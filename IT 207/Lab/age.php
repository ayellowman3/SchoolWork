 <?
 $date = new DateTime($bithdayDate);
 $now = new DateTime();
 $interval = $now->diff($date);
 return $interval->y;
 ?>