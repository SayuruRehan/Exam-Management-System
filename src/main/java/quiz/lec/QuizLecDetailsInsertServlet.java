package quiz.lec;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quiz.lec.QuizLecDetailsInsertBean;
import quiz.lec.QuizLecDetailsInsertDao;

/**
 * Servlet implementation class QuizLecDetailsInsertServlet
 */
@WebServlet("/QuizLecDetailsInsertServlet")
public class QuizLecDetailsInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuizLecDetailsInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get user data from quizLecDetailsInsert.jsp file and load to parameters
		String faculty = request.getParameter("faculty");
		String year = request.getParameter("year");
		String mcode = request.getParameter("mcode");
		String enrollKey = request.getParameter("enrollkey");
		String quizPass = request.getParameter("quizPass");
		
//		System.out.println("until this successful");
		
		//pass data to quizLecDetailsInsertBean.java class usign constructor
		QuizLecDetailsInsertBean qldib1 = new QuizLecDetailsInsertBean(faculty, year, mcode, enrollKey, quizPass);
		
		//call validate method in QuizLecDetailsInsertDeo.java class
		QuizLecDetailsInsertDao qldid1 = new QuizLecDetailsInsertDao();
		qldid1.validate(qldib1);
		
		
		//Redirect to quizLecQuizsionAdd.jsp page
		RequestDispatcher dis = request.getRequestDispatcher("insertQuestion.jsp");
		dis.forward(request, response);

	}

}
