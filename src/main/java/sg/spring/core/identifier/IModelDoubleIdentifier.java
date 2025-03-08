package sg.spring.core.identifier;

import org.jspecify.annotations.Nullable;

public interface IModelDoubleIdentifier<IID, EID> extends IModelIdentifier<IID> {
    @Nullable
    EID getExternalIdentifier();
    boolean externalIsDomainGenerated();
}
