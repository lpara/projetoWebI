<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type="text/css"
	href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
<title>Add new user</title>
</head>
<body>
	<script>
        $(function() {
            $('input[name=dob]').datepicker();
        });
    </script>

	<form method="POST" action='UserController' name="frmAddUser">
		Nome : <input type="text" name="nome" placeholder="Informe Seu Nome"
			value="<c:out value="${user.nome}" />" /> <br /> Login : <input
			type="text" name="login" placeholder="Informe Seu Login"
			value="<c:out value="${user.login}" />" /> <br /> Senha : <input
			type="password" name="senha" placeholder="Informa Sua Senha"
			value="<c:out value="${user.senha}" />" /> <br /> Confirmar Senha :
		<input type="password" name="confirmaSenha"
			placeholder="Confirme Sua Senha"
			value="<c:out value="${user.confirmaSenha}" />" /> <br /> <input
			type="submit" value="${operacao}" />
	</form>
</body>
</html>