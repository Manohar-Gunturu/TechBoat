### What is Ajax?

Asynchronous JavaScript and XML(Later in this section you can learn how ajax is Asynchronous). Using the Ajax you can communicate with the server in background.

Ajax allow the browsers to send/get data to/from servers without page reload. So there is no need to reload the entire page to check new data/messages from servers. Loading whole page for new data is inefficient too.

###How to Communicate with server using Ajax with Jquery:
JQuery provides .load(),.post(),.get() and .getJSON() methods for Ajax. Let look at these methods in brief.

####.load() function
Using .load function you can load a page into some HTML element as shown below
        $( ".em" ).load("test.php?q=jhon@gm.com");
Above line of code loads the page test.php into the '.em'(element having class em) element. You can pass the parameters too. Above example sends the request to test.php with paramter 'q'. JQuery .load() function internally uses Ajax so request to the server will be sent in background(Asynchronously). 
Note:If you are a Java developer you can consider test.php as test.jsp or as any Servlet URL.

####.post() function
If you want to post(similar to method='post' in HTML form) some date to server then look at the code below:

		$.post( "test.php", function( data ) {     
		$(".result").html(data);
		});
In the above example data is nothing but output of of test.php. Now If you want to send the data to test.php using post method look at the below example:
  
         $.post("test.php", { email: "sam@gmail.com", Name: "Samul" },function(data){
			// If data(response of test.php) is html tags then append it to any DIV     
			// If data(response of test.php) is JSON then do some JavaScript operations and then build the required UI
		});

If you are using PHP in the backend then you have to $_POST["email"] to get the email value. If you are using Java then you have to use request.getParameter("email"); in doPost method to get the email value from the request.

Below code explains you how to send form data using ajax post (my_form is the ID of the form).

		$.post("test.php", $( "#my_form" ).serialize(),function(){
		});

.get() method is used to communicate with the server using the get method all the above examples of .post method are applicable to .get method also. Example on Jquery get method.

 

     
$.get("test.php?email=suj@yahoo.com", function( data ) {

       
$(".result").html(data);

   
});
.getJSON method
If you want to retrieve the Json response then you can go with .getJSON method as shown in below Code

 

    
$.getJSON("getJSON.php", function( data ) {

        
$(".result").html(data);

       
});

     

Note: getJSON.php should return the JSON response. All the examples of .post are applicable to .getJSON method too.

.ajaxStart() and .ajaxStop() Events
.ajaxStart() get triggers when an ajax request is sent from page.

.ajaxStop() get triggers when the ajax request gets the response.

.ajaxError() will get triggers when there is an error to communicate with the server through ajax.