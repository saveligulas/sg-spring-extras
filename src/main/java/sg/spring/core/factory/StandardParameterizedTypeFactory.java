package sg.spring.core.factory;

import org.jspecify.annotations.NullMarked;
import org.springframework.core.ParameterizedTypeReference;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@NullMarked
public class StandardParameterizedTypeFactory<T extends IParameterizedTypeFactoryIdentifier> implements IParameterizedTypeFactory<T> {
    private final Map<Type, T> instanceMap = new ConcurrentHashMap<>();

    @Override
    public <R extends T> void register(R instance) {
        for (ParameterizedTypeReference<?> typeReference : instance.getImplementedTypes()) {
            Type type = typeReference.getType();
            if (extractClass(type).isInstance(instance)) {
                instanceMap.put(type, instance);
            } else {
                throw new IllegalArgumentException(
                        "Instance does not implement claimed type: " + type.getTypeName()
                );
            }
        }
    }

    @Override
    public <R extends T> void register(R instance, ParameterizedTypeReference<R> typeRef) {
        instanceMap.put(typeRef.getType(), instance);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <R extends T> R getInstance(ParameterizedTypeReference<R> typeReference) {
        T instance = instanceMap.get(typeReference.getType());
        if (instance == null) {
            throw new IllegalStateException(
                    "No instance registered for type: " + typeReference.getType().getTypeName()
            );
        }

        try {
            return (R) instance;
        } catch (ClassCastException e) {
            throw new IllegalStateException(
                    "Registered instance type does not match requested type: " +
                            typeReference.getType().getTypeName(), e
            );
        }
    }

    private Class<?> extractClass(Type type) {
        if (type instanceof Class<?>) {
            return (Class<?>) type;
        } else if (type instanceof ParameterizedType) {
            return (Class<?>) ((ParameterizedType) type).getRawType();
        } else {
            throw new IllegalArgumentException("Unsupported type: " + type);
        }
    }
}
