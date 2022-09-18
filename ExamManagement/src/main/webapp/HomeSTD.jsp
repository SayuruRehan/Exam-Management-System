<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="home.css" rel="stylesheet" type="text/css">

<title>Insert title here</title>
</head>


<body>
    <header>
        <div>
           
             <a href="#" class = 'logo'>
                <h1 id="lgo">WEBEXAM</h1>
            </a> 
               
             <div class = "searchLogin">
                <div class = "search-container">
                    <div class = "searchbox-container">
                        <input type = 'search' placeholder="Search" id = "searchbox">
                    </div>
                    <div class = "sbtn-container">
                        <a href="#"><span  id ="sbtn" class="material-icons">search</span></a>
                    </div>
                </div>
                <div class="lgn">
                    <button id = "loginbtn">Log-in | Sign Up</button>
                </div>
                
              </div>
           
        </div>
        <nav>

            <ul class = 'menu'>
                <li><a href='Home.html'>Dashboard</a></li>
                <li><a href='Flight Details.html'>Examinations</a></li>
                <li><a href='booking.html'>Practice test</a></li>
                <li><a href='Contact Us.html'>Inquiries</a></li>
                    
            <li id="time" class="hbl" style="background-color: #7995ca ;float:right;">
                <a id="timetxt" style="font-weight: 100; font-size: 20px;color:#fff;">10:10:55</a>
            </li> 
           
            </ul>

        </nav>
    </header>

	<H1>Student</H1>

	<c:forEach var="std" items="${stdDetails}"> 
	<!--The name given in set attribute in servlet file -->
	
		${std.id} <!-- It calls the getters -->
		${std.name}
		${std.NIC}
		${std.phone}
		${std.email}
		${std.username}
		${std.password}
		
	</c:forEach>
</body>
</html>





