package kr.co.chunjae.gochowoo.service.Pokemon;

import kr.co.chunjae.gochowoo.model.Pokemon.Pokemon;

import java.util.List;

public interface PokemonService {

    List<Pokemon> getAllPokemon();

    List<Pokemon> getAllPokemonByNewest();

    Pokemon getPokemonById(Long id);

    List<Pokemon> getLatestPokemon();

    Pokemon addPokemon(Pokemon pokemon);

    Pokemon findPokemonByName(String name);
    Pokemon findPokemonByNumber(Integer number);
}