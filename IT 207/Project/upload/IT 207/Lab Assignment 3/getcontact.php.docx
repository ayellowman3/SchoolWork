<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2//EN"> -->
<?php include '../footer.inc';?>
<?php include '../sidebar.inc';?>
<?php include '../header.php';?>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<title>Online Contacts Directory</title>
<link rel="stylesheet" href="../styles.css">
<link rel="stylesheet" href="assignment3style.css">
</head>

<?php
	$fname = $_POST["fname"];
	$lname = $_POST["lname"];
	$contactarray;
?>
<body>
<div id = "container">
<?php
	if($fname == "" || $lname == ""){
		echo"<p>You must enter a value in each field. Click your brower's Back button to return to the form.</p>";
	}
	else{
		$found = false;
		$handle = fopen("directory.txt", "r");
		do{
			$contactinfo = fgets($handle);
			$info = explode(",", $contactinfo);
			if($fname == $info[0] && $lname == $info[1]){
				$found = true;
				$contactarray = explode(",", $contactinfo);
			}
		}while(!feof($handle));
		fclose($handle);
		if(!$found){
			echo "<p>Contact does not exist!</p>";
		}
		else{
			printForm($contactarray);
		}
	}
?>
	<hr>
	<div id="content2">
		<a href="http://helios.ite.gmu.edu/~ghuang3/IT%20207/Lab%20Assignment%203/assignment3.php">Return to Directory</a></li>
	</div>
</div>
<?php
function printForm($array){	
	echo "<h1>Contact Information</h1>";
	echo "<form action=\"updatecontact.php\" method = \"post\">";
	echo "First Name: <input type=\"text\" name=\"fname\" value=  $array[0]>";
	echo "Last Name: <input type=\"text\" name=\"lname\" value=  $array[1]><br><br>";
	echo "Email Address: <input type=\"text\" name=\"email\" value=  $array[2]><br><br>";
	echo "Phone Number: <input type=\"text\" name=\"pnumber\" value=  \"$array[3]\"><br><br>";
	echo "Address: <input type=\"text\" name=\"address\" value=  \"$array[4]\">";
	echo "City: <input type=\"text\" name=\"city\" value= $array[5]><br><br>";
	echo "State:<select name=\"state\">";
	echo "<option value = \"$array[6]\">$array[6]</option>
		<option value=\"Alabama\">Alabama</option>
		<option value=\"Alaska\">Alaska</option>
		<option value=\"Arizona\">Arizona</option>
		<option value=\"Arkansas\">Arkansas</option>
		<option value=\"California\">California</option>
		<option value=\"Colorado\">Colorado</option>
		<option value=\"Connecticut\">Connecticut</option>
		<option value=\"Delaware\">Delaware</option>
		<option value=\"Florida\">Florida</option>
		<option value=\"Georgia\">Georgia</option>
		<option value=\"Hawaii\">Hawaii</option>
		<option value=\"Idaho\">Idaho</option>
		<option value=\"Illinois\">Illinois</option>
		<option value=\"Indiana\">Indiana</option>
		<option value=\"Iowa\">Iowa</option>
		<option value=\"Kansas\">Kansas</option>
		<option value=\"Kentucky\">Kentucky</option>
		<option value=\"Louisiana\">Louisiana</option>
		<option value=\"Maine\">Maine</option>
		<option value=\"Maryland\">Maryland</option>
		<option value=\"Massachussetts\">Massachussetts</option>
		<option value=\"Michigan\">Michigan</option>
		<option value=\"Minnesota\">Minnesota</option>
		<option value=\"Mississippi\">Mississippi</option>
		<option value=\"Missouri\">Missouri</option>
		<option value=\"Montana\">Montana</option>
		<option value=\"Nebraska\">Nebraska</option>
		<option value=\"Nevada\">Nevada</option>
		<option value=\"New Hampshire\">New Hampshire</option>
		<option value=\"New Jersey\">New Jersey</option>
		<option value=\"New Mexico\">New Mexico</option>
		<option value=\"New York\">New York</option>
		<option value=\"North Carolina\">North Carolina</option>
		<option value=\"North Dakota\">North Dakota</option>
		<option value=\"Ohio\">Ohio</option>
		<option value=\"Oklahoma\">Oklahoma</option>
		<option value=\"Oregon\">Oregon</option>
		<option value=\"Pennsylvania\">Pennsylvania</option>
		<option value=\"Rhode Island\">Rhode Island</option>
		<option value=\"South Carolina\">South Carolina</option>
		<option value=\"South Dakota\">South Dakota</option>
		<option value=\"Tennessee\">Tennessee</option>
		<option value=\"Texas\">Texas</option>
		<option value=\"Utah\">Utah</option>
		<option value=\"Vermont\">Vermont</option>		
		<option value=\"Virginia\">Virginia</option>
		<option value=\"Washington\">Washington</option>
		<option value=\"West Virginia\">West Virginia</option>			
		<option value=\"Wisconsin\">Wisconsin</option>
		<option value=\"Wyoming\">Wyoming</option>
		</select>";
	echo "Zip: <input type=\"text\" name=\"zip\" value= $array[7]><br><br>
	<input type=\"submit\" value=\"Update Contact\"><br><br>
	</form>";
}
?>

</body>
</html>