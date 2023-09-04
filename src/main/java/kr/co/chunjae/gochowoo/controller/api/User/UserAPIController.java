package kr.co.chunjae.gochowoo.controller.api.User;

import kr.co.chunjae.gochowoo.model.User.User;
import kr.co.chunjae.gochowoo.service.User.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;


@Controller
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserAPIController {
    final UserService userService;

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
    public String login(Model model, @RequestParam String email, @RequestParam String password, @RequestParam String callback,HttpServletRequest request) {
        User user = userService.login(email, password);


        if (user == null) {
            return "redirect:/user/login?error=true";
        }
        HttpSession session = request.getSession();
        session.setAttribute("id", user.getId());
        session.setAttribute("email", email);
        session.setAttribute("nickName", user.getNickName());
        session.setAttribute("cash", user.getCash());
        session.setAttribute("user", user);
        if (callback == null || callback.isEmpty()) {
            return "redirect:/";
        }
        return "redirect:"+callback;
    }

    @PostMapping("/logout")
    public String logout(HttpSession session, Model model) {
        session.invalidate(); // 세션 무효화
        model.addAttribute("logoutSuccess", true);
        return "redirect:/user/login";
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
            return "/views/mypage/modify/modifyProfile"; // modifyProfile.html 템플릿을 렌더링
        } else {
            // 사용자 정보가 없을 경우 에러 처리
            return "redirect:/user/login";
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

    @PostMapping("/cash/charge")
    public ResponseEntity<Void> addUserCash(@RequestBody Map<String, String> requestBody, HttpSession session) {
        String email = (String) session.getAttribute("email");

        if (email != null) {
            userService.updateCashByEmail(email, Integer.parseInt(requestBody.get("coin")));
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("/changeTeam")
    public ResponseEntity<Void> changeTeam(@RequestBody Map<String, String> requestBody, HttpSession session) {
        String email = (String) session.getAttribute("email");
        String teamName = requestBody.get("teamName");
        if (email == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        userService.changeTeam(email, teamName);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/check/email")
    public ResponseEntity<Void> isUniqueEmail(@RequestParam String email) {
        boolean isUnique = userService.isUniqueEmail(email);
        if (!isUnique) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/check/nickName")
    public ResponseEntity<Void> isUniqueNickName(@RequestParam String nickName) {
        boolean isUnique = userService.isUniqueNickName(nickName);
        if (!isUnique) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping("/withdraw")
    public String withdraw(@RequestParam String email, @RequestParam String password, HttpServletRequest request
    ) {
        boolean ok = userService.withdrawUser(email, password);
        if (ok) {
            request.getSession().invalidate();
            return "redirect:/user/login";
        }
        return "redirect:/mypage";
    }
}
