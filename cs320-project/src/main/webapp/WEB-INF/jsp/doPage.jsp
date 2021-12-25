<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Dormitory Official Page</title>
  </head>
  <body>
  <%
      String username = (String) session.getAttribute("username");
      String usertype = (String) session.getAttribute("usertypename");
      //int userid = (int) session.getAttribute("userid");
  %>
  <p>You are logged in as : <%= username %> , <%= usertype %> </p>
  <a href="/listResidents">List Residents</a>
  <a href="/listServices">List Services</a>
  <a href="/listRequests">List and Update Requests</a>
  <a href="/logout">Logout</a>
  </body>
</html>
