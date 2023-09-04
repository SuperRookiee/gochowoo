package kr.co.chunjae.gochowoo.controller.api.Community;

import kr.co.chunjae.gochowoo.model.Community.Community;
import kr.co.chunjae.gochowoo.model.User.User;
import kr.co.chunjae.gochowoo.service.Community.CommunityService;
import kr.co.chunjae.gochowoo.service.User.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        if (user == null) return "redirect:/user/login?callback=/community";
        if (title.isEmpty() || content.isEmpty()) return "redirect:/community";
        Community write = communityService.write(Community.builder()
                .title(title)
                .content(content.replace("\r\n", "<br>"))
                .writer(user)
                .build());

        if (write == null) return "redirect:/community";
        return "redirect:/community";
    }

    @PostMapping("/{id}")
    public String updateBoard(@PathVariable Long id, @ModelAttribute Community updatedCommunity, Model model, HttpServletRequest request) {
        Community existingCommunity = communityService.getCommunityById(id);
        HttpSession session = request.getSession();
        String sessionUserEmail = (String) session.getAttribute("email");

        if (!existingCommunity.getWriter().getEmail().equals(sessionUserEmail)) {
            return "redirect:/error"; // error 페이지
        }

        // 업데이트 로직
        existingCommunity.setTitle(updatedCommunity.getTitle());

        String replaced = updatedCommunity.getContent().replace("\r\n", "<br>"); // 엔터키를 <br>태그로 db에 저장
        existingCommunity.setContent(replaced);

        model.addAttribute("community", existingCommunity);
        // 필요한 업데이트 로직 추가

        communityService.saveCommunity(existingCommunity);
        return "redirect:/community/" + id; // 수정 후 상세 페이지로 리다이렉트


    }
    @GetMapping("/delete/{id}")
    public String deleteBoard(@PathVariable Long id, HttpServletRequest request) {
        Community community = communityService.getCommunityById(id);
        HttpSession session = request.getSession();
        String sessionUserEmail = (String) session.getAttribute("email");

        if(community.getWriter().getEmail().equals(sessionUserEmail)){
            communityService.deleteCommunityById(id);
            return "redirect:/community"; // 삭제 후 홈 페이지로 리다이렉트
        }
        return "redirect:/error"; // error 페이지
    }
}
