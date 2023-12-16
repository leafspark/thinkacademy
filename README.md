# thinkacademy
Reverse-engineering of the ThinkAcademy classroom app

View as raw for correct formatting because I'm too lazy to use markdown.

(Gonna be split into separate pages soon)
Unpack the asar files (Electron app)
"npx @electron/asar extract app.asar ."
Windows command (Node.js required)

Once installed use Chromium DevTools to examine

Why? Because this garbage is horrible, laggy and the app sucks.
Typing in things is a pain, it logs all of your keyboard strokes and sends data about your computer overseas.
Data included such as device identifiers, processor type, os version. Pretty standard analytics also sends
whether the window is focused and the code is obfuscated to hell. Not only that but there's a bunch of useless
Unicode references in the code which makes the program a little bit larger and the absurd logging in the javascript.
There are hundreds of warnings, errors, and verbose logs every second.

Website: https://web.archive.org/web/20231112054724/https://www.thethinkacademy.com/
(Archive.org because there's like infinite trackers and analytics on their site)

Sketchy as shit:
https://www.scmp.com/yp/discover/news/hong-kong/article/3058858/tearful-parents-think-academy-international-school
(Students hate it)
Failed to properly register school
Plus recent layoffs in the US
Shutdown in China due to private tutoring laws

Find docs:
https://github.com/LeafSpark/thinkacademy/blob/main/docs/basicData.txt
https://github.com/LeafSpark/thinkacademy/blob/main/docs/homework.txt
https://github.com/LeafSpark/thinkacademy/blob/main/docs/appchangelog

The code is nearly impossible to work with, so the best way to analyze it is watching it live.

From their terms of use (UK site):
1. Scope of Use
   (...)
1.3 
  The User shall not reverse engineer (oops), decompile (it's JavaScript and HTML) or disassemble the Website, and shall not modify any resource compiled inside the program file (lol). In addition to laws and regulations expressly permitting the activities above, the User must comply with the limitations of this User Agreement.

APK folder structure (Latest 2.19.3): Markdown can support images so uploaded here (Refer to docs/basicData.txt)
![image](https://github.com/LeafSpark/thinkacademy/assets/78000825/57a70228-e081-436a-acb7-adbc56248713)

