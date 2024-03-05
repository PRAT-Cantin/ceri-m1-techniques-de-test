package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class IPokedexTest {
    @Mock
    private IPokedex iPokedex;
    private List<Pokemon> pokemons;
    private Pokemon bulbasaur;
    private Pokemon vaporeon;

    @Before
    public void setUp() throws Exception {
        iPokedex = Mockito.mock(IPokedex.class);
        pokemons = new ArrayList<Pokemon>();
        bulbasaur = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        vaporeon = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);
    }

    @Test
    public void testSize() {
        Mockito.when(iPokedex.size()).thenReturn(0);
        assertEquals(0, iPokedex.size());
        iPokedex.addPokemon(bulbasaur);
        Mockito.when(iPokedex.size()).thenReturn(1);
        assertEquals(1, iPokedex.size());
        iPokedex.addPokemon(vaporeon);
        Mockito.when(iPokedex.size()).thenReturn(2);
        assertEquals(2, iPokedex.size());
    }

    @Test
    public void testAddPokemon() throws PokedexException {
        iPokedex.addPokemon(bulbasaur);
        Mockito.when(iPokedex.getPokemon(0)).thenReturn(bulbasaur);
        Pokemon res = iPokedex.getPokemon(0);
        assertEquals(bulbasaur.getIndex(), res.getIndex());
        assertSame(bulbasaur.getName(), res.getName());
        assertEquals(bulbasaur.getAttack(), res.getAttack());
        assertEquals(bulbasaur.getDefense(), res.getDefense());
        assertEquals(bulbasaur.getStamina(), res.getStamina());
        assertEquals(bulbasaur.getCp(), res.getCp());
        assertEquals(bulbasaur.getHp(), res.getHp());
        assertEquals(bulbasaur.getDust(), res.getDust());
        assertEquals(bulbasaur.getCandy(), res.getCandy());
        assertEquals(bulbasaur.getIv(), res.getIv(), 0.0);
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        Mockito.when(iPokedex.getPokemon(-1)).thenThrow(PokedexException.class);
        assertThrows(PokedexException.class, () -> iPokedex.getPokemon(-1));
        iPokedex.addPokemon(bulbasaur);
        Pokemon res = iPokedex.getPokemon(0);
        Mockito.when(iPokedex.getPokemon(0)).thenReturn(bulbasaur);
        assertEquals(bulbasaur.getIndex(), res.getIndex());
        assertSame(bulbasaur.getName(), res.getName());
        assertEquals(bulbasaur.getAttack(), res.getAttack());
        assertEquals(bulbasaur.getDefense(), res.getDefense());
        assertEquals(bulbasaur.getStamina(), res.getStamina());
        assertEquals(bulbasaur.getCp(), res.getCp());
        assertEquals(bulbasaur.getHp(), res.getHp());
        assertEquals(bulbasaur.getDust(), res.getDust());
        assertEquals(bulbasaur.getCandy(), res.getCandy());
        assertEquals(bulbasaur.getIv(), res.getIv(), 0.0);
    }

    @Test
    public void testGetPokemons() {
        Mockito.when(iPokedex.getPokemons()).thenReturn(pokemons);
        assertTrue(iPokedex.getPokemons().isEmpty());

        iPokedex.addPokemon(bulbasaur);
        pokemons.add(bulbasaur);

        assertEquals(bulbasaur.getIndex(), iPokedex.getPokemons().get(0).getIndex());
        assertSame(bulbasaur.getName(), iPokedex.getPokemons().get(0).getName());
        assertEquals(bulbasaur.getAttack(), iPokedex.getPokemons().get(0).getAttack());
        assertEquals(bulbasaur.getDefense(), iPokedex.getPokemons().get(0).getDefense());
        assertEquals(bulbasaur.getStamina(), iPokedex.getPokemons().get(0).getStamina());
        assertEquals(bulbasaur.getCp(), iPokedex.getPokemons().get(0).getCp());
        assertEquals(bulbasaur.getHp(), iPokedex.getPokemons().get(0).getHp());
        assertEquals(bulbasaur.getDust(), iPokedex.getPokemons().get(0).getDust());
        assertEquals(bulbasaur.getCandy(), iPokedex.getPokemons().get(0).getCandy());
        assertEquals(bulbasaur.getIv(), iPokedex.getPokemons().get(0).getIv(), 0.0);

        iPokedex.addPokemon(vaporeon);
        pokemons.add(vaporeon);

        assertEquals(bulbasaur.getIndex(), iPokedex.getPokemons().get(0).getIndex());
        assertSame(bulbasaur.getName(), iPokedex.getPokemons().get(0).getName());
        assertEquals(bulbasaur.getAttack(), iPokedex.getPokemons().get(0).getAttack());
        assertEquals(bulbasaur.getDefense(), iPokedex.getPokemons().get(0).getDefense());
        assertEquals(bulbasaur.getStamina(), iPokedex.getPokemons().get(0).getStamina());
        assertEquals(bulbasaur.getCp(), iPokedex.getPokemons().get(0).getCp());
        assertEquals(bulbasaur.getHp(), iPokedex.getPokemons().get(0).getHp());
        assertEquals(bulbasaur.getDust(), iPokedex.getPokemons().get(0).getDust());
        assertEquals(bulbasaur.getCandy(), iPokedex.getPokemons().get(0).getCandy());
        assertEquals(bulbasaur.getIv(), iPokedex.getPokemons().get(0).getIv(), 0.0);
        assertEquals(bulbasaur.getIndex(), iPokedex.getPokemons().get(0).getIndex());

        assertSame(vaporeon.getName(), iPokedex.getPokemons().get(1).getName());
        assertEquals(vaporeon.getAttack(), iPokedex.getPokemons().get(1).getAttack());
        assertEquals(vaporeon.getDefense(), iPokedex.getPokemons().get(1).getDefense());
        assertEquals(vaporeon.getStamina(), iPokedex.getPokemons().get(1).getStamina());
        assertEquals(vaporeon.getCp(), iPokedex.getPokemons().get(1).getCp());
        assertEquals(vaporeon.getHp(), iPokedex.getPokemons().get(1).getHp());
        assertEquals(vaporeon.getDust(), iPokedex.getPokemons().get(1).getDust());
        assertEquals(vaporeon.getCandy(), iPokedex.getPokemons().get(1).getCandy());
        assertEquals(vaporeon.getIv(), iPokedex.getPokemons().get(1).getIv(), 0.0);
    }

    @Test
    public void testGetPokemonsWithComparatorName() {
        Mockito.when(iPokedex.getPokemons(PokemonComparators.NAME)).thenReturn(pokemons);
        assertTrue(iPokedex.getPokemons().isEmpty());

        iPokedex.addPokemon(vaporeon);
        iPokedex.addPokemon(bulbasaur);

        pokemons.add(bulbasaur);
        pokemons.add(vaporeon);


        List<Pokemon> res = iPokedex.getPokemons(PokemonComparators.NAME);

        assertEquals(bulbasaur.getIndex(), res.get(0).getIndex());
        assertSame(bulbasaur.getName(), res.get(0).getName());
        assertEquals(bulbasaur.getAttack(), res.get(0).getAttack());
        assertEquals(bulbasaur.getDefense(), res.get(0).getDefense());
        assertEquals(bulbasaur.getStamina(), res.get(0).getStamina());
        assertEquals(bulbasaur.getCp(), res.get(0).getCp());
        assertEquals(bulbasaur.getHp(), res.get(0).getHp());
        assertEquals(bulbasaur.getDust(), res.get(0).getDust());
        assertEquals(bulbasaur.getCandy(), res.get(0).getCandy());
        assertEquals(bulbasaur.getIv(), res.get(0).getIv(), 0.0);
        assertEquals(bulbasaur.getIndex(), res.get(0).getIndex());

        assertSame(vaporeon.getName(), res.get(1).getName());
        assertEquals(vaporeon.getAttack(), res.get(1).getAttack());
        assertEquals(vaporeon.getDefense(), res.get(1).getDefense());
        assertEquals(vaporeon.getStamina(), res.get(1).getStamina());
        assertEquals(vaporeon.getCp(), res.get(1).getCp());
        assertEquals(vaporeon.getHp(), res.get(1).getHp());
        assertEquals(vaporeon.getDust(), res.get(1).getDust());
        assertEquals(vaporeon.getCandy(), res.get(1).getCandy());
        assertEquals(vaporeon.getIv(), res.get(1).getIv(), 0.0);
    }

    @Test
    public void testGetPokemonsWithComparatorIndex() {
        Mockito.when(iPokedex.getPokemons(PokemonComparators.INDEX)).thenReturn(pokemons);
        assertTrue(iPokedex.getPokemons().isEmpty());

        iPokedex.addPokemon(vaporeon);
        iPokedex.addPokemon(bulbasaur);

        pokemons.add(bulbasaur);
        pokemons.add(vaporeon);


        List<Pokemon> res = iPokedex.getPokemons(PokemonComparators.INDEX);

        assertEquals(bulbasaur.getIndex(), res.get(0).getIndex());
        assertSame(bulbasaur.getName(), res.get(0).getName());
        assertEquals(bulbasaur.getAttack(), res.get(0).getAttack());
        assertEquals(bulbasaur.getDefense(), res.get(0).getDefense());
        assertEquals(bulbasaur.getStamina(), res.get(0).getStamina());
        assertEquals(bulbasaur.getCp(), res.get(0).getCp());
        assertEquals(bulbasaur.getHp(), res.get(0).getHp());
        assertEquals(bulbasaur.getDust(), res.get(0).getDust());
        assertEquals(bulbasaur.getCandy(), res.get(0).getCandy());
        assertEquals(bulbasaur.getIv(), res.get(0).getIv(), 0.0);
        assertEquals(bulbasaur.getIndex(), res.get(0).getIndex());

        assertSame(vaporeon.getName(), res.get(1).getName());
        assertEquals(vaporeon.getAttack(), res.get(1).getAttack());
        assertEquals(vaporeon.getDefense(), res.get(1).getDefense());
        assertEquals(vaporeon.getStamina(), res.get(1).getStamina());
        assertEquals(vaporeon.getCp(), res.get(1).getCp());
        assertEquals(vaporeon.getHp(), res.get(1).getHp());
        assertEquals(vaporeon.getDust(), res.get(1).getDust());
        assertEquals(vaporeon.getCandy(), res.get(1).getCandy());
        assertEquals(vaporeon.getIv(), res.get(1).getIv(), 0.0);
    }

    @Test
    public void testGetPokemonsWithComparatorCP() {
        Mockito.when(iPokedex.getPokemons(PokemonComparators.CP)).thenReturn(pokemons);
        assertTrue(iPokedex.getPokemons().isEmpty());

        iPokedex.addPokemon(vaporeon);
        iPokedex.addPokemon(bulbasaur);

        pokemons.add(bulbasaur);
        pokemons.add(vaporeon);


        List<Pokemon> res = iPokedex.getPokemons(PokemonComparators.CP);

        assertEquals(bulbasaur.getIndex(), res.get(0).getIndex());
        assertSame(bulbasaur.getName(), res.get(0).getName());
        assertEquals(bulbasaur.getAttack(), res.get(0).getAttack());
        assertEquals(bulbasaur.getDefense(), res.get(0).getDefense());
        assertEquals(bulbasaur.getStamina(), res.get(0).getStamina());
        assertEquals(bulbasaur.getCp(), res.get(0).getCp());
        assertEquals(bulbasaur.getHp(), res.get(0).getHp());
        assertEquals(bulbasaur.getDust(), res.get(0).getDust());
        assertEquals(bulbasaur.getCandy(), res.get(0).getCandy());
        assertEquals(bulbasaur.getIv(), res.get(0).getIv(), 0.0);
        assertEquals(bulbasaur.getIndex(), res.get(0).getIndex());

        assertSame(vaporeon.getName(), res.get(1).getName());
        assertEquals(vaporeon.getAttack(), res.get(1).getAttack());
        assertEquals(vaporeon.getDefense(), res.get(1).getDefense());
        assertEquals(vaporeon.getStamina(), res.get(1).getStamina());
        assertEquals(vaporeon.getCp(), res.get(1).getCp());
        assertEquals(vaporeon.getHp(), res.get(1).getHp());
        assertEquals(vaporeon.getDust(), res.get(1).getDust());
        assertEquals(vaporeon.getCandy(), res.get(1).getCandy());
        assertEquals(vaporeon.getIv(), res.get(1).getIv(), 0.0);
    }
}