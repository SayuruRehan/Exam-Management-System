public static boolean inserttimetable(String faculty, String year, String timetable ) {
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
			 

				 
				 String sql = "insert into timetable values (0,'"+faculty+"','"+year+"','"+timetable+"')";
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
