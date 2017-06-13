<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="<tiles:getAsString name="ng-app"/>">
<head>
	<tiles:insertAttribute name="header" />
	<link rel="stylesheet" href='<tiles:getAsString name="css"/>'>
</head>
<body class="center">
<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">BORJA CRM</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="#">Home</a></li>
			<li><a href="#">Page 1</a></li>
			<li><a href="#">Page 2</a></li>
			<li><a href="#">Page 3</a></li>
		</ul>
	</div>
</nav>
	<tiles:insertAttribute name="body" />
   	<tiles:insertAttribute name="footer" />
  	<script src="<tiles:getAsString name="js" />" ></script>
  	<input type="hidden" id="token"  value="${_csrf.parameterName}=${_csrf.token}" /> 
</body>
</html>


