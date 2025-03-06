package sg.spring.core.persistence.port;

import org.dfa.core.persistence.IPortMarker;

import java.util.Optional;

public interface IPersistenceOptionalFindPort<D, ID> extends IPortMarker {
    Optional<D> findOpt(ID id);
}
