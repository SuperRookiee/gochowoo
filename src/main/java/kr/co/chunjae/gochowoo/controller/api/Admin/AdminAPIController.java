package kr.co.chunjae.gochowoo.controller.api.Admin;

import kr.co.chunjae.gochowoo.model.Item.Item;
import kr.co.chunjae.gochowoo.model.Pokemon.Pokemon;
import kr.co.chunjae.gochowoo.service.Item.ItemService;
import kr.co.chunjae.gochowoo.service.Pokemon.PokemonService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Controller
@AllArgsConstructor
@RequestMapping("/api/admin")
public class AdminAPIController {

    PokemonService pokemonService;
    ItemService itemService;

    @SneakyThrows
    @PostMapping("/product/insert/pokemon")
    public String insertPokemon(Pokemon pokemon, @RequestParam("image") MultipartFile image, @SessionAttribute(name = "id", required = false) Long userId) {
        if(userId == null) return "redirect:/user/login";

        if (!image.isEmpty()) {
            String path = System.getProperty("user.dir")+"/src/main/resources/static/img/pokemon/";
            File directory = new File(path);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            File file = new File(path + pokemon.getName()+".png");
            image.transferTo(file);

             pokemonService.addPokemon(pokemon);
        } else {
            return "redirect:/error";
        }

        return "redirect:/admin/product";
    }

    @SneakyThrows
    @PostMapping("/product/insert/item")
    public String insertItem(Item item, @RequestParam("image") MultipartFile image, @SessionAttribute(name = "id", required = false) Long userId) {
        if(userId == null) return "redirect:/user/login";
        if (!image.isEmpty()) {
            String path = System.getProperty("user.dir")+"/src/main/resources/static/img/item/";
            File directory = new File(path);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            File file = new File(path + item.getName()+".png");
            image.transferTo(file);

            itemService.addItem(item);
        } else {
            return "redirect:/error";
        }

        return "redirect:/admin/product";
    }
}
