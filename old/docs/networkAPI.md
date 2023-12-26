## Used to get course data and etc

https://oversea-api.thethinkacademy.com/

![image](https://github.com/LeafSpark/thinkacademy/assets/78000825/1046ec9e-1b6d-48af-b267-127108c373c3)

https://pa-web.us-west-1.log.aliyuncs.com/logstores/pa-web-prod/track
![image](https://github.com/LeafSpark/thinkacademy/assets/78000825/42283d78-bec8-42e9-a625-b1c02c510cee)

## Homework/class reminders

~~~
@Request headers for ClassList
:authority: one-akamai.thethinkacademy.com
:method: POST
:path: /v1/studyCenter/classList/v3
:scheme: https
accept: application/json, text/plain, */*
accept-encoding: gzip, deflate, br
accept-language: en-US
appname: ThinkAcademy
appversion: 2.14.0
clienttype: WIN_PC_STUDENT
content-length: 2
content-type: application/json
cpuarch: undefined
cpumodel: AMD Ryzen 7 3700X 8-Core Processor              (16)
deviceid: (Removed)
devicename: win
platform: win
referer: http://localhost:10010/
schoolcode: 415
sec-fetch-dest: empty
sec-fetch-mode: cors
sec-fetch-site: cross-site
systemversion: win (Removed)
timezone: America/Los_Angeles
totalmem: 31.9G
user-agent: (Standard user agents)
x-tal-trace-id: (v4 UUID)
 x-token: (See basicData.txt for longer revision of this token)
~~~

## Gets class list of a course
### https://one-akamai.thethinkacademy.com/v1/studyCenter/classList/v3

## GetCoins
### https://oversea-api.thethinkacademy.com/classroom-hub/coin/student/getCoin
~~~
:authority: oversea-api.thethinkacademy.com
:method: POST
:path: /classroom-hub/coin/student/getCoin
:scheme: https
accept: application/json, text/plain, */*
accept-encoding: gzip, deflate, br
accept-language: en-US
appname: ThinkAcademy
appversion: 1.0.0
content-length: 0
cookie: (Removed)
platform: H5
referer: https://student-h5.thethinkacademy.com/coinsMall?previous_source=%E4%B8%AA%E4%BA%BA%E4%B8%AD%E5%BF%83%E5%85%A5%E5%8F%A3
schoolcode: 415
sec-fetch-dest: empty
sec-fetch-mode: cors
sec-fetch-site: same-site
timezone: America/Los_Angeles
user-agent: (Standard user agent)
x-token: (Long token version)
~~~
### Image of https://student-h5.thethinkacademy.com/coinsMall
![image](https://github.com/LeafSpark/thinkacademy/assets/78000825/1c35ee4c-3d65-4817-ba8b-9b45ab511e12)

### App Upgrade check (block this URL not domain)

Also checks when exiting a class

https://oversea-api.thethinkacademy.com/app-upgrade/check

Sends token and other data like device type

### Init URL

Triggered when entering a class

https://one-akamai.thethinkacademy.com/v1/config/init


