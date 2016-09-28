package edu.cvtc.web.comparators;

import java.util.Comparator;

import edu.cvtc.web.model.Movie;

/**
 * @author Project Skeleton
 *
 */
public class LengthInMinutesComparator implements Comparator<Movie> {

	@Override
	public int compare(Movie movie1, Movie movie2) {
		return movie1.getMinutes().compareTo(movie2.getMinutes());
	}

}
