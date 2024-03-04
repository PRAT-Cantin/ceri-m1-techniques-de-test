package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.assertSame;

public class IPokemonTrainerFactoryTest {
    @Mock
    private IPokemonTrainerFactory iPokemonTrainerFactory;
    @Mock
    private IPokedexFactory iPokedexFactory;
    @Mock
    IPokedex iPokedex;

    @Before
    public void setUp() throws Exception {
        iPokemonTrainerFactory = Mockito.mock(IPokemonTrainerFactory.class);
        iPokedexFactory  = Mockito.mock(IPokedexFactory.class);
        iPokedex = Mockito.mock(IPokedex.class);
    }

    @Test
    public void createTrainer() {
        PokemonTrainer james = new PokemonTrainer("James",Team.VALOR,iPokedex);
        Mockito.when(iPokemonTrainerFactory.createTrainer("James",Team.VALOR,iPokedexFactory)).thenReturn(james);
        PokemonTrainer res = iPokemonTrainerFactory.createTrainer("James",Team.VALOR,iPokedexFactory);
        assertSame(james.getName(), res.getName());
        assertSame(james.getTeam(), res.getTeam());
        assertSame(james.getPokedex(), res.getPokedex());
    }
}