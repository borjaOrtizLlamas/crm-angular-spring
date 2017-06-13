var workersFrom = angular.module("workersFrom", ['app','valid']);

workersFrom.constant("baseUrl", "/crm/worker/");

workersFrom.config([ 'baseUrl', 'remoteResourceProvider','validacionesProvider',function(baseUrl, remoteResourceProvider,validacionesProvider) {
		remoteResourceProvider.setBaseUrl(baseUrl);
		
} ]);

workersFrom.controller("workAddController", [
		'$scope',
		'$q',
		'remoteResource',
		'validate',
		function($scope, $q, remoteResource,validate) {

			$scope.nifValidate = function() {
				if (validateForm.dni($scope.worker.nif)) {
					remoteResource.get("isDniInBBDD", $scope.worker.nif).then(
							function(data) {
								$scope.validaciones.falloDni = data.objet.isOK;
								alert($scope.validaciones.falloDni);
							},
							function(status) {
								alert("Ha fallado la petición. Estado HTTP:"
										+ status);
							});
				} else {
					$scope.validaciones.falloDni = "DNI Incorrecto1";
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

						},
						function(status) {
							alert("Ha fallado la petición. Estado HTTP:"
									+ status);
						});
			}

		}

]);