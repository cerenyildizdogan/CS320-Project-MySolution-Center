<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Report An Issue</title>
</head>
<body>
<p>Enter the service's information:</p>
<%
    String requestExpl = (String) session.getAttribute("level");
    int userid = (int) session.getAttribute("userid");
    if(requestExpl == null ){
%>
<p style="color: red" >${errorMessage}</p>
<form method="post">
    <div>
        Service's ID : <input type="text" name="serviceid" required/>
    </div>
    <div>
        Request's Explanation : <input type="text" name="requestExpl" required/>
    </div>
    <div>
        <input type="submit" value="Report An Issue" required/>
    </div>
</form>
<%
}else{
%>

<%
    }
%>
<a href="/residentPage" >Back to previous page</a>


</body>
</html>
