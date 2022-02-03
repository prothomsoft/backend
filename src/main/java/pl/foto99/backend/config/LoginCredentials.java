package pl.foto99.backend.config;
import lombok.Getter;

@Getter
public class LoginCredentials {
    private final String username;
    private final String password;

    public LoginCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
