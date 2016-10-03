package edu.cvtc.web.search.impl;

import java.util.Collections;
import java.util.List;

import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

import edu.cvtc.web.comparators.LengthInMinutesComparator;
import edu.cvtc.web.comparators.SortBy;
import edu.cvtc.web.comparators.TitleComparator;
import edu.cvtc.web.dao.RestaurantDao;
import edu.cvtc.web.dao.impl.MovieDaoImpl;
import edu.cvtc.web.exception.RestaurantDatabaseException;
import edu.cvtc.web.exception.MovieSearchException;
import edu.cvtc.web.model.Restaurant;
import edu.cvtc.web.predicates.MatchesDirectorPredicate;
import edu.cvtc.web.predicates.MatchesTitlePredicate;
import edu.cvtc.web.search.MovieSearch;

/**
 * @author Project Skeleton
 *
 */
public class MovieSearchImpl implements MovieSearch {
	
	private RestaurantDao movieDao = new MovieDaoImpl();

	@Override
	public List<Restaurant> retrieveMovieList(final String sortType) throws MovieSearchException {
		try {
			final List<Restaurant> movies = retrieveMoviesFromDatabase();
			if (null != sortType) {
				sortMovies(movies, sortType);
			}
			return movies;
		} catch (final Exception e) {
			e.printStackTrace();
			throw new MovieSearchException("Error retrieving movie list.");
		}
	}

	private void sortMovies(final List<Restaurant> movies, final String sortType) {
		switch (sortType) {
			case SortBy.TITLE:
				Collections.sort(movies, new TitleComparator());
				break;
			case SortBy.LENGTH:
				Collections.sort(movies, new LengthInMinutesComparator());
				break;
			default:
				break;
		}
	}
	
	@Override
	public List<Restaurant> findMoviesByTitle(final String title) throws MovieSearchException {
		try {
			final List<Restaurant> movies = retrieveMoviesFromDatabase();
			return Lists.newArrayList(Collections2.filter(movies, new MatchesTitlePredicate(title)));
		} catch (final Exception e) {
			e.printStackTrace();
			throw new MovieSearchException("Error finding movies by title.");
		}
	}
	
	@Override
	public List<Restaurant> findMoviesByDirector(final String director) throws MovieSearchException {
		try {
			final List<Restaurant> movies = retrieveMoviesFromDatabase();
			return Lists.newArrayList(Collections2.filter(movies, new MatchesDirectorPredicate(director)));
		} catch (final Exception e) {
			e.printStackTrace();
			throw new MovieSearchException("Error finding movies by director.");
		}
	}

	private List<Restaurant> retrieveMoviesFromDatabase() throws RestaurantDatabaseException {
		return movieDao.retrieveMovies();
	}

}
