package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex {
    private List<Pokemon> pokemons;
    private PokemonMetadataProvider pokemonMetadataProvider;

    public Pokedex() {
        pokemons = new ArrayList<>();
        pokemonMetadataProvider = new PokemonMetadataProvider();
    }

    @Override
    public int size() {
        return pokemons.size();
    }

    @Override
    public int addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
        return pokemons.size()-1;
    }

    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        if (id < 0 || id >= pokemons.size()) {
            throw new PokedexException("Given id is invalid");
        }
        return pokemons.get(id);
    }

    @Override
    public List<Pokemon> getPokemons() {
        return Collections.unmodifiableList(pokemons);
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> copyPokemons = new ArrayList<>(pokemons);
        copyPokemons.sort(order);
        return Collections.unmodifiableList(copyPokemons);
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException {
        PokemonMetadata pokemon = pokemonMetadataProvider.getPokemonMetadata(index);
        return new Pokemon(pokemon.getIndex(),pokemon.getName(),pokemon.getAttack(),pokemon.getDefense(),pokemon.getStamina(),cp,hp,dust,candy,0);
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return pokemonMetadataProvider.getPokemonMetadata(index);
    }
}
