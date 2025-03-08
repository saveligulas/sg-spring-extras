package sg.spring.core.factory;

public interface IFactoryRegistryWrapper<T extends IFactoryIdentifier> extends IFactory<T> {
    <R extends T> void register(R instance, IFactoryIdentifierRegistry<R> registry);
    <R extends T> R getInstance(IFactoryIdentifierRegistry<R> registry);
}
