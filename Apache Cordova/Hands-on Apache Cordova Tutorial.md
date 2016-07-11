We will use the initial setup you created and add additional code. Let’s say that we want to add new projects to an imaginary Toptal database, as well as view existing ones. Open up index.html and set up two tabs in the following manner:

		<!DOCTYPE html>
		<html>
			<head>
				<meta charset="utf-8" />
				<meta name="format-detection" content="telephone=no" />
				<meta name="msapplication-tap-highlight" content="no" />
				<!-- WARNING: for iOS 7, remove the width=device-width and height=device-height attributes. See https://issues.apache.org/jira/browse/CB-4323 -->
				<meta name="viewport" content="user-scalable=no, initial-scale=1, maximum-scale=1, minimum-scale=1, width=device-width, height=device-height, target-densitydpi=device-dpi" />
				<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
				<link rel="stylesheet"
		href="css/jquery.mobile-1.4.5.min.css" />
				<link rel="stylesheet" type="text/css" href="css/toptal.css" />
				<title>Hello Toptal</title>
			</head>
			<body>
				<div id="container">
					<div id="tab-content">
							
					</div>
				</div>
				<footer>
					<ul id="menu">
						<li id="search-tab-button" class="tab-button active" data-tab="#search-tab">Search Projects</li>
						<li id="post-tab-button" class="tab-button" data-tab="#add-tab">Post a Project</li>
					</ul>
				</footer>
				<div id="dev-null" style="display: none"></div>
				<script src="js/jquery-1.11.1.min.js"></script>
				<script src="js/jquery.mobile-1.4.5.min.js"></script>
				<script type="text/javascript" src="cordova.js"></script>
				<script type="text/javascript" src="js/index.js"></script>

			</body>
		</html>
		
		
Notice that I have added Bootstrap and jQuery Mobile as dependencies. Please be aware that much better solutions and frameworks have been developed for building modern hybrid applications, but since most (if not all) web developers are familiar with these two libraries, it makes sense to use them for a beginners tutorial. You can download the stylesheets from GitHub or use your own, if you prefer.

Let us move to the index.js file, and strip it down to the following:


		var app = {
			// Application Constructor
			initialize: function() {
				if (navigator.userAgent.match(/(iPhone|iPod|iPad|Android|BlackBerry)/)) {
					document.addEventListener("deviceready", this.onDeviceReady, false);
				} else {
					this.onDeviceReady();
				}
			},

			onDeviceReady: function() {
				// We will init / bootstrap our application here
			},
		};
		app.initialize();

		
Remember that the advocated architecture for Cordova applications is setting up a Single Page Application (SPA). This way, all of the resources are only loaded once when the app starts, and can stay in the web view for as long as the application is running. In addition, with SPAs, the user will not have page reloads which are not simply typical for native applications. Keeping that in mind, let us set up a simple controller to switch between the two tabs:		

			var Controller = function() {
				var controller = {
					self: null,
					initialize: function() {
						self = this;
						this.bindEvents();
						self.renderSearchView(); 
					},

					bindEvents: function() {
						$('.tab-button').on('click', this.onTabClick);
					},

					onTabClick: function(e) {
						e.preventDefault();
						if ($(this).hasClass('active')) {
							return;
						}
						
						var tab = $(this).data('tab');
						if (tab === '#add-tab') {
							self.renderPostView();
						} else {
							self.renderSearchView();
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
							// Load projects here
						}); 
					}
				}
				controller.initialize();
				return controller;
			}
			
The controller has two methods so far, one for rendering the Search View, and one for rendering the Post Project view. Let’s initialize it in our index.js file by first declaring it at the top and constructing it in the onDeviceReady method:

		// top of index.js
		var controller = null			

		// inside onDeviceReady method
		controller = new Controller();


Finally, add a script reference in index.html above the reference to index.js. You can download the Search and Post views directly from GitHub. Since the partial views are read from a file, some browsers like Chrome, while trying to render your page, will complain about cross-domain requests. At this point you can either set up a simple web server, or even better, do your first deploy to an Android device by running the following:

		cordova run android		