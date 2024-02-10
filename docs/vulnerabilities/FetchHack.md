# FetchHack Guide

First, make this POST request then in the network tab right click on "submit" packet, then click on block request URL.

It should block the url:
[http://oversea-api.thethinkacademy.com/classroom-hub/question/student/submit](http://oversea-api.thethinkacademy.com/classroom-hub/question/student/submit)

or

[http://oversea-api-akamai.thethinkacademy.com/classroom-hub/question/student/submit](http://oversea-api-akamai.thethinkacademy.com/classroom-hub/question/student/submit)


Capture a reuqest (right-click > Copy as fetch) when a question pops up (non-vote), it should look like this:
```
fetch("https://oversea-api-akamai.thethinkacademy.com/classroom-hub/question/student/submit", {
  "headers": {
    "accept": "application/json, text/plain, */*",
    "appname": "ThinkAcademy",
    "appversion": "2.14.0",
    "clienttype": "WIN_PC_STUDENT",
    "content-type": "application/json",
    "cpuarch": "undefined",
    "cpumodel": "AMD Ryzen 7 3700X 8-Core Processor              (16)",
    "deviceid": "<redacted>",
    "devicename": "win",
    "platform": "win",
    "schoolcode": "<redacted>",
    "systemversion": "win 10.0.22631",
    "timezone": "America/Los_Angeles",
    "totalmem": "31.9G",
    "x-tal-trace-id": "<redacted>",
    "x-token": "<redacted>"
  },
  "referrer": "http://localhost:10010/largeClass.html?classId=52293&planId=217643&bizId=1&subPlatformType=0&isParent=0&lessonType=FORMAL&from=course&coursewareId=3192407cd9384709a5713a15e6815603&backUrl=/courses?classId=52293&planId=217643",
  "referrerPolicy": "no-referrer-when-downgrade",
  "body": "{\"teacherId\":<redacted>,\"tutorId\":<redacted>,\"planId\":<redacted>,\"classId\":<redacted>,\"interactId\":\"<redacted>\",\"questionId\":\"<redacted>\",\"userAnswer\":[],\"isRight\":3 [2, or 1],\"userName\":\"Tom\"}",
  "method": "POST",
  "mode": "cors",
  "credentials": "omit"
});
```

## Formatting

Copy this into the developer console, then look at the body of the POST request. You will find classId, interactId, and questionId.

The classId stays the same for every question in the class, so ignore that. For future questions, extract the interactId and questionId and fill it out.

Find the Network tab, and find your request. View the response, and if the totalCoins value is correct, you have succeded.

There should be a code 1 and no error messages.

## Autorequest

Go to [leafspark.github.io/utils/thinkauto](https://leafspark.github.io/utils/thinkauto), and paste in your request into the box.

It will output the classId, interactId, and questionId. This will create a formatted fetch request you can directly paste to automatically get the correct answer.

#### *Warning*: This will make the answers show up as blank, please add a value to the userAnswer data to make it undetectable.

## More info

*isCorrect*

Possible Values
```
1 = Correct
2 = Partially Correct
3 = Incorrect
```

*classId, interactId, questionId*

Possible Values
```
48bit alphanumric hashvalue
```

### Raw data

```
to be added
```