package sg.spring.core.persistence.provider.neo4j;

import org.jspecify.annotations.Nullable;
import org.springframework.data.neo4j.core.schema.Id;
import sg.spring.core.identifier.IModelIdentifier;

public abstract class Neo4jNodeIdentifier<T> implements IModelIdentifier<T> {
    @Id
    private T id;

    public Neo4jNodeIdentifier(T id) {
        this.id = id;
    }

    @Override
    public @Nullable T getIdentifier() {
        return id;
    }
}
