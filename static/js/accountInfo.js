; (window.webpackJsonp = window.webpackJsonp || []).push([
  ['chunk-f8b29358'],
  {
    1361: function (e, t, a) { },
    '1e79': function (e, t, a) {
      'use strict'
      a('c002')
    },
    '620c': function (e, t, a) {
      'use strict'
      var n = a('c7eb'),
        r = a('1da1'),
        o =
          (a('14d9'),
            a('a15b'),
            a('4de4'),
            a('d3b7'),
            a('ac1f'),
            a('159b'),
            a('b0c0'),
            a('bc8a'))
      t.a = {
        data: function () {
          return {
            schoolIsHk: false,
            formData: {},
            hasFocus: false,
            nickErrorTip: '',
            gradeList: [],
          }
        },
        computed: {
          nickNamePromptValue: function () {
            console.info(
              '对象函数 nickNamePromptValue,filePath:renderer/components/PersonalInformation/PersonalForm/mixin.js'
            )
            var e = this.formData,
              t = e.firstName,
              a = e.lastName,
              n = [t, a]
            return (
              this.schoolIsHk && n.reverse(),
              t || a
                ? n
                  .filter(function (e) {
                    return e
                  })
                  .join(' ')
                : ''
            )
          },
        },
        mounted: function () {
          var e = this
          return Object(r.a)(
            Object(n.a)().mark(function t() {
              return Object(n.a)().wrap(function (t) {
                while (1) {
                  switch ((t.prev = t.next)) {
                    case 0:
                      document.addEventListener('click', e.removeNickBlur)
                    case 1:
                    case 'end':
                      return t.stop()
                  }
                }
              }, t)
            })
          )()
        },
        beforeDestroy: function () {
          console.info(
            '对象函数 beforeDestroy,filePath:renderer/components/PersonalInformation/PersonalForm/mixin.js'
          )
          document.removeEventListener('click', this.removeNickBlur)
        },
        methods: {
          removeNickBlur: function (e) {
            var t
            console.info(
              '对象函数 removeNickBlur($event)',
              e,
              'filePath:renderer/components/PersonalInformation/PersonalForm/mixin.js'
            )
            var a =
              null === e || void 0 === e
                ? void 0
                : e.path.filter(function (e) {
                  return (
                    'input-person-nick ant-input-affix-wrapper' ===
                    e.className
                  )
                })
            'set-person-nick' ===
              (null === e ||
                void 0 === e ||
                null === (t = e.target) ||
                void 0 === t
                ? void 0
                : t.className) ||
              a.length ||
              (this.hasFocus = false)
          },
          setNickBlur: function () {
            console.info(
              '对象函数 setNickBlur,filePath:renderer/components/PersonalInformation/PersonalForm/mixin.js'
            )
            this.validateNickName()
          },
          nickNameHandler: function () {
            console.info(
              '对象函数 nickNameHandler,filePath:renderer/components/PersonalInformation/PersonalForm/mixin.js'
            )
            this.nickNamePromptValue &&
              !this.formData.nickName &&
              (this.$set(this.formData, 'nickName', this.nickNamePromptValue),
                this.validateNickName())
            this.hasFocus = false
          },
          validateNickName: function () {
            return (
              console.info(
                '对象函数 validateNickName,filePath:renderer/components/PersonalInformation/PersonalForm/mixin.js'
              ),
              this.formData.nickName
                ? /^[\u3400-\u4db5_\u4e00-\u9fa5_a-zA-Z0-9\s]{0,65}$/.test(
                  this.formData.nickName
                )
                  ? (this.nickErrorTip = '')
                  : (this.nickErrorTip = this.$t(
                    'account.validateInput.invalid'
                  ))
                : (this.nickErrorTip = this.$t(
                  'account.validateInput.inputRequire'
                )),
              !this.nickErrorTip
            )
          },
          validateForm: function () {
            console.info(
              '对象函数 validateForm,filePath:renderer/components/PersonalInformation/PersonalForm/mixin.js'
            )
            var e = null
            return (
              this.$refs.userInfoForm.validate(function (t) {
                console.info(
                  '箭头函数 validate(valid)',
                  t,
                  'filePath:renderer/components/PersonalInformation/PersonalForm/mixin.js'
                )
                e = !!t
              }),
              this.validateNickName()
                ? e
                : (console.info(
                  'if(!this.validateNickName())为true触发return,path: /renderer/components/PersonalInformation/PersonalForm/mixin.js'
                ),
                  false)
            )
          },
          queryGradeList: function () {
            var e = this
            return Object(r.a)(
              Object(n.a)().mark(function t() {
                var a, r, s, i, c
                return Object(n.a)().wrap(function (t) {
                  while (1) {
                    switch ((t.prev = t.next)) {
                      case 0:
                        return (
                          console.info(
                            '对象函数 queryGradeList,filePath:renderer/components/PersonalInformation/PersonalForm/mixin.js'
                          ),
                          (t.next = 3),
                          Object(o.f)()
                        )
                      case 3:
                        if (((a = t.sent), a && 0 == a.code)) {
                          t.next = 9
                          break
                        }
                        return (
                          console.info(
                            'if(!res || res.code != 0)为true触发return,path: /renderer/components/PersonalInformation/PersonalForm/mixin.js'
                          ),
                          (r =
                            null !== a && void 0 !== a && a.code
                              ? 'Code: '.concat(
                                null === a || void 0 === a ? void 0 : a.code,
                                ','
                              )
                              : ''),
                          e.$Message.error(
                            r +
                            ((a && a.msg) ||
                              e.$t(
                                'common.components.errorStatus.errorStatus'
                              ))
                          ),
                          t.abrupt('return')
                        )
                      case 9:
                        ; (s = a.data || {}),
                          (i = s.list || []),
                          (c = []),
                          i.forEach(function (e) {
                            e.list.forEach(function (e) {
                              c.push({
                                value: e.value,
                                name: e.name,
                              })
                            })
                          }),
                          (e.gradeList = c)
                      case 14:
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
    },
    '7bd1': function (e, t, a) {
      'use strict'
      a.d(t, 'a', function () {
        return i
      })
      var n = a('c7eb'),
        r = a('1da1'),
        o = a('3898'),
        s = a('765f'),
        i = (function () {
          var e = Object(r.a)(
            Object(n.a)().mark(function e() {
              var t, a
              return Object(n.a)().wrap(function (e) {
                while (1) {
                  switch ((e.prev = e.next)) {
                    case 0:
                      return (e.next = 2), Object(o.a)()
                    case 2:
                      return (
                        (t = e.sent),
                        (a = t.account.validateInput),
                        e.abrupt('return', {
                          firstName: [
                            {
                              required: true,
                              message: a.inputRequire,
                              trigger: 'blur',
                            },
                            {
                              min: 1,
                              max: 32,
                              message: a.maxLength,
                              trigger: 'blur',
                            },
                            {
                              pattern:
                                /^[\u3400-\u4db5_\u4e00-\u9fa5_a-zA-Z0-9\s]{0,32}$/,
                              message: a.invalid,
                              trigger: 'blur',
                            },
                          ],
                          lastName: [
                            {
                              required: true,
                              message: a.inputRequire,
                              trigger: 'blur',
                            },
                            {
                              min: 1,
                              max: 32,
                              message: a.maxLength,
                              trigger: 'blur',
                            },
                            {
                              pattern:
                                /^[\u3400-\u4db5_\u4e00-\u9fa5_a-zA-Z0-9\s]{0,32}$/,
                              message: a.invalid,
                              trigger: 'blur',
                            },
                          ],
                          gradeId: [
                            {
                              required: true,
                              message: a.inputRequire,
                              trigger: 'change',
                            },
                          ],
                          email: [
                            {
                              required: true,
                              message: a.inputRequire,
                              trigger: 'blur',
                            },
                            {
                              pattern: s.a.regRules.email,
                              message: a.invalid,
                              trigger: 'blur',
                            },
                          ],
                        })
                      )
                    case 5:
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
    '968e': function (e, t, a) {
      'use strict'
      a('1361')
    },
    a206: function (e, t, a) { },
    b5ee: function (e, t, a) {
      'use strict'
      a('a206')
    },
    bd12: function (e, t, a) {
      'use strict'
      var n = function () {
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
                t('img', { attrs: { src: a('c63e') } }),
              ]),
              t('div', { staticClass: 'loading-animation' }),
            ])
          },
        ],
        o = {
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
        s = o,
        i = (a('f761'), a('2877')),
        c = Object(i.a)(s, n, r, false, null, '92d727e8', null)
      t.a = c.exports
    },
    c002: function (e, t, a) { },
    c63e: function (e, t) {
      e.exports =
        'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFAAAABQCAMAAAC5zwKfAAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAAA8UExURUdwTP/DL//DLv/BL//DLv/EL//DL//DLv/DL//CLv/DL//DL//CLf/DL//DL//DL//DLv/DL//DMv/DMGSQIxsAAAATdFJOUwDwcSTeYM1AwICojww0SLNSmhsrwQ8LAAABI0lEQVRYw+3X2a6DIBCAYbaBYXXh/d/1aE3UxtbjMhdtOv+l6BeiiYAQ5+tzLwhK2oGKjTW1Vn/HyQV8NzlzF8HRkfVV10BX38Ygg18FptICKB+70OAWDD4GNPIMaJentyAuv4l8FKx7IIjYdB7a3CdBArplWFoMUYHTiQhcZdDTgqt3yyCDdgTlkBmy1iLeBIcJ7Q6fB2txzpGCYwz+HuhWAR4BcR98LhwAU6vGlXIDaruZexBwAJy35dN2WtadNX++iESbiK8BDRYyULWXT0AvwTsxyCCDnwJaUhAjaCrQBFWSuNsESoytFiRpYzqVxc/kh0Mipaemj2tDHE62iWKCh7daDDLI4CeDhRoUPXSWFHysASpIUnAsK6QFp+Pjf3f8AVRMjNs7xw9TAAAAAElFTkSuQmCC'
    },
    ebc2: function (e, t, a) { },
    f761: function (e, t, a) {
      'use strict'
      a('ebc2')
    },
    fde4: function (e, t, a) {
      'use strict'
      a.r(t)
      var n = function () {
        var e = this,
          t = e._self._c
        return t(
          'div',
          {
            staticClass: 'page-wrapper',
            attrs: { 'data-log': '添加学生页' },
          },
          [
            t(
              'div',
              { staticClass: 'add-student-page-template' },
              [
                e.isLoading
                  ? [
                    e.isLoading
                      ? t('Loading', { attrs: { 'margin-top': '200px' } })
                      : e._e(),
                  ]
                  : [
                    t('div', { staticClass: 'my-account-main-container' }, [
                      t(
                        'div',
                        { staticClass: 'my-account-body-container' },
                        [
                          t('PersonalForm', {
                            ref: 'addForm',
                            attrs: { userInfo: e.addForm },
                          }),
                        ],
                        1
                      ),
                      t(
                        'div',
                        { staticClass: 'my-account-footer-contaienr' },
                        [
                          t(
                            'div',
                            {
                              staticClass: 'btn-back-to-courses',
                              on: { click: e.handleBack },
                            },
                            [
                              t('a-icon', {
                                attrs: { type: 'caret-left' },
                              }),
                              t('span', [
                                e._v(
                                  e._s(
                                    e.$t(
                                      'account.accountVerification.backToAccount'
                                    )
                                  )
                                ),
                              ]),
                            ],
                            1
                          ),
                          t(
                            'a-button',
                            {
                              attrs: {
                                size: 'large',
                                type: 'primary',
                                shape: 'round',
                                loading: e.isSubmit,
                              },
                              on: { click: e.handleAdd },
                            },
                            [
                              e._v(
                                ' ' +
                                e._s(
                                  e.$t('account.accountVerification.done')
                                ) +
                                ' '
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
            ),
          ]
        )
      },
        r = [],
        o = a('c7eb'),
        s = a('1da1'),
        i = (a('14d9'), a('bd12')),
        c =
          (a('b0c0'),
            function () {
              var e = this,
                t = e._self._c
              return t(
                'div',
                { staticClass: 'userform-wrapper' },
                [
                  t(
                    'a-form-model',
                    {
                      ref: 'userInfoForm',
                      attrs: {
                        model: e.formData,
                        rules: e.rules,
                      },
                    },
                    [
                      t(
                        'a-row',
                        { attrs: { type: 'flex' } },
                        [
                          t(
                            'a-col',
                            {
                              attrs: {
                                span: 12,
                                order: e.schoolIsHk ? 1 : 2,
                              },
                            },
                            [
                              t(
                                'a-form-model-item',
                                {
                                  class: [
                                    'field-label',
                                    e.schoolIsHk ? 'mr10' : '',
                                  ],
                                  attrs: {
                                    prop: 'lastName',
                                    label: e.$t(
                                      'account.personalInformation.studentLastName'
                                    ),
                                  },
                                },
                                [
                                  t('a-input', {
                                    attrs: {
                                      'allow-clear': '',
                                      'max-length': 32,
                                      placeholder: e.$t(
                                        'account.personalInformation.enterLastName'
                                      ),
                                    },
                                    model: {
                                      value: e.formData.lastName,
                                      callback: function (t) {
                                        e.$set(e.formData, 'lastName', t)
                                      },
                                      expression: 'formData.lastName',
                                    },
                                  }),
                                ],
                                1
                              ),
                            ],
                            1
                          ),
                          t(
                            'a-col',
                            {
                              attrs: {
                                span: 12,
                                order: e.schoolIsHk ? 2 : 1,
                              },
                            },
                            [
                              t(
                                'a-form-model-item',
                                {
                                  class: [
                                    'field-label',
                                    e.schoolIsHk ? '' : 'mr10',
                                  ],
                                  attrs: {
                                    prop: 'firstName',
                                    label: e.$t(
                                      'account.personalInformation.studentFirstName'
                                    ),
                                  },
                                },
                                [
                                  t('a-input', {
                                    attrs: {
                                      'allow-clear': '',
                                      'max-length': 32,
                                      placeholder: e.$t(
                                        'account.personalInformation.enterFirstName'
                                      ),
                                    },
                                    model: {
                                      value: e.formData.firstName,
                                      callback: function (t) {
                                        e.$set(e.formData, 'firstName', t)
                                      },
                                      expression: 'formData.firstName',
                                    },
                                  }),
                                ],
                                1
                              ),
                            ],
                            1
                          ),
                        ],
                        1
                      ),
                      t(
                        'a-form-model-item',
                        {
                          staticClass: 'field-label field-nickname',
                          attrs: {
                            label: e.$t(
                              'account.personalInformation.displayName'
                            ),
                          },
                        },
                        [
                          t('a-input', {
                            staticClass: 'input-person-nick',
                            attrs: {
                              'allow-clear': '',
                              placeholder: e.$t(
                                'account.personalInformation.displayNamePlaceholder'
                              ),
                            },
                            on: {
                              blur: e.setNickBlur,
                              focus: function () {
                                return (e.hasFocus = true)
                              },
                            },
                            model: {
                              value: e.formData.nickName,
                              callback: function (t) {
                                e.$set(e.formData, 'nickName', t)
                              },
                              expression: 'formData.nickName',
                            },
                          }),
                          t(
                            'div',
                            {
                              directives: [
                                {
                                  name: 'show',
                                  rawName: 'v-show',
                                  value:
                                    e.hasFocus &&
                                    !e.formData.nickName &&
                                    e.nickNamePromptValue,
                                  expression:
                                    'hasFocus && !formData.nickName && nickNamePromptValue',
                                },
                              ],
                              staticClass: 'set-person-nick',
                              on: { click: e.nickNameHandler },
                            },
                            [e._v(' ' + e._s(e.nickNamePromptValue) + ' ')]
                          ),
                          e.nickErrorTip
                            ? t(
                              'div',
                              { staticClass: 'ant-form-explain red-marked' },
                              [e._v(e._s(e.nickErrorTip))]
                            )
                            : t('div', { staticClass: 'nick-name-tips' }, [
                              e._v(
                                ' ' +
                                e._s(
                                  e.$t(
                                    'account.personalInformation.displayNameUse'
                                  )[0]
                                ) +
                                ' ' +
                                e._s(
                                  e.$t(
                                    'account.personalInformation.displayNameUse'
                                  )[1]
                                ) +
                                ' '
                              ),
                            ]),
                        ],
                        1
                      ),
                      t(
                        'a-form-model-item',
                        {
                          staticClass: 'field-label',
                          attrs: {
                            prop: 'gradeId',
                            label: e.$t('account.personalInformation.gradeTitle'),
                          },
                        },
                        [
                          t(
                            'a-select',
                            {
                              attrs: {
                                dropdownClassName: 'dropdown-grade-select',
                                placeholder: e.$t(
                                  'account.personalInformation.select'
                                ),
                                suffixIcon: e.suffixIcon,
                              },
                              scopedSlots: e._u([
                                {
                                  key: 'suffixIcon',
                                  fn: function () {
                                    return [
                                      t('a-icon', {
                                        attrs: { component: e.arrowBottomSvg },
                                      }),
                                    ]
                                  },
                                  proxy: true,
                                },
                              ]),
                              model: {
                                value: e.formData.gradeId,
                                callback: function (t) {
                                  e.$set(e.formData, 'gradeId', t)
                                },
                                expression: 'formData.gradeId',
                              },
                            },
                            e._l(e.gradeList, function (a, n) {
                              return t(
                                'a-select-option',
                                {
                                  key: n,
                                  attrs: { value: a.value },
                                },
                                [e._v(' ' + e._s(a.name) + ' ')]
                              )
                            }),
                            1
                          ),
                        ],
                        1
                      ),
                    ],
                    1
                  ),
                ],
                1
              )
            }),
        l = [],
        u = a('ff07'),
        d = a.n(u),
        m = a('7bd1'),
        f = a('02fc'),
        p = a('620c'),
        h = {
          name: 'PersonalInformation',
          components: {},
          props: {
            userInfo: {
              default: function () {
                return {}
              },
              type: Object,
            },
          },
          data: function () {
            return {
              schoolIsHk: false,
              arrowBottomSvg: d.a,
              formData: this.userInfo,
              emailDisabled: false,
              rules: m.a,
            }
          },
          mixins: [p.a],
          mounted: function () {
            var e = this
            return Object(s.a)(
              Object(o.a)().mark(function t() {
                return Object(o.a)().wrap(function (t) {
                  while (1) {
                    switch ((t.prev = t.next)) {
                      case 0:
                        return (t.next = 2), Object(f.a)()
                      case 2:
                        return (
                          (e.schoolIsHk = t.sent),
                          e.queryGradeList(),
                          (t.next = 6),
                          Object(m.a)()
                        )
                      case 6:
                        e.rules = t.sent
                      case 7:
                      case 'end':
                        return t.stop()
                    }
                  }
                }, t)
              })
            )()
          },
        },
        v = h,
        g = (a('1e79'), a('b5ee'), a('2877')),
        b = Object(g.a)(v, c, l, false, null, '5ec1cc8a', null),
        k = b.exports,
        A = a('ae3f'),
        N = {
          components: {
            Loading: i.a,
            PersonalForm: k,
          },
          data: function () {
            return {
              isLoading: false,
              isSubmit: false,
              addForm: {},
              studentsList: [],
            }
          },
          mounted: function () {
            this.updateHeaderAttr()
          },
          methods: {
            updateHeaderAttr: function () {
              console.info(
                '对象函数 updateHeaderAttr,filePath:renderer/views/Addstudent.vue'
              )
              this.$bus.$emit('updateHeaderAttr', {
                title: this.$t('account.myAccount.title'),
                showGoback: true,
                backUrl: '/my-account',
              })
            },
            addStudent: function (e) {
              var t = this
              return Object(s.a)(
                Object(o.a)().mark(function a() {
                  var n
                  return Object(o.a)().wrap(function (a) {
                    while (1) {
                      switch ((a.prev = a.next)) {
                        case 0:
                          return (
                            console.info(
                              '对象函数 addStudent(callback)',
                              e,
                              'filePath:renderer/views/Addstudent.vue'
                            ),
                            (t.isSubmit = true),
                            (a.next = 4),
                            Object(A.a)(t.addForm)
                          )
                        case 4:
                          if (
                            ((n = a.sent),
                              (t.isSubmit = false),
                              n && 0 == n.code)
                          ) {
                            a.next = 10
                            break
                          }
                          return (
                            console.info(
                              'if(!res || res.code != 0)为true触发return,path: /renderer/views/Addstudent.vue'
                            ),
                            t.$Message.error(
                              (n && n.msg) ||
                              t.$t('account.myAccount.addFailedMessage')
                            ),
                            a.abrupt('return')
                          )
                        case 10:
                          e && e()
                        case 11:
                        case 'end':
                          return a.stop()
                      }
                    }
                  }, a)
                })
              )()
            },
            handleAdd: function () {
              var e = this
              console.info(
                '对象函数 handleAdd,filePath:renderer/views/Addstudent.vue'
              )
              this.$refs.addForm.validateForm() &&
                this.addStudent(function () {
                  console.info(
                    '箭头函数 addStudent,filePath:renderer/views/Addstudent.vue'
                  )
                  e.$Message.success(
                    e.$t('account.myAccount.addSuccessedMessage')
                  )
                  e.handleBack()
                })
            },
            handleBack: function () {
              console.info(
                '对象函数 handleBack,filePath:renderer/views/Addstudent.vue'
              )
              this.$router.push('/my-account')
            },
          },
        },
        w = N,
        x = (a('968e'), Object(g.a)(w, n, r, false, null, '01afabc7', null))
      t.default = x.exports
    },
    ff07: function (e, t) {
      e.exports = {
        functional: true,
        render(e, t) {
          const { _c: a, _v: n, data: r, children: o = [] } = t,
            {
              class: s,
              staticClass: i,
              style: c,
              staticStyle: l,
              attrs: u = {},
              ...d
            } = r
          return a(
            'svg',
            {
              class: ['icon', s, i],
              style: [c, l],
              attrs: Object.assign(
                {
                  viewBox: '0 0 1024 1024',
                  xmlns: 'http://www.w3.org/2000/svg',
                  width: '128',
                  height: '128',
                },
                u
              ),
              ...d,
            },
            o.concat([
              a('defs'),
              a('path', {
                attrs: {
                  d: 'M464.6 736C346 613.3 227.3 490.5 108.8 367.8c-48.9-50.5 30.5-125.9 79.5-75.1C293.9 401.9 399.4 511.2 505 620.3 614.2 510.6 723.6 400.8 832.8 291c49.7-50 129.1 25.4 79.5 75.2C789.6 489.5 666.9 612.7 544.2 736c-20.4 20.4-59.4 20.9-79.6 0z',
                },
              }),
            ])
          )
        },
      }
    },
  },
])
