package edu.cvtc.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.cvtc.web.dao.RestaurantDao;
import edu.cvtc.web.dao.impl.RestaurantDaoImpl;
import edu.cvtc.web.exception.RestaurantDatabaseException;

/**
 * Servlet implementation class PopulateDatabaseController.
 */
@WebServlet("/PopulateDatabase")
public class PopulateDatabaseController extends HttpServlet {
	
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
	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
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
	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		String target = null;
		try {
			final RestaurantDao restaurantDao = new RestaurantDaoImpl();
			final String fileName = request.getSession().getServletContext()
					.getRealPath("/assets/spreadsheets/Restaurants.xlsx");
			restaurantDao.populate(fileName);
			request.setAttribute("success", "Database successfully populated.");
			target = "success.jsp";
		} catch (final RestaurantDatabaseException e) {
			e.printStackTrace();
			request.setAttribute("error", "Sorry, we were unable to complete your request.");
			target = "error.jsp";
		}

		final RequestDispatcher view = request.getRequestDispatcher(target);
		view.forward(request, response);
	}

}
