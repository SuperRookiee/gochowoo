package kr.co.chunjae.gochowoo.service;

import kr.co.chunjae.gochowoo.model.Pokemon;
import kr.co.chunjae.gochowoo.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PokemonServiceImpl implements PokemonService {

    private final PokemonRepository pokemonRepository;

    @Autowired
    public PokemonServiceImpl(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @Override
    public List<Pokemon> getAllPokemon() {
        return pokemonRepository.findAll();
    }

    @Override
    public List<Pokemon> getPokemonByPage(int page, int itemsPerPage) {
        int startIndex = (page - 1) * itemsPerPage;
        int endIndex = startIndex + itemsPerPage;

        List<Pokemon> allPokemonList = getAllPokemon(); // Using the correct method

        if (startIndex >= allPokemonList.size()) {
            return Collections.emptyList(); // 페이지를 벗어나는 경우 빈 리스트 반환
        }

        // endIndex가 리스트의 크기보다 클 경우 제한을 걸어줌
        endIndex = Math.min(endIndex, allPokemonList.size());

        return allPokemonList.subList(startIndex, endIndex);
    }

    @Override
    public int getTotalPokemonCount() {
        return getAllPokemon().size();
    }
}