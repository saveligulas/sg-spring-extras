package sg.spring.core.persistence.provider.neo4j;

import lombok.Setter;
import org.jspecify.annotations.Nullable;
import org.springframework.data.neo4j.core.schema.RelationshipId;
import sg.spring.core.identifier.IModelDoubleIdentifier;
import sg.spring.core.identifier.IVersioned;

import java.util.UUID;

@Setter
public abstract class RelationshipPropertiesBase implements IModelDoubleIdentifier<UUID, String> {
    private UUID uuid;
    @Nullable
    @RelationshipId
    private String elementId;
    //TODO: remove and outsource
    //private Long version;

    public RelationshipPropertiesBase() {
    }

    public RelationshipPropertiesBase(UUID uuid) {
        this(uuid, null);
    }

    public <T extends IModelDoubleIdentifier<UUID, String> & IVersioned> RelationshipPropertiesBase(T identifier) {
        this(identifier.getIdentifier(), identifier.getExternalIdentifier());
    }

    public RelationshipPropertiesBase(IModelDoubleIdentifier<UUID, String> identifier, boolean constructorHelper) {
        this(identifier.getIdentifier(), identifier.getExternalIdentifier());
    }


    public RelationshipPropertiesBase(UUID uuid, @Nullable String elementId) {
        this.uuid = uuid;
        this.elementId = elementId;
    }

    @Override
    public boolean isGeneratedManually() {
        return false;
    }

    @Override
    public boolean externalIsDomainGenerated() {
        return true;
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
