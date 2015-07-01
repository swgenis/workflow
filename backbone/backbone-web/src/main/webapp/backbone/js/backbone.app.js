(function(angular){
	
	// Define the backbone module
	angular.module("backbone", [])
	
	/**
	 * Base for all rest services
	 */
	.factory("BackboneRestServiceBase", 
	["$http", "$q",
	 function($http, $q){
		return {
			'_callService' : function(method, url, sendingData, params){
				var restPath;
				if(contextPath === "/" || contextPath === ""){
					restPath = "/rest/";
				}
				else{
					restPath = contextPath + "/rest/";
				}
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
					'url': restPath + url,
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
				if(username == null){
					return this._callService('GET', 'task/list');
				}
				else{
					return this._callService('GET', 'task/list',null, {'user':username});
				}
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
			},
			/**
			 * Get the task summary of a task
			 */
			'getSummary' : function(taskId){
				return this._callService('GET', 'task/taskSummary/' + taskId);
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
			'getType' : function(key){
				return this._callService('GET', 'type/' + key);
			}
		},BackboneRestServiceBase);
		
	}])
	/**
	 * Rest service client for the ConfigRestService
	 */
	.factory("ConfigRestService", 
	["BackboneRestServiceBase",
	function(BackboneRestServiceBase){
		return angular.extend({
			'getApplications' : function(){
				return this._callService('GET', 'config/applications/');
				
			},
			'getPrincipal' : function(){
				return this._callService('GET', 'config/principal/');
				
			},
			'getProperties' : function(){
				return this._callService('GET', 'config/properties/');
				
			}
		},BackboneRestServiceBase);
		
	}])
	/**
	 * Controller for the task list
	 */
	.controller("ConfigCtrl", 
	["$scope", "ConfigRestService", 
	function($scope, ConfigRestService){

		$scope.properties = null;
		
		// Get the leave types
		ConfigRestService.getProperties().then(function(properties){
			$scope.properties = properties;
			
			// Reset page title.
			document.title = properties.title;
		});
		
	}])
	/**
	 * Filter to show the number of days between 2 dates
	 */
	.filter('days', function() {
		return function(start, end) {
			var startMoment = moment(start);
			var endMoment = moment(end);
			return moment.duration(endMoment.diff(startMoment)).asDays();
		};
	})
	/**
	 * Filter to lookup a type.
	 * Optionaly a list can be specified to get the type out of, instead of doing
	 * a rest call to retrive the type
	 */
	.filter('typeLabel', 
		["TypeRestService","$q", "$timeout",
		 function(TypeRestService,$q, $timeout) {
		
		var DEFAULT = "..."; // Loading text
		
		/**
		 * Function to lookup a type from a list
		 * @param key Key of the item to lookup
		 * @param list List to search in
		 * @returns The label of the item
		 */
		function lookupInList(key, list){
			var defer = $q.defer();
			
			$timeout(function(){
				var text =  null;
				for(var idx in list){
					var item = list[idx];
					if(item.key == key){
						text = item.description;
						break;
					}
				}
				defer.resolve(text);
			},0); // Start this out of current thread
			
			return defer.promise;
		}
		
		
		return function(typeKey, typeList) {
			
			var typeLabel = DEFAULT;
			// If there is a type list, we will attempt to use it
			if(!!typeList){
				lookupInList(typeKey, typeList).then(function(text){
					typeLabel = text;
				});
			}
			// If there is no list, we will use the rest service
			else{
				TypeRestService.getType(typeKey).then(function(type){
					typeLabel = type.description;
				});
			}
			
			return typeLabel;
		};
	}]);
	
})(angular);