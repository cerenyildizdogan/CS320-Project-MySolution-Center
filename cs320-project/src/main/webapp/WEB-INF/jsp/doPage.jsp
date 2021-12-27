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
  <div>
  <a href="/listResidents">List Residents</a>
  </div>
  <div>
  <a href="/listServices">List Services</a>
  </div>
  <div>
  <a href="/listRequests">List and Update Requests</a>
  </div>
  <div>
  <a href="/logout">Logout</a>
  </div>
  </body>
</html>
