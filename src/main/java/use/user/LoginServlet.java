package use.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("uid"); //The name in the form(.jsp file)
		String password = request.getParameter("pass");
		String userType = request.getParameter("userType");
		
		
		if(userType.equals("std")) {
			
			//To take the data from student.java
			try {
			//because validate() is a static method, you can call it using the class
			List<Student> stdDetails = UserDBUtil.validateS(username,password);
			
			//Make a connection with HomeSTD.jsp file
			//What we should send to that new page
			request.setAttribute("stdDetails", stdDetails);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			//Redirect the data to the new page
			RequestDispatcher dis = request.getRequestDispatcher("HomeSTD.jsp"); //Name of the file that data should be redirected to
			dis.forward(request, response);
			
			}
		
		else if(userType.equals("lec")) {
			
			//To take the data from Lecturer.java
			try {
			//because validate() is a static method, you can call it using the class
			List<Lecturer> lecDetails = UserDBUtil.validateL(username,password);
			
			//Make a connection with account.jsp file
			//What we should send to that new page
			request.setAttribute("lecDetails", lecDetails);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			//Redirect the data to the new page
			RequestDispatcher dis = request.getRequestDispatcher("HomeLEC.jsp"); //Name of the file that data should be redirected to
			dis.forward(request, response);
			
		}
		
		else if(userType.equals("examDep")) {
			
			//To take the data from examDept.java
			try {
			//because validate() is a static method, you can call it using the class
			List<ExamDep> ExamDetails = UserDBUtil.validateE(username,password);
			
			//Make a connection with account.jsp file
			//What we should send to that new page
			request.setAttribute("ExamDetails", ExamDetails);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			//Redirect the data to the new page
			RequestDispatcher dis = request.getRequestDispatcher("HomeExam.jsp"); //Name of the file that data should be redirected to
			dis.forward(request, response);
			
		}
		
	}
		
		

}
