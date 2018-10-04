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

<body>
<div id="container">
	<div id="post">
		<?php include 'paragraph.php';?>
	</div>
	<h1>Comments</h1>
	<hr>
	<?php
	include 'dbconnection.php';

	$count = 1;
	
	$all = mysqli_query($connection, "SELECT * FROM COMMENTS;");
	$commentsarray = [];
	$row = mysqli_fetch_row($all);
	
	do{
		array_push($commentsarray, $row);
		$row = mysqli_fetch_row($all);
	}while($row);
	foreach($commentsarray as $comment){
		echo "<div id=box>";
		echo "<div id=index><br>$count</div>";
		echo "<div id=info>Name: <a href=\"mailto:$comment[1]\">$comment[0]</a><br>";
		echo "Comment: $comment[2]</div>";
		echo "</div><hr>";
		$count++;
	}
	?>
	<div id="content2">
		<a href="http://helios.ite.gmu.edu/~ghuang3/IT%20207/Lab%20Assignment%204/assignment4db.php">Add New Comment</a></li><br>
		<a href="http://helios.ite.gmu.edu/~ghuang3/IT%20207/Lab%20Assignment%204/postingcommentsazdb.php">Sort Comments A-Z(by name)</a></li><br>
		<a href="http://helios.ite.gmu.edu/~ghuang3/IT%20207/Lab%20Assignment%204/postingcommentszadb.php">Sort Comments Z-A(by name)</a></li><br><br>
		<form method="post" action="postingcommentsdbdelete.php">
		Delete Comment Number: <input type="text" name="delete" />
		<input type="submit" value="Delete">
		</form>
	</div>
	<br>
</div>
</body>

</html>