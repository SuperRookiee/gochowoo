package kr.co.chunjae.gochowoo.controller.User;

import kr.co.chunjae.gochowoo.model.User.User;
import kr.co.chunjae.gochowoo.model.User.UserAddress;
import kr.co.chunjae.gochowoo.service.User.UserAddressService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@AllArgsConstructor
public class UserAddressController {
    @Autowired
    UserAddressService userAddressService;
    @GetMapping("/mypage/shipping")
    public String showShippingPage(HttpSession session, Model model) {
        User user = (User)session.getAttribute("user");
        if (user == null) return "redirect:/user/login?callback=/mypage/shipping";
        List<UserAddress> addressList =  userAddressService.getMyAllUserAddress(user.getId());
        model.addAttribute("addressList", addressList);
        return "views/mypage/shipping/shipping";
    }
}
