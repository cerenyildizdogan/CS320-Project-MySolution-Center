<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Resident</title>
</head>
<body>
<p>Enter the resident's information:</p>
<%
    String email = (String) session.getAttribute("level");

    if(email == null ){
%>
<p style="color: red" >${errorMessage}</p>
<form method="post">
    <div>
        Name : <input type="text" name="username" required/>
    </div>
    <div>
        Password : <input type="password" name="userpassword" required/>
    </div>
    <div>
        Email : <input type="text" name="email" required/>
    </div>
    <div>
        GSM : <input type="text" name="gsm" required/>
    </div>
    <div>
        Room Number : <input type="text" name="roomnumber"/>
    </div>
    <div>
        <input type="submit" value="add resident" required/>
    </div>
</form>
<%
}else{
%>

<a href="/listResidents" >Back to previous page</a>
<%
    }
%>
<a href="/listResidents" >Back to previous page</a>
</body>
</html>
