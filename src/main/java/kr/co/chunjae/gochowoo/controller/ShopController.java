package kr.co.chunjae.gochowoo.controller;

import kr.co.chunjae.gochowoo.model.Pokemon;
import kr.co.chunjae.gochowoo.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ShopController {

    private final PokemonService pokemonService;

    @Autowired
    public ShopController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/shop")
    public String showShopPage(@RequestParam(name = "page", defaultValue = "1") int page, Model model) {
        int itemsPerPage = 9; // 한 페이지당 아이템 수
        List<Pokemon> pokemonList = pokemonService.getPokemonByPage(page, itemsPerPage);

        // 총 페이지 수 계산
        int totalItems = pokemonService.getTotalPokemonCount();
        int totalPages = (int) Math.ceil((double) totalItems / itemsPerPage);

        model.addAttribute("pokemonList", pokemonList);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);

        return "views/shop/shop";
    }
}