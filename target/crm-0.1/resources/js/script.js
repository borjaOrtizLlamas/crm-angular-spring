var app = angular.module("app", []);
var validaciones = angular.module("valid", []);

function RemoteResource($q, $http, baseUrl) {
	this.get = function(action, dataE) {
		var defered = $q.defer();
		var promise = defered.promise;

		$http({
			method : 'POST',
			url : baseUrl + action + '?' + $("#token").val(),
			data : dataE
		}).success(function(data, status, headers, config) {
			defered.resolve(data);
		}).error(
				function(data, status, headers, config) {
					if (status === 400) {
						defered.reject(data);
					} else {
						throw new Error("Fallo obtener los datos:" + status
								+ "\n" + data);
					}
				});
		return promise;
	},	this.getValidatePromise = function(action, dataE) {
		var defered = $q.defer();
		var promise = defered.promise;
		$http({
			method : 'POST',
			url : "/crm/valid/" + action + '?' + $("#token").val(),
			data : dataE
		}).success(function(data, status, headers, config) {
			defered.resolve(data);
		}).error(
				function(data, status, headers, config) {
					if (status === 400) {
						defered.reject(data);
					} else {
						throw new Error("Fallo obtener los datos:" + status
								+ "\n" + data);
					}
				});
		return promise;
	}
}

function RemoteResourceProvider() {
	var _baseUrl;
	this.setBaseUrl = function(baseUrl) {
		_baseUrl = baseUrl;
	}
	this.$get = [ '$q', '$http', function($q, $http) {
		return new RemoteResource($q, $http, _baseUrl);
	} ];
}

app.provider("remoteResource", RemoteResourceProvider);

function ValidacionObject($q, $http) {
	this.validateDNI = function(dni) {
		var numero;
		var letr;
		var letra;
		var expresion_regular_dni;

		expresion_regular_dni = /^\d{8}[a-zA-Z]$/;

		if (expresion_regular_dni.test(dni) == true) {
			numero = dni.substr(0, dni.length - 1);
			letr = dni.substr(dni.length - 1, 1);
			numero = numero % 23;
			letra = 'TRWAGMYFPDXBNJZSQVHLCKET';
			letra = letra.substring(numero, numero + 1);
			if (letra != letr.toUpperCase()) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}
}

function ValidacionesProvider() {
	this.$get = [ '$q', '$http', function($q, $http) {
		return new ValidacionObject($q, $http);
	} ];
}

validaciones.provider("validaciones", ValidacionesProvider);
