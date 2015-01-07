#reverse a string

import requests
import json

def strRev(a_string):
	return a_string[::-1]

url = "http://challenge.code2040.org/api/getstring"
data = {"token":"1yxife3KZE"}
headers = {'Content-type': 'application/json', 'Accept': 'text/plain'}
r = requests.post(url, data=json.dumps(data), headers=headers)

string = r.json()['result']

result = strRev(string)

url = "http://challenge.code2040.org/api/validatestring"
data = {"token":"1yxife3KZE", "string":result}
headers = {'Content-type': 'application/json', 'Accept': 'text/plain'}
r = requests.post(url, data=json.dumps(data), headers=headers)