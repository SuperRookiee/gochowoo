package kr.co.chunjae.gochowoo.controller.Community;

import kr.co.chunjae.gochowoo.model.Community.Community;
import kr.co.chunjae.gochowoo.model.User.User;
import kr.co.chunjae.gochowoo.service.Community.CommunityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/community")
public class CommunityController {
    CommunityService communityService;
    @GetMapping()
    public String showCommunityPage(Model model) {
        List<Community> communityList = communityService.getAllBoard();
        model.addAttribute("communityList", communityList);

        return "views/community/community";
    }
    @GetMapping("/write")
    public String showWritePage(HttpSession session) {
        User user = (User)session.getAttribute("user");
        if (user == null) return "redirect:/user/login?callback=/community";
        return "views/community/writeBoard";
    }

    @GetMapping("/{id}")
    public String showBoardDetail(@PathVariable Long id, Model model) {
        Community community = communityService.getCommunityById(id);
        if (community != null) {
            community.setHits(community.getHits() + 1);
            communityService.saveCommunity(community);

            model.addAttribute("community", community);
        }
        return "views/community/boardDetail";
    }

    @GetMapping("/update/{id}")
    public String updateBoard(@PathVariable Long id, Model model, HttpServletRequest request) {
        Community community = communityService.getCommunityById(id);
        HttpSession session = request.getSession();
        String sessionUserEmail = (String) session.getAttribute("email");

        if (community == null || !community.getWriter().getEmail().equals(sessionUserEmail)) {
            return "redirect:/error"; // error 페이지
        }

        String replaced = community.getContent().replace("<br>", "\r\n"); // 엔터키를 <br>태그로 db에 저장
        community.setContent(replaced);
        model.addAttribute("community", community);
        return "views/community/updateBoard";
    }

}