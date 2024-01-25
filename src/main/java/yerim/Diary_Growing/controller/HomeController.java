package yerim.Diary_Growing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    public String Index(){
        return "index";
    }

    @GetMapping("/post/write")
    public String PostWrite(){
        return "post/write";
    }

}
