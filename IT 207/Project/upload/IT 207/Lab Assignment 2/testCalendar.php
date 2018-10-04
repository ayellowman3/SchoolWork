<head>
<title>calendar</title>
<link rel="stylesheet" href="../styles.css">
<link rel="stylesheet" href="assign2styles.css">
</head>

<body>
	<div id="container">
		<?php 
			echo '<form method="post" action="">';
			$Monday = getTimes("Monday");
			$Tuesday = getTimes("Tuesday");
			$Wednesday = getTimes("Wednesday");
			$Thursday = getTimes("Thursday");
			$Friday = getTimes("Friday");
			
			foreach($Monday as $num){
				echo $num;
			}
			printCalendar($Monday, $Tuesday, $Wednesday, $Thursday, $Friday);
			echo '</form>';


		function printCalendar($Monday, $Tuesday, $Wednesday, $Thursday, $Friday){
			$days = array("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday");
			$daysInMonth = getDaysInMonth();
			$firstDayOfMonth = getFirstDayOfMonth();
			$blankDays = getNumBlankDays($firstDayOfMonth);
			printCalendarInfo();
			printDaysOfWeek($days);
			printBlankDays($blankDays);
			printCalendarFilled($daysInMonth, $Monday, $Tuesday, $Wednesday, $Thursday, $Friday, $days);
		}

		function printCalendarFilled($daysInMonth, $Monday, $Tuesday, $Wednesday, $Thursday, $Friday, $days){
			for($int = 1; $int <= $daysInMonth; $int++){
				$month = date("m");
				$year = date("y");
				echo "<div>$int";
				$dayOfWeek = date("l",mktime(0,0,0,$month, $int, $year));
				switch($dayOfWeek){
					case "Monday":
						printTimes($Monday);
						break;
					case "Tuesday":
						printTimes($Tuesday);
						break;
					case "Wednesday":
						printTimes($Wednesday);
						break;
					case "Thursday":
						printTimes($Thursday);
						break;
					case "Friday":
						printTimes($Friday);
						break;
				}
				echo "</div>";
			}
		}

		function printTimes($num){
			if(isset($num)){
				foreach($num as $n){
					echo "<input type='radio' name='time' value = 'time'> $n<br>";
				}
			}
		}
		function printBlankDays($blankDays){
			for($int = 0; $int < $blankDays; $int++){
				echo "<div></div>";
			}
		}

		function printDaysOfWeek($days){
			foreach($days as $day){
				echo "<div>$day</div>";
			}
		}
		function printCalendarInfo()
		{
			$month = date("M");
			$year = date("Y");
			echo "<div id=month><h1>$month, $year</h1></div>";
		}
		function getNumBlankDays($day){
			switch($day){
				case "Sunday":
					return 0;
					break;
				case "Monday":
					return 1;
					break;
				case "Tuesday":
					return 2;
					break;
				case "Wednesday":
					return 3;
					break;
				case "Thursday":
					return 4;
					break;
				case "Friday":
					return 5;
					break;
				case "Saturday":
					return 6;
					break;
			}
		}

		function getFirstDayOfMonth(){
			$month = date("m");
			$year = date("y");
			$date = mktime(0,0,0,$month,1,$year);
			return date("l", $date);
		}
		function getDaysInMonth(){
			$month = date("m");
			$year = date("y");
			return cal_days_in_month(CAL_GREGORIAN, $month, $year);
		}

		function getTimes($string){
			if(isset($_POST[$string])){
				return $_POST[$string];
			}
		}

		function printSignupForm(){
			echo '<div id="signupForm">';
			echo '<h1>Office Hour Sign Up</h1>';
			echo 'Student Name: <input type="text" name="name">';
			echo 'Student Email: <input type="text" name="email">';
			echo '<input type="submit" name = "submit" value="Submit">';
			echo '<input type="reset" value="clear">';
			echo '</div>';
		}

		?>


</body>