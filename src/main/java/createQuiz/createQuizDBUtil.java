package createQuiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;

public class createQuizDBUtil {
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
	
	
	
	public void validate(createQuiz cq ) {
		loadDriver(dbDriver);
		Connection con = getConnection();
		
		
		try {
			String newModuleTableName = cq.getFaculty() + "_" + cq.getYear() + "_" + cq.getMcode();
			String QuizDetails = cq.getFaculty()+"','"+cq.getYear()+"','"+cq.getMcode()+"','"+cq.getNoQ()+"','"+cq.getEnrollKey()+"','"+cq.getQuizPass();
			
			String moduleTablenameQry = "SELECT * FROM quiz_table_names";
			Statement st1 = con.createStatement();
			ResultSet rs = st1.executeQuery(moduleTablenameQry);
//			while(rs.next()) {
//				int QuizID = rs.getInt(1);
//				String quiz_table_namescol = rs.getString(2);
//				System.out.println(QuizID + " " + quiz_table_namescol);
//				if(newModuleTableName == quiz_table_namescol) {
//					System.out.println("It is existing table. Cannot be create, Move to update, delete table");
//					boolean existTable = true;
//					break;
//				}
//			}
			
//			String enternewModuleTableNameQry = "INSERT INTO quiz_table_names(QuizID, quiz_table_namescol) VALUES(0, '" + newModuleTableName +"')";
			String quizDetailsQry = "insert into quizdetails(qid, faculty, year, mcode, noQ, enrollKey, quizPass) values(0, '"+ QuizDetails +"','" + newModuleTableName + "')";
			String createTableQry = "CREATE TABLE IF NOT EXISTS `exammanagement`.`" + newModuleTableName + "`(`qid` INT NOT NULL AUTO_INCREMENT, `question` VARCHAR(200) NULL, `option1` VARCHAR(100) NULL, `option2` VARCHAR(100) NULL, `option3` VARCHAR(100) NULL, `option4` VARCHAR(100) NULL, `answer` VARCHAR(100) NULL, PRIMARY KEY (`qid`));";

			Statement st2 = con.createStatement();
			st2.executeUpdate(quizDetailsQry);
			
			Statement st3 = con.createStatement();
			st3.executeUpdate(createTableQry);
			
//			Statement st4 = con.createStatement();
//			st4.executeUpdate(enternewModuleTableNameQry);
			
			
			System.out.println("Data inserted successfully");
		} catch (SQLException e) {
			System.out.println("Error: The table cannot be create. " + e);
		}
		
	}
}
