forms


<html>
<body>

<form action="welcome.php" method="post">
Name: <input type="text" name="name"><br>
E-mail: <input type="text" name="email"><br>
<input type="submit">
</form>

</body>
</html>


<html>
<body>

Welcome <?php echo $_POST["name"]; ?><br>
Your email address is: <?php echo $_POST["email"]; ?>

</body>
</html>


input types
<input type="text">
<input type="radio">
<input type="submit">





linking to a different page
<a href="http://helios.ite.gmu.edu/~ghuang3/IT%20207/Lab%20Assignment%201/assignment1.php">Assignment 1</a>




constants 

define(name, value, case-insensitive)

<?define("GREETING", "Welcome to W3Schools.com!");
echo GREETING;
?>



colors
header: background: #7ec0ee;
sidebar: background: #f0f8ff;

linkcolors
a:link{
	color: blue;
}

a:visited{
	color: blue;
}

a:hover{
	color: red;
}

list

<ul>
  <li>Coffee</li>
  <li>Tea</li>
  <li>Milk</li>
</ul>

php operators
+	Addition
-	subtraction
*	multipliation
/	division
%	modulus
**	exponentiation

assignment operators

x=Y 	assign
x+=y 	addition
x-=y 	subtraction
x*=y 	multiplication
x/=y 	division
x%=y 	modulus


comparison operator
==
===
!=
<>
!==
>
<
>=
<=

increment
$x++
++$x
--$x
$x--

logical operator
and 	
or 	
xor either but not both
&& 	and
|| 	or
! 	not

. concatenation
.= concatenation assignment

if...elseif....else

<?php
$t = date("H");

if ($t < "10") {
    echo "Have a good morning!";
} elseif ($t < "20") {
    echo "Have a good day!";
} else {
    echo "Have a good night!";
}
?>


switch

<?php
$favcolor = "red";

switch ($favcolor) {
    case "red":
        echo "Your favorite color is red!";
        break;
    case "blue":
        echo "Your favorite color is blue!";
        break;
    case "green":
        echo "Your favorite color is green!";
        break;
    default:
        echo "Your favorite color is neither red, blue, nor green!";
}
?>


loops

do while
<?php 
$x = 6;

do {
    echo "The number is: $x <br>";
    $x++;
} while ($x <= 5);
?>

while
<?php 
$x = 1; 

while($x <= 5) {
    echo "The number is: $x <br>";
    $x++;
} 
?>

for
<?php 
for ($x = 0; $x <= 10; $x++) {
    echo "The number is: $x <br>";
} 
?>
foreach
<?php 
$colors = array("red", "green", "blue", "yellow"); 

foreach ($colors as $value) {
    echo "$value <br>";
}
?>


function
<?php
function writeMsg() {
    echo "Hello world!";
}

writeMsg(); // call the function
?>


arrays
<?php
$cars = array("Volvo", "BMW", "Toyota");
echo "I like " . $cars[0] . ", " . $cars[1] . " and " . $cars[2] . ".";
?>

<?php
$cars = array("Volvo", "BMW", "Toyota");
echo count($cars);
?>