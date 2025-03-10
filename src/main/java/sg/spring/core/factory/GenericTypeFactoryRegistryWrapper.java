package sg.spring.core.factory;


import sg.spring.core.factory.exception.FactoryRegistrationException;

public class GenericTypeFactoryRegistryWrapper<T extends IFactoryIdentifier> {

    private IFactory<T> factory;

    public GenericTypeFactoryRegistryWrapper(IFactory<T> factory) {
        this.factory = factory;
    }

    public <R extends T> void register(R instance, IFactoryIdentifierRegistry<R> factoryIdentifierRegistry) {
        if (!instance.getId().equals(factoryIdentifierRegistry.getIdentifier())) {
            throw new FactoryRegistrationException("Identifiers are not equal: " + instance.getId() + " != " + factoryIdentifierRegistry.getIdentifier());        }
        factory.register(instance, factoryIdentifierRegistry.getTypeReference());
    }

    public <R extends T> R getInstance(IFactoryIdentifierRegistry<R> factoryIdentifierRegistry) {
        return factory.getInstance(factoryIdentifierRegistry.getIdentifier(), factoryIdentifierRegistry.getTypeReference());
    }
}
