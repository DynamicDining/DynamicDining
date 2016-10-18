package edu.cvtc.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.cvtc.web.dao.RestaurantDao;
import edu.cvtc.web.dao.impl.RestaurantDaoImpl;
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
			 
			
			final Integer restaurantID = Integer.parseInt(request.getParameter("restaurantID"));
	
			final String author = request.getParameter("author");
			
			final String reviewContent = request.getParameter("reviewContent");
			
			final Integer rating = Integer.parseInt(request.getParameter("rating"));
			
			
			
			if(null != author && !author.isEmpty()
					&& null != reviewContent && !reviewContent.isEmpty()
					&& rating >= 0){ 
				
				
				final Review review = new Review(restaurantID, reviewContent, author,  rating);
				
				System.out.println(review.getId());
				
				System.out.println(review.getAuthor());
				System.out.println(review.getReview());
				
				System.out.println(review.getRating());
				
				final RestaurantDao restaurantDao = new RestaurantDaoImpl();

				restaurantDao.insertReview(review, restaurantID);
				
				request.setAttribute("success", "Success, a new review has been added to the database.");
				target = "success.jsp";
			}else{
				request.setAttribute("error", "Sorry you must complete all fields to add a review to the database");
				target = "error.jsp";
			}
			
			
		} catch (final Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Sorry there was a problem adding this review to the database");
			target = "error.jsp";
		}
			
		
		request.getRequestDispatcher(target).forward(request, response);
	
	}

}
