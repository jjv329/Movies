/**
 * 
 */
package edu.cvtc.web.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author jvollmer
 *
 */
public class DBUtility {
	public static final int TIMEOUT = 30;
	private static final String DRIVER_NAME = "com.pervasive.jdbc.v2.Driver";
	private static final String CONNECTION = "jdbc:pervasive://GlobalERP:1583/DEMODATA";
	
	public static Connection createConnection() throws ClassNotFoundException, SQLException {
		//Register driver for use
		Class.forName(DRIVER_NAME);
				
		//create database connection
		return DriverManager.getConnection(CONNECTION);
		
	}
	
	public static void closeConnections(final Connection connection, final Statement statement){
		try {
			if(connection != null){
				connection.close();
			}
			if(statement != null){
				statement.close();
			}
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}
	
}
