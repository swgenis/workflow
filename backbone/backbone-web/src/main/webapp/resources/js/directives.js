(function(angular){
	angular.module("nwu-backbone")
	/**
	 * Directive to lookup a person
	 */
	.directive("personLookup", 
	["BackboneServices",
	 function(BackboneServices){
		return {
			'restrict': 'E',
			'scope': false,
			'templateUrl': '/backbone/html/directives/personLookup.html',
			'link' : function(scope, element, attr){
				scope.data = null;
				scope.error = null;
				
				/**
				 * Callback funtion to lookup a user
				 */
				scope.lookup = function(username){
					BackboneServices.findPerson(username)
					.then(
					// Success handler
					function(userdetails){
						scope.userdetails = userdetails;
					}, 
					// Error handler
					function(reason){
						
					})
				}
			}
		}
	}]);
	
})(angular);