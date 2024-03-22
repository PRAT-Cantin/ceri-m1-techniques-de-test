package fr.univavignon.pokedex.api;

public class PokemonFactory implements IPokemonFactory {
    private PokemonMetadataProvider pokemonMetadataProvider;

    public PokemonFactory() {
        this.pokemonMetadataProvider = new PokemonMetadataProvider();
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException {
        PokemonMetadata pokemon = pokemonMetadataProvider.getPokemonMetadata(index);
        return new Pokemon(pokemon.getIndex(),pokemon.getName(),pokemon.getAttack(),pokemon.getDefense(),pokemon.getStamina(),cp,hp,dust,candy,0);
    }
}
