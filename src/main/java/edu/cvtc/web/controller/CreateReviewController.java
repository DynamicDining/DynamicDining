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
import edu.cvtc.web.model.Review;

/**
 * Servlet implementation class CreateReviewController
 */
@WebServlet("/CreateReview")
public class CreateReviewController extends HttpServlet {
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

		try {
			final RestaurantDao restaurantDao = new RestaurantDaoImpl();
			final Integer restaurantID = 1;
			final List<Review> review = restaurantDao.retrieveRestaurantReviews(restaurantID);

			request.setAttribute("review", review);

			target = "createReview.jsp";

		} catch (RestaurantReviewDatabaseException e) {
			e.printStackTrace();
			request.setAttribute("error", "Sorry, we were unable to retrieve this restaurant from the database.");
			target = "error.jsp";
		}

		request.getRequestDispatcher(target).forward(request, response);

	}

}
