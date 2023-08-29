package kr.co.chunjae.gochowoo.service.cart;

import kr.co.chunjae.gochowoo.model.base.Cart;
import kr.co.chunjae.gochowoo.model.PokemonCart;
import kr.co.chunjae.gochowoo.repository.cart.PokemonCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokemonCartServiceImpl implements PokemonCartService {

    @Autowired
    private PokemonCartRepository pokemonCartRepository;
    @Override
    public Cart addToCart(Cart cart) {
        return pokemonCartRepository.save((PokemonCart) cart);
    }
}
