package kr.co.chunjae.gochowoo.service.cart;

import kr.co.chunjae.gochowoo.model.PokemonCart;
import kr.co.chunjae.gochowoo.model.base.Cart;
import kr.co.chunjae.gochowoo.repository.cart.PokemonCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonCartServiceImpl implements PokemonCartService {

    @Autowired
    private PokemonCartRepository pokemonCartRepository;
    @Override
    public Cart addToCart(Cart cart) {
        return pokemonCartRepository.save((PokemonCart) cart);
    }

    @Override
    public void updateAmount(Long id, int amount) {
         pokemonCartRepository.updateAmountById(id, amount);
    }

    @Override
    public void removeCart(Long id) {
        pokemonCartRepository.deleteById(id);
    }

    @Override
    public List<PokemonCart> getAllCarts(Long id) {
        return pokemonCartRepository.findAllByUserId(id);
    }
}
