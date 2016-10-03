package edu.cvtc.web.search;

import java.util.List;

import edu.cvtc.web.exception.RestaurantSearchException;
import edu.cvtc.web.model.Restaurant;

/**
 * @author Project Skeleton
 *
 */
public interface RestaurantSearch {

	List<Restaurant> retrieveRestaurantList(String sortType) throws RestaurantSearchException;

	List<Restaurant> findRestaurantsByName(String title) throws RestaurantSearchException;

}
