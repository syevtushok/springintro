package spring.intro.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spring.intro.dto.UserResponseDto;
import spring.intro.models.User;
import spring.intro.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String get(@PathVariable Long id) {
        return userService.get(id).toString();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<UserResponseDto> getAll() {
        List<UserResponseDto> usersDto = new ArrayList<>();
        for (User user : userService.listUsers()) {
            UserResponseDto userDto = new UserResponseDto();
            userDto.setLogin(user.getLogin());
            userDto.setPassword(user.getPassword());
            usersDto.add(userDto);
        }
        return usersDto;
    }

    @RequestMapping(value = "/inject", method = RequestMethod.GET)
    public String addUsersToDB() {
        for (int i = 1; i <= 4; i++) {
            userService.add(new User("user" + i, "pass" + i));
        }
        return "Good!";
    }
}
