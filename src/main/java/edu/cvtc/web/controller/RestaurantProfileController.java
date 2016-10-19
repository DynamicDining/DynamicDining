package edu.cvtc.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.cvtc.web.dao.RestaurantDao;
import edu.cvtc.web.dao.impl.RestaurantDaoImpl;
import edu.cvtc.web.exception.RestaurantReviewDatabaseException;
import edu.cvtc.web.exception.RestaurantSearchException;
import edu.cvtc.web.model.Restaurant;
import edu.cvtc.web.model.Review;
import edu.cvtc.web.search.RestaurantSearch;
import edu.cvtc.web.search.impl.RestaurantSearchImpl;

/**
 * Servlet implementation class RestaurantProfileController.
 */
@WebServlet("/RestaurantProfile")
public class RestaurantProfileController extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * Do post.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String target = null;

		try {
			final RestaurantSearch restaurantSearch = new RestaurantSearchImpl();
			final String name = request.getParameter("name");

			final List<Restaurant> restaurants = restaurantSearch.findRestaurantsByName(name);

			final RestaurantDao restaurantDao = new RestaurantDaoImpl();

			final List<Review> reviews = restaurantDao.retrieveRestaurantReviews(restaurants.get(0).getId());

			request.setAttribute("restaurants", restaurants);
			
			request.setAttribute("reviews", reviews);

			target = "restaurantProfile.jsp";

		} catch (RestaurantSearchException e) {
			e.printStackTrace();
			request.setAttribute("error", "Sorry, we were unable to retrieve this restaurant from the database.");
			target = "error.jsp";
		} catch (RestaurantReviewDatabaseException e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher(target).forward(request, response);

	}

}
