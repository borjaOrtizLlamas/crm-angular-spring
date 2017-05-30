<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div ng-controller="PruebaController">
	<h1 ng-bind="mensaje"></h1>
	<button ng-click="cambiarMensaje()">Cambio</button>
	<input ng-model="mensaje">

	<form>
		<fieldset>
			<legend>Nuevo usuario</legend>
			<label for="nif">NIF:</label> <input id="nif" name="nif" type="text"
				ng-model="usuario.nif" /><br> <label for="nombre">Nombre:</label>
			<input id="nombre" name="nombre" type="text"
				ng-model="usuario.nombre" /><br> <label for="ape1">1º
				Apellido:</label> <input id="ape1" name="ape1" type="text"
				ng-model="usuario.ape1" /><br> <label for="edad">Edad:</label>
			<input id="edad" name="edad" type="text" ng-model="usuario.edad" /><br>
			<label for="sexo">Sexo:</label> <select id="sexo" name="sexo"
				type="checkbox" ng-model="usuario.sexo"><option value="">--Elige
					opcion--</option>
				<option value="H">Hombre</option>
				<option value="M">Mujer</option></select><br> <label for="casado">Casado:</label>
			<input id="casado" name="casado" type="checkbox"
				ng-model="usuario.casado" /><br> <label for="numHijos">Nº
				Hijos:</label> <input id="numHijos" name="numHijos" min="0" max="10"
				type="range" ng-model="usuario.numHijos" />{{usuario.numHijos}}<br>
			<label for="numHijos">ayuda por hijos</label> <input
				ng-disabled="ayudaPosHijosDesavilitado()" id="ayudaPorHijos"
				name="ayudaPorHijos" type="checkbox"
				ng-model="usuario.ayudaPorHijos" /><br> <label
				for="fechaCreacion">Fecha de creaci&oacute;n:</label> <input
				id="fechaCreacion" name="fechaCreacion" type="text"
				ng-model="usuario.fechaCreacion" /><br> <label for="salario">Salario</label>
			<input id="salario" name="salario" type="text"
				ng-model="usuario.salario" /><br> <label for="rango">rango</label>
			<select id="rango" name="sexo" type="checkbox"
				ng-model="usuario.rango">
				<option value="">--Elige opcion--</option>
				<option value="jefe">jefe</option>
				<option value="trabajador">trabajador</option>
			</select><br> <label ng-show="mostrarJefe()"
				for="numeroTrabajadoresBajoServicio">Numero Trabajadores
				Bajo Servicio</label> <input ng-show="mostrarJefe()"
				id="numeroTrabajadoresBajoServicio"
				name="numeroTrabajadoresBajoServicio" type="number"
				ng-model="usuario.numeroTrabajadoresBajoServicio" /><br>
			<button ng-click="calculoIRF()">Click Me!</button>
			{{usuario.valorIRPF}}
		</fieldset>
	</form>

	<hr>
	<h2>Contraseña cifrada</h2>

	<input ng-change="contrasenaCifrada()" type="text"
		ng-model="usuarioSesion.contrasena" /><br>
	{{usuarioSesion.hashcontrasena}}
	<h3 ng-mousemove="myFunc($event)">Mouse Over Me!</h3>
	<p>Coordinates: {{x + ', ' + y}}</p>

	<hr>
	repitiendo arrays:
	<table>
		<thead>
			<tr>
				<th>IdProvincia</th>
				<th>Nombre</th>
				<th>Nº fila</th>
				<th>Nº fila</th>

			</tr>
		</thead>
		<tbody>
			<tr ng-repeat="usuario in usuarios | orderBy:'ape1'| limitTo:2 "
				style="background-color: {{$even?'white':'yellow'}}">
				<td>{{usuario.ape1}}</td>
				<td>{{usuario.casado}}</td>
				<td>{{usuario.salario}}</td>
				<td>{{usuario.numHijos}}</td>
			</tr>
		</tbody>
	</table>

	<hr>
	<select ng-model="miProvinciaSeleccionada"
		ng-options="usuario as usuario.nombre for usuario in usuarios track by usuario.nif">
		<option value="">--Elige opcion--</option>
	</select>
	<hr>
	<h2>Formatos de fechas</h2>

	<div>date:"yyyy/MM/dd" = {{ fecha | date:"yyyy/MM/dd" }}</div>
	<div>date:"medium" = {{ fecha | date:"medium" }}</div>
	<div>date:"short" = {{ fecha | date:"short" }}</div>
	<div>date:"fullDate" = {{ fecha | date:"fullDate" }}</div>
	<div>date:"longDate" = {{ fecha | date:"longDate" }}</div>
	<div>date:"mediumDate" = {{ fecha | date:"mediumDate" }}</div>
	<div>date:"shortDate" = {{ fecha | date:"shortDate" }}</div>
	<div>date:"mediumTime" = {{ fecha | date:"mediumTime" }}</div>
	<div>date:"shortTime" = {{ fecha | date:"shortTime" }}</div>
	<div>date = {{ fecha | date }}</div>
	<hr>
	<h2>Formatos de monedas</h2>
	<div>currency = {{ numeroDecimal | currency: "€" }}</div>
	<hr>
	<h2>Formatos letras</h2>
	<div>lowercase = {{ mensaje | lowercase }}</div>
	<div>uppercase = {{ mensaje | uppercase }}</div>
	<hr>
	<h2>filtros </h2>
	<table>
		<thead>
			<tr>
				<th>IdProvincia</th>
				<th>Nombre</th>
				<th>Nº fila</th>
				<th>Nº fila</th>

			</tr>
		</thead>
		<tbody>
			<tr ng-repeat="usuario in usuarios |  filter:'O' "
				style="background-color: {{$even?'white':'yellow'}}">
				<td>{{usuario.ape1}}</td>
				<td>{{usuario.nombre}}</td>
				<td>{{usuario.casado}}</td>
				<td>{{usuario.salario}}</td>
				<td>{{usuario.numHijos}}</td>
			</tr>
		</tbody>
	</table>
	<hr>
	<h2>filtros con variable</h2>
	<input id="salario"  ng-model="busqueda" />
	<table>
		<thead>
			<tr>
				<th>IdProvincia</th>
				<th>Nombre</th>
				<th>Nº fila</th>
				<th>Nº fila</th>

			</tr>
		</thead>
		<tbody>
			<tr ng-repeat="usuario in usuarios | filter: busqueda " style="background-color: {{$even?'white':'yellow'}}">
				<td>{{usuario.ape1}}</td>
				<td>{{usuario.casado}}</td>
				<td>{{usuario.nombre}}</td>
				<td>{{usuario.salario}}</td>
				<td>{{usuario.numHijos}}</td>
			</tr>
		</tbody>
	</table>
	<hr>
	
	
</div>