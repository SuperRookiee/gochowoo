package kr.co.chunjae.gochowoo.service.Item;

import kr.co.chunjae.gochowoo.model.Item.Item;
import kr.co.chunjae.gochowoo.repository.Item.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository ItemRepository) {
        this.itemRepository = ItemRepository;
    }

    @Override
    public List<Item> getAllItem() {
        return itemRepository.findAll();
    }

    @Override
    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElseThrow(() -> new RuntimeException("Item not found with ID: " + id));
    }

    @Override
    public List<Item> getLatestItem() {
        return itemRepository.findTop8ByOrderByIdDesc();
    }
}