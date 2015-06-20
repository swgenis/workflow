(function(angular){
	angular.module("backbone")
	
	/**
	 * Controller for leave application
	 */
	.controller("LeaveApplicationCtrl", 
	["$scope","$location", "LeaveRestServices", 
	function($scope, $location, LeaveRestServices){
		
		$scope.leaveEntries = [];
		$scope.submitFail = false;
		$scope.submitSuccess = false;
		
		var appLid = $location.search().aid;
		var aaction = $location.search().a;
		
		// Get the leave types
		LeaveRestServices.getLeaveTypes().then(function(leaveTypes){
			$scope.leaveTypes = leaveTypes;
		});
		
		/**
		 * Get tasks for the entered username
		 */
		$scope.searchLeaveTasks = function(){
			LeaveRestServices.searchLeaveTasks($scope.username).then(function(tasks){
				$scope.tasks = tasks;
			});
		};
		
		/**
		 * Function to add a leave record
		 */
		$scope.addLeaveRecord = function(){
			$scope.leaveEntries.push({
				typeKey : $scope.newEntry.typeKey,
				startDate: $scope.newEntry.startDate,
				endDate : $scope.newEntry.endDate
			});
			// Clear the new entry object
			$scope.newEntry = {};
		};
		
		/**
		 * Function to submit the leave
		 */
		$scope.submitLeave = function(){
			$scope.submitFail = false;
			$scope.submitSuccess = false;
			// Build the object to submit
			
			var data = {
						applicantId : $scope.person.id,
						leavePeriods : $scope.leaveEntries
					};
			
			LeaveRestServices.submitLeave(data).then(
				// Success handler
				function(){
					$scope.submitFail = false;
					$scope.submitSuccess = true;
				},
				// Error handler
				function(reason){
					$scope.submitFail = true;
					$scope.submitSuccess = false;
				});
		};
		
		/**
		 * Function to approve a task
		 */
		$scope.approveLeave = function(task){
			LeaveRestServices.approveLeave($scope.username, task.id).then(function(){
				// Once done, refresh the task list
				$scope.searchLeaveTasks();
			});
		};
		
		/**
		 * Function to deny a task
		 */
		$scope.denyLeave = function(task){
			LeaveRestServices.denyLeave($scope.username, task.id).then(function(){
				// Once done, refresh the task list
				$scope.searchLeaveTasks();
			});
		};
		
	}]);
	
	
	
})(angular)