package kr.co.chunjae.gochowoo.controller.api;

import com.google.gson.Gson;
import kr.co.chunjae.gochowoo.model.*;
import kr.co.chunjae.gochowoo.service.UserService;
import kr.co.chunjae.gochowoo.service.cart.ItemCartService;
import kr.co.chunjae.gochowoo.service.cart.OrderService;
import kr.co.chunjae.gochowoo.service.cart.PokemonCartService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@AllArgsConstructor
@Controller
@RequestMapping("/api")
public class PaymentAPIController {
    private final UserService userService;
    private final PokemonCartService pokemonCartService;
    private final ItemCartService itemCartService;
    private final OrderService orderService;

    @PostMapping("/payment")
    public String buy(HttpSession session, @RequestParam Long address) {
        User user = (User) session.getAttribute("user");
        if (user == null || address == null) {
            return "redirect:/user/login";
        }
        List<PokemonCart> pokemonCartList = pokemonCartService.getAllCarts(user.getId());
        List<ItemCart> itemCartList = itemCartService.getAllCarts(user.getId());
        List<OrderHistory> orderHistoryList = new LinkedList<>();
        AtomicLong totalPrice = new AtomicLong(0L);
        pokemonCartList.forEach((p) -> {
            totalPrice.addAndGet((long) p.getPokemon().getPrice() * p.getAmount());
            OrderHistory orderHistory = OrderHistory.builder()
                    .product_id("p" + p.getId())
                    .name(p.getPokemon().getName())
                    .price((long) p.getPokemon().getPrice())
                    .amount(p.getAmount())
                    .build();
            orderHistoryList.add(orderHistory);
        });
        itemCartList.forEach((p) -> {
            totalPrice.addAndGet((long) p.getItem().getPrice() * p.getAmount());
            OrderHistory orderHistory = OrderHistory.builder()
                    .product_id("p" + p.getId())
                    .name(p.getItem().getName())
                    .price((long) p.getItem().getPrice())
                    .amount(p.getAmount())
                    .build();
            orderHistoryList.add(orderHistory);
        });
        if (totalPrice.get() > user.getCash()) {
            return "redirect:/mypage/cash";
        }
        Gson gson = new Gson();
        String orderHistory = gson.toJson(orderHistoryList);
        itemCartService.deleteAllCart(user.getId());
        pokemonCartService.deleteAllCart(user.getId());
        user.setCash(user.getCash() - totalPrice.get());
        userService.updateUser(user);
        orderService.saveOrder(Order.builder()
                .orderHistory(orderHistory)
                .totalPrice(totalPrice.get())
                .userAddress(UserAddress.builder().id(address).build())
                .build());
        return "redirect:/mypage/purchase";
    }
}
