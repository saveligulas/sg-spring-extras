package sg.spring.core.factory;

import org.dfa.core.factory.exception.FactoryInstanceRetrievalException;
import org.springframework.core.ParameterizedTypeReference;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class GenericTypeFactory<T extends IFactoryIdentifier> implements IFactory<T> {
    private final Map<String, TypedInstance<T>> instanceMap = new ConcurrentHashMap<>();

    private record TypedInstance<T>(T instance, Type type) {
    }

    @Override
    public <R extends T> void register(String identifier, R instance, ParameterizedTypeReference<R> typeRef) {
        Objects.requireNonNull(identifier, "Identifier cannot be null");
        Objects.requireNonNull(instance, "Instance cannot be null");
        Objects.requireNonNull(typeRef, "Type reference cannot be null");

        instanceMap.put(identifier, new TypedInstance<>(instance, typeRef.getType()));
    }

    @Override
    public <R extends T> void register(R instance, ParameterizedTypeReference<R> typeRef) {
        this.register(instance.getId(), instance, typeRef);
    }

    @SuppressWarnings("unchecked") //Safe here because type is explicitly checked but IDE will still show error
    @Override
    public <R extends T> R getInstance(String id, ParameterizedTypeReference<R> typeRef) {
        Objects.requireNonNull(id, "ID cannot be null");
        Objects.requireNonNull(typeRef, "Type reference cannot be null");

        TypedInstance<T> typedInstance = instanceMap.get(id);
        if (typedInstance == null) {
            throw new IllegalArgumentException("No instance found for id: " + id);
        }

        Type expectedType = typeRef.getType();
        Type actualType = typedInstance.type;

        if (!isTypeCompatible(expectedType, actualType)) {
            throw new FactoryInstanceRetrievalException(
                    String.format("Instance of type %s cannot be cast to %s",
                            actualType.getTypeName(),
                            expectedType.getTypeName())
            );
        }

        return (R) typedInstance.instance;
    }

    private boolean isTypeCompatible(Type expected, Type actual) {
        if (!(expected instanceof ParameterizedType expectedPType) || !(actual instanceof ParameterizedType actualPType)) {
            return getRawType(expected).isAssignableFrom(getRawType(actual));
        }

        if (!getRawType(expectedPType).isAssignableFrom(getRawType(actualPType))) {
            return false;
        }

        Type[] expectedArgs = expectedPType.getActualTypeArguments();
        Type[] actualArgs = actualPType.getActualTypeArguments();

        if (expectedArgs.length != actualArgs.length) {
            return false;
        }

        // Recursively check type arguments
        for (int i = 0; i < expectedArgs.length; i++) {
            if (!isTypeCompatible(expectedArgs[i], actualArgs[i])) {
                return false;
            }
        }

        return true;
    }

    private Class<?> getRawType(Type type) {
        if (type instanceof Class<?>) {
            return (Class<?>) type;
        }
        if (type instanceof ParameterizedType) {
            return (Class<?>) ((ParameterizedType) type).getRawType();
        }
        throw new IllegalArgumentException("Unexpected type kind: " + type.getClass());
    }
}
