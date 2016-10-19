package edu.cvtc.web.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * The Class DBUtils.
 *
 * @author Project Skeleton
 */
public class DBUtils {

	/** The Constant TIMEOUT. */
	public static final int TIMEOUT = 30;
	
	/** The Constant DATABASE_NAME. */
	public static final String DATABASE_NAME = "restaurants.db";
	
	/** The Constant CONNECTION. */
	public static final String CONNECTION = "jdbc:sqlite:" + DATABASE_NAME;

	/** The Constant DRIVER_NAME. */
	private static final String DRIVER_NAME = "org.sqlite.JDBC";

	/**
	 * Creates the connection.
	 *
	 * @param connection the connection
	 * @return the connection
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	public static Connection createConnection(final String connection) throws ClassNotFoundException, SQLException {
		// register the driver
		Class.forName(DRIVER_NAME);

		// create a database connection
		return DriverManager.getConnection(connection);
	}

	/**
	 * Close connections.
	 *
	 * @param connection the connection
	 * @param statement the statement
	 */
	public static void closeConnections(final Connection connection, final Statement statement) {
		try {
			if (null != connection) {
				connection.close();
			}
			if (null != statement) {
				statement.close();
			}
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

}
