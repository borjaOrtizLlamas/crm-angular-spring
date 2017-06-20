<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container"  ng-controller="workAddController">
	<form class="form-group">
		<div class="row" > 	 
			<div class="col-xs-12 col-sm-6" ng-class="validateCSS">	
				<div class="row ">
					<label for="nif" class="col-xs-2 col-sm-2 control-label"><spring:message code="label.nif"/></label>
	 				<input class=" col-xs-10 col-sm-10 form-control" ng-change="nifValidate()" type="text" ng-model="worker.nif" />
					<div ng-show="validaciones.falloDniValue===1"><spring:message code="label.dniWrong"/></div>
					<div ng-show="validaciones.falloDniValue===2"><spring:message code="label.dniRepeat"/></div>
				</div>
			</div>
			<label for="name" class="col-xs-2 col-sm-1"><spring:message code="label.name"/> </label>
		 	<input id="name" class="col-xs-10 col-sm-5" name="name" type="text" ng-model="worker.name" />
		 </div>
		<div class="row">
			<label for="surname" class="col-xs-2 col-sm-1"><spring:message code="label.surname"/> </label>
	 		<input id="surname" class="col-xs-10 col-sm-5" name="surname" type="text" ng-model="worker.surname" />
			<label for="age" class="col-xs-2 col-sm-1"><spring:message code="label.age"/> </label>
	 		<input id="age" class="col-xs-10 col-sm-5" name="age" type="text" ng-model="worker.age" />
		</div>
		<div class="row">
			<label for="sex" class="col-xs-2 col-sm-1"><spring:message code="label.sex"/> </label>
			<select  id="sex" class="col-xs-10 col-sm-5" name="sex" type="text" ng-model="worker.sex" >
				<option value="M"><spring:message code="label.women"/></option>
				<option value="H"><spring:message code="label.men"/></option>
			</select>
		 	<label for="married" class="col-xs-2 col-sm-1"><spring:message code="label.married"/> </label>
		 	<input id="married" class="col-xs-10 col-sm-5" name="married" type="checkbox" ng-model="worker.married" />
		</div>
		<div class="row">
		 	<label for="numberSon" class="col-xs-2 col-sm-1"><spring:message code="label.numberSon"/> </label>
		 	<input id="numberSon" class="col-xs-10 col-sm-5" name="numberSon" type="text" ng-model="worker.numberSon" />
		 	<label for="salary" class="col-xs-2 col-sm-1"><spring:message code="label.salary"/> </label>
		 	<input id="salary" class="col-xs-10 col-sm-5" name="salary" type="text" ng-model="worker.salary" />
		</div>
		
		<div class="row">
		 	<label for="fristDay" class="col-xs-2 col-sm-1"><spring:message code="label.fristDay"/> </label>
		 	<input id="fristDay" class="col-xs-10 col-sm-5" name="fristDay" type="text" ng-model="worker.fristDay" />
		 	<label for="lastDay" class="col-xs-2 col-sm-1"><spring:message code="label.lastDay"/> </label>
		 	<input id="lastDay" class="col-xs-10 col-sm-5" name="lastDay" type="text" ng-model="worker.lastDay" />
		</div>
		<div class="row">
		 	<label for="address" class="col-xs-1 col-sm-1"><spring:message code="label.address"/> </label>
		 	<input id="address" class="col-xs-10 col-sm-5" name="address" type="text" ng-model="worker.address" />
		 <div ng-hide="mapCheck">	<input id="address" class="col-xs-1 col-sm-1" type="checkbox"  ng-model="mapCheck" /><spring:message code="label.maps"/>
		    </div>
		    <ui-gmap-google-map class="col-xs-12 col-sm-6"   center="map.center" zoom="map.zoom">
	<!-- 	        <ui-gmap-window coords="map.center" show="true" options="map.options"></ui-gmap-window>
	 -->	</ui-gmap-google-map>
		</div>
		
		hpñ{{mapss.latitude}}
   		<button type="button" class="btn btn-primary" ng-click="newWorker()">Click Me!</button>
<br/><br/><br/>
	 </form>
 
</div>