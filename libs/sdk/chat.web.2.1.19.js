! function (t, e) {
    "object" == typeof exports && "undefined" != typeof module ? module.exports = e() : "function" == typeof define && define.amd ? define(e) : (t = t || self).ChatClient = e()
}(this, function () {
    "use strict";
    var p = "undefined" != typeof globalThis ? globalThis : "undefined" != typeof window ? window : "undefined" != typeof global ? global : "undefined" != typeof self ? self : {};

    function to() {
        throw new Error("Dynamic requires are not currently supported by rollup-plugin-commonjs")
    }

    function t(t, e) {
        return t(e = {
            exports: {}
        }, e.exports), e.exports
    }

    function e(t) {
        return t && t.Math == Math && t
    }

    function F(t) {
        try {
            return !!t()
        } catch (t) {
            return !0
        }
    }

    function n(t) {
        return _.call(t).slice(8, -1)
    }

    function h(t) {
        if (null == t) throw TypeError("Can't call method on " + t);
        return t
    }

    function c(t) {
        return v(h(t))
    }

    function f(t, e) {
        if (!C(t)) return t;
        var r, o;
        if (e && "function" == typeof (r = t.toString) && !C(o = r.call(t))) return o;
        if ("function" == typeof (r = t.valueOf) && !C(o = r.call(t))) return o;
        if (!e && "function" == typeof (r = t.toString) && !C(o = r.call(t))) return o;
        throw TypeError("Can't convert object to primitive value")
    }

    function i(t) {
        return M ? S.createElement(t) : {}
    }

    function d(e, r) {
        try {
            q(j, e, r)
        } catch (t) {
            j[e] = r
        }
        return r
    }

    function a(t) {
        return "Symbol(" + String(void 0 === t ? "" : t) + ")_" + (++U + G).toString(36)
    }

    function r(t) {
        return H[t] || (H[t] = a(t))
    }
    var o, s, u, m = "object",
        j = e(typeof globalThis == m && globalThis) || e(typeof window == m && window) || e(typeof self == m && self) || e(typeof p == m && p) || Function("return this")(),
        A = !F(function () {
            return 7 != Object.defineProperty({}, "a", {
                get: function () {
                    return 7
                }
            }).a
        }),
        l = {}.propertyIsEnumerable,
        g = Object.getOwnPropertyDescriptor,
        y = {
            f: g && !l.call({
                1: 2
            }, 1) ? function (t) {
                var e = g(this, t);
                return !!e && e.enumerable
            } : l
        },
        P = function (t, e) {
            return {
                enumerable: !(1 & t),
                configurable: !(2 & t),
                writable: !(4 & t),
                value: e
            }
        },
        _ = {}.toString,
        R = "".split,
        v = F(function () {
            return !Object("z").propertyIsEnumerable(0)
        }) ? function (t) {
            return "String" == n(t) ? R.call(t, "") : Object(t)
        } : Object,
        C = function (t) {
            return "object" == typeof t ? null !== t : "function" == typeof t
        },
        w = {}.hasOwnProperty,
        k = function (t, e) {
            return w.call(t, e)
        },
        S = j.document,
        M = C(S) && C(S.createElement),
        b = !A && !F(function () {
            return 7 != Object.defineProperty(i("div"), "a", {
                get: function () {
                    return 7
                }
            }).a
        }),
        I = Object.getOwnPropertyDescriptor,
        L = {
            f: A ? I : function (t, e) {
                if (t = c(t), e = f(e, !0), b) try {
                    return I(t, e)
                } catch (t) { }
                if (k(t, e)) return P(!y.f.call(t, e), t[e])
            }
        },
        B = function (t) {
            if (!C(t)) throw TypeError(String(t) + " is not an object");
            return t
        },
        T = Object.defineProperty,
        x = {
            f: A ? T : function (t, e, r) {
                if (B(t), e = f(e, !0), B(r), b) try {
                    return T(t, e, r)
                } catch (t) { }
                if ("get" in r || "set" in r) throw TypeError("Accessors not supported");
                return "value" in r && (t[e] = r.value), t
            }
        },
        q = A ? function (t, e, r) {
            return x.f(t, e, P(1, r))
        } : function (t, e, r) {
            return t[e] = r, t
        },
        O = t(function (t) {
            var e = "__core-js_shared__",
                r = j[e] || d(e, {});
            (t.exports = function (t, e) {
                return r[t] || (r[t] = void 0 !== e ? e : {})
            })("versions", []).push({
                version: "3.2.1",
                mode: "global",
                copyright: "© 2019 Denis Pushkarev (zloirock.ru)"
            })
        }),
        D = O("native-function-to-string", Function.toString),
        E = j.WeakMap,
        N = "function" == typeof E && /native code/.test(D.call(E)),
        U = 0,
        G = Math.random(),
        H = O("keys"),
        V = {},
        K = j.WeakMap;
    if (N) {
        var Y = new K,
            W = Y.get,
            J = Y.has,
            z = Y.set;
        o = function (t, e) {
            return z.call(Y, t, e), e
        }, s = function (t) {
            return W.call(Y, t) || {}
        }, u = function (t) {
            return J.call(Y, t)
        }
    } else {
        var Z = r("state");
        V[Z] = !0, o = function (t, e) {
            return q(t, Z, e), e
        }, s = function (t) {
            return k(t, Z) ? t[Z] : {}
        }, u = function (t) {
            return k(t, Z)
        }
    }

    function $(t) {
        return "function" == typeof t ? t : void 0
    }

    function X(t, e) {
        return arguments.length < 2 ? $(ht[t]) || $(j[t]) : ht[t] && ht[t][e] || j[t] && j[t][e]
    }

    function Q(t) {
        return isNaN(t = +t) ? 0 : (0 < t ? dt : pt)(t)
    }

    function tt(t) {
        return 0 < t ? mt(Q(t), 9007199254740991) : 0
    }

    function et(t, e) {
        var r = Q(t);
        return r < 0 ? lt(r + e, 0) : gt(r, e)
    }

    function rt(a) {
        return function (t, e, r) {
            var o, n = c(t),
                i = tt(n.length),
                s = et(r, i);
            if (a && e != e) {
                for (; s < i;)
                    if ((o = n[s++]) != o) return !0
            } else
                for (; s < i; s++)
                    if ((a || s in n) && n[s] === e) return a || s || 0;
            return !a && -1
        }
    }

    function ot(t, e) {
        var r, o = c(t),
            n = 0,
            i = [];
        for (r in o) !k(V, r) && k(o, r) && i.push(r);
        for (; e.length > n;) k(o, r = e[n++]) && (~_t(i, r) || i.push(r));
        return i
    }

    function nt(t, e) {
        for (var r = Mt(e), o = x.f, n = L.f, i = 0; i < r.length; i++) {
            var s = r[i];
            k(t, s) || o(t, s, n(e, s))
        }
    }

    function it(t, e) {
        var r = Bt[It(t)];
        return r == Ot || r != Tt && ("function" == typeof e ? F(e) : !!e)
    }

    function st(t, e) {
        var r, o, n, i, s, a = t.target,
            u = t.global,
            c = t.stat;
        if (r = u ? j : c ? j[a] || d(a, {}) : (j[a] || {}).prototype)
            for (o in e) {
                if (i = e[o], n = t.noTargetGet ? (s = Pt(r, o)) && s.value : r[o], !Dt(u ? o : a + (c ? "." : "#") + o, t.forced) && void 0 !== n) {
                    if (typeof i == typeof n) continue;
                    nt(i, n)
                } (t.sham || n && n.sham) && q(i, "sham", !0), ft(r, o, i, t)
            }
    }

    function at(t) {
        return Object(h(t))
    }

    function ut() { }
    var ct = {
        set: o,
        get: s,
        has: u,
        enforce: function (t) {
            return u(t) ? s(t) : o(t, {})
        },
        getterFor: function (r) {
            return function (t) {
                var e;
                if (!C(t) || (e = s(t)).type !== r) throw TypeError("Incompatible receiver, " + r + " required");
                return e
            }
        }
    },
        ft = t(function (t) {
            var e = ct.get,
                a = ct.enforce,
                u = String(D).split("toString");
            O("inspectSource", function (t) {
                return D.call(t)
            }), (t.exports = function (t, e, r, o) {
                var n = !!o && !!o.unsafe,
                    i = !!o && !!o.enumerable,
                    s = !!o && !!o.noTargetGet;
                "function" == typeof r && ("string" != typeof e || k(r, "name") || q(r, "name", e), a(r).source = u.join("string" == typeof e ? e : "")), t !== j ? (n ? !s && t[e] && (i = !0) : delete t[e], i ? t[e] = r : q(t, e, r)) : i ? t[e] = r : d(e, r)
            })(Function.prototype, "toString", function () {
                return "function" == typeof this && e(this).source || D.call(this)
            })
        }),
        ht = j,
        pt = Math.ceil,
        dt = Math.floor,
        mt = Math.min,
        lt = Math.max,
        gt = Math.min,
        yt = {
            includes: rt(!0),
            indexOf: rt(!1)
        },
        _t = yt.indexOf,
        Rt = ["constructor", "hasOwnProperty", "isPrototypeOf", "propertyIsEnumerable", "toLocaleString", "toString", "valueOf"],
        vt = Rt.concat("length", "prototype"),
        wt = {
            f: Object.getOwnPropertyNames || function (t) {
                return ot(t, vt)
            }
        },
        St = {
            f: Object.getOwnPropertySymbols
        },
        Mt = X("Reflect", "ownKeys") || function (t) {
            var e = wt.f(B(t)),
                r = St.f;
            return r ? e.concat(r(t)) : e
        },
        bt = /#|\.prototype\./,
        It = it.normalize = function (t) {
            return String(t).replace(bt, ".").toLowerCase()
        },
        Bt = it.data = {},
        Tt = it.NATIVE = "N",
        Ot = it.POLYFILL = "P",
        Dt = it,
        Pt = L.f,
        Ct = !!Object.getOwnPropertySymbols && !F(function () {
            return !String(Symbol())
        }),
        kt = Array.isArray || function (t) {
            return "Array" == n(t)
        },
        Lt = Object.keys || function (t) {
            return ot(t, Rt)
        },
        Et = A ? Object.defineProperties : function (t, e) {
            B(t);
            for (var r, o = Lt(e), n = o.length, i = 0; i < n;) x.f(t, r = o[i++], e[r]);
            return t
        },
        Nt = X("document", "documentElement"),
        Ut = r("IE_PROTO"),
        Gt = "prototype",
        Ft = function () {
            var t, e = i("iframe"),
                r = Rt.length,
                o = "script";
            for (e.style.display = "none", Nt.appendChild(e), e.src = String("javascript:"), (t = e.contentWindow.document).open(), t.write("<script>document.F=Object</" + o + ">"), t.close(), Ft = t.F; r--;) delete Ft[Gt][Rt[r]];
            return Ft()
        },
        jt = Object.create || function (t, e) {
            var r;
            return null !== t ? (ut[Gt] = B(t), r = new ut, ut[Gt] = null, r[Ut] = t) : r = Ft(), void 0 === e ? r : Et(r, e)
        };
    V[Ut] = !0;

    function At(t) {
        return re[t] || (re[t] = Ct && ee[t] || (Ct ? ee : a)("Symbol." + t))
    }

    function xt(t) {
        var e = ht.Symbol || (ht.Symbol = {});
        k(e, t) || ne(e, t, {
            value: oe.f(t)
        })
    }

    function qt(t, e, r) {
        t && !k(t = r ? t : t.prototype, se) && ie(t, se, {
            configurable: !0,
            value: e
        })
    }

    function Ht(t) {
        if ("function" != typeof t) throw TypeError(String(t) + " is not a function");
        return t
    }

    function Vt(o, n, t) {
        if (Ht(o), void 0 === n) return o;
        switch (t) {
            case 0:
                return function () {
                    return o.call(n)
                };
            case 1:
                return function (t) {
                    return o.call(n, t)
                };
            case 2:
                return function (t, e) {
                    return o.call(n, t, e)
                };
            case 3:
                return function (t, e, r) {
                    return o.call(n, t, e, r)
                }
        }
        return function () {
            return o.apply(n, arguments)
        }
    }

    function Kt(t, e) {
        var r;
        return kt(t) && ("function" != typeof (r = t.constructor) || r !== Array && !kt(r.prototype) ? C(r) && null === (r = r[ae]) && (r = void 0) : r = void 0), new (void 0 === r ? Array : r)(0 === e ? 0 : e)
    }

    function Yt(d) {
        var m = 1 == d,
            l = 2 == d,
            g = 3 == d,
            y = 4 == d,
            _ = 6 == d,
            R = 5 == d || _;
        return function (t, e, r, o) {
            for (var n, i, s = at(t), a = v(s), u = Vt(e, r, 3), c = tt(a.length), f = 0, h = o || Kt, p = m ? h(t, c) : l ? h(t, 0) : void 0; f < c; f++)
                if ((R || f in a) && (i = u(n = a[f], f, s), d))
                    if (m) p[f] = i;
                    else if (i) switch (d) {
                        case 3:
                            return !0;
                        case 5:
                            return n;
                        case 6:
                            return f;
                        case 2:
                            ue.call(p, n)
                    } else if (y) return !1;
            return _ ? -1 : g || y ? y : p
        }
    }

    function Wt(t, e) {
        var r = Ie[t] = jt(_e[de]);
        return le(r, {
            type: pe,
            tag: t,
            description: e
        }), A || (r.description = e), r
    }

    function Jt(e, t) {
        B(e);
        var r = c(t),
            o = Lt(r).concat(Ue(r));
        return fe(o, function (t) {
            A && !Ne.call(r, t) || Ee(e, t, r[t])
        }), e
    }

    function zt(t, e) {
        var r = c(t),
            o = f(e, !0);
        if (r !== ye || !k(Ie, o) || k(Be, o)) {
            var n = we(r, o);
            return !n || !k(Ie, o) || k(r, he) && r[he][o] || (n.enumerable = !0), n
        }
    }

    function Zt(t) {
        var e = Me(c(t)),
            r = [];
        return fe(e, function (t) {
            k(Ie, t) || k(V, t) || r.push(t)
        }), r
    }
    var $t = wt.f,
        Xt = {}.toString,
        Qt = "object" == typeof window && window && Object.getOwnPropertyNames ? Object.getOwnPropertyNames(window) : [],
        te = {
            f: function (t) {
                return Qt && "[object Window]" == Xt.call(t) ? function (t) {
                    try {
                        return $t(t)
                    } catch (t) {
                        return Qt.slice()
                    }
                }(t) : $t(c(t))
            }
        },
        ee = j.Symbol,
        re = O("wks"),
        oe = {
            f: At
        },
        ne = x.f,
        ie = x.f,
        se = At("toStringTag"),
        ae = At("species"),
        ue = [].push,
        ce = {
            forEach: Yt(0),
            map: Yt(1),
            filter: Yt(2),
            some: Yt(3),
            every: Yt(4),
            find: Yt(5),
            findIndex: Yt(6)
        },
        fe = ce.forEach,
        he = r("hidden"),
        pe = "Symbol",
        de = "prototype",
        me = At("toPrimitive"),
        le = ct.set,
        ge = ct.getterFor(pe),
        ye = Object[de],
        _e = j.Symbol,
        Re = j.JSON,
        ve = Re && Re.stringify,
        we = L.f,
        Se = x.f,
        Me = te.f,
        be = y.f,
        Ie = O("symbols"),
        Be = O("op-symbols"),
        Te = O("string-to-symbol-registry"),
        Oe = O("symbol-to-string-registry"),
        De = O("wks"),
        Pe = j.QObject,
        Ce = !Pe || !Pe[de] || !Pe[de].findChild,
        ke = A && F(function () {
            return 7 != jt(Se({}, "a", {
                get: function () {
                    return Se(this, "a", {
                        value: 7
                    }).a
                }
            })).a
        }) ? function (t, e, r) {
            var o = we(ye, e);
            o && delete ye[e], Se(t, e, r), o && t !== ye && Se(ye, e, o)
        } : Se,
        Le = Ct && "symbol" == typeof _e.iterator ? function (t) {
            return "symbol" == typeof t
        } : function (t) {
            return Object(t) instanceof _e
        },
        Ee = function (t, e, r) {
            t === ye && Ee(Be, e, r), B(t);
            var o = f(e, !0);
            return B(r), k(Ie, o) ? (r.enumerable ? (k(t, he) && t[he][o] && (t[he][o] = !1), r = jt(r, {
                enumerable: P(0, !1)
            })) : (k(t, he) || Se(t, he, P(1, {})), t[he][o] = !0), ke(t, o, r)) : Se(t, o, r)
        },
        Ne = function (t) {
            var e = f(t, !0),
                r = be.call(this, e);
            return !(this === ye && k(Ie, e) && !k(Be, e)) && (!(r || !k(this, e) || !k(Ie, e) || k(this, he) && this[he][e]) || r)
        },
        Ue = function (t) {
            var e = t === ye,
                r = Me(e ? Be : c(t)),
                o = [];
            return fe(r, function (t) {
                !k(Ie, t) || e && !k(ye, t) || o.push(Ie[t])
            }), o
        };
    Ct || (ft((_e = function (t) {
        if (this instanceof _e) throw TypeError("Symbol is not a constructor");
        var e = arguments.length && void 0 !== t ? String(t) : void 0,
            r = a(e),
            o = function (t) {
                this === ye && o.call(Be, t), k(this, he) && k(this[he], r) && (this[he][r] = !1), ke(this, r, P(1, t))
            };
        return A && Ce && ke(ye, r, {
            configurable: !0,
            set: o
        }), Wt(r, e)
    })[de], "toString", function () {
        return ge(this).tag
    }), y.f = Ne, x.f = Ee, L.f = zt, wt.f = te.f = Zt, St.f = Ue, A && (Se(_e[de], "description", {
        configurable: !0,
        get: function () {
            return ge(this).description
        }
    }), ft(ye, "propertyIsEnumerable", Ne, {
        unsafe: !0
    })), oe.f = function (t) {
        return Wt(At(t), t)
    }), st({
        global: !0,
        wrap: !0,
        forced: !Ct,
        sham: !Ct
    }, {
        Symbol: _e
    }), fe(Lt(De), function (t) {
        xt(t)
    }), st({
        target: pe,
        stat: !0,
        forced: !Ct
    }, {
        for: function (t) {
            var e = String(t);
            if (k(Te, e)) return Te[e];
            var r = _e(e);
            return Te[e] = r, Oe[r] = e, r
        },
        keyFor: function (t) {
            if (!Le(t)) throw TypeError(t + " is not a symbol");
            if (k(Oe, t)) return Oe[t]
        },
        useSetter: function () {
            Ce = !0
        },
        useSimple: function () {
            Ce = !1
        }
    }), st({
        target: "Object",
        stat: !0,
        forced: !Ct,
        sham: !A
    }, {
        create: function (t, e) {
            return void 0 === e ? jt(t) : Jt(jt(t), e)
        },
        defineProperty: Ee,
        defineProperties: Jt,
        getOwnPropertyDescriptor: zt
    }), st({
        target: "Object",
        stat: !0,
        forced: !Ct
    }, {
        getOwnPropertyNames: Zt,
        getOwnPropertySymbols: Ue
    }), st({
        target: "Object",
        stat: !0,
        forced: F(function () {
            St.f(1)
        })
    }, {
        getOwnPropertySymbols: function (t) {
            return St.f(at(t))
        }
    }), Re && st({
        target: "JSON",
        stat: !0,
        forced: !Ct || F(function () {
            var t = _e();
            return "[null]" != ve([t]) || "{}" != ve({
                a: t
            }) || "{}" != ve(Object(t))
        })
    }, {
        stringify: function (t) {
            for (var e, r, o = [t], n = 1; n < arguments.length;) o.push(arguments[n++]);
            if (r = e = o[1], (C(e) || void 0 !== t) && !Le(t)) return kt(e) || (e = function (t, e) {
                if ("function" == typeof r && (e = r.call(this, t, e)), !Le(e)) return e
            }), o[1] = e, ve.apply(Re, o)
        }
    }), _e[de][me] || q(_e[de], me, _e[de].valueOf), qt(_e, pe), V[he] = !0, xt("asyncIterator");
    var Ge = x.f,
        Fe = j.Symbol;
    if (!(!A || "function" != typeof Fe || "description" in Fe.prototype && void 0 === Fe().description)) {
        var je = {},
            Ae = function (t) {
                var e = arguments.length < 1 || void 0 === t ? void 0 : String(t),
                    r = this instanceof Ae ? new Fe(e) : void 0 === e ? Fe() : Fe(e);
                return "" === e && (je[r] = !0), r
            };
        nt(Ae, Fe);
        var xe = Ae.prototype = Fe.prototype;
        xe.constructor = Ae;
        var qe = xe.toString,
            He = "Symbol(test)" == String(Fe("test")),
            Ve = /^Symbol\((.*)\)[^)]+$/;
        Ge(xe, "description", {
            configurable: !0,
            get: function () {
                var t = C(this) ? this.valueOf() : this,
                    e = qe.call(t);
                if (k(je, t)) return "";
                var r = He ? e.slice(7, -1) : e.replace(Ve, "$1");
                return "" === r ? void 0 : r
            }
        }), st({
            global: !0,
            forced: !0
        }, {
            Symbol: Ae
        })
    }
    xt("hasInstance"), xt("isConcatSpreadable"), xt("iterator"), xt("match"), xt("matchAll"), xt("replace"), xt("search"), xt("species"), xt("split"), xt("toPrimitive"), xt("toStringTag"), xt("unscopables");
    var Ke = Object.assign,
        Ye = !Ke || F(function () {
            var t = {},
                e = {},
                r = Symbol(),
                o = "abcdefghijklmnopqrst";
            return t[r] = 7, o.split("").forEach(function (t) {
                e[t] = t
            }), 7 != Ke({}, t)[r] || Lt(Ke({}, e)).join("") != o
        }) ? function (t, e) {
            for (var r = at(t), o = arguments.length, n = 1, i = St.f, s = y.f; n < o;)
                for (var a, u = v(arguments[n++]), c = i ? Lt(u).concat(i(u)) : Lt(u), f = c.length, h = 0; h < f;) a = c[h++], A && !s.call(u, a) || (r[a] = u[a]);
            return r
        } : Ke;
    st({
        target: "Object",
        stat: !0,
        forced: Object.assign !== Ye
    }, {
        assign: Ye
    }), st({
        target: "Object",
        stat: !0,
        sham: !A
    }, {
        create: jt
    }), st({
        target: "Object",
        stat: !0,
        forced: !A,
        sham: !A
    }, {
        defineProperty: x.f
    }), st({
        target: "Object",
        stat: !0,
        forced: !A,
        sham: !A
    }, {
        defineProperties: Et
    });

    function We(a) {
        return function (t) {
            for (var e, r = c(t), o = Lt(r), n = o.length, i = 0, s = []; i < n;) e = o[i++], A && !Je.call(r, e) || s.push(a ? [e, r[e]] : r[e]);
            return s
        }
    }
    var Je = y.f,
        ze = {
            entries: We(!0),
            values: We(!1)
        },
        Ze = ze.entries;
    st({
        target: "Object",
        stat: !0
    }, {
        entries: function (t) {
            return Ze(t)
        }
    });
    var $e = !F(function () {
        return Object.isExtensible(Object.preventExtensions({}))
    }),
        Xe = t(function (t) {
            function r(t) {
                e(t, o, {
                    value: {
                        objectID: "O" + ++n,
                        weakData: {}
                    }
                })
            }
            var e = x.f,
                o = a("meta"),
                n = 0,
                i = Object.isExtensible || function () {
                    return !0
                },
                s = t.exports = {
                    REQUIRED: !1,
                    fastKey: function (t, e) {
                        if (!C(t)) return "symbol" == typeof t ? t : ("string" == typeof t ? "S" : "P") + t;
                        if (!k(t, o)) {
                            if (!i(t)) return "F";
                            if (!e) return "E";
                            r(t)
                        }
                        return t[o].objectID
                    },
                    getWeakData: function (t, e) {
                        if (!k(t, o)) {
                            if (!i(t)) return !0;
                            if (!e) return !1;
                            r(t)
                        }
                        return t[o].weakData
                    },
                    onFreeze: function (t) {
                        return $e && s.REQUIRED && i(t) && !k(t, o) && r(t), t
                    }
                };
            V[o] = !0
        }),
        Qe = (Xe.REQUIRED, Xe.fastKey, Xe.getWeakData, Xe.onFreeze, Xe.onFreeze),
        tr = Object.freeze,
        er = F(function () {
            tr(1)
        });
    st({
        target: "Object",
        stat: !0,
        forced: er,
        sham: !$e
    }, {
        freeze: function (t) {
            return tr && C(t) ? tr(Qe(t)) : t
        }
    });

    function rr(t) {
        return void 0 !== t && (ar.Array === t || cr[ur] === t)
    }

    function or(t) {
        var e, r, o;
        return void 0 === t ? "Undefined" : null === t ? "Null" : "string" == typeof (r = function (t, e) {
            try {
                return t[e]
            } catch (t) { }
        }(e = Object(t), fr)) ? r : hr ? n(e) : "Object" == (o = n(e)) && "function" == typeof e.callee ? "Arguments" : o
    }

    function nr(t) {
        if (null != t) return t[pr] || t["@@iterator"] || ar[or(t)]
    }

    function ir(e, t, r, o) {
        try {
            return o ? t(B(r)[0], r[1]) : t(r)
        } catch (t) {
            var n = e.return;
            throw void 0 !== n && B(n.call(e)), t
        }
    }

    function sr(t, e, r) {
        var o = f(e);
        o in t ? x.f(t, o, P(0, r)) : t[o] = r
    }
    var ar = {},
        ur = At("iterator"),
        cr = Array.prototype,
        fr = At("toStringTag"),
        hr = "Arguments" == n(function () {
            return arguments
        }()),
        pr = At("iterator"),
        dr = t(function (t) {
            function p(t, e) {
                this.stopped = t, this.result = e
            } (t.exports = function (t, e, r, o, n) {
                var i, s, a, u, c, f, h = Vt(e, r, o ? 2 : 1);
                if (n) i = t;
                else {
                    if ("function" != typeof (s = nr(t))) throw TypeError("Target is not iterable");
                    if (rr(s)) {
                        for (a = 0, u = tt(t.length); a < u; a++)
                            if ((c = o ? h(B(f = t[a])[0], f[1]) : h(t[a])) && c instanceof p) return c;
                        return new p(!1)
                    }
                    i = s.call(t)
                }
                for (; !(f = i.next()).done;)
                    if ((c = ir(i, h, f.value, o)) && c instanceof p) return c;
                return new p(!1)
            }).stop = function (t) {
                return new p(!0, t)
            }
        });
    st({
        target: "Object",
        stat: !0
    }, {
        fromEntries: function (t) {
            var r = {};
            return dr(t, function (t, e) {
                sr(r, t, e)
            }, void 0, !0), r
        }
    });
    var mr = L.f,
        lr = F(function () {
            mr(1)
        });
    st({
        target: "Object",
        stat: !0,
        forced: !A || lr,
        sham: !A
    }, {
        getOwnPropertyDescriptor: function (t, e) {
            return mr(c(t), e)
        }
    }), st({
        target: "Object",
        stat: !0,
        sham: !A
    }, {
        getOwnPropertyDescriptors: function (t) {
            for (var e, r, o = c(t), n = L.f, i = Mt(o), s = {}, a = 0; i.length > a;) void 0 !== (r = n(o, e = i[a++])) && sr(s, e, r);
            return s
        }
    });
    var gr = te.f,
        yr = F(function () {
            return !Object.getOwnPropertyNames(1)
        });
    st({
        target: "Object",
        stat: !0,
        forced: yr
    }, {
        getOwnPropertyNames: gr
    });
    var _r = !F(function () {
        function t() { }
        return t.prototype.constructor = null, Object.getPrototypeOf(new t) !== t.prototype
    }),
        Rr = r("IE_PROTO"),
        vr = Object.prototype,
        wr = _r ? Object.getPrototypeOf : function (t) {
            return t = at(t), k(t, Rr) ? t[Rr] : "function" == typeof t.constructor && t instanceof t.constructor ? t.constructor.prototype : t instanceof Object ? vr : null
        },
        Sr = F(function () {
            wr(1)
        });
    st({
        target: "Object",
        stat: !0,
        forced: Sr,
        sham: !_r
    }, {
        getPrototypeOf: function (t) {
            return wr(at(t))
        }
    });
    var Mr = Object.is || function (t, e) {
        return t === e ? 0 !== t || 1 / t == 1 / e : t != t && e != e
    };
    st({
        target: "Object",
        stat: !0
    }, {
        is: Mr
    });
    var br = Object.isExtensible,
        Ir = F(function () {
            br(1)
        });
    st({
        target: "Object",
        stat: !0,
        forced: Ir
    }, {
        isExtensible: function (t) {
            return !!C(t) && (!br || br(t))
        }
    });
    var Br = Object.isFrozen,
        Tr = F(function () {
            Br(1)
        });
    st({
        target: "Object",
        stat: !0,
        forced: Tr
    }, {
        isFrozen: function (t) {
            return !C(t) || !!Br && Br(t)
        }
    });
    var Or = Object.isSealed,
        Dr = F(function () {
            Or(1)
        });
    st({
        target: "Object",
        stat: !0,
        forced: Dr
    }, {
        isSealed: function (t) {
            return !C(t) || !!Or && Or(t)
        }
    });
    var Pr = F(function () {
        Lt(1)
    });
    st({
        target: "Object",
        stat: !0,
        forced: Pr
    }, {
        keys: function (t) {
            return Lt(at(t))
        }
    });
    var Cr = Xe.onFreeze,
        kr = Object.preventExtensions,
        Lr = F(function () {
            kr(1)
        });
    st({
        target: "Object",
        stat: !0,
        forced: Lr,
        sham: !$e
    }, {
        preventExtensions: function (t) {
            return kr && C(t) ? kr(Cr(t)) : t
        }
    });
    var Er = Xe.onFreeze,
        Nr = Object.seal,
        Ur = F(function () {
            Nr(1)
        });
    st({
        target: "Object",
        stat: !0,
        forced: Ur,
        sham: !$e
    }, {
        seal: function (t) {
            return Nr && C(t) ? Nr(Er(t)) : t
        }
    });

    function Gr(t) {
        if (!C(t) && null !== t) throw TypeError("Can't set " + String(t) + " as a prototype");
        return t
    }
    var Fr = Object.setPrototypeOf || ("__proto__" in {} ? function () {
        var r, o = !1,
            t = {};
        try {
            (r = Object.getOwnPropertyDescriptor(Object.prototype, "__proto__").set).call(t, []), o = t instanceof Array
        } catch (t) { }
        return function (t, e) {
            return B(t), Gr(e), o ? r.call(t, e) : t.__proto__ = e, t
        }
    }() : void 0);
    st({
        target: "Object",
        stat: !0
    }, {
        setPrototypeOf: Fr
    });
    var jr = ze.values;
    st({
        target: "Object",
        stat: !0
    }, {
        values: function (t) {
            return jr(t)
        }
    });
    var Ar = {};
    Ar[At("toStringTag")] = "z";
    var xr = "[object z]" !== String(Ar) ? function () {
        return "[object " + or(this) + "]"
    } : Ar.toString,
        qr = Object.prototype;
    xr !== qr.toString && ft(qr, "toString", xr, {
        unsafe: !0
    });
    var Hr = !F(function () {
        var t = Math.random();
        __defineSetter__.call(null, t, function () { }), delete j[t]
    });
    A && st({
        target: "Object",
        proto: !0,
        forced: Hr
    }, {
        __defineGetter__: function (t, e) {
            x.f(at(this), t, {
                get: Ht(e),
                enumerable: !0,
                configurable: !0
            })
        }
    }), A && st({
        target: "Object",
        proto: !0,
        forced: Hr
    }, {
        __defineSetter__: function (t, e) {
            x.f(at(this), t, {
                set: Ht(e),
                enumerable: !0,
                configurable: !0
            })
        }
    });
    var Vr = L.f;
    A && st({
        target: "Object",
        proto: !0,
        forced: Hr
    }, {
        __lookupGetter__: function (t) {
            var e, r = at(this),
                o = f(t, !0);
            do {
                if (e = Vr(r, o)) return e.get
            } while (r = wr(r))
        }
    });
    var Kr = L.f;
    A && st({
        target: "Object",
        proto: !0,
        forced: Hr
    }, {
        __lookupSetter__: function (t) {
            var e, r = at(this),
                o = f(t, !0);
            do {
                if (e = Kr(r, o)) return e.set
            } while (r = wr(r))
        }
    });
    var Yr = [].slice,
        Wr = {},
        Jr = Function.bind || function (e) {
            var r = Ht(this),
                o = Yr.call(arguments, 1),
                n = function () {
                    var t = o.concat(Yr.call(arguments));
                    return this instanceof n ? function (t, e, r) {
                        if (!(e in Wr)) {
                            for (var o = [], n = 0; n < e; n++) o[n] = "a[" + n + "]";
                            Wr[e] = Function("C,a", "return new C(" + o.join(",") + ")")
                        }
                        return Wr[e](t, r)
                    }(r, t.length, t) : r.apply(e, t)
                };
            return C(r.prototype) && (n.prototype = r.prototype), n
        };
    st({
        target: "Function",
        proto: !0
    }, {
        bind: Jr
    });
    var zr = x.f,
        Zr = Function.prototype,
        $r = Zr.toString,
        Xr = /^\s*function ([^ (]*)/;
    !A || "name" in Zr || zr(Zr, "name", {
        configurable: !0,
        get: function () {
            try {
                return $r.call(this).match(Xr)[1]
            } catch (t) {
                return ""
            }
        }
    });
    var Qr = At("hasInstance"),
        eo = Function.prototype;
    Qr in eo || x.f(eo, Qr, {
        value: function (t) {
            if ("function" != typeof this || !C(t)) return !1;
            if (!C(this.prototype)) return t instanceof this;
            for (; t = wr(t);)
                if (this.prototype === t) return !0;
            return !1
        }
    });

    function ro(t, e, r) {
        var o, n, i, s, a = at(t),
            u = "function" == typeof this ? this : Array,
            c = arguments.length,
            f = 1 < c ? e : void 0,
            h = void 0 !== f,
            p = 0,
            d = nr(a);
        if (h && (f = Vt(f, 2 < c ? r : void 0, 2)), null == d || u == Array && rr(d))
            for (n = new u(o = tt(a.length)); p < o; p++) sr(n, p, h ? f(a[p], p) : a[p]);
        else
            for (s = d.call(a), n = new u; !(i = s.next()).done; p++) sr(n, p, h ? ir(s, f, [i.value, p], !0) : i.value);
        return n.length = p, n
    }
    var oo = At("iterator"),
        no = !1;
    try {
        var io = 0,
            so = {
                next: function () {
                    return {
                        done: !!io++
                    }
                },
                return: function () {
                    no = !0
                }
            };
        so[oo] = function () {
            return this
        }, Array.from(so, function () {
            throw 2
        })
    } catch (t) { }

    function ao(t, e) {
        if (!e && !no) return !1;
        var r = !1;
        try {
            var o = {};
            o[oo] = function () {
                return {
                    next: function () {
                        return {
                            done: r = !0
                        }
                    }
                }
            }, t(o)
        } catch (t) { }
        return r
    }
    var uo = !ao(function (t) {
        Array.from(t)
    });
    st({
        target: "Array",
        stat: !0,
        forced: uo
    }, {
        from: ro
    }), st({
        target: "Array",
        stat: !0
    }, {
        isArray: kt
    });
    var co = F(function () {
        function t() { }
        return !(Array.of.call(t) instanceof t)
    });
    st({
        target: "Array",
        stat: !0,
        forced: co
    }, {
        of: function () {
            for (var t = 0, e = arguments.length, r = new ("function" == typeof this ? this : Array)(e); t < e;) sr(r, t, arguments[t++]);
            return r.length = e, r
        }
    });

    function fo(e) {
        return !F(function () {
            var t = [];
            return (t.constructor = {})[po] = function () {
                return {
                    foo: 1
                }
            }, 1 !== t[e](Boolean).foo
        })
    }

    function ho(t) {
        if (!C(t)) return !1;
        var e = t[mo];
        return void 0 !== e ? !!e : kt(t)
    }
    var po = At("species"),
        mo = At("isConcatSpreadable"),
        lo = 9007199254740991,
        go = "Maximum allowed index exceeded",
        yo = !F(function () {
            var t = [];
            return t[mo] = !1, t.concat()[0] !== t
        }),
        _o = fo("concat");
    st({
        target: "Array",
        proto: !0,
        forced: !yo || !_o
    }, {
        concat: function (t) {
            var e, r, o, n, i, s = at(this),
                a = Kt(s, 0),
                u = 0;
            for (e = -1, o = arguments.length; e < o; e++)
                if (ho(i = -1 === e ? s : arguments[e])) {
                    if (n = tt(i.length), lo < u + n) throw TypeError(go);
                    for (r = 0; r < n; r++, u++) r in i && sr(a, u, i[r])
                } else {
                    if (lo <= u) throw TypeError(go);
                    sr(a, u++, i)
                }
            return a.length = u, a
        }
    });
    var Ro = Math.min,
        vo = [].copyWithin || function (t, e, r) {
            var o = at(this),
                n = tt(o.length),
                i = et(t, n),
                s = et(e, n),
                a = 2 < arguments.length ? r : void 0,
                u = Ro((void 0 === a ? n : et(a, n)) - s, n - i),
                c = 1;
            for (s < i && i < s + u && (c = -1, s += u - 1, i += u - 1); 0 < u--;) s in o ? o[i] = o[s] : delete o[i], i += c, s += c;
            return o
        },
        wo = At("unscopables"),
        So = Array.prototype;
    null == So[wo] && q(So, wo, jt(null));

    function Mo(t) {
        So[wo][t] = !0
    }
    st({
        target: "Array",
        proto: !0
    }, {
        copyWithin: vo
    }), Mo("copyWithin");

    function bo(t, e) {
        var r = [][t];
        return !r || !F(function () {
            r.call(null, e || function () {
                throw 1
            }, 1)
        })
    }
    var Io = ce.every;
    st({
        target: "Array",
        proto: !0,
        forced: bo("every")
    }, {
        every: function (t, e) {
            return Io(this, t, 1 < arguments.length ? e : void 0)
        }
    });

    function Bo(t, e, r) {
        for (var o = at(this), n = tt(o.length), i = arguments.length, s = et(1 < i ? e : void 0, n), a = 2 < i ? r : void 0, u = void 0 === a ? n : et(a, n); s < u;) o[s++] = t;
        return o
    }
    st({
        target: "Array",
        proto: !0
    }, {
        fill: Bo
    }), Mo("fill");
    var To = ce.filter;
    st({
        target: "Array",
        proto: !0,
        forced: !fo("filter")
    }, {
        filter: function (t, e) {
            return To(this, t, 1 < arguments.length ? e : void 0)
        }
    });
    var Oo = ce.find,
        Do = "find",
        Po = !0;
    Do in [] && Array(1)[Do](function () {
        Po = !1
    }), st({
        target: "Array",
        proto: !0,
        forced: Po
    }, {
        find: function (t, e) {
            return Oo(this, t, 1 < arguments.length ? e : void 0)
        }
    }), Mo(Do);
    var Co = ce.findIndex,
        ko = "findIndex",
        Lo = !0;
    ko in [] && Array(1)[ko](function () {
        Lo = !1
    }), st({
        target: "Array",
        proto: !0,
        forced: Lo
    }, {
        findIndex: function (t, e) {
            return Co(this, t, 1 < arguments.length ? e : void 0)
        }
    }), Mo(ko);
    var Eo = function (t, e, r, o, n, i, s, a) {
        for (var u, c = n, f = 0, h = !!s && Vt(s, a, 3); f < o;) {
            if (f in r) {
                if (u = h ? h(r[f], f, e) : r[f], 0 < i && kt(u)) c = Eo(t, e, u, tt(u.length), c, i - 1) - 1;
                else {
                    if (9007199254740991 <= c) throw TypeError("Exceed the acceptable array length");
                    t[c] = u
                }
                c++
            }
            f++
        }
        return c
    },
        No = Eo;
    st({
        target: "Array",
        proto: !0
    }, {
        flat: function (t) {
            var e = arguments.length ? t : void 0,
                r = at(this),
                o = tt(r.length),
                n = Kt(r, 0);
            return n.length = No(n, r, r, o, 0, void 0 === e ? 1 : Q(e)), n
        }
    }), st({
        target: "Array",
        proto: !0
    }, {
        flatMap: function (t, e) {
            var r, o = at(this),
                n = tt(o.length);
            return Ht(t), (r = Kt(o, 0)).length = No(r, o, o, n, 0, 1, t, 1 < arguments.length ? e : void 0), r
        }
    });
    var Uo = ce.forEach,
        Go = bo("forEach") ? function (t, e) {
            return Uo(this, t, 1 < arguments.length ? e : void 0)
        } : [].forEach;
    st({
        target: "Array",
        proto: !0,
        forced: [].forEach != Go
    }, {
        forEach: Go
    });
    var Fo = yt.includes;
    st({
        target: "Array",
        proto: !0
    }, {
        includes: function (t, e) {
            return Fo(this, t, 1 < arguments.length ? e : void 0)
        }
    }), Mo("includes");
    var jo = yt.indexOf,
        Ao = [].indexOf,
        xo = !!Ao && 1 / [1].indexOf(1, -0) < 0,
        qo = bo("indexOf");
    st({
        target: "Array",
        proto: !0,
        forced: xo || qo
    }, {
        indexOf: function (t, e) {
            return xo ? Ao.apply(this, arguments) || 0 : jo(this, t, 1 < arguments.length ? e : void 0)
        }
    });
    var Ho = [].join,
        Vo = v != Object,
        Ko = bo("join", ",");
    st({
        target: "Array",
        proto: !0,
        forced: Vo || Ko
    }, {
        join: function (t) {
            return Ho.call(c(this), void 0 === t ? "," : t)
        }
    });
    var Yo = Math.min,
        Wo = [].lastIndexOf,
        Jo = !!Wo && 1 / [1].lastIndexOf(1, -0) < 0,
        zo = bo("lastIndexOf"),
        Zo = Jo || zo ? function (t, e) {
            if (Jo) return Wo.apply(this, arguments) || 0;
            var r = c(this),
                o = tt(r.length),
                n = o - 1;
            for (1 < arguments.length && (n = Yo(n, Q(e))), n < 0 && (n = o + n); 0 <= n; n--)
                if (n in r && r[n] === t) return n || 0;
            return -1
        } : Wo;
    st({
        target: "Array",
        proto: !0,
        forced: Zo !== [].lastIndexOf
    }, {
        lastIndexOf: Zo
    });
    var $o = ce.map;
    st({
        target: "Array",
        proto: !0,
        forced: !fo("map")
    }, {
        map: function (t, e) {
            return $o(this, t, 1 < arguments.length ? e : void 0)
        }
    });

    function Xo(c) {
        return function (t, e, r, o) {
            Ht(e);
            var n = at(t),
                i = v(n),
                s = tt(n.length),
                a = c ? s - 1 : 0,
                u = c ? -1 : 1;
            if (r < 2)
                for (; ;) {
                    if (a in i) {
                        o = i[a], a += u;
                        break
                    }
                    if (a += u, c ? a < 0 : s <= a) throw TypeError("Reduce of empty array with no initial value")
                }
            for (; c ? 0 <= a : a < s; a += u) a in i && (o = e(o, i[a], a, n));
            return o
        }
    }
    var Qo = {
        left: Xo(!1),
        right: Xo(!0)
    },
        tn = Qo.left;
    st({
        target: "Array",
        proto: !0,
        forced: bo("reduce")
    }, {
        reduce: function (t, e) {
            return tn(this, t, arguments.length, 1 < arguments.length ? e : void 0)
        }
    });
    var en = Qo.right;
    st({
        target: "Array",
        proto: !0,
        forced: bo("reduceRight")
    }, {
        reduceRight: function (t, e) {
            return en(this, t, arguments.length, 1 < arguments.length ? e : void 0)
        }
    });
    var rn = [].reverse,
        on = [1, 2];
    st({
        target: "Array",
        proto: !0,
        forced: String(on) === String(on.reverse())
    }, {
        reverse: function () {
            return kt(this) && (this.length = this.length), rn.call(this)
        }
    });
    var nn = At("species"),
        sn = [].slice,
        an = Math.max;
    st({
        target: "Array",
        proto: !0,
        forced: !fo("slice")
    }, {
        slice: function (t, e) {
            var r, o, n, i = c(this),
                s = tt(i.length),
                a = et(t, s),
                u = et(void 0 === e ? s : e, s);
            if (kt(i) && ("function" != typeof (r = i.constructor) || r !== Array && !kt(r.prototype) ? C(r) && null === (r = r[nn]) && (r = void 0) : r = void 0, r === Array || void 0 === r)) return sn.call(i, a, u);
            for (o = new (void 0 === r ? Array : r)(an(u - a, 0)), n = 0; a < u; a++, n++) a in i && sr(o, n, i[a]);
            return o.length = n, o
        }
    });
    var un = ce.some;
    st({
        target: "Array",
        proto: !0,
        forced: bo("some")
    }, {
        some: function (t, e) {
            return un(this, t, 1 < arguments.length ? e : void 0)
        }
    });
    var cn = [].sort,
        fn = [1, 2, 3],
        hn = F(function () {
            fn.sort(void 0)
        }),
        pn = F(function () {
            fn.sort(null)
        }),
        dn = bo("sort");
    st({
        target: "Array",
        proto: !0,
        forced: hn || !pn || dn
    }, {
        sort: function (t) {
            return void 0 === t ? cn.call(at(this)) : cn.call(at(this), Ht(t))
        }
    });
    var mn = Math.max,
        ln = Math.min;
    st({
        target: "Array",
        proto: !0,
        forced: !fo("splice")
    }, {
        splice: function (t, e) {
            var r, o, n, i, s, a, u = at(this),
                c = tt(u.length),
                f = et(t, c),
                h = arguments.length;
            if (0 === h ? r = o = 0 : o = 1 === h ? (r = 0, c - f) : (r = h - 2, ln(mn(Q(e), 0), c - f)), 9007199254740991 < c + r - o) throw TypeError("Maximum allowed length exceeded");
            for (n = Kt(u, o), i = 0; i < o; i++)(s = f + i) in u && sr(n, i, u[s]);
            if (r < (n.length = o)) {
                for (i = f; i < c - o; i++) a = i + r, (s = i + o) in u ? u[a] = u[s] : delete u[a];
                for (i = c; c - o + r < i; i--) delete u[i - 1]
            } else if (o < r)
                for (i = c - o; f < i; i--) a = i + r - 1, (s = i + o - 1) in u ? u[a] = u[s] : delete u[a];
            for (i = 0; i < r; i++) u[i + f] = arguments[i + 2];
            return u.length = c - o + r, n
        }
    });

    function gn(t) {
        var e = X(t),
            r = x.f;
        A && e && !e[yn] && r(e, yn, {
            configurable: !0,
            get: function () {
                return this
            }
        })
    }
    var yn = At("species");
    gn("Array"), Mo("flat"), Mo("flatMap");
    var _n, Rn, vn, wn = At("iterator"),
        Sn = !1;
    [].keys && ("next" in (vn = [].keys()) ? (Rn = wr(wr(vn))) !== Object.prototype && (_n = Rn) : Sn = !0), null == _n && (_n = {}), k(_n, wn) || q(_n, wn, function () {
        return this
    });

    function Mn() {
        return this
    }

    function bn(t, e, r) {
        var o = e + " Iterator";
        return t.prototype = jt(On, {
            next: P(1, r)
        }), qt(t, o, !1), ar[o] = Mn, t
    }

    function In() {
        return this
    }

    function Bn(t, e, r, o, n, i, s) {
        function a(t) {
            if (t === n && l) return l;
            if (!Pn && t in d) return d[t];
            switch (t) {
                case "keys":
                case kn:
                case Ln:
                    return function () {
                        return new r(this, t)
                    }
            }
            return function () {
                return new r(this)
            }
        }
        bn(r, e, o);
        var u, c, f, h = e + " Iterator",
            p = !1,
            d = t.prototype,
            m = d[Cn] || d["@@iterator"] || n && d[n],
            l = !Pn && m || a(n),
            g = "Array" == e && d.entries || m;
        if (g && (u = wr(g.call(new t)), Dn !== Object.prototype && u.next && (wr(u) !== Dn && (Fr ? Fr(u, Dn) : "function" != typeof u[Cn] && q(u, Cn, In)), qt(u, h, !0))), n == kn && m && m.name !== kn && (p = !0, l = function () {
            return m.call(this)
        }), d[Cn] !== l && q(d, Cn, l), ar[e] = l, n)
            if (c = {
                values: a(kn),
                keys: i ? l : a("keys"),
                entries: a(Ln)
            }, s)
                for (f in c) !Pn && !p && f in d || ft(d, f, c[f]);
            else st({
                target: e,
                proto: !0,
                forced: Pn || p
            }, c);
        return c
    }
    var Tn = {
        IteratorPrototype: _n,
        BUGGY_SAFARI_ITERATORS: Sn
    },
        On = Tn.IteratorPrototype,
        Dn = Tn.IteratorPrototype,
        Pn = Tn.BUGGY_SAFARI_ITERATORS,
        Cn = At("iterator"),
        kn = "values",
        Ln = "entries",
        En = "Array Iterator",
        Nn = ct.set,
        Un = ct.getterFor(En),
        Gn = Bn(Array, "Array", function (t, e) {
            Nn(this, {
                type: En,
                target: c(t),
                index: 0,
                kind: e
            })
        }, function () {
            var t = Un(this),
                e = t.target,
                r = t.kind,
                o = t.index++;
            return !e || o >= e.length ? {
                value: t.target = void 0,
                done: !0
            } : "keys" == r ? {
                value: o,
                done: !1
            } : "values" == r ? {
                value: e[o],
                done: !1
            } : {
                value: [o, e[o]],
                done: !1
            }
        }, "values");
    ar.Arguments = ar.Array, Mo("keys"), Mo("values"), Mo("entries");
    var Fn = String.fromCharCode,
        jn = String.fromCodePoint,
        An = !!jn && 1 != jn.length;
    st({
        target: "String",
        stat: !0,
        forced: An
    }, {
        fromCodePoint: function (t) {
            for (var e, r = [], o = arguments.length, n = 0; n < o;) {
                if (e = +arguments[n++], et(e, 1114111) !== e) throw RangeError(e + " is not a valid code point");
                r.push(e < 65536 ? Fn(e) : Fn(55296 + ((e -= 65536) >> 10), e % 1024 + 56320))
            }
            return r.join("")
        }
    }), st({
        target: "String",
        stat: !0
    }, {
        raw: function (t) {
            for (var e = c(t.raw), r = tt(e.length), o = arguments.length, n = [], i = 0; i < r;) n.push(String(e[i++])), i < o && n.push(String(arguments[i]));
            return n.join("")
        }
    });

    function xn(a) {
        return function (t, e) {
            var r, o, n = String(h(t)),
                i = Q(e),
                s = n.length;
            return i < 0 || s <= i ? a ? "" : void 0 : (r = n.charCodeAt(i)) < 55296 || 56319 < r || i + 1 === s || (o = n.charCodeAt(i + 1)) < 56320 || 57343 < o ? a ? n.charAt(i) : r : a ? n.slice(i, i + 2) : o - 56320 + (r - 55296 << 10) + 65536
        }
    }
    var qn = {
        codeAt: xn(!1),
        charAt: xn(!0)
    },
        Hn = qn.codeAt;
    st({
        target: "String",
        proto: !0
    }, {
        codePointAt: function (t) {
            return Hn(this, t)
        }
    });

    function Vn(t) {
        var e;
        return C(t) && (void 0 !== (e = t[Wn]) ? !!e : "RegExp" == n(t))
    }

    function Kn(t) {
        if (Vn(t)) throw TypeError("The method doesn't accept regular expressions");
        return t
    }

    function Yn(e) {
        var r = /./;
        try {
            "/./"[e](r)
        } catch (t) {
            try {
                return r[Jn] = !1, "/./"[e](r)
            } catch (t) { }
        }
        return !1
    }
    var Wn = At("match"),
        Jn = At("match"),
        zn = "".endsWith,
        Zn = Math.min;
    st({
        target: "String",
        proto: !0,
        forced: !Yn("endsWith")
    }, {
        endsWith: function (t, e) {
            var r = String(h(this));
            Kn(t);
            var o = 1 < arguments.length ? e : void 0,
                n = tt(r.length),
                i = void 0 === o ? n : Zn(tt(o), n),
                s = String(t);
            return zn ? zn.call(r, s, i) : r.slice(i - s.length, i) === s
        }
    }), st({
        target: "String",
        proto: !0,
        forced: !Yn("includes")
    }, {
        includes: function (t, e) {
            return !!~String(h(this)).indexOf(Kn(t), 1 < arguments.length ? e : void 0)
        }
    });

    function $n() {
        var t = B(this),
            e = "";
        return t.global && (e += "g"), t.ignoreCase && (e += "i"), t.multiline && (e += "m"), t.dotAll && (e += "s"), t.unicode && (e += "u"), t.sticky && (e += "y"), e
    }
    var Xn, Qn, ti = RegExp.prototype.exec,
        ei = String.prototype.replace,
        ri = ti,
        oi = (Xn = /a/, Qn = /b*/g, ti.call(Xn, "a"), ti.call(Qn, "a"), 0 !== Xn.lastIndex || 0 !== Qn.lastIndex),
        ni = void 0 !== /()??/.exec("")[1];
    (oi || ni) && (ri = function (t) {
        var e, r, o, n, i = this;
        return ni && (r = new RegExp("^" + i.source + "$(?!\\s)", $n.call(i))), oi && (e = i.lastIndex), o = ti.call(i, t), oi && o && (i.lastIndex = i.global ? o.index + o[0].length : e), ni && o && 1 < o.length && ei.call(o[0], r, function () {
            for (n = 1; n < arguments.length - 2; n++) void 0 === arguments[n] && (o[n] = void 0)
        }), o
    });

    function ii(r, t, e, o) {
        var n = At(r),
            i = !F(function () {
                var t = {};
                return t[n] = function () {
                    return 7
                }, 7 != ""[r](t)
            }),
            s = i && !F(function () {
                var t = !1,
                    e = /a/;
                return e.exec = function () {
                    return t = !0, null
                }, "split" === r && (e.constructor = {}, e.constructor[ci] = function () {
                    return e
                }), e[n](""), !t
            });
        if (!i || !s || "replace" === r && !fi || "split" === r && !hi) {
            var a = /./[n],
                u = e(n, ""[r], function (t, e, r, o, n) {
                    return e.exec === ui ? i && !n ? {
                        done: !0,
                        value: a.call(e, r, o)
                    } : {
                        done: !0,
                        value: t.call(r, e, o)
                    } : {
                        done: !1
                    }
                }),
                c = u[0],
                f = u[1];
            ft(String.prototype, r, c), ft(RegExp.prototype, n, 2 == t ? function (t, e) {
                return f.call(t, this, e)
            } : function (t) {
                return f.call(t, this)
            }), o && q(RegExp.prototype[n], "sham", !0)
        }
    }

    function si(t, e, r) {
        return e + (r ? pi(t, e).length : 1)
    }

    function ai(t, e) {
        var r = t.exec;
        if ("function" == typeof r) {
            var o = r.call(t, e);
            if ("object" != typeof o) throw TypeError("RegExp exec method returned something other than an Object or null");
            return o
        }
        if ("RegExp" !== n(t)) throw TypeError("RegExp#exec called on incompatible receiver");
        return ui.call(t, e)
    }
    var ui = ri,
        ci = At("species"),
        fi = !F(function () {
            var t = /./;
            return t.exec = function () {
                var t = [];
                return t.groups = {
                    a: "7"
                }, t
            }, "7" !== "".replace(t, "$<a>")
        }),
        hi = !F(function () {
            var t = /(?:)/,
                e = t.exec;
            t.exec = function () {
                return e.apply(this, arguments)
            };
            var r = "ab".split(t);
            return 2 !== r.length || "a" !== r[0] || "b" !== r[1]
        }),
        pi = qn.charAt;
    ii("match", 1, function (o, c, f) {
        return [function (t) {
            var e = h(this),
                r = null == t ? void 0 : t[o];
            return void 0 !== r ? r.call(t, e) : new RegExp(t)[o](String(e))
        }, function (t) {
            var e = f(c, t, this);
            if (e.done) return e.value;
            var r = B(t),
                o = String(this);
            if (!r.global) return ai(r, o);
            for (var n, i = r.unicode, s = [], a = r.lastIndex = 0; null !== (n = ai(r, o));) {
                var u = String(n[0]);
                "" === (s[a] = u) && (r.lastIndex = si(o, tt(r.lastIndex), i)), a++
            }
            return 0 === a ? null : s
        }]
    });

    function di(t, e) {
        var r, o = B(t).constructor;
        return void 0 === o || null == (r = B(o)[li]) ? e : Ht(r)
    }

    function mi(t) {
        var e, r, o, n, i, s, a = B(this),
            u = String(t);
        return e = di(a, RegExp), void 0 === (r = a.flags) && a instanceof RegExp && !("flags" in wi) && (r = $n.call(a)), o = void 0 === r ? "" : String(r), n = new e(e === RegExp ? a.source : a, o), i = !!~o.indexOf("g"), s = !!~o.indexOf("u"), n.lastIndex = tt(a.lastIndex), new Mi(n, u, i, s)
    }
    var li = At("species"),
        gi = At("matchAll"),
        yi = "RegExp String",
        _i = yi + " Iterator",
        Ri = ct.set,
        vi = ct.getterFor(_i),
        wi = RegExp.prototype,
        Si = wi.exec,
        Mi = bn(function (t, e, r, o) {
            Ri(this, {
                type: _i,
                regexp: t,
                string: e,
                global: r,
                unicode: o,
                done: !1
            })
        }, yi, function () {
            var t = vi(this);
            if (t.done) return {
                value: void 0,
                done: !0
            };
            var e = t.regexp,
                r = t.string,
                o = function (t, e) {
                    var r, o = t.exec;
                    if ("function" != typeof o) return Si.call(t, e);
                    if ("object" != typeof (r = o.call(t, e))) throw TypeError("Incorrect exec result");
                    return r
                }(e, r);
            return null === o ? {
                value: void 0,
                done: t.done = !0
            } : t.global ? ("" == String(o[0]) && (e.lastIndex = si(r, tt(e.lastIndex), t.unicode)), {
                value: o,
                done: !1
            }) : {
                value: o,
                done: !(t.done = !0)
            }
        });
    st({
        target: "String",
        proto: !0
    }, {
        matchAll: function (t) {
            var e, r, o = h(this);
            return null != t && null != (r = t[gi]) ? Ht(r).call(t, o) : (e = String(o), new RegExp(t, "g")[gi](e))
        }
    }), gi in wi || q(wi, gi, mi);

    function bi(c) {
        return function (t, e, r) {
            var o, n, i = String(h(t)),
                s = i.length,
                a = void 0 === r ? " " : String(r),
                u = tt(e);
            return u <= s || "" == a ? i : (o = u - s, (n = Ii.call(a, Bi(o / a.length))).length > o && (n = n.slice(0, o)), c ? i + n : n + i)
        }
    }
    var Ii = "".repeat || function (t) {
        var e = String(h(this)),
            r = "",
            o = Q(t);
        if (o < 0 || o == 1 / 0) throw RangeError("Wrong number of repetitions");
        for (; 0 < o;
            (o >>>= 1) && (e += e)) 1 & o && (r += e);
        return r
    },
        Bi = Math.ceil,
        Ti = {
            start: bi(!1),
            end: bi(!0)
        },
        Oi = X("navigator", "userAgent") || "",
        Di = /Version\/10\.\d+(\.\d+)?( Mobile\/\w+)? Safari\//.test(Oi),
        Pi = Ti.end;
    st({
        target: "String",
        proto: !0,
        forced: Di
    }, {
        padEnd: function (t, e) {
            return Pi(this, t, 1 < arguments.length ? e : void 0)
        }
    });
    var Ci = Ti.start;
    st({
        target: "String",
        proto: !0,
        forced: Di
    }, {
        padStart: function (t, e) {
            return Ci(this, t, 1 < arguments.length ? e : void 0)
        }
    }), st({
        target: "String",
        proto: !0
    }, {
        repeat: Ii
    });
    var ki = Math.max,
        Li = Math.min,
        Ei = Math.floor,
        Ni = /\$([$&'`]|\d\d?|<[^>]*>)/g,
        Ui = /\$([$&'`]|\d\d?)/g;
    ii("replace", 2, function (n, w, S) {
        return [function (t, e) {
            var r = h(this),
                o = null == t ? void 0 : t[n];
            return void 0 !== o ? o.call(t, r, e) : w.call(String(r), t, e)
        }, function (t, e) {
            var r = S(w, t, this, e);
            if (r.done) return r.value;
            var o = B(t),
                n = String(this),
                i = "function" == typeof e;
            i || (e = String(e));
            var s = o.global;
            if (s) {
                var a = o.unicode;
                o.lastIndex = 0
            }
            for (var u = []; ;) {
                var c = ai(o, n);
                if (null === c) break;
                if (u.push(c), !s) break;
                "" === String(c[0]) && (o.lastIndex = si(n, tt(o.lastIndex), a))
            }
            for (var f, h = "", p = 0, d = 0; d < u.length; d++) {
                c = u[d];
                for (var m = String(c[0]), l = ki(Li(Q(c.index), n.length), 0), g = [], y = 1; y < c.length; y++) g.push(void 0 === (f = c[y]) ? f : String(f));
                var _ = c.groups;
                if (i) {
                    var R = [m].concat(g, l, n);
                    void 0 !== _ && R.push(_);
                    var v = String(e.apply(void 0, R))
                } else v = M(m, n, l, g, _, e);
                p <= l && (h += n.slice(p, l) + v, p = l + m.length)
            }
            return h + n.slice(p)
        }];

        function M(i, s, a, u, c, t) {
            var f = a + i.length,
                h = u.length,
                e = Ui;
            return void 0 !== c && (c = at(c), e = Ni), w.call(t, e, function (t, e) {
                var r;
                switch (e.charAt(0)) {
                    case "$":
                        return "$";
                    case "&":
                        return i;
                    case "`":
                        return s.slice(0, a);
                    case "'":
                        return s.slice(f);
                    case "<":
                        r = c[e.slice(1, -1)];
                        break;
                    default:
                        var o = +e;
                        if (0 == o) return t;
                        if (h < o) {
                            var n = Ei(o / 10);
                            return 0 === n ? t : n <= h ? void 0 === u[n - 1] ? e.charAt(1) : u[n - 1] + e.charAt(1) : t
                        }
                        r = u[o - 1]
                }
                return void 0 === r ? "" : r
            })
        }
    }), ii("search", 1, function (o, s, a) {
        return [function (t) {
            var e = h(this),
                r = null == t ? void 0 : t[o];
            return void 0 !== r ? r.call(t, e) : new RegExp(t)[o](String(e))
        }, function (t) {
            var e = a(s, t, this);
            if (e.done) return e.value;
            var r = B(t),
                o = String(this),
                n = r.lastIndex;
            Mr(n, 0) || (r.lastIndex = 0);
            var i = ai(r, o);
            return Mr(r.lastIndex, n) || (r.lastIndex = n), null === i ? -1 : i.index
        }]
    });
    var Gi = [].push,
        Fi = Math.min,
        ji = 4294967295,
        Ai = !F(function () {
            return !RegExp(ji, "y")
        });
    ii("split", 2, function (n, g, y) {
        var _;
        return _ = "c" == "abbc".split(/(b)*/)[1] || 4 != "test".split(/(?:)/, -1).length || 2 != "ab".split(/(?:ab)*/).length || 4 != ".".split(/(.?)(.?)/).length || 1 < ".".split(/()()/).length || "".split(/.?/).length ? function (t, e) {
            var r = String(h(this)),
                o = void 0 === e ? ji : e >>> 0;
            if (0 == o) return [];
            if (void 0 === t) return [r];
            if (!Vn(t)) return g.call(r, t, o);
            for (var n, i, s, a = [], u = (t.ignoreCase ? "i" : "") + (t.multiline ? "m" : "") + (t.unicode ? "u" : "") + (t.sticky ? "y" : ""), c = 0, f = new RegExp(t.source, u + "g");
                (n = ui.call(f, r)) && !(c < (i = f.lastIndex) && (a.push(r.slice(c, n.index)), 1 < n.length && n.index < r.length && Gi.apply(a, n.slice(1)), s = n[0].length, c = i, a.length >= o));) f.lastIndex === n.index && f.lastIndex++;
            return c === r.length ? !s && f.test("") || a.push("") : a.push(r.slice(c)), a.length > o ? a.slice(0, o) : a
        } : "0".split(void 0, 0).length ? function (t, e) {
            return void 0 === t && 0 === e ? [] : g.call(this, t, e)
        } : g, [function (t, e) {
            var r = h(this),
                o = null == t ? void 0 : t[n];
            return void 0 !== o ? o.call(t, r, e) : _.call(String(r), t, e)
        }, function (t, e) {
            var r = y(_, t, this, e, _ !== g);
            if (r.done) return r.value;
            var o = B(t),
                n = String(this),
                i = di(o, RegExp),
                s = o.unicode,
                a = (o.ignoreCase ? "i" : "") + (o.multiline ? "m" : "") + (o.unicode ? "u" : "") + (Ai ? "y" : "g"),
                u = new i(Ai ? o : "^(?:" + o.source + ")", a),
                c = void 0 === e ? ji : e >>> 0;
            if (0 == c) return [];
            if (0 === n.length) return null === ai(u, n) ? [n] : [];
            for (var f = 0, h = 0, p = []; h < n.length;) {
                u.lastIndex = Ai ? h : 0;
                var d, m = ai(u, Ai ? n : n.slice(h));
                if (null === m || (d = Fi(tt(u.lastIndex + (Ai ? 0 : h)), n.length)) === f) h = si(n, h, s);
                else {
                    if (p.push(n.slice(f, h)), p.length === c) return p;
                    for (var l = 1; l <= m.length - 1; l++)
                        if (p.push(m[l]), p.length === c) return p;
                    h = f = d
                }
            }
            return p.push(n.slice(f)), p
        }]
    }, !Ai);
    var xi = "".startsWith,
        qi = Math.min;
    st({
        target: "String",
        proto: !0,
        forced: !Yn("startsWith")
    }, {
        startsWith: function (t, e) {
            var r = String(h(this));
            Kn(t);
            var o = tt(qi(1 < arguments.length ? e : void 0, r.length)),
                n = String(t);
            return xi ? xi.call(r, n, o) : r.slice(o, o + n.length) === n
        }
    });

    function Hi(r) {
        return function (t) {
            var e = String(h(t));
            return 1 & r && (e = e.replace(Wi, "")), 2 & r && (e = e.replace(Ji, "")), e
        }
    }

    function Vi(t) {
        return F(function () {
            return !!Ki[t]() || "​᠎" != "​᠎"[t]() || Ki[t].name !== t
        })
    }
    var Ki = "\t\n\v\f\r                　\u2028\u2029\ufeff",
        Yi = "[" + Ki + "]",
        Wi = RegExp("^" + Yi + Yi + "*"),
        Ji = RegExp(Yi + Yi + "*$"),
        zi = {
            start: Hi(1),
            end: Hi(2),
            trim: Hi(3)
        },
        Zi = zi.trim;
    st({
        target: "String",
        proto: !0,
        forced: Vi("trim")
    }, {
        trim: function () {
            return Zi(this)
        }
    });
    var $i = zi.start,
        Xi = Vi("trimStart"),
        Qi = Xi ? function () {
            return $i(this)
        } : "".trimStart;
    st({
        target: "String",
        proto: !0,
        forced: Xi
    }, {
        trimStart: Qi,
        trimLeft: Qi
    });
    var ts = zi.end,
        es = Vi("trimEnd"),
        rs = es ? function () {
            return ts(this)
        } : "".trimEnd;
    st({
        target: "String",
        proto: !0,
        forced: es
    }, {
        trimEnd: rs,
        trimRight: rs
    });
    var os = qn.charAt,
        ns = "String Iterator",
        is = ct.set,
        ss = ct.getterFor(ns);
    Bn(String, "String", function (t) {
        is(this, {
            type: ns,
            string: String(t),
            index: 0
        })
    }, function () {
        var t, e = ss(this),
            r = e.string,
            o = e.index;
        return o >= r.length ? {
            value: void 0,
            done: !0
        } : (t = os(r, o), e.index += t.length, {
            value: t,
            done: !1
        })
    });

    function as(t, e, r, o) {
        var n = String(h(t)),
            i = "<" + e;
        return "" !== r && (i += " " + r + '="' + String(o).replace(cs, "&quot;") + '"'), i + ">" + n + "</" + e + ">"
    }

    function us(e) {
        return F(function () {
            var t = ""[e]('"');
            return t !== t.toLowerCase() || 3 < t.split('"').length
        })
    }
    var cs = /"/g;
    st({
        target: "String",
        proto: !0,
        forced: us("anchor")
    }, {
        anchor: function (t) {
            return as(this, "a", "name", t)
        }
    }), st({
        target: "String",
        proto: !0,
        forced: us("big")
    }, {
        big: function () {
            return as(this, "big", "", "")
        }
    }), st({
        target: "String",
        proto: !0,
        forced: us("blink")
    }, {
        blink: function () {
            return as(this, "blink", "", "")
        }
    }), st({
        target: "String",
        proto: !0,
        forced: us("bold")
    }, {
        bold: function () {
            return as(this, "b", "", "")
        }
    }), st({
        target: "String",
        proto: !0,
        forced: us("fixed")
    }, {
        fixed: function () {
            return as(this, "tt", "", "")
        }
    }), st({
        target: "String",
        proto: !0,
        forced: us("fontcolor")
    }, {
        fontcolor: function (t) {
            return as(this, "font", "color", t)
        }
    }), st({
        target: "String",
        proto: !0,
        forced: us("fontsize")
    }, {
        fontsize: function (t) {
            return as(this, "font", "size", t)
        }
    }), st({
        target: "String",
        proto: !0,
        forced: us("italics")
    }, {
        italics: function () {
            return as(this, "i", "", "")
        }
    }), st({
        target: "String",
        proto: !0,
        forced: us("link")
    }, {
        link: function (t) {
            return as(this, "a", "href", t)
        }
    }), st({
        target: "String",
        proto: !0,
        forced: us("small")
    }, {
        small: function () {
            return as(this, "small", "", "")
        }
    }), st({
        target: "String",
        proto: !0,
        forced: us("strike")
    }, {
        strike: function () {
            return as(this, "strike", "", "")
        }
    }), st({
        target: "String",
        proto: !0,
        forced: us("sub")
    }, {
        sub: function () {
            return as(this, "sub", "", "")
        }
    }), st({
        target: "String",
        proto: !0,
        forced: us("sup")
    }, {
        sup: function () {
            return as(this, "sup", "", "")
        }
    });

    function fs(t, e, r) {
        var o, n;
        return Fr && "function" == typeof (o = e.constructor) && o !== r && C(n = o.prototype) && n !== r.prototype && Fr(t, n), t
    }
    var hs = x.f,
        ps = wt.f,
        ds = At("match"),
        ms = j.RegExp,
        ls = ms.prototype,
        gs = /a/g,
        ys = /a/g,
        _s = new ms(gs) !== gs;
    if (A && Dt("RegExp", !_s || F(function () {
        return ys[ds] = !1, ms(gs) != gs || ms(ys) == ys || "/a/i" != ms(gs, "i")
    }))) {
        for (var Rs = function (t, e) {
            var r = this instanceof Rs,
                o = Vn(t),
                n = void 0 === e;
            return !r && o && t.constructor === Rs && n ? t : fs(_s ? new ms(o && !n ? t.source : t, e) : ms((o = t instanceof Rs) ? t.source : t, o && n ? $n.call(t) : e), r ? this : ls, Rs)
        }, vs = function (e) {
            e in Rs || hs(Rs, e, {
                configurable: !0,
                get: function () {
                    return ms[e]
                },
                set: function (t) {
                    ms[e] = t
                }
            })
        }, ws = ps(ms), Ss = 0; ws.length > Ss;) vs(ws[Ss++]);
        (ls.constructor = Rs).prototype = ls, ft(j, "RegExp", Rs)
    }
    gn("RegExp"), st({
        target: "RegExp",
        proto: !0,
        forced: /./.exec !== ui
    }, {
        exec: ui
    }), A && "g" != /./g.flags && x.f(RegExp.prototype, "flags", {
        configurable: !0,
        get: $n
    });
    var Ms = "toString",
        bs = RegExp.prototype,
        Is = bs[Ms],
        Bs = F(function () {
            return "/a/b" != Is.call({
                source: "a",
                flags: "b"
            })
        }),
        Ts = Is.name != Ms;
    (Bs || Ts) && ft(RegExp.prototype, Ms, function () {
        var t = B(this),
            e = String(t.source),
            r = t.flags;
        return "/" + e + "/" + String(void 0 === r && t instanceof RegExp && !("flags" in bs) ? $n.call(t) : r)
    }, {
        unsafe: !0
    });
    var Os = zi.trim,
        Ds = j.parseInt,
        Ps = /^[+-]?0[Xx]/,
        Cs = 8 !== Ds(Ki + "08") || 22 !== Ds(Ki + "0x16") ? function (t, e) {
            var r = Os(String(t));
            return Ds(r, e >>> 0 || (Ps.test(r) ? 16 : 10))
        } : Ds;
    st({
        global: !0,
        forced: parseInt != Cs
    }, {
        parseInt: Cs
    });
    var ks = zi.trim,
        Ls = j.parseFloat,
        Es = 1 / Ls(Ki + "-0") != -1 / 0 ? function (t) {
            var e = ks(String(t)),
                r = Ls(e);
            return 0 === r && "-" == e.charAt(0) ? -0 : r
        } : Ls;
    st({
        global: !0,
        forced: parseFloat != Es
    }, {
        parseFloat: Es
    });

    function Ns(t) {
        var e, r, o, n, i, s, a, u, c = f(t, !1);
        if ("string" == typeof c && 2 < c.length)
            if (43 === (e = (c = js(c)).charCodeAt(0)) || 45 === e) {
                if (88 === (r = c.charCodeAt(2)) || 120 === r) return NaN
            } else if (48 === e) {
                switch (c.charCodeAt(1)) {
                    case 66:
                    case 98:
                        o = 2, n = 49;
                        break;
                    case 79:
                    case 111:
                        o = 8, n = 55;
                        break;
                    default:
                        return +c
                }
                for (s = (i = c.slice(2)).length, a = 0; a < s; a++)
                    if ((u = i.charCodeAt(a)) < 48 || n < u) return NaN;
                return parseInt(i, o)
            }
        return +c
    }
    var Us = wt.f,
        Gs = L.f,
        Fs = x.f,
        js = zi.trim,
        As = "Number",
        xs = j[As],
        qs = xs.prototype,
        Hs = n(jt(qs)) == As;
    if (Dt(As, !xs(" 0o1") || !xs("0b1") || xs("+0x1"))) {
        for (var Vs, Ks = function (t) {
            var e = arguments.length < 1 ? 0 : t,
                r = this;
            return r instanceof Ks && (Hs ? F(function () {
                qs.valueOf.call(r)
            }) : n(r) != As) ? fs(new xs(Ns(e)), r, Ks) : Ns(e)
        }, Ys = A ? Us(xs) : "MAX_VALUE,MIN_VALUE,NaN,NEGATIVE_INFINITY,POSITIVE_INFINITY,EPSILON,isFinite,isInteger,isNaN,isSafeInteger,MAX_SAFE_INTEGER,MIN_SAFE_INTEGER,parseFloat,parseInt,isInteger".split(","), Ws = 0; Ys.length > Ws; Ws++) k(xs, Vs = Ys[Ws]) && !k(Ks, Vs) && Fs(Ks, Vs, Gs(xs, Vs));
        (Ks.prototype = qs).constructor = Ks, ft(j, As, Ks)
    }
    st({
        target: "Number",
        stat: !0
    }, {
        EPSILON: Math.pow(2, -52)
    });
    var Js = j.isFinite,
        zs = Number.isFinite || function (t) {
            return "number" == typeof t && Js(t)
        };
    st({
        target: "Number",
        stat: !0
    }, {
        isFinite: zs
    });

    function Zs(t) {
        return !C(t) && isFinite(t) && $s(t) === t
    }
    var $s = Math.floor;
    st({
        target: "Number",
        stat: !0
    }, {
        isInteger: Zs
    }), st({
        target: "Number",
        stat: !0
    }, {
        isNaN: function (t) {
            return t != t
        }
    });
    var Xs = Math.abs;
    st({
        target: "Number",
        stat: !0
    }, {
        isSafeInteger: function (t) {
            return Zs(t) && Xs(t) <= 9007199254740991
        }
    }), st({
        target: "Number",
        stat: !0
    }, {
        MAX_SAFE_INTEGER: 9007199254740991
    }), st({
        target: "Number",
        stat: !0
    }, {
        MIN_SAFE_INTEGER: -9007199254740991
    }), st({
        target: "Number",
        stat: !0,
        forced: Number.parseFloat != Es
    }, {
        parseFloat: Es
    }), st({
        target: "Number",
        stat: !0,
        forced: Number.parseInt != Cs
    }, {
        parseInt: Cs
    });

    function Qs(t) {
        if ("number" != typeof t && "Number" != n(t)) throw TypeError("Incorrect invocation");
        return +t
    }
    var ta = 1..toFixed,
        ea = Math.floor,
        ra = function (t, e, r) {
            return 0 === e ? r : e % 2 == 1 ? ra(t, e - 1, r * t) : ra(t * t, e / 2, r)
        },
        oa = ta && ("0.000" !== 8e-5.toFixed(3) || "1" !== .9.toFixed(0) || "1.25" !== 1.255.toFixed(2) || "1000000000000000128" !== (0xde0b6b3a7640080).toFixed(0)) || !F(function () {
            ta.call({})
        });
    st({
        target: "Number",
        proto: !0,
        forced: oa
    }, {
        toFixed: function (t) {
            function e(t, e) {
                for (var r = -1, o = e; ++r < 6;) o += t * f[r], f[r] = o % 1e7, o = ea(o / 1e7)
            }

            function r(t) {
                for (var e = 6, r = 0; 0 <= --e;) r += f[e], f[e] = ea(r / t), r = r % t * 1e7
            }

            function o() {
                for (var t = 6, e = ""; 0 <= --t;)
                    if ("" !== e || 0 === t || 0 !== f[t]) {
                        var r = String(f[t]);
                        e = "" === e ? r : e + Ii.call("0", 7 - r.length) + r
                    }
                return e
            }
            var n, i, s, a, u = Qs(this),
                c = Q(t),
                f = [0, 0, 0, 0, 0, 0],
                h = "",
                p = "0";
            if (c < 0 || 20 < c) throw RangeError("Incorrect fraction digits");
            if (u != u) return "NaN";
            if (u <= -1e21 || 1e21 <= u) return String(u);
            if (u < 0 && (h = "-", u = -u), 1e-21 < u)
                if (i = (n = function (t) {
                    for (var e = 0, r = t; 4096 <= r;) e += 12, r /= 4096;
                    for (; 2 <= r;) e += 1, r /= 2;
                    return e
                }(u * ra(2, 69, 1)) - 69) < 0 ? u * ra(2, -n, 1) : u / ra(2, n, 1), i *= 4503599627370496, 0 < (n = 52 - n)) {
                    for (e(0, i), s = c; 7 <= s;) e(1e7, 0), s -= 7;
                    for (e(ra(10, s, 1), 0), s = n - 1; 23 <= s;) r(1 << 23), s -= 23;
                    r(1 << s), e(1, 1), r(2), p = o()
                } else e(0, i), e(1 << -n, 0), p = o() + Ii.call("0", c);
            return p = 0 < c ? h + ((a = p.length) <= c ? "0." + Ii.call("0", c - a) + p : p.slice(0, a - c) + "." + p.slice(a - c)) : h + p
        }
    });
    var na = 1..toPrecision,
        ia = F(function () {
            return "1" !== na.call(1, void 0)
        }) || !F(function () {
            na.call({})
        });
    st({
        target: "Number",
        proto: !0,
        forced: ia
    }, {
        toPrecision: function (t) {
            return void 0 === t ? na.call(Qs(this)) : na.call(Qs(this), t)
        }
    });
    var sa = Math.log,
        aa = Math.log1p || function (t) {
            return -1e-8 < (t = +t) && t < 1e-8 ? t - t * t / 2 : sa(1 + t)
        },
        ua = Math.acosh,
        ca = Math.log,
        fa = Math.sqrt,
        ha = Math.LN2,
        pa = !ua || 710 != Math.floor(ua(Number.MAX_VALUE)) || ua(1 / 0) != 1 / 0;
    st({
        target: "Math",
        stat: !0,
        forced: pa
    }, {
        acosh: function (t) {
            return (t = +t) < 1 ? NaN : 94906265.62425156 < t ? ca(t) + ha : aa(t - 1 + fa(t - 1) * fa(t + 1))
        }
    });
    var da = Math.asinh,
        ma = Math.log,
        la = Math.sqrt;
    st({
        target: "Math",
        stat: !0,
        forced: !(da && 0 < 1 / da(0))
    }, {
        asinh: function t(e) {
            return isFinite(e = +e) && 0 != e ? e < 0 ? -t(-e) : ma(e + la(e * e + 1)) : e
        }
    });
    var ga = Math.atanh,
        ya = Math.log;
    st({
        target: "Math",
        stat: !0,
        forced: !(ga && 1 / ga(-0) < 0)
    }, {
        atanh: function (t) {
            return 0 == (t = +t) ? t : ya((1 + t) / (1 - t)) / 2
        }
    });
    var _a = Math.sign || function (t) {
        return 0 == (t = +t) || t != t ? t : t < 0 ? -1 : 1
    },
        Ra = Math.abs,
        va = Math.pow;
    st({
        target: "Math",
        stat: !0
    }, {
        cbrt: function (t) {
            return _a(t = +t) * va(Ra(t), 1 / 3)
        }
    });
    var wa = Math.floor,
        Sa = Math.log,
        Ma = Math.LOG2E;
    st({
        target: "Math",
        stat: !0
    }, {
        clz32: function (t) {
            return (t >>>= 0) ? 31 - wa(Sa(t + .5) * Ma) : 32
        }
    });
    var ba = Math.expm1,
        Ia = Math.exp,
        Ba = !ba || 22025.465794806718 < ba(10) || ba(10) < 22025.465794806718 || -2e-17 != ba(-2e-17) ? function (t) {
            return 0 == (t = +t) ? t : -1e-6 < t && t < 1e-6 ? t + t * t / 2 : Ia(t) - 1
        } : ba,
        Ta = Math.cosh,
        Oa = Math.abs,
        Da = Math.E;
    st({
        target: "Math",
        stat: !0,
        forced: !Ta || Ta(710) === 1 / 0
    }, {
        cosh: function (t) {
            var e = Ba(Oa(t) - 1) + 1;
            return (e + 1 / (e * Da * Da)) * (Da / 2)
        }
    }), st({
        target: "Math",
        stat: !0,
        forced: Ba != Math.expm1
    }, {
        expm1: Ba
    });
    var Pa = Math.abs,
        Ca = Math.pow,
        ka = Ca(2, -52),
        La = Ca(2, -23),
        Ea = Ca(2, 127) * (2 - La),
        Na = Ca(2, -126),
        Ua = Math.fround || function (t) {
            var e, r, o = Pa(t),
                n = _a(t);
            return o < Na ? n * function (t) {
                return t + 1 / ka - 1 / ka
            }(o / Na / La) * Na * La : Ea < (r = (e = (1 + La / ka) * o) - (e - o)) || r != r ? n * (1 / 0) : n * r
        };
    st({
        target: "Math",
        stat: !0
    }, {
        fround: Ua
    });
    var Ga = Math.hypot,
        Fa = Math.abs,
        ja = Math.sqrt,
        Aa = !!Ga && Ga(1 / 0, NaN) !== 1 / 0;
    st({
        target: "Math",
        stat: !0,
        forced: Aa
    }, {
        hypot: function (t, e) {
            for (var r, o, n = 0, i = 0, s = arguments.length, a = 0; i < s;) a < (r = Fa(arguments[i++])) ? (n = n * (o = a / r) * o + 1, a = r) : n += 0 < r ? (o = r / a) * o : r;
            return a === 1 / 0 ? 1 / 0 : a * ja(n)
        }
    });
    var xa = Math.imul,
        qa = F(function () {
            return -5 != xa(4294967295, 5) || 2 != xa.length
        });
    st({
        target: "Math",
        stat: !0,
        forced: qa
    }, {
        imul: function (t, e) {
            var r = 65535,
                o = +t,
                n = +e,
                i = r & o,
                s = r & n;
            return 0 | i * s + ((r & o >>> 16) * s + i * (r & n >>> 16) << 16 >>> 0)
        }
    });
    var Ha = Math.log,
        Va = Math.LOG10E;
    st({
        target: "Math",
        stat: !0
    }, {
        log10: function (t) {
            return Ha(t) * Va
        }
    }), st({
        target: "Math",
        stat: !0
    }, {
        log1p: aa
    });
    var Ka = Math.log,
        Ya = Math.LN2;
    st({
        target: "Math",
        stat: !0
    }, {
        log2: function (t) {
            return Ka(t) / Ya
        }
    }), st({
        target: "Math",
        stat: !0
    }, {
        sign: _a
    });
    var Wa = Math.abs,
        Ja = Math.exp,
        za = Math.E,
        Za = F(function () {
            return -2e-17 != Math.sinh(-2e-17)
        });
    st({
        target: "Math",
        stat: !0,
        forced: Za
    }, {
        sinh: function (t) {
            return Wa(t = +t) < 1 ? (Ba(t) - Ba(-t)) / 2 : (Ja(t - 1) - Ja(-t - 1)) * (za / 2)
        }
    });
    var $a = Math.exp;
    st({
        target: "Math",
        stat: !0
    }, {
        tanh: function (t) {
            var e = Ba(t = +t),
                r = Ba(-t);
            return e == 1 / 0 ? 1 : r == 1 / 0 ? -1 : (e - r) / ($a(t) + $a(-t))
        }
    }), qt(Math, "Math", !0);
    var Xa = Math.ceil,
        Qa = Math.floor;
    st({
        target: "Math",
        stat: !0
    }, {
        trunc: function (t) {
            return (0 < t ? Qa : Xa)(t)
        }
    }), st({
        target: "Date",
        stat: !0
    }, {
        now: function () {
            return (new Date).getTime()
        }
    });
    var tu = F(function () {
        return null !== new Date(NaN).toJSON() || 1 !== Date.prototype.toJSON.call({
            toISOString: function () {
                return 1
            }
        })
    });
    st({
        target: "Date",
        proto: !0,
        forced: tu
    }, {
        toJSON: function (t) {
            var e = at(this),
                r = f(e);
            return "number" != typeof r || isFinite(r) ? e.toISOString() : null
        }
    });
    var eu = Ti.start,
        ru = Math.abs,
        ou = Date.prototype,
        nu = ou.getTime,
        iu = ou.toISOString,
        su = F(function () {
            return "0385-07-25T07:06:39.999Z" != iu.call(new Date(-5e13 - 1))
        }) || !F(function () {
            iu.call(new Date(NaN))
        }) ? function () {
            if (!isFinite(nu.call(this))) throw RangeError("Invalid time value");
            var t = this,
                e = t.getUTCFullYear(),
                r = t.getUTCMilliseconds(),
                o = e < 0 ? "-" : 9999 < e ? "+" : "";
            return o + eu(ru(e), o ? 6 : 4, 0) + "-" + eu(t.getUTCMonth() + 1, 2, 0) + "-" + eu(t.getUTCDate(), 2, 0) + "T" + eu(t.getUTCHours(), 2, 0) + ":" + eu(t.getUTCMinutes(), 2, 0) + ":" + eu(t.getUTCSeconds(), 2, 0) + "." + eu(r, 3, 0) + "Z"
        } : iu;
    st({
        target: "Date",
        proto: !0,
        forced: Date.prototype.toISOString !== su
    }, {
        toISOString: su
    });
    var au = Date.prototype,
        uu = "Invalid Date",
        cu = "toString",
        fu = au[cu],
        hu = au.getTime;
    new Date(NaN) + "" != uu && ft(au, cu, function () {
        var t = hu.call(this);
        return t == t ? fu.call(this) : uu
    });
    var pu = At("toPrimitive"),
        du = Date.prototype;
    pu in du || q(du, pu, function (t) {
        if ("string" !== t && "number" !== t && "default" !== t) throw TypeError("Incorrect hint");
        return f(B(this), "number" !== t)
    }), qt(j.JSON, "JSON", !0);

    function mu(t, e, r) {
        for (var o in e) ft(t, o, e[o], r);
        return t
    }

    function lu(t, e, r) {
        if (!(t instanceof e)) throw TypeError("Incorrect " + (r ? r + " " : "") + "invocation");
        return t
    }

    function gu(t) {
        if (Cu.hasOwnProperty(t)) {
            var e = Cu[t];
            delete Cu[t], e()
        }
    }

    function yu(t) {
        return function () {
            gu(t)
        }
    }

    function _u(t) {
        gu(t.data)
    }

    function Ru(t) {
        j.postMessage(t + "", bu.protocol + "//" + bu.host)
    }
    var vu, wu, Su, Mu = j.Promise,
        bu = j.location,
        Iu = j.setImmediate,
        Bu = j.clearImmediate,
        Tu = j.process,
        Ou = j.MessageChannel,
        Du = j.Dispatch,
        Pu = 0,
        Cu = {},
        ku = "onreadystatechange";
    Iu && Bu || (Iu = function (t) {
        for (var e = [], r = 1; r < arguments.length;) e.push(arguments[r++]);
        return Cu[++Pu] = function () {
            ("function" == typeof t ? t : Function(t)).apply(void 0, e)
        }, vu(Pu), Pu
    }, Bu = function (t) {
        delete Cu[t]
    }, "process" == n(Tu) ? vu = function (t) {
        Tu.nextTick(yu(t))
    } : Du && Du.now ? vu = function (t) {
        Du.now(yu(t))
    } : Ou ? (Su = (wu = new Ou).port2, wu.port1.onmessage = _u, vu = Vt(Su.postMessage, Su, 1)) : !j.addEventListener || "function" != typeof postMessage || j.importScripts || F(Ru) ? vu = ku in i("script") ? function (t) {
        Nt.appendChild(i("script"))[ku] = function () {
            Nt.removeChild(this), gu(t)
        }
    } : function (t) {
        setTimeout(yu(t), 0)
    } : (vu = Ru, j.addEventListener("message", _u, !1)));
    var Lu, Eu, Nu, Uu, Gu, Fu, ju, Au, xu = {
        set: Iu,
        clear: Bu
    },
        qu = L.f,
        Hu = xu.set,
        Vu = j.MutationObserver || j.WebKitMutationObserver,
        Ku = j.process,
        Yu = j.Promise,
        Wu = "process" == n(Ku),
        Ju = qu(j, "queueMicrotask"),
        zu = Ju && Ju.value;
    zu || (Lu = function () {
        var t, e;
        for (Wu && (t = Ku.domain) && t.exit(); Eu;) {
            e = Eu.fn, Eu = Eu.next;
            try {
                e()
            } catch (t) {
                throw Eu ? Uu() : Nu = void 0, t
            }
        }
        Nu = void 0, t && t.enter()
    }, Uu = Wu ? function () {
        Ku.nextTick(Lu)
    } : Vu && !/(iphone|ipod|ipad).*applewebkit/i.test(Oi) ? (Gu = !0, Fu = document.createTextNode(""), new Vu(Lu).observe(Fu, {
        characterData: !0
    }), function () {
        Fu.data = Gu = !Gu
    }) : Yu && Yu.resolve ? (ju = Yu.resolve(void 0), Au = ju.then, function () {
        Au.call(ju, Lu)
    }) : function () {
        Hu.call(j, Lu)
    });

    function Zu(t) {
        var r, o;
        this.promise = new t(function (t, e) {
            if (void 0 !== r || void 0 !== o) throw TypeError("Bad Promise constructor");
            r = t, o = e
        }), this.resolve = Ht(r), this.reject = Ht(o)
    }

    function $u(t, e) {
        if (B(t), C(e) && e.constructor === t) return e;
        var r = fc.f(t);
        return (0, r.resolve)(e), r.promise
    }

    function Xu(t, e) {
        var r = j.console;
        r && r.error && (1 === arguments.length ? r.error(t) : r.error(t, e))
    }

    function Qu(t) {
        try {
            return {
                error: !1,
                value: t()
            }
        } catch (t) {
            return {
                error: !0,
                value: t
            }
        }
    }

    function tc(t) {
        var e;
        return !(!C(t) || "function" != typeof (e = t.then)) && e
    }

    function ec(h, p, d) {
        if (!p.notified) {
            p.notified = !0;
            var m = p.reactions;
            cc(function () {
                for (var t = p.value, e = 1 == p.state, r = 0; m.length > r;) {
                    var o, n, i, s = m[r++],
                        a = e ? s.ok : s.fail,
                        u = s.resolve,
                        c = s.reject,
                        f = s.domain;
                    try {
                        a ? (e || (2 === p.rejection && Lc(h, p), p.rejection = 1), !0 === a ? o = t : (f && f.enter(), o = a(t), f && (f.exit(), i = !0)), o === s.promise ? c(_c("Promise-chain cycle")) : (n = tc(o)) ? n.call(o, u, c) : u(o)) : c(t)
                    } catch (t) {
                        f && !i && f.exit(), c(t)
                    }
                }
                p.reactions = [], p.notified = !1, d && !p.rejection && Cc(h, p)
            })
        }
    }

    function rc(t, e, r) {
        var o, n;
        Tc ? ((o = Rc.createEvent("Event")).promise = e, o.reason = r, o.initEvent(t, !1, !0), j.dispatchEvent(o)) : o = {
            promise: e,
            reason: r
        }, (n = j["on" + t]) ? n(o) : t === Oc && Xu("Unhandled promise rejection", r)
    }

    function oc(e, r, o, n) {
        return function (t) {
            e(r, o, t, n)
        }
    }

    function nc(t, e, r, o) {
        e.done || (e.done = !0, o && (e = o), e.value = r, e.state = 2, ec(t, e, !0))
    }
    var ic, sc, ac, uc, cc = zu || function (t) {
        var e = {
            fn: t,
            next: void 0
        };
        Nu && (Nu.next = e), Eu || (Eu = e, Uu()), Nu = e
    },
        fc = {
            f: function (t) {
                return new Zu(t)
            }
        },
        hc = xu.set,
        pc = At("species"),
        dc = "Promise",
        mc = ct.get,
        lc = ct.set,
        gc = ct.getterFor(dc),
        yc = Mu,
        _c = j.TypeError,
        Rc = j.document,
        vc = j.process,
        wc = j.fetch,
        Sc = vc && vc.versions,
        Mc = Sc && Sc.v8 || "",
        bc = fc.f,
        Ic = bc,
        Bc = "process" == n(vc),
        Tc = !!(Rc && Rc.createEvent && j.dispatchEvent),
        Oc = "unhandledrejection",
        Dc = Dt(dc, function () {
            function e() { }
            var t = yc.resolve(1),
                r = (t.constructor = {})[pc] = function (t) {
                    t(e, e)
                };
            return !((Bc || "function" == typeof PromiseRejectionEvent) && t.then(e) instanceof r && 0 !== Mc.indexOf("6.6") && -1 === Oi.indexOf("Chrome/66"))
        }),
        Pc = Dc || !ao(function (t) {
            yc.all(t).catch(function () { })
        }),
        Cc = function (r, o) {
            hc.call(j, function () {
                var t, e = o.value;
                if (kc(o) && (t = Qu(function () {
                    Bc ? vc.emit("unhandledRejection", e, r) : rc(Oc, r, e)
                }), o.rejection = Bc || kc(o) ? 2 : 1, t.error)) throw t.value
            })
        },
        kc = function (t) {
            return 1 !== t.rejection && !t.parent
        },
        Lc = function (t, e) {
            hc.call(j, function () {
                Bc ? vc.emit("rejectionHandled", t) : rc("rejectionhandled", t, e.value)
            })
        },
        Ec = function (r, o, t, e) {
            if (!o.done) {
                o.done = !0, e && (o = e);
                try {
                    if (r === t) throw _c("Promise can't be resolved itself");
                    var n = tc(t);
                    n ? cc(function () {
                        var e = {
                            done: !1
                        };
                        try {
                            n.call(t, oc(Ec, r, e, o), oc(nc, r, e, o))
                        } catch (t) {
                            nc(r, e, t, o)
                        }
                    }) : (o.value = t, o.state = 1, ec(r, o, !1))
                } catch (t) {
                    nc(r, {
                        done: !1
                    }, t, o)
                }
            }
        };
    Dc && (yc = function (t) {
        lu(this, yc, dc), Ht(t), ic.call(this);
        var e = mc(this);
        try {
            t(oc(Ec, this, e), oc(nc, this, e))
        } catch (t) {
            nc(this, e, t)
        }
    }, (ic = function (t) {
        lc(this, {
            type: dc,
            done: !1,
            notified: !1,
            parent: !1,
            reactions: [],
            rejection: !1,
            state: 0,
            value: void 0
        })
    }).prototype = mu(yc.prototype, {
        then: function (t, e) {
            var r = gc(this),
                o = bc(di(this, yc));
            return o.ok = "function" != typeof t || t, o.fail = "function" == typeof e && e, o.domain = Bc ? vc.domain : void 0, r.parent = !0, r.reactions.push(o), 0 != r.state && ec(this, r, !1), o.promise
        },
        catch: function (t) {
            return this.then(void 0, t)
        }
    }), sc = function () {
        var t = new ic,
            e = mc(t);
        this.promise = t, this.resolve = oc(Ec, t, e), this.reject = oc(nc, t, e)
    }, fc.f = bc = function (t) {
        return t === yc || t === ac ? new sc(t) : Ic(t)
    }, "function" == typeof Mu && (uc = Mu.prototype.then, ft(Mu.prototype, "then", function (t, e) {
        var r = this;
        return new yc(function (t, e) {
            uc.call(r, t, e)
        }).then(t, e)
    }), "function" == typeof wc && st({
        global: !0,
        enumerable: !0,
        forced: !0
    }, {
        fetch: function (t) {
            return $u(yc, wc.apply(j, arguments))
        }
    }))), st({
        global: !0,
        wrap: !0,
        forced: Dc
    }, {
        Promise: yc
    }), qt(yc, dc, !1), gn(dc), ac = ht[dc], st({
        target: dc,
        stat: !0,
        forced: Dc
    }, {
        reject: function (t) {
            var e = bc(this);
            return e.reject.call(void 0, t), e.promise
        }
    }), st({
        target: dc,
        stat: !0,
        forced: Dc
    }, {
        resolve: function (t) {
            return $u(this, t)
        }
    }), st({
        target: dc,
        stat: !0,
        forced: Pc
    }, {
        all: function (t) {
            var a = this,
                e = bc(a),
                u = e.resolve,
                c = e.reject,
                r = Qu(function () {
                    var o = Ht(a.resolve),
                        n = [],
                        i = 0,
                        s = 1;
                    dr(t, function (t) {
                        var e = i++,
                            r = !1;
                        n.push(void 0), s++, o.call(a, t).then(function (t) {
                            r || (r = !0, n[e] = t, --s || u(n))
                        }, c)
                    }), --s || u(n)
                });
            return r.error && c(r.value), e.promise
        },
        race: function (t) {
            var r = this,
                o = bc(r),
                n = o.reject,
                e = Qu(function () {
                    var e = Ht(r.resolve);
                    dr(t, function (t) {
                        e.call(r, t).then(o.resolve, n)
                    })
                });
            return e.error && n(e.value), o.promise
        }
    }), st({
        target: "Promise",
        stat: !0
    }, {
        allSettled: function (t) {
            var a = this,
                e = fc.f(a),
                u = e.resolve,
                r = e.reject,
                o = Qu(function () {
                    var o = Ht(a.resolve),
                        n = [],
                        i = 0,
                        s = 1;
                    dr(t, function (t) {
                        var e = i++,
                            r = !1;
                        n.push(void 0), s++, o.call(a, t).then(function (t) {
                            r || (r = !0, n[e] = {
                                status: "fulfilled",
                                value: t
                            }, --s || u(n))
                        }, function (t) {
                            r || (r = !0, n[e] = {
                                status: "rejected",
                                reason: t
                            }, --s || u(n))
                        })
                    }), --s || u(n)
                });
            return o.error && r(o.value), e.promise
        }
    }), st({
        target: "Promise",
        proto: !0,
        real: !0
    }, {
        finally: function (e) {
            var r = di(this, X("Promise")),
                t = "function" == typeof e;
            return this.then(t ? function (t) {
                return $u(r, e()).then(function () {
                    return t
                })
            } : e, t ? function (t) {
                return $u(r, e()).then(function () {
                    throw t
                })
            } : e)
        }
    }), "function" != typeof Mu || Mu.prototype.finally || ft(Mu.prototype, "finally", X("Promise").prototype.finally);

    function Nc(o, t, e, n, i) {
        function r(t) {
            var r = a[t];
            ft(a, t, "add" == t ? function (t) {
                return r.call(this, 0 === t ? 0 : t), this
            } : "delete" == t ? function (t) {
                return !(i && !C(t)) && r.call(this, 0 === t ? 0 : t)
            } : "get" == t ? function (t) {
                return i && !C(t) ? void 0 : r.call(this, 0 === t ? 0 : t)
            } : "has" == t ? function (t) {
                return !(i && !C(t)) && r.call(this, 0 === t ? 0 : t)
            } : function (t, e) {
                return r.call(this, 0 === t ? 0 : t, e), this
            })
        }
        var s = j[o],
            a = s && s.prototype,
            u = s,
            c = n ? "set" : "add",
            f = {};
        if (Dt(o, "function" != typeof s || !(i || a.forEach && !F(function () {
            (new s).entries().next()
        })))) u = e.getConstructor(t, o, n, c), Xe.REQUIRED = !0;
        else if (Dt(o, !0)) {
            var h = new u,
                p = h[c](i ? {} : -0, 1) != h,
                d = F(function () {
                    h.has(1)
                }),
                m = ao(function (t) {
                    new s(t)
                }),
                l = !i && F(function () {
                    for (var t = new s, e = 5; e--;) t[c](e, e);
                    return !t.has(-0)
                });
            m || (((u = t(function (t, e) {
                lu(t, u, o);
                var r = fs(new s, t, u);
                return null != e && dr(e, r[c], r, n), r
            })).prototype = a).constructor = u), (d || l) && (r("delete"), r("has"), n && r("get")), (l || p) && r(c), i && a.clear && delete a.clear
        }
        return f[o] = u, st({
            global: !0,
            forced: u != s
        }, f), qt(u, o), i || e.setStrong(u, o, n), u
    }

    function Uc(t) {
        return t.frozen || (t.frozen = new $c)
    }

    function Gc(t, e) {
        return Jc(t.entries, function (t) {
            return t[0] === e
        })
    }
    var Fc = x.f,
        jc = Xe.fastKey,
        Ac = ct.set,
        xc = ct.getterFor,
        qc = {
            getConstructor: function (t, r, o, n) {
                function i(t, e, r) {
                    var o, n, i = a(t),
                        s = u(t, e);
                    return s ? s.value = r : (i.last = s = {
                        index: n = jc(e, !0),
                        key: e,
                        value: r,
                        previous: o = i.last,
                        next: void 0,
                        removed: !1
                    }, i.first || (i.first = s), o && (o.next = s), A ? i.size++ : t.size++, "F" !== n && (i.index[n] = s)), t
                }
                var s = t(function (t, e) {
                    lu(t, s, r), Ac(t, {
                        type: r,
                        index: jt(null),
                        first: void 0,
                        last: void 0,
                        size: 0
                    }), A || (t.size = 0), null != e && dr(e, t[n], t, o)
                }),
                    a = xc(r),
                    u = function (t, e) {
                        var r, o = a(t),
                            n = jc(e);
                        if ("F" !== n) return o.index[n];
                        for (r = o.first; r; r = r.next)
                            if (r.key == e) return r
                    };
                return mu(s.prototype, {
                    clear: function () {
                        for (var t = a(this), e = t.index, r = t.first; r;) r.removed = !0, r.previous && (r.previous = r.previous.next = void 0), delete e[r.index], r = r.next;
                        t.first = t.last = void 0, A ? t.size = 0 : this.size = 0
                    },
                    delete: function (t) {
                        var e = a(this),
                            r = u(this, t);
                        if (r) {
                            var o = r.next,
                                n = r.previous;
                            delete e.index[r.index], r.removed = !0, n && (n.next = o), o && (o.previous = n), e.first == r && (e.first = o), e.last == r && (e.last = n), A ? e.size-- : this.size--
                        }
                        return !!r
                    },
                    forEach: function (t, e) {
                        for (var r, o = a(this), n = Vt(t, 1 < arguments.length ? e : void 0, 3); r = r ? r.next : o.first;)
                            for (n(r.value, r.key, this); r && r.removed;) r = r.previous
                    },
                    has: function (t) {
                        return !!u(this, t)
                    }
                }), mu(s.prototype, o ? {
                    get: function (t) {
                        var e = u(this, t);
                        return e && e.value
                    },
                    set: function (t, e) {
                        return i(this, 0 === t ? 0 : t, e)
                    }
                } : {
                    add: function (t) {
                        return i(this, t = 0 === t ? 0 : t, t)
                    }
                }), A && Fc(s.prototype, "size", {
                    get: function () {
                        return a(this).size
                    }
                }), s
            },
            setStrong: function (t, e, r) {
                var o = e + " Iterator",
                    n = xc(e),
                    i = xc(o);
                Bn(t, e, function (t, e) {
                    Ac(this, {
                        type: o,
                        target: t,
                        state: n(t),
                        kind: e,
                        last: void 0
                    })
                }, function () {
                    for (var t = i(this), e = t.kind, r = t.last; r && r.removed;) r = r.previous;
                    return t.target && (t.last = r = r ? r.next : t.state.first) ? "keys" == e ? {
                        value: r.key,
                        done: !1
                    } : "values" == e ? {
                        value: r.value,
                        done: !1
                    } : {
                        value: [r.key, r.value],
                        done: !1
                    } : {
                        value: t.target = void 0,
                        done: !0
                    }
                }, r ? "entries" : "values", !r, !0), gn(e)
            }
        },
        Hc = Nc("Map", function (e) {
            return function (t) {
                return e(this, arguments.length ? t : void 0)
            }
        }, qc, !0),
        Vc = Nc("Set", function (e) {
            return function (t) {
                return e(this, arguments.length ? t : void 0)
            }
        }, qc),
        Kc = Xe.getWeakData,
        Yc = ct.set,
        Wc = ct.getterFor,
        Jc = ce.find,
        zc = ce.findIndex,
        Zc = 0,
        $c = function () {
            this.entries = []
        };
    $c.prototype = {
        get: function (t) {
            var e = Gc(this, t);
            if (e) return e[1]
        },
        has: function (t) {
            return !!Gc(this, t)
        },
        set: function (t, e) {
            var r = Gc(this, t);
            r ? r[1] = e : this.entries.push([t, e])
        },
        delete: function (e) {
            var t = zc(this.entries, function (t) {
                return t[0] === e
            });
            return ~t && this.entries.splice(t, 1), !!~t
        }
    };
    var Xc = {
        getConstructor: function (t, r, o, n) {
            function i(t, e, r) {
                var o = a(t),
                    n = Kc(B(e), !0);
                return !0 === n ? Uc(o).set(e, r) : n[o.id] = r, t
            }
            var s = t(function (t, e) {
                lu(t, s, r), Yc(t, {
                    type: r,
                    id: Zc++,
                    frozen: void 0
                }), null != e && dr(e, t[n], t, o)
            }),
                a = Wc(r);
            return mu(s.prototype, {
                delete: function (t) {
                    var e = a(this);
                    if (!C(t)) return !1;
                    var r = Kc(t);
                    return !0 === r ? Uc(e).delete(t) : r && k(r, e.id) && delete r[e.id]
                },
                has: function (t) {
                    var e = a(this);
                    if (!C(t)) return !1;
                    var r = Kc(t);
                    return !0 === r ? Uc(e).has(t) : r && k(r, e.id)
                }
            }), mu(s.prototype, o ? {
                get: function (t) {
                    var e = a(this);
                    if (C(t)) {
                        var r = Kc(t);
                        return !0 === r ? Uc(e).get(t) : r ? r[e.id] : void 0
                    }
                },
                set: function (t, e) {
                    return i(this, t, e)
                }
            } : {
                add: function (t) {
                    return i(this, t, !0)
                }
            }), s
        }
    },
        Qc = t(function (t) {
            function e(e) {
                return function (t) {
                    return e(this, arguments.length ? t : void 0)
                }
            }
            var o, n = ct.enforce,
                r = !j.ActiveXObject && "ActiveXObject" in j,
                i = Object.isExtensible,
                s = t.exports = Nc("WeakMap", e, Xc, !0, !0);
            if (N && r) {
                o = Xc.getConstructor(e, "WeakMap", !0), Xe.REQUIRED = !0;
                var a = s.prototype,
                    u = a.delete,
                    c = a.has,
                    f = a.get,
                    h = a.set;
                mu(a, {
                    delete: function (t) {
                        if (!C(t) || i(t)) return u.call(this, t);
                        var e = n(this);
                        return e.frozen || (e.frozen = new o), u.call(this, t) || e.frozen.delete(t)
                    },
                    has: function (t) {
                        if (!C(t) || i(t)) return c.call(this, t);
                        var e = n(this);
                        return e.frozen || (e.frozen = new o), c.call(this, t) || e.frozen.has(t)
                    },
                    get: function (t) {
                        if (!C(t) || i(t)) return f.call(this, t);
                        var e = n(this);
                        return e.frozen || (e.frozen = new o), c.call(this, t) ? f.call(this, t) : e.frozen.get(t)
                    },
                    set: function (t, e) {
                        if (C(t) && !i(t)) {
                            var r = n(this);
                            r.frozen || (r.frozen = new o), c.call(this, t) ? h.call(this, t, e) : r.frozen.set(t, e)
                        } else h.call(this, t, e);
                        return this
                    }
                })
            }
        });
    Nc("WeakSet", function (e) {
        return function (t) {
            return e(this, arguments.length ? t : void 0)
        }
    }, Xc, !1, !0);

    function tf(t) {
        return C(t) && k(Rf, or(t))
    }
    var ef, rf = x.f,
        of = j.DataView,
        nf = of && of.prototype,
        sf = j.Int8Array,
        af = sf && sf.prototype,
        uf = j.Uint8ClampedArray,
        cf = uf && uf.prototype,
        ff = sf && wr(sf),
        hf = af && wr(af),
        pf = Object.prototype,
        df = pf.isPrototypeOf,
        mf = At("toStringTag"),
        lf = a("TYPED_ARRAY_TAG"),
        gf = !(!j.ArrayBuffer || !of),
        yf = gf && !!Fr && "Opera" !== or(j.opera),
        _f = !1,
        Rf = {
            Int8Array: 1,
            Uint8Array: 1,
            Uint8ClampedArray: 1,
            Int16Array: 2,
            Uint16Array: 2,
            Int32Array: 4,
            Uint32Array: 4,
            Float32Array: 4,
            Float64Array: 8
        };
    for (ef in Rf) j[ef] || (yf = !1);
    if ((!yf || "function" != typeof ff || ff === Function.prototype) && (ff = function () {
        throw TypeError("Incorrect invocation")
    }, yf))
        for (ef in Rf) j[ef] && Fr(j[ef], ff);
    if ((!yf || !hf || hf === pf) && (hf = ff.prototype, yf))
        for (ef in Rf) j[ef] && Fr(j[ef].prototype, hf);
    if (yf && wr(cf) !== hf && Fr(cf, hf), A && !k(hf, mf))
        for (ef in _f = !0, rf(hf, mf, {
            get: function () {
                return C(this) ? this[lf] : void 0
            }
        }), Rf) j[ef] && q(j[ef], lf, ef);
    gf && Fr && wr(nf) !== pf && Fr(nf, pf);

    function vf(t) {
        if (void 0 === t) return 0;
        var e = Q(t),
            r = tt(e);
        if (e !== r) throw RangeError("Wrong length or index");
        return r
    }
    var wf = {
        NATIVE_ARRAY_BUFFER: gf,
        NATIVE_ARRAY_BUFFER_VIEWS: yf,
        TYPED_ARRAY_TAG: _f && lf,
        aTypedArray: function (t) {
            if (tf(t)) return t;
            throw TypeError("Target is not a typed array")
        },
        aTypedArrayConstructor: function (t) {
            if (Fr) {
                if (df.call(ff, t)) return t
            } else
                for (var e in Rf)
                    if (k(Rf, ef)) {
                        var r = j[e];
                        if (r && (t === r || df.call(r, t))) return t
                    } throw TypeError("Target is not a typed array constructor")
        },
        exportProto: function (t, e, r) {
            if (A) {
                if (r)
                    for (var o in Rf) {
                        var n = j[o];
                        n && k(n.prototype, t) && delete n.prototype[t]
                    }
                hf[t] && !r || ft(hf, t, r ? e : yf && af[t] || e)
            }
        },
        exportStatic: function (t, e, r) {
            var o, n;
            if (A) {
                if (Fr) {
                    if (r)
                        for (o in Rf) (n = j[o]) && k(n, t) && delete n[t];
                    if (ff[t] && !r) return;
                    try {
                        return ft(ff, t, r ? e : yf && sf[t] || e)
                    } catch (t) { }
                }
                for (o in Rf) !(n = j[o]) || n[t] && !r || ft(n, t, e)
            }
        },
        isView: function (t) {
            var e = or(t);
            return "DataView" === e || k(Rf, e)
        },
        isTypedArray: tf,
        TypedArray: ff,
        TypedArrayPrototype: hf
    },
        Sf = t(function (t, e) {
            function r(t, e, r) {
                var o, n, i, s = new Array(r),
                    a = 8 * r - e - 1,
                    u = (1 << a) - 1,
                    c = u >> 1,
                    f = 23 === e ? O(2, -24) - O(2, -77) : 0,
                    h = t < 0 || 0 === t && 1 / t < 0 ? 1 : 0,
                    p = 0;
                for ((t = T(t)) != t || t === 1 / 0 ? (n = t != t ? 1 : 0, o = u) : (o = D(P(t) / C), t * (i = O(2, -o)) < 1 && (o--, i *= 2), 2 <= (t += 1 <= o + c ? f / i : f * O(2, 1 - c)) * i && (o++, i /= 2), u <= o + c ? (n = 0, o = u) : 1 <= o + c ? (n = (t * i - 1) * O(2, e), o += c) : (n = t * O(2, c - 1) * O(2, e), o = 0)); 8 <= e; s[p++] = 255 & n, n /= 256, e -= 8);
                for (o = o << e | n, a += e; 0 < a; s[p++] = 255 & o, o /= 256, a -= 8);
                return s[--p] |= 128 * h, s
            }

            function o(t, e) {
                var r, o = t.length,
                    n = 8 * o - e - 1,
                    i = (1 << n) - 1,
                    s = i >> 1,
                    a = n - 7,
                    u = o - 1,
                    c = t[u--],
                    f = 127 & c;
                for (c >>= 7; 0 < a; f = 256 * f + t[u], u--, a -= 8);
                for (r = f & (1 << -a) - 1, f >>= -a, a += e; 0 < a; r = 256 * r + t[u], u--, a -= 8);
                if (0 === f) f = 1 - s;
                else {
                    if (f === i) return r ? NaN : c ? -1 / 0 : 1 / 0;
                    r += O(2, e), f -= s
                }
                return (c ? -1 : 1) * r * O(2, f - e)
            }

            function n(t) {
                return t[3] << 24 | t[2] << 16 | t[1] << 8 | t[0]
            }

            function i(t) {
                return [255 & t]
            }

            function s(t) {
                return [255 & t, t >> 8 & 255]
            }

            function a(t) {
                return [255 & t, t >> 8 & 255, t >> 16 & 255, t >> 24 & 255]
            }

            function u(t) {
                return r(t, 23, 4)
            }

            function c(t) {
                return r(t, 52, 8)
            }

            function f(t, e) {
                l(t[v], e, {
                    get: function () {
                        return g(this)[e]
                    }
                })
            }

            function h(t, e, r, o) {
                var n = vf(+r),
                    i = g(t);
                if (n + e > i.byteLength) throw B(w);
                var s = g(i.buffer).bytes,
                    a = n + i.byteOffset,
                    u = s.slice(a, a + e);
                return o ? u : u.reverse()
            }

            function p(t, e, r, o, n, i) {
                var s = vf(+r),
                    a = g(t);
                if (s + e > a.byteLength) throw B(w);
                for (var u = g(a.buffer).bytes, c = s + a.byteOffset, f = o(+n), h = 0; h < e; h++) u[c + h] = f[i ? h : e - h - 1]
            }
            var d = wf.NATIVE_ARRAY_BUFFER,
                m = wt.f,
                l = x.f,
                g = ct.get,
                y = ct.set,
                _ = "ArrayBuffer",
                R = "DataView",
                v = "prototype",
                w = "Wrong index",
                S = j[_],
                M = S,
                b = j[R],
                I = j.Math,
                B = j.RangeError,
                T = I.abs,
                O = I.pow,
                D = I.floor,
                P = I.log,
                C = I.LN2;
            if (d) {
                if (!F(function () {
                    S(1)
                }) || !F(function () {
                    new S(-1)
                }) || F(function () {
                    return new S, new S(1.5), new S(NaN), S.name != _
                })) {
                    for (var k, L = (M = function (t) {
                        return lu(this, M), new S(vf(t))
                    })[v] = S[v], E = m(S), N = 0; E.length > N;)(k = E[N++]) in M || q(M, k, S[k]);
                    L.constructor = M
                }
                var U = new b(new M(2)),
                    G = b[v].setInt8;
                U.setInt8(0, 2147483648), U.setInt8(1, 2147483649), !U.getInt8(0) && U.getInt8(1) || mu(b[v], {
                    setInt8: function (t, e) {
                        G.call(this, t, e << 24 >> 24)
                    },
                    setUint8: function (t, e) {
                        G.call(this, t, e << 24 >> 24)
                    }
                }, {
                    unsafe: !0
                })
            } else M = function (t) {
                lu(this, M, _);
                var e = vf(t);
                y(this, {
                    bytes: Bo.call(new Array(e), 0),
                    byteLength: e
                }), A || (this.byteLength = e)
            }, b = function (t, e, r) {
                lu(this, b, R), lu(t, M, R);
                var o = g(t).byteLength,
                    n = Q(e);
                if (n < 0 || o < n) throw B("Wrong offset");
                if (o < n + (r = void 0 === r ? o - n : tt(r))) throw B("Wrong length");
                y(this, {
                    buffer: t,
                    byteLength: r,
                    byteOffset: n
                }), A || (this.buffer = t, this.byteLength = r, this.byteOffset = n)
            }, A && (f(M, "byteLength"), f(b, "buffer"), f(b, "byteLength"), f(b, "byteOffset")), mu(b[v], {
                getInt8: function (t) {
                    return h(this, 1, t)[0] << 24 >> 24
                },
                getUint8: function (t) {
                    return h(this, 1, t)[0]
                },
                getInt16: function (t, e) {
                    var r = h(this, 2, t, 1 < arguments.length ? e : void 0);
                    return (r[1] << 8 | r[0]) << 16 >> 16
                },
                getUint16: function (t, e) {
                    var r = h(this, 2, t, 1 < arguments.length ? e : void 0);
                    return r[1] << 8 | r[0]
                },
                getInt32: function (t, e) {
                    return n(h(this, 4, t, 1 < arguments.length ? e : void 0))
                },
                getUint32: function (t, e) {
                    return n(h(this, 4, t, 1 < arguments.length ? e : void 0)) >>> 0
                },
                getFloat32: function (t, e) {
                    return o(h(this, 4, t, 1 < arguments.length ? e : void 0), 23)
                },
                getFloat64: function (t, e) {
                    return o(h(this, 8, t, 1 < arguments.length ? e : void 0), 52)
                },
                setInt8: function (t, e) {
                    p(this, 1, t, i, e)
                },
                setUint8: function (t, e) {
                    p(this, 1, t, i, e)
                },
                setInt16: function (t, e, r) {
                    p(this, 2, t, s, e, 2 < arguments.length ? r : void 0)
                },
                setUint16: function (t, e, r) {
                    p(this, 2, t, s, e, 2 < arguments.length ? r : void 0)
                },
                setInt32: function (t, e, r) {
                    p(this, 4, t, a, e, 2 < arguments.length ? r : void 0)
                },
                setUint32: function (t, e, r) {
                    p(this, 4, t, a, e, 2 < arguments.length ? r : void 0)
                },
                setFloat32: function (t, e, r) {
                    p(this, 4, t, u, e, 2 < arguments.length ? r : void 0)
                },
                setFloat64: function (t, e, r) {
                    p(this, 8, t, c, e, 2 < arguments.length ? r : void 0)
                }
            });
            qt(M, _), qt(b, R), e[_] = M, e[R] = b
        }),
        Mf = "ArrayBuffer",
        bf = Sf[Mf],
        If = j[Mf];
    st({
        global: !0,
        forced: If !== bf
    }, {
        ArrayBuffer: bf
    }), gn(Mf), st({
        target: "ArrayBuffer",
        stat: !0,
        forced: !wf.NATIVE_ARRAY_BUFFER_VIEWS
    }, {
        isView: wf.isView
    });
    var Bf = Sf.ArrayBuffer,
        Tf = Sf.DataView,
        Of = Bf.prototype.slice,
        Df = F(function () {
            return !new Bf(2).slice(1, void 0).byteLength
        });
    st({
        target: "ArrayBuffer",
        proto: !0,
        unsafe: !0,
        forced: Df
    }, {
        slice: function (t, e) {
            if (void 0 !== Of && void 0 === e) return Of.call(B(this), t);
            for (var r = B(this).byteLength, o = et(t, r), n = et(void 0 === e ? r : e, r), i = new (di(this, Bf))(tt(n - o)), s = new Tf(this), a = new Tf(i), u = 0; o < n;) a.setUint8(u++, s.getUint8(o++));
            return i
        }
    }), st({
        global: !0,
        forced: !wf.NATIVE_ARRAY_BUFFER
    }, {
        DataView: Sf.DataView
    });

    function Pf(t, e) {
        var r = Q(t);
        if (r < 0 || r % e) throw RangeError("Wrong offset");
        return r
    }

    function Cf(t, e, r) {
        var o, n, i, s, a, u = at(t),
            c = arguments.length,
            f = 1 < c ? e : void 0,
            h = void 0 !== f,
            p = nr(u);
        if (null != p && !rr(p))
            for (a = p.call(u), u = []; !(s = a.next()).done;) u.push(s.value);
        for (h && 2 < c && (f = Vt(f, r, 2)), n = tt(u.length), i = new (Uf(this))(n), o = 0; o < n; o++) i[o] = h ? f(u[o], o) : u[o];
        return i
    }
    var kf = wf.NATIVE_ARRAY_BUFFER_VIEWS,
        Lf = j.ArrayBuffer,
        Ef = j.Int8Array,
        Nf = !kf || !F(function () {
            Ef(1)
        }) || !F(function () {
            new Ef(-1)
        }) || !ao(function (t) {
            new Ef, new Ef(null), new Ef(1.5), new Ef(t)
        }, !0) || F(function () {
            return 1 !== new Ef(new Lf(2), 1, void 0).length
        }),
        Uf = wf.aTypedArrayConstructor,
        Gf = t(function (t) {
            function m(t, e) {
                for (var r = 0, o = e.length, n = new (s(t))(o); r < o;) n[r] = e[r++];
                return n
            }

            function e(t, e) {
                _(t, e, {
                    get: function () {
                        return g(this)[e]
                    }
                })
            }

            function l(t) {
                var e;
                return t instanceof w || "ArrayBuffer" == (e = or(t)) || "SharedArrayBuffer" == e
            }

            function o(t, e) {
                return T(t) && "symbol" != typeof e && e in t && String(+e) == String(e)
            }

            function r(t, e) {
                return o(t, e = f(e, !0)) ? P(2, t[e]) : i(t, e)
            }

            function n(t, e, r) {
                return !(o(t, e = f(e, !0)) && C(r) && k(r, "value")) || k(r, "get") || k(r, "set") || r.configurable || k(r, "writable") && !r.writable || k(r, "enumerable") && !r.enumerable ? _(t, e, r) : (t[e] = r.value, t)
            }
            var u = wt.f,
                c = ce.forEach,
                g = ct.get,
                y = ct.set,
                _ = x.f,
                i = L.f,
                R = Math.round,
                v = j.RangeError,
                w = Sf.ArrayBuffer,
                S = Sf.DataView,
                M = wf.NATIVE_ARRAY_BUFFER_VIEWS,
                b = wf.TYPED_ARRAY_TAG,
                I = wf.TypedArray,
                B = wf.TypedArrayPrototype,
                s = wf.aTypedArrayConstructor,
                T = wf.isTypedArray,
                O = "BYTES_PER_ELEMENT",
                D = "Wrong length";
            A ? (M || (L.f = r, x.f = n, e(B, "buffer"), e(B, "byteOffset"), e(B, "byteLength"), e(B, "length")), st({
                target: "Object",
                stat: !0,
                forced: !M
            }, {
                getOwnPropertyDescriptor: r,
                defineProperty: n
            }), t.exports = function (t, f, e, n) {
                function h(t, e) {
                    _(t, e, {
                        get: function () {
                            return function (t, e) {
                                var r = g(t);
                                return r.view[o](e * f + r.byteOffset, !0)
                            }(this, e)
                        },
                        set: function (t) {
                            return function (t, e, r) {
                                var o = g(t);
                                n && (r = (r = R(r)) < 0 ? 0 : 255 < r ? 255 : 255 & r), o.view[i](e * f + o.byteOffset, r, !0)
                            }(this, e, t)
                        },
                        enumerable: !0
                    })
                }
                var p = t + (n ? "Clamped" : "") + "Array",
                    o = "get" + t,
                    i = "set" + t,
                    s = j[p],
                    d = s,
                    r = d && d.prototype,
                    a = {};
                M ? Nf && (d = e(function (t, e, r, o) {
                    return lu(t, d, p), C(e) ? l(e) ? void 0 !== o ? new s(e, Pf(r, f), o) : void 0 !== r ? new s(e, Pf(r, f)) : new s(e) : T(e) ? m(d, e) : Cf.call(d, e) : new s(vf(e))
                }), Fr && Fr(d, I), c(u(s), function (t) {
                    t in d || q(d, t, s[t])
                }), d.prototype = r) : (d = e(function (t, e, r, o) {
                    lu(t, d, p);
                    var n, i, s, a = 0,
                        u = 0;
                    if (C(e)) {
                        if (!l(e)) return T(e) ? m(d, e) : Cf.call(d, e);
                        n = e, u = Pf(r, f);
                        var c = e.byteLength;
                        if (void 0 === o) {
                            if (c % f) throw v(D);
                            if ((i = c - u) < 0) throw v(D)
                        } else if (c < (i = tt(o) * f) + u) throw v(D);
                        s = i / f
                    } else s = vf(e), n = new w(i = s * f);
                    for (y(t, {
                        buffer: n,
                        byteOffset: u,
                        byteLength: i,
                        length: s,
                        view: new S(n)
                    }); a < s;) h(t, a++)
                }), Fr && Fr(d, I), r = d.prototype = jt(B)), r.constructor !== d && q(r, "constructor", d), b && q(r, b, p), a[p] = d, st({
                    global: !0,
                    forced: d != s,
                    sham: !M
                }, a), O in d || q(d, O, f), O in r || q(r, O, f), gn(p)
            }) : t.exports = function () { }
        });
    Gf("Int8", 1, function (o) {
        return function (t, e, r) {
            return o(this, t, e, r)
        }
    }), Gf("Uint8", 1, function (o) {
        return function (t, e, r) {
            return o(this, t, e, r)
        }
    }), Gf("Uint8", 1, function (o) {
        return function (t, e, r) {
            return o(this, t, e, r)
        }
    }, !0), Gf("Int16", 2, function (o) {
        return function (t, e, r) {
            return o(this, t, e, r)
        }
    }), Gf("Uint16", 2, function (o) {
        return function (t, e, r) {
            return o(this, t, e, r)
        }
    }), Gf("Int32", 4, function (o) {
        return function (t, e, r) {
            return o(this, t, e, r)
        }
    }), Gf("Uint32", 4, function (o) {
        return function (t, e, r) {
            return o(this, t, e, r)
        }
    }), Gf("Float32", 4, function (o) {
        return function (t, e, r) {
            return o(this, t, e, r)
        }
    }), Gf("Float64", 8, function (o) {
        return function (t, e, r) {
            return o(this, t, e, r)
        }
    }), wf.exportStatic("from", Cf, Nf);
    var Ff = wf.aTypedArrayConstructor;
    wf.exportStatic("of", function () {
        for (var t = 0, e = arguments.length, r = new (Ff(this))(e); t < e;) r[t] = arguments[t++];
        return r
    }, Nf);
    var jf = wf.aTypedArray;
    wf.exportProto("copyWithin", function (t, e, r) {
        return vo.call(jf(this), t, e, 2 < arguments.length ? r : void 0)
    });
    var Af = ce.every,
        xf = wf.aTypedArray;
    wf.exportProto("every", function (t, e) {
        return Af(xf(this), t, 1 < arguments.length ? e : void 0)
    });
    var qf = wf.aTypedArray;
    wf.exportProto("fill", function (t) {
        return Bo.apply(qf(this), arguments)
    });
    var Hf = ce.filter,
        Vf = wf.aTypedArray,
        Kf = wf.aTypedArrayConstructor;
    wf.exportProto("filter", function (t, e) {
        for (var r = Hf(Vf(this), t, 1 < arguments.length ? e : void 0), o = di(this, this.constructor), n = 0, i = r.length, s = new (Kf(o))(i); n < i;) s[n] = r[n++];
        return s
    });
    var Yf = ce.find,
        Wf = wf.aTypedArray;
    wf.exportProto("find", function (t, e) {
        return Yf(Wf(this), t, 1 < arguments.length ? e : void 0)
    });
    var Jf = ce.findIndex,
        zf = wf.aTypedArray;
    wf.exportProto("findIndex", function (t, e) {
        return Jf(zf(this), t, 1 < arguments.length ? e : void 0)
    });
    var Zf = ce.forEach,
        $f = wf.aTypedArray;
    wf.exportProto("forEach", function (t, e) {
        Zf($f(this), t, 1 < arguments.length ? e : void 0)
    });
    var Xf = yt.includes,
        Qf = wf.aTypedArray;
    wf.exportProto("includes", function (t, e) {
        return Xf(Qf(this), t, 1 < arguments.length ? e : void 0)
    });
    var th = yt.indexOf,
        eh = wf.aTypedArray;
    wf.exportProto("indexOf", function (t, e) {
        return th(eh(this), t, 1 < arguments.length ? e : void 0)
    });

    function rh() {
        return ih.call(uh(this))
    }
    var oh = At("iterator"),
        nh = j.Uint8Array,
        ih = Gn.values,
        sh = Gn.keys,
        ah = Gn.entries,
        uh = wf.aTypedArray,
        ch = wf.exportProto,
        fh = nh && nh.prototype[oh],
        hh = !!fh && ("values" == fh.name || null == fh.name);
    ch("entries", function () {
        return ah.call(uh(this))
    }), ch("keys", function () {
        return sh.call(uh(this))
    }), ch("values", rh, !hh), ch(oh, rh, !hh);
    var ph = wf.aTypedArray,
        dh = [].join;
    wf.exportProto("join", function (t) {
        return dh.apply(ph(this), arguments)
    });
    var mh = wf.aTypedArray;
    wf.exportProto("lastIndexOf", function (t) {
        return Zo.apply(mh(this), arguments)
    });
    var lh = ce.map,
        gh = wf.aTypedArray,
        yh = wf.aTypedArrayConstructor;
    wf.exportProto("map", function (t, e) {
        return lh(gh(this), t, 1 < arguments.length ? e : void 0, function (t, e) {
            return new (yh(di(t, t.constructor)))(e)
        })
    });
    var _h = Qo.left,
        Rh = wf.aTypedArray;
    wf.exportProto("reduce", function (t, e) {
        return _h(Rh(this), t, arguments.length, 1 < arguments.length ? e : void 0)
    });
    var vh = Qo.right,
        wh = wf.aTypedArray;
    wf.exportProto("reduceRight", function (t, e) {
        return vh(wh(this), t, arguments.length, 1 < arguments.length ? e : void 0)
    });
    var Sh = wf.aTypedArray,
        Mh = Math.floor;
    wf.exportProto("reverse", function () {
        for (var t, e = this, r = Sh(e).length, o = Mh(r / 2), n = 0; n < o;) t = e[n], e[n++] = e[--r], e[r] = t;
        return e
    });
    var bh = wf.aTypedArray,
        Ih = F(function () {
            new Int8Array(1).set({})
        });
    wf.exportProto("set", function (t, e) {
        bh(this);
        var r = Pf(1 < arguments.length ? e : void 0, 1),
            o = this.length,
            n = at(t),
            i = tt(n.length),
            s = 0;
        if (o < i + r) throw RangeError("Wrong length");
        for (; s < i;) this[r + s] = n[s++]
    }, Ih);
    var Bh = wf.aTypedArray,
        Th = wf.aTypedArrayConstructor,
        Oh = [].slice,
        Dh = F(function () {
            new Int8Array(1).slice()
        });
    wf.exportProto("slice", function (t, e) {
        for (var r = Oh.call(Bh(this), t, e), o = di(this, this.constructor), n = 0, i = r.length, s = new (Th(o))(i); n < i;) s[n] = r[n++];
        return s
    }, Dh);
    var Ph = ce.some,
        Ch = wf.aTypedArray;
    wf.exportProto("some", function (t, e) {
        return Ph(Ch(this), t, 1 < arguments.length ? e : void 0)
    });
    var kh = wf.aTypedArray,
        Lh = [].sort;
    wf.exportProto("sort", function (t) {
        return Lh.call(kh(this), t)
    });
    var Eh = wf.aTypedArray;
    wf.exportProto("subarray", function (t, e) {
        var r = Eh(this),
            o = r.length,
            n = et(t, o);
        return new (di(r, r.constructor))(r.buffer, r.byteOffset + n * r.BYTES_PER_ELEMENT, tt((void 0 === e ? o : et(e, o)) - n))
    });
    var Nh = j.Int8Array,
        Uh = wf.aTypedArray,
        Gh = [].toLocaleString,
        Fh = [].slice,
        jh = !!Nh && F(function () {
            Gh.call(new Nh(1))
        }),
        Ah = F(function () {
            return [1, 2].toLocaleString() != new Nh([1, 2]).toLocaleString()
        }) || !F(function () {
            Nh.prototype.toLocaleString.call([1, 2])
        });
    wf.exportProto("toLocaleString", function () {
        return Gh.apply(jh ? Fh.call(Uh(this)) : Uh(this), arguments)
    }, Ah);
    var xh = j.Uint8Array,
        qh = xh && xh.prototype,
        Hh = [].toString,
        Vh = [].join;
    F(function () {
        Hh.call({})
    }) && (Hh = function () {
        return Vh.call(this)
    }), wf.exportProto("toString", Hh, (qh || {}).toString != Hh);
    var Kh = X("Reflect", "apply"),
        Yh = Function.apply,
        Wh = !F(function () {
            Kh(function () { })
        });
    st({
        target: "Reflect",
        stat: !0,
        forced: Wh
    }, {
        apply: function (t, e, r) {
            return Ht(t), B(r), Kh ? Kh(t, e, r) : Yh.call(t, e, r)
        }
    });
    var Jh = X("Reflect", "construct"),
        zh = F(function () {
            function t() { }
            return !(Jh(function () { }, [], t) instanceof t)
        }),
        Zh = !F(function () {
            Jh(function () { })
        }),
        $h = zh || Zh;
    st({
        target: "Reflect",
        stat: !0,
        forced: $h,
        sham: $h
    }, {
        construct: function (t, e, r) {
            Ht(t), B(e);
            var o = arguments.length < 3 ? t : Ht(r);
            if (Zh && !zh) return Jh(t, e, o);
            if (t == o) {
                switch (e.length) {
                    case 0:
                        return new t;
                    case 1:
                        return new t(e[0]);
                    case 2:
                        return new t(e[0], e[1]);
                    case 3:
                        return new t(e[0], e[1], e[2]);
                    case 4:
                        return new t(e[0], e[1], e[2], e[3])
                }
                var n = [null];
                return n.push.apply(n, e), new (Jr.apply(t, n))
            }
            var i = o.prototype,
                s = jt(C(i) ? i : Object.prototype),
                a = Function.apply.call(t, s, e);
            return C(a) ? a : s
        }
    });
    var Xh = F(function () {
        Reflect.defineProperty(x.f({}, 1, {
            value: 1
        }), 1, {
            value: 2
        })
    });
    st({
        target: "Reflect",
        stat: !0,
        forced: Xh,
        sham: !A
    }, {
        defineProperty: function (t, e, r) {
            B(t);
            var o = f(e, !0);
            B(r);
            try {
                return x.f(t, o, r), !0
            } catch (t) {
                return !1
            }
        }
    });
    var Qh = L.f;
    st({
        target: "Reflect",
        stat: !0
    }, {
        deleteProperty: function (t, e) {
            var r = Qh(B(t), e);
            return !(r && !r.configurable) && delete t[e]
        }
    }), st({
        target: "Reflect",
        stat: !0
    }, {
        get: function t(e, r) {
            var o, n, i = arguments.length < 3 ? e : arguments[2];
            return B(e) === i ? e[r] : (o = L.f(e, r)) ? k(o, "value") ? o.value : void 0 === o.get ? void 0 : o.get.call(i) : C(n = wr(e)) ? t(n, r, i) : void 0
        }
    }), st({
        target: "Reflect",
        stat: !0,
        sham: !A
    }, {
        getOwnPropertyDescriptor: function (t, e) {
            return L.f(B(t), e)
        }
    }), st({
        target: "Reflect",
        stat: !0,
        sham: !_r
    }, {
        getPrototypeOf: function (t) {
            return wr(B(t))
        }
    }), st({
        target: "Reflect",
        stat: !0
    }, {
        has: function (t, e) {
            return e in t
        }
    });
    var tp = Object.isExtensible;
    st({
        target: "Reflect",
        stat: !0
    }, {
        isExtensible: function (t) {
            return B(t), !tp || tp(t)
        }
    }), st({
        target: "Reflect",
        stat: !0
    }, {
        ownKeys: Mt
    }), st({
        target: "Reflect",
        stat: !0,
        sham: !$e
    }, {
        preventExtensions: function (t) {
            B(t);
            try {
                var e = X("Object", "preventExtensions");
                return e && e(t), !0
            } catch (t) {
                return !1
            }
        }
    }), st({
        target: "Reflect",
        stat: !0
    }, {
        set: function t(e, r, o) {
            var n, i, s = arguments.length < 4 ? e : arguments[3],
                a = L.f(B(e), r);
            if (!a) {
                if (C(i = wr(e))) return t(i, r, o, s);
                a = P(0)
            }
            if (k(a, "value")) {
                if (!1 === a.writable || !C(s)) return !1;
                if (n = L.f(s, r)) {
                    if (n.get || n.set || !1 === n.writable) return !1;
                    n.value = o, x.f(s, r, n)
                } else x.f(s, r, P(0, o));
                return !0
            }
            return void 0 !== a.set && (a.set.call(s, o), !0)
        }
    }), Fr && st({
        target: "Reflect",
        stat: !0
    }, {
        setPrototypeOf: function (t, e) {
            B(t), Gr(e);
            try {
                return Fr(t, e), !0
            } catch (t) {
                return !1
            }
        }
    });

    function ep(t, e, r) {
        var o = op.get(t);
        if (!o) {
            if (!r) return;
            op.set(t, o = new Hc)
        }
        var n = o.get(e);
        if (!n) {
            if (!r) return;
            o.set(e, n = new Hc)
        }
        return n
    }
    var rp = O("metadata"),
        op = rp.store || (rp.store = new Qc),
        np = {
            store: op,
            getMap: ep,
            has: function (t, e, r) {
                var o = ep(e, r, !1);
                return void 0 !== o && o.has(t)
            },
            get: function (t, e, r) {
                var o = ep(e, r, !1);
                return void 0 === o ? void 0 : o.get(t)
            },
            set: function (t, e, r, o) {
                ep(r, o, !0).set(t, e)
            },
            keys: function (t, e) {
                var r = ep(t, e, !1),
                    o = [];
                return r && r.forEach(function (t, e) {
                    o.push(e)
                }), o
            },
            toKey: function (t) {
                return void 0 === t || "symbol" == typeof t ? t : String(t)
            }
        },
        ip = np.toKey,
        sp = np.set;
    st({
        target: "Reflect",
        stat: !0
    }, {
        defineMetadata: function (t, e, r, o) {
            var n = arguments.length < 4 ? void 0 : ip(o);
            sp(t, e, B(r), n)
        }
    });
    var ap = np.toKey,
        up = np.getMap,
        cp = np.store;
    st({
        target: "Reflect",
        stat: !0
    }, {
        deleteMetadata: function (t, e, r) {
            var o = arguments.length < 3 ? void 0 : ap(r),
                n = up(B(e), o, !1);
            if (void 0 === n || !n.delete(t)) return !1;
            if (n.size) return !0;
            var i = cp.get(e);
            return i.delete(o), !!i.size || cp.delete(e)
        }
    });
    var fp = np.has,
        hp = np.get,
        pp = np.toKey,
        dp = function (t, e, r) {
            if (fp(t, e, r)) return hp(t, e, r);
            var o = wr(e);
            return null !== o ? dp(t, o, r) : void 0
        };
    st({
        target: "Reflect",
        stat: !0
    }, {
        getMetadata: function (t, e, r) {
            var o = arguments.length < 3 ? void 0 : pp(r);
            return dp(t, B(e), o)
        }
    });
    var mp = np.keys,
        lp = np.toKey,
        gp = function (t, e) {
            var r = mp(t, e),
                o = wr(t);
            if (null === o) return r;
            var n = gp(o, e);
            return n.length ? r.length ? function (t) {
                var e = [];
                return dr(t, e.push, e), e
            }(new Vc(r.concat(n))) : n : r
        };
    st({
        target: "Reflect",
        stat: !0
    }, {
        getMetadataKeys: function (t, e) {
            var r = arguments.length < 2 ? void 0 : lp(e);
            return gp(B(t), r)
        }
    });
    var yp = np.get,
        _p = np.toKey;
    st({
        target: "Reflect",
        stat: !0
    }, {
        getOwnMetadata: function (t, e, r) {
            var o = arguments.length < 3 ? void 0 : _p(r);
            return yp(t, B(e), o)
        }
    });
    var Rp = np.keys,
        vp = np.toKey;
    st({
        target: "Reflect",
        stat: !0
    }, {
        getOwnMetadataKeys: function (t, e) {
            var r = arguments.length < 2 ? void 0 : vp(e);
            return Rp(B(t), r)
        }
    });
    var wp = np.has,
        Sp = np.toKey,
        Mp = function (t, e, r) {
            if (wp(t, e, r)) return !0;
            var o = wr(e);
            return null !== o && Mp(t, o, r)
        };
    st({
        target: "Reflect",
        stat: !0
    }, {
        hasMetadata: function (t, e, r) {
            var o = arguments.length < 3 ? void 0 : Sp(r);
            return Mp(t, B(e), o)
        }
    });
    var bp = np.has,
        Ip = np.toKey;
    st({
        target: "Reflect",
        stat: !0
    }, {
        hasOwnMetadata: function (t, e, r) {
            var o = arguments.length < 3 ? void 0 : Ip(r);
            return bp(t, B(e), o)
        }
    });
    var Bp = np.toKey,
        Tp = np.set;
    st({
        target: "Reflect",
        stat: !0
    }, {
        metadata: function (r, o) {
            return function (t, e) {
                Tp(r, o, B(t), Bp(e))
            }
        }
    }), st({
        target: "Math",
        stat: !0
    }, {
        iaddh: function (t, e, r, o) {
            var n = t >>> 0,
                i = r >>> 0;
            return (e >>> 0) + (o >>> 0) + ((n & i | (n | i) & ~(n + i >>> 0)) >>> 31) | 0
        }
    }), st({
        target: "Math",
        stat: !0
    }, {
        isubh: function (t, e, r, o) {
            var n = t >>> 0,
                i = r >>> 0;
            return (e >>> 0) - (o >>> 0) - ((~n & i | ~(n ^ i) & n - i >>> 0) >>> 31) | 0
        }
    }), st({
        target: "Math",
        stat: !0
    }, {
        imulh: function (t, e) {
            var r = +t,
                o = +e,
                n = 65535 & r,
                i = 65535 & o,
                s = r >> 16,
                a = o >> 16,
                u = (s * i >>> 0) + (n * i >>> 16);
            return s * a + (u >> 16) + ((n * a >>> 0) + (65535 & u) >> 16)
        }
    }), st({
        target: "Math",
        stat: !0
    }, {
        umulh: function (t, e) {
            var r = +t,
                o = +e,
                n = 65535 & r,
                i = 65535 & o,
                s = r >>> 16,
                a = o >>> 16,
                u = (s * i >>> 0) + (n * i >>> 16);
            return s * a + (u >>> 16) + ((n * a >>> 0) + (65535 & u) >>> 16)
        }
    });
    var Op = qn.charAt;
    st({
        target: "String",
        proto: !0
    }, {
        at: function (t) {
            return Op(this, t)
        }
    });

    function Dp(t) {
        return t + 22 + 75 * (t < 26)
    }

    function Pp(t, e, r) {
        var o = 0;
        for (t = r ? Yp(t / 700) : t >> 1, t += Yp(t / e); 455 < t; o += 36) t = Yp(t / 35);
        return Yp(o + 36 * t / (t + 38))
    }

    function Cp(t) {
        var e, r, o = [],
            n = (t = function (t) {
                for (var e = [], r = 0, o = t.length; r < o;) {
                    var n = t.charCodeAt(r++);
                    if (55296 <= n && n <= 56319 && r < o) {
                        var i = t.charCodeAt(r++);
                        56320 == (64512 & i) ? e.push(((1023 & n) << 10) + (1023 & i) + 65536) : (e.push(n), r--)
                    } else e.push(n)
                }
                return e
            }(t)).length,
            i = 128,
            s = 0,
            a = 72;
        for (e = 0; e < t.length; e++)(r = t[e]) < 128 && o.push(Wp(r));
        var u = o.length,
            c = u;
        for (u && o.push("-"); c < n;) {
            var f = qp;
            for (e = 0; e < t.length; e++) i <= (r = t[e]) && r < f && (f = r);
            var h = c + 1;
            if (f - i > Yp((qp - s) / h)) throw RangeError(Kp);
            for (s += (f - i) * h, i = f, e = 0; e < t.length; e++) {
                if ((r = t[e]) < i && ++s > qp) throw RangeError(Kp);
                if (r == i) {
                    for (var p = s, d = 36; ; d += 36) {
                        var m = d <= a ? 1 : a + 26 <= d ? 26 : d - a;
                        if (p < m) break;
                        var l = p - m,
                            g = 36 - m;
                        o.push(Wp(Dp(m + l % g))), p = Yp(l / g)
                    }
                    o.push(Wp(Dp(p))), a = Pp(s, h, c == u), s = 0, ++c
                }
            } ++s, ++i
        }
        return o.join("")
    }

    function kp(t) {
        var e = nr(t);
        if ("function" != typeof e) throw TypeError(String(t) + " is not iterable");
        return B(e.call(t))
    }

    function Lp(e) {
        try {
            return decodeURIComponent(e)
        } catch (t) {
            return e
        }
    }

    function Ep(t) {
        var e, r = t.replace(td, " "),
            o = 4;
        try {
            return decodeURIComponent(r)
        } catch (t) {
            for (; o;) r = r.replace((e = o--, ed[e - 1] || (ed[e - 1] = RegExp("((?:%[\\da-f]{2}){" + e + "})", "gi"))), Lp);
            return r
        }
    }

    function Np(t) {
        return od[t]
    }

    function Up(t) {
        return encodeURIComponent(t).replace(rd, Np)
    }

    function Gp(t, e) {
        if (e)
            for (var r, o, n = e.split("&"), i = 0; i < n.length;)(r = n[i++]).length && (o = r.split("="), t.push({
                key: Ep(o.shift()),
                value: Ep(o.join("="))
            }))
    }

    function Fp(t) {
        this.entries.length = 0, Gp(this.entries, t)
    }

    function jp(t, e) {
        if (t < e) throw TypeError("Not enough arguments")
    }
    var Ap = At("iterator"),
        xp = !F(function () {
            var t = new URL("b?e=1", "http://a"),
                e = t.searchParams;
            return t.pathname = "c%20d", !e.sort || "http://a/c%20d?e=1" !== t.href || "1" !== e.get("e") || "a=1" !== String(new URLSearchParams("?a=1")) || !e[Ap] || "a" !== new URL("https://a@b").username || "b" !== new URLSearchParams(new URLSearchParams("a=b")).get("a") || "xn--e1aybc" !== new URL("http://тест").host || "#%D0%B1" !== new URL("http://a#б").hash
        }),
        qp = 2147483647,
        Hp = /[^\0-\u007E]/,
        Vp = /[.\u3002\uFF0E\uFF61]/g,
        Kp = "Overflow: input needs wider integers to process",
        Yp = Math.floor,
        Wp = String.fromCharCode,
        Jp = At("iterator"),
        zp = "URLSearchParams",
        Zp = zp + "Iterator",
        $p = ct.set,
        Xp = ct.getterFor(zp),
        Qp = ct.getterFor(Zp),
        td = /\+/g,
        ed = Array(4),
        rd = /[!'()~]|%20/g,
        od = {
            "!": "%21",
            "'": "%27",
            "(": "%28",
            ")": "%29",
            "~": "%7E",
            "%20": "+"
        },
        nd = bn(function (t, e) {
            $p(this, {
                type: Zp,
                iterator: kp(Xp(t).entries),
                kind: e
            })
        }, "Iterator", function () {
            var t = Qp(this),
                e = t.kind,
                r = t.iterator.next(),
                o = r.value;
            return r.done || (r.value = "keys" === e ? o.key : "values" === e ? o.value : [o.key, o.value]), r
        }),
        id = function (t) {
            lu(this, id, zp);
            var e, r, o, n, i, s, a, u = 0 < arguments.length ? t : void 0,
                c = [];
            if ($p(this, {
                type: zp,
                entries: c,
                updateURL: function () { },
                updateSearchParams: Fp
            }), void 0 !== u)
                if (C(u))
                    if ("function" == typeof (e = nr(u)))
                        for (r = e.call(u); !(o = r.next()).done;) {
                            if ((i = (n = kp(B(o.value))).next()).done || (s = n.next()).done || !n.next().done) throw TypeError("Expected sequence with length 2");
                            c.push({
                                key: i.value + "",
                                value: s.value + ""
                            })
                        } else
                        for (a in u) k(u, a) && c.push({
                            key: a,
                            value: u[a] + ""
                        });
                else Gp(c, "string" == typeof u ? "?" === u.charAt(0) ? u.slice(1) : u : u + "")
        },
        sd = id.prototype;
    mu(sd, {
        append: function (t, e) {
            jp(arguments.length, 2);
            var r = Xp(this);
            r.entries.push({
                key: t + "",
                value: e + ""
            }), r.updateURL()
        },
        delete: function (t) {
            jp(arguments.length, 1);
            for (var e = Xp(this), r = e.entries, o = t + "", n = 0; n < r.length;) r[n].key === o ? r.splice(n, 1) : n++;
            e.updateURL()
        },
        get: function (t) {
            jp(arguments.length, 1);
            for (var e = Xp(this).entries, r = t + "", o = 0; o < e.length; o++)
                if (e[o].key === r) return e[o].value;
            return null
        },
        getAll: function (t) {
            jp(arguments.length, 1);
            for (var e = Xp(this).entries, r = t + "", o = [], n = 0; n < e.length; n++) e[n].key === r && o.push(e[n].value);
            return o
        },
        has: function (t) {
            jp(arguments.length, 1);
            for (var e = Xp(this).entries, r = t + "", o = 0; o < e.length;)
                if (e[o++].key === r) return !0;
            return !1
        },
        set: function (t, e) {
            jp(arguments.length, 1);
            for (var r, o = Xp(this), n = o.entries, i = !1, s = t + "", a = e + "", u = 0; u < n.length; u++)(r = n[u]).key === s && (i ? n.splice(u--, 1) : (i = !0, r.value = a));
            i || n.push({
                key: s,
                value: a
            }), o.updateURL()
        },
        sort: function () {
            var t, e, r, o = Xp(this),
                n = o.entries,
                i = n.slice();
            for (r = n.length = 0; r < i.length; r++) {
                for (t = i[r], e = 0; e < r; e++)
                    if (n[e].key > t.key) {
                        n.splice(e, 0, t);
                        break
                    }
                e === r && n.push(t)
            }
            o.updateURL()
        },
        forEach: function (t, e) {
            for (var r, o = Xp(this).entries, n = Vt(t, 1 < arguments.length ? e : void 0, 3), i = 0; i < o.length;) n((r = o[i++]).value, r.key, this)
        },
        keys: function () {
            return new nd(this, "keys")
        },
        values: function () {
            return new nd(this, "values")
        },
        entries: function () {
            return new nd(this, "entries")
        }
    }, {
        enumerable: !0
    }), ft(sd, Jp, sd.entries), ft(sd, "toString", function () {
        for (var t, e = Xp(this).entries, r = [], o = 0; o < e.length;) t = e[o++], r.push(Up(t.key) + "=" + Up(t.value));
        return r.join("&")
    }, {
        enumerable: !0
    }), qt(id, zp), st({
        global: !0,
        forced: !xp
    }, {
        URLSearchParams: id
    });

    function ad(t, e) {
        var r, o, n;
        if ("[" == e.charAt(0)) {
            if ("]" != e.charAt(e.length - 1)) return Td;
            if (!(r = xd(e.slice(1, -1)))) return Td;
            t.host = r
        } else if (Jd(t)) {
            if (e = function (t) {
                var e, r, o = [],
                    n = t.toLowerCase().replace(Vp, ".").split(".");
                for (e = 0; e < n.length; e++) r = n[e], o.push(Hp.test(r) ? "xn--" + Cp(r) : r);
                return o.join(".")
            }(e), Ud.test(e)) return Td;
            if (null === (r = Ad(e))) return Td;
            t.host = r
        } else {
            if (Gd.test(e)) return Td;
            for (r = "", o = ro(e), n = 0; n < o.length; n++) r += Yd(o[n], qd);
            t.host = r
        }
    }

    function ud(t) {
        var e, r, o, n;
        if ("number" == typeof t) {
            for (e = [], r = 0; r < 4; r++) e.unshift(t % 256), t = bd(t / 256);
            return e.join(".")
        }
        if ("object" != typeof t) return t;
        for (e = "", o = function (t) {
            for (var e = null, r = 1, o = null, n = 0, i = 0; i < 8; i++) 0 !== t[i] ? (r < n && (e = o, r = n), o = null, n = 0) : (null === o && (o = i), ++n);
            return r < n && (e = o, r = n), e
        }(t), r = 0; r < 8; r++) n && 0 === t[r] || (n = n && !1, o === r ? (e += r ? ":" : "::", n = !0) : (e += t[r].toString(16), r < 7 && (e += ":")));
        return "[" + e + "]"
    }

    function cd(t) {
        return "" != t.username || "" != t.password
    }

    function fd(t) {
        return !t.host || t.cannotBeABaseURL || "file" == t.scheme
    }

    function hd(t, e) {
        var r;
        return 2 == t.length && Dd.test(t.charAt(0)) && (":" == (r = t.charAt(1)) || !e && "|" == r)
    }

    function pd(t) {
        var e;
        return 1 < t.length && hd(t.slice(0, 2)) && (2 == t.length || "/" === (e = t.charAt(2)) || "\\" === e || "?" === e || "#" === e)
    }

    function dd(t) {
        var e = t.path,
            r = e.length;
        !r || "file" == t.scheme && 1 == r && hd(e[0], !0) || e.pop()
    }

    function md(t, e, r, o) {
        var n, i, s, a, u, c, f = r || zd,
            h = 0,
            p = "",
            d = !1,
            m = !1,
            l = !1;
        for (r || (t.scheme = "", t.username = "", t.password = "", t.host = null, t.port = null, t.path = [], t.query = null, t.fragment = null, t.cannotBeABaseURL = !1, e = e.replace(Fd, "")), e = e.replace(jd, ""), n = ro(e); h <= n.length;) {
            switch (i = n[h], f) {
                case zd:
                    if (!i || !Dd.test(i)) {
                        if (r) return Bd;
                        f = $d;
                        continue
                    }
                    p += i.toLowerCase(), f = Zd;
                    break;
                case Zd:
                    if (i && (Pd.test(i) || "+" == i || "-" == i || "." == i)) p += i.toLowerCase();
                    else {
                        if (":" != i) {
                            if (r) return Bd;
                            p = "", f = $d, h = 0;
                            continue
                        }
                        if (r && (Jd(t) != k(Wd, p) || "file" == p && (cd(t) || null !== t.port) || "file" == t.scheme && !t.host)) return;
                        if (t.scheme = p, r) return void (Jd(t) && Wd[t.scheme] == t.port && (t.port = null));
                        p = "", "file" == t.scheme ? f = um : Jd(t) && o && o.scheme == t.scheme ? f = Xd : Jd(t) ? f = rm : "/" == n[h + 1] ? (f = Qd, h++) : (t.cannotBeABaseURL = !0, t.path.push(""), f = dm)
                    }
                    break;
                case $d:
                    if (!o || o.cannotBeABaseURL && "#" != i) return Bd;
                    if (o.cannotBeABaseURL && "#" == i) {
                        t.scheme = o.scheme, t.path = o.path.slice(), t.query = o.query, t.fragment = "", t.cannotBeABaseURL = !0, f = lm;
                        break
                    }
                    f = "file" == o.scheme ? um : tm;
                    continue;
                case Xd:
                    if ("/" != i || "/" != n[h + 1]) {
                        f = tm;
                        continue
                    }
                    f = om, h++;
                    break;
                case Qd:
                    if ("/" == i) {
                        f = nm;
                        break
                    }
                    f = pm;
                    continue;
                case tm:
                    if (t.scheme = o.scheme, i == gd) t.username = o.username, t.password = o.password, t.host = o.host, t.port = o.port, t.path = o.path.slice(), t.query = o.query;
                    else if ("/" == i || "\\" == i && Jd(t)) f = em;
                    else if ("?" == i) t.username = o.username, t.password = o.password, t.host = o.host, t.port = o.port, t.path = o.path.slice(), t.query = "", f = mm;
                    else {
                        if ("#" != i) {
                            t.username = o.username, t.password = o.password, t.host = o.host, t.port = o.port, t.path = o.path.slice(), t.path.pop(), f = pm;
                            continue
                        }
                        t.username = o.username, t.password = o.password, t.host = o.host, t.port = o.port, t.path = o.path.slice(), t.query = o.query, t.fragment = "", f = lm
                    }
                    break;
                case em:
                    if (!Jd(t) || "/" != i && "\\" != i) {
                        if ("/" != i) {
                            t.username = o.username, t.password = o.password, t.host = o.host, t.port = o.port, f = pm;
                            continue
                        }
                        f = nm
                    } else f = om;
                    break;
                case rm:
                    if (f = om, "/" != i || "/" != p.charAt(h + 1)) continue;
                    h++;
                    break;
                case om:
                    if ("/" == i || "\\" == i) break;
                    f = nm;
                    continue;
                case nm:
                    if ("@" == i) {
                        d && (p = "%40" + p), d = !0, s = ro(p);
                        for (var g = 0; g < s.length; g++) {
                            var y = s[g];
                            if (":" != y || l) {
                                var _ = Yd(y, Kd);
                                l ? t.password += _ : t.username += _
                            } else l = !0
                        }
                        p = ""
                    } else if (i == gd || "/" == i || "?" == i || "#" == i || "\\" == i && Jd(t)) {
                        if (d && "" == p) return "Invalid authority";
                        h -= ro(p).length + 1, p = "", f = im
                    } else p += i;
                    break;
                case im:
                case sm:
                    if (r && "file" == t.scheme) {
                        f = fm;
                        continue
                    }
                    if (":" != i || m) {
                        if (i == gd || "/" == i || "?" == i || "#" == i || "\\" == i && Jd(t)) {
                            if (Jd(t) && "" == p) return Td;
                            if (r && "" == p && (cd(t) || null !== t.port)) return;
                            if (a = ad(t, p)) return a;
                            if (p = "", f = hm, r) return;
                            continue
                        }
                        "[" == i ? m = !0 : "]" == i && (m = !1), p += i
                    } else {
                        if ("" == p) return Td;
                        if (a = ad(t, p)) return a;
                        if (p = "", f = am, r == sm) return
                    }
                    break;
                case am:
                    if (!Cd.test(i)) {
                        if (i == gd || "/" == i || "?" == i || "#" == i || "\\" == i && Jd(t) || r) {
                            if ("" != p) {
                                var R = parseInt(p, 10);
                                if (65535 < R) return Od;
                                t.port = Jd(t) && R === Wd[t.scheme] ? null : R, p = ""
                            }
                            if (r) return;
                            f = hm;
                            continue
                        }
                        return Od
                    }
                    p += i;
                    break;
                case um:
                    if (t.scheme = "file", "/" == i || "\\" == i) f = cm;
                    else {
                        if (!o || "file" != o.scheme) {
                            f = pm;
                            continue
                        }
                        if (i == gd) t.host = o.host, t.path = o.path.slice(), t.query = o.query;
                        else if ("?" == i) t.host = o.host, t.path = o.path.slice(), t.query = "", f = mm;
                        else {
                            if ("#" != i) {
                                pd(n.slice(h).join("")) || (t.host = o.host, t.path = o.path.slice(), dd(t)), f = pm;
                                continue
                            }
                            t.host = o.host, t.path = o.path.slice(), t.query = o.query, t.fragment = "", f = lm
                        }
                    }
                    break;
                case cm:
                    if ("/" == i || "\\" == i) {
                        f = fm;
                        break
                    }
                    o && "file" == o.scheme && !pd(n.slice(h).join("")) && (hd(o.path[0], !0) ? t.path.push(o.path[0]) : t.host = o.host), f = pm;
                    continue;
                case fm:
                    if (i == gd || "/" == i || "\\" == i || "?" == i || "#" == i) {
                        if (!r && hd(p)) f = pm;
                        else if ("" == p) {
                            if (t.host = "", r) return;
                            f = hm
                        } else {
                            if (a = ad(t, p)) return a;
                            if ("localhost" == t.host && (t.host = ""), r) return;
                            p = "", f = hm
                        }
                        continue
                    }
                    p += i;
                    break;
                case hm:
                    if (Jd(t)) {
                        if (f = pm, "/" != i && "\\" != i) continue
                    } else if (r || "?" != i)
                        if (r || "#" != i) {
                            if (i != gd && (f = pm, "/" != i)) continue
                        } else t.fragment = "", f = lm;
                    else t.query = "", f = mm;
                    break;
                case pm:
                    if (i == gd || "/" == i || "\\" == i && Jd(t) || !r && ("?" == i || "#" == i)) {
                        if (".." === (c = (c = p).toLowerCase()) || "%2e." === c || ".%2e" === c || "%2e%2e" === c ? (dd(t), "/" == i || "\\" == i && Jd(t) || t.path.push("")) : "." === (u = p) || "%2e" === u.toLowerCase() ? "/" == i || "\\" == i && Jd(t) || t.path.push("") : ("file" == t.scheme && !t.path.length && hd(p) && (t.host && (t.host = ""), p = p.charAt(0) + ":"), t.path.push(p)), p = "", "file" == t.scheme && (i == gd || "?" == i || "#" == i))
                            for (; 1 < t.path.length && "" === t.path[0];) t.path.shift();
                        "?" == i ? (t.query = "", f = mm) : "#" == i && (t.fragment = "", f = lm)
                    } else p += Yd(i, Vd);
                    break;
                case dm:
                    "?" == i ? (t.query = "", f = mm) : "#" == i ? (t.fragment = "", f = lm) : i != gd && (t.path[0] += Yd(i, qd));
                    break;
                case mm:
                    r || "#" != i ? i != gd && ("'" == i && Jd(t) ? t.query += "%27" : t.query += "#" == i ? "%23" : Yd(i, qd)) : (t.fragment = "", f = lm);
                    break;
                case lm:
                    i != gd && (t.fragment += Yd(i, Hd))
            }
            h++
        }
    }

    function ld(t, e) {
        return {
            get: t,
            set: e,
            configurable: !0,
            enumerable: !0
        }
    }
    var gd, yd = {
        URLSearchParams: id,
        getState: Xp
    },
        _d = qn.codeAt,
        Rd = j.URL,
        vd = yd.URLSearchParams,
        wd = yd.getState,
        Sd = ct.set,
        Md = ct.getterFor("URL"),
        bd = Math.floor,
        Id = Math.pow,
        Bd = "Invalid scheme",
        Td = "Invalid host",
        Od = "Invalid port",
        Dd = /[A-Za-z]/,
        Pd = /[\d+\-.A-Za-z]/,
        Cd = /\d/,
        kd = /^(0x|0X)/,
        Ld = /^[0-7]+$/,
        Ed = /^\d+$/,
        Nd = /^[\dA-Fa-f]+$/,
        Ud = /[\u0000\u0009\u000A\u000D #%/:?@[\\]]/,
        Gd = /[\u0000\u0009\u000A\u000D #/:?@[\\]]/,
        Fd = /^[\u0000-\u001F ]+|[\u0000-\u001F ]+$/g,
        jd = /[\u0009\u000A\u000D]/g,
        Ad = function (t) {
            var e, r, o, n, i, s, a, u = t.split(".");
            if (u.length && "" == u[u.length - 1] && u.pop(), 4 < (e = u.length)) return t;
            for (r = [], o = 0; o < e; o++) {
                if ("" == (n = u[o])) return t;
                if (i = 10, 1 < n.length && "0" == n.charAt(0) && (i = kd.test(n) ? 16 : 8, n = n.slice(8 == i ? 1 : 2)), "" === n) s = 0;
                else {
                    if (!(10 == i ? Ed : 8 == i ? Ld : Nd).test(n)) return t;
                    s = parseInt(n, i)
                }
                r.push(s)
            }
            for (o = 0; o < e; o++)
                if (s = r[o], o == e - 1) {
                    if (s >= Id(256, 5 - e)) return null
                } else if (255 < s) return null;
            for (a = r.pop(), o = 0; o < r.length; o++) a += r[o] * Id(256, 3 - o);
            return a
        },
        xd = function (t) {
            function e() {
                return t.charAt(p)
            }
            var r, o, n, i, s, a, u, c = [0, 0, 0, 0, 0, 0, 0, 0],
                f = 0,
                h = null,
                p = 0;
            if (":" == e()) {
                if (":" != t.charAt(1)) return;
                p += 2, h = ++f
            }
            for (; e();) {
                if (8 == f) return;
                if (":" != e()) {
                    for (r = o = 0; o < 4 && Nd.test(e());) r = 16 * r + parseInt(e(), 16), p++, o++;
                    if ("." == e()) {
                        if (0 == o) return;
                        if (p -= o, 6 < f) return;
                        for (n = 0; e();) {
                            if (i = null, 0 < n) {
                                if (!("." == e() && n < 4)) return;
                                p++
                            }
                            if (!Cd.test(e())) return;
                            for (; Cd.test(e());) {
                                if (s = parseInt(e(), 10), null === i) i = s;
                                else {
                                    if (0 == i) return;
                                    i = 10 * i + s
                                }
                                if (255 < i) return;
                                p++
                            }
                            c[f] = 256 * c[f] + i, 2 != ++n && 4 != n || f++
                        }
                        if (4 != n) return;
                        break
                    }
                    if (":" == e()) {
                        if (p++, !e()) return
                    } else if (e()) return;
                    c[f++] = r
                } else {
                    if (null !== h) return;
                    p++, h = ++f
                }
            }
            if (null !== h)
                for (a = f - h, f = 7; 0 != f && 0 < a;) u = c[f], c[f--] = c[h + a - 1], c[h + --a] = u;
            else if (8 != f) return;
            return c
        },
        qd = {},
        Hd = Ye({}, qd, {
            " ": 1,
            '"': 1,
            "<": 1,
            ">": 1,
            "`": 1
        }),
        Vd = Ye({}, Hd, {
            "#": 1,
            "?": 1,
            "{": 1,
            "}": 1
        }),
        Kd = Ye({}, Vd, {
            "/": 1,
            ":": 1,
            ";": 1,
            "=": 1,
            "@": 1,
            "[": 1,
            "\\": 1,
            "]": 1,
            "^": 1,
            "|": 1
        }),
        Yd = function (t, e) {
            var r = _d(t, 0);
            return 32 < r && r < 127 && !k(e, t) ? t : encodeURIComponent(t)
        },
        Wd = {
            ftp: 21,
            file: null,
            gopher: 70,
            http: 80,
            https: 443,
            ws: 80,
            wss: 443
        },
        Jd = function (t) {
            return k(Wd, t.scheme)
        },
        zd = {},
        Zd = {},
        $d = {},
        Xd = {},
        Qd = {},
        tm = {},
        em = {},
        rm = {},
        om = {},
        nm = {},
        im = {},
        sm = {},
        am = {},
        um = {},
        cm = {},
        fm = {},
        hm = {},
        pm = {},
        dm = {},
        mm = {},
        lm = {},
        gm = function (t, e) {
            var r, o, n = lu(this, gm, "URL"),
                i = 1 < arguments.length ? e : void 0,
                s = String(t),
                a = Sd(n, {
                    type: "URL"
                });
            if (void 0 !== i)
                if (i instanceof gm) r = Md(i);
                else if (o = md(r = {}, String(i))) throw TypeError(o);
            if (o = md(a, s, null, r)) throw TypeError(o);
            var u = a.searchParams = new vd,
                c = wd(u);
            c.updateSearchParams(a.query), c.updateURL = function () {
                a.query = String(u) || null
            }, A || (n.href = _m.call(n), n.origin = Rm.call(n), n.protocol = vm.call(n), n.username = wm.call(n), n.password = Sm.call(n), n.host = Mm.call(n), n.hostname = bm.call(n), n.port = Im.call(n), n.pathname = Bm.call(n), n.search = Tm.call(n), n.searchParams = Om.call(n), n.hash = Dm.call(n))
        },
        ym = gm.prototype,
        _m = function () {
            var t = Md(this),
                e = t.scheme,
                r = t.username,
                o = t.password,
                n = t.host,
                i = t.port,
                s = t.path,
                a = t.query,
                u = t.fragment,
                c = e + ":";
            return null !== n ? (c += "//", cd(t) && (c += r + (o ? ":" + o : "") + "@"), c += ud(n), null !== i && (c += ":" + i)) : "file" == e && (c += "//"), c += t.cannotBeABaseURL ? s[0] : s.length ? "/" + s.join("/") : "", null !== a && (c += "?" + a), null !== u && (c += "#" + u), c
        },
        Rm = function () {
            var t = Md(this),
                e = t.scheme,
                r = t.port;
            if ("blob" == e) try {
                return new URL(e.path[0]).origin
            } catch (t) {
                return "null"
            }
            return "file" != e && Jd(t) ? e + "://" + ud(t.host) + (null !== r ? ":" + r : "") : "null"
        },
        vm = function () {
            return Md(this).scheme + ":"
        },
        wm = function () {
            return Md(this).username
        },
        Sm = function () {
            return Md(this).password
        },
        Mm = function () {
            var t = Md(this),
                e = t.host,
                r = t.port;
            return null === e ? "" : null === r ? ud(e) : ud(e) + ":" + r
        },
        bm = function () {
            var t = Md(this).host;
            return null === t ? "" : ud(t)
        },
        Im = function () {
            var t = Md(this).port;
            return null === t ? "" : String(t)
        },
        Bm = function () {
            var t = Md(this),
                e = t.path;
            return t.cannotBeABaseURL ? e[0] : e.length ? "/" + e.join("/") : ""
        },
        Tm = function () {
            var t = Md(this).query;
            return t ? "?" + t : ""
        },
        Om = function () {
            return Md(this).searchParams
        },
        Dm = function () {
            var t = Md(this).fragment;
            return t ? "#" + t : ""
        };
    if (A && Et(ym, {
        href: ld(_m, function (t) {
            var e = Md(this),
                r = String(t),
                o = md(e, r);
            if (o) throw TypeError(o);
            wd(e.searchParams).updateSearchParams(e.query)
        }),
        origin: ld(Rm),
        protocol: ld(vm, function (t) {
            var e = Md(this);
            md(e, String(t) + ":", zd)
        }),
        username: ld(wm, function (t) {
            var e = Md(this),
                r = ro(String(t));
            if (!fd(e)) {
                e.username = "";
                for (var o = 0; o < r.length; o++) e.username += Yd(r[o], Kd)
            }
        }),
        password: ld(Sm, function (t) {
            var e = Md(this),
                r = ro(String(t));
            if (!fd(e)) {
                e.password = "";
                for (var o = 0; o < r.length; o++) e.password += Yd(r[o], Kd)
            }
        }),
        host: ld(Mm, function (t) {
            var e = Md(this);
            e.cannotBeABaseURL || md(e, String(t), im)
        }),
        hostname: ld(bm, function (t) {
            var e = Md(this);
            e.cannotBeABaseURL || md(e, String(t), sm)
        }),
        port: ld(Im, function (t) {
            var e = Md(this);
            fd(e) || ("" == (t = String(t)) ? e.port = null : md(e, t, am))
        }),
        pathname: ld(Bm, function (t) {
            var e = Md(this);
            e.cannotBeABaseURL || (e.path = [], md(e, t + "", hm))
        }),
        search: ld(Tm, function (t) {
            var e = Md(this);
            "" == (t = String(t)) ? e.query = null : ("?" == t.charAt(0) && (t = t.slice(1)), e.query = "", md(e, t, mm)), wd(e.searchParams).updateSearchParams(e.query)
        }),
        searchParams: ld(Om),
        hash: ld(Dm, function (t) {
            var e = Md(this);
            "" != (t = String(t)) ? ("#" == t.charAt(0) && (t = t.slice(1)), e.fragment = "", md(e, t, lm)) : e.fragment = null
        })
    }), ft(ym, "toJSON", function () {
        return _m.call(this)
    }, {
        enumerable: !0
    }), ft(ym, "toString", function () {
        return _m.call(this)
    }, {
        enumerable: !0
    }), Rd) {
        var Pm = Rd.createObjectURL,
            Cm = Rd.revokeObjectURL;
        Pm && ft(gm, "createObjectURL", function (t) {
            return Pm.apply(Rd, arguments)
        }), Cm && ft(gm, "revokeObjectURL", function (t) {
            return Cm.apply(Rd, arguments)
        })
    }
    qt(gm, "URL"), st({
        global: !0,
        forced: !xp,
        sham: !A
    }, {
        URL: gm
    }), st({
        target: "URL",
        proto: !0,
        enumerable: !0
    }, {
        toJSON: function () {
            return URL.prototype.toString.call(this)
        }
    });
    var km = x.f;
    !A || "lastIndex" in [] || (km(Array.prototype, "lastIndex", {
        configurable: !0,
        get: function () {
            var t = at(this),
                e = tt(t.length);
            return 0 == e ? 0 : e - 1
        }
    }), Mo("lastIndex"));
    var Lm = x.f;
    !A || "lastItem" in [] || (Lm(Array.prototype, "lastItem", {
        configurable: !0,
        get: function () {
            var t = at(this),
                e = tt(t.length);
            return 0 == e ? void 0 : t[e - 1]
        },
        set: function (t) {
            var e = at(this),
                r = tt(e.length);
            return e[0 == r ? 0 : r - 1] = t
        }
    }), Mo("lastItem")), st({
        target: "Map",
        stat: !0
    }, {
        groupBy: function (t, r) {
            var o = new this;
            Ht(r);
            var n = Ht(o.has),
                i = Ht(o.get),
                s = Ht(o.set);
            return dr(t, function (t) {
                var e = r(t);
                n.call(o, e) ? i.call(o, e).push(t) : s.call(o, e, [t])
            }), o
        }
    }), st({
        target: "Map",
        stat: !0
    }, {
        keyBy: function (t, e) {
            var r = new this;
            Ht(e);
            var o = Ht(r.set);
            return dr(t, function (t) {
                o.call(r, e(t), t)
            }), r
        }
    });

    function Em() {
        for (var t, e = B(this), r = Ht(e.delete), o = !0, n = 0, i = arguments.length; n < i; n++) t = r.call(e, arguments[n]), o = o && t;
        return !!o
    }
    st({
        target: "Map",
        proto: !0,
        real: !0,
        forced: !1
    }, {
        deleteAll: function () {
            return Em.apply(this, arguments)
        }
    });

    function Nm(t) {
        return Map.prototype.entries.call(t)
    }
    st({
        target: "Map",
        proto: !0,
        real: !0,
        forced: !1
    }, {
        every: function (t, e) {
            var r = B(this),
                o = Nm(r),
                n = Vt(t, 1 < arguments.length ? e : void 0, 3);
            return !dr(o, function (t, e) {
                if (!n(e, t, r)) return dr.stop()
            }, void 0, !0, !0).stopped
        }
    }), st({
        target: "Map",
        proto: !0,
        real: !0,
        forced: !1
    }, {
        filter: function (t, e) {
            var r = B(this),
                o = Nm(r),
                n = Vt(t, 1 < arguments.length ? e : void 0, 3),
                i = new (di(r, X("Map"))),
                s = Ht(i.set);
            return dr(o, function (t, e) {
                n(e, t, r) && s.call(i, t, e)
            }, void 0, !0, !0), i
        }
    }), st({
        target: "Map",
        proto: !0,
        real: !0,
        forced: !1
    }, {
        find: function (t, e) {
            var r = B(this),
                o = Nm(r),
                n = Vt(t, 1 < arguments.length ? e : void 0, 3);
            return dr(o, function (t, e) {
                if (n(e, t, r)) return dr.stop(e)
            }, void 0, !0, !0).result
        }
    }), st({
        target: "Map",
        proto: !0,
        real: !0,
        forced: !1
    }, {
        findKey: function (t, e) {
            var r = B(this),
                o = Nm(r),
                n = Vt(t, 1 < arguments.length ? e : void 0, 3);
            return dr(o, function (t, e) {
                if (n(e, t, r)) return dr.stop(t)
            }, void 0, !0, !0).result
        }
    });
    st({
        target: "Map",
        proto: !0,
        real: !0,
        forced: !1
    }, {
        includes: function (r) {
            return dr(Nm(B(this)), function (t, e) {
                if (function (t, e) {
                    return t === e || t != t && e != e
                }(e, r)) return dr.stop()
            }, void 0, !0, !0).stopped
        }
    }), st({
        target: "Map",
        proto: !0,
        real: !0,
        forced: !1
    }, {
        keyOf: function (r) {
            return dr(Nm(B(this)), function (t, e) {
                if (e === r) return dr.stop(t)
            }, void 0, !0, !0).result
        }
    }), st({
        target: "Map",
        proto: !0,
        real: !0,
        forced: !1
    }, {
        mapKeys: function (t, e) {
            var r = B(this),
                o = Nm(r),
                n = Vt(t, 1 < arguments.length ? e : void 0, 3),
                i = new (di(r, X("Map"))),
                s = Ht(i.set);
            return dr(o, function (t, e) {
                s.call(i, n(e, t, r), e)
            }, void 0, !0, !0), i
        }
    }), st({
        target: "Map",
        proto: !0,
        real: !0,
        forced: !1
    }, {
        mapValues: function (t, e) {
            var r = B(this),
                o = Nm(r),
                n = Vt(t, 1 < arguments.length ? e : void 0, 3),
                i = new (di(r, X("Map"))),
                s = Ht(i.set);
            return dr(o, function (t, e) {
                s.call(i, t, n(e, t, r))
            }, void 0, !0, !0), i
        }
    }), st({
        target: "Map",
        proto: !0,
        real: !0,
        forced: !1
    }, {
        merge: function (t) {
            for (var e = B(this), r = Ht(e.set), o = 0; o < arguments.length;) dr(arguments[o++], r, e, !0);
            return e
        }
    }), st({
        target: "Map",
        proto: !0,
        real: !0,
        forced: !1
    }, {
        reduce: function (r, t) {
            var o, e, n = B(this),
                i = Nm(n);
            if (Ht(r), 1 < arguments.length) o = t;
            else {
                if ((e = i.next()).done) throw TypeError("Reduce of empty map with no initial value");
                o = e.value[1]
            }
            return dr(i, function (t, e) {
                o = r(o, e, t, n)
            }, void 0, !0, !0), o
        }
    }), st({
        target: "Map",
        proto: !0,
        real: !0,
        forced: !1
    }, {
        some: function (t, e) {
            var r = B(this),
                o = Nm(r),
                n = Vt(t, 1 < arguments.length ? e : void 0, 3);
            return dr(o, function (t, e) {
                if (n(e, t, r)) return dr.stop()
            }, void 0, !0, !0).stopped
        }
    }), st({
        target: "Map",
        proto: !0,
        real: !0,
        forced: !1
    }, {
        update: function (t, e, r) {
            var o = B(this),
                n = arguments.length;
            Ht(e);
            var i = o.has(t);
            if (!i && n < 3) throw TypeError("Updating absent value");
            var s = i ? o.get(t) : Ht(2 < n ? r : void 0)(t, o);
            return o.set(t, e(s, t, o)), o
        }
    });

    function Um() {
        for (var t = B(this), e = Ht(t.add), r = 0, o = arguments.length; r < o; r++) e.call(t, arguments[r]);
        return t
    }
    st({
        target: "Set",
        proto: !0,
        real: !0,
        forced: !1
    }, {
        addAll: function () {
            return Um.apply(this, arguments)
        }
    }), st({
        target: "Set",
        proto: !0,
        real: !0,
        forced: !1
    }, {
        deleteAll: function () {
            return Em.apply(this, arguments)
        }
    });

    function Gm(t) {
        return Set.prototype.values.call(t)
    }
    st({
        target: "Set",
        proto: !0,
        real: !0,
        forced: !1
    }, {
        every: function (t, e) {
            var r = B(this),
                o = Gm(r),
                n = Vt(t, 1 < arguments.length ? e : void 0, 3);
            return !dr(o, function (t) {
                if (!n(t, t, r)) return dr.stop()
            }, void 0, !1, !0).stopped
        }
    }), st({
        target: "Set",
        proto: !0,
        real: !0,
        forced: !1
    }, {
        filter: function (t, e) {
            var r = B(this),
                o = Gm(r),
                n = Vt(t, 1 < arguments.length ? e : void 0, 3),
                i = new (di(r, X("Set"))),
                s = Ht(i.add);
            return dr(o, function (t) {
                n(t, t, r) && s.call(i, t)
            }, void 0, !1, !0), i
        }
    }), st({
        target: "Set",
        proto: !0,
        real: !0,
        forced: !1
    }, {
        find: function (t, e) {
            var r = B(this),
                o = Gm(r),
                n = Vt(t, 1 < arguments.length ? e : void 0, 3);
            return dr(o, function (t) {
                if (n(t, t, r)) return dr.stop(t)
            }, void 0, !1, !0).result
        }
    }), st({
        target: "Set",
        proto: !0,
        real: !0,
        forced: !1
    }, {
        join: function (t) {
            var e = B(this),
                r = Gm(e),
                o = void 0 === t ? "," : String(t),
                n = [];
            return dr(r, n.push, n, !1, !0), n.join(o)
        }
    }), st({
        target: "Set",
        proto: !0,
        real: !0,
        forced: !1
    }, {
        map: function (t, e) {
            var r = B(this),
                o = Gm(r),
                n = Vt(t, 1 < arguments.length ? e : void 0, 3),
                i = new (di(r, X("Set"))),
                s = Ht(i.add);
            return dr(o, function (t) {
                s.call(i, n(t, t, r))
            }, void 0, !1, !0), i
        }
    }), st({
        target: "Set",
        proto: !0,
        real: !0,
        forced: !1
    }, {
        reduce: function (e, t) {
            var r, o, n = B(this),
                i = Gm(n);
            if (Ht(e), 1 < arguments.length) r = t;
            else {
                if ((o = i.next()).done) throw TypeError("Reduce of empty set with no initial value");
                r = o.value
            }
            return dr(i, function (t) {
                r = e(r, t, t, n)
            }, void 0, !1, !0), r
        }
    }), st({
        target: "Set",
        proto: !0,
        real: !0,
        forced: !1
    }, {
        some: function (t, e) {
            var r = B(this),
                o = Gm(r),
                n = Vt(t, 1 < arguments.length ? e : void 0, 3);
            return dr(o, function (t) {
                if (n(t, t, r)) return dr.stop()
            }, void 0, !1, !0).stopped
        }
    }), st({
        target: "WeakMap",
        proto: !0,
        real: !0,
        forced: !1
    }, {
        deleteAll: function () {
            return Em.apply(this, arguments)
        }
    }), st({
        target: "WeakSet",
        proto: !0,
        real: !0,
        forced: !1
    }, {
        addAll: function () {
            return Um.apply(this, arguments)
        }
    }), st({
        target: "WeakSet",
        proto: !0,
        real: !0,
        forced: !1
    }, {
        deleteAll: function () {
            return Em.apply(this, arguments)
        }
    });

    function Fm(t, e, r) {
        var o, n, i, s, a = arguments.length,
            u = 1 < a ? e : void 0;
        return Ht(this), (o = void 0 !== u) && Ht(u), null == t ? new this : (n = [], o ? (i = 0, s = Vt(u, 2 < a ? r : void 0, 2), dr(t, function (t) {
            n.push(s(t, i++))
        })) : dr(t, n.push, n), new this(n))
    }
    st({
        target: "Map",
        stat: !0
    }, {
        from: Fm
    });

    function jm() {
        for (var t = arguments.length, e = new Array(t); t--;) e[t] = arguments[t];
        return new this(e)
    }
    st({
        target: "Map",
        stat: !0
    }, {
        of: jm
    }), st({
        target: "Set",
        stat: !0
    }, {
        from: Fm
    }), st({
        target: "Set",
        stat: !0
    }, {
        of: jm
    }), st({
        target: "WeakMap",
        stat: !0
    }, {
        from: Fm
    }), st({
        target: "WeakMap",
        stat: !0
    }, {
        of: jm
    }), st({
        target: "WeakSet",
        stat: !0
    }, {
        from: Fm
    }), st({
        target: "WeakSet",
        stat: !0
    }, {
        of: jm
    });

    function Am() {
        this.object = null, this.symbol = null, this.primitives = null, this.objectsByIndex = jt(null)
    }
    Am.prototype.get = function (t, e) {
        return this[t] || (this[t] = e())
    }, Am.prototype.next = function (t, e, r) {
        var o = r ? this.objectsByIndex[t] || (this.objectsByIndex[t] = new Qc) : this.primitives || (this.primitives = new Hc),
            n = o.get(e);
        return n || o.set(e, n = new Am), n
    };

    function xm() {
        var t, e, r = Hm,
            o = arguments.length;
        for (t = 0; t < o; t++) C(e = arguments[t]) && (r = r.next(t, e, !0));
        if (this === Object && r === Hm) throw TypeError("Composite keys must contain a non-primitive component");
        for (t = 0; t < o; t++) C(e = arguments[t]) || (r = r.next(t, e, !1));
        return r
    }

    function qm() {
        var t = X("Object", "freeze");
        return t ? t(jt(null)) : jt(null)
    }
    var Hm = new Am;
    st({
        global: !0
    }, {
        compositeKey: function () {
            return xm.apply(Object, arguments).get("object", qm)
        }
    }), st({
        global: !0
    }, {
        compositeSymbol: function (t) {
            return 1 === arguments.length && "string" == typeof t ? X("Symbol").for(t) : xm.apply(null, arguments).get("symbol", X("Symbol"))
        }
    }), st({
        target: "Map",
        proto: !0,
        real: !0,
        forced: !1
    }, {
        updateOrInsert: function (t, e, r) {
            var o = B(this);
            Ht(e), Ht(r);
            var n = o.has(t) ? e(o.get(t)) : r();
            return o.set(t, n), n
        }
    });
    var Vm = Math.min,
        Km = Math.max;
    st({
        target: "Math",
        stat: !0
    }, {
        clamp: function (t, e, r) {
            return Vm(r, Km(e, t))
        }
    }), st({
        target: "Math",
        stat: !0
    }, {
        DEG_PER_RAD: Math.PI / 180
    });
    var Ym = 180 / Math.PI;
    st({
        target: "Math",
        stat: !0
    }, {
        degrees: function (t) {
            return t * Ym
        }
    });
    var Wm = Math.scale || function (t, e, r, o, n) {
        return 0 === arguments.length || t != t || e != e || r != r || o != o || n != n ? NaN : t === 1 / 0 || t === -1 / 0 ? t : (t - e) * (n - o) / (r - e) + o
    };
    st({
        target: "Math",
        stat: !0
    }, {
        fscale: function (t, e, r, o, n) {
            return Ua(Wm(t, e, r, o, n))
        }
    }), st({
        target: "Math",
        stat: !0
    }, {
        RAD_PER_DEG: 180 / Math.PI
    });
    var Jm = Math.PI / 180;
    st({
        target: "Math",
        stat: !0
    }, {
        radians: function (t) {
            return t * Jm
        }
    }), st({
        target: "Math",
        stat: !0
    }, {
        scale: Wm
    }), st({
        target: "Math",
        stat: !0
    }, {
        signbit: function (t) {
            return (t = +t) != t ? t : 0 == t ? 1 / t == 1 / 0 : 0 < t
        }
    });
    var zm = "Invalid number representation",
        Zm = /^[\da-z]+$/;
    st({
        target: "Number",
        stat: !0
    }, {
        fromString: function (t, e) {
            var r, o, n = 1;
            if ("string" != typeof t) throw TypeError(zm);
            if (!t.length) throw SyntaxError(zm);
            if ("-" == t.charAt(0) && (n = -1, !(t = t.slice(1)).length)) throw SyntaxError(zm);
            if ((r = void 0 === e ? 10 : Q(e)) < 2 || 36 < r) throw RangeError("Invalid radix");
            if (!Zm.test(t) || (o = Cs(t, r)).toString(r) !== t) throw SyntaxError(zm);
            return n * o
        }
    });

    function $m(t) {
        return null == t ? void 0 : Ht(t)
    }

    function Xm(t) {
        var e = t.cleanup;
        if (e) {
            t.cleanup = void 0;
            try {
                e()
            } catch (t) {
                Xu(t)
            }
        }
    }

    function Qm(t) {
        return void 0 === t.observer
    }

    function tl(t, e) {
        if (!A) {
            t.closed = !0;
            var r = e.subscriptionObserver;
            r && (r.closed = !0)
        }
        e.observer = void 0
    }

    function el(t, e) {
        var r, o = il(this, {
            cleanup: void 0,
            observer: B(t),
            subscriptionObserver: void 0
        });
        A || (this.closed = !1);
        try {
            (r = $m(t.start)) && r.call(t, this)
        } catch (t) {
            Xu(t)
        }
        if (!Qm(o)) {
            var n = o.subscriptionObserver = new sl(this);
            try {
                var i = e(n),
                    s = i;
                null != i && (o.cleanup = "function" == typeof i.unsubscribe ? function () {
                    s.unsubscribe()
                } : Ht(i))
            } catch (t) {
                return void n.error(t)
            }
            Qm(o) && Xm(o)
        }
    }
    var rl = x.f,
        ol = At("observable"),
        nl = ct.get,
        il = ct.set;
    el.prototype = mu({}, {
        unsubscribe: function () {
            var t = nl(this);
            Qm(t) || (tl(this, t), Xm(t))
        }
    }), A && rl(el.prototype, "closed", {
        configurable: !0,
        get: function () {
            return Qm(nl(this))
        }
    });
    var sl = function (t) {
        il(this, {
            subscription: t
        }), A || (this.closed = !1)
    };
    sl.prototype = mu({}, {
        next: function (t) {
            var e = nl(nl(this).subscription);
            if (!Qm(e)) {
                var r = e.observer;
                try {
                    var o = $m(r.next);
                    o && o.call(r, t)
                } catch (t) {
                    Xu(t)
                }
            }
        },
        error: function (t) {
            var e = nl(this).subscription,
                r = nl(e);
            if (!Qm(r)) {
                var o = r.observer;
                tl(e, r);
                try {
                    var n = $m(o.error);
                    n ? n.call(o, t) : Xu(t)
                } catch (t) {
                    Xu(t)
                }
                Xm(r)
            }
        },
        complete: function () {
            var t = nl(this).subscription,
                e = nl(t);
            if (!Qm(e)) {
                var r = e.observer;
                tl(t, e);
                try {
                    var o = $m(r.complete);
                    o && o.call(r)
                } catch (t) {
                    Xu(t)
                }
                Xm(e)
            }
        }
    }), A && rl(sl.prototype, "closed", {
        configurable: !0,
        get: function () {
            return Qm(nl(nl(this).subscription))
        }
    });
    var al = function (t) {
        lu(this, al, "Observable"), il(this, {
            subscriber: Ht(t)
        })
    };
    mu(al.prototype, {
        subscribe: function (t, e, r) {
            var o = arguments.length;
            return new el("function" == typeof t ? {
                next: t,
                error: 1 < o ? e : void 0,
                complete: 2 < o ? r : void 0
            } : C(t) ? t : {}, nl(this).subscriber)
        }
    }), mu(al, {
        from: function (t) {
            var e = "function" == typeof this ? this : al,
                r = $m(B(t)[ol]);
            if (r) {
                var o = B(r.call(t));
                return o.constructor === e ? o : new e(function (t) {
                    return o.subscribe(t)
                })
            }
            var n = kp(t);
            return new e(function (e) {
                dr(n, function (t) {
                    if (e.next(t), e.closed) return dr.stop()
                }, void 0, !1, !0), e.complete()
            })
        },
        of: function () {
            for (var t = "function" == typeof this ? this : al, r = arguments.length, o = new Array(r), e = 0; e < r;) o[e] = arguments[e++];
            return new t(function (t) {
                for (var e = 0; e < r; e++)
                    if (t.next(o[e]), t.closed) return;
                t.complete()
            })
        }
    }), q(al.prototype, ol, function () {
        return this
    }), st({
        global: !0
    }, {
        Observable: al
    }), gn("Observable"), xt("observable"), xt("patternMatch"), st({
        target: "Promise",
        stat: !0
    }, {
        try: function (t) {
            var e = fc.f(this),
                r = Qu(t);
            return (r.error ? e.reject : e.resolve)(r.value), e.promise
        }
    });
    var ul = "Seeded Random",
        cl = ul + " Generator",
        fl = ct.set,
        hl = ct.getterFor(cl),
        pl = bn(function (t) {
            fl(this, {
                type: cl,
                seed: t % 2147483647
            })
        }, ul, function () {
            var t = hl(this);
            return {
                value: (1073741823 & (t.seed = (1103515245 * t.seed + 12345) % 2147483647)) / 1073741823,
                done: !1
            }
        });
    st({
        target: "Math",
        stat: !0,
        forced: !0
    }, {
        seededPRNG: function (t) {
            var e = B(t).seed;
            if (!zs(e)) throw TypeError('Math.seededPRNG() argument should have a "seed" field with a finite value.');
            return new pl(e)
        }
    });
    var dl = qn.codeAt,
        ml = qn.charAt,
        ll = "String Iterator",
        gl = ct.set,
        yl = ct.getterFor(ll),
        _l = bn(function (t) {
            gl(this, {
                type: ll,
                string: t,
                index: 0
            })
        }, "String", function () {
            var t, e = yl(this),
                r = e.string,
                o = e.index;
            return o >= r.length ? {
                value: void 0,
                done: !0
            } : (t = ml(r, o), e.index += t.length, {
                value: {
                    codePoint: dl(t, 0),
                    position: o
                },
                done: !1
            })
        });
    st({
        target: "String",
        proto: !0
    }, {
        codePoints: function () {
            return new _l(String(h(this)))
        }
    });

    function Rl(t, e) {
        if (!vl || !kt(t) || !vl(t)) return !1;
        for (var r, o = 0, n = t.length; o < n;)
            if (!("string" == typeof (r = t[o++]) || e && void 0 === r)) return !1;
        return 0 !== n
    }
    var vl = Object.isFrozen;
    st({
        target: "Array",
        stat: !0
    }, {
        isTemplateObject: function (t) {
            if (!Rl(t, !0)) return !1;
            var e = t.raw;
            return !(e.length !== t.length || !Rl(e, !1))
        }
    });
    var wl = function (t, e) {
        var r = this;
        if (!(r instanceof wl)) return new wl(t, e);
        Fr && (r = Fr(new Error(e), wr(r)));
        var o = [];
        return dr(t, o.push, o), q(r, "errors", o), void 0 !== e && q(r, "message", String(e)), r
    };
    wl.prototype = jt(Error.prototype, {
        constructor: P(5, wl),
        name: P(5, "AggregateError")
    }), st({
        global: !0
    }, {
        AggregateError: wl
    });
    var Sl = "No one promise resolved";
    st({
        target: "Promise",
        stat: !0
    }, {
        any: function (t) {
            var u = this,
                e = fc.f(u),
                c = e.resolve,
                f = e.reject,
                r = Qu(function () {
                    var o = Ht(u.resolve),
                        n = [],
                        i = 0,
                        s = 1,
                        a = !1;
                    dr(t, function (t) {
                        var e = i++,
                            r = !1;
                        n.push(void 0), s++, o.call(u, t).then(function (t) {
                            r || a || (a = !0, c(t))
                        }, function (t) {
                            r || a || (r = !0, n[e] = t, --s || f(new (X("AggregateError"))(n, Sl)))
                        })
                    }), --s || f(new (X("AggregateError"))(n, Sl))
                });
            return r.error && f(r.value), e.promise
        }
    }), st({
        target: "Set",
        proto: !0,
        real: !0,
        forced: !1
    }, {
        difference: function (t) {
            var e = B(this),
                r = new (di(e, X("Set")))(e),
                o = Ht(r.delete);
            return dr(t, function (t) {
                o.call(r, t)
            }), r
        }
    }), st({
        target: "Set",
        proto: !0,
        real: !0,
        forced: !1
    }, {
        intersection: function (t) {
            var e = B(this),
                r = new (di(e, X("Set"))),
                o = Ht(e.has),
                n = Ht(r.add);
            return dr(t, function (t) {
                o.call(e, t) && n.call(r, t)
            }), r
        }
    }), st({
        target: "Set",
        proto: !0,
        real: !0,
        forced: !1
    }, {
        isDisjointFrom: function (t) {
            var e = B(this),
                r = Ht(e.has);
            return !dr(t, function (t) {
                if (!0 === r.call(e, t)) return dr.stop()
            }).stopped
        }
    }), st({
        target: "Set",
        proto: !0,
        real: !0,
        forced: !1
    }, {
        isSubsetOf: function (t) {
            var e = kp(this),
                r = B(t),
                o = r.has;
            return "function" != typeof o && (r = new (X("Set"))(t), o = Ht(r.has)), !dr(e, function (t) {
                if (!1 === o.call(r, t)) return dr.stop()
            }, void 0, !1, !0).stopped
        }
    }), st({
        target: "Set",
        proto: !0,
        real: !0,
        forced: !1
    }, {
        isSupersetOf: function (t) {
            var e = B(this),
                r = Ht(e.has);
            return !dr(t, function (t) {
                if (!1 === r.call(e, t)) return dr.stop()
            }).stopped
        }
    }), st({
        target: "Set",
        proto: !0,
        real: !0,
        forced: !1
    }, {
        union: function (t) {
            var e = B(this),
                r = new (di(e, X("Set")))(e);
            return dr(t, Ht(r.add), r), r
        }
    }), st({
        target: "Set",
        proto: !0,
        real: !0,
        forced: !1
    }, {
        symmetricDifference: function (t) {
            var e = B(this),
                r = new (di(e, X("Set")))(e),
                o = Ht(r.delete),
                n = Ht(r.add);
            return dr(t, function (t) {
                o.call(r, t) || n.call(r, t)
            }), r
        }
    });
    var Ml = At("replaceAll"),
        bl = RegExp.prototype;
    st({
        target: "String",
        proto: !0
    }, {
        replaceAll: function (t, e) {
            var r, o, n, i, s, a, u = h(this);
            if (null != t && void 0 !== (r = t[Ml])) return r.call(t, u, e);
            if (o = String(u), n = String(t), i = o.split(n), "function" != typeof e) return i.join(String(e));
            for (s = i[0], a = 1; a < i.length; a++) s += String(e(n, a - 1, o)), s += i[a];
            return s
        }
    }), Ml in bl || q(bl, Ml, function (t, e) {
        var r = B(this),
            o = String("flags" in bl ? r.flags : $n.call(r));
        return ~o.indexOf("g") || (r = new (di(r, RegExp))(r.source, o + "g")), String(t).replace(r, e)
    }), xt("replaceAll"), xt("asyncDispose"), xt("dispose"), st({
        global: !0
    }, {
        globalThis: j
    });
    var Il = {
        CSSRuleList: 0,
        CSSStyleDeclaration: 0,
        CSSValueList: 0,
        ClientRectList: 0,
        DOMRectList: 0,
        DOMStringList: 0,
        DOMTokenList: 1,
        DataTransferItemList: 0,
        FileList: 0,
        HTMLAllCollection: 0,
        HTMLCollection: 0,
        HTMLFormElement: 0,
        HTMLSelectElement: 0,
        MediaList: 0,
        MimeTypeArray: 0,
        NamedNodeMap: 0,
        NodeList: 1,
        PaintRequestList: 0,
        Plugin: 0,
        PluginArray: 0,
        SVGLengthList: 0,
        SVGNumberList: 0,
        SVGPathSegList: 0,
        SVGPointList: 0,
        SVGStringList: 0,
        SVGTransformList: 0,
        SourceBufferList: 0,
        StyleSheetList: 0,
        TextTrackCueList: 0,
        TextTrackList: 0,
        TouchList: 0
    };
    for (var Bl in Il) {
        var Tl = j[Bl],
            Ol = Tl && Tl.prototype;
        if (Ol && Ol.forEach !== Go) try {
            q(Ol, "forEach", Go)
        } catch (t) {
            Ol.forEach = Go
        }
    }
    var Dl = At("iterator"),
        Pl = At("toStringTag"),
        Cl = Gn.values;
    for (var kl in Il) {
        var Ll = j[kl],
            El = Ll && Ll.prototype;
        if (El) {
            if (El[Dl] !== Cl) try {
                q(El, Dl, Cl)
            } catch (t) {
                El[Dl] = Cl
            }
            if (El[Pl] || q(El, Pl, kl), Il[kl])
                for (var Nl in Gn)
                    if (El[Nl] !== Gn[Nl]) try {
                        q(El, Nl, Gn[Nl])
                    } catch (t) {
                        El[Nl] = Gn[Nl]
                    }
        }
    }
    var Ul = !j.setImmediate || !j.clearImmediate;
    st({
        global: !0,
        bind: !0,
        enumerable: !0,
        forced: Ul
    }, {
        setImmediate: xu.set,
        clearImmediate: xu.clear
    });
    var Gl = j.process,
        Fl = "process" == n(Gl);
    st({
        global: !0,
        enumerable: !0,
        noTargetGet: !0
    }, {
        queueMicrotask: function (t) {
            var e = Fl && Gl.domain;
            cc(e ? e.bind(t) : t)
        }
    });

    function jl(n) {
        return function (t, e) {
            var r = 2 < arguments.length,
                o = r ? Al.call(arguments, 2) : void 0;
            return n(r ? function () {
                ("function" == typeof t ? t : Function(t)).apply(this, o)
            } : t, e)
        }
    }
    var Al = [].slice,
        xl = /MSIE .\./.test(Oi);
    st({
        global: !0,
        bind: !0,
        forced: xl
    }, {
        setTimeout: jl(j.setTimeout),
        setInterval: jl(j.setInterval)
    });
    t(function (t) {
        var e = function (i) {
            var u, t = Object.prototype,
                c = t.hasOwnProperty,
                e = "function" == typeof Symbol ? Symbol : {},
                n = e.iterator || "@@iterator",
                r = e.asyncIterator || "@@asyncIterator",
                o = e.toStringTag || "@@toStringTag";

            function s(t, e, r, o) {
                var n = e && e.prototype instanceof a ? e : a,
                    i = Object.create(n.prototype),
                    s = new T(o || []);
                return i._invoke = function (i, s, a) {
                    var u = h;
                    return function (t, e) {
                        if (u === d) throw new Error("Generator is already running");
                        if (u === m) {
                            if ("throw" === t) throw e;
                            return D()
                        }
                        for (a.method = t, a.arg = e; ;) {
                            var r = a.delegate;
                            if (r) {
                                var o = b(r, a);
                                if (o) {
                                    if (o === l) continue;
                                    return o
                                }
                            }
                            if ("next" === a.method) a.sent = a._sent = a.arg;
                            else if ("throw" === a.method) {
                                if (u === h) throw u = m, a.arg;
                                a.dispatchException(a.arg)
                            } else "return" === a.method && a.abrupt("return", a.arg);
                            u = d;
                            var n = f(i, s, a);
                            if ("normal" === n.type) {
                                if (u = a.done ? m : p, n.arg === l) continue;
                                return {
                                    value: n.arg,
                                    done: a.done
                                }
                            }
                            "throw" === n.type && (u = m, a.method = "throw", a.arg = n.arg)
                        }
                    }
                }(t, r, s), i
            }

            function f(t, e, r) {
                try {
                    return {
                        type: "normal",
                        arg: t.call(e, r)
                    }
                } catch (t) {
                    return {
                        type: "throw",
                        arg: t
                    }
                }
            }
            i.wrap = s;
            var h = "suspendedStart",
                p = "suspendedYield",
                d = "executing",
                m = "completed",
                l = {};

            function a() { }

            function g() { }

            function y() { }
            var _ = {};
            _[n] = function () {
                return this
            };
            var R = Object.getPrototypeOf,
                v = R && R(R(O([])));
            v && v !== t && c.call(v, n) && (_ = v);
            var w = y.prototype = a.prototype = Object.create(_);

            function S(t) {
                ["next", "throw", "return"].forEach(function (e) {
                    t[e] = function (t) {
                        return this._invoke(e, t)
                    }
                })
            }

            function M(u) {
                var e;
                this._invoke = function (r, o) {
                    function t() {
                        return new Promise(function (t, e) {
                            ! function e(t, r, o, n) {
                                var i = f(u[t], u, r);
                                if ("throw" !== i.type) {
                                    var s = i.arg,
                                        a = s.value;
                                    return a && "object" == typeof a && c.call(a, "__await") ? Promise.resolve(a.__await).then(function (t) {
                                        e("next", t, o, n)
                                    }, function (t) {
                                        e("throw", t, o, n)
                                    }) : Promise.resolve(a).then(function (t) {
                                        s.value = t, o(s)
                                    }, function (t) {
                                        return e("throw", t, o, n)
                                    })
                                }
                                n(i.arg)
                            }(r, o, t, e)
                        })
                    }
                    return e = e ? e.then(t, t) : t()
                }
            }

            function b(t, e) {
                var r = t.iterator[e.method];
                if (r === u) {
                    if (e.delegate = null, "throw" === e.method) {
                        if (t.iterator.return && (e.method = "return", e.arg = u, b(t, e), "throw" === e.method)) return l;
                        e.method = "throw", e.arg = new TypeError("The iterator does not provide a 'throw' method")
                    }
                    return l
                }
                var o = f(r, t.iterator, e.arg);
                if ("throw" === o.type) return e.method = "throw", e.arg = o.arg, e.delegate = null, l;
                var n = o.arg;
                return n ? n.done ? (e[t.resultName] = n.value, e.next = t.nextLoc, "return" !== e.method && (e.method = "next", e.arg = u), e.delegate = null, l) : n : (e.method = "throw", e.arg = new TypeError("iterator result is not an object"), e.delegate = null, l)
            }

            function I(t) {
                var e = {
                    tryLoc: t[0]
                };
                1 in t && (e.catchLoc = t[1]), 2 in t && (e.finallyLoc = t[2], e.afterLoc = t[3]), this.tryEntries.push(e)
            }

            function B(t) {
                var e = t.completion || {};
                e.type = "normal", delete e.arg, t.completion = e
            }

            function T(t) {
                this.tryEntries = [{
                    tryLoc: "root"
                }], t.forEach(I, this), this.reset(!0)
            }

            function O(e) {
                if (e) {
                    var t = e[n];
                    if (t) return t.call(e);
                    if ("function" == typeof e.next) return e;
                    if (!isNaN(e.length)) {
                        var r = -1,
                            o = function t() {
                                for (; ++r < e.length;)
                                    if (c.call(e, r)) return t.value = e[r], t.done = !1, t;
                                return t.value = u, t.done = !0, t
                            };
                        return o.next = o
                    }
                }
                return {
                    next: D
                }
            }

            function D() {
                return {
                    value: u,
                    done: !0
                }
            }
            return g.prototype = w.constructor = y, y.constructor = g, y[o] = g.displayName = "GeneratorFunction", i.isGeneratorFunction = function (t) {
                var e = "function" == typeof t && t.constructor;
                return !!e && (e === g || "GeneratorFunction" === (e.displayName || e.name))
            }, i.mark = function (t) {
                return Object.setPrototypeOf ? Object.setPrototypeOf(t, y) : (t.__proto__ = y, o in t || (t[o] = "GeneratorFunction")), t.prototype = Object.create(w), t
            }, i.awrap = function (t) {
                return {
                    __await: t
                }
            }, S(M.prototype), M.prototype[r] = function () {
                return this
            }, i.AsyncIterator = M, i.async = function (t, e, r, o) {
                var n = new M(s(t, e, r, o));
                return i.isGeneratorFunction(e) ? n : n.next().then(function (t) {
                    return t.done ? t.value : n.next()
                })
            }, S(w), w[o] = "Generator", w[n] = function () {
                return this
            }, w.toString = function () {
                return "[object Generator]"
            }, i.keys = function (r) {
                var o = [];
                for (var t in r) o.push(t);
                return o.reverse(),
                    function t() {
                        for (; o.length;) {
                            var e = o.pop();
                            if (e in r) return t.value = e, t.done = !1, t
                        }
                        return t.done = !0, t
                    }
            }, i.values = O, T.prototype = {
                constructor: T,
                reset: function (t) {
                    if (this.prev = 0, this.next = 0, this.sent = this._sent = u, this.done = !1, this.delegate = null, this.method = "next", this.arg = u, this.tryEntries.forEach(B), !t)
                        for (var e in this) "t" === e.charAt(0) && c.call(this, e) && !isNaN(+e.slice(1)) && (this[e] = u)
                },
                stop: function () {
                    this.done = !0;
                    var t = this.tryEntries[0].completion;
                    if ("throw" === t.type) throw t.arg;
                    return this.rval
                },
                dispatchException: function (r) {
                    if (this.done) throw r;
                    var o = this;

                    function t(t, e) {
                        return i.type = "throw", i.arg = r, o.next = t, e && (o.method = "next", o.arg = u), !!e
                    }
                    for (var e = this.tryEntries.length - 1; 0 <= e; --e) {
                        var n = this.tryEntries[e],
                            i = n.completion;
                        if ("root" === n.tryLoc) return t("end");
                        if (n.tryLoc <= this.prev) {
                            var s = c.call(n, "catchLoc"),
                                a = c.call(n, "finallyLoc");
                            if (s && a) {
                                if (this.prev < n.catchLoc) return t(n.catchLoc, !0);
                                if (this.prev < n.finallyLoc) return t(n.finallyLoc)
                            } else if (s) {
                                if (this.prev < n.catchLoc) return t(n.catchLoc, !0)
                            } else {
                                if (!a) throw new Error("try statement without catch or finally");
                                if (this.prev < n.finallyLoc) return t(n.finallyLoc)
                            }
                        }
                    }
                },
                abrupt: function (t, e) {
                    for (var r = this.tryEntries.length - 1; 0 <= r; --r) {
                        var o = this.tryEntries[r];
                        if (o.tryLoc <= this.prev && c.call(o, "finallyLoc") && this.prev < o.finallyLoc) {
                            var n = o;
                            break
                        }
                    }
                    n && ("break" === t || "continue" === t) && n.tryLoc <= e && e <= n.finallyLoc && (n = null);
                    var i = n ? n.completion : {};
                    return i.type = t, i.arg = e, n ? (this.method = "next", this.next = n.finallyLoc, l) : this.complete(i)
                },
                complete: function (t, e) {
                    if ("throw" === t.type) throw t.arg;
                    return "break" === t.type || "continue" === t.type ? this.next = t.arg : "return" === t.type ? (this.rval = this.arg = t.arg, this.method = "return", this.next = "end") : "normal" === t.type && e && (this.next = e), l
                },
                finish: function (t) {
                    for (var e = this.tryEntries.length - 1; 0 <= e; --e) {
                        var r = this.tryEntries[e];
                        if (r.finallyLoc === t) return this.complete(r.completion, r.afterLoc), B(r), l
                    }
                },
                catch: function (t) {
                    for (var e = this.tryEntries.length - 1; 0 <= e; --e) {
                        var r = this.tryEntries[e];
                        if (r.tryLoc === t) {
                            var o = r.completion;
                            if ("throw" === o.type) {
                                var n = o.arg;
                                B(r)
                            }
                            return n
                        }
                    }
                    throw new Error("illegal catch attempt")
                },
                delegateYield: function (t, e, r) {
                    return this.delegate = {
                        iterator: O(t),
                        resultName: e,
                        nextLoc: r
                    }, "next" === this.method && (this.arg = u), l
                }
            }, i
        }(t.exports);
        try {
            regeneratorRuntime = e
        } catch (t) {
            Function("r", "regeneratorRuntime = r")(e)
        }
    });
    var ql = function (t, e) {
        return (ql = Object.setPrototypeOf || {
            __proto__: []
        }
            instanceof Array && function (t, e) {
                t.__proto__ = e
            } || function (t, e) {
                for (var r in e) e.hasOwnProperty(r) && (t[r] = e[r])
            })(t, e)
    };
    var Hl, Vl, Kl, Yl, Wl, Jl, zl, Zl, $l = function () {
        return ($l = Object.assign || function (t) {
            for (var e, r = 1, o = arguments.length; r < o; r++)
                for (var n in e = arguments[r]) Object.prototype.hasOwnProperty.call(e, n) && (t[n] = e[n]);
            return t
        }).apply(this, arguments)
    };

    function Xl(t) {
        var e = "function" == typeof Symbol && t[Symbol.iterator],
            r = 0;
        return e ? e.call(t) : {
            next: function () {
                return t && r >= t.length && (t = void 0), {
                    value: t && t[r++],
                    done: !t
                }
            }
        }
    }

    function Ql(t, e) {
        var r = "function" == typeof Symbol && t[Symbol.iterator];
        if (!r) return t;
        var o, n, i = r.call(t),
            s = [];
        try {
            for (;
                (void 0 === e || 0 < e--) && !(o = i.next()).done;) s.push(o.value)
        } catch (t) {
            n = {
                error: t
            }
        } finally {
            try {
                o && !o.done && (r = i.return) && r.call(i)
            } finally {
                if (n) throw n.error
            }
        }
        return s
    }

    function tg() {
        for (var t = [], e = 0; e < arguments.length; e++) t = t.concat(Ql(arguments[e]));
        return t
    } (Vl = Hl = Hl || {})[Vl.SDKProvisionStatus_Success = 0] = "SDKProvisionStatus_Success", Vl[Vl.SDKProvisionStatus_DispatchError = 1] = "SDKProvisionStatus_DispatchError", Vl[Vl.SDKProvisionStatus_ConfigError = 2] = "SDKProvisionStatus_ConfigError", Vl[Vl.SDKProvisionStatus_UnknownError = 100] = "SDKProvisionStatus_UnknownError", (Yl = Kl = Kl || {})[Yl.Unkown = 0] = "Unkown", Yl[Yl.Unavailable = 1] = "Unavailable", Yl[Yl.ServerFailed = 2] = "ServerFailed", Yl[Yl.Connecting = 3] = "Connecting", Yl[Yl.Connected = 4] = "Connected", Yl[Yl.DisConnected = 5] = "DisConnected", (Jl = Wl = Wl || {})[Jl.MessagePriorityTopic = 0] = "MessagePriorityTopic", Jl[Jl.MessagePriorityNotice = 1] = "MessagePriorityNotice", Jl[Jl.MessagePriorityPrivMsg = 99] = "MessagePriorityPrivMsg", (Zl = zl = zl || {})[Zl.Success = 0] = "Success", Zl[Zl.AlreadyInit = 19] = "AlreadyInit", Zl[Zl.UnInit = 11] = "UnInit", Zl[Zl.UnLogined = 12] = "UnLogined", Zl[Zl.AlreadyLogined = 17] = "AlreadyLogined", Zl[Zl.ParaError = 1] = "ParaError", Zl[Zl.TimeOut = 2] = "TimeOut", Zl[Zl.Logging = 18] = "Logging", Zl[Zl.ContentToLarge = 15] = "ContentToLarge", Zl[Zl.ReceiverTooMany = 20] = "ReceiverTooMany", Zl[Zl.MessageLimit = 21] = "MessageLimit";
    var eg = "onSDKProvisionStatusNotice",
        rg = "onLoginResponse",
        og = "onLogoutNotice",
        ng = "onNetStatusChanged",
        ig = "onKickoutNotice",
        sg = "onNetworkQulityTestResponse",
        ag = "onJoinRoomResponse",
        ug = "onJoinRoomNotice",
        cg = "onRecvRoomMetaData",
        fg = "onRecvRoomDataUpdateNotice",
        hg = "onRecvRoomUserList",
        pg = "onRoomUserCountNotice",
        dg = "onRecvRoomTopic",
        mg = "onLeaveRoomResponse",
        lg = "onLeaveRoomNotice",
        gg = "onRecvRoomMessage",
        yg = "onSendRoomMessageResponse",
        _g = "onMuteRoomResponse",
        Rg = "onGetRoomMuteStatusResponse",
        vg = "onSetRoomDataResponse",
        wg = "onSetRoomsDataResponse",
        Sg = "onGetRoomDataResponse",
        Mg = "onSetRoomSubscribeOption",
        bg = "onGetRoomHistoryMessageResponse",
        Ig = "onSendRoomBinMessageResp",
        Bg = "onRecvRoomBinMessageNotice",
        Tg = "onGetRoomHistoryBinMessageResp",
        Og = "onGetRoomHistoryBinMessageNotice",
        Dg = "onGetRoomBatchHistoryBinaryMessagesResponse",
        Pg = "onGetRoomBatchHistoryBinaryMessagesNotice",
        Cg = "onGetStatisticsResp",
        kg = "onMuteRoomNotice",
        Lg = "onRecvPeerMessage",
        Eg = "onSendPeerMessageResponse",
        Ng = "undefined" != typeof global ? global : "undefined" != typeof self ? self : "undefined" != typeof window ? window : {},
        Ug = [],
        Gg = [],
        Fg = "undefined" != typeof Uint8Array ? Uint8Array : Array,
        jg = !1;

    function Ag() {
        jg = !0;
        for (var t = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", e = 0, r = t.length; e < r; ++e) Ug[e] = t[e], Gg[t.charCodeAt(e)] = e;
        Gg["-".charCodeAt(0)] = 62, Gg["_".charCodeAt(0)] = 63
    }

    function xg(t, e, r) {
        for (var o, n, i = [], s = e; s < r; s += 3) o = (t[s] << 16) + (t[s + 1] << 8) + t[s + 2], i.push(Ug[(n = o) >> 18 & 63] + Ug[n >> 12 & 63] + Ug[n >> 6 & 63] + Ug[63 & n]);
        return i.join("")
    }

    function qg(t) {
        var e;
        jg || Ag();
        for (var r = t.length, o = r % 3, n = "", i = [], s = 0, a = r - o; s < a; s += 16383) i.push(xg(t, s, a < s + 16383 ? a : s + 16383));
        return 1 == o ? (e = t[r - 1], n += Ug[e >> 2], n += Ug[e << 4 & 63], n += "==") : 2 == o && (e = (t[r - 2] << 8) + t[r - 1], n += Ug[e >> 10], n += Ug[e >> 4 & 63], n += Ug[e << 2 & 63], n += "="), i.push(n), i.join("")
    }

    function Hg(t, e, r, o, n) {
        var i, s, a = 8 * n - o - 1,
            u = (1 << a) - 1,
            c = u >> 1,
            f = -7,
            h = r ? n - 1 : 0,
            p = r ? -1 : 1,
            d = t[e + h];
        for (h += p, i = d & (1 << -f) - 1, d >>= -f, f += a; 0 < f; i = 256 * i + t[e + h], h += p, f -= 8);
        for (s = i & (1 << -f) - 1, i >>= -f, f += o; 0 < f; s = 256 * s + t[e + h], h += p, f -= 8);
        if (0 === i) i = 1 - c;
        else {
            if (i === u) return s ? NaN : 1 / 0 * (d ? -1 : 1);
            s += Math.pow(2, o), i -= c
        }
        return (d ? -1 : 1) * s * Math.pow(2, i - o)
    }

    function Vg(t, e, r, o, n, i) {
        var s, a, u, c = 8 * i - n - 1,
            f = (1 << c) - 1,
            h = f >> 1,
            p = 23 === n ? Math.pow(2, -24) - Math.pow(2, -77) : 0,
            d = o ? 0 : i - 1,
            m = o ? 1 : -1,
            l = e < 0 || 0 === e && 1 / e < 0 ? 1 : 0;
        for (e = Math.abs(e), isNaN(e) || e === 1 / 0 ? (a = isNaN(e) ? 1 : 0, s = f) : (s = Math.floor(Math.log(e) / Math.LN2), e * (u = Math.pow(2, -s)) < 1 && (s--, u *= 2), 2 <= (e += 1 <= s + h ? p / u : p * Math.pow(2, 1 - h)) * u && (s++, u /= 2), f <= s + h ? (a = 0, s = f) : 1 <= s + h ? (a = (e * u - 1) * Math.pow(2, n), s += h) : (a = e * Math.pow(2, h - 1) * Math.pow(2, n), s = 0)); 8 <= n; t[r + d] = 255 & a, d += m, a /= 256, n -= 8);
        for (s = s << n | a, c += n; 0 < c; t[r + d] = 255 & s, d += m, s /= 256, c -= 8);
        t[r + d - m] |= 128 * l
    }
    var Kg = {}.toString,
        Yg = Array.isArray || function (t) {
            return "[object Array]" == Kg.call(t)
        };

    function Wg() {
        return zg.TYPED_ARRAY_SUPPORT ? 2147483647 : 1073741823
    }

    function Jg(t, e) {
        if (Wg() < e) throw new RangeError("Invalid typed array length");
        return zg.TYPED_ARRAY_SUPPORT ? (t = new Uint8Array(e)).__proto__ = zg.prototype : (null === t && (t = new zg(e)), t.length = e), t
    }

    function zg(t, e, r) {
        if (!(zg.TYPED_ARRAY_SUPPORT || this instanceof zg)) return new zg(t, e, r);
        if ("number" != typeof t) return Zg(this, t, e, r);
        if ("string" == typeof e) throw new Error("If encoding is specified then the first argument must be a string");
        return Xg(this, t)
    }

    function Zg(t, e, r, o) {
        if ("number" == typeof e) throw new TypeError('"value" argument must not be a number');
        return "undefined" != typeof ArrayBuffer && e instanceof ArrayBuffer ? function (t, e, r, o) {
            if (e.byteLength, r < 0 || e.byteLength < r) throw new RangeError("'offset' is out of bounds");
            if (e.byteLength < r + (o || 0)) throw new RangeError("'length' is out of bounds");
            e = void 0 === r && void 0 === o ? new Uint8Array(e) : void 0 === o ? new Uint8Array(e, r) : new Uint8Array(e, r, o);
            zg.TYPED_ARRAY_SUPPORT ? (t = e).__proto__ = zg.prototype : t = Qg(t, e);
            return t
        }(t, e, r, o) : "string" == typeof e ? function (t, e, r) {
            "string" == typeof r && "" !== r || (r = "utf8");
            if (!zg.isEncoding(r)) throw new TypeError('"encoding" must be a valid string encoding');
            var o = 0 | ry(e, r),
                n = (t = Jg(t, o)).write(e, r);
            n !== o && (t = t.slice(0, n));
            return t
        }(t, e, r) : function (t, e) {
            if (ey(e)) {
                var r = 0 | ty(e.length);
                return 0 === (t = Jg(t, r)).length || e.copy(t, 0, 0, r), t
            }
            if (e) {
                if ("undefined" != typeof ArrayBuffer && e.buffer instanceof ArrayBuffer || "length" in e) return "number" != typeof e.length || function (t) {
                    return t != t
                }(e.length) ? Jg(t, 0) : Qg(t, e);
                if ("Buffer" === e.type && Yg(e.data)) return Qg(t, e.data)
            }
            throw new TypeError("First argument must be a string, Buffer, ArrayBuffer, Array, or array-like object.")
        }(t, e)
    }

    function $g(t) {
        if ("number" != typeof t) throw new TypeError('"size" argument must be a number');
        if (t < 0) throw new RangeError('"size" argument must not be negative')
    }

    function Xg(t, e) {
        if ($g(e), t = Jg(t, e < 0 ? 0 : 0 | ty(e)), !zg.TYPED_ARRAY_SUPPORT)
            for (var r = 0; r < e; ++r) t[r] = 0;
        return t
    }

    function Qg(t, e) {
        var r = e.length < 0 ? 0 : 0 | ty(e.length);
        t = Jg(t, r);
        for (var o = 0; o < r; o += 1) t[o] = 255 & e[o];
        return t
    }

    function ty(t) {
        if (t >= Wg()) throw new RangeError("Attempt to allocate Buffer larger than maximum size: 0x" + Wg().toString(16) + " bytes");
        return 0 | t
    }

    function ey(t) {
        return !(null == t || !t._isBuffer)
    }

    function ry(t, e) {
        if (ey(t)) return t.length;
        if ("undefined" != typeof ArrayBuffer && "function" == typeof ArrayBuffer.isView && (ArrayBuffer.isView(t) || t instanceof ArrayBuffer)) return t.byteLength;
        "string" != typeof t && (t = "" + t);
        var r = t.length;
        if (0 === r) return 0;
        for (var o = !1; ;) switch (e) {
            case "ascii":
            case "latin1":
            case "binary":
                return r;
            case "utf8":
            case "utf-8":
            case void 0:
                return by(t).length;
            case "ucs2":
            case "ucs-2":
            case "utf16le":
            case "utf-16le":
                return 2 * r;
            case "hex":
                return r >>> 1;
            case "base64":
                return Iy(t).length;
            default:
                if (o) return by(t).length;
                e = ("" + e).toLowerCase(), o = !0
        }
    }

    function oy(t, e, r) {
        var o = t[e];
        t[e] = t[r], t[r] = o
    }

    function ny(t, e, r, o, n) {
        if (0 === t.length) return -1;
        if ("string" == typeof r ? (o = r, r = 0) : 2147483647 < r ? r = 2147483647 : r < -2147483648 && (r = -2147483648), r = +r, isNaN(r) && (r = n ? 0 : t.length - 1), r < 0 && (r = t.length + r), r >= t.length) {
            if (n) return -1;
            r = t.length - 1
        } else if (r < 0) {
            if (!n) return -1;
            r = 0
        }
        if ("string" == typeof e && (e = zg.from(e, o)), ey(e)) return 0 === e.length ? -1 : iy(t, e, r, o, n);
        if ("number" == typeof e) return e &= 255, zg.TYPED_ARRAY_SUPPORT && "function" == typeof Uint8Array.prototype.indexOf ? n ? Uint8Array.prototype.indexOf.call(t, e, r) : Uint8Array.prototype.lastIndexOf.call(t, e, r) : iy(t, [e], r, o, n);
        throw new TypeError("val must be string, number or Buffer")
    }

    function iy(t, e, r, o, n) {
        var i, s = 1,
            a = t.length,
            u = e.length;
        if (void 0 !== o && ("ucs2" === (o = String(o).toLowerCase()) || "ucs-2" === o || "utf16le" === o || "utf-16le" === o)) {
            if (t.length < 2 || e.length < 2) return -1;
            a /= s = 2, u /= 2, r /= 2
        }

        function c(t, e) {
            return 1 === s ? t[e] : t.readUInt16BE(e * s)
        }
        if (n) {
            var f = -1;
            for (i = r; i < a; i++)
                if (c(t, i) === c(e, -1 === f ? 0 : i - f)) {
                    if (-1 === f && (f = i), i - f + 1 === u) return f * s
                } else -1 !== f && (i -= i - f), f = -1
        } else
            for (a < r + u && (r = a - u), i = r; 0 <= i; i--) {
                for (var h = !0, p = 0; p < u; p++)
                    if (c(t, i + p) !== c(e, p)) {
                        h = !1;
                        break
                    }
                if (h) return i
            }
        return -1
    }

    function sy(t, e, r, o) {
        r = Number(r) || 0;
        var n = t.length - r;
        o ? n < (o = Number(o)) && (o = n) : o = n;
        var i = e.length;
        if (i % 2 != 0) throw new TypeError("Invalid hex string");
        i / 2 < o && (o = i / 2);
        for (var s = 0; s < o; ++s) {
            var a = parseInt(e.substr(2 * s, 2), 16);
            if (isNaN(a)) return s;
            t[r + s] = a
        }
        return s
    }

    function ay(t, e, r, o) {
        return By(function (t) {
            for (var e = [], r = 0; r < t.length; ++r) e.push(255 & t.charCodeAt(r));
            return e
        }(e), t, r, o)
    }

    function uy(t, e, r) {
        return 0 === e && r === t.length ? qg(t) : qg(t.slice(e, r))
    }

    function cy(t, e, r) {
        r = Math.min(t.length, r);
        for (var o = [], n = e; n < r;) {
            var i, s, a, u, c = t[n],
                f = null,
                h = 239 < c ? 4 : 223 < c ? 3 : 191 < c ? 2 : 1;
            if (n + h <= r) switch (h) {
                case 1:
                    c < 128 && (f = c);
                    break;
                case 2:
                    128 == (192 & (i = t[n + 1])) && 127 < (u = (31 & c) << 6 | 63 & i) && (f = u);
                    break;
                case 3:
                    i = t[n + 1], s = t[n + 2], 128 == (192 & i) && 128 == (192 & s) && 2047 < (u = (15 & c) << 12 | (63 & i) << 6 | 63 & s) && (u < 55296 || 57343 < u) && (f = u);
                    break;
                case 4:
                    i = t[n + 1], s = t[n + 2], a = t[n + 3], 128 == (192 & i) && 128 == (192 & s) && 128 == (192 & a) && 65535 < (u = (15 & c) << 18 | (63 & i) << 12 | (63 & s) << 6 | 63 & a) && u < 1114112 && (f = u)
            }
            null === f ? (f = 65533, h = 1) : 65535 < f && (f -= 65536, o.push(f >>> 10 & 1023 | 55296), f = 56320 | 1023 & f), o.push(f), n += h
        }
        return function (t) {
            var e = t.length;
            if (e <= fy) return String.fromCharCode.apply(String, t);
            var r = "",
                o = 0;
            for (; o < e;) r += String.fromCharCode.apply(String, t.slice(o, o += fy));
            return r
        }(o)
    }
    zg.TYPED_ARRAY_SUPPORT = void 0 === Ng.TYPED_ARRAY_SUPPORT || Ng.TYPED_ARRAY_SUPPORT, zg.poolSize = 8192, zg._augment = function (t) {
        return t.__proto__ = zg.prototype, t
    }, zg.from = function (t, e, r) {
        return Zg(null, t, e, r)
    }, zg.TYPED_ARRAY_SUPPORT && (zg.prototype.__proto__ = Uint8Array.prototype, zg.__proto__ = Uint8Array), zg.alloc = function (t, e, r) {
        return function (t, e, r, o) {
            return $g(e), e <= 0 ? Jg(t, e) : void 0 !== r ? "string" == typeof o ? Jg(t, e).fill(r, o) : Jg(t, e).fill(r) : Jg(t, e)
        }(null, t, e, r)
    }, zg.allocUnsafe = function (t) {
        return Xg(null, t)
    }, zg.allocUnsafeSlow = function (t) {
        return Xg(null, t)
    }, zg.isBuffer = Ty, zg.compare = function (t, e) {
        if (!ey(t) || !ey(e)) throw new TypeError("Arguments must be Buffers");
        if (t === e) return 0;
        for (var r = t.length, o = e.length, n = 0, i = Math.min(r, o); n < i; ++n)
            if (t[n] !== e[n]) {
                r = t[n], o = e[n];
                break
            }
        return r < o ? -1 : o < r ? 1 : 0
    }, zg.isEncoding = function (t) {
        switch (String(t).toLowerCase()) {
            case "hex":
            case "utf8":
            case "utf-8":
            case "ascii":
            case "latin1":
            case "binary":
            case "base64":
            case "ucs2":
            case "ucs-2":
            case "utf16le":
            case "utf-16le":
                return !0;
            default:
                return !1
        }
    }, zg.concat = function (t, e) {
        if (!Yg(t)) throw new TypeError('"list" argument must be an Array of Buffers');
        if (0 === t.length) return zg.alloc(0);
        var r;
        if (void 0 === e)
            for (r = e = 0; r < t.length; ++r) e += t[r].length;
        var o = zg.allocUnsafe(e),
            n = 0;
        for (r = 0; r < t.length; ++r) {
            var i = t[r];
            if (!ey(i)) throw new TypeError('"list" argument must be an Array of Buffers');
            i.copy(o, n), n += i.length
        }
        return o
    }, zg.byteLength = ry, zg.prototype._isBuffer = !0, zg.prototype.swap16 = function () {
        var t = this.length;
        if (t % 2 != 0) throw new RangeError("Buffer size must be a multiple of 16-bits");
        for (var e = 0; e < t; e += 2) oy(this, e, e + 1);
        return this
    }, zg.prototype.swap32 = function () {
        var t = this.length;
        if (t % 4 != 0) throw new RangeError("Buffer size must be a multiple of 32-bits");
        for (var e = 0; e < t; e += 4) oy(this, e, e + 3), oy(this, e + 1, e + 2);
        return this
    }, zg.prototype.swap64 = function () {
        var t = this.length;
        if (t % 8 != 0) throw new RangeError("Buffer size must be a multiple of 64-bits");
        for (var e = 0; e < t; e += 8) oy(this, e, e + 7), oy(this, e + 1, e + 6), oy(this, e + 2, e + 5), oy(this, e + 3, e + 4);
        return this
    }, zg.prototype.toString = function () {
        var t = 0 | this.length;
        return 0 == t ? "" : 0 === arguments.length ? cy(this, 0, t) : function (t, e, r) {
            var o = !1;
            if ((void 0 === e || e < 0) && (e = 0), e > this.length) return "";
            if ((void 0 === r || r > this.length) && (r = this.length), r <= 0) return "";
            if ((r >>>= 0) <= (e >>>= 0)) return "";
            for (t = t || "utf8"; ;) switch (t) {
                case "hex":
                    return dy(this, e, r);
                case "utf8":
                case "utf-8":
                    return cy(this, e, r);
                case "ascii":
                    return hy(this, e, r);
                case "latin1":
                case "binary":
                    return py(this, e, r);
                case "base64":
                    return uy(this, e, r);
                case "ucs2":
                case "ucs-2":
                case "utf16le":
                case "utf-16le":
                    return my(this, e, r);
                default:
                    if (o) throw new TypeError("Unknown encoding: " + t);
                    t = (t + "").toLowerCase(), o = !0
            }
        }.apply(this, arguments)
    }, zg.prototype.equals = function (t) {
        if (!ey(t)) throw new TypeError("Argument must be a Buffer");
        return this === t || 0 === zg.compare(this, t)
    }, zg.prototype.inspect = function () {
        var t = "";
        return 0 < this.length && (t = this.toString("hex", 0, 50).match(/.{2}/g).join(" "), 50 < this.length && (t += " ... ")), "<Buffer " + t + ">"
    }, zg.prototype.compare = function (t, e, r, o, n) {
        if (!ey(t)) throw new TypeError("Argument must be a Buffer");
        if (void 0 === e && (e = 0), void 0 === r && (r = t ? t.length : 0), void 0 === o && (o = 0), void 0 === n && (n = this.length), e < 0 || r > t.length || o < 0 || n > this.length) throw new RangeError("out of range index");
        if (n <= o && r <= e) return 0;
        if (n <= o) return -1;
        if (r <= e) return 1;
        if (this === t) return 0;
        for (var i = (n >>>= 0) - (o >>>= 0), s = (r >>>= 0) - (e >>>= 0), a = Math.min(i, s), u = this.slice(o, n), c = t.slice(e, r), f = 0; f < a; ++f)
            if (u[f] !== c[f]) {
                i = u[f], s = c[f];
                break
            }
        return i < s ? -1 : s < i ? 1 : 0
    }, zg.prototype.includes = function (t, e, r) {
        return -1 !== this.indexOf(t, e, r)
    }, zg.prototype.indexOf = function (t, e, r) {
        return ny(this, t, e, r, !0)
    }, zg.prototype.lastIndexOf = function (t, e, r) {
        return ny(this, t, e, r, !1)
    }, zg.prototype.write = function (t, e, r, o) {
        if (void 0 === e) o = "utf8", r = this.length, e = 0;
        else if (void 0 === r && "string" == typeof e) o = e, r = this.length, e = 0;
        else {
            if (!isFinite(e)) throw new Error("Buffer.write(string, encoding, offset[, length]) is no longer supported");
            e |= 0, isFinite(r) ? (r |= 0, void 0 === o && (o = "utf8")) : (o = r, r = void 0)
        }
        var n = this.length - e;
        if ((void 0 === r || n < r) && (r = n), 0 < t.length && (r < 0 || e < 0) || e > this.length) throw new RangeError("Attempt to write outside buffer bounds");
        o = o || "utf8";
        for (var i, s, a, u, c, f, h, p, d, m = !1; ;) switch (o) {
            case "hex":
                return sy(this, t, e, r);
            case "utf8":
            case "utf-8":
                return p = e, d = r, By(by(t, (h = this).length - p), h, p, d);
            case "ascii":
                return ay(this, t, e, r);
            case "latin1":
            case "binary":
                return ay(this, t, e, r);
            case "base64":
                return u = this, c = e, f = r, By(Iy(t), u, c, f);
            case "ucs2":
            case "ucs-2":
            case "utf16le":
            case "utf-16le":
                return s = e, a = r, By(function (t, e) {
                    for (var r, o, n, i = [], s = 0; s < t.length && !((e -= 2) < 0); ++s) r = t.charCodeAt(s), o = r >> 8, n = r % 256, i.push(n), i.push(o);
                    return i
                }(t, (i = this).length - s), i, s, a);
            default:
                if (m) throw new TypeError("Unknown encoding: " + o);
                o = ("" + o).toLowerCase(), m = !0
        }
    }, zg.prototype.toJSON = function () {
        return {
            type: "Buffer",
            data: Array.prototype.slice.call(this._arr || this, 0)
        }
    };
    var fy = 4096;

    function hy(t, e, r) {
        var o = "";
        r = Math.min(t.length, r);
        for (var n = e; n < r; ++n) o += String.fromCharCode(127 & t[n]);
        return o
    }

    function py(t, e, r) {
        var o = "";
        r = Math.min(t.length, r);
        for (var n = e; n < r; ++n) o += String.fromCharCode(t[n]);
        return o
    }

    function dy(t, e, r) {
        var o = t.length;
        (!e || e < 0) && (e = 0), (!r || r < 0 || o < r) && (r = o);
        for (var n = "", i = e; i < r; ++i) n += My(t[i]);
        return n
    }

    function my(t, e, r) {
        for (var o = t.slice(e, r), n = "", i = 0; i < o.length; i += 2) n += String.fromCharCode(o[i] + 256 * o[i + 1]);
        return n
    }

    function ly(t, e, r) {
        if (t % 1 != 0 || t < 0) throw new RangeError("offset is not uint");
        if (r < t + e) throw new RangeError("Trying to access beyond buffer length")
    }

    function gy(t, e, r, o, n, i) {
        if (!ey(t)) throw new TypeError('"buffer" argument must be a Buffer instance');
        if (n < e || e < i) throw new RangeError('"value" argument is out of bounds');
        if (r + o > t.length) throw new RangeError("Index out of range")
    }

    function yy(t, e, r, o) {
        e < 0 && (e = 65535 + e + 1);
        for (var n = 0, i = Math.min(t.length - r, 2); n < i; ++n) t[r + n] = (e & 255 << 8 * (o ? n : 1 - n)) >>> 8 * (o ? n : 1 - n)
    }

    function _y(t, e, r, o) {
        e < 0 && (e = 4294967295 + e + 1);
        for (var n = 0, i = Math.min(t.length - r, 4); n < i; ++n) t[r + n] = e >>> 8 * (o ? n : 3 - n) & 255
    }

    function Ry(t, e, r, o) {
        if (r + o > t.length) throw new RangeError("Index out of range");
        if (r < 0) throw new RangeError("Index out of range")
    }

    function vy(t, e, r, o, n) {
        return n || Ry(t, 0, r, 4), Vg(t, e, r, o, 23, 4), r + 4
    }

    function wy(t, e, r, o, n) {
        return n || Ry(t, 0, r, 8), Vg(t, e, r, o, 52, 8), r + 8
    }
    zg.prototype.slice = function (t, e) {
        var r, o = this.length;
        if ((t = ~~t) < 0 ? (t += o) < 0 && (t = 0) : o < t && (t = o), (e = void 0 === e ? o : ~~e) < 0 ? (e += o) < 0 && (e = 0) : o < e && (e = o), e < t && (e = t), zg.TYPED_ARRAY_SUPPORT) (r = this.subarray(t, e)).__proto__ = zg.prototype;
        else {
            var n = e - t;
            r = new zg(n, void 0);
            for (var i = 0; i < n; ++i) r[i] = this[i + t]
        }
        return r
    }, zg.prototype.readUIntLE = function (t, e, r) {
        t |= 0, e |= 0, r || ly(t, e, this.length);
        for (var o = this[t], n = 1, i = 0; ++i < e && (n *= 256);) o += this[t + i] * n;
        return o
    }, zg.prototype.readUIntBE = function (t, e, r) {
        t |= 0, e |= 0, r || ly(t, e, this.length);
        for (var o = this[t + --e], n = 1; 0 < e && (n *= 256);) o += this[t + --e] * n;
        return o
    }, zg.prototype.readUInt8 = function (t, e) {
        return e || ly(t, 1, this.length), this[t]
    }, zg.prototype.readUInt16LE = function (t, e) {
        return e || ly(t, 2, this.length), this[t] | this[t + 1] << 8
    }, zg.prototype.readUInt16BE = function (t, e) {
        return e || ly(t, 2, this.length), this[t] << 8 | this[t + 1]
    }, zg.prototype.readUInt32LE = function (t, e) {
        return e || ly(t, 4, this.length), (this[t] | this[t + 1] << 8 | this[t + 2] << 16) + 16777216 * this[t + 3]
    }, zg.prototype.readUInt32BE = function (t, e) {
        return e || ly(t, 4, this.length), 16777216 * this[t] + (this[t + 1] << 16 | this[t + 2] << 8 | this[t + 3])
    }, zg.prototype.readIntLE = function (t, e, r) {
        t |= 0, e |= 0, r || ly(t, e, this.length);
        for (var o = this[t], n = 1, i = 0; ++i < e && (n *= 256);) o += this[t + i] * n;
        return (n *= 128) <= o && (o -= Math.pow(2, 8 * e)), o
    }, zg.prototype.readIntBE = function (t, e, r) {
        t |= 0, e |= 0, r || ly(t, e, this.length);
        for (var o = e, n = 1, i = this[t + --o]; 0 < o && (n *= 256);) i += this[t + --o] * n;
        return (n *= 128) <= i && (i -= Math.pow(2, 8 * e)), i
    }, zg.prototype.readInt8 = function (t, e) {
        return e || ly(t, 1, this.length), 128 & this[t] ? -1 * (255 - this[t] + 1) : this[t]
    }, zg.prototype.readInt16LE = function (t, e) {
        e || ly(t, 2, this.length);
        var r = this[t] | this[t + 1] << 8;
        return 32768 & r ? 4294901760 | r : r
    }, zg.prototype.readInt16BE = function (t, e) {
        e || ly(t, 2, this.length);
        var r = this[t + 1] | this[t] << 8;
        return 32768 & r ? 4294901760 | r : r
    }, zg.prototype.readInt32LE = function (t, e) {
        return e || ly(t, 4, this.length), this[t] | this[t + 1] << 8 | this[t + 2] << 16 | this[t + 3] << 24
    }, zg.prototype.readInt32BE = function (t, e) {
        return e || ly(t, 4, this.length), this[t] << 24 | this[t + 1] << 16 | this[t + 2] << 8 | this[t + 3]
    }, zg.prototype.readFloatLE = function (t, e) {
        return e || ly(t, 4, this.length), Hg(this, t, !0, 23, 4)
    }, zg.prototype.readFloatBE = function (t, e) {
        return e || ly(t, 4, this.length), Hg(this, t, !1, 23, 4)
    }, zg.prototype.readDoubleLE = function (t, e) {
        return e || ly(t, 8, this.length), Hg(this, t, !0, 52, 8)
    }, zg.prototype.readDoubleBE = function (t, e) {
        return e || ly(t, 8, this.length), Hg(this, t, !1, 52, 8)
    }, zg.prototype.writeUIntLE = function (t, e, r, o) {
        t = +t, e |= 0, r |= 0, o || gy(this, t, e, r, Math.pow(2, 8 * r) - 1, 0);
        var n = 1,
            i = 0;
        for (this[e] = 255 & t; ++i < r && (n *= 256);) this[e + i] = t / n & 255;
        return e + r
    }, zg.prototype.writeUIntBE = function (t, e, r, o) {
        t = +t, e |= 0, r |= 0, o || gy(this, t, e, r, Math.pow(2, 8 * r) - 1, 0);
        var n = r - 1,
            i = 1;
        for (this[e + n] = 255 & t; 0 <= --n && (i *= 256);) this[e + n] = t / i & 255;
        return e + r
    }, zg.prototype.writeUInt8 = function (t, e, r) {
        return t = +t, e |= 0, r || gy(this, t, e, 1, 255, 0), zg.TYPED_ARRAY_SUPPORT || (t = Math.floor(t)), this[e] = 255 & t, e + 1
    }, zg.prototype.writeUInt16LE = function (t, e, r) {
        return t = +t, e |= 0, r || gy(this, t, e, 2, 65535, 0), zg.TYPED_ARRAY_SUPPORT ? (this[e] = 255 & t, this[e + 1] = t >>> 8) : yy(this, t, e, !0), e + 2
    }, zg.prototype.writeUInt16BE = function (t, e, r) {
        return t = +t, e |= 0, r || gy(this, t, e, 2, 65535, 0), zg.TYPED_ARRAY_SUPPORT ? (this[e] = t >>> 8, this[e + 1] = 255 & t) : yy(this, t, e, !1), e + 2
    }, zg.prototype.writeUInt32LE = function (t, e, r) {
        return t = +t, e |= 0, r || gy(this, t, e, 4, 4294967295, 0), zg.TYPED_ARRAY_SUPPORT ? (this[e + 3] = t >>> 24, this[e + 2] = t >>> 16, this[e + 1] = t >>> 8, this[e] = 255 & t) : _y(this, t, e, !0), e + 4
    }, zg.prototype.writeUInt32BE = function (t, e, r) {
        return t = +t, e |= 0, r || gy(this, t, e, 4, 4294967295, 0), zg.TYPED_ARRAY_SUPPORT ? (this[e] = t >>> 24, this[e + 1] = t >>> 16, this[e + 2] = t >>> 8, this[e + 3] = 255 & t) : _y(this, t, e, !1), e + 4
    }, zg.prototype.writeIntLE = function (t, e, r, o) {
        if (t = +t, e |= 0, !o) {
            var n = Math.pow(2, 8 * r - 1);
            gy(this, t, e, r, n - 1, -n)
        }
        var i = 0,
            s = 1,
            a = 0;
        for (this[e] = 255 & t; ++i < r && (s *= 256);) t < 0 && 0 === a && 0 !== this[e + i - 1] && (a = 1), this[e + i] = (t / s >> 0) - a & 255;
        return e + r
    }, zg.prototype.writeIntBE = function (t, e, r, o) {
        if (t = +t, e |= 0, !o) {
            var n = Math.pow(2, 8 * r - 1);
            gy(this, t, e, r, n - 1, -n)
        }
        var i = r - 1,
            s = 1,
            a = 0;
        for (this[e + i] = 255 & t; 0 <= --i && (s *= 256);) t < 0 && 0 === a && 0 !== this[e + i + 1] && (a = 1), this[e + i] = (t / s >> 0) - a & 255;
        return e + r
    }, zg.prototype.writeInt8 = function (t, e, r) {
        return t = +t, e |= 0, r || gy(this, t, e, 1, 127, -128), zg.TYPED_ARRAY_SUPPORT || (t = Math.floor(t)), t < 0 && (t = 255 + t + 1), this[e] = 255 & t, e + 1
    }, zg.prototype.writeInt16LE = function (t, e, r) {
        return t = +t, e |= 0, r || gy(this, t, e, 2, 32767, -32768), zg.TYPED_ARRAY_SUPPORT ? (this[e] = 255 & t, this[e + 1] = t >>> 8) : yy(this, t, e, !0), e + 2
    }, zg.prototype.writeInt16BE = function (t, e, r) {
        return t = +t, e |= 0, r || gy(this, t, e, 2, 32767, -32768), zg.TYPED_ARRAY_SUPPORT ? (this[e] = t >>> 8, this[e + 1] = 255 & t) : yy(this, t, e, !1), e + 2
    }, zg.prototype.writeInt32LE = function (t, e, r) {
        return t = +t, e |= 0, r || gy(this, t, e, 4, 2147483647, -2147483648), zg.TYPED_ARRAY_SUPPORT ? (this[e] = 255 & t, this[e + 1] = t >>> 8, this[e + 2] = t >>> 16, this[e + 3] = t >>> 24) : _y(this, t, e, !0), e + 4
    }, zg.prototype.writeInt32BE = function (t, e, r) {
        return t = +t, e |= 0, r || gy(this, t, e, 4, 2147483647, -2147483648), t < 0 && (t = 4294967295 + t + 1), zg.TYPED_ARRAY_SUPPORT ? (this[e] = t >>> 24, this[e + 1] = t >>> 16, this[e + 2] = t >>> 8, this[e + 3] = 255 & t) : _y(this, t, e, !1), e + 4
    }, zg.prototype.writeFloatLE = function (t, e, r) {
        return vy(this, t, e, !0, r)
    }, zg.prototype.writeFloatBE = function (t, e, r) {
        return vy(this, t, e, !1, r)
    }, zg.prototype.writeDoubleLE = function (t, e, r) {
        return wy(this, t, e, !0, r)
    }, zg.prototype.writeDoubleBE = function (t, e, r) {
        return wy(this, t, e, !1, r)
    }, zg.prototype.copy = function (t, e, r, o) {
        if (r = r || 0, o || 0 === o || (o = this.length), e >= t.length && (e = t.length), e = e || 0, 0 < o && o < r && (o = r), o === r) return 0;
        if (0 === t.length || 0 === this.length) return 0;
        if (e < 0) throw new RangeError("targetStart out of bounds");
        if (r < 0 || r >= this.length) throw new RangeError("sourceStart out of bounds");
        if (o < 0) throw new RangeError("sourceEnd out of bounds");
        o > this.length && (o = this.length), t.length - e < o - r && (o = t.length - e + r);
        var n, i = o - r;
        if (this === t && r < e && e < o)
            for (n = i - 1; 0 <= n; --n) t[n + e] = this[n + r];
        else if (i < 1e3 || !zg.TYPED_ARRAY_SUPPORT)
            for (n = 0; n < i; ++n) t[n + e] = this[n + r];
        else Uint8Array.prototype.set.call(t, this.subarray(r, r + i), e);
        return i
    }, zg.prototype.fill = function (t, e, r, o) {
        if ("string" == typeof t) {
            if ("string" == typeof e ? (o = e, e = 0, r = this.length) : "string" == typeof r && (o = r, r = this.length), 1 === t.length) {
                var n = t.charCodeAt(0);
                n < 256 && (t = n)
            }
            if (void 0 !== o && "string" != typeof o) throw new TypeError("encoding must be a string");
            if ("string" == typeof o && !zg.isEncoding(o)) throw new TypeError("Unknown encoding: " + o)
        } else "number" == typeof t && (t &= 255);
        if (e < 0 || this.length < e || this.length < r) throw new RangeError("Out of range index");
        if (r <= e) return this;
        var i;
        if (e >>>= 0, r = void 0 === r ? this.length : r >>> 0, "number" == typeof (t = t || 0))
            for (i = e; i < r; ++i) this[i] = t;
        else {
            var s = ey(t) ? t : by(new zg(t, o).toString()),
                a = s.length;
            for (i = 0; i < r - e; ++i) this[i + e] = s[i % a]
        }
        return this
    };
    var Sy = /[^+\/0-9A-Za-z-_]/g;

    function My(t) {
        return t < 16 ? "0" + t.toString(16) : t.toString(16)
    }

    function by(t, e) {
        var r;
        e = e || 1 / 0;
        for (var o = t.length, n = null, i = [], s = 0; s < o; ++s) {
            if (55295 < (r = t.charCodeAt(s)) && r < 57344) {
                if (!n) {
                    if (56319 < r) {
                        -1 < (e -= 3) && i.push(239, 191, 189);
                        continue
                    }
                    if (s + 1 === o) {
                        -1 < (e -= 3) && i.push(239, 191, 189);
                        continue
                    }
                    n = r;
                    continue
                }
                if (r < 56320) {
                    -1 < (e -= 3) && i.push(239, 191, 189), n = r;
                    continue
                }
                r = 65536 + (n - 55296 << 10 | r - 56320)
            } else n && -1 < (e -= 3) && i.push(239, 191, 189);
            if (n = null, r < 128) {
                if ((e -= 1) < 0) break;
                i.push(r)
            } else if (r < 2048) {
                if ((e -= 2) < 0) break;
                i.push(r >> 6 | 192, 63 & r | 128)
            } else if (r < 65536) {
                if ((e -= 3) < 0) break;
                i.push(r >> 12 | 224, r >> 6 & 63 | 128, 63 & r | 128)
            } else {
                if (!(r < 1114112)) throw new Error("Invalid code point");
                if ((e -= 4) < 0) break;
                i.push(r >> 18 | 240, r >> 12 & 63 | 128, r >> 6 & 63 | 128, 63 & r | 128)
            }
        }
        return i
    }

    function Iy(t) {
        return function (t) {
            var e, r, o, n, i;
            jg || Ag();
            var s = t.length;
            if (0 < s % 4) throw new Error("Invalid string. Length must be a multiple of 4");
            n = "=" === t[s - 2] ? 2 : "=" === t[s - 1] ? 1 : 0, i = new Fg(3 * s / 4 - n), r = 0 < n ? s - 4 : s;
            var a = 0;
            for (e = 0; e < r; e += 4, 3) o = Gg[t.charCodeAt(e)] << 18 | Gg[t.charCodeAt(e + 1)] << 12 | Gg[t.charCodeAt(e + 2)] << 6 | Gg[t.charCodeAt(e + 3)], i[a++] = o >> 16 & 255, i[a++] = o >> 8 & 255, i[a++] = 255 & o;
            return 2 == n ? (o = Gg[t.charCodeAt(e)] << 2 | Gg[t.charCodeAt(e + 1)] >> 4, i[a++] = 255 & o) : 1 == n && (o = Gg[t.charCodeAt(e)] << 10 | Gg[t.charCodeAt(e + 1)] << 4 | Gg[t.charCodeAt(e + 2)] >> 2, i[a++] = o >> 8 & 255, i[a++] = 255 & o), i
        }(function (t) {
            if ((t = function (t) {
                return t.trim ? t.trim() : t.replace(/^\s+|\s+$/g, "")
            }(t).replace(Sy, "")).length < 2) return "";
            for (; t.length % 4 != 0;) t += "=";
            return t
        }(t))
    }

    function By(t, e, r, o) {
        for (var n = 0; n < o && !(n + r >= e.length || n >= t.length); ++n) e[n + r] = t[n];
        return n
    }

    function Ty(t) {
        return null != t && (!!t._isBuffer || Oy(t) || function (t) {
            return "function" == typeof t.readFloatLE && "function" == typeof t.slice && Oy(t.slice(0, 0))
        }(t))
    }

    function Oy(t) {
        return !!t.constructor && "function" == typeof t.constructor.isBuffer && t.constructor.isBuffer(t)
    }

    function Dy() {
        throw new Error("setTimeout has not been defined")
    }

    function Py() {
        throw new Error("clearTimeout has not been defined")
    }
    var Cy = Dy,
        ky = Py;

    function Ly(e) {
        if (Cy === setTimeout) return setTimeout(e, 0);
        if ((Cy === Dy || !Cy) && setTimeout) return Cy = setTimeout, setTimeout(e, 0);
        try {
            return Cy(e, 0)
        } catch (t) {
            try {
                return Cy.call(null, e, 0)
            } catch (t) {
                return Cy.call(this, e, 0)
            }
        }
    }
    "function" == typeof Ng.setTimeout && (Cy = setTimeout), "function" == typeof Ng.clearTimeout && (ky = clearTimeout);
    var Ey, Ny = [],
        Uy = !1,
        Gy = -1;

    function Fy() {
        Uy && Ey && (Uy = !1, Ey.length ? Ny = Ey.concat(Ny) : Gy = -1, Ny.length && jy())
    }

    function jy() {
        if (!Uy) {
            var t = Ly(Fy);
            Uy = !0;
            for (var e = Ny.length; e;) {
                for (Ey = Ny, Ny = []; ++Gy < e;) Ey && Ey[Gy].run();
                Gy = -1, e = Ny.length
            }
            Ey = null, Uy = !1,
                function (e) {
                    if (ky === clearTimeout) return clearTimeout(e);
                    if ((ky === Py || !ky) && clearTimeout) return ky = clearTimeout, clearTimeout(e);
                    try {
                        ky(e)
                    } catch (t) {
                        try {
                            return ky.call(null, e)
                        } catch (t) {
                            return ky.call(this, e)
                        }
                    }
                }(t)
        }
    }

    function Ay(t, e) {
        this.fun = t, this.array = e
    }
    Ay.prototype.run = function () {
        this.fun.apply(null, this.array)
    };

    function xy() { }
    var qy = xy,
        Hy = xy,
        Vy = xy,
        Ky = xy,
        Yy = xy,
        Wy = xy,
        Jy = xy;
    var zy = Ng.performance || {},
        Zy = zy.now || zy.mozNow || zy.msNow || zy.oNow || zy.webkitNow || function () {
            return (new Date).getTime()
        };
    var $y = new Date;
    var Xy = {
        nextTick: function (t) {
            var e = new Array(arguments.length - 1);
            if (1 < arguments.length)
                for (var r = 1; r < arguments.length; r++) e[r - 1] = arguments[r];
            Ny.push(new Ay(t, e)), 1 !== Ny.length || Uy || Ly(jy)
        },
        title: "browser",
        browser: !0,
        env: {},
        argv: [],
        version: "",
        versions: {},
        on: qy,
        addListener: Hy,
        once: Vy,
        off: Ky,
        removeListener: Yy,
        removeAllListeners: Wy,
        emit: Jy,
        binding: function (t) {
            throw new Error("process.binding is not supported")
        },
        cwd: function () {
            return "/"
        },
        chdir: function (t) {
            throw new Error("process.chdir is not supported")
        },
        umask: function () {
            return 0
        },
        hrtime: function (t) {
            var e = .001 * Zy.call(zy),
                r = Math.floor(e),
                o = Math.floor(e % 1 * 1e9);
            return t && (r -= t[0], (o -= t[1]) < 0 && (r--, o += 1e9)), [r, o]
        },
        platform: "browser",
        release: {},
        config: {},
        uptime: function () {
            return (new Date - $y) / 1e3
        }
    },
        Qy = "function" == typeof Object.create ? function (t, e) {
            t.super_ = e, t.prototype = Object.create(e.prototype, {
                constructor: {
                    value: t,
                    enumerable: !1,
                    writable: !0,
                    configurable: !0
                }
            })
        } : function (t, e) {
            t.super_ = e;

            function r() { }
            r.prototype = e.prototype, t.prototype = new r, t.prototype.constructor = t
        },
        t_ = /%[sdj%]/g;

    function e_(t) {
        if (!m_(t)) {
            for (var e = [], r = 0; r < arguments.length; r++) e.push(n_(arguments[r]));
            return e.join(" ")
        }
        r = 1;
        for (var o = arguments, n = o.length, i = String(t).replace(t_, function (t) {
            if ("%%" === t) return "%";
            if (n <= r) return t;
            switch (t) {
                case "%s":
                    return String(o[r++]);
                case "%d":
                    return Number(o[r++]);
                case "%j":
                    try {
                        return JSON.stringify(o[r++])
                    } catch (t) {
                        return "[Circular]"
                    }
                default:
                    return t
            }
        }), s = o[r]; r < n; s = o[++r]) p_(s) || !y_(s) ? i += " " + s : i += " " + n_(s);
        return i
    }
    var r_, o_ = {};

    function n_(t, e) {
        var r = {
            seen: [],
            stylize: s_
        };
        return 3 <= arguments.length && (r.depth = arguments[2]), 4 <= arguments.length && (r.colors = arguments[3]), h_(e) ? r.showHidden = e : e && I_(r, e), l_(r.showHidden) && (r.showHidden = !1), l_(r.depth) && (r.depth = 2), l_(r.colors) && (r.colors = !1), l_(r.customInspect) && (r.customInspect = !0), r.colors && (r.stylize = i_), a_(r, t, r.depth)
    }

    function i_(t, e) {
        var r = n_.styles[e];
        return r ? "[" + n_.colors[r][0] + "m" + t + "[" + n_.colors[r][1] + "m" : t
    }

    function s_(t, e) {
        return t
    }

    function a_(e, r, o) {
        if (e.customInspect && r && v_(r.inspect) && r.inspect !== n_ && (!r.constructor || r.constructor.prototype !== r)) {
            var t = r.inspect(o, e);
            return m_(t) || (t = a_(e, t, o)), t
        }
        var n = function (t, e) {
            if (l_(e)) return t.stylize("undefined", "undefined");
            if (m_(e)) {
                var r = "'" + JSON.stringify(e).replace(/^"|"$/g, "").replace(/'/g, "\\'").replace(/\\"/g, '"') + "'";
                return t.stylize(r, "string")
            }
            if (d_(e)) return t.stylize("" + e, "number");
            if (h_(e)) return t.stylize("" + e, "boolean");
            if (p_(e)) return t.stylize("null", "null")
        }(e, r);
        if (n) return n;
        var i = Object.keys(r),
            s = function (t) {
                var r = {};
                return t.forEach(function (t, e) {
                    r[t] = !0
                }), r
            }(i);
        if (e.showHidden && (i = Object.getOwnPropertyNames(r)), R_(r) && (0 <= i.indexOf("message") || 0 <= i.indexOf("description"))) return u_(r);
        if (0 === i.length) {
            if (v_(r)) {
                var a = r.name ? ": " + r.name : "";
                return e.stylize("[Function" + a + "]", "special")
            }
            if (g_(r)) return e.stylize(RegExp.prototype.toString.call(r), "regexp");
            if (__(r)) return e.stylize(Date.prototype.toString.call(r), "date");
            if (R_(r)) return u_(r)
        }
        var u, c = "",
            f = !1,
            h = ["{", "}"];
        f_(r) && (f = !0, h = ["[", "]"]), v_(r) && (c = " [Function" + (r.name ? ": " + r.name : "") + "]");
        return g_(r) && (c = " " + RegExp.prototype.toString.call(r)), __(r) && (c = " " + Date.prototype.toUTCString.call(r)), R_(r) && (c = " " + u_(r)), 0 !== i.length || f && 0 != r.length ? o < 0 ? g_(r) ? e.stylize(RegExp.prototype.toString.call(r), "regexp") : e.stylize("[Object]", "special") : (e.seen.push(r), u = f ? function (e, r, o, n, t) {
            for (var i = [], s = 0, a = r.length; s < a; ++s) B_(r, String(s)) ? i.push(c_(e, r, o, n, String(s), !0)) : i.push("");
            return t.forEach(function (t) {
                t.match(/^\d+$/) || i.push(c_(e, r, o, n, t, !0))
            }), i
        }(e, r, o, s, i) : i.map(function (t) {
            return c_(e, r, o, s, t, f)
        }), e.seen.pop(), function (t, e, r) {
            if (60 < t.reduce(function (t, e) {
                return e.indexOf("\n"), t + e.replace(/\u001b\[\d\d?m/g, "").length + 1
            }, 0)) return r[0] + ("" === e ? "" : e + "\n ") + " " + t.join(",\n  ") + " " + r[1];
            return r[0] + e + " " + t.join(", ") + " " + r[1]
        }(u, c, h)) : h[0] + c + h[1]
    }

    function u_(t) {
        return "[" + Error.prototype.toString.call(t) + "]"
    }

    function c_(t, e, r, o, n, i) {
        var s, a, u;
        if ((u = Object.getOwnPropertyDescriptor(e, n) || {
            value: e[n]
        }).get ? a = u.set ? t.stylize("[Getter/Setter]", "special") : t.stylize("[Getter]", "special") : u.set && (a = t.stylize("[Setter]", "special")), B_(o, n) || (s = "[" + n + "]"), a || (t.seen.indexOf(u.value) < 0 ? -1 < (a = p_(r) ? a_(t, u.value, null) : a_(t, u.value, r - 1)).indexOf("\n") && (a = i ? a.split("\n").map(function (t) {
            return "  " + t
        }).join("\n").substr(2) : "\n" + a.split("\n").map(function (t) {
            return "   " + t
        }).join("\n")) : a = t.stylize("[Circular]", "special")), l_(s)) {
            if (i && n.match(/^\d+$/)) return a;
            s = (s = JSON.stringify("" + n)).match(/^"([a-zA-Z_][a-zA-Z_0-9]*)"$/) ? (s = s.substr(1, s.length - 2), t.stylize(s, "name")) : (s = s.replace(/'/g, "\\'").replace(/\\"/g, '"').replace(/(^"|"$)/g, "'"), t.stylize(s, "string"))
        }
        return s + ": " + a
    }

    function f_(t) {
        return Array.isArray(t)
    }

    function h_(t) {
        return "boolean" == typeof t
    }

    function p_(t) {
        return null === t
    }

    function d_(t) {
        return "number" == typeof t
    }

    function m_(t) {
        return "string" == typeof t
    }

    function l_(t) {
        return void 0 === t
    }

    function g_(t) {
        return y_(t) && "[object RegExp]" === S_(t)
    }

    function y_(t) {
        return "object" == typeof t && null !== t
    }

    function __(t) {
        return y_(t) && "[object Date]" === S_(t)
    }

    function R_(t) {
        return y_(t) && ("[object Error]" === S_(t) || t instanceof Error)
    }

    function v_(t) {
        return "function" == typeof t
    }

    function w_(t) {
        return null === t || "boolean" == typeof t || "number" == typeof t || "string" == typeof t || "symbol" == typeof t || void 0 === t
    }

    function S_(t) {
        return Object.prototype.toString.call(t)
    }

    function M_(t) {
        return t < 10 ? "0" + t.toString(10) : t.toString(10)
    }
    n_.colors = {
        bold: [1, 22],
        italic: [3, 23],
        underline: [4, 24],
        inverse: [7, 27],
        white: [37, 39],
        grey: [90, 39],
        black: [30, 39],
        blue: [34, 39],
        cyan: [36, 39],
        green: [32, 39],
        magenta: [35, 39],
        red: [31, 39],
        yellow: [33, 39]
    }, n_.styles = {
        special: "cyan",
        number: "yellow",
        boolean: "yellow",
        undefined: "grey",
        null: "bold",
        string: "green",
        date: "magenta",
        regexp: "red"
    };
    var b_ = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];

    function I_(t, e) {
        if (!e || !y_(e)) return t;
        for (var r = Object.keys(e), o = r.length; o--;) t[r[o]] = e[r[o]];
        return t
    }

    function B_(t, e) {
        return Object.prototype.hasOwnProperty.call(t, e)
    }
    var T_ = {
        inherits: Qy,
        _extend: I_,
        log: function () {
            console.log("%s - %s", function () {
                var t = new Date,
                    e = [M_(t.getHours()), M_(t.getMinutes()), M_(t.getSeconds())].join(":");
                return [t.getDate(), b_[t.getMonth()], e].join(" ")
            }(), e_.apply(null, arguments))
        },
        isBuffer: function (t) {
            return Ty(t)
        },
        isPrimitive: w_,
        isFunction: v_,
        isError: R_,
        isDate: __,
        isObject: y_,
        isRegExp: g_,
        isUndefined: l_,
        isSymbol: function (t) {
            return "symbol" == typeof t
        },
        isString: m_,
        isNumber: d_,
        isNullOrUndefined: function (t) {
            return null == t
        },
        isNull: p_,
        isBoolean: h_,
        isArray: f_,
        inspect: n_,
        deprecate: function t(e, r) {
            if (l_(Ng.process)) return function () {
                return t(e, r).apply(this, arguments)
            };
            var o = !1;
            return function () {
                return o || (console.error(r), o = !0), e.apply(this, arguments)
            }
        },
        format: e_,
        debuglog: function (e) {
            if (l_(r_) && (r_ = ""), e = e.toUpperCase(), !o_[e])
                if (new RegExp("\\b" + e + "\\b", "i").test(r_)) {
                    o_[e] = function () {
                        var t = e_.apply(null, arguments);
                        console.error("%s %d: %s", e, 0, t)
                    }
                } else o_[e] = function () { };
            return o_[e]
        }
    };

    function O_(t, e) {
        if (t === e) return 0;
        for (var r = t.length, o = e.length, n = 0, i = Math.min(r, o); n < i; ++n)
            if (t[n] !== e[n]) {
                r = t[n], o = e[n];
                break
            }
        return r < o ? -1 : o < r ? 1 : 0
    }
    var D_, P_ = Object.prototype.hasOwnProperty,
        C_ = Object.keys || function (t) {
            var e = [];
            for (var r in t) P_.call(t, r) && e.push(r);
            return e
        },
        k_ = Array.prototype.slice;

    function L_() {
        return void 0 !== D_ ? D_ : D_ = "foo" === function () { }.name
    }

    function E_(t) {
        return Object.prototype.toString.call(t)
    }

    function N_(t) {
        return !Ty(t) && ("function" == typeof Ng.ArrayBuffer && ("function" == typeof ArrayBuffer.isView ? ArrayBuffer.isView(t) : !!t && (t instanceof DataView || !!(t.buffer && t.buffer instanceof ArrayBuffer))))
    }

    function U_(t, e) {
        t || q_(t, !0, e, "==", H_)
    }
    var G_ = /\s*function\s+([^\(\s]*)\s*/;

    function F_(t) {
        if (v_(t)) {
            if (L_()) return t.name;
            var e = t.toString().match(G_);
            return e && e[1]
        }
    }

    function j_(t) {
        this.name = "AssertionError", this.actual = t.actual, this.expected = t.expected, this.operator = t.operator, t.message ? (this.message = t.message, this.generatedMessage = !1) : (this.message = function (t) {
            return A_(x_(t.actual), 128) + " " + t.operator + " " + A_(x_(t.expected), 128)
        }(this), this.generatedMessage = !0);
        var e = t.stackStartFunction || q_;
        if (Error.captureStackTrace) Error.captureStackTrace(this, e);
        else {
            var r = new Error;
            if (r.stack) {
                var o = r.stack,
                    n = F_(e),
                    i = o.indexOf("\n" + n);
                if (0 <= i) {
                    var s = o.indexOf("\n", i + 1);
                    o = o.substring(s + 1)
                }
                this.stack = o
            }
        }
    }

    function A_(t, e) {
        return "string" == typeof t ? t.length < e ? t : t.slice(0, e) : t
    }

    function x_(t) {
        if (L_() || !v_(t)) return n_(t);
        var e = F_(t);
        return "[Function" + (e ? ": " + e : "") + "]"
    }

    function q_(t, e, r, o, n) {
        throw new j_({
            message: r,
            actual: t,
            expected: e,
            operator: o,
            stackStartFunction: n
        })
    }

    function H_(t, e) {
        t || q_(t, !0, e, "==", H_)
    }

    function V_(t, e, r, o) {
        if (t === e) return !0;
        if (Ty(t) && Ty(e)) return 0 === O_(t, e);
        if (__(t) && __(e)) return t.getTime() === e.getTime();
        if (g_(t) && g_(e)) return t.source === e.source && t.global === e.global && t.multiline === e.multiline && t.lastIndex === e.lastIndex && t.ignoreCase === e.ignoreCase;
        if (null !== t && "object" == typeof t || null !== e && "object" == typeof e) {
            if (N_(t) && N_(e) && E_(t) === E_(e) && !(t instanceof Float32Array || t instanceof Float64Array)) return 0 === O_(new Uint8Array(t.buffer), new Uint8Array(e.buffer));
            if (Ty(t) !== Ty(e)) return !1;
            var n = (o = o || {
                actual: [],
                expected: []
            }).actual.indexOf(t);
            return -1 !== n && n === o.expected.indexOf(e) || (o.actual.push(t), o.expected.push(e), function (t, e, r, o) {
                if (null == t || null == e) return !1;
                if (w_(t) || w_(e)) return t === e;
                if (r && Object.getPrototypeOf(t) !== Object.getPrototypeOf(e)) return !1;
                var n = K_(t),
                    i = K_(e);
                if (n && !i || !n && i) return !1;
                if (n) return t = k_.call(t), e = k_.call(e), V_(t, e, r);
                var s, a, u = C_(t),
                    c = C_(e);
                if (u.length !== c.length) return !1;
                for (u.sort(), c.sort(), a = u.length - 1; 0 <= a; a--)
                    if (u[a] !== c[a]) return !1;
                for (a = u.length - 1; 0 <= a; a--)
                    if (s = u[a], !V_(t[s], e[s], r, o)) return !1;
                return !0
            }(t, e, r, o))
        }
        return r ? t === e : t == e
    }

    function K_(t) {
        return "[object Arguments]" == Object.prototype.toString.call(t)
    }

    function Y_(t, e) {
        if (!t || !e) return !1;
        if ("[object RegExp]" == Object.prototype.toString.call(e)) return e.test(t);
        try {
            if (t instanceof e) return !0
        } catch (t) { }
        return !Error.isPrototypeOf(e) && !0 === e.call({}, t)
    }

    function W_(t, e, r, o) {
        var n;
        if ("function" != typeof e) throw new TypeError('"block" argument must be a function');
        "string" == typeof r && (o = r, r = null), n = function (t) {
            var e;
            try {
                t()
            } catch (t) {
                e = t
            }
            return e
        }(e), o = (r && r.name ? " (" + r.name + ")." : ".") + (o ? " " + o : "."), t && !n && q_(n, r, "Missing expected exception" + o);
        var i = "string" == typeof o,
            s = !t && n && !r;
        if ((!t && R_(n) && i && Y_(n, r) || s) && q_(n, r, "Got unwanted exception" + o), t && n && r && !Y_(n, r) || !t && n) throw n
    }
    Qy(U_.AssertionError = j_, Error), U_.fail = q_, U_.ok = H_, U_.equal = function t(e, r, o) {
        e != r && q_(e, r, o, "==", t)
    }, U_.notEqual = function t(e, r, o) {
        e == r && q_(e, r, o, "!=", t)
    }, U_.deepEqual = function t(e, r, o) {
        V_(e, r, !1) || q_(e, r, o, "deepEqual", t)
    }, U_.deepStrictEqual = function t(e, r, o) {
        V_(e, r, !0) || q_(e, r, o, "deepStrictEqual", t)
    }, U_.notDeepEqual = function t(e, r, o) {
        V_(e, r, !1) && q_(e, r, o, "notDeepEqual", t)
    }, U_.notDeepStrictEqual = function t(e, r, o) {
        V_(e, r, !0) && q_(e, r, o, "notDeepStrictEqual", t)
    }, U_.strictEqual = function t(e, r, o) {
        e !== r && q_(e, r, o, "===", t)
    }, U_.notStrictEqual = function t(e, r, o) {
        e === r && q_(e, r, o, "!==", t)
    }, U_.throws = function (t, e, r) {
        W_(!0, t, e, r)
    }, U_.doesNotThrow = function (t, e, r) {
        W_(!1, t, e, r)
    }, U_.ifError = function (t) {
        if (t) throw t
    };
    for (var J_ = function (t) {
        var e = oR(t),
            r = e[0],
            o = e[1];
        return 3 * (r + o) / 4 - o
    }, z_ = function (t) {
        var e, r, o = oR(t),
            n = o[0],
            i = o[1],
            s = new Q_(function (t, e, r) {
                return 3 * (e + r) / 4 - r
            }(0, n, i)),
            a = 0,
            u = 0 < i ? n - 4 : n;
        for (r = 0; r < u; r += 4) e = X_[t.charCodeAt(r)] << 18 | X_[t.charCodeAt(r + 1)] << 12 | X_[t.charCodeAt(r + 2)] << 6 | X_[t.charCodeAt(r + 3)], s[a++] = e >> 16 & 255, s[a++] = e >> 8 & 255, s[a++] = 255 & e;
        2 === i && (e = X_[t.charCodeAt(r)] << 2 | X_[t.charCodeAt(r + 1)] >> 4, s[a++] = 255 & e);
        1 === i && (e = X_[t.charCodeAt(r)] << 10 | X_[t.charCodeAt(r + 1)] << 4 | X_[t.charCodeAt(r + 2)] >> 2, s[a++] = e >> 8 & 255, s[a++] = 255 & e);
        return s
    }, Z_ = function (t) {
        for (var e, r = t.length, o = r % 3, n = [], i = 0, s = r - o; i < s; i += 16383) n.push(nR(t, i, s < i + 16383 ? s : i + 16383));
        1 == o ? (e = t[r - 1], n.push($_[e >> 2] + $_[e << 4 & 63] + "==")) : 2 == o && (e = (t[r - 2] << 8) + t[r - 1], n.push($_[e >> 10] + $_[e >> 4 & 63] + $_[e << 2 & 63] + "="));
        return n.join("")
    }, $_ = [], X_ = [], Q_ = "undefined" != typeof Uint8Array ? Uint8Array : Array, tR = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", eR = 0, rR = tR.length; eR < rR; ++eR) $_[eR] = tR[eR], X_[tR.charCodeAt(eR)] = eR;

    function oR(t) {
        var e = t.length;
        if (0 < e % 4) throw new Error("Invalid string. Length must be a multiple of 4");
        var r = t.indexOf("=");
        return -1 === r && (r = e), [r, r === e ? 0 : 4 - r % 4]
    }

    function nR(t, e, r) {
        for (var o, n, i = [], s = e; s < r; s += 3) o = (t[s] << 16 & 16711680) + (t[s + 1] << 8 & 65280) + (255 & t[s + 2]), i.push($_[(n = o) >> 18 & 63] + $_[n >> 12 & 63] + $_[n >> 6 & 63] + $_[63 & n]);
        return i.join("")
    }
    X_["-".charCodeAt(0)] = 62, X_["_".charCodeAt(0)] = 63;
    var iR = {
        byteLength: J_,
        toByteArray: z_,
        fromByteArray: Z_
    },
        sR = function (t, e, r, o, n) {
            var i, s, a = 8 * n - o - 1,
                u = (1 << a) - 1,
                c = u >> 1,
                f = -7,
                h = r ? n - 1 : 0,
                p = r ? -1 : 1,
                d = t[e + h];
            for (h += p, i = d & (1 << -f) - 1, d >>= -f, f += a; 0 < f; i = 256 * i + t[e + h], h += p, f -= 8);
            for (s = i & (1 << -f) - 1, i >>= -f, f += o; 0 < f; s = 256 * s + t[e + h], h += p, f -= 8);
            if (0 === i) i = 1 - c;
            else {
                if (i === u) return s ? NaN : 1 / 0 * (d ? -1 : 1);
                s += Math.pow(2, o), i -= c
            }
            return (d ? -1 : 1) * s * Math.pow(2, i - o)
        },
        aR = function (t, e, r, o, n, i) {
            var s, a, u, c = 8 * i - n - 1,
                f = (1 << c) - 1,
                h = f >> 1,
                p = 23 === n ? Math.pow(2, -24) - Math.pow(2, -77) : 0,
                d = o ? 0 : i - 1,
                m = o ? 1 : -1,
                l = e < 0 || 0 === e && 1 / e < 0 ? 1 : 0;
            for (e = Math.abs(e), isNaN(e) || e === 1 / 0 ? (a = isNaN(e) ? 1 : 0, s = f) : (s = Math.floor(Math.log(e) / Math.LN2), e * (u = Math.pow(2, -s)) < 1 && (s--, u *= 2), 2 <= (e += 1 <= s + h ? p / u : p * Math.pow(2, 1 - h)) * u && (s++, u /= 2), f <= s + h ? (a = 0, s = f) : 1 <= s + h ? (a = (e * u - 1) * Math.pow(2, n), s += h) : (a = e * Math.pow(2, h - 1) * Math.pow(2, n), s = 0)); 8 <= n; t[r + d] = 255 & a, d += m, a /= 256, n -= 8);
            for (s = s << n | a, c += n; 0 < c; t[r + d] = 255 & s, d += m, s /= 256, c -= 8);
            t[r + d - m] |= 128 * l
        },
        uR = t(function (t, r) {
            var e = "function" == typeof Symbol ? Symbol.for("nodejs.util.inspect.custom") : null;
            r.Buffer = h, r.SlowBuffer = function (t) {
                +t != t && (t = 0);
                return h.alloc(+t)
            }, r.INSPECT_MAX_BYTES = 50;
            var o = 2147483647;

            function i(t) {
                if (o < t) throw new RangeError('The value "' + t + '" is invalid for option "size"');
                var e = new Uint8Array(t);
                return Object.setPrototypeOf(e, h.prototype), e
            }

            function h(t, e, r) {
                if ("number" != typeof t) return n(t, e, r);
                if ("string" == typeof e) throw new TypeError('The "string" argument must be of type string. Received type number');
                return a(t)
            }

            function n(t, e, r) {
                if ("string" == typeof t) return function (t, e) {
                    "string" == typeof e && "" !== e || (e = "utf8");
                    if (!h.isEncoding(e)) throw new TypeError("Unknown encoding: " + e);
                    var r = 0 | f(t, e),
                        o = i(r),
                        n = o.write(t, e);
                    n !== r && (o = o.slice(0, n));
                    return o
                }(t, e);
                if (ArrayBuffer.isView(t)) return u(t);
                if (null == t) throw new TypeError("The first argument must be one of type string, Buffer, ArrayBuffer, Array, or Array-like Object. Received type " + typeof t);
                if (E(t, ArrayBuffer) || t && E(t.buffer, ArrayBuffer)) return function (t, e, r) {
                    if (e < 0 || t.byteLength < e) throw new RangeError('"offset" is outside of buffer bounds');
                    if (t.byteLength < e + (r || 0)) throw new RangeError('"length" is outside of buffer bounds');
                    var o;
                    o = void 0 === e && void 0 === r ? new Uint8Array(t) : void 0 === r ? new Uint8Array(t, e) : new Uint8Array(t, e, r);
                    return Object.setPrototypeOf(o, h.prototype), o
                }(t, e, r);
                if ("number" == typeof t) throw new TypeError('The "value" argument must not be of type number. Received type number');
                var o = t.valueOf && t.valueOf();
                if (null != o && o !== t) return h.from(o, e, r);
                var n = function (t) {
                    if (h.isBuffer(t)) {
                        var e = 0 | c(t.length),
                            r = i(e);
                        return 0 === r.length || t.copy(r, 0, 0, e), r
                    }
                    if (void 0 !== t.length) return "number" != typeof t.length || N(t.length) ? i(0) : u(t);
                    if ("Buffer" === t.type && Array.isArray(t.data)) return u(t.data)
                }(t);
                if (n) return n;
                if ("undefined" != typeof Symbol && null != Symbol.toPrimitive && "function" == typeof t[Symbol.toPrimitive]) return h.from(t[Symbol.toPrimitive]("string"), e, r);
                throw new TypeError("The first argument must be one of type string, Buffer, ArrayBuffer, Array, or Array-like Object. Received type " + typeof t)
            }

            function s(t) {
                if ("number" != typeof t) throw new TypeError('"size" argument must be of type number');
                if (t < 0) throw new RangeError('The value "' + t + '" is invalid for option "size"')
            }

            function a(t) {
                return s(t), i(t < 0 ? 0 : 0 | c(t))
            }

            function u(t) {
                for (var e = t.length < 0 ? 0 : 0 | c(t.length), r = i(e), o = 0; o < e; o += 1) r[o] = 255 & t[o];
                return r
            }

            function c(t) {
                if (o <= t) throw new RangeError("Attempt to allocate Buffer larger than maximum size: 0x" + o.toString(16) + " bytes");
                return 0 | t
            }

            function f(t, e) {
                if (h.isBuffer(t)) return t.length;
                if (ArrayBuffer.isView(t) || E(t, ArrayBuffer)) return t.byteLength;
                if ("string" != typeof t) throw new TypeError('The "string" argument must be one of type string, Buffer, or ArrayBuffer. Received type ' + typeof t);
                var r = t.length,
                    o = 2 < arguments.length && !0 === arguments[2];
                if (!o && 0 === r) return 0;
                for (var n = !1; ;) switch (e) {
                    case "ascii":
                    case "latin1":
                    case "binary":
                        return r;
                    case "utf8":
                    case "utf-8":
                        return C(t).length;
                    case "ucs2":
                    case "ucs-2":
                    case "utf16le":
                    case "utf-16le":
                        return 2 * r;
                    case "hex":
                        return r >>> 1;
                    case "base64":
                        return k(t).length;
                    default:
                        if (n) return o ? -1 : C(t).length;
                        e = ("" + e).toLowerCase(), n = !0
                }
            }

            function p(t, e, r) {
                var o = t[e];
                t[e] = t[r], t[r] = o
            }

            function d(t, e, r, o, n) {
                if (0 === t.length) return -1;
                if ("string" == typeof r ? (o = r, r = 0) : 2147483647 < r ? r = 2147483647 : r < -2147483648 && (r = -2147483648), N(r = +r) && (r = n ? 0 : t.length - 1), r < 0 && (r = t.length + r), r >= t.length) {
                    if (n) return -1;
                    r = t.length - 1
                } else if (r < 0) {
                    if (!n) return -1;
                    r = 0
                }
                if ("string" == typeof e && (e = h.from(e, o)), h.isBuffer(e)) return 0 === e.length ? -1 : m(t, e, r, o, n);
                if ("number" == typeof e) return e &= 255, "function" == typeof Uint8Array.prototype.indexOf ? n ? Uint8Array.prototype.indexOf.call(t, e, r) : Uint8Array.prototype.lastIndexOf.call(t, e, r) : m(t, [e], r, o, n);
                throw new TypeError("val must be string, number or Buffer")
            }

            function m(t, e, r, o, n) {
                var i, s = 1,
                    a = t.length,
                    u = e.length;
                if (void 0 !== o && ("ucs2" === (o = String(o).toLowerCase()) || "ucs-2" === o || "utf16le" === o || "utf-16le" === o)) {
                    if (t.length < 2 || e.length < 2) return -1;
                    a /= s = 2, u /= 2, r /= 2
                }

                function c(t, e) {
                    return 1 === s ? t[e] : t.readUInt16BE(e * s)
                }
                if (n) {
                    var f = -1;
                    for (i = r; i < a; i++)
                        if (c(t, i) === c(e, -1 === f ? 0 : i - f)) {
                            if (-1 === f && (f = i), i - f + 1 === u) return f * s
                        } else -1 !== f && (i -= i - f), f = -1
                } else
                    for (a < r + u && (r = a - u), i = r; 0 <= i; i--) {
                        for (var h = !0, p = 0; p < u; p++)
                            if (c(t, i + p) !== c(e, p)) {
                                h = !1;
                                break
                            }
                        if (h) return i
                    }
                return -1
            }

            function l(t, e, r, o) {
                r = Number(r) || 0;
                var n = t.length - r;
                o ? n < (o = Number(o)) && (o = n) : o = n;
                var i = e.length;
                i / 2 < o && (o = i / 2);
                for (var s = 0; s < o; ++s) {
                    var a = parseInt(e.substr(2 * s, 2), 16);
                    if (N(a)) return s;
                    t[r + s] = a
                }
                return s
            }

            function g(t, e, r, o) {
                return L(function (t) {
                    for (var e = [], r = 0; r < t.length; ++r) e.push(255 & t.charCodeAt(r));
                    return e
                }(e), t, r, o)
            }

            function y(t, e, r) {
                return 0 === e && r === t.length ? iR.fromByteArray(t) : iR.fromByteArray(t.slice(e, r))
            }

            function _(t, e, r) {
                r = Math.min(t.length, r);
                for (var o = [], n = e; n < r;) {
                    var i, s, a, u, c = t[n],
                        f = null,
                        h = 239 < c ? 4 : 223 < c ? 3 : 191 < c ? 2 : 1;
                    if (n + h <= r) switch (h) {
                        case 1:
                            c < 128 && (f = c);
                            break;
                        case 2:
                            128 == (192 & (i = t[n + 1])) && 127 < (u = (31 & c) << 6 | 63 & i) && (f = u);
                            break;
                        case 3:
                            i = t[n + 1], s = t[n + 2], 128 == (192 & i) && 128 == (192 & s) && 2047 < (u = (15 & c) << 12 | (63 & i) << 6 | 63 & s) && (u < 55296 || 57343 < u) && (f = u);
                            break;
                        case 4:
                            i = t[n + 1], s = t[n + 2], a = t[n + 3], 128 == (192 & i) && 128 == (192 & s) && 128 == (192 & a) && 65535 < (u = (15 & c) << 18 | (63 & i) << 12 | (63 & s) << 6 | 63 & a) && u < 1114112 && (f = u)
                    }
                    null === f ? (f = 65533, h = 1) : 65535 < f && (f -= 65536, o.push(f >>> 10 & 1023 | 55296), f = 56320 | 1023 & f), o.push(f), n += h
                }
                return function (t) {
                    var e = t.length;
                    if (e <= R) return String.fromCharCode.apply(String, t);
                    var r = "",
                        o = 0;
                    for (; o < e;) r += String.fromCharCode.apply(String, t.slice(o, o += R));
                    return r
                }(o)
            }
            r.kMaxLength = o, (h.TYPED_ARRAY_SUPPORT = function () {
                try {
                    var t = new Uint8Array(1),
                        e = {
                            foo: function () {
                                return 42
                            }
                        };
                    return Object.setPrototypeOf(e, Uint8Array.prototype), Object.setPrototypeOf(t, e), 42 === t.foo()
                } catch (t) {
                    return !1
                }
            }()) || "undefined" == typeof console || "function" != typeof console.error || console.error("This browser lacks typed array (Uint8Array) support which is required by `buffer` v5.x. Use `buffer` v4.x if you require old browser support."), Object.defineProperty(h.prototype, "parent", {
                enumerable: !0,
                get: function () {
                    if (h.isBuffer(this)) return this.buffer
                }
            }), Object.defineProperty(h.prototype, "offset", {
                enumerable: !0,
                get: function () {
                    if (h.isBuffer(this)) return this.byteOffset
                }
            }), "undefined" != typeof Symbol && null != Symbol.species && h[Symbol.species] === h && Object.defineProperty(h, Symbol.species, {
                value: null,
                configurable: !0,
                enumerable: !1,
                writable: !1
            }), h.poolSize = 8192, h.from = function (t, e, r) {
                return n(t, e, r)
            }, Object.setPrototypeOf(h.prototype, Uint8Array.prototype), Object.setPrototypeOf(h, Uint8Array), h.alloc = function (t, e, r) {
                return function (t, e, r) {
                    return s(t), t <= 0 ? i(t) : void 0 !== e ? "string" == typeof r ? i(t).fill(e, r) : i(t).fill(e) : i(t)
                }(t, e, r)
            }, h.allocUnsafe = function (t) {
                return a(t)
            }, h.allocUnsafeSlow = function (t) {
                return a(t)
            }, h.isBuffer = function (t) {
                return null != t && !0 === t._isBuffer && t !== h.prototype
            }, h.compare = function (t, e) {
                if (E(t, Uint8Array) && (t = h.from(t, t.offset, t.byteLength)), E(e, Uint8Array) && (e = h.from(e, e.offset, e.byteLength)), !h.isBuffer(t) || !h.isBuffer(e)) throw new TypeError('The "buf1", "buf2" arguments must be one of type Buffer or Uint8Array');
                if (t === e) return 0;
                for (var r = t.length, o = e.length, n = 0, i = Math.min(r, o); n < i; ++n)
                    if (t[n] !== e[n]) {
                        r = t[n], o = e[n];
                        break
                    }
                return r < o ? -1 : o < r ? 1 : 0
            }, h.isEncoding = function (t) {
                switch (String(t).toLowerCase()) {
                    case "hex":
                    case "utf8":
                    case "utf-8":
                    case "ascii":
                    case "latin1":
                    case "binary":
                    case "base64":
                    case "ucs2":
                    case "ucs-2":
                    case "utf16le":
                    case "utf-16le":
                        return !0;
                    default:
                        return !1
                }
            }, h.concat = function (t, e) {
                if (!Array.isArray(t)) throw new TypeError('"list" argument must be an Array of Buffers');
                if (0 === t.length) return h.alloc(0);
                var r;
                if (void 0 === e)
                    for (r = e = 0; r < t.length; ++r) e += t[r].length;
                var o = h.allocUnsafe(e),
                    n = 0;
                for (r = 0; r < t.length; ++r) {
                    var i = t[r];
                    if (E(i, Uint8Array) && (i = h.from(i)), !h.isBuffer(i)) throw new TypeError('"list" argument must be an Array of Buffers');
                    i.copy(o, n), n += i.length
                }
                return o
            }, h.byteLength = f, h.prototype._isBuffer = !0, h.prototype.swap16 = function () {
                var t = this.length;
                if (t % 2 != 0) throw new RangeError("Buffer size must be a multiple of 16-bits");
                for (var e = 0; e < t; e += 2) p(this, e, e + 1);
                return this
            }, h.prototype.swap32 = function () {
                var t = this.length;
                if (t % 4 != 0) throw new RangeError("Buffer size must be a multiple of 32-bits");
                for (var e = 0; e < t; e += 4) p(this, e, e + 3), p(this, e + 1, e + 2);
                return this
            }, h.prototype.swap64 = function () {
                var t = this.length;
                if (t % 8 != 0) throw new RangeError("Buffer size must be a multiple of 64-bits");
                for (var e = 0; e < t; e += 8) p(this, e, e + 7), p(this, e + 1, e + 6), p(this, e + 2, e + 5), p(this, e + 3, e + 4);
                return this
            }, h.prototype.toLocaleString = h.prototype.toString = function () {
                var t = this.length;
                return 0 === t ? "" : 0 === arguments.length ? _(this, 0, t) : function (t, e, r) {
                    var o = !1;
                    if ((void 0 === e || e < 0) && (e = 0), e > this.length) return "";
                    if ((void 0 === r || r > this.length) && (r = this.length), r <= 0) return "";
                    if ((r >>>= 0) <= (e >>>= 0)) return "";
                    for (t = t || "utf8"; ;) switch (t) {
                        case "hex":
                            return S(this, e, r);
                        case "utf8":
                        case "utf-8":
                            return _(this, e, r);
                        case "ascii":
                            return v(this, e, r);
                        case "latin1":
                        case "binary":
                            return w(this, e, r);
                        case "base64":
                            return y(this, e, r);
                        case "ucs2":
                        case "ucs-2":
                        case "utf16le":
                        case "utf-16le":
                            return M(this, e, r);
                        default:
                            if (o) throw new TypeError("Unknown encoding: " + t);
                            t = (t + "").toLowerCase(), o = !0
                    }
                }.apply(this, arguments)
            }, h.prototype.equals = function (t) {
                if (!h.isBuffer(t)) throw new TypeError("Argument must be a Buffer");
                return this === t || 0 === h.compare(this, t)
            }, h.prototype.inspect = function () {
                var t = "",
                    e = r.INSPECT_MAX_BYTES;
                return t = this.toString("hex", 0, e).replace(/(.{2})/g, "$1 ").trim(), this.length > e && (t += " ... "), "<Buffer " + t + ">"
            }, e && (h.prototype[e] = h.prototype.inspect), h.prototype.compare = function (t, e, r, o, n) {
                if (E(t, Uint8Array) && (t = h.from(t, t.offset, t.byteLength)), !h.isBuffer(t)) throw new TypeError('The "target" argument must be one of type Buffer or Uint8Array. Received type ' + typeof t);
                if (void 0 === e && (e = 0), void 0 === r && (r = t ? t.length : 0), void 0 === o && (o = 0), void 0 === n && (n = this.length), e < 0 || r > t.length || o < 0 || n > this.length) throw new RangeError("out of range index");
                if (n <= o && r <= e) return 0;
                if (n <= o) return -1;
                if (r <= e) return 1;
                if (this === t) return 0;
                for (var i = (n >>>= 0) - (o >>>= 0), s = (r >>>= 0) - (e >>>= 0), a = Math.min(i, s), u = this.slice(o, n), c = t.slice(e, r), f = 0; f < a; ++f)
                    if (u[f] !== c[f]) {
                        i = u[f], s = c[f];
                        break
                    }
                return i < s ? -1 : s < i ? 1 : 0
            }, h.prototype.includes = function (t, e, r) {
                return -1 !== this.indexOf(t, e, r)
            }, h.prototype.indexOf = function (t, e, r) {
                return d(this, t, e, r, !0)
            }, h.prototype.lastIndexOf = function (t, e, r) {
                return d(this, t, e, r, !1)
            }, h.prototype.write = function (t, e, r, o) {
                if (void 0 === e) o = "utf8", r = this.length, e = 0;
                else if (void 0 === r && "string" == typeof e) o = e, r = this.length, e = 0;
                else {
                    if (!isFinite(e)) throw new Error("Buffer.write(string, encoding, offset[, length]) is no longer supported");
                    e >>>= 0, isFinite(r) ? (r >>>= 0, void 0 === o && (o = "utf8")) : (o = r, r = void 0)
                }
                var n = this.length - e;
                if ((void 0 === r || n < r) && (r = n), 0 < t.length && (r < 0 || e < 0) || e > this.length) throw new RangeError("Attempt to write outside buffer bounds");
                o = o || "utf8";
                for (var i, s, a, u, c, f, h, p, d, m = !1; ;) switch (o) {
                    case "hex":
                        return l(this, t, e, r);
                    case "utf8":
                    case "utf-8":
                        return p = e, d = r, L(C(t, (h = this).length - p), h, p, d);
                    case "ascii":
                        return g(this, t, e, r);
                    case "latin1":
                    case "binary":
                        return g(this, t, e, r);
                    case "base64":
                        return u = this, c = e, f = r, L(k(t), u, c, f);
                    case "ucs2":
                    case "ucs-2":
                    case "utf16le":
                    case "utf-16le":
                        return s = e, a = r, L(function (t, e) {
                            for (var r, o, n, i = [], s = 0; s < t.length && !((e -= 2) < 0); ++s) r = t.charCodeAt(s), o = r >> 8, n = r % 256, i.push(n), i.push(o);
                            return i
                        }(t, (i = this).length - s), i, s, a);
                    default:
                        if (m) throw new TypeError("Unknown encoding: " + o);
                        o = ("" + o).toLowerCase(), m = !0
                }
            }, h.prototype.toJSON = function () {
                return {
                    type: "Buffer",
                    data: Array.prototype.slice.call(this._arr || this, 0)
                }
            };
            var R = 4096;

            function v(t, e, r) {
                var o = "";
                r = Math.min(t.length, r);
                for (var n = e; n < r; ++n) o += String.fromCharCode(127 & t[n]);
                return o
            }

            function w(t, e, r) {
                var o = "";
                r = Math.min(t.length, r);
                for (var n = e; n < r; ++n) o += String.fromCharCode(t[n]);
                return o
            }

            function S(t, e, r) {
                var o = t.length;
                (!e || e < 0) && (e = 0), (!r || r < 0 || o < r) && (r = o);
                for (var n = "", i = e; i < r; ++i) n += P(t[i]);
                return n
            }

            function M(t, e, r) {
                for (var o = t.slice(e, r), n = "", i = 0; i < o.length; i += 2) n += String.fromCharCode(o[i] + 256 * o[i + 1]);
                return n
            }

            function b(t, e, r) {
                if (t % 1 != 0 || t < 0) throw new RangeError("offset is not uint");
                if (r < t + e) throw new RangeError("Trying to access beyond buffer length")
            }

            function I(t, e, r, o, n, i) {
                if (!h.isBuffer(t)) throw new TypeError('"buffer" argument must be a Buffer instance');
                if (n < e || e < i) throw new RangeError('"value" argument is out of bounds');
                if (r + o > t.length) throw new RangeError("Index out of range")
            }

            function B(t, e, r, o) {
                if (r + o > t.length) throw new RangeError("Index out of range");
                if (r < 0) throw new RangeError("Index out of range")
            }

            function T(t, e, r, o, n) {
                return e = +e, r >>>= 0, n || B(t, 0, r, 4), aR(t, e, r, o, 23, 4), r + 4
            }

            function O(t, e, r, o, n) {
                return e = +e, r >>>= 0, n || B(t, 0, r, 8), aR(t, e, r, o, 52, 8), r + 8
            }
            h.prototype.slice = function (t, e) {
                var r = this.length;
                (t = ~~t) < 0 ? (t += r) < 0 && (t = 0) : r < t && (t = r), (e = void 0 === e ? r : ~~e) < 0 ? (e += r) < 0 && (e = 0) : r < e && (e = r), e < t && (e = t);
                var o = this.subarray(t, e);
                return Object.setPrototypeOf(o, h.prototype), o
            }, h.prototype.readUIntLE = function (t, e, r) {
                t >>>= 0, e >>>= 0, r || b(t, e, this.length);
                for (var o = this[t], n = 1, i = 0; ++i < e && (n *= 256);) o += this[t + i] * n;
                return o
            }, h.prototype.readUIntBE = function (t, e, r) {
                t >>>= 0, e >>>= 0, r || b(t, e, this.length);
                for (var o = this[t + --e], n = 1; 0 < e && (n *= 256);) o += this[t + --e] * n;
                return o
            }, h.prototype.readUInt8 = function (t, e) {
                return t >>>= 0, e || b(t, 1, this.length), this[t]
            }, h.prototype.readUInt16LE = function (t, e) {
                return t >>>= 0, e || b(t, 2, this.length), this[t] | this[t + 1] << 8
            }, h.prototype.readUInt16BE = function (t, e) {
                return t >>>= 0, e || b(t, 2, this.length), this[t] << 8 | this[t + 1]
            }, h.prototype.readUInt32LE = function (t, e) {
                return t >>>= 0, e || b(t, 4, this.length), (this[t] | this[t + 1] << 8 | this[t + 2] << 16) + 16777216 * this[t + 3]
            }, h.prototype.readUInt32BE = function (t, e) {
                return t >>>= 0, e || b(t, 4, this.length), 16777216 * this[t] + (this[t + 1] << 16 | this[t + 2] << 8 | this[t + 3])
            }, h.prototype.readIntLE = function (t, e, r) {
                t >>>= 0, e >>>= 0, r || b(t, e, this.length);
                for (var o = this[t], n = 1, i = 0; ++i < e && (n *= 256);) o += this[t + i] * n;
                return (n *= 128) <= o && (o -= Math.pow(2, 8 * e)), o
            }, h.prototype.readIntBE = function (t, e, r) {
                t >>>= 0, e >>>= 0, r || b(t, e, this.length);
                for (var o = e, n = 1, i = this[t + --o]; 0 < o && (n *= 256);) i += this[t + --o] * n;
                return (n *= 128) <= i && (i -= Math.pow(2, 8 * e)), i
            }, h.prototype.readInt8 = function (t, e) {
                return t >>>= 0, e || b(t, 1, this.length), 128 & this[t] ? -1 * (255 - this[t] + 1) : this[t]
            }, h.prototype.readInt16LE = function (t, e) {
                t >>>= 0, e || b(t, 2, this.length);
                var r = this[t] | this[t + 1] << 8;
                return 32768 & r ? 4294901760 | r : r
            }, h.prototype.readInt16BE = function (t, e) {
                t >>>= 0, e || b(t, 2, this.length);
                var r = this[t + 1] | this[t] << 8;
                return 32768 & r ? 4294901760 | r : r
            }, h.prototype.readInt32LE = function (t, e) {
                return t >>>= 0, e || b(t, 4, this.length), this[t] | this[t + 1] << 8 | this[t + 2] << 16 | this[t + 3] << 24
            }, h.prototype.readInt32BE = function (t, e) {
                return t >>>= 0, e || b(t, 4, this.length), this[t] << 24 | this[t + 1] << 16 | this[t + 2] << 8 | this[t + 3]
            }, h.prototype.readFloatLE = function (t, e) {
                return t >>>= 0, e || b(t, 4, this.length), sR(this, t, !0, 23, 4)
            }, h.prototype.readFloatBE = function (t, e) {
                return t >>>= 0, e || b(t, 4, this.length), sR(this, t, !1, 23, 4)
            }, h.prototype.readDoubleLE = function (t, e) {
                return t >>>= 0, e || b(t, 8, this.length), sR(this, t, !0, 52, 8)
            }, h.prototype.readDoubleBE = function (t, e) {
                return t >>>= 0, e || b(t, 8, this.length), sR(this, t, !1, 52, 8)
            }, h.prototype.writeUIntLE = function (t, e, r, o) {
                t = +t, e >>>= 0, r >>>= 0, o || I(this, t, e, r, Math.pow(2, 8 * r) - 1, 0);
                var n = 1,
                    i = 0;
                for (this[e] = 255 & t; ++i < r && (n *= 256);) this[e + i] = t / n & 255;
                return e + r
            }, h.prototype.writeUIntBE = function (t, e, r, o) {
                t = +t, e >>>= 0, r >>>= 0, o || I(this, t, e, r, Math.pow(2, 8 * r) - 1, 0);
                var n = r - 1,
                    i = 1;
                for (this[e + n] = 255 & t; 0 <= --n && (i *= 256);) this[e + n] = t / i & 255;
                return e + r
            }, h.prototype.writeUInt8 = function (t, e, r) {
                return t = +t, e >>>= 0, r || I(this, t, e, 1, 255, 0), this[e] = 255 & t, e + 1
            }, h.prototype.writeUInt16LE = function (t, e, r) {
                return t = +t, e >>>= 0, r || I(this, t, e, 2, 65535, 0), this[e] = 255 & t, this[e + 1] = t >>> 8, e + 2
            }, h.prototype.writeUInt16BE = function (t, e, r) {
                return t = +t, e >>>= 0, r || I(this, t, e, 2, 65535, 0), this[e] = t >>> 8, this[e + 1] = 255 & t, e + 2
            }, h.prototype.writeUInt32LE = function (t, e, r) {
                return t = +t, e >>>= 0, r || I(this, t, e, 4, 4294967295, 0), this[e + 3] = t >>> 24, this[e + 2] = t >>> 16, this[e + 1] = t >>> 8, this[e] = 255 & t, e + 4
            }, h.prototype.writeUInt32BE = function (t, e, r) {
                return t = +t, e >>>= 0, r || I(this, t, e, 4, 4294967295, 0), this[e] = t >>> 24, this[e + 1] = t >>> 16, this[e + 2] = t >>> 8, this[e + 3] = 255 & t, e + 4
            }, h.prototype.writeIntLE = function (t, e, r, o) {
                if (t = +t, e >>>= 0, !o) {
                    var n = Math.pow(2, 8 * r - 1);
                    I(this, t, e, r, n - 1, -n)
                }
                var i = 0,
                    s = 1,
                    a = 0;
                for (this[e] = 255 & t; ++i < r && (s *= 256);) t < 0 && 0 === a && 0 !== this[e + i - 1] && (a = 1), this[e + i] = (t / s >> 0) - a & 255;
                return e + r
            }, h.prototype.writeIntBE = function (t, e, r, o) {
                if (t = +t, e >>>= 0, !o) {
                    var n = Math.pow(2, 8 * r - 1);
                    I(this, t, e, r, n - 1, -n)
                }
                var i = r - 1,
                    s = 1,
                    a = 0;
                for (this[e + i] = 255 & t; 0 <= --i && (s *= 256);) t < 0 && 0 === a && 0 !== this[e + i + 1] && (a = 1), this[e + i] = (t / s >> 0) - a & 255;
                return e + r
            }, h.prototype.writeInt8 = function (t, e, r) {
                return t = +t, e >>>= 0, r || I(this, t, e, 1, 127, -128), t < 0 && (t = 255 + t + 1), this[e] = 255 & t, e + 1
            }, h.prototype.writeInt16LE = function (t, e, r) {
                return t = +t, e >>>= 0, r || I(this, t, e, 2, 32767, -32768), this[e] = 255 & t, this[e + 1] = t >>> 8, e + 2
            }, h.prototype.writeInt16BE = function (t, e, r) {
                return t = +t, e >>>= 0, r || I(this, t, e, 2, 32767, -32768), this[e] = t >>> 8, this[e + 1] = 255 & t, e + 2
            }, h.prototype.writeInt32LE = function (t, e, r) {
                return t = +t, e >>>= 0, r || I(this, t, e, 4, 2147483647, -2147483648), this[e] = 255 & t, this[e + 1] = t >>> 8, this[e + 2] = t >>> 16, this[e + 3] = t >>> 24, e + 4
            }, h.prototype.writeInt32BE = function (t, e, r) {
                return t = +t, e >>>= 0, r || I(this, t, e, 4, 2147483647, -2147483648), t < 0 && (t = 4294967295 + t + 1), this[e] = t >>> 24, this[e + 1] = t >>> 16, this[e + 2] = t >>> 8, this[e + 3] = 255 & t, e + 4
            }, h.prototype.writeFloatLE = function (t, e, r) {
                return T(this, t, e, !0, r)
            }, h.prototype.writeFloatBE = function (t, e, r) {
                return T(this, t, e, !1, r)
            }, h.prototype.writeDoubleLE = function (t, e, r) {
                return O(this, t, e, !0, r)
            }, h.prototype.writeDoubleBE = function (t, e, r) {
                return O(this, t, e, !1, r)
            }, h.prototype.copy = function (t, e, r, o) {
                if (!h.isBuffer(t)) throw new TypeError("argument should be a Buffer");
                if (r = r || 0, o || 0 === o || (o = this.length), e >= t.length && (e = t.length), e = e || 0, 0 < o && o < r && (o = r), o === r) return 0;
                if (0 === t.length || 0 === this.length) return 0;
                if (e < 0) throw new RangeError("targetStart out of bounds");
                if (r < 0 || r >= this.length) throw new RangeError("Index out of range");
                if (o < 0) throw new RangeError("sourceEnd out of bounds");
                o > this.length && (o = this.length), t.length - e < o - r && (o = t.length - e + r);
                var n = o - r;
                if (this === t && "function" == typeof Uint8Array.prototype.copyWithin) this.copyWithin(e, r, o);
                else if (this === t && r < e && e < o)
                    for (var i = n - 1; 0 <= i; --i) t[i + e] = this[i + r];
                else Uint8Array.prototype.set.call(t, this.subarray(r, o), e);
                return n
            }, h.prototype.fill = function (t, e, r, o) {
                if ("string" == typeof t) {
                    if ("string" == typeof e ? (o = e, e = 0, r = this.length) : "string" == typeof r && (o = r, r = this.length), void 0 !== o && "string" != typeof o) throw new TypeError("encoding must be a string");
                    if ("string" == typeof o && !h.isEncoding(o)) throw new TypeError("Unknown encoding: " + o);
                    if (1 === t.length) {
                        var n = t.charCodeAt(0);
                        ("utf8" === o && n < 128 || "latin1" === o) && (t = n)
                    }
                } else "number" == typeof t && (t &= 255);
                if (e < 0 || this.length < e || this.length < r) throw new RangeError("Out of range index");
                if (r <= e) return this;
                var i;
                if (e >>>= 0, r = void 0 === r ? this.length : r >>> 0, "number" == typeof (t = t || 0))
                    for (i = e; i < r; ++i) this[i] = t;
                else {
                    var s = h.isBuffer(t) ? t : h.from(t, o),
                        a = s.length;
                    if (0 === a) throw new TypeError('The value "' + t + '" is invalid for argument "value"');
                    for (i = 0; i < r - e; ++i) this[i + e] = s[i % a]
                }
                return this
            };
            var D = /[^+/0-9A-Za-z-_]/g;

            function P(t) {
                return t < 16 ? "0" + t.toString(16) : t.toString(16)
            }

            function C(t, e) {
                var r;
                e = e || 1 / 0;
                for (var o = t.length, n = null, i = [], s = 0; s < o; ++s) {
                    if (55295 < (r = t.charCodeAt(s)) && r < 57344) {
                        if (!n) {
                            if (56319 < r) {
                                -1 < (e -= 3) && i.push(239, 191, 189);
                                continue
                            }
                            if (s + 1 === o) {
                                -1 < (e -= 3) && i.push(239, 191, 189);
                                continue
                            }
                            n = r;
                            continue
                        }
                        if (r < 56320) {
                            -1 < (e -= 3) && i.push(239, 191, 189), n = r;
                            continue
                        }
                        r = 65536 + (n - 55296 << 10 | r - 56320)
                    } else n && -1 < (e -= 3) && i.push(239, 191, 189);
                    if (n = null, r < 128) {
                        if ((e -= 1) < 0) break;
                        i.push(r)
                    } else if (r < 2048) {
                        if ((e -= 2) < 0) break;
                        i.push(r >> 6 | 192, 63 & r | 128)
                    } else if (r < 65536) {
                        if ((e -= 3) < 0) break;
                        i.push(r >> 12 | 224, r >> 6 & 63 | 128, 63 & r | 128)
                    } else {
                        if (!(r < 1114112)) throw new Error("Invalid code point");
                        if ((e -= 4) < 0) break;
                        i.push(r >> 18 | 240, r >> 12 & 63 | 128, r >> 6 & 63 | 128, 63 & r | 128)
                    }
                }
                return i
            }

            function k(t) {
                return iR.toByteArray(function (t) {
                    if ((t = (t = t.split("=")[0]).trim().replace(D, "")).length < 2) return "";
                    for (; t.length % 4 != 0;) t += "=";
                    return t
                }(t))
            }

            function L(t, e, r, o) {
                for (var n = 0; n < o && !(n + r >= e.length || n >= t.length); ++n) e[n + r] = t[n];
                return n
            }

            function E(t, e) {
                return t instanceof e || null != t && null != t.constructor && null != t.constructor.name && t.constructor.name === e.name
            }

            function N(t) {
                return t != t
            }
        }),
        cR = uR.Buffer,
        fR = (uR.SlowBuffer, uR.INSPECT_MAX_BYTES, uR.kMaxLength, t(function (t) {
            function i(t, e, r) {
                var o = t.constructor,
                    n = e - (t = new o(t)).e,
                    i = t.c;
                for (i.length > ++e && v(t, n, o.RM), i[0] ? n = r ? e : (i = t.c, t.e + n + 1) : ++n; i.length < n; i.push(0));
                return n = t.e, 1 === r || r && (e <= n || n <= o.E_NEG) ? (t.s < 0 && i[0] ? "-" : "") + (1 < i.length ? i[0] + "." + i.join("").slice(1) : i[0]) + (n < 0 ? "e" : "e+") + n : t.toString()
            }

            function v(t, e, r, o) {
                var n = t.c,
                    i = t.e + e + 1;
                if (1 === r ? o = 5 <= n[i] : 2 === r ? o = 5 < n[i] || 5 == n[i] && (o || i < 0 || void 0 !== n[i + 1] || 1 & n[i - 1]) : 3 === r ? o = o || void 0 !== n[i] || i < 0 : (o = !1, 0 !== r && w("!Big.RM!")), i < 1 || !n[0]) o ? (t.e = -e, t.c = [1]) : t.c = [t.e = 0];
                else {
                    if (n.length = i--, o)
                        for (; 9 < ++n[i];) n[i] = 0, i-- || (++t.e, n.unshift(1));
                    for (i = n.length; !n[--i]; n.pop());
                }
                return t
            }

            function w(t) {
                var e = new Error(t);
                throw e.name = "BigError", e
            }
            var e, r, o, n, s, a, u, c;
            e = p, o = 20, n = 1, s = -7, a = 21, c = /^-?(\d+(\.\d*)?|\.\d+)(e[+-]?\d+)?$/i, (u = {}).abs = function () {
                var t = new this.constructor(this);
                return t.s = 1, t
            }, u.cmp = function (t) {
                var e, r = this.c,
                    o = (t = new this.constructor(t)).c,
                    n = this.s,
                    i = t.s,
                    s = this.e,
                    a = t.e;
                if (!r[0] || !o[0]) return r[0] ? n : o[0] ? -i : 0;
                if (n != i) return n;
                if (e = n < 0, s != a) return a < s ^ e ? 1 : -1;
                for (n = -1, i = (s = r.length) < (a = o.length) ? s : a; ++n < i;)
                    if (r[n] != o[n]) return r[n] > o[n] ^ e ? 1 : -1;
                return s == a ? 0 : a < s ^ e ? 1 : -1
            }, u.div = function (t) {
                var e = this.constructor,
                    r = this.c,
                    o = (t = new e(t)).c,
                    n = this.s == t.s ? 1 : -1,
                    i = e.DP;
                if ((i !== ~~i || i < 0 || 1e6 < i) && w("!Big.DP!"), !r[0] || !o[0]) return r[0] == o[0] && w(NaN), o[0] || w(n / 0), new e(0 * n);
                var s, a, u, c, f, h = o.slice(),
                    p = s = o.length,
                    d = r.length,
                    m = r.slice(0, s),
                    l = m.length,
                    g = t,
                    y = g.c = [],
                    _ = 0,
                    R = i + (g.e = this.e - t.e) + 1;
                for (g.s = n, n = R < 0 ? 0 : R, h.unshift(0); l++ < s; m.push(0));
                do {
                    for (u = 0; u < 10; u++) {
                        if (s != (l = m.length)) c = l < s ? 1 : -1;
                        else
                            for (f = -1, c = 0; ++f < s;)
                                if (o[f] != m[f]) {
                                    c = o[f] > m[f] ? 1 : -1;
                                    break
                                } if (!(c < 0)) break;
                        for (a = l == s ? o : h; l;) {
                            if (m[--l] < a[l]) {
                                for (f = l; f && !m[--f]; m[f] = 9);
                                --m[f], m[l] += 10
                            }
                            m[l] -= a[l]
                        }
                        for (; !m[0]; m.shift());
                    }
                    y[_++] = c ? u : ++u, m[0] && c ? m[l] = r[p] || 0 : m = [r[p]]
                } while ((p++ < d || void 0 !== m[0]) && n--);
                return y[0] || 1 == _ || (y.shift(), g.e--), R < _ && v(g, i, e.RM, void 0 !== m[0]), g
            }, u.eq = function (t) {
                return !this.cmp(t)
            }, u.gt = function (t) {
                return 0 < this.cmp(t)
            }, u.gte = function (t) {
                return -1 < this.cmp(t)
            }, u.lt = function (t) {
                return this.cmp(t) < 0
            }, u.lte = function (t) {
                return this.cmp(t) < 1
            }, u.sub = u.minus = function (t) {
                var e, r, o, n, i = this.constructor,
                    s = this.s,
                    a = (t = new i(t)).s;
                if (s != a) return t.s = -a, this.plus(t);
                var u = this.c.slice(),
                    c = this.e,
                    f = t.c,
                    h = t.e;
                if (!u[0] || !f[0]) return f[0] ? (t.s = -a, t) : new i(u[0] ? this : 0);
                if (s = c - h) {
                    for ((o = (n = s < 0) ? (s = -s, u) : (h = c, f)).reverse(), a = s; a--; o.push(0));
                    o.reverse()
                } else
                    for (r = ((n = u.length < f.length) ? u : f).length, s = a = 0; a < r; a++)
                        if (u[a] != f[a]) {
                            n = u[a] < f[a];
                            break
                        } if (n && (o = u, u = f, f = o, t.s = -t.s), 0 < (a = (r = f.length) - (e = u.length)))
                    for (; a--; u[e++] = 0);
                for (a = e; s < r;) {
                    if (u[--r] < f[r]) {
                        for (e = r; e && !u[--e]; u[e] = 9);
                        --u[e], u[r] += 10
                    }
                    u[r] -= f[r]
                }
                for (; 0 === u[--a]; u.pop());
                for (; 0 === u[0];) u.shift(), --h;
                return u[0] || (t.s = 1, u = [h = 0]), t.c = u, t.e = h, t
            }, u.mod = function (t) {
                var e, r = this,
                    o = r.constructor,
                    n = r.s,
                    i = (t = new o(t)).s;
                return t.c[0] || w(NaN), r.s = t.s = 1, e = 1 == t.cmp(r), r.s = n, t.s = i, e ? new o(r) : (n = o.DP, i = o.RM, o.DP = o.RM = 0, r = r.div(t), o.DP = n, o.RM = i, this.minus(r.times(t)))
            }, u.add = u.plus = function (t) {
                var e, r = this.constructor,
                    o = this.s,
                    n = (t = new r(t)).s;
                if (o != n) return t.s = -n, this.minus(t);
                var i = this.e,
                    s = this.c,
                    a = t.e,
                    u = t.c;
                if (!s[0] || !u[0]) return u[0] ? t : new r(s[0] ? this : 0 * o);
                if (s = s.slice(), o = i - a) {
                    for ((e = 0 < o ? (a = i, u) : (o = -o, s)).reverse(); o--; e.push(0));
                    e.reverse()
                }
                for (s.length - u.length < 0 && (e = u, u = s, s = e), o = u.length, n = 0; o;) n = (s[--o] = s[o] + u[o] + n) / 10 | 0, s[o] %= 10;
                for (n && (s.unshift(n), ++a), o = s.length; 0 === s[--o]; s.pop());
                return t.c = s, t.e = a, t
            }, u.pow = function (t) {
                var e = this,
                    r = new e.constructor(1),
                    o = r,
                    n = t < 0;
                for ((t !== ~~t || t < -1e6 || 1e6 < t) && w("!pow!"), t = n ? -t : t; 1 & t && (o = o.times(e)), t >>= 1;) e = e.times(e);
                return n ? r.div(o) : o
            }, u.round = function (t, e) {
                var r = this,
                    o = r.constructor;
                return null == t ? t = 0 : (t !== ~~t || t < 0 || 1e6 < t) && w("!round!"), v(r = new o(r), t, null == e ? o.RM : e), r
            }, u.sqrt = function () {
                var t, e, r, o = this.constructor,
                    n = this.c,
                    i = this.s,
                    s = this.e,
                    a = new o("0.5");
                if (!n[0]) return new o(this);
                for (i < 0 && w(NaN), 0 === (i = Math.sqrt(this.toString())) || i === 1 / 0 ? ((t = n.join("")).length + s & 1 || (t += "0"), (e = new o(Math.sqrt(t).toString())).e = ((s + 1) / 2 | 0) - (s < 0 || 1 & s)) : e = new o(i.toString()), i = e.e + (o.DP += 4); r = e, e = a.times(r.plus(this.div(r))), r.c.slice(0, i).join("") !== e.c.slice(0, i).join(""););
                return v(e, o.DP -= 4, o.RM), e
            }, u.mul = u.times = function (t) {
                var e, r = this.constructor,
                    o = this.c,
                    n = (t = new r(t)).c,
                    i = o.length,
                    s = n.length,
                    a = this.e,
                    u = t.e;
                if (t.s = this.s == t.s ? 1 : -1, !o[0] || !n[0]) return new r(0 * t.s);
                for (t.e = a + u, i < s && (e = o, o = n, n = e, u = i, i = s, s = u), e = new Array(u = i + s); u--; e[u] = 0);
                for (a = s; a--;) {
                    for (s = 0, u = i + a; a < u;) s = e[u] + n[a] * o[u - a - 1] + s, e[u--] = s % 10, s = s / 10 | 0;
                    e[u] = (e[u] + s) % 10
                }
                for (s && ++t.e, e[0] || e.shift(), a = e.length; !e[--a]; e.pop());
                return t.c = e, t
            }, u.toString = u.valueOf = u.toJSON = function () {
                var t = this.constructor,
                    e = this.e,
                    r = this.c.join(""),
                    o = r.length;
                if (e <= t.E_NEG || e >= t.E_POS) r = r.charAt(0) + (1 < o ? "." + r.slice(1) : "") + (e < 0 ? "e" : "e+") + e;
                else if (e < 0) {
                    for (; ++e; r = "0" + r);
                    r = "0." + r
                } else if (0 < e)
                    if (++e > o)
                        for (e -= o; e--; r += "0");
                    else e < o && (r = r.slice(0, e) + "." + r.slice(e));
                else 1 < o && (r = r.charAt(0) + "." + r.slice(1));
                return this.s < 0 && this.c[0] ? "-" + r : r
            }, u.toExponential = function (t) {
                return null == t ? t = this.c.length - 1 : (t !== ~~t || t < 0 || 1e6 < t) && w("!toExp!"), i(this, t, 1)
            }, u.toFixed = function (t) {
                var e, r = this.constructor,
                    o = r.E_NEG,
                    n = r.E_POS;
                return r.E_NEG = -(r.E_POS = 1 / 0), null == t ? e = this.toString() : t === ~~t && 0 <= t && t <= 1e6 && (e = i(this, this.e + t), this.s < 0 && this.c[0] && e.indexOf("-") < 0 && (e = "-" + e)), r.E_NEG = o, r.E_POS = n, e || w("!toFix!"), e
            }, u.toPrecision = function (t) {
                return null == t ? this.toString() : ((t !== ~~t || t < 1 || 1e6 < t) && w("!toPre!"), i(this, t - 1, 2))
            }, r = function e() {
                function r(t) {
                    if (!(this instanceof r)) return void 0 === t ? e() : new r(t);
                    t instanceof r ? (this.s = t.s, this.e = t.e, this.c = t.c.slice()) : function (t, e) {
                        var r, o, n;
                        for (0 === e && 1 / e < 0 ? e = "-0" : c.test(e += "") || w(NaN), t.s = "-" == e.charAt(0) ? (e = e.slice(1), -1) : 1, -1 < (r = e.indexOf(".")) && (e = e.replace(".", "")), 0 < (o = e.search(/e/i)) ? (r < 0 && (r = o), r += +e.slice(o + 1), e = e.substring(0, o)) : r < 0 && (r = e.length), n = e.length, o = 0; o < n && "0" == e.charAt(o); o++);
                        if (o == n) t.c = [t.e = 0];
                        else {
                            for (; 0 < n && "0" == e.charAt(--n););
                            for (t.e = r - o - 1, t.c = []; o <= n; t.c.push(+e.charAt(o++)));
                        }
                    }(this, t), this.constructor = r
                }
                return r.prototype = u, r.DP = o, r.RM = n, r.E_NEG = s, r.E_POS = a, r
            }(), t.exports ? (t.exports = r, t.exports.Big = r) : e.Big = r
        })),
        hR = (fR.Big, t(function (t) {
            var n = uR.Buffer,
                h = t.exports = {},
                i = 4294967296;
            h.Exception = function (t, e) {
                this.code = t, this.message = e
            }, T_.inherits(h.Exception, Error), h.EncodeException = function (t) {
                this.code = -2, this.message = t
            }, T_.inherits(h.EncodeException, h.Exception), h.DecodeException = function (t) {
                this.code = -1, this.message = t
            }, T_.inherits(h.DecodeException, h.Exception), h.DecodeMismatch = function (t) {
                this.code = -1, this.message = t
            }, T_.inherits(h.DecodeMismatch, h.DecodeException), h.DecodeRequireNotExist = function (t) {
                this.code = -1, this.message = t
            }, T_.inherits(h.DecodeRequireNotExist, h.DecodeException), h.DecodeInvalidValue = function (t) {
                this.code = -1, this.message = t
            }, T_.inherits(h.DecodeInvalidValue, h.DecodeException), h.TupNotFoundKey = function (t) {
                this.code = -1, this.message = t
            }, T_.inherits(h.TupNotFoundKey, h.Exception), h.DataHelp = {
                EN_INT8: 0,
                EN_INT16: 1,
                EN_INT32: 2,
                EN_INT64: 3,
                EN_FLOAT: 4,
                EN_DOUBLE: 5,
                EN_STRING1: 6,
                EN_STRING4: 7,
                EN_MAP: 8,
                EN_LIST: 9,
                EN_STRUCTBEGIN: 10,
                EN_STRUCTEND: 11,
                EN_ZERO: 12,
                EN_SIMPLELIST: 13
            }, h.Boolean = {
                _write: function (t, e, r) {
                    return t.writeBoolean(e, r)
                },
                _read: function (t, e, r) {
                    return t.readBoolean(e, !0, r)
                },
                _classname: "bool"
            }, h.Int8 = {
                _write: function (t, e, r) {
                    return t.writeInt8(e, r)
                },
                _read: function (t, e, r) {
                    return t.readInt8(e, !0, r)
                },
                _classname: "char"
            }, h.Int16 = {
                _write: function (t, e, r) {
                    return t.writeInt16(e, r)
                },
                _read: function (t, e, r) {
                    return t.readInt16(e, !0, r)
                },
                _classname: "short"
            }, h.Int32 = {
                _write: function (t, e, r) {
                    return t.writeInt32(e, r)
                },
                _read: function (t, e, r) {
                    return t.readInt32(e, !0, r)
                },
                _classname: "int32"
            }, h.Int64 = {
                _write: function (t, e, r, o) {
                    return t.writeInt64(e, r, o)
                },
                _read: function (t, e, r, o) {
                    return t.readInt64(e, !0, r, o)
                },
                _classname: "int64"
            }, h.UInt8 = {
                _write: function (t, e, r) {
                    return t.writeInt16(e, r)
                },
                _read: function (t, e, r) {
                    return t.readInt16(e, !0, r)
                },
                _classname: "short"
            }, h.UInt16 = {
                _write: function (t, e, r) {
                    return t.writeInt32(e, r)
                },
                _read: function (t, e, r) {
                    return t.readInt32(e, !0, r)
                },
                _classname: "int32"
            }, h.UInt32 = {
                _write: function (t, e, r) {
                    return t.writeInt64(e, r)
                },
                _read: function (t, e, r) {
                    return t.readInt64(e, !0, r)
                },
                _classname: "int64"
            }, h.Float = {
                _write: function (t, e, r) {
                    return t.writeFloat(e, r)
                },
                _read: function (t, e, r) {
                    return t.readFloat(e, !0, r)
                },
                _classname: "float"
            }, h.Double = {
                _write: function (t, e, r) {
                    return t.writeDouble(e, r)
                },
                _read: function (t, e, r) {
                    return t.readDouble(e, !0, r)
                },
                _classname: "double"
            }, h.String = {
                _write: function (t, e, r, o) {
                    return t.writeString(e, r, o)
                },
                _read: function (t, e, r, o) {
                    return t.readString(e, !0, r, o)
                },
                _classname: "string"
            }, h.Enum = {
                _write: function (t, e, r) {
                    return t.writeInt32(e, r)
                },
                _read: function (t, e, r) {
                    return t.readInt32(e, !0, r)
                },
                _classname: "int32"
            };

            function r(t, e) {
                this._proto = t, this._bValue = e || 0, this.value = new Array, this._classname = "List<" + t._classname + ">"
            }
            r.prototype._write = function (t, e, r, o, n) {
                return t.writeList(e, r, o, n)
            }, r.prototype._read = function (t, e, r, o, n) {
                return t.readList(e, !0, r, o, n)
            }, r.prototype.new = function () {
                return new r(this._proto)
            }, r.prototype.at = function (t) {
                return this.value[t]
            }, r.prototype.push = function (t) {
                this.value.push(t)
            }, r.prototype.forEach = function (t) {
                for (var e = 0; e < this.value.length && 0 != t.call(null, this.value[e], e, this.value); e++);
            }, r.prototype.toObject = function () {
                for (var t = [], e = 0, r = this.value.length; e < r; e++) t.push(this.value[e].toObject ? this.value[e].toObject() : this.value[e]);
                return t
            }, r.prototype.readFromObject = function (t) {
                for (var e = !(this._proto.create || this._proto._vproto || this._proto._proto || this._proto.new), r = 0, o = t.length; r < o; r++)
                    if (e) this.push(t[r]);
                    else {
                        var n = this._proto.new();
                        n.readFromObject(t[r]), this.push(n)
                    }
                return this
            }, r.prototype.__defineGetter__("length", function () {
                return this.value.length
            }), h.List = function (t, e) {
                return new r(t, e)
            };

            function s(t, e, r, o) {
                this._kproto = t, this._vproto = e, this._bKey = r || 0, this._bValue = o || 0, this.keys = new Object, this.value = new Object, this._classname = "map<" + t._classname + "," + e._classname + ">"
            }
            s.prototype._write = function (t, e, r, o) {
                return t.writeMap(e, r, o)
            }, s.prototype._read = function (t, e, r, o) {
                return t.readMap(e, !0, r, o)
            }, s.prototype.put = function (t, e) {
                this.insert(t, e)
            }, s.prototype.set = function (t, e) {
                this.insert(t, e)
            }, s.prototype.remove = function (t) {
                delete this.keys[t._genKey()], delete this.value[t._genKey()]
            }, s.prototype.size = function () {
                return Object.keys(this.keys || {}).length
            }, s.prototype.has = function (t) {
                return this.keys.hasOwnProperty(t._genKey())
            }, s.prototype.insert = function (t, e) {
                for (var r = Object.keys(this.keys || {}), o = 0; o < r.length; o++) {
                    var n = r[o];
                    if (t._equal(this.keys[n])) return void (this.value[n] = e)
                }
                this.keys[t._genKey()] = t, this.value[t._genKey()] = e
            }, s.prototype.get = function (t) {
                for (var e = Object.keys(this.keys || {}), r = 0; r < e.length; r++) {
                    var o = e[r];
                    if (t._equal(this.keys[o])) return this.value[o]
                }
            }, s.prototype.clear = function () {
                delete this.keys, delete this.value, this.keys = new Object, this.value = new Object
            }, s.prototype.forEach = function (t) {
                for (var e = Object.keys(this.value || {}), r = 0; r < e.length; r++) {
                    var o = e[r];
                    if (0 == t.call(null, this.keys[o], this.value[o])) break
                }
            }, s.prototype.toObject = function () {
                U_(!1, "multimap has no toObject function")
            }, s.prototype.readFromObject = function () {
                U_(!1, "multimap has no toObject readFromObject")
            };

            function a(t, e, r, o) {
                this._kproto = t, this._vproto = e, this._bKey = r || 0, this._bValue = o || 0, this.value = new Object, this._classname = "map<" + t._classname + "," + e._classname + ">"
            }
            a.prototype._write = function (t, e, r) {
                return t.writeMap(e, r)
            }, a.prototype._read = function (t, e, r) {
                return t.readMap(e, !0, r)
            }, a.prototype.new = function () {
                return new a(this._kproto, this._vproto)
            }, a.prototype.put = function (t, e) {
                this.insert(t, e)
            }, a.prototype.set = function (t, e) {
                this.insert(t, e)
            }, a.prototype.remove = function (t) {
                delete this.value[t]
            }, a.prototype.size = function () {
                return Object.keys(this.value || {}).length
            }, a.prototype.has = function (t) {
                return this.value.hasOwnProperty(t)
            }, a.prototype.insert = function (t, e) {
                this.value[t] = e
            }, a.prototype.get = function (t) {
                return this.value[t]
            }, a.prototype.clear = function () {
                delete this.value, this.value = new Object
            }, a.prototype.forEach = function (t, e) {
                for (var r = Object.keys(this.value || {}), o = 0; o < r.length; o++) {
                    var n = r[o];
                    switch (this._kproto) {
                        case h.Int8:
                        case h.Int16:
                        case h.Int32:
                        case h.UInt8:
                        case h.UInt16:
                        case h.UInt32:
                        case h.Float:
                        case h.Double:
                            n = Number(n);
                            break;
                        case h.Int64:
                            e || (n = Number(n))
                    }
                    if (0 == t.call(null, n, this.value[n])) break
                }
            }, a.prototype.toObject = function () {
                for (var t = {}, e = Object.keys(this.value || {}), r = 0; r < e.length; r++) {
                    var o = e[r];
                    t[o] = this.value[o].toObject ? this.value[o].toObject() : this.value[o]
                }
                return t
            }, a.prototype.readFromObject = function (t) {
                for (var e = !this._vproto.create && !this._vproto._vproto && !this._vproto._proto, r = Object.keys(t || {}), o = 0; o < r.length; o++) {
                    var n = r[o];
                    if (e) this.insert(n, t[n]);
                    else {
                        var i = this._vproto.new();
                        i.readFromObject(t[n]), this.insert(n, i)
                    }
                }
            }, h.Map = function (t, e, r, o) {
                return t.prototype && t.prototype._equal ? new s(t, e, r, o) : new a(t, e, r, o)
            };
            var o = "allocUnsafe" in n ? function (t) {
                return n.allocUnsafe(t)
            } : function (t) {
                return new n(t)
            };
            h.BinBuffer = function (t) {
                t = t || o(0), this._buffer = null != t && t instanceof n ? t : null, this._length = null != t && t instanceof n ? t.length : 0, this._capacity = this._length, this._position = 0
            }, h.BinBuffer._classname = "list<char>", h.BinBuffer.prototype.__defineGetter__("length", function () {
                return this._length
            }), h.BinBuffer.prototype.__defineGetter__("capacity", function () {
                return this._capacity
            }), h.BinBuffer.prototype.__defineGetter__("position", function () {
                return this._position
            }), h.BinBuffer.prototype.__defineSetter__("position", function (t) {
                this._position = t
            }), h.BinBuffer._write = function (t, e, r) {
                return t.writeBytes(e, r)
            }, h.BinBuffer._read = function (t, e, r) {
                return t.readBytes(e, !0, r)
            }, h.BinBuffer.new = function () {
                return new h.BinBuffer
            }, h.BinBuffer.from = function (t) {
                var e = new h.BinBuffer;
                return e.writeString(t), e
            }, h.BinBuffer.prototype.reset = function () {
                this._length = 0, this._position = 0
            }, h.BinBuffer.prototype._allocate = function (t) {
                if (!(this._capacity > this._position + t)) {
                    this._capacity = Math.max(512, 2 * (this._position + t));
                    var e = o(this._capacity);
                    null != this._buffer && (this._buffer.copy(e, 0, 0, this._position), this._buffer = void 0), this._buffer = e
                }
            }, h.BinBuffer.prototype.replace = function (t, e, r) {
                t.copy(this._buffer, 0, e, e + r)
            }, h.BinBuffer.prototype.writeInt8 = function (t) {
                t = +t, this._allocate(1), this._buffer.writeInt8(t, this._position), this._position += 1, this._length = this._position
            }, h.BinBuffer.prototype.writeUInt8 = function (t) {
                t = +t, this._allocate(1), this._buffer.writeUInt8(t, this._position), this._position += 1, this._length = this._position
            }, h.BinBuffer.prototype.writeInt16 = function (t) {
                t = +t, this._allocate(2), this._buffer.writeInt16BE(t, this._position), this._position += 2, this._length = this._position
            }, h.BinBuffer.prototype.writeUInt16 = function (t) {
                t = +t, this._allocate(2), this._buffer.writeUInt16BE(t, this._position), this._position += 2, this._length = this._position
            }, h.BinBuffer.prototype.writeInt32 = function (t) {
                t = +t, this._allocate(4), this._buffer.writeInt32BE(t, this._position), this._position += 4, this._length = this._position
            }, h.BinBuffer.prototype.writeUInt32 = function (t) {
                t = +t, this._allocate(4), this._buffer.writeUInt32BE(t, this._position), this._position += 4, this._length = this._position
            }, h.BinBuffer.prototype.writeInt64 = function (t, e) {
                var r, o, n;
                !0 === e || 1 === e ? 1 === (n = new fR(t)).s ? (r = +n.div(i).round(0, 0).toString(), o = +n.mod(i).toString()) : (r = n.div(i).round(0, 3), o = +n.minus(new fR(r).times(i)).toString(), r = +r.plus(i).toString()) : 0 < (n = +t) ? o = n - (r = Math.floor(n / i)) * i : (o = n - (r = Math.floor(n / i)) * i, r += i);
                this._allocate(8), this._buffer.writeUInt32BE(r, this._position), this._buffer.writeUInt32BE(o, this._position + 4), this._position += 8, this._length = this._position
            }, h.BinBuffer.prototype.writeFloat = function (t) {
                this._allocate(4), this._buffer.writeFloatBE(t, this._position), this._position += 4, this._length = this._position
            }, h.BinBuffer.prototype.writeDouble = function (t) {
                this._allocate(8), this._buffer.writeDoubleBE(t, this._position), this._position += 8, this._length = this._position
            }, h.BinBuffer.prototype.writeString = function (t, e, r) {
                if (!0 === r || 1 === r) return this._allocate(e), t.copy(this._buffer, this._position), this._position += e, void (this._length = this._position);
                var o = e || n.byteLength(t);
                this._allocate(o), this._buffer.write(t, this._position, o, "utf8"), this._position += o, this._length = this._position
            }, h.BinBuffer.prototype.writeBinBuffer = function (t) {
                0 != t._length && null != t._buffer && (this._allocate(t.length), t._buffer.copy(this._buffer, this._position, 0, t._length), this._position += t._length, this._length = this._position)
            }, h.BinBuffer.prototype.writeNodeBuffer = function (t, e, r) {
                e = null == e ? 0 : e, r = null == r ? t.length : r, this._allocate(r), t.copy(this._buffer, this._position, e, e + r), this._length += r, this._position += r
            }, h.BinBuffer.prototype.readInt8 = function () {
                return this._buffer.readInt8(this._position++)
            }, h.BinBuffer.prototype.readInt16 = function () {
                return this._position += 2, this._buffer.readInt16BE(this._position - 2)
            }, h.BinBuffer.prototype.readInt32 = function () {
                return this._position += 4, this._buffer.readInt32BE(this._position - 4)
            }, h.BinBuffer.prototype.readUInt8 = function () {
                return this._position += 1, this._buffer.readUInt8(this._position - 1)
            }, h.BinBuffer.prototype.readUInt16 = function () {
                return this._position += 2, this._buffer.readUInt16BE(this._position - 2)
            }, h.BinBuffer.prototype.readUInt32 = function () {
                return this._position += 4, this._buffer.readUInt32BE(this._position - 4)
            }, h.BinBuffer.prototype.readInt64 = function (t) {
                var e = this._buffer.readUInt32BE(this._position),
                    r = this._buffer.readUInt32BE(this._position + 4);
                return this._position += 8, !0 === t || 1 === t ? e < 2147483648 ? new fR(e).times(i).plus(r).toString() : "-" + new fR(e = i - 1 - e).times(i).plus(i - r).toString() : e < 2147483648 ? e * i + r : -(i - r + i * (i - 1 - e))
            }, h.BinBuffer.prototype.readFloat = function () {
                return this._position += 4, this._buffer.readFloatBE(this._position - 4)
            }, h.BinBuffer.prototype.readDouble = function () {
                return this._position += 8, this._buffer.readDoubleBE(this._position - 8)
            }, h.BinBuffer.prototype.readString = function (t, e) {
                var r = o(t);
                return !0 === e || 1 === e ? (this._buffer.copy(r, 0, this._position, this._position + t), this._position += t, r) : (this._buffer.copy(r, 0, this._position, this._position + t), this._position += t, 1 == r.length && 128 & r[0] ? r.toString("binary", 0, r.length) : r.toString("utf8", 0, r.length))
            }, h.BinBuffer.prototype.readBinBuffer = function (t, e) {
                var r;
                return !0 === e ? ((r = new h.BinBuffer)._buffer = this._buffer.slice(this._position, this._position + t), r._length = t, r._capacity = t, r._position = 0) : ((r = new h.BinBuffer).writeNodeBuffer(this._buffer, this._position, t), this._position += t), r
            }, h.BinBuffer.prototype.toNodeBuffer = function () {
                var t = o(this._length);
                return this._buffer.copy(t, 0, 0, this._length), t
            }, h.BinBuffer.prototype.toNodeBufferUnSafe = function () {
                return this._buffer.slice(0, this._length)
            }, h.BinBuffer.prototype.toObject = function () {
                return this.toNodeBuffer()
            }, h.BinBuffer.prototype.readFromObject = h.BinBuffer.prototype.writeNodeBuffer, h.BinBuffer.prototype.print = function () {
                for (var t = "", e = 0; e < this._length; e++) t += (15 < this._buffer[e] ? "" : "0") + this._buffer[e].toString(16) + ((e + 1) % 16 == 0 ? "\n" : " ");
                console.log(t.toUpperCase())
            }, h.OutputStream = function () {
                this._binBuffer = new h.BinBuffer
            }, h.OutputStream.prototype._writeTo = function (t, e) {
                t < 15 ? this._binBuffer.writeUInt8(t << 4 & 240 | e) : this._binBuffer.writeUInt16((240 | e) << 8 | t)
            }, h.OutputStream.prototype.setHeaderLength = function (t) {
                var e = 0 === this._binBuffer._position ? 4 : this._binBuffer._position,
                    r = 0 === this._binBuffer._position ? 4 : this._binBuffer._length;
                this._binBuffer._position = 0, this._binBuffer.writeInt32(t), this._binBuffer._position = e, this._binBuffer._length = r
            }, h.OutputStream.prototype.writeBoolean = function (t, e) {
                this.writeInt8(t, 1 == e ? 1 : 0)
            }, h.OutputStream.prototype.writeInt8 = function (t, e) {
                0 == (e = +e) ? this._writeTo(t, h.DataHelp.EN_ZERO) : (this._writeTo(t, h.DataHelp.EN_INT8), this._binBuffer.writeInt8(e))
            }, h.OutputStream.prototype.writeInt16 = function (t, e) {
                -128 <= (e = +e) && e <= 127 ? this.writeInt8(t, e) : (this._writeTo(t, h.DataHelp.EN_INT16), this._binBuffer.writeInt16(e))
            }, h.OutputStream.prototype.writeInt32 = function (t, e) {
                -32768 <= (e = +e) && e <= 32767 ? this.writeInt16(t, e) : (this._writeTo(t, h.DataHelp.EN_INT32), this._binBuffer.writeInt32(e))
            }, h.OutputStream.prototype.writeInt64 = function (t, e, r) {
                var o = +e; - 2147483648 <= o && o <= 2147483647 ? this.writeInt32(t, o) : (this._writeTo(t, h.DataHelp.EN_INT64), this._binBuffer.writeInt64(e, r))
            }, h.OutputStream.prototype.writeUInt8 = function (t, e) {
                this.writeInt16(t, e)
            }, h.OutputStream.prototype.writeUInt16 = function (t, e) {
                this.writeInt32(t, e)
            }, h.OutputStream.prototype.writeUInt32 = function (t, e) {
                this.writeInt64(t, e)
            }, h.OutputStream.prototype.writeFloat = function (t, e) {
                0 == e ? this._writeTo(t, h.DataHelp.EN_ZERO) : (this._writeTo(t, h.DataHelp.EN_FLOAT), this._binBuffer.writeFloat(e))
            }, h.OutputStream.prototype.writeDouble = function (t, e) {
                0 == e ? this._writeTo(t, h.DataHelp.EN_ZERO) : (this._writeTo(t, h.DataHelp.EN_DOUBLE), this._binBuffer.writeDouble(e))
            }, h.OutputStream.prototype.writeStruct = function (t, e) {
                if (null == e._writeTo) throw Error("not defined writeTo Function");
                this._writeTo(t, h.DataHelp.EN_STRUCTBEGIN), e._writeTo(this), this._writeTo(0, h.DataHelp.EN_STRUCTEND)
            }, h.OutputStream.prototype.writeString = function (t, e, r) {
                var o;
                if (null != r && 1 == r) return 255 < (o = e.length) ? (this._writeTo(t, h.DataHelp.EN_STRING4), this._binBuffer.writeUInt32(o)) : (this._writeTo(t, h.DataHelp.EN_STRING1), this._binBuffer.writeUInt8(o)), void this._binBuffer.writeString(e, o, r);
                255 < (o = n.byteLength(e, "utf8")) ? (this._writeTo(t, h.DataHelp.EN_STRING4), this._binBuffer.writeUInt32(o)) : (this._writeTo(t, h.DataHelp.EN_STRING1), this._binBuffer.writeUInt8(o)), this._binBuffer.writeString(e, o)
            }, h.OutputStream.prototype.writeBytes = function (t, e) {
                this._writeTo(t, h.DataHelp.EN_SIMPLELIST), this._writeTo(0, h.DataHelp.EN_INT8), this.writeInt32(0, e.length), this._binBuffer.writeBinBuffer(e)
            };
            var u = T_.deprecate(function () { }, "bRaw in writeList is deprecated, use List(TarsStream.String, bRaw) instead");
            h.OutputStream.prototype.writeList = function (t, e, r) {
                this._writeTo(t, h.DataHelp.EN_LIST), this.writeInt32(0, e.length), !0 === r && u();
                for (var o = e._bValue || r, n = 0, i = e.value.length; n < i; n++) e._proto._write(this, 0, e.value[n], o)
            }, h.OutputStream.prototype.writeMap = function (t, r) {
                this._writeTo(t, h.DataHelp.EN_MAP), this.writeInt32(0, r.size());
                var o = this,
                    n = r._bKey,
                    i = r._bValue;
                r._kproto == h.String && (n = !1), r.forEach(function (t, e) {
                    r._kproto._write(o, 0, t, n), r._vproto._write(o, 1, e, i)
                }, n)
            }, h.OutputStream.prototype.getBinBuffer = function () {
                return this._binBuffer
            }, h.InputStream = function (t) {
                this._binBuffer = t, this._binBuffer._position = 0
            }, h.InputStream.prototype.setBinBuffer = function (t) {
                this._binBuffer = t, this._binBuffer._position = 0
            }, h.InputStream.prototype._readFrom = function () {
                var t = this._binBuffer.readUInt8(),
                    e = (240 & t) >> 4,
                    r = 15 & t;
                return 15 <= e && (e = this._binBuffer.readUInt8()), {
                    tag: e,
                    type: r
                }
            }, h.InputStream.prototype._peekFrom = function () {
                var t = this._binBuffer._position,
                    e = this._readFrom();
                return this._binBuffer.position = t, {
                    tag: e.tag,
                    type: e.type,
                    size: 15 <= e.tag ? 2 : 1
                }
            }, h.InputStream.prototype._skipField = function (t) {
                switch (t) {
                    case h.DataHelp.EN_INT8:
                        this._binBuffer._position += 1;
                        break;
                    case h.DataHelp.EN_INT16:
                        this._binBuffer._position += 2;
                        break;
                    case h.DataHelp.EN_INT32:
                        this._binBuffer._position += 4;
                        break;
                    case h.DataHelp.EN_INT64:
                        this._binBuffer._position += 8;
                        break;
                    case h.DataHelp.EN_FLOAT:
                        this._binBuffer._position += 4;
                        break;
                    case h.DataHelp.EN_DOUBLE:
                        this._binBuffer._position += 8;
                        break;
                    case h.DataHelp.EN_STRING1:
                        var e = this._binBuffer.readUInt8();
                        this._binBuffer._position += e;
                        break;
                    case h.DataHelp.EN_STRING4:
                        e = this._binBuffer.readUInt32();
                        this._binBuffer._position += e;
                        break;
                    case h.DataHelp.EN_STRUCTBEGIN:
                        this._skipToStructEnd();
                        break;
                    case h.DataHelp.EN_STRUCTEND:
                    case h.DataHelp.EN_ZERO:
                        break;
                    case h.DataHelp.EN_MAP:
                        for (var r = this.readInt32(0, !0), o = 0; o < 2 * r; ++o) {
                            var n = this._readFrom();
                            this._skipField(n.type)
                        }
                        break;
                    case h.DataHelp.EN_SIMPLELIST:
                        if ((n = this._readFrom()).type != h.DataHelp.EN_INT8) throw new h.DecodeInvalidValue("skipField with invalid type, type value: " + t + "," + n.type);
                        e = this.readInt32(0, !0);
                        this._binBuffer._position += e;
                        break;
                    case h.DataHelp.EN_LIST:
                        for (r = this.readInt32(0, !0), o = 0; o < r; ++o) {
                            n = this._readFrom();
                            this._skipField(n.type)
                        }
                        break;
                    default:
                        throw new h.DecodeInvalidValue("skipField with invalid type, type value: " + t)
                }
            }, h.InputStream.prototype._skipToStructEnd = function () {
                for (; ;) {
                    var t = this._readFrom();
                    if (this._skipField(t.type), t.type == h.DataHelp.EN_STRUCTEND) return
                }
            }, h.InputStream.prototype._skipToTag = function (t, e) {
                for (; this._binBuffer._position < this._binBuffer._length;) {
                    var r = this._peekFrom();
                    if (this._tagPosMap && (this._tagPosMap[r.tag] = this._binBuffer._position, this._tagPosMap._current = this._binBuffer._position), t <= r.tag || r.type == h.DataHelp.EN_STRUCTEND) {
                        if (r.type !== h.DataHelp.EN_STRUCTEND && t === r.tag) return !0;
                        break
                    }
                    this._binBuffer._position += r.size, this._skipField(r.type)
                }
                if (e) throw new h.DecodeRequireNotExist("require field not exist, tag:" + t);
                return !1
            }, h.InputStream.prototype.readBoolean = function (t, e, r) {
                return 1 == this.readInt8(t, e, r)
            }, h.InputStream.prototype.readInt8 = function (t, e, r) {
                if (0 == this._skipToTag(t, e)) return r;
                var o = this._readFrom();
                switch (o.type) {
                    case h.DataHelp.EN_ZERO:
                        return 0;
                    case h.DataHelp.EN_INT8:
                        return this._binBuffer.readInt8()
                }
                throw new h.DecodeMismatch("read int8 type mismatch, tag:" + t + ", get type:" + o.type)
            }, h.InputStream.prototype.readInt16 = function (t, e, r) {
                if (0 == this._skipToTag(t, e)) return r;
                var o = this._readFrom();
                switch (o.type) {
                    case h.DataHelp.EN_ZERO:
                        return 0;
                    case h.DataHelp.EN_INT8:
                        return this._binBuffer.readInt8();
                    case h.DataHelp.EN_INT16:
                        return this._binBuffer.readInt16()
                }
                throw new h.DecodeMismatch("read int8 type mismatch, tag:" + t + ", get type:" + o.type)
            }, h.InputStream.prototype.readInt32 = function (t, e, r) {
                if (0 == this._skipToTag(t, e)) return r;
                var o = this._readFrom();
                switch (o.type) {
                    case h.DataHelp.EN_ZERO:
                        return 0;
                    case h.DataHelp.EN_INT8:
                        return this._binBuffer.readInt8();
                    case h.DataHelp.EN_INT16:
                        return this._binBuffer.readInt16();
                    case h.DataHelp.EN_INT32:
                        return this._binBuffer.readInt32()
                }
                throw new h.DecodeMismatch("read int8 type mismatch, tag:" + t + ", get type:" + o.type)
            }, h.InputStream.prototype.readInt64 = function (t, e, r, o) {
                if (0 == this._skipToTag(t, e)) return r;
                var n = this._readFrom();
                switch (n.type) {
                    case h.DataHelp.EN_ZERO:
                        return 0;
                    case h.DataHelp.EN_INT8:
                        return this._binBuffer.readInt8();
                    case h.DataHelp.EN_INT16:
                        return this._binBuffer.readInt16();
                    case h.DataHelp.EN_INT32:
                        return this._binBuffer.readInt32();
                    case h.DataHelp.EN_INT64:
                        return this._binBuffer.readInt64(o)
                }
                throw new h.DecodeMismatch("read int64 type mismatch, tag:" + t + ", get type:" + n.type)
            }, h.InputStream.prototype.readFloat = function (t, e, r) {
                if (0 == this._skipToTag(t, e)) return r;
                var o = this._readFrom();
                switch (o.type) {
                    case h.DataHelp.EN_ZERO:
                        return 0;
                    case h.DataHelp.EN_FLOAT:
                        return this._binBuffer.readFloat()
                }
                throw new h.DecodeMismatch("read float type mismatch, tag:" + t + ", get type:" + o.type)
            }, h.InputStream.prototype.readDouble = function (t, e, r) {
                if (0 == this._skipToTag(t, e)) return r;
                var o = this._readFrom();
                switch (o.type) {
                    case h.DataHelp.EN_ZERO:
                        return 0;
                    case h.DataHelp.EN_DOUBLE:
                        return this._binBuffer.readDouble()
                }
                throw new h.DecodeMismatch("read double type mismatch, tag:" + t + ", get type:" + o.type)
            }, h.InputStream.prototype.readUInt8 = function (t, e, r) {
                return this.readInt16(t, e, r)
            }, h.InputStream.prototype.readUInt16 = function (t, e, r) {
                return this.readInt32(t, e, r)
            }, h.InputStream.prototype.readUInt32 = function (t, e, r) {
                return this.readInt64(t, e, r)
            }, h.InputStream.prototype.readString = function (t, e, r, o) {
                if (0 == this._skipToTag(t, e)) return r;
                var n = this._readFrom();
                if (n.type == h.DataHelp.EN_STRING1) return this._binBuffer.readString(this._binBuffer.readUInt8(), o);
                if (n.type == h.DataHelp.EN_STRING4) return this._binBuffer.readString(this._binBuffer.readUInt32(), o);
                throw new h.DecodeMismatch("read 'string' type mismatch, tag: " + t + ", get type: " + n.type + ".")
            }, h.InputStream.prototype.readStruct = function (t, e, r) {
                if (0 == this._skipToTag(t, e)) return new r;
                var o = this._readFrom();
                if (o.type != h.DataHelp.EN_STRUCTBEGIN) throw new h.DecodeMismatch("read struct type mismatch, tag: " + t + ", get type:" + o.type);
                var n = r._readFrom(this);
                return this._skipToStructEnd(), n
            }, h.InputStream.prototype.readBytes = function (t, e, r, o) {
                if (0 == this._skipToTag(t, e)) return new r;
                var n = this._readFrom();
                if (n.type != h.DataHelp.EN_SIMPLELIST) throw new h.DecodeMismatch("type mismatch, tag:" + t + ",type:" + n.type);
                var i = this._readFrom();
                if (i.type != h.DataHelp.EN_INT8) throw new h.DecodeMismatch("type mismatch, tag:" + t + ",type:" + n.type + "," + i.type);
                var s = this.readInt32(0, !0);
                if (s < 0) throw new h.DecodeInvalidValue("invalid size, tag:" + t + ",type:" + n.type + "," + i.type);
                var a = this._binBuffer.readBinBuffer(s, o);
                return a.position = 0, a
            };
            var c = T_.deprecate(function () { }, "bRaw in readList is deprecated, use List(TarsStream.String, bRaw) instead");
            h.InputStream.prototype.readList = function (t, e, r, o) {
                if (0 == this._skipToTag(t, e)) return r;
                var n = this._readFrom();
                if (n.type != h.DataHelp.EN_LIST) throw new h.DecodeMismatch("read 'vector' type mismatch, tag: " + t + ", get type: " + n.type);
                var i = this.readInt32(0, !0);
                if (i < 0) throw new h.DecodeInvalidValue("invalid size, tag: " + t + ", type: " + n.type + ", size: " + i);
                !0 === o && c();
                for (var s = r._bValue || o, a = new h.List(r._proto), u = 0; u < i; ++u) a.value.push(a._proto._read(this, 0, a._proto, s));
                return a
            }, h.InputStream.prototype.readMap = function (t, e, r) {
                if (0 == this._skipToTag(t, e)) return r;
                var o = this._readFrom();
                if (o.type != h.DataHelp.EN_MAP) throw new h.DecodeMismatch("read 'map' type mismatch, tag: " + t + ", get type: " + o.type);
                var n = this.readInt32(0, !0);
                if (n < 0) throw new h.DecodeMismatch("invalid map, tag: " + t + ", size: " + n);
                var i = r._bKey,
                    s = r._bValue;
                r._kproto == h.String && (i = !1);
                for (var a = new h.Map(r._kproto, r._vproto, i, s), u = 0; u < n; u++) {
                    var c = a._kproto._read(this, 0, a._kproto, i),
                        f = a._vproto._read(this, 1, a._vproto, s);
                    a.insert(c, f)
                }
                return a
            }, h.UniAttribute = function () {
                this._data = new h.Map(h.String, h.BinBuffer), this._mmap = new h.Map(h.String, h.Map(h.String, h.BinBuffer)), this._buff = new h.OutputStream, this._temp = new h.InputStream(new h.BinBuffer), this._iver = h.UniAttribute.TUP_SIMPLE, this.__defineGetter__("tupVersion", function () {
                    return this._iver
                }), this.__defineSetter__("tupVersion", function (t) {
                    this._iver = t
                })
            }, h.UniAttribute.TUP_COMPLEX = 2, h.UniAttribute.TUP_SIMPLE = 3, h.UniAttribute.prototype._getkey = function (t, e, r, o, n) {
                if (this._iver == h.UniAttribute.TUP_SIMPLE) {
                    if (null == (i = this._data.get(t)) && null == e) throw new h.TupNotFoundKey("UniAttribute not found key:" + t);
                    if (null == i && null != e) return e
                } else {
                    var i, s = this._mmap.get(t);
                    if (null == s && null == e) throw new h.TupNotFoundKey("UniAttribute not found key:" + t);
                    if (null == s && null != e) return e;
                    if (null == (i = s.get(r._classname))) throw new h.TupNotFoundKey("UniAttribute type match fail,key:" + t + ",type:" + r._classname)
                }
                return this._temp.setBinBuffer(i), o.call(this._temp, 0, !0, r, n)
            }, h.UniAttribute.prototype._setkey = function (t, e, r, o, n) {
                if (this._buff._binBuffer.reset(), o.call(this._buff, 0, e, n), this._iver == h.UniAttribute.TUP_SIMPLE) this._data.set(t, new h.BinBuffer(this._buff.getBinBuffer().toNodeBuffer()));
                else {
                    var i = new h.Map(h.String, h.BinBuffer);
                    i.set(r._classname, new h.BinBuffer(this._buff.getBinBuffer().toNodeBuffer())), this._mmap.set(t, i)
                }
            }, h.UniAttribute.prototype.decode = function (t) {
                var e = new h.InputStream(t);
                this._iver == h.UniAttribute.TUP_SIMPLE ? (this._data.clear(), this._data = e.readMap(0, !0, h.Map(h.String, h.BinBuffer))) : (this._mmap.clear(), this._mmap = e.readMap(0, !0, h.Map(h.String, h.Map(h.String, h.BinBuffer))))
            }, h.UniAttribute.prototype.encode = function () {
                var t = new h.OutputStream;
                return t.writeMap(0, this._iver == h.UniAttribute.TUP_SIMPLE ? this._data : this._mmap), t.getBinBuffer()
            }, h.UniAttribute.prototype.writeBoolean = function (t, e) {
                this._setkey(t, e, h.Boolean, this._buff.writeBoolean)
            }, h.UniAttribute.prototype.writeInt8 = function (t, e) {
                this._setkey(t, e, h.Int8, this._buff.writeInt8)
            }, h.UniAttribute.prototype.writeUInt8 = function (t, e) {
                this._setkey(t, e, h.UInt8, this._buff.writeUInt8)
            }, h.UniAttribute.prototype.writeInt16 = function (t, e) {
                this._setkey(t, e, h.Int16, this._buff.writeInt16)
            }, h.UniAttribute.prototype.writeUInt16 = function (t, e) {
                this._setkey(t, e, h.UInt16, this._buff.writeUInt16)
            }, h.UniAttribute.prototype.writeInt32 = function (t, e) {
                this._setkey(t, e, h.Int32, this._buff.writeInt32)
            }, h.UniAttribute.prototype.writeUInt32 = function (t, e) {
                this._setkey(t, e, h.UInt32, this._buff.writeUInt32)
            }, h.UniAttribute.prototype.writeInt64 = function (t, e, r) {
                this._setkey(t, e, h.Int64, this._buff.writeInt64, r)
            }, h.UniAttribute.prototype.writeFloat = function (t, e) {
                this._setkey(t, e, h.Float, this._buff.writeFloat)
            }, h.UniAttribute.prototype.writeDouble = function (t, e) {
                this._setkey(t, e, h.Double, this._buff.writeDouble)
            }, h.UniAttribute.prototype.writeBytes = function (t, e) {
                this._setkey(t, e, h.BinBuffer, this._buff.writeBytes)
            }, h.UniAttribute.prototype.writeString = function (t, e, r) {
                this._setkey(t, e, h.String, this._buff.writeString, r)
            }, h.UniAttribute.prototype.writeStruct = function (t, e) {
                this._setkey(t, e, e, this._buff.writeStruct)
            }, h.UniAttribute.prototype.writeList = function (t, e) {
                this._setkey(t, e, e, this._buff.writeList)
            }, h.UniAttribute.prototype.writeMap = function (t, e) {
                this._setkey(t, e, e, this._buff.writeMap)
            }, h.UniAttribute.prototype.readBoolean = function (t, e) {
                return this._getkey(t, e, h.Boolean, this._temp.readBoolean)
            }, h.UniAttribute.prototype.readInt8 = function (t, e) {
                return this._getkey(t, e, h.Int8, this._temp.readInt8)
            }, h.UniAttribute.prototype.readUInt8 = function (t, e) {
                return this._getkey(t, e, h.UInt8, this._temp.readUInt8)
            }, h.UniAttribute.prototype.readInt16 = function (t, e) {
                return this._getkey(t, e, h.Int16, this._temp.readInt16)
            }, h.UniAttribute.prototype.readUInt16 = function (t, e) {
                return this._getkey(t, e, h.UInt16, this._temp.readUInt16)
            }, h.UniAttribute.prototype.readInt32 = function (t, e) {
                return this._getkey(t, e, h.Int32, this._temp.readInt32)
            }, h.UniAttribute.prototype.readUInt32 = function (t, e) {
                return this._getkey(t, e, h.UInt32, this._temp.readUInt32)
            }, h.UniAttribute.prototype.readInt64 = function (t, e, r) {
                return this._getkey(t, e, h.Int64, this._temp.readInt64, r)
            }, h.UniAttribute.prototype.readFloat = function (t, e) {
                return this._getkey(t, e, h.Float, this._temp.readFloat)
            }, h.UniAttribute.prototype.readDouble = function (t, e) {
                return this._getkey(t, e, h.Double, this._temp.readDouble)
            }, h.UniAttribute.prototype.readBytes = function (t, e) {
                return this._getkey(t, e, h.BinBuffer, this._temp.readBytes)
            }, h.UniAttribute.prototype.readString = function (t, e, r) {
                return this._getkey(t, e, h.String, this._temp.readString, r)
            }, h.UniAttribute.prototype.readStruct = function (t, e, r) {
                return this._getkey(t, r, e, this._temp.readStruct)
            }, h.UniAttribute.prototype.readList = function (t, e, r) {
                return this._getkey(t, r, e, this._temp.readList)
            }, h.UniAttribute.prototype.readMap = function (t, e, r) {
                return this._getkey(t, r, e, this._temp.readMap)
            }, h.Tup = function () {
                this._iVersion = 0, this._cPacketType = 0, this._iMessageType = 0, this._iRequestId = 0, this._sServantName = "", this._sFuncName = "", this._binBuffer = new h.BinBuffer, this._iTimeout = 0, this._context = new h.Map(h.String, h.String), this._status = new h.Map(h.String, h.String), this._attribute = new h.UniAttribute, this.__defineGetter__("servantName", function () {
                    return this._sServantName
                }), this.__defineSetter__("servantName", function (t) {
                    this._sServantName = t
                }), this.__defineGetter__("funcName", function () {
                    return this._sFuncName
                }), this.__defineSetter__("funcName", function (t) {
                    this._sFuncName = t
                }), this.__defineGetter__("requestId", function () {
                    return this._iRequestId
                }), this.__defineSetter__("requestId", function (t) {
                    this._iRequestId = t
                }), this.__defineGetter__("tupVersion", function () {
                    return this._attribute.tupVersion
                }), this.__defineSetter__("tupVersion", function (t) {
                    this._attribute.tupVersion = t
                })
            }, h.Tup.TUP_COMPLEX = h.UniAttribute.TUP_COMPLEX, h.Tup.TUP_SIMPLE = h.UniAttribute.TUP_SIMPLE, h.Tup.prototype._writeTo = function () {
                var t = new h.OutputStream;
                t._binBuffer.writeInt32(0), t.writeInt16(1, this._attribute.tupVersion), t.writeInt8(2, this._cPacketType), t.writeInt32(3, this._iMessageType), t.writeInt32(4, this._iRequestId), t.writeString(5, this._sServantName), t.writeString(6, this._sFuncName), t.writeBytes(7, this._binBuffer), t.writeInt32(8, this._iTimeout), t.writeMap(9, this._context), t.writeMap(10, this._status);
                var e = t._binBuffer._position,
                    r = t._binBuffer._length;
                return t._binBuffer._position = 0, t._binBuffer.writeInt32(t._binBuffer._length), t._binBuffer._length = r, t._binBuffer._position = e, t.getBinBuffer()
            }, h.Tup.prototype._readFrom = function (t) {
                this._iVersion = t.readInt16(1, !0), this._cPacketType = t.readInt8(2, !0), this._iMessageType = t.readInt32(3, !0), this._iRequestId = t.readInt32(4, !0), this._sServantName = t.readString(5, !0), this._sFuncName = t.readString(6, !0), this._binBuffer = t.readBytes(7, !0), this._iTimeout = t.readInt32(8, !0), this._context = t.readMap(9, !1, h.Map(h.String, h.String)), this._status = t.readMap(10, !1, h.Map(h.String, h.String)), this._attribute.tupVersion = this._iVersion
            }, h.Tup.prototype.encode = function () {
                return this._binBuffer = this._attribute.encode(), this._writeTo()
            }, h.Tup.prototype.decode = function (t) {
                var e = new h.InputStream(t);
                if (e._binBuffer.readInt32() < 4) throw Error("packet length too short");
                this._readFrom(e), this._attribute.decode(this._binBuffer)
            }, h.Tup.prototype.getTarsResultCode = function () {
                var t = this._status.get("STATUS_RESULT_CODE");
                return void 0 === t ? 0 : parseInt(t)
            }, h.Tup.prototype.getTarsResultDesc = function () {
                var t = this._status.get("STATUS_RESULT_DESC");
                return void 0 === t ? "" : t
            }, h.Tup.prototype.writeBoolean = function (t, e) {
                this._attribute.writeBoolean(t, e)
            }, h.Tup.prototype.writeInt8 = function (t, e) {
                this._attribute.writeInt8(t, e)
            }, h.Tup.prototype.writeUInt8 = function (t, e) {
                this._attribute.writeUInt8(t, e)
            }, h.Tup.prototype.writeInt16 = function (t, e) {
                this._attribute.writeInt16(t, e)
            }, h.Tup.prototype.writeUInt16 = function (t, e) {
                this._attribute.writeUInt16(t, e)
            }, h.Tup.prototype.writeInt32 = function (t, e) {
                this._attribute.writeInt32(t, e)
            }, h.Tup.prototype.writeUInt32 = function (t, e) {
                this._attribute.writeUInt32(t, e)
            }, h.Tup.prototype.writeInt64 = function (t, e, r) {
                this._attribute.writeInt64(t, e, r)
            }, h.Tup.prototype.writeFloat = function (t, e) {
                this._attribute.writeFloat(t, e)
            }, h.Tup.prototype.writeDouble = function (t, e) {
                this._attribute.writeDouble(t, e)
            }, h.Tup.prototype.writeBytes = function (t, e) {
                this._attribute.writeBytes(t, e)
            }, h.Tup.prototype.writeString = function (t, e, r) {
                this._attribute.writeString(t, e, r)
            }, h.Tup.prototype.writeStruct = function (t, e) {
                this._attribute.writeStruct(t, e)
            }, h.Tup.prototype.writeList = function (t, e) {
                this._attribute.writeList(t, e)
            }, h.Tup.prototype.writeMap = function (t, e) {
                this._attribute.writeMap(t, e)
            }, h.Tup.prototype.readBoolean = function (t, e) {
                return this._attribute.readBoolean(t, e)
            }, h.Tup.prototype.readInt8 = function (t, e) {
                return this._attribute.readInt8(t, e)
            }, h.Tup.prototype.readUInt8 = function (t, e) {
                return this._attribute.readUInt8(t, e)
            }, h.Tup.prototype.readInt16 = function (t, e) {
                return this._attribute.readInt16(t, e)
            }, h.Tup.prototype.readUInt16 = function (t, e) {
                return this._attribute.readUInt16(t, e)
            }, h.Tup.prototype.readInt32 = function (t, e) {
                return this._attribute.readInt32(t, e)
            }, h.Tup.prototype.readUInt32 = function (t, e) {
                return this._attribute.readUInt32(t, e)
            }, h.Tup.prototype.readInt64 = function (t, e, r) {
                return this._attribute.readInt64(t, e, r)
            }, h.Tup.prototype.readFloat = function (t, e) {
                return this._attribute.readFloat(t, e)
            }, h.Tup.prototype.readDouble = function (t, e) {
                return this._attribute.readDouble(t, e)
            }, h.Tup.prototype.readBytes = function (t, e) {
                return this._attribute.readBytes(t, e)
            }, h.Tup.prototype.readString = function (t, e, r) {
                return this._attribute.readString(t, e, r)
            }, h.Tup.prototype.readStruct = function (t, e, r) {
                return this._attribute.readStruct(t, e, r)
            }, h.Tup.prototype.readList = function (t, e, r) {
                return this._attribute.readList(t, e, r)
            }, h.Tup.prototype.readMap = function (t, e, r) {
                return this._attribute.readMap(t, e, r)
            }
        })),
        pR = pR || {},
        dR = pR;
    pR.Version = {
        VersionIm1: 1,
        VersionIm2: 2,
        VersionChat: 3
    }, pR.Version._write = function (t, e, r) {
        return t.writeInt32(e, r)
    }, pR.Version._read = function (t, e, r) {
        return t.readInt32(e, !0, r)
    }, pR.Format = {
        FormatTars: 0,
        FormatThrift: 1,
        FormatProtobuf: 2,
        FormatJson: 3
    }, pR.Format._write = function (t, e, r) {
        return t.writeInt32(e, r)
    }, pR.Format._read = function (t, e, r) {
        return t.readInt32(e, !0, r)
    }, pR.Encode = {
        EncodeNone: 0,
        EncodeEncrypt: 1,
        EncodeCompress: 2
    }, pR.Encode._write = function (t, e, r) {
        return t.writeInt32(e, r)
    }, pR.Encode._read = function (t, e, r) {
        return t.readInt32(e, !0, r)
    }, pR.Command = {
        CmdLogin: 10,
        CmdLoginResp: 11,
        CmdPing: 20,
        CmdPong: 21,
        CmdJoinRoom: 31,
        CmdJoinRoomResp: 32,
        CmdJoinRoomNotice: 33,
        CmdJoinRoomInfoNotice: 34,
        CmdJoinRoomUserListNotice: 35,
        CmdRecoverRoomMessageNotice: 36,
        CmdRecoverPeer: 37,
        CmdRecoverPeerResp: 38,
        CmdRecoverPeerMessageNotice: 39,
        CmdLeaveRoom: 40,
        CmdLeaveRoomResp: 41,
        CmdLeaveRoomNotice: 42,
        CmdSendRoomMessage: 50,
        CmdSendRoomMessageResp: 51,
        CmdRecvRoomMessage: 52,
        CmdRecvRoomMessageResp: 53,
        CmdSendPeerMessage: 60,
        CmdSendPeerMessageResp: 61,
        CmdRecvPeerMessage: 62,
        CmdRecvPeerMessageResp: 63,
        CmdGetRoomHistoryMessage: 70,
        CmdGetRoomHistoryMessageResp: 71,
        CmdGetRoomMissingMessage: 72,
        CmdGetRoomMissingMessageResp: 73,
        CmdGetRoomMissingMessageNotice: 74,
        CmdGetPeerMissingMessage: 75,
        CmdGetPeerMissingMessageResp: 76,
        CmdGetPeerMissingMessageNotice: 77,
        CmdMuteRoom: 80,
        CmdMuteRoomResp: 81,
        CmdRoomMuteStatus: 82,
        CmdRoomMuteStatusResp: 83,
        CmdMuteRoomNotice: 84,
        CmdSetRoomData: 85,
        CmdSetRoomDataResp: 86,
        CmdSetBatchRoomData: 301,
        CmdSetBatchRoomDataResp: 302,
        CmdGetRoomData: 87,
        CmdGetRoomDataResp: 88,
        CmdRoomDataNotice: 89,
        CmdRoomDataNoticeResp: 300,
        CmdSendRoomBinMessage: 90,
        CmdSendRoomBinMessageResp: 91,
        CmdRecvRoomBinMessage: 92,
        CmdRecvRoomBinMessageResp: 93,
        CmdGetRoomHistoryBinMessage: 94,
        CmdGetRoomHistoryBinMessageResp: 95,
        CmdGetRoomHistoryBinMessageNotice: 96,
        CmdGetRoomBatchHistoryBinMessage: 97,
        CmdGetRoomBatchHistoryBinMessageResp: 98,
        CmdGetRoomBatchHistoryBinMessageNotice: 99,
        CmdRecoverRoomBinMessageNotice: 120,
        CmdGetRoomMissingBinMessage: 121,
        CmdGetRoomMissingBinMessageResp: 122,
        CmdGetRoomMissingBinMessageNotice: 123,
        CmdRoomMsgSubscribe: 200,
        CmdRoomMsgSubscribeResp: 201,
        CmdRoomDataSubscribe: 202,
        CmdRoomDataSubscribeResp: 203,
        CmdKickout: 100,
        CmdLogout: 101,
        CmdLogoutNotice: 102,
        CmdGetStatistics: 110,
        CmdGetStatisticsResp: 111,
        CmdGetStatisticsNotice: 112,
        CmdGetRoomUserList: 113,
        CmdGetRoomUserListResp: 114,
        CmdRoomUserCountNotice: 115,
        CmdUnkown: 999
    }, pR.Command._write = function (t, e, r) {
        return t.writeInt32(e, r)
    }, pR.Command._read = function (t, e, r) {
        return t.readInt32(e, !0, r)
    }, pR.Role = {
        RoleUnkown: 0,
        RoleTeacher: 1,
        RoleStudent: 2
    }, pR.Role._write = function (t, e, r) {
        return t.writeInt32(e, r)
    }, pR.Role._read = function (t, e, r) {
        return t.readInt32(e, !0, r)
    }, pR.DeviceType = {
        DeviceTypeIPhone: 0,
        DeviceTypeIPad: 1,
        DeviceTypeAndroid: 2,
        DeviceTypeWin: 3,
        DeviceTypeMac: 4,
        DeviceTypeLinux: 5,
        DeviceTypeWeb: 6,
        DeviceTypeWX: 7,
        DeviceTypeZFB: 8,
        DeviceTypeOther: 20
    }, pR.DeviceType._write = function (t, e, r) {
        return t.writeInt32(e, r)
    }, pR.DeviceType._read = function (t, e, r) {
        return t.readInt32(e, !0, r)
    }, pR.MessagePriority = {
        MessagePriorityTopic: 0,
        MessagePriorityNotice: 1,
        MessagePriorityInfo: 2,
        MessagePriorityPrivMsg: 99
    }, pR.MessagePriority._write = function (t, e, r) {
        return t.writeInt32(e, r)
    }, pR.MessagePriority._read = function (t, e, r) {
        return t.readInt32(e, !0, r)
    }, pR.RoomUserListMode = {
        RoomUserListModeNone: 0,
        RoomUserListModeAll: 1,
        RoomUserListModeTeacher: 2
    }, pR.RoomUserListMode._write = function (t, e, r) {
        return t.writeInt32(e, r)
    }, pR.RoomUserListMode._read = function (t, e, r) {
        return t.readInt32(e, !0, r)
    }, pR.Code = {
        CodeSuccess: 0,
        CodeErrUnknown: 100,
        CodeErrInvalidParam: 106,
        CodeErrBodyTooLarge: 108,
        CodeErrPsIdNotExsit: 200,
        CodeErrInvalidPassword: 201,
        CodeErrEmptyNickname: 202,
        CodeErrInvalidNickname: 203,
        CodeErrExistNickname: 204,
        CodeErrTokenExpire: 205,
        CodeErrInvalidDeviceType: 206,
        CodeErrKickoutScedule: 300,
        CodeErrKickoutRepeat: 301,
        CodeErrKickoutRequest: 302,
        CodeErrKickoutPingTimeout: 303,
        CodeErrKickoutException: 399,
        CodeErrRoomNotExsit: 400,
        CodeErrRoomTooMany: 401,
        CodeErrRoomNoPermission: 402,
        CodeErrRoomUpperLimit: 403,
        CodeErrRoomInvalidRoomId: 404,
        CodeErrRoomAreadyJoin: 405,
        CodeErrEmptyRecv: 500,
        CodeErrRecvPsIdNotExsit: 501,
        CodeErrRecvNicknameNotExist: 502,
        CodeErrEmptyContent: 503,
        CodeErrRoomSendNoPermission: 504,
        CodeErrNotInRoom: 505,
        CodeErrRecvNotInRoom: 506,
        CodeErrSensitiveWord: 507,
        CodeErrInvalidPriority: 508,
        CodeErrSendUpLimit: 509,
        CodeErrMuteOpen: 510
    }, pR.Code._write = function (t, e, r) {
        return t.writeInt32(e, r)
    }, pR.Code._read = function (t, e, r) {
        return t.readInt32(e, !0, r)
    }, pR.User = function () {
        this.psId = "", this.nickname = "", this._classname = "ChatV2Pro.User"
    }, pR.User._classname = "ChatV2Pro.User", pR.User._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.User._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.User._readFrom = function (t) {
        var e = new pR.User;
        return e.psId = t.readString(0, !0, ""), e.nickname = t.readString(1, !0, ""), e
    }, pR.User.prototype._writeTo = function (t) {
        t.writeString(0, this.psId), t.writeString(1, this.nickname)
    }, pR.User.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.User.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.User.prototype.toObject = function () {
        var t = {};
        return t.psId = this.psId, t.nickname = this.nickname, t
    }, pR.User.prototype.readFromObject = function (t) {
        t.hasOwnProperty("psId") && (this.psId = t.psId), t.hasOwnProperty("nickname") && (this.nickname = t.nickname)
    }, pR.User.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.User.new = function () {
        return new pR.User
    }, pR.User.create = function (t) {
        return pR.User._readFrom(t)
    }, pR.RoomInfo = function () {
        this.topic = "", this.userNum = 0, this._classname = "ChatV2Pro.RoomInfo"
    }, pR.RoomInfo._classname = "ChatV2Pro.RoomInfo", pR.RoomInfo._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.RoomInfo._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.RoomInfo._readFrom = function (t) {
        var e = new pR.RoomInfo;
        return e.topic = t.readString(0, !0, ""), e.userNum = t.readInt32(1, !0, 0), e
    }, pR.RoomInfo.prototype._writeTo = function (t) {
        t.writeString(0, this.topic), t.writeInt32(1, this.userNum)
    }, pR.RoomInfo.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.RoomInfo.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.RoomInfo.prototype.toObject = function () {
        var t = {};
        return t.topic = this.topic, t.userNum = this.userNum, t
    }, pR.RoomInfo.prototype.readFromObject = function (t) {
        t.hasOwnProperty("topic") && (this.topic = t.topic), t.hasOwnProperty("userNum") && (this.userNum = t.userNum)
    }, pR.RoomInfo.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.RoomInfo.new = function () {
        return new pR.RoomInfo
    }, pR.RoomInfo.create = function (t) {
        return pR.RoomInfo._readFrom(t)
    }, pR.UserRespFail = function () {
        this.user = new pR.User, this.code = pR.Code.CodeSuccess, this.msg = "", this._classname = "ChatV2Pro.UserRespFail"
    }, pR.UserRespFail._classname = "ChatV2Pro.UserRespFail", pR.UserRespFail._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.UserRespFail._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.UserRespFail._readFrom = function (t) {
        var e = new pR.UserRespFail;
        return e.user = t.readStruct(0, !0, pR.User), e.code = t.readInt32(1, !0, pR.Code.CodeSuccess), e.msg = t.readString(2, !1, ""), e
    }, pR.UserRespFail.prototype._writeTo = function (t) {
        t.writeStruct(0, this.user), t.writeInt32(1, this.code), t.writeString(2, this.msg)
    }, pR.UserRespFail.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.UserRespFail.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.UserRespFail.prototype.toObject = function () {
        var t = {};
        return t.user = this.user.toObject(), t.code = this.code, t.msg = this.msg, t
    }, pR.UserRespFail.prototype.readFromObject = function (t) {
        t.hasOwnProperty("user") && this.user.readFromObject(t.user), t.hasOwnProperty("code") && (this.code = t.code), t.hasOwnProperty("msg") && (this.msg = t.msg)
    }, pR.UserRespFail.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.UserRespFail.new = function () {
        return new pR.UserRespFail
    }, pR.UserRespFail.create = function (t) {
        return pR.UserRespFail._readFrom(t)
    }, pR.RoomRespFail = function () {
        this.roomId = "", this.code = pR.Code.CodeSuccess, this.msg = "", this._classname = "ChatV2Pro.RoomRespFail"
    }, pR.RoomRespFail._classname = "ChatV2Pro.RoomRespFail", pR.RoomRespFail._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.RoomRespFail._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.RoomRespFail._readFrom = function (t) {
        var e = new pR.RoomRespFail;
        return e.roomId = t.readString(0, !0, ""), e.code = t.readInt32(1, !0, pR.Code.CodeSuccess), e.msg = t.readString(2, !1, ""), e
    }, pR.RoomRespFail.prototype._writeTo = function (t) {
        t.writeString(0, this.roomId), t.writeInt32(1, this.code), t.writeString(2, this.msg)
    }, pR.RoomRespFail.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.RoomRespFail.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.RoomRespFail.prototype.toObject = function () {
        var t = {};
        return t.roomId = this.roomId, t.code = this.code, t.msg = this.msg, t
    }, pR.RoomRespFail.prototype.readFromObject = function (t) {
        t.hasOwnProperty("roomId") && (this.roomId = t.roomId), t.hasOwnProperty("code") && (this.code = t.code), t.hasOwnProperty("msg") && (this.msg = t.msg)
    }, pR.RoomRespFail.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.RoomRespFail.new = function () {
        return new pR.RoomRespFail
    }, pR.RoomRespFail.create = function (t) {
        return pR.RoomRespFail._readFrom(t)
    }, pR.SubscribeOption = function () {
        this.msgType = 0, this.flag = !0, this._classname = "ChatV2Pro.SubscribeOption"
    }, pR.SubscribeOption._classname = "ChatV2Pro.SubscribeOption", pR.SubscribeOption._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.SubscribeOption._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.SubscribeOption._readFrom = function (t) {
        var e = new pR.SubscribeOption;
        return e.msgType = t.readInt32(0, !1, 0), e.flag = t.readBoolean(1, !1, !0), e
    }, pR.SubscribeOption.prototype._writeTo = function (t) {
        t.writeInt32(0, this.msgType), t.writeBoolean(1, this.flag)
    }, pR.SubscribeOption.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.SubscribeOption.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.SubscribeOption.prototype.toObject = function () {
        var t = {};
        return t.msgType = this.msgType, t.flag = this.flag, t
    }, pR.SubscribeOption.prototype.readFromObject = function (t) {
        t.hasOwnProperty("msgType") && (this.msgType = t.msgType), t.hasOwnProperty("flag") && (this.flag = t.flag)
    }, pR.SubscribeOption.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.SubscribeOption.new = function () {
        return new pR.SubscribeOption
    }, pR.SubscribeOption.create = function (t) {
        return pR.SubscribeOption._readFrom(t)
    }, pR.RoomDataSubscribeOption = function () {
        this.msgKey = "", this.flag = !0, this._classname = "ChatV2Pro.RoomDataSubscribeOption"
    }, pR.RoomDataSubscribeOption._classname = "ChatV2Pro.RoomDataSubscribeOption", pR.RoomDataSubscribeOption._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.RoomDataSubscribeOption._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.RoomDataSubscribeOption._readFrom = function (t) {
        var e = new pR.RoomDataSubscribeOption;
        return e.msgKey = t.readString(0, !1, ""), e.flag = t.readBoolean(1, !1, !0), e
    }, pR.RoomDataSubscribeOption.prototype._writeTo = function (t) {
        t.writeString(0, this.msgKey), t.writeBoolean(1, this.flag)
    }, pR.RoomDataSubscribeOption.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.RoomDataSubscribeOption.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.RoomDataSubscribeOption.prototype.toObject = function () {
        var t = {};
        return t.msgKey = this.msgKey, t.flag = this.flag, t
    }, pR.RoomDataSubscribeOption.prototype.readFromObject = function (t) {
        t.hasOwnProperty("msgKey") && (this.msgKey = t.msgKey), t.hasOwnProperty("flag") && (this.flag = t.flag)
    }, pR.RoomDataSubscribeOption.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.RoomDataSubscribeOption.new = function () {
        return new pR.RoomDataSubscribeOption
    }, pR.RoomDataSubscribeOption.create = function (t) {
        return pR.RoomDataSubscribeOption._readFrom(t)
    }, pR.Login = function () {
        this.version = 0, this.appId = "", this.liveId = "", this.psId = "", this.password = "", this.nickname = "", this.deviceType = pR.DeviceType.DeviceTypeOther, this.token = "", this.kickout = !1, this.role = pR.Role.RoleUnkown, this.reconnect = !1, this.msgPullNum = 50, this.businessId = "", this.subBusinessId = "", this.roomUserMode = 0, this._classname = "ChatV2Pro.Login"
    }, pR.Login._classname = "ChatV2Pro.Login", pR.Login._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.Login._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.Login._readFrom = function (t) {
        var e = new pR.Login;
        return e.version = t.readInt32(0, !0, 0), e.appId = t.readString(1, !0, ""), e.liveId = t.readString(2, !0, ""), e.psId = t.readString(3, !0, ""), e.password = t.readString(4, !0, ""), e.nickname = t.readString(5, !0, ""), e.deviceType = t.readInt32(6, !0, pR.DeviceType.DeviceTypeOther), e.token = t.readString(7, !0, ""), e.kickout = t.readBoolean(8, !1, !1), e.role = t.readInt32(9, !1, pR.Role.RoleUnkown), e.reconnect = t.readBoolean(10, !1, !1), e.msgPullNum = t.readInt32(11, !1, 50), e.businessId = t.readString(12, !1, ""), e.subBusinessId = t.readString(13, !1, ""), e.roomUserMode = t.readInt32(14, !1, 0), e
    }, pR.Login.prototype._writeTo = function (t) {
        t.writeInt32(0, this.version), t.writeString(1, this.appId), t.writeString(2, this.liveId), t.writeString(3, this.psId), t.writeString(4, this.password), t.writeString(5, this.nickname), t.writeInt32(6, this.deviceType), t.writeString(7, this.token), t.writeBoolean(8, this.kickout), t.writeInt32(9, this.role), t.writeBoolean(10, this.reconnect), t.writeInt32(11, this.msgPullNum), t.writeString(12, this.businessId), t.writeString(13, this.subBusinessId), t.writeInt32(14, this.roomUserMode)
    }, pR.Login.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.Login.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.Login.prototype.toObject = function () {
        var t = {};
        return t.version = this.version, t.appId = this.appId, t.liveId = this.liveId, t.psId = this.psId, t.password = this.password, t.nickname = this.nickname, t.deviceType = this.deviceType, t.token = this.token, t.kickout = this.kickout, t.role = this.role, t.reconnect = this.reconnect, t.msgPullNum = this.msgPullNum, t.businessId = this.businessId, t.subBusinessId = this.subBusinessId, t.roomUserMode = this.roomUserMode, t
    }, pR.Login.prototype.readFromObject = function (t) {
        t.hasOwnProperty("version") && (this.version = t.version), t.hasOwnProperty("appId") && (this.appId = t.appId), t.hasOwnProperty("liveId") && (this.liveId = t.liveId), t.hasOwnProperty("psId") && (this.psId = t.psId), t.hasOwnProperty("password") && (this.password = t.password), t.hasOwnProperty("nickname") && (this.nickname = t.nickname), t.hasOwnProperty("deviceType") && (this.deviceType = t.deviceType), t.hasOwnProperty("token") && (this.token = t.token), t.hasOwnProperty("kickout") && (this.kickout = t.kickout), t.hasOwnProperty("role") && (this.role = t.role), t.hasOwnProperty("reconnect") && (this.reconnect = t.reconnect), t.hasOwnProperty("msgPullNum") && (this.msgPullNum = t.msgPullNum), t.hasOwnProperty("businessId") && (this.businessId = t.businessId), t.hasOwnProperty("subBusinessId") && (this.subBusinessId = t.subBusinessId), t.hasOwnProperty("roomUserMode") && (this.roomUserMode = t.roomUserMode)
    }, pR.Login.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.Login.new = function () {
        return new pR.Login
    }, pR.Login.create = function (t) {
        return pR.Login._readFrom(t)
    }, pR.LoginRespData = function () {
        this.user = new pR.User, this.timeout = 20, this.encpytType = 0, this.encryptKey = new hR.BinBuffer, this.servInfo = "", this._classname = "ChatV2Pro.LoginRespData"
    }, pR.LoginRespData._classname = "ChatV2Pro.LoginRespData", pR.LoginRespData._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.LoginRespData._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.LoginRespData._readFrom = function (t) {
        var e = new pR.LoginRespData;
        return e.user = t.readStruct(0, !0, pR.User), e.timeout = t.readInt32(1, !0, 20), e.encpytType = t.readInt32(2, !0, 0), e.encryptKey = t.readBytes(3, !1, hR.BinBuffer), e.servInfo = t.readString(4, !0, ""), e
    }, pR.LoginRespData.prototype._writeTo = function (t) {
        t.writeStruct(0, this.user), t.writeInt32(1, this.timeout), t.writeInt32(2, this.encpytType), t.writeBytes(3, this.encryptKey), t.writeString(4, this.servInfo)
    }, pR.LoginRespData.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.LoginRespData.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.LoginRespData.prototype.toObject = function () {
        var t = {};
        return t.user = this.user.toObject(), t.timeout = this.timeout, t.encpytType = this.encpytType, t.encryptKey = this.encryptKey.toObject(), t.servInfo = this.servInfo, t
    }, pR.LoginRespData.prototype.readFromObject = function (t) {
        t.hasOwnProperty("user") && this.user.readFromObject(t.user), t.hasOwnProperty("timeout") && (this.timeout = t.timeout), t.hasOwnProperty("encpytType") && (this.encpytType = t.encpytType), t.hasOwnProperty("encryptKey") && this.encryptKey.readFromObject(t.encryptKey), t.hasOwnProperty("servInfo") && (this.servInfo = t.servInfo)
    }, pR.LoginRespData.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.LoginRespData.new = function () {
        return new pR.LoginRespData
    }, pR.LoginRespData.create = function (t) {
        return pR.LoginRespData._readFrom(t)
    }, pR.LoginResp = function () {
        this.code = pR.Code.CodeSuccess, this.msg = "", this.data = new pR.LoginRespData, this._classname = "ChatV2Pro.LoginResp"
    }, pR.LoginResp._classname = "ChatV2Pro.LoginResp", pR.LoginResp._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.LoginResp._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.LoginResp._readFrom = function (t) {
        var e = new pR.LoginResp;
        return e.code = t.readInt32(0, !0, pR.Code.CodeSuccess), e.msg = t.readString(1, !1, ""), e.data = t.readStruct(2, !1, pR.LoginRespData), e
    }, pR.LoginResp.prototype._writeTo = function (t) {
        t.writeInt32(0, this.code), t.writeString(1, this.msg), t.writeStruct(2, this.data)
    }, pR.LoginResp.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.LoginResp.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.LoginResp.prototype.toObject = function () {
        var t = {};
        return t.code = this.code, t.msg = this.msg, t.data = this.data.toObject(), t
    }, pR.LoginResp.prototype.readFromObject = function (t) {
        t.hasOwnProperty("code") && (this.code = t.code), t.hasOwnProperty("msg") && (this.msg = t.msg), t.hasOwnProperty("data") && this.data.readFromObject(t.data)
    }, pR.LoginResp.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.LoginResp.new = function () {
        return new pR.LoginResp
    }, pR.LoginResp.create = function (t) {
        return pR.LoginResp._readFrom(t)
    }, pR.JoinRoom = function () {
        this.roomIds = new hR.List(hR.String), this.userList = pR.RoomUserListMode.RoomUserListModeAll, this.unitSeqIds = new hR.List(hR.Int64), this.binMsgUnitSeqIds = new hR.List(hR.Int64), this.msgSubscribe = new hR.Map(hR.String, hR.List(pR.SubscribeOption)), this.roomDataSubscribe = new hR.Map(hR.String, hR.List(pR.RoomDataSubscribeOption)), this._classname = "ChatV2Pro.JoinRoom"
    }, pR.JoinRoom._classname = "ChatV2Pro.JoinRoom", pR.JoinRoom._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.JoinRoom._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.JoinRoom._readFrom = function (t) {
        var e = new pR.JoinRoom;
        return e.roomIds = t.readList(0, !0, hR.List(hR.String)), e.userList = t.readInt32(1, !1, pR.RoomUserListMode.RoomUserListModeAll), e.unitSeqIds = t.readList(2, !1, hR.List(hR.Int64)), e.binMsgUnitSeqIds = t.readList(3, !1, hR.List(hR.Int64)), e.msgSubscribe = t.readMap(4, !1, hR.Map(hR.String, hR.List(pR.SubscribeOption))), e.roomDataSubscribe = t.readMap(5, !1, hR.Map(hR.String, hR.List(pR.RoomDataSubscribeOption))), e
    }, pR.JoinRoom.prototype._writeTo = function (t) {
        t.writeList(0, this.roomIds), t.writeInt32(1, this.userList), t.writeList(2, this.unitSeqIds), t.writeList(3, this.binMsgUnitSeqIds), t.writeMap(4, this.msgSubscribe), t.writeMap(5, this.roomDataSubscribe)
    }, pR.JoinRoom.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.JoinRoom.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.JoinRoom.prototype.toObject = function () {
        var t = {};
        return t.roomIds = this.roomIds.toObject(), t.userList = this.userList, t.unitSeqIds = this.unitSeqIds.toObject(), t.binMsgUnitSeqIds = this.binMsgUnitSeqIds.toObject(), t.msgSubscribe = this.msgSubscribe.toObject(), t.roomDataSubscribe = this.roomDataSubscribe.toObject(), t
    }, pR.JoinRoom.prototype.readFromObject = function (t) {
        t.hasOwnProperty("roomIds") && this.roomIds.readFromObject(t.roomIds), t.hasOwnProperty("userList") && (this.userList = t.userList), t.hasOwnProperty("unitSeqIds") && this.unitSeqIds.readFromObject(t.unitSeqIds), t.hasOwnProperty("binMsgUnitSeqIds") && this.binMsgUnitSeqIds.readFromObject(t.binMsgUnitSeqIds), t.hasOwnProperty("msgSubscribe") && this.msgSubscribe.readFromObject(t.msgSubscribe), t.hasOwnProperty("roomDataSubscribe") && this.roomDataSubscribe.readFromObject(t.roomDataSubscribe)
    }, pR.JoinRoom.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.JoinRoom.new = function () {
        return new pR.JoinRoom
    }, pR.JoinRoom.create = function (t) {
        return pR.JoinRoom._readFrom(t)
    }, pR.JoinRoomRespData = function () {
        this.fail = new hR.List(pR.RoomRespFail), this._classname = "ChatV2Pro.JoinRoomRespData"
    }, pR.JoinRoomRespData._classname = "ChatV2Pro.JoinRoomRespData", pR.JoinRoomRespData._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.JoinRoomRespData._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.JoinRoomRespData._readFrom = function (t) {
        var e = new pR.JoinRoomRespData;
        return e.fail = t.readList(0, !0, hR.List(pR.RoomRespFail)), e
    }, pR.JoinRoomRespData.prototype._writeTo = function (t) {
        t.writeList(0, this.fail)
    }, pR.JoinRoomRespData.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.JoinRoomRespData.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.JoinRoomRespData.prototype.toObject = function () {
        var t = {};
        return t.fail = this.fail.toObject(), t
    }, pR.JoinRoomRespData.prototype.readFromObject = function (t) {
        t.hasOwnProperty("fail") && this.fail.readFromObject(t.fail)
    }, pR.JoinRoomRespData.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.JoinRoomRespData.new = function () {
        return new pR.JoinRoomRespData
    }, pR.JoinRoomRespData.create = function (t) {
        return pR.JoinRoomRespData._readFrom(t)
    }, pR.JoinRoomResp = function () {
        this.code = pR.Code.CodeSuccess, this.msg = "", this.data = new pR.JoinRoomRespData, this._classname = "ChatV2Pro.JoinRoomResp"
    }, pR.JoinRoomResp._classname = "ChatV2Pro.JoinRoomResp", pR.JoinRoomResp._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.JoinRoomResp._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.JoinRoomResp._readFrom = function (t) {
        var e = new pR.JoinRoomResp;
        return e.code = t.readInt32(0, !0, pR.Code.CodeSuccess), e.msg = t.readString(1, !1, ""), e.data = t.readStruct(2, !1, pR.JoinRoomRespData), e
    }, pR.JoinRoomResp.prototype._writeTo = function (t) {
        t.writeInt32(0, this.code), t.writeString(1, this.msg), t.writeStruct(2, this.data)
    }, pR.JoinRoomResp.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.JoinRoomResp.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.JoinRoomResp.prototype.toObject = function () {
        var t = {};
        return t.code = this.code, t.msg = this.msg, t.data = this.data.toObject(), t
    }, pR.JoinRoomResp.prototype.readFromObject = function (t) {
        t.hasOwnProperty("code") && (this.code = t.code), t.hasOwnProperty("msg") && (this.msg = t.msg), t.hasOwnProperty("data") && this.data.readFromObject(t.data)
    }, pR.JoinRoomResp.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.JoinRoomResp.new = function () {
        return new pR.JoinRoomResp
    }, pR.JoinRoomResp.create = function (t) {
        return pR.JoinRoomResp._readFrom(t)
    }, pR.JoinRoomNotice = function () {
        this.roomId = "", this.user = new pR.User, this._classname = "ChatV2Pro.JoinRoomNotice"
    }, pR.JoinRoomNotice._classname = "ChatV2Pro.JoinRoomNotice", pR.JoinRoomNotice._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.JoinRoomNotice._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.JoinRoomNotice._readFrom = function (t) {
        var e = new pR.JoinRoomNotice;
        return e.roomId = t.readString(0, !0, ""), e.user = t.readStruct(1, !0, pR.User), e
    }, pR.JoinRoomNotice.prototype._writeTo = function (t) {
        t.writeString(0, this.roomId), t.writeStruct(1, this.user)
    }, pR.JoinRoomNotice.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.JoinRoomNotice.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.JoinRoomNotice.prototype.toObject = function () {
        var t = {};
        return t.roomId = this.roomId, t.user = this.user.toObject(), t
    }, pR.JoinRoomNotice.prototype.readFromObject = function (t) {
        t.hasOwnProperty("roomId") && (this.roomId = t.roomId), t.hasOwnProperty("user") && this.user.readFromObject(t.user)
    }, pR.JoinRoomNotice.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.JoinRoomNotice.new = function () {
        return new pR.JoinRoomNotice
    }, pR.JoinRoomNotice.create = function (t) {
        return pR.JoinRoomNotice._readFrom(t)
    }, pR.JoinRoomInfoNotice = function () {
        this.roomId = "", this.info = new pR.RoomInfo, this._classname = "ChatV2Pro.JoinRoomInfoNotice"
    }, pR.JoinRoomInfoNotice._classname = "ChatV2Pro.JoinRoomInfoNotice", pR.JoinRoomInfoNotice._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.JoinRoomInfoNotice._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.JoinRoomInfoNotice._readFrom = function (t) {
        var e = new pR.JoinRoomInfoNotice;
        return e.roomId = t.readString(0, !0, ""), e.info = t.readStruct(1, !0, pR.RoomInfo), e
    }, pR.JoinRoomInfoNotice.prototype._writeTo = function (t) {
        t.writeString(0, this.roomId), t.writeStruct(1, this.info)
    }, pR.JoinRoomInfoNotice.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.JoinRoomInfoNotice.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.JoinRoomInfoNotice.prototype.toObject = function () {
        var t = {};
        return t.roomId = this.roomId, t.info = this.info.toObject(), t
    }, pR.JoinRoomInfoNotice.prototype.readFromObject = function (t) {
        t.hasOwnProperty("roomId") && (this.roomId = t.roomId), t.hasOwnProperty("info") && this.info.readFromObject(t.info)
    }, pR.JoinRoomInfoNotice.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.JoinRoomInfoNotice.new = function () {
        return new pR.JoinRoomInfoNotice
    }, pR.JoinRoomInfoNotice.create = function (t) {
        return pR.JoinRoomInfoNotice._readFrom(t)
    }, pR.JoinRoomUserListNotice = function () {
        this.roomId = "", this.finish = !0, this.users = new hR.List(pR.User), this._classname = "ChatV2Pro.JoinRoomUserListNotice"
    }, pR.JoinRoomUserListNotice._classname = "ChatV2Pro.JoinRoomUserListNotice", pR.JoinRoomUserListNotice._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.JoinRoomUserListNotice._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.JoinRoomUserListNotice._readFrom = function (t) {
        var e = new pR.JoinRoomUserListNotice;
        return e.roomId = t.readString(0, !0, ""), e.finish = t.readBoolean(1, !0, !0), e.users = t.readList(2, !0, hR.List(pR.User)), e
    }, pR.JoinRoomUserListNotice.prototype._writeTo = function (t) {
        t.writeString(0, this.roomId), t.writeBoolean(1, this.finish), t.writeList(2, this.users)
    }, pR.JoinRoomUserListNotice.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.JoinRoomUserListNotice.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.JoinRoomUserListNotice.prototype.toObject = function () {
        var t = {};
        return t.roomId = this.roomId, t.finish = this.finish, t.users = this.users.toObject(), t
    }, pR.JoinRoomUserListNotice.prototype.readFromObject = function (t) {
        t.hasOwnProperty("roomId") && (this.roomId = t.roomId), t.hasOwnProperty("finish") && (this.finish = t.finish), t.hasOwnProperty("users") && this.users.readFromObject(t.users)
    }, pR.JoinRoomUserListNotice.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.JoinRoomUserListNotice.new = function () {
        return new pR.JoinRoomUserListNotice
    }, pR.JoinRoomUserListNotice.create = function (t) {
        return pR.JoinRoomUserListNotice._readFrom(t)
    }, pR.RecoverPeer = function () {
        this.peers = new hR.List(pR.User), this.unitSeqIds = new hR.List(hR.Int64), this._classname = "ChatV2Pro.RecoverPeer"
    }, pR.RecoverPeer._classname = "ChatV2Pro.RecoverPeer", pR.RecoverPeer._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.RecoverPeer._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.RecoverPeer._readFrom = function (t) {
        var e = new pR.RecoverPeer;
        return e.peers = t.readList(0, !0, hR.List(pR.User)), e.unitSeqIds = t.readList(1, !1, hR.List(hR.Int64)), e
    }, pR.RecoverPeer.prototype._writeTo = function (t) {
        t.writeList(0, this.peers), t.writeList(1, this.unitSeqIds)
    }, pR.RecoverPeer.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.RecoverPeer.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.RecoverPeer.prototype.toObject = function () {
        var t = {};
        return t.peers = this.peers.toObject(), t.unitSeqIds = this.unitSeqIds.toObject(), t
    }, pR.RecoverPeer.prototype.readFromObject = function (t) {
        t.hasOwnProperty("peers") && this.peers.readFromObject(t.peers), t.hasOwnProperty("unitSeqIds") && this.unitSeqIds.readFromObject(t.unitSeqIds)
    }, pR.RecoverPeer.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.RecoverPeer.new = function () {
        return new pR.RecoverPeer
    }, pR.RecoverPeer.create = function (t) {
        return pR.RecoverPeer._readFrom(t)
    }, pR.RecoverPeerRespData = function () {
        this.fail = new hR.List(pR.UserRespFail), this._classname = "ChatV2Pro.RecoverPeerRespData"
    }, pR.RecoverPeerRespData._classname = "ChatV2Pro.RecoverPeerRespData", pR.RecoverPeerRespData._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.RecoverPeerRespData._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.RecoverPeerRespData._readFrom = function (t) {
        var e = new pR.RecoverPeerRespData;
        return e.fail = t.readList(0, !0, hR.List(pR.UserRespFail)), e
    }, pR.RecoverPeerRespData.prototype._writeTo = function (t) {
        t.writeList(0, this.fail)
    }, pR.RecoverPeerRespData.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.RecoverPeerRespData.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.RecoverPeerRespData.prototype.toObject = function () {
        var t = {};
        return t.fail = this.fail.toObject(), t
    }, pR.RecoverPeerRespData.prototype.readFromObject = function (t) {
        t.hasOwnProperty("fail") && this.fail.readFromObject(t.fail)
    }, pR.RecoverPeerRespData.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.RecoverPeerRespData.new = function () {
        return new pR.RecoverPeerRespData
    }, pR.RecoverPeerRespData.create = function (t) {
        return pR.RecoverPeerRespData._readFrom(t)
    }, pR.RecoverPeerResp = function () {
        this.code = pR.Code.CodeSuccess, this.msg = "", this.data = new pR.RecoverPeerRespData, this._classname = "ChatV2Pro.RecoverPeerResp"
    }, pR.RecoverPeerResp._classname = "ChatV2Pro.RecoverPeerResp", pR.RecoverPeerResp._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.RecoverPeerResp._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.RecoverPeerResp._readFrom = function (t) {
        var e = new pR.RecoverPeerResp;
        return e.code = t.readInt32(0, !0, pR.Code.CodeSuccess), e.msg = t.readString(1, !1, ""), e.data = t.readStruct(2, !1, pR.RecoverPeerRespData), e
    }, pR.RecoverPeerResp.prototype._writeTo = function (t) {
        t.writeInt32(0, this.code), t.writeString(1, this.msg), t.writeStruct(2, this.data)
    }, pR.RecoverPeerResp.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.RecoverPeerResp.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.RecoverPeerResp.prototype.toObject = function () {
        var t = {};
        return t.code = this.code, t.msg = this.msg, t.data = this.data.toObject(), t
    }, pR.RecoverPeerResp.prototype.readFromObject = function (t) {
        t.hasOwnProperty("code") && (this.code = t.code), t.hasOwnProperty("msg") && (this.msg = t.msg), t.hasOwnProperty("data") && this.data.readFromObject(t.data)
    }, pR.RecoverPeerResp.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.RecoverPeerResp.new = function () {
        return new pR.RecoverPeerResp
    }, pR.RecoverPeerResp.create = function (t) {
        return pR.RecoverPeerResp._readFrom(t)
    }, pR.LeaveRoom = function () {
        this.roomIds = new hR.List(hR.String), this._classname = "ChatV2Pro.LeaveRoom"
    }, pR.LeaveRoom._classname = "ChatV2Pro.LeaveRoom", pR.LeaveRoom._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.LeaveRoom._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.LeaveRoom._readFrom = function (t) {
        var e = new pR.LeaveRoom;
        return e.roomIds = t.readList(0, !0, hR.List(hR.String)), e
    }, pR.LeaveRoom.prototype._writeTo = function (t) {
        t.writeList(0, this.roomIds)
    }, pR.LeaveRoom.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.LeaveRoom.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.LeaveRoom.prototype.toObject = function () {
        var t = {};
        return t.roomIds = this.roomIds.toObject(), t
    }, pR.LeaveRoom.prototype.readFromObject = function (t) {
        t.hasOwnProperty("roomIds") && this.roomIds.readFromObject(t.roomIds)
    }, pR.LeaveRoom.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.LeaveRoom.new = function () {
        return new pR.LeaveRoom
    }, pR.LeaveRoom.create = function (t) {
        return pR.LeaveRoom._readFrom(t)
    }, pR.LeaveRoomResp = function () {
        this.code = pR.Code.CodeSuccess, this.msg = "", this._classname = "ChatV2Pro.LeaveRoomResp"
    }, pR.LeaveRoomResp._classname = "ChatV2Pro.LeaveRoomResp", pR.LeaveRoomResp._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.LeaveRoomResp._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.LeaveRoomResp._readFrom = function (t) {
        var e = new pR.LeaveRoomResp;
        return e.code = t.readInt32(0, !0, pR.Code.CodeSuccess), e.msg = t.readString(1, !1, ""), e
    }, pR.LeaveRoomResp.prototype._writeTo = function (t) {
        t.writeInt32(0, this.code), t.writeString(1, this.msg)
    }, pR.LeaveRoomResp.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.LeaveRoomResp.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.LeaveRoomResp.prototype.toObject = function () {
        var t = {};
        return t.code = this.code, t.msg = this.msg, t
    }, pR.LeaveRoomResp.prototype.readFromObject = function (t) {
        t.hasOwnProperty("code") && (this.code = t.code), t.hasOwnProperty("msg") && (this.msg = t.msg)
    }, pR.LeaveRoomResp.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.LeaveRoomResp.new = function () {
        return new pR.LeaveRoomResp
    }, pR.LeaveRoomResp.create = function (t) {
        return pR.LeaveRoomResp._readFrom(t)
    }, pR.LeaveRoomNotice = function () {
        this.roomId = "", this.user = new pR.User, this._classname = "ChatV2Pro.LeaveRoomNotice"
    }, pR.LeaveRoomNotice._classname = "ChatV2Pro.LeaveRoomNotice", pR.LeaveRoomNotice._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.LeaveRoomNotice._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.LeaveRoomNotice._readFrom = function (t) {
        var e = new pR.LeaveRoomNotice;
        return e.roomId = t.readString(0, !0, ""), e.user = t.readStruct(1, !0, pR.User), e
    }, pR.LeaveRoomNotice.prototype._writeTo = function (t) {
        t.writeString(0, this.roomId), t.writeStruct(1, this.user)
    }, pR.LeaveRoomNotice.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.LeaveRoomNotice.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.LeaveRoomNotice.prototype.toObject = function () {
        var t = {};
        return t.roomId = this.roomId, t.user = this.user.toObject(), t
    }, pR.LeaveRoomNotice.prototype.readFromObject = function (t) {
        t.hasOwnProperty("roomId") && (this.roomId = t.roomId), t.hasOwnProperty("user") && this.user.readFromObject(t.user)
    }, pR.LeaveRoomNotice.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.LeaveRoomNotice.new = function () {
        return new pR.LeaveRoomNotice
    }, pR.LeaveRoomNotice.create = function (t) {
        return pR.LeaveRoomNotice._readFrom(t)
    }, pR.SendRoomMessage = function () {
        this.priority = pR.MessagePriority.MessagePriorityTopic, this.roomIds = new hR.List(hR.String), this.content = "", this.seqId = 0, this.sendTime = 0, this._classname = "ChatV2Pro.SendRoomMessage"
    }, pR.SendRoomMessage._classname = "ChatV2Pro.SendRoomMessage", pR.SendRoomMessage._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.SendRoomMessage._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.SendRoomMessage._readFrom = function (t) {
        var e = new pR.SendRoomMessage;
        return e.priority = t.readInt32(0, !0, pR.MessagePriority.MessagePriorityTopic), e.roomIds = t.readList(1, !0, hR.List(hR.String)), e.content = t.readString(2, !0, ""), e.seqId = t.readInt64(3, !1, 0), e.sendTime = t.readInt64(4, !1, 0), e
    }, pR.SendRoomMessage.prototype._writeTo = function (t) {
        t.writeInt32(0, this.priority), t.writeList(1, this.roomIds), t.writeString(2, this.content), t.writeInt64(3, this.seqId), t.writeInt64(4, this.sendTime)
    }, pR.SendRoomMessage.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.SendRoomMessage.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.SendRoomMessage.prototype.toObject = function () {
        var t = {};
        return t.priority = this.priority, t.roomIds = this.roomIds.toObject(), t.content = this.content, t.seqId = this.seqId, t.sendTime = this.sendTime, t
    }, pR.SendRoomMessage.prototype.readFromObject = function (t) {
        t.hasOwnProperty("priority") && (this.priority = t.priority), t.hasOwnProperty("roomIds") && this.roomIds.readFromObject(t.roomIds), t.hasOwnProperty("content") && (this.content = t.content), t.hasOwnProperty("seqId") && (this.seqId = t.seqId), t.hasOwnProperty("sendTime") && (this.sendTime = t.sendTime)
    }, pR.SendRoomMessage.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.SendRoomMessage.new = function () {
        return new pR.SendRoomMessage
    }, pR.SendRoomMessage.create = function (t) {
        return pR.SendRoomMessage._readFrom(t)
    }, pR.SendRoomMessageRespData = function () {
        this.msgId = 0, this.timestamp = 0, this.fail = new hR.List(pR.RoomRespFail), this.msgIdStr = "", this._classname = "ChatV2Pro.SendRoomMessageRespData"
    }, pR.SendRoomMessageRespData._classname = "ChatV2Pro.SendRoomMessageRespData", pR.SendRoomMessageRespData._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.SendRoomMessageRespData._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.SendRoomMessageRespData._readFrom = function (t) {
        var e = new pR.SendRoomMessageRespData;
        return e.msgId = t.readInt64(0, !0, 0), e.timestamp = t.readInt64(1, !0, 0), e.fail = t.readList(2, !1, hR.List(pR.RoomRespFail)), e.msgIdStr = t.readString(3, !1, ""), e
    }, pR.SendRoomMessageRespData.prototype._writeTo = function (t) {
        t.writeInt64(0, this.msgId), t.writeInt64(1, this.timestamp), t.writeList(2, this.fail), t.writeString(3, this.msgIdStr)
    }, pR.SendRoomMessageRespData.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.SendRoomMessageRespData.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.SendRoomMessageRespData.prototype.toObject = function () {
        var t = {};
        return t.msgId = this.msgId, t.timestamp = this.timestamp, t.fail = this.fail.toObject(), t.msgIdStr = this.msgIdStr, t
    }, pR.SendRoomMessageRespData.prototype.readFromObject = function (t) {
        t.hasOwnProperty("msgId") && (this.msgId = t.msgId), t.hasOwnProperty("timestamp") && (this.timestamp = t.timestamp), t.hasOwnProperty("fail") && this.fail.readFromObject(t.fail), t.hasOwnProperty("msgIdStr") && (this.msgIdStr = t.msgIdStr)
    }, pR.SendRoomMessageRespData.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.SendRoomMessageRespData.new = function () {
        return new pR.SendRoomMessageRespData
    }, pR.SendRoomMessageRespData.create = function (t) {
        return pR.SendRoomMessageRespData._readFrom(t)
    }, pR.SendRoomMessageResp = function () {
        this.code = pR.Code.CodeSuccess, this.msg = "", this.data = new pR.SendRoomMessageRespData, this._classname = "ChatV2Pro.SendRoomMessageResp"
    }, pR.SendRoomMessageResp._classname = "ChatV2Pro.SendRoomMessageResp", pR.SendRoomMessageResp._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.SendRoomMessageResp._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.SendRoomMessageResp._readFrom = function (t) {
        var e = new pR.SendRoomMessageResp;
        return e.code = t.readInt32(0, !0, pR.Code.CodeSuccess), e.msg = t.readString(1, !1, ""), e.data = t.readStruct(2, !1, pR.SendRoomMessageRespData), e
    }, pR.SendRoomMessageResp.prototype._writeTo = function (t) {
        t.writeInt32(0, this.code), t.writeString(1, this.msg), t.writeStruct(2, this.data)
    }, pR.SendRoomMessageResp.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.SendRoomMessageResp.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.SendRoomMessageResp.prototype.toObject = function () {
        var t = {};
        return t.code = this.code, t.msg = this.msg, t.data = this.data.toObject(), t
    }, pR.SendRoomMessageResp.prototype.readFromObject = function (t) {
        t.hasOwnProperty("code") && (this.code = t.code), t.hasOwnProperty("msg") && (this.msg = t.msg), t.hasOwnProperty("data") && this.data.readFromObject(t.data)
    }, pR.SendRoomMessageResp.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.SendRoomMessageResp.new = function () {
        return new pR.SendRoomMessageResp
    }, pR.SendRoomMessageResp.create = function (t) {
        return pR.SendRoomMessageResp._readFrom(t)
    }, pR.RecvRoomMessage = function () {
        this.priority = pR.MessagePriority.MessagePriorityTopic, this.msgId = 0, this.timestamp = 0, this.roomId = "", this.from = new pR.User, this.content = "", this.msgIdStr = "", this.unitSeqId = 0, this.unitPrevSeqId = 0, this.needAck = !0, this.sendTime = 0, this._classname = "ChatV2Pro.RecvRoomMessage"
    }, pR.RecvRoomMessage._classname = "ChatV2Pro.RecvRoomMessage", pR.RecvRoomMessage._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.RecvRoomMessage._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.RecvRoomMessage._readFrom = function (t) {
        var e = new pR.RecvRoomMessage;
        return e.priority = t.readInt32(0, !0, pR.MessagePriority.MessagePriorityTopic), e.msgId = t.readInt64(1, !0, 0), e.timestamp = t.readInt64(2, !0, 0), e.roomId = t.readString(3, !0, ""), e.from = t.readStruct(4, !0, pR.User), e.content = t.readString(5, !0, ""), e.msgIdStr = t.readString(6, !1, ""), e.unitSeqId = t.readInt64(7, !1, 0), e.unitPrevSeqId = t.readInt64(8, !1, 0), e.needAck = t.readBoolean(9, !1, !0), e.sendTime = t.readInt64(10, !1, 0), e
    }, pR.RecvRoomMessage.prototype._writeTo = function (t) {
        t.writeInt32(0, this.priority), t.writeInt64(1, this.msgId), t.writeInt64(2, this.timestamp), t.writeString(3, this.roomId), t.writeStruct(4, this.from), t.writeString(5, this.content), t.writeString(6, this.msgIdStr), t.writeInt64(7, this.unitSeqId), t.writeInt64(8, this.unitPrevSeqId), t.writeBoolean(9, this.needAck), t.writeInt64(10, this.sendTime)
    }, pR.RecvRoomMessage.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.RecvRoomMessage.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.RecvRoomMessage.prototype.toObject = function () {
        var t = {};
        return t.priority = this.priority, t.msgId = this.msgId, t.timestamp = this.timestamp, t.roomId = this.roomId, t.from = this.from.toObject(), t.content = this.content, t.msgIdStr = this.msgIdStr, t.unitSeqId = this.unitSeqId, t.unitPrevSeqId = this.unitPrevSeqId, t.needAck = this.needAck, t.sendTime = this.sendTime, t
    }, pR.RecvRoomMessage.prototype.readFromObject = function (t) {
        t.hasOwnProperty("priority") && (this.priority = t.priority), t.hasOwnProperty("msgId") && (this.msgId = t.msgId), t.hasOwnProperty("timestamp") && (this.timestamp = t.timestamp), t.hasOwnProperty("roomId") && (this.roomId = t.roomId), t.hasOwnProperty("from") && this.from.readFromObject(t.from), t.hasOwnProperty("content") && (this.content = t.content), t.hasOwnProperty("msgIdStr") && (this.msgIdStr = t.msgIdStr), t.hasOwnProperty("unitSeqId") && (this.unitSeqId = t.unitSeqId), t.hasOwnProperty("unitPrevSeqId") && (this.unitPrevSeqId = t.unitPrevSeqId), t.hasOwnProperty("needAck") && (this.needAck = t.needAck), t.hasOwnProperty("sendTime") && (this.sendTime = t.sendTime)
    }, pR.RecvRoomMessage.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.RecvRoomMessage.new = function () {
        return new pR.RecvRoomMessage
    }, pR.RecvRoomMessage.create = function (t) {
        return pR.RecvRoomMessage._readFrom(t)
    }, pR.RecvRoomMessageResp = function () {
        this.msgId = 0, this.msgIdStr = "", this.unitSeqId = 0, this.unitPrevSeqId = 0, this._classname = "ChatV2Pro.RecvRoomMessageResp"
    }, pR.RecvRoomMessageResp._classname = "ChatV2Pro.RecvRoomMessageResp", pR.RecvRoomMessageResp._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.RecvRoomMessageResp._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.RecvRoomMessageResp._readFrom = function (t) {
        var e = new pR.RecvRoomMessageResp;
        return e.msgId = t.readInt64(0, !0, 0), e.msgIdStr = t.readString(1, !1, ""), e.unitSeqId = t.readInt64(2, !1, 0), e.unitPrevSeqId = t.readInt64(3, !1, 0), e
    }, pR.RecvRoomMessageResp.prototype._writeTo = function (t) {
        t.writeInt64(0, this.msgId), t.writeString(1, this.msgIdStr), t.writeInt64(2, this.unitSeqId), t.writeInt64(3, this.unitPrevSeqId)
    }, pR.RecvRoomMessageResp.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.RecvRoomMessageResp.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.RecvRoomMessageResp.prototype.toObject = function () {
        var t = {};
        return t.msgId = this.msgId, t.msgIdStr = this.msgIdStr, t.unitSeqId = this.unitSeqId, t.unitPrevSeqId = this.unitPrevSeqId, t
    }, pR.RecvRoomMessageResp.prototype.readFromObject = function (t) {
        t.hasOwnProperty("msgId") && (this.msgId = t.msgId), t.hasOwnProperty("msgIdStr") && (this.msgIdStr = t.msgIdStr), t.hasOwnProperty("unitSeqId") && (this.unitSeqId = t.unitSeqId), t.hasOwnProperty("unitPrevSeqId") && (this.unitPrevSeqId = t.unitPrevSeqId)
    }, pR.RecvRoomMessageResp.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.RecvRoomMessageResp.new = function () {
        return new pR.RecvRoomMessageResp
    }, pR.RecvRoomMessageResp.create = function (t) {
        return pR.RecvRoomMessageResp._readFrom(t)
    }, pR.SendPeerMessage = function () {
        this.priority = pR.MessagePriority.MessagePriorityTopic, this.to = new hR.List(pR.User), this.content = "", this.seqId = 0, this.sendTime = 0, this._classname = "ChatV2Pro.SendPeerMessage"
    }, pR.SendPeerMessage._classname = "ChatV2Pro.SendPeerMessage", pR.SendPeerMessage._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.SendPeerMessage._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.SendPeerMessage._readFrom = function (t) {
        var e = new pR.SendPeerMessage;
        return e.priority = t.readInt32(0, !0, pR.MessagePriority.MessagePriorityTopic), e.to = t.readList(1, !0, hR.List(pR.User)), e.content = t.readString(2, !0, ""), e.seqId = t.readInt64(3, !1, 0), e.sendTime = t.readInt64(4, !1, 0), e
    }, pR.SendPeerMessage.prototype._writeTo = function (t) {
        t.writeInt32(0, this.priority), t.writeList(1, this.to), t.writeString(2, this.content), t.writeInt64(3, this.seqId), t.writeInt64(4, this.sendTime)
    }, pR.SendPeerMessage.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.SendPeerMessage.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.SendPeerMessage.prototype.toObject = function () {
        var t = {};
        return t.priority = this.priority, t.to = this.to.toObject(), t.content = this.content, t.seqId = this.seqId, t.sendTime = this.sendTime, t
    }, pR.SendPeerMessage.prototype.readFromObject = function (t) {
        t.hasOwnProperty("priority") && (this.priority = t.priority), t.hasOwnProperty("to") && this.to.readFromObject(t.to), t.hasOwnProperty("content") && (this.content = t.content), t.hasOwnProperty("seqId") && (this.seqId = t.seqId), t.hasOwnProperty("sendTime") && (this.sendTime = t.sendTime)
    }, pR.SendPeerMessage.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.SendPeerMessage.new = function () {
        return new pR.SendPeerMessage
    }, pR.SendPeerMessage.create = function (t) {
        return pR.SendPeerMessage._readFrom(t)
    }, pR.SendPeerMessageRespData = function () {
        this.msgId = 0, this.timestamp = 0, this.fail = new hR.List(pR.UserRespFail), this.msgIdStr = "", this._classname = "ChatV2Pro.SendPeerMessageRespData"
    }, pR.SendPeerMessageRespData._classname = "ChatV2Pro.SendPeerMessageRespData", pR.SendPeerMessageRespData._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.SendPeerMessageRespData._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.SendPeerMessageRespData._readFrom = function (t) {
        var e = new pR.SendPeerMessageRespData;
        return e.msgId = t.readInt64(0, !0, 0), e.timestamp = t.readInt64(1, !0, 0), e.fail = t.readList(2, !1, hR.List(pR.UserRespFail)), e.msgIdStr = t.readString(3, !1, ""), e
    }, pR.SendPeerMessageRespData.prototype._writeTo = function (t) {
        t.writeInt64(0, this.msgId), t.writeInt64(1, this.timestamp), t.writeList(2, this.fail), t.writeString(3, this.msgIdStr)
    }, pR.SendPeerMessageRespData.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.SendPeerMessageRespData.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.SendPeerMessageRespData.prototype.toObject = function () {
        var t = {};
        return t.msgId = this.msgId, t.timestamp = this.timestamp, t.fail = this.fail.toObject(), t.msgIdStr = this.msgIdStr, t
    }, pR.SendPeerMessageRespData.prototype.readFromObject = function (t) {
        t.hasOwnProperty("msgId") && (this.msgId = t.msgId), t.hasOwnProperty("timestamp") && (this.timestamp = t.timestamp), t.hasOwnProperty("fail") && this.fail.readFromObject(t.fail), t.hasOwnProperty("msgIdStr") && (this.msgIdStr = t.msgIdStr)
    }, pR.SendPeerMessageRespData.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.SendPeerMessageRespData.new = function () {
        return new pR.SendPeerMessageRespData
    }, pR.SendPeerMessageRespData.create = function (t) {
        return pR.SendPeerMessageRespData._readFrom(t)
    }, pR.SendPeerMessageResp = function () {
        this.code = pR.Code.CodeSuccess, this.msg = "", this.data = new pR.SendPeerMessageRespData, this._classname = "ChatV2Pro.SendPeerMessageResp"
    }, pR.SendPeerMessageResp._classname = "ChatV2Pro.SendPeerMessageResp", pR.SendPeerMessageResp._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.SendPeerMessageResp._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.SendPeerMessageResp._readFrom = function (t) {
        var e = new pR.SendPeerMessageResp;
        return e.code = t.readInt32(0, !0, pR.Code.CodeSuccess), e.msg = t.readString(1, !1, ""), e.data = t.readStruct(2, !1, pR.SendPeerMessageRespData), e
    }, pR.SendPeerMessageResp.prototype._writeTo = function (t) {
        t.writeInt32(0, this.code), t.writeString(1, this.msg), t.writeStruct(2, this.data)
    }, pR.SendPeerMessageResp.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.SendPeerMessageResp.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.SendPeerMessageResp.prototype.toObject = function () {
        var t = {};
        return t.code = this.code, t.msg = this.msg, t.data = this.data.toObject(), t
    }, pR.SendPeerMessageResp.prototype.readFromObject = function (t) {
        t.hasOwnProperty("code") && (this.code = t.code), t.hasOwnProperty("msg") && (this.msg = t.msg), t.hasOwnProperty("data") && this.data.readFromObject(t.data)
    }, pR.SendPeerMessageResp.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.SendPeerMessageResp.new = function () {
        return new pR.SendPeerMessageResp
    }, pR.SendPeerMessageResp.create = function (t) {
        return pR.SendPeerMessageResp._readFrom(t)
    }, pR.RecvPeerMessage = function () {
        this.priority = pR.MessagePriority.MessagePriorityTopic, this.msgId = 0, this.timestamp = 0, this.from = new pR.User, this.content = "", this.msgIdStr = "", this.unitSeqId = 0, this.unitPrevSeqId = 0, this.needAck = !0, this.sendTime = 0, this._classname = "ChatV2Pro.RecvPeerMessage"
    }, pR.RecvPeerMessage._classname = "ChatV2Pro.RecvPeerMessage", pR.RecvPeerMessage._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.RecvPeerMessage._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.RecvPeerMessage._readFrom = function (t) {
        var e = new pR.RecvPeerMessage;
        return e.priority = t.readInt32(0, !0, pR.MessagePriority.MessagePriorityTopic), e.msgId = t.readInt64(1, !0, 0), e.timestamp = t.readInt64(2, !0, 0), e.from = t.readStruct(3, !0, pR.User), e.content = t.readString(4, !0, ""), e.msgIdStr = t.readString(5, !1, ""), e.unitSeqId = t.readInt64(6, !1, 0), e.unitPrevSeqId = t.readInt64(7, !1, 0), e.needAck = t.readBoolean(8, !1, !0), e.sendTime = t.readInt64(9, !1, 0), e
    }, pR.RecvPeerMessage.prototype._writeTo = function (t) {
        t.writeInt32(0, this.priority), t.writeInt64(1, this.msgId), t.writeInt64(2, this.timestamp), t.writeStruct(3, this.from), t.writeString(4, this.content), t.writeString(5, this.msgIdStr), t.writeInt64(6, this.unitSeqId), t.writeInt64(7, this.unitPrevSeqId), t.writeBoolean(8, this.needAck), t.writeInt64(9, this.sendTime)
    }, pR.RecvPeerMessage.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.RecvPeerMessage.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.RecvPeerMessage.prototype.toObject = function () {
        var t = {};
        return t.priority = this.priority, t.msgId = this.msgId, t.timestamp = this.timestamp, t.from = this.from.toObject(), t.content = this.content, t.msgIdStr = this.msgIdStr, t.unitSeqId = this.unitSeqId, t.unitPrevSeqId = this.unitPrevSeqId, t.needAck = this.needAck, t.sendTime = this.sendTime, t
    }, pR.RecvPeerMessage.prototype.readFromObject = function (t) {
        t.hasOwnProperty("priority") && (this.priority = t.priority), t.hasOwnProperty("msgId") && (this.msgId = t.msgId), t.hasOwnProperty("timestamp") && (this.timestamp = t.timestamp), t.hasOwnProperty("from") && this.from.readFromObject(t.from), t.hasOwnProperty("content") && (this.content = t.content), t.hasOwnProperty("msgIdStr") && (this.msgIdStr = t.msgIdStr), t.hasOwnProperty("unitSeqId") && (this.unitSeqId = t.unitSeqId), t.hasOwnProperty("unitPrevSeqId") && (this.unitPrevSeqId = t.unitPrevSeqId), t.hasOwnProperty("needAck") && (this.needAck = t.needAck), t.hasOwnProperty("sendTime") && (this.sendTime = t.sendTime)
    }, pR.RecvPeerMessage.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.RecvPeerMessage.new = function () {
        return new pR.RecvPeerMessage
    }, pR.RecvPeerMessage.create = function (t) {
        return pR.RecvPeerMessage._readFrom(t)
    }, pR.RecvPeerMessageResp = function () {
        this.msgId = 0, this.msgIdStr = "", this.unitSeqId = 0, this.unitPrevSeqId = 0, this._classname = "ChatV2Pro.RecvPeerMessageResp"
    }, pR.RecvPeerMessageResp._classname = "ChatV2Pro.RecvPeerMessageResp", pR.RecvPeerMessageResp._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.RecvPeerMessageResp._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.RecvPeerMessageResp._readFrom = function (t) {
        var e = new pR.RecvPeerMessageResp;
        return e.msgId = t.readInt64(0, !0, 0), e.msgIdStr = t.readString(1, !1, ""), e.unitSeqId = t.readInt64(2, !1, 0), e.unitPrevSeqId = t.readInt64(3, !1, 0), e
    }, pR.RecvPeerMessageResp.prototype._writeTo = function (t) {
        t.writeInt64(0, this.msgId), t.writeString(1, this.msgIdStr), t.writeInt64(2, this.unitSeqId), t.writeInt64(3, this.unitPrevSeqId)
    }, pR.RecvPeerMessageResp.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.RecvPeerMessageResp.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.RecvPeerMessageResp.prototype.toObject = function () {
        var t = {};
        return t.msgId = this.msgId, t.msgIdStr = this.msgIdStr, t.unitSeqId = this.unitSeqId, t.unitPrevSeqId = this.unitPrevSeqId, t
    }, pR.RecvPeerMessageResp.prototype.readFromObject = function (t) {
        t.hasOwnProperty("msgId") && (this.msgId = t.msgId), t.hasOwnProperty("msgIdStr") && (this.msgIdStr = t.msgIdStr), t.hasOwnProperty("unitSeqId") && (this.unitSeqId = t.unitSeqId), t.hasOwnProperty("unitPrevSeqId") && (this.unitPrevSeqId = t.unitPrevSeqId)
    }, pR.RecvPeerMessageResp.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.RecvPeerMessageResp.new = function () {
        return new pR.RecvPeerMessageResp
    }, pR.RecvPeerMessageResp.create = function (t) {
        return pR.RecvPeerMessageResp._readFrom(t)
    }, pR.GetRoomHistoryMessage = function () {
        this.roomId = "", this.tsOffset = 0, this._classname = "ChatV2Pro.GetRoomHistoryMessage"
    }, pR.GetRoomHistoryMessage._classname = "ChatV2Pro.GetRoomHistoryMessage", pR.GetRoomHistoryMessage._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.GetRoomHistoryMessage._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.GetRoomHistoryMessage._readFrom = function (t) {
        var e = new pR.GetRoomHistoryMessage;
        return e.roomId = t.readString(0, !0, ""), e.tsOffset = t.readInt64(1, !1, 0), e
    }, pR.GetRoomHistoryMessage.prototype._writeTo = function (t) {
        t.writeString(0, this.roomId), t.writeInt64(1, this.tsOffset)
    }, pR.GetRoomHistoryMessage.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.GetRoomHistoryMessage.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.GetRoomHistoryMessage.prototype.toObject = function () {
        var t = {};
        return t.roomId = this.roomId, t.tsOffset = this.tsOffset, t
    }, pR.GetRoomHistoryMessage.prototype.readFromObject = function (t) {
        t.hasOwnProperty("roomId") && (this.roomId = t.roomId), t.hasOwnProperty("tsOffset") && (this.tsOffset = t.tsOffset)
    }, pR.GetRoomHistoryMessage.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.GetRoomHistoryMessage.new = function () {
        return new pR.GetRoomHistoryMessage
    }, pR.GetRoomHistoryMessage.create = function (t) {
        return pR.GetRoomHistoryMessage._readFrom(t)
    }, pR.GetRoomHistoryMessageRespData = function () {
        this.content = new hR.List(hR.String), this._classname = "ChatV2Pro.GetRoomHistoryMessageRespData"
    }, pR.GetRoomHistoryMessageRespData._classname = "ChatV2Pro.GetRoomHistoryMessageRespData", pR.GetRoomHistoryMessageRespData._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.GetRoomHistoryMessageRespData._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.GetRoomHistoryMessageRespData._readFrom = function (t) {
        var e = new pR.GetRoomHistoryMessageRespData;
        return e.content = t.readList(0, !0, hR.List(hR.String)), e
    }, pR.GetRoomHistoryMessageRespData.prototype._writeTo = function (t) {
        t.writeList(0, this.content)
    }, pR.GetRoomHistoryMessageRespData.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.GetRoomHistoryMessageRespData.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.GetRoomHistoryMessageRespData.prototype.toObject = function () {
        var t = {};
        return t.content = this.content.toObject(), t
    }, pR.GetRoomHistoryMessageRespData.prototype.readFromObject = function (t) {
        t.hasOwnProperty("content") && this.content.readFromObject(t.content)
    }, pR.GetRoomHistoryMessageRespData.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.GetRoomHistoryMessageRespData.new = function () {
        return new pR.GetRoomHistoryMessageRespData
    }, pR.GetRoomHistoryMessageRespData.create = function (t) {
        return pR.GetRoomHistoryMessageRespData._readFrom(t)
    }, pR.GetRoomHistoryMessageResp = function () {
        this.code = pR.Code.CodeSuccess, this.msg = "", this.data = new pR.GetRoomHistoryMessageRespData, this._classname = "ChatV2Pro.GetRoomHistoryMessageResp"
    }, pR.GetRoomHistoryMessageResp._classname = "ChatV2Pro.GetRoomHistoryMessageResp", pR.GetRoomHistoryMessageResp._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.GetRoomHistoryMessageResp._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.GetRoomHistoryMessageResp._readFrom = function (t) {
        var e = new pR.GetRoomHistoryMessageResp;
        return e.code = t.readInt32(0, !0, pR.Code.CodeSuccess), e.msg = t.readString(1, !1, ""), e.data = t.readStruct(2, !0, pR.GetRoomHistoryMessageRespData), e
    }, pR.GetRoomHistoryMessageResp.prototype._writeTo = function (t) {
        t.writeInt32(0, this.code), t.writeString(1, this.msg), t.writeStruct(2, this.data)
    }, pR.GetRoomHistoryMessageResp.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.GetRoomHistoryMessageResp.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.GetRoomHistoryMessageResp.prototype.toObject = function () {
        var t = {};
        return t.code = this.code, t.msg = this.msg, t.data = this.data.toObject(), t
    }, pR.GetRoomHistoryMessageResp.prototype.readFromObject = function (t) {
        t.hasOwnProperty("code") && (this.code = t.code), t.hasOwnProperty("msg") && (this.msg = t.msg), t.hasOwnProperty("data") && this.data.readFromObject(t.data)
    }, pR.GetRoomHistoryMessageResp.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.GetRoomHistoryMessageResp.new = function () {
        return new pR.GetRoomHistoryMessageResp
    }, pR.GetRoomHistoryMessageResp.create = function (t) {
        return pR.GetRoomHistoryMessageResp._readFrom(t)
    }, pR.RecoverRoomMessageNotice = function () {
        this.roomId = "", this.finish = !0, this.messages = new hR.List(pR.RecvRoomMessage), this._classname = "ChatV2Pro.RecoverRoomMessageNotice"
    }, pR.RecoverRoomMessageNotice._classname = "ChatV2Pro.RecoverRoomMessageNotice", pR.RecoverRoomMessageNotice._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.RecoverRoomMessageNotice._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.RecoverRoomMessageNotice._readFrom = function (t) {
        var e = new pR.RecoverRoomMessageNotice;
        return e.roomId = t.readString(0, !0, ""), e.finish = t.readBoolean(1, !0, !0), e.messages = t.readList(2, !1, hR.List(pR.RecvRoomMessage)), e
    }, pR.RecoverRoomMessageNotice.prototype._writeTo = function (t) {
        t.writeString(0, this.roomId), t.writeBoolean(1, this.finish), t.writeList(2, this.messages)
    }, pR.RecoverRoomMessageNotice.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.RecoverRoomMessageNotice.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.RecoverRoomMessageNotice.prototype.toObject = function () {
        var t = {};
        return t.roomId = this.roomId, t.finish = this.finish, t.messages = this.messages.toObject(), t
    }, pR.RecoverRoomMessageNotice.prototype.readFromObject = function (t) {
        t.hasOwnProperty("roomId") && (this.roomId = t.roomId), t.hasOwnProperty("finish") && (this.finish = t.finish), t.hasOwnProperty("messages") && this.messages.readFromObject(t.messages)
    }, pR.RecoverRoomMessageNotice.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.RecoverRoomMessageNotice.new = function () {
        return new pR.RecoverRoomMessageNotice
    }, pR.RecoverRoomMessageNotice.create = function (t) {
        return pR.RecoverRoomMessageNotice._readFrom(t)
    }, pR.RecoverPeerMessageNotice = function () {
        this.peer = new pR.User, this.finish = !0, this.messages = new hR.List(pR.RecvPeerMessage), this._classname = "ChatV2Pro.RecoverPeerMessageNotice"
    }, pR.RecoverPeerMessageNotice._classname = "ChatV2Pro.RecoverPeerMessageNotice", pR.RecoverPeerMessageNotice._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.RecoverPeerMessageNotice._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.RecoverPeerMessageNotice._readFrom = function (t) {
        var e = new pR.RecoverPeerMessageNotice;
        return e.peer = t.readStruct(0, !0, pR.User), e.finish = t.readBoolean(1, !0, !0), e.messages = t.readList(2, !1, hR.List(pR.RecvPeerMessage)), e
    }, pR.RecoverPeerMessageNotice.prototype._writeTo = function (t) {
        t.writeStruct(0, this.peer), t.writeBoolean(1, this.finish), t.writeList(2, this.messages)
    }, pR.RecoverPeerMessageNotice.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.RecoverPeerMessageNotice.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.RecoverPeerMessageNotice.prototype.toObject = function () {
        var t = {};
        return t.peer = this.peer.toObject(), t.finish = this.finish, t.messages = this.messages.toObject(), t
    }, pR.RecoverPeerMessageNotice.prototype.readFromObject = function (t) {
        t.hasOwnProperty("peer") && this.peer.readFromObject(t.peer), t.hasOwnProperty("finish") && (this.finish = t.finish), t.hasOwnProperty("messages") && this.messages.readFromObject(t.messages)
    }, pR.RecoverPeerMessageNotice.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.RecoverPeerMessageNotice.new = function () {
        return new pR.RecoverPeerMessageNotice
    }, pR.RecoverPeerMessageNotice.create = function (t) {
        return pR.RecoverPeerMessageNotice._readFrom(t)
    }, pR.GetRoomMissingMessage = function () {
        this.roomId = "", this.seqIdBegin = 0, this.seqIdEnd = 0, this._classname = "ChatV2Pro.GetRoomMissingMessage"
    }, pR.GetRoomMissingMessage._classname = "ChatV2Pro.GetRoomMissingMessage", pR.GetRoomMissingMessage._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.GetRoomMissingMessage._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.GetRoomMissingMessage._readFrom = function (t) {
        var e = new pR.GetRoomMissingMessage;
        return e.roomId = t.readString(0, !0, ""), e.seqIdBegin = t.readInt64(1, !0, 0), e.seqIdEnd = t.readInt64(2, !0, 0), e
    }, pR.GetRoomMissingMessage.prototype._writeTo = function (t) {
        t.writeString(0, this.roomId), t.writeInt64(1, this.seqIdBegin), t.writeInt64(2, this.seqIdEnd)
    }, pR.GetRoomMissingMessage.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.GetRoomMissingMessage.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.GetRoomMissingMessage.prototype.toObject = function () {
        var t = {};
        return t.roomId = this.roomId, t.seqIdBegin = this.seqIdBegin, t.seqIdEnd = this.seqIdEnd, t
    }, pR.GetRoomMissingMessage.prototype.readFromObject = function (t) {
        t.hasOwnProperty("roomId") && (this.roomId = t.roomId), t.hasOwnProperty("seqIdBegin") && (this.seqIdBegin = t.seqIdBegin), t.hasOwnProperty("seqIdEnd") && (this.seqIdEnd = t.seqIdEnd)
    }, pR.GetRoomMissingMessage.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.GetRoomMissingMessage.new = function () {
        return new pR.GetRoomMissingMessage
    }, pR.GetRoomMissingMessage.create = function (t) {
        return pR.GetRoomMissingMessage._readFrom(t)
    }, pR.GetRoomMissingMessageResp = function () {
        this.code = pR.Code.CodeSuccess, this.msg = "", this._classname = "ChatV2Pro.GetRoomMissingMessageResp"
    }, pR.GetRoomMissingMessageResp._classname = "ChatV2Pro.GetRoomMissingMessageResp", pR.GetRoomMissingMessageResp._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.GetRoomMissingMessageResp._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.GetRoomMissingMessageResp._readFrom = function (t) {
        var e = new pR.GetRoomMissingMessageResp;
        return e.code = t.readInt32(0, !0, pR.Code.CodeSuccess), e.msg = t.readString(1, !1, ""), e
    }, pR.GetRoomMissingMessageResp.prototype._writeTo = function (t) {
        t.writeInt32(0, this.code), t.writeString(1, this.msg)
    }, pR.GetRoomMissingMessageResp.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.GetRoomMissingMessageResp.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.GetRoomMissingMessageResp.prototype.toObject = function () {
        var t = {};
        return t.code = this.code, t.msg = this.msg, t
    }, pR.GetRoomMissingMessageResp.prototype.readFromObject = function (t) {
        t.hasOwnProperty("code") && (this.code = t.code), t.hasOwnProperty("msg") && (this.msg = t.msg)
    }, pR.GetRoomMissingMessageResp.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.GetRoomMissingMessageResp.new = function () {
        return new pR.GetRoomMissingMessageResp
    }, pR.GetRoomMissingMessageResp.create = function (t) {
        return pR.GetRoomMissingMessageResp._readFrom(t)
    }, pR.GetRoomMissingMessageNotice = function () {
        this.roomId = "", this.finish = !0, this.messages = new hR.List(pR.RecvRoomMessage), this._classname = "ChatV2Pro.GetRoomMissingMessageNotice"
    }, pR.GetRoomMissingMessageNotice._classname = "ChatV2Pro.GetRoomMissingMessageNotice", pR.GetRoomMissingMessageNotice._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.GetRoomMissingMessageNotice._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.GetRoomMissingMessageNotice._readFrom = function (t) {
        var e = new pR.GetRoomMissingMessageNotice;
        return e.roomId = t.readString(0, !0, ""), e.finish = t.readBoolean(1, !0, !0), e.messages = t.readList(2, !1, hR.List(pR.RecvRoomMessage)), e
    }, pR.GetRoomMissingMessageNotice.prototype._writeTo = function (t) {
        t.writeString(0, this.roomId), t.writeBoolean(1, this.finish), t.writeList(2, this.messages)
    }, pR.GetRoomMissingMessageNotice.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.GetRoomMissingMessageNotice.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.GetRoomMissingMessageNotice.prototype.toObject = function () {
        var t = {};
        return t.roomId = this.roomId, t.finish = this.finish, t.messages = this.messages.toObject(), t
    }, pR.GetRoomMissingMessageNotice.prototype.readFromObject = function (t) {
        t.hasOwnProperty("roomId") && (this.roomId = t.roomId), t.hasOwnProperty("finish") && (this.finish = t.finish), t.hasOwnProperty("messages") && this.messages.readFromObject(t.messages)
    }, pR.GetRoomMissingMessageNotice.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.GetRoomMissingMessageNotice.new = function () {
        return new pR.GetRoomMissingMessageNotice
    }, pR.GetRoomMissingMessageNotice.create = function (t) {
        return pR.GetRoomMissingMessageNotice._readFrom(t)
    }, pR.GetPeerMissingMessage = function () {
        this.peer = new pR.User, this.seqIdBegin = 0, this.seqIdEnd = 0, this._classname = "ChatV2Pro.GetPeerMissingMessage"
    }, pR.GetPeerMissingMessage._classname = "ChatV2Pro.GetPeerMissingMessage", pR.GetPeerMissingMessage._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.GetPeerMissingMessage._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.GetPeerMissingMessage._readFrom = function (t) {
        var e = new pR.GetPeerMissingMessage;
        return e.peer = t.readStruct(0, !0, pR.User), e.seqIdBegin = t.readInt64(1, !0, 0), e.seqIdEnd = t.readInt64(2, !0, 0), e
    }, pR.GetPeerMissingMessage.prototype._writeTo = function (t) {
        t.writeStruct(0, this.peer), t.writeInt64(1, this.seqIdBegin), t.writeInt64(2, this.seqIdEnd)
    }, pR.GetPeerMissingMessage.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.GetPeerMissingMessage.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.GetPeerMissingMessage.prototype.toObject = function () {
        var t = {};
        return t.peer = this.peer.toObject(), t.seqIdBegin = this.seqIdBegin, t.seqIdEnd = this.seqIdEnd, t
    }, pR.GetPeerMissingMessage.prototype.readFromObject = function (t) {
        t.hasOwnProperty("peer") && this.peer.readFromObject(t.peer), t.hasOwnProperty("seqIdBegin") && (this.seqIdBegin = t.seqIdBegin), t.hasOwnProperty("seqIdEnd") && (this.seqIdEnd = t.seqIdEnd)
    }, pR.GetPeerMissingMessage.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.GetPeerMissingMessage.new = function () {
        return new pR.GetPeerMissingMessage
    }, pR.GetPeerMissingMessage.create = function (t) {
        return pR.GetPeerMissingMessage._readFrom(t)
    }, pR.GetPeerMissingMessageResp = function () {
        this.code = pR.Code.CodeSuccess, this.msg = "", this._classname = "ChatV2Pro.GetPeerMissingMessageResp"
    }, pR.GetPeerMissingMessageResp._classname = "ChatV2Pro.GetPeerMissingMessageResp", pR.GetPeerMissingMessageResp._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.GetPeerMissingMessageResp._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.GetPeerMissingMessageResp._readFrom = function (t) {
        var e = new pR.GetPeerMissingMessageResp;
        return e.code = t.readInt32(0, !0, pR.Code.CodeSuccess), e.msg = t.readString(1, !1, ""), e
    }, pR.GetPeerMissingMessageResp.prototype._writeTo = function (t) {
        t.writeInt32(0, this.code), t.writeString(1, this.msg)
    }, pR.GetPeerMissingMessageResp.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.GetPeerMissingMessageResp.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.GetPeerMissingMessageResp.prototype.toObject = function () {
        var t = {};
        return t.code = this.code, t.msg = this.msg, t
    }, pR.GetPeerMissingMessageResp.prototype.readFromObject = function (t) {
        t.hasOwnProperty("code") && (this.code = t.code), t.hasOwnProperty("msg") && (this.msg = t.msg)
    }, pR.GetPeerMissingMessageResp.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.GetPeerMissingMessageResp.new = function () {
        return new pR.GetPeerMissingMessageResp
    }, pR.GetPeerMissingMessageResp.create = function (t) {
        return pR.GetPeerMissingMessageResp._readFrom(t)
    }, pR.GetPeerMissingMessageNotice = function () {
        this.peer = new pR.User, this.finish = !0, this.messages = new hR.List(pR.RecvPeerMessage), this._classname = "ChatV2Pro.GetPeerMissingMessageNotice"
    }, pR.GetPeerMissingMessageNotice._classname = "ChatV2Pro.GetPeerMissingMessageNotice", pR.GetPeerMissingMessageNotice._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.GetPeerMissingMessageNotice._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.GetPeerMissingMessageNotice._readFrom = function (t) {
        var e = new pR.GetPeerMissingMessageNotice;
        return e.peer = t.readStruct(0, !0, pR.User), e.finish = t.readBoolean(1, !0, !0), e.messages = t.readList(2, !1, hR.List(pR.RecvPeerMessage)), e
    }, pR.GetPeerMissingMessageNotice.prototype._writeTo = function (t) {
        t.writeStruct(0, this.peer), t.writeBoolean(1, this.finish), t.writeList(2, this.messages)
    }, pR.GetPeerMissingMessageNotice.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.GetPeerMissingMessageNotice.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.GetPeerMissingMessageNotice.prototype.toObject = function () {
        var t = {};
        return t.peer = this.peer.toObject(), t.finish = this.finish, t.messages = this.messages.toObject(), t
    }, pR.GetPeerMissingMessageNotice.prototype.readFromObject = function (t) {
        t.hasOwnProperty("peer") && this.peer.readFromObject(t.peer), t.hasOwnProperty("finish") && (this.finish = t.finish), t.hasOwnProperty("messages") && this.messages.readFromObject(t.messages)
    }, pR.GetPeerMissingMessageNotice.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.GetPeerMissingMessageNotice.new = function () {
        return new pR.GetPeerMissingMessageNotice
    }, pR.GetPeerMissingMessageNotice.create = function (t) {
        return pR.GetPeerMissingMessageNotice._readFrom(t)
    }, pR.MuteRoom = function () {
        this.roomIds = new hR.List(hR.String), this.flag = 0, this._classname = "ChatV2Pro.MuteRoom"
    }, pR.MuteRoom._classname = "ChatV2Pro.MuteRoom", pR.MuteRoom._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.MuteRoom._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.MuteRoom._readFrom = function (t) {
        var e = new pR.MuteRoom;
        return e.roomIds = t.readList(0, !1, hR.List(hR.String)), e.flag = t.readInt32(1, !1, 0), e
    }, pR.MuteRoom.prototype._writeTo = function (t) {
        t.writeList(0, this.roomIds), t.writeInt32(1, this.flag)
    }, pR.MuteRoom.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.MuteRoom.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.MuteRoom.prototype.toObject = function () {
        var t = {};
        return t.roomIds = this.roomIds.toObject(), t.flag = this.flag, t
    }, pR.MuteRoom.prototype.readFromObject = function (t) {
        t.hasOwnProperty("roomIds") && this.roomIds.readFromObject(t.roomIds), t.hasOwnProperty("flag") && (this.flag = t.flag)
    }, pR.MuteRoom.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.MuteRoom.new = function () {
        return new pR.MuteRoom
    }, pR.MuteRoom.create = function (t) {
        return pR.MuteRoom._readFrom(t)
    }, pR.MuteRoomRespData = function () {
        this.fail = new hR.List(pR.RoomRespFail), this._classname = "ChatV2Pro.MuteRoomRespData"
    }, pR.MuteRoomRespData._classname = "ChatV2Pro.MuteRoomRespData", pR.MuteRoomRespData._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.MuteRoomRespData._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.MuteRoomRespData._readFrom = function (t) {
        var e = new pR.MuteRoomRespData;
        return e.fail = t.readList(0, !0, hR.List(pR.RoomRespFail)), e
    }, pR.MuteRoomRespData.prototype._writeTo = function (t) {
        t.writeList(0, this.fail)
    }, pR.MuteRoomRespData.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.MuteRoomRespData.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.MuteRoomRespData.prototype.toObject = function () {
        var t = {};
        return t.fail = this.fail.toObject(), t
    }, pR.MuteRoomRespData.prototype.readFromObject = function (t) {
        t.hasOwnProperty("fail") && this.fail.readFromObject(t.fail)
    }, pR.MuteRoomRespData.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.MuteRoomRespData.new = function () {
        return new pR.MuteRoomRespData
    }, pR.MuteRoomRespData.create = function (t) {
        return pR.MuteRoomRespData._readFrom(t)
    }, pR.MuteRoomResp = function () {
        this.code = pR.Code.CodeSuccess, this.msg = "", this.data = new pR.MuteRoomRespData, this._classname = "ChatV2Pro.MuteRoomResp"
    }, pR.MuteRoomResp._classname = "ChatV2Pro.MuteRoomResp", pR.MuteRoomResp._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.MuteRoomResp._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.MuteRoomResp._readFrom = function (t) {
        var e = new pR.MuteRoomResp;
        return e.code = t.readInt32(0, !1, pR.Code.CodeSuccess), e.msg = t.readString(1, !1, ""), e.data = t.readStruct(2, !0, pR.MuteRoomRespData), e
    }, pR.MuteRoomResp.prototype._writeTo = function (t) {
        t.writeInt32(0, this.code), t.writeString(1, this.msg), t.writeStruct(2, this.data)
    }, pR.MuteRoomResp.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.MuteRoomResp.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.MuteRoomResp.prototype.toObject = function () {
        var t = {};
        return t.code = this.code, t.msg = this.msg, t.data = this.data.toObject(), t
    }, pR.MuteRoomResp.prototype.readFromObject = function (t) {
        t.hasOwnProperty("code") && (this.code = t.code), t.hasOwnProperty("msg") && (this.msg = t.msg), t.hasOwnProperty("data") && this.data.readFromObject(t.data)
    }, pR.MuteRoomResp.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.MuteRoomResp.new = function () {
        return new pR.MuteRoomResp
    }, pR.MuteRoomResp.create = function (t) {
        return pR.MuteRoomResp._readFrom(t)
    }, pR.RoomMuteStatus = function () {
        this.roomIds = new hR.List(hR.String), this._classname = "ChatV2Pro.RoomMuteStatus"
    }, pR.RoomMuteStatus._classname = "ChatV2Pro.RoomMuteStatus", pR.RoomMuteStatus._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.RoomMuteStatus._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.RoomMuteStatus._readFrom = function (t) {
        var e = new pR.RoomMuteStatus;
        return e.roomIds = t.readList(0, !1, hR.List(hR.String)), e
    }, pR.RoomMuteStatus.prototype._writeTo = function (t) {
        t.writeList(0, this.roomIds)
    }, pR.RoomMuteStatus.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.RoomMuteStatus.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.RoomMuteStatus.prototype.toObject = function () {
        var t = {};
        return t.roomIds = this.roomIds.toObject(), t
    }, pR.RoomMuteStatus.prototype.readFromObject = function (t) {
        t.hasOwnProperty("roomIds") && this.roomIds.readFromObject(t.roomIds)
    }, pR.RoomMuteStatus.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.RoomMuteStatus.new = function () {
        return new pR.RoomMuteStatus
    }, pR.RoomMuteStatus.create = function (t) {
        return pR.RoomMuteStatus._readFrom(t)
    }, pR.RoomMuteInfo = function () {
        this.roomId = "", this.flag = 0, this._classname = "ChatV2Pro.RoomMuteInfo"
    }, pR.RoomMuteInfo._classname = "ChatV2Pro.RoomMuteInfo", pR.RoomMuteInfo._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.RoomMuteInfo._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.RoomMuteInfo._readFrom = function (t) {
        var e = new pR.RoomMuteInfo;
        return e.roomId = t.readString(0, !1, ""), e.flag = t.readInt32(1, !1, 0), e
    }, pR.RoomMuteInfo.prototype._writeTo = function (t) {
        t.writeString(0, this.roomId), t.writeInt32(1, this.flag)
    }, pR.RoomMuteInfo.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.RoomMuteInfo.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.RoomMuteInfo.prototype.toObject = function () {
        var t = {};
        return t.roomId = this.roomId, t.flag = this.flag, t
    }, pR.RoomMuteInfo.prototype.readFromObject = function (t) {
        t.hasOwnProperty("roomId") && (this.roomId = t.roomId), t.hasOwnProperty("flag") && (this.flag = t.flag)
    }, pR.RoomMuteInfo.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.RoomMuteInfo.new = function () {
        return new pR.RoomMuteInfo
    }, pR.RoomMuteInfo.create = function (t) {
        return pR.RoomMuteInfo._readFrom(t)
    }, pR.RoomMuteStatusData = function () {
        this.success = new hR.List(pR.RoomMuteInfo), this.fail = new hR.List(pR.RoomRespFail), this._classname = "ChatV2Pro.RoomMuteStatusData"
    }, pR.RoomMuteStatusData._classname = "ChatV2Pro.RoomMuteStatusData", pR.RoomMuteStatusData._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.RoomMuteStatusData._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.RoomMuteStatusData._readFrom = function (t) {
        var e = new pR.RoomMuteStatusData;
        return e.success = t.readList(1, !1, hR.List(pR.RoomMuteInfo)), e.fail = t.readList(2, !0, hR.List(pR.RoomRespFail)), e
    }, pR.RoomMuteStatusData.prototype._writeTo = function (t) {
        t.writeList(1, this.success), t.writeList(2, this.fail)
    }, pR.RoomMuteStatusData.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.RoomMuteStatusData.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.RoomMuteStatusData.prototype.toObject = function () {
        var t = {};
        return t.success = this.success.toObject(), t.fail = this.fail.toObject(), t
    }, pR.RoomMuteStatusData.prototype.readFromObject = function (t) {
        t.hasOwnProperty("success") && this.success.readFromObject(t.success), t.hasOwnProperty("fail") && this.fail.readFromObject(t.fail)
    }, pR.RoomMuteStatusData.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.RoomMuteStatusData.new = function () {
        return new pR.RoomMuteStatusData
    }, pR.RoomMuteStatusData.create = function (t) {
        return pR.RoomMuteStatusData._readFrom(t)
    }, pR.RoomMuteStatusResp = function () {
        this.code = pR.Code.CodeSuccess, this.msg = "", this.data = new pR.RoomMuteStatusData, this._classname = "ChatV2Pro.RoomMuteStatusResp"
    }, pR.RoomMuteStatusResp._classname = "ChatV2Pro.RoomMuteStatusResp", pR.RoomMuteStatusResp._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.RoomMuteStatusResp._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.RoomMuteStatusResp._readFrom = function (t) {
        var e = new pR.RoomMuteStatusResp;
        return e.code = t.readInt32(0, !1, pR.Code.CodeSuccess), e.msg = t.readString(1, !1, ""), e.data = t.readStruct(2, !0, pR.RoomMuteStatusData), e
    }, pR.RoomMuteStatusResp.prototype._writeTo = function (t) {
        t.writeInt32(0, this.code), t.writeString(1, this.msg), t.writeStruct(2, this.data)
    }, pR.RoomMuteStatusResp.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.RoomMuteStatusResp.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.RoomMuteStatusResp.prototype.toObject = function () {
        var t = {};
        return t.code = this.code, t.msg = this.msg, t.data = this.data.toObject(), t
    }, pR.RoomMuteStatusResp.prototype.readFromObject = function (t) {
        t.hasOwnProperty("code") && (this.code = t.code), t.hasOwnProperty("msg") && (this.msg = t.msg), t.hasOwnProperty("data") && this.data.readFromObject(t.data)
    }, pR.RoomMuteStatusResp.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.RoomMuteStatusResp.new = function () {
        return new pR.RoomMuteStatusResp
    }, pR.RoomMuteStatusResp.create = function (t) {
        return pR.RoomMuteStatusResp._readFrom(t)
    }, pR.MuteRoomNotice = function () {
        this.roomId = "", this.flag = 0, this.handler = new pR.User, this._classname = "ChatV2Pro.MuteRoomNotice"
    }, pR.MuteRoomNotice._classname = "ChatV2Pro.MuteRoomNotice", pR.MuteRoomNotice._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.MuteRoomNotice._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.MuteRoomNotice._readFrom = function (t) {
        var e = new pR.MuteRoomNotice;
        return e.roomId = t.readString(0, !1, ""), e.flag = t.readInt32(1, !1, 0), e.handler = t.readStruct(2, !0, pR.User), e
    }, pR.MuteRoomNotice.prototype._writeTo = function (t) {
        t.writeString(0, this.roomId), t.writeInt32(1, this.flag), t.writeStruct(2, this.handler)
    }, pR.MuteRoomNotice.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.MuteRoomNotice.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.MuteRoomNotice.prototype.toObject = function () {
        var t = {};
        return t.roomId = this.roomId, t.flag = this.flag, t.handler = this.handler.toObject(), t
    }, pR.MuteRoomNotice.prototype.readFromObject = function (t) {
        t.hasOwnProperty("roomId") && (this.roomId = t.roomId), t.hasOwnProperty("flag") && (this.flag = t.flag), t.hasOwnProperty("handler") && this.handler.readFromObject(t.handler)
    }, pR.MuteRoomNotice.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.MuteRoomNotice.new = function () {
        return new pR.MuteRoomNotice
    }, pR.MuteRoomNotice.create = function (t) {
        return pR.MuteRoomNotice._readFrom(t)
    }, pR.RoomDataValue = function () {
        this.value = "", this.save = !0, this._classname = "ChatV2Pro.RoomDataValue"
    }, pR.RoomDataValue._classname = "ChatV2Pro.RoomDataValue", pR.RoomDataValue._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.RoomDataValue._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.RoomDataValue._readFrom = function (t) {
        var e = new pR.RoomDataValue;
        return e.value = t.readString(1, !1, ""), e.save = t.readBoolean(2, !1, !0), e
    }, pR.RoomDataValue.prototype._writeTo = function (t) {
        t.writeString(1, this.value), t.writeBoolean(2, this.save)
    }, pR.RoomDataValue.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.RoomDataValue.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.RoomDataValue.prototype.toObject = function () {
        var t = {};
        return t.value = this.value, t.save = this.save, t
    }, pR.RoomDataValue.prototype.readFromObject = function (t) {
        t.hasOwnProperty("value") && (this.value = t.value), t.hasOwnProperty("save") && (this.save = t.save)
    }, pR.RoomDataValue.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.RoomDataValue.new = function () {
        return new pR.RoomDataValue
    }, pR.RoomDataValue.create = function (t) {
        return pR.RoomDataValue._readFrom(t)
    }, pR.SetRoomData = function () {
        this.roomId = "", this.datas = new hR.Map(hR.String, pR.RoomDataValue), this.sendTime = 0, this._classname = "ChatV2Pro.SetRoomData"
    }, pR.SetRoomData._classname = "ChatV2Pro.SetRoomData", pR.SetRoomData._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.SetRoomData._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.SetRoomData._readFrom = function (t) {
        var e = new pR.SetRoomData;
        return e.roomId = t.readString(0, !1, ""), e.datas = t.readMap(1, !1, hR.Map(hR.String, pR.RoomDataValue)), e.sendTime = t.readInt64(2, !1, 0), e
    }, pR.SetRoomData.prototype._writeTo = function (t) {
        t.writeString(0, this.roomId), t.writeMap(1, this.datas), t.writeInt64(2, this.sendTime)
    }, pR.SetRoomData.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.SetRoomData.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.SetRoomData.prototype.toObject = function () {
        var t = {};
        return t.roomId = this.roomId, t.datas = this.datas.toObject(), t.sendTime = this.sendTime, t
    }, pR.SetRoomData.prototype.readFromObject = function (t) {
        t.hasOwnProperty("roomId") && (this.roomId = t.roomId), t.hasOwnProperty("datas") && this.datas.readFromObject(t.datas), t.hasOwnProperty("sendTime") && (this.sendTime = t.sendTime)
    }, pR.SetRoomData.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.SetRoomData.new = function () {
        return new pR.SetRoomData
    }, pR.SetRoomData.create = function (t) {
        return pR.SetRoomData._readFrom(t)
    }, pR.SetRoomDataRespData = function () {
        this.msgId = 0, this.msgIdStr = "", this.fail = new hR.List(hR.String), this._classname = "ChatV2Pro.SetRoomDataRespData"
    }, pR.SetRoomDataRespData._classname = "ChatV2Pro.SetRoomDataRespData", pR.SetRoomDataRespData._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.SetRoomDataRespData._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.SetRoomDataRespData._readFrom = function (t) {
        var e = new pR.SetRoomDataRespData;
        return e.msgId = t.readInt64(0, !1, 0), e.msgIdStr = t.readString(1, !1, ""), e.fail = t.readList(2, !1, hR.List(hR.String)), e
    }, pR.SetRoomDataRespData.prototype._writeTo = function (t) {
        t.writeInt64(0, this.msgId), t.writeString(1, this.msgIdStr), t.writeList(2, this.fail)
    }, pR.SetRoomDataRespData.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.SetRoomDataRespData.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.SetRoomDataRespData.prototype.toObject = function () {
        var t = {};
        return t.msgId = this.msgId, t.msgIdStr = this.msgIdStr, t.fail = this.fail.toObject(), t
    }, pR.SetRoomDataRespData.prototype.readFromObject = function (t) {
        t.hasOwnProperty("msgId") && (this.msgId = t.msgId), t.hasOwnProperty("msgIdStr") && (this.msgIdStr = t.msgIdStr), t.hasOwnProperty("fail") && this.fail.readFromObject(t.fail)
    }, pR.SetRoomDataRespData.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.SetRoomDataRespData.new = function () {
        return new pR.SetRoomDataRespData
    }, pR.SetRoomDataRespData.create = function (t) {
        return pR.SetRoomDataRespData._readFrom(t)
    }, pR.SetRoomDataResp = function () {
        this.code = pR.Code.CodeSuccess, this.msg = "", this.data = new pR.SetRoomDataRespData, this._classname = "ChatV2Pro.SetRoomDataResp"
    }, pR.SetRoomDataResp._classname = "ChatV2Pro.SetRoomDataResp", pR.SetRoomDataResp._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.SetRoomDataResp._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.SetRoomDataResp._readFrom = function (t) {
        var e = new pR.SetRoomDataResp;
        return e.code = t.readInt32(0, !1, pR.Code.CodeSuccess), e.msg = t.readString(1, !1, ""), e.data = t.readStruct(2, !1, pR.SetRoomDataRespData), e
    }, pR.SetRoomDataResp.prototype._writeTo = function (t) {
        t.writeInt32(0, this.code), t.writeString(1, this.msg), t.writeStruct(2, this.data)
    }, pR.SetRoomDataResp.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.SetRoomDataResp.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.SetRoomDataResp.prototype.toObject = function () {
        var t = {};
        return t.code = this.code, t.msg = this.msg, t.data = this.data.toObject(), t
    }, pR.SetRoomDataResp.prototype.readFromObject = function (t) {
        t.hasOwnProperty("code") && (this.code = t.code), t.hasOwnProperty("msg") && (this.msg = t.msg), t.hasOwnProperty("data") && this.data.readFromObject(t.data)
    }, pR.SetRoomDataResp.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.SetRoomDataResp.new = function () {
        return new pR.SetRoomDataResp
    }, pR.SetRoomDataResp.create = function (t) {
        return pR.SetRoomDataResp._readFrom(t)
    }, pR.BatchRoomDataValue = function () {
        this.value = "", this.save = !0, this._classname = "ChatV2Pro.BatchRoomDataValue"
    }, pR.BatchRoomDataValue._classname = "ChatV2Pro.BatchRoomDataValue", pR.BatchRoomDataValue._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.BatchRoomDataValue._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.BatchRoomDataValue._readFrom = function (t) {
        var e = new pR.BatchRoomDataValue;
        return e.value = t.readString(0, !1, ""), e.save = t.readBoolean(1, !1, !0), e
    }, pR.BatchRoomDataValue.prototype._writeTo = function (t) {
        t.writeString(0, this.value), t.writeBoolean(1, this.save)
    }, pR.BatchRoomDataValue.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.BatchRoomDataValue.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.BatchRoomDataValue.prototype.toObject = function () {
        var t = {};
        return t.value = this.value, t.save = this.save, t
    }, pR.BatchRoomDataValue.prototype.readFromObject = function (t) {
        t.hasOwnProperty("value") && (this.value = t.value), t.hasOwnProperty("save") && (this.save = t.save)
    }, pR.BatchRoomDataValue.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.BatchRoomDataValue.new = function () {
        return new pR.BatchRoomDataValue
    }, pR.BatchRoomDataValue.create = function (t) {
        return pR.BatchRoomDataValue._readFrom(t)
    }, pR.SetBatchRoomData = function () {
        this.roomId = new hR.List(hR.String), this.datas = new hR.Map(hR.String, pR.BatchRoomDataValue), this.sendTime = 0, this._classname = "ChatV2Pro.SetBatchRoomData"
    }, pR.SetBatchRoomData._classname = "ChatV2Pro.SetBatchRoomData", pR.SetBatchRoomData._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.SetBatchRoomData._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.SetBatchRoomData._readFrom = function (t) {
        var e = new pR.SetBatchRoomData;
        return e.roomId = t.readList(0, !1, hR.List(hR.String)), e.datas = t.readMap(1, !1, hR.Map(hR.String, pR.BatchRoomDataValue)), e.sendTime = t.readInt64(2, !1, 0), e
    }, pR.SetBatchRoomData.prototype._writeTo = function (t) {
        t.writeList(0, this.roomId), t.writeMap(1, this.datas), t.writeInt64(2, this.sendTime)
    }, pR.SetBatchRoomData.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.SetBatchRoomData.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.SetBatchRoomData.prototype.toObject = function () {
        var t = {};
        return t.roomId = this.roomId.toObject(), t.datas = this.datas.toObject(), t.sendTime = this.sendTime, t
    }, pR.SetBatchRoomData.prototype.readFromObject = function (t) {
        t.hasOwnProperty("roomId") && this.roomId.readFromObject(t.roomId), t.hasOwnProperty("datas") && this.datas.readFromObject(t.datas), t.hasOwnProperty("sendTime") && (this.sendTime = t.sendTime)
    }, pR.SetBatchRoomData.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.SetBatchRoomData.new = function () {
        return new pR.SetBatchRoomData
    }, pR.SetBatchRoomData.create = function (t) {
        return pR.SetBatchRoomData._readFrom(t)
    }, pR.SetBatchRoomDataRespData = function () {
        this.msgId = 0, this.msgIdStr = "", this.fail = new hR.Map(hR.String, pR.SetRoomDataResp), this._classname = "ChatV2Pro.SetBatchRoomDataRespData"
    }, pR.SetBatchRoomDataRespData._classname = "ChatV2Pro.SetBatchRoomDataRespData", pR.SetBatchRoomDataRespData._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.SetBatchRoomDataRespData._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.SetBatchRoomDataRespData._readFrom = function (t) {
        var e = new pR.SetBatchRoomDataRespData;
        return e.msgId = t.readInt64(0, !1, 0), e.msgIdStr = t.readString(1, !1, ""), e.fail = t.readMap(2, !1, hR.Map(hR.String, pR.SetRoomDataResp)), e
    }, pR.SetBatchRoomDataRespData.prototype._writeTo = function (t) {
        t.writeInt64(0, this.msgId), t.writeString(1, this.msgIdStr), t.writeMap(2, this.fail)
    }, pR.SetBatchRoomDataRespData.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.SetBatchRoomDataRespData.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.SetBatchRoomDataRespData.prototype.toObject = function () {
        var t = {};
        return t.msgId = this.msgId, t.msgIdStr = this.msgIdStr, t.fail = this.fail.toObject(), t
    }, pR.SetBatchRoomDataRespData.prototype.readFromObject = function (t) {
        t.hasOwnProperty("msgId") && (this.msgId = t.msgId), t.hasOwnProperty("msgIdStr") && (this.msgIdStr = t.msgIdStr), t.hasOwnProperty("fail") && this.fail.readFromObject(t.fail)
    }, pR.SetBatchRoomDataRespData.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.SetBatchRoomDataRespData.new = function () {
        return new pR.SetBatchRoomDataRespData
    }, pR.SetBatchRoomDataRespData.create = function (t) {
        return pR.SetBatchRoomDataRespData._readFrom(t)
    }, pR.SetBatchRoomDataResp = function () {
        this.code = pR.Code.CodeSuccess, this.msg = "", this.data = new pR.SetBatchRoomDataRespData, this._classname = "ChatV2Pro.SetBatchRoomDataResp"
    }, pR.SetBatchRoomDataResp._classname = "ChatV2Pro.SetBatchRoomDataResp", pR.SetBatchRoomDataResp._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.SetBatchRoomDataResp._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.SetBatchRoomDataResp._readFrom = function (t) {
        var e = new pR.SetBatchRoomDataResp;
        return e.code = t.readInt32(0, !1, pR.Code.CodeSuccess), e.msg = t.readString(1, !1, ""), e.data = t.readStruct(2, !1, pR.SetBatchRoomDataRespData), e
    }, pR.SetBatchRoomDataResp.prototype._writeTo = function (t) {
        t.writeInt32(0, this.code), t.writeString(1, this.msg), t.writeStruct(2, this.data)
    }, pR.SetBatchRoomDataResp.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.SetBatchRoomDataResp.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.SetBatchRoomDataResp.prototype.toObject = function () {
        var t = {};
        return t.code = this.code, t.msg = this.msg, t.data = this.data.toObject(), t
    }, pR.SetBatchRoomDataResp.prototype.readFromObject = function (t) {
        t.hasOwnProperty("code") && (this.code = t.code), t.hasOwnProperty("msg") && (this.msg = t.msg), t.hasOwnProperty("data") && this.data.readFromObject(t.data)
    }, pR.SetBatchRoomDataResp.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.SetBatchRoomDataResp.new = function () {
        return new pR.SetBatchRoomDataResp
    }, pR.SetBatchRoomDataResp.create = function (t) {
        return pR.SetBatchRoomDataResp._readFrom(t)
    }, pR.GetRoomData = function () {
        this.roomId = "", this.keys = new hR.List(hR.String), this._classname = "ChatV2Pro.GetRoomData"
    }, pR.GetRoomData._classname = "ChatV2Pro.GetRoomData", pR.GetRoomData._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.GetRoomData._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.GetRoomData._readFrom = function (t) {
        var e = new pR.GetRoomData;
        return e.roomId = t.readString(0, !1, ""), e.keys = t.readList(1, !1, hR.List(hR.String)), e
    }, pR.GetRoomData.prototype._writeTo = function (t) {
        t.writeString(0, this.roomId), t.writeList(1, this.keys)
    }, pR.GetRoomData.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.GetRoomData.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.GetRoomData.prototype.toObject = function () {
        var t = {};
        return t.roomId = this.roomId, t.keys = this.keys.toObject(), t
    }, pR.GetRoomData.prototype.readFromObject = function (t) {
        t.hasOwnProperty("roomId") && (this.roomId = t.roomId), t.hasOwnProperty("keys") && this.keys.readFromObject(t.keys)
    }, pR.GetRoomData.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.GetRoomData.new = function () {
        return new pR.GetRoomData
    }, pR.GetRoomData.create = function (t) {
        return pR.GetRoomData._readFrom(t)
    }, pR.GetRoomDataRespData = function () {
        this.datas = new hR.Map(hR.String, pR.RoomDataValue), this._classname = "ChatV2Pro.GetRoomDataRespData"
    }, pR.GetRoomDataRespData._classname = "ChatV2Pro.GetRoomDataRespData", pR.GetRoomDataRespData._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.GetRoomDataRespData._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.GetRoomDataRespData._readFrom = function (t) {
        var e = new pR.GetRoomDataRespData;
        return e.datas = t.readMap(1, !1, hR.Map(hR.String, pR.RoomDataValue)), e
    }, pR.GetRoomDataRespData.prototype._writeTo = function (t) {
        t.writeMap(1, this.datas)
    };
    pR.GetRoomDataRespData.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.GetRoomDataRespData.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.GetRoomDataRespData.prototype.toObject = function () {
        var t = {};
        return t.datas = this.datas.toObject(), t
    }, pR.GetRoomDataRespData.prototype.readFromObject = function (t) {
        t.hasOwnProperty("datas") && this.datas.readFromObject(t.datas)
    }, pR.GetRoomDataRespData.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.GetRoomDataRespData.new = function () {
        return new pR.GetRoomDataRespData
    }, pR.GetRoomDataRespData.create = function (t) {
        return pR.GetRoomDataRespData._readFrom(t)
    }, pR.GetRoomDataResp = function () {
        this.code = pR.Code.CodeSuccess, this.msg = "", this.data = new pR.GetRoomDataRespData, this._classname = "ChatV2Pro.GetRoomDataResp"
    }, pR.GetRoomDataResp._classname = "ChatV2Pro.GetRoomDataResp", pR.GetRoomDataResp._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.GetRoomDataResp._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.GetRoomDataResp._readFrom = function (t) {
        var e = new pR.GetRoomDataResp;
        return e.code = t.readInt32(0, !1, pR.Code.CodeSuccess), e.msg = t.readString(1, !1, ""), e.data = t.readStruct(2, !1, pR.GetRoomDataRespData), e
    }, pR.GetRoomDataResp.prototype._writeTo = function (t) {
        t.writeInt32(0, this.code), t.writeString(1, this.msg), t.writeStruct(2, this.data)
    }, pR.GetRoomDataResp.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.GetRoomDataResp.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.GetRoomDataResp.prototype.toObject = function () {
        var t = {};
        return t.code = this.code, t.msg = this.msg, t.data = this.data.toObject(), t
    }, pR.GetRoomDataResp.prototype.readFromObject = function (t) {
        t.hasOwnProperty("code") && (this.code = t.code), t.hasOwnProperty("msg") && (this.msg = t.msg), t.hasOwnProperty("data") && this.data.readFromObject(t.data)
    }, pR.GetRoomDataResp.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.GetRoomDataResp.new = function () {
        return new pR.GetRoomDataResp
    }, pR.GetRoomDataResp.create = function (t) {
        return pR.GetRoomDataResp._readFrom(t)
    }, pR.RoomDataNotice = function () {
        this.msgId = 0, this.msgIdStr = "", this.handler = new pR.User, this.roomId = "", this.datas = new hR.Map(hR.String, pR.RoomDataValue), this.needAck = !1, this.sendTime = 0, this._classname = "ChatV2Pro.RoomDataNotice"
    }, pR.RoomDataNotice._classname = "ChatV2Pro.RoomDataNotice", pR.RoomDataNotice._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.RoomDataNotice._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.RoomDataNotice._readFrom = function (t) {
        var e = new pR.RoomDataNotice;
        return e.msgId = t.readInt64(0, !1, 0), e.msgIdStr = t.readString(1, !1, ""), e.handler = t.readStruct(2, !1, pR.User), e.roomId = t.readString(3, !1, ""), e.datas = t.readMap(4, !1, hR.Map(hR.String, pR.RoomDataValue)), e.needAck = t.readBoolean(5, !1, !1), e.sendTime = t.readInt64(6, !1, 0), e
    }, pR.RoomDataNotice.prototype._writeTo = function (t) {
        t.writeInt64(0, this.msgId), t.writeString(1, this.msgIdStr), t.writeStruct(2, this.handler), t.writeString(3, this.roomId), t.writeMap(4, this.datas), t.writeBoolean(5, this.needAck), t.writeInt64(6, this.sendTime)
    }, pR.RoomDataNotice.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.RoomDataNotice.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.RoomDataNotice.prototype.toObject = function () {
        var t = {};
        return t.msgId = this.msgId, t.msgIdStr = this.msgIdStr, t.handler = this.handler.toObject(), t.roomId = this.roomId, t.datas = this.datas.toObject(), t.needAck = this.needAck, t.sendTime = this.sendTime, t
    }, pR.RoomDataNotice.prototype.readFromObject = function (t) {
        t.hasOwnProperty("msgId") && (this.msgId = t.msgId), t.hasOwnProperty("msgIdStr") && (this.msgIdStr = t.msgIdStr), t.hasOwnProperty("handler") && this.handler.readFromObject(t.handler), t.hasOwnProperty("roomId") && (this.roomId = t.roomId), t.hasOwnProperty("datas") && this.datas.readFromObject(t.datas), t.hasOwnProperty("needAck") && (this.needAck = t.needAck), t.hasOwnProperty("sendTime") && (this.sendTime = t.sendTime)
    }, pR.RoomDataNotice.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.RoomDataNotice.new = function () {
        return new pR.RoomDataNotice
    }, pR.RoomDataNotice.create = function (t) {
        return pR.RoomDataNotice._readFrom(t)
    }, pR.RoomDataNoticeResp = function () {
        this.msgId = "", this._classname = "ChatV2Pro.RoomDataNoticeResp"
    }, pR.RoomDataNoticeResp._classname = "ChatV2Pro.RoomDataNoticeResp", pR.RoomDataNoticeResp._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.RoomDataNoticeResp._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.RoomDataNoticeResp._readFrom = function (t) {
        var e = new pR.RoomDataNoticeResp;
        return e.msgId = t.readString(0, !1, ""), e
    }, pR.RoomDataNoticeResp.prototype._writeTo = function (t) {
        t.writeString(0, this.msgId)
    }, pR.RoomDataNoticeResp.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.RoomDataNoticeResp.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.RoomDataNoticeResp.prototype.toObject = function () {
        var t = {};
        return t.msgId = this.msgId, t
    }, pR.RoomDataNoticeResp.prototype.readFromObject = function (t) {
        t.hasOwnProperty("msgId") && (this.msgId = t.msgId)
    }, pR.RoomDataNoticeResp.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.RoomDataNoticeResp.new = function () {
        return new pR.RoomDataNoticeResp
    }, pR.RoomDataNoticeResp.create = function (t) {
        return pR.RoomDataNoticeResp._readFrom(t)
    }, pR.SendRoomBinMessage = function () {
        this.roomIds = new hR.List(hR.String), this.dbKey = "", this.keyMsgId = "", this.content = "", this.seqId = 0, this.sendTime = 0, this._classname = "ChatV2Pro.SendRoomBinMessage"
    }, pR.SendRoomBinMessage._classname = "ChatV2Pro.SendRoomBinMessage", pR.SendRoomBinMessage._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.SendRoomBinMessage._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.SendRoomBinMessage._readFrom = function (t) {
        var e = new pR.SendRoomBinMessage;
        return e.roomIds = t.readList(0, !0, hR.List(hR.String)), e.dbKey = t.readString(1, !0, ""), e.keyMsgId = t.readString(2, !0, ""), e.content = t.readString(3, !0, ""), e.seqId = t.readInt64(4, !1, 0), e.sendTime = t.readInt64(5, !1, 0), e
    }, pR.SendRoomBinMessage.prototype._writeTo = function (t) {
        t.writeList(0, this.roomIds), t.writeString(1, this.dbKey), t.writeString(2, this.keyMsgId), t.writeString(3, this.content), t.writeInt64(4, this.seqId), t.writeInt64(5, this.sendTime)
    }, pR.SendRoomBinMessage.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.SendRoomBinMessage.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.SendRoomBinMessage.prototype.toObject = function () {
        var t = {};
        return t.roomIds = this.roomIds.toObject(), t.dbKey = this.dbKey, t.keyMsgId = this.keyMsgId, t.content = this.content, t.seqId = this.seqId, t.sendTime = this.sendTime, t
    }, pR.SendRoomBinMessage.prototype.readFromObject = function (t) {
        t.hasOwnProperty("roomIds") && this.roomIds.readFromObject(t.roomIds), t.hasOwnProperty("dbKey") && (this.dbKey = t.dbKey), t.hasOwnProperty("keyMsgId") && (this.keyMsgId = t.keyMsgId), t.hasOwnProperty("content") && (this.content = t.content), t.hasOwnProperty("seqId") && (this.seqId = t.seqId), t.hasOwnProperty("sendTime") && (this.sendTime = t.sendTime)
    }, pR.SendRoomBinMessage.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.SendRoomBinMessage.new = function () {
        return new pR.SendRoomBinMessage
    }, pR.SendRoomBinMessage.create = function (t) {
        return pR.SendRoomBinMessage._readFrom(t)
    }, pR.SendRoomBinMessageRespData = function () {
        this.msgId = "", this.timestamp = 0, this.fail = new hR.List(pR.RoomRespFail), this._classname = "ChatV2Pro.SendRoomBinMessageRespData"
    }, pR.SendRoomBinMessageRespData._classname = "ChatV2Pro.SendRoomBinMessageRespData", pR.SendRoomBinMessageRespData._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.SendRoomBinMessageRespData._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.SendRoomBinMessageRespData._readFrom = function (t) {
        var e = new pR.SendRoomBinMessageRespData;
        return e.msgId = t.readString(0, !0, ""), e.timestamp = t.readInt64(1, !0, 0), e.fail = t.readList(2, !1, hR.List(pR.RoomRespFail)), e
    }, pR.SendRoomBinMessageRespData.prototype._writeTo = function (t) {
        t.writeString(0, this.msgId), t.writeInt64(1, this.timestamp), t.writeList(2, this.fail)
    }, pR.SendRoomBinMessageRespData.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.SendRoomBinMessageRespData.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.SendRoomBinMessageRespData.prototype.toObject = function () {
        var t = {};
        return t.msgId = this.msgId, t.timestamp = this.timestamp, t.fail = this.fail.toObject(), t
    }, pR.SendRoomBinMessageRespData.prototype.readFromObject = function (t) {
        t.hasOwnProperty("msgId") && (this.msgId = t.msgId), t.hasOwnProperty("timestamp") && (this.timestamp = t.timestamp), t.hasOwnProperty("fail") && this.fail.readFromObject(t.fail)
    }, pR.SendRoomBinMessageRespData.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.SendRoomBinMessageRespData.new = function () {
        return new pR.SendRoomBinMessageRespData
    }, pR.SendRoomBinMessageRespData.create = function (t) {
        return pR.SendRoomBinMessageRespData._readFrom(t)
    }, pR.SendRoomBinMessageResp = function () {
        this.code = pR.Code.CodeSuccess, this.msg = "", this.data = new pR.SendRoomBinMessageRespData, this._classname = "ChatV2Pro.SendRoomBinMessageResp"
    }, pR.SendRoomBinMessageResp._classname = "ChatV2Pro.SendRoomBinMessageResp", pR.SendRoomBinMessageResp._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.SendRoomBinMessageResp._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.SendRoomBinMessageResp._readFrom = function (t) {
        var e = new pR.SendRoomBinMessageResp;
        return e.code = t.readInt32(0, !0, pR.Code.CodeSuccess), e.msg = t.readString(1, !1, ""), e.data = t.readStruct(2, !1, pR.SendRoomBinMessageRespData), e
    }, pR.SendRoomBinMessageResp.prototype._writeTo = function (t) {
        t.writeInt32(0, this.code), t.writeString(1, this.msg), t.writeStruct(2, this.data)
    }, pR.SendRoomBinMessageResp.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.SendRoomBinMessageResp.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.SendRoomBinMessageResp.prototype.toObject = function () {
        var t = {};
        return t.code = this.code, t.msg = this.msg, t.data = this.data.toObject(), t
    }, pR.SendRoomBinMessageResp.prototype.readFromObject = function (t) {
        t.hasOwnProperty("code") && (this.code = t.code), t.hasOwnProperty("msg") && (this.msg = t.msg), t.hasOwnProperty("data") && this.data.readFromObject(t.data)
    }, pR.SendRoomBinMessageResp.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.SendRoomBinMessageResp.new = function () {
        return new pR.SendRoomBinMessageResp
    }, pR.SendRoomBinMessageResp.create = function (t) {
        return pR.SendRoomBinMessageResp._readFrom(t)
    }, pR.RecvRoomBinMessage = function () {
        this.msgId = "", this.timestamp = 0, this.roomId = "", this.from = new pR.User, this.dbKey = "", this.keyMsgId = "", this.content = "", this.unitSeqId = 0, this.unitPrevSeqId = 0, this.needAck = !0, this.sendTime = 0, this._classname = "ChatV2Pro.RecvRoomBinMessage"
    }, pR.RecvRoomBinMessage._classname = "ChatV2Pro.RecvRoomBinMessage", pR.RecvRoomBinMessage._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.RecvRoomBinMessage._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.RecvRoomBinMessage._readFrom = function (t) {
        var e = new pR.RecvRoomBinMessage;
        return e.msgId = t.readString(0, !0, ""), e.timestamp = t.readInt64(1, !0, 0), e.roomId = t.readString(2, !0, ""), e.from = t.readStruct(3, !0, pR.User), e.dbKey = t.readString(4, !0, ""), e.keyMsgId = t.readString(5, !0, ""), e.content = t.readString(6, !0, ""), e.unitSeqId = t.readInt64(7, !1, 0), e.unitPrevSeqId = t.readInt64(8, !1, 0), e.needAck = t.readBoolean(9, !1, !0), e.sendTime = t.readInt64(10, !1, 0), e
    }, pR.RecvRoomBinMessage.prototype._writeTo = function (t) {
        t.writeString(0, this.msgId), t.writeInt64(1, this.timestamp), t.writeString(2, this.roomId), t.writeStruct(3, this.from), t.writeString(4, this.dbKey), t.writeString(5, this.keyMsgId), t.writeString(6, this.content), t.writeInt64(7, this.unitSeqId), t.writeInt64(8, this.unitPrevSeqId), t.writeBoolean(9, this.needAck), t.writeInt64(10, this.sendTime)
    }, pR.RecvRoomBinMessage.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.RecvRoomBinMessage.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.RecvRoomBinMessage.prototype.toObject = function () {
        var t = {};
        return t.msgId = this.msgId, t.timestamp = this.timestamp, t.roomId = this.roomId, t.from = this.from.toObject(), t.dbKey = this.dbKey, t.keyMsgId = this.keyMsgId, t.content = this.content, t.unitSeqId = this.unitSeqId, t.unitPrevSeqId = this.unitPrevSeqId, t.needAck = this.needAck, t.sendTime = this.sendTime, t
    }, pR.RecvRoomBinMessage.prototype.readFromObject = function (t) {
        t.hasOwnProperty("msgId") && (this.msgId = t.msgId), t.hasOwnProperty("timestamp") && (this.timestamp = t.timestamp), t.hasOwnProperty("roomId") && (this.roomId = t.roomId), t.hasOwnProperty("from") && this.from.readFromObject(t.from), t.hasOwnProperty("dbKey") && (this.dbKey = t.dbKey), t.hasOwnProperty("keyMsgId") && (this.keyMsgId = t.keyMsgId), t.hasOwnProperty("content") && (this.content = t.content), t.hasOwnProperty("unitSeqId") && (this.unitSeqId = t.unitSeqId), t.hasOwnProperty("unitPrevSeqId") && (this.unitPrevSeqId = t.unitPrevSeqId), t.hasOwnProperty("needAck") && (this.needAck = t.needAck), t.hasOwnProperty("sendTime") && (this.sendTime = t.sendTime)
    }, pR.RecvRoomBinMessage.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.RecvRoomBinMessage.new = function () {
        return new pR.RecvRoomBinMessage
    }, pR.RecvRoomBinMessage.create = function (t) {
        return pR.RecvRoomBinMessage._readFrom(t)
    }, pR.RecvRoomBinMessageResp = function () {
        this.msgId = "", this.unitSeqId = 0, this.unitPrevSeqId = 0, this._classname = "ChatV2Pro.RecvRoomBinMessageResp"
    }, pR.RecvRoomBinMessageResp._classname = "ChatV2Pro.RecvRoomBinMessageResp", pR.RecvRoomBinMessageResp._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.RecvRoomBinMessageResp._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.RecvRoomBinMessageResp._readFrom = function (t) {
        var e = new pR.RecvRoomBinMessageResp;
        return e.msgId = t.readString(0, !0, ""), e.unitSeqId = t.readInt64(1, !1, 0), e.unitPrevSeqId = t.readInt64(2, !1, 0), e
    }, pR.RecvRoomBinMessageResp.prototype._writeTo = function (t) {
        t.writeString(0, this.msgId), t.writeInt64(1, this.unitSeqId), t.writeInt64(2, this.unitPrevSeqId)
    }, pR.RecvRoomBinMessageResp.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.RecvRoomBinMessageResp.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.RecvRoomBinMessageResp.prototype.toObject = function () {
        var t = {};
        return t.msgId = this.msgId, t.unitSeqId = this.unitSeqId, t.unitPrevSeqId = this.unitPrevSeqId, t
    }, pR.RecvRoomBinMessageResp.prototype.readFromObject = function (t) {
        t.hasOwnProperty("msgId") && (this.msgId = t.msgId), t.hasOwnProperty("unitSeqId") && (this.unitSeqId = t.unitSeqId), t.hasOwnProperty("unitPrevSeqId") && (this.unitPrevSeqId = t.unitPrevSeqId)
    }, pR.RecvRoomBinMessageResp.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.RecvRoomBinMessageResp.new = function () {
        return new pR.RecvRoomBinMessageResp
    }, pR.RecvRoomBinMessageResp.create = function (t) {
        return pR.RecvRoomBinMessageResp._readFrom(t)
    }, pR.GetRoomHistoryBinMessage = function () {
        this.roomId = "", this.dbKey = "", this.lastKeyMsgId = "", this.order = !0, this.count = 0, this._classname = "ChatV2Pro.GetRoomHistoryBinMessage"
    }, pR.GetRoomHistoryBinMessage._classname = "ChatV2Pro.GetRoomHistoryBinMessage", pR.GetRoomHistoryBinMessage._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.GetRoomHistoryBinMessage._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.GetRoomHistoryBinMessage._readFrom = function (t) {
        var e = new pR.GetRoomHistoryBinMessage;
        return e.roomId = t.readString(0, !1, ""), e.dbKey = t.readString(1, !1, ""), e.lastKeyMsgId = t.readString(2, !1, ""), e.order = t.readBoolean(3, !1, !0), e.count = t.readInt32(4, !1, 0), e
    }, pR.GetRoomHistoryBinMessage.prototype._writeTo = function (t) {
        t.writeString(0, this.roomId), t.writeString(1, this.dbKey), t.writeString(2, this.lastKeyMsgId), t.writeBoolean(3, this.order), t.writeInt32(4, this.count)
    }, pR.GetRoomHistoryBinMessage.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.GetRoomHistoryBinMessage.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.GetRoomHistoryBinMessage.prototype.toObject = function () {
        var t = {};
        return t.roomId = this.roomId, t.dbKey = this.dbKey, t.lastKeyMsgId = this.lastKeyMsgId, t.order = this.order, t.count = this.count, t
    }, pR.GetRoomHistoryBinMessage.prototype.readFromObject = function (t) {
        t.hasOwnProperty("roomId") && (this.roomId = t.roomId), t.hasOwnProperty("dbKey") && (this.dbKey = t.dbKey), t.hasOwnProperty("lastKeyMsgId") && (this.lastKeyMsgId = t.lastKeyMsgId), t.hasOwnProperty("order") && (this.order = t.order), t.hasOwnProperty("count") && (this.count = t.count)
    }, pR.GetRoomHistoryBinMessage.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.GetRoomHistoryBinMessage.new = function () {
        return new pR.GetRoomHistoryBinMessage
    }, pR.GetRoomHistoryBinMessage.create = function (t) {
        return pR.GetRoomHistoryBinMessage._readFrom(t)
    }, pR.GetRoomHistoryBinMessageRespData = function () {
        this.traceId = "", this._classname = "ChatV2Pro.GetRoomHistoryBinMessageRespData"
    }, pR.GetRoomHistoryBinMessageRespData._classname = "ChatV2Pro.GetRoomHistoryBinMessageRespData", pR.GetRoomHistoryBinMessageRespData._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.GetRoomHistoryBinMessageRespData._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.GetRoomHistoryBinMessageRespData._readFrom = function (t) {
        var e = new pR.GetRoomHistoryBinMessageRespData;
        return e.traceId = t.readString(0, !0, ""), e
    }, pR.GetRoomHistoryBinMessageRespData.prototype._writeTo = function (t) {
        t.writeString(0, this.traceId)
    }, pR.GetRoomHistoryBinMessageRespData.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.GetRoomHistoryBinMessageRespData.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.GetRoomHistoryBinMessageRespData.prototype.toObject = function () {
        var t = {};
        return t.traceId = this.traceId, t
    }, pR.GetRoomHistoryBinMessageRespData.prototype.readFromObject = function (t) {
        t.hasOwnProperty("traceId") && (this.traceId = t.traceId)
    }, pR.GetRoomHistoryBinMessageRespData.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.GetRoomHistoryBinMessageRespData.new = function () {
        return new pR.GetRoomHistoryBinMessageRespData
    }, pR.GetRoomHistoryBinMessageRespData.create = function (t) {
        return pR.GetRoomHistoryBinMessageRespData._readFrom(t)
    }, pR.GetRoomHistoryBinMessageResp = function () {
        this.code = pR.Code.CodeSuccess, this.msg = "", this.data = new pR.GetRoomHistoryBinMessageRespData, this._classname = "ChatV2Pro.GetRoomHistoryBinMessageResp"
    }, pR.GetRoomHistoryBinMessageResp._classname = "ChatV2Pro.GetRoomHistoryBinMessageResp", pR.GetRoomHistoryBinMessageResp._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.GetRoomHistoryBinMessageResp._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.GetRoomHistoryBinMessageResp._readFrom = function (t) {
        var e = new pR.GetRoomHistoryBinMessageResp;
        return e.code = t.readInt32(0, !0, pR.Code.CodeSuccess), e.msg = t.readString(1, !1, ""), e.data = t.readStruct(2, !0, pR.GetRoomHistoryBinMessageRespData), e
    }, pR.GetRoomHistoryBinMessageResp.prototype._writeTo = function (t) {
        t.writeInt32(0, this.code), t.writeString(1, this.msg), t.writeStruct(2, this.data)
    }, pR.GetRoomHistoryBinMessageResp.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.GetRoomHistoryBinMessageResp.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.GetRoomHistoryBinMessageResp.prototype.toObject = function () {
        var t = {};
        return t.code = this.code, t.msg = this.msg, t.data = this.data.toObject(), t
    }, pR.GetRoomHistoryBinMessageResp.prototype.readFromObject = function (t) {
        t.hasOwnProperty("code") && (this.code = t.code), t.hasOwnProperty("msg") && (this.msg = t.msg), t.hasOwnProperty("data") && this.data.readFromObject(t.data)
    }, pR.GetRoomHistoryBinMessageResp.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.GetRoomHistoryBinMessageResp.new = function () {
        return new pR.GetRoomHistoryBinMessageResp
    }, pR.GetRoomHistoryBinMessageResp.create = function (t) {
        return pR.GetRoomHistoryBinMessageResp._readFrom(t)
    }, pR.GetRoomHistoryBinMessageNotice = function () {
        this.traceId = "", this.finish = !0, this.msgs = new hR.List(pR.RecvRoomBinMessage), this._classname = "ChatV2Pro.GetRoomHistoryBinMessageNotice"
    }, pR.GetRoomHistoryBinMessageNotice._classname = "ChatV2Pro.GetRoomHistoryBinMessageNotice", pR.GetRoomHistoryBinMessageNotice._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.GetRoomHistoryBinMessageNotice._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.GetRoomHistoryBinMessageNotice._readFrom = function (t) {
        var e = new pR.GetRoomHistoryBinMessageNotice;
        return e.traceId = t.readString(0, !1, ""), e.finish = t.readBoolean(1, !1, !0), e.msgs = t.readList(2, !1, hR.List(pR.RecvRoomBinMessage)), e
    }, pR.GetRoomHistoryBinMessageNotice.prototype._writeTo = function (t) {
        t.writeString(0, this.traceId), t.writeBoolean(1, this.finish), t.writeList(2, this.msgs)
    }, pR.GetRoomHistoryBinMessageNotice.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.GetRoomHistoryBinMessageNotice.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.GetRoomHistoryBinMessageNotice.prototype.toObject = function () {
        var t = {};
        return t.traceId = this.traceId, t.finish = this.finish, t.msgs = this.msgs.toObject(), t
    }, pR.GetRoomHistoryBinMessageNotice.prototype.readFromObject = function (t) {
        t.hasOwnProperty("traceId") && (this.traceId = t.traceId), t.hasOwnProperty("finish") && (this.finish = t.finish), t.hasOwnProperty("msgs") && this.msgs.readFromObject(t.msgs)
    }, pR.GetRoomHistoryBinMessageNotice.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.GetRoomHistoryBinMessageNotice.new = function () {
        return new pR.GetRoomHistoryBinMessageNotice
    }, pR.GetRoomHistoryBinMessageNotice.create = function (t) {
        return pR.GetRoomHistoryBinMessageNotice._readFrom(t)
    }, pR.GetRoomBatchHistoryBinMessage = function () {
        this.getInfo = new hR.List(pR.GetRoomHistoryBinMessage), this._classname = "ChatV2Pro.GetRoomBatchHistoryBinMessage"
    }, pR.GetRoomBatchHistoryBinMessage._classname = "ChatV2Pro.GetRoomBatchHistoryBinMessage", pR.GetRoomBatchHistoryBinMessage._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.GetRoomBatchHistoryBinMessage._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.GetRoomBatchHistoryBinMessage._readFrom = function (t) {
        var e = new pR.GetRoomBatchHistoryBinMessage;
        return e.getInfo = t.readList(0, !1, hR.List(pR.GetRoomHistoryBinMessage)), e
    }, pR.GetRoomBatchHistoryBinMessage.prototype._writeTo = function (t) {
        t.writeList(0, this.getInfo)
    }, pR.GetRoomBatchHistoryBinMessage.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.GetRoomBatchHistoryBinMessage.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.GetRoomBatchHistoryBinMessage.prototype.toObject = function () {
        var t = {};
        return t.getInfo = this.getInfo.toObject(), t
    }, pR.GetRoomBatchHistoryBinMessage.prototype.readFromObject = function (t) {
        t.hasOwnProperty("getInfo") && this.getInfo.readFromObject(t.getInfo)
    }, pR.GetRoomBatchHistoryBinMessage.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.GetRoomBatchHistoryBinMessage.new = function () {
        return new pR.GetRoomBatchHistoryBinMessage
    }, pR.GetRoomBatchHistoryBinMessage.create = function (t) {
        return pR.GetRoomBatchHistoryBinMessage._readFrom(t)
    }, pR.GetRoomBatchHistoryBinMessageRespData = function () {
        this.traceId = "", this._classname = "ChatV2Pro.GetRoomBatchHistoryBinMessageRespData"
    }, pR.GetRoomBatchHistoryBinMessageRespData._classname = "ChatV2Pro.GetRoomBatchHistoryBinMessageRespData", pR.GetRoomBatchHistoryBinMessageRespData._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.GetRoomBatchHistoryBinMessageRespData._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.GetRoomBatchHistoryBinMessageRespData._readFrom = function (t) {
        var e = new pR.GetRoomBatchHistoryBinMessageRespData;
        return e.traceId = t.readString(0, !0, ""), e
    }, pR.GetRoomBatchHistoryBinMessageRespData.prototype._writeTo = function (t) {
        t.writeString(0, this.traceId)
    }, pR.GetRoomBatchHistoryBinMessageRespData.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.GetRoomBatchHistoryBinMessageRespData.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.GetRoomBatchHistoryBinMessageRespData.prototype.toObject = function () {
        var t = {};
        return t.traceId = this.traceId, t
    }, pR.GetRoomBatchHistoryBinMessageRespData.prototype.readFromObject = function (t) {
        t.hasOwnProperty("traceId") && (this.traceId = t.traceId)
    }, pR.GetRoomBatchHistoryBinMessageRespData.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.GetRoomBatchHistoryBinMessageRespData.new = function () {
        return new pR.GetRoomBatchHistoryBinMessageRespData
    }, pR.GetRoomBatchHistoryBinMessageRespData.create = function (t) {
        return pR.GetRoomBatchHistoryBinMessageRespData._readFrom(t)
    }, pR.GetRoomBatchHistoryBinMessageResp = function () {
        this.code = pR.Code.CodeSuccess, this.msg = "", this.data = new pR.GetRoomBatchHistoryBinMessageRespData, this._classname = "ChatV2Pro.GetRoomBatchHistoryBinMessageResp"
    }, pR.GetRoomBatchHistoryBinMessageResp._classname = "ChatV2Pro.GetRoomBatchHistoryBinMessageResp", pR.GetRoomBatchHistoryBinMessageResp._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.GetRoomBatchHistoryBinMessageResp._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.GetRoomBatchHistoryBinMessageResp._readFrom = function (t) {
        var e = new pR.GetRoomBatchHistoryBinMessageResp;
        return e.code = t.readInt32(0, !0, pR.Code.CodeSuccess), e.msg = t.readString(1, !1, ""), e.data = t.readStruct(2, !0, pR.GetRoomBatchHistoryBinMessageRespData), e
    }, pR.GetRoomBatchHistoryBinMessageResp.prototype._writeTo = function (t) {
        t.writeInt32(0, this.code), t.writeString(1, this.msg), t.writeStruct(2, this.data)
    }, pR.GetRoomBatchHistoryBinMessageResp.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.GetRoomBatchHistoryBinMessageResp.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.GetRoomBatchHistoryBinMessageResp.prototype.toObject = function () {
        var t = {};
        return t.code = this.code, t.msg = this.msg, t.data = this.data.toObject(), t
    }, pR.GetRoomBatchHistoryBinMessageResp.prototype.readFromObject = function (t) {
        t.hasOwnProperty("code") && (this.code = t.code), t.hasOwnProperty("msg") && (this.msg = t.msg), t.hasOwnProperty("data") && this.data.readFromObject(t.data)
    }, pR.GetRoomBatchHistoryBinMessageResp.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.GetRoomBatchHistoryBinMessageResp.new = function () {
        return new pR.GetRoomBatchHistoryBinMessageResp
    }, pR.GetRoomBatchHistoryBinMessageResp.create = function (t) {
        return pR.GetRoomBatchHistoryBinMessageResp._readFrom(t)
    }, pR.GetRoomBatchHistoryBinMessageNotice = function () {
        this.traceId = "", this.dbKey = "", this.finish = !0, this.msgs = new hR.List(pR.RecvRoomBinMessage), this._classname = "ChatV2Pro.GetRoomBatchHistoryBinMessageNotice"
    }, pR.GetRoomBatchHistoryBinMessageNotice._classname = "ChatV2Pro.GetRoomBatchHistoryBinMessageNotice", pR.GetRoomBatchHistoryBinMessageNotice._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.GetRoomBatchHistoryBinMessageNotice._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.GetRoomBatchHistoryBinMessageNotice._readFrom = function (t) {
        var e = new pR.GetRoomBatchHistoryBinMessageNotice;
        return e.traceId = t.readString(0, !1, ""), e.dbKey = t.readString(1, !1, ""), e.finish = t.readBoolean(2, !1, !0), e.msgs = t.readList(3, !1, hR.List(pR.RecvRoomBinMessage)), e
    }, pR.GetRoomBatchHistoryBinMessageNotice.prototype._writeTo = function (t) {
        t.writeString(0, this.traceId), t.writeString(1, this.dbKey), t.writeBoolean(2, this.finish), t.writeList(3, this.msgs)
    }, pR.GetRoomBatchHistoryBinMessageNotice.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.GetRoomBatchHistoryBinMessageNotice.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.GetRoomBatchHistoryBinMessageNotice.prototype.toObject = function () {
        var t = {};
        return t.traceId = this.traceId, t.dbKey = this.dbKey, t.finish = this.finish, t.msgs = this.msgs.toObject(), t
    }, pR.GetRoomBatchHistoryBinMessageNotice.prototype.readFromObject = function (t) {
        t.hasOwnProperty("traceId") && (this.traceId = t.traceId), t.hasOwnProperty("dbKey") && (this.dbKey = t.dbKey), t.hasOwnProperty("finish") && (this.finish = t.finish), t.hasOwnProperty("msgs") && this.msgs.readFromObject(t.msgs)
    }, pR.GetRoomBatchHistoryBinMessageNotice.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.GetRoomBatchHistoryBinMessageNotice.new = function () {
        return new pR.GetRoomBatchHistoryBinMessageNotice
    }, pR.GetRoomBatchHistoryBinMessageNotice.create = function (t) {
        return pR.GetRoomBatchHistoryBinMessageNotice._readFrom(t)
    }, pR.RecoverRoomBinMessageNotice = function () {
        this.roomId = "", this.finish = !0, this.messages = new hR.List(pR.RecvRoomBinMessage), this._classname = "ChatV2Pro.RecoverRoomBinMessageNotice"
    }, pR.RecoverRoomBinMessageNotice._classname = "ChatV2Pro.RecoverRoomBinMessageNotice", pR.RecoverRoomBinMessageNotice._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.RecoverRoomBinMessageNotice._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.RecoverRoomBinMessageNotice._readFrom = function (t) {
        var e = new pR.RecoverRoomBinMessageNotice;
        return e.roomId = t.readString(0, !0, ""), e.finish = t.readBoolean(1, !0, !0), e.messages = t.readList(2, !1, hR.List(pR.RecvRoomBinMessage)), e
    }, pR.RecoverRoomBinMessageNotice.prototype._writeTo = function (t) {
        t.writeString(0, this.roomId), t.writeBoolean(1, this.finish), t.writeList(2, this.messages)
    }, pR.RecoverRoomBinMessageNotice.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.RecoverRoomBinMessageNotice.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.RecoverRoomBinMessageNotice.prototype.toObject = function () {
        var t = {};
        return t.roomId = this.roomId, t.finish = this.finish, t.messages = this.messages.toObject(), t
    }, pR.RecoverRoomBinMessageNotice.prototype.readFromObject = function (t) {
        t.hasOwnProperty("roomId") && (this.roomId = t.roomId), t.hasOwnProperty("finish") && (this.finish = t.finish), t.hasOwnProperty("messages") && this.messages.readFromObject(t.messages)
    }, pR.RecoverRoomBinMessageNotice.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.RecoverRoomBinMessageNotice.new = function () {
        return new pR.RecoverRoomBinMessageNotice
    }, pR.RecoverRoomBinMessageNotice.create = function (t) {
        return pR.RecoverRoomBinMessageNotice._readFrom(t)
    }, pR.GetRoomMissingBinMessage = function () {
        this.roomId = "", this.seqIdBegin = 0, this.seqIdEnd = 0, this._classname = "ChatV2Pro.GetRoomMissingBinMessage"
    }, pR.GetRoomMissingBinMessage._classname = "ChatV2Pro.GetRoomMissingBinMessage", pR.GetRoomMissingBinMessage._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.GetRoomMissingBinMessage._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.GetRoomMissingBinMessage._readFrom = function (t) {
        var e = new pR.GetRoomMissingBinMessage;
        return e.roomId = t.readString(0, !0, ""), e.seqIdBegin = t.readInt64(1, !0, 0), e.seqIdEnd = t.readInt64(2, !0, 0), e
    }, pR.GetRoomMissingBinMessage.prototype._writeTo = function (t) {
        t.writeString(0, this.roomId), t.writeInt64(1, this.seqIdBegin), t.writeInt64(2, this.seqIdEnd)
    }, pR.GetRoomMissingBinMessage.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.GetRoomMissingBinMessage.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.GetRoomMissingBinMessage.prototype.toObject = function () {
        var t = {};
        return t.roomId = this.roomId, t.seqIdBegin = this.seqIdBegin, t.seqIdEnd = this.seqIdEnd, t
    }, pR.GetRoomMissingBinMessage.prototype.readFromObject = function (t) {
        t.hasOwnProperty("roomId") && (this.roomId = t.roomId), t.hasOwnProperty("seqIdBegin") && (this.seqIdBegin = t.seqIdBegin), t.hasOwnProperty("seqIdEnd") && (this.seqIdEnd = t.seqIdEnd)
    }, pR.GetRoomMissingBinMessage.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.GetRoomMissingBinMessage.new = function () {
        return new pR.GetRoomMissingBinMessage
    }, pR.GetRoomMissingBinMessage.create = function (t) {
        return pR.GetRoomMissingBinMessage._readFrom(t)
    }, pR.GetRoomMissingBinMessageResp = function () {
        this.code = pR.Code.CodeSuccess, this.msg = "", this._classname = "ChatV2Pro.GetRoomMissingBinMessageResp"
    }, pR.GetRoomMissingBinMessageResp._classname = "ChatV2Pro.GetRoomMissingBinMessageResp", pR.GetRoomMissingBinMessageResp._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.GetRoomMissingBinMessageResp._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.GetRoomMissingBinMessageResp._readFrom = function (t) {
        var e = new pR.GetRoomMissingBinMessageResp;
        return e.code = t.readInt32(0, !0, pR.Code.CodeSuccess), e.msg = t.readString(1, !1, ""), e
    }, pR.GetRoomMissingBinMessageResp.prototype._writeTo = function (t) {
        t.writeInt32(0, this.code), t.writeString(1, this.msg)
    }, pR.GetRoomMissingBinMessageResp.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.GetRoomMissingBinMessageResp.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.GetRoomMissingBinMessageResp.prototype.toObject = function () {
        var t = {};
        return t.code = this.code, t.msg = this.msg, t
    }, pR.GetRoomMissingBinMessageResp.prototype.readFromObject = function (t) {
        t.hasOwnProperty("code") && (this.code = t.code), t.hasOwnProperty("msg") && (this.msg = t.msg)
    }, pR.GetRoomMissingBinMessageResp.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.GetRoomMissingBinMessageResp.new = function () {
        return new pR.GetRoomMissingBinMessageResp
    }, pR.GetRoomMissingBinMessageResp.create = function (t) {
        return pR.GetRoomMissingBinMessageResp._readFrom(t)
    }, pR.GetRoomMissingBinMessageNotice = function () {
        this.roomId = "", this.finish = !0, this.messages = new hR.List(pR.RecvRoomBinMessage), this._classname = "ChatV2Pro.GetRoomMissingBinMessageNotice"
    }, pR.GetRoomMissingBinMessageNotice._classname = "ChatV2Pro.GetRoomMissingBinMessageNotice", pR.GetRoomMissingBinMessageNotice._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.GetRoomMissingBinMessageNotice._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.GetRoomMissingBinMessageNotice._readFrom = function (t) {
        var e = new pR.GetRoomMissingBinMessageNotice;
        return e.roomId = t.readString(0, !0, ""), e.finish = t.readBoolean(1, !0, !0), e.messages = t.readList(2, !1, hR.List(pR.RecvRoomBinMessage)), e
    }, pR.GetRoomMissingBinMessageNotice.prototype._writeTo = function (t) {
        t.writeString(0, this.roomId), t.writeBoolean(1, this.finish), t.writeList(2, this.messages)
    }, pR.GetRoomMissingBinMessageNotice.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.GetRoomMissingBinMessageNotice.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.GetRoomMissingBinMessageNotice.prototype.toObject = function () {
        var t = {};
        return t.roomId = this.roomId, t.finish = this.finish, t.messages = this.messages.toObject(), t
    }, pR.GetRoomMissingBinMessageNotice.prototype.readFromObject = function (t) {
        t.hasOwnProperty("roomId") && (this.roomId = t.roomId), t.hasOwnProperty("finish") && (this.finish = t.finish), t.hasOwnProperty("messages") && this.messages.readFromObject(t.messages)
    }, pR.GetRoomMissingBinMessageNotice.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.GetRoomMissingBinMessageNotice.new = function () {
        return new pR.GetRoomMissingBinMessageNotice
    }, pR.GetRoomMissingBinMessageNotice.create = function (t) {
        return pR.GetRoomMissingBinMessageNotice._readFrom(t)
    }, pR.KickoutData = function () {
        this.desc = "", this._classname = "ChatV2Pro.KickoutData"
    }, pR.KickoutData._classname = "ChatV2Pro.KickoutData", pR.KickoutData._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.KickoutData._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.KickoutData._readFrom = function (t) {
        var e = new pR.KickoutData;
        return e.desc = t.readString(0, !0, ""), e
    }, pR.KickoutData.prototype._writeTo = function (t) {
        t.writeString(0, this.desc)
    }, pR.KickoutData.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.KickoutData.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.KickoutData.prototype.toObject = function () {
        var t = {};
        return t.desc = this.desc, t
    }, pR.KickoutData.prototype.readFromObject = function (t) {
        t.hasOwnProperty("desc") && (this.desc = t.desc)
    }, pR.KickoutData.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.KickoutData.new = function () {
        return new pR.KickoutData
    }, pR.KickoutData.create = function (t) {
        return pR.KickoutData._readFrom(t)
    }, pR.Kickout = function () {
        this.code = pR.Code.CodeSuccess, this.msg = "", this.data = new pR.KickoutData, this._classname = "ChatV2Pro.Kickout"
    }, pR.Kickout._classname = "ChatV2Pro.Kickout", pR.Kickout._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.Kickout._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.Kickout._readFrom = function (t) {
        var e = new pR.Kickout;
        return e.code = t.readInt32(0, !0, pR.Code.CodeSuccess), e.msg = t.readString(1, !1, ""), e.data = t.readStruct(2, !1, pR.KickoutData), e
    }, pR.Kickout.prototype._writeTo = function (t) {
        t.writeInt32(0, this.code), t.writeString(1, this.msg), t.writeStruct(2, this.data)
    }, pR.Kickout.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.Kickout.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.Kickout.prototype.toObject = function () {
        var t = {};
        return t.code = this.code, t.msg = this.msg, t.data = this.data.toObject(), t
    }, pR.Kickout.prototype.readFromObject = function (t) {
        t.hasOwnProperty("code") && (this.code = t.code), t.hasOwnProperty("msg") && (this.msg = t.msg), t.hasOwnProperty("data") && this.data.readFromObject(t.data)
    }, pR.Kickout.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.Kickout.new = function () {
        return new pR.Kickout
    }, pR.Kickout.create = function (t) {
        return pR.Kickout._readFrom(t)
    }, pR.LogoutNotice = function () {
        this.user = new pR.User, this.roomIds = new hR.List(hR.String), this._classname = "ChatV2Pro.LogoutNotice"
    }, pR.LogoutNotice._classname = "ChatV2Pro.LogoutNotice", pR.LogoutNotice._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.LogoutNotice._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.LogoutNotice._readFrom = function (t) {
        var e = new pR.LogoutNotice;
        return e.user = t.readStruct(0, !0, pR.User), e.roomIds = t.readList(1, !1, hR.List(hR.String)), e
    }, pR.LogoutNotice.prototype._writeTo = function (t) {
        t.writeStruct(0, this.user), t.writeList(1, this.roomIds)
    }, pR.LogoutNotice.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.LogoutNotice.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.LogoutNotice.prototype.toObject = function () {
        var t = {};
        return t.user = this.user.toObject(), t.roomIds = this.roomIds.toObject(), t
    }, pR.LogoutNotice.prototype.readFromObject = function (t) {
        t.hasOwnProperty("user") && this.user.readFromObject(t.user), t.hasOwnProperty("roomIds") && this.roomIds.readFromObject(t.roomIds)
    }, pR.LogoutNotice.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.LogoutNotice.new = function () {
        return new pR.LogoutNotice
    }, pR.LogoutNotice.create = function (t) {
        return pR.LogoutNotice._readFrom(t)
    }, pR.GetStatistics = function () {
        this.type = "", this.params = new hR.Map(hR.String, hR.String), this._classname = "ChatV2Pro.GetStatistics"
    }, pR.GetStatistics._classname = "ChatV2Pro.GetStatistics", pR.GetStatistics._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.GetStatistics._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.GetStatistics._readFrom = function (t) {
        var e = new pR.GetStatistics;
        return e.type = t.readString(0, !1, ""), e.params = t.readMap(1, !1, hR.Map(hR.String, hR.String)), e
    }, pR.GetStatistics.prototype._writeTo = function (t) {
        t.writeString(0, this.type), t.writeMap(1, this.params)
    }, pR.GetStatistics.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.GetStatistics.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.GetStatistics.prototype.toObject = function () {
        var t = {};
        return t.type = this.type, t.params = this.params.toObject(), t
    }, pR.GetStatistics.prototype.readFromObject = function (t) {
        t.hasOwnProperty("type") && (this.type = t.type), t.hasOwnProperty("params") && this.params.readFromObject(t.params)
    }, pR.GetStatistics.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.GetStatistics.new = function () {
        return new pR.GetStatistics
    }, pR.GetStatistics.create = function (t) {
        return pR.GetStatistics._readFrom(t)
    }, pR.GetStatisticsRespData = function () {
        this.async = !0, this.traceId = "", this.info = new hR.Map(hR.String, hR.String), this._classname = "ChatV2Pro.GetStatisticsRespData"
    }, pR.GetStatisticsRespData._classname = "ChatV2Pro.GetStatisticsRespData", pR.GetStatisticsRespData._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.GetStatisticsRespData._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.GetStatisticsRespData._readFrom = function (t) {
        var e = new pR.GetStatisticsRespData;
        return e.async = t.readBoolean(0, !1, !0), e.traceId = t.readString(1, !1, ""), e.info = t.readMap(2, !1, hR.Map(hR.String, hR.String)), e
    }, pR.GetStatisticsRespData.prototype._writeTo = function (t) {
        t.writeBoolean(0, this.async), t.writeString(1, this.traceId), t.writeMap(2, this.info)
    }, pR.GetStatisticsRespData.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.GetStatisticsRespData.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.GetStatisticsRespData.prototype.toObject = function () {
        var t = {};
        return t.async = this.async, t.traceId = this.traceId, t.info = this.info.toObject(), t
    }, pR.GetStatisticsRespData.prototype.readFromObject = function (t) {
        t.hasOwnProperty("async") && (this.async = t.async), t.hasOwnProperty("traceId") && (this.traceId = t.traceId), t.hasOwnProperty("info") && this.info.readFromObject(t.info)
    }, pR.GetStatisticsRespData.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.GetStatisticsRespData.new = function () {
        return new pR.GetStatisticsRespData
    }, pR.GetStatisticsRespData.create = function (t) {
        return pR.GetStatisticsRespData._readFrom(t)
    }, pR.GetStatisticsResp = function () {
        this.code = pR.Code.CodeSuccess, this.msg = "", this.data = new pR.GetStatisticsRespData, this._classname = "ChatV2Pro.GetStatisticsResp"
    }, pR.GetStatisticsResp._classname = "ChatV2Pro.GetStatisticsResp", pR.GetStatisticsResp._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.GetStatisticsResp._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.GetStatisticsResp._readFrom = function (t) {
        var e = new pR.GetStatisticsResp;
        return e.code = t.readInt32(0, !0, pR.Code.CodeSuccess), e.msg = t.readString(1, !1, ""), e.data = t.readStruct(2, !1, pR.GetStatisticsRespData), e
    }, pR.GetStatisticsResp.prototype._writeTo = function (t) {
        t.writeInt32(0, this.code), t.writeString(1, this.msg), t.writeStruct(2, this.data)
    }, pR.GetStatisticsResp.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.GetStatisticsResp.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.GetStatisticsResp.prototype.toObject = function () {
        var t = {};
        return t.code = this.code, t.msg = this.msg, t.data = this.data.toObject(), t
    }, pR.GetStatisticsResp.prototype.readFromObject = function (t) {
        t.hasOwnProperty("code") && (this.code = t.code), t.hasOwnProperty("msg") && (this.msg = t.msg), t.hasOwnProperty("data") && this.data.readFromObject(t.data)
    }, pR.GetStatisticsResp.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.GetStatisticsResp.new = function () {
        return new pR.GetStatisticsResp
    }, pR.GetStatisticsResp.create = function (t) {
        return pR.GetStatisticsResp._readFrom(t)
    }, pR.GetStatisticsNoticeData = function () {
        this.traceId = "", this.finish = !0, this.info = new hR.Map(hR.String, hR.String), this._classname = "ChatV2Pro.GetStatisticsNoticeData"
    }, pR.GetStatisticsNoticeData._classname = "ChatV2Pro.GetStatisticsNoticeData", pR.GetStatisticsNoticeData._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.GetStatisticsNoticeData._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.GetStatisticsNoticeData._readFrom = function (t) {
        var e = new pR.GetStatisticsNoticeData;
        return e.traceId = t.readString(0, !1, ""), e.finish = t.readBoolean(1, !1, !0), e.info = t.readMap(2, !1, hR.Map(hR.String, hR.String)), e
    }, pR.GetStatisticsNoticeData.prototype._writeTo = function (t) {
        t.writeString(0, this.traceId), t.writeBoolean(1, this.finish), t.writeMap(2, this.info)
    }, pR.GetStatisticsNoticeData.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.GetStatisticsNoticeData.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.GetStatisticsNoticeData.prototype.toObject = function () {
        var t = {};
        return t.traceId = this.traceId, t.finish = this.finish, t.info = this.info.toObject(), t
    }, pR.GetStatisticsNoticeData.prototype.readFromObject = function (t) {
        t.hasOwnProperty("traceId") && (this.traceId = t.traceId), t.hasOwnProperty("finish") && (this.finish = t.finish), t.hasOwnProperty("info") && this.info.readFromObject(t.info)
    }, pR.GetStatisticsNoticeData.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.GetStatisticsNoticeData.new = function () {
        return new pR.GetStatisticsNoticeData
    }, pR.GetStatisticsNoticeData.create = function (t) {
        return pR.GetStatisticsNoticeData._readFrom(t)
    }, pR.GetStatisticsNotice = function () {
        this.code = pR.Code.CodeSuccess, this.msg = "", this.data = new pR.GetStatisticsNoticeData, this._classname = "ChatV2Pro.GetStatisticsNotice"
    }, pR.GetStatisticsNotice._classname = "ChatV2Pro.GetStatisticsNotice", pR.GetStatisticsNotice._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.GetStatisticsNotice._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.GetStatisticsNotice._readFrom = function (t) {
        var e = new pR.GetStatisticsNotice;
        return e.code = t.readInt32(0, !0, pR.Code.CodeSuccess), e.msg = t.readString(1, !1, ""), e.data = t.readStruct(2, !1, pR.GetStatisticsNoticeData), e
    }, pR.GetStatisticsNotice.prototype._writeTo = function (t) {
        t.writeInt32(0, this.code), t.writeString(1, this.msg), t.writeStruct(2, this.data)
    }, pR.GetStatisticsNotice.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.GetStatisticsNotice.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.GetStatisticsNotice.prototype.toObject = function () {
        var t = {};
        return t.code = this.code, t.msg = this.msg, t.data = this.data.toObject(), t
    }, pR.GetStatisticsNotice.prototype.readFromObject = function (t) {
        t.hasOwnProperty("code") && (this.code = t.code), t.hasOwnProperty("msg") && (this.msg = t.msg), t.hasOwnProperty("data") && this.data.readFromObject(t.data)
    }, pR.GetStatisticsNotice.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.GetStatisticsNotice.new = function () {
        return new pR.GetStatisticsNotice
    }, pR.GetStatisticsNotice.create = function (t) {
        return pR.GetStatisticsNotice._readFrom(t)
    }, pR.GetRoomUserList = function () {
        this.roomIds = new hR.List(hR.String), this.userList = pR.RoomUserListMode.RoomUserListModeAll, this._classname = "ChatV2Pro.GetRoomUserList"
    }, pR.GetRoomUserList._classname = "ChatV2Pro.GetRoomUserList", pR.GetRoomUserList._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.GetRoomUserList._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.GetRoomUserList._readFrom = function (t) {
        var e = new pR.GetRoomUserList;
        return e.roomIds = t.readList(0, !1, hR.List(hR.String)), e.userList = t.readInt32(1, !1, pR.RoomUserListMode.RoomUserListModeAll), e
    }, pR.GetRoomUserList.prototype._writeTo = function (t) {
        t.writeList(0, this.roomIds), t.writeInt32(1, this.userList)
    }, pR.GetRoomUserList.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.GetRoomUserList.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.GetRoomUserList.prototype.toObject = function () {
        var t = {};
        return t.roomIds = this.roomIds.toObject(), t.userList = this.userList, t
    }, pR.GetRoomUserList.prototype.readFromObject = function (t) {
        t.hasOwnProperty("roomIds") && this.roomIds.readFromObject(t.roomIds), t.hasOwnProperty("userList") && (this.userList = t.userList)
    }, pR.GetRoomUserList.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.GetRoomUserList.new = function () {
        return new pR.GetRoomUserList
    }, pR.GetRoomUserList.create = function (t) {
        return pR.GetRoomUserList._readFrom(t)
    }, pR.GetRoomUserListRespData = function () {
        this.traceId = "", this.userNum = new hR.Map(hR.String, hR.Int32), this._classname = "ChatV2Pro.GetRoomUserListRespData"
    }, pR.GetRoomUserListRespData._classname = "ChatV2Pro.GetRoomUserListRespData", pR.GetRoomUserListRespData._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.GetRoomUserListRespData._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.GetRoomUserListRespData._readFrom = function (t) {
        var e = new pR.GetRoomUserListRespData;
        return e.traceId = t.readString(0, !1, ""), e.userNum = t.readMap(1, !1, hR.Map(hR.String, hR.Int32)), e
    }, pR.GetRoomUserListRespData.prototype._writeTo = function (t) {
        t.writeString(0, this.traceId), t.writeMap(1, this.userNum)
    }, pR.GetRoomUserListRespData.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.GetRoomUserListRespData.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.GetRoomUserListRespData.prototype.toObject = function () {
        var t = {};
        return t.traceId = this.traceId, t.userNum = this.userNum.toObject(), t
    }, pR.GetRoomUserListRespData.prototype.readFromObject = function (t) {
        t.hasOwnProperty("traceId") && (this.traceId = t.traceId), t.hasOwnProperty("userNum") && this.userNum.readFromObject(t.userNum)
    }, pR.GetRoomUserListRespData.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.GetRoomUserListRespData.new = function () {
        return new pR.GetRoomUserListRespData
    }, pR.GetRoomUserListRespData.create = function (t) {
        return pR.GetRoomUserListRespData._readFrom(t)
    }, pR.GetRoomUserListResp = function () {
        this.code = pR.Code.CodeSuccess, this.msg = "", this.data = new pR.GetRoomUserListRespData, this._classname = "ChatV2Pro.GetRoomUserListResp"
    }, pR.GetRoomUserListResp._classname = "ChatV2Pro.GetRoomUserListResp", pR.GetRoomUserListResp._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.GetRoomUserListResp._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.GetRoomUserListResp._readFrom = function (t) {
        var e = new pR.GetRoomUserListResp;
        return e.code = t.readInt32(0, !0, pR.Code.CodeSuccess), e.msg = t.readString(1, !1, ""), e.data = t.readStruct(2, !1, pR.GetRoomUserListRespData), e
    }, pR.GetRoomUserListResp.prototype._writeTo = function (t) {
        t.writeInt32(0, this.code), t.writeString(1, this.msg), t.writeStruct(2, this.data)
    }, pR.GetRoomUserListResp.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.GetRoomUserListResp.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.GetRoomUserListResp.prototype.toObject = function () {
        var t = {};
        return t.code = this.code, t.msg = this.msg, t.data = this.data.toObject(), t
    }, pR.GetRoomUserListResp.prototype.readFromObject = function (t) {
        t.hasOwnProperty("code") && (this.code = t.code), t.hasOwnProperty("msg") && (this.msg = t.msg), t.hasOwnProperty("data") && this.data.readFromObject(t.data)
    }, pR.GetRoomUserListResp.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.GetRoomUserListResp.new = function () {
        return new pR.GetRoomUserListResp
    }, pR.GetRoomUserListResp.create = function (t) {
        return pR.GetRoomUserListResp._readFrom(t)
    }, pR.RoomUserCountNotice = function () {
        this.userCount = new hR.Map(hR.String, hR.Int32), this._classname = "ChatV2Pro.RoomUserCountNotice"
    }, pR.RoomUserCountNotice._classname = "ChatV2Pro.RoomUserCountNotice", pR.RoomUserCountNotice._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.RoomUserCountNotice._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.RoomUserCountNotice._readFrom = function (t) {
        var e = new pR.RoomUserCountNotice;
        return e.userCount = t.readMap(0, !0, hR.Map(hR.String, hR.Int32)), e
    }, pR.RoomUserCountNotice.prototype._writeTo = function (t) {
        t.writeMap(0, this.userCount)
    }, pR.RoomUserCountNotice.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.RoomUserCountNotice.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.RoomUserCountNotice.prototype.toObject = function () {
        var t = {};
        return t.userCount = this.userCount.toObject(), t
    }, pR.RoomUserCountNotice.prototype.readFromObject = function (t) {
        t.hasOwnProperty("userCount") && this.userCount.readFromObject(t.userCount)
    }, pR.RoomUserCountNotice.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.RoomUserCountNotice.new = function () {
        return new pR.RoomUserCountNotice
    }, pR.RoomUserCountNotice.create = function (t) {
        return pR.RoomUserCountNotice._readFrom(t)
    }, pR.RoomMsgSubscribe = function () {
        this.subscribe = new hR.Map(hR.String, hR.List(pR.SubscribeOption)), this._classname = "ChatV2Pro.RoomMsgSubscribe"
    }, pR.RoomMsgSubscribe._classname = "ChatV2Pro.RoomMsgSubscribe", pR.RoomMsgSubscribe._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.RoomMsgSubscribe._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.RoomMsgSubscribe._readFrom = function (t) {
        var e = new pR.RoomMsgSubscribe;
        return e.subscribe = t.readMap(0, !1, hR.Map(hR.String, hR.List(pR.SubscribeOption))), e
    }, pR.RoomMsgSubscribe.prototype._writeTo = function (t) {
        t.writeMap(0, this.subscribe)
    }, pR.RoomMsgSubscribe.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.RoomMsgSubscribe.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.RoomMsgSubscribe.prototype.toObject = function () {
        var t = {};
        return t.subscribe = this.subscribe.toObject(), t
    }, pR.RoomMsgSubscribe.prototype.readFromObject = function (t) {
        t.hasOwnProperty("subscribe") && this.subscribe.readFromObject(t.subscribe)
    }, pR.RoomMsgSubscribe.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.RoomMsgSubscribe.new = function () {
        return new pR.RoomMsgSubscribe
    }, pR.RoomMsgSubscribe.create = function (t) {
        return pR.RoomMsgSubscribe._readFrom(t)
    }, pR.RoomMsgSubscribeRespData = function () {
        this.fail = new hR.List(pR.RoomRespFail), this._classname = "ChatV2Pro.RoomMsgSubscribeRespData"
    }, pR.RoomMsgSubscribeRespData._classname = "ChatV2Pro.RoomMsgSubscribeRespData", pR.RoomMsgSubscribeRespData._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.RoomMsgSubscribeRespData._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.RoomMsgSubscribeRespData._readFrom = function (t) {
        var e = new pR.RoomMsgSubscribeRespData;
        return e.fail = t.readList(0, !0, hR.List(pR.RoomRespFail)), e
    }, pR.RoomMsgSubscribeRespData.prototype._writeTo = function (t) {
        t.writeList(0, this.fail)
    }, pR.RoomMsgSubscribeRespData.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.RoomMsgSubscribeRespData.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.RoomMsgSubscribeRespData.prototype.toObject = function () {
        var t = {};
        return t.fail = this.fail.toObject(), t
    }, pR.RoomMsgSubscribeRespData.prototype.readFromObject = function (t) {
        t.hasOwnProperty("fail") && this.fail.readFromObject(t.fail)
    }, pR.RoomMsgSubscribeRespData.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.RoomMsgSubscribeRespData.new = function () {
        return new pR.RoomMsgSubscribeRespData
    }, pR.RoomMsgSubscribeRespData.create = function (t) {
        return pR.RoomMsgSubscribeRespData._readFrom(t)
    }, pR.RoomMsgSubscribeResp = function () {
        this.code = pR.Code.CodeSuccess, this.msg = "", this.data = new pR.RoomMsgSubscribeRespData, this._classname = "ChatV2Pro.RoomMsgSubscribeResp"
    }, pR.RoomMsgSubscribeResp._classname = "ChatV2Pro.RoomMsgSubscribeResp", pR.RoomMsgSubscribeResp._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.RoomMsgSubscribeResp._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.RoomMsgSubscribeResp._readFrom = function (t) {
        var e = new pR.RoomMsgSubscribeResp;
        return e.code = t.readInt32(0, !0, pR.Code.CodeSuccess), e.msg = t.readString(1, !1, ""), e.data = t.readStruct(2, !1, pR.RoomMsgSubscribeRespData), e
    }, pR.RoomMsgSubscribeResp.prototype._writeTo = function (t) {
        t.writeInt32(0, this.code), t.writeString(1, this.msg), t.writeStruct(2, this.data)
    }, pR.RoomMsgSubscribeResp.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.RoomMsgSubscribeResp.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.RoomMsgSubscribeResp.prototype.toObject = function () {
        var t = {};
        return t.code = this.code, t.msg = this.msg, t.data = this.data.toObject(), t
    }, pR.RoomMsgSubscribeResp.prototype.readFromObject = function (t) {
        t.hasOwnProperty("code") && (this.code = t.code), t.hasOwnProperty("msg") && (this.msg = t.msg), t.hasOwnProperty("data") && this.data.readFromObject(t.data)
    }, pR.RoomMsgSubscribeResp.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.RoomMsgSubscribeResp.new = function () {
        return new pR.RoomMsgSubscribeResp
    }, pR.RoomMsgSubscribeResp.create = function (t) {
        return pR.RoomMsgSubscribeResp._readFrom(t)
    }, pR.RoomDataSubscribe = function () {
        this.rommDataSubscribe = new hR.Map(hR.String, hR.List(pR.RoomDataSubscribeOption)), this._classname = "ChatV2Pro.RoomDataSubscribe"
    }, pR.RoomDataSubscribe._classname = "ChatV2Pro.RoomDataSubscribe", pR.RoomDataSubscribe._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.RoomDataSubscribe._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.RoomDataSubscribe._readFrom = function (t) {
        var e = new pR.RoomDataSubscribe;
        return e.rommDataSubscribe = t.readMap(0, !1, hR.Map(hR.String, hR.List(pR.RoomDataSubscribeOption))), e
    }, pR.RoomDataSubscribe.prototype._writeTo = function (t) {
        t.writeMap(0, this.rommDataSubscribe)
    }, pR.RoomDataSubscribe.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.RoomDataSubscribe.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.RoomDataSubscribe.prototype.toObject = function () {
        var t = {};
        return t.rommDataSubscribe = this.rommDataSubscribe.toObject(), t
    }, pR.RoomDataSubscribe.prototype.readFromObject = function (t) {
        t.hasOwnProperty("rommDataSubscribe") && this.rommDataSubscribe.readFromObject(t.rommDataSubscribe)
    }, pR.RoomDataSubscribe.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.RoomDataSubscribe.new = function () {
        return new pR.RoomDataSubscribe
    }, pR.RoomDataSubscribe.create = function (t) {
        return pR.RoomDataSubscribe._readFrom(t)
    }, pR.RoomDataSubscribeRespData = function () {
        this.fail = new hR.List(pR.RoomRespFail), this._classname = "ChatV2Pro.RoomDataSubscribeRespData"
    }, pR.RoomDataSubscribeRespData._classname = "ChatV2Pro.RoomDataSubscribeRespData", pR.RoomDataSubscribeRespData._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.RoomDataSubscribeRespData._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.RoomDataSubscribeRespData._readFrom = function (t) {
        var e = new pR.RoomDataSubscribeRespData;
        return e.fail = t.readList(0, !0, hR.List(pR.RoomRespFail)), e
    }, pR.RoomDataSubscribeRespData.prototype._writeTo = function (t) {
        t.writeList(0, this.fail)
    }, pR.RoomDataSubscribeRespData.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.RoomDataSubscribeRespData.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.RoomDataSubscribeRespData.prototype.toObject = function () {
        var t = {};
        return t.fail = this.fail.toObject(), t
    }, pR.RoomDataSubscribeRespData.prototype.readFromObject = function (t) {
        t.hasOwnProperty("fail") && this.fail.readFromObject(t.fail)
    }, pR.RoomDataSubscribeRespData.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.RoomDataSubscribeRespData.new = function () {
        return new pR.RoomDataSubscribeRespData
    }, pR.RoomDataSubscribeRespData.create = function (t) {
        return pR.RoomDataSubscribeRespData._readFrom(t)
    }, pR.RoomDataSubscribeResp = function () {
        this.code = pR.Code.CodeSuccess, this.msg = "", this.data = new pR.RoomDataSubscribeRespData, this._classname = "ChatV2Pro.RoomDataSubscribeResp"
    }, pR.RoomDataSubscribeResp._classname = "ChatV2Pro.RoomDataSubscribeResp", pR.RoomDataSubscribeResp._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.RoomDataSubscribeResp._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.RoomDataSubscribeResp._readFrom = function (t) {
        var e = new pR.RoomDataSubscribeResp;
        return e.code = t.readInt32(0, !0, pR.Code.CodeSuccess), e.msg = t.readString(1, !1, ""), e.data = t.readStruct(2, !1, pR.RoomDataSubscribeRespData), e
    }, pR.RoomDataSubscribeResp.prototype._writeTo = function (t) {
        t.writeInt32(0, this.code), t.writeString(1, this.msg), t.writeStruct(2, this.data)
    }, pR.RoomDataSubscribeResp.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.RoomDataSubscribeResp.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.RoomDataSubscribeResp.prototype.toObject = function () {
        var t = {};
        return t.code = this.code, t.msg = this.msg, t.data = this.data.toObject(), t
    }, pR.RoomDataSubscribeResp.prototype.readFromObject = function (t) {
        t.hasOwnProperty("code") && (this.code = t.code), t.hasOwnProperty("msg") && (this.msg = t.msg), t.hasOwnProperty("data") && this.data.readFromObject(t.data)
    }, pR.RoomDataSubscribeResp.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.RoomDataSubscribeResp.new = function () {
        return new pR.RoomDataSubscribeResp
    }, pR.RoomDataSubscribeResp.create = function (t) {
        return pR.RoomDataSubscribeResp._readFrom(t)
    }, pR.Unkown = function () {
        this.code = pR.Code.CodeSuccess, this.msg = "", this._classname = "ChatV2Pro.Unkown"
    }, pR.Unkown._classname = "ChatV2Pro.Unkown", pR.Unkown._write = function (t, e, r) {
        t.writeStruct(e, r)
    }, pR.Unkown._read = function (t, e, r) {
        return t.readStruct(e, !0, r)
    }, pR.Unkown._readFrom = function (t) {
        var e = new pR.Unkown;
        return e.code = t.readInt32(0, !0, pR.Code.CodeSuccess), e.msg = t.readString(1, !1, ""), e
    }, pR.Unkown.prototype._writeTo = function (t) {
        t.writeInt32(0, this.code), t.writeString(1, this.msg)
    }, pR.Unkown.prototype._equal = function (t) {
        U_(!1, "this structure not define key operation")
    }, pR.Unkown.prototype._genKey = function () {
        return this._proto_struct_name_ || (this._proto_struct_name_ = "STRUCT" + Math.random()), this._proto_struct_name_
    }, pR.Unkown.prototype.toObject = function () {
        var t = {};
        return t.code = this.code, t.msg = this.msg, t
    }, pR.Unkown.prototype.readFromObject = function (t) {
        t.hasOwnProperty("code") && (this.code = t.code), t.hasOwnProperty("msg") && (this.msg = t.msg)
    }, pR.Unkown.prototype.toBinBuffer = function () {
        var t = new hR.OutputStream;
        return this._writeTo(t), t.getBinBuffer()
    }, pR.Unkown.new = function () {
        return new pR.Unkown
    }, pR.Unkown.create = function (t) {
        return pR.Unkown._readFrom(t)
    };
    var mR = {
        0: "TopicNamespace",
        1: "NoticeNamespace",
        99: "PriMsgNamespace"
    },
        lR = "Single",
        gR = "Group",
        yR = "BinaryGroup",
        _R = "2.1.19",
        RR = 1;
    var vR, wR, SR, MR, bR, IR, BR, TR, OR, DR, PR, CR, kR = function () { };

    function LR(t, e) {
        return ER(t, (3e4 < (RR += 1) && (RR = 1), RR++), e)
    }

    function ER(t, e, r) {
        var o = new kR;
        return o.version = vR.VersionChatv2, o.format = SR.ormatTars, o.encode = bR.EncodeNone, o.command = t, o.seqId = e, o.length = r ? r.length : 0, o.data = r, o.timestamp = Date.now(), o
    } (wR = vR = vR || {})[wR.VersionIm1 = 1] = "VersionIm1", wR[wR.VersionIm2 = 2] = "VersionIm2", wR[wR.VersionChat = 3] = "VersionChat", wR[wR.VersionChatv2 = 4] = "VersionChatv2", (MR = SR = SR || {})[MR.ormatTars = 0] = "ormatTars", MR[MR.FormatThrift = 1] = "FormatThrift", MR[MR.FormatProtobuf = 2] = "FormatProtobuf", MR[MR.FormatJson = 3] = "FormatJson", (IR = bR = bR || {})[IR.EncodeNone = 0] = "EncodeNone", IR[IR.EncodeEncrypt = 1] = "EncodeEncrypt", IR[IR.EncodeCompress = 2] = "EncodeCompress", (TR = BR = BR || {})[TR.RoleUnkown = 0] = "RoleUnkown", TR[TR.RoleTeacher = 1] = "RoleTeacher", TR[TR.RoleStudent = 2] = "RoleStudent", (DR = OR = OR || {})[DR.LoginType = dR.Command.CmdLogin] = "LoginType", DR[DR.LoginRespType = dR.Command.CmdLoginResp] = "LoginRespType", DR[DR.PingType = dR.Command.CmdPing] = "PingType", DR[DR.PongType = dR.Command.CmdPong] = "PongType", DR[DR.RecoverPeer = dR.Command.CmdRecoverPeer] = "RecoverPeer", DR[DR.RecoverPeerResp = dR.Command.CmdRecoverPeerResp] = "RecoverPeerResp", DR[DR.RecoverPeerMessageNotice = dR.Command.CmdRecoverPeerMessageNotice] = "RecoverPeerMessageNotice", DR[DR.JoinRoomType = dR.Command.CmdJoinRoom] = "JoinRoomType", DR[DR.JoinRoomRespType = dR.Command.CmdJoinRoomResp] = "JoinRoomRespType", DR[DR.JoinRoomNoticeType = dR.Command.CmdJoinRoomNotice] = "JoinRoomNoticeType", DR[DR.JoinRoomInfoNoticeType = dR.Command.CmdJoinRoomInfoNotice] = "JoinRoomInfoNoticeType", DR[DR.JoinUserListNoticeType = dR.Command.CmdJoinRoomUserListNotice] = "JoinUserListNoticeType", DR[DR.RoomDataNotice = dR.Command.CmdRoomDataNotice] = "RoomDataNotice", DR[DR.RoomDataNoticeResp = dR.Command.CmdRoomDataNoticeResp] = "RoomDataNoticeResp", DR[DR.RoomUserCountNotice = dR.Command.CmdRoomUserCountNotice] = "RoomUserCountNotice", DR[DR.LeaveRoomType = dR.Command.CmdLeaveRoom] = "LeaveRoomType", DR[DR.LeaveRoomRespType = dR.Command.CmdLeaveRoomResp] = "LeaveRoomRespType", DR[DR.LeaveRoomNoticeType = dR.Command.CmdLeaveRoomNotice] = "LeaveRoomNoticeType", DR[DR.SendRoomMessageType = dR.Command.CmdSendRoomMessage] = "SendRoomMessageType", DR[DR.SendRoomMessageRespType = dR.Command.CmdSendRoomMessageResp] = "SendRoomMessageRespType", DR[DR.RecvRoomMessageType = dR.Command.CmdRecvRoomMessage] = "RecvRoomMessageType", DR[DR.RecoverRoomMessageNotice = dR.Command.CmdRecoverRoomMessageNotice] = "RecoverRoomMessageNotice", DR[DR.GetRoomHistoryMessageReqType = dR.Command.CmdGetRoomHistoryMessage] = "GetRoomHistoryMessageReqType", DR[DR.MuteRoomReqType = dR.Command.CmdMuteRoom] = "MuteRoomReqType", DR[DR.MuteRoomResp = dR.Command.CmdMuteRoomResp] = "MuteRoomResp", DR[DR.RoomMuteStatusReqType = dR.Command.CmdRoomMuteStatus] = "RoomMuteStatusReqType", DR[DR.RoomMuteStatusResp = dR.Command.CmdRoomMuteStatusResp] = "RoomMuteStatusResp", DR[DR.SetRoomDataResp = dR.Command.CmdSetRoomDataResp] = "SetRoomDataResp", DR[DR.SetRoomData = dR.Command.CmdSetRoomData] = "SetRoomData", DR[DR.SetBatchRoomData = dR.Command.CmdSetBatchRoomData] = "SetBatchRoomData", DR[DR.SetBatchRoomDataResp = dR.Command.CmdSetBatchRoomDataResp] = "SetBatchRoomDataResp", DR[DR.GetRoomData = dR.Command.CmdGetRoomData] = "GetRoomData", DR[DR.GetRoomDataResp = dR.Command.CmdGetRoomDataResp] = "GetRoomDataResp", DR[DR.RoomMsgSubscribe = dR.Command.CmdRoomMsgSubscribe] = "RoomMsgSubscribe", DR[DR.RoomMsgSubscribeResp = dR.Command.CmdRoomMsgSubscribeResp] = "RoomMsgSubscribeResp", DR[DR.MuteRoomNotice = dR.Command.CmdMuteRoomNotice] = "MuteRoomNotice", DR[DR.GetRoomHistoryMessageRespType = dR.Command.CmdGetRoomHistoryMessageResp] = "GetRoomHistoryMessageRespType", DR[DR.SendRoomBinMessage = dR.Command.CmdSendRoomBinMessage] = "SendRoomBinMessage", DR[DR.SendRoomBinMessageResp = dR.Command.CmdSendRoomBinMessageResp] = "SendRoomBinMessageResp", DR[DR.RecvRoomBinMessage = dR.Command.CmdRecvRoomBinMessage] = "RecvRoomBinMessage", DR[DR.RecvRoomBinMessageResp = dR.Command.CmdRecvRoomBinMessageResp] = "RecvRoomBinMessageResp", DR[DR.GetRoomHistoryBinMessage = dR.Command.CmdGetRoomHistoryBinMessage] = "GetRoomHistoryBinMessage", DR[DR.GetRoomHistoryBinMessageResp = dR.Command.CmdGetRoomHistoryBinMessageResp] = "GetRoomHistoryBinMessageResp", DR[DR.GetRoomHistoryBinMessageNotice = dR.Command.CmdGetRoomHistoryBinMessageNotice] = "GetRoomHistoryBinMessageNotice", DR[DR.GetRoomBatchHistoryBinMessage = dR.Command.CmdGetRoomBatchHistoryBinMessage] = "GetRoomBatchHistoryBinMessage", DR[DR.GetRoomBatchHistoryBinMessageResp = dR.Command.CmdGetRoomBatchHistoryBinMessageResp] = "GetRoomBatchHistoryBinMessageResp", DR[DR.GetRoomBatchHistoryBinMessageNotice = dR.Command.CmdGetRoomBatchHistoryBinMessageNotice] = "GetRoomBatchHistoryBinMessageNotice", DR[DR.RecvRoomMessageRespType = dR.Command.CmdRecvRoomMessageResp] = "RecvRoomMessageRespType", DR[DR.SendPeerMessageType = dR.Command.CmdSendPeerMessage] = "SendPeerMessageType", DR[DR.SendPeerMessageRespType = dR.Command.CmdSendPeerMessageResp] = "SendPeerMessageRespType", DR[DR.RecvPeerMessageType = dR.Command.CmdRecvPeerMessage] = "RecvPeerMessageType", DR[DR.RecvPeerMessageRespType = dR.Command.CmdRecvPeerMessageResp] = "RecvPeerMessageRespType", DR[DR.KickoutType = dR.Command.CmdKickout] = "KickoutType", DR[DR.LogoutType = dR.Command.CmdLogout] = "LogoutType", DR[DR.LogoutNiticeType = dR.Command.CmdLogoutNotice] = "LogoutNiticeType", DR[DR.UnkownCommand = dR.Command.CmdUnkown] = "UnkownCommand", DR[DR.GetRoomUserList = dR.Command.CmdGetRoomUserList] = "GetRoomUserList", DR[DR.GetRoomUserListResp = dR.Command.CmdGetRoomUserListResp] = "GetRoomUserListResp", DR[DR.GetStatistics = dR.Command.CmdGetStatistics] = "GetStatistics", DR[DR.GetStatisticsResp = dR.Command.CmdGetStatisticsResp] = "GetStatisticsResp", DR[DR.GetStatisticsNotice = dR.Command.CmdGetStatisticsNotice] = "GetStatisticsNotice", DR[DR.GetRoomMissingMessage = dR.Command.CmdGetRoomMissingMessage] = "GetRoomMissingMessage", DR[DR.GetRoomMissingMessageResp = dR.Command.CmdGetRoomMissingMessageResp] = "GetRoomMissingMessageResp", DR[DR.GetRoomMissingMessageNotice = dR.Command.CmdGetRoomMissingMessageNotice] = "GetRoomMissingMessageNotice", DR[DR.GetPeerMissingMessage = dR.Command.CmdGetPeerMissingMessage] = "GetPeerMissingMessage", DR[DR.GetPeerMissingMessageResp = dR.Command.CmdGetPeerMissingMessageResp] = "GetPeerMissingMessageResp", DR[DR.GetPeerMissingMessageNotice = dR.Command.CmdGetPeerMissingMessageNotice] = "GetPeerMissingMessageNotice", (CR = PR = PR || {})[CR.DeviceTypeIPhone = 0] = "DeviceTypeIPhone", CR[CR.DeviceTypeIPad = 1] = "DeviceTypeIPad", CR[CR.DeviceTypeAndroid = 2] = "DeviceTypeAndroid", CR[CR.DeviceTypeWin = 3] = "DeviceTypeWin", CR[CR.DeviceTypeMac = 4] = "DeviceTypeMac", CR[CR.DeviceTypeLinux = 5] = "DeviceTypeLinux", CR[CR.DeviceTypeWeb = 6] = "DeviceTypeWeb", CR[CR.DeviceTypeWX = 7] = "DeviceTypeWX", CR[CR.DeviceTypeZFB = 8] = "DeviceTypeZFB", CR[CR.DeviceTypeOther = 20] = "DeviceTypeOther";
    var NR, UR, GR = 52,
        FR = 53,
        jR = 55;

    function AR(t) {
        var e = dR.Login.new(),
            r = void 0 === t.kickout ? t.role == BR.RoleStudent : t.kickout;
        return e.readFromObject({
            appId: t.appId,
            businessId: t.businessId,
            liveId: t.liveId,
            psId: t.psId,
            password: t.password,
            nickname: t.nickname,
            deviceType: t.deviceType,
            token: t.token,
            kickout: r,
            role: t.role,
            version: function (t) {
                var e = t.split(".");
                return parseInt(e[0]) * Math.pow(2, 16) + parseInt(e[1]) * Math.pow(2, 8) + parseInt(e[2])
            }(_R),
            reconnect: t.reconnect,
            msgPullNum: t.msgPullNum,
            roomUserMode: t.roomUserMode
        }), e.toBinBuffer().toNodeBuffer()
    } (UR = NR = NR || {})[UR.close = 0] = "close", UR[UR.open = 1] = "open";
    var xR = (qR.prototype.onConnectTimeout = function () {
        this.clearConnectTimeout(), console.log("websocket connection timeout!"), this.status != NR.open && this.websocket.close()
    }, qR.prototype.clearConnectTimeout = function () {
        null != this.connectTimeout && (clearTimeout(this.connectTimeout), this.connectTimeout = null)
    }, qR.prototype.connect = function (t, e) {
        var r = this;
        console.log("websocket timeoutMs: " + e), this.websocket = new WebSocket(t, "Chat2.0_v4"), this.websocket.binaryType = "arraybuffer", this.websocket.onopen = function () {
            r.onOpen()
        }, this.websocket.onclose = function (t) {
            r.onClose(t)
        }, this.websocket.onerror = function () {
            r.onError()
        }, this.websocket.onmessage = function (t) {
            r.onMessage(t.data)
        }, this.clearConnectTimeout(), 0 < e && (this.connectTimeout = setTimeout(function () {
            return r.onConnectTimeout()
        }, e))
    }, qR.prototype.send = function (t) {
        var e = function (t) {
            var e = cR.alloc(12);
            return e.writeUInt8(t.version, 0), e.writeUInt8(t.format | t.encode << 4, 1), e.writeUInt16BE(t.command, 2), e.writeUInt32BE(t.seqId, 4), e.writeUInt32BE(t.length, 8), 0 === t.length ? e : cR.concat([e, t.data])
        }(t);
        this.websocket.send(e.buffer)
    }, qR.prototype.registerCallback = function (t) {
        this.onOpenCallback = t.openCallback, this.onCloseCallback = t.closeCallback, this.onErrorCallback = t.errorCallback, this.onMessageCallback = t.messageCallback
    }, qR.prototype.close = function () {
        this.websocket.onopen = null, this.websocket.onclose = null, this.websocket.onerror = null, this.websocket.onmessage = null, this.websocket.close(), this.clearConnectTimeout()
    }, qR.prototype.onOpen = function () {
        this.clearConnectTimeout(), this.status = NR.open, this.onOpenCallback && this.onOpenCallback()
    }, qR.prototype.onClose = function (t) {
        console.log("code: " + t.code + ", reason: " + t.reason), this.clearConnectTimeout(), this.status = NR.close, this.onCloseCallback && this.onCloseCallback(t.code)
    }, qR.prototype.onError = function () {
        this.clearConnectTimeout(), this.onErrorCallback && this.onErrorCallback()
    }, qR.prototype.onMessage = function (t) {
        var e = function (t) {
            var e = t.readUInt8(0),
                r = t.readUInt8(1),
                o = t.readUInt16BE(2),
                n = t.readUInt32BE(4),
                i = t.readUInt32BE(8);
            if (i != t.length - 12) return null;
            var s = new kR;
            return s.version = e, s.format = r >> 4, s.encode = 15 & r, s.command = o, s.seqId = n, s.length = i, s.data = t.slice(12), s
        }(cR.from(t));
        this.onMessageCallback && this.onMessageCallback(e)
    }, qR);

    function qR() {
        this.status = NR.close
    }

    function HR(t) {
        return null != t && (WR(t) || function (t) {
            return "function" == typeof t.readFloatLE && "function" == typeof t.slice && WR(t.slice(0, 0))
        }(t) || !!t._isBuffer)
    }
    var VR = t(function (t) {
        var i, r;
        i = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", r = {
            rotl: function (t, e) {
                return t << e | t >>> 32 - e
            },
            rotr: function (t, e) {
                return t << 32 - e | t >>> e
            },
            endian: function (t) {
                if (t.constructor == Number) return 16711935 & r.rotl(t, 8) | 4278255360 & r.rotl(t, 24);
                for (var e = 0; e < t.length; e++) t[e] = r.endian(t[e]);
                return t
            },
            randomBytes: function (t) {
                for (var e = []; 0 < t; t--) e.push(Math.floor(256 * Math.random()));
                return e
            },
            bytesToWords: function (t) {
                for (var e = [], r = 0, o = 0; r < t.length; r++, o += 8) e[o >>> 5] |= t[r] << 24 - o % 32;
                return e
            },
            wordsToBytes: function (t) {
                for (var e = [], r = 0; r < 32 * t.length; r += 8) e.push(t[r >>> 5] >>> 24 - r % 32 & 255);
                return e
            },
            bytesToHex: function (t) {
                for (var e = [], r = 0; r < t.length; r++) e.push((t[r] >>> 4).toString(16)), e.push((15 & t[r]).toString(16));
                return e.join("")
            },
            hexToBytes: function (t) {
                for (var e = [], r = 0; r < t.length; r += 2) e.push(parseInt(t.substr(r, 2), 16));
                return e
            },
            bytesToBase64: function (t) {
                for (var e = [], r = 0; r < t.length; r += 3)
                    for (var o = t[r] << 16 | t[r + 1] << 8 | t[r + 2], n = 0; n < 4; n++) 8 * r + 6 * n <= 8 * t.length ? e.push(i.charAt(o >>> 6 * (3 - n) & 63)) : e.push("=");
                return e.join("")
            },
            base64ToBytes: function (t) {
                t = t.replace(/[^A-Z0-9+\/]/gi, "");
                for (var e = [], r = 0, o = 0; r < t.length; o = ++r % 4) 0 != o && e.push((i.indexOf(t.charAt(r - 1)) & Math.pow(2, -2 * o + 8) - 1) << 2 * o | i.indexOf(t.charAt(r)) >>> 6 - 2 * o);
                return e
            }
        }, t.exports = r
    }),
        KR = {
            utf8: {
                stringToBytes: function (t) {
                    return KR.bin.stringToBytes(unescape(encodeURIComponent(t)))
                },
                bytesToString: function (t) {
                    return decodeURIComponent(escape(KR.bin.bytesToString(t)))
                }
            },
            bin: {
                stringToBytes: function (t) {
                    for (var e = [], r = 0; r < t.length; r++) e.push(255 & t.charCodeAt(r));
                    return e
                },
                bytesToString: function (t) {
                    for (var e = [], r = 0; r < t.length; r++) e.push(String.fromCharCode(t[r]));
                    return e.join("")
                }
            }
        },
        YR = KR;

    function WR(t) {
        return !!t.constructor && "function" == typeof t.constructor.isBuffer && t.constructor.isBuffer(t)
    }
    var JR = t(function (t) {
        var y, _, R, v, w;
        y = VR, _ = YR.utf8, R = HR, v = YR.bin, (w = function (t, e) {
            t.constructor == String ? t = e && "binary" === e.encoding ? v.stringToBytes(t) : _.stringToBytes(t) : R(t) ? t = Array.prototype.slice.call(t, 0) : Array.isArray(t) || (t = t.toString());
            for (var r = y.bytesToWords(t), o = 8 * t.length, n = 1732584193, i = -271733879, s = -1732584194, a = 271733878, u = 0; u < r.length; u++) r[u] = 16711935 & (r[u] << 8 | r[u] >>> 24) | 4278255360 & (r[u] << 24 | r[u] >>> 8);
            r[o >>> 5] |= 128 << o % 32, r[14 + (64 + o >>> 9 << 4)] = o;
            var c = w._ff,
                f = w._gg,
                h = w._hh,
                p = w._ii;
            for (u = 0; u < r.length; u += 16) {
                var d = n,
                    m = i,
                    l = s,
                    g = a;
                i = p(i = p(i = p(i = p(i = h(i = h(i = h(i = h(i = f(i = f(i = f(i = f(i = c(i = c(i = c(i = c(i, s = c(s, a = c(a, n = c(n, i, s, a, r[u + 0], 7, -680876936), i, s, r[u + 1], 12, -389564586), n, i, r[u + 2], 17, 606105819), a, n, r[u + 3], 22, -1044525330), s = c(s, a = c(a, n = c(n, i, s, a, r[u + 4], 7, -176418897), i, s, r[u + 5], 12, 1200080426), n, i, r[u + 6], 17, -1473231341), a, n, r[u + 7], 22, -45705983), s = c(s, a = c(a, n = c(n, i, s, a, r[u + 8], 7, 1770035416), i, s, r[u + 9], 12, -1958414417), n, i, r[u + 10], 17, -42063), a, n, r[u + 11], 22, -1990404162), s = c(s, a = c(a, n = c(n, i, s, a, r[u + 12], 7, 1804603682), i, s, r[u + 13], 12, -40341101), n, i, r[u + 14], 17, -1502002290), a, n, r[u + 15], 22, 1236535329), s = f(s, a = f(a, n = f(n, i, s, a, r[u + 1], 5, -165796510), i, s, r[u + 6], 9, -1069501632), n, i, r[u + 11], 14, 643717713), a, n, r[u + 0], 20, -373897302), s = f(s, a = f(a, n = f(n, i, s, a, r[u + 5], 5, -701558691), i, s, r[u + 10], 9, 38016083), n, i, r[u + 15], 14, -660478335), a, n, r[u + 4], 20, -405537848), s = f(s, a = f(a, n = f(n, i, s, a, r[u + 9], 5, 568446438), i, s, r[u + 14], 9, -1019803690), n, i, r[u + 3], 14, -187363961), a, n, r[u + 8], 20, 1163531501), s = f(s, a = f(a, n = f(n, i, s, a, r[u + 13], 5, -1444681467), i, s, r[u + 2], 9, -51403784), n, i, r[u + 7], 14, 1735328473), a, n, r[u + 12], 20, -1926607734), s = h(s, a = h(a, n = h(n, i, s, a, r[u + 5], 4, -378558), i, s, r[u + 8], 11, -2022574463), n, i, r[u + 11], 16, 1839030562), a, n, r[u + 14], 23, -35309556), s = h(s, a = h(a, n = h(n, i, s, a, r[u + 1], 4, -1530992060), i, s, r[u + 4], 11, 1272893353), n, i, r[u + 7], 16, -155497632), a, n, r[u + 10], 23, -1094730640), s = h(s, a = h(a, n = h(n, i, s, a, r[u + 13], 4, 681279174), i, s, r[u + 0], 11, -358537222), n, i, r[u + 3], 16, -722521979), a, n, r[u + 6], 23, 76029189), s = h(s, a = h(a, n = h(n, i, s, a, r[u + 9], 4, -640364487), i, s, r[u + 12], 11, -421815835), n, i, r[u + 15], 16, 530742520), a, n, r[u + 2], 23, -995338651), s = p(s, a = p(a, n = p(n, i, s, a, r[u + 0], 6, -198630844), i, s, r[u + 7], 10, 1126891415), n, i, r[u + 14], 15, -1416354905), a, n, r[u + 5], 21, -57434055), s = p(s, a = p(a, n = p(n, i, s, a, r[u + 12], 6, 1700485571), i, s, r[u + 3], 10, -1894986606), n, i, r[u + 10], 15, -1051523), a, n, r[u + 1], 21, -2054922799), s = p(s, a = p(a, n = p(n, i, s, a, r[u + 8], 6, 1873313359), i, s, r[u + 15], 10, -30611744), n, i, r[u + 6], 15, -1560198380), a, n, r[u + 13], 21, 1309151649), s = p(s, a = p(a, n = p(n, i, s, a, r[u + 4], 6, -145523070), i, s, r[u + 11], 10, -1120210379), n, i, r[u + 2], 15, 718787259), a, n, r[u + 9], 21, -343485551), n = n + d >>> 0, i = i + m >>> 0, s = s + l >>> 0, a = a + g >>> 0
            }
            return y.endian([n, i, s, a])
        })._ff = function (t, e, r, o, n, i, s) {
            var a = t + (e & r | ~e & o) + (n >>> 0) + s;
            return (a << i | a >>> 32 - i) + e
        }, w._gg = function (t, e, r, o, n, i, s) {
            var a = t + (e & o | r & ~o) + (n >>> 0) + s;
            return (a << i | a >>> 32 - i) + e
        }, w._hh = function (t, e, r, o, n, i, s) {
            var a = t + (e ^ r ^ o) + (n >>> 0) + s;
            return (a << i | a >>> 32 - i) + e
        }, w._ii = function (t, e, r, o, n, i, s) {
            var a = t + (r ^ (e | ~o)) + (n >>> 0) + s;
            return (a << i | a >>> 32 - i) + e
        }, w._blocksize = 16, w._digestsize = 16, t.exports = function (t, e) {
            if (null == t) throw new Error("Illegal argument " + t);
            var r = y.wordsToBytes(w(t, e));
            return e && e.asBytes ? r : e && e.asString ? v.bytesToString(r) : y.bytesToHex(r)
        }
    }),
        zR = t(function (Qr, t) {
            Qr.exports = function () {
                var e, n;

                function c() {
                    return e.apply(null, arguments)
                }

                function s(t) {
                    return t instanceof Array || "[object Array]" === Object.prototype.toString.call(t)
                }

                function a(t) {
                    return null != t && "[object Object]" === Object.prototype.toString.call(t)
                }

                function i(t) {
                    return void 0 === t
                }

                function u(t) {
                    return "number" == typeof t || "[object Number]" === Object.prototype.toString.call(t)
                }

                function f(t) {
                    return t instanceof Date || "[object Date]" === Object.prototype.toString.call(t)
                }

                function o(t, e) {
                    var r, o = [];
                    for (r = 0; r < t.length; ++r) o.push(e(t[r], r));
                    return o
                }

                function h(t, e) {
                    return Object.prototype.hasOwnProperty.call(t, e)
                }

                function p(t, e) {
                    for (var r in e) h(e, r) && (t[r] = e[r]);
                    return h(e, "toString") && (t.toString = e.toString), h(e, "valueOf") && (t.valueOf = e.valueOf), t
                }

                function d(t, e, r, o) {
                    return ke(t, e, r, o, !0).utc()
                }

                function m(t) {
                    return null == t._pf && (t._pf = {
                        empty: !1,
                        unusedTokens: [],
                        unusedInput: [],
                        overflow: -2,
                        charsLeftOver: 0,
                        nullInput: !1,
                        invalidMonth: null,
                        invalidFormat: !1,
                        userInvalidated: !1,
                        iso: !1,
                        parsedDateParts: [],
                        meridiem: null,
                        rfc2822: !1,
                        weekdayMismatch: !1
                    }), t._pf
                }

                function l(t) {
                    if (null == t._isValid) {
                        var e = m(t),
                            r = n.call(e.parsedDateParts, function (t) {
                                return null != t
                            }),
                            o = !isNaN(t._d.getTime()) && e.overflow < 0 && !e.empty && !e.invalidMonth && !e.invalidWeekday && !e.weekdayMismatch && !e.nullInput && !e.invalidFormat && !e.userInvalidated && (!e.meridiem || e.meridiem && r);
                        if (t._strict && (o = o && 0 === e.charsLeftOver && 0 === e.unusedTokens.length && void 0 === e.bigHour), null != Object.isFrozen && Object.isFrozen(t)) return o;
                        t._isValid = o
                    }
                    return t._isValid
                }

                function g(t) {
                    var e = d(NaN);
                    return null != t ? p(m(e), t) : m(e).userInvalidated = !0, e
                }
                n = Array.prototype.some ? Array.prototype.some : function (t) {
                    for (var e = Object(this), r = e.length >>> 0, o = 0; o < r; o++)
                        if (o in e && t.call(this, e[o], o, e)) return !0;
                    return !1
                };
                var y = c.momentProperties = [];

                function _(t, e) {
                    var r, o, n;
                    if (i(e._isAMomentObject) || (t._isAMomentObject = e._isAMomentObject), i(e._i) || (t._i = e._i), i(e._f) || (t._f = e._f), i(e._l) || (t._l = e._l), i(e._strict) || (t._strict = e._strict), i(e._tzm) || (t._tzm = e._tzm), i(e._isUTC) || (t._isUTC = e._isUTC), i(e._offset) || (t._offset = e._offset), i(e._pf) || (t._pf = m(e)), i(e._locale) || (t._locale = e._locale), 0 < y.length)
                        for (r = 0; r < y.length; r++) o = y[r], i(n = e[o]) || (t[o] = n);
                    return t
                }
                var r = !1;

                function R(t) {
                    _(this, t), this._d = new Date(null != t._d ? t._d.getTime() : NaN), this.isValid() || (this._d = new Date(NaN)), !1 === r && (r = !0, c.updateOffset(this), r = !1)
                }

                function v(t) {
                    return t instanceof R || null != t && null != t._isAMomentObject
                }

                function w(t) {
                    return t < 0 ? Math.ceil(t) || 0 : Math.floor(t)
                }

                function S(t) {
                    var e = +t,
                        r = 0;
                    return 0 != e && isFinite(e) && (r = w(e)), r
                }

                function M(t, e, r) {
                    var o, n = Math.min(t.length, e.length),
                        i = Math.abs(t.length - e.length),
                        s = 0;
                    for (o = 0; o < n; o++)(r && t[o] !== e[o] || !r && S(t[o]) !== S(e[o])) && s++;
                    return s + i
                }

                function b(t) {
                    !1 === c.suppressDeprecationWarnings && "undefined" != typeof console && console.warn && console.warn("Deprecation warning: " + t)
                }

                function t(n, i) {
                    var s = !0;
                    return p(function () {
                        if (null != c.deprecationHandler && c.deprecationHandler(null, n), s) {
                            for (var t, e = [], r = 0; r < arguments.length; r++) {
                                if (t = "", "object" == typeof arguments[r]) {
                                    for (var o in t += "\n[" + r + "] ", arguments[0]) t += o + ": " + arguments[0][o] + ", ";
                                    t = t.slice(0, -2)
                                } else t = arguments[r];
                                e.push(t)
                            }
                            b(n + "\nArguments: " + Array.prototype.slice.call(e).join("") + "\n" + (new Error).stack), s = !1
                        }
                        return i.apply(this, arguments)
                    }, i)
                }
                var I, B = {};

                function T(t, e) {
                    null != c.deprecationHandler && c.deprecationHandler(t, e), B[t] || (b(e), B[t] = !0)
                }

                function O(t) {
                    return t instanceof Function || "[object Function]" === Object.prototype.toString.call(t)
                }

                function D(t, e) {
                    var r, o = p({}, t);
                    for (r in e) h(e, r) && (a(t[r]) && a(e[r]) ? (o[r] = {}, p(o[r], t[r]), p(o[r], e[r])) : null != e[r] ? o[r] = e[r] : delete o[r]);
                    for (r in t) h(t, r) && !h(e, r) && a(t[r]) && (o[r] = p({}, o[r]));
                    return o
                }

                function P(t) {
                    null != t && this.set(t)
                }
                c.suppressDeprecationWarnings = !1, c.deprecationHandler = null, I = Object.keys ? Object.keys : function (t) {
                    var e, r = [];
                    for (e in t) h(t, e) && r.push(e);
                    return r
                };
                var C = {};

                function k(t, e) {
                    var r = t.toLowerCase();
                    C[r] = C[r + "s"] = C[e] = t
                }

                function L(t) {
                    return "string" == typeof t ? C[t] || C[t.toLowerCase()] : void 0
                }

                function E(t) {
                    var e, r, o = {};
                    for (r in t) h(t, r) && (e = L(r)) && (o[e] = t[r]);
                    return o
                }
                var N = {};

                function U(t, e) {
                    N[t] = e
                }

                function G(t) {
                    var e = [];
                    for (var r in t) e.push({
                        unit: r,
                        priority: N[r]
                    });
                    return e.sort(function (t, e) {
                        return t.priority - e.priority
                    }), e
                }

                function F(t, e, r) {
                    var o = "" + Math.abs(t),
                        n = e - o.length,
                        i = 0 <= t;
                    return (i ? r ? "+" : "" : "-") + Math.pow(10, Math.max(0, n)).toString().substr(1) + o
                }
                var j = /(\[[^\[]*\])|(\\)?([Hh]mm(ss)?|Mo|MM?M?M?|Do|DDDo|DD?D?D?|ddd?d?|do?|w[o|w]?|W[o|W]?|Qo?|YYYYYY|YYYYY|YYYY|YY|gg(ggg?)?|GG(GGG?)?|e|E|a|A|hh?|HH?|kk?|mm?|ss?|S{1,9}|x|X|zz?|ZZ?|.)/g,
                    A = /(\[[^\[]*\])|(\\)?(LTS|LT|LL?L?L?|l{1,4})/g,
                    x = {},
                    q = {};

                function H(t, e, r, o) {
                    var n = o;
                    "string" == typeof o && (n = function () {
                        return this[o]()
                    }), t && (q[t] = n), e && (q[e[0]] = function () {
                        return F(n.apply(this, arguments), e[1], e[2])
                    }), r && (q[r] = function () {
                        return this.localeData().ordinal(n.apply(this, arguments), t)
                    })
                }

                function V(t) {
                    return t.match(/\[[\s\S]/) ? t.replace(/^\[|\]$/g, "") : t.replace(/\\/g, "")
                }

                function K(t, e) {
                    return t.isValid() ? (e = Y(e, t.localeData()), x[e] = x[e] || function (o) {
                        var t, n, i = o.match(j);
                        for (t = 0, n = i.length; t < n; t++) q[i[t]] ? i[t] = q[i[t]] : i[t] = V(i[t]);
                        return function (t) {
                            var e, r = "";
                            for (e = 0; e < n; e++) r += O(i[e]) ? i[e].call(t, o) : i[e];
                            return r
                        }
                    }(e), x[e](t)) : t.localeData().invalidDate()
                }

                function Y(t, e) {
                    var r = 5;

                    function o(t) {
                        return e.longDateFormat(t) || t
                    }
                    for (A.lastIndex = 0; 0 <= r && A.test(t);) t = t.replace(A, o), A.lastIndex = 0, r -= 1;
                    return t
                }
                var W = /\d/,
                    J = /\d\d/,
                    z = /\d{3}/,
                    Z = /\d{4}/,
                    $ = /[+-]?\d{6}/,
                    X = /\d\d?/,
                    Q = /\d\d\d\d?/,
                    tt = /\d\d\d\d\d\d?/,
                    et = /\d{1,3}/,
                    rt = /\d{1,4}/,
                    ot = /[+-]?\d{1,6}/,
                    nt = /\d+/,
                    it = /[+-]?\d+/,
                    st = /Z|[+-]\d\d:?\d\d/gi,
                    at = /Z|[+-]\d\d(?::?\d\d)?/gi,
                    ut = /[0-9]{0,256}['a-z\u00A0-\u05FF\u0700-\uD7FF\uF900-\uFDCF\uFDF0-\uFF07\uFF10-\uFFEF]{1,256}|[\u0600-\u06FF\/]{1,256}(\s*?[\u0600-\u06FF]{1,256}){1,2}/i,
                    ct = {};

                function ft(t, r, o) {
                    ct[t] = O(r) ? r : function (t, e) {
                        return t && o ? o : r
                    }
                }

                function ht(t, e) {
                    return h(ct, t) ? ct[t](e._strict, e._locale) : new RegExp(function (t) {
                        return pt(t.replace("\\", "").replace(/\\(\[)|\\(\])|\[([^\]\[]*)\]|\\(.)/g, function (t, e, r, o, n) {
                            return e || r || o || n
                        }))
                    }(t))
                }

                function pt(t) {
                    return t.replace(/[-\/\\^$*+?.()|[\]{}]/g, "\\$&")
                }
                var dt = {};

                function mt(t, r) {
                    var e, o = r;
                    for ("string" == typeof t && (t = [t]), u(r) && (o = function (t, e) {
                        e[r] = S(t)
                    }), e = 0; e < t.length; e++) dt[t[e]] = o
                }

                function lt(t, n) {
                    mt(t, function (t, e, r, o) {
                        r._w = r._w || {}, n(t, r._w, r, o)
                    })
                }

                function gt(t, e, r) {
                    null != e && h(dt, t) && dt[t](e, r._a, r, t)
                }
                var yt = 0,
                    _t = 1,
                    Rt = 2,
                    vt = 3,
                    wt = 4,
                    St = 5,
                    Mt = 6,
                    bt = 7,
                    It = 8;

                function Bt(t) {
                    return Tt(t) ? 366 : 365
                }

                function Tt(t) {
                    return t % 4 == 0 && t % 100 != 0 || t % 400 == 0
                }
                H("Y", 0, 0, function () {
                    var t = this.year();
                    return t <= 9999 ? "" + t : "+" + t
                }), H(0, ["YY", 2], 0, function () {
                    return this.year() % 100
                }), H(0, ["YYYY", 4], 0, "year"), H(0, ["YYYYY", 5], 0, "year"), H(0, ["YYYYYY", 6, !0], 0, "year"), k("year", "y"), U("year", 1), ft("Y", it), ft("YY", X, J), ft("YYYY", rt, Z), ft("YYYYY", ot, $), ft("YYYYYY", ot, $), mt(["YYYYY", "YYYYYY"], yt), mt("YYYY", function (t, e) {
                    e[yt] = 2 === t.length ? c.parseTwoDigitYear(t) : S(t)
                }), mt("YY", function (t, e) {
                    e[yt] = c.parseTwoDigitYear(t)
                }), mt("Y", function (t, e) {
                    e[yt] = parseInt(t, 10)
                }), c.parseTwoDigitYear = function (t) {
                    return S(t) + (68 < S(t) ? 1900 : 2e3)
                };
                var Ot, Dt = Pt("FullYear", !0);

                function Pt(e, r) {
                    return function (t) {
                        return null != t ? (kt(this, e, t), c.updateOffset(this, r), this) : Ct(this, e)
                    }
                }

                function Ct(t, e) {
                    return t.isValid() ? t._d["get" + (t._isUTC ? "UTC" : "") + e]() : NaN
                }

                function kt(t, e, r) {
                    t.isValid() && !isNaN(r) && ("FullYear" === e && Tt(t.year()) && 1 === t.month() && 29 === t.date() ? t._d["set" + (t._isUTC ? "UTC" : "") + e](r, t.month(), Lt(r, t.month())) : t._d["set" + (t._isUTC ? "UTC" : "") + e](r))
                }

                function Lt(t, e) {
                    if (isNaN(t) || isNaN(e)) return NaN;
                    var r = function (t, e) {
                        return (t % e + e) % e
                    }(e, 12);
                    return t += (e - r) / 12, 1 === r ? Tt(t) ? 29 : 28 : 31 - r % 7 % 2
                }
                Ot = Array.prototype.indexOf ? Array.prototype.indexOf : function (t) {
                    var e;
                    for (e = 0; e < this.length; ++e)
                        if (this[e] === t) return e;
                    return -1
                }, H("M", ["MM", 2], "Mo", function () {
                    return this.month() + 1
                }), H("MMM", 0, 0, function (t) {
                    return this.localeData().monthsShort(this, t)
                }), H("MMMM", 0, 0, function (t) {
                    return this.localeData().months(this, t)
                }), k("month", "M"), U("month", 8), ft("M", X), ft("MM", X, J), ft("MMM", function (t, e) {
                    return e.monthsShortRegex(t)
                }), ft("MMMM", function (t, e) {
                    return e.monthsRegex(t)
                }), mt(["M", "MM"], function (t, e) {
                    e[_t] = S(t) - 1
                }), mt(["MMM", "MMMM"], function (t, e, r, o) {
                    var n = r._locale.monthsParse(t, o, r._strict);
                    null != n ? e[_t] = n : m(r).invalidMonth = t
                });
                var Et = /D[oD]?(\[[^\[\]]*\]|\s)+MMMM?/,
                    Nt = "January_February_March_April_May_June_July_August_September_October_November_December".split("_");
                var Ut = "Jan_Feb_Mar_Apr_May_Jun_Jul_Aug_Sep_Oct_Nov_Dec".split("_");

                function Gt(t, e, r) {
                    var o, n, i, s = t.toLocaleLowerCase();
                    if (!this._monthsParse)
                        for (this._monthsParse = [], this._longMonthsParse = [], this._shortMonthsParse = [], o = 0; o < 12; ++o) i = d([2e3, o]), this._shortMonthsParse[o] = this.monthsShort(i, "").toLocaleLowerCase(), this._longMonthsParse[o] = this.months(i, "").toLocaleLowerCase();
                    return r ? "MMM" === e ? -1 !== (n = Ot.call(this._shortMonthsParse, s)) ? n : null : -1 !== (n = Ot.call(this._longMonthsParse, s)) ? n : null : "MMM" === e ? -1 !== (n = Ot.call(this._shortMonthsParse, s)) ? n : -1 !== (n = Ot.call(this._longMonthsParse, s)) ? n : null : -1 !== (n = Ot.call(this._longMonthsParse, s)) ? n : -1 !== (n = Ot.call(this._shortMonthsParse, s)) ? n : null
                }

                function Ft(t, e) {
                    var r;
                    if (!t.isValid()) return t;
                    if ("string" == typeof e)
                        if (/^\d+$/.test(e)) e = S(e);
                        else if (!u(e = t.localeData().monthsParse(e))) return t;
                    return r = Math.min(t.date(), Lt(t.year(), e)), t._d["set" + (t._isUTC ? "UTC" : "") + "Month"](e, r), t
                }

                function jt(t) {
                    return null != t ? (Ft(this, t), c.updateOffset(this, !0), this) : Ct(this, "Month")
                }
                var At = ut;
                var xt = ut;

                function qt() {
                    function t(t, e) {
                        return e.length - t.length
                    }
                    var e, r, o = [],
                        n = [],
                        i = [];
                    for (e = 0; e < 12; e++) r = d([2e3, e]), o.push(this.monthsShort(r, "")), n.push(this.months(r, "")), i.push(this.months(r, "")), i.push(this.monthsShort(r, ""));
                    for (o.sort(t), n.sort(t), i.sort(t), e = 0; e < 12; e++) o[e] = pt(o[e]), n[e] = pt(n[e]);
                    for (e = 0; e < 24; e++) i[e] = pt(i[e]);
                    this._monthsRegex = new RegExp("^(" + i.join("|") + ")", "i"), this._monthsShortRegex = this._monthsRegex, this._monthsStrictRegex = new RegExp("^(" + n.join("|") + ")", "i"), this._monthsShortStrictRegex = new RegExp("^(" + o.join("|") + ")", "i")
                }

                function Ht(t) {
                    var e;
                    if (t < 100 && 0 <= t) {
                        var r = Array.prototype.slice.call(arguments);
                        r[0] = t + 400, e = new Date(Date.UTC.apply(null, r)), isFinite(e.getUTCFullYear()) && e.setUTCFullYear(t)
                    } else e = new Date(Date.UTC.apply(null, arguments));
                    return e
                }

                function Vt(t, e, r) {
                    var o = 7 + e - r,
                        n = (7 + Ht(t, 0, o).getUTCDay() - e) % 7;
                    return o - n - 1
                }

                function Kt(t, e, r, o, n) {
                    var i, s, a = (7 + r - o) % 7,
                        u = Vt(t, o, n),
                        c = 1 + 7 * (e - 1) + a + u;
                    return s = c <= 0 ? Bt(i = t - 1) + c : c > Bt(t) ? (i = t + 1, c - Bt(t)) : (i = t, c), {
                        year: i,
                        dayOfYear: s
                    }
                }

                function Yt(t, e, r) {
                    var o, n, i = Vt(t.year(), e, r),
                        s = Math.floor((t.dayOfYear() - i - 1) / 7) + 1;
                    return s < 1 ? (n = t.year() - 1, o = s + Wt(n, e, r)) : s > Wt(t.year(), e, r) ? (o = s - Wt(t.year(), e, r), n = t.year() + 1) : (n = t.year(), o = s), {
                        week: o,
                        year: n
                    }
                }

                function Wt(t, e, r) {
                    var o = Vt(t, e, r),
                        n = Vt(t + 1, e, r);
                    return (Bt(t) - o + n) / 7
                }
                H("w", ["ww", 2], "wo", "week"), H("W", ["WW", 2], "Wo", "isoWeek"), k("week", "w"), k("isoWeek", "W"), U("week", 5), U("isoWeek", 5), ft("w", X), ft("ww", X, J), ft("W", X), ft("WW", X, J), lt(["w", "ww", "W", "WW"], function (t, e, r, o) {
                    e[o.substr(0, 1)] = S(t)
                });

                function Jt(t, e) {
                    return t.slice(e, 7).concat(t.slice(0, e))
                }
                H("d", 0, "do", "day"), H("dd", 0, 0, function (t) {
                    return this.localeData().weekdaysMin(this, t)
                }), H("ddd", 0, 0, function (t) {
                    return this.localeData().weekdaysShort(this, t)
                }), H("dddd", 0, 0, function (t) {
                    return this.localeData().weekdays(this, t)
                }), H("e", 0, 0, "weekday"), H("E", 0, 0, "isoWeekday"), k("day", "d"), k("weekday", "e"), k("isoWeekday", "E"), U("day", 11), U("weekday", 11), U("isoWeekday", 11), ft("d", X), ft("e", X), ft("E", X), ft("dd", function (t, e) {
                    return e.weekdaysMinRegex(t)
                }), ft("ddd", function (t, e) {
                    return e.weekdaysShortRegex(t)
                }), ft("dddd", function (t, e) {
                    return e.weekdaysRegex(t)
                }), lt(["dd", "ddd", "dddd"], function (t, e, r, o) {
                    var n = r._locale.weekdaysParse(t, o, r._strict);
                    null != n ? e.d = n : m(r).invalidWeekday = t
                }), lt(["d", "e", "E"], function (t, e, r, o) {
                    e[o] = S(t)
                });
                var zt = "Sunday_Monday_Tuesday_Wednesday_Thursday_Friday_Saturday".split("_");
                var Zt = "Sun_Mon_Tue_Wed_Thu_Fri_Sat".split("_");
                var $t = "Su_Mo_Tu_We_Th_Fr_Sa".split("_");

                function Xt(t, e, r) {
                    var o, n, i, s = t.toLocaleLowerCase();
                    if (!this._weekdaysParse)
                        for (this._weekdaysParse = [], this._shortWeekdaysParse = [], this._minWeekdaysParse = [], o = 0; o < 7; ++o) i = d([2e3, 1]).day(o), this._minWeekdaysParse[o] = this.weekdaysMin(i, "").toLocaleLowerCase(), this._shortWeekdaysParse[o] = this.weekdaysShort(i, "").toLocaleLowerCase(), this._weekdaysParse[o] = this.weekdays(i, "").toLocaleLowerCase();
                    return r ? "dddd" === e ? -1 !== (n = Ot.call(this._weekdaysParse, s)) ? n : null : "ddd" === e ? -1 !== (n = Ot.call(this._shortWeekdaysParse, s)) ? n : null : -1 !== (n = Ot.call(this._minWeekdaysParse, s)) ? n : null : "dddd" === e ? -1 !== (n = Ot.call(this._weekdaysParse, s)) ? n : -1 !== (n = Ot.call(this._shortWeekdaysParse, s)) ? n : -1 !== (n = Ot.call(this._minWeekdaysParse, s)) ? n : null : "ddd" === e ? -1 !== (n = Ot.call(this._shortWeekdaysParse, s)) ? n : -1 !== (n = Ot.call(this._weekdaysParse, s)) ? n : -1 !== (n = Ot.call(this._minWeekdaysParse, s)) ? n : null : -1 !== (n = Ot.call(this._minWeekdaysParse, s)) ? n : -1 !== (n = Ot.call(this._weekdaysParse, s)) ? n : -1 !== (n = Ot.call(this._shortWeekdaysParse, s)) ? n : null
                }
                var Qt = ut;
                var te = ut;
                var ee = ut;

                function re() {
                    function t(t, e) {
                        return e.length - t.length
                    }
                    var e, r, o, n, i, s = [],
                        a = [],
                        u = [],
                        c = [];
                    for (e = 0; e < 7; e++) r = d([2e3, 1]).day(e), o = this.weekdaysMin(r, ""), n = this.weekdaysShort(r, ""), i = this.weekdays(r, ""), s.push(o), a.push(n), u.push(i), c.push(o), c.push(n), c.push(i);
                    for (s.sort(t), a.sort(t), u.sort(t), c.sort(t), e = 0; e < 7; e++) a[e] = pt(a[e]), u[e] = pt(u[e]), c[e] = pt(c[e]);
                    this._weekdaysRegex = new RegExp("^(" + c.join("|") + ")", "i"), this._weekdaysShortRegex = this._weekdaysRegex, this._weekdaysMinRegex = this._weekdaysRegex, this._weekdaysStrictRegex = new RegExp("^(" + u.join("|") + ")", "i"), this._weekdaysShortStrictRegex = new RegExp("^(" + a.join("|") + ")", "i"), this._weekdaysMinStrictRegex = new RegExp("^(" + s.join("|") + ")", "i")
                }

                function oe() {
                    return this.hours() % 12 || 12
                }

                function ne(t, e) {
                    H(t, 0, 0, function () {
                        return this.localeData().meridiem(this.hours(), this.minutes(), e)
                    })
                }

                function ie(t, e) {
                    return e._meridiemParse
                }
                H("H", ["HH", 2], 0, "hour"), H("h", ["hh", 2], 0, oe), H("k", ["kk", 2], 0, function () {
                    return this.hours() || 24
                }), H("hmm", 0, 0, function () {
                    return "" + oe.apply(this) + F(this.minutes(), 2)
                }), H("hmmss", 0, 0, function () {
                    return "" + oe.apply(this) + F(this.minutes(), 2) + F(this.seconds(), 2)
                }), H("Hmm", 0, 0, function () {
                    return "" + this.hours() + F(this.minutes(), 2)
                }), H("Hmmss", 0, 0, function () {
                    return "" + this.hours() + F(this.minutes(), 2) + F(this.seconds(), 2)
                }), ne("a", !0), ne("A", !1), k("hour", "h"), U("hour", 13), ft("a", ie), ft("A", ie), ft("H", X), ft("h", X), ft("k", X), ft("HH", X, J), ft("hh", X, J), ft("kk", X, J), ft("hmm", Q), ft("hmmss", tt), ft("Hmm", Q), ft("Hmmss", tt), mt(["H", "HH"], vt), mt(["k", "kk"], function (t, e, r) {
                    var o = S(t);
                    e[vt] = 24 === o ? 0 : o
                }), mt(["a", "A"], function (t, e, r) {
                    r._isPm = r._locale.isPM(t), r._meridiem = t
                }), mt(["h", "hh"], function (t, e, r) {
                    e[vt] = S(t), m(r).bigHour = !0
                }), mt("hmm", function (t, e, r) {
                    var o = t.length - 2;
                    e[vt] = S(t.substr(0, o)), e[wt] = S(t.substr(o)), m(r).bigHour = !0
                }), mt("hmmss", function (t, e, r) {
                    var o = t.length - 4,
                        n = t.length - 2;
                    e[vt] = S(t.substr(0, o)), e[wt] = S(t.substr(o, 2)), e[St] = S(t.substr(n)), m(r).bigHour = !0
                }), mt("Hmm", function (t, e, r) {
                    var o = t.length - 2;
                    e[vt] = S(t.substr(0, o)), e[wt] = S(t.substr(o))
                }), mt("Hmmss", function (t, e, r) {
                    var o = t.length - 4,
                        n = t.length - 2;
                    e[vt] = S(t.substr(0, o)), e[wt] = S(t.substr(o, 2)), e[St] = S(t.substr(n))
                });
                var se, ae = Pt("Hours", !0),
                    ue = {
                        calendar: {
                            sameDay: "[Today at] LT",
                            nextDay: "[Tomorrow at] LT",
                            nextWeek: "dddd [at] LT",
                            lastDay: "[Yesterday at] LT",
                            lastWeek: "[Last] dddd [at] LT",
                            sameElse: "L"
                        },
                        longDateFormat: {
                            LTS: "h:mm:ss A",
                            LT: "h:mm A",
                            L: "MM/DD/YYYY",
                            LL: "MMMM D, YYYY",
                            LLL: "MMMM D, YYYY h:mm A",
                            LLLL: "dddd, MMMM D, YYYY h:mm A"
                        },
                        invalidDate: "Invalid date",
                        ordinal: "%d",
                        dayOfMonthOrdinalParse: /\d{1,2}/,
                        relativeTime: {
                            future: "in %s",
                            past: "%s ago",
                            s: "a few seconds",
                            ss: "%d seconds",
                            m: "a minute",
                            mm: "%d minutes",
                            h: "an hour",
                            hh: "%d hours",
                            d: "a day",
                            dd: "%d days",
                            M: "a month",
                            MM: "%d months",
                            y: "a year",
                            yy: "%d years"
                        },
                        months: Nt,
                        monthsShort: Ut,
                        week: {
                            dow: 0,
                            doy: 6
                        },
                        weekdays: zt,
                        weekdaysMin: $t,
                        weekdaysShort: Zt,
                        meridiemParse: /[ap]\.?m?\.?/i
                    },
                    ce = {},
                    fe = {};

                function he(t) {
                    return t ? t.toLowerCase().replace("_", "-") : t
                }

                function pe(t) {
                    var e = null;
                    if (!ce[t] && Qr && Qr.exports) try {
                        e = se._abbr;
                        var r = to;
                        r("./locale/" + t), de(e)
                    } catch (t) { }
                    return ce[t]
                }

                function de(t, e) {
                    var r;
                    return t && ((r = i(e) ? le(t) : me(t, e)) ? se = r : "undefined" != typeof console && console.warn && console.warn("Locale " + t + " not found. Did you forget to load it?")), se._abbr
                }

                function me(t, e) {
                    if (null === e) return delete ce[t], null;
                    var r, o = ue;
                    if (e.abbr = t, null != ce[t]) T("defineLocaleOverride", "use moment.updateLocale(localeName, config) to change an existing locale. moment.defineLocale(localeName, config) should only be used for creating a new locale See http://momentjs.com/guides/#/warnings/define-locale/ for more info."), o = ce[t]._config;
                    else if (null != e.parentLocale)
                        if (null != ce[e.parentLocale]) o = ce[e.parentLocale]._config;
                        else {
                            if (null == (r = pe(e.parentLocale))) return fe[e.parentLocale] || (fe[e.parentLocale] = []), fe[e.parentLocale].push({
                                name: t,
                                config: e
                            }), null;
                            o = r._config
                        }
                    return ce[t] = new P(D(o, e)), fe[t] && fe[t].forEach(function (t) {
                        me(t.name, t.config)
                    }), de(t), ce[t]
                }

                function le(t) {
                    var e;
                    if (t && t._locale && t._locale._abbr && (t = t._locale._abbr), !t) return se;
                    if (!s(t)) {
                        if (e = pe(t)) return e;
                        t = [t]
                    }
                    return function (t) {
                        var e, r, o, n, i = 0;
                        for (; i < t.length;) {
                            for (n = he(t[i]).split("-"), e = n.length, r = (r = he(t[i + 1])) ? r.split("-") : null; 0 < e;) {
                                if (o = pe(n.slice(0, e).join("-"))) return o;
                                if (r && r.length >= e && M(n, r, !0) >= e - 1) break;
                                e--
                            }
                            i++
                        }
                        return se
                    }(t)
                }

                function ge(t) {
                    var e, r = t._a;
                    return r && -2 === m(t).overflow && (e = r[_t] < 0 || 11 < r[_t] ? _t : r[Rt] < 1 || r[Rt] > Lt(r[yt], r[_t]) ? Rt : r[vt] < 0 || 24 < r[vt] || 24 === r[vt] && (0 !== r[wt] || 0 !== r[St] || 0 !== r[Mt]) ? vt : r[wt] < 0 || 59 < r[wt] ? wt : r[St] < 0 || 59 < r[St] ? St : r[Mt] < 0 || 999 < r[Mt] ? Mt : -1, m(t)._overflowDayOfYear && (e < yt || Rt < e) && (e = Rt), m(t)._overflowWeeks && -1 === e && (e = bt), m(t)._overflowWeekday && -1 === e && (e = It), m(t).overflow = e), t
                }

                function ye(t, e, r) {
                    return null != t ? t : null != e ? e : r
                }

                function _e(t) {
                    var e, r, o, n, i, s = [];
                    if (!t._d) {
                        for (o = function (t) {
                            var e = new Date(c.now());
                            if (t._useUTC) return [e.getUTCFullYear(), e.getUTCMonth(), e.getUTCDate()];
                            return [e.getFullYear(), e.getMonth(), e.getDate()]
                        }(t), t._w && null == t._a[Rt] && null == t._a[_t] && function (t) {
                            var e, r, o, n, i, s, a, u;
                            if (null != (e = t._w).GG || null != e.W || null != e.E) i = 1, s = 4, r = ye(e.GG, t._a[yt], Yt(Le(), 1, 4).year), o = ye(e.W, 1), ((n = ye(e.E, 1)) < 1 || 7 < n) && (u = !0);
                            else {
                                i = t._locale._week.dow, s = t._locale._week.doy;
                                var c = Yt(Le(), i, s);
                                r = ye(e.gg, t._a[yt], c.year), o = ye(e.w, c.week), null != e.d ? ((n = e.d) < 0 || 6 < n) && (u = !0) : null != e.e ? (n = e.e + i, (e.e < 0 || 6 < e.e) && (u = !0)) : n = i
                            }
                            o < 1 || o > Wt(r, i, s) ? m(t)._overflowWeeks = !0 : null != u ? m(t)._overflowWeekday = !0 : (a = Kt(r, o, n, i, s), t._a[yt] = a.year, t._dayOfYear = a.dayOfYear)
                        }(t), null != t._dayOfYear && (i = ye(t._a[yt], o[yt]), (t._dayOfYear > Bt(i) || 0 === t._dayOfYear) && (m(t)._overflowDayOfYear = !0), r = Ht(i, 0, t._dayOfYear), t._a[_t] = r.getUTCMonth(), t._a[Rt] = r.getUTCDate()), e = 0; e < 3 && null == t._a[e]; ++e) t._a[e] = s[e] = o[e];
                        for (; e < 7; e++) t._a[e] = s[e] = null == t._a[e] ? 2 === e ? 1 : 0 : t._a[e];
                        24 === t._a[vt] && 0 === t._a[wt] && 0 === t._a[St] && 0 === t._a[Mt] && (t._nextDay = !0, t._a[vt] = 0), t._d = (t._useUTC ? Ht : function (t, e, r, o, n, i, s) {
                            var a;
                            t < 100 && 0 <= t ? (a = new Date(t + 400, e, r, o, n, i, s), isFinite(a.getFullYear()) && a.setFullYear(t)) : a = new Date(t, e, r, o, n, i, s);
                            return a
                        }).apply(null, s), n = t._useUTC ? t._d.getUTCDay() : t._d.getDay(), null != t._tzm && t._d.setUTCMinutes(t._d.getUTCMinutes() - t._tzm), t._nextDay && (t._a[vt] = 24), t._w && void 0 !== t._w.d && t._w.d !== n && (m(t).weekdayMismatch = !0)
                    }
                }
                var Re = /^\s*((?:[+-]\d{6}|\d{4})-(?:\d\d-\d\d|W\d\d-\d|W\d\d|\d\d\d|\d\d))(?:(T| )(\d\d(?::\d\d(?::\d\d(?:[.,]\d+)?)?)?)([\+\-]\d\d(?::?\d\d)?|\s*Z)?)?$/,
                    ve = /^\s*((?:[+-]\d{6}|\d{4})(?:\d\d\d\d|W\d\d\d|W\d\d|\d\d\d|\d\d))(?:(T| )(\d\d(?:\d\d(?:\d\d(?:[.,]\d+)?)?)?)([\+\-]\d\d(?::?\d\d)?|\s*Z)?)?$/,
                    we = /Z|[+-]\d\d(?::?\d\d)?/,
                    Se = [
                        ["YYYYYY-MM-DD", /[+-]\d{6}-\d\d-\d\d/],
                        ["YYYY-MM-DD", /\d{4}-\d\d-\d\d/],
                        ["GGGG-[W]WW-E", /\d{4}-W\d\d-\d/],
                        ["GGGG-[W]WW", /\d{4}-W\d\d/, !1],
                        ["YYYY-DDD", /\d{4}-\d{3}/],
                        ["YYYY-MM", /\d{4}-\d\d/, !1],
                        ["YYYYYYMMDD", /[+-]\d{10}/],
                        ["YYYYMMDD", /\d{8}/],
                        ["GGGG[W]WWE", /\d{4}W\d{3}/],
                        ["GGGG[W]WW", /\d{4}W\d{2}/, !1],
                        ["YYYYDDD", /\d{7}/]
                    ],
                    Me = [
                        ["HH:mm:ss.SSSS", /\d\d:\d\d:\d\d\.\d+/],
                        ["HH:mm:ss,SSSS", /\d\d:\d\d:\d\d,\d+/],
                        ["HH:mm:ss", /\d\d:\d\d:\d\d/],
                        ["HH:mm", /\d\d:\d\d/],
                        ["HHmmss.SSSS", /\d\d\d\d\d\d\.\d+/],
                        ["HHmmss,SSSS", /\d\d\d\d\d\d,\d+/],
                        ["HHmmss", /\d\d\d\d\d\d/],
                        ["HHmm", /\d\d\d\d/],
                        ["HH", /\d\d/]
                    ],
                    be = /^\/?Date\((\-?\d+)/i;

                function Ie(t) {
                    var e, r, o, n, i, s, a = t._i,
                        u = Re.exec(a) || ve.exec(a);
                    if (u) {
                        for (m(t).iso = !0, e = 0, r = Se.length; e < r; e++)
                            if (Se[e][1].exec(u[1])) {
                                n = Se[e][0], o = !1 !== Se[e][2];
                                break
                            }
                        if (null == n) return void (t._isValid = !1);
                        if (u[3]) {
                            for (e = 0, r = Me.length; e < r; e++)
                                if (Me[e][1].exec(u[3])) {
                                    i = (u[2] || " ") + Me[e][0];
                                    break
                                }
                            if (null == i) return void (t._isValid = !1)
                        }
                        if (!o && null != i) return void (t._isValid = !1);
                        if (u[4]) {
                            if (!we.exec(u[4])) return void (t._isValid = !1);
                            s = "Z"
                        }
                        t._f = n + (i || "") + (s || ""), Pe(t)
                    } else t._isValid = !1
                }
                var Be = /^(?:(Mon|Tue|Wed|Thu|Fri|Sat|Sun),?\s)?(\d{1,2})\s(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)\s(\d{2,4})\s(\d\d):(\d\d)(?::(\d\d))?\s(?:(UT|GMT|[ECMP][SD]T)|([Zz])|([+-]\d{4}))$/;

                function Te(t, e, r, o, n, i) {
                    var s = [function (t) {
                        var e = parseInt(t, 10); {
                            if (e <= 49) return 2e3 + e;
                            if (e <= 999) return 1900 + e
                        }
                        return e
                    }(t), Ut.indexOf(e), parseInt(r, 10), parseInt(o, 10), parseInt(n, 10)];
                    return i && s.push(parseInt(i, 10)), s
                }
                var Oe = {
                    UT: 0,
                    GMT: 0,
                    EDT: -240,
                    EST: -300,
                    CDT: -300,
                    CST: -360,
                    MDT: -360,
                    MST: -420,
                    PDT: -420,
                    PST: -480
                };

                function De(t) {
                    var e = Be.exec(function (t) {
                        return t.replace(/\([^)]*\)|[\n\t]/g, " ").replace(/(\s\s+)/g, " ").replace(/^\s\s*/, "").replace(/\s\s*$/, "")
                    }(t._i));
                    if (e) {
                        var r = Te(e[4], e[3], e[2], e[5], e[6], e[7]);
                        if (! function (t, e, r) {
                            if (t) {
                                var o = Zt.indexOf(t),
                                    n = new Date(e[0], e[1], e[2]).getDay();
                                if (o !== n) return m(r).weekdayMismatch = !0, r._isValid = !1
                            }
                            return !0
                        }(e[1], r, t)) return;
                        t._a = r, t._tzm = function (t, e, r) {
                            {
                                if (t) return Oe[t];
                                if (e) return 0;
                                var o = parseInt(r, 10),
                                    n = o % 100;
                                return 60 * ((o - n) / 100) + n
                            }
                        }(e[8], e[9], e[10]), t._d = Ht.apply(null, t._a), t._d.setUTCMinutes(t._d.getUTCMinutes() - t._tzm), m(t).rfc2822 = !0
                    } else t._isValid = !1
                }

                function Pe(t) {
                    if (t._f !== c.ISO_8601)
                        if (t._f !== c.RFC_2822) {
                            t._a = [], m(t).empty = !0;
                            var e, r, o, n, i, s = "" + t._i,
                                a = s.length,
                                u = 0;
                            for (o = Y(t._f, t._locale).match(j) || [], e = 0; e < o.length; e++) n = o[e], (r = (s.match(ht(n, t)) || [])[0]) && (0 < (i = s.substr(0, s.indexOf(r))).length && m(t).unusedInput.push(i), s = s.slice(s.indexOf(r) + r.length), u += r.length), q[n] ? (r ? m(t).empty = !1 : m(t).unusedTokens.push(n), gt(n, r, t)) : t._strict && !r && m(t).unusedTokens.push(n);
                            m(t).charsLeftOver = a - u, 0 < s.length && m(t).unusedInput.push(s), t._a[vt] <= 12 && !0 === m(t).bigHour && 0 < t._a[vt] && (m(t).bigHour = void 0), m(t).parsedDateParts = t._a.slice(0), m(t).meridiem = t._meridiem, t._a[vt] = function (t, e, r) {
                                var o;
                                if (null == r) return e;
                                return null != t.meridiemHour ? t.meridiemHour(e, r) : (null != t.isPM && ((o = t.isPM(r)) && e < 12 && (e += 12), o || 12 !== e || (e = 0)), e)
                            }(t._locale, t._a[vt], t._meridiem), _e(t), ge(t)
                        } else De(t);
                    else Ie(t)
                }

                function Ce(t) {
                    var e = t._i,
                        r = t._f;
                    return t._locale = t._locale || le(t._l), null === e || void 0 === r && "" === e ? g({
                        nullInput: !0
                    }) : ("string" == typeof e && (t._i = e = t._locale.preparse(e)), v(e) ? new R(ge(e)) : (f(e) ? t._d = e : s(r) ? function (t) {
                        var e, r, o, n, i;
                        if (0 === t._f.length) return m(t).invalidFormat = !0, t._d = new Date(NaN);
                        for (n = 0; n < t._f.length; n++) i = 0, e = _({}, t), null != t._useUTC && (e._useUTC = t._useUTC), e._f = t._f[n], Pe(e), l(e) && (i += m(e).charsLeftOver, i += 10 * m(e).unusedTokens.length, m(e).score = i, (null == o || i < o) && (o = i, r = e));
                        p(t, r || e)
                    }(t) : r ? Pe(t) : function (t) {
                        var e = t._i;
                        i(e) ? t._d = new Date(c.now()) : f(e) ? t._d = new Date(e.valueOf()) : "string" == typeof e ? function (t) {
                            var e = be.exec(t._i);
                            if (null !== e) return t._d = new Date(+e[1]); {
                                if (Ie(t), !1 !== t._isValid) return;
                                delete t._isValid
                            } {
                                if (De(t), !1 !== t._isValid) return;
                                delete t._isValid
                            }
                            c.createFromInputFallback(t)
                        }(t) : s(e) ? (t._a = o(e.slice(0), function (t) {
                            return parseInt(t, 10)
                        }), _e(t)) : a(e) ? function (t) {
                            if (t._d) return;
                            var e = E(t._i);
                            t._a = o([e.year, e.month, e.day || e.date, e.hour, e.minute, e.second, e.millisecond], function (t) {
                                return t && parseInt(t, 10)
                            }), _e(t)
                        }(t) : u(e) ? t._d = new Date(e) : c.createFromInputFallback(t)
                    }(t), l(t) || (t._d = null), t))
                }

                function ke(t, e, r, o, n) {
                    var i = {};
                    return !0 !== r && !1 !== r || (o = r, r = void 0), (a(t) && function (t) {
                        {
                            if (Object.getOwnPropertyNames) return 0 === Object.getOwnPropertyNames(t).length;
                            var e;
                            for (e in t)
                                if (t.hasOwnProperty(e)) return !1;
                            return !0
                        }
                    }(t) || s(t) && 0 === t.length) && (t = void 0), i._isAMomentObject = !0, i._useUTC = i._isUTC = n, i._l = r, i._i = t, i._f = e, i._strict = o,
                        function (t) {
                            var e = new R(ge(Ce(t)));
                            e._nextDay && (e.add(1, "d"), e._nextDay = void 0);
                            return e
                        }(i)
                }

                function Le(t, e, r, o) {
                    return ke(t, e, r, o, !1)
                }
                c.createFromInputFallback = t("value provided is not in a recognized RFC2822 or ISO format. moment construction falls back to js Date(), which is not reliable across all browsers and versions. Non RFC2822/ISO date formats are discouraged and will be removed in an upcoming major release. Please refer to http://momentjs.com/guides/#/warnings/js-date/ for more info.", function (t) {
                    t._d = new Date(t._i + (t._useUTC ? " UTC" : ""))
                }), c.ISO_8601 = function () { }, c.RFC_2822 = function () { };
                var Ee = t("moment().min is deprecated, use moment.max instead. http://momentjs.com/guides/#/warnings/min-max/", function () {
                    var t = Le.apply(null, arguments);
                    return this.isValid() && t.isValid() ? t < this ? this : t : g()
                }),
                    Ne = t("moment().max is deprecated, use moment.min instead. http://momentjs.com/guides/#/warnings/min-max/", function () {
                        var t = Le.apply(null, arguments);
                        return this.isValid() && t.isValid() ? this < t ? this : t : g()
                    });

                function Ue(t, e) {
                    var r, o;
                    if (1 === e.length && s(e[0]) && (e = e[0]), !e.length) return Le();
                    for (r = e[0], o = 1; o < e.length; ++o) e[o].isValid() && !e[o][t](r) || (r = e[o]);
                    return r
                }
                var Ge = ["year", "quarter", "month", "week", "day", "hour", "minute", "second", "millisecond"];

                function Fe(t) {
                    var e = E(t),
                        r = e.year || 0,
                        o = e.quarter || 0,
                        n = e.month || 0,
                        i = e.week || e.isoWeek || 0,
                        s = e.day || 0,
                        a = e.hour || 0,
                        u = e.minute || 0,
                        c = e.second || 0,
                        f = e.millisecond || 0;
                    this._isValid = function (t) {
                        for (var e in t)
                            if (-1 === Ot.call(Ge, e) || null != t[e] && isNaN(t[e])) return !1;
                        for (var r = !1, o = 0; o < Ge.length; ++o)
                            if (t[Ge[o]]) {
                                if (r) return !1;
                                parseFloat(t[Ge[o]]) !== S(t[Ge[o]]) && (r = !0)
                            }
                        return !0
                    }(e), this._milliseconds = +f + 1e3 * c + 6e4 * u + 1e3 * a * 60 * 60, this._days = +s + 7 * i, this._months = +n + 3 * o + 12 * r, this._data = {}, this._locale = le(), this._bubble()
                }

                function je(t) {
                    return t instanceof Fe
                }

                function Ae(t) {
                    return t < 0 ? -1 * Math.round(-1 * t) : Math.round(t)
                }

                function xe(t, r) {
                    H(t, 0, 0, function () {
                        var t = this.utcOffset(),
                            e = "+";
                        return t < 0 && (t = -t, e = "-"), e + F(~~(t / 60), 2) + r + F(~~t % 60, 2)
                    })
                }
                xe("Z", ":"), xe("ZZ", ""), ft("Z", at), ft("ZZ", at), mt(["Z", "ZZ"], function (t, e, r) {
                    r._useUTC = !0, r._tzm = He(at, t)
                });
                var qe = /([\+\-]|\d\d)/gi;

                function He(t, e) {
                    var r = (e || "").match(t);
                    if (null === r) return null;
                    var o = r[r.length - 1] || [],
                        n = (o + "").match(qe) || ["-", 0, 0],
                        i = 60 * n[1] + S(n[2]);
                    return 0 === i ? 0 : "+" === n[0] ? i : -i
                }

                function Ve(t, e) {
                    var r, o;
                    return e._isUTC ? (r = e.clone(), o = (v(t) || f(t) ? t.valueOf() : Le(t).valueOf()) - r.valueOf(), r._d.setTime(r._d.valueOf() + o), c.updateOffset(r, !1), r) : Le(t).local()
                }

                function Ke(t) {
                    return 15 * -Math.round(t._d.getTimezoneOffset() / 15)
                }

                function Ye() {
                    return !!this.isValid() && (this._isUTC && 0 === this._offset)
                }
                c.updateOffset = function () { };
                var We = /^(\-|\+)?(?:(\d*)[. ])?(\d+)\:(\d+)(?:\:(\d+)(\.\d*)?)?$/,
                    Je = /^(-|\+)?P(?:([-+]?[0-9,.]*)Y)?(?:([-+]?[0-9,.]*)M)?(?:([-+]?[0-9,.]*)W)?(?:([-+]?[0-9,.]*)D)?(?:T(?:([-+]?[0-9,.]*)H)?(?:([-+]?[0-9,.]*)M)?(?:([-+]?[0-9,.]*)S)?)?$/;

                function ze(t, e) {
                    var r, o, n, i = t,
                        s = null;
                    return je(t) ? i = {
                        ms: t._milliseconds,
                        d: t._days,
                        M: t._months
                    } : u(t) ? (i = {}, e ? i[e] = t : i.milliseconds = t) : (s = We.exec(t)) ? (r = "-" === s[1] ? -1 : 1, i = {
                        y: 0,
                        d: S(s[Rt]) * r,
                        h: S(s[vt]) * r,
                        m: S(s[wt]) * r,
                        s: S(s[St]) * r,
                        ms: S(Ae(1e3 * s[Mt])) * r
                    }) : (s = Je.exec(t)) ? (r = "-" === s[1] ? -1 : 1, i = {
                        y: Ze(s[2], r),
                        M: Ze(s[3], r),
                        w: Ze(s[4], r),
                        d: Ze(s[5], r),
                        h: Ze(s[6], r),
                        m: Ze(s[7], r),
                        s: Ze(s[8], r)
                    }) : null == i ? i = {} : "object" == typeof i && ("from" in i || "to" in i) && (n = function (t, e) {
                        var r;
                        if (!t.isValid() || !e.isValid()) return {
                            milliseconds: 0,
                            months: 0
                        };
                        e = Ve(e, t), t.isBefore(e) ? r = $e(t, e) : ((r = $e(e, t)).milliseconds = -r.milliseconds, r.months = -r.months);
                        return r
                    }(Le(i.from), Le(i.to)), (i = {}).ms = n.milliseconds, i.M = n.months), o = new Fe(i), je(t) && h(t, "_locale") && (o._locale = t._locale), o
                }

                function Ze(t, e) {
                    var r = t && parseFloat(t.replace(",", "."));
                    return (isNaN(r) ? 0 : r) * e
                }

                function $e(t, e) {
                    var r = {};
                    return r.months = e.month() - t.month() + 12 * (e.year() - t.year()), t.clone().add(r.months, "M").isAfter(e) && --r.months, r.milliseconds = +e - +t.clone().add(r.months, "M"), r
                }

                function Xe(o, n) {
                    return function (t, e) {
                        var r;
                        return null === e || isNaN(+e) || (T(n, "moment()." + n + "(period, number) is deprecated. Please use moment()." + n + "(number, period). See http://momentjs.com/guides/#/warnings/add-inverted-param/ for more info."), r = t, t = e, e = r), Qe(this, ze(t = "string" == typeof t ? +t : t, e), o), this
                    }
                }

                function Qe(t, e, r, o) {
                    var n = e._milliseconds,
                        i = Ae(e._days),
                        s = Ae(e._months);
                    t.isValid() && (o = null == o || o, s && Ft(t, Ct(t, "Month") + s * r), i && kt(t, "Date", Ct(t, "Date") + i * r), n && t._d.setTime(t._d.valueOf() + n * r), o && c.updateOffset(t, i || s))
                }
                ze.fn = Fe.prototype, ze.invalid = function () {
                    return ze(NaN)
                };
                var tr = Xe(1, "add"),
                    er = Xe(-1, "subtract");

                function rr(t, e) {
                    var r, o, n = 12 * (e.year() - t.year()) + (e.month() - t.month()),
                        i = t.clone().add(n, "months");
                    return o = e - i < 0 ? (r = t.clone().add(n - 1, "months"), (e - i) / (i - r)) : (r = t.clone().add(1 + n, "months"), (e - i) / (r - i)), -(n + o) || 0
                }

                function or(t) {
                    var e;
                    return void 0 === t ? this._locale._abbr : (null != (e = le(t)) && (this._locale = e), this)
                }
                c.defaultFormat = "YYYY-MM-DDTHH:mm:ssZ", c.defaultFormatUtc = "YYYY-MM-DDTHH:mm:ss[Z]";
                var nr = t("moment().lang() is deprecated. Instead, use moment().localeData() to get the language configuration. Use moment().locale() to change languages.", function (t) {
                    return void 0 === t ? this.localeData() : this.locale(t)
                });

                function ir() {
                    return this._locale
                }
                var sr = 126227808e5;

                function ar(t, e) {
                    return (t % e + e) % e
                }

                function ur(t, e, r) {
                    return t < 100 && 0 <= t ? new Date(t + 400, e, r) - sr : new Date(t, e, r).valueOf()
                }

                function cr(t, e, r) {
                    return t < 100 && 0 <= t ? Date.UTC(t + 400, e, r) - sr : Date.UTC(t, e, r)
                }

                function fr(t, e) {
                    H(0, [t, t.length], 0, e)
                }

                function hr(t, e, r, o, n) {
                    var i;
                    return null == t ? Yt(this, o, n).year : ((i = Wt(t, o, n)) < e && (e = i), function (t, e, r, o, n) {
                        var i = Kt(t, e, r, o, n),
                            s = Ht(i.year, 0, i.dayOfYear);
                        return this.year(s.getUTCFullYear()), this.month(s.getUTCMonth()), this.date(s.getUTCDate()), this
                    }.call(this, t, e, r, o, n))
                }
                H(0, ["gg", 2], 0, function () {
                    return this.weekYear() % 100
                }), H(0, ["GG", 2], 0, function () {
                    return this.isoWeekYear() % 100
                }), fr("gggg", "weekYear"), fr("ggggg", "weekYear"), fr("GGGG", "isoWeekYear"), fr("GGGGG", "isoWeekYear"), k("weekYear", "gg"), k("isoWeekYear", "GG"), U("weekYear", 1), U("isoWeekYear", 1), ft("G", it), ft("g", it), ft("GG", X, J), ft("gg", X, J), ft("GGGG", rt, Z), ft("gggg", rt, Z), ft("GGGGG", ot, $), ft("ggggg", ot, $), lt(["gggg", "ggggg", "GGGG", "GGGGG"], function (t, e, r, o) {
                    e[o.substr(0, 2)] = S(t)
                }), lt(["gg", "GG"], function (t, e, r, o) {
                    e[o] = c.parseTwoDigitYear(t)
                }), H("Q", 0, "Qo", "quarter"), k("quarter", "Q"), U("quarter", 7), ft("Q", W), mt("Q", function (t, e) {
                    e[_t] = 3 * (S(t) - 1)
                }), H("D", ["DD", 2], "Do", "date"), k("date", "D"), U("date", 9), ft("D", X), ft("DD", X, J), ft("Do", function (t, e) {
                    return t ? e._dayOfMonthOrdinalParse || e._ordinalParse : e._dayOfMonthOrdinalParseLenient
                }), mt(["D", "DD"], Rt), mt("Do", function (t, e) {
                    e[Rt] = S(t.match(X)[0])
                });
                var pr = Pt("Date", !0);
                H("DDD", ["DDDD", 3], "DDDo", "dayOfYear"), k("dayOfYear", "DDD"), U("dayOfYear", 4), ft("DDD", et), ft("DDDD", z), mt(["DDD", "DDDD"], function (t, e, r) {
                    r._dayOfYear = S(t)
                }), H("m", ["mm", 2], 0, "minute"), k("minute", "m"), U("minute", 14), ft("m", X), ft("mm", X, J), mt(["m", "mm"], wt);
                var dr = Pt("Minutes", !1);
                H("s", ["ss", 2], 0, "second"), k("second", "s"), U("second", 15), ft("s", X), ft("ss", X, J), mt(["s", "ss"], St);
                var mr, lr = Pt("Seconds", !1);
                for (H("S", 0, 0, function () {
                    return ~~(this.millisecond() / 100)
                }), H(0, ["SS", 2], 0, function () {
                    return ~~(this.millisecond() / 10)
                }), H(0, ["SSS", 3], 0, "millisecond"), H(0, ["SSSS", 4], 0, function () {
                    return 10 * this.millisecond()
                }), H(0, ["SSSSS", 5], 0, function () {
                    return 100 * this.millisecond()
                }), H(0, ["SSSSSS", 6], 0, function () {
                    return 1e3 * this.millisecond()
                }), H(0, ["SSSSSSS", 7], 0, function () {
                    return 1e4 * this.millisecond()
                }), H(0, ["SSSSSSSS", 8], 0, function () {
                    return 1e5 * this.millisecond()
                }), H(0, ["SSSSSSSSS", 9], 0, function () {
                    return 1e6 * this.millisecond()
                }), k("millisecond", "ms"), U("millisecond", 16), ft("S", et, W), ft("SS", et, J), ft("SSS", et, z), mr = "SSSS"; mr.length <= 9; mr += "S") ft(mr, nt);

                function gr(t, e) {
                    e[Mt] = S(1e3 * ("0." + t))
                }
                for (mr = "S"; mr.length <= 9; mr += "S") mt(mr, gr);
                var yr = Pt("Milliseconds", !1);
                H("z", 0, 0, "zoneAbbr"), H("zz", 0, 0, "zoneName");
                var _r = R.prototype;

                function Rr(t) {
                    return t
                }
                _r.add = tr, _r.calendar = function (t, e) {
                    var r = t || Le(),
                        o = Ve(r, this).startOf("day"),
                        n = c.calendarFormat(this, o) || "sameElse",
                        i = e && (O(e[n]) ? e[n].call(this, r) : e[n]);
                    return this.format(i || this.localeData().calendar(n, this, Le(r)))
                }, _r.clone = function () {
                    return new R(this)
                }, _r.diff = function (t, e, r) {
                    var o, n, i;
                    if (!this.isValid()) return NaN;
                    if (!(o = Ve(t, this)).isValid()) return NaN;
                    switch (n = 6e4 * (o.utcOffset() - this.utcOffset()), e = L(e)) {
                        case "year":
                            i = rr(this, o) / 12;
                            break;
                        case "month":
                            i = rr(this, o);
                            break;
                        case "quarter":
                            i = rr(this, o) / 3;
                            break;
                        case "second":
                            i = (this - o) / 1e3;
                            break;
                        case "minute":
                            i = (this - o) / 6e4;
                            break;
                        case "hour":
                            i = (this - o) / 36e5;
                            break;
                        case "day":
                            i = (this - o - n) / 864e5;
                            break;
                        case "week":
                            i = (this - o - n) / 6048e5;
                            break;
                        default:
                            i = this - o
                    }
                    return r ? i : w(i)
                }, _r.endOf = function (t) {
                    var e;
                    if (void 0 === (t = L(t)) || "millisecond" === t || !this.isValid()) return this;
                    var r = this._isUTC ? cr : ur;
                    switch (t) {
                        case "year":
                            e = r(this.year() + 1, 0, 1) - 1;
                            break;
                        case "quarter":
                            e = r(this.year(), this.month() - this.month() % 3 + 3, 1) - 1;
                            break;
                        case "month":
                            e = r(this.year(), this.month() + 1, 1) - 1;
                            break;
                        case "week":
                            e = r(this.year(), this.month(), this.date() - this.weekday() + 7) - 1;
                            break;
                        case "isoWeek":
                            e = r(this.year(), this.month(), this.date() - (this.isoWeekday() - 1) + 7) - 1;
                            break;
                        case "day":
                        case "date":
                            e = r(this.year(), this.month(), this.date() + 1) - 1;
                            break;
                        case "hour":
                            e = this._d.valueOf(), e += 36e5 - ar(e + (this._isUTC ? 0 : 6e4 * this.utcOffset()), 36e5) - 1;
                            break;
                        case "minute":
                            e = this._d.valueOf(), e += 6e4 - ar(e, 6e4) - 1;
                            break;
                        case "second":
                            e = this._d.valueOf(), e += 1e3 - ar(e, 1e3) - 1
                    }
                    return this._d.setTime(e), c.updateOffset(this, !0), this
                }, _r.format = function (t) {
                    t = t || (this.isUtc() ? c.defaultFormatUtc : c.defaultFormat);
                    var e = K(this, t);
                    return this.localeData().postformat(e)
                }, _r.from = function (t, e) {
                    return this.isValid() && (v(t) && t.isValid() || Le(t).isValid()) ? ze({
                        to: this,
                        from: t
                    }).locale(this.locale()).humanize(!e) : this.localeData().invalidDate()
                }, _r.fromNow = function (t) {
                    return this.from(Le(), t)
                }, _r.to = function (t, e) {
                    return this.isValid() && (v(t) && t.isValid() || Le(t).isValid()) ? ze({
                        from: this,
                        to: t
                    }).locale(this.locale()).humanize(!e) : this.localeData().invalidDate()
                }, _r.toNow = function (t) {
                    return this.to(Le(), t)
                }, _r.get = function (t) {
                    if (O(this[t = L(t)])) return this[t]();
                    return this
                }, _r.invalidAt = function () {
                    return m(this).overflow
                }, _r.isAfter = function (t, e) {
                    var r = v(t) ? t : Le(t);
                    if (!this.isValid() || !r.isValid()) return !1;
                    return "millisecond" === (e = L(e) || "millisecond") ? this.valueOf() > r.valueOf() : r.valueOf() < this.clone().startOf(e).valueOf()
                }, _r.isBefore = function (t, e) {
                    var r = v(t) ? t : Le(t);
                    if (!this.isValid() || !r.isValid()) return !1;
                    return "millisecond" === (e = L(e) || "millisecond") ? this.valueOf() < r.valueOf() : this.clone().endOf(e).valueOf() < r.valueOf()
                }, _r.isBetween = function (t, e, r, o) {
                    var n = v(t) ? t : Le(t),
                        i = v(e) ? e : Le(e);
                    return !!(this.isValid() && n.isValid() && i.isValid()) && (("(" === (o = o || "()")[0] ? this.isAfter(n, r) : !this.isBefore(n, r)) && (")" === o[1] ? this.isBefore(i, r) : !this.isAfter(i, r)))
                }, _r.isSame = function (t, e) {
                    var r, o = v(t) ? t : Le(t);
                    if (!this.isValid() || !o.isValid()) return !1;
                    return "millisecond" === (e = L(e) || "millisecond") ? this.valueOf() === o.valueOf() : (r = o.valueOf(), this.clone().startOf(e).valueOf() <= r && r <= this.clone().endOf(e).valueOf())
                }, _r.isSameOrAfter = function (t, e) {
                    return this.isSame(t, e) || this.isAfter(t, e)
                }, _r.isSameOrBefore = function (t, e) {
                    return this.isSame(t, e) || this.isBefore(t, e)
                }, _r.isValid = function () {
                    return l(this)
                }, _r.lang = nr, _r.locale = or, _r.localeData = ir, _r.max = Ne, _r.min = Ee, _r.parsingFlags = function () {
                    return p({}, m(this))
                }, _r.set = function (t, e) {
                    if ("object" == typeof t)
                        for (var r = G(t = E(t)), o = 0; o < r.length; o++) this[r[o].unit](t[r[o].unit]);
                    else if (O(this[t = L(t)])) return this[t](e);
                    return this
                }, _r.startOf = function (t) {
                    var e;
                    if (void 0 === (t = L(t)) || "millisecond" === t || !this.isValid()) return this;
                    var r = this._isUTC ? cr : ur;
                    switch (t) {
                        case "year":
                            e = r(this.year(), 0, 1);
                            break;
                        case "quarter":
                            e = r(this.year(), this.month() - this.month() % 3, 1);
                            break;
                        case "month":
                            e = r(this.year(), this.month(), 1);
                            break;
                        case "week":
                            e = r(this.year(), this.month(), this.date() - this.weekday());
                            break;
                        case "isoWeek":
                            e = r(this.year(), this.month(), this.date() - (this.isoWeekday() - 1));
                            break;
                        case "day":
                        case "date":
                            e = r(this.year(), this.month(), this.date());
                            break;
                        case "hour":
                            e = this._d.valueOf(), e -= ar(e + (this._isUTC ? 0 : 6e4 * this.utcOffset()), 36e5);
                            break;
                        case "minute":
                            e = this._d.valueOf(), e -= ar(e, 6e4);
                            break;
                        case "second":
                            e = this._d.valueOf(), e -= ar(e, 1e3)
                    }
                    return this._d.setTime(e), c.updateOffset(this, !0), this
                }, _r.subtract = er, _r.toArray = function () {
                    return [this.year(), this.month(), this.date(), this.hour(), this.minute(), this.second(), this.millisecond()]
                }, _r.toObject = function () {
                    return {
                        years: this.year(),
                        months: this.month(),
                        date: this.date(),
                        hours: this.hours(),
                        minutes: this.minutes(),
                        seconds: this.seconds(),
                        milliseconds: this.milliseconds()
                    }
                }, _r.toDate = function () {
                    return new Date(this.valueOf())
                }, _r.toISOString = function (t) {
                    if (!this.isValid()) return null;
                    var e = !0 !== t,
                        r = e ? this.clone().utc() : this;
                    if (r.year() < 0 || 9999 < r.year()) return K(r, e ? "YYYYYY-MM-DD[T]HH:mm:ss.SSS[Z]" : "YYYYYY-MM-DD[T]HH:mm:ss.SSSZ");
                    if (O(Date.prototype.toISOString)) return e ? this.toDate().toISOString() : new Date(this.valueOf() + 60 * this.utcOffset() * 1e3).toISOString().replace("Z", K(r, "Z"));
                    return K(r, e ? "YYYY-MM-DD[T]HH:mm:ss.SSS[Z]" : "YYYY-MM-DD[T]HH:mm:ss.SSSZ")
                }, _r.inspect = function () {
                    if (!this.isValid()) return "moment.invalid(/* " + this._i + " */)";
                    var t = "moment",
                        e = "";
                    this.isLocal() || (t = 0 === this.utcOffset() ? "moment.utc" : "moment.parseZone", e = "Z");
                    var r = "[" + t + '("]',
                        o = 0 <= this.year() && this.year() <= 9999 ? "YYYY" : "YYYYYY",
                        n = e + '[")]';
                    return this.format(r + o + "-MM-DD[T]HH:mm:ss.SSS" + n)
                }, _r.toJSON = function () {
                    return this.isValid() ? this.toISOString() : null
                }, _r.toString = function () {
                    return this.clone().locale("en").format("ddd MMM DD YYYY HH:mm:ss [GMT]ZZ")
                }, _r.unix = function () {
                    return Math.floor(this.valueOf() / 1e3)
                }, _r.valueOf = function () {
                    return this._d.valueOf() - 6e4 * (this._offset || 0)
                }, _r.creationData = function () {
                    return {
                        input: this._i,
                        format: this._f,
                        locale: this._locale,
                        isUTC: this._isUTC,
                        strict: this._strict
                    }
                }, _r.year = Dt, _r.isLeapYear = function () {
                    return Tt(this.year())
                }, _r.weekYear = function (t) {
                    return hr.call(this, t, this.week(), this.weekday(), this.localeData()._week.dow, this.localeData()._week.doy)
                }, _r.isoWeekYear = function (t) {
                    return hr.call(this, t, this.isoWeek(), this.isoWeekday(), 1, 4)
                }, _r.quarter = _r.quarters = function (t) {
                    return null == t ? Math.ceil((this.month() + 1) / 3) : this.month(3 * (t - 1) + this.month() % 3)
                }, _r.month = jt, _r.daysInMonth = function () {
                    return Lt(this.year(), this.month())
                }, _r.week = _r.weeks = function (t) {
                    var e = this.localeData().week(this);
                    return null == t ? e : this.add(7 * (t - e), "d")
                }, _r.isoWeek = _r.isoWeeks = function (t) {
                    var e = Yt(this, 1, 4).week;
                    return null == t ? e : this.add(7 * (t - e), "d")
                }, _r.weeksInYear = function () {
                    var t = this.localeData()._week;
                    return Wt(this.year(), t.dow, t.doy)
                }, _r.isoWeeksInYear = function () {
                    return Wt(this.year(), 1, 4)
                }, _r.date = pr, _r.day = _r.days = function (t) {
                    if (!this.isValid()) return null != t ? this : NaN;
                    var e = this._isUTC ? this._d.getUTCDay() : this._d.getDay();
                    return null != t ? (r = t, o = this.localeData(), t = "string" == typeof r ? isNaN(r) ? "number" != typeof (r = o.weekdaysParse(r)) ? null : r : parseInt(r, 10) : r, this.add(t - e, "d")) : e;
                    var r, o
                }, _r.weekday = function (t) {
                    if (!this.isValid()) return null != t ? this : NaN;
                    var e = (this.day() + 7 - this.localeData()._week.dow) % 7;
                    return null == t ? e : this.add(t - e, "d")
                }, _r.isoWeekday = function (t) {
                    if (!this.isValid()) return null != t ? this : NaN; {
                        if (null == t) return this.day() || 7;
                        var e = (r = t, o = this.localeData(), "string" != typeof r ? isNaN(r) ? null : r : o.weekdaysParse(r) % 7 || 7);
                        return this.day(this.day() % 7 ? e : e - 7)
                    }
                    var r, o
                }, _r.dayOfYear = function (t) {
                    var e = Math.round((this.clone().startOf("day") - this.clone().startOf("year")) / 864e5) + 1;
                    return null == t ? e : this.add(t - e, "d")
                }, _r.hour = _r.hours = ae, _r.minute = _r.minutes = dr, _r.second = _r.seconds = lr, _r.millisecond = _r.milliseconds = yr, _r.utcOffset = function (t, e, r) {
                    var o, n = this._offset || 0;
                    if (!this.isValid()) return null != t ? this : NaN; {
                        if (null == t) return this._isUTC ? n : Ke(this);
                        if ("string" == typeof t) {
                            if (null === (t = He(at, t))) return this
                        } else Math.abs(t) < 16 && !r && (t *= 60);
                        return !this._isUTC && e && (o = Ke(this)), this._offset = t, this._isUTC = !0, null != o && this.add(o, "m"), n !== t && (!e || this._changeInProgress ? Qe(this, ze(t - n, "m"), 1, !1) : this._changeInProgress || (this._changeInProgress = !0, c.updateOffset(this, !0), this._changeInProgress = null)), this
                    }
                }, _r.utc = function (t) {
                    return this.utcOffset(0, t)
                }, _r.local = function (t) {
                    this._isUTC && (this.utcOffset(0, t), this._isUTC = !1, t && this.subtract(Ke(this), "m"));
                    return this
                }, _r.parseZone = function () {
                    if (null != this._tzm) this.utcOffset(this._tzm, !1, !0);
                    else if ("string" == typeof this._i) {
                        var t = He(st, this._i);
                        null != t ? this.utcOffset(t) : this.utcOffset(0, !0)
                    }
                    return this
                }, _r.hasAlignedHourOffset = function (t) {
                    return !!this.isValid() && (t = t ? Le(t).utcOffset() : 0, (this.utcOffset() - t) % 60 == 0)
                }, _r.isDST = function () {
                    return this.utcOffset() > this.clone().month(0).utcOffset() || this.utcOffset() > this.clone().month(5).utcOffset()
                }, _r.isLocal = function () {
                    return !!this.isValid() && !this._isUTC
                }, _r.isUtcOffset = function () {
                    return !!this.isValid() && this._isUTC
                }, _r.isUtc = Ye, _r.isUTC = Ye, _r.zoneAbbr = function () {
                    return this._isUTC ? "UTC" : ""
                }, _r.zoneName = function () {
                    return this._isUTC ? "Coordinated Universal Time" : ""
                }, _r.dates = t("dates accessor is deprecated. Use date instead.", pr), _r.months = t("months accessor is deprecated. Use month instead", jt), _r.years = t("years accessor is deprecated. Use year instead", Dt), _r.zone = t("moment().zone is deprecated, use moment().utcOffset instead. http://momentjs.com/guides/#/warnings/zone/", function (t, e) {
                    return null != t ? ("string" != typeof t && (t = -t), this.utcOffset(t, e), this) : -this.utcOffset()
                }), _r.isDSTShifted = t("isDSTShifted is deprecated. See http://momentjs.com/guides/#/warnings/dst-shifted/ for more information", function () {
                    if (!i(this._isDSTShifted)) return this._isDSTShifted;
                    var t = {};
                    if (_(t, this), (t = Ce(t))._a) {
                        var e = t._isUTC ? d(t._a) : Le(t._a);
                        this._isDSTShifted = this.isValid() && 0 < M(t._a, e.toArray())
                    } else this._isDSTShifted = !1;
                    return this._isDSTShifted
                });
                var vr = P.prototype;

                function wr(t, e, r, o) {
                    var n = le(),
                        i = d().set(o, e);
                    return n[r](i, t)
                }

                function Sr(t, e, r) {
                    if (u(t) && (e = t, t = void 0), t = t || "", null != e) return wr(t, e, r, "month");
                    var o, n = [];
                    for (o = 0; o < 12; o++) n[o] = wr(t, o, r, "month");
                    return n
                }

                function Mr(t, e, r, o) {
                    e = ("boolean" == typeof t ? u(e) && (r = e, e = void 0) : (e = t, t = !1, u(r = e) && (r = e, e = void 0)), e || "");
                    var n, i = le(),
                        s = t ? i._week.dow : 0;
                    if (null != r) return wr(e, (r + s) % 7, o, "day");
                    var a = [];
                    for (n = 0; n < 7; n++) a[n] = wr(e, (n + s) % 7, o, "day");
                    return a
                }
                vr.calendar = function (t, e, r) {
                    var o = this._calendar[t] || this._calendar.sameElse;
                    return O(o) ? o.call(e, r) : o
                }, vr.longDateFormat = function (t) {
                    var e = this._longDateFormat[t],
                        r = this._longDateFormat[t.toUpperCase()];
                    return !e && r ? (this._longDateFormat[t] = r.replace(/MMMM|MM|DD|dddd/g, function (t) {
                        return t.slice(1)
                    }), this._longDateFormat[t]) : e
                }, vr.invalidDate = function () {
                    return this._invalidDate
                }, vr.ordinal = function (t) {
                    return this._ordinal.replace("%d", t)
                }, vr.preparse = Rr, vr.postformat = Rr, vr.relativeTime = function (t, e, r, o) {
                    var n = this._relativeTime[r];
                    return O(n) ? n(t, e, r, o) : n.replace(/%d/i, t)
                }, vr.pastFuture = function (t, e) {
                    var r = this._relativeTime[0 < t ? "future" : "past"];
                    return O(r) ? r(e) : r.replace(/%s/i, e)
                }, vr.set = function (t) {
                    var e, r;
                    for (r in t) O(e = t[r]) ? this[r] = e : this["_" + r] = e;
                    this._config = t, this._dayOfMonthOrdinalParseLenient = new RegExp((this._dayOfMonthOrdinalParse.source || this._ordinalParse.source) + "|" + /\d{1,2}/.source)
                }, vr.months = function (t, e) {
                    return t ? s(this._months) ? this._months[t.month()] : this._months[(this._months.isFormat || Et).test(e) ? "format" : "standalone"][t.month()] : s(this._months) ? this._months : this._months.standalone
                }, vr.monthsShort = function (t, e) {
                    return t ? s(this._monthsShort) ? this._monthsShort[t.month()] : this._monthsShort[Et.test(e) ? "format" : "standalone"][t.month()] : s(this._monthsShort) ? this._monthsShort : this._monthsShort.standalone
                }, vr.monthsParse = function (t, e, r) {
                    var o, n, i;
                    if (this._monthsParseExact) return Gt.call(this, t, e, r);
                    this._monthsParse || (this._monthsParse = [], this._longMonthsParse = [], this._shortMonthsParse = []);
                    for (o = 0; o < 12; o++) {
                        if (n = d([2e3, o]), r && !this._longMonthsParse[o] && (this._longMonthsParse[o] = new RegExp("^" + this.months(n, "").replace(".", "") + "$", "i"), this._shortMonthsParse[o] = new RegExp("^" + this.monthsShort(n, "").replace(".", "") + "$", "i")), r || this._monthsParse[o] || (i = "^" + this.months(n, "") + "|^" + this.monthsShort(n, ""), this._monthsParse[o] = new RegExp(i.replace(".", ""), "i")), r && "MMMM" === e && this._longMonthsParse[o].test(t)) return o;
                        if (r && "MMM" === e && this._shortMonthsParse[o].test(t)) return o;
                        if (!r && this._monthsParse[o].test(t)) return o
                    }
                }, vr.monthsRegex = function (t) {
                    return this._monthsParseExact ? (h(this, "_monthsRegex") || qt.call(this), t ? this._monthsStrictRegex : this._monthsRegex) : (h(this, "_monthsRegex") || (this._monthsRegex = xt), this._monthsStrictRegex && t ? this._monthsStrictRegex : this._monthsRegex)
                }, vr.monthsShortRegex = function (t) {
                    return this._monthsParseExact ? (h(this, "_monthsRegex") || qt.call(this), t ? this._monthsShortStrictRegex : this._monthsShortRegex) : (h(this, "_monthsShortRegex") || (this._monthsShortRegex = At), this._monthsShortStrictRegex && t ? this._monthsShortStrictRegex : this._monthsShortRegex)
                }, vr.week = function (t) {
                    return Yt(t, this._week.dow, this._week.doy).week
                }, vr.firstDayOfYear = function () {
                    return this._week.doy
                }, vr.firstDayOfWeek = function () {
                    return this._week.dow
                }, vr.weekdays = function (t, e) {
                    var r = s(this._weekdays) ? this._weekdays : this._weekdays[t && !0 !== t && this._weekdays.isFormat.test(e) ? "format" : "standalone"];
                    return !0 === t ? Jt(r, this._week.dow) : t ? r[t.day()] : r
                }, vr.weekdaysMin = function (t) {
                    return !0 === t ? Jt(this._weekdaysMin, this._week.dow) : t ? this._weekdaysMin[t.day()] : this._weekdaysMin
                }, vr.weekdaysShort = function (t) {
                    return !0 === t ? Jt(this._weekdaysShort, this._week.dow) : t ? this._weekdaysShort[t.day()] : this._weekdaysShort
                }, vr.weekdaysParse = function (t, e, r) {
                    var o, n, i;
                    if (this._weekdaysParseExact) return Xt.call(this, t, e, r);
                    this._weekdaysParse || (this._weekdaysParse = [], this._minWeekdaysParse = [], this._shortWeekdaysParse = [], this._fullWeekdaysParse = []);
                    for (o = 0; o < 7; o++) {
                        if (n = d([2e3, 1]).day(o), r && !this._fullWeekdaysParse[o] && (this._fullWeekdaysParse[o] = new RegExp("^" + this.weekdays(n, "").replace(".", "\\.?") + "$", "i"), this._shortWeekdaysParse[o] = new RegExp("^" + this.weekdaysShort(n, "").replace(".", "\\.?") + "$", "i"), this._minWeekdaysParse[o] = new RegExp("^" + this.weekdaysMin(n, "").replace(".", "\\.?") + "$", "i")), this._weekdaysParse[o] || (i = "^" + this.weekdays(n, "") + "|^" + this.weekdaysShort(n, "") + "|^" + this.weekdaysMin(n, ""), this._weekdaysParse[o] = new RegExp(i.replace(".", ""), "i")), r && "dddd" === e && this._fullWeekdaysParse[o].test(t)) return o;
                        if (r && "ddd" === e && this._shortWeekdaysParse[o].test(t)) return o;
                        if (r && "dd" === e && this._minWeekdaysParse[o].test(t)) return o;
                        if (!r && this._weekdaysParse[o].test(t)) return o
                    }
                }, vr.weekdaysRegex = function (t) {
                    return this._weekdaysParseExact ? (h(this, "_weekdaysRegex") || re.call(this), t ? this._weekdaysStrictRegex : this._weekdaysRegex) : (h(this, "_weekdaysRegex") || (this._weekdaysRegex = Qt), this._weekdaysStrictRegex && t ? this._weekdaysStrictRegex : this._weekdaysRegex)
                }, vr.weekdaysShortRegex = function (t) {
                    return this._weekdaysParseExact ? (h(this, "_weekdaysRegex") || re.call(this), t ? this._weekdaysShortStrictRegex : this._weekdaysShortRegex) : (h(this, "_weekdaysShortRegex") || (this._weekdaysShortRegex = te), this._weekdaysShortStrictRegex && t ? this._weekdaysShortStrictRegex : this._weekdaysShortRegex)
                }, vr.weekdaysMinRegex = function (t) {
                    return this._weekdaysParseExact ? (h(this, "_weekdaysRegex") || re.call(this), t ? this._weekdaysMinStrictRegex : this._weekdaysMinRegex) : (h(this, "_weekdaysMinRegex") || (this._weekdaysMinRegex = ee), this._weekdaysMinStrictRegex && t ? this._weekdaysMinStrictRegex : this._weekdaysMinRegex)
                }, vr.isPM = function (t) {
                    return "p" === (t + "").toLowerCase().charAt(0)
                }, vr.meridiem = function (t, e, r) {
                    return 11 < t ? r ? "pm" : "PM" : r ? "am" : "AM"
                }, de("en", {
                    dayOfMonthOrdinalParse: /\d{1,2}(th|st|nd|rd)/,
                    ordinal: function (t) {
                        var e = t % 10,
                            r = 1 === S(t % 100 / 10) ? "th" : 1 == e ? "st" : 2 == e ? "nd" : 3 == e ? "rd" : "th";
                        return t + r
                    }
                }), c.lang = t("moment.lang is deprecated. Use moment.locale instead.", de), c.langData = t("moment.langData is deprecated. Use moment.localeData instead.", le);
                var br = Math.abs;

                function Ir(t, e, r, o) {
                    var n = ze(e, r);
                    return t._milliseconds += o * n._milliseconds, t._days += o * n._days, t._months += o * n._months, t._bubble()
                }

                function Br(t) {
                    return t < 0 ? Math.floor(t) : Math.ceil(t)
                }

                function Tr(t) {
                    return 4800 * t / 146097
                }

                function Or(t) {
                    return 146097 * t / 4800
                }

                function Dr(t) {
                    return function () {
                        return this.as(t)
                    }
                }
                var Pr = Dr("ms"),
                    Cr = Dr("s"),
                    kr = Dr("m"),
                    Lr = Dr("h"),
                    Er = Dr("d"),
                    Nr = Dr("w"),
                    Ur = Dr("M"),
                    Gr = Dr("Q"),
                    Fr = Dr("y");

                function jr(t) {
                    return function () {
                        return this.isValid() ? this._data[t] : NaN
                    }
                }
                var Ar = jr("milliseconds"),
                    xr = jr("seconds"),
                    qr = jr("minutes"),
                    Hr = jr("hours"),
                    Vr = jr("days"),
                    Kr = jr("months"),
                    Yr = jr("years");
                var Wr = Math.round,
                    Jr = {
                        ss: 44,
                        s: 45,
                        m: 45,
                        h: 22,
                        d: 26,
                        M: 11
                    };
                var zr = Math.abs;

                function Zr(t) {
                    return (0 < t) - (t < 0) || +t
                }

                function $r() {
                    if (!this.isValid()) return this.localeData().invalidDate();
                    var t, e, r = zr(this._milliseconds) / 1e3,
                        o = zr(this._days),
                        n = zr(this._months);
                    t = w(r / 60), e = w(t / 60), r %= 60, t %= 60;
                    var i = w(n / 12),
                        s = n %= 12,
                        a = o,
                        u = e,
                        c = t,
                        f = r ? r.toFixed(3).replace(/\.?0+$/, "") : "",
                        h = this.asSeconds();
                    if (!h) return "P0D";
                    var p = h < 0 ? "-" : "",
                        d = Zr(this._months) !== Zr(h) ? "-" : "",
                        m = Zr(this._days) !== Zr(h) ? "-" : "",
                        l = Zr(this._milliseconds) !== Zr(h) ? "-" : "";
                    return p + "P" + (i ? d + i + "Y" : "") + (s ? d + s + "M" : "") + (a ? m + a + "D" : "") + (u || c || f ? "T" : "") + (u ? l + u + "H" : "") + (c ? l + c + "M" : "") + (f ? l + f + "S" : "")
                }
                var Xr = Fe.prototype;
                return Xr.isValid = function () {
                    return this._isValid
                }, Xr.abs = function () {
                    var t = this._data;
                    return this._milliseconds = br(this._milliseconds), this._days = br(this._days), this._months = br(this._months), t.milliseconds = br(t.milliseconds), t.seconds = br(t.seconds), t.minutes = br(t.minutes), t.hours = br(t.hours), t.months = br(t.months), t.years = br(t.years), this
                }, Xr.add = function (t, e) {
                    return Ir(this, t, e, 1)
                }, Xr.subtract = function (t, e) {
                    return Ir(this, t, e, -1)
                }, Xr.as = function (t) {
                    if (!this.isValid()) return NaN;
                    var e, r, o = this._milliseconds;
                    if ("month" === (t = L(t)) || "quarter" === t || "year" === t) switch (e = this._days + o / 864e5, r = this._months + Tr(e), t) {
                        case "month":
                            return r;
                        case "quarter":
                            return r / 3;
                        case "year":
                            return r / 12
                    } else switch (e = this._days + Math.round(Or(this._months)), t) {
                        case "week":
                            return e / 7 + o / 6048e5;
                        case "day":
                            return e + o / 864e5;
                        case "hour":
                            return 24 * e + o / 36e5;
                        case "minute":
                            return 1440 * e + o / 6e4;
                        case "second":
                            return 86400 * e + o / 1e3;
                        case "millisecond":
                            return Math.floor(864e5 * e) + o;
                        default:
                            throw new Error("Unknown unit " + t)
                    }
                }, Xr.asMilliseconds = Pr, Xr.asSeconds = Cr, Xr.asMinutes = kr, Xr.asHours = Lr, Xr.asDays = Er, Xr.asWeeks = Nr, Xr.asMonths = Ur, Xr.asQuarters = Gr, Xr.asYears = Fr, Xr.valueOf = function () {
                    return this.isValid() ? this._milliseconds + 864e5 * this._days + this._months % 12 * 2592e6 + 31536e6 * S(this._months / 12) : NaN
                }, Xr._bubble = function () {
                    var t, e, r, o, n, i = this._milliseconds,
                        s = this._days,
                        a = this._months,
                        u = this._data;
                    return 0 <= i && 0 <= s && 0 <= a || i <= 0 && s <= 0 && a <= 0 || (i += 864e5 * Br(Or(a) + s), a = s = 0), u.milliseconds = i % 1e3, t = w(i / 1e3), u.seconds = t % 60, e = w(t / 60), u.minutes = e % 60, r = w(e / 60), u.hours = r % 24, s += w(r / 24), n = w(Tr(s)), a += n, s -= Br(Or(n)), o = w(a / 12), a %= 12, u.days = s, u.months = a, u.years = o, this
                }, Xr.clone = function () {
                    return ze(this)
                }, Xr.get = function (t) {
                    return t = L(t), this.isValid() ? this[t + "s"]() : NaN
                }, Xr.milliseconds = Ar, Xr.seconds = xr, Xr.minutes = qr, Xr.hours = Hr, Xr.days = Vr, Xr.weeks = function () {
                    return w(this.days() / 7)
                }, Xr.months = Kr, Xr.years = Yr, Xr.humanize = function (t) {
                    if (!this.isValid()) return this.localeData().invalidDate();
                    var e = this.localeData(),
                        r = function (t, e, r) {
                            var o = ze(t).abs(),
                                n = Wr(o.as("s")),
                                i = Wr(o.as("m")),
                                s = Wr(o.as("h")),
                                a = Wr(o.as("d")),
                                u = Wr(o.as("M")),
                                c = Wr(o.as("y")),
                                f = n <= Jr.ss && ["s", n] || n < Jr.s && ["ss", n] || i <= 1 && ["m"] || i < Jr.m && ["mm", i] || s <= 1 && ["h"] || s < Jr.h && ["hh", s] || a <= 1 && ["d"] || a < Jr.d && ["dd", a] || u <= 1 && ["M"] || u < Jr.M && ["MM", u] || c <= 1 && ["y"] || ["yy", c];
                            return f[2] = e, f[3] = 0 < +t, f[4] = r,
                                function (t, e, r, o, n) {
                                    return n.relativeTime(e || 1, !!r, t, o)
                                }.apply(null, f)
                        }(this, !t, e);
                    return t && (r = e.pastFuture(+this, r)), e.postformat(r)
                }, Xr.toISOString = $r, Xr.toString = $r, Xr.toJSON = $r, Xr.locale = or, Xr.localeData = ir, Xr.toIsoString = t("toIsoString() is deprecated. Please use toISOString() instead (notice the capitals)", $r), Xr.lang = nr, H("X", 0, 0, "unix"), H("x", 0, 0, "valueOf"), ft("x", it), ft("X", /[+-]?\d+(\.\d{1,3})?/), mt("X", function (t, e, r) {
                    r._d = new Date(1e3 * parseFloat(t, 10))
                }), mt("x", function (t, e, r) {
                    r._d = new Date(S(t))
                }), c.version = "2.24.0",
                    function (t) {
                        e = t
                    }(Le), c.fn = _r, c.min = function () {
                        return Ue("isBefore", [].slice.call(arguments, 0))
                    }, c.max = function () {
                        return Ue("isAfter", [].slice.call(arguments, 0))
                    }, c.now = function () {
                        return Date.now ? Date.now() : +new Date
                    }, c.utc = d, c.unix = function (t) {
                        return Le(1e3 * t)
                    }, c.months = function (t, e) {
                        return Sr(t, e, "months")
                    }, c.isDate = f, c.locale = de, c.invalid = g, c.duration = ze, c.isMoment = v, c.weekdays = function (t, e, r) {
                        return Mr(t, e, r, "weekdays")
                    }, c.parseZone = function () {
                        return Le.apply(null, arguments).parseZone()
                    }, c.localeData = le, c.isDuration = je, c.monthsShort = function (t, e) {
                        return Sr(t, e, "monthsShort")
                    }, c.weekdaysMin = function (t, e, r) {
                        return Mr(t, e, r, "weekdaysMin")
                    }, c.defineLocale = me, c.updateLocale = function (t, e) {
                        if (null != e) {
                            var r, o, n = ue;
                            null != (o = pe(t)) && (n = o._config), e = D(n, e), (r = new P(e)).parentLocale = ce[t], ce[t] = r, de(t)
                        } else null != ce[t] && (null != ce[t].parentLocale ? ce[t] = ce[t].parentLocale : null != ce[t] && delete ce[t]);
                        return ce[t]
                    }, c.locales = function () {
                        return I(ce)
                    }, c.weekdaysShort = function (t, e, r) {
                        return Mr(t, e, r, "weekdaysShort")
                    }, c.normalizeUnits = L, c.relativeTimeRounding = function (t) {
                        return void 0 !== t ? "function" == typeof t && (Wr = t, !0) : Wr
                    }, c.relativeTimeThreshold = function (t, e) {
                        return void 0 !== Jr[t] && (void 0 === e ? Jr[t] : (Jr[t] = e, "s" === t && (Jr.ss = e - 1), !0))
                    }, c.calendarFormat = function (t, e) {
                        var r = t.diff(e, "days", !0);
                        return r < -6 ? "sameElse" : r < -1 ? "lastWeek" : r < 0 ? "lastDay" : r < 1 ? "sameDay" : r < 2 ? "nextDay" : r < 7 ? "nextWeek" : "sameElse"
                    }, c.prototype = _r, c.HTML5_FMT = {
                        DATETIME_LOCAL: "YYYY-MM-DDTHH:mm",
                        DATETIME_LOCAL_SECONDS: "YYYY-MM-DDTHH:mm:ss",
                        DATETIME_LOCAL_MS: "YYYY-MM-DDTHH:mm:ss.SSS",
                        DATE: "YYYY-MM-DD",
                        TIME: "HH:mm",
                        TIME_SECONDS: "HH:mm:ss",
                        TIME_MS: "HH:mm:ss.SSS",
                        WEEK: "GGGG-[W]WW",
                        MONTH: "YYYY-MM"
                    }, c
            }()
        }),
        ZR = {
            searchParams: "URLSearchParams" in self,
            iterable: "Symbol" in self && "iterator" in Symbol,
            blob: "FileReader" in self && "Blob" in self && function () {
                try {
                    return new Blob, !0
                } catch (t) {
                    return !1
                }
            }(),
            formData: "FormData" in self,
            arrayBuffer: "ArrayBuffer" in self
        };
    if (ZR.arrayBuffer) var $R = ["[object Int8Array]", "[object Uint8Array]", "[object Uint8ClampedArray]", "[object Int16Array]", "[object Uint16Array]", "[object Int32Array]", "[object Uint32Array]", "[object Float32Array]", "[object Float64Array]"],
        XR = ArrayBuffer.isView || function (t) {
            return t && -1 < $R.indexOf(Object.prototype.toString.call(t))
        };

    function QR(t) {
        if ("string" != typeof t && (t = String(t)), /[^a-z0-9\-#$%&'*+.^_`|~]/i.test(t)) throw new TypeError("Invalid character in header field name");
        return t.toLowerCase()
    }

    function tv(t) {
        return "string" != typeof t && (t = String(t)), t
    }

    function ev(e) {
        var t = {
            next: function () {
                var t = e.shift();
                return {
                    done: void 0 === t,
                    value: t
                }
            }
        };
        return ZR.iterable && (t[Symbol.iterator] = function () {
            return t
        }), t
    }

    function rv(e) {
        this.map = {}, e instanceof rv ? e.forEach(function (t, e) {
            this.append(e, t)
        }, this) : Array.isArray(e) ? e.forEach(function (t) {
            this.append(t[0], t[1])
        }, this) : e && Object.getOwnPropertyNames(e).forEach(function (t) {
            this.append(t, e[t])
        }, this)
    }

    function ov(t) {
        if (t.bodyUsed) return Promise.reject(new TypeError("Already read"));
        t.bodyUsed = !0
    }

    function nv(r) {
        return new Promise(function (t, e) {
            r.onload = function () {
                t(r.result)
            }, r.onerror = function () {
                e(r.error)
            }
        })
    }

    function iv(t) {
        var e = new FileReader,
            r = nv(e);
        return e.readAsArrayBuffer(t), r
    }

    function sv(t) {
        if (t.slice) return t.slice(0);
        var e = new Uint8Array(t.byteLength);
        return e.set(new Uint8Array(t)), e.buffer
    }

    function av() {
        return this.bodyUsed = !1, this._initBody = function (t) {
            (this._bodyInit = t) ? "string" == typeof t ? this._bodyText = t : ZR.blob && Blob.prototype.isPrototypeOf(t) ? this._bodyBlob = t : ZR.formData && FormData.prototype.isPrototypeOf(t) ? this._bodyFormData = t : ZR.searchParams && URLSearchParams.prototype.isPrototypeOf(t) ? this._bodyText = t.toString() : ZR.arrayBuffer && ZR.blob && function (t) {
                return t && DataView.prototype.isPrototypeOf(t)
            }(t) ? (this._bodyArrayBuffer = sv(t.buffer), this._bodyInit = new Blob([this._bodyArrayBuffer])) : ZR.arrayBuffer && (ArrayBuffer.prototype.isPrototypeOf(t) || XR(t)) ? this._bodyArrayBuffer = sv(t) : this._bodyText = t = Object.prototype.toString.call(t) : this._bodyText = "", this.headers.get("content-type") || ("string" == typeof t ? this.headers.set("content-type", "text/plain;charset=UTF-8") : this._bodyBlob && this._bodyBlob.type ? this.headers.set("content-type", this._bodyBlob.type) : ZR.searchParams && URLSearchParams.prototype.isPrototypeOf(t) && this.headers.set("content-type", "application/x-www-form-urlencoded;charset=UTF-8"))
        }, ZR.blob && (this.blob = function () {
            var t = ov(this);
            if (t) return t;
            if (this._bodyBlob) return Promise.resolve(this._bodyBlob);
            if (this._bodyArrayBuffer) return Promise.resolve(new Blob([this._bodyArrayBuffer]));
            if (this._bodyFormData) throw new Error("could not read FormData body as blob");
            return Promise.resolve(new Blob([this._bodyText]))
        }, this.arrayBuffer = function () {
            return this._bodyArrayBuffer ? ov(this) || Promise.resolve(this._bodyArrayBuffer) : this.blob().then(iv)
        }), this.text = function () {
            var t = ov(this);
            if (t) return t;
            if (this._bodyBlob) return function (t) {
                var e = new FileReader,
                    r = nv(e);
                return e.readAsText(t), r
            }(this._bodyBlob);
            if (this._bodyArrayBuffer) return Promise.resolve(function (t) {
                for (var e = new Uint8Array(t), r = new Array(e.length), o = 0; o < e.length; o++) r[o] = String.fromCharCode(e[o]);
                return r.join("")
            }(this._bodyArrayBuffer));
            if (this._bodyFormData) throw new Error("could not read FormData body as text");
            return Promise.resolve(this._bodyText)
        }, ZR.formData && (this.formData = function () {
            return this.text().then(fv)
        }), this.json = function () {
            return this.text().then(JSON.parse)
        }, this
    }
    rv.prototype.append = function (t, e) {
        t = QR(t), e = tv(e);
        var r = this.map[t];
        this.map[t] = r ? r + ", " + e : e
    }, rv.prototype.delete = function (t) {
        delete this.map[QR(t)]
    }, rv.prototype.get = function (t) {
        return t = QR(t), this.has(t) ? this.map[t] : null
    }, rv.prototype.has = function (t) {
        return this.map.hasOwnProperty(QR(t))
    }, rv.prototype.set = function (t, e) {
        this.map[QR(t)] = tv(e)
    }, rv.prototype.forEach = function (t, e) {
        for (var r in this.map) this.map.hasOwnProperty(r) && t.call(e, this.map[r], r, this)
    }, rv.prototype.keys = function () {
        var r = [];
        return this.forEach(function (t, e) {
            r.push(e)
        }), ev(r)
    }, rv.prototype.values = function () {
        var e = [];
        return this.forEach(function (t) {
            e.push(t)
        }), ev(e)
    }, rv.prototype.entries = function () {
        var r = [];
        return this.forEach(function (t, e) {
            r.push([e, t])
        }), ev(r)
    }, ZR.iterable && (rv.prototype[Symbol.iterator] = rv.prototype.entries);
    var uv = ["DELETE", "GET", "HEAD", "OPTIONS", "POST", "PUT"];

    function cv(t, e) {
        var r = (e = e || {}).body;
        if (t instanceof cv) {
            if (t.bodyUsed) throw new TypeError("Already read");
            this.url = t.url, this.credentials = t.credentials, e.headers || (this.headers = new rv(t.headers)), this.method = t.method, this.mode = t.mode, this.signal = t.signal, r || null == t._bodyInit || (r = t._bodyInit, t.bodyUsed = !0)
        } else this.url = String(t);
        if (this.credentials = e.credentials || this.credentials || "same-origin", !e.headers && this.headers || (this.headers = new rv(e.headers)), this.method = function (t) {
            var e = t.toUpperCase();
            return -1 < uv.indexOf(e) ? e : t
        }(e.method || this.method || "GET"), this.mode = e.mode || this.mode || null, this.signal = e.signal || this.signal, this.referrer = null, ("GET" === this.method || "HEAD" === this.method) && r) throw new TypeError("Body not allowed for GET or HEAD requests");
        this._initBody(r)
    }

    function fv(t) {
        var n = new FormData;
        return t.trim().split("&").forEach(function (t) {
            if (t) {
                var e = t.split("="),
                    r = e.shift().replace(/\+/g, " "),
                    o = e.join("=").replace(/\+/g, " ");
                n.append(decodeURIComponent(r), decodeURIComponent(o))
            }
        }), n
    }

    function hv(t, e) {
        e = e || {}, this.type = "default", this.status = void 0 === e.status ? 200 : e.status, this.ok = 200 <= this.status && this.status < 300, this.statusText = "statusText" in e ? e.statusText : "OK", this.headers = new rv(e.headers), this.url = e.url || "", this._initBody(t)
    }
    cv.prototype.clone = function () {
        return new cv(this, {
            body: this._bodyInit
        })
    }, av.call(cv.prototype), av.call(hv.prototype), hv.prototype.clone = function () {
        return new hv(this._bodyInit, {
            status: this.status,
            statusText: this.statusText,
            headers: new rv(this.headers),
            url: this.url
        })
    }, hv.error = function () {
        var t = new hv(null, {
            status: 0,
            statusText: ""
        });
        return t.type = "error", t
    };
    var pv = [301, 302, 303, 307, 308];
    hv.redirect = function (t, e) {
        if (-1 === pv.indexOf(e)) throw new RangeError("Invalid status code");
        return new hv(null, {
            status: e,
            headers: {
                location: t
            }
        })
    };
    var dv = self.DOMException;
    try {
        new dv
    } catch (t) {
        (dv = function (t, e) {
            this.message = t, this.name = e;
            var r = Error(t);
            this.stack = r.stack
        }).prototype = Object.create(Error.prototype), dv.prototype.constructor = dv
    }

    function mv(i, s) {
        return new Promise(function (r, t) {
            var e = new cv(i, s);
            if (e.signal && e.signal.aborted) return t(new dv("Aborted", "AbortError"));
            var o = new XMLHttpRequest;

            function n() {
                o.abort()
            }
            o.onload = function () {
                var t = {
                    status: o.status,
                    statusText: o.statusText,
                    headers: function (t) {
                        var n = new rv;
                        return t.replace(/\r?\n[\t ]+/g, " ").split(/\r?\n/).forEach(function (t) {
                            var e = t.split(":"),
                                r = e.shift().trim();
                            if (r) {
                                var o = e.join(":").trim();
                                n.append(r, o)
                            }
                        }), n
                    }(o.getAllResponseHeaders() || "")
                };
                t.url = "responseURL" in o ? o.responseURL : t.headers.get("X-Request-URL");
                var e = "response" in o ? o.response : o.responseText;
                r(new hv(e, t))
            }, o.onerror = function () {
                t(new TypeError("Network request failed"))
            }, o.ontimeout = function () {
                t(new TypeError("Network request failed"))
            }, o.onabort = function () {
                t(new dv("Aborted", "AbortError"))
            }, o.open(e.method, e.url, !0), "include" === e.credentials ? o.withCredentials = !0 : "omit" === e.credentials && (o.withCredentials = !1), "responseType" in o && ZR.blob && (o.responseType = "blob"), e.headers.forEach(function (t, e) {
                o.setRequestHeader(e, t)
            }), e.signal && (e.signal.addEventListener("abort", n), o.onreadystatechange = function () {
                4 === o.readyState && e.signal.removeEventListener("abort", n)
            }), o.send(void 0 === e._bodyInit ? null : e._bodyInit)
        })
    }

    function lv(t, e, r, o) {
        mv(t, $l({
            mode: "cors",
            method: "GET"
        }, e)).then(function (t) {
            if (200 === t.status) return t.json();
            throw new Error(t.statusText)
        }).then(function (t) {
            r && r(t)
        }).catch(function (t) {
            o && o(t.message)
        })
    }

    function gv(t, e, r, o) {
        var n = e.data,
            i = function (t, e) {
                var r = {};
                for (var o in t) Object.prototype.hasOwnProperty.call(t, o) && e.indexOf(o) < 0 && (r[o] = t[o]);
                if (null != t && "function" == typeof Object.getOwnPropertySymbols) {
                    var n = 0;
                    for (o = Object.getOwnPropertySymbols(t); n < o.length; n++) e.indexOf(o[n]) < 0 && Object.prototype.propertyIsEnumerable.call(t, o[n]) && (r[o[n]] = t[o[n]])
                }
                return r
            }(e, ["data"]);
        mv(t, $l({
            method: "POST",
            body: JSON.stringify(n)
        }, i)).then(function (t) {
            200 === t.status ? r && r(t.json()) : o("response.status:" + t.status)
        }).catch(function (t) {
            o && o(t.message)
        })
    }
    mv.polyfill = !0, self.fetch || (self.fetch = mv, self.Headers = rv, self.Request = cv, self.Response = hv);
    var yv = (_v.prototype.setOnMessageTimeout = function (t) {
        this.msgTimeoutFunction = t
    }, _v.prototype.registerMsg = function (t) {
        var e = this;
        this.msgHandle.set(t.seqId, {
            timeoutId: setTimeout(function (t) {
                return e.timeout(t)
            }, 2e4, t),
            msg: t
        })
    }, _v.prototype.receiveMsg = function (t) {
        if (this.msgHandle.has(t.seqId)) {
            var e = this.msgHandle.get(t.seqId),
                r = e.timeoutId,
                o = e.msg;
            return clearTimeout(r), o
        }
        return null
    }, _v.prototype.timeout = function (t) {
        console.log("timeout"), this.msgTimeoutFunction && this.msgTimeoutFunction(t)
    }, _v);

    function _v() {
        this.msgHandle = new Map
    }
    var Rv = (vv.prototype.getPrefix = function (t) {
        return "[" + t + "] " + zR().format("YYYY MM DD HH:mm:ss") + " " + this.prefix + " ->"
    }, vv.prototype.info = function () {
        for (var t = [], e = 0; e < arguments.length; e++) t[e] = arguments[e];
        console.info.apply(console, tg([this.getPrefix("info")], t))
    }, vv.prototype.debug = function () {
        for (var t = [], e = 0; e < arguments.length; e++) t[e] = arguments[e];
        console.debug.apply(console, tg([this.getPrefix("debug")], t))
    }, vv.prototype.error = function () {
        for (var t = [], e = 0; e < arguments.length; e++) t[e] = arguments[e];
        console.error.apply(console, tg([this.getPrefix("error")], t))
    }, vv.prototype.warn = function () {
        for (var t = [], e = 0; e < arguments.length; e++) t[e] = arguments[e];
        console.warn.apply(console, tg([this.getPrefix("error")], t))
    }, vv);

    function vv(t) {
        this.prefix = t
    }

    function wv() { }

    function Sv() {
        Sv.init.call(this)
    }

    function Mv(t) {
        return void 0 === t._maxListeners ? Sv.defaultMaxListeners : t._maxListeners
    }

    function bv(t, e, r, o) {
        var n, i, s;
        if ("function" != typeof r) throw new TypeError('"listener" argument must be a function');
        if ((i = t._events) ? (i.newListener && (t.emit("newListener", e, r.listener ? r.listener : r), i = t._events), s = i[e]) : (i = t._events = new wv, t._eventsCount = 0), s) {
            if ("function" == typeof s ? s = i[e] = o ? [r, s] : [s, r] : o ? s.unshift(r) : s.push(r), !s.warned && (n = Mv(t)) && 0 < n && s.length > n) {
                s.warned = !0;
                var a = new Error("Possible EventEmitter memory leak detected. " + s.length + " " + e + " listeners added. Use emitter.setMaxListeners() to increase limit");
                a.name = "MaxListenersExceededWarning", a.emitter = t, a.type = e, a.count = s.length,
                    function (t) {
                        "function" == typeof console.warn ? console.warn(t) : console.log(t)
                    }(a)
            }
        } else s = i[e] = r, ++t._eventsCount;
        return t
    }

    function Iv(t, e, r) {
        var o = !1;

        function n() {
            t.removeListener(e, n), o || (o = !0, r.apply(t, arguments))
        }
        return n.listener = r, n
    }

    function Bv(t) {
        var e = this._events;
        if (e) {
            var r = e[t];
            if ("function" == typeof r) return 1;
            if (r) return r.length
        }
        return 0
    }

    function Tv(t, e) {
        for (var r = new Array(e); e--;) r[e] = t[e];
        return r
    }
    wv.prototype = Object.create(null), (Sv.EventEmitter = Sv).usingDomains = !1, Sv.prototype.domain = void 0, Sv.prototype._events = void 0, Sv.prototype._maxListeners = void 0, Sv.defaultMaxListeners = 10, Sv.init = function () {
        this.domain = null, Sv.usingDomains && (void 0).active && (void 0).Domain, this._events && this._events !== Object.getPrototypeOf(this)._events || (this._events = new wv, this._eventsCount = 0), this._maxListeners = this._maxListeners || void 0
    }, Sv.prototype.setMaxListeners = function (t) {
        if ("number" != typeof t || t < 0 || isNaN(t)) throw new TypeError('"n" argument must be a positive number');
        return this._maxListeners = t, this
    }, Sv.prototype.getMaxListeners = function () {
        return Mv(this)
    }, Sv.prototype.emit = function (t, e, r, o) {
        var n, i, s, a, u, c, f, h = "error" === t;
        if (c = this._events) h = h && null == c.error;
        else if (!h) return !1;
        if (f = this.domain, h) {
            if (n = e, f) return (n = n || new Error('Uncaught, unspecified "error" event')).domainEmitter = this, n.domain = f, n.domainThrown = !1, f.emit("error", n), !1;
            if (n instanceof Error) throw n;
            var p = new Error('Uncaught, unspecified "error" event. (' + n + ")");
            throw p.context = n, p
        }
        if (!(i = c[t])) return !1;
        var d = "function" == typeof i;
        switch (s = arguments.length) {
            case 1:
                ! function (t, e, r) {
                    if (e) t.call(r);
                    else
                        for (var o = t.length, n = Tv(t, o), i = 0; i < o; ++i) n[i].call(r)
                }(i, d, this);
                break;
            case 2:
                ! function (t, e, r, o) {
                    if (e) t.call(r, o);
                    else
                        for (var n = t.length, i = Tv(t, n), s = 0; s < n; ++s) i[s].call(r, o)
                }(i, d, this, e);
                break;
            case 3:
                ! function (t, e, r, o, n) {
                    if (e) t.call(r, o, n);
                    else
                        for (var i = t.length, s = Tv(t, i), a = 0; a < i; ++a) s[a].call(r, o, n)
                }(i, d, this, e, r);
                break;
            case 4:
                ! function (t, e, r, o, n, i) {
                    if (e) t.call(r, o, n, i);
                    else
                        for (var s = t.length, a = Tv(t, s), u = 0; u < s; ++u) a[u].call(r, o, n, i)
                }(i, d, this, e, r, o);
                break;
            default:
                for (a = new Array(s - 1), u = 1; u < s; u++) a[u - 1] = arguments[u];
                ! function (t, e, r, o) {
                    if (e) t.apply(r, o);
                    else
                        for (var n = t.length, i = Tv(t, n), s = 0; s < n; ++s) i[s].apply(r, o)
                }(i, d, this, a)
        }
        return !0
    }, Sv.prototype.on = Sv.prototype.addListener = function (t, e) {
        return bv(this, t, e, !1)
    }, Sv.prototype.prependListener = function (t, e) {
        return bv(this, t, e, !0)
    }, Sv.prototype.once = function (t, e) {
        if ("function" != typeof e) throw new TypeError('"listener" argument must be a function');
        return this.on(t, Iv(this, t, e)), this
    }, Sv.prototype.prependOnceListener = function (t, e) {
        if ("function" != typeof e) throw new TypeError('"listener" argument must be a function');
        return this.prependListener(t, Iv(this, t, e)), this
    }, Sv.prototype.removeListener = function (t, e) {
        var r, o, n, i, s;
        if ("function" != typeof e) throw new TypeError('"listener" argument must be a function');
        if (!(o = this._events)) return this;
        if (!(r = o[t])) return this;
        if (r === e || r.listener && r.listener === e) 0 == --this._eventsCount ? this._events = new wv : (delete o[t], o.removeListener && this.emit("removeListener", t, r.listener || e));
        else if ("function" != typeof r) {
            for (n = -1, i = r.length; 0 < i--;)
                if (r[i] === e || r[i].listener && r[i].listener === e) {
                    s = r[i].listener, n = i;
                    break
                }
            if (n < 0) return this;
            if (1 === r.length) {
                if (r[0] = void 0, 0 == --this._eventsCount) return this._events = new wv, this;
                delete o[t]
            } else ! function (t, e) {
                for (var r = e, o = r + 1, n = t.length; o < n; r += 1, o += 1) t[r] = t[o];
                t.pop()
            }(r, n);
            o.removeListener && this.emit("removeListener", t, s || e)
        }
        return this
    }, Sv.prototype.removeAllListeners = function (t) {
        var e, r;
        if (!(r = this._events)) return this;
        if (!r.removeListener) return 0 === arguments.length ? (this._events = new wv, this._eventsCount = 0) : r[t] && (0 == --this._eventsCount ? this._events = new wv : delete r[t]), this;
        if (0 === arguments.length) {
            for (var o, n = Object.keys(r), i = 0; i < n.length; ++i) "removeListener" !== (o = n[i]) && this.removeAllListeners(o);
            return this.removeAllListeners("removeListener"), this._events = new wv, this._eventsCount = 0, this
        }
        if ("function" == typeof (e = r[t])) this.removeListener(t, e);
        else if (e)
            for (; this.removeListener(t, e[e.length - 1]), e[0];);
        return this
    }, Sv.prototype.listeners = function (t) {
        var e, r = this._events;
        return r && (e = r[t]) ? "function" == typeof e ? [e.listener || e] : function (t) {
            for (var e = new Array(t.length), r = 0; r < e.length; ++r) e[r] = t[r].listener || t[r];
            return e
        }(e) : []
    }, Sv.listenerCount = function (t, e) {
        return "function" == typeof t.listenerCount ? t.listenerCount(e) : Bv.call(t, e)
    }, Sv.prototype.listenerCount = Bv, Sv.prototype.eventNames = function () {
        return 0 < this._eventsCount ? Reflect.ownKeys(this._events) : []
    };
    var Ov = t(function (L, t) {
        ! function () {
            function r(t) {
                return parseInt(t) === t
            }

            function o(t) {
                if (!r(t.length)) return !1;
                for (var e = 0; e < t.length; e++)
                    if (!r(t[e]) || t[e] < 0 || 255 < t[e]) return !1;
                return !0
            }

            function i(t, e) {
                if (t.buffer && "Uint8Array" === t.name) return e && (t = t.slice ? t.slice() : Array.prototype.slice.call(t)), t;
                if (Array.isArray(t)) {
                    if (!o(t)) throw new Error("Array contains invalid value: " + t);
                    return new Uint8Array(t)
                }
                if (r(t.length) && o(t)) return new Uint8Array(t);
                throw new Error("unsupported array-like object")
            }

            function u(t) {
                return new Uint8Array(t)
            }

            function s(t, e, r, o, n) {
                null == o && null == n || (t = t.slice ? t.slice(o, n) : Array.prototype.slice.call(t, o, n)), e.set(t, r)
            }
            var n, t = {
                toBytes: function (t) {
                    var e = [],
                        r = 0;
                    for (t = encodeURI(t); r < t.length;) {
                        var o = t.charCodeAt(r++);
                        37 === o ? (e.push(parseInt(t.substr(r, 2), 16)), r += 2) : e.push(o)
                    }
                    return i(e)
                },
                fromBytes: function (t) {
                    for (var e = [], r = 0; r < t.length;) {
                        var o = t[r];
                        o < 128 ? (e.push(String.fromCharCode(o)), r++) : 191 < o && o < 224 ? (e.push(String.fromCharCode((31 & o) << 6 | 63 & t[r + 1])), r += 2) : (e.push(String.fromCharCode((15 & o) << 12 | (63 & t[r + 1]) << 6 | 63 & t[r + 2])), r += 3)
                    }
                    return e.join("")
                }
            },
                e = (n = "0123456789abcdef", {
                    toBytes: function (t) {
                        for (var e = [], r = 0; r < t.length; r += 2) e.push(parseInt(t.substr(r, 2), 16));
                        return e
                    },
                    fromBytes: function (t) {
                        for (var e = [], r = 0; r < t.length; r++) {
                            var o = t[r];
                            e.push(n[(240 & o) >> 4] + n[15 & o])
                        }
                        return e.join("")
                    }
                }),
                h = {
                    16: 10,
                    24: 12,
                    32: 14
                },
                p = [1, 2, 4, 8, 16, 32, 64, 128, 27, 54, 108, 216, 171, 77, 154, 47, 94, 188, 99, 198, 151, 53, 106, 212, 179, 125, 250, 239, 197, 145],
                d = [99, 124, 119, 123, 242, 107, 111, 197, 48, 1, 103, 43, 254, 215, 171, 118, 202, 130, 201, 125, 250, 89, 71, 240, 173, 212, 162, 175, 156, 164, 114, 192, 183, 253, 147, 38, 54, 63, 247, 204, 52, 165, 229, 241, 113, 216, 49, 21, 4, 199, 35, 195, 24, 150, 5, 154, 7, 18, 128, 226, 235, 39, 178, 117, 9, 131, 44, 26, 27, 110, 90, 160, 82, 59, 214, 179, 41, 227, 47, 132, 83, 209, 0, 237, 32, 252, 177, 91, 106, 203, 190, 57, 74, 76, 88, 207, 208, 239, 170, 251, 67, 77, 51, 133, 69, 249, 2, 127, 80, 60, 159, 168, 81, 163, 64, 143, 146, 157, 56, 245, 188, 182, 218, 33, 16, 255, 243, 210, 205, 12, 19, 236, 95, 151, 68, 23, 196, 167, 126, 61, 100, 93, 25, 115, 96, 129, 79, 220, 34, 42, 144, 136, 70, 238, 184, 20, 222, 94, 11, 219, 224, 50, 58, 10, 73, 6, 36, 92, 194, 211, 172, 98, 145, 149, 228, 121, 231, 200, 55, 109, 141, 213, 78, 169, 108, 86, 244, 234, 101, 122, 174, 8, 186, 120, 37, 46, 28, 166, 180, 198, 232, 221, 116, 31, 75, 189, 139, 138, 112, 62, 181, 102, 72, 3, 246, 14, 97, 53, 87, 185, 134, 193, 29, 158, 225, 248, 152, 17, 105, 217, 142, 148, 155, 30, 135, 233, 206, 85, 40, 223, 140, 161, 137, 13, 191, 230, 66, 104, 65, 153, 45, 15, 176, 84, 187, 22],
                c = [82, 9, 106, 213, 48, 54, 165, 56, 191, 64, 163, 158, 129, 243, 215, 251, 124, 227, 57, 130, 155, 47, 255, 135, 52, 142, 67, 68, 196, 222, 233, 203, 84, 123, 148, 50, 166, 194, 35, 61, 238, 76, 149, 11, 66, 250, 195, 78, 8, 46, 161, 102, 40, 217, 36, 178, 118, 91, 162, 73, 109, 139, 209, 37, 114, 248, 246, 100, 134, 104, 152, 22, 212, 164, 92, 204, 93, 101, 182, 146, 108, 112, 72, 80, 253, 237, 185, 218, 94, 21, 70, 87, 167, 141, 157, 132, 144, 216, 171, 0, 140, 188, 211, 10, 247, 228, 88, 5, 184, 179, 69, 6, 208, 44, 30, 143, 202, 63, 15, 2, 193, 175, 189, 3, 1, 19, 138, 107, 58, 145, 17, 65, 79, 103, 220, 234, 151, 242, 207, 206, 240, 180, 230, 115, 150, 172, 116, 34, 231, 173, 53, 133, 226, 249, 55, 232, 28, 117, 223, 110, 71, 241, 26, 113, 29, 41, 197, 137, 111, 183, 98, 14, 170, 24, 190, 27, 252, 86, 62, 75, 198, 210, 121, 32, 154, 219, 192, 254, 120, 205, 90, 244, 31, 221, 168, 51, 136, 7, 199, 49, 177, 18, 16, 89, 39, 128, 236, 95, 96, 81, 127, 169, 25, 181, 74, 13, 45, 229, 122, 159, 147, 201, 156, 239, 160, 224, 59, 77, 174, 42, 245, 176, 200, 235, 187, 60, 131, 83, 153, 97, 23, 43, 4, 126, 186, 119, 214, 38, 225, 105, 20, 99, 85, 33, 12, 125],
                f = [3328402341, 4168907908, 4000806809, 4135287693, 4294111757, 3597364157, 3731845041, 2445657428, 1613770832, 33620227, 3462883241, 1445669757, 3892248089, 3050821474, 1303096294, 3967186586, 2412431941, 528646813, 2311702848, 4202528135, 4026202645, 2992200171, 2387036105, 4226871307, 1101901292, 3017069671, 1604494077, 1169141738, 597466303, 1403299063, 3832705686, 2613100635, 1974974402, 3791519004, 1033081774, 1277568618, 1815492186, 2118074177, 4126668546, 2211236943, 1748251740, 1369810420, 3521504564, 4193382664, 3799085459, 2883115123, 1647391059, 706024767, 134480908, 2512897874, 1176707941, 2646852446, 806885416, 932615841, 168101135, 798661301, 235341577, 605164086, 461406363, 3756188221, 3454790438, 1311188841, 2142417613, 3933566367, 302582043, 495158174, 1479289972, 874125870, 907746093, 3698224818, 3025820398, 1537253627, 2756858614, 1983593293, 3084310113, 2108928974, 1378429307, 3722699582, 1580150641, 327451799, 2790478837, 3117535592, 0, 3253595436, 1075847264, 3825007647, 2041688520, 3059440621, 3563743934, 2378943302, 1740553945, 1916352843, 2487896798, 2555137236, 2958579944, 2244988746, 3151024235, 3320835882, 1336584933, 3992714006, 2252555205, 2588757463, 1714631509, 293963156, 2319795663, 3925473552, 67240454, 4269768577, 2689618160, 2017213508, 631218106, 1269344483, 2723238387, 1571005438, 2151694528, 93294474, 1066570413, 563977660, 1882732616, 4059428100, 1673313503, 2008463041, 2950355573, 1109467491, 537923632, 3858759450, 4260623118, 3218264685, 2177748300, 403442708, 638784309, 3287084079, 3193921505, 899127202, 2286175436, 773265209, 2479146071, 1437050866, 4236148354, 2050833735, 3362022572, 3126681063, 840505643, 3866325909, 3227541664, 427917720, 2655997905, 2749160575, 1143087718, 1412049534, 999329963, 193497219, 2353415882, 3354324521, 1807268051, 672404540, 2816401017, 3160301282, 369822493, 2916866934, 3688947771, 1681011286, 1949973070, 336202270, 2454276571, 201721354, 1210328172, 3093060836, 2680341085, 3184776046, 1135389935, 3294782118, 965841320, 831886756, 3554993207, 4068047243, 3588745010, 2345191491, 1849112409, 3664604599, 26054028, 2983581028, 2622377682, 1235855840, 3630984372, 2891339514, 4092916743, 3488279077, 3395642799, 4101667470, 1202630377, 268961816, 1874508501, 4034427016, 1243948399, 1546530418, 941366308, 1470539505, 1941222599, 2546386513, 3421038627, 2715671932, 3899946140, 1042226977, 2521517021, 1639824860, 227249030, 260737669, 3765465232, 2084453954, 1907733956, 3429263018, 2420656344, 100860677, 4160157185, 470683154, 3261161891, 1781871967, 2924959737, 1773779408, 394692241, 2579611992, 974986535, 664706745, 3655459128, 3958962195, 731420851, 571543859, 3530123707, 2849626480, 126783113, 865375399, 765172662, 1008606754, 361203602, 3387549984, 2278477385, 2857719295, 1344809080, 2782912378, 59542671, 1503764984, 160008576, 437062935, 1707065306, 3622233649, 2218934982, 3496503480, 2185314755, 697932208, 1512910199, 504303377, 2075177163, 2824099068, 1841019862, 739644986],
                m = [2781242211, 2230877308, 2582542199, 2381740923, 234877682, 3184946027, 2984144751, 1418839493, 1348481072, 50462977, 2848876391, 2102799147, 434634494, 1656084439, 3863849899, 2599188086, 1167051466, 2636087938, 1082771913, 2281340285, 368048890, 3954334041, 3381544775, 201060592, 3963727277, 1739838676, 4250903202, 3930435503, 3206782108, 4149453988, 2531553906, 1536934080, 3262494647, 484572669, 2923271059, 1783375398, 1517041206, 1098792767, 49674231, 1334037708, 1550332980, 4098991525, 886171109, 150598129, 2481090929, 1940642008, 1398944049, 1059722517, 201851908, 1385547719, 1699095331, 1587397571, 674240536, 2704774806, 252314885, 3039795866, 151914247, 908333586, 2602270848, 1038082786, 651029483, 1766729511, 3447698098, 2682942837, 454166793, 2652734339, 1951935532, 775166490, 758520603, 3000790638, 4004797018, 4217086112, 4137964114, 1299594043, 1639438038, 3464344499, 2068982057, 1054729187, 1901997871, 2534638724, 4121318227, 1757008337, 0, 750906861, 1614815264, 535035132, 3363418545, 3988151131, 3201591914, 1183697867, 3647454910, 1265776953, 3734260298, 3566750796, 3903871064, 1250283471, 1807470800, 717615087, 3847203498, 384695291, 3313910595, 3617213773, 1432761139, 2484176261, 3481945413, 283769337, 100925954, 2180939647, 4037038160, 1148730428, 3123027871, 3813386408, 4087501137, 4267549603, 3229630528, 2315620239, 2906624658, 3156319645, 1215313976, 82966005, 3747855548, 3245848246, 1974459098, 1665278241, 807407632, 451280895, 251524083, 1841287890, 1283575245, 337120268, 891687699, 801369324, 3787349855, 2721421207, 3431482436, 959321879, 1469301956, 4065699751, 2197585534, 1199193405, 2898814052, 3887750493, 724703513, 2514908019, 2696962144, 2551808385, 3516813135, 2141445340, 1715741218, 2119445034, 2872807568, 2198571144, 3398190662, 700968686, 3547052216, 1009259540, 2041044702, 3803995742, 487983883, 1991105499, 1004265696, 1449407026, 1316239930, 504629770, 3683797321, 168560134, 1816667172, 3837287516, 1570751170, 1857934291, 4014189740, 2797888098, 2822345105, 2754712981, 936633572, 2347923833, 852879335, 1133234376, 1500395319, 3084545389, 2348912013, 1689376213, 3533459022, 3762923945, 3034082412, 4205598294, 133428468, 634383082, 2949277029, 2398386810, 3913789102, 403703816, 3580869306, 2297460856, 1867130149, 1918643758, 607656988, 4049053350, 3346248884, 1368901318, 600565992, 2090982877, 2632479860, 557719327, 3717614411, 3697393085, 2249034635, 2232388234, 2430627952, 1115438654, 3295786421, 2865522278, 3633334344, 84280067, 33027830, 303828494, 2747425121, 1600795957, 4188952407, 3496589753, 2434238086, 1486471617, 658119965, 3106381470, 953803233, 334231800, 3005978776, 857870609, 3151128937, 1890179545, 2298973838, 2805175444, 3056442267, 574365214, 2450884487, 550103529, 1233637070, 4289353045, 2018519080, 2057691103, 2399374476, 4166623649, 2148108681, 387583245, 3664101311, 836232934, 3330556482, 3100665960, 3280093505, 2955516313, 2002398509, 287182607, 3413881008, 4238890068, 3597515707, 975967766],
                l = [1671808611, 2089089148, 2006576759, 2072901243, 4061003762, 1807603307, 1873927791, 3310653893, 810573872, 16974337, 1739181671, 729634347, 4263110654, 3613570519, 2883997099, 1989864566, 3393556426, 2191335298, 3376449993, 2106063485, 4195741690, 1508618841, 1204391495, 4027317232, 2917941677, 3563566036, 2734514082, 2951366063, 2629772188, 2767672228, 1922491506, 3227229120, 3082974647, 4246528509, 2477669779, 644500518, 911895606, 1061256767, 4144166391, 3427763148, 878471220, 2784252325, 3845444069, 4043897329, 1905517169, 3631459288, 827548209, 356461077, 67897348, 3344078279, 593839651, 3277757891, 405286936, 2527147926, 84871685, 2595565466, 118033927, 305538066, 2157648768, 3795705826, 3945188843, 661212711, 2999812018, 1973414517, 152769033, 2208177539, 745822252, 439235610, 455947803, 1857215598, 1525593178, 2700827552, 1391895634, 994932283, 3596728278, 3016654259, 695947817, 3812548067, 795958831, 2224493444, 1408607827, 3513301457, 0, 3979133421, 543178784, 4229948412, 2982705585, 1542305371, 1790891114, 3410398667, 3201918910, 961245753, 1256100938, 1289001036, 1491644504, 3477767631, 3496721360, 4012557807, 2867154858, 4212583931, 1137018435, 1305975373, 861234739, 2241073541, 1171229253, 4178635257, 33948674, 2139225727, 1357946960, 1011120188, 2679776671, 2833468328, 1374921297, 2751356323, 1086357568, 2408187279, 2460827538, 2646352285, 944271416, 4110742005, 3168756668, 3066132406, 3665145818, 560153121, 271589392, 4279952895, 4077846003, 3530407890, 3444343245, 202643468, 322250259, 3962553324, 1608629855, 2543990167, 1154254916, 389623319, 3294073796, 2817676711, 2122513534, 1028094525, 1689045092, 1575467613, 422261273, 1939203699, 1621147744, 2174228865, 1339137615, 3699352540, 577127458, 712922154, 2427141008, 2290289544, 1187679302, 3995715566, 3100863416, 339486740, 3732514782, 1591917662, 186455563, 3681988059, 3762019296, 844522546, 978220090, 169743370, 1239126601, 101321734, 611076132, 1558493276, 3260915650, 3547250131, 2901361580, 1655096418, 2443721105, 2510565781, 3828863972, 2039214713, 3878868455, 3359869896, 928607799, 1840765549, 2374762893, 3580146133, 1322425422, 2850048425, 1823791212, 1459268694, 4094161908, 3928346602, 1706019429, 2056189050, 2934523822, 135794696, 3134549946, 2022240376, 628050469, 779246638, 472135708, 2800834470, 3032970164, 3327236038, 3894660072, 3715932637, 1956440180, 522272287, 1272813131, 3185336765, 2340818315, 2323976074, 1888542832, 1044544574, 3049550261, 1722469478, 1222152264, 50660867, 4127324150, 236067854, 1638122081, 895445557, 1475980887, 3117443513, 2257655686, 3243809217, 489110045, 2662934430, 3778599393, 4162055160, 2561878936, 288563729, 1773916777, 3648039385, 2391345038, 2493985684, 2612407707, 505560094, 2274497927, 3911240169, 3460925390, 1442818645, 678973480, 3749357023, 2358182796, 2717407649, 2306869641, 219617805, 3218761151, 3862026214, 1120306242, 1756942440, 1103331905, 2578459033, 762796589, 252780047, 2966125488, 1425844308, 3151392187, 372911126],
                g = [1667474886, 2088535288, 2004326894, 2071694838, 4075949567, 1802223062, 1869591006, 3318043793, 808472672, 16843522, 1734846926, 724270422, 4278065639, 3621216949, 2880169549, 1987484396, 3402253711, 2189597983, 3385409673, 2105378810, 4210693615, 1499065266, 1195886990, 4042263547, 2913856577, 3570689971, 2728590687, 2947541573, 2627518243, 2762274643, 1920112356, 3233831835, 3082273397, 4261223649, 2475929149, 640051788, 909531756, 1061110142, 4160160501, 3435941763, 875846760, 2779116625, 3857003729, 4059105529, 1903268834, 3638064043, 825316194, 353713962, 67374088, 3351728789, 589522246, 3284360861, 404236336, 2526454071, 84217610, 2593830191, 117901582, 303183396, 2155911963, 3806477791, 3958056653, 656894286, 2998062463, 1970642922, 151591698, 2206440989, 741110872, 437923380, 454765878, 1852748508, 1515908788, 2694904667, 1381168804, 993742198, 3604373943, 3014905469, 690584402, 3823320797, 791638366, 2223281939, 1398011302, 3520161977, 0, 3991743681, 538992704, 4244381667, 2981218425, 1532751286, 1785380564, 3419096717, 3200178535, 960056178, 1246420628, 1280103576, 1482221744, 3486468741, 3503319995, 4025428677, 2863326543, 4227536621, 1128514950, 1296947098, 859002214, 2240123921, 1162203018, 4193849577, 33687044, 2139062782, 1347481760, 1010582648, 2678045221, 2829640523, 1364325282, 2745433693, 1077985408, 2408548869, 2459086143, 2644360225, 943212656, 4126475505, 3166494563, 3065430391, 3671750063, 555836226, 269496352, 4294908645, 4092792573, 3537006015, 3452783745, 202118168, 320025894, 3974901699, 1600119230, 2543297077, 1145359496, 387397934, 3301201811, 2812801621, 2122220284, 1027426170, 1684319432, 1566435258, 421079858, 1936954854, 1616945344, 2172753945, 1330631070, 3705438115, 572679748, 707427924, 2425400123, 2290647819, 1179044492, 4008585671, 3099120491, 336870440, 3739122087, 1583276732, 185277718, 3688593069, 3772791771, 842159716, 976899700, 168435220, 1229577106, 101059084, 606366792, 1549591736, 3267517855, 3553849021, 2897014595, 1650632388, 2442242105, 2509612081, 3840161747, 2038008818, 3890688725, 3368567691, 926374254, 1835907034, 2374863873, 3587531953, 1313788572, 2846482505, 1819063512, 1448540844, 4109633523, 3941213647, 1701162954, 2054852340, 2930698567, 134748176, 3132806511, 2021165296, 623210314, 774795868, 471606328, 2795958615, 3031746419, 3334885783, 3907527627, 3722280097, 1953799400, 522133822, 1263263126, 3183336545, 2341176845, 2324333839, 1886425312, 1044267644, 3048588401, 1718004428, 1212733584, 50529542, 4143317495, 235803164, 1633788866, 892690282, 1465383342, 3115962473, 2256965911, 3250673817, 488449850, 2661202215, 3789633753, 4177007595, 2560144171, 286339874, 1768537042, 3654906025, 2391705863, 2492770099, 2610673197, 505291324, 2273808917, 3924369609, 3469625735, 1431699370, 673740880, 3755965093, 2358021891, 2711746649, 2307489801, 218961690, 3217021541, 3873845719, 1111672452, 1751693520, 1094828930, 2576986153, 757954394, 252645662, 2964376443, 1414855848, 3149649517, 370555436],
                y = [1374988112, 2118214995, 437757123, 975658646, 1001089995, 530400753, 2902087851, 1273168787, 540080725, 2910219766, 2295101073, 4110568485, 1340463100, 3307916247, 641025152, 3043140495, 3736164937, 632953703, 1172967064, 1576976609, 3274667266, 2169303058, 2370213795, 1809054150, 59727847, 361929877, 3211623147, 2505202138, 3569255213, 1484005843, 1239443753, 2395588676, 1975683434, 4102977912, 2572697195, 666464733, 3202437046, 4035489047, 3374361702, 2110667444, 1675577880, 3843699074, 2538681184, 1649639237, 2976151520, 3144396420, 4269907996, 4178062228, 1883793496, 2403728665, 2497604743, 1383856311, 2876494627, 1917518562, 3810496343, 1716890410, 3001755655, 800440835, 2261089178, 3543599269, 807962610, 599762354, 33778362, 3977675356, 2328828971, 2809771154, 4077384432, 1315562145, 1708848333, 101039829, 3509871135, 3299278474, 875451293, 2733856160, 92987698, 2767645557, 193195065, 1080094634, 1584504582, 3178106961, 1042385657, 2531067453, 3711829422, 1306967366, 2438237621, 1908694277, 67556463, 1615861247, 429456164, 3602770327, 2302690252, 1742315127, 2968011453, 126454664, 3877198648, 2043211483, 2709260871, 2084704233, 4169408201, 0, 159417987, 841739592, 504459436, 1817866830, 4245618683, 260388950, 1034867998, 908933415, 168810852, 1750902305, 2606453969, 607530554, 202008497, 2472011535, 3035535058, 463180190, 2160117071, 1641816226, 1517767529, 470948374, 3801332234, 3231722213, 1008918595, 303765277, 235474187, 4069246893, 766945465, 337553864, 1475418501, 2943682380, 4003061179, 2743034109, 4144047775, 1551037884, 1147550661, 1543208500, 2336434550, 3408119516, 3069049960, 3102011747, 3610369226, 1113818384, 328671808, 2227573024, 2236228733, 3535486456, 2935566865, 3341394285, 496906059, 3702665459, 226906860, 2009195472, 733156972, 2842737049, 294930682, 1206477858, 2835123396, 2700099354, 1451044056, 573804783, 2269728455, 3644379585, 2362090238, 2564033334, 2801107407, 2776292904, 3669462566, 1068351396, 742039012, 1350078989, 1784663195, 1417561698, 4136440770, 2430122216, 775550814, 2193862645, 2673705150, 1775276924, 1876241833, 3475313331, 3366754619, 270040487, 3902563182, 3678124923, 3441850377, 1851332852, 3969562369, 2203032232, 3868552805, 2868897406, 566021896, 4011190502, 3135740889, 1248802510, 3936291284, 699432150, 832877231, 708780849, 3332740144, 899835584, 1951317047, 4236429990, 3767586992, 866637845, 4043610186, 1106041591, 2144161806, 395441711, 1984812685, 1139781709, 3433712980, 3835036895, 2664543715, 1282050075, 3240894392, 1181045119, 2640243204, 25965917, 4203181171, 4211818798, 3009879386, 2463879762, 3910161971, 1842759443, 2597806476, 933301370, 1509430414, 3943906441, 3467192302, 3076639029, 3776767469, 2051518780, 2631065433, 1441952575, 404016761, 1942435775, 1408749034, 1610459739, 3745345300, 2017778566, 3400528769, 3110650942, 941896748, 3265478751, 371049330, 3168937228, 675039627, 4279080257, 967311729, 135050206, 3635733660, 1683407248, 2076935265, 3576870512, 1215061108, 3501741890],
                _ = [1347548327, 1400783205, 3273267108, 2520393566, 3409685355, 4045380933, 2880240216, 2471224067, 1428173050, 4138563181, 2441661558, 636813900, 4233094615, 3620022987, 2149987652, 2411029155, 1239331162, 1730525723, 2554718734, 3781033664, 46346101, 310463728, 2743944855, 3328955385, 3875770207, 2501218972, 3955191162, 3667219033, 768917123, 3545789473, 692707433, 1150208456, 1786102409, 2029293177, 1805211710, 3710368113, 3065962831, 401639597, 1724457132, 3028143674, 409198410, 2196052529, 1620529459, 1164071807, 3769721975, 2226875310, 486441376, 2499348523, 1483753576, 428819965, 2274680428, 3075636216, 598438867, 3799141122, 1474502543, 711349675, 129166120, 53458370, 2592523643, 2782082824, 4063242375, 2988687269, 3120694122, 1559041666, 730517276, 2460449204, 4042459122, 2706270690, 3446004468, 3573941694, 533804130, 2328143614, 2637442643, 2695033685, 839224033, 1973745387, 957055980, 2856345839, 106852767, 1371368976, 4181598602, 1033297158, 2933734917, 1179510461, 3046200461, 91341917, 1862534868, 4284502037, 605657339, 2547432937, 3431546947, 2003294622, 3182487618, 2282195339, 954669403, 3682191598, 1201765386, 3917234703, 3388507166, 0, 2198438022, 1211247597, 2887651696, 1315723890, 4227665663, 1443857720, 507358933, 657861945, 1678381017, 560487590, 3516619604, 975451694, 2970356327, 261314535, 3535072918, 2652609425, 1333838021, 2724322336, 1767536459, 370938394, 182621114, 3854606378, 1128014560, 487725847, 185469197, 2918353863, 3106780840, 3356761769, 2237133081, 1286567175, 3152976349, 4255350624, 2683765030, 3160175349, 3309594171, 878443390, 1988838185, 3704300486, 1756818940, 1673061617, 3403100636, 272786309, 1075025698, 545572369, 2105887268, 4174560061, 296679730, 1841768865, 1260232239, 4091327024, 3960309330, 3497509347, 1814803222, 2578018489, 4195456072, 575138148, 3299409036, 446754879, 3629546796, 4011996048, 3347532110, 3252238545, 4270639778, 915985419, 3483825537, 681933534, 651868046, 2755636671, 3828103837, 223377554, 2607439820, 1649704518, 3270937875, 3901806776, 1580087799, 4118987695, 3198115200, 2087309459, 2842678573, 3016697106, 1003007129, 2802849917, 1860738147, 2077965243, 164439672, 4100872472, 32283319, 2827177882, 1709610350, 2125135846, 136428751, 3874428392, 3652904859, 3460984630, 3572145929, 3593056380, 2939266226, 824852259, 818324884, 3224740454, 930369212, 2801566410, 2967507152, 355706840, 1257309336, 4148292826, 243256656, 790073846, 2373340630, 1296297904, 1422699085, 3756299780, 3818836405, 457992840, 3099667487, 2135319889, 77422314, 1560382517, 1945798516, 788204353, 1521706781, 1385356242, 870912086, 325965383, 2358957921, 2050466060, 2388260884, 2313884476, 4006521127, 901210569, 3990953189, 1014646705, 1503449823, 1062597235, 2031621326, 3212035895, 3931371469, 1533017514, 350174575, 2256028891, 2177544179, 1052338372, 741876788, 1606591296, 1914052035, 213705253, 2334669897, 1107234197, 1899603969, 3725069491, 2631447780, 2422494913, 1635502980, 1893020342, 1950903388, 1120974935],
                R = [2807058932, 1699970625, 2764249623, 1586903591, 1808481195, 1173430173, 1487645946, 59984867, 4199882800, 1844882806, 1989249228, 1277555970, 3623636965, 3419915562, 1149249077, 2744104290, 1514790577, 459744698, 244860394, 3235995134, 1963115311, 4027744588, 2544078150, 4190530515, 1608975247, 2627016082, 2062270317, 1507497298, 2200818878, 567498868, 1764313568, 3359936201, 2305455554, 2037970062, 1047239e3, 1910319033, 1337376481, 2904027272, 2892417312, 984907214, 1243112415, 830661914, 861968209, 2135253587, 2011214180, 2927934315, 2686254721, 731183368, 1750626376, 4246310725, 1820824798, 4172763771, 3542330227, 48394827, 2404901663, 2871682645, 671593195, 3254988725, 2073724613, 145085239, 2280796200, 2779915199, 1790575107, 2187128086, 472615631, 3029510009, 4075877127, 3802222185, 4107101658, 3201631749, 1646252340, 4270507174, 1402811438, 1436590835, 3778151818, 3950355702, 3963161475, 4020912224, 2667994737, 273792366, 2331590177, 104699613, 95345982, 3175501286, 2377486676, 1560637892, 3564045318, 369057872, 4213447064, 3919042237, 1137477952, 2658625497, 1119727848, 2340947849, 1530455833, 4007360968, 172466556, 266959938, 516552836, 0, 2256734592, 3980931627, 1890328081, 1917742170, 4294704398, 945164165, 3575528878, 958871085, 3647212047, 2787207260, 1423022939, 775562294, 1739656202, 3876557655, 2530391278, 2443058075, 3310321856, 547512796, 1265195639, 437656594, 3121275539, 719700128, 3762502690, 387781147, 218828297, 3350065803, 2830708150, 2848461854, 428169201, 122466165, 3720081049, 1627235199, 648017665, 4122762354, 1002783846, 2117360635, 695634755, 3336358691, 4234721005, 4049844452, 3704280881, 2232435299, 574624663, 287343814, 612205898, 1039717051, 840019705, 2708326185, 793451934, 821288114, 1391201670, 3822090177, 376187827, 3113855344, 1224348052, 1679968233, 2361698556, 1058709744, 752375421, 2431590963, 1321699145, 3519142200, 2734591178, 188127444, 2177869557, 3727205754, 2384911031, 3215212461, 2648976442, 2450346104, 3432737375, 1180849278, 331544205, 3102249176, 4150144569, 2952102595, 2159976285, 2474404304, 766078933, 313773861, 2570832044, 2108100632, 1668212892, 3145456443, 2013908262, 418672217, 3070356634, 2594734927, 1852171925, 3867060991, 3473416636, 3907448597, 2614737639, 919489135, 164948639, 2094410160, 2997825956, 590424639, 2486224549, 1723872674, 3157750862, 3399941250, 3501252752, 3625268135, 2555048196, 3673637356, 1343127501, 4130281361, 3599595085, 2957853679, 1297403050, 81781910, 3051593425, 2283490410, 532201772, 1367295589, 3926170974, 895287692, 1953757831, 1093597963, 492483431, 3528626907, 1446242576, 1192455638, 1636604631, 209336225, 344873464, 1015671571, 669961897, 3375740769, 3857572124, 2973530695, 3747192018, 1933530610, 3464042516, 935293895, 3454686199, 2858115069, 1863638845, 3683022916, 4085369519, 3292445032, 875313188, 1080017571, 3279033885, 621591778, 1233856572, 2504130317, 24197544, 3017672716, 3835484340, 3247465558, 2220981195, 3060847922, 1551124588, 1463996600],
                v = [4104605777, 1097159550, 396673818, 660510266, 2875968315, 2638606623, 4200115116, 3808662347, 821712160, 1986918061, 3430322568, 38544885, 3856137295, 718002117, 893681702, 1654886325, 2975484382, 3122358053, 3926825029, 4274053469, 796197571, 1290801793, 1184342925, 3556361835, 2405426947, 2459735317, 1836772287, 1381620373, 3196267988, 1948373848, 3764988233, 3385345166, 3263785589, 2390325492, 1480485785, 3111247143, 3780097726, 2293045232, 548169417, 3459953789, 3746175075, 439452389, 1362321559, 1400849762, 1685577905, 1806599355, 2174754046, 137073913, 1214797936, 1174215055, 3731654548, 2079897426, 1943217067, 1258480242, 529487843, 1437280870, 3945269170, 3049390895, 3313212038, 923313619, 679998e3, 3215307299, 57326082, 377642221, 3474729866, 2041877159, 133361907, 1776460110, 3673476453, 96392454, 878845905, 2801699524, 777231668, 4082475170, 2330014213, 4142626212, 2213296395, 1626319424, 1906247262, 1846563261, 562755902, 3708173718, 1040559837, 3871163981, 1418573201, 3294430577, 114585348, 1343618912, 2566595609, 3186202582, 1078185097, 3651041127, 3896688048, 2307622919, 425408743, 3371096953, 2081048481, 1108339068, 2216610296, 0, 2156299017, 736970802, 292596766, 1517440620, 251657213, 2235061775, 2933202493, 758720310, 265905162, 1554391400, 1532285339, 908999204, 174567692, 1474760595, 4002861748, 2610011675, 3234156416, 3693126241, 2001430874, 303699484, 2478443234, 2687165888, 585122620, 454499602, 151849742, 2345119218, 3064510765, 514443284, 4044981591, 1963412655, 2581445614, 2137062819, 19308535, 1928707164, 1715193156, 4219352155, 1126790795, 600235211, 3992742070, 3841024952, 836553431, 1669664834, 2535604243, 3323011204, 1243905413, 3141400786, 4180808110, 698445255, 2653899549, 2989552604, 2253581325, 3252932727, 3004591147, 1891211689, 2487810577, 3915653703, 4237083816, 4030667424, 2100090966, 865136418, 1229899655, 953270745, 3399679628, 3557504664, 4118925222, 2061379749, 3079546586, 2915017791, 983426092, 2022837584, 1607244650, 2118541908, 2366882550, 3635996816, 972512814, 3283088770, 1568718495, 3499326569, 3576539503, 621982671, 2895723464, 410887952, 2623762152, 1002142683, 645401037, 1494807662, 2595684844, 1335535747, 2507040230, 4293295786, 3167684641, 367585007, 3885750714, 1865862730, 2668221674, 2960971305, 2763173681, 1059270954, 2777952454, 2724642869, 1320957812, 2194319100, 2429595872, 2815956275, 77089521, 3973773121, 3444575871, 2448830231, 1305906550, 4021308739, 2857194700, 2516901860, 3518358430, 1787304780, 740276417, 1699839814, 1592394909, 2352307457, 2272556026, 188821243, 1729977011, 3687994002, 274084841, 3594982253, 3613494426, 2701949495, 4162096729, 322734571, 2837966542, 1640576439, 484830689, 1202797690, 3537852828, 4067639125, 349075736, 3342319475, 4157467219, 4255800159, 1030690015, 1155237496, 2951971274, 1757691577, 607398968, 2738905026, 499347990, 3794078908, 1011452712, 227885567, 2818666809, 213114376, 3034881240, 1455525988, 3414450555, 850817237, 1817998408, 3092726480],
                w = [0, 235474187, 470948374, 303765277, 941896748, 908933415, 607530554, 708780849, 1883793496, 2118214995, 1817866830, 1649639237, 1215061108, 1181045119, 1417561698, 1517767529, 3767586992, 4003061179, 4236429990, 4069246893, 3635733660, 3602770327, 3299278474, 3400528769, 2430122216, 2664543715, 2362090238, 2193862645, 2835123396, 2801107407, 3035535058, 3135740889, 3678124923, 3576870512, 3341394285, 3374361702, 3810496343, 3977675356, 4279080257, 4043610186, 2876494627, 2776292904, 3076639029, 3110650942, 2472011535, 2640243204, 2403728665, 2169303058, 1001089995, 899835584, 666464733, 699432150, 59727847, 226906860, 530400753, 294930682, 1273168787, 1172967064, 1475418501, 1509430414, 1942435775, 2110667444, 1876241833, 1641816226, 2910219766, 2743034109, 2976151520, 3211623147, 2505202138, 2606453969, 2302690252, 2269728455, 3711829422, 3543599269, 3240894392, 3475313331, 3843699074, 3943906441, 4178062228, 4144047775, 1306967366, 1139781709, 1374988112, 1610459739, 1975683434, 2076935265, 1775276924, 1742315127, 1034867998, 866637845, 566021896, 800440835, 92987698, 193195065, 429456164, 395441711, 1984812685, 2017778566, 1784663195, 1683407248, 1315562145, 1080094634, 1383856311, 1551037884, 101039829, 135050206, 437757123, 337553864, 1042385657, 807962610, 573804783, 742039012, 2531067453, 2564033334, 2328828971, 2227573024, 2935566865, 2700099354, 3001755655, 3168937228, 3868552805, 3902563182, 4203181171, 4102977912, 3736164937, 3501741890, 3265478751, 3433712980, 1106041591, 1340463100, 1576976609, 1408749034, 2043211483, 2009195472, 1708848333, 1809054150, 832877231, 1068351396, 766945465, 599762354, 159417987, 126454664, 361929877, 463180190, 2709260871, 2943682380, 3178106961, 3009879386, 2572697195, 2538681184, 2236228733, 2336434550, 3509871135, 3745345300, 3441850377, 3274667266, 3910161971, 3877198648, 4110568485, 4211818798, 2597806476, 2497604743, 2261089178, 2295101073, 2733856160, 2902087851, 3202437046, 2968011453, 3936291284, 3835036895, 4136440770, 4169408201, 3535486456, 3702665459, 3467192302, 3231722213, 2051518780, 1951317047, 1716890410, 1750902305, 1113818384, 1282050075, 1584504582, 1350078989, 168810852, 67556463, 371049330, 404016761, 841739592, 1008918595, 775550814, 540080725, 3969562369, 3801332234, 4035489047, 4269907996, 3569255213, 3669462566, 3366754619, 3332740144, 2631065433, 2463879762, 2160117071, 2395588676, 2767645557, 2868897406, 3102011747, 3069049960, 202008497, 33778362, 270040487, 504459436, 875451293, 975658646, 675039627, 641025152, 2084704233, 1917518562, 1615861247, 1851332852, 1147550661, 1248802510, 1484005843, 1451044056, 933301370, 967311729, 733156972, 632953703, 260388950, 25965917, 328671808, 496906059, 1206477858, 1239443753, 1543208500, 1441952575, 2144161806, 1908694277, 1675577880, 1842759443, 3610369226, 3644379585, 3408119516, 3307916247, 4011190502, 3776767469, 4077384432, 4245618683, 2809771154, 2842737049, 3144396420, 3043140495, 2673705150, 2438237621, 2203032232, 2370213795],
                S = [0, 185469197, 370938394, 487725847, 741876788, 657861945, 975451694, 824852259, 1483753576, 1400783205, 1315723890, 1164071807, 1950903388, 2135319889, 1649704518, 1767536459, 2967507152, 3152976349, 2801566410, 2918353863, 2631447780, 2547432937, 2328143614, 2177544179, 3901806776, 3818836405, 4270639778, 4118987695, 3299409036, 3483825537, 3535072918, 3652904859, 2077965243, 1893020342, 1841768865, 1724457132, 1474502543, 1559041666, 1107234197, 1257309336, 598438867, 681933534, 901210569, 1052338372, 261314535, 77422314, 428819965, 310463728, 3409685355, 3224740454, 3710368113, 3593056380, 3875770207, 3960309330, 4045380933, 4195456072, 2471224067, 2554718734, 2237133081, 2388260884, 3212035895, 3028143674, 2842678573, 2724322336, 4138563181, 4255350624, 3769721975, 3955191162, 3667219033, 3516619604, 3431546947, 3347532110, 2933734917, 2782082824, 3099667487, 3016697106, 2196052529, 2313884476, 2499348523, 2683765030, 1179510461, 1296297904, 1347548327, 1533017514, 1786102409, 1635502980, 2087309459, 2003294622, 507358933, 355706840, 136428751, 53458370, 839224033, 957055980, 605657339, 790073846, 2373340630, 2256028891, 2607439820, 2422494913, 2706270690, 2856345839, 3075636216, 3160175349, 3573941694, 3725069491, 3273267108, 3356761769, 4181598602, 4063242375, 4011996048, 3828103837, 1033297158, 915985419, 730517276, 545572369, 296679730, 446754879, 129166120, 213705253, 1709610350, 1860738147, 1945798516, 2029293177, 1239331162, 1120974935, 1606591296, 1422699085, 4148292826, 4233094615, 3781033664, 3931371469, 3682191598, 3497509347, 3446004468, 3328955385, 2939266226, 2755636671, 3106780840, 2988687269, 2198438022, 2282195339, 2501218972, 2652609425, 1201765386, 1286567175, 1371368976, 1521706781, 1805211710, 1620529459, 2105887268, 1988838185, 533804130, 350174575, 164439672, 46346101, 870912086, 954669403, 636813900, 788204353, 2358957921, 2274680428, 2592523643, 2441661558, 2695033685, 2880240216, 3065962831, 3182487618, 3572145929, 3756299780, 3270937875, 3388507166, 4174560061, 4091327024, 4006521127, 3854606378, 1014646705, 930369212, 711349675, 560487590, 272786309, 457992840, 106852767, 223377554, 1678381017, 1862534868, 1914052035, 2031621326, 1211247597, 1128014560, 1580087799, 1428173050, 32283319, 182621114, 401639597, 486441376, 768917123, 651868046, 1003007129, 818324884, 1503449823, 1385356242, 1333838021, 1150208456, 1973745387, 2125135846, 1673061617, 1756818940, 2970356327, 3120694122, 2802849917, 2887651696, 2637442643, 2520393566, 2334669897, 2149987652, 3917234703, 3799141122, 4284502037, 4100872472, 3309594171, 3460984630, 3545789473, 3629546796, 2050466060, 1899603969, 1814803222, 1730525723, 1443857720, 1560382517, 1075025698, 1260232239, 575138148, 692707433, 878443390, 1062597235, 243256656, 91341917, 409198410, 325965383, 3403100636, 3252238545, 3704300486, 3620022987, 3874428392, 3990953189, 4042459122, 4227665663, 2460449204, 2578018489, 2226875310, 2411029155, 3198115200, 3046200461, 2827177882, 2743944855],
                M = [0, 218828297, 437656594, 387781147, 875313188, 958871085, 775562294, 590424639, 1750626376, 1699970625, 1917742170, 2135253587, 1551124588, 1367295589, 1180849278, 1265195639, 3501252752, 3720081049, 3399941250, 3350065803, 3835484340, 3919042237, 4270507174, 4085369519, 3102249176, 3051593425, 2734591178, 2952102595, 2361698556, 2177869557, 2530391278, 2614737639, 3145456443, 3060847922, 2708326185, 2892417312, 2404901663, 2187128086, 2504130317, 2555048196, 3542330227, 3727205754, 3375740769, 3292445032, 3876557655, 3926170974, 4246310725, 4027744588, 1808481195, 1723872674, 1910319033, 2094410160, 1608975247, 1391201670, 1173430173, 1224348052, 59984867, 244860394, 428169201, 344873464, 935293895, 984907214, 766078933, 547512796, 1844882806, 1627235199, 2011214180, 2062270317, 1507497298, 1423022939, 1137477952, 1321699145, 95345982, 145085239, 532201772, 313773861, 830661914, 1015671571, 731183368, 648017665, 3175501286, 2957853679, 2807058932, 2858115069, 2305455554, 2220981195, 2474404304, 2658625497, 3575528878, 3625268135, 3473416636, 3254988725, 3778151818, 3963161475, 4213447064, 4130281361, 3599595085, 3683022916, 3432737375, 3247465558, 3802222185, 4020912224, 4172763771, 4122762354, 3201631749, 3017672716, 2764249623, 2848461854, 2331590177, 2280796200, 2431590963, 2648976442, 104699613, 188127444, 472615631, 287343814, 840019705, 1058709744, 671593195, 621591778, 1852171925, 1668212892, 1953757831, 2037970062, 1514790577, 1463996600, 1080017571, 1297403050, 3673637356, 3623636965, 3235995134, 3454686199, 4007360968, 3822090177, 4107101658, 4190530515, 2997825956, 3215212461, 2830708150, 2779915199, 2256734592, 2340947849, 2627016082, 2443058075, 172466556, 122466165, 273792366, 492483431, 1047239e3, 861968209, 612205898, 695634755, 1646252340, 1863638845, 2013908262, 1963115311, 1446242576, 1530455833, 1277555970, 1093597963, 1636604631, 1820824798, 2073724613, 1989249228, 1436590835, 1487645946, 1337376481, 1119727848, 164948639, 81781910, 331544205, 516552836, 1039717051, 821288114, 669961897, 719700128, 2973530695, 3157750862, 2871682645, 2787207260, 2232435299, 2283490410, 2667994737, 2450346104, 3647212047, 3564045318, 3279033885, 3464042516, 3980931627, 3762502690, 4150144569, 4199882800, 3070356634, 3121275539, 2904027272, 2686254721, 2200818878, 2384911031, 2570832044, 2486224549, 3747192018, 3528626907, 3310321856, 3359936201, 3950355702, 3867060991, 4049844452, 4234721005, 1739656202, 1790575107, 2108100632, 1890328081, 1402811438, 1586903591, 1233856572, 1149249077, 266959938, 48394827, 369057872, 418672217, 1002783846, 919489135, 567498868, 752375421, 209336225, 24197544, 376187827, 459744698, 945164165, 895287692, 574624663, 793451934, 1679968233, 1764313568, 2117360635, 1933530610, 1343127501, 1560637892, 1243112415, 1192455638, 3704280881, 3519142200, 3336358691, 3419915562, 3907448597, 3857572124, 4075877127, 4294704398, 3029510009, 3113855344, 2927934315, 2744104290, 2159976285, 2377486676, 2594734927, 2544078150],
                b = [0, 151849742, 303699484, 454499602, 607398968, 758720310, 908999204, 1059270954, 1214797936, 1097159550, 1517440620, 1400849762, 1817998408, 1699839814, 2118541908, 2001430874, 2429595872, 2581445614, 2194319100, 2345119218, 3034881240, 3186202582, 2801699524, 2951971274, 3635996816, 3518358430, 3399679628, 3283088770, 4237083816, 4118925222, 4002861748, 3885750714, 1002142683, 850817237, 698445255, 548169417, 529487843, 377642221, 227885567, 77089521, 1943217067, 2061379749, 1640576439, 1757691577, 1474760595, 1592394909, 1174215055, 1290801793, 2875968315, 2724642869, 3111247143, 2960971305, 2405426947, 2253581325, 2638606623, 2487810577, 3808662347, 3926825029, 4044981591, 4162096729, 3342319475, 3459953789, 3576539503, 3693126241, 1986918061, 2137062819, 1685577905, 1836772287, 1381620373, 1532285339, 1078185097, 1229899655, 1040559837, 923313619, 740276417, 621982671, 439452389, 322734571, 137073913, 19308535, 3871163981, 4021308739, 4104605777, 4255800159, 3263785589, 3414450555, 3499326569, 3651041127, 2933202493, 2815956275, 3167684641, 3049390895, 2330014213, 2213296395, 2566595609, 2448830231, 1305906550, 1155237496, 1607244650, 1455525988, 1776460110, 1626319424, 2079897426, 1928707164, 96392454, 213114376, 396673818, 514443284, 562755902, 679998e3, 865136418, 983426092, 3708173718, 3557504664, 3474729866, 3323011204, 4180808110, 4030667424, 3945269170, 3794078908, 2507040230, 2623762152, 2272556026, 2390325492, 2975484382, 3092726480, 2738905026, 2857194700, 3973773121, 3856137295, 4274053469, 4157467219, 3371096953, 3252932727, 3673476453, 3556361835, 2763173681, 2915017791, 3064510765, 3215307299, 2156299017, 2307622919, 2459735317, 2610011675, 2081048481, 1963412655, 1846563261, 1729977011, 1480485785, 1362321559, 1243905413, 1126790795, 878845905, 1030690015, 645401037, 796197571, 274084841, 425408743, 38544885, 188821243, 3613494426, 3731654548, 3313212038, 3430322568, 4082475170, 4200115116, 3780097726, 3896688048, 2668221674, 2516901860, 2366882550, 2216610296, 3141400786, 2989552604, 2837966542, 2687165888, 1202797690, 1320957812, 1437280870, 1554391400, 1669664834, 1787304780, 1906247262, 2022837584, 265905162, 114585348, 499347990, 349075736, 736970802, 585122620, 972512814, 821712160, 2595684844, 2478443234, 2293045232, 2174754046, 3196267988, 3079546586, 2895723464, 2777952454, 3537852828, 3687994002, 3234156416, 3385345166, 4142626212, 4293295786, 3841024952, 3992742070, 174567692, 57326082, 410887952, 292596766, 777231668, 660510266, 1011452712, 893681702, 1108339068, 1258480242, 1343618912, 1494807662, 1715193156, 1865862730, 1948373848, 2100090966, 2701949495, 2818666809, 3004591147, 3122358053, 2235061775, 2352307457, 2535604243, 2653899549, 3915653703, 3764988233, 4219352155, 4067639125, 3444575871, 3294430577, 3746175075, 3594982253, 836553431, 953270745, 600235211, 718002117, 367585007, 484830689, 133361907, 251657213, 2041877159, 1891211689, 1806599355, 1654886325, 1568718495, 1418573201, 1335535747, 1184342925];

            function I(t) {
                for (var e = [], r = 0; r < t.length; r += 4) e.push(t[r] << 24 | t[r + 1] << 16 | t[r + 2] << 8 | t[r + 3]);
                return e
            }
            var a = function (t) {
                if (!(this instanceof a)) throw Error("AES must be instanitated with `new`");
                Object.defineProperty(this, "key", {
                    value: i(t, !0)
                }), this._prepare()
            };
            a.prototype._prepare = function () {
                var t = h[this.key.length];
                if (null == t) throw new Error("invalid key size (must be 16, 24 or 32 bytes)");
                this._Ke = [], this._Kd = [];
                for (var e = 0; e <= t; e++) this._Ke.push([0, 0, 0, 0]), this._Kd.push([0, 0, 0, 0]);
                var r, o = 4 * (t + 1),
                    n = this.key.length / 4,
                    i = I(this.key);
                for (e = 0; e < n; e++) r = e >> 2, this._Ke[r][e % 4] = i[e], this._Kd[t - r][e % 4] = i[e];
                for (var s, a = 0, u = n; u < o;) {
                    if (s = i[n - 1], i[0] ^= d[s >> 16 & 255] << 24 ^ d[s >> 8 & 255] << 16 ^ d[255 & s] << 8 ^ d[s >> 24 & 255] ^ p[a] << 24, a += 1, 8 != n)
                        for (e = 1; e < n; e++) i[e] ^= i[e - 1];
                    else {
                        for (e = 1; e < n / 2; e++) i[e] ^= i[e - 1];
                        s = i[n / 2 - 1], i[n / 2] ^= d[255 & s] ^ d[s >> 8 & 255] << 8 ^ d[s >> 16 & 255] << 16 ^ d[s >> 24 & 255] << 24;
                        for (e = n / 2 + 1; e < n; e++) i[e] ^= i[e - 1]
                    }
                    for (e = 0; e < n && u < o;) c = u >> 2, f = u % 4, this._Ke[c][f] = i[e], this._Kd[t - c][f] = i[e++], u++
                }
                for (var c = 1; c < t; c++)
                    for (var f = 0; f < 4; f++) s = this._Kd[c][f], this._Kd[c][f] = w[s >> 24 & 255] ^ S[s >> 16 & 255] ^ M[s >> 8 & 255] ^ b[255 & s]
            }, a.prototype.encrypt = function (t) {
                if (16 != t.length) throw new Error("invalid plaintext size (must be 16 bytes)");
                for (var e = this._Ke.length - 1, r = [0, 0, 0, 0], o = I(t), n = 0; n < 4; n++) o[n] ^= this._Ke[0][n];
                for (var i = 1; i < e; i++) {
                    for (n = 0; n < 4; n++) r[n] = f[o[n] >> 24 & 255] ^ m[o[(n + 1) % 4] >> 16 & 255] ^ l[o[(n + 2) % 4] >> 8 & 255] ^ g[255 & o[(n + 3) % 4]] ^ this._Ke[i][n];
                    o = r.slice()
                }
                var s, a = u(16);
                for (n = 0; n < 4; n++) s = this._Ke[e][n], a[4 * n] = 255 & (d[o[n] >> 24 & 255] ^ s >> 24), a[4 * n + 1] = 255 & (d[o[(n + 1) % 4] >> 16 & 255] ^ s >> 16), a[4 * n + 2] = 255 & (d[o[(n + 2) % 4] >> 8 & 255] ^ s >> 8), a[4 * n + 3] = 255 & (d[255 & o[(n + 3) % 4]] ^ s);
                return a
            }, a.prototype.decrypt = function (t) {
                if (16 != t.length) throw new Error("invalid ciphertext size (must be 16 bytes)");
                for (var e = this._Kd.length - 1, r = [0, 0, 0, 0], o = I(t), n = 0; n < 4; n++) o[n] ^= this._Kd[0][n];
                for (var i = 1; i < e; i++) {
                    for (n = 0; n < 4; n++) r[n] = y[o[n] >> 24 & 255] ^ _[o[(n + 3) % 4] >> 16 & 255] ^ R[o[(n + 2) % 4] >> 8 & 255] ^ v[255 & o[(n + 1) % 4]] ^ this._Kd[i][n];
                    o = r.slice()
                }
                var s, a = u(16);
                for (n = 0; n < 4; n++) s = this._Kd[e][n], a[4 * n] = 255 & (c[o[n] >> 24 & 255] ^ s >> 24), a[4 * n + 1] = 255 & (c[o[(n + 3) % 4] >> 16 & 255] ^ s >> 16), a[4 * n + 2] = 255 & (c[o[(n + 2) % 4] >> 8 & 255] ^ s >> 8), a[4 * n + 3] = 255 & (c[255 & o[(n + 1) % 4]] ^ s);
                return a
            };
            var B = function (t) {
                if (!(this instanceof B)) throw Error("AES must be instanitated with `new`");
                this.description = "Electronic Code Block", this.name = "ecb", this._aes = new a(t)
            };
            B.prototype.encrypt = function (t) {
                if ((t = i(t)).length % 16 != 0) throw new Error("invalid plaintext size (must be multiple of 16 bytes)");
                for (var e = u(t.length), r = u(16), o = 0; o < t.length; o += 16) s(t, r, 0, o, o + 16), s(r = this._aes.encrypt(r), e, o);
                return e
            }, B.prototype.decrypt = function (t) {
                if ((t = i(t)).length % 16 != 0) throw new Error("invalid ciphertext size (must be multiple of 16 bytes)");
                for (var e = u(t.length), r = u(16), o = 0; o < t.length; o += 16) s(t, r, 0, o, o + 16), s(r = this._aes.decrypt(r), e, o);
                return e
            };
            var T = function (t, e) {
                if (!(this instanceof T)) throw Error("AES must be instanitated with `new`");
                if (this.description = "Cipher Block Chaining", this.name = "cbc", e) {
                    if (16 != e.length) throw new Error("invalid initialation vector size (must be 16 bytes)")
                } else e = u(16);
                this._lastCipherblock = i(e, !0), this._aes = new a(t)
            };
            T.prototype.encrypt = function (t) {
                if ((t = i(t)).length % 16 != 0) throw new Error("invalid plaintext size (must be multiple of 16 bytes)");
                for (var e = u(t.length), r = u(16), o = 0; o < t.length; o += 16) {
                    s(t, r, 0, o, o + 16);
                    for (var n = 0; n < 16; n++) r[n] ^= this._lastCipherblock[n];
                    this._lastCipherblock = this._aes.encrypt(r), s(this._lastCipherblock, e, o)
                }
                return e
            }, T.prototype.decrypt = function (t) {
                if ((t = i(t)).length % 16 != 0) throw new Error("invalid ciphertext size (must be multiple of 16 bytes)");
                for (var e = u(t.length), r = u(16), o = 0; o < t.length; o += 16) {
                    s(t, r, 0, o, o + 16), r = this._aes.decrypt(r);
                    for (var n = 0; n < 16; n++) e[o + n] = r[n] ^ this._lastCipherblock[n];
                    s(t, this._lastCipherblock, 0, o, o + 16)
                }
                return e
            };
            var O = function (t, e, r) {
                if (!(this instanceof O)) throw Error("AES must be instanitated with `new`");
                if (this.description = "Cipher Feedback", this.name = "cfb", e) {
                    if (16 != e.length) throw new Error("invalid initialation vector size (must be 16 size)")
                } else e = u(16);
                r = r || 1, this.segmentSize = r, this._shiftRegister = i(e, !0), this._aes = new a(t)
            };
            O.prototype.encrypt = function (t) {
                if (t.length % this.segmentSize != 0) throw new Error("invalid plaintext size (must be segmentSize bytes)");
                for (var e, r = i(t, !0), o = 0; o < r.length; o += this.segmentSize) {
                    e = this._aes.encrypt(this._shiftRegister);
                    for (var n = 0; n < this.segmentSize; n++) r[o + n] ^= e[n];
                    s(this._shiftRegister, this._shiftRegister, 0, this.segmentSize), s(r, this._shiftRegister, 16 - this.segmentSize, o, o + this.segmentSize)
                }
                return r
            }, O.prototype.decrypt = function (t) {
                if (t.length % this.segmentSize != 0) throw new Error("invalid ciphertext size (must be segmentSize bytes)");
                for (var e, r = i(t, !0), o = 0; o < r.length; o += this.segmentSize) {
                    e = this._aes.encrypt(this._shiftRegister);
                    for (var n = 0; n < this.segmentSize; n++) r[o + n] ^= e[n];
                    s(this._shiftRegister, this._shiftRegister, 0, this.segmentSize), s(t, this._shiftRegister, 16 - this.segmentSize, o, o + this.segmentSize)
                }
                return r
            };
            var D = function (t, e) {
                if (!(this instanceof D)) throw Error("AES must be instanitated with `new`");
                if (this.description = "Output Feedback", this.name = "ofb", e) {
                    if (16 != e.length) throw new Error("invalid initialation vector size (must be 16 bytes)")
                } else e = u(16);
                this._lastPrecipher = i(e, !0), this._lastPrecipherIndex = 16, this._aes = new a(t)
            };
            D.prototype.encrypt = function (t) {
                for (var e = i(t, !0), r = 0; r < e.length; r++) 16 === this._lastPrecipherIndex && (this._lastPrecipher = this._aes.encrypt(this._lastPrecipher), this._lastPrecipherIndex = 0), e[r] ^= this._lastPrecipher[this._lastPrecipherIndex++];
                return e
            }, D.prototype.decrypt = D.prototype.encrypt;
            var P = function (t) {
                if (!(this instanceof P)) throw Error("Counter must be instanitated with `new`");
                0 === t || t || (t = 1), "number" == typeof t ? (this._counter = u(16), this.setValue(t)) : this.setBytes(t)
            };
            P.prototype.setValue = function (t) {
                if ("number" != typeof t || parseInt(t) != t) throw new Error("invalid counter value (must be an integer)");
                if (t > Number.MAX_SAFE_INTEGER) throw new Error("integer value out of safe range");
                for (var e = 15; 0 <= e; --e) this._counter[e] = t % 256, t = parseInt(t / 256)
            }, P.prototype.setBytes = function (t) {
                if (16 != (t = i(t, !0)).length) throw new Error("invalid counter bytes size (must be 16 bytes)");
                this._counter = t
            }, P.prototype.increment = function () {
                for (var t = 15; 0 <= t; t--) {
                    if (255 !== this._counter[t]) {
                        this._counter[t]++;
                        break
                    }
                    this._counter[t] = 0
                }
            };
            var C = function (t, e) {
                if (!(this instanceof C)) throw Error("AES must be instanitated with `new`");
                this.description = "Counter", this.name = "ctr", e instanceof P || (e = new P(e)), this._counter = e, this._remainingCounter = null, this._remainingCounterIndex = 16, this._aes = new a(t)
            };
            C.prototype.encrypt = function (t) {
                for (var e = i(t, !0), r = 0; r < e.length; r++) 16 === this._remainingCounterIndex && (this._remainingCounter = this._aes.encrypt(this._counter._counter), this._remainingCounterIndex = 0, this._counter.increment()), e[r] ^= this._remainingCounter[this._remainingCounterIndex++];
                return e
            }, C.prototype.decrypt = C.prototype.encrypt;
            var k = {
                AES: a,
                Counter: P,
                ModeOfOperation: {
                    ecb: B,
                    cbc: T,
                    cfb: O,
                    ofb: D,
                    ctr: C
                },
                utils: {
                    hex: e,
                    utf8: t
                },
                padding: {
                    pkcs7: {
                        pad: function (t) {
                            var e = 16 - (t = i(t, !0)).length % 16,
                                r = u(t.length + e);
                            s(t, r);
                            for (var o = t.length; o < r.length; o++) r[o] = e;
                            return r
                        },
                        strip: function (t) {
                            if ((t = i(t, !0)).length < 16) throw new Error("PKCS#7 invalid length");
                            var e = t[t.length - 1];
                            if (16 < e) throw new Error("PKCS#7 padding byte out of range");
                            for (var r = t.length - e, o = 0; o < e; o++)
                                if (t[r + o] !== e) throw new Error("PKCS#7 invalid padding byte");
                            var n = u(r);
                            return s(t, n, 0, 0, r), n
                        }
                    }
                },
                _arrayTest: {
                    coerceArray: i,
                    createArray: u,
                    copyArray: s
                }
            };
            L.exports = k
        }()
    }),
        Dv = new function () { };
    Dv.remoteConfigBackupAddr = "https://platform.xesimg.com/chat/conf/chat.conf", Dv.remoteConfigAddr = "https://chatconf.msg.xescdn.com/chat/v1/getConfig", Dv.remoteConfigRetry = 6, Dv.remoteConfigTimeout = 1e3, Dv.pingTimeout = 2e4, Dv.pingInterval = 8e3, Dv.dispatchList = ["https://chatgslb.xescdn.com/chat/v2/getserver", "https://chatgslb.xesimg.com/chat/v2/getserver"], Dv.reDispatchTimeout = 3e4, Dv.contentMaxLength = 10240, Dv.receiverMaxNum = 400;
    var Pv, Cv = t(function (t, e) {
        var n = p && p.__spreadArrays || function () {
            for (var t = 0, e = 0, r = arguments.length; e < r; e++) t += arguments[e].length;
            var o = Array(t),
                n = 0;
            for (e = 0; e < r; e++)
                for (var i = arguments[e], s = 0, a = i.length; s < a; s++, n++) o[n] = i[s];
            return o
        };
        Object.defineProperty(e, "__esModule", {
            value: !0
        });
        var s = function (t, e, r) {
            this.name = t, this.version = e, this.os = r
        };
        e.BrowserInfo = s;
        var r = function (t) {
            this.version = t, this.name = "node", this.os = Xy.platform
        };
        e.NodeInfo = r;
        var a = function () {
            this.bot = !0, this.name = "bot", this.version = null, this.os = null
        };
        e.BotInfo = a;
        var u = 3,
            c = [
                ["aol", /AOLShield\/([0-9\._]+)/],
                ["edge", /Edge\/([0-9\._]+)/],
                ["yandexbrowser", /YaBrowser\/([0-9\._]+)/],
                ["vivaldi", /Vivaldi\/([0-9\.]+)/],
                ["kakaotalk", /KAKAOTALK\s([0-9\.]+)/],
                ["samsung", /SamsungBrowser\/([0-9\.]+)/],
                ["silk", /\bSilk\/([0-9._-]+)\b/],
                ["miui", /MiuiBrowser\/([0-9\.]+)$/],
                ["beaker", /BeakerBrowser\/([0-9\.]+)/],
                ["edge-chromium", /Edg\/([0-9\.]+)/],
                ["chromium-webview", /(?!Chrom.*OPR)wv\).*Chrom(?:e|ium)\/([0-9\.]+)(:?\s|$)/],
                ["chrome", /(?!Chrom.*OPR)Chrom(?:e|ium)\/([0-9\.]+)(:?\s|$)/],
                ["phantomjs", /PhantomJS\/([0-9\.]+)(:?\s|$)/],
                ["crios", /CriOS\/([0-9\.]+)(:?\s|$)/],
                ["firefox", /Firefox\/([0-9\.]+)(?:\s|$)/],
                ["fxios", /FxiOS\/([0-9\.]+)/],
                ["opera-mini", /Opera Mini.*Version\/([0-9\.]+)/],
                ["opera", /Opera\/([0-9\.]+)(?:\s|$)/],
                ["opera", /OPR\/([0-9\.]+)(:?\s|$)/],
                ["ie", /Trident\/7\.0.*rv\:([0-9\.]+).*\).*Gecko$/],
                ["ie", /MSIE\s([0-9\.]+);.*Trident\/[4-7].0/],
                ["ie", /MSIE\s(7\.0)/],
                ["bb10", /BB10;\sTouch.*Version\/([0-9\.]+)/],
                ["android", /Android\s([0-9\.]+)/],
                ["ios", /Version\/([0-9\._]+).*Mobile.*Safari.*/],
                ["safari", /Version\/([0-9\._]+).*Safari/],
                ["facebook", /FBAV\/([0-9\.]+)/],
                ["instagram", /Instagram\s([0-9\.]+)/],
                ["ios-webview", /AppleWebKit\/([0-9\.]+).*Mobile/],
                ["ios-webview", /AppleWebKit\/([0-9\.]+).*Gecko\)$/],
                ["searchbot", /alexa|bot|crawl(er|ing)|facebookexternalhit|feedburner|google web preview|nagios|postrank|pingdom|slurp|spider|yahoo!|yandex/]
            ],
            i = [
                ["iOS", /iP(hone|od|ad)/],
                ["Android OS", /Android/],
                ["BlackBerry OS", /BlackBerry|BB10/],
                ["Windows Mobile", /IEMobile/],
                ["Amazon OS", /Kindle/],
                ["Windows 3.11", /Win16/],
                ["Windows 95", /(Windows 95)|(Win95)|(Windows_95)/],
                ["Windows 98", /(Windows 98)|(Win98)/],
                ["Windows 2000", /(Windows NT 5.0)|(Windows 2000)/],
                ["Windows XP", /(Windows NT 5.1)|(Windows XP)/],
                ["Windows Server 2003", /(Windows NT 5.2)/],
                ["Windows Vista", /(Windows NT 6.0)/],
                ["Windows 7", /(Windows NT 6.1)/],
                ["Windows 8", /(Windows NT 6.2)/],
                ["Windows 8.1", /(Windows NT 6.3)/],
                ["Windows 10", /(Windows NT 10.0)/],
                ["Windows ME", /Windows ME/],
                ["Open BSD", /OpenBSD/],
                ["Sun OS", /SunOS/],
                ["Chrome OS", /CrOS/],
                ["Linux", /(Linux)|(X11)/],
                ["Mac OS", /(Mac_PowerPC)|(Macintosh)/],
                ["QNX", /QNX/],
                ["BeOS", /BeOS/],
                ["OS/2", /OS\/2/],
                ["Search Bot", /(nuhk)|(Googlebot)|(Yammybot)|(Openbot)|(Slurp)|(MSNBot)|(Ask Jeeves\/Teoma)|(ia_archiver)/]
            ];

        function o(i) {
            var t = "" !== i && c.reduce(function (t, e) {
                var r = e[0],
                    o = e[1];
                if (t) return t;
                var n = o.exec(i);
                return !!n && [r, n]
            }, !1);
            if (!t) return null;
            var e = t[0],
                r = t[1];
            if ("searchbot" === e) return new a;
            var o = r[1] && r[1].split(/[._]/).slice(0, 3);
            return o ? o.length < u && (o = n(o, function (t) {
                for (var e = [], r = 0; r < t; r++) e.push("0");
                return e
            }(u - o.length))) : o = [], new s(e, o.join("."), f(i))
        }

        function f(t) {
            for (var e = 0, r = i.length; e < r; e++) {
                var o = i[e],
                    n = o[0];
                if (o[1].test(t)) return n
            }
            return null
        }

        function h() {
            return void 0 !== Xy && Xy.version ? new r(Xy.version.slice(1)) : null
        }
        e.detect = function (t) {
            return t ? o(t) : "undefined" != typeof navigator ? o(navigator.userAgent) : h()
        }, e.parseUserAgent = o, e.detectOS = f, e.getNodeVersion = h
    });
    (Pv = Cv) && Pv.__esModule && Object.prototype.hasOwnProperty.call(Pv, "default") && Pv.default;
    Cv.BrowserInfo, Cv.NodeInfo, Cv.BotInfo;
    var kv = Cv.detect;
    Cv.parseUserAgent, Cv.detectOS, Cv.getNodeVersion;
    var Lv = (Ev.prototype.reset = function (t, e, r, o, n, i, s) {
        var a = this;
        this.remoteLogServer = t, this.appId = e, this.psId = o, this.nickname = n, this.liveId = i, this.businessId = r, this.url = s;
        var u = function () {
            var t = kv();
            return {
                dev: (t && t.name ? t.name : "unknown") + "-" + (t && t.version ? t.version : "unknown"),
                os: t && t.os ? t.os : "unknown",
                agentGen: function (t) {
                    return "ChatSdk WEB(" + t + ")"
                }
            }
        }(),
            c = u.os,
            f = u.dev,
            h = u.agentGen;
        this.os = c, this.dev = f, this.agent = h(_R), this.messageList = [], this.sendMessageTask || (clearInterval(this.sendMessageTask), this.sendMessageTask = null), this.sendMessageTask = setInterval(function () {
            a.sendMessage()
        }, 15e3)
    }, Ev.prototype.destroy = function () {
        if (clearInterval(this.sendMessageTask), this.sendMessageTask = null, 0 < this.messageList.length) {
            var t = this.logDebug(622, this.messageList);
            this.messageList = new Array, this.log(t)
        }
    }, Ev.prototype.sendMessage = function () {
        if (0 === this.messageList.length) {
            var t = this.logDebug(622, []);
            this.log(t)
        } else
            for (; 0 < this.messageList.length;) {
                var e = this.messageList.splice(0, 10);
                t = this.logDebug(622, e), this.log(t)
            }
    }, Ev.prototype.logBase = function (t) {
        return {
            ver: 1,
            serv: 620,
            pri: t,
            ts: this.ntpTime.getTime(),
            appId: this.appId,
            businessId: this.businessId,
            psId: this.psId,
            agent: this.agent,
            os: this.os,
            dev: this.dev,
            arch: "",
            ram: 0,
            net: 10,
            cpu: 0,
            mem: 0,
            cip: "",
            lip: "",
            sip: "",
            tid: this.nickname + "-" + this.ntpTime.getTime(),
            pridata: {}
        }
    }, Ev.prototype.logRemoteConfig = function (t, e, r, o) {
        var n = this.logBase(2);
        n.pridata = {
            url: t,
            code: e,
            msg: r,
            dns: 0,
            delay: o,
            businessId: this.businessId,
            liveId: this.liveId
        }, this.log(n)
    }, Ev.prototype.logDispatch = function (t, e, r, o) {
        var n = this.logBase(0);
        n.pridata = {
            url: t,
            code: e,
            msg: r,
            dns: 0,
            delay: o,
            businessId: this.businessId,
            liveId: this.liveId
        }, this.log(n)
    }, Ev.prototype.logConnect = function (t, e, r) {
        var o = this.logBase(620);
        o.pridata = {
            url: this.url,
            code: t,
            msg: e,
            delay: r,
            chatUid: this.nickname,
            businessId: this.businessId,
            liveId: this.liveId
        }, this.log(o)
    }, Ev.prototype.logNetChange = function (t, e, r, o, n) {
        var i = this.logBase(621);
        i.pridata = {
            url: this.url,
            code: t,
            msg: e,
            state: r,
            lifetime: o,
            chatUid: this.nickname,
            roomId: n.join(","),
            businessId: this.businessId,
            liveId: this.liveId
        }, this.log(i)
    }, Ev.prototype.logJoinRoom = function (t, e, r) {
        var o = {
            code: 610,
            info: {
                snd_time: this.ntpTime.getISOTime(),
                from: t,
                to: e.join(","),
                msgSubscribe: r,
                action: "JoinChatRooms"
            }
        };
        this.messageList.push(o)
    }, Ev.prototype.logJoinRoomResp = function (t, e) {
        var r = {
            code: 611,
            info: {
                rcv_time: this.ntpTime.getISOTime(),
                from: t,
                to: e,
                callback: "OnJoinRoomResponse"
            }
        };
        this.messageList.push(r)
    }, Ev.prototype.logRecvRoomData = function (t, e, r, o) {
        var n = {
            code: 611,
            info: {
                msg_md5: "",
                priority: 0,
                rcv_time: this.ntpTime.getISOTime(),
                from: t,
                to: e,
                msg_id: r,
                callback: "onRecvRoomDataUpdateNotice",
                msgDelay: o
            }
        };
        this.messageList.push(n)
    }, Ev.prototype.logLeaveRoom = function (t, e) {
        var r = {
            code: 610,
            info: {
                rcv_time: this.ntpTime.getISOTime(),
                from: t,
                to: e,
                action: "leaveChatRooms"
            }
        };
        this.messageList.push(r)
    }, Ev.prototype.logLeaveResp = function (t, e) {
        var r = {
            code: 611,
            info: {
                rcv_time: this.ntpTime.getISOTime(),
                from: t,
                to: e,
                action: "OnLeavenRoomResponse"
            }
        };
        this.messageList.push(r)
    }, Ev.prototype.logSendRoomMsg = function (t, e, r, o, n, i) {
        var s = {
            code: 610,
            info: {
                msg_md5: JR(t),
                priority: e,
                snd_time: this.ntpTime.getISOTime(),
                from: r.nickname,
                from_psid: r.psId,
                to: o.map(function (t) {
                    return t.recver
                }).join(","),
                action: "sendRoomMessage",
                rtt: n,
                msg_id: String(i)
            }
        };
        this.messageList.push(s)
    }, Ev.prototype.logRecvRoomMsg = function (t, e, r, o, n, i) {
        var s = {
            code: 611,
            info: {
                msg_md5: JR(t),
                priority: e,
                rcv_time: this.ntpTime.getISOTime(),
                from: r.nickname,
                psid: r.psId,
                to: o,
                callback: "OnRecvRoomMessage",
                msgDelay: n,
                msg_id: i
            }
        };
        this.messageList.push(s)
    }, Ev.prototype.logSendPeerMsg = function (t, e, r, o, n, i) {
        var s = {
            code: 610,
            info: {
                msg_md5: JR(t),
                priority: e,
                snd_time: this.ntpTime.getISOTime(),
                from: r.nickname,
                from_psid: r.psId,
                to: i.map(function (t) {
                    return t.recver
                }).join(","),
                number: i.length,
                action: "sendPeerMessage",
                rtt: o,
                msg_id: String(n)
            }
        };
        this.messageList.push(s)
    }, Ev.prototype.logRecvPeerMsg = function (t, e, r, o, n) {
        var i = {
            code: 611,
            info: {
                msg_md5: JR(t),
                priority: 1,
                rcv_time: this.ntpTime.getISOTime(),
                from: e.nickname,
                from_psid: e.psId,
                to: r.nickname,
                to_psid: r.psId,
                msg_id: String(o),
                callback: "OnRecvPeerMessage",
                msgDelay: n
            }
        };
        this.messageList.push(i)
    }, Ev.prototype.logSendRoomBinMsg = function (t, e, r, o, n, i, s, a, u) {
        if (!u || this.binMsgReqSeq++ % u == 0) {
            var c = {
                code: 610,
                info: {
                    rtt: a,
                    db_key: r,
                    resp_code: o,
                    snd_time: this.ntpTime.getISOTime(),
                    action: "SendRoomBinaryMessage",
                    resp_info: n,
                    from: i.nickname,
                    to: s.join(","),
                    key_msg_id: e,
                    msg_id: t
                }
            };
            this.messageList.push(c)
        }
    }, Ev.prototype.logRecvRoomBinMsg = function (t, e, r, o, n, i, s) {
        if (!s || this.binMsgSeq++ % s == 0) {
            var a = {
                code: 611,
                info: {
                    recv_time: this.ntpTime.getISOTime(),
                    db_key: r,
                    from: o.nickname,
                    psid: o.psId,
                    to: n,
                    msg_id: String(t),
                    key_msg_id: e,
                    callback: "OnRecvRoomBinaryMessage",
                    msgDelay: i
                }
            };
            this.messageList.push(a)
        }
    }, Ev.prototype.log = function (t) {
        this.remoteLogServer && gv(this.remoteLogServer, {
            data: t
        })
    }, Ev.prototype.logDebug = function (t, e) {
        var r = this.logBase(t);
        return r.pridata = {
            url: this.url,
            chatUid: this.nickname,
            roomId: this.roomId,
            liveId: this.liveId,
            businessId: this.businessId,
            messages: e
        }, r
    }, Ev);

    function Ev(t) {
        this.binMsgSeq = 0, this.binMsgReqSeq = 0, this.ntpTime = t
    }
    var Nv = (Uv.prototype.registry = function (t, e, r) {
        this.traceMap.set(t, {
            callback: e,
            msgs: new Array,
            data: r
        })
    }, Uv.prototype.recvMsgs = function (t, e, r) {
        var o = this.traceMap.get(t);
        o && (o.msgs.push(r), e && (this.traceMap.delete(t), o.callback(o.msgs, o.data)))
    }, Uv);

    function Uv() {
        this.traceMap = new Map
    }
    var Gv = (Fv.prototype.reset = function (t, e, r) {
        var o = this.messageLimits.get(t);
        o ? o.reset(e, r) : this.messageLimits.set(t, new jv(e, r))
    }, Fv.prototype.add = function (t) {
        var e = this.messageLimits.get(t);
        return !e || e.add()
    }, Fv);

    function Fv(t) {
        var e, r;
        this.messageLimits = new Map;
        try {
            for (var o = Xl(t), n = o.next(); !n.done; n = o.next()) {
                var i = n.value;
                this.messageLimits.set(i.namespace, new jv(i.interval, i.limit))
            }
        } catch (t) {
            e = {
                error: t
            }
        } finally {
            try {
                n && !n.done && (r = o.return) && r.call(o)
            } finally {
                if (e) throw e.error
            }
        }
    }
    var jv = (Av.prototype.add = function () {
        return this.limit < 0 || !(this.interval <= 0) && 0 < this.limit - this.num && (this.num++, !0)
    }, Av.prototype.destroy = function () {
        this.cleanInterval && (clearInterval(this.cleanInterval), this.cleanInterval = null)
    }, Av.prototype.reset = function (t, e) {
        var r = this;
        this.cleanInterval && (clearInterval(this.cleanInterval), this.cleanInterval = null), this.interval = t, this.limit = e, (this.num = 0) < this.interval && (this.cleanInterval = setInterval(function () {
            r.num = 0
        }, this.interval))
    }, Av);

    function Av(t, e) {
        this.reset(t, e)
    }
    var xv = function (t) {
        return new Yv(t || $v, null)
    };

    function qv(t, e, r, o, n, i) {
        this._color = t, this.key = e, this.value = r, this.left = o, this.right = n, this._count = i
    }

    function Hv(t) {
        return new qv(t._color, t.key, t.value, t.left, t.right, t._count)
    }

    function Vv(t, e) {
        return new qv(t, e.key, e.value, e.left, e.right, e._count)
    }

    function Kv(t) {
        t._count = 1 + (t.left ? t.left._count : 0) + (t.right ? t.right._count : 0)
    }

    function Yv(t, e) {
        this._compare = t, this.root = e
    }
    var Wv = Yv.prototype;

    function Jv(t, e) {
        this.tree = t, this._stack = e
    }
    Object.defineProperty(Wv, "keys", {
        get: function () {
            var r = [];
            return this.forEach(function (t, e) {
                r.push(t)
            }), r
        }
    }), Object.defineProperty(Wv, "values", {
        get: function () {
            var r = [];
            return this.forEach(function (t, e) {
                r.push(e)
            }), r
        }
    }), Object.defineProperty(Wv, "length", {
        get: function () {
            return this.root ? this.root._count : 0
        }
    }), Wv.insert = function (t, e) {
        for (var r = this._compare, o = this.root, n = [], i = []; o;) {
            var s = r(t, o.key);
            n.push(o), i.push(s), o = s <= 0 ? o.left : o.right
        }
        n.push(new qv(0, t, e, null, null, 1));
        for (var a = n.length - 2; 0 <= a; --a) {
            o = n[a];
            i[a] <= 0 ? n[a] = new qv(o._color, o.key, o.value, n[a + 1], o.right, o._count + 1) : n[a] = new qv(o._color, o.key, o.value, o.left, n[a + 1], o._count + 1)
        }
        for (a = n.length - 1; 1 < a; --a) {
            var u = n[a - 1];
            o = n[a];
            if (1 === u._color || 1 === o._color) break;
            var c = n[a - 2];
            if (c.left === u)
                if (u.left === o) {
                    if (!(f = c.right) || 0 !== f._color) {
                        if (c._color = 0, c.left = u.right, u._color = 1, u.right = c, n[a - 2] = u, n[a - 1] = o, Kv(c), Kv(u), 3 <= a) (h = n[a - 3]).left === c ? h.left = u : h.right = u;
                        break
                    }
                    u._color = 1, c.right = Vv(1, f), c._color = 0, a -= 1
                } else {
                    if (!(f = c.right) || 0 !== f._color) {
                        if (u.right = o.left, c._color = 0, c.left = o.right, o._color = 1, o.left = u, o.right = c, n[a - 2] = o, n[a - 1] = u, Kv(c), Kv(u), Kv(o), 3 <= a) (h = n[a - 3]).left === c ? h.left = o : h.right = o;
                        break
                    }
                    u._color = 1, c.right = Vv(1, f), c._color = 0, a -= 1
                }
            else if (u.right === o) {
                if (!(f = c.left) || 0 !== f._color) {
                    if (c._color = 0, c.right = u.left, u._color = 1, u.left = c, n[a - 2] = u, n[a - 1] = o, Kv(c), Kv(u), 3 <= a) (h = n[a - 3]).right === c ? h.right = u : h.left = u;
                    break
                }
                u._color = 1, c.left = Vv(1, f), c._color = 0, a -= 1
            } else {
                var f;
                if (!(f = c.left) || 0 !== f._color) {
                    var h;
                    if (u.left = o.right, c._color = 0, c.right = o.left, o._color = 1, o.right = u, o.left = c, n[a - 2] = o, n[a - 1] = u, Kv(c), Kv(u), Kv(o), 3 <= a) (h = n[a - 3]).right === c ? h.right = o : h.left = o;
                    break
                }
                u._color = 1, c.left = Vv(1, f), c._color = 0, a -= 1
            }
        }
        return n[0]._color = 1, new Yv(r, n[0])
    }, Wv.forEach = function (t, e, r) {
        if (this.root) switch (arguments.length) {
            case 1:
                return function t(e, r) {
                    var o;
                    if (r.left && (o = t(e, r.left))) return o;
                    return (o = e(r.key, r.value)) || (r.right ? t(e, r.right) : void 0)
                }(t, this.root);
            case 2:
                return function t(e, r, o, n) {
                    if (r(e, n.key) <= 0) {
                        var i;
                        if (n.left && (i = t(e, r, o, n.left))) return i;
                        if (i = o(n.key, n.value)) return i
                    }
                    if (n.right) return t(e, r, o, n.right)
                }(e, this._compare, t, this.root);
            case 3:
                if (0 <= this._compare(e, r)) return;
                return function t(e, r, o, n, i) {
                    var s, a = o(e, i.key),
                        u = o(r, i.key);
                    if (a <= 0) {
                        if (i.left && (s = t(e, r, o, n, i.left))) return s;
                        if (0 < u && (s = n(i.key, i.value))) return s
                    }
                    if (0 < u && i.right) return t(e, r, o, n, i.right)
                }(e, r, this._compare, t, this.root)
        }
    }, Object.defineProperty(Wv, "begin", {
        get: function () {
            for (var t = [], e = this.root; e;) t.push(e), e = e.left;
            return new Jv(this, t)
        }
    }), Object.defineProperty(Wv, "end", {
        get: function () {
            for (var t = [], e = this.root; e;) t.push(e), e = e.right;
            return new Jv(this, t)
        }
    }), Wv.at = function (t) {
        if (t < 0) return new Jv(this, []);
        for (var e = this.root, r = []; ;) {
            if (r.push(e), e.left) {
                if (t < e.left._count) {
                    e = e.left;
                    continue
                }
                t -= e.left._count
            }
            if (!t) return new Jv(this, r);
            if (t -= 1, !e.right) break;
            if (t >= e.right._count) break;
            e = e.right
        }
        return new Jv(this, [])
    }, Wv.ge = function (t) {
        for (var e = this._compare, r = this.root, o = [], n = 0; r;) {
            var i = e(t, r.key);
            o.push(r), i <= 0 && (n = o.length), r = i <= 0 ? r.left : r.right
        }
        return o.length = n, new Jv(this, o)
    }, Wv.gt = function (t) {
        for (var e = this._compare, r = this.root, o = [], n = 0; r;) {
            var i = e(t, r.key);
            o.push(r), i < 0 && (n = o.length), r = i < 0 ? r.left : r.right
        }
        return o.length = n, new Jv(this, o)
    }, Wv.lt = function (t) {
        for (var e = this._compare, r = this.root, o = [], n = 0; r;) {
            var i = e(t, r.key);
            o.push(r), 0 < i && (n = o.length), r = i <= 0 ? r.left : r.right
        }
        return o.length = n, new Jv(this, o)
    }, Wv.le = function (t) {
        for (var e = this._compare, r = this.root, o = [], n = 0; r;) {
            var i = e(t, r.key);
            o.push(r), 0 <= i && (n = o.length), r = i < 0 ? r.left : r.right
        }
        return o.length = n, new Jv(this, o)
    }, Wv.find = function (t) {
        for (var e = this._compare, r = this.root, o = []; r;) {
            var n = e(t, r.key);
            if (o.push(r), 0 === n) return new Jv(this, o);
            r = n <= 0 ? r.left : r.right
        }
        return new Jv(this, [])
    }, Wv.remove = function (t) {
        var e = this.find(t);
        return e ? e.remove() : this
    }, Wv.get = function (t) {
        for (var e = this._compare, r = this.root; r;) {
            var o = e(t, r.key);
            if (0 === o) return r.value;
            r = o <= 0 ? r.left : r.right
        }
    };
    var zv = Jv.prototype;

    function Zv(t, e) {
        t.key = e.key, t.value = e.value, t.left = e.left, t.right = e.right, t._color = e._color, t._count = e._count
    }

    function $v(t, e) {
        return t < e ? -1 : e < t ? 1 : 0
    }
    Object.defineProperty(zv, "valid", {
        get: function () {
            return 0 < this._stack.length
        }
    }), Object.defineProperty(zv, "node", {
        get: function () {
            return 0 < this._stack.length ? this._stack[this._stack.length - 1] : null
        },
        enumerable: !0
    }), zv.clone = function () {
        return new Jv(this.tree, this._stack.slice())
    }, zv.remove = function () {
        var t = this._stack;
        if (0 === t.length) return this.tree;
        var e = new Array(t.length),
            r = t[t.length - 1];
        e[e.length - 1] = new qv(r._color, r.key, r.value, r.left, r.right, r._count);
        for (var o = t.length - 2; 0 <= o; --o) {
            (r = t[o]).left === t[o + 1] ? e[o] = new qv(r._color, r.key, r.value, e[o + 1], r.right, r._count) : e[o] = new qv(r._color, r.key, r.value, r.left, e[o + 1], r._count)
        }
        if ((r = e[e.length - 1]).left && r.right) {
            var n = e.length;
            for (r = r.left; r.right;) e.push(r), r = r.right;
            var i = e[n - 1];
            e.push(new qv(r._color, i.key, i.value, r.left, r.right, r._count)), e[n - 1].key = r.key, e[n - 1].value = r.value;
            for (o = e.length - 2; n <= o; --o) r = e[o], e[o] = new qv(r._color, r.key, r.value, r.left, e[o + 1], r._count);
            e[n - 1].left = e[n]
        }
        if (0 === (r = e[e.length - 1])._color) {
            var s = e[e.length - 2];
            s.left === r ? s.left = null : s.right === r && (s.right = null), e.pop();
            for (o = 0; o < e.length; ++o) e[o]._count--;
            return new Yv(this.tree._compare, e[0])
        }
        if (r.left || r.right) {
            r.left ? Zv(r, r.left) : r.right && Zv(r, r.right), r._color = 1;
            for (o = 0; o < e.length - 1; ++o) e[o]._count--;
            return new Yv(this.tree._compare, e[0])
        }
        if (1 === e.length) return new Yv(this.tree._compare, null);
        for (o = 0; o < e.length; ++o) e[o]._count--;
        var a = e[e.length - 2];
        return function (t) {
            for (var e, r, o, n, i = t.length - 1; 0 <= i; --i) {
                if (e = t[i], 0 === i) return e._color = 1;
                if ((r = t[i - 1]).left === e) {
                    if ((o = r.right).right && 0 === o.right._color) {
                        if (n = (o = r.right = Hv(o)).right = Hv(o.right), r.right = o.left, o.left = r, o.right = n, o._color = r._color, e._color = 1, r._color = 1, n._color = 1, Kv(r), Kv(o), 1 < i) (s = t[i - 2]).left === r ? s.left = o : s.right = o;
                        return t[i - 1] = o
                    }
                    if (o.left && 0 === o.left._color) {
                        if (n = (o = r.right = Hv(o)).left = Hv(o.left), r.right = n.left, o.left = n.right, n.left = r, n.right = o, n._color = r._color, r._color = 1, o._color = 1, e._color = 1, Kv(r), Kv(o), Kv(n), 1 < i) (s = t[i - 2]).left === r ? s.left = n : s.right = n;
                        return t[i - 1] = n
                    }
                    if (1 === o._color) {
                        if (0 === r._color) return r._color = 1, r.right = Vv(0, o);
                        r.right = Vv(0, o);
                        continue
                    }
                    o = Hv(o), r.right = o.left, o.left = r, o._color = r._color, r._color = 0, Kv(r), Kv(o), 1 < i && ((s = t[i - 2]).left === r ? s.left = o : s.right = o), t[i - 1] = o, t[i] = r, i + 1 < t.length ? t[i + 1] = e : t.push(e), i += 2
                } else {
                    if ((o = r.left).left && 0 === o.left._color) {
                        if (n = (o = r.left = Hv(o)).left = Hv(o.left), r.left = o.right, o.right = r, o.left = n, o._color = r._color, e._color = 1, r._color = 1, n._color = 1, Kv(r), Kv(o), 1 < i) (s = t[i - 2]).right === r ? s.right = o : s.left = o;
                        return t[i - 1] = o
                    }
                    if (o.right && 0 === o.right._color) {
                        if (n = (o = r.left = Hv(o)).right = Hv(o.right), r.left = n.right, o.right = n.left, n.right = r, n.left = o, n._color = r._color, r._color = 1, o._color = 1, e._color = 1, Kv(r), Kv(o), Kv(n), 1 < i) (s = t[i - 2]).right === r ? s.right = n : s.left = n;
                        return t[i - 1] = n
                    }
                    if (1 === o._color) {
                        if (0 === r._color) return r._color = 1, r.left = Vv(0, o);
                        r.left = Vv(0, o);
                        continue
                    }
                    var s;
                    o = Hv(o), r.left = o.right, o.right = r, o._color = r._color, r._color = 0, Kv(r), Kv(o), 1 < i && ((s = t[i - 2]).right === r ? s.right = o : s.left = o), t[i - 1] = o, t[i] = r, i + 1 < t.length ? t[i + 1] = e : t.push(e), i += 2
                }
            }
        }(e), a.left === r ? a.left = null : a.right = null, new Yv(this.tree._compare, e[0])
    }, Object.defineProperty(zv, "key", {
        get: function () {
            if (0 < this._stack.length) return this._stack[this._stack.length - 1].key
        },
        enumerable: !0
    }), Object.defineProperty(zv, "value", {
        get: function () {
            if (0 < this._stack.length) return this._stack[this._stack.length - 1].value
        },
        enumerable: !0
    }), Object.defineProperty(zv, "index", {
        get: function () {
            var t = 0,
                e = this._stack;
            if (0 === e.length) {
                var r = this.tree.root;
                return r ? r._count : 0
            }
            e[e.length - 1].left && (t = e[e.length - 1].left._count);
            for (var o = e.length - 2; 0 <= o; --o) e[o + 1] === e[o].right && (++t, e[o].left && (t += e[o].left._count));
            return t
        },
        enumerable: !0
    }), zv.next = function () {
        var t = this._stack;
        if (0 !== t.length) {
            var e = t[t.length - 1];
            if (e.right)
                for (e = e.right; e;) t.push(e), e = e.left;
            else
                for (t.pop(); 0 < t.length && t[t.length - 1].right === e;) e = t[t.length - 1], t.pop()
        }
    }, Object.defineProperty(zv, "hasNext", {
        get: function () {
            var t = this._stack;
            if (0 === t.length) return !1;
            if (t[t.length - 1].right) return !0;
            for (var e = t.length - 1; 0 < e; --e)
                if (t[e - 1].left === t[e]) return !0;
            return !1
        }
    }), zv.update = function (t) {
        var e = this._stack;
        if (0 === e.length) throw new Error("Can't update empty node!");
        var r = new Array(e.length),
            o = e[e.length - 1];
        r[r.length - 1] = new qv(o._color, o.key, t, o.left, o.right, o._count);
        for (var n = e.length - 2; 0 <= n; --n)(o = e[n]).left === e[n + 1] ? r[n] = new qv(o._color, o.key, o.value, r[n + 1], o.right, o._count) : r[n] = new qv(o._color, o.key, o.value, o.left, r[n + 1], o._count);
        return new Yv(this.tree._compare, r[0])
    }, zv.prev = function () {
        var t = this._stack;
        if (0 !== t.length) {
            var e = t[t.length - 1];
            if (e.left)
                for (e = e.left; e;) t.push(e), e = e.right;
            else
                for (t.pop(); 0 < t.length && t[t.length - 1].left === e;) e = t[t.length - 1], t.pop()
        }
    }, Object.defineProperty(zv, "hasPrev", {
        get: function () {
            var t = this._stack;
            if (0 === t.length) return !1;
            if (t[t.length - 1].left) return !0;
            for (var e = t.length - 1; 0 < e; --e)
                if (t[e - 1].right === t[e]) return !0;
            return !1
        }
    });
    var Xv = (Qv.prototype.init = function (t, e, r, o) {
        this.waitTimeout = t, this.pullTimeout = e, this.messageCallback = r, this.messageTimeoutCallback = o
    }, Qv.prototype.destroyAll = function () {
        this.messageSyncMap.forEach(function (t) {
            t.destroy()
        })
    }, Qv.prototype.recvMessage = function (t, e, r) {
        var o;
        this.messageSyncMap.has(t) ? o = this.messageSyncMap.get(t) : ((o = new tw).init(this.waitTimeout, this.pullTimeout, this.messageCallback.bind(null, t), this.messageTimeoutCallback.bind(null, t)), this.messageSyncMap.set(t, o)), o.recvMessage(e, r)
    }, Qv.prototype.getMinSeq = function (t) {
        return this.messageSyncMap.has(t) ? this.messageSyncMap.get(t).getMinSeq() : -1
    }, Qv.prototype.getSeqId = function (t) {
        return this.messageSyncMap.has(t) ? this.messageSyncMap.get(t).getSeqId() : -1
    }, Qv);

    function Qv() {
        this.messageSyncMap = new Map
    }
    var tw = (ew.prototype.init = function (t, e, r, o) {
        this.waitTimeout = t, this.pullTimeout = e, this.messageCallback = r, this.messageTimeoutCallback = o
    }, ew.prototype.destroy = function () {
        this.messageList = xv(), this.waitTimeoutHandler && (clearTimeout(this.waitTimeoutHandler), this.waitTimeoutHandler = null), this.pullTimeoutHandler && (clearTimeout(this.pullTimeoutHandler), this.pullTimeoutHandler = null)
    }, ew.prototype.getSeqId = function () {
        return this.seqId = this.seqId ? this.seqId + 1 : 0, this.seqId
    }, ew.prototype.getMinSeq = function () {
        return this.minSeq
    }, ew.prototype.recvMessage = function (t, e) {
        console.log("recvMessage minSeq:" + this.minSeq + " seq:" + t + " msg:" + e), t <= this.minSeq ? console.log("recvMessage 无效消息 丢弃") : (this.messageList = this.messageList.insert(t, e), console.log("recvMessage messageListSize:" + this.messageList.length + " messageListKeys:" + this.messageList.keys), this.doReadMessage())
    }, ew.prototype.doReadMessage = function () {
        for (var t = this.messageList.begin; ;) {
            var e = t.key,
                r = t.value;
            if (console.log("doReadMessage minSeq:" + this.minSeq + " uintPrevSeqId:" + r.unitPrevSeqId + " msg:" + r), !(this.minSeq <= 0 || this.minSeq === r.unitPrevSeqId)) {
                console.log("doReadMessage 探测到消息空洞"), this.waitTimeoutHandler || (this.waitTimeoutHandler = setTimeout(this.handleMessageTimeout, this.waitTimeout), console.log("waitTimeoutHandler", this.waitTimeoutHandler));
                break
            }
            if (this.messageList = this.messageList.remove(e), this.doMessageCallback(r), !t.hasNext) break;
            t.next()
        }
    }, ew.prototype.doMessageCallback = function (t) {
        console.log("doMessageCallback", t), this.pullTimeoutHandler && (clearTimeout(this.pullTimeoutHandler), this.pullTimeoutHandler = null), this.waitTimeoutHandler && (clearTimeout(this.waitTimeoutHandler), this.waitTimeoutHandler = null), this.minSeq = t.unitSeqId, this.messageCallback(t)
    }, ew.prototype.pullMessageTimeoutCallback = function () {
        console.log("pullMessageTimeoutCallback 空洞消息拉取超时"), this.pullTimeoutHandler = null, this.waitTimeoutHandler = null, this.minSeq = -1, this.doReadMessage()
    }, ew);

    function ew() {
        var r = this;
        this.handleMessageTimeout = function () {
            r.pullTimeoutHandler || (r.pullTimeoutHandler = setTimeout(function () {
                return r.pullMessageTimeoutCallback()
            }, r.pullTimeout)), console.log("handleMessageTimeout messageListKeys:" + r.messageList.keys);
            var t = r.minSeq,
                e = r.messageList.begin.key;
            console.log("handleMessageTimeout 拉取空洞 begin:" + t + " end:" + e), r.messageTimeoutCallback(t, e)
        }, this.messageList = xv(), this.minSeq = -1
    }
    var rw = (ow.prototype.initNamespace = function (t, e, r, o, n) {
        this.namespaceMap.set(t, {
            sendFunc: e,
            callbackHandler: r,
            timeoutHandler: o,
            sendTimeout: n
        })
    }, ow.prototype.destroyAll = function () {
        this.namespaceMap = new Map, this.messageSeqId = 1, this.messageList = xv(), this.msgMap.forEach(function (t) {
            var e = t.timeouter;
            return clearTimeout(e)
        }), this.msgMap = new Map
    }, ow.prototype.send = function (t, e, r) {
        var o = this.namespaceMap.get(t),
            n = o.sendFunc,
            i = o.sendTimeout,
            s = this.messageSeqId++,
            a = n(e(s));
        return this.msgMap.set(a.seqId, {
            namespace: t,
            msg: a,
            seq: s,
            realSeqId: a.seqId,
            sync: r,
            timeouter: setTimeout(this.handleTimeout, i, a.seqId)
        }), r && (this.messageList = this.messageList.insert(s, a.seqId)), a
    }, ow.prototype.reSend = function () {
        for (var o = this, t = new Array, e = this.messageList.begin; e.valid;) {
            var r = e.value,
                n = e.key;
            console.log("seqId:" + r + " seq:" + n);
            var i = this.msgMap.get(r),
                s = i.namespace,
                a = i.msg,
                u = i.realSeqId,
                c = i.timeouter,
                f = i.sync;
            clearTimeout(c), this.msgMap.delete(r);
            var h = this.namespaceMap.get(s),
                p = h.sendFunc,
                d = h.sendTimeout,
                m = p(a.data);
            t.push({
                seq: n,
                seqId: m.seqId
            }), this.msgMap.set(m.seqId, {
                namespace: s,
                msg: m,
                seq: n,
                realSeqId: u,
                sync: f,
                timeouter: setTimeout(this.handleTimeout, d, m.seqId)
            }), e.next()
        }
        this.messageList = xv(), t.forEach(function (t) {
            var e = t.seq,
                r = t.seqId;
            o.messageList = o.messageList.insert(e, r)
        })
    }, ow.prototype.callback = function (t, e, r) {
        if (this.msgMap.has(e)) {
            var o = this.msgMap.get(e),
                n = o.msg,
                i = o.realSeqId,
                s = o.timeouter,
                a = o.seq;
            clearTimeout(s), this.messageList = this.messageList.remove(a), this.msgMap.delete(e), (0, this.namespaceMap.get(t).callbackHandler)(r, n, i)
        } else console.error("recv unknown seqId", r)
    }, ow);

    function ow() {
        var a = this;
        this.handleTimeout = function (t) {
            var e = a.msgMap.get(t),
                r = e.realSeqId,
                o = e.namespace,
                n = e.msg,
                i = e.seq,
                s = a.namespaceMap.get(o).timeoutHandler;
            a.msgMap.delete(t), a.messageList = a.messageList.remove(i), s(n, r)
        }, this.namespaceMap = new Map, this.msgMap = new Map, this.messageSeqId = 1, this.messageList = xv()
    }
    var nw = (iw.prototype.ping = function () {
        this.lastPingTime = Date.now()
    }, iw.prototype.stop = function () {
        clearInterval(this.intervaler)
    }, iw.prototype.intervalHandler = function () {
        var t = Date.now() - this.lastPingTime;
        this.pingFunc(), t > this.pingTimeout && (this.stop(), this.timeoutFunc())
    }, iw);

    function iw(t, e, r, o) {
        this.pingInterval = t, this.pingTimeout = e, this.lastPingTime = Date.now(), this.pingFunc = r, this.timeoutFunc = o;
        var n = this.intervalHandler.bind(this);
        this.intervaler = setInterval(n, this.pingInterval)
    }

    function sw(r, o, n) {
        var i = {
            successCount: 0,
            errorCount: 0,
            requestDelayMs: 0
        };
        ! function t() {
            var e = Date.now();
            ! function (t, e, r, o) {
                mv(t, $l({
                    mode: "cors",
                    method: "OPTIONS"
                }, e)).then(function (t) {
                    if (console.log("response:", t, "----------"), !(200 <= t.status && t.status < 300)) throw new Error(t.statusText)
                }).then(function (t) {
                    console.log("option data:", t), r && r(t)
                }).catch(function (t) {
                    console.log("option err:", t), o && o(t.message)
                })
            }(r, {}, function () {
                console.log("success url:", r), i.requestDelayMs += Date.now() - e, i.successCount++, i.successCount + i.errorCount === o ? n(r, i) : t()
            }, function () {
                console.log("error url:", r), i.errorCount++, i.successCount + i.errorCount === o ? n(r, i) : t()
            })
        }()
    }

    function aw(t) {
        var e = !(("http" === t.protocol || "ws" === t.protocol) && 80 === t.port || ("https" === t.protocol || "wss" === t.protocol) && 443 === t.port);
        return t.protocol + "://" + (t.host || t.hostname) + (e ? ":" + t.port : "") + t.url
    }
    var uw = (cw.prototype.start = function () {
        this.handleCalibration()
    }, cw.prototype.stop = function () {
        this.timer && clearTimeout(this.timer)
    }, cw.prototype.destroy = function () {
        this.stop()
    }, cw.prototype.reset = function (t, e) {
        this.server = t, this.initUrl(), this.config = e, this.updateTimes = 0, this.stop(), this.start()
    }, cw.prototype.getOffset = function () {
        return this.offset
    }, cw.prototype.getTime = function () {
        return null === this.offset ? Date.now() : Date.now() - this.offset
    }, cw.prototype.getISOTime = function () {
        var t = this.getTime();
        return new Date(t).toISOString()
    }, cw.prototype.loopHandleCalibration = function () {
        var t = this;
        this.stop(), this.timer = setTimeout(function () {
            t.handleCalibration()
        }, 1e3 * this.config.interval[this.updateTimes >= this.config.set_number ? 1 : 0])
    }, cw.prototype.handleCalibration = function () {
        var o = this;
        (function (t) {
            return new Promise(function (r, o) {
                var n = new XMLHttpRequest,
                    i = null,
                    s = Date.now();
                n.open("GET", t, !0), n.onreadystatechange = function () {
                    switch (n.readyState) {
                        case XMLHttpRequest.HEADERS_RECEIVED:
                            i = Date.now();
                            break;
                        case XMLHttpRequest.DONE:
                            if (null === i && (i = Date.now()), 200 != n.status) {
                                o(new TypeError("status is " + n.status));
                                break
                            }
                            try {
                                var t = JSON.parse(n.responseText),
                                    e = i - t.data.serverTime;
                                r({
                                    offset: e,
                                    requestTime: i - s
                                })
                            } catch (t) {
                                o(new TypeError("json parse failed: " + t))
                            }
                    }
                }, n.onerror = function () {
                    o(new TypeError("Network request failed"))
                }, n.ontimeout = function () {
                    o(new TypeError("Network request failed"))
                }, n.send()
            })
        })(this.url).then(function (t) {
            var e = t.offset,
                r = t.requestTime;
            return r > o.config.timeout || (null === o.offset ? (o.offset = e, o.updateTimes++) : Math.abs(o.offset - e) > o.config.invalid_threshold ? (o.offset = e, o.updateTimes = 1) : (o.offset += Math.floor((e - o.offset) * o.config.weight / 100), o.updateTimes++)), o.log.debug("ntp time update: ", {
                offset: e,
                requestTime: r,
                caliOffset: o.offset
            }), o.loopHandleCalibration()
        }).catch(function (t) {
            return o.log.error("catch exception in ntp time calibration: ", t), o.loopHandleCalibration()
        })
    }, cw.prototype.initUrl = function () {
        var t = aw(this.server);
        this.server.params && (t += "?" + function (e) {
            return Object.keys(e).map(function (t) {
                return [t, e[t]].map(encodeURIComponent).join("=")
            }).join("&")
        }(this.server.params || {})), this.url = t
    }, cw);

    function cw(t) {
        this.offset = null, this.updateTimes = 0, this.log = t
    }
    var fw, hw, pw, dw, mw, lw = (ql(fw = yw, hw = pw = Sv), void (fw.prototype = null === hw ? Object.create(hw) : (gw.prototype = hw.prototype, new gw)), yw);

    function gw() {
        this.constructor = fw
    }

    function yw() {
        return null !== pw && pw.apply(this, arguments) || this
    } (mw = dw = dw || {})[mw.NoneEncpy = 0] = "NoneEncpy", mw[mw.AesEncpy = 1] = "AesEncpy";
    var _w, Rw, vw = (ww.prototype.init = function (t, e) {
        return ww.log.debug("init appId:", t, " appKey:", e), this.status !== _w.UnInit ? (ww.log.warn("init :already init"), zl.AlreadyInit) : t && e ? (this.userData.appId = t, this.userData.appKey = e, this.status = _w.Init, zl.Success) : (ww.log.error("init :param error"), zl.ParaError)
    }, ww.prototype.uninit = function () {
        return this.status !== _w.Init ? (ww.log.warn("当前状态不允许uninit status:", this.status), zl.UnInit) : (ww.log.debug("uninit"), this.status = _w.UnInit, this.liveInfo = null, this.registeredEvents.clear(), this.resultEvent.removeAllListeners(), zl.Success)
    }, ww.prototype.setLiveInfo = function (t) {
        return this.status === _w.UnInit ? (ww.log.error("setLiveInfo client 未初始化 不允许setLiveInfo"), zl.UnInit) : this.status !== _w.Init ? (ww.log.error("setLiveInfo 已经登陆，不允许在登陆状态修改liveInfo"), zl.AlreadyLogined) : (ww.log.debug("setLiveInfo liveInfo:", t), this.liveInfo = t, this.liveInfo.role = void 0 === t.role ? BR.RoleStudent : t.role, zl.Success)
    }, ww.prototype.setSdkProperties = function (t) {
        return this.status === _w.UnInit ? (ww.log.error("setLiveInfo client 未初始化 不允许setLiveInfo"), zl.UnInit) : this.status !== _w.Init ? (ww.log.error("setLiveInfo 已经登陆，不允许在登陆状态修改liveInfo"), zl.AlreadyLogined) : (ww.log.debug("setSdkProperties SdkProperties:", t), this.properties = t, zl.Success)
    }, ww.prototype.startNetworkQulityTest = function (t, e) {
        var o = this;
        return this.status === _w.UnInit ? (ww.log.error("setLiveInfo client 未初始化 不允许startNetworkQulityTest"), zl.UnInit) : (function (r, t, o) {
            for (var n = new Map, i = 0, e = 0; e < r.length; e++) sw(r[e], t, function (t, e) {
                console.log("url:", t, " statics:", e), i++, n.set(t, e), i === r.length && o(n)
            })
        }(t, e, function (t) {
            console.log("staticsMap:", t);
            var r = new Map;
            t.forEach(function (t, e) {
                r.set(e, {
                    url: e,
                    successRate: t.successCount / (t.successCount + t.errorCount),
                    avgRequestDelayMs: t.requestDelayMs / t.successCount
                })
            }), o.resultEvent.emit(sg, r)
        }), zl.Success)
    }, ww.prototype.loginWithMode = function (t, e, r, o) {
        if (this.loginBegin = Date.now(), ww.log.debug("login psId:", t, " password:", e), this.status === _w.UnInit) return ww.log.error("login 当前chat未初始化"), zl.UnInit;
        if (this.status !== _w.Init) return ww.log.error("login 当前chat未初始化"), zl.AlreadyInit;
        if (!this.liveInfo) return ww.log.error("login 当前client 未设置liveInfo 无法登陆"), zl.ParaError;
        if (!this.properties) return ww.log.error("login 当前client 未设置SdkProperties 无法登陆"), zl.ParaError;
        if (!this.properties.confService) return ww.log.error("login 当前client 未设置SdkProperties 配置地址 无法登陆"), zl.ParaError;
        if (this.properties.logService || ww.log.warn("login 当前client 未设置SdkProperties 日志地址 无法上传日志"), !t || !e) return ww.log.error("login psId或password为空 无法登陆"), zl.ParaError;
        var n = this.properties.logService,
            i = null;
        return n && (i = n.protocol + "://" + n.hostname + n.url), this.remoteLog.reset(i, this.userData.appId, this.liveInfo.businessId, this.userData.psId, this.liveInfo.nickname, this.liveInfo.liveId, ""), this.userData.psId = t, this.userData.password = e, this.userData.roomUserMode = r, this.userData.kickout = o, this.status = _w.Logging, this.tryRemoteConfig(), zl.Success
    }, ww.prototype.handleLoginResp = function (t) {
        var r = this;
        if (!t) {
            this.conn.close();
            var e = Date.now() - this.connectBegin;
            return this.remoteLog.logConnect(1, "登录报文超时", e), this.status = _w.Logging, void setTimeout(function () {
                return r.tryConnect()
            }, 0)
        }
        var o = dR.LoginResp.create(new hR.InputStream(new hR.BinBuffer(cR.from(t.data))));
        if (o.code === dR.Code.CodeSuccess) {
            if (this.serverData = {
                timeout: o.data.timeout,
                encpytType: o.data.encpytType,
                encryptKey: o.data.encryptKey,
                servInfo: o.data.servInfo
            }, 1 === o.data.encpytType) {
                for (var n = o.data.encryptKey.toNodeBuffer(), i = cR.from(this.userData.password), s = n.byteLength, a = i.byteLength, u = 0; u < s; u++) n[u] = n[u] ^ i[u % a];
                this.aesEcb = new Ov.ModeOfOperation.ecb(n)
            }
            if (this.status === _w.ReLogin) {
                this.status = _w.Login, ww.log.debug("handleLoginResp relogin successful");
                var c = {
                    netStatus: Kl.Connected
                };
                this.resultEvent.emit(ng, c), console.log("handleLoginResp 需要重新接入的房间", this.roomIds);
                var f = {};
                this.subOptions.forEach(function (t, e) {
                    var r = [];
                    t.forEach(function (t, e) {
                        r.push({
                            msgType: e,
                            flag: t
                        })
                    }), f[e] = r
                }), this.modeRoomIdMap.forEach(function (t, e) {
                    r.joinChatRooms1(t, e, f)
                }), this.recoverPeer(this.peerIds), this.sendSync.reSend()
            }
            this.status = _w.Login, this.dispatchIndex = 0, ww.log.debug("handleLoginResp login successful");
            var h = {
                code: o.code,
                info: o.msg,
                userInfo: {
                    nickname: this.liveInfo.nickname,
                    psId: this.userData.psId
                }
            };
            ww.log.debug("handleLoginResp loginResp:", h), this.resultEvent.emit(rg, h)
        } else {
            if (this.status = _w.Logout, this.conn.close(), o.code === dR.Code.CodeErrTokenExpire) return this.status = _w.ReLogin, void this.tryDispatch();
            ww.log.info("logout with code " + o.code), this.heartbeatManager.stop(), clearTimeout(this.remoteConfigTimeout), clearTimeout(this.dispatcherTimeout), clearTimeout(this.connectTimeout);
            var p = this.status;
            if (this.status = _w.Logout, p === _w.Login) {
                var d = LR(OR.LogoutType, null);
                this.sendMessage(d)
            }
            this.messageSync.destroyAll(), this.sendSync.destroyAll(), this.peerIds = [], this.roomIds = [], this.modeRoomIdMap = new Map, this.remoteLog.destroy(), this.status = _w.Init, h = {
                code: o.code,
                info: o.msg,
                userInfo: {
                    nickname: this.liveInfo.nickname,
                    psId: this.userData.psId
                }
            }, ww.log.debug("handleLoginResp loginResp:", h), this.resultEvent.emit(rg, h)
        }
    }, ww.prototype.logout = function () {
        if (this.status == _w.Init || this.status == _w.UnInit || this.status == _w.Logout) return ww.log.warn("logout unlogin"), zl.UnLogined;
        ww.log.debug("logout");
        var t = Date.now() - this.loginBegin;
        this.remoteLog.logNetChange(605, "正常退出", 0 < this.roomIds.length ? 2 : 1, t, this.roomIds), this.heartbeatManager && this.heartbeatManager.stop(), clearTimeout(this.remoteConfigTimeout), clearTimeout(this.dispatcherTimeout), clearTimeout(this.connectTimeout);
        var e = this.status;
        if (this.status = _w.Logout, e === _w.Login) {
            var r = LR(OR.LogoutType, null);
            this.sendMessage(r)
        }
        return this.conn.close(), ww.log.info("logout"), this.messageSync.destroyAll(), this.sendSync.destroyAll(), this.peerIds = [], this.roomIds = [], this.modeRoomIdMap = new Map, this.remoteLog.destroy(), this.status = _w.Init, zl.Success
    }, ww.prototype.handleKickout = function (t) {
        var e = this,
            r = dR.Kickout.create(new hR.InputStream(new hR.BinBuffer(cR.from(t.data))));
        if (ww.log.info("handleKickout code:", r.code, "msg:", r), this.status = _w.Logout, this.heartbeatManager.stop(), clearTimeout(this.remoteConfigTimeout), clearTimeout(this.dispatcherTimeout), clearTimeout(this.connectTimeout), this.conn.close(), r.code === dR.Code.CodeErrKickoutScedule) this.status = _w.ReLogin, this.tryDispatch();
        else if (r.code === dR.Code.CodeErrKickoutPingTimeout) {
            this.remoteLog.destroy(), this.roomUserCount = new Map, this.heartbeatManager.stop();
            var o = Date.now() - this.connectBegin;
            this.remoteLog.logConnect(1, "login error, recv CodeErrKickoutPingTimeout", o), this.status = _w.ReLogin;
            var n = {
                netStatus: Kl.DisConnected
            };
            this.resultEvent.emit(ng, n);
            var i = {
                netStatus: Kl.Connecting
            };
            this.resultEvent.emit(ng, i), setTimeout(function () {
                return e.tryConnect()
            }, 0)
        } else {
            this.messageSync.destroyAll(), this.sendSync.destroyAll(), this.peerIds = [], this.roomIds = [], this.modeRoomIdMap = new Map, this.remoteLog.destroy(), o = Date.now() - this.connectBegin, this.remoteLog.logConnect(1, "websocket断开 resultMsg:kickout", o), this.status = _w.Init;
            var s = {
                code: r.code,
                info: r.msg
            };
            this.resultEvent.emit(ig, s)
        }
    }, ww.prototype.handleLogoutNotice = function (t) {
        var e = dR.LogoutNotice.create(new hR.InputStream(new hR.BinBuffer(cR.from(t.data)))),
            r = {
                code: dR.Code.CodeSuccess,
                userInfo: {
                    nickname: e.user.nickname,
                    psId: e.user.psId
                }
            };
        ww.log.debug("handleLogoutNotice logoutNotice:", r), this.resultEvent.emit(og, r);
        for (var o = 0; o < e.roomIds.length; o++) {
            var n = e.roomIds.value[o],
                i = this.roomUserCount.get(n) ? this.roomUserCount.get(n) : 0;
            this.roomUserCount.set(n, i - 1)
        }
    }, ww.prototype.handlePing = function () {
        var t = LR(OR.PongType, null);
        this.sendMessage(t)
    }, ww.prototype.handlePong = function () { }, ww.prototype.handleUnkownCommand = function (t) {
        var e = dR.Unkown.create(new hR.InputStream(new hR.BinBuffer(cR.from(t.data)))),
            r = e.code,
            o = e.msg;
        ww.log.error("handleUnkownCommand code:" + r + " errMsg:" + o)
    }, ww.prototype.recoverPeer = function (t) {
        var e, r;
        console.log(t, "peerIds");
        var o = new Array,
            n = new Array;
        try {
            for (var i = Xl(t), s = i.next(); !s.done; s = i.next()) {
                var a = s.value;
                n.push({
                    psId: "bu zhi dao",
                    nickname: a
                }), o.push(this.messageSync.getMinSeq(a))
            }
        } catch (t) {
            e = {
                error: t
            }
        } finally {
            try {
                s && !s.done && (r = i.return) && r.call(i)
            } finally {
                if (e) throw e.error
            }
        }
        if (console.log("recoverPeer", n, o), 0 < t.length) {
            var u = function (t, e) {
                var r = dR.RecoverPeer.new();
                return r.readFromObject({
                    peers: t,
                    unitSeqIds: e
                }), r.toBinBuffer().toNodeBuffer()
            }(n, o),
                c = LR(OR.RecoverPeer, u);
            this.sendMessage(c)
        }
    }, ww.prototype.handleRecoverPeerResp = function (t) {
        console.log("handleRecoverPeerResp")
    }, ww.prototype.handleRecoverPeerNotice = function (t) {
        for (var e = dR.RecoverPeerMessageNotice.create(new hR.InputStream(new hR.BinBuffer(cR.from(t.data)))), r = 0; r < e.messages.length; r++) this.messageSync.recvMessage(e.peer.nickname, e.messages.value[r].unitSeqId, e.messages.value[r])
    }, ww.prototype.joinChatRooms1 = function (t, e, r) {
        var o, n;
        this.remoteLog.logJoinRoom(this.liveInfo.nickname, t, r);
        var i = new Array;
        try {
            for (var s = Xl(this.roomIds), a = s.next(); !a.done; a = s.next()) {
                var u = a.value,
                    c = this.messageSync.getMinSeq(u);
                console.log("unitSeqId:", c, " roomId:", u), i.push(c)
            }
        } catch (t) {
            o = {
                error: t
            }
        } finally {
            try {
                a && !a.done && (n = s.return) && n.call(s)
            } finally {
                if (o) throw o.error
            }
        }
        if (console.log("unitSeqIds", i), 0 < t.length) {
            var f = function (t, e, r, o) {
                var n = dR.JoinRoom.new();
                return n.readFromObject({
                    roomIds: t,
                    unitSeqIds: e,
                    userList: r,
                    msgSubscribe: o
                }), n.toBinBuffer().toNodeBuffer()
            }(t, i, e, r),
                h = LR(OR.JoinRoomType, f);
            this.sendMessage(h)
        }
    }, ww.prototype.handleRecoverRoomMessageNotice = function (t) {
        var e = dR.RecoverRoomMessageNotice.create(new hR.InputStream(new hR.BinBuffer(cR.from(t.data))));
        ww.log.debug("handleRecoverRoomMessageNotice ", e);
        for (var r = 0; r < e.messages.length; r++) console.log("RecoverRoomMessageNotice", e.messages.value[r]), this.messageSync.recvMessage(e.roomId, e.messages.value[r].unitSeqId, e.messages.value[r])
    }, ww.prototype.handleMuteRoomNotice = function (t) {
        var e = dR.MuteRoomNotice.create(new hR.InputStream(new hR.BinBuffer(cR.from(t.data))));
        console.log("muteRoomNotice", e);
        var r = {
            roomId: e.roomId,
            flag: e.flag,
            handler: {
                psId: e.handler.psId,
                nickname: e.handler.psId
            }
        };
        this.resultEvent.emit(kg, r)
    }, ww.prototype.joinChatRoomsWithJoinMode = function (r, t) {
        var o = this;
        return ww.log.debug("joinChatRooms join:", r), this.status === _w.UnInit ? (ww.log.error("当前sdk 未初始化，不允许该操作 status:", this.status), zl.UnInit) : this.status !== _w.Login ? (ww.log.error("当前sdk 未登录，不允许该操作 status:", this.status), zl.UnLogined) : (r = r.filter(function (t) {
            if (o.roomIds.includes(t)) {
                ww.log.debug("joinChatRooms " + r + " 已经在加入房间列表中，不再重复加入");
                var e = {
                    code: dR.Code.CodeErrRoomAreadyJoin,
                    info: "该聊天室已加入",
                    roomId: t,
                    userInfo: {
                        psId: o.userData.psId,
                        nickname: o.liveInfo.nickname
                    }
                };
                return o.resultEvent.emit(ag, e), !1
            }
            return !0
        }), this.joinChatRooms1(r, t, {}), zl.Success)
    }, ww.prototype.handleJoinRoomResp = function (t, e) {
        var r, o, n = dR.JoinRoomResp.create(new hR.InputStream(new hR.BinBuffer(cR.from(t.data)))),
            i = dR.JoinRoom.create(new hR.InputStream(new hR.BinBuffer(cR.from(e.data))));
        ww.log.debug("handleJoinRoomResp code:", n.code);
        for (var s = i.roomIds, a = [], u = 0; u < s.length; u++) a.push(s.value[u]);
        if (this.remoteLog.logJoinRoom(this.liveInfo.nickname, a, i.msgSubscribe), n.code !== dR.Code.CodeSuccess)
            for (u = 0; u < i.roomIds.length; u++) {
                var c = i.roomIds.value[u],
                    f = {
                        code: n.code,
                        info: n.msg,
                        roomId: c,
                        userInfo: {
                            psId: this.userData.psId,
                            nickname: this.liveInfo.nickname
                        }
                    };
                this.resultEvent.emit(ag, f)
            } else {
            var h = n.data,
                p = i.roomIds.value.filter(function (e) {
                    return !h.fail.value.find(function (t) {
                        return t.roomId === e
                    })
                });
            try {
                for (var d = Xl(p), m = d.next(); !m.done; m = d.next()) {
                    c = m.value, this.roomIds.includes(c) || this.roomIds.push(c);
                    var l = i.mode,
                        g = this.modeRoomIdMap.get(l);
                    g || (g = new Array, this.modeRoomIdMap.set(l, g)), g.includes(c) || g.push(c), f = {
                        code: dR.Code.CodeSuccess,
                        info: "join room success",
                        roomId: c,
                        userInfo: {
                            psId: this.userData.psId,
                            nickname: this.liveInfo.nickname
                        }
                    }, this.resultEvent.emit(ag, f)
                }
            } catch (t) {
                r = {
                    error: t
                }
            } finally {
                try {
                    m && !m.done && (o = d.return) && o.call(d)
                } finally {
                    if (r) throw r.error
                }
            }
            for (u = 0; u < h.fail.length; u++) {
                var y = h.fail.value[u];
                c = y.roomId, f = {
                    code: y.code,
                    info: y.msg,
                    roomId: c,
                    userInfo: {
                        psId: this.userData.psId,
                        nickname: this.liveInfo.nickname
                    }
                }, this.resultEvent.emit(ag, f)
            }
        }
    }, ww.prototype.handleJoinRoomNotice = function (t) {
        var e = dR.JoinRoomNotice.create(new hR.InputStream(new hR.BinBuffer(cR.from(t.data))));
        ww.log.debug("handleJoinRoomNotice join room ", e.roomId), this.addUserToRoomMap(e.roomId, e.user.nickname);
        var r = {
            info: "JoinRoomNotice",
            roomId: e.roomId,
            userInfo: {
                psId: e.user.psId,
                nickname: e.user.nickname
            }
        };
        this.resultEvent.emit(ug, r)
    }, ww.prototype.handleJoinRoomMetaDataNotice = function (t) {
        var e = dR.JoinRoomInfoNotice.create(new hR.InputStream(new hR.BinBuffer(cR.from(t.data))));
        ww.log.debug("handleJoinRoomMetaDataNotice roomId:" + e.roomId + " ", "topic:" + e.info.topic + " ", "userNum:" + e.info.userNum);
        var r = {
            roomId: e.roomId,
            content: {
                topic: e.info.topic,
                number: e.info.userNum
            }
        };
        this.resultEvent.emit(cg, r);
        var o = {
            topic: e.info.topic,
            roomId: e.roomId
        };
        this.resultEvent.emit(dg, o)
    }, ww.prototype.handleJoinRoomUserListNotice = function (t) {
        var e = dR.JoinRoomUserListNotice.create(new hR.InputStream(new hR.BinBuffer(cR.from(t.data))));
        ww.log.debug("handleJoinRoomUserListNotice rooId:", e.roomId);
        for (var r = new Array, o = 0; o < e.users.length; o++) {
            var n = e.users.value[o],
                i = n.psId,
                s = n.nickname;
            this.addUserToRoomMap(e.roomId, s), r.push({
                psId: i,
                nickname: s
            })
        }
        var a = {
            code: e.finish ? FR : GR,
            userList: r,
            roomId: e.roomId
        };
        this.resultEvent.emit(hg, a)
    }, ww.prototype.handleRoomUserCountNotice = function (t) {
        var e = dR.RoomUserCountNotice.create(new hR.InputStream(new hR.BinBuffer(cR.from(t.data)))),
            r = new Map;
        e.userCount.forEach(function (t, e) {
            r.set(t, e)
        });
        var o = {
            userCount: r
        };
        this.resultEvent.emit(pg, o)
    }, ww.prototype.handleRecvRoomData = function (t) {
        var e = dR.RoomDataNotice.create(new hR.InputStream(new hR.BinBuffer(cR.from(t.data))));
        this.remoteLog.logRecvRoomData(e.handler.nickname, this.liveInfo.nickname, e.msgIdStr, e.sendTime ? this.ntpTime.getTime() - e.sendTime : 0);
        var r = new Map;
        e.datas.forEach(function (t, e) {
            r.set(t, {
                value: e.value,
                save: e.save
            })
        });
        var o = {
            msgId: e.msgIdStr,
            handler: {
                psId: e.handler.psId,
                nickname: e.handler.nickname
            },
            roomId: e.roomId,
            datas: r
        };
        if (this.resultEvent.emit(fg, o), e.needAck) {
            var n = function (t) {
                var e = dR.RoomDataNoticeResp.new();
                return e.readFromObject({
                    msgId: t
                }), e.toBinBuffer().toNodeBuffer()
            }(e.msgIdStr),
                i = ER(OR.RoomDataNoticeResp, t.seqId, n);
            this.sendMessage(i)
        }
    }, ww.prototype.leaveChatRooms = function (t) {
        var e = this;
        if (this.status === _w.UnInit) return ww.log.error("当前sdk 为登录，不允许该操作 status:", this.status), zl.UnInit;
        if (this.status !== _w.Login) return ww.log.error("当前sdk 为登录，不允许该操作 status:", this.status), zl.UnLogined;
        var r = function (t) {
            var e = dR.LeaveRoom.new();
            return e.readFromObject({
                roomIds: t
            }), e.toBinBuffer().toNodeBuffer()
        }(t),
            o = LR(OR.LeaveRoomType, r);
        return this.sendMessage(o), t.forEach(function (t) {
            e.subOptions.delete(t)
        }), zl.Success
    }, ww.prototype.handleLeaveRoomResp = function (t, e) {
        for (var o = dR.LeaveRoomResp.create(new hR.InputStream(new hR.BinBuffer(cR.from(t.data)))), n = dR.LeaveRoom.create(new hR.InputStream(new hR.BinBuffer(cR.from(e.data)))), r = function (t) {
            var e = n.roomIds.value[t];
            i.roomUserCount.delete(e), i.remoteLog.logLeaveResp(i.liveInfo.nickname, e), i.roomIds = i.roomIds.filter(function (t) {
                return t != e
            });
            var r = {
                code: o.code,
                info: o.msg,
                roomId: e,
                userInfo: {
                    psId: i.userData.psId,
                    nickname: i.liveInfo.nickname
                }
            };
            i.resultEvent.emit(mg, r)
        }, i = this, s = 0; s < n.roomIds.length; s++) r(s)
    }, ww.prototype.handleLeaveRoomNotice = function (t) {
        var e = dR.LeaveRoomNotice.create(new hR.InputStream(new hR.BinBuffer(cR.from(t.data))));
        ww.log.debug("handleLeaveRoomNotice rooId", e.roomId), this.remoteUserFromRoom(e.roomId, e.user.nickname);
        var r = {
            info: "leave room notice",
            userInfo: {
                psId: e.user.psId,
                nickname: e.user.nickname
            },
            roomId: e.roomId
        };
        this.resultEvent.emit(lg, r)
    }, ww.prototype.muteRoom = function (t, e) {
        if (this.status === _w.UnInit) return ww.log.error("当前sdk 未初始化，不允许该操作 status:", this.status), {
            code: zl.UnInit
        };
        if (this.status !== _w.Login) return ww.log.error("当前sdk 未登录，不允许该操作 status:", this.status), {
            code: zl.UnLogined
        };
        if (0 !== e && 1 !== e) return {
            code: zl.ParaError
        };
        var r = function (t, e) {
            var r = dR.MuteRoom.new();
            return r.readFromObject({
                roomIds: t,
                flag: e
            }), r.toBinBuffer().toNodeBuffer()
        }(t, e),
            o = LR(OR.MuteRoomReqType, r);
        return this.sendMessage(o), {
            code: zl.Success
        }
    }, ww.prototype.getRoomMuteStatus = function (t) {
        if (this.status === _w.UnInit) return ww.log.error("当前sdk 未初始化，不允许该操作 status:", this.status), {
            code: zl.UnInit
        };
        if (this.status !== _w.Login) return ww.log.error("当前sdk 未登录，不允许该操作 status:", this.status), {
            code: zl.UnLogined
        };
        var e = function (t) {
            var e = dR.RoomMuteStatus.new();
            return e.readFromObject({
                roomIds: t
            }), e.toBinBuffer().toNodeBuffer()
        }(t),
            r = LR(OR.RoomMuteStatusReqType, e);
        return this.sendMessage(r), {
            code: zl.Success
        }
    }, ww.prototype.setRoomData = function (t, e) {
        if (this.status === _w.UnInit) return ww.log.error("当前sdk 未初始化，不允许该操作 status:", this.status), {
            code: zl.UnInit
        };
        if (this.status !== _w.Login) return ww.log.error("当前sdk 未登录，不允许该操作 status:", this.status), {
            code: zl.UnLogined
        };
        var r = function (t, e, r) {
            var o = dR.SetRoomData.new();
            return o.readFromObject({
                roomId: t,
                datas: e,
                sendTime: r
            }), o.toBinBuffer().toNodeBuffer()
        }(t, e, this.ntpTime.getTime()),
            o = LR(OR.SetRoomData, r);
        return this.sendMessage(o), {
            code: zl.Success,
            preMsgId: o.seqId
        }
    }, ww.prototype.setRoomsData = function (t, e) {
        if (this.status === _w.UnInit) return ww.log.error("当前sdk 未初始化，不允许该操作 status:", this.status), {
            code: zl.UnInit
        };
        if (this.status !== _w.Login) return ww.log.error("当前sdk 未登录，不允许该操作 status:", this.status), {
            code: zl.UnLogined
        };
        var r = function (t, e, r) {
            var o = dR.SetBatchRoomData.new();
            return o.readFromObject({
                roomId: t,
                datas: e,
                sendTime: r
            }), o.toBinBuffer().toNodeBuffer()
        }(t, e, this.ntpTime.getTime()),
            o = LR(OR.SetBatchRoomData, r);
        return this.sendMessage(o), {
            code: zl.Success,
            preMsgId: o.seqId
        }
    }, ww.prototype.getRoomData = function (t, e) {
        if (this.status === _w.UnInit) return ww.log.error("当前sdk 未初始化，不允许该操作 status:", this.status), {
            code: zl.UnInit
        };
        if (this.status !== _w.Login) return ww.log.error("当前sdk 未登录，不允许该操作 status:", this.status), {
            code: zl.UnLogined
        };
        var r = function (t, e) {
            var r = dR.GetRoomData.new();
            return r.readFromObject({
                roomId: t,
                keys: e
            }), r.toBinBuffer().toNodeBuffer()
        }(t, e),
            o = LR(OR.GetRoomData, r);
        return this.sendMessage(o), {
            code: zl.Success,
            preMsgId: o.seqId
        }
    }, ww.prototype.getAllRoomData = function (t) {
        if (this.status === _w.UnInit) return ww.log.error("当前sdk 未初始化，不允许该操作 status:", this.status), {
            code: zl.UnInit
        };
        if (this.status !== _w.Login) return ww.log.error("当前sdk 未登录，不允许该操作 status:", this.status), {
            code: zl.UnLogined
        };
        var e = function (t) {
            var e = dR.GetRoomData.new();
            return e.readFromObject({
                roomId: t
            }), e.toBinBuffer().toNodeBuffer()
        }(t),
            r = LR(OR.GetRoomData, e);
        return this.sendMessage(r), {
            code: zl.Success,
            preMsgId: r.seqId
        }
    }, ww.prototype.setRoomSubscribeOption = function (t, r) {
        var o = this;
        if (this.status === _w.UnInit) return ww.log.error("当前sdk 未初始化，不允许该操作 status:", this.status), {
            code: zl.UnInit
        };
        if (this.status !== _w.Login) return ww.log.error("当前sdk 未登录，不允许该操作 status:", this.status), {
            code: zl.UnLogined
        };
        var e = function (t, e) {
            var r = dR.RoomMsgSubscribe.new(),
                o = {};
            return t.forEach(function (t) {
                o[t] = e
            }), r.readFromObject({
                subscribe: o
            }), r.toBinBuffer().toNodeBuffer()
        }(t, r),
            n = LR(OR.RoomMsgSubscribe, e);
        return this.sendMessage(n), t.forEach(function (e) {
            o.subOptions.has(e) || o.subOptions.set(e, new Map), r.forEach(function (t) {
                o.subOptions.get(e).set(t.msgType, t.flag)
            })
        }), {
            code: zl.Success
        }
    }, ww.prototype.handleMuteRoomResp = function (t, e) {
        var r, o, n = dR.MuteRoomResp.create(new hR.InputStream(new hR.BinBuffer(cR.from(t.data)))),
            i = dR.MuteRoom.create(new hR.InputStream(new hR.BinBuffer(cR.from(e.data))));
        if (ww.log.debug("handleMuteRoomResp code:", n.code), n.code !== dR.Code.CodeSuccess)
            for (var s = 0; s < i.roomIds.length; s++) {
                var a = i.roomIds.value[s],
                    u = {
                        code: n.code,
                        info: n.msg,
                        roomId: a
                    };
                this.resultEvent.emit(_g, u)
            } else {
            var c = i.roomIds.value.filter(function (e) {
                return !n.data.fail.value.find(function (t) {
                    return t.roomId === e
                })
            });
            try {
                for (var f = Xl(c), h = f.next(); !h.done; h = f.next()) a = h.value, u = {
                    code: dR.Code.CodeSuccess,
                    info: "mute room success",
                    roomId: a
                }, this.resultEvent.emit(_g, u)
            } catch (t) {
                r = {
                    error: t
                }
            } finally {
                try {
                    h && !h.done && (o = f.return) && o.call(f)
                } finally {
                    if (r) throw r.error
                }
            }
            for (s = 0; s < n.data.fail.length; s++) {
                var p = n.data.fail.value[s];
                a = p.roomId, u = {
                    code: p.code,
                    info: p.msg,
                    roomId: a
                }, this.resultEvent.emit(_g, u)
            }
        }
    }, ww.prototype.handleMuteRoomStatusResp = function (t, e) {
        var r = dR.RoomMuteStatusResp.create(new hR.InputStream(new hR.BinBuffer(cR.from(t.data)))),
            o = dR.RoomMuteStatus.create(new hR.InputStream(new hR.BinBuffer(cR.from(e.data))));
        if (ww.log.debug("handleMuteRoomStatusResp code:", r.code), r.code !== dR.Code.CodeSuccess)
            for (var n = 0; n < o.roomIds.length; n++) {
                var i = o.roomIds.value[n],
                    s = {
                        code: r.code,
                        info: r.msg,
                        roomId: i,
                        flag: r.flag
                    };
                this.resultEvent.emit(Rg, s)
            } else {
            for (n = 0; n < r.data.success.length; n++) {
                var a = r.data.success.value[n],
                    u = (i = a.roomId, a.flag);
                s = {
                    code: dR.Code.CodeSuccess,
                    info: "mute room success",
                    roomId: i,
                    flag: u
                }, this.resultEvent.emit(Rg, s)
            }
            for (n = 0; n < r.data.fail.length; n++) {
                var c = r.data.fail.value[n];
                i = c.roomId, s = {
                    code: c.code,
                    info: c.msg,
                    roomId: i,
                    flag: u = c.flag
                }, this.resultEvent.emit(Rg, s)
            }
        }
    }, ww.prototype.handleSetRoomDataResp = function (t, e) {
        var r = dR.SetRoomDataResp.create(new hR.InputStream(new hR.BinBuffer(cR.from(t.data)))),
            o = dR.SetRoomData.create(new hR.InputStream(new hR.BinBuffer(cR.from(e.data)))),
            n = o.roomId;
        if (r.code !== dR.Code.CodeSuccess) {
            var i = [];
            if (o && o.datas && o.datas.value)
                for (var s in o.datas.value) i.push(s);
            var a = {
                code: r.code,
                info: r.msg,
                roomId: n,
                preMsgId: t.seqId,
                msgId: r.data.msgIdStr,
                failKeys: i
            };
            this.resultEvent.emit(vg, a)
        } else a = {
            code: r.code,
            info: r.msg,
            roomId: n,
            preMsgId: t.seqId,
            msgId: r.data.msgIdStr,
            failKeys: r.data.fail.value
        }, this.resultEvent.emit(vg, a)
    }, ww.prototype.handleSetRoomsDataResp = function (t, e) {
        var r = dR.SetBatchRoomDataResp.create(new hR.InputStream(new hR.BinBuffer(cR.from(t.data)))),
            o = dR.SetBatchRoomData.create(new hR.InputStream(new hR.BinBuffer(cR.from(e.data)))),
            n = r.data.msgIdStr;
        if (r.code !== dR.Code.CodeSuccess) var i = [];
        else {
            if (i = [], o.roomId.value)
                for (var s = 0; s < o.roomId.value.length; s++) {
                    var a = o.roomId.value[s],
                        u = r.data.fail.value[a];
                    if (u) {
                        var c = {
                            code: u.code,
                            info: u.msg,
                            roomId: a,
                            preMsgId: t.seqId,
                            msgId: n,
                            failKeys: []
                        };
                        i.push(c)
                    } else c = {
                        code: dR.Code.CodeSuccess,
                        info: "success",
                        roomId: a,
                        preMsgId: t.seqId,
                        msgId: n,
                        failKeys: []
                    }, i.push(c)
                }
            var f = {
                result: i,
                preMsgId: t.seqId,
                msgId: n
            };
            this.resultEvent.emit(wg, f)
        }
    }, ww.prototype.handleGetRoomData = function (t, e) {
        var r = dR.GetRoomDataResp.create(new hR.InputStream(new hR.BinBuffer(cR.from(t.data)))),
            o = dR.GetRoomData.create(new hR.InputStream(new hR.BinBuffer(cR.from(e.data)))),
            n = r.code,
            i = o.roomId;
        if (n !== dR.Code.CodeSuccess) {
            var s = {
                code: n,
                info: r.msg,
                roomId: i,
                preMsgId: t.seqId,
                datas: {}
            };
            this.resultEvent.emit(Sg, s)
        } else s = {
            code: n,
            info: "success",
            roomId: i,
            preMsgId: t.seqId,
            datas: r.data.datas.value
        }, this.resultEvent.emit(Sg, s)
    }, ww.prototype.handleSetRoomMsgSubscribeOptionResp = function (t, e) {
        var r = dR.RoomMsgSubscribeResp.create(new hR.InputStream(new hR.BinBuffer(cR.from(t.data)))),
            o = dR.RoomMsgSubscribe.create(new hR.InputStream(new hR.BinBuffer(cR.from(e.data))));
        if (r.code !== dR.Code.CodeSuccess)
            for (var n in o.subscribe.value) {
                var i = {
                    code: r.code,
                    info: r.msg,
                    roomId: n
                };
                this.resultEvent.emit(Mg, i)
            } else
            for (var n in o.subscribe.value) i = r.data.fail.value[n] ? {
                code: r.code,
                info: r.msg,
                roomId: n
            } : {
                code: dR.Code.CodeSuccess,
                info: "success",
                roomId: n
            }, this.resultEvent.emit(Mg, i)
    }, ww.prototype.sendRoomMessage = function (t, e, r) {
        var o = this.sendRoomMessageWithPreMsgId(t, e, r),
            n = o.code,
            i = o.preMsgId;
        return ww.log.debug("sendRoomMessage preMsgId:", i, " code:", n), n
    }, ww.prototype.sendRoomMessageWithPreMsgId = function (t, e, r) {
        var o, n, i = this;
        if (this.status === _w.UnInit) return ww.log.error("当前sdk 未初始化，不允许该操作 status:", this.status), {
            code: zl.UnInit
        };
        if (this.status !== _w.Login) return ww.log.error("当前sdk 未登录，不允许该操作 status:", this.status), {
            code: zl.UnLogined
        };
        if (1 === this.remoteConfig.msg_send_limit_enable && !this.messageLimit.add(mR[r])) return {
            code: zl.ReceiverTooMany
        };
        var s = new Array;
        t = t.filter(function (t) {
            return !!i.roomIds.includes(t) || (s.push(t), console.error(t + "不在已加入的房间列表中"), !1)
        });
        var a = !1;
        1 === this.remoteConfig.msg_send_retry_enable && (a = !0), r === Wl.MessagePriorityPrivMsg && (a = !1);
        var u = this.sendSync.send(gR, function (t, e, r, o, n) {
            var i = dR.SendRoomMessage.new();
            return i.readFromObject({
                roomIds: t,
                content: e,
                priority: r,
                seqId: n,
                sendTime: o
            }), i.toBinBuffer().toNodeBuffer()
        }.bind(null, t, e, r, this.ntpTime.getTime()), a);
        try {
            for (var c = Xl(s), f = c.next(); !f.done; f = c.next()) {
                var h = f.value,
                    p = {
                        code: dR.Code.CodeErrNotInRoom,
                        info: "不在聊天室内",
                        fromUserInfo: {
                            psId: this.userData.psId,
                            nickname: this.liveInfo.nickname
                        },
                        toRoomId: h,
                        preMsgId: u.seqId,
                        msgId: 0,
                        timestamp: 0
                    };
                this.resultEvent.emit(yg, p)
            }
        } catch (t) {
            o = {
                error: t
            }
        } finally {
            try {
                f && !f.done && (n = c.return) && n.call(c)
            } finally {
                if (o) throw o.error
            }
        }
        return {
            code: zl.Success,
            preMsgId: u.seqId
        }
    }, ww.prototype.handleSendRoomMessageResp = function (t) {
        this.sendSync.callback(gR, t.seqId, t)
    }, ww.prototype.handleRecvRoomMessage = function (t) {
        console.log("handleRecvRoomMessage seqId:", t.seqId);
        var e = dR.RecvRoomMessage.create(new hR.InputStream(new hR.BinBuffer(cR.from(t.data))));
        if (ww.log.debug("handleRecvRoomMessage ", e, "roomId:", e.roomId, " content:", e.content), e.needAck) {
            var r = function (t, e, r) {
                var o = dR.RecvRoomMessageResp.new();
                return o.readFromObject({
                    msgIdStr: t,
                    unitSeqId: e,
                    unitPrevSeqId: r
                }), o.toBinBuffer().toNodeBuffer()
            }(e.msgIdStr, e.unitSeqId, e.unitPrevSeqId),
                o = ER(OR.RecvRoomMessageRespType, t.seqId, r);
            this.sendMessage(o)
        }
        e.priority === Wl.MessagePriorityNotice && 1 === this.remoteConfig.msg_pull_enable ? this.messageSync.recvMessage(e.roomId, e.unitSeqId, e) : this.doHandleRecvRoomMessage(e)
    }, ww.prototype.doHandleRecvRoomMessage = function (t) {
        if (t.priority !== Wl.MessagePriorityTopic && t.priority !== Wl.MessagePriorityNotice || this.remoteLog.logRecvRoomMsg(t.content, t.priority, t.from.nickname, t.roomId, t.sendTime ? this.ntpTime.getTime() - t.sendTime : 0, t.msgIdStr), t.from.nickname !== this.liveInfo.nickname || t.priority === Wl.MessagePriorityTopic) {
            var e = {
                messagePriority: t.priority,
                timestamp: t.timestamp,
                msgId: t.msgIdStr,
                fromUserInfo: {
                    nickname: t.from.nickname,
                    psId: t.from.psId
                },
                toRoomId: t.roomId,
                content: t.content
            };
            this.resultEvent.emit(gg, e)
        }
    }, ww.prototype.getRoomHistoryMessage = function (t, e) {
        if (this.status === _w.UnInit) return ww.log.error("当前sdk 未登录，不允许该操作 status:", this.status), zl.UnInit;
        if (this.status !== _w.Login) return ww.log.error("当前sdk 未登录，不允许该操作 status:", this.status), zl.UnLogined;
        if (e < 0) return ww.log.error("tsOffset 不能小于零"), zl.ParaError;
        var r = function (t, e) {
            var r = dR.GetRoomHistoryMessage.new();
            return r.readFromObject({
                roomId: t,
                tsOffset: e
            }), r.toBinBuffer().toNodeBuffer()
        }(t, e),
            o = LR(OR.GetRoomHistoryMessageReqType, r);
        return this.sendMessage(o), zl.Success
    }, ww.prototype.handleGetRoomHistoryMessageResp = function (t) {
        for (var e = dR.GetRoomHistoryMessageResp.create(new hR.InputStream(new hR.BinBuffer(cR.from(t.data)))), r = new Array, o = 0; o < e.data.content.value.length; o++) r.push(JSON.parse(e.data.content.value[o]));
        var n = {
            code: e.code,
            info: e.msg,
            content: r
        };
        this.resultEvent.emit(bg, n)
    }, ww.prototype.sendRoomBinMessage = function (t, e, r, o) {
        if (this.status === _w.UnInit) return ww.log.error("当前sdk 未登录，不允许该操作 status:", this.status), zl.UnInit;
        if (this.status !== _w.Login) return ww.log.error("当前sdk 未登录，不允许该操作 status:", this.status), zl.UnLogined;
        var n = !1;
        return 1 === this.remoteConfig.msg_send_retry_enable && (n = !0), this.sendSync.send(yR, function (t, e, r, o, n, i) {
            var s = dR.SendRoomBinMessage.new();
            return s.readFromObject({
                roomIds: t,
                dbKey: e,
                keyMsgId: r,
                content: o,
                seqId: i,
                sendTime: n
            }), s.toBinBuffer().toNodeBuffer()
        }.bind(null, t, e, r, iR.fromByteArray(o), this.ntpTime.getTime()), n), zl.Success
    }, ww.prototype.handleSendRoomBinMessageResp = function (t) {
        this.sendSync.callback(yR, t.seqId, t)
    }, ww.prototype.handleRecvRoomBinMessageNotice = function (t) {
        console.log("handleRecvRoomBinMessage seqId:", t.seqId);
        var e = dR.RecvRoomBinMessage.create(new hR.InputStream(new hR.BinBuffer(cR.from(t.data))));
        if (ww.log.debug("handleRecvRoomBinMessage ", e, "roomId:", e.roomId, " content:", e.content), e.needAck) {
            console.log("seqId:" + t.seqId);
            var r = function (t, e, r) {
                var o = dR.RecvRoomBinMessageResp.new();
                return o.readFromObject({
                    msgId: t,
                    unitSeqId: e,
                    unitPrevSeqId: r
                }), o.toBinBuffer().toNodeBuffer()
            }(e.msgId, e.unitSeqId, e.unitPrevSeqId),
                o = ER(OR.RecvRoomBinMessageResp, t.seqId, r);
            this.sendMessage(o)
        }
        1 === this.remoteConfig.msg_pull_enable ? this.messageSync.recvMessage("#" + e.roomId, e.unitSeqId, e) : this.doHandleRecvRoomBinMessageNotice(e)
    }, ww.prototype.doHandleRecvRoomBinMessageNotice = function (t) {
        if (t.from.nickname !== this.liveInfo.nickname) {
            this.remoteLog.logRecvRoomBinMsg(t.msgId, t.keyMsgId, t.dbKey, t.from, t.roomId, t.sendTime ? this.ntpTime.getTime() - t.sendTime : 0, this.remoteConfig.bin_msg_sample_rate);
            var e = {
                msgId: t.msgId,
                timestamp: t.timestamp,
                roomId: t.roomId,
                from: t.from,
                dbKey: t.dbKey,
                keyMsgId: t.keyMsgId,
                content: iR.toByteArray(t.content)
            };
            this.resultEvent.emit(Bg, e)
        }
    }, ww.prototype.getRoomHistoryBinMessage = function (t, e, r, o, n) {
        if (this.status === _w.UnInit) return ww.log.error("当前sdk 未登录，不允许该操作 status:", this.status), zl.UnInit;
        if (this.status !== _w.Login) return ww.log.error("当前sdk 未登录，不允许该操作 status:", this.status), zl.UnLogined;
        var i = function (t, e, r, o, n) {
            var i = dR.GetRoomHistoryBinMessage.new();
            return i.readFromObject({
                roomId: t,
                dbKey: e,
                lastKeyMsgId: r,
                order: o,
                count: n
            }), i.toBinBuffer().toNodeBuffer()
        }(t, e, r, o, n),
            s = LR(OR.GetRoomHistoryBinMessage, i);
        return this.sendMessage(s), zl.Success
    }, ww.prototype.handleGetRoomHistoryBinMessageResp = function (t, e) {
        var r = this,
            o = dR.GetRoomHistoryBinMessageResp.create(new hR.InputStream(new hR.BinBuffer(cR.from(t.data)))),
            n = dR.GetRoomHistoryBinMessage.create(new hR.InputStream(new hR.BinBuffer(cR.from(e.data)))),
            i = {
                code: o.code,
                msg: o.msg,
                roomId: n.roomId
            };
        this.resultEvent.emit(Tg, i);
        var s = o.data.traceId;
        this.binaryMessageHistory.registry(s, function (t) {
            var e = new Array;
            t.forEach(function (t) {
                t.value.forEach(function (t) {
                    e.push({
                        msgId: t.msgId,
                        timestamp: t.timestamp,
                        roomId: t.roomId,
                        from: t.from,
                        dbKey: t.dbKey,
                        keyMsgId: t.keyMsgId,
                        content: iR.toByteArray(t.content)
                    })
                })
            }), r.resultEvent.emit(Og, e)
        })
    }, ww.prototype.handleGetRoomHistoryBinMessageNotice = function (t) {
        var e = dR.GetRoomHistoryBinMessageNotice.create(new hR.InputStream(new hR.BinBuffer(cR.from(t.data))));
        this.binaryMessageHistory.recvMsgs(e.traceId, e.finish, e.msgs)
    }, ww.prototype.GetRoomBatchHistoryBinMessage = function (t) {
        if (this.status === _w.UnInit) return ww.log.error("当前sdk 未初始化，不允许该操作 status:", this.status), zl.UnInit;
        if (this.status !== _w.Login) return ww.log.error("当前sdk 未登录，不允许该操作 status:", this.status), zl.UnLogined;
        console.log("GetRoomBatchHistoryBinMessage:", t);
        var e = function (t) {
            var e = dR.GetRoomBatchHistoryBinMessage.new();
            return e.readFromObject({
                getInfo: t
            }), e.toBinBuffer().toNodeBuffer()
        }(t),
            r = LR(OR.GetRoomBatchHistoryBinMessage, e);
        return this.sendMessage(r), zl.Success
    }, ww.prototype.handleGetRoomBatchHistoryBinMessageResp = function (t, e) {
        var r = this,
            o = dR.GetRoomBatchHistoryBinMessageResp.create(new hR.InputStream(new hR.BinBuffer(cR.from(t.data)))),
            s = dR.GetRoomBatchHistoryBinMessage.create(new hR.InputStream(new hR.BinBuffer(cR.from(e.data))));
        if (this.resultEvent.emit(Dg, {
            code: o.code,
            msg: o.msg
        }), console.log("tarsGetRoomBatchHistoryBinMessageResp", o), 0 === o.code) {
            var n = o.data.traceId;
            this.binaryMessageHistory.registry(n, function (t) {
                var n = new Map;
                t.forEach(function (t) {
                    t.value.forEach(function (t) {
                        var e = t.dbKey,
                            r = n.get(e);
                        r || (r = new Array, n.set(e, r)), r.push({
                            msgId: t.msgId,
                            timestamp: t.timestamp,
                            roomId: t.roomId,
                            from: t.from,
                            dbKey: t.dbKey,
                            keyMsgId: t.keyMsgId,
                            content: iR.toByteArray(t.content)
                        })
                    })
                });
                var i = new Array;
                s.getInfo.forEach(function (t) {
                    var e = t.dbKey,
                        r = t.order,
                        o = n.get(e);
                    i.push({
                        code: 0,
                        content: o,
                        dbKey: e,
                        info: "success",
                        order: r
                    })
                }), r.resultEvent.emit(Pg, {
                    code: 0,
                    content: i
                })
            })
        }
    }, ww.prototype.handleGetRoomBatchHistoryBinMessageNotice = function (t) {
        var e = dR.GetRoomBatchHistoryBinMessageNotice.create(new hR.InputStream(new hR.BinBuffer(cR.from(t.data))));
        console.log("tarsGetRoomBatchHistoryBinMessageNotice", e), this.binaryMessageHistory.recvMsgs(e.traceId, e.finish, e.msgs)
    }, ww.prototype.getRoomUserList = function (t, e) {
        if (this.status === _w.UnInit) return ww.log.error("当前sdk 未登录，不允许该操作 status:", this.status), zl.UnInit;
        if (this.status !== _w.Login) return ww.log.error("当前sdk 未登录，不允许该操作 status:", this.status), zl.UnLogined;
        var r = function (t, e) {
            var r, o = dR.GetRoomUserList.new();
            switch (e) {
                case 1:
                    r = dR.RoomUserListMode.RoomUserListModeAll;
                    break;
                case 2:
                    r = dR.RoomUserListMode.RoomUserListModeTeacher;
                    break;
                default:
                    r = dR.RoomUserListMode.RoomUserListModeNone
            }
            return o.readFromObject({
                roomIds: t,
                userList: r
            }), o.toBinBuffer().toNodeBuffer()
        }(t, e),
            o = LR(OR.GetRoomUserList, r);
        return this.sendMessage(o), zl.Success
    }, ww.prototype.getStatistics = function (t, e) {
        if (this.status === _w.UnInit) return ww.log.error("当前sdk 未登录，不允许该操作 status:", this.status), zl.UnInit;
        if (this.status !== _w.Login) return ww.log.error("当前sdk 未登录，不允许该操作 status:", this.status), zl.UnLogined;
        var r = function (t, e) {
            var r = dR.GetStatistics.new();
            return r.readFromObject({
                type: t,
                params: e
            }), r.toBinBuffer().toNodeBuffer()
        }(t, e),
            o = LR(OR.GetStatistics, r);
        return this.sendMessage(o), zl.Success
    }, ww.prototype.handleGetStatisticsResp = function (t, e) {
        var n = this,
            r = dR.GetStatisticsResp.create(new hR.InputStream(new hR.BinBuffer(cR.from(t.data)))),
            o = dR.GetStatistics.create(new hR.InputStream(new hR.BinBuffer(cR.from(e.data)))),
            i = r.data;
        if (0 === r.code)
            if (i.async) {
                var s = i.traceId;
                this.binaryMessageHistory.registry(s, function (t, e) {
                    var r = {};
                    t.forEach(function (t) {
                        t.forEach(function (t, e) {
                            console.log(t, e), r[t] = e
                        })
                    });
                    var o = {
                        code: 0,
                        msg: "",
                        key: e.key,
                        params: e.params,
                        info: r
                    };
                    n.resultEvent.emit(Cg, o)
                }, {
                    key: o.type,
                    params: o.params
                })
            } else {
                var a = {};
                i.info.forEach(function (t, e) {
                    a[t] = e
                }), u = {
                    code: r.code,
                    msg: r.msg,
                    key: o.type,
                    params: o.params,
                    info: a
                }, this.resultEvent.emit(Cg, u)
            }
        else {
            var u = {
                code: r.code,
                msg: r.msg
            };
            this.resultEvent.emit(Cg, u)
        }
    }, ww.prototype.handleGetStatisticsNotice = function (t) {
        var e = dR.GetStatisticsNotice.create(new hR.InputStream(new hR.BinBuffer(cR.from(t.data))));
        if (console.log(e, "handleGetStatisticsNotice"), 0 === e.code) {
            var r = e.data;
            this.binaryMessageHistory.recvMsgs(r.traceId, r.finish, r.info)
        }
    }, ww.prototype.sendPeerMessage = function (t, e, r) {
        console.log("userIds:", t);
        var o = this.sendPeerMessageWithPreMsgId(t, e, r),
            n = o.code,
            i = o.preMsgId;
        return ww.log.debug("sendPeerMessage preMsgId:", i, " code:", n), n
    }, ww.prototype.sendPeerMessageWithPreMsgId = function (t, e, r) {
        if (this.status === _w.UnInit) return ww.log.error("当前sdk 未登录，不允许该操作 status:", this.status), {
            code: zl.UnInit
        };
        if (this.status !== _w.Login) return ww.log.error("当前sdk 未登录，不允许该操作 status:", this.status), {
            code: zl.UnLogined
        };
        if (1 === this.remoteConfig.msg_send_limit_enable && !this.messageLimit.add(mR[r])) return ww.log.error("消息超过发送限制"), {
            code: zl.MessageLimit
        };
        var o = !0;
        1 !== this.remoteConfig.msg_send_retry_enable && (o = !1), r === Wl.MessagePriorityPrivMsg && (o = !1);
        var n = this.sendSync.send(lR, function (t, e, r, o, n) {
            var i = dR.SendPeerMessage.new();
            return i.readFromObject({
                to: t,
                content: e,
                priority: r,
                seqId: n,
                sendTime: o
            }), i.toBinBuffer().toNodeBuffer()
        }.bind(null, t, e, r, this.ntpTime.getTime()), o);
        return {
            code: zl.Success,
            preMsgId: n.seqId
        }
    }, ww.prototype.handleSendPeerMessageResp = function (t) {
        this.sendSync.callback(lR, t.seqId, t)
    }, ww.prototype.handleRecvPeerMessage = function (t) {
        var e = dR.RecvPeerMessage.create(new hR.InputStream(new hR.BinBuffer(cR.from(t.data))));
        if (ww.log.debug("handleRecvPeerMessage ", e, " nickname:", e.from.nickname, " content:", e.content), e.needAck) {
            var r = function (t, e, r) {
                var o = dR.RecvPeerMessageResp.new();
                return o.readFromObject({
                    msgIdStr: t,
                    unitSeqId: e,
                    unitPrevSeqId: r
                }), o.toBinBuffer().toNodeBuffer()
            }(e.msgIdStr, e.unitSeqId, e.unitPrevSeqId),
                o = ER(OR.RecvPeerMessageRespType, t.seqId, r);
            this.sendMessage(o)
        }
        e.priority === Wl.MessagePriorityNotice && 1 === this.remoteConfig.msg_pull_enable ? (this.peerIds.includes(e.from.nickname) || this.peerIds.push(e.from.nickname), this.messageSync.recvMessage(e.from.nickname, e.unitSeqId, e)) : this.doHandleRecvPeerMessage(e)
    }, ww.prototype.doHandleRecvPeerMessage = function (t) {
        this.remoteLog.logRecvPeerMsg(t.content, t.from, {
            nickname: this.liveInfo.nickname,
            psId: this.userData.psId
        }, t.msgIdStr, t.sendTime ? this.ntpTime.getTime() - t.sendTime : 0);
        var e = {
            msgId: t.msgIdStr,
            timestamp: t.timestamp,
            msgPriority: t.priority,
            fromUserInfo: {
                nickname: t.from.nickname,
                psId: t.from.psId
            },
            toUserInfo: {
                nickname: this.liveInfo.nickname,
                psId: this.userData.psId
            },
            content: t.content
        };
        this.resultEvent.emit(Lg, e)
    }, ww.prototype.on = function (t, e) {
        return t ? this.status === _w.UnInit ? (ww.log.error("当前sdk 未初始化，不允许该操作"), zl.UnInit) : (this.registeredEvents.has(t) ? ww.log.warn("已注册事件: " + t) : (this.resultEvent.on(t, e), this.registeredEvents.set(t, e)), zl.Success) : (ww.log.error("eventType 错误"), zl.ParaError)
    }, ww.prototype.once = function (t, e) {
        return t ? this.status === _w.UnInit ? (ww.log.error("当前sdk 不为init状态，不允许该操作"), zl.UnInit) : (this.resultEvent.once(t, e), zl.Success) : (ww.log.error("eventType 错误"), zl.ParaError)
    }, ww.prototype.off = function (t, e) {
        return t ? this.status === _w.UnInit ? (ww.log.error("当前sdk 不为init状态，不允许该操作"), zl.UnInit) : (this.resultEvent.off(t, e), zl.Success) : (ww.log.error("eventType 错误"), zl.ParaError)
    }, ww.prototype.tryRemoteConfig = function () {
        var d = this;
        if (ww.log.info("tryConfig begin"), this.remoteConfigBegin = Date.now(), this.remoteConfigCount++, this.remoteConfigCount > this.config.remoteConfigRetry) return this.remoteConfigCount = 0, void
            function (t, e, r) {
                lv(t, {}, e, r)
            }(this.config.remoteConfigBackupAddr, function (t) {
                ww.log.debug("backupRemoteConfig success", "conf:" + t);
                var e = t[d.userData.appId];
                if (e) {
                    var r = e[d.liveInfo.businessId];
                    if (r) {
                        var o = Date.now() - d.remoteConfigBegin;
                        return d.remoteLog.logRemoteConfig(d.config.remoteConfigBackupAddr, 0, "请求remote config成功", o), d.dispatchIndex = 0, d.dispatchList = r, null !== d.dispatcherTimeout && clearTimeout(d.dispatcherTimeout), void (d.dispatcherTimeout = setTimeout(function () {
                            return d.tryDispatch()
                        }, 0))
                    }
                }
                var n = {
                    status: Hl.SDKProvisionStatus_ConfigError,
                    info: "parse config error!"
                };
                d.resultEvent.emit(eg, n);
                var i = Date.now() - d.remoteConfigBegin;
                d.remoteLog.logRemoteConfig(d.config.remoteConfigBackupAddr, 1, "请求remote config失败", i), null !== d.remoteConfigTimeout && clearTimeout(d.remoteConfigTimeout), d.remoteConfigTimeout = setTimeout(function () {
                    return d.tryRemoteConfig()
                }, d.config.remoteConfigTimeout)
            }, function (t) {
                var e = {
                    status: Hl.SDKProvisionStatus_ConfigError,
                    info: "get config error!"
                };
                d.resultEvent.emit(eg, e), ww.log.debug("backupRemoteConfig error", "err:" + t);
                var r = Date.now() - d.remoteConfigBegin;
                d.remoteLog.logRemoteConfig(d.config.remoteConfigBackupAddr, 1, "请求remote config失败" + t, r), null !== d.remoteConfigTimeout && clearTimeout(d.remoteConfigTimeout), d.remoteConfigTimeout = setTimeout(function () {
                    return d.tryRemoteConfig()
                }, d.config.remoteConfigTimeout)
            });
        var t = this.properties.confService;
        ! function (t, e, r, o) {
            var n = Date.now() / 1e3,
                i = {
                    "X-Auth-Appid": e.appId,
                    "X-Auth-TimeStamp": n,
                    "X-Auth-Sign": JR(e.appId + "&" + n + e.appKey)
                };
            lv(t + "?appId=" + e.appId + "&psId=" + e.psId + "&nickname=" + e.nickname + "&liveId=" + e.liveId + "&businessId=" + e.businessId + "&location=" + e.location + "&sdkVer=" + _R + "&agent=web&role=" + e.role, {
                headers: i
            }, r, o)
        }(t.protocol + "://" + t.hostname + t.url, {
            appId: this.userData.appId,
            appKey: this.userData.appKey,
            psId: this.userData.psId,
            nickname: this.liveInfo.nickname,
            liveId: this.liveInfo.liveId,
            businessId: this.liveInfo.businessId,
            location: this.liveInfo.location,
            role: this.liveInfo.role
        }, function (t) {
            var e, r, o = t.stat,
                n = t.message,
                i = t.data;
            if (0 === o) {
                if (ww.log.debug("remoteConfig success", "remoteConfig:", i, " message:" + n), d.dispatchIndex = 0, d.dispatchList = i.gslb, d.remoteConfig = i.sdkconfig, i.sdkconfig.ntp_service) {
                    var s = $l({}, i.sdkconfig.ntp_service.server, {
                        params: {
                            appId: d.userData.appId,
                            sdkVer: _R
                        }
                    }),
                        a = i.sdkconfig.ntp_service.config;
                    d.ntpTime.reset(s, a)
                }
                d.sendSync.initNamespace(lR, function (t) {
                    var e = LR(OR.SendPeerMessageType, t);
                    return d.sendMessage(e), e
                }, d.sendPeerMessageRespCallback, d.sendPeerMessageRespTimeout, d.remoteConfig.msg_send_timeout * d.remoteConfig.msg_send_retry), d.sendSync.initNamespace(gR, function (t) {
                    var e = LR(OR.SendRoomMessageType, t);
                    return d.sendMessage(e), e
                }, d.sendRoomMessageRespCallback, d.sendRoomMessageRespTimeout, d.remoteConfig.msg_send_timeout * d.remoteConfig.msg_send_retry), d.sendSync.initNamespace(yR, function (t) {
                    var e = LR(OR.SendRoomBinMessage, t);
                    return d.sendMessage(e), e
                }, d.handleSendRoomBinMessageRespCallback, d.handleSendRoomBinMessageRespTimeout, d.remoteConfig.msg_send_timeout * d.remoteConfig.msg_send_retry), d.messageSync.init(d.remoteConfig.msg_pull_waittime, d.remoteConfig.msg_pull_timeout, function (t, e) {
                    return d.handleRecvMessage(t, e)
                }, function (t, e, r) {
                    return d.handleMessageTimeout(t, e, r)
                });
                try {
                    for (var u = Xl(d.remoteConfig.msg_send_frequency), c = u.next(); !c.done; c = u.next()) {
                        var f = c.value;
                        d.messageLimit.reset(mR[f.priority], f.interval, f.count)
                    }
                } catch (t) {
                    e = {
                        error: t
                    }
                } finally {
                    try {
                        c && !c.done && (r = u.return) && r.call(u)
                    } finally {
                        if (e) throw e.error
                    }
                }
                var h = Date.now() - d.remoteConfigBegin;
                d.remoteLog.logRemoteConfig(d.config.remoteConfigAddr, 0, "请求remote config成功", h), null != d.dispatcherTimeout && clearTimeout(d.dispatcherTimeout), d.dispatcherTimeout = setTimeout(function () {
                    return d.tryDispatch()
                }, 0)
            } else {
                var p = {
                    status: Hl.SDKProvisionStatus_ConfigError,
                    info: "parse config error!"
                };
                d.resultEvent.emit(eg, p), ww.log.debug("remoteConfig error stat:", o), h = Date.now() - d.remoteConfigBegin, d.remoteLog.logRemoteConfig(d.config.remoteConfigAddr, 1, "remote config 请求失败 stat:" + o + " msg:" + n, h), null != d.remoteConfigTimeout && clearTimeout(d.remoteConfigTimeout), d.remoteConfigTimeout = setTimeout(function () {
                    return d.tryRemoteConfig()
                }, d.config.remoteConfigTimeout)
            }
        }, function (t) {
            var e = {
                status: Hl.SDKProvisionStatus_ConfigError,
                info: "get config error!"
            };
            d.resultEvent.emit(eg, e), ww.log.debug("remoteConfig error");
            var r = Date.now() - d.remoteConfigBegin;
            d.remoteLog.logRemoteConfig(d.config.remoteConfigAddr, 1, "remote config 请求失败 err:" + t, r), null != d.remoteConfigTimeout && clearTimeout(d.remoteConfigTimeout), d.remoteConfigTimeout = setTimeout(function () {
                return d.tryRemoteConfig()
            }, d.config.remoteConfigTimeout)
        })
    }, ww.prototype.tryDispatch = function () {
        var i = this;
        ww.log.info("tryDispatch begin"), this.dispatchIndex >= this.dispatchList.length && (ww.log.info("当前调度服务器全是重试，清零this.dispatchIndex"), this.dispatchIndex = 0), this.dispatchBegin = Date.now();
        var s = aw(this.dispatchList[this.dispatchIndex]);
        ! function (t, e, r, o, n, i, s, a, u) {
            var c = zR();
            lv(t + "?appId=" + e + "&businessId=" + r + "&liveId=" + n + "&psId=" + i + "&location=" + s + "&protocol=wss", {
                headers: {
                    "X-PS-AppID": e,
                    "X-PS-Timestamp": c,
                    "X-PS-Version": "1",
                    "X-PS-Signature": JR("" + e + o + c)
                }
            }, a, u)
        }(s, this.userData.appId, this.liveInfo.businessId, this.userData.appKey, this.liveInfo.liveId, this.userData.psId, this.liveInfo.location, function (t) {
            var e = t.content,
                r = t.stat;
            if (t.message, ww.log.debug("dispatch success remoteConfig:" + e), 0 === r) {
                var o = {
                    status: Hl.SDKProvisionStatus_Success,
                    info: "Success"
                };
                i.resultEvent.emit(eg, o);
                var n = Date.now() - i.dispatchBegin;
                i.remoteLog.logDispatch(s, 0, "请求调度成功", n), i.serverInfo = e, i.serverIndex = 0, null != i.connectTimeout && clearTimeout(i.connectTimeout), i.connectTimeout = setTimeout(function () {
                    return i.tryConnect()
                }, 0)
            } else o = {
                status: Hl.SDKProvisionStatus_DispatchError,
                info: "parse dispatch error!"
            }, i.resultEvent.emit(eg, o), ww.log.debug("dispatch error"), i.dispatchIndex++, null != i.dispatcherTimeout && clearTimeout(i.dispatcherTimeout), i.dispatcherTimeout = setTimeout(function () {
                return i.tryDispatch()
            }, Dv.reDispatchTimeout)
        }, function (t) {
            var e = {
                status: Hl.SDKProvisionStatus_DispatchError,
                info: "get dispatch error!"
            };
            i.resultEvent.emit(eg, e);
            var r = Date.now() - i.dispatchBegin;
            i.remoteLog.logDispatch(s, 1, "请求调度失败 errMsg:" + t, r), ww.log.debug("dispatch error:", t), i.dispatchIndex++, null != i.dispatcherTimeout && clearTimeout(i.dispatcherTimeout), i.dispatcherTimeout = setTimeout(function () {
                return i.tryDispatch()
            }, Dv.reDispatchTimeout)
        })
    }, ww.prototype.handleRecvMessage = function (t, e) {
        t.startsWith("##") ? this.doHandleRecvRoomBinMessageNotice(e) : t.startsWith("#") ? this.doHandleRecvRoomMessage(e) : this.doHandleRecvPeerMessage(e)
    }, ww.prototype.handleMessageTimeout = function (t, e, r) {
        if (console.log("handleMessageTimeout namespace" + t + " begin:" + e + " end:" + r), t.startsWith("#")) {
            var o = function (t, e, r) {
                var o = dR.GetRoomMissingMessage.new();
                return o.readFromObject({
                    roomId: t,
                    seqIdBegin: e,
                    seqIdEnd: r
                }), o.toBinBuffer().toNodeBuffer()
            }(t, e, r),
                n = LR(OR.GetRoomMissingMessage, o);
            this.sendMessage(n)
        } else {
            var i = function (t, e, r) {
                var o = dR.GetPeerMissingMessage.new();
                return o.readFromObject({
                    peer: {
                        nickname: t
                    },
                    seqIdBegin: e,
                    seqIdEnd: r
                }), o.toBinBuffer().toNodeBuffer()
            }(t, e, r);
            n = LR(OR.GetPeerMissingMessage, i), this.sendMessage(n)
        }
    }, ww.prototype.tryConnect = function () {
        var e = this;
        if (ww.log.info("tryConnect begin"), this.status != _w.Logout && this.status != _w.Init)
            if (this.status != _w.UnInit) {
                if (this.connectBegin = Date.now(), this.serverIndex >= this.serverInfo.endpoint.length) return this.serverIndex = 0, ww.log.info("当前服务器列表全部重试 重新调度"), this.dispatchIndex++, void this.tryDispatch();
                var t = this.serverInfo.endpoint[this.serverIndex++].host;
                ww.log.debug("tryConnect use url:", t), this.remoteLog && this.remoteLog.destroy();
                var r = this.properties.logService,
                    o = null;
                r && (o = r.protocol + "://" + r.hostname + r.url), this.remoteLog.reset(o, this.userData.appId, this.liveInfo.businessId, this.userData.psId, this.liveInfo.nickname, this.liveInfo.liveId, t), this.conn.registerCallback({
                    openCallback: function () {
                        return e.handleConnOpen()
                    },
                    closeCallback: function (t) {
                        return e.handleConnClose(t)
                    },
                    errorCallback: function (t) {
                        return e.handleConnError(t)
                    },
                    messageCallback: function (t) {
                        return e.handleConnMessage(t)
                    }
                }), this.conn.connect("wss://" + t, this.remoteConfig.connect_timeout)
            } else ww.log.info("already uninited, stop reconnect");
        else ww.log.info("already logout, stop reconnect")
    }, ww.prototype.messageDispatch = function (t, e) {
        switch (t.command) {
            case OR.LoginRespType:
                this.handleLoginResp(t);
                break;
            case OR.PingType:
                this.handlePing();
                break;
            case OR.PongType:
                this.handlePong();
                break;
            case OR.UnkownCommand:
                this.handleUnkownCommand(t);
                break;
            case OR.KickoutType:
                this.handleKickout(t);
                break;
            case OR.LogoutNiticeType:
                this.handleLogoutNotice(t);
                break;
            case OR.RecoverPeerResp:
                this.handleRecoverPeerResp(t);
                break;
            case OR.RecoverPeerMessageNotice:
                this.handleRecoverPeerNotice(t);
                break;
            case OR.JoinRoomRespType:
                this.handleJoinRoomResp(t, e);
                break;
            case OR.JoinRoomNoticeType:
                this.handleJoinRoomNotice(t);
                break;
            case OR.JoinRoomInfoNoticeType:
                this.handleJoinRoomMetaDataNotice(t);
                break;
            case OR.JoinUserListNoticeType:
                this.handleJoinRoomUserListNotice(t);
                break;
            case OR.RoomUserCountNotice:
                this.handleRoomUserCountNotice(t);
                break;
            case OR.RoomDataNotice:
                this.handleRecvRoomData(t);
                break;
            case OR.LeaveRoomRespType:
                this.handleLeaveRoomResp(t, e);
                break;
            case OR.LeaveRoomNoticeType:
                this.handleLeaveRoomNotice(t);
                break;
            case OR.SendRoomMessageRespType:
                this.handleSendRoomMessageResp(t);
                break;
            case OR.RecvRoomMessageType:
                this.handleRecvRoomMessage(t);
                break;
            case OR.RecoverRoomMessageNotice:
                this.handleRecoverRoomMessageNotice(t);
                break;
            case OR.MuteRoomNotice:
                this.handleMuteRoomNotice(t);
                break;
            case OR.MuteRoomResp:
                this.handleMuteRoomResp(t, e);
                break;
            case OR.RoomMuteStatusResp:
                this.handleMuteRoomStatusResp(t, e);
                break;
            case OR.SetRoomDataResp:
                this.handleSetRoomDataResp(t, e);
                break;
            case OR.SetBatchRoomDataResp:
                this.handleSetRoomsDataResp(t, e);
                break;
            case OR.GetRoomDataResp:
                this.handleGetRoomData(t, e);
                break;
            case OR.RoomMsgSubscribeResp:
                this.handleSetRoomMsgSubscribeOptionResp(t, e);
                break;
            case OR.GetRoomHistoryMessageRespType:
                this.handleGetRoomHistoryMessageResp(t);
                break;
            case OR.SendRoomBinMessageResp:
                this.handleSendRoomBinMessageResp(t);
                break;
            case OR.RecvRoomBinMessage:
                this.handleRecvRoomBinMessageNotice(t);
                break;
            case OR.GetRoomHistoryBinMessageResp:
                this.handleGetRoomHistoryBinMessageResp(t, e);
                break;
            case OR.GetRoomHistoryBinMessageNotice:
                this.handleGetRoomHistoryBinMessageNotice(t);
                break;
            case OR.GetRoomBatchHistoryBinMessageResp:
                this.handleGetRoomBatchHistoryBinMessageResp(t, e);
                break;
            case OR.GetRoomBatchHistoryBinMessageNotice:
                this.handleGetRoomBatchHistoryBinMessageNotice(t);
                break;
            case OR.SendPeerMessageRespType:
                this.handleSendPeerMessageResp(t);
                break;
            case OR.RecvPeerMessageType:
                this.handleRecvPeerMessage(t);
                break;
            case OR.GetStatisticsResp:
                this.handleGetStatisticsResp(t, e);
                break;
            case OR.GetStatisticsNotice:
                this.handleGetStatisticsNotice(t);
                break;
            case OR.GetRoomHistoryMessageReqType:
                this.handlePullMessageResp(!0, t);
                break;
            case OR.GetPeerMissingMessageResp:
                this.handlePullMessageResp(!1, t);
                break;
            case OR.GetRoomMissingMessageNotice:
                this.handlePullMessageNotice(!0, t);
                break;
            case OR.GetPeerMissingMessageNotice:
                this.handlePullMessageNotice(!1, t)
        }
    }, ww.prototype.handlePullMessageResp = function (t, e) {
        console.log("handlePullMessageResp"), t ? dR.GetRoomMissingMessageResp.create(new hR.InputStream(new hR.BinBuffer(cR.from(e.data)))) : dR.GetPeerMissingMessageResp.create(new hR.InputStream(new hR.BinBuffer(cR.from(e.data))))
    }, ww.prototype.handlePullMessageNotice = function (t, e) {
        if (t) {
            var r = dR.GetRoomMissingMessageNotice.create(new hR.InputStream(new hR.BinBuffer(cR.from(e.data))));
            console.log("handlePullMessageNotice", r);
            for (var o = 0; o < r.messages.length; o++) this.messageSync.recvMessage(r.roomId, r.messages.value[o].unitSeqId, r.messages.value[o])
        } else
            for (r = dR.GetPeerMissingMessageNotice.create(new hR.InputStream(new hR.BinBuffer(cR.from(e.data)))), console.log("handlePullMessageNotice", r), o = 0; o < r.messages.length; o++) this.messageSync.recvMessage(r.peer.nickname, r.messages.value[o].unitSeqId, r.messages.value[o])
    }, ww.prototype.timeoutMessageDispatch = function (t) {
        switch (t.command) {
            case OR.LoginType:
                this.handleLoginResp(null)
        }
    }, ww.prototype.handleConnOpen = function () {
        ww.log.info("handleConnOpen");
        var t = Date.now() - this.connectBegin;
        this.remoteLog.logConnect(0, "建立websocket成功", t), ww.log.info("handleConnOpen send login pack");
        var e, r = JR(this.userData.password + this.serverInfo.token);
        e = this.status === _w.Logging ? AR({
            appId: this.userData.appId,
            liveId: this.liveInfo.liveId,
            psId: this.userData.psId,
            password: r,
            nickname: this.liveInfo.nickname,
            deviceType: dR.DeviceType.DeviceTypeWeb,
            token: this.serverInfo.token,
            reconnect: !1,
            msgPullNum: this.remoteConfig.msg_pull_max_num,
            businessId: this.liveInfo.businessId,
            subBusinessId: this.liveInfo.subBusinessId,
            roomUserMode: this.userData.roomUserMode,
            role: this.liveInfo.role,
            kickout: this.userData.kickout
        }) : AR({
            appId: this.userData.appId,
            liveId: this.liveInfo.liveId,
            psId: this.userData.psId,
            password: r,
            nickname: this.liveInfo.nickname,
            deviceType: dR.DeviceType.DeviceTypeWeb,
            token: this.serverInfo.token,
            reconnect: !0,
            msgPullNum: this.remoteConfig.msg_pull_max_num,
            businessId: this.liveInfo.businessId,
            subBusinessId: this.liveInfo.subBusinessId,
            roomUserMode: this.userData.roomUserMode,
            role: this.liveInfo.role,
            kickout: !0
        });
        var o = LR(OR.LoginType, e);
        this.sendMessage(o), this.heartbeatManager = new nw(this.remoteConfig.ping_interval, this.remoteConfig.ping_timeout, this.sendHeartbeat.bind(this), this.handlePingTimeout.bind(this))
    }, ww.prototype.sendHeartbeat = function () {
        var t = LR(OR.PingType, null);
        this.sendMessage(t)
    }, ww.prototype.handlePingTimeout = function () {
        var t = this;
        console.log("handlePingTimeout");
        var e = Date.now() - this.connectBegin;
        this.remoteLog.logNetChange(604, "心跳超时", 0 < this.roomIds.length ? 2 : 1, e, this.roomIds), this.conn.close();
        var r = Date.now() - this.connectBegin;
        this.remoteLog.logConnect(1, "login error, ping timeout", r), this.status = _w.ReLogin;
        var o = {
            netStatus: Kl.DisConnected
        };
        this.resultEvent.emit(ng, o);
        var n = {
            netStatus: Kl.Connecting
        };
        this.resultEvent.emit(ng, n), setTimeout(function () {
            return t.tryConnect()
        }, 0)
    }, ww.prototype.handleConnError = function (t) {
        var e = this;
        if (ww.log.info("handleConnError"), t && t.errMsg) {
            var r = Date.now() - this.connectBegin;
            this.remoteLog.logConnect(1, "login error: weixin socket error: " + t.errMsg, r), setTimeout(function () {
                return e.tryConnect()
            }, this.retryInterval())
        }
    }, ww.prototype.handleConnClose = function (t) {
        var e = this;
        if (ww.log.info("handleConnClose, code: " + t), this.remoteLog.destroy(), this.roomUserCount = new Map, null != this.heartbeatManager && this.heartbeatManager.stop(), this.status === _w.Logging) {
            var r = Date.now() - this.connectBegin;
            this.remoteLog.logConnect(1, "login error, connection close, state is Logging, code: " + t, r), setTimeout(function () {
                return e.tryConnect()
            }, 0)
        } else if (this.status === _w.Login) {
            r = Date.now() - this.connectBegin, this.remoteLog.logConnect(1, "login error, connection close, state is login, code: " + t, r), this.status = _w.ReLogin;
            var o = {
                netStatus: Kl.DisConnected
            };
            this.resultEvent.emit(ng, o);
            var n = {
                netStatus: Kl.Connecting
            };
            this.resultEvent.emit(ng, n), setTimeout(function () {
                return e.tryConnect()
            }, 0)
        } else this.status === _w.ReLogin && (r = Date.now() - this.connectBegin, this.remoteLog.logConnect(1, "login error, connection close, state is ReLogin, code: " + t, r), setTimeout(function () {
            return e.tryConnect()
        }, 0))
    }, ww.prototype.handleConnMessage = function (t) {
        if (this.heartbeatManager.ping(), t.command !== OR.LoginRespType && 0 !== t.length && this.serverData && 1 === this.serverData.encpytType) {
            var e = this.aesEcb.decrypt(t.data);
            t.length = e.length, t.data = e
        }
        var r;
        t.command !== OR.LoginRespType && t.command !== OR.JoinRoomRespType && t.command !== OR.GetRoomHistoryBinMessageResp && t.command !== OR.LeaveRoomRespType && t.command !== OR.GetStatisticsResp && t.command !== OR.GetRoomBatchHistoryBinMessageResp && t.command !== OR.MuteRoomResp && t.command !== OR.RoomMuteStatusResp && t.command !== OR.SetRoomDataResp && t.command !== OR.SetBatchRoomDataResp && t.command !== OR.GetRoomDataResp && t.command !== OR.RoomMsgSubscribeResp || (r = this.msgHandle.receiveMsg(t)) ? this.messageDispatch(t, r) : console.log("preMsg is null msg:", t)
    }, ww.prototype.sendMessage = function (t) {
        if (t.command === OR.LoginType || t.command === OR.JoinRoomType || t.command === OR.GetRoomHistoryBinMessage || t.command === OR.LeaveRoomType || t.command === OR.GetStatistics || t.command === OR.GetRoomBatchHistoryBinMessage || t.command === OR.MuteRoomReqType || t.command === OR.RoomMuteStatusReqType || t.command === OR.SetRoomData || t.command === OR.SetBatchRoomData || t.command === OR.GetRoomData || t.command === OR.RoomMsgSubscribe) {
            var e = new kR;
            e.data = t.data, e.seqId = t.seqId, this.msgHandle.registerMsg(e)
        }
        if (t.command !== OR.LoginType && 0 !== t.length && this.serverData && 1 === this.serverData.encpytType) {
            var r = 16 - t.data.length % 16;
            0 === r && (r = 16);
            var o = cR.alloc(t.data.length + r, t.data);
            o.fill(r, t.data.length);
            var n = this.aesEcb.encrypt(o);
            t.length = n.length, t.data = n
        }
        this.conn.send(t)
    }, ww.prototype.addUserToRoomMap = function (t, e) {
        var r = this.roomUserCount.get(t);
        this.roomUserCount.set(t, r + 1)
    }, ww.prototype.remoteUserFromRoom = function (t, e) {
        var r = this.roomUserCount.get(t);
        this.roomUserCount.set(t, r - 1)
    }, ww.prototype.retryInterval = function () {
        var t = this.failTimes++;
        return 500 * Math.pow(2, 2 < t ? 2 : t)
    }, ww.log = new Rv("IrcCore"), ww);

    function ww() {
        var S = this;
        this.userData = {
            appId: "",
            appKey: "",
            psId: "",
            password: "",
            roomUserMode: 1,
            kickout: void 0
        }, this.remoteConfigCount = 0, this.dispatchIndex = 0, this.serverIndex = 0, this.registeredEvents = new Map, this.subOptions = new Map, this.failTimes = 0, this.sendRoomMessageRespTimeout = function (t, e) {
            for (var r = dR.SendRoomMessage.create(new hR.InputStream(new hR.BinBuffer(cR.from(t.data)))).roomIds, o = 0; o < r.length; o++) {
                var n = {
                    code: jR,
                    info: "send timeout",
                    fromUserInfo: {
                        psId: S.userData.psId,
                        nickname: S.liveInfo.nickname
                    },
                    toRoomId: r.value[o],
                    preMsgId: e,
                    msgId: 0,
                    timestamp: 0
                };
                S.resultEvent.emit(yg, n)
            }
        }, this.sendRoomMessageRespCallback = function (t, e, r) {
            var o, n, i = dR.SendRoomMessageResp.create(new hR.InputStream(new hR.BinBuffer(cR.from(t.data)))),
                s = dR.SendRoomMessage.create(new hR.InputStream(new hR.BinBuffer(cR.from(e.data))));
            ww.log.debug("handleSendRoomMessageResp ", i);
            for (var a, u = s.roomIds, c = s.content, f = s.priority, h = [], p = 0; p < u.length; p++) h.push(u.value[p]);
            if (i.code !== dR.Code.CodeSuccess) {
                a = "0";
                for (p = 0; p < s.roomIds.length; p++) {
                    var d = s.roomIds.value[p],
                        m = {
                            code: i.code,
                            info: i.msg,
                            fromUserInfo: {
                                psId: S.userData.psId,
                                nickname: S.liveInfo.nickname
                            },
                            toRoomId: d,
                            preMsgId: r,
                            msgId: 0,
                            timestamp: 0
                        };
                    S.resultEvent.emit(yg, m)
                }
            } else {
                var l = i.data;
                a = l.msgIdStr;
                var g = s.roomIds.value.filter(function (e) {
                    return !l.fail.value.find(function (t) {
                        return t.roomId === e
                    })
                });
                try {
                    for (var y = Xl(g), _ = y.next(); !_.done; _ = y.next()) {
                        d = _.value, m = {
                            code: dR.Code.CodeSuccess,
                            info: i.msg,
                            fromUserInfo: {
                                psId: S.userData.psId,
                                nickname: S.liveInfo.nickname
                            },
                            toRoomId: d,
                            preMsgId: r,
                            msgId: a,
                            timestamp: l.timestamp
                        };
                        S.resultEvent.emit(yg, m)
                    }
                } catch (t) {
                    o = {
                        error: t
                    }
                } finally {
                    try {
                        _ && !_.done && (n = y.return) && n.call(y)
                    } finally {
                        if (o) throw o.error
                    }
                }
                for (p = 0; p < l.fail.length; p++) {
                    var R = l.fail.value[p];
                    d = R.roomId, m = {
                        code: R.code,
                        info: R.msg,
                        fromUserInfo: {
                            psId: S.userData.psId,
                            nickname: S.liveInfo.nickname
                        },
                        toRoomId: d,
                        preMsgId: r,
                        msgId: a,
                        timestamp: i.timestamp
                    };
                    S.resultEvent.emit(yg, m)
                }
            }
            var v = function (t, e) {
                var r, o, n = [];
                try {
                    for (var i = Xl(t), s = i.next(); !s.done; s = i.next()) {
                        var a = s.value;
                        n.push({
                            user_count: e.get(a),
                            room: a
                        })
                    }
                } catch (t) {
                    r = {
                        error: t
                    }
                } finally {
                    try {
                        s && !s.done && (o = i.return) && o.call(i)
                    } finally {
                        if (r) throw r.error
                    }
                }
                return n
            }(h, S.roomUserCount);
            v = v.map(function (t) {
                var e = t.user_count;
                return {
                    recver: t.room,
                    user_count: e - 1
                }
            });
            var w = S.ntpTime.getTime() - s.sendTime;
            S.remoteLog.logSendRoomMsg(c, f, {
                nickname: S.liveInfo.nickname,
                psId: S.userData.psId
            }, v, w, a)
        }, this.handleSendRoomBinMessageRespTimeout = function (t, e) {
            var r, o = dR.SendRoomBinMessage.create(new hR.InputStream(new hR.BinBuffer(cR.from(t.data)))),
                n = new Array;
            0 === o.roomIds.length ? r = S.roomIds : (r = new Array, o.roomIds.value.forEach(function (t) {
                return r.push(t)
            })), r.forEach(function (t) {
                n.push({
                    code: jR,
                    msg: "send timeout",
                    roomId: t,
                    dbKey: o.dbKey,
                    keyMsgId: o.keyMsgId
                })
            }), n.forEach(function (t) {
                return S.resultEvent.emit(Ig, t)
            })
        }, this.handleSendRoomBinMessageRespCallback = function (t, e, r) {
            var o, n = dR.SendRoomBinMessageResp.create(new hR.InputStream(new hR.BinBuffer(cR.from(t.data)))),
                i = dR.SendRoomBinMessage.create(new hR.InputStream(new hR.BinBuffer(cR.from(e.data)))),
                s = new Array,
                a = n.data;
            if (0 === i.roomIds.length ? o = S.roomIds : (o = new Array, i.roomIds.value.forEach(function (t) {
                return o.push(t)
            })), n.code !== dR.Code.CodeSuccess) o.forEach(function (t) {
                s.push({
                    code: n.code,
                    msg: n.msg,
                    roomId: t,
                    dbKey: i.dbKey,
                    keyMsgId: i.keyMsgId
                })
            });
            else {
                var u = new Array;
                a.fail.value.forEach(function (t) {
                    var e = t.roomId,
                        r = t.code,
                        o = t.msg;
                    u.push(e), s.push({
                        code: r,
                        msg: o,
                        roomId: e,
                        dbKey: i.dbKey,
                        keyMsgId: i.keyMsgId
                    })
                }), o.forEach(function (t) {
                    u.includes(t) || s.push({
                        code: n.code,
                        msg: n.msg,
                        roomId: t,
                        msgId: a.msgId,
                        timestamp: a.timestamp,
                        dbKey: i.dbKey,
                        keyMsgId: i.keyMsgId
                    })
                })
            }
            s.forEach(function (t) {
                return S.resultEvent.emit(Ig, t)
            }), S.remoteLog.logSendRoomBinMsg(i.msgId, i.keyMsgId, i.dbKey, n.code, n.msg, {
                nickname: S.liveInfo.nickname,
                psId: S.userData.psId
            }, i.roomIds.value, S.ntpTime.getTime() - i.sendTime, S.remoteConfig.bin_msg_sample_rate)
        }, this.sendPeerMessageRespTimeout = function (t, e) {
            console.log("sendPeerMessageRespTimeout");
            for (var r = dR.SendPeerMessage.create(new hR.InputStream(new hR.BinBuffer(cR.from(t.data)))), o = 0; o < r.to.length; o++) {
                var n = r.to.value[o],
                    i = {
                        code: jR,
                        info: "send timeout",
                        fromUserInfo: {
                            nickname: S.liveInfo.nickname,
                            psId: S.userData.psId
                        },
                        toUserInfo: {
                            nickname: n.nickname,
                            psId: n.psId
                        },
                        msgId: 0,
                        preMsgId: e,
                        timestamp: Date.now()
                    };
                S.resultEvent.emit(Eg, i)
            }
        }, this.sendPeerMessageRespCallback = function (t, e, r) {
            var o, n, i = dR.SendPeerMessageResp.create(new hR.InputStream(new hR.BinBuffer(cR.from(t.data)))),
                s = dR.SendPeerMessage.create(new hR.InputStream(new hR.BinBuffer(cR.from(e.data))));
            ww.log.debug("handleSendPeerMessageResp ", i, s);
            var a, u = s.to,
                c = s.content,
                f = s.priority;
            if (i.code !== dR.Code.CodeSuccess) {
                a = "0";
                for (var h = 0; h < s.to.length; h++) {
                    var p = s.to.value[h],
                        d = {
                            code: i.code,
                            info: i.msg,
                            fromUserInfo: {
                                nickname: S.liveInfo.nickname,
                                psId: S.userData.psId
                            },
                            toUserInfo: {
                                nickname: p.nickname,
                                psId: p.psId
                            },
                            msgId: i.data.msgId,
                            preMsgId: r,
                            timestamp: i.data.timestamp
                        };
                    S.resultEvent.emit(Eg, d)
                }
            } else {
                a = i.data.msgId;
                var m = s.to.value.filter(function (t) {
                    var e = t.nickname;
                    return !i.data.fail.value.find(function (t) {
                        return t.user.nickname === e
                    })
                });
                try {
                    for (var l = Xl(m), g = l.next(); !g.done; g = l.next()) {
                        p = g.value, d = {
                            code: dR.Code.CodeSuccess,
                            info: i.msg,
                            fromUserInfo: {
                                nickname: S.liveInfo.nickname,
                                psId: S.userData.psId
                            },
                            toUserInfo: {
                                nickname: p.nickname,
                                psId: p.psId
                            },
                            msgId: a,
                            preMsgId: r,
                            timestamp: i.data.timestamp
                        };
                        S.resultEvent.emit(Eg, d)
                    }
                } catch (t) {
                    o = {
                        error: t
                    }
                } finally {
                    try {
                        g && !g.done && (n = l.return) && n.call(l)
                    } finally {
                        if (o) throw o.error
                    }
                }
                for (h = 0; h < i.data.fail.length; h++) {
                    var y = i.data.fail.value[h];
                    p = y.user, d = {
                        code: y.code,
                        info: y.msg,
                        fromUserInfo: {
                            nickname: S.liveInfo.nickname,
                            psId: S.userData.psId
                        },
                        toUserInfo: {
                            nickname: p.nickname,
                            psId: p.psId
                        },
                        msgId: a,
                        preMsgId: r,
                        timestamp: i.data.timestamp
                    };
                    S.resultEvent.emit(Eg, d)
                }
            }
            var _ = [];
            for (h = 0; h < u.length; h++) _.push({
                recver: u.value[h].nickname,
                user_count: 1
            });
            var R = S.ntpTime.getTime() - s.sendTime;
            f === Wl.MessagePriorityNotice && S.remoteLog.logSendPeerMsg(c, f, {
                nickname: S.liveInfo.nickname,
                psId: S.userData.psId
            }, R, a, _)
        }, this.ntpTime = new uw(ww.log), this.remoteLog = new Lv(this.ntpTime), this.binaryMessageHistory = new Nv, this.config = Dv, this.status = _w.UnInit, this.msgHandle = new yv, this.msgHandle.setOnMessageTimeout(function (t) {
            return S.timeoutMessageDispatch(t)
        }), this.conn = new xR, this.peerIds = new Array, this.roomIds = new Array, this.roomUserCount = new Map, this.modeRoomIdMap = new Map, this.messageLimit = new Gv([]), this.messageSync = new Xv, this.sendSync = new rw, this.resultEvent = new lw
    } (Rw = _w = _w || {})[Rw.Init = 0] = "Init", Rw[Rw.New = 1] = "New", Rw[Rw.Logging = 2] = "Logging", Rw[Rw.reLogging = 3] = "reLogging", Rw[Rw.Login = 4] = "Login", Rw[Rw.OffLine = 5] = "OffLine", Rw[Rw.ReLogin = 6] = "ReLogin", Rw[Rw.Logout = 7] = "Logout", Rw[Rw.UnInit = 8] = "UnInit";
    var Sw = (Mw.prototype.sendPeerMessage = function (t, e, r) {
        return this.ircCore.sendPeerMessage(t, e, r)
    }, Mw.prototype.sendPeerMessageWithPreMsgId = function (t, e, r) {
        return this.ircCore.sendPeerMessageWithPreMsgId(t, e, r)
    }, Mw.prototype.on = function (t, e) {
        return this.ircCore.on(t, e)
    }, Mw.prototype.off = function (t, e) {
        return this.ircCore.off(t, e)
    }, Mw);

    function Mw(t) {
        this.ircCore = t
    }
    var bw = (Iw.prototype.joinChatRooms = function (t) {
        return this.ircCore.joinChatRoomsWithJoinMode(t, 1)
    }, Iw.prototype.joinChatRoomsWithJoinMode = function (t, e) {
        return this.ircCore.joinChatRoomsWithJoinMode(t, e)
    }, Iw.prototype.leaveChatRooms = function (t) {
        return this.ircCore.leaveChatRooms(t)
    }, Iw.prototype.sendRoomMessage = function (t, e, r) {
        return this.ircCore.sendRoomMessage(t, e, r)
    }, Iw.prototype.muteRoom = function (t, e) {
        return this.ircCore.muteRoom(t, e)
    }, Iw.prototype.getRoomMuteStatus = function (t) {
        return this.ircCore.getRoomMuteStatus(t)
    }, Iw.prototype.setRoomData = function (t, e) {
        return this.ircCore.setRoomData(t, e)
    }, Iw.prototype.setRoomsData = function (t, e) {
        return this.ircCore.setRoomsData(t, e)
    }, Iw.prototype.getRoomData = function (t, e) {
        return this.ircCore.getRoomData(t, e)
    }, Iw.prototype.getAllRoomData = function (t) {
        return this.ircCore.getAllRoomData(t)
    }, Iw.prototype.setRoomSubscribeOption = function (t, e) {
        return this.ircCore.setRoomSubscribeOption(t, e)
    }, Iw.prototype.sendRoomMessageWithPreMsgId = function (t, e, r) {
        return this.ircCore.sendRoomMessageWithPreMsgId(t, e, r)
    }, Iw.prototype.getRoomHistoryMessage = function (t, e) {
        return this.ircCore.getRoomHistoryMessage(t, e)
    }, Iw.prototype.sendRoomBinMessage = function (t, e, r, o) {
        return this.ircCore.sendRoomBinMessage(t, e, r, o)
    }, Iw.prototype.getRoomHistoryBinMessage = function (t, e, r, o, n) {
        return void 0 === n && (n = 0), this.ircCore.getRoomHistoryBinMessage(t, e, r, o, n)
    }, Iw.prototype.getRoomBatchHistoryBinaryMessages = function (t) {
        return this.ircCore.GetRoomBatchHistoryBinMessage(t)
    }, Iw.prototype.getStatistics = function (t, e) {
        return this.ircCore.getStatistics(t, e)
    }, Iw.prototype.getRoomUserList = function (t, e) {
        return this.ircCore.getRoomUserList(t, e)
    }, Iw.prototype.on = function (t, e) {
        return this.ircCore.on(t, e)
    }, Iw.prototype.off = function (t, e) {
        return this.ircCore.off(t, e)
    }, Iw);

    function Iw(t) {
        this.ircCore = t
    }

    function Bw() {
        var t = new vw;
        this.ircCore = t, this.PeerChatManager = new Sw(t), this.RoomChatManager = new bw(t)
    }
    return new (Bw.prototype.init = function (t, e) {
        return this.ircCore.init(t, e)
    }, Bw.prototype.uninit = function () {
        return this.ircCore.uninit()
    }, Bw.prototype.setSdkProperties = function (t) {
        return this.ircCore.setSdkProperties(t)
    }, Bw.prototype.setLiveInfo = function (t) {
        return this.ircCore.setLiveInfo(t)
    }, Bw.prototype.startNetworkQulityTest = function (t, e) {
        return this.ircCore.startNetworkQulityTest(t, e)
    }, Bw.prototype.login = function (t, e, r) {
        return this.ircCore.loginWithMode(t, e, 0, r)
    }, Bw.prototype.loginWithMode = function (t, e, r, o) {
        return this.ircCore.loginWithMode(t, e, r, o)
    }, Bw.prototype.logout = function () {
        return this.ircCore.logout()
    }, Bw.prototype.on = function (t, e) {
        return this.ircCore.on(t, e)
    }, Bw.prototype.off = function (t, e) {
        return this.ircCore.off(t, e)
    }, Bw)
});