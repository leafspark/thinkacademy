; (window.webpackJsonp = window.webpackJsonp || []).push([
    ['Assignment'],
    {
        '0e7b': function (e, t, n) {
            'use strict'
            n.r(t)
            var s = function () {
                var e = this,
                    t = e._self._c
                return t('div', { staticClass: 'page-wrapper' }, [
                    t('div', { staticClass: 'assignment' }, [
                        t('iframe', {
                            staticClass: 'iframe',
                            attrs: {
                                id: 'assignment',
                                src: e.assignmentUrl,
                            },
                            on: { onload: e.handleIframeLoad },
                        }),
                    ]),
                ])
            },
                a = [],
                i = n('c7eb'),
                r = n('1da1'),
                o = n('92e5'),
                c = n('90dc'),
                m = n('e39c'),
                u = n('02fc'),
                d = n('d0db'),
                l = {
                    name: 'Homework',
                    components: {},
                    data: function () {
                        return {
                            title: 'Homework',
                            backUrl: '',
                            assignmentUrl: '',
                            params: {
                                Authorization: '',
                                appName: '',
                                appVersion: '',
                                platform: '',
                                schoolCode: '',
                            },
                        }
                    },
                    mounted: function () {
                        var e = this
                        return Object(r.a)(
                            Object(i.a)().mark(function t() {
                                return Object(i.a)().wrap(function (t) {
                                    while (1) {
                                        switch ((t.prev = t.next)) {
                                            case 0:
                                                return (t.next = 2), e.initMessageParams()
                                            case 2:
                                                e.bindEvent(), e.initRouteParams()
                                            case 4:
                                            case 'end':
                                                return t.stop()
                                        }
                                    }
                                }, t)
                            })
                        )()
                    },
                    methods: {
                        updateHeaderAttr: function () {
                            console.info(
                                '对象函数 updateHeaderAttr,filePath:renderer/views/h5/Assignment.vue'
                            )
                            this.$bus.$emit('updateHeaderAttr', {
                                title: this.$t('courses.assignment.title'),
                                showGoback: true,
                                backUrl: this.backUrl,
                            })
                        },
                        initMessageParams: function () {
                            var e = this
                            return Object(r.a)(
                                Object(i.a)().mark(function t() {
                                    var n, s, a, r, d, l, p
                                    return Object(i.a)().wrap(function (t) {
                                        while (1) {
                                            switch ((t.prev = t.next)) {
                                                case 0:
                                                    return (
                                                        console.info(
                                                            '对象函数 initMessageParams,filePath:renderer/views/h5/Assignment.vue'
                                                        ),
                                                        (t.next = 3),
                                                        Object(o.a)()
                                                    )
                                                case 3:
                                                    return (
                                                        (n = t.sent),
                                                        (s = n.unifiedAccessToken),
                                                        (t.next = 7),
                                                        Object(c.a)()
                                                    )
                                                case 7:
                                                    return (
                                                        (a = t.sent),
                                                        (r = a.appName),
                                                        (d = a.appVersion),
                                                        (t.next = 12),
                                                        Object(u.f)()
                                                    )
                                                case 12:
                                                    ; (l = t.sent),
                                                        (p = Object(m.l)()),
                                                        (e.params.Authorization = s),
                                                        (e.params.appName = r),
                                                        (e.params.appVersion = d),
                                                        (e.params.platform = p),
                                                        (e.params.schoolCode = l)
                                                case 19:
                                                case 'end':
                                                    return t.stop()
                                            }
                                        }
                                    }, t)
                                })
                            )()
                        },
                        initRouteParams: function () {
                            console.info(
                                '对象函数 initRouteParams,filePath:renderer/views/h5/Assignment.vue'
                            )
                            var e = this.$route.query
                            this.assignmentUrl = e.assignmentUrl
                            window.thinkApi.ipc.send('test:url', this.assignmentUrl)
                            this.backUrl = e.backUrl
                            this.updateHeaderAttr()
                        },
                        bindEvent: function () {
                            var e = this
                            console.info(
                                '对象函数 bindEvent,filePath:renderer/views/h5/Assignment.vue'
                            )
                            window.addEventListener(
                                'message',
                                function (t) {
                                    console.info(
                                        '箭头函数 监听 message(e)',
                                        t,
                                        'filePath:renderer/views/h5/Assignment.vue'
                                    )
                                    console.log('Assignment-message', t)
                                    var n = t.data || {},
                                        s = n.type
                                    'homework.init' == s &&
                                        document
                                            .getElementById('assignment')
                                            .contentWindow.postMessage(
                                                {
                                                    type: 'homework.init',
                                                    params: e.params,
                                                },
                                                '*'
                                            )
                                },
                                false
                            )
                        },
                        handleIframeLoad: function () {
                            console.info(
                                '对象函数 handleIframeLoad,filePath:renderer/views/h5/Assignment.vue'
                            )
                            d.a.send({
                                content: {
                                    msg: '加载H5成功-作业',
                                    assignmentUrl: this.assignmentUrl,
                                },
                            })
                        },
                    },
                },
                p = l,
                h = (n('81d0'), n('2877')),
                f = Object(h.a)(p, s, a, false, null, '2bf30225', null)
            t.default = f.exports
        },
        '81d0': function (e, t, n) {
            'use strict'
            n('b8bb')
        },
        b8bb: function (e, t, n) { },
    },
])
