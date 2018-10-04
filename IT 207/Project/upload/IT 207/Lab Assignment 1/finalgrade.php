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
		function main($earned, $max, $weight)
		{
			$throwaway = false;
			$output = validate($earned, $max, $weight);
			($output == "") ? 
			getReport($earned, $max, $weight):
			print $output;
			
		}

		function validate($earned, $max, $weight)
		{
			$output = "";
			$earnedGreaterThanMax = false;
			$notEqual100 = false;
			$emptyString = false;
			$throwaway = false;
			$notNum = false;
			$negative = false;
			define('MAXWEIGHT', 100);
			for($Count = 0; $Count < 4; $Count++)
			{
				($earned[$Count] > $max[$Count]) ?
				$earnedGreaterThanMax = true:
				$throwaway = false;
			}
			$totalWeight = 0;
			foreach($weight as $point)
			{
				$totalWeight += $point;
			}
			
			($totalWeight != MAXWEIGHT) ?
			$notEqual100 = true:
			$throwaway = false;

			foreach($earned as $val)
			{
				($val == "") ?
				$emptyString = true:
				$throwaway = false;
			}
			foreach($max as $val)
			{
				($val == "") ?
				$emptyString = true:
				$throwaway = false;
			}
			foreach($weight as $val)
			{
				($val == "") ?
				$emptyString = true:
				$throwaway = false;
			}

			foreach($earned as $val)
			{
				(is_numeric($val)) ?
				$throwaway = false:
				$notNum = true;
			}
			
			foreach($max as $val)
			{
				(is_numeric($val)) ?
				$throwaway = false:
				$notNum = true;
			}
			foreach($weight as $val)
			{
				(is_numeric($val)) ?
				$throwaway = false:
				$notNum = true;
			}
			foreach($earned as $val)
			{
				($val < 0) ?
				$negative = true:
				$throwaway = false;
			}
			foreach($max as $val)
			{
				($val < 0) ?
				$negative = true:
				$throwaway = false;
			}
			foreach($weight as $val)
			{
				($val < 0) ?
				$negative = true:
				$throwaway = false;
			}



			($earnedGreaterThanMax) ?
			$output .= "<p>Error! Earned entered is greater than max!</p>":
			$throwaway = false;

			($notEqual100) ?
			$output .= "<p>Error! Weight entered is not equal to 100!</p>":
			$throwaway = false;

			($emptyString) ?
			$output .= "<p> Error! Not all inputs were entered!":
			$throwaway = false;

			($notNum) ?
			$output .= "<p>Error! Invalid value entered!</p>":
			$throwaway = false;
			($negative) ?
			$output .= "<p>Error! Negative value entered!</P>":
			$throwaway = false;

			return $output;
		}
		function getReport($earned, $max, $weight)
		{
			$earnedPercent = array();
			$weightEarned = array();
			for($Count = 0; $Count < 4; $Count++)
			{
				$earnedPercent[$Count] = getEarnedPercent($earned[$Count], $max[$Count]);
				$weightEarned[$Count] = $earnedPercent[$Count] * $weight[$Count] / 100;
			}
			printGradeSummary($earnedPercent, $weightEarned);	
			$finalGradePercentage = 0;		
			foreach($weightEarned as $num)
			{
				$finalGradePercentage += $num;
			}
			$finalGrade = "F";
			$Grade = array("D", "C", "C+", "B", "B+", "A", "A+");
			$gradePercent = array(60,70,75,80,85,90,95);
			for($int = 0; $int < 7; $int++)
			{
				($finalGradePercentage > $gradePercent[$int]) ?
				$finalGrade = $Grade[$int]:
				$finalGrade = $finalGrade;
			}
			echo"<p>Your Final Grade is a $finalGradePercentage%, which is a $finalGrade.</p>";
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
		main($earned, $max, $weight);
	?>


	</div>
</body>
</html>