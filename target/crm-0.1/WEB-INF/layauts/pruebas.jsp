<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="app">
  <head>
    <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.19/angular.js"></script>
    <script src="resources/js/prueba.js"></script>
    <script src="resources/js/remoteresource.js"></script>
  </head>
  <body ng-controller="SeguroController">
    <form>
      <fieldset>
        <legend>Seguro Médico</legend>
          <label for="nif">NIF:</label><input id="nif" name="nif" type="text" ng-model="seguro.nif" /><br>
          <label for="nombre">Nombre:</label><input id="nombre" name="nombre" type="text" ng-model="seguro.nombre" /><br>
          <label for="ape1">1º Apellido:</label><input id="ape1" name="ape1" type="text" ng-model="seguro.ape1" /><br>
          <label for="edad">Edad:</label><input id="edad" name="edad" type="text" ng-model="seguro.edad" /><br>
          <label for="sexo">Sexo:</label><select id="sexo" name="sexo" type="checkbox" ng-model="seguro.sexo" ><option value="">--Elige opcion--</option><option value="H">Hombre</option><option value="M">Mujer</option></select><br>
          <label for="casado">Casado:</label><input id="casado" name="casado" type="checkbox" ng-model="seguro.casado" /><br>
          <label for="numHijos">Nº Hijos:</label><input id="numHijos" name="numHijos" type="text" ng-model="seguro.numHijos" /><br>
          <label for="embarazada">Embarazada:</label><input id="embarazada" name="embarazada" type="checkbox" ng-model="seguro.embarazada" /><br>
          <label for="fechaCreacion">Fecha de creaci&oacute;n:</label><input id="fechaCreacion" name="fechaCreacion" type="text" ng-model="seguro.fechaCreacion" /><br>
      </fieldset>
      <fieldset>
        <legend>Coberturas</legend>
          <label for="oftalmologia">Oftalmologia:</label><input id="oftalmologia" name="oftalmologia" type="checkbox" ng-model="seguro.coberturas.oftalmologia" /><br>
          <label for="dental">Dental:</label><input id="dental" name="dental" type="checkbox" ng-model="seguro.coberturas.dental" /><br>
          <label ng-show="seguro.sexo==='M'" for="fecundacionInVitro">Fecundacion In Vitro:</label><input ng-show="seguro.sexo==='M'" id="fecundacionInVitro" name="fecundacionInVitro" type="checkbox" ng-model="seguro.coberturas.fecundacionInVitro" /><br>
      </fieldset>      
      <fieldset>
      <legend>Enfermedades</legend>
          <label for="corazon">Corazon:</label><input id="corazon" name="corazon" type="checkbox" ng-model="seguro.enfermedades.corazon" /><br>
          <label for="estomacal">Estomacal:</label><input id="estomacal" name="estomacal" type="checkbox" ng-model="seguro.enfermedades.estomacal" /><br>
          <label for="rinyones">Ri&ntilde;ones:</label><input id="rinyones" name="rinyones" type="checkbox" ng-model="seguro.enfermedades.rinyones" /><br>
          <label for="alergia">Alergia:</label><input id="alergia" name="alergia" type="checkbox" ng-model="seguro.enfermedades.alergia" /><br>
          <label for="nombreAlergia">Nombre de la alergia:</label><input ng-disabled="seguro.enfermedades.alergia===false" id="nombreAlergia" name="nombreAlergia" type="text" ng-model="seguro.enfermedades.nombreAlergia" /><br>
      </fieldset> 
    </form>
  </body>
</html>