<?php 
$firstString = "I have a 3.72 GPA";
$gpa = 3.72;
$secondString = "I have a ";
$secondString.=(int)$gpa;
$secondString.=" GPA";
echo strcmp($firstString, $secondString);
?>