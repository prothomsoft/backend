package pl.foto99.backend.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDto {
    private String username;
    private String password;
    private String roles;
    private boolean enabled;
}
