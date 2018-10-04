<?php
$file = file('practice2.txt');
print_r($file);
echo(sizeof($file));
$read = fopen('practice2.txt', "r");
$write = fopen('practice2.txt', "w");
$count = 0;
if(sizeof($file) == 0){
	fwrite($write, "$count");
	$count++;
}
else{
	echo "test";
	foreach($file as $x){
		if($x !== "\n"){
			fwrite($write, $x);
			$count++;
		}
	}
	fwrite($write, "\n");
	fwrite($write, "$count");	
}
print_r($file);




?>