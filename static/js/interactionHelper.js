; (window.webpackJsonp = window.webpackJsonp || []).push([
  ['chunk-14a97d99'],
  {
    '0919': function (e, t, s) { },
    '3de5b': function (e, t, s) {
      'use strict'
      s('0919')
    },
    4773: function (e, t, s) {
      'use strict'
      s('6fc9')
    },
    '5ee3': function (e, t, s) {
      e.exports = s.p + 'static/media/interact-fail.55547638.mp3'
    },
    '6fc9': function (e, t, s) { },
    '85f5': function (e, t, s) {
      'use strict'
      s.r(t)
      s.d(t, 'default', function () {
        return W
      })
      var n,
        o = s('5530'),
        r = s('d4ec'),
        a = s('bee2'),
        i = s('262e'),
        c = s('2caf'),
        u = s('b6c9'),
        l = function () {
          var e = this,
            t = e._self._c
          return t(
            'div',
            {
              directives: [
                {
                  name: 'show',
                  rawName: 'v-show',
                  value: e.visible,
                  expression: 'visible',
                },
              ],
              class:
                e.isSubmit && !e.isExceptionStatus
                  ? 'courseware-board-container-musk'
                  : 'courseware-board-container',
            },
            [
              t('audio', {
                ref: 'interactFail',
                staticClass: 'hide',
                attrs: { src: s('5ee3') },
              }),
              t('audio', {
                ref: 'interactKeyTone',
                staticClass: 'hide',
                attrs: { src: s('e32e') },
              }),
              t('audio', {
                ref: 'interactSubmit',
                staticClass: 'hide',
                attrs: { src: s('afc3') },
              }),
              t('audio', {
                ref: 'interactSuccess',
                staticClass: 'hide',
                attrs: { src: s('b0ec') },
              }),
              t('audio', {
                ref: 'coinAudio',
                attrs: { src: s('bc2e') },
              }),
              t(
                'div',
                {
                  ref: 'coursewareBoardBlock',
                  staticClass: 'courseware-board-block',
                  class: [e.isExpanded ? 'closeBoard' : 'openBoard'],
                },
                [
                  e.countdownOptions
                    ? t(
                      'div',
                      {
                        ref: 'timerBox',
                        staticClass: 'timer-box',
                        class: [e.isSubmit ? 'hidden' : ''],
                      },
                      [
                        t('ne-countdown', {
                          attrs: {
                            time: e.countdownOptions,
                            format: 'mm:ss',
                          },
                          on: { complete: e.countdownComplete },
                        }),
                      ],
                      1
                    )
                    : e._e(),
                  e.isSubmit
                    ? e._e()
                    : [
                      t(
                        'div',
                        {
                          staticClass: 'courseware-board-control',
                          on: {
                            click: function (t) { },
                          },
                        },
                        [
                          t('i', {
                            staticClass: 'ne-icon',
                            class: [e.iconClass],
                          }),
                        ]
                      ),
                      t(
                        'div',
                        { staticClass: 'courseware-board-content' },
                        [
                          t('QuestionOption', {
                            attrs: {
                              optionList: e.optionList,
                              quesTypeId: e.quesTypeId,
                            },
                            on: { change: e.upodateUserAnswer },
                          }),
                          t(
                            'button',
                            {
                              staticClass: 'submit-box',
                              class: { 'is-disabled': e.btnDisabled },
                              on: { click: e.submitAnswer },
                            },
                            [e._v(' ' + e._s(e.$t('common.submit')) + ' ')]
                          ),
                        ],
                        1
                      ),
                    ],
                  e.isSubmit && !e.isExceptionStatus
                    ? [
                      t(
                        'div',
                        { staticClass: 'courseware-board-content is-submit' },
                        [
                          t('QuestionJudge', {
                            attrs: {
                              quesTypeId: e.quesTypeId,
                              userAnswer: e.userAnswer,
                              quesAnswer: e.quesAnswer,
                            },
                          }),
                        ],
                        1
                      ),
                    ]
                    : e._e(),
                ],
                2
              ),
            ]
          )
        },
        d = [],
        m = s('c7eb'),
        p = s('1da1'),
        f = s('2909'),
        h =
          (s('99af'),
            s('0481'),
            s('4069'),
            s('d3b7'),
            s('25f0'),
            s('4e82'),
            s('e260'),
            s('6062'),
            s('3ca3'),
            s('ddb0'),
            s('753a')),
        w = s('ceab'),
        v = s('8bbf'),
        b = s.n(v),
        I = function () {
          var e = this,
            t = e._self._c
          return t(
            'transition',
            { on: { 'after-leave': e.handleAfterLeave } },
            [
              e.visible
                ? t(
                  'div',
                  {
                    staticClass: 'coursewae-toast',
                    class: [e.typeClass],
                    on: {
                      mouseenter: e.clearTimer,
                      mouseleave: e.startTimer,
                    },
                  },
                  [
                    t('h2', [e._v(e._s(e.title))]),
                    t('p', [e._v(e._s(e.message))]),
                    'right' === e.type
                      ? t('div', { staticClass: 'coins-number' }, [
                        t('i'),
                        e._v(' +' + e._s(e.coin)),
                      ])
                      : e._e(),
                  ]
                )
                : e._e(),
            ]
          )
        },
        C = [],
        y = {
          data: function () {
            return {
              visible: false,
              type: 'right',
              title: '',
              message: '',
              coin: 0,
              duration: 0,
              closed: false,
              onClose: null,
              timer: null,
            }
          },
          computed: {
            typeClass: function () {
              return (
                console.info(
                  '对象函数 typeClass,filePath:renderer/components/Classroom/CommonInteractions/coursewareBoard/components/toast/toast.vue'
                ),
                'is-'.concat(g[this.type])
              )
            },
          },
          mounted: function () {
            this.startTimer()
          },
          methods: {
            handleAfterLeave: function () {
              var e, t
              console.info(
                '对象函数 handleAfterLeave,filePath:renderer/components/Classroom/CommonInteractions/coursewareBoard/components/toast/toast.vue'
              )
              this.$destroy(true)
              null === (e = this.$el) ||
                void 0 === e ||
                null === (t = e.parentNode) ||
                void 0 === t ||
                t.removeChild(this.$el)
            },
            close: function () {
              console.info(
                '对象函数 close,filePath:renderer/components/Classroom/CommonInteractions/coursewareBoard/components/toast/toast.vue'
              )
              this.closed = true
              'function' === typeof this.onClose && this.onClose(this)
            },
            clearTimer: function () {
              console.info(
                '对象函数 clearTimer,filePath:renderer/components/Classroom/CommonInteractions/coursewareBoard/components/toast/toast.vue'
              )
              clearTimeout(this.timer)
            },
            startTimer: function () {
              var e = this
              console.info(
                '对象函数 startTimer,filePath:renderer/components/Classroom/CommonInteractions/coursewareBoard/components/toast/toast.vue'
              )
              this.duration > 0 &&
                (this.timer = setTimeout(function () {
                  e.closed || e.close()
                }, this.duration))
            },
          },
          watch: {
            closed: function (e) {
              console.info(
                '对象函数 closed(newVal)',
                e,
                'filePath:renderer/components/Classroom/CommonInteractions/coursewareBoard/components/toast/toast.vue'
              )
              e && (this.visible = false)
            },
          },
        },
        B = y,
        A = (s('3de5b'), s('2877')),
        q = Object(A.a)(B, I, C, false, null, '50eee934', null),
        O = q.exports,
        j = b.a.extend(O),
        x = 1,
        _ = function (e) {
          console.info(
            '箭头函数 ToastBox(options)',
            e,
            'filePath:renderer/components/Classroom/CommonInteractions/coursewareBoard/components/toast/index.js'
          )
          e = e || {}
          'string' === typeof e && (e = { message: e })
          var t = 'toast_' + x++
          return (
            (n = new j({ data: e })),
            (n.id = t),
            n.$mount(),
            document.getElementById('interactionController').appendChild(n.$el),
            (n.visible = true),
            n
          )
        }
      _.close = function () {
        n && (n.visible = false)
      }
      var k = _,
        T = s('d0db'),
        $ = (function (e) {
          Object(i.a)(s, e)
          var t = Object(c.a)(s)
          function s() {
            var e,
              n =
                arguments.length > 0 && void 0 !== arguments[0]
                  ? arguments[0]
                  : {}
            return (
              console.info(
                '函数申明 Main(opts)',
                n,
                'filePath:renderer/components/Classroom/CommonInteractions/coursewareBoard/coursewareBoard.js'
              ),
              Object(r.a)(this, s),
              (e = t.call(this)),
              (e.options = n),
              (e.vm = n.vm),
              (e.quesInfo = null),
              e.handleQuesInfo(),
              e
            )
          }
          return (
            Object(a.a)(s, [
              {
                key: 'initCountdown',
                value: function () {
                  var e = +new Date(),
                    t =
                      this.options.roomMessage.roomInfo.commonOption.timeOffset,
                    s =
                      1000 * this.options.ircMsg.countDownTime -
                      (e + t - this.options.ircMsg.currentTime)
                  return (
                    T.a.send({
                      tag: 'student.Interact',
                      content: {
                        msg: '本机时间\uFF1A'
                          .concat(e, ',偏移量:')
                          .concat(t, ',倒计时')
                          .concat(s),
                        interactType: '答题h5互动',
                        interactId: this.options.ircMsg.interactId,
                      },
                    }),
                    s
                  )
                },
              },
              {
                key: 'handleQuesInfo',
                value: function () {
                  var e = this.options.ircMsg,
                    t = e.quesTypeId,
                    s = e.quesAnswer,
                    n = e.quesOptions,
                    o = e.quesId,
                    r = e.interactId,
                    a = e.rightCoin,
                    i = e.countDownTime,
                    c = this.options.roomMessage.roomInfo,
                    u = c.stuInfo,
                    l = c.teacherInfo,
                    d = c.stuLiveInfo
                  return (
                    (this.quesInfo = {
                      quesTypeId: 1 * t,
                      quesAnswer: s,
                      quesOptions: n.flat(),
                      quesId: o,
                      interactId: r,
                      rightCoin: a,
                      countDownTime: i,
                      stuInfo: u,
                      teacherInfo: l,
                      stuLiveInfo: d,
                    }),
                    this.quesInfo
                  )
                },
              },
              {
                key: 'handleCorrectQues',
                value: function (e, t) {
                  return e.length
                    ? Object(f.a)(new Set(e)).sort().toString() ===
                      Object(f.a)(new Set(t)).sort().toString()
                      ? 1
                      : 2
                    : (console.info(
                      'if(!userAnswer.length)为true触发return,path: /renderer/components/Classroom/CommonInteractions/coursewareBoard/coursewareBoard.js'
                    ),
                      3)
                },
              },
              {
                key: 'submitAnswer',
                value: (function () {
                  var e = Object(p.a)(
                    Object(m.a)().mark(function e(t) {
                      var s, n, r, a, i, c, u
                      return Object(m.a)().wrap(
                        function (e) {
                          while (1) {
                            switch ((e.prev = e.next)) {
                              case 0:
                                return (
                                  (s = {
                                    teacherId: this.quesInfo.teacherInfo.id,
                                    tutorId: this.quesInfo.stuLiveInfo.tutorId,
                                    planId: this.quesInfo.stuLiveInfo.planId,
                                    classId: this.quesInfo.stuLiveInfo.classId,
                                    interactId: this.quesInfo.interactId,
                                    questionId: this.quesInfo.quesId,
                                    userAnswer: Object(f.a)(t),
                                    isRight: this.handleCorrectQues(
                                      t,
                                      this.quesInfo.quesAnswer
                                    ),
                                    userName: this.quesInfo.stuInfo.nickName,
                                  }),
                                  (e.next = 3),
                                  Object(w.f)(s).catch(function (e) {
                                    return (
                                      console.info(
                                        '箭头函数 submitUserAnswer的catch(err)',
                                        e,
                                        'filePath:renderer/components/Classroom/CommonInteractions/coursewareBoard/coursewareBoard.js'
                                      ),
                                      T.a.send({
                                        tag: 'http',
                                        content: {
                                          msg: '接口报错:提交答案:',
                                          err: e,
                                          params: s,
                                        },
                                        level: 'error',
                                      }),
                                      e
                                    )
                                  })
                                )
                              case 3:
                                if (
                                  ((n = e.sent),
                                    (r = n.code),
                                    (a = n.data),
                                    (i = s.isRight),
                                    (c = Object(o.a)(
                                      Object(o.a)({}, a),
                                      {},
                                      {
                                        isRight: i,
                                        rightCoin:
                                          null === a || void 0 === a
                                            ? void 0
                                            : a.rightCoin,
                                      }
                                    )),
                                    (u = {
                                      params: s,
                                      response: n,
                                      isSubmit: false,
                                      isRight: i,
                                    }),
                                    b.a.prototype.$bus.$emit(
                                      'continuousCorrect',
                                      c
                                    ),
                                    0 !== r)
                                ) {
                                  break
                                }
                                return (
                                  console.info(
                                    'if(code === 0)为true触发return,path: /renderer/components/Classroom/CommonInteractions/coursewareBoard/coursewareBoard.js'
                                  ),
                                  (1 !== i && 2 != i) ||
                                  b.a.prototype.$bus.$emit(
                                    'updateAchievement',
                                    'add',
                                    a.rightCoin
                                  ),
                                  (u.isSubmit = true),
                                  e.abrupt('return', u)
                                )
                              case 14:
                                return e.abrupt('return', u)
                              case 15:
                              case 'end':
                                return e.stop()
                            }
                          }
                        },
                        e,
                        this
                      )
                    })
                  )
                  function t(t) {
                    return (
                      console.info(
                        '函数申明 submitAnswer(_x)',
                        t,
                        'filePath:renderer/components/Classroom/CommonInteractions/coursewareBoard/coursewareBoard.js'
                      ),
                      e.apply(this, arguments)
                    )
                  }
                  return t
                })(),
              },
              {
                key: 'questionStatus',
                value: (function () {
                  var e = Object(p.a)(
                    Object(m.a)().mark(function e() {
                      var t
                      return Object(m.a)().wrap(
                        function (e) {
                          while (1) {
                            switch ((e.prev = e.next)) {
                              case 0:
                                return (
                                  (e.prev = 0),
                                  (t = {
                                    teacherId: this.quesInfo.teacherInfo.id,
                                    tutorId: this.quesInfo.stuLiveInfo.tutorId,
                                    planId: this.quesInfo.stuLiveInfo.planId,
                                    courseId:
                                      this.quesInfo.stuLiveInfo.courseId,
                                    classId: this.quesInfo.stuLiveInfo.classId,
                                    interactId: this.quesInfo.interactId,
                                  }),
                                  (e.next = 4),
                                  Object(w.d)(t)
                                )
                              case 4:
                                return e.abrupt('return', e.sent)
                              case 7:
                                ; (e.prev = 7),
                                  (e.t0 = e.catch(0)),
                                  console.error('getQuestionStatus', e.t0)
                              case 10:
                              case 'end':
                                return e.stop()
                            }
                          }
                        },
                        e,
                        this,
                        [[0, 7]]
                      )
                    })
                  )
                  function t() {
                    return (
                      console.info(
                        '函数申明 questionStatus, filePath:renderer/components/Classroom/CommonInteractions/coursewareBoard/coursewareBoard.js'
                      ),
                      e.apply(this, arguments)
                    )
                  }
                  return t
                })(),
              },
              {
                key: 'interactReport',
                value: (function () {
                  var e = Object(p.a)(
                    Object(m.a)().mark(function e() {
                      var t
                      return Object(m.a)().wrap(
                        function (e) {
                          while (1) {
                            switch ((e.prev = e.next)) {
                              case 0:
                                return (
                                  (e.prev = 0),
                                  (t = {
                                    planId: this.quesInfo.stuLiveInfo.planId,
                                    classId: this.quesInfo.stuLiveInfo.classId,
                                    interactId: this.quesInfo.interactId,
                                  }),
                                  (e.next = 4),
                                  Object(w.e)(t)
                                )
                              case 4:
                                return e.abrupt('return', e.sent)
                              case 7:
                                ; (e.prev = 7),
                                  (e.t0 = e.catch(0)),
                                  console.error('interactReport', e.t0)
                              case 10:
                              case 'end':
                                return e.stop()
                            }
                          }
                        },
                        e,
                        this,
                        [[0, 7]]
                      )
                    })
                  )
                  function t() {
                    return (
                      console.info(
                        '函数申明 interactReport, filePath:renderer/components/Classroom/CommonInteractions/coursewareBoard/coursewareBoard.js'
                      ),
                      e.apply(this, arguments)
                    )
                  }
                  return t
                })(),
              },
              {
                key: 'closeToast',
                value: function () {
                  return k.close()
                },
              },
            ]),
            s
          )
        })(h.a),
        S = function () {
          var e = this,
            t = e._self._c
          return t(
            'div',
            {
              staticClass: 'options-box',
              attrs: { 'data-log': '单选多选判断面板' },
            },
            [
              1 === e.quesTypeId
                ? t(
                  'ne-radio-group',
                  {
                    staticClass: 'courseware-options',
                    on: { change: e.handleChange },
                    model: {
                      value: e.userAnswer,
                      callback: function (t) { },
                      expression: 'userAnswer',
                    },
                  },
                  e._l(e.optionList, function (e, s) {
                    return t('ne-radio-button', {
                      key: s,
                      attrs: { label: e },
                    })
                  }),
                  1
                )
                : e._e(),
              2 === e.quesTypeId
                ? t(
                  'ne-checkbox-group',
                  {
                    staticClass: 'courseware-options',
                    on: { change: e.handleChange },
                    model: {
                      value: e.userAnswer,
                      callback: function (t) { },
                      expression: 'userAnswer',
                    },
                  },
                  e._l(e.optionList, function (e) {
                    return t('ne-checkbox-button', {
                      key: e.id,
                      attrs: { label: e },
                    })
                  }),
                  1
                )
                : e._e(),
              5 === e.quesTypeId
                ? t(
                  'ne-radio-group',
                  {
                    staticClass: 'courseware-options courseware-options--tf',
                    on: { change: e.handleChange },
                    model: {
                      value: e.userAnswer,
                      callback: function (t) { },
                      expression: 'userAnswer',
                    },
                  },
                  [
                    t('ne-radio-button', { attrs: { label: 'T' } }, [
                      e._v(
                        ' ' +
                        e._s(
                          e.$t(
                            'classroom.interactions.coursewareBoard.true'
                          )
                        ) +
                        ' '
                      ),
                    ]),
                    t('ne-radio-button', { attrs: { label: 'F' } }, [
                      e._v(
                        ' ' +
                        e._s(
                          e.$t(
                            'classroom.interactions.coursewareBoard.false'
                          )
                        ) +
                        ' '
                      ),
                    ]),
                  ],
                  1
                )
                : e._e(),
            ],
            1
          )
        },
        L = [],
        P =
          (s('a9e3'),
          {
            name: 'QuestionOption',
            props: {
              optionList: {
                type: Array,
                default: function () {
                  return []
                },
              },
              quesTypeId: {
                type: Number,
                default: 0,
              },
            },
            data: function () {
              return { userAnswer: [] }
            },
            methods: {
              handleChange: function (e) {
                console.info(
                  '对象函数 handleChange(val)',
                  e,
                  'filePath:renderer/components/Classroom/CommonInteractions/coursewareBoard/components/question-option.vue'
                )
                this.$emit('change', e)
              },
            },
          }),
        D = P,
        Q = Object(A.a)(D, S, L, false, null, null, null),
        E = Q.exports,
        M = function () {
          var e = this,
            t = e._self._c
          return t(
            'div',
            { staticClass: 'answer-box' },
            [
              5 === e.quesTypeId
                ? [
                  e.theUserAnswer && e.theUserAnswer !== e.theQuesAnswer
                    ? t('div', { staticClass: 'my-answer-box' }, [
                      t('p', [
                        e._v(
                          e._s(
                            e.$t(
                              'classroom.interactions.coursewareBoard.yourAnswer'
                            )
                          )
                        ),
                      ]),
                      t(
                        'span',
                        [
                          [
                            e._v(
                              e._s(
                                'T' === e.theUserAnswer
                                  ? e.$t(
                                    'classroom.interactions.coursewareBoard.true'
                                  )
                                  : e.$t(
                                    'classroom.interactions.coursewareBoard.false'
                                  )
                              )
                            ),
                          ],
                        ],
                        2
                      ),
                    ])
                    : e._e(),
                  t('div', { staticClass: 'right-answer-box' }, [
                    t('p', [
                      e._v(
                        e._s(
                          e.$t(
                            'classroom.interactions.coursewareBoard.rightAnswer'
                          )
                        )
                      ),
                    ]),
                    t(
                      'span',
                      [
                        [
                          e._v(
                            e._s(
                              'T' === e.theQuesAnswer
                                ? e.$t(
                                  'classroom.interactions.coursewareBoard.true'
                                )
                                : e.$t(
                                  'classroom.interactions.coursewareBoard.false'
                                )
                            )
                          ),
                        ],
                      ],
                      2
                    ),
                  ]),
                ]
                : [
                  e.theUserAnswer && e.theUserAnswer !== e.theQuesAnswer
                    ? t('div', { staticClass: 'my-answer-box' }, [
                      t('p', [
                        e._v(
                          e._s(
                            e.$t(
                              'classroom.interactions.coursewareBoard.yourAnswer'
                            )
                          )
                        ),
                      ]),
                      t(
                        'span',
                        [
                          e._l(e.userAnswer, function (t) {
                            return [e._v(e._s(t[0]))]
                          }),
                        ],
                        2
                      ),
                    ])
                    : e._e(),
                  t('div', { staticClass: 'right-answer-box' }, [
                    t('p', [
                      e._v(
                        e._s(
                          e.$t(
                            'classroom.interactions.coursewareBoard.correctAnswer'
                          )
                        )
                      ),
                    ]),
                    t(
                      'span',
                      [
                        e._l(e.quesAnswer, function (t) {
                          return [e._v(e._s(t[0]))]
                        }),
                      ],
                      2
                    ),
                  ]),
                ],
            ],
            2
          )
        },
        N = [],
        U = {
          name: 'QuestionJudge',
          props: {
            quesTypeId: {
              type: Number,
              default: 0,
            },
            userAnswer: {
              type: Array,
              default: function () {
                return []
              },
            },
            quesAnswer: {
              type: Array,
              default: function () {
                return []
              },
            },
          },
          computed: {
            theUserAnswer: function () {
              return (
                console.info(
                  '对象函数 theUserAnswer,filePath:renderer/components/Classroom/CommonInteractions/coursewareBoard/components/question-judge.vue'
                ),
                Object(f.a)(new Set(this.userAnswer)).sort().toString()
              )
            },
            theQuesAnswer: function () {
              return (
                console.info(
                  '对象函数 theQuesAnswer,filePath:renderer/components/Classroom/CommonInteractions/coursewareBoard/components/question-judge.vue'
                ),
                Object(f.a)(new Set(this.quesAnswer)).sort().toString()
              )
            },
          },
        },
        R = U,
        J = Object(A.a)(R, M, N, false, null, null, null),
        V = J.exports,
        F = s('c02a'),
        H = {
          props: {
            options: {
              type: Object,
              default: function () {
                return {}
              },
            },
          },
          data: function () {
            return {
              quesAnswer: [],
              optionList: [],
              quesTypeId: null,
              clickDisabled: false,
              btnDisabled: true,
              userAnswer: [],
              isExpanded: false,
              isSubmit: false,
              isExceptionStatus: false,
              countdownOptions: null,
              visible: false,
            }
          },
          components: {
            QuestionOption: E,
            QuestionJudge: V,
          },
          created: function () {
            var e = this
            return Object(p.a)(
              Object(m.a)().mark(function t() {
                return Object(m.a)().wrap(function (t) {
                  while (1) {
                    switch ((t.prev = t.next)) {
                      case 0:
                        e.initEventListener(),
                          (e.coursewareBoard = new $(
                            Object(o.a)({}, e.options)
                          )),
                          e.$nextTick(function () {
                            var t = e.coursewareBoard.quesInfo
                            e.sendLogger({
                              msg: '收到互动',
                              stage: 'start',
                              response: t,
                            })
                            e.coursewareBoard.interactReport()
                            var s = e.questionStatus()
                            e.sendLogger({
                              msg: '上报结果'.concat(JSON.stringify(s)),
                              stage: '开始互动上报',
                            })
                            e.sendLogger({
                              msg: '互动倒计时'.concat(e.countdownOptions),
                              stage: '开始互动倒计时',
                            })
                          })
                      case 3:
                      case 'end':
                        return t.stop()
                    }
                  }
                }, t)
              })
            )()
          },
          computed: {
            iconClass: function () {
              return (
                console.info(
                  '对象函数 iconClass,filePath:renderer/components/Classroom/CommonInteractions/coursewareBoard/app.vue'
                ),
                this.isExpanded
                  ? 'ne-icon-courseware-arrow ne-icon-courseware-up'
                  : 'ne-icon-courseware-arrow'
              )
            },
          },
          methods: {
            initEventListener: function () {
              var e = this
              console.info(
                '对象函数 initEventListener,filePath:renderer/components/Classroom/CommonInteractions/coursewareBoard/app.vue'
              )
              this.$bus.$emit('initClose')
              this.$bus.$on('closeContinusCorrect', function (t) {
                console.info(
                  '箭头函数 监听 closeContinusCorrect(data)',
                  t,
                  'filePath:renderer/components/Classroom/CommonInteractions/coursewareBoard/app.vue'
                )
                t && e.closeBoard()
              })
            },
            upodateUserAnswer: function (e) {
              console.info(
                '对象函数 upodateUserAnswer(val)',
                e,
                'filePath:renderer/components/Classroom/CommonInteractions/coursewareBoard/app.vue'
              )
              this.sendLogger({
                msg: '学生答案',
                stage: 'start',
                params: { val: e },
              })
              this.$refs.interactKeyTone.play()
              this.userAnswer = e
            },
            closeBoard: function () {
              var e = this
              console.info(
                '对象函数 closeBoard,filePath:renderer/components/Classroom/CommonInteractions/coursewareBoard/app.vue'
              )
              this.isExpanded = true
              this.$refs.coursewareBoardBlock &&
                this.$refs.coursewareBoardBlock.addEventListener(
                  'transitionend',
                  function () {
                    console.info(
                      '箭头函数 监听 transitionend,filePath:renderer/components/Classroom/CommonInteractions/coursewareBoard/app.vue'
                    )
                    e.destroy()
                  },
                  false
                )
            },
            questionStatus: function () {
              var e = this
              return Object(p.a)(
                Object(m.a)().mark(function t() {
                  var s, n, o
                  return Object(m.a)().wrap(function (t) {
                    while (1) {
                      switch ((t.prev = t.next)) {
                        case 0:
                          return (
                            console.info(
                              '对象函数 questionStatus,filePath:renderer/components/Classroom/CommonInteractions/coursewareBoard/app.vue'
                            ),
                            (t.next = 3),
                            e.coursewareBoard
                              .questionStatus()
                              .catch(function (t) {
                                return (
                                  console.info(
                                    '箭头函数 catch(err)',
                                    t,
                                    'filePath:renderer/components/Classroom/CommonInteractions/coursewareBoard/app.vue'
                                  ),
                                  e.sendLogger(
                                    {
                                      msg: '接口报错:异常恢复:',
                                      response: t,
                                    },
                                    'error'
                                  ),
                                  t || {}
                                )
                              })
                          )
                        case 3:
                          ; (s = t.sent),
                            (n = s.code),
                            (o = s.data),
                            0 === n &&
                            (o.userAnswer
                              ? ((e.isSubmit = true),
                                (e.isExceptionStatus = true),
                                (e.userAnswer = o.userAnswer))
                              : (e.visible = true))
                        case 7:
                        case 'end':
                          return t.stop()
                      }
                    }
                  }, t)
                })
              )()
            },
            submitAnswer: function (e) {
              var t = this
              return Object(p.a)(
                Object(m.a)().mark(function s() {
                  var n, o, r, a, i, c, u, l
                  return Object(m.a)().wrap(function (s) {
                    while (1) {
                      switch ((s.prev = s.next)) {
                        case 0:
                          if (
                            (console.info(
                              '对象函数 submitAnswer(e)',
                              e,
                              'filePath:renderer/components/Classroom/CommonInteractions/coursewareBoard/app.vue'
                            ),
                              !t.clickDisabled)
                          ) {
                            s.next = 4
                            break
                          }
                          return (
                            console.info(
                              'if(_this5.clickDisabled)为true触发return,path: /renderer/components/Classroom/CommonInteractions/coursewareBoard/app.vue'
                            ),
                            s.abrupt('return')
                          )
                        case 4:
                          return (
                            (t.btnDisabled = true),
                            (t.clickDisabled = true),
                            t.$refs.interactSubmit &&
                            t.$refs.interactSubmit.play(),
                            (s.next = 9),
                            t.coursewareBoard.submitAnswer(t.userAnswer)
                          )
                        case 9:
                          return (
                            (a = s.sent),
                            (i = a.isSubmit),
                            (c = a.isRight),
                            (u = a.params),
                            (l = a.response),
                            (t.isSubmit = i),
                            (t.clickDisabled = false),
                            t.sendLogger({
                              msg: '提交答案结果',
                              params: u,
                              response: l,
                            }),
                            (s.next = 19),
                            t.$nextTick()
                          )
                        case 19:
                          1 === c
                            ? null === (n = t.$refs.interactSuccess) ||
                            void 0 === n ||
                            n.play()
                            : null === (o = t.$refs.interactFail) ||
                            void 0 === o ||
                            o.play(),
                            F.f(
                              null === (r = t.options) || void 0 === r
                                ? void 0
                                : r.ircMsg,
                              t.quesTypeId,
                              c
                            )
                        case 21:
                        case 'end':
                          return s.stop()
                      }
                    }
                  }, s)
                })
              )()
            },
            countdownComplete: function () {
              console.info(
                '对象函数 countdownComplete,filePath:renderer/components/Classroom/CommonInteractions/coursewareBoard/app.vue'
              )
              this.sendLogger({
                msg: '倒计时结束自动提交答案结果',
                stage: 'submit',
              })
              !this.isSubmit && this.submitAnswer()
            },
            destroyInteraction: function (e) {
              console.info(
                '对象函数 destroyInteraction(msg)',
                e,
                'filePath:renderer/components/Classroom/CommonInteractions/coursewareBoard/app.vue'
              )
              e.isNeedSubmit
                ? (this.sendLogger({
                  msg: '主讲关闭自动提交答案结果',
                  stage: 'submit',
                }),
                  !this.isSubmit && this.submitAnswer())
                : this.destroy()
            },
            autoCloseBoard: function (e) {
              var t = this
              console.info(
                '对象函数 autoCloseBoard(timer)',
                e,
                'filePath:renderer/components/Classroom/CommonInteractions/coursewareBoard/app.vue'
              )
              var s = setTimeout(function () {
                t.closeBoard()
                clearTimeout(s)
                s = null
              }, e)
            },
            sendLogger: function (e) {
              var t = e.msg,
                s = void 0 === t ? '' : t,
                n = e.stage,
                o = void 0 === n ? '' : n,
                r = e.params,
                a = void 0 === r ? {} : r,
                i = e.response,
                c = void 0 === i ? {} : i,
                u =
                  arguments.length > 1 && void 0 !== arguments[1]
                    ? arguments[1]
                    : 'info'
              T.a.send({
                tag: 'student.Interact',
                content: {
                  msg: s,
                  interactType: l[this.quesTypeId],
                  interactId: this.options.ircMsg.interactId,
                  interactStage: o,
                  params: JSON.stringify(a),
                  response: JSON.stringify(c),
                },
                level: u,
              })
            },
            destroy: function () {
              var e, t
              console.info(
                '对象函数 destroy,filePath:renderer/components/Classroom/CommonInteractions/coursewareBoard/app.vue'
              )
              this.$bus.$off('closeContinusCorrect')
              this.sendLogger({
                msg: '结束互动',
                stage: 'end',
              })
              this.$destroy()
              this.coursewareBoard.closeToast()
              null === (e = this.$el) ||
                void 0 === e ||
                null === (t = e.parentNode) ||
                void 0 === t ||
                t.removeChild(this.$el)
            },
          },
          watch: {
            userAnswer: function (e) {
              console.info(
                '对象函数 userAnswer(val)',
                e,
                'filePath:renderer/components/Classroom/CommonInteractions/coursewareBoard/app.vue'
              )
              e.length > 0
                ? (this.btnDisabled = false)
                : (this.btnDisabled = true)
            },
          },
        },
        K = H,
        z = (s('4773'), Object(A.a)(K, l, d, false, null, null, null)),
        G = z.exports,
        W = (function (e) {
          Object(i.a)(s, e)
          var t = Object(c.a)(s)
          function s() {
            var e,
              n =
                arguments.length > 0 && void 0 !== arguments[0]
                  ? arguments[0]
                  : {}
            return (
              console.info(
                '函数申明 CoursewareBoard(opts)',
                n,
                'filePath:renderer/components/Classroom/CommonInteractions/coursewareBoard/index.js'
              ),
              Object(r.a)(this, s),
              (e = t.call(this, G)),
              (e.options = n),
              (e.dom = n.roomMessage.roomInfo.interactionController),
              e.initVmApp('h5课件互动题'),
              e
            )
          }
          return (
            Object(a.a)(s, [
              {
                key: 'createPropsData',
                value: function () {
                  var e = {
                    isExpanded: !e.isExpanded,
                    next: 14,
                    userAnswer: t,
                    userAnswer: t,
                    userAnswer: t,
                    optionList: t.quesOptions,
                    quesAnswer: t.quesAnswer,
                    quesTypeId: t.quesTypeId,
                    countdownOptions: e.coursewareBoard.initCountdown(),
                  }
                  return Object(o.a)({ options: this.options }, e)
                },
              },
            ]),
            s
          )
        })(u.a)
    },
    afc3: function (e, t, s) {
      e.exports = s.p + 'static/media/interact-submit.83bed748.mp3'
    },
    b0ec: function (e, t, s) {
      e.exports = s.p + 'static/media/interact-success.bd430e73.mp3'
    },
    b6c9: function (e, t, s) {
      'use strict'
      s.d(t, 'a', function () {
        return u
      })
      var n = s('d4ec'),
        o = s('bee2'),
        r = (s('99af'), s('d9e2'), s('8bbf')),
        a = s.n(r),
        i = s('3898'),
        c = s('d0db'),
        u = (function () {
          function e(t) {
            console.info(
              '函数申明 InteractionBase(app)',
              t,
              'filePath:renderer/components/Classroom/CommonInteractions/interaction-base.js'
            )
            Object(n.a)(this, e)
            this.app = t
            this.vm = null
            this.keepOtherDom = false
          }
          return (
            Object(o.a)(e, [
              {
                key: 'initVmApp',
                value: function (e) {
                  if (!this.dom) {
                    throw Error('互动的dom容器不存在')
                  }
                  this.dom.children.length > 0 &&
                    !this.keepOtherDom &&
                    (c.a.send({
                      tag: 'tempInteractionTest',
                      content: {
                        msg: '清空互动容器\uFF0C由'
                          .concat(e, '触发清空\uFF0C清空')
                          .concat(this.dom.children[0].className),
                      },
                    }),
                      (this.dom.innerHTML = ''))
                  this.vm = this.initVm(this.app)
                  this.render(this.dom, this.vm)
                },
              },
              {
                key: 'initVm',
                value: function (e) {
                  var t = a.a.extend(e),
                    s = this.createPropsData(),
                    n = new t({
                      i18n: i.b,
                      propsData: s,
                      store: this.store || {},
                    })
                  return n.$mount(), n
                },
              },
              {
                key: 'render',
                value: function (e, t) {
                  e.appendChild(t.$el)
                },
              },
              {
                key: 'destroy',
                value: function () {
                  var e =
                    arguments.length > 0 && void 0 !== arguments[0]
                      ? arguments[0]
                      : {},
                    t = e.submit
                  this.vm
                    ? (t && this.vm.submit(),
                      this.vm.$destroy(),
                      (this.dom.innerHTML = ''),
                      (this.vm = null),
                      (this.app = null))
                    : console.info(
                      'if(!this.vm)为true触发return,path: /renderer/components/Classroom/CommonInteractions/interaction-base.js'
                    )
                },
              },
              {
                key: 'getProperties',
                value: function (e, t) {
                  return e[''.concat(t)].properties
                },
              },
              {
                key: 'handleMsg',
                value: function () { },
              },
            ]),
            e
          )
        })()
    },
    bc2e: function (e, t, s) {
      e.exports = s.p + 'static/media/get-coins.71310f30.mp3'
    },
    e32e: function (e, t, s) {
      e.exports = s.p + 'static/media/interact-key-tone.631f9373.mp3'
    },
  },
])
