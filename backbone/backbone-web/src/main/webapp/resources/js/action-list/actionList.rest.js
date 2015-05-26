(function(angular){
	angular.module("nwu-backbone")
	
	/**
	 * Action list rest services
	 */
	.factory("ActionistRestServices", 
	["BackboneRestServiceBase",
	function(BackboneRestServiceBase){
		return angular.extend({
			/**
			 * Get the tasks for a user that requires action
			 */
			'getTasks' : function(username){
				return this._callService('GET', 'task/list',null, {'user' : username});
			}
		},BackboneRestServiceBase);
		
	}]);
})(angular)