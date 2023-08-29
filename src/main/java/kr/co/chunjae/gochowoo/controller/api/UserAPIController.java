package kr.co.chunjae.gochowoo.controller.api;

import kr.co.chunjae.gochowoo.model.User;
import kr.co.chunjae.gochowoo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        session.setAttribute("cash", user.getCash());

        return "/index";
    }

    @PostMapping("/logout")
    public String logout(HttpSession session, Model model) {
        if (session.getAttribute("email") == null) {
            // 세션에 유저 정보가 없는 경우 에러 메시지 추가
            model.addAttribute("errorMessage", "세션에 저장된 데이터가 없습니다.");
            return "redirect:/mypage"; // 에러 페이지로 리다이렉트 또는 포워드
        }
        session.invalidate(); // 세션 무효화
        model.addAttribute("logoutSuccess", true);
        return "redirect:/mypage";
    }

    @GetMapping ("/profile")
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
    @PostMapping("/cash")
    public String cash(){

        return "/index";
    }

    @PostMapping("/chargeCash")
    public String chargeCash(@RequestParam String email, @RequestParam Long cash, HttpServletRequest request) {
        User user = userService.userInfo(email);

        if(user != null){
            HttpSession session = request.getSession();
            user.setCash(cash);
            session.setAttribute("cash", user.getCash());
            userService.updateUser(user);
            return "redirect:/mypage";
        }else {
            return "/index";
        }
    }

    /*public String withdrawUser(@RequestParam String email, @RequestParam String password) {

        UserRepository userRepository;
        User userToWithdraw = UserRepository.findById(email);
    }*/

}
