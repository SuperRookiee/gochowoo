package kr.co.chunjae.gochowoo.controller.api.Admin;

import kr.co.chunjae.gochowoo.dto.AddCartDTO;
import kr.co.chunjae.gochowoo.model.Item.Item;
import kr.co.chunjae.gochowoo.model.Item.ItemCart;
import kr.co.chunjae.gochowoo.model.Pokemon.Pokemon;
import kr.co.chunjae.gochowoo.model.Pokemon.PokemonCart;
import kr.co.chunjae.gochowoo.model.User.User;
import kr.co.chunjae.gochowoo.service.cart.ItemCartService;
import kr.co.chunjae.gochowoo.service.cart.PokemonCartService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/api/admin")
public class AdminAPIController {

    @PostMapping("/product/regist/insert/{type}")
    String insertProduct(@PathVariable Long type, Model model) {
        if (type.equals("pokemon")) {
            //insert pokemon
        }
        else if (type.equals("item")) {
            //insert item
        }
        return "redirect:/admin/product";
    }
}
