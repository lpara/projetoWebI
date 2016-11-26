<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Gerenciar Usuários</title>
</head>
<body>
	<table border=1>
		<thead>
			<tr>
				<th>Login</th>
				<th>Nome</th>
				<th colspan=2>Ações</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listaUsuarios}" var="user">
				<tr>
					<td><c:out value="${user.login}" /></td>
					<td><c:out value="${user.nome}" /></td>
					<td><a
						href="UserController?acao=atualizar&login=<c:out value="${user.login}"/>">Atualizar</a></td>
					<td><a
						href="UserController?acao=remover&login=<c:out value="${user.login}"/>">Remover</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>
		<a href="UserController?acao=adicionar">Adicionar Usuário</a>
	</p>
</body>
</html>