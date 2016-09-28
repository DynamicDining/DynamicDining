package edu.cvtc.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import edu.cvtc.web.dao.MovieDao;
import edu.cvtc.web.dao.impl.MovieDaoImpl;
import edu.cvtc.web.exception.MovieDatabaseException;

/**
 * Servlet implementation class DeleteMovieController
 */
@WebServlet("/DeleteMovie")
public class DeleteMovieController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MovieDao movieDao = new MovieDaoImpl();
	
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
			
			Map<String, String> movie = new Gson().fromJson(request.getParameter("movieList"), new TypeToken<HashMap<String, String>>() {}.getType());

			final int id = Integer.parseInt(movie.get("id"));

			movieDao.deletePerson(id);
			request.setAttribute("success", "Success, a movie has been deleted from the database.");
			target = "success.jsp";

		} catch (MovieDatabaseException e) {
			e.printStackTrace();
			request.setAttribute("error", "Sorry, there was a problem deleting this movie from the database.");
			target = "error.jsp";
		} catch (NumberFormatException | NullPointerException e) {
			e.printStackTrace();
			request.setAttribute("error", "Error. There are no movies to delete.");
			target = "error.jsp";
		}
		
		request.getRequestDispatcher(target).forward(request, response);
	}

}
