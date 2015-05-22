(function(angular){
	angular.module("nwu-backbone")
	
	/**
	 * Rest Services for leave application
	 */
	.factory("TaskListRestServices", 
	["BackboneRestServiceBase",
	function(BackboneRestServiceBase){
		return angular.extend({
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
		},BackboneRestServiceBase);
		
	}]);
})(angular)