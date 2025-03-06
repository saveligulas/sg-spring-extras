package sg.spring.core.persistence.port;

import org.dfa.core.persistence.IPortMarker;

public interface IPersistenceDeletePort<D, ID> extends IPortMarker {
    void delete(ID id);
}
