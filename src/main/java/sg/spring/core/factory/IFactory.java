package sg.spring.core.factory;

import org.springframework.core.ParameterizedTypeReference;

public interface IFactory<T extends IFactoryIdentifier> {
    /**
     * Safer to use this than without explicitly specifying the id, if you have Multi-purpose Persistence port classes
     * @param identifier
     * @param instance
     * @param typeRef
     * @param <R>
     */
    <R extends T> void register(String identifier, R instance, ParameterizedTypeReference<R> typeRef);
    <R extends T> void register(R instance, ParameterizedTypeReference<R> typeRef);
    <R extends T> R getInstance(String identifier, ParameterizedTypeReference<R> instanceClass);
}

