(function(angular){
	angular.module("nwu-backbone")
	
	/**
	 * Controller for the task list
	 */
	.controller("TaskListCtrl", 
	["$scope", "TaskListRestServices", 
	function($scope, TaskListRestServices){
		$scope.tasks = null;
		
		/**
		 * Get tasks for the entered username
		 */
		$scope.searchTasks = function(){
			TaskListRestServices.getTasks($scope.username).then(function(tasks){
				$scope.tasks = tasks;
			});
		};
		
		
		/**
		 * Function to approve a task
		 */
		$scope.approveTask = function(task){
			
		};
		
	}]);
	
	
	
})(angular)