package sg.spring.core.auth;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;

/**
 * IJwtAuthenticationProvider defines a contract for components responsible for handling JWT (JSON Web Token)
 * authentication in a web application.
 *
 * <p>Implementing classes are expected to provide functionality for decoding JWT tokens, extracting
 * authentication details from HTTP requests, and retrieving specific claims such as the issuer or email.</p>
 *
 * <p>This interface is typically used in applications that rely on JWT-based authentication to validate
 * and authorize users.</p>
 *
 * <p>Example implementation:
 * <pre>
 * {@code
 * public class MyJwtAuthenticationProvider implements IJwtAuthenticationProvider {
 *     private final JwtDecoder jwtDecoder;
 *
 *     public MyJwtAuthenticationProvider(JwtDecoder jwtDecoder) {
 *         this.jwtDecoder = jwtDecoder;
 *     }
 *
 *     @Override
 *     public JwtDecoder getJwtDecoder() {
 *         return jwtDecoder;
 *     }
 *
 *     @Override
 *     public String getIssuer() {
 *         return "https://example.com";
 *     }
 *
 *     @Override
 *     public Jwt extractDecodedToken(HttpServletRequest request) {
 *         String token = request.getHeader("Authorization").substring(7);
 *         return jwtDecoder.decode(token);
 *     }
 *
 *     @Override
 *     public String getEmail(Jwt jwt) {
 *         return jwt.getClaim("email");
 *     }
 * }
 * }
 * </pre>
 */
public interface IJwtAuthenticationProvider {

    /**
     * Returns the {@link JwtDecoder} used to decode JWT tokens.
     *
     * <p>The decoder is responsible for verifying the token's signature, expiration, and other
     * validation checks.</p>
     *
     * @return The {@link JwtDecoder} instance used for decoding tokens.
     */
    JwtDecoder getJwtDecoder();

    /**
     * Returns the issuer of the JWT tokens.
     *
     * <p>The issuer is typically a URL or identifier that represents the entity issuing the tokens.
     * This value can be used to verify that the token originates from a trusted source.</p>
     *
     * @return A string representing the issuer of the JWT tokens.
     */
    String getIssuer();

    /**
     * Extracts and decodes a JWT token from an HTTP request.
     *
     * <p>This method is responsible for retrieving the token (e.g., from the "Authorization" header),
     * decoding it using the {@link JwtDecoder}, and returning the decoded {@link Jwt} object.</p>
     *
     * @param request The {@link HttpServletRequest} containing the JWT token.
     * @return The decoded {@link Jwt} object.
     */
    Jwt extractDecodedToken(HttpServletRequest request);

    /**
     * Retrieves the email claim from a decoded JWT token.
     *
     * <p>This method extracts the "email" claim from the provided {@link Jwt} object. The claim name
     * may vary depending on the token's structure.</p>
     *
     * @param jwt The decoded {@link Jwt} object.
     * @return The email address extracted from the token, or {@code null} if not present.
     */
    String getEmail(Jwt jwt);

    /**
     * Extracts the token from commonly used Bearer prefix.
     * @param token
     * @return token without Bearer prefix
     */
    default String extractTokenFromBearer(String token) {
        return token.substring(7); // Remove "Bearer " prefix
    }
}

