(function(angular){
	angular.module("nwu-backbone")
	
	/**
	 * Controller for leave application
	 */
	.controller("LeaveViewCtrl", 
	["$scope","TaskRestService", "PersonRestService","TypeRestService",
	function($scope, TaskRestService, PersonRestService, TypeRestService){
		
		$scope.busy = true;

		/**
		 * Returns a promise to get the task summary
		 */
		function getTaskSummaryPromise(){
			return TaskRestService.getSummary(applicationId).then(function(taskSummary){
				$scope.taskSummary = taskSummary;
				return taskSummary.data.applicantId;
			});
		}
		
		/**
		 * Return a promise to get the details of the user
		 */
		function getUserDetailsPromise(username){
			return PersonRestService.lookup(username).then(function(person){
				$scope.person = person;
			})
		}
		
		/**
		 * Return a promise to get the leave types
		 */
		function getLeaveTypesPromise(){
			return LeaveRestServices.getTypes().then(function(types){
				$scope.leaveTypes = types;
			});
		}
		
		// Start the chain of actions
		getTaskSummaryPromise()
			.then(getUserDetailsPromise)
			.then(getLeaveTypesPromise)
			.then(function(){
				$scope.busy = false; // We are now done
			});
		
		
		
	}]);
	
	
	
})(angular)