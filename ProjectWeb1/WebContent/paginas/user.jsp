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
<title>Adicionar Novo Usuário</title>
<link rel="stylesheet" type="text/css" href="../estilo.css">
<style>
	body{
		background-color:#11a6d4;
		}
</style>
</head>
<body>
	<script>
        $(function() {
            $('input[name=dob]').datepicker();
        });
    </script>

	<form method="POST" action='UserController' name="frmAddUser">
		<div id="login-box">
			<div id="login-box-interno2">
				<div id="login-box-label">
					Adicionar Novo Usuário
				</div>
				<div class="input-div" id="input-usuario"><font face="sans-serif"><b> Nome:</b></font>
					<input type="text" value="<c:out value="${user.nome}" />" placeholder="Informe Seu Nome" name="nome">	
				</div>
				<div class="input-div" id="input-login"><font face="sans-serif"><b> Login:</b></font>
					<input type="text" value="<c:out value="${user.login}" />" placeholder="Informe Seu Login" name="login">	
				</div>
				
				<div class="input-div" id="input-senha"><font face="sans-serif"><b> Senha:</b></font>
					<input type="password"  value="<c:out value="${user.senha}" />" name="senha" placeholder="Informe Sua Senha">	
				</div>
				
				<div class="input-div" id="input-confirma-senha"><font face="sans-serif"><b> Confirmar Senha:</b></font>
					<input type="password"  value="<c:out value="${user.confirmaSenha}" />" name="confirmaSenha" placeholder="Confirme Sua Senha">	
				</div>
				
				<div id="botoes">
					<div id="botao">
						<input type="submit" value="${operacao}">
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>