(function(angular){
	angular.module("nwu-backbone")
	
	/**
	 * Controller for leave application
	 */
	.controller("LeaveApplicationCtrl", 
	["$scope", "LeaveRestServices", 
	function($scope, LeaveRestServices){
		
		$scope.leaveEntries = [];
		
		// Get the leave types
		LeaveRestServices.getLeaveTypes().then(function(leaveTypes){
			$scope.leaveTypes = leaveTypes;
		});
		
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
			
			// Build the object to submit
			
			var data = {
						applicantId : $scope.person.id,
						leavePeriods : $scope.leaveEntries
					};
			
			LeaveRestServices.submitLeave(data).then(
				// Success handler
				function(){
					console.log("Leave submitted");
				},
				// Error handler
				function(reason){
					console.log("Failed to submit leave");
				});
		};
		
	}]);
	
	
	
})(angular)