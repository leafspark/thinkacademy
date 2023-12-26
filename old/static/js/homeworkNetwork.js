; (window.webpackJsonp = window.webpackJsonp || []).push([
  ['chunk-337dbcdc'],
  {
    '16ba': function (e, s, t) {
      'use strict'
      t.r(s)
      var a = function () {
        var e = this,
          s = e._self._c
        return s(
          'div',
          { staticClass: 'page-wrapper' },
          [
            s('Toolbar'),
            s('div', { staticClass: 'reportReport' }, [
              s('iframe', {
                staticClass: 'iframe',
                attrs: {
                  id: 'examReport',
                  src: e.examReportUrl,
                },
              }),
            ]),
          ],
          1
        )
      },
        o = [],
        n = t('c7eb'),
        i = t('1da1'),
        r = (t('99af'), t('dfa8')),
        c = t('7b1b'),
        d = {
          name: 'ExamReport',
          components: { Toolbar: r.a },
          mixins: [c.a],
          data: function () {
            return {
              backUrl: '',
              examReportUrl: '',
              useInfo: window.localStorage.getItem('userInfo'),
            }
          },
          mounted: function () {
            var e = this
            return Object(i.a)(
              Object(n.a)().mark(function s() {
                return Object(n.a)().wrap(function (s) {
                  while (1) {
                    switch ((s.prev = s.next)) {
                      case 0:
                        e.bindEvent(), e.initRouteParams()
                      case 2:
                      case 'end':
                        return s.stop()
                    }
                  }
                }, s)
              })
            )()
          },
          methods: {
            initRouteParams: function () {
              console.info(
                '对象函数 initRouteParams,filePath:renderer/views/h5/ExamReport-h5.vue'
              )
              var e = this.useInfo
                ? JSON.parse(this.useInfo).unifiedAccessToken
                : '',
                s = this.useInfo ? JSON.parse(this.useInfo).uid : '',
                t = this.$route.query
              this.examReportUrl = ''
                .concat(t.examReportUrl, '&platform=3&classId=')
                .concat(t.classId, '&studentId=')
                .concat(s, '&token=')
                .concat(e)
              this.backUrl = t.examReportBackUrl
            },
          },
        },
        h = d,
        m = (t('d424'), t('2877')),
        u = Object(m.a)(h, a, o, false, null, '0d916721', null)
      s.default = u.exports
    },
    '7b1b': function (e, s, t) {
      'use strict'
      t('14d9')
      t('99af')
      var a = t('d0db'),
        o = t('e39c'),
        n = {
          data: { return: { isSendLogger: false } },
          methods: {
            bindEvent: function () {
              console.info(
                '对象函数 bindEvent,filePath:renderer/mixins/h5BindEvent.js'
              )
              window.addEventListener('message', this.bindMessage, false)
            },
            bindMessage: function (e) {
              var s = e.data || {}
              if ('string' === typeof s) {
                try {
                  s = JSON.parse(s)
                } catch (h) {
                  console.error(h)
                  s = e.data
                }
              }
              var t = s.action
              if (
                ('jy-exit' == t &&
                  (this.sendLoggers(
                    'h5message',
                    '退出作业事件:actionType: '
                      .concat(t, ', parseData: ')
                      .concat(JSON.stringify(s))
                  ),
                    this.isBeforeClassTest() &&
                    this.$router.push(''.concat(this.backUrl))),
                  'jy-submit' == t &&
                  (this.sendLoggers(
                    'h5message',
                    '提交作业事件:actionType: '
                      .concat(t, ', parseData: ')
                      .concat(JSON.stringify(s), ', sendMessageDone: ')
                      .concat(this.sendMessageDone)
                  ),
                    this.sendMessageDone ||
                    this.submitHomeworkEvent(
                      s.data.state || 1,
                      s.data.type || 0
                    )),
                  'jy-overtime' == t &&
                  (this.sendLoggers(
                    'h5message',
                    '请求超时事件:actionType: '
                      .concat(t, ', parseData: ')
                      .concat(JSON.stringify(s))
                  ),
                    this.isBeforeClassTest() &&
                    this.$router.push(''.concat(this.backUrl)),
                    this.$Message.warning(
                      'Network error (or your account is signed in on another device)'
                    )),
                  'jy-close' == t &&
                  (this.sendLoggers(
                    'h5message',
                    '退出h5页面事件:actionType: '
                      .concat(t, ', parseData: ')
                      .concat(JSON.stringify(s))
                  ),
                    this.isBeforeClassTest() &&
                    this.$router.push(''.concat(this.backUrl))),
                  'hwApiResponse' == t)
              ) {
                var a = Object(o.o)('homeworkId'),
                  n = Object(o.o)('classId'),
                  i = {
                    homeworkId: a,
                    homeworkClassId: n,
                    homeworkApiPath: s.data.path,
                    homeworkResponseTime: s.data.responseTime,
                    homeworkStatus: s.data.status,
                  }
                this.sendLoggers(
                  'h5message',
                  '提交作业接口响应时长:actionType: '
                    .concat(t, ', parseData: ')
                    .concat(JSON.stringify(s), ',homeworkSubmit:')
                    .concat(JSON.stringify(i))
                )
              }
              if ('hwUploadImg' == t) {
                var r = Object(o.o)('homeworkId'),
                  c = Object(o.o)('classId'),
                  d = {
                    homeworkId: r,
                    homeworkClassId: c,
                    homeworkUploadDuration: s.data.uploadDuration,
                    homeworkType: s.data.uploadType,
                    homeworkUploadStatus: s.data.uploadStatus,
                  }
                this.sendLoggers(
                  'h5message',
                  '上传图片上传时长:actionType: '
                    .concat(t, ', parseData: ')
                    .concat(JSON.stringify(s), ',homeworkUpload:')
                    .concat(JSON.stringify(d))
                )
              }
              'completedExamSuccess' == t &&
                (this.sendSubmitEaxmToTeacher(),
                  this.sendLoggers(
                    'h5message',
                    '监听h5交卷事件:actionType: '
                      .concat(t, ', parseData: ')
                      .concat(JSON.stringify(s))
                  ))
                ; ('dismissView' != t && 'hwHomeWorkRepeat' !== t) ||
                  ((this.showEaxmIframe = false),
                    (this.examUrl = ''),
                    this.sendLoggers(
                      'h5message',
                      '监听h5关闭事件:actionType: '
                        .concat(t, ', parseData: ')
                        .concat(JSON.stringify(s))
                    ))
            },
            sendLoggers: function (e, s) {
              console.info(
                '对象函数 sendLoggers(tag, msg)',
                e,
                s,
                'filePath:renderer/mixins/h5BindEvent.js'
              )
              this.isSendLogger = true
              a.a.send({
                tag: e,
                level: 'info',
                content: { msg: s },
              })
            },
            isBeforeClassTest: function () {
              return (
                console.info(
                  '对象函数 isBeforeClassTest,filePath:renderer/mixins/h5BindEvent.js'
                ),
                !!this.$router
              )
            },
          },
          beforeDestroy: function () {
            console.info(
              '对象函数 beforeDestroy,filePath:renderer/mixins/h5BindEvent.js'
            )
            window.removeEventListener('message', this.bindMessage)
          },
        }
      s.a = n
    },
    b2cc: function (e, s, t) { },
    d424: function (e, s, t) {
      'use strict'
      t('b2cc')
    },
  },
])
