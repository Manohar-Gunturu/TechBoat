#### Display the domain name of the server that loaded the document

        <!DOCTYPE html>
		<html>
		<body>

		<p>Click the button to display the domain name of the server that loaded this document.</p>

		<button onclick="myFunction()">Try it</button>

		<p id="demo"></p>

		<script>
		function myFunction() {
			document.getElementById("demo").innerHTML = document.domain;
		}
		</script>

		</body>
		</html>

#### Replace the content of a document

         <!DOCTYPE html>
		<html>
		<body>

		<p id="demo">Click the button to replace this document with new content.</p>

		<button onclick="myFunction()">Try it</button>

		<script>
		function myFunction() {
			document.open("text/html","replace");
			document.write("<h2>Learning about the HTML DOM is fun!</h2>");
			document.close();
		}
		</script>

		</body>
		</html>
	
#### Open a new window, and add some content

       <!DOCTYPE html>
		<html>
		<body>

		<p>Click the button to open a new window and add some content.</p>

		<button onclick="myFunction()">Try it</button>

		<script>
		function myFunction() {
			var w = window.open();
			w.document.open();
			w.document.write("<h1>Hello World!</h1>");
			w.document.close();
		}
		</script>

		</body>
		</html>	
		
#### Display the number of elements with a specific name

      <!DOCTYPE html>
		<html>
		<head>
		<script>
		function getElements() {
			var x = document.getElementsByName("x");
			document.getElementById("demo").innerHTML = x.length;
		}
		</script>
		</head>
		<body>

		<p>
		Cats: <input name="x" type="radio" value="Cats">
		Dogs: <input name="x" type="radio" value="Dogs">
		</p>

		<p>
		<input type="button" onclick="getElements()" value="How many elements named x?">
		</p>

		<p id="demo"></p>

		</body>
		</html>

To get elements by tag name use `document.getElementsByTagName("input")`.


#### Find the innerHTML of the first element in the set of elements.


      <!DOCTYPE html>
		<html>
		<body>

		<a name="html">HTML Tutorial</a><br>
		<a name="css">CSS Tutorial</a><br>
		<a name="xml">XML Tutorial</a><br>

		<p>Click the button to display the innerHTML of the first anchor in the document.</p>

		<button onclick="myFunction()">Try it</button>

		<p id="demo"></p>

		<script>
		function myFunction() {
			document.getElementById("demo").innerHTML =
			document.anchors[0].innerHTML;
		}
		</script>

		</body>
		</html>



#### Change the visibility of an HTML element

     <!DOCTYPE html>
		<html>
		<body>

		<p id="p1">
		This is a text.
		This is a text.
		This is a text.
		</p>

		<input type="button" value="Hide text"
		onclick="document.getElementById('p1').style.visibility='hidden'">

		<input type="button" value="Show text"
		onclick="document.getElementById('p1').style.visibility='visible'">

		</body>
		</html>
		