package kr.co.chunjae.gochowoo.controller.Admin;

import kr.co.chunjae.gochowoo.model.Order.Purchase.Purchase;
import kr.co.chunjae.gochowoo.model.User.User;
import kr.co.chunjae.gochowoo.service.User.UserService;
import kr.co.chunjae.gochowoo.service.order.PurchaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    PurchaseService purchaseService;
    UserService userService;

    @GetMapping("")
    String showAdminPage(Model model) {
        return "views/admin/adminHome";
    }
    @GetMapping("/order")
    String showAdminOrderPage(Model model) {
        List<Purchase> purchaseList = purchaseService.getAllPurchases();
        model.addAttribute("purchaseList", purchaseList);
        return "views/admin/manageOrder";
    }

    @GetMapping("/userInfo/{id}")
    String showUserInfo(@PathVariable String id, Model model) {
        User user = userService.getUserById(Long.parseLong(id));
        if (user == null) {
            return "redirect:/admin";
        }
        model.addAttribute("user", user);
        return "/views/admin/userInfo";
    }
}
