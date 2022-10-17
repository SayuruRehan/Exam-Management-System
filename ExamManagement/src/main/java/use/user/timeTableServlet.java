package use.user;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CustomerInsert
 */
@WebServlet("/timeTableServlet")
public class timeTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//To capture the data from the form and to save it
		//We use request method to save the data inside variables
		String faculty = request.getParameter("faculty"); //We use the name given in the form inside the parentheses 
		String year = request.getParameter("year");
		String timetable = request.getParameter("timetable");

		
		//Call the insertCustomer method in the customerDBUtil
		//Use above variable names as argument names
		
		boolean isTrue; //To capture the return boolean value
		
		isTrue = timetableDBUtil.inserttimetable(faculty, year, timetable);
		
		//check whether the db connection is successful
		if(isTrue == true) {
			
			RequestDispatcher dis = request.getRequestDispatcher("viewTimetable.jsp");
			dis.forward(request, response);
		}
		else {
			
			RequestDispatcher dis2 = request.getRequestDispatcher("uploadTimetable.jsp");
			dis2.forward(request, response);
		}
		
	}

}
