package use.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDBUtil {
	
	//Related to login class
	//Validate Method for Student
	public static List<Student> validateS(String userName, String password){
		
		//Create an arrayList object
		 ArrayList<Student> stu = new ArrayList<>();
		 
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
			 String sql = "select * from student where username = '"+userName+"' and password='"+password+"'";
			 
			 ResultSet rs = stmt.executeQuery(sql);
			 
			 //next is a boolean method. if it is true then the UN and PW is correct
			 //And we take the data from the DB
			 if(rs.next()) {
				 int id = rs.getInt(1); //give the column id
				 String name = rs.getString(2);	 
				 String NIC = rs.getString(3);	 
				 String phone = rs.getString(4);
				 String email = rs.getString(5);
				 String userU = rs.getString(6);
				 String pwdU = rs.getString(7);
				 String userT = rs.getString(8);
				 
				 if(userT.equals("std")) {
					 //create object
					 Student s = new Student(id,name,NIC,phone,email,userU,pwdU,userT);
					 //pass this object to array object
					 stu.add(s);
				 }
				 
				
			 }
			 
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		 
		 //we should return this array object
		 return stu;
	}
	
	    //Related to login class
		//Validate Method for Lecturer
		public static List<Lecturer> validateL(String userName, String password){
			
			//Create an array object
			 ArrayList<Lecturer> lec = new ArrayList<>();
			 
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
				 String sql = "select * from lecturer where username = '"+userName+"' and password='"+password+"'";
				 
				 ResultSet rs = stmt.executeQuery(sql);
				 
				 //next is a boolean method. if it is true then the UN and PW is correct
				 //And we take the data from the DB
				 if(rs.next()) {
					 int id = rs.getInt(1); //give the column id
					 String name = rs.getString(2);	 
					 String NIC = rs.getString(3);	 
					 String phone = rs.getString(4);
					 String email = rs.getString(5);
					 String userU = rs.getString(6);
					 String pwdU = rs.getString(7);
					 String userT = rs.getString(8);
					 
					 if(userT.equals("lec")) {
						 //create object
						 Lecturer l = new Lecturer(id,name,NIC,phone,email,userU,pwdU,userT);
						 //pass this object to array object
						 lec.add(l);
					 }
					 
				 }//close if
				 
			 } //close try
			 catch(Exception e) {
				 e.printStackTrace();
			 } //close catch
			 
			 //we should return this array object
			 return lec;
		}
		//Related to login class
				//Validate Method for Exam Department
				public static List<ExamDep> validateE(String userName, String password){
					
					//Create an array object
					 ArrayList<ExamDep> exm = new ArrayList<>();
					 
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
						 String sql = "select * from examdept where username = '"+userName+"' and password='"+password+"'";
						 
						 ResultSet rs = stmt.executeQuery(sql);
						 
						 //next is a boolean method. if it is true then the UN and PW is correct
						 //And we take the data from the DB
						 if(rs.next()) {
							 int id = rs.getInt(1); //give the column id
							 String name = rs.getString(2);	 
							 String NIC = rs.getString(3);	 
							 String phone = rs.getString(4);
							 String email = rs.getString(5);
							 String userU = rs.getString(6);
							 String pwdU = rs.getString(7);
							 String userT = rs.getString(8);
							 
							 if(userT.equals("examDep")) {
								 //create object
								 ExamDep e = new ExamDep(id,name,NIC,phone,email,userU,pwdU,userT);
								 //pass this object to array object
								 exm.add(e);
							 }
							 
						 }//close if
						 
					 } //close try
					 catch(Exception e) {
						 e.printStackTrace();
					 } //close catch
					 
					 //we should return this array object
					 return exm;
				}
		
	//Related to createAccount class
	//InsertUser Method
	//This method make a connection with the DB and insert the data into the DB
	//This method returns a boolean value to the servlet class
	//It detect whether the data was inserted successfully or not
	
	//We have to capture the data passed through the servlet
	public static boolean insertuser(String name, String NIC, String phone, String email, String username, String password, String userType) {
		
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
			 
			 //insert query
			 //pass the data to the database
			 if(userType.equals("std")) {
				 
				 String sql = "insert into student values (0,'"+name+"','"+NIC+"','"+phone+"','"+email+"','"+username+"','"+password+"','"+userType+"')";
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
			
			 if(userType.equals("lec")) {
				 
				 String sql1 = "insert into lecturer values (0,'"+name+"','"+NIC+"','"+phone+"','"+email+"','"+username+"','"+password+"','"+userType+"')";
				 //We don't create a object from resultSet here
				 //We assign the values to an integer variable
				 int rs1 = stmt.executeUpdate(sql1);
				 //executeUpdate method returns 2 values  
				 //If it returns 1 - success
				 //If returns 0 - unsuccess
				 
				 if(rs1 > 0) {
					 isSuccess = true;
				 }
				 else {
					 isSuccess = false;
				 }
	
			 }
			 	if(userType.equals("examDep")) {
				 
				 String sql1 = "insert into examdept values (0,'"+name+"','"+NIC+"','"+phone+"','"+email+"','"+username+"','"+password+"','"+userType+"')";
				 //We don't create a object from resultSet here
				 //We assign the values to an integer variable
				 int rs1 = stmt.executeUpdate(sql1);
				 //executeUpdate method returns 2 values  
				 //If it returns 1 - success
				 //If returns 0 - unsuccess
				 
				 if(rs1 > 0) {
					 isSuccess = true;
				 }
				 else {
					 isSuccess = false;
				 }
	
			 }
			 
		 }
		 
		 catch(Exception e){
			 //To print the error if an error occurs
			 e.printStackTrace();
		 }
		
		return isSuccess;
	}
	
}
