package sg.spring.core.persistence.provider.neo4j;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Getter;
import lombok.Setter;
import org.jspecify.annotations.Nullable;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import sg.spring.core.identifier.IModelIdentifier;

@Setter
@Getter
public class Neo4jSerialIdentifier implements IModelIdentifier<Long> {
    @Id
    @GeneratedValue
    @Nullable
    private Long id;

    public Neo4jSerialIdentifier() {

    }

    public Neo4jSerialIdentifier(Long id) {
        this.id = id;
    }

    @Override
    public @Nullable Long getIdentifier() {
        return 0L;
    }

    @Override
    public boolean isGeneratedManually() {
        return false;
    }

    @Override
    public boolean isPersisted() {
        return IModelIdentifier.super.isPersisted();
    }
}
