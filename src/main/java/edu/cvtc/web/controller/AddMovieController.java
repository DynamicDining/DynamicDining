package edu.cvtc.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.cvtc.web.dao.RestaurantDao;
import edu.cvtc.web.dao.impl.MovieDaoImpl;
import edu.cvtc.web.exception.RestaurantDatabaseException;
import edu.cvtc.web.model.Restaurant;
import edu.cvtc.web.model.Star;
import edu.cvtc.web.util.StringUtils;

/**
 * Servlet implementation class AddMovieController
 */
@WebServlet("/AddMovie")
public class AddMovieController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RestaurantDao movieDao = new MovieDaoImpl();

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

		boolean isValidData = StringUtils.isNotEmpty(request.getParameter("title"))
				&& StringUtils.isNotEmpty(request.getParameter("director"))
				&& StringUtils.isNotEmpty(request.getParameter("actor_1"))
				&& StringUtils.isNotEmpty(request.getParameter("actor_2"))
				&& StringUtils.isNotEmpty(request.getParameter("actor_3"))
				&& StringUtils.isANumber(request.getParameter("minutes"));

		if (isValidData) {
			try {
				final String title = request.getParameter("title");
				final String director = request.getParameter("director");
				final int minutes = Integer.parseInt(request.getParameter("minutes"));
				final String actor1 = request.getParameter("actor_1");
				final String actor2 = request.getParameter("actor_2");
				final String actor3 = request.getParameter("actor_3");

				final List<Star> stars = new ArrayList<>();
				stars.add(new Star(actor1));
				stars.add(new Star(actor2));
				stars.add(new Star(actor3));

				final Restaurant movie = new Restaurant(title, director, minutes, stars);

				movieDao.insertMovie(movie);

				request.setAttribute("success", "Success, a new movie has been added to the database.");
				target = "success.jsp";

			} catch (RestaurantDatabaseException e) {
				e.printStackTrace();
				request.setAttribute("error", "Sorry, there was a problem adding this movie to the database.");
				target = "error.jsp";
			}

		} else {
			request.setAttribute("error", "Sorry, invalid input provided.");
			target = "error.jsp";
		}

		request.getRequestDispatcher(target).forward(request, response);
	}

}
