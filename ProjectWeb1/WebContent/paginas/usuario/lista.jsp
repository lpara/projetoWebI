<%@page import="br.unirn.dominio.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Página Principal</title>
	</head>
	
	<body>
		<h2>Usuário Logado</h2> <%=((Usuario) session.getAttribute("usuarioLogado")).getNome()  %>
		<a href="/projetoWeb/sair">Sair</a>
	</body>
</html>