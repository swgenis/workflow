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
				 * Callback function to lookup a user
				 */
				scope.findPerson = function(){
					scope.userdetails = null;
					scope.error = null;
					
					BackboneServices.findPerson(scope.nwuuid)
					.then(
					// Success handler
					function(userdetails){
						// If we didn't find the user
						if(userdetails == null){
							scope.error = "Could not find user for ID \"" + scope.nwuuid + "\"";
						}
						// We found the user
						else{
							scope.userdetails = userdetails;
						}
					}, 
					// Error handler
					function(reason){
						scope.error = "An error ocurred while trying to find the user";
					})
				}
			}
		}
	}]);
	
})(angular);