#exclude prefix

import requests
import json

def noPref(prefix, fullList):
	newList = []
	pref = len(prefix)
	for item in fullList:
		if prefix not in item[:pref]:
			newList.append(item)
	return newList

url = "http://challenge.code2040.org/api/prefix"
data = {"token":"1yxife3KZE"}
headers = {'Content-type': 'application/json', 'Accept': 'text/plain'}
r = requests.post(url, data=json.dumps(data), headers=headers)

prefix = r.json()['result']['prefix']
arr = r.json()['result']['array']

result = noPref(prefix, arr)

url = "http://challenge.code2040.org/api/validateprefix"
data = {"token":"1yxife3KZE", "array":result}
headers = {'Content-type': 'application/json', 'Accept': 'text/plain'}
r = requests.post(url, data=json.dumps(data), headers=headers)