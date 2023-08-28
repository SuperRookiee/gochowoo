package kr.co.chunjae.gochowoo.controller.api;

import kr.co.chunjae.gochowoo.model.User;
import kr.co.chunjae.gochowoo.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



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
    public String login(Model model, @RequestParam String email, @RequestParam String password, HttpServletRequest request) {
        User user = userService.login(email, password);


        if (user == null) {
            return "redirect:/user/login?error=true";
        }
        HttpSession session = request.getSession();
        session.setAttribute("email", email);
        session.setAttribute("nickName", user.getNickName());

        model.addAttribute("user", user);
        return "/index";
    }
    @GetMapping("/profile")
    public String userProfile(Model model, HttpSession session) {
        String email = (String) session.getAttribute("email");

        if (email == null) {
            // 로그인되지 않은 상태면 로그인 페이지로 리다이렉트
            return "redirect:/user/login";
        }

        User user = userService.userInfo(email);

        if (user != null) {
            model.addAttribute("user", user);
            return "/views/user/userProfile"; // userProfile.html 템플릿을 렌더링
        } else {
            // 사용자 정보가 없을 경우 에러 처리
            return "/index";
        }
    }
    @PostMapping("/updateProfile")
    public String updateProfile(@RequestParam String email, @RequestParam String nickname, HttpServletRequest request) {
        User user = userService.userInfo(email);

        if (user != null) {
            HttpSession session = request.getSession();
            user.setNickName(nickname);
            session.setAttribute("nickName", user.getNickName());
            userService.updateUser(user);
            return "redirect:/mypage";
        } else {
            return "/index";
        }
    }

}
