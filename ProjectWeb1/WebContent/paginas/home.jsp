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
		<form action="/usuario/UserController?acao=listar" method="get">
			<div id="navegar-box-user">
				<div id="navegar-box-interno-user">
					<div id="botoes-user">
						<div id="botao-user">
							<!--  <input type="submit" value="Gerenciar Usuario">-->
							<p><a href="usuario/UserController?acao=listar">Gerenciar Usuario</a></p>
						</div>
						
					</div>
				</div>
			</div>
		</form>
		
		
		
		<form action="/papel/PapelController?acaoPapel=listar" method="get">
			<div id="navegar-box-papel">
				<div id="navegar-box-interno-papel">
					<div id="botoes-papel">
						<div id="botao-papel">
							<!-- <input type="submit" value="Gerenciar Papel"> -->
							<p><a href="papel/PapelController?acaoPapel=listar">Gerenciar Papel</a></p>
						</div>
						
					</div>
				</div>
			</div>
		</form>
	</body>
</html>