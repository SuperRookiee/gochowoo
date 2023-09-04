package kr.co.chunjae.gochowoo.repository.Pokemon;

import kr.co.chunjae.gochowoo.model.Pokemon.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    List<Pokemon> findTop8ByOrderByIdDesc();

    Pokemon findByName(String name);

    Pokemon findByNumber(Integer number);

    List<Pokemon> findAllByOrderByIdDesc();
}
