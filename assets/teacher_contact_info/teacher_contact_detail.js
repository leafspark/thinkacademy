; (() => {
    var t = {
        8771: (t, e, n) => {
            n(3620)
            var r = n(9307),
                o = n(1595)
            r.JSON || (r.JSON = { stringify: JSON.stringify })
            t.exports = function (t, e, n) {
                return o(r.JSON.stringify, null, arguments)
            }
        },
        2672: (t, e, n) => {
            var r = n(4438),
                o = n(2489),
                i = TypeError
            t.exports = function (t) {
                if (r(t)) {
                    return t
                }
                throw i(o(t) + ' is not a function')
            }
        },
        678: (t, e, n) => {
            var r = n(6469),
                o = String,
                i = TypeError
            t.exports = function (t) {
                if (r(t)) {
                    return t
                }
                throw i(o(t) + ' is not an object')
            }
        },
        2624: (t, e, n) => {
            var r = n(8913)
            t.exports = r([].slice)
        },
        8779: (t, e, n) => {
            var r = n(8913),
                o = r({}.toString),
                i = r(''.slice)
            t.exports = function (t) {
                return i(o(t), 8, -1)
            }
        },
        8870: (t, e, n) => {
            var r = n(3606),
                o = n(4346),
                i = n(2097)
            t.exports = r
                ? function (t, e, n) {
                    return o.f(t, e, i(1, n))
                }
                : function (t, e, n) {
                    return (t[e] = n), t
                }
        },
        2097: (t) => {
            t.exports = function (t, e) {
                return {
                    enumerable: !(1 & t),
                    configurable: !(2 & t),
                    writable: !(4 & t),
                    value: e,
                }
            }
        },
        7972: (t, e, n) => {
            var r = n(9477),
                o = Object.defineProperty
            t.exports = function (t, e) {
                try {
                    o(r, t, {
                        value: e,
                        configurable: true,
                        writable: true,
                    })
                } catch (n) {
                    r[t] = e
                }
                return e
            }
        },
        3606: (t, e, n) => {
            var r = n(3764)
            t.exports = !r(function () {
                return (
                    7 !=
                    Object.defineProperty({}, 1, {
                        get: function () {
                            return 7
                        },
                    })[1]
                )
            })
        },
        6078: (t) => {
            var e = 'object' == typeof document && document.all,
                n = void 0 === e && void 0 !== e
            t.exports = {
                all: e,
                IS_HTMLDDA: n,
            }
        },
        4292: (t, e, n) => {
            var r = n(9477),
                o = n(6469),
                i = r.document,
                a = o(i) && o(i.createElement)
            t.exports = function (t) {
                return a ? i.createElement(t) : {}
            }
        },
        7340: (t, e, n) => {
            var r = n(6483)
            t.exports = r('navigator', 'userAgent') || ''
        },
        2694: (t, e, n) => {
            var r,
                o,
                i = n(9477),
                a = n(7340),
                c = i.process,
                s = i.Deno,
                l = (c && c.versions) || (s && s.version),
                u = l && l.v8
            u && (o = (r = u.split('.'))[0] > 0 && r[0] < 4 ? 1 : +(r[0] + r[1]))
            !o &&
                a &&
                (!(r = a.match(/Edge\/(\d+)/)) || r[1] >= 74) &&
                (r = a.match(/Chrome\/(\d+)/)) &&
                (o = +r[1])
            t.exports = o
        },
        2651: (t, e, n) => {
            'use strict'
            var r = n(9477),
                o = n(1595),
                i = n(3008),
                a = n(4438),
                c = n(1653).f,
                s = n(3277),
                l = n(9307),
                u = n(2761),
                p = n(8870),
                f = n(2707),
                h = function (t) {
                    var e = function (n, r, i) {
                        if (this instanceof e) {
                            switch (arguments.length) {
                                case 0:
                                    return new t()
                                case 1:
                                    return new t(n)
                                case 2:
                                    return new t(n, r)
                            }
                            return new t(n, r, i)
                        }
                        return o(t, this, arguments)
                    }
                    return (e.prototype = t.prototype), e
                }
            t.exports = function (t, e) {
                var n,
                    o,
                    y,
                    d,
                    m,
                    g,
                    v,
                    w,
                    b = t.target,
                    x = t.global,
                    C = t.stat,
                    S = t.proto,
                    I = x ? r : C ? r[b] : (r[b] || {}).prototype,
                    L = x ? l : l[b] || p(l, b, {})[b],
                    T = L.prototype
                for (y in e)
                    (n = !s(x ? y : b + (C ? '.' : '#') + y, t.forced) && I && f(I, y)),
                        (m = L[y]),
                        n && (g = t.dontCallGetSet ? (w = c(I, y)) && w.value : I[y]),
                        (d = n && g ? g : e[y]),
                        (n && typeof m == typeof d) ||
                        ((v =
                            t.bind && n
                                ? u(d, r)
                                : t.wrap && n
                                    ? h(d)
                                    : S && a(d)
                                        ? i(d)
                                        : d),
                            (t.sham || (d && d.sham) || (m && m.sham)) &&
                            p(v, 'sham', true),
                            p(L, y, v),
                            S &&
                            (f(l, (o = b + 'Prototype')) || p(l, o, {}),
                                p(l[o], y, d),
                                t.real && T && !T[y] && p(T, y, d)))
            }
        },
        3764: (t) => {
            t.exports = function (t) {
                try {
                    return !!t()
                } catch (t) {
                    return true
                }
            }
        },
        1595: (t, e, n) => {
            var r = n(6499),
                o = Function.prototype,
                i = o.apply,
                a = o.call
            t.exports =
                ('object' == typeof Reflect && Reflect.apply) ||
                (r
                    ? a.bind(i)
                    : function () {
                        return a.apply(i, arguments)
                    })
        },
        2761: (t, e, n) => {
            var r = n(3008),
                o = n(2672),
                i = n(6499),
                a = r(r.bind)
            t.exports = function (t, e) {
                return (
                    o(t),
                    void 0 === e
                        ? t
                        : i
                            ? a(t, e)
                            : function () {
                                return t.apply(e, arguments)
                            }
                )
            }
        },
        6499: (t, e, n) => {
            var r = n(3764)
            t.exports = !r(function () {
                var t = function () { }.bind()
                return 'function' != typeof t || t.hasOwnProperty('prototype')
            })
        },
        6940: (t, e, n) => {
            var r = n(6499),
                o = Function.prototype.call
            t.exports = r
                ? o.bind(o)
                : function () {
                    return o.apply(o, arguments)
                }
        },
        3008: (t, e, n) => {
            var r = n(8779),
                o = n(8913)
            t.exports = function (t) {
                if ('Function' === r(t)) {
                    return o(t)
                }
            }
        },
        8913: (t, e, n) => {
            var r = n(6499),
                o = Function.prototype,
                i = o.call,
                a = r && o.bind.bind(i, i)
            t.exports = r
                ? a
                : function (t) {
                    return function () {
                        return i.apply(t, arguments)
                    }
                }
        },
        6483: (t, e, n) => {
            var r = n(9307),
                o = n(9477),
                i = n(4438),
                a = function (t) {
                    return i(t) ? t : void 0
                }
            t.exports = function (t, e) {
                return arguments.length < 2
                    ? a(r[t]) || a(o[t])
                    : (r[t] && r[t][e]) || (o[t] && o[t][e])
            }
        },
        7097: (t, e, n) => {
            var r = n(2672),
                o = n(571)
            t.exports = function (t, e) {
                var n = t[e]
                return o(n) ? void 0 : r(n)
            }
        },
        9477: (t, e, n) => {
            var r = function (t) {
                return t && t.Math == Math && t
            }
            t.exports =
                r('object' == typeof globalThis && globalThis) ||
                r('object' == typeof window && window) ||
                r('object' == typeof self && self) ||
                r('object' == typeof n.g && n.g) ||
                (function () {
                    return this
                })() ||
                Function('return this')()
        },
        2707: (t, e, n) => {
            var r = n(8913),
                o = n(2798),
                i = r({}.hasOwnProperty)
            t.exports =
                Object.hasOwn ||
                function (t, e) {
                    return i(o(t), e)
                }
        },
        6818: (t, e, n) => {
            var r = n(3606),
                o = n(3764),
                i = n(4292)
            t.exports =
                !r &&
                !o(function () {
                    return (
                        7 !=
                        Object.defineProperty(i('div'), 'a', {
                            get: function () {
                                return 7
                            },
                        }).a
                    )
                })
        },
        6992: (t, e, n) => {
            var r = n(8913),
                o = n(3764),
                i = n(8779),
                a = Object,
                c = r(''.split)
            t.exports = o(function () {
                return !a('z').propertyIsEnumerable(0)
            })
                ? function (t) {
                    return 'String' == i(t) ? c(t, '') : a(t)
                }
                : a
        },
        6601: (t, e, n) => {
            var r = n(8779)
            t.exports =
                Array.isArray ||
                function (t) {
                    return 'Array' == r(t)
                }
        },
        4438: (t, e, n) => {
            var r = n(6078),
                o = r.all
            t.exports = r.IS_HTMLDDA
                ? function (t) {
                    return 'function' == typeof t || t === o
                }
                : function (t) {
                    return 'function' == typeof t
                }
        },
        3277: (t, e, n) => {
            var r = n(3764),
                o = n(4438),
                a = function (t, e) {
                    var n = s[c(t)]
                    return n == u || (n != l && (o(e) ? r(e) : !!e))
                },
                c = (a.normalize = function (t) {
                    return String(t)
                        .replace(/#|\.prototype\./, '.')
                        .toLowerCase()
                }),
                s = (a.data = {}),
                l = (a.NATIVE = 'N'),
                u = (a.POLYFILL = 'P')
            t.exports = a
        },
        571: (t) => {
            t.exports = function (t) {
                return null == t
            }
        },
        6469: (t, e, n) => {
            var r = n(4438),
                o = n(6078),
                i = o.all
            t.exports = o.IS_HTMLDDA
                ? function (t) {
                    return 'object' == typeof t ? null !== t : r(t) || t === i
                }
                : function (t) {
                    return 'object' == typeof t ? null !== t : r(t)
                }
        },
        1907: (t) => {
            t.exports = true
        },
        3037: (t, e, n) => {
            var r = n(6483),
                o = n(4438),
                i = n(1287),
                a = n(7873),
                c = Object
            t.exports = a
                ? function (t) {
                    return 'symbol' == typeof t
                }
                : function (t) {
                    var e = r('Symbol')
                    return o(e) && i(e.prototype, c(t))
                }
        },
        4346: (t, e, n) => {
            var r = n(3606),
                o = n(6818),
                i = n(8616),
                a = n(678),
                c = n(4761),
                s = TypeError,
                l = Object.defineProperty,
                u = Object.getOwnPropertyDescriptor
        },
        1653: (t, e, n) => {
            var r = n(3606),
                o = n(6940),
                i = n(6374),
                a = n(2097),
                c = n(4242),
                s = n(4761),
                l = n(2707),
                u = n(6818),
                p = Object.getOwnPropertyDescriptor
        },
        1287: (t, e, n) => {
            var r = n(8913)
            t.exports = r({}.isPrototypeOf)
        },
        6374: (t, e) => {
            'use strict'
            var n = {}.propertyIsEnumerable,
                r = Object.getOwnPropertyDescriptor,
                o = r && !n.call({ 1: 2 }, 1)
        },
        9078: (t, e, n) => {
            var r = n(6940),
                o = n(4438),
                i = n(6469),
                a = TypeError
            t.exports = function (t, e) {
                var n, c
                if ('string' === e && o((n = t.toString)) && !i((c = r(n, t)))) {
                    return c
                }
                if (o((n = t.valueOf)) && !i((c = r(n, t)))) {
                    return c
                }
                if ('string' !== e && o((n = t.toString)) && !i((c = r(n, t)))) {
                    return c
                }
                throw a("Can't convert object to primitive value")
            }
        },
        9307: (t) => {
            t.exports = {}
        },
        358: (t, e, n) => {
            var r = n(571),
                o = TypeError
            t.exports = function (t) {
                if (r(t)) {
                    throw o("Can't call method on " + t)
                }
                return t
            }
        },
        3544: (t, e, n) => {
            var r = n(9477),
                o = n(7972),
                a = r['__core-js_shared__'] || o('__core-js_shared__', {})
            t.exports = a
        },
        5472: (t, e, n) => {
            var r = n(1907),
                o = n(3544)
                ; (t.exports = function (t, e) {
                    return o[t] || (o[t] = void 0 !== e ? e : {})
                })('versions', []).push({
                    version: '3.26.1',
                    mode: r ? 'pure' : 'global',
                    copyright: '\xA9 2014-2022 Denis Pushkarev (zloirock.ru)',
                    license: 'https://github.com/zloirock/core-js/blob/v3.26.1/LICENSE',
                    source: 'https://github.com/zloirock/core-js',
                })
        },
        4314: (t, e, n) => {
            var r = n(2694),
                o = n(3764)
            t.exports =
                !!Object.getOwnPropertySymbols &&
                !o(function () {
                    var t = Symbol()
                    return (
                        !String(t) ||
                        !(Object(t) instanceof Symbol) ||
                        (!Symbol.sham && r && r < 41)
                    )
                })
        },
        4242: (t, e, n) => {
            var r = n(6992),
                o = n(358)
            t.exports = function (t) {
                return r(o(t))
            }
        },
        2798: (t, e, n) => {
            var r = n(358),
                o = Object
            t.exports = function (t) {
                return o(r(t))
            }
        },
        6418: (t, e, n) => {
            var r = n(6940),
                o = n(6469),
                i = n(3037),
                a = n(7097),
                c = n(9078),
                s = n(8099),
                l = TypeError,
                u = s('toPrimitive')
            t.exports = function (t, e) {
                if (!o(t) || i(t)) {
                    return t
                }
                var n,
                    s = a(t, u)
                if (s) {
                    if (
                        (void 0 === e && (e = 'default'), (n = r(s, t, e)), !o(n) || i(n))
                    ) {
                        return n
                    }
                    throw l("Can't convert object to primitive value")
                }
                return void 0 === e && (e = 'number'), c(t, e)
            }
        },
        4761: (t, e, n) => {
            var r = n(6418),
                o = n(3037)
            t.exports = function (t) {
                var e = r(t, 'string')
                return o(e) ? e : e + ''
            }
        },
        2489: (t) => {
            var e = String
            t.exports = function (t) {
                try {
                    return e(t)
                } catch (t) {
                    return 'Object'
                }
            }
        },
        8736: (t, e, n) => {
            var r = n(8913),
                o = 0,
                i = Math.random(),
                a = r((1).toString)
            t.exports = function (t) {
                return 'Symbol(' + (void 0 === t ? '' : t) + ')_' + a(++o + i, 36)
            }
        },
        7873: (t, e, n) => {
            var r = n(4314)
            t.exports = r && !Symbol.sham && 'symbol' == typeof Symbol.iterator
        },
        8616: (t, e, n) => {
            var r = n(3606),
                o = n(3764)
            t.exports =
                r &&
                o(function () {
                    return (
                        42 !=
                        Object.defineProperty(function () { }, 'prototype', {
                            value: 42,
                            writable: false,
                        }).prototype
                    )
                })
        },
        8099: (t, e, n) => {
            var r = n(9477),
                o = n(5472),
                i = n(2707),
                a = n(8736),
                c = n(4314),
                s = n(7873),
                l = o('wks'),
                u = r.Symbol,
                p = u && u.for,
                f = s ? u : (u && u.withoutSetter) || a
            t.exports = function (t) {
                if (!i(l, t) || (!c && 'string' != typeof l[t])) {
                    var e = 'Symbol.' + t
                    c && i(u, t) ? (l[t] = u[t]) : (l[t] = s && p ? p(e) : f(e))
                }
                return l[t]
            }
        },
        3620: (t, e, n) => {
            var r = n(2651),
                o = n(6483),
                i = n(1595),
                a = n(6940),
                c = n(8913),
                s = n(3764),
                l = n(6601),
                u = n(4438),
                p = n(6469),
                f = n(3037),
                h = n(2624),
                y = n(4314),
                d = o('JSON', 'stringify'),
                m = c(/./.exec),
                g = c(''.charAt),
                v = c(''.charCodeAt),
                w = c(''.replace),
                b = c((1).toString),
                I =
                    !y ||
                    s(function () {
                        var t = o('Symbol')()
                        return (
                            '[null]' != d([t]) ||
                            '{}' != d({ a: t }) ||
                            '{}' != d(Object(t))
                        )
                    }),
                L = s(function () {
                    return (
                        '"\\udf06\\ud834"' !== d('\uDF06\uD834') ||
                        '"\\udead"' !== d('\uDEAD')
                    )
                }),
                T = function (t, e) {
                    var n = h(arguments),
                        r = e
                    if ((p(e) || void 0 !== t) && !f(t)) {
                        return (
                            l(e) ||
                            (e = function (t, e) {
                                if ((u(r) && (e = a(r, this, t, e)), !f(e))) {
                                    return e
                                }
                            }),
                            (n[1] = e),
                            i(d, null, n)
                        )
                    }
                },
                O = function (t, e, n) {
                    var r = g(n, e - 1),
                        o = g(n, e + 1)
                    return (m(/^[\uD800-\uDBFF]$/, t) && !m(/^[\uDC00-\uDFFF]$/, o)) ||
                        (m(/^[\uDC00-\uDFFF]$/, t) && !m(/^[\uD800-\uDBFF]$/, r))
                        ? '\\u' + b(v(t, 0), 16)
                        : t
                }
            d &&
                r(
                    {
                        target: 'JSON',
                        stat: true,
                        arity: 3,
                        forced: I || L,
                    },
                    {
                        stringify: function (t, e, n) {
                            var r = h(arguments),
                                o = i(I ? T : d, null, r)
                            return L && 'string' == typeof o
                                ? w(o, /[\uD800-\uDFFF]/g, O)
                                : o
                        },
                    }
                )
        },
        3328: (t, e, n) => {
            var r = n(8771)
            t.exports = r
        },
    },
        e = {
            f: r
                ? i
                    ? function (t, e, n) {
                        if (
                            (a(t),
                                (e = c(e)),
                                a(n),
                                'function' == typeof t &&
                                'prototype' === e &&
                                'value' in n &&
                                'writable' in n &&
                                !n.writable)
                        ) {
                            var r = u(t, e)
                            r &&
                                r.writable &&
                                ((t[e] = n.value),
                                    (n = {
                                        configurable:
                                            'configurable' in n ? n.configurable : r.configurable,
                                        enumerable: 'enumerable' in n ? n.enumerable : r.enumerable,
                                        writable: false,
                                    }))
                        }
                        return l(t, e, n)
                    }
                    : l
                : function (t, e, n) {
                    if ((a(t), (e = c(e)), a(n), o)) {
                        try {
                            return l(t, e, n)
                        } catch (t) { }
                    }
                    if ('get' in n || 'set' in n) {
                        throw s('Accessors not supported')
                    }
                    return 'value' in n && (t[e] = n.value), t
                },
            f: r
                ? p
                : function (t, e) {
                    if (((t = c(t)), (e = s(e)), u)) {
                        try {
                            return p(t, e)
                        } catch (t) { }
                    }
                    if (l(t, e)) {
                        return a(!o(i.f, t, e), t[e])
                    }
                },
            f: o
                ? function (t) {
                    var e = r(this, t)
                    return !!e && e.enumerable
                }
                : n,
            text: d().contactInfoDes,
            style: {
                fontSize: '14',
                color: '#A2AAB8',
                textAlign: 'center',
                marginLeft: 50,
                marginRight: 50,
                marginTop: '20',
                flexShrink: 1,
                flexGrow: 1,
            },
            style: {
                marginLeft: '10',
                marginRight: 16,
                fontSize: '14',
                color: '#A2AAB8',
                textLineClamp: 1,
                textOverflow: 'ellipsis',
                fontWeight: 'bold',
                textDecoration: 'underline',
                flexGrow: 1,
                flexShrink: 1,
            },
            text: d().copyAndOpenWechat,
            style: {
                marginLeft: '4',
                fontSize: '12',
                color: '#A2AAB8',
                flexShrink: 1,
                marginRight: 46,
            },
            text: d().qrDesc,
        }
    function n(r) {
        var o = e[r]
        if (void 0 !== o) {
            return o.exports
        }
        var i = (e[r] = { exports: {} })
        return t[r](i, i.exports, n), i.exports
    }
    n.n = (t) => {
        var e = t && t.__esModule ? () => t.default : () => t
        return n.d(e, { a: e }), e
    }
    n.d = (t, e) => {
        for (var r in e)
            n.o(e, r) &&
                !n.o(t, r) &&
                Object.defineProperty(t, r, {
                    enumerable: true,
                    get: e[r],
                })
    }
    n.g = (function () {
        if ('object' == typeof globalThis) {
            return globalThis
        }
        try {
            return this || new Function('return this')()
        } catch (t) {
            if ('object' == typeof window) {
                return window
            }
        }
    })()
    n.o = (t, e) => Object.prototype.hasOwnProperty.call(t, e)
    n.p = './'
        ; (() => {
            'use strict'
            function t(t, e) {
                if (!(t instanceof e)) {
                    throw new TypeError('Cannot call a class as a function')
                }
            }
            function e(t) {
                return (
                    (e =
                        'function' == typeof Symbol && 'symbol' == typeof Symbol.iterator
                            ? function (t) {
                                return typeof t
                            }
                            : function (t) {
                                return t &&
                                    'function' == typeof Symbol &&
                                    t.constructor === Symbol &&
                                    t !== Symbol.prototype
                                    ? 'symbol'
                                    : typeof t
                            }),
                    e(t)
                )
            }
            function r(t, n) {
                for (var r = 0; r < n.length; r++) {
                    var o = n[r]
                    o.enumerable = o.enumerable || false
                    o.configurable = true
                    'value' in o && (o.writable = true)
                    Object.defineProperty(
                        t,
                        ((i = o.key),
                            (a = void 0),
                            (a = (function (t, n) {
                                if ('object' !== e(t) || null === t) {
                                    return t
                                }
                                var r = t[Symbol.toPrimitive]
                                if (void 0 !== r) {
                                    var o = r.call(t, 'string')
                                    if ('object' !== e(o)) {
                                        return o
                                    }
                                    throw new TypeError(
                                        '@@toPrimitive must return a primitive value.'
                                    )
                                }
                                return String(t)
                            })(i)),
                            'symbol' === e(a) ? a : String(a)),
                        o
                    )
                }
                var i, a
            }
            function o(t, e, n) {
                return (
                    e && r(t.prototype, e),
                    n && r(t, n),
                    Object.defineProperty(t, 'prototype', { writable: false }),
                    t
                )
            }
            function i(t, e) {
                return (
                    (i = Object.setPrototypeOf
                        ? Object.setPrototypeOf.bind()
                        : function (t, e) {
                            return (t.__proto__ = e), t
                        }),
                    i(t, e)
                )
            }
            function a(t, e) {
                if ('function' != typeof e && null !== e) {
                    throw new TypeError(
                        'Super expression must either be null or a function'
                    )
                }
                t.prototype = Object.create(e && e.prototype, {
                    constructor: {
                        value: t,
                        writable: true,
                        configurable: true,
                    },
                })
                Object.defineProperty(t, 'prototype', { writable: false })
                e && i(t, e)
            }
            function c(t) {
                return (
                    (c = Object.setPrototypeOf
                        ? Object.getPrototypeOf.bind()
                        : function (t) {
                            return t.__proto__ || Object.getPrototypeOf(t)
                        }),
                    c(t)
                )
            }
            function s(t, n) {
                if (n && ('object' === e(n) || 'function' == typeof n)) {
                    return n
                }
                if (void 0 !== n) {
                    throw new TypeError(
                        'Derived constructors may only return object or undefined'
                    )
                }
                return (function (t) {
                    if (void 0 === t) {
                        throw new ReferenceError(
                            "this hasn't been initialised - super() hasn't been called"
                        )
                    }
                    return t
                })(t)
            }
            function l(t) {
                var e = (function () {
                    if ('undefined' == typeof Reflect || !Reflect.construct) {
                        return false
                    }
                    if (Reflect.construct.sham) {
                        return false
                    }
                    if ('function' == typeof Proxy) {
                        return true
                    }
                    try {
                        return (
                            Boolean.prototype.valueOf.call(
                                Reflect.construct(Boolean, [], function () { })
                            ),
                            true
                        )
                    } catch (t) {
                        return false
                    }
                })()
                return function () {
                    var n,
                        r = c(t)
                    if (e) {
                        var o = c(this).constructor
                        n = Reflect.construct(r, arguments, o)
                    } else {
                        n = r.apply(this, arguments)
                    }
                    return s(this, n)
                }
            }
            var u = n(3328),
                p = n.n(u)
            const f = __GLOBAL__
            n.p
            n.p
            n.p
            n.p
            n.p
            n.p
            n.p
            n.p
            var h = {
                en: {
                    activitTitle: 'Contact Teacher',
                    contactInfoDes:
                        'If you have any questions, please contact your teacher',
                    copyAndOpenWechat: 'Copy and open WeChat',
                    qrDesc: 'Save the screenshot and scan it with WeChat',
                    copy: 'Copy',
                    copySuccess: 'Copied successfully',
                    copyFailed: 'Copied failed',
                },
                enGB: {
                    activitTitle: 'Contact Teacher',
                    contactInfoDes:
                        'If you have any questions, please contact your teacher',
                    copyAndOpenWechat: 'Copy and open WeChat',
                    qrDesc: 'Save the screenshot and scan it with WeChat',
                    copy: 'Copy',
                    copySuccess: 'Copied successfully',
                    copyFailed: 'Copied failed',
                },
                zh: {
                    activitTitle: '联系老师',
                    contactInfoDes: '如您有任何问题\uFF0C请联系您的老师',
                    copyAndOpenWechat: '复制并打开微信',
                    qrDesc: '截图保存图片\uFF0C使用微信扫一扫它',
                    copy: '复制',
                    copySuccess: '复制成功',
                    copyFailed: '复制失败',
                },
                zhHK: {
                    activitTitle: '聯系老師',
                    contactInfoDes: '如您有任何問題\uFF0C請聯系您的老師',
                    copyAndOpenWechat: '複製並打開微信',
                    qrDesc: '截圖保存圖片\uFF0C使用微信掃一掃它',
                    copy: '複製',
                    copySuccess: '複製成功',
                    copyFailed: '複製失敗',
                },
            },
                y = 'zh',
                d = function () {
                    var t = h[y]
                    return null == t && (t = h.en), t
                },
                m = new HwHmBridge(),
                g = f.Hummer.pageInfo.params,
                v = null
            if (null != g && null != g.hwData) {
                console.log('Page info:hwData ' + g.hwData)
                try {
                    v = JSON.parse(g.hwData)
                } catch (t) {
                    v = null
                    console.log('JSON.parse 错误\uFF0Cerror = ' + t)
                }
                v instanceof Object
                    ? console.log('hwData是对象')
                    : (console.log('hwData不是对象'), (v = null))
                null == v && console.log('hwData为空')
            }
            var w = f.Hummer.env.language
            null == w && (w = 'en')
            var b = null
            null != v && (b = v.contactInfoListV2)
                ; (function (t) {
                    y = t
                })(w)
            console.log('测试环境变量\uFF0CPage info: ' + p()(f.Hummer.env))
            var x = (function (e) {
                a(r, e)
                var n = l(r)
                function r() {
                    var e, o
                    return (
                        t(this, r),
                        ((o = n.call(this)).style = {
                            width: '100%',
                            height: '100%',
                            backgroundColor: '#f4f6fa',
                        }),
                        (o.teacherItemCount = 0),
                        null != v && b instanceof Array && (o.teacherItemCount = b.length),
                        console.log('最终获取到联系方式数组 size = ' + o.teacherItemCount),
                        m.setTopBarTitle(d().activitTitle, '#ffffff'),
                        o.showTeacherContactInfo(),
                        m.track('hw_contact_teacher_pv', {
                            teacher_category: parseInt(
                                null === (e = v) || void 0 === e ? void 0 : e.identityType
                            ),
                        }),
                        o
                    )
                }
                return (
                    o(r, [
                        {
                            key: 'showTeacherContactInfo',
                            value: function () {
                                var t = this
                                this.listView = new f.List()
                                this.listView.style = {
                                    marginLeft: '16',
                                    marginRight: 16,
                                    mode: 'list',
                                    column: 1,
                                    flexGrow: 1,
                                    flexShrink: 1,
                                    scrollDirection: 'vertical',
                                    marginBottom: '20',
                                    backgroundColor: '#f4f6fa',
                                    showScrollBar: false,
                                }
                                this.listView.bounces = false
                                this.listView.showScrollBar = false
                                this.listView.onRegister = function (t) {
                                    return (
                                        console.log('TypeCallback: position = ' + t), 0 == t ? 2 : 1
                                    )
                                }
                                this.listView.onCreate = function (t) {
                                    return (
                                        console.log('CreateCallback: type = ' + t),
                                        2 == t ? new C() : new S()
                                    )
                                }
                                this.listView.onUpdate = function (e, n) {
                                    if (
                                        (console.log(
                                            'UpdateCallback: position = ' + e + ', cell = ' + n
                                        ),
                                            n instanceof S)
                                    ) {
                                        var r,
                                            o = b[e - 1]
                                        r = 'weChat' == o.type
                                        n.showWechat(r)
                                        n.setTypeIcon(o.type)
                                        var i = o.value
                                        null != i &&
                                            (n.showQrImage(i.qrCode, r),
                                                n.setContacName(i.account, r))
                                        e == t.teacherItemCount
                                            ? n.setIsBottomRound(true)
                                            : n.setIsBottomRound(false)
                                    }
                                }
                                this.appendChild(this.listView)
                                this.listView.refresh(this.teacherItemCount + 1)
                            },
                        },
                    ]),
                    r
                )
            })(f.View),
                C = (function (e) {
                    a(r, e)
                    var n = l(r)
                    function r() {
                        var e
                        return (
                            t(this, r),
                            (e = n.call(this)).showTeacherHead(),
                            e.showContactDesc(),
                            e
                        )
                    }
                    return (
                        o(r, [
                            {
                                key: 'showTeacherHead',
                                value: function () {
                                    var t,
                                        e,
                                        n,
                                        r = new f.View()
                                    r.style = {
                                        flexDirection: 'row',
                                        backgroundColor: '#ffffff',
                                        with: '100%',
                                        height: '102',
                                        marginTop: '16',
                                        borderRadius: '10',
                                        alignItems: 'center',
                                    }
                                    var o = new f.Image()
                                    o.src = './images/head_user_icon.png'
                                    o.style = {
                                        width: '70',
                                        height: '70',
                                        borderRadius: '35',
                                        marginLeft: '16',
                                        borderWidth: '1',
                                        borderColor: '#e3e5e9',
                                        resize: 'contain',
                                    }
                                    var i = null === (t = v) || void 0 === t ? void 0 : t.avatar
                                    null != i &&
                                        o.load(
                                            {
                                                src: i,
                                                placeholder: './images/head_user_icon.png',
                                                failedImage: './images/head_user_icon.png',
                                            },
                                            function (t, e) {
                                                console.log('头像加载,srcType=' + t + 'isSuccess=' + e)
                                            }
                                        )
                                    r.appendChild(o)
                                    var a = new f.View()
                                    a.style = {
                                        flexDirection: 'column',
                                        marginLeft: '16',
                                        marginRight: 16,
                                        width: '100%',
                                        flexGrow: 1,
                                        flexShrink: 1,
                                    }
                                    var c = new f.Text()
                                    c.text = ''
                                    c.style = {
                                        fontSize: '18',
                                        fontWeight: 'bold',
                                        color: '#172b4d',
                                        textLineClamp: 1,
                                        textOverflow: 'ellipsis',
                                        flexShrink: 1,
                                    }
                                    var s = null === (e = v) || void 0 === e ? void 0 : e.name
                                    null != s && (c.text = s)
                                    a.appendChild(c)
                                    var l = new f.Text()
                                    l.text = ''
                                    l.style = {
                                        fontSize: '14',
                                        color: '#a2aab8',
                                        width: '100%',
                                        textLineClamp: 1,
                                        textOverflow: 'ellipsis',
                                    }
                                    var u =
                                        null === (n = v) || void 0 === n ? void 0 : n.identityName
                                    null != u && (l.text = u)
                                    a.appendChild(l)
                                    r.appendChild(a)
                                    this.appendChild(r)
                                },
                            },
                            {
                                key: 'showContactDesc',
                                value: function () {
                                    var t = new f.View()
                                    t.style = {
                                        backgroundColor: '#ffffff',
                                        marginTop: '1',
                                        borderTopLeftRadius: '10',
                                        borderTopRightRadius: '10',
                                        paddingBottom: '20',
                                    }
                                    var e = new f.Text()
                                    t.appendChild(e)
                                    this.appendChild(t)
                                },
                            },
                        ]),
                        r
                    )
                })(f.View),
                S = (function (e) {
                    a(r, e)
                    var n = l(r)
                    function r() {
                        var e
                        return (
                            t(this, r),
                            ((e = n.call(this)).style = {
                                backgroundColor: '#ffffff',
                                flexDirection: 'row',
                                paddingBottom: '30',
                            }),
                            (e.columnParentView = new f.View()),
                            (e.columnParentView.style = {
                                flexDirection: 'column',
                                flexGrow: 1,
                                flexShrink: 1,
                            }),
                            e.addNameLayout(),
                            e.addWechatCopyLayout(),
                            e.addQRCodeImage(),
                            e.appendChild(e.columnParentView),
                            e
                        )
                    }
                    return (
                        o(r, [
                            {
                                key: 'setData',
                                value: function (t) {
                                    this.hwData = t
                                },
                            },
                            {
                                key: 'setTypeIcon',
                                value: function (t) {
                                    var e = './images/icon_wechat.png'
                                    switch (t) {
                                        case 'whatsApp':
                                            e = './images/icon_whatsapp.png'
                                            break
                                        case 'line':
                                            e = './images/icon_line.png'
                                            break
                                        case 'weChat':
                                            e = './images/icon_wechat.png'
                                    }
                                    this.weIcon.src = e
                                },
                            },
                            {
                                key: 'setContacName',
                                value: function (t, e) {
                                    this.nameTextView.text = null != t ? t : ''
                                    I(t)
                                        ? ((this.nameLayout.style = { display: 'none' }),
                                            e && (this.wechatCopyLayout.style = { display: 'none' }),
                                            (this.qrImageParent.style = { marginTop: 0 }))
                                        : ((this.nameLayout.style = { display: 'flex' }),
                                            e && (this.wechatCopyLayout.style = { display: 'flex' }),
                                            (this.qrImageParent.style = { marginTop: 14 }))
                                },
                            },
                            {
                                key: 'addNameLayout',
                                value: function () {
                                    var t = this
                                    this.nameLayout = new f.View()
                                    this.nameLayout.style = {
                                        flexDirection: 'row',
                                        alignItems: 'center',
                                        height: 30,
                                    }
                                    this.weIcon = new f.Image()
                                    this.weIcon.style = {
                                        width: '30',
                                        height: '30',
                                        marginLeft: '16',
                                    }
                                    this.weIcon.src = './images/icon_wechat.png'
                                    this.nameTextView = new f.Text()
                                    this.nameTextView.style = {
                                        fontSize: '16',
                                        color: '#172B4D',
                                        textLineClamp: 1,
                                        textOverflow: 'ellipsis',
                                        marginLeft: '10',
                                        marginRight: 16,
                                        flexGrow: 1,
                                        flexShrink: 1,
                                    }
                                    this.nameTextView.text = '11111111111bbbbbbbbbbbbbbbbbbbbbbbbb'
                                    this.appendChild(this.weIcon)
                                    this.nameLayout.appendChild(this.nameTextView)
                                    this.normalCopyLayout = new f.View()
                                    this.normalCopyLayout.style = {
                                        flexDirection: 'row',
                                        marginRight: 16,
                                    }
                                    this.copyText = new f.Text()
                                    this.copyText.text = d().copy
                                    this.copyText.style = {
                                        fontSize: '14',
                                        color: '#A2AAB8',
                                        textAlign: 'right',
                                        textDecoration: 'underline',
                                        fontWeight: 'bold',
                                    }
                                    this.normalCopyLayout.appendChild(this.copyText)
                                    this.copyImage = new f.Image()
                                    this.copyImage.src = './images/icon_copy.png'
                                    this.copyImage.style = {
                                        width: '20',
                                        height: '20',
                                        marginLeft: '4',
                                    }
                                    this.normalCopyLayout.addEventListener('tap', function (e) {
                                        t.copyContactName(t.nameTextView.text)
                                    })
                                    this.normalCopyLayout.appendChild(this.copyImage)
                                    this.nameLayout.appendChild(this.normalCopyLayout)
                                    this.columnParentView.appendChild(this.nameLayout)
                                },
                            },
                            {
                                key: 'copyContactName',
                                value: function (t) {
                                    m.copyString(t)
                                        ? f.Toast.show(d().copySuccess)
                                        : f.Toast.show(d().copyFailed)
                                },
                            },
                            {
                                key: 'addWechatCopyLayout',
                                value: function () {
                                    var t = this
                                    this.wechatCopyLayout = new f.View()
                                    this.wechatCopyLayout.style = {
                                        flexDirection: 'row',
                                        marginTop: '7',
                                        alignItems: 'center',
                                    }
                                    var e = new f.Text()
                                    this.wechatCopyLayout.appendChild(e)
                                    var n = new f.Image()
                                    n.style = {
                                        width: '20',
                                        height: '20',
                                        marginRight: 16,
                                    }
                                    n.src = './images/icon_copy.png'
                                    this.wechatCopyLayout.appendChild(n)
                                    this.wechatCopyLayout.addEventListener('tap', function (e) {
                                        t.copyContactName(t.nameTextView.text)
                                        var n = m.openWechat()
                                        console.log('打开微信\uFF1A' + n)
                                    })
                                    this.columnParentView.appendChild(this.wechatCopyLayout)
                                },
                            },
                            {
                                key: 'addQRCodeImage',
                                value: function () {
                                    this.qrImage = new f.Image()
                                    this.qrImage.style = {
                                        flexShrink: 1,
                                        flexGrow: 1,
                                        margin: 16,
                                        resize: 'contain',
                                        width: 158,
                                        height: 158,
                                    }
                                    this.qrImage.src = ''
                                    this.qrImageParent = new f.View()
                                    this.qrImageParent.style = {
                                        width: '190',
                                        height: '190',
                                        marginLeft: '11',
                                        marginTop: '14',
                                        borderRadius: '13',
                                        borderWidth: '1',
                                        borderColor: '#2222221a',
                                        alignItems: 'center',
                                    }
                                    this.qrImageParent.appendChild(this.qrImage)
                                    this.columnParentView.appendChild(this.qrImageParent)
                                    this.qrDescLayout = new f.View()
                                    this.qrDescLayout.style = {
                                        flexDirection: 'row',
                                        marginLeft: '11',
                                        marginTop: '10',
                                        alignItems: 'stretch',
                                    }
                                    var t = new f.Image()
                                    t.style = {
                                        width: '14',
                                        height: '14',
                                        marginTop: '2',
                                    }
                                    t.src = './images/qr_tips_icon.png'
                                    this.qrDescLayout.appendChild(t)
                                    var e = new f.Text()
                                    this.qrDescLayout.appendChild(e)
                                    this.columnParentView.appendChild(this.qrDescLayout)
                                },
                            },
                            {
                                key: 'setIsBottomRound',
                                value: function (t) {
                                    this.style = t
                                        ? {
                                            borderBottomLeftRadius: '10',
                                            borderBottomRightRadius: '10',
                                        }
                                        : {
                                            borderBottomLeftRadius: 0,
                                            borderBottomRightRadius: 0,
                                        }
                                },
                            },
                            {
                                key: 'showWechat',
                                value: function (t) {
                                    t
                                        ? ((this.wechatCopyLayout.style = { display: 'flex' }),
                                            (this.normalCopyLayout.style = { display: 'none' }))
                                        : ((this.wechatCopyLayout.style = { display: 'none' }),
                                            (this.normalCopyLayout.style = { display: 'flex' }))
                                },
                            },
                            {
                                key: 'showQrImage',
                                value: function (t, e) {
                                    I(t)
                                        ? ((this.qrImageParent.style = { display: 'none' }),
                                            (this.qrDescLayout.style = { display: 'none' }))
                                        : ((this.qrImageParent.style = { display: 'flex' }),
                                            (this.qrDescLayout.style = e
                                                ? { display: 'flex' }
                                                : { display: 'none' }))
                                    this.qrImage.load(
                                        {
                                            src: t,
                                            placeholder: './images/default_image_loading.png',
                                            failedImage: './images/default_image_loading.png',
                                        },
                                        function (t, e) {
                                            console.log('二维码加载,srcType=' + t + 'isSuccess=' + e)
                                        }
                                    )
                                },
                            },
                        ]),
                        r
                    )
                })(f.View)
            function I(t) {
                return null == t || '' === t
            }
            f.Hummer.render(new x())
        })()
})()
