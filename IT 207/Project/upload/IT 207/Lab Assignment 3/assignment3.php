<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2//EN"> -->
<?php include '../footer.inc';?>
<?php include '../sidebar.inc';?>
<?php include '../header.php';?>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<title>Assignment 3</title>
<link rel="stylesheet" href="../styles.css">
<link rel="stylesheet" href="assignment3style.css">
</head>


<body>
	<div id="container">
		<h1>Online Contacts Directory</h1>
		<h3>Search for a Contact</h3>
		<div id="Directory">
			<form action="getcontact.php" method="post">
			First Name: <input type="text" name="fname"/><br><br>
			Last Name: <input type="text" name="lname"/><br><br>
			<input type="submit" value="Search">
			</form>
		</div>
		<hr>
		<div id="content2">
			<a href="http://helios.ite.gmu.edu/~ghuang3/IT%20207/Lab%20Assignment%203/newcontactentry.php">Add New Contact Entry</a></li>
		</div>
	</div>
</body>

</html>