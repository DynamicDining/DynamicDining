package edu.cvtc.web.dao;

import java.util.List;

import edu.cvtc.web.exception.RestaurantDatabaseException;
import edu.cvtc.web.exception.RestaurantReviewDatabaseException;
import edu.cvtc.web.model.Restaurant;
import edu.cvtc.web.model.Review;

/**
 * @author Project Skeleton
 *
 */
public interface RestaurantDao {

	List<Restaurant> retrieveRestaurants() throws RestaurantDatabaseException;

	List<Restaurant> retrieveRestaurantsByName(String nameToSearchFor) throws RestaurantDatabaseException;

	void populate(String fileName) throws RestaurantDatabaseException;

	List<Review> retrieveRestaurantReviews(int restaurantID) throws RestaurantReviewDatabaseException;

	void insertReview(Review review, int restaurantID) throws RestaurantReviewDatabaseException;

}
