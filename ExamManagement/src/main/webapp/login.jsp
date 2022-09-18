<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="login" method="POST">
		 User Name : <input type='text' name='uid'><br>
		 Password : <input type='password' name='pass'><br>
		 
		 <select name="userType">
		 
		    <option value="std">Student</option>
		    <option value="lec">Lecturer</option>
		    <option value="examDep">Exam Department</option>
		    
		</select>
		
		<input type='submit' name='submit' value='Login'>
	</form>
</body>
</html>