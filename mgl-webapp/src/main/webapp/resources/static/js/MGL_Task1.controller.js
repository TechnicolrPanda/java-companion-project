'use strict';

angular.module('MGL_Task1_app').controller('MGLTask1Controller',
		[ 'MGL_Task1_Service', function(MGL_Task1_Service) {
			var self = this;
			self.game = {
				id : '',
				name : '',
				genre : ''
			};
			self.games = [];

			self.fetchAllGames = function(){
				MGL_Task1_Service.fetchAllGames().then(function(data) {
					self.games = data;
				});
			}

			self.addGame = function(){
				return MGL_Task1_Service.createGame(self.game).then( function() {
				self.fetchAllGames();
				});
			}
			
			self.deleteGame = function(game){
				return MGL_Task1_Service.deleteGame(game).then( function() {
				self.fetchAllGames();
				});
			}
			
			self.updateGame = function (gameSelected){
				self.game = angular.copy(gameSelected);			
			}

			self.fetchAllGames();
		} ]);
