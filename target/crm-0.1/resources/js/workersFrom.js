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
					remoteResource.getValidatePromise("isDniInBBDD", "{nif:"+ $scope.worker.nif + "}").then(
						function(data) {
							alert(data.objet.ok); 
							if(data.objet.ok){
								$scope.validaciones.falloDni =true;
								$scope.validaciones.falloDniValue = 0;
								//styles
								$scope.validateCSS.hasError=false;
								$scope.validateCSS.hasSuccess=true;
							}else{
								badDni($scope,2); 
							};
						},
						function(status) {
							alert("Ha fallado la petición. Estado HTTP:" + status);
						});
				} else {
					badDni($scope,1); 				
				}
			}

			$scope.validaciones = {
				falloDniValue: null,				
				falloDni: false
				
			};
			
			$scope.validateCSS = {
				hasError:true,
				hasSuccess:false
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
				if($scope.validaciones.falloDni){
					remoteResource.get("addWorker", $scope.worker).then(
						function(data) {
							if(data.error == true){
								alert("error:" + data.nameError); 
							}
						},
						function(status) {
							alert("Ha fallado la petición. Estado HTTP:" + status);
						});
				}else{
					alert("no validamos"); 
				}
			}
		}
]);


function badDni($scope,number) {
	$scope.validaciones.falloDniValue = number;
	$scope.validaciones.falloDni = false; 
	//stlyes
	$scope.validateCSS.hasError=true;
	$scope.validateCSS.hasSuccess=false;
}