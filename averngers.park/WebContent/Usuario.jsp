<%@page import="br.com.fiap.averngers.park.beans.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% 

	Usuario usuario = new Usuario();
	usuario.setCpf(request.getParameter("cpf"));
	
	out.println(usuario.getCpf());

%>

</body>
</html>