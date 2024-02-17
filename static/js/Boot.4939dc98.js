; (window.webpackJsonp = window.webpackJsonp || []).push([
    ['Boot'],
    {
        '3ed8': function (e, t, n) {
            'use strict'
            n('aa44')
        },
        '40be': function (e, t, n) {
            'use strict'
            n('8854')
        },
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
                a = n('1da1'),
                o = (n('caad'), n('2532'), n('02fc')),
                c = n('bc8a'),
                i = n('35ac'),
                s = n('d0db'),
                u = function (e, t) {
                    var n =
                        arguments.length > 2 && void 0 !== arguments[2]
                            ? arguments[2]
                            : {},
                        r =
                            arguments.length > 3 && void 0 !== arguments[3]
                                ? arguments[3]
                                : 'error'
                    s.a.send({
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
                    var e = Object(a.a)(
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
                    var e = Object(a.a)(
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
                    var e = Object(a.a)(
                        Object(r.a)().mark(function e() {
                            var t, n, a, s, p, f, b, h, v, m, w, g, x
                            return Object(r.a)().wrap(function (e) {
                                while (1) {
                                    switch ((e.prev = e.next)) {
                                        case 0:
                                            return (e.next = 2), Object(i.b)()
                                        case 2:
                                            return (t = e.sent), (e.next = 5), Object(o.f)()
                                        case 5:
                                            return (n = e.sent), (e.next = 8), d()
                                        case 8:
                                            if (
                                                ((a = e.sent),
                                                    (s =
                                                        (null === t || void 0 === t
                                                            ? void 0
                                                            : t.timeZoneSwitchSchool) || []),
                                                    (p = s.includes(n)),
                                                    console.log('####hasAuth', p, a),
                                                    !p)
                                            ) {
                                                e.next = 22
                                                break
                                            }
                                            return (
                                                'manual' !== a && (a = 'geo'),
                                                (e.next = 16),
                                                Object(c.h)().catch(function (e) {
                                                    u('接口报错:时区列表:', e)
                                                })
                                            )
                                        case 16:
                                            ; (f = e.sent),
                                                (b = f.code),
                                                (h = f.data),
                                                0 === b && Object(o.k)(h),
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
                                            return (
                                                l(a),
                                                console.log('####timezoneRuleType', a),
                                                (e.next = 29),
                                                Object(o.c)()
                                            )
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
                                                (g = Object(o.b)()),
                                                console.log('####deviceTimeZone', g),
                                                (e.next = 37),
                                                Object(c.a)({ timezone: g })
                                            )
                                        case 37:
                                            ; (x = e.sent),
                                                x &&
                                                0 === x.code &&
                                                x.data &&
                                                (0 === x.data.invalid
                                                    ? (m = g)
                                                    : (w = ['setting.timezone.invalidMsg', m]))
                                        case 39:
                                            return (
                                                'manual' !== a && Object(o.j)(m),
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
        '4a82': function (e, t, n) {
            'use strict'
            n('7c49')
        },
        '7c49': function (e, t, n) { },
        '822e': function (e, t, n) {
            'use strict'
            var r = n('c7eb'),
                a = n('1da1'),
                o = (n('14d9'), n('02fc')),
                c = n('bc13'),
                i = n('383d'),
                s = n('92e5'),
                u = n('40f6'),
                l = n('3898'),
                d = n('2b6b'),
                p = {
                    methods: {
                        initBoot: function () {
                            var e = this
                            return Object(a.a)(
                                Object(r.a)().mark(function t() {
                                    var n, a, p, f, b, h, v, m
                                    return Object(r.a)().wrap(function (t) {
                                        while (1) {
                                            switch ((t.prev = t.next)) {
                                                case 0:
                                                    return (
                                                        console.info(
                                                            '对象函数 initBoot,filePath:renderer/mixins/boot.js'
                                                        ),
                                                        (t.next = 3),
                                                        Object(o.c)()
                                                    )
                                                case 3:
                                                    return (
                                                        (n = t.sent),
                                                        console.log(n, 'local==='),
                                                        (t.next = 7),
                                                        Object(s.a)()
                                                    )
                                                case 7:
                                                    if (
                                                        ((a = t.sent),
                                                            (p = a.unifiedAccessToken),
                                                            n && 'undefined' != n)
                                                    ) {
                                                        t.next = 34
                                                        break
                                                    }
                                                    return (t.next = 12), Object(i.g)()
                                                case 12:
                                                    if (((f = t.sent), f && 0 == f.code)) {
                                                        t.next = 16
                                                        break
                                                    }
                                                    return (
                                                        e.$router.push('local-setting'), t.abrupt('return')
                                                    )
                                                case 16:
                                                    return (
                                                        (b = f.data || {}),
                                                        (h = b.schoolCode),
                                                        (t.next = 20),
                                                        Object(o.d)(h)
                                                    )
                                                case 20:
                                                    if (((v = t.sent), v && 'undefined' != v)) {
                                                        t.next = 24
                                                        break
                                                    }
                                                    return (
                                                        e.$router.push('local-setting'), t.abrupt('return')
                                                    )
                                                case 24:
                                                    return (t.next = 26), Object(o.i)(v)
                                                case 26:
                                                    return (
                                                        (t.t0 = d.setSchoolCode),
                                                        (t.next = 29),
                                                        Object(o.f)()
                                                    )
                                                case 29:
                                                    return (
                                                        (t.t1 = t.sent),
                                                        (0, t.t0)(t.t1),
                                                        (t.next = 33),
                                                        Object(c.b)()
                                                    )
                                                case 33:
                                                    Object(l.c)()
                                                case 34:
                                                    return (t.next = 36), Object(u.b)()
                                                case 36:
                                                    if (
                                                        ((m = t.sent),
                                                            m && e.$Message.info(e.$t(m[0]) + m[1]),
                                                            p)
                                                    ) {
                                                        t.next = 41
                                                        break
                                                    }
                                                    return e.$router.push('/login'), t.abrupt('return')
                                                case 41:
                                                    e.$router.push('/courses')
                                                case 42:
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
            t.a = p
        },
        '857a': function (e, t, n) {
            'use strict'
            var r = n('e330'),
                a = n('1d80'),
                o = n('577e'),
                i = r(''.replace)
            e.exports = function (e, t, n, r) {
                var s = o(a(e)),
                    u = '<' + t
                return (
                    '' !== n && (u += ' ' + n + '="' + i(o(r), /"/g, '&quot;') + '"'),
                    u + '>' + s + '</' + t + '>'
                )
            }
        },
        8854: function (e, t, n) { },
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
                a = [],
                o = n('c7eb'),
                c = n('1da1'),
                i = (n('14d9'), n('a9e3'), n('dfa8')),
                s = n('383d'),
                u = n('822e'),
                l = n('0d52'),
                d = n('d0db'),
                p = {
                    name: 'Boot',
                    mixins: [u.a],
                    components: { Toolbar: i.a },
                    created: function () {
                        console.log(this.message)
                    },
                    mounted: function () {
                        this.getDeviceIntercept()
                    },
                    methods: {
                        getDeviceIntercept: function () {
                            var e = this
                            return Object(c.a)(
                                Object(o.a)().mark(function t() {
                                    var n, r, a, c, i, u
                                    return Object(o.a)().wrap(
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
                                                            l.nativeApi.getDeviceInfo()
                                                        )
                                                    case 4:
                                                        return (
                                                            (n = t.sent),
                                                            (r = n.cpuModel.lastIndexOf('(')),
                                                            (a = parseInt(n.cpuModel.substr(r + 1, 1))),
                                                            (c = Number(
                                                                n.totalMem.substr(0, n.totalMem.length - 1)
                                                            )),
                                                            (t.next = 10),
                                                            Object(s.a)({
                                                                coreNum: a,
                                                                memory: c,
                                                            })
                                                        )
                                                    case 10:
                                                        return (
                                                            (i = t.sent),
                                                            (u = i.code),
                                                            0 !== u &&
                                                            e.sendLogger(
                                                                '设备拦截接口code: '.concat(JSON.stringify(u))
                                                            ),
                                                            48000 == u || 48001 == u
                                                                ? e.$router.push({
                                                                    path: '/device-intercept',
                                                                    query: { code: u },
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
                f = p,
                b = (n('40be'), n('2877')),
                h = Object(b.a)(f, r, a, false, null, '131352c7', null)
            t.default = h.exports
        },
        aa44: function (e, t, n) { },
        af03: function (e, t, n) {
            'use strict'
            var r = n('d039')
            e.exports = function (e) {
                return r(function () {
                    var t = ''[e]('"')
                    return t !== t.toLowerCase() || t.split('"').length > 3
                })
            }
        },
        bc13: function (e, t, n) {
            'use strict'
            n.d(t, 'b', function () {
                return o
            })
            n.d(t, 'c', function () {
                return c
            })
            n.d(t, 'a', function () {
                return i
            })
            var r = n('c7eb'),
                a = n('1da1'),
                o = (function () {
                    var e = Object(a.a)(
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
                c = (function () {
                    var e = Object(a.a)(
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
                i = (function () {
                    var e = Object(a.a)(
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
        c7cd: function (e, t, n) {
            'use strict'
            var r = n('23e7'),
                a = n('857a'),
                o = n('af03')
            r(
                {
                    target: 'String',
                    proto: true,
                    forced: o('fixed'),
                },
                {
                    fixed: function () {
                        return a(this, 'tt', '', '')
                    },
                }
            )
        },
        dfa8: function (e, t, n) {
            'use strict'
            n('c7cd')
            var r = function () {
                var e = this,
                    t = e._self._c
                return t(
                    'div',
                    {
                        staticClass: 'toolbar',
                        class: [
                            {
                                transparent: e.transparent,
                                fixed: e.fixed,
                                'white-button': e.whiteButton,
                                'theme-dark': e.darkTheme,
                            },
                        ],
                        attrs: { 'data-log': '原生菜单栏' },
                    },
                    [
                        t('div', {
                            staticClass: 'drag-bar',
                            attrs: { 'data-log': 'drag-bar' },
                        }),
                        t('WindowsActionBar'),
                    ],
                    1
                )
            },
                a = [],
                o = function () {
                    var e = this,
                        t = e._self._c
                    return 'win' === e.platform
                        ? t(
                            'div',
                            {
                                staticClass: 'windows-action-bar',
                                attrs: { 'data-log': 'window菜单栏' },
                            },
                            [
                                t(
                                    'div',
                                    {
                                        staticClass: 'item',
                                        attrs: { 'data-log': '最小化' },
                                        on: { click: e.handleMinimizeWindow },
                                    },
                                    [t('span', { staticClass: 'icon icon-minimize' })]
                                ),
                                t(
                                    'div',
                                    {
                                        staticClass: 'item',
                                        attrs: { 'data-log': '关闭' },
                                        on: { click: e.handleCloseWindow },
                                    },
                                    [t('span', { staticClass: 'icon icon-close' })]
                                ),
                            ]
                        )
                        : e._e()
                },
                c = [],
                i = n('0d52'),
                s = n('e39c'),
                u = {
                    name: 'WindowsActionBar',
                    data: function () {
                        return { platform: Object(s.l)() }
                    },
                    methods: {
                        handleMinimizeWindow: function () {
                            console.info(
                                '对象函数 handleMinimizeWindow,filePath:renderer/components/Common/windowsActionBar.vue'
                            )
                            i.nativeApi.minimizeWindow()
                        },
                        handleCloseWindow: function () {
                            console.info(
                                '对象函数 handleCloseWindow,filePath:renderer/components/Common/windowsActionBar.vue'
                            )
                            localStorage.removeItem('largeClassTestCoverage')
                            localStorage.removeItem('smallClassTestCoverage')
                            i.nativeApi.closeWindow(true)
                        },
                    },
                },
                l = u,
                d = (n('4a82'), n('2877')),
                p = Object(d.a)(l, o, c, false, null, '55cdfd22', null),
                f = p.exports,
                b = {
                    name: 'Toolbar',
                    components: { WindowsActionBar: f },
                    props: {
                        transparent: {
                            default: false,
                            type: Boolean,
                        },
                        fixed: {
                            default: false,
                            type: Boolean,
                        },
                        whiteButton: {
                            default: false,
                            type: Boolean,
                        },
                        disabledMaximize: {
                            default: false,
                            type: Boolean,
                        },
                        darkTheme: {
                            default: false,
                            type: Boolean,
                        },
                    },
                },
                h = b,
                v = (n('3ed8'), Object(d.a)(h, r, a, false, null, '3bd2c296', null))
            t.a = v.exports
        },
    },
])
