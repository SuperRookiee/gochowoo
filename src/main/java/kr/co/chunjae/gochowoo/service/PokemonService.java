package kr.co.chunjae.gochowoo.service;

import kr.co.chunjae.gochowoo.model.Pokemon;

import java.util.List;

public interface PokemonService {

    List<Pokemon> getAllPokemon();

    public List<Pokemon> getPokemonByPage(int page, int itemsPerPage);

    public int getTotalPokemonCount();
}