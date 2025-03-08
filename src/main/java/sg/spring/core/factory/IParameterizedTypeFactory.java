package sg.spring.core.factory;

import org.springframework.core.ParameterizedTypeReference;

public interface IParameterizedTypeFactory<T extends IParameterizedTypeFactoryIdentifier> {
    <R extends T> void register(R instance);
    <R extends T> void register(R instance, ParameterizedTypeReference<R> typeRef);
    <R extends T> R getInstance(ParameterizedTypeReference<R> typeReference);
}
