<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:url value="/entrada" var="linkServletNovaEmpresa"/>
<!DOCTYPE html>
<html>
<head>
<title>Cadastro de empresa</title>
</head>
<body>

	<form method="post" action="${linkServletNovaEmpresa}">
		<label>Login:</label><input type="text" name="login">
		<label>Senha</label><input type="password" name="senha">
		
		<input type="hidden" value="Login" name="acao">
		<input value="Submeter" type="submit">
	</form>
</body>
</html>