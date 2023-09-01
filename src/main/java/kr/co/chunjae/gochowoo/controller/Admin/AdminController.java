package kr.co.chunjae.gochowoo.controller.Admin;

import kr.co.chunjae.gochowoo.model.Item.Item;
import kr.co.chunjae.gochowoo.model.Order.Purchase.Purchase;
import kr.co.chunjae.gochowoo.model.Pokemon.Pokemon;
import kr.co.chunjae.gochowoo.model.User.User;
import kr.co.chunjae.gochowoo.service.Item.ItemService;
import kr.co.chunjae.gochowoo.service.Pokemon.PokemonService;
import kr.co.chunjae.gochowoo.service.User.UserService;
import kr.co.chunjae.gochowoo.service.order.PurchaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    PurchaseService purchaseService;
    UserService userService;
    PokemonService pokemonService;
    ItemService itemService;

    @GetMapping("")
    String showAdminPage(@SessionAttribute(name = "id", required = false) Long userId, Model model) {
        if(userId == null) {
            return "redirect:/user/login";
        }
        return "views/admin/adminHome";
    }
    @GetMapping("/order")
    String showAdminOrderPage(@SessionAttribute(name = "id", required = false) Long userId, Model model) {
        if(userId == null) {
            return "redirect:/user/login";
        }
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

    @GetMapping("/product")
    String showAdminProductPage(@SessionAttribute(name = "id", required = false) Long userId, Model model) {
        if(userId == null) {
            return "redirect:/user/login";
        }
        List<Pokemon> pokemonList = pokemonService.getAllPokemon();
        List<Item> itemList = itemService.getAllItem();
        model.addAttribute("pokemonList", pokemonList);
        model.addAttribute("itemList", itemList);

        return "views/admin/manageProduct";
    }

    @GetMapping("/product/regist/{type}")
    String insertProduct(@PathVariable String type, Model model) {
        model.addAttribute("type", type);
        return "views/admin/registProduct";
    }
}