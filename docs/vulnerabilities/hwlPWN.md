# hwlPWN

hwlPWN is a moderate security vulnerbility that targets the ThinkAcademy Exam taking interface.

Although this vulnerbility cannot achieve RCE or any particularly damaging tasks, it can push false data to the server.

Note: This is most likely an oversight, but this was an interesting this to write about.

# NOTE: USE AT YOUR OWN RISK (I DO NOT TAKE ANY RESPONSIBILITY ON HOW THIS EXPLOIT IS USED)

## Stage 1: Finding the exploit (Web)

This was a fairly simple task, as it took a bit of digging in Chrome DevTools. When receiving data for a question on an exam,

it sends over more than necessary for the task. Below is a cURL (bash) dump of what the "hwl.png" payload looks like:

~~~
curl 'https://log.jiaoyanyun.com/hwl.png' \
  -H 'authority: log.jiaoyanyun.com' \
  -H 'accept: */*' \
  -H 'accept-language: en-US,en;q=0.9' \
  -H 'content-type: text/plain' \
  -H 'dnt: 1' \
  -H 'origin: https://www.thethinkacademy.com' \
  -H 'referer: https://www.thethinkacademy.com/' \
  -H 'sec-ch-ua: "Chromium";v="119", "Not?A_Brand";v="24"' \
  -H 'sec-ch-ua-mobile: ?0' \
  -H 'sec-ch-ua-platform: "Windows"' \
  -H 'sec-fetch-dest: empty' \
  -H 'sec-fetch-mode: cors' \
  -H 'sec-fetch-site: cross-site' \
  -H 'user-agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/119.0.0.0 Safari/537.36' \
  --data-raw '{
  "type":"used", // Completed question
  "data":{"queId":"9ba5fc55334140c1932a463c6f3a8b1c", // Question ID
  "gradeGroupId":(1/2/3/4),
  "rigAnswer":[["C"]], // rightAnswer, C
  "blankAnswer":null, // Boolean, checks if answer is ""
  "type":1, // Multiple choice/blank filling?
  "subjectId":2, // Math?
  "stuAnswer":[]},
  "beg":1704512763034,
  "uuid":"REDACTED (Version 4 UUID)",
  "page":"https://www.thethinkacademy.com/quiz/exam/(32char)?examId=(Exam)",
  "ref":"", // Ref
  "title":"Think Academy",
  "pid":"(32char)", // Undefined
  "ver":"0.2.59", // Interface version
  "env":"prod",
  "org":"",
  "sys":"",
  "jobNumber":"1",
  "teaEmail":"1@qq.com",
  "stuId":1,"noPv":true}' \
  --compressed
  
Question 11, C is the correct answer
~~~

As you can see, in the "hwl.png" payload, it sends the question ID and correct answer.

You may ask, how do you trigger this? This is triggered every time a answer is selected,

or keyboard input is detected in the input area. However, it not only sends the "hwl.png"

payload for this current question, it sends the ENTIRE test over. This is obviously very

inefficient, and this one 20 question test alone cost almost 3500 requests.

## Stage 2: Exploiting

ThinkAcademy hosts many online competitions including the "World Think Cup", which winners can win many

expensive prizes such as drones and LEGO sets. Obviously you can just go to WolframAlpha or ChatGPT and

fill in the answer, but the reliability is not great.

Anyways, lets get to the fun part, exploiting.

Enter a competition, Ctrl+Shift+I, or F12 to open DevTools. (Use Chromium)

Enter the Network tab and if the first question is multiple choice, select a random answer.

If the answer is blank filling, fill a random input.

It will start to output lots of hwl.png. Go to the first one, and select it. If there is

no answer contained within, it is not it. Go to the next one, and match it. Make sure you don't

lose track! Always make sure the answer is the correct one before continuing. 

## If you are still unsure

Double check all answers, then proceed to the end of the test. DO NOT HIT SUBMIT.

After completing the last question, there should be a submit packet. Click and expand this,

and there will be a list of all your answers and the score. The totalScore should be 100 or 

whatever the specific score for the exam is. Now submit and enjoy!

### Please use this exploit ethically.
