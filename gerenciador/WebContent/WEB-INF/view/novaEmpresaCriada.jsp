<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import url="logout-parcial.jsp"></c:import>
	<c:if test="${not empty empresa }">
		Empresa <b>${ empresa }</b> cadastrada com sucesso!
	</c:if>
	
	<c:if test="${empty empresa}">
		Não existe empresas
	</c:if>	
</body>
</html>