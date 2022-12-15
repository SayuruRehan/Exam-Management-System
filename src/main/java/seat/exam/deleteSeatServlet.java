package seat.exam;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class deleteSeatServlet
 */
@WebServlet("/deleteSeatServlet")
public class deleteSeatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	boolean isTrue;
		
	String faculty = request.getParameter("faculty");
	String year = request.getParameter("year");//Give the name in the form delete.jsp
			
	try {
			
			isTrue = seatDBUtil.deleteSeat(faculty,year);
			if(isTrue == true) {
				RequestDispatcher dis = request.getRequestDispatcher("viewSeat.jsp");
				dis.forward(request,  response);
			}
			else {

				RequestDispatcher dis = request.getRequestDispatcher("Home.jsp");
				dis.forward(request,  response);
			}
				

	}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}

}
