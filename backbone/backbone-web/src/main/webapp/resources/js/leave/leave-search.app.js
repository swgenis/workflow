(function(angular){
	angular.module("nwu-backbone")
	
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
			
			LeaveRestServices.searchLeave(newValue).then(function(leaveEntries){
				$scope.leaveEntries = leaveEntries;
			});
		});
		
	}]);
	
	
	
})(angular)