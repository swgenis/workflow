(function(angular){
	angular.module("backbone")
	
	/**
	 * Rest Services for leave application
	 */
	.factory("OrganizationRestServices", 
	["BackboneRestServiceBase",
	function(BackboneRestServiceBase){
		return angular.extend({
			
			},BackboneRestServiceBase);
		
		
	}]);
	
	
	
})(angular)