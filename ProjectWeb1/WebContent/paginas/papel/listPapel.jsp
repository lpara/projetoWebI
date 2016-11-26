<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Show All Roles</title>
</head>
<body>
    <table border=1>
        <thead>
            <tr>
                <th>Role Name</th>
                <th>Role Description</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listaPapeis}" var="role">
                <tr>
                    <td><c:out value="${role.codigo}" /></td>
                    <td><c:out value="${role.nome}" /></td>
                    <td><a href="PapelController?action=edit&nome=<c:out value="${role.nome}"/>">Update</a></td>
                    <td><a href="PapelController?action=delete&nome=<c:out value="${role.nome}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="PapelController?action=insert">Add Role</a></p>
</body>
</html>