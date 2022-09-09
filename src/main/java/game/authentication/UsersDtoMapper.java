package game.authentication;

public class UsersDtoMapper {
        static UserDto map(User user) {
            Long id = user.getId();
            String username = user.getUsername();
            String password = user.getPassword();
            String role = user.getRole();
            return new UserDto(username, password, role);
        }
    }

