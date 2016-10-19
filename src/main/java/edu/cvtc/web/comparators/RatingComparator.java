package edu.cvtc.web.comparators;

import java.util.Comparator;

import edu.cvtc.web.model.Restaurant;

/**
 * The Class RatingComparator.
 */
public class RatingComparator implements Comparator<Restaurant> {

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Restaurant restaurant1, Restaurant restaurant2) {
		return Double.compare(restaurant2.getRating(), restaurant1.getRating());
	}

}
