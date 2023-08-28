package kr.co.chunjae.gochowoo.service;

import kr.co.chunjae.gochowoo.model.Item;

import java.util.List;

public interface ItemService {
    List<Item> getAllItem();
    Item getItemById(Long id);

    List<Item> getLatestItem();
}