package kr.co.chunjae.gochowoo.controller.api;

import kr.co.chunjae.gochowoo.model.Community;
import kr.co.chunjae.gochowoo.model.User;
import kr.co.chunjae.gochowoo.service.CommunityService;
import kr.co.chunjae.gochowoo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/api/community")
public class CommunityAPIController {
    final CommunityService communityService;
    UserService userService;

    public CommunityAPIController(CommunityService communityService) {
        this.communityService = communityService;
    }

    @PostMapping("/write")
    public String write(@RequestParam String title, @RequestParam String content, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) return "redirect:/user/login";
        if (title.isEmpty() || content.isEmpty()) return "redirect:/community";
        Community write = communityService.write(Community.builder()
                .title(title)
                .content(content)
                .writer(user)
                .build());
        if (write == null) return "redirect:/community";
        System.out.println("title:["+title+"]");
        return "redirect:/community";
    }


}
