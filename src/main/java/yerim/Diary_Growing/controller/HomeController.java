package yerim.Diary_Growing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    @ResponseBody
    public String Index(){
        return "home";
    }

    @GetMapping("/login")
    @ResponseBody
    public String Join(){
        return "join";
    }


}