# Blocklist

This blocklist removes ThinkAcademy tracking, and will be updated every week as I find more unesscary tracking.

Import via Network Request Blocking > Enable > Plus icon > Add pattern

#### Warning: Do not add into HOSTS file, only designed for ThinkAcademy

```
pa-web.us-west-1.log.aliyuncs.com
*.amazonaws.com
logirc.thethinkacademy.com/log
logirc.thethinkacademy.com
msg.thethinkacademy.com
chatconf.thethinkacademy.com
datacenterrest.speiyou.com
one.thethinkacademy.com/api/health?payload=4096&num=1
shence-datasink.thethinkacademy.com
oversea-api.talthinktech.com/app-upgrade-check/
oversea-api-akamai.thethinkacademy.com/classroom-hub/vote/student/noAnswerCommit
pa-web.us-west-1.log.aliyuncs.com/logstores/pa-web-prod/track
sentry-electron.scope/sentry_key
arms-retcode.aliyuncs.com
newsentry.jiaoyanyun.com
```

## Set up your own filters

Block any request that includes track, log, sentry_key, sa.gif, p.jpg, or other *.image files.

These are disguises for tracking, and except for hwl.png block them all. Make sure to test before blocking.

Please make a pull request so I can add new ones to the blocklist.