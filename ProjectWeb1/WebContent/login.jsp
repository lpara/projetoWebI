<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv = "Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login</title> 
		<link rel="stylesheet" type="text/css" href="estilo.css">
		<style>
			body{
				background-color:#11a6d4;
				}
		</style>
	</head>
	<body>
		<form action="logar" method="post">
			<div id="login-box">
				<div id="login-box-interno">
					<div id="login-box-label">
						Entrar no Sistema
					</div>
					<div class="input-div" id="input-usuario">
						<input type="text" placeholder="Usuário" name="login">	
					</div>
					<div class="input-div" id="input-senha">
						<input type="password"  name="senha" placeholder="Senha">	
					</div>
					
					<div id="botoes">
						<div id="botao">
							<input type="submit" value="Entrar">
						</div>
					</div>
				</div>
			</div>
		</form>
	</body>
</html>