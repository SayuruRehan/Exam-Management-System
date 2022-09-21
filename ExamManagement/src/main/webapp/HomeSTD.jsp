<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <link href="home.css" rel="stylesheet" type="text/css" />

    <title>Insert title here</title>
  </head>

  <body>
    <header>
      <div class="upnav">
        <a href="#" class="logo">
          <h1 id="lgo">WEBEXAM</h1>
        </a>

        <div class="searchLogin">
          <div class="search-container">
            <div class="searchbox-container">
              <input type="search" placeholder="Search" id="searchbox" />
            </div>
            <div class="sbtn-container">
              <svg
                xmlns="http://www.w3.org/2000/svg"
                width="16"
                height="16"
                fill="currentColor"
                class="bi bi-bell"
                viewBox="0 0 16 16"
              >
                <path
                  d="M8 16a2 2 0 0 0 2-2H6a2 2 0 0 0 2 2zM8 1.918l-.797.161A4.002 4.002 0 0 0 4 6c0 .628-.134 2.197-.459 3.742-.16.767-.376 1.566-.663 2.258h10.244c-.287-.692-.502-1.49-.663-2.258C12.134 8.197 12 6.628 12 6a4.002 4.002 0 0 0-3.203-3.92L8 1.917zM14.22 12c.223.447.481.801.78 1H1c.299-.199.557-.553.78-1C2.68 10.2 3 6.88 3 6c0-2.42 1.72-4.44 4.005-4.901a1 1 0 1 1 1.99 0A5.002 5.002 0 0 1 13 6c0 .88.32 4.2 1.22 6z"
                />
              </svg>
            </div>
          </div>
          <div class="lgn">
            <button id="loginbtn">Log-in | Sign Up</button>
          </div>
        </div>
      </div>
      <nav>
        <ul class="menu">
          <li><a href="Home.html">Dashboard</a></li>
          <li><a href="Flight Details.html">Examinations</a></li>
          <li><a href="booking.html">Practice test</a></li>
          <li><a href="Contact Us.html">Inquiries</a></li>

          <li
            id="time"
            class="hbl"
            style="background-color: #7995ca; float: right"
          >
            <a
              id="timetxt"
              style="font-weight: 100; font-size: 20px; color: #fff"
              >10:10:55</a
            >
          </li>
        </ul>
      </nav>
    </header>

    <h1>Student</h1>

    <c:forEach var="std" items="${stdDetails}">
      <!--The name given in set attribute in servlet file -->

      ${std.id}
      <!-- It calls the getters -->
      ${std.name} ${std.NIC} ${std.phone} ${std.email} ${std.username}
      ${std.password}
    </c:forEach>
  </body>
</html>
