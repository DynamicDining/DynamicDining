package edu.cvtc.web.comparators;

import java.util.Comparator;

import edu.cvtc.web.model.Restaurant;

/**
 * @author Project Skeleton
 *
 */
public class NameComparator implements Comparator<Restaurant> {

	@Override
	public int compare(Restaurant restaurant1, Restaurant restaurant2) {
		return restaurant1.getName().toLowerCase().compareTo(restaurant2.getName().toLowerCase());
	}

}
