; (window.webpackJsonp = window.webpackJsonp || []).push([
  ['chunk-fd38125e'],
  {
    '02615': function (e, t, n) {
      const r = n('eb3b'),
        o = n('5a20'),
        a = n('445e')
      e.exports = function (e, t) {
        var n = [],
          s = {
            header: e.slice(n, (n += a.Constants.CENHDR)),
            entryName: e.slice(n, (n += s.header.fileNameLength)),
          },
          i = Buffer.alloc(0),
          value_0 = new o.MainHeader(),
          l = false
        const u = Object.assign(Object.create(null), t),
          { noSort: d } = u
        function f(t) {
          const n = value_0.diskEntries
          let o = value_0.offset
          for (let s = 0; s < n; s++) {
            let n = o
            const s = new r(e)
            o += s.header.entryHeaderSize
            t(s)
          }
        }
        function p() {
          l = true
          s = {}
          n = new Array(value_0.diskEntries)
          for (var t = value_0.offset, o = 0; o < n.length; o++) {
            var i = t,
              u = new r(e)
            u.header = e.slice(i, (i += a.Constants.CENHDR))
            u.entryName = e.slice(i, (i += u.header.fileNameLength))
            u.header.extraLength &&
              (u.extra = e.slice(i, (i += u.header.extraLength)))
            u.header.commentLength &&
              (u.comment = e.slice(i, i + u.header.commentLength))
            t += u.header.entryHeaderSize
            n[o] = u
            s[u.entryName] = u
          }
        }
        function h(t) {
          var n = e.length - a.Constants.ENDHDR,
            r = Math.max(0, n - 65535),
            o = r,
            s = e.length,
            l = -1,
            u = 0
          for (n; n >= o; n--) {
            if (80 === e[n]) {
              if (e.readUInt32LE(n) !== a.Constants.ENDSIG) {
                if (e.readUInt32LE(n) !== a.Constants.END64SIG) {
                  if (e.readUInt32LE(n) === a.Constants.ZIP64SIG) {
                    l = n
                    s =
                      n +
                      a.readBigUInt64LE(e, n + a.Constants.ZIP64SIZE) +
                      a.Constants.ZIP64LEAD
                    break
                  }
                } else {
                  o = r
                }
              } else {
                l = n
                u = n
                s = n + a.Constants.ENDHDR
                o = n - a.Constants.END64HDR
              }
            }
          }
          if (!~l) {
            throw new Error(a.Errors.INVALID_FORMAT)
          }
          value_0.loadFromBinary(e.slice(l, s))
          value_0.commentLength && (i = e.slice(u + a.Constants.ENDHDR))
          t && p()
        }
        function m() {
          n.length > 1 &&
            !d &&
            n.sort((e, t) =>
              e.entryName.toLowerCase().localeCompare(t.entryName.toLowerCase())
            )
        }
        return (
          e ? h(u.readEntries) : (l = true),
          {
            get entries() {
              return l || p(), n
            },
            get comment() {
              return i.toString()
            },
            set comment(e) {
              i = a.toBuffer(e)
              value_0.commentLength = i.length
            },
            getEntryCount: function () {
              return l ? n.length : value_0.diskEntries
            },
            forEach: function (e) {
              l ? n.forEach(e) : f(e)
            },
            getEntry: function (e) {
              return l || p(), s[e] || null
            },
            setEntry: function (e) {
              l || p()
              n.push(e)
              s[e.entryName] = e
              value_0.totalEntries = n.length
            },
            deleteEntry: function (e) {
              l || p()
              var t = s[e]
              if (t && t.isDirectory) {
                var r = this
                this.getEntryChildren(t).forEach(function (t) {
                  t.entryName !== e && r.deleteEntry(t.entryName)
                })
              }
              n.splice(n.indexOf(t), 1)
              delete s[e]
              value_0.totalEntries = n.length
            },
            getEntryChildren: function (e) {
              if ((l || p(), e && e.isDirectory)) {
                const t = [],
                  r = e.entryName,
                  o = r.length
                return (
                  n.forEach(function (e) {
                    e.entryName.substr(0, o) === r && t.push(e)
                  }),
                  t
                )
              }
              return []
            },
            compressToBuffer: function () {
              l || p()
              m()
              const e = [],
                t = []
              let r = 0,
                o = 0
              value_0.size = 0
              value_0.offset = 0
              for (const a of n) {
                const n = a.getCompressedData()
                a.header.offset = o
                const s = a.header.dataHeaderToBinary(),
                  i = a.rawEntryName.length,
                  l = Buffer.alloc(i + a.extra.length)
                a.rawEntryName.copy(l, 0)
                l.copy(a.extra, i)
                const u = s.length + l.length + n.length
                o += u
                e.push(s)
                e.push(l)
                e.push(n)
                const d = a.packHeader()
                t.push(d)
                value_0.size += d.length
                r += u + d.length
              }
              r += value_0.mainHeaderSize
              value_0.offset = o
              o = 0
              const s = Buffer.alloc(r)
              for (const n of e) n.copy(s, o), (o += n.length)
              for (const n of t) n.copy(s, o), (o += n.length)
              const u = value_0.toBinary()
              return i && i.copy(u, a.Constants.ENDHDR), u.copy(s, o), s
            },
            toAsyncBuffer: function (e, t, r, o) {
              try {
                l || p()
                m()
                const t = [],
                  s = []
                let u = 0,
                  d = 0
                value_0.size = 0
                value_0.offset = 0
                const f = function (n) {
                  if (n.length) {
                    const e = n.pop(),
                      a = e.entryName + e.extra.toString()
                    r && r(a)
                    e.getCompressedDataAsync(function (r) {
                      o && o(a)
                      e.header.offset = d
                      const i = e.header.dataHeaderToBinary(),
                        l = Buffer.alloc(a.length, a),
                        p = i.length + l.length + r.length
                      d += p
                      t.push(i)
                      t.push(l)
                      t.push(r)
                      const h = e.packHeader()
                      s.push(h)
                      value_0.size += h.length
                      u += p + h.length
                      f(n)
                    })
                  } else {
                    u += value_0.mainHeaderSize
                    value_0.offset = d
                    d = 0
                    const n = Buffer.alloc(u)
                    t.forEach(function (e) {
                      e.copy(n, d)
                      d += e.length
                    })
                    s.forEach(function (e) {
                      e.copy(n, d)
                      d += e.length
                    })
                    const r = value_0.toBinary()
                    i && i.copy(r, a.Constants.ENDHDR)
                    r.copy(n, d)
                    e(n)
                  }
                }
                f(n)
              } catch (s) {
                t(s)
              }
            },
          }
        )
      }
    },
    '0517': function (e, t) {
      e.exports = {
        functional: true,
        render(e, t) {
          const { _c: n, _v: r, data: o, children: data_0 = [] } = t,
            {
              class: s,
              staticClass: i,
              style: c,
              staticStyle: l,
              attrs: u = {},
              ...d
            } = o
          return n(
            'svg',
            {
              class: [s, i],
              style: [c, l],
              attrs: Object.assign(
                {
                  width: '14',
                  height: '14',
                  xmlns: 'http://www.w3.org/2000/svg',
                },
                u
              ),
              ...d,
            },
            data_0.concat([
              n('path', {
                attrs: {
                  d: 'M10.84 3.44h0C9.967 1.247 7.542.2 5.422 1.101a4.225 4.225 0 00-2.262 2.34h0C1.76 3.781.771 5.08.778 6.57h0C.78 8.346 2.17 9.785 3.888 9.787h1.187c.23 0 .415-.192.415-.429a.422.422 0 00-.415-.429H3.89h0c-1.26-.001-2.28-1.057-2.282-2.36h0c-.005-1.163.814-2.155 1.925-2.331l.247-.04.08-.245h0c.595-1.793 2.483-2.75 4.217-2.135a3.378 3.378 0 012.064 2.135l.081.245.247.04h0c1.111.176 1.93 1.168 1.924 2.331h0c-.001 1.303-1.022 2.358-2.28 2.36H8.85h0a.422.422 0 00-.415.43c0 .236.186.428.415.428h1.261c1.718-.002 3.11-1.441 3.111-3.218h0c.007-1.49-.98-2.788-2.383-3.13h0zm-2.054 7.286l-1.371 1.161V6.141h0A.422.422 0 007 5.712a.422.422 0 00-.415.43v5.745l-1.384-1.172h0a.405.405 0 00-.585.035.44.44 0 00.06.629l2.062 1.746h0c.153.13.373.13.526 0l2.048-1.735h0a.44.44 0 00.071-.603.406.406 0 00-.597-.06h0z',
                  fill: '#FF503F',
                  'fill-rule': 'nonzero',
                  stroke: '#FF503F',
                  'stroke-width': '.5',
                },
              }),
            ])
          )
        },
      }
    },
    '0770': function (e, t, n) { },
    '0a06a': function (e, t, n) {
      'use strict'
      n.d(t, 'g', function () {
        return o
      })
      n.d(t, 'j', function () {
        return a
      })
      n.d(t, 'k', function () {
        return s
      })
      n.d(t, 'i', function () {
        return i
      })
      n.d(t, 'c', function () {
        return c
      })
      n.d(t, 'b', function () {
        return l
      })
      n.d(t, 'a', function () {
        return u
      })
      n.d(t, 'f', function () {
        return d
      })
      n.d(t, 'h', function () {
        return f
      })
      n.d(t, 'd', function () {
        return p
      })
      n.d(t, 'e', function () {
        return h
      })
      n('b680')
      var r = n('2f5c'),
        o = function (e) {
          Object(r.a)('osta_login', { hw_user_id: ''.concat(e) })
        },
        a = function (check) {
          try {
            Object(r.a)('osta_update_new_version', {
              new_version: null === check || void 0 === check ? void 0 : check.newVersion,
              is_force_update: !(
                null === check ||
                void 0 === check ||
                !check.needForceUpgrade
              ),
            })
          } catch (t) {
            console.error('神策埋点报错:', t)
          }
        },
        s = function (e) {
          Object(r.a)('osta_update_skip', {
            new_version:
              (null === e || void 0 === e ? void 0 : e.newVersion) || '',
          })
        },
        i = function (e) {
          Object(r.a)('osta_update_install', {
            new_version: null === e || void 0 === e ? void 0 : e.newVersion,
          })
        },
        c = function (e) {
          Object(r.a)('osta_do_pre_test', { plan_id: ''.concat(e) })
        },
        l = function (e) {
          Object(r.a)('osta_do_homework', { plan_id: ''.concat(e) })
        },
        u = function (e) {
          Object(r.a)('osta_class_report', { plan_id: ''.concat(e) })
        },
        d = function (e) {
          Object(r.a)('osta_leraning_material', { plan_id: ''.concat(e) })
        },
        f = function (e) {
          try {
            Object(r.a)('osta_sign_in', {
              plan_id: ''.concat(e.planId),
              coins_count: e.coins,
              start_difference: new Date().getTime() - 1000 * e.time,
            })
          } catch (t) {
            console.error('神策埋点报错:', t)
          }
        },
        p = function (e, t, n) {
          var o =
            arguments.length > 3 && void 0 !== arguments[3] ? arguments[3] : 0
          try {
            Object(r.a)('osta_enter_classroom', {
              time_offset: o,
              plan_id: ''.concat(e.planId),
              class_type: 2 == e.subPlatformType ? 'small' : 'dual',
              class_id: ''.concat(e.classId),
              is_camera_ok: !t.camDetecting,
              is_mic_ok: !t.micDetecting,
              network_quality:
                0 === t.netDetecting
                  ? 'good'
                  : 1 === e.networkStatus
                    ? 'poor'
                    : 'unknown',
              courseware_localcache_exit: n.exit,
              courseware_download_size: n.exit ? 0 : +n.size.toFixed(2),
              courseware_download_time: n.exit
                ? 0
                : (n.endTime - n.startTime) / 1000,
              start_difference:
                new Date().getTime() + o - 1000 * n.courseStartTime,
            })
          } catch (a) {
            console.error('神策埋点报错:', a)
          }
        },
        h = function (e, t) {
          var n =
            arguments.length > 2 && void 0 !== arguments[2] ? arguments[2] : 0
          try {
            Object(r.a)('osta_enter_playback', {
              plan_id: ''.concat(e.planId),
              class_id: ''.concat(e.classId),
              courseware_localcache_exit: t.exit,
              courseware_download_size: t.exit ? 0 : +t.size.toFixed(2),
              courseware_download_time: t.exit
                ? 0
                : (t.endTime - t.startTime) / 1000,
              end_difference: new Date().getTime() + n - 1000 * t.courseEndTime,
            })
          } catch (o) {
            console.error('神策埋点报错:', o)
          }
        }
    },
    '0dc5': function (e, t, n) {
      const r = n('445e'),
        o = n('a32b'),
        a = n('eb3b'),
        s = n('02615'),
        i = (e, t) => ('boolean' === typeof e ? e : t),
        c = (e, t) => ('string' === typeof e ? e : t),
        l = {
          noSort: false,
          readEntries: false,
          method: r.Constants.NONE,
          fs: null,
        }
      e.exports = function (e, t) {
        let n = null
        const u = Object.assign(Object.create(null), l)
        e &&
          'object' === typeof e &&
          (e instanceof Uint8Array ||
            (Object.assign(u, e),
              (e = u.input ? u.input : void 0),
              u.input && delete u.input),
            Buffer.isBuffer(e) &&
            ((n = e), (u.method = r.Constants.BUFFER), (e = void 0)))
        Object.assign(u, t)
        const d = new r(u)
        if (e && 'string' === typeof e) {
          if (!d.fs.existsSync(e)) {
            throw new Error(r.Errors.INVALID_FILENAME)
          }
          u.method = r.Constants.FILE
          u.filename = e
          n = d.fs.readFileSync(e)
        }
        const f = new s(n, u),
          { canonical: p, sanitize: h } = r
        function m(e) {
          var t
          if (
            e &&
            f &&
            ('string' === typeof e && (t = f.getEntry(e)),
              'object' === typeof e &&
              'undefined' !== typeof e.entryName &&
              'undefined' !== typeof e.header &&
              (t = f.getEntry(e.entryName)),
              t)
          ) {
            return t
          }
          return null
        }
        function get_0(e) {
          const { join: t, normalize: n, sep: r } = o.posix
          return t('.', n(r + e.split('\\').join(r) + r))
        }
        return {
          readFile: function (e, t) {
            var n = m(e)
            return (n && n.getData(t)) || null
          },
          readFileAsync: function (e, t) {
            var fileRead0 = m(e)
            fileRead0 ? fileRead0.getDataAsync(t) : t(null, 'getEntry failed for:' + e)
          },
          readAsText: function (e, t) {
            var n = m(e)
            if (n) {
              var r = n.getData()
              if (r && r.length) {
                return r.toString(t || 'utf8')
              }
            }
            return ''
          },
          readAsTextAsync: function (e, t, n) {
            var r = m(e)
            r
              ? r.getDataAsync(function (e, r) {
                r
                  ? t(e, r)
                  : e && e.length
                    ? t(e.toString(n || 'utf8'))
                    : t('')
              })
              : t('')
          },
          deleteFile: function (e) {
            var t = m(e)
            t && f.deleteEntry(t.entryName)
          },
          addZipComment: function (e) {
            f.comment = e
          },
          getZipComment: function () {
            return f.comment || ''
          },
          addZipEntryComment: function (e, t) {
            var n = m(e)
            n && (n.comment = t)
          },
          getZipEntryComment: function (e) {
            var t = m(e)
            return (t && t.comment) || ''
          },
          updateFile: function (e, t) {
            var n = m(e)
            n && n.setData(t)
          },
          addLocalFile: function (e, t, n, o) {
            if (!d.fs.existsSync(e)) {
              throw new Error(r.Errors.FILE_NOT_FOUND.replace('%s', e))
            }
            {
              t = t ? get_0(t) : ''
              var a = e.split('\\').join('/').split('/').pop()
              t += n || a
              const r = d.fs.statSync(e)
              this.addFile(t, d.fs.readFileSync(e), o, r)
            }
          },
          addLocalFolder: function (e, t, n, a) {
            if (
              (n instanceof RegExp
                ? (n = (function (e) {
                  return function (t) {
                    return e.test(t)
                  }
                })(n))
                : 'function' !== typeof n &&
                (n = function () {
                  return true
                }),
                (t = t ? get_0(t) : ''),
                (e = o.normalize(e)),
                !d.fs.existsSync(e))
            ) {
              throw new Error(r.Errors.FILE_NOT_FOUND.replace('%s', e))
            }
            {
              const r = d.findFiles(e),
                s = this
              r.length &&
                r.forEach(function (r) {
                  var i = o.relative(e, r).split('\\').join('/')
                  if (n(i)) {
                    var c = d.fs.statSync(r)
                    c.isFile()
                      ? s.addFile(t + i, d.fs.readFileSync(r), '', a || c)
                      : s.addFile(t + i + '/', Buffer.alloc(0), '', a || c)
                  }
                })
            }
          },
          addLocalFolderAsync: function (e, t, n, a) {
            a instanceof RegExp
              ? (a = (function (e) {
                return function (t) {
                  return e.test(t)
                }
              })(a))
              : 'function' !== typeof a &&
              (a = function () {
                return true
              })
            n = n ? get_0(n) : ''
            e = o.normalize(e)
            var s = this
            d.fs.open(e, 'r', function (i) {
              if (i && 'ENOENT' === i.code) {
                t(void 0, r.Errors.FILE_NOT_FOUND.replace('%s', e))
              } else {
                if (i) {
                  t(void 0, i)
                } else {
                  var c = d.findFiles(e),
                    l = -1,
                    u = function () {
                      if (((l += 1), l < c.length)) {
                        var r = c[l],
                          i = o.relative(e, r).split('\\').join('/')
                        i = i
                          .normalize('NFD')
                          .replace(/[\u0300-\u036f]/g, '')
                          .replace(/[^\x20-\x7E]/g, '')
                        a(i)
                          ? d.fs.stat(r, function (e, o) {
                            e && t(void 0, e)
                            o.isFile()
                              ? d.fs.readFile(r, function (e, r) {
                                e
                                  ? t(void 0, e)
                                  : (s.addFile(n + i, r, '', o), u())
                              })
                              : (s.addFile(
                                n + i + '/',
                                Buffer.alloc(0),
                                '',
                                o
                              ),
                                u())
                          })
                          : process.nextTick(() => {
                            u()
                          })
                      } else {
                        t(true, void 0)
                      }
                    }
                  u()
                }
              }
            })
          },
          addLocalFolderPromise: function (e, t) {
            return new Promise((n, r) => {
              const { filter: o, zipPath: a } = Object.assign({}, t)
              this.addLocalFolderAsync(
                e,
                (e, t) => {
                  t && r(t)
                  e && n(this)
                },
                a,
                o
              )
            })
          },
          addFile: function (e, t, n, r) {
            let o = m(e)
            const s = null != o
            s || ((o = new a()), (o.entryName = e))
            o.comment = n || ''
            const i = 'object' === typeof r && r instanceof d.fs.Stats
            i && (o.header.time = r.mtime)
            var c = o.isDirectory ? 16 : 0
            let l = o.isDirectory ? 16384 : 32768
            l |= i
              ? 4095 & r.mode
              : 'number' === typeof r
                ? 4095 & r
                : o.isDirectory
                  ? 493
                  : 420
            c = (c | (l << 16)) >>> 0
            o.attr = c
            o.setData(t)
            s || f.setEntry(o)
          },
          getEntries: function () {
            return f ? f.entries : []
          },
          getEntry: function (e) {
            return m(e)
          },
          getEntryCount: function () {
            return f.getEntryCount()
          },
          forEach: function (e) {
            return f.forEach(e)
          },
          extractEntryTo: function (e, t, n, a, s, l) {
            a = i(a, false)
            s = i(s, false)
            n = i(n, true)
            l = c(l, c(s, void 0))
            var u = m(e)
            if (!u) {
              throw new Error(r.Errors.NO_ENTRY)
            }
            var g = p(u.entryName),
              w = h(t, l && !u.isDirectory ? l : n ? g : o.basename(g))
            if (u.isDirectory) {
              var E = f.getEntryChildren(u)
              return (
                E.forEach(function (e) {
                  if (e.isDirectory) {
                    return
                  }
                  var i = e.getData()
                  if (!i) {
                    throw new Error(r.Errors.CANT_EXTRACT_FILE)
                  }
                  var c = p(e.entryName),
                    l = h(t, n ? c : o.basename(c))
                  const u = s ? e.header.fileAttr : void 0
                  d.writeFileTo(l, i, a, u)
                }),
                true
              )
            }
            var I = u.getData()
            if (!I) {
              throw new Error(r.Errors.CANT_EXTRACT_FILE)
            }
            if (d.fs.existsSync(w) && !a) {
              throw new Error(r.Errors.CANT_OVERRIDE)
            }
            const y = s ? e.header.fileAttr : void 0
            return d.writeFileTo(w, I, a, y), true
          },
          test: function (e) {
            if (!f) {
              return false
            }
            for (var t in f.entries)
              try {
                if (t.isDirectory) {
                  continue
                }
                var n = f.entries[t].getData(e)
                if (!n) {
                  return false
                }
              } catch (r) {
                return false
              }
            return true
          },
          extractAllTo: function (e, t, n, o) {
            if (((t = i(t, false)), (o = c(n, o)), (n = i(n, false)), !f)) {
              throw new Error(r.Errors.NO_ZIP)
            }
            f.entries.forEach(function (a) {
              var s = h(e, p(a.entryName.toString()))
              if (a.isDirectory) {
                return void d.makeDir(s)
              }
              var i = a.getData(o)
              if (!i) {
                throw new Error(r.Errors.CANT_EXTRACT_FILE)
              }
              const c = n ? a.header.fileAttr : void 0
              d.writeFileTo(s, i, t, c)
              try {
                d.fs.utimesSync(s, a.header.time, a.header.time)
              } catch (l) {
                throw new Error(r.Errors.CANT_EXTRACT_FILE)
              }
            })
          },
          extractAllToAsync: function (e, t, n, a) {
            if (
              ((t = i(t, false)),
                'function' !== typeof n || a || (a = n),
                (n = i(n, false)),
                a ||
                (a = function (e) {
                  throw new Error(e)
                }),
                !f)
            ) {
              return void a(new Error(r.Errors.NO_ZIP))
            }
            e = o.resolve(e)
            const s = (t) => h(e, o.normalize(p(t.entryName.toString()))),
              c = (e, t) => new Error(e + ': "' + t + '"'),
              l = [],
              u = new Set()
            f.entries.forEach((e) => {
              e.isDirectory ? l.push(e) : u.add(e)
            })
            for (const r of l) {
              const e = s(r),
                t = n ? r.header.fileAttr : void 0
              try {
                d.makeDir(e)
                t && d.fs.chmodSync(e, t)
                d.fs.utimesSync(e, r.header.time, r.header.time)
              } catch (g) {
                a(c('Unable to create folder', e))
              }
            }
            const m = () => {
              0 === u.size && a()
            }
            for (const i of u.values()) {
              const s = o.normalize(p(i.entryName.toString())),
                l = h(e, s)
              i.getDataAsync(function (e, o) {
                if (o) {
                  a(new Error(o))
                } else {
                  if (e) {
                    const r = n ? i.header.fileAttr : void 0
                    d.writeFileToAsync(l, e, t, r, function (e) {
                      e
                        ? d.fs.utimes(
                          l,
                          i.header.time,
                          i.header.time,
                          function (e) {
                            e
                              ? a(c('Unable to set times', l))
                              : (u.delete(i), m())
                          }
                        )
                        : a(c('Unable to write file', l))
                    })
                  } else {
                    a(new Error(r.Errors.CANT_EXTRACT_FILE))
                  }
                }
              })
            }
            m()
          },
          writeZip: function (e, t) {
            if (
              (1 === arguments.length &&
                'function' === typeof e &&
                ((t = e), (e = '')),
                !e && u.filename && (e = u.filename),
                e)
            ) {
              var n = f.compressToBuffer()
              if (n) {
                var r = d.writeFileTo(e, n, true)
                'function' === typeof t && t(r ? null : new Error('failed'), '')
              }
            }
          },
          writeZipPromise: function (e, t) {
            const { overwrite: n, perm: r } = Object.assign(
              { overwrite: true },
              t
            )
            return new Promise((t, o) => {
              !e && u.filename && (e = u.filename)
              e || o('ADM-ZIP: ZIP File Name Missing')
              this.toBufferPromise().then((a) => {
                const s = (e) =>
                  e ? t(e) : o("ADM-ZIP: Wasn't able to write zip file")
                d.writeFileToAsync(e, a, n, r, s)
              }, o)
            })
          },
          toBufferPromise: function () {
            return new Promise((e, t) => {
              f.toAsyncBuffer(e, t)
            })
          },
          toBuffer: function (e, t, n, r) {
            return (
              (this.valueOf = 2),
              'function' === typeof e
                ? (f.toAsyncBuffer(e, t, n, r), null)
                : f.compressToBuffer()
            )
          },
        }
      }
    },
    '1d6f': function (e, t, n) {
      const r = n('7e8d').require(),
        o = n('a32b')
      r.existsSync = r.existsSync || o.existsSync
      e.exports = function (e) {
        var t = e || '',
          n = s(),
          a = null
        function s() {
          return {
            directory: false,
            readonly: false,
            hidden: false,
            executable: false,
            mtime: 0,
            atime: 0,
          }
        }
        return (
          t && r.existsSync(t)
            ? ((a = r.statSync(t)),
              (n.directory = a.isDirectory()),
              (n.mtime = a.mtime),
              (n.atime = a.atime),
              (n.executable = 0 !== (73 & a.mode)),
              (n.readonly = 0 === (128 & a.mode)),
              (n.hidden = '.' === o.basename(t)[0]))
            : console.warn('Invalid path: ' + t),
          {
            get directory() {
              return n.directory
            },
            get readOnly() {
              return n.readonly
            },
            get hidden() {
              return n.hidden
            },
            get mtime() {
              return n.mtime
            },
            get atime() {
              return n.atime
            },
            get executable() {
              return n.executable
            },
            decodeAttributes: function () { },
            encodeAttributes: function () { },
            toJSON: function () {
              return {
                path: t,
                isDirectory: n.directory,
                isReadOnly: n.readonly,
                isHidden: n.hidden,
                isExecutable: n.executable,
                mTime: n.mtime,
                aTime: n.atime,
              }
            },
            toString: function () {
              return JSON.stringify(this.toJSON(), null, '\t')
            },
          }
        )
      }
    },
    '24ba': function (e, t) {
      e.exports = {
        functional: true,
        render(e, t) {
          const { _c: n, _v: r, data: o, children: a = [] } = t,
            {
              class: s,
              staticClass: i,
              style: c,
              staticStyle: l,
              attrs: u = {},
              ...d
            } = o
          return n(
            'svg',
            {
              class: [s, i],
              style: [c, l],
              attrs: Object.assign(
                {
                  width: '18',
                  height: '18',
                  xmlns: 'http://www.w3.org/2000/svg',
                },
                u
              ),
              ...d,
            },
            a.concat([
              n('path', {
                attrs: {
                  d: 'M9 0a9 9 0 110 18A9 9 0 019 0zm0 12a1.125 1.125 0 100 2.25A1.125 1.125 0 009 12zm0-9a1.07 1.07 0 00-1.069 1.124l.282 5.627a.788.788 0 001.574 0l.282-5.627A1.07 1.07 0 009 3z',
                  fill: '#FF503F',
                  'fill-rule': 'evenodd',
                },
              }),
            ])
          )
        },
      }
    },
    '27b0': function (e, t, n) {
      var r = n('445e'),
        o = r.Constants
      e.exports = function () {
        var e = 20,
          t = 10,
          n = 0,
          a = 0,
          s = 0,
          i = 0,
          c = 0,
          l = 0,
          u = 0,
          d = 0,
          f = 0,
          p = 0,
          h = 0,
          m = 0,
          g = 0
        e |= r.isWin ? 2560 : 768
        n |= o.FLG_EFS
        var w = {}
        function E(e) {
          e = new Date(e)
          s =
            (((e.getFullYear() - 1980) & 127) << 25) |
            ((e.getMonth() + 1) << 21) |
            (e.getDate() << 16) |
            (e.getHours() << 11) |
            (e.getMinutes() << 5) |
            (e.getSeconds() >> 1)
        }
        return (
          E(+new Date()),
          {
            get made() {
              return e
            },
            set made(t) {
              e = t
            },
            get version() {
              return t
            },
            set version(e) {
              t = e
            },
            get flags() {
              return n
            },
            set flags(e) {
              n = e
            },
            get method() {
              return a
            },
            set method(e) {
              switch (e) {
                case o.STORED:
                  this.version = 10
                case o.DEFLATED:
                default:
                  this.version = 20
              }
              a = e
            },
            get time() {
              return new Date(
                1980 + ((s >> 25) & 127),
                ((s >> 21) & 15) - 1,
                (s >> 16) & 31,
                (s >> 11) & 31,
                (s >> 5) & 63,
                (31 & s) << 1
              )
            },
            set time(e) {
              E(e)
            },
            get crc() {
              return i
            },
            set crc(e) {
              i = Math.max(0, e) >>> 0
            },
            get compressedSize() {
              return c
            },
            set compressedSize(e) {
              c = Math.max(0, e) >>> 0
            },
            get size() {
              return l
            },
            set size(e) {
              l = Math.max(0, e) >>> 0
            },
            get fileNameLength() {
              return u
            },
            set fileNameLength(e) {
              u = e
            },
            get extraLength() {
              return d
            },
            set extraLength(e) {
              d = e
            },
            get commentLength() {
              return f
            },
            set commentLength(e) {
              f = e
            },
            get diskNumStart() {
              return p
            },
            set diskNumStart(e) {
              p = Math.max(0, e) >>> 0
            },
            get inAttr() {
              return h
            },
            set inAttr(e) {
              h = Math.max(0, e) >>> 0
            },
            get attr() {
              return m
            },
            set attr(e) {
              m = Math.max(0, e) >>> 0
            },
            get fileAttr() {
              return m ? (((m >>> 0) | 0) >> 16) & 4095 : 0
            },
            get offset() {
              return g
            },
            set offset(e) {
              g = Math.max(0, e) >>> 0
            },
            get encripted() {
              return 1 === (1 & n)
            },
            get entryHeaderSize() {
              return o.CENHDR + u + d + f
            },
            get realDataOffset() {
              return g + o.LOCHDR + w.fnameLen + w.extraLen
            },
            get dataHeader() {
              return w
            },
            loadDataHeaderFromBinary: function (e) {
              var t = e.slice(g, g + o.LOCHDR)
              if (t.readUInt32LE(0) !== o.LOCSIG) {
                throw new Error(r.Errors.INVALID_LOC)
              }
              w = {
                version: t.readUInt16LE(o.LOCVER),
                flags: t.readUInt16LE(o.LOCFLG),
                method: t.readUInt16LE(o.LOCHOW),
                time: t.readUInt32LE(o.LOCTIM),
                crc: t.readUInt32LE(o.LOCCRC),
                compressedSize: t.readUInt32LE(o.LOCSIZ),
                size: t.readUInt32LE(o.LOCLEN),
                fnameLen: t.readUInt16LE(o.LOCNAM),
                extraLen: t.readUInt16LE(o.LOCEXT),
              }
            },
            loadFromBinary: function (w) {
              if (w.length !== o.CENHDR || w.readUInt32LE(0) !== o.CENSIG) {
                throw new Error(r.Errors.INVALID_CEN)
              }
              e = w.readUInt16LE(o.CENVEM)
              t = w.readUInt16LE(o.CENVER)
              n = w.readUInt16LE(o.CENFLG)
              a = w.readUInt16LE(o.CENHOW)
              s = w.readUInt32LE(o.CENTIM)
              i = w.readUInt32LE(o.CENCRC)
              c = w.readUInt32LE(o.CENSIZ)
              l = w.readUInt32LE(o.CENLEN)
              u = w.readUInt16LE(o.CENNAM)
              d = w.readUInt16LE(o.CENEXT)
              f = w.readUInt16LE(o.CENCOM)
              p = w.readUInt16LE(o.CENDSK)
              h = w.readUInt16LE(o.CENATT)
              m = w.readUInt32LE(o.CENATX)
              g = w.readUInt32LE(o.CENOFF)
            },
            dataHeaderToBinary: function () {
              var e = Buffer.alloc(o.LOCHDR)
              return (
                e.writeUInt32LE(o.LOCSIG, 0),
                e.writeUInt16LE(t, o.LOCVER),
                e.writeUInt16LE(n, o.LOCFLG),
                e.writeUInt16LE(a, o.LOCHOW),
                e.writeUInt32LE(s, o.LOCTIM),
                e.writeUInt32LE(i, o.LOCCRC),
                e.writeUInt32LE(c, o.LOCSIZ),
                e.writeUInt32LE(l, o.LOCLEN),
                e.writeUInt16LE(u, o.LOCNAM),
                e.writeUInt16LE(d, o.LOCEXT),
                e
              )
            },
            entryHeaderToBinary: function () {
              var r = Buffer.alloc(o.CENHDR + u + d + f)
              return (
                r.writeUInt32LE(o.CENSIG, 0),
                r.writeUInt16LE(e, o.CENVEM),
                r.writeUInt16LE(t, o.CENVER),
                r.writeUInt16LE(n, o.CENFLG),
                r.writeUInt16LE(a, o.CENHOW),
                r.writeUInt32LE(s, o.CENTIM),
                r.writeUInt32LE(i, o.CENCRC),
                r.writeUInt32LE(c, o.CENSIZ),
                r.writeUInt32LE(l, o.CENLEN),
                r.writeUInt16LE(u, o.CENNAM),
                r.writeUInt16LE(d, o.CENEXT),
                r.writeUInt16LE(f, o.CENCOM),
                r.writeUInt16LE(p, o.CENDSK),
                r.writeUInt16LE(h, o.CENATT),
                r.writeUInt32LE(m, o.CENATX),
                r.writeUInt32LE(g, o.CENOFF),
                r.fill(0, o.CENHDR),
                r
              )
            },
            toJSON: function () {
              const s = function (e) {
                return e + ' bytes'
              }
              return {
                made: e,
                version: t,
                flags: n,
                method: r.methodToString(a),
                time: this.time,
                crc: '0x' + i.toString(16).toUpperCase(),
                compressedSize: s(c),
                size: s(l),
                fileNameLength: s(u),
                extraLength: s(d),
                commentLength: s(f),
                diskNumStart: p,
                inAttr: h,
                attr: m,
                offset: g,
                entryHeaderSize: s(o.CENHDR + u + d + f),
              }
            },
            toString: function () {
              return JSON.stringify(this.toJSON(), null, '\t')
            },
          }
        )
      }
    },
    '2af5': function (e, t, n) {
      'use strict'
      n('0770')
    },
    '2f5c': function (e, t, n) {
      'use strict'
      n.d(t, 'a', function () {
        return r
      })
      var r = function (e) {
        var t =
          arguments.length > 1 && void 0 !== arguments[1] ? arguments[1] : {}
        window.$sensors.track(e, t)
      }
    },
    '3aa1': function (e, t, n) {
      'use strict'
      var r = function () {
        var e = this,
          t = e._self._c
        return t(
          'div',
          { staticClass: 'lottie-emoticon-icon' },
          [
            t('lottie-player', {
              ref: 'emoji',
              style: e.emoticonStyle,
              attrs: {
                mode: 'normal',
                autoplay: '',
                loop: e.loopLottie,
                src: e.lottieUrl,
              },
              on: { complete: e.onLottieComplete },
            }),
          ],
          1
        )
      },
        o = [],
        a = (n('a9e3'), n('a717'), n('e39c')),
        s = {
          props: {
            type: {
              type: Number,
              default: 2,
            },
            width: {
              type: Number,
              default: 70,
            },
            height: {
              type: Number,
              default: 70,
            },
            lottieUrl: {
              type: String,
              default: '',
            },
            loopLottie: {
              type: Boolean,
              default: false,
            },
          },
          computed: {
            emoticonStyle: function () {
              return (
                console.info(
                  '对象函数 emoticonStyle,filePath:renderer/components/Classroom/SmallClass/Common/LottieEmoticon/index.vue'
                ),
                {
                  width: ''.concat(Object(a.v)(this.width)),
                  height: ''.concat(Object(a.v)(this.height)),
                }
              )
            },
          },
          methods: {
            onLottieComplete: function () {
              console.info(
                '对象函数 onLottieComplete,filePath:renderer/components/Classroom/SmallClass/Common/LottieEmoticon/index.vue'
              )
              this.$emit('animationComplete')
            },
          },
          watch: {
            lottieUrl: function (e) {
              var t = this
              e &&
                this.$nextTick(function () {
                  return t.$refs.emoji.load(e)
                })
            },
          },
        },
        i = s,
        c = n('2877'),
        l = Object(c.a)(i, r, o, false, null, null, null)
      t.a = l.exports
    },
    '445e': function (e, t, n) {
      e.exports = n('ff7a')
      e.exports.Constants = n('566b7')
      e.exports.Errors = n('5a45')
      e.exports.FileAttr = n('1d6f')
    },
    5010: function (e, t, n) { },
    '566b7': function (e, t) {
      e.exports = {
        LOCHDR: 30,
        LOCSIG: 67324752,
        LOCVER: 4,
        LOCFLG: 6,
        LOCHOW: 8,
        LOCTIM: 10,
        LOCCRC: 14,
        LOCSIZ: 18,
        LOCLEN: 22,
        LOCNAM: 26,
        LOCEXT: 28,
        EXTSIG: 134695760,
        EXTHDR: 16,
        EXTCRC: 4,
        EXTSIZ: 8,
        EXTLEN: 12,
        CENHDR: 46,
        CENSIG: 33639248,
        CENVEM: 4,
        CENVER: 6,
        CENFLG: 8,
        CENHOW: 10,
        CENTIM: 12,
        CENCRC: 16,
        CENSIZ: 20,
        CENLEN: 24,
        CENNAM: 28,
        CENEXT: 30,
        CENCOM: 32,
        CENDSK: 34,
        CENATT: 36,
        CENATX: 38,
        CENOFF: 42,
        ENDHDR: 22,
        ENDSIG: 101010256,
        ENDSUB: 8,
        ENDTOT: 10,
        ENDSIZ: 12,
        ENDOFF: 16,
        ENDCOM: 20,
        END64HDR: 20,
        END64SIG: 117853008,
        END64START: 4,
        END64OFF: 8,
        END64NUMDISKS: 16,
        ZIP64SIG: 101075792,
        ZIP64HDR: 56,
        ZIP64LEAD: 12,
        ZIP64SIZE: 4,
        ZIP64VEM: 12,
        ZIP64VER: 14,
        ZIP64DSK: 16,
        ZIP64DSKDIR: 20,
        ZIP64SUB: 24,
        ZIP64TOT: 32,
        ZIP64SIZB: 40,
        ZIP64OFF: 48,
        ZIP64EXTRA: 56,
        STORED: 0,
        SHRUNK: 1,
        REDUCED1: 2,
        REDUCED2: 3,
        REDUCED3: 4,
        REDUCED4: 5,
        IMPLODED: 6,
        DEFLATED: 8,
        ENHANCED_DEFLATED: 9,
        PKWARE: 10,
        BZIP2: 12,
        LZMA: 14,
        IBM_TERSE: 18,
        IBM_LZ77: 19,
        AES_ENCRYPT: 99,
        FLG_ENC: 1,
        FLG_COMP1: 2,
        FLG_COMP2: 4,
        FLG_DESC: 8,
        FLG_ENH: 16,
        FLG_PATCH: 32,
        FLG_STR: 64,
        FLG_EFS: 2048,
        FLG_MSK: 4096,
        FILE: 2,
        BUFFER: 1,
        NONE: 0,
        EF_ID: 0,
        EF_SIZE: 2,
        ID_ZIP64: 1,
        ID_AVINFO: 7,
        ID_PFS: 8,
        ID_OS2: 9,
        ID_NTFS: 10,
        ID_OPENVMS: 12,
        ID_UNIX: 13,
        ID_FORK: 14,
        ID_PATCH: 15,
        ID_X509_PKCS7: 20,
        ID_X509_CERTID_F: 21,
        ID_X509_CERTID_C: 22,
        ID_STRONGENC: 23,
        ID_RECORD_MGT: 24,
        ID_X509_PKCS7_RL: 25,
        ID_IBM1: 101,
        ID_IBM2: 102,
        ID_POSZIP: 18064,
        EF_ZIP64_OR_32: 4294967295,
        EF_ZIP64_OR_16: 65535,
        EF_ZIP64_SUNCOMP: 0,
        EF_ZIP64_SCOMP: 8,
        EF_ZIP64_RHO: 16,
        EF_ZIP64_DSN: 24,
      }
    },
    '583f': function (e, t, n) {
      e.exports = function (e) {
        var t = n('14c2'),
          r = { chunkSize: 1024 * (parseInt(e.length / 1024) + 1) }
        return {
          deflate: function () {
            return t.deflateRawSync(e, r)
          },
          deflateAsync: function (n) {
            var o = t.createDeflateRaw(r),
              a = [],
              s = 0
            o.on('data', function (e) {
              a.push(e)
              s += e.length
            })
            o.on('end', function () {
              var e = Buffer.alloc(s),
                t = 0
              e.fill(0)
              for (var r = 0; r < a.length; r++) {
                var o = a[r]
                o.copy(e, t)
                t += o.length
              }
              n && n(e)
            })
            o.end(e)
          },
        }
      }
    },
    '5a20': function (e, t, n) {
      t.EntryHeader = n('27b0')
      t.MainHeader = n('e634')
    },
    '5a45': function (e, t) {
      e.exports = {
        INVALID_LOC: 'Invalid LOC header (bad signature)',
        INVALID_CEN: 'Invalid CEN header (bad signature)',
        INVALID_END: 'Invalid END header (bad signature)',
        NO_DATA: 'Nothing to decompress',
        BAD_CRC: 'CRC32 checksum failed',
        FILE_IN_THE_WAY: 'There is a file in the way: %s',
        UNKNOWN_METHOD: 'Invalid/unsupported compression method',
        AVAIL_DATA: 'inflate::Available inflate data did not terminate',
        INVALID_DISTANCE:
          'inflate::Invalid literal/length or distance code in fixed or dynamic block',
        TO_MANY_CODES:
          'inflate::Dynamic block code description: too many length or distance codes',
        INVALID_REPEAT_LEN:
          'inflate::Dynamic block code description: repeat more than specified lengths',
        INVALID_REPEAT_FIRST:
          'inflate::Dynamic block code description: repeat lengths with no first length',
        INCOMPLETE_CODES:
          'inflate::Dynamic block code description: code lengths codes incomplete',
        INVALID_DYN_DISTANCE:
          'inflate::Dynamic block code description: invalid distance code lengths',
        INVALID_CODES_LEN:
          'inflate::Dynamic block code description: invalid literal/length code lengths',
        INVALID_STORE_BLOCK:
          "inflate::Stored block length did not match one's complement",
        INVALID_BLOCK_TYPE: 'inflate::Invalid block type (type == 3)',
        CANT_EXTRACT_FILE: 'Could not extract the file',
        CANT_OVERRIDE: 'Target file already exists',
        NO_ZIP: 'No zip file was loaded',
        NO_ENTRY: "Entry doesn't exist",
        DIRECTORY_CONTENT_ERROR: 'A directory cannot have content',
        FILE_NOT_FOUND: 'File not found: %s',
        NOT_IMPLEMENTED: 'Not implemented',
        INVALID_FILENAME: 'Invalid filename',
        INVALID_FORMAT:
          'Invalid or unsupported zip format. No END header found',
      }
    },
    '6e1f': function (e, t) {
      e.exports = {
        functional: true,
        render(e, t) {
          const { _c: n, _v: r, data: o, children: a = [] } = t,
            {
              class: s,
              staticClass: i,
              style: c,
              staticStyle: l,
              attrs: u = {},
              ...d
            } = o
          return n(
            'svg',
            {
              class: [s, i],
              style: [c, l],
              attrs: Object.assign(
                {
                  width: '18',
                  height: '18',
                  xmlns: 'http://www.w3.org/2000/svg',
                },
                u
              ),
              ...d,
            },
            a.concat([
              n('path', {
                attrs: {
                  d: 'M9 0a9 9 0 109 9 9 9 0 00-9-9zm4.314 6.62l-5.197 5.727a.714.714 0 01-1.125-.062L4.635 9.034a.714.714 0 01.113-.968l.208-.191a.714.714 0 01.984.05l1.519 1.581a.197.197 0 00.27 0l4.595-3.937a.714.714 0 01.996 1.024l-.006.028z',
                  fill: '#02CA8A',
                  'fill-rule': 'nonzero',
                },
              }),
            ])
          )
        },
      }
    },
    7582: function (e, t, n) {
      'use strict'
      n.r(t)
      var r = function () {
        var e = this,
          t = e._self._c
        return t(
          'div',
          {
            staticClass: 'ready-class',
            attrs: {
              id: 'ready-class',
              'data-log': '回放准备页',
            },
          },
          [t('Toolbar'), t('ReadyClass')],
          1
        )
      },
        o = [],
        a = n('dfa8'),
        s = function () {
          var e = this,
            t = e._self._c
          return t('div', { attrs: { 'data-log': '回放课前准备页' } }, [
            t(
              'div',
              { staticClass: 'playback-class-content-wrapper' },
              [
                t('Header', { attrs: { 'back-url': e.backUrl } }),
                t(
                  'div',
                  { staticClass: 'playback-class-content' },
                  [
                    t('CoursewareDownloading', {
                      staticClass: 'content-item',
                      attrs: { 'back-url': e.backUrl },
                      on: { completeDownload: e.completeDownload },
                    }),
                  ],
                  1
                ),
              ],
              1
            ),
          ])
        },
        i = [],
        c = n('c7eb'),
        l = n('1da1'),
        u = n('5530'),
        d =
          (n('ac1f'),
            n('5319'),
            function () {
              var e = this,
                t = e._self._c
              return t(
                'div',
                { staticClass: 'courseware-downloading' },
                [
                  e.loading
                    ? [t('Loading', { attrs: { 'margin-top': '300px' } })]
                    : e.vodAddress
                      ? [
                        t(
                          'div',
                          { staticClass: 'courseware-downloading-header' },
                          [
                            t('LottieEmoticon', {
                              attrs: {
                                lottieUrl: e.lottieUrl,
                                width: 140,
                                height: 130,
                                loopLottie: true,
                              },
                            }),
                          ],
                          1
                        ),
                        t(
                          'div',
                          { staticClass: 'courseware-downloading-status' },
                          [
                            t('a-progress', {
                              attrs: {
                                'stroke-color': {
                                  '0%': '#ffd518',
                                  '100%': '#ffaa0a',
                                },
                                showInfo: false,
                                strokeLinecap: e.square,
                                percent: e.percent,
                              },
                            }),
                            'exists' == e.state || 'complete' == e.state
                              ? t('div', { staticClass: 'tips' }, [
                                e._v(
                                  ' ' +
                                  e._s(
                                    e.$t('prepareClass.coursewareDownload')
                                  ) +
                                  ' '
                                ),
                              ])
                              : 'progress' == e.state || 'start' == e.state
                                ? t('div', { staticClass: 'tips' }, [
                                  e._v(' ' + e._s(e.downloadTip) + ' '),
                                ])
                                : t(
                                  'div',
                                  { staticClass: 'failed tips' },
                                  [
                                    t('p', { staticClass: 'tip-desc' }, [
                                      e._v(
                                        e._s(
                                          e.$t(
                                            'prepareClass.coursewareDownloadWeekTitle'
                                          )
                                        )
                                      ),
                                    ]),
                                    t(
                                      'a-button',
                                      {
                                        staticClass: 'btn redown-btn',
                                        attrs: {
                                          type: 'primary',
                                          shape: 'round',
                                          size: 'large',
                                          loading: e.loading,
                                        },
                                        on: { click: e.reDownload },
                                      },
                                      [
                                        e._v(
                                          ' ' +
                                          e._s(
                                            e.$t('prepareClass.redownload')
                                          ) +
                                          ' '
                                        ),
                                      ]
                                    ),
                                  ],
                                  1
                                ),
                          ],
                          1
                        ),
                      ]
                      : [
                        t(
                          'div',
                          { staticClass: 'courseware-downloading-header' },
                          [
                            e.vodAddress
                              ? t('LottieEmoticon', {
                                attrs: {
                                  lottieUrl: e.lottieUrl,
                                  width: 140,
                                  height: 130,
                                  loopLottie: true,
                                },
                              })
                              : t('span', { staticClass: 'no-address' }),
                          ],
                          1
                        ),
                        t(
                          'div',
                          { staticClass: 'error-info' },
                          [
                            t('p', { staticClass: 'error-desc' }, [
                              e._v(e._s(e.$t('prepareClass.playbackError'))),
                            ]),
                            t(
                              'a-button',
                              {
                                staticClass: 'btn back-btn',
                                attrs: {
                                  type: 'primary',
                                  shape: 'round',
                                  size: 'large',
                                  loading: e.loading,
                                },
                                on: { click: e.back },
                              },
                              [e._v(' ' + e._s(e.$t('common.back')) + ' ')]
                            ),
                          ],
                          1
                        ),
                      ],
                ],
                2
              )
            }),
        f = [],
        p = (n('a15b'), n('d81d'), n('99af'), n('14d9'), n('0517')),
        h = n.n(p),
        m = n('24ba'),
        g = n.n(m),
        w = n('6e1f'),
        E = n.n(w),
        I = n('2103'),
        y = n('a5bc'),
        C = n('d0db'),
        v = n('bd12'),
        D = n('3aa1'),
        b = n('e39c'),
        L = n('bc8a'),
        S = n('2b6b'),
        _ = n('0dc5'),
        O = n('83ef'),
        N = {
          props: {
            backUrl: {
              default: '',
              type: String,
            },
          },
          data: function () {
            return {
              loading: true,
              state: 'start',
              baseZipUrl: '',
              baseZipMd5: '',
              IconDownloadSvg: h.a,
              IconFailed: g.a,
              IconSuccess: E.a,
              coursewareInfo: null,
              dataInfo: {},
              currentDownIndex: 0,
              mainInfoUrl: '',
              needDownloadFileCount: 0,
              tempPath: '',
              percent: '0',
              receivedSize: '0M',
              coursewareReceivedSize: '0M',
              dataInfoReceivedSize: '0M',
              mainInfoReceivedSize: '0M',
              currentSpeed: 0,
              coursewareSpeed: '0M/S',
              dataInfoSpeed: '0M/S',
              mainInfoSpeed: '0M/S',
              totalSize: '0M',
              coursewareTotalSize: '0M',
              dataInfoTotalSize: '0M',
              mainInfoTotalSize: '0M',
              commonCoursewareReceivedSize: '0M',
              commonCoursewareSpeed: '0KB/S',
              commonCoursewareTotalSize: '0M',
              lottieUrl: '/lottiefiles/readyClass/playBack_data.json',
              vodAddress: null,
              isOffline: false,
              courseWarePackages: {},
              planId: null,
              coursewareSensorData: {
                exit: false,
                size: 0,
                startTime: new Date().getTime(),
                endTime: new Date().getTime(),
                courseEndTime: 0,
              },
            }
          },
          components: {
            LottieEmoticon: D.a,
            Loading: v.a,
          },
          computed: {
            speed: function () {
              return (
                console.info(
                  '对象函数 speed,filePath:renderer/components/ReadyClass/DownloadList/index.vue'
                ),
                this.currentSpeed + 'M/S'
              )
            },
            downloadTip: function () {
              var e = this
              return (
                console.info(
                  '对象函数 downloadTip,filePath:renderer/components/ReadyClass/DownloadList/index.vue'
                ),
                this.$t('prepareClass.coursewareDownloading', {
                  speed: this.speed,
                  minutes: (function () {
                    try {
                      var t =
                        Object(b.l)(e.coursewareReceivedSize) +
                        Object(b.l)(e.dataInfoReceivedSize) +
                        Object(b.l)(e.mainInfoReceivedSize) +
                        Object(b.l)(e.commonCoursewareReceivedSize),
                        n =
                          Object(b.l)(e.coursewareTotalSize) +
                          Object(b.l)(e.dataInfoTotalSize) +
                          Object(b.l)(e.mainInfoTotalSize) +
                          Object(b.l)(e.commonCoursewareTotalSize)
                      if (
                        ((e.currentSpeed = Math.max(
                          Object(b.n)(e.coursewareSpeed),
                          Object(b.n)(e.dataInfoSpeed),
                          Object(b.n)(e.mainInfoSpeed),
                          Object(b.n)(e.commonCoursewareSpeed)
                        )),
                          0 !== n && (e.percent = (100 * t) / n),
                          (e.coursewareSensorData.size = 1024 * n),
                          0 == e.currentSpeed)
                      ) {
                        return (
                          console.info(
                            'if(_this.currentSpeed == 0)为true触发return,path: /renderer/components/ReadyClass/DownloadList/index.vue'
                          ),
                          e.$t('prepareClass.coursewareDownloadingSlow')
                        )
                      }
                      var r = Math.ceil((n - t) / e.currentSpeed)
                      return r < 60
                        ? (console.info(
                          'if(times < 60)为true触发return,path: /renderer/components/ReadyClass/DownloadList/index.vue'
                        ),
                          r + e.$t('prepareClass.second'))
                        : r >= 60
                          ? (console.info(
                            'if(times >= 60)为true触发return,path: /renderer/components/ReadyClass/DownloadList/index.vue'
                          ),
                            Math.floor(r / 60) +
                            e.$t('prepareClass.minute') +
                            (r % 60) +
                            e.$t('prepareClass.second'))
                          : (console.info(
                            'if(times >= 60)为false,触发return,path: /renderer/components/ReadyClass/DownloadList/index.vue'
                          ),
                            e.$t('prepareClass.coursewareDownloadingSlow'))
                    } catch (o) {
                      return (
                        console.error(
                          e.$t('prepareClass.coursewareDownloadingSlow'),
                          o
                        ),
                        e.$t('prepareClass.coursewareDownloadingSlow')
                      )
                    }
                  })(),
                })
              )
            },
          },
          watch: {
            state: function (e) {
              ; ('complete' !== e && 'exists' !== e) ||
                !this.vodAddress ||
                ((this.coursewareSensorData.endTime = new Date().getTime()),
                  this.$emit('completeDownload', this.coursewareSensorData))
              'fail' != e || this.isOffline || this.sensorsTrack('fail')
            },
            currentDownIndex: function (e) {
              e === this.needDownloadFileCount &&
                ((this.state = 'complete'),
                  (this.percent = 100),
                  this.sensorsTrack('success'))
            },
          },
          methods: {
            sensorsTrack: function (e) {
              this.$sensors.track('coursewareDownload', {
                planId: this.planId,
                downloadResult: e,
                plan_mode: '回放',
              })
            },
            back: function () {
              console.info(
                '对象函数 back,filePath:renderer/components/ReadyClass/DownloadList/index.vue'
              )
              this.$router.push({ path: this.backUrl })
            },
            testOfflineStatus: function () {
              var e = this
              return Object(l.a)(
                Object(c.a)().mark(function t() {
                  return Object(c.a)().wrap(function (t) {
                    while (1) {
                      switch ((t.prev = t.next)) {
                        case 0:
                          console.info(
                            '对象函数 testOfflineStatus,filePath:renderer/components/ReadyClass/DownloadList/index.vue'
                          ),
                            window.addEventListener('offline', function () {
                              console.info(
                                '箭头函数 监听 offline,filePath:renderer/components/ReadyClass/DownloadList/index.vue'
                              )
                              'complete' !== e.state &&
                                'exists' !== e.state &&
                                (e.state = 'fail')
                              e.isOffline = true
                            })
                        case 2:
                        case 'end':
                          return t.stop()
                      }
                    }
                  }, t)
                })
              )()
            },
            testOnlineStatus: function () {
              var e = this
              return Object(l.a)(
                Object(c.a)().mark(function t() {
                  return Object(c.a)().wrap(function (t) {
                    while (1) {
                      switch ((t.prev = t.next)) {
                        case 0:
                          console.info(
                            '对象函数 testOnlineStatus,filePath:renderer/components/ReadyClass/DownloadList/index.vue'
                          ),
                            window.addEventListener('online', function () {
                              console.info(
                                '箭头函数 监听 online,filePath:renderer/components/ReadyClass/DownloadList/index.vue'
                              )
                              e.isOffline = false
                            })
                        case 2:
                        case 'end':
                          return t.stop()
                      }
                    }
                  }, t)
                })
              )()
            },
            reDownload: function () {
              var e = this
              return Object(l.a)(
                Object(c.a)().mark(function t() {
                  return Object(c.a)().wrap(function (t) {
                    while (1) {
                      switch ((t.prev = t.next)) {
                        case 0:
                          console.info(
                            '对象函数 reDownload,filePath:renderer/components/ReadyClass/DownloadList/index.vue'
                          ),
                            (e.currentDownIndex = 0),
                            (e.currentSpeed = 0),
                            e.startDown()
                        case 4:
                        case 'end':
                          return t.stop()
                      }
                    }
                  }, t)
                })
              )()
            },
            getCommonCourseware: function () {
              var e = this
              return Object(l.a)(
                Object(c.a)().mark(function t() {
                  var n, r
                  return Object(c.a)().wrap(function (t) {
                    while (1) {
                      switch ((t.prev = t.next)) {
                        case 0:
                          return (
                            console.info(
                              '对象函数 getCommonCourseware,filePath:renderer/components/ReadyClass/DownloadList/index.vue'
                            ),
                            (t.next = 3),
                            Object(L.e)().catch(function (t) {
                              return (
                                console.info(
                                  '箭头函数 initConfigApi的catch(error)',
                                  t,
                                  'filePath:renderer/components/ReadyClass/DownloadList/index.vue'
                                ),
                                e.sendLogger(
                                  '回放课前准备页-获取基础包地址失败',
                                  { error: t },
                                  'error'
                                ),
                                t || {}
                              )
                            })
                          )
                        case 3:
                          if (((n = t.sent), n && 0 == n.code)) {
                            t.next = 9
                            break
                          }
                          return (
                            console.info(
                              'if(!res || res.code != 0)为true触发return,path: /renderer/components/ReadyClass/DownloadList/index.vue'
                            ),
                            (e.state = 'fail'),
                            e.sendLogger(
                              '回放课前准备页-获取基础包地址失败',
                              { res: n },
                              'error'
                            ),
                            t.abrupt('return')
                          )
                        case 9:
                          ; (r = n.data || {}),
                            (e.courseWarePackages =
                              r.courseWarePackages &&
                                r.courseWarePackages.length
                                ? r.courseWarePackages[1]
                                : {}),
                            e.courseWarePackages,
                            e.courseWarePackages.url &&
                            (e.needDownloadFileCount += 1)
                        case 13:
                        case 'end':
                          return t.stop()
                      }
                    }
                  }, t)
                })
              )()
            },
            getDataInfo: function () {
              var e = this
              return Object(l.a)(
                Object(c.a)().mark(function t() {
                  var n, r, o, a, s, i, l, u, d, f
                  return Object(c.a)().wrap(
                    function (t) {
                      while (1) {
                        switch ((t.prev = t.next)) {
                          case 0:
                            return (
                              console.info(
                                '对象函数 getDataInfo,filePath:renderer/components/ReadyClass/DownloadList/index.vue'
                              ),
                              (t.prev = 1),
                              (t.next = 4),
                              Object(y.c)({ planId: 1 * e.planId }).catch(
                                function (t) {
                                  return (
                                    console.info(
                                      '箭头函数 queryNewPlaybackInfo的catch(error)',
                                      t,
                                      'filePath:renderer/components/ReadyClass/DownloadList/index.vue'
                                    ),
                                    e.sendLogger(
                                      '回放课前准备页-获取数据地址失败',
                                      {
                                        error: t,
                                        planId: e.planId,
                                      },
                                      'error'
                                    ),
                                    console.error('回放获取数据失败', t),
                                    t || {}
                                  )
                                }
                              )
                            )
                          case 4:
                            if (((f = t.sent), 0 === f.code)) {
                              t.next = 10
                              break
                            }
                            return (
                              console.info(
                                'if(res.code !== 0)为true触发return,path: /renderer/components/ReadyClass/DownloadList/index.vue'
                              ),
                              e.sendLogger(
                                '回放课前准备页-获取数据地址失败',
                                {
                                  res: f,
                                  planId: e.planId,
                                },
                                'error'
                              ),
                              console.error('回放获取数据失败', f),
                              t.abrupt('return')
                            )
                          case 10:
                            ; (e.coursewareSensorData.courseEndTime =
                              f.data.endTime),
                              e.$store.dispatch(
                                'playback/setMetadataAvailable',
                                f.data.metadataAvailable
                              ),
                              Object(S.setTimeOffset)(
                                1000 * f.data.timestamp - new Date().getTime()
                              ),
                              e.$store.dispatch(
                                'common/setTimeOffset',
                                f.data.timestamp
                              ),
                              null !== (n = f.data) &&
                              void 0 !== n &&
                              null !== (r = n.graffiti) &&
                              void 0 !== r &&
                              r.url &&
                              ((e.dataInfo = f.data.graffiti),
                                (e.needDownloadFileCount += 1),
                                (e.dataInfoTotalSize = e.dataInfo.size + 'B')),
                              null !== (o = f.data) &&
                              void 0 !== o &&
                              null !== (a = o.metadata) &&
                              void 0 !== a &&
                              a.url &&
                              ((e.mainInfoUrl = f.data.metadata.url),
                                (e.needDownloadFileCount += 1),
                                (e.mainInfoTotalSize =
                                  f.data.metadata.size + 'B')),
                              null !== (s = f.data) &&
                              void 0 !== s &&
                              null !== (i = s.courseware) &&
                              void 0 !== i &&
                              i.baseZipUrl &&
                              ((e.coursewareInfo = f.data.courseware),
                                (e.needDownloadFileCount += 1),
                                (e.coursewareTotalSize =
                                  e.coursewareInfo.baseZipSize + 'B')),
                              null !== (l = f.data) &&
                              void 0 !== l &&
                              null !== (u = l.vodAddress) &&
                              void 0 !== u &&
                              null !== (d = u.list) &&
                              void 0 !== d &&
                              d.length &&
                              (e.vodAddress = f.data.vodAddress),
                              (e.loading = false),
                              (t.next = 24)
                            break
                          case 21:
                            ; (t.prev = 21),
                              (t.t0 = t.catch(1)),
                              console.error('回放课前准备页-获取数据地址失败', {
                                error: t.t0,
                                planId: e.planId,
                              })
                          case 24:
                          case 'end':
                            return t.stop()
                        }
                      }
                    },
                    t,
                    null,
                    [[1, 21]]
                  )
                })
              )()
            },
            downloadCourseware: function () {
              var e = this
              if (
                (console.info(
                  '对象函数 downloadCourseware,filePath:renderer/components/ReadyClass/DownloadList/index.vue'
                ),
                  this.sendLogger('回放课前准备页-课件下载', {
                    coursewareInfo: this.coursewareInfo,
                  }),
                  this.coursewareInfo)
              ) {
                this.sendLogger('回放课前准备页-课件下载', {
                  planId: this.planId,
                  url: this.coursewareInfo.baseZipUrl,
                  packageMd5: this.coursewareInfo.baseZipMd5,
                  coursewareId: this.coursewareInfo.id,
                  packageSize: this.coursewareInfo.baseZipSize,
                })
                var t = {
                  planId: this.planId,
                  url: this.coursewareInfo.baseZipUrl,
                  packageMd5: this.coursewareInfo.baseZipMd5,
                  coursewareId: this.coursewareInfo.id,
                  packageSize: this.coursewareInfo.baseZipSize,
                }
                I.a.downloadCourseware({
                  fileURL: this.coursewareInfo.baseZipUrl,
                  fileMD5: this.coursewareInfo.baseZipMd5,
                  retry: 2,
                  timeout: 10000,
                  start: function (t) {
                    e.sendLogger(
                      '回放课前准备页-课件下载',
                      Object(u.a)(
                        Object(u.a)({}, t),
                        {},
                        { url: e.coursewareInfo.baseZipUrl }
                      )
                    )
                  },
                  progress: function (t) {
                    e.coursewareSpeed = t.speed.replace('NaN', '0')
                    e.coursewareReceivedSize = t.receivedSize
                    e.coursewareTotalSize = t.totalSize
                    e.sendLogger(
                      '回放课前准备页-课件下载进度',
                      Object(u.a)(
                        Object(u.a)({}, t),
                        {},
                        { url: e.coursewareInfo.baseZipUrl }
                      )
                    )
                  },
                  complete: function (n) {
                    e.currentDownIndex++
                    e.$sensors.track
                    e.$sensors.track(
                      'pc_courseware_download',
                      Object(u.a)(
                        Object(u.a)({}, t),
                        {},
                        {
                          statusDesc: 'success',
                          downloadPackageMd5: n.MD5 || '',
                          downloadCost: parseInt(n.uptime / 1000),
                        }
                      )
                    )
                    e.sendLogger(
                      '回放课前准备页-课件下载完成',
                      Object(u.a)(
                        Object(u.a)({}, n),
                        {},
                        { url: e.coursewareInfo.baseZipUrl }
                      )
                    )
                  },
                  fail: function (n) {
                    e.state = 'fail'
                    e.sendLogger(
                      '回放课前准备页-下载课件失败',
                      Object(u.a)(Object(u.a)({}, t), {}, { error: n }),
                      'error'
                    )
                    e.$sensors.track(
                      'pc_courseware_download',
                      Object(u.a)(
                        Object(u.a)({}, t),
                        {},
                        {
                          statusDesc: 'fail',
                          downloadCost: parseInt(n.uptime / 1000),
                          downloadPackageMd5: n.MD5 || '',
                        }
                      )
                    )
                  },
                  exists: function (t) {
                    e.coursewareSensorData.exit = true
                    e.$electron.remote.app.getPath('userData')
                    e.currentDownIndex++
                    e.sendLogger(
                      '回放课前准备页-课件下载已存在',
                      Object(u.a)(
                        Object(u.a)({}, t),
                        {},
                        { url: e.coursewareInfo.baseZipUrl }
                      )
                    )
                  },
                  extract: function (t) {
                    e.sendLogger(
                      '回放课前准备页-课件下载解压回调',
                      Object(u.a)(
                        Object(u.a)({}, t),
                        {},
                        { url: e.coursewareInfo.baseZipUrl }
                      )
                    )
                  },
                })
              } else {
                console.info(
                  'if(!this.coursewareInfo)为true触发return,path: /renderer/components/ReadyClass/DownloadList/index.vue'
                )
              }
            },
            downloadDataInfo: function () {
              var e = this
              console.info(
                '对象函数 downloadDataInfo,filePath:renderer/components/ReadyClass/DownloadList/index.vue'
              )
              this.dataInfo.url
                ? (this.dataInfo,
                  this.sendLogger('回放课前准备页-涂鸦数据下载', {
                    dataInfoUrl: this.dataInfo.url,
                  }),
                  I.a.downloadFile({
                    fileURL: this.dataInfo.url.split('?')[0],
                    fileMD5: this.dataInfo.md5,
                    savePath: ''.concat(
                      this.$electron.remote.app.getPath('userData'),
                      '/playback'
                    ),
                    start: function (t) {
                      e.sendLogger(
                        '回放课前准备页-涂鸦数据开始下载',
                        Object(u.a)(
                          Object(u.a)({}, t),
                          {},
                          { dataInfoUrl: e.dataInfo.url }
                        )
                      )
                    },
                    progress: function (t) {
                      e.dataInfoSpeed = t.speed.replace('NaN', '0')
                      e.dataInfoReceivedSize = t.receivedSize
                      e.dataInfoTotalSize = t.totalSize
                      e.sendLogger(
                        '回放课前准备页-涂鸦数据进度',
                        Object(u.a)(
                          Object(u.a)({}, t),
                          {},
                          { dataInfoUrl: e.dataInfo.url }
                        )
                      )
                    },
                    complete: function (t) {
                      e.sendLogger(
                        '回放课前准备页-涂鸦数据下载完成',
                        Object(u.a)(
                          Object(u.a)({}, t),
                          {},
                          { dataInfoUrl: e.dataInfo.url }
                        )
                      )
                      e.currentDownIndex++
                      try {
                        var n = t.filePath.split('/')
                        n.pop()
                        n.join('/')
                        var r = new _(t.filePath)
                        r.extractAllTo(e.tempPath, true)
                        var o = O.readdirSync(e.tempPath)
                        o.map(function (t) {
                          if (t.indexOf('.zip') > -1) {
                            var n = new _(''.concat(e.tempPath).concat(t))
                            n.extractAllTo(''.concat(e.tempPath), true)
                          }
                        })
                      } catch (a) {
                        console.error(
                          '回放课前准备页-涂鸦数据解压失败 '.concat(
                            e.dataInfo.url
                          ),
                          a
                        )
                      }
                    },
                    fail: function (t) {
                      e.state = 'fail'
                      e.sendLogger(
                        '回放课前准备页-下载涂鸦文件失败',
                        {
                          error: t,
                          params: e.dataInfo,
                        },
                        'error'
                      )
                    },
                    exists: function (t) {
                      e.currentDownIndex++
                      e.sendLogger(
                        '回放课前准备页-涂鸦数据已经存在',
                        Object(u.a)(
                          Object(u.a)({}, t),
                          {},
                          { dataInfoUrl: e.dataInfo.url }
                        )
                      )
                    },
                    extract: function (t) {
                      e.sendLogger(
                        '回放课前准备页-涂鸦数据下载解压回调',
                        Object(u.a)(
                          Object(u.a)({}, t),
                          {},
                          { dataInfoUrl: e.dataInfo.url }
                        )
                      )
                    },
                  }))
                : console.info(
                  'if(!this.dataInfo.url)为true触发return,path: /renderer/components/ReadyClass/DownloadList/index.vue'
                )
            },
            downloadMainInfo: function () {
              var e = this
              if (
                (console.info(
                  '对象函数 downloadMainInfo,filePath:renderer/components/ReadyClass/DownloadList/index.vue'
                ),
                  this.$store.dispatch('playback/setMainFileName', ''),
                  !this.mainInfoUrl)
              ) {
                return (
                  console.info(
                    'if(!this.mainInfoUrl)为true触发return,path: /renderer/components/ReadyClass/DownloadList/index.vue'
                  ),
                  void this.sendLogger('回放课前准备页-打点文件没有下载地址', {
                    mainInfoUrl: this.mainInfoUrl,
                  })
                )
              }
              this.mainInfoUrl
              this.sendLogger('回放课前准备页-打点文件下载', {
                mainInfoUrl: this.mainInfoUrl,
              })
              I.a.downloadFile({
                fileURL: this.mainInfoUrl,
                savePath: this.tempPath,
                start: function (t) {
                  e.sendLogger(
                    '回放课前准备页-打点文件开始下载',
                    Object(u.a)(
                      Object(u.a)({}, t),
                      {},
                      { mainInfoUrl: e.mainInfoUrl }
                    )
                  )
                },
                progress: function (t) {
                  e.mainInfoSpeed = t.speed.replace('NaN', '0')
                  e.mainInfoReceivedSize = t.receivedSize
                  e.mainInfoTotalSize = t.totalSize
                  e.sendLogger(
                    '回放课前准备页-打点文件下载进度',
                    Object(u.a)(
                      Object(u.a)({}, t),
                      {},
                      { mainInfoUrl: e.mainInfoUrl }
                    )
                  )
                },
                complete: function (t) {
                  e.currentDownIndex++
                  e.$store.dispatch('playback/setMainFileName', t.fileName)
                  e.sendLogger(
                    '回放课前准备页-打点文件下载完成',
                    Object(u.a)(
                      Object(u.a)({}, t),
                      {},
                      { mainInfoUrl: e.mainInfoUrl }
                    )
                  )
                },
                fail: function (t) {
                  e.state = 'fail'
                  e.sendLogger(
                    '回放课前准备页-打点文件下载打点文件失败',
                    {
                      error: t,
                      params: e.mainInfoUrl,
                    },
                    'error'
                  )
                },
                exists: function (t) {
                  e.sendLogger(
                    '回放课前准备页-打点文件已经存在',
                    Object(u.a)(
                      Object(u.a)({}, t),
                      {},
                      { mainInfoUrl: e.mainInfoUrl }
                    )
                  )
                  e.currentDownIndex++
                },
              })
            },
            downloadCommonCourseware: function () {
              var e = this
              console.info(
                '对象函数 downloadCommonCourseware,filePath:renderer/components/ReadyClass/DownloadList/index.vue'
              )
              I.a.downloadCourseware({
                fileURL: this.courseWarePackages.url,
                fileMD5: this.courseWarePackages.zipMd5,
                retry: 2,
                timeout: 10000,
                start: function (t) {
                  e.sendLogger(
                    '回放课前准备页-课件基础包开始下载',
                    Object(u.a)(
                      Object(u.a)({}, t),
                      {},
                      { params: e.courseWarePackages }
                    )
                  )
                },
                progress: function (t) {
                  e.commonCoursewareReceivedSize = t.receivedSize
                  e.commonCoursewareSpeed = t.speed.replace('NaN', '0')
                  e.commonCoursewareTotalSize = t.totalSize
                },
                complete: function (t) {
                  e.currentDownIndex++
                  e.sendLogger(
                    '回放课前准备页-课件基础包下载完成',
                    Object(u.a)(
                      Object(u.a)({}, t),
                      {},
                      { params: e.courseWarePackages }
                    )
                  )
                },
                fail: function (t) {
                  e.state = 'fail'
                  e.sendLogger(
                    '回放课前准备页-课件基础包下载失败',
                    {
                      error: t,
                      params: e.courseWarePackages,
                    },
                    'error'
                  )
                },
                exists: function (t) {
                  e.currentDownIndex++
                  e.sendLogger('回放课前准备页-课件基础包已经存在', {
                    res: t,
                    params: e.courseWarePackages,
                  })
                },
              })
            },
            startDown: function () {
              if (
                (console.info(
                  '对象函数 startDown,filePath:renderer/components/ReadyClass/DownloadList/index.vue'
                ),
                  (this.state = 'progress'),
                  0 === this.needDownloadFileCount)
              ) {
                return (
                  console.info(
                    'if(this.needDownloadFileCount === 0)为true触发return,path: /renderer/components/ReadyClass/DownloadList/index.vue'
                  ),
                  void (this.state = 'complete')
                )
              }
              this.downloadCourseware()
              this.downloadDataInfo()
              this.downloadMainInfo()
              this.downloadCommonCourseware()
            },
            sendLogger: function (e, t) {
              var n =
                arguments.length > 2 && void 0 !== arguments[2]
                  ? arguments[2]
                  : 'info'
              C.a.send({
                tag: 'student.playback',
                content: Object(u.a)(Object(u.a)({}, t), {}, { msg: e }),
                level: n,
              })
            },
          },
          mounted: function () {
            var e = this
            this.planId = this.$route.query.planId
            this.tempPath = ''
              .concat(
                this.$electron.remote.app.getPath('userData'),
                '/playback/'
              )
              .concat(this.planId, '/')
            this.sendLogger('回放文件下载存放地址', { tempPath: this.tempPath })
            this.tempPath
            this.$nextTick(
              Object(l.a)(
                Object(c.a)().mark(function t() {
                  return Object(c.a)().wrap(function (t) {
                    while (1) {
                      switch ((t.prev = t.next)) {
                        case 0:
                          return (t.next = 2), e.getDataInfo()
                        case 2:
                          return (t.next = 4), e.getCommonCourseware()
                        case 4:
                          e.startDown(),
                            e.testOfflineStatus(),
                            e.testOnlineStatus()
                        case 7:
                        case 'end':
                          return t.stop()
                      }
                    }
                  }, t)
                })
              )
            )
          },
        },
        T = N,
        A = (n('7f61'), n('2877')),
        x = Object(A.a)(T, d, f, false, null, '11b7f4ff', null),
        R = x.exports,
        U = n('e79d'),
        k = n('0a06a'),
        j = {
          components: {
            Header: U.a,
            CoursewareDownloading: R,
          },
          data: function () {
            return {
              speedStandard: {},
              isCompleteDownload: false,
              backUrl: this.$route.query.backUrl || '/courses',
            }
          },
          methods: {
            completeDownload: function (e) {
              var t, n, r, o
              console.info(
                '对象函数 completeDownload(coursewareInfo)',
                e,
                'filePath:renderer/components/ReadyClass/PlayBackReadyClass.vue'
              )
              this.isCompleteDownload = true
              Object(S.setPlanId)(
                null === (t = this.$route) || void 0 === t ? void 0 : t.query,
                true
              )
              k.e(
                this.$route.query,
                e,
                null === (n = this.$store) ||
                  void 0 === n ||
                  null === (r = n.state) ||
                  void 0 === r ||
                  null === (o = r.common) ||
                  void 0 === o
                  ? void 0
                  : o.timeOffset
              )
              this.enterClass()
            },
            enterClass: function () {
              var e = this
              console.info(
                '对象函数 enterClass,filePath:renderer/components/ReadyClass/PlayBackReadyClass.vue'
              )
              this.$sensors.track('pc_ready_class_enter', {
                type: 'playBack',
                isCompleteDownload: this.isCompleteDownload,
              })
              this.sendLogger('enterClass准备页进入回放页')
              setTimeout(function () {
                e.$router.replace({
                  path: '/playback/live',
                  query: e.$route.query,
                })
                C.a.send({
                  tag: 'userTrack',
                  content: { msg: '回放准备页-自动进入回放' },
                })
              }, 1000)
            },
            sendLogger: function (e, t) {
              var n =
                arguments.length > 2 && void 0 !== arguments[2]
                  ? arguments[2]
                  : 'info'
              C.a.send({
                tag: 'student.playback',
                content: Object(u.a)(Object(u.a)({}, t), {}, { msg: e }),
                level: n,
              })
            },
          },
          mounted: function () {
            var e = this
            return Object(l.a)(
              Object(c.a)().mark(function t() {
                return Object(c.a)().wrap(function (t) {
                  while (1) {
                    switch ((t.prev = t.next)) {
                      case 0:
                        e.sendLogger('回放准备页mounted')
                      case 1:
                      case 'end':
                        return t.stop()
                    }
                  }
                }, t)
              })
            )()
          },
          destroyed: function () {
            console.info(
              '对象函数 destroyed,filePath:renderer/components/ReadyClass/PlayBackReadyClass.vue'
            )
          },
        },
        F = j,
        P = (n('9d27'), Object(A.a)(F, s, i, false, null, '7b5c47f6', null)),
        B = P.exports,
        z = {
          components: {
            Toolbar: a.a,
            ReadyClass: B,
          },
          data: function () {
            return {}
          },
          methods: {},
        },
        M = z,
        Z = (n('2af5'), Object(A.a)(M, r, o, false, null, null, null))
      t.default = Z.exports
    },
    '7e8d': function (e, t, n) {
      t.require = function () {
        if (
          'object' === typeof process &&
          process.versions &&
          process.versions.electron
        ) {
          try {
            const e = n('b56f')
            if (Object.keys(e).length > 0) {
              return e
            }
          } catch (e) { }
        }
        return n('9b0f')
      }
    },
    '7f61': function (e, t, n) {
      'use strict'
      n('94bc')
    },
    '80b0': function (e, t, n) {
      e.exports = function (e) {
        var t = n('14c2')
        return {
          inflate: function () {
            return t.inflateRawSync(e)
          },
          inflateAsync: function (n) {
            var r = t.createInflateRaw(),
              o = [],
              a = 0
            r.on('data', function (e) {
              o.push(e)
              a += e.length
            })
            r.on('end', function () {
              var e = Buffer.alloc(a),
                t = 0
              e.fill(0)
              for (var r = 0; r < o.length; r++) {
                var s = o[r]
                s.copy(e, t)
                t += s.length
              }
              n && n(e)
            })
            r.end(e)
          },
        }
      }
    },
    '90d7': function (e, t, n) { },
    '94bc': function (e, t, n) { },
    '9c38': function (e, t, n) {
      'use strict'
      n('90d7')
    },
    '9d27': function (e, t, n) {
      'use strict'
      n('a23b')
    },
    '9e7a': function (e, t, n) {
      'use strict'
      n('5010')
    },
    '9ff96': function (e, t, n) {
      'use strict'
      const { randomFillSync: r } = n('3c93'),
        o = new Uint32Array(256).map((e, t) => {
          for (let n = 0; n < 8; n++) {
            0 !== (1 & t) ? (t = (t >>> 1) ^ 3988292384) : (t >>>= 1)
          }
          return t >>> 0
        }),
        a = (e, t) => Math.imul(e, t) >>> 0,
        s = (e, t) => o[255 & (e ^ t)] ^ (e >>> 8),
        i = () => ('function' === typeof r ? r(Buffer.alloc(12)) : i.node())
      i.node = () => {
        const e = Buffer.alloc(12),
          t = e.length
        for (let n = 0; n < t; n++) {
          e[n] = (256 * Math.random()) & 255
        }
        return e
      }
      const c = { genSalt: i }
      function l(e) {
        const t = Buffer.isBuffer(e) ? e : Buffer.from(e)
        this.keys = new Uint32Array([305419896, 591751049, 878082192])
        for (let n = 0; n < t.length; n++) {
          this.updateKeys(t[n])
        }
      }
      function u(e) {
        const t = new l(e)
        return function (e) {
          const n = Buffer.alloc(e.length)
          let r = 0
          for (let o of e) n[r++] = t.updateKeys(o ^ t.next())
          return n
        }
      }
      function d(e) {
        const t = new l(e)
        return function (e, n, r = 0) {
          n || (n = Buffer.alloc(e.length))
          for (let o of e) {
            const e = t.next()
            n[r++] = o ^ e
            t.updateKeys(o)
          }
          return n
        }
      }
      function f(e, t, n) {
        if (!e || !Buffer.isBuffer(e) || e.length < 12) {
          return Buffer.alloc(0)
        }
        const r = u(n),
          o = r(e.slice(0, 12))
        if (o[11] !== t.crc >>> 24) {
          throw 'ADM-ZIP: Wrong Password'
        }
        return r(e.slice(12))
      }
      function p(e) {
        Buffer.isBuffer(e) && e.length >= 12
          ? (c.genSalt = function () {
            return e.slice(0, 12)
          })
          : (c.genSalt = 'node' === e ? i.node : i)
      }
      function h(e, t, n, r = false) {
        null == e && (e = Buffer.alloc(0))
        Buffer.isBuffer(e) || (e = Buffer.from(e.toString()))
        const o = d(n),
          a = c.genSalt()
        a[11] = (t.crc >>> 24) & 255
        r && (a[10] = (t.crc >>> 16) & 255)
        const s = Buffer.alloc(e.length + 12)
        return o(a, s), o(e, s, 12)
      }
      l.prototype.updateKeys = function (e) {
        const t = this.keys
        return (
          (t[0] = s(t[0], e)),
          (t[1] += 255 & t[0]),
          (t[1] = a(t[1], 134775813) + 1),
          (t[2] = s(t[2], t[1] >>> 24)),
          e
        )
      }
      l.prototype.next = function () {
        const e = (2 | this.keys[2]) >>> 0
        return (a(e, 1 ^ e) >> 8) & 255
      }
      e.exports = {
        decrypt: f,
        encrypt: h,
        _salter: p,
      }
    },
    a23b: function (e, t, n) { },
    a5bc: function (e, t, n) {
      'use strict'
      n.d(t, 'd', function () {
        return l
      })
      n.d(t, 'c', function () {
        return u
      })
      n.d(t, 'a', function () {
        return d
      })
      n.d(t, 'b', function () {
        return f
      })
      var r = n('c7eb'),
        o = n('1da1'),
        a = n('dc21'),
        s = n('e39c')
      function i(e, t) {
        return c.apply(this, arguments)
      }
      function c() {
        return (
          (c = Object(o.a)(
            Object(r.a)().mark(function e(t, n) {
              var o, i, c
              return Object(r.a)().wrap(function (e) {
                while (1) {
                  switch ((e.prev = e.next)) {
                    case 0:
                      return (
                        (o = Object(s.h)()),
                        (i = o.oversea),
                        (e.next = 3),
                        Object(a.a)({
                          url: t,
                          params: n,
                          apiDomain: i,
                        })
                      )
                    case 3:
                      return (c = e.sent), e.abrupt('return', c)
                    case 5:
                    case 'end':
                      return e.stop()
                  }
                }
              }, e)
            })
          )),
          c.apply(this, arguments)
        )
      }
      var l = (function () {
        var e = Object(o.a)(
          Object(r.a)().mark(function e(t) {
            var n, o
            return Object(r.a)().wrap(function (e) {
              while (1) {
                switch ((e.prev = e.next)) {
                  case 0:
                    return (
                      (n = '/classroom-hub/playback/student/initEntry'),
                      (e.next = 3),
                      i(n, t)
                    )
                  case 3:
                    return (o = e.sent), e.abrupt('return', o)
                  case 5:
                  case 'end':
                    return e.stop()
                }
              }
            }, e)
          })
        )
        return function (t) {
          return e.apply(this, arguments)
        }
      })(),
        u = (function () {
          var e = Object(o.a)(
            Object(r.a)().mark(function e(t) {
              var n, o
              return Object(r.a)().wrap(function (e) {
                while (1) {
                  switch ((e.prev = e.next)) {
                    case 0:
                      return (
                        (n = '/api/hub/playback/info'), (e.next = 3), i(n, t)
                      )
                    case 3:
                      return (o = e.sent), e.abrupt('return', o)
                    case 5:
                    case 'end':
                      return e.stop()
                  }
                }
              }, e)
            })
          )
          return function (t) {
            return e.apply(this, arguments)
          }
        })(),
        d = (function () {
          var e = Object(o.a)(
            Object(r.a)().mark(function e(t) {
              var n, o
              return Object(r.a)().wrap(function (e) {
                while (1) {
                  switch ((e.prev = e.next)) {
                    case 0:
                      return (
                        (n =
                          '/classroom-hub/playback/student/getRoomHistoryMessage'),
                        (e.next = 3),
                        i(n, t)
                      )
                    case 3:
                      return (o = e.sent), e.abrupt('return', o)
                    case 5:
                    case 'end':
                      return e.stop()
                  }
                }
              }, e)
            })
          )
          return function (t) {
            return e.apply(this, arguments)
          }
        })(),
        f = (function () {
          var e = Object(o.a)(
            Object(r.a)().mark(function e(t) {
              var n, o
              return Object(r.a)().wrap(function (e) {
                while (1) {
                  switch ((e.prev = e.next)) {
                    case 0:
                      return (
                        (n = '/api/playback/feedback'), (e.next = 3), i(n, t)
                      )
                    case 3:
                      return (o = e.sent), e.abrupt('return', o)
                    case 5:
                    case 'end':
                      return e.stop()
                  }
                }
              }, e)
            })
          )
          return function (t) {
            return e.apply(this, arguments)
          }
        })()
    },
    bd12: function (e, t, n) {
      'use strict'
      var r = function () {
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
        o = [
          function () {
            var e = this,
              t = e._self._c
            return t('div', { staticClass: 'loading-contenter' }, [
              t('div', { staticClass: 'loading-logo' }, [
                t('img', { attrs: { src: n('c63e') } }),
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
        s = a,
        i = (n('f761'), n('2877')),
        c = Object(i.a)(s, r, o, false, null, '92d727e8', null)
      t.a = c.exports
    },
    c63e: function (e, t) {
      e.exports =
        'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFAAAABQCAMAAAC5zwKfAAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAAA8UExURUdwTP/DL//DLv/BL//DLv/EL//DL//DLv/DL//CLv/DL//DL//CLf/DL//DL//DL//DLv/DL//DMv/DMGSQIxsAAAATdFJOUwDwcSTeYM1AwICojww0SLNSmhsrwQ8LAAABI0lEQVRYw+3X2a6DIBCAYbaBYXXh/d/1aE3UxtbjMhdtOv+l6BeiiYAQ5+tzLwhK2oGKjTW1Vn/HyQV8NzlzF8HRkfVV10BX38Ygg18FptICKB+70OAWDD4GNPIMaJentyAuv4l8FKx7IIjYdB7a3CdBArplWFoMUYHTiQhcZdDTgqt3yyCDdgTlkBmy1iLeBIcJ7Q6fB2txzpGCYwz+HuhWAR4BcR98LhwAU6vGlXIDaruZexBwAJy35dN2WtadNX++iESbiK8BDRYyULWXT0AvwTsxyCCDnwJaUhAjaCrQBFWSuNsESoytFiRpYzqVxc/kh0Mipaemj2tDHE62iWKCh7daDDLI4CeDhRoUPXSWFHysASpIUnAsK6QFp+Pjf3f8AVRMjNs7xw9TAAAAAElFTkSuQmCC'
    },
    cfea: function (e, t) {
      e.exports = {
        functional: true,
        render(e, t) {
          const { _c: n, _v: r, data: o, children: a = [] } = t,
            {
              class: s,
              staticClass: i,
              style: c,
              staticStyle: l,
              attrs: u = {},
              ...d
            } = o
          return n(
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
            a.concat([
              n('defs'),
              n('path', {
                attrs: {
                  d: 'M328.555 515.588L692.82 151.323c20.074-20.05 20.074-52.554 0-72.578-20.024-20.049-52.528-20.049-72.577 0l-399.25 399.226c-20.025 20.024-20.025 52.529 0 72.578 1.578 1.578 3.383 2.831 5.112 4.16.3.325.526.701.827 1.027l389.877 389.878c19.573 19.573 51.3 19.573 70.874 0s19.573-51.3 0-70.873L328.555 515.588z',
                },
              }),
            ])
          )
        },
      }
    },
    e417: function (e, t, n) {
      'use strict'
      n.d(t, 'f', function () {
        return f
      })
      n.d(t, 'e', function () {
        return p
      })
      n.d(t, 'd', function () {
        return h
      })
      n.d(t, 'c', function () {
        return m
      })
      n.d(t, 'a', function () {
        return g
      })
      n.d(t, 'b', function () {
        return w
      })
      var r = n('bee2'),
        o = n('d4ec'),
        a = n('ade3'),
        s = n('5530'),
        i = (n('cca6'), n('99af'), n('8bbf')),
        c = n.n(i),
        l = null,
        u = true,
        d = 0,
        p = function (e, t) {
          var n =
            arguments.length > 2 && void 0 !== arguments[2] ? arguments[2] : {}
          c.a.prototype.$sensors.track(
            e,
            Object(s.a)(
              {
                lesson_type: f[t.classType],
                class_id: t.classId,
                plan_id: t.planId,
              },
              n
            )
          )
        },
        h = function (e, t) {
          c.a.prototype.$sensors.track(e, t)
        },
        m = function (e) {
          var t = e.type,
            n = void 0 === t ? 'link' : t,
            r = e.result,
            o = e.errorType,
            a = void 0 === o ? '' : o,
            s = e.code,
            i = void 0 === s ? 0 : s,
            f = e.msg,
            p = void 0 === f ? '无' : f,
            h = e.liveInfo,
            m = void 0 === h ? {} : h,
            g = e.msgInfo,
            w = void 0 === g ? {} : g,
            E = {}
          'message' == n
            ? ((E = {
              result: r,
              irc_message_type: p,
            }),
              'fail' == r &&
              Object.assign(E, {
                error_type: a,
                msg_info: JSON.stringify(w),
                error_msg: '错误码='
                  .concat(i, '\uFF0C错误描述=')
                  .concat(p, '失败'),
              }),
              c.a.prototype.$sensors.track('hw_irc_send_message', E))
            : ((E = {
              result: r,
              re_connect_num: d,
              is_first: u ? '是' : '否',
              location: m.location,
            }),
              'fail' == r
                ? (Object.assign(E, {
                  live_info: JSON.stringify(m),
                  error_type: a,
                  error_msg: '错误码='.concat(i, '\uFF0C错误描述=').concat(p),
                }),
                  (u = false),
                  (d += 1))
                : 'success' == r
                  ? (Object.assign(E, { irc_join_room_duration: Date.now() - l }),
                    (u = false),
                    (d += 1))
                  : 'start' == r && (l = Date.now()),
              c.a.prototype.$sensors.track('hw_irc_join_room', E))
        },
        g = Object(r.a)(function e() {
          var t = this
          Object(o.a)(this, e)
          Object(a.a)(this, 'rtcSensorPush', function (e) {
            var n = e.result,
              r = e.errorType,
              o = void 0 === r ? '' : r,
              a = e.code,
              s = void 0 === a ? 0 : a,
              i = e.msg,
              l = void 0 === i ? '无' : i,
              u = {
                result: n,
                is_first: t.isFirstJoinChannel ? '是' : '否',
              }
            'fail' == n
              ? Object.assign(u, {
                error_type: o,
                error_msg: '错误码='.concat(s, '\uFF0C错误描述=').concat(l),
              })
              : 'success' == n
                ? Object.assign(u, {
                  rtc_join_room_duration: Date.now() - t.joinRtcStartTime,
                })
                : 'start' == n && (t.joinRtcStartTime = Date.now())
            c.a.prototype.$sensors.track('hw_rtc_join_room', u)
          })
          this.joinRtcStartTime = null
          this.isFirstJoinChannel = true
        }),
        w = function (e) {
          var t = ''
          if (e.isParent) {
            t = '家长旁听'
          } else {
            t = n[e.lessonType]
          }
          c.a.prototype.$sensors.track('hw_stu_enter_class_room', {
            package_id: e.packageId,
            class_id: e.classId,
            previous_source:
              'course' == e.from ? '学习中心一级页' : '学习中心二级页',
            plan_id: e.planId,
            plan_mode: 0 == e.isPlayBack ? '直播' : '回放',
            lesson_type: f[e.classType],
            course_type: t,
          })
          0 == e.isPlayBack &&
            c.a.prototype.$sensors.track('pc_enter_class_room', {
              previous_source:
                'course' == e.from ? '学习中心一级页' : '学习中心二级页',
              course_type: t,
              is_start_class: !e.isPlayBack && e.isStartClass,
            })
        }
    },
    e634: function (e, t, n) {
      var r = n('445e'),
        o = r.Constants
      e.exports = function () {
        var e = 0,
          t = 0,
          n = 0,
          a = 0,
          s = 0
        return {
          get diskEntries() {
            return e
          },
          set diskEntries(n) {
            e = t = n
          },
          get totalEntries() {
            return t
          },
          set totalEntries(n) {
            t = e = n
          },
          get size() {
            return n
          },
          set size(e) {
            n = e
          },
          get offset() {
            return a
          },
          set offset(e) {
            a = e
          },
          get commentLength() {
            return s
          },
          set commentLength(e) {
            s = e
          },
          get mainHeaderSize() {
            return o.ENDHDR + s
          },
          loadFromBinary: function (i) {
            if (
              (i.length !== o.ENDHDR || i.readUInt32LE(0) !== o.ENDSIG) &&
              (i.length < o.ZIP64HDR || i.readUInt32LE(0) !== o.ZIP64SIG)
            ) {
              throw new Error(r.Errors.INVALID_END)
            }
            i.readUInt32LE(0) === o.ENDSIG
              ? ((e = i.readUInt16LE(o.ENDSUB)),
                (t = i.readUInt16LE(o.ENDTOT)),
                (n = i.readUInt32LE(o.ENDSIZ)),
                (a = i.readUInt32LE(o.ENDOFF)),
                (s = i.readUInt16LE(o.ENDCOM)))
              : ((e = r.readBigUInt64LE(i, o.ZIP64SUB)),
                (t = r.readBigUInt64LE(i, o.ZIP64TOT)),
                (n = r.readBigUInt64LE(i, o.ZIP64SIZE)),
                (a = r.readBigUInt64LE(i, o.ZIP64OFF)),
                (s = 0))
          },
          toBinary: function () {
            var r = Buffer.alloc(o.ENDHDR + s)
            return (
              r.writeUInt32LE(o.ENDSIG, 0),
              r.writeUInt32LE(0, 4),
              r.writeUInt16LE(e, o.ENDSUB),
              r.writeUInt16LE(t, o.ENDTOT),
              r.writeUInt32LE(n, o.ENDSIZ),
              r.writeUInt32LE(a, o.ENDOFF),
              r.writeUInt16LE(s, o.ENDCOM),
              r.fill(' ', o.ENDHDR),
              r
            )
          },
          toJSON: function () {
            const r = function (e, t) {
              let n = e.toString(16).toUpperCase()
              while (n.length < t) {
                n = '0' + n
              }
              return '0x' + n
            }
            return {
              diskEntries: e,
              totalEntries: t,
              size: n + ' bytes',
              offset: r(a, 4),
              commentLength: s,
            }
          },
          toString: function () {
            return JSON.stringify(this.toJSON(), null, '\t')
          },
        }
      }
    },
    e79d: function (e, t, n) {
      'use strict'
      var r = function () {
        var e = this,
          t = e._self._c
        return t(
          'div',
          {
            staticClass: 'header',
            attrs: { 'data-log': '课前准备页header' },
          },
          [
            t('div', { staticClass: 'icon-goback' }, [
              t(
                'div',
                {
                  staticClass: 'icon-wrapper',
                  attrs: { 'data-log': '返回' },
                  on: { click: e.backToPrev },
                },
                [t('a-icon', { attrs: { component: e.gobackSvg } })],
                1
              ),
            ]),
            e.showSignIn
              ? [
                t('SignIn', {
                  attrs: {
                    signStatus: e.signStatus,
                    rightCoin: e.rightCoin,
                    startTime: e.startTime,
                    'data-log': '签到',
                  },
                }),
              ]
              : e._e(),
          ],
          2
        )
      },
        o = [],
        a = (n('14d9'), n('a9e3'), n('cfea')),
        s = n.n(a),
        i = function () {
          var e = this,
            t = e._self._c
          return t(
            'div',
            {
              staticClass: 'center',
              class: { upToDown: e.showAnimation },
            },
            [
              t('div', { staticClass: 'left-content' }, [
                t('div', { staticClass: 'icon-coin' }),
                t('p', { staticClass: 'check-title' }, [
                  e._v(e._s(e.$t('prepareClass.checkIn.onTime'))),
                ]),
              ]),
              t(
                'div',
                { staticClass: 'right-content' },
                [
                  t(
                    'div',
                    { staticClass: 'check-centent' },
                    [
                      e.showCoinAnimation
                        ? [
                          e.checkedSuccess
                            ? t(
                              'div',
                              {
                                staticClass: 'coins-animation',
                                class: { 'self-ani': e.checkedSuccess },
                              },
                              [
                                t('span', { staticClass: 'icon-smile' }),
                                e._m(0),
                              ]
                            )
                            : e._e(),
                          e.rightCoin
                            ? t('span', { staticClass: 'icon-number' }, [
                              e._v('+' + e._s(e.rightCoin)),
                            ])
                            : e._e(),
                        ]
                        : e._e(),
                    ],
                    2
                  ),
                  t(
                    'a-button',
                    {
                      staticClass: 'btn check-btn',
                      attrs: {
                        type: 'primary',
                        shape: 'round',
                        size: 'large',
                        loading: e.loading,
                        disabled: 2 == e.signStatus,
                      },
                      on: { click: e.handleSignIn },
                    },
                    [e._v(' ' + e._s(e.$t('prepareClass.gotIt')) + ' ')]
                  ),
                ],
                1
              ),
            ]
          )
        },
        c = [
          function () {
            var e = this,
              t = e._self._c
            return t('div', { staticClass: 'coins-num-box' }, [
              t('div', { staticClass: 'icons-box' }, [
                t('div', { staticClass: 'top1' }),
                t('div', { staticClass: 'top2' }),
                t('div', { staticClass: 'top3' }),
                t('div', { staticClass: 'bottom1' }),
                t('div', { staticClass: 'bottom2' }),
                t('div', { staticClass: 'bottom3' }),
              ]),
            ])
          },
        ],
        l = n('c7eb'),
        u = n('1da1'),
        d = n('dc21'),
        f = n('e39c')
      function p(e, t, n) {
        return h.apply(this, arguments)
      }
      function h() {
        return (
          (h = Object(u.a)(
            Object(l.a)().mark(function e(t, n, r) {
              var o, a, s
              return Object(l.a)().wrap(function (e) {
                while (1) {
                  switch ((e.prev = e.next)) {
                    case 0:
                      return (
                        (o = Object(f.h)()),
                        (a = o.oversea),
                        (e.next = 3),
                        Object(d.a)({
                          url: n,
                          params: r,
                          apiDomain: a,
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
          )),
          h.apply(this, arguments)
        )
      }
      function m(e, t) {
        return p(e, '/classroom-hub/sign/student/v2/arrive', t)
      }
      var g = n('d0db'),
        w = n('e417'),
        E = n('0a06a'),
        I = {
          props: {
            signStatus: {
              default: 0,
              type: Number,
            },
            rightCoin: {
              default: 0,
              type: Number,
            },
            startTime: {
              default: 0,
              type: Number,
            },
          },
          data: function () {
            return {
              checkedSuccess: false,
              loading: false,
              showAnimation: false,
              showCoinAnimation: true,
            }
          },
          methods: {
            buildSensorOption: function () {
              console.info(
                '对象函数 buildSensorOption,filePath:renderer/components/ReadyClass/SignIn/index.vue'
              )
              var e = this.$route.query,
                t = e.classId,
                n = e.planId,
                r = e.subPlatformType
              return {
                classId: t,
                planId: n,
                classType: r,
              }
            },
            reSensorEvent: function (e) {
              var t =
                arguments.length > 1 && void 0 !== arguments[1]
                  ? arguments[1]
                  : {}
              console.info(
                '对象函数 reSensorEvent(eventName, params)',
                e,
                t,
                'filePath:renderer/components/ReadyClass/SignIn/index.vue'
              )
              var n = this.buildSensorOption()
              Object(w.e)(e, n, t)
            },
            handleSignIn: function () {
              var e = this
              return Object(u.a)(
                Object(l.a)().mark(function t() {
                  var n, r, o, a
                  return Object(l.a)().wrap(function (t) {
                    while (1) {
                      switch ((t.prev = t.next)) {
                        case 0:
                          return (
                            console.info(
                              '对象函数 handleSignIn,filePath:renderer/components/ReadyClass/SignIn/index.vue'
                            ),
                            e.reSensorEvent('hw_classroom_checkin_click', {
                              click_button: 1,
                            }),
                            (e.loading = true),
                            (n = e.$route.query),
                            (r = n.planId),
                            (o = n.classId),
                            E.h({
                              planId: r,
                              coins: e.rightCoin,
                              time: e.startTime,
                            }),
                            (t.next = 7),
                            m(e, {
                              planId: 1 * r,
                              classId: 1 * o,
                            }).catch(function (t) {
                              return (
                                console.info(
                                  '箭头函数 _handleSignIn的catch(err)',
                                  t,
                                  'filePath:renderer/components/ReadyClass/SignIn/index.vue'
                                ),
                                e.sendLogger('接口报错:签到失败:', t, 'error'),
                                t
                              )
                            })
                          )
                        case 7:
                          if (
                            ((a = t.sent),
                              0 == (null === a || void 0 === a ? void 0 : a.code))
                          ) {
                            t.next = 14
                            break
                          }
                          return (
                            console.info(
                              'if(res?.code != 0)为true触发return,path: /renderer/components/ReadyClass/SignIn/index.vue'
                            ),
                            e.sendLogger(
                              '签到失败, res: '.concat(JSON.stringify(a)),
                              'submit'
                            ),
                            e.$Message.error({
                              content: e.$t('prepareClass.checkIn.checkInFail'),
                              duration: 3,
                            }),
                            (e.loading = false),
                            t.abrupt('return')
                          )
                        case 14:
                          ; (e.loading = false),
                            (e.signStatus = 2),
                            (e.checkedSuccess = true),
                            setTimeout(function () {
                              e.showCoinAnimation = false
                            }, 3000),
                            e.sendLogger(
                              '签到成功, res: '.concat(JSON.stringify(a)),
                              'submit'
                            ),
                            e.$Message.success({
                              content: e.$t(
                                'prepareClass.checkIn.checkInSuccess'
                              ),
                              duration: 3,
                            })
                        case 20:
                        case 'end':
                          return t.stop()
                      }
                    }
                  }, t)
                })
              )()
            },
            sendLogger: function (e) {
              var t =
                arguments.length > 1 && void 0 !== arguments[1]
                  ? arguments[1]
                  : '',
                n =
                  arguments.length > 2 && void 0 !== arguments[2]
                    ? arguments[2]
                    : 'info'
              g.a.send({
                tag: 'student.Interact',
                content: {
                  msg: e,
                  interactType: 'Checkin',
                  interactId: '',
                  interactStage: t,
                },
                level: n,
              })
            },
          },
          mounted: function () {
            var e = this
            setTimeout(function () {
              e.showAnimation = true
            })
          },
        },
        y = I,
        C = (n('9c38'), n('2877')),
        v = Object(C.a)(y, i, c, false, null, '5621b0b4', null),
        D = v.exports,
        b = {
          props: {
            backUrl: {
              default: '',
              type: String,
            },
            showSignIn: {
              default: false,
              type: Boolean,
            },
            signStatus: {
              default: 1,
              type: Number,
            },
            rightCoin: {
              default: 0,
              type: Number,
            },
            startTime: {
              default: 0,
              type: Number,
            },
          },
          components: { SignIn: D },
          data: function () {
            return { gobackSvg: s.a }
          },
          computed: {},
          methods: {
            backToPrev: function () {
              console.info(
                '对象函数 backToPrev,filePath:renderer/components/ReadyClass/Header/index.vue'
              )
              this.$router.push({ path: this.backUrl })
            },
          },
          mounted: function () { },
          beforeDestroy: function () {
            console.info(
              '对象函数 beforeDestroy,filePath:renderer/components/ReadyClass/Header/index.vue'
            )
          },
        },
        L = b,
        S = (n('9e7a'), Object(C.a)(L, r, o, false, null, '5efde760', null))
      t.a = S.exports
    },
    eb3b: function (e, t, n) {
      var r = n('445e'),
        o = n('5a20'),
        a = r.Constants,
        s = n('fc95')
      e.exports = function (e) {
        var t = new o.EntryHeader(),
          n = Buffer.alloc(0),
          i = Buffer.alloc(0),
          c = false,
          l = null,
          u = Buffer.alloc(0)
        function d() {
          return e && Buffer.isBuffer(e)
            ? (t.loadDataHeaderFromBinary(e),
              e.slice(t.realDataOffset, t.realDataOffset + t.compressedSize))
            : Buffer.alloc(0)
        }
        function f(e) {
          return 8 === (8 & t.flags) || r.crc32(e) === t.dataHeader.crc
        }
        function p(e, o, a) {
          if (
            ('undefined' === typeof o &&
              'string' === typeof e &&
              ((a = e), (e = void 0)),
              c)
          ) {
            return (
              e && o && o(Buffer.alloc(0), r.Errors.DIRECTORY_CONTENT_ERROR),
              Buffer.alloc(0)
            )
          }
          var i = d()
          if (0 === i.length) {
            return e && o && o(i), i
          }
          if (t.encripted) {
            if ('string' !== typeof a && !Buffer.isBuffer(a)) {
              throw new Error('ADM-ZIP: Incompatible password parameter')
            }
            i = s.ZipCrypto.decrypt(i, t, a)
          }
          var l = Buffer.alloc(t.size)
          switch (t.method) {
            case r.Constants.STORED:
              if ((i.copy(l), f(l))) {
                return e && o && o(l), l
              }
              throw (
                (e && o && o(l, r.Errors.BAD_CRC), new Error(r.Errors.BAD_CRC))
              )
            case r.Constants.DEFLATED:
              var u = new s.Inflater(i)
              if (!e) {
                const e = u.inflate(l)
                if ((e.copy(l, 0), !f(l))) {
                  throw new Error(r.Errors.BAD_CRC + ' ' + n.toString())
                }
                return l
              }
              u.inflateAsync(function (e) {
                e.copy(e, 0)
                o && (f(e) ? o(e) : o(e, r.Errors.BAD_CRC))
              })
              break
            default:
              throw (
                (e && o && o(Buffer.alloc(0), r.Errors.UNKNOWN_METHOD),
                  new Error(r.Errors.UNKNOWN_METHOD))
              )
          }
        }
        function h(n, o) {
          if ((!l || !l.length) && Buffer.isBuffer(e)) {
            return n && o && o(d()), d()
          }
          if (l.length && !c) {
            var a
            switch (t.method) {
              case r.Constants.STORED:
                return (
                  (t.compressedSize = t.size),
                  (a = Buffer.alloc(l.length)),
                  l.copy(a),
                  n && o && o(a),
                  a
                )
              default:
              case r.Constants.DEFLATED:
                var i = new s.Deflater(l)
                if (!n) {
                  var u = i.deflate()
                  return (t.compressedSize = u.length), u
                }
                i.deflateAsync(function (e) {
                  a = Buffer.alloc(e.length)
                  t.compressedSize = e.length
                  e.copy(a)
                  o && o(a)
                }),
                  (i = null)
                break
            }
          } else {
            if (!n || !o) {
              return Buffer.alloc(0)
            }
            o(Buffer.alloc(0))
          }
        }
        function m(e, t) {
          return (e.readUInt32LE(t + 4) << 4) + e.readUInt32LE(t)
        }
        function g(e) {
          var t,
            n,
            r,
            o = 0
          while (o < e.length) {
            t = e.readUInt16LE(o)
            o += 2
            n = e.readUInt16LE(o)
            o += 2
            r = e.slice(o, o + n)
            o += n
            a.ID_ZIP64 === t && w(r)
          }
        }
        function w(e) {
          var n, r, o, s
          e.length >= a.EF_ZIP64_SCOMP &&
            ((n = m(e, a.EF_ZIP64_SUNCOMP)),
              t.size === a.EF_ZIP64_OR_32 && (t.size = n))
          e.length >= a.EF_ZIP64_RHO &&
            ((r = m(e, a.EF_ZIP64_SCOMP)),
              t.compressedSize === a.EF_ZIP64_OR_32 && (t.compressedSize = r))
          e.length >= a.EF_ZIP64_DSN &&
            ((o = m(e, a.EF_ZIP64_RHO)),
              t.offset === a.EF_ZIP64_OR_32 && (t.offset = o))
          e.length >= a.EF_ZIP64_DSN + 4 &&
            ((s = e.readUInt32LE(a.EF_ZIP64_DSN)),
              t.diskNumStart === a.EF_ZIP64_OR_16 && (t.diskNumStart = s))
        }
        return {
          get entryName() {
            return n.toString()
          },
          get rawEntryName() {
            return n
          },
          set entryName(e) {
            n = r.toBuffer(e)
            var o = n[n.length - 1]
            c = 47 === o || 92 === o
            t.fileNameLength = n.length
          },
          get extra() {
            return u
          },
          set extra(e) {
            u = e
            t.extraLength = e.length
            g(e)
          },
          get comment() {
            return i.toString()
          },
          set comment(e) {
            i = r.toBuffer(e)
            t.commentLength = i.length
          },
          get name() {
            var e = n.toString()
            return c
              ? e
                .substr(e.length - 1)
                .split('/')
                .pop()
              : e.split('/').pop()
          },
          get isDirectory() {
            return c
          },
          getCompressedData: function () {
            return h(false, null)
          },
          getCompressedDataAsync: function (e) {
            h(true, e)
          },
          setData: function (e) {
            l = r.toBuffer(e)
            !c && l.length
              ? ((t.size = l.length),
                (t.method = r.Constants.DEFLATED),
                (t.crc = r.crc32(e)),
                (t.changed = true))
              : (t.method = r.Constants.STORED)
          },
          getData: function (e) {
            return t.changed ? l : p(false, null, e)
          },
          getDataAsync: function (e, n) {
            t.changed ? e(l) : p(true, e, n)
          },
          set attr(e) {
            t.attr = e
          },
          get attr() {
            return t.attr
          },
          set header(e) {
            t.loadFromBinary(e)
          },
          get header() {
            return t
          },
          packHeader: function () {
            var e = t.entryHeaderToBinary(),
              o = r.Constants.CENHDR
            return (
              n.copy(e, o),
              (o += n.length),
              t.extraLength && (u.copy(e, o), (o += t.extraLength)),
              t.commentLength && i.copy(e, o),
              e
            )
          },
          toJSON: function () {
            const n = function (e) {
              return '<' + ((e && e.length + ' bytes buffer') || 'null') + '>'
            }
            return {
              entryName: this.entryName,
              name: this.name,
              comment: this.comment,
              isDirectory: this.isDirectory,
              header: t.toJSON(),
              compressedData: n(e),
              data: n(l),
            }
          },
          toString: function () {
            return JSON.stringify(this.toJSON(), null, '\t')
          },
        }
      }
    },
    ebc2: function (e, t, n) { },
    f761: function (e, t, n) {
      'use strict'
      n('ebc2')
    },
    fc95: function (e, t, n) {
      t.Deflater = n('583f')
      t.Inflater = n('80b0')
      t.ZipCrypto = n('9ff96')
    },
    ff7a: function (e, t, n) {
      const r = n('7e8d').require(),
        o = n('a32b'),
        a = n('566b7'),
        s = n('5a45'),
        i = 'object' === typeof process && 'win32' === process.platform,
        c = (e) => e && 'object' === typeof e,
        l = new Uint32Array(256).map((e, t) => {
          for (let n = 0; n < 8; n++) {
            0 !== (1 & t) ? (t = 3988292384 ^ (t >>> 1)) : (t >>>= 1)
          }
          return t >>> 0
        })
      function u(e) {
        this.sep = o.sep
        this.fs = r
        c(e) &&
          c(e.fs) &&
          'function' === typeof e.fs.statSync &&
          (this.fs = e.fs)
      }
      e.exports = u
      u.prototype.makeDir = function (e) {
        const t = this
        function n(e) {
          let n = e.split(t.sep)[0]
          e.split(t.sep).forEach(function (e) {
            if (e && ':' !== e.substr(-1, 1)) {
              var r
              n += t.sep + e
              try {
                r = t.fs.statSync(n)
              } catch (o) {
                t.fs.mkdirSync(n)
              }
              if (r && r.isFile()) {
                throw s.FILE_IN_THE_WAY.replace('%s', n)
              }
            }
          })
        }
        n(e)
      }
      u.prototype.writeFileTo = function (e, t, n, r) {
        const a = this
        if (a.fs.existsSync(e)) {
          if (!n) {
            return false
          }
          var s = a.fs.statSync(e)
          if (s.isDirectory()) {
            return false
          }
        }
        var i,
          c = o.dirname(e)
        a.fs.existsSync(c) || a.makeDir(c)
        try {
          i = a.fs.openSync(e, 'w', 438)
        } catch (l) {
          a.fs.chmodSync(e, 438)
          i = a.fs.openSync(e, 'w', 438)
        }
        if (i) {
          try {
            a.fs.writeSync(i, t, 0, t.length, 0)
          } finally {
            a.fs.closeSync(i)
          }
        }
        return a.fs.chmodSync(e, r || 438), true
      }
      u.prototype.writeFileToAsync = function (e, t, n, r, a) {
        'function' === typeof r && ((a = r), (r = void 0))
        const s = this
        s.fs.exists(e, function (i) {
          if (i && !n) {
            return a(false)
          }
          s.fs.stat(e, function (n, c) {
            if (i && c.isDirectory()) {
              return a(false)
            }
            var l = o.dirname(e)
            s.fs.exists(l, function (n) {
              n || s.makeDir(l)
              s.fs.open(e, 'w', 438, function (n, o) {
                n
                  ? s.fs.chmod(e, 438, function () {
                    s.fs.open(e, 'w', 438, function (n, o) {
                      s.fs.write(o, t, 0, t.length, 0, function () {
                        s.fs.close(o, function () {
                          s.fs.chmod(e, r || 438, function () {
                            a(true)
                          })
                        })
                      })
                    })
                  })
                  : o
                    ? s.fs.write(o, t, 0, t.length, 0, function () {
                      s.fs.close(o, function () {
                        s.fs.chmod(e, r || 438, function () {
                          a(true)
                        })
                      })
                    })
                    : s.fs.chmod(e, r || 438, function () {
                      a(true)
                    })
              })
            })
          })
        })
      }
      u.prototype.findFiles = function (e) {
        const t = this
        function n(e, r, a) {
          'boolean' === typeof r && ((a = r), (r = void 0))
          let s = []
          return (
            t.fs.readdirSync(e).forEach(function (i) {
              var c = o.join(e, i)
              t.fs.statSync(c).isDirectory() && a && (s = s.concat(n(c, r, a)))
                ; (r && !r.test(c)) ||
                  s.push(
                    o.normalize(c) + (t.fs.statSync(c).isDirectory() ? t.sep : '')
                  )
            }),
            s
          )
        }
        return n(e, void 0, true)
      }
      u.prototype.getAttributes = function () { }
      u.prototype.setAttributes = function () { }
      u.crc32update = function (e, t) {
        return l[255 & (e ^ t)] ^ (e >>> 8)
      }
      u.crc32 = function (e) {
        'string' === typeof e && (e = Buffer.from(e, 'utf8'))
        l.length || genCRCTable()
        let t = e.length,
          n = -1
        for (let r = 0; r < t;) {
          n = u.crc32update(n, e[r++])
        }
        return ~n >>> 0
      }
      u.methodToString = function (e) {
        switch (e) {
          case a.STORED:
            return 'STORED (' + e + ')'
          case a.DEFLATED:
            return 'DEFLATED (' + e + ')'
          default:
            return 'UNSUPPORTED (' + e + ')'
        }
      }
      u.canonical = function (e) {
        if (!e) {
          return ''
        }
        var t = o.posix.normalize('/' + e.split('\\').join('/'))
        return o.join('.', t)
      }
      u.sanitize = function (e, t) {
        e = o.resolve(o.normalize(e))
        for (var n = t.split('/'), r = 0, a = n.length; r < a; r++) {
          var s = o.normalize(o.join(e, n.slice(r, a).join(o.sep)))
          if (0 === s.indexOf(e)) {
            return s
          }
        }
        return o.normalize(o.join(e, o.basename(t)))
      }
      u.toBuffer = function (e) {
        return Buffer.isBuffer(e)
          ? e
          : e instanceof Uint8Array
            ? Buffer.from(e)
            : 'string' === typeof e
              ? Buffer.from(e, 'utf8')
              : Buffer.alloc(0)
      }
      u.readBigUInt64LE = function (e, t) {
        var n = Buffer.from(e.slice(t, t + 8))
        return n.swap64(), parseInt('0x' + n.toString('hex'))
      }
      u.isWin = i
      u.crcTable = l
    },
  },
])
