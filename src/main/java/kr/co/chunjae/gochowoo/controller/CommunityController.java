package kr.co.chunjae.gochowoo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/community")
public class CommunityController {
    @GetMapping()
    public String showCommunityPage() {
        return "views/community/community";
    }
}