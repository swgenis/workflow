(function(angular){
	angular.module("nwu-backbone")
	
	/**
	 * Rest Services for leave application
	 */
	.factory("LeaveRestServices", 
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
			 * Submit leave for approval
			 */
			'submitLeave' : function(data){
				return this._callService('POST', 'leave/apply', data);
			},
			/**
			 * Get the tasks for a user
			 */
			'approveLeave' : function(username, taskId){
				return this._callService('GET', 'leave/approve',null, {'user' : username, 'taskId' : taskId});
			},
			/**
			 * Get the tasks for a user
			 */
			'denyLeave' : function(username, taskId){
				return this._callService('GET', 'leave/deny',null, {'user' : username, 'taskId' : taskId});
			},
			/**
			 * Search for leave applications for a user
			 */
			'searchLeave' : function(username){
				return this._callService('GET', 'leave/search/records', null, {'applicantId': username});
			},
			/**
			 * Search for leave applications for a user
			 */
			'searchLeaveTasks' : function(username){
				return this._callService('GET', 'leave/search/applications', null, {'user': username});
			},
			/**
			 * Get the types of leave a person can take
			 */
			'getLeaveTypes' : function(personLookupId){
				return this._callService('GET', 'leave/types.json');
			}
		}
		
	}]);
	
	
	
})(angular)