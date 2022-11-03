<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <link href="exam.css" rel="stylesheet" type="text/css" />

    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
    <title>Exam | ExamDept</title>
  </head>

  <body onload="startTime()">
    <header>
      <div class="upnav">
        <div class="logo">
          <a href="#">
            <h1 id="lgo">WEBEXAM</h1>
          </a>
        </div>

        <div class="searchLogin">
          <div class="search-container">
            <input type="search" placeholder="Search" id="searchbox" />
          </div>
          <div class="bi bi-bell">
            <svg
              xmlns="http://www.w3.org/2000/svg"
              width="45"
              height="45"
              fill="currentColor"
              class="bi bi-bell"
              viewBox="0 0 16 16"
            >
              <path
                d="M8 16a2 2 0 0 0 2-2H6a2 2 0 0 0 2 2zM8 1.918l-.797.161A4.002 4.002 0 0 0 4 6c0 .628-.134 2.197-.459 3.742-.16.767-.376 1.566-.663 2.258h10.244c-.287-.692-.502-1.49-.663-2.258C12.134 8.197 12 6.628 12 6a4.002 4.002 0 0 0-3.203-3.92L8 1.917zM14.22 12c.223.447.481.801.78 1H1c.299-.199.557-.553.78-1C2.68 10.2 3 6.88 3 6c0-2.42 1.72-4.44 4.005-4.901a1 1 0 1 1 1.99 0A5.002 5.002 0 0 1 13 6c0 .88.32 4.2 1.22 6z"
              />
            </svg>
          </div>
          <div class="lgn">
            <svg xmlns="http://www.w3.org/2000/svg" width="45" height="45" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
                <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
                <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
              </svg>
          </div>
          <div class="lgn-out">
            <svg xmlns="http://www.w3.org/2000/svg" width="45" height="45" fill="currentColor" class="bi bi-box-arrow-right" viewBox="0 0 16 16">
                <path fill-rule="evenodd" d="M10 12.5a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v2a.5.5 0 0 0 1 0v-2A1.5 1.5 0 0 0 9.5 2h-8A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-2a.5.5 0 0 0-1 0v2z"/>
                <path fill-rule="evenodd" d="M15.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 0 0-.708.708L14.293 7.5H5.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z"/>
              </svg>
          </div>
        </div>
      </div>
      <nav>
        <div>
          <ul class="menu">
            <li><a href="HomeExam.jsp">Dashboard</a></li>
            <li><a href="#">Examinations</a></li>
            <li><a href="booking.html">Practice test</a></li>
            <li><a href="Contact Us.html">Inquiries</a></li>
          </ul>
        </div>
    
        <div
          id="time"
          class="hbl"
          style="
            background-color: #7995ca;
            float: right;
            padding: 0 10px 0 10px;
          "
        >
          <a
            id="timetxt"
            style="font-weight: 100; font-size: 20px; color: #fff"
          >
          </a>
          <script>
            function startTime() {
              const today = new Date();
              let h = today.getHours();
              let m = today.getMinutes();
              let s = today.getSeconds();
              m = checkTime(m);
              s = checkTime(s);
              document.getElementById("timetxt").innerHTML =
                h + ":" + m + ":" + s;
              setTimeout(startTime, 1000);
            }
            function checkTime(i) {
              if (i < 10) {
                i = "0" + i;
              } // add zero in front of numbers < 10
              return i;
            }
          </script>
        </div>
      </nav>
    </header>

	
    <!--<c:forEach var="std" items="${stdDetails}">
      //The name given in set attribute in servlet file 

      ${std.id}
      //It calls the getters 
      ${std.name} ${std.NIC} ${std.phone} ${std.email} ${std.username}
      ${std.password}
    </c:forEach> -->
	<div class="op-background">
		<div class="op-btn">

        	<div class="design-btn"><a href="register.jsp" ><button id="register-btn" >Upload Question<br><br><ion-icon name="book-outline" class="timetable"></ion-icon></button></a></div>
        	<div  class="design-btn"><a href="seatStd.jsp" ><button id="seat-btn">Update Question<br><br><ion-icon name="reader-outline" class="seat"></ion-icon></button></a></div>
        	<div  class="design-btn"><a href="seatStd.jsp" ><button id="seat-btn">Assign Examiners<br><br><ion-icon name="reader-outline" class="seat"></ion-icon></button></a></div>
        </div> 
    </div>
    
  </body>
</html>