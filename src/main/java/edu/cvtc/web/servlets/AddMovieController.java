/**
 * 
 */
package edu.cvtc.web.servlets;

import java.io.IOException;

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
@WebServlet("/AddMovie")
public class AddMovieController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String target = null;
		
		try {
			
			final String title = request.getParameter("title");
			final String director = request.getParameter("director");
			final String time = request.getParameter("lengthInMinutes");			

			if (Strings.isNullOrEmpty(title) != true && Strings.isNullOrEmpty(director) != true && Strings.isNullOrEmpty(time) != true){
			
				final int length = Integer.parseInt(time);
				final Movie movie = new Movie(title,director,length);
				
				final MovieDao movieDao = new MovieDaoImpl();
				movieDao.insertMovie(movie);
				
				request.setAttribute("message", "The movie has been added to the database.");
				target = "success.jsp";
			
			}else{
				String msg = "The title1, director2, 3length fields must be populated in order to add a movie.\n";
				int cnt = 0;
				
				if(Strings.isNullOrEmpty(title) != true) {
					msg = msg.replaceFirst("title1, ", "");
					cnt += 1;
				}
			
				if(Strings.isNullOrEmpty(director) != true){
					msg = msg.replaceFirst("director2, ", "");
					cnt += 1;
				}
			
				if(Strings.isNullOrEmpty(time) != true){
					msg = msg.replaceFirst(" 3length ", "");
					cnt += 1;
				}
				
				if (cnt == 1){
					msg = msg.replaceAll("2, 3", ", and ");
					msg = msg.replaceAll("1, 3", ", and ");
					msg = msg.replaceAll("1, d", ", and d");
					msg = msg.replaceAll("2,f", " f");
				}else if (cnt == 2){
					msg = msg.replaceAll("1,", " ");
					msg = msg.replaceAll("2, 3", "");
					msg = msg.replaceAll("3", "");
					msg = msg.replaceAll("2,", " ");
					
					msg = msg.replaceFirst("fields", "field");
				}else{
					msg = msg.replaceAll("1,", ",");
					msg = msg.replaceAll("2, 3", ", and ");
				}

				request.setAttribute("message", msg);
				target = "addMovie.jsp";
			}
			
		} catch (MovieDaoException e) {
			e.printStackTrace();
			request.setAttribute("message", e.getMessage());
			target = "error.jsp";
		}
		
		
		request.getRequestDispatcher(target).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
