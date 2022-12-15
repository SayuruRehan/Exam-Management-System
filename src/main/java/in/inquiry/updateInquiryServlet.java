package in.inquiry;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class updateInquiryServlet
 */
@WebServlet("/updateInquiryServlet")
public class updateInquiryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");		
		String number = request.getParameter("number")	;	
		String faculty = request.getParameter("faculty");
		String year = request.getParameter("year"); //We use the name given in the form inside the parentheses 
		String inquirytype = request.getParameter("inquirytype");
		String message = request.getParameter("message");
		
		System.out.println(email);
		
		
	
		
		try {
	
			//Call the update method
			boolean isTrue;
			
			isTrue = inquiryDBUtil.updateInquiry(id,name,email,number,faculty,year,inquirytype,message);
				
				if(isTrue == true) {
	
					
					RequestDispatcher dis = request.getRequestDispatcher("viewInquiry.jsp");
					dis.forward(request,  response);
					
					System.out.println("Working");
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
