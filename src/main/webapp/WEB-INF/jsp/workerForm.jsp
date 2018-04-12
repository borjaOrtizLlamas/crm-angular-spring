<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div>
  
<form:form method="POST" action="/crm/worker/add" modelAttribute="workerForm">  	
	nif
	<form:input path="nif" class="form-control"/>
	name
	<form:input path="name" class="form-control"/>
	surname
	<form:input path="surname" class="form-control"/>
	addrees
	<form:input path="address" class="form-control"/>
	
	
	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />
				<input type="submit" value="insertar anuncio"
class="btn btn-primary " />z		
</form:form>
</div>