# thinkacademy-reverse-engineered
Reverse-engineering of the ThinkAcademy classroom app

Unpack the asar files (Electron app)

"npx @electron/asar extract app.asar ."

Windows command (Node.js required)

Once installed use Chromium DevTools to examine

Sends tons of analytics to servers overseas

Website: https://web.archive.org/web/20231112054724/https://www.thethinkacademy.com/

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

