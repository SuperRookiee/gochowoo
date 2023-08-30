package kr.co.chunjae.gochowoo.service.cart;

import kr.co.chunjae.gochowoo.model.Item;
import kr.co.chunjae.gochowoo.model.base.Cart;
import kr.co.chunjae.gochowoo.model.ItemCart;
import kr.co.chunjae.gochowoo.repository.cart.ItemCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemCartServiceImpl implements ItemCartService{
    @Autowired
    private ItemCartRepository itemCartRepository;
    @Override
    public Cart addToCart(Cart cart) {
        return itemCartRepository.save((ItemCart) cart);
    }

    @Override
    public void updateAmount(Long id, int amount)  {
        itemCartRepository.updateAmountById(id, amount);
    }

    @Override
    public void removeCart(Long id) {
        itemCartRepository.deleteById(id);
    }

    @Override
    public List<ItemCart> getAllCarts(Long id) {
        return itemCartRepository.findAllByUserId(id);
    }
}
