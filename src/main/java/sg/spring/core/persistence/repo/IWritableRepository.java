package sg.spring.core.persistence.repo;

import org.dfa.core.persistence.port.IPersistenceSaveAllPort;
import org.dfa.core.persistence.port.IPersistenceSavePort;

public interface IWritableRepository<D> extends IPersistenceSavePort<D>, IPersistenceSaveAllPort<D> {
}
