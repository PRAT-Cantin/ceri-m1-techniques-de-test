package fr.univavignon.pokedex.api;

import java.util.HashMap;

/**
 * <p>PokemonMetadataProvider class.</p>
 *
 * @author Cantin-PRAT
 * @version $Id: $Id
 */
public class PokemonMetadataProvider implements IPokemonMetadataProvider {
    /**
     * Hashmap linking a pokemon id to its pokemon metadata
     */
    HashMap<Integer,PokemonMetadata> pokemons;
    /**
     * <p>Constructor for PokemonMetadataProvider.</p>
     */
    public PokemonMetadataProvider() {
        pokemons = new HashMap<>(151);
        pokemons.put(0,new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));
        pokemons.put(133,new PokemonMetadata(133, "Aquali", 186, 168, 260));
    }
    /** {@inheritDoc} */
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if (index < 0 || index > 150) {
            throw new PokedexException("Given index is out of range");
        }
        return pokemons.get(index);
    }
}
