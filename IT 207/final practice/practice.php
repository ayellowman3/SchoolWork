<?php

$test = file('practice.txt');
print_r($test);

$test2 = [];
foreach($test as $x){
	if($x!="" && $x!="\\r"){
		$test2[] = $x;
	}
}
print_r($test2);
$test3 = file('practice.txt', 'SKIP_EMPTY_LINES');
print_r($test3);
?>