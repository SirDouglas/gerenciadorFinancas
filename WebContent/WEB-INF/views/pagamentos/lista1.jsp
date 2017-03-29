<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="caelum" %>
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
<form action="listaPagamentosMes" method="post">
<label for="data">Data:</label>
<caelum:campoData id="data"></caelum:campoData> <br>
<label for="data1">Data1:</label>
<caelum:campoData id="data1"></caelum:campoData> <br>	
<input type="submit" value="Submeter" />
</form>
	
<br>	<br>	<br>

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
<c:forEach var="pagamento" items="${pagamentos}">
<tr>
<td>${pagamento.id} </td>
<td>${pagamento.nome} </td>
<td>${pagamento.valor}</td>
<td><fmt:formatDate value="${pagamento.data.time}" pattern="dd/MM/yyyy"/> </td>
<td><a href="removePagamento?id=${pagamento.id}">Remover</a> </td>
<td><a href="mostraPagamento?id=${pagamento.id}">Mostra</a> </td>
</tr>
</c:forEach>
</tbody>
</table>
</div>
<c:import url="../rodape.jsp"></c:import>
</body>
</html>