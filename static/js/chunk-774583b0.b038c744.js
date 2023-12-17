; (window.webpackJsonp = window.webpackJsonp || []).push([
    ['chunk-774583b0'],
    {
        '309f': function (e, t, n) {
            'use strict'
            n.d(t, 'a', function () {
                return u
            })
            var s = n('c7eb'),
                r = n('1da1'),
                a = n('92e5'),
                i = n('90dc'),
                o = n('e39c'),
                c = n('02fc'),
                u = (function () {
                    var e = Object(r.a)(
                        Object(s.a)().mark(function e() {
                            var t, n, r, u, p, d, f, m, l, b
                            return Object(s.a)().wrap(function (e) {
                                while (1) {
                                    switch ((e.prev = e.next)) {
                                        case 0:
                                            return (t = {}), (e.next = 3), Object(a.a)()
                                        case 3:
                                            return (
                                                (n = e.sent),
                                                (r = n.unifiedAccessToken),
                                                (u = n.uid),
                                                (e.next = 8),
                                                Object(i.a)()
                                            )
                                        case 8:
                                            return (
                                                (p = e.sent),
                                                (d = p.appName),
                                                (f = p.appVersion),
                                                (e.next = 13),
                                                Object(c.f)()
                                            )
                                        case 13:
                                            return (m = e.sent), (e.next = 16), Object(c.g)()
                                        case 16:
                                            return (
                                                (l = e.sent),
                                                (b = Object(o.k)()),
                                                (t.Authorization = r),
                                                (t.appName = d),
                                                (t.uid = u),
                                                (t.appVersion = f),
                                                (t.platform = b),
                                                (t.schoolCode = m),
                                                (t.timezone = l),
                                                e.abrupt('return', t)
                                            )
                                        case 26:
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
        '31f4': function (e, t, n) { },
        ba0d: function (e, t, n) {
            'use strict'
            n.r(t)
            var s = function () {
                var e = this,
                    t = e._self._c
                return t(
                    'div',
                    { staticClass: 'page-wrapper' },
                    [
                        t('Toolbar'),
                        t('div', { staticClass: 'tempCourse' }, [
                            t('iframe', {
                                staticClass: 'iframe',
                                attrs: {
                                    id: 'tempCourse',
                                    src: e.tempCourseRegistUrl,
                                },
                            }),
                        ]),
                    ],
                    1
                )
            },
                r = [],
                a = n('c7eb'),
                i = n('1da1'),
                o = (n('14d9'), n('dfa8')),
                c = n('309f'),
                u = {
                    name: 'TempCourse',
                    components: { Toolbar: o.a },
                    data: function () {
                        return {
                            backUrl: '',
                            tempCourseRegistUrl: '',
                            params: null,
                        }
                    },
                    mounted: function () {
                        var e = this
                        return Object(i.a)(
                            Object(a.a)().mark(function t() {
                                return Object(a.a)().wrap(function (t) {
                                    while (1) {
                                        switch ((t.prev = t.next)) {
                                            case 0:
                                                return (t.next = 2), Object(c.a)()
                                            case 2:
                                                ; (e.params = t.sent), e.bindEvent(), e.initRouteParams()
                                            case 5:
                                            case 'end':
                                                return t.stop()
                                        }
                                    }
                                }, t)
                            })
                        )()
                    },
                    methods: {
                        initRouteParams: function () {
                            console.info(
                                '对象函数 initRouteParams,filePath:renderer/views/h5/TempCourseRegist.vue'
                            )
                            var e = this.$route.query
                            this.tempCourseRegistUrl = e.tempCourseRegistUrl
                            this.backUrl = e.backUrl
                        },
                        sendMessageToH5: function (e) {
                            console.info(
                                '对象函数 sendMessageToH5(e)',
                                e,
                                'filePath:renderer/views/h5/TempCourseRegist.vue'
                            )
                            var t = e.data || {},
                                n = t.type,
                                s = t.data
                            'common.init' == n &&
                                document.getElementById('tempCourse').contentWindow.postMessage(
                                    {
                                        type: 'common.init',
                                        params: this.params,
                                    },
                                    '*'
                                )
                            'common.backToClient' == n &&
                                this.$router.push({
                                    path: this.backUrl,
                                    query: { getButtonBack: void 0 === s.classId },
                                })
                        },
                        bindEvent: function () {
                            console.info(
                                '对象函数 bindEvent,filePath:renderer/views/h5/TempCourseRegist.vue'
                            )
                            window.addEventListener('message', this.sendMessageToH5, false)
                        },
                    },
                    destroyed: function () {
                        console.info(
                            '对象函数 destroyed,filePath:renderer/views/h5/TempCourseRegist.vue'
                        )
                        window.removeEventListener('message', this.sendMessageToH5)
                    },
                },
                p = u,
                d = (n('cfff'), n('2877')),
                f = Object(d.a)(p, s, r, false, null, '75c1b6b4', null)
            t.default = f.exports
        },
        cfff: function (e, t, n) {
            'use strict'
            n('31f4')
        },
    },
])
