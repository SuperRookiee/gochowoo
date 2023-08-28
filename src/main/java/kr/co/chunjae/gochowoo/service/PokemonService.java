package kr.co.chunjae.gochowoo.service;

import kr.co.chunjae.gochowoo.model.Pokemon;

import java.util.List;

public interface PokemonService {

    List<Pokemon> getAllPokemon();

    Pokemon getPokemonById(Long id);

    List<Pokemon> getLatestPokemon();
}