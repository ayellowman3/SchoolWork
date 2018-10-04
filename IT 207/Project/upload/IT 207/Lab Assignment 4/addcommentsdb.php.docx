<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2//EN"> -->
<?php include '../footer.inc';?>
<?php include '../sidebar.inc';?>
<?php include '../header.php';?>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<title>View Posting</title>
<link rel="stylesheet" href="../styles.css">
<link rel="stylesheet" href="assignment4style.css">
</head>

<?php
define("min_char", 6);

function validateemail($i){
	if(strlen($i) < "min_char"){
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
?>
<body>
<?php
	$errormessage = "";
	$name = $_POST["name"];
	$email = $_POST["email"];
	$comments = $_POST["comments"];
	
	if($name == "" || $email == "" || $comments == ""){
		$errormessage = "<h3>Error! You must enter a value in each field. Click your brower's Back button to return to the form.</h3>"; 
	}

	else if(validateemail($email)){
		$errormessage = "<h2>Error! Invalid Email Entered!</h2>";
	}
	else{
		$errormessage = "";
	}
?>
<div id="container">
	<br>
	<div id = "post">
		<?php
		if($errormessage == ""){
			include 'dbconnection.php';
			$namerepeat = false;
			$commentrepeat = false;
			$all = mysqli_query($connection, "SELECT * FROM COMMENTS;");
			$commentsarray = [];
			$row = mysqli_fetch_row($all);
			do{
				array_push($commentsarray, $row);
				$row = mysqli_fetch_row($all);
			}while($row);
			foreach($commentsarray as $comment){
				if($name == $comment[0]){
					$namerepeat = true;
					$errormessage = "<h3>One per person! You have already left comments for this posting.</h3><br><br>"; 
				}
				if($errormessage == "" && $comments == $comment[2]){
					$commentrepeat = true;
					$errormessage = "<h3>Comment has already been posted.</h3>";
				}
			}
			if(!$namerepeat && !$commentrepeat){
				mysqli_query($connection, "INSERT INTO COMMENTS VALUES ('$name','$email','$comments')") or @mysql_error("Error saving comment");
				mysqli_close($connection);
				echo "<h3>Comments Added</h3><hr>";
				echo "Name: $name<br>Comments: $comments<br>";
				echo "<hr>";
			}
			else{
				echo $errormessage;
				echo "<hr>";
			}
		}
		else{
			echo $errormessage;
			echo "<hr>";
		}
		?>
	</div>
	<div id=content2>
	<a href="http://helios.ite.gmu.edu/~ghuang3/IT%20207/Lab%20Assignment%204/assignment4db.php">Someone Else Want to 
	Comment?</a></li><br>
	<a href="http://helios.ite.gmu.edu/~ghuang3/IT%20207/Lab%20Assignment%204/postingcommentsdb.php">View Posting Comments</a></li>
	</div>
</div>
</body>

</html>