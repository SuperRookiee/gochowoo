package kr.co.chunjae.gochowoo.controller;

import kr.co.chunjae.gochowoo.model.Pokemon;
import kr.co.chunjae.gochowoo.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ShopController {

    private final PokemonService pokemonService;

    @Autowired
    public ShopController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/shop")
    public String showShopPage(Model model) {
        List<Pokemon> pokemonList = pokemonService.getAllPokemon();
        model.addAttribute("pokemonList", pokemonList);
        return "views/shop/shop";
    }
}