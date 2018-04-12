var moduloT=angular.module("T",[]);
var moduloA=angular.module("A",["T"]);
var moduloB=angular.module("B",[]);
 
var app=angular.module("app",["A","B"]);


app.value("tamanyoInicialRectangulo",{
	  ancho:5,
	  alto:3
	});
	 
function Rectangulo(tamanyoInicial) {
	  this.ancho=tamanyoInicial.ancho;
	  this.alto=tamanyoInicial.alto;
	   
	  this.setAncho=function(ancho) {
	    this.ancho=ancho;
	  }
	   
	  this.setAlto=function(alto) {
	    this.alto=alto;
	  }  
	   
	  this.getArea=function() {
	    return this.ancho * this.alto;
	  }
	}

app.service("rectangulo",['tamanyoInicialRectangulo',Rectangulo]);
	
moduloB.value("matematicas_simples",{
	  sumar:function(a,b) {
	    return a+b;
	  },
	  restar:function(a,b) {
	    return a-b;
	  }
	});


moduloT.constant("miServicioConstante","Hola mundo desde constante");
var seguro= {
	    nif:"",
	    nombre:"nombre",
	    coberturas : false
}; 

var llamadahttps = function ($http,$scope){
	  $http({
		    method: 'GET', 
		    url: 'pruebaGet'
		  }).success(function(data, status, headers, config) {
			  $scope.trabajador = data;
		  }).error(function(data, status, headers, config) {
		      alert("Ha fallado la petición. Estado HTTP:"+status);
		  });	
}

var pruebaModulos = function($scope) {
	$scope.cambioEnModulos =function () {
			$scope.mensaje = "cambio en modulos ";
	}
};
var trabajador = {
		age : 1,
		name : ""
}; 

var pruebaController = function($scope,$log,$http,$timeout,miServicioConstante,matematicas_simples,rectangulo){
	$scope.mensaje = "ddsadsadsadsa"; 
	$scope.trabajador = trabajador; 
	$scope.cambiarMensaje = function () {
		$scope.mensaje = "12332113211321321";
		$log.debug("cambiando cosas");
    }
	
	$scope.llamada = function () {
		llamadahttps($http,$scope); 
    }

	$scope.seguro  = seguro; 
	$timeout(function() {
		$scope.producidoEvento="2";
	},2);
	$log.debug(miServicioConstante);
	$log.debug(matematicas_simples.sumar(4,5)); 
	$log.debug(rectangulo.getArea());
	
}


app.controller("PruebaController", pruebaController);
moduloT.controller("PruebaModulos",pruebaModulos); 