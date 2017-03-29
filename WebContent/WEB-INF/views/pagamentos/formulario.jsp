<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="caelum" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
<c:import url="../cabecalho.jsp">
</c:import>
<div id="main">
<form:errors path="pagamento.nome" />
<form action="adicionaPagamento" method="post">
<fieldset>
<legend>Cadastrar Pagamento</legend>
<label for="nome">Nome: </label>
<input name="nome"        />
<br />
<label for="valor">Valor:</label>
<input name="valor"     />
<br />
<label for="data">Data: </label>
<caelum:campoData id="data" />
<br /> 
<input type="submit" value="Adicionar" />
</fieldset>
</form>
</div>
<c:import url="../rodape.jsp">
</c:import>
</body>
</html>