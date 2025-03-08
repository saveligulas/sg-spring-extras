package sg.spring.core.factory;

public class StandardIdentifier implements IFactoryIdentifier {
    private final String identifier;

    public StandardIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String getId() {
        return this.identifier;
    }
}
