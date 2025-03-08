package sg.spring.core.persistence.provider.neo4j;

import lombok.Setter;
import org.jspecify.annotations.Nullable;
import org.springframework.data.neo4j.core.schema.RelationshipId;
import sg.spring.core.identifier.IModelDoubleIdentifier;
import sg.spring.core.identifier.IVersioned;

import java.util.UUID;

@Setter
public abstract class RelationshipPropertiesBase implements IModelDoubleIdentifier<UUID, String>, IVersioned {
    private UUID uuid;
    @Nullable
    @RelationshipId
    private String elementId;
    private Long version;

    public RelationshipPropertiesBase() {
    }

    public RelationshipPropertiesBase(UUID uuid) {
        this(uuid, null, 0L);
    }

    public <T extends IModelDoubleIdentifier<UUID, String> & IVersioned> RelationshipPropertiesBase(T identifier) {
        this(identifier.getIdentifier(), identifier.getExternalIdentifier(), identifier.getVersion());
    }

    public RelationshipPropertiesBase(IModelDoubleIdentifier<UUID, String> identifier, boolean constructorHelper) {
        this(identifier.getIdentifier(), identifier.getExternalIdentifier(), 0L);
    }


    public RelationshipPropertiesBase(UUID uuid, @Nullable String elementId, Long version) {
        this.uuid = uuid;
        this.elementId = elementId;
        this.version = version;
    }

    @Override
    public Long getVersion() {
        return version;
    }


    @Override
    @Nullable
    public String getExternalIdentifier() {
        return elementId;
    }

    @Override
    @Nullable
    public UUID getIdentifier() {
        return uuid;
    }
}
