package edu.cvtc.web.predicates;

import com.google.common.base.Predicate;

import edu.cvtc.web.model.Movie;

/**
 * @author Project Skeleton
 *
 */
public class MatchesTitlePredicate implements Predicate<Movie> {

	private String title;
	
	public MatchesTitlePredicate(final String title) {
		super();
		this.title = title;
	}

	@Override
	public boolean apply(final Movie movie) {
		return movie.getTitle().toLowerCase().contains(title.toLowerCase());
	}

}
