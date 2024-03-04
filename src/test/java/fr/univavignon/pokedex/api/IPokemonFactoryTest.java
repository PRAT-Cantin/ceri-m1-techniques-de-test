package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class IPokemonFactoryTest {
    @Mock
    private IPokemonFactory iPokemonFactory;

    @Before
    public void setUp() throws Exception {
        iPokemonFactory = Mockito.mock(IPokemonFactory.class);
    }

    @Test
    public void createPokemon() {
        Pokemon bulbasaur = new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000,4,56);
        Mockito.when(iPokemonFactory.createPokemon(0,613,64,4000,4)).thenReturn(bulbasaur);
        Pokemon res = iPokemonFactory.createPokemon(0,613,64,4000,4);
        assertEquals(bulbasaur.getIndex(), res.getIndex());
        assertSame(bulbasaur.getName(), res.getName());
        assertEquals(bulbasaur.getAttack(),  res.getAttack());
        assertEquals(bulbasaur.getDefense(), res.getDefense());
        assertEquals(bulbasaur.getStamina(), res.getStamina());
        assertEquals(bulbasaur.getCp(), res.getCp());
        assertEquals(bulbasaur.getHp(), res.getHp());
        assertEquals(bulbasaur.getDust(), res.getDust());
        assertEquals(bulbasaur.getCandy(), res.getCandy());
        assertEquals(bulbasaur.getIv(), res.getIv(), 0.0);
        Mockito.verify(iPokemonFactory).createPokemon(0,613,64,4000,4);
    }
}