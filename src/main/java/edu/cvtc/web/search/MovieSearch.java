package edu.cvtc.web.search;

import java.util.List;

import edu.cvtc.web.exception.MovieSearchException;
import edu.cvtc.web.model.Restaurant;

/**
 * @author Project Skeleton
 *
 */
public interface MovieSearch {

	List<Restaurant> retrieveMovieList(String sortType) throws MovieSearchException;

	List<Restaurant> findMoviesByTitle(String title) throws MovieSearchException;

	List<Restaurant> findMoviesByDirector(String director) throws MovieSearchException;

}
