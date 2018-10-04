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
	$commentsarray = [];
	$handle = fopen("comments.txt", "r");
	do{
		$commentsopen = fgets($handle);
		$commentsarray[] = $commentsopen;
	}while(!feof($handle));
	fclose($handle);
	$delete = "";
	if(!empty($_POST["delete"])){
		$delete = $_POST["delete"];
		if(($delete > sizeof($commentsarray,0)) || $delete <= 0){
			 echo "Error! Invalid selection for delete";
		}
		else{
			$temp = [];
			for($x = 0; $x<sizeof($commensarray); $x++){
				if(!($x == $delete-1)){
					$temp[] = $commentsarray[$x];
				}
			}
			$Handle = fopen("comments.txt","w+");
			fclose($Handle);
			$Handle2 = fopen("comments.txt","a+");
			for($x = 0; $x<sizeof($temp); $x++){
				fwrite($Handle2, $temp[$x]."\n");
			}
		}
	}
?>
<body>
<div id="container">
	<div id="post">
		<?php include 'paragraph.php';?>
	</div>
	<h1>Comments</h1>
	<hr>
	<?php
	$count = 1;
	for($x = 0; $x<(sizeof($commentsarray,0)-1);$x++){
		if(strlen($commentsarray[$x])>2){
			$info = explode("---", $commentsarray[$x]);
			echo "<div id=box>";
			print_r($info);
			echo "<div id=index><br>$count</div>";
			echo "<div id=info>Name: <a href=\"mailto:$info[1]\">$info[0]</a><br>";
			echo "Comment: $info[2]</div>";
			echo "</div><hr>";
			$count++;
		}
	}


	?>
	<div id="content2">
		<a href="http://helios.ite.gmu.edu/~ghuang3/IT%20207/Lab%20Assignment%204/assignment4.php">Add New Comment</a></li><br>
		<a href="http://helios.ite.gmu.edu/~ghuang3/IT%20207/Lab%20Assignment%204/postingcommentsaz.php">Sort Comments A-Z(by name)</a></li><br>
		<a href="http://helios.ite.gmu.edu/~ghuang3/IT%20207/Lab%20Assignment%204/postingcommentsza.php">Sort Comments Z-A(by name)</a></li><br><br>
		<form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">
		Delete Comment Number: <input type="text" name="delete" />
		<input type="submit" value="Delete">
		</form>
	</div>
</div>
</body>

</html>