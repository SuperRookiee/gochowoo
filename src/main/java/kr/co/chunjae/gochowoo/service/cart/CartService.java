package kr.co.chunjae.gochowoo.service.cart;

import kr.co.chunjae.gochowoo.model.base.Cart;

import java.util.List;

public interface CartService {

    Cart addToCart(Cart cart);

    <T extends Cart> List<T> getAllCarts(Long id);

    void updateAmount(Long id, int amount);

    void removeCart(Long id);

}
