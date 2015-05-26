(function(angular){
	angular.module("nwu-backbone")
	
	/**
	 * Controller for the task list
	 */
	.controller("ActionListCtrl", 
	["$scope", "TaskRestService", 
	function($scope, TaskRestService){
		$scope.tasks = null;
		
		TaskRestService.getTasks().then(function(tasks){
			$scope.tasks = tasks;
		})
		
	}]);
	
	
	
})(angular)