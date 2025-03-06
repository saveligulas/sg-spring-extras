package sg.spring.core.persistence.port;

import org.dfa.core.persistence.IPortMarker;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface IPersistenceFindAllByIdPort<D, ID> extends IPortMarker {
    List<D> findAll(Collection<ID> ids);
    Set<D> findAllSet(Collection<ID> ids);
}
