--TEST--
Test gmstrftime() function : usage variation - Checking time related formats which was not supported on Windows before VC14.
--FILE--
<?php
/* Prototype  : string gmstrftime(string format [, int timestamp])
 * Description: Format a GMT/UCT time/date according to locale settings
 * Source code: ext/date/php_date.c
 * Alias to functions:
 */

echo "*** Testing gmstrftime() : usage variation ***\n";

// Initialise function arguments not being substituted (if any)
$timestamp = gmmktime(8, 8, 8, 8, 8, 2008);
date_default_timezone_set("Asia/Calcutta");

//array of values to iterate over
$inputs = array(
	  'Time in a.m/p.m notation' => "%r",
	  'Time in 24 hour notation' => "%R",
	  'Current time H:M:S format' => "%T",
);

// loop through each element of the array for timestamp

foreach($inputs as $key =>$value) {
      echo "\n--$key--\n";
      var_dump( gmstrftime($value) );
      var_dump( gmstrftime($value, $timestamp) );
};

?>
===DONE===
--EXPECTF--
*** Testing gmstrftime() : usage variation ***

--Time in a.m/p.m notation--
string(%d) "%02d:%02d:%02d %c%c"
string(11) "08:08:08 AM"

--Time in 24 hour notation--
string(%d) "%02d:%02d"
string(5) "08:08"

--Current time H:M:S format--
string(%d) "%02d:%02d:%02d"
string(8) "08:08:08"
===DONE===
