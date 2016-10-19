package edu.cvtc.web.search;

import java.util.List;

import edu.cvtc.web.exception.RestaurantSearchException;
import edu.cvtc.web.model.Restaurant;

/**
 * The Interface RestaurantSearch.
 *
 * @author Project Skeleton
 */
public interface RestaurantSearch {

	/**
	 * Retrieve restaurant list.
	 *
	 * @param sortType the sort type
	 * @return the list
	 * @throws RestaurantSearchException the restaurant search exception
	 */
	List<Restaurant> retrieveRestaurantList(String sortType) throws RestaurantSearchException;

	/**
	 * Find restaurants by name.
	 *
	 * @param title the title
	 * @return the list
	 * @throws RestaurantSearchException the restaurant search exception
	 */
	List<Restaurant> findRestaurantsByName(String title) throws RestaurantSearchException;

}
