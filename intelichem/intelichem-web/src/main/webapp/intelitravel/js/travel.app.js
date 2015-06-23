(function(angular){
	angular.module("intelitravel")
	
	/**
	 * Controller for InteliTravel
	 */
	.controller("TravelRequestCtrl", 
	["$scope","$location", "TravelRestServices", 
	function($scope, $location, TravelRestServices){
		
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
		
	}]);
	
	
	
})(angular)