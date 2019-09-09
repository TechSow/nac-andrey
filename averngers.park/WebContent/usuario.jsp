<%@page import="br.com.fiap.averngers.park.beans.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% Usuario usuario =  (Usuario) request.getAttribute("usuario"); %>
<%= usuario.toString() %>
funciona o dispatcher pelo menos
</body>
</html>