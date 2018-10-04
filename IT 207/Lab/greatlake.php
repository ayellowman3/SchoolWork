<?php

$lake1 = array("Superior","Ontario","Michigan","Huron", "Erie");


$lake2[] = "Superior";
$lake2[] = "Ontario";
$lake2[] = "Michigan";
$lake2[] = "Huron";
$lake2[] = "Erie";

echo var_dump($lake1);
echo "<br>";
echo var_dump($lake2);
echo "<br>";
echo print_r($lake1);
echo "<br>";
echo print_r($lake2);
echo "<br>";
echo var_export($lake1);
echo "<br>";
echo var_export($lake2);
?>