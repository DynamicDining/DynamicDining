package edu.cvtc.web.comparators;

import java.util.Comparator;

import edu.cvtc.web.model.Restaurant;

/**
 * @author Project Skeleton
 *
 */
public class LengthInMinutesComparator implements Comparator<Restaurant> {

	@Override
	public int compare(Restaurant movie1, Restaurant movie2) {
		return movie1.getMinutes().compareTo(movie2.getMinutes());
	}

}
