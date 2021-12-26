<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Requests</title>
</head>
<body>
<p>Enter the Request's id you want to update</p>
<%
    String name = (String) session.getAttribute("level");


    if(name == null){
%>
<p style="color: red" >${errorMessage}</p>
<form method="post">
    <div>
        Request ID = <input type="text" name="requestid" required>
    </div>
    <div>
        <input type="submit" value="Update" />
    </div>
    <a href="/listRequests" >Back to previous page</a>
</form>
<%
}else{
%>

<a href="/updateRequests">Update another request</a>
<a href="/listRequests" >Back to previous page</a>

<%
    }
%>
</body>
</html>
