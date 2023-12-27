# AI and their website

### Use ChatGPT at chat.openai.com or download ProtonVPN and uBlock Origin and use the "Help" option on thethinkacademy.com on their own website. (500 char limit)

#### It will take 65096 decades to bankrupt TAL Education Group with only 1 instance. However we can drop that to:

##### However, we can assume each computer can run 4 instances. That means in only 7.5 months, with 256k hosts, we can bankrupt TAL Education Group  
~~~
Old Logic:
32548 decades with 2 instances
16274 decades with 4 instances
8137 decades with 8 instances
4068 decades with 16 instances
2034 decades with 32 instances
1017 decades with 64 instances
508 decades with 128 instances
254 decades with 256 instances
127 decades with 512 instances
64 decades with 1024 instances
32 decades with 2048 instances
16 decades with 4096 instances
8 decades with 8192 instances
4 decades with 16384 instances
2 decades with 32767 instances
1 decade with 65536 instances
5 years with 128k instances
30 months with 256k instances
15 months with 512k instances
7.5 months with 1M instances
3.25 months with 2M instances/500k hosts
42 days with 4M instances/1M hosts
21 days with 8M instances/2M hosts
21 days with 8M instances/1M hosts (Host == 8 instances)
21 days with 8M instances/500k hosts (Host == 16 instances)
21 days with 8M instances/250k hosts (Host == 32 instances)
21 days with 8M instances/125k hosts (Host == 64 instances)
21 days with 8M instances/65k hosts (Host == 128 instances)
21 days with 8M instances/32k hosts (Host == 256 instances)

Optimized prompt:

1,200,000 years with 1 instance (Optimized prompt)
600K years with 2 instances
300K years with 4 instances
150K years with 8 instances
75K years with 16 instances
32.5K years with 32 instances
16K years with 64 instances
8K years with 128 instances
4K years with 256 instances
2K years with 512 instances
1K years with 1024 instances
500 years with 2048 instances
250 years with 4096 instances
125 years with 8192 instances
62.5 years with 16384 instances
31 years with 32767 instances
15.5 years with 65536 instances
7.5 years with 128K instances
4 years with 256K instances
2 years with 512K instances
1 year with 1M instances
6 months with 2M instances
3 months with 4M instances
1.5 months with 8M instances
~~~

Why? Because they are unethical and trash.

## Bankrupter v1.0:

Note that you must have an account to do this for a auth token.

First go to a lorum ipsum generator and generate 500 chars of text. 

Then cut off around 4 chars. Save this for later, you will need this to bypass spam filters.

## Current API prices: GPT-3.5-Turbo: $0.0010 for 1k tokens. So for this 500 token input, you will need around 2000 requests to cost them $1 dollar.

Go to their site, do F12 and open Inspect Element (Ctrl+Shift+I). Switch to the Network Tab.

After you do this, there should be a button that says "Help" on the sidebar.

There should be a network packet sent. Right click and select Copy > Copy to cURL (bash)

Then add this to Insomnia. (Download that)

After getting your webChatSid (UUID), send a message. Then capture the packet and add to Insomnia.

This should contain the MessageID. Don't worry if it said error, it still went through.

Finally there should be another packet in Chrome that says streamOutput or something similar.

Copy that then paste into Insomnia. Then use the MessageID and webChatSid to fill in the request.

Click send, and you should recieve a unable to help message like this:

~~~
data: 
data: Sorry
data: ,
data:  I
data:  can
data:  only
data:  answer
data:  questions
data:  about
data:  Think
data:  Academy
data:  courses
data:  at
data:  the
data:  moment
data: .
data:  Is
data:  there
data:  anything
data:  I
data:  can
data:  help
data: ?
data: 
~~~

Then click on the arrow next to Send, and click interval. 2 seconds work fine.

You're all set! They should go bankrupt any decade now. (lol)

And if you are thinking of rate limits, I tested and there are absolutely no reasonable rate limits. Zero.
