(function(angular){
	angular.module("nwu-backbone")
	
	/**
	 * Controller for leave application
	 */
	.controller("LeaveApplicationCtrl", 
	["$scope", "LeaveRestServices", 
	function($scope, LeaveRestServices){
		
		// Get the leave types
		LeaveRestServices.getLeaveTypes().then(function(leaveTypes){
			$scope.leaveTypes = leaveTypes;
		});
		
	}]);
	
	
	
})(angular)