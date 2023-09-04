package kr.co.chunjae.gochowoo.service.Item;

import kr.co.chunjae.gochowoo.model.Item.Item;

import java.util.List;

public interface ItemService {
    List<Item> getAllItemByNewest();

    List<Item> getAllItem();
    Item getItemById(Long id);

    List<Item> getLatestItem();

    Item addItem(Item item);

    Item findItemByName(String name);
    Item findItemByNumber(Integer number);
}