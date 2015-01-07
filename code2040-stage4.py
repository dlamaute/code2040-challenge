#date and time

import requests
import json
from datetime import timedelta, datetime

MINUTE_CONST = 60
HOUR_CONST = 3600
DAY_CONST = 24 


def timeUpdate(datestamp, interval):
	#convert relevant parts of datestamp to datetime object
	datestamp = filter(lambda x: x in '0123456789', datestamp)

	year = int(datestamp[:4])
	month = int(datestamp[4:6])
	day = int(datestamp[6:8])
	hour = int(datestamp[8:10])
	minute = int(datestamp[10:12])
	second = int(datestamp[12:14])

	currTime = datetime(year, month, day, hour, minute, second)

	#create timedelta
	td = timedelta(seconds=interval)

	#calculate new time
	newTime = currTime + td

	#format into ISO 8601
	return str(datetime.isoformat(newTime)) + ".000Z"


url = "http://challenge.code2040.org/api/time"
data = {"token":"1yxife3KZE"}
headers = {'Content-type': 'application/json', 'Accept': 'text/plain'}
r = requests.post(url, data=json.dumps(data), headers=headers)

datestamp = r.json()['result']['datestamp']
interval = r.json()['result']['interval']

result = timeUpdate(datestamp, interval)

url = "http://challenge.code2040.org/api/validatetime"
data = {"token":"1yxife3KZE", "datestamp":result}
headers = {'Content-type': 'application/json', 'Accept': 'text/plain'}
r = requests.post(url, data=json.dumps(data), headers=headers)


	

