<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<?php
    $url = $_GET["url"];
    if(strlen($url)==0){
        header('Location: '.'index.php=?error=1');
    }
    else(header('Location: '.'reliabilityresults.php?url=$url'));
?>
</body>
</html>