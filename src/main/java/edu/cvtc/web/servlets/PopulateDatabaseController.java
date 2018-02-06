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

import edu.cvtc.web.dao.MovieDao;
import edu.cvtc.web.dao.impl.MovieDaoException;
import edu.cvtc.web.dao.impl.MovieDaoImpl;
import edu.cvtc.web.util.WorkbookUtility;

/**
 * @author jvollmer
 *
 */
@WebServlet("/PopulateDatabase")
public class PopulateDatabaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String target = null;
		
		try {
			final String filePath = getServletContext().getRealPath(WorkbookUtility.INPUT_FILE);
			final MovieDao personDao = new MovieDaoImpl();
			
			personDao.populate(filePath);
			
			request.setAttribute("message", "Database populated...");
			target = "success.jsp";
			
		} catch (MovieDaoException e) {
			e.printStackTrace();
			request.setAttribute("message", e.getMessage());
			target = "error.jsp";
		}
		
		request.getRequestDispatcher(target).forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
