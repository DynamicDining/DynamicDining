package edu.cvtc.web.comparators;

import java.util.Comparator;

import edu.cvtc.web.model.Restaurant;

public class RatingComparator implements Comparator<Restaurant> {

	@Override
	public int compare(Restaurant restaurant1, Restaurant restaurant2) {
		return Double.compare(restaurant2.getRating(), restaurant1.getRating());
	}

}
