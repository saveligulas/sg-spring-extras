package sg.spring.core.domain;

import org.jspecify.annotations.Nullable;

public interface IObjectIdentifier<T> {
    @Nullable T getIdentifier();
    Long getVersion();
    boolean isDomainGenerated();
    default boolean isPersisted() {
        if (isDomainGenerated()) {
            return getVersion() > 0L;
        }
        if (getIdentifier() == null) {
            return false;
        }
        return getVersion() > 0;
    }
}
