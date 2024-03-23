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
        iPokedex = new Pokedex();
        bulbasaur = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        vaporeon = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);
    }

    @Test
    public void testSize() {
        assertEquals(0, iPokedex.size());
        iPokedex.addPokemon(bulbasaur);
        assertEquals(1, iPokedex.size());
        iPokedex.addPokemon(vaporeon);
        assertEquals(2, iPokedex.size());
    }

    @Test
    public void testAddPokemon() throws PokedexException {
        iPokedex.addPokemon(bulbasaur);
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
        assertThrows(PokedexException.class, () -> iPokedex.getPokemon(-1));
        iPokedex.addPokemon(bulbasaur);
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
    public void testGetPokemons() {
        assertTrue(iPokedex.getPokemons().isEmpty());

        iPokedex.addPokemon(bulbasaur);

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
        assertTrue(iPokedex.getPokemons().isEmpty());

        iPokedex.addPokemon(bulbasaur);
        iPokedex.addPokemon(vaporeon);


        List<Pokemon> res = iPokedex.getPokemons(PokemonComparators.NAME);

        assertEquals(vaporeon.getIndex(), res.get(0).getIndex());
        assertSame(vaporeon.getName(), res.get(0).getName());
        assertEquals(vaporeon.getAttack(), res.get(0).getAttack());
        assertEquals(vaporeon.getDefense(), res.get(0).getDefense());
        assertEquals(vaporeon.getStamina(), res.get(0).getStamina());
        assertEquals(vaporeon.getCp(), res.get(0).getCp());
        assertEquals(vaporeon.getHp(), res.get(0).getHp());
        assertEquals(vaporeon.getDust(), res.get(0).getDust());
        assertEquals(vaporeon.getCandy(), res.get(0).getCandy());
        assertEquals(vaporeon.getIv(), res.get(0).getIv(), 0.0);
        assertEquals(vaporeon.getIndex(), res.get(0).getIndex());

        assertEquals(bulbasaur.getIndex(), res.get(1).getIndex());
        assertSame(bulbasaur.getName(), res.get(1).getName());
        assertEquals(bulbasaur.getAttack(), res.get(1).getAttack());
        assertEquals(bulbasaur.getDefense(), res.get(1).getDefense());
        assertEquals(bulbasaur.getStamina(), res.get(1).getStamina());
        assertEquals(bulbasaur.getCp(), res.get(1).getCp());
        assertEquals(bulbasaur.getHp(), res.get(1).getHp());
        assertEquals(bulbasaur.getDust(), res.get(1).getDust());
        assertEquals(bulbasaur.getCandy(), res.get(1).getCandy());
        assertEquals(bulbasaur.getIv(), res.get(1).getIv(), 0.0);
    }

    @Test
    public void testGetPokemonsWithComparatorIndex() {
        assertTrue(iPokedex.getPokemons().isEmpty());

        iPokedex.addPokemon(vaporeon);
        iPokedex.addPokemon(bulbasaur);

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
        assertTrue(iPokedex.getPokemons().isEmpty());

        iPokedex.addPokemon(vaporeon);
        iPokedex.addPokemon(bulbasaur);

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
    @Test
    public void testCreatePokemon() throws PokedexException {
        Pokemon bulbasaur = new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000,4,0);
        Pokemon res = iPokedex.createPokemon(0,613,64,4000,4);
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
    }

    @Test
    public void getPokemonMetadata() throws PokedexException {
        PokemonMetadata res = iPokedex.getPokemonMetadata(0);
        assertEquals(bulbasaur.getIndex(), res.getIndex());
        assertSame(bulbasaur.getName(), res.getName());
        assertEquals(bulbasaur.getAttack(), res.getAttack());
        assertEquals(bulbasaur.getDefense(), res.getDefense());
        assertEquals(bulbasaur.getStamina(), res.getStamina());
        assertThrows(PokedexException.class, () -> iPokedex.getPokemonMetadata(-1));
        assertThrows(PokedexException.class, () -> iPokedex.getPokemonMetadata(151));
    }
}