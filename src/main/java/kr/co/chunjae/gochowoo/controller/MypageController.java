package kr.co.chunjae.gochowoo.controller;

import kr.co.chunjae.gochowoo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@AllArgsConstructor
@RequestMapping("/mypage")
public class MypageController {

    final UserService userService;

    @GetMapping()
    public String showShopPage() {
        return "views/mypage/mypage";
    }

    @GetMapping("/cash")
    public String showCashPage() {
        return "views/mypage/cash";
    }
    @GetMapping("/cash/currentCash")
    public ResponseEntity<Long> getUserCash(HttpServletRequest request) {
        String email = (String) request.getSession().getAttribute("email");
        if (email != null) {
            Long cashValue = userService.getCash(email).getCash();
            return ResponseEntity.ok(cashValue);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(0L);
        }
    }
}