package edu.cvtc.web.dao;

import java.util.List;

import edu.cvtc.web.exception.MovieDatabaseException;
import edu.cvtc.web.model.Movie;

/**
 * @author Project Skeleton
 *
 */
public interface MovieDao {

	List<Movie> retrieveMovies() throws MovieDatabaseException;

	List<Movie> retrieveMoviesByTitle(String titleToSearchFor) throws MovieDatabaseException;

	List<Movie> retrieveMoviesByDirector(String directorToSearchFor) throws MovieDatabaseException;

	void populate(String fileName) throws MovieDatabaseException;

	void insertMovie(Movie movie) throws MovieDatabaseException;

	int deletePerson(int id) throws MovieDatabaseException;

	int updateMovie(Movie movie) throws MovieDatabaseException;

}
