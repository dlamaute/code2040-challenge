<?php
$entryData = new stdClass();
$entryData->email = "dlamaute@mit.edu";
$entryData->github = "https://github.com/dlamaute/code2040-challenge";
 
$json_data = json_encode($entryData);
 
$post = file_get_contents('http://challenge.code2040.org/api/register',null,stream_context_create(array(
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
 
if ($post) {
    echo $post;
} else {
    echo "POST failed";
}