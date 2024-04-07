package fr.univavignon.pokedex.api;

/**
 * <p>PokemonTrainerFactory class.</p>
 *
 * @author Cantin-PRAT
 * @version $Id: $Id
 */
public class PokemonTrainerFactory implements IPokemonTrainerFactory {
    /** {@inheritDoc} */
    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
        return new PokemonTrainer(name,team,pokedexFactory.createPokedex(new PokemonMetadataProvider(),new PokemonFactory()));
    }
}
