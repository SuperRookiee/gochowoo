package kr.co.chunjae.gochowoo.repository;

import kr.co.chunjae.gochowoo.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

}
