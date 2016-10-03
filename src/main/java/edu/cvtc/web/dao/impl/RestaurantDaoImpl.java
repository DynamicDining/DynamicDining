package edu.cvtc.web.dao.impl;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.cvtc.web.dao.RestaurantDao;
import edu.cvtc.web.exception.RestaurantDatabaseException;
import edu.cvtc.web.exception.RestaurantReviewDatabaseException;
import edu.cvtc.web.model.Restaurant;
import edu.cvtc.web.model.Review;
import edu.cvtc.web.util.DBUtils;
import edu.cvtc.web.util.WorkBookUtility;

/**
 * @author Project Skeleton
 *
 */
public class RestaurantDaoImpl implements RestaurantDao {

	private static final String DROP_TABLE_RESTAURANT = "drop table if exists restaurant";
	private static final String DROP_TABLE_REVIEW = "drop table if exists review";
	private static final String CREATE_TABLE_RESTAURANT = "create table restaurant (restaurantID integer primary key autoincrement, name text, address text, city text, state text, zipCode text, telephoneNumber text, website text);";
	private static final String CREATE_TABLE_REVIEW = "create table review (reviewID integer primary key autoincrement, restaurantID, review text, author text, rating integer, foreign key(restaurantID) references restaurant(restaurantID));";
	private static final String SELECT_FROM_RESTAURANT = "select * from restaurant";

	@Override
	public List<Review> retrieveRestaurantReviews(int restaurantID) throws RestaurantReviewDatabaseException {
		final List<Review> reviews = new ArrayList<Review>();
		Connection connection = null;
		Statement statement = null;

		try {
			connection = DBUtils.createConnection(DBUtils.CONNECTION);
			statement = connection.createStatement();
			statement.setQueryTimeout(DBUtils.TIMEOUT);

			final ResultSet results = statement
					.executeQuery("select * from review where restaurantID = '" + restaurantID + "'");
			buildReviewList(reviews, results);
		} catch (final Exception e) {
			e.printStackTrace();
			throw new RestaurantReviewDatabaseException("Error retrieving reviews.");
		} finally {
			DBUtils.closeConnections(connection, statement);
		}

		return reviews;
	}

	@Override
	public List<Restaurant> retrieveRestaurants() throws RestaurantDatabaseException {
		final List<Restaurant> restaurants = new ArrayList<Restaurant>();
		Connection connection = null;
		Statement statement = null;

		try {
			connection = DBUtils.createConnection(DBUtils.CONNECTION);
			statement = connection.createStatement();
			statement.setQueryTimeout(DBUtils.TIMEOUT);

			final ResultSet results = statement.executeQuery(SELECT_FROM_RESTAURANT);
			buildRestaurantList(restaurants, results);

			results.close();

		} catch (final Exception e) {
			e.printStackTrace();
			throw new RestaurantDatabaseException("Error selecting restaurants from database.");
		} finally {
			DBUtils.closeConnections(connection, statement);
		}

		return restaurants;
	}

	@Override
	public List<Restaurant> retrieveRestaurantsByName(final String nameToSearchFor) throws RestaurantDatabaseException {
		final List<Restaurant> restaurants = new ArrayList<Restaurant>();
		Connection connection = null;
		Statement statement = null;

		try {
			connection = DBUtils.createConnection(DBUtils.CONNECTION);
			statement = connection.createStatement();
			statement.setQueryTimeout(DBUtils.TIMEOUT);

			final String sql = "select * from restaurant where name = '" + nameToSearchFor + "'";
			final ResultSet results = statement.executeQuery(sql);

			buildRestaurantList(restaurants, results);

			results.close();

		} catch (final Exception e) {
			e.printStackTrace();
			throw new RestaurantDatabaseException("Error retrieving restaurants by name.");
		} finally {
			DBUtils.closeConnections(connection, statement);
		}

		return restaurants;
	}

	private void buildRestaurantList(final List<Restaurant> restaurants, final ResultSet results)
			throws SQLException, RestaurantDatabaseException {
		while (results.next()) {

			final int id = results.getInt("restaurantID");

			final double rating = calculateRestaurantRating(id);
			final String name = results.getString("name");
			final String address = results.getString("address");
			final String city = results.getString("city");
			final String state = results.getString("state");
			final String zipCode = results.getString("zipCode");
			final String telephoneNumber = results.getString("telephoneNumber");
			final String website = results.getString("website");

			final Restaurant restaurant = new Restaurant(id, name, address, city, state, zipCode, telephoneNumber,
					website, rating);
			restaurants.add(restaurant);
		}
	}

