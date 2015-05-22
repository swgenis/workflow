(function(angular){
	
	// Define the nwu-backbone module
	angular.module("nwu-backbone", [])
	
	/**
	 * Base for all rest services
	 */
	.factory("BackboneRestServiceBase", 
	["$http", "$q",
	 function($http, $q){
		return {
			'_callService' : function(method, url, sendingData, params){
				var contextPath = "/backbone/rest/"; // TODO get this from application
				
				var deferred = $q.defer();

				// TODO implement CSRF
				var token = null;  //$("meta[name='_csrf']").attr("content");
				var header = null; // $("meta[name='_csrf_header']").attr("content");
				var headers = {};

				if(header != null && header != ""){
					headers[header] = token;
				}
				
				$http({
					'method': method,
					'url': contextPath + url,
					'data' : sendingData,
					'params': params,
					'headers' : headers
				}).success(function(data, status, headers, config) {
					deferred.resolve(data == "" ? null : data);
				}).error(function(data, status, headers, config) {
					deferred.reject(data);
				});
				return deferred.promise;
			}
		}
		
	}])
	
	/**
	 * Factory for the Common Backbone Services
	 */
	.factory("BackboneServices", 
	["BackboneRestServiceBase",
	 function(BackboneRestServiceBase){
		return angular.extend({
			/**
			 * Function to find a person
			 */
			'findPerson' : function(personLookupId){
				return this._callService('GET', 'person/lookup', null, {'personLookupId': personLookupId});
			}
		},BackboneRestServiceBase);
		
	}]);
	
})(angular);