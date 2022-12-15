package in.inquiry;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class deleteInquiryServlet
 */
@WebServlet("/deleteInquiryServlet")
public class deleteInquiryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	boolean isTrue;
		
	String number = request.getParameter("number");
	//Give the name in the form delete.jsp
			
	try {
			
			isTrue = inquiryDBUtil.deleteInquiry(number);
			if(isTrue == true) {
				RequestDispatcher dis = request.getRequestDispatcher("viewInquiry.jsp");
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
