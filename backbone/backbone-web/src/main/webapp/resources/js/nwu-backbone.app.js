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
	 * Rest service client for the PersonRestService
	 */
	.factory("PersonRestService", 
	["BackboneRestServiceBase",
	 function(BackboneRestServiceBase){
		return angular.extend({
			/**
			 * Function to find a person
			 */
			'lookup' : function(name, surname){
				return this._callService('GET', 'person/search', null, {'name': name, 'surname': surname});
			},
			'search' : function(personLookupId){
				return this._callService('GET', 'person/lookup', null, {'personLookupId': personLookupId});
			}
		},BackboneRestServiceBase);
		
	}])
	/**
	 * Rest service client for the TaskRestService
	 */
	.factory("TaskRestService", 
	["BackboneRestServiceBase",
	function(BackboneRestServiceBase){
		return angular.extend({
			/**
			 * Lists tasks for a user
			 */
			'list' : function(username){
				return this._callService('GET', 'task/list');
				
			},
			/**
			 * Get the tasks for a user
			 */
			'approve' : function(username, taskId){
				return this._callService('GET', 'task/approve',null, {'user' : username, 'taskId' : taskId});
			},
			/**
			 * Get the tasks for a user
			 */
			'deny' : function(username, taskId){
				return this._callService('GET', 'task/approve',null, {'user' : username, 'taskId' : taskId});
			},
			/**
			 * Get a task with the specified id
			 */
			'get' : function(taskId){
				return this._callService('GET', 'task/' + taskId);
			}
		},BackboneRestServiceBase);
		
	}])
	/**
	 * Rest service client for the TypeRestService
	 */
	.factory("TypeRestService", 
	["BackboneRestServiceBase",
	function(BackboneRestServiceBase){
		return angular.extend({
			'search' : function(category){
				return this._callService('GET', 'type/category/' + category);
				
			},
			'approve' : function(key){
				return this._callService('GET', 'type/' + key);
			}
		},BackboneRestServiceBase);
		
	}]);
	
})(angular);