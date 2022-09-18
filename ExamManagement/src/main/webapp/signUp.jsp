<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action = "insert" method = "POST">
	
		Name : <input type="text" name="name"><br>
		NIC : <input type="text" name="NIC"><br>
		Phone Number : <input type="text" name="phone"><br>
		Email : <input type="text" name="email"><br>
		User Name : <input type="text" name="uid"><br>
		Password : <input type="password" name="psw"><br>
		
		User Type:
		<select name="userType">
		    <option value="std">Student</option>
		    <option value="lec">Lecturer</option>
		    <option value="examDep">Exam Department</option>
		    
		</select>
		<input type = "submit" name = "submit" value="Create Account">
	
	</form>

</body>
</html>