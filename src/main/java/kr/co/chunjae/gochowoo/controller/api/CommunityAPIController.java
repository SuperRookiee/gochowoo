package kr.co.chunjae.gochowoo.controller.api;

import kr.co.chunjae.gochowoo.model.User;
import kr.co.chunjae.gochowoo.service.CommunityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/community")
public class CommunityAPIController {
    final CommunityService communityService;

    public CommunityAPIController(CommunityService communityService) {
        this.communityService = communityService;
    }

//    @PostMapping("/write")
//    public String write(@RequestParam String email, @RequestParam String password, @RequestParam String nickName) {
//        User join = communityService.write();
//        if (join == null) return "redirect:/user/join";
//        return "redirect:/user/login";
//    }
}
