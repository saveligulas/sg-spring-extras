package sg.spring.core.domain.exception;

public interface IDomainRuleViolation {
    String getViolationMessage();
    int getMessageIdentifier();
}
