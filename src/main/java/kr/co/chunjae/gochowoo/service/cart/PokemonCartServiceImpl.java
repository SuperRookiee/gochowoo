package kr.co.chunjae.gochowoo.service.cart;

import kr.co.chunjae.gochowoo.model.Pokemon.PokemonCart;
import kr.co.chunjae.gochowoo.repository.Cart.PokemonCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonCartServiceImpl implements PokemonCartService {

    @Autowired
    private PokemonCartRepository pokemonCartRepository;
    @Override
    public PokemonCart addToCart(PokemonCart cart) {
        return pokemonCartRepository.save(cart);
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
    public PokemonCart findCartByProductId(Long productId, Long userId) {
        return pokemonCartRepository.findByPokemonIdAndUserId(productId, userId).orElse(null);
    }

    @Override
    public void deleteAllCart(Long id) {
        pokemonCartRepository.deleteAllByUserId(id);
    }

    @Override
    public List<PokemonCart> getAllCarts(Long id) {
        return pokemonCartRepository.findAllByUserId(id);
    }
}
