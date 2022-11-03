package use.user;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class timetableDBUtil {

	//Insert data to the database
	public static boolean inserttimetable(String faculty, String year, String filename) {
		 {
		
		 boolean isSuccess = false;
		 
		//Create db connection
		 String url = "jdbc:mysql://localhost:3306/exammanagement";
		 String user = "root";
		 String pwd = "";
		 
		 try {

			 //Class.forName(className)
			 Class.forName("com.mysql.jdbc.Driver");
			 
			 //call the database
			 //DriverManager,Statement are classes
			 Connection con = DriverManager.getConnection(url, user, pwd);
			 Statement stmt = con.createStatement();

				 String sql = "insert into timetable values (0,'"+faculty+"','"+year+"','"+filename+"')";
				 //We don't create a object from resultSet here
				 //We assign the values to an integer variable
				 int rs = stmt.executeUpdate(sql);
				 
				 //executeUpdate method returns 2 values  
				 //If it returns 1 - success
				 //If returns 0 - unsuccess
				 
				 if(rs > 0) {
					 isSuccess = true;
				 }
				 else {
					 isSuccess = false;
				 }
			 
		 }
		 
		 catch(Exception e){
			 //To print the error if an error occurs
			 e.printStackTrace();
		 }
		
		return isSuccess;
		 }
	
	}
	
	
//Get Data from the database 
	public static List<timetable> validateT(String faculty, String year){
			
			//Create an arrayList object
			 ArrayList<timetable> timet = new ArrayList<>();
			 
			 //Create database connection
			 String url = "jdbc:mysql://localhost:3306/exammanagement";
			 String user = "root";
			 String pwd = "";
			 
			 //Validate
			 
			 //To fix the errors without terminating the program
			 try {
				 //Sql 
				 
				 //Class.forName(className)
				 Class.forName("com.mysql.jdbc.Driver");
				 
				 //call the database
				 //DriverManager,Statement are classes
				 Connection con = DriverManager.getConnection(url, user, pwd);
				 Statement stmt = con.createStatement();
				 
				 //insert query
				 //we do the validation with the help of where clause
				 String sql = "select * from timetable where faculty = '"+faculty+"' and year='"+year+"'";
				 
				 ResultSet rs = stmt.executeQuery(sql);
				 
				 //next is a boolean method. if it is true then the UN and PW is correct
				 //And we take the data from the DB
				 if(rs.next()) {
					 int ttID = rs.getInt(1); //give the column id
					 String fac = rs.getString(2);	 
					 String Byear = rs.getString(3);
					 String fileN = rs.getString(4);
		
						 //create object
						 timetable t = new timetable(ttID, fac, Byear, fileN);
						 //pass this object to array object
						 timet.add(t);
					 
					 
					
				 }
				 
			 }
			 catch(Exception e) {
				 e.printStackTrace();
			 }
			 
			 //we should return this array object
			 return timet;
		}
}
