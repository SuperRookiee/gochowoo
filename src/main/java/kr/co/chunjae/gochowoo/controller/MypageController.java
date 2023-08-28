package kr.co.chunjae.gochowoo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypage")
public class MypageController {

    @GetMapping()
    public String showShopPage() {
        return "views/user/mypage";
    }

    @GetMapping("/info")
    public String showUserInfo() {
        return "views/user/mypage";
    }
}