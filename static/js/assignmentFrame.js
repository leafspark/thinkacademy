; (window.webpackJsonp = window.webpackJsonp || []).push([
  ['chunk-c827cafc'],
  {
    '58ac': function (e, s, t) {
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
            s('div', { staticClass: 'assignment' }, [
              s('iframe', {
                staticClass: 'iframe',
                attrs: {
                  id: 'assignment',
                  src: e.iframeUrl,
                },
              }),
            ]),
          ],
          1
        )
      },
        n = [],
        o = t('c7eb'),
        i = t('1da1'),
        r = t('dfa8'),
        c = t('7b1b'),
        d = {
          name: 'Preview',
          mixins: [c.a],
          components: { Toolbar: r.a },
          data: function () {
            return {
              backUrl: '',
              iframeUrl: '',
            }
          },
          mounted: function () {
            var e = this
            return Object(i.a)(
              Object(o.a)().mark(function s() {
                return Object(o.a)().wrap(function (s) {
                  while (1) {
                    switch ((s.prev = s.next)) {
                      case 0:
                        e.initRouteParams(), e.bindEvent()
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
                '对象函数 initRouteParams,filePath:renderer/views/h5/ExamIframe-h5.vue'
              )
              this.iframeUrl = window.sessionStorage.getItem('iframeUrl')
              this.backUrl = decodeURIComponent(
                window.sessionStorage.getItem('backUrl')
              )
            },
          },
        },
        h = d,
        m = (t('d362'), t('2877')),
        g = Object(m.a)(h, a, n, false, null, 'd9ac05ac', null)
      s.default = g.exports
    },
    '7b1b': function (e, s, t) {
      'use strict'
      t('14d9')
      t('99af')
      var a = t('d0db'),
        n = t('e39c'),
        o = {
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
                var a = Object(n.o)('homeworkId'),
                  o = Object(n.o)('classId'),
                  i = {
                    homeworkId: a,
                    homeworkClassId: o,
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
                var r = Object(n.o)('homeworkId'),
                  c = Object(n.o)('classId'),
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
      s.a = o
    },
    d362: function (e, s, t) {
      'use strict'
      t('d486')
    },
    d486: function (e, s, t) { },
  },
])
