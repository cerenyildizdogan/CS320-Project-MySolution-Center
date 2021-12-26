<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List and Update The Current Requests</title>
</head>
<body>
<%
    String[][] data = (String[][]) session.getAttribute("requestData");

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
<a href="/updateRequests">Update request</a>
<a href="/doPage" >Back to previous page</a>
</body>
</html>
