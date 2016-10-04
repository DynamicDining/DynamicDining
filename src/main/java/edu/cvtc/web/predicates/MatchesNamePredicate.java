package edu.cvtc.web.predicates;

import com.google.common.base.Predicate;

import edu.cvtc.web.model.Restaurant;

/**
 * @author Project Skeleton
 *
 */
public class MatchesNamePredicate implements Predicate<Restaurant> {

	private String title;
	
	public MatchesNamePredicate(final String title) {
		super();
		this.title = title;
	}

	@Override
	public boolean apply(final Restaurant restaurant) {
		return restaurant.getName().toLowerCase().contains(title.toLowerCase());
	}

}
