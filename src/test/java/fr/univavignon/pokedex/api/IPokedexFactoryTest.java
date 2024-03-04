package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class IPokedexFactoryTest {
    @Mock
    private IPokedexFactory iPokedexFactory;
    @Mock
    private IPokemonMetadataProvider iPokemonMetadataProvider;
    @Mock
    private IPokemonFactory iPokemonFactory;

    @Before
    public void setUp() throws Exception {
        iPokedexFactory = Mockito.mock(IPokedexFactory.class);
        iPokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        iPokemonFactory = Mockito.mock(IPokemonFactory.class);
    }

    @Test
    public void testCreatePokedex() {
        Mockito.when(iPokedexFactory.createPokedex(iPokemonMetadataProvider,iPokemonFactory)).thenReturn(Mockito.mock(IPokedex.class));
        Object iPokedex = iPokedexFactory.createPokedex(iPokemonMetadataProvider,iPokemonFactory);
        Assert.assertTrue(iPokedex instanceof IPokedex);
        Mockito.verify(iPokedexFactory).createPokedex(iPokemonMetadataProvider,iPokemonFactory);
    }
}