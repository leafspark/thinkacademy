; (window.webpackJsonp = window.webpackJsonp || []).push([
    ['chunk-9c37b028'],
    {
        1385: function (t, o, e) {
            'use strict'
            e.r(o)
            e.d(o, 'default', function () {
                return _
            })
            var n = e('5530'),
                s = e('d4ec'),
                a = e('bee2'),
                i = e('262e'),
                r = e('2caf'),
                c = e('b6c9'),
                l = function () {
                    var t = this,
                        o = t._self._c
                    return o(
                        'div',
                        {
                            staticClass: 'photoWallContainer',
                            attrs: { id: 'photoWallContainer' },
                        },
                        [
                            o(
                                'div',
                                {
                                    ref: 'countdownContainer',
                                    staticClass: 'countdownContainer',
                                    style: t.countdownStyle,
                                    attrs: { id: 'countdownContainer' },
                                },
                                [
                                    o('i', { staticClass: 'countDown-icon' }),
                                    o('NeCountdown', {
                                        ref: 'countDown',
                                        staticClass: 'countdown',
                                        attrs: {
                                            time: t.countDownTime,
                                            format: 'mm:ss',
                                        },
                                        on: { complete: t.countdownComplete },
                                    }),
                                ],
                                1
                            ),
                            t.showCamera || t.showGraffiti
                                ? o(
                                    'div',
                                    {
                                        staticClass: 'toolbar',
                                        attrs: { id: 'toolbar' },
                                    },
                                    [
                                        o('i', {
                                            staticClass: 'back',
                                            on: { click: t.goClassRoom },
                                        }),
                                    ]
                                )
                                : t._e(),
                            !t.isSubmit && t.isCanOpenCamera
                                ? o(
                                    'div',
                                    {
                                        ref: 'photoShotBtn',
                                        staticClass: 'photoShotBtn',
                                        class: t.disableCamera,
                                        attrs: { id: 'photoShotBtnId' },
                                        on: { click: t.openClassCamera },
                                    },
                                    [o('i')]
                                )
                                : t._e(),
                            t.showCamera && !t.showGraffiti
                                ? o('camera', {
                                    attrs: {
                                        delay: 2000,
                                        options: t.options,
                                    },
                                    on: {
                                        changeTakePhotoWay: t.changeTakePhotoWay,
                                        submit: t.submitPhoto,
                                        photoData: t.getPhotoData,
                                    },
                                })
                                : t._e(),
                            t.showGraffiti && !t.showCamera
                                ? o('graffiti', {
                                    attrs: {
                                        options: t.options,
                                        cameraAccess: t.cameraAccess,
                                        closeInteractive: t.closeInteractive,
                                    },
                                    on: {
                                        submit: t.submitPhoto,
                                        photoData: t.getPhotoData,
                                        changeTakePhotoWay: t.changeTakePhotoWay,
                                    },
                                })
                                : t._e(),
                            !t.showPhotoShotTip || t.isSubmit || t.userClosePhotoShotTip
                                ? t._e()
                                : o(
                                    'div',
                                    {
                                        ref: 'photoShotTip',
                                        staticClass: 'photoShotTip animateSlideInDown',
                                    },
                                    [
                                        o('div', {
                                            staticClass: 'close',
                                            on: { click: t.closePhotoShotTip },
                                        }),
                                        o('ul', [
                                            o('li', [
                                                t._v(
                                                    t._s(
                                                        this.$t(
                                                            'classroom.interactions.photoWall.hasAccessNotice'
                                                        )[0]
                                                    )
                                                ),
                                            ]),
                                            o('li', [
                                                t._v(
                                                    t._s(
                                                        this.$t(
                                                            'classroom.interactions.photoWall.hasAccessNotice'
                                                        )[1]
                                                    )
                                                ),
                                            ]),
                                            o('li', [
                                                t._v(
                                                    t._s(
                                                        this.$t(
                                                            'classroom.interactions.photoWall.hasAccessNotice'
                                                        )[2]
                                                    )
                                                ),
                                            ]),
                                        ]),
                                    ]
                                ),
                            t.cameraAccess
                                ? t._e()
                                : o('div', { staticClass: 'cameraAccessToast animateFadeIn' }, [
                                    o('p', [
                                        t._v(
                                            ' ' +
                                            t._s(
                                                this.$t(
                                                    'classroom.interactions.photoWall.notAccessNotice'
                                                )[0]
                                            )
                                        ),
                                        o('br'),
                                        t._v(
                                            ' ' +
                                            t._s(
                                                this.$t(
                                                    'classroom.interactions.photoWall.notAccessNotice'
                                                )[1]
                                            ) +
                                            ' '
                                        ),
                                    ]),
                                    o(
                                        'div',
                                        {
                                            staticClass: 'showGraffiti',
                                            on: { click: t.openClassGraffiti },
                                        },
                                        [t._v('去涂鸦')]
                                    ),
                                ]),
                            o('photoWallDialog', {
                                attrs: {
                                    cancelText: t.$t('common.no'),
                                    confirmText: t.confirmText,
                                    visible: t.dialogVisible,
                                    content: t.dialogContent,
                                    description: t.dialogDescription,
                                },
                                on: {
                                    cancel: t.dialogCancel,
                                    confirm: t.dialogConfirm,
                                },
                            }),
                            o('uploadProgress', {
                                attrs: {
                                    percent: t.percent,
                                    visible: t.showUploadProgress,
                                },
                            }),
                            o('MediaSecurityAccess', {
                                attrs: {
                                    type: 'camera',
                                    visible: true,
                                },
                            }),
                            o('audio', {
                                ref: 'photoWallBeginSound',
                                staticClass: 'hide',
                                attrs: { src: e('79d5') },
                            }),
                            o('audio', {
                                ref: 'photoWallBtnSound',
                                staticClass: 'hide',
                                attrs: { src: e('e28a') },
                            }),
                            o('audio', {
                                ref: 'photoWallSuccessSound',
                                staticClass: 'hide',
                                attrs: { src: e('8b88') },
                            }),
                        ],
                        1
                    )
                },
                m = [],
                h = e('c7eb'),
                p = e('1da1'),
                u = (e('99af'), e('0a4b')),
                d = e('dad2'),
                f = e('e811'),
                C = e('36e9'),
                b = e('75b9'),
                g = e('030f'),
                v = e('e39c'),
                w = e('3b29'),
                I = e('1a37'),
                W = e('3898'),
                T = e('d0db'),
                y = e('e417'),
                S = e('bcaf'),
                P = e('c02a'),
                k = {
                    name: 'PhotoWall',
                    props: {
                        options: {
                            type: Object,
                            default: function () {
                                return {}
                            },
                        },
                    },
                    i18n: W.b,
                    components: {
                        camera: f.a,
                        graffiti: C.a,
                        photoWallDialog: b.a,
                        uploadProgress: g.a,
                        MediaSecurityAccess: w.a,
                    },
                    data: function () {
                        return {
                            showPhotoShotTip: false,
                            userClosePhotoShotTip: false,
                            dialogVisible: false,
                            cameraAccess: true,
                            isCountdownComplete: false,
                            countDownTime: 0,
                            showCamera: false,
                            showGraffiti: false,
                            isSubmit: false,
                            submiting: false,
                            submitTimer: null,
                            submitCountdown: 5,
                            confirmText: ''.concat(this.$t('common.yes'), ' (5)'),
                            percent: 0,
                            showUploadProgress: false,
                            photoData: false,
                            uploadError: false,
                            closeInteractive: false,
                            isInteraction: false,
                            classType: 0,
                            isCanOpenCamera: true,
                        }
                    },
                    created: function () {
                        this.photoWall = new d.a(Object(n.a)({}, this.options))
                        this.countDownTime = this.photoWall.initCountdownTime() || 0
                        this.classType =
                            this.options.roomMessage.roomInfo.commonOption.classType
                    },
                    mounted: function () {
                        var t = this
                        this.userTrackLogger('拍照上墙启动')
                        this.$nextTick(
                            Object(p.a)(
                                Object(h.a)().mark(function o() {
                                    var e
                                    return Object(h.a)().wrap(function (o) {
                                        while (1) {
                                            switch ((o.prev = o.next)) {
                                                case 0:
                                                    return (
                                                        t.$refs.photoWallBeginSound.play(),
                                                        t.$bus.$emit(
                                                            'photoWallInteractId',
                                                            t.options.ircMsg.interactId
                                                        ),
                                                        t.photoWall.interactOpen(),
                                                        t.getWallStatus(),
                                                        (o.next = 6),
                                                        u.nativeApi.getMediaAccessStatus('camera')
                                                    )
                                                case 6:
                                                    if (((e = o.sent), 'granted' === e)) {
                                                        o.next = 12
                                                        break
                                                    }
                                                    return (
                                                        console.info(
                                                            "if(cameraAccess !== 'granted')为true触发return,path: /renderer/components/Classroom/CommonInteractions/photoWall/app.vue"
                                                        ),
                                                        t.sendLogger(
                                                            '拍照上墙初始化摄像头无权限\uFF0Ccode:'.concat(e),
                                                            'init'
                                                        ),
                                                        (t.cameraAccess = false),
                                                        o.abrupt('return')
                                                    )
                                                case 12:
                                                    ; (t.showPhotoShotTip = true),
                                                        localStorage.setItem(
                                                            'photoWallOptions',
                                                            JSON.stringify(t.options)
                                                        )
                                                case 14:
                                                case 'end':
                                                    return o.stop()
                                            }
                                        }
                                    }, o)
                                })
                            )
                        )
                    },
                    computed: {
                        countdownStyle: function () {
                            return (
                                console.info(
                                    '对象函数 countdownStyle,filePath:renderer/components/Classroom/CommonInteractions/photoWall/app.vue'
                                ),
                                this.showCamera || this.showGraffiti ? 'left:67.5%' : ''
                            )
                        },
                        disableCamera: function () {
                            return (
                                console.info(
                                    '对象函数 disableCamera,filePath:renderer/components/Classroom/CommonInteractions/photoWall/app.vue'
                                ),
                                !this.cameraAccess && 'disabled'
                            )
                        },
                    },
                    methods: {
                        changeTakePhotoWay: function (t) {
                            console.info(
                                '对象函数 changeTakePhotoWay(way)',
                                t,
                                'filePath:renderer/components/Classroom/CommonInteractions/photoWall/app.vue'
                            )
                            'graffiti' === t
                                ? ((this.showCamera = false),
                                    (this.showGraffiti = true),
                                    this.sendLogger('切换到涂鸦板成功'))
                                : ((this.showCamera = true),
                                    (this.showGraffiti = false),
                                    this.sendLogger('切换到拍照成功'))
                        },
                        closePhotoShotTip: function () {
                            console.info(
                                '对象函数 closePhotoShotTip,filePath:renderer/components/Classroom/CommonInteractions/photoWall/app.vue'
                            )
                            this.sendLogger('点击关闭有权限提示层')
                            this.showPhotoShotTip = false
                            this.userClosePhotoShotTip = true
                        },
                        openClassCamera: function () {
                            var t = this
                            console.info(
                                '对象函数 openClassCamera,filePath:renderer/components/Classroom/CommonInteractions/photoWall/app.vue'
                            )
                            this.$nextTick(function () {
                                t.$refs.photoWallBtnSound.play()
                            })
                            this.showCamera = !this.showCamera
                            this.isInteraction = true
                            this.sendLogger('打开拍照弹层成功')
                            this.addSmallClassStyle()
                            Object(y.e)(
                                'hw_classroom_interact_photograph_click',
                                this.options.roomMessage.roomInfo.commonOption,
                                { interact_id: this.options.ircMsg.interactId }
                            )
                        },
                        sendPeerMessageToTutor: function (t) {
                            console.info(
                                '对象函数 sendPeerMessageToTutor(isBusy)',
                                t,
                                'filePath:renderer/components/Classroom/CommonInteractions/photoWall/app.vue'
                            )
                            var o = {
                                type: 170,
                                isFunction: 1,
                                msg: '拍照上墙',
                                parameter: { cameraBusy: t },
                            }
                            window.ChatClient.PeerChatManager.sendPeerMessage(
                                [
                                    {
                                        nickname:
                                            this.options.roomMessage.roomInfo.configs.tutorIrcId,
                                    },
                                ],
                                JSON.stringify(o),
                                S.a.privMsg
                            )
                        },
                        openClassGraffiti: function () {
                            console.info(
                                '对象函数 openClassGraffiti,filePath:renderer/components/Classroom/CommonInteractions/photoWall/app.vue'
                            )
                            this.showGraffiti = !this.showGraffiti
                            this.isInteraction = true
                            this.sendLogger('打开涂鸦板成功')
                            this.addSmallClassStyle()
                        },
                        goClassRoom: function () {
                            console.info(
                                '对象函数 goClassRoom,filePath:renderer/components/Classroom/CommonInteractions/photoWall/app.vue'
                            )
                            this.sendLogger('点击返回课堂')
                            this.showPhotoShotTip = true
                            this.showCamera = this.showGraffiti = this.isInteraction = false
                            this.removeSmallClassStyle()
                        },
                        getPhotoData: function (t) {
                            this.photoData = t
                        },
                        getWallStatus: function () {
                            var t = this
                            return Object(p.a)(
                                Object(h.a)().mark(function o() {
                                    var e, n, s
                                    return Object(h.a)().wrap(
                                        function (o) {
                                            while (1) {
                                                switch ((o.prev = o.next)) {
                                                    case 0:
                                                        return (
                                                            console.info(
                                                                '对象函数 getWallStatus,filePath:renderer/components/Classroom/CommonInteractions/photoWall/app.vue'
                                                            ),
                                                            (o.prev = 1),
                                                            (o.next = 4),
                                                            t.photoWall.getWallStatus()
                                                        )
                                                    case 4:
                                                        ; (e = o.sent),
                                                            (n = e.code),
                                                            (s = e.data),
                                                            T.a.send({
                                                                tag: 'student.Interact',
                                                                content: {
                                                                    interactType: 'PhotoWall',
                                                                    msg: '拍照上墙异常恢复',
                                                                    code: n,
                                                                    data: s,
                                                                },
                                                            }),
                                                            0 === n && (t.isSubmit = s.isSubmit),
                                                            (o.next = 14)
                                                        break
                                                    case 11:
                                                        ; (o.prev = 11),
                                                            (o.t0 = o.catch(1)),
                                                            T.a.send({
                                                                tag: 'student.Interact',
                                                                content: {
                                                                    interactType: 'PhotoWall',
                                                                    msg: '拍照上墙异常恢复错误',
                                                                    error: o.t0,
                                                                },
                                                                level: 'error',
                                                            })
                                                    case 14:
                                                    case 'end':
                                                        return o.stop()
                                                }
                                            }
                                        },
                                        o,
                                        null,
                                        [[1, 11]]
                                    )
                                })
                            )()
                        },
                        interactiveOver: function () {
                            var t = this
                            return Object(p.a)(
                                Object(h.a)().mark(function o() {
                                    return Object(h.a)().wrap(function (o) {
                                        while (1) {
                                            switch ((o.prev = o.next)) {
                                                case 0:
                                                    return (
                                                        console.info(
                                                            '对象函数 interactiveOver,filePath:renderer/components/Classroom/CommonInteractions/photoWall/app.vue'
                                                        ),
                                                        (t.showPhotoShotTip = false),
                                                        (o.next = 4),
                                                        Object(v.e)(800)
                                                    )
                                                case 4:
                                                    if (t.photoData || t.isSubmit || t.submiting) {
                                                        o.next = 9
                                                        break
                                                    }
                                                    return (
                                                        console.info(
                                                            'if(!_this4.photoData && !_this4.isSubmit && !_this4.submiting)为true触发return,path: /renderer/components/Classroom/CommonInteractions/photoWall/app.vue'
                                                        ),
                                                        t.sendLogger('没参与拍照上墙结束'),
                                                        t.photoWall.showNotjoinTip({
                                                            className:
                                                                t.showGraffiti || t.showCamera ? '' : 'notJoin',
                                                            tips: t.$t(
                                                                'classroom.interactions.photoWall.notjoinTip'
                                                            ),
                                                            callback: function () {
                                                                t.destroy()
                                                            },
                                                        }),
                                                        o.abrupt('return')
                                                    )
                                                case 9:
                                                    if (!t.photoData || t.isSubmit || t.submiting) {
                                                        o.next = 18
                                                        break
                                                    }
                                                    return (
                                                        console.info(
                                                            'if(_this4.photoData && !_this4.isSubmit && !_this4.submiting)为true触发return,path: /renderer/components/Classroom/CommonInteractions/photoWall/app.vue'
                                                        ),
                                                        t.sendLogger('有图片数据\uFF0C弹框提醒提交'),
                                                        t.clearSubmitTimer(),
                                                        (t.dialogContent = t.$t(
                                                            'classroom.interactions.photoWall.endNotice'
                                                        )[0]),
                                                        (t.dialogDescription = t.$t(
                                                            'classroom.interactions.photoWall.endNotice'
                                                        )[1]),
                                                        (t.dialogVisible = true),
                                                        (t.submitTimer = setInterval(function () {
                                                            t.submitCountdown--
                                                            0 === t.submitCountdown &&
                                                                (clearInterval(t.submitTimer),
                                                                    (t.submitTimer = null),
                                                                    t.destroy())
                                                        }, 1000)),
                                                        o.abrupt('return')
                                                    )
                                                case 18:
                                                    t.destroy()
                                                case 19:
                                                case 'end':
                                                    return o.stop()
                                            }
                                        }
                                    }, o)
                                })
                            )()
                        },
                        submitPhoto: function () {
                            var t = this
                            return Object(p.a)(
                                Object(h.a)().mark(function o() {
                                    var e, n, s, a, i
                                    return Object(h.a)().wrap(function (o) {
                                        while (1) {
                                            switch ((o.prev = o.next)) {
                                                case 0:
                                                    if (
                                                        (console.info(
                                                            '对象函数 submitPhoto,filePath:renderer/components/Classroom/CommonInteractions/photoWall/app.vue'
                                                        ),
                                                            !t.submiting || !t.closeInteractive)
                                                    ) {
                                                        o.next = 5
                                                        break
                                                    }
                                                    return (
                                                        console.info(
                                                            'if(_this5.submiting && _this5.closeInteractive)为true触发return,path: /renderer/components/Classroom/CommonInteractions/photoWall/app.vue'
                                                        ),
                                                        T.a.send({
                                                            tag: 'student.Interact',
                                                            content: {
                                                                interactType: 'PhotoWall',
                                                                msg: '提交中或者老师已经关闭互动',
                                                            },
                                                        }),
                                                        o.abrupt('return')
                                                    )
                                                case 5:
                                                    return (
                                                        (t.dialogVisible = t.showPhotoShotTip = false),
                                                        (t.submiting = t.showUploadProgress = true),
                                                        (t.isCanOpenCamera = false),
                                                        (e = new I.b({ scene: 'pictureWall' })),
                                                        t.photoData.base64.substring(
                                                            t.photoData.base64.indexOf(',') + 1
                                                        ).length > 0
                                                            ? T.a.send({
                                                                tag: 'student.Interact',
                                                                content: {
                                                                    interactType: 'PhotoWall',
                                                                    msg: 'base64有内容开始拍照上墙文件上传',
                                                                },
                                                            })
                                                            : T.a.send({
                                                                tag: 'student.Interact',
                                                                content: {
                                                                    interactType: 'PhotoWall',
                                                                    msg: '拍照文件为空',
                                                                },
                                                                level: 'error',
                                                            }),
                                                        (o.next = 12),
                                                        e.putFile({
                                                            filePath: 'pictureWall.jpg',
                                                            file: t.photoData.blob,
                                                            progress: function (o) { },
                                                            success: function (o) {
                                                                var e, n
                                                                t.sendLogger(
                                                                    '上传照片成功, url: '.concat(o.url)
                                                                )
                                                                P.l(
                                                                    null === (e = t.options) ||
                                                                        void 0 === e ||
                                                                        null === (n = e.ircMsg) ||
                                                                        void 0 === n
                                                                        ? void 0
                                                                        : n.interactId,
                                                                    o
                                                                )
                                                            },
                                                            fail: function () {
                                                                t.photoWall.showSubmitTip({
                                                                    text: t.$t('common.uploadFailed'),
                                                                    icon: 'error',
                                                                    callback: function () {
                                                                        t.isCountdownComplete && t.destroy()
                                                                    },
                                                                })
                                                                t.sendLogger('上传照片失败', '', 'error')
                                                            },
                                                        })
                                                    )
                                                case 12:
                                                    if (((n = o.sent), (s = n.key), !s)) {
                                                        o.next = 39
                                                        break
                                                    }
                                                    return (
                                                        (t.showUploadProgress = false),
                                                        t.isFromCorrectAnsewr ||
                                                        t.photoWall.showSubmitTip({
                                                            text: ''.concat(
                                                                t.$t('common.submiting'),
                                                                '...'
                                                            ),
                                                            icon: 'loading',
                                                            duration: 0,
                                                        }),
                                                        (o.next = 19),
                                                        t.photoWall.submitPhoto(s)
                                                    )
                                                case 19:
                                                    if (
                                                        ((a = o.sent),
                                                            T.a.send({
                                                                tag: 'student.Interact',
                                                                content: {
                                                                    interactType: 'PhotoWall',
                                                                    msg: '拍照上墙提交地址完毕',
                                                                    submitRes: a,
                                                                    isFromCorrectAnsewr: t.isFromCorrectAnsewr,
                                                                },
                                                            }),
                                                            0 !== a.code || !a.data)
                                                    ) {
                                                        o.next = 35
                                                        break
                                                    }
                                                    if (
                                                        ((i = a.data.rightCoin),
                                                            (t.showGraffiti = t.showCamera = false),
                                                            (t.isSubmit = true),
                                                            t.removeSmallClassStyle(),
                                                            !t.isFromCorrectAnsewr)
                                                    ) {
                                                        o.next = 30
                                                        break
                                                    }
                                                    return (
                                                        console.info(
                                                            'if(_this5.isFromCorrectAnsewr)为true触发return,path: /renderer/components/Classroom/CommonInteractions/photoWall/app.vue'
                                                        ),
                                                        (t.$refs.photoShotBtn.style.display = 'none'),
                                                        o.abrupt('return')
                                                    )
                                                case 30:
                                                    t.$nextTick(function () {
                                                        var o
                                                        null === (o = t.$refs.photoWallSuccessSound) ||
                                                            void 0 === o ||
                                                            o.play()
                                                    }),
                                                        t.photoWall.showCoinsTip({
                                                            coins: i,
                                                            tips: t.$t('common.sumbittedSuccessfully'),
                                                            callback: function () {
                                                                if (t.closeInteractive) {
                                                                    return (
                                                                        console.info(
                                                                            'if(_this5.closeInteractive)为true触发return,path: /renderer/components/Classroom/CommonInteractions/photoWall/app.vue'
                                                                        ),
                                                                        console.info(
                                                                            'if(_this5.closeInteractive)为true触发return,path: /renderer/components/Classroom/CommonInteractions/photoWall/app.vue'
                                                                        ),
                                                                        t.destroy()
                                                                    )
                                                                }
                                                            },
                                                        }),
                                                        t.sendLogger(
                                                            '获得金币成功, '.concat(JSON.stringify(a))
                                                        ),
                                                        (o.next = 39)
                                                    break
                                                case 35:
                                                    ; (t.submiting = false),
                                                        (t.percent = 0),
                                                        t.photoWall.showSubmitTip({
                                                            text: t.$t('common.submissionFailed'),
                                                            icon: 'error',
                                                            callback: function () {
                                                                t.isCountdownComplete && t.destroy()
                                                            },
                                                        }),
                                                        t.sendLogger(
                                                            '获得金币失败, '.concat(JSON.stringify(a))
                                                        )
                                                case 39:
                                                case 'end':
                                                    return o.stop()
                                            }
                                        }
                                    }, o)
                                })
                            )()
                        },
                        dialogCancel: function () {
                            console.info(
                                '对象函数 dialogCancel,filePath:renderer/components/Classroom/CommonInteractions/photoWall/app.vue'
                            )
                            this.sendLogger('弹框提醒取消按钮点击')
                            this.clearSubmitTimer()
                            this.destroy()
                        },
                        dialogConfirm: function () {
                            console.info(
                                '对象函数 dialogConfirm,filePath:renderer/components/Classroom/CommonInteractions/photoWall/app.vue'
                            )
                            this.sendLogger('弹框提醒提交按钮点击')
                            this.clearSubmitTimer()
                            this.confirmText = ''.concat(this.$t('common.submiting'), '...')
                            this.submitPhoto()
                        },
                        clearSubmitTimer: function () {
                            console.info(
                                '对象函数 clearSubmitTimer,filePath:renderer/components/Classroom/CommonInteractions/photoWall/app.vue'
                            )
                            this.submitTimer &&
                                (clearInterval(this.submitTimer), (this.submitTimer = null))
                        },
                        countdownComplete: function () {
                            console.info(
                                '对象函数 countdownComplete,filePath:renderer/components/Classroom/CommonInteractions/photoWall/app.vue'
                            )
                        },
                        destroyInteraction: function () {
                            var t = this
                            return Object(p.a)(
                                Object(h.a)().mark(function o() {
                                    return Object(h.a)().wrap(function (o) {
                                        while (1) {
                                            switch ((o.prev = o.next)) {
                                                case 0:
                                                    return (
                                                        console.info(
                                                            '对象函数 destroyInteraction,filePath:renderer/components/Classroom/CommonInteractions/photoWall/app.vue'
                                                        ),
                                                        (t.closeInteractive = true),
                                                        (t.isCanOpenCamera = false),
                                                        t.$bus.$emit('photoWallInteractId', null),
                                                        (o.next = 6),
                                                        t.interactiveOver()
                                                    )
                                                case 6:
                                                case 'end':
                                                    return o.stop()
                                            }
                                        }
                                    }, o)
                                })
                            )()
                        },
                        addSmallClassStyle: function () {
                            var t = this
                            console.info(
                                '对象函数 addSmallClassStyle,filePath:renderer/components/Classroom/CommonInteractions/photoWall/app.vue'
                            )
                            this.$nextTick(function () {
                                2 == t.classType &&
                                    (Object(v.a)(
                                        document.getElementById('countdownContainer'),
                                        'smallclass-countdownContainer'
                                    ),
                                        Object(v.a)(
                                            document.getElementById('toolbar'),
                                            'small-class-toolbar'
                                        ))
                            })
                        },
                        removeSmallClassStyle: function () {
                            console.info(
                                '对象函数 removeSmallClassStyle,filePath:renderer/components/Classroom/CommonInteractions/photoWall/app.vue'
                            )
                            2 == this.classType &&
                                (Object(v.w)(
                                    document.getElementById('countdownContainer'),
                                    'smallclass-countdownContainer'
                                ),
                                    Object(v.w)(
                                        document.getElementById('toolbar'),
                                        'small-class-toolbar'
                                    ))
                        },
                        sendLogger: function (t) {
                            var o =
                                arguments.length > 1 && void 0 !== arguments[1]
                                    ? arguments[1]
                                    : '',
                                e =
                                    arguments.length > 2 && void 0 !== arguments[2]
                                        ? arguments[2]
                                        : 'info'
                            T.a.send({
                                tag: 'student.Interact',
                                content: {
                                    msg: t,
                                    interactType: 'PhotoWall',
                                    interactId: this.options.ircMsg.interactId,
                                    interactStage: o,
                                },
                                level: e,
                            })
                        },
                        userTrackLogger: function (t) {
                            T.a.send({
                                tag: 'userTrack',
                                content: {
                                    msg: t,
                                    tag: 'student.Interact',
                                    interactType: 'PhotoWall',
                                },
                            })
                        },
                        destroy: function () {
                            console.info(
                                '对象函数 destroy,filePath:renderer/components/Classroom/CommonInteractions/photoWall/app.vue'
                            )
                            this.$el &&
                                this.$el.parentNode &&
                                (this.$bus.$off('changeTakePhotoWay'),
                                    this.$bus.$emit('photoWallInteractId', null),
                                    this.$destroy(),
                                    this.$el.parentNode.removeChild(this.$el),
                                    Object(v.w)(
                                        document.getElementById('interactionController'),
                                        'index-1000'
                                    ),
                                    this.userTrackLogger('拍照上墙结束'))
                        },
                    },
                    watch: {
                        showCamera: function (t) {
                            console.info(
                                '对象函数 showCamera(val)',
                                t,
                                'filePath:renderer/components/Classroom/CommonInteractions/photoWall/app.vue'
                            )
                            t &&
                                this.photoWall.showShortCutTip({
                                    tips: this.$t('classroom.interactions.photoWall.shortCutTip'),
                                })
                            var o = t ? 1 : 2
                            this.sendPeerMessageToTutor(o)
                        },
                        isInteraction: function (t) {
                            console.info(
                                '对象函数 isInteraction(val)',
                                t,
                                'filePath:renderer/components/Classroom/CommonInteractions/photoWall/app.vue'
                            )
                            t
                                ? Object(v.a)(
                                    document.getElementById('interactionController'),
                                    'index-1000'
                                )
                                : Object(v.w)(
                                    document.getElementById('interactionController'),
                                    'index-1000'
                                )
                        },
                    },
                },
                O = k,
                x = (e('d3fc'), e('3dd7'), e('2877')),
                $ = Object(x.a)(O, l, m, false, null, '7cf7aca8', null),
                j = $.exports,
                _ = (function (t) {
                    Object(i.a)(e, t)
                    var o = Object(r.a)(e)
                    function e() {
                        var t,
                            n =
                                arguments.length > 0 && void 0 !== arguments[0]
                                    ? arguments[0]
                                    : {}
                        return (
                            console.info(
                                '函数申明 PhotoWall(opts)',
                                n,
                                'filePath:renderer/components/Classroom/CommonInteractions/photoWall/index.js'
                            ),
                            Object(s.a)(this, e),
                            (t = o.call(this, j)),
                            (t.options = n),
                            (t.dom = n.roomMessage.roomInfo.interactionController),
                            t.initVmApp('拍照上墙'),
                            t
                        )
                    }
                    return (
                        Object(a.a)(e, [
                            {
                                key: 'createPropsData',
                                value: function () {
                                    var t = {
                                        confirmText: ''
                                            .concat(t.$t('common.yes'), ' (')
                                            .concat(t.submitCountdown, ')'),
                                        percent: o,
                                        showUploadProgress: false,
                                        submiting: false,
                                        percent: 0,
                                        isInteraction: false,
                                    }
                                    return Object(n.a)({ options: this.options }, t)
                                },
                            },
                        ]),
                        e
                    )
                })(c.a)
        },
        2579: function (t, o, e) { },
        '3dd7': function (t, o, e) {
            'use strict'
            e('f90a')
        },
        '79d5': function (t, o, e) {
            t.exports = e.p + 'static/media/photowall-begin.563c00a9.mp3'
        },
        '8b88': function (t, o, e) {
            t.exports = e.p + 'static/media/photowall-submit-success.ba915894.mp3'
        },
        b6c9: function (t, o, e) {
            'use strict'
            e.d(o, 'a', function () {
                return l
            })
            var n = e('d4ec'),
                s = e('bee2'),
                a = (e('99af'), e('d9e2'), e('8bbf')),
                i = e.n(a),
                r = e('3898'),
                c = e('d0db'),
                l = (function () {
                    function t(o) {
                        console.info(
                            '函数申明 InteractionBase(app)',
                            o,
                            'filePath:renderer/components/Classroom/CommonInteractions/interaction-base.js'
                        )
                        Object(n.a)(this, t)
                        this.app = o
                        this.vm = null
                        this.keepOtherDom = false
                    }
                    return (
                        Object(s.a)(t, [
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
                                    var o = i.a.extend(t),
                                        e = this.createPropsData(),
                                        n = new o({
                                            i18n: r.b,
                                            propsData: e,
                                            store: this.store || {},
                                        })
                                    return n.$mount(), n
                                },
                            },
                            {
                                key: 'render',
                                value: function (t, o) {
                                    t.appendChild(o.$el)
                                },
                            },
                            {
                                key: 'destroy',
                                value: function () {
                                    var t =
                                        arguments.length > 0 && void 0 !== arguments[0]
                                            ? arguments[0]
                                            : {},
                                        o = t.submit
                                    this.vm
                                        ? (o && this.vm.submit(),
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
                                value: function (t, o) {
                                    return t[''.concat(o)].properties
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
        d3fc: function (t, o, e) {
            'use strict'
            e('2579')
        },
        f90a: function (t, o, e) { },
    },
])
