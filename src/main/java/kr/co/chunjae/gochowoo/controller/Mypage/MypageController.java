package kr.co.chunjae.gochowoo.controller.Mypage;

import kr.co.chunjae.gochowoo.model.Community.Community;
import kr.co.chunjae.gochowoo.model.Order.Purchase.Purchase;
import kr.co.chunjae.gochowoo.model.User.User;
import kr.co.chunjae.gochowoo.service.Community.CommunityService;
import kr.co.chunjae.gochowoo.service.User.UserService;
import kr.co.chunjae.gochowoo.service.order.PurchaseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/mypage")
public class MypageController {

    private final UserService userService;
    private final PurchaseService purchaseService;
    private final CommunityService communityService;

    @GetMapping()
    public String showShopPage(HttpSession session, Model model) {
        String email = (String) session.getAttribute("email");
        if(email == null) {
            return "redirect:/user/login?callback=/mypage";
        }
        User user = userService.userInfo(email);
        model.addAttribute("user", user);
        return "views/mypage/mypage";
    }

    @GetMapping("/purchase")
    public String showPurchasePage(@SessionAttribute(name = "id", required = false) Long userId, Model model) {
        if (userId != null) {
            List<Purchase> purchaseList = purchaseService.getAllPurchasesByUserId(userId);
            model.addAttribute("purchaseList", purchaseList);
            return "views/mypage/purchase/purchase";
        }
        return "redirect:/user/login?callback=/mypage";
    }

    @GetMapping("/purchase/{id}")
    public String showPurchaseDetailPage(@SessionAttribute(name = "id", required = false) Long userId, Model model, @PathVariable Long id) {
        if (userId != null) {
            Purchase purchase = purchaseService.getPurchaseByOrderId(id);
            model.addAttribute("purchase", purchase);
            return "views/mypage/purchase/purchaseDetail";
        }
        return "redirect:/user/login?callback=/mypage";
    }

    @GetMapping("/cash")
    public String showCashPage() {
        return "views/mypage/cash/cash";
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

    @GetMapping("/post")
    public String showPostPage(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/user/login?callback=/mypage";
        }
        List<Community> postList = communityService.getAllBoardByUserId(user.getId());
        model.addAttribute("postList", postList);
        return "/views/mypage/post/post";
    }
}