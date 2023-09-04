package kr.co.chunjae.gochowoo.controller.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/login")
    public String showLoginPage(@RequestParam(required = false) String callback, Model model) {
        if (callback != null && !callback.isEmpty()) {
            model.addAttribute("callback",callback);
        }
        return "views/user/login";
    }

    @GetMapping("/join")
    public String showJoinPage() { return "views/user/join"; }

}
