; (window.webpackJsonp = window.webpackJsonp || []).push([
    ['chunk-2f487bd5'],
    {
        '0151': function (t, e, a) { },
        '04e4': function (t, e) {
            t.exports =
                'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABQAAAAUBAMAAAB/pwA+AAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAAAnUExURaGruaGruUdwTKOquZqas6OpuaGrt6KquZ+jtKOpuaGquaGpuaOruWgPXzMAAAAMdFJOU7MyAO0KLjioFEzGbJ794ZoAAABfSURBVAjXY1CCAwZcTI0CBoZqJzBTBchcbApmOgoKinosdgIyNW3OnDlj2bMJyHRmExQUY/YqAjJjkoC6cwKYgEwZISBTRoAEpjjChAgnuLlgN0Bsg7jMFegGJ5xOBwAmTCLQGK7IggAAAABJRU5ErkJggg=='
        },
        '0a06a': function (t, e, a) {
            'use strict'
            a.d(e, 'g', function () {
                return n
            })
            a.d(e, 'j', function () {
                return r
            })
            a.d(e, 'k', function () {
                return o
            })
            a.d(e, 'i', function () {
                return i
            })
            a.d(e, 'c', function () {
                return c
            })
            a.d(e, 'b', function () {
                return u
            })
            a.d(e, 'a', function () {
                return l
            })
            a.d(e, 'f', function () {
                return d
            })
            a.d(e, 'h', function () {
                return p
            })
            a.d(e, 'd', function () {
                return m
            })
            a.d(e, 'e', function () {
                return f
            })
            a('b680')
            var s = a('2f5c'),
                n = function (t) {
                    Object(s.a)('osta_login', { hw_user_id: ''.concat(t) })
                },
                r = function (t) {
                    try {
                        Object(s.a)('osta_update_new_version', {
                            new_version: null === t || void 0 === t ? void 0 : t.newVersion,
                            is_force_update: !(
                                null === t ||
                                void 0 === t ||
                                !t.needForceUpgrade
                            ),
                        })
                    } catch (e) {
                        console.error('神策埋点报错:', e)
                    }
                },
                o = function (t) {
                    Object(s.a)('osta_update_skip', {
                        new_version:
                            (null === t || void 0 === t ? void 0 : t.newVersion) || '',
                    })
                },
                i = function (t) {
                    Object(s.a)('osta_update_install', {
                        new_version: null === t || void 0 === t ? void 0 : t.newVersion,
                    })
                },
                c = function (t) {
                    Object(s.a)('osta_do_pre_test', { plan_id: ''.concat(t) })
                },
                u = function (t) {
                    Object(s.a)('osta_do_homework', { plan_id: ''.concat(t) })
                },
                l = function (t) {
                    Object(s.a)('osta_class_report', { plan_id: ''.concat(t) })
                },
                d = function (t) {
                    Object(s.a)('osta_leraning_material', { plan_id: ''.concat(t) })
                },
                p = function (t) {
                    try {
                        Object(s.a)('osta_sign_in', {
                            plan_id: ''.concat(t.planId),
                            coins_count: t.coins,
                            start_difference: new Date().getTime() - 1000 * t.time,
                        })
                    } catch (e) {
                        console.error('神策埋点报错:', e)
                    }
                },
                m = function (t, e, a) {
                    var n =
                        arguments.length > 3 && void 0 !== arguments[3] ? arguments[3] : 0
                    try {
                        Object(s.a)('osta_enter_classroom', {
                            time_offset: n,
                            plan_id: ''.concat(t.planId),
                            class_type: 2 == t.subPlatformType ? 'small' : 'dual',
                            class_id: ''.concat(t.classId),
                            is_camera_ok: !e.camDetecting,
                            is_mic_ok: !e.micDetecting,
                            network_quality:
                                0 === e.netDetecting
                                    ? 'good'
                                    : 1 === t.networkStatus
                                        ? 'poor'
                                        : 'unknown',
                            courseware_localcache_exit: a.exit,
                            courseware_download_size: a.exit ? 0 : +a.size.toFixed(2),
                            courseware_download_time: a.exit
                                ? 0
                                : (a.endTime - a.startTime) / 1000,
                            start_difference:
                                new Date().getTime() + n - 1000 * a.courseStartTime,
                        })
                    } catch (r) {
                        console.error('神策埋点报错:', r)
                    }
                },
                f = function (t, e) {
                    var a =
                        arguments.length > 2 && void 0 !== arguments[2] ? arguments[2] : 0
                    try {
                        Object(s.a)('osta_enter_playback', {
                            plan_id: ''.concat(t.planId),
                            class_id: ''.concat(t.classId),
                            courseware_localcache_exit: e.exit,
                            courseware_download_size: e.exit ? 0 : +e.size.toFixed(2),
                            courseware_download_time: e.exit
                                ? 0
                                : (e.endTime - e.startTime) / 1000,
                            end_difference: new Date().getTime() + a - 1000 * e.courseEndTime,
                        })
                    } catch (n) {
                        console.error('神策埋点报错:', n)
                    }
                }
        },
        1276: function (t, e, a) {
            'use strict'
            var s = a('2ba4'),
                n = a('c65b'),
                r = a('e330'),
                o = a('d784'),
                i = a('825a'),
                c = a('7234'),
                u = a('44e7'),
                l = a('1d80'),
                d = a('4840'),
                p = a('8aa5'),
                m = a('50c4'),
                f = a('577e'),
                h = a('dc4a'),
                b = a('4dae'),
                v = a('14c3'),
                w = a('9263'),
                y = a('9f7f'),
                C = a('d039'),
                _ = y.UNSUPPORTED_Y,
                x = Math.min,
                k = [].push,
                O = r(/./.exec),
                D = r(k),
                j = r(''.slice),
                A = !C(function () {
                    var e = /(?:)/.exec
                        ; /(?:)/.exec = function () {
                            return e.apply(this, arguments)
                        }
                    var a = 'ab'.split(/(?:)/)
                    return 2 !== a.length || 'a' !== a[0] || 'b' !== a[1]
                })
            o(
                'split',
                function (t, e, a) {
                    var r
                    return (
                        (r =
                            'c' == 'abbc'.split(/(b)*/)[1] ||
                                4 != 'test'.split(/(?:)/, -1).length ||
                                2 != 'ab'.split(/(?:ab)*/).length ||
                                4 != '.'.split(/(.?)(.?)/).length ||
                                '.'.split(/()()/).length > 1 ||
                                ''.split(/.?/).length
                                ? function (t, a) {
                                    var r = f(l(this)),
                                        o = void 0 === a ? 4294967295 : a >>> 0
                                    if (0 === o) {
                                        return []
                                    }
                                    if (void 0 === t) {
                                        return [r]
                                    }
                                    if (!u(t)) {
                                        return n(e, r, t, o)
                                    }
                                    var i,
                                        c,
                                        d,
                                        p = [],
                                        m =
                                            (t.ignoreCase ? 'i' : '') +
                                            (t.multiline ? 'm' : '') +
                                            (t.unicode ? 'u' : '') +
                                            (t.sticky ? 'y' : ''),
                                        h = 0,
                                        v = new RegExp(t.source, m + 'g')
                                    while ((i = n(w, v, r))) {
                                        if (
                                            ((c = v.lastIndex),
                                                c > h &&
                                                (D(p, j(r, h, i.index)),
                                                    i.length > 1 &&
                                                    i.index < r.length &&
                                                    s(k, p, b(i, 1)),
                                                    (d = i[0].length),
                                                    (h = c),
                                                    p.length >= o))
                                        ) {
                                            break
                                        }
                                        v.lastIndex === i.index && v.lastIndex++
                                    }
                                    return (
                                        h === r.length
                                            ? (!d && O(v, '')) || D(p, '')
                                            : D(p, j(r, h)),
                                        p.length > o ? b(p, 0, o) : p
                                    )
                                }
                                : '0'.split(void 0, 0).length
                                    ? function (t, a) {
                                        return void 0 === t && 0 === a ? [] : n(e, this, t, a)
                                    }
                                    : e),
                        [
                            function (e, a) {
                                var s = l(this),
                                    o = c(e) ? void 0 : h(e, t)
                                return o ? n(o, e, s, a) : n(r, f(s), e, a)
                            },
                            function (t, s) {
                                var n = i(this),
                                    o = f(t),
                                    c = a(r, n, o, s, r !== e)
                                if (c.done) {
                                    return c.value
                                }
                                var u = d(n, RegExp),
                                    l = n.unicode,
                                    h =
                                        (n.ignoreCase ? 'i' : '') +
                                        (n.multiline ? 'm' : '') +
                                        (n.unicode ? 'u' : '') +
                                        (_ ? 'g' : 'y'),
                                    b = new u(_ ? '^(?:' + n.source + ')' : n, h),
                                    w = void 0 === s ? 4294967295 : s >>> 0
                                if (0 === w) {
                                    return []
                                }
                                if (0 === o.length) {
                                    return null === v(b, o) ? [o] : []
                                }
                                var y = 0,
                                    C = 0,
                                    k = []
                                while (C < o.length) {
                                    b.lastIndex = _ ? 0 : C
                                    var O,
                                        A = v(b, _ ? j(o, C) : o)
                                    if (
                                        null === A ||
                                        (O = x(m(b.lastIndex + (_ ? C : 0)), o.length)) === y
                                    ) {
                                        C = p(o, C, l)
                                    } else {
                                        if ((D(k, j(o, y, C)), k.length === w)) {
                                            return k
                                        }
                                        for (var T = 1; T <= A.length - 1; T++) {
                                            if ((D(k, A[T]), k.length === w)) {
                                                return k
                                            }
                                        }
                                        C = y = O
                                    }
                                }
                                return D(k, j(o, y)), k
                            },
                        ]
                    )
                },
                !A,
                _
            )
        },
        '22de': function (t, e, a) {
            'use strict'
            a.d(e, 'd', function () {
                return c
            })
            a.d(e, 'e', function () {
                return u
            })
            a.d(e, 'a', function () {
                return l
            })
            a.d(e, 'b', function () {
                return d
            })
            a.d(e, 'c', function () {
                return p
            })
            a.d(e, 'f', function () {
                return m
            })
            var s = a('c7eb'),
                n = a('1da1'),
                r = a('dc21'),
                o = a('e39c'),
                i = (function () {
                    var t = Object(n.a)(
                        Object(s.a)().mark(function t(e, a, n) {
                            var i, c, u
                            return Object(s.a)().wrap(function (t) {
                                while (1) {
                                    switch ((t.prev = t.next)) {
                                        case 0:
                                            return (
                                                (i = Object(o.h)()),
                                                (c = i.oversea),
                                                (t.next = 3),
                                                Object(r.a)({
                                                    url: a,
                                                    params: n,
                                                    apiDomain: c,
                                                })
                                            )
                                        case 3:
                                            return (u = t.sent), t.abrupt('return', u)
                                        case 5:
                                        case 'end':
                                            return t.stop()
                                    }
                                }
                            }, t)
                        })
                    )
                    return function (e, a, s) {
                        return t.apply(this, arguments)
                    }
                })(),
                c = (function () {
                    var t = Object(n.a)(
                        Object(s.a)().mark(function t(e, a) {
                            var n, r
                            return Object(s.a)().wrap(function (t) {
                                while (1) {
                                    switch ((t.prev = t.next)) {
                                        case 0:
                                            return (
                                                (n = '/homework-api/student/neirongyun/jumpUrl'),
                                                (t.next = 3),
                                                i(e, n, a)
                                            )
                                        case 3:
                                            return (r = t.sent), t.abrupt('return', r)
                                        case 5:
                                        case 'end':
                                            return t.stop()
                                    }
                                }
                            }, t)
                        })
                    )
                    return function (e, a) {
                        return t.apply(this, arguments)
                    }
                })(),
                u = (function () {
                    var t = Object(n.a)(
                        Object(s.a)().mark(function t(e, a) {
                            var n, r
                            return Object(s.a)().wrap(function (t) {
                                while (1) {
                                    switch ((t.prev = t.next)) {
                                        case 0:
                                            return (
                                                (n = '/homework-api/student/sync'),
                                                (t.next = 3),
                                                i(e, n, a)
                                            )
                                        case 3:
                                            return (r = t.sent), t.abrupt('return', r)
                                        case 5:
                                        case 'end':
                                            return t.stop()
                                    }
                                }
                            }, t)
                        })
                    )
                    return function (e, a) {
                        return t.apply(this, arguments)
                    }
                })(),
                l = (function () {
                    var t = Object(n.a)(
                        Object(s.a)().mark(function t(e, a) {
                            var n, r
                            return Object(s.a)().wrap(function (t) {
                                while (1) {
                                    switch ((t.prev = t.next)) {
                                        case 0:
                                            return (
                                                (n = '/homework-api/student/paperDetail'),
                                                (t.next = 3),
                                                i(e, n, a)
                                            )
                                        case 3:
                                            return (r = t.sent), t.abrupt('return', r)
                                        case 5:
                                        case 'end':
                                            return t.stop()
                                    }
                                }
                            }, t)
                        })
                    )
                    return function (e, a) {
                        return t.apply(this, arguments)
                    }
                })(),
                d = (function () {
                    var t = Object(n.a)(
                        Object(s.a)().mark(function t(e, a) {
                            var n, r
                            return Object(s.a)().wrap(function (t) {
                                while (1) {
                                    switch ((t.prev = t.next)) {
                                        case 0:
                                            return (
                                                (n = '/homework-api/student/paperOverview'),
                                                (t.next = 3),
                                                i(e, n, a)
                                            )
                                        case 3:
                                            return (r = t.sent), t.abrupt('return', r)
                                        case 5:
                                        case 'end':
                                            return t.stop()
                                    }
                                }
                            }, t)
                        })
                    )
                    return function (e, a) {
                        return t.apply(this, arguments)
                    }
                })(),
                p = (function () {
                    var t = Object(n.a)(
                        Object(s.a)().mark(function t(e, a) {
                            var n, r
                            return Object(s.a)().wrap(function (t) {
                                while (1) {
                                    switch ((t.prev = t.next)) {
                                        case 0:
                                            return (
                                                (n = '/beibo/student/paperOverview'),
                                                (t.next = 3),
                                                i(e, n, a)
                                            )
                                        case 3:
                                            return (r = t.sent), t.abrupt('return', r)
                                        case 5:
                                        case 'end':
                                            return t.stop()
                                    }
                                }
                            }, t)
                        })
                    )
                    return function (e, a) {
                        return t.apply(this, arguments)
                    }
                })(),
                m = (function () {
                    var t = Object(n.a)(
                        Object(s.a)().mark(function t(e, a) {
                            var n, r
                            return Object(s.a)().wrap(function (t) {
                                while (1) {
                                    switch ((t.prev = t.next)) {
                                        case 0:
                                            return (
                                                (n = '/api/beibo/student/watch'),
                                                (t.next = 3),
                                                i(e, n, a)
                                            )
                                        case 3:
                                            return (r = t.sent), t.abrupt('return', r)
                                        case 5:
                                        case 'end':
                                            return t.stop()
                                    }
                                }
                            }, t)
                        })
                    )
                    return function (e, a) {
                        return t.apply(this, arguments)
                    }
                })()
        },
        2535: function (t, e, a) { },
        '2f5c': function (t, e, a) {
            'use strict'
            a.d(e, 'a', function () {
                return s
            })
            var s = function (t) {
                var e =
                    arguments.length > 1 && void 0 !== arguments[1] ? arguments[1] : {}
                window.$sensors.track(t, e)
            }
        },
        '31bc': function (t, e, a) {
            'use strict'
            a('a270')
        },
        '5fb8': function (t, e, a) {
            'use strict'
            a('f94ec')
        },
        '74f3': function (t, e) {
            t.exports =
                'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABYAAAAUCAMAAAC+oj0CAAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAABjUExURUdwTP+pB/+rCP/NAP+rCf+pCf+rCP+qCf+rCP+qC/+pCP+rCv+hAP+rCP+rCP+qCP+qCP+qCf+3AP+rCP+qCP+qCP+rCP+qCv+qCv+rB/+qCv+rCP+rCP+pCP+tCP+pCv+rCn/wTC8AAAAgdFJOUwAMbAMy+83f9hQnlglWcmW/WwbU5xqId3o+r6Ohu0xKO4LoqQAAALVJREFUGNNVkOkWhSAIhCk1NW3fu5vv/5QXSk3n1/AdDgMAgF6lkkZDrnp2KDHXOa7crYml9HBBR4q7iMsUDxEPWBXlee6UrpWnAqtakps58s3j/YmXI/qW+tWGjod5Xxqvm7a5rmmy9GVoh4UMFx7/AKyhQhgLwPo7HGezj+/44JXLdCXiH8r0HGa796sskpc4V9F4y3lBz1ERK4BxxVIZbHePKOfapSoyHN+2Z7gPTmZYBif+swQfaDV/TGwAAAAASUVORK5CYII='
        },
        '76f4': function (t, e, a) {
            'use strict'
            a('ce0e')
        },
        '78d5': function (t, e, a) {
            'use strict'
            a('e3f2')
        },
        9222: function (t, e, a) {
            'use strict'
            a('2535')
        },
        a270: function (t, e, a) { },
        c342: function (t, e, a) {
            'use strict'
            a.d(e, 'm', function () {
                return c
            })
            a.d(e, 'p', function () {
                return u
            })
            a.d(e, 's', function () {
                return l
            })
            a.d(e, 'r', function () {
                return d
            })
            a.d(e, 'o', function () {
                return p
            })
            a.d(e, 'c', function () {
                return m
            })
            a.d(e, 'v', function () {
                return f
            })
            a.d(e, 'q', function () {
                return h
            })
            a.d(e, 't', function () {
                return b
            })
            a.d(e, 'n', function () {
                return v
            })
            a.d(e, 'x', function () {
                return w
            })
            a.d(e, 'w', function () {
                return y
            })
            a.d(e, 'i', function () {
                return C
            })
            a.d(e, 'a', function () {
                return _
            })
            a.d(e, 'b', function () {
                return g
            })
            a.d(e, 'y', function () {
                return x
            })
            a.d(e, 'g', function () {
                return k
            })
            a.d(e, 'f', function () {
                return O
            })
            a.d(e, 'j', function () {
                return D
            })
            a.d(e, 'h', function () {
                return j
            })
            a.d(e, 'u', function () {
                return A
            })
            a.d(e, 'e', function () {
                return T
            })
            a.d(e, 'k', function () {
                return N
            })
            a.d(e, 'l', function () {
                return I
            })
            a.d(e, 'd', function () {
                return P
            })
            var s = a('c7eb'),
                n = a('1da1'),
                r = a('dc21'),
                o = a('e39c'),
                i = (function () {
                    var t = Object(n.a)(
                        Object(s.a)().mark(function t(e, a) {
                            var n, i, c
                            return Object(s.a)().wrap(function (t) {
                                while (1) {
                                    switch ((t.prev = t.next)) {
                                        case 0:
                                            return (
                                                (n = Object(o.h)()),
                                                (i = n.oversea),
                                                (t.next = 3),
                                                Object(r.a)({
                                                    url: e,
                                                    params: a,
                                                    apiDomain: i,
                                                })
                                            )
                                        case 3:
                                            return (c = t.sent), t.abrupt('return', c)
                                        case 5:
                                        case 'end':
                                            return t.stop()
                                    }
                                }
                            }, t)
                        })
                    )
                    return function (e, a) {
                        return t.apply(this, arguments)
                    }
                })(),
                c = (function () {
                    var t = Object(n.a)(
                        Object(s.a)().mark(function t(e) {
                            var a, n
                            return Object(s.a)().wrap(function (t) {
                                while (1) {
                                    switch ((t.prev = t.next)) {
                                        case 0:
                                            return (
                                                (a = '/classroom-hub/classroom/student/basic'),
                                                (t.next = 3),
                                                i(a, e)
                                            )
                                        case 3:
                                            return (n = t.sent), t.abrupt('return', n)
                                        case 5:
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
                })(),
                u = (function () {
                    var t = Object(n.a)(
                        Object(s.a)().mark(function t(e) {
                            var a, n
                            return Object(s.a)().wrap(function (t) {
                                while (1) {
                                    switch ((t.prev = t.next)) {
                                        case 0:
                                            return (
                                                (a = '/classroom-hub/classroom/student/initModule'),
                                                (t.next = 3),
                                                i(a, e)
                                            )
                                        case 3:
                                            return (n = t.sent), t.abrupt('return', n)
                                        case 5:
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
                })(),
                l = (function () {
                    var t = Object(n.a)(
                        Object(s.a)().mark(function t(e) {
                            var a, n
                            return Object(s.a)().wrap(function (t) {
                                while (1) {
                                    switch ((t.prev = t.next)) {
                                        case 0:
                                            return (
                                                (a = '/classroom-hub/playback/student/showVodAddress'),
                                                (t.next = 3),
                                                i(a, e)
                                            )
                                        case 3:
                                            return (n = t.sent), t.abrupt('return', n)
                                        case 5:
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
                })(),
                d = (function () {
                    var t = Object(n.a)(
                        Object(s.a)().mark(function t(e) {
                            var a, n
                            return Object(s.a)().wrap(function (t) {
                                while (1) {
                                    switch ((t.prev = t.next)) {
                                        case 0:
                                            return (
                                                (a = '/classroom-hub/playback/metainfo'),
                                                (t.next = 3),
                                                i(a, e)
                                            )
                                        case 3:
                                            return (n = t.sent), t.abrupt('return', n)
                                        case 5:
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
                })(),
                p = (function () {
                    var t = Object(n.a)(
                        Object(s.a)().mark(function t(e) {
                            var a, n
                            return Object(s.a)().wrap(function (t) {
                                while (1) {
                                    switch ((t.prev = t.next)) {
                                        case 0:
                                            return (
                                                (a = '/classroom-hub/classroom/student/groupMember'),
                                                (t.next = 3),
                                                i(a, e)
                                            )
                                        case 3:
                                            return (n = t.sent), t.abrupt('return', n)
                                        case 5:
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
                })(),
                m = (function () {
                    var t = Object(n.a)(
                        Object(s.a)().mark(function t(e) {
                            var a, n
                            return Object(s.a)().wrap(function (t) {
                                while (1) {
                                    switch ((t.prev = t.next)) {
                                        case 0:
                                            return (
                                                (a = '/classroom-hub/duration/student/push'),
                                                (t.next = 3),
                                                i(a, e)
                                            )
                                        case 3:
                                            return (n = t.sent), t.abrupt('return', n)
                                        case 5:
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
                })(),
                f = (function () {
                    var t = Object(n.a)(
                        Object(s.a)().mark(function t(e) {
                            var a, n
                            return Object(s.a)().wrap(function (t) {
                                while (1) {
                                    switch ((t.prev = t.next)) {
                                        case 0:
                                            return (
                                                (a = '/classroom-hub/classroom/student/setRtcStatus'),
                                                (t.next = 3),
                                                i(a, e)
                                            )
                                        case 3:
                                            return (n = t.sent), t.abrupt('return', n)
                                        case 5:
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
                })(),
                h = (function () {
                    var t = Object(n.a)(
                        Object(s.a)().mark(function t(e) {
                            var a, n
                            return Object(s.a)().wrap(function (t) {
                                while (1) {
                                    switch ((t.prev = t.next)) {
                                        case 0:
                                            return (
                                                (a =
                                                    '/classroom-hub/classroom/student/peerMessageHistory'),
                                                (t.next = 3),
                                                i(a, e)
                                            )
                                        case 3:
                                            return (n = t.sent), t.abrupt('return', n)
                                        case 5:
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
                })(),
                b = (function () {
                    var t = Object(n.a)(
                        Object(s.a)().mark(function t(e) {
                            var a, n
                            return Object(s.a)().wrap(function (t) {
                                while (1) {
                                    switch ((t.prev = t.next)) {
                                        case 0:
                                            return (
                                                (a = '/classroom-hub/speech/student/whoCanSpeak'),
                                                (t.next = 3),
                                                i(a, e)
                                            )
                                        case 3:
                                            return (n = t.sent), t.abrupt('return', n)
                                        case 5:
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
                })(),
                v = (function () {
                    var t = Object(n.a)(
                        Object(s.a)().mark(function t(e) {
                            var a, n
                            return Object(s.a)().wrap(function (t) {
                                while (1) {
                                    switch ((t.prev = t.next)) {
                                        case 0:
                                            return (
                                                (a =
                                                    '/classroom-hub/classroom/student/classStudentList'),
                                                (t.next = 3),
                                                i(a, e)
                                            )
                                        case 3:
                                            return (n = t.sent), t.abrupt('return', n)
                                        case 5:
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
                })(),
                w = (function () {
                    var t = Object(n.a)(
                        Object(s.a)().mark(function t(e) {
                            var a
                            return Object(s.a)().wrap(function (t) {
                                while (1) {
                                    switch ((t.prev = t.next)) {
                                        case 0:
                                            return (
                                                (a = '/classroom-hub/praise/student/submit'),
                                                (t.next = 3),
                                                i(a, e)
                                            )
                                        case 3:
                                            return t.abrupt('return', t.sent)
                                        case 4:
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
                })(),
                y = (function () {
                    var t = Object(n.a)(
                        Object(s.a)().mark(function t(e) {
                            var a
                            return Object(s.a)().wrap(function (t) {
                                while (1) {
                                    switch ((t.prev = t.next)) {
                                        case 0:
                                            return (
                                                (a = '/api/hub/classroom/studentCoinAndMedal'),
                                                (t.next = 3),
                                                i(a, e)
                                            )
                                        case 3:
                                            return t.abrupt('return', t.sent)
                                        case 4:
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
                })(),
                C = (function () {
                    var t = Object(n.a)(
                        Object(s.a)().mark(function t(e) {
                            var a
                            return Object(s.a)().wrap(function (t) {
                                while (1) {
                                    switch ((t.prev = t.next)) {
                                        case 0:
                                            return (
                                                (a = '/api/classroom/v1/getMute'), (t.next = 3), i(a, e)
                                            )
                                        case 3:
                                            return t.abrupt('return', t.sent)
                                        case 4:
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
                })(),
                _ = (function () {
                    var t = Object(n.a)(
                        Object(s.a)().mark(function t(e) {
                            var a
                            return Object(s.a)().wrap(function (t) {
                                while (1) {
                                    switch ((t.prev = t.next)) {
                                        case 0:
                                            return (
                                                (a = '/api/linkmic/v1/student/answerRob'),
                                                (t.next = 3),
                                                i(a, e)
                                            )
                                        case 3:
                                            return t.abrupt('return', t.sent)
                                        case 4:
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
                })(),
                g = (function () {
                    var t = Object(n.a)(
                        Object(s.a)().mark(function t(e) {
                            var a
                            return Object(s.a)().wrap(function (t) {
                                while (1) {
                                    switch ((t.prev = t.next)) {
                                        case 0:
                                            return (
                                                (a = '/api/schultegrid/v1/student/check'),
                                                (t.next = 3),
                                                i(a, e)
                                            )
                                        case 3:
                                            return t.abrupt('return', t.sent)
                                        case 4:
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
                })(),
                x = (function () {
                    var t = Object(n.a)(
                        Object(s.a)().mark(function t(e) {
                            var a
                            return Object(s.a)().wrap(function (t) {
                                while (1) {
                                    switch ((t.prev = t.next)) {
                                        case 0:
                                            return (
                                                (a = '/api/schultegrid/v1/student/commit'),
                                                (t.next = 3),
                                                i(a, e)
                                            )
                                        case 3:
                                            return t.abrupt('return', t.sent)
                                        case 4:
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
                })(),
                k = (function () {
                    var t = Object(n.a)(
                        Object(s.a)().mark(function t(e) {
                            var a
                            return Object(s.a)().wrap(function (t) {
                                while (1) {
                                    switch ((t.prev = t.next)) {
                                        case 0:
                                            return (
                                                (a = '/api/hub/linkmic/getLinkMicStudentDataOfMulti'),
                                                (t.next = 3),
                                                i(a, e)
                                            )
                                        case 3:
                                            return t.abrupt('return', t.sent)
                                        case 4:
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
                })(),
                O = (function () {
                    var t = Object(n.a)(
                        Object(s.a)().mark(function t(e) {
                            var a
                            return Object(s.a)().wrap(function (t) {
                                while (1) {
                                    switch ((t.prev = t.next)) {
                                        case 0:
                                            return (
                                                (a = '/api/classroom/v1/getClassroomData'),
                                                (t.next = 3),
                                                i(a, e)
                                            )
                                        case 3:
                                            return t.abrupt('return', t.sent)
                                        case 4:
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
                })(),
                D = (function () {
                    var t = Object(n.a)(
                        Object(s.a)().mark(function t(e) {
                            var a, n
                            return Object(s.a)().wrap(function (t) {
                                while (1) {
                                    switch ((t.prev = t.next)) {
                                        case 0:
                                            return (
                                                (a = '/api/hub/classroom/student/inClass'),
                                                (t.next = 3),
                                                i(a, e)
                                            )
                                        case 3:
                                            return (n = t.sent), t.abrupt('return', n)
                                        case 5:
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
                })(),
                j = (function () {
                    var t = Object(n.a)(
                        Object(s.a)().mark(function t(e) {
                            var a
                            return Object(s.a)().wrap(function (t) {
                                while (1) {
                                    switch ((t.prev = t.next)) {
                                        case 0:
                                            return (
                                                (a = '/api/emoji/v1/student/detail'),
                                                (t.next = 3),
                                                i(a, e)
                                            )
                                        case 3:
                                            return t.abrupt('return', t.sent)
                                        case 4:
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
                })(),
                A = (function () {
                    var t = Object(n.a)(
                        Object(s.a)().mark(function t(e) {
                            var a
                            return Object(s.a)().wrap(function (t) {
                                while (1) {
                                    switch ((t.prev = t.next)) {
                                        case 0:
                                            return (
                                                (a = '/api/emoji/v1/student/setOverHide'),
                                                (t.next = 3),
                                                i(a, e)
                                            )
                                        case 3:
                                            return t.abrupt('return', t.sent)
                                        case 4:
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
                })(),
                T = (function () {
                    var t = Object(n.a)(
                        Object(s.a)().mark(function t(e) {
                            var a
                            return Object(s.a)().wrap(function (t) {
                                while (1) {
                                    switch ((t.prev = t.next)) {
                                        case 0:
                                            return (
                                                (a = '/api/linkmic/v1/studentGetAllPageKey'),
                                                (t.next = 3),
                                                i(a, e)
                                            )
                                        case 3:
                                            return t.abrupt('return', t.sent)
                                        case 4:
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
                })(),
                N = (function () {
                    var t = Object(n.a)(
                        Object(s.a)().mark(function t(e) {
                            var a, n
                            return Object(s.a)().wrap(function (t) {
                                while (1) {
                                    switch ((t.prev = t.next)) {
                                        case 0:
                                            return (
                                                (a = '/api/notfocused/student/push'),
                                                (t.next = 3),
                                                i(a, e)
                                            )
                                        case 3:
                                            return (n = t.sent), t.abrupt('return', n)
                                        case 5:
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
                })(),
                I = (function () {
                    var t = Object(n.a)(
                        Object(s.a)().mark(function t(e) {
                            var a, n
                            return Object(s.a)().wrap(function (t) {
                                while (1) {
                                    switch ((t.prev = t.next)) {
                                        case 0:
                                            return (
                                                (a = '/api/classroom/v1/student/reportDeviceInfo'),
                                                (t.next = 3),
                                                i(a, e)
                                            )
                                        case 3:
                                            return (n = t.sent), t.abrupt('return', n)
                                        case 5:
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
                })(),
                P = (function () {
                    var t = Object(n.a)(
                        Object(s.a)().mark(function t(e) {
                            var a, n
                            return Object(s.a)().wrap(function (t) {
                                while (1) {
                                    switch ((t.prev = t.next)) {
                                        case 0:
                                            return (
                                                (a = '/api/classroom/v1/teacher/feedbackUpdate'),
                                                (t.next = 3),
                                                i(a, e)
                                            )
                                        case 3:
                                            return (n = t.sent), t.abrupt('return', n)
                                        case 5:
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
        },
        ce0e: function (t, e, a) { },
        e37b: function (t, e, a) {
            'use strict'
            a('0151')
        },
        e3f2: function (t, e, a) { },
        e417: function (t, e, a) {
            'use strict'
            a.d(e, 'f', function () {
                return p
            })
            a.d(e, 'e', function () {
                return m
            })
            a.d(e, 'd', function () {
                return f
            })
            a.d(e, 'c', function () {
                return h
            })
            a.d(e, 'a', function () {
                return b
            })
            a.d(e, 'b', function () {
                return v
            })
            var s = a('bee2'),
                n = a('d4ec'),
                r = a('ade3'),
                o = a('5530'),
                i = (a('cca6'), a('99af'), a('8bbf')),
                c = a.n(i),
                u = null,
                l = true,
                d = 0,
                m = function (t, e) {
                    var a =
                        arguments.length > 2 && void 0 !== arguments[2] ? arguments[2] : {}
                    c.a.prototype.$sensors.track(
                        t,
                        Object(o.a)(
                            {
                                lesson_type: p[e.classType],
                                class_id: e.classId,
                                plan_id: e.planId,
                            },
                            a
                        )
                    )
                },
                f = function (t, e) {
                    c.a.prototype.$sensors.track(t, e)
                },
                h = function (t) {
                    var e = t.type,
                        a = void 0 === e ? 'link' : e,
                        s = t.result,
                        n = t.errorType,
                        r = void 0 === n ? '' : n,
                        o = t.code,
                        i = void 0 === o ? 0 : o,
                        p = t.msg,
                        m = void 0 === p ? '无' : p,
                        f = t.liveInfo,
                        h = void 0 === f ? {} : f,
                        b = t.msgInfo,
                        v = void 0 === b ? {} : b,
                        w = {}
                    'message' == a
                        ? ((w = {
                            result: s,
                            irc_message_type: m,
                        }),
                            'fail' == s &&
                            Object.assign(w, {
                                error_type: r,
                                msg_info: JSON.stringify(v),
                                error_msg: '错误码='
                                    .concat(i, '\uFF0C错误描述=')
                                    .concat(m, '失败'),
                            }),
                            c.a.prototype.$sensors.track('hw_irc_send_message', w))
                        : ((w = {
                            result: s,
                            re_connect_num: d,
                            is_first: l ? '是' : '否',
                            location: h.location,
                        }),
                            'fail' == s
                                ? (Object.assign(w, {
                                    live_info: JSON.stringify(h),
                                    error_type: r,
                                    error_msg: '错误码='.concat(i, '\uFF0C错误描述=').concat(m),
                                }),
                                    (l = false),
                                    (d += 1))
                                : 'success' == s
                                    ? (Object.assign(w, { irc_join_room_duration: Date.now() - u }),
                                        (l = false),
                                        (d += 1))
                                    : 'start' == s && (u = Date.now()),
                            c.a.prototype.$sensors.track('hw_irc_join_room', w))
                },
                b = Object(s.a)(function t() {
                    var e = this
                    Object(n.a)(this, t)
                    Object(r.a)(this, 'rtcSensorPush', function (t) {
                        var a = t.result,
                            s = t.errorType,
                            n = void 0 === s ? '' : s,
                            r = t.code,
                            o = void 0 === r ? 0 : r,
                            i = t.msg,
                            u = void 0 === i ? '无' : i,
                            l = {
                                result: a,
                                is_first: e.isFirstJoinChannel ? '是' : '否',
                            }
                        'fail' == a
                            ? Object.assign(l, {
                                error_type: n,
                                error_msg: '错误码='.concat(o, '\uFF0C错误描述=').concat(u),
                            })
                            : 'success' == a
                                ? Object.assign(l, {
                                    rtc_join_room_duration: Date.now() - e.joinRtcStartTime,
                                })
                                : 'start' == a && (e.joinRtcStartTime = Date.now())
                        c.a.prototype.$sensors.track('hw_rtc_join_room', l)
                    })
                    this.joinRtcStartTime = null
                    this.isFirstJoinChannel = true
                }),
                v = function (t) {
                    var e = ''
                    if (t.isParent) {
                        e = '家长旁听'
                    } else {
                        e = a[t.lessonType]
                    }
                    c.a.prototype.$sensors.track('hw_stu_enter_class_room', {
                        package_id: t.packageId,
                        class_id: t.classId,
                        previous_source:
                            'course' == t.from ? '学习中心一级页' : '学习中心二级页',
                        plan_id: t.planId,
                        plan_mode: 0 == t.isPlayBack ? '直播' : '回放',
                        lesson_type: p[t.classType],
                        course_type: e,
                    })
                    0 == t.isPlayBack &&
                        c.a.prototype.$sensors.track('pc_enter_class_room', {
                            previous_source:
                                'course' == t.from ? '学习中心一级页' : '学习中心二级页',
                            course_type: e,
                            is_start_class: !t.isPlayBack && t.isStartClass,
                        })
                }
        },
        e9eb: function (t, e, a) {
            'use strict'
            a.r(e)
            var s = function () {
                var t = this,
                    e = t._self._c
                return e(
                    'div',
                    {
                        staticClass: 'page-wrapper',
                        attrs: { 'data-log': '课程详情' },
                    },
                    [
                        e(
                            'div',
                            {
                                ref: 'syllabusList',
                                staticClass: 'syllabus-list',
                            },
                            [
                                t.isError
                                    ? [
                                        e('ErrorStatus', {
                                            attrs: {
                                                'data-log': '错误状态',
                                                scene: 'CoursesDetails',
                                            },
                                            on: { 'click-refresh': t.queryData },
                                        }),
                                    ]
                                    : [
                                        t.loading
                                            ? e('Loading', { attrs: { 'margin-top': '200px' } })
                                            : e(
                                                'section',
                                                [
                                                    e('SyllabusNav', {
                                                        attrs: { 'course-datas': t.courseDatas },
                                                    }),
                                                    e('SyllabusList', {
                                                        attrs: {
                                                            teachers: t.teachers,
                                                            'course-datas': t.courseDatas,
                                                            'data-list': t.dataList,
                                                        },
                                                    }),
                                                ],
                                                1
                                            ),
                                    ],
                            ],
                            2
                        ),
                    ]
                )
            },
                n = [],
                r = a('c7eb'),
                o = a('1da1'),
                i = (a('4de4'), a('d3b7'), a('e6cf'), a('a79d'), a('c740'), a('bd12')),
                c = a('aaf0'),
                u = function () {
                    var t = this,
                        e = t._self._c
                    return e(
                        'div',
                        { staticClass: 'wrapper' },
                        [
                            t._l(t.dataList, function (a, s) {
                                return e('SyllabusCard', {
                                    key: s,
                                    staticClass: 'item-syllabus',
                                    attrs: {
                                        index:
                                            'LESSON' === a.scheduleType
                                                ? a.lessonDetails.orderNum
                                                : 0,
                                        teachers: t.teachers,
                                        isOpenParentEntry: t.isOpenParentEntry,
                                        'course-datas': t.courseDatas,
                                        scheduleType: a.scheduleType,
                                        'syllabus-data':
                                            'LESSON' === a.scheduleType
                                                ? a.lessonDetails
                                                : a.examDetails,
                                    },
                                    on: {
                                        openConfirm: t.openConfirm,
                                        showAttendClass: t.showAttendClass,
                                    },
                                })
                            }),
                            e('GoClassModal', {
                                attrs: {
                                    visible: t.showConfirmModal,
                                    params: t.needParams,
                                },
                                on: {
                                    'update:visible': function (e) {
                                        t.showConfirmModal = e
                                    },
                                },
                            }),
                            e('HowToAttendClass', {
                                attrs: {
                                    data: t.attendClassData,
                                    visible: t.showAttendModal,
                                },
                                on: { closeModal: t.closeModal },
                            }),
                        ],
                        2
                    )
                },
                l = [],
                d =
                    (a('99af'),
                        function () {
                            var t = this,
                                e = t._self._c
                            return e(
                                'div',
                                {
                                    staticClass: 'syllabus-container',
                                    attrs: {
                                        'data-log': '课程卡片'
                                            .concat(this.syllabusData.classId, '-')
                                            .concat(t.syllabusData.planId),
                                    },
                                },
                                [
                                    'LESSON' === t.scheduleType
                                        ? e(
                                            'div',
                                            [
                                                e('div', { staticClass: 'syllabus-card' }, [
                                                    t.lessonType
                                                        ? e(
                                                            'div',
                                                            {
                                                                class: [
                                                                    'card-tag',
                                                                    1 == t.syllabusData.isChange
                                                                        ? 'green-tag'
                                                                        : 'blue-tag',
                                                                ],
                                                            },
                                                            [
                                                                e('span', { staticClass: 'tag-left' }),
                                                                e('span', { staticClass: 'tag-center' }, [
                                                                    t._v(t._s(t.lessonType)),
                                                                ]),
                                                                e('span', { staticClass: 'tag-right' }),
                                                            ]
                                                        )
                                                        : t._e(),
                                                    e('div', { staticClass: 'number' }, [
                                                        e('label'),
                                                        e('span', [t._v(t._s(t.padIndex))]),
                                                    ]),
                                                    e('div', { staticClass: 'syllabus-info' }, [
                                                        e('div', { staticClass: 'title' }, [
                                                            t._v(' ' + t._s(t.syllabusData.lessonName) + ' '),
                                                        ]),
                                                        e('div', { staticClass: 'datetime' }, [
                                                            e('span', { staticClass: 'content' }, [
                                                                t._v(t._s(t.syllabusData.classDateDesc)),
                                                            ]),
                                                            e('span', { staticClass: 'content' }, [
                                                                t._v(
                                                                    ' ' +
                                                                    t._s(t.syllabusData.startTime) +
                                                                    ' - ' +
                                                                    t._s(t.syllabusData.endTime) +
                                                                    ' '
                                                                ),
                                                            ]),
                                                        ]),
                                                    ]),
                                                ]),
                                                e('div', { staticClass: 'bottom-info' }, [
                                                    e(
                                                        'section',
                                                        {
                                                            staticClass: 'wrapper',
                                                            attrs: { id: 'content-wrapper' },
                                                        },
                                                        [
                                                            1 != t.syllabusData.previewQuestion.status
                                                                ? e('section', { staticClass: 'preview' }, [
                                                                    e('div', { staticClass: 'class-info' }, [
                                                                        e('span', {
                                                                            staticClass: 'preview-icon common-icon',
                                                                        }),
                                                                        e('label', [
                                                                            e('span', { staticClass: 'title' }, [
                                                                                t._v(
                                                                                    t._s(
                                                                                        t.syllabusData.previewQuestion
                                                                                            .title || 'Preview question'
                                                                                    )
                                                                                ),
                                                                            ]),
                                                                            e('span', { staticClass: 'content' }, [
                                                                                t._v(
                                                                                    t._s(
                                                                                        t._f('handleAssignmentEndTime')(
                                                                                            t.syllabusData.previewQuestion
                                                                                                .endTime,
                                                                                            t.local
                                                                                        )
                                                                                    )
                                                                                ),
                                                                            ]),
                                                                        ]),
                                                                    ]),
                                                                    e(
                                                                        'div',
                                                                        { staticClass: 'button-wrapper' },
                                                                        [
                                                                            t.previewQuestionButton.buttonClassName
                                                                                ? e(
                                                                                    'a-button',
                                                                                    {
                                                                                        directives: [
                                                                                            {
                                                                                                name: 'mark-scroll',
                                                                                                rawName: 'v-mark-scroll',
                                                                                                value: 'courseDetail',
                                                                                                expression:
                                                                                                    "'courseDetail'",
                                                                                            },
                                                                                        ],
                                                                                        class:
                                                                                            t.previewQuestionButton
                                                                                                .buttonClassName,
                                                                                        attrs: {
                                                                                            type: 'link',
                                                                                            shape: 'round',
                                                                                            loading: t.previewBtnLoading,
                                                                                            'data-log':
                                                                                                t.previewQuestionButton
                                                                                                    .buttonName,
                                                                                        },
                                                                                        on: {
                                                                                            click: function (e) {
                                                                                                return t.handlePreviewButton(
                                                                                                    t.syllabusData
                                                                                                        .previewQuestion.status
                                                                                                )
                                                                                            },
                                                                                        },
                                                                                    },
                                                                                    [
                                                                                        t._v(
                                                                                            ' ' +
                                                                                            t._s(
                                                                                                t.previewQuestionButton
                                                                                                    .buttonName
                                                                                            ) +
                                                                                            ' '
                                                                                        ),
                                                                                        t.showNextBtn(
                                                                                            t.syllabusData.previewQuestion
                                                                                                .status
                                                                                        )
                                                                                            ? e('span', {
                                                                                                staticClass:
                                                                                                    'finish-icon',
                                                                                            })
                                                                                            : t._e(),
                                                                                    ]
                                                                                )
                                                                                : t._e(),
                                                                        ],
                                                                        1
                                                                    ),
                                                                ])
                                                                : t._e(),
                                                            1 != t.syllabusData.assignment.status
                                                                ? e('section', { staticClass: 'assignment' }, [
                                                                    e('div', { staticClass: 'class-info' }, [
                                                                        e('span', {
                                                                            staticClass:
                                                                                'assignment-icon common-icon',
                                                                        }),
                                                                        e('label', [
                                                                            e('span', { staticClass: 'title' }, [
                                                                                t._v(
                                                                                    t._s(
                                                                                        t.$t(
                                                                                            'courses.detail.homework.title'
                                                                                        )
                                                                                    )
                                                                                ),
                                                                            ]),
                                                                        ]),
                                                                    ]),
                                                                    e(
                                                                        'div',
                                                                        { staticClass: 'button-wrapper' },
                                                                        [
                                                                            t.assignmentButton.buttonClassName
                                                                                ? e(
                                                                                    'a-button',
                                                                                    {
                                                                                        directives: [
                                                                                            {
                                                                                                name: 'mark-scroll',
                                                                                                rawName: 'v-mark-scroll',
                                                                                                value: 'courseDetail',
                                                                                                expression:
                                                                                                    "'courseDetail'",
                                                                                            },
                                                                                        ],
                                                                                        class:
                                                                                            t.assignmentButton
                                                                                                .buttonClassName,
                                                                                        attrs: {
                                                                                            type: 'link',
                                                                                            shape: 'round',
                                                                                            loading:
                                                                                                t.assignmentBtnLoading,
                                                                                            'data-log':
                                                                                                t.assignmentButton
                                                                                                    .buttonName,
                                                                                        },
                                                                                        on: {
                                                                                            click:
                                                                                                t.handleAssignmentButton,
                                                                                        },
                                                                                    },
                                                                                    [
                                                                                        t._v(
                                                                                            ' ' +
                                                                                            t._s(
                                                                                                t.assignmentButton
                                                                                                    .buttonName
                                                                                            ) +
                                                                                            ' '
                                                                                        ),
                                                                                        t.showNextBtn(
                                                                                            t.syllabusData.assignment
                                                                                                .status
                                                                                        )
                                                                                            ? e('span', {
                                                                                                staticClass:
                                                                                                    'finish-icon',
                                                                                            })
                                                                                            : t._e(),
                                                                                    ]
                                                                                )
                                                                                : t._e(),
                                                                        ],
                                                                        1
                                                                    ),
                                                                ])
                                                                : t._e(),
                                                            e(
                                                                'section',
                                                                {
                                                                    staticClass: 'classroom',
                                                                    class: {
                                                                        'full-column': t.fullColumn(t.syllabusData),
                                                                    },
                                                                },
                                                                [
                                                                    e('div', { staticClass: 'class-info' }, [
                                                                        e('span', {
                                                                            staticClass: 'classroom-icon common-icon',
                                                                        }),
                                                                        e('label', [
                                                                            e('span', { staticClass: 'title' }, [
                                                                                t._v(
                                                                                    t._s(t.$t('courses.detail.classRoom'))
                                                                                ),
                                                                            ]),
                                                                            e('span', { staticClass: 'content' }, [
                                                                                t._v(
                                                                                    ' ' +
                                                                                    t._s(t.syllabusData.startTime) +
                                                                                    ' - ' +
                                                                                    t._s(t.syllabusData.endTime) +
                                                                                    ' '
                                                                                ),
                                                                            ]),
                                                                        ]),
                                                                    ]),
                                                                    e(
                                                                        'div',
                                                                        {
                                                                            staticClass: 'button-wrapper flex-layout',
                                                                        },
                                                                        [
                                                                            'OFFLINE' !== t.syllabusData.platformType
                                                                                ? [
                                                                                    t.showParentAuditBtn
                                                                                        ? e(
                                                                                            'a-button',
                                                                                            {
                                                                                                directives: [
                                                                                                    {
                                                                                                        name: 'mark-scroll',
                                                                                                        rawName:
                                                                                                            'v-mark-scroll',
                                                                                                        value: 'courseDetail',
                                                                                                        expression:
                                                                                                            "'courseDetail'",
                                                                                                    },
                                                                                                    {
                                                                                                        name: 'log',
                                                                                                        rawName: 'v-log',
                                                                                                    },
                                                                                                ],
                                                                                                staticClass:
                                                                                                    'color-orange parent-btn',
                                                                                                attrs: {
                                                                                                    type: 'link',
                                                                                                    shape: 'round',
                                                                                                    loading:
                                                                                                        t.parentAuditLoading,
                                                                                                    'data-log': t.$t(
                                                                                                        'courses.courseCard.parentAudit'
                                                                                                    ),
                                                                                                },
                                                                                                on: {
                                                                                                    click: function (e) {
                                                                                                        return (
                                                                                                            e.stopPropagation(),
                                                                                                            t.toParentAudit.apply(
                                                                                                                null,
                                                                                                                arguments
                                                                                                            )
                                                                                                        )
                                                                                                    },
                                                                                                },
                                                                                            },
                                                                                            [
                                                                                                e(
                                                                                                    'span',
                                                                                                    {
                                                                                                        staticClass:
                                                                                                            'parent-btn-template',
                                                                                                    },
                                                                                                    [
                                                                                                        e('img', {
                                                                                                            staticClass:
                                                                                                                'parent-btn-icon',
                                                                                                            attrs: {
                                                                                                                src: a('74f3'),
                                                                                                                alt: '',
                                                                                                            },
                                                                                                        }),
                                                                                                        e(
                                                                                                            'span',
                                                                                                            {
                                                                                                                staticClass:
                                                                                                                    'parent-btn-text',
                                                                                                            },
                                                                                                            [
                                                                                                                t._v(
                                                                                                                    t._s(
                                                                                                                        t.$t(
                                                                                                                            'courses.courseCard.parentAudit'
                                                                                                                        )
                                                                                                                    )
                                                                                                                ),
                                                                                                            ]
                                                                                                        ),
                                                                                                    ]
                                                                                                ),
                                                                                            ]
                                                                                        )
                                                                                        : t._e(),
                                                                                    7 !== t.status
                                                                                        ? e(
                                                                                            'a-button',
                                                                                            {
                                                                                                directives: [
                                                                                                    {
                                                                                                        name: 'mark-scroll',
                                                                                                        rawName:
                                                                                                            'v-mark-scroll',
                                                                                                        value: 'courseDetail',
                                                                                                        expression:
                                                                                                            "'courseDetail'",
                                                                                                    },
                                                                                                    {
                                                                                                        name: 'log',
                                                                                                        rawName: 'v-log',
                                                                                                    },
                                                                                                ],
                                                                                                class: [
                                                                                                    t.classroomButton
                                                                                                        .buttonClassName,
                                                                                                ],
                                                                                                attrs: {
                                                                                                    type: 'link',
                                                                                                    shape: 'round',
                                                                                                    loading: t.loading,
                                                                                                    'data-log':
                                                                                                        t.classroomButton
                                                                                                            .buttonName,
                                                                                                },
                                                                                                on: {
                                                                                                    click: function (e) {
                                                                                                        return (
                                                                                                            e.stopPropagation(),
                                                                                                            t.handleClassroomButton.apply(
                                                                                                                null,
                                                                                                                arguments
                                                                                                            )
                                                                                                        )
                                                                                                    },
                                                                                                },
                                                                                            },
                                                                                            [
                                                                                                t._v(
                                                                                                    ' ' +
                                                                                                    t._s(
                                                                                                        t.classroomButton
                                                                                                            .buttonName
                                                                                                    ) +
                                                                                                    ' '
                                                                                                ),
                                                                                            ]
                                                                                        )
                                                                                        : t._e(),
                                                                                    3 === t.status && t.showGenerateTips
                                                                                        ? e(
                                                                                            'div',
                                                                                            { staticClass: 'tooltip' },
                                                                                            [
                                                                                                e('span', [
                                                                                                    t._v(
                                                                                                        t._s(
                                                                                                            t.$t(
                                                                                                                'courses.detail.playBackTip'
                                                                                                            )
                                                                                                        )
                                                                                                    ),
                                                                                                ]),
                                                                                                e('label'),
                                                                                            ]
                                                                                        )
                                                                                        : t._e(),
                                                                                ]
                                                                                : e(
                                                                                    'a-button',
                                                                                    {
                                                                                        directives: [
                                                                                            {
                                                                                                name: 'mark-scroll',
                                                                                                rawName: 'v-mark-scroll',
                                                                                                value: 'courseDetail',
                                                                                                expression: "'courseDetail'",
                                                                                            },
                                                                                            {
                                                                                                name: 'log',
                                                                                                rawName: 'v-log',
                                                                                            },
                                                                                        ],
                                                                                        staticClass: 'color-orange',
                                                                                        attrs: {
                                                                                            type: 'link',
                                                                                            shape: 'round',
                                                                                            loading: t.loading,
                                                                                            'data-log': t.$t(
                                                                                                'courses.faceToFace.attendClass'
                                                                                            ),
                                                                                        },
                                                                                        on: {
                                                                                            click: function (e) {
                                                                                                return (
                                                                                                    e.stopPropagation(),
                                                                                                    t.teachMethod.apply(
                                                                                                        null,
                                                                                                        arguments
                                                                                                    )
                                                                                                )
                                                                                            },
                                                                                        },
                                                                                    },
                                                                                    [
                                                                                        t._v(
                                                                                            ' ' +
                                                                                            t._s(
                                                                                                t.$t(
                                                                                                    'courses.faceToFace.attendClass'
                                                                                                )
                                                                                            ) +
                                                                                            ' '
                                                                                        ),
                                                                                    ]
                                                                                ),
                                                                        ],
                                                                        2
                                                                    ),
                                                                ]
                                                            ),
                                                            t.syllabusData.exam
                                                                ? e(
                                                                    'section',
                                                                    {
                                                                        staticClass: 'preview',
                                                                        class: {
                                                                            'full-column': t.fullColumn(
                                                                                t.syllabusData
                                                                            ),
                                                                        },
                                                                    },
                                                                    [
                                                                        e('div', { staticClass: 'class-info' }, [
                                                                            e('span', {
                                                                                staticClass:
                                                                                    'examination-icon common-icon',
                                                                            }),
                                                                            e('label', [
                                                                                e('span', { staticClass: 'title' }, [
                                                                                    t._v(
                                                                                        t._s(t.syllabusData.exam.examName)
                                                                                    ),
                                                                                ]),
                                                                                t.syllabusData.exam.canViewReport ||
                                                                                    2 === t.syllabusData.exam.status
                                                                                    ? t._e()
                                                                                    : e(
                                                                                        'span',
                                                                                        { staticClass: 'content' },
                                                                                        [
                                                                                            t._v(
                                                                                                ' ' +
                                                                                                t._s(
                                                                                                    t.$t(
                                                                                                        'courses.detail.reportTips',
                                                                                                        {
                                                                                                            canViewTime:
                                                                                                                t.syllabusData
                                                                                                                    .exam
                                                                                                                    .canViewTime,
                                                                                                        }
                                                                                                    )
                                                                                                ) +
                                                                                                ' '
                                                                                            ),
                                                                                        ]
                                                                                    ),
                                                                            ]),
                                                                        ]),
                                                                        e(
                                                                            'div',
                                                                            { staticClass: 'button-wrapper' },
                                                                            [
                                                                                t.examReportButton
                                                                                    ? e(
                                                                                        'a-button',
                                                                                        {
                                                                                            directives: [
                                                                                                {
                                                                                                    name: 'mark-scroll',
                                                                                                    rawName: 'v-mark-scroll',
                                                                                                    value: 'courseDetail',
                                                                                                    expression:
                                                                                                        "'courseDetail'",
                                                                                                },
                                                                                                {
                                                                                                    name: 'log',
                                                                                                    rawName: 'v-log',
                                                                                                },
                                                                                            ],
                                                                                            class: [
                                                                                                t.examReportButton
                                                                                                    .buttonClassName,
                                                                                            ],
                                                                                            attrs: {
                                                                                                type: 'link',
                                                                                                shape: 'round',
                                                                                                loading:
                                                                                                    t.classExamBtnLoading,
                                                                                                'data-log':
                                                                                                    t.examReportButton
                                                                                                        .buttonName,
                                                                                            },
                                                                                            on: {
                                                                                                click: t.handleClassExam,
                                                                                            },
                                                                                        },
                                                                                        [
                                                                                            t._v(
                                                                                                ' ' +
                                                                                                t._s(
                                                                                                    t.examReportButton
                                                                                                        .buttonName
                                                                                                ) +
                                                                                                ' '
                                                                                            ),
                                                                                        ]
                                                                                    )
                                                                                    : t._e(),
                                                                            ],
                                                                            1
                                                                        ),
                                                                    ]
                                                                )
                                                                : t._e(),
                                                            t.syllabusData.material &&
                                                                t.syllabusData.material.count > 0
                                                                ? e(
                                                                    'section',
                                                                    {
                                                                        staticClass: 'resources',
                                                                        class: t.assignmentButton.buttonName
                                                                            ? 'resources-no-radius'
                                                                            : 'resources-radius',
                                                                    },
                                                                    [
                                                                        e('div', { staticClass: 'class-info' }, [
                                                                            e('span', {
                                                                                staticClass:
                                                                                    'resources-icon common-icon',
                                                                            }),
                                                                            e('label', [
                                                                                e('span', { staticClass: 'title' }, [
                                                                                    t._v(
                                                                                        t._s(
                                                                                            t.$t('courses.detail.resources')
                                                                                        )
                                                                                    ),
                                                                                ]),
                                                                            ]),
                                                                        ]),
                                                                        t.syllabusData.material
                                                                            ? e(
                                                                                'div',
                                                                                { staticClass: 'button-wrapper' },
                                                                                [
                                                                                    e(
                                                                                        'a-button',
                                                                                        {
                                                                                            directives: [
                                                                                                {
                                                                                                    name: 'mark-scroll',
                                                                                                    rawName: 'v-mark-scroll',
                                                                                                    value: 'courseDetail',
                                                                                                    expression:
                                                                                                        "'courseDetail'",
                                                                                                },
                                                                                            ],
                                                                                            staticClass: 'color-orange',
                                                                                            attrs: {
                                                                                                type: 'link',
                                                                                                shape: 'round',
                                                                                                'data-log': '领资料',
                                                                                            },
                                                                                            on: {
                                                                                                click: function (e) {
                                                                                                    return t.handleToStudyResource(
                                                                                                        t.syllabusData
                                                                                                    )
                                                                                                },
                                                                                            },
                                                                                        },
                                                                                        [
                                                                                            1 ==
                                                                                                t.syllabusData.material.count
                                                                                                ? e('span', [
                                                                                                    t._v(
                                                                                                        t._s(
                                                                                                            t.syllabusData
                                                                                                                .material.count
                                                                                                        ) +
                                                                                                        ' ' +
                                                                                                        t._s(
                                                                                                            t.$t(
                                                                                                                'courses.detail.file'
                                                                                                            )
                                                                                                        )
                                                                                                    ),
                                                                                                ])
                                                                                                : e('span', [
                                                                                                    t._v(
                                                                                                        t._s(
                                                                                                            t.syllabusData
                                                                                                                .material.count
                                                                                                        ) +
                                                                                                        ' ' +
                                                                                                        t._s(
                                                                                                            t.$t(
                                                                                                                'courses.detail.files'
                                                                                                            )
                                                                                                        )
                                                                                                    ),
                                                                                                ]),
                                                                                        ]
                                                                                    ),
                                                                                ],
                                                                                1
                                                                            )
                                                                            : t._e(),
                                                                    ]
                                                                )
                                                                : t._e(),
                                                        ]
                                                    ),
                                                    t.syllabusData.performance.available
                                                        ? e('section', { staticClass: 'lesson-report' }, [
                                                            e(
                                                                'div',
                                                                {
                                                                    directives: [
                                                                        {
                                                                            name: 'mark-scroll',
                                                                            rawName: 'v-mark-scroll',
                                                                            value: 'courseDetail',
                                                                            expression: "'courseDetail'",
                                                                        },
                                                                    ],
                                                                    staticClass: 'report',
                                                                    attrs: { 'data-log': '学情报告' },
                                                                    on: {
                                                                        click: function (e) {
                                                                            return t.jumpToLessonReport(
                                                                                t.syllabusData
                                                                            )
                                                                        },
                                                                    },
                                                                },
                                                                [
                                                                    e('span', [
                                                                        t._v(
                                                                            t._s(
                                                                                t.$t('courses.detail.lessonReport')
                                                                            )
                                                                        ),
                                                                    ]),
                                                                    e('span'),
                                                                ]
                                                            ),
                                                        ])
                                                        : t._e(),
                                                ]),
                                                e(
                                                    'a-modal',
                                                    {
                                                        attrs: {
                                                            visible:
                                                                t.showExpiredTip &&
                                                                6 == t.syllabusData.assignment.status,
                                                            closable: false,
                                                            footer: null,
                                                            width: 386,
                                                            'confirm-loading': t.confirmLoading,
                                                        },
                                                        on: { cancel: t.handleCancel },
                                                    },
                                                    [
                                                        e(
                                                            'div',
                                                            {
                                                                staticClass: 'content',
                                                                attrs: { 'data-log': '作业过期弹窗' },
                                                            },
                                                            [
                                                                e('span', { staticClass: 'title-icon' }),
                                                                e('span', { staticClass: 'title' }, [
                                                                    t._v(
                                                                        t._s(t.$t('courses.detail.expiredTips'))
                                                                    ),
                                                                ]),
                                                                e('div', { staticClass: 'btn' }, [
                                                                    e(
                                                                        'div',
                                                                        {
                                                                            directives: [
                                                                                {
                                                                                    name: 'mark-scroll',
                                                                                    rawName: 'v-mark-scroll',
                                                                                    value: 'courseDetail',
                                                                                    expression: "'courseDetail'",
                                                                                },
                                                                            ],
                                                                            staticClass: 'no',
                                                                            on: { click: t.handleMouseout },
                                                                        },
                                                                        [
                                                                            t._v(
                                                                                ' ' + t._s(t.$t('common.cancel')) + ' '
                                                                            ),
                                                                        ]
                                                                    ),
                                                                    e(
                                                                        'div',
                                                                        {
                                                                            directives: [
                                                                                {
                                                                                    name: 'mark-scroll',
                                                                                    rawName: 'v-mark-scroll',
                                                                                    value: 'courseDetail',
                                                                                    expression: "'courseDetail'",
                                                                                },
                                                                            ],
                                                                            staticClass: 'yes',
                                                                            attrs: {
                                                                                'data-log': t.$t(
                                                                                    'courses.detail.homework.status[5]'
                                                                                ),
                                                                            },
                                                                            on: { click: t.handleAssignmentJump },
                                                                        },
                                                                        [
                                                                            t._v(
                                                                                ' ' +
                                                                                t._s(
                                                                                    t.$t(
                                                                                        'courses.detail.homework.status[5]'
                                                                                    )
                                                                                ) +
                                                                                ' '
                                                                            ),
                                                                        ]
                                                                    ),
                                                                ]),
                                                            ]
                                                        ),
                                                    ]
                                                ),
                                            ],
                                            1
                                        )
                                        : e('div', [
                                            e('div', { staticClass: 'exam-card' }, [
                                                e('div', { staticClass: 'exam-tag' }),
                                                e('div', { staticClass: 'exam-info' }, [
                                                    e('div', { staticClass: 'title' }, [
                                                        t._v(' ' + t._s(t.syllabusData.examName) + ' '),
                                                    ]),
                                                ]),
                                                e(
                                                    'div',
                                                    { staticClass: 'button-wrapper' },
                                                    [
                                                        e(
                                                            'a-button',
                                                            {
                                                                directives: [
                                                                    {
                                                                        name: 'mark-scroll',
                                                                        rawName: 'v-mark-scroll',
                                                                        value: 'courseDetail',
                                                                        expression: "'courseDetail'",
                                                                    },
                                                                    {
                                                                        name: 'log',
                                                                        rawName: 'v-log',
                                                                    },
                                                                ],
                                                                class: [t.examButton.buttonClassName],
                                                                attrs: {
                                                                    type: 'link',
                                                                    shape: 'round',
                                                                    loading: t.examBtnLoading,
                                                                    'data-log': t.examButton.buttonName,
                                                                },
                                                                on: {
                                                                    click: function (e) {
                                                                        return (
                                                                            e.stopPropagation(),
                                                                            t.handleExamButton.apply(null, arguments)
                                                                        )
                                                                    },
                                                                },
                                                            },
                                                            [t._v(' ' + t._s(t.examButton.buttonName) + ' ')]
                                                        ),
                                                        t.showExamTips
                                                            ? e('div', { staticClass: 'tooltip' }, [
                                                                e('span', [
                                                                    t._v(t._s(t.$t('courses.detail.examTip'))),
                                                                ]),
                                                                e('label'),
                                                            ])
                                                            : t._e(),
                                                    ],
                                                    1
                                                ),
                                            ]),
                                        ]),
                                ]
                            )
                        }),
                p = [],
                m = a('5530'),
                f = (a('14d9'), a('a9e3'), a('caad'), a('0a4b')),
                h = a('c1df'),
                b = a.n(h),
                v = a('22de'),
                w = a('7e54'),
                y = a('c342'),
                C = a('e417'),
                _ = a('e39c'),
                g = a('9b0f'),
                x = a('d0db'),
                k = a('0a06a'),
                O = {
                    name: 'SyllabusCard',
                    props: {
                        isOpenParentEntry: {
                            type: Boolean,
                            default: false,
                        },
                        index: {
                            default: 0,
                            type: Number,
                        },
                        teachers: {
                            default: function () {
                                return []
                            },
                            type: Array,
                        },
                        courseDatas: {
                            default: function () {
                                return {}
                            },
                            type: Object,
                        },
                        syllabusData: {
                            default: function () {
                                return {}
                            },
                            type: Object,
                        },
                        scheduleType: {
                            default: 'LESSON',
                            type: String,
                        },
                    },
                    filters: {
                        handleAssignmentEndTime: function (t, e) {
                            var s = b()(t).format(a[e])
                            return s
                        },
                    },
                    computed: {
                        showParentAuditBtn: function () {
                            return (
                                2 == this.status &&
                                'FORMAL' == this.syllabusData.lessonType &&
                                this.isOpenParentEntry &&
                                1 != this.syllabusData.subPlatformType
                            )
                        },
                        padIndex: function () {
                            return this.index <= 9 ? '0' + this.index : this.index
                        },
                        lessonType: function () {
                            var t = {
                                PLAYBACK: this.$t('courses.lessonType.playback'),
                                AUDITION: this.$t('courses.lessonType.audition'),
                                TEMPORARY: this.$t('courses.lessonType.temporary'),
                                TRANSFERRED: this.$t('courses.detail.transferred'),
                            }
                            return t[this.syllabusData.lessonFlag]
                        },
                        assignmentButton: function () {
                            var t = {
                                1: {
                                    buttonClassName: '',
                                    buttonName: '',
                                },
                                2: {
                                    buttonClassName: 'color-nobg',
                                    buttonName: this.$t('courses.detail.homework.status[0]'),
                                },
                                3: {
                                    buttonClassName: 'color-green',
                                    buttonName: this.$t('courses.detail.homework.status[1]'),
                                },
                                4: {
                                    buttonClassName: 'color-nobg',
                                    buttonName: this.$t('courses.detail.homework.status[2]'),
                                },
                                5: {
                                    buttonClassName: 'color-nobg',
                                    buttonName: this.$t('courses.detail.homework.status[3]'),
                                },
                                6: {
                                    buttonClassName: 'color-nobg',
                                    buttonName: this.$t('courses.detail.homework.status[4]'),
                                },
                            }
                            return t[this.syllabusData.assignment.status]
                        },
                        examReportButton: function () {
                            var t = {
                                3: {
                                    buttonClassName: 'color-orange',
                                    buttonName: this.$t('courses.detail.reportSubmitText'),
                                },
                                4: {
                                    buttonClassName: 'color-orange',
                                    buttonName: this.$t('courses.detail.reportBtnText'),
                                },
                                5: {
                                    buttonClassName: 'color-orange',
                                    buttonName: this.$t('courses.detail.reportExpiredText'),
                                },
                            },
                                e = {
                                    buttonName: this.$t('courses.detail.startTest'),
                                    buttonClassName: 'color-green',
                                },
                                a = this.syllabusData.exam,
                                s = a.supportAfterAnswer,
                                n = a.canViewReport,
                                r = a.status,
                                o = n ? t[r] : null
                            return s ? ([3, 4].includes(r) || 5 === r ? o : e) : o
                        },
                        previewQuestionButton: function () {
                            var t = {
                                1: {
                                    buttonClassName: '',
                                    buttonName: '',
                                },
                                2: {
                                    buttonClassName: 'color-nobg',
                                    buttonName: this.$t('courses.detail.homework.status[0]'),
                                },
                                3: {
                                    buttonClassName: 'color-green',
                                    buttonName: this.$t('courses.detail.homework.status[6]'),
                                },
                                4: {
                                    buttonClassName: 'color-nobg',
                                    buttonName: this.$t('courses.detail.homework.status[2]'),
                                },
                                5: {
                                    buttonClassName: 'color-nobg',
                                    buttonName: this.$t('courses.detail.homework.status[3]'),
                                },
                                6: {
                                    buttonClassName: 'color-nobg',
                                    buttonName: this.$t('courses.detail.homework.status[4]'),
                                },
                            }
                            return t[this.syllabusData.previewQuestion.status]
                        },
                        classroomButton: function () {
                            if (1 == this.isAudition && 2 == this.status) {
                                return {
                                    buttonClassName: 'color-orange',
                                    buttonName: this.$t(
                                        'courses.detail.playButton.startAuditing'
                                    ),
                                }
                            }
                            var t = {
                                1: {
                                    buttonClassName: 'color-gray',
                                    buttonName: this.$t('courses.detail.playButton.startSoon'),
                                },
                                2: {
                                    buttonClassName: 'color-orange',
                                    buttonName: this.$t('courses.detail.playButton.live'),
                                },
                                3: {
                                    buttonClassName: 'color-orange',
                                    buttonName: this.$t(
                                        'courses.detail.playButton.playbackGenerating'
                                    ),
                                },
                                4: {
                                    buttonClassName: 'color-orange',
                                    buttonName: this.$t('courses.detail.playButton.playback'),
                                },
                                5: {
                                    buttonClassName: 'color-gray',
                                    buttonName: this.$t(
                                        'courses.detail.playButton.playbackExpired'
                                    ),
                                },
                                6: {
                                    buttonClassName: 'color-text',
                                    buttonName: this.$t('courses.detail.playButton.unpaid'),
                                },
                            }
                            return t[this.status]
                        },
                        examButton: function () {
                            var t = {
                                1: {
                                    buttonClassName: 'color-gray',
                                    buttonName: this.$t('courses.detail.exam.status[0]'),
                                },
                                2: {
                                    buttonClassName: 'color-orange',
                                    buttonName: this.$t('courses.detail.exam.status[1]'),
                                },
                                3: {
                                    buttonClassName: 'color-orange',
                                    buttonName: this.$t('courses.detail.exam.status[2]'),
                                },
                                4: {
                                    buttonClassName: 'color-orange',
                                    buttonName: this.$t('courses.detail.exam.status[3]'),
                                },
                                5: {
                                    buttonClassName: 'color-orange',
                                    buttonName: this.$t('courses.detail.exam.status[4]'),
                                },
                            }
                            return t[this.syllabusData.examStatus]
                        },
                        isAudition: function () {
                            return 'AUDITION' === this.syllabusData.lessonType ? 1 : 0
                        },
                    },
                    data: function () {
                        var t =
                            'LESSON' === this.scheduleType ? this.syllabusData.status : 1
                        return {
                            demo: false,
                            local: this.$store.state.common.local,
                            status: t,
                            loading: false,
                            parentAuditLoading: false,
                            showGenerateTips: false,
                            showExamTips: false,
                            timer: null,
                            examTimer: null,
                            showExpiredTip: false,
                            previewBtnLoading: false,
                            assignmentBtnLoading: false,
                            examBtnLoading: false,
                            classExamBtnLoading: false,
                        }
                    },
                    methods: {
                        handleAssignmentButton: function () {
                            2 != this.syllabusData.assignment.status &&
                                (6 != this.syllabusData.assignment.status ||
                                    0 != this.syllabusData.assignment.sourceType
                                    ? 6 == this.syllabusData.assignment.status
                                        ? (this.showExpiredTip = !this.showExpiredTip)
                                        : this.handleAssignmentJump()
                                    : this.handleOldAssignmentButton())
                        },
                        showNextBtn: function (t) {
                            return 4 == t || 5 == t || 6 == t
                        },
                        fullColumn: function (t) {
                            return (
                                !!(t.previewQuestion && t.assignment && t.material) &&
                                1 == t.assignment.status &&
                                1 == t.previewQuestion.status &&
                                t.material.count <= 0
                            )
                        },
                        handlePreviewButton: function (t) {
                            if (2 != t) {
                                this.previewBtnLoading = true
                                var a = window.JSON.stringify(
                                    this.syllabusData.previewQuestion.jumpParams
                                ),
                                    s = ''
                                        .concat('/previewQuestion?', 'backUrl=')
                                        .concat(this.$route.fullPath)
                                window.localStorage.setItem('paperJumpUrlParam', a)
                                this.previewBtnLoading = false
                                k.c(this.syllabusData.planId)
                                this.$router.push({
                                    path: s,
                                    query: {
                                        classId: this.syllabusData.classId,
                                        lessonId: this.syllabusData.planId,
                                        planId: this.syllabusData.previewQuestion.jumpParams.planId,
                                        homeworkId:
                                            this.syllabusData.previewQuestion.jumpParams.homeworkId ||
                                            '',
                                        status: this.syllabusData.previewQuestion
                                            ? this.syllabusData.previewQuestion.status
                                            : 6,
                                    },
                                })
                            }
                        },
                        handleAssignmentJump: function () {
                            k.b(this.syllabusData.planId)
                            var e = this.syllabusData.assignment.sourceType
                            0 == e
                                ? this.handleOldAssignmentButton()
                                : 1 === e &&
                                this.handleNewAssignmentButton(
                                    '/new-assignment?assignmentUrl'
                                )
                        },
                        handleNewAssignmentButton: function (t) {
                            var e = this
                            this.assignmentBtnLoading = true
                            var a = this.syllabusData.assignment.jumpParams,
                                s = a.planId,
                                n = a.classId,
                                r = a.homeworkId
                            Object(v.d)(this, this.syllabusData.assignment.jumpParams).then(
                                function (a) {
                                    if (a) {
                                        var o = a.data
                                        e.assignmentBtnLoading = false
                                        o &&
                                            e.$router.push({
                                                path: ''
                                                    .concat(t, '=')
                                                    .concat(encodeURIComponent(o), '&backUrl=')
                                                    .concat(e.$route.fullPath),
                                                query: {
                                                    planId: s,
                                                    classId: n,
                                                    homeworkStatus: e.syllabusData.assignment.status,
                                                    homeworkId: r,
                                                },
                                            })
                                    }
                                }
                            )
                        },
                        handleOldAssignmentButton: function () {
                            var t = this.syllabusData.assignment.url
                            t &&
                                this.$router.push(
                                    '/assignment?assignmentUrl='
                                        .concat(encodeURIComponent(t), '&backUrl=')
                                        .concat(this.$route.fullPath)
                                )
                        },
                        handleMouseEnter: function () {
                            this.showExpiredTip = true
                        },
                        handleMouseout: function () {
                            this.showExpiredTip = false
                        },
                        jumpToLessonReport: function () {
                            var t = this.syllabusData.performance.url
                            window.localStorage.setItem('lessonReportUrl', t)
                            window.localStorage.setItem(
                                'syllabusDatalist',
                                this.$route.fullPath
                            )
                            k.a(this.syllabusData.planId)
                            t &&
                                this.$router.push({
                                    path: '/lessonReport?lessonReportUrl='
                                        .concat(encodeURIComponent(t), '&backUrl=')
                                        .concat(this.$route.fullPath),
                                    query: { planId: this.syllabusData.planId },
                                })
                        },
                        handleExamButton: function (t) {
                            var e = this
                            return Object(o.a)(
                                Object(r.a)().mark(function a() {
                                    return Object(r.a)().wrap(function (a) {
                                        while (1) {
                                            switch ((a.prev = a.next)) {
                                                case 0:
                                                    if (
                                                        (t.stopPropagation(),
                                                            1 != e.syllabusData.examStatus)
                                                    ) {
                                                        a.next = 6
                                                        break
                                                    }
                                                    return (
                                                        (e.showExamTips = true),
                                                        clearTimeout(e.examTimer),
                                                        (e.examTimer = setTimeout(function () {
                                                            e.showExamTips = false
                                                        }, 3000)),
                                                        a.abrupt('return')
                                                    )
                                                case 6:
                                                    ; (e.examBtnLoading = true),
                                                        e.$router.push({
                                                            path: '/examIntro',
                                                            query: e.syllabusData.jumpParams,
                                                        })
                                                case 8:
                                                case 'end':
                                                    return a.stop()
                                            }
                                        }
                                    }, a)
                                })
                            )()
                        },
                        handleClassExam: function (t) {
                            t.stopPropagation()
                            this.classExamBtnLoading = true
                            this.$router.push({
                                path: '/examIntro',
                                query: this.syllabusData.exam.jumpParams,
                            })
                        },
                        toParentAudit: function () {
                            this.parentAuditLoading = true
                            this.clickButtonEvent('hw_parent_class_enter_click')
                            this.jumpToClassRoom(t)
                        },
                        handleClassroomButton: function (t) {
                            var e = this
                            return Object(o.a)(
                                Object(r.a)().mark(function a() {
                                    var s, n
                                    return Object(r.a)().wrap(function (a) {
                                        while (1) {
                                            switch ((a.prev = a.next)) {
                                                case 0:
                                                    if (
                                                        (t.stopPropagation(),
                                                            1 != e.status && 5 != e.status && 6 != e.status)
                                                    ) {
                                                        a.next = 3
                                                        break
                                                    }
                                                    return a.abrupt('return')
                                                case 3:
                                                    if (3 != e.status) {
                                                        a.next = 8
                                                        break
                                                    }
                                                    return (
                                                        (e.showGenerateTips = true),
                                                        clearTimeout(e.timer),
                                                        (e.timer = setTimeout(function () {
                                                            e.showGenerateTips = false
                                                        }, 3000)),
                                                        a.abrupt('return')
                                                    )
                                                case 8:
                                                    if (4 != e.status) {
                                                        a.next = 15
                                                        break
                                                    }
                                                    return (
                                                        (e.loading = true),
                                                        e.deletePlayBackFiles(),
                                                        e.clickButtonEvent('hw_stu_class_list_click', {
                                                            previous_source: '学习中心二级页面',
                                                            plan_mode: '回放',
                                                        }),
                                                        (s = {
                                                            isAudition: e.isAudition,
                                                            playback: 1,
                                                            isParent: 0,
                                                        }),
                                                        e.jumpToClassRoom(s),
                                                        a.abrupt('return')
                                                    )
                                                case 15:
                                                    2 == e.status &&
                                                        ((e.loading = true),
                                                            0 == e.isAudition &&
                                                            e.clickButtonEvent('hw_stu_class_list_click', {
                                                                previous_source: '学习中心二级页面',
                                                                plan_mode: '直播',
                                                            }),
                                                            (n = {
                                                                isAudition: e.isAudition,
                                                                playback: 0,
                                                                isParent: 0,
                                                            }),
                                                            e.jumpToClassRoom(n, e.beforeJumpToClassRoom))
                                                case 16:
                                                case 'end':
                                                    return a.stop()
                                            }
                                        }
                                    }, a)
                                })
                            )()
                        },
                        deletePlayBackFiles: function () {
                            return Object(o.a)(
                                Object(r.a)().mark(function t() {
                                    var e, a
                                    return Object(r.a)().wrap(function (t) {
                                        while (1) {
                                            switch ((t.prev = t.next)) {
                                                case 0:
                                                    return (
                                                        (t.next = 2), f.nativeApi.getPathByName('userData')
                                                    )
                                                case 2:
                                                    if (
                                                        ((e = t.sent),
                                                            (a = ''.concat(e, '/playback')),
                                                            Object(g.existsSync)(a),
                                                            Object(g.existsSync)(a))
                                                    ) {
                                                        t.next = 8
                                                        break
                                                    }
                                                    return (
                                                        x.a.send({
                                                            tag: 'deletePlayback',
                                                            content: { msg: 'playback文件夹不存在' },
                                                        }),
                                                        t.abrupt('return')
                                                    )
                                                case 8:
                                                    Object(_.f)(a, 7)
                                                case 9:
                                                case 'end':
                                                    return t.stop()
                                            }
                                        }
                                    }, t)
                                })
                            )()
                        },
                        teachMethod: function (t) {
                            var e = this
                            t.stopPropagation()
                            var a = {
                                data: {
                                    classId: this.syllabusData.classId,
                                    orderNum: this.syllabusData.orderNum,
                                },
                            }
                            Object(w.f)(this, a)
                                .then(function (t) {
                                    if (0 === t.code) {
                                        var a = {
                                            zoom: t.data.zoom,
                                            classIn: t.data.classIn,
                                            platformType: e.syllabusData.platformType,
                                        }
                                        e.$emit('showAttendClass', a)
                                    }
                                })
                                .catch(function (t) {
                                    console.error('getTeachMethod', t)
                                })
                        },
                        jumpToClassRoom: function (t, e) {
                            var a = this,
                                s = Object(m.a)(
                                    {
                                        planId: this.syllabusData.planId,
                                        classId: this.syllabusData.classId,
                                        subPlatformType: this.syllabusData.subPlatformType,
                                        bizId: this.syllabusData.bizId,
                                        lessonType: this.syllabusData.lessonType,
                                        from: 'syllabus',
                                        backUrl: encodeURI(
                                            '/courses-detail?classId='
                                                .concat(this.syllabusData.classId, '&planId=')
                                                .concat(this.syllabusData.planId)
                                        ),
                                    },
                                    t
                                ),
                                n = function (e) {
                                    t.playback
                                        ? a.$router.push({
                                            path: '/playback/ready-class',
                                            query: e,
                                        })
                                        : a.$router.push({
                                            path: '/ready-class',
                                            query: e,
                                        })
                                }
                            'function' === typeof e ? e(s, n) : n(s)
                        },
                        beforeJumpToClassRoom: function (t, e) {
                            var a = this
                            return Object(o.a)(
                                Object(r.a)().mark(function s() {
                                    var n
                                    return Object(r.a)().wrap(function (s) {
                                        while (1) {
                                            switch ((s.prev = s.next)) {
                                                case 0:
                                                    return (s.next = 2), a.studentInClass()
                                                case 2:
                                                    ; (n = s.sent),
                                                        n
                                                            ? ((a.loading = false), a.$emit('openConfirm', t))
                                                            : e(t)
                                                case 4:
                                                case 'end':
                                                    return s.stop()
                                            }
                                        }
                                    }, s)
                                })
                            )()
                        },
                        studentInClass: function () {
                            var t = this
                            return Object(o.a)(
                                Object(r.a)().mark(function e() {
                                    var a
                                    return Object(r.a)().wrap(function (e) {
                                        while (1) {
                                            switch ((e.prev = e.next)) {
                                                case 0:
                                                    return (
                                                        (e.next = 2),
                                                        Object(y.j)({ planId: t.syllabusData.planId })
                                                    )
                                                case 2:
                                                    if (((a = e.sent), 0 != a.code)) {
                                                        e.next = 7
                                                        break
                                                    }
                                                    return e.abrupt(
                                                        'return',
                                                        2 == a.data.lastInClassSameDevice &&
                                                        1 == a.data.maybeInClass
                                                    )
                                                case 7:
                                                    return e.abrupt('return', false)
                                                case 8:
                                                case 'end':
                                                    return e.stop()
                                            }
                                        }
                                    }, e)
                                })
                            )()
                        },
                        handleToStudyResource: function (t) {
                            k.f(t.planId)
                            this.$router.push({
                                path: '/studyResources',
                                query: {
                                    classId: this.courseDatas.classId,
                                    lessonId: t.planId,
                                    filesNumber: t.material ? t.material.count : 0,
                                    backUrl: ''.concat(this.$route.fullPath),
                                },
                            })
                        },
                        showCount: function (t) {
                            if (t && t.material) {
                                return t.material.count >= 2
                                    ? ''.concat(t.materia.count, 'Files')
                                    : (t.material.count, ''.concat(t.material.count, 'File'))
                            }
                        },
                        buildSensorsData: function () {
                            return {
                                plan_id: this.syllabusData.planId,
                                class_id: this.syllabusData.classId,
                                package_id: this.syllabusData.packageId,
                                lesson_type: C.f[this.syllabusData.subPlatformType],
                            }
                        },
                        clickButtonEvent: function (t) {
                            var e =
                                arguments.length > 1 && void 0 !== arguments[1]
                                    ? arguments[1]
                                    : {}
                            this.$sensors.track(
                                t,
                                Object(m.a)(Object(m.a)({}, this.buildSensorsData()), e)
                            )
                        },
                    },
                    mounted: function () {
                        window.localStorage.removeItem('previewStatus')
                    },
                    destoryed: function () {
                        clearTimeout(this.timer)
                        clearTimeout(this.examTimer)
                    },
                },
                D = O,
                j = (a('5fb8'), a('2877')),
                A = Object(j.a)(D, d, p, false, null, '2b696f8d', null),
                T = A.exports,
                N = function () {
                    var t = this,
                        e = t._self._c
                    return e(
                        'a-modal',
                        {
                            attrs: {
                                width: 343,
                                centered: true,
                                closable: false,
                                keyboard: false,
                                okText: t.$t('courses.confirmModal.backBtn'),
                                cancelText: t.$t('courses.confirmModal.enterBtn'),
                                dialogClass: 'modal-simple no-apu-header',
                            },
                            on: {
                                ok: function (e) {
                                    t.showModal = false
                                },
                                cancel: t.joinClassRoom,
                            },
                            model: {
                                value: t.showModal,
                                callback: function (e) {
                                    t.showModal = e
                                },
                                expression: 'showModal',
                            },
                        },
                        [
                            e('div', { staticClass: 'confirm-title' }, [
                                t._v(' ' + t._s(t.$t('courses.confirmModal.title')) + ' '),
                            ]),
                            e(
                                'div',
                                { staticClass: 'confirm-con is-keep-all' },
                                [
                                    e(
                                        'i18n',
                                        {
                                            attrs: {
                                                path: 'courses.confirmModal.content',
                                                tag: false,
                                            },
                                        },
                                        [
                                            e(
                                                'span',
                                                {
                                                    staticClass: 'redText',
                                                    attrs: { slot: 'warning' },
                                                    slot: 'warning',
                                                },
                                                [t._v(t._s(t.$t('courses.confirmModal.warning')))]
                                            ),
                                        ]
                                    ),
                                ],
                                1
                            ),
                        ]
                    )
                },
                I = [],
                P = {
                    data: function () {
                        return { showModal: false }
                    },
                    props: {
                        visible: {
                            type: Boolean,
                            default: false,
                        },
                        params: {
                            type: Object,
                            default: function () {
                                return {}
                            },
                        },
                    },
                    watch: {
                        visible: function (t) {
                            console.info(
                                '对象函数 visible(val)',
                                t,
                                'filePath:renderer/components/Courses/ConfirmGoClassRoom.vue'
                            )
                            this.showModal = t
                        },
                        showModal: function (t) {
                            console.info(
                                '对象函数 showModal(val)',
                                t,
                                'filePath:renderer/components/Courses/ConfirmGoClassRoom.vue'
                            )
                            this.$emit('update:visible', t)
                        },
                    },
                    methods: {
                        joinClassRoom: function () {
                            console.info(
                                '对象函数 joinClassRoom,filePath:renderer/components/Courses/ConfirmGoClassRoom.vue'
                            )
                            this.$router.push({
                                path: '/ready-class',
                                query: this.params,
                            })
                        },
                    },
                },
                $ = P,
                B = (a('76f4'), Object(j.a)($, N, I, false, null, 'ff725d2e', null)),
                S = B.exports,
                L = a('35ac'),
                E = function () {
                    var t = this,
                        e = t._self._c
                    return e(
                        'a-modal',
                        {
                            attrs: {
                                width: 400,
                                footer: null,
                                maskClosable: false,
                                centered: true,
                                keyboard: false,
                                dialogClass: 'modal-simple close-color-white',
                            },
                            model: {
                                value: t.visible,
                                callback: function (e) {
                                    t.visible = e
                                },
                                expression: 'visible',
                            },
                        },
                        [
                            e(
                                'div',
                                { staticClass: 'how-to-attend' },
                                [
                                    e('div', { staticClass: 'header' }, [
                                        t._v(t._s(t.$t('courses.faceToFace.attendClass'))),
                                    ]),
                                    'ZOOM' === t.data.platformType
                                        ? [
                                            e('ul', { staticClass: 'bg-list' }, [
                                                e('li', { staticClass: 'list-item left-right' }, [
                                                    e('div', { staticClass: 'label' }, [
                                                        t._v(t._s(t.$t('courses.faceToFace.location'))),
                                                    ]),
                                                    e('div', { staticClass: 'value' }, [t._v('Zoom')]),
                                                ]),
                                                e('li', { staticClass: 'list-item can-copy' }, [
                                                    e('div', { staticClass: 'top' }, [
                                                        e('div', { staticClass: 'label' }, [
                                                            t._v(t._s(t.$t('courses.faceToFace.zoomId'))),
                                                        ]),
                                                        e(
                                                            'div',
                                                            {
                                                                staticClass: 'copy-btn',
                                                                on: {
                                                                    click: function (e) {
                                                                        return t.copyText('999-999-999')
                                                                    },
                                                                },
                                                            },
                                                            [
                                                                e('span', [
                                                                    t._v(t._s(t.$t('courses.faceToFace.copy'))),
                                                                ]),
                                                                e('img', {
                                                                    attrs: {
                                                                        src: a('04e4'),
                                                                        alt: '',
                                                                    },
                                                                }),
                                                            ]
                                                        ),
                                                    ]),
                                                    e('div', { staticClass: 'value' }, [
                                                        t._v(t._s(t.data.zoom && t.data.zoom.id)),
                                                    ]),
                                                ]),
                                                e('li', { staticClass: 'list-item can-copy' }, [
                                                    e('div', { staticClass: 'top' }, [
                                                        e('div', { staticClass: 'label' }, [
                                                            t._v(
                                                                t._s(t.$t('courses.faceToFace.zoomPassword'))
                                                            ),
                                                        ]),
                                                        e('div', { staticClass: 'copy-btn' }, [
                                                            e('span', [
                                                                t._v(t._s(t.$t('courses.faceToFace.copy'))),
                                                            ]),
                                                            e('img', {
                                                                attrs: {
                                                                    src: a('04e4'),
                                                                    alt: '',
                                                                },
                                                            }),
                                                        ]),
                                                    ]),
                                                    e('div', { staticClass: 'value' }, [
                                                        t._v(t._s(t.data.zoom && t.data.zoom.password)),
                                                    ]),
                                                ]),
                                            ]),
                                            e('div', { staticClass: 'strong-words' }, [
                                                e('span', { staticClass: 'strong' }, [
                                                    t._v(t._s(t.$t('courses.faceToFace.zoomDownload'))),
                                                ]),
                                                t._v(
                                                    ' ' +
                                                    t._s(t.$t('courses.faceToFace.zoomDescribe')) +
                                                    ' '
                                                ),
                                            ]),
                                        ]
                                        : 'CLASS_IN' === t.data.platformType
                                            ? [
                                                e('ul', { staticClass: 'bg-list' }, [
                                                    e('li', { staticClass: 'list-item left-right' }, [
                                                        e('div', { staticClass: 'label' }, [
                                                            t._v(t._s(t.$t('courses.faceToFace.location'))),
                                                        ]),
                                                        e('div', { staticClass: 'value' }, [
                                                            t._v('Classin'),
                                                        ]),
                                                    ]),
                                                    e('li', { staticClass: 'list-item can-copy' }, [
                                                        e('div', { staticClass: 'top' }, [
                                                            e('div', { staticClass: 'label' }, [
                                                                t._v(
                                                                    t._s(t.$t('courses.faceToFace.classinLink'))
                                                                ),
                                                            ]),
                                                            e('div', { staticClass: 'copy-btn' }, [
                                                                e('span', [
                                                                    t._v(t._s(t.$t('courses.faceToFace.copy'))),
                                                                ]),
                                                                e('img', {
                                                                    attrs: {
                                                                        src: a('04e4'),
                                                                        alt: '',
                                                                    },
                                                                }),
                                                            ]),
                                                        ]),
                                                        e('div', { staticClass: 'value' }, [
                                                            t._v(t._s(t.data.classIn && t.data.classIn.href)),
                                                        ]),
                                                    ]),
                                                ]),
                                                e('div', { staticClass: 'strong-words' }, [
                                                    e('span', { staticClass: 'strong' }, [
                                                        t._v(
                                                            t._s(t.$t('courses.faceToFace.classinDownload'))
                                                        ),
                                                    ]),
                                                    t._v(
                                                        ' ' +
                                                        t._s(t.$t('courses.faceToFace.classinDescribe')) +
                                                        ' '
                                                    ),
                                                ]),
                                            ]
                                            : 'OFFLINE' === t.data.platformType ||
                                                'DUAL' === t.data.platformType
                                                ? [
                                                    e('div', { staticClass: 'main-content' }, [
                                                        e('div', { staticClass: 'label' }, [
                                                            t._v(t._s(t.$t('courses.faceToFace.location'))),
                                                        ]),
                                                        e('div', { staticClass: 'value' }, [
                                                            t._v(
                                                                t._s(t.$t('courses.faceToFace.classroomDescribe'))
                                                            ),
                                                        ]),
                                                    ]),
                                                    e('div', { staticClass: 'subtip' }, [
                                                        t._v(
                                                            t._s(t.$t('courses.faceToFace.classroomDescribe'))
                                                        ),
                                                    ]),
                                                ]
                                                : e('div', { staticClass: 'call-container' }, [
                                                    e('p', { staticClass: 'words' }, [
                                                        t._v(t._s(t.$t('courses.faceToFace.ipadDescribe'))),
                                                    ]),
                                                    e('p', { staticClass: 'strong' }, [
                                                        t._v('844-844-6587'),
                                                    ]),
                                                ]),
                                    e(
                                        'div',
                                        { staticClass: 'button-wrapper' },
                                        [
                                            e(
                                                'a-button',
                                                {
                                                    attrs: {
                                                        size: 'large',
                                                        type: 'primary',
                                                        shape: 'round',
                                                        block: '',
                                                    },
                                                    on: { click: t.closeModal },
                                                },
                                                [t._v(' ' + t._s(t.$t('common.gotIt')) + ' ')]
                                            ),
                                        ],
                                        1
                                    ),
                                ],
                                2
                            ),
                        ]
                    )
                },
                M = [],
                R = {
                    props: {
                        data: {
                            type: Object,
                            default: function () {
                                return (
                                    console.info(
                                        '对象函数 default,filePath:renderer/components/Courses/HowToAttendClass.vue'
                                    ),
                                    {}
                                )
                            },
                        },
                        visible: {
                            type: Boolean,
                            default: false,
                        },
                    },
                    methods: {
                        copyText: function (t) {
                            console.info(
                                '对象函数 copyText(text)',
                                t,
                                'filePath:renderer/components/Courses/HowToAttendClass.vue'
                            )
                            var e = document.createElement('input')
                            e.value = t
                            document.body.appendChild(e)
                            e.select()
                            document.execCommand('copy') && document.execCommand('copy')
                            document.body.removeChild(e)
                        },
                        closeModal: function () {
                            console.info(
                                '对象函数 closeModal,filePath:renderer/components/Courses/HowToAttendClass.vue'
                            )
                            this.$emit('closeModal')
                        },
                    },
                },
                U = R,
                F = (a('9222'), Object(j.a)(U, E, M, false, null, '0359675c', null)),
                q = F.exports,
                G = {
                    name: 'SyllabusList',
                    data: function () {
                        return {
                            showConfirmModal: false,
                            needParams: {},
                            isOpenParentEntry: false,
                            attendClassData: {},
                            showAttendModal: false,
                        }
                    },
                    methods: {
                        openConfirm: function (t) {
                            console.info(
                                '对象函数 openConfirm(params)',
                                t,
                                'filePath:renderer/components/Courses/SyllabusList.vue'
                            )
                            this.showConfirmModal = true
                            this.needParams = t
                        },
                        initParentEntry: function () {
                            var t = this
                            return Object(o.a)(
                                Object(r.a)().mark(function e() {
                                    return Object(r.a)().wrap(function (e) {
                                        while (1) {
                                            switch ((e.prev = e.next)) {
                                                case 0:
                                                    return (
                                                        console.info(
                                                            '对象函数 initParentEntry,filePath:renderer/components/Courses/SyllabusList.vue'
                                                        ),
                                                        (e.next = 3),
                                                        Object(L.d)('openParentEntry')
                                                    )
                                                case 3:
                                                    t.isOpenParentEntry = e.sent
                                                case 4:
                                                case 'end':
                                                    return e.stop()
                                            }
                                        }
                                    }, e)
                                })
                            )()
                        },
                        showAttendClass: function (t) {
                            console.info(
                                '对象函数 showAttendClass(data)',
                                t,
                                'filePath:renderer/components/Courses/SyllabusList.vue'
                            )
                            this.attendClassData = t
                            this.showAttendModal = true
                        },
                        closeModal: function () {
                            console.info(
                                '对象函数 closeModal,filePath:renderer/components/Courses/SyllabusList.vue'
                            )
                            this.showAttendModal = false
                        },
                    },
                    created: function () {
                        this.initParentEntry()
                    },
                    components: {
                        SyllabusCard: T,
                        GoClassModal: S,
                        HowToAttendClass: q,
                    },
                    props: {
                        teachers: {
                            default: function () {
                                return []
                            },
                            type: Array,
                        },
                        courseDatas: {
                            default: function () {
                                return {}
                            },
                            type: Object,
                        },
                        dataList: {
                            default: function () {
                                return []
                            },
                            type: Array,
                        },
                    },
                },
                H = G,
                Q = (a('e37b'), Object(j.a)(H, u, l, false, null, '630ffade', null)),
                z = Q.exports,
                J =
                    (a('b0c0'),
                        function () {
                            var t = this,
                                e = t._self._c
                            return t.courseDatas
                                ? e(
                                    'div',
                                    { staticClass: 'nav-wrapper' },
                                    [
                                        e('div', { staticClass: 'content-wrapper' }, [
                                            e('section', { staticClass: 'name-subject' }, [
                                                t.courseDatas.tag
                                                    ? e('span', { staticClass: 'label' }, [
                                                        t._v(t._s(t.courseDatas.tag)),
                                                    ])
                                                    : t._e(),
                                                e('span', [t._v(t._s(t.courseDatas.className || ''))]),
                                            ]),
                                            e(
                                                'section',
                                                { staticClass: 'class-date' },
                                                [
                                                    e('span', { staticClass: 'classtime-icon' }),
                                                    e('span', [
                                                        t._v(t._s(''.concat(t.courseDatas.timeDesc))),
                                                    ]),
                                                    t.courseDatas.timeDesc2
                                                        ? [
                                                            e('span', { staticClass: 'timezone-icon' }),
                                                            e('span', [
                                                                t._v(
                                                                    t._s(''.concat(t.courseDatas.timeDesc2))
                                                                ),
                                                            ]),
                                                        ]
                                                        : t._e(),
                                                ],
                                                2
                                            ),
                                            e(
                                                'section',
                                                {
                                                    ref: 'teacher',
                                                    staticClass: 'teacher',
                                                },
                                                [
                                                    t.showArrow
                                                        ? [
                                                            e('span', {
                                                                staticClass: 'left-arrow',
                                                                on: { click: t.clickLeftArrow },
                                                            }),
                                                            e('span', {
                                                                staticClass: 'left-shadow common-shadow',
                                                            }),
                                                        ]
                                                        : t._e(),
                                                    t.courseDatas.teachers
                                                        ? e(
                                                            'div',
                                                            {
                                                                ref: 'teacherWrapper',
                                                                staticClass: 'teacthers',
                                                            },
                                                            [
                                                                e(
                                                                    'div',
                                                                    {
                                                                        ref: 'scrollWrapper',
                                                                        staticClass: 'teacher-wrapper',
                                                                    },
                                                                    [
                                                                        t._l(
                                                                            t.courseDatas.teachers,
                                                                            function (a, s) {
                                                                                var n
                                                                                return [
                                                                                    e(
                                                                                        'div',
                                                                                        {
                                                                                            key: s,
                                                                                            ref: 'scrollList',
                                                                                            refInFor: true,
                                                                                            staticClass: 'item',
                                                                                        },
                                                                                        [
                                                                                            null !== a &&
                                                                                                void 0 !== a &&
                                                                                                null !==
                                                                                                (n = a.contactInfoListV2) &&
                                                                                                void 0 !== n &&
                                                                                                n.length
                                                                                                ? e(
                                                                                                    'div',
                                                                                                    {
                                                                                                        staticClass:
                                                                                                            'avator-wrap-contact',
                                                                                                        on: {
                                                                                                            click: function (e) {
                                                                                                                return t.openContact(
                                                                                                                    a
                                                                                                                )
                                                                                                            },
                                                                                                        },
                                                                                                    },
                                                                                                    [
                                                                                                        e(
                                                                                                            'span',
                                                                                                            {
                                                                                                                staticClass:
                                                                                                                    'avator-wrap pointer',
                                                                                                            },
                                                                                                            [
                                                                                                                e('a-avatar', {
                                                                                                                    attrs: {
                                                                                                                        icon: 'user',
                                                                                                                        src: a.avatar,
                                                                                                                    },
                                                                                                                }),
                                                                                                                e('span', {
                                                                                                                    class:
                                                                                                                        t.getContactClass(
                                                                                                                            a.contactInfoListV2
                                                                                                                        ),
                                                                                                                }),
                                                                                                                e('span', {
                                                                                                                    staticClass:
                                                                                                                        'contact-masker',
                                                                                                                }),
                                                                                                            ],
                                                                                                            1
                                                                                                        ),
                                                                                                    ]
                                                                                                )
                                                                                                : e(
                                                                                                    'span',
                                                                                                    {
                                                                                                        staticClass:
                                                                                                            'avator-wrap',
                                                                                                    },
                                                                                                    [
                                                                                                        e('a-avatar', {
                                                                                                            attrs: {
                                                                                                                icon: 'user',
                                                                                                                src: a.avatar,
                                                                                                            },
                                                                                                        }),
                                                                                                    ],
                                                                                                    1
                                                                                                ),
                                                                                            e(
                                                                                                'div',
                                                                                                { staticClass: 'info' },
                                                                                                [
                                                                                                    e(
                                                                                                        'div',
                                                                                                        { staticClass: 'name' },
                                                                                                        [t._v(t._s(a.name))]
                                                                                                    ),
                                                                                                    e(
                                                                                                        'span',
                                                                                                        { staticClass: 'title' },
                                                                                                        [
                                                                                                            e('span', [
                                                                                                                t._v(
                                                                                                                    t._s(a.identityName)
                                                                                                                ),
                                                                                                            ]),
                                                                                                        ]
                                                                                                    ),
                                                                                                ]
                                                                                            ),
                                                                                        ]
                                                                                    ),
                                                                                ]
                                                                            }
                                                                        ),
                                                                    ],
                                                                    2
                                                                ),
                                                            ]
                                                        )
                                                        : t._e(),
                                                    t.showArrow
                                                        ? [
                                                            e('span', {
                                                                staticClass: 'right-shadow common-shadow',
                                                            }),
                                                            e('span', {
                                                                staticClass: 'right-arrow',
                                                                on: { click: t.clickRightArrow },
                                                            }),
                                                        ]
                                                        : t._e(),
                                                ],
                                                2
                                            ),
                                        ]),
                                        t.isOpenContact
                                            ? e('TeacherContact', {
                                                attrs: { data: t.curContactInfo },
                                                on: { closeModal: t.closeContact },
                                            })
                                            : t._e(),
                                    ],
                                    1
                                )
                                : t._e()
                        }),
                V = [],
                W = (a('159b'), a('a630'), a('3ca3'), a('8759')),
                K = {
                    name: 'SyllabusNav',
                    components: { TeacherContact: W.a },
                    props: {
                        courseDatas: {
                            default: function () {
                                return {}
                            },
                            type: Object,
                        },
                    },
                    data: function () {
                        return {
                            newTeachers: [],
                            timer: null,
                            animationId: null,
                            showArrow: false,
                            isOpenContact: false,
                            curContactInfo: null,
                        }
                    },
                    methods: {
                        closeContact: function () {
                            console.info(
                                '对象函数 closeContact,filePath:renderer/components/Courses/SyllabusNav.vue'
                            )
                            this.isOpenContact = false
                            this.curContactInfo = null
                        },
                        openContact: function (t) {
                            console.info(
                                '对象函数 openContact(item)',
                                t,
                                'filePath:renderer/components/Courses/SyllabusNav.vue'
                            )
                            this.curContactInfo = t
                            this.isOpenContact = true
                            this.$sensors.track('hw_contact_teacher_icon_click', {
                                teacher_category: t.identityType,
                            })
                        },
                        getContactClass: function (t) {
                            if (
                                (console.info(
                                    '对象函数 getContactClass(list)',
                                    t,
                                    'filePath:renderer/components/Courses/SyllabusNav.vue'
                                ),
                                    t.length > 1)
                            ) {
                                return (
                                    console.info(
                                        'if(list.length > 1)为true触发return,path: /renderer/components/Courses/SyllabusNav.vue'
                                    ),
                                    'contact_normal'
                                )
                            }
                            console.info(
                                'if(list.length > 1)为false,触发return,path: /renderer/components/Courses/SyllabusNav.vue'
                            )
                            return e[t[0].type]
                        },
                        showPrevTeachers: function () {
                            console.info(
                                '对象函数 showPrevTeachers,filePath:renderer/components/Courses/SyllabusNav.vue'
                            )
                            this.$refs.carousel.prev()
                        },
                        showNextTeachers: function () {
                            console.info(
                                '对象函数 showNextTeachers,filePath:renderer/components/Courses/SyllabusNav.vue'
                            )
                            this.$refs.carousel.next()
                        },
                        clickRightArrow: function () {
                            console.info(
                                '对象函数 clickRightArrow,filePath:renderer/components/Courses/SyllabusNav.vue'
                            )
                            this.moveSlow(1)
                        },
                        clickLeftArrow: function () {
                            console.info(
                                '对象函数 clickLeftArrow,filePath:renderer/components/Courses/SyllabusNav.vue'
                            )
                            var t = -1
                            this.moveSlow(t)
                        },
                        moveSlow: function (t) {
                            var e = this
                            console.info(
                                '对象函数 moveSlow(direction)',
                                t,
                                'filePath:renderer/components/Courses/SyllabusNav.vue'
                            )
                            var a = null,
                                s = null,
                                n = 240,
                                r = function r(o) {
                                    console.info(
                                        '箭头函数 step(timestamp)',
                                        o,
                                        'filePath:renderer/components/Courses/SyllabusNav.vue'
                                    )
                                    a || (a = o)
                                    s = o - a
                                    e.$refs.scrollWrapper.scrollLeft += t * Math.min(s / 15, 150)
                                    n -= Math.min(s / 15, 150)
                                    s < 1000 &&
                                        n > 0 &&
                                        (e.animationId = window.requestAnimationFrame(r))
                                }
                            this.animationId = window.requestAnimationFrame(r)
                        },
                        calculateScrollWidth: function () {
                            console.info(
                                '对象函数 calculateScrollWidth,filePath:renderer/components/Courses/SyllabusNav.vue'
                            )
                            var t = document.querySelectorAll('.item'),
                                e = 0
                            Array.from(t).forEach(function (t) {
                                t && t.clientWidth && (e += t.clientWidth)
                            })
                            this.$refs.scrollWrapper &&
                                this.$refs.scrollWrapper.clientWidth <= e &&
                                ((this.showArrow = true),
                                    (this.$refs.teacherWrapper.style.width = '94%'))
                        },
                    },
                    mounted: function () {
                        var t = this
                        this.$nextTick(function () {
                            return t.calculateScrollWidth()
                        })
                    },
                    destoryed: function () {
                        console.info(
                            '对象函数 destoryed,filePath:renderer/components/Courses/SyllabusNav.vue'
                        )
                        window.cancelAnimationFrame(this.animationId)
                    },
                },
                Y = K,
                Z = (a('31bc'), Object(j.a)(Y, J, V, false, null, '5f75df2a', null)),
                X = Z.exports,
                tt = a('c5ee'),
                et = {
                    name: 'CoursesDetail',
                    components: {
                        ErrorStatus: c.a,
                        Loading: i.a,
                        SyllabusList: z,
                        SyllabusNav: X,
                    },
                    data: function () {
                        var t = this.$route.query.classId
                        return {
                            subject: '',
                            isError: false,
                            loading: true,
                            classId: t,
                            dataList: [],
                            teachers: [],
                            courseDatas: {},
                        }
                    },
                    created: function () {
                        this.updateHeaderAttr()
                    },
                    mounted: function () {
                        var t = this
                        this.queryData(function () {
                            console.info(
                                '箭头函数 queryData,filePath:renderer/views/CoursesDetail.vue'
                            )
                            t.checkUpdate()
                            t.preload()
                            t.addContactTeacherSensor()
                            t.$sensors.track('hw_class_detail_pv', {
                                course_category: t.courseDatas.courseType || 0,
                            })
                        })
                        this.$bus.$on('reload', function () {
                            console.info(
                                '箭头函数 监听 reload,filePath:renderer/views/CoursesDetail.vue'
                            )
                            t.queryData(function () {
                                console.info(
                                    '箭头函数 queryData,filePath:renderer/views/CoursesDetail.vue'
                                )
                                t.checkUpdate()
                                t.preload()
                                delete t.$route.query.isNeedBackToCurrentTap
                                t.$bus.$emit('reload-completed')
                            })
                        })
                    },
                    destroyed: function () {
                        console.info(
                            '对象函数 destroyed,filePath:renderer/views/CoursesDetail.vue'
                        )
                        this.$bus.$off('reload')
                    },
                    methods: {
                        addContactTeacherSensor: function () {
                            console.info(
                                '对象函数 addContactTeacherSensor,filePath:renderer/views/CoursesDetail.vue'
                            )
                            var t = this.teachers.filter(function (t) {
                                return 2 === t.identityType
                            }),
                                e = this.teachers.filter(function (t) {
                                    var e
                                    return (
                                        1 === t.identityType &&
                                        !(
                                            null === (e = t.contactInfoListV2) ||
                                            void 0 === e ||
                                            !e.length
                                        )
                                    )
                                })
                            if (t.length) {
                                var a = t.filter(function (t) {
                                    var e
                                    return !(
                                        null === (e = t.contactInfoListV2) ||
                                        void 0 === e ||
                                        !e.length
                                    )
                                })
                                a.length &&
                                    this.$sensors.track('hw_contact_teacher_icon_show', {
                                        teacher_category: 2,
                                    })
                            } else {
                                e.length &&
                                    this.$sensors.track('hw_contact_teacher_icon_show', {
                                        teacher_category: 1,
                                    })
                            }
                        },
                        updateHeaderAttr: function () {
                            console.info(
                                '对象函数 updateHeaderAttr,filePath:renderer/views/CoursesDetail.vue'
                            )
                            var t = this.$t('courses.detail.title')
                            this.$bus.$emit('updateHeaderAttr', {
                                title: t,
                                showGoback: true,
                                backUrl: '/courses',
                            })
                        },
                        queryData: function (t) {
                            var e = this
                            console.info(
                                '对象函数 queryData(callback)',
                                t,
                                'filePath:renderer/views/CoursesDetail.vue'
                            )
                            this.loading = true
                            this.isError = false
                            Object(w.h)(this, { classId: this.classId })
                                .then(function (a) {
                                    if (((e.loading = false), !a || 0 != a.code)) {
                                        return (
                                            console.info(
                                                'if(!res || res.code != 0)为true触发return,path: /renderer/views/CoursesDetail.vue'
                                            ),
                                            void (e.isError = true)
                                        )
                                    }
                                    var s = a.data || {},
                                        n = s.classInfo
                                    e.teachers = n.teachers || []
                                    e.dataList = s.scheduleList || []
                                    e.courseDatas = {
                                        tag: n.tag || '',
                                        startDate: n.startDate || '',
                                        endDate: n.endDate || '',
                                        classId: n.classId || '',
                                        className: n.className || '',
                                        teachers: n.teachers || [],
                                        timeDesc: n.timeDesc,
                                        timeDesc2: n.timeDesc2 || '',
                                        courseType: n.courseType || 0,
                                    }
                                    t && t(s)
                                    var r = location.hash.split('&')[0],
                                        o = localStorage.getItem(r)
                                    o
                                        ? e.$nextTick(function () {
                                            e.$refs.syllabusList.scrollTo({
                                                top: o,
                                                behavior: 'smooth',
                                            })
                                        })
                                        : e.$nextTick(function () {
                                            e.dataList && e.handleScrollToLive()
                                        })
                                })
                                .finally(function () {
                                    console.info(
                                        '箭头函数 finally,filePath:renderer/views/CoursesDetail.vue'
                                    )
                                    e.$bus.$emit('reload-completed')
                                })
                        },
                        checkUpdate: function () {
                            console.info(
                                '对象函数 checkUpdate,filePath:renderer/views/CoursesDetail.vue'
                            )
                            this.$bus.$emit('System.CheckUpdate.backgroundCheckUpdate', {
                                type: 'regular',
                            })
                        },
                        preload: function () {
                            return Object(o.a)(
                                Object(r.a)().mark(function t() {
                                    return Object(r.a)().wrap(function (t) {
                                        while (1) {
                                            switch ((t.prev = t.next)) {
                                                case 0:
                                                    console.info(
                                                        '对象函数 preload,filePath:renderer/views/CoursesDetail.vue'
                                                    ),
                                                        Object(tt.e)(),
                                                        Object(tt.f)()
                                                case 3:
                                                case 'end':
                                                    return t.stop()
                                            }
                                        }
                                    }, t)
                                })
                            )()
                        },
                        handleScrollToLive: function () {
                            console.info(
                                '对象函数 handleScrollToLive,filePath:renderer/views/CoursesDetail.vue'
                            )
                            var t = this.$route.query
                            if (t.isNeedBackToCurrentTap) {
                                var e = this.dataList.findIndex(function (e) {
                                    if (t.from && 'exam' == t.from) {
                                        if ('EXAM' === e.scheduleType) {
                                            return (
                                                console.info(
                                                    "if(classItem.scheduleType === 'EXAM')为true触发return,path: /renderer/views/CoursesDetail.vue"
                                                ),
                                                e.examDetails.jumpParams.planId == t.planId
                                            )
                                        }
                                    } else {
                                        if ('LESSON' === e.scheduleType) {
                                            return (
                                                console.info(
                                                    "if(classItem.scheduleType === 'LESSON')为true触发return,path: /renderer/views/CoursesDetail.vue"
                                                ),
                                                e.lessonDetails.planId == t.planId
                                            )
                                        }
                                    }
                                })
                                this.scrollIntoIndex(e)
                            } else {
                                var a = this.dataList.findIndex(function (t) {
                                    if ('LESSON' === t.scheduleType) {
                                        return (
                                            console.info(
                                                "if(classItem.scheduleType === 'LESSON')为true触发return,path: /renderer/views/CoursesDetail.vue"
                                            ),
                                            2 == t.lessonDetails.status
                                        )
                                    }
                                }),
                                    s = this.dataList.findIndex(function (t) {
                                        if ('LESSON' === t.scheduleType) {
                                            return (
                                                console.info(
                                                    "if(classItem.scheduleType === 'LESSON')为true触发return,path: /renderer/views/CoursesDetail.vue"
                                                ),
                                                1 == t.lessonDetails.status
                                            )
                                        }
                                    }),
                                    n = -1 != a ? a : s - 1
                                n > -1 && this.scrollIntoIndex(n)
                            }
                        },
                        scrollIntoIndex: function (t) {
                            console.info(
                                '对象函数 scrollIntoIndex(key)',
                                t,
                                'filePath:renderer/views/CoursesDetail.vue'
                            )
                            var e = document.getElementsByClassName('syllabus-container')[t]
                            e && e.scrollIntoView({ behavior: 'smooth' })
                        },
                    },
                },
                at = et,
                st = (a('78d5'), Object(j.a)(at, s, n, false, null, '24aa3c38', null))
            e.default = st.exports
        },
        f94ec: function (t, e, a) { },
    },
])
