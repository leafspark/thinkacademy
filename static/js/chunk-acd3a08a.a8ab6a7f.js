; (window.webpackJsonp = window.webpackJsonp || []).push([
    ['chunk-acd3a08a'],
    {
        '114c': function (e, t, s) {
            'use strict'
            s('dd46')
        },
        3206: function (e, t, s) {
            'use strict'
            s('8e89')
        },
        '8e89': function (e, t, s) { },
        a755: function (e, t, s) {
            'use strict'
            s.r(t)
            var o = function () {
                var e = this,
                    t = e._self._c
                return t('div', { staticClass: 'page-wrapper' }, [
                    t(
                        'div',
                        { staticClass: 'syllabus-list' },
                        [
                            e.isError
                                ? [
                                    t('ErrorStatus', {
                                        attrs: { scene: 'CoursesDetails' },
                                        on: { 'click-refresh': e.queryData },
                                    }),
                                ]
                                : [
                                    e.loading
                                        ? t('Loading', { attrs: { 'margin-top': '200px' } })
                                        : t(
                                            'section',
                                            { staticClass: 'record-detail-wrapper' },
                                            [
                                                t('RecordSyllabusNav', {
                                                    attrs: { 'course-data': e.courseData },
                                                }),
                                                t('RecordSyllabusList', {
                                                    attrs: {
                                                        'course-data': e.courseData,
                                                        'schedule-list': e.scheduleList,
                                                    },
                                                }),
                                            ],
                                            1
                                        ),
                                ],
                        ],
                        2
                    ),
                ])
            },
                r = [],
                a = s('c7eb'),
                n = s('1da1'),
                c = (s('4de4'), s('d3b7'), s('e6cf'), s('a79d'), s('b0c0'), s('bd12')),
                i = s('aaf0'),
                l =
                    (s('99af'),
                        function () {
                            var e = this,
                                t = e._self._c
                            return t(
                                'div',
                                { staticClass: 'record-syllabus-list' },
                                e._l(e.scheduleList, function (s, o) {
                                    return t(
                                        'div',
                                        {
                                            key: 'schedule-'.concat(o),
                                            staticClass: 'record-syllabus-card',
                                        },
                                        [
                                            t('div', { staticClass: 'syllabus-card' }, [
                                                t('div', { staticClass: 'number' }, [
                                                    e._v(e._s(e.calIndex(o + 1))),
                                                ]),
                                                t('div', { staticClass: 'title' }, [
                                                    e._v(e._s(s.recordLesson.lessonName)),
                                                ]),
                                            ]),
                                            t('div', { staticClass: 'syllabus-bottom' }, [
                                                t('div', { staticClass: 'syllabus-bottom-item' }, [
                                                    t('div', { staticClass: 'info' }, [
                                                        t('span', { staticClass: 'title' }, [
                                                            e._v('Recorded Course'),
                                                        ]),
                                                        t('span', { staticClass: 'time' }, [
                                                            e._v(e._s(e.getTime(s.recordLesson))),
                                                        ]),
                                                    ]),
                                                    t(
                                                        'div',
                                                        { staticClass: 'handler' },
                                                        [
                                                            'NORMAL' === s.recordLesson.displayStatus
                                                                ? t(
                                                                    'a-button',
                                                                    {
                                                                        directives: [
                                                                            {
                                                                                name: 'log',
                                                                                rawName: 'v-log',
                                                                            },
                                                                        ],
                                                                        staticClass: 'color-orange',
                                                                        attrs: {
                                                                            type: 'link',
                                                                            shape: 'round',
                                                                            loading: e.loading,
                                                                            'data-log': ''
                                                                                .concat(
                                                                                    e.$t('courses.recordCourse.enter'),
                                                                                    ' '
                                                                                )
                                                                                .concat(s.recordLesson.lessonId),
                                                                        },
                                                                        on: {
                                                                            click: function (t) {
                                                                                return (
                                                                                    t.stopPropagation(),
                                                                                    e.handlerEnter(
                                                                                        s.recordLesson.lessonId
                                                                                    )
                                                                                )
                                                                            },
                                                                        },
                                                                    },
                                                                    [
                                                                        e._v(
                                                                            ' ' +
                                                                            e._s(
                                                                                e.$t('courses.recordCourse.enter')
                                                                            ) +
                                                                            ' '
                                                                        ),
                                                                    ]
                                                                )
                                                                : 'REFUND' === s.recordLesson.displayStatus
                                                                    ? t('span', [
                                                                        e._v(
                                                                            e._s(e.$t('courses.recordCourse.refunded'))
                                                                        ),
                                                                    ])
                                                                    : t('span', [
                                                                        e._v(
                                                                            e._s(e.$t('courses.recordCourse.expired'))
                                                                        ),
                                                                    ]),
                                                        ],
                                                        1
                                                    ),
                                                ]),
                                                s.recordLesson.homework
                                                    ? t('div', { staticClass: 'syllabus-bottom-item' }, [
                                                        t('div', { staticClass: 'exam-info' }, [
                                                            t('span', {
                                                                staticClass: 'exam-icon common-icon',
                                                            }),
                                                            t('span', { staticClass: 'title' }, [
                                                                e._v(e._s(s.recordLesson.homework.title)),
                                                            ]),
                                                        ]),
                                                        t(
                                                            'div',
                                                            { staticClass: 'handler' },
                                                            [
                                                                e.examButton[
                                                                    s.recordLesson.homework.displayStatus
                                                                ] &&
                                                                    e.examButton[
                                                                        s.recordLesson.homework.displayStatus
                                                                    ].buttonClassName
                                                                    ? t(
                                                                        'a-button',
                                                                        {
                                                                            class:
                                                                                e.examButton[
                                                                                    s.recordLesson.homework
                                                                                        .displayStatus
                                                                                ].buttonClassName,
                                                                            attrs: {
                                                                                type: 'link',
                                                                                shape: 'round',
                                                                                loading: e.assignmentBtnLoading,
                                                                            },
                                                                            on: {
                                                                                click: function (t) {
                                                                                    return e.handlerClassExam(
                                                                                        s.recordLesson
                                                                                    )
                                                                                },
                                                                            },
                                                                        },
                                                                        [
                                                                            e._v(
                                                                                ' ' +
                                                                                e._s(
                                                                                    e.examButton[
                                                                                        s.recordLesson.homework
                                                                                            .displayStatus
                                                                                    ].buttonName
                                                                                ) +
                                                                                ' '
                                                                            ),
                                                                        ]
                                                                    )
                                                                    : 'REFUND' === s.recordLesson.displayStatus
                                                                        ? t('span', [
                                                                            e._v(
                                                                                e._s(
                                                                                    e.$t('courses.recordCourse.refunded')
                                                                                )
                                                                            ),
                                                                        ])
                                                                        : t('span', [
                                                                            e._v(
                                                                                e._s(
                                                                                    e.$t('courses.recordCourse.expired')
                                                                                )
                                                                            ),
                                                                        ]),
                                                            ],
                                                            1
                                                        ),
                                                    ])
                                                    : e._e(),
                                            ]),
                                        ]
                                    )
                                }),
                                0
                            )
                        }),
                u = [],
                d =
                    (s('14d9'),
                    {
                        props: {
                            scheduleList: {
                                type: Array,
                                default: function () {
                                    return []
                                },
                            },
                            courseData: {
                                type: Object,
                                default: function () {
                                    return {}
                                },
                            },
                        },
                        data: function () {
                            return {
                                examButton: {
                                    TO_BE_SUBMIT: {
                                        buttonClassName: 'color-green',
                                        buttonName: this.$t('courses.recordCourse.goToTest'),
                                    },
                                    SUBMITTED: {
                                        buttonClassName: 'color-orange',
                                        buttonName: this.$t('courses.recordCourse.report'),
                                    },
                                },
                            }
                        },
                        methods: {
                            calIndex: function (e) {
                                return (
                                    console.info(
                                        '对象函数 calIndex(index)',
                                        e,
                                        'filePath:renderer/components/Courses/RecordSyllabusList.vue'
                                    ),
                                    e <= 9 ? '0'.concat(e) : e
                                )
                            },
                            getTime: function (e) {
                                return (
                                    console.info(
                                        '对象函数 getTime(recordLesson)',
                                        e,
                                        'filePath:renderer/components/Courses/RecordSyllabusList.vue'
                                    ),
                                    e.resourceList.length && e.resourceList[0].duration
                                )
                            },
                            handlerEnter: function (e) {
                                console.info(
                                    '对象函数 handlerEnter(lessonId)',
                                    e,
                                    'filePath:renderer/components/Courses/RecordSyllabusList.vue'
                                )
                                var t = this.courseData,
                                    s = t.id,
                                    o = t.name,
                                    r = t.studentCourseId
                                this.$router.push({
                                    path: '/record-courses-video',
                                    query: {
                                        studentCourseId: r,
                                        lessonId: e,
                                    },
                                })
                                this.$sensors.track('hw_recorded_course_enter_click', {
                                    goods_id: s,
                                    goods_name: o,
                                })
                            },
                            handlerClassExam: function (e) {
                                if (
                                    (console.info(
                                        '对象函数 handlerClassExam(recordLesson)',
                                        e,
                                        'filePath:renderer/components/Courses/RecordSyllabusList.vue'
                                    ),
                                        'SUBMITTED' === e.homework.displayStatus)
                                ) {
                                    console.info(
                                        "if(recordLesson.homework.displayStatus === 'SUBMITTED')为true触发return,path: /renderer/components/Courses/RecordSyllabusList.vue"
                                    )
                                    var t = JSON.parse(window.localStorage.getItem('userInfo'))
                                    return (
                                        window.sessionStorage.setItem(
                                            'iframeUrl',
                                            ''
                                                .concat(e.homework.url, '&token=')
                                                .concat(
                                                    null === t || void 0 === t
                                                        ? void 0
                                                        : t.unifiedAccessToken
                                                )
                                        ),
                                        window.sessionStorage.setItem(
                                            'backUrl',
                                            this.$route.fullPath
                                        ),
                                        void this.$router.push({ path: '/examH5' })
                                    )
                                }
                                this.$router.push({
                                    path: '/examIntro',
                                    query: {
                                        classType: 'RECORD',
                                        planId: e.lessonId,
                                        permanent: this.courseData.permanent,
                                        expirationTime: this.courseData.expirationTime,
                                        courseData: this.courseData,
                                        studentCourseId: this.$route.query.studentCourseId,
                                        homeworkType: e.homework.type,
                                        entityId: e.homework.entityId,
                                    },
                                })
                            },
                        },
                    }),
                h = d,
                f = (s('a832'), s('2877')),
                p = Object(f.a)(h, l, u, false, null, 'b021c8dc', null),
                v = p.exports,
                m = function () {
                    var e = this,
                        t = e._self._c
                    return e.courseData
                        ? t(
                            'div',
                            { staticClass: 'record-syllabus-nav' },
                            [
                                t('div', { staticClass: 'name-subject' }, [
                                    e.courseData.subjectTag
                                        ? t('span', { staticClass: 'label' }, [
                                            e._v(e._s(e.courseData.subjectTag)),
                                        ])
                                        : e._e(),
                                    t('span', [e._v(e._s(e.courseData.name))]),
                                ]),
                                t('div', { staticClass: 'class-date' }, [
                                    t('span', { staticClass: 'classtime-icon' }),
                                    t(
                                        'div',
                                        { staticClass: 'time-text' },
                                        [
                                            e.courseData.permanent
                                                ? [
                                                    e._v(
                                                        ' ' + e._s(e.recordConfig.permanentTip) + ' '
                                                    ),
                                                ]
                                                : t(
                                                    'span',
                                                    { class: { expired: e.courseData.expired } },
                                                    [
                                                        e._v(
                                                            e._s(e.recordConfig.courseValidUntil) +
                                                            ' ' +
                                                            e._s(e.courseData.expirationTime)
                                                        ),
                                                    ]
                                                ),
                                        ],
                                        2
                                    ),
                                ]),
                                e.courseData.teachers
                                    ? t(
                                        'div',
                                        {
                                            ref: 'teacher',
                                            staticClass: 'teacher',
                                        },
                                        [
                                            e.showArrow
                                                ? [
                                                    t('span', {
                                                        staticClass: 'left-arrow',
                                                        on: { click: e.clickLeftArrow },
                                                    }),
                                                    t('span', {
                                                        staticClass: 'left-shadow common-shadow',
                                                    }),
                                                ]
                                                : e._e(),
                                            t(
                                                'div',
                                                {
                                                    staticClass: 'teacthers',
                                                    style: { width: e.teachersWidth },
                                                },
                                                [
                                                    t(
                                                        'div',
                                                        {
                                                            ref: 'scrollWrapper',
                                                            staticClass: 'teacher-wrapper',
                                                        },
                                                        e._l(e.courseData.teachers, function (s, o) {
                                                            var r
                                                            return t(
                                                                'div',
                                                                {
                                                                    key: 'teacher-'.concat(o),
                                                                    staticClass: 'item',
                                                                },
                                                                [
                                                                    null !== s &&
                                                                        void 0 !== s &&
                                                                        null !== (r = s.contactInfoListV2) &&
                                                                        void 0 !== r &&
                                                                        r.length
                                                                        ? t(
                                                                            'div',
                                                                            {
                                                                                staticClass:
                                                                                    'avator-wrap-contact',
                                                                                on: {
                                                                                    click: function (t) {
                                                                                        return e.openContact(s)
                                                                                    },
                                                                                },
                                                                            },
                                                                            [
                                                                                t(
                                                                                    'span',
                                                                                    {
                                                                                        staticClass:
                                                                                            'avator-wrap pointer',
                                                                                    },
                                                                                    [
                                                                                        t('a-avatar', {
                                                                                            attrs: {
                                                                                                icon: 'user',
                                                                                                src: s.avatar,
                                                                                            },
                                                                                        }),
                                                                                        t('span', {
                                                                                            class: e.getContactClass(
                                                                                                s.contactInfoListV2
                                                                                            ),
                                                                                        }),
                                                                                        t('span', {
                                                                                            staticClass:
                                                                                                'contact-masker',
                                                                                        }),
                                                                                    ],
                                                                                    1
                                                                                ),
                                                                            ]
                                                                        )
                                                                        : t(
                                                                            'span',
                                                                            { staticClass: 'avator-wrap' },
                                                                            [
                                                                                t('a-avatar', {
                                                                                    attrs: {
                                                                                        icon: 'user',
                                                                                        src: s.avatar,
                                                                                    },
                                                                                }),
                                                                            ],
                                                                            1
                                                                        ),
                                                                    t('div', { staticClass: 'info' }, [
                                                                        t('div', { staticClass: 'name' }, [
                                                                            e._v(e._s(s.name)),
                                                                        ]),
                                                                        t('span', { staticClass: 'title' }, [
                                                                            t('span', [
                                                                                e._v(e._s(s.identityName)),
                                                                            ]),
                                                                        ]),
                                                                    ]),
                                                                ]
                                                            )
                                                        }),
                                                        0
                                                    ),
                                                ]
                                            ),
                                            e.showArrow
                                                ? [
                                                    t('span', {
                                                        staticClass: 'right-shadow common-shadow',
                                                    }),
                                                    t('span', {
                                                        staticClass: 'right-arrow',
                                                        on: { click: e.clickRightArrow },
                                                    }),
                                                ]
                                                : e._e(),
                                        ],
                                        2
                                    )
                                    : e._e(),
                                e.courseData.expired
                                    ? t('div', { staticClass: 'class-status' })
                                    : e._e(),
                                e.isOpenContact
                                    ? t('TeacherContact', {
                                        attrs: { data: e.curContactInfo },
                                        on: { closeModal: e.closeContact },
                                    })
                                    : e._e(),
                            ],
                            1
                        )
                        : e._e()
                },
                C = [],
                w = s('8759'),
                y = {
                    props: {
                        courseData: {
                            type: Object,
                            default: function () {
                                return {}
                            },
                        },
                    },
                    components: { TeacherContact: w.a },
                    data: function () {
                        return {
                            recordConfig: this.$t('courses.recordCourse'),
                            teachersWidth: '',
                            scrollLength: 7,
                            isOpenContact: false,
                            curContactInfo: null,
                            contactMap: {
                                weChat: 'contact_wechat',
                                whatsApp: 'contact_whatsapp',
                                line: 'contact_line',
                            },
                        }
                    },
                    computed: {
                        showArrow: function () {
                            return (
                                console.info(
                                    '对象函数 showArrow,filePath:renderer/components/Courses/RecordSyllabusNav.vue'
                                ),
                                this.courseData.teachers.length > this.scrollLength &&
                                (console.info(
                                    'if(this.courseData.teachers.length > this.scrollLength)为true触发return,path: /renderer/components/Courses/RecordSyllabusNav.vue'
                                ),
                                    (this.teachersWidth = '94%'),
                                    true)
                            )
                        },
                    },
                    methods: {
                        closeContact: function () {
                            console.info(
                                '对象函数 closeContact,filePath:renderer/components/Courses/RecordSyllabusNav.vue'
                            )
                            this.isOpenContact = false
                            this.curContactInfo = null
                        },
                        openContact: function (e) {
                            console.info(
                                '对象函数 openContact(item)',
                                e,
                                'filePath:renderer/components/Courses/RecordSyllabusNav.vue'
                            )
                            this.curContactInfo = e
                            this.isOpenContact = true
                            this.$sensors.track('hw_contact_teacher_icon_click', {
                                teacher_category: e.identityType,
                            })
                        },
                        getContactClass: function (e) {
                            return (
                                console.info(
                                    '对象函数 getContactClass(list)',
                                    e,
                                    'filePath:renderer/components/Courses/RecordSyllabusNav.vue'
                                ),
                                e.length > 1
                                    ? (console.info(
                                        'if(list.length > 1)为true触发return,path: /renderer/components/Courses/RecordSyllabusNav.vue'
                                    ),
                                        'contact_normal')
                                    : (console.info(
                                        'if(list.length > 1)为false,触发return,path: /renderer/components/Courses/RecordSyllabusNav.vue'
                                    ),
                                        this.contactMap[e[0].type])
                            )
                        },
                        showPrevTeachers: function () {
                            console.info(
                                '对象函数 showPrevTeachers,filePath:renderer/components/Courses/RecordSyllabusNav.vue'
                            )
                            this.$refs.carousel.prev()
                        },
                        showNextTeachers: function () {
                            console.info(
                                '对象函数 showNextTeachers,filePath:renderer/components/Courses/RecordSyllabusNav.vue'
                            )
                            this.$refs.carousel.next()
                        },
                        clickRightArrow: function () {
                            console.info(
                                '对象函数 clickRightArrow,filePath:renderer/components/Courses/RecordSyllabusNav.vue'
                            )
                            this.moveSlow(1)
                        },
                        clickLeftArrow: function () {
                            console.info(
                                '对象函数 clickLeftArrow,filePath:renderer/components/Courses/RecordSyllabusNav.vue'
                            )
                            var e = -1
                            this.moveSlow(e)
                        },
                        moveSlow: function (e) {
                            var t = this
                            console.info(
                                '对象函数 moveSlow(direction)',
                                e,
                                'filePath:renderer/components/Courses/RecordSyllabusNav.vue'
                            )
                            var s = null,
                                o = null,
                                r = 240,
                                a = function a(n) {
                                    console.info(
                                        '箭头函数 step(timestamp)',
                                        n,
                                        'filePath:renderer/components/Courses/RecordSyllabusNav.vue'
                                    )
                                    s || (s = n)
                                    o = n - s
                                    t.$refs.scrollWrapper.scrollLeft += e * Math.min(o / 15, 150)
                                    r -= Math.min(o / 15, 150)
                                    o < 1000 &&
                                        r > 0 &&
                                        (t.animationId = window.requestAnimationFrame(a))
                                }
                            this.animationId = window.requestAnimationFrame(a)
                        },
                    },
                    destoryed: function () {
                        console.info(
                            '对象函数 destoryed,filePath:renderer/components/Courses/RecordSyllabusNav.vue'
                        )
                        window.cancelAnimationFrame(this.animationId)
                    },
                },
                g = y,
                _ = (s('3206'), Object(f.a)(g, m, C, false, null, '36601303', null)),
                b = _.exports,
                D = s('7e54'),
                A = {
                    components: {
                        Loading: c.a,
                        ErrorStatus: i.a,
                        RecordSyllabusList: v,
                        RecordSyllabusNav: b,
                    },
                    data: function () {
                        return {
                            loading: true,
                            courseData: {},
                            scheduleList: [],
                            isError: false,
                        }
                    },
                    created: function () {
                        this.updateHeaderAttr()
                    },
                    mounted: function () {
                        var e = this
                        this.queryData(function () {
                            console.info(
                                '箭头函数 queryData,filePath:renderer/views/RecordCoursesDetail.vue'
                            )
                            e.addContactTeacherSensor()
                        })
                        this.$bus.$on('reload', function () {
                            console.info(
                                '箭头函数 监听 reload,filePath:renderer/views/RecordCoursesDetail.vue'
                            )
                            e.queryData(function () {
                                console.info(
                                    '箭头函数 queryData,filePath:renderer/views/RecordCoursesDetail.vue'
                                )
                                delete e.$route.query.isNeedBackToCurrentTap
                            })
                        })
                    },
                    destroyed: function () {
                        console.info(
                            '对象函数 destroyed,filePath:renderer/views/RecordCoursesDetail.vue'
                        )
                        this.$bus.$off('reload')
                    },
                    methods: {
                        addContactTeacherSensor: function () {
                            var e
                            console.info(
                                '对象函数 addContactTeacherSensor,filePath:renderer/views/RecordCoursesDetail.vue'
                            )
                            var t =
                                (null === (e = this.courseData) || void 0 === e
                                    ? void 0
                                    : e.teachers) || [],
                                s = t.filter(function (e) {
                                    return 2 === e.identityType
                                }),
                                o = t.filter(function (e) {
                                    var t
                                    return (
                                        1 === e.identityType &&
                                        !(
                                            null === (t = e.contactInfoListV2) ||
                                            void 0 === t ||
                                            !t.length
                                        )
                                    )
                                })
                            if (s.length) {
                                var r = s.filter(function (e) {
                                    var t
                                    return !(
                                        null === (t = e.contactInfoListV2) ||
                                        void 0 === t ||
                                        !t.length
                                    )
                                })
                                r.length &&
                                    this.$sensors.track('hw_contact_teacher_icon_show', {
                                        teacher_category: 2,
                                    })
                            } else {
                                o.length &&
                                    this.$sensors.track('hw_contact_teacher_icon_show', {
                                        teacher_category: 1,
                                    })
                            }
                        },
                        queryData: function (e) {
                            var t = this
                            return Object(n.a)(
                                Object(a.a)().mark(function s() {
                                    var o, r, n, c, i, l
                                    return Object(a.a)().wrap(function (s) {
                                        while (1) {
                                            switch ((s.prev = s.next)) {
                                                case 0:
                                                    return (
                                                        console.info(
                                                            '对象函数 queryData(callback)',
                                                            e,
                                                            'filePath:renderer/views/RecordCoursesDetail.vue'
                                                        ),
                                                        (t.loading = true),
                                                        (t.isError = false),
                                                        (s.next = 5),
                                                        Object(D.d)(t, {
                                                            studentCourseId: t.$route.query.studentCourseId,
                                                        })
                                                            .finally(function () {
                                                                console.info(
                                                                    '箭头函数 getSchedule的finally,filePath:renderer/views/RecordCoursesDetail.vue'
                                                                )
                                                                t.loading = false
                                                                t.$bus.$emit('reload-completed')
                                                            })
                                                            .catch(function (e) {
                                                                console.info(
                                                                    '箭头函数 catch(err)',
                                                                    e,
                                                                    'filePath:renderer/views/RecordCoursesDetail.vue'
                                                                )
                                                                t.isError = true
                                                                t.isLoading = false
                                                                console.error('获取录播课讲次列表接口报错:', e)
                                                            })
                                                    )
                                                case 5:
                                                    if (((o = s.sent), o && 0 == o.code)) {
                                                        s.next = 10
                                                        break
                                                    }
                                                    return (
                                                        console.info(
                                                            'if(!res || res.code != 0)为true触发return,path: /renderer/views/RecordCoursesDetail.vue'
                                                        ),
                                                        (t.isError = true),
                                                        s.abrupt('return')
                                                    )
                                                case 10:
                                                    ; (r = o.data || {}),
                                                        (t.courseData = r.course),
                                                        (t.scheduleList = r.scheduleList || []),
                                                        t.$store.dispatch(
                                                            'courses/setRecordCoursesDetail',
                                                            r
                                                        ),
                                                        e && e(r),
                                                        (t.loading = false),
                                                        (n = t.courseData),
                                                        (c = n.expired),
                                                        (i = n.id),
                                                        (l = n.name),
                                                        t.$sensors.track('hw_recorded_course_detail_pv', {
                                                            recorded_class_state: c ? 0 : 1,
                                                            goods_id: i,
                                                            goods_name: l,
                                                        })
                                                case 18:
                                                case 'end':
                                                    return s.stop()
                                            }
                                        }
                                    }, s)
                                })
                            )()
                        },
                        updateHeaderAttr: function () {
                            console.info(
                                '对象函数 updateHeaderAttr,filePath:renderer/views/RecordCoursesDetail.vue'
                            )
                            var e = this.$t('courses.detail.title')
                            this.$bus.$emit('updateHeaderAttr', {
                                title: e,
                                showGoback: true,
                                backUrl: '/courses?courseType=RECORD',
                            })
                        },
                    },
                },
                L = A,
                S = (s('114c'), Object(f.a)(L, o, r, false, null, '557ff8d7', null))
            t.default = S.exports
        },
        a79d: function (e, t, s) {
            'use strict'
            var o = s('23e7'),
                r = s('c430'),
                a = s('d256'),
                n = s('d039'),
                c = s('d066'),
                i = s('1626'),
                l = s('4840'),
                u = s('cdf9'),
                d = s('cb2d'),
                h = a && a.prototype,
                f =
                    !!a &&
                    n(function () {
                        h.finally.call(
                            {
                                then: function () { },
                            },
                            function () { }
                        )
                    })
            if (
                (o(
                    {
                        target: 'Promise',
                        proto: true,
                        real: true,
                        forced: f,
                    },
                    {
                        finally: function (e) {
                            var t = l(this, c('Promise')),
                                s = i(e)
                            return this.then(
                                s
                                    ? function (s) {
                                        return u(t, e()).then(function () {
                                            return s
                                        })
                                    }
                                    : e,
                                s
                                    ? function (s) {
                                        return u(t, e()).then(function () {
                                            throw s
                                        })
                                    }
                                    : e
                            )
                        },
                    }
                ),
                    !r && i(a))
            ) {
                var p = c('Promise').prototype.finally
                h.finally !== p && d(h, 'finally', p, { unsafe: true })
            }
        },
        a832: function (e, t, s) {
            'use strict'
            s('ae5b')
        },
        ae5b: function (e, t, s) { },
        bd12: function (e, t, s) {
            'use strict'
            var o = function () {
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
                r = [
                    function () {
                        var e = this,
                            t = e._self._c
                        return t('div', { staticClass: 'loading-contenter' }, [
                            t('div', { staticClass: 'loading-logo' }, [
                                t('img', { attrs: { src: s('c63e') } }),
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
                n = a,
                c = (s('f761'), s('2877')),
                i = Object(c.a)(n, o, r, false, null, '92d727e8', null)
            t.a = i.exports
        },
        c63e: function (e, t) {
            e.exports =
                'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFAAAABQCAMAAAC5zwKfAAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAAA8UExURUdwTP/DL//DLv/BL//DLv/EL//DL//DLv/DL//CLv/DL//DL//CLf/DL//DL//DL//DLv/DL//DMv/DMGSQIxsAAAATdFJOUwDwcSTeYM1AwICojww0SLNSmhsrwQ8LAAABI0lEQVRYw+3X2a6DIBCAYbaBYXXh/d/1aE3UxtbjMhdtOv+l6BeiiYAQ5+tzLwhK2oGKjTW1Vn/HyQV8NzlzF8HRkfVV10BX38Ygg18FptICKB+70OAWDD4GNPIMaJentyAuv4l8FKx7IIjYdB7a3CdBArplWFoMUYHTiQhcZdDTgqt3yyCDdgTlkBmy1iLeBIcJ7Q6fB2txzpGCYwz+HuhWAR4BcR98LhwAU6vGlXIDaruZexBwAJy35dN2WtadNX++iESbiK8BDRYyULWXT0AvwTsxyCCDnwJaUhAjaCrQBFWSuNsESoytFiRpYzqVxc/kh0Mipaemj2tDHE62iWKCh7daDDLI4CeDhRoUPXSWFHysASpIUnAsK6QFp+Pjf3f8AVRMjNs7xw9TAAAAAElFTkSuQmCC'
        },
        dd46: function (e, t, s) { },
        ebc2: function (e, t, s) { },
        f761: function (e, t, s) {
            'use strict'
            s('ebc2')
        },
    },
])
