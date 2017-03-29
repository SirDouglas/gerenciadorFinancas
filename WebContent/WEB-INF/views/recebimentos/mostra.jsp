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
<form action="alteraRecebimento" method="post">
<fieldset>
<legend>Alterar Recebimento </legend>

<input type="hidden" name="id" value="${recebimento.id}">
<label for="nome">Nome:</label>
<input type="text" name="nome" value="${recebimento.nome}" /> <br/>
<label for="valor">Valor:</label>
<input type="text" name="valor"  value="${recebimento.valor}" /> <br />
<label for="data">Data</label>
<fmt:formatDate value="${recebimento.data.time}" var="dia"/>
<caelum:campoData id="data" value="${dia}" />
<br />
<input type="submit" value="Alterar">
</fieldset>
</form>
</div>
<c:import url="../rodape.jsp"></c:import>
</body>
</html>