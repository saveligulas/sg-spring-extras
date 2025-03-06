package sg.spring.core.persistence.provider.neo4j;

import lombok.Setter;
import org.jspecify.annotations.Nullable;
import org.springframework.data.neo4j.core.schema.RelationshipId;
import sg.spring.core.domain.IObjectInternalExternalIdentifier;

import java.util.UUID;

@Setter
public abstract class RelationshipPropertiesBase implements IObjectInternalExternalIdentifier<UUID, String> {
    private UUID uuid;
    @Nullable
    @RelationshipId
    private String elementId;

    public RelationshipPropertiesBase() {
    }

    public RelationshipPropertiesBase(UUID uuid) {
        this(uuid, null);
    }

    public RelationshipPropertiesBase(IObjectInternalExternalIdentifier<UUID, String> identifier) {
        this(identifier.getIdentifier(), identifier.getExternalIdentifier());
    }

    public RelationshipPropertiesBase(UUID uuid, @Nullable String elementId) {
        this.uuid = uuid;
        this.elementId = elementId;
    }



    @Override
    public @Nullable String getExternalIdentifier() {
        return elementId;
    }

    @Override
    public @Nullable UUID getIdentifier() {
        return uuid;
    }
}
