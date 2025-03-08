package sg.spring.core.auth;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * JwtRequiredPermissionFilter is an abstract class that extends OncePerRequestFilter to enforce
 * permission-based access control in a web application. This filter ensures that incoming requests
 * contain the required permissions before allowing further processing.
 *
 * <p>This class uses an {@link IAuthenticationDetailsExtractor} to extract permissions from the
 * authentication details of the request. If the required permissions are not present, the filter
 * responds with an HTTP 401 Unauthorized status and halts further processing.</p>
 *
 * <p>Make sure that the SecurityContext is set or set it before calling the doFilter() method of this class.</p>
 *
 * <p>To use this filter, extend it and configure the required permissions by calling
 * {@link #setRequiredPermissions(String...)} during initialization.</p>
 *
 * <p>Example usage:
 * <pre>
 * {@code
 * public class MyPermissionFilter extends JwtRequiredPermissionFilter {
 *     public MyPermissionFilter(IAuthenticationDetailsExtractor extractor) {
 *         super(extractor);
 *         setRequiredPermissions("PERMISSION_1", "PERMISSION_2");
 *     }
 * }
 * }
 * </pre>
 */
public abstract class JwtRequiredPermissionFilter extends OncePerRequestFilter {

    /**
     * A list of permissions that are required for the request to be processed.
     */
    private List<String> requiredPermissions = new ArrayList<>();

    /**
     * The {@link IAuthenticationDetailsExtractor} used to extract permissions from the authentication details.
     */
    private final IAuthenticationDetailsExtractor authenticationDetailsExtractor;

    /**
     * Constructs a new JwtRequiredPermissionFilter with the specified {@link IAuthenticationDetailsExtractor}.
     *
     * @param authenticationDetailsExtractor an implementation of {@link IAuthenticationDetailsExtractor}
     *                                        used to extract permissions from the authentication context.
     */
    public JwtRequiredPermissionFilter(IAuthenticationDetailsExtractor authenticationDetailsExtractor) {
        this.authenticationDetailsExtractor = authenticationDetailsExtractor;
    }

    /**
     * Sets the permissions required for this filter to allow requests to proceed.
     *
     * @param permissions a varargs array of permission strings that are required.
     */
    protected void setRequiredPermissions(String... permissions) {
        this.requiredPermissions = Arrays.asList(permissions);
    }

    /**
     * Checks if the current request has all of the required permissions.
     *
     * <p>This method uses the {@link IAuthenticationDetailsExtractor} to retrieve the list of
     * permissions associated with the current request. If any of the required permissions are
     * missing, it sets the HTTP response status to 401 (Unauthorized) and returns false.</p>
     *
     * @param response the {@link HttpServletResponse} object used to send an error status if necessary.
     * @return true if all required permissions are present, false otherwise.
     */
    protected boolean hasRequiredPermissions(HttpServletResponse response) {
        // Extract permissions from the authentication details
        List<String> permissions = authenticationDetailsExtractor.getPermissions();

        // Check if all required permissions are present
        if (!new HashSet<>(permissions).containsAll(requiredPermissions)) {
            // Set HTTP status to 401 Unauthorized if any required permission is missing
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }

        // All required permissions are present
        return true;
    }

    /**
     * Filters incoming requests based on their permissions.
     *
     * <p>This method is invoked for every HTTP request. It checks if the request has all of
     * the required permissions by calling {@link #hasRequiredPermissions(HttpServletResponse)}.
     * If the request has the necessary permissions, it allows further processing by invoking
     * {@link FilterChain#doFilter(ServletRequest, ServletResponse)}.
     * Otherwise, it halts processing.</p>
     *
     * <p>SecurityContext has to be set for this method to resolve correctly.</p>
     *
     * @param request  the {@link HttpServletRequest} object containing client request information.
     * @param response the {@link HttpServletResponse} object for sending a response back to the client.
     * @param filterChain the {@link FilterChain} object for invoking subsequent filters in the chain.
     *
     * @throws ServletException if an error occurs during filtering.
     * @throws IOException      if an input or output error occurs while processing the request or response.
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // Check for required permissions and proceed with filtering if valid
        if (hasRequiredPermissions(response)) {
            filterChain.doFilter(request, response);
        }
    }
}

