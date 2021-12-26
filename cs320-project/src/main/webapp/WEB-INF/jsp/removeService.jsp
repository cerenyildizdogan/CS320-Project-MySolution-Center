
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Remove Service</title>
</head>
<body>
<p>Enter the Service's name you want to remove</p>
<%
    String name = (String) session.getAttribute("level");

    if(name == null){
%>
<p style="color: red" >${errorMessage}</p>
<form method="post">
    <div>
        Service Name = <input type="text" name="servicename" required>
    </div>
    <div>
        <input type="submit" value="remove" />
    </div>
    <a href="/listServices" >Back to previous page</a>
</form>
<%
}else{
%>

<a href="/listServices" >Back to previous page</a>

<%
    }
%>

</body>
</html>
