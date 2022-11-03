package quiz.lec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class QuizLecDetailsInsertDao {
	private String dbUrl = "jdbc:mysql://localhost:3306/exammanagement";
	private String dbUname = "root";
	private String dbPassword = "";
	private String dbDriver = "com.mysql.jdbc.Driver";
	
	public void loadDriver(String dbDriver) {
		try {
		Class.forName(dbDriver);
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		Connection con = null;
		try {
		con = DriverManager.getConnection(dbUrl, dbUname, dbPassword);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return con;
	}
	
	
	
	public void validate(QuizLecDetailsInsertBean qldib ) {
		loadDriver(dbDriver);
		Connection con = getConnection();
		
		
		try {
			String qry = "insert into quizdetails(qid, faculty, year, mcode, enrollKey, quizPass) values(0, '"+qldib.getFaculty()+"','"+qldib.getYear()+"','"+qldib.getMcode()+"','"+qldib.getEnrollKey()+"','"+qldib.getQuizPass()+"')";
			Statement st = con.createStatement();
			st.executeUpdate(qry);
			System.out.println("Data inserted successfully");
		} catch (SQLException e) {
			System.out.println("Error: This error from SQL query. " + e);
		}
		
	}

}
