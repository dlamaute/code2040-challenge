<?php

function noPref($prefix, $array){
  $newList = [];
  foreach ($array as $element){
    if (strpos($element, $prefix) !== 0){
      $newList[] = $element;
    }
  }
  return $newList;
}

$request = new stdClass();
$request->token = "1yxife3KZE";
 
$json_data = json_encode($request);
 
$post = file_get_contents('http://challenge.code2040.org/api/prefix',null,stream_context_create(array(
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
	$prefix = json_decode($post)->result->prefix;
  $array = json_decode($post)->result->array;

  $res = noPref($prefix, $array);

	$newRequest = new stdClass();
	$newRequest->token = "1yxife3KZE";
	$newRequest->array = $res;
 
	$json_data = json_encode($newRequest);
 
	$post = file_get_contents('http://challenge.code2040.org/api/validateprefix',null,stream_context_create(array(
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