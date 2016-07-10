### What Is JQuery

JQuery is a rich JavaScript Library which is mostly used for DOM manipulation and Ajax.

### What is DOM

Document Object Model (DOM) is a convention representing objects of HTML. Objects of HTML are nothing but elements of HTML. The nodes of every document are organized in a tree structure, called the DOM tree.

### What is document

Document is the root element which holds every element inside the page. That is why we use documet.getElementById('id') to get an element by its ID.

'$' Symbol in JQuery is alias of jQuery() function.
##### Let look at the below example

     $( ".em" ).html( "Next Step..." )

	 In the above example ".em" is the selector it selects the elements with class name 'em'. And .html('') is the function which changes the HTML in it.

###### To get start with the JQuery you have to import the JQuery framework into your HTML page as shown below

     <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

### What is an HTML element?
Every HTML tag creates an HTML element. In the below image there is a div tag with class name 'add-right' this div tag creates an HTML element with class name 'add-right'. 

![alt text](http://uikindle.com/jquery/element.PNG "HTML tag")

### How to select an HTML element using JQuery
To select an HTML element through JQuery you have to pass the HTML element tag name/class name/ID name/combination of these 3/any one of these three with attributes values to JQuery function as shown in below examples. 
#### Examples: 
To select an 'h4' tag element in a page: 
![alt text](http://uikindle.com/jquery/select_h.PNG "HTML tag")

If an HTML page has 2 'h4' tags then JQuery will return a array of h4 elements 
![alt text](http://uikindle.com/jquery/h4.PNG "HTML tag")





