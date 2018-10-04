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
		$errormessage = "<p>Error! You must enter a value in each field. Click your brower's Back button to return to the form.</p>"; 
	}
	else if(validateemail($email)){
		$errormessage = "<h2>Error! Invalid Email Entered!</h2>";
	}
	else if(!file_exists("comments.txt")){
		$errormessage = "<p>Error! File does not exist!</p>";
	}
	else{
		$errormessage .= "";
	}
?>
<div id="container">
	<br>
	<?php
	if($errormessage == ""){
		$nameexist = false;
		$commentexist = false;
		$handle = fopen("comments.txt", "r");
		do{
			$commentsopen = fgets($handle);
			if(strlen($commentsopen)>0){
				$commentsinfo = explode("---", $commentsopen);
				if($name == $commentsinfo[0]){
					$nameexist = true;
					$errormessage ="<h2>Comments Not Added</h2><hr>One per person! You have already left comments for this posting.<hr>";
				}
				if($comments == $commentsinfo[2]){
					$commentexist = true;
					$errormessage = "<h2>Comments Not Added</h2><hr>Comment already exist.<hr>";

				}
			}
		}while(!feof($handle));
		fclose($handle);
		if(!$nameexist && !$commentexist){
			$Handle = fopen("comments.txt", "a+");
			if(flock($Handle,LOCK_EX)){
				if(fwrite($Handle, $name."---")>0 && fwrite($Handle, $email."---")>0 && fwrite($Handle, $comments."\n")>0){
					echo "<h2>Comments Added</h2>";
					echo"<hr>Name: $name<br>Comments: $comments<hr>";
				}
			}
		}
	}
	else{
		echo $errormessage;
	}
?>
	<a href="http://helios.ite.gmu.edu/~ghuang3/IT%20207/Lab%20Assignment%204/assignment4.php">Someone Else Want to 
	Comment?</a></li><br>
	<a href="http://helios.ite.gmu.edu/~ghuang3/IT%20207/Lab%20Assignment%204/postingcomments.php">View Posting Comments</a></li>
</div>
</body>

</html>