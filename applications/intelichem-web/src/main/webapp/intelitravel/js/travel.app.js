(function(angular){
	angular.module("intelitravel", ['ui.bootstrap', 'backbone', 'identity'])
	
	/**
	 * Controller for InteliTravel
	 */
	.controller("TravelRequestCtrl", 
	["$scope","$location", "TravelRestServices", 
	function($scope, $location, TravelRestServices){
		
		$scope.flights = [{ date : new Date(),  from : "Cape Town", to : "", departurePrefType : "" }];
		$scope.submitFail = false;
		$scope.submitSuccess = false;
		
		var appLid = $location.search().aid;
		var aaction = $location.search().a;
		
		// Get the departure time preference
		TravelRestServices.getSeatPrefTypes().then(function(seatPrefTypes){
			$scope.seatPrefTypes = seatPrefTypes;
		});
		
		// Get the departure time preference
		TravelRestServices.getDeparturePrefTypes().then(function(departurePrefTypes){
			$scope.departurePrefTypes = departurePrefTypes;
		});
		
		/**
		 * Function to add a new flight
		 */
		$scope.addFlight = function(index){
			$scope.flights.splice(index + 1, 0, {
				date : "",
				from : "",
				to : "",
				departurePrefType : ""
			});
		};
		
		/**
		 * Function to add a new flight
		 */
		$scope.removeFlight = function(index){
			$scope.flights.splice(index, 1);
		};
		
		/**
		 * Function to add a new flight
		 */
		$scope.returnFlight = function(){
			$scope.flights.push({
				date : "",
				from : $scope.flights[$scope.flights.length-1].to,
				to : $scope.flights[0].from,
				departurePrefType : ""
			});
		};
		
		/**
		 * Function to submit the travel request
		 */
		$scope.submitTravelRequest = function(){
			$scope.submitFail = false;
			$scope.submitSuccess = false;
			// Build the object to submit
			
			var data = {
						applicantId : $scope.person.id,
						leavePeriods : $scope.leaveEntries
					};
			
			TravelRestServices.submitRequest(data).then(
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