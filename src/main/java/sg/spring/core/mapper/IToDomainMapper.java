package sg.spring.core.mapper;

import org.jspecify.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public interface IToDomainMapper<D, E> {
    @Nullable D toDomain(@Nullable E entity);

    default Set<D> toDomainSet(@Nullable Set<E> entities) {
        if (entities == null) {
            return new HashSet<>();
        }

        return entities.stream()
                .map(this::toDomain)
                .collect(Collectors.toSet());
    }

    default List<D> toDomainList(@Nullable List<E> entities) {
        if (entities == null) {
            return new ArrayList<>();
        }

        return entities.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }
}
