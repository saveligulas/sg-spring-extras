package sg.spring.core.domain;

import java.util.UUID;

public abstract class UUIDDomainIdentifier extends DomainModelIdentifierBase<UUID> {
    public UUIDDomainIdentifier() {
        this(UUID.randomUUID());
    }

    public UUIDDomainIdentifier(UUID identifier) {
        super(identifier);
    }

    @Override
    public boolean isDomainGenerated() {
        return true;
    }
}
