package edu.cvtc.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.cvtc.web.exception.RestaurantSearchException;
import edu.cvtc.web.model.Restaurant;
import edu.cvtc.web.search.RestaurantSearch;
import edu.cvtc.web.search.impl.RestaurantSearchImpl;
import edu.cvtc.web.util.StringUtils;

/**
 * Servlet implementation class SearchByTitleController
 */
@WebServlet("/SearchByName")
public class SearchByNameController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String target = null;

		if (StringUtils.isNotEmpty(request.getParameter("title"))) {
			try {
				final String title = request.getParameter("title");
				final RestaurantSearch restaurantSearch = new RestaurantSearchImpl();
				final List<Restaurant> movies = restaurantSearch.findRestaurantsByName(title);

				if (movies.isEmpty()) {
					throw new RestaurantSearchException("");
				}

				request.setAttribute("movies", movies);

				target = "view-all.jsp";

			} catch (RestaurantSearchException e) {
				e.printStackTrace();
				request.setAttribute("error", "Sorry, we were unable to find a movie with that title.");
				target = "error.jsp";
			}

		} else {
			request.setAttribute("error", "Sorry, invalid input provided.");
			target = "error.jsp";
		}

		request.getRequestDispatcher(target).forward(request, response);
	}

}
