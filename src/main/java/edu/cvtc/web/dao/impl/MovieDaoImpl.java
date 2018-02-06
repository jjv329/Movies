/**
 * 
 */
package edu.cvtc.web.dao.impl;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import edu.cvtc.web.dao.MovieDao;
import edu.cvtc.web.model.Movie;
import edu.cvtc.web.util.DBUtility;
import edu.cvtc.web.util.WorkbookUtility;

/**
 * @author jvollmer
 *
 */
public class MovieDaoImpl implements MovieDao{
	
	private static final String SELECT_ALL_FROM_MOVIES = "SELECT *  FROM movies;";
	private static final String DROP_TABLE_MOVIES = "drop table movies;";
	private static final String CREATE_TABLE_MOVIES = "CREATE TABLE movies(id IDENTITY DEFAULT '0',title VARCHAR(50),director VARCHAR(50),length INTEGER,UNIQUE (id));";
	
	@Override
	public void populate(String filePath) throws MovieDaoException {
		
		Connection connection = null;
		Statement statement = null;
		
		try {
			connection = DBUtility.createConnection();
			statement = connection.createStatement();
			
			statement.setQueryTimeout(DBUtility.TIMEOUT);
			
			statement.executeUpdate(DROP_TABLE_MOVIES);
			
			statement.executeUpdate(CREATE_TABLE_MOVIES);
			
			final File inputFile = new File(filePath);
			final List<Movie> movies = WorkbookUtility.retrieveMovieFromWorkbook(inputFile);
			
			for(final Movie movie : movies){
				final String insertValues = "insert into movies (title, director, length) "
						+ "values ('" + movie.getTitle() + "', '"+ movie.getDirector() + "', " + movie.getLengthInMinutes() +");";
				
				System.out.println(insertValues);
				statement.executeUpdate(insertValues);
			}
		
		}catch (ClassNotFoundException | SQLException | InvalidFormatException | IOException e){
			e.printStackTrace();
			throw new MovieDaoException("Error: Unable to populate database.");
		
		}finally{
			DBUtility.closeConnections(connection, statement);
		}
		
	}

	@Override
	public List<Movie> retrieveMovie() throws MovieDaoException {

		Connection connection = null;
		Statement statement = null;
		
		final List<Movie> movies = new ArrayList<>();
		
		try {
			connection = DBUtility.createConnection();
			statement = connection.createStatement();
			
			statement.setQueryTimeout(DBUtility.TIMEOUT);
			
			final ResultSet resultSet = statement.executeQuery(SELECT_ALL_FROM_MOVIES);
			
			while (resultSet.next()){
				final String title = resultSet.getString("title");
				final String director = resultSet.getString("director");
				final int length = resultSet.getInt("length");
				
				movies.add(new Movie(title,director, length));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new MovieDaoException("Error : Unable to retrieve movies.");
		}finally{
			DBUtility.closeConnections(connection, statement);
		}

		return movies;
	}

	@Override
	public void insertMovie(Movie movie) throws MovieDaoException {
		
		Connection connection = null;
		PreparedStatement insertStatement = null;
		
		try {
			connection = DBUtility.createConnection();
			final String sqlStatement = "INSERT INTO movies (title, director, length) VALUES (?,?,?);";
			
			insertStatement = connection.prepareStatement(sqlStatement);
			
			insertStatement.setString(1, movie.getTitle());
			insertStatement.setString(2, movie.getDirector());
			insertStatement.setInt(3, movie.getLengthInMinutes());
			
			
			insertStatement.setQueryTimeout(DBUtility.TIMEOUT);
			
			insertStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e){
			e.printStackTrace();
			throw new MovieDaoException("Error: Unable to add this movie to the database.");
		} finally {
			DBUtility.closeConnections(connection, insertStatement);
		}
			

	}

}
