; (window.webpackJsonp = window.webpackJsonp || []).push([
    ['chunk-2ec16a41'],
    {
        '00d9': function (t, e, n) {
            'use strict'
            n('506e')
        },
        '0219': function (t, e, n) { },
        '0ccb': function (t, e, n) {
            var i = n('e330'),
                o = n('50c4'),
                s = n('577e'),
                r = n('1148'),
                a = n('1d80'),
                c = i(r),
                f = i(''.slice),
                l = Math.ceil,
                u = function (t) {
                    return function (e, n, i) {
                        var r,
                            u,
                            d = s(a(e)),
                            m = o(n),
                            h = d.length,
                            g = void 0 === i ? ' ' : s(i)
                        return m <= h || '' == g
                            ? d
                            : ((r = m - h),
                                (u = c(g, l(r / g.length))),
                                u.length > r && (u = f(u, 0, r)),
                                t ? d + u : u + d)
                    }
                }
            t.exports = {
                start: u(false),
                end: u(true),
            }
        },
        '293c3': function (t, e, n) {
            'use strict'
            n('a7b6')
        },
        '4d90': function (t, e, n) {
            'use strict'
            var i = n('23e7'),
                o = n('0ccb').start,
                s = n('9a0c')
            i(
                {
                    target: 'String',
                    proto: true,
                    forced: s,
                },
                {
                    padStart: function (t) {
                        return o(this, t, arguments.length > 1 ? arguments[1] : void 0)
                    },
                }
            )
        },
        '506e': function (t, e, n) { },
        '85e5': function (t, e) {
            t.exports =
                'data:image/png;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBwgICAcIBwcHBwcHBw0HBwcHBw8ICQcNFREWFhURExMYHSggGCYxGxMTITEhJSkrLi4uFx8zODMsNygtLisBCgoKDQ0NDw8PDysZFRkrKystKys3LSsrNys3KysrKysrLSstKystKy0rKysrKysrKysrKysrKysrKysrKysrK//AABEIAMIBAwMBIgACEQEDEQH/xAAWAAEBAQAAAAAAAAAAAAAAAAAAAQf/xAAXEAEBAQEAAAAAAAAAAAAAAAAAARFR/8QAFgEBAQEAAAAAAAAAAAAAAAAAAAEC/8QAFBEBAAAAAAAAAAAAAAAAAAAAAP/aAAwDAQACEQMRAD8Aw4gCAIqqAgAKIAgKgACqICggACiAoICgIAAgAAAAAAAoAICKUUAUAQABAAUAVBAFAAAAAABUUBBQAEQAAAAAURQQQUVRFRBQQAAAAAAABQAAAAVAFRUQVFFACIgAAAAAAAAEAEVBQAAAAAAAABQAQAAAAAAUQBQAABAAAADABQAQQBQAAAAAAAAAAAAAABQABQEAAAAQAAAAAAAFQBQAQAAAAAAAAAAAFAAAAFBEF0BQARAAAAAAAAEAFAAAAAAAAAAAAAFAAAWgIoiCggKAIAACgIAAAKgqAKiggAAAAAAAACgAAAgoigigAAIAAAAAACKKAAICgAgAKACAAAAAAoAAKgCiCCgAACAAAAAAAAoAIigqiKIIAoCiCAKAqIAoCAtURQARRAAEAAAAAAAAAAAAAAAAANFKagAogCoqgioCwCIIKAACAAAAAAAAAIqqAiAAAAAACKCopQAwAABBFAAAAAAAAAAAAAAAAAVAAAAICqAIgABQBRABUAFAEIAAAAAoAIHQAFQAAAAaV//Z'
        },
        9973: function (t, e, n) {
            'use strict'
            n.r(e)
            n.d(e, 'default', function () {
                return ft
            })
            var i = n('5530'),
                o = n('d4ec'),
                s = n('bee2'),
                r = n('262e'),
                a = n('2caf'),
                c = n('b6c9'),
                f = function () {
                    var t = this,
                        e = t._self._c
                    return t.isSubmit
                        ? t._e()
                        : e(
                            'div',
                            {
                                staticClass: 'graffitiContainer',
                                attrs: { id: 'graffitiContainer' },
                            },
                            [
                                t.isNewGraffiti
                                    ? e('GraffitiViewNew', {
                                        attrs: {
                                            countDownTime: t.countDownTime,
                                            options: t.options,
                                            isSubmit: t.GraffitIsSubmit,
                                        },
                                        on: { submit: t.submitNotice },
                                    })
                                    : '' !== t.isNewGraffiti
                                        ? e('GraffitiView', {
                                            attrs: {
                                                countDownTime: t.countDownTime,
                                                options: t.options,
                                                isSubmit: t.GraffitIsSubmit,
                                            },
                                            on: {
                                                submit: t.submitPhoto,
                                                photoData: t.getPhotoData,
                                            },
                                        })
                                        : t._e(),
                                e('UploadProgress', {
                                    attrs: {
                                        classType: t.classType,
                                        percent: t.percent,
                                        visible: t.showUploadProgress,
                                    },
                                }),
                            ],
                            1
                        )
                },
                l = [],
                u = n('c7eb'),
                d = n('1da1'),
                m =
                    (n('c19f'),
                        n('ace4'),
                        n('d3b7'),
                        n('e260'),
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
                        n('3c5d'),
                        n('2954'),
                        n('649e'),
                        n('219c'),
                        n('170b'),
                        n('b39a'),
                        n('72f7'),
                        n('b7ef'),
                        n('907a'),
                        n('986a'),
                        n('1d02'),
                        n('1b3b'),
                        n('3d71'),
                        n('c6e3'),
                        n('99af'),
                        n('8bbf')),
                h = n.n(m),
                g = n('753a'),
                p = n('c5f1'),
                A = (function (t) {
                    Object(r.a)(n, t)
                    var e = Object(a.a)(n)
                    function n() {
                        var t,
                            i =
                                arguments.length > 0 && void 0 !== arguments[0]
                                    ? arguments[0]
                                    : {}
                        return (
                            console.info(
                                '函数申明 Main(opts)',
                                i,
                                'filePath:renderer/components/Classroom/CommonInteractions/graffiti/graffiti.js'
                            ),
                            Object(o.a)(this, n),
                            (t = e.call(this)),
                            (t.options = i),
                            t
                        )
                    }
                    return (
                        Object(s.a)(n, [
                            {
                                key: 'clearTipTimer',
                                value: function () {
                                    this.tipTimer &&
                                        (clearTimeout(this.tipTimer), (this.tipTimer = null))
                                },
                            },
                            {
                                key: 'closeTip',
                                value: function (t, e, n) {
                                    if (t) {
                                        if ((this.clearTipTimer(), e > 0)) {
                                            var i = setTimeout(function () {
                                                t.parentNode.removeChild(t)
                                                clearTimeout(i)
                                                i = null
                                                n && n()
                                            }, e)
                                        }
                                    } else {
                                        console.info(
                                            'if(!dom)为true触发return,path: /renderer/components/Classroom/CommonInteractions/graffiti/graffiti.js'
                                        )
                                    }
                                },
                            },
                            {
                                key: 'showShortCutTip',
                                value: function (t) {
                                    var e = t.duration,
                                        n = void 0 === e ? 3000 : e,
                                        i = t.tips,
                                        o = JSON.parse(
                                            window.sessionStorage.getItem('photoWallShortCutTip')
                                        )
                                    if (o) {
                                        console.info(
                                            'if(needShortCutTip)为true触发return,path: /renderer/components/Classroom/CommonInteractions/graffiti/graffiti.js'
                                        )
                                    } else {
                                        var s = document.createElement('div')
                                        s.setAttribute('class', 'shortCutTip animateTada')
                                        s.innerHTML = '\n      <p>'.concat(i, '</p>\n    ')
                                        document.getElementById('graffitiContainer').appendChild(s)
                                        window.sessionStorage.setItem('photoWallShortCutTip', true)
                                        this.closeTip(s, n)
                                    }
                                },
                            },
                            {
                                key: 'showNotjoinTip',
                                value: function () {
                                    var t =
                                        arguments.length > 0 && void 0 !== arguments[0]
                                            ? arguments[0]
                                            : {},
                                        e = t.tips,
                                        n = t.callback,
                                        i = t.className,
                                        o = void 0 === i ? null : i,
                                        s = t.duration,
                                        r = void 0 === s ? 3000 : s,
                                        a = t.dom,
                                        c = void 0 === a ? 'graffitiContainer' : a,
                                        f = document.createElement('div')
                                    f.setAttribute('class', 'notJoinTip '.concat(o || ''))
                                    f.innerHTML = '\n      <p>'.concat(e, '</p>\n    ')
                                    document.getElementById(c) &&
                                        document.getElementById(c).appendChild(f)
                                    this.closeTip(f, r, n)
                                },
                            },
                            {
                                key: 'showCoinsTip',
                                value: function () {
                                    var t =
                                        arguments.length > 0 && void 0 !== arguments[0]
                                            ? arguments[0]
                                            : {},
                                        e = t.tips,
                                        n = t.coins,
                                        i = void 0 === n ? 0 : n,
                                        o = t.duration,
                                        s = void 0 === o ? 3000 : o,
                                        r = t.callback,
                                        a = void 0 === r ? null : r,
                                        c = t.dom,
                                        f = void 0 === c ? 'graffitiContainer' : c,
                                        l = document.getElementById('submitTipContainer')
                                    l && l.parentNode.removeChild(l)
                                    var u = document.createElement('div')
                                    i
                                        ? (u.setAttribute('class', 'wallConisTip animateTada'),
                                            (u.innerHTML =
                                                '\n        <div class="coins">\n          <i></i> + '
                                                    .concat(i, '\n        </div>\n        <p>')
                                                    .concat(e, '</p>\n      ')))
                                        : (u.setAttribute(
                                            'class',
                                            'wallConisTip submitSuccessTip animateTada'
                                        ),
                                            (u.innerHTML = '<p>'.concat(e, '</p>')))
                                    document.getElementById(f) &&
                                        document.getElementById(f).appendChild(u)
                                    this.closeTip(u, s, a)
                                },
                            },
                            {
                                key: 'showSubmitTip',
                                value: function () {
                                    var t =
                                        arguments.length > 0 && void 0 !== arguments[0]
                                            ? arguments[0]
                                            : {},
                                        e = t.duration,
                                        n = void 0 === e ? 3000 : e,
                                        i = t.callback,
                                        o = void 0 === i ? null : i,
                                        s = t.text,
                                        r = t.icon,
                                        a = t.dom,
                                        c = void 0 === a ? 'graffitiContainer' : a,
                                        f = 'loading' === r ? 0 : n,
                                        l = document.getElementById('submitTipContainer')
                                    l && l.parentNode.removeChild(l)
                                    var u = document.createElement('div')
                                    u.setAttribute('id', 'submitTipContainer')
                                    u.setAttribute('class', 'submitTipContainer')
                                    u.innerHTML = '\n      <div class="tipContainer">\n        '
                                        .concat(
                                            r ? '<i class="' + r + '"></i>' : '',
                                            '\n        <p>'
                                        )
                                        .concat(s, '</p>\n      </div>\n    ')
                                    document.getElementById(c) &&
                                        document.getElementById(c).appendChild(u)
                                    this.closeTip(u, f, o)
                                },
                            },
                            {
                                key: 'initCountdownTime',
                                value: function () {
                                    var t = +new Date(),
                                        e =
                                            this.options.roomMessage.roomInfo.commonOption.timeOffset,
                                        n =
                                            1000 * this.options.ircMsg.totalTime -
                                            (t + e - this.options.ircMsg.beginTime)
                                    return n
                                },
                            },
                            {
                                key: 'interactOpen',
                                value: (function () {
                                    var t = Object(d.a)(
                                        Object(u.a)().mark(function t() {
                                            var e
                                            return Object(u.a)().wrap(
                                                function (t) {
                                                    while (1) {
                                                        switch ((t.prev = t.next)) {
                                                            case 0:
                                                                return (
                                                                    (e = {
                                                                        planId:
                                                                            1 *
                                                                            this.options.roomMessage.roomInfo
                                                                                .stuLiveInfo.planId,
                                                                        classId:
                                                                            1 *
                                                                            this.options.roomMessage.roomInfo
                                                                                .stuLiveInfo.classId,
                                                                        interactId: this.options.ircMsg.interactId,
                                                                    }),
                                                                    (t.next = 3),
                                                                    Object(p.b)(e)
                                                                )
                                                            case 3:
                                                            case 'end':
                                                                return t.stop()
                                                        }
                                                    }
                                                },
                                                t,
                                                this
                                            )
                                        })
                                    )
                                    function e() {
                                        return (
                                            console.info(
                                                '函数申明 interactOpen, filePath:renderer/components/Classroom/CommonInteractions/graffiti/graffiti.js'
                                            ),
                                            t.apply(this, arguments)
                                        )
                                    }
                                    return e
                                })(),
                            },
                            {
                                key: 'submitPhoto',
                                value: (function () {
                                    var t = Object(d.a)(
                                        Object(u.a)().mark(function t(e, n) {
                                            var i, o, s
                                            return Object(u.a)().wrap(
                                                function (t) {
                                                    while (1) {
                                                        switch ((t.prev = t.next)) {
                                                            case 0:
                                                                return (
                                                                    (i = {
                                                                        planId:
                                                                            1 *
                                                                            this.options.roomMessage.roomInfo
                                                                                .stuLiveInfo.planId,
                                                                        classId:
                                                                            this.options.roomMessage.roomInfo
                                                                                .stuLiveInfo.classId,
                                                                        tutorId:
                                                                            this.options.roomMessage.roomInfo
                                                                                .stuLiveInfo.tutorId,
                                                                        photoPath: e,
                                                                        interactId: this.options.ircMsg.interactId,
                                                                        teacherId:
                                                                            this.options.roomMessage.roomInfo
                                                                                .teacherInfo.id,
                                                                    }),
                                                                    n && (i.version = 722),
                                                                    (t.next = 4),
                                                                    Object(p.d)(i)
                                                                )
                                                            case 4:
                                                                return (
                                                                    (o = t.sent),
                                                                    0 === o.code &&
                                                                    o.data &&
                                                                    ((s = o.data.rightCoin),
                                                                        h.a.prototype.$bus.$emit(
                                                                            'updateAchievement',
                                                                            'add',
                                                                            s
                                                                        )),
                                                                    t.abrupt('return', o)
                                                                )
                                                            case 8:
                                                            case 'end':
                                                                return t.stop()
                                                        }
                                                    }
                                                },
                                                t,
                                                this
                                            )
                                        })
                                    )
                                    function e(e, n) {
                                        return (
                                            console.info(
                                                '函数申明 submitPhoto(_x, _x2)',
                                                e,
                                                n,
                                                'filePath:renderer/components/Classroom/CommonInteractions/graffiti/graffiti.js'
                                            ),
                                            t.apply(this, arguments)
                                        )
                                    }
                                    return e
                                })(),
                            },
                            {
                                key: 'getWallStatus',
                                value: (function () {
                                    var t = Object(d.a)(
                                        Object(u.a)().mark(function t() {
                                            var e, n
                                            return Object(u.a)().wrap(
                                                function (t) {
                                                    while (1) {
                                                        switch ((t.prev = t.next)) {
                                                            case 0:
                                                                return (
                                                                    (e = {
                                                                        planId:
                                                                            1 *
                                                                            this.options.roomMessage.roomInfo
                                                                                .stuLiveInfo.planId,
                                                                        interactId: this.options.ircMsg.interactId,
                                                                    }),
                                                                    (t.next = 3),
                                                                    Object(p.a)(e)
                                                                )
                                                            case 3:
                                                                return (n = t.sent), t.abrupt('return', n)
                                                            case 5:
                                                            case 'end':
                                                                return t.stop()
                                                        }
                                                    }
                                                },
                                                t,
                                                this
                                            )
                                        })
                                    )
                                    function e() {
                                        return (
                                            console.info(
                                                '函数申明 getWallStatus, filePath:renderer/components/Classroom/CommonInteractions/graffiti/graffiti.js'
                                            ),
                                            t.apply(this, arguments)
                                        )
                                    }
                                    return e
                                })(),
                            },
                            {
                                key: 'submitGratiffi',
                                value: (function () {
                                    var t = Object(d.a)(
                                        Object(u.a)().mark(function t() {
                                            var e, n
                                            return Object(u.a)().wrap(
                                                function (t) {
                                                    while (1) {
                                                        switch ((t.prev = t.next)) {
                                                            case 0:
                                                                return (
                                                                    (e = {
                                                                        planId:
                                                                            1 *
                                                                            this.options.roomMessage.roomInfo
                                                                                .stuLiveInfo.planId,
                                                                        classId:
                                                                            this.options.roomMessage.roomInfo
                                                                                .stuLiveInfo.classId,
                                                                        tutorId:
                                                                            this.options.roomMessage.roomInfo
                                                                                .stuLiveInfo.tutorId,
                                                                        interactId: this.options.ircMsg.interactId,
                                                                        version: 722,
                                                                    }),
                                                                    (t.next = 3),
                                                                    Object(p.c)(e)
                                                                )
                                                            case 3:
                                                                return (n = t.sent), t.abrupt('return', n)
                                                            case 5:
                                                            case 'end':
                                                                return t.stop()
                                                        }
                                                    }
                                                },
                                                t,
                                                this
                                            )
                                        })
                                    )
                                    function e() {
                                        return (
                                            console.info(
                                                '函数申明 submitGratiffi, filePath:renderer/components/Classroom/CommonInteractions/graffiti/graffiti.js'
                                            ),
                                            t.apply(this, arguments)
                                        )
                                    }
                                    return e
                                })(),
                            },
                        ]),
                        n
                    )
                })(g.a),
                v = function () {
                    var t = this,
                        e = t._self._c
                    return e(
                        'div',
                        { staticClass: 'photoShotContainer' },
                        [
                            e('GratiffiTools', {
                                attrs: {
                                    minutes: t.minutes,
                                    seconds: t.seconds,
                                    isSubmit: t.isSubmit,
                                },
                                on: {
                                    graffitiDraw: t.graffitiDraw,
                                    graffitiEraser: t.graffitiEraser,
                                    confirm: t.confirm,
                                },
                            }),
                            e('div', {
                                staticClass: 'graffitiWrapper',
                                attrs: { id: 'graffitiWrapper' },
                            }),
                        ],
                        1
                    )
                },
                b = [],
                C = (n('a9e3'), n('4d90'), n('25f0'), n('6e4d')),
                w = n.n(C),
                I = n('e39c'),
                y = n('b047'),
                S = n.n(y),
                O = function () {
                    var t = this,
                        e = t._self._c
                    return e('div', { staticClass: 'tools' }, [
                        e('div', { staticClass: 'graffitiTools' }, [
                            e(
                                'i',
                                {
                                    staticClass: 'draw draw-yellow select',
                                    on: {
                                        click: function (e) {
                                            return t.graffitiDraw('yellow', '#ffcf1b', e)
                                        },
                                    },
                                },
                                [
                                    t._v(
                                        ' ' +
                                        t._s(t.$t('classroom.interactions.graffiti.yellow')) +
                                        ' '
                                    ),
                                ]
                            ),
                            e(
                                'i',
                                {
                                    staticClass: 'draw draw-red',
                                    on: {
                                        click: function (e) {
                                            return t.graffitiDraw('red', '#ff503f', e)
                                        },
                                    },
                                },
                                [
                                    t._v(
                                        ' ' +
                                        t._s(t.$t('classroom.interactions.graffiti.red')) +
                                        ' '
                                    ),
                                ]
                            ),
                            e(
                                'i',
                                {
                                    staticClass: 'draw draw-blue',
                                    on: {
                                        click: function (e) {
                                            return t.graffitiDraw('blue', '#1572ff', e)
                                        },
                                    },
                                },
                                [
                                    t._v(
                                        ' ' +
                                        t._s(t.$t('classroom.interactions.graffiti.blue')) +
                                        ' '
                                    ),
                                ]
                            ),
                            e('i', {
                                staticClass: 'draw eraser',
                                on: { click: t.graffitiEraser },
                            }),
                        ]),
                        e(
                            'div',
                            { staticClass: 'userTools' },
                            [
                                e('div', { staticClass: 'time' }, [
                                    e('div', { staticClass: 'minutes' }, [
                                        e('span', { staticClass: 'line' }),
                                        e('span', { staticClass: 'num' }, [t._v(t._s(t.minutes))]),
                                    ]),
                                    t._m(0),
                                    e('div', { staticClass: 'seconds' }, [
                                        e('span', { staticClass: 'line' }),
                                        e('span', { staticClass: 'num' }, [t._v(t._s(t.seconds))]),
                                    ]),
                                ]),
                                e(
                                    'a-button',
                                    {
                                        staticClass: 'submit-btn',
                                        class: { 'is-submit': t.isSubmit },
                                        attrs: {
                                            shape: 'round',
                                            disabled: t.isSubmit,
                                        },
                                        on: { click: t.confirm },
                                    },
                                    [t._v(' ' + t._s(t.$t('common.done')) + ' ')]
                                ),
                            ],
                            1
                        ),
                    ])
                },
                B = [
                    function () {
                        var t = this,
                            e = t._self._c
                        return e('div', { staticClass: 'dots' }, [e('span'), e('span')])
                    },
                ],
                T =
                    (n('159b'),
                    {
                        name: 'GratiffiTools',
                        props: {
                            minutes: {
                                type: String,
                                default: '00',
                            },
                            seconds: {
                                type: String,
                                default: '00',
                            },
                            isSubmit: {
                                style: Boolean,
                                default: false,
                            },
                        },
                        methods: {
                            graffitiDraw: function (t, e, n) {
                                console.info(
                                    '对象函数 graffitiDraw(abstractColor, specificColor, e)',
                                    t,
                                    e,
                                    n,
                                    'filePath:renderer/components/Classroom/CommonInteractions/graffiti/components/graffitiTools.vue'
                                )
                                n && this.setClass(n.target)
                                this.$emit('graffitiDraw', t, e)
                            },
                            graffitiEraser: function (t) {
                                console.info(
                                    '对象函数 graffitiEraser(e)',
                                    t,
                                    'filePath:renderer/components/Classroom/CommonInteractions/graffiti/components/graffitiTools.vue'
                                )
                                this.setClass(t.target)
                                this.$emit('graffitiEraser')
                            },
                            setClass: function (t) {
                                console.info(
                                    '对象函数 setClass(target)',
                                    t,
                                    'filePath:renderer/components/Classroom/CommonInteractions/graffiti/components/graffitiTools.vue'
                                )
                                t.parentNode.children.forEach(function (t) {
                                    Object(I.w)(t, 'select')
                                })
                                Object(I.a)(t, 'select')
                            },
                            confirm: function () {
                                console.info(
                                    '对象函数 confirm,filePath:renderer/components/Classroom/CommonInteractions/graffiti/components/graffitiTools.vue'
                                )
                                this.$emit('confirm')
                            },
                        },
                    }),
                N = T,
                k = (n('00d9'), n('2877')),
                M = Object(k.a)(N, O, B, false, null, 'bf7a062e', null),
                D = M.exports,
                j = n('d0db'),
                W = {
                    name: 'smallClassGraffiti',
                    props: {
                        closeInteractive: {
                            style: Boolean,
                            default: false,
                        },
                        isSubmit: {
                            style: Boolean,
                            default: false,
                        },
                        countDownTime: {
                            type: Number,
                            default: 0,
                        },
                        options: {
                            type: Object,
                            default: function () { },
                        },
                    },
                    data: function () {
                        return {
                            graffiti: null,
                            dialogVisible: false,
                            dialogContent: null,
                            dialogDescription: null,
                            timer: null,
                            minutes: '00',
                            seconds: '00',
                            graffitiInit: {
                                dom: 'graffitiWrapper',
                                width: 840,
                                height: 630,
                                quality: 0.8,
                                lineColor: '#ffcf1b',
                                background: '',
                                lineSize: 3,
                            },
                            eraserSize: 25,
                        }
                    },
                    components: { GratiffiTools: D },
                    mounted: function () {
                        var t = this
                        this.renderCountDown()
                        this.$nextTick(
                            Object(d.a)(
                                Object(u.a)().mark(function e() {
                                    return Object(u.a)().wrap(function (e) {
                                        while (1) {
                                            switch ((e.prev = e.next)) {
                                                case 0:
                                                    t.initGraffitiDraw()
                                                case 1:
                                                case 'end':
                                                    return e.stop()
                                            }
                                        }
                                    }, e)
                                })
                            )
                        )
                        window.addEventListener('resize', this.setGraffitiScale)
                    },
                    computed: {},
                    methods: {
                        initGraffitiDraw: function () {
                            var t = this
                            return Object(d.a)(
                                Object(u.a)().mark(function e() {
                                    var n
                                    return Object(u.a)().wrap(function (e) {
                                        while (1) {
                                            switch ((e.prev = e.next)) {
                                                case 0:
                                                    return (
                                                        console.info(
                                                            '对象函数 initGraffitiDraw,filePath:renderer/components/Classroom/CommonInteractions/graffiti/components/graffiti.vue'
                                                        ),
                                                        (n = document.querySelector('#graffitiContainer')),
                                                        (t.graffitiInit.width = n.clientWidth),
                                                        (t.graffitiInit.height = n.clientHeight),
                                                        t.options,
                                                        t.sendLogger(
                                                            '涂鸦画板this.options : '.concat(
                                                                JSON.stringify(t.options)
                                                            )
                                                        ),
                                                        (t.graffitiInit.background =
                                                            t.options.ircMsg.imageUrl || '#000000'),
                                                        (e.next = 9),
                                                        w.a.init(t.graffitiInit)
                                                    )
                                                case 9:
                                                    ; (t.graffiti = e.sent),
                                                        t.graffiti.setAttribute(
                                                            'class',
                                                            'yellow_penCursor'
                                                        ),
                                                        w.a.draw()
                                                case 12:
                                                case 'end':
                                                    return e.stop()
                                            }
                                        }
                                    }, e)
                                })
                            )()
                        },
                        renderCountDown: function () {
                            console.info(
                                '对象函数 renderCountDown,filePath:renderer/components/Classroom/CommonInteractions/graffiti/components/graffiti.vue'
                            )
                            this.countDown()
                            this.timer = setInterval(this.countDown, 1000)
                        },
                        setGraffitiScale: S()(function () {
                            var t = document.querySelector('#graffitiContainer'),
                                e = document.querySelector('#graffitiWrapper')
                            if (t) {
                                var n = t.querySelector('canvas'),
                                    i = t.querySelector('img')
                                e.firstChild.style.width =
                                    e.style.width =
                                    i.style.width =
                                    n.style.width =
                                    t.clientWidth + 'px'
                                e.firstChild.style.height =
                                    e.style.height =
                                    i.style.height =
                                    n.style.height =
                                    t.clientHeight + 'px'
                            }
                        }, 300),
                        graffitiDraw: function (t, e) {
                            console.info(
                                '对象函数 graffitiDraw(abstractColor, specificColor)',
                                t,
                                e,
                                'filePath:renderer/components/Classroom/CommonInteractions/graffiti/components/graffiti.vue'
                            )
                            this.graffiti.setAttribute('class', ''.concat(t, '_penCursor'))
                            w.a.lineColor(e)
                            w.a.draw()
                        },
                        graffitiEraser: function () {
                            console.info(
                                '对象函数 graffitiEraser,filePath:renderer/components/Classroom/CommonInteractions/graffiti/components/graffiti.vue'
                            )
                            this.graffiti.setAttribute('class', 'eraserCursor')
                            w.a.eraser(this.eraserSize)
                        },
                        createImage: function () {
                            var t = this
                            return Object(d.a)(
                                Object(u.a)().mark(function e() {
                                    var n
                                    return Object(u.a)().wrap(function (e) {
                                        while (1) {
                                            switch ((e.prev = e.next)) {
                                                case 0:
                                                    return (
                                                        console.info(
                                                            '对象函数 createImage,filePath:renderer/components/Classroom/CommonInteractions/graffiti/components/graffiti.vue'
                                                        ),
                                                        (e.next = 3),
                                                        w.a.createImage()
                                                    )
                                                case 3:
                                                    ; (n = e.sent),
                                                        0 === n.errCode &&
                                                        (t.sendLogger(
                                                            '生成涂鸦图片 : '.concat(JSON.stringify(n.data))
                                                        ),
                                                            t.$emit('photoData', n.data))
                                                case 6:
                                                case 'end':
                                                    return e.stop()
                                            }
                                        }
                                    }, e)
                                })
                            )()
                        },
                        confirm: function () {
                            var t = this
                            return Object(d.a)(
                                Object(u.a)().mark(function e() {
                                    return Object(u.a)().wrap(function (e) {
                                        while (1) {
                                            switch ((e.prev = e.next)) {
                                                case 0:
                                                    return (
                                                        console.info(
                                                            '对象函数 confirm,filePath:renderer/components/Classroom/CommonInteractions/graffiti/components/graffiti.vue'
                                                        ),
                                                        t.sendLogger('涂鸦画板学生点击提交'),
                                                        (e.next = 4),
                                                        t.createImage()
                                                    )
                                                case 4:
                                                    t.$emit('submit')
                                                case 5:
                                                case 'end':
                                                    return e.stop()
                                            }
                                        }
                                    }, e)
                                })
                            )()
                        },
                        countDown: function () {
                            if (
                                (console.info(
                                    '对象函数 countDown,filePath:renderer/components/Classroom/CommonInteractions/graffiti/components/graffiti.vue'
                                ),
                                    this.countDownTime >= 0)
                            ) {
                                var t = Math.floor(this.countDownTime / 60),
                                    e = Math.floor(this.countDownTime % 60)
                                this.countDownTime = this.countDownTime - 1
                                this.minutes = t.toString().padStart(2, '0')
                                this.seconds = e.toString().padStart(2, '0')
                            } else {
                                clearInterval(this.timer)
                            }
                        },
                        sendLogger: function (t) {
                            var e =
                                arguments.length > 1 && void 0 !== arguments[1]
                                    ? arguments[1]
                                    : ''
                            j.a.send({
                                tag: 'student.Interact',
                                content: {
                                    msg: t,
                                    interactType: 'Graffiti',
                                    interactId: '',
                                    interactStage: e,
                                },
                            })
                        },
                    },
                    beforeDestroy: function () {
                        console.info(
                            '对象函数 beforeDestroy,filePath:renderer/components/Classroom/CommonInteractions/graffiti/components/graffiti.vue'
                        )
                        window.removeEventListener('resize', this.setGraffitiScale)
                        w.a.destroy()
                        this.sendLogger('关闭互动')
                        this.timer && clearInterval(this.timer)
                    },
                    watch: {
                        closeInteractive: function (t) {
                            console.info(
                                '对象函数 closeInteractive(val)',
                                t,
                                'filePath:renderer/components/Classroom/CommonInteractions/graffiti/components/graffiti.vue'
                            )
                            t && this.createImage()
                        },
                    },
                },
                P = W,
                L = (n('99f5'), Object(k.a)(P, v, b, false, null, '71ffa29c', null)),
                R = L.exports,
                E = function () {
                    var t = this,
                        e = t._self._c
                    return e(
                        'div',
                        { staticClass: 'photoShotContainer photoShotNewContainer' },
                        [
                            e('GratiffiTools', {
                                ref: 'GratiffiTools',
                                attrs: {
                                    minutes: t.minutes,
                                    seconds: t.seconds,
                                    isSubmit: t.isSubmit,
                                },
                                on: {
                                    graffitiDraw: t.graffitiDraw,
                                    graffitiEraser: t.graffitiEraser,
                                    confirm: t.confirm,
                                },
                            }),
                            e(
                                'div',
                                {
                                    staticClass: 'graffitiWrapper graffitiNewWrapper',
                                    attrs: { id: 'graffitiWrapper' },
                                },
                                [
                                    e('img', {
                                        attrs: {
                                            id: 'gratiffiImg',
                                            src: n('85e5'),
                                        },
                                        on: {
                                            load: function (e) {
                                                return t.handleImgLoad(e)
                                            },
                                            error: function (e) {
                                                return t.handleImgError(e)
                                            },
                                        },
                                    }),
                                    e('white-board-canvas', { ref: 'WhiteBoardNew' }),
                                    e('white-board-tools', { ref: 'WhiteBoardTools' }),
                                ],
                                1
                            ),
                            t.teacherWatching
                                ? e('div', { staticClass: 'teacher-watching-label' }, [
                                    t._v(' ' + t._s(t.$t('common.teacherWatching')) + ' '),
                                ])
                                : t._e(),
                        ],
                        1
                    )
                },
                $ = [],
                x = n('2909'),
                G =
                    (n('14d9'),
                        n('e6cf'),
                        n('3ca3'),
                        n('ddb0'),
                        n('0481'),
                        n('4069'),
                        n('20bf'),
                        n('f3f2')),
                Q = n.n(G),
                _ = (n('bcac'), n('281f')),
                H = n.n(_),
                K = (n('8d67'), n('612a')),
                U = n('97a4'),
                F = n('c02a'),
                q = n('c58d'),
                J = {
                    name: 'smallClassGraffitiNew',
                    props: {
                        closeInteractive: {
                            style: Boolean,
                            default: false,
                        },
                        isSubmit: {
                            style: Boolean,
                            default: false,
                        },
                        countDownTime: {
                            type: Number,
                            default: 0,
                        },
                        options: {
                            type: Object,
                            default: function () { },
                        },
                    },
                    data: function () {
                        return {
                            dialogVisible: false,
                            dialogContent: null,
                            dialogDescription: null,
                            timer: null,
                            minutes: '00',
                            seconds: '00',
                            isBanned: false,
                            currentThickness: 4,
                            currentLineDashed: false,
                            containerWidth: 0,
                            containerHeight: 0,
                            gratiffiMsgArray: [],
                            teacherWatching: false,
                            eraserSize: 50,
                            countDownTimeCopy: null,
                            canvasScale: 2,
                        }
                    },
                    components: {
                        WhiteBoardCanvas: Q.a.WhiteBoardCanvas,
                        WhiteBoardTools: H.a,
                        GratiffiTools: D,
                    },
                    mounted: function () {
                        var t = this
                        return Object(d.a)(
                            Object(u.a)().mark(function e() {
                                return Object(u.a)().wrap(function (e) {
                                    while (1) {
                                        switch ((e.prev = e.next)) {
                                            case 0:
                                                return (
                                                    t.teacherIsWatchingMe(
                                                        K.a.state.smallClass.gratiffiBoardWatchingInfo
                                                    ),
                                                    (e.next = 3),
                                                    Object(q.a)()
                                                )
                                            case 3:
                                                ; (t.canvasScale = e.sent),
                                                    t.$nextTick(
                                                        Object(d.a)(
                                                            Object(u.a)().mark(function e() {
                                                                var n
                                                                return Object(u.a)().wrap(function (e) {
                                                                    while (1) {
                                                                        switch ((e.prev = e.next)) {
                                                                            case 0:
                                                                                t.initBoard(),
                                                                                    t.listenerSignalService(),
                                                                                    t.options.ircMsg.imageUrl &&
                                                                                    ((n =
                                                                                        document.querySelector(
                                                                                            '#gratiffiImg'
                                                                                        )),
                                                                                        t.sendLogger(
                                                                                            '涂鸦画板更换背景图 '
                                                                                                .concat(n, ',')
                                                                                                .concat(
                                                                                                    t.options.ircMsg.imageUrl
                                                                                                )
                                                                                        ),
                                                                                        (n.src =
                                                                                            t.options.ircMsg.imageUrl)),
                                                                                    t.sendLogger(
                                                                                        'this.options, '.concat(
                                                                                            JSON.stringify(t.options)
                                                                                        )
                                                                                    )
                                                                            case 4:
                                                                            case 'end':
                                                                                return e.stop()
                                                                        }
                                                                    }
                                                                }, e)
                                                            })
                                                        )
                                                    ),
                                                    t.renderCountDown(),
                                                    window.addEventListener('resize', t.setGraffitiScale)
                                            case 7:
                                            case 'end':
                                                return e.stop()
                                        }
                                    }
                                }, e)
                            })
                        )()
                    },
                    computed: {
                        roomInfo: function () {
                            return (
                                console.info(
                                    '对象函数 roomInfo,filePath:renderer/components/Classroom/CommonInteractions/graffiti/components/graffitiNew.vue'
                                ),
                                this.options.roomMessage.roomInfo
                            )
                        },
                    },
                    watch: {
                        teacherWatching: function (t) {
                            console.info(
                                '对象函数 teacherWatching(val)',
                                t,
                                'filePath:renderer/components/Classroom/CommonInteractions/graffiti/components/graffitiNew.vue'
                            )
                            t && this.sendGratiffiMsg()
                        },
                    },
                    methods: {
                        handleImgLoad: function (t) {
                            console.info(
                                '对象函数 handleImgLoad(event)',
                                t,
                                'filePath:renderer/components/Classroom/CommonInteractions/graffiti/components/graffitiNew.vue'
                            )
                            this.sendLogger('涂鸦画板背景图加载成功', { url: t.target.src })
                        },
                        handleImgError: function (t) {
                            console.info(
                                '对象函数 handleImgError(event)',
                                t,
                                'filePath:renderer/components/Classroom/CommonInteractions/graffiti/components/graffitiNew.vue'
                            )
                            console.error('涂鸦画板背景图加载失败', t.target.src)
                            this.sendLogger(
                                '涂鸦画板背景图加载失败',
                                { url: t.target.src },
                                'error'
                            )
                        },
                        initBoard: function () {
                            var t = this
                            console.info(
                                '对象函数 initBoard,filePath:renderer/components/Classroom/CommonInteractions/graffiti/components/graffitiNew.vue'
                            )
                            this.getCurrentCanvasSize()
                            var e = {
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
                                    liveId: String(this.roomInfo.planInfo.id),
                                    role: 'student',
                                    dataVersion: '1',
                                    courseId: '',
                                    userId: this.roomInfo.stuInfo.id + '',
                                    userName: this.roomInfo.stuInfo.nickName,
                                    screenWidth: this.containerWidth,
                                    screenHeight: this.containerHeight,
                                    roomIds: [this.roomInfo.commonOption.roomlist[0]],
                                    fastFrequency: 2000,
                                    slowFrequency: 3000,
                                    serverTimestamp:
                                        +new Date() + this.roomInfo.commonOption.timeOffset,
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
                                (this.$refs,
                                    this.sendLogger('涂鸦初始化参数, '.concat(JSON.stringify(e))),
                                    this.$refs.WhiteBoardNew)
                            ) {
                                this.$refs.WhiteBoardNew.uninit()
                                this.$refs.WhiteBoardNew.init(e)
                                this.$refs.WhiteBoardNew.handleMouse('default')
                                var n = this.$refs.WhiteBoardNew.getMainBoardHandWritting(),
                                    i = this.$refs.WhiteBoardNew.getPluginManager(),
                                    o = this.$refs.WhiteBoardNew,
                                    s = ''
                                        .concat(this.roomInfo.stuInfo.id, '_')
                                        .concat(this.options.ircMsg.dbkey, '#')
                                        .concat(this.roomInfo.stuInfo.id),
                                    r = s.split('_')[5]
                                this.$refs.WhiteBoardTools.init(o, n, i)
                                var a = [11, 12, 13, 14, 15, 1000]
                                a.forEach(function (e) {
                                    1000 === e
                                        ? i.registerEvent(
                                            'WhiteboardResize',
                                            e,
                                            t.toolsMessageHandler('WhiteboardResize', e, String(r))
                                        )
                                        : i.registerEvent(
                                            'ReceiveBinaryData',
                                            e,
                                            t.toolsMessageHandler('ReceiveBinaryData', e, String(r))
                                        )
                                })
                                this.$refs.WhiteBoardTools.setWBToolsStatus(false)
                                this.$refs.WhiteBoardTools.handleMenuEnable(false)
                                this.$refs.WhiteBoardNew.handleResetImComingDbkey(s)
                                this.$refs.WhiteBoardNew.handlePageChange(String(r))
                                this.$refs.WhiteBoardTools.handlePageChange(String(r))
                                this.$refs.GratiffiTools.graffitiDraw('yellow', '#ffcf1b')
                            }
                        },
                        toolsMessageHandler: function (t, e, n) {
                            var i = this
                            return (
                                console.info(
                                    '对象函数 toolsMessageHandler(actionType, toolType, pageId)',
                                    t,
                                    e,
                                    n,
                                    'filePath:renderer/components/Classroom/CommonInteractions/graffiti/components/graffitiNew.vue'
                                ),
                                function (o) {
                                    i.$refs.WhiteBoardTools.receiveBinaryData(t, e, n, o)
                                }
                            )
                        },
                        sendRoomCanvasMessage: function (t, e) {
                            this.teacherWatching
                                ? (this.thinkClass.SignalService.sendRoomBinMessage(
                                    [this.roomInfo.commonOption.roomlist[0]],
                                    ''
                                        .concat(this.options.ircMsg.dbkey, '#')
                                        .concat(this.roomInfo.stuInfo.id),
                                    e.keyMsgId,
                                    e.content
                                ),
                                    this.sendLogger(
                                        '发送涂鸦画板涂鸦消息:'
                                            .concat(e.dbKey, ' ')
                                            .concat(e.keyMsgId)
                                    ))
                                : (this.gratiffiMsgArray.push(e),
                                    this.$refs.WhiteBoardNew &&
                                    this.$refs.WhiteBoardNew.handleSendMessageSuccess(
                                        e.dbKey,
                                        e.keyMsgId
                                    ),
                                    this.sendLogger(
                                        '保存涂鸦画板涂鸦消息:'
                                            .concat(e.dbKey, ' ')
                                            .concat(e.keyMsgId)
                                    ))
                        },
                        getHistoryMessage: function (t) {
                            var e = this
                            console.info(
                                '对象函数 getHistoryMessage(data)',
                                t,
                                'filePath:renderer/components/Classroom/CommonInteractions/graffiti/components/graffitiNew.vue'
                            )
                            var n = ''
                                .concat(this.options.ircMsg.dbkey, '#')
                                .concat(this.roomInfo.stuInfo.id),
                                i = 'teacher_'.concat(n),
                                o = [n, i]
                            this.sendLogger('拉取历史消息dbkey :'.concat(JSON.stringify(o)))
                            var s = []
                            o.forEach(function (t) {
                                s.push(
                                    Object(U.a)({
                                        dbkey: t,
                                        appId: K.a.state.smallClass.baseData.configs.ircAk,
                                        sk: K.a.state.smallClass.baseData.configs.ircSk,
                                        businessId: 3,
                                        liveId: K.a.state.smallClass.baseData.planInfo.id,
                                        ircApiHost:
                                            K.a.state.smallClass.baseData.configs.ircApiHost,
                                    })
                                )
                            })
                            Promise.all(s)
                                .then(function (t) {
                                    console.info(
                                        '箭头函数 then(resAll)',
                                        t,
                                        'filePath:renderer/components/Classroom/CommonInteractions/graffiti/components/graffitiNew.vue'
                                    )
                                    var n = t.flat()
                                    try {
                                        e.$refs.WhiteBoardNew &&
                                            e.$refs.WhiteBoardNew.handleRecoverHistoryMessage([
                                                { content: n },
                                            ])
                                    } catch (i) {
                                        console.error(i)
                                    }
                                })
                                .catch(function (t) {
                                    console.info(
                                        '箭头函数 catch(err)',
                                        t,
                                        'filePath:renderer/components/Classroom/CommonInteractions/graffiti/components/graffitiNew.vue'
                                    )
                                    console.error(t)
                                })
                        },
                        listenerSignalService: function () {
                            console.info(
                                '对象函数 listenerSignalService,filePath:renderer/components/Classroom/CommonInteractions/graffiti/components/graffitiNew.vue'
                            )
                            this.thinkClass.SignalService.on(
                                'onGetRoomHistoryBinMessageNotice',
                                this.handleOnGetRoomHistoryBinMessageNotice
                            )
                            this.thinkClass.SignalService.on(
                                'onRecvRoomDataUpdateNotice',
                                this.handleOnRecvRoomDataUpdateNotice
                            )
                            this.thinkClass.SignalService.on(
                                'onRecvRoomBinMessageNotice',
                                this.handleOnRecvRoomBinMessageNotice
                            )
                            this.thinkClass.SignalService.on(
                                'onSendRoomBinMessageResp',
                                this.handleOnSendRoomBinMessageResp
                            )
                        },
                        handleOnGetRoomHistoryBinMessageNotice: function (t) {
                            console.info(
                                '对象函数 handleOnGetRoomHistoryBinMessageNotice(data)',
                                t,
                                'filePath:renderer/components/Classroom/CommonInteractions/graffiti/components/graffitiNew.vue'
                            )
                            this.sendLogger('监听信令历史消息 :'.concat(JSON.stringify(t)))
                            var e = t
                            if (Array.isArray(e)) {
                                e.forEach(function (t, n) {
                                    e[n].content = Uint8Array.from(t.content)
                                })
                                try {
                                    this.$refs.WhiteBoardNew &&
                                        this.$refs.WhiteBoardNew.handleRecoverHistoryMessage([
                                            { content: e },
                                        ])
                                } catch (n) {
                                    this.sendLogger('涂鸦sdk报错 '.concat(n), {}, 'error')
                                }
                            } else {
                                this.sendLogger(
                                    '涂鸦历史消息格式错误 res: '.concat(JSON.stringify(res)),
                                    {},
                                    'error'
                                )
                            }
                        },
                        handleOnRecvRoomDataUpdateNotice: function (t) {
                            var e = t.key,
                                n = t.noticeContent
                            'graffiti_board_watching' === e &&
                                (this.sendLogger(
                                    '老师正在查看学生涂鸦 :'.concat(JSON.stringify(n))
                                ),
                                    this.teacherIsWatchingMe(n))
                        },
                        handleOnRecvRoomBinMessageNotice: function (t) {
                            this.sendLogger(
                                '收到涂鸦消息 :'.concat(t.dbKey, ', ').concat(t.msgId)
                            )
                            this.$refs.WhiteBoardNew &&
                                this.$refs.WhiteBoardNew.handleRoomCanvasMessage(t)
                        },
                        handleOnSendRoomBinMessageResp: function (t) {
                            this.sendLogger(
                                '发送涂鸦消息回调 : '.concat(t.dbKey, ', ').concat(t.keyMsgId)
                            )
                            0 === t.code
                                ? this.$refs.WhiteBoardNew &&
                                this.$refs.WhiteBoardNew.handleSendMessageSuccess(
                                    t.dbKey,
                                    t.keyMsgId
                                )
                                : (this.$refs.WhiteBoardNew &&
                                    this.$refs.WhiteBoardNew.handleSendMessageError(
                                        t.code,
                                        t.msg,
                                        t.dbKey,
                                        t.keyMsgId
                                    ),
                                    this.sendLogger(
                                        '涂鸦发送失败:'.concat(
                                            'code:' +
                                            t.code +
                                            'msg:' +
                                            t.msg +
                                            'dbKey:' +
                                            t.dbKey +
                                            'keyMsgId:' +
                                            t.keyMsgId
                                        ),
                                        {},
                                        'error'
                                    ))
                        },
                        teacherIsWatchingMe: function (t) {
                            console.info(
                                '对象函数 teacherIsWatchingMe(noticeContent)',
                                t,
                                'filePath:renderer/components/Classroom/CommonInteractions/graffiti/components/graffitiNew.vue'
                            )
                            this.teacherWatching = t.studentId === this.roomInfo.stuInfo.id
                        },
                        sendGratiffiMsg: function () {
                            var t = this
                            console.info(
                                '对象函数 sendGratiffiMsg,filePath:renderer/components/Classroom/CommonInteractions/graffiti/components/graffitiNew.vue'
                            )
                            var e = Object(x.a)(this.gratiffiMsgArray)
                            this.gratiffiMsgArray = []
                            e.forEach(function (e) {
                                t.thinkClass.SignalService.sendRoomBinMessage(
                                    [t.roomInfo.commonOption.roomlist[0]],
                                    ''
                                        .concat(t.options.ircMsg.dbkey, '#')
                                        .concat(t.roomInfo.stuInfo.id),
                                    e.keyMsgId,
                                    e.content
                                )
                                t.sendLogger(
                                    '发送涂鸦画板保存的涂鸦消息:'
                                        .concat(e.dbKey, ' ')
                                        .concat(e.keyMsgId)
                                )
                            })
                        },
                        getCurrentCanvasSize: function () {
                            console.info(
                                '对象函数 getCurrentCanvasSize,filePath:renderer/components/Classroom/CommonInteractions/graffiti/components/graffitiNew.vue'
                            )
                            var t = document.querySelector('#graffitiContainer')
                            this.containerWidth = t.clientWidth
                            this.containerHeight = t.clientHeight
                        },
                        renderCountDown: function () {
                            console.info(
                                '对象函数 renderCountDown,filePath:renderer/components/Classroom/CommonInteractions/graffiti/components/graffitiNew.vue'
                            )
                            this.countDownTimeCopy = this.countDownTime
                            this.countDown()
                            this.timer = setInterval(this.countDown, 1000)
                        },
                        graffitiDraw: function (t, e) {
                            if (
                                (console.info(
                                    '对象函数 graffitiDraw(abstractColor, specificColor)',
                                    t,
                                    e,
                                    'filePath:renderer/components/Classroom/CommonInteractions/graffiti/components/graffitiNew.vue'
                                ),
                                    this.$refs.WhiteBoardNew)
                            ) {
                                var n = {
                                    color: e,
                                    thickness: this.currentThickness,
                                    lineDashed: this.currentLineDashed,
                                }
                                this.$refs.WhiteBoardNew.setPenStyle(n)
                                this.$refs.WhiteBoardNew.handlePen()
                                this.sendLogger('选择了涂鸦画笔, '.concat(JSON.stringify(n)))
                            } else {
                                this.sendLogger(
                                    '选择了涂鸦画笔, 但是未获得涂鸦工具WhiteBoardNew'
                                )
                            }
                        },
                        graffitiEraser: function () {
                            console.info(
                                '对象函数 graffitiEraser,filePath:renderer/components/Classroom/CommonInteractions/graffiti/components/graffitiNew.vue'
                            )
                            this.$refs.WhiteBoardNew.setEraserStyle(this.eraserSize)
                            this.$refs.WhiteBoardNew.handleEraser()
                            this.sendLogger(
                                '选择了涂鸦橡皮擦, '.concat(
                                    JSON.stringify({ eraserSize: this.eraserSize })
                                )
                            )
                        },
                        setGraffitiScale: S()(function () {
                            this.getCurrentCanvasSize()
                            this.$refs.WhiteBoardNew &&
                                this.$refs.WhiteBoardNew.handleResizeCanvas(
                                    this.containerWidth,
                                    this.containerHeight,
                                    true
                                )
                        }, 300),
                        confirm: function () {
                            var t = this
                            return Object(d.a)(
                                Object(u.a)().mark(function e() {
                                    var n
                                    return Object(u.a)().wrap(function (e) {
                                        while (1) {
                                            switch ((e.prev = e.next)) {
                                                case 0:
                                                    console.info(
                                                        '对象函数 confirm,filePath:renderer/components/Classroom/CommonInteractions/graffiti/components/graffitiNew.vue'
                                                    ),
                                                        F.j(
                                                            null === (n = t.options) || void 0 === n
                                                                ? void 0
                                                                : n.ircMsg
                                                        ),
                                                        t.sendLogger('涂鸦画板学生点击提交'),
                                                        t.$emit('submit')
                                                case 4:
                                                case 'end':
                                                    return e.stop()
                                            }
                                        }
                                    }, e)
                                })
                            )()
                        },
                        countDown: function () {
                            if (this.countDownTimeCopy >= 0) {
                                var t = Math.floor(this.countDownTimeCopy / 60),
                                    e = Math.floor(this.countDownTimeCopy % 60)
                                this.countDownTimeCopy = this.countDownTimeCopy - 1
                                this.minutes = t.toString().padStart(2, '0')
                                this.seconds = e.toString().padStart(2, '0')
                            } else {
                                clearInterval(this.timer)
                            }
                        },
                        sendLogger: function (t, e) {
                            var n =
                                arguments.length > 2 && void 0 !== arguments[2]
                                    ? arguments[2]
                                    : 'info'
                            j.a.send({
                                tag: 'student.Interact',
                                content: Object(i.a)(
                                    {
                                        msg: t,
                                        interactType: 'Graffiti',
                                        interactId: '',
                                    },
                                    e
                                ),
                                level: n,
                            })
                        },
                        removeListenerSignalService: function () {
                            console.info(
                                '对象函数 removeListenerSignalService,filePath:renderer/components/Classroom/CommonInteractions/graffiti/components/graffitiNew.vue'
                            )
                            this.thinkClass.SignalService.off(
                                'onGetRoomHistoryBinMessageNotice',
                                this.handleOnGetRoomHistoryBinMessageNotice
                            )
                            this.thinkClass.SignalService.off(
                                'onRecvRoomDataUpdateNotice',
                                this.handleOnRecvRoomDataUpdateNotice
                            )
                            this.thinkClass.SignalService.off(
                                'onRecvRoomBinMessageNotice',
                                this.handleOnRecvRoomBinMessageNotice
                            )
                            this.thinkClass.SignalService.off(
                                'onSendRoomBinMessageResp',
                                this.handleOnSendRoomBinMessageResp
                            )
                        },
                    },
                    beforeDestroy: function () {
                        console.info(
                            '对象函数 beforeDestroy,filePath:renderer/components/Classroom/CommonInteractions/graffiti/components/graffitiNew.vue'
                        )
                        K.a.dispatch('smallClass/updateGraffitiBoardWatchingStutus', {})
                        this.removeListenerSignalService()
                        this.$refs.WhiteBoardNew.uninit()
                        window.removeEventListener('resize', this.setGraffitiScale)
                        this.timer && clearInterval(this.timer)
                    },
                },
                V = J,
                z = (n('d47f'), Object(k.a)(V, E, $, false, null, '643b85aa', null)),
                Z = z.exports,
                Y = n('1a37'),
                X = function () {
                    var t = this,
                        e = t._self._c
                    return t.visible
                        ? e('div', { staticClass: 'progressContainer' }, [
                            e(
                                'div',
                                {
                                    staticClass: 'progress',
                                    class:
                                        2 == t.classType
                                            ? 'progress-small-class'
                                            : 'progress-normal-class',
                                },
                                [
                                    e('div', { staticClass: 'progress-text' }, [
                                        t._v(
                                            t._s(t.$t('common.uploading')) +
                                            '\u2026 ' +
                                            t._s(t.percent) +
                                            '%'
                                        ),
                                    ]),
                                    e('a-progress', {
                                        attrs: {
                                            percent: t.percent,
                                            'stroke-color': {
                                                '0%': 'rgba(255,213,24,1)',
                                                '100%': 'rgba(255,170,10,1)',
                                            },
                                            strokeWidth: 4,
                                            showInfo: false,
                                        },
                                    }),
                                ],
                                1
                            ),
                        ])
                        : t._e()
                },
                tt = [],
                et = {
                    name: 'photoWallProgress',
                    props: {
                        visible: {
                            type: Boolean,
                            default: true,
                        },
                        percent: {
                            type: Number,
                            default: 0,
                        },
                        classType: {
                            type: Number,
                            default: 0,
                        },
                    },
                    methods: {},
                },
                nt = et,
                it = (n('eb0e'), Object(k.a)(nt, X, tt, false, null, 'f621ddb4', null)),
                ot = it.exports,
                st = {
                    name: 'Graffiti',
                    props: {
                        options: {
                            type: Object,
                            default: function () { },
                        },
                    },
                    components: {
                        GraffitiView: R,
                        GraffitiViewNew: Z,
                        UploadProgress: ot,
                    },
                    data: function () {
                        return {
                            graffitiOptions: null,
                            showUploadProgress: false,
                            closeInteractive: false,
                            countDownTime: 0,
                            classType: 0,
                            isSubmit: false,
                            isNewGraffiti: '',
                            GraffitIsSubmit: false,
                        }
                    },
                    created: function () {
                        this.graffitiOptions = new A(Object(i.a)({}, this.options))
                        this.countDownTime =
                            parseFloat(this.graffitiOptions.initCountdownTime() / 1000) || 0
                        this.sendLogger(
                            '涂鸦画板互动开始倒计时, '.concat(this.countDownTime, 's')
                        )
                        this.classType =
                            this.options.roomMessage.roomInfo.commonOption.classType
                    },
                    mounted: function () {
                        var t = this
                        this.userTrackLogger('涂鸦画板启动')
                        this.$nextTick(
                            Object(d.a)(
                                Object(u.a)().mark(function e() {
                                    return Object(u.a)().wrap(function (e) {
                                        while (1) {
                                            switch ((e.prev = e.next)) {
                                                case 0:
                                                    ; (t.isNewGraffiti = t.options.ircMsg.dbkey),
                                                        t.sendLogger(
                                                            '收到涂鸦画板互动, 信令内容为: '.concat(
                                                                JSON.stringify(t.options.ircMsg)
                                                            ),
                                                            'start'
                                                        ),
                                                        t.$bus.$emit(
                                                            'photoWallInteractId',
                                                            t.options.ircMsg.interactId
                                                        ),
                                                        localStorage.setItem(
                                                            'photoWallOptions',
                                                            JSON.stringify(t.options)
                                                        ),
                                                        t.getWallStatus(),
                                                        t.graffitiOptions.interactOpen()
                                                case 6:
                                                case 'end':
                                                    return e.stop()
                                            }
                                        }
                                    }, e)
                                })
                            )
                        )
                    },
                    computed: {},
                    methods: {
                        getPhotoData: function (t) {
                            this.photoData = t
                        },
                        submitPhoto: function (t) {
                            var e = this
                            return Object(d.a)(
                                Object(u.a)().mark(function n() {
                                    var i, o, s, r, a, c
                                    return Object(u.a)().wrap(function (n) {
                                        while (1) {
                                            switch ((n.prev = n.next)) {
                                                case 0:
                                                    if (
                                                        (console.info(
                                                            '对象函数 submitPhoto(blob)',
                                                            t,
                                                            'filePath:renderer/components/Classroom/CommonInteractions/graffiti/app.vue'
                                                        ),
                                                            !e.submiting)
                                                    ) {
                                                        n.next = 4
                                                        break
                                                    }
                                                    return (
                                                        console.info(
                                                            'if(_this2.submiting)为true触发return,path: /renderer/components/Classroom/CommonInteractions/graffiti/app.vue'
                                                        ),
                                                        n.abrupt('return')
                                                    )
                                                case 4:
                                                    return (
                                                        (e.dialogVisible = e.showPhotoShotTip = false),
                                                        (e.submiting = e.showUploadProgress = true),
                                                        (i = new Y.b({ scene: 'pictureWall' })),
                                                        (n.next = 9),
                                                        i.putFile({
                                                            filePath: 'pictureWall.jpg',
                                                            file: t || e.photoData.blob,
                                                            progress: function (t) {
                                                                e.percent = t
                                                            },
                                                            success: function (t) {
                                                                e.sendLogger(
                                                                    '上传照片成功, url: '.concat(t.url)
                                                                )
                                                            },
                                                            fail: function () {
                                                                e.showUploadProgress = false
                                                                e.submiting = false
                                                                e.percent = 0
                                                                e.graffitiOptions.showSubmitTip({
                                                                    text: e.$t('common.uploadFailed'),
                                                                    icon: 'error',
                                                                    callback: function () { },
                                                                })
                                                                e.sendLogger('上传照片失败')
                                                            },
                                                        })
                                                    )
                                                case 9:
                                                    if (((o = n.sent), (s = o.key), !s)) {
                                                        n.next = 36
                                                        break
                                                    }
                                                    return (
                                                        (e.showUploadProgress = false),
                                                        (n.next = 16),
                                                        e.graffitiOptions.submitPhoto(s, e.isNewGraffiti)
                                                    )
                                                case 16:
                                                    if (((r = n.sent), 0 !== r.code)) {
                                                        n.next = 28
                                                        break
                                                    }
                                                    if (
                                                        ((e.GraffitIsSubmit = true),
                                                            e.isNewGraffiti && (e.isSubmit = true),
                                                            null !== r &&
                                                            void 0 !== r &&
                                                            null !== (a = r.data) &&
                                                            void 0 !== a &&
                                                            a.rightCoin &&
                                                            !e.isNewGraffiti)
                                                    ) {
                                                        n.next = 23
                                                        break
                                                    }
                                                    return (
                                                        console.info(
                                                            'if(!submitRes?.data?.rightCoin || _this2.isNewGraffiti)为true触发return,path: /renderer/components/Classroom/CommonInteractions/graffiti/app.vue'
                                                        ),
                                                        n.abrupt('return')
                                                    )
                                                case 23:
                                                    ; (c = r.data.rightCoin),
                                                        e.graffitiOptions.showCoinsTip({
                                                            coins: c,
                                                            tips: e.$t('common.sumbittedSuccessfully'),
                                                            callback: function () {
                                                                e.isSubmit = true
                                                            },
                                                        }),
                                                        e.sendLogger(
                                                            '获得金币成功, '.concat(JSON.stringify(r))
                                                        ),
                                                        (n.next = 36)
                                                    break
                                                case 28:
                                                    if (
                                                        ((e.submiting = false),
                                                            (e.isSubmit = true),
                                                            (e.percent = 0),
                                                            !e.isNewGraffiti)
                                                    ) {
                                                        n.next = 34
                                                        break
                                                    }
                                                    return (
                                                        console.info(
                                                            'if(_this2.isNewGraffiti)为true触发return,path: /renderer/components/Classroom/CommonInteractions/graffiti/app.vue'
                                                        ),
                                                        n.abrupt('return')
                                                    )
                                                case 34:
                                                    e.graffitiOptions.showSubmitTip({
                                                        text: e.$t('common.submissionFailed'),
                                                        icon: 'error',
                                                        callback: function () { },
                                                    }),
                                                        e.sendLogger(
                                                            '获得金币失败, '.concat(JSON.stringify(r))
                                                        )
                                                case 36:
                                                case 'end':
                                                    return n.stop()
                                            }
                                        }
                                    }, n)
                                })
                            )()
                        },
                        stopGratiffi: function () {
                            var t = this
                            return Object(d.a)(
                                Object(u.a)().mark(function e() {
                                    var n, i, o, s, r, a, c, f, l
                                    return Object(u.a)().wrap(function (e) {
                                        while (1) {
                                            switch ((e.prev = e.next)) {
                                                case 0:
                                                    console.info(
                                                        '对象函数 stopGratiffi,filePath:renderer/components/Classroom/CommonInteractions/graffiti/app.vue'
                                                    ),
                                                        t.sendLogger('老师发送停止作答'),
                                                        (n = document.querySelector('#graffitiContainer')),
                                                        (i = n.clientWidth),
                                                        (o = n.clientHeight),
                                                        (s = document.createElement('canvas')),
                                                        (s.width = i),
                                                        (s.height = o),
                                                        (r = document.querySelector('#gratiffiImg')),
                                                        (a = document.querySelector(
                                                            '#graffitiWrapper .canvas-container .canvas-shape'
                                                        )),
                                                        (c = document.querySelector(
                                                            '#graffitiWrapper .canvas-container .canvas-main'
                                                        )),
                                                        s.getContext('2d').drawImage(r, 0, 0, i, o),
                                                        s.getContext('2d').drawImage(a, 0, 0, i, o),
                                                        s.getContext('2d').drawImage(c, 0, 0, i, o),
                                                        (f = s.toDataURL()),
                                                        (l = t.base64ToBlob(f, 'image/jpeg')),
                                                        t.submitPhoto(l)
                                                case 18:
                                                case 'end':
                                                    return e.stop()
                                            }
                                        }
                                    }, e)
                                })
                            )()
                        },
                        submitNotice: function () {
                            var t = this
                            return Object(d.a)(
                                Object(u.a)().mark(function e() {
                                    var n, i, o
                                    return Object(u.a)().wrap(function (e) {
                                        while (1) {
                                            switch ((e.prev = e.next)) {
                                                case 0:
                                                    return (
                                                        console.info(
                                                            '对象函数 submitNotice,filePath:renderer/components/Classroom/CommonInteractions/graffiti/app.vue'
                                                        ),
                                                        t.sendLogger('学员提交涂鸦'),
                                                        (e.next = 5),
                                                        t.graffitiOptions.submitGratiffi()
                                                    )
                                                case 5:
                                                    if (((n = e.sent), 0 !== n.code)) {
                                                        e.next = 15
                                                        break
                                                    }
                                                    if (
                                                        ((t.GraffitIsSubmit = true),
                                                            null !== n &&
                                                            void 0 !== n &&
                                                            null !== (i = n.data) &&
                                                            void 0 !== i &&
                                                            i.rightCoin)
                                                    ) {
                                                        e.next = 11
                                                        break
                                                    }
                                                    return (
                                                        console.info(
                                                            'if(!submitRes?.data?.rightCoin)为true触发return,path: /renderer/components/Classroom/CommonInteractions/graffiti/app.vue'
                                                        ),
                                                        e.abrupt('return')
                                                    )
                                                case 11:
                                                    ; (o = n.data.rightCoin),
                                                        t.graffitiOptions.showCoinsTip({
                                                            coins: o,
                                                            tips: t.$t('common.sumbittedSuccessfully'),
                                                            callback: function () { },
                                                        }),
                                                        t.sendLogger(
                                                            '获得金币成功, '.concat(JSON.stringify(n))
                                                        ),
                                                        t.$bus.$emit('addCoin', true, o)
                                                case 15:
                                                case 'end':
                                                    return e.stop()
                                            }
                                        }
                                    }, e)
                                })
                            )()
                        },
                        base64ToBlob: function (t, e) {
                            for (
                                var n = window.atob(t.split(',')[1]),
                                i = new ArrayBuffer(n.length),
                                o = new Uint8Array(i),
                                s = 0;
                                s < n.length;
                                s++
                            ) {
                                o[s] = n.charCodeAt(s)
                            }
                            return new Blob([i], { type: e })
                        },
                        sendLogger: function (t) {
                            var e =
                                arguments.length > 1 && void 0 !== arguments[1]
                                    ? arguments[1]
                                    : ''
                            j.a.send({
                                tag: 'student.Interact',
                                content: {
                                    msg: t,
                                    interactType: 'Photopost',
                                    interactId: '',
                                    interactStage: e,
                                },
                            })
                        },
                        userTrackLogger: function (t) {
                            j.a.send({
                                tag: 'userTrack',
                                content: {
                                    msg: t,
                                    tag: 'student.Interact',
                                    interactType: 'Photopost',
                                },
                            })
                        },
                        getWallStatus: function () {
                            var t = this
                            return Object(d.a)(
                                Object(u.a)().mark(function e() {
                                    var n, i, o
                                    return Object(u.a)().wrap(
                                        function (e) {
                                            while (1) {
                                                switch ((e.prev = e.next)) {
                                                    case 0:
                                                        return (
                                                            console.info(
                                                                '对象函数 getWallStatus,filePath:renderer/components/Classroom/CommonInteractions/graffiti/app.vue'
                                                            ),
                                                            (e.prev = 1),
                                                            (e.next = 4),
                                                            t.graffitiOptions.getWallStatus()
                                                        )
                                                    case 4:
                                                        ; (n = e.sent),
                                                            (i = n.code),
                                                            (o = n.data),
                                                            0 === i && (t.isSubmit = o.isSubmit),
                                                            (e.next = 13)
                                                        break
                                                    case 10:
                                                        ; (e.prev = 10),
                                                            (e.t0 = e.catch(1)),
                                                            console.error('异常恢复error', e.t0)
                                                    case 13:
                                                    case 'end':
                                                        return e.stop()
                                                }
                                            }
                                        },
                                        e,
                                        null,
                                        [[1, 10]]
                                    )
                                })
                            )()
                        },
                        destroyInteraction: function () {
                            var t = this
                            return Object(d.a)(
                                Object(u.a)().mark(function e() {
                                    return Object(u.a)().wrap(function (e) {
                                        while (1) {
                                            switch ((e.prev = e.next)) {
                                                case 0:
                                                    console.info(
                                                        '对象函数 destroyInteraction,filePath:renderer/components/Classroom/CommonInteractions/graffiti/app.vue'
                                                    ),
                                                        (t.closeInteractive = true),
                                                        t.photoData ||
                                                        t.isSubmit ||
                                                        t.submiting ||
                                                        t.graffitiOptions.showNotjoinTip({
                                                            className: 'notJoin',
                                                            tips: t.$t(
                                                                'classroom.interactions.photoWall.notjoinTip'
                                                            ),
                                                            callback: function () {
                                                                t.destroy()
                                                            },
                                                        })
                                                case 3:
                                                case 'end':
                                                    return e.stop()
                                            }
                                        }
                                    }, e)
                                })
                            )()
                        },
                        destroy: function () {
                            var t, e
                            console.info(
                                '对象函数 destroy,filePath:renderer/components/Classroom/CommonInteractions/graffiti/app.vue'
                            )
                            this.$destroy()
                            null === (t = this.$el) ||
                                void 0 === t ||
                                null === (e = t.parentNode) ||
                                void 0 === e ||
                                e.removeChild(this.$el)
                            this.$bus.$emit('photoWallInteractId', null)
                            this.userTrackLogger('涂鸦画板结束')
                        },
                    },
                },
                rt = st,
                at = (n('293c3'), Object(k.a)(rt, f, l, false, null, '0f934f2d', null)),
                ct = at.exports,
                ft = (function (t) {
                    Object(r.a)(n, t)
                    var e = Object(a.a)(n)
                    function n() {
                        var t,
                            i =
                                arguments.length > 0 && void 0 !== arguments[0]
                                    ? arguments[0]
                                    : {}
                        return (
                            console.info(
                                '函数申明 Graffiti(opts)',
                                i,
                                'filePath:renderer/components/Classroom/CommonInteractions/graffiti/index.js'
                            ),
                            Object(o.a)(this, n),
                            (t = e.call(this, ct)),
                            (t.options = i),
                            (t.dom = i.roomMessage.roomInfo.interactionController),
                            t.initVmApp('涂鸦画板'),
                            t
                        )
                    }
                    return (
                        Object(s.a)(n, [
                            {
                                key: 'createPropsData',
                                value: function () {
                                    var t = {}
                                    return Object(i.a)({ options: this.options }, t)
                                },
                            },
                        ]),
                        n
                    )
                })(c.a)
        },
        '99f5': function (t, e, n) {
            'use strict'
            n('0219')
        },
        '9a0c': function (t, e, n) {
            var i = n('342f')
            t.exports =
                /Version\/10(?:\.\d+){1,2}(?: [\w./]+)?(?: Mobile\/\w+)? Safari\//.test(
                    i
                )
        },
        a7b6: function (t, e, n) { },
        aec3: function (t, e, n) { },
        b6c9: function (t, e, n) {
            'use strict'
            n.d(e, 'a', function () {
                return f
            })
            var i = n('d4ec'),
                o = n('bee2'),
                s = (n('99af'), n('d9e2'), n('8bbf')),
                r = n.n(s),
                a = n('3898'),
                c = n('d0db'),
                f = (function () {
                    function t(e) {
                        console.info(
                            '函数申明 InteractionBase(app)',
                            e,
                            'filePath:renderer/components/Classroom/CommonInteractions/interaction-base.js'
                        )
                        Object(i.a)(this, t)
                        this.app = e
                        this.vm = null
                        this.keepOtherDom = false
                    }
                    return (
                        Object(o.a)(t, [
                            {
                                key: 'initVmApp',
                                value: function (t) {
                                    if (!this.dom) {
                                        throw Error('互动的dom容器不存在')
                                    }
                                    this.dom.children.length > 0 &&
                                        !this.keepOtherDom &&
                                        (c.a.send({
                                            tag: 'tempInteractionTest',
                                            content: {
                                                msg: '清空互动容器\uFF0C由'
                                                    .concat(t, '触发清空\uFF0C清空')
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
                                value: function (t) {
                                    var e = r.a.extend(t),
                                        n = this.createPropsData(),
                                        i = new e({
                                            i18n: a.b,
                                            propsData: n,
                                            store: this.store || {},
                                        })
                                    return i.$mount(), i
                                },
                            },
                            {
                                key: 'render',
                                value: function (t, e) {
                                    t.appendChild(e.$el)
                                },
                            },
                            {
                                key: 'destroy',
                                value: function () {
                                    var t =
                                        arguments.length > 0 && void 0 !== arguments[0]
                                            ? arguments[0]
                                            : {},
                                        e = t.submit
                                    this.vm
                                        ? (e && this.vm.submit(),
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
                                value: function (t, e) {
                                    return t[''.concat(e)].properties
                                },
                            },
                            {
                                key: 'handleMsg',
                                value: function () { },
                            },
                        ]),
                        t
                    )
                })()
        },
        d47f: function (t, e, n) {
            'use strict'
            n('aec3')
        },
        e996: function (t, e, n) { },
        eb0e: function (t, e, n) {
            'use strict'
            n('e996')
        },
    },
])
