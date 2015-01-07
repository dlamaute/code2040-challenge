<?php
$request = new stdClass();
$request->token = "1yxife3KZE";
 
$json_data = json_encode($request);
 
$post = file_get_contents('http://challenge.code2040.org/api/getstring',null,stream_context_create(array(
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
	$origStr = json_decode($post)->result;
	$res = strrev($origStr);

	$newRequest = new stdClass();
	$newRequest->token = "1yxife3KZE";
	$newRequest->string = $res;
 
	$json_data = json_encode($newRequest);
 
	$post = file_get_contents('http://challenge.code2040.org/api/validatestring',null,stream_context_create(array(
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