; (window.webpackJsonp = window.webpackJsonp || []).push([
  ['chunk-1f5d7637'],
  {
    '17c8': function (t, e, a) { },
    '1a4e': function (t, e, a) {
      'use strict'
      var s = function () {
        var t = this,
          e = t._self._c
        return e(
          'div',
          {
            staticClass: 'empty-status',
            class: { small: 'small' == t.size },
          },
          [e('div', { staticClass: 'message' }, [t._v(t._s(t.message))])]
        )
      },
        n = [],
        o = {
          name: 'EmptyStatus',
          data: function () {
            return { showSwitchAccount: false }
          },
          props: {
            message: {
              type: String,
              default: '',
            },
            size: {
              default: 'normal',
              type: String,
            },
          },
        },
        i = o,
        c = (a('a4ed1'), a('2877')),
        r = Object(c.a)(i, s, n, false, null, '46393ed8', null)
      e.a = r.exports
    },
    4252: function (t, e, a) { },
    '54c0': function (t, e, a) {
      'use strict'
      a('4252')
    },
    8796: function (t, e, a) { },
    a4ed1: function (t, e, a) {
      'use strict'
      a('8796')
    },
    aaf0: function (t, e, a) {
      'use strict'
      var s = function () {
        var t = this,
          e = t._self._c
        return e(
          'div',
          {
            class: ['error-wrapper', t.bgWhiteAuth ? 'bg-white' : ''],
          },
          [
            e('div', { staticClass: 'center' }, [
              e('div', { staticClass: 'error-status' }),
              e('div', { staticClass: 'message' }, [
                e('div', { staticClass: 'message-main' }, [
                  t._v(t._s(t.message)),
                ]),
                t.scene
                  ? e('p', { staticClass: 'message-sub' }, [
                    t._v(
                      ' ' +
                      t._s('Scene: '.concat(t.scene, '.')) +
                      ' ' +
                      t._s(t.subMessage) +
                      ' '
                    ),
                  ])
                  : t._e(),
              ]),
              e(
                'div',
                { staticClass: 'button-wrapper' },
                [
                  t.showRefresh
                    ? e(
                      'a-button',
                      {
                        class:
                          t.showBack || t.isClassLiveOrPlayback
                            ? 'mr40'
                            : '',
                        attrs: {
                          type: 'primary',
                          shape: 'round',
                          size: 'large',
                        },
                        on: { click: t.handleRefresh },
                      },
                      [t._v(' ' + t._s(t.$t('common.refresh')) + ' ')]
                    )
                    : t._e(),
                  t.showBack || t.isClassLiveOrPlayback
                    ? e(
                      'a-button',
                      {
                        staticClass: 'color-orange',
                        attrs: {
                          shape: 'round',
                          size: 'large',
                        },
                        on: { click: t.handleBack },
                      },
                      [
                        t._v(
                          ' ' +
                          t._s(
                            t.isClassLiveOrPlayback
                              ? t.$t(
                                'classroom.modules.systemError.backButtonName'
                              )
                              : t.$t('common.back')
                          ) +
                          ' '
                        ),
                      ]
                    )
                    : t._e(),
                ],
                1
              ),
            ]),
          ]
        )
      },
        n = [],
        o =
          (a('14d9'),
            a('caad'),
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
        i = o,
        c = (a('dc2d'), a('2877')),
        r = Object(c.a)(i, s, n, false, null, 'f910b7da', null)
      e.a = r.exports
    },
    bd12: function (t, e, a) {
      'use strict'
      var s = function () {
        var t = this,
          e = t._self._c
        return t.show
          ? e(
            'div',
            {
              staticClass: 'loading-wrapper',
              class: t.className,
              style: t.loadingStyle,
            },
            [t._m(0)]
          )
          : t._e()
      },
        n = [
          function () {
            var t = this,
              e = t._self._c
            return e('div', { staticClass: 'loading-contenter' }, [
              e('div', { staticClass: 'loading-logo' }, [
                e('img', { attrs: { src: a('c63e') } }),
              ]),
              e('div', { staticClass: 'loading-animation' }),
            ])
          },
        ],
        data_2 = {
          name: 'Loading',
          props: {
            show: {
              default: true,
              type: Boolean,
            },
            size: {
              default: 'default',
              type: String,
              validator: function (t) {
                return (
                  console.info(
                    '对象函数 validator(value)',
                    t,
                    'filePath:renderer/components/Common/Loading.vue'
                  ),
                  -1 !== ['small', 'default'].indexOf(t)
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
        i = data_2,
        c = (a('f761'), a('2877')),
        r = Object(c.a)(i, s, n, false, null, '92d727e8', null)
      e.a = r.exports
    },
    c63e: function (t, e) {
      t.exports =
        'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFAAAABQCAMAAAC5zwKfAAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAAA8UExURUdwTP/DL//DLv/BL//DLv/EL//DL//DLv/DL//CLv/DL//DL//CLf/DL//DL//DL//DLv/DL//DMv/DMGSQIxsAAAATdFJOUwDwcSTeYM1AwICojww0SLNSmhsrwQ8LAAABI0lEQVRYw+3X2a6DIBCAYbaBYXXh/d/1aE3UxtbjMhdtOv+l6BeiiYAQ5+tzLwhK2oGKjTW1Vn/HyQV8NzlzF8HRkfVV10BX38Ygg18FptICKB+70OAWDD4GNPIMaJentyAuv4l8FKx7IIjYdB7a3CdBArplWFoMUYHTiQhcZdDTgqt3yyCDdgTlkBmy1iLeBIcJ7Q6fB2txzpGCYwz+HuhWAR4BcR98LhwAU6vGlXIDaruZexBwAJy35dN2WtadNX++iESbiK8BDRYyULWXT0AvwTsxyCCDnwJaUhAjaCrQBFWSuNsESoytFiRpYzqVxc/kh0Mipaemj2tDHE62iWKCh7daDDLI4CeDhRoUPXSWFHysASpIUnAsK6QFp+Pjf3f8AVRMjNs7xw9TAAAAAElFTkSuQmCC'
    },
    dc2d: function (t, e, a) {
      'use strict'
      a('17c8')
    },
    e300: function (t, e, data_0) {
      'use strict'
      data_0.r(e)
      var data_1 = function () {
        var obj_0 = this,
          func_0 = obj_0._self._c
        return func_0(
          'div',
          {
            staticClass: 'page-wrapper',
            attrs: { 'data-log': '我的账号页面' },
          },
          [
            func_0(
              'div',
              { staticClass: 'my-accont-page-template' },
              [
                obj_0.isError
                  ? [
                    func_0('ErrorStatus', {
                      attrs: { scene: 'MyAccount' },
                      on: { 'click-refresh': obj_0.init },
                    }),
                  ]
                  : obj_0.isLoading
                    ? [
                      obj_0.isLoading
                        ? func_0('Loading', { attrs: { 'margin-top': '200px' } })
                        : obj_0._e(),
                    ]
                    : [
                      func_0('div', { staticClass: 'my-account-main-container' }, [
                        func_0(
                          'div',
                          { staticClass: 'my-account-body-container' },
                          [
                            func_0(
                              'div',
                              { staticClass: 'current-account-card' },
                              [
                                func_0('div', { staticClass: 'stu-card' }, [
                                  func_0('div', { staticClass: 'stu-avatar' }, [
                                    func_0('img', {
                                      attrs: {
                                        src: obj_0.userInfo.avatar,
                                        alt: '',
                                      },
                                    }),
                                  ]),
                                  func_0('div', { staticClass: 'stu-name' }, [
                                    obj_0._v(
                                      ' ' + obj_0._s(obj_0.userInfo.nickName) + ' '
                                    ),
                                  ]),
                                  func_0('div', { staticClass: 'card-footer' }, [
                                    func_0('div', { staticClass: 'stu-no' }, [
                                      func_0('span', [obj_0._v('No.')]),
                                      func_0('span', [
                                        obj_0._v(
                                          obj_0._s(
                                            obj_0._f('formatCardNo')(
                                              obj_0.userInfo.card
                                            )
                                          )
                                        ),
                                      ]),
                                    ]),
                                    func_0(
                                      'div',
                                      {
                                        staticClass: 'btn-copy-stu-no',
                                        on: { click: obj_0.handleCopy },
                                      },
                                      [obj_0._v(obj_0._s(obj_0.$t('common.copy')))]
                                    ),
                                  ]),
                                ]),
                                func_0('div', { staticClass: 'resetPassword' }, [
                                  func_0(
                                    'a',
                                    {
                                      attrs: { href: 'javascript:;' },
                                      on: { click: obj_0.resetPassword },
                                    },
                                    [
                                      obj_0._v(
                                        obj_0._s(
                                          obj_0.$t(
                                            'account.accountVerification.clickToResetPw[0]'
                                          )
                                        )
                                      ),
                                    ]
                                  ),
                                  obj_0._v(
                                    ' ' +
                                    obj_0._s(
                                      obj_0.$t(
                                        'account.accountVerification.clickToResetPw[1]'
                                      )
                                    ) +
                                    ' '
                                  ),
                                ]),
                                func_0(
                                  'div',
                                  {
                                    staticClass: 'copy-toast-tip',
                                    class: { show: obj_0.showCopiedToast },
                                  },
                                  [obj_0._v(' ' + obj_0._s(obj_0.copiedToastMsg) + ' ')]
                                ),
                              ]
                            ),
                            func_0(
                              'div',
                              { staticClass: 'other-acounts-card' },
                              [
                                func_0('div', { staticClass: 'title' }, [
                                  obj_0._v(
                                    obj_0._s(
                                      obj_0.$t(
                                        'account.accountVerification.otherStudents'
                                      )
                                    )
                                  ),
                                ]),
                                func_0('div', { staticClass: 'tip-text' }, [
                                  obj_0._v(
                                    obj_0._s(
                                      obj_0.$t('account.accountVerification.note')
                                    )
                                  ),
                                ]),
                                0 == obj_0.studentsList.length
                                  ? [
                                    func_0('EmptyStatus', {
                                      attrs: {
                                        message: obj_0.$t(
                                          'account.accountVerification.noAccountAssociated'
                                        ),
                                        size: 'small',
                                      },
                                    }),
                                  ]
                                  : [
                                    func_0(
                                      'div',
                                      {
                                        staticClass:
                                          'student-list-container',
                                      },
                                      obj_0._l(obj_0.studentsList, function (a, s) {
                                        return func_0(
                                          'div',
                                          {
                                            key: s,
                                            staticClass: 'stu-item-card',
                                            on: {
                                              click: function (e) {
                                                return obj_0.handleSwitchAccount(
                                                  a
                                                )
                                              },
                                            },
                                          },
                                          [
                                            func_0(
                                              'div',
                                              { staticClass: 'stu-avatar' },
                                              [
                                                func_0('img', {
                                                  attrs: {
                                                    src: a.avatar,
                                                    alt: '',
                                                  },
                                                }),
                                              ]
                                            ),
                                            func_0(
                                              'div',
                                              { staticClass: 'stu-info' },
                                              [
                                                func_0(
                                                  'div',
                                                  {
                                                    staticClass: 'stu-name',
                                                  },
                                                  [obj_0._v(obj_0._s(a.nickName))]
                                                ),
                                                func_0(
                                                  'div',
                                                  { staticClass: 'stu-no' },
                                                  [
                                                    func_0('span', [
                                                      obj_0._v('No.'),
                                                    ]),
                                                    func_0('span', [
                                                      obj_0._v(
                                                        obj_0._s(
                                                          obj_0._f(
                                                            'formatCardNo'
                                                          )(a.card)
                                                        )
                                                      ),
                                                    ]),
                                                  ]
                                                ),
                                              ]
                                            ),
                                            func_0('div', {
                                              staticClass:
                                                'icon-btn-change',
                                            }),
                                          ]
                                        )
                                      }),
                                      0
                                    ),
                                  ],
                              ],
                              2
                            ),
                          ]
                        ),
                        func_0(
                          'div',
                          { staticClass: 'my-account-footer-contaienr' },
                          [
                            func_0(
                              'div',
                              {
                                staticClass: 'btn-back-to-courses',
                                on: { click: obj_0.handleBack },
                              },
                              [
                                func_0('a-icon', {
                                  attrs: { type: 'caret-left' },
                                }),
                                func_0('span', [
                                  obj_0._v(
                                    obj_0._s(
                                      obj_0.$t(
                                        'account.personalInformation.backToCourses'
                                      )
                                    )
                                  ),
                                ]),
                              ],
                              1
                            ),
                            obj_0.studentsList.length < 5
                              ? func_0(
                                'div',
                                {
                                  staticClass: 'btn-add-student',
                                  on: {
                                    click: function (e) {
                                      return obj_0.handleAddStu()
                                    },
                                  },
                                },
                                [
                                  func_0('span', [
                                    obj_0._v(
                                      obj_0._s(
                                        obj_0.$t(
                                          'account.accountVerification.addStudent'
                                        )
                                      )
                                    ),
                                  ]),
                                  func_0('span', {
                                    staticClass: 'icon-arrow-right',
                                  }),
                                ]
                              )
                              : func_0('div', { staticClass: 'tip-text' }, [
                                obj_0._v(
                                  obj_0._s(
                                    obj_0.$t(
                                      'account.accountVerification.maxAccount'
                                    )
                                  )
                                ),
                              ]),
                          ]
                        ),
                      ]),
                    ],
              ],
              2
            ),
          ]
        )
      },
        n = [],
        o = data_0('c7eb'),
        i = data_0('1da1'),
        c = (data_0('14d9'), data_0('ac1f'), data_0('5319'), data_0('bd12')),
        r = data_0('aaf0'),
        u = data_0('1a4e'),
        d = data_0('92e5'),
        l = data_0('ae3f'),
        f = data_0('0a4b'),
        h = data_0('2b6b'),
        p = {
          components: {
            Loading: c.a,
            ErrorStatus: r.a,
            EmptyStatus: u.a,
          },
          data: function () {
            return {
              isLoading: false,
              isError: false,
              isSwitching: false,
              showCopiedToast: false,
              copiedToastMsg: 'Copied Successfully',
              userInfo: {
                avatar: '',
                nickName: '',
                uid: '',
                card: '',
              },
              studentsList: [],
            }
          },
          filters: {
            formatCardNo: function (t) {
              return (
                console.info(
                  '对象函数 formatCardNo(val)',
                  t,
                  'filePath:renderer/views/MyAccount.vue'
                ),
                t || (t = ''),
                t.replace(/(.{4})/g, '$1 ')
              )
            },
          },
          mounted: function () {
            this.init()
          },
          methods: {
            resetPassword: function () {
              var t = this
              return Object(i.a)(
                Object(o.a)().mark(function e() {
                  var a, s
                  return Object(o.a)().wrap(function (e) {
                    while (1) {
                      switch ((e.prev = e.next)) {
                        case 0:
                          return (
                            console.info(
                              '对象函数 resetPassword,filePath:renderer/views/MyAccount.vue'
                            ),
                            (e.next = 3),
                            Object(l.c)({ changeType: 1 })
                          )
                        case 3:
                          if (((a = e.sent), a && 0 == a.code)) {
                            e.next = 8
                            break
                          }
                          return (
                            console.info(
                              'if(!res || res.code != 0)为true触发return,path: /renderer/views/MyAccount.vue'
                            ),
                            t.$Modal.warning({
                              class: 'modal-simple modal-changePassword',
                              content: t.$t(
                                'account.modifyPassword.noEmailOrPhoneLinked'
                              ),
                              width: '380px',
                              okText: t.$t('common.gotIt'),
                            }),
                            e.abrupt('return')
                          )
                        case 8:
                          ; (s = a.data || {}),
                            t.$store.dispatch('login/updatePasswordLoginType', {
                              type: 1 == s.helper.status ? 'mobile' : 'email',
                            }),
                            t.$Modal.confirm({
                              class: 'modal-simple modal-changePassword',
                              content: t.$t(
                                'account.modifyPassword.changePasswordTips'
                              ),
                              width: '380px',
                              okText: t.$t(
                                'account.modifyPassword.confirmChange'
                              ),
                              cancelText: t.$t('account.modifyPassword.cancel'),
                              onOk: function () {
                                t.$router.push({
                                  path: '/my-password-settings',
                                  query: {
                                    emailOrMobileStatus: s.helper.status,
                                    phoneNumber:
                                      1 == s.helper.status
                                        ? s.helper.extra.phone
                                        : '',
                                    countryCallingCode:
                                      1 == s.helper.status
                                        ? s.helper.extra.countryCallingCode
                                        : '',
                                    email:
                                      2 == s.helper.status
                                        ? s.helper.extra.email
                                        : '',
                                  },
                                })
                              },
                            })
                        case 11:
                        case 'end':
                          return e.stop()
                      }
                    }
                  }, e)
                })
              )()
            },
            init: function () {
              var t = this
              return Object(i.a)(
                Object(o.a)().mark(function e() {
                  return Object(o.a)().wrap(function (e) {
                    while (1) {
                      switch ((e.prev = e.next)) {
                        case 0:
                          return (
                            console.info(
                              '对象函数 init,filePath:renderer/views/MyAccount.vue'
                            ),
                            t.updateHeaderAttr(),
                            (t.isLoading = true),
                            (e.next = 5),
                            t.reloadUserInfo()
                          )
                        case 5:
                          t.isLoading = false
                        case 6:
                        case 'end':
                          return e.stop()
                      }
                    }
                  }, e)
                })
              )()
            },
            updateHeaderAttr: function () {
              console.info(
                '对象函数 updateHeaderAttr,filePath:renderer/views/MyAccount.vue'
              )
              this.$bus.$emit('updateHeaderAttr', {
                title: this.$t('account.myAccount.title'),
                showGoback: true,
                backUrl: '/courses',
              })
            },
            reloadUserInfo: function () {
              var t = this
              return Object(i.a)(
                Object(o.a)().mark(function e() {
                  return Object(o.a)().wrap(function (e) {
                    while (1) {
                      switch ((e.prev = e.next)) {
                        case 0:
                          return (
                            console.info(
                              '对象函数 reloadUserInfo,filePath:renderer/views/MyAccount.vue'
                            ),
                            (e.next = 3),
                            t.getLocalUserInfo()
                          )
                        case 3:
                          return (e.next = 5), t.getStudentsList()
                        case 5:
                        case 'end':
                          return e.stop()
                      }
                    }
                  }, e)
                })
              )()
            },
            getLocalUserInfo: function () {
              var t = this
              return Object(i.a)(
                Object(o.a)().mark(function e() {
                  var a
                  return Object(o.a)().wrap(function (e) {
                    while (1) {
                      switch ((e.prev = e.next)) {
                        case 0:
                          return (
                            console.info(
                              '对象函数 getLocalUserInfo,filePath:renderer/views/MyAccount.vue'
                            ),
                            (e.next = 3),
                            Object(d.a)()
                          )
                        case 3:
                          ; (a = e.sent),
                            (t.userInfo.avatar = a.avatar),
                            (t.userInfo.nickName = a.nickName),
                            (t.userInfo.uid = a.uid),
                            (t.userInfo.card = a.card),
                            (t.loadingUserInfo = false)
                        case 9:
                        case 'end':
                          return e.stop()
                      }
                    }
                  }, e)
                })
              )()
            },
            getStudentsList: function () {
              var t = this
              return Object(i.a)(
                Object(o.a)().mark(function e() {
                  var a, s
                  return Object(o.a)().wrap(function (e) {
                    while (1) {
                      switch ((e.prev = e.next)) {
                        case 0:
                          return (
                            console.info(
                              '对象函数 getStudentsList,filePath:renderer/views/MyAccount.vue'
                            ),
                            (e.next = 3),
                            Object(l.b)()
                          )
                        case 3:
                          if (
                            ((a = e.sent),
                              0 == (null === a || void 0 === a ? void 0 : a.code))
                          ) {
                            e.next = 8
                            break
                          }
                          return (
                            console.info(
                              'if(res?.code != 0)为true触发return,path: /renderer/views/MyAccount.vue'
                            ),
                            (t.isError = true),
                            e.abrupt('return')
                          )
                        case 8:
                          ; (s = a.data || {}),
                            (t.studentsList = s.associatedAccount || []),
                            (t.loadingStudentList = false)
                        case 11:
                        case 'end':
                          return e.stop()
                      }
                    }
                  }, e)
                })
              )()
            },
            handleAddStu: function () {
              console.info(
                '对象函数 handleAddStu,filePath:renderer/views/MyAccount.vue'
              )
              this.$router.push('/add-student')
            },
            handleSwitchAccount: function (t) {
              var e = this
              return Object(i.a)(
                Object(o.a)().mark(function a() {
                  var s, n, i
                  return Object(o.a)().wrap(function (a) {
                    while (1) {
                      switch ((a.prev = a.next)) {
                        case 0:
                          if (
                            (console.info(
                              '对象函数 handleSwitchAccount(stuInfo)',
                              t,
                              'filePath:renderer/views/MyAccount.vue'
                            ),
                              !e.isSwitching)
                          ) {
                            a.next = 4
                            break
                          }
                          return (
                            console.info(
                              'if(_this6.isSwitching)为true触发return,path: /renderer/views/MyAccount.vue'
                            ),
                            a.abrupt('return')
                          )
                        case 4:
                          return (
                            (e.isSwitching = true),
                            (s = { targetUid: t.uid }),
                            (a.next = 8),
                            Object(l.j)(s)
                          )
                        case 8:
                          if (((n = a.sent), n && 0 == n.code)) {
                            a.next = 14
                            break
                          }
                          return (
                            console.info(
                              'if(!res || res.code != 0)为true触发return,path: /renderer/views/MyAccount.vue'
                            ),
                            e.$Message.warn(
                              n.msg ||
                              e.$t(
                                'account.accountVerification.switchedFailed'
                              ),
                              1.5
                            ),
                            (e.isSwitching = false),
                            a.abrupt('return')
                          )
                        case 14:
                          return (
                            (i = n.data || {}),
                            e.$Message.success(
                              e.$t(
                                'account.accountVerification.switchedSuccessfully'
                              ),
                              1.5
                            ),
                            (a.next = 18),
                            Object(d.c)({
                              uid: i.uid,
                              card: i.card,
                              avatar: i.avatar,
                              email: i.email,
                              nickName: i.nickName,
                              countryCallingCode: i.countryCallingCode,
                              phone: i.phone,
                              unifiedAccessToken: i.unifiedAccessToken,
                            })
                          )
                        case 18:
                          Object(h.setUserAttributes)(),
                            e.$bus.$emit('update-userinfo'),
                            e.$bus.$emit('update-coin'),
                            e.reloadUserInfo(),
                            (e.isSwitching = false)
                        case 23:
                        case 'end':
                          return a.stop()
                      }
                    }
                  }, a)
                })
              )()
            },
            handleCopy: function () {
              if (
                (console.info(
                  '对象函数 handleCopy,filePath:renderer/views/MyAccount.vue'
                ),
                  !this.userInfo.card)
              ) {
                return (
                  console.info(
                    'if(!this.userInfo.card)为true触发return,path: /renderer/views/MyAccount.vue'
                  ),
                  (this.copiedToastMsg = this.$t(
                    'account.accountVerification.copiedFailed'
                  )),
                  void this.handleShowToast()
                )
              }
              this.copiedToastMsg = this.$t(
                'account.accountVerification.copiedSuccessfully'
              )
              f.nativeApi.clipboard.write(this.userInfo.card)
              this.handleShowToast()
            },
            handleShowToast: function () {
              var t = this
              console.info(
                '对象函数 handleShowToast,filePath:renderer/views/MyAccount.vue'
              )
              this.showCopiedToast = true
              setTimeout(function () {
                t.showCopiedToast = false
              }, 3000)
            },
            handleBack: function () {
              console.info(
                '对象函数 handleBack,filePath:renderer/views/MyAccount.vue'
              )
              this.$router.push('/courses')
            },
          },
        },
        v = p,
        m = (data_0('54c0'), data_0('2877')),
        w = Object(m.a)(v, data_1, n, false, null, 'bcc44dea', null)
      e.default = w.exports
    },
    ebc2: function (t, e, a) { },
    f761: function (t, e, a) {
      'use strict'
      a('ebc2')
    },
  },
])
