<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Gerenciar Usuários</title>

<style>
	body{
		font-family: sans-serif;
		font-size: 11pt;
		background-color:#11a6d4;
	}
	table, th, td{
		border: 1px solid black;
		border-collapse:collapse;
		opacity:0.95;
	}
	table{
		width:80%;
	}
	th, td{
		padding: 10px;
		text-align: center;
	}
	th{
		background-color: #a70000;
		color:white;
	}
	tr:nth-child(even){
		background-color: #eBeBeB;
	}
	tr:nth-child(odd){
		background-color: white;
	}
	#header{
		background-color:1992b7;
		color:black;
		font:bold 12px sans-serif;
	}
	#botao{
		background:    #fff;
		background:    -webkit-linear-gradient(#fff, #fff);
		background:    linear-gradient(#fff, #fff);
		border:        1px solid #569;
		border-radius: 5px;
		box-shadow:    0 1px 0 0 #444;
		color:         #666;
		display:       inline-block;
		padding:       8px 20px;
		font:          normal 700 18px/1 "Calibri", sans-serif;
		text-align:    center;
		text-shadow:   0px 0px 0 #000;
	}
	.div-botao{
		width:1000px;
		height:47px;
		padding-left:573px;
		padding-top:26px;
	}
</style>

</head>
<body>
	<table align="center">
		<tr>
			<td id="header" colspan="4"><h1> Lista dos Usuários</h1></td>
		</tr>
		<tr>
			<th>Login</th>
			<th>Nome</th>
			<th colspan="2">Ações</th>
		</tr>
		<tbody>
			<c:forEach items="${listaUsuarios}" var="user">
				<tr>
					<td><c:out value="${user.login}" /></td>
					<td><c:out value="${user.nome}" /></td>
					<td><a href="UserController?acao=atualizar&login=<c:out value="${user.login}"/>">Atualizar</a></td>
					<td><a href="UserController?acao=remover&login=<c:out value="${user.login}"/>">Remover</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="div-botao">
		<div id="botao">
			<a href="UserController?acao=adicionar">Adicionar Usuário</a>
		</div>
		<div id="botao-voltar">
			<a href="UserController?acao=voltar">Voltar</a>
		</div>
	</div>

</body>
</html>