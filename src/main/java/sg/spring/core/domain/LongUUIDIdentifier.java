package sg.spring.core.domain;

import lombok.Setter;
import org.jspecify.annotations.Nullable;
import sg.spring.core.identifier.IModelDoubleIdentifier;

import java.util.UUID;

@Setter
public abstract class LongUUIDIdentifier extends InternalExternalIdentifier<Long, UUID> {
    public LongUUIDIdentifier(IModelDoubleIdentifier<Long, UUID> internalExternalIdentifier) {
        super(internalExternalIdentifier);
    }

    public LongUUIDIdentifier(@Nullable Long aLong, @Nullable UUID uuid) {
        super(aLong, uuid);
    }
}
