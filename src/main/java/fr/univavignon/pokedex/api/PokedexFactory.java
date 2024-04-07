package fr.univavignon.pokedex.api;

/**
 * <p>PokedexFactory class.</p>
 *
 * @author Cantin-PRAT
 * @version $Id: $Id
 */
public class PokedexFactory implements IPokedexFactory{
    /** {@inheritDoc} */
    @Override
    public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        return new Pokedex(metadataProvider,pokemonFactory);
    }
}
