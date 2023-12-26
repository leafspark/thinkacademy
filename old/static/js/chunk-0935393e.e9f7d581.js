;(window.webpackJsonp = window.webpackJsonp || []).push([
  ['chunk-0935393e'],
  {
    '1d7d': function (e, t, i) {
      'use strict'
      i('d984')
    },
    '269fb': function (e, t, i) {
      'use strict'
      i.r(t)
      i.d(t, 'default', function () {
        return $
      })
      var o = i('5530'),
        n = i('d4ec'),
        s = i('bee2'),
        a = i('262e'),
        r = i('2caf'),
        l = i('b6c9'),
        u = function () {
          var e = this,
            t = e._self._c
          return t(
            'div',
            e._l(e.data, function (i) {
              return t(
                'div',
                {
                  key: i.userId,
                  staticClass: 'student-item',
                  style: {
                    left:
                      e.diffInfo.w + e.pptratio.width * i.originXRatio + 'px',
                    top:
                      e.diffInfo.h + e.pptratio.height * i.originYRatio + 'px',
                    width: e.pptratio.width * i.WRatio + 'px',
                    height: e.pptratio.height * i.HRatio + 'px',
                  },
                },
                [
                  t('p', { staticClass: 'stu-name word-ellipsis' }, [
                    e._v(' ' + e._s(i.nickName) + ' '),
                  ]),
                  t('div', {
                    directives: [
                      {
                        name: 'show',
                        rawName: 'v-show',
                        value: 1 == i.cameraIsOpen,
                        expression: 'item.cameraIsOpen == 1',
                      },
                    ],
                    staticClass: 'stu-video',
                    attrs: { id: 'mult-video-' + i.userId },
                  }),
                  2 == i.cameraIsOpen
                    ? t('p', { staticClass: 'stu-img' }, [
                        t('img', {
                          attrs: {
                            src: i.avatar,
                            alt: '',
                          },
                        }),
                      ])
                    : e._e(),
                  4 === e.msgType && e.urlMap[i.addCoin] && e.isShowCoins
                    ? t('lottie-player', {
                        staticClass: 'lottie-player',
                        attrs: {
                          autoplay: '',
                          mode: 'normal',
                          src: e.urlMap[i.addCoin],
                        },
                      })
                    : e._e(),
                  i.isAuthorize
                    ? t('div', { staticClass: 'authgraffiti-wrapper' })
                    : e._e(),
                  t(
                    'div',
                    { staticClass: 'microphone-wrapper' },
                    [
                      t('AudioWaves', {
                        attrs: {
                          microphoneStatus:
                            e.stuId === i.userId
                              ? e.microphoneStatus
                              : 1 == i.micIsOpen,
                          microphoneStyle: 'bottleGreen',
                          microphoneHeight: '16',
                          volumeValue: i.volume,
                        },
                      }),
                    ],
                    1
                  ),
                  i.level
                    ? t(
                        'div',
                        { staticClass: 'medal-wrapper' },
                        [
                          i.level > 0
                            ? t('MedalIcon', {
                                attrs: {
                                  type: 'small',
                                  level: i.level,
                                },
                              })
                            : e._e(),
                        ],
                        1
                      )
                    : e._e(),
                  i.emoticonName
                    ? t(
                        'div',
                        { staticClass: 'emoji-wrapper' },
                        [
                          t('EmoticonMessage', {
                            attrs: {
                              willAutoClear: true,
                              name: i.emoticonName,
                              type: i.emoticonType,
                              userId: i.userId,
                              width: 70,
                              height: 70,
                              emojiId: i.emojiId,
                              lottieUrl: i.lottieUrl,
                            },
                            on: { clearEmoticon: e.handleClearEmoticon },
                          }),
                        ],
                        1
                      )
                    : e._e(),
                ],
                1
              )
            }),
            0
          )
        },
        d = [],
        c = i('c7eb'),
        m = i('1da1'),
        h = i('3835'),
        p = i('b85c'),
        f = i('2909'),
        v =
          (i('14d9'),
          i('4de4'),
          i('d3b7'),
          i('159b'),
          i('e260'),
          i('4ec9'),
          i('3ca3'),
          i('ddb0'),
          i('99af'),
          i('d81d'),
          i('6062'),
          i('a434'),
          i('b0c0'),
          i('08fd')),
        C = i('ef7c'),
        I = i('722b'),
        S = i('c342'),
        g = i('b047'),
        V = i.n(g),
        b = i('d0db'),
        L = (i('a717'), i('c02a')),
        k = {
          components: {
            AudioWaves: v.a,
            MedalIcon: C.a,
            EmoticonMessage: I.a,
          },
          props: {
            options: {
              type: Object,
              default: function () {
                return {
                  isHistory: false,
                  ircMsg: {},
                  roomMessage: {
                    roomInfo: {
                      commonOption: {},
                      planInfo: {},
                      stuInfo: {},
                    },
                  },
                }
              },
            },
          },
          data: function () {
            return {
              stuId: this.options.roomMessage.roomInfo.stuInfo.id,
              urlMap: {
                5: '/lottiefiles/coins/coins-add-5/data.json',
                10: '/lottiefiles/coins/coins-add-10/data.json',
              },
              ircMsg: this.options.ircMsg,
              stuList: [],
              diffInfo: {},
              pptratio: {
                width: '',
                height: '',
              },
              boundingClientRect: {},
              data: [],
              isShowCoins: false,
              lastInteraction: '',
              highEncoderConfig: {
                width: 320,
                height: 240,
                bitrate: 120,
                frameRate: 10,
              },
              lowEncoderConfig: {
                bitrate: 80,
                frameRate: 10,
                width: 160,
                height: 120,
              },
              msgType: null,
            }
          },
          watch: {
            stuList: {
              handler: function (e, t) {
                var i = this
                switch (
                  (console.info(
                    '对象函数 handler(newVal, oldVal)',
                    e,
                    t,
                    'filePath:renderer/components/Classroom/SmallClass/Live/Interactions/multVideoLink/app.vue'
                  ),
                  this.options.isHistory && this.upDownClass(e, t),
                  this.msgType)
                ) {
                  case 2:
                  case 3:
                  case 6:
                    if (this.options.isHistory) {
                      return void console.info(
                        'if(this.options.isHistory)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/Interactions/multVideoLink/app.vue'
                      )
                    }
                    this.ircMsg,
                      this.options.isHistory,
                      this.upDownClass(e, t),
                      this.data
                    break
                  case 4:
                    var o = e.filter(function (e) {
                      return 0 !== e.addCoin
                    })
                    this.data.forEach(function (e) {
                      return (e.addCoin = 0)
                    }),
                      o.forEach(function (e) {
                        i.data.forEach(function (t) {
                          e.userId === t.userId && (t.addCoin = e.addCoin)
                        })
                        e.userId == i.stuId &&
                          i.$bus.$emit('updateAchievement', 'add', e.addCoin)
                      }),
                      (this.isShowCoins = true)
                    var n = null
                    if (n) {
                      return void console.info(
                        'if(timer)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/Interactions/multVideoLink/app.vue'
                      )
                    }
                    n = setTimeout(function () {
                      i.isShowCoins = false
                      clearTimeout(n)
                      n = null
                    }, 4000)
                    break
                  case 5:
                    this.dragVideoView(e, t), this.$forceUpdate()
                    break
                  default:
                    break
                }
              },
              deep: true,
            },
            data: {
              handler: function (e) {
                console.info(
                  '对象函数 handler(newVal)',
                  e,
                  'filePath:renderer/components/Classroom/SmallClass/Live/Interactions/multVideoLink/app.vue'
                )
                var t = []
                e.forEach(function (e) {
                  t.push(e.userId)
                })
                this.$store.dispatch('smallClass/updateVideoMicLinkUsers', t)
              },
            },
          },
          computed: {
            microphoneStatus: function () {
              return (
                console.info(
                  '对象函数 microphoneStatus,filePath:renderer/components/Classroom/SmallClass/Live/Interactions/multVideoLink/app.vue'
                ),
                this.$store.state.smallClass.microphoneStatus
              )
            },
            cameraStatus: function () {
              return (
                console.info(
                  '对象函数 cameraStatus,filePath:renderer/components/Classroom/SmallClass/Live/Interactions/multVideoLink/app.vue'
                ),
                this.$store.state.smallClass.cameraStatus
              )
            },
          },
          mounted: function () {
            var e = this
            b.a.send({
              tag: 'userTrack',
              content: { msg: '小班-多人上台' },
            })
            this.$bus.$emit('multVideoLinkStatus', {
              pub: true,
              status: 1,
            })
            this.$bus.$emit('raiseHandSendMessageToTeacher', { type: 127 })
            this.$bus.$emit('raiseHandForMultVideoLink', true)
            this.$nextTick(function () {
              e.getSize()
              window.addEventListener('resize', V()(e.getSize, 500))
            })
            this.ircMsg
            this.options.isHistory
            this.receiveMessage(this.ircMsg)
            this.bindEvent()
            this.initUpdateStudentAudioStatus()
          },
          beforeDestroy: function () {
            var e = this
            console.info(
              '对象函数 beforeDestroy,filePath:renderer/components/Classroom/SmallClass/Live/Interactions/multVideoLink/app.vue'
            )
            this.setVideoEncoderConfiguration(false)
            this.$bus.$emit('multVideoLinkStatus', { pub: false })
            this.$bus.$emit('raiseHandForMultVideoLink', false)
            this.data.forEach(function (t) {
              t.userId == e.stuId && e.$bus.$emit('raiseHandDisabled', false)
              e.$bus.$emit('multVideoLinkStatus', {
                pub: true,
                status: 3,
                stuId: t.userId,
              })
            })
            this.upDownClass([], this.data)
            this.unbindEvent()
          },
          methods: {
            setVideoEncoderConfiguration: function (e) {
              var t, i, o
              console.info(
                '对象函数 setVideoEncoderConfiguration(isOnStage)',
                e,
                'filePath:renderer/components/Classroom/SmallClass/Live/Interactions/multVideoLink/app.vue'
              )
              o = e ? this.highEncoderConfig : this.lowEncoderConfig
              null === (t = this.thinkClass) ||
                void 0 === t ||
                null === (i = t.RtcService) ||
                void 0 === i ||
                i.setVideoEncoderConfiguration(o)
            },
            getUpDownStuObj: function (e, t) {
              console.info(
                '对象函数 getUpDownStuObj(newVal, oldVal)',
                e,
                t,
                'filePath:renderer/components/Classroom/SmallClass/Live/Interactions/multVideoLink/app.vue'
              )
              var i = new Map(),
                o = [].concat(Object(f.a)(t), Object(f.a)(e))
              o.forEach(function (e) {
                i.set(e.userId, e)
              })
              var n =
                  t.map(function (e) {
                    return e.userId
                  }) || [],
                s =
                  e.map(function (e) {
                    return e.userId
                  }) || [],
                a = new Set(s),
                r = new Set(n),
                l = n.filter(function (e) {
                  return !a.has(e)
                }),
                u = s.filter(function (e) {
                  return !r.has(e)
                })
              return {
                downstu: l,
                upstu: u,
                allList: i,
              }
            },
            upDownClass: function (e, t) {
              var i = this,
                o =
                  arguments.length > 2 &&
                  void 0 !== arguments[2] &&
                  arguments[2]
              console.info(
                '对象函数 upDownClass(newVal, oldVal, isDestroy)',
                e,
                t,
                o,
                'filePath:renderer/components/Classroom/SmallClass/Live/Interactions/multVideoLink/app.vue'
              )
              var n = this.getUpDownStuObj(e, t)
              n.downstu.forEach(function (e) {
                return n.allList.delete(e)
              })
              n.downstu.forEach(function (e) {
                var t = null
                i.data.forEach(function (i, o) {
                  e == i.userId && (t = o)
                })
                null != t && i.data.splice(t, 1)
              })
              n.upstu.forEach(function (e) {
                i.data.length <= 4 && i.data.push(n.allList.get(e))
                i.data.forEach(function (e) {
                  i.stuId == e.userId &&
                    (i.cameraStatus
                      ? (e.cameraIsOpen = 1)
                      : (e.cameraIsOpen = 2))
                })
              })
              e.forEach(function (e) {
                i.data.map(function (t) {
                  return (
                    e.userId === t.userId &&
                      ((t.isAuthorize = e.isAuthorize),
                      e.isAuthorize &&
                        b.a.send({
                          tag: 'userTrack',
                          content: { msg: '小班-多人上台-授权涂鸦' },
                        })),
                    t
                  )
                })
              })
              this.$nextTick(function () {
                n.upstu
                n.downstu
                o ||
                  n.upstu.forEach(function (e) {
                    i.$bus.$emit('multVideoLinkStatus', {
                      pub: true,
                      status: 2,
                      stuId: e,
                    })
                    var t,
                      o = 'mult-video-'.concat(e)
                    e == i.stuId
                      ? (L.k(
                          null === (t = i.ircMsg) || void 0 === t
                            ? void 0
                            : t.interactId,
                          true
                        ),
                        i.setVideoEncoderConfiguration(true),
                        i.$bus.$emit('raiseHandDisabled', true),
                        i.setupLocalVideo(o),
                        i.updateStudentVal(
                          i.stuId,
                          'micIsOpen',
                          i.microphoneStatus ? 1 : 2
                        ),
                        i.microphoneStatus ||
                          i.$bus.$emit('showMicrophoneAllowConfirm'),
                        i.$store.dispatch(
                          'smallClass/updateSelfVideoMicLink',
                          true
                        ))
                      : setTimeout(function () {
                          i.setupRemoteVideo(e, o)
                          i.muteRemoteAudio(e, false)
                        }, 100)
                  })
                n.downstu.forEach(function (e) {
                  var t, o, n
                  e == i.stuId &&
                    (i.setVideoEncoderConfiguration(false),
                    i.$bus.$emit('raiseHandDisabled', false),
                    i.$store.dispatch(
                      'smallClass/updateSelfVideoMicLink',
                      false
                    ),
                    i.lastInteraction !=
                      (null === (t = i.ircMsg) || void 0 === t
                        ? void 0
                        : t.interactId) &&
                      (L.k(
                        null === (o = i.ircMsg) || void 0 === o
                          ? void 0
                          : o.interactId,
                        false
                      ),
                      (i.lastInteraction =
                        null === (n = i.ircMsg) || void 0 === n
                          ? void 0
                          : n.interactId)))
                  i.destroyRemoteVideo(e)
                  i.$bus.$emit('multVideoLinkStatus', {
                    pub: true,
                    status: 3,
                    stuId: e,
                  })
                })
              })
            },
            receiveMessage: function (e) {
              console.info(
                '对象函数 receiveMessage(noticeContent)',
                e,
                'filePath:renderer/components/Classroom/SmallClass/Live/Interactions/multVideoLink/app.vue'
              )
              this.msgType = e.status
              this.stuList = e.data || []
            },
            dragVideoView: function (e) {
              var t = this
              return (
                console.info(
                  '对象函数 dragVideoView(newVal)',
                  e,
                  'filePath:renderer/components/Classroom/SmallClass/Live/Interactions/multVideoLink/app.vue'
                ),
                e.forEach(function (e) {
                  t.data
                  t.data.forEach(function (i, o) {
                    i.userId == e.userId &&
                      ((t.data[o].originYRatio = e.originYRatio),
                      (t.data[o].originXRatio = e.originXRatio))
                  })
                }),
                e
              )
            },
            updateStudentVal: function (e, t, i) {
              var o = this
              this.data.forEach(function (n) {
                n.userId == e && ((n[t] = i), o.$forceUpdate())
              })
            },
            strMapToObj: function (e) {
              console.info(
                '对象函数 strMapToObj(strMap)',
                e,
                'filePath:renderer/components/Classroom/SmallClass/Live/Interactions/multVideoLink/app.vue'
              )
              var t,
                i = Object.create(null),
                o = Object(p.a)(e)
              try {
                for (o.s(); !(t = o.n()).done; ) {
                  var n = Object(h.a)(t.value, 2),
                    s = n[0],
                    a = n[1]
                  i[s] = a
                }
              } catch (r) {
                o.e(r)
              } finally {
                o.f()
              }
              return i
            },
            getSize: function () {
              console.info(
                '对象函数 getSize,filePath:renderer/components/Classroom/SmallClass/Live/Interactions/multVideoLink/app.vue'
              )
              this.boundingClientRectController = document
                .getElementById('interactionController')
                .getBoundingClientRect()
              var e = (this.pptratio.width =
                  this.boundingClientRectController.width),
                t = (this.pptratio.height =
                  this.boundingClientRectController.height)
              t / e > 0.75
                ? ((this.diffInfo = {
                    h: (t - (e / 4) * 3) / 2,
                    w: 0,
                  }),
                  (this.pptratio.height = t - 2 * this.diffInfo.h))
                : ((this.diffInfo = {
                    w: (e - (t / 3) * 4) / 2,
                    h: 0,
                  }),
                  (this.pptratio.width = e - 2 * this.diffInfo.w))
            },
            setupLocalVideo: function (e) {
              console.info(
                '对象函数 setupLocalVideo(id)',
                e,
                'filePath:renderer/components/Classroom/SmallClass/Live/Interactions/multVideoLink/app.vue'
              )
              this.thinkClass.RtcService.createLocalVideo(e)
            },
            destroyRemoteVideo: function (e) {
              console.info(
                '对象函数 destroyRemoteVideo(uid)',
                e,
                'filePath:renderer/components/Classroom/SmallClass/Live/Interactions/multVideoLink/app.vue'
              )
              this.thinkClass.RtcService.destroyRemoteVideo(e)
            },
            setupRemoteVideo: function (e, t) {
              console.info(
                '对象函数 setupRemoteVideo(uid, id)',
                e,
                t,
                'filePath:renderer/components/Classroom/SmallClass/Live/Interactions/multVideoLink/app.vue'
              )
              this.thinkClass.RtcService.createRemoteVideo(e, t)
            },
            muteRemoteAudio: function (e, t) {
              console.info(
                '对象函数 muteRemoteAudio(uid, mute)',
                e,
                t,
                'filePath:renderer/components/Classroom/SmallClass/Live/Interactions/multVideoLink/app.vue'
              )
              this.thinkClass.RtcService.muteRemoteAudio(e, t)
            },
            bindEvent: function () {
              console.info(
                '对象函数 bindEvent,filePath:renderer/components/Classroom/SmallClass/Live/Interactions/multVideoLink/app.vue'
              )
              this.thinkClass.RtcService.on(
                'remoteVideoStateChanged',
                this.listenRemoteVideoStateChanged
              )
              this.thinkClass.RtcService.on(
                'remoteAudioStateChanged',
                this.listenRemoteAudioStateChanged
              )
              this.thinkClass.RtcService.on(
                'groupAudioVolumeIndication',
                this.listenGroupAudioVolumeIndication
              )
              this.$bus.$on(
                'updateMicrophoneStatus',
                this.listenUpdateMicrophoneStatus
              )
              this.$bus.$on('updateCameraStatus', this.listenUpdateCameraStatus)
              this.$bus.$on('sendEmoji', this.listenLocalEmoticonMessage)
              this.thinkClass.SignalService.on(
                'onRecvRoomMessage',
                this.listenOnRecvRoomMessage
              )
            },
            unbindEvent: function () {
              console.info(
                '对象函数 unbindEvent,filePath:renderer/components/Classroom/SmallClass/Live/Interactions/multVideoLink/app.vue'
              )
              this.thinkClass.RtcService.off(
                'remoteVideoStateChanged',
                this.listenRemoteVideoStateChanged
              )
              this.thinkClass.RtcService.off(
                'remoteAudioStateChanged',
                this.listenRemoteAudioStateChanged
              )
              this.thinkClass.RtcService.off(
                'groupAudioVolumeIndication',
                this.listenGroupAudioVolumeIndication
              )
              this.$bus.$off(
                'updateMicrophoneStatus',
                this.listenUpdateMicrophoneStatus
              )
              this.$bus.$off(
                'updateCameraStatus',
                this.listenUpdateCameraStatus
              )
              this.$bus.$off('sendEmoji', this.listenLocalEmoticonMessage)
              this.thinkClass.SignalService.off(
                'onRecvRoomMessage',
                this.listenOnRecvRoomMessage
              )
            },
            listenRemoteVideoStateChanged: function (e, t, i) {
              var o = this
              console.info(
                '对象函数 listenRemoteVideoStateChanged(uid, state, reason)',
                e,
                t,
                i,
                'filePath:renderer/components/Classroom/SmallClass/Live/Interactions/multVideoLink/app.vue'
              )
              this.data.forEach(function (n) {
                e == n.userId &&
                  (2 == t &&
                    (document.getElementById('mult-video-'.concat(e)) &&
                      !document.getElementById('mult-video-'.concat(e))
                        .innerHTML &&
                      setTimeout(function () {
                        o.setupRemoteVideo(e, 'mult-video-'.concat(e))
                      }, 150),
                    (n.cameraIsOpen = 1)),
                  (n.cameraIsOpen = 3 == i || 5 == i || 7 == i ? 2 : 1))
              })
            },
            listenRemoteAudioStateChanged: function (e, t, i) {
              console.info(
                '对象函数 listenRemoteAudioStateChanged(uid, state, reason)',
                e,
                t,
                i,
                'filePath:renderer/components/Classroom/SmallClass/Live/Interactions/multVideoLink/app.vue'
              )
              5 === i && this.updateStudentVal(e, 'micIsOpen', 2)
              ;(6 !== i && 2 !== t) || this.updateStudentVal(e, 'micIsOpen', 1)
            },
            listenGroupAudioVolumeIndication: function (e) {
              var t = this
              e.forEach(function (e) {
                t.updateStudentVal(
                  0 == e.uid ? t.stuId : e.uid,
                  'volume',
                  e.volume
                )
              })
            },
            listenUpdateMicrophoneStatus: function (e) {
              console.info(
                '对象函数 listenUpdateMicrophoneStatus(status)',
                e,
                'filePath:renderer/components/Classroom/SmallClass/Live/Interactions/multVideoLink/app.vue'
              )
              this.$bus.$emit('raiseHandSendMessageToTeacher', { type: 127 })
              this.updateStudentVal(this.stuId, 'micIsOpen', e ? 1 : 2)
            },
            listenUpdateCameraStatus: function (e) {
              console.info(
                '对象函数 listenUpdateCameraStatus(status)',
                e,
                'filePath:renderer/components/Classroom/SmallClass/Live/Interactions/multVideoLink/app.vue'
              )
              this.handleSwitchCameraStatus(e)
              this.$bus.$emit('raiseHandSendMessageToTeacher', { type: 127 })
            },
            listenLocalEmoticonMessage: function (e) {
              console.info(
                '对象函数 listenLocalEmoticonMessage(params)',
                e,
                'filePath:renderer/components/Classroom/SmallClass/Live/Interactions/multVideoLink/app.vue'
              )
              this.handleEmoticon(this.stuId, e)
            },
            listenOnRecvRoomMessage: function (e) {
              console.info(
                '对象函数 listenOnRecvRoomMessage(res)',
                e,
                'filePath:renderer/components/Classroom/SmallClass/Live/Interactions/multVideoLink/app.vue'
              )
              var t = e.content,
                i = e.fromUserInfo,
                n = t.ircType,
                s = t.data,
                a = {
                  name: null === s || void 0 === s ? void 0 : s.name,
                  type: null === s || void 0 === s ? void 0 : s.type,
                }
              'send_emoji' == n
                ? this.handleEmoticon(i.psId, a)
                : 'animation_emoji' == n &&
                  this.handleEmoticon(
                    i.psId,
                    Object(o.a)(Object(o.a)({}, a), s.resource)
                  )
            },
            handleEmoticon: function (e, t) {
              console.info(
                '对象函数 handleEmoticon(stuId, params)',
                e,
                t,
                'filePath:renderer/components/Classroom/SmallClass/Live/Interactions/multVideoLink/app.vue'
              )
              var i = {
                emoticonName: t.name,
                emoticonType: t.type,
                lottieUrl: t.lottieUrl,
                emojiId: t.emojiId,
              }
              this.patchDealEmoji(e, i)
            },
            patchDealEmoji: function (e, t) {
              for (var i in (console.info(
                '对象函数 patchDealEmoji(stuId, clearEmojiList)',
                e,
                t,
                'filePath:renderer/components/Classroom/SmallClass/Live/Interactions/multVideoLink/app.vue'
              ),
              t))
                this.updateStudentVal(e, i, t[i])
            },
            handleClearEmoticon: function (e) {
              console.info(
                '对象函数 handleClearEmoticon(userId)',
                e,
                'filePath:renderer/components/Classroom/SmallClass/Live/Interactions/multVideoLink/app.vue'
              )
              this.patchDealEmoji(e, t)
            },
            destroyInteraction: function (e) {
              var t, i
              console.info(
                '对象函数 destroyInteraction(options)',
                e,
                'filePath:renderer/components/Classroom/SmallClass/Live/Interactions/multVideoLink/app.vue'
              )
              var o = e.ircMsg
              this.upDownClass(o.data, this.data, true)
              this.$destroy()
              null === (t = this.$el) ||
                void 0 === t ||
                null === (i = t.parentNode) ||
                void 0 === i ||
                i.removeChild(this.$el)
            },
            handleSwitchCameraStatus: function (e) {
              var t = this
              console.info(
                '对象函数 handleSwitchCameraStatus(status)',
                e,
                'filePath:renderer/components/Classroom/SmallClass/Live/Interactions/multVideoLink/app.vue'
              )
              this.data.forEach(function (i) {
                t.stuId == i.userId &&
                  (t.thinkClass.RtcService.muteLocalVideo(!e),
                  (i.cameraIsOpen = e ? 1 : 2))
              })
            },
            initUpdateStudentAudioStatus: function () {
              var e = this
              return Object(m.a)(
                Object(c.a)().mark(function t() {
                  var i, o, n
                  return Object(c.a)().wrap(function (t) {
                    while (1) {
                      switch ((t.prev = t.next)) {
                        case 0:
                          return (
                            console.info(
                              '对象函数 initUpdateStudentAudioStatus,filePath:renderer/components/Classroom/SmallClass/Live/Interactions/multVideoLink/app.vue'
                            ),
                            (t.next = 3),
                            Object(S.g)({
                              planId:
                                e.options.roomMessage.roomInfo.planInfo.id,
                            })
                          )
                        case 3:
                          if (((i = t.sent), i && 0 == i.code)) {
                            t.next = 7
                            break
                          }
                          return (
                            console.info(
                              'if(!res || res.code != 0)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/Interactions/multVideoLink/app.vue'
                            ),
                            t.abrupt('return')
                          )
                        case 7:
                          ;(o = i.data.list),
                            (n = void 0 === o ? [] : o),
                            n.forEach(function (t) {
                              e.updateStudentVal(
                                t.userId,
                                'micIsOpen',
                                t.micIsOpen
                              )
                              e.updateStudentVal(
                                t.userId,
                                'cameraIsOpen',
                                t.cameraIsOpen
                              )
                            })
                        case 9:
                        case 'end':
                          return t.stop()
                      }
                    }
                  }, t)
                })
              )()
            },
          },
        },
        w = k,
        E = (i('1d7d'), i('2877')),
        R = Object(E.a)(w, u, d, false, null, 'deebe15c', null),
        M = R.exports,
        $ = (function (e) {
          Object(a.a)(i, e)
          var t = Object(r.a)(i)
          function i() {
            var e,
              o =
                arguments.length > 0 && void 0 !== arguments[0]
                  ? arguments[0]
                  : {},
              s =
                arguments.length > 1 && void 0 !== arguments[1]
                  ? arguments[1]
                  : {}
            return (
              console.info(
                '函数申明 MultVideoLink(opts, store)',
                o,
                s,
                'filePath:renderer/components/Classroom/SmallClass/Live/Interactions/multVideoLink/index.js'
              ),
              Object(n.a)(this, i),
              (e = t.call(this, M)),
              (e.options = o),
              (e.store = s),
              (e.dom = o.roomMessage.roomInfo.interactionController),
              (e.keepOtherDom = o.keepOtherDom),
              e.initVmApp('多人上台'),
              e
            )
          }
          return (
            Object(s.a)(i, [
              {
                key: 'createPropsData',
                value: function () {
                  var e = {}
                  return Object(o.a)({ options: this.options }, e)
                },
              },
            ]),
            i
          )
        })(l.a)
    },
    b6c9: function (e, t, i) {
      'use strict'
      i.d(t, 'a', function () {
        return u
      })
      var o = i('d4ec'),
        n = i('bee2'),
        s = (i('99af'), i('d9e2'), i('8bbf')),
        a = i.n(s),
        r = i('3898'),
        l = i('d0db'),
        u = (function () {
          function e(t) {
            console.info(
              '函数申明 InteractionBase(app)',
              t,
              'filePath:renderer/components/Classroom/CommonInteractions/interaction-base.js'
            )
            Object(o.a)(this, e)
            this.app = t
            this.vm = null
            this.keepOtherDom = false
          }
          return (
            Object(n.a)(e, [
              {
                key: 'initVmApp',
                value: function (e) {
                  if (!this.dom) {
                    throw Error('互动的dom容器不存在')
                  }
                  this.dom.children.length > 0 &&
                    !this.keepOtherDom &&
                    (l.a.send({
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
                    i = this.createPropsData(),
                    o = new t({
                      i18n: r.b,
                      propsData: i,
                      store: this.store || {},
                    })
                  return o.$mount(), o
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
                value: function () {},
              },
            ]),
            e
          )
        })()
    },
    d984: function (e, t, i) {},
  },
])
