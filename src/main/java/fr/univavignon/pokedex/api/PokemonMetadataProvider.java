package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.List;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {
    List<PokemonMetadata> pokemons;
    public PokemonMetadataProvider() {
        pokemons = new ArrayList<PokemonMetadata>(151);
        pokemons.add(new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));
        pokemons.add(new PokemonMetadata(133, "Aquali", 186, 168, 260));
    }
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if (index < 0 || index > 150) {
            throw new PokedexException("Given index is out of range");
        }
        return pokemons.get(index);
    }
}
