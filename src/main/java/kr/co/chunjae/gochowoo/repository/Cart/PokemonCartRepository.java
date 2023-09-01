package kr.co.chunjae.gochowoo.repository.Cart;

import kr.co.chunjae.gochowoo.model.Pokemon.PokemonCart;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface PokemonCartRepository extends JpaRepository<PokemonCart, Long> {
    List<PokemonCart> findAllByUserId(Long id);
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update PokemonCart c set c.amount = :amount where c.id = :id")
    void updateAmountById(@Param(value = "id") Long id, @Param(value = "amount")int amount);

    Optional<PokemonCart> findByPokemonIdAndUserId(Long pokemon_id, Long user_id);

    @Modifying(clearAutomatically = true)
    @Transactional
    void deleteAllByUserId(Long id);
}
