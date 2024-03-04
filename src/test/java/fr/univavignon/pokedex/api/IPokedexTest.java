package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;

public class IPokedexTest {
    @Mock
    private IPokedex iPokedex;
    private ArrayList<Pokemon> pokemons;
    private Pokemon bulbasaur;
    private Pokemon vaporeon;

    @Before
    public void setUp() throws Exception {
        iPokedex = Mockito.mock(IPokedex.class);
        pokemons = new ArrayList<Pokemon>();
        bulbasaur = new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000,4,56);
        vaporeon = new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,100);
    }

    @Test
    public void testAddPokemon() {
        iPokedex.addPokemon(bulbasaur);
    }
    @Test
    public void testGetPokemon() {
    }
    @Test
    public void testGetPokemons() {
    }
    @Test
    public void testTestGetPokemons() {
    }
}