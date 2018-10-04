<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2//EN"> -->
<?php include '../footer.inc';?>
<?php include '../sidebar.inc';?>
<?php include '../header.php';?>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Final Grade</title>
<link rel="stylesheet" href="assignment1styles.css">
<style type="text/css">
</style>
</head>


<body>
	<div id="gradeCalc">
	<?php
		$output = "";
		$earned = array();
		$max = array();
		$weight = array();
		$earned[0] = $_POST["earnedParticipation"];
		$earned[1] = $_POST["earnedQuiz"];
		$earned[2] = $_POST["earnedLab"];
		$earned[3] = $_POST["earnedPracticum"];
		$max[0] = $_POST["maxParticipation"];
		$max[1] = $_POST["maxQuiz"];
		$max[2] = $_POST["maxLab"];
		$max[3] = $_POST["maxPracticum"];
		$weight[0] = $_POST["weightParticipation"];
		$weight[1] = $_POST["weightQuiz"];
		$weight[2] = $_POST["weightLab"];
		$weight[3] = $_POST["weightPracticum"];

		function main($earned, $max, $weight, $output)
		{
			$output = validate($earned, $max, $weight);
			($output == "") ?
			$output = getReport($earned, $max, $weight):
			$output .= "";
			print $output;

		}


		function validate($earned, $max, $weight)
		{
			//validates that earned is less than max
			$output = "";
			for($Count = 0; $Count < 4; $Count++)
			{
				($earned[$Count] > $max[$Count]) ?
				$output .= "Error! Earned score is greater than score earned!":
				$output .= "";
			}

			//validates that total_Weight is 100
			$total_Weight = 0;
			foreach($weight as $point)
			{
				$total_Weight += $point;
			}
			
			($total_Weight == 100) ?
			$output .= "":
			$output .= "Error! Total weight score is not equal to zero." ;
			
			$emptyString = false;
			//validates that no empty string
			foreach($earned as $val)
			{
				($val == "")?
				$emptyString = true:
				$output += "";
			}
			($emptyString) ?
			$output .= "Error! Text box was left blank!":
			$output .= "";

			return $output;
		}
		
		function getReport($earned, $max, $weight)
		{
			$earnedPercent = array();
			$weightEarned = array();
			for($Count = 0; $Count < 4; $Count++)
			{
				$earnedPercent[$Count] = getEarnedPercent($earned[$Count], $max[$Count]);
			}
			for($Count = 0; $Count < 4; $Count++)
			{
				$weightEarned[$Count] = $earnedPercent[$Count] * $weight[$Count] / 100;
			}
			printGradeSummary($earnedPercent, $weightEarned);	
			$finalGradePercentage = 0;		
			foreach($weightEarned as $num)
			{
				$finalGradePercentage += $num;
			}
			echo"<p>Your Final Grade is a $finalGradePercentage%, which is a.</p>";
			return "runs";
		}

		function getEarnedPercent($earned, $max)
		{
			$result = ($earned/$max)*100;
			return $result;
		} 

		function printGradeSummary($earnedPercent, $weightEarned)
		{
			echo "<p>You earned a $earnedPercent[0]% for Participation, with a weighted value of $weightEarned[0]%</p>";
			echo "<p>You earned a $earnedPercent[1]% for the Quizzes, with a weighted value of $weightEarned[1]%</p>";
			echo "<p>You earned a $earnedPercent[2]% for the Lab Assignments, with a weighted value of $weightEarned[2]%</p>";
			echo "<p>You earned a $earnedPercent[3]% for the Practica, with a weighted value of $weightEarned[3]%</p>";
		}
		main($earned, $max, $weight, $output);
	?>
	</div>
</body>

</html>