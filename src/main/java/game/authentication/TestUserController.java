package game.authentication;

import game.QuestionDto;
import game.QuestionsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
class TestUserController {
    private UsersService usersService;
    private UserDto userDto;

    public TestUserController(UsersService usersService, UserDto userDto) {
        this.usersService = usersService;
        this.userDto = userDto;
    }
    @RequestMapping("/getusers")
    String getParameter(@RequestParam String id, Model model) {
        Long newId = Long.parseLong(id);
        UserDetails userDetails = usersService.findUserById(newId)
        .map(this::createUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User %s not found", id)));
        model.addAttribute("name", userDetails.getUsername());
        return "testusername";
    }
    private UserDetails createUserDetails(UserDto credentials) {
        return User.builder()
                .username(credentials.getUsername())
                .password(credentials.getPassword())
                .roles(credentials.getRole())
                .build();
    }
}
