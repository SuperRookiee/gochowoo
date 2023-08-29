package kr.co.chunjae.gochowoo.service.cart;

import kr.co.chunjae.gochowoo.model.base.Cart;
import kr.co.chunjae.gochowoo.model.ItemCart;
import kr.co.chunjae.gochowoo.repository.cart.ItemCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemCartServiceImpl implements ItemCartService{
    @Autowired
    private ItemCartRepository itemCartRepository;
    @Override
    public Cart addToCart(Cart cart) {
        return itemCartRepository.save((ItemCart) cart);
    }
}
