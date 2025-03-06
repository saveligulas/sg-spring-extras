package sg.spring.core.persistence.port;

public interface IPersistenceSavePort<D>{
    void save(D d);
}
