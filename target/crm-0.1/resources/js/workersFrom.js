var workersFrom = angular.module("workersFrom", [ 'app', 'valid',
		'uiGmapgoogle-maps' ]);

workersFrom.constant("baseUrl", "/crm/worker/");

workersFrom.config([
		'baseUrl',
		'remoteResourceProvider',
		'validacionesProvider',
		'uiGmapGoogleMapApiProvider',
		function(baseUrl, remoteResourceProvider, validacionesProvider,
				GoogleMapApi) {
			GoogleMapApi.configure({
				key : 'AIzaSyAZyUOqhGb2m70X8A7BAv5TLUzn-rBIN5g',
				// v: '3.20',
				libraries : 'weather,geometry,visualization'
			});

			remoteResourceProvider.setBaseUrl(baseUrl);
		} ]);

workersFrom.controller("workAddController", [
		'$scope',
		'$q',
		'remoteResource',
		'validaciones',
		'uiGmapLogger',
		'uiGmapGoogleMapApi',
		function($scope, $q, remoteResource, validaciones, $log, GoogleMapApi) {

			$scope.mapCheck = false;

			$scope.map = {
				'center' : {
					'latitude' : 40.4165000,
					'longitude' : -3.7025600
				},
				zoom : 10,
				'events' : {
					'tilesloaded' : function(map, eventName, originalEventArgs) {
					},
					'click' : function(mapModel, eventName, originalEventArgs) {
						alert("hola");
					}
				}
			};

			$scope.nifValidate = function() {
				if (validaciones.validateDNI($scope.worker.nif)) {
					remoteResource.getValidatePromise(
							"isDniInBBDD/" + $scope.worker.nif, null).then(
							function(data) {
								alert(data.objet.ok);
								if (data.objet.ok) {
									$scope.validaciones.falloDni = true;
									$scope.validaciones.falloDniValue = 0;
									// styles
									$scope.validateCSS.hasError = false;
									$scope.validateCSS.hasSuccess = true;
								} else {
									badDni($scope, 2);
								}
								;
							},
							function(status) {
								alert("Ha fallado la petición. Estado HTTP:"
										+ status);
							});
				} else {
					badDni($scope, 1);
				}
			}

			$scope.validaciones = {
				falloDniValue : null,
				falloDni : false

			};

			$scope.validateCSS = {
				hasError : true,
				hasSuccess : false
			};

			$scope.worker = {
				nif : "",
				name : "",
				surname : "",
				age : "",
				sex : "",
				married : false,
				married1 : undefined,
				numberSon : undefined,
				salary : undefined,
				fristDay : new Date,
				lastDay : new Date
			};

			$scope.newWorker = function() {
				if ($scope.validaciones.falloDni) {
					remoteResource.get("addWorker", $scope.worker).then(
							function(data) {
								if (data.error == true) {
									alert("error:" + data.nameError);
								}
							},
							function(status) {
								alert("Ha fallado la petición. Estado HTTP:"
										+ status);
							});
				} else {
					alert("no validamos");
				}
			}
		} ]);

function badDni($scope, number) {
	$scope.validaciones.falloDniValue = number;
	$scope.validaciones.falloDni = false;
	// stlyes
	$scope.validateCSS.hasError = true;
	$scope.validateCSS.hasSuccess = false;
}


















