package sg.spring.core.persistence.repo;

import org.dfa.core.persistence.port.IPersistenceFindAllByIdPort;
import org.dfa.core.persistence.port.IPersistenceFindPort;
import org.dfa.core.persistence.port.IPersistenceOptionalFindPort;
import org.dfa.core.persistence.port.IPersistencePaginationPort;

public interface IReadRepository<D, ID> extends IPersistenceOptionalFindPort<D, ID>, IPersistenceFindPort<D, ID>, IPersistencePaginationPort<D>, IPersistenceFindAllByIdPort<D, ID> {
}
