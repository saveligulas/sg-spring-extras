package sg.spring.core.persistence.port;

import org.dfa.core.persistence.IPortMarker;
import org.jspecify.annotations.Nullable;
import org.springframework.dao.EmptyResultDataAccessException;

public interface IPersistenceFindPort<D, ID> extends IPortMarker {
    D find(ID id);

    default void checkIfNull(@Nullable String name, Object o, ID id) {
        if (o == null) {
            throw new EmptyResultDataAccessException(name == null ? "Unspecified Entity" : name + " not found with id: " + id , 1);
        }
    }
}
