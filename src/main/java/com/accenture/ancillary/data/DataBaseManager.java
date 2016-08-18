package com.accenture.ancillary.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class DataBaseManager {
	
	private static final Logger logger = Logger.getLogger(DataBaseManager.class);
//	private static final String DB_JNDI_NAME = "java:/comp/env/jdbc/TasksDB";
	
	// change this to whatever your DSN is
//	private static final String dbURL = "jdbc:mysql://localhost:3306/library";
	private static final String dbURL = "jdbc:mysql://localhost:3306/swu";

	/*
	 * This method will return a connection object
	 */
	public static Connection getConnection() {
		Connection conn = null;

		 try {
	         Class.forName("com.mysql.jdbc.Driver");
	         conn = DriverManager.getConnection(dbURL, "root", "mysql");
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
		return conn;
	}

	/*
	 * This method will close the connection
	 */
	public static void closeConnection(Connection con) {
		try {
			if(con != null)
			con.close();
		} catch (SQLException e) {
			logger.debug("Failed to close connection");
			logger.error(e);
		}
	}

	/*
	 * This method will close the connection
	 */
	public static void closeStatement(PreparedStatement pre) {
		try {
			if(pre != null)
			pre.close();
		} catch (SQLException e) {
			logger.debug("Failed to close Statement");
			logger.error(e);
		}
	}

	/*
	 * This method will close the connection
	 */
	public static void closeResultSet(ResultSet rs) {
		try {
			if(rs != null)
			rs.close();
		} catch (SQLException e) {
			logger.debug("Failed to close resultset");
			logger.error(e);
		}
	}

}
