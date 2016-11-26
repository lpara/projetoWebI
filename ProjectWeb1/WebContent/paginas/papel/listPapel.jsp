<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Gerenciar Papel</title>
	<link rel="stylesheet" type="text/css" href="../../estiloTabela.css">
	<style>
		body{
			background-color:#11a6d4;
			}
	</style>
</head>

<body>
	<table align="center">
		<tr>
			<td id="header" colspan="5"><h1> Lista de Papéis</h1></td>
		</tr>
		<tr>
			<th>Código</th>
			<th>Nome</th>
			<th>Descrição</th>
			<th colspan="2">Ação</th>
		</tr>
		<tbody>
			<c:forEach items="${listaPapeis}" var="role">
				<tr>
                	<td><c:out value="${role.codigo}" /></td>
                    <td><c:out value="${role.nome}" /></td>
                    <td><c:out value="${role.descricao}" /></td>
                    <td><a href="PapelController?acaoPapel=atualizar&nome=<c:out value="${role.nome}"/>">Atualizar</a></td>
                    <td><a href="PapelController?acaoPapel=remover&nome=<c:out value="${role.nome}"/>">Remover</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="div-botao">
		<div class="botao">
			<a href="PapelController?acaoPapel=voltar">Voltar</a>
		</div>
		<div class="botao">
			<a href="PapelController?acaoPapel=adicionar">Adicionar Papel</a>
		</div>
	</div>
</body>
</html>