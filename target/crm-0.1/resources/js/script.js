var app = angular.module("app", []);

function RemoteResource($q,$http,baseUrl) {
	this.get=function(action,dataE) {
		var defered = $q.defer();
		var promise = defered.promise;
		 
		$http({
			method: 'POST', 
			url: baseUrl+action+'?'+$("#token").val(),
			data: dataE 
		}).success(function(data, status, headers, config) {
			defered.resolve(data);
		}).error(function(data, status, headers, config) {
			if (status === 400) {
				defered.reject(data);
			} else {
				throw new Error("Fallo obtener los datos:" + status + "\n" + data);
			}
		});
		return promise;
  	}
}

function RemoteResourceProvider() {
  var _baseUrl;
  this.setBaseUrl=function(baseUrl) {
    _baseUrl=baseUrl;
  }
  this.$get=['$q','$http',function($q,$http) {
	  	return new RemoteResource($q,$http,_baseUrl);
  }];
}

app.provider("remoteResource",RemoteResourceProvider);

var valid = angular.module("valid", []);

function ValidacionObject($q,$http,baseUrl) {
	this.validateDNI=function(action,dataE) {
		var defered = $q.defer();
		var promise = defered.promise;

		$http({
			method: 'POST', 
			url: baseUrl+action+'?'+$("#token").val(),
			data: dataE 
		}).success(function(data, status, headers, config) {
			defered.resolve(data);
		}).error(function(data, status, headers, config) {
			if (status === 400) {
				defered.reject(data);
			} else {
				throw new Error("Fallo obtener los datos:" + status + "\n" + data);
			}
		});
		return promise;
  	}
}

function ValidacionesProvider() {
  var _baseUrl;
  this.setBaseUrl=function(baseUrl) {
    _baseUrl=baseUrl;
  }
  this.$get=['$q','$http',function($q,$http) {
	  	return new ValidacionObject($q,$http,_baseUrl);
  }];
}

valid.provider("validaciones",RemoteResourceProvider);


