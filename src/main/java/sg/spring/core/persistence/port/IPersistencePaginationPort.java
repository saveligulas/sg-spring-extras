package sg.spring.core.persistence.port;

import org.dfa.core.persistence.IPortMarker;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

public interface IPersistencePaginationPort<D> extends IPortMarker {
    Page<D> findAll(int page, int size);
    Page<D> findAll(int page, int size, Sort sort);
}
