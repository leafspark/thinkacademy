; (window.webpackJsonp = window.webpackJsonp || []).push([
  ['chunk-5173cda2'],
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
        return h
      })
      var c = n('c7eb'),
        a = n('1da1'),
        r = (n('caad'), n('2532'), n('02fc')),
        i = n('bc8a'),
        o = n('35ac'),
        s = n('d0db'),
        u = function (e, t) {
          var n =
            arguments.length > 2 && void 0 !== arguments[2]
              ? arguments[2]
              : {},
            c =
              arguments.length > 3 && void 0 !== arguments[3]
                ? arguments[3]
                : 'error'
          s.a.send({
            tag: 'http',
            level: c,
            content: {
              msg: e,
              err: t,
              params: n,
            },
          })
        },
        l = (function () {
          var e = Object(a.a)(
            Object(c.a)().mark(function e() {
              var t,
                n = arguments
              return Object(c.a)().wrap(function (e) {
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
          var e = Object(a.a)(
            Object(c.a)().mark(function e() {
              var t
              return Object(c.a)().wrap(function (e) {
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
        h = (function () {
          var e = Object(a.a)(
            Object(c.a)().mark(function e() {
              var t, n, a, s, h, p, f, b, v, m, w, O, j
              return Object(c.a)().wrap(function (e) {
                while (1) {
                  switch ((e.prev = e.next)) {
                    case 0:
                      return (e.next = 2), Object(o.b)()
                    case 2:
                      return (t = e.sent), (e.next = 5), Object(r.f)()
                    case 5:
                      return (n = e.sent), (e.next = 8), d()
                    case 8:
                      if (
                        ((a = e.sent),
                          (s =
                            (null === t || void 0 === t
                              ? void 0
                              : t.timeZoneSwitchSchool) || []),
                          (h = s.includes(n)),
                          !h)
                      ) {
                        e.next = 22
                        break
                      }
                      return (
                        'manual' !== a && (a = 'geo'),
                        (e.next = 16),
                        Object(i.h)().catch(function (e) {
                          u('接口报错:时区列表:', e)
                        })
                      )
                    case 16:
                      ; (p = e.sent),
                        (f = p.code),
                        (b = p.data),
                        0 === f && Object(r.k)(b),
                        (e.next = 25)
                      break
                    case 22:
                      ; (a = 'school'),
                        window.thinkApi.ipc.send(
                          'deleteStoreValue',
                          'timezoneList'
                        ),
                        window.thinkApi.ipc.send('deleteStoreValue', 'timezone')
                    case 25:
                      return l(a), (e.next = 29), Object(r.c)()
                    case 29:
                      if (
                        ((v = e.sent),
                          (m =
                            null === t || void 0 === t ? void 0 : t.timezone[v]),
                          (w = []),
                          'geo' !== a)
                      ) {
                        e.next = 39
                        break
                      }
                      return (
                        (O = Object(r.b)()),
                        (e.next = 37),
                        Object(i.a)({ timezone: O })
                      )
                    case 37:
                      ; (j = e.sent),
                        j &&
                        0 === j.code &&
                        j.data &&
                        (0 === j.data.invalid
                          ? (m = O)
                          : (w = ['setting.timezone.invalidMsg', m]))
                    case 39:
                      return (
                        'manual' !== a && Object(r.j)(m),
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
    '61ea': function (e, t, n) {
      'use strict'
      n.r(t)
      var c = function () {
        var e = this,
          t = e._self._c
        return t(
          'div',
          { staticClass: 'page-local-setting' },
          [
            t('Toolbar', {
              attrs: {
                transparent: true,
                fixed: true,
                disabledMaximize: true,
              },
            }),
            t('div', { staticClass: 'wrapper' }, [
              t('div', { staticClass: 'title' }, [e._v(e._s(e.chooseTitle))]),
              t('div', { staticClass: 'description' }, [
                e._v(' ' + e._s(e.chooseDesc) + ' '),
              ]),
              t(
                'div',
                { staticClass: 'choose-items' },
                [
                  e._l(e.localList, function (n, c) {
                    return [
                      n.schoolForCustomerEnabled
                        ? t(
                          'div',
                          {
                            key: c,
                            staticClass: 'item',
                            class: [
                              { active: n.schoolSimplifyName === e.local },
                            ],
                            on: {
                              click: function (t) {
                                return e.handleItem(n)
                              },
                            },
                          },
                          [
                            t('div', { staticClass: 'item-name' }, [
                              t('div', { staticClass: 'country-flag' }, [
                                t('img', {
                                  attrs: { src: n.schoolIconUrl },
                                }),
                              ]),
                              t('div', { staticClass: 'country-name' }, [
                                e._v(' ' + e._s(n.schoolName) + ' '),
                              ]),
                            ]),
                          ]
                        )
                        : e._e(),
                    ]
                  }),
                ],
                2
              ),
            ]),
            t('div', { staticClass: 'choose-button' }, [
              t('div', {
                staticClass: 'button',
                class: [{ disabled: !e.localCode }],
                on: { click: e.handleOk },
              }),
            ]),
          ],
          1
        )
      },
        a = [],
        r = n('c7eb'),
        i = n('1da1'),
        o = (n('14d9'), n('dfa8')),
        s = n('02fc'),
        u = n('bc13'),
        l = n('40f6'),
        d = n('35ac'),
        h = n('d19c'),
        p = n('3898'),
        f = {
          name: 'LocalSetting',
          components: { Toolbar: o.a },
          data: function () {
            return {
              localList: Object(d.c)('campusConfig') || [],
              local: '',
              localCode: '',
              chooseTitle: 'Choose an education system',
              chooseDesc:
                'Please choose the education system that you want your child to follow.',
            }
          },
          methods: {
            handleItem: function (e) {
              console.info(
                '对象函数 handleItem(item)',
                e,
                'filePath:renderer/views/LocalSetting.vue'
              )
              var t = e.schoolSimplifyName,
                n = e.schoolISOStandardlanguageCode
              'hk' == t
                ? ((this.chooseTitle = '選擇教育體系'),
                  (this.chooseDesc =
                    '選擇適合您孩子的教育體系\uFF0C為您推薦相應課程'))
                : 'tmc' == t
                  ? ((this.chooseTitle = '选择教育体系'),
                    (this.chooseDesc =
                      '选择适合您孩子的教育体系\uFF0C为您推荐相应课程'))
                  : ((this.chooseTitle = 'Choose an education system'),
                    (this.chooseDesc =
                      'Please choose the education system that you want your child to follow.'))
              this.local = t
              this.localCode = t
              Object(h.c)(n)
              Object(p.c)()
            },
            handleOk: function () {
              var e = this
              return Object(i.a)(
                Object(r.a)().mark(function t() {
                  var n
                  return Object(r.a)().wrap(function (t) {
                    while (1) {
                      switch ((t.prev = t.next)) {
                        case 0:
                          if (
                            (console.info(
                              '对象函数 handleOk,filePath:renderer/views/LocalSetting.vue'
                            ),
                              e.local)
                          ) {
                            t.next = 4
                            break
                          }
                          return (
                            console.info(
                              'if(!_this.local)为true触发return,path: /renderer/views/LocalSetting.vue'
                            ),
                            t.abrupt('return')
                          )
                        case 4:
                          return (t.next = 6), Object(s.i)(e.local)
                        case 6:
                          return (t.next = 8), Object(u.c)()
                        case 8:
                          return (t.next = 10), Object(l.b)()
                        case 10:
                          ; (n = t.sent),
                            n && e.$Message.info(e.$t(n[0]) + n[1]),
                            e.$router.push('/login')
                        case 13:
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
        b = f,
        v = (n('7535'), n('2877')),
        m = Object(v.a)(b, c, a, false, null, '079dab60', null)
      t.default = m.exports
    },
    7535: function (e, t, n) {
      'use strict'
      n('9244')
    },
    9244: function (e, t, n) { },
    bc13: function (e, t, n) {
      'use strict'
      n.d(t, 'b', function () {
        return r
      })
      n.d(t, 'c', function () {
        return i
      })
      n.d(t, 'a', function () {
        return o
      })
      var c = n('c7eb'),
        a = n('1da1'),
        r = (function () {
          var e = Object(a.a)(
            Object(c.a)().mark(function e() {
              return Object(c.a)().wrap(function (e) {
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
          var e = Object(a.a)(
            Object(c.a)().mark(function e() {
              return Object(c.a)().wrap(function (e) {
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
          var e = Object(a.a)(
            Object(c.a)().mark(function e() {
              var t
              return Object(c.a)().wrap(function (e) {
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
