package sg.spring.core.domain;

import org.jspecify.annotations.Nullable;
import sg.spring.core.identifier.IModelDoubleIdentifier;

import java.util.Objects;

public abstract class InternalExternalIdentifier<IID, EID> extends DomainModelIdentifierBase<IID> implements IModelDoubleIdentifier<IID, EID> {
    @Nullable
    protected EID eid;


    public InternalExternalIdentifier(IModelDoubleIdentifier<IID, EID> internalExternalIdentifier) {
        this(internalExternalIdentifier.getIdentifier(), internalExternalIdentifier.getExternalIdentifier());
    }

    public InternalExternalIdentifier(@Nullable IID iid, @Nullable EID eid) {
        super(iid);
        this.eid = eid;
    }


    @Override
    @Nullable
    public EID getExternalIdentifier() {
        return this.eid;
    }

    @Override
    public boolean isDomainGenerated() {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof InternalExternalIdentifier<?, ?> that)) return false;
        return Objects.equals(this.getIdentifier(), that.getIdentifier()) || Objects.equals(this.getExternalIdentifier(), that.getExternalIdentifier());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), eid);
    }
}
