angular.module("myapp.controllers", [])
            .controller("myappcontroller", function($scope,$location,$http,$routeParams,DTOptionsBuilder, DTColumnBuilder) {
            
            $scope.formData = {
            	firstname: '',
            	lastname: '',
            	address: ''
            };
            
            
            
            $scope.submitData = function (val) {
				
				if(val){
	                var onSuccess = function (data, status, headers, config) {
	                    alert('Customer saved successfully.');
	                    $scope.submit_disabled = true;
	                };
	
	                var onError = function (data, status, headers, config) {
	                    alert('Error occured when is creating Customer.');
	                }
	
					var dataObj = {
						firstname : $scope.formData.firstname,
						lastname : $scope.formData.lastname,
						address : $scope.formData.address
					};
	                $http.post('./api/customers', dataObj)
	                    .success(onSuccess)
	                    .error(onError);
                }else{
                	$scope.submitUpdateData();
                }

            };
            
            $scope.getcreatepage = function () {
            	$scope.formData.firstname='';
		    	$scope.formData.lastname='';
		    	$scope.formData.address='';
            	$scope.submit_disabled = false;
            }
            
            $scope.submitUpdateData = function () {
            
    			var onSuccess = function (data, status, headers, config) {
	                    alert('Customer updated successfully.');
	                };
	
	                var onError = function (data, status, headers, config) {
	                    alert('Error occured when Updating...');
	                }   
	                 	
            	var dataObj = {
            		id : $scope.formData.id,
					firstname : $scope.formData.firstname,
					lastname : $scope.formData.lastname,
					address : $scope.formData.address
				};
				
				var id = $scope.formData.id;
				
                $http.put('./api/customers/'+id, dataObj)
	                    .success(onSuccess)
	                    .error(onError);
            };
            
            $scope.view_report = function () {
            	$http.get('./api/customers')
	            		.success(function(data, status, headers, config) {
	            	   			
	           		if(status == "200"){
	           		
	           			$scope.reportData = data;
	           			
	            	}
	           })
	           .error(function(data, status, headers, config) {
	            	
	           });
            
     		};
     		
    		$scope.delete_customer = function (id) {
    		
    			$http.delete('./api/customers/'+id)
	            		.success(function(data, status, headers, config) {
	            	   			
	           		if(status == "200"){
	           		
	           			alert("Customer Deleted");
	           			$scope.view_report();
	           			
	            	}
	           })
	           .error(function(data, status, headers, config) {
	            	
	           });
    		};
    		
    		var listId;
    		
    		var loc = $(location).attr('href');
			if (loc.indexOf("?") >= 0) {
			    var url = loc.substr(loc.indexOf("?") + 1, loc.length);
			    listId = url.split("=")[1];
			}
			
        	if(angular.isUndefined(listId)){
        		$scope.update=false;
        		$scope.create=true;
        	}
        	
        	if(!angular.isUndefined(listId)){
 				var param_id = listId;
            	
            	
				$http.get('./api/customers/'+param_id)
	            		.success(function(data, status, headers, config) {
	            	   			
	           		if(status == "200"){
	           		
	           			$scope.formData.id=data.id;
	           			$scope.formData.firstname=data.firstname;
		    			$scope.formData.lastname=data.lastname;
		    			$scope.formData.address=data.address;
		    			$scope.update=true;
		    			$scope.create=false;
		    			
	            	}
	           })
	           .error(function(data, status, headers, config) {
	            	
	           });
  			};
  			
  			
  				    
            $scope.vm = {};

            $scope.vm.dtOptions = DTOptionsBuilder.newOptions().withOption('order', [0, 'asc']);
    
            $scope.view_report();
           
            
            	
});
