package sg.spring.core.domain.exception;

//TODO: handle internal messages for error handling and external messages for the user
public class DomainRuleValidationException extends RuntimeException{
    public DomainRuleValidationException(String message) {
        super(message);
    }




}
