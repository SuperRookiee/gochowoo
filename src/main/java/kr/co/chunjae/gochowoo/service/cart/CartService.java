package kr.co.chunjae.gochowoo.service.cart;

import kr.co.chunjae.gochowoo.model.base.Cart;

import java.util.List;

public interface CartService  <T extends Cart> {

    T addToCart(T cart);

    List<T> getAllCarts(Long id);

    void updateAmount(Long id, int amount);

    void removeCart(Long id);

    T findCartByProductId(Long userId, Long productId);

    void deleteAllCart(Long id);
}
