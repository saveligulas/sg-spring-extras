package sg.spring.core.domain;

public abstract class SerialDomainIdentifier extends DomainModelIdentifierBase<Long> {
    public SerialDomainIdentifier() {
        super();
    }

    public SerialDomainIdentifier(Long identifier) {
        super(identifier);
    }

    @Override
    public boolean isGeneratedManually() {
        return false;
    }
}
