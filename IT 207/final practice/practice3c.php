<?php
if($_SERVER["REQUEST_METHOD"] == "GET"){
	$error = $_GET['error'];
	echo $error;
}
?>