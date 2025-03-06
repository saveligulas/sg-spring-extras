package sg.spring.core.persistence.repo;

import org.dfa.core.persistence.port.IPersistenceDeletePort;

public interface IBaseRepository<D, ID> extends IReadRepository<D, ID>, IWritableRepository<D>, IPersistenceDeletePort<D, ID> {
}
