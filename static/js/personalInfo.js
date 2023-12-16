(window.webpackJsonp = window.webpackJsonp || []).push([
    ['chunk-31983c92'],
    {
        '17c8': function (e, t, r) {
        },
        '56b7': function (e, t, r) {
            'use strict';
            r('cc4e');
        },
        '620c': function (e, t, r) {
            'use strict';
            var o = r('c7eb'), n = r('1da1'), a = (r('14d9'), r('a15b'), r('4de4'), r('d3b7'), r('ac1f'), r('159b'), r('b0c0'), r('bc8a'));
            t.a = {
                data: function () {
                    return {
                        schoolIsHk: false,
                        formData: {},
                        hasFocus: false,
                        nickErrorTip: '',
                        gradeList: []
                    };
                },
                computed: {
                    nickNamePromptValue: function () {
                        console.info('对象函数 nickNamePromptValue,filePath:renderer/components/PersonalInformation/PersonalForm/mixin.js');
                        var e = this.formData, t = e.firstName, r = e.lastName, o = [
                            t,
                            r
                        ];
                        return this.schoolIsHk && o.reverse(), t || r ? o.filter(function (e) {
                            return e;
                        }).join(' ') : '';
                    }
                },
                mounted: function () {
                    var e = this;
                    return Object(n.a)(Object(o.a)().mark(function t() {
                        return Object(o.a)().wrap(function (t) {
                            while (1) {
                                switch (t.prev = t.next) {
                                    case 0:
                                        document.addEventListener('click', e.removeNickBlur);
                                    case 1:
                                    case 'end':
                                        return t.stop();
                                }
                            }
                        }, t);
                    }))();
                },
                beforeDestroy: function () {
                    console.info('对象函数 beforeDestroy,filePath:renderer/components/PersonalInformation/PersonalForm/mixin.js');
                    document.removeEventListener('click', this.removeNickBlur);
                },
                methods: {
                    removeNickBlur: function (e) {
                        var t;
                        console.info('对象函数 removeNickBlur($event)', e, 'filePath:renderer/components/PersonalInformation/PersonalForm/mixin.js');
                        var r = null === e || void 0 === e ? void 0 : e.path.filter(function (e) {
                            return 'input-person-nick ant-input-affix-wrapper' === e.className;
                        });
                        'set-person-nick' === (null === e || void 0 === e || null === (t = e.target) || void 0 === t ? void 0 : t.className) || r.length || (this.hasFocus = false);
                    },
                    setNickBlur: function () {
                        console.info('对象函数 setNickBlur,filePath:renderer/components/PersonalInformation/PersonalForm/mixin.js');
                        this.validateNickName();
                    },
                    nickNameHandler: function () {
                        console.info('对象函数 nickNameHandler,filePath:renderer/components/PersonalInformation/PersonalForm/mixin.js');
                        this.nickNamePromptValue && !this.formData.nickName && (this.$set(this.formData, 'nickName', this.nickNamePromptValue), this.validateNickName());
                        this.hasFocus = false;
                    },
                    validateNickName: function () {
                        return console.info('对象函数 validateNickName,filePath:renderer/components/PersonalInformation/PersonalForm/mixin.js'), this.formData.nickName ? /^[\u3400-\u4db5_\u4e00-\u9fa5_a-zA-Z0-9\s]{0,65}$/.test(this.formData.nickName) ? this.nickErrorTip = '' : this.nickErrorTip = this.$t('account.validateInput.invalid') : this.nickErrorTip = this.$t('account.validateInput.inputRequire'), !this.nickErrorTip;
                    },
                    validateForm: function () {
                        console.info('对象函数 validateForm,filePath:renderer/components/PersonalInformation/PersonalForm/mixin.js');
                        var e = null;
                        return this.$refs.userInfoForm.validate(function (t) {
                            console.info('箭头函数 validate(valid)', t, 'filePath:renderer/components/PersonalInformation/PersonalForm/mixin.js');
                            e = !!t;
                        }), this.validateNickName() ? e : (console.info('if(!this.validateNickName())为true触发return,path: /renderer/components/PersonalInformation/PersonalForm/mixin.js'), false);
                    },
                    queryGradeList: function () {
                        var e = this;
                        return Object(n.a)(Object(o.a)().mark(function t() {
                            var r, n, i, s, c;
                            return Object(o.a)().wrap(function (t) {
                                while (1) {
                                    switch (t.prev = t.next) {
                                        case 0:
                                            return console.info('对象函数 queryGradeList,filePath:renderer/components/PersonalInformation/PersonalForm/mixin.js'), t.next = 3, Object(a.f)();
                                        case 3:
                                            if (r = t.sent, r && 0 == r.code) {
                                                t.next = 9;
                                                break;
                                            }
                                            return console.info('if(!res || res.code != 0)为true触发return,path: /renderer/components/PersonalInformation/PersonalForm/mixin.js'), n = null !== r && void 0 !== r && r.code ? 'Code: '.concat(null === r || void 0 === r ? void 0 : r.code, ',') : '', e.$Message.error(n + (r && r.msg || e.$t('common.components.errorStatus.errorStatus'))), t.abrupt('return');
                                        case 9:
                                            i = r.data || {}, s = i.list || [], c = [], s.forEach(function (e) {
                                                e.list.forEach(function (e) {
                                                    c.push({
                                                        value: e.value,
                                                        name: e.name
                                                    });
                                                });
                                            }), e.gradeList = c;
                                        case 14:
                                        case 'end':
                                            return t.stop();
                                    }
                                }
                            }, t);
                        }))();
                    }
                }
            };
        },
        '7bd1': function (e, t, r) {
            'use strict';
            r.d(t, 'a', function () {
                return s;
            });
            var o = r('c7eb'), n = r('1da1'), a = r('3898'), i = r('765f'), s = function () {
                var e = Object(n.a)(Object(o.a)().mark(function e() {
                    var t, r;
                    return Object(o.a)().wrap(function (e) {
                        while (1) {
                            switch (e.prev = e.next) {
                                case 0:
                                    return e.next = 2, Object(a.a)();
                                case 2:
                                    return t = e.sent, r = t.account.validateInput, e.abrupt('return', {
                                        firstName: [
                                            {
                                                required: true,
                                                message: r.inputRequire,
                                                trigger: 'blur'
                                            },
                                            {
                                                min: 1,
                                                max: 32,
                                                message: r.maxLength,
                                                trigger: 'blur'
                                            },
                                            {
                                                pattern: /^[\u3400-\u4db5_\u4e00-\u9fa5_a-zA-Z0-9\s]{0,32}$/,
                                                message: r.invalid,
                                                trigger: 'blur'
                                            }
                                        ],
                                        lastName: [
                                            {
                                                required: true,
                                                message: r.inputRequire,
                                                trigger: 'blur'
                                            },
                                            {
                                                min: 1,
                                                max: 32,
                                                message: r.maxLength,
                                                trigger: 'blur'
                                            },
                                            {
                                                pattern: /^[\u3400-\u4db5_\u4e00-\u9fa5_a-zA-Z0-9\s]{0,32}$/,
                                                message: r.invalid,
                                                trigger: 'blur'
                                            }
                                        ],
                                        gradeId: [{
                                            required: true,
                                            message: r.inputRequire,
                                            trigger: 'change'
                                        }],
                                        email: [
                                            {
                                                required: true,
                                                message: r.inputRequire,
                                                trigger: 'blur'
                                            },
                                            {
                                                pattern: i.a.regRules.email,
                                                message: r.invalid,
                                                trigger: 'blur'
                                            }
                                        ]
                                    });
                                case 5:
                                case 'end':
                                    return e.stop();
                            }
                        }
                    }, e);
                }));
                return function () {
                    return e.apply(this, arguments);
                };
            }();
        },
        '7e79': function (e, t, r) {
            !function (t, r) {
                e.exports = r();
            }(self, () => (() => {
                var e = {
                    669: (e, t, r) => {
                        (e.exports = r(252)(false)).push([
                            e.id,
                            '\n.vue-cropper[data-v-07be87c7] {\n  position: relative;\n  width: 100%;\n  height: 100%;\n  box-sizing: border-box;\n  user-select: none;\n  -webkit-user-select: none;\n  -moz-user-select: none;\n  -ms-user-select: none;\n  direction: ltr;\n  touch-action: none;\n  text-align: left;\n  background-image: url("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQAQMAAAAlPW0iAAAAA3NCSVQICAjb4U/gAAAABlBMVEXMzMz////TjRV2AAAACXBIWXMAAArrAAAK6wGCiw1aAAAAHHRFWHRTb2Z0d2FyZQBBZG9iZSBGaXJld29ya3MgQ1M26LyyjAAAABFJREFUCJlj+M/AgBVhF/0PAH6/D/HkDxOGAAAAAElFTkSuQmCC");\n}\n.cropper-box[data-v-07be87c7],\n.cropper-box-canvas[data-v-07be87c7],\n.cropper-drag-box[data-v-07be87c7],\n.cropper-crop-box[data-v-07be87c7],\n.cropper-face[data-v-07be87c7] {\n  position: absolute;\n  top: 0;\n  right: 0;\n  bottom: 0;\n  left: 0;\n  user-select: none;\n}\n.cropper-box-canvas img[data-v-07be87c7] {\n  position: relative;\n  text-align: left;\n  user-select: none;\n  transform: none;\n  max-width: none;\n  max-height: none;\n}\n.cropper-box[data-v-07be87c7] {\n  overflow: hidden;\n}\n.cropper-move[data-v-07be87c7] {\n  cursor: move;\n}\n.cropper-crop[data-v-07be87c7] {\n  cursor: crosshair;\n}\n.cropper-modal[data-v-07be87c7] {\n  background: rgba(0, 0, 0, 0.5);\n}\n.cropper-crop-box[data-v-07be87c7] {\n  /*border: 2px solid #39f;*/\n}\n.cropper-view-box[data-v-07be87c7] {\n  display: block;\n  overflow: hidden;\n  width: 100%;\n  height: 100%;\n  outline: 1px solid #39f;\n  outline-color: rgba(51, 153, 255, 0.75);\n  user-select: none;\n}\n.cropper-view-box img[data-v-07be87c7] {\n  user-select: none;\n  text-align: left;\n  max-width: none;\n  max-height: none;\n}\n.cropper-face[data-v-07be87c7] {\n  top: 0;\n  left: 0;\n  background-color: #fff;\n  opacity: 0.1;\n}\n.crop-info[data-v-07be87c7] {\n  position: absolute;\n  left: 0px;\n  min-width: 65px;\n  text-align: center;\n  color: white;\n  line-height: 20px;\n  background-color: rgba(0, 0, 0, 0.8);\n  font-size: 12px;\n}\n.crop-line[data-v-07be87c7] {\n  position: absolute;\n  display: block;\n  width: 100%;\n  height: 100%;\n  opacity: 0.1;\n}\n.line-w[data-v-07be87c7] {\n  top: -3px;\n  left: 0;\n  height: 5px;\n  cursor: n-resize;\n}\n.line-a[data-v-07be87c7] {\n  top: 0;\n  left: -3px;\n  width: 5px;\n  cursor: w-resize;\n}\n.line-s[data-v-07be87c7] {\n  bottom: -3px;\n  left: 0;\n  height: 5px;\n  cursor: s-resize;\n}\n.line-d[data-v-07be87c7] {\n  top: 0;\n  right: -3px;\n  width: 5px;\n  cursor: e-resize;\n}\n.crop-point[data-v-07be87c7] {\n  position: absolute;\n  width: 8px;\n  height: 8px;\n  opacity: 0.75;\n  background-color: #39f;\n  border-radius: 100%;\n}\n.point1[data-v-07be87c7] {\n  top: -4px;\n  left: -4px;\n  cursor: nw-resize;\n}\n.point2[data-v-07be87c7] {\n  top: -5px;\n  left: 50%;\n  margin-left: -3px;\n  cursor: n-resize;\n}\n.point3[data-v-07be87c7] {\n  top: -4px;\n  right: -4px;\n  cursor: ne-resize;\n}\n.point4[data-v-07be87c7] {\n  top: 50%;\n  left: -4px;\n  margin-top: -3px;\n  cursor: w-resize;\n}\n.point5[data-v-07be87c7] {\n  top: 50%;\n  right: -4px;\n  margin-top: -3px;\n  cursor: e-resize;\n}\n.point6[data-v-07be87c7] {\n  bottom: -5px;\n  left: -4px;\n  cursor: sw-resize;\n}\n.point7[data-v-07be87c7] {\n  bottom: -5px;\n  left: 50%;\n  margin-left: -3px;\n  cursor: s-resize;\n}\n.point8[data-v-07be87c7] {\n  bottom: -5px;\n  right: -4px;\n  cursor: se-resize;\n}\n@media screen and (max-width: 500px) {\n.crop-point[data-v-07be87c7] {\n    position: absolute;\n    width: 20px;\n    height: 20px;\n    opacity: 0.45;\n    background-color: #39f;\n    border-radius: 100%;\n}\n.point1[data-v-07be87c7] {\n    top: -10px;\n    left: -10px;\n}\n.point2[data-v-07be87c7],\n  .point4[data-v-07be87c7],\n  .point5[data-v-07be87c7],\n  .point7[data-v-07be87c7] {\n    display: none;\n}\n.point3[data-v-07be87c7] {\n    top: -10px;\n    right: -10px;\n}\n.point4[data-v-07be87c7] {\n    top: 0;\n    left: 0;\n}\n.point6[data-v-07be87c7] {\n    bottom: -10px;\n    left: -10px;\n}\n.point8[data-v-07be87c7] {\n    bottom: -10px;\n    right: -10px;\n}\n}\n',
                            ''
                        ]);
                    },
                    252: e => {
                        e.exports = function (e) {
                            var t = [];
                            return t.toString = function () {
                                return this.map(function (t) {
                                    var r = function (e, t) {
                                        var r, o = e[1] || '', n = e[3];
                                        if (!n) {
                                            return o;
                                        }
                                        if (t && 'function' == typeof btoa) {
                                            var a = (r = n, '/*# sourceMappingURL=data:application/json;charset=utf-8;base64,' + btoa(unescape(encodeURIComponent(JSON.stringify(r)))) + ' */'), i = n.sources.map(function (e) {
                                                return '/*# sourceURL=' + n.sourceRoot + e + ' */';
                                            });
                                            return [o].concat(i).concat([a]).join('\n');
                                        }
                                        return [o].join('\n');
                                    }(t, e);
                                    return t[2] ? '@media ' + t[2] + '{' + r + '}' : r;
                                }).join('');
                            }, t.i = function (e, r) {
                                'string' == typeof e && (e = [[
                                    null,
                                    e,
                                    ''
                                ]]);
                                for (var o = {
                                    r: e[r],
                                    onload: function () {
                                        if (0 !== t.cropW) {
                                            var h = r.getContext('2d'), u = 1;
                                            t.high & !t.full && (u = window.devicePixelRatio);
                                            1 !== t.enlarge & !t.full && (u = Math.abs(Number(t.enlarge)));
                                            var p = t.cropW * u, f = t.cropH * u, d = a * t.scale * u, m = i * t.scale * u, v = (t.x - s + t.trueWidth * (1 - t.scale) / 2) * u, g = (t.y - c + t.trueHeight * (1 - t.scale) / 2) * u;
                                            switch (l(p, f), h.save(), n) {
                                                case 0:
                                                    t.full ? (l(p / t.scale, f / t.scale), h.drawImage(o, v / t.scale, g / t.scale, d / t.scale, m / t.scale)) : h.drawImage(o, v, g, d, m);
                                                    break;
                                                case 1:
                                                case -3:
                                                    t.full ? (l(p / t.scale, f / t.scale), v = v / t.scale + (d / t.scale - m / t.scale) / 2, g = g / t.scale + (m / t.scale - d / t.scale) / 2, h.rotate(90 * n * Math.PI / 180), h.drawImage(o, g, -v - m / t.scale, d / t.scale, m / t.scale)) : (v += (d - m) / 2, g += (m - d) / 2, h.rotate(90 * n * Math.PI / 180), h.drawImage(o, g, -v - m, d, m));
                                                    break;
                                                case 2:
                                                case -2:
                                                    t.full ? (l(p / t.scale, f / t.scale), h.rotate(90 * n * Math.PI / 180), v /= t.scale, g /= t.scale, h.drawImage(o, -v - d / t.scale, -g - m / t.scale, d / t.scale, m / t.scale)) : (h.rotate(90 * n * Math.PI / 180), h.drawImage(o, -v - d, -g - m, d, m));
                                                    break;
                                                case 3:
                                                case -1:
                                                    t.full ? (l(p / t.scale, f / t.scale), v = v / t.scale + (d / t.scale - m / t.scale) / 2, g = g / t.scale + (m / t.scale - d / t.scale) / 2, h.rotate(90 * n * Math.PI / 180), h.drawImage(o, -g - d / t.scale, v, d / t.scale, m / t.scale)) : (v += (d - m) / 2, g += (m - d) / 2, h.rotate(90 * n * Math.PI / 180), h.drawImage(o, -g - d, v, d, m));
                                                    break;
                                                default:
                                                    t.full ? (l(p / t.scale, f / t.scale), h.drawImage(o, v / t.scale, g / t.scale, d / t.scale, m / t.scale)) : h.drawImage(o, v, g, d, m);
                                            }
                                            h.restore();
                                        } else {
                                            var b = a * t.scale, w = i * t.scale, x = r.getContext('2d');
                                            switch (x.save(), n) {
                                                case 0:
                                                    l(b, w), x.drawImage(o, 0, 0, b, w);
                                                    break;
                                                case 1:
                                                case -3:
                                                    l(w, b), x.rotate(90 * n * Math.PI / 180), x.drawImage(o, 0, -w, b, w);
                                                    break;
                                                case 2:
                                                case -2:
                                                    l(b, w), x.rotate(90 * n * Math.PI / 180), x.drawImage(o, -b, -w, b, w);
                                                    break;
                                                case 3:
                                                case -1:
                                                    l(w, b), x.rotate(90 * n * Math.PI / 180), x.drawImage(o, -b, 0, b, w);
                                                    break;
                                                default:
                                                    l(b, w), x.drawImage(o, 0, 0, b, w);
                                            }
                                            x.restore();
                                        }
                                        e(r);
                                    },
                                    src: this.imgs
                                }, n = 0; n < this.length; n++) {
                                    var a = this[n][0];
                                    'number' == typeof a && (o[a] = true);
                                }
                                for (n = 0; n < e.length; n++) {
                                    var i = e[n];
                                    'number' == typeof i[0] && o[i[0]] || (r && !i[2] ? i[2] = r : r && (i[2] = '(' + i[2] + ') and (' + r + ')'), t.push(i));
                                }
                            }, t;
                        };
                    },
                    97: (e, t, r) => {
                        var o = r(669);
                        'string' == typeof o && (o = [[
                            e.id,
                            o,
                            ''
                        ]]);
                        r(723)(o, {
                            hmr: true,
                            transform: void 0,
                            insertInto: void 0
                        });
                        o.locals && (e.exports = o.locals);
                    },
                    723: (e, t, r) => {
                        var o, n, a = {
                            onload: function () {
                                if (200 != this.status && 0 !== this.status) {
                                    throw 'Could not load image';
                                }
                                t = a.response;
                                r(t);
                                a = null;
                            },
                            responseType: 'arraybuffer'
                        }, i = (o = function () {
                            return window && document && document.all && !window.atob;
                        }, function () {
                            return void 0 === n && (n = o.apply(this, arguments)), n;
                        }), s = function (e, t) {
                            return t ? t.querySelector(e) : document.querySelector(e);
                        }, c = function (e) {
                            var t = { e: o };
                            return function (e, r) {
                                if ('function' == typeof e) {
                                    return e();
                                }
                                if (void 0 === t[e]) {
                                    var o = s.call(this, e, r);
                                    if (window.HTMLIFrameElement && o instanceof window.HTMLIFrameElement) {
                                        try {
                                            o = o.contentDocument.head;
                                        } catch (e) {
                                            o = null;
                                        }
                                    }
                                    ;
                                }
                                return t[e];
                            };
                        }(), l = null, h = 0, u = [], p = r(947);
                        function f(e, t) {
                            for (var r = 0; r < e.length; r++) {
                                var o = e[r], n = a[o.id];
                                if (n) {
                                    n.refs++;
                                    for (var i = 0; i < n.parts.length; i++) {
                                        n.parts[i](o.parts[i]);
                                    }
                                    for (; i < o.parts.length; i++) {
                                        n.parts.push(w(o.parts[i], t));
                                    }
                                } else {
                                    var s = [];
                                    for (i = 0; i < o.parts.length; i++) {
                                        s.push(w(o.parts[i], t));
                                    }
                                    a[o.id] = {
                                        id: o.id,
                                        refs: 1,
                                        parts: s
                                    };
                                }
                            }
                        }
                        function d(e, t) {
                            for (var r = [], o = {}, n = 0; n < e.length; n++) {
                                var a = e[n], i = t.base ? a[0] + t.base : a[0], s = {
                                    css: a[1],
                                    media: a[2],
                                    sourceMap: a[3]
                                };
                                o[i] ? o[i].parts.push(s) : r.push(o[i] = {
                                    id: i,
                                    parts: [s]
                                });
                            }
                            return r;
                        }
                        function m(e, t) {
                            var r = c(e.insertInto);
                            if (!r) {
                                throw new Error('Couldn\'t find a style target. This probably means that the value for the \'insertInto\' parameter is invalid.');
                            }
                            var o = u[u.length - 1];
                            if ('top' === e.insertAt) {
                                o ? o.nextSibling ? r.insertBefore(t, o.nextSibling) : r.appendChild(t) : r.insertBefore(t, r.firstChild);
                                u.push(t);
                            } else {
                                if ('bottom' === e.insertAt) {
                                    r.appendChild(t);
                                } else {
                                    if ('object' != typeof e.insertAt || !e.insertAt.before) {
                                        throw new Error('[Style Loader]\n\n Invalid value for parameter \'insertAt\' (\'options.insertAt\') found.\n Must be \'top\', \'bottom\', or Object.\n (https://github.com/webpack-contrib/style-loader#insertat)\n');
                                    }
                                    var n = c(e.insertAt.before, r);
                                    r.insertBefore(t, n);
                                }
                            }
                        }
                        function v(e) {
                            if (null === e.parentNode) {
                                return false;
                            }
                            e.parentNode.removeChild(e);
                            var t = u.indexOf(e);
                            t >= 0 && u.splice(t, 1);
                        }
                        function g(e) {
                            var t = document.createElement('style');
                            if (void 0 === e.attrs.type && (e.attrs.type = 'text/css'), void 0 === e.attrs.nonce) {
                                var o = r.nc;
                                o && (e.attrs.nonce = o);
                            }
                            return b(t, e.attrs), m(e, t), t;
                        }
                        function b(e, t) {
                            Object.keys(t).forEach(function (r) {
                                e.setAttribute(r, t[r]);
                            });
                        }
                        function w(e, t) {
                            var r, o, n, a;
                            if (t.transform && e.css) {
                                if (!(a = 'function' == typeof t.transform ? t.transform(e.css) : t.transform.default(e.css))) {
                                    return function () {
                                    };
                                }
                                e.css = a;
                            }
                            if (t.singleton) {
                                var i = h++;
                                r = l || (l = g(t));
                                o = y.bind(null, r, i, false);
                                n = y.bind(null, r, i, true);
                            } else {
                                e.sourceMap && 'function' == typeof URL && 'function' == typeof URL.createObjectURL && 'function' == typeof URL.revokeObjectURL && 'function' == typeof Blob && 'function' == typeof btoa ? (r = function (e) {
                                    var t = document.createElement('link');
                                    return void 0 === e.attrs.type && (e.attrs.type = 'text/css'), e.attrs.rel = 'stylesheet', b(t, e.attrs), m(e, t), t;
                                }(t), o = k.bind(null, r, t), n = function () {
                                    v(r);
                                    r.href && URL.revokeObjectURL(r.href);
                                }) : (r = g(t), o = A.bind(null, r), n = function () {
                                    v(r);
                                });
                            }
                            return o(e), function (t) {
                                if (t) {
                                    if (t.css === e.css && t.media === e.media && t.sourceMap === e.sourceMap) {
                                        return;
                                    }
                                    o(e = t);
                                } else {
                                    n();
                                }
                            };
                        }
                        e.exports = function (e, t) {
                            if ('undefined' != typeof DEBUG && DEBUG && 'object' != typeof document) {
                                throw new Error('The style-loader cannot be used in a non-browser environment');
                            }
                            (t = t || {}).attrs = 'object' == typeof t.attrs ? t.attrs : {};
                            t.singleton || 'boolean' == typeof t.singleton || (t.singleton = i());
                            t.insertInto || (t.insertInto = 'head');
                            t.insertAt || (t.insertAt = 'bottom');
                            var r = d(e, t);
                            return f(r, t), function (e) {
                                for (var o = [], n = 0; n < r.length; n++) {
                                    var i = r[n];
                                    (s = a[i.id]).refs--;
                                    o.push(s);
                                }
                                for (e && f(d(e, t), t), n = 0; n < o.length; n++) {
                                    var s;
                                    if (0 === (s = o[n]).refs) {
                                        for (var c = 0; c < s.parts.length; c++) {
                                            s.parts[c]();
                                        }
                                        delete a[s.id];
                                    }
                                }
                            };
                        };
                        var x, C = (x = [], function (e, t) {
                            return x[e] = t, x.filter(Boolean).join('\n');
                        });
                        function y(e, t, r, o) {
                            var n = r ? '' : o.css;
                            if (e.styleSheet) {
                                e.styleSheet.cssText = C(t, n);
                            } else {
                                var a = document.createTextNode(n), i = e.childNodes;
                                i[t] && e.removeChild(i[t]);
                                i.length ? e.insertBefore(a, i[t]) : e.appendChild(a);
                            }
                        }
                        function A(e, t) {
                            var r = t.css, o = t.media;
                            if (o && e.setAttribute('media', o), e.styleSheet) {
                                e.styleSheet.cssText = r;
                            } else {
                                for (; e.firstChild;) {
                                    e.removeChild(e.firstChild);
                                }
                                e.appendChild(document.createTextNode(r));
                            }
                        }
                        function k(e, t, r) {
                            var o = r.css, n = r.sourceMap, a = void 0 === t.convertToAbsoluteUrls && n;
                            (t.convertToAbsoluteUrls || a) && (o = p(o));
                            n && (o += '\n/*# sourceMappingURL=data:application/json;base64,' + btoa(unescape(encodeURIComponent(JSON.stringify(n)))) + ' */');
                            var i = new Blob([o], { type: 'text/css' }), s = e.href;
                            e.href = URL.createObjectURL(i);
                            s && URL.revokeObjectURL(s);
                        }
                    },
                    947: e => {
                        e.exports = function (e) {
                            var t = 'undefined' != typeof window && window.location;
                            if (!t) {
                                throw new Error('fixUrls requires window.location');
                            }
                            if (!e || 'string' != typeof e) {
                                return e;
                            }
                            var r = t.protocol + '//' + t.host, o = r + t.pathname.replace(/\/[^\/]*$/, '/');
                            return e.replace(/url\s*\(((?:[^)(]|\((?:[^)(]+|\([^)(]*\))*\))*)\)/gi, function (e, t) {
                                var n, a = t.trim().replace(/^"(.*)"$/, function (e, t) {
                                    return t;
                                }).replace(/^'(.*)'$/, function (e, t) {
                                    return t;
                                });
                                return /^(#|data:|http:\/\/|https:\/\/|file:\/\/\/|\s*$)/i.test(a) ? e : (n = 0 === a.indexOf('//') ? a : 0 === a.indexOf('/') ? r + a : o + a.replace(/^\.\//, ''), 'url(' + JSON.stringify(n) + ')');
                            });
                        };
                    }
                }, t = {
                    src: e,
                    src: this.img,
                    touchNow: false,
                    x: r,
                    y: o,
                    scaling: false,
                    coe: t.coe += 0.01,
                    cropOffsertY: t.cropOffsertY,
                    onload: function () {
                        e.w = parseFloat(window.getComputedStyle(e.$refs.cropper).width);
                        e.h = parseFloat(window.getComputedStyle(e.$refs.cropper).height);
                        e.trueWidth = t.width;
                        e.trueHeight = t.height;
                        e.original ? e.scale = 1 : e.scale = e.checkedMode();
                        e.$nextTick(function () {
                            e.x = -(e.trueWidth - e.trueWidth * e.scale) / 2 + (e.w - e.trueWidth * e.scale) / 2;
                            e.y = -(e.trueHeight - e.trueHeight * e.scale) / 2 + (e.h - e.trueHeight * e.scale) / 2;
                            e.loading = false;
                            e.autoCrop && e.goAutoCrop();
                            e.$emit('img-load', 'success');
                            setTimeout(function () {
                                e.showPreview();
                            }, 20);
                        });
                    },
                    onerror: function () {
                        e.$emit('img-load', 'error');
                    },
                    src: this.imgs
                };
                function r(o) {
                    var n = t[o];
                    if (void 0 !== n) {
                        return n.exports;
                    }
                    var a = t[o] = {
                        id: o,
                        exports: {}
                    };
                    return e[o](a, a.exports, r), a.exports;
                }
                r.d = (e, t) => {
                    for (var o in t)
                        r.o(t, o) && !r.o(e, o) && Object.defineProperty(e, o, {
                            enumerable: true,
                            get: t[o]
                        });
                };
                r.o = (e, t) => Object.prototype.hasOwnProperty.call(e, t);
                r.r = e => {
                    'undefined' != typeof Symbol && Symbol.toStringTag && Object.defineProperty(e, Symbol.toStringTag, { value: 'Module' });
                    Object.defineProperty(e, '__esModule', { value: true });
                };
                r.nc = void 0;
                var o = {};
                return (() => {
                    'use strict';
                    r.r(o);
                    r.d(o, {
                        VueCropper: () => l,
                        default: () => u
                    });
                    var e = function () {
                        var e = this, t = e._self._c;
                        return t('div', {
                            ref: 'cropper',
                            staticClass: 'vue-cropper',
                            on: {
                                mouseover: e.scaleImg,
                                mouseout: e.cancelScale
                            }
                        }, [
                            e.imgs ? t('div', { staticClass: 'cropper-box' }, [t('div', {
                                directives: [{
                                    name: 'show',
                                    rawName: 'v-show',
                                    value: !e.loading,
                                    expression: '!loading'
                                }],
                                staticClass: 'cropper-box-canvas',
                                style: {
                                    width: e.trueWidth + 'px',
                                    height: e.trueHeight + 'px',
                                    transform: 'scale(' + e.scale + ',' + e.scale + ') translate3d(' + e.x / e.scale + 'px,' + e.y / e.scale + 'px,0)rotateZ(' + 90 * e.rotate + 'deg)'
                                }
                            }, [t('img', {
                                ref: 'cropperImg',
                                attrs: {
                                    src: e.imgs,
                                    alt: 'cropper-img'
                                }
                            })])]) : e._e(),
                            e._v(' '),
                            t('div', {
                                staticClass: 'cropper-drag-box',
                                class: {
                                    'cropper-move': e.move && !e.crop,
                                    'cropper-crop': e.crop,
                                    'cropper-modal': e.cropping
                                },
                                on: {
                                    mousedown: e.startMove,
                                    touchstart: e.startMove
                                }
                            }),
                            e._v(' '),
                            t('div', {
                                directives: [{
                                    name: 'show',
                                    rawName: 'v-show',
                                    value: e.cropping,
                                    expression: 'cropping'
                                }],
                                staticClass: 'cropper-crop-box',
                                style: {
                                    width: e.cropW + 'px',
                                    height: e.cropH + 'px',
                                    transform: 'translate3d(' + e.cropOffsertX + 'px,' + e.cropOffsertY + 'px,0)'
                                }
                            }, [
                                t('span', { staticClass: 'cropper-view-box' }, [t('img', {
                                    style: {
                                        width: e.trueWidth + 'px',
                                        height: e.trueHeight + 'px',
                                        transform: 'scale(' + e.scale + ',' + e.scale + ') translate3d(' + (e.x - e.cropOffsertX) / e.scale + 'px,' + (e.y - e.cropOffsertY) / e.scale + 'px,0)rotateZ(' + 90 * e.rotate + 'deg)'
                                    },
                                    attrs: {
                                        src: e.imgs,
                                        alt: 'cropper-img'
                                    }
                                })]),
                                e._v(' '),
                                t('span', {
                                    staticClass: 'cropper-face cropper-move',
                                    on: {
                                        mousedown: e.cropMove,
                                        touchstart: e.cropMove
                                    }
                                }),
                                e._v(' '),
                                e.info ? t('span', {
                                    staticClass: 'crop-info',
                                    style: { top: e.cropInfo.top }
                                }, [e._v(e._s(e.cropInfo.width) + ' \xD7 ' + e._s(e.cropInfo.height))]) : e._e(),
                                e._v(' '),
                                e.fixedBox ? e._e() : t('span', [
                                    t('span', {
                                        staticClass: 'crop-line line-w',
                                        on: {
                                            mousedown: function (t) {
                                                return e.changeCropSize(t, false, true, 0, 1);
                                            },
                                            touchstart: function (t) {
                                                return e.changeCropSize(t, false, true, 0, 1);
                                            }
                                        }
                                    }),
                                    e._v(' '),
                                    t('span', {
                                        staticClass: 'crop-line line-a',
                                        on: {
                                            mousedown: function (t) {
                                                return e.changeCropSize(t, true, false, 1, 0);
                                            },
                                            touchstart: function (t) {
                                                return e.changeCropSize(t, true, false, 1, 0);
                                            }
                                        }
                                    }),
                                    e._v(' '),
                                    t('span', {
                                        staticClass: 'crop-line line-s',
                                        on: {
                                            mousedown: function (t) {
                                                return e.changeCropSize(t, false, true, 0, 2);
                                            },
                                            touchstart: function (t) {
                                                return e.changeCropSize(t, false, true, 0, 2);
                                            }
                                        }
                                    }),
                                    e._v(' '),
                                    t('span', {
                                        staticClass: 'crop-line line-d',
                                        on: {
                                            mousedown: function (t) {
                                                return e.changeCropSize(t, true, false, 2, 0);
                                            },
                                            touchstart: function (t) {
                                                return e.changeCropSize(t, true, false, 2, 0);
                                            }
                                        }
                                    }),
                                    e._v(' '),
                                    t('span', {
                                        staticClass: 'crop-point point1',
                                        on: {
                                            mousedown: function (t) {
                                                return e.changeCropSize(t, true, true, 1, 1);
                                            },
                                            touchstart: function (t) {
                                                return e.changeCropSize(t, true, true, 1, 1);
                                            }
                                        }
                                    }),
                                    e._v(' '),
                                    t('span', {
                                        staticClass: 'crop-point point2',
                                        on: {
                                            mousedown: function (t) {
                                                return e.changeCropSize(t, false, true, 0, 1);
                                            },
                                            touchstart: function (t) {
                                                return e.changeCropSize(t, false, true, 0, 1);
                                            }
                                        }
                                    }),
                                    e._v(' '),
                                    t('span', {
                                        staticClass: 'crop-point point3',
                                        on: {
                                            mousedown: function (t) {
                                                return e.changeCropSize(t, true, true, 2, 1);
                                            },
                                            touchstart: function (t) {
                                                return e.changeCropSize(t, true, true, 2, 1);
                                            }
                                        }
                                    }),
                                    e._v(' '),
                                    t('span', {
                                        staticClass: 'crop-point point4',
                                        on: {
                                            mousedown: function (t) {
                                                return e.changeCropSize(t, true, false, 1, 0);
                                            },
                                            touchstart: function (t) {
                                                return e.changeCropSize(t, true, false, 1, 0);
                                            }
                                        }
                                    }),
                                    e._v(' '),
                                    t('span', {
                                        staticClass: 'crop-point point5',
                                        on: {
                                            mousedown: function (t) {
                                                return e.changeCropSize(t, true, false, 2, 0);
                                            },
                                            touchstart: function (t) {
                                                return e.changeCropSize(t, true, false, 2, 0);
                                            }
                                        }
                                    }),
                                    e._v(' '),
                                    t('span', {
                                        staticClass: 'crop-point point6',
                                        on: {
                                            mousedown: function (t) {
                                                return e.changeCropSize(t, true, true, 1, 2);
                                            },
                                            touchstart: function (t) {
                                                return e.changeCropSize(t, true, true, 1, 2);
                                            }
                                        }
                                    }),
                                    e._v(' '),
                                    t('span', {
                                        staticClass: 'crop-point point7',
                                        on: {
                                            mousedown: function (t) {
                                                return e.changeCropSize(t, false, true, 0, 2);
                                            },
                                            touchstart: function (t) {
                                                return e.changeCropSize(t, false, true, 0, 2);
                                            }
                                        }
                                    }),
                                    e._v(' '),
                                    t('span', {
                                        staticClass: 'crop-point point8',
                                        on: {
                                            mousedown: function (t) {
                                                return e.changeCropSize(t, true, true, 2, 2);
                                            },
                                            touchstart: function (t) {
                                                return e.changeCropSize(t, true, true, 2, 2);
                                            }
                                        }
                                    })
                                ])
                            ])
                        ]);
                    };
                    function t(e, t) {
                        (null == t || t > e.length) && (t = e.length);
                        for (var r = 0, o = new Array(t); r < t; r++) {
                            ;
                        }
                        return o;
                    }
                    function n(e, r) {
                        return function (e) {
                            if (Array.isArray(e)) {
                                return e;
                            }
                        }(e) || function (e, t) {
                            var r = null == e ? null : 'undefined' != typeof Symbol && e[Symbol.iterator] || e['@@iterator'];
                            if (null != r) {
                                var o, n, a, i, s = [], c = true, l = false;
                                try {
                                    if (a = (r = r.call(e)).next, 0 === t) {
                                        if (Object(r) !== r) {
                                            return;
                                        }
                                        c = false;
                                    } else {
                                        for (; !(c = (o = a.call(r)).done) && (s.push(o.value), s.length !== t); c = true) {
                                            ;
                                        }
                                    }
                                } catch (e) {
                                    l = true;
                                    n = e;
                                } finally {
                                    try {
                                        if (!c && null != r.return && (i = r.return(), Object(i) !== i)) {
                                            return;
                                        }
                                    } finally {
                                        if (l) {
                                            throw n;
                                        }
                                    }
                                }
                                return s;
                            }
                        }(e, r) || function (e, r) {
                            if (e) {
                                if ('string' == typeof e) {
                                    return t(e, r);
                                }
                                var o = Object.prototype.toString.call(e).slice(8, -1);
                                return 'Object' === o && e.constructor && (o = e.constructor.name), 'Map' === o || 'Set' === o ? Array.from(e) : 'Arguments' === o || /^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(o) ? t(e, r) : void 0;
                            }
                        }(e, r) || function () {
                            throw new TypeError('Invalid attempt to destructure non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.');
                        }();
                    }
                    e._withStripped = true;
                    var a = {
                        getData: function (e) {
                            return new Promise(function (t, r) {
                                var o = {
                                    arrayBuffer: e,
                                    orientation: function (e) {
                                        var t, r, o, n, a, i, s, c, l, h = new DataView(e), u = h.byteLength;
                                        if (255 === h.getUint8(0) && 216 === h.getUint8(1)) {
                                            for (c = 2; c < u;) {
                                                if (255 === h.getUint8(c) && 225 === h.getUint8(c + 1)) {
                                                    i = c;
                                                    break;
                                                }
                                                c++;
                                            }
                                        }
                                        if (i && (r = i + 10, 'Exif' === function (e, t, r) {
                                            var o, n = '';
                                            for (o = t, r += t; o < r; o++) {
                                                n += String.fromCharCode(e.getUint8(o));
                                            }
                                            return n;
                                        }(h, i + 4, 4) && ((n = 18761 === (a = h.getUint16(r))) || 19789 === a) && 42 === h.getUint16(r + 2, n) && (o = h.getUint32(r + 4, n)) >= 8 && (s = r + o)), s) {
                                            for (u = h.getUint16(s, n), l = 0; l < u; l++) {
                                                if (c = s + 12 * l + 2, 274 === h.getUint16(c, n)) {
                                                    c += 8;
                                                    t = h.getUint16(c, n);
                                                    break;
                                                }
                                            }
                                        }
                                        return t;
                                    }(e)
                                };
                                (function (e) {
                                    var t = null;
                                    return new Promise(function (r, o) {
                                        if (e.src) {
                                            if (/^data\:/i.test(e.src)) {
                                                t = function (e) {
                                                    e = e.replace(/^data\:([^\;]+)\;base64,/gim, '');
                                                    for (var t = atob(e), r = t.length, o = new ArrayBuffer(r), n = new Uint8Array(o), a = 0; a < r; a++) {
                                                        n[a] = t.charCodeAt(a);
                                                    }
                                                    return o;
                                                }(e.src);
                                                r(t);
                                            } else {
                                                if (/^blob\:/i.test(e.src)) {
                                                    var n = new FileReader();
                                                    n.onload = function (e) {
                                                        t = e.target.result;
                                                        r(t);
                                                    };
                                                    (function (e, t) {
                                                        var r = new XMLHttpRequest();
                                                        r.open('GET', e, true);
                                                        r.responseType = 'blob';
                                                        r.onload = function (e) {
                                                            var t;
                                                            200 != this.status && 0 !== this.status || (t = this.response, n.readAsArrayBuffer(t));
                                                        };
                                                        r.send();
                                                    }(e.src));
                                                } else {
                                                    var a = new XMLHttpRequest();
                                                    ;
                                                    a.open('GET', e.src, true);
                                                    ;
                                                    a.send(null);
                                                }
                                            }
                                        } else {
                                            o('img error');
                                        }
                                    });
                                }(e).then(function (e) {
                                    ;
                                    ;
                                    t(o);
                                }).catch(function (e) {
                                    r(e);
                                }));
                            });
                        }
                    };
                    const i = a, s = {
                        data: function () {
                            return {
                                w: 0,
                                h: 0,
                                scale: 1,
                                x: 0,
                                y: 0,
                                loading: true,
                                trueWidth: 0,
                                trueHeight: 0,
                                move: true,
                                moveX: 0,
                                moveY: 0,
                                crop: false,
                                cropping: false,
                                cropW: 0,
                                cropH: 0,
                                cropOldW: 0,
                                cropOldH: 0,
                                canChangeX: false,
                                canChangeY: false,
                                changeCropTypeX: 1,
                                changeCropTypeY: 1,
                                cropX: 0,
                                cropY: 0,
                                cropChangeX: 0,
                                cropChangeY: 0,
                                cropOffsertX: 0,
                                cropOffsertY: 0,
                                support: '',
                                touches: [],
                                touchNow: false,
                                rotate: 0,
                                isIos: false,
                                orientation: 0,
                                imgs: '',
                                coe: 0.2,
                                scaling: false,
                                scalingSet: '',
                                coeStatus: '',
                                isCanShow: true
                            };
                        },
                        props: {
                            img: {
                                type: [
                                    String,
                                    Blob,
                                    null,
                                    File
                                ],
                                default: ''
                            },
                            outputSize: {
                                type: Number,
                                default: 1
                            },
                            outputType: {
                                type: String,
                                default: 'jpeg'
                            },
                            info: {
                                type: Boolean,
                                default: true
                            },
                            canScale: {
                                type: Boolean,
                                default: true
                            },
                            autoCrop: {
                                type: Boolean,
                                default: false
                            },
                            autoCropWidth: {
                                type: [
                                    Number,
                                    String
                                ],
                                default: 0
                            },
                            autoCropHeight: {
                                type: [
                                    Number,
                                    String
                                ],
                                default: 0
                            },
                            fixed: {
                                type: Boolean,
                                default: false
                            },
                            fixedNumber: {
                                type: Array,
                                default: function () {
                                    return [
                                        1,
                                        1
                                    ];
                                }
                            },
                            fixedBox: {
                                type: Boolean,
                                default: false
                            },
                            full: {
                                type: Boolean,
                                default: false
                            },
                            canMove: {
                                type: Boolean,
                                default: true
                            },
                            canMoveBox: {
                                type: Boolean,
                                default: true
                            },
                            original: {
                                type: Boolean,
                                default: false
                            },
                            centerBox: {
                                type: Boolean,
                                default: false
                            },
                            high: {
                                type: Boolean,
                                default: true
                            },
                            infoTrue: {
                                type: Boolean,
                                default: false
                            },
                            maxImgSize: {
                                type: [
                                    Number,
                                    String
                                ],
                                default: 2000
                            },
                            enlarge: {
                                type: [
                                    Number,
                                    String
                                ],
                                default: 1
                            },
                            preW: {
                                type: [
                                    Number,
                                    String
                                ],
                                default: 0
                            },
                            mode: {
                                type: String,
                                default: 'contain'
                            },
                            limitMinSize: {
                                type: [
                                    Number,
                                    Array,
                                    String
                                ],
                                default: function () {
                                    return 10;
                                },
                                validator: function (e) {
                                    return Array.isArray(e) ? Number(e[0]) >= 0 && Number(e[1]) >= 0 : Number(e) >= 0;
                                }
                            }
                        },
                        computed: {
                            cropInfo: function () {
                                var e = {
                                    width: e.width * t,
                                    height: e.height * t
                                };
                                if (e.top = this.cropOffsertY > 21 ? '-21px' : '0px', e.width = this.cropW > 0 ? this.cropW : 0, e.height = this.cropH > 0 ? this.cropH : 0, this.infoTrue) {
                                    var t = 1;
                                    this.high && !this.full && (t = window.devicePixelRatio);
                                    1 !== this.enlarge & !this.full && (t = Math.abs(Number(this.enlarge)));
                                    ;
                                    ;
                                    this.full && (e.width = e.width / this.scale, e.height = e.height / this.scale);
                                }
                                return e.width = e.width.toFixed(0), e.height = e.height.toFixed(0), e;
                            },
                            isIE: function () {
                                return navigator.userAgent, !!window.ActiveXObject || 'ActiveXObject' in window;
                            },
                            passive: function () {
                                return this.isIE ? null : { passive: false };
                            }
                        },
                        watch: {
                            img: function () {
                                this.checkedImg();
                            },
                            imgs: function (e) {
                                '' !== e && this.reload();
                            },
                            cropW: function () {
                                this.showPreview();
                            },
                            cropH: function () {
                                this.showPreview();
                            },
                            cropOffsertX: function () {
                                this.showPreview();
                            },
                            cropOffsertY: function () {
                                this.showPreview();
                            },
                            scale: function (e, t) {
                                this.showPreview();
                            },
                            x: function () {
                                this.showPreview();
                            },
                            y: function () {
                                this.showPreview();
                            },
                            autoCrop: function (e) {
                                e && this.goAutoCrop();
                            },
                            autoCropWidth: function () {
                                this.autoCrop && this.goAutoCrop();
                            },
                            autoCropHeight: function () {
                                this.autoCrop && this.goAutoCrop();
                            },
                            mode: function () {
                                this.checkedImg();
                            },
                            rotate: function () {
                                this.showPreview();
                                (this.autoCrop || this.cropW > 0 || this.cropH > 0) && this.goAutoCrop(this.cropW, this.cropH);
                            }
                        },
                        methods: {
                            getVersion: function (e) {
                                for (var t = navigator.userAgent.split(' '), r = '', o = new RegExp(e, 'i'), n = 0; n < t.length; n++) {
                                    o.test(t[n]) && (r = t[n]);
                                }
                                return r ? r.split('/')[1].split('.') : [
                                    '0',
                                    '0',
                                    '0'
                                ];
                            },
                            checkOrientationImage: function (e, t, r, o) {
                                var n = this;
                                if (this.getVersion('chrome')[0] >= 81) {
                                    t = -1;
                                } else {
                                    if (this.getVersion('safari')[0] >= 605) {
                                        var a = this.getVersion('version');
                                        a[0] > 13 && a[1] > 1 && (t = -1);
                                    } else {
                                        var i = navigator.userAgent.toLowerCase().match(/cpu iphone os (.*?) like mac os/);
                                        if (i) {
                                            var s = i[1];
                                            ((s = s.split('_'))[0] > 13 || s[0] >= 13 && s[1] >= 4) && (t = -1);
                                        }
                                    }
                                }
                                var c = document.createElement('canvas'), l = c.getContext('2d');
                                switch (l.save(), t) {
                                    case 2:
                                        c.width = r, c.height = o, l.translate(r, 0), l.scale(-1, 1);
                                        break;
                                    case 3:
                                        c.width = r, c.height = o, l.translate(r / 2, o / 2), l.rotate(180 * Math.PI / 180), l.translate(-r / 2, -o / 2);
                                        break;
                                    case 4:
                                        c.width = r, c.height = o, l.translate(0, o), l.scale(1, -1);
                                        break;
                                    case 5:
                                        c.height = r, c.width = o, l.rotate(0.5 * Math.PI), l.scale(1, -1);
                                        break;
                                    case 6:
                                        c.width = o, c.height = r, l.translate(o / 2, r / 2), l.rotate(90 * Math.PI / 180), l.translate(-r / 2, -o / 2);
                                        break;
                                    case 7:
                                        c.height = r, c.width = o, l.rotate(0.5 * Math.PI), l.translate(r, -o), l.scale(-1, 1);
                                        break;
                                    case 8:
                                        c.height = r, c.width = o, l.translate(o / 2, r / 2), l.rotate(-90 * Math.PI / 180), l.translate(-r / 2, -o / 2);
                                        break;
                                    default:
                                        c.width = r, c.height = o;
                                }
                                l.drawImage(e, 0, 0, r, o);
                                l.restore();
                                c.toBlob(function (e) {
                                    var t = URL.createObjectURL(e);
                                    URL.revokeObjectURL(n.imgs);
                                    n.imgs = t;
                                }, 'image/' + this.outputType, 1);
                            },
                            checkedImg: function () {
                                var e = this;
                                if (null === this.img || '' === this.img) {
                                    return this.imgs = '', void this.clearCrop();
                                }
                                this.loading = true;
                                this.scale = 1;
                                this.rotate = 0;
                                this.clearCrop();
                                var t = new Image();
                                if (t.onload = function () {
                                    if ('' === e.img) {
                                        return e.$emit('img-load', 'error'), false;
                                    }
                                    var r = t.width, o = t.height;
                                    i.getData(t).then(function (n) {
                                        e.orientation = n.orientation || 1;
                                        var a = Number(e.maxImgSize);
                                        !e.orientation && r < a & o < a ? e.imgs = e.img : (r > a && (o = o / r * a, r = a), o > a && (r = r / o * a, o = a), e.checkOrientationImage(t, e.orientation, r, o));
                                    });
                                }, t.onerror = function () {
                                    e.$emit('img-load', 'error');
                                }, 'data' !== this.img.substr(0, 4) && (t.crossOrigin = ''), this.isIE) {
                                    var r = new XMLHttpRequest();
                                    r.onload = function () {
                                        var e = URL.createObjectURL(this.response);
                                        ;
                                    };
                                    r.open('GET', this.img, true);
                                    r.responseType = 'blob';
                                    r.send();
                                } else {
                                    ;
                                }
                            },
                            startMove: function (e) {
                                if (e.preventDefault(), this.move && !this.crop) {
                                    if (!this.canMove) {
                                        return false;
                                    }
                                    this.moveX = ('clientX' in e ? e.clientX : e.touches[0].clientX) - this.x;
                                    this.moveY = ('clientY' in e ? e.clientY : e.touches[0].clientY) - this.y;
                                    e.touches ? (window.addEventListener('touchmove', this.moveImg), window.addEventListener('touchend', this.leaveImg), 2 == e.touches.length && (this.touches = e.touches, window.addEventListener('touchmove', this.touchScale), window.addEventListener('touchend', this.cancelTouchScale))) : (window.addEventListener('mousemove', this.moveImg), window.addEventListener('mouseup', this.leaveImg));
                                    this.$emit('img-moving', {
                                        moving: true,
                                        axis: this.getImgAxis()
                                    });
                                } else {
                                    this.cropping = true;
                                    window.addEventListener('mousemove', this.createCrop);
                                    window.addEventListener('mouseup', this.endCrop);
                                    window.addEventListener('touchmove', this.createCrop);
                                    window.addEventListener('touchend', this.endCrop);
                                    this.cropOffsertX = e.offsetX ? e.offsetX : e.touches[0].pageX - this.$refs.cropper.offsetLeft;
                                    this.cropOffsertY = e.offsetY ? e.offsetY : e.touches[0].pageY - this.$refs.cropper.offsetTop;
                                    this.cropX = 'clientX' in e ? e.clientX : e.touches[0].clientX;
                                    this.cropY = 'clientY' in e ? e.clientY : e.touches[0].clientY;
                                    this.cropChangeX = this.cropOffsertX;
                                    this.cropChangeY = this.cropOffsertY;
                                    this.cropW = 0;
                                    this.cropH = 0;
                                }
                            },
                            touchScale: function (e) {
                                var t = this;
                                e.preventDefault();
                                var r = this.scale, o = this.touches[0].clientX, n = this.touches[0].clientY, a = e.touches[0].clientX, i = e.touches[0].clientY, s = this.touches[1].clientX, c = this.touches[1].clientY, l = e.touches[1].clientX, h = e.touches[1].clientY, u = Math.sqrt(Math.pow(o - s, 2) + Math.pow(n - c, 2)), p = Math.sqrt(Math.pow(a - l, 2) + Math.pow(i - h, 2)) - u, f = 1, d = (f = (f = f / this.trueWidth > f / this.trueHeight ? f / this.trueHeight : f / this.trueWidth) > 0.1 ? 0.1 : f) * p;
                                if (!this.touchNow) {
                                    if (this.touchNow = true, p > 0 ? r += Math.abs(d) : p < 0 && r > Math.abs(d) && (r -= Math.abs(d)), this.touches = e.touches, setTimeout(function () {
                                        ;
                                    }, 8), !this.checkoutImgAxis(this.x, this.y, r)) {
                                        return false;
                                    }
                                    this.scale = r;
                                }
                            },
                            cancelTouchScale: function (e) {
                                window.removeEventListener('touchmove', this.touchScale);
                            },
                            moveImg: function (e) {
                                var t = this;
                                if (e.preventDefault(), e.touches && 2 === e.touches.length) {
                                    return this.touches = e.touches, window.addEventListener('touchmove', this.touchScale), window.addEventListener('touchend', this.cancelTouchScale), window.removeEventListener('touchmove', this.moveImg), false;
                                }
                                var r, o, n = 'clientX' in e ? e.clientX : e.touches[0].clientX, a = 'clientY' in e ? e.clientY : e.touches[0].clientY;
                                r = n - this.moveX;
                                o = a - this.moveY;
                                this.$nextTick(function () {
                                    if (t.centerBox) {
                                        var e, n, a, i, s = t.getImgAxis(r, o, t.scale), c = t.getCropAxis(), l = t.trueHeight * t.scale, h = t.trueWidth * t.scale;
                                        switch (t.rotate) {
                                            case 1:
                                            case -1:
                                            case 3:
                                            case -3:
                                                e = t.cropOffsertX - t.trueWidth * (1 - t.scale) / 2 + (l - h) / 2, n = t.cropOffsertY - t.trueHeight * (1 - t.scale) / 2 + (h - l) / 2, a = e - l + t.cropW, i = n - h + t.cropH;
                                                break;
                                            default:
                                                e = t.cropOffsertX - t.trueWidth * (1 - t.scale) / 2, n = t.cropOffsertY - t.trueHeight * (1 - t.scale) / 2, a = e - h + t.cropW, i = n - l + t.cropH;
                                        }
                                        s.x1 >= c.x1 && (r = e);
                                        s.y1 >= c.y1 && (o = n);
                                        s.x2 <= c.x2 && (r = a);
                                        s.y2 <= c.y2 && (o = i);
                                    }
                                    ;
                                    ;
                                    t.$emit('img-moving', {
                                        moving: true,
                                        axis: t.getImgAxis()
                                    });
                                });
                            },
                            leaveImg: function (e) {
                                window.removeEventListener('mousemove', this.moveImg);
                                window.removeEventListener('touchmove', this.moveImg);
                                window.removeEventListener('mouseup', this.leaveImg);
                                window.removeEventListener('touchend', this.leaveImg);
                                this.$emit('img-moving', {
                                    moving: false,
                                    axis: this.getImgAxis()
                                });
                            },
                            scaleImg: function () {
                                this.canScale && window.addEventListener(this.support, this.changeSize, this.passive);
                            },
                            cancelScale: function () {
                                this.canScale && window.removeEventListener(this.support, this.changeSize);
                            },
                            changeSize: function (e) {
                                var t = this;
                                e.preventDefault();
                                var r = this.scale, o = e.deltaY || e.wheelDelta;
                                o = navigator.userAgent.indexOf('Firefox') > 0 ? 30 * o : o;
                                this.isIE && (o = -o);
                                var n = this.coe, a = (n = n / this.trueWidth > n / this.trueHeight ? n / this.trueHeight : n / this.trueWidth) * o;
                                a < 0 ? r += Math.abs(a) : r > Math.abs(a) && (r -= Math.abs(a));
                                var i = a < 0 ? 'add' : 'reduce';
                                if (i !== this.coeStatus && (this.coeStatus = i, this.coe = 0.2), this.scaling || (this.scalingSet = setTimeout(function () {
                                    ;
                                    ;
                                }, 50)), this.scaling = true, !this.checkoutImgAxis(this.x, this.y, r)) {
                                    return false;
                                }
                                this.scale = r;
                            },
                            changeScale: function (e) {
                                var t = this.scale;
                                e = e || 1;
                                var r = 20;
                                if ((e *= r = r / this.trueWidth > r / this.trueHeight ? r / this.trueHeight : r / this.trueWidth) > 0 ? t += Math.abs(e) : t > Math.abs(e) && (t -= Math.abs(e)), !this.checkoutImgAxis(this.x, this.y, t)) {
                                    return false;
                                }
                                this.scale = t;
                            },
                            createCrop: function (e) {
                                var t = this;
                                e.preventDefault();
                                var r = 'clientX' in e ? e.clientX : e.touches ? e.touches[0].clientX : 0, o = 'clientY' in e ? e.clientY : e.touches ? e.touches[0].clientY : 0;
                                this.$nextTick(function () {
                                    var e = r - t.cropX, n = o - t.cropY;
                                    if (e > 0 ? (t.cropW = e + t.cropChangeX > t.w ? t.w - t.cropChangeX : e, t.cropOffsertX = t.cropChangeX) : (t.cropW = t.w - t.cropChangeX + Math.abs(e) > t.w ? t.cropChangeX : Math.abs(e), t.cropOffsertX = t.cropChangeX + e > 0 ? t.cropChangeX + e : 0), t.fixed) {
                                        var a = t.cropW / t.fixedNumber[0] * t.fixedNumber[1];
                                        a + t.cropOffsertY > t.h ? (t.cropH = t.h - t.cropOffsertY, t.cropW = t.cropH / t.fixedNumber[1] * t.fixedNumber[0], t.cropOffsertX = e > 0 ? t.cropChangeX : t.cropChangeX - t.cropW) : t.cropH = a;
                                        ;
                                    } else {
                                        n > 0 ? (t.cropH = n + t.cropChangeY > t.h ? t.h - t.cropChangeY : n, t.cropOffsertY = t.cropChangeY) : (t.cropH = t.h - t.cropChangeY + Math.abs(n) > t.h ? t.cropChangeY : Math.abs(n), t.cropOffsertY = t.cropChangeY + n > 0 ? t.cropChangeY + n : 0);
                                    }
                                });
                            },
                            changeCropSize: function (e, t, r, o, n) {
                                e.preventDefault();
                                window.addEventListener('mousemove', this.changeCropNow);
                                window.addEventListener('mouseup', this.changeCropEnd);
                                window.addEventListener('touchmove', this.changeCropNow);
                                window.addEventListener('touchend', this.changeCropEnd);
                                this.canChangeX = t;
                                this.canChangeY = r;
                                this.changeCropTypeX = o;
                                this.changeCropTypeY = n;
                                this.cropX = 'clientX' in e ? e.clientX : e.touches[0].clientX;
                                this.cropY = 'clientY' in e ? e.clientY : e.touches[0].clientY;
                                this.cropOldW = this.cropW;
                                this.cropOldH = this.cropH;
                                this.cropChangeX = this.cropOffsertX;
                                this.cropChangeY = this.cropOffsertY;
                                this.fixed && this.canChangeX && this.canChangeY && (this.canChangeY = 0);
                                this.$emit('change-crop-size', {
                                    width: this.cropW,
                                    height: this.cropH
                                });
                            },
                            changeCropNow: function (e) {
                                var t = this;
                                e.preventDefault();
                                var r = 'clientX' in e ? e.clientX : e.touches ? e.touches[0].clientX : 0, o = 'clientY' in e ? e.clientY : e.touches ? e.touches[0].clientY : 0, a = this.w, i = this.h, s = 0, c = 0;
                                if (this.centerBox) {
                                    var l = this.getImgAxis(), h = l.x2, u = l.y2;
                                    s = l.x1 > 0 ? l.x1 : 0;
                                    c = l.y1 > 0 ? l.y1 : 0;
                                    a > h && (a = h);
                                    i > u && (i = u);
                                }
                                var p = n(this.checkCropLimitSize(), 2), f = p[0], d = p[1];
                                this.$nextTick(function () {
                                    var e = r - t.cropX, n = o - t.cropY;
                                    if (t.canChangeX && (1 === t.changeCropTypeX ? t.cropOldW - e < f ? (t.cropW = f, t.cropOffsertX = t.cropOldW + t.cropChangeX - s - f) : t.cropOldW - e > 0 ? (t.cropW = a - t.cropChangeX - e <= a - s ? t.cropOldW - e : t.cropOldW + t.cropChangeX - s, t.cropOffsertX = a - t.cropChangeX - e <= a - s ? t.cropChangeX + e : s) : (t.cropW = Math.abs(e) + t.cropChangeX <= a ? Math.abs(e) - t.cropOldW : a - t.cropOldW - t.cropChangeX, t.cropOffsertX = t.cropChangeX + t.cropOldW) : 2 === t.changeCropTypeX && (t.cropOldW + e < f ? t.cropW = f : t.cropOldW + e > 0 ? (t.cropW = t.cropOldW + e + t.cropOffsertX <= a ? t.cropOldW + e : a - t.cropOffsertX, t.cropOffsertX = t.cropChangeX) : (t.cropW = a - t.cropChangeX + Math.abs(e + t.cropOldW) <= a - s ? Math.abs(e + t.cropOldW) : t.cropChangeX - s, t.cropOffsertX = a - t.cropChangeX + Math.abs(e + t.cropOldW) <= a - s ? t.cropChangeX - Math.abs(e + t.cropOldW) : s))), t.canChangeY && (1 === t.changeCropTypeY ? t.cropOldH - n < d ? (t.cropH = d, t.cropOffsertY = t.cropOldH + t.cropChangeY - c - d) : t.cropOldH - n > 0 ? (t.cropH = i - t.cropChangeY - n <= i - c ? t.cropOldH - n : t.cropOldH + t.cropChangeY - c, t.cropOffsertY = i - t.cropChangeY - n <= i - c ? t.cropChangeY + n : c) : (t.cropH = Math.abs(n) + t.cropChangeY <= i ? Math.abs(n) - t.cropOldH : i - t.cropOldH - t.cropChangeY, t.cropOffsertY = t.cropChangeY + t.cropOldH) : 2 === t.changeCropTypeY && (t.cropOldH + n < d ? t.cropH = d : t.cropOldH + n > 0 ? (t.cropH = t.cropOldH + n + t.cropOffsertY <= i ? t.cropOldH + n : i - t.cropOffsertY, t.cropOffsertY = t.cropChangeY) : (t.cropH = i - t.cropChangeY + Math.abs(n + t.cropOldH) <= i - c ? Math.abs(n + t.cropOldH) : t.cropChangeY - c, t.cropOffsertY = i - t.cropChangeY + Math.abs(n + t.cropOldH) <= i - c ? t.cropChangeY - Math.abs(n + t.cropOldH) : c))), t.canChangeX && t.fixed) {
                                        var l = t.cropW / t.fixedNumber[0] * t.fixedNumber[1];
                                        l < d ? (t.cropH = d, t.cropW = t.fixedNumber[0] * d / t.fixedNumber[1], t.cropOffsertX = t.cropOldW + t.cropChangeX - t.cropW) : l + t.cropOffsertY > i ? (t.cropH = i - t.cropOffsertY, t.cropW = t.cropH / t.fixedNumber[1] * t.fixedNumber[0]) : t.cropH = l;
                                    }
                                    if (t.canChangeY && t.fixed) {
                                        var h = t.cropH / t.fixedNumber[1] * t.fixedNumber[0];
                                        h < f ? (t.cropW = f, t.cropH = t.fixedNumber[1] * f / t.fixedNumber[0], 1 === t.changeCropTypeX && (t.cropOffsertX = t.cropChangeX + (t.cropOldW - t.cropW))) : h + t.cropOffsertX > a ? (t.cropW = a - t.cropOffsertX, t.cropH = t.cropW / t.fixedNumber[0] * t.fixedNumber[1]) : t.cropW = h;
                                    }
                                    t.$emit('crop-sizing', {
                                        cropW: t.cropW,
                                        cropH: t.cropH
                                    });
                                });
                            },
                            checkCropLimitSize: function () {
                                this.cropW;
                                this.cropH;
                                var e = this.limitMinSize, t = new Array();
                                return t = Array.isArray(e) ? e : [
                                    e,
                                    e
                                ], [
                                        parseFloat(t[0]),
                                        parseFloat(t[1])
                                    ];
                            },
                            changeCropEnd: function (e) {
                                window.removeEventListener('mousemove', this.changeCropNow);
                                window.removeEventListener('mouseup', this.changeCropEnd);
                                window.removeEventListener('touchmove', this.changeCropNow);
                                window.removeEventListener('touchend', this.changeCropEnd);
                            },
                            calculateSize: function (e, t, r, o, n, a) {
                                var i = e / t, s = n, c = a;
                                return s < r && (s = r, c = Math.ceil(s / i)), c < o && (c = o, (s = Math.ceil(c * i)) < r && (s = r, c = Math.ceil(s / i))), s < n && (s = n, c = Math.ceil(s / i)), c < a && (c = a, s = Math.ceil(c * i)), {
                                    width: s,
                                    height: c
                                };
                            },
                            endCrop: function () {
                                0 === this.cropW && 0 === this.cropH && (this.cropping = false);
                                var e = n(this.checkCropLimitSize(), 2), t = e[0], r = e[1], o = this.fixed ? this.calculateSize(this.fixedNumber[0], this.fixedNumber[1], t, r, this.cropW, this.cropH) : {
                                    width: t,
                                    height: r
                                }, a = o.width, i = o.height;
                                a > this.cropW && (this.cropW = a, this.cropOffsertX + a > this.w && (this.cropOffsertX = this.w - a));
                                i > this.cropH && (this.cropH = i, this.cropOffsertY + i > this.h && (this.cropOffsertY = this.h - i));
                                window.removeEventListener('mousemove', this.createCrop);
                                window.removeEventListener('mouseup', this.endCrop);
                                window.removeEventListener('touchmove', this.createCrop);
                                window.removeEventListener('touchend', this.endCrop);
                            },
                            startCrop: function () {
                                this.crop = true;
                            },
                            stopCrop: function () {
                                this.crop = false;
                            },
                            clearCrop: function () {
                                this.cropping = false;
                                this.cropW = 0;
                                this.cropH = 0;
                            },
                            cropMove: function (e) {
                                if (e.preventDefault(), !this.canMoveBox) {
                                    return this.crop = false, this.startMove(e), false;
                                }
                                if (e.touches && 2 === e.touches.length) {
                                    return this.crop = false, this.startMove(e), this.leaveCrop(), false;
                                }
                                window.addEventListener('mousemove', this.moveCrop);
                                window.addEventListener('mouseup', this.leaveCrop);
                                window.addEventListener('touchmove', this.moveCrop);
                                window.addEventListener('touchend', this.leaveCrop);
                                var t, r, o = 'clientX' in e ? e.clientX : e.touches[0].clientX, n = 'clientY' in e ? e.clientY : e.touches[0].clientY;
                                t = o - this.cropOffsertX;
                                r = n - this.cropOffsertY;
                                this.cropX = t;
                                this.cropY = r;
                                this.$emit('crop-moving', {
                                    moving: true,
                                    axis: this.getCropAxis()
                                });
                            },
                            moveCrop: function (e, t) {
                                var r = this, o = 0, n = 0;
                                e && (e.preventDefault(), o = 'clientX' in e ? e.clientX : e.touches[0].clientX, n = 'clientY' in e ? e.clientY : e.touches[0].clientY);
                                this.$nextTick(function () {
                                    var e, a, i = o - r.cropX, s = n - r.cropY;
                                    if (t && (i = r.cropOffsertX, s = r.cropOffsertY), e = i <= 0 ? 0 : i + r.cropW > r.w ? r.w - r.cropW : i, a = s <= 0 ? 0 : s + r.cropH > r.h ? r.h - r.cropH : s, r.centerBox) {
                                        var c = r.getImgAxis();
                                        e <= c.x1 && (e = c.x1);
                                        e + r.cropW > c.x2 && (e = c.x2 - r.cropW);
                                        a <= c.y1 && (a = c.y1);
                                        a + r.cropH > c.y2 && (a = c.y2 - r.cropH);
                                    }
                                    r.cropOffsertX = e;
                                    r.cropOffsertY = a;
                                    r.$emit('crop-moving', {
                                        moving: true,
                                        axis: r.getCropAxis()
                                    });
                                });
                            },
                            getImgAxis: function (e, t, r) {
                                e = e || this.x;
                                t = t || this.y;
                                r = r || this.scale;
                                var n = this.trueWidth * r, a = this.trueHeight * r;
                                switch (this.rotate) {
                                    case 0:
                                        0 = e + this.trueWidth * (1 - r) / 2, 0 = 0 + this.trueWidth * r, 0 = t + this.trueHeight * (1 - r) / 2, 0 = 0 + this.trueHeight * r;
                                        break;
                                    case 1:
                                    case -1:
                                    case 3:
                                    case -3:
                                        0 = e + this.trueWidth * (1 - r) / 2 + (n - a) / 2, 0 = 0 + this.trueHeight * r, 0 = t + this.trueHeight * (1 - r) / 2 + (a - n) / 2, 0 = 0 + this.trueWidth * r;
                                        break;
                                    default:
                                        0 = e + this.trueWidth * (1 - r) / 2, 0 = 0 + this.trueWidth * r, 0 = t + this.trueHeight * (1 - r) / 2, 0 = 0 + this.trueHeight * r;
                                }
                                return o;
                            },
                            getCropAxis: function () {
                                ;
                                return 0 = this.cropOffsertX, 0 = 0 + this.cropW, 0 = this.cropOffsertY, 0 = 0 + this.cropH, e;
                            },
                            leaveCrop: function (e) {
                                window.removeEventListener('mousemove', this.moveCrop);
                                window.removeEventListener('mouseup', this.leaveCrop);
                                window.removeEventListener('touchmove', this.moveCrop);
                                window.removeEventListener('touchend', this.leaveCrop);
                                this.$emit('crop-moving', {
                                    moving: false,
                                    axis: this.getCropAxis()
                                });
                            },
                            getCropChecked: function (e) {
                                var t = this, r = document.createElement('canvas'), o = new Image(), n = this.rotate, a = this.trueWidth, i = this.trueHeight, s = this.cropOffsertX, c = this.cropOffsertY;
                                function l(e, t) {
                                    r.width = Math.round(e);
                                    r.height = Math.round(t);
                                }
                                ;
                                'data' !== this.img.substr(0, 4) && (o.crossOrigin = 'Anonymous');
                                ;
                            },
                            getCropData: function (e) {
                                var t = this;
                                this.getCropChecked(function (r) {
                                    e(r.toDataURL('image/' + t.outputType, t.outputSize));
                                });
                            },
                            getCropBlob: function (e) {
                                var t = this;
                                this.getCropChecked(function (r) {
                                    r.toBlob(function (t) {
                                        return e(t);
                                    }, 'image/' + t.outputType, t.outputSize);
                                });
                            },
                            showPreview: function () {
                                var e = this;
                                if (!this.isCanShow) {
                                    return false;
                                }
                                this.isCanShow = false;
                                setTimeout(function () {
                                    e.isCanShow = true;
                                }, 16);
                                var t = this.cropW, r = this.cropH, o = this.scale, n = {
                                    div: {
                                        width: ''.concat(t, 'px'),
                                        height: ''.concat(r, 'px')
                                    },
                                    w: t,
                                    h: r,
                                    url: this.imgs,
                                    img: {
                                        width: ''.concat(this.trueWidth, 'px'),
                                        height: ''.concat(this.trueHeight, 'px'),
                                        transform: 'scale('.concat(o, ')translate3d(').concat(a, 'px, ').concat(i, 'px, ').concat(0, 'px)rotateZ(').concat(90 * this.rotate, 'deg)')
                                    },
                                    html: '\n      <div class="show-preview" style="width: '.concat(n.w, 'px; height: ').concat(n.h, 'px; overflow: hidden">\n        <div style="width: ').concat(t, 'px; height: ').concat(r, 'px">\n          <img src=').concat(n.url, ' style="width: ').concat(this.trueWidth, 'px; height: ').concat(this.trueHeight, 'px; transform:\n          scale(').concat(o, ')translate3d(').concat(a, 'px, ').concat(i, 'px, ').concat(0, 'px)rotateZ(').concat(90 * this.rotate, 'deg)">\n        </div>\n      </div>')
                                };
                                ;
                                var a = (this.x - this.cropOffsertX) / o, i = (this.y - this.cropOffsertY) / o;
                                ;
                                ;
                                ;
                                ;
                                ;
                                this.$emit('real-time', n);
                            },
                            reload: function () {
                                var e = this, t = new Image();
                                ;
                                ;
                                ;
                            },
                            checkedMode: function () {
                                var e = 1, t = (this.trueWidth, this.trueHeight), r = this.mode.split(' ');
                                switch (r[0]) {
                                    case 'contain':
                                        this.trueWidth > this.w && (e = this.w / this.trueWidth), this.trueHeight * e > this.h && (e = this.h / this.trueHeight);
                                        break;
                                    case 'cover':
                                        (t *= e = this.w / this.trueWidth) < this.h && (e = (t = this.h) / this.trueHeight);
                                        break;
                                    default:
                                        try {
                                            var o = r[0];
                                            if (-1 !== o.search('px')) {
                                                o = o.replace('px', '');
                                                var n = parseFloat(o) / this.trueWidth, a = 1, i = r[1];
                                                -1 !== i.search('px') && (i = i.replace('px', ''), a = (t = parseFloat(i)) / this.trueHeight);
                                                e = Math.min(n, a);
                                            }
                                            if (-1 !== o.search('%') && (o = o.replace('%', ''), e = parseFloat(o) / 100 * this.w / this.trueWidth), 2 === r.length && 'auto' === o) {
                                                var s = r[1];
                                                -1 !== s.search('px') && (s = s.replace('px', ''), e = (t = parseFloat(s)) / this.trueHeight);
                                                -1 !== s.search('%') && (s = s.replace('%', ''), e = (t = parseFloat(s) / 100 * this.h) / this.trueHeight);
                                            }
                                        } catch (t) {
                                            e = 1;
                                        }
                                }
                                return e;
                            },
                            goAutoCrop: function (e, t) {
                                if ('' !== this.imgs && null !== this.imgs) {
                                    this.clearCrop();
                                    this.cropping = true;
                                    var r = this.w, o = this.h;
                                    if (this.centerBox) {
                                        var n = Math.abs(this.rotate) % 2 > 0, a = (n ? this.trueHeight : this.trueWidth) * this.scale, i = (n ? this.trueWidth : this.trueHeight) * this.scale;
                                        r = a < r ? a : r;
                                        o = i < o ? i : o;
                                    }
                                    var s = e || parseFloat(this.autoCropWidth), c = t || parseFloat(this.autoCropHeight);
                                    0 !== s && 0 !== c || (s = 0.8 * r, c = 0.8 * o);
                                    s = s > r ? r : s;
                                    c = c > o ? o : c;
                                    this.fixed && (c = s / this.fixedNumber[0] * this.fixedNumber[1]);
                                    c > this.h && (s = (c = this.h) / this.fixedNumber[1] * this.fixedNumber[0]);
                                    this.changeCrop(s, c);
                                }
                            },
                            changeCrop: function (e, t) {
                                var r = this;
                                if (this.centerBox) {
                                    var o = this.getImgAxis();
                                    e > o.x2 - o.x1 && (t = (e = o.x2 - o.x1) / this.fixedNumber[0] * this.fixedNumber[1]);
                                    t > o.y2 - o.y1 && (e = (t = o.y2 - o.y1) / this.fixedNumber[1] * this.fixedNumber[0]);
                                }
                                this.cropW = e;
                                this.cropH = t;
                                this.checkCropLimitSize();
                                this.$nextTick(function () {
                                    r.cropOffsertX = (r.w - r.cropW) / 2;
                                    r.cropOffsertY = (r.h - r.cropH) / 2;
                                    r.centerBox && r.moveCrop(null, true);
                                });
                            },
                            refresh: function () {
                                var e = this;
                                this.img;
                                this.imgs = '';
                                this.scale = 1;
                                this.crop = false;
                                this.rotate = 0;
                                this.w = 0;
                                this.h = 0;
                                this.trueWidth = 0;
                                this.trueHeight = 0;
                                this.clearCrop();
                                this.$nextTick(function () {
                                    e.checkedImg();
                                });
                            },
                            rotateLeft: function () {
                                this.rotate = this.rotate <= -3 ? 0 : this.rotate - 1;
                            },
                            rotateRight: function () {
                                this.rotate = this.rotate >= 3 ? 0 : this.rotate + 1;
                            },
                            rotateClear: function () {
                                this.rotate = 0;
                            },
                            checkoutImgAxis: function (e, t, r) {
                                e = e || this.x;
                                t = t || this.y;
                                r = r || this.scale;
                                var o = true;
                                if (this.centerBox) {
                                    var n = this.getImgAxis(e, t, r), a = this.getCropAxis();
                                    n.x1 >= a.x1 && (o = false);
                                    n.x2 <= a.x2 && (o = false);
                                    n.y1 >= a.y1 && (o = false);
                                    n.y2 <= a.y2 && (o = false);
                                }
                                return o;
                            }
                        },
                        mounted: function () {
                            this.support = 'onwheel' in document.createElement('div') ? 'wheel' : void 0 !== document.onmousewheel ? 'mousewheel' : 'DOMMouseScroll';
                            var e = this, t = navigator.userAgent;
                            this.isIOS = !!t.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/);
                            HTMLCanvasElement.prototype.toBlob || Object.defineProperty(HTMLCanvasElement.prototype, 'toBlob', {
                                value: function (t, r, o) {
                                    for (var n = atob(this.toDataURL(r, o).split(',')[1]), a = n.length, i = new Uint8Array(a), s = 0; s < a; s++) {
                                        i[s] = n.charCodeAt(s);
                                    }
                                    t(new Blob([i], { type: e.type || 'image/png' }));
                                }
                            });
                            this.showPreview();
                            this.checkedImg();
                        },
                        destroyed: function () {
                            window.removeEventListener('mousemove', this.moveCrop);
                            window.removeEventListener('mouseup', this.leaveCrop);
                            window.removeEventListener('touchmove', this.moveCrop);
                            window.removeEventListener('touchend', this.leaveCrop);
                            this.cancelScale();
                        }
                    };
                    r(97);
                    var c = function (e, t, r, o, n, a, i, s) {
                        var c, l = 'function' == typeof e ? e.options : e;
                        if (t && (l.render = t, l.staticRenderFns = [], l._compiled = true), a && (l._scopeId = 'data-v-' + a), c) {
                            if (l.functional) {
                                l._injectStyles = c;
                                var h = l.render;
                                l.render = function (e, t) {
                                    return c.call(t), h(e, t);
                                };
                            } else {
                                var u = l.beforeCreate;
                                l.beforeCreate = u ? [].concat(u, c) : [c];
                            }
                        }
                        return {
                            exports: e,
                            options: l
                        };
                    }(s, e, 0, 0, 0, '07be87c7');
                    const l = c.exports;
                    var h = function (e) {
                        e.component('VueCropper', l);
                    };
                    'undefined' != typeof window && window.Vue && h(window.Vue);
                    const u = {
                        version: '0.5.10',
                        install: h,
                        VueCropper: l,
                        vueCropper: l
                    };
                })(), o;
            })());
        },
        '857a': function (e, t, r) {
            var o = r('e330'), n = r('1d80'), a = r('577e'), s = o(''.replace);
            e.exports = function (e, t, r, o) {
                var c = a(n(e)), l = '<' + t;
                return '' !== r && (l += ' ' + r + '="' + s(a(o), /"/g, '&quot;') + '"'), l + '>' + c + '</' + t + '>';
            };
        },
        aaf0: function (e, t, r) {
            'use strict';
            var o = function () {
                var e = this, t = e._self._c;
                return t('div', {
                    class: [
                        'error-wrapper',
                        e.bgWhiteAuth ? 'bg-white' : ''
                    ]
                }, [t('div', { staticClass: 'center' }, [
                    t('div', { staticClass: 'error-status' }),
                    t('div', { staticClass: 'message' }, [
                        t('div', { staticClass: 'message-main' }, [e._v(e._s(e.message))]),
                        e.scene ? t('p', { staticClass: 'message-sub' }, [e._v(' ' + e._s('Scene: '.concat(e.scene, '.')) + ' ' + e._s(e.subMessage) + ' ')]) : e._e()
                    ]),
                    t('div', { staticClass: 'button-wrapper' }, [
                        e.showRefresh ? t('a-button', {
                            class: e.showBack || e.isClassLiveOrPlayback ? 'mr40' : '',
                            attrs: {
                                type: 'primary',
                                shape: 'round',
                                size: 'large'
                            },
                            on: { click: e.handleRefresh }
                        }, [e._v(' ' + e._s(e.$t('common.refresh')) + ' ')]) : e._e(),
                        e.showBack || e.isClassLiveOrPlayback ? t('a-button', {
                            staticClass: 'color-orange',
                            attrs: {
                                shape: 'round',
                                size: 'large'
                            },
                            on: { click: e.handleBack }
                        }, [e._v(' ' + e._s(e.isClassLiveOrPlayback ? e.$t('classroom.modules.systemError.backButtonName') : e.$t('common.back')) + ' ')]) : e._e()
                    ], 1)
                ])]);
            }, n = [], a = (r('14d9'), r('caad'), {
                name: 'ErrorStatus',
                props: {
                    message: {
                        type: String,
                        default: function () {
                            return console.info('对象函数 default,filePath:renderer/components/Common/ErrorStatus.vue'), this.$t('common.components.errorStatus.message');
                        }
                    },
                    isClassLiveOrPlayback: {
                        type: Boolean,
                        default: false
                    },
                    scene: {
                        type: String,
                        default: ''
                    },
                    subMessage: {
                        type: String,
                        default: ''
                    },
                    showRefresh: {
                        type: Boolean,
                        default: true
                    },
                    showBack: {
                        type: Boolean,
                        default: false
                    },
                    backUrl: {
                        type: String,
                        default: ''
                    }
                },
                computed: {
                    bgWhiteAuth: function () {
                        return console.info('对象函数 bgWhiteAuth,filePath:renderer/components/Common/ErrorStatus.vue'), [
                            'ClassLiving',
                            'PlaybackReadyClass',
                            'LivingReadyClass',
                            'PlayBack'
                        ].includes(this.scene);
                    }
                },
                methods: {
                    handleRefresh: function () {
                        console.info('对象函数 handleRefresh,filePath:renderer/components/Common/ErrorStatus.vue');
                        this.isClassLiveOrPlayback ? window.location.reload() : this.$emit('click-refresh');
                    },
                    handleBack: function () {
                        console.info('对象函数 handleBack,filePath:renderer/components/Common/ErrorStatus.vue');
                        this.isClassLiveOrPlayback ? window.location.href = ''.concat(window.location.origin, '/#/courses') : this.$router.push({ path: this.backUrl });
                    }
                }
            }), i = a, s = (r('dc2d'), r('2877')), c = Object(s.a)(i, o, n, false, null, 'f910b7da', null);
            t.a = c.exports;
        },
        af03: function (e, t, r) {
            var o = r('d039');
            e.exports = function (e) {
                return o(function () {
                    var t = ''[e]('"');
                    return t !== t.toLowerCase() || t.split('"').length > 3;
                });
            };
        },
        bd12: function (e, t, r) {
            'use strict';
            var o = function () {
                var e = this, t = e._self._c;
                return e.show ? t('div', {
                    staticClass: 'loading-wrapper',
                    class: e.className,
                    style: e.loadingStyle
                }, [e._m(0)]) : e._e();
            }, n = [function () {
                var e = this, t = e._self._c;
                return t('div', { staticClass: 'loading-contenter' }, [
                    t('div', { staticClass: 'loading-logo' }, [t('img', { attrs: { src: r('c63e') } })]),
                    t('div', { staticClass: 'loading-animation' })
                ]);
            }], a = {
                name: 'Loading',
                props: {
                    show: {
                        default: true,
                        type: Boolean
                    },
                    size: {
                        default: 'default',
                        type: String,
                        validator: function (e) {
                            return console.info('对象函数 validator(value)', e, 'filePath:renderer/components/Common/Loading.vue'), -1 !== [
                                'small',
                                'default'
                            ].indexOf(e);
                        }
                    },
                    marginTop: {
                        default: '0',
                        type: String
                    },
                    marginBottom: {
                        default: '0',
                        type: String
                    }
                },
                computed: {
                    className: function () {
                        return console.info('对象函数 className,filePath:renderer/components/Common/Loading.vue'), 'loading-'.concat(this.size);
                    },
                    loadingStyle: function () {
                        return console.info('对象函数 loadingStyle,filePath:renderer/components/Common/Loading.vue'), {
                            marginTop: this.marginTop,
                            marginBottom: this.marginBottom
                        };
                    }
                }
            }, i = a, s = (r('f761'), r('2877')), c = Object(s.a)(i, o, n, false, null, '92d727e8', null);
            t.a = c.exports;
        },
        c63e: function (e, t) {
            e.exports = 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFAAAABQCAMAAAC5zwKfAAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAAA8UExURUdwTP/DL//DLv/BL//DLv/EL//DL//DLv/DL//CLv/DL//DL//CLf/DL//DL//DL//DLv/DL//DMv/DMGSQIxsAAAATdFJOUwDwcSTeYM1AwICojww0SLNSmhsrwQ8LAAABI0lEQVRYw+3X2a6DIBCAYbaBYXXh/d/1aE3UxtbjMhdtOv+l6BeiiYAQ5+tzLwhK2oGKjTW1Vn/HyQV8NzlzF8HRkfVV10BX38Ygg18FptICKB+70OAWDD4GNPIMaJentyAuv4l8FKx7IIjYdB7a3CdBArplWFoMUYHTiQhcZdDTgqt3yyCDdgTlkBmy1iLeBIcJ7Q6fB2txzpGCYwz+HuhWAR4BcR98LhwAU6vGlXIDaruZexBwAJy35dN2WtadNX++iESbiK8BDRYyULWXT0AvwTsxyCCDnwJaUhAjaCrQBFWSuNsESoytFiRpYzqVxc/kh0Mipaemj2tDHE62iWKCh7daDDLI4CeDhRoUPXSWFHysASpIUnAsK6QFp+Pjf3f8AVRMjNs7xw9TAAAAAElFTkSuQmCC';
        },
        c7cd: function (e, t, r) {
            'use strict';
            var o = r('23e7'), n = r('857a'), a = r('af03');
            o({
                target: 'String',
                proto: true,
                forced: a('fixed')
            }, {
                fixed: function () {
                    return n(this, 'tt', '', '');
                }
            });
        },
        c9da: function (e, t, r) {
            'use strict';
            r.r(t);
            r('b0c0');
            var o = function () {
                var e = this, t = e._self._c;
                return t('div', { staticClass: 'page-wrapper' }, [
                    t('div', { staticClass: 'personal-information-contenter' }, [e.isError ? [t('ErrorStatus', {
                        attrs: { scene: 'Personal Information' },
                        on: { 'click-refresh': e.reloadData }
                    })] : [e.isLoading ? t('Loading', { attrs: { 'margin-top': '200px' } }) : t('div', { staticClass: 'personal-information-wrapper' }, [
                        t('div', { staticClass: 'userinfo-contenter' }, [
                            t('div', { staticClass: 'avatar-wrapper' }, [t('div', { staticClass: 'avatar-image' }, [
                                t('a-avatar', {
                                    attrs: {
                                        icon: 'user',
                                        src: e.formData.avatar,
                                        size: 80
                                    }
                                }),
                                t('i', {
                                    staticClass: 'icon-change',
                                    on: { click: e.handleChangeAvatar }
                                })
                            ], 1)]),
                            t('div', { staticClass: 'userinfo-wrapper' }, [t('a-form-model', {
                                ref: 'userInfoForm',
                                attrs: {
                                    model: e.formData,
                                    rules: e.rules,
                                    colon: false
                                }
                            }, [
                                t('a-row', { attrs: { type: 'flex' } }, [
                                    t('a-col', {
                                        attrs: {
                                            span: 12,
                                            order: e.schoolIsHk ? 1 : 2
                                        }
                                    }, [t('a-form-model-item', {
                                        class: [
                                            'field-label',
                                            e.schoolIsHk ? 'mr10' : ''
                                        ],
                                        attrs: {
                                            prop: 'lastName',
                                            label: e.$t('account.personalInformation.studentLastName')
                                        }
                                    }, [t('a-input', {
                                        attrs: {
                                            'allow-clear': '',
                                            placeholder: e.$t('account.personalInformation.enterLastName')
                                        },
                                        model: {
                                            value: e.formData.lastName,
                                            callback: function (t) {
                                                e.$set(e.formData, 'lastName', t);
                                            },
                                            expression: 'formData.lastName'
                                        }
                                    })], 1)], 1),
                                    t('a-col', {
                                        attrs: {
                                            span: 12,
                                            order: e.schoolIsHk ? 2 : 1
                                        }
                                    }, [t('a-form-model-item', {
                                        class: [
                                            'field-label',
                                            e.schoolIsHk ? '' : 'mr10'
                                        ],
                                        attrs: {
                                            prop: 'firstName',
                                            label: e.$t('account.personalInformation.studentFirstName')
                                        }
                                    }, [t('a-input', {
                                        attrs: {
                                            'allow-clear': '',
                                            placeholder: e.$t('account.personalInformation.enterFirstName')
                                        },
                                        model: {
                                            value: e.formData.firstName,
                                            callback: function (t) {
                                                e.$set(e.formData, 'firstName', t);
                                            },
                                            expression: 'formData.firstName'
                                        }
                                    })], 1)], 1)
                                ], 1),
                                t('a-form-model-item', {
                                    staticClass: 'field-label field-nickname',
                                    attrs: {
                                        prop: 'nickName',
                                        required: false,
                                        label: e.$t('account.personalInformation.displayName')
                                    }
                                }, [
                                    t('a-input', {
                                        staticClass: 'input-person-nick',
                                        attrs: {
                                            'allow-clear': '',
                                            placeholder: e.$t('account.personalInformation.displayNamePlaceholder')
                                        },
                                        on: {
                                            blur: e.setNickBlur,
                                            focus: function () {
                                                return e.hasFocus = true;
                                            }
                                        },
                                        model: {
                                            value: e.formData.nickName,
                                            callback: function (t) {
                                                e.$set(e.formData, 'nickName', t);
                                            },
                                            expression: 'formData.nickName'
                                        }
                                    }),
                                    t('div', {
                                        directives: [{
                                            name: 'show',
                                            rawName: 'v-show',
                                            value: e.hasFocus && !e.formData.nickName && e.nickNamePromptValue,
                                            expression: 'hasFocus && !formData.nickName && nickNamePromptValue'
                                        }],
                                        staticClass: 'set-person-nick',
                                        on: { click: e.nickNameHandler }
                                    }, [e._v(' ' + e._s(e.nickNamePromptValue) + ' ')]),
                                    e.nickErrorTip ? t('div', { staticClass: 'ant-form-explain red-marked' }, [e._v(' ' + e._s(e.nickErrorTip) + ' ')]) : t('div', { staticClass: 'nick-name-tips' }, [e._v(' ' + e._s(e.$t('account.personalInformation.displayNameUse')[0]) + ' ' + e._s(e.$t('account.personalInformation.displayNameUse')[1]) + ' ')])
                                ], 1),
                                t('a-row', [
                                    t('a-col', { attrs: { span: 12 } }, [t('a-form-model-item', {
                                        staticClass: 'field-label marRight',
                                        attrs: {
                                            prop: 'linkedAccount[0].value',
                                            label: e.$t('account.personalInformation.weChat')
                                        }
                                    }, [t('a-input', {
                                        attrs: { placeholder: e.$t('account.personalInformation.enterWeChat') },
                                        model: {
                                            value: e.formData.linkedAccount[0].value,
                                            callback: function (t) {
                                                e.$set(e.formData.linkedAccount[0], 'value', t);
                                            },
                                            expression: 'formData.linkedAccount[0].value'
                                        }
                                    })], 1)], 1),
                                    t('a-col', { attrs: { span: 12 } }, [t('a-form-model-item', {
                                        staticClass: 'field-label marLeft',
                                        attrs: {
                                            prop: 'linkedAccount[1].value',
                                            label: e.$t('account.personalInformation.whatsApp')
                                        }
                                    }, [t('a-input', {
                                        attrs: { placeholder: e.$t('account.personalInformation.enterWhatsApp') },
                                        model: {
                                            value: e.formData.linkedAccount[1].value,
                                            callback: function (t) {
                                                e.$set(e.formData.linkedAccount[1], 'value', t);
                                            },
                                            expression: 'formData.linkedAccount[1].value'
                                        }
                                    })], 1)], 1)
                                ], 1),
                                t('a-form-model-item', {
                                    staticClass: 'field-label field-nickname',
                                    attrs: {
                                        prop: 'linkedAccount[2].value',
                                        required: false,
                                        label: e.$t('account.personalInformation.line')
                                    }
                                }, [
                                    t('a-input', {
                                        attrs: { placeholder: e.$t('account.personalInformation.enterLine') },
                                        model: {
                                            value: e.formData.linkedAccount[2].value,
                                            callback: function (t) {
                                                e.$set(e.formData.linkedAccount[2], 'value', t);
                                            },
                                            expression: 'formData.linkedAccount[2].value'
                                        }
                                    }),
                                    t('div', { staticClass: 'tips' }, [e._v(' ' + e._s(e.$t('account.personalInformation.description')) + ' ')])
                                ], 1),
                                t('a-form-model-item', {
                                    staticClass: 'field-label',
                                    attrs: {
                                        prop: 'gradeId',
                                        label: e.$t('account.personalInformation.gradeTitle')
                                    }
                                }, [t('a-select', {
                                    attrs: {
                                        dropdownClassName: 'dropdown-grade-select',
                                        placeholder: e.$t('account.personalInformation.select'),
                                        suffixIcon: e.suffixIcon
                                    },
                                    scopedSlots: e._u([{
                                        key: 'suffixIcon',
                                        fn: function () {
                                            return [t('a-icon', { attrs: { component: e.arrowBottomSvg } })];
                                        },
                                        proxy: true
                                    }]),
                                    model: {
                                        value: e.formData.gradeId,
                                        callback: function (t) {
                                            e.$set(e.formData, 'gradeId', t);
                                        },
                                        expression: 'formData.gradeId'
                                    }
                                }, e._l(e.gradeList, function (r, o) {
                                    return t('a-select-option', {
                                        key: o,
                                        attrs: { value: r.value }
                                    }, [e._v(' ' + e._s(r.name) + ' ')]);
                                }), 1)], 1)
                            ], 1)], 1)
                        ]),
                        t('div', { staticClass: 'userinfo-footer' }, [
                            t('div', {
                                staticClass: 'goback',
                                on: { click: e.handleBack }
                            }, [
                                t('a-icon', { attrs: { type: 'caret-left' } }),
                                e._v(' ' + e._s(e.$t('account.personalInformation.backToCourses')) + ' ')
                            ], 1),
                            t('div', { staticClass: 'button-group' }, [t('a-button', {
                                attrs: {
                                    size: 'large',
                                    type: 'primary',
                                    shape: 'round',
                                    loading: e.isSubmit
                                },
                                on: { click: e.handleSave }
                            }, [e._v(' ' + e._s(e.$t('account.personalInformation.save')) + ' ')])], 1)
                        ])
                    ])]], 2),
                    t('UploadAvatar', { ref: 'UploadAvatar' })
                ], 1);
            }, n = [], a = r('c7eb'), i = r('1da1'), s = (r('14d9'), r('ff07')), c = r.n(s), l = r('bd12'), h = r('aaf0'), u = (r('c7cd'), function () {
                var e = this, t = e._self._c;
                return t('a-modal', {
                    attrs: {
                        width: 370,
                        maskClosable: false,
                        closable: false,
                        centered: true,
                        keyboard: false,
                        footer: null,
                        dialogClass: 'modal-simple modal-upload-avatar'
                    },
                    model: {
                        value: e.visible,
                        callback: function (t) {
                            e.visible = t;
                        },
                        expression: 'visible'
                    }
                }, [t('div', { staticClass: 'upload-avatar-contenter' }, [
                    t('div', { staticClass: 'upload-avatar-wrapper' }, [
                        t('div', { staticClass: 'upload-title' }, [e._v(' ' + e._s(e.$t('account.personalInformation.uploadAvatarTitle')) + ' ')]),
                        t('div', { staticClass: 'upload-contenter' }, [t('vueCropper', {
                            ref: 'cropper',
                            attrs: {
                                img: e.options.img,
                                'auto-crop-width': e.options.autoCropWidth,
                                'auto-crop-height': e.options.autoCropWidth,
                                'output-type': e.options.outputType,
                                info: e.options.info,
                                full: e.options.full,
                                'can-move': e.options.canMove,
                                'can-move-box': e.options.canMoveBox,
                                original: e.options.original,
                                'auto-crop': e.options.autoCrop,
                                fixed: e.options.fixed,
                                'fixed-number': e.options.fixedNumber,
                                'center-box': e.options.centerBox,
                                'info-true': e.options.infoTrue,
                                'fixed-box': e.options.fixedBox,
                                mode: e.options.mode
                            },
                            on: { realTime: e.handleRealTime }
                        })], 1),
                        t('div', { staticClass: 'upload-operation' }, [
                            t('div', {
                                staticClass: 'icon icon-minus',
                                on: { click: e.handleMinus }
                            }),
                            t('div', {
                                staticClass: 'icon icon-plus',
                                on: { click: e.handlePlus }
                            }),
                            t('div', {
                                staticClass: 'icon icon-reload',
                                on: { click: e.handleReload }
                            })
                        ]),
                        t('div', { staticClass: 'button-upload-wrapper' }, [t('a-upload', {
                            attrs: {
                                name: 'avatar',
                                accept: e.uploadAccept,
                                showUploadList: false,
                                headers: e.headers,
                                customRequest: function () {
                                },
                                beforeUpload: e.beforeUpload
                            },
                            on: { change: e.handleChange }
                        }, [t('a-button', {
                            staticClass: 'button-upload',
                            attrs: {
                                type: 'default',
                                size: 'large',
                                shape: 'round'
                            }
                        }, [e._v(' ' + e._s(e.$t('common.reUpload')) + ' ')])], 1)], 1)
                    ]),
                    t('div', { staticClass: 'avatar-preview-wrapper' }, [
                        t('div', { staticClass: 'avatar-wrapper' }, [t('div', { staticClass: 'avatar-image' }, [
                            t('div', {
                                staticClass: 'image-wrapper',
                                style: e.previewStyle
                            }, [t('img', {
                                staticStyle: { 'max-width': 'none' },
                                style: e.previews.img,
                                attrs: { src: e.previews.url }
                            })]),
                            t('div', { staticClass: 'avatar-title' }, [e._v(' ' + e._s(e.$t('common.preview')) + ' ')])
                        ])]),
                        t('div', { staticClass: 'buttons' }, [
                            t('a-button', {
                                attrs: {
                                    type: 'default',
                                    size: 'large',
                                    shape: 'round'
                                },
                                on: { click: e.handleCancel }
                            }, [e._v(' ' + e._s(e.$t('common.cancel')) + ' ')]),
                            t('a-button', {
                                attrs: {
                                    type: 'primary',
                                    size: 'large',
                                    shape: 'round',
                                    loading: e.isLoading
                                },
                                on: { click: e.handleSave }
                            }, [e._v(' ' + e._s(e.$t('common.save')) + ' ')])
                        ], 1)
                    ])
                ])]);
            }), p = [], f = r('7e79'), d = r('02fc'), m = r('bc8a'), v = {
                components: { VueCropper: f.VueCropper },
                data: function () {
                    return {
                        visible: false,
                        callback: null,
                        isLoading: false,
                        previews: {},
                        previewStyle: {},
                        filename: '',
                        uploadAccept: '.jpg,.jpeg,.png',
                        imgSize: 2,
                        options: {
                            img: '',
                            info: true,
                            outputSize: 1,
                            outputType: 'jpeg',
                            canScale: false,
                            canMove: true,
                            autoCrop: true,
                            autoCropWidth: 150,
                            autoCropHeight: 150,
                            fixedBox: false,
                            fixed: true,
                            fixedNumber: [
                                1,
                                1
                            ],
                            full: false,
                            canMoveBox: true,
                            original: false,
                            centerBox: false,
                            infoTrue: false,
                            mode: 'cover'
                        }
                    };
                },
                mounted: function () {
                },
                methods: {
                    showModal: function (e) {
                        var t = e.avatar, r = e.callback;
                        console.info('对象函数 showModal(avatar, callback)', t, r, 'filePath:renderer/components/PersonalInformation/UploadAvatar.vue');
                        this.visible = true;
                        this.options.img = t;
                        this.filename = t;
                        this.callback = r;
                        this.$refs.cropper && this.$refs.cropper.refresh();
                    },
                    handleCancel: function () {
                        console.info('对象函数 handleCancel,filePath:renderer/components/PersonalInformation/UploadAvatar.vue');
                        this.visible = false;
                        this.$refs.cropper.refresh();
                    },
                    handleSave: function () {
                        var e = this;
                        console.info('对象函数 handleSave,filePath:renderer/components/PersonalInformation/UploadAvatar.vue');
                        this.$refs.cropper.getCropBlob(function () {
                            var t = Object(i.a)(Object(a.a)().mark(function t(r) {
                                var o, n, i, s;
                                return Object(a.a)().wrap(function (t) {
                                    while (1) {
                                        switch (t.prev = t.next) {
                                            case 0:
                                                return console.info('箭头函数 getCropBlob(data)', r, 'filePath:renderer/components/PersonalInformation/UploadAvatar.vue'), t.next = 3, Object(d.f)();
                                            case 3:
                                                return o = t.sent, n = new FormData(), n.append('file', r, e.filename), n.append('schoolCode', o), e.isLoading = true, t.next = 10, Object(m.i)(n);
                                            case 10:
                                                if (i = t.sent, e.isLoading = false, i && 0 == i.code) {
                                                    t.next = 16;
                                                    break;
                                                }
                                                return console.info('if(!res || res.code != 0)为true触发return,path: /renderer/components/PersonalInformation/UploadAvatar.vue'), e.$Message.error('Save failed, Please try again'), t.abrupt('return');
                                            case 16:
                                                s = i.data || '', e.visible = false, e.$refs.cropper.refresh(), e.callback && e.callback(s);
                                            case 20:
                                            case 'end':
                                                return t.stop();
                                        }
                                    }
                                }, t);
                            }));
                            return function (e) {
                                return t.apply(this, arguments);
                            };
                        }());
                    },
                    handleMinus: function () {
                        console.info('对象函数 handleMinus,filePath:renderer/components/PersonalInformation/UploadAvatar.vue');
                        this.$refs.cropper.changeScale(-1);
                    },
                    handlePlus: function () {
                        console.info('对象函数 handlePlus,filePath:renderer/components/PersonalInformation/UploadAvatar.vue');
                        this.$refs.cropper.changeScale(1);
                    },
                    handleReload: function () {
                        console.info('对象函数 handleReload,filePath:renderer/components/PersonalInformation/UploadAvatar.vue');
                        this.$refs.cropper.refresh();
                    },
                    beforeUpload: function (e) {
                        console.info('对象函数 beforeUpload(file)', e, 'filePath:renderer/components/PersonalInformation/UploadAvatar.vue');
                        var t = e.size / 1024 / 1024 <= this.imgSize;
                        return t || this.$Message.error('File is too large. Maximum upload file size is 2MB.'), t;
                    },
                    handleChange: function (e) {
                        var t = this;
                        console.info('对象函数 handleChange(info)', e, 'filePath:renderer/components/PersonalInformation/UploadAvatar.vue');
                        var r = e.file;
                        if (r.originFileObj) {
                            var o = new FileReader();
                            o.readAsDataURL(r.originFileObj);
                            o.onload = function () {
                                t.filename = r.name;
                                t.options.img = o.result;
                            };
                        } else {
                            console.info('if(!file.originFileObj)为true触发return,path: /renderer/components/PersonalInformation/UploadAvatar.vue');
                        }
                    },
                    handleRealTime: function (e) {
                        console.info('对象函数 handleRealTime(data)', e, 'filePath:renderer/components/PersonalInformation/UploadAvatar.vue');
                        this.previewStyle = {
                            width: e.w + 'px',
                            height: e.h + 'px',
                            overflow: 'hidden',
                            margin: '0',
                            zoom: 80 / e.h
                        };
                        this.previews = e;
                    }
                }
            }, g = v, b = (r('56b7'), r('2877')), w = Object(b.a)(g, u, p, false, null, '08725f6b', null), x = w.exports, C = r('ae3f'), y = r('7bd1'), A = r('620c'), k = {
                name: 'PersonalInformation',
                components: {
                    Loading: l.a,
                    ErrorStatus: h.a,
                    UploadAvatar: x
                },
                data: function () {
                    return {
                        schoolIsHk: false,
                        arrowBottomSvg: c.a,
                        isLoading: false,
                        isError: false,
                        isSubmit: false,
                        userInfo: {},
                        formData: {
                            avatar: '',
                            nickName: '',
                            firstName: '',
                            lastName: '',
                            gradeId: '',
                            linkedAccount: [
                                {
                                    type: '0',
                                    name: 'WeChat',
                                    value: ''
                                },
                                {
                                    type: '1',
                                    name: 'WhatsApp',
                                    value: ''
                                },
                                {
                                    type: '2',
                                    name: 'Line',
                                    value: ''
                                }
                            ]
                        },
                        emailDisabled: false,
                        gradeList: [],
                        rules: {}
                    };
                },
                mixins: [A.a],
                mounted: function () {
                    var e = this;
                    return Object(i.a)(Object(a.a)().mark(function t() {
                        return Object(a.a)().wrap(function (t) {
                            while (1) {
                                switch (t.prev = t.next) {
                                    case 0:
                                        return t.next = 2, Object(d.a)();
                                    case 2:
                                        return e.schoolIsHk = t.sent, e.queryUserInfo(), e.queryGradeList(), e.updateHeaderAttr(), t.next = 8, Object(y.a)();
                                    case 8:
                                        e.rules = t.sent;
                                    case 9:
                                    case 'end':
                                        return t.stop();
                                }
                            }
                        }, t);
                    }))();
                },
                methods: {
                    handleBack: function () {
                        console.info('对象函数 handleBack,filePath:renderer/views/PersonalInformation.vue');
                        this.$router.push('/courses');
                    },
                    updateHeaderAttr: function () {
                        console.info('对象函数 updateHeaderAttr,filePath:renderer/views/PersonalInformation.vue');
                        this.$bus.$emit('updateHeaderAttr', {
                            title: this.$t('account.personalInformation.title'),
                            showGoback: true,
                            backUrl: '/courses'
                        });
                    },
                    reloadData: function () {
                        console.info('对象函数 reloadData,filePath:renderer/views/PersonalInformation.vue');
                        this.isError = false;
                        this.queryUserInfo();
                        this.queryGradeList();
                    },
                    handleSave: function () {
                        var e = this;
                        console.info('对象函数 handleSave,filePath:renderer/views/PersonalInformation.vue');
                        this.$refs.userInfoForm.validate(function (t) {
                            return console.info('箭头函数 validate(valid)', t, 'filePath:renderer/views/PersonalInformation.vue'), t ? e.validateNickName() ? void e.modifyUserInfo(function () {
                                console.info('箭头函数 modifyUserInfo,filePath:renderer/views/PersonalInformation.vue');
                                !e.emailDisabled && e.formData.email && (e.emailDisabled = true);
                                e.$bus.$emit('update-userinfo');
                                e.$Message.success(e.$t('common.savedSuccessfully'));
                            }) : (console.info('if(!_this2.validateNickName())为true触发return,path: /renderer/views/PersonalInformation.vue'), false) : (console.info('if(!valid)为true触发return,path: /renderer/views/PersonalInformation.vue'), false);
                        });
                    },
                    handleChangeAvatar: function () {
                        var e = this;
                        console.info('对象函数 handleChangeAvatar,filePath:renderer/views/PersonalInformation.vue');
                        this.$refs.UploadAvatar.showModal({
                            avatar: this.formData.avatar,
                            callback: function (t) {
                                e.formData.avatar = t;
                            }
                        });
                    },
                    handleEditEmail: function () {
                        console.info('对象函数 handleEditEmail,filePath:renderer/views/PersonalInformation.vue');
                        this.emailDisabled = false;
                    },
                    queryUserInfo: function () {
                        var e = this;
                        return Object(i.a)(Object(a.a)().mark(function t() {
                            var r, o;
                            return Object(a.a)().wrap(function (t) {
                                while (1) {
                                    switch (t.prev = t.next) {
                                        case 0:
                                            return console.info('对象函数 queryUserInfo,filePath:renderer/views/PersonalInformation.vue'), e.isLoading = true, t.next = 4, Object(C.g)(e.formData);
                                        case 4:
                                            if (r = t.sent, e.isLoading = false, r && 0 == r.code) {
                                                t.next = 10;
                                                break;
                                            }
                                            return console.info('if(!res || res.code != 0)为true触发return,path: /renderer/views/PersonalInformation.vue'), e.isError = true, t.abrupt('return');
                                        case 10:
                                            o = r.data || {}, e.userInfo = o, e.formData.avatar = o.avatar || '', e.formData.firstName = o.firstName || '', e.formData.lastName = o.lastName || '', e.formData.nickName = o.nickNameModified ? o.nickName : '', e.formData.gradeId = o.gradeId || void 0, e.formData.linkedAccount = o.linkedAccount || [], e.emailDisabled = !!o.email;
                                        case 19:
                                        case 'end':
                                            return t.stop();
                                    }
                                }
                            }, t);
                        }))();
                    },
                    modifyUserInfo: function (e) {
                        var t = this;
                        return Object(i.a)(Object(a.a)().mark(function r() {
                            var o;
                            return Object(a.a)().wrap(function (r) {
                                while (1) {
                                    switch (r.prev = r.next) {
                                        case 0:
                                            return console.info('对象函数 modifyUserInfo(callback)', e, 'filePath:renderer/views/PersonalInformation.vue'), t.isSubmit = true, r.next = 4, Object(C.f)(t.formData);
                                        case 4:
                                            if (o = r.sent, t.isSubmit = false, o && 0 == o.code) {
                                                r.next = 10;
                                                break;
                                            }
                                            return console.info('if(!res || res.code != 0)为true触发return,path: /renderer/views/PersonalInformation.vue'), t.$Message.error(o && o.msg || t.$t('common.saveFailedTryAgain')), r.abrupt('return');
                                        case 10:
                                            e && e();
                                        case 11:
                                        case 'end':
                                            return r.stop();
                                    }
                                }
                            }, r);
                        }))();
                    }
                }
            }, I = k, O = (r('de46'), Object(b.a)(I, o, n, false, null, '4b860e20', null));
            t.default = O.exports;
        },
        cc4e: function (e, t, r) {
        },
        dc2d: function (e, t, r) {
            'use strict';
            r('17c8');
        },
        de46: function (e, t, r) {
            'use strict';
            r('fbc7');
        },
        ebc2: function (e, t, r) {
        },
        f761: function (e, t, r) {
            'use strict';
            r('ebc2');
        },
        fbc7: function (e, t, r) {
        },
        ff07: function (e, t) {
            e.exports = {
                functional: true,
                render(e, t) {
                    const {
                        _c: r,
                        _v: o,
                        data: n,
                        children: a = []
                    } = t, {
                        class: i,
                        staticClass: s,
                        style: c,
                        staticStyle: l,
                        attrs: h = {},
                        ...u
                    } = n;
                    return r('svg', {
                        class: [
                            'icon',
                            i,
                            s
                        ],
                        style: [
                            c,
                            l
                        ],
                        attrs: Object.assign({
                            viewBox: '0 0 1024 1024',
                            xmlns: 'http://www.w3.org/2000/svg',
                            width: '128',
                            height: '128'
                        }, h),
                        ...u
                    }, a.concat([
                        r('defs'),
                        r('path', { attrs: { d: 'M464.6 736C346 613.3 227.3 490.5 108.8 367.8c-48.9-50.5 30.5-125.9 79.5-75.1C293.9 401.9 399.4 511.2 505 620.3 614.2 510.6 723.6 400.8 832.8 291c49.7-50 129.1 25.4 79.5 75.2C789.6 489.5 666.9 612.7 544.2 736c-20.4 20.4-59.4 20.9-79.6 0z' } })
                    ]));
                }
            };
        }
    }
]);