	private double calculateRestaurantRating(int restaurantID) throws RestaurantDatabaseException {
		Connection connection = null;
		Statement statement = null;
		double goodRatingsPercentage;

		try {
			connection = DBUtils.createConnection(DBUtils.CONNECTION);
			statement = connection.createStatement();

			statement.setQueryTimeout(DBUtils.TIMEOUT);

			final String sql = "select count(restaurantID) as total, sum(rating) as goodRatings from review";
			final ResultSet results = statement.executeQuery(sql);

			final int goodRatings = results.getInt("goodRatings");
			final int totalRatings = results.getInt("total");
			goodRatingsPercentage = totalRatings != 0
					? Math.round(((double) goodRatings / totalRatings) * 100.0) / 100.0 : totalRatings;

		} catch (final Exception e) {
			e.printStackTrace();
			throw new RestaurantDatabaseException("Sorry, no rating.");
		}

		return goodRatingsPercentage;
	}

	private void buildReviewList(final List<Review> reviews, final ResultSet results) throws SQLException {
		while (results.next()) {
			final int id = results.getInt("reviewID");
			final String author = results.getString("author");
			final String dbReview = results.getString("review");
			final int rating = results.getInt("rating");

			final Review review = new Review(id, dbReview, author, rating);
			reviews.add(review);
		}
	}

	@Override
	public void populate(final String filePath) throws RestaurantDatabaseException {
		Connection connection = null;
		Statement statement = null;
		PreparedStatement insertStatement = null;

		try {
			connection = DBUtils.createConnection(DBUtils.CONNECTION);
			statement = connection.createStatement();

			statement.setQueryTimeout(DBUtils.TIMEOUT);
			statement.executeUpdate(DROP_TABLE_RESTAURANT);
			statement.executeUpdate(DROP_TABLE_REVIEW);
			statement.executeUpdate(CREATE_TABLE_RESTAURANT);
			statement.executeUpdate(CREATE_TABLE_REVIEW);

			final List<Restaurant> restaurants = WorkBookUtility.retrieveRestaurantsFromWorkBook(new File(filePath));

			for (final Restaurant restaurant : restaurants) {

				final String insert = "insert into restaurant (name, address, city, state, zipCode, telephoneNumber, website) values (?,?,?,?,?,?,?)";
				insertStatement = connection.prepareStatement(insert);

				insertStatement.setString(1, restaurant.getName());
				insertStatement.setString(2, restaurant.getAddress());
				insertStatement.setString(3, restaurant.getCity());
				insertStatement.setString(4, restaurant.getState());
				insertStatement.setString(5, restaurant.getZipCode());
				insertStatement.setString(6, restaurant.getTelephoneNumber());
				insertStatement.setString(7, restaurant.getWebsite());

				insertStatement.setQueryTimeout(DBUtils.TIMEOUT);

				insertStatement.executeUpdate();
			}
		} catch (final Exception e) {
			e.printStackTrace();
			throw new RestaurantDatabaseException("Error encountered while populating database.");
		} finally {
			DBUtils.closeConnections(connection, statement);
		}
	}

	@Override
	public void insertReview(Review review, int restaurantID) throws RestaurantReviewDatabaseException {
		Connection connection = null;
		PreparedStatement insertStatement = null;

		try {
			connection = DBUtils.createConnection(DBUtils.CONNECTION);

			final String insert = "insert into review (restaurantID, review, author, rating) values (?,?,?,?)";
			insertStatement = connection.prepareStatement(insert);

			insertStatement.setInt(1, restaurantID);
			insertStatement.setString(2, review.getReview());
			insertStatement.setString(3, review.getAuthor());
			insertStatement.setInt(4, review.getRating());

			insertStatement.setQueryTimeout(DBUtils.TIMEOUT);

			insertStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RestaurantReviewDatabaseException("Error inserting review into database.");
		}
	}

}
