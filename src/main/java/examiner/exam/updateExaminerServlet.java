package examiner.exam;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;



/**
 * Servlet implementation class updateExaminerServlet
 */
@WebServlet("/updateExaminerServlet")
public class updateExaminerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateExaminerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//To capture the data from the form and to save it
		//We use request method to save the data inside variables
		
		String id = request.getParameter("id");
		String faculty = request.getParameter("faculty"); //We use the name given in the form inside the parentheses 
		String year = request.getParameter("year");
		
		Part examiner = request.getPart("examiner");
		String filename = examiner.getSubmittedFileName();  //get selected file name
		
		String path = "C:/Projects/ExamManagement/src/main/webapp/Examiner/"+filename; //upload path, to where should the file upload
		File f = new File(path);

		
		try {
			
			//upload the file into the folder
			if(f.exists()) {
				JOptionPane.showMessageDialog(null, "Examiner List already Exist!");
			}
			else {
				FileOutputStream fos = new FileOutputStream(path); 
				InputStream is = examiner.getInputStream();
				
				byte[] data = new byte[is.available()];
				is.read(data);
				fos.write(data);
				fos.close();
			}
			
		//Call the update method
		boolean isTrue;
		
		isTrue = examinerDBUtil.updateExaminer(id,faculty,year,filename);
			
			if(isTrue == true) {

				
				RequestDispatcher dis = request.getRequestDispatcher("viewExaminer.jsp");
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
