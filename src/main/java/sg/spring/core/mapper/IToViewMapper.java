package sg.spring.core.mapper;

import org.jspecify.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public interface IToViewMapper<D, T> {
    @Nullable T toView(@Nullable D domain);

    default List<T> toViewList(@Nullable List<D> domains) {
        if (domains == null) {
            return new ArrayList<>();
        }

        return domains.stream()
                .map(this::toView)
                .collect(Collectors.toList());
    }

    default Set<T> toViewSet(@Nullable Set<D> domains) {
        if (domains == null) {
            return new HashSet<>();
        }

        return domains.stream()
                .map(this::toView)
                .collect(Collectors.toSet());
    }
}
