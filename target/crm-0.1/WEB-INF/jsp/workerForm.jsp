<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="col-xs-12" ng-controller="workAddController">
	<form name='workersForm' method="POST" action="/crm/worker/addWorker">
		<div class="row">	 	
			<label for="nif" class="col-xs-12"><spring:message code="label.nif"/> </label>
	 		<input id="nif" ng-change="nifValidate()" class="col-xs-12" name="nif" type="text" ng-model="worker.nif" />
			<div>
			{{validaciones.falloDni}}
			</div>
		</div>
		<div class="row">	 	
			<label for="name" class="col-xs-12"><spring:message code="label.name"/> </label>
		 	<input id="name" class="col-xs-12" name="name" type="text" ng-model="worker.name" />
		</div>
		<div class="row">
			<label for="surname" class="col-xs-12"><spring:message code="label.surname"/> </label>
	 		<input id="surname" class="col-xs-12" name="surname" type="text" ng-model="worker.surname" />
		</div>
		<div class="row">
			<label for="age" class="col-xs-12"><spring:message code="label.age"/> </label>
	 		<input id="age" class="col-xs-12" name="age" type="text" ng-model="worker.age" />
		</div>
		<div class="row">
		 	<label for="sex" class="col-xs-12"><spring:message code="label.sex"/> </label>
		 	<input id="sex" class="col-xs-12" name="sex" type="text" ng-model="worker.sex" />
		</div>
		<div class="row">
		 	<label for="married" class="col-xs-12"><spring:message code="label.married"/> </label>
		 	<input id="married" class="col-xs-12" name="married" type="checkbox" ng-model="worker.married" />
		</div>

		<div class="row">
		 	<label for="numberSon" class="col-xs-12"><spring:message code="label.numberSon"/> </label>
		 	<input id="numberSon" class="col-xs-12" name="numberSon" type="text" ng-model="worker.numberSon" />
		</div>

		<div class="row">
		 	<label for="salary" class="col-xs-12"><spring:message code="label.salary"/> </label>
		 	<input id="salary" class="col-xs-12" name="salary" type="text" ng-model="worker.salary" />
		</div>
		
		<div class="row">
		 	<label for="fristDay" class="col-xs-12"><spring:message code="label.fristDay"/> </label>
		 	<input id="fristDay" class="col-xs-12" name="fristDay" type="text" ng-model="worker.fristDay" />
		</div>

		<div class="row">
		 	<label for="lastDay" class="col-xs-12"><spring:message code="label.lastDay"/> </label>
		 	<input id="lastDay" class="col-xs-12" name="lastDay" type="text" ng-model="worker.lastDay" />
		</div>
   		<input type="submit" value="Submit">

 		
   		<button type="button" class="btn btn-primary" ng-click="newWorker()">Click Me!</button>
<br/><br/><br/>
	 </form>
 
</div>