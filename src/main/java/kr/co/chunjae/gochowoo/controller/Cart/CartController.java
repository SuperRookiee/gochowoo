package kr.co.chunjae.gochowoo.controller.Cart;

import kr.co.chunjae.gochowoo.model.Item.ItemCart;
import kr.co.chunjae.gochowoo.model.Pokemon.PokemonCart;
import kr.co.chunjae.gochowoo.model.User.User;
import kr.co.chunjae.gochowoo.model.User.UserAddress;
import kr.co.chunjae.gochowoo.service.User.UserAddressService;
import kr.co.chunjae.gochowoo.service.cart.ItemCartService;
import kr.co.chunjae.gochowoo.service.cart.PokemonCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final PokemonCartService pokemonCartService;
    private final ItemCartService itemCartService;
    private final UserAddressService userAddressService;

    @Autowired
    public CartController(PokemonCartService pokemonCartService, ItemCartService itemCartService, UserAddressService userAddressService) {
        this.pokemonCartService = pokemonCartService;
        this.itemCartService = itemCartService;
        this.userAddressService = userAddressService;
    }
    @GetMapping()
    public String showCartPage(HttpServletRequest request, Model model) {
        HttpSession httpSession = request.getSession();
        User user = (User) httpSession.getAttribute("user");
        if (user == null) {return "redirect:/user/login?callback=/cart";}
        List<PokemonCart> pokemonCartList = pokemonCartService.getAllCarts(user.getId());
        List<ItemCart> itemCartList = itemCartService.getAllCarts(user.getId());
        List<UserAddress> addressList =  userAddressService.getMyAllUserAddress(user.getId());
        model.addAttribute("addressList", addressList);
        httpSession.setAttribute("cash", user.getCash());
        model.addAttribute("pokemonCartList", pokemonCartList);
        model.addAttribute("itemCartList", itemCartList);
        return "views/cart/cart";
    }

}
