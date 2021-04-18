package pl.foto99.admin.dto;
import pl.foto99.admin.model.User;

public class UserDtoMapper {
    private UserDtoMapper() {
    }

    public static User mapToUser(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setRoles(userDto.getRoles());
        user.setEnabled(userDto.isEnabled());
        return user;
    }
}
