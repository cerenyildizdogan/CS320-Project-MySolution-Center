<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Services</title>
</head>
<body>
<%
    String[][] data = (String[][]) session.getAttribute("serviceData");

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
<a href="/addService" >Add service</a>
<a href="/removeService" >Remove service</a>
<a href="/doPage" >Back to previous page</a>
</body>
</html>
