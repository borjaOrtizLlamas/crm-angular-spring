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

app.factory("idioma",function() {
	  return "es-es";
});


app.factory("matematicasSimplesFactory",function() { 
	  return {
	    sumar:function(a,b) {
	      return a+b;
	    },
	    restar:function(a,b) {
	      return a-b;
	    }
	  }
	});

app.factory("radio",function() {
	  return 10;
	});
	  



app.factory("area",function() {
  return function(radio) {
    return 3.1416*radio*radio;
  }
});

app.constant("algoritmo","MD5");


function HashProvider () {
	  var _algoritmo="";
	   
	  this.setAlgoritmo=function(algoritmo) {
	    _algoritmo=algoritmo;
	  };
	  
	  this.metodo= function (hash){
			return  hash + "haseando mi string"; 
		}

	  this.$get=function() {
		    var funQueDevolveraMiProvider;
		   
		    if (_algoritmo==="MD5") {
		    	hashFunction=this.metodo;
		    } else {//aqui podriamos meter mas tipos de funciones
		      throw Error("El tipo de algoritmo no es válido:"+_algoritmo);
		    }
		    
		    var funQueDevolveraMiProvider=function(message) {
		    	return hashFunction(message);
		    }
		     
		    return funQueDevolveraMiProvider;
	  }
}

app.provider("hash",HashProvider);

app.config(["hashProvider","algoritmo",function(hashProvider,algoritmo) {
	hashProvider.setAlgoritmo(algoritmo);
}]);

var provincias=[
    {
      idProvincia:2,
      nombre:"Castellón"
    },
    {
      idProvincia:3,
      nombre:"Alicante"
    },
    {
      idProvincia:1,
      nombre:"Valencia"
    },
    {
      idProvincia:7,
      nombre:"Teruel"
    },  
    {
      idProvincia:5,
      nombre:"Tarragona"
    }
];

var pruebaController = function($scope,$log,$http,$timeout,miServicioConstante,matematicas_simples,rectangulo,matematicasSimplesFactory,area,radio,hash,provedorHttp){
	$scope.mensaje = "ddsadsadsadsa"; 
	$scope.trabajador = trabajador; 
	
	$scope.aIncluir="/crm/resources/aIncluir.html"; 
	
	$scope.provincias =provincias; 
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
	$log.debug("-------------------------------------------------------------");
	matematicasSimplesFactoryAUsar = matematicasSimplesFactory.sumar(3,2); 
	$log.debug(matematicasSimplesFactoryAUsar);
	matematicasSimplesFactoryComplicado = area(radio); 
	$log.debug(matematicasSimplesFactoryComplicado);
	$log.debug("-------------------------------------------------------------");
	$log.debug("provider: "+ hash("metodoParaHash-")); 
	
	var datos = provedorHttp(
		{method: "GET",
			url: "usuario/array"},
			function(data, status, headers, config) {
				alert("entro"); 
				return "HOLA";  //{error: false , data};
			},function(data, status, headers, config) {
				alert("entro2"); 
				return "HOLA1";  //{error: true ,data,status};
			}); 

	$log.debug("http "+ datos); 
}


/*
 * 
 * Servicio de get con provider configurado con un config 
 * 
 * */

app.constant("urlbase","/crm/");

function HttpProvider () {
	  
	  var _baseURL;

	  this.setBaseURL =  function(baseURL) {  
		  _baseURL=baseURL;
	  };


	  this.$get=['$http',function ($http){
		  return function(datos, dataOK,dataError) {
			return $http({
				    method: datos.method, 
				    url: _baseURL + datos.url})
				  .success(function (data, status, headers, config){
					  return dataOK(data, status, headers, config); 
				  })
				  .error(function (data, status, headers, config){
					  return dataError(data, status, headers, config); 
				}) ;	
			  
		  }
	  }]; 
};

moduloT.provider("provedorHttp",HttpProvider);

app.config(["provedorHttpProvider","urlbase",function(provedorHttpProvider,urlbase) { 
	provedorHttpProvider.setBaseURL(urlbase); 
}]);


app.controller("PruebaController", pruebaController);
moduloT.controller("PruebaModulos",pruebaModulos); 