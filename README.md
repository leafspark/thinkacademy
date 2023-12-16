# thinkacademy
Reverse-engineering of the ThinkAcademy classroom app

(Gonna be split into separate pages soon)
Unpack the agar files (Electron app)
Once installed use Chromium DevTools to examine

Why? Because this garbage is horrible, laggy and the app sucks.
Typing in things is a pain, it logs all of your keyboard strokes and sends data about your computer overseas.
Data included such as device identifiers, processor type, os version. Pretty standard analytics also sends
whether the window is focused and the code is obfuscated to hell. Not only that but there's a bunch of useless
Unicode references in the code which makes the program a little bit larger and the absurd logging in the javascript.
There are hundreds of warnings, errors, and verbose logs every second.

The whole app is just a glorified web browser. It's pretty much just Electron and hosts an web interface at localhost:10010 which is 
accessible without any authentication. The homework questions also are just (a web browser) to 
https://student-homework.thethinkacademy.com/exam? with these arguments:
pageType=answer
token=REDACTED (also absurdly long)
reportFromOrigin=2 (?)
schoolCode=415 (Area code?) [Fremont/USA=415]
platform=2 (Linux, mobile, Windows, macOS etc) [Windows=2]
homeworkId=REDACTED (32 char long hash)
planId=xxxxxx (6 character long ID maybe lesson number/homework number)
studentId=xxxxxxx (7 character long numerical ID)
classId=xxxxx (Fall, Spring, Pre-Algebra)
homeworkType=0 (Probably for like exams/tests)
