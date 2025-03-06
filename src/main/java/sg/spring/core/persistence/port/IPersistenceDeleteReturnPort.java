package sg.spring.core.persistence.port;

import org.dfa.core.persistence.IPortMarker;

public interface IPersistenceDeleteReturnPort<D, ID> extends IPortMarker {
    D delete(ID id);
}
