(function(angular){
	angular.module("backbone")
	/**
	 * Directive to show an action list
	 */
	.directive("actionList", 
	["TaskRestService","$location",
	 function(TaskRestService, $location){
		return {
			'restrict': 'E',
			'scope': { },
			'templateUrl': contextPath + '/backbone/html/actionList.html',
			'link' : function(scope, element, attr){
				
				TaskRestService.list().then(function(tasks){
					scope.tasks = tasks;
				});
				
				/**
				 * Change the window location to view the selected task.
				 */
				scope.viewTask = function(task){
					window.location = contextPath + task.viewUrl;
				};
			}
		}
	}]);
	
})(angular);