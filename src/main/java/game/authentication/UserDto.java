package game.authentication;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private  Long id;
    private String username;
    private String password;
    private String role;
}