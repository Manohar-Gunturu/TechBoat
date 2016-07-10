#### CLASS and ID in HTML

Class and id are the attributes of html elements, document can have multiple elements with the same class, but not with the same ID. 
In the below image type, class, id, name and data-validate are called attributes. 

![alt text](http://uikindle.com/jquery/attr.PNG "HTML tag")

Note: ID should be unique in an html page. Multiple elements can have same class name but not same ID.

For example <div id="menu">, this will give us the chance to target only this div with selector #menu. If you want to target multiple elements give them same class name and target them with selector .class_name

| Situation     | JQuery selector|
| ------------- |:-------------:|
| To select all elements with class name 'em'	     | $('.em') |
| To select elements with class name 'em' and with tag name 'p'	      | $('p.em')   |
| To select elements tag name 'p'	 | $('p')    |
| To select elements with ID 'my_em'| $('#my_em') |
| To select elements with class name 'em' and with class name 'em_o'| $('.em.em_o') |
|To select all elements	|  $('*') |
| To select all(recursively) elements inside an element with class name 'em' | $('.em').find('*') | 
|To select first level elements inside an element with class name 'em'	|$('.em>*')|
