package kr.co.chunjae.gochowoo.service.Pokemon;

import kr.co.chunjae.gochowoo.model.Pokemon.Pokemon;
import kr.co.chunjae.gochowoo.repository.Pokemon.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<Pokemon> getAllPokemonByNewest() {
        return pokemonRepository.findAllByOrderByIdDesc();
    }

    @Override
    public Pokemon getPokemonById(Long id) {
        return pokemonRepository.findById(id).orElseThrow(() -> new RuntimeException("Pokemon not found with ID: " + id));
    }

    @Override
    public List<Pokemon> getLatestPokemon() {
        return pokemonRepository.findTop8ByOrderByIdDesc();
    }

    @Override
    public Pokemon addPokemon(Pokemon pokemon) {
        pokemonRepository.save(pokemon);
        return pokemon;
    }

    @Override
    public Pokemon findPokemonByName(String name) {
        return pokemonRepository.findByName(name);
    }

    @Override
    public Pokemon findPokemonByNumber(Integer number) {
        return pokemonRepository.findByNumber(number);
    }
}