var app = angular.module('app', []);

// se ejecutan antes de todos los demas
app.constant("calculosConstantes", {
	sumar : function(a, b) {
		return a + b;
	},
	restar : function(a, b) {
		return a - b;
	},
	calculoIRPF : function(a) {
		return a * 0.8;
	},
	baseUrl : "./usuario"
});

function RemoteResource($http, baseUrl) {
	this.get = function(fnOK, fnError,url) {
		$http({
			method : 'GET',
			url : baseUrl+"/"+url
		}).success(function(data, status, headers, config) {
			fnOK(data);
		}).error(function(data, status, headers, config) {
			fnError(data, status);
		});
	}
}

function RemoteResourceProvider() {
	var _baseUrl;
	this.setBaseUrl = function(baseUrl) {
		_baseUrl = baseUrl;
	}
	this.$get = [ '$http', function($http) {
		return new RemoteResource($http, _baseUrl);
	} ];
}

app.provider("remoteResource", RemoteResourceProvider);

app.config([ 'calculosConstantes', 'remoteResourceProvider',
		function(baseUrl, remoteResourceProvider) {
			remoteResourceProvider.setBaseUrl(baseUrl.baseUrl);
		} ]);

app.controller("PruebaController", [
		'calculosConstantes',
		'$scope',
		'$log',
		'$http',
		'$timeout',
		'remoteResource',
		function(calculosConstantes, $scope, $log, $http, $timeout,remoteResource) {
			
			$scope.calculoIRF = function() {
				$scope.usuario.valorIRPF = calculosConstantes
						.calculoIRPF($scope.usuario.salario);
			}; 
			
			$scope.fecha=new Date();
			
			$scope.numeroDecimal= 146; 
			
			$scope.mensaje = "Hola Msundo";

			$scope.contrasena = "cambiame guapo";

			$scope.cambiarMensaje = function() {
				$scope.mensaje = "hola mundito";
			};

			$timeout(function() {
				$scope.mensaje = "MALDITO LISADO";
			}, 10000);

			$scope.usuarioSesion = {
				hashcontrasena : "dsadsa",
				contrasena : undefined
			};

			$scope.contrasenaCifrada = function(event) {
				if (event != null) {
					alert("FUNCIONA");
				}
			};

			$scope.usuario = {
				nif : "",
				nombre : "",
				ape1 : "",
				edad : undefined,
				sexo : "",
				casado : false,
				numHijos : "0",
				ayudaPorHijos : false,
				salario : 321,
				rango : "",
				valorIRPF : undefined,
				fechaDeIncorporacion : new Date(),
				fechaDeBaja : new Date(),
				numeroTrabajadoresBajoServicio : undefined
			};

			$scope.ayudaPosHijosDesavilitado = function() {
				return ($scope.usuario.numHijos === "0");
			};

			$scope.mostrarJefe = function() {
				return ($scope.usuario.rango === "jefe");
			};
			$scope.x = null;
			$scope.y = null;

			$scope.myFunc = function(myE) {
				$scope.x = myE.clientX;
				$scope.y = myE.clientY;
			}

			remoteResource.get(function(usuario) {
				$scope.usuario = usuario;
			}, function(data, status) {
				alert("Ha fallado la petición. Estado HTTP:" + status);
			},"solo");

			
			remoteResource.get(function(usuarios) {
				$scope.usuarios = usuarios;
			}, function(data, status) {
				alert("Ha fallado la petición. Estado HTTP:" + status);
			},"array");

			
			
			
			
			$log.debug("controlador creado");
		
		
		
		
		
		} ]);
