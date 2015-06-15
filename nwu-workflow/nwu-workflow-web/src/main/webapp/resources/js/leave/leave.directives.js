(function(angular){
	angular.module("nwu-backbone")
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