(function(angular){
	angular.module("nwu-backbone")
	/**
	 * Directive to lookup a person
	 */
	.directive("personLookup", 
	["PersonRestService",
	 function(PersonRestService){
		return {
			'restrict': 'E',
			'scope': {
				'person': "=person"
			},
			'templateUrl': '/backbone/html/directives/personLookup.html',
			'link' : function(scope, element, attr){
				scope.data = null;
				scope.error = null;
				scope.canUse = false;
				
				/**
				 * Callback function to lookup a user
				 */
				scope.findPerson = function(){
					
					scope.userdetails = null;
					scope.error = null;
					
					PersonRestService.search(scope.nwuuid)
					.then(
					// Success handler
					function(userdetails){
						// If we didn't find the user
						if(userdetails == null){
							scope.canUse = false;
							scope.error = "Could not find user for ID \"" + scope.nwuuid + "\"";
						}
						// We found the user
						else{
							scope.canUse = true;
							scope.userdetails = userdetails;
						}
					}, 
					// Error handler
					function(reason){
						scope.canUse = false;
						scope.error = "An error ocurred while trying to find the user";
					})
				};
				
				/**
				 * Callback function if the user decides to use the user that was looked up
				 */
				scope.usePerson = function(){
					scope.person = scope.userdetails;
				};
			}
		}
	}])
	/**
	 * Directive to show an action list
	 */
	.directive("actionList", 
	["TaskRestService",
	 function(TaskRestService){
		return {
			'restrict': 'E',
			'scope': { },
			'templateUrl': '/backbone/html/directives/actionList.html',
			'link' : function(scope, element, attr){
				
				TaskRestService.list().then(function(tasks){
					scope.tasks = tasks;
				});
			}
		}
	}]);
	
})(angular);