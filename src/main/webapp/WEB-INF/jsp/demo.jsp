<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="app">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<script src="/crm/resources/js/jsDefault/jquery-3.2.1.min.js" ></script>
	<script src="https://code.angularjs.org/1.3.0/angular.min.js"></script>
	<script src="https://code.angularjs.org/1.3.0/angular-route.min.js"></script>
	<script src="/crm/resources/js/demoangular.js"></script>
</head>


<body ng-controller="PruebaController">
	{{producidoEvento}}
    <h1>{{mensaje}}</h1>
    
    
    <button ng-click="cambiarMensaje()">Cambio</button>
        <hr/>
        <div ng-controller="PruebaModulos">
       	<h1>{{mensaje}}</h1>
 		<button ng-click="cambioEnModulos()">cambioEnModulos</button>
	</div> 
<hr/>
<br/>

    Mensaje:<input ng-model="mensaje" >
<hr/>
	NIF:<input type="text" ng-model="seguro.nif" /><br>
	nombre:<input  type="text" ng-disabled="seguro.coberturas" ng-model="seguro.nombre" /><br>
	Dental:<input type="checkbox" ng-model="seguro.coberturas" />{{seguro.coberturas}}<br>
        
 <hr/>
	<button ng-click="llamada()">peticion</button>
          
    <input type="text" ng-model="trabajador.age" /><br>      
<hr/>

<table>
  <thead>
    <tr>
      <th>IdProvincia</th>
      <th>Nombre</th>
    </tr>
  </thead>
  <tbody>
    <tr ng-repeat="provincia in provincias">
      <td>{{provincia.idProvincia}}</td>
      <td>{{provincia.nombre}}</td>
    </tr>
  </tbody>
</table>

<select ng-model="provinciaSeleccion" ng-options="provincia as provincia.nombre for provincia in provincias track by provincia.idProvincia" >
  <option value="">--Elige opcion--</option>
</select>

{{provinciaSeleccion.idProvincia}}
          <hr/>
<input type="checkbox" ng-model="modelo.showApellido">¿Mostrar apellido?
<br>
<div ng-if="modelo.showApellido">
  Apellido: <input ng-model="modelo.apellido" >
  <br>
  El valor de "apellido" en el $scope del "ng-if" es : {{modelo.apellido}}
</div>
<hr/>
<ng-include src="'/crm/resources/aIncluir.html'"></ng-include>
----
<ng-include src="aIncluir"></ng-include>



<br><br><br><br><br><br><br><br><br>



</body>
</html>