package kr.co.chunjae.gochowoo.controller.Shop;

import kr.co.chunjae.gochowoo.model.Item.Item;
import kr.co.chunjae.gochowoo.model.Pokemon.Pokemon;
import kr.co.chunjae.gochowoo.service.Item.ItemService;
import kr.co.chunjae.gochowoo.service.Pokemon.PokemonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/shop")
@AllArgsConstructor
public class ShopController {

    private final PokemonService pokemonService;
    private final ItemService itemService;

    @GetMapping()
    public String showShopPage(Model model) {
        List<Pokemon> pokemonList = pokemonService.getAllPokemon();
        List<Item> itemList = itemService.getAllItem();

        model.addAttribute("pokemonList", pokemonList);
        model.addAttribute("itemList", itemList);

        return "views/shop/shop";
    }

    @GetMapping("{productKind}/{id}")
    public String showProductPage(@PathVariable String productKind, @PathVariable Long id, Model model) {
        if(productKind.equals("pokemon")) {
            model.addAttribute("product", pokemonService.getPokemonById(id));
            model.addAttribute("recentList", pokemonService.getLatestPokemon());
        }
        else if(productKind.equals("item")) {
            model.addAttribute("product", itemService.getItemById(id));
            model.addAttribute("recentList", itemService.getLatestItem());
        }

        model.addAttribute("productKind", productKind);

        return "views/shop/product";
    }
}