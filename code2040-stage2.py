#needle in haystack

import requests
import json

def findNeedle(needle, haystack):
	return haystack.index(needle)

url = "http://challenge.code2040.org/api/haystack"
data = {"token":"1yxife3KZE"}
headers = {'Content-type': 'application/json', 'Accept': 'text/plain'}
r = requests.post(url, data=json.dumps(data), headers=headers)

needle = r.json()['result']['needle']
haystack = r.json()['result']['haystack']

result = findNeedle(needle, haystack)

url = "http://challenge.code2040.org/api/validateneedle"
data = {"token":"1yxife3KZE", "needle":result}
headers = {'Content-type': 'application/json', 'Accept': 'text/plain'}
r = requests.post(url, data=json.dumps(data), headers=headers)

