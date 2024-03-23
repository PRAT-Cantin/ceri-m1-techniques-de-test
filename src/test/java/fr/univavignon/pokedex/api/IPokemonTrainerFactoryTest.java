package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.assertSame;

public class IPokemonTrainerFactoryTest {
    private IPokemonTrainerFactory iPokemonTrainerFactory;
    private IPokedexFactory iPokedexFactory;

    @Before
    public void setUp() throws Exception {
        iPokemonTrainerFactory = new PokemonTrainerFactory();
        iPokedexFactory  = new PokedexFactory();
    }

    @Test
    public void createTrainer() {
        PokemonTrainer res = iPokemonTrainerFactory.createTrainer("James",Team.VALOR,iPokedexFactory);
        assertSame("James", res.getName());
        assertSame(Team.VALOR, res.getTeam());
        Assert.assertTrue(res.getPokedex() instanceof IPokedex);
    }
}