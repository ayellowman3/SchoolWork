<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2//EN"> -->
<?php include '../footer.inc';?>
<?php include '../sidebar.inc';?>
<?php include '../header.php';?>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<title>New Contact Entry</title>
<link rel="stylesheet" href="../styles.css">
<link rel="stylesheet" href="assignment3style.css">
</head>

<body>
<?php
	$errormessage = "";
	$input1 = $_POST["fname"];
	$input2 = $_POST["lname"];
	$input3 = $_POST["email"];
	$input4 = $_POST["pnumber"];
	$input5 = $_POST["address"];
	$input6 = $_POST["city"];
	$input7 = $_POST["state"];
	$input8 = $_POST["zip"];
	if(!file_exists("directory.txt")){
		$errormessage .= "<p>Error! File does not exist!</p>";
	}
	if($errormessage == ""){
		$errormessage .= checkempty($input1, "<p>Error! No first name entered!</p>");
		$errormessage .= checkempty($input2, "<p>Error! No last name entered!</p>");
		$errormessage .= checkempty($input3, "<p>Error! No email entered!</p>");
		$errormessage .= checkempty($input4, "<p>Error! No phone number entered!</p>");
		$errormessage .= checkempty($input5, "<p>Error! No address entered!</p>");
		$errormessage .= checkempty($input6, "<p>Error! No city entered!</p>");
		$errormessage .= checkempty($input7, "<p>Error! No state entered!</p>");
		$errormessage .= checkempty($input8, "<p>Error! No zip code entered!</p>");
	}
	if($errormessage == ""){
		$erroremail = validateemail($input3);
		$errorphonenumber = validatephonenumber($input4);
		$errorzip = validatezip($input8);
		if($erroremail){
			$errormessage .="<p>Error! Invalid email entered!</p>";
		}
		if($errorphonenumber){
			$errormessage .="<p>Error! Invalid phone number entered!</p>";
		}
		if($errorzip){
			$errormessage .="<p>Error! Invalid zip code entered!</p>";
		}
	}
	function validatephonenumber($i){
		if(strlen($i) != 14){
			return true;
		}
		if(substr($i, 0, 1) != "("){
			return true;
		}
		if(!is_numeric(substr($i, 1, 3))){
			return true;
		}	
		if(!strcmp(substr($i, 4, 6), ") ")){
			return true;
		}
		if(!is_numeric(substr($i, 6, 3))){
			return true;
		}
		if(!(substr($i, 9, 1) == "-")){
			return true;
		}
		if(!is_numeric(substr($i, 10, 4))){
			return true;
		}
		return false;
	}
	function validatezip($i){
		if(strlen($i) != 5){
			return true;
		}
		return is_int($i);

	}
	function validateemail($i){
		if(strlen($i) < 6){
			return true;
		}
		
		$atcount = substr_count($i, "@");
		if($atcount != 1){
			return true;
		}
		$atlocation = strpos($i, "@");
		if($atlocation == 0 || $atlocation == strlen($i) - 1){
			return true;
		}
		if(substr($i,$atlocation - 1, $atlocation) == "." || substr($i, $atlocation + 1, $atlocation + 2) == "."){
			return true;
		}
		$part1 = substr($i,0, $atlocation);
		$part2 = substr($i, $atlocation+1, strlen($i));
		for($int = 1; $int < strlen($part1); $int++){
			if(substr($part1, $int, $int+1) == " "){
				return true;
			}
		}
		for($int = 1; $int < strlen($part2); $int++){
			if(substr($part2, $int, $int+1) == " "){
				return true;
			}	
		}
		$periodcount = substr_count($part2, ".");
		if($periodcount == 0){
			return true;
		}
		$lastperiod = strrpos($i, ".");
		$charafterperiod = strlen($i) - $lastperiod;
		if($charafterperiod>4 || $charafterperiod<2){
			return true;
		}
		return false;


	}
	function checkempty($input, $error){
		if($input == ""){
			return $error;
		}
	}
?>
<div id="container">
<?php
	echo $row;
	if($errormessage==""){
		$Handle = fopen("directory.txt", "a+");
		if(flock($Handle, LOCK_EX)){
			if(fwrite($Handle, $input1.",")>0){echo "<p>First name successfully updated</p>";}
			if(fwrite($Handle, $input2.",")>0){echo "<p>Last name successfully updated</p>";}
			if(fwrite($Handle, $input3.",")>0){echo "<p>E-mail address successfully updated</p>";}
			if(fwrite($Handle, $input4.",")>0){echo "<p>Phone number successfully updated</p>";}
			if(fwrite($Handle, $input5.",")>0){echo "<p>Address successfully updated</p>";}
			if(fwrite($Handle, $input6.",")>0){echo "<p>City successfully updated</p>";}
			if(fwrite($Handle, $input7.",")>0){echo "<p>State successfully updated</p>";}
			if(fwrite($Handle, $input8."\n")>0){echo "<p>Zip code successfully updated</p>";}
		}
		else{
			echo"<p>Error! Locking file unsuccessful!</p>";
		}
	}
	else{
		echo $errormessage;
	}
?>
	<hr>
	<div id="content2">
		<a href="http://helios.ite.gmu.edu/~ghuang3/IT%20207/Lab%20Assignment%203/assignment3.php">Return to Directory</a></li>
	</div>
</div>
</body>