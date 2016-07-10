### .ready() event

.ready event get triggers when the entire page(DOM) building is completed.

		$( document ).ready(function() {
			alert("entire dom is constructed"); 
		});
It is safe/best to write all the JQuery code inside the 'ready' function.
### .click() event

.click() function is used to bind the click event on an element. Example

		$( ".em" ).click(function() {
		  alert( " I got a click " );
		});
Use .on() function to attach a click event on dynamically loaded elements or on elements that appended dynamically. Example

		$( document ).on("click",".em",function() {
		  alert( " I got a click " );
		});
You can write .click function in a different way as shown below: 
			$( "#target" ).on("click",myFunction);
			function myFunction(){
			  alert( "Execute it on click of #target" ); 
			}
 
In the above example whenever a user clicks on the element having id 'target' myFuntion() method will be called.

For more visit http://uikindle.com/jquery/event_handling.html and http://api.jquery.com/category/events/
