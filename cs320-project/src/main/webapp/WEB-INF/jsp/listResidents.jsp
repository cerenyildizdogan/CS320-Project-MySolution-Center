<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Residents</title>
</head>
<body>
<%
    String[][] data = (String[][]) session.getAttribute("residentData");

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
<a href="/addResident" >Add resident</a>
<a href="/removeResident" >Remove resident</a>
<a href="/doPage" >Back to previous page</a>
</body>
</html>
