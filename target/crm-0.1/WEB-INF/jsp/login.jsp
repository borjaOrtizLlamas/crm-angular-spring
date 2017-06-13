<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<form name='loginForm' 	action="<c:url value='/j_spring_security_check' />" method='POST'>
	<hr>
	<label for='usuario'><spring:message code="label.firstname"/> Nombre de usuario:</label>
	<input type='text' name='username' class="form-control" />
	<label for='contrasena'>Contraseña:</label>
	<input type='password' name='password' class="form-control" />
	<input name="submit" type="submit" value="Iniciar sesión"		class="btn btn-primary" />
	<hr>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>


<sec:authorize access="isAuthenticated()">
	hola
</sec:authorize>