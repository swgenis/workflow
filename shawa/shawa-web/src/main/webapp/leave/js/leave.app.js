(function(angular){
	angular.module("leave", ['backbone', 'identity'])
	
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
		
	}])
	/**
	 * Controller for leave application
	 */
	.controller("LeaveSearchCtrl", 
	["$scope", "LeaveRestServices", 
	function($scope, LeaveRestServices){
		
		$scope.leaveEntries = [];
		
		$scope.$watch('person', function(newValue, oldValue) {
			if(newValue == null || newValue == ""){
				$scope.leaveEntries = [];
				return;
			}
			
			LeaveRestServices.searchLeave(newValue.id).then(function(leaveEntries){
				$scope.leaveEntries = leaveEntries;
			});
		});
		
	}])
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
		
		
		
	}])
	/**
	 * Filter to show the number of days between 2 dates
	 */
	.filter('leaveTypeLabel', function() {
		return function(leaveKey) {
			var startMoment = moment(start);
			var endMoment = moment(end);
			return moment.duration(endMoment.diff(startMoment)).asDays();
		};
	});	
	
})(angular)