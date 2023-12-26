; (window.webpackJsonp = window.webpackJsonp || []).push([
  ['chunk-459f8285'],
  {
    '15ea': function (e, t, o) {
      'use strict'
      o('cbf6')
    },
    '2ecc': function (e, t, o) {
      'use strict'
      o.r(t)
      var i = function () {
        var e = this,
          t = e._self._c
        return t(
          'div',
          { staticClass: 'page-wrapper' },
          [
            t('Toolbar', {
              attrs: {
                transparent: true,
                fixed: true,
                whiteButton: true,
                disabledMaximize: true,
              },
            }),
            e.showSkip
              ? t(
                'div',
                {
                  staticClass: 'button-skip',
                  on: { click: e.handleSkip },
                },
                [
                  e._v(
                    ' ' +
                    e._s(e.$t('login.verificationCodePage.skip')) +
                    ' '
                  ),
                ]
              )
              : e._e(),
            t(
              'div',
              { staticClass: 'page-contenter' },
              [
                'accountVerification' === e.type
                  ? t('AccountVerification', {
                    attrs: {
                      dark: '',
                      account: e.account,
                      title: e.$t('account.accountVerification.title'),
                      subTitle: e.$t(
                        'account.accountVerification.subTitle'
                      ),
                    },
                    on: { 'validation-success': e.validationSuccess },
                  })
                  : e._e(),
                'passwordSettings' === e.type
                  ? t('PasswordSetting', {
                    attrs: {
                      dark: '',
                      title: e.$t('account.modifyPassword.title'),
                      subTitle: e.$t('account.modifyPassword.subTitle'),
                      description: e.$t(
                        'account.modifyPassword.modifyText'
                      ),
                      placeholder: e.$t(
                        'account.modifyPassword.placeholder'
                      ),
                      areaCode: e.passwordSettingsInfo.areaCode,
                      phoneNumber: e.passwordSettingsInfo.phoneNumber,
                      emailInput: e.accountInfo.emailInput,
                      verificationCode:
                        e.passwordSettingsInfo.verificationCode,
                    },
                    on: { 'reset-success': e.resetSuccess },
                  })
                  : e._e(),
              ],
              1
            ),
            t('div', { staticClass: 'page-footer' }, [
              e.showSkip
                ? e._e()
                : t(
                  'div',
                  {
                    staticClass: 'button-back',
                    on: { click: e.handleBack },
                  },
                  [
                    t('a-icon', { attrs: { type: 'caret-left' } }),
                    e._v(
                      ' ' +
                      e._s(e.$t('login.verificationCodePage.back')) +
                      ' '
                    ),
                  ],
                  1
                ),
            ]),
          ],
          1
        )
      },
        n = [],
        a = o('c7eb'),
        s = o('1da1'),
        r = (o('14d9'), o('92e5')),
        c = o('2b6b'),
        u = o('dfa8'),
        d = o('83a1'),
        p = o('43d0'),
        f = o('3898'),
        l = {
          name: 'Login',
          components: {
            Toolbar: u.a,
            AccountVerification: d.a,
            PasswordSetting: p.a,
          },
          i18n: f.b,
          data: function () {
            var e = this.$route.params,
              t = e.isLogin || false,
              o = e.accountInfo || {}
            return {
              type: 'accountVerification',
              showSkip: false,
              isLogin: t,
              accountInfo: {
                countryCode: o.countryCode || '',
                areaCode: o.areaCode || '',
                phoneReg: o.phoneReg || '',
                phoneNumber: o.phoneNumber || '',
                emailInput: o.emailInput,
                emailReg: o.emailReg,
              },
              passwordSettingsInfo: {
                areaCode: o.areaCode || '',
                phoneNumber: o.phoneNumber || '',
                verificationCode: '',
              },
            }
          },
          computed: {
            account: function () {
              return (
                console.info(
                  '对象函数 account,filePath:renderer/views/ForgotPassword.vue'
                ),
                this.accountInfo || null
              )
            },
          },
          created: function () {
            this.init()
          },
          methods: {
            init: function () {
              console.info(
                '对象函数 init,filePath:renderer/views/ForgotPassword.vue'
              )
              var e = this.$route.params,
                t = e.type
              'passwordSettings' === t &&
                ((this.type = 'passwordSettings'), (this.showSkip = true))
            },
            handleSkip: function () {
              var e = this
              return Object(s.a)(
                Object(a.a)().mark(function t() {
                  return Object(a.a)().wrap(function (t) {
                    while (1) {
                      switch ((t.prev = t.next)) {
                        case 0:
                          return (
                            console.info(
                              '对象函数 handleSkip,filePath:renderer/views/ForgotPassword.vue'
                            ),
                            (t.next = 3),
                            window.thinkApi.ipc.invoke(
                              'setStoreValue',
                              'skipPasswordSettings',
                              true
                            )
                          )
                        case 3:
                          e.$router.push('/courses')
                        case 4:
                        case 'end':
                          return t.stop()
                      }
                    }
                  }, t)
                })
              )()
            },
            handleBack: function () {
              console.info(
                '对象函数 handleBack,filePath:renderer/views/ForgotPassword.vue'
              )
              'accountVerification' === this.type && this.gotoLogin()
              'passwordSettings' === this.type &&
                (this.type = 'accountVerification')
            },
            validationSuccess: function (e) {
              var t = e.areaCode,
                o = e.phoneNumber,
                i = e.verificationCode
              console.info(
                '对象函数 validationSuccess(areaCode, phoneNumber, verificationCode)',
                t,
                o,
                i,
                'filePath:renderer/views/ForgotPassword.vue'
              )
              this.type = 'passwordSettings'
              this.passwordSettingsInfo.areaCode = t
              this.passwordSettingsInfo.phoneNumber = o
              this.passwordSettingsInfo.verificationCode = i
            },
            resetSuccess: function (e) {
              var t = this
              return Object(s.a)(
                Object(a.a)().mark(function o() {
                  return Object(a.a)().wrap(function (o) {
                    while (1) {
                      switch ((o.prev = o.next)) {
                        case 0:
                          if (
                            (console.info(
                              '对象函数 resetSuccess(data)',
                              e,
                              'filePath:renderer/views/ForgotPassword.vue'
                            ),
                              t.isLogin || !e)
                          ) {
                            o.next = 5
                            break
                          }
                          return (
                            (o.next = 4),
                            Object(r.c)({
                              uid: e.uid,
                              avatar: e.avatar,
                              email: e.email,
                              nickName: e.nickName,
                              card: e.card,
                              countryCallingCode: e.countryCallingCode,
                              phone: e.phone,
                              unifiedAccessToken: e.unifiedAccessToken,
                            })
                          )
                        case 4:
                          Object(c.setUserAttributes)()
                        case 5:
                          t.$router.push('/courses')
                        case 6:
                        case 'end':
                          return o.stop()
                      }
                    }
                  }, o)
                })
              )()
            },
            gotoLogin: function () {
              console.info(
                '对象函数 gotoLogin,filePath:renderer/views/ForgotPassword.vue'
              )
              this.$router.push({
                path: '/login',
                query: { loginType: 'password' },
              })
            },
          },
        },
        h = l,
        w = (o('15ea'), o('2877')),
        g = Object(w.a)(h, i, n, false, null, '0138e282', null)
      t.default = g.exports
    },
    cbf6: function (e, t, o) { },
  },
])
