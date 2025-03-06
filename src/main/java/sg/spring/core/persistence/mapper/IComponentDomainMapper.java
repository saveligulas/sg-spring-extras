package sg.spring.core.persistence.mapper;

public interface IComponentDomainMapper<D, E> {
    void enrichDomain(D domain, E entity);
}
