package edu.cvtc.web.predicates;

import com.google.common.base.Predicate;

import edu.cvtc.web.model.Restaurant;

/**
 * @author Project Skeleton
 *
 */
public class MatchesTitlePredicate implements Predicate<Restaurant> {

	private String title;
	
	public MatchesTitlePredicate(final String title) {
		super();
		this.title = title;
	}

	@Override
	public boolean apply(final Restaurant movie) {
		return movie.getTitle().toLowerCase().contains(title.toLowerCase());
	}

}
