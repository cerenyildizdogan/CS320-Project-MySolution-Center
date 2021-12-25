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
<a href="/listServicesForResidents">List Services</a>
<a href="/myRequests/<%=userid%>">List my Requests</a>
<a href="/logout">Logout</a>

</body>
</html>
