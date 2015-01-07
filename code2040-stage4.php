<?php

function updateTime($interval, $datestamp){
  date_default_timezone_set('UTC');
  $time = new DateTime($datestamp);
  $intStr = "PT".$interval."S";
  $inter = new DateInterval($intStr);
  $time->add($inter);
  $newTime = $time->format(DateTime::ISO8601);
  return $newTime;
}

$request = new stdClass();
$request->token = "1yxife3KZE";
 
$json_data = json_encode($request);
 
$post = file_get_contents('http://challenge.code2040.org/api/time',null,stream_context_create(array(
    'http' => array(
        'protocol_version' => 1.1,
        'user_agent'       => 'Diana_Lamaute',
        'method'           => 'POST',
        'header'           => "Content-type: application/json\r\n".
                              "Connection: close\r\n" .
                              "Content-length: " . strlen($json_data) . "\r\n",
        'content'          => $json_data,
    ),
)));
 
if ($post){
	$interval = json_decode($post)->result->interval;
  $datestamp = json_decode($post)->result->datestamp;

  $res = updateTime($interval, $datestamp);

	$newRequest = new stdClass();
	$newRequest->token = "1yxife3KZE";
	$newRequest->datestamp = $res;
 
	$json_data = json_encode($newRequest);
 
	$post = file_get_contents('http://challenge.code2040.org/api/validatetime',null,stream_context_create(array(
    'http' => array(
        'protocol_version' => 1.1,
        'user_agent'       => 'Diana_Lamaute',
        'method'           => 'POST',
        'header'           => "Content-type: application/json\r\n".
                              "Connection: close\r\n" .
                              "Content-length: " . strlen($json_data) . "\r\n",
        'content'          => $json_data,
    ),
)));
} 
else echo "POST failed";