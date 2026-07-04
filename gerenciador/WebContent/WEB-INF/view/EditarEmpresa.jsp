<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <c:url value="/entrada" var="linkEntradaEmpresa"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import url="logout-parcial.jsp"></c:import>
	<form action="${linkEntradaEmpresa }" method="post">
		<label>Nome</label><input type="text" name="nome" value="${empresa.nome} ">
		<label>Data de abertura</label><input type="text" name="data" value='<fmt:formatDate value="${empresa.dataAbertura }" pattern="dd/MM/yyyy"/>'>
		<input type="hidden" value="${empresa.id }" name="id">
		<input type="hidden" value="EditarEmpresa" name="acao">
		<input type="submit" value="Editar">
	</form>
</body>
</html>