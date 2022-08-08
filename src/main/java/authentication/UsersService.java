package authentication;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository userRepository) {
        this.usersRepository = userRepository;
    }

    public Optional<UserDto> findUserByUsername(String userName) {
        User user = usersRepository.findUserByUsername(userName);
        return Optional.of(UsersDtoMapper.map(user));
    }
}