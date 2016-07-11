To add the console and the dialog plugins, execute the following:

      cordova plugin add org.apache.cordova.dialogs
      cordova plugin add org.apache.cordova.console
	  
The cordova.dialogs plugin enables native notifications. A common practice is to redefine the windows.alert method using the cordova.dialogs API in the following manner:

		  overrideBrowserAlert: function() {
			if (navigator.notification) { // Override default HTML alert with native dialog
				window.alert = function (message) {
					navigator.notification.alert(
						message,    // message
						null,       // callback
						"Toptal", // title
						'OK'        // buttonName
					);
				};
			}
		},	  
		
		
The overrideBrowserAlert function should be called within the deviceready event handler. You should now be able to add new projects and view existing ones from the database. If you select the checkbox “Include location”, the device will make a call to the Geolocation API and add your current location to the project.

		