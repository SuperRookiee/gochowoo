package kr.co.chunjae.gochowoo.controller.api;

import kr.co.chunjae.gochowoo.model.*;
import kr.co.chunjae.gochowoo.service.cart.ItemCartService;
import kr.co.chunjae.gochowoo.service.cart.PokemonCartService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
    public ResponseEntity<Void> addToPokemonCart(HttpServletRequest request, Long pokemon_id) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) { return ResponseEntity.status(401).build(); }
        Pokemon targetPokemon = Pokemon.builder().id(pokemon_id).build();
        pokemonCartService.addToCart(PokemonCart.builder().user(user).pokemon(targetPokemon).build());
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/item")
    public ResponseEntity<Void> addToItemCart(HttpServletRequest request, Long item_id) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) { return ResponseEntity.status(401).build(); }
        Item targetPokemon = Item.builder().id(item_id).build();
        itemCartService.addToCart(ItemCart.builder().user(user).item(targetPokemon).build());
        return ResponseEntity.noContent().build();
    }

}
