<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" charset="utf-8">
<title>Insert title here</title>
	<link href="css/jquery-ui.css" rel="stylesheet">
	<link href="css/parte.css" rel="stylesheet">
	<link href="css/jquery-ui.theme.css" rel="stylesheet">
	<link href="css/jquery-ui.structure.css" rel="stylesheet">
<script src="js/jquery.js"></script>
<script src="js/jquery-ui.js"></script>
</head>
<body>
<c:import url="../cabecalho.jsp" /> 
<div id="main">
<table>
<thead>
<tr>
<th>Codigo </th>
<th>Nome </th>
<th>Valor </th> 
<th>Data </th>
<th>Remover </th>
<th>Alterar </th>
</tr>
</thead>
<tbody>
<c:forEach var="recebimento" items="${recebimentos}">
<tr>
<td>${recebimento.id} </td>
<td>${recebimento.nome} </td>
<td>${recebimento.valor}</td>
<td><fmt:formatDate value="${recebimento.data.time}" pattern="dd/MM/yyyy"/> </td>
<td><a href="removeRecebimento?id=${recebimento.id}">Remover</a> </td>
<td><a href="mostraRecebimento?id=${recebimento.id}">Mostra</a> </td>
</tr>
</c:forEach>
</tbody>
</table>
</div>
<c:import url="../rodape.jsp"></c:import>
</body>
</html>