	<?php
		$To = $_POST["email"];
		$Name = $_POST["name"];
		$Message = $_POST["message"];
		$Header = $_POST["header"];
		mail("ghuang3@masonlive.gmu.edu", $Name, $Message, $Gender);
	?>