package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * <p>Pokedex class.</p>
 * @author Cantin-PRAT
 * @version $Id: $Id
 */
public class Pokedex implements IPokedex {
    /**
     * Pokemons in Pokedex
     */
    private List<Pokemon> pokemons;
    /**
     * Pokemon Metadata Provider of the pokedex
     */
    private IPokemonMetadataProvider pokemonMetadataProvider;
    /**
     * Pokemon Factory of the pokedex
     */
    private IPokemonFactory pokemonFactory;

    /**
     * <p>Constructor for Pokedex.</p>
     *
     * @param pokemonMetadataProvider a {@link fr.univavignon.pokedex.api.IPokemonMetadataProvider} object
     * @param pokemonFactory a {@link fr.univavignon.pokedex.api.IPokemonFactory} object
     */
    public Pokedex(IPokemonMetadataProvider pokemonMetadataProvider, IPokemonFactory pokemonFactory) {
        this.pokemons = new ArrayList<>();;
        this.pokemonMetadataProvider = pokemonMetadataProvider;
        this.pokemonFactory = pokemonFactory;
    }

    /**
     * <p>Constructor for Pokedex.</p>
     */
    public Pokedex() {
        pokemons = new ArrayList<>();
        pokemonMetadataProvider = new PokemonMetadataProvider();
        pokemonFactory = new PokemonFactory(pokemonMetadataProvider);
    }

    /** {@inheritDoc} */
    @Override
    public int size() {
        return pokemons.size();
    }

    /** {@inheritDoc} */
    @Override
    public int addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
        return pokemons.size() - 1;
    }

    /** {@inheritDoc} */
    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        if (id < 0 || id >= pokemons.size()) {
            throw new PokedexException("Given id is invalid");
        }
        return pokemons.get(id);
    }

    /** {@inheritDoc} */
    @Override
    public List<Pokemon> getPokemons() {
        return Collections.unmodifiableList(pokemons);
    }

    /** {@inheritDoc} */
    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> copyPokemons = new ArrayList<>(pokemons);
        copyPokemons.sort(order);
        return Collections.unmodifiableList(copyPokemons);
    }

    /** {@inheritDoc} */
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException {
        return pokemonFactory.createPokemon(index,cp,hp,dust,candy);
    }

    /** {@inheritDoc} */
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return pokemonMetadataProvider.getPokemonMetadata(index);
    }
}
