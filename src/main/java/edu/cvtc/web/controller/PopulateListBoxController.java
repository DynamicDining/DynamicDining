package edu.cvtc.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.cvtc.web.comparators.SortBy;
import edu.cvtc.web.exception.RestaurantSearchException;
import edu.cvtc.web.model.Restaurant;
import edu.cvtc.web.search.RestaurantSearch;
import edu.cvtc.web.search.impl.MovieSearchImpl;

/**
 * Servlet implementation class PopulateListBoxController
 */
@WebServlet("/PopulateListBox")
public class PopulateListBoxController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String target = null;
		
		try {
			final RestaurantSearch movieSearch = new MovieSearchImpl();
			final List<Restaurant> movies = movieSearch.retrieveMovieList(SortBy.TITLE);
			
			request.setAttribute("movies", movies);
			
			target = "edit-movie.jsp";
			
		} catch (RestaurantSearchException e){
			e.printStackTrace();
			request.setAttribute("error", "Sorry, we were unable to retrieve a list of movies from the database.");
			target = "error.jsp";
		}
		
		request.getRequestDispatcher(target).forward(request, response);
	}

}
