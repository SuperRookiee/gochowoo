package kr.co.chunjae.gochowoo.controller.api;

import kr.co.chunjae.gochowoo.dto.AddCartDTO;
import kr.co.chunjae.gochowoo.model.*;
import kr.co.chunjae.gochowoo.service.cart.ItemCartService;
import kr.co.chunjae.gochowoo.service.cart.PokemonCartService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
@RequestMapping("/api/cart")
public class CartAPIController {
    private final PokemonCartService pokemonCartService;
    private final ItemCartService itemCartService;

    public CartAPIController(PokemonCartService pokemonCartService, ItemCartService itemCartService) {
        this.pokemonCartService = pokemonCartService;
        this.itemCartService = itemCartService;
    }

    @PostMapping("/pokemon")
    public ResponseEntity<Void> addToPokemonCart(HttpServletRequest request, @RequestBody AddCartDTO dto) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return ResponseEntity.status(401).build();
        }
        Pokemon pokemon = Pokemon.builder().id(dto.getProductId()).build();
        pokemonCartService.addToCart(PokemonCart.builder().pokemon(pokemon).user(user).amount(dto.getAmount()).build());
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/item")
    public ResponseEntity<Void> addToItemCart(HttpServletRequest request, @RequestBody AddCartDTO dto) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return ResponseEntity.status(401).build();
        }
        Item item = Item.builder().id(dto.getProductId()).build();
        itemCartService.addToCart(ItemCart.builder().item(item).user(user).amount(dto.getAmount()).build());
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/item")
    public ResponseEntity<Void> putToItemCart(HttpServletRequest request, @RequestBody ItemCart itemCart) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return ResponseEntity.status(401).build();
        }
        itemCartService.updateAmount(itemCart.getId(), itemCart.getAmount());
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/pokemon")
    public ResponseEntity<Void> putToPokemonCart(HttpServletRequest request, @RequestBody PokemonCart pokemonCart) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return ResponseEntity.status(401).build();
        }
        pokemonCartService.updateAmount(pokemonCart.getId(), pokemonCart.getAmount());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/pokemon")
    public ResponseEntity<Void> deletePokemonCart(HttpServletRequest request, @RequestBody PokemonCart pokemonCart) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return ResponseEntity.status(401).build();
        }
        pokemonCartService.removeCart(pokemonCart.getId());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/item")
    public ResponseEntity<Void> deleteItemCart(HttpServletRequest request, @RequestBody ItemCart itemCart) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return ResponseEntity.status(401).build();
        }
        itemCartService.removeCart(itemCart.getId());
        return ResponseEntity.noContent().build();
    }

}
