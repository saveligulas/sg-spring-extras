package sg.spring.core.factory;

import org.springframework.core.ParameterizedTypeReference;

public interface IFactoryIdentifierRegistry<T extends IFactoryIdentifier> {
    String getIdentifier();
    ParameterizedTypeReference<T> getTypeReference();
}

