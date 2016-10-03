package edu.cvtc.web.predicates;

import com.google.common.base.Predicate;

import edu.cvtc.web.model.Restaurant;

/**
 * @author Project Skeleton
 *
 */
public class MatchesDirectorPredicate implements Predicate<Restaurant> {
	
	private String director;

	public MatchesDirectorPredicate(final String director) {
		super();
		this.director = director;
	}

	@Override
	public boolean apply(final Restaurant movie) {
		return movie.getDirector().equalsIgnoreCase(director);
	}

}
