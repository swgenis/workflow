(function(angular){
	angular.module("nwu-backbone")
	
	/**
	 * Rest Services for leave application
	 */
	.factory("TaskListRestServices", 
	["$q","$http",
	function($q, $http){
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
			},
			/**
			 * Get the tasks for a user
			 */
			'getTasks' : function(username){
				return this._callService('GET', 'task/list',null, {'user' : username});
			},
			/**
			 * Get the tasks for a user
			 */
			'approveTask' : function(username, taskId){
				return this._callService('GET', 'task/approve',null, {'user' : username, 'taskId' : taskId});
			},
			/**
			 * Get the tasks for a user
			 */
			'denyTask' : function(username, taskId){
				return this._callService('GET', 'task/approve',null, {'user' : username, 'taskId' : taskId});
			}
		}
		
	}]);
	
	
	
})(angular)