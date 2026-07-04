<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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
	Usuario Logado : ${ usuarioLogado.login }
	<br><br>
	<ul>
		<c:forEach items="${ empresas }" var="empresa">
			<li>${ empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"  /></li>
			<a href="entrada?id=${empresa.id }&acao=AlteraEmpresa">Editar</a>
			<a href="entrada?id=${empresa.id}&acao=RemoveEmpresa">Excluir</a>
		</c:forEach>
	</ul>
</body>
</html>