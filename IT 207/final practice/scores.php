table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}

<?php
function sortData($data,$column) {
# PRE: $data is an array where each index is a row of data
# The data is sorted home,away,home_score,away_score
# $column will be a value 0-3, corresponding to the 4 columns
# POST: Returns an array in the same structure as $data
# but sorted based on the $column value

  $keys = []; 
  foreach ($data as $x=>$i) {
    $keys[] = $i[$column];
  # code...
  }
  print_r($keys);
  asort($keys);
  print_r($keys);
  $scoredatawinner = [];
  foreach($keys as $x=>$i){
    $scoredatawinner[] = $data[$x];
  }
  return $scoredatawinner;
}

function printTable($data,$headings) {
# PRE: $data is an array where each index is a row of data
# $headings is an array of table headings
# POST: Prints a table with the headings and each
# row after is an index in the $data array
   $table = "<table><tr><br>";
   foreach($headings as $i){
      $table .="<th>$i</th>";
   }
   $table .="</tr>";
   foreach($data as $i){
      $table.="<tr>";
      foreach($i as $x){
         $table.="<td>$x</td>";
      }
      $table.="</tr>";
   }
   $table .="</table>";
   echo $table;
}
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
      "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
   <head>
      <title>Files In-class Exercise</title>
   </head>

<body>
<?php
   $data = file('logs.txt');
   $scoredata = [];
   $scoredatawinner = [];
   foreach($data as $i){
      $temp = explode(",", $i);
      array_push($scoredata, $temp);
   }
   foreach($scoredata as $i){
      if($i[2]>$i[3]){
         array_push($i, "Home");
         array_push($scoredatawinner, $i);
      }
      else{
         array_push($i, "Away");   
         array_push($scoredatawinner, $i);

      }
   }
   print_r($scoredatawinner);
   

   $headings = array("Home Team","Away Team","Home Score","Away Score","Winner");
   // check $_GET for file sort
      // call sortData() if appropriate
   if($_SERVER["REQUEST_METHOD"] == "GET"){
      $column = $_GET['sort'];
      $scoredatawinner = sortData($scoredatawinner, $column);
      echo $column;
   }

   // LOOP through array
      // determine winner (home or away)
      // concatenate "Home" or "Away" as a new field in the record line
      // example: A,B,10,5 becomes A,B,10,5,Home
      
   // call printTable()
   printTable($scoredatawinner, $headings);
?>
   Sort by...
   <ul>
      <li><a href="<?php echo $_SERVER['PHP_SELF'] . "?sort=0";?>">Home Team</a></li>
      <li><a href="<?php echo $_SERVER['PHP_SELF'] . "?sort=1";?>">Away Team</a></li>
      <li><a href="<?php echo $_SERVER['PHP_SELF'] . "?sort=2";?>">Home Score</a></li>
      <li><a href="<?php echo $_SERVER['PHP_SELF'] . "?sort=3";?>">Away Score</a></li>
   </ul>
</body>
</html>