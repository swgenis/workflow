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
			TaskListRestServices.approveTask($scope.username, task.id).then(function(){
				// Once done, refresh the task list
				$scope.searchTasks();
			});
		};
		
		/**
		 * Function to deny a task
		 */
		$scope.denyTask = function(task){
			TaskListRestServices.denyTask($scope.username, task.id).then(function(){
				// Once done, refresh the task list
				$scope.searchTasks();
			});
		};
		
	}]);
	
	
	
})(angular)