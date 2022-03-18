'use strict';

angular.module('MGL_Task1_app').factory('MGL_Task1_Service', ['$http', function($http) {

		var REST_SERVICE_URI = 'game/';

		var factory = {
			fetchAllGames : fetchAllGames,
			createGame : createGame,
			deleteGame : deleteGame
		};

		return factory;

		function fetchAllGames() {
			return $http.get(REST_SERVICE_URI + 'allGames').then(function(response) {
					return response.data;
				}
			);
		}

		function createGame(game) {
			return $http.post(REST_SERVICE_URI + 'newGame', game).then(function(response) {
					return response.data;
				}
			);
		}
		
		function deleteGame(game) {
			return $http.post(REST_SERVICE_URI + 'deleteGame', game).then(function(response) {
					return response.data;
					}
				);
		}

}]);
