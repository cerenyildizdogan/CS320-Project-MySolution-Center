<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Remove Resident</title>
</head>
<body>
<p>Enter the Resident's username you want to remove</p>
<%
    String email = (String) session.getAttribute("level");

    if(email == null){
%>
<p style="color: red" >${errorMessage}</p>
<form method="post">
    <div>
        Email = <input type="text" name="email" required>
    </div>
    <div>
        <input type="submit" value="remove" />
    </div>
    <a href="/listResidents" >Back to previous page</a>
</form>
<%
}else{
%>

<a href="/listResidents" >Back to previous page</a>

<%
    }
%>

</body>
</html>
