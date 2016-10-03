package edu.cvtc.web.dao;

import java.util.List;

import edu.cvtc.web.exception.RestaurantDatabaseException;
import edu.cvtc.web.model.Restaurant;

/**
 * @author Project Skeleton
 *
 */
public interface RestaurantDao {

	List<Restaurant> retrieveRestaurants() throws RestaurantDatabaseException;

	List<Restaurant> retrieveRestaurantsByName(String nameToSearchFor) throws RestaurantDatabaseException;

	void populate(String fileName) throws RestaurantDatabaseException;

	// int deleteComment(int id) throws RestaurantDatabaseException;

}
