<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Resident Page</title>
    </head>
    <body>
    <%
        String username = (String) session.getAttribute("username");
        String usertype = (String) session.getAttribute("usertypename");
        int userid = (int) session.getAttribute("userid");
    %>
    <p>You are logged in as : <%= username %> , <%= usertype %> </p>
    <div>
    <a href="/listServicesForResidents">List Services</a>
    </div>
    <div>
    <a href="/myRequests/<%=userid%>" >List my Requests</a>
    </div>
    <div>
    <a href="/logout">Logout</a>
    </div>
    
    </body>
</html>
