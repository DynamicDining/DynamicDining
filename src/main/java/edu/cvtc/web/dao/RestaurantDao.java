package edu.cvtc.web.dao;

import java.util.List;

import edu.cvtc.web.exception.RestaurantDatabaseException;
import edu.cvtc.web.exception.RestaurantReviewDatabaseException;
import edu.cvtc.web.model.Restaurant;
import edu.cvtc.web.model.Review;

/**
 * The Interface RestaurantDao.
 *
 * @author Project Skeleton
 */
public interface RestaurantDao {

	/**
	 * Retrieve restaurants.
	 *
	 * @return the list
	 * @throws RestaurantDatabaseException the restaurant database exception
	 */
	List<Restaurant> retrieveRestaurants() throws RestaurantDatabaseException;

	/**
	 * Retrieve restaurants by name.
	 *
	 * @param nameToSearchFor the name to search for
	 * @return the list
	 * @throws RestaurantDatabaseException the restaurant database exception
	 */
	List<Restaurant> retrieveRestaurantsByName(String nameToSearchFor) throws RestaurantDatabaseException;

	/**
	 * Populate.
	 *
	 * @param fileName the file name
	 * @throws RestaurantDatabaseException the restaurant database exception
	 */
	void populate(String fileName) throws RestaurantDatabaseException;

	/**
	 * Retrieve restaurant reviews.
	 *
	 * @param restaurantID the restaurant ID
	 * @return the list
	 * @throws RestaurantReviewDatabaseException the restaurant review database exception
	 */
	List<Review> retrieveRestaurantReviews(int restaurantID) throws RestaurantReviewDatabaseException;

	/**
	 * Insert review.
	 *
	 * @param review the review
	 * @param restaurantID the restaurant ID
	 * @throws RestaurantReviewDatabaseException the restaurant review database exception
	 */
	void insertReview(Review review, int restaurantID) throws RestaurantReviewDatabaseException;

}
