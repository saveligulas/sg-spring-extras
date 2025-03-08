package sg.spring.core.factory.exception;

public class FactoryInstanceRetrievalException extends ClassCastException {
    public FactoryInstanceRetrievalException(String message) {
        super(message);
    }
}
