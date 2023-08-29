package kr.co.chunjae.gochowoo.repository.cart;

import kr.co.chunjae.gochowoo.model.Item;
import kr.co.chunjae.gochowoo.model.PokemonCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonCartRepository extends JpaRepository<PokemonCart, Long> {
}
