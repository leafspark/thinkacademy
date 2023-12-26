;(function (e) {
  function t(t) {
    for (
      var s, o, r = t[0], c = t[1], l = t[2], d = 0, u = [];
      d < r.length;
      d++
    ) {
      o = r[d]
      Object.prototype.hasOwnProperty.call(a, o) && a[o] && u.push(a[o][0])
      a[o] = 0
    }
    for (s in c) Object.prototype.hasOwnProperty.call(c, s) && (e[s] = c[s])
    m && m(t)
    while (u.length) {
      u.shift()()
    }
    return i.push.apply(i, l || []), n()
  }
  function n() {
    for (var e, t = 0; t < i.length; t++) {
      for (var n = i[t], s = true, o = 1; o < n.length; o++) {
        var r = n[o]
        0 !== a[r] && (s = false)
      }
      s && (i.splice(t--, 1), (e = c((c.s = n[0]))))
    }
    return e
  }
  var s = {},
    i = []
  function r(e) {
    return (
      c.p +
      'static/js/' +
      ({}[e] || e) +
      '.' +
      {
        'chunk-0935393e': 'e9f7d581',
        'chunk-09d4164c': '50c8114a',
        'chunk-0b480b94': 'f1c54200',
        'chunk-14a97d99': 'fd3f9688',
        'chunk-74ddfa26': 'c1f47ab5',
        'chunk-16c075d8': '70eae4d1',
        'chunk-1c3482b2': 'd9016fdb',
        'chunk-271490e8': '5cf3baa4',
        'chunk-2e9cf93e': 'd01b997d',
        'chunk-2ec16a41': '0c553de0',
        'chunk-3d75fc56': '4e5265e6',
        'chunk-4cfb0224': '33aaacdb',
        'chunk-5125c77c': '3d49a1c2',
        'chunk-21cb9dbc': '691d8a8c',
        'chunk-6e54407c': '95b46345',
        'chunk-6fa24106': '0852af73',
        'chunk-7f66cf6e': '0a47586e',
        'chunk-9c37b028': 'f10c61d2',
        'chunk-9c43f55c': 'a9eebaa9',
        'chunk-0c3f1dd4': 'b6934393',
        'chunk-2d0d67ce': '9fe70b65',
        'chunk-d5156d36': 'd0a12b00',
        'chunk-f823038e': 'a378e45e',
      }[e] +
      '.js'
    )
  }
  function c(t) {
    if (s[t]) {
      return s[t].exports
    }
    var n = (s[t] = {
      i: t,
      l: false,
      exports: {},
    })
    return e[t].call(n.exports, n, n.exports, c), (n.l = true), n.exports
  }
  c.e = function (e) {
    var t = []
    o[e]
      ? t.push(o[e])
      : 0 !== o[e] &&
        n[e] &&
        t.push(
          (o[e] = new Promise(function (t, n) {
            for (
              var s =
                  'static/css/' +
                  ({}[e] || e) +
                  '.' +
                  {
                    'chunk-0935393e': '66194496',
                    'chunk-09d4164c': 'd95d103b',
                    'chunk-0b480b94': '47948cdd',
                    'chunk-14a97d99': 'a4c2b5ac',
                    'chunk-74ddfa26': '31d6cfe0',
                    'chunk-16c075d8': 'dc899aec',
                    'chunk-1c3482b2': '573c2743',
                    'chunk-271490e8': 'dcf6c5b9',
                    'chunk-2e9cf93e': '31d6cfe0',
                    'chunk-2ec16a41': 'c08f8ea4',
                    'chunk-3d75fc56': '9282e18c',
                    'chunk-4cfb0224': '8111d05f',
                    'chunk-5125c77c': 'd1738e4f',
                    'chunk-21cb9dbc': 'b2c05241',
                    'chunk-6e54407c': '0722f961',
                    'chunk-6fa24106': '0ac66689',
                    'chunk-7f66cf6e': '6624d027',
                    'chunk-9c37b028': '98858406',
                    'chunk-9c43f55c': '442c9dd5',
                    'chunk-0c3f1dd4': '6b5b13bd',
                    'chunk-2d0d67ce': '31d6cfe0',
                    'chunk-d5156d36': '21154e7f',
                    'chunk-f823038e': 'c56cd55f',
                  }[e] +
                  '.css',
                a = c.p + s,
                i = document.getElementsByTagName('link'),
                r = 0;
              r < i.length;
              r++
            ) {
              var l = i[r],
                d = l.getAttribute('data-href') || l.getAttribute('href')
              if ('stylesheet' === l.rel && (d === s || d === a)) {
                return t()
              }
            }
            var u = document.getElementsByTagName('style')
            for (r = 0; r < u.length; r++) {
              l = u[r]
              d = l.getAttribute('data-href')
              if (d === s || d === a) {
                return t()
              }
            }
            var m = document.createElement('link')
            m.rel = 'stylesheet'
            m.type = 'text/css'
            m.onload = t
            m.onerror = function (t) {
              var s = (t && t.target && t.target.src) || a,
                i = new Error(
                  'Loading CSS chunk ' + e + ' failed.\n(' + s + ')'
                )
              i.code = 'CSS_CHUNK_LOAD_FAILED'
              i.request = s
              delete o[e]
              m.parentNode.removeChild(m)
              n(i)
            }
            m.href = a
            var h = document.getElementsByTagName('head')[0]
            h.appendChild(m)
          }).then(function () {
            o[e] = 0
          }))
        )
    var s = a[e]
    if (0 !== s) {
      if (s) {
        t.push(s[2])
      } else {
        var i = new Promise(function (t, n) {
          s = a[e] = [t, n]
        })
        t.push((s[2] = i))
        var l,
          d = document.createElement('script')
        d.charset = 'utf-8'
        d.timeout = 120
        c.nc && d.setAttribute('nonce', c.nc)
        d.src = r(e)
        var u = new Error()
        l = function (t) {
          d.onerror = d.onload = null
          clearTimeout(m)
          var n = a[e]
          if (0 !== n) {
            if (n) {
              var s = t && ('load' === t.type ? 'missing' : t.type),
                o = t && t.target && t.target.src
              u.message =
                'Loading chunk ' + e + ' failed.\n(' + s + ': ' + o + ')'
              u.name = 'ChunkLoadError'
              u.type = s
              u.request = o
              n[1](u)
            }
            a[e] = void 0
          }
        }
        var m = setTimeout(function () {
          l({
            type: 'timeout',
            target: d,
          })
        }, 120000)
        d.onerror = d.onload = l
        document.head.appendChild(d)
      }
    }
    return Promise.all(t)
  }
  c.m = e
  c.c = s
  c.d = function (e, t, n) {
    c.o(e, t) ||
      Object.defineProperty(e, t, {
        enumerable: true,
        get: n,
      })
  }
  c.r = function (e) {
    'undefined' !== typeof Symbol &&
      Symbol.toStringTag &&
      Object.defineProperty(e, Symbol.toStringTag, { value: 'Module' })
    Object.defineProperty(e, '__esModule', { value: true })
  }
  c.t = function (e, t) {
    if ((1 & t && (e = c(e)), 8 & t)) {
      return e
    }
    if (4 & t && 'object' === typeof e && e && e.__esModule) {
      return e
    }
    var n = Object.create(null)
    if (
      (c.r(n),
      Object.defineProperty(n, 'default', {
        enumerable: true,
        value: e,
      }),
      2 & t && 'string' != typeof e)
    ) {
      for (var s in e)
        c.d(
          n,
          s,
          function (t) {
            return e[t]
          }.bind(null, s)
        )
    }
    return n
  }
  c.n = function (e) {
    var t =
      e && e.__esModule
        ? function () {
            return e.default
          }
        : function () {
            return e
          }
    return c.d(t, 'a', t), t
  }
  c.o = function (e, t) {
    return Object.prototype.hasOwnProperty.call(e, t)
  }
  c.p = '/'
  c.oe = function (e) {
    throw (console.error(e), e)
  }
  var l = (window.webpackJsonp = window.webpackJsonp || []),
    d = l.push.bind(l)
  l.push = t
  l = l.slice()
  for (var u = 0; u < l.length; u++) {
    t(l[u])
  }
  var m = d
  i.push([5, 'chunk-vendors', 'chunk-common'])
  n()
})({
  0: function (e, t) {},
  '022e': function (e, t, n) {
    'use strict'
    n('4c4f')
  },
  '03bb': function (e, t) {
    e.exports =
      'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACgAAAAoCAMAAAC7IEhfAAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAABCUExURUdwTP8yMv9OPP9NPv9QPP9QRP9MPv9OPv9OPf9OPP9MPP9QQv9QPv////9gUv+bkf/Z1f90Zv/z8/+tp/+JfP+/uQdkbLEAAAAMdFJOUwAE01frFpf5gLHjNuGC4G8AAAEJSURBVDjLlZXrDoMwCIWr9kIVW93l/V91Ysw2Ck52/piQL6XAKTrHNEHufUq+zzC5UwUYMSXctX1GCDoWD+ajFBV08KjIDw3WRTxR7BiX8VS5s3GMjPhT8V0Hj5daC48cFQVeb7nN842TPmiJn/Omp5I8NH1eCFyaztORgNcgwlb5iNepcdz80jbjTuC9jU4isw4mcGIolcAqxuP6NvQg8NFGe+dtoHfCrSuBq/CwBAuBRYLS2IvsN6UWxSju2YvJaFHKDpKJBDlCPfUkTbGScVdpis5mM8W48y7FuO1T0E6M2uNS7ng8LvNztS8A+0oxLyn72rMv0j9W87Hsv+d7suzppvz3wW73AuO2O5X1jG6cAAAAAElFTkSuQmCC'
  },
  '07d1': function (e, t, n) {},
  '09ea': function (e, t, n) {},
  '0a05': function (e, t) {
    e.exports = require('constants')
  },
  '0be0': function (e, t, n) {
    'use strict'
    n('44ca')
  },
  '0c1b': function (e, t, n) {
    'use strict'
    n('9044')
  },
  '0ee1': function (e, t, n) {
    'use strict'
    n('8474')
  },
  1: function (e, t) {},
  '10e6': function (e, t, n) {},
  1174: function (e, t, n) {
    'use strict'
    var s = n('5e27'),
      o = n.n(s)
    t.default = o.a
  },
  '139c': function (e, t, n) {
    'use strict'
    n.d(t, 'a', function () {
      return v
    })
    var s = n('c7eb'),
      o = n('1da1'),
      a = n('d4ec'),
      i = n('bee2'),
      r = (n('99af'), n('d3b7'), n('159b'), n('caad'), n('2532'), n('0a4b')),
      c = n('c1df'),
      l = n.n(c),
      d = n('d0db'),
      u = n('e39c'),
      m = n('d202'),
      h = n('9b0f'),
      f = n('a32b'),
      p = n('e4ec')
    window._isUploadingNativeLogs = false
    var v = (function () {
      function e() {
        var t =
          arguments.length > 0 && void 0 !== arguments[0] ? arguments[0] : {}
        Object(a.a)(this, e)
        this.userId = t.userId
        this.uploadFolderName = ['agora', 'logs']
      }
      return (
        Object(i.a)(e, [
          {
            key: 'upload',
            value: (function () {
              var e = Object(o.a)(
                Object(s.a)().mark(function e(t) {
                  var n,
                    o,
                    a,
                    i,
                    c,
                    l,
                    d = this
                  return Object(s.a)().wrap(
                    function (e) {
                      while (1) {
                        switch ((e.prev = e.next)) {
                          case 0:
                            if (!window._isUploadingNativeLogs) {
                              e.next = 3
                              break
                            }
                            return (
                              console.warn(
                                '本地日志正在上传中:',
                                window._isUploadingNativeLogs
                              ),
                              e.abrupt('return')
                            )
                          case 3:
                            return (
                              (e.next = 5),
                              r.nativeApi.getPathByName('userData')
                            )
                          case 5:
                            if (
                              ((n = e.sent),
                              (o = ''.concat(n, '/Logs')),
                              (a = ''.concat(n, '/uploadLogs')),
                              o)
                            ) {
                              e.next = 12
                              break
                            }
                            return (
                              this.sendLogger('本地日志目录不存在'),
                              null === t ||
                                void 0 === t ||
                                null === (i = t.fail) ||
                                void 0 === i ||
                                i.call(t),
                              e.abrupt('return')
                            )
                          case 12:
                            return (
                              !Object(h.existsSync)(a) &&
                                Object(h.mkdirSync)(a),
                              Object(h.existsSync)(''.concat(o, '/logs')) &&
                                Object(u.g)(''.concat(o, '/logs')),
                              this.deleteLogs(o),
                              (c = new Date().getTime()),
                              this.copyLogs(o),
                              (e.next = 19),
                              this.zipFile(o, a)
                            )
                          case 19:
                            this.sendLogger(
                              '日志压缩耗时 '.concat(new Date().getTime() - c)
                            ),
                              (l = 'pcStudentLog/'.concat(this.userId)),
                              this.sendLogger(
                                '压缩logs文件夹所在目录'.concat(a)
                              ),
                              (window._isUploadingNativeLogs = true),
                              new m.a().upload({
                                uploadFolder: l,
                                uploadPath: a,
                                success: function (e) {
                                  var n
                                  d.sendLogger(
                                    '本地日志上传成功, res: '.concat(
                                      JSON.stringify(e)
                                    )
                                  )
                                  null === t ||
                                    void 0 === t ||
                                    null === (n = t.success) ||
                                    void 0 === n ||
                                    n.call(t, e)
                                },
                                fail: function (e) {
                                  var n
                                  d.sendLogger(
                                    '本地日志上传失败, res: '.concat(
                                      JSON.stringify(e)
                                    )
                                  )
                                  null === t ||
                                    void 0 === t ||
                                    null === (n = t.fail) ||
                                    void 0 === n ||
                                    n.call(t, e)
                                },
                                final: function () {
                                  var e
                                  d.sendLogger(
                                    '本地日志上传完成 uploadPath:'
                                      .concat(a, ' existsSync:')
                                      .concat(Object(h.existsSync)(a))
                                  )
                                  Object(h.existsSync)(''.concat(o, '/logs')) &&
                                    Object(u.g)(''.concat(o, '/logs'))
                                  Object(h.existsSync)(a) && Object(u.g)(a)
                                  window._isUploadingNativeLogs = false
                                  null === t ||
                                    void 0 === t ||
                                    null === (e = t.final) ||
                                    void 0 === e ||
                                    e.call(t)
                                },
                              })
                          case 24:
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
                return e.apply(this, arguments)
              }
              return t
            })(),
          },
          {
            key: 'copyLogs',
            value: function (e) {
              var t = l()().format('MM-DD'),
                n = ''.concat(e, '/logs')
              try {
                !Object(h.existsSync)(n) && Object(h.mkdirSync)(n)
              } catch (s) {
                console.error('copyLogs', s)
              }
              try {
                Object(h.readdirSync)(e).forEach(function (s) {
                  var o = Object(f.join)(e, s),
                    a = Object(h.statSync)(o)
                  Object(h.statSync)(o).isFile() &&
                    l()(a.mtime).format('MM-DD') == t &&
                    Object(h.writeFileSync)(
                      ''.concat(n, '/').concat(s),
                      Object(h.readFileSync)(o)
                    )
                })
              } catch (o) {
                this.sendLogger(
                  'copy日志报错, err: '.concat(JSON.stringify(o)),
                  'error'
                )
              }
            },
          },
          {
            key: 'zipFile',
            value: (function () {
              var e = Object(o.a)(
                Object(s.a)().mark(function e(t, n) {
                  var a,
                    i = this
                  return Object(s.a)().wrap(
                    function (e) {
                      while (1) {
                        switch ((e.prev = e.next)) {
                          case 0:
                            a = l()().format('YYYYMMDD')
                            try {
                              Object(h.readdirSync)(t).forEach(
                                (function () {
                                  var e = Object(o.a)(
                                    Object(s.a)().mark(function e(o) {
                                      var r, c
                                      return Object(s.a)().wrap(function (e) {
                                        while (1) {
                                          switch ((e.prev = e.next)) {
                                            case 0:
                                              if (
                                                ((r = Object(f.join)(t, o)),
                                                !i.uploadFolderName.includes(
                                                  o
                                                ) ||
                                                  !Object(h.statSync)(
                                                    r
                                                  ).isDirectory())
                                              ) {
                                                e.next = 5
                                                break
                                              }
                                              return (
                                                (c = ''
                                                  .concat(n, '/')
                                                  .concat(i.userId, '-')
                                                  .concat(a, '-')
                                                  .concat(o, '-')
                                                  .concat(
                                                    new Date().getTime(),
                                                    '.zip'
                                                  )),
                                                (e.next = 5),
                                                p.zip
                                                  .compressDir(r, c)
                                                  .catch(function (e) {
                                                    i.sendLogger(
                                                      '本地日志压缩失败, res: '
                                                        .concat(
                                                          JSON.stringify(e),
                                                          ', curPath: '
                                                        )
                                                        .concat(r),
                                                      'error'
                                                    )
                                                  })
                                              )
                                            case 5:
                                            case 'end':
                                              return e.stop()
                                          }
                                        }
                                      }, e)
                                    })
                                  )
                                  return function (t) {
                                    return e.apply(this, arguments)
                                  }
                                })()
                              )
                            } catch (r) {
                              this.sendLogger(
                                '压缩日志报错, res: '.concat(JSON.stringify(r)),
                                'error'
                              )
                            }
                          case 2:
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
              function t(t, n) {
                return e.apply(this, arguments)
              }
              return t
            })(),
          },
          {
            key: 'deleteFiles',
            value: function (e) {
              var t = Object(h.statSync)(e),
                n = new Date().getTime()
              n - t.birthtimeMs >= 1209600000 && Object(h.unlinkSync)(e)
            },
          },
          {
            key: 'deleteLogs',
            value: (function () {
              var e = Object(o.a)(
                Object(s.a)().mark(function e(t) {
                  var n = this
                  return Object(s.a)().wrap(
                    function (e) {
                      while (1) {
                        switch ((e.prev = e.next)) {
                          case 0:
                            try {
                              Object(h.readdirSync)(t).forEach(function (e) {
                                var s = Object(f.join)(t, e)
                                Object(h.statSync)(s).isDirectory()
                                  ? n.sendLogger(
                                      '声网agora日志不用删除\uFF0C声网有自己删除逻辑'
                                    )
                                  : n.deleteFiles(s)
                              })
                            } catch (s) {
                              this.sendLogger(
                                '删除本地日志报错, res: '.concat(
                                  JSON.stringify(s)
                                ),
                                'error'
                              )
                            }
                          case 1:
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
                return e.apply(this, arguments)
              }
              return t
            })(),
          },
          {
            key: 'sendLogger',
            value: function (e) {
              var t =
                arguments.length > 1 && void 0 !== arguments[1]
                  ? arguments[1]
                  : 'info'
              d.a.send({
                tag: 'logUploadS3',
                content: { msg: e },
                level: t,
              })
            },
          },
        ]),
        e
      )
    })()
  },
  '14c2': function (e, t) {
    e.exports = require('zlib')
  },
  '17c8': function (e, t, n) {},
  '1bd1': function (e, t, n) {
    'use strict'
    n('761b')
  },
  '1c10': function (e, t, n) {
    'use strict'
    n('e9b8')
  },
  '1ed9': function (e, t, n) {},
  2: function (e, t) {},
  '230e': function (e, t, n) {
    'use strict'
    var s = n('8bbf'),
      o = n.n(s),
      a = function () {
        var e = this,
          t = e._self._c
        return t('transition', { on: { 'after-leave': e.handleAfterLeave } }, [
          t(
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
              staticClass: 'ne-tips',
              attrs: { id: 'toast_' + e.uuid },
            },
            [
              t('div', { staticClass: 'ne-tips__content' }, [
                e.msg
                  ? t('p', {
                      staticClass: 'ne-tips__content--text',
                      domProps: { textContent: e._s(e.msg) },
                    })
                  : e._e(),
              ]),
            ]
          ),
        ])
      },
      i = [],
      r =
        (n('d3b7'),
        n('25f0'),
        n('a9e3'),
        {
          name: 'NeTips',
          data: function () {
            return { uuid: Math.random().toString(36).substring(3, 20) }
          },
          props: {
            msg: {
              type: [String, Number],
              default: '',
            },
            duration: {
              type: Number,
              default: 3000,
            },
            callback: Function,
            visible: Boolean,
          },
          beforeDestroy: function () {
            console.info(
              '对象函数 beforeDestroy,filePath:renderer/components/Classroom/CommonInteractions/collectiveSpeech/components/tips/main.vue'
            )
            this.$_timer && clearTimeout(this.$_timer)
            this.visible && this.closeTips()
          },
          methods: {
            handleAfterLeave: function () {
              var e, t
              console.info(
                '对象函数 handleAfterLeave,filePath:renderer/components/Classroom/CommonInteractions/collectiveSpeech/components/tips/main.vue'
              )
              this.$destroy(true)
              null === (e = this.$el) ||
                void 0 === e ||
                null === (t = e.parentNode) ||
                void 0 === t ||
                t.removeChild(this.$el)
              'function' == typeof this.callback && this.callback()
            },
            fire: function () {
              var e = this
              console.info(
                '对象函数 fire,filePath:renderer/components/Classroom/CommonInteractions/collectiveSpeech/components/tips/main.vue'
              )
              this.$_timer && clearTimeout(this.$_timer)
              this.visible &&
                this.duration > 0 &&
                (this.$_timer = setTimeout(function () {
                  e.closeTips()
                }, this.duration))
            },
            showTips: function () {
              console.info(
                '对象函数 showTips,filePath:renderer/components/Classroom/CommonInteractions/collectiveSpeech/components/tips/main.vue'
              )
              this.visible = true
              this.fire()
            },
            closeTips: function () {
              console.info(
                '对象函数 closeTips,filePath:renderer/components/Classroom/CommonInteractions/collectiveSpeech/components/tips/main.vue'
              )
              this.visible = false
              this.handleAfterLeave()
            },
          },
        }),
      c = r,
      l = (n('e80a'), n('2877')),
      d = Object(l.a)(c, a, i, false, null, '7ff65c7c', null),
      u = d.exports,
      m = function e(t) {
        var n = t.msg,
          s = void 0 === n ? '' : n,
          a = t.duration,
          i = void 0 === a ? 3000 : a,
          r = t.callback,
          c = void 0 === r ? null : r,
          l = t.parentNode,
          d =
            void 0 === l
              ? document.getElementById('collectiveSpeechContainer')
              : l
        console.info(
          '箭头函数 Tips(msg, duration, callback, parentNode)',
          s,
          i,
          c,
          d,
          'filePath:renderer/components/Classroom/CommonInteractions/collectiveSpeech/components/tips/index.js'
        )
        var m = e._instance,
          h = o.a.extend(u)
        return (
          (m = e._instance =
            new h({
              propsData: {
                msg: s,
                duration: i,
                callback: c,
              },
            }).$mount()),
          m.$el.parentNode || d.appendChild(m.$el),
          (m.msg = s),
          (m.duration = i),
          (m.callback = c),
          m.showTips(),
          m
        )
      }
    m._instance = null
    m.close = function () {
      var e = o.a.extend(u)
      m._instance instanceof e && m._instance.visible && m._instance.closeTips()
    }
    m.tips = function () {
      var e =
          arguments.length > 0 && void 0 !== arguments[0] ? arguments[0] : '',
        t =
          arguments.length > 1 && void 0 !== arguments[1] ? arguments[1] : 3000,
        n =
          arguments.length > 2 && void 0 !== arguments[2] ? arguments[2] : null
      return m({
        msg: e,
        duration: t,
        callback: n,
      })
    }
    m.component = u
    t.a = m
  },
  '233d': function (e, t, n) {
    e.exports = n.p + 'static/img/icon_flower_r.5dab610e.png'
  },
  '266ff': function (e, t, n) {
    'use strict'
    n('3abc')
  },
  '270c': function (e, t, n) {
    'use strict'
    n.d(t, 'a', function () {
      return g
    })
    var s = n('d4ec'),
      o = n('bee2'),
      a = n('c7eb'),
      i = n('1da1'),
      r = n('5530'),
      c = n('262e'),
      l = n('2caf'),
      d =
        (n('99af'),
        n('d3b7'),
        n('159b'),
        n('caad'),
        n('2532'),
        n('a15b'),
        n('a434'),
        n('7db0'),
        n('a9e3'),
        n('a9a6')),
      m = n('5e36'),
      h = n('612a'),
      f = n('d0db'),
      p = n('8c9b'),
      v = n('e417'),
      C = (function (e) {
        Object(c.a)(n, e)
        var t = Object(l.a)(n)
        function n() {
          var e,
            o =
              arguments.length > 0 && void 0 !== arguments[0]
                ? arguments[0]
                : {}
          Object(s.a)(this, n)
          e = t.call(this)
          var a = o.planId,
            i = o.businessId,
            r = o.userId,
            c = o.isAudition,
            l = o.ircOptions
          e.ircHaveStartSensor = false
          e.timeOut = 5
          e.ircTimer = null
          e.planId = a
          e.businessId = i
          e.userId = r
          e.isAudition = c
          e.ircOptions = l || {}
          e.liveInfo = {}
          e.inRoom = false
          e.chatInstance = null
          try {
            e.triggerTimeMap = localStorage.getItem('triggerTimeMap')
              ? JSON.parse(localStorage.getItem('triggerTimeMap'))
              : {}
          } catch (d) {
            console.error('triggerTimeMap报错', d)
            e.triggerTimeMap = {}
          }
          return e._initChat(), e._listener(), e
        }
        return (
          Object(o.a)(n, [
            {
              key: 'beginTimer',
              value: function () {
                var e = this
                this.ircTimer = setTimeout(function () {
                  e.emit('showNotification', '402')
                }, 1000 * this.timeOut)
              },
            },
            {
              key: 'endTimer',
              value: function () {
                this.emit('closeNotification', '402')
                clearTimeout(this.ircTimer)
                this.ircTimer = null
              },
            },
            {
              key: 'initSdk',
              value: function () {
                var e = this.ircOptions,
                  t = e.appId,
                  n = e.appKey,
                  s = e.nickname,
                  o = e.location
                this.liveInfo = {
                  nickname: s,
                  businessId: this.businessId,
                  classId: '0',
                  liveId: String(this.planId),
                  location: o || 'China',
                }
                var a = window.TalMsgClient,
                  i = new a(t, 'v3.2.1')
                window.ChatClient = this.chatInstance = i.getInstance(1)
                var r = this.chatInstance.init(t, n)
                return (
                  this.sendLogger(
                    'irc 调用初始化方法,code: '
                      .concat(r, ',appId:')
                      .concat(t, ',appKey:')
                      .concat(n),
                    {},
                    0 == r ? 'info' : 'error'
                  ),
                  Object(v.c)({
                    result: 'start',
                    liveInfo: this.liveInfo,
                  }),
                  (this.ircHaveStartSensor = true),
                  r
                )
              },
            },
            {
              key: 'setLiveInfo',
              value: function () {
                var e = this.chatInstance.setLiveInfo(this.liveInfo)
                return (
                  this.sendLogger(
                    'irc 设置直播信息,code:'.concat(e),
                    this.liveInfo,
                    0 == e ? 'info' : 'error'
                  ),
                  e
                )
              },
            },
            {
              key: 'setSdkProperties',
              value: function () {
                var e = this.ircOptions,
                  t = e.confService,
                  n = e.logService,
                  s = {
                    confService: {
                      hostname: t.hostname,
                      url: t.url,
                      protocol: t.protocol,
                    },
                    logService: {
                      hostname: n.hostname,
                      url: n.url,
                      protocol: n.protocol,
                    },
                  },
                  o = this.chatInstance.setSdkProperties(s)
                return (
                  this.sendLogger(
                    'irc 设置sdk配置信息,code:'.concat(JSON.stringify(o)),
                    s,
                    0 == o ? 'info' : 'error'
                  ),
                  o
                )
              },
            },
            {
              key: 'joinRoom',
              value: function () {
                var e = this.chatInstance.RoomChatManager,
                  t = e.joinChatRoomsWithJoinMode(this.ircOptions.ircRooms, 1)
                0 === t
                  ? this.sendLogger('irc调用加入房间接口成功')
                  : (this.sendLogger(
                      'irc调用加入房间接口失败,code:'.concat(t),
                      {},
                      'error'
                    ),
                    Object(v.c)({
                      result: 'fail',
                      errorType: '调用加入房间接口失败',
                      code: t,
                      liveInfo: Object(r.a)(
                        Object(r.a)({}, this.liveInfo),
                        {},
                        { ircRooms: this.ircOptions.ircRooms }
                      ),
                    }))
              },
            },
            {
              key: '_initChat',
              value: function () {
                var e = this.initSdk()
                if (e === 0) {
                  var t = this.setLiveInfo()
                  if (0 == t) {
                    var n = this.setSdkProperties()
                    0 == n
                      ? this.ircLogin()
                      : Object(v.c)({
                          result: 'fail',
                          errorType: '设置配置信息失败',
                          code: n,
                          liveInfo: this.liveInfo,
                        })
                  } else {
                    Object(v.c)({
                      result: 'fail',
                      errorType: '设置直播信息失败',
                      code: t,
                      liveInfo: this.liveInfo,
                    })
                  }
                } else {
                  Object(v.c)({
                    result: 'fail',
                    errorType: '初始化失败',
                    code: e,
                    liveInfo: this.liveInfo,
                  })
                }
              },
            },
            {
              key: 'ircLogin',
              value: function () {
                var e = this.chatInstance.loginWithMode(
                  this.userId,
                  this.userId,
                  0
                )
                0 == e
                  ? (this.beginTimer(), this.sendLogger('irc调用登陆方法成功'))
                  : (this.sendLogger(
                      'irc调用登录接口失败,code:'.concat(e),
                      this.ircOptions,
                      'error'
                    ),
                    Object(v.c)({
                      result: 'fail',
                      errorType: '调用登录接口失败',
                      code: e,
                      liveInfo: this.liveInfo,
                    }))
              },
            },
            {
              key: '_listener',
              value: (function () {
                var e = Object(i.a)(
                  Object(a.a)().mark(function e() {
                    return Object(a.a)().wrap(
                      function (e) {
                        while (1) {
                          switch ((e.prev = e.next)) {
                            case 0:
                              this._chatListener(),
                                this._roomListener(),
                                this._peerListener()
                            case 3:
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
                function t() {
                  return e.apply(this, arguments)
                }
                return t
              })(),
            },
            {
              key: '_chatListener',
              value: function () {
                var e = this,
                  t = this.chatInstance.RoomChatManager
                this.chatInstance.on('onLoginResponse', function (t) {
                  var n = t.code
                  '[hw_irc_join_room]触发登陆回调'.concat(n)
                  n == 0
                    ? e.inRoom
                      ? console.warn('当前已在irc房间中\uFF0C无需重复加入')
                      : (e.joinRoom(), e.sendLogger('irc 登陆回调返回成功'))
                    : (e.sendLogger('irc 登陆回调返回失败', t, 'error'),
                      Object(v.c)({
                        result: 'fail',
                        errorType: '登录失败',
                        code: n,
                        liveInfo: e.liveInfo,
                      }))
                })
                t.on('onJoinRoomResponse', function (n) {
                  '[hw_irc_join_room]触发加入房间回调'.concat(n.code)
                  0 == n.code
                    ? ((e.inRoom = true),
                      e.endTimer(),
                      h.a.dispatch('smallClass/updateIrcStatus', true),
                      e.emit('ready', true),
                      t.getAllRoomData(e.ircOptions.ircRooms[0]),
                      t.getRoomHistoryMessage(e.ircOptions.ircRooms[0], 0),
                      e.sendLogger('irc 加入房间回调成功'),
                      Object(v.c)({
                        result: 'success',
                        liveInfo: e.liveInfo,
                      }))
                    : (e.sendLogger('irc 加入房间回调失败', n, 'error'),
                      Object(v.c)({
                        result: 'fail',
                        errorType: '加入房间失败',
                        code: n.code,
                        liveInfo: e.liveInfo,
                      }))
                })
                this.chatInstance.on('onLogoutNotice', function (t) {
                  e.sendLogger('irc 频道内人员退出:'.concat(JSON.stringify(t)))
                  var n = t.code
                  n == 0 && e.emit('logoutSuccess')
                })
                this.chatInstance.on(
                  'onNetStatusChanged',
                  (function () {
                    var t = Object(i.a)(
                      Object(a.a)().mark(function t(n) {
                        var s, o
                        return Object(a.a)().wrap(function (t) {
                          while (1) {
                            switch ((t.prev = t.next)) {
                              case 0:
                                if (
                                  ('[hw_irc_join_room]触发网络状态回调'.concat(
                                    n.netStatus
                                  ),
                                  4 == n.netStatus)
                                ) {
                                  t.next = 15
                                  break
                                }
                                if (
                                  (e.emit('showNotification', n.netStatus),
                                  (s = {
                                    0: '未知',
                                    1: '网络不可用',
                                    2: '服务器连接失败',
                                    3: '服务器连接中',
                                    5: '服务器断开连接',
                                  }),
                                  e.sendLogger(
                                    'irc 网络状态改变,'.concat(s[n.netStatus]),
                                    {},
                                    3 == n.netStatus ? 'info' : 'error'
                                  ),
                                  0 != n.netStatus &&
                                    1 != n.netStatus &&
                                    2 != n.netStatus)
                                ) {
                                  t.next = 12
                                  break
                                }
                                return (t.next = 8), Object(p.a)()
                              case 8:
                                ;(o = t.sent),
                                  Object(v.c)({
                                    result: 'fail',
                                    errorType: '连接失败',
                                    code: n.netStatus,
                                    msg: ''.concat(o ? '有网络' : '没有网络'),
                                    liveInfo: e.liveInfo,
                                  }),
                                  (t.next = 13)
                                break
                              case 12:
                                3 == n.netStatus &&
                                  (Object(v.c)({
                                    result: 'start',
                                    liveInfo: e.liveInfo,
                                  }),
                                  (e.ircHaveStartSensor = true))
                              case 13:
                                t.next = 17
                                break
                              case 15:
                                e.emit('closeNotification', n.netStatus),
                                  e.sendLogger('irc 网络状态改变,连接成功')
                              case 17:
                                e.emit('onNetStatusChanged', n)
                              case 18:
                              case 'end':
                                return t.stop()
                            }
                          }
                        }, t)
                      })
                    )
                    return function (e) {
                      return t.apply(this, arguments)
                    }
                  })()
                )
                this.chatInstance.on('onKickoutNotice', function (t) {
                  e.sendLogger(
                    'irc 被其他客户端顶掉:'.concat(JSON.stringify(t)),
                    {},
                    'error'
                  )
                  h.a.dispatch('smallClass/updateIrcStatus', false)
                  e.emit('onKickoutNotice', t)
                })
                this.chatInstance.on(
                  'onSDKProvisionStatusNotice',
                  function (t) {
                    '[hw_irc_join_room]触发irc调度服务回调'.concat(t.status)
                    e.ircHaveStartSensor ||
                      Object(v.c)({
                        result: 'start',
                        liveInfo: e.liveInfo,
                      })
                    e.ircHaveStartSensor = false
                    0 != t.status
                      ? (e.emit('showNotification', t.status),
                        e.sendLogger('irc 连接调度服务失败', t, 'error'),
                        Object(v.c)({
                          result: 'fail',
                          errorType: '调度失败',
                          code: t.status,
                          liveInfo: e.liveInfo,
                        }))
                      : (e.emit('closeNotification', t.status),
                        e.sendLogger('irc 连接调度服务成功'))
                    e.emit('onSDKProvisionStatusNotice', t)
                  }
                )
              },
            },
            {
              key: '_roomListener',
              value: function () {
                var e = this,
                  t = this.chatInstance.RoomChatManager
                t.on('onSetRoomDataResponse', function (t) {
                  e.emit('onSetRoomDataResponse', t)
                })
                t.on('onRecvRoomBinMessageNotice', function (t) {
                  e.emit('onRecvRoomBinMessageNotice', t)
                })
                t.on('onGetRoomHistoryBinMessageNotice', function (t) {
                  e.emit('onGetRoomHistoryBinMessageNotice', t)
                })
                t.on('onRecvRoomDataUpdateNotice', function (t) {
                  var n = t.datas,
                    s = t.handler,
                    o = !s.psId && !s.nickname
                  n.forEach(function (t, n) {
                    if (e.isAudition && m.a.includes(n)) {
                      e.sendLogger('旁听课不参与互动', { key: n })
                    } else {
                      var s = JSON.parse(t.value),
                        a = s.sendTime
                      s[n]
                      var i = e.isTriggerFun(n, s),
                        r = 'boolean' == typeof s[n] ? s[n] : s[n] || s.data,
                        c = '收到KV消息('
                          .concat(o ? '历史' : '实时', ')(')
                          .concat(i ? '旧互动' : '新互动', ') => ')
                          .concat(n)
                      e.sendLogger(c, r)
                      ;(('small_random_call' != n && 'speedyHand' != n) ||
                        !i) &&
                        e.emit('onRecvRoomDataUpdateNotice', {
                          key: n,
                          isHistory: o,
                          noticeContent: r,
                          sendTime: a,
                        })
                    }
                  })
                })
                t.on('onGetRoomDataResponse', function (t) {
                  e.emit('onGetRoomDataResponse', t)
                })
                t.on('onRecvRoomMessage', function (t) {
                  var n = t.content,
                    s = t.fromUserInfo,
                    o = t.messagePriority,
                    a = t.msgId,
                    i = t.timestamp
                  e.emit('onRecvRoomMessage', {
                    content: JSON.parse(n),
                    fromUserInfo: s,
                    messagePriority: o,
                    msgId: a,
                    timestamp: i,
                  })
                  e.sendLogger('irc 收到群聊消息:'.concat(JSON.stringify(t)))
                })
                t.on('onRecvRoomTopic', function (t) {
                  e.emit('onRecvRoomTopic', t)
                })
                t.on('onGetRoomHistoryMessageResponse', function (t) {
                  e.emit('onGetRoomHistoryMessageResponse', t)
                })
                t.on('onJoinRoomNotice', function (t) {
                  e.emit('onJoinRoomNotice', t)
                })
                t.on('onRecvRoomUserList', function (t) {
                  e.emit('onRecvRoomUserList', t)
                })
                t.on('onLeaveRoomNotice', function (t) {
                  e.emit('onLeaveRoomNotice', t)
                })
                t.on('onSendRoomMessageResponse', function (t) {
                  e.emit('onSendRoomMessageResponse', t)
                  0 == t.code
                    ? Object(v.c)({
                        type: 'message',
                        result: 'success',
                        msg: '群聊',
                      })
                    : (Object(v.c)({
                        type: 'message',
                        result: 'fail',
                        errorType: '群聊消息发送失败',
                        msg: '群聊',
                        code: t.code,
                        msgInfo: t,
                      }),
                      e.sendLogger('irc 群聊消息发送失败', t, 'error'))
                })
                t.on('onRoomUserCountNotice', function (t) {
                  e.emit('onRoomUserCountNotice', t)
                })
                t.on('onSendRoomBinMessageResp', function (t) {
                  e.emit('onSendRoomBinMessageResp', t)
                  0 == t.code
                    ? Object(v.c)({
                        type: 'message',
                        result: 'success',
                        msg: '群聊二进制',
                      })
                    : (Object(v.c)({
                        type: 'message',
                        result: 'fail',
                        errorType: '群聊二进制消息发送失败',
                        msg: '群聊二进制',
                        code: t.code,
                        msgInfo: t,
                      }),
                      e.sendLogger('irc 发送二进制涂鸦消息失败', t, 'error'))
                })
              },
            },
            {
              key: '_peerListener',
              value: function () {
                var e = this,
                  t = this.chatInstance.PeerChatManager
                t.on('onSendPeerMessageResponse', function (t) {
                  e.emit('onSendPeerMessageResponse', t)
                  0 == t.code
                    ? Object(v.c)({
                        type: 'message',
                        result: 'success',
                        msg: '私聊',
                      })
                    : (Object(v.c)({
                        type: 'message',
                        result: 'fail',
                        errorType: '私聊消息发送失败',
                        msg: '私聊',
                        code: t.code,
                        msgInfo: t,
                      }),
                      e.sendLogger(
                        'irc 发送私聊失败,code: '.concat(t.code),
                        t,
                        'error'
                      ))
                })
                t.on('onRecvPeerMessage', function (t) {
                  e.sendLogger('监听irc私聊消息'.concat(JSON.stringify(t)))
                  var n = t.content,
                    s = t.fromUserInfo,
                    o = t.messagePriority,
                    a = t.msgId,
                    i = t.timestamp
                  e.emit('onRecvPeerMessage', {
                    content: JSON.parse(n),
                    fromUserInfo: s,
                    messagePriority: o,
                    msgId: a,
                    timestamp: i,
                  })
                  e.sendLogger('irc 私聊消息监听:'.concat(JSON.stringify(t)))
                })
              },
            },
            {
              key: 'getRoomHistoryBinMessage',
              value: function (e) {
                var t = e.roomid,
                  n = e.key
                this.sendLogger('拉取历史数据 '.concat(JSON.stringify(e)))
                this.chatInstance.RoomChatManager.getRoomHistoryBinMessage(
                  t,
                  n,
                  '0',
                  true
                )
              },
            },
            {
              key: 'getRoomHistoryBinMessageNew',
              value: function (e) {
                var t = this,
                  n = e.roomid,
                  s = e.key,
                  o = s.split('_').splice(1).join('_')
                this.chatInstance.RoomChatManager.getRoomHistoryBinMessage(
                  n,
                  o,
                  '0',
                  true
                )
                var a = h.a.state.smallClass.isAuthorizedUserList,
                  i = a.find(function (e) {
                    return e.pageKey === o
                  })
                i &&
                  i.userIdList &&
                  i.userIdList.forEach(function (e) {
                    var s = ''.concat(e, '_').concat(o)
                    t.chatInstance.RoomChatManager.getRoomHistoryBinMessage(
                      n,
                      s,
                      '0',
                      true
                    )
                  })
                this.sendLogger(
                  'irc',
                  '拉取老师和学员历史数据 teachdbkey: '
                    .concat(o, ', curPageKeyUserList: ')
                    .concat(JSON.stringify(i))
                )
              },
            },
            {
              key: 'sendPeerMessage',
              value: function () {
                var e =
                    arguments.length > 0 && void 0 !== arguments[0]
                      ? arguments[0]
                      : {},
                  t = e.content,
                  n = e.nickname,
                  s = e.chatMsgPriority,
                  o = void 0 === s ? 1 : s
                return this.chatInstance.PeerChatManager.sendPeerMessage(
                  [{ nickname: n }],
                  JSON.stringify(t),
                  o
                )
              },
            },
            {
              key: 'sendRoomMessage',
              value: function () {
                var e =
                    arguments.length > 0 && void 0 !== arguments[0]
                      ? arguments[0]
                      : {},
                  t = e.content,
                  n = e.roomList,
                  s = e.chatMsgPriority,
                  o = void 0 === s ? 99 : s
                return this.chatInstance.RoomChatManager.sendRoomMessage(
                  n || this.ircOptions.ircRooms,
                  JSON.stringify(t),
                  o
                )
              },
            },
            {
              key: 'sendRoomBinMessage',
              value: function (e, t, n, s) {
                return this.chatInstance.RoomChatManager.sendRoomBinMessage(
                  e,
                  t,
                  n,
                  s
                )
              },
            },
            {
              key: 'getRoomBatchHistoryBinaryMessages',
              value: function (e) {
                return this.chatInstance.RoomChatManager.getRoomBatchHistoryBinaryMessages(
                  e
                )
              },
            },
            {
              key: 'sendRoomMessageWithPreMsgId',
              value: function () {
                var e =
                    arguments.length > 0 && void 0 !== arguments[0]
                      ? arguments[0]
                      : {},
                  t = e.content,
                  n = e.roomList,
                  s = e.chatMsgPriority,
                  o = void 0 === s ? 99 : s
                return this.chatInstance.RoomChatManager.sendRoomMessageWithPreMsgId(
                  n || this.ircOptions.ircRooms,
                  JSON.stringify(t),
                  o
                )
              },
            },
            {
              key: 'getRoomHistoryMessage',
              value: function () {
                this.chatInstance.RoomChatManager.getRoomHistoryMessage(
                  this.ircOptions.ircRooms[0],
                  0
                )
              },
            },
            {
              key: 'setRoomData',
              value: function (e, t) {
                this.chatInstance.RoomChatManager.setRoomData(e, t)
              },
            },
            {
              key: 'logout',
              value: function () {
                h.a.dispatch('smallClass/updateIrcStatus', false)
                this.chatInstance.logout && this.chatInstance.logout()
              },
            },
            {
              key: 'unInit',
              value: function () {
                this.chatInstance && this.chatInstance.uninit()
              },
            },
            {
              key: 'release',
              value: function () {
                this.logout()
                this.unInit()
              },
            },
            {
              key: 'isTriggerFun',
              value: function (e, t) {
                var n = ''.concat(e, '_time'),
                  s = this.triggerTimeMap[n]
                if (!s) {
                  var o = localStorage.getItem('triggerTimeMap')
                  s = o && JSON.parse(o)[n] ? JSON.parse(o)[n] : 0
                }
                var a = t.sendTime ? t.sendTime : 0,
                  i = false
                return (
                  Number(a) > Number(s)
                    ? ((this.triggerTimeMap[n] = a),
                      localStorage.setItem(
                        'triggerTimeMap',
                        JSON.stringify(this.triggerTimeMap)
                      ),
                      (i = false))
                    : (i = true),
                  i
                )
              },
            },
            {
              key: 'sendLogger',
              value: function (e) {
                var t =
                    arguments.length > 1 && void 0 !== arguments[1]
                      ? arguments[1]
                      : {},
                  n =
                    arguments.length > 2 && void 0 !== arguments[2]
                      ? arguments[2]
                      : 'info'
                f.a.send({
                  tag: f.b.irc,
                  level: n,
                  content: {
                    msg: e,
                    params: t,
                  },
                })
              },
            },
          ]),
          n
        )
      })(d.a),
      S = n('d15d'),
      g = (function () {
        function e() {
          var t =
            arguments.length > 0 && void 0 !== arguments[0] ? arguments[0] : {}
          Object(s.a)(this, e)
          var n = t.planId,
            o = t.businessId,
            a = t.userId,
            i = t.ircOptions,
            r = t.rtcConfig,
            c = t.isAudition
          this.planId = n
          this.businessId = o
          this.userId = a
          this.ircOptions = i
          this.rtcConfig = r
          this.isAudition = c
          this._initSignalService()
          this._initRtcService()
        }
        return (
          Object(o.a)(e, [
            {
              key: 'release',
              value: function () {
                this.SignalService.release()
                this.RtcService.release()
              },
            },
            {
              key: '_initSignalService',
              value: function () {
                this.SignalService = new C({
                  planId: this.planId,
                  businessId: this.businessId,
                  userId: this.userId,
                  isAudition: this.isAudition,
                  ircOptions: this.ircOptions,
                })
              },
            },
            {
              key: '_initRtcService',
              value: function () {
                this.RtcService = new S.a({
                  rtcConfig: this.rtcConfig,
                  publishStatus: !this.isAudition,
                })
              },
            },
          ]),
          e
        )
      })()
  },
  2849: function (e, t) {
    e.exports = require('http')
  },
  '2a77': function (e, t, n) {
    'use strict'
    n('fee4')
  },
  '2ae6': function (e, t, n) {
    'use strict'
    n('d3b5')
  },
  '2be6': function (e, t, n) {
    'use strict'
    var s,
      o = function () {
        var e = this,
          t = e._self._c
        return e.thumbnailBase64
          ? t(
              'div',
              {
                staticClass: 'thumbnail-wrapper',
                on: {
                  click: function (t) {
                    return (
                      t.stopPropagation(),
                      e.handleScreenshotPath.apply(null, arguments)
                    )
                  },
                },
              },
              [
                t('div', { staticClass: 'thumbnail-img' }, [
                  t('img', { attrs: { src: e.thumbnailBase64 } }),
                ]),
                t('div', { staticClass: 'thumbnail-text' }, [
                  e._v(
                    ' ' +
                      e._s(
                        e.$t('classroom.modules.screenThumbnail.successNotice')
                      ) +
                      ' '
                  ),
                ]),
              ]
            )
          : e._e()
      },
      a = [],
      i = n('c7eb'),
      r = n('1da1'),
      c = n('0a4b'),
      l = n('4bde'),
      d = n('3631'),
      u = {
        data: function () {
          return {
            waiting: false,
            thumbnailBase64: null,
          }
        },
        mounted: function () {
          var e = this
          this.$bus.$on('screenThumbnail', function () {
            console.info(
              '箭头函数 监听 screenThumbnail,filePath:renderer/components/Classroom/SmallClass/Live/Modules/ScreenThumbnail/index.vue'
            )
            e.handleScreenshot()
          })
        },
        methods: {
          handleScreenshot: function () {
            var e = this
            return Object(r.a)(
              Object(i.a)().mark(function t() {
                var n
                return Object(i.a)().wrap(function (t) {
                  while (1) {
                    switch ((t.prev = t.next)) {
                      case 0:
                        if (
                          (console.info(
                            '对象函数 handleScreenshot,filePath:renderer/components/Classroom/SmallClass/Live/Modules/ScreenThumbnail/index.vue'
                          ),
                          !e.waiting)
                        ) {
                          t.next = 4
                          break
                        }
                        return (
                          console.info(
                            'if(_this2.waiting)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/Modules/ScreenThumbnail/index.vue'
                          ),
                          t.abrupt('return')
                        )
                      case 4:
                        return (
                          (e.waiting = true), (t.next = 7), Object(d.default)()
                        )
                      case 7:
                        ;(n = t.sent),
                          (e.thumbnailBase64 = n.thumbnail),
                          s && clearTimeout(s),
                          (s = setTimeout(function () {
                            e.thumbnailBase64 = null
                            e.waiting = false
                          }, 3000))
                      case 11:
                      case 'end':
                        return t.stop()
                    }
                  }
                }, t)
              })
            )()
          },
          handleScreenshotPath: function () {
            return Object(r.a)(
              Object(i.a)().mark(function e() {
                var t
                return Object(i.a)().wrap(function (e) {
                  while (1) {
                    switch ((e.prev = e.next)) {
                      case 0:
                        return (
                          console.info(
                            '对象函数 handleScreenshotPath,filePath:renderer/components/Classroom/SmallClass/Live/Modules/ScreenThumbnail/index.vue'
                          ),
                          (e.next = 3),
                          Object(l.b)()
                        )
                      case 3:
                        ;(t = e.sent), c.nativeApi.openDirBySystem(t)
                      case 5:
                      case 'end':
                        return e.stop()
                    }
                  }
                }, e)
              })
            )()
          },
        },
        beforeDestroy: function () {
          console.info(
            '对象函数 beforeDestroy,filePath:renderer/components/Classroom/SmallClass/Live/Modules/ScreenThumbnail/index.vue'
          )
          this.$bus.$off('screenThumbnail')
        },
      },
      m = u,
      h = (n('2d38'), n('2877')),
      f = Object(h.a)(m, o, a, false, null, '333c6e84', null)
    t.a = f.exports
  },
  '2d38': function (e, t, n) {
    'use strict'
    n('10e6')
  },
  '2d81': function (e, t, n) {},
  '2f84': function (e, t, n) {},
  3: function (e, t) {},
  '30d6': function (e, t, n) {
    'use strict'
    n('9eaf')
  },
  3143: function (e, t) {
    e.exports =
      'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEoAAABICAMAAABmxpNIAAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAAGbUExURUdwTPtSu/FZlPdUqvZfpP9ms/BSmP9+futQifZLofhPufVPoexMiulRjvlMyfldrOtUl/+Mwf1jv/1cv/l8t+tQi/pPx+lYk/l4sepNlPdJvv5ytvNqp/pPw/+Hu/FGtf6KwfVWn+lel+1knu1moe5opv1jp/dZofdyv/95w/lLyft2xvtOvPx0v/lWo/tOs+xXkepZlvJqr/pLw+tOl/lQqPFrp/NOnOtak/5YrPtfpetgl/lMuupUletemP9zwvdwt+xWk/ZIwf93vfpMzv55t/Vstf5otPJhovVTnvtao/+Cv/6GvPBoqvt0uelclfxnr/l4t/pvuO9enf2AuP1qqf+Ow/Vrsfd1sPVOo+5Jm/90r/Vwrfdfp+lYk/VIsvdMrfpTpvRurflkq/FEr+5Go/9zt/98vf9tu/VKqOlIm+9EqO9ZmfVHu+tOk/93x/9QqelUjftWvv9gt/FanfJkqPlyw/dys+9Umf1utf9mufdstfFEt/90ve9Ql/dmr/5srepEou1im/+Iwf9wvf9erftYtf1WxftUqWKGX3QAAAAidFJOUwA4dylEFGEC/gmOp3/aqR4yimRzTJvp94u509Hbur/37N8a5ExrAAAHOElEQVRYw+3X+VMa2R4FcB2Xdo3GJSaTmJnH1iCLgoBsooDsm62gIjui7YILilE0KG7on/3O7dZUMI5xMu/V/OJpQYsqP3W+ty8N3dDwmte85v+clsbGgebGln/KNPYPv7u9vR2/Hd///U3fCzmqpbm/o7Ozs6O16dtLfR+/rE+dnBwc7O/vK24tCsubxhcM0f8xGr2RGI3Gvb29/3T1UHit+aPjev3k5PYE0IHlwLKvUFgUw00/gd46nXH3QfQGlG+PpLOH6o9EQmtzc+Xz01quVqtZapZ99FKMd7Q/Iw386Y/E18plSfXmhu+1t6f6HIk48eLs7KxkxWhM1kZro5ZRhcWusD9T7O3ClZ/1r6253e4bEqMPXjwSiTDxeLUaXblJriTv7pJ3GWAWhX18/F3TX0oLV1d+5xqsMqcd3Bhv4gF0iscT0agkakomaaNRd1fLgLKMK2D1PiOx7JpzfW3dfeJ2H8AqB8h4S3FIEonJ5PPRtFGn041mYKHWyLuntsXAAqiAn3VUKmvXayfuE/y41yOBSBytoiTzsGifSpW9nxAjjowPP7GZ/uRLyZwhx/X19fq1e339xO1nI9x8XCuTxOfzqbKquzvdRi0DCtLITN8P1Geuk9/BKitTlUrlmnDrMn+EfShFBqRB0dmsLnM3SmphwJGRd9QjqpmfLuJwVhywpqaucVT8ftbJtYpGTVGTSUL7aB9aZbOZTIajYP1Q6/NCAJ1kpJRyipVNyaamlFMylmWdRMJOiJokkpLJZ8JSZbHutVFsLa7VzJt6qWkBVICUclSUSiLJZHIZC8vhZMqnOX4+rJUKoXVYLEy4vc+1mqnf9G+vUIpl2JASqYCR7+7KZLAcSiZULlejh7BKZED6vlUai2XfHyG16t7Z1MdAIOL3M6wyVFE6dpVymWxXvitnZVI2FGJAVat6sq3IXshiRB3W6mHdZ2b6697FV1eYjmGlaBWSO+TyL4Bkcv8XVuoIheKu0+qKROLBGTTROIM6QtXSGNA+cguro257BrAVWYZhlJyF7OJBlkuqrKDV7Gx0BWfQ5CM7VBXL6mKj6YylZt8m89Wve1+AiQCSMiGlVCkPoRCR5FJWqmRwdSkvnlclK9x8WCpVNnaHWmilsNt/OIXvIxzFhHDwrUhYuRQdIZ1WMWA0aSLjeWlvNpbZINudUPbHrd4uEemImWbmlEqpVMpTUjlKzqHVYuL8EKWStEflo2NZHJlMftSSxht65NFaUe8BLRFsetrFgJJ+gUZ+M9K56dBi+XxlReJJ0jTpNEHHkI1MOp3+yreqO4Pvl7gcHcGa5ikuzPTc3OnpOaQVXKpoDySvl5M28pn0tgWSfaZuX1F9BGKIBOtIyvAYIwU8fQoreJhMemjS6oGKkVYWvlbdJWsAUmIpl1jMLS6SYlwz7g/X6bmGdALkKXm9xyrvRGwCEmmV394GZR+mqO8vVoBwHCVyi0ca1zRpduSSulyQNOfnOUzn8QDzlrwTCKyLjVg+neGomf76q8ynBEkup0nkXDnXt2hcQTKc2INWpdKxtzBxTKzV1djqxlY6/5Wzeuoo6n1Czx2JnAaW5kFCgoeHYlSaLxVK3oLXe+Y9m1jGcbEVy2e+IvY3j698Ir2ew/SanIYTiBMMAjo8FHnm50soVbAdn52hFKDVrY2tfP4P1NpufHwV/aTnktBrEsGE5j7BoPhQBIlQhePC8fEZrDPthHZi+WJrFRZaDT+WGlo5SUwe4pw4KEbQSSzycBCkQunYxkHL2uXl5VUkvwXqj6bHFEV9EvG9xDm9WBMkDqE8YiGR5q0ldQGtCrDOiLWJxdq6yG997aB+/PAaEApFiF4k/i4iqxDOZUFdMNhsk7bJyTOtFrU2+VqY8Pcnv2h1clSdJBYLhbCs81ZruKAGNqnlsU3t6gWSv3j6c779k5nHeE4kJn8JBZcCq1VtwGGz8dbOjnZzc3N58wIjtlLUU9/1qN4hs1B4X4384EkovLwUWgVWQ9hqUKshTdq0XIChVceTEqyG5iHzN4yrhEMgEJitmA9J2Xhsh7cuNjvb/4IiOwL/KBAS4QFDLs1mgSBMNLWab6ad1O6g1od26plvfa1DHCZAOZFARFCyWMQScMVgTaawWpB2nuvEvYHuLZGAFMIzMDNHYfUFamCkFiwi/eQLcm93WBAm/yniQDyhI7H49VKncBqJ1EX9/Et7z4cUR92XI6JZwNcKhwWGlC2FCYdaqRfdAXQVU+EHjYQsltlsDZvDYUMqZRvbKXb3vvBmAkN+h/Hzmc1hs9WApMZSxQ8tVMNLLapriGC8BsdgwCY18NJYWyv1N26NqIamwWKxaCiSlb5HuIyNDXX3Un/3Tqv3Q5FkrDiGGO4fxbHBX7ptaxocamvjOAMKEqetu/lX7wHbW7vbvs9gC/WLEoV3Rs9v3UXeGRps+mc3p6jR3tza1dXV3P6/uGUm7Siq4TWv+RfyX2oun10S0WQHAAAAAElFTkSuQmCC'
  },
  '33f6': function (e, t, n) {},
  '34bb': function (e, t) {
    e.exports = require('electron')
  },
  '35dc': function (e, t, n) {},
  3646: function (e, t) {
    e.exports = require('buffer')
  },
  3983: function (e, t, n) {
    'use strict'
    n('cfa1')
  },
  '39b4': function (e, t, n) {
    'use strict'
    n('a28b')
  },
  '3a6c1': function (e, t) {
    e.exports =
      'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADwAAAA8CAMAAAANIilAAAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAAG2UExURUdwTO9On+pSjflSuPZHxu9JnfFPm/9Uq/9en/VUs+5XletRlft8u+1ZlvRRof19t/9Ppe9Ctf9Or/lOw+lPiftOw/dmpu1EofBOlP9zvPlMw+lQjelMhfV0rf90u/+Bu/VKw/9Opf6BvPlKy/6Gvv+Dvf2Jvf1ew/tMzf9Wp/2LwflKzf2Bt+1kn+tkm+lelfhyvutfl/lSqelble1opf52vPpZo+ximu1QlvlMyutTkPtiqf5srflMsvlOt/tyu/1np/tPvfZcov12wetYkftnrvJtqfNPnP13yPlLwP1VpulemfFXm/ZusutbluxVlu5MmvdSpfVjqu1InPBGo/dMrft2w/lMxPdUoP56vPJqrPdepf+IwelWlfpytfdtuP5sufdKxulSlf90vvBbnOtSi/t8uf1eo/FEt+pLlvNqtf+Ow/9qtv6Auf98wvtrsvl4sfNKpe9qp/1UsPNqsf2Fuf9arv91xP9ysvVGvPFjpu9EqflMz/Forf9xu/NIqf9ir/l0w/Vwrf94s/d0r+9en+9mq/lMu/+Bvf1cwvdan+1mpf9itf1cufNGr/9er/9uv/9OpQLWudYAAAAtdFJOUwAw+Cb6/EUCCBq1x05uU37x/RCPqsjW892ScJeFMttspZXaXOY6qdul8enX7aMIaWYAAAViSURBVEjH7ZbnVxpZGIctHAbEmqjpPdmWdeggRdqMEJQiHQFBuiAgDKACVooFJTH/8b53MKirySZ79tOePMMZvvDc3/veudy5fX0/+cl/wL1B5jCzn/XjIjb86NfT01PPqVY7db//279lPhqa/n18fPrVKB3EevH84jzUOe10tB0tMDX6VZM19nxPeb65ubDw+fPn8VfsPvbzhPpidbVz3ul0VNrOsdZonBrE7nSH354sb2eUBwefigtFGGD80Z/lRnBjHihWPxWLRRXYWsbju9yx9cDJciND25tA8SBbzue3lUqlXaFY+FQtqrq25/7tiQE3cCIWb2cy52CDrimXG+BqgKRftykQFF2quWMVw3PbHltfXz85WRbvZZAOHCA3j9xkMqmTSCQCmwBko7bikb252fc7cKHqxJ54b291NZTJZBLZRrahzNPBSUnbKxFA9pxKdezxyGTsG/P8+jIYiPIuYIbd2Wwi34COkdtOtiVem8DlmlMdG5H823X5BcrNQdHiaDRKbF3wLnIniQS4TY1Gh5IREO2CZKNRJtu5Fo39QRctXhZH1dGtLYLYyuWWlxONJgrW6JI6Ha0K5kCG5LBMdu15DQcCgWwuIVZHxZALEDkCWghug63X9JJtLmj6+BjK3pm6kn8JlKFF6JfgEe4PQC6HbHUQHrImqdH5kxKbDVWNmg6HwX5/Nd9vywHaVauJQzeyc4SbADfYnJ/XaPxJum5bb8YgeefeF5ddziYANUDQrvuDmyAItTizAYvTDzYUbYPnLAC5UgmHQe4t8XfZMqh5JKOyQc+5CTdKNs8rNQqF3w/B8KhsKFllhGiQe/MFsflEUBxUqw95buDQfcjj8dTgblRB9eu8XhvgQvKaEc32Dhv78n/PJ/L5PHQIBg9EN+2GQumNDcU8yG3dpV0QuNZUWgZqurevDIPabJqDwVAI2QCPF+SFguaNeQUk69pek9drsBUKrv2Pc2t00+97k/0M3HywaTanm8imCYVC4FYVdn+r3fZCsLdQ8Bb299fmKhVGOPzyaoHVm3CZ62ZzsJnuuuY6uLt2n13nb7dMMe+s12AoFPYLHz+uqSoMT/jN1SKZrjf1db0Z9FA6XSqleaW0uWQ+8tn9/pauZWobTAYE2HTdjArj2lY6pq/X9UCpVKqnEaWSz+ez2+1nLV0sFjOZDKYlg8O55HTu19YAxv2rBYY90+uput4H91LdB35pd/fIXqWqM7oWUk2m2SXAsOQs1ApgVyo39uBpSk9RetAp/W7paJfapURUtdpqtVCudRYA2eFwOmv7E5D88sZOMkJRSKconwhukHt0Vp1BLt9qsvbslNPhrIE+wb65hU3jyAJElOgIXWfg4jF+LGaxktZZ62W0o+asTUw8/tvW3Y/j+AwuuuIMl0qlfIvFYgUicpSdStGFT3BubfsjuAhdIkim3ZkZkC18vsW6gvTZSCq15EiB7Hhw7/aeP4TT4TOACGpAMn+RLxQKSeEKaY1EUvBxOFK1B3e97bCujdQuOC5dpG3hinWFjJCQDYU/YN75LmVxuIs4fjkCQipd5ANCCxdqX0HZjtTdLrKHuF1d1B1jkcvnc7lcIR0OMtgDzK++x7En8FtuN5y+S1E40i0rUHgk9fCbb/fRAaQv4t2LK+XykWxByXK5nMP+5hkCG+QIaZ2Lc8GGslHhyCblkSfYPx1BsJEBIcntwu9+WUihhZQ/HP2OAwzGnhyIk+TlADDTFtJCknEOG/uu809f/2Q8TqIBLomTAyPYdx+fsMGnA3EaORomzunHfuT0hbFGJ+OXPBxhYT96esNYzKeTnKEnTOzfnBoxrLvwfp6f/wf8BaQMDDgsIeBCAAAAAElFTkSuQmCC'
  },
  '3abc': function (e, t, n) {},
  '3c93': function (e, t) {
    e.exports = require('crypto')
  },
  '41db': function (e, t) {
    e.exports = require('child_process')
  },
  '42cd': function (e, t) {
    e.exports = require('assert')
  },
  '42cd9': function (e, t) {
    e.exports = require('net')
  },
  '42ec': function (e, t, n) {},
  '44ca': function (e, t, n) {},
  4598: function (e, t, n) {},
  4600: function (e, t) {
    e.exports = require('timers')
  },
  4678: function (e, t, n) {
    function o(e) {
      var t = a(e)
      return n(t)
    }
    function a(e) {
      if (!n.o(s, e)) {
        var t = new Error("Cannot find module '" + e + "'")
        throw ((t.code = 'MODULE_NOT_FOUND'), t)
      }
      return s[e]
    }
    o.keys = function () {
      return Object.keys(s)
    }
    o.resolve = a
    e.exports = o
    o.id = '4678'
  },
  '488c': function (e, t, n) {
    'use strict'
    n('8098')
  },
  4978: function (e, t, n) {},
  '4a42': function (e, t, n) {
    'use strict'
    n('7859')
  },
  '4a79': function (e, t, n) {},
  '4ac5': function (e, t, n) {
    'use strict'
    n('6b78')
  },
  '4b91': function (e, t, n) {
    'use strict'
    var s = n('badb'),
      o = n('1174'),
      a = (n('900f'), n('2877')),
      i = Object(a.a)(o.default, s.a, s.b, false, null, '1c1b767a', null)
    t.default = i.exports
  },
  '4c0a': function (e, t, n) {},
  '4c4f': function (e, t, n) {},
  '4ec6': function (e, t, n) {
    'use strict'
    n('4598')
  },
  5: function (e, t, n) {
    e.exports = n('8f59')
  },
  '50c44': function (e, t, n) {},
  '526d': function (e, t, n) {
    'use strict'
    n('7850')
  },
  '52a9': function (e, t) {
    e.exports =
      'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABgAAAAcBAMAAACJyGLdAAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAAAkUExURUdwTP+rCv+rCP+rCf+qCv+rCP+jAP+rC/+rBv+rCP+rCv+qCn9KHKEAAAALdFJOUwB+90HIlw4nbFjl8LNS6gAAAIJJREFUGNNjYMAApeEINrP2JgM4x2j3bmWExO7dcCmgBFwKJAGXAktApSASUCmoBFgKJOG6e3cIWKpo9+4tibt3i3nv3q3OEL17txvj7t0CKbt3bwVytiSAOGzeQE7RbjcGEIchBaiMvZMBwmGYUQC2FsKBAnpxmHcjBRVD1wrMgAUA53xNzEyb/KQAAAAASUVORK5CYII='
  },
  5711: function (e, t, n) {},
  5880: function (e, t) {
    e.exports = Vuex
  },
  5919: function (e, t) {
    e.exports =
      'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABgAAAAcBAMAAACJyGLdAAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAAAhUExURUdwTKOruaGruaOrtaGpuZGjt6OruKKquaOruqOrt6OruU9IpHoAAAAKdFJOUwB+90LJDieXaOVc0UabAAAAhElEQVQY073QPQqDQBBA4RHROo0nCFhYiXeQgJWCBwg2uUCw8AR6A2sRhHdKZ39YA/aZah/fwMKI3OYzXu+42MoQFTwvgEAKgQwEsuDJgSeFDQpLBl7wtTTA3kHWQC4T1BE8ejg09tZE0mgM1GJCel1LZ3Eh89t+68LPvyLm51SyrPfDnrP1Rzr87URqAAAAAElFTkSuQmCC'
  },
  '5e27': function (e, t) {},
  '5f36': function (e, t) {
    e.exports =
      'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACoAAABMCAMAAAAssNUuAAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAAEyUExURUdwTP/Wv//Hq//Hqv/h0f/CpP/axv/bxf/m1//x6f+1kP/17//z7f/u5f+jdP/n2f/y6/+oe/+kc/+kdP/Iq/+sgP/48//Wwf/Tu//x6P/dzf+xif+jcv/Hqf/Zxf+hdP/Xw//dy/+jdP/v5f/byf/Jrf98N//Lsf+hav/fz/+lbv/Hq/9+PP+jbP+aYf9+Ov+dZP/Xwv+rgf/dzf/Zxf/Ns/+pdP/o2/+thP/Lr//bx/+sd//h0f+faP+pfv+pfP/p3v+ncv+fZv/Zx//Jr//fzf/Vv/95M//Uvf+ncP/t5P/l1/+LTP/i0//j1f+rfv/w6P+BPP/Ptv/s4f+xiP/z7f+lcP+haP/38v+md//Su/+8mf/BoP/Fpv+YXv+3kP/Vwf/r3//l2f+BPv+jcv+FQ6L/BooAAAAhdFJOUwBfzOlHGCcHM4yG885k6su92FurnLmagrfo89f1saPF34YAaeEAAASESURBVEjHjdd5V9pYGAZwa1Vwd3TaTns6C2vAKFuIEJYQTVwOBFSIPYUkUlG//1eY971L7gWXmYfAP/3d575JqCcsLb2aWHwlHlv6z8S3P2/9hGyuv4fXtte3Nn9G2Yu9pfY270SI/fxCrazvfe2SpG5I7vCFWZkfbXc0sixrhKG+e9NlK+6+yiPEZxbJg/UwskYPwndvUrCHPMKnfG1Wg1g1S4TsQNdII3hBbzaDA0MWWWIR7GFtiRHq9cmgNxj0er1ZL1qBb7aiti7Rab7fH8BB0iOLeHCbWTwaoF4PW5g+vnDRgK3CRZjdWNRar5fz+XyLvsSaaJ/eF0ErvqZp5+fwzkehq3AhrFgTrRUjwaMlNJbzc7ay1dqVqFdN8ySk0CWalt4WtBLYDbvRsNPwkU7jWyxNw07fyAjgMMMqxKZvW0qjgQsTfyCtVAie/qq+HbuaWCEUY5pheTFV+lmFo1r+K6IVsz75RXLB3lHKcJTL/0i0Mr14M9D7TaKm6Vy9EmB2IgEnxqmJ8SbwT5OrSZSrsk0vM140pCZ9QQKhJhdQBtefw7RNW02aTmXIWRrvkQQbNlJEFHc6UFu2Nbjt+N3Ror3hNhJaN6PWTgBfKIzGKtO8Em4hUMPj0uz4BM41Eog3HOhQnzLYIfQlpDcX6XDod1j8vCbLhoB2nlBdCdgI/uuV2sDqpoDeZ3TFCCu0VbpADTpkol/rpjBAj9zAMJzQG5tjoOICgUu3ZqMUD9LH52kmo6pTc2z60tb5wUM3cqnuACmko6ohWj9NJRlOpDf0m4ekFWwhhPimj/+X+rWRxB4uguvj48PDH0BRHj26Ptqg1ZvbNRF6uVzumFPSWjx6ngZhoHdTkRzo08OzdpvLqBVjBsGQSevKH5dKJZCEoiSU2OJRtlgIFGjtNsLrUqEAst2WSk8FLcKHG/YV7+y+UCDyTN7+lNDbW5TFYraYde8hTJaIJNsLSkqL2aMsoQgLkmSl860RJYPy7X9QecIo2x8pKz1jpYfHePYgT/jFEq2sszS//Qmjt1wCXdyeDUopH7XIaCm6ooRy2ST0lstLl5dGF58NetJcoFk3GrQ9Pyij4qygFc9+7oYS2pxrzbIB2vLZi+0ZLUr0xbeE0g6h7mMkL1357CUJuQY6vr9lMsup/C0hg3aang80Oc49Z7OstdBuvzz7ay9QDQNbk+OkS+Wl2y7Nbw9uGhiKYzgOtgIdF4qXhC6cU2UaKoZiOIrjZLAVa5O550tOmTz1fFXXFQWkk4GwVjxcnJXIp9zTiRcYyBT4G0UlocCSiGEIlwzanIa6vgBVlbTy5J7ddq6C21JIzsYhTiV0h3aSPAXKUNdfqaT0k6hNerouKhlUaUKg+4uUQGNRfsQHggOJDunlmd8a/6KG5KkodjAWrVGlJAGGy/RZK7bxxKk8JK8Eu/whejDc/x7RxSHV4M8Pq0vSU+zaDqXOAvz4+8qLx+3VvzkVcHkj/voPgYPvyac6HzKj4rZvZn8n6RGYodu+96NgdeM3J6Muf4GfGf/jh8bS6jvoX8W1SZbV33gqAAAAAElFTkSuQmCC'
  },
  '5f75': function (e, t, n) {
    'use strict'
    n('4978')
  },
  6092: function (e, t, n) {
    'use strict'
    n('6679')
  },
  '62bf': function (e, t, n) {},
  6359: function (e, t, n) {
    'use strict'
    n('7da2')
  },
  '645f': function (e, t) {
    e.exports =
      'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADIAAABkCAMAAADzNpNpAAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAAEmUExURUdwTCAgICQkJP9naxcXFxYWFiEhISEhIf86Qf8zUyQkJP89ev83VTQ0NP89dxISEiIiIv80UP9VYv9qbf86Zv82U/9qav9Cif9gZhISEv9ygf9OWf9wfv9aaP9SXv9ebf9gb/9od/9jc/9mdP9WYzExMf9sev99g/9icP9JVP9qef9IUv9RXP9UX/9MV/9ETf9mdv91ev9cav95gf9ufBQUFP9GUBYWFv90gCYmJv9BSf9wgf9YY/9sfP9ufjQ0NDY2Nv9UYv94fR8fH/9xdv9ob/9scisrK/9aZv9YZv9xe/87Qf9td/96fi4uLv98gf9kbP84Wv9KVv86Zf82VRoaGv84YP9faRwcHP9MWv8+Rf9dZP87bf89df9iZ/8/ff82Uv9AhA8xJp0AAAAZdFJOUwAWiPHVCK9n/j8rPr/hv+1CvyatLt8m862KdfiIAAAGK0lEQVRYw62WCVcaWRBG434SJ5rJNoMNzdYwLN3sEFBAGgMCQYaQBREl8f//ifmq6rUs4tLnTMXT2klfb331Xj/y4sXaevvhw9sX7uqP77//dEe8/Pn1+++X7iRAvrvS7H/7+dWl5uDbT+rMhebl9Te3moPra9Y8P83+9bVbzcHNtUvN/q+bG1jcaA4IcaXZvwVy4yrNwe2vuebrczT7t7fCPD/N+79ulzXvnyJevW40GqeD8/PK2dmPT5+KRc/2qycQJiIDIi4/AfF4PNs7jxJ7DaqISH6QBLX5GLFBEuqrUjm7lL5QhxuPIJsiGVQqlUuRMLP7SPaGSAZLElwensBuY97XXRJith8Adt5IWxx+QYLr4d4DyOvGmvBF/lo/6B0ZcMNZlB9FhTw86I3GgoRX3klSfGDQO5tzCfdVXELWDfrVnYTDzxGHeXNPsntPsojgz/b6zeXsyEWJAxX3Vgd8SsBpZGV7LSKHy4PejEROqRi5XJE4zNKgNyKDyClbeMKXyxKP2p6Hi1ttF8TpYl/LEjWBxUG/GQy4r4ha+bXI8qBfnytkbfgF5m7Qe5VzTi97eHlRVhg16I3tgTSmEJasQ4p3W23vHH1FHu1rVcOIZF+z8ivM3o5sL7ZEFiQez1oGY5bGPr7byn7+nM02mxeof6n+UcU39LfNbBbPtLfe8X85Pm61CVDIIqAgQi4EaQ+3iHnXardFsgZxNM2mIK3Z30C2GCEPI/TcnOCLEIS0WtMtILOZ0ohnTZamQ0AymwoyZy4u8kud4SZPSPNzFgSQqSDDluqtR6LmRT4PjoPn5Xl29NHWbDazgExnjqfXy2bLzXwzn2eIvzXLzXK21+sxQRKy4AoETL8PqFfOlsvlvCr82PQy0EdXQySZmkBMYobUnGLwex0EBnL0++QYDsfTqUWIZU2nYyDhMP6l32NooXDf7/XbQSDjcdVixDStamcMKNwKMuLlR/N8zVJb/X4wHI6BmILQgGgmPISEyBMtFLzZBYm3UIj2g+1waxgQCSMaaXw5aMLBICFe75E8f4QfgQRF0plWQcSBxDXTrHY6uXEsBiQhyBEgXBhJAIkFxjlfF0SKkGTKNO1uJ+cXhDVHrCGkXog6SIckqSRZUujMMHzjQCxESJQ05CGHtxAVZAiJ4SBJdKYbRicHJBxMJKK1ujB0rdeiiUQwHIr5cx3DMBGFkZGmkUUh0VpBHOIpgBGELIgiSApI18dhMkE0VveenBzxF80rGsyEYw6yYvHDMkdQQOqChOZICUgpOZnotiAZ1diJ9AWEwgQzgtj6ZJJ0hRhzJD7RHORe/PpCfCDaRBqLI8sycuIgJ2K5Q0yV5b7laURzj0z+B+Tp+M8esuUW4aW8H//RDWPfbRi8MAp5YlsiS8pBUrqxhNTxNNVRvb60k/WUQpJ4LW3sfkHwjtXpvYSCzwq8YYyAsOmlnCM2kIAgtULdQTBjQQKrSIoR57XEzOoUB+Mq1NSyBHKMpBxkxEg35w+EQhlCanV+/THhGk6LTCgU8Oe6XRvISCHxlGkJAk3C0bAERIIkjFgmXn2FjEzdUpYwr2atVkDVuC2silgs3RwppBQfabpuAJHFhCZawwkYZYcsJBDD0rVRvCQIDgycZBgZd8ZzJtGcCPj9cvAhCiFpspg6rUwugDnzYa4qCAITlnlh68OSZiQZnyiENXwyc9HRKuEFmSAKI2leTMzMh9WkCYABlaBrmLJjHWlP0rFfShNynC7xgWkbHdaQJ5zJoCc0BQdLOgaNGFHSx4wkFUKfGNIaB+JvnD3X6dL7BSQpyHGpNEqpNDyBWCysCj9SdhU+NSqVjgVJp+PYM/Qh0+34AgGGYvx8jO58cGDC6AtR7hDqjDW0OH4OxF8BuvN1HUkyLcgVIXH+LLOMKvUGRgrPU1dVw+JxxQm5UgjtsxQ2mgEGc8v5VeVySF5FWzq1hXkp5OpYzRm9WTaYDkxcPsToVm0AmiYTPr4i5AsjJWpNYxGGAIyq6yg0aqvEyBcHoTgjvJ26jkBd/OquuiCGjq6cthRCDHmS4kFZtm0bBi4W3bEjyQ4QCmEPjwAMlaWKbyiH45gjioEHEChdFT2v4fBKOgQj/wEAON21u28DQQAAAABJRU5ErkJggg=='
  },
  '646d': function (e, t, n) {},
  6679: function (e, t, n) {},
  '675f': function (e, t, n) {
    'use strict'
    var s = function () {
        var e = this,
          t = e._self._c
        return t(
          'div',
          {
            staticClass: 'h5coursewareContainer',
            class: { topZindex: 'error' === e.coursewareState },
            attrs: { id: 'h5coursewareContainer' },
          },
          [
            t('NeLoading', {
              attrs: { visible: 'loading' === e.coursewareState },
            }),
            t(
              'NeDialog',
              { attrs: { visible: 'error' === e.coursewareState } },
              [
                t('h3', [
                  e._v(
                    ' ' +
                      e._s(
                        e.$t('classroom.modules.courseware.errorNotice')[0]
                      ) +
                      ' '
                  ),
                ]),
                t('p', [
                  e._v(
                    ' ' +
                      e._s(e.$t('classroom.modules.courseware.errorNotice')[1])
                  ),
                  t('br'),
                  e._v(
                    ' ' +
                      e._s(
                        e.$t('classroom.modules.courseware.errorNotice')[2]
                      ) +
                      ' '
                  ),
                ]),
                t(
                  'div',
                  {
                    attrs: { slot: 'footer' },
                    slot: 'footer',
                  },
                  [
                    t(
                      'button',
                      {
                        staticClass: 'button',
                        on: { click: e.reloadCourseWare },
                      },
                      [e._v(' ' + e._s(e.$t('common.reload')) + ' ')]
                    ),
                  ]
                ),
              ]
            ),
            t('div', {
              directives: [
                {
                  name: 'show',
                  rawName: 'v-show',
                  value: e.screenShareStatus,
                  expression: 'screenShareStatus',
                },
              ],
              staticClass: 'screen-share-class',
              attrs: { id: e.screenDomID },
            }),
            e.screenVideoShow
              ? t('ScreenSharePlayer', {
                  ref: 'player',
                  attrs: { beginTime: e.screenShareBeginTime },
                })
              : e._e(),
            e.blackBoardImg
              ? t('img', {
                  staticClass: 'blackBoardImg',
                  attrs: { src: e.blackBoardImg },
                })
              : e._e(),
            t('ShowPhotoWall', {
              directives: [
                {
                  name: 'show',
                  rawName: 'v-show',
                  value: e.photoWallImg,
                  expression: 'photoWallImg',
                },
              ],
              attrs: {
                isAudition: e.isAudition,
                photoWallImg: e.photoWallImg,
              },
            }),
            t(
              'div',
              {
                ref: 'h5courseware',
                class: [
                  'h5courseware',
                  'noCourseware' === e.coursewareState ? 'coursewareBg' : '',
                ],
                attrs: { id: 'h5CoursewareContent' },
              },
              [
                'noCourseware' === e.coursewareState
                  ? t('div', { staticClass: 'tip' }, [
                      e._v(' ' + e._s(e.$t('courses.noCoursesWare')) + ' '),
                    ])
                  : e._e(),
              ]
            ),
          ],
          1
        )
      },
      o = [],
      a = n('c7eb'),
      i = n('2909'),
      r = n('1da1'),
      c = (n('d3b7'), n('159b'), n('99af'), n('b680'), n('1bff')),
      l = n.n(c),
      d = function () {
        var e = this,
          t = e._self._c
        return e.visible
          ? t(
              'div',
              {
                staticClass: 'game-courseware-mask-bg',
                class: e.showCover,
              },
              [e._m(0)]
            )
          : e._e()
      },
      u = [
        function () {
          var e = this,
            t = e._self._c
          return t('div', { staticClass: 'loading-contenter' }, [
            t('div', { staticClass: 'loading-logo' }),
            t('div', { staticClass: 'loading-animation' }),
          ])
        },
      ],
      m = {
        name: 'NeLoading',
        props: {
          visible: {
            type: Boolean,
            default: false,
          },
          cover: {
            type: Boolean,
            default: true,
          },
        },
        computed: {
          showCover: function () {
            return (
              console.info(
                '对象函数 showCover,filePath:renderer/components/Classroom/SmallClass/Common/H5courseware/loading/index.vue'
              ),
              this.cover ? '' : 'no-mask'
            )
          },
        },
      },
      h = m,
      f = (n('39b4'), n('2877')),
      p = Object(f.a)(h, d, u, false, null, '0f92e9a7', null),
      v = p.exports,
      C = function () {
        var e = this,
          t = e._self._c
        return e.visible
          ? t('div', { staticClass: 'game-courseware-mask-bg' }, [
              t('div', { staticClass: 'dialog-contenter' }, [
                t(
                  'div',
                  { staticClass: 'ne-dialog--body' },
                  [e._t('default')],
                  2
                ),
                e.$slots.footer
                  ? t(
                      'div',
                      { staticClass: 'ne-dialog--footer' },
                      [e._t('footer')],
                      2
                    )
                  : e._e(),
              ]),
            ])
          : e._e()
      },
      S = [],
      g = {
        name: 'NeLoading',
        props: {
          visible: {
            type: Boolean,
            default: false,
          },
        },
      },
      b = g,
      w = (n('022e'), Object(f.a)(b, C, S, false, null, 'cabb026c', null)),
      k = w.exports,
      L = function () {
        var e = this,
          t = e._self._c
        return t(
          'div',
          {
            ref: 'showPhotoWall',
            staticClass: 'showPhotoWall',
          },
          [
            t('NeLoading', {
              attrs: {
                visible: e.photoLoading,
                cover: false,
              },
            }),
            e.photoLoading
              ? e._e()
              : t('img', {
                  ref: 'photoImg',
                  attrs: { src: e.photoWallImg },
                }),
          ],
          1
        )
      },
      x = [],
      y = n('b795'),
      I = n.n(y),
      P = n('d190'),
      O = n.n(P),
      A = n('e525'),
      j = n.n(A),
      M = n('3a6c1'),
      T = n.n(M),
      R = n('233d'),
      B = n.n(R),
      D = n('ab6e'),
      V = n.n(D),
      N = n('a6a2'),
      E = n.n(N),
      _ = n('3143'),
      H = n.n(_),
      U = {
        name: 'showPhotoWall',
        data: function () {
          return { photoLoading: true }
        },
        props: {
          photoWallImg: {
            type: String,
            default: '',
          },
          isAudition: {
            type: Boolean,
            default: false,
          },
        },
        components: { NeLoading: v },
        methods: {
          handlePhotoWall: function (e) {
            var t = this
            console.info(
              '对象函数 handlePhotoWall(imgUrl)',
              e,
              'filePath:renderer/components/Classroom/SmallClass/Common/H5courseware/showPhotoWall.vue'
            )
            this.photoLoading = true
            this.isAudition || this.createLikeContainer()
            var n = new Image()
            n.src = e
            n.onload = function () {
              var e = document.getElementById('photoWallLikeContainer')
              e && (e.style.display = 'block')
              t.photoLoading = false
            }
          },
          createLikeContainer: function () {
            return Object(r.a)(
              Object(a.a)().mark(function e() {
                var t, n
                return Object(a.a)().wrap(function (e) {
                  while (1) {
                    switch ((e.prev = e.next)) {
                      case 0:
                        if (
                          (console.info(
                            '对象函数 createLikeContainer,filePath:renderer/components/Classroom/SmallClass/Common/H5courseware/showPhotoWall.vue'
                          ),
                          (t = document.getElementById(
                            'photoWallLikeContainer'
                          )),
                          !t)
                        ) {
                          e.next = 6
                          break
                        }
                        return (
                          console.info(
                            'if(likeContainer)为true触发return,path: /renderer/components/Classroom/SmallClass/Common/H5courseware/showPhotoWall.vue'
                          ),
                          e.abrupt('return')
                        )
                      case 6:
                        ;(n = document.createElement('div')),
                          n.setAttribute('id', 'photoWallLikeContainer'),
                          n.setAttribute('class', 'photoWallLikeContainer'),
                          (n.innerHTML =
                            '<div class="likeBtn" id="likeBtn">\n        <img src="'.concat(
                              H.a,
                              '" id="heart" />\n      </div>'
                            )),
                          document
                            .getElementById('interactionLeft')
                            .appendChild(n),
                          I.a.init({
                            icons: [V.a, O.a, j.a, T.a, E.a, B.a],
                            btnDom: 'likeBtn',
                            flyDom: 'photoWallLikeContainer',
                            className: 'fly',
                            width: 200,
                            height: 600,
                          })
                      case 12:
                      case 'end':
                        return e.stop()
                    }
                  }
                }, e)
              })
            )()
          },
          destroyLike: function () {
            return Object(r.a)(
              Object(a.a)().mark(function e() {
                var t
                return Object(a.a)().wrap(function (e) {
                  while (1) {
                    switch ((e.prev = e.next)) {
                      case 0:
                        console.info(
                          '对象函数 destroyLike,filePath:renderer/components/Classroom/SmallClass/Common/H5courseware/showPhotoWall.vue'
                        ),
                          (t = document.getElementById(
                            'photoWallLikeContainer'
                          )),
                          t && t.parentNode.removeChild(t),
                          I.a.destroy()
                      case 4:
                      case 'end':
                        return e.stop()
                    }
                  }
                }, e)
              })
            )()
          },
        },
        beforeDestroy: function () {
          console.info(
            '对象函数 beforeDestroy,filePath:renderer/components/Classroom/SmallClass/Common/H5courseware/showPhotoWall.vue'
          )
          this.destroyLike()
        },
        watch: {
          photoWallImg: function (e) {
            console.info(
              '对象函数 photoWallImg(val)',
              e,
              'filePath:renderer/components/Classroom/SmallClass/Common/H5courseware/showPhotoWall.vue'
            )
            e ? this.handlePhotoWall(e) : this.destroyLike()
          },
        },
      },
      $ = U,
      W =
        (n('fd71'),
        n('9858'),
        Object(f.a)($, L, x, false, null, '4a7d8c2d', null)),
      G = W.exports,
      F = n('d0db'),
      J = n('0a4b'),
      z = n('ceab'),
      Q = n('e39c'),
      K = n('c5ee'),
      q = function () {
        var e = this,
          t = e._self._c
        return t('div', { staticClass: 'back-screen-share-class' }, [
          t('video', {
            ref: 'screen-share-player',
            staticClass: 'video-js vjs-default-skin vjs-big-play-centered',
            staticStyle: {
              width: '100%',
              height: 'auto',
            },
            attrs: {
              id: 'screen-share-player',
              controls: '',
              preload: 'auto',
              crossorigin: 'anonymous',
              poster: '',
              autoplay: 'autoplay',
              'webkit-playsinline': 'true',
              playsinline: 'true',
            },
          }),
        ])
      },
      X = [],
      Y = (n('a9e3'), n('f0e2')),
      Z =
        (n('a151'),
        {
          created: function () {
            this.$bus.$on('sharePlay', this.play)
            this.$bus.$on('sharePause', this.pause)
            this.$bus.$on('shareChangeTime', this.changeTime)
            this.$bus.$on('shareScreenSpeed', this.changeSpeed)
          },
          props: {
            beginTime: {
              type: Number,
              default: 0,
            },
          },
          methods: {
            initPlay: function (e) {
              var t = this
              console.info(
                '对象函数 initPlay(url)',
                e,
                'filePath:renderer/components/Classroom/SmallClass/Common/H5courseware/screenSharePlayer/index.vue'
              )
              this.$nextTick(function () {
                var n = t
                t.myVideo = Object(Y.a)(
                  'screen-share-player',
                  {
                    bigPlayButton: true,
                    textTrackDisplay: false,
                    posterImage: false,
                    loop: false,
                    controls: false,
                    errorDisplay: false,
                    hls: { withCredentials: true },
                  },
                  function () {
                    this.on('loadedmetadata', function () {})
                    this.on('ended', function () {})
                    this.on('firstplay', function () {})
                    this.on('loadstart', function () {})
                    this.on('loadeddata', function () {
                      n.changeTime()
                    })
                    this.on('seeking', function () {})
                    this.on('seeked', function () {})
                    this.on('waiting', function () {})
                    this.on('pause', function () {})
                    this.on('play', function () {})
                  }
                )
                t.myVideo.src([
                  {
                    type: 'application/x-mpegURL',
                    src: e,
                  },
                ])
                t.myVideo.load(e)
              })
            },
            play: function () {
              console.info(
                '对象函数 play,filePath:renderer/components/Classroom/SmallClass/Common/H5courseware/screenSharePlayer/index.vue'
              )
              this.myVideo.play()
            },
            pause: function () {
              console.info(
                '对象函数 pause,filePath:renderer/components/Classroom/SmallClass/Common/H5courseware/screenSharePlayer/index.vue'
              )
              this.myVideo.pause()
            },
            changeTime: function () {
              console.info(
                '对象函数 changeTime,filePath:renderer/components/Classroom/SmallClass/Common/H5courseware/screenSharePlayer/index.vue'
              )
              var e =
                window.PSLiveClient.getseitimestamp() / 1000 -
                this.beginTime / 1000
              this.myVideo.currentTime(e)
            },
            changeSpeed: function (e) {
              console.info(
                '对象函数 changeSpeed(speed)',
                e,
                'filePath:renderer/components/Classroom/SmallClass/Common/H5courseware/screenSharePlayer/index.vue'
              )
              this.myVideo.playbackRate(e)
            },
          },
          destroyed: function () {
            console.info(
              '对象函数 destroyed,filePath:renderer/components/Classroom/SmallClass/Common/H5courseware/screenSharePlayer/index.vue'
            )
            this.$bus.$off('sharePlay')
            this.$bus.$off('sharePause')
            this.$bus.$off('shareChangeTime')
            this.$bus.$off('shareScreenSpeed')
            this.myVideo.dispose()
          },
        }),
      ee = Z,
      te = (n('6359'), Object(f.a)(ee, q, X, false, null, 'eb638810', null)),
      ne = te.exports,
      se = {
        props: ['ircconfig', 'playback', 'isAudition'],
        data: function () {
          return {
            baseData: this.$store.state.smallClass.baseData,
            coursewareInfo: null,
            coursewarePlayer: null,
            coursewareState: 'loading',
            blackBoardImg: null,
            photoWallImg: null,
            localUrl: null,
            coursewareStartLoadTime: 0,
            pageId: 0,
            currentCourseWareData: {},
            screenShareStatus: false,
            screenShareBeginTime: 0,
            screenVideoShow: false,
          }
        },
        components: {
          NeLoading: v,
          NeDialog: k,
          ShowPhotoWall: G,
          ScreenSharePlayer: ne,
        },
        computed: {
          teacherShareUid: function () {
            return (
              console.info(
                '对象函数 teacherShareUid,filePath:renderer/components/Classroom/SmallClass/Common/H5courseware/index.vue'
              ),
              this.baseData.configs.rtcConfig
                ? this.baseData.configs.rtcConfig.teacherShareUid
                : (console.info(
                    'if(!this.baseData.configs.rtcConfig)为true触发return,path: /renderer/components/Classroom/SmallClass/Common/H5courseware/index.vue'
                  ),
                  0)
            )
          },
          screenDomID: function () {
            return (
              console.info(
                '对象函数 screenDomID,filePath:renderer/components/Classroom/SmallClass/Common/H5courseware/index.vue'
              ),
              this.baseData.configs.rtcConfig
                ? 'screenShare-'.concat(
                    this.baseData.configs.rtcConfig.teacherShareUid
                  )
                : (console.info(
                    'if(!this.baseData.configs.rtcConfig)为true触发return,path: /renderer/components/Classroom/SmallClass/Common/H5courseware/index.vue'
                  ),
                  'screenShare-0')
            )
          },
        },
        created: function () {
          var e = this
          return Object(r.a)(
            Object(a.a)().mark(function t() {
              var n, s, o, c, d, u
              return Object(a.a)().wrap(function (t) {
                while (1) {
                  switch ((t.prev = t.next)) {
                    case 0:
                      return (
                        (n = Object(Q.o)('planId')),
                        (t.next = 3),
                        J.nativeApi.getClientInfo()
                      )
                    case 3:
                      return (
                        (s = t.sent),
                        (o = s.CW_SERVER_ADDRESS),
                        (c = s.CW_WEBROOT),
                        (t.next = 8),
                        Object(z.b)(1 * n)
                      )
                    case 8:
                      if (((d = t.sent), 0 === d.code)) {
                        t.next = 14
                        break
                      }
                      return (
                        console.info(
                          'if(courseware.code !== 0)为true触发return,path: /renderer/components/Classroom/SmallClass/Common/H5courseware/index.vue'
                        ),
                        (e.coursewareState = 'error'),
                        e.sendLogger(
                          'error',
                          '接口返回错误,'.concat(JSON.stringify(d))
                        ),
                        t.abrupt('return')
                      )
                    case 14:
                      if (0 !== d.data.list.length) {
                        t.next = 21
                        break
                      }
                      return (
                        console.info(
                          'if(courseware.data.list.length === 0)为true触发return,path: /renderer/components/Classroom/SmallClass/Common/H5courseware/index.vue'
                        ),
                        (e.coursewareState = 'noCourseware'),
                        e.$bus.$emit('corewareLoadStatus', {
                          status: 'loaded',
                        }),
                        e.sendLogger('error', '接口返回课件为空'),
                        e.$emit('courseWareReady', true),
                        t.abrupt('return')
                      )
                    case 21:
                      if (
                        (d.data.list.forEach(function (t) {
                          16 == t.id && (e.coursewareInfo = t)
                        }),
                        e.coursewareInfo)
                      ) {
                        t.next = 27
                        break
                      }
                      return (
                        console.info(
                          'if(!_this.coursewareInfo)为true触发return,path: /renderer/components/Classroom/SmallClass/Common/H5courseware/index.vue'
                        ),
                        (e.coursewareState = 'error'),
                        e.sendLogger('error', '没有主讲课件'),
                        t.abrupt('return')
                      )
                    case 27:
                      if (2 === e.coursewareInfo.detail.compressState) {
                        t.next = 32
                        break
                      }
                      return (
                        console.info(
                          'if(_this.coursewareInfo.detail.compressState !== 2)为true触发return,path: /renderer/components/Classroom/SmallClass/Common/H5courseware/index.vue'
                        ),
                        (e.coursewareState = 'error'),
                        e.sendLogger(
                          'error',
                          '课件没有同步完成,status:'.concat(
                            e.coursewareInfo.detail.compressState
                          )
                        ),
                        t.abrupt('return')
                      )
                    case 32:
                      return (
                        (t.next = 34),
                        Object(K.a)(
                          e.coursewareInfo.detail.baseZipUrl,
                          e.coursewareInfo.detail.baseZipMd5,
                          c
                        )
                      )
                    case 34:
                      ;(u = t.sent),
                        e.coursewareInfo.detail,
                        (e.localUrl = u
                          ? ''
                              .concat(o)
                              .concat(
                                e.coursewareInfo.detail.catalog,
                                '/index.html'
                              )
                          : ''),
                        (e.initCoursewareParams = {
                          role: 'student',
                          screenWidth: '100%',
                          screenHeight: '100%',
                          itsId: e.coursewareInfo.detail.id,
                          localUrl: e.localUrl,
                          remoteUrl: [
                            e.coursewareInfo.detail.compressIndexUrl,
                          ].concat(
                            Object(i.a)(
                              e.coursewareInfo.detail.compressIndexUrlSpareList
                            )
                          ),
                          onEvent: e.onEvent.bind(e),
                          showPagePercent: 30,
                          gameTip: e.$t(
                            'classroom.largeClass.coursewareBoard.gameConfig.gameTip'
                          ),
                          gameToast: e.$t(
                            'classroom.largeClass.coursewareBoard.gameConfig.gameToast'
                          ),
                          getLatestItsMessage: (function () {
                            var e = Object(r.a)(
                              Object(a.a)().mark(function e(t) {
                                var n
                                return Object(a.a)().wrap(function (e) {
                                  while (1) {
                                    switch ((e.prev = e.next)) {
                                      case 0:
                                        try {
                                          n = n && JSON.parse(n)
                                          t(n)
                                        } catch (s) {
                                          console.error(
                                            'error latest message',
                                            n,
                                            s
                                          )
                                        }
                                      case 1:
                                      case 'end':
                                        return e.stop()
                                    }
                                  }
                                }, e)
                              })
                            )
                            function t(t) {
                              return (
                                console.info(
                                  '函数申明 getLatestItsMessage(_x)',
                                  t,
                                  'filePath:renderer/components/Classroom/SmallClass/Common/H5courseware/index.vue'
                                ),
                                console.info(
                                  '函数申明 getLatestItsMessage(_x)',
                                  t,
                                  'filePath:renderer/components/Classroom/SmallClass/Common/H5courseware/index.vue'
                                ),
                                e.apply(this, arguments)
                              )
                            }
                            return t
                          })(),
                        }),
                        e.$nextTick(function () {
                          e.coursewarePlayer = l.a.getPlayer(
                            'student',
                            e.$refs.h5courseware
                          )
                          e.sendLogger('开始初始化课件')
                          e.coursewarePlayer.init(e.initCoursewareParams)
                        }),
                        (e.coursewareStartLoadTime = new Date().getTime())
                    case 40:
                    case 'end':
                      return t.stop()
                  }
                }
              }, t)
            })
          )()
        },
        mounted: function () {
          this.$bus.$on('liveRefresh', this.handleLiveRefresh)
          this.$bus.$on(
            'teachrLiveCloseScreenShare',
            this.handleTeachrLiveCloseScreenShare
          )
        },
        beforeDestroy: function () {
          console.info(
            '对象函数 beforeDestroy,filePath:renderer/components/Classroom/SmallClass/Common/H5courseware/index.vue'
          )
          this.$bus.$off('liveRefresh', this.handleLiveRefresh)
          this.$bus.$off(
            'teachrLiveCloseScreenShare',
            this.handleTeachrLiveCloseScreenShare
          )
        },
        methods: {
          handleLiveRefresh: function () {
            console.info(
              '对象函数 handleLiveRefresh,filePath:renderer/components/Classroom/SmallClass/Common/H5courseware/index.vue'
            )
            this.reloadCourseWare()
          },
          handleTeachrLiveCloseScreenShare: function () {
            console.info(
              '对象函数 handleTeachrLiveCloseScreenShare,filePath:renderer/components/Classroom/SmallClass/Common/H5courseware/index.vue'
            )
            this.screenShareStatus && this.screenShareStateChange(false)
          },
          reloadCourseWare: function () {
            console.info(
              '对象函数 reloadCourseWare,filePath:renderer/components/Classroom/SmallClass/Common/H5courseware/index.vue'
            )
            this.coursewareStartLoadTime = new Date().getTime()
            this.coursewarePlayer &&
              (this.sendLogger('重新开始初始化课件'),
              this.coursewarePlayer.init(this.initCoursewareParams))
          },
          onEvent: function (e, t) {
            switch (e) {
              case 'error':
                this.handleError(t)
                break
              case 'loadingProgress':
                this.handleLoadingProgress(t)
                break
              case 'statusChange':
                this.handleStatusChange(t)
                break
            }
          },
          handleError: function () {
            console.info(
              '对象函数 handleError,filePath:renderer/components/Classroom/SmallClass/Common/H5courseware/index.vue'
            )
            this.coursewareState = 'error'
            this.$emit('courseWareReady', false)
            this.sendLogger('error', 'iframe 加载失败')
          },
          handleLoadingProgress: function (e) {
            console.info(
              '对象函数 handleLoadingProgress(data)',
              e,
              'filePath:renderer/components/Classroom/SmallClass/Common/H5courseware/index.vue'
            )
            ;(e.loaded / e.total) * 100 >=
            this.initCoursewareParams.showPagePercent
              ? (this.$emit('courseWareReady', true),
                (this.coursewareState = 'loaded'))
              : (this.coursewareState = 'loading')
          },
          handleStatusChange: function (e) {
            console.info(
              '对象函数 handleStatusChange(data)',
              e,
              'filePath:renderer/components/Classroom/SmallClass/Common/H5courseware/index.vue'
            )
            this.$bus.$emit('corewareLoadStatus', e)
            'loaded' === e.status && this.sendLogger('loaded')
          },
          handleSwitchCourseware: function (e) {
            var t = this
            if (e && e.currentCourseWare) {
              this.currentCourseWareData = e.currentCourseWare
              var n = e.currentCourseWare,
                s = n.blackBoardType,
                o = n.imgUrl,
                i = n.jsString,
                c = n.photoWallImageArray,
                l = n.pageId
              if (
                (this.$bus.$emit('photoWallShow', false),
                (this.blackBoardImg = this.photoWallImg = ''),
                1 === s && o && (this.blackBoardImg = o),
                3 === s &&
                  c &&
                  ((this.photoWallImg = c[0]),
                  this.$bus.$emit('photoWallShow', true)),
                9 === s)
              ) {
                if (this.playback) {
                  if (this.pageId == l) {
                    return void console.info(
                      'if(this.pageId == pageId)为true触发return,path: /renderer/components/Classroom/SmallClass/Common/H5courseware/index.vue'
                    )
                  }
                  this.screenVideoShow = false
                  var d = this.baseData.playerOptions,
                    u = d.shareVideoMap[l]
                  if (!u) {
                    return void console.info(
                      'if(!videoUrl)为true触发return,path: /renderer/components/Classroom/SmallClass/Common/H5courseware/index.vue'
                    )
                  }
                  this.screenVideoShow = true
                  this.screenShareBeginTime = e.beginTime
                  this.$nextTick(
                    Object(r.a)(
                      Object(a.a)().mark(function e() {
                        return Object(a.a)().wrap(function (e) {
                          while (1) {
                            switch ((e.prev = e.next)) {
                              case 0:
                                t.$refs.player.initPlay(u)
                              case 1:
                              case 'end':
                                return e.stop()
                            }
                          }
                        }, e)
                      })
                    )
                  )
                } else {
                  this.screenShareStateChange(true)
                  this.beginScreeShare()
                }
              }
              0 === s &&
                this.screenShareStatus &&
                this.screenShareStateChange(false)
              0 === s &&
                i &&
                this.coursewarePlayer &&
                this.coursewarePlayer.handleRoomItsMessage(JSON.parse(i))
              this.playback &&
                9 !== s &&
                this.screenVideoShow &&
                (this.screenVideoShow = false)
              this.pageId = l
              this.$emit('changePageId', l, this.currentCourseWareData)
            } else {
              console.info(
                'if(!data || !data.currentCourseWare)为true触发return,path: /renderer/components/Classroom/SmallClass/Common/H5courseware/index.vue'
              )
            }
          },
          sendLogger: function (e) {
            var t = arguments,
              n = this
            return Object(r.a)(
              Object(a.a)().mark(function s() {
                var o, i, r, c, l
                return Object(a.a)().wrap(function (s) {
                  while (1) {
                    switch ((s.prev = s.next)) {
                      case 0:
                        return (
                          (o = t.length > 1 && void 0 !== t[1] ? t[1] : ''),
                          (i = (
                            (new Date().getTime() - n.coursewareStartLoadTime) /
                            1000
                          ).toFixed(2)),
                          (r = n.localUrl ? n.localUrl : ''),
                          (c = ''),
                          n.coursewareInfo &&
                            (r ||
                              (r = n.coursewareInfo.detail.compressIndexUrl),
                            (c = n.coursewareInfo.detail.id)),
                          (l = {
                            coursewareId: c,
                            url: r,
                            msg: o,
                            loadTime: parseFloat(i),
                            isOnlineUrl: n.localUrl ? 0 : 1,
                            isSuccess: 'loaded' == e ? 1 : 0,
                            isPlayback: 1 == n.playback ? 1 : 0,
                          }),
                          (s.next = 8),
                          F.a.send({
                            tag: 'coursewareLoad',
                            content: l,
                          })
                        )
                      case 8:
                      case 'end':
                        return s.stop()
                    }
                  }
                }, s)
              })
            )()
          },
          screenShareStateChange: function (e) {
            if (
              (console.info(
                '对象函数 screenShareStateChange(status)',
                e,
                'filePath:renderer/components/Classroom/SmallClass/Common/H5courseware/index.vue'
              ),
              !e)
            ) {
              var t = this.thinkClass.RtcService
              t.destroyRemoteVideo(this.teacherShareUid)
            }
            this.screenShareStatus = e
          },
          beginScreeShare: function () {
            var e = this
            console.info(
              '对象函数 beginScreeShare,filePath:renderer/components/Classroom/SmallClass/Common/H5courseware/index.vue'
            )
            var t = this.thinkClass.RtcService
            setTimeout(function () {
              var n = document.getElementById(e.screenDomID)
              'beginScreenShare:screenShare-'.concat(e.teacherShareUid)
              n && n.innerHTML
                ? console.info(
                    'if(screenShareElement && screenShareElement.innerHTML)为true触发return,path: /renderer/components/Classroom/SmallClass/Common/H5courseware/index.vue'
                  )
                : (t.createRemoteVideo(e.teacherShareUid, e.screenDomID),
                  t.setupViewContentMode(e.teacherShareUid, 1))
            }, 100)
          },
        },
      },
      oe = se,
      ae = (n('6092'), Object(f.a)(oe, s, o, false, null, '3d207ac5', null))
    t.a = ae.exports
  },
  '67c7': function (e, t, n) {},
  '6b78': function (e, t, n) {},
  '6c63': function (e, t, n) {
    'use strict'
    n('09ea')
  },
  '6e2e': function (e, t, n) {
    'use strict'
    n('e401')
  },
  '6ed2': function (e, t, n) {
    'use strict'
    n('8545')
  },
  '6f3a': function (e, t) {
    e.exports = require('url')
  },
  '761b': function (e, t, n) {},
  '77b24': function (e, t, n) {},
  7825: function (e, t, n) {
    'use strict'
    n('f96f')
  },
  7850: function (e, t, n) {},
  7859: function (e, t, n) {},
  '7a91': function (e, t, n) {},
  '7cbd': function (e, t, n) {
    'use strict'
    n('d1e5')
  },
  '7da2': function (e, t, n) {},
  '7e43': function (e, t, n) {
    'use strict'
    n('e94e')
  },
  8098: function (e, t, n) {},
  '80d0': function (e, t, n) {
    'use strict'
    n('ffae')
  },
  '82f9': function (e, t, n) {},
  8454: function (e, t, n) {
    'use strict'
    n('7a91')
  },
  8474: function (e, t, n) {},
  8545: function (e, t, n) {},
  '867f': function (e, t, n) {},
  '87cd': function (e, t, n) {
    'use strict'
    n('b0c0')
    var s = function () {
        var e = this,
          t = e._self._c
        return t(
          'div',
          {
            staticClass: 'header',
            style: { background: ''.concat(e.headerBg) },
          },
          [
            t(
              'div',
              {
                staticClass: 'wrapper ignore-wrapper',
                attrs: { 'data-log': 'header' },
              },
              [
                'win' == e.platform
                  ? t(
                      'div',
                      {
                        staticClass: 'windows-exit',
                        attrs: { 'data-log': 'win' },
                      },
                      [
                        t('div', {
                          staticClass: 'button button-exit',
                          attrs: { 'data-log': '退出按钮' },
                          on: { click: e.handleExit },
                        }),
                      ]
                    )
                  : e._e(),
                t('div', {
                  staticClass: 'drag-bar',
                  class: e.platform,
                }),
                t(
                  'div',
                  {
                    staticClass: 'title',
                    style: { color: ''.concat(e.titleColor) },
                  },
                  [
                    e.baseData.planInfo.name
                      ? t('span', { staticClass: 'plan-name' }, [
                          e._v(' ' + e._s(e.baseData.planInfo.name) + ' '),
                        ])
                      : e._e(),
                  ]
                ),
                t('div', { staticClass: 'operation-wrapper' }, [
                  t('div', { staticClass: 'operation-buttons' }, [
                    e.isPlayBack
                      ? e._e()
                      : t(
                          'div',
                          { staticClass: 'item' },
                          [t('NetworkStatus')],
                          1
                        ),
                    e.isPlayBack || e.isAllOnStageStatus
                      ? e._e()
                      : t('div', { staticClass: 'item' }, [
                          t('div', {
                            staticClass: 'button button-screenshot',
                            attrs: { 'data-log': '课中截图' },
                            on: { click: e.handleScreenshot },
                          }),
                        ]),
                    e.isPlayBack || e.isAllOnStageStatus
                      ? e._e()
                      : t('div', { staticClass: 'item' }, [
                          t('div', {
                            staticClass: 'button button-device',
                            attrs: { 'data-log': '硬件测试' },
                            on: { click: e.handleDeviceTest },
                          }),
                        ]),
                    e.isAllOnStageStatus
                      ? e._e()
                      : t('div', { staticClass: 'item' }, [
                          t('div', {
                            staticClass: 'button button-refresh',
                            attrs: { 'data-log': '刷新' },
                            on: { click: e.handleRefresh },
                          }),
                        ]),
                    e.isPlayBack
                      ? t('div', { staticClass: 'item' }, [
                          t('div', {
                            staticClass: 'button button-feedback',
                            attrs: { 'data-log': '回放反馈按钮' },
                            on: { click: e.handleFeedback },
                          }),
                        ])
                      : e._e(),
                    'mac' == e.platform
                      ? t(
                          'div',
                          {
                            staticClass: 'item',
                            attrs: { 'data-log': 'mac' },
                          },
                          [
                            t('div', {
                              staticClass: 'button button-exit',
                              attrs: { 'data-log': '课中退出按钮' },
                              on: { click: e.handleExit },
                            }),
                          ]
                        )
                      : e._e(),
                  ]),
                ]),
              ]
            ),
          ]
        )
      },
      o = [],
      a = n('c7eb'),
      i = n('1da1'),
      r =
        (n('ac1f'),
        n('841c'),
        n('a4d3'),
        n('e01a'),
        function () {
          var e = this,
            t = e._self._c
          return e.networkStatus
            ? t(
                'div',
                {
                  staticClass: 'network-status',
                  class: e.networkStatusClass,
                },
                [
                  t('div', {
                    staticClass: 'status-button',
                    on: {
                      mouseenter: e.handleMouseenter,
                      mouseleave: e.handleMouseleave,
                    },
                  }),
                  e.showStatusPanel
                    ? t('div', { staticClass: 'status-panel' }, [
                        t('div', { staticClass: 'panel-wrapper' }, [
                          t('div', { staticClass: 'title-wrapper' }, [
                            t('div', { staticClass: 'icon' }),
                            t('div', { staticClass: 'title' }, [
                              e._v(' ' + e._s(e.statusConfig.title) + ' '),
                            ]),
                          ]),
                          e.statusConfig.description
                            ? t('div', { staticClass: 'description' }, [
                                e._v(
                                  ' ' + e._s(e.statusConfig.description) + ' '
                                ),
                              ])
                            : e._e(),
                        ]),
                      ])
                    : e._e(),
                ]
              )
            : e._e()
        }),
      c = [],
      l = {
        data: function () {
          return {
            rtcengine: null,
            showStatusPanel: false,
          }
        },
        computed: {
          downlinkNetworkQuality: function () {
            return this.$store.state.smallClass.rtcDownlinkNetworkQuality
          },
          networkStatus: function () {
            return e[this.downlinkNetworkQuality] || ''
          },
          statusConfig: function () {
            console.info(
              '对象函数 statusConfig,filePath:renderer/components/Classroom/SmallClass/Common/NetworkStatus/index.vue'
            )
            var e = this.$t('classroom.modules.networkStatus.statusMap'),
              t = {
                good: { title: e.good.title },
                normal: { title: e.normal.title },
                weak: {
                  title: e.weak.title,
                  description: e.weak.description,
                },
              }
            return t[this.networkStatus] || {}
          },
          networkStatusClass: function () {
            return (
              console.info(
                '对象函数 networkStatusClass,filePath:renderer/components/Classroom/SmallClass/Common/NetworkStatus/index.vue'
              ),
              this.networkStatus ? 'status-'.concat(this.networkStatus) : ''
            )
          },
        },
        mounted: function () {},
        methods: {
          handleMouseenter: function () {
            console.info(
              '对象函数 handleMouseenter,filePath:renderer/components/Classroom/SmallClass/Common/NetworkStatus/index.vue'
            )
            this.showStatusPanel = true
          },
          handleMouseleave: function () {
            console.info(
              '对象函数 handleMouseleave,filePath:renderer/components/Classroom/SmallClass/Common/NetworkStatus/index.vue'
            )
            this.showStatusPanel = false
          },
        },
      },
      d = l,
      u = (n('ff5c'), n('2877')),
      m = Object(u.a)(d, r, c, false, null, 'fd48e134', null),
      h = m.exports,
      f = n('d0db'),
      p = n('e39c'),
      v = n('c5ee'),
      C = n('9c59'),
      S = n.n(C),
      g = n('c02a'),
      b = n('2b6b'),
      w = {
        components: { NetworkStatus: h },
        props: { backUrl: { type: String } },
        data: function () {
          var e = this.$store.state.smallClass.baseData
          return {
            baseData: e,
            platform: Object(p.k)(),
            loading: false,
            isPlayBack: !!e.isPlayBack,
            showMore: false,
            curBackUrl: '',
            lessonType: '',
          }
        },
        computed: {
          isAllOnStageStatus: function () {
            return (
              console.info(
                '对象函数 isAllOnStageStatus,filePath:renderer/components/Classroom/SmallClass/Common/Header/index.vue'
              ),
              this.$store.state.smallClass.isAllOnStageStatus
            )
          },
          titleColor: function () {
            return (
              console.info(
                '对象函数 titleColor,filePath:renderer/components/Classroom/SmallClass/Common/Header/index.vue'
              ),
              this.isAllOnStageStatus ? '#fff' : ''
            )
          },
          headerBg: function () {
            return (
              console.info(
                '对象函数 headerBg,filePath:renderer/components/Classroom/SmallClass/Common/Header/index.vue'
              ),
              this.isAllOnStageStatus ? '#ffaa0a' : ''
            )
          },
        },
        mounted: function () {
          var e = this.backUrl || window.location.href.split('curBackUrl=')[1]
          this.curBackUrl =
            e || window.location.href.split('backUrl=')[1] || '/courses'
          var t = S.a.parse(window.location.search)
          this.lessonType = v.g[t.lessonType] || ''
        },
        methods: {
          handleExit: function () {
            var e = this
            return Object(i.a)(
              Object(a.a)().mark(function t() {
                return Object(a.a)().wrap(function (t) {
                  while (1) {
                    switch ((t.prev = t.next)) {
                      case 0:
                        if (
                          (console.info(
                            '对象函数 handleExit,filePath:renderer/components/Classroom/SmallClass/Common/Header/index.vue'
                          ),
                          localStorage.setItem(
                            'smallClassTestCoverage',
                            JSON.stringify(window.__coverage__)
                          ),
                          !e.isPlayBack)
                        ) {
                          t.next = 7
                          break
                        }
                        return (
                          console.info(
                            'if(_this.isPlayBack)为true触发return,path: /renderer/components/Classroom/SmallClass/Common/Header/index.vue'
                          ),
                          f.a.send({
                            tag: 'student.Playback',
                            content: { msg: '学生点击退出回放' },
                          }),
                          (window.location.href = '/#' + e.curBackUrl),
                          t.abrupt('return')
                        )
                      case 7:
                        e.$Modal.confirm({
                          class: 'modal-simple apu-header',
                          content: e.$t(
                            'classroom.modules.header.backConfirm.content'
                          ),
                          okText: e.$t('common.yes'),
                          cancelText: e.$t('common.no'),
                          width: Object(p.v)(416),
                          centered: true,
                          zIndex: 3000,
                          onOk: function () {
                            if (!e.isPlayBack) {
                              var t, n, s, o
                              e.$bus.$emit('liveQuit')
                              var a =
                                  null === (t = e.baseData) || void 0 === t
                                    ? void 0
                                    : t.planInfo,
                                i = a.startStampTime,
                                r = void 0 === i ? '' : i,
                                c = a.endStampTime,
                                l = void 0 === c ? '' : c,
                                d = a.id,
                                u = void 0 === d ? '' : d
                              Object(p.A)(r, l) &&
                                e.$sensors.track('click_exit_btn', {
                                  isStartClass: true,
                                  isKickout: false,
                                  planId: +u,
                                  course_type: e.lessonType,
                                })
                              g.d(
                                null === (n = e.$store) ||
                                  void 0 === n ||
                                  null === (s = n.state) ||
                                  void 0 === s ||
                                  null === (o = s.common) ||
                                  void 0 === o
                                  ? void 0
                                  : o.timeOffset,
                                l
                              )
                              Object(b.setPlanId)({})
                            }
                            f.a.send({
                              tag: 'student.Quit',
                              content: { msg: '学生退出课堂' },
                            })
                            setTimeout(function () {
                              window.location.href = '/#' + e.curBackUrl
                            }, 1000)
                          },
                        })
                      case 8:
                      case 'end':
                        return t.stop()
                    }
                  }
                }, t)
              })
            )()
          },
          handleScreenshot: function () {
            var e = this
            return Object(i.a)(
              Object(a.a)().mark(function t() {
                return Object(a.a)().wrap(function (t) {
                  while (1) {
                    switch ((t.prev = t.next)) {
                      case 0:
                        console.info(
                          '对象函数 handleScreenshot,filePath:renderer/components/Classroom/SmallClass/Common/Header/index.vue'
                        ),
                          e.$bus.$emit('screenThumbnail')
                      case 2:
                      case 'end':
                        return t.stop()
                    }
                  }
                }, t)
              })
            )()
          },
          handleDeviceTest: function () {
            console.info(
              '对象函数 handleDeviceTest,filePath:renderer/components/Classroom/SmallClass/Common/Header/index.vue'
            )
            this.$bus.$emit('deviceTestShow')
          },
          handleRefresh: function () {
            var e
            console.info(
              '对象函数 handleRefresh,filePath:renderer/components/Classroom/SmallClass/Common/Header/index.vue'
            )
            this.$bus.$emit('liveRefresh')
            var t =
                null === (e = this.baseData) || void 0 === e
                  ? void 0
                  : e.planInfo,
              n = t.startStampTime,
              s = void 0 === n ? '' : n,
              o = t.endStampTime,
              a = void 0 === o ? '' : o
            Object(p.A)(s, a) &&
              this.$sensors.track('refresh_livePage', {
                course_type: this.lessonType,
              })
          },
          handleFeedback: function () {
            console.info(
              '对象函数 handleFeedback,filePath:renderer/components/Classroom/SmallClass/Common/Header/index.vue'
            )
            this.$bus.$emit('open_feedback')
          },
        },
      },
      k = w,
      L = (n('f3d9'), Object(u.a)(k, s, o, false, null, 'ff00d1c2', null))
    t.a = L.exports
  },
  '88f0': function (e, t, n) {},
  '8bbf': function (e, t) {
    e.exports = Vue
  },
  '8cad': function (e, t) {
    e.exports = require('util')
  },
  '8e57': function (e, t) {
    e.exports = require('os')
  },
  '8f59': function (e, t, n) {
    'use strict'
    n.r(t)
    n('dc5a')
    var s,
      o,
      a,
      i,
      r,
      c,
      l = n('56cd'),
      d = (n('3b18'), n('f64c')),
      u = (n('5704'), n('b558')),
      m = (n('2ef0'), n('9839')),
      h = (n('6ba6'), n('5efb')),
      f = (n('1273'), n('f2ca')),
      p = (n('fbd8'), n('55f1')),
      v = (n('9d5c'), n('a600')),
      C = (n('fbd6'), n('160c')),
      S = (n('cd17'), n('ed3b')),
      g = (n('8fb1'), n('0c63')),
      b = n('8bbf'),
      w = n.n(b),
      k = function () {
        var e = this,
          t = e._self._c
        return t(
          'div',
          { staticClass: 'small-class-page' },
          [
            e.isLoading
              ? [t('Loading', { attrs: { 'margin-top': '300px' } })]
              : e.errorObject.isShow
              ? [
                  t('ErrorStatus', {
                    attrs: {
                      message: e.errorObject.message,
                      showRefresh: e.errorObject.showRefresh,
                      isClassLiveOrPlayback: true,
                      scene: 'ClassLiving',
                      subMessage: e.subMessage,
                    },
                  }),
                ]
              : [t('Header', { attrs: { 'data-log': 'live层' } }), t('Live')],
          ],
          2
        )
      },
      L = [],
      x = n('c7eb'),
      y = n('1da1'),
      I = (n('b0c0'), n('ac1f'), n('841c'), n('a9e3'), n('bd12')),
      P = n('87cd'),
      O = n('aaf0'),
      A = function () {
        var e = this,
          t = e._self._c
        return e.onRtcServiceReady
          ? t(
              'div',
              { staticClass: 'live-container' },
              [e.isAllOnStageStatus ? t('WholeOnStage') : t('Live')],
              1
            )
          : e._e()
      },
      j = [],
      M = n('ade3'),
      T = n('53ca'),
      R = (n('99af'), n('d3b7'), n('25f0'), n('caad'), n('2532'), n('270c')),
      B = function () {
        var e = this,
          t = e._self._c
        return t('div', { staticClass: 'live-wrapper' }, [
          t(
            'div',
            { staticClass: 'live-controller' },
            [
              t('VideoGroup'),
              t(
                'div',
                {
                  staticClass: 'class-center-wrapper',
                  class: [
                    !e.isChatFull && e.chatBox.isShowBox ? 'wrapperspace' : '',
                  ],
                },
                [
                  e.showSpeaking
                    ? t('Speaking', {
                        staticClass: 'speaking-class',
                        attrs: { stuName: e.stuName },
                      })
                    : e._e(),
                  t(
                    'div',
                    { staticClass: 'courseware-board-wrapper' },
                    [
                      t('CoursewareBoard', {
                        attrs: { isAudition: e.isAudition },
                      }),
                      t(
                        'div',
                        {
                          staticClass: 'interaction-controller',
                          attrs: { id: 'interactionController' },
                        },
                        [t('Interactions')],
                        1
                      ),
                      t('Modules', { staticClass: 'modules-wrapper' }),
                      t('div', {
                        staticClass: 'interaction-full-left',
                        style: {
                          width: e.coursewareWidth / 2 + 'px',
                          marginLeft: e.interactionMarginLeft + 'px',
                        },
                        attrs: { id: 'interactionLeft' },
                      }),
                    ],
                    1
                  ),
                  t('Chatbox', {
                    ref: 'chatbox',
                    staticClass: 'chat-box-body',
                    class: [e.isChatFull ? 'chat-box-full' : 'chat-box-unfull'],
                    attrs: { showHeader: false },
                  }),
                  t(
                    'div',
                    { staticClass: 'sidebar-wrapper' },
                    [e.isAudition ? [t('AuditionPanel')] : [t('Sidebar')]],
                    2
                  ),
                ],
                1
              ),
            ],
            1
          ),
          t('div', {
            staticClass: 'interaction-full-page',
            attrs: { id: 'interactionFullPage' },
          }),
          t('div', {
            staticClass: 'interaction-game',
            attrs: { id: 'interactionGame' },
          }),
        ])
      },
      D = [],
      V = n('5530'),
      N = function () {
        var e = this,
          t = e._self._c
        return t('div', { staticClass: 'speaking-box' }, [
          t('span', { staticClass: 'student-name' }, [e._v(e._s(e.stuName))]),
          t('span', {
            class: ['vocal-print', e.styleName],
          }),
        ])
      },
      E = [],
      _ = {
        name: 'Speaking',
        components: {},
        data: function () {
          return {
            showTimer: null,
            showTime: 4,
            styleName: 'voice1',
          }
        },
        props: {
          stuName: {
            type: String,
            default: '',
          },
        },
        watch: {
          showTime: function (e) {
            console.info(
              '对象函数 showTime(val)',
              e,
              'filePath:renderer/components/Classroom/SmallClass/Live/Modules/Speaking/index.vue'
            )
            e % 3 == 2
              ? (this.styleName = 'voice1')
              : e % 3 == 1
              ? (this.styleName = 'voice3')
              : e % 3 == 0 && (this.styleName = 'voice2')
          },
        },
        mounted: function () {
          var e = this
          clearInterval(this.showTimer)
          this.showTime += 1
          this.showTimer = setInterval(function () {
            e.showTime += 1
          }, 1000)
        },
        destroyed: function () {
          console.info(
            '对象函数 destroyed,filePath:renderer/components/Classroom/SmallClass/Live/Modules/Speaking/index.vue'
          )
          clearInterval(this.showTimer)
        },
      },
      H = _,
      U = (n('80d0'), n('2877')),
      $ = Object(U.a)(H, N, E, false, null, 'efc9be9a', null),
      W = $.exports,
      G = function () {
        var e = this,
          t = e._self._c
        return t(
          'div',
          { staticClass: 'video-group-container' },
          [
            t('TeacherVideo', { attrs: { videoGroup: e.videoGroup } }),
            t('StudentVideo', { attrs: { videoGroup: e.videoGroup } }),
            t('StudentAudio', { attrs: { videoGroup: e.videoGroup } }),
          ],
          1
        )
      },
      F = [],
      J = n('d4ec'),
      z = n('bee2'),
      Q = (n('159b'), n('099c')),
      K = n('c342'),
      q = n('d0db'),
      X = (function () {
        function e() {
          var t =
            arguments.length > 0 && void 0 !== arguments[0] ? arguments[0] : {}
          console.info(
            '函数申明 _default(options)',
            t,
            'filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/videoGroup.js'
          )
          Object(J.a)(this, e)
          this.options = t
        }
        return (
          Object(z.a)(e, [
            {
              key: 'sendRtcStatus',
              value: (function () {
                var e = Object(y.a)(
                  Object(x.a)().mark(function e() {
                    var t,
                      n,
                      s,
                      o,
                      a,
                      i = arguments
                    return Object(x.a)().wrap(
                      function (e) {
                        while (1) {
                          switch ((e.prev = e.next)) {
                            case 0:
                              return (
                                (t =
                                  i.length > 0 && void 0 !== i[0] ? i[0] : {}),
                                (n = -1),
                                (e.next = 4),
                                Object(Q.c)()
                              )
                            case 4:
                              return (s = e.sent), (e.next = 7), Object(Q.f)()
                            case 7:
                              if (
                                ((o = e.sent),
                                s && (n = 1),
                                o && (n = 2),
                                s && o && (n = 3),
                                -1 != n)
                              ) {
                                e.next = 14
                                break
                              }
                              return (
                                console.info(
                                  'if(status == -1)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/LiveComponents/videoGroup.js'
                                ),
                                e.abrupt('return')
                              )
                            case 14:
                              return (
                                (a = {
                                  planId: this.options.planId,
                                  classId: this.options.classId,
                                  status: n,
                                  micPermission: o ? 1 : 2,
                                  cameraPermission: s ? 1 : 2,
                                  micIsOpen: o ? 1 : 2,
                                  cameraIsOpen: s ? 1 : 2,
                                }),
                                void 0 !== t.micIsOpen &&
                                  (a.micIsOpen = t.micIsOpen ? 1 : 2),
                                void 0 !== t.displayVideo &&
                                  (a.cameraIsOpen = t.displayVideo ? 1 : 2),
                                (e.next = 19),
                                Object(K.v)(a)
                              )
                            case 19:
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
                function t() {
                  return (
                    console.info(
                      '函数申明 sendRtcStatus, filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/videoGroup.js'
                    ),
                    e.apply(this, arguments)
                  )
                }
                return t
              })(),
            },
            {
              key: 'queryClassStudentList',
              value: (function () {
                var e = Object(y.a)(
                  Object(x.a)().mark(function e() {
                    var t, n
                    return Object(x.a)().wrap(
                      function (e) {
                        while (1) {
                          switch ((e.prev = e.next)) {
                            case 0:
                              return (
                                (e.next = 2),
                                Object(K.n)({
                                  planId: this.options.planId,
                                  classId: this.options.classId,
                                })
                              )
                            case 2:
                              if (((t = e.sent), t && 0 == t.code)) {
                                e.next = 6
                                break
                              }
                              return (
                                console.info(
                                  'if(!res || res.code != 0)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/LiveComponents/videoGroup.js'
                                ),
                                e.abrupt('return', [])
                              )
                            case 6:
                              return (n = t.data || []), e.abrupt('return', n)
                            case 8:
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
                function t() {
                  return (
                    console.info(
                      '函数申明 queryClassStudentList, filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/videoGroup.js'
                    ),
                    e.apply(this, arguments)
                  )
                }
                return t
              })(),
            },
            {
              key: 'hasUserIdByStudentList',
              value: function (e, t) {
                var n = false
                return (
                  e.forEach(function (e) {
                    ;(e.stuId != t && e.userId != t) || (n = true)
                  }),
                  n
                )
              },
            },
            {
              key: 'sendLogger',
              value: function (e) {
                q.a.send({
                  tag: 'videoGroup',
                  content: { msg: e },
                })
              },
            },
          ]),
          e
        )
      })(),
      Y = function () {
        var e = this,
          t = e._self._c
        return t(
          'div',
          { class: e.isAllOnStage ? 'isAllOnStage' : 'teacher-video-wrapper' },
          [
            t('div', { staticClass: 'teacher-video-container' }, [
              t('div', {
                directives: [
                  {
                    name: 'show',
                    rawName: 'v-show',
                    value: e.showTeacherVideo,
                    expression: 'showTeacherVideo',
                  },
                ],
                attrs: { id: 'teacherVideoContainer' },
              }),
            ]),
            t('div', { staticClass: 'video-info-wrapper' }, [
              e.teacherOnPrivateChatStatus
                ? t('div', { staticClass: 'help-other' }, [
                    t('div', { staticClass: 'name' }, [
                      t('i'),
                      e._v(e._s(e.$t('common.helpOthers'))),
                    ]),
                  ])
                : t('div', { staticClass: 'video-info-container' }, [
                    t('div', { staticClass: 'name' }, [
                      e._v(e._s(e.teacherName)),
                    ]),
                    e.teacherJoinChannelStatus
                      ? t(
                          'div',
                          { staticClass: 'microphone-wrapper' },
                          [
                            t('AudioWaves', {
                              attrs: {
                                microphoneStatus: e.teacherMicrophoneStatus,
                                microphoneStyle: 'bottleGreen',
                                microphoneHeight: '13',
                                volumeValue: e.volume,
                              },
                            }),
                          ],
                          1
                        )
                      : e._e(),
                  ]),
            ]),
            e.teacherOnStageStatus
              ? t('div', { staticClass: 'teacher-on-stage' }, [
                  t('div', { staticClass: 'stage-tips' }, [
                    e._v(e._s(e.$t('common.onStage'))),
                  ]),
                ])
              : e._e(),
          ]
        )
      },
      Z = [],
      ee = n('08fd'),
      te = {
        name: 'TeacherVideo',
        components: { AudioWaves: ee.a },
        props: {
          videoGroup: {
            type: Object,
            default: null,
          },
          isAllOnStage: {
            type: Boolean,
            default: false,
          },
        },
        data: function () {
          var e = this.$store.state.smallClass.baseData,
            t = e.teacherInfo,
            n = t.name,
            s = t.avatar
          return {
            baseData: e,
            teacherName: n,
            teacherAvatar: s,
            volume: 0,
            teacherMicrophoneStatus: false,
            teacherVideoStatus: false,
            teacherOnStageStatus: false,
            teacherOnPrivateChatStatus: false,
            rtcEventMap: {
              teacherVideoStart: this.teacherJoinhandle,
              teacherAudioStart: this.teacherAudioOpen,
              teacherVideoMute: this.teacherVideoMute,
              teacherAudioMute: this.teacherAudioMute,
              teacherVideoLeaveChannel: this.teacherVideoLeave,
              teacherAudioVolume: this.teacherAudioVolume,
            },
          }
        },
        computed: {
          teacherJoinChannelStatus: function () {
            return (
              console.info(
                '对象函数 teacherJoinChannelStatus,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/TeacherVideo/index.vue'
              ),
              true === this.$store.state.smallClass.teacherJoinChannelStatus
            )
          },
          showTeacherVideo: function () {
            return (
              console.info(
                '对象函数 showTeacherVideo,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/TeacherVideo/index.vue'
              ),
              this.teacherJoinChannelStatus && this.teacherVideoStatus
            )
          },
        },
        mounted: function () {
          var e = this.$store.state.smallClass.allStageDone
          if (e) {
            var t = this.$store.state.smallClass.teacherInfo
            if (t.videoStatus) {
              var n = this.thinkClass.RtcService
              document.getElementById('teacherVideoContainer').innerHTML = ''
              n.createRemoteVideo(t.uid, 'teacherVideoContainer')
              this.teacherVideoStatus = true
            }
          }
          this.listenerEvent()
          this.listenerRtcService()
        },
        methods: {
          teacherJoinhandle: function (e) {
            console.info(
              '对象函数 teacherJoinhandle(uid)',
              e,
              'filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/TeacherVideo/index.vue'
            )
            this.teacherOnStageStatus
              ? console.info(
                  'if(this.teacherOnStageStatus)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/LiveComponents/TeacherVideo/index.vue'
                )
              : (this.$store.dispatch('smallClass/updateTeacherInfo', {
                  uid: e,
                  videoStatus: true,
                }),
                (document.getElementById('teacherVideoContainer').innerHTML =
                  ''),
                this.thinkClass.RtcService.createTeacherVideo(
                  'teacherVideoContainer'
                ),
                (this.teacherVideoStatus = true),
                this.videoGroup.sendLogger('老师视频正常播放, uid: '.concat(e)))
          },
          teacherAudioOpen: function () {
            console.info(
              '对象函数 teacherAudioOpen,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/TeacherVideo/index.vue'
            )
            this.teacherMicrophoneStatus = true
          },
          teacherVideoMute: function (e) {
            console.info(
              '对象函数 teacherVideoMute(mute)',
              e,
              'filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/TeacherVideo/index.vue'
            )
            this.teacherVideoStatus = !e
            this.$store.dispatch('smallClass/updateTeacherVideoStatus', !e)
            this.videoGroup.sendLogger(
              '老师'.concat(e ? '关闭' : '开启', '视频')
            )
          },
          teacherAudioMute: function (e) {
            console.info(
              '对象函数 teacherAudioMute(mute)',
              e,
              'filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/TeacherVideo/index.vue'
            )
            this.teacherMicrophoneStatus = !e
            this.videoGroup.sendLogger(
              '老师'.concat(e ? '关闭' : '开启', '音频')
            )
          },
          teacherVideoLeave: function (e) {
            console.info(
              '对象函数 teacherVideoLeave(uid)',
              e,
              'filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/TeacherVideo/index.vue'
            )
            this.teacherOnStageStatus
              ? console.info(
                  'if(this.teacherOnStageStatus)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/LiveComponents/TeacherVideo/index.vue'
                )
              : (this.$store.dispatch('smallClass/updateTeacherInfo', {
                  uid: '',
                  videoStatus: false,
                }),
                this.thinkClass.RtcService.destroyTeacherVideo(),
                this.videoGroup.sendLogger(
                  '老师视频端离开频道, uid: '.concat(e)
                ))
          },
          teacherAudioVolume: function (e) {
            this.volume = e
          },
          listenerEvent: function () {
            console.info(
              '对象函数 listenerEvent,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/TeacherVideo/index.vue'
            )
            this.$bus.$on('teacherOnStageStatus', this.handleTeacherOnStage)
            this.$bus.$on(
              'teacherOnPrivateChat',
              this.handleTeacherOnPrivateChat
            )
          },
          removeListenerEvent: function () {
            console.info(
              '对象函数 removeListenerEvent,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/TeacherVideo/index.vue'
            )
            this.$bus.$off('teacherOnStageStatus', this.handleTeacherOnStage)
            this.$bus.$off(
              'teacherOnPrivateChat',
              this.handleTeacherOnPrivateChat
            )
          },
          listenerRtcService: function () {
            console.info(
              '对象函数 listenerRtcService,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/TeacherVideo/index.vue'
            )
            var e = this.thinkClass.RtcService
            for (var t in this.rtcEventMap) e.on(t, this.rtcEventMap[t])
          },
          removeRtcService: function () {
            console.info(
              '对象函数 removeRtcService,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/TeacherVideo/index.vue'
            )
            var e = this.thinkClass.RtcService
            for (var t in this.rtcEventMap) e.off(t, this.rtcEventMap[t])
          },
          handleTeacherOnStage: function (e) {
            console.info(
              '对象函数 handleTeacherOnStage(status)',
              e,
              'filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/TeacherVideo/index.vue'
            )
            this.teacherOnStageStatus = e
            this.$store.dispatch('smallClass/updateTeacherOnStageStatus', e)
            e
              ? (this.thinkClass.RtcService.destroyTeacherVideo(),
                (this.teacherVideoStatus = false))
              : (this.thinkClass.RtcService.createTeacherVideo(
                  'teacherVideoContainer'
                ),
                (this.teacherVideoStatus = true))
          },
          handleTeacherOnPrivateChat: function (e) {
            console.info(
              '对象函数 handleTeacherOnPrivateChat(notice)',
              e,
              'filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/TeacherVideo/index.vue'
            )
            this.teacherOnPrivateChatStatus = e.pub
          },
        },
        beforeDestroy: function () {
          console.info(
            '对象函数 beforeDestroy,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/TeacherVideo/index.vue'
          )
          this.removeListenerEvent()
          this.removeRtcService()
        },
      },
      ne = te,
      se = (n('30d6'), Object(U.a)(ne, Y, Z, false, null, '29962a8e', null)),
      oe = se.exports,
      ae = function () {
        var e = this,
          t = e._self._c
        return t(
          'div',
          { staticClass: 'student-video-wrapper' },
          [
            e.isParent
              ? [
                  e.myChildInfo && e.myChildInfo.inClass
                    ? t('RemoteVideo', {
                        key: e.myChildInfo.userId,
                        attrs: {
                          isChild: true,
                          remoteStuInfo: e.myChildInfo,
                          hideRemoteVideo: e.hideRemoteVideo,
                          remoteAudioStatus: e.remoteAudioStatus,
                        },
                        on: {
                          handleRemoteVideoStatus: e.handleRemoteVideoStatus,
                          clearEmoticon: e.handleClearEmoticon,
                          raiseHandUpdateStatus: e.handleRaiseHandUpdateStatus,
                        },
                      })
                    : t('OffLineVideo', {
                        attrs: { name: e.baseData.commonOption.nickName },
                      }),
                ]
              : e.isAudition && !e.isParent
              ? [t('LocalVideoAudition')]
              : [
                  t('LocalVideo', {
                    ref: 'LocalVideo',
                    attrs: { videoGroup: e.videoGroup },
                  }),
                ],
            t(
              'div',
              {
                ref: 'scroll',
                staticClass: 'remote-video-wrapper',
              },
              [
                t(
                  'div',
                  { staticClass: 'remote-video-container' },
                  [
                    e._l(e.inClassStudentList, function (n) {
                      return [
                        t('RemoteVideo', {
                          key: n.stuId,
                          attrs: {
                            isChild: false,
                            remoteStuInfo: n,
                            hideRemoteVideo: e.hideRemoteVideo,
                            remoteAudioStatus: e.remoteAudioStatus,
                            isExaminationStatus: e.isExaminationStatus,
                          },
                          on: {
                            handleRemoteVideoStatus: e.handleRemoteVideoStatus,
                            clearEmoticon: e.handleClearEmoticon,
                            raiseHandUpdateStatus:
                              e.handleRaiseHandUpdateStatus,
                          },
                        }),
                      ]
                    }),
                  ],
                  2
                ),
              ]
            ),
          ],
          2
        )
      },
      ie = [],
      re = n('b85c'),
      ce =
        (n('e260'),
        n('4ec9'),
        n('3ca3'),
        n('ddb0'),
        n('7db0'),
        n('4de4'),
        n('cca6'),
        function () {
          var e = this,
            t = e._self._c
          return t(
            'div',
            {
              staticClass: 'video-item video-local',
              class: {
                'mult-video-link': e.selfInfo.multVideoLinkStatus,
                'allOnStage-item': e.isAllOnStage,
                'three-line-status': e.studentList.length <= 9,
                'four-line-status': e.studentList.length > 9,
              },
            },
            [
              t('div', { staticClass: 'group-wrapper local-wrapper' }, [
                t('div', {
                  directives: [
                    {
                      name: 'show',
                      rawName: 'v-show',
                      value:
                        e.selfInfo.displayVideo &&
                        !e.wallRandomCallStatus &&
                        this.cameraStatus,
                      expression:
                        'selfInfo.displayVideo && !wallRandomCallStatus && this.cameraStatus',
                    },
                  ],
                  staticClass: 'video-wrapper',
                  attrs: { id: 'video-group-local' },
                }),
                e.selfInfo.displayVideo &&
                !e.wallRandomCallStatus &&
                this.cameraStatus
                  ? e._e()
                  : t('div', { staticClass: 'avatar-wrapper' }, [
                      t('img', { attrs: { src: e.selfInfo.avatar } }),
                    ]),
              ]),
              e.selfInfo.level
                ? t(
                    'div',
                    { staticClass: 'medal-wrapper' },
                    [
                      e.selfInfo.level > 0
                        ? t('MedalIcon', {
                            attrs: {
                              type: 'small',
                              level: e.selfInfo.level,
                            },
                          })
                        : e._e(),
                    ],
                    1
                  )
                : e._e(),
              e.selfInfo.raiseHandStatus
                ? t(
                    'div',
                    { staticClass: 'raise-hand-wrapper' },
                    [
                      t('RaiseHandMessage', {
                        attrs: { status: e.selfInfo.raiseHandStatus },
                        on: { updateStatus: e.handleRaiseHandUpdateStatus },
                      }),
                    ],
                    1
                  )
                : e._e(),
              e.selfInfo.emoticonName
                ? t(
                    'div',
                    { staticClass: 'emoji-wrapper' },
                    [
                      t('EmoticonMessage', {
                        attrs: {
                          willAutoClear: true,
                          name: e.selfInfo.emoticonName,
                          type: e.selfInfo.emoticonType,
                          emojiId: e.selfInfo.emojiId,
                          width:
                            e.isAllOnStage ||
                            2 == e.selfInfo.emoticonType ||
                            3 == e.selfInfo.emoticonType
                              ? 70
                              : 50,
                          height:
                            e.isAllOnStage ||
                            2 == e.selfInfo.emoticonType ||
                            3 == e.selfInfo.emoticonType
                              ? 70
                              : 50,
                          lottieUrl: e.selfInfo.lottieUrl,
                        },
                        on: { clearEmoticon: e.handleClearEmoticon },
                      }),
                    ],
                    1
                  )
                : e._e(),
              t(
                'div',
                { staticClass: 'video-info-wrapper local-info-wrapper' },
                [
                  t('div', { staticClass: 'video-info-container' }, [
                    t('div', { staticClass: 'name' }, [
                      e._v(
                        e._s(e.$t('common.me')) +
                          ' (' +
                          e._s(e.selfInfo.stuName) +
                          ')'
                      ),
                    ]),
                    t(
                      'div',
                      { staticClass: 'microphone-wrapper' },
                      [
                        t('AudioWaves', {
                          attrs: {
                            microphoneStatus: e.microphoneStatus,
                            microphoneStyle: 'bottleGreen',
                            microphoneHeight: '13',
                            volumeValue: e.selfInfo.volume,
                          },
                        }),
                      ],
                      1
                    ),
                  ]),
                ]
              ),
            ]
          )
        }),
      le = [],
      de = n('ef7c'),
      ue = function () {
        var e = this,
          t = e._self._c
        return e.status ? t('div', { staticClass: 'icon-raise-hand' }) : e._e()
      },
      me = [],
      he = {
        props: {
          status: {
            type: Boolean,
            default: false,
          },
          userId: {
            type: String,
            default: '',
          },
          duration: {
            type: Number,
            default: 10,
          },
        },
        computed: {},
        data: function () {
          return { timer: null }
        },
        watch: {
          status: {
            immediate: true,
            handler: function (e) {
              var t = this
              console.info(
                '对象函数 handler(newVal)',
                e,
                'filePath:renderer/components/Classroom/SmallClass/Common/RaiseHandMessage/index.vue'
              )
              e &&
                (this.timer && clearTimeout(this.timer),
                (this.timer = setTimeout(function () {
                  t.$emit('updateStatus', false, t.userId)
                }, 1000 * this.duration)))
            },
          },
        },
        mounted: function () {},
      },
      fe = he,
      pe = (n('bd31'), Object(U.a)(fe, ue, me, false, null, '19ac73b3', null)),
      ve = pe.exports,
      Ce = n('722b'),
      Se = n('5880'),
      ge = {
        components: {
          AudioWaves: ee.a,
          MedalIcon: de.a,
          RaiseHandMessage: ve,
          EmoticonMessage: Ce.a,
        },
        props: {
          videoGroup: {
            type: Object,
            default: null,
          },
          hideVideoIcon: {
            type: Boolean,
            default: false,
          },
          isAllOnStage: {
            type: Boolean,
            default: false,
          },
        },
        computed: Object(V.a)(
          Object(V.a)(
            {},
            Object(Se.mapState)('smallClass', [
              'isAllOnStageStatus',
              'cameraStatus',
              'microphoneStatus',
              'studentList',
              'baseData',
              'wallRandomCallStatus',
            ])
          ),
          {},
          {
            stuId: function () {
              return (
                console.info(
                  '对象函数 stuId,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/StudentVideo/LocalVideo.vue'
                ),
                this.baseData.stuInfo.id
              )
            },
            selfInfo: function () {
              var e = this
              return (
                console.info(
                  '对象函数 selfInfo,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/StudentVideo/LocalVideo.vue'
                ),
                this.studentList.find(function (t) {
                  return t.userId == e.stuId
                })
              )
            },
          }
        ),
        mounted: function () {
          this.listenerRtcService()
          this.listenerEvent()
        },
        methods: {
          localJoinHandle: function () {
            console.info(
              '对象函数 localJoinHandle,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/StudentVideo/LocalVideo.vue'
            )
            this.setupLocalVideo()
            this.$bus.$emit('closeStudentAudio')
            this.videoGroup.sendLogger('本地加入频道成功')
          },
          localVolume: function (e) {
            this.volume = e
          },
          updateCamera: function (e) {
            console.info(
              '对象函数 updateCamera(status)',
              e,
              'filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/StudentVideo/LocalVideo.vue'
            )
            this.videoGroup.sendRtcStatus({
              displayVideo: e,
              micIsOpen: this.microphoneStatus,
            })
            this.selfInfo.multVideoLinkStatus
              ? console.info(
                  'if(this.selfInfo.multVideoLinkStatus)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/LiveComponents/StudentVideo/LocalVideo.vue'
                )
              : this.handleLocalVideoStatus(e)
          },
          localDisplayVideoStatus: function (e) {
            console.info(
              '对象函数 localDisplayVideoStatus(callback)',
              e,
              'filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/StudentVideo/LocalVideo.vue'
            )
            e && e(this.cameraStatus)
          },
          localMicrophoneStatus: function (e) {
            console.info(
              '对象函数 localMicrophoneStatus(callback)',
              e,
              'filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/StudentVideo/LocalVideo.vue'
            )
            e && e(this.microphoneStatus)
          },
          levelChange: function (e) {
            console.info(
              '对象函数 levelChange(data)',
              e,
              'filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/StudentVideo/LocalVideo.vue'
            )
            this.updateStudentList(this.stuId, { level: e.level })
          },
          multVideoLinkChange: function (e) {
            var t = e.status,
              n = e.stuId
            if (
              (console.info(
                '对象函数 multVideoLinkChange(status, stuId)',
                t,
                n,
                'filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/StudentVideo/LocalVideo.vue'
              ),
              !n)
            ) {
              return (
                console.info(
                  'if(!stuId)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/LiveComponents/StudentVideo/LocalVideo.vue'
                ),
                void console.warn('多人上台互动消息\uFF0C未传入学生id')
              )
            }
            var s = n == this.stuId
            s &&
              (2 == t
                ? this.updateStudentList(this.stuId, {
                    multVideoLinkStatus: true,
                  })
                : 3 == t
                ? (this.updateStudentList(this.stuId, {
                    multVideoLinkStatus: false,
                  }),
                  this.handleLocalVideoStatus(this.cameraStatus))
                : console.warn('多人上台互动消息\uFF0Cstatus错误:'.concat(t)))
          },
          listenerRtcService: function () {
            console.info(
              '对象函数 listenerRtcService,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/StudentVideo/LocalVideo.vue'
            )
            var e = this.thinkClass.RtcService
            e.on('localJoinChannel', this.localJoinHandle)
            e.on('localAudioVolume', this.localVolume)
          },
          listenerEvent: function () {
            this.$bus.$on('updateCameraStatus', this.updateCamera)
            this.$bus.$on(
              'updateMicrophoneStatus',
              this.handleLocalMicrophoneStatus
            )
            this.$bus.$on(
              'getLocalDisplayVideoStatus',
              this.localDisplayVideoStatus
            )
            this.$bus.$on(
              'getLocalMicrophoneStatus',
              this.localMicrophoneStatus
            )
            this.$bus.$on('chats.correctSelfMedalData', this.levelChange)
            this.$bus.$on('multVideoLinkStatus', this.multVideoLinkChange)
            this.$bus.$on('sendEmoji', this.handleEmoticon)
            this.$bus.$on('sendRaiseHand', this.handleRaiseHandUpdateStatus)
          },
          removeAllListener: function () {
            console.info(
              '对象函数 removeAllListener,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/StudentVideo/LocalVideo.vue'
            )
            var e = this.thinkClass.RtcService
            e.off('localJoinChannel', this.localJoinHandle)
            e.off('localAudioVolume', this.localVolume)
            this.$bus.$off('updateCameraStatus', this.updateCamera)
            this.$bus.$off(
              'updateMicrophoneStatus',
              this.handleLocalMicrophoneStatus
            )
            this.$bus.$off(
              'getLocalDisplayVideoStatus',
              this.localDisplayVideoStatus
            )
            this.$bus.$off(
              'getLocalMicrophoneStatus',
              this.localMicrophoneStatus
            )
            this.$bus.$off('chats.correctSelfMedalData', this.levelChange)
            this.$bus.$off('multVideoLinkStatus', this.multVideoLinkChange)
            this.$bus.$off('sendEmoji', this.handleEmoticon)
            this.$bus.$off('sendRaiseHand', this.handleRaiseHandUpdateStatus)
          },
          setupLocalVideo: function () {
            console.info(
              '对象函数 setupLocalVideo,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/StudentVideo/LocalVideo.vue'
            )
            this.cameraStatus && !this.selfInfo.multVideoLinkStatus
              ? (this.thinkClass.RtcService.createLocalVideo(
                  'video-group-local'
                ),
                this.selfInfo.displayVideo ||
                  this.updateStudentList(this.stuId, { displayVideo: true }))
              : console.info(
                  'if(!this.cameraStatus || this.selfInfo.multVideoLinkStatus)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/LiveComponents/StudentVideo/LocalVideo.vue'
                )
          },
          hideLocalVideo: function () {
            console.info(
              '对象函数 hideLocalVideo,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/StudentVideo/LocalVideo.vue'
            )
            this.updateStudentList(this.stuId, { displayVideo: false })
          },
          handleLocalVideoStatus: function (e) {
            console.info(
              '对象函数 handleLocalVideoStatus(status)',
              e,
              'filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/StudentVideo/LocalVideo.vue'
            )
            this.thinkClass.RtcService.muteLocalVideo(!e)
            this.updateStudentList(this.stuId, { displayVideo: e })
            this.videoGroup.sendRtcStatus({
              displayVideo: e,
              micIsOpen: this.microphoneStatus,
            })
            var t = document.getElementById('video-group-local')
            this.selfInfo.displayVideo &&
              !t.innerHTML &&
              this.thinkClass.RtcService.createLocalVideo('video-group-local')
            this.videoGroup.sendLogger('本地视频开关状态, status: '.concat(e))
          },
          handleLocalMicrophoneStatus: function (e) {
            console.info(
              '对象函数 handleLocalMicrophoneStatus(status)',
              e,
              'filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/StudentVideo/LocalVideo.vue'
            )
            this.thinkClass.RtcService.muteLocalAudio(!e)
            this.videoGroup.sendLogger('本地音频开关状态, status: '.concat(e))
          },
          handleEmoticon: function (e) {
            console.info(
              '对象函数 handleEmoticon(params)',
              e,
              'filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/StudentVideo/LocalVideo.vue'
            )
            var t = {
              emoticonName: e.name,
              emoticonType: e.type,
            }
            ;(2 != e.type && 3 != e.type) ||
              (t = Object.assign(t, {
                lottieUrl: e.lottieUrl,
                emojiId: e.emojiId,
              }))
            this.updateStudentList(this.stuId, t)
          },
          handleClearEmoticon: function () {
            console.info(
              '对象函数 handleClearEmoticon,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/StudentVideo/LocalVideo.vue'
            )
            this.updateStudentList(this.stuId, e)
          },
          handleRaiseHandUpdateStatus: function (e) {
            console.info(
              '对象函数 handleRaiseHandUpdateStatus(status)',
              e,
              'filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/StudentVideo/LocalVideo.vue'
            )
            this.updateStudentList(this.stuId, { raiseHandStatus: e })
          },
          updateStudentList: function (e, t) {
            console.info(
              '对象函数 updateStudentList(uid, data)',
              e,
              t,
              'filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/StudentVideo/LocalVideo.vue'
            )
            this.$store.dispatch('smallClass/updateStudentList', {
              uid: e,
              data: t,
            })
          },
        },
        beforeDestroy: function () {
          console.info(
            '对象函数 beforeDestroy,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/StudentVideo/LocalVideo.vue'
          )
          this.removeAllListener()
        },
        watch: {
          isAllOnStageStatus: {
            handler: function (e) {
              var t = this
              console.info(
                '对象函数 handler(newVal)',
                e,
                'filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/StudentVideo/LocalVideo.vue'
              )
              0 == e &&
                this.$nextTick(function () {
                  t.setupLocalVideo()
                })
            },
            immediate: true,
          },
        },
      },
      be = ge,
      we = (n('488c'), Object(U.a)(be, ce, le, false, null, '41fc2fa8', null)),
      ke = we.exports,
      Le = function () {
        var e = this,
          t = e._self._c
        return t(
          'div',
          {
            staticClass: 'video-item video-remote',
            class: {
              'mult-video-link': e.remoteStuInfo.multVideoLinkStatus,
              'allOnStage-item': e.isAllOnStage,
              'three-line-status': e.studentLists.length <= 9,
              'four-line-status': e.studentLists.length > 9,
              'remote-audio-border': e.border,
            },
            attrs: {
              'data-id': e.remoteStuInfo.stuId,
              id: 'remote-observe-'.concat(e.remoteStuInfo.stuId),
            },
          },
          [
            t(
              'div',
              {
                directives: [
                  {
                    name: 'show',
                    rawName: 'v-show',
                    value: e.remoteStuInfo.cameraStatus,
                    expression: 'remoteStuInfo.cameraStatus',
                  },
                ],
                staticClass: 'item-wrapper',
              },
              [
                t('div', { staticClass: 'group-wrapper' }, [
                  t('div', {
                    directives: [
                      {
                        name: 'show',
                        rawName: 'v-show',
                        value: e.showRemoteVideo,
                        expression: 'showRemoteVideo',
                      },
                    ],
                    staticClass: 'video-wrapper',
                    attrs: { id: 'remote-' + e.remoteStuInfo.stuId },
                  }),
                  e.showRemoteAvatar
                    ? t('div', { staticClass: 'avatar-wrapper' }, [
                        t('img', { attrs: { src: e.remoteStuInfo.avatar } }),
                      ])
                    : e._e(),
                ]),
              ]
            ),
            e.remoteStuInfo.cameraStatus
              ? e._e()
              : [
                  t('div', { staticClass: 'group-wrapper' }, [
                    t('div', { staticClass: 'avatar-wrapper' }, [
                      t('img', { attrs: { src: e.remoteStuInfo.avatar } }),
                    ]),
                  ]),
                ],
            t('div', { staticClass: 'video-info-wrapper allOnStage-info' }, [
              t('div', { staticClass: 'video-info-container' }, [
                t('div', { staticClass: 'name' }, [
                  e._v(e._s(e.remoteStuInfo.stuName)),
                ]),
                (e.remoteAudioStatus || e.isChild) &&
                e.remoteStuInfo.displayVideo
                  ? t(
                      'div',
                      { staticClass: 'microphone-wrapper' },
                      [
                        t('AudioWaves', {
                          attrs: {
                            microphoneStyle: 'bottleGreen',
                            microphoneHeight: '13',
                            microphoneStatus: e.microphoneStatus,
                            volumeValue: e.remoteStuInfo.volume,
                          },
                        }),
                      ],
                      1
                    )
                  : e._e(),
                e.remoteStuInfo.displayVideo
                  ? e._e()
                  : t('div', { staticClass: 'disabled-wrapper' }, [
                      t('div', { staticClass: 'icon-disabled' }),
                    ]),
              ]),
            ]),
            e.remoteStuInfo.level
              ? t(
                  'div',
                  { staticClass: 'medal-wrapper' },
                  [
                    e.remoteStuInfo.level > 0
                      ? t('MedalIcon', {
                          attrs: {
                            type: 'small',
                            level: e.remoteStuInfo.level,
                          },
                        })
                      : e._e(),
                  ],
                  1
                )
              : e._e(),
            e.remoteStuInfo.raiseHandStatus
              ? t(
                  'div',
                  { staticClass: 'raise-hand-wrapper' },
                  [
                    t('RaiseHandMessage', {
                      attrs: { status: e.remoteStuInfo.raiseHandStatus },
                      on: { updateStatus: e.handleRaiseHandUpdateStatus },
                    }),
                  ],
                  1
                )
              : e._e(),
            t(
              'div',
              {
                directives: [
                  {
                    name: 'show',
                    rawName: 'v-show',
                    value: e.showEmoji && e.remoteStuInfo.emoticonName,
                    expression: 'showEmoji && remoteStuInfo.emoticonName',
                  },
                ],
                staticClass: 'emoji-wrapper',
              },
              [
                t('EmoticonMessage', {
                  attrs: {
                    willAutoClear: true,
                    name: e.remoteStuInfo.emoticonName,
                    type: e.remoteStuInfo.emoticonType,
                    emojiId: e.remoteStuInfo.emojiId,
                    lottieUrl: e.remoteStuInfo.lottieUrl,
                    width: e.emoticonStyle ? 70 : 50,
                    height: e.emoticonStyle ? 70 : 50,
                  },
                  on: { clearEmoticon: e.handleClearEmoticon },
                }),
              ],
              1
            ),
            t('div', { staticClass: 'video-switch-wrapper' }, [
              t('div', { staticClass: 'video-switch-container' }, [
                e.remoteStuInfo.displayVideo
                  ? t(
                      'div',
                      {
                        staticClass: 'hide-video-button',
                        on: { click: e.handleRemoteVideoStatus },
                      },
                      [
                        e._v(
                          ' ' +
                            e._s(e.$t('classroom.smallClass.videoGroup.hide')) +
                            ' '
                        ),
                      ]
                    )
                  : e._e(),
                e.remoteStuInfo.displayVideo
                  ? e._e()
                  : t(
                      'div',
                      {
                        staticClass: 'show-video-button',
                        on: { click: e.handleRemoteVideoStatus },
                      },
                      [
                        e._v(
                          ' ' +
                            e._s(e.$t('classroom.smallClass.videoGroup.show')) +
                            ' '
                        ),
                      ]
                    ),
              ]),
            ]),
          ],
          2
        )
      },
      xe = [],
      ye =
        (n('e6cf'),
        {
          components: {
            AudioWaves: ee.a,
            MedalIcon: de.a,
            RaiseHandMessage: ve,
            EmoticonMessage: Ce.a,
          },
          data: function () {
            return { border: false }
          },
          props: {
            remoteStuInfo: {
              type: Object,
              default: null,
            },
            hideRemoteVideo: {
              type: Boolean,
              default: null,
            },
            remoteAudioStatus: {
              type: Boolean,
              default: null,
            },
            isAllOnStage: {
              type: Boolean,
              default: false,
            },
            isExaminationStatus: {
              type: Boolean,
              default: false,
            },
            isChild: {
              type: Boolean,
              default: false,
            },
          },
          computed: {
            showRemoteVideo: function () {
              return (
                console.info(
                  '对象函数 showRemoteVideo,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/StudentVideo/RemoteVideo.vue'
                ),
                this.remoteStuInfo.isIntersecting &&
                  this.remoteStuInfo.displayVideo &&
                  !this.remoteStuInfo.mutedVideoStatus &&
                  !this.remoteStuInfo.multVideoLinkStatus &&
                  !this.hideRemoteVideo &&
                  !this.isExaminationStatus
              )
            },
            showRemoteAvatar: function () {
              return (
                console.info(
                  '对象函数 showRemoteAvatar,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/StudentVideo/RemoteVideo.vue'
                ),
                !this.remoteStuInfo.isIntersecting ||
                  !this.remoteStuInfo.displayVideo ||
                  this.remoteStuInfo.mutedVideoStatus ||
                  this.remoteStuInfo.multVideoLinkStatus ||
                  this.hideRemoteVideo ||
                  this.isExaminationStatus
              )
            },
            microphoneStatus: function () {
              return (
                console.info(
                  '对象函数 microphoneStatus,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/StudentVideo/RemoteVideo.vue'
                ),
                this.remoteStuInfo.microphoneStatus
              )
            },
            showEmoji: function () {
              return (
                console.info(
                  '对象函数 showEmoji,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/StudentVideo/RemoteVideo.vue'
                ),
                this.remoteStuInfo.displayVideo
              )
            },
            studentLists: function () {
              return (
                console.info(
                  '对象函数 studentLists,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/StudentVideo/RemoteVideo.vue'
                ),
                this.$store.state.smallClass.studentList
              )
            },
            emoticonStyle: function () {
              console.info(
                '对象函数 emoticonStyle,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/StudentVideo/RemoteVideo.vue'
              )
              var e =
                this.isAllOnStage ||
                2 == this.remoteStuInfo.emoticonType ||
                3 == this.remoteStuInfo.emoticonType
              return e
            },
          },
          mounted: function () {
            this.remoteStuInfo
          },
          methods: {
            handleRemoteVideoStatus: function () {
              console.info(
                '对象函数 handleRemoteVideoStatus,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/StudentVideo/RemoteVideo.vue'
              )
              this.$emit(
                'handleRemoteVideoStatus',
                this.remoteStuInfo.stuId,
                !this.remoteStuInfo.displayVideo
              )
            },
            handleClearEmoticon: function () {
              console.info(
                '对象函数 handleClearEmoticon,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/StudentVideo/RemoteVideo.vue'
              )
              this.$emit('clearEmoticon', this.remoteStuInfo.stuId)
            },
            handleRaiseHandUpdateStatus: function (e) {
              console.info(
                '对象函数 handleRaiseHandUpdateStatus(status)',
                e,
                'filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/StudentVideo/RemoteVideo.vue'
              )
              this.$emit('raiseHandUpdateStatus', this.remoteStuInfo.stuId, e)
            },
            sleep: function (e) {
              return (
                console.info(
                  '对象函数 sleep(time)',
                  e,
                  'filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/StudentVideo/RemoteVideo.vue'
                ),
                new Promise(function (t) {
                  return setTimeout(t, e)
                })
              )
            },
          },
          watch: {
            'remoteStuInfo.volume': {
              handler: function (e) {
                var t = this
                e >= 100
                  ? ((this.border = true),
                    this.sleep(1000).then(function () {
                      console.info(
                        '箭头函数 then,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/StudentVideo/RemoteVideo.vue'
                      )
                      t.border = false
                    }))
                  : console.warn('用户声音小于100')
              },
            },
          },
        }),
      Ie = ye,
      Pe = (n('9df9'), Object(U.a)(Ie, Le, xe, false, null, '8da045e6', null)),
      Oe = Pe.exports,
      Ae = n('229e'),
      je = n('0d3b'),
      Me = function () {
        var e = this,
          t = e._self._c
        return t(
          'div',
          { staticClass: 'video-item video-remote video-parent-audition' },
          [
            t('div', { staticClass: 'notice' }, [
              e._v(
                ' ' +
                  e._s(
                    e.$t(
                      'classroom.smallClass.videoGroup.localVideoAudition.offline'
                    )
                  ) +
                  ' '
              ),
            ]),
            t('div', { staticClass: 'name' }, [e._v(e._s(e.name))]),
          ]
        )
      },
      Te = [],
      Re = {
        props: {
          name: {
            type: String,
            default: '',
          },
        },
      },
      Be = Re,
      De = (n('bf49'), Object(U.a)(Be, Me, Te, false, null, '621263c8', null)),
      Ve = De.exports,
      Ne = n('4b91'),
      Ee = n('35ac'),
      _e = {
        name: 'StudentVideo',
        components: {
          LocalVideo: ke,
          RemoteVideo: Oe,
          LocalVideoAudition: Ne.default,
          OffLineVideo: Ve,
        },
        props: {
          videoGroup: {
            type: Object,
            default: null,
          },
        },
        data: function () {
          return {
            bs: null,
            videoLinkStatus: false,
            otherCameraStatus: false,
            pageNum: 1,
            pageSize: 6,
            isExaminationStatus: false,
            canShowOtherChild: false,
            noInStudentListCache: new Map(),
            intersectionObserver: null,
          }
        },
        computed: Object(V.a)(
          Object(V.a)(
            {},
            Object(Se.mapState)('smallClass', [
              'cameraStatus',
              'isAllOnStageStatus',
              'remoteAudioStatus',
              'studentList',
              'baseData',
              'wallRandomCallStatus',
            ])
          ),
          {},
          {
            myChildInfo: function () {
              return (
                console.info(
                  '对象函数 myChildInfo,filePath:renderer/components/Classroom/SmallClass/Live/VideoGroup/StudentVideo/index.vue'
                ),
                this.studentList.find(function (e) {
                  return e.currentParentsChild
                })
              )
            },
            isAudition: function () {
              return (
                console.info(
                  '对象函数 isAudition,filePath:renderer/components/Classroom/SmallClass/Live/VideoGroup/StudentVideo/index.vue'
                ),
                this.baseData.commonOption.isAudition
              )
            },
            isParent: function () {
              return (
                console.info(
                  '对象函数 isParent,filePath:renderer/components/Classroom/SmallClass/Live/VideoGroup/StudentVideo/index.vue'
                ),
                this.baseData.commonOption.isParent
              )
            },
            inClassStudentList: function () {
              var e = this
              console.info(
                '对象函数 inClassStudentList,filePath:renderer/components/Classroom/SmallClass/Live/VideoGroup/StudentVideo/index.vue'
              )
              var t = this.studentList.filter(function (e) {
                return e.inClass && !e.currentParentsChild && !e.isSelf
              })
              return (
                this.$nextTick(function () {
                  e.bs.refresh()
                }),
                t
              )
            },
            inClassAndNoStage: function () {
              return (
                console.info(
                  '对象函数 inClassAndNoStage,filePath:renderer/components/Classroom/SmallClass/Live/VideoGroup/StudentVideo/index.vue'
                ),
                this.studentList.filter(function (e) {
                  return (
                    e.inClass &&
                    !e.currentParentsChild &&
                    !e.isSelf &&
                    !e.multVideoLinkStatus
                  )
                })
              )
            },
            hideRemoteVideo: function () {
              return (
                console.info(
                  '对象函数 hideRemoteVideo,filePath:renderer/components/Classroom/SmallClass/Live/VideoGroup/StudentVideo/index.vue'
                ),
                this.otherCameraStatus || this.wallRandomCallStatus
              )
            },
            teacherShareUid: function () {
              return (
                console.info(
                  '对象函数 teacherShareUid,filePath:renderer/components/Classroom/SmallClass/Live/VideoGroup/StudentVideo/index.vue'
                ),
                this.baseData.configs.rtcConfig.teacherShareUid
              )
            },
          }
        ),
        created: function () {
          this.initVideoShow()
          Ae.a.use(je.a)
        },
        mounted: function () {
          this.bs = new Ae.a(this.$refs.scroll, {
            scrollX: true,
            scrollY: false,
            mouseWheel: true,
            disableMouse: false,
            disableTouch: false,
            bounce: false,
          })
          this.initObserver()
          this.init()
        },
        methods: {
          initObserver: function () {
            var e = this
            console.info(
              '对象函数 initObserver,filePath:renderer/components/Classroom/SmallClass/Live/VideoGroup/StudentVideo/index.vue'
            )
            this.intersectionObserver = new IntersectionObserver(
              function (t) {
                var n,
                  s = Object(re.a)(t)
                try {
                  for (s.s(); !(n = s.n()).done; ) {
                    var o = n.value,
                      a = o.target.dataset.id
                    e.updateStudentList(a, { isIntersecting: o.isIntersecting })
                    e.setMaxVolumeStudent()
                  }
                } catch (i) {
                  s.e(i)
                } finally {
                  s.f()
                }
              },
              {
                root: document.querySelectorAll('.remote-video-wrapper')[0],
                threshold: 0.2,
              }
            )
          },
          toggleObserver: function (e, t) {
            console.info(
              '对象函数 toggleObserver(uid, isObserve)',
              e,
              t,
              'filePath:renderer/components/Classroom/SmallClass/Live/VideoGroup/StudentVideo/index.vue'
            )
            var n = document.querySelector('#remote-observe-'.concat(e))
            n
              ? t
                ? this.intersectionObserver.observe(n)
                : (this.intersectionObserver.unobserve(n),
                  this.setMaxVolumeStudent())
              : console.info(
                  'if(!ele)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/VideoGroup/StudentVideo/index.vue'
                )
          },
          init: function () {
            var e = this
            console.info(
              '对象函数 init,filePath:renderer/components/Classroom/SmallClass/Live/VideoGroup/StudentVideo/index.vue'
            )
            this.inClassStudentList.length > 0 &&
              this.inClassStudentList.forEach(function (t) {
                e.$nextTick(function () {
                  e.thinkClass.RtcService.createRemoteVideo(
                    t.userId,
                    'remote-'.concat(t.userId)
                  )
                  e.toggleObserver(t.userId, true)
                })
              })
            this.listenerRtcService()
            this.listenerSignalService()
            this.listenerEvent()
          },
          initVideoShow: function () {
            var e = this
            return Object(y.a)(
              Object(x.a)().mark(function t() {
                return Object(x.a)().wrap(function (t) {
                  while (1) {
                    switch ((t.prev = t.next)) {
                      case 0:
                        if (
                          (console.info(
                            '对象函数 initVideoShow,filePath:renderer/components/Classroom/SmallClass/Live/VideoGroup/StudentVideo/index.vue'
                          ),
                          !e.isParent)
                        ) {
                          t.next = 7
                          break
                        }
                        return (t.next = 4), Object(Ee.d)('showOtherChild')
                      case 4:
                        ;(e.canShowOtherChild = t.sent), (t.next = 8)
                        break
                      case 7:
                        e.canShowOtherChild = true
                      case 8:
                      case 'end':
                        return t.stop()
                    }
                  }
                }, t)
              })
            )()
          },
          listenerRtcService: function () {
            var e = this
            console.info(
              '对象函数 listenerRtcService,filePath:renderer/components/Classroom/SmallClass/Live/VideoGroup/StudentVideo/index.vue'
            )
            var t = this.thinkClass.RtcService
            t.on('remoteJoinChannel', function (t) {
              console.info(
                '箭头函数 监听 remoteJoinChannel(uid)',
                t,
                'filePath:renderer/components/Classroom/SmallClass/Live/VideoGroup/StudentVideo/index.vue'
              )
              e.teacherShareUid
              e.videoGroup.sendLogger('远端学生加入频道, uid: '.concat(t))
              e.updateClassStudent(t)
            })
            t.on('remoteLeaveChannel', function (t) {
              console.info(
                '箭头函数 监听 remoteLeaveChannel(uid)',
                t,
                'filePath:renderer/components/Classroom/SmallClass/Live/VideoGroup/StudentVideo/index.vue'
              )
              e.handleRemoteLeaveChannel(t)
              e.videoGroup.sendLogger('远端学生离开频道, uid: '.concat(t))
            })
            t.on('remoteAudioVolume', function (t, n) {
              e.updateStudentList(t, { volume: n })
              e.setMaxVolumeStudent()
            })
            t.on('studentVideoStart', this.creatStudentVideo)
            t.on('studentVideoMute', this.muteVideoHandle)
            t.on('remoteAudioStateChanged', function (t, n, s) {
              console.info(
                '箭头函数 监听 remoteAudioStateChanged(uid, state, reason)',
                t,
                n,
                s,
                'filePath:renderer/components/Classroom/SmallClass/Live/VideoGroup/StudentVideo/index.vue'
              )
              var o = {}
              1 === n && (o.microphoneStatus = true)
              5 === s && (o.microphoneStatus = false)
              e.updateStudentList(t, o)
              e.updateNoInStudentListCache(t, o)
            })
          },
          listenerSignalService: function () {
            var e = this
            console.info(
              '对象函数 listenerSignalService,filePath:renderer/components/Classroom/SmallClass/Live/VideoGroup/StudentVideo/index.vue'
            )
            var t = this.thinkClass.SignalService
            t.on('onRecvRoomMessage', function (t) {
              console.info(
                '箭头函数 监听 onRecvRoomMessage(res)',
                t,
                'filePath:renderer/components/Classroom/SmallClass/Live/VideoGroup/StudentVideo/index.vue'
              )
              var n = t.content,
                s = t.fromUserInfo,
                o = n.ircType,
                a = n.data
              'send_emoji' == o
                ? e.handleEmoticon(s.psId, {
                    name: a.name,
                    type: a.type,
                  })
                : 'animation_emoji' == o &&
                  e.handleEmoticon(
                    s.psId,
                    Object(V.a)(
                      {
                        type: a.type,
                        name: a.resource.emojiName,
                      },
                      a.resource
                    )
                  )
              'raise_hand' == o && e.handleRaiseHandUpdateStatus(s.psId, true)
            })
          },
          listenerEvent: function () {
            var e = this
            console.info(
              '对象函数 listenerEvent,filePath:renderer/components/Classroom/SmallClass/Live/VideoGroup/StudentVideo/index.vue'
            )
            this.$bus.$on('cameraStatus', function (t) {
              console.info(
                '箭头函数 监听 cameraStatus(status)',
                t,
                'filePath:renderer/components/Classroom/SmallClass/Live/VideoGroup/StudentVideo/index.vue'
              )
              t
                ? e.thinkClass.RtcService.muteLocalVideo(true)
                : e.thinkClass.RtcService.muteLocalVideo(false)
            })
            this.$bus.$on('setDefaultVideoDevice', function (t) {
              console.info(
                '箭头函数 监听 setDefaultVideoDevice(deviceId)',
                t,
                'filePath:renderer/components/Classroom/SmallClass/Live/VideoGroup/StudentVideo/index.vue'
              )
              e.thinkClass.RtcService.setVideoDevice(t)
            })
            this.$bus.$on('resetSpeaking', function () {
              console.info(
                '箭头函数 监听 resetSpeaking,filePath:renderer/components/Classroom/SmallClass/Live/VideoGroup/StudentVideo/index.vue'
              )
              e.setMaxVolumeStudent()
            })
            this.$bus.$on('remoteAudioStatus', function (t) {
              console.info(
                '箭头函数 监听 remoteAudioStatus(status)',
                t,
                'filePath:renderer/components/Classroom/SmallClass/Live/VideoGroup/StudentVideo/index.vue'
              )
              e.$store.dispatch('smallClass/updateRemoteAudioStatus', t)
            })
            this.$bus.$on('multVideoLinkStatus', function (t) {
              var n = t.pub,
                s = t.status,
                o = t.stuId
              if (
                (console.info(
                  '箭头函数 监听 multVideoLinkStatus(pub, status, stuId)',
                  n,
                  s,
                  o,
                  'filePath:renderer/components/Classroom/SmallClass/Live/VideoGroup/StudentVideo/index.vue'
                ),
                o)
              ) {
                var a = o == e.baseData.stuInfo.id && !e.isParent
                n &&
                  2 == s &&
                  (a
                    ? e.$refs.LocalVideo.hideLocalVideo()
                    : e.thinkClass.RtcService.destroyRemoteVideo(o),
                  e.updateStudentList(o, { multVideoLinkStatus: true }))
                n &&
                  3 == s &&
                  (a
                    ? e.$refs.LocalVideo.setupLocalVideo()
                    : e.thinkClass.RtcService.createRemoteVideo(
                        o,
                        'remote-'.concat(o)
                      ),
                  e.updateStudentList(o, { multVideoLinkStatus: false }))
                e.setMaxVolumeStudent()
              } else {
                console.info(
                  'if(!stuId)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/VideoGroup/StudentVideo/index.vue'
                )
              }
            })
            this.$bus.$on('liveQuit', function () {
              console.info(
                '箭头函数 监听 liveQuit,filePath:renderer/components/Classroom/SmallClass/Live/VideoGroup/StudentVideo/index.vue'
              )
              e.thinkClass.RtcService.unpublish()
              e.thinkClass.RtcService.leaveChannel()
            })
            this.$bus.$on('chats.correctMedalData', function (t) {
              console.info(
                '箭头函数 监听 chats.correctMedalData(data)',
                t,
                'filePath:renderer/components/Classroom/SmallClass/Live/VideoGroup/StudentVideo/index.vue'
              )
              e.updateStudentList(t.userId, { level: t.level })
            })
            this.$bus.$on('setExaminationStatus', function (t) {
              console.info(
                '箭头函数 监听 setExaminationStatus(data)',
                t,
                'filePath:renderer/components/Classroom/SmallClass/Live/VideoGroup/StudentVideo/index.vue'
              )
              e.isExaminationStatus = t
            })
            this.$bus.$on('wallRandomCall', function (t) {
              var n = t.pub
              console.info(
                '箭头函数 监听 wallRandomCall(pub)',
                n,
                'filePath:renderer/components/Classroom/SmallClass/Live/VideoGroup/StudentVideo/index.vue'
              )
              n
                ? e.inClassAndNoStage.forEach(function (t) {
                    e.thinkClass.RtcService.destroyRemoteVideo(t.userId)
                  })
                : (e.inClassAndNoStage.forEach(function (t) {
                    e.thinkClass.RtcService.createRemoteVideo(
                      t.userId,
                      'remote-'.concat(t.userId)
                    )
                  }),
                  e.$refs.LocalVideo.setupLocalVideo())
              e.$store.dispatch('smallClass/updateWallRandomCallStatus', n)
            })
          },
          handleRemoteJoinChannel: function (e) {
            var t = this
            console.info(
              '对象函数 handleRemoteJoinChannel(uid)',
              e,
              'filePath:renderer/components/Classroom/SmallClass/Live/VideoGroup/StudentVideo/index.vue'
            )
            this.isMyChild(e)
              ? this.updateStudentList(e, {
                  inClass: true,
                  currentParentsChild: true,
                })
              : this.canShowOtherChild &&
                (this.updateStudentList(e, { inClass: true }),
                this.$nextTick(function () {
                  t.toggleObserver(e, true)
                }))
          },
          handleRemoteLeaveChannel: function (e) {
            console.info(
              '对象函数 handleRemoteLeaveChannel(uid)',
              e,
              'filePath:renderer/components/Classroom/SmallClass/Live/VideoGroup/StudentVideo/index.vue'
            )
            this.toggleObserver(e, false)
            this.updateNoInStudentListCache(e, { inClass: false })
            this.updateStudentList(e, { inClass: false })
            this.remoteStuInfo
          },
          handleRemoteVideoStatus: function (e, t) {
            console.info(
              '对象函数 handleRemoteVideoStatus(stuId, status)',
              e,
              t,
              'filePath:renderer/components/Classroom/SmallClass/Live/VideoGroup/StudentVideo/index.vue'
            )
            this.updateStudentList(e, { displayVideo: t })
            this.videoGroup.sendLogger(
              '学生操作远端视频开关状态, uid: '.concat(e, ' status: ').concat(t)
            )
          },
          handleEmoticon: function (e, t) {
            console.info(
              '对象函数 handleEmoticon(stuId, params)',
              e,
              t,
              'filePath:renderer/components/Classroom/SmallClass/Live/VideoGroup/StudentVideo/index.vue'
            )
            var n = {
              emoticonName: t.name,
              emoticonType: t.type,
              lottieUrl: t.lottieUrl,
              emojiId: t.emojiId,
            }
            this.updateStudentList(e, n)
          },
          handleClearEmoticon: function (e) {
            console.info(
              '对象函数 handleClearEmoticon(stuId)',
              e,
              'filePath:renderer/components/Classroom/SmallClass/Live/VideoGroup/StudentVideo/index.vue'
            )
            this.updateStudentList(e, t)
          },
          handleRaiseHandUpdateStatus: function (e, t) {
            console.info(
              '对象函数 handleRaiseHandUpdateStatus(stuId, status)',
              e,
              t,
              'filePath:renderer/components/Classroom/SmallClass/Live/VideoGroup/StudentVideo/index.vue'
            )
            this.remoteStuInfo
            this.updateStudentList(e, { raiseHandStatus: t })
          },
          updateClassStudent: function (e) {
            console.info(
              '对象函数 updateClassStudent(uid)',
              e,
              'filePath:renderer/components/Classroom/SmallClass/Live/VideoGroup/StudentVideo/index.vue'
            )
            var t = this.studentList.find(function (t) {
              return e == t.userId
            })
            t ? this.handleRemoteJoinChannel(e) : this.getOriginClassStudent(e)
          },
          getOriginClassStudent: function (e) {
            var t = this
            return Object(y.a)(
              Object(x.a)().mark(function n() {
                var s, o, a, i, r
                return Object(x.a)().wrap(function (n) {
                  while (1) {
                    switch ((n.prev = n.next)) {
                      case 0:
                        return (
                          console.info(
                            '对象函数 getOriginClassStudent(uid)',
                            e,
                            'filePath:renderer/components/Classroom/SmallClass/Live/VideoGroup/StudentVideo/index.vue'
                          ),
                          t.noInStudentListCache.set(e, {
                            cameraStatus: false,
                            microphoneStatus: true,
                            mutedVideoStatus: false,
                            inClass: true,
                          }),
                          (s = t.baseData.commonOption),
                          (n.next = 5),
                          Object(K.n)({
                            planId: s.planId,
                            classId: s.classId,
                          })
                        )
                      case 5:
                        ;(o = n.sent),
                          o &&
                            0 == o.code &&
                            ((a = o.data || []),
                            (i = a.find(function (t) {
                              return t.userId == e
                            })),
                            i &&
                              ((r = t.noInStudentListCache.get(e)),
                              t.$store.dispatch(
                                'smallClass/concatStudentList',
                                {
                                  stuInfo: i,
                                  rtcInfo: r,
                                }
                              ),
                              t.noInStudentListCache.delete(e),
                              t.remoteAudioStatus ||
                                t.thinkClass.RtcService.muteRemoteAudio(
                                  e,
                                  true
                                ),
                              t.$nextTick(function () {
                                t.thinkClass.RtcService.createRemoteVideo(
                                  e,
                                  'remote-'.concat(e)
                                )
                              })))
                      case 7:
                      case 'end':
                        return n.stop()
                    }
                  }
                }, n)
              })
            )()
          },
          setMaxVolumeStudent: function () {
            var e = '',
              t = 0
            this.remoteAudioStatus &&
              this.inClassStudentList.forEach(function (n) {
                !n.multVideoLinkStatus &&
                  n.microphoneStatus &&
                  n.volume > 100 &&
                  n.volume > t &&
                  !n.isIntersecting &&
                  ((t = n.volume), (e = n.stuName))
              })
            this.$store.dispatch('smallClass/updateMaxVolumeStudent', {
              volume: t,
              stuName: e,
            })
          },
          isMyChild: function (e) {
            return (
              console.info(
                '对象函数 isMyChild(uid)',
                e,
                'filePath:renderer/components/Classroom/SmallClass/Live/VideoGroup/StudentVideo/index.vue'
              ),
              this.isParent && e == this.baseData.commonOption.stuId
            )
          },
          creatStudentVideo: function (e) {
            console.info(
              '对象函数 creatStudentVideo(uid)',
              e,
              'filePath:renderer/components/Classroom/SmallClass/Live/VideoGroup/StudentVideo/index.vue'
            )
            this.updateStudentList(e, t)
            this.updateNoInStudentListCache(e, t)
            var n = document.getElementById('remote-'.concat(e))
            if (n && n.innerHTML) {
              return (
                console.info(
                  'if(remoteElement && remoteElement.innerHTML)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/VideoGroup/StudentVideo/index.vue'
                ),
                void console.warn(
                  '当前已创建学生视频\uFF0C禁止重复触发,uid\uFF1A'.concat(e)
                )
              )
            }
            this.thinkClass.RtcService.createRemoteVideo(e, 'remote-'.concat(e))
          },
          muteVideoHandle: function (e, t) {
            console.info(
              '对象函数 muteVideoHandle(mute, uid)',
              e,
              t,
              'filePath:renderer/components/Classroom/SmallClass/Live/VideoGroup/StudentVideo/index.vue'
            )
            var n = { mutedVideoStatus: e }
            this.updateStudentList(t, n)
            this.updateNoInStudentListCache(t, n)
          },
          updateStudentList: function (e, t) {
            this.$store.dispatch('smallClass/updateStudentList', {
              uid: e,
              data: t,
            })
          },
          updateNoInStudentListCache: function (e, t) {
            console.info(
              '对象函数 updateNoInStudentListCache(uid, data)',
              e,
              t,
              'filePath:renderer/components/Classroom/SmallClass/Live/VideoGroup/StudentVideo/index.vue'
            )
            this.noInStudentListCache.has(e) &&
              Object.assign(this.noInStudentListCache.get(e), t)
          },
        },
        beforeDestroy: function () {
          console.info(
            '对象函数 beforeDestroy,filePath:renderer/components/Classroom/SmallClass/Live/VideoGroup/StudentVideo/index.vue'
          )
          this.intersectionObserver && this.intersectionObserver.disconnect()
          this.bs.destroy()
        },
      },
      He = _e,
      Ue = (n('4a42'), Object(U.a)(He, ae, ie, false, null, 'dfc395c4', null)),
      $e = Ue.exports,
      We =
        (n('14d9'),
        {
          name: 'StudentAudio',
          data: function () {
            var e = this.$store.state.smallClass.baseData,
              t = this.$store.state.smallClass.teacherInfo,
              n = e.commonOption.isParent,
              s = e.commonOption.isAudition
            return {
              baseData: e,
              speakStudentList: [],
              remoteAudioStatus: false,
              teacherData: t,
              isParent: n,
              isAudition: s,
            }
          },
          props: {
            videoGroup: {
              type: Object,
              default: null,
            },
          },
          computed: Object(V.a)(
            {},
            Object(Se.mapState)('smallClass', [
              'interactionStatus',
              'videoMicLinkUsers',
              'cameraStatus',
              'studentList',
            ])
          ),
          mounted: function () {
            this.muteAudio()
            this.listenerEvent()
          },
          methods: {
            muteAudio: function () {
              console.info(
                '对象函数 muteAudio,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/StudentAudio/index.vue'
              )
              ;(this.isParent || this.isAudition) &&
                this.thinkClass.RtcService.on(
                  'localJoinChannel',
                  this.audioClose
                )
            },
            microphoneChange: function (e) {
              console.info(
                '对象函数 microphoneChange(status)',
                e,
                'filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/StudentAudio/index.vue'
              )
              this.videoGroup.sendRtcStatus({
                micIsOpen: e,
                displayVideo: this.cameraStatus,
              })
            },
            closeStudentAudio: function () {
              console.info(
                '对象函数 closeStudentAudio,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/StudentAudio/index.vue'
              )
              this.remoteAudioStatus
                ? console.warn('irc已先触发开启语音')
                : this.audioClose()
            },
            remoteAudioChange: function (e) {
              console.info(
                '对象函数 remoteAudioChange(status)',
                e,
                'filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/StudentAudio/index.vue'
              )
              this.videoGroup.sendLogger(
                '收到语音管理状态变化, status: '.concat(e)
              )
              this.remoteAudioStatus = e
              e ? this.audioOpen() : this.audioClose()
            },
            chatAudioChange: function (e) {
              var t = this
              console.info(
                '对象函数 chatAudioChange(noticeContent)',
                e,
                'filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/StudentAudio/index.vue'
              )
              e.pub
                ? (this.$store.dispatch('smallClass/updatePrivateChatInfo', e),
                  this.baseData.commonOption.stuId == e.userId
                    ? this.studentList.forEach(function (n) {
                        n.userId != e.userId &&
                          t.thinkClass.RtcService.muteRemoteAudio(
                            n.userId,
                            true
                          )
                      })
                    : (this.thinkClass.RtcService.muteRemoteAudio(
                        this.baseData.configs.rtcConfig.teacherUid,
                        true
                      ),
                      this.thinkClass.RtcService.muteRemoteAudio(
                        e.userId,
                        true
                      )))
                : (this.$store.dispatch('smallClass/updatePrivateChatInfo', {}),
                  this.baseData.commonOption.stuId == e.userId
                    ? this.studentList.forEach(function (n) {
                        n.userId != e.userId &&
                          t.thinkClass.RtcService.muteRemoteAudio(
                            n.userId,
                            false
                          )
                      })
                    : (this.thinkClass.RtcService.muteRemoteAudio(
                        this.baseData.configs.rtcConfig.teacherUid,
                        false
                      ),
                      this.thinkClass.RtcService.muteRemoteAudio(
                        e.userId,
                        false
                      )))
            },
            multVideoLinkChange: function (e) {
              var t = e.pub,
                n = e.status,
                s = e.stuId
              console.info(
                '对象函数 multVideoLinkChange(pub, status, stuId)',
                t,
                n,
                s,
                'filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/StudentAudio/index.vue'
              )
              t &&
                3 == n &&
                (this.remoteAudioStatus ||
                  this.thinkClass.RtcService.muteRemoteAudio(s, true))
            },
            listenerEvent: function () {
              console.info(
                '对象函数 listenerEvent,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/StudentAudio/index.vue'
              )
              this.$bus.$on('updateMicrophoneStatus', this.microphoneChange)
              this.$bus.$on('closeStudentAudio', this.closeStudentAudio)
              this.$bus.$on('remoteAudioStatus', this.remoteAudioChange)
              this.$bus.$on('changeAudioStatus', this.chatAudioChange)
              this.$bus.$on('multVideoLinkStatus', this.multVideoLinkChange)
            },
            removeListenerEvent: function () {
              console.info(
                '对象函数 removeListenerEvent,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/StudentAudio/index.vue'
              )
              this.$bus.$off('updateMicrophoneStatus', this.microphoneChange)
              this.$bus.$off('closeStudentAudio', this.closeStudentAudio)
              this.$bus.$off('remoteAudioStatus', this.remoteAudioChange)
              this.$bus.$off('changeAudioStatus', this.chatAudioChange)
              this.$bus.$off('multVideoLinkStatus', this.multVideoLinkChange)
            },
            audioOpen: function () {
              var e = this
              return Object(y.a)(
                Object(x.a)().mark(function t() {
                  var n, s, o
                  return Object(x.a)().wrap(function (t) {
                    while (1) {
                      switch ((t.prev = t.next)) {
                        case 0:
                          if (
                            (console.info(
                              '对象函数 audioOpen,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/StudentAudio/index.vue'
                            ),
                            (n = e.$store.state.smallClass.privateChatInfo),
                            (s = null === n || void 0 === n ? void 0 : n.pub),
                            !s ||
                              e.baseData.commonOption.stuId !=
                                (null === n || void 0 === n
                                  ? void 0
                                  : n.userId))
                          ) {
                            t.next = 6
                            break
                          }
                          return (
                            console.info(
                              'if(pub && _this2.baseData.commonOption.stuId == privateChatInfo?.userId)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/LiveComponents/StudentAudio/index.vue'
                            ),
                            t.abrupt('return')
                          )
                        case 6:
                          ;(o = e.getSpeakStudentList()),
                            o.forEach(function (t) {
                              s &&
                              t ==
                                (null === n || void 0 === n ? void 0 : n.userId)
                                ? e.thinkClass.RtcService.muteRemoteAudio(
                                    t,
                                    true
                                  )
                                : e.thinkClass.RtcService.muteRemoteAudio(
                                    t,
                                    false
                                  )
                            }),
                            e.videoGroup.sendLogger(
                              '拉取远端学生音频流, 远端学生列表: '.concat(
                                JSON.stringify(o)
                              )
                            )
                        case 9:
                        case 'end':
                          return t.stop()
                      }
                    }
                  }, t)
                })
              )()
            },
            audioClose: function () {
              var e = this
              console.info(
                '对象函数 audioClose,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/StudentAudio/index.vue'
              )
              var t = this.getSpeakStudentList()
              t.forEach(function (t) {
                ;(e.interactionStatus.mult_video_mic &&
                  e.videoMicLinkUsers.includes(t)) ||
                (e.baseData.commonOption.isParent &&
                  t == e.baseData.commonOption.stuId)
                  ? console.info(
                      'if(_this3.interactionStatus.mult_video_mic && _this3.videoMicLinkUsers.includes(item) || _this3.baseData.commonOption.isParent && item == _this3.baseData.commonOption.stuId)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/LiveComponents/StudentAudio/index.vue'
                    )
                  : e.thinkClass.RtcService.muteRemoteAudio(t, true)
              })
              this.$bus.$emit('resetSpeaking')
            },
            getSpeakStudentList: function () {
              console.info(
                '对象函数 getSpeakStudentList,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/StudentAudio/index.vue'
              )
              var e = []
              return (
                this.studentList.forEach(function (t) {
                  e.push(t.userId)
                }),
                e
              )
            },
          },
          beforeDestroy: function () {
            console.info(
              '对象函数 beforeDestroy,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/StudentAudio/index.vue'
            )
            this.removeListenerEvent()
            ;(this.isParent || this.isAudition) &&
              this.thinkClass.RtcService.off(
                'localJoinChannel',
                this.audioClose
              )
          },
        }),
      Ge = We,
      Fe = Object(U.a)(Ge, s, o, false, null, null, null),
      Je = Fe.exports,
      ze = {
        name: 'VideoGroup',
        components: {
          TeacherVideo: oe,
          StudentVideo: $e,
          StudentAudio: Je,
        },
        data: function () {
          return {
            baseData: this.$store.state.smallClass.baseData,
            videoGroup: null,
          }
        },
        created: function () {
          var e = this.baseData.commonOption
          this.videoGroup = new X({
            planId: e.planId,
            classId: e.classId,
          })
        },
        mounted: function () {
          this.videoGroup.sendRtcStatus()
        },
        methods: {},
      },
      Qe = ze,
      Ke = (n('8454'), Object(U.a)(Qe, G, F, false, null, '29f0507a', null)),
      qe = Ke.exports,
      Xe = function () {
        var e = this,
          t = e._self._c
        return t(
          'div',
          {
            ref: 'ppt-area',
            staticClass: 'ppt-area-container',
            attrs: { id: 'ppt-area-container' },
          },
          [
            e.showCoursewareBoard && !e.teacherJoinChannelStatus
              ? t('ClassSoon')
              : e._e(),
            t('H5Courseware', {
              ref: 'h5CoursewareMain',
              attrs: {
                ircconfig: e.baseData.configs,
                isAudition: e.isAudition,
              },
              on: {
                courseWareReady: e.courseWareReady,
                changePageId: e.changePageId,
              },
            }),
            e.showEaxmIframe
              ? t(
                  'div',
                  {
                    ref: 'exam-wrapper',
                    staticClass: 'exam-container',
                  },
                  [
                    t('iframe', {
                      attrs: {
                        id: 'class-examination',
                        src: e.examUrl,
                      },
                    }),
                  ]
                )
              : e._e(),
            t('PeiyouSdk', {
              ref: 'PeiyouSdk',
              attrs: { showCoursewareBoard: e.showCoursewareBoard },
            }),
          ],
          1
        )
      },
      Ye = [],
      Ze = n('675f'),
      et = function () {
        var e = this,
          t = e._self._c
        return t('div', { staticClass: 'wait-teacher' }, [
          t('div', { staticClass: 'wait-dialog' }, [
            t('div', { staticClass: 'notice-content' }, [
              e._v(
                ' ' +
                  e._s(
                    e.$t('classroom.smallClass.coursewareBoard.classSoonNotice')
                  ) +
                  ' '
              ),
            ]),
          ]),
        ])
      },
      tt = [],
      nt = {
        components: {},
        data: function () {
          return {}
        },
        mounted: function () {},
        methods: {},
      },
      st = nt,
      ot = (n('5f75'), Object(U.a)(st, et, tt, false, null, '0e8d4644', null)),
      at = ot.exports,
      it = n('068a'),
      rt = n('7b1b'),
      ct = function () {
        var e = this,
          t = e._self._c
        return t(
          'div',
          { attrs: { id: 'white-board-wrapper' } },
          [
            t('white-board-canvas', { ref: 'WhiteBoard' }),
            t('white-board-tools', { ref: 'WhiteBoardTools' }),
            e.isAuthorized
              ? t(
                  'div',
                  { staticClass: 'authorize-pen' },
                  e._l(e.penTools, function (n) {
                    return t('img', {
                      key: n.key,
                      staticClass: 'eraser',
                      class: ''
                        .concat(n.key, ' ')
                        .concat(e.selectedKey === n.key ? 'select-item' : ''),
                      attrs: { src: n.icon },
                      on: {
                        click: function (t) {
                          return e.selectTool(n.key)
                        },
                      },
                    })
                  }),
                  0
                )
              : e._e(),
          ],
          1
        )
      },
      lt = [],
      dt =
        (n('907a'),
        n('986a'),
        n('1d02'),
        n('3c5d'),
        n('1b3b'),
        n('3d71'),
        n('c6e3'),
        n('a15b'),
        n('a434'),
        n('0481'),
        n('4069'),
        n('4e82'),
        n('20bf'),
        n('ace4'),
        n('5cc6'),
        n('9a8c'),
        n('a975'),
        n('735e'),
        n('c1ac'),
        n('d139'),
        n('3a7b'),
        n('d5d6'),
        n('82f8'),
        n('e91f'),
        n('60bd'),
        n('5f96'),
        n('3280'),
        n('3fcc'),
        n('ca91'),
        n('25a1'),
        n('cd26'),
        n('2954'),
        n('649e'),
        n('219c'),
        n('170b'),
        n('b39a'),
        n('72f7'),
        n('f3f2')),
      ut = n.n(dt),
      mt = (n('bcac'), n('281f')),
      ht = n.n(mt),
      ft = (n('8d67'), n('97a4')),
      pt = n('c71c'),
      vt = n('c58d'),
      Ct = {
        name: 'PeiyouCoursewareBoard',
        components: {
          WhiteBoardCanvas: ut.a.WhiteBoardCanvas,
          WhiteBoardTools: ht.a,
        },
        data: function () {
          return {
            baseData: this.$store.state.smallClass.baseData,
            pageId: 0,
            useInfo: window.localStorage.getItem('userInfo'),
            isBanned: false,
            currentThickness: 4,
            currentLineDashed: false,
            eraserSize: 50,
            isAuthorized: false,
            selectedKey: 'red-pen',
            containerWidth: 0,
            containerHeight: 0,
            isInit: false,
            penTools: [
              {
                key: 'yellow-pen',
                icon: n('ba84'),
              },
              {
                key: 'red-pen',
                icon: n('645f'),
              },
              {
                key: 'eraser',
                icon: n('5f36'),
              },
            ],
            historyList: [],
            currentDbKey: [],
            canvasScale: 2,
          }
        },
        computed: {
          courseWareBounce: function () {
            return (
              console.info(
                '对象函数 courseWareBounce,filePath:renderer/components/Classroom/SmallClass/Live/CoursewareBoard/peiyouSdk.vue'
              ),
              this.$store.state.smallClass.coursesPosition
            )
          },
        },
        props: {
          showCoursewareBoard: {
            type: Boolean,
            default: false,
          },
        },
        watch: {
          isAuthorized: function (e) {
            console.info(
              '对象函数 isAuthorized(val)',
              e,
              'filePath:renderer/components/Classroom/SmallClass/Live/CoursewareBoard/peiyouSdk.vue'
            )
            this.sendLogger('授权涂鸦 '.concat(e))
            e
              ? (this.$refs.WhiteBoardTools.setWBToolsStatus(false, true),
                this.selectTool('yellow-pen'))
              : this.$refs.WhiteBoardTools.setWBToolsStatus(false)
          },
          courseWareBounce: {
            handler: function (e) {
              if (
                (console.info(
                  '对象函数 handler(val)',
                  e,
                  'filePath:renderer/components/Classroom/SmallClass/Live/CoursewareBoard/peiyouSdk.vue'
                ),
                this.isInit)
              ) {
                return (
                  console.info(
                    'if(this.isInit)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/CoursewareBoard/peiyouSdk.vue'
                  ),
                  void (
                    this.$refs.WhiteBoard &&
                    this.$refs.WhiteBoard.handleResizeCanvas(
                      e.width,
                      e.height,
                      true
                    )
                  )
                )
              }
            },
            deep: true,
          },
        },
        mounted: function () {
          var e = this
          return Object(y.a)(
            Object(x.a)().mark(function t() {
              return Object(x.a)().wrap(function (t) {
                while (1) {
                  switch ((t.prev = t.next)) {
                    case 0:
                      return (t.next = 2), Object(vt.a)()
                    case 2:
                      ;(e.canvasScale = t.sent),
                        e.initBoard(),
                        window.addEventListener('resize', e.setCanvasScale)
                    case 5:
                    case 'end':
                      return t.stop()
                  }
                }
              }, t)
            })
          )()
        },
        beforeDestroy: function () {
          console.info(
            '对象函数 beforeDestroy,filePath:renderer/components/Classroom/SmallClass/Live/CoursewareBoard/peiyouSdk.vue'
          )
          this.$refs.WhiteBoard && this.$refs.WhiteBoard.uninit()
          window.removeEventListener('resize', this.setCanvasScale)
        },
        methods: {
          initBoard: function () {
            var e = this
            console.info(
              '对象函数 initBoard,filePath:renderer/components/Classroom/SmallClass/Live/CoursewareBoard/peiyouSdk.vue'
            )
            var t = document.getElementsByClassName(
                'courseware-board-wrapper'
              )[0],
              n = t.offsetWidth,
              s = t.offsetHeight
            this.isInit = true
            var o = {
              canvas: {
                penType: 'Bspline',
                strokeType: 'none',
                scale: this.canvasScale,
                pageChangeReport: false,
                sendRoomCanvasMessage: this.sendRoomCanvasMessage.bind(this),
                getHistoryMessage: this.getHistoryMessage.bind(this),
                enableKeyboardDelete: true,
                enableFittingShape: false,
              },
              common: {
                liveId: String(this.baseData.planInfo.id),
                role: 'student',
                dataVersion: '1',
                courseId: '',
                userId: this.baseData.stuInfo.id + '',
                userName: this.baseData.stuInfo.nickName,
                screenWidth: n,
                screenHeight: s,
                roomIds: [this.baseData.commonOption.roomlist[0]],
                fastFrequency: 2000,
                slowFrequency: 3000,
                serverTimestamp:
                  +new Date() + this.baseData.commonOption.timeOffset,
              },
              accessControl: {
                showMenu: false,
                mode: 'itsAndCanvas',
                isBanned: this.isBanned,
                enableHistoryMessage: true,
                showCursor: true,
                enableRetrySend: true,
                enableLogSend: false,
                enableFittingShape: false,
              },
            }
            if (
              (this.sendLogger(
                '小班涂鸦初始化参数params: '.concat(JSON.stringify(o))
              ),
              this.$refs.WhiteBoard)
            ) {
              this.$refs.WhiteBoard.uninit()
              this.$refs.WhiteBoard.init(o)
              this.$refs.WhiteBoard.handleMouse('default')
              var a = this.$refs.WhiteBoard.getMainBoardHandWritting(),
                i = this.$refs.WhiteBoard.getPluginManager(),
                r = this.$refs.WhiteBoard
              this.$refs.WhiteBoardTools.init(r, a, i)
              var c = [11, 12, 13, 14, 15, 1000]
              c.forEach(function (t) {
                1000 === t
                  ? i.registerEvent(
                      'WhiteboardResize',
                      t,
                      e.toolsMessageHandler('WhiteboardResize', t)
                    )
                  : i.registerEvent(
                      'ReceiveBinaryData',
                      t,
                      e.toolsMessageHandler('ReceiveBinaryData', t)
                    )
              })
              this.$refs.WhiteBoardTools.setWBToolsStatus(false)
              this.$refs.WhiteBoardTools.handleMenuEnable(false)
            }
          },
          toolsMessageHandler: function (e, t) {
            var n = this
            return function (s) {
              n.$refs.WhiteBoardTools.receiveBinaryData(e, t, n.pageId, s)
            }
          },
          initCatalogueInfo: function (e) {
            var t = [
              {
                index: 0,
                isHide: 0,
                pageId: this.pageId,
                title: '标题',
                type: 'course',
              },
            ]
            try {
              var n = ''
                .concat(this.useInfo ? JSON.parse(this.useInfo).uid : '', '_')
                .concat(e)
              this.$refs.WhiteBoard.handleCatalogueChange(t)
              this.$refs.WhiteBoard.handleResetImComingDbkey(n)
              this.$refs.WhiteBoard.handlePageChange(String(this.pageId))
              this.$refs.WhiteBoardTools.handlePageChange(String(this.pageId))
            } catch (s) {
              console.error('initCatalogueInfo JSON.parse异常捕获', s)
            }
          },
          handlePointerMove: function () {
            console.info(
              '对象函数 handlePointerMove,filePath:renderer/components/Classroom/SmallClass/Live/CoursewareBoard/peiyouSdk.vue'
            )
            this.$refs.WhiteBoard &&
              this.$refs.WhiteBoard.handleShowLaserPen(
                event.clientX,
                event.clientY
              )
          },
          sendRoomCanvasMessage: function (e, t) {
            this.thinkClass.SignalService.sendRoomBinMessage(
              [this.baseData.commonOption.roomlist[0]],
              t.dbKey,
              t.keyMsgId,
              t.content
            )
            this.sendLogger(
              'sendRoomCanvasMessage: '.concat(t.keyMsgId, ' ').concat(t.dbKey)
            )
          },
          getHistoryMessage: function (e) {
            var t = this
            return Object(y.a)(
              Object(x.a)().mark(function n() {
                var s, o, a, i, r, c
                return Object(x.a)().wrap(function (n) {
                  while (1) {
                    switch ((n.prev = n.next)) {
                      case 0:
                        return (
                          console.info(
                            '对象函数 getHistoryMessage(data)',
                            e,
                            'filePath:renderer/components/Classroom/SmallClass/Live/CoursewareBoard/peiyouSdk.vue'
                          ),
                          (s = e.info[0].dbKey),
                          (o = s.split('_').splice(1).join('_')),
                          (a = []),
                          t.baseData,
                          a.push(
                            Object(ft.a)({
                              dbkey: o,
                              appId: t.baseData.configs.ircAk,
                              sk: t.baseData.configs.ircSk,
                              businessId: 3,
                              liveId: t.baseData.planInfo.id,
                              ircApiHost: t.baseData.configs.ircApiHost,
                            })
                          ),
                          (n.next = 8),
                          Object(pt.a)({
                            planId: Number(t.baseData.planInfo.id),
                          })
                        )
                      case 8:
                        ;(i = n.sent),
                          t.$store.dispatch(
                            'smallClass/updateIsAuthorizedUserList',
                            i
                          ),
                          (r = t.$store.state.smallClass.isAuthorizedUserList),
                          (c = r.find(function (e) {
                            return e.pageKey === o
                          })),
                          c &&
                            c.userIdList &&
                            c.userIdList.forEach(function (e) {
                              var n = ''.concat(e, '_').concat(o)
                              a.push(
                                Object(ft.a)({
                                  dbkey: n,
                                  appId: t.baseData.configs.ircAk,
                                  sk: t.baseData.configs.ircSk,
                                  businessId: 3,
                                  liveId: t.baseData.planInfo.id,
                                  ircApiHost: t.baseData.configs.ircApiHost,
                                })
                              )
                            }),
                          Promise.all(a)
                            .then(function (e) {
                              var n = e.flat()
                              try {
                                t.$refs.WhiteBoard &&
                                  t.$refs.WhiteBoard.handleRecoverHistoryMessage(
                                    [{ content: n }]
                                  )
                              } catch (s) {
                                console.error('handleRecoverHistoryMessage', s)
                              }
                            })
                            .catch(function (e) {
                              console.info(
                                '箭头函数 catch(err)',
                                e,
                                'filePath:renderer/components/Classroom/SmallClass/Live/CoursewareBoard/peiyouSdk.vue'
                              )
                              console.error('获取历史涂鸦失败', e)
                            })
                      case 16:
                      case 'end':
                        return n.stop()
                    }
                  }
                }, n)
              })
            )()
          },
          handleRoomCanvasMessage: function (e) {
            this.$refs.WhiteBoard &&
              this.$refs.WhiteBoard.handleRoomCanvasMessage(e)
          },
          onSendRoomBinMessageResp: function (e) {
            0 === e.code
              ? this.$refs.WhiteBoard &&
                this.$refs.WhiteBoard.handleSendMessageSuccess(
                  e.dbKey,
                  e.keyMsgId
                )
              : (this.sendLogger('发送涂鸦消息回调: '.concat(e)),
                this.$refs.WhiteBoard &&
                  this.$refs.WhiteBoard.handleSendMessageError(
                    e.code,
                    e.msg,
                    e.dbKey,
                    e.keyMsgId
                  ))
          },
          onGetRoomHistoryBinMessageNotice: function (e) {
            var t = this
            console.info(
              '对象函数 onGetRoomHistoryBinMessageNotice(res)',
              e,
              'filePath:renderer/components/Classroom/SmallClass/Live/CoursewareBoard/peiyouSdk.vue'
            )
            this.sendLogger('处理拉取到的涂鸦历史消息')
            var n = this.$store.state.smallClass.isAuthorizedUserList,
              s = n.find(function (e) {
                return e.pageKey === t.currentDbKey
              })
            if (s && s.userIdList) {
              if (
                (this.historyList.push(e),
                this.historyList.length === s.userIdList.length + 1)
              ) {
                var o = this.historyList.flat()
                o.sort(function (e, t) {
                  return e.msgId - t.msgId
                })
                o.forEach(function (e, t) {
                  o[t].content = Uint8Array.from(e.content)
                })
                try {
                  this.$refs.WhiteBoard &&
                    this.$refs.WhiteBoard.handleRecoverHistoryMessage([
                      { content: o },
                    ])
                } catch (i) {
                  this.sendLogger('涂鸦sdk报错 '.concat(i), 'error')
                }
                this.historyList = []
              }
            } else {
              var a = e
              if (Array.isArray(a)) {
                a.forEach(function (e, t) {
                  a[t].content = Uint8Array.from(e.content)
                })
                try {
                  this.$refs.WhiteBoard &&
                    this.$refs.WhiteBoard.handleRecoverHistoryMessage([
                      { content: a },
                    ])
                } catch (i) {
                  console.error('涂鸦sdk报错', i)
                }
              } else {
                console.error('涂鸦历史消息格式错误')
              }
            }
          },
          setIsAuthorizedStatus: function (e) {
            console.info(
              '对象函数 setIsAuthorizedStatus(noticeContent)',
              e,
              'filePath:renderer/components/Classroom/SmallClass/Live/CoursewareBoard/peiyouSdk.vue'
            )
            try {
              var t = this.useInfo ? JSON.parse(this.useInfo).uid : '',
                n = e.data.find(function (e) {
                  return e.userId === t
                })
              n && 1 === n.isAuthorize
                ? (this.isAuthorized = true)
                : ((this.isAuthorized = false),
                  this.$refs.WhiteBoard.handleMouse('default'))
            } catch (s) {
              this.sendLogger('JSON.parse异常捕获: '.concat(s), 'error')
            }
          },
          changePageId: function (e, t) {
            this.pageId = e
            var n = t.specificLiveKey,
              s = t.courseWareId,
              o = t.pageId
            if (!n || !s || !o) {
              return (
                console.info(
                  'if(!specificLiveKey || !courseWareId || !pageId)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/CoursewareBoard/peiyouSdk.vue'
                ),
                void console.error('课件信息错误', t)
              )
            }
            var a = ''.concat(n, '_').concat(s, '_').concat(o)
            this.initCatalogueInfo(a)
          },
          selectTool: function (e) {
            console.info(
              '对象函数 selectTool(type)',
              e,
              'filePath:renderer/components/Classroom/SmallClass/Live/CoursewareBoard/peiyouSdk.vue'
            )
            this.selectedKey = e
            'yellow-pen' === e || 'red-pen' === e
              ? (this.$refs.WhiteBoard &&
                  (this.$refs.WhiteBoard.setPenStyle({
                    color: 'yellow-pen' === e ? '#FFD82D' : '#FF503F',
                    thickness: this.currentThickness,
                    lineDashed: this.currentLineDashed,
                  }),
                  this.$refs.WhiteBoard.handlePen(),
                  this.sendLogger('授权涂鸦选择画笔 '.concat(e))),
                this.sendLogger(
                  '授权涂鸦选择画笔失败\uFF0C未获得涂鸦元素WhiteBoard'
                ))
              : (this.$refs.WhiteBoard &&
                  (this.$refs.WhiteBoard.setEraserStyle(this.eraserSize),
                  this.$refs.WhiteBoard.handleEraser(),
                  this.sendLogger(
                    '授权涂鸦选择橡皮\uFF0C大小'.concat(this.eraserSize)
                  )),
                this.sendLogger(
                  '授权涂鸦选择橡皮失败\uFF0C未获得涂鸦元素WhiteBoard'
                ))
          },
          sendLogger: function (e) {
            var t =
              arguments.length > 1 && void 0 !== arguments[1]
                ? arguments[1]
                : 'info'
            q.a.send({
              tag: 'smallClass-griffiti',
              content: { msg: e },
              level: t,
            })
          },
        },
      },
      St = Ct,
      gt = (n('0be0'), Object(U.a)(St, ct, lt, false, null, '451bfc46', null)),
      bt = gt.exports,
      wt = {},
      kt = {
        name: 'CoursewareBoard',
        components: {
          ClassSoon: at,
          H5Courseware: Ze.a,
          PeiyouSdk: bt,
        },
        props: {
          isAudition: {
            default: false,
            type: Boolean,
          },
        },
        data: function () {
          return {
            baseData: this.$store.state.smallClass.baseData,
            pageId: 0,
            showCoursewareBoard: false,
            examUrl: '',
            showEaxmIframe: false,
            useInfo: window.localStorage.getItem('userInfo'),
          }
        },
        mixins: [rt.a],
        computed: Object(V.a)(
          {
            teacherJoinChannelStatus: function () {
              return (
                console.info(
                  '对象函数 teacherJoinChannelStatus,filePath:renderer/components/Classroom/SmallClass/Live/CoursewareBoard/index.vue'
                ),
                true === this.$store.state.smallClass.teacherJoinChannelStatus
              )
            },
          },
          Object(Se.mapGetters)({ blackBoardData: 'smallClass/blackBoardData' })
        ),
        mounted: function () {
          var e = this
          return Object(y.a)(
            Object(x.a)().mark(function t() {
              return Object(x.a)().wrap(function (t) {
                while (1) {
                  switch ((t.prev = t.next)) {
                    case 0:
                      e.listenerSignalService(), e.bindEvent()
                    case 2:
                    case 'end':
                      return t.stop()
                  }
                }
              }, t)
            })
          )()
        },
        beforeDestroy: function () {
          console.info(
            '对象函数 beforeDestroy,filePath:renderer/components/Classroom/SmallClass/Live/CoursewareBoard/index.vue'
          )
          this.removeListenerSignalService()
          this.$refs.WhiteBoard && this.$refs.WhiteBoard.uninit()
        },
        methods: {
          listenerSignalService: function () {
            console.info(
              '对象函数 listenerSignalService,filePath:renderer/components/Classroom/SmallClass/Live/CoursewareBoard/index.vue'
            )
            this.thinkClass.SignalService.on(
              'onRecvRoomBinMessageNotice',
              this.handleOnRecvRoomBinMessageNotice
            )
            this.thinkClass.SignalService.on(
              'onSendRoomBinMessageResp',
              this.handleOnSendRoomBinMessageResp
            )
            this.thinkClass.SignalService.on(
              'onGetRoomHistoryBinMessageNotice',
              this.handleOnGetRoomHistoryBinMessageNotice
            )
            this.thinkClass.SignalService.on(
              'onRecvRoomDataUpdateNotice',
              this.handleOnRecvRoomDataUpdateNotice
            )
          },
          handleOnRecvRoomBinMessageNotice: function (e) {
            var t = this,
              n = Object(it.b)(Object(it.a)(e.content)),
              s = ''
                .concat(n.pageId, '_')
                .concat(n.msgId, '_')
                .concat(n.dataCreateTimestamp)
            this.sendLogger('监听irc涂鸦实时信令消息: '.concat(s))
            wt[s]
              ? console.info(
                  'if(BINARY_DATA_CACHE[key])为true触发return,path: /renderer/components/Classroom/SmallClass/Live/CoursewareBoard/index.vue'
                )
              : ((wt[s] = 1),
                this.$nextTick(function () {
                  var n
                  null === (n = t.$refs.PeiyouSdk) ||
                    void 0 === n ||
                    n.handleRoomCanvasMessage(e)
                }))
          },
          handleOnSendRoomBinMessageResp: function (e) {
            var t = this
            this.sendLogger(
              '监听irc涂鸦消息发送回调: '.concat(JSON.stringify(e))
            )
            this.$nextTick(function () {
              var n
              null === (n = t.$refs.PeiyouSdk) ||
                void 0 === n ||
                n.onSendRoomBinMessageResp(e)
            })
          },
          handleOnGetRoomHistoryBinMessageNotice: function (e) {
            var t = this
            console.info(
              '对象函数 handleOnGetRoomHistoryBinMessageNotice(res)',
              e,
              'filePath:renderer/components/Classroom/SmallClass/Live/CoursewareBoard/index.vue'
            )
            this.sendLogger('监听irc历史数据拉取: '.concat(JSON.stringify(e)))
            this.$nextTick(function () {
              var n
              null === (n = t.$refs.PeiyouSdk) ||
                void 0 === n ||
                n.onGetRoomHistoryBinMessageNotice(e)
            })
          },
          handleOnRecvRoomDataUpdateNotice: function (e) {
            var t = this,
              n = e.key,
              s = e.noticeContent
            if ('class_examination' === n) {
              if (s.pub) {
                this.showEaxmIframe = true
                this.$bus.$emit('setExaminationStatus', true)
                var o = this.baseData.commonOption.timeOffset,
                  a = +new Date(),
                  i = parseInt((a + o) / 1000),
                  r = i - s.beginTime - 60,
                  c = s.beginTime + s.totaltime - i,
                  l = this.useInfo
                    ? JSON.parse(this.useInfo).unifiedAccessToken
                    : ''
                if (
                  (1 === s.status && r <= 0 && (c = s.totaltime), !this.examUrl)
                ) {
                  var d = 'from=live&classId='
                      .concat(this.baseData.commonOption.classId, '&studentId=')
                      .concat(this.baseData.commonOption.stuId, '&token=')
                      .concat(l),
                    u = 'duration='
                      .concat(s.totaltime, '&completed=')
                      .concat(3 === s.status ? 1 : 0, '&isLate=')
                      .concat(r > 0 ? 1 : 0, '&remainSeconds=')
                      .concat(c)
                  this.examUrl = ''
                    .concat(s.examUrl, '&platform=3&')
                    .concat(d, '&')
                    .concat(u)
                }
                2 === s.status
                  ? this.$nextTick(function () {
                      document
                        .getElementById('class-examination')
                        .contentWindow.postMessage(
                          {
                            type: 'updateRemainSecondsTo',
                            data: { remainSeconds: c },
                          },
                          '*'
                        )
                    })
                  : 3 === s.status &&
                    this.$nextTick(function () {
                      document
                        .getElementById('class-examination')
                        .contentWindow.postMessage(
                          { type: 'completeExam' },
                          '*'
                        )
                    })
              } else {
                this.showEaxmIframe = false
                this.examUrl = ''
                this.$bus.$emit('setExaminationStatus', false)
              }
            }
            'mult_video_mic' === n &&
              this.$nextTick(function () {
                var e
                null === (e = t.$refs.PeiyouSdk) ||
                  void 0 === e ||
                  e.setIsAuthorizedStatus(s)
              })
            'canvas_switch_courseware' === n &&
              this.$refs.h5CoursewareMain &&
              this.$refs.h5CoursewareMain.handleSwitchCourseware(s)
          },
          sendSubmitEaxmToTeacher: function () {
            console.info(
              '对象函数 sendSubmitEaxmToTeacher,filePath:renderer/components/Classroom/SmallClass/Live/CoursewareBoard/index.vue'
            )
            var e = {
              nickname: this.baseData.configs.teacherIrcId,
              content: {
                type: 128,
                submit: true,
              },
              chatMsgPriority: 99,
            }
            this.thinkClass.SignalService.sendPeerMessage(e)
          },
          courseWareReady: function (e) {
            console.info(
              '对象函数 courseWareReady(flag)',
              e,
              'filePath:renderer/components/Classroom/SmallClass/Live/CoursewareBoard/index.vue'
            )
            this.showCoursewareBoard = e
          },
          changePageId: function (e, t) {
            var n = this
            this.pageId = e
            this.$nextTick(function () {
              var s
              null === (s = n.$refs.PeiyouSdk) ||
                void 0 === s ||
                s.changePageId(e, t)
            })
          },
          sendLogger: function (e) {
            q.a.send({
              tag: 'smallClass-griffiti',
              content: { msg: e },
            })
          },
          removeListenerSignalService: function () {
            console.info(
              '对象函数 removeListenerSignalService,filePath:renderer/components/Classroom/SmallClass/Live/CoursewareBoard/index.vue'
            )
            this.thinkClass.SignalService.off(
              'onRecvRoomBinMessageNotice',
              this.handleOnRecvRoomBinMessageNotice
            )
            this.thinkClass.SignalService.off(
              'onSendRoomBinMessageResp',
              this.handleOnSendRoomBinMessageResp
            )
            this.thinkClass.SignalService.off(
              'onGetRoomHistoryBinMessageNotice',
              this.handleOnGetRoomHistoryBinMessageNotice
            )
            this.thinkClass.SignalService.off(
              'onRecvRoomDataUpdateNotice',
              this.handleOnRecvRoomDataUpdateNotice
            )
          },
        },
      },
      Lt = kt,
      xt = (n('4ac5'), Object(U.a)(Lt, Xe, Ye, false, null, 'ca02097e', null)),
      yt = xt.exports,
      It = function () {
        var e = this,
          t = e._self._c
        return t('div', { staticClass: 'sidebar' }, [
          t(
            'div',
            { staticClass: 'sidebar-inner-module' },
            [
              t('Coins'),
              t(
                'section',
                { staticClass: 'bottom-operate' },
                [
                  t('Settings', { staticClass: 'settings' }),
                  t('Microphone', { staticClass: 'microphone' }),
                  t('ChatBoxIcon', { staticClass: 'chat-box-icon' }),
                  t('SendEmoji', { staticClass: 'send-emoji' }),
                  t('RaiseHand'),
                ],
                1
              ),
            ],
            1
          ),
          t(
            'div',
            { staticClass: 'sidebar-outter-module' },
            [t('SiderbarModule', { staticClass: 'module' })],
            1
          ),
        ])
      },
      Pt = [],
      Ot = function () {
        var e = this,
          t = e._self._c
        return t(
          'div',
          {
            staticClass: 'coins-container',
            on: { click: e.openBadgePane },
          },
          [
            t('div', { staticClass: 'title-bg' }, [
              t('span', {
                staticClass: 'medal',
                class: 'level-'.concat(e.level),
              }),
              t('span', { staticClass: 'tips' }),
            ]),
            t('div', { staticClass: 'coins' }, [
              t(
                'section',
                [
                  t('span', {
                    class: ['icon-coins', { 'add-coin': e.addCoin }],
                  }),
                  e.addCoin
                    ? t('CountTo', {
                        staticClass: 'count',
                        attrs: {
                          startVal: e.startCoin,
                          endVal: e.endCoin,
                          duration: 400,
                          separator: '',
                        },
                        on: {
                          end: function (t) {
                            e.addCoin = false
                          },
                        },
                      })
                    : t('span', { staticClass: 'count' }, [
                        e._v(e._s(e.planIdCoin)),
                      ]),
                ],
                1
              ),
            ]),
            t('div', { staticClass: 'detail-entry' }, [
              t('span', { staticClass: 'title' }, [
                e._v(e._s(e.$t('classroom.smallClass.coins.buttonName'))),
              ]),
              t('span', { staticClass: 'icon' }),
            ]),
          ]
        )
      },
      At = [],
      jt = n('306f'),
      Mt = n('9c59'),
      Tt = n.n(Mt),
      Rt = {
        components: { CountTo: jt.a },
        data: function () {
          return {
            coinDatas: null,
            planIdCoin: 0,
            level: 0,
            addCoin: false,
            startCoin: 0,
            endCoin: 0,
          }
        },
        computed: {
          goldCoins: function () {
            return (
              console.info(
                '对象函数 goldCoins,filePath:renderer/components/Classroom/SmallClass/Live/Sidebar/Coins/index.vue'
              ),
              this.$store.state.smallClass.goldCoins
            )
          },
          options: function () {
            return (
              console.info(
                '对象函数 options,filePath:renderer/components/Classroom/SmallClass/Live/Sidebar/Coins/index.vue'
              ),
              this.$store.state.smallClass.baseData.commonOption
            )
          },
          ircStatus: function () {
            return (
              console.info(
                '对象函数 ircStatus,filePath:renderer/components/Classroom/SmallClass/Live/Sidebar/Coins/index.vue'
              ),
              this.$store.state.smallClass.ircStatus
            )
          },
        },
        mounted: function () {
          var e = this
          this.initMedalCoins()
          this.$bus.$on('updateAchievement', function (t, n) {
            console.info(
              '箭头函数 监听 updateAchievement(type, num)',
              t,
              n,
              'filePath:renderer/components/Classroom/SmallClass/Live/Sidebar/Coins/index.vue'
            )
            e.initMedalCoins()
          })
          this.$bus.$on('addCoin', function (t, n) {
            console.info(
              '箭头函数 监听 addCoin(isStart, coin)',
              t,
              n,
              'filePath:renderer/components/Classroom/SmallClass/Live/Sidebar/Coins/index.vue'
            )
            t &&
              ((e.addCoin = true),
              (e.startCoin = +e.planIdCoin),
              (e.endCoin = e.startCoin + n),
              (e.planIdCoin = e.endCoin))
            e.initMedalCoins()
          })
        },
        methods: {
          openBadgePane: function () {
            var e = this
            console.info(
              '对象函数 openBadgePane,filePath:renderer/components/Classroom/SmallClass/Live/Sidebar/Coins/index.vue'
            )
            this.ircStatus
            this.ircStatus
              ? setTimeout(function () {
                  e.$bus.$emit('openBadgePane', e.coinDatas)
                }, 100)
              : console.info(
                  'if(!this.ircStatus)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/Sidebar/Coins/index.vue'
                )
          },
          initMedalCoins: function () {
            var e = this
            return Object(y.a)(
              Object(x.a)().mark(function t() {
                var n, s
                return Object(x.a)().wrap(function (t) {
                  while (1) {
                    switch ((t.prev = t.next)) {
                      case 0:
                        return (
                          console.info(
                            '对象函数 initMedalCoins,filePath:renderer/components/Classroom/SmallClass/Live/Sidebar/Coins/index.vue'
                          ),
                          (n = Tt.a.parse(window.location.search)),
                          (t.next = 4),
                          Object(K.w)({ planId: n.planId })
                        )
                      case 4:
                        ;(s = t.sent),
                          s &&
                            0 == s.code &&
                            ((e.coinDatas = s.data),
                            (e.planIdCoin = e.coinDatas.planIdCoin || ''),
                            (e.level = e.coinDatas.medalNum))
                      case 6:
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
      Bt = Rt,
      Dt = (n('f5ef'), Object(U.a)(Bt, Ot, At, false, null, '30640505', null)),
      Vt = Dt.exports,
      Nt = function () {
        var e = this,
          t = e._self._c
        return t(
          'div',
          {
            class: e.allOnStage
              ? 'allOnStage-microphone'
              : 'siderbar-microphone',
            on: { click: e.handleMicrophoneStatusClick },
          },
          [
            t('div', { staticClass: 'microphone-inner' }, [
              t(
                'div',
                { staticClass: 'icon' },
                [
                  t('AudioWaves', {
                    attrs: {
                      microphoneStyle: e.allOnStage
                        ? 'allOnStage'
                        : 'laurelGreen',
                      volumeValue: e.localVolumeValue,
                      microphoneHeight: e.allOnStage ? 26 : 20,
                      microphoneStatus: e.microphoneStatus,
                      offMicrophoneStyle: e.allOnStage ? 'allOnStage' : 'icon',
                    },
                  }),
                ],
                1
              ),
            ]),
            t(
              'span',
              {
                staticClass: 'text',
                class: [
                  e.microphoneStatus ? 'textUnmute' : 'textMute',
                  e.forbidClickMute ? 'disabled' : '',
                ],
              },
              [
                e._v(
                  e._s(
                    e.microphoneStatus
                      ? e.$t('classroom.smallClass.microphone.buttonName')[0]
                      : e.$t('classroom.smallClass.microphone.buttonName')[1]
                  )
                ),
              ]
            ),
            t('MediaSecurityAccess', {
              ref: 'MediaSecurityAccessMicrophone',
              attrs: {
                visible: false,
                type: 'microphone',
              },
            }),
          ],
          1
        )
      },
      Et = [],
      _t = n('3b29'),
      Ht = n('c02a'),
      Ut = n('b047'),
      $t = n.n(Ut),
      Wt = {
        name: 'Microphone',
        components: {
          AudioWaves: ee.a,
          MediaSecurityAccess: _t.a,
        },
        data: function () {
          return {
            baseData: this.$store.state.smallClass.baseData,
            localVolumeValue: 0,
            allowOpenMicrophone: null,
            teacherAllowConfirmStatus: false,
            forbidMuteAudio: false,
            initFirstOnStage: false,
          }
        },
        props: {
          allOnStage: {
            type: Boolean,
            default: false,
          },
        },
        computed: {
          microphoneStatus: function () {
            return (
              console.info(
                '对象函数 microphoneStatus,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/Microphone/index.vue'
              ),
              this.$store.state.smallClass.microphoneStatus
            )
          },
          selfVideoMicLink: function () {
            return (
              console.info(
                '对象函数 selfVideoMicLink,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/Microphone/index.vue'
              ),
              this.$store.state.smallClass.selfVideoMicLink
            )
          },
          forbidClickMute: function () {
            return (
              console.info(
                '对象函数 forbidClickMute,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/Microphone/index.vue'
              ),
              this.forbidMuteAudio && this.microphoneStatus
            )
          },
        },
        mounted: function () {
          this.queryMuteStatus()
          this.listenerEvent()
          this.listenerRtcService()
          this.listenerSignalService()
        },
        methods: {
          teacherAllowMicrophone: function () {
            console.info(
              '对象函数 teacherAllowMicrophone,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/Microphone/index.vue'
            )
            this.teacherAllowConfirmStatus = false
          },
          localVolume: function (e) {
            this.localVolumeValue = e
          },
          kvHandle: function (e) {
            var t = this
            return Object(y.a)(
              Object(x.a)().mark(function n() {
                var s, o, a, i
                return Object(x.a)().wrap(function (n) {
                  while (1) {
                    switch ((n.prev = n.next)) {
                      case 0:
                        if (
                          ((s = e.key),
                          (o = e.noticeContent),
                          'mult_video_mic' !== s)
                        ) {
                          n.next = 5
                          break
                        }
                        2 === o.status && (t.initFirstOnStage = true),
                          (n.next = 22)
                        break
                      case 5:
                        if ('allow_open_microphone' !== s) {
                          n.next = 11
                          break
                        }
                        ;(a = o.pub),
                          (t.allowOpenMicrophone = a),
                          t.sendLogger(
                            '静音时是否允许学生开启麦克风\uFF0Cres: '.concat(
                              JSON.stringify(o)
                            )
                          ),
                          (n.next = 22)
                        break
                      case 11:
                        if ('forbid_mute_audio' !== s) {
                          n.next = 22
                          break
                        }
                        if (
                          ((t.forbidMuteAudio = 1 == o.pub), !t.forbidMuteAudio)
                        ) {
                          n.next = 21
                          break
                        }
                        return (n.next = 16), Object(Q.f)()
                      case 16:
                        if (((i = n.sent), i)) {
                          n.next = 20
                          break
                        }
                        return (
                          console.info(
                            'if(!microphoneAccessStatus)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/LiveComponents/Microphone/index.vue'
                          ),
                          n.abrupt('return')
                        )
                      case 20:
                        t.updateMicrophoneStatus(true)
                      case 21:
                        t.sendLogger(
                          '是否禁止学生关闭麦克风\uFF0Cres: '.concat(
                            JSON.stringify(o)
                          )
                        )
                      case 22:
                      case 'end':
                        return n.stop()
                    }
                  }
                }, n)
              })
            )()
          },
          recvRoomMessage: function (e) {
            console.info(
              '对象函数 recvRoomMessage(res)',
              e,
              'filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/Microphone/index.vue'
            )
            var t = e.content,
              n = t.ircType,
              s = t.data
            if ('all_audio_mute' === n) {
              var o = !s.pub
              if (o) {
                if (this.microphoneStatus) {
                  return void console.info(
                    'if(this.microphoneStatus)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/LiveComponents/Microphone/index.vue'
                  )
                }
                this.teacherAllowConfirmStatus = true
                this.$bus.$emit('showMicrophoneAllowConfirm')
              } else {
                if (!this.microphoneStatus || this.selfVideoMicLink) {
                  return void console.info(
                    'if(!this.microphoneStatus || this.selfVideoMicLink)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/LiveComponents/Microphone/index.vue'
                  )
                }
                this.handleMicrophoneStatus(o)
              }
              this.sendLogger(
                '老师控制全员麦克风'
                  .concat(o ? '打开' : '关闭', '\uFF0Cres: ')
                  .concat(JSON.stringify(e))
              )
            }
          },
          recvPeerMessage: function (e) {
            console.info(
              '对象函数 recvPeerMessage(res)',
              e,
              'filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/Microphone/index.vue'
            )
            var t = e.content,
              n = t.ircType,
              s = t.data
            if ('user_audio_mute' === n) {
              var o = !s.pub
              if (
                (this.sendLogger(
                  '老师控制单独学生麦克风'
                    .concat(o ? '打开' : '关闭', '\uFF0Cres: ')
                    .concat(JSON.stringify(e), ',microphoneStatus: ')
                    .concat(this.microphoneStatus)
                ),
                o)
              ) {
                if (this.microphoneStatus) {
                  return void console.info(
                    'if(this.microphoneStatus)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/LiveComponents/Microphone/index.vue'
                  )
                }
                this.teacherAllowConfirmStatus = true
                this.$bus.$emit('showMicrophoneAllowConfirm')
              } else {
                if (!this.microphoneStatus) {
                  return void console.info(
                    'if(!this.microphoneStatus)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/LiveComponents/Microphone/index.vue'
                  )
                }
                this.handleMicrophoneStatus(o)
              }
            }
          },
          listenerEvent: function () {
            console.info(
              '对象函数 listenerEvent,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/Microphone/index.vue'
            )
            this.$bus.$on('openMicrophone', this.handleMicrophoneStatus)
            this.$bus.$on(
              'closeMicrophoneAllowConfirm',
              this.teacherAllowMicrophone
            )
          },
          listenerRtcService: function () {
            console.info(
              '对象函数 listenerRtcService,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/Microphone/index.vue'
            )
            var e = this.thinkClass.RtcService
            e.on('localAudioVolume', this.localVolume)
          },
          listenerSignalService: function () {
            console.info(
              '对象函数 listenerSignalService,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/Microphone/index.vue'
            )
            var e = this.thinkClass.SignalService
            e.on('onRecvRoomDataUpdateNotice', this.kvHandle)
            e.on('onRecvRoomMessage', this.recvRoomMessage)
            e.on('onRecvPeerMessage', this.recvPeerMessage)
          },
          removeAllListener: function () {
            console.info(
              '对象函数 removeAllListener,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/Microphone/index.vue'
            )
            this.$bus.$off('openMicrophone', this.handleMicrophoneStatus)
            this.$bus.$off(
              'closeMicrophoneAllowConfirm',
              this.teacherAllowMicrophone
            )
            var e = this.thinkClass.RtcService
            e.off('localAudioVolume', this.localVolume)
            var t = this.thinkClass.SignalService
            t.off('onRecvRoomDataUpdateNotice', this.kvHandle)
            t.off('onRecvRoomMessage', this.recvRoomMessage)
            t.off('onRecvPeerMessage', this.recvPeerMessage)
          },
          handleMicrophoneStatusClick: $t()(function (e) {
            this.handleMicrophoneStatus(e)
          }, 300),
          handleMicrophoneStatus: function (e) {
            var t = this
            return Object(y.a)(
              Object(x.a)().mark(function n() {
                var s, o, a
                return Object(x.a)().wrap(function (n) {
                  while (1) {
                    switch ((n.prev = n.next)) {
                      case 0:
                        return (
                          console.info(
                            '对象函数 handleMicrophoneStatus(status)',
                            e,
                            'filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/Microphone/index.vue'
                          ),
                          (s = 'boolean' !== typeof e),
                          (n.next = 4),
                          Object(Q.f)()
                        )
                      case 4:
                        if (((o = n.sent), o)) {
                          n.next = 9
                          break
                        }
                        return (
                          console.info(
                            'if(!microphoneAccessStatus)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/LiveComponents/Microphone/index.vue'
                          ),
                          t.$refs.MediaSecurityAccessMicrophone.checkAccess(),
                          n.abrupt('return')
                        )
                      case 9:
                        if (!t.forbidClickMute || !s) {
                          n.next = 13
                          break
                        }
                        return (
                          console.info(
                            'if(_this2.forbidClickMute && isClick)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/LiveComponents/Microphone/index.vue'
                          ),
                          t.$bus.$emit(
                            'showTeacherDisabledMicrophoneNotice',
                            'off'
                          ),
                          n.abrupt('return')
                        )
                      case 13:
                        if (
                          ((a = s ? !t.microphoneStatus : e),
                          !t.selfVideoMicLink ||
                            !a ||
                            (!t.initFirstOnStage &&
                              !t.teacherAllowConfirmStatus))
                        ) {
                          n.next = 19
                          break
                        }
                        return (
                          console.info(
                            'if(_this2.selfVideoMicLink && microphoneStatus && (_this2.initFirstOnStage || _this2.teacherAllowConfirmStatus))为true触发return,path: /renderer/components/Classroom/SmallClass/Live/LiveComponents/Microphone/index.vue'
                          ),
                          t.updateMicrophoneStatus(a),
                          t.initFirstOnStage && (t.initFirstOnStage = false),
                          n.abrupt('return')
                        )
                      case 19:
                        if (
                          t.teacherAllowConfirmStatus ||
                          !a ||
                          false !== t.allowOpenMicrophone
                        ) {
                          n.next = 23
                          break
                        }
                        return (
                          console.info(
                            'if(!_this2.teacherAllowConfirmStatus && microphoneStatus && _this2.allowOpenMicrophone === false)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/LiveComponents/Microphone/index.vue'
                          ),
                          t.$bus.$emit(
                            'showTeacherDisabledMicrophoneNotice',
                            'on'
                          ),
                          n.abrupt('return')
                        )
                      case 23:
                        t.updateMicrophoneStatus(a),
                          Ht.r({ microphoneStatus: a })
                      case 25:
                      case 'end':
                        return n.stop()
                    }
                  }
                }, n)
              })
            )()
          },
          updateMicrophoneStatus: function (e) {
            console.info(
              '对象函数 updateMicrophoneStatus(microphoneStatus)',
              e,
              'filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/Microphone/index.vue'
            )
            this.$store.dispatch('smallClass/updateMicrophoneStatus', e)
            this.$bus.$emit('updateMicrophoneStatus', e)
          },
          queryMuteStatus: function () {
            var e = this
            return Object(y.a)(
              Object(x.a)().mark(function t() {
                var n, s, o
                return Object(x.a)().wrap(function (t) {
                  while (1) {
                    switch ((t.prev = t.next)) {
                      case 0:
                        return (
                          console.info(
                            '对象函数 queryMuteStatus,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/Microphone/index.vue'
                          ),
                          (t.next = 3),
                          Object(K.i)({ planId: e.baseData.planInfo.id })
                        )
                      case 3:
                        if (((n = t.sent), n && 0 == n.code)) {
                          t.next = 7
                          break
                        }
                        return (
                          console.info(
                            'if(!res || res.code != 0)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/LiveComponents/Microphone/index.vue'
                          ),
                          t.abrupt('return')
                        )
                      case 7:
                        ;(s = n.data),
                          (o = s.enterRoomMute),
                          1 == o && e.handleMicrophoneStatus(false),
                          e.sendLogger(
                            '学生进入课堂静音开关\uFF0C状态: '
                              .concat(
                                1 == o ? '静音' : '不静音',
                                ',\n        res: '
                              )
                              .concat(JSON.stringify(n))
                          )
                      case 11:
                      case 'end':
                        return t.stop()
                    }
                  }
                }, t)
              })
            )()
          },
          sendLogger: function (e) {
            q.a.send({
              tag: 'audioMute',
              content: { msg: e },
            })
          },
        },
        beforeDestroy: function () {
          console.info(
            '对象函数 beforeDestroy,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/Microphone/index.vue'
          )
          this.removeAllListener()
        },
      },
      Gt = Wt,
      Ft = (n('526d'), Object(U.a)(Gt, Nt, Et, false, null, '310854d3', null)),
      Jt = Ft.exports,
      zt = function () {
        var e = this,
          t = e._self._c
        return t(
          'div',
          { staticClass: 'setting-container' },
          [
            t(
              'div',
              {
                staticClass: 'setting',
                attrs: { id: 'setting' },
                on: { click: e.handleSettingOpen },
              },
              [
                t('div', { staticClass: 'icon' }, [
                  t('span', { class: e.isSelected ? 'selected' : 'normal' }),
                ]),
                t(
                  'span',
                  {
                    staticClass: 'text',
                    class: e.isSelected ? 'selected' : 'normal',
                  },
                  [
                    e._v(
                      ' ' +
                        e._s(
                          e.$t('classroom.smallClass.moreSettings.buttonName')
                        ) +
                        ' '
                    ),
                  ]
                ),
              ]
            ),
            t('SettingTools', {
              directives: [
                {
                  name: 'clickoutside',
                  rawName: 'v-clickoutside',
                  value: e.handleSettingHide,
                  expression: 'handleSettingHide',
                },
              ],
              ref: 'SettingToolRef',
              class: [
                'uk' == e.local
                  ? 'setting-tools-no-assignment'
                  : 'setting-tools',
                e.reportBtnVisible ? 'setting-tools-top' : '',
              ],
              attrs: {
                showNewMessageTip: e.showNewMessageTip,
                reportBtnVisible: e.reportBtnVisible,
              },
              on: { handleUnselect: e.handleUnselect },
            }),
          ],
          1
        )
      },
      Qt = [],
      Kt = function () {
        var e = this,
          t = e._self._c
        return t(
          'div',
          {
            directives: [
              {
                name: 'show',
                rawName: 'v-show',
                value: e.showSettingTools,
                expression: 'showSettingTools',
              },
            ],
            staticClass: 'setting-tools-container',
            class: [
              { 'no-assignmentBox': 'uk' == e.local },
              { 'rechang-height': e.reportBtnVisible },
            ],
          },
          [
            t(
              'div',
              { staticClass: 'setting-tools-content' },
              [
                t('SwitchCamera', { staticClass: 'setting-video' }),
                t('FeedbackEntry', {
                  staticClass: 'setting-feedback',
                  on: { closeSettingPane: e.closeSettingPane },
                }),
                'uk' != e.local
                  ? t('HomeworkBoxEntry', {
                      attrs: { showNewMessageTip: e.showNewMessageTip },
                      on: { closeSettingPane: e.closeSettingPane },
                    })
                  : e._e(),
                e.reportBtnVisible
                  ? t('ExamReportEntry', {
                      on: { closeSettingPane: e.closeSettingPane },
                    })
                  : e._e(),
              ],
              1
            ),
            t('span', { staticClass: 'arrow' }),
          ]
        )
      },
      qt = [],
      Xt = function () {
        var e = this,
          t = e._self._c
        return t(
          'div',
          {
            class: e.allOnStage ? 'allOnStage-camera' : 'setting-tools-camera',
            on: { click: e.onStageHandleStatus },
          },
          [
            t('span', { staticClass: 'setting-icon' }, [
              t('span', { staticClass: 'icon' }, [
                t('span', { class: e.cameraStatus ? 'on' : 'off' }),
              ]),
              t(
                'span',
                {
                  staticClass: 'text',
                  class: e.cameraStatus ? 'text-active' : '',
                },
                [
                  e._v(
                    ' ' +
                      e._s(e.$t('classroom.smallClass.camera.buttonName')) +
                      ' '
                  ),
                ]
              ),
            ]),
            e.allOnStage
              ? e._e()
              : t('a-switch', {
                  attrs: {
                    size: 'small',
                    disabled: e.disabledStatus,
                  },
                  on: { change: e.handleCameraStatus },
                  model: {
                    value: e.cameraStatus,
                    callback: function (t) {
                      e.cameraStatus = t
                    },
                    expression: 'cameraStatus',
                  },
                }),
            t('MediaSecurityAccess', {
              ref: 'MediaSecurityAccessCamera',
              attrs: {
                visible: false,
                type: 'camera',
              },
            }),
          ],
          1
        )
      },
      Yt = [],
      Zt = {
        name: 'SwitchVideo',
        components: { MediaSecurityAccess: _t.a },
        data: function () {
          return {}
        },
        props: {
          allOnStage: {
            type: Boolean,
            default: false,
          },
        },
        computed: {
          cameraStatus: function () {
            return (
              console.info(
                '对象函数 cameraStatus,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/Camera/SwitchCamera.vue'
              ),
              this.$store.state.smallClass.cameraStatus
            )
          },
          disabledStatus: function () {
            return (
              console.info(
                '对象函数 disabledStatus,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/Camera/SwitchCamera.vue'
              ),
              this.$store.state.smallClass.interactionStatus.random_call ||
                this.$store.state.smallClass.interactionStatus.random_video_mic
            )
          },
        },
        mounted: function () {
          this.listenerSignalService()
          this.listenerEvent()
        },
        methods: {
          listenerEvent: function () {
            console.info(
              '对象函数 listenerEvent,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/Camera/SwitchCamera.vue'
            )
            this.$bus.$on('openCamera', this.handleCameraStatus)
          },
          listenerSignalService: function () {
            console.info(
              '对象函数 listenerSignalService,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/Camera/SwitchCamera.vue'
            )
            var e = this.thinkClass.SignalService
            e.on('onRecvPeerMessage', this.recvPeerMessage)
          },
          removeAllListener: function () {
            console.info(
              '对象函数 removeAllListener,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/Camera/SwitchCamera.vue'
            )
            this.$bus.$off('openCamera', this.handleCameraStatus)
            this.thinkClass.SignalService.off(
              'onRecvPeerMessage',
              this.recvPeerMessage
            )
          },
          recvPeerMessage: function (e) {
            console.info(
              '对象函数 recvPeerMessage(res)',
              e,
              'filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/Camera/SwitchCamera.vue'
            )
            var t = e.content,
              n = t.ircType,
              s = t.data
            if ('user_video_mute' === n) {
              var o = !s.pub
              o
                ? this.$bus.$emit('showCameraAllowConfirm')
                : this.handleCameraStatus(o)
              this.sendLogger(
                '老师控制单独学生摄像头'
                  .concat(o ? '打开' : '关闭', '\uFF0Cres: ')
                  .concat(JSON.stringify(e))
              )
            }
          },
          handleCameraStatus: function (e) {
            var t = this
            return Object(y.a)(
              Object(x.a)().mark(function n() {
                var s, o
                return Object(x.a)().wrap(function (n) {
                  while (1) {
                    switch ((n.prev = n.next)) {
                      case 0:
                        return (
                          console.info(
                            '对象函数 handleCameraStatus(status)',
                            e,
                            'filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/Camera/SwitchCamera.vue'
                          ),
                          (n.next = 3),
                          Object(Q.c)()
                        )
                      case 3:
                        if (((s = n.sent), s)) {
                          n.next = 9
                          break
                        }
                        return (
                          console.info(
                            'if(!cameraAccessStatus)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/LiveComponents/Camera/SwitchCamera.vue'
                          ),
                          t.$refs.MediaSecurityAccessCamera.checkAccess(),
                          t.$store.dispatch(
                            'smallClass/updateCameraStatus',
                            false
                          ),
                          n.abrupt('return')
                        )
                      case 9:
                        ;(o = 'boolean' === typeof e ? e : !t.cameraStatus),
                          t.$bus.$emit('updateLocalDisplayVideoStatus', o),
                          t.$store.dispatch('smallClass/updateCameraStatus', o),
                          t.$bus.$emit('updateCameraStatus', o),
                          Ht.s(o)
                      case 14:
                      case 'end':
                        return n.stop()
                    }
                  }
                }, n)
              })
            )()
          },
          onStageHandleStatus: function () {
            console.info(
              '对象函数 onStageHandleStatus,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/Camera/SwitchCamera.vue'
            )
            this.allOnStage
              ? this.handleCameraStatus(!this.cameraStatus)
              : console.info(
                  'if(!this.allOnStage)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/LiveComponents/Camera/SwitchCamera.vue'
                )
          },
          sendLogger: function (e) {
            q.a.send({
              tag: 'cameraStatus',
              content: { msg: e },
            })
          },
        },
        beforeDestroy: function () {
          console.info(
            '对象函数 beforeDestroy,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/Camera/SwitchCamera.vue'
          )
          this.removeAllListener()
        },
      },
      en = Zt,
      tn = (n('6e2e'), Object(U.a)(en, Xt, Yt, false, null, 'c195d914', null)),
      nn = tn.exports,
      sn = function () {
        var e = this,
          t = e._self._c
        return t(
          'div',
          {
            staticClass: 'setting-tools-homeworkbox',
            attrs: { id: 'setting-tools-homeworkbox' },
            on: {
              click: function (t) {
                return (
                  t.stopPropagation(), e.handleOpenBox.apply(null, arguments)
                )
              },
            },
          },
          [
            t('div', { staticClass: 'left' }, [
              t('span', { staticClass: 'icon' }, [
                t('span', { staticClass: 'normal' }),
                e.showNewMessageTip
                  ? t('div', { staticClass: 'msg' }, [e._v('+1')])
                  : e._e(),
              ]),
              t('span', { staticClass: 'text' }, [
                e._v(e._s(e.$t('classroom.smallClass.homework.buttonName'))),
              ]),
            ]),
            e._m(0),
          ]
        )
      },
      on = [
        function () {
          var e = this,
            t = e._self._c
          return t('span', { staticClass: 'hover' }, [t('label')])
        },
      ],
      an = {
        name: 'FeedbackEntry',
        components: {},
        data: function () {
          return { shouldShowMessage: true }
        },
        props: {
          showNewMessageTip: {
            type: Boolean,
            default: false,
          },
        },
        computed: {},
        mounted: function () {},
        methods: {
          handleOpenBox: function () {
            console.info(
              '对象函数 handleOpenBox,filePath:renderer/components/Classroom/SmallClass/Live/Sidebar/Settings/SettingTools/HomeworkBoxEntry.vue'
            )
            var e = document.querySelector('#setting-tools-homeworkbox')
            this.$emit('closeSettingPane')
            this.$bus.$emit('handleOpenBox', e)
            this.$parent.$parent.showNewMessageTip = false
          },
        },
      },
      rn = an,
      cn = (n('c0ca'), Object(U.a)(rn, sn, on, false, null, '40be03b4', null)),
      ln = cn.exports,
      dn = function () {
        var e = this,
          t = e._self._c
        return t(
          'div',
          {
            staticClass: 'setting-tools-feedeback',
            on: {
              click: function (t) {
                return (
                  t.stopPropagation(),
                  e.handleOpenFeedback.apply(null, arguments)
                )
              },
            },
          },
          [
            t('span', { staticClass: 'setting-feedback' }, [
              e._m(0),
              t('span', { staticClass: 'text' }, [
                e._v(
                  ' ' +
                    e._s(e.$t('classroom.smallClass.feedback.buttonName')) +
                    ' '
                ),
              ]),
            ]),
            e._m(1),
          ]
        )
      },
      un = [
        function () {
          var e = this,
            t = e._self._c
          return t('span', { staticClass: 'icon' }, [
            t('span', { staticClass: 'normal' }),
          ])
        },
        function () {
          var e = this,
            t = e._self._c
          return t('span', { staticClass: 'hover' }, [t('label')])
        },
      ],
      mn = {
        name: 'FeedbackEntry',
        components: {},
        data: function () {
          return {}
        },
        computed: {},
        mounted: function () {},
        methods: {
          handleOpenFeedback: function () {
            console.info(
              '对象函数 handleOpenFeedback,filePath:renderer/components/Classroom/SmallClass/Live/Sidebar/Settings/SettingTools/FeedbackEntry.vue'
            )
            this.$bus.$emit('handleOpenFeedback', true)
            this.$emit('closeSettingPane')
          },
        },
      },
      hn = mn,
      fn = (n('f1a5'), Object(U.a)(hn, dn, un, false, null, '16c39e25', null)),
      pn = fn.exports,
      vn = function () {
        var e = this,
          t = e._self._c
        return t(
          'div',
          {
            staticClass: 'setting-tools-ExamReport',
            on: { click: e.handleOpenExamReport },
          },
          [
            t('span', { staticClass: 'setting-examReport' }, [
              e._m(0),
              t('span', { staticClass: 'text' }, [
                e._v(
                  ' ' +
                    e._s(e.$t('classroom.smallClass.examReport.buttonName')) +
                    ' '
                ),
              ]),
            ]),
            e._m(1),
          ]
        )
      },
      Cn = [
        function () {
          var e = this,
            t = e._self._c
          return t('span', { staticClass: 'icon' }, [
            t('span', { staticClass: 'normal' }),
          ])
        },
        function () {
          var e = this,
            t = e._self._c
          return t('span', { staticClass: 'hover' }, [t('label')])
        },
      ],
      Sn = {
        name: 'ExamReportEntry',
        components: {},
        data: function () {
          return {}
        },
        computed: {},
        mounted: function () {},
        methods: {
          handleOpenExamReport: function () {
            console.info(
              '对象函数 handleOpenExamReport,filePath:renderer/components/Classroom/SmallClass/Live/Sidebar/Settings/SettingTools/ExamReportEntry.vue'
            )
            this.$bus.$emit('handleOpenExamReport', true)
            this.$emit('closeSettingPane')
          },
        },
      },
      gn = Sn,
      bn = (n('1c10'), Object(U.a)(gn, vn, Cn, false, null, '1bec075b', null)),
      wn = bn.exports,
      kn = n('02fc'),
      Ln = {
        name: 'SettingTools',
        components: {
          SwitchCamera: nn,
          FeedbackEntry: pn,
          HomeworkBoxEntry: ln,
          ExamReportEntry: wn,
        },
        data: function () {
          return {
            showSettingTools: false,
            local: 'us',
          }
        },
        props: {
          showNewMessageTip: {
            type: Boolean,
            default: false,
          },
          reportBtnVisible: {
            type: Boolean,
            default: false,
          },
        },
        computed: {},
        mounted: function () {
          var e = this
          return Object(y.a)(
            Object(x.a)().mark(function t() {
              return Object(x.a)().wrap(function (t) {
                while (1) {
                  switch ((t.prev = t.next)) {
                    case 0:
                      return (t.next = 2), Object(kn.c)()
                    case 2:
                      e.local = t.sent
                    case 3:
                    case 'end':
                      return t.stop()
                  }
                }
              }, t)
            })
          )()
        },
        methods: {
          openSetting: function () {
            console.info(
              '对象函数 openSetting,filePath:renderer/components/Classroom/SmallClass/Live/Sidebar/Settings/SettingTools/index.vue'
            )
          },
          closeSettingPane: function () {
            console.info(
              '对象函数 closeSettingPane,filePath:renderer/components/Classroom/SmallClass/Live/Sidebar/Settings/SettingTools/index.vue'
            )
            this.showSettingTools = false
            this.$emit('handleUnselect')
          },
          openSettingTools: function () {
            console.info(
              '对象函数 openSettingTools,filePath:renderer/components/Classroom/SmallClass/Live/Sidebar/Settings/SettingTools/index.vue'
            )
            this.showSettingTools = true
          },
        },
      },
      xn = Ln,
      yn = (n('6c63'), Object(U.a)(xn, Kt, qt, false, null, '53839eee', null)),
      In = yn.exports,
      Pn = n('a5d8'),
      On = n('36e6'),
      An = {
        name: 'SettingTool',
        components: { SettingTools: In },
        data: function () {
          return {
            isSelected: false,
            isOpenTools: false,
            local: 'us',
            showNewMessageTip: false,
            reportBtnVisible: false,
            baseData: this.$store.state.smallClass.baseData,
          }
        },
        computed: {},
        mounted: function () {
          var e = this
          return Object(y.a)(
            Object(x.a)().mark(function t() {
              return Object(x.a)().wrap(function (t) {
                while (1) {
                  switch ((t.prev = t.next)) {
                    case 0:
                      return (t.next = 2), Object(kn.c)()
                    case 2:
                      ;(e.local = t.sent),
                        e.initShowReportBtn(),
                        e.$bus.$on('smallClassShowMessageTip', function () {
                          console.info(
                            '箭头函数 监听 smallClassShowMessageTip,filePath:renderer/components/Classroom/SmallClass/Live/Sidebar/Settings/index.vue'
                          )
                          q.a.send({
                            tag: 'student.Interact',
                            content: {
                              msg: '显示作业批改消息提示',
                              interactType: 'Wall',
                            },
                          })
                          e.showNewMessageTip = true
                        })
                    case 5:
                    case 'end':
                      return t.stop()
                  }
                }
              }, t)
            })
          )()
        },
        directives: { Clickoutside: Pn.a },
        methods: {
          handleSettingOpen: function () {
            console.info(
              '对象函数 handleSettingOpen,filePath:renderer/components/Classroom/SmallClass/Live/Sidebar/Settings/index.vue'
            )
            this.isSelected = true
            this.$refs.SettingToolRef.openSettingTools()
            this.$bus.$emit('openSettingPane', true)
          },
          handleSettingHide: function (e) {
            console.info(
              '对象函数 handleSettingHide(e)',
              e,
              'filePath:renderer/components/Classroom/SmallClass/Live/Sidebar/Settings/index.vue'
            )
            var t = document.querySelector('#setting'),
              n = t == e.target || t.contains(e.target)
            if (n && !this.isOpenTools) {
              return (
                console.info(
                  'if(clickDom && !this.isOpenTools)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/Sidebar/Settings/index.vue'
                ),
                void (this.isOpenTools = true)
              )
            }
            this.$refs.SettingToolRef.closeSettingPane()
            this.isSelected = false
            this.isOpenTools = false
            this.$bus.$emit('openSettingPane', false)
          },
          handleUnselect: function () {
            console.info(
              '对象函数 handleUnselect,filePath:renderer/components/Classroom/SmallClass/Live/Sidebar/Settings/index.vue'
            )
            this.isSelected = this.isOpenTools = false
          },
          initShowReportBtn: function () {
            var e = this
            return Object(y.a)(
              Object(x.a)().mark(function t() {
                var n, s
                return Object(x.a)().wrap(function (t) {
                  while (1) {
                    switch ((t.prev = t.next)) {
                      case 0:
                        return (
                          console.info(
                            '对象函数 initShowReportBtn,filePath:renderer/components/Classroom/SmallClass/Live/Sidebar/Settings/index.vue'
                          ),
                          (t.next = 3),
                          Object(On.a)({
                            planId: e.baseData.planInfo.id,
                            platform: '3',
                          })
                        )
                      case 3:
                        if (((s = t.sent), s && 0 == s.code)) {
                          t.next = 7
                          break
                        }
                        return (
                          console.info(
                            'if(!res || res.code != 0)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/Sidebar/Settings/index.vue'
                          ),
                          t.abrupt('return')
                        )
                      case 7:
                        e.reportBtnVisible =
                          '1' ===
                          (null === s ||
                          void 0 === s ||
                          null === (n = s.data) ||
                          void 0 === n
                            ? void 0
                            : n.showReportEnter)
                      case 8:
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
      jn = An,
      Mn = (n('3983'), Object(U.a)(jn, zt, Qt, false, null, '86461304', null)),
      Tn = Mn.exports,
      Rn = function () {
        var e = this,
          t = e._self._c
        return t(
          'div',
          {
            class: e.allOnStage
              ? 'allOnStage-emoji-container'
              : 'sidebar-emoji-container',
          },
          [
            e.showForbiddenTip
              ? t('div', { staticClass: 'forbiddenTips' }, [
                  e._v(
                    ' ' +
                      e._s(
                        e.$t(
                          'classroom.smallClass.sendEmoji.forbiddenSendMessage'
                        )
                      ) +
                      ' '
                  ),
                ])
              : e._e(),
            t(
              'div',
              {
                staticClass: 'emoji-operator',
                attrs: { id: 'emoji-operator' },
                on: { click: e.openEmojiPane },
              },
              [
                e.allOnStage
                  ? [
                      t(
                        'div',
                        {
                          staticClass: 'icon',
                          class: e.isSelected ? 'selected' : '',
                        },
                        [
                          t('span', {
                            class: e.isSelected ? 'selected' : 'normal',
                          }),
                        ]
                      ),
                      t(
                        'span',
                        {
                          staticClass: 'text',
                          class: e.isSelected ? 'selected' : 'normal',
                        },
                        [
                          e._v(
                            ' ' +
                              e._s(
                                e.$t(
                                  'classroom.smallClass.sendEmoji.buttonName'
                                )[0]
                              ) +
                              ' '
                          ),
                        ]
                      ),
                    ]
                  : [
                      t(
                        'div',
                        {
                          staticClass: 'icon',
                          class: e.isSelected ? 'selected' : '',
                        },
                        [
                          t('span', {
                            staticClass: 'normal',
                            class: e.emojiStatusStyle,
                          }),
                        ]
                      ),
                      e.showProgress
                        ? t(
                            'div',
                            { staticClass: 'count-down-container' },
                            [
                              t('CountDownProgress', {
                                attrs: {
                                  progressTimeFromParent: e.progressTime,
                                  countdownTimeFromParent: e.countdownTime,
                                  strokeWidth: 22,
                                  showTime: e.progressTextColor,
                                  strokeColor: {
                                    from: 'rgba(255, 207, 27, 1)',
                                    to: 'rgba(255, 207, 27, 1)',
                                  },
                                },
                                on: {
                                  countdownCompleted: e.countdownCompleted,
                                },
                              }),
                            ],
                            1
                          )
                        : t(
                            'span',
                            {
                              staticClass: 'text',
                              class: e.isSelected ? 'selected' : 'normal',
                            },
                            [
                              e._v(
                                ' ' +
                                  e._s(
                                    e.$t(
                                      'classroom.smallClass.sendEmoji.buttonName[0]'
                                    )
                                  ) +
                                  ' '
                              ),
                            ]
                          ),
                    ],
              ],
              2
            ),
            t('EmojiPane', {
              directives: [
                {
                  name: 'clickoutside',
                  rawName: 'v-clickoutside',
                  value: e.closeEmojiPane,
                  expression: 'closeEmojiPane',
                },
              ],
              ref: 'emojiPaneRef',
              staticClass: 'emoji-pane',
              class: e.allOnStage ? 'allOnStage-emoji-pane' : '',
              style: { left: e.left + 'px' },
              attrs: {
                options: e.commonOptions,
                allOnStage: e.allOnStage,
                packageId: e.packageId,
              },
              on: { handleSendEmoji: e.handleSendEmoji },
            }),
          ],
          1
        )
      },
      Bn = [],
      Dn = function () {
        var e = this,
          t = e._self._c
        return e.showEmojiPane
          ? t(
              'div',
              {
                directives: [
                  {
                    name: 'clickoutside',
                    rawName: 'v-clickoutside',
                    value: e.closeEmojiPane,
                    expression: 'closeEmojiPane',
                  },
                ],
                staticClass: 'emojis-pane-container',
                class: e.allOnStage ? 'allOnStage-pane-container' : '',
              },
              [
                t('section', { staticClass: 'emojis-nav' }, [
                  t(
                    'ul',
                    e._l(e.getDynamicEmolist, function (s, o) {
                      return t(
                        'li',
                        {
                          key: s.emojiPackageId,
                          staticClass: 'emoji-nav-content',
                          class:
                            s.emojiPackageId == e.currentOrderId
                              ? 'active'
                              : '',
                          on: {
                            click: function (t) {
                              return e.selectedEmoji(s.emojiPackageId, o)
                            },
                          },
                        },
                        [
                          s.isLocal
                            ? t('img', {
                                attrs: {
                                  src: n('ff63'),
                                  alt: '',
                                },
                              })
                            : t('img', {
                                attrs: {
                                  src: s.picture,
                                  alt: '',
                                },
                              }),
                        ]
                      )
                    }),
                    0
                  ),
                ]),
                t('section', { staticClass: 'emojis-list' }, [
                  t(
                    'div',
                    {
                      ref: 'scrollWrapper',
                      staticClass: 'emoji-scroll-wrapper',
                    },
                    [
                      e._l(e.getDynamicEmolist, function (n) {
                        return [
                          1 == n.isOver && 1 == n.overShow
                            ? t('expiredEmojiChunk', {
                                key: n.emojiPackageId,
                                attrs: { imgSrc: n.picture },
                              })
                            : t('emojiChunk', {
                                key: n.emojiPackageId + 1,
                                staticClass: 'emoji-show-list',
                                attrs: {
                                  list: n.content,
                                  lineNum: 1 == n.isLocal ? 3 : 2,
                                  isLocal: n.isLocal,
                                },
                                on: {
                                  handleClick: function (t) {
                                    return e.sendEmoji(arguments, n)
                                  },
                                },
                              }),
                        ]
                      }),
                    ],
                    2
                  ),
                ]),
              ]
            )
          : e._e()
      },
      Vn = [],
      Nn = n('3835'),
      En =
        (n('8a79'),
        function () {
          var e = this,
            t = e._self._c
          return t(
            'div',
            { staticClass: 'emojiPane' },
            e._l(e.lineNum, function (n) {
              return t(
                'div',
                {
                  key: n,
                  staticClass: 'emojiLine',
                },
                [
                  e._l(e.list, function (s, o) {
                    return [
                      o < e.perLineEmojiNum * n &&
                      o >= e.perLineEmojiNum * (n - 1)
                        ? t(
                            'div',
                            {
                              key: o,
                              class: ['emoji-group-item', e.emojiSize],
                            },
                            [
                              e.isLocal
                                ? t('Emoticon', {
                                    attrs: {
                                      name: s.name,
                                      type: s.type,
                                      enableHover: true,
                                      hoverWidth: e.hoverWidth,
                                      hoverHeight: e.hoverHeight,
                                      width: e.width,
                                      height: e.height,
                                    },
                                    on: {
                                      handleClick: function (t) {
                                        return e.clickEmoji(s, o)
                                      },
                                    },
                                  })
                                : t(
                                    'div',
                                    {
                                      staticClass: 'dynamic-emoji',
                                      on: {
                                        click: function (t) {
                                          return e.clickEmoji(s, o)
                                        },
                                      },
                                    },
                                    [
                                      t('img', {
                                        attrs: {
                                          src: s.emojiPicture,
                                          alt: '',
                                        },
                                      }),
                                    ]
                                  ),
                            ],
                            1
                          )
                        : e._e(),
                    ]
                  }),
                ],
                2
              )
            }),
            0
          )
        }),
      _n = [],
      Hn = n('90ea'),
      Un = {
        name: 'emojiChunk',
        components: { Emoticon: Hn.a },
        props: {
          list: {
            type: Array,
            default: [],
          },
          lineNum: {
            type: Number,
            default: 3,
          },
          isLocal: {
            type: Boolean,
            default: true,
          },
          width: {
            type: Number,
            default: 40,
          },
          height: {
            type: Number,
            default: 40,
          },
          hoverWidth: {
            type: Number,
            default: 45,
          },
          hoverHeight: {
            type: Number,
            default: 45,
          },
        },
        data: function () {
          return {}
        },
        computed: {
          perLineEmojiNum: function () {
            return Math.ceil(this.list.length / this.lineNum)
          },
          emojiSize: function () {
            return 'emojiSize'.concat(this.lineNum)
          },
        },
        methods: {
          clickEmoji: function (e, t) {
            console.info(
              '对象函数 clickEmoji(params, index)',
              e,
              t,
              'filePath:renderer/components/Classroom/CommonModules/EmojiPane/emojiChunk.vue'
            )
            this.$emit('handleClick', e, t)
          },
        },
      },
      $n = Un,
      Wn = (n('bc48'), Object(U.a)($n, En, _n, false, null, '8bd0a4e4', null)),
      Gn = Wn.exports,
      Fn = function () {
        var e = this,
          t = e._self._c
        return t('div', { staticClass: 'emojiPane' }, [
          t('div', { staticClass: 'emojiGroup-overShow' }, [
            t('span', { staticClass: 'overShow-emoji' }, [
              t('img', { attrs: { src: e.imgSrc } }),
              t('span'),
            ]),
            t('p', { staticClass: 'overShow-tips top' }, [
              e._v(
                ' ' + e._s(e.$t('classroom.smallClass.dynamicEmoji[0]')) + ' '
              ),
            ]),
            t('p', { staticClass: 'overShow-tips' }, [
              e._v(e._s(e.$t('classroom.smallClass.dynamicEmoji[1]'))),
            ]),
          ]),
        ])
      },
      Jn = [],
      zn = {
        name: 'ExpiredEmojiChunk',
        props: {
          imgSrc: {
            type: String,
            default: '',
          },
        },
      },
      Qn = zn,
      Kn = (n('c0ee'), Object(U.a)(Qn, Fn, Jn, false, null, '2c064bb7', null)),
      qn = Kn.exports,
      Xn = n('92e5'),
      Yn = n('975c'),
      Zn = {
        name: 'EmojiPane',
        components: {
          emojiChunk: Gn,
          expiredEmojiChunk: qn,
        },
        data: function () {
          return {
            showEmojiPane: false,
            nickName: '',
            avatar: '',
            currentOrderId: 0,
          }
        },
        props: {
          options: {
            type: Object,
            default: null,
          },
          allOnStage: {
            type: Boolean,
            default: false,
          },
          packageId: {
            type: Number,
            default: 0,
          },
        },
        computed: {
          getDynamicEmolist: function () {
            return this.$store.state.smallClass.dynamicEmojiLists
          },
        },
        mounted: function () {
          this.getUserInfo()
        },
        methods: {
          getUserInfo: function () {
            var e = this
            return Object(y.a)(
              Object(x.a)().mark(function t() {
                var n, s, o
                return Object(x.a)().wrap(function (t) {
                  while (1) {
                    switch ((t.prev = t.next)) {
                      case 0:
                        return (
                          console.info(
                            '对象函数 getUserInfo,filePath:renderer/components/Classroom/CommonModules/EmojiPane/index.vue'
                          ),
                          (t.next = 3),
                          Object(Xn.a)()
                        )
                      case 3:
                        ;(n = t.sent),
                          (s = n.nickName),
                          (o = n.avatar),
                          (e.nickName = s),
                          (e.avatar = o)
                      case 8:
                      case 'end':
                        return t.stop()
                    }
                  }
                }, t)
              })
            )()
          },
          sendEmoji: function (e, t) {
            var n,
              s = Object(Nn.a)(e, 2),
              o = s[0],
              a = s[1]
            if (
              (console.info(
                '对象函数 sendEmoji(params, key, emojiGroup)',
                o,
                a,
                t,
                'filePath:renderer/components/Classroom/CommonModules/EmojiPane/index.vue'
              ),
              1 == o.type)
            ) {
              n = this.emojiIrcConfig('send_emoji', o)
            } else {
              var i = o.lottieUrl.endsWith('.json') ? 2 : 3
              o = Object.assign(o, {
                type: i,
                name: o.emojiName,
              })
              n = this.emojiIrcConfig('animation_emoji', o)
              n.content.data.resource = {
                emojiName: o.emojiName,
                emojiId: o.emojiId,
                emojiPicture: o.emojiPicture,
                lottieUrl: o.lottieUrl,
              }
            }
            this.thinkClass.SignalService &&
              this.thinkClass.SignalService.sendRoomMessage(n)
            this.$emit('handleSendEmoji')
            this.$bus.$emit('sendEmoji', o)
            this.closeEmojiPane()
            Object(Yn.c)(this.options, o, t, a, this.allOnStage, this.packageId)
            Ht.c({
              type: 4,
              contentType: 'emoji',
              msg: ''.concat(o.name),
            })
          },
          emojiIrcConfig: function (e, t) {
            return (
              console.info(
                '对象函数 emojiIrcConfig(emojitype, params)',
                e,
                t,
                'filePath:renderer/components/Classroom/CommonModules/EmojiPane/index.vue'
              ),
              {
                roomList: this.options.roomlist,
                content: {
                  ircType: e,
                  data: {
                    name: t.name,
                    type: t.type,
                  },
                  from: {
                    username: this.nickName,
                    path: this.avatar,
                  },
                },
                chatMsgPriority: 99,
              }
            )
          },
          closeEmojiPane: function () {
            console.info(
              '对象函数 closeEmojiPane,filePath:renderer/components/Classroom/CommonModules/EmojiPane/index.vue'
            )
            this.showEmojiPane = false
            this.currentOrderId = 0
          },
          openEmojiPane: function () {
            console.info(
              '对象函数 openEmojiPane,filePath:renderer/components/Classroom/CommonModules/EmojiPane/index.vue'
            )
            this.showEmojiPane = true
          },
          selectedEmoji: function (e, t) {
            console.info(
              '对象函数 selectedEmoji(emojiPackageId, key)',
              e,
              t,
              'filePath:renderer/components/Classroom/CommonModules/EmojiPane/index.vue'
            )
            this.currentOrderId = e
            var n = document.getElementsByClassName('emoji-show-list')[t]
            n && n.scrollIntoView({ inline: 'center' })
          },
        },
      },
      es = Zn,
      ts = (n('7825'), Object(U.a)(es, Dn, Vn, false, null, 'c29cc0b0', null)),
      ns = ts.exports,
      ss = function () {
        var e = this,
          t = e._self._c
        return t(
          'div',
          [
            t(
              'span',
              {
                staticClass: 'show-time',
                style: { color: e.showTime },
              },
              [e._v(e._s(e.countdownTime) + 's')]
            ),
            t('a-progress', {
              attrs: {
                percent: e.percent,
                strokeWidth: e.strokeWidth,
                showInfo: false,
                strokeLinecap: 'square',
                strokeColor: {
                  from: e.strokeColor.from,
                  to: e.strokeColor.to,
                },
              },
            }),
          ],
          1
        )
      },
      os = [],
      as =
        (n('b680'),
        {
          name: 'CountDownProgress',
          components: {},
          data: function () {
            return {
              progressTime: this.progressTimeFromParent,
              countdownTime: this.countdownTimeFromParent,
              percent: 0,
            }
          },
          props: {
            countdownTimeFromParent: {
              type: Number,
              default: 30,
            },
            progressTimeFromParent: {
              type: Number,
              default: 300,
            },
            strokeWidth: {
              type: Number,
              default: 20,
            },
            showTime: {
              type: String,
              default: '#fff',
            },
            strokeColor: {
              type: Object,
              default: function () {
                return {
                  from: '',
                  to: '',
                }
              },
            },
          },
          computed: {},
          mounted: function () {
            this.setCountdown()
            this.setProgressPercent()
          },
          methods: {
            setCountdown: function () {
              var e = this
              if (
                (console.info(
                  '对象函数 setCountdown,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/CountDownProgress/index.vue'
                ),
                this.countdownTime <= 0)
              ) {
                return (
                  console.info(
                    'if(this.countdownTime <= 0)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/LiveComponents/CountDownProgress/index.vue'
                  ),
                  (this.countdownTime = this.countdownTimeFromParent),
                  void this.$emit('countdownCompleted')
                )
              }
              var t = setTimeout(function () {
                e.countdownTime--
                e.setCountdown()
                clearTimeout(t)
                t = null
              }, 1000)
            },
            setProgressPercent: function () {
              var e = this
              if (this.progressTime <= 0) {
                return (
                  console.info(
                    'if(this.progressTime <= 0)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/LiveComponents/CountDownProgress/index.vue'
                  ),
                  (this.progressTime = 100)
                )
              }
              this.progressTime--
              this.percent = this.calcProgressPercent(
                this.progressTimeFromParent,
                this.progressTime
              )
              var t = setTimeout(function () {
                e.setProgressPercent()
                clearTimeout(t)
                t = null
              }, 100)
            },
            calcProgressPercent: function (e, t) {
              if (((e = parseInt(e)), (t = parseInt(t)), 0 === e || 0 === t)) {
                return (
                  console.info(
                    'if(total === 0 || completed === 0)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/LiveComponents/CountDownProgress/index.vue'
                  ),
                  0
                )
              }
              var n = ((e - t) / e) * 100
              return parseFloat(n.toFixed(2))
            },
          },
        }),
      is = as,
      rs = (n('b146'), Object(U.a)(is, ss, os, false, null, '24c46db5', null)),
      cs = rs.exports,
      ls = {
        name: 'Emojis',
        components: {
          EmojiPane: ns,
          CountDownProgress: cs,
        },
        data: function () {
          return {
            isSelected: false,
            showProgress: false,
            progressTime: 300,
            countdownTime: 30,
            forbiddenTimer: null,
            showCountDown: false,
            firstSendEmojiTime: null,
            sendEmojiCount: 0,
            isOpenPane: false,
            progressTextColor: '#FF850A',
            emojiForbiddenStatus: false,
            showForbiddenTip: false,
            left: 0,
          }
        },
        computed: {
          commonOptions: function () {
            return (
              console.info(
                '对象函数 commonOptions,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/SendEmoji/index.vue'
              ),
              this.$store.state.smallClass.baseData.commonOption
            )
          },
          packageId: function () {
            return (
              console.info(
                '对象函数 packageId,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/SendEmoji/index.vue'
              ),
              this.$store.state.smallClass.baseData.planInfo.packageId
            )
          },
          courseWareBounce: function () {
            return (
              console.info(
                '对象函数 courseWareBounce,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/SendEmoji/index.vue'
              ),
              this.$store.state.smallClass.coursesPosition
            )
          },
          emojiStatusStyle: function () {
            return (
              console.info(
                '对象函数 emojiStatusStyle,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/SendEmoji/index.vue'
              ),
              {
                forbidden: this.emojiForbiddenStatus,
                selected: this.isSelected,
                disabled: this.showProgress,
              }
            )
          },
        },
        directives: { Clickoutside: Pn.a },
        props: {
          allOnStage: {
            type: Boolean,
            default: false,
          },
        },
        mounted: function () {
          this.bindEvents()
        },
        methods: {
          openEmojiPane: function () {
            var e = this
            if (
              (console.info(
                '对象函数 openEmojiPane,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/SendEmoji/index.vue'
              ),
              !this.allOnStage)
            ) {
              if (this.showProgress) {
                return (
                  console.info(
                    'if(this.showProgress)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/LiveComponents/SendEmoji/index.vue'
                  ),
                  this.$Message.destroy(),
                  void this.$Message.warning(
                    this.$t('classroom.smallClass.sendEmoji.sendTooFastNotice')
                  )
                )
              }
              if (this.emojiForbiddenStatus) {
                return (
                  console.info(
                    'if(this.emojiForbiddenStatus)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/LiveComponents/SendEmoji/index.vue'
                  ),
                  this.timer && clearTimeout(this.timer),
                  (this.showForbiddenTip = true),
                  void (this.timer = setTimeout(function () {
                    e.showForbiddenTip = false
                  }, 3000))
                )
              }
            }
            this.isSelected ||
              Object(Yn.b)(this.commonOptions, this.allOnStage, this.packageId)
            this.isSelected = true
            document.querySelector('.courseware-board-wrapper') &&
              (this.left = document
                .querySelector('.courseware-board-wrapper')
                .getBoundingClientRect().left)
            this.$refs.emojiPaneRef.openEmojiPane()
          },
          closeEmojiPane: function (e) {
            console.info(
              '对象函数 closeEmojiPane(e)',
              e,
              'filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/SendEmoji/index.vue'
            )
            var t = document.querySelector('#emoji-operator'),
              n = t == e.target || t.contains(e.target)
            if (n && !this.isOpenPane) {
              return (
                console.info(
                  'if(clickDom && !this.isOpenPane)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/LiveComponents/SendEmoji/index.vue'
                ),
                void (this.isOpenPane = true)
              )
            }
            this.handleClosePane()
          },
          handleClosePane: function () {
            console.info(
              '对象函数 handleClosePane,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/SendEmoji/index.vue'
            )
            this.$refs.emojiPaneRef.closeEmojiPane()
            this.isOpenPane = this.isSelected = false
          },
          handleSendEmoji: function () {
            var e = this
            if (
              (console.info(
                '对象函数 handleSendEmoji,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/SendEmoji/index.vue'
              ),
              (this.isSelected = false),
              (this.isOpenPane = false),
              (this.sendEmojiCount += 1),
              1 == this.sendEmojiCount)
            ) {
              this.firstSendEmojiTime = new Date().getTime()
            } else {
              if (3 == this.sendEmojiCount) {
                var t =
                  Math.floor(new Date().getTime() - this.firstSendEmojiTime) /
                  1000
                t <= 30
                  ? ((this.showProgress = true),
                    (this.forbiddenTimer = window.setTimeout(function () {
                      console.info(
                        '箭头函数 setTimeout,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/SendEmoji/index.vue'
                      )
                      e.getResetTimer()
                    }, 30000)))
                  : ((this.sendEmojiCount = 1),
                    (this.firstSendEmojiTime = new Date().getTime()))
              }
            }
          },
          bindEvents: function () {
            console.info(
              '对象函数 bindEvents,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/SendEmoji/index.vue'
            )
            this.$bus.$on('forbidden_student_emoji', this.getEmojiStatus)
          },
          getEmojiStatus: function (e) {
            console.info(
              '对象函数 getEmojiStatus(params)',
              e,
              'filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/SendEmoji/index.vue'
            )
            this.emojiForbiddenStatus =
              null === e || void 0 === e ? void 0 : e.pub
            null !== e &&
              void 0 !== e &&
              e.pub &&
              this.forbiddenTimer &&
              (this.clearLimitEmojiTimer(), this.getResetTimer())
          },
          getResetTimer: function () {
            console.info(
              '对象函数 getResetTimer,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/SendEmoji/index.vue'
            )
            this.sendEmojiCount = 0
            this.firstSendEmojiTime = new Date().getTime()
            this.showProgress = false
          },
          clearLimitEmojiTimer: function () {
            console.info(
              '对象函数 clearLimitEmojiTimer,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/SendEmoji/index.vue'
            )
            window.clearTimeout(this.forbiddenTimer)
            this.forbiddenTimer = null
          },
        },
        beforeDestroy: function () {
          console.info(
            '对象函数 beforeDestroy,filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/SendEmoji/index.vue'
          )
          this.$bus.$off('forbidden_student_emoji')
          this.clearLimitEmojiTimer()
        },
        watch: {
          emojiForbiddenStatus: function (e) {
            console.info(
              '对象函数 emojiForbiddenStatus(flag)',
              e,
              'filePath:renderer/components/Classroom/SmallClass/Live/LiveComponents/SendEmoji/index.vue'
            )
            e && !this.allOnStage && this.handleClosePane()
          },
        },
      },
      ds = ls,
      us = (n('4ec6'), Object(U.a)(ds, Rn, Bn, false, null, '415abe52', null)),
      ms = us.exports,
      hs = function () {
        var e = this,
          t = e._self._c
        return t(
          'div',
          [t('RaiseHandComp', { attrs: { options: e.commonOptions } })],
          1
        )
      },
      fs = [],
      ps = function () {
        var e = this,
          t = e._self._c
        return t(
          'div',
          {
            staticClass: 'raiseHand',
            class: !e.showRaiseHand || e.disabled ? 'raisingHand' : '',
          },
          [
            t(
              'div',
              {
                staticClass: 'raiseHand_inner',
                on: { click: e.handleRaiseHand },
              },
              [
                t('i', {
                  class:
                    !e.showRaiseHand || e.disabled
                      ? 'disabled-hand'
                      : 'normal-hand',
                }),
                e.showRaiseHand || e.disabled
                  ? t('div', { staticClass: 'raiseHand-btn' }, [
                      t(
                        'span',
                        { class: e.disabled ? 'disabled-text' : 'normal-text' },
                        [
                          e._v(
                            e._s(
                              e.disabled
                                ? e.$t(
                                    'classroom.smallClass.raiseHand.buttonName'
                                  )[1]
                                : e.$t(
                                    'classroom.smallClass.raiseHand.buttonName'
                                  )[0]
                            )
                          ),
                        ]
                      ),
                    ])
                  : e._e(),
                e.showRaiseHand
                  ? e._e()
                  : t('CountDownProgress', {
                      staticClass: 'raiseHand-countdown',
                      attrs: {
                        strokeWidth: 20,
                        progressTimeFromParent: e.progressTime,
                        countdownTimeFromParent: e.countdownTime,
                        strokeColor: {
                          from: 'rgba(2, 202, 138, 1)',
                          to: 'rgba(30, 252, 146, 1)',
                        },
                      },
                      on: { countdownCompleted: e.countdownCompleted },
                    }),
              ],
              1
            ),
          ]
        )
      },
      vs = [],
      Cs = n('0a4b'),
      Ss = n('bcaf'),
      gs = {
        props: {
          options: {
            type: Object,
            default: function () {},
          },
        },
        components: { CountDownProgress: cs },
        data: function () {
          return {
            showRaiseHand: true,
            countdownTime: 10,
            progressTime: 100,
            percent: 100,
            disabled: false,
            multVideoLinkStatus: false,
          }
        },
        computed: {
          cameraStatus: function () {
            return (
              console.info(
                '对象函数 cameraStatus,filePath:renderer/components/Classroom/SmallClass/Live/Sidebar/RaiseHand/RaiseHandComp/index.vue'
              ),
              this.$store.state.smallClass.cameraStatus
            )
          },
          microphoneStatus: function () {
            return (
              console.info(
                '对象函数 microphoneStatus,filePath:renderer/components/Classroom/SmallClass/Live/Sidebar/RaiseHand/RaiseHandComp/index.vue'
              ),
              this.$store.state.smallClass.microphoneStatus
            )
          },
        },
        mounted: function () {
          var e = this
          this.$bus.$on('raiseHandForMultVideoLink', function (t) {
            console.info(
              '箭头函数 监听 raiseHandForMultVideoLink(status)',
              t,
              'filePath:renderer/components/Classroom/SmallClass/Live/Sidebar/RaiseHand/RaiseHandComp/index.vue'
            )
            e.multVideoLinkStatus = t
          })
          this.$bus.$on('raiseHandDisabled', function (t) {
            console.info(
              '箭头函数 监听 raiseHandDisabled(status)',
              t,
              'filePath:renderer/components/Classroom/SmallClass/Live/Sidebar/RaiseHand/RaiseHandComp/index.vue'
            )
            t
              ? ((e.disabled = true), (e.showRaiseHand = true))
              : (e.disabled = false)
          })
          this.$bus.$on('raiseHandSendMessageToTeacher', function (t) {
            var n = t.type
            console.info(
              '箭头函数 监听 raiseHandSendMessageToTeacher(type)',
              n,
              'filePath:renderer/components/Classroom/SmallClass/Live/Sidebar/RaiseHand/RaiseHandComp/index.vue'
            )
            e.sendPeerMessageToTeacher({ type: n })
          })
        },
        methods: {
          handleRaiseHand: function () {
            if (
              (console.info(
                '对象函数 handleRaiseHand,filePath:renderer/components/Classroom/SmallClass/Live/Sidebar/RaiseHand/RaiseHandComp/index.vue'
              ),
              this.showRaiseHand && !this.disabled)
            ) {
              this.showRaiseHand = false
              this.sendPeerMessage()
              this.sendLogger('学员举手')
              var e = {
                roomList: this.options.roomlist,
                content: { ircType: 'raise_hand' },
                chatMsgPriority: 1,
              }
              this.thinkClass.SignalService.sendRoomMessage(e)
              this.$bus.$emit('sendRaiseHand', true)
              Ht.q()
            } else {
              console.info(
                'if(!this.showRaiseHand || this.disabled)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/Sidebar/RaiseHand/RaiseHandComp/index.vue'
              )
            }
          },
          sendPeerMessage: function () {
            console.info(
              '对象函数 sendPeerMessage,filePath:renderer/components/Classroom/SmallClass/Live/Sidebar/RaiseHand/RaiseHandComp/index.vue'
            )
            this.multVideoLinkStatus
            this.sendPeerMessageToTour()
            this.multVideoLinkStatus &&
              this.sendPeerMessageToTeacher({ type: 125 })
          },
          sendPeerMessageToTour: function () {
            var e = this
            return Object(y.a)(
              Object(x.a)().mark(function t() {
                var n, s, o
                return Object(x.a)().wrap(function (t) {
                  while (1) {
                    switch ((t.prev = t.next)) {
                      case 0:
                        return (
                          console.info(
                            '对象函数 sendPeerMessageToTour,filePath:renderer/components/Classroom/SmallClass/Live/Sidebar/RaiseHand/RaiseHandComp/index.vue'
                          ),
                          (t.next = 3),
                          Object(kn.f)()
                        )
                      case 3:
                        return (
                          (n = t.sent),
                          (t.next = 6),
                          Cs.nativeApi.getDeviceInfo()
                        )
                      case 6:
                        ;(s = t.sent),
                          (o = {
                            type: 160,
                            msg: 'raiseHand',
                            parameter: {
                              schoolCode: n,
                              planId: e.options.planId,
                              roomId: e.options.classId,
                              studentId: e.options.stuIRCId,
                              uid: e.options.stuId,
                              teacherId: e.options.teacherInfo.id,
                              teacherName: e.options.teacherInfo.name,
                              startTime: e.options.stime,
                              currenTime: new Date().getTime(),
                              device: s.platform,
                              deviceVersion: s.osVersion,
                              AppVersion: s.appVersion,
                            },
                          }),
                          window.ChatClient.PeerChatManager.sendPeerMessage(
                            [{ nickname: e.options.configs.tutorIrcId }],
                            JSON.stringify(o),
                            Ss.a.notice
                          )
                      case 9:
                      case 'end':
                        return t.stop()
                    }
                  }
                }, t)
              })
            )()
          },
          countdownCompleted: function () {
            console.info(
              '对象函数 countdownCompleted,filePath:renderer/components/Classroom/SmallClass/Live/Sidebar/RaiseHand/RaiseHandComp/index.vue'
            )
            this.showRaiseHand = true
          },
          sendPeerMessageToTeacher: function (e) {
            var t = e.type
            console.info(
              '对象函数 sendPeerMessageToTeacher(type)',
              t,
              'filePath:renderer/components/Classroom/SmallClass/Live/Sidebar/RaiseHand/RaiseHandComp/index.vue'
            )
            this.cameraStatus
            var n = {
              type: t || 125,
              status: 6,
              stuId: this.options.stuId,
              cameraIsOpen: this.cameraStatus ? 1 : 2,
              mikeAvailable: this.microphoneStatus ? 1 : 2,
            }
            window.ChatClient.PeerChatManager.sendPeerMessage(
              [{ nickname: this.options.configs.teacherIrcId }],
              JSON.stringify(n),
              Ss.a.notice
            )
          },
          sendLogger: function (e) {
            var t =
              arguments.length > 1 && void 0 !== arguments[1]
                ? arguments[1]
                : ''
            q.a.send({
              tag: 'student.Interact',
              content: {
                msg: e,
                interactType: 'stu_handsup',
                interactId: '',
                interactStage: t,
              },
            })
          },
        },
      },
      bs = gs,
      ws = (n('1bd1'), Object(U.a)(bs, ps, vs, false, null, '06cc6dd6', null)),
      ks = ws.exports,
      Ls = {
        name: 'raiseHand',
        components: { RaiseHandComp: ks },
        data: function () {
          return {}
        },
        computed: {
          commonOptions: function () {
            return (
              console.info(
                '对象函数 commonOptions,filePath:renderer/components/Classroom/SmallClass/Live/Sidebar/RaiseHand/index.vue'
              ),
              this.$store.state.smallClass.baseData.commonOption
            )
          },
        },
        mounted: function () {},
        methods: {},
      },
      xs = Ls,
      ys = Object(U.a)(xs, hs, fs, false, null, null, null),
      Is = ys.exports,
      Ps = function () {
        var e = this,
          t = e._self._c
        return t(
          'div',
          { staticClass: 'sidebar-module' },
          [
            t('Assignment'),
            t('CoinsBadge'),
            t('Feedback', { attrs: { options: e.commonOptions } }),
            t('ExamReport', { attrs: { commonOptions: e.commonOptions } }),
          ],
          1
        )
      },
      Os = [],
      As = function () {
        var e = this,
          t = e._self._c
        return t(
          'div',
          {
            directives: [
              {
                name: 'clickoutside',
                rawName: 'v-clickoutside',
                value: e.clickBoxOutside,
                expression: 'clickBoxOutside',
              },
            ],
          },
          [
            t('AssignmentBox', {
              ref: 'assignmentBoxRef',
              attrs: {
                'plan-id': e.planInfo.id,
                options: e.commonOptions,
                fromSmallClass: true,
              },
              on: { hideHeader: e.hideHeader },
            }),
          ],
          1
        )
      },
      js = [],
      Ms = n('6cd4'),
      Ts = {
        components: { AssignmentBox: Ms.a },
        data: function () {
          return {
            willOpenBox: false,
            homeworkEntryDom: null,
            checkBigPictureDom: null,
          }
        },
        computed: {
          commonOptions: function () {
            return (
              console.info(
                '对象函数 commonOptions,filePath:renderer/components/Classroom/SmallClass/Live/Sidebar/SiderbarModule/Assignment/index.vue'
              ),
              this.$store.state.smallClass.baseData.commonOption
            )
          },
          planInfo: function () {
            return (
              console.info(
                '对象函数 planInfo,filePath:renderer/components/Classroom/SmallClass/Live/Sidebar/SiderbarModule/Assignment/index.vue'
              ),
              this.$store.state.smallClass.baseData.planInfo
            )
          },
        },
        directives: { Clickoutside: Pn.a },
        mounted: function () {
          var e = this
          this.$bus.$on('handleOpenBox', function (t) {
            console.info(
              '箭头函数 监听 handleOpenBox(wrapperDom)',
              t,
              'filePath:renderer/components/Classroom/SmallClass/Live/Sidebar/SiderbarModule/Assignment/index.vue'
            )
            e.homeworkEntryDom = t
            e.$nextTick(function () {
              e.$refs.assignmentBoxRef.handleOpenAssignmentBox()
            })
          })
          this.$bus.$on('emitBigImgDom', function (t) {
            console.info(
              '箭头函数 监听 emitBigImgDom(wrapperDom)',
              t,
              'filePath:renderer/components/Classroom/SmallClass/Live/Sidebar/SiderbarModule/Assignment/index.vue'
            )
            e.checkBigPictureDom = t
          })
        },
        methods: {
          clickBoxOutside: function (e) {
            var t = this
            console.info(
              '对象函数 clickBoxOutside(e)',
              e,
              'filePath:renderer/components/Classroom/SmallClass/Live/Sidebar/SiderbarModule/Assignment/index.vue'
            )
            var n = e.target,
              s =
                (this.homeworkEntryDom && this.homeworkEntryDom.contains(n)) ||
                (this.checkBigPictureDom && this.checkBigPictureDom.contains(n))
            s
              ? console.info(
                  'if(isExcludeDom)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/Sidebar/SiderbarModule/Assignment/index.vue'
                )
              : this.$nextTick(function () {
                  t.$refs.assignmentBoxRef.hideAssignmentBoxOnly()
                })
          },
          beforeDestroy: function () {
            console.info(
              '对象函数 beforeDestroy,filePath:renderer/components/Classroom/SmallClass/Live/Sidebar/SiderbarModule/Assignment/index.vue'
            )
            this.$bus.$off('handleOpenBox')
            this.$bus.$off('emitBigImgDom')
          },
        },
      },
      Rs = Ts,
      Bs = Object(U.a)(Rs, As, js, false, null, null, null),
      Ds = Bs.exports,
      Vs = function () {
        var e = this,
          t = e._self._c
        return e.showCoinsBadge
          ? t('div', { staticClass: 'coins-badge' }, [
              t('section', [
                t('div', { staticClass: 'coins' }, [
                  t('div', { staticClass: 'coins-curlesson-coins' }, [
                    t('div', { staticClass: 'topTip' }, [
                      t('div', { staticClass: 'tip' }, [
                        e._v(
                          ' ' +
                            e._s(
                              e.$t(
                                'classroom.smallClass.coins.currentLessonCoinsTips'
                              )
                            ) +
                            ' '
                        ),
                      ]),
                    ]),
                    t('div', { staticClass: 'content' }, [
                      t('span', { staticClass: 'icon' }),
                      e.coinDatas
                        ? t('span', { staticClass: 'number' }, [
                            e._v('+' + e._s(e.coinDatas.planIdCoin)),
                          ])
                        : e._e(),
                    ]),
                  ]),
                  t('div', { staticClass: 'coins-total-coins' }, [
                    t('div', { staticClass: 'topTip' }, [
                      t('div', { staticClass: 'tip' }, [
                        e._v(
                          ' ' +
                            e._s(
                              e.$t('classroom.smallClass.coins.totalCoinsTips')
                            ) +
                            ' '
                        ),
                      ]),
                    ]),
                    t('div', { staticClass: 'content' }, [
                      t('span', { staticClass: 'icon' }),
                      e.coinDatas
                        ? t('span', { staticClass: 'number' }, [
                            e._v(e._s(e.coinDatas.totalCoin)),
                          ])
                        : e._e(),
                    ]),
                  ]),
                ]),
                t('div', { staticClass: 'badge' }, [
                  t(
                    'div',
                    { staticClass: 'badge-icon' },
                    e._l(e.totalBadgeList, function (n, s) {
                      return t(
                        'span',
                        {
                          key: s,
                          staticClass: 'badge-item',
                          class:
                            s + 1 <= e.level
                              ? 'level-'.concat(s + 1)
                              : 'lock-level-'.concat(s + 1),
                          style: {
                            marginRight:
                              s + 1 == e.level && 7 != e.level ? '44px' : '',
                          },
                        },
                        [s + 1 == e.level && 7 != e.level ? t('label') : e._e()]
                      )
                    }),
                    0
                  ),
                  t('span', { staticClass: 'text' }, [e._v(e._s(e.levelText))]),
                ]),
                t('div', {
                  staticClass: 'badge-close',
                  on: { click: e.closeBadgePane },
                }),
              ]),
            ])
          : e._e()
      },
      Ns = [],
      Es = {
        components: {},
        data: function () {
          return {
            level: 0,
            totalBadgeList: new Array(7),
            currentBadgeList: null,
            showCoinsBadge: false,
            coinDatas: {},
            levelList: [
              'Level 1',
              'Level 2',
              'Level 3',
              'Level 4',
              'Level 5',
              'Level 6',
              'Level 7',
            ],
          }
        },
        computed: {
          levelText: function () {
            console.info(
              '对象函数 levelText,filePath:renderer/components/Classroom/SmallClass/Live/Sidebar/SiderbarModule/CoinsBadge/index.vue'
            )
            var e = this.$t('classroom.smallClass.coins.levelNameList')
            return 0 == this.level
              ? (console.info(
                  'if(this.level == 0)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/Sidebar/SiderbarModule/CoinsBadge/index.vue'
                ),
                this.$t('classroom.smallClass.coins.levelNotice_0'))
              : 7 == this.level
              ? (console.info(
                  'if(this.level == 7)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/Sidebar/SiderbarModule/CoinsBadge/index.vue'
                ),
                this.$t('classroom.smallClass.coins.levelNotice_7'))
              : this.$t('classroom.smallClass.coins.levelNotice_other', {
                  levelName: e[this.level],
                })
          },
        },
        mounted: function () {
          var e = this
          this.currentBadgeList = new Array(this.level)
          this.$bus.$on('openBadgePane', function (t) {
            console.info(
              '箭头函数 监听 openBadgePane(coinsData)',
              t,
              'filePath:renderer/components/Classroom/SmallClass/Live/Sidebar/SiderbarModule/CoinsBadge/index.vue'
            )
            e.coinDatas = t
            e.showCoinsBadge = true
            e.level = e.coinDatas.medalNum
          })
        },
        methods: {
          closeBadgePane: function () {
            console.info(
              '对象函数 closeBadgePane,filePath:renderer/components/Classroom/SmallClass/Live/Sidebar/SiderbarModule/CoinsBadge/index.vue'
            )
            this.showCoinsBadge = false
          },
        },
        beforeDestroy: function () {
          console.info(
            '对象函数 beforeDestroy,filePath:renderer/components/Classroom/SmallClass/Live/Sidebar/SiderbarModule/CoinsBadge/index.vue'
          )
          this.$bus.$off('openBadgePane')
        },
      },
      _s = Es,
      Hs = (n('9c71'), Object(U.a)(_s, Vs, Ns, false, null, '73b138fa', null)),
      Us = Hs.exports,
      $s = function () {
        var e = this,
          t = e._self._c
        return e.showStatus
          ? t('div', { staticClass: 'container-feedback' }, [
              t('div', { staticClass: 'feedback-popup' }, [
                t('div', { staticClass: 'popup-wrapper' }, [
                  t('div', { staticClass: 'popup-header' }, [
                    t('label'),
                    t('span', [
                      e._v(
                        ' ' +
                          e._s(e.$t('classroom.modules.feedback.headerName')) +
                          ' '
                      ),
                    ]),
                  ]),
                  t(
                    'div',
                    { staticClass: 'popup-contenter' },
                    [
                      t('FeedbackOptions', {
                        on: { 'update-checked-info': e.updateCheckedInfo },
                      }),
                      t('div', { staticClass: 'feedback-textarea' }, [
                        t('textarea', {
                          directives: [
                            {
                              name: 'model',
                              rawName: 'v-model',
                              value: e.content,
                              expression: 'content',
                            },
                          ],
                          attrs: {
                            maxlength: '500',
                            placeholder: e.$t(
                              'classroom.modules.feedback.placeholder'
                            ),
                          },
                          domProps: { value: e.content },
                          on: {
                            input: function (t) {
                              t.target.composing
                                ? console.info(
                                    'if($event.target.composing)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/Sidebar/SiderbarModule/Feedback/index.vue'
                                  )
                                : (e.content = t.target.value)
                            },
                          },
                        }),
                      ]),
                      t(
                        'div',
                        {
                          staticClass: 'agree-wrapper',
                          on: { click: e.handleClickAgree },
                        },
                        [
                          t('div', { staticClass: 'agree-checkbox' }, [
                            e.agreeChecked
                              ? t('div', { staticClass: 'icon-checked' })
                              : e._e(),
                          ]),
                          e._v(
                            ' ' +
                              e._s(
                                e.$t(
                                  'classroom.modules.feedback.screenshotTips'
                                )
                              ) +
                              ' '
                          ),
                        ]
                      ),
                      t('div', { staticClass: 'button-wrapper' }, [
                        t('div', { on: { click: e.handleCancel } }, [
                          e._v(' ' + e._s(e.$t('common.cancel')) + ' '),
                        ]),
                        t('div', { on: { click: e.handleSend } }, [
                          e._v(' ' + e._s(e.$t('common.send')) + ' '),
                        ]),
                      ]),
                    ],
                    1
                  ),
                ]),
              ]),
            ])
          : e._e()
      },
      Ws = [],
      Gs =
        (n('5319'),
        function () {
          var e = this,
            t = e._self._c
          return t(
            'div',
            { staticClass: 'feedback-options' },
            e._l(e.options, function (n, s) {
              return t(
                'div',
                {
                  key: s,
                  staticClass: 'item',
                  class: { active: e.checkedCode == n.code },
                  on: {
                    click: function (t) {
                      return e.handleClickOption(n)
                    },
                  },
                },
                [
                  e.checkedCode == n.code
                    ? t('div', { staticClass: 'icon-checked' })
                    : e._e(),
                  t('div', { staticClass: 'item-name' }, [e._v(e._s(n.name))]),
                ]
              )
            }),
            0
          )
        }),
      Fs = [],
      Js = {
        data: function () {
          return {
            checkedCode: 'study-question',
            checkedName: '',
          }
        },
        computed: {
          options: function () {
            console.info(
              '对象函数 options,filePath:renderer/components/Classroom/SmallClass/Live/Sidebar/SiderbarModule/Feedback/feedbackOptions.vue'
            )
            var e = this.$t('classroom.modules.feedback.optionNames')
            return [
              {
                code: 'study-question',
                name: e[0],
              },
              {
                code: 'app-problem',
                name: e[1],
              },
              {
                code: 'inappropriate-behavior',
                name: e[2],
              },
              {
                code: 'others',
                name: e[3],
              },
            ]
          },
        },
        methods: {
          handleClickOption: function (e) {
            if (
              (console.info(
                '对象函数 handleClickOption(item)',
                e,
                'filePath:renderer/components/Classroom/SmallClass/Live/Sidebar/SiderbarModule/Feedback/feedbackOptions.vue'
              ),
              e.code == this.checkedCode)
            ) {
              return (
                console.info(
                  'if(item.code == this.checkedCode)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/Sidebar/SiderbarModule/Feedback/feedbackOptions.vue'
                ),
                (this.checkedCode = ''),
                (this.checkedName = ''),
                void this.$emit('update-checked-info', '', '')
              )
            }
            this.checkedCode = e.code
            this.checkedName = e.name
            this.$emit('update-checked-info', e.code, e.name)
          },
        },
      },
      zs = Js,
      Qs = (n('7e43'), Object(U.a)(zs, Gs, Fs, false, null, 'ef54370e', null)),
      Ks = Qs.exports,
      qs = n('e39c'),
      Xs = n('1a37'),
      Ys = n('3631'),
      Zs = {
        props: {
          options: {
            type: Object,
            default: null,
          },
          rtcConfig: {
            type: Object,
            default: null,
          },
          downlinkNetworkQuality: {
            type: Number,
            default: null,
          },
        },
        components: { FeedbackOptions: Ks },
        data: function () {
          return {
            showStatus: false,
            agreeChecked: true,
            content: '',
            checkedCode: '',
            checkedName: '',
          }
        },
        mounted: function () {
          var e = this
          this.$bus.$on('handleOpenFeedback', function (t) {
            console.info(
              '箭头函数 监听 handleOpenFeedback(flag)',
              t,
              'filePath:renderer/components/Classroom/SmallClass/Live/Sidebar/SiderbarModule/Feedback/index.vue'
            )
            t && (e.showStatus = true)
          })
        },
        methods: {
          handleShow: function () {
            console.info(
              '对象函数 handleShow,filePath:renderer/components/Classroom/SmallClass/Live/Sidebar/SiderbarModule/Feedback/index.vue'
            )
            this.showStatus = true
          },
          handleHide: function () {
            console.info(
              '对象函数 handleHide,filePath:renderer/components/Classroom/SmallClass/Live/Sidebar/SiderbarModule/Feedback/index.vue'
            )
            this.showStatus = false
          },
          handleClickAgree: function () {
            console.info(
              '对象函数 handleClickAgree,filePath:renderer/components/Classroom/SmallClass/Live/Sidebar/SiderbarModule/Feedback/index.vue'
            )
            this.agreeChecked = !this.agreeChecked
          },
          handleSend: function () {
            var e = this
            console.info(
              '对象函数 handleSend,filePath:renderer/components/Classroom/SmallClass/Live/Sidebar/SiderbarModule/Feedback/index.vue'
            )
            this.$Message.destroy()
            this.handleHide()
            var t = JSON.stringify({
              checkedName: this.checkedName,
              content: this.content.replace(/[\r\n]/g, ' '),
              agreeChecked: this.agreeChecked,
            })
            window.setTimeout(function () {
              console.info(
                '箭头函数 setTimeout,filePath:renderer/components/Classroom/SmallClass/Live/Sidebar/SiderbarModule/Feedback/index.vue'
              )
              e.$Message.info(
                e.$t('classroom.modules.feedback.sendSuccessNotice')
              )
            }, 100)
            this.agreeChecked
              ? this.uploadScreenshot(function (t) {
                  console.info(
                    '箭头函数 uploadScreenshot(screenshotUrl)',
                    t,
                    'filePath:renderer/components/Classroom/SmallClass/Live/Sidebar/SiderbarModule/Feedback/index.vue'
                  )
                  e.sendMessage(t)
                })
              : this.sendMessage()
            this.sendLogger('点击Send按钮: '.concat(t))
          },
          handleCancel: function () {
            console.info(
              '对象函数 handleCancel,filePath:renderer/components/Classroom/SmallClass/Live/Sidebar/SiderbarModule/Feedback/index.vue'
            )
            this.handleHide()
          },
          sendMessage: function (e) {
            var t = this
            return Object(y.a)(
              Object(x.a)().mark(function n() {
                var s, o, a, i, r
                return Object(x.a)().wrap(function (n) {
                  while (1) {
                    switch ((n.prev = n.next)) {
                      case 0:
                        return (
                          console.info(
                            '对象函数 sendMessage(screenshotUrl)',
                            e,
                            'filePath:renderer/components/Classroom/SmallClass/Live/Sidebar/SiderbarModule/Feedback/index.vue'
                          ),
                          (n.next = 3),
                          Object(kn.f)()
                        )
                      case 3:
                        return (
                          (s = n.sent),
                          (n.next = 6),
                          Cs.nativeApi.getDeviceInfo()
                        )
                      case 6:
                        if (
                          ((o = n.sent),
                          (a = t.content.replace(/[\r\n]/g, ' ')),
                          (i = JSON.stringify({
                            type: 150,
                            from: 'flv',
                            name: t.options.nickName,
                            msg: t.$t('classroom.modules.feedback.defaultMsg'),
                            parameter: {
                              schoolCode: s,
                              planId: t.options.planId,
                              roomId: t.options.classId,
                              studentId: t.options.stuIRCId,
                              uid: t.options.stuId,
                              teacherId: t.options.teacherInfo.id,
                              teacherName: t.options.teacherInfo.name,
                              teacherRoomId:
                                t.options.configs.rtcConfig.teacherRoomId,
                              startTime: t.options.stime,
                              currenTime: new Date().getTime(),
                              device: o.platform,
                              deviceVersion: o.osVersion,
                              AppVersion: o.appVersion,
                              question: t.checkedName,
                              question_msg: a,
                              question_url: e || '',
                            },
                          })),
                          (r =
                            window.ChatClient.PeerChatManager.sendPeerMessage(
                              [{ nickname: t.options.configs.tutorIrcId }],
                              i,
                              Ss.a.privMsg
                            )),
                          t.resetData(),
                          0 == r)
                        ) {
                          n.next = 15
                          break
                        }
                        return (
                          console.info(
                            'if(res != 0)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/Sidebar/SiderbarModule/Feedback/index.vue'
                          ),
                          t.sendLogger(
                            '发送反馈消息失败: '
                              .concat(i, ' irc消息发送返回状态: ')
                              .concat(r)
                          ),
                          n.abrupt('return')
                        )
                      case 15:
                        t.sendLogger('发送反馈消息成功: '.concat(i))
                      case 16:
                      case 'end':
                        return n.stop()
                    }
                  }
                }, n)
              })
            )()
          },
          uploadScreenshot: function (e) {
            var t = this
            return Object(y.a)(
              Object(x.a)().mark(function n() {
                var s, o, a, i
                return Object(x.a)().wrap(
                  function (n) {
                    while (1) {
                      switch ((n.prev = n.next)) {
                        case 0:
                          return (
                            console.info(
                              '对象函数 uploadScreenshot(callback)',
                              e,
                              'filePath:renderer/components/Classroom/SmallClass/Live/Sidebar/SiderbarModule/Feedback/index.vue'
                            ),
                            (n.prev = 1),
                            (n.next = 4),
                            Object(Ys.default)({
                              thumbnailWidth: 1024,
                              thumbnailQuality: 1,
                            })
                          )
                        case 4:
                          ;(s = n.sent),
                            (o = s.thumbnail),
                            (a = Object(qs.d)(o)),
                            (i = new Xs.b({ scene: 'classFeedback' })),
                            i.putFile({
                              filePath: 'classFeedback.jpg',
                              file: a,
                              progress: function (e) {},
                              success: function (n) {
                                e && e(n.url)
                                t.sendLogger('截屏上传成功:'.concat(n.url))
                              },
                              fail: function () {
                                e && e()
                                t.sendLogger('截屏上传失败', 'error')
                              },
                            }),
                            (n.next = 15)
                          break
                        case 11:
                          ;(n.prev = 11),
                            (n.t0 = n.catch(1)),
                            console.error('上传截屏失败', n.t0),
                            e && e()
                        case 15:
                        case 'end':
                          return n.stop()
                      }
                    }
                  },
                  n,
                  null,
                  [[1, 11]]
                )
              })
            )()
          },
          updateCheckedInfo: function (e, t) {
            console.info(
              '对象函数 updateCheckedInfo(code, name)',
              e,
              t,
              'filePath:renderer/components/Classroom/SmallClass/Live/Sidebar/SiderbarModule/Feedback/index.vue'
            )
            this.checkedCode = e
            this.checkedName = t
          },
          resetData: function () {
            console.info(
              '对象函数 resetData,filePath:renderer/components/Classroom/SmallClass/Live/Sidebar/SiderbarModule/Feedback/index.vue'
            )
            this.content = ''
            this.checkedCode = ''
            this.checkedName = ''
          },
          sendLogger: function (e) {
            var t =
              arguments.length > 1 && void 0 !== arguments[1]
                ? arguments[1]
                : 'info'
            q.a.send({
              tag: 'liveFeedback',
              content: { msg: e },
              level: t,
            })
          },
        },
        beforeDestroy: function () {
          console.info(
            '对象函数 beforeDestroy,filePath:renderer/components/Classroom/SmallClass/Live/Sidebar/SiderbarModule/Feedback/index.vue'
          )
          this.$bus.$off('handleOpenFeedback')
        },
      },
      eo = Zs,
      to = (n('6ed2'), Object(U.a)(eo, $s, Ws, false, null, '5f454cc6', null)),
      no = to.exports,
      so = n('c6c8'),
      oo = {
        components: {
          Assignment: Ds,
          CoinsBadge: Us,
          Feedback: no,
          ExamReport: so.a,
        },
        data: function () {
          return { showCoinsBadge: false }
        },
        computed: {
          commonOptions: function () {
            return (
              console.info(
                '对象函数 commonOptions,filePath:renderer/components/Classroom/SmallClass/Live/Sidebar/SiderbarModule/index.vue'
              ),
              this.$store.state.smallClass.baseData.commonOption
            )
          },
        },
        mounted: function () {},
        methods: {},
      },
      ao = oo,
      io = (n('ba79'), Object(U.a)(ao, Ps, Os, false, null, 'ade0919a', null)),
      ro = io.exports,
      co = function () {
        var e = this,
          t = e._self._c
        return t('div', { staticClass: 'chat-box-warp' }, [
          t(
            'div',
            {
              staticClass: 'chat-box-icon',
              class: { checked: e.chatBox.isShowBox },
              attrs: { 'data-log': 'chatbox按钮' },
              on: { click: e.handleIsShowBox },
            },
            [
              t('div', { staticClass: 'icon-img' }, [
                t('div', { staticClass: 'icon' }),
                t('div', {
                  directives: [
                    {
                      name: 'show',
                      rawName: 'v-show',
                      value: e.hasNewMsg,
                      expression: 'hasNewMsg',
                    },
                  ],
                  staticClass: 'new-tips',
                }),
              ]),
              t('div', { staticClass: 'icon-text' }, [
                e._v(e._s(e.$t('classroom.chats.chats.chatbox'))),
              ]),
            ]
          ),
        ])
      },
      lo = [],
      uo = {
        name: 'ChatBoxIcon',
        mounted: function () {
          this.$bus.$on('demonstrationStatus', this.demonstrationStatus)
        },
        beforeDestroy: function () {
          console.info(
            '对象函数 beforeDestroy,filePath:renderer/components/ChatBox/icon.vue'
          )
          this.$bus.$off('demonstrationStatus', this.demonstrationStatus)
        },
        methods: {
          handleIsShowBox: function () {
            console.info(
              '对象函数 handleIsShowBox,filePath:renderer/components/ChatBox/icon.vue'
            )
            this.$store.dispatch(
              'smallClass/updateChatboxIsShowBox',
              !this.chatBox.isShowBox
            )
          },
        },
        computed: Object(V.a)(
          {},
          Object(Se.mapGetters)({
            hasNewMsg: 'smallClass/hasNewMsg',
            chatBox: 'smallClass/chatBox',
          })
        ),
      },
      mo = uo,
      ho = (n('a1e9'), Object(U.a)(mo, co, lo, false, null, '2c15b691', null)),
      fo = ho.exports,
      po = {
        components: {
          Coins: Vt,
          Microphone: Jt,
          Settings: Tn,
          SendEmoji: ms,
          RaiseHand: Is,
          SiderbarModule: ro,
          ChatBoxIcon: fo,
        },
        data: function () {
          return {
            menuIsActive: false,
            activeType: 'setting',
          }
        },
        computed: {
          goldCoins: function () {
            return (
              console.info(
                '对象函数 goldCoins,filePath:renderer/components/Classroom/SmallClass/Live/Sidebar/index.vue'
              ),
              this.$store.state.smallClass.goldCoins
            )
          },
        },
        mounted: function () {},
        methods: {},
      },
      vo = po,
      Co = (n('0ee1'), Object(U.a)(vo, It, Pt, false, null, '74a5df31', null)),
      So = Co.exports,
      go = function () {
        var e = this,
          t = e._self._c
        return t(
          'div',
          [
            t(
              'div',
              { staticClass: 'courseware-area-wrapper-top' },
              [
                t('CountDown', {
                  ref: 'CountDown',
                  attrs: { options: e.baseData.commonOption },
                }),
                t('OrientationCoins', {
                  ref: 'OrientationCoins',
                  attrs: { options: e.baseData.commonOption },
                }),
                t('SmallClassRank', {
                  ref: 'SmallClassRank',
                  attrs: { options: e.baseData.commonOption },
                }),
                t('ContinuousCorrect', {
                  ref: 'ContinuousCorrect',
                  attrs: { options: e.baseData.commonOption },
                }),
                t('SmallClassGraffitiCorrect', {
                  attrs: {
                    width: e.courseWareBounce.width,
                    height: e.courseWareBounce.height,
                    marginLeft: e.courseWareBounce.offsetLeft,
                    options: e.baseData.commonOption,
                  },
                }),
                t('ScreenThumbnail'),
                t('TeacherOnStage', {
                  attrs: {
                    options: e.baseData.commonOption,
                    teacherUid: e.baseData.configs.rtcConfig.teacherUid,
                  },
                }),
              ],
              1
            ),
            t(
              'div',
              { staticClass: 'courseware-area-wrapper-bottom' },
              [
                t('ClassPraise', {
                  ref: 'ClassPraise',
                  attrs: { options: e.baseData.commonOption },
                }),
                t('MicrophoneAllowConfirm', { ref: 'MicrophoneAllowConfirm' }),
                t('CameraAllowConfirm', { ref: 'CameraAllowConfirm' }),
                t('TeacherDisabledMicrophoneNotice', {
                  ref: 'TeacherDisabledMicrophoneNotice',
                }),
              ],
              1
            ),
            t('LiveKickout', {
              ref: 'LiveKickout',
              attrs: { options: e.baseData.commonOption },
            }),
            t('MediaSecurityAccess', {
              ref: 'MediaSecurityAccess',
              attrs: { visible: true },
            }),
            t('DeviceTest', { ref: 'DeviceTest' }),
            t('ClassInfoDataReport', { ref: 'ClassInfoDataReport' }),
            t('NetworkError'),
          ],
          1
        )
      },
      bo = [],
      wo = n('d9de'),
      ko = n('cab4'),
      Lo = n('ac6d'),
      xo = n('5f8e'),
      yo = n('6c5d'),
      Io = n('e99b'),
      Po = n('9f80'),
      Oo = n('4a3d'),
      Ao = function () {
        var e = this,
          t = e._self._c
        return t(
          'a-modal',
          {
            attrs: {
              width: e.dialogWidth,
              maskClosable: false,
              closable: false,
              centered: true,
              title: e.$t('classroom.modules.deviceTest.dialogTitle'),
              dialogClass: 'modal-simple',
              okText: e.$t('common.confirm'),
              cancelText: e.$t('common.cancel'),
            },
            on: { ok: e.handleOk },
            model: {
              value: e.visible,
              callback: function (t) {
                e.visible = t
              },
              expression: 'visible',
            },
          },
          [
            t('div', { staticClass: 'modal-device-test' }, [
              t(
                'div',
                { staticClass: 'device-item' },
                [
                  t('div', { staticClass: 'device-head' }, [
                    t('div', { staticClass: 'title' }, [
                      t('span', { staticClass: 'color-gray' }, [
                        e._v(
                          ' ' +
                            e._s(
                              e.$t('classroom.modules.deviceTest.cameraTitle')
                            ) +
                            ' '
                        ),
                      ]),
                      e._v(' ' + e._s(e.cameraStatusInfo.text) + ' '),
                    ]),
                    t('div', {
                      staticClass: 'icon',
                      class: e.cameraStatusInfo.className,
                    }),
                  ]),
                  t(
                    'a-select',
                    {
                      style: { width: e.selectWidth },
                      attrs: {
                        value: e.defaultVideoDeviceId,
                        'default-value': e.defaultVideoDeviceId,
                        suffixIcon: e.suffixIcon,
                      },
                      on: { change: e.handleChangeVideoDevice },
                      scopedSlots: e._u([
                        {
                          key: 'suffixIcon',
                          fn: function () {
                            return [
                              t('a-icon', {
                                attrs: { component: e.arrowBottomSvg },
                              }),
                            ]
                          },
                          proxy: true,
                        },
                      ]),
                    },
                    e._l(e.videoDevices, function (n, s) {
                      return t(
                        'a-select-option',
                        {
                          key: s,
                          attrs: { value: n.deviceid },
                        },
                        [e._v(' ' + e._s(n.devicename) + ' ')]
                      )
                    }),
                    1
                  ),
                  e.isMac && false === e.cameraStatus
                    ? t('div', { staticClass: 'authorize-guide' }, [
                        e._v(
                          ' ' +
                            e._s(
                              e.$t(
                                'classroom.modules.deviceTest.authorizeGuide'
                              )[0]
                            ) +
                            ' '
                        ),
                        t('span', { on: { click: e.handleCameraAccess } }, [
                          e._v(
                            ' ' +
                              e._s(
                                e.$t(
                                  'classroom.modules.deviceTest.authorizeGuide'
                                )[1]
                              ) +
                              ' '
                          ),
                        ]),
                      ])
                    : e._e(),
                ],
                1
              ),
              t(
                'div',
                { staticClass: 'device-item' },
                [
                  t('div', { staticClass: 'device-head' }, [
                    t('div', { staticClass: 'title' }, [
                      t('span', { staticClass: 'color-gray' }, [
                        e._v(
                          ' ' +
                            e._s(
                              e.$t(
                                'classroom.modules.deviceTest.microphoneTitle'
                              )
                            ) +
                            ' '
                        ),
                      ]),
                      e._v(' ' + e._s(e.microphoneStatusInfo.text) + ' '),
                    ]),
                    t('div', {
                      staticClass: 'icon',
                      class: e.microphoneStatusInfo.className,
                    }),
                  ]),
                  t(
                    'a-select',
                    {
                      style: { width: e.selectWidth },
                      attrs: {
                        value: e.defaultAudioRecordingDeviceId,
                        'default-value': e.defaultAudioRecordingDeviceId,
                        suffixIcon: e.suffixIcon,
                      },
                      on: { change: e.handleChangeAudioRecordingDevice },
                      scopedSlots: e._u([
                        {
                          key: 'suffixIcon',
                          fn: function () {
                            return [
                              t('a-icon', {
                                attrs: { component: e.arrowBottomSvg },
                              }),
                            ]
                          },
                          proxy: true,
                        },
                      ]),
                    },
                    e._l(e.audioRecordingDevices, function (n, s) {
                      return t(
                        'a-select-option',
                        {
                          key: s,
                          attrs: { value: n.deviceid },
                        },
                        [e._v(' ' + e._s(n.devicename) + ' ')]
                      )
                    }),
                    1
                  ),
                  e.isMac && false === e.microphoneStatus
                    ? t('div', { staticClass: 'authorize-guide' }, [
                        e._v(
                          ' ' +
                            e._s(
                              e.$t(
                                'classroom.modules.deviceTest.authorizeGuide'
                              )[0]
                            ) +
                            ' '
                        ),
                        t('span', { on: { click: e.handleMicrophoneAccess } }, [
                          e._v(
                            ' ' +
                              e._s(
                                e.$t(
                                  'classroom.modules.deviceTest.authorizeGuide'
                                )[1]
                              ) +
                              ' '
                          ),
                        ]),
                      ])
                    : e._e(),
                ],
                1
              ),
              t(
                'div',
                { staticClass: 'device-item' },
                [
                  t('div', { staticClass: 'device-head' }, [
                    t('div', { staticClass: 'title' }, [
                      t('span', { staticClass: 'color-gray' }, [
                        e._v(
                          ' ' +
                            e._s(
                              e.$t('classroom.modules.deviceTest.audioTitle')
                            ) +
                            ' '
                        ),
                      ]),
                      e._v(' ' + e._s(e.audioPlaybackStatusInfo.text) + ' '),
                    ]),
                    t('div', {
                      staticClass: 'icon',
                      class: e.audioPlaybackStatusInfo.className,
                    }),
                  ]),
                  t(
                    'a-select',
                    {
                      style: { width: e.selectWidth },
                      attrs: {
                        value: e.defaultAudioPlaybackDeviceId,
                        'default-value': e.defaultAudioPlaybackDeviceId,
                        suffixIcon: e.suffixIcon,
                      },
                      on: { change: e.handleChangeAudioPlaybackDevice },
                      scopedSlots: e._u([
                        {
                          key: 'suffixIcon',
                          fn: function () {
                            return [
                              t('a-icon', {
                                attrs: { component: e.arrowBottomSvg },
                              }),
                            ]
                          },
                          proxy: true,
                        },
                      ]),
                    },
                    e._l(e.audioPlaybackDevices, function (n, s) {
                      return t(
                        'a-select-option',
                        {
                          key: s,
                          attrs: { value: n.deviceid },
                        },
                        [e._v(' ' + e._s(n.devicename) + ' ')]
                      )
                    }),
                    1
                  ),
                ],
                1
              ),
            ]),
          ]
        )
      },
      jo = [],
      Mo = n('ff07'),
      To = n.n(Mo),
      Ro = n('6543'),
      Bo = {
        data: function () {
          return {
            isMac: Object(qs.s)(),
            arrowBottomSvg: To.a,
            visible: false,
            rtcEngine: null,
            videoDevices: [],
            audioRecordingDevices: [],
            audioPlaybackDevices: [],
            defaultVideoDeviceId: '',
            defaultAudioRecordingDeviceId: '',
            defaultAudioPlaybackDeviceId: '',
            cameraStatus: null,
            microphoneStatus: null,
          }
        },
        computed: {
          dialogWidth: function () {
            return (
              console.info(
                '对象函数 dialogWidth,filePath:renderer/components/Classroom/SmallClass/Live/Modules/DeviceTest/index.vue'
              ),
              Object(qs.v)(400)
            )
          },
          selectWidth: function () {
            return (
              console.info(
                '对象函数 selectWidth,filePath:renderer/components/Classroom/SmallClass/Live/Modules/DeviceTest/index.vue'
              ),
              Object(qs.v)(340)
            )
          },
          statusNames: function () {
            return (
              console.info(
                '对象函数 statusNames,filePath:renderer/components/Classroom/SmallClass/Live/Modules/DeviceTest/index.vue'
              ),
              this.$t('classroom.modules.deviceTest.statusNames')
            )
          },
          cameraStatusInfo: function () {
            return (
              console.info(
                '对象函数 cameraStatusInfo,filePath:renderer/components/Classroom/SmallClass/Live/Modules/DeviceTest/index.vue'
              ),
              this.videoDevices.length
                ? true === this.cameraStatus
                  ? (console.info(
                      'if(this.cameraStatus === true)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/Modules/DeviceTest/index.vue'
                    ),
                    {
                      className: 'icon-success',
                      text: this.statusNames.usable,
                    })
                  : false === this.cameraStatus
                  ? (console.info(
                      'if(this.cameraStatus === false)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/Modules/DeviceTest/index.vue'
                    ),
                    {
                      className: 'icon-warn',
                      text: this.statusNames.unauthorized,
                    })
                  : (console.info(
                      'if(this.cameraStatus === false)为false,触发return,path: /renderer/components/Classroom/SmallClass/Live/Modules/DeviceTest/index.vue'
                    ),
                    {})
                : (console.info(
                    'if(!this.videoDevices.length)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/Modules/DeviceTest/index.vue'
                  ),
                  {
                    className: 'icon-error',
                    text: this.statusNames.disabled,
                  })
            )
          },
          microphoneStatusInfo: function () {
            return (
              console.info(
                '对象函数 microphoneStatusInfo,filePath:renderer/components/Classroom/SmallClass/Live/Modules/DeviceTest/index.vue'
              ),
              this.audioRecordingDevices.length
                ? true === this.microphoneStatus
                  ? (console.info(
                      'if(this.microphoneStatus === true)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/Modules/DeviceTest/index.vue'
                    ),
                    {
                      className: 'icon-success',
                      text: this.statusNames.usable,
                    })
                  : false === this.microphoneStatus
                  ? (console.info(
                      'if(this.microphoneStatus === false)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/Modules/DeviceTest/index.vue'
                    ),
                    {
                      className: 'icon-warn',
                      text: this.statusNames.unauthorized,
                    })
                  : (console.info(
                      'if(this.microphoneStatus === false)为false,触发return,path: /renderer/components/Classroom/SmallClass/Live/Modules/DeviceTest/index.vue'
                    ),
                    {})
                : (console.info(
                    'if(!this.audioRecordingDevices.length)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/Modules/DeviceTest/index.vue'
                  ),
                  {
                    className: 'icon-error',
                    text: this.statusNames.disabled,
                  })
            )
          },
          audioPlaybackStatusInfo: function () {
            return (
              console.info(
                '对象函数 audioPlaybackStatusInfo,filePath:renderer/components/Classroom/SmallClass/Live/Modules/DeviceTest/index.vue'
              ),
              this.audioPlaybackDevices.length
                ? (console.info(
                    'if(!this.audioPlaybackDevices.length)为false,触发return,path: /renderer/components/Classroom/SmallClass/Live/Modules/DeviceTest/index.vue'
                  ),
                  {
                    className: 'icon-success',
                    text: this.statusNames.usable,
                  })
                : (console.info(
                    'if(!this.audioPlaybackDevices.length)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/Modules/DeviceTest/index.vue'
                  ),
                  {
                    className: 'icon-error',
                    text: this.statusNames.disabled,
                  })
            )
          },
        },
        mounted: function () {
          var e = this
          this.$bus.$on('deviceTestShow', function () {
            console.info(
              '箭头函数 监听 deviceTestShow,filePath:renderer/components/Classroom/SmallClass/Live/Modules/DeviceTest/index.vue'
            )
            e.showModal()
          })
        },
        methods: {
          showModal: function () {
            console.info(
              '对象函数 showModal,filePath:renderer/components/Classroom/SmallClass/Live/Modules/DeviceTest/index.vue'
            )
            this.visible = true
            this.rtcEngine = this.thinkClass.RtcService.rtcEngine
            this.getDevices()
            this.getDefaultDevices()
            this.getMediaAccess()
          },
          hideModal: function () {
            console.info(
              '对象函数 hideModal,filePath:renderer/components/Classroom/SmallClass/Live/Modules/DeviceTest/index.vue'
            )
            this.visible = false
          },
          handleOk: function () {
            var e = this
            return Object(y.a)(
              Object(x.a)().mark(function t() {
                return Object(x.a)().wrap(function (t) {
                  while (1) {
                    switch ((t.prev = t.next)) {
                      case 0:
                        return (
                          console.info(
                            '对象函数 handleOk,filePath:renderer/components/Classroom/SmallClass/Live/Modules/DeviceTest/index.vue'
                          ),
                          (t.next = 3),
                          Object(Ro.e)(e.defaultVideoDeviceId)
                        )
                      case 3:
                        return (
                          (t.next = 5),
                          Object(Ro.d)(e.defaultAudioRecordingDeviceId)
                        )
                      case 5:
                        return (
                          (t.next = 7),
                          Object(Ro.c)(e.defaultAudioPlaybackDeviceId)
                        )
                      case 7:
                        e.rtcEngine.setVideoDevice(e.defaultVideoDeviceId),
                          e.rtcEngine.setAudioRecordingDevice(
                            e.defaultAudioRecordingDeviceId
                          ),
                          e.rtcEngine.setAudioPlaybackDevice(
                            e.defaultAudioPlaybackDeviceId
                          ),
                          e.sendLogger(
                            '设置默认设备, 摄像头: '
                              .concat(e.defaultVideoDeviceId, ', 麦克风: ')
                              .concat(
                                e.defaultAudioRecordingDeviceId,
                                ', 扬声器: '
                              )
                              .concat(e.defaultAudioPlaybackDeviceId)
                          ),
                          e.hideModal()
                      case 12:
                      case 'end':
                        return t.stop()
                    }
                  }
                }, t)
              })
            )()
          },
          handleChangeVideoDevice: function (e) {
            console.info(
              '对象函数 handleChangeVideoDevice(val)',
              e,
              'filePath:renderer/components/Classroom/SmallClass/Live/Modules/DeviceTest/index.vue'
            )
            this.defaultVideoDeviceId = e
          },
          handleChangeAudioRecordingDevice: function (e) {
            console.info(
              '对象函数 handleChangeAudioRecordingDevice(val)',
              e,
              'filePath:renderer/components/Classroom/SmallClass/Live/Modules/DeviceTest/index.vue'
            )
            this.defaultAudioRecordingDeviceId = e
          },
          handleChangeAudioPlaybackDevice: function (e) {
            console.info(
              '对象函数 handleChangeAudioPlaybackDevice(val)',
              e,
              'filePath:renderer/components/Classroom/SmallClass/Live/Modules/DeviceTest/index.vue'
            )
            this.defaultAudioPlaybackDeviceId = e
          },
          getDevices: function () {
            console.info(
              '对象函数 getDevices,filePath:renderer/components/Classroom/SmallClass/Live/Modules/DeviceTest/index.vue'
            )
            var e = this.rtcEngine.getVideoDevices(),
              t = this.rtcEngine.getAudioRecordingDevices(),
              n = this.rtcEngine.getAudioPlaybackDevices()
            this.videoDevices = e
            this.audioRecordingDevices = t
            this.audioPlaybackDevices = n
            this.sendLogger(
              '查询设备列表, 摄像头: '
                .concat(JSON.stringify(e), ', 麦克风: ')
                .concat(JSON.stringify(t), ', 扬声器: ')
                .concat(JSON.stringify(n))
            )
          },
          getDefaultDevices: function () {
            console.info(
              '对象函数 getDefaultDevices,filePath:renderer/components/Classroom/SmallClass/Live/Modules/DeviceTest/index.vue'
            )
            var e = this.rtcEngine.getCurrentVideoDevice(),
              t = this.rtcEngine.getCurrentAudioRecordingDevice(),
              n = this.rtcEngine.getCurrentAudioPlaybackDevice()
            this.defaultVideoDeviceId = e
            this.defaultAudioRecordingDeviceId = t
            this.defaultAudioPlaybackDeviceId = n
            this.sendLogger(
              '查询当前默认使用设备, 摄像头: '
                .concat(e, ', 麦克风: ')
                .concat(t, ', 扬声器: ')
                .concat(n)
            )
          },
          getMediaAccess: function () {
            var e = this
            return Object(y.a)(
              Object(x.a)().mark(function t() {
                return Object(x.a)().wrap(function (t) {
                  while (1) {
                    switch ((t.prev = t.next)) {
                      case 0:
                        return (
                          console.info(
                            '对象函数 getMediaAccess,filePath:renderer/components/Classroom/SmallClass/Live/Modules/DeviceTest/index.vue'
                          ),
                          (t.next = 3),
                          Object(Q.c)()
                        )
                      case 3:
                        return (
                          (e.cameraStatus = t.sent), (t.next = 6), Object(Q.f)()
                        )
                      case 6:
                        e.microphoneStatus = t.sent
                      case 7:
                      case 'end':
                        return t.stop()
                    }
                  }
                }, t)
              })
            )()
          },
          handleCameraAccess: function () {
            console.info(
              '对象函数 handleCameraAccess,filePath:renderer/components/Classroom/SmallClass/Live/Modules/DeviceTest/index.vue'
            )
            Cs.nativeApi.openPreferences('security', 'camera')
          },
          handleMicrophoneAccess: function () {
            console.info(
              '对象函数 handleMicrophoneAccess,filePath:renderer/components/Classroom/SmallClass/Live/Modules/DeviceTest/index.vue'
            )
            Cs.nativeApi.openPreferences('security', 'microphone')
          },
          sendLogger: function (e) {
            q.a.send({
              tag: 'deviceTest',
              content: { msg: e },
            })
          },
        },
      },
      Do = Bo,
      Vo = (n('a7cb'), Object(U.a)(Do, Ao, jo, false, null, 'dbe08956', null)),
      No = Vo.exports,
      Eo = function () {
        var e = this,
          t = e._self._c
        return t('div', {
          staticClass: 'network-error-wrapper',
          attrs: { id: 'networkError' },
        })
      },
      _o = [],
      Ho = {
        data: function () {
          return { isShow: false }
        },
        mounted: function () {
          this.thinkClass.SignalService.on('showNotification', this.showNotice)
          this.thinkClass.SignalService.on(
            'closeNotification',
            this.closeNotice
          )
        },
        beforeDestroy: function () {
          console.info(
            '对象函数 beforeDestroy,filePath:renderer/components/Classroom/SmallClass/Live/Modules/NetworkError/index.vue'
          )
          this.thinkClass.SignalService.off('showNotification', this.showNotice)
          this.thinkClass.SignalService.off(
            'closeNotification',
            this.closeNotice
          )
        },
        methods: {
          showNotice: function (e) {
            var t = this
            console.info(
              '对象函数 showNotice(code)',
              e,
              'filePath:renderer/components/Classroom/SmallClass/Live/Modules/NetworkError/index.vue'
            )
            var n = this.$createElement
            if (this.isShow) {
              console.info(
                'if(this.isShow)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/Modules/NetworkError/index.vue'
              )
            } else {
              var s = this.$t('classroom.modules.networkError')
              this.isShow = true
              this.$Notification.open({
                key: 'networkError',
                class: 'notification-network-error',
                placement: 'bottomRight',
                bottom: '0px',
                duration: null,
                description: function () {
                  return n('div', [
                    n('i', { class: 'netError' }),
                    n('div', { class: 'description' }, [
                      s.notice[0],
                      ' ',
                      n('br'),
                      ' ',
                      ''.concat(s.notice[1], ',code:').concat(e),
                    ]),
                  ])
                },
                btn: function () {
                  return n(
                    'a-button',
                    {
                      class: 'ant-btn-primary',
                      attrs: { shape: 'round' },
                    },
                    [t.$t('common.exit')]
                  )
                },
                getContainer: function () {
                  return document.getElementById('networkError')
                },
                onClick: function () {
                  t.sendLogger('click NetworkError')
                  window.location.href = '/#/courses'
                },
              })
            }
          },
          closeNotice: function () {
            console.info(
              '对象函数 closeNotice,filePath:renderer/components/Classroom/SmallClass/Live/Modules/NetworkError/index.vue'
            )
            this.isShow = false
            this.$Notification.destroy()
          },
          sendLogger: function (e) {
            q.a.send({
              tag: 'Net',
              content: { msg: e },
            })
          },
        },
      },
      Uo = Ho,
      $o = (n('2a77'), Object(U.a)(Uo, Eo, _o, false, null, null, null)),
      Wo = $o.exports,
      Go = {
        data: function () {
          var e = this.$store.state.smallClass.baseData,
            t = this.$store.state.smallClass.initModule
          return {
            baseData: e,
            durationTimestamp: new Date().getTime(),
            durationModuleInfo: t['11'] || null,
            timer: null,
            kejianStatus: 1,
            ircCodeCount: {
              0: 0,
              1: 0,
              2: 0,
              3: 0,
              4: 0,
              5: 0,
            },
            ircCurrentCode: 0,
            rtcRoundTripDelayed: 0,
            rtcDownlinkPacketLossRate: 0,
          }
        },
        mounted: function () {
          this.initEventListeners()
          this.delayDurationPush()
        },
        methods: {
          initEventListeners: function () {
            var e = this
            console.info(
              '对象函数 initEventListeners,filePath:renderer/components/Classroom/SmallClass/Live/Modules/ClassInfoDataReport/index.vue'
            )
            this.$bus.$on('corewareLoadStatus', function (t) {
              console.info(
                '箭头函数 监听 corewareLoadStatus(data)',
                t,
                'filePath:renderer/components/Classroom/SmallClass/Live/Modules/ClassInfoDataReport/index.vue'
              )
              e.kejianStatus = t.isLocal ? 1 : 2
            })
            this.thinkClass.SignalService.on(
              'onNetStatusChanged',
              function (t) {
                var n = t.netStatus
                e.ircCodeCount[n] = e.ircCodeCount[n] + 1
                e.ircCurrentCode = n
              }
            )
            this.thinkClass.RtcService.on('rtcStats', function (t) {
              e.rtcRoundTripDelayed = t.gatewayRtt
              e.rtcDownlinkPacketLossRate = t.rxPacketLossRate
            })
          },
          durationPush: function () {
            var e = this
            return Object(y.a)(
              Object(x.a)().mark(function t() {
                var n, s, o, a
                return Object(x.a)().wrap(
                  function (t) {
                    while (1) {
                      switch ((t.prev = t.next)) {
                        case 0:
                          return (
                            (n = String(e.baseData.planInfo.id)),
                            (s = 60000),
                            (o = 60),
                            (e.durationTimestamp = new Date().getTime()),
                            (a = e.$store.state.smallClass.cameraStatus
                              ? 1
                              : 2),
                            (t.prev = 5),
                            (t.next = 8),
                            Object(K.c)({
                              planId: n,
                              duration: o,
                              isParentAudition: e.baseData.commonOption.isParent
                                ? 1
                                : 0,
                              kejianStatus: e.kejianStatus,
                              ircCodeCount: e.ircCodeCount,
                              ircCurrentCode: e.ircCurrentCode,
                              rtcRoundTripDelayed: e.rtcRoundTripDelayed,
                              rtcDownlinkPacketLossRate:
                                e.rtcDownlinkPacketLossRate,
                              cameraState: a,
                            })
                          )
                        case 8:
                          t.next = 13
                          break
                        case 10:
                          ;(t.prev = 10),
                            (t.t0 = t.catch(5)),
                            console.error('上报学生在线时长接口报错', t.t0)
                        case 13:
                          e.delayDurationPush(s)
                        case 14:
                        case 'end':
                          return t.stop()
                      }
                    }
                  },
                  t,
                  null,
                  [[5, 10]]
                )
              })
            )()
          },
          delayDurationPush: function (e) {
            var t = this
            this.resetPrevMinuteReportData()
            this.timer && clearTimeout(this.timer)
            this.timer = setTimeout(function () {
              t.durationPush()
            }, e)
          },
          resetPrevMinuteReportData: function () {
            console.info(
              '对象函数 resetPrevMinuteReportData,filePath:renderer/components/Classroom/SmallClass/Live/Modules/ClassInfoDataReport/index.vue'
            )
            this.ircCodeCount = {
              0: 0,
              1: 0,
              2: 0,
              3: 0,
              4: 0,
              5: 0,
            }
            this.kejianStatus = 1
            this.rtcRoundTripDelayed = 0
            this.rtcDownlinkPacketLossRate = 0
            this.ircCurrentCode = 0
          },
        },
      },
      Fo = Go,
      Jo = Object(U.a)(Fo, a, i, false, null, null, null),
      zo = Jo.exports,
      Qo = n('2be6'),
      Ko = function () {
        var e = this,
          t = e._self._c
        return t('div', { staticClass: 'microphone-allow-confirm' })
      },
      qo = [],
      Xo = {
        name: 'MicrophoneAllowConfirm',
        watch: {
          '$store.state.smallClass.microphoneStatus': {
            handler: function (e) {
              console.info(
                '对象函数 handler(val)',
                e,
                'filePath:renderer/components/Classroom/SmallClass/Live/Modules/MicrophoneAllowConfirm/index.vue'
              )
              e && this.closeDialog()
            },
          },
        },
        mounted: function () {
          var e = this
          this.$bus.$on('showMicrophoneAllowConfirm', function () {
            console.info(
              '箭头函数 监听 showMicrophoneAllowConfirm,filePath:renderer/components/Classroom/SmallClass/Live/Modules/MicrophoneAllowConfirm/index.vue'
            )
            e.handleOk()
          })
        },
        methods: {
          handleOk: function () {
            console.info(
              '对象函数 handleOk,filePath:renderer/components/Classroom/SmallClass/Live/Modules/MicrophoneAllowConfirm/index.vue'
            )
            this.$bus.$emit('openMicrophone', true)
            this.closeDialog()
            this.sendLogger('学生同意打开麦克风')
          },
          closeDialog: function () {
            var e = this
            console.info(
              '对象函数 closeDialog,filePath:renderer/components/Classroom/SmallClass/Live/Modules/MicrophoneAllowConfirm/index.vue'
            )
            setTimeout(function () {
              e.$bus.$emit('closeMicrophoneAllowConfirm')
            }, 0)
          },
          sendLogger: function (e) {
            q.a.send({
              tag: 'audioMute',
              content: { msg: e },
            })
          },
        },
      },
      Yo = Xo,
      Zo = (n('2ae6'), Object(U.a)(Yo, Ko, qo, false, null, '142ee6fb', null)),
      ea = Zo.exports,
      ta = function () {
        var e = this,
          t = e._self._c
        return t(
          'div',
          { staticClass: 'camera-allow-confirm' },
          [
            t(
              'AllowAccessDialog',
              {
                attrs: {
                  isAllOnStage: e.isAllOnStage,
                  theme: 'orange',
                },
                on: {
                  ok: e.handleOk,
                  cancel: e.handleCancel,
                },
                model: {
                  value: e.visible,
                  callback: function (t) {
                    e.visible = t
                  },
                  expression: 'visible',
                },
              },
              [
                t('div', { staticClass: 'content' }, [
                  t('div', { staticClass: 'icon-camera' }),
                  t('div', { staticClass: 'notice' }, [
                    e._v(
                      ' ' +
                        e._s(
                          e.$t('classroom.smallClass.cameraAllowConfirm.notice')
                        ) +
                        ' '
                    ),
                  ]),
                ]),
              ]
            ),
          ],
          1
        )
      },
      na = [],
      sa = function () {
        var e = this,
          t = e._self._c
        return e.sVisible
          ? t(
              'div',
              {
                staticClass: 'dialog-wrapper',
                class: [e.dialogClass, e.allOnStageClass],
              },
              [
                t(
                  'div',
                  { staticClass: 'dialog-content' },
                  [e._t('default')],
                  2
                ),
                e.showOkButton || e.showCancelButton
                  ? t('div', { staticClass: 'dialog-footer' }, [
                      e.showCancelButton
                        ? t(
                            'div',
                            {
                              staticClass: 'dialog-button button-cancel',
                              on: { click: e.handleCancel },
                            },
                            [
                              e._v(
                                ' ' +
                                  e._s(e.cancelValue || e.$t('common.deny')) +
                                  ' '
                              ),
                            ]
                          )
                        : e._e(),
                      e.showOkButton
                        ? t(
                            'div',
                            {
                              staticClass: 'dialog-button button-ok',
                              on: { click: e.handleOk },
                            },
                            [
                              e._v(
                                ' ' +
                                  e._s(e.okValue || e.$t('common.agree')) +
                                  ' '
                              ),
                            ]
                          )
                        : e._e(),
                    ])
                  : e._e(),
              ]
            )
          : e._e()
      },
      oa = [],
      aa = {
        name: 'AllowAccessDialog',
        model: { prop: 'visible' },
        data: function () {
          return { sVisible: !!this.visible }
        },
        props: {
          dialogClass: {
            type: String,
            default: '',
          },
          theme: {
            type: String,
            default: 'green',
          },
          visible: {
            type: Boolean,
            default: false,
          },
          okValue: {
            type: String,
            default: '',
          },
          cancelValue: {
            type: String,
            default: '',
          },
          showOkButton: {
            type: Boolean,
            default: true,
          },
          showCancelButton: {
            type: Boolean,
            default: true,
          },
          isAllOnStage: {
            type: Boolean,
            default: false,
          },
        },
        watch: {
          visible: function (e) {
            this.sVisible = e
          },
        },
        computed: {
          allOnStageClass: function () {
            return (
              console.info(
                '对象函数 allOnStageClass,filePath:renderer/components/Classroom/SmallClass/Common/AllowAccessDialog/index.vue'
              ),
              this.isAllOnStage ? 'all-on-stage-wrapper' : ''
            )
          },
        },
        mounted: function () {},
        methods: {
          handleCancel: function (e) {
            this.$emit('cancel', e)
          },
          handleOk: function (e) {
            this.$emit('ok', e)
          },
        },
      },
      ia = aa,
      ra = (n('ec0d'), Object(U.a)(ia, sa, oa, false, null, 'ce1c3158', null)),
      ca = ra.exports,
      la = {
        name: 'CameraAllowConfirm',
        components: { AllowAccessDialog: ca },
        data: function () {
          return {
            visible: false,
            timer: null,
            duration: 10000,
          }
        },
        props: {
          isAllOnStage: {
            type: Boolean,
            default: false,
          },
        },
        watch: {
          '$store.state.smallClass.cameraStatus': {
            handler: function (e) {
              console.info(
                '对象函数 handler(val)',
                e,
                'filePath:renderer/components/Classroom/SmallClass/Live/Modules/CameraAllowConfirm/index.vue'
              )
              e && this.closeDialog()
            },
          },
        },
        mounted: function () {
          this.$bus.$on('showCameraAllowConfirm', this.autoClose)
        },
        methods: {
          handleOk: function () {
            console.info(
              '对象函数 handleOk,filePath:renderer/components/Classroom/SmallClass/Live/Modules/CameraAllowConfirm/index.vue'
            )
            this.$bus.$emit('openCamera', true)
            this.closeDialog()
            this.sendLogger('学生同意打开摄像头')
          },
          handleCancel: function () {
            console.info(
              '对象函数 handleCancel,filePath:renderer/components/Classroom/SmallClass/Live/Modules/CameraAllowConfirm/index.vue'
            )
            this.closeDialog()
            this.sendLogger('学生拒绝打开摄像头')
          },
          closeDialog: function () {
            console.info(
              '对象函数 closeDialog,filePath:renderer/components/Classroom/SmallClass/Live/Modules/CameraAllowConfirm/index.vue'
            )
            this.visible = false
            this.timer && clearTimeout(this.timer)
          },
          autoClose: function () {
            var e = this
            console.info(
              '对象函数 autoClose,filePath:renderer/components/Classroom/SmallClass/Live/Modules/CameraAllowConfirm/index.vue'
            )
            this.visible = true
            this.timer && clearTimeout(this.timer)
            this.timer = setTimeout(function () {
              e.closeDialog()
              e.sendLogger('授权打开摄像头提示自动关闭')
            }, this.duration)
          },
          sendLogger: function (e) {
            q.a.send({
              tag: 'cameraStatus',
              content: { msg: e },
            })
          },
        },
        beforeDestroy: function () {
          console.info(
            '对象函数 beforeDestroy,filePath:renderer/components/Classroom/SmallClass/Live/Modules/CameraAllowConfirm/index.vue'
          )
          this.$bus.$off('showCameraAllowConfirm', this.autoClose)
        },
      },
      da = la,
      ua = (n('f58c'), Object(U.a)(da, ta, na, false, null, 'fb86c2ec', null)),
      ma = ua.exports,
      ha = function () {
        var e = this,
          t = e._self._c
        return t(
          'div',
          { staticClass: 'microphone-disabled-notice' },
          [
            t(
              'AllowAccessDialog',
              {
                attrs: {
                  isAllOnStage: e.isAllOnStage,
                  showCancelButton: false,
                  okValue: e.$t('common.gotIt'),
                },
                on: {
                  ok: e.handleOk,
                  cancel: e.handleCancel,
                },
                model: {
                  value: e.visible,
                  callback: function (t) {
                    e.visible = t
                  },
                  expression: 'visible',
                },
              },
              [
                t('div', { staticClass: 'content' }, [
                  t('div', {
                    class: [
                      'on' == e.showOnOrOff
                        ? 'icon-microphone'
                        : 'icon-off-microphone',
                    ],
                  }),
                  t('div', { staticClass: 'notice' }, [
                    e._v(
                      ' ' +
                        e._s(
                          'on' == e.showOnOrOff
                            ? e.$t(
                                'classroom.smallClass.teacherDisabledOnMicrophone.notice'
                              )
                            : e.$t(
                                'classroom.smallClass.teacherDisabledOffMicrophone.notice'
                              )
                        ) +
                        ' '
                    ),
                  ]),
                ]),
              ]
            ),
          ],
          1
        )
      },
      fa = [],
      pa = {
        name: 'TeacherDisabledMicrophoneNotice',
        components: { AllowAccessDialog: ca },
        data: function () {
          return {
            visible: false,
            timer: null,
            duration: 5000,
            showOnOrOff: 'on',
          }
        },
        props: {
          isAllOnStage: {
            type: Boolean,
            default: false,
          },
        },
        mounted: function () {
          this.$bus.$on('showTeacherDisabledMicrophoneNotice', this.autoClose)
        },
        methods: {
          handleOk: function () {
            console.info(
              '对象函数 handleOk,filePath:renderer/components/Classroom/SmallClass/Live/Modules/TeacherDisabledMicrophoneNotice/index.vue'
            )
            this.closeDialog()
          },
          handleCancel: function () {
            console.info(
              '对象函数 handleCancel,filePath:renderer/components/Classroom/SmallClass/Live/Modules/TeacherDisabledMicrophoneNotice/index.vue'
            )
            this.closeDialog()
          },
          closeDialog: function () {
            console.info(
              '对象函数 closeDialog,filePath:renderer/components/Classroom/SmallClass/Live/Modules/TeacherDisabledMicrophoneNotice/index.vue'
            )
            this.visible = false
            this.timer && clearTimeout(this.timer)
          },
          autoClose: function (e) {
            var t = this
            console.info(
              '对象函数 autoClose(type)',
              e,
              'filePath:renderer/components/Classroom/SmallClass/Live/Modules/TeacherDisabledMicrophoneNotice/index.vue'
            )
            this.visible = true
            this.showOnOrOff = e
            this.timer && clearTimeout(this.timer)
            this.timer = setTimeout(function () {
              t.closeDialog()
            }, this.duration)
          },
        },
        beforeDestroy: function () {
          console.info(
            '对象函数 beforeDestroy,filePath:renderer/components/Classroom/SmallClass/Live/Modules/TeacherDisabledMicrophoneNotice/index.vue'
          )
          this.$bus.$off('showTeacherDisabledMicrophoneNotice', this.autoClose)
        },
      },
      va = pa,
      Ca = (n('fe8e'), Object(U.a)(va, ha, fa, false, null, '0649029d', null)),
      Sa = Ca.exports,
      ga = {
        components: {
          CountDown: wo.a,
          OrientationCoins: ko.a,
          ContinuousCorrect: Lo.a,
          ClassPraise: yo.a,
          SmallClassRank: Io.a,
          LiveKickout: Po.a,
          TeacherOnStage: Oo.a,
          MediaSecurityAccess: _t.a,
          DeviceTest: No,
          ClassInfoDataReport: zo,
          SmallClassGraffitiCorrect: xo.a,
          ScreenThumbnail: Qo.a,
          MicrophoneAllowConfirm: ea,
          CameraAllowConfirm: ma,
          TeacherDisabledMicrophoneNotice: Sa,
          NetworkError: Wo,
        },
        data: function () {
          return {
            baseData: this.$store.state.smallClass.baseData,
            commonData: this.$store.state.smallClass,
            currentPrivateStudent: null,
          }
        },
        computed: {
          courseWareBounce: function () {
            return (
              console.info(
                '对象函数 courseWareBounce,filePath:renderer/components/Classroom/SmallClass/Live/Modules/index.vue'
              ),
              this.$store.state.smallClass.coursesPosition
            )
          },
        },
        mounted: function () {
          this.listenerSignalService()
          this.$store.state.smallClass.baseData
        },
        methods: {
          listenerSignalService: function () {
            var e = this
            console.info(
              '对象函数 listenerSignalService,filePath:renderer/components/Classroom/SmallClass/Live/Modules/index.vue'
            )
            var t = this.commonData,
              n = this.currentPrivateStudent
            this.thinkClass.SignalService.on(
              'onRecvRoomDataUpdateNotice',
              function (s) {
                var o = s.key,
                  a = s.noticeContent
                return 'countDown' === o
                  ? (console.info(
                      "if(key === 'countDown')为true触发return,path: /renderer/components/Classroom/SmallClass/Live/Modules/index.vue"
                    ),
                    void e.$bus.$emit('room.countDown', a))
                  : 'classroom_praise' === o
                  ? (console.info(
                      "if(key === 'classroom_praise')为true触发return,path: /renderer/components/Classroom/SmallClass/Live/Modules/index.vue"
                    ),
                    void (a.pub && e.$bus.$emit('room.showPraiseTreasure', a)))
                  : 'distribute_coins' === o
                  ? (console.info(
                      "if(key === 'distribute_coins')为true触发return,path: /renderer/components/Classroom/SmallClass/Live/Modules/index.vue"
                    ),
                    void (a.pub && e.$bus.$emit('room.orientationCoins', a)))
                  : 'student_rank' === o
                  ? (console.info(
                      "if(key === 'student_rank')为true触发return,path: /renderer/components/Classroom/SmallClass/Live/Modules/index.vue"
                    ),
                    void e.$bus.$emit('room.smallClassRank', a))
                  : ('teacher_video_mic' === o &&
                      e.$bus.$emit('teacherOnStage', a),
                    'graffiti_board_video' === o &&
                      ((null === a || void 0 === a ? void 0 : a.userId) !=
                      t.baseData.stuInfo.id
                        ? e.$bus.$emit('teacherOnPrivateChat', a)
                        : ((a.teacherName = t.baseData.teacherInfo.name),
                          (a.status = 1),
                          (a.privateChat = true),
                          a.pub &&
                            !t.microphoneStatus &&
                            n != a.userId &&
                            e.$bus.$emit('showMicrophoneAllowConfirm'),
                          e.$bus.$emit('teacherOnStage', a)),
                      q.a.send({
                        tag: 'userTrack',
                        content: {
                          msg: a.pub ? '视频私聊开始' : '视频私聊结束',
                          uid: a.userId,
                        },
                      }),
                      (n = a.pub ? a.userId : null),
                      e.$bus.$emit('changeAudioStatus', a)),
                    void (
                      'forbidden_student_emoji' === o &&
                      e.$bus.$emit('forbidden_student_emoji', a)
                    ))
              }
            )
          },
        },
      },
      ba = ga,
      wa = (n('957b'), Object(U.a)(ba, go, bo, false, null, '2e90d44c', null)),
      ka = wa.exports,
      La = {
        redPacket: function () {
          return n.e('chunk-5125c77c').then(n.bind(null, '9571'))
        },
        openGift: function () {
          return n.e('chunk-3d75fc56').then(n.bind(null, '91ff'))
        },
        vote: function () {
          return n.e('chunk-16c075d8').then(n.bind(null, '1505a'))
        },
        nonpreset_fill_blank: function () {
          return n.e('chunk-1c3482b2').then(n.bind(null, 'd422'))
        },
        classRest: function () {
          return n.e('chunk-09d4164c').then(n.bind(null, 'c913'))
        },
        mult_video_mic: function () {
          return n.e('chunk-0935393e').then(n.bind(null, '269fb'))
        },
        interact: function () {
          return n.e('chunk-14a97d99').then(n.bind(null, '85f5'))
        },
        game_interact: function () {
          return n.e('chunk-2e9cf93e').then(n.bind(null, 'a611'))
        },
        take_picture: function () {
          return n.e('chunk-9c37b028').then(n.bind(null, '1385'))
        },
        fill_blank: function () {
          return n.e('chunk-6fa24106').then(n.bind(null, 'a692'))
        },
        small_random_call: function () {
          return Promise.all([
            n.e('chunk-9c43f55c'),
            n.e('chunk-0c3f1dd4'),
          ]).then(n.bind(null, '6e9a7'))
        },
        graffiti_board: function () {
          return n.e('chunk-2ec16a41').then(n.bind(null, '9973'))
        },
        speedyHand: function () {
          return n.e('chunk-f823038e').then(n.bind(null, '3aa6'))
        },
        class_praise_list: function () {
          return n.e('chunk-271490e8').then(n.bind(null, 'b6e5'))
        },
        schulte_table: function () {
          return n.e('chunk-0b480b94').then(n.bind(null, '4143'))
        },
      },
      xa = n('6ce8'),
      ya = {
        components: {},
        data: function () {
          return {
            baseData: this.$store.state.smallClass.baseData,
            interactionList: La,
            submit: false,
            tutorVideoLinkStatus: false,
            interactionMap: new Map(),
            speedyHandInstance: null,
            speedHandTimer: null,
          }
        },
        mounted: function () {
          var e = this
          this.$nextTick(function () {
            e.listenerSignalService()
          })
        },
        methods: {
          sendLogger: function (e, t) {
            q.a.send({
              tag: 'student.Interact',
              level: t,
              content: { msg: e },
            })
          },
          listenerSignalService: function () {
            var e = this
            console.info(
              '对象函数 listenerSignalService,filePath:renderer/components/Classroom/SmallClass/Live/Interactions/index.vue'
            )
            this.thinkClass.SignalService.on(
              'onRecvRoomDataUpdateNotice',
              (function () {
                var t = Object(y.a)(
                  Object(x.a)().mark(function t(n) {
                    var s,
                      o,
                      a,
                      i,
                      r,
                      c,
                      l,
                      d,
                      u,
                      m,
                      h,
                      f,
                      p,
                      v,
                      C,
                      S,
                      g,
                      b,
                      w,
                      k,
                      L,
                      y,
                      I,
                      P,
                      O,
                      A,
                      j,
                      M,
                      T,
                      R,
                      B,
                      D,
                      V,
                      N,
                      E
                    return Object(x.a)().wrap(function (t) {
                      while (1) {
                        switch ((t.prev = t.next)) {
                          case 0:
                            if (
                              ((o = n.key),
                              (a = n.isHistory),
                              (i = n.noticeContent),
                              (r = n.sendTime),
                              e.interactionMap,
                              (c = e.interactionMap.get(o)),
                              null === c ||
                                void 0 === c ||
                                null === (s = c.ircMsg) ||
                                void 0 === s ||
                                s.sendTime,
                              !c || r !== c.ircMsg.sendTime)
                            ) {
                              t.next = 10
                              break
                            }
                            return (
                              console.info(
                                'if(keyContent && sendTime === keyContent.ircMsg.sendTime)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/Interactions/index.vue'
                              ),
                              e.interactionMap,
                              e.sendLogger(
                                '收到和已存在互动相同的消息',
                                'error'
                              ),
                              t.abrupt('return')
                            )
                          case 10:
                            if (
                              !e.tutorVideoLinkStatus ||
                              ('take_picture' !== o && 'random_video_mic' !== o)
                            ) {
                              t.next = 13
                              break
                            }
                            return (
                              console.info(
                                "if(_this2.tutorVideoLinkStatus && (key === 'take_picture' || key === 'random_video_mic'))为true触发return,path: /renderer/components/Classroom/SmallClass/Live/Interactions/index.vue"
                              ),
                              t.abrupt('return')
                            )
                          case 13:
                            if ('sendGiftBarrage' !== o) {
                              t.next = 18
                              break
                            }
                            return (
                              console.info(
                                "if(key === 'sendGiftBarrage')为true触发return,path: /renderer/components/Classroom/SmallClass/Live/Interactions/index.vue"
                              ),
                              (d =
                                null ===
                                  (l = e.interactionMap.get('openGift')) ||
                                void 0 === l
                                  ? void 0
                                  : l.instance),
                              d && d.vm.receiveGiftBarrage(i),
                              t.abrupt('return')
                            )
                          case 18:
                            if ('vote_data' !== o) {
                              t.next = 23
                              break
                            }
                            return (
                              console.info(
                                "if(key === 'vote_data')为true触发return,path: /renderer/components/Classroom/SmallClass/Live/Interactions/index.vue"
                              ),
                              (m =
                                null === (u = e.interactionMap.get('vote')) ||
                                void 0 === u
                                  ? void 0
                                  : u.instance),
                              m && m.vm.getVoteStatistics(i),
                              t.abrupt('return')
                            )
                          case 23:
                            if ('video_mic' !== o) {
                              t.next = 30
                              break
                            }
                            if (
                              ((f =
                                null ===
                                  (h = e.interactionMap.get('video_mic')) ||
                                void 0 === h
                                  ? void 0
                                  : h.instance),
                              !f)
                            ) {
                              t.next = 30
                              break
                            }
                            return (
                              console.info(
                                'if(_interaction2)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/Interactions/index.vue'
                              ),
                              f.vm.videoLinkMessage(i),
                              i.open || e.destroy(o),
                              t.abrupt('return')
                            )
                          case 30:
                            if (
                              ('small_random_call' === o &&
                                0 === i.pub &&
                                'wall' === i.type &&
                                i.recoverVideo &&
                                e.$bus.$emit('wallRandomCall', { pub: false }),
                              'video_mic_f' !== o)
                            ) {
                              t.next = 35
                              break
                            }
                            return (
                              console.info(
                                "if(key === 'video_mic_f')为true触发return,path: /renderer/components/Classroom/SmallClass/Live/Interactions/index.vue"
                              ),
                              e.$bus.$emit(
                                'room.tutorVideoLink',
                                i,
                                function (t) {
                                  var n = t.status
                                  console.info(
                                    '箭头函数 监听 room.tutorVideoLink(status)',
                                    n,
                                    'filePath:renderer/components/Classroom/SmallClass/Live/Interactions/index.vue'
                                  )
                                  e.tutorVideoLinkStatus = n
                                }
                              ),
                              t.abrupt('return')
                            )
                          case 35:
                            if ('praise' !== o) {
                              t.next = 38
                              break
                            }
                            return (
                              console.info(
                                "if(key === 'praise')为true触发return,path: /renderer/components/Classroom/SmallClass/Live/Interactions/index.vue"
                              ),
                              t.abrupt(
                                'return',
                                e.$bus.$emit('endCorrectPhotoWall', i, a)
                              )
                            )
                          case 38:
                            if (
                              ('speedyHand' === o &&
                                ((v =
                                  null ===
                                    (p = e.interactionMap.get('speedyHand')) ||
                                  void 0 === p
                                    ? void 0
                                    : p.instance),
                                v && v.vm.receiveMessage(i)),
                              'mult_video_mic' !== o)
                            ) {
                              t.next = 46
                              break
                            }
                            if (
                              ((S =
                                null ===
                                  (C =
                                    e.interactionMap.get('mult_video_mic')) ||
                                void 0 === C
                                  ? void 0
                                  : C.instance),
                              i.pub &&
                                (null === (g = e.speedyHandInstance) ||
                                  void 0 === g ||
                                  g.instance.vm.destroyInteraction('normal')),
                              !S || !i.pub || 1 == i.status || a)
                            ) {
                              t.next = 46
                              break
                            }
                            return (
                              console.info(
                                'if(_interaction4 && noticeContent.pub && noticeContent.status != 1 && !isHistory)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/Interactions/index.vue'
                              ),
                              S.vm.receiveMessage(i),
                              t.abrupt('return')
                            )
                          case 46:
                            if ('all_onStage_closed' !== o) {
                              t.next = 49
                              break
                            }
                            return (
                              console.info(
                                "if(key === 'all_onStage_closed')为true触发return,path: /renderer/components/Classroom/SmallClass/Live/Interactions/index.vue"
                              ),
                              t.abrupt('return')
                            )
                          case 49:
                            if ('graffiti_board' !== o) {
                              t.next = 55
                              break
                            }
                            if (
                              ((w =
                                null ===
                                  (b =
                                    e.interactionMap.get('graffiti_board')) ||
                                void 0 === b
                                  ? void 0
                                  : b.instance),
                              !w || i.pub || i.isEnd || !i.dbkey)
                            ) {
                              t.next = 55
                              break
                            }
                            return (
                              console.info(
                                'if(_interaction5 && !noticeContent.pub && !noticeContent.isEnd && noticeContent.dbkey)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/Interactions/index.vue'
                              ),
                              w.vm.stopGratiffi(),
                              t.abrupt('return')
                            )
                          case 55:
                            if (
                              ('graffiti_board_watching' === o &&
                                e.$store.dispatch(
                                  'smallClass/updateGraffitiBoardWatchingStutus',
                                  i
                                ),
                              'red_packet_rain' !== o)
                            ) {
                              t.next = 87
                              break
                            }
                            if (
                              ((k = i.pub),
                              (L = i.action),
                              (y = i.name),
                              'redbagrainPackage' === y && (o = 'redPacket'),
                              (I = e.interactionMap.get(o)),
                              !k)
                            ) {
                              t.next = 87
                              break
                            }
                            if (!I || 'start' !== L) {
                              t.next = 64
                              break
                            }
                            return (
                              console.info(
                                "if(storeVm && action === 'start')为true触发return,path: /renderer/components/Classroom/SmallClass/Live/Interactions/index.vue"
                              ),
                              t.abrupt('return')
                            )
                          case 64:
                            if ('play' !== L) {
                              t.next = 87
                              break
                            }
                            if (
                              ((P = localStorage.getItem('redPacketRainKey')),
                              (O = localStorage.getItem('redPacketRainStatus')),
                              P !== i.interactId || 'end' !== O)
                            ) {
                              t.next = 71
                              break
                            }
                            return (
                              console.info(
                                "if(interactId === noticeContent.interactId && status === 'end')为true触发return,path: /renderer/components/Classroom/SmallClass/Live/Interactions/index.vue"
                              ),
                              I && e.destroy(o),
                              t.abrupt('return')
                            )
                          case 71:
                            if (!I || ('' !== O && 'start' !== O)) {
                              t.next = 75
                              break
                            }
                            return (
                              console.info(
                                "if(storeVm && (status === '' || status === 'start'))为true触发return,path: /renderer/components/Classroom/SmallClass/Live/Interactions/index.vue"
                              ),
                              I.instance.vm.play(),
                              t.abrupt('return')
                            )
                          case 75:
                            if (
                              ((A =
                                e.baseData.commonOption.timeOffset +
                                +new Date()),
                              !(A > r + 10000))
                            ) {
                              t.next = 80
                              break
                            }
                            return (
                              console.info(
                                'if(nowTime > sendTime + 10000)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/Interactions/index.vue'
                              ),
                              t.abrupt('return')
                            )
                          case 80:
                            return (
                              (j = e.$store.state.smallClass.baseData),
                              (M = j.stuInfo),
                              (T = j.planInfo),
                              (t.next = 83),
                              Object(xa.b)(e, {
                                interactId: i.interactId,
                                planId: T.id,
                                userId: M.id.toString(),
                              })
                            )
                          case 83:
                            if (((R = t.sent), !R)) {
                              t.next = 87
                              break
                            }
                            return (
                              console.info(
                                'if(hasReport)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/Interactions/index.vue'
                              ),
                              t.abrupt('return')
                            )
                          case 87:
                            if (!La[o]) {
                              t.next = 131
                              break
                            }
                            if (
                              ((B = i.pub),
                              (D = i.open),
                              (V = i.publishTopic),
                              'schulte_table' !== o)
                            ) {
                              t.next = 105
                              break
                            }
                            if (
                              (console.info(
                                "if(key === 'schulte_table')为true触发return,path: /renderer/components/Classroom/SmallClass/Live/Interactions/index.vue"
                              ),
                              !a)
                            ) {
                              t.next = 100
                              break
                            }
                            if (
                              ((N = e.interactionMap.get(o)),
                              !N || i.interactId !== N.ircMsg.interactId)
                            ) {
                              t.next = 96
                              break
                            }
                            return (
                              console.info(
                                'if(_keyContent && noticeContent.interactId === _keyContent.ircMsg.interactId)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/Interactions/index.vue'
                              ),
                              t.abrupt('return')
                            )
                          case 96:
                            return (
                              (t.next = 98),
                              e.render({
                                key: o,
                                noticeContent: i,
                                isHistory: a,
                                sendTime: r,
                              })
                            )
                          case 98:
                            t.next = 103
                            break
                          case 100:
                            if (!B || 'schulte_table_start' !== i.actionType) {
                              t.next = 103
                              break
                            }
                            return (
                              (t.next = 103),
                              e.render({
                                key: o,
                                noticeContent: i,
                                isHistory: a,
                                sendTime: r,
                              })
                            )
                          case 103:
                            return (
                              e.$bus.$emit('room.schulte_table', i, a),
                              t.abrupt('return')
                            )
                          case 105:
                            if (!(B || D || V)) {
                              t.next = 130
                              break
                            }
                            if ('nonpreset_fill_blank' !== o || !i.isStop) {
                              t.next = 113
                              break
                            }
                            if (
                              (console.info(
                                "if(key === 'nonpreset_fill_blank' && noticeContent.isStop)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/Interactions/index.vue"
                              ),
                              !a)
                            ) {
                              t.next = 111
                              break
                            }
                            return (
                              (t.next = 111),
                              e.render({
                                key: o,
                                noticeContent: i,
                                isHistory: a,
                                sendTime: r,
                              })
                            )
                          case 111:
                            return (
                              e.$bus.$emit('free_fill_blank_stop'),
                              t.abrupt('return')
                            )
                          case 113:
                            if ('class_praise_list' !== o || !i.isUpdate) {
                              t.next = 122
                              break
                            }
                            if (
                              (console.info(
                                "if(key === 'class_praise_list' && noticeContent.isUpdate)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/Interactions/index.vue"
                              ),
                              !a)
                            ) {
                              t.next = 120
                              break
                            }
                            return (
                              (t.next = 118),
                              e.render({
                                key: o,
                                noticeContent: i,
                                isHistory: a,
                                sendTime: r,
                              })
                            )
                          case 118:
                            t.next = 121
                            break
                          case 120:
                            e.$bus.$emit('update_praise_list', i)
                          case 121:
                            return t.abrupt('return')
                          case 122:
                            if (((E = e.interactionMap.get(o)), !E)) {
                              t.next = 126
                              break
                            }
                            return (t.next = 126), e.destroy(o, false)
                          case 126:
                            return (
                              (t.next = 128),
                              e.render({
                                key: o,
                                noticeContent: i,
                                isHistory: a,
                                sendTime: r,
                              })
                            )
                          case 128:
                            t.next = 131
                            break
                          case 130:
                            ;(false !== B &&
                              false !== D &&
                              0 !== B &&
                              0 !== D &&
                              false !== V) ||
                              e.destroy(o)
                          case 131:
                            'speedyHand' === o &&
                              (i.pub
                                ? (e.speedHandTimer = setTimeout(function () {
                                    var t
                                    console.warn('0704 20s未接收到结果')
                                    var n =
                                      null ===
                                        (t =
                                          e.interactionMap.get('speedyHand')) ||
                                      void 0 === t
                                        ? void 0
                                        : t.instance
                                    null === n ||
                                      void 0 === n ||
                                      n.vm.destroyInteraction('normal')
                                    q.a.send({
                                      tag: 'student.Interact',
                                      content: {
                                        msg: '抢答\uFF09接收消息--20s未接收到结果',
                                        interactType: 'speedyHand',
                                      },
                                    })
                                  }, 20000))
                                : (clearTimeout(e.speedHandTimer),
                                  q.a.send({
                                    tag: 'student.Interact',
                                    content: {
                                      msg: '抢答\uFF09接收消息--接收到结果----清除兜底方案',
                                      interactType: 'speedyHand',
                                    },
                                  })))
                          case 132:
                          case 'end':
                            return t.stop()
                        }
                      }
                    }, t)
                  })
                )
                return function (e) {
                  return t.apply(this, arguments)
                }
              })()
            )
          },
          render: function (e) {
            var t = this
            return Object(y.a)(
              Object(x.a)().mark(function n() {
                var s, o, a, i, r, c, l
                return Object(x.a)().wrap(function (n) {
                  while (1) {
                    switch ((n.prev = n.next)) {
                      case 0:
                        if (
                          ((s = e.key),
                          (o = e.noticeContent),
                          (a = e.isHistory),
                          (i = e.sendTime),
                          console.info(
                            '对象函数 render(key, noticeContent, isHistory, sendTime)',
                            s,
                            o,
                            a,
                            i,
                            'filePath:renderer/components/Classroom/SmallClass/Live/Interactions/index.vue'
                          ),
                          (r = t.interactionList[s]),
                          !r)
                        ) {
                          n.next = 13
                          break
                        }
                        return (n.next = 6), r()
                      case 6:
                        ;(c = n.sent),
                          (l = new c.default(
                            {
                              roomMessage: {
                                roomInfo: Object(V.a)(
                                  Object(V.a)({}, t.baseData),
                                  {},
                                  {
                                    interactionController:
                                      document.getElementById(
                                        'interactionController'
                                      ),
                                    interactionFullPage:
                                      document.getElementById(
                                        'interactionFullPage'
                                      ),
                                    interactionGame:
                                      document.getElementById(
                                        'interactionGame'
                                      ),
                                  }
                                ),
                              },
                              ircMsg: o,
                              isHistory: a,
                              keepOtherDom: true,
                            },
                            t.$store
                          )),
                          'speedyHand' === s &&
                            (t.speedyHandInstance = {
                              instance: l,
                              ircMsg: o,
                            }),
                          t.interactionMap.set(s, {
                            instance: l,
                            ircMsg: Object(V.a)(
                              Object(V.a)({}, o),
                              {},
                              { sendTime: i }
                            ),
                          }),
                          t.$store.dispatch(
                            'smallClass/updateInteractionStatus',
                            {
                              interactionName: s,
                              interactionStatus: true,
                            }
                          ),
                          (n.next = 14)
                        break
                      case 13:
                        console.error('未实现这种互动')
                      case 14:
                      case 'end':
                        return n.stop()
                    }
                  }
                }, n)
              })
            )()
          },
          destroy: function (e) {
            var t = arguments,
              n = this
            return Object(y.a)(
              Object(x.a)().mark(function s() {
                var o, a, i, r
                return Object(x.a)().wrap(function (s) {
                  while (1) {
                    switch ((s.prev = s.next)) {
                      case 0:
                        if (
                          ((o = !(t.length > 1 && void 0 !== t[1]) || t[1]),
                          console.info(
                            '对象函数 destroy(key, isNeedSubmit)',
                            e,
                            o,
                            'filePath:renderer/components/Classroom/SmallClass/Live/Interactions/index.vue'
                          ),
                          (a = n.interactionMap.get(e)),
                          a)
                        ) {
                          break
                        }
                        return (
                          console.info(
                            'if(!interactionObj)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/Interactions/index.vue'
                          ),
                          s.abrupt('return')
                        )
                      case 6:
                        if (
                          ((i = a.instance),
                          (r = a.ircMsg),
                          n.interactionMap.delete(e),
                          n.$store.dispatch(
                            'smallClass/updateInteractionStatus',
                            {
                              interactionName: e,
                              interactionStatus: false,
                            }
                          ),
                          !i.vm.destroyInteraction)
                        ) {
                          break
                        }
                        i.vm.destroyInteraction({
                          ircMsg: r,
                          isNeedSubmit: o,
                        }),
                          (s.next = 16)
                        break
                      case 14:
                        return (
                          (s.next = 16),
                          i.destroy({
                            options: n.baseData,
                            ircMsg: r,
                            submit: n.submit,
                          })
                        )
                      case 16:
                      case 'end':
                        return s.stop()
                    }
                  }
                }, s)
              })
            )()
          },
        },
      },
      Ia = ya,
      Pa = Object(U.a)(Ia, r, c, false, null, null, null),
      Oa = Pa.exports,
      Aa = function () {
        var e = this,
          t = e._self._c
        return t('div', { staticClass: 'audition-notice' }, [
          t('div', { staticClass: 'content' }, [
            e._v(
              ' ' +
                e._s(e.$t('classroom.smallClass.auditionPanel.notice')) +
                ' '
            ),
          ]),
        ])
      },
      ja = [],
      Ma = {
        components: {},
        data: function () {
          return {}
        },
        mounted: function () {},
      },
      Ta = Ma,
      Ra = (n('0c1b'), Object(U.a)(Ta, Aa, ja, false, null, '72ab1eaa', null)),
      Ba = Ra.exports,
      Da = n('34bb'),
      Va = n('df5f'),
      Ea = {
        name: 'Live',
        components: {
          VideoGroup: qe,
          CoursewareBoard: yt,
          Sidebar: So,
          Modules: ka,
          Interactions: Oa,
          AuditionPanel: Ba,
          Speaking: W,
          Chatbox: Va.a,
        },
        data: function () {
          var e = this.$store.state.smallClass.baseData,
            t = e.commonOption.isAudition
          return {
            baseData: e,
            isAudition: t,
            coursewareWidth: 762,
            coursewareHeight: 572,
            interactionMarginLeft: 0,
            showSpeaking: false,
            stuName: '',
            timer: null,
            blurTimer: null,
            isWindowBlur: null,
            startTime: '',
            endTime: '',
            isChatFull: false,
          }
        },
        computed: Object(V.a)(
          Object(V.a)(
            {},
            Object(Se.mapGetters)({ chatBox: 'smallClass/chatBox' })
          ),
          {},
          {
            maxVolumeStudent: function () {
              return (
                console.info(
                  '对象函数 maxVolumeStudent,filePath:renderer/components/Classroom/SmallClass/Live/live.vue'
                ),
                this.$store.state.smallClass.setMaxVolumeStudent
              )
            },
          }
        ),
        watch: {
          maxVolumeStudent: {
            handler: function (e) {
              var t = this
              if (e.stuName && '' != e.stuName && e.volume > 100) {
                clearTimeout(this.timer)
                this.showSpeaking = true
                this.stuName = e.stuName
              } else {
                if (!this.showSpeaking) {
                  return void console.info(
                    'if(!this.showSpeaking)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/live.vue'
                  )
                }
                this.timer = setTimeout(function () {
                  t.showSpeaking = false
                  t.stuName = ''
                }, 1000)
              }
            },
            deep: true,
            immediate: true,
          },
        },
        mounted: function () {
          q.a.send({
            tag: 'userTrack',
            content: { msg: '小班课堂-live模板' },
          })
          window.addEventListener('resize', this.setCoursewareAdaptation)
          this.setCoursewareAdaptation()
          this.windowBlur()
          var e = document.querySelector('.class-center-wrapper').offsetWidth,
            t = document.querySelector('.sidebar-wrapper').offsetWidth,
            n = document.querySelector('.courseware-board-wrapper').offsetWidth
          this.isChatFull = e - t - n > 278
        },
        methods: {
          windowBlur: function () {
            console.info(
              '对象函数 windowBlur,filePath:renderer/components/Classroom/SmallClass/Live/live.vue'
            )
            var e = this.$store.state.smallClass.baseData,
              t = e.commonOption,
              n = e.stuInfo,
              s = e.configs,
              o = e.planInfo
            this.$store.state.smallClass.baseData
            t.isParent || t.isAudition
              ? console.info(
                  'if(commonOption.isParent || commonOption.isAudition)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/live.vue'
                )
              : this.focusHandler({
                  studentId: n.id,
                  teacherIrcId: s.teacherIrcId,
                  planId: o.id,
                })
          },
          focusHandler: function (e) {
            var t = this,
              n = e.studentId,
              s = e.teacherIrcId,
              o = e.planId
            console.info(
              '对象函数 focusHandler(studentId, teacherIrcId, planId)',
              n,
              s,
              o,
              'filePath:renderer/components/Classroom/SmallClass/Live/live.vue'
            )
            Da.ipcRenderer.on('window_blur', function (e, a) {
              if ((clearTimeout(t.blurTimer), t.isWindowBlur !== a)) {
                console.info('监听window_blur,学生端聚焦/失焦', a)
                var i = a ? 5000 : 0,
                  r = JSON.stringify({
                    type: 'isBlur',
                    isBlur: a,
                    id: n,
                  })
                t.blurTimer = setTimeout(function () {
                  window.ChatClient.PeerChatManager.sendPeerMessage(
                    [{ nickname: s }],
                    r,
                    Ss.a.notice
                  )
                  a
                    ? (t.startTime = new Date().getTime())
                    : ((t.endTime = new Date().getTime()),
                      t.startTime &&
                        t.reportData({
                          studentId: n,
                          planId: o,
                        }))
                  t.isWindowBlur = a
                  Ht.a(a)
                  q.a.send({
                    tag: '开小差',
                    content: r,
                    teacherIrcId: s,
                  })
                }, i)
              } else {
                console.info(
                  'if(_this2.isWindowBlur === arg)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/live.vue'
                )
              }
            })
          },
          reportData: function (e) {
            var t = this
            return Object(y.a)(
              Object(x.a)().mark(function n() {
                var s, o, a, i, r
                return Object(x.a)().wrap(function (n) {
                  while (1) {
                    switch ((n.prev = n.next)) {
                      case 0:
                        return (
                          (s = e.studentId),
                          (o = e.planId),
                          console.info(
                            '对象函数 reportData(studentId, planId)',
                            s,
                            o,
                            'filePath:renderer/components/Classroom/SmallClass/Live/live.vue'
                          ),
                          (a = t.startTime),
                          (i = t.endTime),
                          (r = parseInt((i - a) / 1000)),
                          (n.next = 7),
                          Object(K.k)({
                            planId: o,
                            studentId: s,
                            duration: r,
                            startTime: a,
                            endTime: i,
                          }).catch(function (e) {
                            console.info(
                              '箭头函数 notFocusedPush的catch(err)',
                              e,
                              'filePath:renderer/components/Classroom/SmallClass/Live/live.vue'
                            )
                            q.a.send({
                              tag: '开小差',
                              content: {
                                msg: '状态上报接口报错'.concat(
                                  JSON.stringify(e)
                                ),
                              },
                              level: 'error',
                            })
                          })
                        )
                      case 7:
                      case 'end':
                        return n.stop()
                    }
                  }
                }, n)
              })
            )()
          },
          setCoursewareAdaptation: $t()(function () {
            var e = document.getElementsByClassName(
              'courseware-board-wrapper'
            )[0]
            this.coursewareWidth = e.offsetWidth
            this.coursewareHeight = e.offsetHeight
            this.coursewareOffsetLeft = e.offsetLeft
            this.$store.dispatch('smallClass/updateCoursesWarePos', {
              width: this.coursewareWidth,
              height: this.coursewareHeight,
              offsetLeft: this.coursewareOffsetLeft,
            })
            this.coursewareWidth
            this.coursewareHeight
            this.coursewareOffsetLeft
          }, 300),
        },
        beforeDestroy: function () {
          console.info(
            '对象函数 beforeDestroy,filePath:renderer/components/Classroom/SmallClass/Live/live.vue'
          )
          window.removeEventListener('resize', this.setCoursewareAdaptation)
        },
      },
      _a = Ea,
      Ha = (n('9962'), Object(U.a)(_a, B, D, false, null, '4c3aa63b', null)),
      Ua = Ha.exports,
      $a = function () {
        var e = this,
          t = e._self._c
        return t(
          'div',
          { staticClass: 'whole-on-satge-container' },
          [
            t('div', { staticClass: 'whole-on-satge' }, [
              t(
                'div',
                { staticClass: 'left-module' },
                [
                  t('TeacherModule', { attrs: { videoGroup: e.videoGroup } }),
                  t('ChatBox', {
                    ref: 'chatbox',
                    staticClass: 'chat-box',
                    attrs: {
                      showHeader: false,
                      isWholeOnsatge: true,
                    },
                  }),
                ],
                1
              ),
              t('div', { staticClass: 'right-module' }, [
                t(
                  'div',
                  { staticClass: 'student-video' },
                  [t('StudentModule', { attrs: { videoGroup: e.videoGroup } })],
                  1
                ),
                t(
                  'div',
                  { staticClass: 'operator-zone' },
                  [t('OperatorModule')],
                  1
                ),
              ]),
            ]),
            t('NetworkError'),
          ],
          1
        )
      },
      Wa = [],
      Ga = function () {
        var e = this,
          t = e._self._c
        return t('TeacherVideo', {
          attrs: {
            videoGroup: e.videoGroup,
            isAllOnStage: true,
          },
        })
      },
      Fa = [],
      Ja = {
        name: 'TeacherModule',
        components: { TeacherVideo: oe },
        props: {
          videoGroup: {
            type: Object,
            default: null,
          },
        },
      },
      za = Ja,
      Qa = Object(U.a)(za, Ga, Fa, false, null, null, null),
      Ka = Qa.exports,
      qa = function () {
        var e = this,
          t = e._self._c
        return t(
          'div',
          { staticClass: 'student-video-wrapper' },
          [
            t(
              'section',
              { staticClass: 'video-inner' },
              [
                t('LocalVideo', {
                  ref: 'LocalVideo',
                  attrs: {
                    isAllOnStage: true,
                    videoGroup: e.videoGroup,
                  },
                }),
                e._l(e.studentList, function (n) {
                  return [
                    n.inClass
                      ? t('RemoteVideo', {
                          key: n.stuId,
                          attrs: {
                            remoteStuInfo: n,
                            isChild: n.stuId == e.baseData.commonOption.stuId,
                            hideRemoteVideo: e.hideRemoteVideo,
                            remoteAudioStatus: e.remoteAudioStatus,
                            isAllOnStage: true,
                          },
                          on: {
                            handleRemoteVideoStatus: e.handleRemoteVideoStatus,
                            clearEmoticon: e.handleClearEmoticon,
                            raiseHandUpdateStatus:
                              e.handleRaiseHandUpdateStatus,
                          },
                        })
                      : e._e(),
                  ]
                }),
              ],
              2
            ),
            t('StudentAudio', { attrs: { videoGroup: e.videoGroup } }),
          ],
          1
        )
      },
      Xa = [],
      Ya = {
        name: 'StudentVideo',
        components: {
          LocalVideo: ke,
          RemoteVideo: Oe,
          StudentAudio: Je,
        },
        props: {
          videoGroup: {
            type: Object,
            default: null,
          },
        },
        data: function () {
          return {
            otherCameraStatus: false,
            remoteStuVideoStream: [],
            pageNum: 1,
            pageSize: 6,
            rtcEventMap: {
              remoteJoinChannel: this.remoteJoinHandle,
              remoteLeaveChannel: this.remoteLeaveHandle,
              remoteAudioVolume: this.remoteVolumeHandle,
              remoteVideoStateChanged: this.remoteSutdentChange,
              remoteAudioStateChanged: this.remoteAudioChangeHandle,
            },
            noInStudentListCache: new Map(),
          }
        },
        computed: Object(V.a)(
          {
            hideRemoteVideo: function () {
              return (
                console.info(
                  '对象函数 hideRemoteVideo,filePath:renderer/components/Classroom/SmallClass/Live/WholeOnStage/StudentModule/index.vue'
                ),
                this.otherCameraStatus
              )
            },
          },
          Object(Se.mapState)('smallClass', [
            'baseData',
            'cameraStatus',
            'remoteAudioStatus',
            'studentList',
          ])
        ),
        mounted: function () {
          this.init()
        },
        methods: {
          init: function () {
            console.info(
              '对象函数 init,filePath:renderer/components/Classroom/SmallClass/Live/WholeOnStage/StudentModule/index.vue'
            )
            this.listenerRtcService()
            this.listenerSignalService()
            this.listenerEvent()
          },
          remoteJoinHandle: function (e) {
            console.info(
              '对象函数 remoteJoinHandle(uid)',
              e,
              'filePath:renderer/components/Classroom/SmallClass/Live/WholeOnStage/StudentModule/index.vue'
            )
            this.videoGroup.sendLogger('远端学生加入频道, uid: '.concat(e))
            this.updateClassStudent(e)
          },
          remoteLeaveHandle: function (e) {
            console.info(
              '对象函数 remoteLeaveHandle(uid)',
              e,
              'filePath:renderer/components/Classroom/SmallClass/Live/WholeOnStage/StudentModule/index.vue'
            )
            this.updateNoInStudentListCache(e, { inClass: false })
            var t = this.studentList.find(function (t) {
              return t.userId == e
            })
            t
              ? (this.updateStudentList(e, { inClass: false }),
                this.videoGroup.sendLogger('远端学生离开频道, uid: '.concat(e)))
              : console.info(
                  'if(!stuInfo)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/WholeOnStage/StudentModule/index.vue'
                )
          },
          remoteVolumeHandle: function (e, t) {
            console.info(
              '对象函数 remoteVolumeHandle(uid, volume)',
              e,
              t,
              'filePath:renderer/components/Classroom/SmallClass/Live/WholeOnStage/StudentModule/index.vue'
            )
            this.updateStudentList(e, { volume: t })
          },
          remoteAudioChangeHandle: function (e, t, n) {
            console.info(
              '对象函数 remoteAudioChangeHandle(uid, state, reason)',
              e,
              t,
              n,
              'filePath:renderer/components/Classroom/SmallClass/Live/WholeOnStage/StudentModule/index.vue'
            )
            var s = {
              next: 6,
              next: 14,
            }
            1 === t && (s.microphoneStatus = true)
            5 === n && (s.microphoneStatus = false)
            this.updateStudentList(e, s)
            this.updateNoInStudentListCache(e, s)
          },
          ircMessage: function (e) {
            console.info(
              '对象函数 ircMessage(res)',
              e,
              'filePath:renderer/components/Classroom/SmallClass/Live/WholeOnStage/StudentModule/index.vue'
            )
            var t = e.content,
              n = e.fromUserInfo,
              s = t.ircType,
              o = t.data
            'send_emoji' == s
              ? this.handleEmoticon(n.psId, {
                  name: o.name,
                  type: o.type,
                })
              : 'animation_emoji' == s &&
                this.handleEmoticon(
                  n.psId,
                  Object(V.a)(
                    {
                      type: o.type,
                      name: o.resource.emojiName,
                    },
                    o.resource
                  )
                )
            'raise_hand' == s && this.handleRaiseHandUpdateStatus(n.psId, true)
          },
          listenerRtcService: function () {
            console.info(
              '对象函数 listenerRtcService,filePath:renderer/components/Classroom/SmallClass/Live/WholeOnStage/StudentModule/index.vue'
            )
            var e = this.thinkClass.RtcService
            for (var t in this.rtcEventMap) e.on(t, this.rtcEventMap[t])
          },
          removeRtcService: function () {
            console.info(
              '对象函数 removeRtcService,filePath:renderer/components/Classroom/SmallClass/Live/WholeOnStage/StudentModule/index.vue'
            )
            var e = this.thinkClass.RtcService
            for (var t in this.rtcEventMap) e.off(t, this.rtcEventMap[t])
          },
          listenerSignalService: function () {
            console.info(
              '对象函数 listenerSignalService,filePath:renderer/components/Classroom/SmallClass/Live/WholeOnStage/StudentModule/index.vue'
            )
            var e = this.thinkClass.SignalService
            e.on('onRecvRoomMessage', this.ircMessage)
          },
          removeSignalService: function () {
            console.info(
              '对象函数 removeSignalService,filePath:renderer/components/Classroom/SmallClass/Live/WholeOnStage/StudentModule/index.vue'
            )
            var e = this.thinkClass.SignalService
            e.off('onRecvRoomMessage', this.ircMessage)
          },
          listenerEvent: function () {
            var e = this
            console.info(
              '对象函数 listenerEvent,filePath:renderer/components/Classroom/SmallClass/Live/WholeOnStage/StudentModule/index.vue'
            )
            this.$bus.$on('cameraStatus', function (t) {
              console.info(
                '箭头函数 监听 cameraStatus(status)',
                t,
                'filePath:renderer/components/Classroom/SmallClass/Live/WholeOnStage/StudentModule/index.vue'
              )
              e.cameraStatus &&
                (t
                  ? e.thinkClass.RtcService.muteLocalVideo(true)
                  : e.thinkClass.RtcService.muteLocalVideo(false))
            })
            this.$bus.$on('setDefaultVideoDevice', function (t) {
              console.info(
                '箭头函数 监听 setDefaultVideoDevice(deviceId)',
                t,
                'filePath:renderer/components/Classroom/SmallClass/Live/WholeOnStage/StudentModule/index.vue'
              )
              e.thinkClass.RtcService.setVideoDevice(t)
            })
            this.$bus.$on('remoteAudioStatus', function (t) {
              console.info(
                '箭头函数 监听 remoteAudioStatus(status)',
                t,
                'filePath:renderer/components/Classroom/SmallClass/Live/WholeOnStage/StudentModule/index.vue'
              )
              e.$store.dispatch('smallClass/updateRemoteAudioStatus', t)
            })
            this.$bus.$on('liveQuit', function () {
              console.info(
                '箭头函数 监听 liveQuit,filePath:renderer/components/Classroom/SmallClass/Live/WholeOnStage/StudentModule/index.vue'
              )
              e.thinkClass.RtcService.unpublish()
              e.thinkClass.RtcService.leaveChannel()
            })
          },
          updateClassStudent: function (e) {
            console.info(
              '对象函数 updateClassStudent(uid)',
              e,
              'filePath:renderer/components/Classroom/SmallClass/Live/WholeOnStage/StudentModule/index.vue'
            )
            var t = this.studentList.find(function (t) {
              return e == t.userId
            })
            t ? this.handleRemoteJoinChannel(e) : this.getOriginClassStudent(e)
          },
          getOriginClassStudent: function (e) {
            var t = this
            return Object(y.a)(
              Object(x.a)().mark(function n() {
                var s, o, a, i, r
                return Object(x.a)().wrap(function (n) {
                  while (1) {
                    switch ((n.prev = n.next)) {
                      case 0:
                        return (
                          console.info(
                            '对象函数 getOriginClassStudent(uid)',
                            e,
                            'filePath:renderer/components/Classroom/SmallClass/Live/WholeOnStage/StudentModule/index.vue'
                          ),
                          t.noInStudentListCache.set(e, {
                            cameraStatus: false,
                            microphoneStatus: true,
                            mutedVideoStatus: false,
                            inClass: true,
                          }),
                          (s = t.baseData.commonOption),
                          (n.next = 5),
                          Object(K.n)({
                            planId: s.planId,
                            classId: s.classId,
                          })
                        )
                      case 5:
                        ;(o = n.sent),
                          o &&
                            0 == o.code &&
                            ((a = o.data || []),
                            (i = a.find(function (t) {
                              return t.userId == e
                            })),
                            i &&
                              ((r = t.noInStudentListCache.get(e)),
                              t.$store.dispatch(
                                'smallClass/concatStudentList',
                                {
                                  stuInfo: i,
                                  rtcInfo: r,
                                }
                              ),
                              t.noInStudentListCache.delete(e),
                              t.remoteAudioStatus ||
                                t.thinkClass.RtcService.muteRemoteAudio(
                                  e,
                                  true
                                ),
                              t.$nextTick(function () {
                                t.thinkClass.RtcService.createRemoteVideo(
                                  e,
                                  'remote-'.concat(e)
                                )
                              })))
                      case 7:
                      case 'end':
                        return n.stop()
                    }
                  }
                }, n)
              })
            )()
          },
          handleRemoteJoinChannel: function (e) {
            console.info(
              '对象函数 handleRemoteJoinChannel(uid)',
              e,
              'filePath:renderer/components/Classroom/SmallClass/Live/WholeOnStage/StudentModule/index.vue'
            )
            this.updateStudentList(e, { inClass: true })
            this.studentList
          },
          handleRemoteVideoStatus: function (e, t) {
            console.info(
              '对象函数 handleRemoteVideoStatus(stuId, status)',
              e,
              t,
              'filePath:renderer/components/Classroom/SmallClass/Live/WholeOnStage/StudentModule/index.vue'
            )
            this.updateStudentList(e, { displayVideo: t })
            this.videoGroup.sendLogger(
              '学生操作远端视频开关状态, uid: '.concat(e, ' status: ').concat(t)
            )
          },
          handleEmoticon: function (e, t) {
            console.info(
              '对象函数 handleEmoticon(stuId, params)',
              e,
              t,
              'filePath:renderer/components/Classroom/SmallClass/Live/WholeOnStage/StudentModule/index.vue'
            )
            var n = {
              emoticonName: t.name,
              emoticonType: t.type,
              lottieUrl: t.lottieUrl,
              emojiId: t.emojiId,
            }
            this.updateStudentList(e, n)
          },
          handleClearEmoticon: function (e) {
            console.info(
              '对象函数 handleClearEmoticon(stuId)',
              e,
              'filePath:renderer/components/Classroom/SmallClass/Live/WholeOnStage/StudentModule/index.vue'
            )
            this.updateStudentList(e, t)
          },
          handleRaiseHandUpdateStatus: function (e, t) {
            console.info(
              '对象函数 handleRaiseHandUpdateStatus(stuId, status)',
              e,
              t,
              'filePath:renderer/components/Classroom/SmallClass/Live/WholeOnStage/StudentModule/index.vue'
            )
            this.updateStudentList(e, { raiseHandStatus: t })
          },
          remoteSutdentChange: function (e, t, n) {
            if (
              (console.info(
                '对象函数 remoteSutdentChange(uid, state, reason)',
                e,
                t,
                n,
                'filePath:renderer/components/Classroom/SmallClass/Live/WholeOnStage/StudentModule/index.vue'
              ),
              e != this.baseData.configs.rtcConfig.teacherUid)
            ) {
              var s = {}
              if (
                (2 == t &&
                  (s = {
                    cameraStatus: true,
                    mutedVideoStatus: false,
                  }),
                5 === n
                  ? (s.mutedVideoStatus = true)
                  : 6 === n && (s.mutedVideoStatus = false),
                this.updateStudentList(e, s),
                this.updateNoInStudentListCache(e, s),
                2 == t)
              ) {
                var o = document.getElementById('remote-'.concat(e))
                if (o && o.innerHTML) {
                  return void console.info(
                    'if(remoteElement && remoteElement.innerHTML)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/WholeOnStage/StudentModule/index.vue'
                  )
                }
                this.thinkClass.RtcService.createRemoteVideo(
                  e,
                  'remote-'.concat(e)
                )
              }
            } else {
              console.info(
                'if(uid == this.baseData.configs.rtcConfig.teacherUid)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/WholeOnStage/StudentModule/index.vue'
              )
            }
          },
          updateStudentList: function (e, t) {
            console.info(
              '对象函数 updateStudentList(uid, data)',
              e,
              t,
              'filePath:renderer/components/Classroom/SmallClass/Live/WholeOnStage/StudentModule/index.vue'
            )
            this.$store.dispatch('smallClass/updateStudentList', {
              uid: e,
              data: t,
            })
          },
          updateNoInStudentListCache: function (e, t) {
            console.info(
              '对象函数 updateNoInStudentListCache(uid, data)',
              e,
              t,
              'filePath:renderer/components/Classroom/SmallClass/Live/WholeOnStage/StudentModule/index.vue'
            )
            this.noInStudentListCache.has(e) &&
              Object.assign(this.noInStudentListCache.get(e), t)
          },
        },
        destroyed: function () {
          console.info(
            '对象函数 destroyed,filePath:renderer/components/Classroom/SmallClass/Live/WholeOnStage/StudentModule/index.vue'
          )
          this.$bus.$off('cameraStatus')
          this.$bus.$off('remoteAudioStatus')
          this.$bus.$off('liveQuit')
          this.removeRtcService()
          this.removeSignalService()
        },
      },
      Za = Ya,
      ei = (n('c7b1'), Object(U.a)(Za, qa, Xa, false, null, 'ca12ce6a', null)),
      ti = ei.exports,
      ni = function () {
        var e = this,
          t = e._self._c
        return t('div', { staticClass: 'operator' }, [
          t('div', { staticClass: 'operator-container' }, [
            t(
              'div',
              { staticClass: 'microphone' },
              [t('MicroPhone', { attrs: { allOnStage: true } })],
              1
            ),
            t(
              'div',
              { staticClass: 'camera' },
              [t('SwitchCamera', { attrs: { allOnStage: true } })],
              1
            ),
            t(
              'div',
              { staticClass: 'raise-hand' },
              [t('SendEmoji', { attrs: { allOnStage: true } })],
              1
            ),
          ]),
          t(
            'section',
            { staticClass: 'allow-confirm-tip' },
            [
              t('MicrophoneAllowConfirm', {
                ref: 'MicrophoneAllowConfirm',
                attrs: { isAllOnStage: true },
              }),
              t('CameraAllowConfirm', {
                ref: 'CameraAllowConfirm',
                attrs: { isAllOnStage: true },
              }),
              t('TeacherDisabledMicrophoneNotice', {
                ref: 'TeacherDisabledMicrophoneNotice',
                attrs: { isAllOnStage: true },
              }),
              t('LiveKickout', {
                ref: 'LiveKickout',
                attrs: { options: e.options },
              }),
            ],
            1
          ),
        ])
      },
      si = [],
      oi = {
        components: {
          MicroPhone: Jt,
          SwitchCamera: nn,
          SendEmoji: ms,
          MicrophoneAllowConfirm: ea,
          CameraAllowConfirm: ma,
          TeacherDisabledMicrophoneNotice: Sa,
          LiveKickout: Po.a,
        },
        computed: {
          options: function () {
            return (
              console.info(
                '对象函数 options,filePath:renderer/components/Classroom/SmallClass/Live/WholeOnStage/OperatorModule/index.vue'
              ),
              this.$store.state.smallClass.baseData.commonOption
            )
          },
        },
      },
      ai = oi,
      ii = (n('266ff'), Object(U.a)(ai, ni, si, false, null, '86fb8bd4', null)),
      ri = ii.exports,
      ci = {
        name: 'WholeOnStage',
        data: function () {
          return {
            baseData: this.$store.state.smallClass.baseData,
            videoGroup: null,
          }
        },
        components: {
          TeacherModule: Ka,
          StudentModule: ti,
          OperatorModule: ri,
          ChatBox: Va.a,
          NetworkError: Wo,
        },
        created: function () {
          var e = this.baseData.commonOption
          this.videoGroup = new X({
            planId: e.planId,
            classId: e.classId,
          })
        },
        mounted: function () {
          q.a.send({
            tag: 'userTrack',
            content: { msg: '小班课-全员上台' },
          })
          this.videoGroup.sendRtcStatus()
          this.$refs.chatbox.handleIsShowBox()
        },
        beforeDestroy: function () {
          console.info(
            '对象函数 beforeDestroy,filePath:renderer/components/Classroom/SmallClass/Live/WholeOnStage/index.vue'
          )
          this.videoGroup = null
        },
      },
      li = ci,
      di = (n('ee02'), Object(U.a)(li, $a, Wa, false, null, 'b333084c', null)),
      ui = di.exports,
      hi = n('8958'),
      fi = n('d202'),
      pi = n('9b0f'),
      vi = n('e4ec')
    window._isUploadingNativeCourseware = false
    var Ci = (function () {
        function e() {
          var t =
            arguments.length > 0 && void 0 !== arguments[0] ? arguments[0] : {}
          Object(J.a)(this, e)
          this.userId = t.userId
          this.planId = t.planId
          this.coursewareId = t.coursewareId
        }
        return (
          Object(z.a)(e, [
            {
              key: 'upload',
              value: (function () {
                var e = Object(y.a)(
                  Object(x.a)().mark(function e(t) {
                    var n,
                      s,
                      o,
                      a,
                      i,
                      r,
                      c = this
                    return Object(x.a)().wrap(
                      function (e) {
                        while (1) {
                          switch ((e.prev = e.next)) {
                            case 0:
                              if (!window._isUploadingNativeCourseware) {
                                e.next = 3
                                break
                              }
                              return (
                                console.warn(
                                  '本地课件正在上传中:',
                                  window._isUploadingNativeLogs
                                ),
                                e.abrupt('return')
                              )
                            case 3:
                              return (
                                (e.next = 5),
                                Cs.nativeApi.getPathByName('userData')
                              )
                            case 5:
                              if (
                                ((n = e.sent),
                                (s = ''.concat(n, '/courseware/cw_webroot')),
                                (o = ''.concat(s, '/upload')),
                                (a = ''
                                  .concat(s, '/')
                                  .concat(this.coursewareId)),
                                s && Object(pi.existsSync)(a))
                              ) {
                                e.next = 12
                                break
                              }
                              return (
                                null === t ||
                                  void 0 === t ||
                                  null === (i = t.fail) ||
                                  void 0 === i ||
                                  i.call(t),
                                e.abrupt('return')
                              )
                            case 12:
                              return (
                                !Object(pi.existsSync)(o) &&
                                  Object(pi.mkdirSync)(o),
                                (window._isUploadingNativeCourseware = true),
                                (e.next = 16),
                                this.zipFile(a, o)
                              )
                            case 16:
                              e.sent,
                                (r = 'pcStudentCourseware/'.concat(
                                  this.userId
                                )),
                                new fi.a().upload({
                                  uploadFolder: r,
                                  uploadPath: o,
                                  success: function (e) {
                                    var n
                                    c.sendLogger(
                                      '本地课件上传成功, res: '.concat(
                                        JSON.stringify(e)
                                      )
                                    )
                                    null === t ||
                                      void 0 === t ||
                                      null === (n = t.success) ||
                                      void 0 === n ||
                                      n.call(t, e)
                                  },
                                  fail: function (e) {
                                    var n
                                    c.sendLogger(
                                      '本地课件上传失败, res: '.concat(
                                        JSON.stringify(e)
                                      )
                                    )
                                    null === t ||
                                      void 0 === t ||
                                      null === (n = t.fail) ||
                                      void 0 === n ||
                                      n.call(t, e)
                                  },
                                  final: function () {
                                    var e
                                    Object(pi.existsSync)(o)
                                    Object(pi.existsSync)(o) && Object(qs.g)(o)
                                    window._isUploadingNativeCourseware = false
                                    null === t ||
                                      void 0 === t ||
                                      null === (e = t.final) ||
                                      void 0 === e ||
                                      e.call(t)
                                  },
                                })
                            case 20:
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
                  return e.apply(this, arguments)
                }
                return t
              })(),
            },
            {
              key: 'zipFile',
              value: (function () {
                var e = Object(y.a)(
                  Object(x.a)().mark(function e(t, n) {
                    var s,
                      o = this
                    return Object(x.a)().wrap(
                      function (e) {
                        while (1) {
                          switch ((e.prev = e.next)) {
                            case 0:
                              return (
                                (s = ''
                                  .concat(n, '/')
                                  .concat(this.userId, '-courseware-')
                                  .concat(this.planId, '.zip')),
                                (e.next = 3),
                                vi.zip.compressDir(t, s).catch(function (e) {
                                  o.sendLogger(
                                    '本地课件压缩失败, res: '.concat(
                                      JSON.stringify(e)
                                    )
                                  )
                                })
                              )
                            case 3:
                              return e.abrupt('return', s)
                            case 4:
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
                function t(t, n) {
                  return e.apply(this, arguments)
                }
                return t
              })(),
            },
            {
              key: 'sendLogger',
              value: function (e) {
                q.a.send({
                  tag: 'coursewareUploadS3',
                  content: { msg: e },
                })
              },
            },
          ]),
          e
        )
      })(),
      Si = n('230e'),
      gi = n('139c'),
      bi = n('c5ee'),
      wi = {
        name: 'LiveEntry',
        components: {
          Live: Ua,
          WholeOnStage: ui,
        },
        mixins: [hi.a],
        data: function () {
          var e = this.$store.state.smallClass.baseData,
            t = e.commonOption.isAudition
          return {
            baseData: e,
            isAudition: t,
            onRtcServiceReady: false,
            coursewareWidth: 762,
            coursewareHeight: 572,
            interactionMarginLeft: 0,
            canShowOtherChild: false,
            workAreaSize: '',
            reportChannel: 'enterroom',
          }
        },
        computed: {
          cameraStatus: function () {
            return (
              console.info(
                '对象函数 cameraStatus,filePath:renderer/components/Classroom/SmallClass/Live/index.vue'
              ),
              this.$store.state.smallClass.cameraStatus
            )
          },
          microphoneStatus: function () {
            return (
              console.info(
                '对象函数 microphoneStatus,filePath:renderer/components/Classroom/SmallClass/Live/index.vue'
              ),
              this.$store.state.smallClass.microphoneStatus
            )
          },
          isAllOnStageStatus: function () {
            return (
              console.info(
                '对象函数 isAllOnStageStatus,filePath:renderer/components/Classroom/SmallClass/Live/index.vue'
              ),
              this.$store.state.smallClass.isAllOnStageStatus
            )
          },
        },
        created: function () {
          var e = this
          Da.ipcRenderer.on(
            'application:work-area-size-reply',
            function (t, n, s) {
              console.info(
                '箭头函数 监听 application:work-area-size-reply(event, windowWidth, windowHeight)',
                t,
                n,
                s,
                'filePath:renderer/components/Classroom/SmallClass/Live/index.vue'
              )
              e.workAreaSize = ''.concat(n, '*').concat(s)
              e.pushStudentDeviceInfo()
            }
          )
        },
        mounted: function () {
          var e = this
          return Object(y.a)(
            Object(x.a)().mark(function t() {
              return Object(x.a)().wrap(function (t) {
                while (1) {
                  switch ((t.prev = t.next)) {
                    case 0:
                      return (t.next = 2), e.initMediaAccess()
                    case 2:
                      return (t.next = 4), e.initVideoShow()
                    case 4:
                      e.init(),
                        (e.reportChannel = 'enterroom'),
                        Da.ipcRenderer.send('application:work-area-size'),
                        e.$bus.$on('liveQuit', function () {
                          console.info(
                            '箭头函数 监听 liveQuit,filePath:renderer/components/Classroom/SmallClass/Live/index.vue'
                          )
                          e.reportChannel = 'quitroom'
                          Da.ipcRenderer.send('application:work-area-size')
                        })
                    case 8:
                    case 'end':
                      return t.stop()
                  }
                }
              }, t)
            })
          )()
        },
        methods: {
          initVideoShow: function () {
            var e = this
            return Object(y.a)(
              Object(x.a)().mark(function t() {
                return Object(x.a)().wrap(function (t) {
                  while (1) {
                    switch ((t.prev = t.next)) {
                      case 0:
                        if (
                          (console.info(
                            '对象函数 initVideoShow,filePath:renderer/components/Classroom/SmallClass/Live/index.vue'
                          ),
                          !e.baseData.commonOption.isParent)
                        ) {
                          t.next = 7
                          break
                        }
                        return (t.next = 4), Object(Ee.d)('showOtherChild')
                      case 4:
                        ;(e.canShowOtherChild = t.sent), (t.next = 8)
                        break
                      case 7:
                        e.canShowOtherChild = true
                      case 8:
                      case 'end':
                        return t.stop()
                    }
                  }
                }, t)
              })
            )()
          },
          init: function () {
            var e = this
            console.info(
              '对象函数 init,filePath:renderer/components/Classroom/SmallClass/Live/index.vue'
            )
            var t = this.baseData,
              n = t.configs,
              s = t.stuInfo,
              o = t.planInfo,
              a = t.commonOption,
              i = new R.a({
                planId: o.id,
                businessId: n.liveTypeId,
                userId: s.id.toString(),
                rtcConfig: n.rtcConfig,
                isAudition: a.isAudition,
                ircOptions: {
                  appId: n.appId,
                  appKey: n.appKey,
                  nickname: n.stuIrcId,
                  ircRooms: n.ircRooms,
                  location: n.ircServer.location,
                  confService: n.ircServer.confService,
                  logService: n.ircServer.logService,
                },
              }),
              r = {
                ircRooms: n.ircRooms,
                ircServer: n.ircServer,
                stuIrcId: n.stuIrcId,
                teacherIrcId: n.teacherIrcId,
              }
            q.a.send({
              tag: 'irc',
              content: { msg: 'ircConfig:'.concat(JSON.stringify(r)) },
            })
            i.RtcService.on(
              'ready',
              Object(y.a)(
                Object(x.a)().mark(function t() {
                  return Object(x.a)().wrap(function (t) {
                    while (1) {
                      switch ((t.prev = t.next)) {
                        case 0:
                          console.info(
                            '箭头函数 监听 ready,filePath:renderer/components/Classroom/SmallClass/Live/index.vue'
                          ),
                            (w.a.prototype.thinkClass = i),
                            e.listenerRtcService(),
                            e.listenerSignalService(),
                            e.listenerEvent(),
                            e.sendLogger('irc\u3001rtc初始化完成', {
                              cameraAccessStatus: e.cameraStatus ? 1 : 0,
                              microphoneAccessStatus: e.microphoneStatus
                                ? 1
                                : 0,
                            }),
                            (e.onRtcServiceReady = true)
                        case 7:
                        case 'end':
                          return t.stop()
                      }
                    }
                  }, t)
                })
              )
            )
          },
          listenerEvent: function () {
            var e = this
            console.info(
              '对象函数 listenerEvent,filePath:renderer/components/Classroom/SmallClass/Live/index.vue'
            )
            this.$bus.$on('updateAchievement', function (t, n) {
              console.info(
                '箭头函数 监听 updateAchievement(type, num)',
                t,
                n,
                'filePath:renderer/components/Classroom/SmallClass/Live/index.vue'
              )
              'add' == t && e.$store.dispatch('smallClass/addGoldCoins', n)
              'update' == t &&
                e.$store.dispatch('smallClass/updateGoldCoins', n)
            })
          },
          listenerSignalService: function () {
            var e = this
            console.info(
              '对象函数 listenerSignalService,filePath:renderer/components/Classroom/SmallClass/Live/index.vue'
            )
            var t = this.thinkClass.SignalService
            this.thinkClass
            this.thinkClass.SignalService.on(
              'onRecvRoomDataUpdateNotice',
              function (t) {
                var n = t.key,
                  s = t.noticeContent
                if ('classmode' === n) {
                  var o = s
                  'object' !== Object(T.a)(s) && (o = Object(M.a)({}, n, s))
                  Object(bi.b)(
                    n,
                    o,
                    e.$t(
                      'classroom.modules.header.backConfirm.exitByCoursewareIdChange'
                    ),
                    e.$t('courses.confirmModal.confirm')
                  )
                }
                if ('video_bet_student' === n) {
                  return (
                    console.info(
                      "if(key === 'video_bet_student')为true触发return,path: /renderer/components/Classroom/SmallClass/Live/index.vue"
                    ),
                    void (s.pub && e.canShowOtherChild
                      ? e.$bus.$emit('remoteAudioStatus', true)
                      : e.$bus.$emit('remoteAudioStatus', false))
                  )
                }
                'all_onStage_closed' === n &&
                  e.$store.dispatch('smallClass/updateAllOnStageStatus', false)
                'teacher_video_mute' === n &&
                  e.$bus.$emit('teacher_video_mute', s)
              }
            )
            t.on('onRecvRoomMessage', function (t) {
              console.info(
                '箭头函数 监听 onRecvRoomMessage(res)',
                t,
                'filePath:renderer/components/Classroom/SmallClass/Live/index.vue'
              )
              t.content &&
                142 == t.content.type &&
                e.$bus.$emit('chats.correctMedalData', t.content)
              t.content &&
                'auto_feedback' === t.content.ircType &&
                e.handleFeedBackUpload(t.content.data)
            })
            t.on('onRecvPeerMessage', function (t) {
              console.info(
                '箭头函数 监听 onRecvPeerMessage(res)',
                t,
                'filePath:renderer/components/Classroom/SmallClass/Live/index.vue'
              )
              var n = t.content,
                s = n.type,
                o = n.coursewareId
              if (140 == s) {
                var a = n.parameter ? n.parameter : n.msg,
                  i = JSON.parse(a).correct_picrure_t
                i && e.$bus.$emit('chats.assignmentCheckedPush', i)
              }
              if ('uploadCourseware' === s) {
                if (window._isUploadingNativeCourseware) {
                  return void console.info(
                    'if(window._isUploadingNativeCourseware)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/index.vue'
                  )
                }
                new Ci({
                  userId: e.baseData.stuInfo.id,
                  planId: e.baseData.planInfo.id,
                  coursewareId: o,
                }).upload({
                  success: function () {},
                  fail: function () {},
                })
              }
            })
            t.on('onNetStatusChanged', function (t) {
              e.handleNetStatusChanged(t)
            })
            t.on('onKickoutNotice', function (t) {
              console.info(
                '箭头函数 监听 onKickoutNotice(res)',
                t,
                'filePath:renderer/components/Classroom/SmallClass/Live/index.vue'
              )
              e.handleKickoutNotice(t)
            })
          },
          sendDataToToast: function (e) {
            console.info(
              '对象函数 sendDataToToast(msg)',
              e,
              'filePath:renderer/components/Classroom/SmallClass/Live/index.vue'
            )
            Object(Si.a)({
              msg: e,
              duration: 2000,
              parentNode: document.getElementById('interactionController'),
            })
          },
          listenerRtcService: function () {
            var e = this
            console.info(
              '对象函数 listenerRtcService,filePath:renderer/components/Classroom/SmallClass/Live/index.vue'
            )
            var t = this.thinkClass.RtcService
            t.on('teacherJoinChannel', function (t) {
              console.info(
                '箭头函数 监听 teacherJoinChannel(teacherDeviceType)',
                t,
                'filePath:renderer/components/Classroom/SmallClass/Live/index.vue'
              )
              e.$store.dispatch(
                'smallClass/updateTeacherJoinChannelStatus',
                true
              )
              e.$store.dispatch('smallClass/updateTeacherDeviceType', t)
            })
            t.on('teacherLeaveChannel', function () {
              console.info(
                '箭头函数 监听 teacherLeaveChannel,filePath:renderer/components/Classroom/SmallClass/Live/index.vue'
              )
              e.$store.dispatch(
                'smallClass/updateTeacherJoinChannelStatus',
                false
              )
            })
            t.on('shareScreenLeaveChannel', function () {
              console.info(
                '箭头函数 监听 shareScreenLeaveChannel,filePath:renderer/components/Classroom/SmallClass/Live/index.vue'
              )
              e.$bus.$emit('teachrLiveCloseScreenShare')
            })
            t.on('localNetworkQuality', function (t, n) {
              e.$store.dispatch('smallClass/updateRtcDownlinkNetworkQuality', n)
            })
            t.on('localVideoStateChanged', function (t, n) {
              console.info(
                '箭头函数 监听 localVideoStateChanged(state, err)',
                t,
                n,
                'filePath:renderer/components/Classroom/SmallClass/Live/index.vue'
              )
              e.showNotification(e.VideoErrorMap, n)
            })
            t.on('localAudioStateChanged', function (t, n) {
              console.info(
                '箭头函数 监听 localAudioStateChanged(state, err)',
                t,
                n,
                'filePath:renderer/components/Classroom/SmallClass/Live/index.vue'
              )
              e.showNotification(e.AudioErrorMap, n)
            })
          },
          handleNetStatusChanged: function (e) {
            var t = e.netStatus
            this.$store.dispatch('smallClass/updateIrcNetStatus', t)
            var n = mi[t] || ''
            q.a.send({
              tag: 'ircStatus',
              content: { msg: n },
            })
          },
          handleKickoutNotice: function (e) {
            console.info(
              '对象函数 handleKickoutNotice(res)',
              e,
              'filePath:renderer/components/Classroom/SmallClass/Live/index.vue'
            )
            301 === e.code &&
              (this.$bus.$emit('live-kickout', true),
              q.a.send({ tag: 'student.IRCKick' }))
          },
          initMediaAccess: function () {
            var e = this
            return Object(y.a)(
              Object(x.a)().mark(function t() {
                var n, s
                return Object(x.a)().wrap(function (t) {
                  while (1) {
                    switch ((t.prev = t.next)) {
                      case 0:
                        if (
                          (console.info(
                            '对象函数 initMediaAccess,filePath:renderer/components/Classroom/SmallClass/Live/index.vue'
                          ),
                          (n = false),
                          (s = false),
                          e.isAudition)
                        ) {
                          t.next = 10
                          break
                        }
                        return (t.next = 6), Object(Q.c)()
                      case 6:
                        return (n = t.sent), (t.next = 9), Object(Q.f)()
                      case 9:
                        s = t.sent
                      case 10:
                        e.$store.dispatch('smallClass/updateCameraStatus', n),
                          e.$store.dispatch(
                            'smallClass/updateMicrophoneStatus',
                            s
                          )
                      case 12:
                      case 'end':
                        return t.stop()
                    }
                  }
                }, t)
              })
            )()
          },
          uploadLogs: function () {
            return Object(y.a)(
              Object(x.a)().mark(function e() {
                var t, n, s
                return Object(x.a)().wrap(function (e) {
                  while (1) {
                    switch ((e.prev = e.next)) {
                      case 0:
                        return (
                          console.info(
                            '对象函数 uploadLogs,filePath:renderer/components/Classroom/SmallClass/Live/index.vue'
                          ),
                          (e.next = 3),
                          Object(Xn.a)()
                        )
                      case 3:
                        ;(t = e.sent),
                          (n = t.uid),
                          (s = new gi.a({ userId: n })),
                          s.upload()
                      case 7:
                      case 'end':
                        return e.stop()
                    }
                  }
                }, e)
              })
            )()
          },
          handleFeedBackUpload: function (e) {
            var t = this
            return Object(y.a)(
              Object(x.a)().mark(function n() {
                var s, o, a
                return Object(x.a)().wrap(function (n) {
                  while (1) {
                    switch ((n.prev = n.next)) {
                      case 0:
                        if (
                          (console.info(
                            '对象函数 handleFeedBackUpload(content)',
                            e,
                            'filePath:renderer/components/Classroom/SmallClass/Live/index.vue'
                          ),
                          e.studentIds.includes(
                            t.$store.state.smallClass.baseData.stuInfo.id
                          ))
                        ) {
                          n.next = 4
                          break
                        }
                        return (
                          console.info(
                            'if(!content.studentIds.includes(_this9.$store.state.smallClass.baseData.stuInfo.id))为true触发return,path: /renderer/components/Classroom/SmallClass/Live/index.vue'
                          ),
                          n.abrupt('return')
                        )
                      case 4:
                        return (
                          (n.next = 6),
                          Object(Ys.default)({
                            width: window.screen.width,
                            height: window.screen.height,
                            feedback: true,
                          })
                        )
                      case 6:
                        return (
                          (s = n.sent),
                          (n.next = 9),
                          Object(Xs.a)(s, 'image/jpeg')
                        )
                      case 9:
                        if (
                          ((o = n.sent),
                          (a = o.url),
                          t.sendLogger(
                            '课中反馈上报截图',
                            { uploadUrl: a },
                            a ? 'info' : 'error'
                          ),
                          a)
                        ) {
                          n.next = 16
                          break
                        }
                        return (
                          console.info(
                            'if(!uploadUrl)为true触发return,path: /renderer/components/Classroom/SmallClass/Live/index.vue'
                          ),
                          n.abrupt('return')
                        )
                      case 16:
                        Object(K.d)({
                          screenshot: a,
                          planId: t.baseData.commonOption.planId,
                          feedbackId: e.feedbackId,
                        })
                          .then(function (n) {
                            console.info(
                              '箭头函数 feedbackUpdate的then(res)',
                              n,
                              'filePath:renderer/components/Classroom/SmallClass/Live/index.vue'
                            )
                            0 === n.code
                              ? (t.sendLogger('课中反馈上报成功', {
                                  screenshot: a,
                                  planId: t.baseData.commonOption.planId,
                                  feedbackId: e.feedbackId,
                                }),
                                t.uploadLogs())
                              : (console.error('反馈失败'),
                                t.sendLogger(
                                  '课中反馈上报失败',
                                  {
                                    screenshot: a,
                                    planId: t.baseData.commonOption.planId,
                                    feedbackId: e.feedbackId,
                                  },
                                  'error'
                                ))
                          })
                          .catch(function (n) {
                            console.info(
                              '箭头函数 catch(err)',
                              n,
                              'filePath:renderer/components/Classroom/SmallClass/Live/index.vue'
                            )
                            console.error(n)
                            t.sendLogger(
                              '课中反馈上报失败',
                              {
                                screenshot: a,
                                planId: t.baseData.commonOption.planId,
                                feedbackId: e.feedbackId,
                              },
                              'error'
                            )
                          })
                      case 17:
                      case 'end':
                        return n.stop()
                    }
                  }
                }, n)
              })
            )()
          },
          pushStudentDeviceInfo: function () {
            var e = this
            return Object(y.a)(
              Object(x.a)().mark(function t() {
                var n, s, o, a, i, r
                return Object(x.a)().wrap(function (t) {
                  while (1) {
                    switch ((t.prev = t.next)) {
                      case 0:
                        console.info(
                          '对象函数 pushStudentDeviceInfo,filePath:renderer/components/Classroom/SmallClass/Live/index.vue'
                        ),
                          (r = {
                            planId: e.baseData.commonOption.planId,
                            resolution: e.workAreaSize,
                            ircName:
                              null === (n = e.baseData) ||
                              void 0 === n ||
                              null === (s = n.configs) ||
                              void 0 === s
                                ? void 0
                                : s.stuIrcId,
                            ircChannel:
                              null === (o = e.baseData) ||
                              void 0 === o ||
                              null === (a = o.configs) ||
                              void 0 === a ||
                              null === (i = a.ircServer) ||
                              void 0 === i
                                ? void 0
                                : i.ircLocation,
                            reportChannel: e.reportChannel,
                            extra: '',
                          }),
                          Object(K.l)(r)
                            .then(function (e) {
                              console.info(
                                '箭头函数 _pushStudentDeviceInfo的then(res)',
                                e,
                                'filePath:renderer/components/Classroom/SmallClass/Live/index.vue'
                              )
                              0 !== e.code &&
                                console.error('pushStudentDeviceInfo error', e)
                            })
                            .catch(function (e) {
                              console.info(
                                '箭头函数 catch(err)',
                                e,
                                'filePath:renderer/components/Classroom/SmallClass/Live/index.vue'
                              )
                              console.error('pushStudentDeviceInfo error', e)
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
          sendLogger: function (e, t) {
            var n =
              arguments.length > 2 && void 0 !== arguments[2]
                ? arguments[2]
                : 'info'
            q.a.send({
              tag: 'student.live',
              level: n,
              content: {
                msg: e,
                params: t,
              },
            })
          },
        },
      },
      ki = wi,
      Li = (n('a7f4'), Object(U.a)(ki, A, j, false, null, '4153a374', null)),
      xi = Li.exports,
      yi = n('e417'),
      Ii = n('3898'),
      Pi = n('5f9e'),
      Oi = n('cf14'),
      Ai = n('2b6b'),
      ji = {
        name: 'SmallClass',
        components: {
          Loading: I.a,
          Header: P.a,
          ErrorStatus: O.a,
          Live: xi,
        },
        data: function () {
          return {
            isLoading: true,
            isLive: true,
            isWindowBlur: false,
            blurTimer: null,
            errorObject: {
              message: this.$t('classroom.modules.systemError.message'),
              showRefresh: true,
              isShow: false,
            },
            beginLoadingTime: new Date().getTime(),
            duration: '',
            subMessage: '',
            checkNetHealthIntervalId: null,
          }
        },
        mixins: [Pi.a],
        created: function () {
          var e = this
          this.init()
          this.$bus.$on(
            'sendErrorMsg',
            (function () {
              var t = Object(y.a)(
                Object(x.a)().mark(function t(n) {
                  var s, o, a, i, r, c, l, d
                  return Object(x.a)().wrap(function (t) {
                    while (1) {
                      switch ((t.prev = t.next)) {
                        case 0:
                          return (
                            console.info(
                              '箭头函数 监听 sendErrorMsg(res)',
                              n,
                              'filePath:renderer/components/Classroom/SmallClass/index.vue'
                            ),
                            (t.next = 3),
                            Object(Xn.a)()
                          )
                        case 3:
                          ;(s = t.sent),
                            (o = s.uid),
                            (a = e.$t(n.name)),
                            (i = n.code ? ', Code: '.concat(n.code) : ''),
                            (r = n.url ? ', Url: '.concat(n.url) : ''),
                            (c = n.msg ? ', Msg: '.concat(n.msg) : ''),
                            (l = ', Uid: ' + o),
                            (d =
                              ', Params: ' + JSON.stringify(n.requestParams)),
                            (e.subMessage = a + i + c + r + l + d)
                        case 12:
                        case 'end':
                          return t.stop()
                      }
                    }
                  }, t)
                })
              )
              return function (e) {
                return t.apply(this, arguments)
              }
            })()
          )
        },
        mounted: function () {
          q.a.send({
            tag: 'userTrack',
            content: { msg: '进入小班课堂' },
          })
          this.checkNetHealthIntervalId = setInterval(function () {
            Object(Oi.a)()
          }, Oi.b)
        },
        beforeDestroy: function () {
          console.info(
            '对象函数 beforeDestroy,filePath:renderer/components/Classroom/SmallClass/index.vue'
          )
          this.checkNetHealthIntervalId &&
            clearInterval(this.checkNetHealthIntervalId)
        },
        watch: {
          isLoading: function (e, t) {
            if (
              (console.info(
                '对象函数 isLoading(val, old)',
                e,
                t,
                'filePath:renderer/components/Classroom/SmallClass/index.vue'
              ),
              !e && t)
            ) {
              var n = +new Date(),
                s = Tt.a.parse(window.location.search)
              this.$sensors.track('enter_class_loading_duration', {
                beginLoadingTime: this.beginLoadingTime,
                endLoadingTime: n,
                duration: n - this.beginLoadingTime,
                planId: Number(s.planId),
                isPlayback: 1 === Number(s.playback),
              })
            }
          },
        },
        methods: {
          sendLogger: function (e) {
            var t =
                arguments.length > 1 && void 0 !== arguments[1]
                  ? arguments[1]
                  : {},
              n =
                arguments.length > 2 && void 0 !== arguments[2]
                  ? arguments[2]
                  : 'info'
            q.a.send({
              tag: 'smallClass',
              content: {
                msg: e,
                params: t,
              },
              level: n,
            })
          },
          errorMsgTip: function (e) {
            var t =
              !(arguments.length > 1 && void 0 !== arguments[1]) || arguments[1]
            console.info(
              '对象函数 errorMsgTip(message, showRefresh)',
              e,
              t,
              'filePath:renderer/components/Classroom/SmallClass/index.vue'
            )
            this.isLoading = false
            this.errorObject = {
              isShow: true,
              message: e,
              showRefresh: t,
              subMessage: '',
            }
          },
          init: function () {
            var e = this
            return Object(y.a)(
              Object(x.a)().mark(function t() {
                var n, s, o, a, i, r, c
                return Object(x.a)().wrap(function (t) {
                  while (1) {
                    switch ((t.prev = t.next)) {
                      case 0:
                        return (
                          console.info(
                            '对象函数 init,filePath:renderer/components/Classroom/SmallClass/index.vue'
                          ),
                          Object(Ii.c)(),
                          (n = Tt.a.parse(window.location.search)),
                          (s = {
                            planId: Number(n.planId),
                            courseId: Number(n.classId),
                            bizId: Number(n.bizId),
                            playback: Number(n.playback),
                            isParentAudition: Number(n.isParent),
                          }),
                          (t.next = 6),
                          Object(pt.b)(s).catch(function (t) {
                            console.info(
                              '箭头函数 getBaseData的catch(error)',
                              t,
                              'filePath:renderer/components/Classroom/SmallClass/index.vue'
                            )
                            console.error(t)
                            e.sendLogger(
                              '获取初始化数据base错误',
                              { error: t },
                              'error'
                            )
                          })
                        )
                      case 6:
                        return (
                          (o = t.sent),
                          (t.next = 9),
                          Object(pt.c)(s).catch(function (t) {
                            console.info(
                              '箭头函数 getInitModule的catch(error)',
                              t,
                              'filePath:renderer/components/Classroom/SmallClass/index.vue'
                            )
                            console.error(t)
                            e.sendLogger(
                              '获取初始化数据init错误',
                              { error: t },
                              'error'
                            )
                          })
                        )
                      case 9:
                        return (
                          (a = t.sent),
                          e.sendLogger('直播初始化数据', {
                            baseData: o,
                            initModule: a,
                          }),
                          (t.next = 13),
                          Object(pt.a)({ planId: Number(n.planId) })
                        )
                      case 13:
                        if (
                          ((i = t.sent),
                          e.$store.dispatch(
                            'smallClass/updateIsAuthorizedUserList',
                            i
                          ),
                          !o)
                        ) {
                          t.next = 28
                          break
                        }
                        if (((r = o.isPlayBack), !r)) {
                          t.next = 22
                          break
                        }
                        return (
                          console.info(
                            'if(isPlayBack)为true触发return,path: /renderer/components/Classroom/SmallClass/index.vue'
                          ),
                          e.errorMsgTip(
                            e.$t('classroom.smallClass.courseEnd'),
                            false
                          ),
                          t.abrupt('return')
                        )
                      case 22:
                        ;(e.isLive = !r),
                          (c = {
                            classId: o.commonOption.classId,
                            planId: o.commonOption.planId,
                            isPlayBack: r,
                            classType: n.subPlatformType,
                            isParent: o.commonOption.isParent,
                            packageId: o.planInfo.packageId,
                            from: n.from,
                            lessonType: n.lessonType,
                            isStartClass: false,
                          }),
                          Object(qs.A)(
                            o.planInfo.startStampTime,
                            o.planInfo.endStampTime
                          ) && (c.isStartClass = true),
                          Object(yi.b)(c),
                          (t.next = 31)
                        break
                      case 28:
                        return (
                          console.info(
                            'if(baseData)为false,触发return,path: /renderer/components/Classroom/SmallClass/index.vue'
                          ),
                          e.errorMsgTip(
                            e.$t('classroom.modules.systemError.message')
                          ),
                          t.abrupt('return')
                        )
                      case 31:
                        return (
                          (t.next = 33),
                          Object(Yn.a)().then(function (t) {
                            e.$store.dispatch(
                              'smallClass/updateDynamicEmojiLists',
                              t
                            )
                          })
                        )
                      case 33:
                        if (
                          (e.$store.dispatch('smallClass/updateBaseData', o),
                          Object(Ai.setTimeOffset)(
                            1000 * o.nowTime - new Date().getTime()
                          ),
                          Object(Ai.setPlanId)(n, true),
                          e.$store.dispatch('common/setTimeOffset', o.nowTime),
                          e.$store.dispatch('smallClass/updateInitModule', a),
                          !e.isLive)
                        ) {
                          t.next = 42
                          break
                        }
                        return (
                          e.$store.dispatch(
                            'smallClass/updateGoldCoins',
                            o.userInfo.userCoin
                          ),
                          (t.next = 42),
                          e.initClassStudent(o)
                        )
                      case 42:
                        Object(Ee.d)('canOnStage').then(function (t) {
                          console.info(
                            '箭头函数 isOpenTheFunc的then(hasAllOnStage)',
                            t,
                            'filePath:renderer/components/Classroom/SmallClass/index.vue'
                          )
                          var s = o.commonOption.isAudition
                          t && !s
                            ? e.initClassRoomData(n)
                            : (e.isLoading = false)
                        }),
                          Cs.nativeApi.setWindowAble('maximize', true),
                          Cs.nativeApi.setWindowAble('fullscreen', true),
                          Cs.nativeApi.setFullScreen(true)
                      case 46:
                      case 'end':
                        return t.stop()
                    }
                  }
                }, t)
              })
            )()
          },
          initClassRoomData: function (e) {
            var t = this
            return Object(y.a)(
              Object(x.a)().mark(function n() {
                var s, o, a, i
                return Object(x.a)().wrap(function (n) {
                  while (1) {
                    switch ((n.prev = n.next)) {
                      case 0:
                        return (
                          console.info(
                            '对象函数 initClassRoomData(query)',
                            e,
                            'filePath:renderer/components/Classroom/SmallClass/index.vue'
                          ),
                          (s = ''.concat(e.planId, '-allOnStageClosed')),
                          (n.next = 4),
                          Object(K.f)({ keys: [s] })
                        )
                      case 4:
                        ;(o = n.sent),
                          o &&
                            0 == o.code &&
                            ((i =
                              null === (a = o.data) || void 0 === a
                                ? void 0
                                : a.keyValPair),
                            i &&
                              'true' !== i[s] &&
                              (t.$store.dispatch(
                                'smallClass/updateAllOnStageStatus',
                                true
                              ),
                              t.$store.dispatch(
                                'smallClass/updateAllStageDone',
                                true
                              ))),
                          (t.isLoading = false)
                      case 7:
                      case 'end':
                        return n.stop()
                    }
                  }
                }, n)
              })
            )()
          },
          initClassStudent: function (e) {
            var t = this
            return Object(y.a)(
              Object(x.a)().mark(function n() {
                var s, o, a
                return Object(x.a)().wrap(function (n) {
                  while (1) {
                    switch ((n.prev = n.next)) {
                      case 0:
                        return (
                          console.info(
                            '对象函数 initClassStudent(baseData)',
                            e,
                            'filePath:renderer/components/Classroom/SmallClass/index.vue'
                          ),
                          (s = e.commonOption),
                          (n.next = 4),
                          Object(K.n)({
                            planId: s.planId,
                            classId: s.classId,
                          })
                        )
                      case 4:
                        ;(o = n.sent),
                          o &&
                            0 == o.code &&
                            ((a = o.data || []),
                            t.$store.dispatch('smallClass/initStudentList', a))
                      case 6:
                      case 'end':
                        return n.stop()
                    }
                  }
                }, n)
              })
            )()
          },
        },
      },
      Mi = ji,
      Ti = (n('e12e'), Object(U.a)(Mi, k, L, false, null, null, null)),
      Ri = Ti.exports,
      Bi = n('612a'),
      Di = (n('9e1b'), n('c618'), n('e8a0'), n('0b2c'), n('ddcf'))
    w.a.use(g.a)
    w.a.use(S.a)
    w.a.use(C.a)
    w.a.use(v.a)
    w.a.use(p.a)
    w.a.use(f.a)
    w.a.use(h.a)
    w.a.use(m.a)
    w.a.use(u.a)
    w.a.use(u.a.TextArea)
    w.a.prototype.$Modal = S.a
    w.a.prototype.$Message = d.a
    w.a.prototype.$Notification = l.a
    w.a.prototype.$bus = new w.a()
    Object(Di.a)(w.a)
    Object(Di.b)()
    new w.a({
      i18n: Ii.b,
      store: Bi.a,
      render: function (e) {
        return e(Ri)
      },
    }).$mount('#app')
  },
  '900f': function (e, t, n) {
    'use strict'
    n('35dc')
  },
  9044: function (e, t, n) {},
  '949e': function (e, t, n) {},
  '957b': function (e, t, n) {
    'use strict'
    n('42ec')
  },
  9858: function (e, t, n) {
    'use strict'
    n('fc4f')
  },
  9962: function (e, t, n) {
    'use strict'
    n('5711')
  },
  '9ac2': function (e, t) {
    e.exports = require('stream')
  },
  '9b0f': function (e, t) {
    e.exports = require('fs')
  },
  '9b244': function (e, t, n) {
    'use strict'
    n('62bf')
  },
  '9c71': function (e, t, n) {
    'use strict'
    n('2d81')
  },
  '9cdb': function (e, t, n) {},
  '9df9': function (e, t, n) {
    'use strict'
    n('50c44')
  },
  '9eaf': function (e, t, n) {},
  '9ee3': function (e, t) {
    function n(e) {
      var t = new Error("Cannot find module '" + e + "'")
      throw ((t.code = 'MODULE_NOT_FOUND'), t)
    }
    n.keys = function () {
      return []
    }
    n.resolve = n
    e.exports = n
    n.id = '9ee3'
  },
  '9f06': function (e, t, n) {},
  a1e9: function (e, t, n) {
    'use strict'
    n('e829')
  },
  a28b: function (e, t, n) {},
  a32b: function (e, t) {
    e.exports = require('path')
  },
  a6a2: function (e, t) {
    e.exports =
      'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEgAAABICAMAAABiM0N1AAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAAE4UExURUdwTPfBOPO3LvHBNvjKSf/hbvW1NP//AP/QTvjKQf3ngf7lf+2pIPnKQ/jKP/nXYO+/Lv3nfv3lgeylG/XHPOmdC/3YYOqhFO23MOulGfnRSPPDO+ykGPnPROmbCO2zLv3PSPnNQPnJQv/of//jePnNQu+vKOmhFumfEv3PRO2tKPfTUv7ga/3dYO+7NPvjePvhcu+vHfjHPvrPSOqiDP3idPzVUvK2JfTCMemeCeynFPnJQvnMQeyvK/fCNu6pFfvSTPzXWuujGOmZBv/mgPfLPvjGN/nKR/3dbvO+LvrPRPG1IfG6Iu+uGfvbZPG7Kv3levXFNOurEuypIP3eaO2rJu2jEu2nGu+5KPO9NO+6Mu+1LPzbX/W9KuunDvfJOe6wKe+rGPXBQO2zGO2tIPvNQu2tFPvTSI7gJnIAAAAxdFJOUwAvV/seMxgCCP73iHjR5PkQ2LHBQe1FqfmN7Z47v2brXnixbVqJmVDdatmHlLjN79+uTS0yAAAEMElEQVRYw9WY617aShTFQZAwVBGLeBdbe6ptPfWcJJBASLgEcLgIIUEkIRWURPr+b3D2hH4HZ/hy8gD/39pr7b1nJqHQ//aLc5vhfP19ur0Jzmf1t/RzA5q21I5U+8nOCaNOVfr1gZkTTXZQtfb4iTmv3Q4SpX5rm9Wjq44q4lo/H2cN/g2porTX+peR8wmrKhZr/dZHNs4BUpGKJaiMKTQudiqiEsZgdf4vFlBqVywJJbFaa+UHTBNy0SkhhInV+QRLaLdvJSQgXAWHBvsMXfT9rSQIpRIOKmMI7RADRygF2ecb9KGFT4FTFoigfmvQoA4tlkTC/b0QgFoAog2Nu0Cgx5wjjGuQWSNBK+jsTSg7TllAIhn8QWOfdrVi4BScwCICSlCGtkU47bZjCgImG2RAGVoYCeX2s9F2yuARpA8WUYUWTSLHkWXXKJQFAQXpU01afBf0yC+ybLRNs4lxlZj9hSL4q3nZkLt814Xa7sFtiUhK/H343qn9isvPsj/i+a69NAlIpCMbiY9fou9ZrWhuaH6v1+NJbQUTIVhHwbQBq7H/YV1h23juaL2xMu75XdmeOGZzjqukukfYAAS1pjBuF8/dYUVRlIoPJNIBJpqLVQlQoCofoIiwFSwujOeTl1ddV5TxqxeQyhHoSYhuiXoEFigbDP5Z0Q+H82N3NNafcjqQhr5sG44TTK4UoIDVb4EwwK0YvtjE1bSRrutTXR/3+KCZnDIiixtXAQWs2q8+GNZqrZB0DZzRcKiDqLHy6vOy6xacAjQ4EqE+MYAtla0AcScjQgKXAp94P9DkkFnBoihisQraRCzt7aVWrsadHyAJUPoTIYEmIJlAaqImUjtNVSVA6XadZjq/vgxIxHEfjIIWn5gm7JRmE2jwYelizdMpnk2P9PEfkvxig6gCoGbCbDYDnHgaXf+Yi+18C0iVHg89Towy/3zg1uF7tgDHnR9lYFjGvM93DcNotwuOCbpmTXT73o0SSmUzoImHVSAbhGWQCvEFxfHNbT0pFVJdt/tgG8/GM+yDZIxqf+egCxY9nve6Dw/AKkTmB1QHwU2xSCQt/K5HRLVN9JnuZNrJ5XKKNbY83/NAUSFyRXlUHtWLOpAqi4Xn8bYRSaboOFy6WMzlppa1WPiebUciYdpLQKYOoNxUsaA4e2J+p724xepLkGVZ/oPtnFFfAM8BtCQtPHdyl6IFcVngEJOmFhQWCdPfSE+WiqZKz3cnWxw9KL1UpFjAOWN5Z2WWiixfm9yxPLTjdQIqKpZmX0YZ9JDQAKRbQzaDQqFsIEj3teMztufaCVEEHPeO8f14RAobatpljBH0rV4nnOMDju2JHc/oQ8I5YeSEwkXC0dLM/yBuhiPQw2wQ7FngaBrzL4gQd01AOxv43ZMGzhHHLojLatqPVGgDH3dwE93IvzWOW/vd8B9jbyLv9RMC6QAAAABJRU5ErkJggg=='
  },
  a7cb: function (e, t, n) {
    'use strict'
    n('67c7')
  },
  a7f4: function (e, t, n) {
    'use strict'
    n('ad09')
  },
  a9a6: function (e, t, n) {
    'use strict'
    n.d(t, 'a', function () {
      return c
    })
    var s = n('d4ec'),
      o = n('bee2'),
      a = n('262e'),
      i = n('2caf'),
      r = (n('99af'), n('ff4a')),
      c = (function (e) {
        Object(a.a)(n, e)
        var t = Object(i.a)(n)
        function n() {
          return Object(s.a)(this, n), t.call(this)
        }
        return (
          Object(o.a)(n, [
            {
              key: 'logger',
              value: function (e) {
                var t = e.type,
                  n = void 0 === t ? 'info' : t,
                  s = e.msg,
                  o = void 0 === s ? '' : s,
                  a = e.params,
                  i = void 0 === a ? {} : a
                console[n](
                  '\u3010 ThinkClass '
                    .concat(n, ' \u3011')
                    .concat(o, ' ')
                    .concat(JSON.stringify(i))
                )
                window.thinkApi.logger(
                  n,
                  {
                    msg: o,
                    params: i,
                  },
                  '\u3010ThinkClass\u3011'
                )
              },
            },
          ]),
          n
        )
      })(r.EventEmitter)
  },
  aaf0: function (e, t, n) {
    'use strict'
    var s = function () {
        var e = this,
          t = e._self._c
        return t(
          'div',
          {
            class: ['error-wrapper', e.bgWhiteAuth ? 'bg-white' : ''],
          },
          [
            t('div', { staticClass: 'center' }, [
              t('div', { staticClass: 'error-status' }),
              t('div', { staticClass: 'message' }, [
                t('div', { staticClass: 'message-main' }, [
                  e._v(e._s(e.message)),
                ]),
                e.scene
                  ? t('p', { staticClass: 'message-sub' }, [
                      e._v(
                        ' ' +
                          e._s('Scene: '.concat(e.scene, '.')) +
                          ' ' +
                          e._s(e.subMessage) +
                          ' '
                      ),
                    ])
                  : e._e(),
              ]),
              t(
                'div',
                { staticClass: 'button-wrapper' },
                [
                  e.showRefresh
                    ? t(
                        'a-button',
                        {
                          class:
                            e.showBack || e.isClassLiveOrPlayback ? 'mr40' : '',
                          attrs: {
                            type: 'primary',
                            shape: 'round',
                            size: 'large',
                          },
                          on: { click: e.handleRefresh },
                        },
                        [e._v(' ' + e._s(e.$t('common.refresh')) + ' ')]
                      )
                    : e._e(),
                  e.showBack || e.isClassLiveOrPlayback
                    ? t(
                        'a-button',
                        {
                          staticClass: 'color-orange',
                          attrs: {
                            shape: 'round',
                            size: 'large',
                          },
                          on: { click: e.handleBack },
                        },
                        [
                          e._v(
                            ' ' +
                              e._s(
                                e.isClassLiveOrPlayback
                                  ? e.$t(
                                      'classroom.modules.systemError.backButtonName'
                                    )
                                  : e.$t('common.back')
                              ) +
                              ' '
                          ),
                        ]
                      )
                    : e._e(),
                ],
                1
              ),
            ]),
          ]
        )
      },
      o = [],
      a =
        (n('14d9'),
        n('caad'),
        {
          name: 'ErrorStatus',
          props: {
            message: {
              type: String,
              default: function () {
                return (
                  console.info(
                    '对象函数 default,filePath:renderer/components/Common/ErrorStatus.vue'
                  ),
                  this.$t('common.components.errorStatus.message')
                )
              },
            },
            isClassLiveOrPlayback: {
              type: Boolean,
              default: false,
            },
            scene: {
              type: String,
              default: '',
            },
            subMessage: {
              type: String,
              default: '',
            },
            showRefresh: {
              type: Boolean,
              default: true,
            },
            showBack: {
              type: Boolean,
              default: false,
            },
            backUrl: {
              type: String,
              default: '',
            },
          },
          computed: {
            bgWhiteAuth: function () {
              return (
                console.info(
                  '对象函数 bgWhiteAuth,filePath:renderer/components/Common/ErrorStatus.vue'
                ),
                [
                  'ClassLiving',
                  'PlaybackReadyClass',
                  'LivingReadyClass',
                  'PlayBack',
                ].includes(this.scene)
              )
            },
          },
          methods: {
            handleRefresh: function () {
              console.info(
                '对象函数 handleRefresh,filePath:renderer/components/Common/ErrorStatus.vue'
              )
              this.isClassLiveOrPlayback
                ? window.location.reload()
                : this.$emit('click-refresh')
            },
            handleBack: function () {
              console.info(
                '对象函数 handleBack,filePath:renderer/components/Common/ErrorStatus.vue'
              )
              this.isClassLiveOrPlayback
                ? (window.location.href = ''.concat(
                    window.location.origin,
                    '/#/courses'
                  ))
                : this.$router.push({ path: this.backUrl })
            },
          },
        }),
      i = a,
      r = (n('dc2d'), n('2877')),
      c = Object(r.a)(i, s, o, false, null, 'f910b7da', null)
    t.a = c.exports
  },
  ab6e: function (e, t, n) {
    e.exports = n.p + 'static/img/icon_flower_l.e1cd1cbd.png'
  },
  ad09: function (e, t, n) {},
  b146: function (e, t, n) {
    'use strict'
    n('82f9')
  },
  b293: function (e, t) {
    e.exports =
      'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEwAAABMCAMAAADwSaEZAAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAAGbUExURUdwTP////////////////////////////////////////////////////////////////////////////////////////////+tDf85Z/87cf+PHv+6GMHH0f+1Ev6GIf/IKf81XC+N//+nA7e9yf/DIP8+ef+dG6uzwfgqR7vBzUe+//+9HP/89//HJLO7x//BHjed/7G3w/f5+/+VHD6r///PLCiA/z2h///pzv/pwFXU/6OruwZm2v6RPkS3///XMyKX7bTs//9CiTSX//9Ag//ROEKx/4eUq0zF/52ltSyH//0wUuTw+Qd04SBnzk7L//VMSEyP/t3f5SR4/5WfsQZe1a/h///n6//12v/NKP+3JDKT//96pf9+sRbvaf90l/18JP/Fjzyn/5HZ/xLvhQ7vnQztq//17z6t///H2Qjrx/+fPARW0wXq3v+Yw0/iSTbilP+uX//PcP/r8cnR0//HUv/Zl//l5ZXROkK1//dAUNXZ3wrvt/9QaP/drWSx//9ehzzjbEaFy4u129HV3f+vNrPBNAh840ol6zAAAAAXdFJOUwAefJE9B7Uu9+zl1/uPUGbBNqsO39DLbf0MuwAABNZJREFUWMOt2PlbIjcYB/DhEkQRPHBATikqIlPkWhXxoLKeqF28RSziRdXV1a26du9ud9s/u0lgrEzeDODD+5PPMH6ebyaZTBKOkyuN2mhoMnc163TNXeYmg1Gt4Z5Z7UqTjpeUzqRsr19SKFt4RrUoFXVR2g5etjq0tVNNfNVqqo3rVLXyNVSrqrO61abnayx9WxVKo+LrKJXsSFF083VVt0y/avV8naVn9oO6ma+7mtUMSyfzT0JxLH5fuCtSP+hATQvmEnbin+/f3mWzlp9wxYFsQEsV9PMS3t657QEnLouFifF6qhc0QD/u9PUFAvaA3WnBmIWF8d3SEQKNL4QNDwfsqJyiFofHm2TcQ/fs/FzWnE57WYsLoFbxLnTqYcyNG4q0rPjY4ozh1lmlkQhzu3E2rNmdWRItznqxnowKaJ4QtsfcqB41pxzW+v/4kMxfZ/n810+f3g++eoGiidmcD28eHv65XV6OwPPbYzDJD/ne3nRvenDw1TTS+twYCwQsb35DlVwf2ct8+XJ0tCU1xWjSOTpv7UVcGiXb3d3F2XCXYuz4JLm+5PGkQqHR2JZ0Ji+PfWnknBVrJNmLXdRSd19gOGv56/j45CQ5suTZC4Visd+lGF96D5TSy/kerKUJRjSUDWMnp6dJEmw0NjdFYUqCUd+0HMKsBJueLWl9AefA9enpx/MkCXYYm/uTwlrIt5anMaIhbBZnw+MDJbv+eH5+mdzzpDKHsdgUnYxvh1rJ5/qJNvh+erZcbnc2e31+eXmZKgebGqIx3E4TgGEN9QCqdwIuPiIUM+vrI0tLntQoemJzQ0O/UP9mQnMPPb/u9/f3W1G2NMbEixGCeVKpUjAA02k4NT2acy+RhhtqTae3H69mSsFCo4foiS0s0M3k1ZyRvrj/Emk9/VizVmKePdLKqaGFX+lkvJEzMLBSJ/Q+wcrBYgRbADADByxS9mdmSLYeKYaDZUrBxregl90MYjNiNoIJEVQY8+DHP4UxqJlmrou+eDVTjoZ6gWD+xY2N+dXNzYmJlZV/k7iR4+MA1sUBX8vts6ur/dzXGRztD3whnFicF7GVJGklhDVz7M+4IGyfnZG/wosYe40wpCVJMAjTcboaFhTBxCJq5uuShrDx8aOjCITVslgJl7DNidXVb9/+Xl5mLWKgDgCSYW1+fiOxmEjcMm/rgoYGVV5fAjM+ny8c9H5g3mbmmmrBiBP2eb1+v3+NvQKHXie6mZhCoYJ+h9/BxgzQi06VH2NBksshgxmhKQh4ZuhhhVEw+WRqaHIEkqFW4mAOuWRocgSmbQgLBr1+L7Ju2ZgJ/KDQWJhgKNnt2rLAuksJfupAzOt1fFiLyN3VDn6EqXKEHd/lIfEjXEM7IxGhenwlvHB5XingJVVFFQuFz/F3xapWB2OxV1FjLpfrwOWanLwpyGJaxjK0ErPZbNg7OJiU3WbLL5BFLCpqctiTBTKnksOiNpetGqaquqkQsSiJ5pLBKjYV8HanhA0QzeaSS9ZWfSNWxgbK2SZraiRriyhiiEPRbEyM2iJCm9cnWFQG0ytq3Vaj7fCPgSjJdsH4Wmrr2fBHdu5vLpAGYzp13UcRkXjh4qaeo4jGHpI09vimsQdLjT3yavBhXGOPCRt8gNngo9UGH/o+6zj6P5pZJ+h/PvSoAAAAAElFTkSuQmCC'
  },
  b56f: function (e, t) {
    e.exports = require('original-fs')
  },
  b658: function (e, t) {
    e.exports = require('string_decoder')
  },
  ba09: function (e, t) {
    e.exports = require('tls')
  },
  ba79: function (e, t, n) {
    'use strict'
    n('ddce')
  },
  ba84: function (e, t) {
    e.exports =
      'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADIAAABkCAMAAADzNpNpAAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAAGPUExURUdwTCQkJCQkJBISEhYWFh8fHyAgIP/ADyEhIf+8DfvJVRERER4eHjQ0NCIiIv+7DP/ME/zKV//GETQ0NCgoKP+3DP/DTP/JVvvBSv/LEv/RFvm/Rv/PEhISEjMzM/m3LPmxJf/bWvvHPvu7MfmrH/muI/3TUf3ZV/eoHP3cbfvDOv3VUhQUFP7aXBYWFv3XVP3STP3PSvvGPfmzJvu9MvzLQv/ZWjY2Nvq5MPu/N/m0KiMjI/vBOP3fdP3XVi0tLf3NSCkpKfvBNv3Yav3LRf3XWfvJQv3PSPu+NP3STv3ecPeiFv++D/3NRf3aYfm1Lfq6Lf3VUPemGv3ecjAwMP3UVvm0KP3YZP3RSvvLUx4eHv+6DvvJRf/EEf3cafekGPvJQPmtH/q5OPedEP3WX/3TYhoaGhwcHP3VZv3RX/vMTvefFPerH/vDOP3QWvzNWfvEQv/BEPvDSvu+Pv3bZfq/Q/mnHf3UW//HEvvHTf/LFPzAKvWaDvm9Nf/JEvzQUP/NFP/QFfvLQPWXDfu5IVxGRcMAAAAddFJOUwAriPMIrBa/Z0Dx2M/WQis2rcrx8d8mJq1A8/FAnVf3WQAAB9hJREFUWMOV1o9XEukaB/C2NO3Htrtnf9zd20UIHUCQ+KEB0iyinIFjpCMoBjWJ6wGTAYOVFO04dza7f/j9Ps87IBCWvnQQiE/f53ned8Zu3Rq5fvj11x9u3WxNvHkzcTNx7w3WvZuG3DDm3ss3N42ZePnyhjH33v4tzPVjJt7+Lcy1Y/54+7ZrrhszcSrM9WP++Pjf017O9WImPn48PSVC5lox//n08dJcL2biHyZAFPPyGjE/fvokYk6tdn78Nvn3p0//9Jn/fZN89300Gp3aWlp+/vz1u/2nT+dsD777BiERhVh+/vr1U4g5m+3B2FfFZNQiEAiZs4HYJr9m7v4c5bqWqa59EWKz3bn7FXK7FwKxT4LM3PhXeo9Ge82/e0etUAjY1RMYF4Sb398XgoMeXgHGHvWHcF1zFrkzeQX5PtprXuzJnK0bM3rQY2LA0b5t7KXYbLdHDjg6UNdl76K0EYMeux3tNi9CRFk9M37VgDlk2Wre1m/mHo0+XNEpMeF31rh6BJU9HH24ume4P6Q3geFB/zw1xQITXu6bcD8ZGvTtLZCp0SE9NDDou78scUj32no6RETMnf6jNj7FKRBLgxMeXH2DfrS0xGRra3hThtbloB8uLU3xogk/H2q+fz3oDZhDpqbENg5uytCa7Pa+fEm6F/BIMme7IwY9uWyRXshVdc11Y0C2tliM3pQBI+42Y+Ndsjxw7EeOWVwD//rp/sHBQQprdnbzxebm5p99C29fvJidTaXwlVrz/u+/sbhfq1WZzKY2Zze/JPgwRaZaqzWbj8n8VGrWahyzSY9BQm/5cyykNO+f/Q7yuNQkQx8KMWz+ZHFwUK02m6WjxyBHIM1qTXTD/cxu9hbezFJVJGokjo6JsKF2RD/9Bi+64oA6aQpybJlatWolEePF3+4WVWuWziD2BDk6ssyrg4MPqZ3UjoXwcyf14eBVtUrTKpVKFtk7Pj4qnVFQs1OrVF9hfdjZ2Uml8PSB3lUrtQ7+ksHxHhMyZ2dnpdL7ZqdTqVTIWAsv8UGn0ywg4oxFl1A/esksvCezvr5uCbwi8b5jNk39TISoIKrKSNN1QoWOwmidwXplXekUCiVT18+01nEbokuM41ZLO9N1s9BMdA0LfwfEhNAgvAaEBCLBGIYXBsQ0lYKi+P1C+P0VpVDoEWPPIg027VYrzQZfUZQKIQKKYolWK2wYhhpvNCyCd16vpmkgLgjkVPihiBBT09LhloG6JNUiccR4W05NKxIhU3H7/USVhM80gyjL6eVOrJSGQ1VjhjcMkoTxFdxIQT+E3IWCywxlNG0XJKbGuyQetxsw1EzG9PkKCcVPIfRIFHwgSS3dkg0jZo87LCLF7TFDbofT6WRId7lAlEhF8UeoroLLVdRBwl6ZUhwNjyjMgcJWvOG0lgwFXZRCZcH4E4UAUjJE2lYKEQ+IfcOQ5XD6IpkB8RWUiJ+Xmwozi8Xkxa7z8BDEIVlEmreLlLUMpQQUt0UiSiLg8wXR/oXTu2Js2OcdjRORMo8Uw+u8wMSIuC3yxO92o7BgMfNMC4NM2x19hcUWDr3OtJYpmjkifmsRyQV1TkH7lNLoEWPRSvmCcEoahS0w6UtZQcpaRv+S+ILFpPasl3JJDJlSMlYvw4WtpZ2yPCIlnH6WsQrrTqxbWDo9KoV7EUNOXJIEpRSREh7ZC+0Lb2VC6d8XVzCTvLgYTqF9WZSdtPsmpShP2ESeMCliyOmwvLgwSGLTKzIfy2IuB+KOREjgwARyOZyxCxB5emMwZRqXJQgKy/kSCfeTSCTi9rsTCV/OVcwk0+jFmO5LkRxxpByGnSD6qsuXwClTIhE8BRI4yNQ9LsoVAwdZumzfHltBCm3MKjWTcPNKoJVVXJTJtDN8uLIRuzxjSLFPG2L7Q8FVVyDghkFZ7kDAtUoHeZcGNt2XIjm2+fQ7d3GPCXIMmQTtChFcYXT2Y/btS8JXMm4Yu1oGZ5l2hkrDk48ITtguuqeLUhIkD7KNjcGU6SyHqBtfAP0EAiRw5a9p4bC8srBh3wbJE/H8RWTBEFdMKEQEhgRIqLim8QkziPzlYYJbzDxuSzjLuGFc6BhAjnMAcqtmRmdyaCzY4/OSxKTsoZsf9h+b6Uw/CyX1oOmyFkQSW0+3Susu5ikTyc/M8MiYaNRNsSeKoZDGdS1Ox9Tt+EwjL8hJwxGPx3D+5RbMWlIPmUFzdZUATiQu4paMYxyLb0uNE07JUjMUs0BXJoaGHFZ6SA+hLK1FzS9QXdJMo5wlUvbMSI55NTa9KNPtn6amZ+j7ABkqC5uyiLsrb2SXeCSJ7/64ZaId5CAJ39bpxa4z3KZbuKo6JOkkz6SeRTOSpNppAoteakfT8K8ntTVEpJ1OTAud8AE7yWfrTMp5xGzznI02fs8w4pXebSFDpkslTqcl3yNlGoAobUVuIwiqlcaPFn5HUIjdrjo4pFxnUi+XT07oClCpNBnb4w23xAMv24tUlsplecplTjmvZ0U3MCp2B6qNb+Lh9cpt7kMlwZ1kzznlvF7Pe7rGHsN/AiirLb6P34gqBDVy4kEn9XNKOc/Wy3m6BKgdNYYDarQJiYU2RIbo5JzIZ6Rks9wOchBE5e0Z+LNHv7YpgjNO0AfIZ4tgBCAcZBn+o7KgWTGh731m8vkcE6jT6YSR4gKR42cHIkRV2SzKIvJ/ej3vnH3Bc7cAAAAASUVORK5CYII='
  },
  badb: function (e, t, n) {
    'use strict'
    n.d(t, 'a', function () {
      return s
    })
    n.d(t, 'b', function () {
      return o
    })
    var s = function () {
        var e = this,
          t = e._self._c
        e._self._setupProxy
        return t(
          'div',
          { staticClass: 'video-item video-remote video-audition' },
          [
            t('div', { staticClass: 'notice' }, [
              e._v(
                ' ' +
                  e._s(
                    e.$t(
                      'classroom.smallClass.videoGroup.localVideoAudition.notice'
                    )
                  ) +
                  ' '
              ),
            ]),
          ]
        )
      },
      o = []
  },
  bc48: function (e, t, n) {
    'use strict'
    n('867f')
  },
  bd12: function (e, t, n) {
    'use strict'
    var s = function () {
        var e = this,
          t = e._self._c
        return e.show
          ? t(
              'div',
              {
                staticClass: 'loading-wrapper',
                class: e.className,
                style: e.loadingStyle,
              },
              [e._m(0)]
            )
          : e._e()
      },
      o = [
        function () {
          var e = this,
            t = e._self._c
          return t('div', { staticClass: 'loading-contenter' }, [
            t('div', { staticClass: 'loading-logo' }, [
              t('img', { attrs: { src: n('c63e') } }),
            ]),
            t('div', { staticClass: 'loading-animation' }),
          ])
        },
      ],
      a = {
        name: 'Loading',
        props: {
          show: {
            default: true,
            type: Boolean,
          },
          size: {
            default: 'default',
            type: String,
            validator: function (e) {
              return (
                console.info(
                  '对象函数 validator(value)',
                  e,
                  'filePath:renderer/components/Common/Loading.vue'
                ),
                -1 !== ['small', 'default'].indexOf(e)
              )
            },
          },
          marginTop: {
            default: '0',
            type: String,
          },
          marginBottom: {
            default: '0',
            type: String,
          },
        },
        computed: {
          className: function () {
            return (
              console.info(
                '对象函数 className,filePath:renderer/components/Common/Loading.vue'
              ),
              'loading-'.concat(this.size)
            )
          },
          loadingStyle: function () {
            return (
              console.info(
                '对象函数 loadingStyle,filePath:renderer/components/Common/Loading.vue'
              ),
              {
                marginTop: this.marginTop,
                marginBottom: this.marginBottom,
              }
            )
          },
        },
      },
      i = a,
      r = (n('f761'), n('2877')),
      c = Object(r.a)(i, s, o, false, null, '92d727e8', null)
    t.a = c.exports
  },
  bd31: function (e, t, n) {
    'use strict'
    n('2f84')
  },
  bf49: function (e, t, n) {
    'use strict'
    n('07d1')
  },
  c0ca: function (e, t, n) {
    'use strict'
    n('33f6')
  },
  c0ee: function (e, t, n) {
    'use strict'
    n('9f06')
  },
  c63e: function (e, t) {
    e.exports =
      'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFAAAABQCAMAAAC5zwKfAAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAAA8UExURUdwTP/DL//DLv/BL//DLv/EL//DL//DLv/DL//CLv/DL//DL//CLf/DL//DL//DL//DLv/DL//DMv/DMGSQIxsAAAATdFJOUwDwcSTeYM1AwICojww0SLNSmhsrwQ8LAAABI0lEQVRYw+3X2a6DIBCAYbaBYXXh/d/1aE3UxtbjMhdtOv+l6BeiiYAQ5+tzLwhK2oGKjTW1Vn/HyQV8NzlzF8HRkfVV10BX38Ygg18FptICKB+70OAWDD4GNPIMaJentyAuv4l8FKx7IIjYdB7a3CdBArplWFoMUYHTiQhcZdDTgqt3yyCDdgTlkBmy1iLeBIcJ7Q6fB2txzpGCYwz+HuhWAR4BcR98LhwAU6vGlXIDaruZexBwAJy35dN2WtadNX++iESbiK8BDRYyULWXT0AvwTsxyCCDnwJaUhAjaCrQBFWSuNsESoytFiRpYzqVxc/kh0Mipaemj2tDHE62iWKCh7daDDLI4CeDhRoUPXSWFHysASpIUnAsK6QFp+Pjf3f8AVRMjNs7xw9TAAAAAElFTkSuQmCC'
  },
  c71c: function (e, t, n) {
    'use strict'
    n.d(t, 'b', function () {
      return p
    })
    n.d(t, 'c', function () {
      return v
    })
    n.d(t, 'a', function () {
      return C
    })
    var s = n('c7eb'),
      o = n('5530'),
      a = n('1da1'),
      i =
        (n('ac1f'),
        n('5319'),
        n('caad'),
        n('2532'),
        n('b0c0'),
        n('d3b7'),
        n('25f0'),
        n('8bbf')),
      r = n.n(i),
      c = n('c342'),
      l = n('a5bc'),
      d = n('02fc'),
      u = n('d0db'),
      m = n('e417'),
      h = function (e) {
        console.info(
          '箭头函数 jumpPlayBack(keyword)',
          e,
          'filePath:renderer/components/Classroom/SmallClass/index.js'
        )
        var n = window.location.href.replace(e, '/#/playback/live')
        window.location.href = n
      },
      p = (function () {
        var e = Object(a.a)(
          Object(s.a)().mark(function e(t) {
            var n,
              a,
              i,
              p,
              v,
              C,
              g,
              b,
              w,
              k,
              L,
              x,
              y,
              I,
              P,
              O,
              A,
              j,
              M,
              T,
              R,
              B,
              D,
              V,
              N,
              E,
              _,
              H,
              U,
              $,
              W,
              G,
              F,
              J,
              z,
              Q,
              K,
              q,
              X,
              Y,
              Z,
              ee,
              te,
              ne,
              se,
              oe,
              ae,
              ie,
              re,
              ce,
              le,
              de,
              ue,
              me,
              he,
              fe,
              pe,
              ve,
              Ce,
              Se,
              ge,
              be,
              we,
              ke,
              Le,
              xe,
              ye,
              Ie,
              Pe,
              Oe,
              Ae,
              je,
              Me,
              Te,
              Re,
              Be,
              De,
              Ve,
              Ne,
              Ee,
              _e,
              He,
              Ue,
              $e,
              We,
              Ge,
              Fe,
              Je,
              ze,
              Qe,
              Ke,
              qe,
              Xe
            return Object(s.a)().wrap(function (e) {
              while (1) {
                switch ((e.prev = e.next)) {
                  case 0:
                    return (
                      console.info(
                        '箭头函数 getBaseData(params)',
                        t,
                        'filePath:renderer/components/Classroom/SmallClass/index.js'
                      ),
                      (n = t.isParentAudition),
                      (a = {
                        bizId: t.bizId,
                        planId: t.planId,
                        courseId: t.courseId,
                        isParentAudition: n,
                      }),
                      (i = 1800),
                      (p = 900),
                      (v = 0),
                      (C = 0),
                      (g = 0),
                      r.a.$bus || (r.a.prototype.$bus = new r.a()),
                      (e.next = 11),
                      Object(c.m)(a)
                    )
                  case 11:
                    if (((b = e.sent), b && 0 == b.code)) {
                      e.next = 16
                      break
                    }
                    return (
                      console.info(
                        'if(!res || res.code != 0)为true触发return,path: /renderer/components/Classroom/SmallClass/index.js'
                      ),
                      r.a.prototype.$bus.$emit('sendErrorMsg', {
                        name: 'courses.playback.courseInformationError',
                        url: '/classroom-hub/classroom/student/basic',
                        code:
                          (null === (w = b) || void 0 === w
                            ? void 0
                            : w.code) || '',
                        msg:
                          (null === (k = b) || void 0 === k ? void 0 : k.msg) ||
                          '',
                        requestParams: a,
                      }),
                      e.abrupt('return', false)
                    )
                  case 16:
                    if (0 !== b.code) {
                      e.next = 50
                      break
                    }
                    if (
                      ((b = b.data),
                      (b.planInfo.etime = b.planInfo.endStampTime),
                      (b.planInfo.stime = b.planInfo.startStampTime),
                      (window._requestBasicTime = new Date().getTime()),
                      (window._requestBasicEnterServerTime = b.nowTime),
                      !(
                        1 * b.nowTime - 1 * b.planInfo.etime > i ||
                        1 == t.playback
                      ))
                    ) {
                      e.next = 37
                      break
                    }
                    if (
                      ((v = 1),
                      (L = window.location.href),
                      (x = '/largeClass.html'),
                      (y = '/smallClass.html'),
                      !L.includes(x))
                    ) {
                      e.next = 33
                      break
                    }
                    return (
                      console.info(
                        'if(url.includes(largeClassUrl))为true触发return,path: /renderer/components/Classroom/SmallClass/index.js'
                      ),
                      h(x),
                      e.abrupt('return')
                    )
                  case 33:
                    if (!L.includes(y)) {
                      e.next = 37
                      break
                    }
                    return (
                      console.info(
                        'if(url.includes(smallClassUrl))为true触发return,path: /renderer/components/Classroom/SmallClass/index.js'
                      ),
                      h(y),
                      e.abrupt('return')
                    )
                  case 37:
                    if (
                      ((g = b.planInfo.stime - b.nowTime), g < p && (C = 1), !v)
                    ) {
                      e.next = 50
                      break
                    }
                    return (e.next = 42), Object(l.d)(a)
                  case 42:
                    if (((I = e.sent), I && 0 === I.code)) {
                      e.next = 47
                      break
                    }
                    return (
                      console.info(
                        'if(!playBackRes || playBackRes.code !== 0)为true触发return,path: /renderer/components/Classroom/SmallClass/index.js'
                      ),
                      r.a.prototype.$bus.$emit('sendErrorMsg', {
                        name: 'courses.playback.playbackInformationError',
                        url: '/classroom-hub/playback/student/initEntry',
                        code:
                          (null === I || void 0 === I ? void 0 : I.code) || '',
                        msg:
                          (null === I || void 0 === I ? void 0 : I.msg) || '',
                        requestParams: a,
                      }),
                      e.abrupt('return', false)
                    )
                  case 47:
                    ;(P = b.stuInfo.goldNum),
                      (I.data.stuInfo.goldNum = P),
                      (b = I.data)
                  case 50:
                    if (((O = {}), (A = {}), !v)) {
                      e.next = 87
                      break
                    }
                    return (
                      (j = {
                        appId: b.configs.appId,
                        fid: b.configs.fileId,
                        teacherId: b.teacherInfo.id,
                        planId: a.planId,
                        bizId: a.bizId,
                      }),
                      (e.next = 56),
                      Object(c.s)(j)
                    )
                  case 56:
                    if (((M = e.sent), M && 0 == M.code)) {
                      e.next = 61
                      break
                    }
                    return (
                      console.info(
                        'if(!showVodAddressRes || showVodAddressRes.code != 0)为true触发return,path: /renderer/components/Classroom/SmallClass/index.js'
                      ),
                      r.a.prototype.$bus.$emit('sendErrorMsg', {
                        name: 'courses.playback.playbackInterfaceError',
                        url: '/classroom-hub/playback/student/showVodAddress',
                        code:
                          (null === M || void 0 === M ? void 0 : M.code) || '',
                        msg:
                          (null === M || void 0 === M ? void 0 : M.msg) || '',
                        requestParams: j,
                      }),
                      e.abrupt('return', false)
                    )
                  case 61:
                    if (((T = M.data.result || []), T.length)) {
                      e.next = 69
                      break
                    }
                    return (
                      console.info(
                        'if(!vodAddressResult.length)为true触发return,path: /renderer/components/Classroom/SmallClass/index.js'
                      ),
                      Object(m.d)('hw_video_player', {
                        result: 'start',
                        video_player_scene: '回放',
                        type: '起播',
                        video_player_url: '',
                      }),
                      Object(m.d)('hw_video_player', {
                        result: 'fail',
                        video_player_scene: '回放',
                        type: '起播',
                        video_player_url: '',
                        error_type: '播放地址为空',
                        error_msg: '错误码=无,错误描述=播放地址为空',
                      }),
                      u.a.send({
                        tag: 'load',
                        content: { msg: '未获取到回放地址' },
                      }),
                      r.a.prototype.$bus.$emit('sendErrorMsg', {
                        name: 'courses.playback.playbackSourceIsNull',
                        url: '',
                        code: '',
                        msg: '',
                        requestParams: j,
                      }),
                      e.abrupt('return', false)
                    )
                  case 69:
                    R = 0
                  case 70:
                    if (!(R < T.length)) {
                      e.next = 77
                      break
                    }
                    if (!T[R].address.includes('.m3u8')) {
                      e.next = 74
                      break
                    }
                    return (
                      (A = {
                        address: T[R].address,
                        protocol: S(T[R].address),
                      }),
                      e.abrupt('break', 77)
                    )
                  case 74:
                    R++, (e.next = 70)
                    break
                  case 77:
                    return (
                      (B = Object(o.a)({ playbackStatus: 1 }, a)),
                      (A.share = M.data.share),
                      (e.next = 81),
                      Object(c.r)(B)
                    )
                  case 81:
                    if (((O = e.sent), O && 0 == O.code)) {
                      e.next = 86
                      break
                    }
                    return (
                      console.info(
                        'if(!playback || playback.code != 0)为true触发return,path: /renderer/components/Classroom/SmallClass/index.js'
                      ),
                      r.a.prototype.$bus.$emit('sendErrorMsg', {
                        name: 'courses.playback.playbackStampError',
                        url: '/classroom-hub/playback/metainfo',
                        code:
                          (null === (D = O) || void 0 === D
                            ? void 0
                            : D.code) || '',
                        msg:
                          (null === (V = O) || void 0 === V ? void 0 : V.msg) ||
                          '',
                        requestParams: B,
                      }),
                      e.abrupt('return', false)
                    )
                  case 86:
                    0 === O.code && (O = O.data)
                  case 87:
                    return (
                      (N = a.bizId),
                      (E = b),
                      (_ = E.configs),
                      (H = void 0 === _ ? {} : _),
                      (U = E.planInfo),
                      ($ = void 0 === U ? {} : U),
                      (W = E.stuInfo),
                      (G = void 0 === W ? {} : W),
                      (F = E.counselorInfo),
                      (J = void 0 === F ? {} : F),
                      (z = E.teacherInfo),
                      (Q = void 0 === z ? {} : z),
                      (K = E.nowTime),
                      (q = E.stuLiveInfo),
                      (X = E.liveStatus),
                      (Y = void 0 === X ? {} : X),
                      (Z = E.pageKeyList),
                      (ee = H.appId),
                      (te = H.appKey),
                      (ne = H.ircRooms),
                      (se = H.videoPath),
                      (oe = H.stuIrcId),
                      (ae = H.mainTeacherVideo),
                      (ie = H.counselorTeacherVideo),
                      (re = H.reseeding),
                      (ce = H.skinType),
                      (le = Array.isArray(ne) ? ne : [ne]),
                      (de = G.userName),
                      (ue = G.nickName),
                      (me = G.id),
                      (he = G.realName),
                      (fe = G.goldNum),
                      (pe = G.englishName),
                      (ve = G.avatar),
                      (Ce = G.gradeId),
                      (Se = G.id),
                      (ge = G.id),
                      (be = $.id),
                      (we = $.startTime),
                      (ke = $.endTime),
                      (Le = $.stime),
                      (xe = $.subjectIds),
                      (ye = $.gradeIds),
                      (Ie = $.name),
                      (Pe = $.seriesId),
                      (Oe = $.bigImageUrl),
                      (Ae = $.notice),
                      (je = $.visitNum),
                      (Me = $.mode),
                      (Te = Y.streamMode),
                      (Re = q.classId),
                      (Be = q.teamId),
                      (De = q.courseId),
                      (Ve = q.isAudition),
                      (Ne = Q.id),
                      (Ee = Q.name),
                      (_e = Q.avatar),
                      (He = Q.spellName),
                      (Ue = O),
                      ($e = Ue.event),
                      (We = Ue.gotoClassTime),
                      (Ge = Ue.streamTime),
                      (Fe = +new Date()),
                      (Je = 1000 * K - Fe),
                      (e.next = 103),
                      Object(d.f)()
                    )
                  case 103:
                    return (
                      (ze = e.sent),
                      (Qe = {
                        mode: Me,
                        appId: ee,
                        appKey: te,
                        psId: Se.toString(),
                        password: ge.toString(),
                        stuName: de,
                        stuId: me,
                        planId: be,
                        isPlayBack: v,
                        teacherId: Ne,
                        videoPath: se,
                        bizId: N,
                        events: $e,
                        teacherName: Ee,
                        avatar: _e,
                        startTime: we,
                        endTime: ke,
                        subjectName: Ie,
                        seriesId: Pe,
                        bigImageUrl: Oe,
                        notice: Ae,
                        visitNum: je,
                        spellName: He,
                        mainTeacherVideo: ae,
                        counselorTeacherVideo: ie,
                        reseeding: re,
                        classId: Re,
                        skinType: ce,
                        nickName: ue,
                        isDisPath: false,
                        videoFile: A.address || '',
                        protocol: A.protocol || '',
                        shareVideoMap: A.share,
                        configs: {
                          dispatch: { '2.0': 'videogslb.thethinkacademy.com' },
                          log: 'log-live.thethinkacademy.com',
                          schoolcode: ze,
                        },
                      }),
                      (Ke = {
                        appId: ee,
                        appKey: te,
                        psId: Se.toString(),
                        password: ge.toString(),
                        nick: oe,
                        planId: be,
                        uid: me || Ne,
                        roomlist: le,
                      }),
                      (qe = {
                        streamMode: Te,
                        mode: Me,
                        bizId: N,
                        subjectIds: xe,
                        gradeIds: ye,
                        goldNum: fe,
                        realName: he,
                        nickName: ue,
                        englishName: pe,
                        stuName: de,
                        nick: oe,
                        stuId: me,
                        roomlist: le,
                        isPlayBack: v,
                        planId: be,
                        stime: Le,
                        gotoClassTime: We,
                        streamTime: Ge,
                        psId: Se,
                        imgPath: ve,
                        classId: Re,
                        teamId: Be,
                        skinType: ce,
                        courseId: De,
                      }),
                      (Xe = {
                        mode: Me,
                        stuName: de,
                        stuId: me,
                        isPlayBack: v,
                        planId: be,
                        nickName: ue,
                        realName: he,
                        englishName: pe,
                        bizId: N,
                        nowTime: K,
                        stime: Le,
                        stuIRCId: oe,
                        subjectIds: xe,
                        gradeIds: ye,
                        roomlist: le,
                        goldNum: fe,
                        classId: Re,
                        teamId: Be,
                        skinType: ce,
                        psId: Se,
                        avatar: _e,
                        gradeId: Ce,
                        streamMode: Te,
                        timeOffset: Je,
                        counselorInfo: J,
                        teacherInfo: Q,
                        configs: H,
                        classType: 2,
                        isParent: !!n,
                        isAudition: 1 === n || !!Ve,
                      }),
                      e.abrupt(
                        'return',
                        Object(o.a)(
                          Object(o.a)({}, b),
                          {},
                          {
                            isPlayBack: v,
                            isLiveStart: C,
                            countDown: g,
                            playerOptions: Qe,
                            ircInitOptions: Ke,
                            chatOptions: qe,
                            commonOption: Xe,
                            bizId: N,
                            stuInfo: G,
                            pageKeyList: Z,
                          }
                        )
                      )
                    )
                  case 109:
                  case 'end':
                    return e.stop()
                }
              }
            }, e)
          })
        )
        return function (t) {
          return e.apply(this, arguments)
        }
      })(),
      v = (function () {
        var e = Object(a.a)(
          Object(s.a)().mark(function e(t) {
            var n, o, a, i, r, l, d, u
            return Object(s.a)().wrap(function (e) {
              while (1) {
                switch ((e.prev = e.next)) {
                  case 0:
                    return (
                      (n = t.planId),
                      (o = t.classId),
                      (a = t.isParentAudition),
                      console.info(
                        '箭头函数 getInitModule(planId, classId, isParentAudition)',
                        n,
                        o,
                        a,
                        'filePath:renderer/components/Classroom/SmallClass/index.js'
                      ),
                      (i = {
                        planId: n,
                        classId: o,
                        isParentAudition: a,
                      }),
                      (e.next = 5),
                      Object(c.p)(i)
                    )
                  case 5:
                    if (((r = e.sent), (l = {}), 0 !== r.code)) {
                      e.next = 12
                      break
                    }
                    for (
                      console.info(
                        'if(res.code === 0)为true触发return,path: /renderer/components/Classroom/SmallClass/index.js'
                      ),
                        d = r.data.plugins,
                        u = 0;
                      u < d.length;
                      u++
                    ) {
                      l[d[u].moduleId] = d[u]
                    }
                    return e.abrupt('return', l)
                  case 12:
                    return e.abrupt('return', l)
                  case 13:
                  case 'end':
                    return e.stop()
                }
              }
            }, e)
          })
        )
        return function (t) {
          return e.apply(this, arguments)
        }
      })(),
      C = (function () {
        var e = Object(a.a)(
          Object(s.a)().mark(function e(t) {
            var n, o
            return Object(s.a)().wrap(function (e) {
              while (1) {
                switch ((e.prev = e.next)) {
                  case 0:
                    return (
                      console.info(
                        '箭头函数 fetchIsAuthorizedUserInfo(params)',
                        t,
                        'filePath:renderer/components/Classroom/SmallClass/index.js'
                      ),
                      (n = []),
                      (e.next = 4),
                      Object(c.e)(t)
                    )
                  case 4:
                    return (
                      (o = e.sent),
                      0 === o.code && (n = o.data.pageKeyList),
                      e.abrupt('return', n)
                    )
                  case 7:
                  case 'end':
                    return e.stop()
                }
              }
            }, e)
          })
        )
        return function (t) {
          return e.apply(this, arguments)
        }
      })()
    function S(e) {
      console.info(
        '函数申明 getProtocolByVideoUrl(url)',
        e,
        'filePath:renderer/components/Classroom/SmallClass/index.js'
      )
      var t = window.PSProtocol
      return e.indexOf('.mp4') > 0
        ? (console.info(
            "if(url.indexOf('.mp4') > 0)为true触发return,path: /renderer/components/Classroom/SmallClass/index.js"
          ),
          t.PS_MP4)
        : e.indexOf('.m3u8') > 0
        ? (console.info(
            "if(url.indexOf('.m3u8') > 0)为true触发return,path: /renderer/components/Classroom/SmallClass/index.js"
          ),
          t.PS_HLS)
        : void 0
    }
  },
  c7b1: function (e, t, n) {
    'use strict'
    n('4c0a')
  },
  cfa1: function (e, t, n) {},
  d15d: function (e, t, n) {
    'use strict'
    n.d(t, 'a', function () {
      return v
    })
    var s = n('c7eb'),
      o = n('1da1'),
      a = n('d4ec'),
      i = n('bee2'),
      r = n('262e'),
      c = n('2caf'),
      l = (n('a9e3'), n('99af'), n('d3b7'), n('159b'), n('0a4b')),
      d = n('c1f6'),
      u = n('d0db'),
      m = n('e417'),
      h = n('099c'),
      f = n('6543'),
      p = n('a9a6'),
      v = (function (e) {
        Object(r.a)(n, e)
        var t = Object(c.a)(n)
        function n() {
          var e,
            s =
              arguments.length > 0 && void 0 !== arguments[0]
                ? arguments[0]
                : {}
          Object(a.a)(this, n)
          e = t.call(this)
          var o = s.rtcConfig,
            i = void 0 === o ? {} : o,
            r = s.publishStatus,
            c = void 0 === r || r,
            l = i.token,
            d = i.teacherUid,
            u = i.teacherAudioUid,
            h = i.teacherVideoUid,
            f = i.teacherShareUid
          return (
            (e.teacherDeviceType = ''),
            (e.options = s),
            (e.token = l),
            (e.teacherUid = Number(d)),
            (e.teacherVideoUid = Number(h)),
            (e.teacherAudioUid = Number(u)),
            (e.teacherShareUid = Number(f)),
            (e.publishStatus = c),
            (e.rtcSensor = new m.a()),
            e._init(),
            e
          )
        }
        return (
          Object(i.a)(n, [
            {
              key: '_init',
              value: (function () {
                var e = Object(o.a)(
                  Object(s.a)().mark(function e() {
                    var t, n
                    return Object(s.a)().wrap(
                      function (e) {
                        while (1) {
                          switch ((e.prev = e.next)) {
                            case 0:
                              if (this.publishStatus) {
                                e.next = 2
                                break
                              }
                              return e.abrupt('return', this.createRtcChannel())
                            case 2:
                              return (e.next = 4), Object(h.b)()
                            case 4:
                              return (t = e.sent), (e.next = 7), Object(h.e)()
                            case 7:
                              if (((n = e.sent), 'not-determined' !== t)) {
                                e.next = 17
                                break
                              }
                              return (e.next = 11), Object(h.a)()
                            case 11:
                              if ('not-determined' !== n) {
                                e.next = 14
                                break
                              }
                              return (e.next = 14), Object(h.d)()
                            case 14:
                              this.createRtcChannel(), (e.next = 18)
                              break
                            case 17:
                              this.createRtcChannel()
                            case 18:
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
                function t() {
                  return e.apply(this, arguments)
                }
                return t
              })(),
            },
            {
              key: 'createRtcChannel',
              value: (function () {
                var e = Object(o.a)(
                  Object(s.a)().mark(function e() {
                    var t, n, o, a, i, r, c, u
                    return Object(s.a)().wrap(
                      function (e) {
                        while (1) {
                          switch ((e.prev = e.next)) {
                            case 0:
                              return (e.next = 2), Object(h.c)()
                            case 2:
                              return (t = e.sent), (e.next = 5), Object(h.f)()
                            case 5:
                              return (
                                (n = e.sent),
                                (e.next = 9),
                                l.nativeApi.getPathByName('userData')
                              )
                            case 9:
                              return (
                                (o = e.sent),
                                (a = ''.concat(o, '/Logs')),
                                (i = new d.a(this.token, { logsPath: a })),
                                (this.rtcEngine = i),
                                (r = i.setParameters(
                                  '{"che.audio.specify.codec":"OPUSFB","che.audio.bitrate.force":16000}'
                                )),
                                0 != r &&
                                  this.sendLogger(
                                    '音频设置,code:'.concat(r),
                                    {},
                                    'error'
                                  ),
                                (c = i.createChannel()),
                                (e.next = 18),
                                Object(f.b)(i)
                              )
                            case 18:
                              ;(u = this.publishStatus ? 1 : 2),
                                c.setClientRole(u),
                                this.publishStatus &&
                                  (i.enableLocalVideo(t),
                                  c.muteLocalAudioStream(!n),
                                  c.muteLocalVideoStream(!t)),
                                (this.rtcChannel = c),
                                this._rtcChannelListener(),
                                this.joinRtcChannel()
                            case 24:
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
                function t() {
                  return e.apply(this, arguments)
                }
                return t
              })(),
            },
            {
              key: 'joinRtcChannel',
              value: function () {
                this.rtcSensor.rtcSensorPush({ result: 'start' })
                var e = this.rtcChannel.joinChannel(
                  {
                    autoSubscribeAudio: true,
                    autoSubscribeVideo: true,
                    publishLocalAudio: true,
                    publishLocalVideo: true,
                  },
                  {
                    bitrate: 80,
                    frameRate: 10,
                    width: 160,
                    height: 120,
                  }
                )
                return (
                  0 == e
                    ? (this.emit('ready'),
                      this.sendLogger('调用加入频道码成功'))
                    : (this.sendLogger(
                        '调用加入频道码失败',
                        { res: e },
                        'error'
                      ),
                      this.rtcSensor.rtcSensorPush({
                        result: 'fail',
                        errorType: '调用加入房间接口失败',
                      })),
                  e
                )
              },
            },
            {
              key: '_rtcChannelListener',
              value: function () {
                var e = this
                this.rtcEngine.on('localVideoStateChanged', function (t, n) {
                  e.emit('localVideoStateChanged', t, n)
                  e.sendLogger(
                    '本地视频状态变更state:'.concat(t, ',err:').concat(n)
                  )
                })
                this.rtcEngine.on('localAudioStateChanged', function (t, n) {
                  e.emit('localAudioStateChanged', t, n)
                  e.sendLogger(
                    '本地音频状态变更state:'.concat(t, ',err:').concat(n)
                  )
                })
                this.rtcChannel.on(
                  'remoteVideoStateChanged',
                  function (t, n, s) {
                    t == e.teacherUid || t == e.teacherVideoUid
                      ? (2 == n && 0 == s && e.emit('teacherVideoStart', t),
                        0 === n && 5 === s && e.emit('teacherVideoMute', true),
                        2 === n && 6 === s && e.emit('teacherVideoMute', false))
                      : t !== e.teacherShareUid &&
                        (2 == n && 0 == s && e.emit('studentVideoStart', t),
                        0 === n &&
                          5 === s &&
                          e.emit('studentVideoMute', true, t),
                        2 === n &&
                          6 === s &&
                          e.emit('studentVideoMute', false, t))
                    e.emit('remoteVideoStateChanged', t, n, s)
                  }
                )
                this.rtcChannel.on(
                  'remoteAudioStateChanged',
                  function (t, n, s) {
                    ;(t != e.teacherUid && t != e.teacherAudioUid) ||
                      (2 === n && e.emit('teacherAudioStart'),
                      0 === n && 5 === s && e.emit('teacherAudioMute', true),
                      2 === n && 6 === s && e.emit('teacherAudioMute', false))
                    e.emit('remoteAudioStateChanged', t, n, s)
                  }
                )
                this.rtcChannel.on('localJoinChannel', function () {
                  e.emit('localJoinChannel')
                  e.sendLogger('本地加入频道成功')
                  e.rtcSensor.rtcSensorPush({ result: 'success' })
                })
                this.rtcChannel.on('rejoinChannelSuccess', function () {
                  e.emit('rejoinChannelSuccess')
                  e.sendLogger('本地重连加入频道成功')
                  e.rtcSensor.rtcSensorPush({ result: 'success' })
                })
                this.rtcChannel.on('remoteJoinChannel', function (t) {
                  t == e.teacherUid &&
                    ((e.teacherDeviceType = 'pc'),
                    e.emit('teacherJoinChannel', e.teacherDeviceType))
                  t == e.teacherAudioUid &&
                    ((e.teacherDeviceType = 'ipad'),
                    e.emit('teacherJoinChannel', e.teacherDeviceType))
                  t == e.teacherVideoUid && e.emit('teacherVideoJoinChannel')
                  e.emit('remoteJoinChannel', t)
                })
                this.rtcChannel.on('remoteLeaveChannel', function (t) {
                  'pc' == e.teacherDeviceType &&
                    t == e.teacherUid &&
                    (e.emit('teacherLeaveChannel', e.teacherDeviceType),
                    e.emit('teacherVideoLeaveChannel', t))
                  'ipad' == e.teacherDeviceType &&
                    t == e.teacherAudioUid &&
                    e.emit('teacherLeaveChannel', e.teacherDeviceType)
                  'ipad' == e.teacherDeviceType &&
                    t == e.teacherVideoUid &&
                    e.emit('teacherVideoLeaveChannel', t)
                  t == e.teacherShareUid && e.emit('shareScreenLeaveChannel')
                  e.emit('remoteLeaveChannel', t)
                })
                this.rtcChannel.on('rtcStats', function (t) {
                  e.emit('rtcStats', t)
                })
                this.rtcChannel.on('connectionStateChanged', function (t) {
                  e.emit('connectionStateChanged', t)
                  5 == t
                    ? e.rtcSensor.rtcSensorPush({
                        result: 'fail',
                        errorType: '连接失败',
                      })
                    : 4 == t &&
                      ((e.rtcSensor.isFirstJoinChannel = false),
                      e.rtcSensor.rtcSensorPush({ result: 'start' }))
                })
                this.rtcChannel.on('localNetworkQuality', function (t, n) {
                  e.emit('localNetworkQuality', t, n)
                })
                this.rtcEngine.on('warning', function (t) {
                  e.sendLogger('警告码\uFF1A'.concat(t), {}, 'warn')
                })
                this.rtcEngine.on('error', function (t, n) {
                  e.sendLogger(
                    '错误码\uFF1A'.concat(t, '\uFF0C错误信息\uFF1A').concat(n),
                    {},
                    'error'
                  )
                })
                this.rtcEngine.on(
                  'groupAudioVolumeIndication',
                  function (t, n, s) {
                    t.forEach(function (t) {
                      0 == t.uid
                        ? e.emit('localAudioVolume', t.volume)
                        : t.uid == e.teacherUid || t.uid == e.teacherAudioUid
                        ? e.emit('teacherAudioVolume', t.volume)
                        : e.emit('remoteAudioVolume', t.uid, t.volume)
                    })
                    e.emit('groupAudioVolumeIndication', t, n, s)
                  }
                )
                this.rtcEngine.on('lastMileQuality', function (t) {
                  e.emit('lastMileQuality', t)
                })
              },
            },
            {
              key: '_getTeacherVideoUid',
              value: function () {
                return 'pc' === this.teacherDeviceType
                  ? this.teacherUid
                  : this.teacherVideoUid
              },
            },
            {
              key: 'createLocalVideo',
              value: function (e) {
                this.rtcEngine.setupLocalVideo(document.getElementById(e))
              },
            },
            {
              key: 'setVideoEncoderConfiguration',
              value: function (e) {
                this.rtcChannel.setVideoEncoderConfiguration(e)
              },
            },
            {
              key: 'setCameraCapturerConfiguration',
              value: function (e) {
                this.rtcEngine.setCameraCapturerConfiguration(e)
              },
            },
            {
              key: 'muteLocalVideo',
              value: function (e) {
                this.rtcChannel.muteLocalVideoStream(e)
              },
            },
            {
              key: 'muteLocalAudio',
              value: function (e) {
                this.rtcChannel.muteLocalAudioStream(e)
              },
            },
            {
              key: 'createRemoteVideo',
              value: function (e, t) {
                this.rtcChannel.setupRemoteVideo(
                  Number(e),
                  document.getElementById(t)
                )
              },
            },
            {
              key: 'destroyRemoteVideo',
              value: function (e) {
                this.rtcChannel.destroyRemoteVideo(Number(e))
              },
            },
            {
              key: 'createTeacherVideo',
              value: function (e) {
                var t = this._getTeacherVideoUid()
                this.createRemoteVideo(t, e)
              },
            },
            {
              key: 'destroyTeacherVideo',
              value: function () {
                var e = this._getTeacherVideoUid()
                this.destroyRemoteVideo(e)
              },
            },
            {
              key: 'muteRemoteVideo',
              value: function (e, t) {
                this.rtcChannel.muteRemoteVideoStream(Number(e), t)
              },
            },
            {
              key: 'muteRemoteAudio',
              value: function (e, t) {
                this.rtcChannel.muteRemoteAudioStream(Number(e), t)
              },
            },
            {
              key: 'muteAllRemoteAudio',
              value: function (e) {
                this.rtcChannel.muteAllRemoteAudioStreams(e)
              },
            },
            {
              key: 'publish',
              value: function (e) {
                var t = e.publishAudio,
                  n = void 0 === t || t,
                  s = e.publishVideo,
                  o = void 0 === s || s
                this.rtcChannel.setClientRole(1)
                n && this.rtcChannel.muteLocalAudioStream(false)
                o && this.rtcChannel.muteLocalVideoStream(false)
              },
            },
            {
              key: 'unpublish',
              value: function () {
                this.rtcChannel.setClientRole(0)
                this.rtcChannel.muteLocalAudioStream(true)
                this.rtcChannel.muteLocalVideoStream(true)
              },
            },
            {
              key: 'leaveChannel',
              value: function () {
                this.rtcChannel.leaveChannel()
              },
            },
            {
              key: 'enableLocalVideo',
              value: function (e) {
                this.rtcEngine.enableLocalVideo(e)
                this.rtcChannel.muteLocalVideoStream(!e)
              },
            },
            {
              key: 'setVideoDevice',
              value: function (e) {
                this.rtcEngine.setVideoDevice(e)
              },
            },
            {
              key: 'setAudioRecordingDevice',
              value: function (e) {
                this.rtcEngine.setAudioRecordingDevice(e)
              },
            },
            {
              key: 'subscribe',
              value: function (e, t) {
                return this.rtcEngine.subscribe(
                  Number(e),
                  document.getElementById(t)
                )
              },
            },
            {
              key: 'setupViewContentMode',
              value: function (e) {
                var t =
                  arguments.length > 1 && void 0 !== arguments[1]
                    ? arguments[1]
                    : 1
                return this.rtcEngine.setupViewContentMode(
                  Number(e),
                  t,
                  this.rtcEngine.channel
                )
              },
            },
            {
              key: 'setAudioPlaybackDevice',
              value: function (e) {
                this.rtcEngine.setAudioPlaybackDevice(e)
              },
            },
            {
              key: 'resizeRender',
              value: function (e) {
                this.rtcEngine.resizeRender(e)
              },
            },
            {
              key: 'enableLastmileTest',
              value: function () {
                return this.rtcEngine.enableLastmileTest()
              },
            },
            {
              key: 'disableLastmileTest',
              value: function () {
                return this.rtcEngine.disableLastmileTest()
              },
            },
            {
              key: 'release',
              value: function () {
                if (this.rtcEngine) {
                  return this.rtcEngine.release(true)
                }
              },
            },
            {
              key: 'sendLogger',
              value: function (e) {
                var t =
                    arguments.length > 1 && void 0 !== arguments[1]
                      ? arguments[1]
                      : {},
                  n =
                    arguments.length > 2 && void 0 !== arguments[2]
                      ? arguments[2]
                      : 'info'
                u.a.send({
                  tag: u.b.rtc,
                  level: n,
                  content: {
                    msg: e,
                    params: t,
                  },
                })
              },
            },
          ]),
          n
        )
      })(p.a)
  },
  d190: function (e, t) {
    e.exports =
      'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEIAAABACAMAAACZQlHRAAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAAFHUExURUdwTO2jIf/ZZv/nfOyhHeGOEOibF//NMumkJf/nheOTDOmVEN+JBN6HAv7nfv/wjt2EAP/wjd+LAvSsJv3pgeGMCPvNRve2Mv/dZP3FQfWxKvW3NP/kePm/Ov/ri+mZFv/UVNuDAP3fb//xkf3zl/31nf/1m/3PSu+bGv3RTNuDANuDAP/ZXP3XVv/bYP7QS/3LSPvHRP3TWP7UUvvEPv3NTPWfFfrBOvi3L/OVC/e9PNuDAP/bXvKmH/WvJt6EAOGGAP/dYveqIPWjGv/of/e7OP/hbPOpJumNAvSbEfGuLOWIAPm6NPGfHPGbGPGTCO2QBe2VDPezKv3LRP/2mvWxMPanG/GPBuWLBOKRC/OZDO2LAv/fZv/lePu/OvW1Mv/kcv/tiuqdF/mvJO2pJPOxKv3TUP/xke2jHvm/NvOZDv/ZWvejFoU9ZmUAAAAsdFJOUwD0OyqOH/kEEv1EWnTCtxaQeNvR9TRQxWi1dFzM6Ye1lPHrVu/fl+nf0+Wjs1rp8gAABMBJREFUWMPtl+dX4loUxXVGpFieY1vP9sbprxAgIaGEDoZICVUEQYqgMZb///Pb54aZVwSi+HXuWiy+6G/tvc859x4WFn6e5x/Hm7evA9j3j3jh8FWQ/UbPJ2Q//jI/wZVvyLxw2V2fm2BbzDd4SRC63V/nDWJLbShAeLLd7TmtLGlqX5agIpt1rtvn0bCiqXlFBoFknLybA7GzGGNhgpDKDrrbL6+s43fNyPdFHyEgY+A8fLGV95pGIiSBc7s9HqRx8ttLoyxp10gCPtxuxuh2nW9eRFgpmSIEiSEYw7n9EsbKUNNYT0hMhYchTpzOT88u55JmqPlGn5IQou4oQ6SIcbX+rLrYXWjKRp+CoJ5wc8zHWMft7fonq8o49rd6RUWRFVkWfUAAEI0yRMrUcXv7+euMTBwHe7Is93r44BtJ6BxHWRCDThaZQsjZ2Zd3jokGdvdkMRgUe3KxGFJ6okhh+gVTBYuDGAMIOcP5MmHuDo5EWVaUUK0WH9VqYIxVcFxUiEajHs8YMujCDBhPZ2ZX7hVD8ZGaTp+fp0fxWrHHmyoemIyoZyzkEj02BbGlqrFMgB1ihEJFUiH5BaQR5RiDZUoMFObs7Gl1l4dVnPB9OPcYOE/Ha6FiT+R9kh8yHvD/UcFjekldYuKA+Po0is1W67RTqYbb7ZyWyaRHtaIsiiTDz6EzOEoDpUkJsDLoXl19npDmaiJJjHK7Hcg9/kuGoAvcAxsTaGGBkpOrSVNrX0smC63TSjnczj1q6dEIYYg8GLofRWEt6h4P3GX3ZPJVavuQSBZOK5XyfS7wmEnH46EQGD4Wxz8MGEnByZSrw5VIJGGmWm7nAkgDVhTSweJAWVgkDHI5OJk2bBsRk1Ftl1CUNNJQgiKrLOmAEowcR0YGh1NHZC2SSBRarWr7PpDRVFgpKqYXLxPCKByu0sH0h8nx51gHMWJptVYr3qG0YEDIGMLRff52+ry7IpFIgnkJBDKo7E2fZp4nIagMO6Ti46wbY4MQBTMO6IAXQILIFGa8kl/XdWq1mS+b48N3GTkw0tBxoyjiWIhXkrxgCNzxzEtrLAMdBoYWo9L27+SgKDIlkk7JCrOfeaSBqpxiWO4hIxNTkQd5kXnqVJ+P7HC7s+9epqJVqYTD6FKNGDWWBzrEB4jk071+i+dk0zTSLDPGDx3IgwVCifhtsxFrkQhTUcblUSqVgEAeYJAVXx1OEKndCoEsCp1ms1yGjFwgEKOyhPrBoFkXML5ZvCN/kYrTjsnIlTAtrCzFuyDag6+jrt4/LBA0a1BhIqo5XGHn351QqyMLfc8Cscri7FSanXIzjDQCGQNNisGnmtTr1KXHdktEIdkhFaYTqIip6g3e6CBrL6+kH1utBRRnhxhlqggmRYupBiBoUr7OQ4RutYO6oMLMokppxmKGZgyHQ+P6GnHwdYjw7lrteaymnWoTGjQDBGN4wc4QEJkxLJrTbiMV1FZYc3CM5ferrp2dlY1NULB8iXWv12a1X7D7wgTkjcWlH39vW127WCYh3yyXnETyojrE3pvPXy8u/XeLcKy8X7w+st7ZoBg7a6OR/z9gbNRhvWqtXiD+/GTAs5dW45UACu7AZV945bHbX4/4+dN6zvM3+0yHfS6UANUAAAAASUVORK5CYII='
  },
  d1e5: function (e, t, n) {},
  d202: function (e, t, n) {
    'use strict'
    n.d(t, 'a', function () {
      return d
    })
    var s = n('c7eb'),
      o = n('1da1'),
      a = n('d4ec'),
      i = n('bee2'),
      r = (n('99af'), n('d3b7'), n('e6cf'), n('a79d'), n('383d')),
      c = n('d0db'),
      l = n('c8f5'),
      d = (function () {
        function e() {
          Object(a.a)(this, e)
        }
        return (
          Object(i.a)(e, [
            {
              key: 'upload',
              value: (function () {
                var e = Object(o.a)(
                  Object(s.a)().mark(function e(t) {
                    var n,
                      o,
                      a,
                      i,
                      r = this
                    return Object(s.a)().wrap(
                      function (e) {
                        while (1) {
                          switch ((e.prev = e.next)) {
                            case 0:
                              return (e.next = 2), this._getToken()
                            case 2:
                              ;(n = e.sent),
                                (o = 1000 * n.timestamp - new Date().getTime()),
                                (a = {
                                  accessKeyId: n.accessKey,
                                  secretAccessKey: n.accessSecret,
                                  sessionToken: n.sessionToken,
                                  region: n.region || 'us-west-2',
                                  bucket: n.bucketName,
                                  useAccelerateEndpoint: true,
                                  systemClockOffset: o,
                                  httpOptions: { timeout: 300000 },
                                }),
                                (i = {
                                  useFoldersForFileTypes: false,
                                  useIAMRoleCredentials: false,
                                  uploadFolder: ''
                                    .concat(n.finalScene, '/')
                                    .concat(
                                      null === t || void 0 === t
                                        ? void 0
                                        : t.uploadFolder
                                    ),
                                }),
                                l(
                                  ''.concat(
                                    null === t || void 0 === t
                                      ? void 0
                                      : t.uploadPath
                                  ),
                                  a,
                                  i
                                )
                                  .then(function (e) {
                                    var n
                                    null === t ||
                                      void 0 === t ||
                                      null === (n = t.success) ||
                                      void 0 === n ||
                                      n.call(t, e)
                                  })
                                  .catch(function (e) {
                                    var n
                                    null === t ||
                                      void 0 === t ||
                                      null === (n = t.fail) ||
                                      void 0 === n ||
                                      n.call(t, e)
                                    r.sendLogger(
                                      's3上传失败'.concat(e),
                                      'error'
                                    )
                                  })
                                  .finally(function () {
                                    var e
                                    null === t ||
                                      void 0 === t ||
                                      null === (e = t.final) ||
                                      void 0 === e ||
                                      e.call(t)
                                  })
                            case 7:
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
                  return e.apply(this, arguments)
                }
                return t
              })(),
            },
            {
              key: '_getToken',
              value: (function () {
                var e = Object(o.a)(
                  Object(s.a)().mark(function e() {
                    var t, n
                    return Object(s.a)().wrap(
                      function (e) {
                        while (1) {
                          switch ((e.prev = e.next)) {
                            case 0:
                              return (
                                (t = {
                                  scene: 'pcAgoralog/*',
                                  target: 's3',
                                }),
                                (e.next = 3),
                                Object(r.f)(t)
                              )
                            case 3:
                              if (((n = e.sent), n && 0 == n.code)) {
                                e.next = 7
                                break
                              }
                              return (
                                this.sendLogger(
                                  '上传到S3获取Token失败, params: '
                                    .concat(JSON.stringify(t), ', res: ')
                                    .concat(JSON.stringify(n))
                                ),
                                e.abrupt('return', false)
                              )
                            case 7:
                              return e.abrupt('return', n.data)
                            case 8:
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
                function t() {
                  return e.apply(this, arguments)
                }
                return t
              })(),
            },
            {
              key: 'sendLogger',
              value: function (e) {
                var t =
                  arguments.length > 1 && void 0 !== arguments[1]
                    ? arguments[1]
                    : 'info'
                c.a.send({
                  tag: 'uploadS3',
                  content: { msg: e },
                  level: t,
                })
              },
            },
          ]),
          e
        )
      })()
  },
  d3b5: function (e, t, n) {},
  d787: function (e, t) {
    e.exports = require('punycode')
  },
  dc2d: function (e, t, n) {
    'use strict'
    n('17c8')
  },
  ddce: function (e, t, n) {},
  debb: function (e, t) {
    e.exports =
      'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADAAAAAwBAMAAAClLOS0AAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAAAYUExURUdwTP///////77DzKOruf///62zwaOrud8WV5gAAAAHdFJOUwAUCDblEHJz81ZjAAAA/klEQVQ4y41USw7CIBBtTdyXal23vYEJ0bXpoltJ0wMYFx5A41zfUhigwEucDTAvb37MTFGw9LMQc1/EslNilaaN9MJJC/RbRIVA4/Wd2EidNRQa62KgBgSmlClQpSEFgWUsGVtlDqhyMXFc9noxx9M+nYsTDfqQ9GAne3O50ucsxGGkt3nf2feLNEUSfdm79X2khbIQ6MbeLaB1g6TVoAE4b60cyYSw5s6ApnjCAricpAYG9/SApjjCX0BsCjqH4cIEw5JMnlKHRVRrEZUt4qbsU1B2/1Fq+1Hwa3EzwPaBDQdbFDc1HAM4OHjU4HDiccYLgGuc6D0nXjLpWvoBPFBsmiujR/4AAAAASUVORK5CYII='
  },
  df5f: function (e, t, n) {
    'use strict'
    n('b0c0')
    var s = function () {
        var e = this,
          t = e._self._c
        return t(
          'div',
          {
            directives: [
              {
                name: 'show',
                rawName: 'v-show',
                value: e.chatBox.isShowBox,
                expression: 'chatBox.isShowBox',
              },
            ],
            staticClass: 'chat-box-container',
            class: {
              'on-wholeOnsatge': e.isWholeOnsatge,
              playBack: e.isPlayBack,
            },
          },
          [
            e.showHeader
              ? t('div', { staticClass: 'chat-box-head' }, [
                  t('div', { staticClass: 'title' }, [
                    e._v(e._s(e.$t('classroom.chats.chats.chatbox'))),
                  ]),
                  t(
                    'div',
                    {
                      staticClass: 'close',
                      on: { click: e.handleIsShowBox },
                    },
                    [
                      t('img', {
                        attrs: {
                          src: n('debb'),
                          alt: '',
                        },
                      }),
                    ]
                  ),
                ])
              : e._e(),
            t(
              'div',
              {
                staticClass: 'chat-box-content',
                attrs: { id: 'chat-list' },
              },
              [
                t(
                  'ul',
                  { staticClass: 'chat-ul' },
                  [
                    e._l(e.chatList, function (s, o) {
                      return [
                        't' === s.role || 'f' === s.role
                          ? t(
                              'li',
                              {
                                key: o,
                                staticClass: 'left-li',
                              },
                              [
                                t('div', { staticClass: 'msg-header' }, [
                                  t(
                                    'div',
                                    {
                                      staticClass: 'avatar avatar-teacher',
                                      class: { 'avatar-f': 'f' === s.role },
                                    },
                                    [
                                      t('img', {
                                        attrs: { src: s.content.path },
                                      }),
                                    ]
                                  ),
                                  t('div', { staticClass: 'nickname' }, [
                                    e._v(e._s(s.content.name)),
                                  ]),
                                  s.content.to_uid
                                    ? t('div', { staticClass: 'msg-private' }, [
                                        e._v(
                                          ' \u3010' +
                                            e._s(
                                              e.$t(
                                                'classroom.chats.chats.privateMessage'
                                              )
                                            ) +
                                            '\u3011 '
                                        ),
                                      ])
                                    : e._e(),
                                ]),
                                t(
                                  'div',
                                  {
                                    staticClass: 'msg-box msg-box-teacher',
                                    class: { 'msg-box-f': 'f' === s.role },
                                  },
                                  [e._v(' ' + e._s(s.content.msg) + ' ')]
                                ),
                              ]
                            )
                          : e._e(),
                        's' === s.role && s.userId != e.baseData.stuInfo.id
                          ? t(
                              'li',
                              {
                                key: o,
                                staticClass: 'left-li',
                              },
                              [
                                t('div', { staticClass: 'msg-header' }, [
                                  t('div', { staticClass: 'avatar' }, [
                                    t('img', {
                                      attrs: { src: s.content.path },
                                    }),
                                  ]),
                                  t('div', { staticClass: 'nickname' }, [
                                    e._v(' ' + e._s(s.content.name) + ' '),
                                  ]),
                                ]),
                                s.content.isNewEmoji
                                  ? t('EmoticonMessage', {
                                      staticStyle: {
                                        'margin-left': '40px',
                                        'margin-top': '-12px',
                                      },
                                      attrs: {
                                        willAutoClear: false,
                                        name: s.content.msg,
                                        type: s.content.emojiType,
                                        emojiId: s.content.emojiId,
                                        width: 70,
                                        height: 70,
                                        lottieUrl: s.content.lottieUrl,
                                        loopLottie: true,
                                      },
                                    })
                                  : t('div', { staticClass: 'msg-box' }, [
                                      e._v(e._s(s.content.msg)),
                                    ]),
                              ],
                              1
                            )
                          : e._e(),
                        s.userId == e.baseData.stuInfo.id
                          ? t(
                              'li',
                              {
                                key: o,
                                staticClass: 'right-li',
                              },
                              [
                                t('div', { staticClass: 'msg-header' }, [
                                  s.content.to_uid &&
                                  s.content.to_uid === e.baseData.teacherInfo.id
                                    ? t('div', { staticClass: 'msg-private' }, [
                                        e._v(
                                          ' \u3010' +
                                            e._s(
                                              e.$t('classroom.chats.chats.To')
                                            ) +
                                            ' ' +
                                            e._s(
                                              e.$t(
                                                'classroom.chats.chats.sendToTeacher'
                                              )
                                            ) +
                                            '\u3011 '
                                        ),
                                      ])
                                    : e._e(),
                                  t('div', { staticClass: 'nickname' }, [
                                    e._v(e._s(s.content.name)),
                                  ]),
                                  t(
                                    'div',
                                    { staticClass: 'avatar avatar-me' },
                                    [
                                      t('img', {
                                        attrs: { src: s.content.path },
                                      }),
                                    ]
                                  ),
                                ]),
                                t(
                                  'div',
                                  { staticClass: 'msg-wrap' },
                                  [
                                    2 === s.status
                                      ? t(
                                          'div',
                                          {
                                            staticClass: 'msg-error',
                                            on: {
                                              click: function (t) {
                                                return e.handleReSend(s)
                                              },
                                            },
                                          },
                                          [
                                            t('img', {
                                              attrs: { src: n('03bb') },
                                            }),
                                          ]
                                        )
                                      : e._e(),
                                    s.content.isNewEmoji
                                      ? t('EmoticonMessage', {
                                          attrs: {
                                            willAutoClear: false,
                                            name: s.content.msg,
                                            type: s.content.emojiType,
                                            emojiId: s.content.emojiId,
                                            width: 70,
                                            height: 70,
                                            lottieUrl: s.content.lottieUrl,
                                            loopLottie: true,
                                          },
                                        })
                                      : t(
                                          'div',
                                          { staticClass: 'msg-box msg-box-me' },
                                          [
                                            e._v(
                                              ' ' + e._s(s.content.msg) + ' '
                                            ),
                                          ]
                                        ),
                                  ],
                                  1
                                ),
                              ]
                            )
                          : e._e(),
                        'tip' === s.role
                          ? t(
                              'li',
                              {
                                key: o,
                                staticClass: 'tip',
                              },
                              [e._v(' ' + e._s(e.$t(s.msg)) + ' ')]
                            )
                          : e._e(),
                      ]
                    }),
                  ],
                  2
                ),
              ]
            ),
            t('div', { staticClass: 'chat-box-foot' }, [
              e.isShowNewMsgTip
                ? t(
                    'div',
                    {
                      staticClass: 'new-meg-tip',
                      on: { click: e.handleScrollBottom },
                    },
                    [t('i', { staticClass: 'icon-more-bottom' })]
                  )
                : e._e(),
              e.isFrequentlyShow
                ? t('div', { staticClass: 'too-frequently' }, [
                    e._v(
                      ' ' + e._s(e.$t('classroom.chats.chats.frequently')) + ' '
                    ),
                  ])
                : e._e(),
              t(
                'div',
                {
                  directives: [
                    {
                      name: 'show',
                      rawName: 'v-show',
                      value: e.sendToReactive.isOpen,
                      expression: 'sendToReactive.isOpen',
                    },
                  ],
                  staticClass: 'memberList',
                  attrs: { id: 'memberList' },
                },
                [
                  t(
                    'ul',
                    e._l(e.sendToList, function (n) {
                      return t(
                        'li',
                        {
                          key: n.id,
                          staticClass: 'member-li',
                          attrs: {
                            'data-log': '选中发送对象'.concat(e.$t(n.name)),
                          },
                          on: {
                            click: function (t) {
                              return e.changeSendToValue(n)
                            },
                          },
                        },
                        [
                          t(
                            'span',
                            {
                              staticClass: 'member-name',
                              class: {
                                'member-changed': e.sendToReactive.id === n.id,
                              },
                            },
                            [e._v(e._s(e.$t(n.name)))]
                          ),
                          e.sendToReactive.id === n.id
                            ? t('span', { staticClass: 'member-icon' })
                            : e._e(),
                        ]
                      )
                    }),
                    0
                  ),
                ]
              ),
              e.isShowFoot
                ? t('div', { staticClass: 'send-to' }, [
                    e._v(
                      ' ' + e._s(e.$t('classroom.chats.chats.sendTo')) + ': '
                    ),
                    t(
                      'div',
                      {
                        staticClass: 'send-to-click',
                        class: {
                          'un-send-to-click':
                            e.isConnecting ||
                            !e.chatBox.isOpenChat ||
                            e.chatBox.isOnlyTeacher,
                        },
                        on: { click: e.toggleMemberPopup },
                      },
                      [
                        t(
                          'span',
                          {
                            staticClass: 'send-to-name',
                            class: {
                              'un-send-to-name':
                                e.isConnecting ||
                                !e.chatBox.isOpenChat ||
                                e.chatBox.isOnlyTeacher,
                            },
                          },
                          [e._v(e._s(e.$t(e.sendToReactive.name)))]
                        ),
                        e.chatBox.isOpenChat && !e.chatBox.isOnlyTeacher
                          ? t('div', { staticClass: 'send-to-icon' })
                          : e._e(),
                      ]
                    ),
                  ])
                : e._e(),
              e.isShowFoot && e.chatBox.isOpenChat && !e.isConnecting
                ? t(
                    'div',
                    { staticClass: 'input-box' },
                    [
                      t('a-textarea', {
                        staticClass: 'text-area',
                        attrs: {
                          maxLength: 200,
                          'auto-size': {
                            minRows: 1,
                            maxRows: 3,
                          },
                          placeholder: e.$t(
                            'classroom.chats.chats.inputPlaceholder'
                          ),
                        },
                        on: { pressEnter: e.handleSendMsg },
                        model: {
                          value: e.messageText,
                          callback: function (t) {
                            e.messageText = t
                          },
                          expression: 'messageText',
                        },
                      }),
                      e.isCanSend
                        ? t(
                            'div',
                            {
                              staticClass: 'send-btn',
                              on: { click: e.handleSendMsg },
                            },
                            [t('img', { attrs: { src: n('52a9') } })]
                          )
                        : t('div', { staticClass: 'send-btn no-send' }, [
                            t('img', { attrs: { src: n('5919') } }),
                          ]),
                    ],
                    1
                  )
                : e._e(),
              e.chatBox.isOpenChat
                ? e._e()
                : t('div', { staticClass: 'input-close' }, [
                    t('div', { staticClass: 'input-close-content' }, [
                      e._v(
                        ' ' +
                          e._s(e.$t('classroom.chats.chats.chatboxClosed')) +
                          ' '
                      ),
                    ]),
                  ]),
              e.isShowFoot && e.isConnecting
                ? t('div', { staticClass: 'input-close' }, [
                    t('div', { staticClass: 'input-close-content' }, [
                      e._v(
                        ' ' +
                          e._s(e.$t('classroom.chats.chats.connecting')) +
                          ' '
                      ),
                    ]),
                  ])
                : e._e(),
            ]),
          ]
        )
      },
      o = [],
      a = n('2909'),
      i = n('5530'),
      r =
        (n('14d9'),
        n('3c65'),
        n('498a2'),
        n('d3b7'),
        n('159b'),
        n('a9e3'),
        n('2ca0'),
        n('a434'),
        n('5880')),
      c = n('d0db'),
      l = n('722b'),
      d = n('a5d8'),
      u = n('35ac'),
      m = n('c02a'),
      p = n('b293'),
      v = {
        components: { EmoticonMessage: l.a },
        props: {
          showHeader: {
            default: true,
            type: Boolean,
          },
          isWholeOnsatge: {
            default: false,
            type: Boolean,
          },
          isShowFoot: {
            default: true,
            type: Boolean,
          },
          isPlayBack: {
            default: false,
            type: Boolean,
          },
        },
        data: function () {
          return {
            isShowNewMsgTip: false,
            messageText: '',
            chatList: [],
            isFrequently: false,
            isFrequentlyShow: false,
            isConnecting: true,
            chatMsgPriority: 99,
            sendToReactive: {
              id: '',
              name: 'classroom.chats.chats.sendToAll',
              isOpen: false,
            },
            dragEvent: null,
            singleChat: [],
            limitNum: 5,
            limitTime: 5000,
            waitTime: 3000,
          }
        },
        directives: { Clickoutside: d.a },
        computed: Object(i.a)(
          Object(i.a)(
            {},
            Object(r.mapGetters)({
              baseData: 'smallClass/baseData',
              chatBox: 'smallClass/chatBox',
              isShowBox: 'smallClass/isShowBox',
              ircStatus: 'smallClass/ircStatus',
            })
          ),
          {},
          {
            isCanSend: function () {
              return (
                console.info(
                  '对象函数 isCanSend,filePath:renderer/components/ChatBox/index.vue'
                ),
                this.messageText.trim()
              )
            },
            sendToList: function () {
              return (
                console.info(
                  '对象函数 sendToList,filePath:renderer/components/ChatBox/index.vue'
                ),
                this.baseData,
                [
                  {
                    id: '',
                    name: 'classroom.chats.chats.sendToAll',
                  },
                  {
                    id: this.baseData.teacherInfo.id,
                    name: 'classroom.chats.chats.sendToTeacher',
                  },
                ]
              )
            },
          }
        ),
        watch: {
          ircStatus: {
            handler: function (e) {
              e && (this.isConnecting = false)
            },
            immediate: true,
          },
          isShowBox: {
            handler: function (e) {
              e &&
                (this.handleScrollBottom(),
                this.$store.dispatch(
                  'smallClass/updateChatboxHasNewMsg',
                  false
                ))
            },
          },
        },
        created: function () {
          this.isPlayBack ||
            (this.thinkClass.SignalService.on(
              'onNetStatusChanged',
              this.onNetStatusChanged
            ),
            this.thinkClass.SignalService.on(
              'onSendRoomMessageResponse',
              this.onSendRoomMessageResponse
            ),
            this.thinkClass.SignalService.on(
              'onGetRoomHistoryMessageResponse',
              this.onGetRoomHistoryMessageResponse
            ),
            this.thinkClass.SignalService.on(
              'onRecvRoomMessage',
              this.onRecvRoomMessage
            ),
            this.thinkClass.SignalService.on(
              'onRecvRoomDataUpdateNotice',
              this.onRecvRoomDataUpdateNotice
            ))
          document.addEventListener('click', this.handleDocumentClick)
        },
        mounted: function () {
          var e = Object(u.a)()
          if (e && e.configs) {
            for (var t = 0; t < e.configs.length; t++) {
              var n = e.configs[t]
              if ('frequentlyObj' === n.configKey) {
                var s = n.configDefaultValue.split(',')
                this.limitNum = s[0] || 5
                this.limitTime = s[1] || 5000
                this.waitTime = s[2] || 3000
                break
              }
            }
          }
          this.limitNum
          this.limitTime
          this.waitTime
          this.chatBox.historyList.length &&
            ((this.chatList = Object(a.a)(this.chatBox.historyList)),
            this.handleScrollBottom())
        },
        beforeDestroy: function () {
          if (
            (console.info(
              '对象函数 beforeDestroy,filePath:renderer/components/ChatBox/index.vue'
            ),
            this.isPlayBack)
          ) {
            this.$store.dispatch('smallClass/updateChatboxIsShowBox', false)
          } else {
            this.thinkClass.SignalService.off(
              'onNetStatusChanged',
              this.onNetStatusChanged
            )
            this.thinkClass.SignalService.off(
              'onSendRoomMessageResponse',
              this.onSendRoomMessageResponse
            )
            this.thinkClass.SignalService.off(
              'onGetRoomHistoryMessageResponse',
              this.onGetRoomHistoryMessageResponse
            )
            this.thinkClass.SignalService.off(
              'onRecvRoomDataUpdateNotice',
              this.onRecvRoomDataUpdateNotice
            )
            var e = document.getElementById('chat-list')
            e.removeEventListener('scroll', this.handleOnScroll)
            this.$store.dispatch('smallClass/updateChatboxIsShowBox', false)
          }
          document.removeEventListener('click', this.handleDocumentClick)
        },
        methods: {
          handleIsShowBox: function () {
            if (
              (console.info(
                '对象函数 handleIsShowBox,filePath:renderer/components/ChatBox/index.vue'
              ),
              this.isPlayBack)
            ) {
              return (
                console.info(
                  'if(this.isPlayBack)为true触发return,path: /renderer/components/ChatBox/index.vue'
                ),
                void this.$store.dispatch(
                  'smallClass/updateChatboxIsShowBox',
                  true
                )
              )
            }
            this.$store.dispatch(
              'smallClass/updateChatboxIsShowBox',
              !this.chatBox.isShowBox
            )
            this.messageText = ''
            this.chatBox.isShowBox &&
              (this.handleScrollBottom(),
              this.$store.dispatch('smallClass/updateChatboxHasNewMsg', false))
          },
          handleSendMsg: function (e) {
            var t = this
            if (
              (console.info(
                '对象函数 handleSendMsg(e)',
                e,
                'filePath:renderer/components/ChatBox/index.vue'
              ),
              e.preventDefault(),
              this.messageText.trim())
            ) {
              if (this.isFrequently) {
                return (
                  console.info(
                    'if(this.isFrequently)为true触发return,path: /renderer/components/ChatBox/index.vue'
                  ),
                  (this.isFrequentlyShow = true),
                  void m.b()
                )
              }
              this.isFrequentlyShow = false
              var n = this.handleFrequentlyFn()
              if (n) {
                return (
                  console.info(
                    'if(isFrequently)为true触发return,path: /renderer/components/ChatBox/index.vue'
                  ),
                  (this.isFrequently = true),
                  (this.isFrequentlyShow = true),
                  m.b(),
                  void setTimeout(function () {
                    t.isFrequently = false
                    t.isFrequentlyShow = false
                  }, this.waitTime)
                )
              }
              var s = {
                type: '130',
                from: 'flv',
                name: this.baseData.stuInfo.nickName,
                msg: this.messageText,
                path: this.baseData.stuInfo.avatar,
              }
              this.sendToReactive.id &&
                ((s.type = '139'), (s.to_uid = this.sendToReactive.id))
              this.chatBox.isOnlyTeacher &&
                ((s.type = '139'), (s.to_uid = this.baseData.teacherInfo.id))
              var o = this.thinkClass.SignalService.sendRoomMessageWithPreMsgId(
                {
                  content: s,
                  chatMsgPriority: this.chatMsgPriority,
                }
              )
              0 === o.code
                ? (this.chatList.push({
                    role: 's',
                    content: s,
                    status: 0,
                    preMsgId: o.preMsgId,
                    userId: this.baseData.stuInfo.id,
                  }),
                  this.singleChat.push(+new Date()),
                  (this.messageText = ''),
                  this.handleScrollBottom(),
                  this.sendLogger('学生发送chatbox消息', Object(i.a)({}, s)),
                  m.c(s))
                : this.sendLogger(
                    '学生发送chatbox消息失败',
                    Object(i.a)({}, o),
                    'error'
                  )
            } else {
              console.info(
                'if(!this.messageText.trim())为true触发return,path: /renderer/components/ChatBox/index.vue'
              )
            }
          },
          handleFrequentlyFn: function () {
            return (
              console.info(
                '对象函数 handleFrequentlyFn,filePath:renderer/components/ChatBox/index.vue'
              ),
              this.singleChat.length >= this.limitNum &&
              +new Date() -
                this.singleChat[this.singleChat.length - this.limitNum] <
                this.limitTime
                ? (console.info(
                    'if(this.singleChat.length >= this.limitNum && +new Date() - this.singleChat[this.singleChat.length - this.limitNum] < this.limitTime)为true触发return,path: /renderer/components/ChatBox/index.vue'
                  ),
                  true)
                : (console.info(
                    'if(this.singleChat.length >= this.limitNum && +new Date() - this.singleChat[this.singleChat.length - this.limitNum] < this.limitTime)为false,触发return,path: /renderer/components/ChatBox/index.vue'
                  ),
                  false)
            )
          },
          onSendRoomMessageResponse: function (e) {
            console.info(
              '对象函数 onSendRoomMessageResponse(res)',
              e,
              'filePath:renderer/components/ChatBox/index.vue'
            )
            for (var t = this.chatList.length - 1; t > 0; t--) {
              var n = this.chatList[t]
              if (n.preMsgId && n.preMsgId === e.preMsgId) {
                console.info(
                  'if(element.preMsgId && element.preMsgId === res.preMsgId)为true触发return,path: /renderer/components/ChatBox/index.vue'
                )
                var s = 0 === e.code ? 1 : 2
                return (
                  (n.status = s),
                  void (
                    0 === e.code &&
                    this.$store.dispatch(
                      'smallClass/updateChatBoxHistoryList',
                      n
                    )
                  )
                )
              }
            }
          },
          handleReSend: function (e) {
            console.info(
              '对象函数 handleReSend(item)',
              e,
              'filePath:renderer/components/ChatBox/index.vue'
            )
            var t = e.content,
              n = this.thinkClass.SignalService.sendRoomMessageWithPreMsgId({
                content: t,
                chatMsgPriority: this.chatMsgPriority,
              })
            if (0 === n.code) {
              for (var s = this.chatList.length - 1; s > 0; s--) {
                var o = this.chatList[s]
                if (o.preMsgId && o.preMsgId === e.preMsgId) {
                  return (
                    console.info(
                      'if(element.preMsgId && element.preMsgId === item.preMsgId)为true触发return,path: /renderer/components/ChatBox/index.vue'
                    ),
                    (o.status = 0),
                    void (o.preMsgId = n.preMsgId)
                  )
                }
              }
            }
          },
          onGetRoomHistoryMessageResponse: function (e) {
            var t = this
            if (
              (console.info(
                '对象函数 onGetRoomHistoryMessageResponse(res)',
                e,
                'filePath:renderer/components/ChatBox/index.vue'
              ),
              0 === e.code)
            ) {
              if (
                ((this.chatList = []),
                e.content.forEach(function (e) {
                  try {
                    e.content = JSON.parse(e.text)
                  } catch (n) {
                    console.error('[chatbox]监听获取历史消息回调解析错误', n)
                  }
                  if (
                    (e.content.type && 130 === Number(e.content.type)) ||
                    (139 === Number(e.content.type) &&
                      e.content.to_uid === t.baseData.stuInfo.id) ||
                    (139 === Number(e.content.type) &&
                      e.content.to_uid === t.baseData.teacherInfo.id &&
                      Number(e.sender.split('_').pop()) ===
                        t.baseData.stuInfo.id)
                  ) {
                    if (
                      ((e.status = 1),
                      e.sender.startsWith('t')
                        ? (e.role = 't')
                        : e.sender.startsWith('s')
                        ? (e.role = 's')
                        : e.sender.startsWith('f') && (e.role = 'f'),
                      e.content.path || (e.content.path = p),
                      (e.userId = e.sender.split('_').pop()),
                      t.chatBox.isOnlyTeacher &&
                        's' === e.role &&
                        +e.userId !== t.baseData.stuInfo.id)
                    ) {
                      return void console.info(
                        "if(_this2.chatBox.isOnlyTeacher && e.role === 's' && +e.userId !== _this2.baseData.stuInfo.id)为true触发return,path: /renderer/components/ChatBox/index.vue"
                      )
                    }
                    t.chatList.unshift(e)
                  }
                }),
                this.chatList.length > 300)
              ) {
                var n = this.chatList.length - 300
                this.chatList = this.chatList.splice(n)
              }
              this.$store.dispatch(
                'smallClass/updateChatBoxHistoryListInit',
                Object(a.a)(this.chatList)
              )
              this.handleScrollBottom()
            }
          },
          onRecvRoomDataUpdateNotice: function (e) {
            var t = e.key,
              n = e.noticeContent
            if ('openchat' === t) {
              var s = n
              this.$store.dispatch('smallClass/updateChatBoxIsClose', s)
              this.handleChangeIsStopChat(s)
              this.sendLogger('老师'.concat(s ? '开启' : '关闭', ' 聊天功能'))
            }
            if ('chat_msg_control' === t) {
              var o = 'teacher' === n.status
              this.$store.dispatch('smallClass/updateChatBoxIsOnlyTeacher', o)
              this.handleChangeIsOnlyReadTeacher(o)
              this.sendLogger('老师设置学员仅可看到老师消息')
              o &&
                this.changeSendToValue({
                  id: this.baseData.teacherInfo.id,
                  name: 'classroom.chats.chats.sendToTeacher',
                })
            }
          },
          onNetStatusChanged: function (e) {
            4 === e.netStatus
              ? this.chatList.push({
                  role: 'tip',
                  msg: 'classroom.chats.chats.msgTip.CONNECT',
                })
              : (1 !== e.netStatus && 2 !== e.netStatus && 5 !== e.netStatus) ||
                this.chatList.push({
                  role: 'tip',
                  msg: 'classroom.chats.chats.msgTip.DISCONNECT',
                })
            this.handleConditionScrollBottom()
          },
          onRecvRoomMessage: function (e) {
            console.info(
              '对象函数 onRecvRoomMessage(res)',
              e,
              'filePath:renderer/components/ChatBox/index.vue'
            )
            var t = e.content,
              n = e.fromUserInfo
            if (
              (t && t.type && 130 === Number(t.type)) ||
              (139 === Number(t.type) && t.to_uid === this.baseData.stuInfo.id)
            ) {
              var s = ''
              if (
                (n.nickname.startsWith('t')
                  ? (s = 't')
                  : n.nickname.startsWith('s')
                  ? (s = 's')
                  : n.nickname.startsWith('f') && (s = 'f'),
                t.path || (t.path = p),
                this.chatList.length >= 300 && this.chatList.shift(),
                this.chatBox.isOnlyTeacher && 's' === s)
              ) {
                return void console.info(
                  "if(this.chatBox.isOnlyTeacher && role === 's')为true触发return,path: /renderer/components/ChatBox/index.vue"
                )
              }
              var o = document.getElementById('chat-list'),
                a = Math.round(o.scrollHeight),
                i = Math.round(o.scrollTop),
                r = Math.round(o.clientHeight)
              this.handleSaveList({
                role: s,
                content: t,
                userId: n.nickname.split('_').pop(),
              })
              a <= i + r + 1
                ? this.handleScrollBottom()
                : (o.addEventListener('scroll', this.handleOnScroll),
                  (this.isShowNewMsgTip = true))
              this.chatBox.isShowBox ||
                this.$store.dispatch('smallClass/updateChatboxHasNewMsg', true)
            }
          },
          handleChangeIsStopChat: function (e) {
            console.info(
              '对象函数 handleChangeIsStopChat(bool)',
              e,
              'filePath:renderer/components/ChatBox/index.vue'
            )
            var t = ''
            t = e
              ? {
                  role: 'tip',
                  msg: 'classroom.chats.chats.teacherOn',
                }
              : {
                  role: 'tip',
                  msg: 'classroom.chats.chats.teacherOff',
                }
            this.handleSaveList(t)
            this.handleConditionScrollBottom()
          },
          handleChangeIsOnlyReadTeacher: function (e) {
            console.info(
              '对象函数 handleChangeIsOnlyReadTeacher(bool)',
              e,
              'filePath:renderer/components/ChatBox/index.vue'
            )
            var t = ''
            t = e
              ? {
                  role: 'tip',
                  msg: 'classroom.chats.chats.onlyteacher',
                }
              : {
                  role: 'tip',
                  msg: 'classroom.chats.chats.all',
                }
            this.handleSaveList(t)
            this.handleConditionScrollBottom()
          },
          handleSaveList: function (e) {
            console.info(
              '对象函数 handleSaveList(item)',
              e,
              'filePath:renderer/components/ChatBox/index.vue'
            )
            this.chatList.push(e)
            this.$store.dispatch('smallClass/updateChatBoxHistoryList', e)
          },
          handleScrollBottom: function () {
            var e = this
            this.isShowNewMsgTip = false
            this.$nextTick(function () {
              var t = document.getElementById('chat-list'),
                n = Math.round(t.scrollHeight),
                s = Math.round(t.clientHeight)
              t.scrollTop = n - s + 1
              t.removeEventListener('scroll', e.handleOnScroll)
            })
          },
          handleConditionScrollBottom: function () {
            var e = document.getElementById('chat-list'),
              t = Math.round(e.scrollHeight),
              n = Math.round(e.scrollTop),
              s = Math.round(e.clientHeight)
            t <= n + s + 1 && this.handleScrollBottom()
          },
          handleOnScroll: function () {
            console.info(
              '对象函数 handleOnScroll,filePath:renderer/components/ChatBox/index.vue'
            )
            var e = document.getElementById('chat-list'),
              t = Math.round(e.scrollHeight),
              n = Math.round(e.scrollTop),
              s = Math.round(e.clientHeight)
            t <= n + s + 1 &&
              ((this.isShowNewMsgTip = false),
              e.removeEventListener('scroll', this.handleOnScroll))
          },
          sendLogger: function (e, t) {
            var n =
              arguments.length > 2 && void 0 !== arguments[2]
                ? arguments[2]
                : 'info'
            c.a.send({
              tag: 'ChatBox',
              content: {
                msg: e,
                interactType: 'ChatBox',
                params: t,
              },
              level: n,
            })
          },
          playBackList: function (e) {
            console.info(
              '对象函数 playBackList(e)',
              e,
              'filePath:renderer/components/ChatBox/index.vue'
            )
            try {
              e.content = JSON.parse(e.text)
            } catch (h) {
              console.error(h)
            }
            if (
              (e.sender.startsWith('t')
                ? (e.role = 't')
                : e.sender.startsWith('s')
                ? (e.role = 's')
                : e.sender.startsWith('f') && (e.role = 'f'),
              e.content.path || (e.content.path = p),
              (e.userId = e.sender.split('_').pop()),
              (e.content.type && 130 === Number(e.content.type)) ||
                (139 === Number(e.content.type) &&
                  e.content.to_uid === this.baseData.stuInfo.id) ||
                (139 === Number(e.content.type) &&
                  e.content.to_uid == this.baseData.teacherInfo.id &&
                  e.sender.indexOf(this.baseData.stuInfo.id) > -1))
            ) {
              e.status = 1
              this.chatList.push(e)
            } else {
              var t,
                n,
                s,
                o = {},
                a = {
                  name:
                    null === (t = e.content.from) || void 0 === t
                      ? void 0
                      : t.username,
                  isMe: false,
                  msg:
                    null === (n = e.content.data) || void 0 === n
                      ? void 0
                      : n.name,
                  isNewEmoji: true,
                  path:
                    (null === (s = e.content.from) || void 0 === s
                      ? void 0
                      : s.path) || '',
                }
              if (
                'send_emoji' == e.content.ircType &&
                1 == e.content.data.type
              ) {
                o = a
                this.chatList.push({
                  role: 's',
                  content: o,
                  userId: e.userId,
                })
              } else {
                if (
                  'animation_emoji' == e.content.ircType &&
                  (2 == e.content.data.type || 3 == e.content.data.type)
                ) {
                  var r, c
                  o = Object(i.a)(
                    Object(i.a)({}, a),
                    {},
                    {
                      lottieUrl:
                        (null === (r = e.content.data.resource) || void 0 === r
                          ? void 0
                          : r.lottieUrl) || '',
                      emojiId:
                        (null === (c = e.content.data.resource) || void 0 === c
                          ? void 0
                          : c.emojiId) || 0,
                      emojiType: e.content.data.type,
                    }
                  )
                  this.chatList.push({
                    role: 's',
                    content: o,
                    userId: e.userId,
                  })
                }
              }
            }
            var l = document.getElementById('chat-list'),
              d = Math.round(l.scrollHeight),
              u = Math.round(l.scrollTop),
              m = Math.round(l.clientHeight)
            d <= u + m + 1
              ? this.handleScrollBottom()
              : (l.addEventListener('scroll', this.handleOnScroll),
                (this.isShowNewMsgTip = true))
          },
          changeSendToValue: function (e) {
            console.info(
              '对象函数 changeSendToValue(item)',
              e,
              'filePath:renderer/components/ChatBox/index.vue'
            )
            this.sendToReactive.id = e.id
            this.sendToReactive.name = e.name
            this.sendToReactive.isOpen = false
          },
          toggleMemberPopup: function (e) {
            if (
              (console.info(
                '对象函数 toggleMemberPopup(e)',
                e,
                'filePath:renderer/components/ChatBox/index.vue'
              ),
              e.stopPropagation(),
              !this.chatBox.isOpenChat ||
                this.chatBox.isOnlyTeacher ||
                this.isConnecting)
            ) {
              return (
                console.info(
                  'if(!this.chatBox.isOpenChat || this.chatBox.isOnlyTeacher || this.isConnecting)为true触发return,path: /renderer/components/ChatBox/index.vue'
                ),
                void (this.sendToReactive.isOpen = false)
              )
            }
            this.sendToReactive.isOpen = !this.sendToReactive.isOpen
          },
          handleDocumentClick: function (e) {
            if (this.sendToReactive.isOpen) {
              var t = document.getElementById('memberList')
              t.contains(e.target) || (this.sendToReactive.isOpen = false)
            } else {
              console.info(
                'if(!this.sendToReactive.isOpen)为true触发return,path: /renderer/components/ChatBox/index.vue'
              )
            }
          },
        },
      },
      C = v,
      S = (n('7cbd'), n('2877')),
      g = Object(S.a)(C, s, o, false, null, '43f5f029', null)
    t.a = g.exports
  },
  e12e: function (e, t, n) {
    'use strict'
    n('1ed9')
  },
  e1bd: function (e, t, n) {},
  e1d5: function (e, t, n) {},
  e401: function (e, t, n) {},
  e525: function (e, t) {
    e.exports =
      'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAMAAACdt4HsAAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAAJDUExURUdwTPm5v/etsf26wv+lh/2/x/+hIf9+fv+dIv+fPv+vtf+XJv+yuP+hJf+pq/96QP+RLP+jJPqgof+/x/+ZKv+0u/+lIv+dIuqrpf+fKv+imv98bv+pLv/BxUX8l/l8fv1weP+bLv+Ql/twfKO3hWrXh1rnjf+XKM/Lsf+RMP+zt3TVh/+9x43nqdvPv1zrk++rqftqev+bfP+7wf/ByeHLv/+hq/+fJP+xt/+vt/+3v/+xuv+9xf+5wf+zu/+1vf+vtf/AyP+dMP+zuf+cpP+ss/+lrf+tt/+pr//BOf+1u/+3vf+Pl/90e/+5PP+9OkT/l/+Vn/+Llf+Fj/+Hk/+ps/94hf58iUz7mf+jqUn9mP6Tmv+zOP+Bjf+fMln2mv/XZv/RPP+nsf+jrf+vMv+3NeLAtf/TYnbpof+Lj/+/Uv97hv+Zofm3u/+zS//JWf+dOFT5m+25tX3qo2Dznf+nMP+fp8PNrv+jPK7UrP/XQNLKtojkpP/PXv+rRGjwnv9+dPW5u+PHvdjCsYvSlPlqdv+tLL3Hpf18fu3Bv/+Dh6PZqf+hWpvVn/uzt3Dtof/HOPXDw/+6TOO7sf+LZmbpkZHjqXrblbnatv/Lav+TMP+9MP+hLJHbof+ncrnRreelnf/AbLa+mtell/+RTp3jo/Wbn9mYiP+VfM6hi+2Ph/vJQNnPv4/7s/x/Ybuxh9G1o/+ZYP+HeG71jXT9n//FgXDjl/+zm/+ZULLsvs/RVv/FPL/ZdO2xStetbNuraP+1cDeYyGcAAAA4dFJOUwAo/LUQ+zoCSgifiUm12yLEWjfx09CjLPHpGZPTPqKFtffJ6fcShamvmeNLbM1a63o0wYPVx81ww517GwAABvlJREFUWMPtV/dTG9caFcUsAmNwHzuJ7fTe3kve2yLtLkirXa16X0kGoYIsgcAghEAI001HGFNt3HsvsVPJK39avruYmQhw/S0z+WCY0cA599zzne/ei0Lxd/1FSnnw4ME3hGK7vijbu7tapVKTnxV9sx17PXTxV0W7q6FUgFerSYbiC8u+fXX454esVmugfXlWrYIvNUkyIi6Eve/tejX49u8HZ8fH7y0vBnyLQIE0kAyNjwauGN96BXhBUfWadnW1KptK3VOhUpMinctIS3eOvNSKL7YBuFr1rGYXpaz8CTRo8LmZtttHXgz/8MvlwW2yb7JyA6me9GVVMgVpoFlh2vrB4RfK/3ImZZUWh0gDSZIGhqFp2nBdGlTLakiRIrhH0tKu5+4CewfJH+9st/YMiKJIayi5egLjaqRBDZtghUsLXyuf6z7Cg12aaF9blKJwHCegqFwsNWBAIkgNSPAaFz56Ph6WMdAanMj1tCUJnAAKisDZXN9MM7gBvwJKzn/n6w+3xMv61dBvtGwuFsPXi8KTqVgzQ4I0+MSG7Tc/2sqFApR66BUlL0wUDnEcyxJrBGwyEBtApgA1LtjGPtiCoPi7bQgPGwcQwQrhRELrFTh2XUNfX5RBm2MJVjth+nwzwyf3BmdRVuRihUQ8frm+vv7Hn0EEMpIaaJc6aRrxs7q46fAmgq9+/fX+/fvLSZmBdSXi/WcAX3/s2I+sTKARDRlfLIoM4rxx06aRKN69TTWQXX76tBPtn0vHTf9H6BPHjx+/DLugKJoxGAYhH1GWE/wTprc3EpRVw8CzQvL60+s50Ggcu3WsHsEbG0+fRrugaBRNZihmjY3eiJtaIsr8PeyqVpEU7xLCus4n1zmdbaL/DMAbT7e09Pb2XiCI6JBIknAqiNTc+ba2h43BlZJ8AUWIgOJ5XUg392TaOPGDjG8EeFdr6wUNNWlt68nCZDE4l3Y8/K27e6U0T0HBLDSQpsCsUMh76cnDC0g+wLtaz56t+nQHWDAA89EOfSSExFh/d3dQvzNPwCGrNDOZw1HDXGnnnd/X8WffLa/ECjic0jCMerBdylDInnkgWMknyA5mJ1OBKOogl54wnak/BnhYvqpSgRXvxTU4zcAkqC9K0wRk4DEiKM0bApKkcRifORQBaPLlE0hA19lPUX/38jiuYdAokYYhadprN00Fg8GG/X8m+CdJUxTLt6dyKIN+sPAEEvAxuhk+AzzsAPXAwNBDvitx01R38NRInodFkHWCxXOpHjmotvity6dbug4osYKyOel8UkOLKAQwizw3ar3pBgWr+UHaCzCWINg5XwbFUND67bcuzP+jbEeYd3WmpIxoQDeDSEMIhaUl0+Ng8NS+PAU7eI7jgYLttHZCJ+DvdLpwKBR2USAtd9HX3kyqQT/BhcLaS76bU8HVhvwm7BBgbFmexbmML4uMxFmYIDiLKI2GpphoYKYZxYR36dIJ//DS1N1TI8X5BKGQgCTwPDtpvcg/O4cATNMMA/6NB3pIDcC92oTfeVvqvauvyA/yv9I6F0+gIPLEKMwsLC7jRYDL9kV9nYQL9Cdsxlr3wt1TkdINZ0kiLPAUrIeO8SQM3MUkfBINDNwOajSE1GRA500nbH67o8n9v9WVDcOMHep7pONhXhlGpMHr6PmANbWYRWsjOISEL5RGQb7f7vS4x8z6kQ2jqPhm2He+kBNJueRTOZppl9oyzXAfPjNvus9utDtrPW5Ty2rDvo330Xbj1YXAEEGTKK+wII7OwYFMW9+4iG4SXVhru2G96nTUNrn7W/QrBza9eIodduOwNBpCMwNLgpco/9RALJXkEDxhtDuWht1NY/1Ter1lpHTTgYq953Q4r/hGdS4OdQJixcnJLJzpE8JayKXD4/7vb2Y9oPWWSPkWd8rhWofDcUW6mvaGdTohpBMEl4tzuYTCwLTNbwT4Y7PFDGBgiFRs+aCqRTUcuJHQatNebxjxQJq9iUfWS87aph96zRaLRW9etVhGKra+2t/yNHk8jp+uOo1+m00LNHJB438adrvnzWY9fFksZvNIhXJrguL33aYmk9tT67DbjX4gkQv6fts39osZCtAWS0PHvuc+Lb59/yQq4HA4gUMuO5jnWfiP2dwADpgtDUfP/fsFj9LKIydPPmitu/bABDKccqG+z0eOHm0wN8D30ZEDJS981ioqq2pq6urqWq/1ezzIUw/E5hfAr1Xk3D7lSx7GGFb+bg2q1tZr8/1N7qYH1zo6Il2RDkCPnNtTonj5WxkrqVpjqGmtQ9XR1dHRFYEfNVWl2Cs9tTFFacWaipq17SCamj3l+xWv8VJX7vx4zzpHzYE95TsrX/efBEyBKfeXlELth9Rg2Bv+r6FEyDcEr/vxd/1F6g9OO4/gdbF2GAAAAABJRU5ErkJggg=='
  },
  e80a: function (e, t, n) {
    'use strict'
    n('f168')
  },
  e829: function (e, t, n) {},
  e94e: function (e, t, n) {},
  e9b8: function (e, t, n) {},
  ea42: function (e, t, n) {},
  ebc2: function (e, t, n) {},
  ec0d: function (e, t, n) {
    'use strict'
    n('9cdb')
  },
  ed62: function (e, t) {
    e.exports = require('https')
  },
  ee02: function (e, t, n) {
    'use strict'
    n('77b24')
  },
  ef7c: function (e, t, n) {
    'use strict'
    var s = function () {
        var e = this,
          t = e._self._c
        return t('div', [
          t('div', {
            class: [e.medalClass, e.levelClass],
          }),
          t(
            'span',
            {
              staticClass: 'text',
              class: e.smallLevelText,
            },
            [e._v('Lv' + e._s(e.level))]
          ),
        ])
      },
      o = [],
      a =
        (n('a9e3'),
        {
          props: {
            type: {
              type: String,
              default: 'small',
            },
            level: {
              type: Number,
              default: 0,
            },
          },
          computed: {
            medalClass: function () {
              return (
                console.info(
                  '对象函数 medalClass,filePath:renderer/components/Classroom/SmallClass/Common/MedalIcon/index.vue'
                ),
                'medal-'.concat(this.type)
              )
            },
            levelClass: function () {
              return (
                console.info(
                  '对象函数 levelClass,filePath:renderer/components/Classroom/SmallClass/Common/MedalIcon/index.vue'
                ),
                'level-'.concat(this.level)
              )
            },
            smallLevelText: function () {
              return (
                console.info(
                  '对象函数 smallLevelText,filePath:renderer/components/Classroom/SmallClass/Common/MedalIcon/index.vue'
                ),
                'level-'.concat(this.level)
              )
            },
          },
          data: function () {
            return {}
          },
          mounted: function () {},
          methods: {},
        }),
      i = a,
      r = (n('9b244'), n('2877')),
      c = Object(r.a)(i, s, o, false, null, '0fdafc67', null)
    t.a = c.exports
  },
  f168: function (e, t, n) {},
  f1a5: function (e, t, n) {
    'use strict'
    n('949e')
  },
  f319: function (e, t) {
    e.exports = require('querystring')
  },
  f3d9: function (e, t, n) {
    'use strict'
    n('ea42')
  },
  f58c: function (e, t, n) {
    'use strict'
    n('88f0')
  },
  f5ef: function (e, t, n) {
    'use strict'
    n('646d')
  },
  f761: function (e, t, n) {
    'use strict'
    n('ebc2')
  },
  f96f: function (e, t, n) {},
  fc4f: function (e, t, n) {},
  fd71: function (e, t, n) {
    'use strict'
    n('e1d5')
  },
  fe8e: function (e, t, n) {
    'use strict'
    n('4a79')
  },
  fee4: function (e, t, n) {},
  ff4a: function (e, t) {
    e.exports = require('events')
  },
  ff5c: function (e, t, n) {
    'use strict'
    n('e1bd')
  },
  ffae: function (e, t, n) {},
})
