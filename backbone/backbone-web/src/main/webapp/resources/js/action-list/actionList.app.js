(function(angular){
	angular.module("nwu-backbone")
	
	/**
	 * Controller for the task list
	 */
	.controller("ActionListCtrl", 
	["$scope", "TaskListRestServices", 
	function($scope, ActionistRestServices){
		$scope.tasks = null;
		
		ActionistRestServices.getTasks()
		
	}]);
	
	
	
})(angular)