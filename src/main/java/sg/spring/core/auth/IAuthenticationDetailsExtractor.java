package sg.spring.core.auth;

import java.util.List;

/**
 * IAuthenticationDetailsExtractor defines a contract for extracting authentication details
 * from a security context, token, or other authentication mechanisms.
 *
 * <p>Implementing classes are expected to provide methods for retrieving key user-related
 * information such as a unique identifier (ID), name, and permissions. These details are
 * typically extracted from a decoded JWT token or another authentication source.</p>
 *
 * <p>This interface allows you to abstract the user handling from your authentication provider/process.</p>
 *
 * <p>Example implementation:
 * <pre>
 * {@code
 * public class JwtAuthenticationDetailsExtractor implements IAuthenticationDetailsExtractor {
 *
 *     private final Jwt jwt;
 *
 *     public JwtAuthenticationDetailsExtractor(Jwt jwt) {
 *         this.jwt = jwt;
 *     }
 *
 *     @Override
 *     public String getId() {
 *         return jwt.getClaim("sub"); // Retrieves the "subject" claim as the user ID
 *     }
 *
 *     @Override
 *     public String getName() {
 *         return jwt.getClaim("name"); // Retrieves the "name" claim from the token
 *     }
 *
 *     @Override
 *     public List<String> getPermissions() {
 *         return jwt.getClaim("permissions"); // Retrieves the "permissions" claim as a list
 *     }
 * }
 * }
 * </pre>
 */
public interface IAuthenticationDetailsExtractor {

    /**
     * Retrieves the unique identifier (ID) of the authenticated user.
     *
     * <p>This method typically extracts the "sub" (subject) claim from a JWT token or another
     * equivalent field that uniquely identifies the user in the system.</p>
     *
     * @return A string representing the unique identifier of the user.
     */
    String getId();

    /**
     * Retrieves the name of the authenticated user.
     *
     * <p>This method typically extracts the "name" claim or an equivalent field that represents
     * the user's full name or display name.</p>
     *
     * @return A string representing the name of the user.
     */
    String getName();

    /**
     * Retrieves the list of permissions assigned to the authenticated user.
     *
     * <p>This method typically extracts a "permissions" claim or an equivalent field that contains
     * a list of permissions or roles associated with the user. These permissions are often used
     * for access control and authorization checks.</p>
     *
     * @return A list of strings representing the permissions assigned to the user.
     */
    List<String> getPermissions();
}


