<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.io.*,java.util.*" %>
<%@ page import = "javax.servlet.*,java.text.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<%
		if (session.getAttribute("validado") != "sim") {
			response.sendRedirect(request.getContextPath() + "/Login.html");
		}
%>

<%
         Date dNow = new Date( );
         SimpleDateFormat ft = 
         new SimpleDateFormat ("hh:mm:ss");
         out.print( "<h2 align=\"center\">" + ft.format(dNow) + "</h2>");
%>

</body>
</html>