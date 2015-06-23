(function(angular){
	
	angular.module("intelitravel")
	
	/**
	 * Rest Services for leave application
	 */
	.factory("PayRestServices", 
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
