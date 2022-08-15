package config;

import authentication.UserDto;
import authentication.UsersService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
class CustomUserDetailsManager implements UserDetailsService {
    private final UsersService usersService;

    public CustomUserDetailsManager(UsersService usersService) {
        this.usersService = usersService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usersService.findUserByUsername(username)
                .map(this::createUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User %s not found", username)));
    }

    private UserDetails createUserDetails(UserDto credentials) {
        return User.builder()
                .username(credentials.getUsername())
                .password(credentials.getPassword())
                .roles(credentials.getRole())
                .build();
    }
}