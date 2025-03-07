package sg.spring.core.identifier;

import org.jspecify.annotations.Nullable;

public interface IModelIdentifier<T> {
    @Nullable
    T getIdentifier();
    boolean isDomainGenerated();

    /**
     * Checks if the object is persisted. If the identifier is domain generated then this will always return true.
     * @return true if the object is persisted.
     */
    default boolean isPersisted() {
        if (isDomainGenerated()) {
            return true;
        }
        return getIdentifier() != null;
    }

    /**
     * Verifies that the version is valid(non-negative).
     * @param version to verify
     * @throws IllegalArgumentException if the version is negative
     */
    default void verifyVersion(Long version) {
        if (version < 0L) {
            throw new IllegalArgumentException("Version must be non negative");
        }
    }
}
