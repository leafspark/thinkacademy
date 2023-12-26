; (window.webpackJsonp = window.webpackJsonp || []).push([
  ['chunk-7697d2b8'],
  {
    '40f6': function (e, t, n) {
      'use strict'
      n.d(t, 'c', function () {
        return l
      })
      n.d(t, 'a', function () {
        return d
      })
      n.d(t, 'b', function () {
        return p
      })
      var r = n('c7eb'),
        c = n('1da1'),
        i = (n('caad'), n('2532'), n('02fc')),
        a = n('bc8a'),
        s = n('35ac'),
        o = n('d0db'),
        u = function (e, t) {
          var n =
            arguments.length > 2 && void 0 !== arguments[2]
              ? arguments[2]
              : {},
            r =
              arguments.length > 3 && void 0 !== arguments[3]
                ? arguments[3]
                : 'error'
          o.a.send({
            tag: 'http',
            level: r,
            content: {
              msg: e,
              err: t,
              params: n,
            },
          })
        },
        l = (function () {
          var e = Object(c.a)(
            Object(r.a)().mark(function e() {
              var t,
                n = arguments
              return Object(r.a)().wrap(function (e) {
                while (1) {
                  switch ((e.prev = e.next)) {
                    case 0:
                      return (
                        (t = n.length > 0 && void 0 !== n[0] ? n[0] : 'school'),
                        (e.next = 3),
                        window.thinkApi.ipc.invoke(
                          'setStoreValue',
                          'timezoneRuleType',
                          t
                        )
                      )
                    case 3:
                    case 'end':
                      return e.stop()
                  }
                }
              }, e)
            })
          )
          return function () {
            return e.apply(this, arguments)
          }
        })(),
        d = (function () {
          var e = Object(c.a)(
            Object(r.a)().mark(function e() {
              var t
              return Object(r.a)().wrap(function (e) {
                while (1) {
                  switch ((e.prev = e.next)) {
                    case 0:
                      return (
                        (e.next = 2),
                        window.thinkApi.ipc.invoke(
                          'getStoreValue',
                          'timezoneRuleType'
                        )
                      )
                    case 2:
                      return (t = e.sent), e.abrupt('return', t || 'school')
                    case 4:
                    case 'end':
                      return e.stop()
                  }
                }
              }, e)
            })
          )
          return function () {
            return e.apply(this, arguments)
          }
        })(),
        p = (function () {
          var e = Object(c.a)(
            Object(r.a)().mark(function e() {
              var t, n, c, o, p, f, v, b, h, m, w, j, O
              return Object(r.a)().wrap(function (e) {
                while (1) {
                  switch ((e.prev = e.next)) {
                    case 0:
                      return (e.next = 2), Object(s.b)()
                    case 2:
                      return (t = e.sent), (e.next = 5), Object(i.f)()
                    case 5:
                      return (n = e.sent), (e.next = 8), d()
                    case 8:
                      if (
                        ((c = e.sent),
                          (o =
                            (null === t || void 0 === t
                              ? void 0
                              : t.timeZoneSwitchSchool) || []),
                          (p = o.includes(n)),
                          !p)
                      ) {
                        e.next = 22
                        break
                      }
                      return (
                        'manual' !== c && (c = 'geo'),
                        (e.next = 16),
                        Object(a.h)().catch(function (e) {
                          u('接口报错:时区列表:', e)
                        })
                      )
                    case 16:
                      ; (f = e.sent),
                        (v = f.code),
                        (b = f.data),
                        0 === v && Object(i.k)(b),
                        (e.next = 25)
                      break
                    case 22:
                      ; (c = 'school'),
                        window.thinkApi.ipc.send(
                          'deleteStoreValue',
                          'timezoneList'
                        ),
                        window.thinkApi.ipc.send('deleteStoreValue', 'timezone')
                    case 25:
                      return l(c), (e.next = 29), Object(i.c)()
                    case 29:
                      if (
                        ((h = e.sent),
                          (m =
                            null === t || void 0 === t ? void 0 : t.timezone[h]),
                          (w = []),
                          'geo' !== c)
                      ) {
                        e.next = 39
                        break
                      }
                      return (
                        (j = Object(i.b)()),
                        (e.next = 37),
                        Object(a.a)({ timezone: j })
                      )
                    case 37:
                      ; (O = e.sent),
                        O &&
                        0 === O.code &&
                        O.data &&
                        (0 === O.data.invalid
                          ? (m = j)
                          : (w = ['setting.timezone.invalidMsg', m]))
                    case 39:
                      return (
                        'manual' !== c && Object(i.j)(m),
                        e.abrupt('return', w.length ? w : '')
                      )
                    case 41:
                    case 'end':
                      return e.stop()
                  }
                }
              }, e)
            })
          )
          return function () {
            return e.apply(this, arguments)
          }
        })()
    },
    5511: function (e, t, n) {
      'use strict'
      n('781d')
    },
    '781d': function (e, t, n) { },
    '822e': function (e, t, n) {
      'use strict'
      var r = n('c7eb'),
        c = n('1da1'),
        i = (n('14d9'), n('02fc')),
        a = n('bc13'),
        s = n('383d'),
        o = n('92e5'),
        u = n('40f6'),
        l = n('3898'),
        d = {
          methods: {
            initBoot: function () {
              var e = this
              return Object(c.a)(
                Object(r.a)().mark(function t() {
                  var n, c, d, p, f, v, b, h
                  return Object(r.a)().wrap(function (t) {
                    while (1) {
                      switch ((t.prev = t.next)) {
                        case 0:
                          return (
                            console.info(
                              '对象函数 initBoot,filePath:renderer/mixins/boot.js'
                            ),
                            (t.next = 3),
                            Object(i.c)()
                          )
                        case 3:
                          return (n = t.sent), (t.next = 7), Object(o.a)()
                        case 7:
                          if (
                            ((c = t.sent),
                              (d = c.unifiedAccessToken),
                              n && 'undefined' != n)
                          ) {
                            t.next = 31
                            break
                          }
                          return (t.next = 12), Object(s.g)()
                        case 12:
                          if (((p = t.sent), p && 0 == p.code)) {
                            t.next = 17
                            break
                          }
                          return (
                            console.info(
                              'if(!res || res.code != 0)为true触发return,path: /renderer/mixins/boot.js'
                            ),
                            e.$router.push('local-setting'),
                            t.abrupt('return')
                          )
                        case 17:
                          return (
                            (f = p.data || {}),
                            (v = f.schoolCode),
                            (t.next = 21),
                            Object(i.d)(v)
                          )
                        case 21:
                          if (((b = t.sent), b && 'undefined' != b)) {
                            t.next = 26
                            break
                          }
                          return (
                            console.info(
                              "if(!_local || _local == 'undefined')为true触发return,path: /renderer/mixins/boot.js"
                            ),
                            e.$router.push('local-setting'),
                            t.abrupt('return')
                          )
                        case 26:
                          return (t.next = 28), Object(i.i)(b)
                        case 28:
                          return (t.next = 30), Object(a.b)()
                        case 30:
                          Object(l.c)()
                        case 31:
                          return (t.next = 33), Object(u.b)()
                        case 33:
                          if (
                            ((h = t.sent),
                              h && e.$Message.info(e.$t(h[0]) + h[1]),
                              d)
                          ) {
                            t.next = 39
                            break
                          }
                          return (
                            console.info(
                              'if(!token)为true触发return,path: /renderer/mixins/boot.js'
                            ),
                            e.$router.push('/login'),
                            t.abrupt('return')
                          )
                        case 39:
                          e.$router.push('/courses')
                        case 40:
                        case 'end':
                          return t.stop()
                      }
                    }
                  }, t)
                })
              )()
            },
          },
        }
      t.a = d
    },
    a5c3: function (e, t, n) {
      'use strict'
      n.r(t)
      var r = function () {
        var e = this,
          t = e._self._c
        return t(
          'div',
          { staticClass: 'device-intercept' },
          [
            t('Toolbar', {
              attrs: {
                transparent: true,
                fixed: true,
                disabledMaximize: true,
              },
            }),
            t('div', { staticClass: 'wrapper' }, [
              t('div', { staticClass: 'logo' }),
              t('div', { staticClass: 'device' }, [
                48000 == e.code
                  ? t('section', { staticClass: 'device-status' }, [
                    e._m(0),
                    t('div', { staticClass: 'contnet' }, [
                      e._v(
                        ' Sorry, your device is not supported. Please use the software on devices that meet the minimum requirements. '
                      ),
                    ]),
                  ])
                  : t('section', { staticClass: 'device-status' }, [
                    e._m(1),
                    t('div', { staticClass: 'contnet' }, [
                      e._v(
                        ' Sorry, your device is not recommended for an ultimate class experience. Please use the software on devices that meet the minimum requirements. '
                      ),
                    ]),
                  ]),
                t('section', { staticClass: 'device-info' }, [
                  t('div', { staticClass: 'common compatibility' }, [
                    e._m(2),
                    t('span', { staticClass: 'right' }, [
                      t('span', [
                        e._v(
                          ' ' +
                          e._s(
                            'Mac' == e.deviceInfo.platform
                              ? 'MacOS 10.12 and above'
                              : 'Windows 7 and above'
                          ) +
                          ' '
                        ),
                      ]),
                    ]),
                  ]),
                  e._m(3),
                  'Windows' == e.deviceInfo.platform
                    ? t('div', { staticClass: 'common' }, [
                      t('div', { staticClass: 'left' }, [e._v('Device')]),
                      t('span', { staticClass: 'right' }, [
                        e._v(
                          ' Chromebook and Surface Book are NOT recommended '
                        ),
                      ]),
                    ])
                    : e._e(),
                ]),
              ]),
              48000 == e.code
                ? t(
                  'div',
                  {
                    staticClass: 'stop-button',
                    class: [{ disabled: !e.couldButtonTap }],
                    on: { click: e.jumpToWebsite },
                  },
                  [e._v(' Got it ')]
                )
                : t('div', { staticClass: 'remind-button' }, [
                  t('div', {
                    staticClass: 'button',
                    class: [{ disabled: !e.couldButtonTap }],
                    on: { click: e.handleOk },
                  }),
                ]),
            ]),
          ],
          1
        )
      },
        c = [
          function () {
            var e = this,
              t = e._self._c
            return t('div', { staticClass: 'title' }, [
              t('span'),
              t('span', [e._v('Device Not Compatible')]),
            ])
          },
          function () {
            var e = this,
              t = e._self._c
            return t('div', { staticClass: 'title' }, [
              t('span'),
              t('span', [e._v('Device Not Recommend')]),
            ])
          },
          function () {
            var e = this,
              t = e._self._c
            return t('div', { staticClass: 'left' }, [
              t('span', [e._v(' Compatibility ')]),
            ])
          },
          function () {
            var e = this,
              t = e._self._c
            return t('div', { staticClass: 'common configurations' }, [
              t('div', { staticClass: 'left' }, [
                t('span', [e._v('configurations')]),
              ]),
              t('span', { staticClass: 'right' }, [
                e._v(' CPU 4 Cores, 4GB RAM '),
              ]),
            ])
          },
        ],
        i = n('c7eb'),
        a = n('1da1'),
        s = n('dfa8'),
        o = n('02fc'),
        u = n('822e'),
        l = n('0a4b'),
        d = n('d0db'),
        p = n('35ac'),
        f = {
          name: 'DeviceIntercept',
          mixins: [u.a],
          components: { Toolbar: s.a },
          data: function () {
            var e = this.$route.query.code
            return {
              localList: Object(p.c)('campusConfig') || [],
              local: '',
              couldButtonTap: false,
              deviceInfo: 'Mac',
              code: e,
            }
          },
          mounted: function () {
            this.init()
            this.releaseBtn()
            this.sendLogger('初始化设备拦截')
          },
          methods: {
            init: function () {
              var e = this
              return Object(a.a)(
                Object(i.a)().mark(function t() {
                  return Object(i.a)().wrap(function (t) {
                    while (1) {
                      switch ((t.prev = t.next)) {
                        case 0:
                          return (
                            console.info(
                              '对象函数 init,filePath:renderer/views/DeviceIntercept.vue'
                            ),
                            (t.next = 3),
                            Object(o.c)()
                          )
                        case 3:
                          return (
                            (e.local = t.sent),
                            (t.next = 6),
                            l.nativeApi.getDeviceInfo()
                          )
                        case 6:
                          e.deviceInfo = t.sent
                        case 7:
                        case 'end':
                          return t.stop()
                      }
                    }
                  }, t)
                })
              )()
            },
            handleItem: function (e) {
              console.info(
                '对象函数 handleItem(local)',
                e,
                'filePath:renderer/views/DeviceIntercept.vue'
              )
              this.local = e
            },
            releaseBtn: function () {
              var e = this
              console.info(
                '对象函数 releaseBtn,filePath:renderer/views/DeviceIntercept.vue'
              )
              setTimeout(function () {
                e.couldButtonTap = true
              }, 3000)
            },
            jumpToWebsite: function () {
              return Object(a.a)(
                Object(i.a)().mark(function e() {
                  return Object(i.a)().wrap(function (e) {
                    while (1) {
                      switch ((e.prev = e.next)) {
                        case 0:
                          console.info(
                            '对象函数 jumpToWebsite,filePath:renderer/views/DeviceIntercept.vue'
                          ),
                            setTimeout(function () {
                              l.nativeApi.closeWindow(true)
                            }, 100)
                        case 2:
                        case 'end':
                          return e.stop()
                      }
                    }
                  }, e)
                })
              )()
            },
            handleOk: function () {
              var e = this
              return Object(a.a)(
                Object(i.a)().mark(function t() {
                  return Object(i.a)().wrap(function (t) {
                    while (1) {
                      switch ((t.prev = t.next)) {
                        case 0:
                          if (
                            (console.info(
                              '对象函数 handleOk,filePath:renderer/views/DeviceIntercept.vue'
                            ),
                              e.couldButtonTap)
                          ) {
                            t.next = 4
                            break
                          }
                          return (
                            console.info(
                              'if(!_this3.couldButtonTap)为true触发return,path: /renderer/views/DeviceIntercept.vue'
                            ),
                            t.abrupt('return')
                          )
                        case 4:
                          e.initBoot()
                        case 5:
                        case 'end':
                          return t.stop()
                      }
                    }
                  }, t)
                })
              )()
            },
            sendLogger: function (e) {
              d.a.send({
                tag: 'deviceIntercept',
                content: { msg: e },
              })
            },
          },
        },
        v = f,
        b = (n('5511'), n('2877')),
        h = Object(b.a)(v, r, c, false, null, 'c7d37b8c', null)
      t.default = h.exports
    },
    bc13: function (e, t, n) {
      'use strict'
      n.d(t, 'b', function () {
        return i
      })
      n.d(t, 'c', function () {
        return a
      })
      n.d(t, 'a', function () {
        return s
      })
      var r = n('c7eb'),
        c = n('1da1'),
        i = (function () {
          var e = Object(c.a)(
            Object(r.a)().mark(function e() {
              return Object(r.a)().wrap(function (e) {
                while (1) {
                  switch ((e.prev = e.next)) {
                    case 0:
                      return (
                        (e.next = 2),
                        window.thinkApi.ipc.invoke(
                          'setStoreValue',
                          'campusRuleType',
                          'geo'
                        )
                      )
                    case 2:
                    case 'end':
                      return e.stop()
                  }
                }
              }, e)
            })
          )
          return function () {
            return e.apply(this, arguments)
          }
        })(),
        a = (function () {
          var e = Object(c.a)(
            Object(r.a)().mark(function e() {
              return Object(r.a)().wrap(function (e) {
                while (1) {
                  switch ((e.prev = e.next)) {
                    case 0:
                      return (
                        (e.next = 2),
                        window.thinkApi.ipc.invoke(
                          'setStoreValue',
                          'campusRuleType',
                          'manual'
                        )
                      )
                    case 2:
                    case 'end':
                      return e.stop()
                  }
                }
              }, e)
            })
          )
          return function () {
            return e.apply(this, arguments)
          }
        })(),
        s = (function () {
          var e = Object(c.a)(
            Object(r.a)().mark(function e() {
              var t
              return Object(r.a)().wrap(function (e) {
                while (1) {
                  switch ((e.prev = e.next)) {
                    case 0:
                      return (
                        (e.next = 2),
                        window.thinkApi.ipc.invoke(
                          'getStoreValue',
                          'campusRuleType'
                        )
                      )
                    case 2:
                      return (t = e.sent), e.abrupt('return', t || 'manual')
                    case 4:
                    case 'end':
                      return e.stop()
                  }
                }
              }, e)
            })
          )
          return function () {
            return e.apply(this, arguments)
          }
        })()
    },
  },
])
