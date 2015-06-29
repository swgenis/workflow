(function(angular){
	
	angular.module("intelitravel")
	
	/**
	 * Rest Services for leave application
	 */
	.factory("TravelRestServices", 
	["BackboneRestServiceBase",
	function(BackboneRestServiceBase){
		return angular.extend({
			/**
			 * Submit leave for approval
			 */
			'submitRequest' : function(data){
				return this._callService('POST', 'travel/request', data);
			},
			/**
			 * Get the types of leave a person can take
			 */
			'getSeatPrefTypes' : function(){
				return this._callService('GET', 'travel/types/seat');
			},
			/**
			 * Get the types of leave a person can take
			 */
			'getDeparturePrefTypes' : function(){
				return this._callService('GET', 'travel/types/departure');
			}
			
		},BackboneRestServiceBase);
		
	}]);
	
	
	
})(angular)
