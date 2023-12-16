; (window.webpackJsonp = window.webpackJsonp || []).push([
  ['chunk-0c3f1dd4'],
  {
    '05e9': function (e, t, n) {
      'use strict'
      n('e0e9')
    },
    '6e9a7': function (e, t, n) {
      'use strict'
      n.r(t)
      n.d(t, 'default', function () {
        return w
      })
      var o = n('5530'),
        s = n('d4ec'),
        a = n('bee2'),
        i = n('262e'),
        l = n('2caf'),
        r = n('b6c9'),
        d = n('b7b5'),
        c = function () {
          var e = this,
            t = e._self._c
          return t('div', { attrs: { id: 'wallRandomCall' } }, [
            t('audio', {
              ref: 'wallBg',
              staticClass: 'hidden',
              attrs: { src: n('99a2') },
            }),
            t('audio', {
              ref: 'wallSpinner1',
              staticClass: 'hidden',
              attrs: { src: n('a22d') },
            }),
            t('audio', {
              ref: 'wallSpinner2',
              staticClass: 'hidden',
              attrs: { src: n('db85') },
            }),
            t('audio', {
              ref: 'wallSelected',
              staticClass: 'hidden',
              attrs: { src: n('c6df') },
            }),
            e.animationStatus
              ? t('div', { staticClass: 'wallBackground' }, [
                t('div', {
                  class: ['wallTitle', e.titleClassName],
                }),
                t(
                  'div',
                  { staticClass: 'wallContent' },
                  e._l(e.studentsInfo, function (n) {
                    return t(
                      'div',
                      {
                        key: n.userId,
                        class: [
                          'wallVideoOutBorder',
                          e.selectStutId == n.userId ? 'selectBorder' : '',
                        ],
                      },
                      [
                        t('div', { staticClass: 'wallVideoBox' }, [
                          t('div', {
                            directives: [
                              {
                                name: 'show',
                                rawName: 'v-show',
                                value: e.showVideo(n),
                                expression: 'showVideo(item)',
                              },
                            ],
                            staticClass: 'video-wrapper',
                            attrs: { id: 'wall-video-' + n.userId },
                          }),
                          t('div', { staticClass: 'avatar-wrapper' }, [
                            t('img', {
                              attrs: {
                                src: n.avatar ? n.avatar : e.defaultAvatar,
                              },
                            }),
                            t('span', { staticClass: 'student-name' }, [
                              e._v(e._s(n.stuName)),
                            ]),
                          ]),
                        ]),
                      ]
                    )
                  }),
                  0
                ),
              ])
              : t('div', { staticClass: 'selectBackground' }, [
                t('div', {
                  staticClass: 'close',
                  on: { click: e.clickClose },
                }),
                t('div', {
                  class: ['wallTitle', e.titleClassName],
                }),
                t('div', { staticClass: 'selectVideoBox' }, [
                  t('div', {
                    directives: [
                      {
                        name: 'show',
                        rawName: 'v-show',
                        value: e.showVideo(e.selectInfo),
                        expression: 'showVideo(selectInfo)',
                      },
                    ],
                    staticClass: 'video-wrapper',
                    attrs: { id: 'select-video-' + e.selectInfo.userId },
                  }),
                  t('div', { staticClass: 'avatar-wrapper' }, [
                    t('img', {
                      attrs: {
                        src: e.selectInfo.avatar
                          ? e.selectInfo.avatar
                          : e.defaultAvatar,
                      },
                    }),
                  ]),
                  t('div', { staticClass: 'stuInfoBox' }, [
                    0 != e.selectInfo.level
                      ? t('div', { staticClass: 'stuLevel' }, [
                        t('span', { staticClass: 'levelBox' }, [
                          t('i', {
                            class: ['levelIcon', e.level],
                          }),
                        ]),
                      ])
                      : e._e(),
                    t('div', { staticClass: 'stuName' }, [
                      t('span', { staticClass: 'leftBg' }),
                      t('span', { staticClass: 'nameBg word-ellipsis' }, [
                        e._v(e._s(e.selectInfo.stuName)),
                      ]),
                      t('span', { staticClass: 'rightBg' }),
                    ]),
                  ]),
                ]),
              ]),
          ])
        },
        u = [],
        m =
          (n('14d9'),
            n('7db0'),
            n('d3b7'),
            n('e260'),
            n('6062'),
            n('3ca3'),
            n('ddb0'),
            n('d81d'),
            n('4de4'),
            n('a9e3'),
            n('159b'),
            n('b680'),
            n('d0db')),
        f = n('702a'),
        h = {
          name: 'WallRandomCall',
          props: {
            options: {
              type: Object,
              default: function () { },
            },
            studentList: {
              type: Array,
              default: function () {
                return []
              },
            },
          },
          data: function () {
            return {
              local: '',
              stuId: this.options.roomMessage.roomInfo.stuInfo.id,
              studentsInfo: [],
              randomStuIdList: [],
              selectStutId: 0,
              randomCount: 16,
              currentRandomCount: 0,
              animationStatus: true,
              defaultAvatar: f,
              animationTimer: null,
            }
          },
          computed: {
            titleClassName: function () {
              return (
                console.info(
                  '对象函数 titleClassName,filePath:renderer/components/Classroom/CommonInteractions/randomCall/wall.vue'
                ),
                'hk' == this.local ? 'title_zh' : 'title_en'
              )
            },
            ircStudentList: function () {
              return (
                console.info(
                  '对象函数 ircStudentList,filePath:renderer/components/Classroom/CommonInteractions/randomCall/wall.vue'
                ),
                this.options.ircMsg.students
              )
            },
            selectedStuId: function () {
              return (
                console.info(
                  '对象函数 selectedStuId,filePath:renderer/components/Classroom/CommonInteractions/randomCall/wall.vue'
                ),
                this.options.ircMsg.selected.userId
              )
            },
            selectInfo: function () {
              var e = this
              return (
                console.info(
                  '对象函数 selectInfo,filePath:renderer/components/Classroom/CommonInteractions/randomCall/wall.vue'
                ),
                this.studentList.find(function (t) {
                  return t.userId == e.options.ircMsg.selected.userId
                })
              )
            },
            level: function () {
              return (
                console.info(
                  '对象函数 level,filePath:renderer/components/Classroom/CommonInteractions/randomCall/wall.vue'
                ),
                'level_'.concat(this.selectInfo.level)
              )
            },
          },
          created: function () {
            this.local = window.localStorage.getItem('local')
            this.thinkClass.RtcService.on(
              'studentVideoStart',
              this.creatStudentVideo
            )
          },
          mounted: function () {
            this.$bus.$emit('wallRandomCall', { pub: true })
            this.sendLogger('开启照片墙随机点名互动')
            this.initFullPageStyle()
            this.$refs.wallBg.play()
            this.initVideo()
          },
          methods: {
            creatStudentVideo: function (e) {
              var t = this
              console.info(
                '对象函数 creatStudentVideo(uid)',
                e,
                'filePath:renderer/components/Classroom/CommonInteractions/randomCall/wall.vue'
              )
              var n = this.studentsInfo.find(function (t) {
                return t.userId == e
              }),
                o = ''
              n &&
                (this.animationStatus
                  ? (o = 'wall-video-'.concat(n.userId))
                  : n.userId == this.selectedStuId &&
                  (o = 'select-video-'.concat(n.userId)))
              document.getElementById(o) &&
                this.$nextTick(function () {
                  t.thinkClass.RtcService.createRemoteVideo(e, o)
                })
            },
            showVideo: function (e) {
              return (
                console.info(
                  '对象函数 showVideo(item)',
                  e,
                  'filePath:renderer/components/Classroom/CommonInteractions/randomCall/wall.vue'
                ),
                e.isSelf
                  ? (console.info(
                    'if(item.isSelf)为true触发return,path: /renderer/components/Classroom/CommonInteractions/randomCall/wall.vue'
                  ),
                    e.displayVideo && !e.multVideoLinkStatus)
                  : (console.info(
                    'if(item.isSelf)为false,触发return,path: /renderer/components/Classroom/CommonInteractions/randomCall/wall.vue'
                  ),
                    e.displayVideo &&
                    !e.mutedVideoStatus &&
                    !e.multVideoLinkStatus &&
                    e.inClass)
              )
            },
            initFullPageStyle: function () {
              console.info(
                '对象函数 initFullPageStyle,filePath:renderer/components/Classroom/CommonInteractions/randomCall/wall.vue'
              )
              document.getElementById('interactionFullPage').style.height =
                '100%'
            },
            initVideo: function () {
              var e = this
              console.info(
                '对象函数 initVideo,filePath:renderer/components/Classroom/CommonInteractions/randomCall/wall.vue'
              )
              var t = new Set(
                this.ircStudentList.map(function (e) {
                  return e.userId
                })
              )
              this.studentsInfo = this.studentList.filter(function (e) {
                return t.has(Number(e.userId))
              })
              this.initRandomList()
              this.$nextTick(function () {
                e.studentsInfo.forEach(function (t) {
                  var n = 'wall-video-'.concat(t.userId)
                  e.createVideo(t, n)
                })
              })
            },
            initRandomList: function () {
              console.info(
                '对象函数 initRandomList,filePath:renderer/components/Classroom/CommonInteractions/randomCall/wall.vue'
              )
              for (var e = 0; e < this.randomCount; e++) {
                var t = this.getRandomIndex(),
                  n = this.studentsInfo[t].userId
                if (e > 0) {
                  var o = this.randomStuIdList[e - 1]
                  this.reRandom(o, n)
                } else {
                  this.randomStuIdList.push(this.selectedStuId)
                }
              }
              this.randomStuIdList.reverse()
              this.beginAnimation()
            },
            reRandom: function (e, t) {
              if (
                (console.info(
                  '对象函数 reRandom(lastRandomId, currentRandomId)',
                  e,
                  t,
                  'filePath:renderer/components/Classroom/CommonInteractions/randomCall/wall.vue'
                ),
                  e == t)
              ) {
                var n = this.getRandomIndex(),
                  o = this.studentsInfo[n].userId
                this.reRandom(e, o)
              } else {
                this.randomStuIdList.push(t)
              }
            },
            getRandomIndex: function () {
              return (
                console.info(
                  '对象函数 getRandomIndex,filePath:renderer/components/Classroom/CommonInteractions/randomCall/wall.vue'
                ),
                Math.ceil(Math.random() * this.studentsInfo.length) - 1
              )
            },
            beginAnimation: function () {
              console.info(
                '对象函数 beginAnimation,filePath:renderer/components/Classroom/CommonInteractions/randomCall/wall.vue'
              )
              this.selectStutId = this.randomStuIdList[0]
              this.$refs.wallSpinner1.play()
              this.animations()
            },
            animations: function () {
              var e = this
              console.info(
                '对象函数 animations,filePath:renderer/components/Classroom/CommonInteractions/randomCall/wall.vue'
              )
              this.currentRandomCount += 1
              var t = (
                Math.pow(this.currentRandomCount - 1, 3) / 6 +
                100
              ).toFixed(2)
              this.currentRandomCount == this.randomCount
                ? (this.animationTimer = setTimeout(function () {
                  e.destroyedTimer()
                  e.$refs.wallSelected.play()
                  e.$nextTick(function () {
                    var t = 'select-video-'.concat(e.selectInfo.userId)
                    e.createVideo(e.selectInfo, t)
                  })
                }, t))
                : (this.animationTimer = setTimeout(function () {
                  e.destroyedTimer()
                  var t =
                    e.currentRandomCount % 2 == 0
                      ? 'wallSpinner1'
                      : 'wallSpinner2'
                  e.$refs[t].play()
                  e.currentRandomCount < e.randomCount && e.animations()
                }, t))
            },
            destroyedTimer: function () {
              console.info(
                '对象函数 destroyedTimer,filePath:renderer/components/Classroom/CommonInteractions/randomCall/wall.vue'
              )
              this.animationTimer &&
                (clearTimeout(this.animationTimer),
                  (this.animationTimer = null))
            },
            createVideo: function (e, t) {
              console.info(
                '对象函数 createVideo(stuInfo, videoId)',
                e,
                t,
                'filePath:renderer/components/Classroom/CommonInteractions/randomCall/wall.vue'
              )
              e.userId == this.stuId
                ? this.thinkClass.RtcService.createLocalVideo(t)
                : this.thinkClass.RtcService.createRemoteVideo(e.userId, t)
            },
            clickClose: function () {
              console.info(
                '对象函数 clickClose,filePath:renderer/components/Classroom/CommonInteractions/randomCall/wall.vue'
              )
              this.destroyInteraction()
              this.$bus.$emit('wallRandomCall', { pub: false })
            },
            destroyInteraction: function () {
              console.info(
                '对象函数 destroyInteraction,filePath:renderer/components/Classroom/CommonInteractions/randomCall/wall.vue'
              )
              this.$el &&
                this.$el.parentNode &&
                (this.sendLogger('关闭照片墙随机点名互动'),
                  this.$el.parentNode.removeChild(this.$el),
                  this.$destroy())
            },
            sendLogger: function (e) {
              var t =
                arguments.length > 1 && void 0 !== arguments[1]
                  ? arguments[1]
                  : ''
              m.a.send({
                tag: 'student.Interact',
                content: {
                  msg: e,
                  interactType: 'wallRandomCall',
                  interactId: this.options.ircMsg.interactId,
                  interactStage: t,
                },
              })
            },
          },
          beforeDestroy: function () {
            console.info(
              '对象函数 beforeDestroy,filePath:renderer/components/Classroom/CommonInteractions/randomCall/wall.vue'
            )
            this.destroyedTimer()
            this.thinkClass.RtcService.off(
              'studentVideoStart',
              this.creatStudentVideo
            )
            document.getElementById('interactionFullPage').style.height = 'auto'
          },
        },
        v = h,
        C = (n('05e9'), n('2877')),
        p = Object(C.a)(v, c, u, false, null, null, null),
        I = p.exports,
        w = (function (e) {
          Object(i.a)(n, e)
          var t = Object(l.a)(n)
          function n() {
            var e,
              a =
                arguments.length > 0 && void 0 !== arguments[0]
                  ? arguments[0]
                  : {},
              i =
                arguments.length > 1 && void 0 !== arguments[1]
                  ? arguments[1]
                  : {}
            console.info(
              '函数申明 smallRandomCall(opts, store)',
              a,
              i,
              'filePath:renderer/components/Classroom/CommonInteractions/randomCall/smallRandomCallIndex.js'
            )
            Object(s.a)(this, n)
            var l = 'wheel' == a.ircMsg.type ? d.a : I
            return (
              (e = t.call(this, l)),
              (e.dom =
                'wheel' == a.ircMsg.type
                  ? a.roomMessage.roomInfo.interactionController
                  : a.roomMessage.roomInfo.interactionFullPage),
              (e.options = a),
              (e.store = i),
              i.dispatch('smallClass/updateStudentList', {
                uid: a.ircMsg.selected.userId,
                data: Object(o.a)(
                  Object(o.a)({}, a.ircMsg.selected),
                  {},
                  { stuName: a.ircMsg.selected.nickName }
                ),
              }),
              (e.studentList = i.state.smallClass.studentList),
              (e.keepOtherDom = a.keepOtherDom),
              e.initVmApp('小班随机点名'),
              e
            )
          }
          return (
            Object(a.a)(n, [
              {
                key: 'createPropsData',
                value: function () {
                  var e = {
                    animationStatus: false,
                    selectStutId: e.randomStuIdList[e.currentRandomCount],
                  }
                  return Object(o.a)(
                    {
                      msgType: 'small_random_call',
                      options: this.options,
                      studentList: this.studentList,
                    },
                    e
                  )
                },
              },
            ]),
            n
          )
        })(r.a)
    },
    '702a': function (e, t) {
      e.exports =
        'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEwAAABMCAMAAADwSaEZAAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAAJkUExURUdwTP/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////GJP/AH7a9yLrBzL7Ez/88dP+4GP+UHbO6xv+2Ff+yEf2EIv+aHP/DIf+MH6Oruv/MKTOT//+QH/84ZP87bv81WrC3w//PLf6rDf83X/86aiyG/8LJ0v+oB/+kAvUpRPb4+v+9HDie//+tDv/JKP/rz/9Cif+7Gv/ovv8+ef86Z/wxU0Kx/z+q/zGN/0zE///UMEi9//8+fTym///9+P/m6zui/yh//zaa/52ltfRNSf/ROUnA//9Ag07K//+fHK21wlLQ/wZw39zf5fgsSy6K/6/h/wZf1RLuhSV4//+vEEW3/yKV6v97pP9/sf+JIEO1//93lQRX0jWX/6iwviFkywZp2//YObLo/7Xv/4mTpv/176uzwP2MPSec9f/02z+t/wZk2P/78gnrx//Pcf/69hbvbf62Jf19JP+ePf/H2Ea6/5Gbrg/unU+T/v/Zl5ags8nR0/6UPOn3/1TX/wvut4GVuefp7SmE/P/HUpTQOgh24f/pxD3jbAbr1keFyv/HnNXZ3/9QaE2M///q8f+NvPdAUP/12f/crP/j5mWw///DhP/o4EHkTpze/w3tq/7hyNfs//+zWiJx0v+vNv+tzwbp3wh84zbhpUib/xrvWDjjg0qP+/9sodHV3f2VTgTp64nF///DMv9ak4u12/2jaGrX/7PBNP+hFoHh/2zbQP9iejbhkyp3DfwAAAAedFJOUwAf/u8w6ZH6fbWrPgjfwY88LDYOBtlQZuXL09H3zUp3JrYAAAU1SURBVFjDrdj5WxNHGAfwJZKQAOE+AsQViBQol5yJSEkUQQhBhQhGoUqNciRgEawWUDHIaSlQqgJaTxSVKqi9aO1FL3v8U52Z7ALZmdkkPnl/8lk2H79z7O7MMIxYBQfFhioSlNIAtVSZoAiNDQpm3rIi5CFqVlDqEHmE95KfPJqlVLTczyvKP1DCipQk0N9zSiFKIU7hGRcpC2A9qABZpHsrRsV6WKoYN1SUTMJ6XBJZlOgYxrFeVZzIuIarWC9LFU6zwrawXteWMIqlFvmRo2/vvsmluT7sD2qiFk7M5bh06/HklbmREe17sPYRshFa6of3l+PK3JqhIi0tPT29fY9WW0LGWBU2ClGEcVzMzDQYKipSgNYOtJISMsbGCWeIjCViiYmGipQUEA5oe4BGxFiZYN6T5uriNldNS8MkLs9CJHGCLW6DmoHXQLdRMFYV6aaRACsrE2glFGxzQ/1J74mhhZWyzVp6u5aOBWy8kRSufxnv6vr3/v1H1iNFAOO1tPl/5uf/mn4xoydqivVggt7vKgBltJYeOeDUEqGW/uz74eFhe1tDzerTp78+PyUwJXy0QMH/0lWl0xUYjQDLycnhtIr2Z8PDrRP2huKamu7d9fWmU4IfBXJzXzgtOqqqdAUFKFlRDpctRftFa+sEwnYc3m0aGBBiEudzIBe2vysfaiDZuaJ1bQRgE8vL9pMomKn6QyHGyhGGfdM68ncCDWIHjjq1TEPKmx+Wl68NXkTB6khYNPrWYiPTsR1ougIrwEBDwSCUwWT/XRscvH0RBFutNw3YbBjGRpBaCTCkWR+dO8rV2trIyHeDt7/5pZsLZjuIY7CdIThWWZmfD7DS0lLrE7PZPDRk1jscr9vaZmdPOnus+mDjeexnIWBtgr9fO2uhtjPPaLVan/AX9Q/a2hqK14MRMHUwE4TP5o6mykrY0Dyd0Xho/eoDYIFgh+vrBmxXG/fjGBvExOIXO5ugth0MaZ7OFavZ0Q3mKwi2/30CFsuEErHaWi7bBvZpQ3ExDGYyVV8lY6HChxxh5eVNAEND6oLBHlt1Bms+T3rY44kY1FA2hJn1oF7PzsLZX2ey2RoB9jH+u3hGiV98CDEuG8KSLVOf9J5tuXz5ow9ufmtHwUiYkpHiFxfGv37Y+eNv5TDaArxQmG2BWAvEbtphjzV/TsCkDP0zbh46ND6O/pVqsfT2nj0DMKDZkUXC1IzagwVFKkp2BmkQa/7z7+czJEzqGTYFk7W8enXnzu8vZii3SUkDQMCgdv36lMWSnT1NvU3JJHiAJfX0ZIPq6T9emJp0j3pbAmnSkrB+ABUmJSUna05Qb1OQHicCBjOlAkujEcFCSQ86Vsn9/YWFqSiXZhcdiyW9gvBkm4KJYEGklyOe7PhGMDoGXo6E1zYJA8GcFh0LIX5QcIwLlqyZPnGDepec+KnDSoN6bNe9G3qxuyKIH2ECpvlJHOI/wh60U683u48vJy9c3qq4hQu2pHKpvqW7j1e+7HOLBVIWey619/Tpd0Fd+PmPu6LB/CnLUJdayc3KAtzo6OgFMUwhvkDmk73Da2LYpgUyZenOYbwmhsncbip4DGqw20T2sJFutztOLCODy/YZvfdj3G/EeAxpYphMuEXcSsPeHANabm5uFhXDtoikzSuPOTUqpvLzdFsNtsNfHctA2hhlyx/uzYZff2ny5RjQyJg6zOujCP2tpbGX3hxF+PaQBIzCVt8d3/j2YMm3R14+Pozz7TGhjw8wfXy06uND303H0fFKqTpAqox3fxz9P7Ff9RoP+8uUAAAAAElFTkSuQmCC'
    },
    '99a2': function (e, t, n) {
      e.exports = n.p + 'static/media/wall_background.b9db467f.mp3'
    },
    a22d: function (e, t, n) {
      e.exports = n.p + 'static/media/wall_spinner1.9da005ed.mp3'
    },
    c6df: function (e, t, n) {
      e.exports = n.p + 'static/media/wall_selected.ef965b4f.mp3'
    },
    db85: function (e, t, n) {
      e.exports = n.p + 'static/media/wall_spinner2.90fae3b9.mp3'
    },
    e0e9: function (e, t, n) { },
  },
])
