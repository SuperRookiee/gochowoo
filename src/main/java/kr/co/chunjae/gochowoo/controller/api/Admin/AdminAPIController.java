package kr.co.chunjae.gochowoo.controller.api.Admin;

import kr.co.chunjae.gochowoo.model.Item.Item;
import kr.co.chunjae.gochowoo.model.Pokemon.Pokemon;
import kr.co.chunjae.gochowoo.model.utils.ShippingStatus;
import kr.co.chunjae.gochowoo.service.Item.ItemService;
import kr.co.chunjae.gochowoo.service.Pokemon.PokemonService;
import kr.co.chunjae.gochowoo.service.order.PurchaseService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@RequestMapping("/api/admin")
public class AdminAPIController {

    PokemonService pokemonService;
    ItemService itemService;
    PurchaseService.OrderService orderService;

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

    @PutMapping("/order")
    public ResponseEntity<Void> changeOrderStatus(@RequestParam List<String> targets, @RequestParam String status) {
        ShippingStatus newStatus = ShippingStatus.getShippingStatus(status);
        if (newStatus == null) { return ResponseEntity.badRequest().build(); }
        orderService.changeOrdersStatus(targets.stream().map(Long::parseLong).collect(Collectors.toList()), newStatus);
        return ResponseEntity.ok().build();
    }
}
