var workersFrom = angular.module("workersFrom", [ 'app', 'valid' ]);

workersFrom.constant("baseUrl", "/crm/worker/");

workersFrom.config([ 'baseUrl', 'remoteResourceProvider',
		'validacionesProvider',
		function(baseUrl, remoteResourceProvider, validacionesProvider) {
			remoteResourceProvider.setBaseUrl(baseUrl);

		} ]);

workersFrom.controller("workAddController", [
		'$scope',
		'$q',
		'remoteResource',
		'validaciones',
		function($scope, $q, remoteResource, validaciones) {

			$scope.nifValidate = function() {
				if (validaciones.validateDNI($scope.worker.nif)) {
					$scope.validaciones.falloDni = "DNI";
					remoteResource.getValidatePromise("isDniInBBDD", $scope.worker.nif).then(
						function(data) {
							$scope.validaciones.falloDni = data.objet.isOK;
							alert($scope.validaciones.falloDni);
						},
						function(status) {
							alert("Ha fallado la petición. Estado HTTP:"
									+ status);
						});
				} else {
					$scope.validaciones.falloDni = "DNI MAL ESCRITO";
				}
			}

			$scope.validaciones = {
				falloDni : "¿cambia?"
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
				remoteResource.get("addWorker", $scope.worker).then(
					function(data) {
						if(data.error == true){
							alert("error:" + data.nameError); 
						}
					},
					function(status) {
						alert("Ha fallado la petición. Estado HTTP:"
								+ status);
					});
			}

		}

]);