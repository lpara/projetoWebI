<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv = "Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login</title> 
	</head>
	<body>
		<form action="logar" method="post">
			<h1>Bem vindo!</h1>
			<fieldset>
				<p> <input type="text" name="login" placeholder="Usuario..">
				<p> <input type="password" name="senha" placeholder="Senha..">
				<p> <input type="submit" value="logar">
			</fieldset>
		</form>
	</body>
</html>