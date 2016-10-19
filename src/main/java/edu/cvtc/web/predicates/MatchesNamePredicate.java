package edu.cvtc.web.predicates;

import com.google.common.base.Predicate;

import edu.cvtc.web.model.Restaurant;

/**
 * The Class MatchesNamePredicate.
 *
 * @author Project Skeleton
 */
public class MatchesNamePredicate implements Predicate<Restaurant> {

	/** The name. */
	private String name;
	
	/**
	 * Instantiates a new matches name predicate.
	 *
	 * @param name the name
	 */
	public MatchesNamePredicate(final String name) {
		super();
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see com.google.common.base.Predicate#apply(java.lang.Object)
	 */
	@Override
	public boolean apply(final Restaurant restaurant) {
		return restaurant.getName().toLowerCase().contains(name.toLowerCase());
	}

}
