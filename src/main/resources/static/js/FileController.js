/**
 * 
 */
var URI = "http://localhost:8080/files/";
var application = angular.module('FileApplication',["ngRoute"]);
		
	application.controller('FileController', function($scope, $http){
			$scope.message = null;
			$scope.fileUpload = function(){
				let file = document.getElementById("fileUpload").files[0];
				let formData = new FormData();
				formData.append("file",file);
				var config = {
		           transformRequest: angular.identity,
		           transformResponse: angular.identity,
		           headers : {
		           			'Content-Type': undefined
		           }
		       }

				$http.post(URI+"/uploadFile", formData, config).then(function(response){
					$scope.message = response.data;

				}, function(response){
					$scope.message = response.data;
				})

		}


		});