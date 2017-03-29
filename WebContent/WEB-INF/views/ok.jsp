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
<c:import url="cabecalho.jsp"></c:import>
<h1>ola </h1>

<div id="main">
<form id="oi"> 
<label for="nome">Nome: </label>
<input name="a1"  id="a1"    />  <br>
<button id="ui-button" class="ui-button">Value </button>
</form>
</div>
<c:import url="rodape.jsp"></c:import>
</body>
</html>