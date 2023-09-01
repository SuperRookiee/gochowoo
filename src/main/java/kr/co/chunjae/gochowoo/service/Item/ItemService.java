package kr.co.chunjae.gochowoo.service.Item;

import kr.co.chunjae.gochowoo.model.Item.Item;

import java.util.List;

public interface ItemService {
    List<Item> getAllItem();
    Item getItemById(Long id);

    List<Item> getLatestItem();
}