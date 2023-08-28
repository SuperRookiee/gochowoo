package kr.co.chunjae.gochowoo.controller;

import kr.co.chunjae.gochowoo.model.Item;
import kr.co.chunjae.gochowoo.model.Pokemon;
import kr.co.chunjae.gochowoo.service.ItemService;
import kr.co.chunjae.gochowoo.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/shop")
public class ShopController {
    private final PokemonService pokemonService;
    private final ItemService itemService;

    @Autowired
    public ShopController(PokemonService pokemonService, ItemService itemService) {
        this.pokemonService = pokemonService;
        this.itemService = itemService;
    }

    @GetMapping()
    public String showShopPage(Model model) {
        List<Pokemon> pokemonList = pokemonService.getAllPokemon();
        List<Item> itemList = itemService.getAllItem();

        model.addAttribute("pokemonList", pokemonList);
        model.addAttribute("itemList", itemList);

        return "views/shop/shop";
    }

    @GetMapping("{productType}/{id}")
    public String showProduct(@PathVariable String productType, @PathVariable Long id, Model model) {
        if(productType.equals("pokemon")) {
            model.addAttribute("product", pokemonService.getPokemonById(id));
        }
        else if(productType.equals("item")) {
            model.addAttribute("item", itemService.getItemById(id));
        }
        model.addAttribute("productType", productType);

        return "views/shop/product";
    }
}