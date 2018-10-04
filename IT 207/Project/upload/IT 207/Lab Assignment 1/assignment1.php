<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2//EN"> -->
<?php include '../footer.inc';?>
<?php include '../sidebar.inc';?>
<?php include '../header.php';?>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Assignment 1</title>
<link rel="stylesheet" href="assignment1styles.css"/>
<style type="text/css">
</style>
</head>


<body>
	<div id="gradeCalc">
		<form action="finalgrade.php" method="post">
			<h3>Participation</h3>
			Earned: <input type="text" name="earnedParticipation" size="10"/>
			Max: <input type="text" name="maxParticipation" size="10"/>
			Weight (percentage): <input type="text" name="weightParticipation" size="10"/>
			<h3>Quizzes</h3>
			Earned: <input type="text" name="earnedQuiz" size="10"/>
			Max: <input type="text" name="maxQuiz" size="10"/>
			Weight (percentage): <input type="text" name="weightQuiz" size="10"/>
			<h3>Lab Assignments</h3>
			Earned: <input type="text" name="earnedLab" size="10"/>
			Max: <input type="text" name="maxLab" size="10"/>
			Weight (percentage): <input type="text" name="weightLab" size="10"/>
			<h3>Practica</h3>
			Earned: <input type="text" name="earnedPracticum" size="10"/>
			Max: <input type="text" name="maxPracticum" size="10"/>
			Weight (percentage): <input type="text" name="weightPracticum" size="10"/>
			<br /><br />
			<input type="submit" />
		</form>
	</div>
</body>

</html>