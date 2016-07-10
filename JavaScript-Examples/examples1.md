#### Change borderWidth  

      <!DOCTYPE html>
		<html lang="en">
		<head>
		<title>Modifying an image border</title>

		<script>
		function setBorderWidth(width) {
		  document.getElementById("img1").style.borderWidth = width + "px";
		}
		</script>
		</head>

		<body>
		<p>
		  <img id="img1"
			   src="image1.gif"
			   style="border: 5px solid green;"
			   width="100" height="100" alt="border test">
		</p>

		<form name="FormName">
		  <input type="button" value="Make border 20px-wide" onclick="setBorderWidth(20);" />
		  <input type="button" value="Make border 5px-wide"  onclick="setBorderWidth(5);" />
		</form>

		</body>
		</html>
		
		
#### Manipulating Styles

     <!DOCTYPE html>
	<html lang="en">
	<head>
	<title>Changing color and font-size example</title>

	<script>
	function changeText() {
	  var p = document.getElementById("pid");

	  p.style.color = "blue"
	  p.style.fontSize = "18pt"
	}
	</script>
	</head>
	<body>

	<p id="pid" onclick="window.location.href = 'http://www.cnn.com/';">linker</p>

	<form>
	  <p><input value="rec" type="button" onclick="changeText();" /></p>
	</form>

	</body>
	</html>		
	
#### Style Object Properties

        | Property      | Description   |
		| ------------- |:-------------:|
		| background    | background properties |
		| backgroundColor | background-color of an element|
		| borderBottom | borderBottom* properties in one declaration |	
		| borderBottomColor |color of the bottom border |
		| display         | an element's display type  |
        | fontSize        |   the font size of the text|
        | marginRight     | right margin of an element |     		