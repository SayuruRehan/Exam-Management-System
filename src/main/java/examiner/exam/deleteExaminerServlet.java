package examiner.exam;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class deleteExaminerServlet
 */
@WebServlet("/deleteExaminerServlet")
public class deleteExaminerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteExaminerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	boolean isTrue;
		
	String faculty = request.getParameter("faculty");
	String year = request.getParameter("year");//Give the name in the form delete.jsp
			
	try {
			
			isTrue = examinerDBUtil.deleteExaminer(faculty,year);
			if(isTrue == true) {
				RequestDispatcher dis = request.getRequestDispatcher("viewExaminer.jsp");
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
