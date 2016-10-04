package edu.cvtc.web.search.impl;

import java.util.Collections;
import java.util.List;

import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

import edu.cvtc.web.comparators.NameComparator;
import edu.cvtc.web.comparators.RatingComparator;
import edu.cvtc.web.comparators.SortBy;
import edu.cvtc.web.dao.RestaurantDao;
import edu.cvtc.web.dao.impl.RestaurantDaoImpl;
import edu.cvtc.web.exception.RestaurantDatabaseException;
import edu.cvtc.web.exception.RestaurantSearchException;
import edu.cvtc.web.model.Restaurant;
import edu.cvtc.web.predicates.MatchesNamePredicate;
import edu.cvtc.web.search.RestaurantSearch;

/**
 * @author Project Skeleton
 *
 */
public class RestaurantSearchImpl implements RestaurantSearch {

	private RestaurantDao restaurantDao = new RestaurantDaoImpl();

	@Override
	public List<Restaurant> retrieveRestaurantList(final String sortType) throws RestaurantSearchException {
		try {
			final List<Restaurant> restaurants = retrieveRestaurantsFromDatabase();
			if (null != sortType) {
				sortRestaurants(restaurants, sortType);
			}
			return restaurants;
		} catch (final Exception e) {
			e.printStackTrace();
			throw new RestaurantSearchException("Error retrieving restaurant list.");
		}
	}

	private void sortRestaurants(final List<Restaurant> restaurants, final String sortType) {
		switch (sortType) {
		case SortBy.NAME:
			Collections.sort(restaurants, new NameComparator());
			break;
		case SortBy.RATING:
			Collections.sort(restaurants, new RatingComparator());
		default:
			break;
		}
	}

	@Override
	public List<Restaurant> findRestaurantsByName(final String name) throws RestaurantSearchException {
		try {
			final List<Restaurant> restaurants = retrieveRestaurantsFromDatabase();
			return Lists.newArrayList(Collections2.filter(restaurants, new MatchesNamePredicate(name)));
		} catch (final Exception e) {
			e.printStackTrace();
			throw new RestaurantSearchException("Error finding restaurants by name.");
		}
	}

	private List<Restaurant> retrieveRestaurantsFromDatabase() throws RestaurantDatabaseException {
		return restaurantDao.retrieveRestaurants();
	}

}
