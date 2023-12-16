; (window.webpackJsonp = window.webpackJsonp || []).push([
    ['chunk-7977b3b6'],
    {
        '0570': function (e, t, n) {
            'use strict'
            n('b821')
        },
        1276: function (e, t, n) {
            'use strict'
            var o = n('2ba4'),
                r = n('c65b'),
                s = n('e330'),
                i = n('d784'),
                c = n('825a'),
                a = n('7234'),
                u = n('44e7'),
                l = n('1d80'),
                d = n('4840'),
                h = n('8aa5'),
                m = n('50c4'),
                p = n('577e'),
                f = n('dc4a'),
                v = n('4dae'),
                k = n('14c3'),
                g = n('9263'),
                b = n('9f7f'),
                _ = n('d039'),
                S = b.UNSUPPORTED_Y,
                y = Math.min,
                w = [].push,
                E = s(/./.exec),
                P = s(w),
                x = s(''.slice),
                I = !_(function () {
                    var t = /(?:)/.exec
                        ; /(?:)/.exec = function () {
                            return t.apply(this, arguments)
                        }
                    var n = 'ab'.split(/(?:)/)
                    return 2 !== n.length || 'a' !== n[0] || 'b' !== n[1]
                })
            i(
                'split',
                function (e, t, n) {
                    var s
                    return (
                        (s =
                            'c' == 'abbc'.split(/(b)*/)[1] ||
                                4 != 'test'.split(/(?:)/, -1).length ||
                                2 != 'ab'.split(/(?:ab)*/).length ||
                                4 != '.'.split(/(.?)(.?)/).length ||
                                '.'.split(/()()/).length > 1 ||
                                ''.split(/.?/).length
                                ? function (e, n) {
                                    var s = p(l(this)),
                                        i = void 0 === n ? 4294967295 : n >>> 0
                                    if (0 === i) {
                                        return []
                                    }
                                    if (void 0 === e) {
                                        return [s]
                                    }
                                    if (!u(e)) {
                                        return r(t, s, e, i)
                                    }
                                    var c,
                                        a,
                                        d,
                                        h = [],
                                        m =
                                            (e.ignoreCase ? 'i' : '') +
                                            (e.multiline ? 'm' : '') +
                                            (e.unicode ? 'u' : '') +
                                            (e.sticky ? 'y' : ''),
                                        f = 0,
                                        k = new RegExp(e.source, m + 'g')
                                    while ((c = r(g, k, s))) {
                                        if (
                                            ((a = k.lastIndex),
                                                a > f &&
                                                (P(h, x(s, f, c.index)),
                                                    c.length > 1 &&
                                                    c.index < s.length &&
                                                    o(w, h, v(c, 1)),
                                                    (d = c[0].length),
                                                    (f = a),
                                                    h.length >= i))
                                        ) {
                                            break
                                        }
                                        k.lastIndex === c.index && k.lastIndex++
                                    }
                                    return (
                                        f === s.length
                                            ? (!d && E(k, '')) || P(h, '')
                                            : P(h, x(s, f)),
                                        h.length > i ? v(h, 0, i) : h
                                    )
                                }
                                : '0'.split(void 0, 0).length
                                    ? function (e, n) {
                                        return void 0 === e && 0 === n ? [] : r(t, this, e, n)
                                    }
                                    : t),
                        [
                            function (t, n) {
                                var o = l(this),
                                    i = a(t) ? void 0 : f(t, e)
                                return i ? r(i, t, o, n) : r(s, p(o), t, n)
                            },
                            function (e, o) {
                                var r = c(this),
                                    i = p(e),
                                    a = n(s, r, i, o, s !== t)
                                if (a.done) {
                                    return a.value
                                }
                                var u = d(r, RegExp),
                                    l = r.unicode,
                                    f =
                                        (r.ignoreCase ? 'i' : '') +
                                        (r.multiline ? 'm' : '') +
                                        (r.unicode ? 'u' : '') +
                                        (S ? 'g' : 'y'),
                                    v = new u(S ? '^(?:' + r.source + ')' : r, f),
                                    g = void 0 === o ? 4294967295 : o >>> 0
                                if (0 === g) {
                                    return []
                                }
                                if (0 === i.length) {
                                    return null === k(v, i) ? [i] : []
                                }
                                var b = 0,
                                    _ = 0,
                                    w = []
                                while (_ < i.length) {
                                    v.lastIndex = S ? 0 : _
                                    var E,
                                        I = k(v, S ? x(i, _) : i)
                                    if (
                                        null === I ||
                                        (E = y(m(v.lastIndex + (S ? _ : 0)), i.length)) === b
                                    ) {
                                        _ = h(i, _, l)
                                    } else {
                                        if ((P(w, x(i, b, _)), w.length === g)) {
                                            return w
                                        }
                                        for (var D = 1; D <= I.length - 1; D++) {
                                            if ((P(w, I[D]), w.length === g)) {
                                                return w
                                            }
                                        }
                                        _ = b = E
                                    }
                                }
                                return P(w, x(i, b)), w
                            },
                        ]
                    )
                },
                !I,
                S
            )
        },
        '182b': function (e, t, n) {
            'use strict'
            const o = (async () => { })().constructor.prototype,
                r = ['then', 'catch', 'finally'].map((e) => [
                    e,
                    Reflect.getOwnPropertyDescriptor(o, e),
                ]),
                s = (e, t) => {
                    for (const [n, o] of r) {
                        const r =
                            'function' === typeof t
                                ? (...e) => Reflect.apply(o.value, t(), e)
                                : o.value.bind(t)
                        Reflect.defineProperty(e, n, {
                            ...o,
                            value: r,
                        })
                    }
                    return e
                },
                i = (e) =>
                    new Promise((t, n) => {
                        e.on('exit', (e, n) => {
                            t({
                                exitCode: e,
                                signal: n,
                            })
                        })
                        e.on('error', (e) => {
                            n(e)
                        })
                        e.stdin &&
                            e.stdin.on('error', (e) => {
                                n(e)
                            })
                    })
            e.exports = {
                mergePromise: s,
                getSpawnedPromise: i,
            }
        },
        '21dc': function (e, t, n) {
            const o = n('8e57')
            let r = null
            switch (o.type()) {
                case 'Darwin':
                    r = n('2847')
                    break
                case 'Linux':
                    r = n('e10d')
                    break
                case 'Windows_NT':
                    r = n('c04b')
                    break
                default:
                    throw new Error(
                        'Your OS is currently not supported by node-loudness.'
                    )
            }
            e.exports = {
                setVolume(e) {
                    return r.setVolume(e)
                },
                getVolume() {
                    return r.getVolume()
                },
                setMuted(e) {
                    return r.setMuted(e)
                },
                getMuted() {
                    return r.getMuted()
                },
            }
        },
        '225c': function (e, t, n) {
            'use strict'
            e.exports = /^#!(.*)/
        },
        2678: function (e, t, n) {
            'use strict'
            Object.defineProperty(t, '__esModule', { value: true })
            t.getSignals = void 0
            var o = n('8e57'),
                r = n('c023'),
                s = n('3ba6')
            const i = function () {
                const e = (0, s.getRealtimeSignals)(),
                    t = [...r.SIGNALS, ...e].map(c)
                return t
            }
            t.getSignals = i
            const c = function ({
                name: e,
                number: t,
                description: n,
                action: r,
                forced: s = false,
                standard: i,
            }) {
                const {
                    signals: { [e]: c },
                } = o.constants,
                    a = void 0 !== c,
                    u = a ? c : t
                return {
                    name: e,
                    number: u,
                    description: n,
                    supported: a,
                    action: r,
                    forced: s,
                    standard: i,
                }
            }
        },
        '270c': function (e, t, n) {
            'use strict'
            n.d(t, 'a', function () {
                return b
            })
            var o = n('d4ec'),
                r = n('bee2'),
                s = n('c7eb'),
                i = n('1da1'),
                c = n('5530'),
                a = n('262e'),
                u = n('2caf'),
                l =
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
                h = n('5e36'),
                m = n('612a'),
                p = n('d0db'),
                f = n('8c9b'),
                v = n('e417'),
                k = (function (e) {
                    Object(a.a)(n, e)
                    var t = Object(u.a)(n)
                    function n() {
                        var e,
                            r =
                                arguments.length > 0 && void 0 !== arguments[0]
                                    ? arguments[0]
                                    : {}
                        Object(o.a)(this, n)
                        e = t.call(this)
                        var s = r.planId,
                            i = r.businessId,
                            c = r.userId,
                            a = r.isAudition,
                            u = r.ircOptions
                        e.ircHaveStartSensor = false
                        e.timeOut = 5
                        e.ircTimer = null
                        e.planId = s
                        e.businessId = i
                        e.userId = c
                        e.isAudition = a
                        e.ircOptions = u || {}
                        e.liveInfo = {}
                        e.inRoom = false
                        e.chatInstance = null
                        try {
                            e.triggerTimeMap = localStorage.getItem('triggerTimeMap')
                                ? JSON.parse(localStorage.getItem('triggerTimeMap'))
                                : {}
                        } catch (l) {
                            console.error('triggerTimeMap报错', l)
                            e.triggerTimeMap = {}
                        }
                        return e._initChat(), e._listener(), e
                    }
                    return (
                        Object(r.a)(n, [
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
                                        o = e.nickname,
                                        r = e.location
                                    this.liveInfo = {
                                        nickname: o,
                                        businessId: this.businessId,
                                        classId: '0',
                                        liveId: String(this.planId),
                                        location: r || 'China',
                                    }
                                    var s = window.TalMsgClient,
                                        i = new s(t, 'v3.2.1')
                                    window.ChatClient = this.chatInstance = i.getInstance(1)
                                    var c = this.chatInstance.init(t, n)
                                    return (
                                        this.sendLogger(
                                            'irc 调用初始化方法,code: '
                                                .concat(c, ',appId:')
                                                .concat(t, ',appKey:')
                                                .concat(n),
                                            {},
                                            0 == c ? 'info' : 'error'
                                        ),
                                        Object(v.c)({
                                            result: 'start',
                                            liveInfo: this.liveInfo,
                                        }),
                                        (this.ircHaveStartSensor = true),
                                        c
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
                                        o = {
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
                                        r = this.chatInstance.setSdkProperties(o)
                                    return (
                                        this.sendLogger(
                                            'irc 设置sdk配置信息,code:'.concat(JSON.stringify(r)),
                                            o,
                                            0 == r ? 'info' : 'error'
                                        ),
                                        r
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
                                                liveInfo: Object(c.a)(
                                                    Object(c.a)({}, this.liveInfo),
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
                                        ? (this.beginTimer(),
                                            this.sendLogger('irc调用登陆方法成功'))
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
                                        Object(s.a)().mark(function e() {
                                            return Object(s.a)().wrap(
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
                                                m.a.dispatch('smallClass/updateIrcStatus', true),
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
                                        e.sendLogger(
                                            'irc 频道内人员退出:'.concat(JSON.stringify(t))
                                        )
                                        var n = t.code
                                        n == 0 && e.emit('logoutSuccess')
                                    })
                                    this.chatInstance.on(
                                        'onNetStatusChanged',
                                        (function () {
                                            var t = Object(i.a)(
                                                Object(s.a)().mark(function t(n) {
                                                    var o, r
                                                    return Object(s.a)().wrap(function (t) {
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
                                                                            (o = {
                                                                                0: '未知',
                                                                                1: '网络不可用',
                                                                                2: '服务器连接失败',
                                                                                3: '服务器连接中',
                                                                                5: '服务器断开连接',
                                                                            }),
                                                                            e.sendLogger(
                                                                                'irc 网络状态改变,'.concat(
                                                                                    o[n.netStatus]
                                                                                ),
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
                                                                    return (t.next = 8), Object(f.a)()
                                                                case 8:
                                                                    ; (r = t.sent),
                                                                        Object(v.c)({
                                                                            result: 'fail',
                                                                            errorType: '连接失败',
                                                                            code: n.netStatus,
                                                                            msg: ''.concat(r ? '有网络' : '没有网络'),
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
                                        m.a.dispatch('smallClass/updateIrcStatus', false)
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
                                            o = t.handler,
                                            r = !o.psId && !o.nickname
                                        n.forEach(function (t, n) {
                                            if (e.isAudition && h.a.includes(n)) {
                                                e.sendLogger('旁听课不参与互动', { key: n })
                                            } else {
                                                var o = JSON.parse(t.value),
                                                    s = o.sendTime
                                                o[n]
                                                var i = e.isTriggerFun(n, o),
                                                    c = 'boolean' == typeof o[n] ? o[n] : o[n] || o.data,
                                                    a = '收到KV消息('
                                                        .concat(r ? '历史' : '实时', ')(')
                                                        .concat(i ? '旧互动' : '新互动', ') => ')
                                                        .concat(n)
                                                e.sendLogger(a, c)
                                                    ; (('small_random_call' != n && 'speedyHand' != n) ||
                                                        !i) &&
                                                        e.emit('onRecvRoomDataUpdateNotice', {
                                                            key: n,
                                                            isHistory: r,
                                                            noticeContent: c,
                                                            sendTime: s,
                                                        })
                                            }
                                        })
                                    })
                                    t.on('onGetRoomDataResponse', function (t) {
                                        e.emit('onGetRoomDataResponse', t)
                                    })
                                    t.on('onRecvRoomMessage', function (t) {
                                        var n = t.content,
                                            o = t.fromUserInfo,
                                            r = t.messagePriority,
                                            s = t.msgId,
                                            i = t.timestamp
                                        e.emit('onRecvRoomMessage', {
                                            content: JSON.parse(n),
                                            fromUserInfo: o,
                                            messagePriority: r,
                                            msgId: s,
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
                                            o = t.fromUserInfo,
                                            r = t.messagePriority,
                                            s = t.msgId,
                                            i = t.timestamp
                                        e.emit('onRecvPeerMessage', {
                                            content: JSON.parse(n),
                                            fromUserInfo: o,
                                            messagePriority: r,
                                            msgId: s,
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
                                        o = e.key,
                                        r = o.split('_').splice(1).join('_')
                                    this.chatInstance.RoomChatManager.getRoomHistoryBinMessage(
                                        n,
                                        r,
                                        '0',
                                        true
                                    )
                                    var s = m.a.state.smallClass.isAuthorizedUserList,
                                        i = s.find(function (e) {
                                            return e.pageKey === r
                                        })
                                    i &&
                                        i.userIdList &&
                                        i.userIdList.forEach(function (e) {
                                            var o = ''.concat(e, '_').concat(r)
                                            t.chatInstance.RoomChatManager.getRoomHistoryBinMessage(
                                                n,
                                                o,
                                                '0',
                                                true
                                            )
                                        })
                                    this.sendLogger(
                                        'irc',
                                        '拉取老师和学员历史数据 teachdbkey: '
                                            .concat(r, ', curPageKeyUserList: ')
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
                                        o = e.chatMsgPriority,
                                        r = void 0 === o ? 1 : o
                                    return this.chatInstance.PeerChatManager.sendPeerMessage(
                                        [{ nickname: n }],
                                        JSON.stringify(t),
                                        r
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
                                        o = e.chatMsgPriority,
                                        r = void 0 === o ? 99 : o
                                    return this.chatInstance.RoomChatManager.sendRoomMessage(
                                        n || this.ircOptions.ircRooms,
                                        JSON.stringify(t),
                                        r
                                    )
                                },
                            },
                            {
                                key: 'sendRoomBinMessage',
                                value: function (e, t, n, o) {
                                    return this.chatInstance.RoomChatManager.sendRoomBinMessage(
                                        e,
                                        t,
                                        n,
                                        o
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
                                        o = e.chatMsgPriority,
                                        r = void 0 === o ? 99 : o
                                    return this.chatInstance.RoomChatManager.sendRoomMessageWithPreMsgId(
                                        n || this.ircOptions.ircRooms,
                                        JSON.stringify(t),
                                        r
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
                                    m.a.dispatch('smallClass/updateIrcStatus', false)
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
                                        o = this.triggerTimeMap[n]
                                    if (!o) {
                                        var r = localStorage.getItem('triggerTimeMap')
                                        o = r && JSON.parse(r)[n] ? JSON.parse(r)[n] : 0
                                    }
                                    var s = t.sendTime ? t.sendTime : 0,
                                        i = false
                                    return (
                                        Number(s) > Number(o)
                                            ? ((this.triggerTimeMap[n] = s),
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
                                    p.a.send({
                                        tag: p.b.irc,
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
                })(l.a),
                g = n('d15d'),
                b = (function () {
                    function e() {
                        var t =
                            arguments.length > 0 && void 0 !== arguments[0]
                                ? arguments[0]
                                : {}
                        Object(o.a)(this, e)
                        var n = t.planId,
                            r = t.businessId,
                            s = t.userId,
                            i = t.ircOptions,
                            c = t.rtcConfig,
                            a = t.isAudition
                        this.planId = n
                        this.businessId = r
                        this.userId = s
                        this.ircOptions = i
                        this.rtcConfig = c
                        this.isAudition = a
                        this._initSignalService()
                        this._initRtcService()
                    }
                    return (
                        Object(r.a)(e, [
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
                                    this.SignalService = new k({
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
                                    this.RtcService = new g.a({
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
        2847: function (e, t, n) {
            const o = n('6e2d')
            async function r(e) {
                return (await o('osascript', ['-e', e])).stdout
            }
            t.getVolume = async function () {
                return parseInt(await r('output volume of (get volume settings)'), 10)
            }
            t.setVolume = async function (e) {
                await r('set volume output volume ' + e)
            }
            t.getMuted = async function () {
                return 'true' === (await r('output muted of (get volume settings)'))
            }
            t.setMuted = async function (e) {
                await r('set volume ' + (e ? 'with' : 'without') + ' output muted')
            }
        },
        '2d0d': function (e, t, n) {
            n('f8c9')
            n('4ae1')
            n('d3b7')
            var o = n('36c6'),
                r = n('6f8f'),
                s = n('6b58')
            function i(e) {
                var t = r()
                return function () {
                    var n,
                        r = o(e)
                    if (t) {
                        var i = o(this).constructor
                        n = Reflect.construct(r, arguments, i)
                    } else {
                        n = r.apply(this, arguments)
                    }
                    return s(this, n)
                }
            }
            e.exports = i
            e.exports.__esModule = true
            e.exports.default = e.exports
        },
        3164: function (e, t, n) {
            'use strict'
            n('8f6e')
        },
        '365d8': function (e, t, n) { },
        '395e': function (e, t, n) {
            'use strict'
            n.r(t)
            var o = function () {
                var e = this,
                    t = e._self._c
                return t(
                    'div',
                    {
                        staticClass: 'checkdevice-wrapper',
                        attrs: { 'data-log': '硬件检查页' },
                    },
                    [
                        e.isLoading
                            ? t('Loading', { attrs: { 'margin-top': '200px' } })
                            : t('div', { staticClass: 'checkdevice-wrapper--contenter' }, [
                                t(
                                    'div',
                                    { staticClass: 'checkdevice-wrapper--contenter__steps' },
                                    [
                                        t(
                                            'a-steps',
                                            {
                                                attrs: {
                                                    current: e.currentStep,
                                                    labelPlacement: 'vertical',
                                                },
                                            },
                                            [
                                                t('a-step', {
                                                    attrs: {
                                                        title: e.$t(
                                                            'classroom.modules.checkDevice.network'
                                                        ),
                                                        status: e.networkStatus,
                                                    },
                                                    scopedSlots: e._u([
                                                        {
                                                            key: 'icon',
                                                            fn: function () {
                                                                return [
                                                                    t('i', {
                                                                        staticClass:
                                                                            'step-icon network process',
                                                                        class: e.networkStatus,
                                                                    }),
                                                                ]
                                                            },
                                                            proxy: true,
                                                        },
                                                    ]),
                                                }),
                                                t('a-step', {
                                                    attrs: {
                                                        title: e.$t(
                                                            'classroom.modules.checkDevice.microphone'
                                                        ),
                                                        status: e.microphoneStatus,
                                                    },
                                                    scopedSlots: e._u([
                                                        {
                                                            key: 'icon',
                                                            fn: function () {
                                                                return [
                                                                    t('i', {
                                                                        staticClass: 'step-icon microphone',
                                                                        class: e.microphoneStatus,
                                                                    }),
                                                                ]
                                                            },
                                                            proxy: true,
                                                        },
                                                    ]),
                                                }),
                                                t('a-step', {
                                                    class: e.cameraStatus,
                                                    attrs: {
                                                        title: e.$t(
                                                            'classroom.modules.checkDevice.camera'
                                                        ),
                                                    },
                                                    scopedSlots: e._u([
                                                        {
                                                            key: 'icon',
                                                            fn: function () {
                                                                return [
                                                                    t('i', {
                                                                        staticClass: 'step-icon camera',
                                                                        class: e.cameraStatus,
                                                                    }),
                                                                ]
                                                            },
                                                            proxy: true,
                                                        },
                                                    ]),
                                                }),
                                                t('a-step', {
                                                    class: e.speakerStatus,
                                                    attrs: {
                                                        title: e.$t(
                                                            'classroom.modules.checkDevice.voice'
                                                        ),
                                                    },
                                                    scopedSlots: e._u([
                                                        {
                                                            key: 'icon',
                                                            fn: function () {
                                                                return [
                                                                    t('i', {
                                                                        staticClass: 'step-icon speaker',
                                                                        class: e.speakerStatus,
                                                                    }),
                                                                ]
                                                            },
                                                            proxy: true,
                                                        },
                                                    ]),
                                                }),
                                            ],
                                            1
                                        ),
                                    ],
                                    1
                                ),
                                e.showResult
                                    ? e._e()
                                    : t(
                                        'div',
                                        {
                                            staticClass:
                                                'checkdevice-wrapper--contenter__content',
                                        },
                                        [
                                            0 === e.currentStep && e.serviceData
                                                ? t('NetworkCheck', {
                                                    attrs: { serviceData: e.serviceData },
                                                    on: {
                                                        nextCheck: e.nextCheck,
                                                        status: e.changeStepStatus,
                                                    },
                                                })
                                                : e._e(),
                                            1 === e.currentStep
                                                ? t('MicrophoneCheck', {
                                                    on: {
                                                        nextCheck: e.nextCheck,
                                                        status: e.changeStepStatus,
                                                    },
                                                })
                                                : e._e(),
                                            2 === e.currentStep
                                                ? t('CameraCheck', {
                                                    on: {
                                                        nextCheck: e.nextCheck,
                                                        status: e.changeStepStatus,
                                                    },
                                                })
                                                : e._e(),
                                            3 === e.currentStep
                                                ? t('SpeakerCheck', {
                                                    on: { status: e.changeStepStatus },
                                                })
                                                : e._e(),
                                        ],
                                        1
                                    ),
                                e.showResult
                                    ? t(
                                        'div',
                                        {
                                            staticClass:
                                                'checkdevice-wrapper--contenter__result',
                                        },
                                        [
                                            e.checkSuccessStatus
                                                ? [
                                                    t('i', {
                                                        staticClass:
                                                            'svg-icon svg-success green-color',
                                                    }),
                                                    t('h2', [
                                                        e._v(
                                                            e._s(
                                                                e.$t(
                                                                    'classroom.modules.checkDevice.你的设备满足上课要求'
                                                                )
                                                            )
                                                        ),
                                                    ]),
                                                ]
                                                : [
                                                    t('i', {
                                                        staticClass:
                                                            'svg-icon svg-warning red-color',
                                                    }),
                                                    t('h2', [
                                                        e._v(
                                                            e._s(
                                                                e.$t(
                                                                    'classroom.modules.checkDevice.你的设备不完全满足上课要求'
                                                                )
                                                            )
                                                        ),
                                                    ]),
                                                    t('p', [
                                                        e._v(
                                                            e._s(
                                                                e.$t(
                                                                    'classroom.modules.checkDevice.继续使用此设备上课可能会降低你的体验'
                                                                )
                                                            )
                                                        ),
                                                    ]),
                                                ],
                                            t(
                                                'a-button',
                                                {
                                                    attrs: {
                                                        type: 'default',
                                                        shape: 'round',
                                                    },
                                                    on: { click: e.goBack },
                                                },
                                                [e._v(' ' + e._s(e.$t('common.gotIt')) + ' ')]
                                            ),
                                        ],
                                        2
                                    )
                                    : e._e(),
                            ]),
                    ],
                    1
                )
            },
                r = [],
                s = n('c7eb'),
                i = n('1da1'),
                c = n('5530'),
                a = (n('14d9'), n('bd12')),
                u = function () {
                    var e = this,
                        t = e._self._c
                    return t(
                        'div',
                        { staticClass: 'service-check' },
                        [
                            t('div', { staticClass: 'check-network-loading' }, [
                                t('i', { staticClass: 'icon-local' }),
                                t(
                                    'div',
                                    { staticClass: 'check-loading' },
                                    e._l(7, function (n) {
                                        return t('span', {
                                            key: n,
                                            class: {
                                                stopAnimation: e.finishedCheck,
                                                'network-error': e.hasError,
                                            },
                                        })
                                    }),
                                    0
                                ),
                                t('i', { staticClass: 'icon-service' }),
                            ]),
                            t('ul', [
                                t('li', { class: e.rtcStatus }, [
                                    e._v(
                                        ' ' +
                                        e._s(e.$t('classroom.modules.checkDevice.音视频测试')) +
                                        ' '
                                    ),
                                    t('i', {
                                        staticClass: 'svg-icon svg-loading',
                                        class: [
                                            { 'svg-success': 'success' === e.rtcStatus },
                                            { 'svg-warning': 'error' === e.rtcStatus },
                                        ],
                                    }),
                                ]),
                                t('li', { class: e.ircStatus }, [
                                    e._v(
                                        ' ' +
                                        e._s(e.$t('classroom.modules.checkDevice.课堂互动测试')) +
                                        ' '
                                    ),
                                    t('i', {
                                        staticClass: 'svg-icon svg-loading',
                                        class: [
                                            { 'svg-success': 'success' === e.ircStatus },
                                            { 'svg-warning': 'error' === e.ircStatus },
                                        ],
                                    }),
                                ]),
                                t('li', { class: e.apiStatus }, [
                                    e._v(
                                        ' ' +
                                        e._s(e.$t('classroom.modules.checkDevice.服务器检测')) +
                                        ' '
                                    ),
                                    t('i', {
                                        staticClass: 'svg-icon svg-loading',
                                        class: [
                                            { 'svg-success': 'success' === e.apiStatus },
                                            { 'svg-warning': 'error' === e.apiStatus },
                                        ],
                                    }),
                                ]),
                                t('li', { class: e.coursewareStatus }, [
                                    e._v(
                                        ' ' +
                                        e._s(e.$t('classroom.modules.checkDevice.课件下载测试')) +
                                        ' '
                                    ),
                                    t('i', {
                                        staticClass: 'svg-icon svg-loading',
                                        class: [
                                            { 'svg-success': 'success' === e.coursewareStatus },
                                            { 'svg-warning': 'error' === e.coursewareStatus },
                                        ],
                                    }),
                                ]),
                            ]),
                            t(
                                'div',
                                { staticClass: 'checkdevice-result' },
                                [
                                    e.finishedCheck
                                        ? [
                                            e.hasError
                                                ? [
                                                    t('i', {
                                                        staticClass: 'svg-icon svg-warning red-color',
                                                    }),
                                                    t('p', [
                                                        e._v(
                                                            ' ' +
                                                            e._s(
                                                                e.$t(
                                                                    'classroom.modules.checkDevice.你的网络是乎有些问题'
                                                                )
                                                            ) +
                                                            ' '
                                                        ),
                                                        t(
                                                            'a',
                                                            {
                                                                staticStyle: { color: '#007AFF' },
                                                                on: {
                                                                    click: function (t) {
                                                                        return e.$refs.networkHelp.showHelp()
                                                                    },
                                                                },
                                                            },
                                                            [
                                                                e._v(
                                                                    ' ' +
                                                                    e._s(
                                                                        e.$t(
                                                                            'classroom.modules.checkDevice.解决方案'
                                                                        )
                                                                    ) +
                                                                    ' '
                                                                ),
                                                            ]
                                                        ),
                                                    ]),
                                                    t(
                                                        'div',
                                                        { staticClass: 'button-group' },
                                                        [
                                                            t(
                                                                'a-button',
                                                                {
                                                                    attrs: {
                                                                        type: 'default',
                                                                        shape: 'round',
                                                                    },
                                                                    on: { click: e.reStartCheckNetwork },
                                                                },
                                                                [
                                                                    e._v(
                                                                        ' ' +
                                                                        e._s(
                                                                            e.$t(
                                                                                'classroom.modules.checkDevice.重新测试'
                                                                            )
                                                                        ) +
                                                                        ' '
                                                                    ),
                                                                ]
                                                            ),
                                                            t(
                                                                'a-button',
                                                                {
                                                                    attrs: {
                                                                        type: 'default',
                                                                        shape: 'round',
                                                                    },
                                                                    on: { click: e.nextCheck },
                                                                },
                                                                [
                                                                    e._v(
                                                                        ' ' +
                                                                        e._s(
                                                                            e.$t(
                                                                                'classroom.modules.checkDevice.下一项'
                                                                            )
                                                                        ) +
                                                                        ' '
                                                                    ),
                                                                ]
                                                            ),
                                                        ],
                                                        1
                                                    ),
                                                ]
                                                : [
                                                    t('i', {
                                                        staticClass: 'svg-icon svg-success green-color',
                                                    }),
                                                    t('p', [
                                                        e._v(
                                                            e._s(
                                                                e.$t(
                                                                    'classroom.modules.checkDevice.网络满足上课需求'
                                                                )
                                                            )
                                                        ),
                                                    ]),
                                                    t(
                                                        'div',
                                                        { staticClass: 'button-group' },
                                                        [
                                                            t(
                                                                'a-button',
                                                                {
                                                                    attrs: {
                                                                        type: 'default',
                                                                        shape: 'round',
                                                                    },
                                                                    on: { click: e.nextCheck },
                                                                },
                                                                [
                                                                    e._v(
                                                                        e._s(
                                                                            e.$t(
                                                                                'classroom.modules.checkDevice.下一项'
                                                                            )
                                                                        ) +
                                                                        '(' +
                                                                        e._s(e.countDownTime) +
                                                                        's)'
                                                                    ),
                                                                ]
                                                            ),
                                                        ],
                                                        1
                                                    ),
                                                ],
                                        ]
                                        : [
                                            t('i', { staticClass: 'icon-hourglass' }),
                                            t('p', [
                                                e._v(
                                                    e._s(
                                                        e.$t(
                                                            'classroom.modules.checkDevice.此项测试大约需要花费一分钟'
                                                        )
                                                    )
                                                ),
                                            ]),
                                        ],
                                ],
                                2
                            ),
                            t('NetworkHelp', { ref: 'networkHelp' }),
                        ],
                        1
                    )
                },
                l = [],
                d = (n('99af'), n('a15b'), n('caad'), n('2532'), n('270c')),
                h = n('383d'),
                m = n('0a4b'),
                p = n('2103'),
                f = n('e39c'),
                v = function () {
                    var e = this,
                        t = e._self._c
                    return t(
                        'a-modal',
                        {
                            attrs: {
                                width: 400,
                                maskClosable: false,
                                centered: true,
                                keyboard: false,
                                footer: null,
                                closable: false,
                                dialogClass: 'modal-simple',
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
                            t('div', { staticClass: 'modal-help' }, [
                                t('div', { staticClass: 'header' }, [
                                    e._v(
                                        ' ' +
                                        e._s(
                                            e.$t('classroom.modules.checkDevice.常见网络问题建议')
                                        ) +
                                        ' '
                                    ),
                                ]),
                                t('div', { staticClass: 'content' }, [
                                    t('p', [
                                        e._v(
                                            ' ' +
                                            e._s(
                                                e.$t('classroom.modules.checkDevice.尝试重启路由器')
                                            ) +
                                            ' '
                                        ),
                                    ]),
                                    t('p', [
                                        e._v(
                                            ' ' +
                                            e._s(
                                                e.$t('classroom.modules.checkDevice.检查网络权限')
                                            ) +
                                            ' '
                                        ),
                                    ]),
                                    t('p', [
                                        e._v(
                                            ' ' +
                                            e._s(
                                                e.$t('classroom.modules.checkDevice.切换其它网络')
                                            ) +
                                            ' '
                                        ),
                                    ]),
                                ]),
                                t(
                                    'div',
                                    { staticClass: 'button-wrapper' },
                                    [
                                        t(
                                            'a-button',
                                            {
                                                attrs: {
                                                    size: 'large',
                                                    type: 'primary',
                                                    shape: 'round',
                                                    block: '',
                                                },
                                                on: { click: e.handleOk },
                                            },
                                            [e._v(' ' + e._s(e.$t('common.gotIt')) + ' ')]
                                        ),
                                    ],
                                    1
                                ),
                            ]),
                        ]
                    )
                },
                k = [],
                g = {
                    data: function () {
                        return { visible: false }
                    },
                    methods: {
                        handleOk: function () {
                            console.info(
                                '对象函数 handleOk,filePath:renderer/components/CheckDevice/networkHelp.vue'
                            )
                            this.visible = false
                        },
                        showHelp: function () {
                            console.info(
                                '对象函数 showHelp,filePath:renderer/components/CheckDevice/networkHelp.vue'
                            )
                            this.visible = true
                        },
                    },
                },
                b = g,
                _ = (n('d59e'), n('2877')),
                S = Object(_.a)(b, v, k, false, null, '0df96162', null),
                C = S.exports,
                y = {
                    name: 'NetworkCheck',
                    data: function () {
                        return {
                            networkCheckTime: 40000,
                            networkCheckTimer: null,
                            rtcStatus: '',
                            ircStatus: '',
                            apiStatus: '',
                            coursewareStatus: '',
                            thinkClass: null,
                            hasError: false,
                            ircRoom: '',
                            lastmileTestValue: 0,
                            lastmileTestNumber: 0,
                            stopAnimation: false,
                            countDownTime: 0,
                            btnTimeCount: 5,
                            btnTimer: null,
                            apiResponseTime: 3000,
                            downloadTime: 10000,
                            downloadNeedSpeed: 200,
                            roomDataResponse: 0,
                        }
                    },
                    components: { NetworkHelp: C },
                    props: {
                        serviceData: {
                            default: function () { },
                            type: Object,
                        },
                    },
                    mounted: function () {
                        this.ircRoom = this.serviceData.ircRooms[0]
                        this.initService()
                        this.startCheckNetwork()
                    },
                    computed: {
                        finishedCheck: function () {
                            return (
                                console.info(
                                    '对象函数 finishedCheck,filePath:renderer/components/CheckDevice/networkCheck.vue'
                                ),
                                this.rtcStatus &&
                                this.ircStatus &&
                                this.apiStatus &&
                                this.coursewareStatus
                            )
                        },
                    },
                    methods: {
                        checkTiming: function () {
                            var e = this
                            console.info(
                                '对象函数 checkTiming,filePath:renderer/components/CheckDevice/networkCheck.vue'
                            )
                            this.networkCheckTimer = setTimeout(function () {
                                !e.rtcStatus && (e.rtcStatus = 'error')
                                !e.ircStatus && (e.ircStatus = 'error')
                                !e.apiStatus && (e.apiStatus = 'error')
                                !e.coursewareStatus && (e.coursewareStatus = 'error')
                                e.clearNetworkCheckTimer()
                            }, this.networkCheckTime)
                        },
                        listenerOffline: function () {
                            var e = this
                            console.info(
                                '对象函数 listenerOffline,filePath:renderer/components/CheckDevice/networkCheck.vue'
                            )
                            window.addEventListener('offline', function () {
                                console.info(
                                    '箭头函数 监听 offline,filePath:renderer/components/CheckDevice/networkCheck.vue'
                                )
                                e.ircStatus =
                                    e.rtcStatus =
                                    e.apiStatus =
                                    e.coursewareStatus =
                                    'error'
                            })
                        },
                        kvMsg: function (e) {
                            console.info(
                                '对象函数 kvMsg(index)',
                                e,
                                'filePath:renderer/components/CheckDevice/networkCheck.vue'
                            )
                            var t = {
                                ircCheckKV: {
                                    value: JSON.stringify({
                                        ircCheckKV: 'device_test_'
                                            .concat(+new Date(), '_')
                                            .concat(e),
                                        sendTime: +new Date(),
                                    }),
                                },
                            }
                            return t
                        },
                        initService: function () {
                            var e = this
                            return Object(i.a)(
                                Object(s.a)().mark(function t() {
                                    var n, o, r, i
                                    return Object(s.a)().wrap(function (t) {
                                        while (1) {
                                            switch ((t.prev = t.next)) {
                                                case 0:
                                                    return (
                                                        console.info(
                                                            '对象函数 initService,filePath:renderer/components/CheckDevice/networkCheck.vue'
                                                        ),
                                                        (i = new d.a({
                                                            planId: e.serviceData.testPlanId,
                                                            businessId: '3',
                                                            userId: String(e.serviceData.studentId),
                                                            rtcConfig: {
                                                                token: e.serviceData.rtcToken,
                                                                teacherUid: parseInt(
                                                                    10000 * Math.random() + 1,
                                                                    10
                                                                ),
                                                            },
                                                            isAudition: true,
                                                            ircOptions: {
                                                                appId: e.serviceData.ircAppId,
                                                                appKey: e.serviceData.ircAppKey,
                                                                nickname: e.serviceData.ircNickName,
                                                                ircRooms: e.serviceData.ircRooms,
                                                                location:
                                                                    null === (n = e.serviceData.ircServer) ||
                                                                        void 0 === n
                                                                        ? void 0
                                                                        : n.location,
                                                                confService:
                                                                    null === (o = e.serviceData.ircServer) ||
                                                                        void 0 === o
                                                                        ? void 0
                                                                        : o.confService,
                                                                logService:
                                                                    null === (r = e.serviceData.ircServer) ||
                                                                        void 0 === r
                                                                        ? void 0
                                                                        : r.logService,
                                                            },
                                                        })),
                                                        t.abrupt('return', (e.thinkClass = i))
                                                    )
                                                case 3:
                                                case 'end':
                                                    return t.stop()
                                            }
                                        }
                                    }, t)
                                })
                            )()
                        },
                        startCheckNetwork: function () {
                            var e = this
                            return Object(i.a)(
                                Object(s.a)().mark(function t() {
                                    return Object(s.a)().wrap(function (t) {
                                        while (1) {
                                            switch ((t.prev = t.next)) {
                                                case 0:
                                                    return (
                                                        console.info(
                                                            '对象函数 startCheckNetwork,filePath:renderer/components/CheckDevice/networkCheck.vue'
                                                        ),
                                                        e.serviceListener(),
                                                        (t.next = 4),
                                                        e.checkServiceApi()
                                                    )
                                                case 4:
                                                    e.checkTiming()
                                                case 5:
                                                case 'end':
                                                    return t.stop()
                                            }
                                        }
                                    }, t)
                                })
                            )()
                        },
                        reStartCheckNetwork: function () {
                            var e = this
                            return Object(i.a)(
                                Object(s.a)().mark(function t() {
                                    return Object(s.a)().wrap(function (t) {
                                        while (1) {
                                            switch ((t.prev = t.next)) {
                                                case 0:
                                                    return (
                                                        console.info(
                                                            '对象函数 reStartCheckNetwork,filePath:renderer/components/CheckDevice/networkCheck.vue'
                                                        ),
                                                        e.clearNetworkCheckTimer(),
                                                        e.$emit('status', 'process', 'network'),
                                                        e.thinkClass.release(),
                                                        (e.rtcStatus =
                                                            e.ircStatus =
                                                            e.apiStatus =
                                                            e.coursewareStatus =
                                                            ''),
                                                        e.initService(),
                                                        (t.next = 8),
                                                        e.startCheckNetwork()
                                                    )
                                                case 8:
                                                case 'end':
                                                    return t.stop()
                                            }
                                        }
                                    }, t)
                                })
                            )()
                        },
                        serviceListener: function () {
                            var e = this
                            console.info(
                                '对象函数 serviceListener,filePath:renderer/components/CheckDevice/networkCheck.vue'
                            )
                            this.thinkClass.RtcService.on('ready', function () {
                                console.info(
                                    '箭头函数 监听 ready,filePath:renderer/components/CheckDevice/networkCheck.vue'
                                )
                                e.thinkClass.RtcService.enableLastmileTest()
                            })
                            this.thinkClass.SignalService.on('ready', function () {
                                console.info(
                                    '箭头函数 监听 ready,filePath:renderer/components/CheckDevice/networkCheck.vue'
                                )
                                for (var t = 0; t < 20; t++) {
                                    e.thinkClass.SignalService.setRoomData(e.ircRoom, e.kvMsg(t))
                                }
                            })
                            this.thinkClass.SignalService.on(
                                'onNetStatusChanged',
                                function (t) {
                                    console.info(
                                        '箭头函数 监听 onNetStatusChanged(res)',
                                        t,
                                        'filePath:renderer/components/CheckDevice/networkCheck.vue'
                                    )
                                    3 !== t.netStatus && (e.ircStatus = 'error')
                                }
                            )
                            this.thinkClass.SignalService.on(
                                'onSetRoomDataResponse',
                                function () {
                                    console.info(
                                        '箭头函数 监听 onSetRoomDataResponse,filePath:renderer/components/CheckDevice/networkCheck.vue'
                                    )
                                    e.roomDataResponse++
                                }
                            )
                            this.thinkClass.RtcService.on('lastMileQuality', function (t) {
                                console.info(
                                    '箭头函数 监听 lastMileQuality(txquality)',
                                    t,
                                    'filePath:renderer/components/CheckDevice/networkCheck.vue'
                                )
                                e.lastmileTestNumber++
                                e.lastmileTestValue = e.lastmileTestValue + t
                                4 === e.lastmileTestNumber &&
                                    (e.thinkClass.RtcService.disableLastmileTest(),
                                        (e.rtcStatus =
                                            e.lastmileTestValue &&
                                                Math.ceil(e.lastmileTestValue / 3) < 5
                                                ? 'success'
                                                : 'error'),
                                        (e.lastmileTestNumber = 0),
                                        (e.lastmileTestValue = 0))
                            })
                        },
                        checkServiceApi: function () {
                            var e = this
                            return Object(i.a)(
                                Object(s.a)().mark(function t() {
                                    var n, o, r, i, c
                                    return Object(s.a)().wrap(function (t) {
                                        while (1) {
                                            switch ((t.prev = t.next)) {
                                                case 0:
                                                    return (
                                                        console.info(
                                                            '对象函数 checkServiceApi,filePath:renderer/components/CheckDevice/networkCheck.vue'
                                                        ),
                                                        (n = +new Date()),
                                                        (t.next = 4),
                                                        Object(h.b)(e.serviceData.healthCheckUrl).catch(
                                                            function (e) {
                                                                return (
                                                                    console.info(
                                                                        '箭头函数 _checkServiceApi的catch(err)',
                                                                        e,
                                                                        'filePath:renderer/components/CheckDevice/networkCheck.vue'
                                                                    ),
                                                                    console.error('checkServiceApi', e),
                                                                    e
                                                                )
                                                            }
                                                        )
                                                    )
                                                case 4:
                                                    ; (o = t.sent),
                                                        (r = o.code),
                                                        (i = +new Date()),
                                                        (c = i - n),
                                                        (e.apiStatus =
                                                            0 === r && c <= e.apiResponseTime
                                                                ? 'success'
                                                                : 'error')
                                                case 9:
                                                case 'end':
                                                    return t.stop()
                                            }
                                        }
                                    }, t)
                                })
                            )()
                        },
                        checkDownloadCourseware: function () {
                            var e = this
                            return Object(i.a)(
                                Object(s.a)().mark(function t() {
                                    var n
                                    return Object(s.a)().wrap(function (t) {
                                        while (1) {
                                            switch ((t.prev = t.next)) {
                                                case 0:
                                                    return (
                                                        console.info(
                                                            '对象函数 checkDownloadCourseware,filePath:renderer/components/CheckDevice/networkCheck.vue'
                                                        ),
                                                        (t.next = 3),
                                                        p.a.downloadFile({
                                                            fileURL: e.serviceData.coursewareZipUrl,
                                                            fail: function () {
                                                                e.coursewareStatus = 'error'
                                                            },
                                                        })
                                                    )
                                                case 3:
                                                    ; (n = t.sent),
                                                        p.a.on(n, function (t) {
                                                            if (
                                                                (console.info(
                                                                    '箭头函数 on(res)',
                                                                    t,
                                                                    'filePath:renderer/components/CheckDevice/networkCheck.vue'
                                                                ),
                                                                    t.uptime >= e.downloadTime || 100 === t.percent)
                                                            ) {
                                                                p.a.removeListener(n)
                                                                var o = t.receivedSize.split('M').join(''),
                                                                    r = 1024 * o * 1024,
                                                                    s = Math.floor(r / e.downloadTime)
                                                                100 === t.percent &&
                                                                    (s = Math.floor(r / t.uptime))
                                                                e.coursewareStatus =
                                                                    s >= e.downloadNeedSpeed ? 'success' : 'error'
                                                                ''.concat(s, 'KB/S')
                                                                e.coursewareStatus
                                                            }
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
                        delTempCourseware: function () {
                            var e = this
                            return Object(i.a)(
                                Object(s.a)().mark(function t() {
                                    var n, o, r
                                    return Object(s.a)().wrap(function (t) {
                                        while (1) {
                                            switch ((t.prev = t.next)) {
                                                case 0:
                                                    return (
                                                        console.info(
                                                            '对象函数 delTempCourseware,filePath:renderer/components/CheckDevice/networkCheck.vue'
                                                        ),
                                                        (t.next = 3),
                                                        m.nativeApi.getPathByName('downloads')
                                                    )
                                                case 3:
                                                    if (
                                                        ((n = t.sent),
                                                            (o = Object(f.i)(e.serviceData.coursewareZipUrl)),
                                                            n && o)
                                                    ) {
                                                        t.next = 8
                                                        break
                                                    }
                                                    return (
                                                        console.info(
                                                            'if(!path || !fileName)为true触发return,path: /renderer/components/CheckDevice/networkCheck.vue'
                                                        ),
                                                        t.abrupt('return')
                                                    )
                                                case 8:
                                                    ; (r = ''.concat(n, '/').concat(o)),
                                                        window.thinkApi.ipc.send(
                                                            'application:removeDeviceCheckFile',
                                                            r
                                                        )
                                                case 10:
                                                case 'end':
                                                    return t.stop()
                                            }
                                        }
                                    }, t)
                                })
                            )()
                        },
                        nextCheck: function () {
                            console.info(
                                '对象函数 nextCheck,filePath:renderer/components/CheckDevice/networkCheck.vue'
                            )
                            this.delTempCourseware()
                            this.$emit('nextCheck')
                        },
                        btnCountDown: function () {
                            var e = this
                            console.info(
                                '对象函数 btnCountDown,filePath:renderer/components/CheckDevice/networkCheck.vue'
                            )
                            this.btnTimer ||
                                ((this.countDownTime = this.btnTimeCount),
                                    (this.btnTimer = setInterval(function () {
                                        e.countDownTime > 0 && e.countDownTime <= e.btnTimeCount
                                            ? e.countDownTime--
                                            : (e.clearBtnTimer(), e.nextCheck())
                                    }, 1000)))
                        },
                        clearBtnTimer: function () {
                            console.info(
                                '对象函数 clearBtnTimer,filePath:renderer/components/CheckDevice/networkCheck.vue'
                            )
                            this.btnTimer &&
                                (clearInterval(this.btnTimer), (this.btnTimer = null))
                        },
                        clearNetworkCheckTimer: function () {
                            console.info(
                                '对象函数 clearNetworkCheckTimer,filePath:renderer/components/CheckDevice/networkCheck.vue'
                            )
                            this.networkCheckTimer &&
                                (clearTimeout(this.networkCheckTimer),
                                    (this.networkCheckTimer = null))
                        },
                    },
                    watch: {
                        roomDataResponse: function (e) {
                            console.info(
                                '对象函数 roomDataResponse(val)',
                                e,
                                'filePath:renderer/components/CheckDevice/networkCheck.vue'
                            )
                            this.ircStatus = e && e >= 19 ? 'success' : 'error'
                        },
                        finishedCheck: function (e) {
                            if (
                                (console.info(
                                    '对象函数 finishedCheck(val)',
                                    e,
                                    'filePath:renderer/components/CheckDevice/networkCheck.vue'
                                ),
                                    e)
                            ) {
                                var t = [
                                    this.rtcStatus,
                                    this.ircStatus,
                                    this.apiStatus,
                                    this.coursewareStatus,
                                ].includes('error')
                                this.$emit('status', t ? 'error' : 'finish', 'network')
                                this.hasError = t
                                t || this.btnCountDown()
                            }
                        },
                        apiStatus: function (e) {
                            console.info(
                                '对象函数 apiStatus(val)',
                                e,
                                'filePath:renderer/components/CheckDevice/networkCheck.vue'
                            )
                            e && this.checkDownloadCourseware()
                        },
                    },
                    beforeDestroy: function () {
                        console.info(
                            '对象函数 beforeDestroy,filePath:renderer/components/CheckDevice/networkCheck.vue'
                        )
                        this.clearBtnTimer()
                        this.clearNetworkCheckTimer()
                        this.thinkClass.release()
                        window.removeEventListener('offline', function () {
                            console.info(
                                '箭头函数 监听 offline,filePath:renderer/components/CheckDevice/networkCheck.vue'
                            )
                        })
                    },
                },
                w = y,
                E = (n('9813'), Object(_.a)(w, u, l, false, null, '680bae0b', null)),
                P = E.exports,
                x = function () {
                    var e = this,
                        t = e._self._c
                    return t(
                        'div',
                        { staticClass: 'microphone-check' },
                        [
                            e.checkMicrophone
                                ? [
                                    e.hasAccessError
                                        ? [
                                            t('div', { staticClass: 'microphone-error-info' }, [
                                                t('i', {
                                                    staticClass: 'result-icon microphone-error',
                                                }),
                                                e.microphoneAccess
                                                    ? t('p', [
                                                        e._v(
                                                            e._s(
                                                                e.$t(
                                                                    'classroom.modules.checkDevice.没有找到可用的麦克风'
                                                                )
                                                            )
                                                        ),
                                                    ])
                                                    : t('p', [
                                                        e._v(
                                                            e._s(
                                                                e.$t(
                                                                    'classroom.modules.checkDevice.没有麦克风权限'
                                                                )
                                                            )
                                                        ),
                                                    ]),
                                            ]),
                                            t('div', { staticClass: 'checkdevice-result' }, [
                                                t('i', {
                                                    staticClass: 'svg-icon svg-warning red-color',
                                                }),
                                                e.microphoneAccess
                                                    ? t('p', [
                                                        e._v(
                                                            e._s(
                                                                e.$t(
                                                                    'classroom.modules.checkDevice.请检查你的麦克风或者佩戴耳机'
                                                                )
                                                            )
                                                        ),
                                                    ])
                                                    : t('p', [
                                                        e._v(
                                                            ' ' +
                                                            e._s(
                                                                e.$t(
                                                                    'classroom.modules.checkDevice.在设置中打开麦克风权限'
                                                                )
                                                            ) +
                                                            ' '
                                                        ),
                                                    ]),
                                                t(
                                                    'div',
                                                    { staticClass: 'button-group' },
                                                    [
                                                        e.microphoneAccess || 'mac' !== e.platform
                                                            ? e._e()
                                                            : t(
                                                                'a-button',
                                                                {
                                                                    attrs: {
                                                                        type: 'default',
                                                                        shape: 'round',
                                                                    },
                                                                    on: { click: e.openPreferences },
                                                                },
                                                                [
                                                                    e._v(
                                                                        e._s(
                                                                            e.$t(
                                                                                'classroom.modules.checkDevice.去设置'
                                                                            )
                                                                        )
                                                                    ),
                                                                ]
                                                            ),
                                                        t(
                                                            'a-button',
                                                            {
                                                                attrs: {
                                                                    type: 'default',
                                                                    shape: 'round',
                                                                },
                                                                on: { click: e.nextCheck },
                                                            },
                                                            [
                                                                e._v(
                                                                    e._s(
                                                                        e.$t(
                                                                            'classroom.modules.checkDevice.下一项'
                                                                        )
                                                                    )
                                                                ),
                                                            ]
                                                        ),
                                                    ],
                                                    1
                                                ),
                                            ]),
                                        ]
                                        : e.volumeInputError
                                            ? [
                                                t('i', {
                                                    staticClass: 'result-icon microphone-error',
                                                }),
                                                t('p', [
                                                    e._v(
                                                        e._s(
                                                            e.$t(
                                                                'classroom.modules.checkDevice.请检查你的麦克风或者佩戴耳机'
                                                            )
                                                        )
                                                    ),
                                                ]),
                                                t('div', { staticClass: 'checkdevice-result' }, [
                                                    t('i', {
                                                        staticClass: 'svg-icon svg-warning red-color',
                                                    }),
                                                    t('p', [
                                                        e._v(
                                                            ' ' +
                                                            e._s(
                                                                e.$t(
                                                                    'classroom.modules.checkDevice.请检查你的麦克风或者佩戴耳机'
                                                                )
                                                            ) +
                                                            ' '
                                                        ),
                                                    ]),
                                                    t(
                                                        'div',
                                                        { staticClass: 'button-group' },
                                                        [
                                                            t(
                                                                'a-button',
                                                                {
                                                                    attrs: {
                                                                        type: 'default',
                                                                        shape: 'round',
                                                                    },
                                                                    on: { click: e.reStartVolumeInput },
                                                                },
                                                                [
                                                                    e._v(
                                                                        ' ' +
                                                                        e._s(
                                                                            e.$t(
                                                                                'classroom.modules.checkDevice.重新测试'
                                                                            )
                                                                        ) +
                                                                        ' '
                                                                    ),
                                                                ]
                                                            ),
                                                            t(
                                                                'a-button',
                                                                {
                                                                    attrs: {
                                                                        type: 'default',
                                                                        shape: 'round',
                                                                    },
                                                                    on: { click: e.nextCheck },
                                                                },
                                                                [
                                                                    e._v(
                                                                        e._s(
                                                                            e.$t(
                                                                                'classroom.modules.checkDevice.下一项'
                                                                            )
                                                                        )
                                                                    ),
                                                                ]
                                                            ),
                                                        ],
                                                        1
                                                    ),
                                                ]),
                                            ]
                                            : [
                                                t('InputVolume', { on: { volume: e.handleVolume } }),
                                                t('p', [
                                                    e._v(
                                                        e._s(
                                                            e.$t(
                                                                'classroom.modules.checkDevice.尝试你大声读出下面的文字'
                                                            )
                                                        )
                                                    ),
                                                ]),
                                                t(
                                                    'div',
                                                    { staticClass: 'checkdevice-result' },
                                                    [
                                                        t('a-progress', {
                                                            attrs: {
                                                                type: 'circle',
                                                                strokeWidth: 5,
                                                                percent: e.percent,
                                                                width: 86,
                                                                trailColor: '#C8CDD7',
                                                                'stroke-color': {
                                                                    '100%': '#39CD5F',
                                                                    '0%': '#2AD8BB',
                                                                },
                                                            },
                                                            scopedSlots: e._u(
                                                                [
                                                                    {
                                                                        key: 'format',
                                                                        fn: function () {
                                                                            return [
                                                                                t(
                                                                                    'span',
                                                                                    { staticClass: 'tips-word' },
                                                                                    [
                                                                                        e._v(
                                                                                            e._s(
                                                                                                e.$t(
                                                                                                    'classroom.modules.checkDevice.你好'
                                                                                                )
                                                                                            )
                                                                                        ),
                                                                                    ]
                                                                                ),
                                                                            ]
                                                                        },
                                                                        proxy: true,
                                                                    },
                                                                ],
                                                                null,
                                                                false,
                                                                3576677175
                                                            ),
                                                        }),
                                                    ],
                                                    1
                                                ),
                                            ],
                                ]
                                : [
                                    t('i', { staticClass: 'result-icon microphone-success' }),
                                    t('p', [
                                        e._v(
                                            e._s(
                                                e.$t('classroom.modules.checkDevice.麦克风检测完成')
                                            )
                                        ),
                                    ]),
                                    t('div', { staticClass: 'checkdevice-result' }, [
                                        t('i', {
                                            staticClass: 'svg-icon svg-success green-color',
                                        }),
                                        t('p', [
                                            e._v(
                                                e._s(
                                                    e.$t(
                                                        'classroom.modules.checkDevice.你的麦克风工作正常'
                                                    )
                                                )
                                            ),
                                        ]),
                                        t(
                                            'div',
                                            { staticClass: 'button-group' },
                                            [
                                                t(
                                                    'a-button',
                                                    {
                                                        attrs: {
                                                            type: 'default',
                                                            shape: 'round',
                                                        },
                                                        on: { click: e.nextCheck },
                                                    },
                                                    [
                                                        e._v(
                                                            ' ' +
                                                            e._s(
                                                                e.$t('classroom.modules.checkDevice.下一项')
                                                            ) +
                                                            '(' +
                                                            e._s(e.countDownTime) +
                                                            's) '
                                                        ),
                                                    ]
                                                ),
                                            ],
                                            1
                                        ),
                                    ]),
                                ],
                        ],
                        2
                    )
                },
                I = [],
                D =
                    (n('d3b7'),
                        n('25f0'),
                        function () {
                            var e = this,
                                t = e._self._c
                            return t('div', { staticClass: 'dynamic-mic-container' }, [
                                t('div', { staticClass: 'dynamic-mic-green' }),
                                t('div', {
                                    staticClass: 'dynamic-mic-white',
                                    style: {
                                        clip: 'rect(0 40px '.concat(
                                            38 - (e.volume / 100) * 38,
                                            'px 0)'
                                        ),
                                    },
                                }),
                            ])
                        }),
                R = [],
                T = {
                    data: function () {
                        return { volume: 0 }
                    },
                    mounted: function () {
                        var e = this
                        this.$nextTick(function () {
                            e.getVolumeInput()
                        })
                    },
                    methods: {
                        getVolumeInput: function () {
                            var e = this
                            console.info(
                                '对象函数 getVolumeInput,filePath:renderer/components/CheckDevice/volumeInput.vue'
                            )
                            var t = function () {
                                console.info(
                                    '箭头函数 onError,filePath:renderer/components/CheckDevice/volumeInput.vue'
                                )
                                e.$emit('volume', 0)
                            },
                                n = function (t) {
                                    console.info(
                                        '箭头函数 onSuccess(stream)',
                                        t,
                                        'filePath:renderer/components/CheckDevice/volumeInput.vue'
                                    )
                                    var n = window.AudioContext || window.webkitAudioContext,
                                        o = new n(),
                                        r = o.createMediaStreamSource(t),
                                        s = o.createGain()
                                    r.connect(s)
                                    var c = o.createScriptProcessor(2048, 1, 1)
                                    c.onaudioprocess = function (t) {
                                        for (
                                            var n = t.inputBuffer.getChannelData(0), o = 0, r = 0;
                                            r < n.length;
                                            r++
                                        ) {
                                            o < n[r] && (o = n[r])
                                        }
                                        e.volume = Math.round(100 * o)
                                        e.volume >= 30 && e.$emit('volume', e.volume)
                                    }
                                    s.connect(c)
                                    c.connect(o.destination)
                                }
                            navigator.getUserMedia =
                                navigator.getUserMedia || navigator.webkitGetUserMedia
                            navigator.getUserMedia({ audio: true }, n, t)
                        },
                    },
                },
                O = T,
                A = (n('bb61'), Object(_.a)(O, D, R, false, null, '72a5f1dc', null)),
                L = A.exports,
                N = {
                    name: 'MicrophoneCheck',
                    data: function () {
                        return {
                            checkMicrophone: true,
                            percent: 100,
                            hasAccessError: false,
                            volumeInputError: false,
                            microphoneAccess: '',
                            platform: '',
                            percentTimer: null,
                            volumeValue: 0,
                            btnTimeCount: 5,
                            btnTimer: null,
                            countDownTime: 0,
                        }
                    },
                    components: { InputVolume: L },
                    mounted: function () {
                        var e = this
                        return Object(i.a)(
                            Object(s.a)().mark(function t() {
                                var n, o
                                return Object(s.a)().wrap(function (t) {
                                    while (1) {
                                        switch ((t.prev = t.next)) {
                                            case 0:
                                                if (
                                                    ((e.platform = Object(f.k)()), 'mac' !== e.platform)
                                                ) {
                                                    t.next = 7
                                                    break
                                                }
                                                return (
                                                    (t.next = 4), m.nativeApi.getMediaAccess('microphone')
                                                )
                                            case 4:
                                                ; (t.t0 = t.sent), (t.next = 8)
                                                break
                                            case 7:
                                                t.t0 = true
                                            case 8:
                                                return (
                                                    (n = t.t0),
                                                    (t.next = 11),
                                                    m.nativeApi.getMediaAccessStatus('microphone')
                                                )
                                            case 11:
                                                ; (o = t.sent),
                                                    (e.microphoneAccess = n),
                                                    'not-determined' !== o && n
                                                        ? e.startCheckVolumeInput()
                                                        : (e.$emit('status', 'error', 'microphone'),
                                                            (e.hasAccessError = true))
                                            case 14:
                                            case 'end':
                                                return t.stop()
                                        }
                                    }
                                }, t)
                            })
                        )()
                    },
                    methods: {
                        openPreferences: function () {
                            console.info(
                                '对象函数 openPreferences,filePath:renderer/components/CheckDevice/microphoneCheck.vue'
                            )
                            m.nativeApi.openPreferences('security', 'microphone')
                        },
                        handleVolume: function (e) {
                            console.info(
                                '对象函数 handleVolume(value)',
                                e,
                                'filePath:renderer/components/CheckDevice/microphoneCheck.vue'
                            )
                            this.volumeValue = e
                        },
                        clearInterval: (function (e) {
                            function t() {
                                return (
                                    console.info(
                                        '函数申明 clearInterval, filePath:renderer/components/CheckDevice/microphoneCheck.vue'
                                    ),
                                    e.apply(this, arguments)
                                )
                            }
                            return (
                                (t.toString = function () {
                                    return e.toString()
                                }),
                                t
                            )
                        })(function () {
                            console.info(
                                '对象函数 clearInterval,filePath:renderer/components/CheckDevice/microphoneCheck.vue'
                            )
                            clearInterval(this.percentTimer)
                            this.percentTimer = null
                        }),
                        nextCheck: function () {
                            console.info(
                                '对象函数 nextCheck,filePath:renderer/components/CheckDevice/microphoneCheck.vue'
                            )
                            this.$emit('nextCheck')
                        },
                        startCheckVolumeInput: function () {
                            var e = this
                            console.info(
                                '对象函数 startCheckVolumeInput,filePath:renderer/components/CheckDevice/microphoneCheck.vue'
                            )
                            this.percentTimer = setInterval(function () {
                                e.percent = e.percent - 0.1
                                e.percent <= 0 &&
                                    (e.clearInterval(),
                                        e.volumeValue
                                            ? ((e.checkMicrophone = false),
                                                e.$emit('status', 'finish', 'microphone'),
                                                e.btnCountDown())
                                            : ((e.volumeInputError = true),
                                                e.$emit('status', 'error', 'microphone')))
                            }, 10)
                        },
                        reStartVolumeInput: function () {
                            console.info(
                                '对象函数 reStartVolumeInput,filePath:renderer/components/CheckDevice/microphoneCheck.vue'
                            )
                            this.percent = 100
                            this.volumeInputError = false
                            this.$emit('status', 'process', 'microphone')
                            this.startCheckVolumeInput()
                        },
                        btnCountDown: function () {
                            var e = this
                            console.info(
                                '对象函数 btnCountDown,filePath:renderer/components/CheckDevice/microphoneCheck.vue'
                            )
                            this.btnTimer ||
                                ((this.countDownTime = this.btnTimeCount),
                                    (this.btnTimer = setInterval(function () {
                                        e.countDownTime > 0 && e.countDownTime <= e.btnTimeCount
                                            ? e.countDownTime--
                                            : (e.clearBtnTimer(), e.nextCheck())
                                    }, 1000)))
                        },
                        clearBtnTimer: function () {
                            console.info(
                                '对象函数 clearBtnTimer,filePath:renderer/components/CheckDevice/microphoneCheck.vue'
                            )
                            this.btnTimer &&
                                (clearInterval(this.btnTimer), (this.btnTimer = null))
                        },
                    },
                    beforeDestroy: function () {
                        console.info(
                            '对象函数 beforeDestroy,filePath:renderer/components/CheckDevice/microphoneCheck.vue'
                        )
                        this.percentTimer && this.clearInterval()
                        this.clearBtnTimer()
                    },
                },
                M = N,
                U = (n('98f3'), Object(_.a)(M, x, I, false, null, '14b48ff4', null)),
                V = U.exports,
                j = function () {
                    var e = this,
                        t = e._self._c
                    return t(
                        'div',
                        {
                            staticClass: 'camera-check',
                            class: {
                                restoreClass:
                                    e.cameraError || !e.checkCamera || !e.cameraAccess,
                            },
                        },
                        [
                            e.checkCamera
                                ? [
                                    e.hasAccessError
                                        ? [
                                            t('div', { staticClass: 'camera-error-info' }, [
                                                t('i', { staticClass: 'result-icon camera-error' }),
                                                e.cameraAccess
                                                    ? t('p', [
                                                        e._v(
                                                            e._s(
                                                                e.$t(
                                                                    'classroom.modules.checkDevice.没有找到可用的摄像头'
                                                                )
                                                            )
                                                        ),
                                                    ])
                                                    : t('p', [
                                                        e._v(
                                                            ' ' +
                                                            e._s(
                                                                e.$t(
                                                                    'classroom.modules.checkDevice.没有摄像头权限'
                                                                )
                                                            ) +
                                                            ' '
                                                        ),
                                                    ]),
                                            ]),
                                            t('div', { staticClass: 'checkdevice-result' }, [
                                                t('i', {
                                                    staticClass: 'svg-icon svg-warning red-color',
                                                }),
                                                e.cameraAccess
                                                    ? t('p', [
                                                        e._v(
                                                            ' ' +
                                                            e._s(
                                                                e.$t(
                                                                    'classroom.modules.checkDevice.请检查你的摄像头'
                                                                )
                                                            ) +
                                                            ' '
                                                        ),
                                                    ])
                                                    : t('p', [
                                                        e._v(
                                                            ' ' +
                                                            e._s(
                                                                e.$t(
                                                                    'classroom.modules.checkDevice.在设置中打开麦克风权限'
                                                                )
                                                            ) +
                                                            ' '
                                                        ),
                                                    ]),
                                                t(
                                                    'div',
                                                    { staticClass: 'button-group' },
                                                    [
                                                        e.cameraAccess || 'mac' !== e.platform
                                                            ? e._e()
                                                            : t(
                                                                'a-button',
                                                                {
                                                                    attrs: {
                                                                        type: 'default',
                                                                        shape: 'round',
                                                                    },
                                                                    on: { click: e.openPreferences },
                                                                },
                                                                [
                                                                    e._v(
                                                                        ' ' +
                                                                        e._s(
                                                                            e.$t(
                                                                                'classroom.modules.checkDevice.去设置'
                                                                            )
                                                                        ) +
                                                                        ' '
                                                                    ),
                                                                ]
                                                            ),
                                                        t(
                                                            'a-button',
                                                            {
                                                                attrs: {
                                                                    type: 'default',
                                                                    shape: 'round',
                                                                },
                                                                on: { click: e.nextCheck },
                                                            },
                                                            [
                                                                e._v(
                                                                    ' ' +
                                                                    e._s(
                                                                        e.$t(
                                                                            'classroom.modules.checkDevice.下一项'
                                                                        )
                                                                    ) +
                                                                    ' '
                                                                ),
                                                            ]
                                                        ),
                                                    ],
                                                    1
                                                ),
                                            ]),
                                        ]
                                        : e.cameraError
                                            ? [
                                                t('i', { staticClass: 'result-icon camera-error' }),
                                                t('p', [
                                                    e._v(
                                                        e._s(
                                                            e.$t(
                                                                'classroom.modules.checkDevice.你的摄像头似乎存在问题'
                                                            )
                                                        )
                                                    ),
                                                ]),
                                                t('div', { staticClass: 'checkdevice-result' }, [
                                                    t('i', {
                                                        staticClass: 'svg-icon svg-warning red-color',
                                                    }),
                                                    t('p', [
                                                        e._v(
                                                            e._s(
                                                                e.$t(
                                                                    'classroom.modules.checkDevice.请检查你的摄像头是否正确安装'
                                                                )
                                                            )
                                                        ),
                                                    ]),
                                                    t(
                                                        'div',
                                                        { staticClass: 'button-group' },
                                                        [
                                                            t(
                                                                'a-button',
                                                                {
                                                                    attrs: {
                                                                        type: 'default',
                                                                        shape: 'round',
                                                                    },
                                                                    on: { click: e.reStartCheckCamera },
                                                                },
                                                                [
                                                                    e._v(
                                                                        ' ' +
                                                                        e._s(
                                                                            e.$t(
                                                                                'classroom.modules.checkDevice.重新测试'
                                                                            )
                                                                        ) +
                                                                        ' '
                                                                    ),
                                                                ]
                                                            ),
                                                            t(
                                                                'a-button',
                                                                {
                                                                    attrs: {
                                                                        type: 'default',
                                                                        shape: 'round',
                                                                    },
                                                                    on: { click: e.nextCheck },
                                                                },
                                                                [
                                                                    e._v(
                                                                        ' ' +
                                                                        e._s(
                                                                            e.$t(
                                                                                'classroom.modules.checkDevice.下一项'
                                                                            )
                                                                        ) +
                                                                        ' '
                                                                    ),
                                                                ]
                                                            ),
                                                        ],
                                                        1
                                                    ),
                                                ]),
                                            ]
                                            : [
                                                t('video', { ref: 'demo' }),
                                                t('h2', [
                                                    e._v(
                                                        ' ' +
                                                        e._s(
                                                            e.$t(
                                                                'classroom.modules.checkDevice.可以在上面看到自己吗'
                                                            )
                                                        ) +
                                                        ' '
                                                    ),
                                                ]),
                                                t('h3', [
                                                    e._v(
                                                        e._s(
                                                            e.$t(
                                                                'classroom.modules.checkDevice.正在使用摄像头'
                                                            )
                                                        )
                                                    ),
                                                ]),
                                                t(
                                                    'div',
                                                    { staticClass: 'button-group' },
                                                    [
                                                        t(
                                                            'a-button',
                                                            {
                                                                attrs: {
                                                                    type: 'default',
                                                                    shape: 'round',
                                                                },
                                                                on: { click: e.handleError },
                                                            },
                                                            [
                                                                e._v(
                                                                    ' ' +
                                                                    e._s(
                                                                        e.$t(
                                                                            'classroom.modules.checkDevice.不能'
                                                                        )
                                                                    ) +
                                                                    ' '
                                                                ),
                                                            ]
                                                        ),
                                                        t(
                                                            'a-button',
                                                            {
                                                                attrs: {
                                                                    type: 'default',
                                                                    shape: 'round',
                                                                },
                                                                on: { click: e.handleSuccess },
                                                            },
                                                            [
                                                                e._v(
                                                                    ' ' +
                                                                    e._s(
                                                                        e.$t('classroom.modules.checkDevice.能')
                                                                    ) +
                                                                    ' '
                                                                ),
                                                            ]
                                                        ),
                                                    ],
                                                    1
                                                ),
                                            ],
                                ]
                                : [
                                    t('i', { staticClass: 'result-icon camera-success' }),
                                    t('p', [
                                        e._v(
                                            ' ' +
                                            e._s(
                                                e.$t('classroom.modules.checkDevice.摄像头检测完成')
                                            ) +
                                            ' '
                                        ),
                                    ]),
                                    t('div', { staticClass: 'checkdevice-result' }, [
                                        t('i', {
                                            staticClass: 'svg-icon svg-success green-color',
                                        }),
                                        t('p', [
                                            e._v(
                                                e._s(
                                                    e.$t(
                                                        'classroom.modules.checkDevice.你的摄像头工作正常'
                                                    )
                                                )
                                            ),
                                        ]),
                                        t(
                                            'div',
                                            { staticClass: 'button-group' },
                                            [
                                                t(
                                                    'a-button',
                                                    {
                                                        attrs: {
                                                            type: 'default',
                                                            shape: 'round',
                                                        },
                                                        on: { click: e.nextCheck },
                                                    },
                                                    [
                                                        e._v(
                                                            ' ' +
                                                            e._s(
                                                                e.$t('classroom.modules.checkDevice.下一项')
                                                            ) +
                                                            '(' +
                                                            e._s(e.countDownTime) +
                                                            's) '
                                                        ),
                                                    ]
                                                ),
                                            ],
                                            1
                                        ),
                                    ]),
                                ],
                        ],
                        2
                    )
                },
                $ = [],
                B = {
                    name: 'CameraCheck',
                    data: function () {
                        return {
                            checkCamera: true,
                            cameraAccess: true,
                            hasAccessError: false,
                            cameraError: false,
                            platform: '',
                            MediaStreamTrack: null,
                            btnTimeCount: 5,
                            btnTimer: null,
                            countDownTime: 0,
                        }
                    },
                    mounted: function () {
                        var e = this
                        return Object(i.a)(
                            Object(s.a)().mark(function t() {
                                var n, o
                                return Object(s.a)().wrap(function (t) {
                                    while (1) {
                                        switch ((t.prev = t.next)) {
                                            case 0:
                                                if (
                                                    ((e.platform = Object(f.k)()), 'mac' !== e.platform)
                                                ) {
                                                    t.next = 7
                                                    break
                                                }
                                                return (
                                                    (t.next = 4), m.nativeApi.getMediaAccess('camera')
                                                )
                                            case 4:
                                                ; (t.t0 = t.sent), (t.next = 8)
                                                break
                                            case 7:
                                                t.t0 = true
                                            case 8:
                                                return (
                                                    (n = t.t0),
                                                    (t.next = 11),
                                                    m.nativeApi.getMediaAccessStatus('camera')
                                                )
                                            case 11:
                                                ; (o = t.sent),
                                                    (e.cameraAccess = n),
                                                    'not-determined' !== o && n
                                                        ? e.startCheckCheckCamera()
                                                        : (e.$emit('status', 'error', 'camera'),
                                                            (e.hasAccessError = true))
                                            case 14:
                                            case 'end':
                                                return t.stop()
                                        }
                                    }
                                }, t)
                            })
                        )()
                    },
                    methods: {
                        openPreferences: function () {
                            console.info(
                                '对象函数 openPreferences,filePath:renderer/components/CheckDevice/cameraCheck.vue'
                            )
                            m.nativeApi.openPreferences('security', 'camera')
                        },
                        startCheckCheckCamera: function () {
                            var e = this
                            console.info(
                                '对象函数 startCheckCheckCamera,filePath:renderer/components/CheckDevice/cameraCheck.vue'
                            )
                            var t = {
                                video: {
                                    width: 600,
                                    height: 450,
                                },
                                audio: false,
                            }
                            navigator.mediaDevices
                                .getUserMedia(t)
                                .then(function (t) {
                                    console.info(
                                        '箭头函数 then(MediaStream)',
                                        t,
                                        'filePath:renderer/components/CheckDevice/cameraCheck.vue'
                                    )
                                    e.MediaStreamTrack =
                                        'function' === typeof t.stop ? t : t.getTracks()[0]
                                    e.$refs.demo.srcObject = t
                                    e.$refs.demo.play()
                                })
                                .catch(function (t) {
                                    console.info(
                                        '箭头函数 catch(e)',
                                        t,
                                        'filePath:renderer/components/CheckDevice/cameraCheck.vue'
                                    )
                                    e.cameraError = true
                                    console.error('摄像头检测error', t)
                                })
                        },
                        reStartCheckCamera: function () {
                            console.info(
                                '对象函数 reStartCheckCamera,filePath:renderer/components/CheckDevice/cameraCheck.vue'
                            )
                            this.cameraError = false
                            this.$emit('status', 'process', 'camera')
                            this.startCheckCheckCamera()
                        },
                        handleError: function () {
                            console.info(
                                '对象函数 handleError,filePath:renderer/components/CheckDevice/cameraCheck.vue'
                            )
                            this.cameraError = true
                            this.$emit('status', 'error', 'camera')
                        },
                        handleSuccess: function () {
                            console.info(
                                '对象函数 handleSuccess,filePath:renderer/components/CheckDevice/cameraCheck.vue'
                            )
                            this.checkCamera = false
                            this.$emit('status', 'finish', 'camera')
                            this.btnCountDown()
                        },
                        nextCheck: function () {
                            console.info(
                                '对象函数 nextCheck,filePath:renderer/components/CheckDevice/cameraCheck.vue'
                            )
                            this.$emit('nextCheck')
                        },
                        closeCamera: function () {
                            console.info(
                                '对象函数 closeCamera,filePath:renderer/components/CheckDevice/cameraCheck.vue'
                            )
                            this.MediaStreamTrack &&
                                (this.MediaStreamTrack.stop(), (this.MediaStreamTrack = null))
                        },
                        btnCountDown: function () {
                            var e = this
                            console.info(
                                '对象函数 btnCountDown,filePath:renderer/components/CheckDevice/cameraCheck.vue'
                            )
                            this.btnTimer ||
                                ((this.countDownTime = this.btnTimeCount),
                                    (this.btnTimer = setInterval(function () {
                                        e.countDownTime > 0 && e.countDownTime <= e.btnTimeCount
                                            ? e.countDownTime--
                                            : (e.clearBtnTimer(), e.nextCheck())
                                    }, 1000)))
                        },
                        clearBtnTimer: function () {
                            console.info(
                                '对象函数 clearBtnTimer,filePath:renderer/components/CheckDevice/cameraCheck.vue'
                            )
                            this.btnTimer &&
                                (clearInterval(this.btnTimer), (this.btnTimer = null))
                        },
                    },
                    beforeDestroy: function () {
                        console.info(
                            '对象函数 beforeDestroy,filePath:renderer/components/CheckDevice/cameraCheck.vue'
                        )
                        this.closeCamera()
                        this.clearBtnTimer()
                    },
                },
                G = B,
                H = (n('3164'), Object(_.a)(G, j, $, false, null, '519bc143', null)),
                F = H.exports,
                K = function () {
                    var e = this,
                        t = e._self._c
                    return t(
                        'div',
                        {
                            staticClass: 'speaker-check',
                            class: { restoreClass: e.speakerError || !e.checkSpeaker },
                        },
                        [
                            t('audio', {
                                ref: 'speakerAudio',
                                staticClass: 'hide',
                                attrs: {
                                    src: n('40fd'),
                                    loop: '',
                                },
                            }),
                            e.speakerError
                                ? [
                                    t('i', { staticClass: 'result-icon speaker-error' }),
                                    t('p', [
                                        e._v(
                                            e._s(
                                                e.$t(
                                                    'classroom.modules.checkDevice.你的扬声器似乎存在问题'
                                                )
                                            )
                                        ),
                                    ]),
                                    t('div', { staticClass: 'checkdevice-result' }, [
                                        t('i', { staticClass: 'svg-icon svg-warning red-color' }),
                                        t('p', [
                                            e._v(
                                                e._s(
                                                    e.$t(
                                                        'classroom.modules.checkDevice.建议尝试佩戴耳机或者更换其它设备'
                                                    )
                                                )
                                            ),
                                        ]),
                                        t(
                                            'div',
                                            { staticClass: 'button-group' },
                                            [
                                                t(
                                                    'a-button',
                                                    {
                                                        attrs: {
                                                            type: 'default',
                                                            shape: 'round',
                                                        },
                                                        on: { click: e.reStartCheckSpeaker },
                                                    },
                                                    [
                                                        e._v(
                                                            ' ' +
                                                            e._s(
                                                                e.$t(
                                                                    'classroom.modules.checkDevice.重新测试'
                                                                )
                                                            ) +
                                                            ' '
                                                        ),
                                                    ]
                                                ),
                                                t(
                                                    'a-button',
                                                    {
                                                        attrs: {
                                                            type: 'default',
                                                            shape: 'round',
                                                        },
                                                        on: { click: e.nextCheck },
                                                    },
                                                    [
                                                        e._v(
                                                            ' ' +
                                                            e._s(
                                                                e.$t('classroom.modules.checkDevice.下一项')
                                                            ) +
                                                            ' '
                                                        ),
                                                    ]
                                                ),
                                            ],
                                            1
                                        ),
                                    ]),
                                ]
                                : [
                                    t(
                                        'div',
                                        { staticClass: 'play-content' },
                                        [
                                            t('i', { staticClass: 'result-icon speaker-success' }),
                                            'win' !== e.platform
                                                ? [
                                                    t('a-progress', {
                                                        attrs: {
                                                            percent: e.systemVol,
                                                            'show-info': false,
                                                            strokeWidth: 3,
                                                            'stroke-color': {
                                                                '0%': '#FF26DC',
                                                                '100%': '#32C5FF',
                                                            },
                                                        },
                                                    }),
                                                    t('p', [
                                                        e._v(
                                                            e._s(
                                                                e.$t(
                                                                    'classroom.modules.checkDevice.当前音量'
                                                                )
                                                            ) +
                                                            e._s(e.systemVol) +
                                                            '%'
                                                        ),
                                                    ]),
                                                ]
                                                : e._e(),
                                        ],
                                        2
                                    ),
                                    t('h2', [
                                        e._v(
                                            ' ' +
                                            e._s(
                                                e.$t(
                                                    'classroom.modules.checkDevice.可以听到正在播放的音乐吗'
                                                )
                                            ) +
                                            ' '
                                        ),
                                    ]),
                                    t('h3', [
                                        e._v(
                                            ' ' +
                                            e._s(
                                                e.$t(
                                                    'classroom.modules.checkDevice.请注意调整系统音量到适当大小'
                                                )
                                            ) +
                                            ' '
                                        ),
                                    ]),
                                    t(
                                        'div',
                                        { staticClass: 'button-group' },
                                        [
                                            t(
                                                'a-button',
                                                {
                                                    attrs: {
                                                        type: 'default',
                                                        shape: 'round',
                                                    },
                                                    on: { click: e.handleError },
                                                },
                                                [
                                                    e._v(
                                                        ' ' +
                                                        e._s(
                                                            e.$t('classroom.modules.checkDevice.不能')
                                                        ) +
                                                        ' '
                                                    ),
                                                ]
                                            ),
                                            t(
                                                'a-button',
                                                {
                                                    attrs: {
                                                        type: 'default',
                                                        shape: 'round',
                                                    },
                                                    on: { click: e.handleSuccess },
                                                },
                                                [
                                                    e._v(
                                                        ' ' +
                                                        e._s(e.$t('classroom.modules.checkDevice.能')) +
                                                        ' '
                                                    ),
                                                ]
                                            ),
                                        ],
                                        1
                                    ),
                                ],
                        ],
                        2
                    )
                },
                J = [],
                W = n('21dc'),
                q = {
                    name: 'SpeakerCheck',
                    data: function () {
                        return {
                            systemVol: 0,
                            speakerError: false,
                            checkSpeaker: true,
                            platform: '',
                        }
                    },
                    mounted: function () {
                        var e = this
                        return Object(i.a)(
                            Object(s.a)().mark(function t() {
                                return Object(s.a)().wrap(function (t) {
                                    while (1) {
                                        switch ((t.prev = t.next)) {
                                            case 0:
                                                return (
                                                    (e.platform = Object(f.k)()),
                                                    (t.next = 3),
                                                    e.startCheckSpeaker()
                                                )
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
                        startCheckSpeaker: function () {
                            var e = this
                            return Object(i.a)(
                                Object(s.a)().mark(function t() {
                                    var n
                                    return Object(s.a)().wrap(function (t) {
                                        while (1) {
                                            switch ((t.prev = t.next)) {
                                                case 0:
                                                    if (
                                                        (console.info(
                                                            '对象函数 startCheckSpeaker,filePath:renderer/components/CheckDevice/speakerCheck.vue'
                                                        ),
                                                            'mac' !== e.platform)
                                                    ) {
                                                        t.next = 6
                                                        break
                                                    }
                                                    return (t.next = 4), W.getVolume()
                                                case 4:
                                                    ; (n = t.sent), (e.systemVol = n || 0)
                                                case 6:
                                                    e.$refs.speakerAudio.play()
                                                case 7:
                                                case 'end':
                                                    return t.stop()
                                            }
                                        }
                                    }, t)
                                })
                            )()
                        },
                        reStartCheckSpeaker: function () {
                            console.info(
                                '对象函数 reStartCheckSpeaker,filePath:renderer/components/CheckDevice/speakerCheck.vue'
                            )
                            this.checkSpeaker = true
                            this.speakerError = false
                            this.$emit('status', 'process', 'speaker')
                            this.startCheckSpeaker()
                        },
                        handleError: function () {
                            console.info(
                                '对象函数 handleError,filePath:renderer/components/CheckDevice/speakerCheck.vue'
                            )
                            this.$refs.speakerAudio.pause()
                            this.speakerError = true
                            this.checkSpeaker = false
                            this.$emit('status', 'error', 'speaker')
                        },
                        handleSuccess: function () {
                            console.info(
                                '对象函数 handleSuccess,filePath:renderer/components/CheckDevice/speakerCheck.vue'
                            )
                            this.checkSpeaker = false
                            this.$refs.speakerAudio.pause()
                            this.$emit('status', 'finish', 'speaker')
                            this.nextCheck()
                        },
                        nextCheck: function () {
                            console.info(
                                '对象函数 nextCheck,filePath:renderer/components/CheckDevice/speakerCheck.vue'
                            )
                            this.$bus.$emit('finishedDeviceCheck')
                        },
                    },
                },
                X = q,
                z = (n('9319'), Object(_.a)(X, K, J, false, null, 'aeff23ce', null)),
                Y = z.exports,
                Z = n('5880'),
                Q = {
                    name: 'CheckDevice',
                    components: {
                        Loading: a.a,
                        NetworkCheck: P,
                        MicrophoneCheck: V,
                        CameraCheck: F,
                        SpeakerCheck: Y,
                    },
                    data: function () {
                        return {
                            isLoading: true,
                            currentStep: 0,
                            networkStatus: '',
                            microphoneStatus: '',
                            cameraStatus: '',
                            speakerStatus: '',
                            serviceData: null,
                            needCheckList: ['network', 'microphone', 'camera', 'speaker'],
                            showResult: false,
                            checkSuccessStatus: '',
                        }
                    },
                    computed: Object(c.a)(
                        {},
                        Object(Z.mapGetters)({ deviceCheckData: 'common/deviceCheckData' })
                    ),
                    beforeMount: function () {
                        var e = this
                        return Object(i.a)(
                            Object(s.a)().mark(function t() {
                                return Object(s.a)().wrap(function (t) {
                                    while (1) {
                                        switch ((t.prev = t.next)) {
                                            case 0:
                                                if (
                                                    (console.info(
                                                        '对象函数 beforeMount,filePath:renderer/views/CheckDevice.vue'
                                                    ),
                                                        (e.serviceData = e.deviceCheckData),
                                                        e.serviceData)
                                                ) {
                                                    t.next = 5
                                                    break
                                                }
                                                return (t.next = 5), e.getDeviceCheckData()
                                            case 5:
                                            case 'end':
                                                return t.stop()
                                        }
                                    }
                                }, t)
                            })
                        )()
                    },
                    mounted: function () {
                        var e = this
                        this.updateHeaderAttr()
                        this.$bus.$on('finishedDeviceCheck', function () {
                            console.info(
                                '箭头函数 监听 finishedDeviceCheck,filePath:renderer/views/CheckDevice.vue'
                            )
                            e.showResult = true
                            e.checkSuccessStatus =
                                'finish' === e.networkStatus &&
                                'finish' === e.microphoneStatus &&
                                'finish' === e.cameraStatus &&
                                'finish' === e.speakerStatus
                            e.$sensors.track('pc_device_test_check', {
                                result: e.checkSuccessStatus ? 'success' : 'fail',
                                networkStatus: e.networkStatus,
                                cameraStatus: e.cameraStatus,
                                microphoneStatus: e.microphoneStatus,
                                speakerStatus: e.speakerStatus,
                            })
                        })
                        this.isLoading = false
                    },
                    methods: {
                        updateHeaderAttr: function () {
                            console.info(
                                '对象函数 updateHeaderAttr,filePath:renderer/views/CheckDevice.vue'
                            )
                            this.$bus.$emit('updateHeaderAttr', {
                                title: this.$t('setting.menus.checkDevice'),
                                showGoback: true,
                                backUrl: '/courses',
                            })
                        },
                        getDeviceCheckData: function () {
                            var e = this
                            return Object(i.a)(
                                Object(s.a)().mark(function t() {
                                    var n
                                    return Object(s.a)().wrap(function (t) {
                                        while (1) {
                                            switch ((t.prev = t.next)) {
                                                case 0:
                                                    return (
                                                        console.info(
                                                            '对象函数 getDeviceCheckData,filePath:renderer/views/CheckDevice.vue'
                                                        ),
                                                        (t.next = 3),
                                                        Object(h.d)()
                                                    )
                                                case 3:
                                                    if (
                                                        ((n = t.sent),
                                                            0 !==
                                                            (null === n || void 0 === n ? void 0 : n.code))
                                                    ) {
                                                        t.next = 7
                                                        break
                                                    }
                                                    return (
                                                        console.info(
                                                            'if(res?.code === 0)为true触发return,path: /renderer/views/CheckDevice.vue'
                                                        ),
                                                        t.abrupt(
                                                            'return',
                                                            (e.serviceData =
                                                                null === n || void 0 === n ? void 0 : n.data)
                                                        )
                                                    )
                                                case 7:
                                                    e.$Modal.warning({
                                                        centered: true,
                                                        class: 'modal-simple modal-service-data',
                                                        content: e.$t(
                                                            'common.components.errorStatus.message'
                                                        ),
                                                        width: '380px',
                                                        okText: e.$t('common.gotIt'),
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
                        nextCheck: function () {
                            console.info(
                                '对象函数 nextCheck,filePath:renderer/views/CheckDevice.vue'
                            )
                            this.currentStep++
                            var e = this.needCheckList[this.currentStep]
                            this[''.concat(e, 'Status')] = 'process'
                        },
                        changeStepStatus: function (e, t) {
                            console.info(
                                '对象函数 changeStepStatus(status, type)',
                                e,
                                t,
                                'filePath:renderer/views/CheckDevice.vue'
                            )
                            this[''.concat(t, 'Status')] = e
                        },
                        goBack: function () {
                            console.info(
                                '对象函数 goBack,filePath:renderer/views/CheckDevice.vue'
                            )
                            this.$router.push('/courses')
                        },
                    },
                    beforeDestroy: function () {
                        console.info(
                            '对象函数 beforeDestroy,filePath:renderer/views/CheckDevice.vue'
                        )
                        this.networkStatus = ''
                    },
                },
                ee = Q,
                te =
                    (n('9c69'),
                        n('0570'),
                        Object(_.a)(ee, o, r, false, null, '70af3cb8', null))
            t.default = te.exports
        },
        '3ba6': function (e, t, n) {
            'use strict'
            Object.defineProperty(t, '__esModule', { value: true })
            t.SIGRTMAX = t.getRealtimeSignals = void 0
            const o = function () {
                const e = 31
                return Array.from({ length: e }, r)
            }
            t.getRealtimeSignals = o
            const r = function (e, t) {
                return {
                    name: 'SIGRT' + (t + 1),
                    number: 34 + t,
                    action: 'terminate',
                    description: 'Application-specific signal (realtime)',
                    standard: 'posix',
                }
            }
            t.SIGRTMAX = 64
        },
        '3d44': function (e, t, n) {
            'use strict'
            const o = n('9569'),
                r = new WeakMap(),
                s = (e, t = {}) => {
                    if ('function' !== typeof e) {
                        throw new TypeError('Expected a function')
                    }
                    let n,
                        s = 0
                    const i = e.displayName || e.name || '<anonymous>',
                        c = function (...o) {
                            if ((r.set(c, ++s), 1 === s)) {
                                n = e.apply(this, o)
                                e = null
                            } else {
                                if (true === t.throw) {
                                    throw new Error(`Function \`${i}\` can only be called once`)
                                }
                            }
                            return n
                        }
                    return o(c, e), r.set(c, s), c
                }
            e.exports = s
            e.exports.default = s
            e.exports.callCount = (e) => {
                if (!r.has(e)) {
                    throw new Error(
                        `The given function \`${e.name}\` is not wrapped by the \`onetime\` package`
                    )
                }
                return r.get(e)
            }
        },
        '40fd': function (e, t, n) {
            e.exports = n.p + 'static/media/speaker.8df209e4.mp3'
        },
        '54b9': function (e, t, n) { },
        5528: function (e, t, n) {
            'use strict'
            const o = n('d010'),
                r = n('68c7'),
                s = n('b72c'),
                i = (e, t) => {
                    void 0 !== t &&
                        void 0 !== e.stdin &&
                        (o(t) ? t.pipe(e.stdin) : e.stdin.end(t))
                },
                c = (e, { all: t }) => {
                    if (!t || (!e.stdout && !e.stderr)) {
                        return
                    }
                    const n = s()
                    return e.stdout && n.add(e.stdout), e.stderr && n.add(e.stderr), n
                },
                a = async (e, t) => {
                    if (e) {
                        e.destroy()
                        try {
                            return await t
                        } catch (n) {
                            return n.bufferedData
                        }
                    }
                },
                u = (e, { encoding: t, buffer: n, maxBuffer: o }) => {
                    if (e && n) {
                        return t
                            ? r(e, {
                                encoding: t,
                                maxBuffer: o,
                            })
                            : r.buffer(e, { maxBuffer: o })
                    }
                },
                l = async (
                    { stdout: e, stderr: t, all: n },
                    { encoding: o, buffer: r, maxBuffer: s },
                    i
                ) => {
                    const c = u(e, {
                        encoding: o,
                        buffer: r,
                        maxBuffer: s,
                    }),
                        l = u(t, {
                            encoding: o,
                            buffer: r,
                            maxBuffer: s,
                        }),
                        d = u(n, {
                            encoding: o,
                            buffer: r,
                            maxBuffer: 2 * s,
                        })
                    try {
                        return await Promise.all([i, c, l, d])
                    } catch (h) {
                        return Promise.all([
                            {
                                error: h,
                                signal: h.signal,
                                timedOut: h.timedOut,
                            },
                            a(e, c),
                            a(t, l),
                            a(n, d),
                        ])
                    }
                },
                d = ({ input: e }) => {
                    if (o(e)) {
                        throw new TypeError(
                            'The `input` option cannot be a stream in sync mode'
                        )
                    }
                }
            e.exports = {
                handleInput: i,
                makeAllStream: c,
                getSpawnedResult: l,
                validateInputSync: d,
            }
        },
        '566b': function (e, t, n) {
            var o = n('d633')
            function r(e) {
                var t = function () {
                    return t.called
                        ? t.value
                        : ((t.called = true), (t.value = e.apply(this, arguments)))
                }
                return (t.called = false), t
            }
            function s(e) {
                var t = function () {
                    if (t.called) {
                        throw new Error(t.onceError)
                    }
                    return (t.called = true), (t.value = e.apply(this, arguments))
                },
                    n = e.name || 'Function wrapped with `once`'
                return (
                    (t.onceError = n + " shouldn't be called more than once"),
                    (t.called = false),
                    t
                )
            }
            e.exports = o(r)
            e.exports.strict = o(s)
            r.proto = r(function () {
                Object.defineProperty(Function.prototype, 'once', {
                    value: function () {
                        return r(this)
                    },
                    configurable: true,
                })
                Object.defineProperty(Function.prototype, 'onceStrict', {
                    value: function () {
                        return s(this)
                    },
                    configurable: true,
                })
            })
        },
        '578e': function (e, t, n) {
            'use strict'
            Object.defineProperty(t, '__esModule', { value: true })
            t.signalsByNumber = t.signalsByName = void 0
            var o = n('8e57'),
                r = n('2678'),
                s = n('3ba6')
            const i = function () {
                const e = (0, r.getSignals)()
                return e.reduce(c, {})
            },
                c = function (
                    e,
                    {
                        name: t,
                        number: n,
                        description: o,
                        supported: r,
                        action: s,
                        forced: i,
                        standard: c,
                    }
                ) {
                    return {
                        ...e,
                        [t]: {
                            name: t,
                            number: n,
                            description: o,
                            supported: r,
                            action: s,
                            forced: i,
                            standard: c,
                        },
                    }
                },
                a = i()
            t.signalsByName = a
            const u = function () {
                const e = (0, r.getSignals)(),
                    t = s.SIGRTMAX + 1,
                    n = Array.from({ length: t }, (t, n) => l(n, e))
                return Object.assign({}, ...n)
            },
                l = function (e, t) {
                    const n = d(e, t)
                    if (void 0 === n) {
                        return {}
                    }
                    const {
                        name: o,
                        description: r,
                        supported: s,
                        action: i,
                        forced: c,
                        standard: a,
                    } = n
                    return {
                        [e]: {
                            name: o,
                            number: e,
                            description: r,
                            supported: s,
                            action: i,
                            forced: c,
                            standard: a,
                        },
                    }
                },
                d = function (e, t) {
                    const n = t.find(({ name: t }) => o.constants.signals[t] === e)
                    return void 0 !== n ? n : t.find((t) => t.number === e)
                },
                h = u()
            t.signalsByNumber = h
        },
        '5a1a': function (e, t, n) {
            'use strict'
            const o = n('a32b'),
                r = n('68f5'),
                s = n('8fa8'),
                i = n('9083'),
                c = 'win32' === process.platform
            function l(e) {
                e.file = r(e)
                const t = e.file && i(e.file)
                return t ? (e.args.unshift(e.file), (e.command = t), r(e)) : e.file
            }
            function d(e) {
                if (!c) {
                    return e
                }
                const t = l(e),
                    n = !/\.(?:com|exe)$/i.test(t)
                if (e.options.forceShell || n) {
                    const n = /node_modules[\\/].bin[\\/][^\\/]+\.cmd$/i.test(t)
                    e.command = o.normalize(e.command)
                    e.command = s.command(e.command)
                    e.args = e.args.map((e) => s.argument(e, n))
                    const r = [e.command].concat(e.args).join(' ')
                    e.args = ['/d', '/s', '/c', `"${r}"`]
                    e.command =
                        Object({
                            VUE_APP_MODE: 'production',
                            VUE_APP_URL_ONE: 'https://one.thethinkacademy.com',
                            VUE_APP_URL_OVERSEA: 'https://oversea-api.thethinkacademy.com',
                            VUE_APP_LIVE_CLASS_RTMP_DISPATCH: 'videogslb.thethinkacademy.com',
                            VUE_APP_H5_URL: 'https://student-h5.thethinkacademy.com',
                            NODE_ENV: 'production',
                            VUE_APP_RELEASE_VERSION:
                                '75700b875603b2d2a7a1d9d59b11609d175f79e9',
                            BASE_URL: '/',
                            IS_ELECTRON: true,
                        }).comspec || 'cmd.exe'
                    e.options.windowsVerbatimArguments = true
                }
                return e
            }
            function h(e, t, n) {
                t && !Array.isArray(t) && ((n = t), (t = null))
                t = t ? t.slice(0) : []
                n = Object.assign({}, n)
                const o = {
                    command: e,
                    args: t,
                    options: n,
                    file: void 0,
                    original: {
                        command: e,
                        args: t,
                    },
                }
                return n.shell ? o : d(o)
            }
            e.exports = h
        },
        '5bc3': function (e, t, n) {
            var o = n('a395')
            function r(e, t) {
                for (var n = 0; n < t.length; n++) {
                    var r = t[n]
                    r.enumerable = r.enumerable || false
                    r.configurable = true
                    'value' in r && (r.writable = true)
                    Object.defineProperty(e, o(r.key), r)
                }
            }
            function s(e, t, n) {
                return (
                    t && r(e.prototype, t),
                    n && r(e, n),
                    Object.defineProperty(e, 'prototype', { writable: false }),
                    e
                )
            }
            e.exports = s
            e.exports.__esModule = true
            e.exports.default = e.exports
        },
        '5e36': function (e, t, n) {
            'use strict'
            n.d(t, 'a', function () {
                return o
            })
            var o = [
                'take_picture',
                'random_video_mic',
                'sendGiftBarrage',
                'vote_data',
                'video_mic',
                'video_mic_f',
                'praise',
                'mult_video_mic',
                'redPacket',
                'red_packet_rain',
                'openGift',
                'vote',
                'classRest',
                'interact',
                'game_interact',
                'fill_blank',
                'nonpreset_fill_blank',
                'class_praise_list',
                'random_call',
                'graffiti_board',
                'speech_interact',
                'classroom_praise',
                'distribute_coins',
                'student_rank',
                'allow_open_microphone',
                'countDown',
                'class_examination',
                'small_random_call',
                'speedyHand',
                'schulte_table',
                'ircTestKey',
                'ircCheckKV',
            ]
        },
        '5e8a': function (e, t, n) {
            'use strict'
            const r = (e, t = []) => (Array.isArray(t) ? [e, ...t].join(' ') : e),
                s = (e) => {
                    const t = []
                    for (const n of e.trim().split(/ +/g)) {
                        const e = t[t.length - 1]
                        e && e.endsWith('\\')
                            ? (t[t.length - 1] = `${e.slice(0, -1)} ${n}`)
                            : t.push(n)
                    }
                    return t
                }
            e.exports = {
                joinCommand: r,
                parseCommand: s,
            }
        },
        '67dd': function (e, t, n) { },
        '68c7': function (e, t, n) {
            'use strict'
            const { constants: o } = n('3646'),
                r = n('6f59'),
                s = n('8b3a')
            class i extends Error {
                constructor() {
                    super('maxBuffer exceeded')
                    this.name = 'MaxBufferError'
                }
            }
            async function c(e, t) {
                if (!e) {
                    return Promise.reject(new Error('Expected a stream'))
                }
                t = {
                    maxBuffer: 1e400,
                    ...t,
                }
                const { maxBuffer: n } = t
                let c
                return (
                    await new Promise((a, u) => {
                        const l = (e) => {
                            e &&
                                c.getBufferedLength() <= o.MAX_LENGTH &&
                                (e.bufferedData = c.getBufferedValue())
                            u(e)
                        }
                        c = r(e, s(t), (e) => {
                            e ? l(e) : a()
                        })
                        c.on('data', () => {
                            c.getBufferedLength() > n && l(new i())
                        })
                    }),
                    c.getBufferedValue()
                )
            }
            e.exports = c
            e.exports.default = c
            e.exports.buffer = (e, t) =>
                c(e, {
                    ...t,
                    encoding: 'buffer',
                })
            e.exports.array = (e, t) =>
                c(e, {
                    ...t,
                    array: true,
                })
            e.exports.MaxBufferError = i
        },
        '68f5': function (e, t, n) {
            'use strict'
            const o = n('a32b'),
                r = n('b9bb'),
                s = n('b9bd')
            function i(e, t) {
                const n =
                    e.options.env ||
                    Object({
                        VUE_APP_MODE: 'production',
                        VUE_APP_URL_ONE: 'https://one.thethinkacademy.com',
                        VUE_APP_URL_OVERSEA: 'https://oversea-api.thethinkacademy.com',
                        VUE_APP_LIVE_CLASS_RTMP_DISPATCH: 'videogslb.thethinkacademy.com',
                        VUE_APP_H5_URL: 'https://student-h5.thethinkacademy.com',
                        NODE_ENV: 'production',
                        VUE_APP_RELEASE_VERSION:
                            '75700b875603b2d2a7a1d9d59b11609d175f79e9',
                        BASE_URL: '/',
                        IS_ELECTRON: true,
                    }),
                    i = process.cwd(),
                    c = null != e.options.cwd,
                    a = c && void 0 !== process.chdir && !process.chdir.disabled
                if (a) {
                    try {
                        process.chdir(e.options.cwd)
                    } catch (l) { }
                }
                let u
                try {
                    u = r.sync(e.command, {
                        path: n[s({ env: n })],
                        pathExt: t ? o.delimiter : void 0,
                    })
                } catch (d) {
                } finally {
                    a && process.chdir(i)
                }
                return u && (u = o.resolve(c ? e.options.cwd : '', u)), u
            }
            function c(e) {
                return i(e) || i(e, true)
            }
            e.exports = c
        },
        '6b58': function (e, t, n) {
            n('d9e2')
            var o = n('7037').default,
                r = n('3c96')
            function s(e, t) {
                if (t && ('object' === o(t) || 'function' === typeof t)) {
                    return t
                }
                if (void 0 !== t) {
                    throw new TypeError(
                        'Derived constructors may only return object or undefined'
                    )
                }
                return r(e)
            }
            e.exports = s
            e.exports.__esModule = true
            e.exports.default = e.exports
        },
        '6e2d': function (e, t, n) {
            'use strict'
            const o = n('a32b'),
                r = n('41db'),
                s = n('8c6f'),
                i = n('fcb5'),
                c = n('89b6'),
                a = n('3d44'),
                u = n('74be'),
                l = n('8c52'),
                {
                    spawnedKill: d,
                    spawnedCancel: h,
                    setupTimeout: m,
                    setExitHandler: p,
                } = n('71ae'),
                {
                    handleInput: f,
                    getSpawnedResult: v,
                    makeAllStream: k,
                    validateInputSync: g,
                } = n('5528'),
                { mergePromise: b, getSpawnedPromise: _ } = n('182b'),
                { joinCommand: S, parseCommand: C } = n('5e8a'),
                w = ({
                    env: e,
                    extendEnv: t,
                    preferLocal: n,
                    localDir: o,
                    execPath: r,
                }) => {
                    const s = t
                        ? {
                            ...Object({
                                VUE_APP_MODE: 'production',
                                VUE_APP_URL_ONE: 'https://one.thethinkacademy.com',
                                VUE_APP_URL_OVERSEA:
                                    'https://oversea-api.thethinkacademy.com',
                                VUE_APP_LIVE_CLASS_RTMP_DISPATCH:
                                    'videogslb.thethinkacademy.com',
                                VUE_APP_H5_URL: 'https://student-h5.thethinkacademy.com',
                                NODE_ENV: 'production',
                                VUE_APP_RELEASE_VERSION:
                                    '75700b875603b2d2a7a1d9d59b11609d175f79e9',
                                BASE_URL: '/',
                                IS_ELECTRON: true,
                            }),
                            ...e,
                        }
                        : e
                    return n
                        ? c.env({
                            env: s,
                            cwd: o,
                            execPath: r,
                        })
                        : s
                },
                E = (e, t, n = {}) => {
                    const r = s._parse(e, t, n)
                    return (
                        (e = r.command),
                        (t = r.args),
                        (n = r.options),
                        (n = {
                            maxBuffer: 100000000,
                            buffer: true,
                            stripFinalNewline: true,
                            extendEnv: true,
                            preferLocal: false,
                            localDir: n.cwd || process.cwd(),
                            execPath: process.execPath,
                            encoding: 'utf8',
                            reject: true,
                            cleanup: true,
                            all: false,
                            windowsHide: true,
                            ...n,
                        }),
                        (n.env = w(n)),
                        (n.stdio = l(n)),
                        'win32' === process.platform &&
                        'cmd' === o.basename(e, '.exe') &&
                        t.unshift('/q'),
                        {
                            file: e,
                            args: t,
                            options: n,
                            parsed: r,
                        }
                    )
                },
                P = (e, t, n) =>
                    'string' === typeof t || Buffer.isBuffer(t)
                        ? e.stripFinalNewline
                            ? i(t)
                            : t
                        : void 0 === n
                            ? void 0
                            : '',
                x = (e, t, n) => {
                    const o = E(e, t, n),
                        i = S(e, t)
                    let c
                    try {
                        c = r.spawn(o.file, o.args, o.options)
                    } catch (I) {
                        const e = new r.ChildProcess(),
                            t = Promise.reject(
                                u({
                                    error: I,
                                    stdout: '',
                                    stderr: '',
                                    all: '',
                                    command: i,
                                    parsed: o,
                                    timedOut: false,
                                    isCanceled: false,
                                    killed: false,
                                })
                            )
                        return b(e, t)
                    }
                    const l = _(c),
                        g = m(c, o.options, l),
                        C = p(c, o.options, g)
                    c.kill = d.bind(null, c.kill.bind(c))
                    c.cancel = h.bind(null, c, y)
                    const w = async () => {
                        const [
                            { error: e, exitCode: t, signal: n, timedOut: r },
                            s,
                            a,
                            l,
                        ] = await v(c, o.options, C),
                            d = P(o.options, s),
                            h = P(o.options, a),
                            m = P(o.options, l)
                        if (e || 0 !== t || null !== n) {
                            const s = u({
                                error: e,
                                exitCode: t,
                                signal: n,
                                stdout: d,
                                stderr: h,
                                all: m,
                                command: i,
                                parsed: o,
                                timedOut: r,
                                isCanceled: false,
                                killed: c.killed,
                            })
                            if (!o.options.reject) {
                                return s
                            }
                            throw s
                        }
                        return {
                            command: i,
                            exitCode: 0,
                            stdout: d,
                            stderr: h,
                            all: m,
                            failed: false,
                            timedOut: false,
                            isCanceled: false,
                            killed: false,
                        }
                    },
                        x = a(w)
                    return (
                        s._enoent.hookChildProcess(c, o.parsed),
                        f(c, o.options.input),
                        (c.all = k(c, o.options)),
                        b(c, x)
                    )
                }
            e.exports = x
            e.exports.sync = (e, t, n) => {
                const o = E(e, t, n),
                    s = S(e, t)
                let i
                g(o.options)
                try {
                    i = r.spawnSync(o.file, o.args, o.options)
                } catch (l) {
                    throw u({
                        error: l,
                        stdout: '',
                        stderr: '',
                        all: '',
                        command: s,
                        parsed: o,
                        timedOut: false,
                        isCanceled: false,
                        killed: false,
                    })
                }
                const c = P(o.options, i.stdout, i.error),
                    a = P(o.options, i.stderr, i.error)
                if (i.error || 0 !== i.status || null !== i.signal) {
                    const e = u({
                        stdout: c,
                        stderr: a,
                        error: i.error,
                        signal: i.signal,
                        exitCode: i.status,
                        command: s,
                        parsed: o,
                        timedOut: i.error && 'ETIMEDOUT' === i.error.code,
                        isCanceled: false,
                        killed: null !== i.signal,
                    })
                    if (!o.options.reject) {
                        return e
                    }
                    throw e
                }
                return {
                    command: s,
                    exitCode: 0,
                    stdout: c,
                    stderr: a,
                    failed: false,
                    timedOut: false,
                    isCanceled: false,
                    killed: false,
                }
            }
            e.exports.command = (e, t) => {
                const [n, ...o] = C(e)
                return x(n, o, t)
            }
            e.exports.commandSync = (e, t) => {
                const [n, ...o] = C(e)
                return x.sync(n, o, t)
            }
            e.exports.node = (e, t, n = {}) => {
                t && !Array.isArray(t) && 'object' === typeof t && ((n = t), (t = []))
                const o = l.node(n),
                    r = process.execArgv.filter((e) => !e.startsWith('--inspect')),
                    { nodePath: s = process.execPath, nodeOptions: i = r } = n
                return x(s, [...i, e, ...(Array.isArray(t) ? t : [])], {
                    ...n,
                    stdin: void 0,
                    stdout: void 0,
                    stderr: void 0,
                    stdio: o,
                    shell: false,
                })
            }
        },
        '6ee1': function (e, t, n) {
            var o = global.process
            const r = function (e) {
                return (
                    e &&
                    'object' === typeof e &&
                    'function' === typeof e.removeListener &&
                    'function' === typeof e.emit &&
                    'function' === typeof e.reallyExit &&
                    'function' === typeof e.listeners &&
                    'function' === typeof e.kill &&
                    'number' === typeof e.pid &&
                    'function' === typeof e.on
                )
            }
            if (r(o)) {
                var s,
                    i = n('42cd'),
                    c = n('c7ef'),
                    a = /^win/i.test(o.platform),
                    u = n('ff4a')
                'function' !== typeof u && (u = u.EventEmitter)
                o.__signal_exit_emitter__
                    ? (s = o.__signal_exit_emitter__)
                    : ((s = o.__signal_exit_emitter__ = new u()),
                        (s.count = 0),
                        (s.emitted = {}))
                s.infinite || (s.setMaxListeners(1e400), (s.infinite = true))
                e.exports = function (e, t) {
                    if (!r(global.process)) {
                        return function () { }
                    }
                    i.equal(
                        typeof e,
                        'function',
                        'a callback must be provided for exit handler'
                    )
                    false === m && p()
                    var n = 'exit'
                    t && t.alwaysLast && (n = 'afterexit')
                    var o = function () {
                        s.removeListener(n, e)
                        0 === s.listeners('exit').length &&
                            0 === s.listeners('afterexit').length &&
                            l()
                    }
                    return s.on(n, e), o
                }
                var l = function () {
                    m &&
                        r(global.process) &&
                        ((m = false),
                            c.forEach(function (e) {
                                try {
                                    o.removeListener(e, h[e])
                                } catch (t) { }
                            }),
                            (o.emit = k),
                            (o.reallyExit = f),
                            (s.count -= 1))
                }
                e.exports.unload = l
                var d = function (e, t, n) {
                    s.emitted[e] || ((s.emitted[e] = true), s.emit(e, t, n))
                },
                    h = {
                        e: function () {
                            if (r(global.process)) {
                                var t = o.listeners(e)
                                t.length === s.count &&
                                    (l(),
                                        d('exit', null, e),
                                        d('afterexit', null, e),
                                        a && 'SIGHUP' === e && (e = 'SIGINT'),
                                        o.kill(o.pid, e))
                            }
                        },
                    }
                c.forEach(function (e) { })
                e.exports.signals = function () {
                    return c
                }
                var m = false,
                    p = function () {
                        !m &&
                            r(global.process) &&
                            ((m = true),
                                (s.count += 1),
                                (c = c.filter(function (e) {
                                    try {
                                        return o.on(e, h[e]), true
                                    } catch (t) {
                                        return false
                                    }
                                })),
                                (o.emit = g),
                                (o.reallyExit = v))
                    }
                e.exports.load = p
                var f = o.reallyExit,
                    v = function (e) {
                        r(global.process) &&
                            ((o.exitCode = e || 0),
                                d('exit', o.exitCode, null),
                                d('afterexit', o.exitCode, null),
                                f.call(o, o.exitCode))
                    },
                    k = o.emit,
                    g = function (e, t) {
                        if ('exit' === e && r(global.process)) {
                            void 0 !== t && (o.exitCode = t)
                            var n = k.apply(this, arguments)
                            return (
                                d('exit', o.exitCode, null), d('afterexit', o.exitCode, null), n
                            )
                        }
                        return k.apply(this, arguments)
                    }
            } else {
                e.exports = function () {
                    return function () { }
                }
            }
        },
        '6f59': function (e, t, n) {
            var o = n('566b'),
                r = n('ab52'),
                s = n('9b0f'),
                i = function () { },
                c = /^v?\.0/.test(process.version),
                a = function (e) {
                    return 'function' === typeof e
                },
                u = function (e) {
                    return (
                        !!c &&
                        !!s &&
                        (e instanceof (s.ReadStream || i) ||
                            e instanceof (s.WriteStream || i)) &&
                        a(e.close)
                    )
                },
                l = function (e) {
                    return e.setHeader && a(e.abort)
                },
                d = function (e, t, n, s) {
                    s = o(s)
                    var c = false
                    e.on('close', function () {
                        c = true
                    })
                    r(
                        e,
                        {
                            readable: t,
                            writable: n,
                        },
                        function (e) {
                            if (e) {
                                return s(e)
                            }
                            c = true
                            s()
                        }
                    )
                    var d = false
                    return function (t) {
                        if (!c && !d) {
                            return (
                                (d = true),
                                u(e)
                                    ? e.close(i)
                                    : l(e)
                                        ? e.abort()
                                        : a(e.destroy)
                                            ? e.destroy()
                                            : void s(t || new Error('stream was destroyed'))
                            )
                        }
                    }
                },
                h = function (e) {
                    e()
                },
                m = function (e, t) {
                    return e.pipe(t)
                },
                p = function () {
                    var e,
                        t = Array.prototype.slice.call(arguments),
                        n = (a(t[t.length - 1] || i) && t.pop()) || i
                    if ((Array.isArray(t[0]) && (t = t[0]), t.length < 2)) {
                        throw new Error('pump requires two streams per minimum')
                    }
                    var o = t.map(function (r, s) {
                        var i = s < t.length - 1,
                            c = s > 0
                        return d(r, i, c, function (t) {
                            e || (e = t)
                            t && o.forEach(h)
                            i || (o.forEach(h), n(e))
                        })
                    })
                    return t.reduce(m)
                }
            e.exports = p
        },
        7037: function (e, t, n) {
            function o(t) {
                return (
                    (e.exports = o =
                        'function' == typeof Symbol && 'symbol' == typeof Symbol.iterator
                            ? function (e) {
                                return typeof e
                            }
                            : function (e) {
                                return e &&
                                    'function' == typeof Symbol &&
                                    e.constructor === Symbol &&
                                    e !== Symbol.prototype
                                    ? 'symbol'
                                    : typeof e
                            }),
                    (e.exports.__esModule = true),
                    (e.exports.default = e.exports),
                    o(t)
                )
            }
            n('a4d3')
            n('e01a')
            n('d3b7')
            n('d28b')
            n('e260')
            n('3ca3')
            n('ddb0')
            e.exports = o
            e.exports.__esModule = true
            e.exports.default = e.exports
        },
        '71ae': function (e, t, n) {
            'use strict'
            const o = n('8e57'),
                r = n('6ee1'),
                i = (e, t = 'SIGTERM', n = {}) => {
                    const o = e(t)
                    return c(e, t, n, o), o
                },
                c = (e, t, n, o) => {
                    if (!a(t, n, o)) {
                        return
                    }
                    const r = l(n),
                        s = setTimeout(() => {
                            e('SIGKILL')
                        }, r)
                    s.unref && s.unref()
                },
                a = (e, { forceKillAfterTimeout: t }, n) => u(e) && false !== t && n,
                u = (e) =>
                    e === o.constants.signals.SIGTERM ||
                    ('string' === typeof e && 'SIGTERM' === e.toUpperCase()),
                l = ({ forceKillAfterTimeout: e = true }) => {
                    if (true === e) {
                        return 5000
                    }
                    if (!Number.isFinite(e) || e < 0) {
                        throw new TypeError(
                            `Expected the \`forceKillAfterTimeout\` option to be a non-negative integer, got \`${e}\` (${typeof e})`
                        )
                    }
                    return e
                },
                d = (e, t) => {
                    const n = e.kill()
                    n && (t.isCanceled = true)
                },
                h = (e, t, n) => {
                    e.kill(t)
                    n(
                        Object.assign(new Error('Timed out'), {
                            timedOut: true,
                            signal: t,
                        })
                    )
                },
                m = (e, { timeout: t, killSignal: n = 'SIGTERM' }, o) => {
                    if (0 === t || void 0 === t) {
                        return o
                    }
                    if (!Number.isFinite(t) || t < 0) {
                        throw new TypeError(
                            `Expected the \`timeout\` option to be a non-negative integer, got \`${t}\` (${typeof t})`
                        )
                    }
                    let r
                    const s = new Promise((o, s) => {
                        r = setTimeout(() => {
                            h(e, n, s)
                        }, t)
                    }),
                        i = o.finally(() => {
                            clearTimeout(r)
                        })
                    return Promise.race([s, i])
                },
                p = async (e, { cleanup: t, detached: n }, o) => {
                    if (!t || n) {
                        return o
                    }
                    const s = r(() => {
                        e.kill()
                    })
                    return o.finally(() => {
                        s()
                    })
                }
            e.exports = {
                spawnedKill: i,
                spawnedCancel: d,
                setupTimeout: m,
                setExitHandler: p,
            }
        },
        '74be': function (e, t, n) {
            'use strict'
            const { signalsByName: o } = n('578e'),
                r = ({
                    timedOut: e,
                    timeout: t,
                    errorCode: n,
                    signal: o,
                    signalDescription: r,
                    exitCode: s,
                    isCanceled: i,
                }) =>
                    e
                        ? `timed out after ${t} milliseconds`
                        : i
                            ? 'was canceled'
                            : void 0 !== n
                                ? 'failed with ' + n
                                : void 0 !== o
                                    ? `was killed with ${o} (${r})`
                                    : void 0 !== s
                                        ? 'failed with exit code ' + s
                                        : 'failed',
                s = ({
                    stdout: e,
                    stderr: t,
                    all: n,
                    error: s,
                    signal: i,
                    exitCode: c,
                    command: a,
                    timedOut: u,
                    isCanceled: l,
                    killed: d,
                    parsed: {
                        options: { timeout: h },
                    },
                }) => {
                    c = null === c ? void 0 : c
                    i = null === i ? void 0 : i
                    const m = void 0 === i ? void 0 : o[i].description,
                        p = s && s.code,
                        f = r({
                            timedOut: u,
                            timeout: h,
                            errorCode: p,
                            signal: i,
                            signalDescription: m,
                            exitCode: c,
                            isCanceled: l,
                        }),
                        v = `Command ${f}: ${a}`,
                        k = '[object Error]' === Object.prototype.toString.call(s),
                        g = k ? `${v}\n${s.message}` : v,
                        b = [g, t, e].filter(Boolean).join('\n')
                    return (
                        k
                            ? ((s.originalMessage = s.message), (s.message = b))
                            : (s = new Error(b)),
                        (s.shortMessage = g),
                        (s.command = a),
                        (s.exitCode = c),
                        (s.signal = i),
                        (s.signalDescription = m),
                        (s.stdout = e),
                        (s.stderr = t),
                        void 0 !== n && (s.all = n),
                        'bufferedData' in s && delete s.bufferedData,
                        (s.failed = true),
                        (s.timedOut = Boolean(u)),
                        (s.isCanceled = l),
                        (s.killed = d && !u),
                        s
                    )
                }
            e.exports = s
        },
        '7ca1': function (e, t, n) { },
        '7fe3': function (e, t, n) {
            var o
            n('9b0f')
            function r(e, t, n) {
                if (('function' === typeof t && ((n = t), (t = {})), !n)) {
                    if ('function' !== typeof Promise) {
                        throw new TypeError('callback not provided')
                    }
                    return new Promise(function (n, o) {
                        r(e, t || {}, function (e, t) {
                            e ? o(e) : n(t)
                        })
                    })
                }
                o(e, t || {}, function (e, o) {
                    e &&
                        ('EACCES' === e.code || (t && t.ignoreErrors)) &&
                        ((e = null), (o = false))
                    n(e, o)
                })
            }
            function s(e, t) {
                try {
                    return o.sync(e, t || {})
                } catch (n) {
                    if ((t && t.ignoreErrors) || 'EACCES' === n.code) {
                        return false
                    }
                    throw n
                }
            }
            o =
                'win32' === process.platform || global.TESTING_WINDOWS
                    ? n('beae')
                    : n('a8c7')
            e.exports = r
            r.sync = s
        },
        '89b6': function (e, t, n) {
            'use strict'
            const o = n('a32b'),
                r = n('b9bd'),
                s = (e) => {
                    let t
                    e = {
                        cwd: process.cwd(),
                        path: Object({
                            VUE_APP_MODE: 'production',
                            VUE_APP_URL_ONE: 'https://one.thethinkacademy.com',
                            VUE_APP_URL_OVERSEA: 'https://oversea-api.thethinkacademy.com',
                            VUE_APP_LIVE_CLASS_RTMP_DISPATCH: 'videogslb.thethinkacademy.com',
                            VUE_APP_H5_URL: 'https://student-h5.thethinkacademy.com',
                            NODE_ENV: 'production',
                            VUE_APP_RELEASE_VERSION:
                                '75700b875603b2d2a7a1d9d59b11609d175f79e9',
                            BASE_URL: '/',
                            IS_ELECTRON: true,
                        })[r()],
                        execPath: process.execPath,
                        ...e,
                    }
                    let n = o.resolve(e.cwd)
                    const s = []
                    while (t !== n) {
                        s.push(o.join(n, 'node_modules/.bin'))
                        t = n
                        n = o.resolve(n, '..')
                    }
                    const i = o.resolve(e.cwd, e.execPath, '..')
                    return s.push(i), s.concat(e.path).join(o.delimiter)
                }
            e.exports = s
            e.exports.default = s
            e.exports.env = (t) => {
                t = {
                    env: Object({
                        VUE_APP_MODE: 'production',
                        VUE_APP_URL_ONE: 'https://one.thethinkacademy.com',
                        VUE_APP_URL_OVERSEA: 'https://oversea-api.thethinkacademy.com',
                        VUE_APP_LIVE_CLASS_RTMP_DISPATCH: 'videogslb.thethinkacademy.com',
                        VUE_APP_H5_URL: 'https://student-h5.thethinkacademy.com',
                        NODE_ENV: 'production',
                        VUE_APP_RELEASE_VERSION: '75700b875603b2d2a7a1d9d59b11609d175f79e9',
                        BASE_URL: '/',
                        IS_ELECTRON: true,
                    }),
                    ...t,
                }
                const n = { ...t.env },
                    o = r({ env: n })
                return (t.path = n[o]), (n[o] = e.exports(t)), n
            }
        },
        '8b3a': function (e, t, n) {
            'use strict'
            const { PassThrough: o } = n('9ac2')
            e.exports = (e) => {
                e = { ...e }
                const { array: t } = e
                let { encoding: n } = e
                const r = 'buffer' === n
                let s = false
                t ? (s = !(n || r)) : (n = n || 'utf8')
                r && (n = null)
                const i = new o({ objectMode: s })
                n && i.setEncoding(n)
                let c = 0
                const a = []
                return (
                    i.on('data', (e) => {
                        a.push(e)
                        s ? (c = a.length) : (c += e.length)
                    }),
                    (i.getBufferedValue = () =>
                        t ? a : r ? Buffer.concat(a, c) : a.join('')),
                    (i.getBufferedLength = () => c),
                    i
                )
            }
        },
        '8c52': function (e, t, n) {
            'use strict'
            const o = ['stdin', 'stdout', 'stderr'],
                r = (e) => o.some((t) => void 0 !== e[t]),
                s = (e) => {
                    if (!e) {
                        return
                    }
                    const { stdio: t } = e
                    if (void 0 === t) {
                        return o.map((t) => e[t])
                    }
                    if (r(e)) {
                        throw new Error(
                            "It's not possible to provide `stdio` in combination with one of " +
                            o.map((e) => `\`${e}\``).join(', ')
                        )
                    }
                    if ('string' === typeof t) {
                        return t
                    }
                    if (!Array.isArray(t)) {
                        throw new TypeError(
                            `Expected \`stdio\` to be of type \`string\` or \`Array\`, got \`${typeof t}\``
                        )
                    }
                    const n = Math.max(t.length, o.length)
                    return Array.from({ length: n }, (e, n) => t[n])
                }
            e.exports = s
            e.exports.node = (e) => {
                const t = s(e)
                return 'ipc' === t
                    ? 'ipc'
                    : void 0 === t || 'string' === typeof t
                        ? [t, t, t, 'ipc']
                        : t.includes('ipc')
                            ? t
                            : [...t, 'ipc']
            }
        },
        '8c6f': function (e, t, n) {
            'use strict'
            const o = n('41db'),
                r = n('5a1a'),
                s = n('dda8')
            function i(e, t, n) {
                const i = r(e, t, n),
                    c = o.spawn(i.command, i.args, i.options)
                return s.hookChildProcess(c, i), c
            }
            function c(e, t, n) {
                const i = r(e, t, n),
                    c = o.spawnSync(i.command, i.args, i.options)
                return (c.error = c.error || s.verifyENOENTSync(c.status, i)), c
            }
            e.exports = i
            e.exports.spawn = i
            e.exports.sync = c
            e.exports._parse = r
            e.exports._enoent = s
        },
        '8f6e': function (e, t, n) { },
        '8fa8': function (e, t, n) {
            'use strict'
            function r(e) {
                return (e = e.replace(/([()\][%!^"`<>&|;, *?])/g, '^$1')), e
            }
            function s(e, t) {
                return (
                    (e = '' + e),
                    (e = e.replace(/(\\*)"/g, '$1$1\\"')),
                    (e = e.replace(/(\\*)$/, '$1$1')),
                    (e = `"${e}"`),
                    (e = e.replace(/([()\][%!^"`<>&|;, *?])/g, '^$1')),
                    t && (e = e.replace(/([()\][%!^"`<>&|;, *?])/g, '^$1')),
                    e
                )
            }
            e.exports.command = r
            e.exports.argument = s
        },
        9083: function (e, t, n) {
            'use strict'
            const o = n('9b0f'),
                r = n('d72d')
            function s(e) {
                const n = Buffer.alloc(150)
                let s
                try {
                    s = o.openSync(e, 'r')
                    o.readSync(s, n, 0, 150, 0)
                    o.closeSync(s)
                } catch (i) { }
                return r(n.toString())
            }
            e.exports = s
        },
        9319: function (e, t, n) {
            'use strict'
            n('b95c')
        },
        9569: function (e, t, n) {
            'use strict'
            const o = (e, t) => {
                for (const n of Reflect.ownKeys(t))
                    Object.defineProperty(e, n, Object.getOwnPropertyDescriptor(t, n))
                return e
            }
            e.exports = o
            e.exports.default = o
        },
        '970b': function (e, t, n) {
            function o(e, t) {
                if (!(e instanceof t)) {
                    throw new TypeError('Cannot call a class as a function')
                }
            }
            n('d9e2')
            e.exports = o
            e.exports.__esModule = true
            e.exports.default = e.exports
        },
        9813: function (e, t, n) {
            'use strict'
            n('fbc4')
        },
        '98f3': function (e, t, n) {
            'use strict'
            n('67dd')
        },
        '9c69': function (e, t, n) {
            'use strict'
            n('54b9')
        },
        a395: function (e, t, n) {
            var o = n('7037').default,
                r = n('e50d')
            function s(e) {
                var t = r(e, 'string')
                return 'symbol' === o(t) ? t : String(t)
            }
            e.exports = s
            e.exports.__esModule = true
            e.exports.default = e.exports
        },
        a8c7: function (e, t, n) {
            e.exports = r
            r.sync = s
            var o = n('9b0f')
            function r(e, t, n) {
                o.stat(e, function (e, o) {
                    n(e, !e && i(o, t))
                })
            }
            function s(e, t) {
                return i(o.statSync(e), t)
            }
            function i(e, t) {
                return e.isFile() && c(e, t)
            }
            function c(e, t) {
                var n = e.mode,
                    o = e.uid,
                    r = e.gid,
                    s = void 0 !== t.uid ? t.uid : process.getuid && process.getuid(),
                    i = void 0 !== t.gid ? t.gid : process.getgid && process.getgid(),
                    c = parseInt('100', 8),
                    a = parseInt('010', 8),
                    u = parseInt('001', 8),
                    l = c | a,
                    d =
                        n & u ||
                        (n & a && r === i) ||
                        (n & c && o === s) ||
                        (n & l && 0 === s)
                return d
            }
        },
        ab52: function (e, t, n) {
            var o = n('566b'),
                r = function () { },
                s = function (e) {
                    return e.setHeader && 'function' === typeof e.abort
                },
                i = function (e) {
                    return e.stdio && Array.isArray(e.stdio) && 3 === e.stdio.length
                },
                c = function (e, t, n) {
                    if ('function' === typeof t) {
                        return c(e, null, t)
                    }
                    t || (t = {})
                    n = o(n || r)
                    var a = e._writableState,
                        u = e._readableState,
                        l = t.readable || (false !== t.readable && e.readable),
                        d = t.writable || (false !== t.writable && e.writable),
                        h = false,
                        m = function () {
                            e.writable || p()
                        },
                        p = function () {
                            d = false
                            l || n.call(e)
                        },
                        f = function () {
                            l = false
                            d || n.call(e)
                        },
                        v = function (t) {
                            n.call(e, t ? new Error('exited with error code: ' + t) : null)
                        },
                        k = function (t) {
                            n.call(e, t)
                        },
                        g = function () {
                            process.nextTick(b)
                        },
                        b = function () {
                            if (!h) {
                                return (!l || (u && u.ended && !u.destroyed)) &&
                                    (!d || (a && a.ended && !a.destroyed))
                                    ? void 0
                                    : n.call(e, new Error('premature close'))
                            }
                        },
                        _ = function () {
                            e.req.on('finish', p)
                        }
                    return (
                        s(e)
                            ? (e.on('complete', p),
                                e.on('abort', g),
                                e.req ? _() : e.on('request', _))
                            : d && !a && (e.on('end', m), e.on('close', m)),
                        i(e) && e.on('exit', v),
                        e.on('end', f),
                        e.on('finish', p),
                        false !== t.error && e.on('error', k),
                        e.on('close', g),
                        function () {
                            h = true
                            e.removeListener('complete', p)
                            e.removeListener('abort', g)
                            e.removeListener('request', _)
                            e.req && e.req.removeListener('finish', p)
                            e.removeListener('end', m)
                            e.removeListener('close', m)
                            e.removeListener('finish', p)
                            e.removeListener('exit', v)
                            e.removeListener('end', f)
                            e.removeListener('error', k)
                            e.removeListener('close', g)
                        }
                    )
                }
            e.exports = c
        },
        b72c: function (e, t, n) {
            'use strict'
            const { PassThrough: o } = n('9ac2')
            e.exports = function () {
                var e = [],
                    t = new o({ objectMode: true })
                return (
                    t.setMaxListeners(0),
                    (t.add = n),
                    (t.isEmpty = r),
                    t.on('unpipe', s),
                    Array.prototype.slice.call(arguments).forEach(n),
                    t
                )
                function n(o) {
                    return Array.isArray(o)
                        ? (o.forEach(n), this)
                        : (e.push(o),
                            o.once('end', s.bind(null, o)),
                            o.once('error', t.emit.bind(t, 'error')),
                            o.pipe(t, { end: false }),
                            this)
                }
                function r() {
                    return 0 == e.length
                }
                function s(n) {
                    e = e.filter(function (e) {
                        return e !== n
                    })
                    !e.length && t.readable && t.end()
                }
            }
        },
        b821: function (e, t, n) { },
        b95c: function (e, t, n) { },
        b9bb: function (e, t, n) {
            const o =
                'win32' === process.platform ||
                'cygwin' ===
                Object({
                    VUE_APP_MODE: 'production',
                    VUE_APP_URL_ONE: 'https://one.thethinkacademy.com',
                    VUE_APP_URL_OVERSEA: 'https://oversea-api.thethinkacademy.com',
                    VUE_APP_LIVE_CLASS_RTMP_DISPATCH: 'videogslb.thethinkacademy.com',
                    VUE_APP_H5_URL: 'https://student-h5.thethinkacademy.com',
                    NODE_ENV: 'production',
                    VUE_APP_RELEASE_VERSION:
                        '75700b875603b2d2a7a1d9d59b11609d175f79e9',
                    BASE_URL: '/',
                    IS_ELECTRON: true,
                }).OSTYPE ||
                'msys' ===
                Object({
                    VUE_APP_MODE: 'production',
                    VUE_APP_URL_ONE: 'https://one.thethinkacademy.com',
                    VUE_APP_URL_OVERSEA: 'https://oversea-api.thethinkacademy.com',
                    VUE_APP_LIVE_CLASS_RTMP_DISPATCH: 'videogslb.thethinkacademy.com',
                    VUE_APP_H5_URL: 'https://student-h5.thethinkacademy.com',
                    NODE_ENV: 'production',
                    VUE_APP_RELEASE_VERSION:
                        '75700b875603b2d2a7a1d9d59b11609d175f79e9',
                    BASE_URL: '/',
                    IS_ELECTRON: true,
                }).OSTYPE,
                r = n('a32b'),
                s = o ? ';' : ':',
                i = n('7fe3'),
                c = (e) =>
                    Object.assign(new Error('not found: ' + e), { code: 'ENOENT' }),
                a = (e, t) => {
                    const n = t.colon || s,
                        r =
                            e.match(/\//) || (o && e.match(/\\/))
                                ? ['']
                                : [
                                    ...(o ? [process.cwd()] : []),
                                    ...(
                                        t.path ||
                                        Object({
                                            VUE_APP_MODE: 'production',
                                            VUE_APP_URL_ONE: 'https://one.thethinkacademy.com',
                                            VUE_APP_URL_OVERSEA:
                                                'https://oversea-api.thethinkacademy.com',
                                            VUE_APP_LIVE_CLASS_RTMP_DISPATCH:
                                                'videogslb.thethinkacademy.com',
                                            VUE_APP_H5_URL:
                                                'https://student-h5.thethinkacademy.com',
                                            NODE_ENV: 'production',
                                            VUE_APP_RELEASE_VERSION:
                                                '75700b875603b2d2a7a1d9d59b11609d175f79e9',
                                            BASE_URL: '/',
                                            IS_ELECTRON: true,
                                        }).PATH ||
                                        ''
                                    ).split(n),
                                ],
                        i = o
                            ? t.pathExt ||
                            Object({
                                VUE_APP_MODE: 'production',
                                VUE_APP_URL_ONE: 'https://one.thethinkacademy.com',
                                VUE_APP_URL_OVERSEA:
                                    'https://oversea-api.thethinkacademy.com',
                                VUE_APP_LIVE_CLASS_RTMP_DISPATCH:
                                    'videogslb.thethinkacademy.com',
                                VUE_APP_H5_URL: 'https://student-h5.thethinkacademy.com',
                                NODE_ENV: 'production',
                                VUE_APP_RELEASE_VERSION:
                                    '75700b875603b2d2a7a1d9d59b11609d175f79e9',
                                BASE_URL: '/',
                                IS_ELECTRON: true,
                            }).PATHEXT ||
                            '.EXE;.CMD;.BAT;.COM'
                            : '',
                        c = o ? i.split(n) : ['']
                    return (
                        o && -1 !== e.indexOf('.') && '' !== c[0] && c.unshift(''),
                        {
                            pathEnv: r,
                            pathExt: c,
                            pathExtExe: i,
                        }
                    )
                },
                u = (e, t, n) => {
                    'function' === typeof t && ((n = t), (t = {}))
                    t || (t = {})
                    const { pathEnv: o, pathExt: s, pathExtExe: u } = a(e, t),
                        l = [],
                        d = (n) =>
                            new Promise((s, i) => {
                                if (n === o.length) {
                                    return t.all && l.length ? s(l) : i(c(e))
                                }
                                const a = o[n],
                                    u = /^".*"$/.test(a) ? a.slice(1, -1) : a,
                                    d = r.join(u, e),
                                    m = !u && /^\.[\\\/]/.test(e) ? e.slice(0, 2) + d : d
                                s(h(m, n, 0))
                            }),
                        h = (e, n, o) =>
                            new Promise((r, c) => {
                                if (o === s.length) {
                                    return r(d(n + 1))
                                }
                                const a = s[o]
                                i(e + a, { pathExt: u }, (s, i) => {
                                    if (!s && i) {
                                        if (!t.all) {
                                            return r(e + a)
                                        }
                                        l.push(e + a)
                                    }
                                    return r(h(e, n, o + 1))
                                })
                            })
                    return n ? d(0).then((e) => n(null, e), n) : d(0)
                },
                l = (e, t) => {
                    t = t || {}
                    const { pathEnv: n, pathExt: o, pathExtExe: s } = a(e, t),
                        u = []
                    for (let c = 0; c < n.length; c++) {
                        const a = n[c],
                            d = /^".*"$/.test(a) ? a.slice(1, -1) : a,
                            h = r.join(d, e),
                            m = !d && /^\.[\\\/]/.test(e) ? e.slice(0, 2) + h : h
                        for (let e = 0; e < o.length; e++) {
                            const n = m + o[e]
                            try {
                                const e = i.sync(n, { pathExt: s })
                                if (e) {
                                    if (!t.all) {
                                        return n
                                    }
                                    u.push(n)
                                }
                            } catch (l) { }
                        }
                    }
                    if (t.all && u.length) {
                        return u
                    }
                    if (t.nothrow) {
                        return null
                    }
                    throw c(e)
                }
            e.exports = u
            u.sync = l
        },
        b9bd: function (e, t, n) {
            'use strict'
            const o = (e = {}) => {
                const t =
                    e.env ||
                    Object({
                        VUE_APP_MODE: 'production',
                        VUE_APP_URL_ONE: 'https://one.thethinkacademy.com',
                        VUE_APP_URL_OVERSEA: 'https://oversea-api.thethinkacademy.com',
                        VUE_APP_LIVE_CLASS_RTMP_DISPATCH: 'videogslb.thethinkacademy.com',
                        VUE_APP_H5_URL: 'https://student-h5.thethinkacademy.com',
                        NODE_ENV: 'production',
                        VUE_APP_RELEASE_VERSION:
                            '75700b875603b2d2a7a1d9d59b11609d175f79e9',
                        BASE_URL: '/',
                        IS_ELECTRON: true,
                    }),
                    n = e.platform || process.platform
                return 'win32' !== n
                    ? 'PATH'
                    : Object.keys(t)
                        .reverse()
                        .find((e) => 'PATH' === e.toUpperCase()) || 'Path'
            }
            e.exports = o
            e.exports.default = o
        },
        bb61: function (e, t, n) {
            'use strict'
            n('7ca1')
        },
        beae: function (e, t, n) {
            e.exports = i
            i.sync = c
            var o = n('9b0f')
            function r(e, t) {
                var n =
                    void 0 !== t.pathExt
                        ? t.pathExt
                        : Object({
                            VUE_APP_MODE: 'production',
                            VUE_APP_URL_ONE: 'https://one.thethinkacademy.com',
                            VUE_APP_URL_OVERSEA: 'https://oversea-api.thethinkacademy.com',
                            VUE_APP_LIVE_CLASS_RTMP_DISPATCH:
                                'videogslb.thethinkacademy.com',
                            VUE_APP_H5_URL: 'https://student-h5.thethinkacademy.com',
                            NODE_ENV: 'production',
                            VUE_APP_RELEASE_VERSION:
                                '75700b875603b2d2a7a1d9d59b11609d175f79e9',
                            BASE_URL: '/',
                            IS_ELECTRON: true,
                        }).PATHEXT
                if (!n) {
                    return true
                }
                if (((n = n.split(';')), -1 !== n.indexOf(''))) {
                    return true
                }
                for (var o = 0; o < n.length; o++) {
                    var r = n[o].toLowerCase()
                    if (r && e.substr(-r.length).toLowerCase() === r) {
                        return true
                    }
                }
                return false
            }
            function s(e, t, n) {
                return !(!e.isSymbolicLink() && !e.isFile()) && r(t, n)
            }
            function i(e, t, n) {
                o.stat(e, function (o, r) {
                    n(o, !o && s(r, e, t))
                })
            }
            function c(e, t) {
                return s(o.statSync(e), e, t)
            }
        },
        c023: function (e, t, n) {
            'use strict'
            Object.defineProperty(t, '__esModule', { value: true })
            t.SIGNALS = void 0
            const o = [
                {
                    name: 'SIGHUP',
                    number: 1,
                    action: 'terminate',
                    description: 'Terminal closed',
                    standard: 'posix',
                },
                {
                    name: 'SIGINT',
                    number: 2,
                    action: 'terminate',
                    description: 'User interruption with CTRL-C',
                    standard: 'ansi',
                },
                {
                    name: 'SIGQUIT',
                    number: 3,
                    action: 'core',
                    description: 'User interruption with CTRL-\\',
                    standard: 'posix',
                },
                {
                    name: 'SIGILL',
                    number: 4,
                    action: 'core',
                    description: 'Invalid machine instruction',
                    standard: 'ansi',
                },
                {
                    name: 'SIGTRAP',
                    number: 5,
                    action: 'core',
                    description: 'Debugger breakpoint',
                    standard: 'posix',
                },
                {
                    name: 'SIGABRT',
                    number: 6,
                    action: 'core',
                    description: 'Aborted',
                    standard: 'ansi',
                },
                {
                    name: 'SIGIOT',
                    number: 6,
                    action: 'core',
                    description: 'Aborted',
                    standard: 'bsd',
                },
                {
                    name: 'SIGBUS',
                    number: 7,
                    action: 'core',
                    description:
                        'Bus error due to misaligned, non-existing address or paging error',
                    standard: 'bsd',
                },
                {
                    name: 'SIGEMT',
                    number: 7,
                    action: 'terminate',
                    description: 'Command should be emulated but is not implemented',
                    standard: 'other',
                },
                {
                    name: 'SIGFPE',
                    number: 8,
                    action: 'core',
                    description: 'Floating point arithmetic error',
                    standard: 'ansi',
                },
                {
                    name: 'SIGKILL',
                    number: 9,
                    action: 'terminate',
                    description: 'Forced termination',
                    standard: 'posix',
                    forced: true,
                },
                {
                    name: 'SIGUSR1',
                    number: 10,
                    action: 'terminate',
                    description: 'Application-specific signal',
                    standard: 'posix',
                },
                {
                    name: 'SIGSEGV',
                    number: 11,
                    action: 'core',
                    description: 'Segmentation fault',
                    standard: 'ansi',
                },
                {
                    name: 'SIGUSR2',
                    number: 12,
                    action: 'terminate',
                    description: 'Application-specific signal',
                    standard: 'posix',
                },
                {
                    name: 'SIGPIPE',
                    number: 13,
                    action: 'terminate',
                    description: 'Broken pipe or socket',
                    standard: 'posix',
                },
                {
                    name: 'SIGALRM',
                    number: 14,
                    action: 'terminate',
                    description: 'Timeout or timer',
                    standard: 'posix',
                },
                {
                    name: 'SIGTERM',
                    number: 15,
                    action: 'terminate',
                    description: 'Termination',
                    standard: 'ansi',
                },
                {
                    name: 'SIGSTKFLT',
                    number: 16,
                    action: 'terminate',
                    description: 'Stack is empty or overflowed',
                    standard: 'other',
                },
                {
                    name: 'SIGCHLD',
                    number: 17,
                    action: 'ignore',
                    description: 'Child process terminated, paused or unpaused',
                    standard: 'posix',
                },
                {
                    name: 'SIGCLD',
                    number: 17,
                    action: 'ignore',
                    description: 'Child process terminated, paused or unpaused',
                    standard: 'other',
                },
                {
                    name: 'SIGCONT',
                    number: 18,
                    action: 'unpause',
                    description: 'Unpaused',
                    standard: 'posix',
                    forced: true,
                },
                {
                    name: 'SIGSTOP',
                    number: 19,
                    action: 'pause',
                    description: 'Paused',
                    standard: 'posix',
                    forced: true,
                },
                {
                    name: 'SIGTSTP',
                    number: 20,
                    action: 'pause',
                    description: 'Paused using CTRL-Z or "suspend"',
                    standard: 'posix',
                },
                {
                    name: 'SIGTTIN',
                    number: 21,
                    action: 'pause',
                    description: 'Background process cannot read terminal input',
                    standard: 'posix',
                },
                {
                    name: 'SIGBREAK',
                    number: 21,
                    action: 'terminate',
                    description: 'User interruption with CTRL-BREAK',
                    standard: 'other',
                },
                {
                    name: 'SIGTTOU',
                    number: 22,
                    action: 'pause',
                    description: 'Background process cannot write to terminal output',
                    standard: 'posix',
                },
                {
                    name: 'SIGURG',
                    number: 23,
                    action: 'ignore',
                    description: 'Socket received out-of-band data',
                    standard: 'bsd',
                },
                {
                    name: 'SIGXCPU',
                    number: 24,
                    action: 'core',
                    description: 'Process timed out',
                    standard: 'bsd',
                },
                {
                    name: 'SIGXFSZ',
                    number: 25,
                    action: 'core',
                    description: 'File too big',
                    standard: 'bsd',
                },
                {
                    name: 'SIGVTALRM',
                    number: 26,
                    action: 'terminate',
                    description: 'Timeout or timer',
                    standard: 'bsd',
                },
                {
                    name: 'SIGPROF',
                    number: 27,
                    action: 'terminate',
                    description: 'Timeout or timer',
                    standard: 'bsd',
                },
                {
                    name: 'SIGWINCH',
                    number: 28,
                    action: 'ignore',
                    description: 'Terminal window size changed',
                    standard: 'bsd',
                },
                {
                    name: 'SIGIO',
                    number: 29,
                    action: 'terminate',
                    description: 'I/O is available',
                    standard: 'other',
                },
                {
                    name: 'SIGPOLL',
                    number: 29,
                    action: 'terminate',
                    description: 'Watched event',
                    standard: 'other',
                },
                {
                    name: 'SIGINFO',
                    number: 29,
                    action: 'ignore',
                    description: 'Request for process information',
                    standard: 'other',
                },
                {
                    name: 'SIGPWR',
                    number: 30,
                    action: 'terminate',
                    description: 'Device running out of power',
                    standard: 'systemv',
                },
                {
                    name: 'SIGSYS',
                    number: 31,
                    action: 'core',
                    description: 'Invalid system call',
                    standard: 'other',
                },
                {
                    name: 'SIGUNUSED',
                    number: 31,
                    action: 'terminate',
                    description: 'Invalid system call',
                    standard: 'other',
                },
            ]
            t.SIGNALS = o
        },
        c04b: function (e, t, n) {
            const o = n('6e2d'),
                r = n('a32b'),
                s = r.join(
                    require('electron').remote.app.getAppPath(),
                    'adjust_get_current_system_volume_vista_plus.exe'
                )
            async function i(...e) {
                return (await o(s, e)).stdout
            }
            async function c() {
                const e = await i(),
                    t = e.split(' ')
                return {
                    volume: parseInt(t[0], 10),
                    muted: Boolean(parseInt(t[1], 10)),
                }
            }
            t.getVolume = async function () {
                return (await c()).volume
            }
            t.setVolume = async function (e) {
                await i(String(e))
            }
            t.getMuted = async function () {
                return (await c()).muted
            }
            t.setMuted = async function (e) {
                await i(e ? 'mute' : 'unmute')
            }
        },
        c7ef: function (e, t) {
            e.exports = ['SIGABRT', 'SIGALRM', 'SIGHUP', 'SIGINT', 'SIGTERM']
            'win32' !== process.platform &&
                e.exports.push(
                    'SIGVTALRM',
                    'SIGXCPU',
                    'SIGXFSZ',
                    'SIGUSR2',
                    'SIGTRAP',
                    'SIGSYS',
                    'SIGQUIT',
                    'SIGIOT'
                )
            'linux' === process.platform &&
                e.exports.push('SIGIO', 'SIGPOLL', 'SIGPWR', 'SIGSTKFLT', 'SIGUNUSED')
        },
        d010: function (e, t, n) {
            'use strict'
            const o = (e) =>
                null !== e && 'object' === typeof e && 'function' === typeof e.pipe
            o.writable = (e) =>
                o(e) &&
                false !== e.writable &&
                'function' === typeof e._write &&
                'object' === typeof e._writableState
            o.readable = (e) =>
                o(e) &&
                false !== e.readable &&
                'function' === typeof e._read &&
                'object' === typeof e._readableState
            o.duplex = (e) => o.writable(e) && o.readable(e)
            o.transform = (e) => o.duplex(e) && 'function' === typeof e._transform
            e.exports = o
        },
        d59e: function (e, t, n) {
            'use strict'
            n('365d8')
        },
        d633: function (e, t) {
            function n(e, t) {
                if (e && t) {
                    return n(e)(t)
                }
                if ('function' !== typeof e) {
                    throw new TypeError('need wrapper function')
                }
                return (
                    Object.keys(e).forEach(function (t) {
                        o[t] = e[t]
                    }),
                    o
                )
                function o() {
                    for (var t = new Array(arguments.length), n = 0; n < t.length; n++) {
                        t[n] = arguments[n]
                    }
                    var o = e.apply(this, t),
                        r = t[t.length - 1]
                    return (
                        'function' === typeof o &&
                        o !== r &&
                        Object.keys(r).forEach(function (e) {
                            o[e] = r[e]
                        }),
                        o
                    )
                }
            }
            e.exports = n
        },
        d72d: function (e, t, n) {
            'use strict'
            const o = n('225c')
            e.exports = (e = '') => {
                const t = e.match(o)
                if (!t) {
                    return null
                }
                const [n, r] = t[0].replace(/#! ?/, '').split(' '),
                    s = n.split('/').pop()
                return 'env' === s ? r : r ? `${s} ${r}` : s
            }
        },
        dda8: function (e, t, n) {
            'use strict'
            const o = 'win32' === process.platform
            function r(e, t) {
                return Object.assign(new Error(`${t} ${e.command} ENOENT`), {
                    code: 'ENOENT',
                    errno: 'ENOENT',
                    syscall: `${t} ${e.command}`,
                    path: e.command,
                    spawnargs: e.args,
                })
            }
            function s(e, t) {
                if (!o) {
                    return
                }
                const n = e.emit
                e.emit = function (o, r) {
                    if ('exit' === o) {
                        const o = i(r, t, 'spawn')
                        if (o) {
                            return n.call(e, 'error', o)
                        }
                    }
                    return n.apply(e, arguments)
                }
            }
            function i(e, t) {
                return o && 1 === e && !t.file ? r(t.original, 'spawn') : null
            }
            function c(e, t) {
                return o && 1 === e && !t.file ? r(t.original, 'spawnSync') : null
            }
            e.exports = {
                hookChildProcess: s,
                verifyENOENT: i,
                verifyENOENTSync: c,
                notFoundError: r,
            }
        },
        e10d: function (e, t, n) {
            const o = n('6e2d')
            async function r(...e) {
                return (await o('amixer', e)).stdout
            }
            let s = null
            function c(e) {
                const t = /Simple mixer control '([a-z0-9 -]+)',[0-9]+/i.exec(e)
                if (null === t) {
                    throw new Error('Alsa Mixer Error: failed to parse output')
                }
                return t[1]
            }
            async function a() {
                return s || (s = c(await r()))
            }
            function l(e) {
                const t =
                    /[a-z][a-z ]*: Playback [0-9-]+ \[([0-9]+)%\] (?:[[0-9.-]+dB\] )?\[(on|off)\]/i.exec(
                        e
                    )
                if (null === t) {
                    throw new Error('Alsa Mixer Error: failed to parse output')
                }
                return {
                    volume: parseInt(t[1], 10),
                    muted: 'off' === t[2],
                }
            }
            async function d() {
                return l(await r('get', await a()))
            }
            t.getVolume = async function () {
                return (await d()).volume
            }
            t.setVolume = async function (e) {
                await r('set', await a(), e + '%')
            }
            t.getMuted = async function () {
                return (await d()).muted
            }
            t.setMuted = async function (e) {
                await r('set', await a(), e ? 'mute' : 'unmute')
            }
        },
        e50d: function (e, t, n) {
            n('d9e2')
            n('8172')
            n('efec')
            n('a4d3')
            n('e01a')
            n('d3b7')
            n('a9e3')
            var o = n('7037').default
            function r(e, t) {
                if ('object' !== o(e) || null === e) {
                    return e
                }
                var n = e[Symbol.toPrimitive]
                if (void 0 !== n) {
                    var r = n.call(e, t || 'default')
                    if ('object' !== o(r)) {
                        return r
                    }
                    throw new TypeError('@@toPrimitive must return a primitive value.')
                }
                return ('string' === t ? String : Number)(e)
            }
            e.exports = r
            e.exports.__esModule = true
            e.exports.default = e.exports
        },
        fbc4: function (e, t, n) { },
        fcb5: function (e, t, n) {
            'use strict'
            e.exports = (e) => {
                const t = 'string' === typeof e ? '\n' : '\n'.charCodeAt(),
                    n = 'string' === typeof e ? '\r' : '\r'.charCodeAt()
                return (
                    e[e.length - 1] === t && (e = e.slice(0, e.length - 1)),
                    e[e.length - 1] === n && (e = e.slice(0, e.length - 1)),
                    e
                )
            }
        },
    },
])
