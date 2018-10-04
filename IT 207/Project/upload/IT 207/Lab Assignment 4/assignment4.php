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
	<hr>
	<form action="addcomments.php" method = "post">
	Name: <input type="text" name="name" /><br>
	Email Address: <input type="text" name="email" /><br>
	Comments: <textarea rows="4" cols="50" name="comments"></textarea><br>
	<input type="submit" value="Submit Comment">
	<input type="reset" value="Reset Form">
	</form>
	<hr>
	<div id="content2">
		<a href="http://helios.ite.gmu.edu/~ghuang3/IT%20207/Lab%20Assignment%204/postingcomments.php">Posting Comments</a></li>
		<a href="http://helios.ite.gmu.edu/~ghuang3/IT%20207/Lab%20Assignment%204/assignment4db.php">Database Version</a></li>
	</div>
</div>
</body>

</html>