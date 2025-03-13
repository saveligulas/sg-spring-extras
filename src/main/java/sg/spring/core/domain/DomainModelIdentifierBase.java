package sg.spring.core.domain;

import lombok.Getter;
import lombok.Setter;
import org.jspecify.annotations.Nullable;
import sg.spring.core.identifier.IModelIdentifier;

import java.util.Objects;

@Getter
@Setter
public abstract class DomainModelIdentifierBase<T> implements IModelIdentifier<T> {
    @Nullable
    protected T identifier;

    public DomainModelIdentifierBase(IModelIdentifier<T> identifier, boolean constructorIdentifier) {
        this(identifier.getIdentifier());
    }

    public DomainModelIdentifierBase() {
        this(null);
    }

    public DomainModelIdentifierBase(@Nullable T identifier) {
        this.identifier = identifier;
    }

    @Override
    public @Nullable T getIdentifier() {
        return this.identifier;
    }

    @Override
    public boolean isPersisted() {
        return IModelIdentifier.super.isPersisted();
    }

    @Override
    public int hashCode() {
        if (identifier == null) {
            return -1;
        } else {
            return identifier.hashCode();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof DomainModelIdentifierBase<?> that)) return false;
        return identifier != null && Objects.equals(identifier, that.identifier);
    }

    @Override
    public String toString() {
        return "Model{" +
                "type=" + this.getClass().getTypeName() +
                "identifier=" + identifier +
                '}';
    }
}
