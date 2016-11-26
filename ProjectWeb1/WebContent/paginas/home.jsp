<%@page import="br.unirn.dominio.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Página Principal</title>
		<link rel="stylesheet" type="text/css" href="../estilo.css">
		<link rel="stylesheet" type="text/css" href="../estiloTabela.css">
		<style>
			body{
				background-color:#11a6d4;
				}
		</style>
	</head>
	
	<body>
		<div id="login-box">
			<div id="login-box-interno">
				<div id="login-box-label">
					Menu
				</div>
				<div class="input-div" align="center">
					<div class="botao" style="width: 157px;">
						<form action="/usuario/UserController?acao=listar" method="get">
							<a href="usuario/UserController?acao=listar">Gerenciar Usuário</a>
						</form>
					</div>
					<div class="botao" style="width: 160px;">
						<form action="/papel/PapelController?acaoPapel=listar" method="get">
							<a href="papel/PapelController?acaoPapel=listar">Gerenciar Papel</a>
						</form>
					</div>
					<div class="botao">
						<form action="/papel/PapelController?acaoPapel=listar" method="get">
							<a href="papel/PapelController?acaoPapel=listar">Gerenciar Permissões</a>
						</form>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>