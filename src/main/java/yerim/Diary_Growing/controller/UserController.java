package yerim.Diary_Growing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yerim.Diary_Growing.domain.User;
import yerim.Diary_Growing.repository.UserRepository;
import yerim.Diary_Growing.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    @Autowired
    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }


    @PostMapping("/join")
    @ResponseBody
    public User Join(@RequestBody User user){
//        User joinUser =
        return user;
    }


}
