package fr.univavignon.pokedex.api;

/**
 * <p>PokemonFactory class.</p>
 *
 * @author Cantin-PRAT
 * @version $Id: $Id
 */
public class PokemonFactory implements IPokemonFactory {
    private IPokemonMetadataProvider pokemonMetadataProvider;

    /**
     * <p>Constructor for PokemonFactory.</p>
     *
     * @param pokemonMetadataProvider a {@link fr.univavignon.pokedex.api.IPokemonMetadataProvider} object
     */
    public PokemonFactory(IPokemonMetadataProvider pokemonMetadataProvider) {
        this.pokemonMetadataProvider = pokemonMetadataProvider;
    }

    /**
     * <p>Constructor for PokemonFactory.</p>
     */
    public PokemonFactory() {
        this.pokemonMetadataProvider = new PokemonMetadataProvider();
    }

    /** {@inheritDoc} */
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException {
        PokemonMetadata pokemon = pokemonMetadataProvider.getPokemonMetadata(index);
        return new Pokemon(pokemon.getIndex(),pokemon.getName(),pokemon.getAttack(),pokemon.getDefense(),pokemon.getStamina(),cp,hp,dust,candy,0);
    }
}
