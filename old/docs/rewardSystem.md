ThinkAcademy uses a system of coins to reward its students for purchasing classes. I've looked into the code and it appears coins are handled server side with a "red packet" token.
The "redpacket" token is used during sessions where the instructor gives coins the students, where I think this is used to verify the coins are actually legit.
I suppose the coins are pretty difficult to hack as they provide exchange for Amazon gift cards, toys, electronics such as Apple Watch, Beats headphones, various stationary, and LEGO sets.
These can be fairly pricy and I think they have an authentication system for this set up. The "Coin Mall" is avaliable during the holiday season for Christmas, and orders take about a month
to arrive shipping with the textbooks. Coins are just honestly a way to entice students and parents to keep spending money on the classes. 

## Coins Mall data (More details in networkAPI.md):
https://student-h5.thethinkacademy.com/coinsMall?previous_source=%E4%B8%AA%E4%BA%BA%E4%B8%AD%E5%BF%83%E5%85%A5%E5%8F%A3

Needs authorization token (use the one from homework.txt)

### Everytime the Coins Mall menu is entered it verifies the authorization token:
~~~
{Authorization: "(Token)",
appName: "ThinkAcademy",
uid: (User ID 7 chars),
appVersion: "2.14.0 (Latest 2.19.0)",
platform: "win", (App available for )
…} 
Authorization: "(Longer version of previous authorization?)
"appName: "ThinkAcademy"
appVersion: "2.14.0" (Latest 2.19.0)
platform: "win"
schoolCode: "415" (USA/Fremont)
"timezone: "America/Los_Angeles"
uid: (User ID)
__proto__: Object "params -------- pc" 
~~~
