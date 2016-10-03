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
 * Servlet implementation class UpdateMovieController
 */
@WebServlet("/UpdateMovie")
public class UpdateMovieController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RestaurantDao movieDao = new MovieDaoImpl();
	
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
		
		boolean isValidData = StringUtils.isNotEmpty(request.getParameter("title")) &&
			  	  			  StringUtils.isNotEmpty(request.getParameter("director")) &&
			  	  			  StringUtils.isNotEmpty(request.getParameter("star_1")) &&
			  	  			  StringUtils.isNotEmpty(request.getParameter("star_2")) &&
			  	  			  StringUtils.isNotEmpty(request.getParameter("star_3")) &&
			  	  			  StringUtils.isANumber(request.getParameter("minutes"));
		
		if (isValidData) {
			try {
				final int id = Integer.parseInt(request.getParameter("id"));
				final String title = request.getParameter("title");
				final String director = request.getParameter("director");
				final int minutes = Integer.parseInt(request.getParameter("minutes"));
				final String star1 = request.getParameter("star_1");
				final String star2 = request.getParameter("star_2");
				final String star3 = request.getParameter("star_3");
				
				final List<Star> stars = new ArrayList<>();
				stars.add(new Star(star1));
				stars.add(new Star(star2));
				stars.add(new Star(star3));
				
				final Restaurant movie = new Restaurant(id, title, director, minutes, stars);
				
				movieDao.updateMovie(movie);
				
				request.setAttribute("success", "Success, this movie has been updated in the database.");
				target = "success.jsp";
				
			} catch (RestaurantDatabaseException e) {
				e.printStackTrace();
				request.setAttribute("error", "Sorry, there was a problem updating this movie in the database.");
				target = "error.jsp";
				
			} catch (NumberFormatException e2) {
				e2.printStackTrace();
				request.setAttribute("error", "Sorry, there is no movie selected.");
				target = "error.jsp";
			}
			
		} else {
			request.setAttribute("error", "Sorry, invalid input provided.");
			target = "error.jsp";
		}

		request.getRequestDispatcher(target).forward(request, response);
	}
	
}
