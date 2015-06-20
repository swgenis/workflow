(function(angular){
	
	angular.module("backbone")
	
	/**
	 * Rest Services for leave application
	 */
	.factory("LeaveRestServices", 
	["BackboneRestServiceBase",
	function(BackboneRestServiceBase){
		return angular.extend({
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
			'getLeaveTypes' : function(){
				return this._callService('GET', 'leave/types.json');
			}
			
		},BackboneRestServiceBase);
		
	}]);
	
	
	
})(angular)
