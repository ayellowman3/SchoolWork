<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2//EN"> -->
<?php include '../footer.inc';?>
<?php include '../sidebar.inc';?>
<?php include '../header.php';?>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<title>Assignment 2</title>
<link rel="stylesheet" href="../styles.css">
<link rel="stylesheet" href="assign2styles.css">
</head>


<body>
	<div id="container">
		<div id=setupForm><h1>Office Hour Setup Form</h1></div>
		<div id="date">date:</div>
		<div id="days">Monday</div>
		<div id="days">Tuesday</div>
		<div id="days">Wednesday</div>
		<div id="days">Thursday</div>
		<div id="days">Friday</div>
		<div id="selectTime"><B>Select times:</B></div>
		
		<form action="testCalendar.php" method="post">
		<div id="select">
		<select name="Monday[]" multiple = "multiple" SIZE="12">
		<option value = "7:00am"> 7:00am </option>
		<option value = "7:30am"> 7:30am </option>
		<option value = "8:00am"> 8:00am </option>
		<option value = "8:30am"> 8:30am </option>
		<option value = "9:00am"> 9:00am </option>
		<option value = "9:30am"> 9:30am </option>
		<option value = "10:00am"> 10:00am </option>
		<option value = "10:30am"> 10:30am </option>
		<option value = "11:00am"> 11:00am </option>
		<option value = "11:30am"> 11:30am </option>
		<option value = "12:00pm"> 12:00pm </option>
		<option value = "12:30pm"> 12:30pm </option>
		<option value = "1:00pm"> 1:00pm </option>
		<option value = "1:30pm"> 1:30pm </option>
		<option value = "2:00pm"> 2:00pm </option>
		<option value = "2:30pm"> 2:30pm </option>
		<option value = "3:00pm"> 3:00pm </option>
		<option value = "3:30pm"> 3:30pm </option>
		<option value = "4:00pm"> 4:00pm </option>
		<option value = "4:30pm"> 4:30pm </option>
		<option value = "5:00pm"> 5:00pm </option>
		<option value = "5:30pm"> 5:30pm </option>
		<option value = "6:00pm"> 6:00pm </option>
		<option value = "6:30pm"> 6:30pm </option>
		<option value = "7:00pm"> 7:00pm </option>
		<option value = "7:30pm"> 7:30pm </option>
		<option value = "8:00pm"> 8:00pm </option>
		<option value = "8:30pm"> 8:30pm </option>
		<option value = "9:00pm"> 9:00pm </option>
		<option value = "9:30pm"> 9:30pm </option>
		<option value = "10:00pm"> 10:00pm </option>
		</select>
		</div>
		
		<div id="select">
		<select name="Tuesday[]" multiple = "multiple" SIZE="12">
		<option value = "7:00am"> 7:00am </option>
		<option value = "7:30am"> 7:30am </option>
		<option value = "8:00am"> 8:00am </option>
		<option value = "8:30am"> 8:30am </option>
		<option value = "9:00am"> 9:00am </option>
		<option value = "9:30am"> 9:30am </option>
		<option value = "10:00am"> 10:00am </option>
		<option value = "10:30am"> 10:30am </option>
		<option value = "11:00am"> 11:00am </option>
		<option value = "11:30am"> 11:30am </option>
		<option value = "12:00pm"> 12:00pm </option>
		<option value = "12:30pm"> 12:30pm </option>
		<option value = "1:00pm"> 1:00pm </option>
		<option value = "1:30pm"> 1:30pm </option>
		<option value = "2:00pm"> 2:00pm </option>
		<option value = "2:30pm"> 2:30pm </option>
		<option value = "3:00pm"> 3:00pm </option>
		<option value = "3:30pm"> 3:30pm </option>
		<option value = "4:00pm"> 4:00pm </option>
		<option value = "4:30pm"> 4:30pm </option>
		<option value = "5:00pm"> 5:00pm </option>
		<option value = "5:30pm"> 5:30pm </option>
		<option value = "6:00pm"> 6:00pm </option>
		<option value = "6:30pm"> 6:30pm </option>
		<option value = "7:00pm"> 7:00pm </option>
		<option value = "7:30pm"> 7:30pm </option>
		<option value = "8:00pm"> 8:00pm </option>
		<option value = "8:30pm"> 8:30pm </option>
		<option value = "9:00pm"> 9:00pm </option>
		<option value = "9:30pm"> 9:30pm </option>
		<option value = "10:00pm"> 10:00pm </option>
		</select>
		</div>

		<div id="select">
		<select name="Wednesday[]" multiple = "multiple" SIZE="12">
		<option value = "7:00am"> 7:00am </option>
		<option value = "7:30am"> 7:30am </option>
		<option value = "8:00am"> 8:00am </option>
		<option value = "8:30am"> 8:30am </option>
		<option value = "9:00am"> 9:00am </option>
		<option value = "9:30am"> 9:30am </option>
		<option value = "10:00am"> 10:00am </option>
		<option value = "10:30am"> 10:30am </option>
		<option value = "11:00am"> 11:00am </option>
		<option value = "11:30am"> 11:30am </option>
		<option value = "12:00pm"> 12:00pm </option>
		<option value = "12:30pm"> 12:30pm </option>
		<option value = "1:00pm"> 1:00pm </option>
		<option value = "1:30pm"> 1:30pm </option>
		<option value = "2:00pm"> 2:00pm </option>
		<option value = "2:30pm"> 2:30pm </option>
		<option value = "3:00pm"> 3:00pm </option>
		<option value = "3:30pm"> 3:30pm </option>
		<option value = "4:00pm"> 4:00pm </option>
		<option value = "4:30pm"> 4:30pm </option>
		<option value = "5:00pm"> 5:00pm </option>
		<option value = "5:30pm"> 5:30pm </option>
		<option value = "6:00pm"> 6:00pm </option>
		<option value = "6:30pm"> 6:30pm </option>
		<option value = "7:00pm"> 7:00pm </option>
		<option value = "7:30pm"> 7:30pm </option>
		<option value = "8:00pm"> 8:00pm </option>
		<option value = "8:30pm"> 8:30pm </option>
		<option value = "9:00pm"> 9:00pm </option>
		<option value = "9:30pm"> 9:30pm </option>
		<option value = "10:00pm"> 10:00pm </option>
		</select>
		</div>

		<div id="select">
		<select name="Thursday[]" multiple = "multiple" SIZE="12">
		<option value = "7:00am"> 7:00am </option>
		<option value = "7:30am"> 7:30am </option>
		<option value = "8:00am"> 8:00am </option>
		<option value = "8:30am"> 8:30am </option>
		<option value = "9:00am"> 9:00am </option>
		<option value = "9:30am"> 9:30am </option>
		<option value = "10:00am"> 10:00am </option>
		<option value = "10:30am"> 10:30am </option>
		<option value = "11:00am"> 11:00am </option>
		<option value = "11:30am"> 11:30am </option>
		<option value = "12:00pm"> 12:00pm </option>
		<option value = "12:30pm"> 12:30pm </option>
		<option value = "1:00pm"> 1:00pm </option>
		<option value = "1:30pm"> 1:30pm </option>
		<option value = "2:00pm"> 2:00pm </option>
		<option value = "2:30pm"> 2:30pm </option>
		<option value = "3:00pm"> 3:00pm </option>
		<option value = "3:30pm"> 3:30pm </option>
		<option value = "4:00pm"> 4:00pm </option>
		<option value = "4:30pm"> 4:30pm </option>
		<option value = "5:00pm"> 5:00pm </option>
		<option value = "5:30pm"> 5:30pm </option>
		<option value = "6:00pm"> 6:00pm </option>
		<option value = "6:30pm"> 6:30pm </option>
		<option value = "7:00pm"> 7:00pm </option>
		<option value = "7:30pm"> 7:30pm </option>
		<option value = "8:00pm"> 8:00pm </option>
		<option value = "8:30pm"> 8:30pm </option>
		<option value = "9:00pm"> 9:00pm </option>
		<option value = "9:30pm"> 9:30pm </option>
		<option value = "10:00pm"> 10:00pm </option>
		</select>
		</div>

		<div id="select">
		<select name="Friday[]" multiple = "multiple" SIZE="12">
		<option value = "7:00am"> 7:00am </option>
		<option value = "7:30am"> 7:30am </option>
		<option value = "8:00am"> 8:00am </option>
		<option value = "8:30am"> 8:30am </option>
		<option value = "9:00am"> 9:00am </option>
		<option value = "9:30am"> 9:30am </option>
		<option value = "10:00am"> 10:00am </option>
		<option value = "10:30am"> 10:30am </option>
		<option value = "11:00am"> 11:00am </option>
		<option value = "11:30am"> 11:30am </option>
		<option value = "12:00pm"> 12:00pm </option>
		<option value = "12:30pm"> 12:30pm </option>
		<option value = "1:00pm"> 1:00pm </option>
		<option value = "1:30pm"> 1:30pm </option>
		<option value = "2:00pm"> 2:00pm </option>
		<option value = "2:30pm"> 2:30pm </option>
		<option value = "3:00pm"> 3:00pm </option>
		<option value = "3:30pm"> 3:30pm </option>
		<option value = "4:00pm"> 4:00pm </option>
		<option value = "4:30pm"> 4:30pm </option>
		<option value = "5:00pm"> 5:00pm </option>
		<option value = "5:30pm"> 5:30pm </option>
		<option value = "6:00pm"> 6:00pm </option>
		<option value = "6:30pm"> 6:30pm </option>
		<option value = "7:00pm"> 7:00pm </option>
		<option value = "7:30pm"> 7:30pm </option>
		<option value = "8:00pm"> 8:00pm </option>
		<option value = "8:30pm"> 8:30pm </option>
		<option value = "9:00pm"> 9:00pm </option>
		<option value = "9:30pm"> 9:30pm </option>
		<option value = "10:00pm"> 10:00pm </option>
		</select>
		</div>
		
		<input type="submit" value="Submit">
		<input type="reset" value="clear">
		</form>
	</div>
</body>

</html>