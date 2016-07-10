Historically, JavaScript was an interpreted language. Which means an interpreter accepts the source code and executes it all in one step. The advantage here is simplicity and flexibility, but interpreters are very slow. Compilers convert the high level language into a lower level language that either the native processor or a VM (in this case, the Java VM) can execute directly. This is much faster.
JavaScript in modern browsers is now compiled on the fly. So when the script is loaded, the first thing the JavaScript engine does is compile it into a bytecode and then execute it. The reason the entire compilation step is missing from the end user's perspective is because browser developers have (thankfully) maintained the requirement that JavaScript is not explicitly compiled.

Now a days JavaScript is used at server side using Node.js runtime.

Example:

        var i=0;
        var str = 'string';
        var str1 = 'string1';
        var d = 0.2;
          		
			
Wrap above code with `<script></script>` tag to run in an html files. 

Example 1:


         function fun(s){
		    alert(s+2);
		 }	
         alert(fun(2));
         //4   		 
		 
		 
To know about JS visit https://developer.mozilla.org/en-US/docs/Web/JavaScript.	

### DOM (Document Object Model)

When a web page is loaded, the browser creates a Document Object Model of the page.
The HTML DOM model is constructed as a tree of Objects, to know about DOM goto https://developer.mozilla.org/en-US/docs/Web/API/Document_Object_Model/Introduction.

Examples on DOM manipulation https://developer.mozilla.org/en-US/docs/Web/API/Document_Object_Model/Examples.



	 