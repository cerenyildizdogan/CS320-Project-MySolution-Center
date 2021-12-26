<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Service</title>
</head>
<body>
<p>Enter the service's information:</p>
<%
    String name = (String) session.getAttribute("level");

    if(name == null ){
%>
<p style="color: red" >${errorMessage}</p>
<form method="post">
    <div>
        Service's Name : <input type="text" name="serviceName" required/>
    </div>
    <div>
        Service's Explanation : <input type="text" name="serviceExpl" required/>
    </div>
    <div>
        <input type="submit" value="Add Service" required/>
    </div>
</form>
<%
}else{
%>

<a href="/listServices" >Back to previous page</a>
<%
    }
%>
<a href="/listServices" >Back to previous page</a>
</body>
</html>
