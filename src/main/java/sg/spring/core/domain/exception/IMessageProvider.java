package sg.spring.core.domain.exception;

/**
 * Resolves Message identifiers and gives you the responding message. Should be used in monolithic applications where
 * the frontend is directly accessible through the Spring Boot application.
 */
public interface IMessageProvider {
    /**
     * Retrieves the message associated with the given identifier.
     *
     * @param identifier The message identifier.
     * @return The message.
     * @throws java.lang.IllegalArgumentException if the identifier is not valid
     */
    String getMessage(int identifier);
}
