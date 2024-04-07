package fr.univavignon.pokedex.api;

/**
 * An IPokemonMetadataProvider aims to provide PokemonMetadata
 * for a given pokemon index.
 *
 * @author fv
 * @version $Id: $Id
 */
public interface IPokemonMetadataProvider {

	/**
	 * Retrieves and returns the metadata for the pokemon
	 * denoted by the given <code>index</code>.
	 *
	 * @param index Index of the pokemon to retrieve metadata for.
	 * @return Metadata of the pokemon.
	 * @throws fr.univavignon.pokedex.api.PokedexException If the given <code>index</code> is not valid.
	 */
	PokemonMetadata getPokemonMetadata(int index) throws PokedexException;
	
}
