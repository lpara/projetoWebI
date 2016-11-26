<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta http-equiv = "Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Permissões</title> 
        <link rel="stylesheet" type="text/css" href="estilo.css">
        <style>
            body{
                background-color:#11a6d4;
                }
        </style>
</head>
<body>
    <table border=1>
    
        <thead>
        
            <caption>Lista de Papeis</caption>
        
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Descricao</th>
                <th colspan=2>Ações</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listaPapeisDisponiveis}" var="papel">
                <tr>
                    <td><c:out value="${papel.codigo}" /></td>
                    <td><c:out value="${papel.nome}" /></td>
                    <td><c:out value="${papel.descricao}" /></td>
                    <td><a href="PermissaoController?acaoPermissao=adcionar&login=<c:out 
                        value="${user.login}"/>&papel=<c:out value="${papel.codigo}"/>" >Adicionar</a>
                        </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>


<br><br><br><br>
    
    <table border=1>
    
        <thead>
        
            <caption>Lista de Papeis do Usuario</caption>
        
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Descricao</th>
                <th colspan=2>Ações</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${user.papeis}" var="papel">
                <tr>
                    <td><c:out value="${papel.codigo}" /></td>
                    <td><c:out value="${papel.nome}" /></td>
                    <td><c:out value="${papel.descricao}" /></td>
                    <td><a href="PermissaoController?acaoPermissao=remover&login=<c:out 
                        value="${user.login}"/>&papel=<c:out value="${papel.codigo}"/>">Remover</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
        <div id="botao">
            <p><a href="/projetoWeb/paginas/usuario/UserController?acao=permissoes">Voltar</a></p>
        </div>
</body>
</html>




