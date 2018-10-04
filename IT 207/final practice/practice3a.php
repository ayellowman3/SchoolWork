<?php
$test = false;
if($test){
header('Location: '.'practice3b.php?error=1');
}
else{
	header('Location: '.'practice3c.php?error=2');
}
?>