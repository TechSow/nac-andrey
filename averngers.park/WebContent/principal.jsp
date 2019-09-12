<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Avengers Park</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="style.css" />
<link rel="shortcut icon" type="image/x-icon" href="image/favicon.ico">
</head>
<body>


	<%
		if (session.getAttribute("validado") != "sim") {
			response.sendRedirect(request.getContextPath() + "/Login.html");
		}
	%>


	<br>
	<br>

	<form action="LogoutServlet" method="post">
		<input type="submit" value="Logout">
	</form>

</body>
</html>