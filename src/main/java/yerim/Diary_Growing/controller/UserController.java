package yerim.Diary_Growing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yerim.Diary_Growing.domain.user.User;
import yerim.Diary_Growing.repository.UserRepository;
import yerim.Diary_Growing.repository.UserSaveRequestDto;
import yerim.Diary_Growing.service.UserService;

@Controller
@RequestMapping("/user")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    @Autowired
    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    //회원가입 페이지
    @GetMapping("/join")
    public String Join(){
        return "user/join";
    }

    //회원가입 처리
    @PostMapping("/joinin")
    @ResponseBody
    public ResponseEntity<String> Join(@RequestBody UserSaveRequestDto userSaveRequestDto){
        String newUserId = userService.Join(userSaveRequestDto);
        return ResponseEntity.ok(newUserId);
    }

}
