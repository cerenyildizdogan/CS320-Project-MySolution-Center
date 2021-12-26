<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Requests</title>
</head>
<body>
<%
    String[][] data = (String[][]) session.getAttribute("myRequestData");

    if(data != null){
        for(String [] item : data){

%>
<p> <%
    for(int i = 0; i < item.length-1; i++){%>
    <%=item[i]+" , "%>
    <%
        }
    %>
    <%=item[item.length-1]%>
</p>
<%
        }
    }
%>
<a href="/residentPage" >Back to previous page</a>
</body>
</html>
