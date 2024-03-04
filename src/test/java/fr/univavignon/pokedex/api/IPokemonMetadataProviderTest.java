package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class IPokemonMetadataProviderTest {
    @Mock
    private IPokemonMetadataProvider iPokemonMetadataProvider;
    private PokemonMetadata bulbasaur;
    @Before
    public void setUp() throws Exception {
        iPokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        bulbasaur = new PokemonMetadata(0,"Bulbizarre",126,126,90);
    }
    @Test
    public void getPokemonMetadata() throws PokedexException {
        Mockito.when(iPokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(bulbasaur);
        PokemonMetadata res = iPokemonMetadataProvider.getPokemonMetadata(0);
        assertEquals(bulbasaur.getIndex(), res.getIndex());
        assertSame(bulbasaur.getName(), res.getName());
        assertEquals(bulbasaur.getAttack(),  res.getAttack());
        assertEquals(bulbasaur.getDefense(), res.getDefense());
        assertEquals(bulbasaur.getStamina(), res.getStamina());
        Mockito.verify(iPokemonMetadataProvider).getPokemonMetadata(0);
    }
}