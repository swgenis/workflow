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
	}])
	/**
	 * Directive to show navigation bar
	 */
	.directive("navBar", 
	["ConfigRestService","$location",
	 function(ConfigRestService, $location){
		return {
			'restrict': 'E',
			'scope': { },
			'templateUrl': contextPath + '/backbone/html/navBar.html',
			'link' : function(scope, element, attr){
				
				scope.contextPath = contextPath;
				
				ConfigRestService.getProcesses().then(function(processes){
					scope.processes = processes;
				});
				
				ConfigRestService.getPrincipal().then(function(principal){
					scope.principal = principal;
				});
			}
		}
	}])
	/**
	 * Directive to show bread crumbs
	 */
	.directive("breadCrumbs", 
	["ConfigRestService","$location",
	 function(ConfigRestService, $location){
		return {
			'restrict': 'E',
			'scope': { },
			'templateUrl': contextPath + '/backbone/html/breadCrumbs.html',
			'link' : function(scope, element, attr){

			}
		}
	}])
	/**
	 * Directive to show thumb nails
	 */
	.directive("thumbNails", 
	["ConfigRestService","$location",
	 function(ConfigRestService, $location){
		return {
			'restrict': 'E',
			'scope': { },
			'templateUrl': contextPath + '/backbone/html/thumbNails.html',
			'link' : function(scope, element, attr){

			}
		}
	}]);
	
})(angular);