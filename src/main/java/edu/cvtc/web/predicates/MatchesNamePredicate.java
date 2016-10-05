package edu.cvtc.web.predicates;

import com.google.common.base.Predicate;

import edu.cvtc.web.model.Restaurant;

/**
 * @author Project Skeleton
 *
 */
public class MatchesNamePredicate implements Predicate<Restaurant> {

	private String name;
	
	public MatchesNamePredicate(final String name) {
		super();
		this.name = name;
	}

	@Override
	public boolean apply(final Restaurant restaurant) {
		return restaurant.getName().toLowerCase().contains(name.toLowerCase());
	}

}
