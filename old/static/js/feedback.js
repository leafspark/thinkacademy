; (window.webpackJsonp = window.webpackJsonp || []).push([
  ['chunk-7bc122d5'],
  {
    '76ce': function (e, t, i) {
      'use strict'
      i('bac4')
    },
    '83fd': function (e, t, i) { },
    bac4: function (e, t, i) { },
    bd12: function (e, t, i) {
      'use strict'
      var a = function () {
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
        n = [
          function () {
            var e = this,
              t = e._self._c
            return t('div', { staticClass: 'loading-contenter' }, [
              t('div', { staticClass: 'loading-logo' }, [
                t('img', { attrs: { src: i('c63e') } }),
              ]),
              t('div', { staticClass: 'loading-animation' }),
            ])
          },
        ],
        r = {
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
        s = r,
        o = (i('f761'), i('2877')),
        l = Object(o.a)(s, a, n, false, null, '92d727e8', null)
      t.a = l.exports
    },
    c63e: function (e, t) {
      e.exports =
        'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFAAAABQCAMAAAC5zwKfAAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAAA8UExURUdwTP/DL//DLv/BL//DLv/EL//DL//DLv/DL//CLv/DL//DL//CLf/DL//DL//DL//DLv/DL//DMv/DMGSQIxsAAAATdFJOUwDwcSTeYM1AwICojww0SLNSmhsrwQ8LAAABI0lEQVRYw+3X2a6DIBCAYbaBYXXh/d/1aE3UxtbjMhdtOv+l6BeiiYAQ5+tzLwhK2oGKjTW1Vn/HyQV8NzlzF8HRkfVV10BX38Ygg18FptICKB+70OAWDD4GNPIMaJentyAuv4l8FKx7IIjYdB7a3CdBArplWFoMUYHTiQhcZdDTgqt3yyCDdgTlkBmy1iLeBIcJ7Q6fB2txzpGCYwz+HuhWAR4BcR98LhwAU6vGlXIDaruZexBwAJy35dN2WtadNX++iESbiK8BDRYyULWXT0AvwTsxyCCDnwJaUhAjaCrQBFWSuNsESoytFiRpYzqVxc/kh0Mipaemj2tDHE62iWKCh7daDDLI4CeDhRoUPXSWFHysASpIUnAsK6QFp+Pjf3f8AVRMjNs7xw9TAAAAAElFTkSuQmCC'
    },
    d14a: function (e, t, i) {
      'use strict'
      i.r(t)
      var a = function () {
        var e = this,
          t = e._self._c
        return t('div', { staticClass: 'feedback-wrapper' }, [
          t(
            'div',
            { staticClass: 'feedback-information-contenter' },
            [
              [
                e.isLoading
                  ? t('Loading', { attrs: { 'margin-top': '200px' } })
                  : t(
                    'div',
                    { staticClass: 'feedback-information-wrapper' },
                    [
                      t('div', { staticClass: 'userinfo-contenter' }, [
                        t(
                          'div',
                          { staticClass: 'problem-wrapper' },
                          [
                            t('div', { staticClass: 'title' }, [
                              e._v(e._s(e.$t('setting.feedback.title'))),
                            ]),
                            t(
                              'section',
                              { staticClass: 'problems' },
                              [
                                e._l(
                                  e.$t(
                                    'setting.feedback.problemDescriptors'
                                  ),
                                  function (i, a) {
                                    return [
                                      t(
                                        'div',
                                        {
                                          key: a,
                                          staticClass: 'item',
                                          class:
                                            i == e.feedbackProblem
                                              ? 'problem_active'
                                              : '',
                                          on: {
                                            click: function (t) {
                                              return e.handleChooseProblem(
                                                i
                                              )
                                            },
                                          },
                                        },
                                        [e._v(' ' + e._s(i) + ' ')]
                                      ),
                                    ]
                                  }
                                ),
                              ],
                              2
                            ),
                            t(
                              'a-form-model',
                              {
                                ref: 'proInfoForm',
                                attrs: {
                                  model: e.problemForm,
                                  rules: e.rules,
                                  'label-col': e.labelCol,
                                  'wrapper-col': e.wrapperCol,
                                },
                              },
                              [
                                t(
                                  'a-form-model-item',
                                  { attrs: { prop: 'desc' } },
                                  [
                                    t('a-input', {
                                      staticClass: 'inputProblem',
                                      attrs: {
                                        'auto-size': {
                                          minRows: 8,
                                          maxRows: 8,
                                        },
                                        maxLength: '500',
                                        type: 'textarea',
                                        placeholder: e.$t(
                                          'setting.feedback.feedBackInput'
                                        ),
                                      },
                                      model: {
                                        value: e.problemForm.desc,
                                        callback: function (t) {
                                          e.$set(e.problemForm, 'desc', t)
                                        },
                                        expression: 'problemForm.desc',
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
                        t('div', { staticClass: 'upload-wrapper' }, [
                          t('div', { staticClass: 'title' }, [
                            t('span', [
                              e._v(e._s(e.$t('setting.feedback.images'))),
                            ]),
                            t('span', [
                              e._v(e._s(e.$t('setting.feedback.optional'))),
                            ]),
                          ]),
                          t(
                            'section',
                            [
                              t('Upload', {
                                attrs: {
                                  uploadAccept: e.uploadAccept,
                                  maxFileSize: e.maxFileSize,
                                  maxFileNumber: e.maxFileNumber,
                                },
                                on: {
                                  handleImageFile: e.handleImageFile,
                                  removeImageFile: e.removeImageFile,
                                },
                              }),
                            ],
                            1
                          ),
                        ]),
                      ]),
                      t('div', { staticClass: 'userinfo-footer' }, [
                        t(
                          'div',
                          {
                            staticClass: 'goback',
                            on: { click: e.handleBack },
                          },
                          [
                            t('a-icon', { attrs: { type: 'caret-left' } }),
                            e._v(
                              ' ' +
                              e._s(
                                e.$t('setting.feedback.backToCourses')
                              ) +
                              ' '
                            ),
                          ],
                          1
                        ),
                        e.feedbackProblem
                          ? t(
                            'div',
                            { staticClass: 'button-group' },
                            [
                              t(
                                'a-button',
                                {
                                  attrs: {
                                    size: 'large',
                                    type: 'primary',
                                    shape: 'round',
                                    loading: e.isSubmit,
                                  },
                                  on: { click: e.handleSubmit },
                                },
                                [
                                  e._v(
                                    ' ' +
                                    e._s(
                                      e.$t('setting.feedback.submit')
                                    ) +
                                    ' '
                                  ),
                                ]
                              ),
                            ],
                            1
                          )
                          : t(
                            'div',
                            { staticClass: 'button-limit' },
                            [
                              t(
                                'a-button',
                                {
                                  attrs: {
                                    size: 'large',
                                    type: 'primary',
                                    disabled: '',
                                    shape: 'round',
                                  },
                                },
                                [
                                  e._v(
                                    ' ' +
                                    e._s(
                                      e.$t('setting.feedback.submit')
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
                  ),
              ],
            ],
            2
          ),
        ])
      },
        n = [],
        r = (i('4de4'), i('d3b7'), i('14d9'), i('ff07')),
        s = i.n(r),
        o = i('bd12'),
        l = function () {
          var e = this,
            t = e._self._c
          return t(
            'div',
            { staticClass: 'uploadFile' },
            [
              t(
                'a-upload',
                {
                  attrs: {
                    'list-type': 'picture-card',
                    'file-list': e.fileList,
                    accept: e.uploadAccept,
                    remove: e.removeUploadFile,
                    multiple: false,
                    beforeUpload: e.beforeUpload,
                    customRequest: e.customRequest,
                  },
                  on: {
                    preview: e.handlePreview,
                    change: e.handleChange,
                  },
                },
                [
                  !e.isUploading && e.fileList.length < 3
                    ? t('div', { staticClass: 'input_icon upload' })
                    : e._e(),
                  e.isUploading && e.fileList.length < 3
                    ? t(
                      'div',
                      { staticClass: 'uploading' },
                      [
                        t('a-icon', { attrs: { type: 'loading' } }),
                        t('span', [
                          e._v(e._s(e.$t('common.uploading')) + '...'),
                        ]),
                      ],
                      1
                    )
                    : e._e(),
                ]
              ),
              e.fileList.length < 2
                ? t('span', { staticClass: 'maxmum' }, [
                  e._v(
                    ' ' +
                    e._s(
                      e.$t('setting.feedback.maximuImages', { num: 3 })
                    ) +
                    ' '
                  ),
                ])
                : e._e(),
              t(
                'a-modal',
                {
                  attrs: {
                    visible: e.previewVisible,
                    footer: null,
                  },
                  on: { cancel: e.handleCancel },
                },
                [
                  t('img', {
                    staticStyle: { width: '100%' },
                    attrs: {
                      alt: 'example',
                      src: e.previewImage,
                    },
                  }),
                ]
              ),
            ],
            1
          )
        },
        c = [],
        u = i('c7eb'),
        d = i('1da1'),
        m = (i('e6cf'), i('a9e3'), i('b0c0'), i('fb6a'), i('1a37'))
      function f(e) {
        return (
          console.info(
            '函数申明 getBase64(file)',
            e,
            'filePath:renderer/components/Common/Upload.vue'
          ),
          new Promise(function (t, i) {
            var a = new FileReader()
            a.readAsDataURL(e)
            a.onload = function () {
              return t(a.result)
            }
            a.onerror = function (e) {
              return i(e)
            }
          })
        )
      }
      var p = {
        data: function () {
          return {
            previewVisible: false,
            previewImage: '',
            fileList: [],
            isUploading: false,
            imgUrl: '',
            fileUid: -1,
          }
        },
        props: {
          uploadAccept: {
            type: String,
            default: function () {
              return '.jpg,.jpeg,.png'
            },
          },
          maxFileSize: {
            type: Number,
            default: function () {
              return 10485760
            },
          },
          maxFileNumber: {
            type: Number,
            default: function () {
              return 3
            },
          },
        },
        methods: {
          handleCancel: function () {
            console.info(
              '对象函数 handleCancel,filePath:renderer/components/Common/Upload.vue'
            )
            this.previewVisible = false
          },
          handlePreview: function (e) {
            var t = this
            return Object(d.a)(
              Object(u.a)().mark(function i() {
                return Object(u.a)().wrap(function (i) {
                  while (1) {
                    switch ((i.prev = i.next)) {
                      case 0:
                        if (
                          (console.info(
                            '对象函数 handlePreview(file)',
                            e,
                            'filePath:renderer/components/Common/Upload.vue'
                          ),
                            e.url || e.preview)
                        ) {
                          i.next = 5
                          break
                        }
                        return (i.next = 4), f(e.originFileObj)
                      case 4:
                        e.preview = i.sent
                      case 5:
                        ; (t.previewImage = e.url || e.preview),
                          (t.previewVisible = true)
                      case 7:
                      case 'end':
                        return i.stop()
                    }
                  }
                }, i)
              })
            )()
          },
          beforeUpload: function (e) {
            var t = this
            console.info(
              '对象函数 beforeUpload(file)',
              e,
              'filePath:renderer/components/Common/Upload.vue'
            )
            var i = this.uploadAccept.split(','),
              a = e.name.lastIndexOf('.'),
              n = e.name.substr(a + 1),
              r = i.some(function (e) {
                return e.slice(1) === n
              })
            return new Promise(function (i, a) {
              e.size > t.maxFileSize
                ? (t.$Message.warning(t.$t('setting.feedback.maxFileSize')),
                  a(e))
                : r
                  ? (i(e), (t.isUploading = true))
                  : (t.$Message.warning(
                    t.$t('setting.feedback.fileFormatIncorrect')
                  ),
                    a(e))
            })
          },
          removeUploadFile: function (e) {
            var t = this
            console.info(
              '对象函数 removeUploadFile(file)',
              e,
              'filePath:renderer/components/Common/Upload.vue'
            )
            this.fileList = this.fileList.filter(function (i) {
              return (
                i.uid == e.uid && t.$emit('removeImageFile', i.url),
                i.uid !== e.uid
              )
            })
          },
          customRequest: function (e) {
            var t = this
            return Object(d.a)(
              Object(u.a)().mark(function i() {
                var a
                return Object(u.a)().wrap(function (i) {
                  while (1) {
                    switch ((i.prev = i.next)) {
                      case 0:
                        console.info(
                          '对象函数 customRequest(param)',
                          e,
                          'filePath:renderer/components/Common/Upload.vue'
                        ),
                          (a = new m.b({ scene: 'feedback' })),
                          a.putFile({
                            filePath: 'feedback.jpg',
                            file: e.file,
                            success: function (e) {
                              if (t.fileList.length >= t.maxFileNumber) {
                                return (
                                  console.info(
                                    'if(_this4.fileList.length >= _this4.maxFileNumber)为true触发return,path: /renderer/components/Common/Upload.vue'
                                  ),
                                  console.info(
                                    'if(_this4.fileList.length >= _this4.maxFileNumber)为true触发return,path: /renderer/components/Common/Upload.vue'
                                  ),
                                  t.$Message.warning(
                                    t.$t('setting.feedback.maximuImages', {
                                      num: t.maxFileNumber,
                                    })
                                  ),
                                  false
                                )
                              }
                              t.fileList.push({
                                uid: t.fileUid--,
                                status: 'done',
                                url: e.url,
                              })
                              t.$emit('handleImageFile', e.url)
                              t.isUploading = false
                            },
                            fail: function () {
                              t.isUploading = false
                              t.$Message.warning(
                                t.$t('setting.feedback.uploadFailTryAgain')
                              )
                            },
                          })
                      case 3:
                      case 'end':
                        return i.stop()
                    }
                  }
                }, i)
              })
            )()
          },
        },
      },
        b = p,
        v = (i('76ce'), i('2877')),
        h = Object(v.a)(b, l, c, false, null, '13cb35d4', null),
        g = h.exports,
        w = i('dc21'),
        k = i('e39c'),
        A = (function () {
          var e = Object(d.a)(
            Object(u.a)().mark(function e(t, i, a) {
              var n, r, s
              return Object(u.a)().wrap(function (e) {
                while (1) {
                  switch ((e.prev = e.next)) {
                    case 0:
                      return (
                        (n = Object(k.h)()),
                        (r = n.one),
                        (e.next = 3),
                        Object(w.a)({
                          url: i,
                          params: a,
                          apiDomain: r,
                        })
                      )
                    case 3:
                      return (s = e.sent), e.abrupt('return', s)
                    case 5:
                    case 'end':
                      return e.stop()
                  }
                }
              }, e)
            })
          )
          return function (t, i, a) {
            return e.apply(this, arguments)
          }
        })(),
        C = (function () {
          var e = Object(d.a)(
            Object(u.a)().mark(function e(t, i) {
              var a, n
              return Object(u.a)().wrap(function (e) {
                while (1) {
                  switch ((e.prev = e.next)) {
                    case 0:
                      return (
                        (a = '/v1/feedback/submit'), (e.next = 3), A(t, a, i)
                      )
                    case 3:
                      return (n = e.sent), e.abrupt('return', n)
                    case 5:
                    case 'end':
                      return e.stop()
                  }
                }
              }, e)
            })
          )
          return function (t, i) {
            return e.apply(this, arguments)
          }
        })(),
        F = {
          name: 'Feedback',
          components: {
            Loading: o.a,
            Upload: g,
          },
          data: function () {
            return {
              arrowBottomSvg: s.a,
              isSubmit: false,
              feedbackProblem: '',
              labelCol: { span: 24 },
              wrapperCol: { span: 24 },
              problemForm: { desc: '' },
              uploadAccept: '.jpg,.jpeg,.png',
              maxFileSize: 10485760,
              maxFileNumber: 3,
              submitParams: { images: [] },
              rules: {
                desc: [
                  {
                    required: true,
                    message: this.$t('setting.feedback.inputInvilidate'),
                    trigger: 'blur',
                  },
                ],
              },
            }
          },
          mounted: function () {
            this.updateHeaderAttr()
          },
          methods: {
            updateHeaderAttr: function () {
              console.info(
                '对象函数 updateHeaderAttr,filePath:renderer/views/Feedback.vue'
              )
              this.$bus.$emit('updateHeaderAttr', {
                title: this.$t('setting.feedback.title'),
                showGoback: true,
                backUrl: '/courses',
              })
            },
            handleBack: function () {
              console.info(
                '对象函数 handleBack,filePath:renderer/views/Feedback.vue'
              )
              this.$router.push('/courses')
            },
            handleChooseProblem: function (e) {
              if (
                (console.info(
                  '对象函数 handleChooseProblem(problem)',
                  e,
                  'filePath:renderer/views/Feedback.vue'
                ),
                  e == this.feedbackProblem)
              ) {
                return (
                  console.info(
                    'if(problem == this.feedbackProblem)为true触发return,path: /renderer/views/Feedback.vue'
                  ),
                  void (this.feedbackProblem = '')
                )
              }
              this.feedbackProblem = e
            },
            handleSubmit: function () {
              var e = this
              console.info(
                '对象函数 handleSubmit,filePath:renderer/views/Feedback.vue'
              )
              this.$refs.proInfoForm.validate(function (t) {
                if (
                  (console.info(
                    '箭头函数 validate(valid)',
                    t,
                    'filePath:renderer/views/Feedback.vue'
                  ),
                    !t)
                ) {
                  return (
                    console.info(
                      'if(!valid)为true触发return,path: /renderer/views/Feedback.vue'
                    ),
                    false
                  )
                }
                e.isSubmit = true
                e.submitParams.tag = e.feedbackProblem
                e.submitParams.details = e.problemForm.desc
                e.submitParams.deviceId = ''
                C(e, e.submitParams).then(function (t) {
                  if (
                    (console.info(
                      '箭头函数 submitFeedback的then(res)',
                      t,
                      'filePath:renderer/views/Feedback.vue'
                    ),
                      !t || 0 != t.code)
                  ) {
                    return (
                      console.info(
                        'if(!res || res.code != 0)为true触发return,path: /renderer/views/Feedback.vue'
                      ),
                      e.$Message.error(e.$t('common.submissionFailed')),
                      void (e.isSubmit = false)
                    )
                  }
                  e.$Message.success(e.$t('common.sumbittedSuccessfully'))
                  e.isSubmit = false
                  setTimeout(function () {
                    e.handleBack()
                  }, 2000)
                })
              })
            },
            handleImageFile: function (e) {
              console.info(
                '对象函数 handleImageFile(url)',
                e,
                'filePath:renderer/views/Feedback.vue'
              )
              this.submitParams.images.push(e)
            },
            removeImageFile: function (e) {
              console.info(
                '对象函数 removeImageFile(url)',
                e,
                'filePath:renderer/views/Feedback.vue'
              )
              this.submitParams.images = this.submitParams.images.filter(
                function (t) {
                  return t != e
                }
              )
            },
          },
          watch: {
            '$i18n.locale': function (e) {
              console.info(
                '对象函数 undefined(newValue)',
                e,
                'filePath:renderer/views/Feedback.vue'
              )
              e && this.updateHeaderAttr()
            },
          },
        },
        x = F,
        P = (i('e1c87'), Object(v.a)(x, a, n, false, null, '7f8444be', null))
      t.default = P.exports
    },
    e1c87: function (e, t, i) {
      'use strict'
      i('83fd')
    },
    ebc2: function (e, t, i) { },
    f761: function (e, t, i) {
      'use strict'
      i('ebc2')
    },
    ff07: function (e, t) {
      e.exports = {
        functional: true,
        render(e, t) {
          const { _c: i, _v: a, data: n, children: r = [] } = t,
            {
              class: s,
              staticClass: o,
              style: l,
              staticStyle: c,
              attrs: u = {},
              ...d
            } = n
          return i(
            'svg',
            {
              class: ['icon', s, o],
              style: [l, c],
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
            r.concat([
              i('defs'),
              i('path', {
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
