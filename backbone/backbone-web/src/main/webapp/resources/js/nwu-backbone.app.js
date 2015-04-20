(function(angular){
	
	// Define the nwu-backbone module
	angular.module("nwu-backbone", [])
	
	/**
	 * Factory for the Common Backbone Services
	 */
	.factory("BackboneServices", 
	["$http", 
	 function($http){
		return {
			/**
			 * Function to find a person
			 */
			'findPerson' : function(username){
				
			}
		}
		
	}]);
	
})(angular);