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
<c:import url="logout-parcial.jsp"></c:import>
	<form method="post" action="${linkServletNovaEmpresa}">
		<label>Nome:</label><input type="text" name="nome">
		<label>Data de Abertura</label><input type="text" name="data">
		<input type="hidden" value="NovaEmpresa" name="acao">
		<input value="Submeter" type="submit">
	</form>
</body>
</html>