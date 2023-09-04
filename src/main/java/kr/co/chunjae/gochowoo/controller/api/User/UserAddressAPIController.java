package kr.co.chunjae.gochowoo.controller.api.User;

import kr.co.chunjae.gochowoo.model.User.User;
import kr.co.chunjae.gochowoo.model.User.UserAddress;
import kr.co.chunjae.gochowoo.service.User.UserAddressService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
@Controller
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserAddressAPIController {

    @Autowired
    private final UserAddressService userAddressService;
    @PostMapping("/userAddress")
    public ResponseEntity<Void> addUserAddress(@RequestParam String recipient, @RequestParam String phoneNumber, @RequestParam String address, @RequestParam String deliveryRequest, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        UserAddress userAddress = UserAddress.builder().address(address).user(user).recipient(recipient).phoneNumber(phoneNumber).deliveryRequest(deliveryRequest).build();
        userAddressService.addUserAddress(userAddress);
        return ResponseEntity.ok().build();
    }
}
