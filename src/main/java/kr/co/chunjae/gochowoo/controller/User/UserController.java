package kr.co.chunjae.gochowoo.controller.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/login")
    public String showLoginPage() {return "views/user/login";}

    @GetMapping("/join")
    public String showJoinPage() { return "views/user/join"; }

}