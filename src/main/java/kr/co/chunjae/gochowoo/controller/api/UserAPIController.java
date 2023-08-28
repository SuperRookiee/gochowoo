package kr.co.chunjae.gochowoo.controller.api;

import kr.co.chunjae.gochowoo.model.User;
import kr.co.chunjae.gochowoo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/user")
public class UserAPIController {

    final UserService userService;

    public UserAPIController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/join")
    public String join(@RequestParam String email, @RequestParam String password, @RequestParam String nickName) {
        User join = userService.joinUser(User.builder()
                .email(email)
                .password(password)
                .nickName(nickName)
                .build());
        if (join == null) return "redirect:/user/join";
        return "redirect:/user/login";
    }

    @PostMapping("/login")
    public String login(Model model, @RequestParam String email, @RequestParam String password) {
        User user = userService.login(email, password);
        if (user == null) {
            return "redirect:/user/login?error=true";
        }
        model.addAttribute("user", user);
        return "redirect:/";
    }

}
