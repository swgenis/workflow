(function(angular){
	angular.module("backbone")
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
			'templateUrl': contextPath + '/html/directives/personLookup.html',
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
					
					PersonRestService.lookup(scope.uid)
					.then(
					// Success handler
					function(userdetails){
						// If we didn't find the user
						if(userdetails == null){
							scope.canUse = false;
							scope.error = "Could not find user for ID \"" + scope.uid + "\"";
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
	["TaskRestService","$location",
	 function(TaskRestService, $location){
		return {
			'restrict': 'E',
			'scope': { },
			'templateUrl': contextPath + '/html/directives/actionList.html',
			'link' : function(scope, element, attr){
				
				TaskRestService.list().then(function(tasks){
					scope.tasks = tasks;
				});
				
				/**
				 * Change the window location to view the selected task.
				 */
				scope.viewTask = function(task){
					window.location = contextPath + task.viewUrl;
				};
			}
		}
	}])
	/**
	 * Directive to show an action list
	 */
	.directive("userInfo", 
	["ConfigRestService","$location",
	 function(ConfigRestService, $location){
		return {
			'restrict': 'E',
			'scope': { },
			'templateUrl': contextPath + '/html/directives/personInfo.html',
			'link' : function(scope, element, attr){
				
				ConfigRestService.getPrincipal().then(function(principal){
					scope.principal = principal;
				});

			}
		}
	}]);
	
})(angular);