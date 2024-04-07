package fr.univavignon.pokedex.api;

/**
 * Trainer POJO.
 *
 * @author fv
 * @version $Id: $Id
 */
public class PokemonTrainer {

	/** Trainer name. **/
	private final String name;

	/** Trainer team. **/
	private final Team team;
	
	/** Trainer pokedex. **/
	private final IPokedex pokedex;
	
	/**
	 * Default constructor.
	 *
	 * @param name Trainer name.
	 * @param team Trainer team.
	 * @param pokedex Trainer pokedex.
	 */
	public PokemonTrainer(final String name, final Team team, final IPokedex pokedex) {
		this.name = name;
		this.team = team;
		this.pokedex = pokedex;
	}
	
	/**
	 * Name getter. *
	 *
	 * @return a {@link java.lang.String} object
	 */
	public String getName() {
		return name;
	}

	/**
	 * Team getter. *
	 *
	 * @return a {@link fr.univavignon.pokedex.api.Team} object
	 */
	public Team getTeam() {
		return team;
	}
	
	/**
	 * Pokedex getter. *
	 *
	 * @return a {@link fr.univavignon.pokedex.api.IPokedex} object
	 */
	public IPokedex getPokedex() {
		return pokedex;
	}
	
}
