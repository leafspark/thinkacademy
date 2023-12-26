; (window.webpackJsonp = window.webpackJsonp || []).push([
  ['chunk-2ee5cc78'],
  {
    3782: function (e, t, n) {
      'use strict'
      n('c66c')
    },
    '40f6': function (e, t, n) {
      'use strict'
      n.d(t, 'c', function () {
        return p
      })
      n.d(t, 'a', function () {
        return d
      })
      n.d(t, 'b', function () {
        return l
      })
      var r = n('c7eb'),
        c = n('1da1'),
        a = (n('caad'), n('2532'), n('02fc')),
        i = n('bc8a'),
        o = n('35ac'),
        u = n('d0db'),
        s = function (e, t) {
          var n =
            arguments.length > 2 && void 0 !== arguments[2]
              ? arguments[2]
              : {},
            r =
              arguments.length > 3 && void 0 !== arguments[3]
                ? arguments[3]
                : 'error'
          u.a.send({
            tag: 'http',
            level: r,
            content: {
              msg: e,
              err: t,
              params: n,
            },
          })
        },
        p = (function () {
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
        l = (function () {
          var e = Object(c.a)(
            Object(r.a)().mark(function e() {
              var t, n, c, u, l, b, f, h, v, j, w, O, m
              return Object(r.a)().wrap(function (e) {
                while (1) {
                  switch ((e.prev = e.next)) {
                    case 0:
                      return (e.next = 2), Object(o.b)()
                    case 2:
                      return (t = e.sent), (e.next = 5), Object(a.f)()
                    case 5:
                      return (n = e.sent), (e.next = 8), d()
                    case 8:
                      if (
                        ((c = e.sent),
                          (u =
                            (null === t || void 0 === t
                              ? void 0
                              : t.timeZoneSwitchSchool) || []),
                          (l = u.includes(n)),
                          !l)
                      ) {
                        e.next = 22
                        break
                      }
                      return (
                        'manual' !== c && (c = 'geo'),
                        (e.next = 16),
                        Object(i.h)().catch(function (e) {
                          s('接口报错:时区列表:', e)
                        })
                      )
                    case 16:
                      ; (b = e.sent),
                        (f = b.code),
                        (h = b.data),
                        0 === f && Object(a.k)(h),
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
                      return p(c), (e.next = 29), Object(a.c)()
                    case 29:
                      if (
                        ((v = e.sent),
                          (j =
                            null === t || void 0 === t ? void 0 : t.timezone[v]),
                          (w = []),
                          'geo' !== c)
                      ) {
                        e.next = 39
                        break
                      }
                      return (
                        (O = Object(a.b)()),
                        (e.next = 37),
                        Object(i.a)({ timezone: O })
                      )
                    case 37:
                      ; (m = e.sent),
                        m &&
                        0 === m.code &&
                        m.data &&
                        (0 === m.data.invalid
                          ? (j = O)
                          : (w = ['setting.timezone.invalidMsg', j]))
                    case 39:
                      return (
                        'manual' !== c && Object(a.j)(j),
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
    '822e': function (e, t, n) {
      'use strict'
      var r = n('c7eb'),
        c = n('1da1'),
        a = (n('14d9'), n('02fc')),
        i = n('bc13'),
        o = n('383d'),
        u = n('92e5'),
        s = n('40f6'),
        p = n('3898'),
        d = {
          methods: {
            initBoot: function () {
              var e = this
              return Object(c.a)(
                Object(r.a)().mark(function t() {
                  var n, c, d, l, b, f, h, v
                  return Object(r.a)().wrap(function (t) {
                    while (1) {
                      switch ((t.prev = t.next)) {
                        case 0:
                          return (
                            console.info(
                              '对象函数 initBoot,filePath:renderer/mixins/boot.js'
                            ),
                            (t.next = 3),
                            Object(a.c)()
                          )
                        case 3:
                          return (n = t.sent), (t.next = 7), Object(u.a)()
                        case 7:
                          if (
                            ((c = t.sent),
                              (d = c.unifiedAccessToken),
                              n && 'undefined' != n)
                          ) {
                            t.next = 31
                            break
                          }
                          return (t.next = 12), Object(o.g)()
                        case 12:
                          if (((l = t.sent), l && 0 == l.code)) {
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
                            (b = l.data || {}),
                            (f = b.schoolCode),
                            (t.next = 21),
                            Object(a.d)(f)
                          )
                        case 21:
                          if (((h = t.sent), h && 'undefined' != h)) {
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
                          return (t.next = 28), Object(a.i)(h)
                        case 28:
                          return (t.next = 30), Object(i.b)()
                        case 30:
                          Object(p.c)()
                        case 31:
                          return (t.next = 33), Object(s.b)()
                        case 33:
                          if (
                            ((v = t.sent),
                              v && e.$Message.info(e.$t(v[0]) + v[1]),
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
    a7cc: function (e, t, n) {
      'use strict'
      n.r(t)
      var r = function () {
        var e = this,
          t = e._self._c
        return t(
          'div',
          { staticClass: 'page-boot' },
          [
            t('Toolbar', {
              attrs: {
                transparent: true,
                fixed: true,
                whiteButton: true,
                disabledMaximize: true,
              },
            }),
            t('div', { staticClass: 'logo' }),
          ],
          1
        )
      },
        c = [],
        a = n('c7eb'),
        i = n('1da1'),
        o = (n('14d9'), n('a9e3'), n('dfa8')),
        u = n('383d'),
        s = n('822e'),
        p = n('0a4b'),
        d = n('d0db'),
        l = {
          name: 'Boot',
          mixins: [s.a],
          components: { Toolbar: o.a },
          created: function () {
            this.message
          },
          mounted: function () {
            this.getDeviceIntercept()
          },
          methods: {
            getDeviceIntercept: function () {
              var e = this
              return Object(i.a)(
                Object(a.a)().mark(function t() {
                  var n, r, c, i, o, s
                  return Object(a.a)().wrap(
                    function (t) {
                      while (1) {
                        switch ((t.prev = t.next)) {
                          case 0:
                            return (
                              console.info(
                                '对象函数 getDeviceIntercept,filePath:renderer/views/Boot.vue'
                              ),
                              (t.prev = 1),
                              (t.next = 4),
                              p.nativeApi.getDeviceInfo()
                            )
                          case 4:
                            return (
                              (n = t.sent),
                              (r = n.cpuModel.lastIndexOf('(')),
                              (c = parseInt(n.cpuModel.substr(r + 1, 1))),
                              (i = Number(
                                n.totalMem.substr(0, n.totalMem.length - 1)
                              )),
                              (t.next = 10),
                              Object(u.a)({
                                coreNum: c,
                                memory: i,
                              })
                            )
                          case 10:
                            return (
                              (o = t.sent),
                              (s = o.code),
                              0 !== s &&
                              e.sendLogger(
                                '设备拦截接口code: '.concat(JSON.stringify(s))
                              ),
                              48000 == s || 48001 == s
                                ? e.$router.push({
                                  path: '/device-intercept',
                                  query: { code: s },
                                })
                                : e.initBoot(),
                              t.abrupt('return')
                            )
                          case 17:
                            ; (t.prev = 17),
                              (t.t0 = t.catch(1)),
                              e.sendLogger(
                                '设备拦截接口报错: '.concat(
                                  JSON.stringify(t.t0)
                                ),
                                'error'
                              ),
                              e.initBoot()
                          case 21:
                          case 'end':
                            return t.stop()
                        }
                      }
                    },
                    t,
                    null,
                    [[1, 17]]
                  )
                })
              )()
            },
            sendLogger: function (e) {
              var t =
                arguments.length > 1 && void 0 !== arguments[1]
                  ? arguments[1]
                  : 'info'
              d.a.send({
                tag: 'bootApp',
                content: { msg: e },
                level: t,
              })
            },
          },
        },
        b = l,
        f = (n('3782'), n('2877')),
        h = Object(f.a)(b, r, c, false, null, '68bb5433', null)
      t.default = h.exports
    },
    bc13: function (e, t, n) {
      'use strict'
      n.d(t, 'b', function () {
        return a
      })
      n.d(t, 'c', function () {
        return i
      })
      n.d(t, 'a', function () {
        return o
      })
      var r = n('c7eb'),
        c = n('1da1'),
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
        o = (function () {
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
    c66c: function (e, t, n) { },
  },
])
