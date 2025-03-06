package sg.spring.core.mapper;

public interface IComponentDomainMapper<D, E> {
    void enrichDomain(D domain, E entity);
}
