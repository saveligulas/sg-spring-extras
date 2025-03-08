package sg.spring.core.auth;

public interface IAuthenticationClaimsExtractor {
    String extractClaim(String claim);
}
