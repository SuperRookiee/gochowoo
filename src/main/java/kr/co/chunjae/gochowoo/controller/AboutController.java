package kr.co.chunjae.gochowoo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {

    @GetMapping("/about")
    public String showShopPage() {
        return "views/about";
    }
}