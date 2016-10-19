package edu.cvtc.web.comparators;

import java.util.Comparator;

import edu.cvtc.web.model.Restaurant;

/**
 * The Class NameComparator.
 *
 * @author Project Skeleton
 */
public class NameComparator implements Comparator<Restaurant> {

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Restaurant restaurant1, Restaurant restaurant2) {
		return restaurant1.getName().toLowerCase().compareTo(restaurant2.getName().toLowerCase());
	}

}
