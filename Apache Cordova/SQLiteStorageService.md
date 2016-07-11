All we have now is a classic web application running inside a web view. We haven’t really used any of the native features so let’s try to do that now. A common question is how to store data locally on the device, or more precisely, what type of storage to use. If you go to Cordova’s web site, you will see that you can use four types of storage:

1)LocalStorage
2)WebSQL
3)IndexedDB

Server-side storage accessed through a web service
LocalStorage is OK for storing small amounts of data, but it won’t suffice if you are building a data-intensive application. You can use WebSQL but it is deprecated and is supported only on four platforms, excluding Windows Phone. On the other hand, IndexedDB is only available on Windows Phone 8 and BlackBerry 10. Finally, using web services to fetch and modify data fits well within the SPA paradigm, but it breaks down when your application goes offline.

This is where additional, third party plugins come in to fill the gaps in Cordova’s core. Go ahead and add SQLitePlugin to your project by running:

         cordova plugin add https://github.com/brodysoft/Cordova-SQLitePlugin
		 
SQLitePlugin provides an API to the device’s SQLite database and serves as a true persistence mechanism. We can create a simple Storage Service in the following manner:


		SQLiteStorageService = function () {
			var service = {};
			var db = window.sqlitePlugin.openDatabase({name: "demo.toptal"});

			service.initialize = function() {
				// Initialize the database 
				var deferred = $.Deferred();
				db.transaction(function(tx) {
					tx.executeSql(
						'CREATE TABLE IF NOT EXISTS projects ' + 
						'(id integer primary key, name text, company text, description text, latitude real, longitude real)'
					,[], function(tx, res) {
						tx.executeSql('DELETE FROM projects', [], function(tx, res) {
							deferred.resolve(service);
						}, function(tx, res) {
							deferred.reject('Error initializing database');
						});
					}, function(tx, res) {
						deferred.reject('Error initializing database');
					});
				});
				return deferred.promise();
			}

			service.getProjects = function() {
				// fetch projects
			}

			service.addProject = function(name, company, description, addLocation) {
				// add a new project
			}

			return service.initialize();
		}		 
		

You can download the code for fetching and adding projects from GitHub and paste it in the respective placeholders. Do not forget to add SQLiteStorageService.js to your index.html file above Controller.js, and initialize it in your controller by modifying the Controller’s init function:


			initialize: function() {
			self = this;
			new SQLiteStorageService()
			.done(function(service) {
			self.storageService = service;   
						   self.bindEvents();
						// render search view after storage service is initialized
			self.renderSearchView(); 
			}).fail(function(error) {
							alert(error);
						});
					},



If you take a glimpse at the service.addProject(), you will notice that it makes a call to the navigator.geolocation.getCurrentPosition() method. Cordova has a geolocation plugin which you can use to get your (or more precisely - the phone’s) current location, and you can even use the navigator.geolocation.watchPosition() method to receive updates when the user’s position changes. However, if you type in `cordova plugins`.

you will not find the geolocation plugin in the list. Recently it has been suggested that the Cordova geolocation plugin is demoted to status deprecated simply because the HTML5 implementation does a very good job at replacing the native implementation. Since the HTML5 API requires user consent to run, add the following lines to the /platforms/android/AndroidManifest.xml file (just before the root closing tag):

		<uses-permission android:name="android.permission.ACCESS_LOCATION_EXTRA_COMMANDS" />
		<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
		<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />


Finally, let’s add the controller event handles for adding and fetching projects from the database:


		postProject: function(e) {
					e.preventDefault();
					var name = $('#project-name').val();
					var description = $('#project-description').val();
					var company = $('#company').val();
					var addLocation = $('#include-location').is(':checked');

					if (!name || !description || !company) {
						alert('Please fill in all fields');
						return;
					} else {
						var result = self.storageService.addProject(
						name, company, description, addLocation);

						result.done(function() {
							alert('Project successfully added');
							self.renderSearchView();
						}).fail(function(error) {
							alert(error);
						});
					}
				},

		renderPostView: function() {
					$('.tab-button').removeClass('active');
					$('#post-tab-button').addClass('active');

					var $tab = $('#tab-content');
					$tab.empty();
					$("#tab-content").load("./views/post-project-view.html", function(data) {
						$('#tab-content').find('#post-project-form').on('submit', self.postProject);
					}); 
				},

		renderSearchView: function() {
					$('.tab-button').removeClass('active');
					$('#search-tab-button').addClass('active');

					var $tab = $('#tab-content');
					$tab.empty();

					var $projectTemplate = null;
					$("#tab-content").load("./views/search-project-view.html", function(data) {
						$projectTemplate = $('.project').remove();

						var projects = self.storageService.getProjects().done(function(projects) {

							for(var idx in projects) {
								var $div = $projectTemplate.clone();
								var project = projects[idx];

								$div.find('.project-name').text(project.name);
								$div.find('.project-company').text(project.company);
								$div.find('.project-description').text(project.description);

								if (project.location) {
									var url = 
										'<a target="_blank" href="https://www.google.com.au/maps/preview/@' + 
										project.location.latitude + ',' + project.location.longitude + ',10z">Click to open map</a>';
									
									$div.find('.project-location').html(url);
								} else {
									$div.find('.project-location').text("Not specified");
								}

								$tab.append($div);
							}
						}).fail(function(error) {
							alert(error);
						});
					}); 
				}
			}



			