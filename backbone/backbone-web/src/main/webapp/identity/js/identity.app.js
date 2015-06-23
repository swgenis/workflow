(function(angular){
	
	// Define the backbone module
	angular.module("identity", ['backbone'])
	
	/**
	 * Rest service client for the PersonRestService
	 */
	.factory("PersonRestService", 
	["BackboneRestServiceBase",
	 function(BackboneRestServiceBase){
		return angular.extend({
			/**
			 * Function to find a person
			 */
			'search' : function(name, surname){
				return this._callService('GET', 'person/search', null, {'name': name, 'surname': surname});
			},
			'lookup' : function(personLookupId){
				return this._callService('GET', 'person/lookup', null, {'personLookupId': personLookupId});
			}
		},BackboneRestServiceBase);
		
	}])
	/**
	 * Controller for the task list
	 */
	.controller("IdentityCtrl", 
	["$scope", "PersonRestService", 
	function($scope, PersonRestService){
		$scope.persons = null;
		
		/**
		 * Get tasks for the entered username
		 */
		$scope.searchPersons = function(){
			PersonRestService.searchLeaveTasks($scope.username).then(function(persons){
				$scope.persons = persons;
			});
		};
		
	}]);
	
})(angular);