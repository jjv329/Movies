/**
 * 
 */
package edu.cvtc.web.servlets;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.base.Strings;

import edu.cvtc.web.dao.MovieDao;
import edu.cvtc.web.dao.impl.MovieDaoException;
import edu.cvtc.web.dao.impl.MovieDaoImpl;
import edu.cvtc.web.model.Movie;

/**
 * @author jvollmer
 *
 */
@WebServlet("/Search")
public class SearchController extends HttpServlet {
	
	private static final long serialVersionUID = -7146804893798524255L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String target=null;
		 
		 try{
			final MovieDao movieDao = new MovieDaoImpl();
			final List<Movie> movies = movieDao.retrieveMovie();
			
			final String director = request.getParameter("director").toUpperCase();
			final String title = request.getParameter("title").toUpperCase();
			//TODO: could be here
			final List<Movie> filteredMovies;
			
			if (Strings.isNullOrEmpty(title) != true && Strings.isNullOrEmpty(director) != true){
				
				filteredMovies = movies
						.stream()
						.filter((movie) -> movie.getTitle().toUpperCase().contains(title))
						.filter((movie) -> movie.getDirector().toUpperCase().contains(director))
						.collect(Collectors.toList());
				
			}else{
				
				if (Strings.isNullOrEmpty(title) != true){
				filteredMovies = movies
				.stream()
				.filter((movie) -> movie.getTitle().toUpperCase().contains(title))
				.collect(Collectors.toList());		
				
				}else{	
				filteredMovies = movies
				.stream()
				.filter((movie) -> movie.getDirector().toUpperCase().contains(director))
				.collect(Collectors.toList());		
				}
			}
				
				request.setAttribute("movie", filteredMovies);
				target="view-all.jsp";
				
			}catch(MovieDaoException e){
				e.printStackTrace();
				throw new IOException("The workbook file has an invalid format.");
			}
		
		 request.getRequestDispatcher(target).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
