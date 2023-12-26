(function (e) {
    function t(t) {
        for (var o, a, i = t[0], c = t[1], l = t[2], u = 0, d = []; u < i.length; u++) {
            a = i[u];
            Object.prototype.hasOwnProperty.call(n, a) && n[a] && d.push(n[a][0]);
            n[a] = 0;
        }
        for (o in c)
            Object.prototype.hasOwnProperty.call(c, o) && (e[o] = c[o]);
        m && m(t);
        while (d.length) {
            d.shift()();
        }
        return r.push.apply(r, l || []), s();
    }
    function s() {
        for (var e, t = 0; t < r.length; t++) {
            for (var s = r[t], o = true, a = 1; a < s.length; a++) {
                var i = s[a];
                0 !== n[i] && (o = false);
            }
            o && (r.splice(t--, 1), e = c(c.s = s[0]));
        }
        return e;
    }
    var o = {}, r = [];
    function i(e) {
        return c.p + 'static/js/' + ({}[e] || e) + '.' + {
            'chunk-09d4164c': '50c8114a',
            'chunk-14a97d99': 'fd3f9688',
            'chunk-74ddfa26': 'c1f47ab5',
            'chunk-16c075d8': '70eae4d1',
            'chunk-2e9cf93e': 'd01b997d',
            'chunk-2ec16a41': '0c553de0',
            'chunk-3d75fc56': '4e5265e6',
            'chunk-4cfb0224': '33aaacdb',
            'chunk-5125c77c': '3d49a1c2',
            'chunk-21cb9dbc': '691d8a8c',
            'chunk-6e54407c': '95b46345',
            'chunk-6fa24106': '0852af73',
            'chunk-7f66cf6e': '0a47586e',
            'chunk-9c37b028': 'f10c61d2',
            'chunk-9c43f55c': 'a9eebaa9',
            'chunk-2d0d67ce': '9fe70b65',
            'chunk-d5156d36': 'd0a12b00'
        }[e] + '.js';
    }
    function c(t) {
        if (o[t]) {
            return o[t].exports;
        }
        var s = o[t] = {
            i: t,
            l: false,
            exports: {}
        };
        return e[t].call(s.exports, s, s.exports, c), s.l = true, s.exports;
    }
    c.e = function (e) {
        var t = [];
        a[e] ? t.push(a[e]) : 0 !== a[e] && s[e] && t.push(a[e] = new Promise(function (t, s) {
            for (var o = 'static/css/' + ({}[e] || e) + '.' + {
                'chunk-09d4164c': 'd95d103b',
                'chunk-14a97d99': 'a4c2b5ac',
                'chunk-74ddfa26': '31d6cfe0',
                'chunk-16c075d8': 'dc899aec',
                'chunk-2e9cf93e': '31d6cfe0',
                'chunk-2ec16a41': 'c08f8ea4',
                'chunk-3d75fc56': '9282e18c',
                'chunk-4cfb0224': '8111d05f',
                'chunk-5125c77c': 'd1738e4f',
                'chunk-21cb9dbc': 'b2c05241',
                'chunk-6e54407c': '0722f961',
                'chunk-6fa24106': '0ac66689',
                'chunk-7f66cf6e': '6624d027',
                'chunk-9c37b028': '98858406',
                'chunk-9c43f55c': '442c9dd5',
                'chunk-2d0d67ce': '31d6cfe0',
                'chunk-d5156d36': '21154e7f'
            }[e] + '.css', n = c.p + o, r = document.getElementsByTagName('link'), i = 0; i < r.length; i++) {
                var l = r[i], u = l.getAttribute('data-href') || l.getAttribute('href');
                if ('stylesheet' === l.rel && (u === o || u === n)) {
                    return t();
                }
            }
            var d = document.getElementsByTagName('style');
            for (i = 0; i < d.length; i++) {
                l = d[i];
                u = l.getAttribute('data-href');
                if (u === o || u === n) {
                    return t();
                }
            }
            var m = document.createElement('link');
            m.rel = 'stylesheet';
            m.type = 'text/css';
            m.onload = t;
            m.onerror = function (t) {
                var o = t && t.target && t.target.src || n, r = new Error('Loading CSS chunk ' + e + ' failed.\n(' + o + ')');
                r.code = 'CSS_CHUNK_LOAD_FAILED';
                r.request = o;
                delete a[e];
                m.parentNode.removeChild(m);
                s(r);
            };
            m.href = n;
            var h = document.getElementsByTagName('head')[0];
            h.appendChild(m);
        }).then(function () {
            a[e] = 0;
        }));
        var o = n[e];
        if (0 !== o) {
            if (o) {
                t.push(o[2]);
            } else {
                var r = new Promise(function (t, s) {
                    o = n[e] = [
                        t,
                        s
                    ];
                });
                t.push(o[2] = r);
                var l, u = document.createElement('script');
                u.charset = 'utf-8';
                u.timeout = 120;
                c.nc && u.setAttribute('nonce', c.nc);
                u.src = i(e);
                var d = new Error();
                l = function (t) {
                    u.onerror = u.onload = null;
                    clearTimeout(m);
                    var s = n[e];
                    if (0 !== s) {
                        if (s) {
                            var o = t && ('load' === t.type ? 'missing' : t.type), a = t && t.target && t.target.src;
                            d.message = 'Loading chunk ' + e + ' failed.\n(' + o + ': ' + a + ')';
                            d.name = 'ChunkLoadError';
                            d.type = o;
                            d.request = a;
                            s[1](d);
                        }
                        n[e] = void 0;
                    }
                };
                var m = setTimeout(function () {
                    l({
                        type: 'timeout',
                        target: u
                    });
                }, 120000);
                u.onerror = u.onload = l;
                document.head.appendChild(u);
            }
        }
        return Promise.all(t);
    };
    c.m = e;
    c.c = o;
    c.d = function (e, t, s) {
        c.o(e, t) || Object.defineProperty(e, t, {
            enumerable: true,
            get: s
        });
    };
    c.r = function (e) {
        'undefined' !== typeof Symbol && Symbol.toStringTag && Object.defineProperty(e, Symbol.toStringTag, { value: 'Module' });
        Object.defineProperty(e, '__esModule', { value: true });
    };
    c.t = function (e, t) {
        if (1 & t && (e = c(e)), 8 & t) {
            return e;
        }
        if (4 & t && 'object' === typeof e && e && e.__esModule) {
            return e;
        }
        var s = Object.create(null);
        if (c.r(s), Object.defineProperty(s, 'default', {
            enumerable: true,
            value: e
        }), 2 & t && 'string' != typeof e) {
            for (var o in e)
                c.d(s, o, function (t) {
                    return e[t];
                }.bind(null, o));
        }
        return s;
    };
    c.n = function (e) {
        var t = e && e.__esModule ? function () {
            return e.default;
        } : function () {
            return e;
        };
        return c.d(t, 'a', t), t;
    };
    c.o = function (e, t) {
        return Object.prototype.hasOwnProperty.call(e, t);
    };
    c.p = '/';
    c.oe = function (e) {
        throw console.error(e), e;
    };
    var l = window.webpackJsonp = window.webpackJsonp || [], u = l.push.bind(l);
    l.push = t;
    l = l.slice();
    for (var d = 0; d < l.length; d++) {
        t(l[d]);
    }
    var m = u;
    r.push([
        4,
        'chunk-vendors',
        'chunk-common'
    ]);
    s();
}({
    '006b': function (e, t, s) {
        'use strict';
        s('bcb4');
    },
    '0224': function (e, t) {
        e.exports = 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFgAAABYBAMAAACDuy0HAAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAAAqUExURUdwTBSE5BSE5Q+G6hSE5Q+G8hSD5RSE5RSF5RKB4xSF5RSD5RSF5RSF5R3hsmUAAAANdFJOUwCS6Rb5BbNXeDar09MVx7XRAAABEElEQVRIx+3Xvw7BUBQG8EvTWA2MTQiJSSLegFgMEiLECxgl4hFsHWwGiyfAYLBIvICNNOJPzrtITiltVL+zGOR+8y/NzelwvqPUM7Nlnj6kurdVMO0xhcXJlvzWsCg8tYpfj+hrCu+2RRFJv6w5iMKnpoe7FJm+h61ofHjaBAEZPnAZwTn8Fd47jAaCHffHxCBMScZxyDoZxlMIU53xBMNnxisMXxnvMHxjXMTwkTE2OXIYExiNNdZYY401/kcsWpqidSxa9KIKISoncwxf3EKFjWPDuId92a1qBjZmtwSaknopK66iSiwq27IaLzoQRKeH7KhRRuqbrQSPq/BDjNYBq8zObPH5xNvaTaXz09wBJLUrWlJ9+nYAAAAASUVORK5CYII=';
    },
    '0504': function (e, t) {
        e.exports = 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABgAAAAcCAMAAABMOI/cAAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAAAzUExURUdwTP+rC/+qCv+rCP+pCv+rAP+qCf+rCv+qCP+qCv+rCP+rCv+tCP+rCv+rCP+rCv+rCiEaMUEAAAAQdFJOUwAq/m3JDpZ+9kNY5TrFHni/d9yZAAAAj0lEQVQoz9XSQQ6EIAwF0FKggIr2/qcVKCjONHG2w8KY/74NGADelyEyWp4ic0x6rkmKyJpI/1tG/1Pu/lPm/izSRxyPIb3vqKaUcYiRvvOhRBi8k28MUHtxHipwgC4kUHII3KALlVHIueQXgM9tFOx2aZu7AGCx+3T6CZ7rz+CocCiw1b+7aRfLrqv94V6eU2oNVnwN9MUAAAAASUVORK5CYII=';
    },
    '0555': function (e, t, s) {
        e.exports = s.p + 'static/img/icon_flower_r.5dab610e.png';
    },
    '05ee': function (e, t, s) {
        var o = s('970b').default, a = s('5bc3').default, n = s('ed6d').default, r = s('2d0d').default;
        s('14d9');
        s('3c65');
        s('99af');
        s('a15b');
        s('d81d');
        s('cb29');
        s('d3b7');
        s('159b');
        s('b64b');
        s('caad');
        s('2532');
        var i = s('9b0f'), c = s('a32b'), l = s('7188'), u = s('ac91'), d = u.ReportBase, m = s('f0e0');
        function h(e) {
            return '\n <head>\n     <title>Code coverage report for '.concat(l.escape(e.entity), '</title>\n     <meta charset="utf-8" />\n     <link rel="stylesheet" href="').concat(l.escape(e.prettify.css), '" />\n     <link rel="stylesheet" href="').concat(l.escape(e.base.css), '" />\n     <link rel="shortcut icon" type="image/x-icon" href="').concat(l.escape(e.favicon), '" />\n     <meta name="viewport" content="width=device-width, initial-scale=1" />\n     <style type=\'text/css\'>\n         .coverage-summary .sorter {\n             background-image: url(').concat(l.escape(e.sorter.image), ');\n         }\n     </style>\n </head>\n     ');
        }
        function p(e) {
            function t(e, t) {
                var s = e.pct, o = e.covered, a = e.total;
                return '\n             <div class=\'fl pad1y space-right2\'>\n                 <span class="strong">'.concat(s, '% </span>\n                 <span class="quiet">').concat(t, '</span>\n                 <span class=\'fraction\'>').concat(o, '/').concat(a, '</span>\n             </div>\n         ');
            }
            function s(e) {
                var t = e.statements.skipped, s = e.branches.skipped, o = e.functions.skipped, a = function (e, t, s) {
                    return 0 === e ? [] : ''.concat(e, ' ').concat(t).concat(1 === e ? '' : s);
                }, n = [].concat(a(t, 'statement', 's'), a(o, 'function', 's'), a(s, 'branch', 'es'));
                return 0 === n.length ? '' : '\n             <div class=\'fl pad1y\'>\n                 <span class="strong">'.concat(n.join(', '), '</span>\n                 <span class="quiet">Ignored</span>  &nbsp;&nbsp;&nbsp;&nbsp;\n             </div>\n         ');
            }
            return '\n <!doctype html>\n <html lang="en">\n '.concat(h(e), '\n <body>\n <div class=\'wrapper\'>\n     <div class=\'pad1\'>\n         <h1>').concat(e.pathHtml, '</h1>\n         <div class=\'clearfix\'>\n             ').concat(t(e.metrics.statements, 'Statements'), '\n             ').concat(t(e.metrics.branches, 'Branches'), '\n             ').concat(t(e.metrics.functions, 'Functions'), '\n             ').concat(t(e.metrics.lines, 'Lines'), '\n             ').concat(s(e.metrics), '\n         </div>\n         <p class="quiet">\n             Press <em>n</em> or <em>j</em> to go to the next uncovered block, <em>b</em>, <em>p</em> or <em>k</em> for the previous block.\n         </p>\n         <template id="filterTemplate">\n             <div class="quiet">\n                 Filter:\n                 <input oninput="onInput()" type="search" id="fileSearch">\n             </div>\n         </template>\n     </div>\n     <div class=\'status-line ').concat(e.reportClass, '\'></div>\n     ');
        }
        function f(e) {
            return '\n                 <div class=\'push\'></div><!-- for sticky footer -->\n             </div><!-- /wrapper -->\n             <div class=\'footer quiet pad2 space-top1 center small\'>\n                 Code coverage generated by\n                 <a href="https://istanbul.js.org/" target="_blank" rel="noopener noreferrer">istanbul</a>\n                 at '.concat(l.escape(e.datetime), '\n             </div>\n         <script src="').concat(l.escape(e.prettify.js), '"></script>\n         <script>\n             window.onload = function () {\n                 prettyPrint();\n             };\n         </script>\n         <script src="').concat(l.escape(e.sorter.js), '"></script>\n         <script src="').concat(l.escape(e.blockNavigation.js), '"></script>\n     </body>\n </html>\n     ');
        }
        function v(e) {
            var t = new Array(e.maxLines).fill().map(function (e, t) {
                return t + 1;
            }), s = function (e) {
                return '<a name=\'L'.concat(e, '\'></a><a href=\'#L').concat(e, '\'>').concat(e, '</a>');
            }, o = function (e) {
                return '<span class="cline-any cline-'.concat(e.covered, '">').concat(e.hits, '</span>');
            };
            return [
                '<tr>',
                '<td class="line-count quiet">'.concat(t.map(s).join('\n'), '</td>'),
                '<td class="line-coverage quiet">'.concat(e.lineCoverage.map(o).join('\n'), '</td>'),
                '<td class="text"><pre class="prettyprint lang-js">'.concat(e.annotatedCode.join('\n'), '</pre></td>'),
                '</tr>'
            ].join('');
        }
        var g = [
            '<div class="pad1">',
            '<table class="coverage-summary">',
            '<thead>',
            '<tr>',
            '   <th data-col="file" data-fmt="html" data-html="true" class="file">File</th>',
            '   <th data-col="pic" data-type="number" data-fmt="html" data-html="true" class="pic"></th>',
            '   <th data-col="statements" data-type="number" data-fmt="pct" class="pct">Statements</th>',
            '   <th data-col="statements_raw" data-type="number" data-fmt="html" class="abs"></th>',
            '   <th data-col="branches" data-type="number" data-fmt="pct" class="pct">Branches</th>',
            '   <th data-col="branches_raw" data-type="number" data-fmt="html" class="abs"></th>',
            '   <th data-col="functions" data-type="number" data-fmt="pct" class="pct">Functions</th>',
            '   <th data-col="functions_raw" data-type="number" data-fmt="html" class="abs"></th>',
            '   <th data-col="lines" data-type="number" data-fmt="pct" class="pct">Lines</th>',
            '   <th data-col="lines_raw" data-type="number" data-fmt="html" class="abs"></th>',
            '</tr>',
            '</thead>',
            '<tbody>'
        ].join('\n');
        function C(e) {
            var t = e.reportClasses, s = e.metrics, o = e.file, a = e.output, n = function (e) {
                if (!isFinite(e)) {
                    return '';
                }
                var t = ['cover-fill'];
                return 100 === e && t.push('cover-full'), e = Math.floor(e), [
                    '<div class="'.concat(t.join(' '), '" style="width: ').concat(e, '%"></div>'),
                    '<div class="cover-empty" style="width: '.concat(100 - e, '%"></div>')
                ].join('');
            }, r = function (e) {
                var o = arguments.length > 1 && void 0 !== arguments[1] && arguments[1], a = s[e], r = t[e], i = [
                    '<td data-value="'.concat(a.pct, '" class="pct ').concat(r, '">').concat(a.pct, '%</td>'),
                    '<td data-value="'.concat(a.total, '" class="abs ').concat(r, '">').concat(a.covered, '/').concat(a.total, '</td>')
                ];
                return o && i.unshift('<td data-value="'.concat(a.pct, '" class="pic ').concat(r, '">'), '<div class="chart">'.concat(n(a.pct), '</div>'), '</td>'), i;
            };
            return [].concat('<tr>', '<td class="file '.concat(t.statements, '" data-value="').concat(l.escape(o), '"><a href="').concat(l.escape(a), '">').concat(l.escape(o), '</a></td>'), r('statements', true), r('branches'), r('functions'), r('lines'), '</tr>\n').join('\n\t');
        }
        var b = [
            '</tbody>',
            '</table>',
            '</div>'
        ].join('\n'), w = {
            getPath: function (e) {
                if ('string' === typeof e) {
                    return e;
                }
                var t = e.getQualifiedName();
                return e.isSummary() ? '' !== t ? t += '/index.html' : t = 'index.html' : t += '.html', t;
            },
            relativePath: function (e, t) {
                var s = this.getPath(t), o = c.dirname(this.getPath(e));
                return c.posix.relative(o, s);
            },
            assetPath: function (e, t) {
                return this.relativePath(this.getPath(e), t);
            }
        };
        function y(e) {
            return Object.keys(S).forEach(function (t) {
                e[t].pct = 0;
            }), e;
        }
        var P = function (e) {
            'use strict';
            n(s, e);
            var t = r(s);
            function s(e) {
                var a;
                return o(this, s), a = t.call(this), a.verbose = e.verbose, a.linkMapper = e.linkMapper || w, a.subdir = e.subdir || '', a.date = new Date().toISOString(), a.skipEmpty = e.skipEmpty, a;
            }
            return a(s, [
                {
                    key: 'getBreadcrumbHtml',
                    value: function (e) {
                        var t = this, s = e.getParent(), o = [];
                        while (s) {
                            o.push(s);
                            s = s.getParent();
                        }
                        var a = o.map(function (s) {
                            var o = t.linkMapper.relativePath(e, s), a = s.getRelativeName() || 'All files';
                            return '<a href="' + o + '">' + a + '</a>';
                        });
                        return a.reverse(), a.length > 0 ? a.join(' / ') + ' ' + e.getRelativeName() : 'All files';
                    }
                },
                {
                    key: 'fillTemplate',
                    value: function (e, t, s) {
                        var o = this.linkMapper, a = e.getCoverageSummary();
                        t.entity = e.getQualifiedName() || 'All files';
                        t.metrics = a;
                        t.reportClass = s.classForPercent('statements', a.statements.pct);
                        t.pathHtml = this.getBreadcrumbHtml(e);
                        t.base = { css: o.assetPath(e, 'base.css') };
                        t.sorter = {
                            js: o.assetPath(e, 'sorter.js'),
                            image: o.assetPath(e, 'sort-arrow-sprite.png')
                        };
                        t.blockNavigation = { js: o.assetPath(e, 'block-navigation.js') };
                        t.prettify = {
                            js: o.assetPath(e, 'prettify.js'),
                            css: o.assetPath(e, 'prettify.css')
                        };
                        t.favicon = o.assetPath(e, 'favicon.png');
                    }
                },
                {
                    key: 'getTemplateData',
                    value: function () {
                        return { datetime: this.date };
                    }
                },
                {
                    key: 'getWriter',
                    value: function (e) {
                        return this.subdir ? e.writer.writerForDir(this.subdir) : e.writer;
                    }
                },
                {
                    key: 'onStart',
                    value: function (e, t) {
                        var s = this;
                        [
                            '.',
                            'vendor'
                        ].forEach(function (e) {
                            var a = s.getWriter(t), n = c.resolve(require('electron').remote.app.getAppPath(), 'assets', e);
                            n.includes('.asar') || i.readdirSync(n).forEach(function (e) {
                                var t, r = c.resolve(n, e), u = i.statSync(r);
                                u.isFile() && (t = './' + e, s.verbose, a.copyFile(r, t, o[c.extname(e)]));
                            });
                        });
                    }
                },
                {
                    key: 'onSummary',
                    value: function (e, t) {
                        var s = this.linkMapper, o = this.getTemplateData(), a = e.getChildren(), n = this.skipEmpty;
                        this.fillTemplate(e, o, t);
                        var r = this.getWriter(t).writeFile(s.getPath(e));
                        r.write(p(o));
                        r.write(g);
                        a.forEach(function (o) {
                            var a = o.getCoverageSummary(), i = a.isEmpty();
                            if (!n || !i) {
                                var c = i ? S : {
                                    statements: t.classForPercent('statements', a.statements.pct),
                                    lines: t.classForPercent('lines', a.lines.pct),
                                    functions: t.classForPercent('functions', a.functions.pct),
                                    branches: t.classForPercent('branches', a.branches.pct)
                                }, l = {
                                    metrics: i ? y(a) : a,
                                    reportClasses: c,
                                    file: o.getRelativeName(),
                                    output: s.relativePath(e, o)
                                };
                                r.write(C(l) + '\n');
                            }
                        });
                        r.write(b);
                        r.write(f(o));
                        r.close();
                    }
                },
                {
                    key: 'onDetail',
                    value: function (e, t) {
                        var s = this.linkMapper, o = this.getTemplateData();
                        this.fillTemplate(e, o, t);
                        var a = this.getWriter(t).writeFile(s.getPath(e));
                        a.write(p(o));
                        a.write('<pre><table class="coverage">\n');
                        a.write(v(m(e.getFileCoverage(), t)));
                        a.write('</table></pre>\n');
                        a.write(f(o));
                        a.close();
                    }
                }
            ]), s;
        }(d);
        e.exports = P;
    },
    '0781': function (e, t, s) {
        'use strict';
        s('7a0d');
    },
    '0a05': function (e, t) {
        e.exports = require('constants');
    },
    '0b48': function (e, t, s) {
        'use strict';
        s('44a2');
    },
    '0e0e': function (e, t, s) {
        'use strict';
        s('cd21');
    },
    '14c2': function (e, t) {
        e.exports = require('zlib');
    },
    '15c3': function (e, t) {
        e.exports = 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFgAAABYCAMAAABGS8AGAAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAACrUExURUdwTESr/0Wr/0Sp/0Sp/1vF/kSp/1Ot/0ms/0Wp/0Ks/UWt/kuv/ESr/0Wr/zyh90Op/0Sr/0Ws/0aq/0Sq/0as/0Sr/0Sq/0Sq/0Wq/0Sr/wBjvUGm/AFjvkKo/gZow0Op/0Op/0Sr/xB1zkWq/wZpxEar/0Cm/ABlvxF1z0ap/xh81gttyC+U7AttyQVowySK4ANlwDCV7SSL4whsyQBkvwBivQBkvQRowb+LDOIAAAA1dFJOUwDnmsg4AvkGF2QSDgkdWybfNTwsqjJ8w1KPSvnx7bzEzdKX+IRub62r4WL6P7HTlvii+d8cDoKygAAAA9tJREFUWMPtmVtzokAQhSPKDgz3iwiMYBQ1apIyN2b8/79sm2vAYERh94m2tHxovjoeZizm9MPDefEvx10QUEbbFSHB7vjCP1wp/usYUAL9jLKsmnGsrKSb0OD49Tv2Pb8uFcyyL6yhira8M6n3r0uy+YcNKbk3VXZVsOGb0fKO3IyswAH/LjXpxYvLv7wVF8gL/EMzLy3u8OCH5oV8RubRrnavs4qvVIPVuzqZR5ua3pjFbcF5a0neoCoZaaTmQpxCr//6tKnWR4mGKnqlXc3e+KrWmu64ZvNOKjXz6KWy0G6jnrEBQ14Km3mEj9V1Ft9RFc3siHPJvKwFFSPiuCM50HLJCG8I68j9JoPCjYQywcqRfTscdyUzclRSyQhri1N3boW8sFLJSDBKi+MuiuPCimAqoNQJk3R2uO6FmXgBa8Ivtl3cDVygia9JAMaWy1gP3IIMGl0LwAhbark9OoKzPyJGVQsjuHfT/sHJ3eMF48D6WG2VPXIwhESxIdJeTC7XGxUz8ETMN17cFRzn//biJAcX26MXMKuC6QAewAN4AA/gATyAB/AA7h38zx4Kab+PsWdW9PTgXbeix6PCfwL3eByrgFmvN4+yEkxYj4d0SkkJDhilvR3SKQ1ysCHuaZ+xAt3nxzHjsDj1F4TA/likB0gejryvjNK+ohs4/L8ekiNvckj3CGO0n7AJFBLPneIsVnD2tKPmKne/dq0ELGm+81qR3C3QA8qr4ytJECIr5pbbs2oYe38ECYw9t02jmzSw8GaMUdo9NAV1p5mXxhVJ1G35ztMnqw4L7ot5k+vp55PjaxhlgZ4prsKIsB/J9M3BNKNRuBIzJ5JED9aF/Rgx2hB63zJagHf0aDuuhVEemoJkL9Qjytjd6GzKES1DDwRLfBHzWv6WS8n3is4ui/Qxt/WtIuYFyYKhOvZYfyN5D2Ws3YCB5jF3es2bPrYdWBLyd+ItKRN1DeT5c3W4xM7nSg0jobKDPs/1mb1WJ4pUif+RpJlAni1HH8+n34ZXzfMs+Hiej5YJ19QkVBtXYCA7XLjUR/OPt+h0ru2X8Rg7RW8f85G+DDkHuBjVByEy1ibudgWiAT3/c0vN/4wAO3vyturknJv5bPiis7LD8XKp6yN91KqgUdeX49BeOaI/rfn7TRYs0xUdj7PDcDabjdu8xtAY2jbnOaJrWkIDNyHLWAG0unXWnrdarbgWBW2et3a2KmAVLF8Y6KVobWr6rqsexJZ1UFXXNw1NwSD34gwS0JKgKNbUMIxJqzKMqWVpioDly9gcDWyMsdC+sCRdoZbwBF+W/Ms7Kb4Z+hejAijwNBe/BgAAAABJRU5ErkJggg==';
    },
    1643: function (e, t, s) {
        'use strict';
        s('4054');
    },
    1794: function (e, t, s) {
    },
    '18b0': function (e, t, s) {
        'use strict';
        s('d3b7');
        s('159b');
        s('ac91');
        s('abc3');
        s('05ee');
        var o = s('a32b'), a = (o.resolve, s('3631'));
        a.mkdirsSync;
        s('34bb');
    },
    '1c7c': function (e, t, s) {
    },
    '1cc8': function (e, t, s) {
        e.exports = s.p + 'static/img/em_2.2e71ba64.png';
    },
    '1e3a': function (e, t, s) {
        e.exports = s.p + 'static/img/em_4.52bb58d6.png';
    },
    '217d': function (e, t, s) {
        'use strict';
        var o = function () {
            var e = this, t = e._self._c;
            return t('div', {
                staticClass: 'audio-waves',
                class: [
                    e.skinClass,
                    e.size
                ]
            }, [e.animation ? t('div', { staticClass: 'waves-wrapper' }, [
                t('span', {
                    staticClass: 'waves-item waves-animation waves1',
                    class: e.animationTypeClass
                }),
                t('span', {
                    staticClass: 'waves-item waves-animation waves2',
                    class: e.animationTypeClass
                }),
                t('span', {
                    staticClass: 'waves-item waves-animation waves3',
                    class: e.animationTypeClass
                }),
                t('span', {
                    staticClass: 'waves-item waves-animation waves4',
                    class: e.animationTypeClass
                }),
                'large' === e.size ? t('span', {
                    staticClass: 'waves-item waves-animation waves5',
                    class: e.animationTypeClass
                }) : e._e(),
                'large' === e.size ? t('span', {
                    staticClass: 'waves-item waves-animation waves6',
                    class: e.animationTypeClass
                }) : e._e()
            ]) : t('div', { staticClass: 'waves-wrapper' }, [
                t('span', { staticClass: 'waves-item default-bg waves1' }),
                t('span', { staticClass: 'waves-item default-bg waves2' }),
                t('span', { staticClass: 'waves-item default-bg waves3' }),
                t('span', { staticClass: 'waves-item default-bg waves4' }),
                'large' === e.size ? t('span', { staticClass: 'waves-item default-bg waves5' }) : e._e(),
                'large' === e.size ? t('span', { staticClass: 'waves-item default-bg waves6' }) : e._e()
            ])]);
        }, a = [], n = {
            props: {
                animation: {
                    default: false,
                    type: Boolean
                },
                animationType: {
                    default: 'liner',
                    type: String
                },
                size: {
                    default: 'large',
                    type: String
                },
                skin: {
                    default: 'orange',
                    type: String
                }
            },
            computed: {
                skinClass: function () {
                    return console.info('对象函数 skinClass,filePath:renderer/components/Common/AudioWaves.vue'), 'skin-'.concat(this.skin);
                },
                animationTypeClass: function () {
                    return console.info('对象函数 animationTypeClass,filePath:renderer/components/Common/AudioWaves.vue'), 'animation-'.concat(this.animationType);
                }
            }
        }, r = n, i = (s('29df'), s('2877')), c = Object(i.a)(r, o, a, false, null, '1051bd64', null);
        t.a = c.exports;
    },
    '27cf': function (e, t, s) {
    },
    2849: function (e, t) {
        e.exports = require('http');
    },
    '29df': function (e, t, s) {
        'use strict';
        s('5ddf');
    },
    '2be0': function (e, t, s) {
        e.exports = s.p + 'static/img/em_11.f698fa9e.png';
    },
    '2eee': function (e, t) {
        e.exports = 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACwAAAAsCAMAAAApWqozAAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAABjUExURUdwTObm79/j6N7f5t/j593d597j59/j6N/j5+Hj6N7k6eDm6d/k6N7j5+Dj6N/j6ODl6t7j6N/j593q6t/j5+vr69/j6N/j597i6eDj6eDj6Obm5t/j597j597i593h69/j5xE2Z9QAAAAgdFJOUwAL6x77Ft021EJXI0v2X70ZjMkGswKomz9sLhSCmOQ8Fss2KwAAAWFJREFUOMvtldmSgyAQRTFihLgv7TaG8P9fOS0ugFGSVKrmaVpLy/Kgze3mQsh/7MNrEypP4jJWNlxLVxQW6ztZmVifDt2w/PkEDr6DacE57+wjbk/gBoAQdRoHlMdwcViB5hgW0QEbJicTpGyOcrsw5lSDSjrf9PV76T6CkzQPlhgyG86f4Ba2Z9h1lkifdNYwyfeJNBXYacTbc772d9nzLm0nrTN4MUERY72x5j5DEUdwwsJfXt+U4JELplyz16uUd3DAtcH6N1y4LjgFzRIPMxkccGiwhGBLxQ44AoMluAgWaRf4cr9FnopKSMlNFi7rr0iOGYmWTyNhc53RYMmA6qztxEduGQn0ONrTLLljDY3X9nIKsMSZZju6qXMU4zSJlX1gxqw699Vq8oDyoZywwO8mAzhcOFCLVWQZm1vyhWc3WvNr+MLgAXitXEOyvnpjQwCPp2kcvbl9wBR/sU/9ArkPW2rk6DWrAAAAAElFTkSuQmCC';
    },
    '31e5': function (e, t, s) {
    },
    '31ee': function (e, t, s) {
    },
    '32a8': function (e, t, s) {
        e.exports = s.p + 'static/img/em_17.cc58f62b.png';
    },
    '34bb': function (e, t) {
        e.exports = require('electron');
    },
    '352b': function (e, t) {
        e.exports = 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADwAAAA8CAMAAAANIilAAAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAADVUExURUdwTP/////t7f/t7f/t7f/t7f/t7f/t7f/v7//t7f/s7P/s7P/t7f/s7P/t7f/s7P/t7f/t7f/r6//s7P/t7f/r6//r60dwTPloaP/h4f/t7fplZfdjY//m5vBSUv/j4/JZWflgYPo9PflaWv/r6/VeXv/p6exMTPpDQ/uysv/7+/yfn/Q9Pf/29vlSUvlLS/JVVfVERP/x8fRKSviamv/d3f3Ly+9BQf3ExP/v7/uqqvmDg/lubv27u+xGRv3X1/uUlPmiovFvb/h5ef3R0e9hYfWMjE5JdS8AAAAYdFJOUwAD+NHfakyDDhx07Syss47PPsVYflqDAIM328IAAAUASURBVEjHtZcLd6I8EIZrL27v2+22e4QmXORuBQQBAYsKGv//T9pJAoifdXs555uqlZDHd2YSksnJyf9jl7fPFxfPt71voP27U10Ey07v+l9FH0QdTGQv/eEr+O29XqMNfn/72Vh/nlJC1OPUcdKY06c/Lz+B9i5umKBZzAfM5oXJ8JuLD9lfD1wpqVGGJ8wR/eHXP9Gru9rh1WDPVjHH766OB/vnlPXB+eDAcsxunf45Evrvc5ZjvVgP3rF1wcXPf78new9zAu5u5oMjNt/w8bs/EL/isnG0D5C9qyhmU+f8qnfIith52/Ws8mU4GrnLvNq1veWmyOi9wX2k/iTdYJ1w5DIbuXmFdqEnlH7swtcsUR20WrpumNHWLHTdZUd8UNAZe91J1g2kKn1BXTbUMRaWS0HGeujGOxa9pHS6Xe4JC287FqVuZsqbFQhWq41sim6KWnH0JsC47KTPQPhVrWEIcO6KWGiieCsELLrzQfPbCJWgddamGi5MaKxvDqo0xHK68zQVcEgvuTpSX2jKm4T3QTjRaph+iqYsz+lX/jcXwPOqvgciWgJq/eYhhPTlHCa0xzzDcsI59kKJgLN5czlQjRyCbh7QJ1AuNbXuiVBkyoKDCKURaygEWY8QQnUHrQTgqYZ/gBevTJn1JZEp4JxQirA3yWXBjOA7YbSqvQLwo4VFgFX6w9Bzm6dYkJPcyR1ueZ5gAaf5FnFxBLDYgWtlenczcjNMB8cdgcHkhA9RhqDd0YZ6ckyZuuiMwhBCBjoLswze8CliGfIN89RhsRxVJmJmQldBkGUs4+bFGrAZZgY5rkwMJaOytcXOauvE7SWIK8ZRZYQMRdixm0pRiFJtdrSggPQxZUNRkhaOK0lRlIlUtdpyoihHlKnbRCpauLAsgBXJclq4mChHlJnXUtk6GVmgTCTJiprfkyOJGBz+r7KhIqJI27ZnSeEJkayyacJbSQHaOBaztMYNvLQsAm5b1rJpwmuJux3B3O4oi5GnGgi8JC0slhLzO8oaZZNIMFaqdqjsaYYBypbZwHoIPyVJJNRbty2JKNDL6yo/0Zg9TTUg29ay7QoZk+DXok4gVFnTPKrcPJIXsKrkPpWGvkk7MHSoJIi5hROmrHk+LAZ6vRj06DKU+p6nsVFtlcuKWdnCDs2/5nk+LENif7cAiqYH9KTrJQ5HzMIWjixlMgHWo9ttu+OcQQwr2/c9mBLtQNPFHgwW/wbeQhI837dXYmfpPbkGvwXP9oPp1CLt/MTYBMO4TQKxplNgPQG0rjvbDThe2LYdTBeLSBA6z1HHosViGkAn2KzEznZDpXXRsYd2EMxm8yQWDi1ZL2aBPRzajr6/0cEWSzfOVBuOx+PZbLYAs8AkMPhHL2eL2QxuDrWUbsaPvYPN3ZQje8joGYUpqtQ0bQPWjmTzYHPnNGRnuR4zcQ7TSULpBUfH6yXk8JBlBQ2l5QLRbkEwrYUBngaMVQvM2Pv3qqnncz4ypc/pqQTjPpGm0yAYD8d+SRdQ8/1SihdxlMbxyh4GgR34MKq+D1+GY3sbs2E/WsSx8pHPi80axoSOO5A2jA8Ey2bMP8rHunAF30wzVTkO5FBNTdr2UeHKHtAbVvbqzsuQ2YtjssLvEyVzXayzAj8uyryo693PFev1MaE+HjT26WMCP6BQV1klC38P/W8cjXiJ/eWjEXta+KHs8lsnul7v5IPT3F++t0UEiPdniAAAAABJRU5ErkJggg==';
    },
    '35ee': function (e, t) {
        e.exports = 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABgAAAAYBAMAAAASWSDLAAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAAAwUExURUdwTP+rCP+rCP+rCP+rCv+qCP+qCf+rCv+rCP+rCP+rCP+pCP+rCP+rCv+vCv+rChkkFIAAAAAPdFJOUwDzGTz6bY/lt8VO85vhMGrfPZQAAADGSURBVBjTY2BgYGCKKPFtVWAAA6Yj/4HAB8Jb/d8zNWzK/10gNut/N6AgU8r/ACBn/d8HEDEvoND+S2DF1v9/KzDwfAFLMO/fuv8Ag8o3iMRvg3wnhngniMRmBv2vDP0ToBIMnD8Y6hOgEgxsfxn2g4y3/mgANPwLg38AVALEASkD6QAq+w4yACIBMgBoNESCQeUr0FKoBAPQUp4v0RAJPv8DQIf+h0joAh3KsATsEQa++15gj2xDeA7F26gBAgyqK+7goAIAOoxW60CbPMAAAAAASUVORK5CYII=';
    },
    3605: function (e, t, s) {
        e.exports = s.p + 'static/img/icon_flower_l.e1cd1cbd.png';
    },
    3646: function (e, t) {
        e.exports = require('buffer');
    },
    '3c93': function (e, t) {
        e.exports = require('crypto');
    },
    '3ed8': function (e, t, s) {
        'use strict';
        s('aa44');
    },
    '3f62': function (e, t, s) {
        e.exports = s.p + 'static/img/em_13.455b3233.png';
    },
    '3fa5': function (e, t) {
        e.exports = 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEoAAABICAMAAABmxpNIAAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAAMAUExURUdwTOxVlvNLnO1RlPZNpepgmelVjfJIqPllsfNXn/l/tflawepNhutRi/lPwvlNyfdNq/BPkvlLw+pSi/pMx+lRi+lRkfhZr/l5sf9ssfFXmv5Tr/xPyO9PmP+GvP15vOpUkPNrpvlMzf6Du/duqfx3tvZWn/tYwfZKuOtHmv5Qpf9plfFItP+PxPhLxP+GvfdMzuhalO1Gnf2Pw+lOk+9inf+Txf+Fv/1ewf1cxf9ssexim+telu5oo+tbk+xknexXlft0vutgl/50vexkn+tgmetRiflwufpNyvpUpP55vPNuquxbmOxWjvlLwPRurvRttetRlvlNzulfl+tYkOtblfFanPlOsO5moflNtPFsp/1vtPlMxvdwvPlXo/xbo/92xPhzwvtgpfx1wvJNnf1ipf9RqPtYpP90wO5InfJgoe9Ql+pLlvt2xP54yPt3x/9gsvpQrOxmoP+AvvVOo/pQuPBoqfZuuPhRpfdJxP1qqfZWoOlZkvlbo/1mrP15xPNVnPRtse5YmO1Lme1ppv1tre9VmP11vvRHvPlMw/VItfdys/lLvelbl/xlqPVJr/9Yqv59vPxepPtyvflRqfdRn/BFr/+Euf57wfxprulclf6GwPlMu/twt/Jkqf6Dv+5Fpu9EqvZbof95tPJprPpNwfl5tv+Jwe9jo/+Pw/5ztPNqse1Gov9sve5mqPhMuOxZkf50r/12uvtSv+tTkv9ls/dnrvpOvfp1uP5arvVIwPthqPhlqv16uf51uPpRsetFnv55wPlepflSp/FQmelImvFFtv1+t+9fne9oq/FrrvZwt/VKqvNRm/trsvpMx/9xwP9nt/tUqPBqpPdzvulZlvdstPRxrPd3sPBkputUlfJIpf5vr/xlpvRfpfVMpu1enP+LwvdhqP9wuPtYqv9suOpOk/9xvPhpsfZ0rf2BuP5nvvdLyvtavPtZtOtOl/xWxPdNrPFIof2Gvf9qtP1gvetWk/5frelVletWketemfx6tfpOpvVIufdUn+lEo0kDPAgAAAA7dFJOUwAzD2kg/v4GFEhNK36aPaiTKbn25tC3NIp3XKZggb7V5NtxkD9p3oLdq6EC9nzIGo/3ve/5qZHpu+/NQJpOtQAACFxJREFUWMPt13tUk/cZB3BABVEs3i+stdrq2vl27dy6bivhkkAFA4IQoIeLqCFQLkZYLpTJLSCgSCkXESGCYEAmEE2BSmIWSFFuBqEywkUcFxFFMBAoCAhH2fN7QWtQrLXd/uL7BnJOzuFzvs/Dmzd51dTmM5/5/I+zeN0bS7TXLf6lzLr3/vq3wcHBs4PRRe/rvvmq3GLtDct/s23bcr0VT17Btn66//79Bw8e9PcX9RcNsoVs3TdewdnwaWrImHt8fLyHh8dv31qIXtvy9vHr5+/XI6m/n93PLhIK04Qrl/4E9G5JVt7IxZCx+GnLw2PbQmxD32RpaXp63b17A8UDAwPsAXYRGyyr97ReIi35S0ZVVp7zSEjI2NgTa+fGvqrJvLy61NSQEMml7u4B6YAjm81O+8rK6sOFc0q/z72VwUwovT0yMuLnNzZ2CVWLL+irqposKIiMPCQZ6+rq6u7uTpJKHQVpQrFV9Oq5hvwk99Y/TzFLSpF18eJFPz+/S5cu5Z08mZVVUNB76FBbG/XyZVeQuqVSqUAgOGsVHb163RydgGIyyUDdvjNSj1t+zidPVmUV9BYgqY2aGBwc7NqdlDT0uRTVio52Wf2i02IJkmA+co/J7Z7b9XfqIRfvIAlKHYK0ebsnJgZ/4brzSveQ1JEtEAqBclmJzYawj/6Ej8csI5eSe3p6zp+/c+d8fT2TWQWlIKiUu3vw3r2uO13/DbVgW8Kvzrq4fG/75nOlNubmnjqVwSSTTTw9TUw8e3AuJSMhIWtyplSbeyJvb7ArtLry9yR88dDqe/PVs0+JLdBpGP4QKLInynWIJ5OZUDKJWk1L7ry9vC+g1ZWkoSEpG6fMzZ+rtTF3eDiDmQIStCLv89zn5uZ2PSUhIaGkJC/vP3AmoPl4iTAgapUErRyFaWejXRTmtrqq21qae2t4eBiVIpscObIPDz0FQiaXTjo7W+OtqO5IglyZXhaqZa6wtVWd8BOAMqBBIdGEeMRzX1ko/eDB0FBEEUUi57rIVAmsnUflBfNcXQNmWrHTrGDvUEv1nf328HAfUGRiIZQKdaOHhh6EIyVFXlZYKHJ2joyMlKDTKhFtHTDY1eeOAoEQKHNb23dU3sVour6cBHkhkUh0K3Oj030P+kIrtzJ5oUiU11SXKvm6rd2dCmuH8QLwtR9jPyoSKwah1R9UTs/hvuG+hJIcEfE4WACBhCh6GZFoAq3gvSxpo1Kp6GSHUgFJHdI4qYAtFrsoYFe6z1Jb+3L6cnJy5CIRakWkh/pCQun7y+REUXq6c11dcerXEir1Mg4hCt46x2BAcbTCRaFKrZ+mckQihEEr6OVLT6HLicTjQDVFogG7qJd5rrzAwMAA1lDHNWmc4JFQDNasVu+2IKkmp0Zkdpwol+9HI/rul9NBMkOUdbFEApcFHmwqMADCGhqKg7ULxNFoQpVdrQeoBTrF1NTUiORgQejwLBftMatJb6oD6V/tIAU+DnxcG8hisTquDcUdO/YItVKo/gfXt0BiWmJikLUHWaAhqcbMrKnp3j2JRNIFEkzHOXGChVPJQzilgAlVzqutiMpBErLkeC+A5DVmNV8CVZwNl892RD3mnODgVAdqJTgqFv9DoVC5ZC3p7e1t7g1rDrMOC0MYrsHTlwAV58N47QhyCORwHp+gsWismyzUKvkRUNHiD1UuVot7m1uaY+CwDosJ2w3G7j270QOo/OLibElXl3e7N4/H4XBqa2uRxb/ZkRwXhyix4h3VC8PmZhRrC5k19Arb/ST5+dnF2afbbyDIgYOk8loajfYDn5V57UxcciVuqX7sYOubnZot4Gi2loX9aOXLZNnZp0/fOOftXe3g4MCJ4nDKa8tpXnDwM6FWZWXlUbHu7Ctfg5OTk4WThYWTzEKGZ7dMln/1qv/pGzeeSFHhUVHl5eU02mEa/4fMm2eSkz+oPHr06HOf+Judpi0nWTMcM/H390fSOe/q6hkpyqfcR0lT0rz4uAW1Vj53addzQr0i0E+EDI6rEVchwOBQtUN4uENUVJSPj4/yMMSLz+dnJp8B6oOlsz9xMK3NDRAkySwiZNPQVf+Gc+dMkdRp6WAZDq3CwfJBVAUsKzMTai1/7rNLDVuiz2AYGDAaDCJ+zAXTTlMEhVuG2xsbt7aO29jYKJWHlRVeeC2g3td40Yfzn40YCDNoeApduGBgZGRU3dnZaWlpb2lsPNraamPjYwMjVij5/KmpqeQp9Rd+zmtsJiGMgYMREYwIBsP0nOki/YkJgj0EpNHRcbDu3j1QUVHhVTE1lXlmAfZCClPfrg8lGAZwADNtmerr609QCPZce/vGRuPxcdRLCQHsu6mp5dhc34m0t5NICJuJqSmiFn1GmiAQYrlcbtBoI+yrtfWuzYEDUIz/3e+05qTU9BZRKBSwntGM9D8jkSiU2AlCbGxjI95sXDmuRDP+8WVf+tT0tlMQRjHCPVOIEQX1ghehGI6Nj47fRes6AJ2wl1CY9nbuEwvn0AOvRaFMTMRCGkehFrJeNt101DcFcbkz1SgMyiL0REIWgQDr4jYGjeKtPn4L+8nv2thHa4OCcIuCWwxEUfBayLIH6uH43Y/1sFe5AcB0NJ9i6N9A0Ue1SAQu9DIMChp9+O23m9RfSVLDMPU1gAXhFmlmPhKFQCIYQoIePtRcq/GqdzMYpqWzHWGGFC6ukQwNCYZcw2nJbtUC7GfcGmFqK5Zpamra2aG/xn/N5Bu7b9aoYz/zRgtTX6uJtF12KIb4b7tdu3Ytw17ntm3FslU7duDlANyFnB2btF/3HlBjwZodz2TVMo3XlWBnagt11jyFVvyym1PQNLYs0NHR0db6dW6aMfwxn/n8//Nfk0A5vPzDiq8AAAAASUVORK5CYII=';
    },
    4: function (e, t, s) {
        e.exports = s('ce8d');
    },
    4054: function (e, t, s) {
    },
    '41cc': function (e, t, s) {
    },
    '41db': function (e, t) {
        e.exports = require('child_process');
    },
    '42cd': function (e, t) {
        e.exports = require('assert');
    },
    '42cd9': function (e, t) {
        e.exports = require('net');
    },
    '44a2': function (e, t, s) {
    },
    '45d3': function (e, t) {
        e.exports = 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACwAAAAsCAMAAAApWqozAAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAACNUExURUdwTP+yCv/BEP/HEf+7Df/GDf/GEP/JEv+8Dv+/D//DEP/AEP+8Dv/AD//DEP+9D/+9Dv/ED//CEP/CEP/HEf/FAP+6Df+8Dv/AD/+1DP++Df/KEf/DEP++D/+5Df/BEP/DEf/FEv+0DP+3Df+/EP+7Dv+9D/+5Dv/BEP/HEv/OFP/LFP+xC//JEv/JFGldl3UAAAAgdFJOUwAV1ELTCBY2QR35V/pfm91LI8S36ALsqoT4Lg7cj99vR10UGQAAAhhJREFUOMvt1dmyojAQBmCO7KsIBlEUEwMElOH9H286iwiI1rmaq2lurOLzL7qbRdP+17KKKMNV0zR1zURRehPVQ2W5OcdpiyuoUVOle1GXmXXbtq2kblb0cRZtYyzxh+yfBcZj9Dx7Hb/0K5sqPceE60vs6LruTCuO+ts7JpgcVkaKNINnLzHBl9UNHHrQ73i/W7H2kXf5hgn2NqKMjTFWCZYucUdEwUim84ZpyJFYc9xJi+UqG4FrNT/6hrnGPBpXrZw2HFwziJ/jAbAXutaPPE5JAJ7VTIVbaIaHboimd5ZcfKNWWYZLfJn83ZI98nB+IfR2MKd4GB7xqK1UNsmSa+yE0ZHSPh1P2o9BFlFtVqLLvSMEcg0Ydo5G/BC8Gzo1Es5LV533jzCS/rlg+y4wn18nxo0r0Ppo621JaTRJVlfy2k6qTvoBK12f9Rl6JXP9pxtIR1S2GpfP2NZFJlz16Ynvd5ndqSahbNGcH9RbF34YjMZLPMhorndIXEMlrGZQqkbL8f1x30f+rijMwjSLM8E6t5WyWsaYrbYLdh/pkxWmBOdgvac9wdqfd7Weg5zeLVd4cgrfa8/SalHNko8vP8sjOMV4q/biBKwOP78qc97mM9fJmsZAnzFKYIaJLjq6eE0TnL5hawPR7T5JN/yZDOKvr2xUHAaxHH5Tnb/lqhmlnngJbq7mr74IehjGu99/QRD6F9+pv8h/aSu8bghcAAAAAElFTkSuQmCC';
    },
    4600: function (e, t) {
        e.exports = require('timers');
    },
    '480a': function (e, t, s) {
        e.exports = s.p + 'static/img/emoji-nav.001568dd.png';
    },
    '4a45': function (e, t) {
        e.exports = 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAMAAABg3Am1AAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAABXUExURUdwTP////+rCv/////////////////////////////bk//WiP/mtf/+/P/cmP+0I/++QP+5Mv+vFf/z3P/fov/89f/46v/EU//tyv/KY//OcP/Tfv+pCkZRH2EAAAAKdFJOUwAM//+79+OCKLOCvqX1AAABnElEQVRIx5WW2bbDIAhFvZhmFDOP5f+/85LUZQdNjKcvproFRUEhjPIsSR/Sq0eaZLn4Vl5IlBdCWXwhmbyhzA7/K+QtFX8GuDmeiQh/PrzKZYTyGIeMU1EGdhP+FeA44skqEs+/y9wRUVOOblciUnf2DQBoV9s7nalwz8/KQ+t1axjqHOIhnPGaxw17o2/YhrMSBxhrAmWaTAxBQBFtdvFEcxCorAFWSx0GAHwSvVc6E40hCwws9qMhCLo0AFQ23EBtEJgI6sm0N4JnEMCND8VBYMkRmYKAnGoe91SL5ii4YfAAsm/JCEp5BzjOBPCv03gDwMOVY36CbutDgKrJarcC23gJVPtNaKpB7dLrfo/a6QLgg0Rzb9Mj72wHP4T4Oamg3S2b8QTgq0DaF5bhBKiIVk9G4AuLfqAF6D1hmeHjhlhAac0G6sqjlTdCaz19AerYd6BzQWOAxxu41mzSjElki1JDeS4O4yt3pjZVIl4VOdubxJSTVzKOS/eYxxcUkWNkyYouivFlN76ws1d43x/7OAlN77xnbj5//gEIyDXCdC6yKAAAAABJRU5ErkJggg==';
    },
    '4b5d': function (e, t, s) {
        ;
        function a(e) {
            var t = n(e);
            return s(t);
        }
        function n(e) {
            if (!s.o(o, e)) {
                var t = new Error('Cannot find module \'' + e + '\'');
                throw t.code = 'MODULE_NOT_FOUND', t;
            }
            return o[e];
        }
        a.keys = function () {
            return Object.keys(o);
        };
        a.resolve = n;
        e.exports = a;
        a.id = '4b5d';
    },
    '501b': function (e, t, s) {
    },
    '524e': function (e, t, s) {
    },
    '53c1': function (e, t, s) {
    },
    5479: function (e, t, s) {
        e.exports = s.p + 'static/img/em_3.0789b952.png';
    },
    5497: function (e, t, s) {
        e.exports = s.p + 'static/img/em_19.139186c1.png';
    },
    5880: function (e, t) {
        e.exports = Vuex;
    },
    '58cb': function (e, t, s) {
        'use strict';
        s('9b27');
    },
    '5ddf': function (e, t, s) {
    },
    '5f71': function (e, t, s) {
    },
    6060: function (e, t, s) {
        e.exports = s.p + 'static/img/over-show.53e69424.png';
    },
    '609f': function (e, t, s) {
        e.exports = s.p + 'static/img/em_6.c66380ca.png';
    },
    6169: function (e, t, s) {
        e.exports = s.p + 'static/img/em_7.965030f8.png';
    },
    '61c1': function (e, t, s) {
        'use strict';
        s('31ee');
    },
    '62bb': function (e, t, s) {
        e.exports = s.p + 'static/img/em_10.76e6ce92.png';
    },
    '64c2': function (e, t, s) {
        e.exports = s.p + 'static/img/em_12.5a40d8d2.png';
    },
    '6cad': function (e, t, s) {
        'use strict';
        s('7161');
    },
    '6f3a': function (e, t) {
        e.exports = require('url');
    },
    '6f51': function (e, t, s) {
    },
    '6ffc': function (e, t, s) {
        'use strict';
        s('f980');
    },
    '712f': function (e, t, s) {
        'use strict';
        s('6f51');
    },
    7161: function (e, t, s) {
    },
    '75ac': function (e, t, s) {
        e.exports = s.p + 'static/img/em_18.ea6914a2.png';
    },
    7648: function (e, t, s) {
        e.exports = s.p + 'static/img/em_14.80af00b0.png';
    },
    77132: function (e, t, s) {
        'use strict';
        s('1794');
    },
    7960: function (e, t, s) {
        e.exports = s.p + 'static/img/em_9.2dfa3031.png';
    },
    '7a0d': function (e, t, s) {
    },
    '7a10': function (e, t, s) {
    },
    '7a38': function (e, t) {
        e.exports = 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEgAAABICAMAAABiM0N1AAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAAIcUExURUdwTP7lgPO2MPzcaf/ON/vOSP7daPjZVva9NffMTOypIvrMQvHBN/7levrQSPnMRf/kevK9NPrPRumbCu22MPnKQu2zLvrNQ+2tKv7mfvnLQP3mf/3mgeumG/W8MvjHPvnNQe+4MuqeDe2iGO+6NPjTVPnQSPvPSvC+NvzWV+60MO2zLvrOSe6uKuqhFuqhFOytKe+5M//ogvbHQe2lG+eZB+6yLeyuK//lgP3lfu6xJOmfE/jIRf/ogf/nfvvhcumbCv/lfvPHPuujEvnXYPvjeu2pJv3PRvG/OPnLTueXBP3dZP3dXOmXBu+/OOmXBvrNQ/nLQvfKP/zVVeyuKPnORf3jd+mfCffIO/jFOuumDvnJQvnHPuqjDfnKP/S7K++rGfK3J+umFPG0JfO9Lu2pF/O+KvXENe6tGvvXWeiZBuyjE/C0I/3gb+uqEu6oFPG6J+mgDe+xHvC4IfbGN/vUT/vQTfvSTf7lfO+vHP3ke+mbB/rSSe2sFfvUUv7lfvO+L/XBM++0IOymG/fDN/vPSffIOPzYXvbBNu+0He2lFv3fa/3aYv7mgfPAMvzcafvORP3cZ/TDMeuoIO2yGeidCvTBMPvaYe2oIvG7Ku2mEv3hdO61LO2vGP3hcvK9NPfHPvvaZPzXXOysIeqjGO+yLvnOSe6vH+yrJ/jNQeuvLOyvHPvOSO6xK/jJR++5Kf3dbvfIQu+7MvTBQUb9OSIAAABQdFJOUwCxGB8CzzgGEAp55Psv7DNaHL9n+bBrib+L99f3QSdSeEinN82HPV6XkOqLSJhR+Nn+Q6Vb69Ctg9ot3P5pl9/JeOHv+e/xatn5ibe5vWCVmPJuOQAABMRJREFUWMPVmPtTGlcUxw3BIEq0vibGkJiYxKRGMzHRaWvoK7FN7VNQiLhmlJc8dIj4oCPVxYqjWzNAyqNIF2VVXF5xWeAf7LmY38G9/NLL8NvOZ77nfM8999xbU/O/XVJxdTjX1huvVINzO71O/lwFTldavWr9CZ/T1Dm2TkauY3OaG8bSzmP/A2y/apVKlozw2MluH0urWevRoRTX+DEkaIT/GpPzgFMqkSD+Eh6npxMEceSxn8YyTdzc+IFQcix5xNOf4IDqat8TDKEG72nXVZzN1vKeyOc5dnyEp+U4pn1KEComzzmPj2jXFxiCXhEEw+QJ1nnM0y4M0/o44ECG2HFItfdzwYbdalQyWi1DoMh4l1uwaaIGYho4DIoMPPNeFciRtCgY7bZZ+9Ezt1wiEPSMmKaoOMXk1agaXd4bQlurYpry+QAEKYJcu+QCTetSTG/Hjca4GSmyQhUJNK2pU0sZZ6JGH6UlOARyywWZ1tzAUHGdLhb1UQyjLIXmFtIepbXTlFFnWNBFN80rKo6DZGvc3wqoxPYiNWNYSALI+Oc2k2dJiE0j/+rpRQvgmgI4yZO1pYWcEWxTQTfa9fMal1t+6cvLF2mtiuLMWdJisSyh2HzmvIp1jsMmoV0ut9d74/rTCtvJldFi/Mxi0pssyS1DruAzMwznHCWPI36e1iCUtzJh4lquqNt/q9ebgLRgQBWwosqzThJE+fnDkqySsHKsJq44cDabmNfrPZYsyvcmJYPWxo4Cyhr52//ukNbAcrm+K7OJ+4oDpylPYh5IptmTpEE3E0fOjbFOJ1K1GznyvwNhNK0ps/lEA6enEyeeBKASplkIDjQh6/JqNbBWSdJq3Y1E/H6e58tI6j/NpFLBEmnPZEKaYj7YKUxeqf7Arjt/XwXYuNUKysrUuuRRKlUi6UvRJZMGwwxkfBs6HBy48Ftn0SJHRurKtsb6J6n9/ZKovRIpFoU2QE1CfKp0Wp2GvxpI9yspprv93+8HE0DSe1DGDVDicfPKCjOpOl9pNdlS4YaRDnYEPZ7EHmiyIBIUlA9QO5OTOzuAYxsvV37MNdc/h/D0nlJl6hApYDavAA06Att3kS4gFt/sfrkHpGRyaWExGjVu/uMLBALQWtL3L9xT6lpfwm5ZW1va0i0uRufm5jYBpGgRcnwPzu+9NVnWtraWlxcX56JzAbPqhUhI3x12zP9r2rCApmWEigZkih5BB8FjhwMkHRxkl/4CVG7TrLotbC6pdzje6O2mjYNsKAQgn6xd4FHZbXPMn5NCoa1cVPaiTuCg9E0YJE3Z7Rsb2dByTiZrEjpwDdkAVCIdZHMF8yuhHJHtj/A5yJ5dzhWeCR4Ab9ps4ddvEOkgFCv8IPgeKW61hRFoasqezQ3IhoUPkr99BNkt2VjhV4wJ+RcEeg3+A+chzuw/BDkC2+zZTOEezkVbCpxw2KG3T+R6b+EIumtDpCn7SWygC+vi34o4jkQ20/YQ7wHhRwQCTuweHkfcDalOBCcyvc2YF9HntjDitN3BfBmRDiWCwUym7RHuC8twiZPpwH6peRxMgZ5eES6npj6VAVIPNkfSD5hMfRWeezqA81kVnrIkranMk7oqCKoR3xkUVedtDSaJCr/8D+9IH+3OoMZ3AAAAAElFTkSuQmCC';
    },
    '7aac': function (e, t, s) {
    },
    '822a': function (e, t, s) {
        function o(e, t) {
            this.text = e;
            this.origLength = e.length;
            this.offsets = [];
            this.consumeBlanks = t;
            this.startPos = this.findFirstNonBlank();
            this.endPos = this.findLastNonBlank();
        }
        s('ac1f');
        s('466d');
        s('a434');
        ;
        o.prototype = {
            findFirstNonBlank: function () {
                var e, t = -1, s = this.text, o = s.length;
                for (e = 0; e < o; e += 1) {
                    if (!s.charAt(e).match(/[ \f\n\r\t\v\u00A0\u2028\u2029]/)) {
                        t = e;
                        break;
                    }
                }
                return t;
            },
            findLastNonBlank: function () {
                var e, t = this.text, s = t.length, o = t.length + 1;
                for (e = s - 1; e >= 0; e -= 1) {
                    if (!t.charAt(e).match(/[ \f\n\r\t\v\u00A0\u2028\u2029]/)) {
                        o = e;
                        break;
                    }
                }
                return o;
            },
            originalLength: function () {
                return this.origLength;
            },
            insertAt: function (e, t, s, o) {
                o = 'undefined' === typeof o ? this.consumeBlanks : o;
                e = e > this.originalLength() ? this.originalLength() : e;
                e = e < 0 ? 0 : e;
                o && (e <= this.startPos && (e = 0), e > this.endPos && (e = this.origLength));
                var a = t.length, n = this.findOffset(e, a, s), r = e + n, i = this.text;
                return this.text = i.substring(0, r) + t + i.substring(r), this;
            },
            findOffset: function (e, t, s) {
                var o, a, n = this.offsets, r = 0;
                for (a = 0; a < n.length; a += 1) {
                    if (o = n[a], (o.pos < e || o.pos === e && !s) && (r += o.len), o.pos >= e) {
                        break;
                    }
                }
                return o && o.pos === e ? o.len += t : n.splice(a, 0, {
                    pos: e,
                    len: t
                }), r;
            },
            wrap: function (e, t, s, o, a) {
                return this.insertAt(e, t, true, a), this.insertAt(s, o, false, a), this;
            },
            wrapLine: function (e, t) {
                this.wrap(0, e, this.originalLength(), t);
            },
            toString: function () {
                return this.text;
            }
        };
        e.exports = o;
    },
    8292: function (e, t, s) {
    },
    '82d3': function (e, t, s) {
        'use strict';
        s('b618');
    },
    '832e': function (e, t, s) {
    },
    '84c9': function (e, t, s) {
        'use strict';
        s('501b');
    },
    '8bbf': function (e, t) {
        e.exports = Vue;
    },
    '8cad': function (e, t) {
        e.exports = require('util');
    },
    '8e57': function (e, t) {
        e.exports = require('os');
    },
    '909f': function (e, t, s) {
        e.exports = s.p + 'static/img/em_16.5f0faaf1.png';
    },
    9234: function (e, t, s) {
        'use strict';
        s('8292');
    },
    9280: function (e, t, s) {
        'use strict';
        s('c24d');
    },
    '954e': function (e, t) {
        e.exports = 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEIAAABACAMAAACZQlHRAAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAAIoUExURUdwTOuiIO+7QNqBAOiVEuyaFN6HAfezLeaaGP/of/7ogv/xkfzLR+2hHkdwTPi+PN+MBu+wLeuoJt2EAP/ohv/siv/3neCKBPKxLemZFvSxL92FAOucGfWwLPW4NP/nf/7PTvKpJuycGPq+O//cZf/fcP/vkfKpJOGTD/3PS/7zl//STv3hc/31nNyDAPzWZ9uDAPi/OueWEv/uktuDAP/1mt6FAv/ldO+XFv/RTv3daPOpJNuJBP3RTN2DAEdwTO+bHNuDAP3heN+FAP/nh++fGP/vk9+NCv/tjfezMP3ZYv3dbv/bXv/ZXP/bXP/ZWv7RT/m+N//XWP3PTPm5Mvq/Ov3TUvSiG+CFAPzHQvCOBvGSCfzLSfi1LfzJRfzLRfarIvvEPv3NSPKVDPOaEv3WVv7RS/nBO//mfP/eZfeyKfSfF/3TUP3VU/apIP/bYNuDAP/cYv/ZWOmOBf/gbfWmHfKsJ/SeE+iKAt2FAPrDP/3PSviuJfGtLPvFQOWJAv/VVfWhFv3NSv/wkP/jcd6DAP/kdfvHReGHAP/fafGkIPm7NuSGAfe6OPOpJvCVCu2RB/vCO+2OBPGYDPScD/CfHfSxMO2KAvemG+WLBPSYDPewJ/WuJ//qhvOZD//0mPejFv/XVemdGPe3MfS1M+yiHv/2nP3NTfezLP/keOGPCvGbGO2oJP7TVPCnI+yUDPOmHvm3L//qgf/tiv3TWeWUD/OxK//ngTOE2HEAAABMdFJOUwCMDiBc/UUFFSv0FVDzAP5w+vXB/IZ62yO1HY2UdV3HOsuksmhvVkf+6O+Tud6VR/DpTjrkljZ0g7nv1zLTfgDfo+d6IDKzw7PXl9W5Ew/8AAAFRklEQVRYw+2W61MaVxiHjTeM1VnT2FhjTcykk5ikSWPbpPdO79fFyyDgCFaniFhBwBEEVsBx1KDorkYDiqI4LAQRG6xu4N/r+561dlqR9fKhX3Ic/eYzz+/3nnP2FBS8WidfhQ0XzweQ1Tf5hF/OBakPKrWC7evXzk647QlSPmEm+c6ZCVcrLwV9CUFI9r991iJucEEWEBZbsvzbsyHeCnAxSgsWNlv1maLIigOch6WAIAzZkusfngHxXaWflCno5UMzT5Llp59s2ZcBvyfGaFV6wYIa2euy0yJqAwGUSICE3GKZsWWzb5yS8FEq8AKagBwtcmCARn/1u6ciFKdECSEhyOUHjGz5+6chlAQCZE+QHHLLgUb1rROP80LAz3mCMWwCJJoRQTSy+z+ebC63P+WCwVgQitAKKr2caIge2er9/e9vSU2mrP4nnmVZiqUoRptQYQ6altOIIFn2JybuPsrTSeG1mxRFKZVK+KUgRkKl12OdNGhAlKGZSRCZmIhE7l8pzNlAxU3Kyzx9qqRmZ/lZJcNgmYNg0UxjGUgZmrE9AZFIJPL8fo4r5FoTw+A/b22tude2/gSGT4sWej0t0DRtsYgQ2ySGiTx/fuUIoYJStvNrbs5sttt73OGtdiVaqP7AnUXKoMW5/A4egIjkQNwY4XbVRqMDflZWzO4uftYAFkRDoPXIIB7Qhy25Vw0aR6cbLUmn0/O61dVnm0ZAYBLvr1oFarTImy20YBGzgMbk3vpE5NHRKmpCoeHFBcIwqld63JjEixqDuDP02AaMZkiASif71/fv5mjzG9d0yLm4oFlddTg2UYM/KBS2Rgs5Jrg50ATayO7nOrWyyx3TY6HhBY1utXdcbXa7u9rbGC8wTFgH2aLygwM382SvPOdXoehhx/QceMxvPHNsAmOgq50CDagDPA4ZehzKZP8xV0epyzU9DR7zS71Gtd0chigGxoeTJWMhlQBEsEAZxx22OqurAxjp+SUYrLkHNFhgaBWiB5gIcvhDg8X1Y4/IZavLNRcKpZc2HGo1Fw7zIkObUBARQtHjfX78bV72gXWKeCz1OjAKeLRRDCMyBkUIXMZDtovHn/dSq9XqIgzHuNreE87wLDB8KAKTIQsZn+S7MR5YwWNsOJ1eSo2rd3sgC88aDMhQKLATE9rI837Zyh6CRgeJgrsDPDIsMEQRRUKhMJmg2p/zXloPEDEGk9X1pozoMdDFt1EGhkAUCRO2IuT/zEMbLteYExAbsDvUu1w4E4uxFIYBBsmj0lfkv7yJRWhxQXfIGOiKsW0YprsbEFqTQtWQ//qtQYRzoVPzDyPDx7APkkU7ChpX8yMuW60dc2ChSeugjhQgoA8yFy/RGB1VmGRSiKmOOedyZ6dGAxq9RuOuGcbC84bDKIo7Et+Rr8BizLm8CAgNahjtMJYtnm9DDV83WPR9LoGo+9sCNeZ7xUO7RpIw3m7SxccSiC9we6IFInRgofabw+Tgi0FgqvckuqiyTs3NLS8faOD+stu5kUww1mbwwiUGFq33pJ4FGIQgNLoUEvx+/wv/i5EMMMDit9G+Vqk3aClYOJ2AgKkCAQCBeDQaje/swObwdYNEX4UE4vEUCZIGh1QAAPF49OU2rMYoQESGxOaUFaFFOq2DhxLHcSPxaG1V6WePi+tqthsbdy6xTPdo65tS74spvHJEgCdeeaHo8Iav+gFM4OVzR/KN45reTpfAu9fj2am8UPZvfHFt5U5TgySiZvslPBeDQc/r/wEcBC2UfmlVbUP9ntyAE7//4+cEYHHX3issOOeSFbxa/9v6C6HWzMHMyVyFAAAAAElFTkSuQmCC';
    },
    9654: function (e, t, s) {
        'use strict';
        s('31e5');
    },
    '96d9': function (e, t) {
        function s(e) {
            var t = new Error('Cannot find module \'' + e + '\'');
            throw t.code = 'MODULE_NOT_FOUND', t;
        }
        s.keys = function () {
            return [];
        };
        s.resolve = s;
        e.exports = s;
        s.id = '96d9';
    },
    '97e5': function (e, t, s) {
        'use strict';
        s('7a10');
    },
    '9ac2': function (e, t) {
        e.exports = require('stream');
    },
    '9b0f': function (e, t) {
        e.exports = require('fs');
    },
    '9b27': function (e, t, s) {
    },
    '9e3a': function (e, t, s) {
        e.exports = s.p + 'static/img/em_1.9b8121a0.png';
    },
    '9e93': function (e, t, s) {
        e.exports = s.p + 'static/img/em_15.fca415a1.png';
    },
    '9f8f': function (e, t) {
        e.exports = 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADQAAAA0CAMAAADypuvZAAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAABLUExURUdwTP///+Hl6v///+Hl6f///////////////////+3w8+Hl6d/j6ODk6d/j6N/j5+To7Onr7/P19f///9/k6eLm6uTn7Ons79/j519TOaIAAAAYdFJOUwAInRaTFA4aGAQ2reHJ8fxuUScSvIViSJV5UR4AAAGmSURBVEjHnVaLjoQgDFw9haII6una///SA9SzVfHBbDYxhKbTaWn7+RyhMlFCQCky9XkAJUAygLizy0p5gjK78nJqEsyi3oS8gHjpJu5MgbwBHKwy+QA7PZR8BPWO2wnDUj5E+VDriPJKvoA6JVc1Rn9vCe7UbhDRVne6c0cTeuQ3rnYR5Yga0dxExaSD3iB2Bm17LSDPa+sceW/DRYYP7Bq0RYhrlaLNA4qK8uPaTTYopy0W88EXF2iqH6+GwmLjCIz/l9oTI7ET3MngJags4pLgMa/rOq/zCYjoTAdHxvb+Y1ilgOXPlWAn7q5pPLSvCojKx8oOKUb5yKhgRjqaKUbPkWq6GS6/2M15KvyP5onF9J05AbjQvX51OLOLXyBGm+QwkDcB/oX0EtY8WU3rXLAkDUCKMKRqrGeQPAlaRgPabit3jYbGwZ4hLdiJ3uqnPv6gQL4EvOtf2yPc+PVjEcXY8yZW0j4URcN7WEYkj8PsRsfqqr2wMu2umye15aQBkDZq0oZa0vhMG9RpK0Ha8pG25iQuVGmrW+KSuK6jv2Eb/Ymso39yhUyCdLC7GgAAAABJRU5ErkJggg==';
    },
    a027: function (e, t, s) {
        'use strict';
        s('7aac');
    },
    a12d: function (e, t) {
        e.exports = 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAMAAACdt4HsAAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAAMAUExURUdwTP+cJNjIuP+UMf2XQP+iLPi7vf+uLOmUS/uhjEdwTP+bI/+prP7AyPa7vf+jJP+YKP+/x/+aKv+vtf+lI/+cI/56RP+gJP+fK/+rtf/Ax/+pL/1xefp9f/99gP+6w/+1vfWTj/+cL/+RSf+WKf+kJP+xuP/AyftxfUf8lmXZhczFr/9+Tvu6wP+yuNvOv/+RMI3nqc7Ksu+rqlvojf++xqS2hf+YoP+bKF7qkvtufP+hq/+ZLJG9gf+Jk0zzk/+Xm/+vJP+fJP+rsUT9l+HLv/2LNv/Byf+7wf+7wf+bfv+bLv+JKv+xuf+xt/+5wf+zu/+3v/+vt/+1vf+8xP+zuf+/xv+9xf+5v/+dMP+vtf+1u/+3vf+8Ov+ttv+fMv+msP+lrf+rsv+KlP+Vnv+Ol0X/l/+Ejv/AO//RPf99if+iqP/XZv95hP+jrP+dpf+psv+4PP+Hkv+Sm/+ep1T4mv+Zof/SYv+7wf+pr0r9me25tU37mf+rRHfpoGHynf+BjP+Lj/+3OP+ts//GOf+mMeK/tP+yOP+sNf/Byf+9Mf+ao/+cOFz2nOPHvf51f/9/dfS5uvlrdv+zSv+gW0n9l//WQKLYqP/GWP/OXv/AU3Htof53esXJrfuzt37oo7jQrZrZof+3L/+jPfTCw1n0mf97h/99hGfokXvqo2runf/KW/+7T+3BvpHjqeO6sIflpbzGpfm4va3Tqve1tv9yd8zKs/+RTv+xu/+mctG1ov+KZ9jOvnralK/Vreaknf+Ch5zio/18f//Lat7Ctf+3S3T9n+2Ph7vXto77sv+/av+UfLqwhsHRr/WbntfDsvWtsIjjo5DRlv+YYf+yLv+HeG71jYrRk9ejlf2CZ9m8rM7RVv/Be7u/nXHilrDir5Hboc+eif/Ac/2us//FPNOXhP+9Uv/ANJrNmvqGkLG9lv18ifaSlWfxnv+ZUYHTj73nwdenmculj+OZj/+1cNuraO2xSvl2WP+tVKfxu7/ZdP+zk//FgfvJQNetbP+zo9bTz38AAABNdFJOUwBP/P4I/ij+AhEAPdr6+FuI8NOeoywjROgaPtK0hJS3NTr9Gai1zkrophP1jrPiW5jMrnqEbfZJwuo0zbVUz0LDNnDtmcfH1dGDwfe97K5AsQAAB3BJREFUWMPtV2lUU2caBmW5HOWIoqitXXRqp+0Zu0z3zr51ls69uUsSws1C9gAhIQkEvCQkhBAQgyyyKasKQYoCsohRRBGtuwLVapfTjh1araV2prMvdWbe72rPmSCu/3pOH3IO5JDn+Z73+d73u1/Cwr7B1wQRS5cuvUcq9vDz8b+aL04UCqgnH3r2Rezu2DFPrZpfIi5JFAqFqwUCigniP4t/5c7pP3pcr9evaznaJhQKQEBCMVJCrTL+ePmd0b/9i7K2rq69R7vtud1tq3kPFEMSvYH3dQ/eAT3qIXEJQCwWisWDbvfeRADEICWb+3OHjyy7bRTPx5aIgSHkX4lt3c5BMSARPIiIngb7h8tuTX/imaNlsVC4ADkXQPGCutxZwkRQEFIykuU261944Jb2n2lYp3d2j1EyiqJkDEOSpOyAs0wAEolCiRSn1Xucw8tvWgV2X2xJSWLXqRb9jkqpVEqKcEAwOBHoEghRFVAEy+3veDnipukDH+IiRYc67UU4ThAEDcCbXe5KSgAlUSKc9ho/63ju5nyxUCAjRQTdPGF30AQNEjj8Guhs6JNRAvgXSKq1R15+Ykb+fTwf9hst2+xyEV8Bxx1uVx9DUVIRvGPNmo+fmymFKNT1sFc4vzA9/q7Xy7I0L0CwjoCrEoUC0gSn3frCDAIxv4wVCyUMFA4kmuXM/uwMI+dlr3kgHFeuFDGoOJZmM0Yaf3CjwHf3lrVJGNE10yyX7fH8Pj09/cv/ggkUJF7Z4jxFkkifVXl23tgLT/3xn8eOHTvq4BVYS7an4iDw03NyvmR5AZFUti/XVYQC8ho9jd+ZXkPM/Fhh36zfHT58CtXvzfI0/gWxN27btuE4i2IkGZmsrEU/UcR6Oe3IzvunG4gvYYIKhcVx4PCBZvCoGz2Rkw70DfUXt2//NwSHk6g1mTGX3tV72tP4j+KIUAsPlwipoMKiNKuazh2YVGlHKg7mbNxQv72qKi8vbzdNF41JKclq2MdgzwW7/WR96tqfhBpYhQTAglKp7Dm3WTfyFvC31V8Eemtp6W4RXqe375glkFEMMZl1+eR7tbVrw0McRLVBA5A4hGVRGvefO7kb7G8Aemvp7NmvPj0XIqiE+Xgd9pHmskcramtTL80LMfBzvbOhboBAG2bJ0hz5Fyr/4ht5rbNfi0vAoiYJXMQwgrLXnfuCKJ4hEFgbKjCrbLDOHShCO+jNGtl5MD1nW30VLP/bhDAs5lFCRJAMBSfrJudmWuVpPIMEFocMAZw2+MCEvQfahDV6dh7nC2id/TTUCXyCEDFolCjZmHOzUdNYnZqaumXR/2fwa4oMQgAt7gHUg1qIcOPFN1pLH4HPLH8SGhsqoCiBRMbgY7nve8qra1MLz4ZkuApGn2aJAfcE36haz4nj26tal0RgUfE9zgsOESmVSSQSmEWFulf/53JwUHh/iMCjQGNhC3pq+lEbcv5M3YndQ7+Jn6tU0E1uZ/91PsmqOW54uPEMCCwMEZhLe9UKNLpN+ibkwcupVCpOqbTg4L55U25LH/BhC71Kc8Z+/cfVqYVbQjdhLqdWs6wCpqa/ZhDNEsHC30QQRkhEksyhdQ19qE0UFlWWP/P8H6qvFkbHhAoolZwCLCgUdF3NJvr6OYTIJMNAfl3rdjAioBszsjNtH9ZUXb20MrSRv2dUWRQ0zh+gvTWuIpgdni8FOpoh6lBNE/SoOSNbqzOYOq4Wnl087SzxmzkFDuvBMR50wMBtcsA7qYyBp4MADWGwLsAZs7K1mRpDu+mvH62dNszY4517VAqYV4aRklKSLroQ0Lu7B9Ha8GSiKKh+3NkL9jM1tjTTqPVS9LRRDHv2fM2F8UkpxYM/lYv6W5z2fX3QodfD+6RTp9PY8tNM5VUfbVk47TjCXtR90RF4lyYp1K+wIMGiM3Cf/UqXFJ4kahUUf1r/ts2Q326qqEq5tORbNxzINs1nbzp7LWhmYEmaViggRLzS5XZM8nSd5vLw+fatoxXVKSny6PAbT+Qf2myaT2t6VRYvjdheNXoi0Ox4QydnzvBDdGmm/7xnTUGQn42b4ZnygMFgsH3q/CLLaEYtqOI4i0VtsXDjgU+grYF+xir/ir9yxgtVPsDwZuB0tj8jy2g0Ix2Vymz079Hvt+W3v5Unl8uBjPyvnPnR/uBU+1Ta5Q/e1ugytVq/P4OH36/N/OB8u2nIak2BHxApiF4ZMbNAzGPl5aZy01S+QQMaIMID9v1PNaOfWwFyObwKfAtverV45bH1CKBhsIEGD43GMDXV8TertQASsMoLiiN/eotLacKy9ev/Xpq8651ysGHjgfZ9aE1xcQHAWlAcvWTOLa+1WMKrSUnJSUmluyqm0lCoadA2nwMfUFBcvCZyYcRtLsYYFvdaEkJp6a6hiq0m0zu7fL41AGBHRy6YE3b7uzI256VrCkmlyQi+Vp+vdY3P54t8KfzObtpY2OLvX3MB4DWSI5NXLIhbdFdfD+Y9smDFdY0VSxbEzUu42y8JWBgWsWhOeHj44kXQNRh2j981MOzeyd/ga4b/AfZHaqCX9WGYAAAAAElFTkSuQmCC';
    },
    a32b: function (e, t) {
        e.exports = require('path');
    },
    a6c9: function (e, t) {
        e.exports = 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABQAAAAUCAMAAAC6V+0/AAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAABXUExURUdwTP+rCv+rCP+pCP+rCP+rCP+rCP+rCv+rCv+qCv+rCP+rCP+sCv+rCP+sC/+rCP+rCv+qCf+rCv+tAP+rCP+tCP+rCP+pCv+qCP+nCP+rCf+rDP+rCvlNS4gAAAAcdFJOUwBZPO/y69j65Ej3JC9RKjWmZnsPtx7Ry4kadBTPyswQAAAArklEQVQY042QSRaEIAxEo4iAI+Ksdf9zdkCB7l3XKu/nZagi+ltWml9gpCUN1X+zXkHTKKCKzAoFMRJ1EmqKbFKQnS8GnegE6OEpWw1cvriYtXForQFH5IB6DcAt3DuZHgezk+cWRyJsvjewtjvcFf4HyT/MO7DPRKMMH/K3omRqLbNSoAleTIOqfC6W1cuYcmliOyXBQz6Ad1FUCOC1neUDiLazOIBkO6vd6mT7A2AkCruEL1NeAAAAAElFTkSuQmCC';
    },
    aa44: function (e, t, s) {
    },
    ac04: function (e, t) {
        e.exports = 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADwAAAA8CAMAAAANIilAAAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAALxUExURUdwTOpRjvZUqelRjfdKwfBSn/hLyPlarvlSnPZTsPxOyfyDu+xEofRanPBEtPpOwvpPvvVKw+tPh/+LwPVIw/FQk0dwTOpVjf91uvJLnelXlPlMwuxPifNrpe5fmfpxtflMyulMhf5PpfpTuv9PpPd1q+tMlupclv2GvvhWsOtSjupUjf+Bu/9Spv1ututPkP+Fv/1gw+dSi/lMzfVwq/9Yp/tOzelMhf9gq/2Bt/9mrf9Qo/9mrf+Rxe9Cq/9mwf2Hvf+Rw/2JvflQz/lOz/2Lwe1inf9aqexln+tYkflSqO1moetclOxjnflyv/tao+tgl/lMv/JrsOtim+lfmO5Go/13u/pOvPlPr+telf5zuutalP1kpflOt/FrquxgmutVjvlMyftzu+timfx3xu1mpPlNz/Zttvtipv50wvdNrOtOlv97vfdPo/dvuetbl/NGr+tSivp2w/dKxP14yexVlfxfoutel+9XmPlMy/pXpf90v+1Slfx3wflQqv9itfZyvPNIqe9Pl/hytetXl/5aru9fn+lXlOlalPNqrfBopPtutv2EuP+Fv/FIn/+Pw/l0wv16uu1Infpjqv54s/tdpfRHuflYo+9MmvBorf52vfBjpPhqsv9ttf56w/tTvPNrtPxtsf9/wPJeofZVn/Fspu5EqfRwrOpKl/RlqvlMu+9nqvNLpPNOnfhNs/Fmp/lMw/9vv/pUpP5qr/Nuqv1rq+lelfVHvv5zr+tkm/52xP50vf2Au/5er/Z0r/5Uq/lLt/VvsfFTmv1nrO9qpv6IwP1ztf9ir/9otv+LwutVkvZIs/tUsPNYnfdSpPdfpPxcue5cmv1ppvppr/FanOpImvlMxf9xuulSlflwvPtgqPtmrO1opf93uvp6tvFFtvdan/9Sp/dbov+AvelNlPh4se1Nmelclf5+tf1vrP1aqvdSn/p1tfp9uPdusvxawv5tu/VXofVip/9ouv1hv/dru+pRkfJNm/1Wp/9OpftMxRdcWAwAAABIdFJOUwDzQJb+MP4IAxsoUPMl/I/NpK94/VkA/Nv6xXG71GTZXEzuTZUyTbE6EHTPbPNN4+XbpdeH8aWFte2Ty4WLvZfn26m57+l02fQs8ioAAAYGSURBVEjH7dZnVFNnGAdwQEZSEBcePa66FWdrh93TtklAlkkYGgwJSAALKBJASA0GCR6ibAMyZIYVECoEIxEPHJYeSJChKQSZYRoLaNF+6/MmZVW02vZLz/GfnPAlv/t/7r3hva+W1pu8yX8Q04U6m3T0DF4fYvZ8+e6vKFdsFy/Se/lXdT776IcPdm/8dPNydZHBrpXFj3978qSp6QrE1nbxphdSg2Ur71+rax959qyn5/eNm7Fa2LejaGOP65vONDU1URC2tl781vzW8J2+ztrka3V1N2+N3Op51rP7k495sbVpLS0tHQ0TNxsaGiig8w6sns8uu13Tdzw2Wa3PQW7V8XixyuvDw6Ux7e0j5yYaKEjr2hYtet5+HnH7Ql9nZ3Jy/RnQwDt4vCGwzc3NRxhxvSMEQoMdpTDPVrfoeb0sIqLmQl9U5/1kxCF105bJZPZa8k8TCD8VFuZZW+vec1qPmWO3R0SgqckODg73x8bCH9fXRw0NDcUOX0fFTKZlN59PgO5CCiWvqMgpADvnOn+NLODL5eWBFsXFY2MsiUQVGwtnjGw3s5ufSSDYuRdS8qwR/nA23nUbhk6H4svlgYFubsUWxel9UVFq2yxDzZaWp9HcdhQKnLST07FZ1ZjvkI0ik8uh2O2Gm5tbSvpxwBy41M1HZExZL//0zwRUTaFAs35AwKz7ZVhTUyNJj4KZLweybkBY6azjZHIt3OTS3GYGNPP5qNndTj03NH87g7+p4UkkUExmWbBOOp86dSolJYVFJtM4w2mlzQyGTAYXW0r486R9fO4FBByYwV/xaiQqsDQaKxKws3MKi8Ui02rD01o6OhgMZlwvzC2VEtwBa875mOmUxfIkKpXqAQ3CYjk7T2maQ3haGsKMOL6mGeFLuj76gKd/4tslPJWK9hBhNDbglJMsVjktPPxRS2lHTLssDorHpQQpwhT0K5mFDVHvg4cOHBot0uKkJmw2mwa2JTdGJpP1jmdKIe6a5iIfp4Dpe4UxVKqUyoccDucXNtsiUmMtLDw9XZNaOmIA9wIeR1ro7t5FsfbxcdI/Nr2u7FEqlRUVgD09oTASArVsz/BHSR0xEwxZb/d4Y+ZogVQodA/2LuwqK/PRD3hv+mJvAavkVFRWulYirH6j3iQYekKW0d2dOZr546hQKBUGB3cVXioz8dFfMvMDy66oqMiuhHA4rmx1XCtdHyWdz82dkMkaMxobM6tGCwqEwmCht3dXHsLrZ+7z2uyK7OwSpF1TIWx2amqSTVICshkZYKuqClBAo7kvmZiYzFpK388GW+JYYmNjU5mqjs3586g3EWhrK+Cqp0+jL14kkYIFXV2gF836h96SVZKFsKOjTTYcINUmISE/9+rVxMSM0NbWVn//qqqz8fHxBfEkoQDpMpM5a/DaLIijOgkgwSqAhmaE3r0LNijobNDAQHx0NIkkCDaG6iVzVpJ1WdWIV1c7Khyr88HmJybiQkPB+vsjHHR2APQAKZokEHgbG2PnLmFrxYpqdRTVinz0cjELDT14FxLi7+ur1vED0dHRApLAuGv13CVMSw8nxuFwiqm4uLgcpB896ud1OCTE19dXPukByclRDy74AvPX1fN7wGY4MwU0q7UZjn7oqJ+fn1cIF/kguYfHQNsAYJKR6XNYaxtdLEbtaAAczgWHo9P9iH6DYWFciK9c3t8vz2lrayMZzfe0w2wTa7RCcwSc+BCdCBrxEC5Xfkee0w/aSAczHzZdJSKKxdP1qJpoBYMPeg16hYRw5XIPeVuO0dYXPSS3iTQcLh76QyRaWYlEokF1ORcN3q+t88KHs8GCMPiyph190CFEP3vgXlwuHvTelz7dl2uDFhHpRLH6RRdZEaHcfBCa70xOrsK+fGewcGcYaieK6HAEOoxtZQ/YPCwMf2dyAeZv9yA7tMPwIk2s1J/2QA/jqXu3vsoWBrtvBZWKx5uL7CHmELw5Hk9dhcW80v5HS28pcPBToVJX7HiN/dPC/donINQTVPV7p95r7b4wBsuXrjihyd51/2D/ZrBh/741axZswPyLzSNG603+//kD2SqhfEQ8pxQAAAAASUVORK5CYII=';
    },
    aed8: function (e, t, s) {
        'use strict';
        s('27cf');
    },
    b1b7: function (e, t, s) {
        'use strict';
        s('53c1');
    },
    b2dd: function (e, t, s) {
    },
    b56f: function (e, t) {
        e.exports = require('original-fs');
    },
    b618: function (e, t, s) {
    },
    b658: function (e, t) {
        e.exports = require('string_decoder');
    },
    b8a2: function (e, t, s) {
    },
    ba09: function (e, t) {
        e.exports = require('tls');
    },
    bc3f: function (e, t, s) {
    },
    bcb4: function (e, t, s) {
    },
    bcf1: function (e, t, s) {
        'use strict';
        s('c67f');
    },
    bf00: function (e, t, s) {
        'use strict';
        s('1c7c');
    },
    bf30: function (e, t, s) {
        'use strict';
        s('5f71');
    },
    c163: function (e, t) {
        e.exports = 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEgAAABKCAMAAAAv++J+AAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAACoUExURUdwTP/KEv+6Dv/ME/+1DP/AEP/AFf+/Bf/BD//AD/+zC/+2DP/AD//EEP/BD//ADf/BD//LE//FEf/KEv+/D//NFP/PFP////+9D/+/EP/DEf/BEP+7Dv+5Dv/FEv/HEv+3Df/LFP+1DP+zDP/NFP/JFP/JEv+xDP/ML//DLP/IJv/op//99v/rrP/00v/NQf/hjP/UWv/ceP/XZv/34//vwP/BI//NHFo2nloAAAAXdFJOUwDt0dbqX/4HOnD7spMiVBqJsLn58fv9arslNQAABWJJREFUWMPFmGt7ojwQhhEhAtpWe3AREg4q4qnWntz//8/ezOSIYKv75R3cXvmg9z4zmTwJcZwfIvDHQ9f1osjz3OHYD5x/iYdw6M3ni8UcIuJR17U3DB9uowz8ISsYKzCAtFjUixoiGvqD6zGhxxhgGGLw34KzFoLlhYMrMc+MUSZQqKhYwIOkG1CBy3To7ArMToPq2v2t8IMRjSmlhiQkYcWbqNGPou5cGsdAog1Nc1VxC1S7dz+k9RwTQWK0oakT5QWXRN3Hs1mMgZJok6Q5mhTdd3N8jpEgkV2bVDRJtd+ph8wwNCkWpEKX3BKlSB2aAsm5rKmwpk5n12qDu+fZ7JwUN0s+7+inOjqbu4GbzNokS5LMbnGuKXKbUzdK0rRJotiZMbXr1NlPo0aB0oRI0nr3tf/zW3ztTrVGBY3EEi4JSO+/UzD271qUlVyYJ5K0vpLDSRutKdSCeomIlOz+XB07LclTksJMgdIv/o3jKSUyYkIYfPgDH2VS7Ah1qnXJQy0oUyD4r9Zq6igljDeTMQLVmvUGvodWZ0vySZIpTfCFzVmPxxqm+mmBoNrYr1hzjxmEAa0VZxZT7irY4MRed0womhvzHeK+85QZkg0SXsDrA4qa606mZlAPWOrMkDA13eMxEZnhY5GUItPjUO5JZpFQkVktqIl7JmWxmTUmFdk+Drn1MouEIGvdxSCKZyfcl0iSKLbtBR5fZpkVSpFNUi4XU7NNCUV8t9OkwPGrPDckpchYAdaJK8KWkn2wkCBj5LwBxhyUN0FpYqGMzVGmm1OmZnnm2JnkuUUSihKbJOdO1JygPxWqRtqfeLX7eXUOSjWJfwiKItCaqIjaisyO4Dr9ypakFKVvx4+TxMBQKGIw5KjCAglJkef0BChvgt64L31lBNLD4QmTE0NbkT4/ec5TVVmaEJQl2SsMPiE7IoaQHBNDKkFMngvgiSIDyg0oSxSIk3bi1yBJDAuqFJk9uIh4alW10igFgiQOGYJwSOBYwHDIeM21Io3ynH5ZaU25AmXJ9uMzI2LuNh+fOHWcxIfgKFSC9C41n7sSpEgKlBn3lf1EYAHDGQX2OkuR3M5dZ1LJOAMBKbX6SfsTtIEC6TPdfOiMywsgS1MK/TSLla1QYkDKfMeOv1xapHOQpYkoTSo1qu2Xh+8EZVma7OzUtCa7UMIMEBSbEwaD401vWZZdIEBZ2WGXK0kitdi4rwdWW2pNqwpBueZkRpFYeMILSBPEA6w2nBqSAFX5uSSFUv4kUmMxU2UC8394KQ1pj4pyQ2rMXao0rUWN9H4X4UvT43SpSQc4HazXW/2cJCnbbDfbLfzZ8IBFd6BiRwDSo9iykYOk1fH88LJ/BxJZH1qnkSM6FO53xb08RAhJQPrb+sH+yEkdx68DQGKx36lzTTjVmsr1d+sn39tjm/N9Ei0FHh6H+qD115Cq9+PulQf+eUUsYg47K45vRO4s8OiDlhMuJaisytWqXK5WK+lPlSraDhcxtCX/xLrFsUyhOYz2pwpVleXKuEqe5Z+gZ/8Bi44097uZ3KTsk3YwNZosL8irLMvfvveHt7Y/YT9RLos23iJGnLRc2iS9I+R5kuUdTic0UTJqvkP0NaipyT5htDRBpc5eIZw7PnO3kkDRc+uFNHhpaaoukBJtBjHpeNu+n16oeLcmVEU6X0b96fKMtGqhDAg6auZfeDl+uaAp764Tub90exD0ljeQnn+4jbjrT6+tePrTBQJ05pX9REa/3bME1rq7THKvud0Ke79kl/SuvkGyPLOt6VqMuBp7fLnQT4/3g1sv6yaNPRiiN7n1ss5cH076/d7TU6/fn/zr9eH/Fv8B2qjOLnnVdfcAAAAASUVORK5CYII=';
    },
    c216: function (e, t, s) {
    },
    c24d: function (e, t, s) {
    },
    c482: function (e, t, s) {
    },
    c67f: function (e, t, s) {
    },
    c7c9: function (e, t, s) {
        'use strict';
        s('41cc');
    },
    c826: function (e, t, s) {
    },
    c836: function (e, t) {
        e.exports = 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADwAAAA8CAMAAAANIilAAAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAAJ8UExURUdwTP7lvP7rxP/w0P7xzv/10/7owP/szP/3zv/vzv7lvvzqv/3ou/735/7u0P3syf7v2P/35/3vz/3tvf3wyvzvyf3ksv3ww//77P3otf3tu//78/3pt/312//Wxe3h1f3tvf3jt//78v/ruf721v/r1P337f/67f/psf/9+f//7//78//77fvvxf/77//Vw//78f/99//9+f3r1f/59f/32f3ruf399////3g8AP/9+f/99////f/9+/344v3tv/733/756f7xzP//+/713f3z0f356//98/388P/78+FSFv/66f312f3z0/3vw//78f335v7z1f/77f3vyP/99f722//87/3xz/zxzP/34f3wxXo9AP/58//7+P3xyf7z2P714f/JyP/U1Pvz1v3twv3rvP/JXv/MzP311/39+fztvP399v/GvP/55f+/u//16v/56/7x0f7s0P/79f355//48Pvuwfzz0/vvyP/54//Y2P/59v/Pz//v3P/s1f/37f3ktP7y3P3owv705v7y4Pvx0P/Mvv/g3P/Cwv357v3mvP7u2P/Fxf3kuP/9/f39/P/Pv/7v1Pvlsv3tzP7pyv3nvv379v7Kvf//+YlQGvzpuP3ryPvz7fn28v/x44RLE/+2tP/T0f+vrv/SwP/r6P67uP+8up9mOP3rxf7w5/7pzuXXy72cfJBcKehxKcuymf/n4f/Yyd7PwPrf1/Kmlf3tyPO8o/u3VbBsR+h8TO3k3MeHaoJDC59zSP/Pc8SpjvXEseFWHPO1oO2GNeFZH+qMZP/TffKulv/d0dWPePnRx+uTbvW3peuVcPPt6f/bl//jqeNgKu2deMOFaIU2gXUAAAA4dFJOUwBKiwpLFloIBhByl92R1rXpzeDd6fvfubW350z53eHuzc35IHL53VoW3SDZ2dnrueu5crWXIOvlYFsQ0gAABcZJREFUSMftlvlXkmkUx8Mpxa1lKsu20zZTM83eLC+HQDghAbFlYxKIbJK+UHIyfGHEJUlUEHhdX4+KZqYFuGfMtE7ZPjNNs/1Dc5+XmjkH0OzHzun+wOGXz/v93ufe595nxYp38ZZH5tbczQe+2L37s082527NfBMyY9+XFI5T34vFCpHXK+QrN+/LWC761XdsHGfjbOs5KyVWnCgSCrln1u5dFr71I1Clg81mU5RYLKoR8vl27vaVr5f9mgJRnAMR55E4cs7VF+e+RnzVOuqcC7HkYZKkPwDmgS7ic/U8wbr9S7EfHygtdWlxDkkeCpKHyMM0jaS9QiWXK3Vs/2YJ3Q8ba0opLYccCmKAHwKew2EjWoGMCwSm7YtqZ6yz2bw1LnzyIuvqLRJDLNBIW6Hw8sG4wORYvVjeuZELSHlGw2KxpkgSIzHQJ9GxicX0mQmkJkduanbl8LDNNkSF+jWInsAQHQwGOYfh0MQilDUPpFUpK5axY27u2WyNa4alAVozgdH00LUJqB1FAWxXgu9K2fvMFHBWR9/p01VVrVMIZfXjGAR57SKLdTcErQpZI2nwrdqbzDJ39AE8Pv5LXPgeYrEhYFmsScpqhXJBl/GklQ7PhmTp9I6WPhAeuUoLXxyihe+h/6wpUEa+4+ft8aQnwZ93gO2qcQQDPkkL4/0sBF+lYZGQr9cLKk0e1aak+3uZVr4ycpvO+AUNzyBWw5pBpabgeij1xTpQ3ph4vxkdLS2nkfLoDY2m/xrNYlM03G8lUY+KaLjSVFiSVK20yy3osEdGRkevT5Bx9hbNaiaHXjY4DTsKVaq0BPhgwxxKeXx0dHQMexkvaNN3xv11s67/YU9J2ZoEeHVDff2zOYO/otWFYaH5eS2i74Iu67bf76+4FBIrhHZ02jJQ/jQBXttQH7EpKDYnGAz99vzB9ev3AZ6/caf/H7/fUFFRdymCSgV1lnlUZRsS4A8a6pttjaVaTtB1c+Hpr30PHj3FsNYrVW1tbQaDoa7uUq0NOkwvNclKVM6NSXD7cKimFMeDzyWSR49//0vyKBQcu/IfazTOQsqC1PDahvbmC6FSrZZ8LEGxIJHcx8iKtja/wVBRV2c01rby6VtVqCqTJ9peHa1vjjSWwuC8CdzC9MOH0z/CnTK0xTM21tbOKk/yTNCdqjJn4oEdjLbXg2+KIv+WSKZ/OgXRRAaDLiNi64CtHUY3Ugct4pQnliotCr5tXkqLzy9MI/TUE5KOMWPcdISLMnaUgLA8sUlWRqshaSFI4w9o3Z/1QHJwLY4PRcbGInYlKjLqTedxdWJ7ZkajUKyQUAFZm/548uTPEJpduJZtPYKGvt3O5QLrUIGwmkhafGui0fZmfaNXIQJxinq1bs4dQeMLmouHpogHYLV8U/Iw6KGNK2u8RygI3Ip+oaNFohPCo0gXsR6n0yknkofBezt6op26ZiW/yCsWgboYrTiRAi1JNH8QCyU+ri4ntqSYgFmDPdH2JtAWFnlFXpEINjOEEG7xDyehO0weuE5OdZggslKN3hx3T3dne5NAyecLX4XdfgahxXDOHpXTGSMIYn3KncFwuwejHqC53DP2o3y70q6E7QaOi6WV6Ky6nWp5OWFmpF4Z2T53eLC70yRtEui5XL1ef5LHEwikNNqtisWI8oICS/Zii26Xr9fd01PdqdMBT4dUqtPJHLRlNVg2W3YyF1uT+3N8vt7w4GC1p1p2zHRMZ4K2kDlKoKucToJwA5uzavEFvScvEOjtdYdj3SXVZ8+e9cg8haghoSPlRIHFMrB+z1JPg/27zgcCYD4cjsW6YyokCYaPg2MC2J2rln6UMLO7AA/4zG4i7AzH1Gq1XC6Po5Zs5mvfQ4y8811dAd+Ar5coIMohiAIIi2U9YzkPMWZWXhdEYGDAN2A2A4ZiSxZzuW/A9HyEdw0MAG02Wyz56cw3ergy0vLztmzb9m1Ofhojc8W7eMvjX8bTq8gm7H/BAAAAAElFTkSuQmCC';
    },
    c8e4: function (e, t, s) {
    },
    cbde: function (e, t) {
        e.exports = 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACgAAAAoCAMAAAC7IEhfAAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAABRUExURSwsLKlANps+NudMPPlOPv9hUv+ck/9QPv///+9MPHQ4MjouLI88NLtEOMFEONtIOlgyMEIwLv/y8v+7tf90Zv/a1qdANv+JfDQsLP/Nx//d2T1TBhMAAAELSURBVDjLpZXbEoIwDETDpaSlrYBiVf7/Q20cHmwStKP7uHNmQtJNACg0hzi5vndTDDMcamk7fFPXLirmU49MffKSGx0qciPnEh4oFdj9hIc63d/AD1wmK+qy6mPpm2EwpbN35Mt+zdnac0k6rxW+2KyLUnxhc74SeGWTpzdq2ac/CHwws81gh99LY5fzgjUgzhC4NRA4cDdArAMjTNy6EXjj7gSuDnQg0roSuIoMS9AQaCQog71Zu8moy2aU9LyaiVilKAeuK8gn1EvPMhQrBXeVoRAx22g8mxIzHlz7khJcvgpawpO2XMo37stVva71B6D+pNQfKYDmiGt+PaR58Mppbvw/x/7L7+MJbxMn5jpNKiYAAAAASUVORK5CYII=';
    },
    cd21: function (e, t, s) {
    },
    ce8d: function (e, t, s) {
        'use strict';
        s.r(t);
        s('dc5a');
        var o, a = s('56cd'), n = (s('3b18'), s('f64c')), r = (s('2ef0'), s('9839')), i = (s('6ba6'), s('5efb')), c = (s('1273'), s('f2ca')), l = (s('fbd8'), s('55f1')), u = (s('9d5c'), s('a600')), d = (s('fbd6'), s('160c')), m = (s('cd17'), s('ed3b')), h = (s('8fb1'), s('0c63')), p = s('c1f6'), f = (s('c618'), s('8bbf')), v = s.n(f), g = (s('9e1b'), s('d4ec')), C = s('bee2'), b = s('262e'), S = s('2caf'), w = s('1e89'), y = function (e) {
            Object(b.a)(s, e);
            var t = Object(S.a)(s);
            function s() {
                var e = arguments.length > 0 && void 0 !== arguments[0] ? arguments[0] : {};
                return console.info('函数申明 LiveFameWork(opts)', e, 'filePath:renderer/components/Classroom/LargeClass/framework/index.js'), Object(g.a)(this, s), t.call(this, e);
            }
            return Object(C.a)(s, null, [{
                key: 'getInstance',
                value: function (e) {
                    return this.instance || (this.instance = new s(e)), this.instance;
                }
            }]), s;
        }(w.a), P = s('c7eb'), A = s('1da1'), k = s('15fd'), L = s('d0db'), I = s('8c9b'), x = s('e417'), O = ['code'], j = ['code'], T = ['code'], M = ['code'], R = ['code'], E = ['code'], V = ['code'], N = ['code'], D = ['code'], B = ['code'], U = ['code'], G = ['code'], H = function (e) {
            return '[object Function]' === function call() { [native,] }(e);
        }, _ = function () {
            function e(t) {
                console.info('函数申明 LiveLogger(opts)', t, 'filePath:renderer/components/Classroom/LargeClass/base/logger/index.js');
                Object(g.a)(this, e);
                this.initLogger(t);
                this.liveInfo = {};
                this.ircHaveStartSensor = false;
            }
            return Object(C.a)(e, [
                {
                    key: 'initLogger',
                    value: function (e) {
                    }
                },
                {
                    key: 'eventHandler',
                    value: function (e) {
                        'customirc' == e.type && H(this[e.data.logType]) && this[e.data.logType](e.data.logData);
                    }
                },
                {
                    key: 'onLiveInfo',
                    value: function (e) {
                        this.liveInfo = e.liveInfo;
                    }
                },
                {
                    key: 'ircinit',
                    value: function (e) {
                        var t = e.code, s = Object(k.a)(e, O);
                        Object(x.c)({
                            result: 'start',
                            liveInfo: this.liveInfo
                        });
                        this.ircHaveStartSensor = true;
                        0 == t ? this.sendLogger('irc 调用初始化方法成功') : (this.sendLogger('irc 调用初始化方法失败,code: '.concat(t), s, 'error'), Object(x.c)({
                            result: 'fail',
                            errorType: '初始化失败',
                            code: t,
                            liveInfo: this.liveInfo
                        }));
                    }
                },
                {
                    key: 'setLiveInfo',
                    value: function (e) {
                        var t = e.code, s = Object(k.a)(e, j);
                        0 == t ? this.sendLogger('irc 设置直播信息成功') : (this.sendLogger('irc 设置直播信息失败,code: '.concat(t), s, 'error'), Object(x.c)({
                            result: 'fail',
                            errorType: '设置直播信息失败',
                            code: t,
                            liveInfo: this.liveInfo
                        }));
                    }
                },
                {
                    key: 'setSdkProperties',
                    value: function (e) {
                        var t = e.code, s = Object(k.a)(e, T);
                        0 == t ? this.sendLogger('irc 设置配置信息成功') : (this.sendLogger('irc 设置配置信息失败,code: '.concat(t), s, 'error'), Object(x.c)({
                            result: 'fail',
                            errorType: '设置配置信息失败',
                            code: t,
                            liveInfo: this.liveInfo
                        }));
                    }
                },
                {
                    key: 'loginWithMode',
                    value: function (e) {
                        var t = e.code, s = Object(k.a)(e, M);
                        0 == t ? this.sendLogger('irc 调用登录接口成功') : (this.sendLogger('irc 调用登录接口失败,code: '.concat(t), s, 'error'), Object(x.c)({
                            result: 'fail',
                            errorType: '调用登录接口失败',
                            code: t,
                            liveInfo: this.liveInfo
                        }));
                    }
                },
                {
                    key: 'onSDKProvisionStatusNotice',
                    value: function (e) {
                        var t = e.code, s = Object(k.a)(e, R);
                        '[hw_irc_join_room]触发irc调度服务回调'.concat(t);
                        this.ircHaveStartSensor || Object(x.c)({
                            result: 'start',
                            liveInfo: this.liveInfo
                        });
                        this.ircHaveStartSensor = false;
                        0 == t ? this.sendLogger('irc 连接调度服务成功') : (this.sendLogger('irc 连接调度服务失败,code: '.concat(t), s, 'error'), Object(x.c)({
                            result: 'fail',
                            errorType: '调度失败',
                            code: t,
                            liveInfo: this.liveInfo
                        }));
                    }
                },
                {
                    key: 'onLoginResponse',
                    value: function (e) {
                        var t = e.code, s = Object(k.a)(e, E);
                        '[hw_irc_join_room]触发登陆回调'.concat(t);
                        0 == t ? this.sendLogger('irc 登陆回调返回成功') : (this.sendLogger('irc 登陆回调返回失败,code: '.concat(t), s, 'error'), Object(x.c)({
                            result: 'fail',
                            errorType: '登录失败',
                            code: t,
                            liveInfo: this.liveInfo
                        }));
                    }
                },
                {
                    key: 'joinChatRoomsWithJoinMode',
                    value: function (e) {
                        var t = e.code, s = Object(k.a)(e, V);
                        0 === t ? this.sendLogger('irc调用加入房间接口成功') : (this.sendLogger('irc调用加入房间接口失败,code:'.concat(t), s, 'error'), Object(x.c)({
                            result: 'fail',
                            errorType: '调用加入房间接口失败',
                            code: t,
                            liveInfo: this.liveInfo
                        }));
                    }
                },
                {
                    key: 'onNetStatusChanged',
                    value: function () {
                        var e = Object(A.a)(Object(P.a)().mark(function e(t) {
                            var s, o, a;
                            return Object(P.a)().wrap(function (e) {
                                while (1) {
                                    switch (e.prev = e.next) {
                                        case 0:
                                            if (s = t.code, Object(k.a)(t, N), '[hw_irc_join_room]触发网络状态回调'.concat(s), 4 == s) {
                                                e.next = 15;
                                                break;
                                            }
                                            if (o = {
                                                0: '未知',
                                                1: '网络不可用',
                                                2: '服务器连接失败',
                                                3: '服务器连接中',
                                                5: '服务器断开连接'
                                            }, this.sendLogger('irc 网络状态改变,'.concat(o[s]), {}, 3 == s ? 'info' : 'error'), 0 != s && 1 != s && 2 != s) {
                                                e.next = 12;
                                                break;
                                            }
                                            return e.next = 8, Object(I.a)();
                                        case 8:
                                            a = e.sent, Object(x.c)({
                                                result: 'fail',
                                                errorType: '连接失败',
                                                code: s,
                                                msg: ''.concat(a ? '有网络' : '没有网络'),
                                                liveInfo: this.liveInfo
                                            }), e.next = 13;
                                            break;
                                        case 12:
                                            3 == s && (Object(x.c)({
                                                result: 'start',
                                                liveInfo: this.liveInfo
                                            }), this.ircHaveStartSensor = true);
                                        case 13:
                                            e.next = 16;
                                            break;
                                        case 15:
                                            this.sendLogger('irc 网络状态改变,连接成功');
                                        case 16:
                                        case 'end':
                                            return e.stop();
                                    }
                                }
                            }, e, this);
                        }));
                        function t(t) {
                            return console.info('函数申明 onNetStatusChanged(_x)', t, 'filePath:renderer/components/Classroom/LargeClass/base/logger/index.js'), e.apply(this, arguments);
                        }
                        return t;
                    }()
                },
                {
                    key: 'onJoinRoomResponse',
                    value: function (e) {
                        var t = e.code, s = Object(k.a)(e, D);
                        '[hw_irc_join_room]触发加入房间回调'.concat(t);
                        0 == t ? (this.sendLogger('irc 加入房间回调成功'), Object(x.c)({
                            result: 'success',
                            liveInfo: this.liveInfo
                        })) : (this.sendLogger('irc 加入房间回调失败,code: '.concat(t), s, 'error'), Object(x.c)({
                            result: 'fail',
                            errorType: '登录加入房间失败失败',
                            code: t,
                            liveInfo: this.liveInfo
                        }));
                    }
                },
                {
                    key: 'onSendRoomMessageResponse',
                    value: function (e) {
                        var t = e.code, s = Object(k.a)(e, B);
                        0 == t ? Object(x.c)({
                            type: 'message',
                            result: 'success',
                            msg: '群聊'
                        }) : (Object(x.c)({
                            type: 'message',
                            result: 'fail',
                            errorType: '群聊消息发送失败',
                            msg: '群聊',
                            code: t,
                            msgInfo: s
                        }), this.sendLogger('irc 群聊消息发送失败,code: '.concat(t), s, 'error'));
                    }
                },
                {
                    key: 'onSendRoomBinMessageResp',
                    value: function (e) {
                        var t = e.code, s = Object(k.a)(e, U);
                        0 == t ? Object(x.c)({
                            type: 'message',
                            result: 'success',
                            msg: '群聊二进制'
                        }) : (Object(x.c)({
                            type: 'message',
                            result: 'fail',
                            errorType: '群聊二进制消息发送失败',
                            msg: '群聊二进制',
                            code: t,
                            msgInfo: s
                        }), this.sendLogger('irc 发送二进制涂鸦消息失败,code: '.concat(t), s, 'error'));
                    }
                },
                {
                    key: 'onSendPeerMessageResponse',
                    value: function (e) {
                        var t = e.code, s = Object(k.a)(e, G);
                        0 == t ? Object(x.c)({
                            type: 'message',
                            result: 'success',
                            msg: '私聊'
                        }) : (Object(x.c)({
                            type: 'message',
                            result: 'fail',
                            errorType: '私聊消息发送失败',
                            msg: '私聊',
                            code: t,
                            msgInfo: s
                        }), this.sendLogger('irc 发送私聊失败,code: '.concat(t), s, 'error'));
                    }
                },
                {
                    key: 'onKickoutNotice',
                    value: function (e) {
                        this.sendLogger('irc 被其他客户端顶掉:'.concat(JSON.stringify(e)), {}, 'error');
                    }
                },
                {
                    key: 'onRecvRoomMessage',
                    value: function (e) {
                        this.sendLogger('irc 收到群聊消息:'.concat(JSON.stringify(e)));
                    }
                },
                {
                    key: 'onRecvPeerMessage',
                    value: function (e) {
                        this.sendLogger('irc 收到私聊消息:'.concat(JSON.stringify(e)));
                    }
                },
                {
                    key: 'sendLogger',
                    value: function (e) {
                        var t = arguments.length > 1 && void 0 !== arguments[1] ? arguments[1] : {}, s = arguments.length > 2 && void 0 !== arguments[2] ? arguments[2] : 'info';
                        L.a.send({
                            tag: L.b.irc,
                            level: s,
                            content: {
                                msg: e,
                                params: t
                            }
                        });
                    }
                }
            ]), e;
        }(), F = s('5530'), W = (s('d9e2'), s('ac1f'), s('841c'), s('99af'), s('caad'), s('2532'), s('b0c0'), s('d3b7'), s('25f0'), s('832e'), s('9c59')), K = s.n(W), q = s('418d'), z = s('3cd0'), J = s('9277'), Q = s('c342'), Z = s('a5bc'), Y = s('02fc'), X = s('e39c'), $ = s('099c'), ee = function (e) {
            console.info('箭头函数 getProtocolByVideoUrl(url)', e, 'filePath:renderer/components/Classroom/LargeClass/base/initer/utils.js');
            var t = window.PSProtocol;
            if (t) {
                return e.indexOf('.mp4') > 0 ? (console.info('if(url.indexOf(\'.mp4\') > 0)为true触发return,path: /renderer/components/Classroom/LargeClass/base/initer/utils.js'), t.PS_MP4) : e.indexOf('.m3u8') > 0 ? (console.info('if(url.indexOf(\'.m3u8\') > 0)为true触发return,path: /renderer/components/Classroom/LargeClass/base/initer/utils.js'), t.PS_HLS) : void 0;
            }
            console.info('if(!PSProtocol)为true触发return,path: /renderer/components/Classroom/LargeClass/base/initer/utils.js');
        }, te = s('0a4b'), se = s('3898'), oe = s('92e5'), ae = s('5f9e'), ne = s('2b6b'), re = window.location.search, ie = function (e) {
            Object(b.a)(s, e);
            var t = Object(S.a)(s);
            function s() {
                var e, o = arguments.length > 0 && void 0 !== arguments[0] ? arguments[0] : {};
                return console.info('函数申明 WebLive(options)', o, 'filePath:renderer/components/Classroom/LargeClass/base/initer/index.js'), Object(g.a)(this, s), e = t.call(this, o), e.requestParams = {}, e.initModuleParams = {}, e.init(), ae.a.methods.initWebVitals(), e;
            }
            return Object(C.a)(s, [
                {
                    key: 'init',
                    value: function () {
                        var e = Object(A.a)(Object(P.a)().mark(function e() {
                            var t, s, o, a, n, r, i;
                            return Object(P.a)().wrap(function (e) {
                                while (1) {
                                    switch (e.prev = e.next) {
                                        case 0:
                                            return t = new Date().getTime(), e.next = 3, this.initDom();
                                        case 3:
                                            return s = e.sent, this.app = s, e.next = 7, this.getParams();
                                        case 7:
                                            return o = e.sent, L.a.send({
                                                tag: 'init',
                                                content: { msg: '初始化参数:'.concat(JSON.stringify(o)) }
                                            }), J.a.emit('roomMessage', {
                                                space: 'params',
                                                data: o
                                            }), this.requestParams = {
                                                bizId: o.bizId,
                                                planId: o.planId,
                                                courseId: o.classId,
                                                isParentAudition: o.isParent
                                            }, this.initModuleParams = {
                                                planId: o.planId,
                                                courseId: o.classId,
                                                isParentAudition: o.isParent
                                            }, e.next = 14, this.getInfo(o);
                                        case 14:
                                            return a = e.sent, e.next = 18, this.initModule();
                                        case 18:
                                            if (n = e.sent, n) {
                                                e.next = 21;
                                                break;
                                            }
                                            throw Error('initModule接口报错');
                                        case 21:
                                            if (this.hideLoading(t, o.planId), a) {
                                                e.next = 27;
                                                break;
                                            }
                                            return console.info('if(!roomInfo)为true触发return,path: /renderer/components/Classroom/LargeClass/base/initer/index.js'), L.a.send({
                                                tag: 'init',
                                                level: 'error',
                                                content: { msg: '显示失败,原因roomInfo为false' }
                                            }), this.showError(), e.abrupt('return', false);
                                        case 27:
                                            if (this.roomInfo = a, r = a.isPlayBack, L.a.send({
                                                tag: 'userTrack',
                                                content: {
                                                    msg: '大班-学生进入'.concat(1 == r ? '回放' : '直播'),
                                                    tag: 'init'
                                                }
                                            }), r) {
                                                e.next = 34;
                                                break;
                                            }
                                            return i = a.configs.rtcConfig.token, e.next = 34, this.initRtcEngine(i);
                                        case 34:
                                            s.room.style.display = 'block', r || J.a.emit('instance', {
                                                type: 'Player',
                                                index: 0,
                                                options: Object(F.a)({ dom: s.video }, a)
                                            }), r && J.a.emit('instance', {
                                                type: 'Player',
                                                index: 1,
                                                options: Object(F.a)(Object(F.a)({ dom: s.video }, a), {}, { moduleInfo: n })
                                            }), J.a.emit('roomMessage', {
                                                space: 'roomInfo',
                                                data: Object(F.a)(Object(F.a)({}, a), {}, {
                                                    interactionController: s.interactionController,
                                                    interactionFullPage: s.interactionFullPage,
                                                    interactionLeft: s.interactionLeft,
                                                    interactionGame: s.interactionGame
                                                })
                                            }), r || J.a.emit('instance', {
                                                type: 'SignalService',
                                                options: Object(F.a)({}, a)
                                            }), r || J.a.emit('instance', {
                                                type: 'Chat',
                                                options: Object(F.a)(Object(F.a)({}, a), {}, { dom: s.chat })
                                            }), J.a.emit('roomMessage', {
                                                space: 'moduleInfo',
                                                data: n
                                            }), J.a.emit('instance', {
                                                type: 'Room',
                                                index: r,
                                                options: {
                                                    videoGroupDom: s.videoGroup,
                                                    controllerDom: s.controller,
                                                    playBackSignDom: s.playBackSign,
                                                    headerDom: s.headerDom,
                                                    roomModulesDom: s.roomModulesDom,
                                                    roomMessage: {
                                                        roomInfo: a,
                                                        moduleInfo: n
                                                    }
                                                }
                                            }), this.sendLogger({ isPlayBack: r });
                                        case 43:
                                        case 'end':
                                            return e.stop();
                                    }
                                }
                            }, e, this);
                        }));
                        function t() {
                            return console.info('函数申明 init, filePath:renderer/components/Classroom/LargeClass/base/initer/index.js'), e.apply(this, arguments);
                        }
                        return t;
                    }()
                },
                {
                    key: 'getParams',
                    value: function () {
                        var e = Object(A.a)(Object(P.a)().mark(function e() {
                            var t, s;
                            return Object(P.a)().wrap(function (e) {
                                while (1) {
                                    switch (e.prev = e.next) {
                                        case 0:
                                            for (s in (t = K.a.parse(re), t))
                                                /^[0-9]*$/.test(t[s]) && (t[s] = 1 * t[s]);
                                            return window._requestHeadersData = {}, e.abrupt('return', t);
                                        case 4:
                                        case 'end':
                                            return e.stop();
                                    }
                                }
                            }, e);
                        }));
                        function t() {
                            return console.info('函数申明 getParams, filePath:renderer/components/Classroom/LargeClass/base/initer/index.js'), e.apply(this, arguments);
                        }
                        return t;
                    }()
                },
                {
                    key: 'initDom',
                    value: function () {
                        var e = Object(A.a)(Object(P.a)().mark(function e() {
                            var t, s, o, a;
                            return Object(P.a)().wrap(function (e) {
                                while (1) {
                                    switch (e.prev = e.next) {
                                        case 0:
                                            return e.next = 2, Object(se.a)();
                                        case 2:
                                            return t = e.sent, s = t.classroom.modules.systemError || {}, o = '\n      <div class="live-loading" id="liveLoading">\n        <div class="loading-wrapper loading-default">\n          <div class="loading-contenter">\n            <div class="loading-logo"></div>\n            <div class="loading-animation"></div>\n          </div>\n        </div>\n      </div>\n      <div class="live-error" id="liveError" style="display:none;">\n        <div class="notice-wrapper">\n          <div class="message">\n            <div id="liveErrorMainTitle" class="message-main"></div>\n            <p id="liveErrorSubTitle" class="message-sub"></p>\n          </div>\n          <div class="button-wrapper">\n            <a href="javascript:;" class="btn-orange-primary" onclick="window.location.reload();">'.concat(s.refreshButtonName, '</a>\n            <a href="javascript:;" class="btn-orange" onclick="window.location.href = window.location.origin + \'/#/courses\'">').concat(s.backButtonName, '</a>\n          </div>\n        </div>\n      </div>\n      <div class="room" id="room" style="display:none;">\n        <div class="header" id="header"></div>\n        <div class="video" id="video"></div>\n        <div class="controller" id="controller"></div>\n        <div class="video-group" id="videoGroup"></div>\n        <div class="chat" id="chat"></div>\n        <div class="room-modules" id="roomModules"></div>\n      </div>\n      <div class="interaction-controller" id="interactionController"></div>\n      <div class="interaction-full-page" id="interactionFullPage"></div>\n      <div class="interaction-full-left" id="interactionLeft"></div>\n      <div class="interaction-game" id="interactionGame"></div>\n      <div class="play-back-sign" id="playBackSign"></div>\n    '), a = function (e) {
                                                return document.querySelector(e);
                                            }, a('#live').innerHTML = o, e.abrupt('return', {
                                                root: a('#live'),
                                                liveLoading: a('#liveLoading'),
                                                liveError: a('#liveError'),
                                                liveErrorMainTitle: a('#liveErrorMainTitle'),
                                                liveErrorSubTitle: a('#liveErrorSubTitle'),
                                                room: a('#room'),
                                                video: a('#video'),
                                                loadingImg: a('#loading-img'),
                                                interaction: a('#interaction'),
                                                chat: a('#chat'),
                                                videoGroup: a('#videoGroup'),
                                                controller: a('#controller'),
                                                interactionController: a('#interactionController'),
                                                interactionFullPage: a('#interactionFullPage'),
                                                interactionLeft: a('#interactionLeft'),
                                                interactionGame: a('#interactionGame'),
                                                playBackSign: a('#playBackSign'),
                                                headerDom: a('#header'),
                                                roomModulesDom: a('#roomModules')
                                            });
                                        case 8:
                                        case 'end':
                                            return e.stop();
                                    }
                                }
                            }, e);
                        }));
                        function t() {
                            return console.info('函数申明 initDom, filePath:renderer/components/Classroom/LargeClass/base/initer/index.js'), e.apply(this, arguments);
                        }
                        return t;
                    }()
                },
                {
                    key: 'getInfo',
                    value: function () {
                        var e = Object(A.a)(Object(P.a)().mark(function e(t) {
                            var s, o, a, n, r, i, c, l, u, d, m, h, p, f, v, g, C, b, S, w, y, A, k, I, O, j, T, M, R, E, V, N, D, B, U, G, H, _, W, K, q, $, te, se, oe, ae, re, ie, ce, le, ue, de, me, he, pe, fe, ve, ge, Ce, be, Se, we, ye, Pe, Ae, ke, Le, Ie, xe, Oe, je, Te, Me, Re, Ee, Ve, Ne, De, Be, Ue, Ge, He, _e, Fe, We, Ke, qe, ze, Je, Qe, Ze, Ye, Xe, $e, et, tt, st;
                            return Object(P.a)().wrap(function (e) {
                                while (1) {
                                    switch (e.prev = e.next) {
                                        case 0:
                                            return s = 1800, o = 900, a = 0, n = 0, r = 0, e.next = 7, Object(Q.m)(this.requestParams);
                                        case 7:
                                            if (i = e.sent, i && 0 == i.code) {
                                                e.next = 13;
                                                break;
                                            }
                                            return console.info('if(!res || res.code != 0)为true触发return,path: /renderer/components/Classroom/LargeClass/base/initer/index.js'), this.errorTitleObj = {
                                                name: 'courseInformationError',
                                                code: (null === (c = i) || void 0 === c ? void 0 : c.code) || '',
                                                msg: (null === (l = i) || void 0 === l ? void 0 : l.msg) || '',
                                                requestParams: this.requestParams
                                            }, L.a.send({
                                                tag: 'http',
                                                level: 'error',
                                                content: {
                                                    msg: '获取basic接口失败',
                                                    params: this.requestParams,
                                                    res: i
                                                }
                                            }), e.abrupt('return', false);
                                        case 13:
                                            if (0 !== i.code) {
                                                e.next = 40;
                                                break;
                                            }
                                            if (i = i.data, i.planInfo.etime = i.planInfo.endStampTime, i.planInfo.stime = i.planInfo.startStampTime, window.__requestBasicStartTakeClassTime = i.planInfo.startStampTime, window._requestHeadersData.subjectIds = i.planInfo.subjectIds, window._requestHeadersData.gradeIds = i.planInfo.gradeIds, window._requestBasicTime = new Date().getTime(), window._requestBasicEnterServerTime = i.nowTime, (1 * i.nowTime - 1 * i.planInfo.etime > s || 1 == t.playback) && (a = 1), r = i.planInfo.stime - i.nowTime, r < o && (n = 1), u = {
                                                classId: i.stuLiveInfo.classId,
                                                planId: i.stuLiveInfo.planId,
                                                isPlayBack: a,
                                                classType: t.subPlatformType,
                                                isParent: !!t.isParent,
                                                packageId: i.planInfo.packageId,
                                                from: t.from,
                                                lessonType: t.lessonType,
                                                isStartClass: false
                                            }, Object(X.A)(i.planInfo.startStampTime, i.planInfo.endStampTime) && (u.isStartClass = true), Object(x.b)(u), !a) {
                                                e.next = 40;
                                                break;
                                            }
                                            return e.next = 31, Object(Z.d)(this.requestParams);
                                        case 31:
                                            if (d = e.sent, d && 0 === d.code) {
                                                e.next = 37;
                                                break;
                                            }
                                            return console.info('if(!playBackRes || playBackRes.code !== 0)为true触发return,path: /renderer/components/Classroom/LargeClass/base/initer/index.js'), this.errorTitleObj = {
                                                name: 'playbackInformationError',
                                                code: d.code,
                                                msg: d.msg,
                                                requestParams: this.requestParams
                                            }, L.a.send({
                                                tag: 'http',
                                                level: 'error',
                                                content: {
                                                    msg: '无回放信息\uFF0C显示error',
                                                    playBackRes: d,
                                                    requestParams: this.requestParams
                                                }
                                            }), e.abrupt('return', false);
                                        case 37:
                                            m = i.stuInfo.goldNum, d.data.stuInfo.goldNum = m, i = d.data;
                                        case 40:
                                            if (h = {}, p = {}, !a) {
                                                e.next = 76;
                                                break;
                                            }
                                            return f = {
                                                appId: i.configs.appId,
                                                fid: i.configs.fileId,
                                                teacherId: i.teacherInfo.id,
                                                planId: this.requestParams.planId,
                                                bizId: this.requestParams.bizId
                                            }, e.next = 46, Object(Q.s)(f);
                                        case 46:
                                            if (v = e.sent, v && 0 == v.code) {
                                                e.next = 51;
                                                break;
                                            }
                                            return console.info('if(!showVodAddressRes || showVodAddressRes.code != 0)为true触发return,path: /renderer/components/Classroom/LargeClass/base/initer/index.js'), this.errorTitleObj = {
                                                name: 'playbackInterfaceError',
                                                code: (null === v || void 0 === v ? void 0 : v.code) || '',
                                                msg: (null === v || void 0 === v ? void 0 : v.msg) || '',
                                                requestParams: f
                                            }, e.abrupt('return', false);
                                        case 51:
                                            if (g = v.data.result || [], g.length) {
                                                e.next = 57;
                                                break;
                                            }
                                            return console.info('if(!vodAddressResult.length)为true触发return,path: /renderer/components/Classroom/LargeClass/base/initer/index.js'), this.errorTitleObj = {
                                                name: 'playbackSourceIsNull',
                                                url: '',
                                                code: '',
                                                msg: '',
                                                requestParams: f
                                            }, L.a.send({
                                                tag: 'http',
                                                level: 'error',
                                                content: {
                                                    msg: '回放地址列表为空\uFF0C显示error',
                                                    vodAddressResult: g,
                                                    showVodAddressParams: f
                                                }
                                            }), e.abrupt('return', false);
                                        case 57:
                                            if (!g || !g.length) {
                                                e.next = 66;
                                                break;
                                            }
                                            C = 0;
                                        case 59:
                                            if (!(C <= g.length)) {
                                                e.next = 66;
                                                break;
                                            }
                                            if (!g[C].address.includes('.m3u8')) {
                                                e.next = 63;
                                                break;
                                            }
                                            return p = {
                                                address: g[C].address,
                                                protocol: ee(g[C].address)
                                            }, e.abrupt('break', 66);
                                        case 63:
                                            C++, e.next = 59;
                                            break;
                                        case 66:
                                            return b = Object(F.a)({ playbackStatus: 1 }, this.requestParams), e.next = 69, Object(Q.r)(b);
                                        case 69:
                                            if (h = e.sent, h && 0 == h.code) {
                                                e.next = 75;
                                                break;
                                            }
                                            return console.info('if(!playback || playback.code != 0)为true触发return,path: /renderer/components/Classroom/LargeClass/base/initer/index.js'), this.errorTitleObj = {
                                                name: 'playbackStampError',
                                                code: (null === (S = h) || void 0 === S ? void 0 : S.code) || '',
                                                msg: (null === (w = h) || void 0 === w ? void 0 : w.msg) || '',
                                                requestParams: b
                                            }, L.a.send({
                                                tag: 'http',
                                                level: 'error',
                                                content: {
                                                    msg: '无回放打点信息\uFF0C显示error',
                                                    playback: h,
                                                    playbackParams: b
                                                }
                                            }), e.abrupt('return', false);
                                        case 75:
                                            h = h.data;
                                        case 76:
                                            return y = this.requestParams, A = y.bizId, k = y.stuCouId, I = i, O = I.configs, j = void 0 === O ? {} : O, T = I.planInfo, M = void 0 === T ? {} : T, R = I.stuInfo, E = void 0 === R ? {} : R, V = I.counselorInfo, N = void 0 === V ? {} : V, D = I.teacherInfo, B = void 0 === D ? {} : D, U = I.nowTime, G = I.stuLiveInfo, H = I.liveStatus, _ = void 0 === H ? {} : H, W = t.fromtype, K = j.appId, q = j.appKey, $ = j.ircRooms, j.fileId, te = j.videoPath, se = j.stuIrcId, oe = j.mainTeacherVideo, ae = j.counselorTeacherVideo, re = j.reseeding, ie = j.skinType, ce = j.liveTypeId, le = j.ircSwitch, j.protocol, ue = Array.isArray($) ? $ : [$], de = E.userName, me = E.nickName, he = E.id, pe = E.realName, fe = E.goldNum, ve = E.englishName, ge = E.avatar, Ce = E.gradeId, be = E.id, Se = E.id, we = M.id, ye = M.startTime, Pe = M.endTime, Ae = M.stime, ke = M.subjectIds, Le = M.gradeIds, Ie = M.name, xe = M.seriesId, Oe = M.bigImageUrl, je = M.notice, Te = M.visitNum, Me = M.mode, Re = M.pattern, Ee = Object(z.d)(ke), 1 !== Re && 13 !== Re && 3 === A && 2 !== W && J.a.emit('logger', {
                                                type: 'sys',
                                                data: {
                                                    logData: {
                                                        pattern: Re,
                                                        type: 'Error'
                                                    },
                                                    logType: 'ajax'
                                                }
                                            }), Ve = _.streamMode, Ne = G.classId, De = G.teamId, Be = G.courseId, Ue = G.isAudition, Ge = B.id, He = B.name, _e = B.avatar, Fe = B.spellName, We = h, Ke = We.event, qe = We.gotoClassTime, ze = We.streamTime, e.next = 93, Object(Y.f)();
                                        case 93:
                                            return Je = e.sent, Qe = {
                                                mode: Me,
                                                appId: K,
                                                appKey: q,
                                                psId: be.toString(),
                                                password: Se.toString(),
                                                stuName: de,
                                                stuId: he,
                                                planId: we,
                                                isPlayBack: a,
                                                teacherId: Ge,
                                                videoPath: te,
                                                bizId: A,
                                                events: Ke,
                                                teacherName: He,
                                                avatar: _e,
                                                startTime: ye,
                                                endTime: Pe,
                                                subjectName: Ie,
                                                seriesId: xe,
                                                bigImageUrl: Oe,
                                                notice: je,
                                                visitNum: Te,
                                                spellName: Fe,
                                                mainTeacherVideo: oe,
                                                counselorTeacherVideo: ae,
                                                stuCouId: k,
                                                reseeding: re,
                                                classId: Ne,
                                                skinType: ie,
                                                liveTypeId: ce,
                                                nickName: me,
                                                isDisPath: false,
                                                videoFile: p.address || '',
                                                protocol: p.protocol || '',
                                                configs: {
                                                    dispatch: { '2.0': 'videogslb.thethinkacademy.com' },
                                                    log: 'log-live.thethinkacademy.com',
                                                    schoolcode: Je
                                                }
                                            }, Ze = j.ircServer || {}, Ye = {
                                                appId: K,
                                                appKey: q,
                                                psId: be.toString(),
                                                password: Se.toString(),
                                                nick: se,
                                                planId: we,
                                                uid: he || Ge,
                                                roomlist: ue,
                                                liveTypeId: ce,
                                                ircSwitch: le,
                                                confService: Ze.confService || '',
                                                logService: Ze.logService || '',
                                                location: Ze.location || ''
                                            }, L.a.send({
                                                tag: 'irc',
                                                content: { msg: 'ircConfig:'.concat(JSON.stringify(Ye)) }
                                            }), Xe = {
                                                streamMode: Ve,
                                                mode: Me,
                                                bizId: A,
                                                subjectIds: ke,
                                                gradeIds: Le,
                                                goldNum: fe,
                                                realName: pe,
                                                nickName: me,
                                                englishName: ve,
                                                stuName: de,
                                                nick: se,
                                                stuId: he,
                                                roomlist: ue,
                                                isPlayBack: a,
                                                planId: we,
                                                stime: Ae,
                                                gotoClassTime: qe,
                                                streamTime: ze,
                                                psId: be,
                                                imgPath: ge,
                                                classId: Ne,
                                                teamId: De,
                                                skinType: ie,
                                                courseId: Be,
                                                isEnglish: Ee,
                                                ircSwitch: le
                                            }, $e = +new Date(), et = 1000 * U - $e, Object(ne.setTimeOffset)(et), Object(ne.setPlanId)(t, true), tt = 0, [
                                                0,
                                                1,
                                                2
                                            ].includes(t.subPlatformType) && (tt = t.subPlatformType), st = {
                                                planInfo: M,
                                                mode: Me,
                                                stuName: de,
                                                stuId: he,
                                                isPlayBack: a,
                                                planId: we,
                                                nickName: me,
                                                realName: pe,
                                                englishName: ve,
                                                bizId: A,
                                                nowTime: U,
                                                stime: Ae,
                                                stuIRCId: se,
                                                subjectIds: ke,
                                                gradeIds: Le,
                                                roomlist: ue,
                                                goldNum: fe,
                                                classId: Ne,
                                                teamId: De,
                                                stuCouId: k,
                                                skinType: ie,
                                                psId: be,
                                                avatar: _e,
                                                gradeId: Ce,
                                                streamMode: Ve,
                                                isEnglish: Ee,
                                                liveTypeId: ce,
                                                fromType: W,
                                                timeOffset: et,
                                                counselorInfo: N,
                                                teacherInfo: B,
                                                configs: j,
                                                classType: tt,
                                                isAudition: 1 === t.isParent || !!Ue,
                                                isParent: !!t.isParent
                                            }, e.abrupt('return', Object(F.a)(Object(F.a)({
                                                isPlayBack: a,
                                                isLiveStart: n,
                                                countDown: r,
                                                playerOptions: Qe,
                                                ircInitOptions: Ye,
                                                chatOptions: Xe,
                                                commonOption: st
                                            }, i), {}, {
                                                bizId: A,
                                                liveType: t.type,
                                                stuInfo: E
                                            }));
                                        case 107:
                                        case 'end':
                                            return e.stop();
                                    }
                                }
                            }, e, this);
                        }));
                        function t(t) {
                            return console.info('函数申明 getInfo(_x)', t, 'filePath:renderer/components/Classroom/LargeClass/base/initer/index.js'), e.apply(this, arguments);
                        }
                        return t;
                    }()
                },
                {
                    key: 'initModule',
                    value: function () {
                        var e = Object(A.a)(Object(P.a)().mark(function e() {
                            var t, s, o, a;
                            return Object(P.a)().wrap(function (e) {
                                while (1) {
                                    switch (e.prev = e.next) {
                                        case 0:
                                            return e.next = 2, Object(Q.p)(this.initModuleParams);
                                        case 2:
                                            if (t = e.sent, L.a.send({
                                                tag: 'init',
                                                content: { msg: '获取初始化module'.concat(JSON.stringify(t)) }
                                            }), s = {}, 0 !== t.code) {
                                                e.next = 11;
                                                break;
                                            }
                                            for (console.info('if(res.code === 0)为true触发return,path: /renderer/components/Classroom/LargeClass/base/initer/index.js'), o = t.data.plugins, a = 0; a < o.length; a++) {
                                                s[o[a].moduleId] = o[a];
                                            }
                                            return e.abrupt('return', s);
                                        case 11:
                                            return e.abrupt('return', s);
                                        case 12:
                                        case 'end':
                                            return e.stop();
                                    }
                                }
                            }, e, this);
                        }));
                        function t() {
                            return console.info('函数申明 initModule, filePath:renderer/components/Classroom/LargeClass/base/initer/index.js'), e.apply(this, arguments);
                        }
                        return t;
                    }()
                },
                {
                    key: 'sendLogger',
                    value: function () {
                        var e = Object(A.a)(Object(P.a)().mark(function e(t) {
                            var s, o, a, n, r, i;
                            return Object(P.a)().wrap(function (e) {
                                while (1) {
                                    switch (e.prev = e.next) {
                                        case 0:
                                            if (s = t.isPlayBack, !s) {
                                                e.next = 4;
                                                break;
                                            }
                                            return console.info('if(isPlayBack)为true触发return,path: /renderer/components/Classroom/LargeClass/base/initer/index.js'), e.abrupt('return');
                                        case 4:
                                            return o = sessionStorage.getItem('click_popup_enter_classroom'), o && sessionStorage.removeItem('click_popup_enter_classroom'), a = sessionStorage.getItem('click_enter_classroom'), a && sessionStorage.removeItem('click_enter_classroom'), e.next = 10, Object($.b)();
                                        case 10:
                                            return n = e.sent, e.next = 13, Object($.e)();
                                        case 13:
                                            return r = e.sent, i = {
                                                camera_isopen: 'granted' === n ? 1 : 0,
                                                microphone_isopen: 'granted' === r ? 1 : 0
                                            }, e.next = 17, L.a.send({
                                                tag: 'init',
                                                content: {
                                                    msg: '学生进入课堂',
                                                    cameraAccessStatus: i.camera_isopen,
                                                    microphoneAccessStatus: i.microphone_isopen
                                                }
                                            });
                                        case 17:
                                        case 'end':
                                            return e.stop();
                                    }
                                }
                            }, e);
                        }));
                        function t(t) {
                            return console.info('函数申明 sendLogger(_x2)', t, 'filePath:renderer/components/Classroom/LargeClass/base/initer/index.js'), e.apply(this, arguments);
                        }
                        return t;
                    }()
                },
                {
                    key: 'hideLoading',
                    value: function (e, t) {
                        new Date().getTime();
                        L.a.send({
                            tag: 'init',
                            content: { msg: '结束loading状态' }
                        });
                        this.app.liveLoading.style.display = 'none';
                    }
                },
                {
                    key: 'showError',
                    value: function () {
                        var e = Object(A.a)(Object(P.a)().mark(function e() {
                            var t, s, o, a, n, r, i, c, l, u, d, m, h, p, f, v, g, C, b, S;
                            return Object(P.a)().wrap(function (e) {
                                while (1) {
                                    switch (e.prev = e.next) {
                                        case 0:
                                            return e.next = 2, this.getParams();
                                        case 2:
                                            return t = e.sent, s = 'Big Class ' + (1 == t.playback ? 'PlayBack' : 'ClassLiving'), o = this.errorTitleObj, a = o.name, n = o.code, r = o.msg, i = o.requestParams, e.next = 7, Object(oe.a)();
                                        case 7:
                                            return c = e.sent, l = c.uid, e.next = 11, Object(se.a)();
                                        case 11:
                                            u = e.sent, d = u.courses.playback[a] || '', m = n ? ', Code: '.concat(n) : '', h = {
                                                courseInformationError: '/classroom-hub/classroom/student/basic',
                                                playbackInformationError: '/classroom-hub/playback/student/initEntry',
                                                playbackInterfaceError: '/classroom-hub/playback/student/showVodAddress',
                                                playbackStampError: '/classroom-hub/playback/metainfo'
                                            }, p = h[a] || '', f = p ? ', Url: '.concat(p) : '', v = r ? ', Msg: '.concat(r) : '', g = ', Uid: ' + l, C = ', Params: ' + JSON.stringify(i), b = 'Scene: '.concat(s, '. ') + d + m + v + f + g + C, S = u.classroom.modules.systemError || {}, this.app.room.style.display = 'none', this.app.liveError.style.display = 'flex', this.app.liveErrorMainTitle.innerHTML = 'playbackInformationError' === a ? S.noPlaybackMessage : S.message, this.app.liveErrorSubTitle.innerHTML = b;
                                        case 26:
                                        case 'end':
                                            return e.stop();
                                    }
                                }
                            }, e, this);
                        }));
                        function t() {
                            return console.info('函数申明 showError, filePath:renderer/components/Classroom/LargeClass/base/initer/index.js'), e.apply(this, arguments);
                        }
                        return t;
                    }()
                },
                {
                    key: 'initRtcEngine',
                    value: function () {
                        var e = Object(A.a)(Object(P.a)().mark(function e(t) {
                            var s, o, a, n;
                            return Object(P.a)().wrap(function (e) {
                                while (1) {
                                    switch (e.prev = e.next) {
                                        case 0:
                                            return s = window.RTC_COMMON.RtcEngine, e.next = 3, te.nativeApi.getPathByName('userData');
                                        case 3:
                                            o = e.sent, a = ''.concat(o, '/Logs'), L.a.send({
                                                tag: 'init',
                                                content: {
                                                    msg: '大班实例化rtc',
                                                    logsPath: a,
                                                    token: t
                                                }
                                            }), n = new s(t, { logsPath: a }), window.RTC_COMMON.rtcEngine = n, n.on('error', function (e, t) {
                                                console.info('箭头函数 监听 error(code, message)', e, t, 'filePath:renderer/components/Classroom/LargeClass/base/initer/index.js');
                                                L.a.send({
                                                    tag: 'rtc错误',
                                                    level: 'error',
                                                    content: { msg: '错误码\uFF1A'.concat(e, '\uFF0C错误信息\uFF1A').concat(t) }
                                                });
                                            }), n.on('warning', function (e, t) {
                                                console.info('箭头函数 监听 warning(code, message)', e, t, 'filePath:renderer/components/Classroom/LargeClass/base/initer/index.js');
                                                L.a.send({
                                                    tag: 'rtc警告',
                                                    content: { msg: '警告码\uFF1A'.concat(e, '\uFF0C警告信息\uFF1A').concat(t) }
                                                });
                                            });
                                        case 10:
                                        case 'end':
                                            return e.stop();
                                    }
                                }
                            }, e);
                        }));
                        function t(t) {
                            return console.info('函数申明 initRtcEngine(_x3)', t, 'filePath:renderer/components/Classroom/LargeClass/base/initer/index.js'), e.apply(this, arguments);
                        }
                        return t;
                    }()
                }
            ]), s;
        }(q.a), ce = function () {
            var e = this, t = e._self._c;
            return t('div', { staticClass: 'live-main' }, [
                t('div', { staticClass: 'live-ppt' }, [t('PptArea', {
                    ref: 'ppt',
                    attrs: {
                        options: e.commonOption,
                        configs: e.configs,
                        ircconfig: e.ircconfig,
                        isInClass: e.isInClass
                    }
                })], 1),
                t('MediaSecurityAccess', { attrs: { visible: true } }),
                0 == e.classType || 1 == e.classType ? t('LargeClassLiveVideo', {
                    attrs: {
                        options: e.commonOption,
                        rtcConfig: e.configs.rtcConfig
                    },
                    on: { updateLiveState: e.updateLiveState }
                }) : e._e(),
                2 == e.classType ? t('SmallClassLiveVideo', {
                    attrs: {
                        options: e.commonOption,
                        rtcConfig: e.configs.rtcConfig
                    },
                    on: { updateLiveState: e.updateLiveState }
                }) : e._e(),
                t('ScreenThumbnail')
            ], 1);
        }, le = [], ue = function () {
            var e = this, t = e._self._c;
            return t('div', {
                ref: 'ppt-area',
                staticClass: 'ppt-area-container',
                attrs: { id: 'ppt-area-container' }
            }, [
                e.showCanvas && !e.isInClass ? t('div', { staticClass: 'wait-teacher' }, [t('div', { staticClass: 'wait-dialog' }, [t('div', { staticClass: 'notice-content' }, [e._v(' ' + e._s(e.$t('classroom.largeClass.coursewareBoard.classSoonNotice')) + ' ')])])]) : e._e(),
                t('H5Courseware', {
                    ref: 'h5CoursewareMian',
                    attrs: {
                        ircconfig: e.ircconfig,
                        options: e.options
                    },
                    on: {
                        courseWareReady: e.courseWareReady,
                        changePageId: e.changePageId,
                        clear: e.clear
                    }
                }),
                e.showCanvas ? t('white-board-canvas', { ref: 'WhiteBoard' }) : e._e(),
                e.showCanvas ? t('white-board-tools', { ref: 'WhiteBoardTools' }) : e._e(),
                e.showEaxmIframe ? t('div', {
                    ref: 'exam-wrapper',
                    staticClass: 'exam-container'
                }, [t('iframe', {
                    attrs: {
                        id: 'class-examination',
                        src: e.examUrl
                    }
                })]) : e._e()
            ], 1);
        }, de = [], me = (s('907a'), s('986a'), s('1d02'), s('3c5d'), s('1b3b'), s('3d71'), s('c6e3'), s('159b'), s('20bf'), s('e260'), s('ace4'), s('5cc6'), s('9a8c'), s('a975'), s('735e'), s('c1ac'), s('d139'), s('3a7b'), s('d5d6'), s('82f8'), s('e91f'), s('60bd'), s('5f96'), s('3280'), s('3fcc'), s('ca91'), s('25a1'), s('cd26'), s('2954'), s('649e'), s('219c'), s('170b'), s('b39a'), s('72f7'), s('a9e3'), s('5319'), function () {
            var e = this, t = e._self._c;
            return t('div', {
                staticClass: 'h5coursewareContainer',
                class: { topZindex: 'error' === e.coursewareState }
            }, [
                t('NeLoading', { attrs: { visible: 'loading' === e.coursewareState } }),
                t('NeDialog', { attrs: { visible: 'error' === e.coursewareState } }, [
                    t('h3', [e._v('Courseware failed to load')]),
                    t('p', [
                        e._v('Your courseware failed to load.'),
                        t('br'),
                        e._v('Please click "Reload" to try again')
                    ]),
                    t('div', {
                        attrs: { slot: 'footer' },
                        slot: 'footer'
                    }, [t('button', {
                        staticClass: 'button',
                        on: { click: e.reloadCourseWare }
                    }, [e._v('Reload')])])
                ]),
                t('img', {
                    directives: [{
                        name: 'show',
                        rawName: 'v-show',
                        value: e.blackBoardImg,
                        expression: 'blackBoardImg'
                    }],
                    staticClass: 'blackBoardImg',
                    attrs: { src: e.blackBoardImg }
                }),
                t('ShowPhotoWall', {
                    directives: [{
                        name: 'show',
                        rawName: 'v-show',
                        value: e.photoWallImg,
                        expression: 'photoWallImg'
                    }],
                    attrs: {
                        options: e.options,
                        photoWallImg: e.photoWallImg
                    }
                }),
                t('div', {
                    ref: 'h5courseware',
                    staticClass: 'h5courseware',
                    attrs: { id: 'h5CoursewareContent' }
                })
            ], 1);
        }), he = [], pe = s('2909'), fe = (s('b680'), s('b047')), ve = s.n(fe), ge = s('1bff'), Ce = s.n(ge), be = s('ceab'), Se = function () {
            var e = this, t = e._self._c;
            return e.visible ? t('div', {
                staticClass: 'game-courseware-mask-bg',
                class: e.showCover
            }, [e._m(0)]) : e._e();
        }, we = [function () {
            var e = this, t = e._self._c;
            return t('div', { staticClass: 'loading-contenter' }, [
                t('div', { staticClass: 'loading-logo' }),
                t('div', { staticClass: 'loading-animation' })
            ]);
        }], ye = {
            name: 'NeLoading',
            props: {
                visible: {
                    type: Boolean,
                    default: false
                },
                cover: {
                    type: Boolean,
                    default: true
                }
            },
            computed: {
                showCover: function () {
                    return console.info('对象函数 showCover,filePath:renderer/components/Classroom/LargeClass/base/players/components/h5courseware/loading/index.vue'), this.cover ? '' : 'no-mask';
                }
            }
        }, Pe = ye, Ae = (s('82d3'), s('2877')), ke = Object(Ae.a)(Pe, Se, we, false, null, '588dbd9d', null), Le = ke.exports, Ie = function () {
            var e = this, t = e._self._c;
            return e.visible ? t('div', { staticClass: 'game-courseware-mask-bg' }, [t('div', { staticClass: 'dialog-contenter' }, [
                t('div', { staticClass: 'ne-dialog--body' }, [e._t('default')], 2),
                e.$slots.footer ? t('div', { staticClass: 'ne-dialog--footer' }, [e._t('footer')], 2) : e._e()
            ])]) : e._e();
        }, xe = [], Oe = {
            name: 'NeLoading',
            props: {
                visible: {
                    type: Boolean,
                    default: false
                }
            }
        }, je = Oe, Te = (s('aed8'), Object(Ae.a)(je, Ie, xe, false, null, '3a8d0640', null)), Me = Te.exports, Re = function () {
            var e = this, t = e._self._c;
            return t('div', {
                ref: 'showPhotoWall',
                staticClass: 'showPhotoWall'
            }, [
                t('NeLoading', {
                    attrs: {
                        visible: e.photoLoading,
                        cover: false
                    }
                }),
                e.photoLoading ? e._e() : t('img', {
                    ref: 'photoImg',
                    attrs: { src: e.photoWallImg }
                })
            ], 1);
        }, Ee = [], Ve = s('b795'), Ne = s.n(Ve), De = s('954e'), Be = s.n(De), Ue = s('a12d'), Ge = s.n(Ue), He = s('ac04'), _e = s.n(He), Fe = s('0555'), We = s.n(Fe), Ke = s('3605'), qe = s.n(Ke), ze = s('7a38'), Je = s.n(ze), Qe = s('3fa5'), Ze = s.n(Qe), Ye = {
            name: 'showPhotoWall',
            data: function () {
                return { photoLoading: true };
            },
            props: {
                photoWallImg: {
                    type: String,
                    default: ''
                },
                options: {
                    type: Object,
                    default: {}
                }
            },
            components: { NeLoading: Le },
            methods: {
                handlePhotoWall: function (e) {
                    var t = this;
                    console.info('对象函数 handlePhotoWall(imgUrl)', e, 'filePath:renderer/components/Classroom/LargeClass/base/players/components/h5courseware/showPhotoWall.vue');
                    this.photoLoading = true;
                    !this.options.isAudition && this.createLikeContainer();
                    var s = new Image();
                    s.src = e;
                    s.onload = function () {
                        var e = document.getElementById('photoWallLikeContainer');
                        e && (e.style.display = 'block');
                        t.photoLoading = false;
                    };
                },
                createLikeContainer: function () {
                    return Object(A.a)(Object(P.a)().mark(function e() {
                        var t, s;
                        return Object(P.a)().wrap(function (e) {
                            while (1) {
                                switch (e.prev = e.next) {
                                    case 0:
                                        if (console.info('对象函数 createLikeContainer,filePath:renderer/components/Classroom/LargeClass/base/players/components/h5courseware/showPhotoWall.vue'), t = document.getElementById('photoWallLikeContainer'), !t) {
                                            e.next = 5;
                                            break;
                                        }
                                        return console.info('if(likeContainer)为true触发return,path: /renderer/components/Classroom/LargeClass/base/players/components/h5courseware/showPhotoWall.vue'), e.abrupt('return');
                                    case 5:
                                        s = document.createElement('div'), s.setAttribute('id', 'photoWallLikeContainer'), s.setAttribute('class', 'photoWallLikeContainer'), s.innerHTML = '<div class="likeBtn" id="likeBtn">\n        <img src="'.concat(Ze.a, '" id="heart" />\n      </div>'), document.getElementById('interactionLeft').appendChild(s), Ne.a.init({
                                            icons: [
                                                qe.a,
                                                Be.a,
                                                Ge.a,
                                                _e.a,
                                                Je.a,
                                                We.a
                                            ],
                                            btnDom: 'likeBtn',
                                            flyDom: 'photoWallLikeContainer',
                                            className: 'fly',
                                            width: 200,
                                            height: 600
                                        });
                                    case 11:
                                    case 'end':
                                        return e.stop();
                                }
                            }
                        }, e);
                    }))();
                },
                destroyLike: function () {
                    return Object(A.a)(Object(P.a)().mark(function e() {
                        var t;
                        return Object(P.a)().wrap(function (e) {
                            while (1) {
                                switch (e.prev = e.next) {
                                    case 0:
                                        console.info('对象函数 destroyLike,filePath:renderer/components/Classroom/LargeClass/base/players/components/h5courseware/showPhotoWall.vue'), t = document.getElementById('photoWallLikeContainer'), t && t.parentNode.removeChild(t), Ne.a.destroy();
                                    case 4:
                                    case 'end':
                                        return e.stop();
                                }
                            }
                        }, e);
                    }))();
                }
            },
            beforeDestroy: function () {
                console.info('对象函数 beforeDestroy,filePath:renderer/components/Classroom/LargeClass/base/players/components/h5courseware/showPhotoWall.vue');
                this.destroyLike();
            },
            watch: {
                photoWallImg: function (e) {
                    console.info('对象函数 photoWallImg(val)', e, 'filePath:renderer/components/Classroom/LargeClass/base/players/components/h5courseware/showPhotoWall.vue');
                    e ? this.handlePhotoWall(e) : this.destroyLike();
                }
            }
        }, Xe = Ye, $e = (s('db99'), s('d871'), Object(Ae.a)(Xe, Re, Ee, false, null, 'a369118a', null)), et = $e.exports, tt = s('c5ee'), st = {
            props: [
                'ircconfig',
                'playback',
                'options'
            ],
            data: function () {
                return {
                    coursewareInfo: null,
                    coursewarePlayer: null,
                    coursewareState: 'loading',
                    blackBoardImg: null,
                    photoWallImg: null,
                    localUrl: null,
                    coursewareStartLoadTime: 0,
                    pageId: 0,
                    currentCourseWareData: {}
                };
            },
            components: {
                NeLoading: Le,
                NeDialog: Me,
                ShowPhotoWall: et
            },
            created: function () {
                var e = this;
                return Object(A.a)(Object(P.a)().mark(function t() {
                    var s, o, a, n, r, i;
                    return Object(P.a)().wrap(function (t) {
                        while (1) {
                            switch (t.prev = t.next) {
                                case 0:
                                    return s = Object(X.o)('planId'), t.next = 3, te.nativeApi.getClientInfo();
                                case 3:
                                    return o = t.sent, a = o.CW_SERVER_ADDRESS, n = o.CW_WEBROOT, t.next = 8, Object(be.b)(1 * s);
                                case 8:
                                    if (r = t.sent, 0 === r.code) {
                                        t.next = 14;
                                        break;
                                    }
                                    return console.info('if(courseware.code !== 0)为true触发return,path: /renderer/components/Classroom/LargeClass/base/players/components/h5courseware/index.vue'), e.coursewareState = 'error', e.sendLogger('error', '接口返回错误,'.concat(JSON.stringify(r))), t.abrupt('return');
                                case 14:
                                    if (0 !== r.data.list.length) {
                                        t.next = 19;
                                        break;
                                    }
                                    return console.info('if(courseware.data.list.length === 0)为true触发return,path: /renderer/components/Classroom/LargeClass/base/players/components/h5courseware/index.vue'), e.coursewareState = 'error', e.sendLogger('error', '接口返回课件为空'), t.abrupt('return');
                                case 19:
                                    if (r.data.list.forEach(function (t) {
                                        16 == t.id && (e.coursewareInfo = t);
                                    }), e.coursewareInfo) {
                                        t.next = 25;
                                        break;
                                    }
                                    return console.info('if(!_this.coursewareInfo)为true触发return,path: /renderer/components/Classroom/LargeClass/base/players/components/h5courseware/index.vue'), e.coursewareState = 'error', e.sendLogger('error', '没有主讲课件'), t.abrupt('return');
                                case 25:
                                    if (2 === e.coursewareInfo.detail.compressState) {
                                        t.next = 30;
                                        break;
                                    }
                                    return console.info('if(_this.coursewareInfo.detail.compressState !== 2)为true触发return,path: /renderer/components/Classroom/LargeClass/base/players/components/h5courseware/index.vue'), e.coursewareState = 'error', e.sendLogger('error', '课件没有同步完成,status:'.concat(e.coursewareInfo.detail.compressState)), t.abrupt('return');
                                case 30:
                                    return t.next = 32, Object(tt.a)(e.coursewareInfo.detail.baseZipUrl, e.coursewareInfo.detail.baseZipMd5, n);
                                case 32:
                                    i = t.sent, e.localUrl = i ? ''.concat(a).concat(e.coursewareInfo.detail.catalog, '/index.html') : '', e.initCoursewareParams = {
                                        role: 'student',
                                        screenWidth: '100%',
                                        screenHeight: '100%',
                                        itsId: e.coursewareInfo.detail.id,
                                        localUrl: e.localUrl,
                                        remoteUrl: [e.coursewareInfo.detail.compressIndexUrl].concat(Object(pe.a)(e.coursewareInfo.detail.compressIndexUrlSpareList)),
                                        onEvent: e.onEvent.bind(e),
                                        showPagePercent: 30,
                                        gameTip: e.$t('classroom.largeClass.coursewareBoard.gameConfig.gameTip'),
                                        gameToast: e.$t('classroom.largeClass.coursewareBoard.gameConfig.gameToast'),
                                        getLatestItsMessage: function () {
                                            var e = Object(A.a)(Object(P.a)().mark(function e(t) {
                                                var s;
                                                return Object(P.a)().wrap(function (e) {
                                                    while (1) {
                                                        switch (e.prev = e.next) {
                                                            case 0:
                                                                try {
                                                                    s = s && JSON.parse(s);
                                                                    t(s);
                                                                } catch (o) {
                                                                    console.error('error latest message', s);
                                                                }
                                                            case 1:
                                                            case 'end':
                                                                return e.stop();
                                                        }
                                                    }
                                                }, e);
                                            }));
                                            function t(t) {
                                                return console.info('函数申明 getLatestItsMessage(_x)', t, 'filePath:renderer/components/Classroom/LargeClass/base/players/components/h5courseware/index.vue'), console.info('函数申明 getLatestItsMessage(_x)', t, 'filePath:renderer/components/Classroom/LargeClass/base/players/components/h5courseware/index.vue'), e.apply(this, arguments);
                                            }
                                            return t;
                                        }(),
                                        getAllStoredData: e.getAllStoredData.bind(e)
                                    }, e.$nextTick(function () {
                                        e.coursewarePlayer = Ce.a.getPlayer('student', e.$refs.h5courseware);
                                        e.sendLogger('开始初始化课件');
                                        e.coursewarePlayer.init(e.initCoursewareParams);
                                    }), e.coursewareStartLoadTime = new Date().getTime();
                                case 37:
                                case 'end':
                                    return t.stop();
                            }
                        }
                    }, t);
                }))();
            },
            mounted: function () {
                var e = this;
                this.$nextTick(function () {
                    e.$bus.$on('liveRefresh', function () {
                        console.info('箭头函数 监听 liveRefresh,filePath:renderer/components/Classroom/LargeClass/base/players/components/h5courseware/index.vue');
                        e.reloadCourseWare();
                    });
                    te.nativeApi.setWindowAble('maximize', true);
                    te.nativeApi.setWindowAble('fullscreen', true);
                    te.nativeApi.setFullScreen(true);
                });
            },
            methods: {
                reloadCourseWare: function () {
                    console.info('对象函数 reloadCourseWare,filePath:renderer/components/Classroom/LargeClass/base/players/components/h5courseware/index.vue');
                    this.coursewarePlayer.init(this.initCoursewareParams);
                },
                onEvent: function (e, t) {
                    switch (console.info('对象函数 onEvent(event, data)', e, t, 'filePath:renderer/components/Classroom/LargeClass/base/players/components/h5courseware/index.vue'), e) {
                        case 'error':
                            this.handleError(t);
                            break;
                        case 'loadingProgress':
                            this.handleLoadingProgress(t);
                            break;
                        case 'statusChange':
                            this.handleStatusChange(t);
                            break;
                    }
                },
                handleError: function () {
                    console.info('对象函数 handleError,filePath:renderer/components/Classroom/LargeClass/base/players/components/h5courseware/index.vue');
                    this.coursewareState = 'error';
                    this.$emit('courseWareReady', false);
                    this.sendLogger('error', 'iframe 加载错误');
                },
                handleLoadingProgress: function (e) {
                    L.a.send({
                        tag: 'courseware',
                        content: {
                            msg: '课件加载中',
                            data: e
                        }
                    });
                    e.loaded / e.total * 100 >= this.initCoursewareParams.showPagePercent ? (this.$emit('courseWareReady', true), this.coursewareState = 'loaded') : this.coursewareState = 'loading';
                },
                handleStatusChange: function (e) {
                    console.info('对象函数 handleStatusChange(data)', e, 'filePath:renderer/components/Classroom/LargeClass/base/players/components/h5courseware/index.vue');
                    this.localUrl;
                    this.$bus.$emit('corewareLoadStatus', e);
                    'loaded' === e.status && this.sendLogger('loaded');
                },
                getAllStoredData: function (e) {
                    console.info('对象函数 getAllStoredData(callback)', e, 'filePath:renderer/components/Classroom/LargeClass/base/players/components/h5courseware/index.vue');
                },
                handleSwitchCourseware: function (e) {
                    if (console.info('对象函数 handleSwitchCourseware(data)', e, 'filePath:renderer/components/Classroom/LargeClass/base/players/components/h5courseware/index.vue'), e && e.currentCourseWare) {
                        this.currentCourseWareData = e.currentCourseWare;
                        var t = e.currentCourseWare, s = t.blackBoardType, o = t.imgUrl, a = t.jsString, n = t.photoWallImageArray, r = t.pageId;
                        this.$bus.$emit('photoWallShow', false);
                        this.blackBoardImg = this.photoWallImg = '';
                        1 === s && o && (L.a.send({
                            tag: 'courseware',
                            content: { msg: '显示黑板' }
                        }), this.blackBoardImg = o);
                        3 === s && n && (this.photoWallImg = n[0], this.$bus.$emit('photoWallShow', true), L.a.send({
                            tag: 'courseware',
                            content: {
                                msg: '图片上墙',
                                photoWallImg: this.photoWallImg
                            }
                        }));
                        0 === s && a && this.coursewarePlayer && this.coursewarePlayer.handleRoomItsMessage(JSON.parse(a));
                        this.pageId = r;
                        this.$emit('changePageId', r, this.currentCourseWareData);
                    } else {
                        console.info('if(!data || !data.currentCourseWare)为true触发return,path: /renderer/components/Classroom/LargeClass/base/players/components/h5courseware/index.vue');
                    }
                },
                sendLogger: function (e) {
                    var t = arguments, s = this;
                    return Object(A.a)(Object(P.a)().mark(function o() {
                        var a, n, r, i, c;
                        return Object(P.a)().wrap(function (o) {
                            while (1) {
                                switch (o.prev = o.next) {
                                    case 0:
                                        return a = t.length > 1 && void 0 !== t[1] ? t[1] : '', n = ((new Date().getTime() - s.coursewareStartLoadTime) / 1000).toFixed(2), r = s.localUrl ? s.localUrl : '', i = '', s.coursewareInfo && (r || (r = s.coursewareInfo.detail.compressIndexUrl), i = s.coursewareInfo.detail.id), c = {
                                            coursewareId: i,
                                            url: r,
                                            msg: a,
                                            loadTime: parseFloat(n),
                                            isOnlineUrl: s.localUrl ? 0 : 1,
                                            isSuccess: 'loaded' == e ? 1 : 0,
                                            isPlayback: 1 == s.playback ? 1 : 0
                                        }, o.next = 8, L.a.send({
                                            tag: 'coursewareLoad',
                                            content: c
                                        });
                                    case 8:
                                    case 'end':
                                        return o.stop();
                                }
                            }
                        }, o);
                    }))();
                }
            }
        }, ot = st, at = (s('bf30'), Object(Ae.a)(ot, me, he, false, null, 'f44e5934', null)), nt = at.exports, rt = (s('9b02'), s('7b1b')), it = s('ae97'), ct = s('f3f2'), lt = s.n(ct), ut = (s('bcac'), s('281f')), dt = s.n(ut), mt = (s('8d67'), s('c58d')), ht = (s('612a'), s('97a4')), pt = {
            name: 'ppt-area',
            components: {
                H5Courseware: nt,
                WhiteBoardCanvas: lt.a.WhiteBoardCanvas,
                WhiteBoardTools: dt.a
            },
            props: [
                'ircconfig',
                'isInClass',
                'options',
                'configs'
            ],
            data: function () {
                return {
                    pageId: 0,
                    showCanvas: false,
                    examUrl: '',
                    showEaxmIframe: false,
                    useInfo: window.localStorage.getItem('userInfo'),
                    isBanned: false,
                    currentThickness: 4,
                    currentLineDashed: false,
                    eraserSize: 50,
                    containerWidth: 0,
                    containerHeight: 0,
                    currentCourseWareData: {},
                    currentDbKey: '',
                    canvasScale: 2
                };
            },
            mixins: [rt.a],
            mounted: function () {
                var e = this;
                return Object(A.a)(Object(P.a)().mark(function t() {
                    return Object(P.a)().wrap(function (t) {
                        while (1) {
                            switch (t.prev = t.next) {
                                case 0:
                                    return t.next = 2, Object(mt.a)();
                                case 2:
                                    e.canvasScale = t.sent, e.$nextTick(function () {
                                        e.init();
                                        window.addEventListener('resize', e.setCanvasScale);
                                        e.bindEvent();
                                    });
                                case 4:
                                case 'end':
                                    return t.stop();
                            }
                        }
                    }, t);
                }))();
            },
            destroy: function () {
                console.info('对象函数 destroy,filePath:renderer/components/Classroom/LargeClass/base/players/components/ppt/index.vue');
                this.$bus.$off('classExamination');
                window.removeEventListener('resize', this.setCanvasScale);
            },
            beforeDestroy: function () {
                console.info('对象函数 beforeDestroy,filePath:renderer/components/Classroom/LargeClass/base/players/components/ppt/index.vue');
                this.$refs.WhiteBoard && this.$refs.WhiteBoard.uninit();
            },
            watch: {
                showCanvas: function (e) {
                    var t = this;
                    console.info('对象函数 showCanvas(val)', e, 'filePath:renderer/components/Classroom/LargeClass/base/players/components/ppt/index.vue');
                    e && this.$nextTick(function () {
                        t.initBoard();
                    });
                }
            },
            methods: {
                init: function () {
                    console.info('对象函数 init,filePath:renderer/components/Classroom/LargeClass/base/players/components/ppt/index.vue');
                    this.listenerEvent();
                },
                initBoard: function () {
                    var e = this;
                    console.info('对象函数 initBoard,filePath:renderer/components/Classroom/LargeClass/base/players/components/ppt/index.vue');
                    this.getCurrentCanvasSize();
                    var t = {
                        canvas: {
                            penType: 'Bspline',
                            strokeType: 'none',
                            scale: this.canvasScale,
                            pageChangeReport: false,
                            sendRoomCanvasMessage: this.sendRoomCanvasMessage.bind(this),
                            getHistoryMessage: this.getHistoryMessage.bind(this),
                            enableKeyboardDelete: true,
                            enableFittingShape: false
                        },
                        common: {
                            liveId: String(this.options.planInfo.id),
                            role: 'student',
                            dataVersion: '1',
                            courseId: '',
                            userId: this.options.stuId + '',
                            userName: this.options.nickName,
                            screenWidth: this.containerWidth,
                            screenHeight: this.containerHeight,
                            roomIds: [this.options.roomlist[0]],
                            fastFrequency: 2000,
                            slowFrequency: 3000,
                            serverTimestamp: +new Date() + this.options.timeOffset
                        },
                        accessControl: {
                            showMenu: false,
                            mode: 'itsAndCanvas',
                            isBanned: this.isBanned,
                            enableHistoryMessage: true,
                            showCursor: true,
                            enableRetrySend: true,
                            enableLogSend: false,
                            enableFittingShape: false
                        }
                    };
                    if (this.sendLogger('大班涂鸦初始化参数params: '.concat(JSON.stringify(t))), this.$refs.WhiteBoard) {
                        this.$refs.WhiteBoard.uninit();
                        this.$refs.WhiteBoard.init(t);
                        this.$refs.WhiteBoard.handleMouse('default');
                        var s = this.$refs.WhiteBoard.getMainBoardHandWritting(), o = this.$refs.WhiteBoard.getPluginManager(), a = this.$refs.WhiteBoard;
                        this.$refs.WhiteBoardTools.handleMenuEnable(false);
                        this.$refs.WhiteBoardTools.init(a, s, o);
                        var n = [
                            11,
                            12,
                            13,
                            14,
                            15,
                            1000
                        ];
                        n.forEach(function (t) {
                            1000 === t ? o.registerEvent('WhiteboardResize', t, e.toolsMessageHandler('WhiteboardResize', t)) : o.registerEvent('ReceiveBinaryData', t, e.toolsMessageHandler('ReceiveBinaryData', t));
                        });
                        this.$refs.WhiteBoardTools.setWBToolsStatus(false);
                        this.currentDbKey && this.initCatalogueInfo(this.currentDbKey);
                    }
                },
                toolsMessageHandler: function (e, t) {
                    var s = this;
                    return console.info('对象函数 toolsMessageHandler(actionType, toolType)', e, t, 'filePath:renderer/components/Classroom/LargeClass/base/players/components/ppt/index.vue'), function (o) {
                        s.$refs.WhiteBoardTools.receiveBinaryData(e, t, s.pageId, o);
                    };
                },
                initCatalogueInfo: function (e) {
                    console.info('对象函数 initCatalogueInfo(dbKey)', e, 'filePath:renderer/components/Classroom/LargeClass/base/players/components/ppt/index.vue');
                    var t = [{
                        index: 0,
                        isHide: 0,
                        pageId: this.pageId,
                        title: '标题',
                        type: 'course'
                    }];
                    try {
                        this.$refs.WhiteBoard && (this.$refs.WhiteBoard.handleCatalogueChange(t), this.$refs.WhiteBoard.handleResetImComingDbkey(e), this.$refs.WhiteBoard.handlePageChange(String(this.pageId)), this.$refs.WhiteBoardTools.handlePageChange(String(this.pageId)));
                    } catch (s) {
                        console.error('initCatalogueInfo中JSON.parse异常捕获', s);
                    }
                },
                sendRoomCanvasMessage: function (e, t) {
                    var s = window.ChatClient;
                    s.RoomChatManager.sendRoomBinMessage([this.options.roomlist[0]], t.dbKey, t.keyMsgId, t.content);
                    this.sendLogger('sendRoomCanvasMessage: '.concat(JSON.stringify(t)));
                },
                getHistoryMessage: function (e) {
                    var t = this;
                    console.info('对象函数 getHistoryMessage(data)', e, 'filePath:renderer/components/Classroom/LargeClass/base/players/components/ppt/index.vue');
                    var s = e.info[0].dbKey;
                    this.configs;
                    this.ircconfig;
                    this.options;
                    this.sendLogger('发送消息申请拉取数据dbkey: '.concat(s));
                    Object(ht.a)({
                        dbkey: s,
                        appId: this.configs.ircAk,
                        sk: this.configs.ircSk,
                        businessId: 3,
                        liveId: this.options.planInfo.id,
                        ircApiHost: this.configs.ircApiHost
                    }).then(function (e) {
                        console.info('箭头函数 _getHistoryMessage的then(res)', e, 'filePath:renderer/components/Classroom/LargeClass/base/players/components/ppt/index.vue');
                        try {
                            t.$refs.WhiteBoard && t.$refs.WhiteBoard.handleRecoverHistoryMessage([{ content: e }]);
                        } catch (s) {
                            console.error(s);
                            t.sendLogger('涂鸦sdk报错 '.concat(s));
                        }
                    }).catch(function (e) {
                        console.info('箭头函数 catch(err)', e, 'filePath:renderer/components/Classroom/LargeClass/base/players/components/ppt/index.vue');
                    });
                },
                handleRoomCanvasMessage: function (e) {
                    this.sendLogger('处理接收到的实时涂鸦消息: '.concat(e.dbKey, ', ').concat(e.msgId, '}'));
                    this.$refs.WhiteBoard && this.$refs.WhiteBoard.handleRoomCanvasMessage(e);
                },
                onSendRoomBinMessageResp: function (e) {
                    console.info('对象函数 onSendRoomBinMessageResp(res)', e, 'filePath:renderer/components/Classroom/LargeClass/base/players/components/ppt/index.vue');
                    0 === e.code ? this.$refs.WhiteBoard && this.$refs.WhiteBoard.handleSendMessageSuccess(e.dbKey, e.keyMsgId) : this.$refs.WhiteBoard && this.$refs.WhiteBoard.handleSendMessageError(e.code, e.msg, e.dbKey, e.keyMsgId);
                },
                onGetRoomHistoryBinMessageNotice: function (e) {
                    console.info('对象函数 onGetRoomHistoryBinMessageNotice(res)', e, 'filePath:renderer/components/Classroom/LargeClass/base/players/components/ppt/index.vue');
                    this.sendLogger('处理拉取到的涂鸦历史消息');
                    var t = e;
                    if (Array.isArray(t)) {
                        t.forEach(function (e, s) {
                            t[s].content = Uint8Array.from(e.content);
                        });
                        try {
                            this.$refs.WhiteBoard && this.$refs.WhiteBoard.handleRecoverHistoryMessage([{ content: t }]);
                        } catch (s) {
                            console.error('涂鸦sdk报错', s);
                        }
                    } else {
                        console.error('涂鸦历史消息格式错误');
                    }
                },
                listenerEvent: function () {
                    var e = this;
                    console.info('对象函数 listenerEvent,filePath:renderer/components/Classroom/LargeClass/base/players/components/ppt/index.vue');
                    this.$bus.$on('classExamination', function (t) {
                        if (console.info('箭头函数 监听 classExamination(examinationInfo)', t, 'filePath:renderer/components/Classroom/LargeClass/base/players/components/ppt/index.vue'), L.a.send({
                            tag: 'student.Interact',
                            content: {
                                msg: '收到课中考试互动',
                                examinationInfo: t
                            }
                        }), t.pub) {
                            e.showEaxmIframe = true;
                            e.$bus.$emit('setExaminationStatus', true);
                            var s = e.options.timeOffset, o = +new Date(), a = parseInt((o + s) / 1000), n = a - t.beginTime - 60, r = t.beginTime + t.totaltime - a, i = e.useInfo ? JSON.parse(e.useInfo).unifiedAccessToken : '';
                            if (1 === t.status && n <= 0 && (r = t.totaltime), !e.examUrl) {
                                var c = 'from=live&source=pcLargeClass&classId='.concat(e.options.classId, '&studentId=').concat(e.options.stuId, '&token=').concat(i), l = 'duration='.concat(t.totaltime, '&completed=').concat(3 === t.status ? 1 : 0, '&isLate=').concat(n > 0 ? 1 : 0, '&remainSeconds=').concat(r);
                                e.examUrl = ''.concat(t.examUrl, '&platform=3&').concat(c, '&').concat(l);
                            }
                            2 === t.status ? e.$nextTick(function () {
                                document.getElementById('class-examination').contentWindow.postMessage({
                                    type: 'updateRemainSecondsTo',
                                    data: { remainSeconds: r }
                                }, '*');
                            }) : 3 === t.status && e.$nextTick(function () {
                                document.getElementById('class-examination').contentWindow.postMessage({ type: 'completeExam' }, '*');
                            });
                        } else {
                            e.showEaxmIframe = false;
                            e.examUrl = '';
                            e.$bus.$emit('setExaminationStatus', false);
                        }
                    });
                },
                sendSubmitEaxmToTeacher: function () {
                    console.info('对象函数 sendSubmitEaxmToTeacher,filePath:renderer/components/Classroom/LargeClass/base/players/components/ppt/index.vue');
                    var e = {
                        roomlist: this.options.roomlist,
                        content: {
                            type: 128,
                            name: this.options.nickName,
                            msg: '',
                            submit: true
                        },
                        chatMsgPriority: 99
                    };
                    2 !== this.options.classType ? it.a.sendRoomMessage(e) : this.thinkClass.SignalService.sendRoomMessage(e);
                },
                courseWareReady: function (e) {
                    var t = this;
                    console.info('对象函数 courseWareReady(flag)', e, 'filePath:renderer/components/Classroom/LargeClass/base/players/components/ppt/index.vue');
                    this.showCanvas = e;
                    e && this.$nextTick(function () {
                        t.setCanvasScale();
                    });
                    L.a.send({
                        tag: 'init',
                        content: { msg: '课件准备状态'.concat(e) }
                    });
                },
                setCanvasScale: ve()(function () {
                    var e = this;
                    this.showCanvas ? setTimeout(function () {
                        e.getCurrentCanvasSize();
                        e.$refs.WhiteBoard && e.$refs.WhiteBoard.handleResizeCanvas(e.containerWidth, e.containerHeight, true);
                    }, 0) : console.info('if(!this.showCanvas)为true触发return,path: /renderer/components/Classroom/LargeClass/base/players/components/ppt/index.vue');
                }, 300),
                getCurrentCanvasSize: function () {
                    var e = this;
                    console.info('对象函数 getCurrentCanvasSize,filePath:renderer/components/Classroom/LargeClass/base/players/components/ppt/index.vue');
                    var t = document.getElementById('ppt-area-container');
                    this.containerWidth = Math.round(Number(window.getComputedStyle(t).width.replace('px', '')));
                    this.containerHeight = 3 * this.containerWidth / 4;
                    var s = Math.round(Number(window.getComputedStyle(t).height.replace('px', ''))), o = (s - this.containerHeight) / 2, a = 0;
                    if (o < 0) {
                        var n = 4 * s / 3;
                        this.containerHeight = s;
                        a = (this.containerWidth - n) / 2;
                        o = 0;
                        this.containerWidth = n;
                    }
                    this.$nextTick(function () {
                        var t = document.querySelector('.ppt-area-container .container');
                        t.style.top = ''.concat(o, 'px');
                        t.style.left = ''.concat(a, 'px');
                        var s = document.querySelector('.showPhotoWall');
                        s && (s.style.top = ''.concat(o, 'px'), s.style.left = ''.concat(a, 'px'), s.style.width = ''.concat(e.containerWidth, 'px'), s.style.height = ''.concat(e.containerHeight, 'px'));
                        var n = document.querySelector('.blackBoardImg');
                        n && (n.style.top = ''.concat(o, 'px'), n.style.left = ''.concat(a, 'px'), n.style.width = ''.concat(e.containerWidth, 'px'), n.style.height = ''.concat(e.containerHeight, 'px'));
                    });
                    this.containerWidth;
                    this.containerHeight;
                    this.sendLogger('获取当前课件区域的宽高(宽\uFF1A'.concat(this.containerWidth, ', 高\uFF1A').concat(this.containerHeight, '\uFF09'));
                },
                clear: function () {
                    console.info('对象函数 clear,filePath:renderer/components/Classroom/LargeClass/base/players/components/ppt/index.vue');
                },
                changePageId: function (e, t) {
                    var s = this;
                    console.info('对象函数 changePageId(id, currentCourseWareData)', e, t, 'filePath:renderer/components/Classroom/LargeClass/base/players/components/ppt/index.vue');
                    this.pageId = e;
                    this.currentCourseWareData = t;
                    var o = t.specificLiveKey, a = t.courseWareId, n = t.pageId;
                    if (!o || !a || !n) {
                        return console.info('if(!specificLiveKey || !courseWareId || !pageId)为true触发return,path: /renderer/components/Classroom/LargeClass/base/players/components/ppt/index.vue'), void console.error('课件信息错误', t);
                    }
                    var r = ''.concat(o, '_').concat(a, '_').concat(n);
                    this.currentDbKey = r;
                    this.$nextTick(function () {
                        s.initCatalogueInfo(r);
                    });
                },
                sendLogger: function (e) {
                    L.a.send({
                        tag: 'largeClass-graffiti',
                        content: { msg: e }
                    });
                }
            }
        }, ft = pt, vt = (s('9280'), Object(Ae.a)(ft, ue, de, false, null, '7a17753a', null)), gt = vt.exports, Ct = s('3b29'), bt = function () {
            var e = this, t = e._self._c;
            return t('div', { staticClass: 'live-video-wrapper' }, [
                t('div', {
                    directives: [{
                        name: 'show',
                        rawName: 'v-show',
                        value: e.teacherVideoStatus,
                        expression: 'teacherVideoStatus'
                    }],
                    ref: 'liveVideoContainer',
                    staticClass: 'live-video-container',
                    attrs: { id: 'liveVideoContainer' }
                }),
                t('div', {
                    directives: [{
                        name: 'show',
                        rawName: 'v-show',
                        value: !e.teacherVideoStatus,
                        expression: '!teacherVideoStatus'
                    }],
                    staticClass: 'live-bg'
                }),
                e.audioMuteStatus ? t('div', { staticClass: 'microphone-container' }, [t('MicrophoneStatus')], 1) : e._e(),
                e.teacherOnStageStatus ? t('div', { staticClass: 'teacher-on-stage' }, [t('div', { staticClass: 'wrapper' }, [
                    t('div', { staticClass: 'teacher-avatar' }, [t('img', { attrs: { src: e.teacherAvatar } })]),
                    t('div', { staticClass: 'stage-tips' }, [e._v('On Stage')])
                ])]) : e._e()
            ]);
        }, St = [], wt = s('6543'), yt = function () {
            function e() {
                var t = arguments.length > 0 && void 0 !== arguments[0] ? arguments[0] : {};
                console.info('函数申明 _default(opts)', t, 'filePath:renderer/components/Classroom/LargeClass/base/players/components/liveVideo/rtcClass.js');
                Object(g.a)(this, e);
                this.rtcConfig = t.rtcConfig;
                this.teacherVideoUid = Number(this.rtcConfig.teacherVideoUid);
                this.teacherAudioUid = Number(this.rtcConfig.teacherAudioUid);
            }
            return Object(C.a)(e, [
                {
                    key: 'createTeacherRtcChannel',
                    value: function () {
                        var e = Object(A.a)(Object(P.a)().mark(function e() {
                            var t, s;
                            return Object(P.a)().wrap(function (e) {
                                while (1) {
                                    switch (e.prev = e.next) {
                                        case 0:
                                            return t = window.RTC_COMMON.rtcEngine, s = t.createChannel(), s.muteLocalAudioStream(true), s.muteLocalVideoStream(true), this.teacherRtcChannel = s, window.RTC_COMMON.teacherRtcChannel = s, e.abrupt('return', s);
                                        case 7:
                                        case 'end':
                                            return e.stop();
                                    }
                                }
                            }, e, this);
                        }));
                        function t() {
                            return console.info('函数申明 createTeacherRtcChannel, filePath:renderer/components/Classroom/LargeClass/base/players/components/liveVideo/rtcClass.js'), e.apply(this, arguments);
                        }
                        return t;
                    }()
                },
                {
                    key: 'createVideo',
                    value: function (e) {
                        this.teacherRtcChannel.setupRemoteVideo(this.teacherVideoUid, document.getElementById(e));
                    }
                },
                {
                    key: 'destroyVideo',
                    value: function () {
                        this.teacherRtcChannel.destroyRemoteVideo(this.teacherVideoUid, document.getElementById(this.teacherVideoUid));
                    }
                },
                {
                    key: 'muteTeacherChannelAudio',
                    value: function (e) {
                        this.teacherRtcChannel.muteAllRemoteAudioStreams(e);
                    }
                }
            ]), e;
        }(), Pt = function () {
            var e = this, t = e._self._c;
            return t('div', { staticClass: 'microphone-status' }, [
                t('div', { staticClass: 'icon-mute' }),
                t('dic', { staticClass: 'status-text' }, [e._v(' ' + e._s(e.$t('classroom.largeClass.players.mute')) + ' ')])
            ], 1);
        }, At = [], kt = (s('e4e0'), {}), Lt = Object(Ae.a)(kt, Pt, At, false, null, '175be238', null), It = Lt.exports, xt = {
            name: 'liveVideo',
            components: { MicrophoneStatus: It },
            props: {
                options: {
                    type: Object,
                    default: function () {
                        return {};
                    }
                },
                rtcConfig: {
                    type: Object,
                    default: function () {
                        return {};
                    }
                }
            },
            data: function () {
                var e = this.options.teacherInfo.avatar;
                return {
                    audioMuteStatus: false,
                    teacherAvatar: e,
                    teacherOnStageStatus: false,
                    teacherVideoStatus: true,
                    teacherRtcSensor: null
                };
            },
            mounted: function () {
                this.init();
            },
            methods: {
                init: function () {
                    console.info('对象函数 init,filePath:renderer/components/Classroom/LargeClass/base/players/components/liveVideo/largeClass.vue');
                    this.rtcClass = new yt({ rtcConfig: this.rtcConfig });
                    this.initTeacherRtcChannel();
                    this.bindEvent();
                },
                bindEvent: function () {
                    var e = this;
                    console.info('对象函数 bindEvent,filePath:renderer/components/Classroom/LargeClass/base/players/components/liveVideo/largeClass.vue');
                    this.$bus.$on('player.muteTeacherChannelAudio', function (t) {
                        console.info('箭头函数 监听 player.muteTeacherChannelAudio(status)', t, 'filePath:renderer/components/Classroom/LargeClass/base/players/components/liveVideo/largeClass.vue');
                        e.rtcClass.muteTeacherChannelAudio(t);
                    });
                    this.$bus.$on('stageLeavelChannel', function () {
                        console.info('箭头函数 监听 stageLeavelChannel,filePath:renderer/components/Classroom/LargeClass/base/players/components/liveVideo/largeClass.vue');
                        e.rtcClass.destroyVideo();
                        e.teacherVideoStatus = false;
                    });
                    this.$bus.$on('teacherOnStageStatus', function (t) {
                        console.info('箭头函数 监听 teacherOnStageStatus(status)', t, 'filePath:renderer/components/Classroom/LargeClass/base/players/components/liveVideo/largeClass.vue');
                        e.handleTeacherOnStage(t);
                    });
                },
                initTeacherRtcChannel: function () {
                    var e = this;
                    return Object(A.a)(Object(P.a)().mark(function t() {
                        var s, o;
                        return Object(P.a)().wrap(function (t) {
                            while (1) {
                                switch (t.prev = t.next) {
                                    case 0:
                                        return console.info('对象函数 initTeacherRtcChannel,filePath:renderer/components/Classroom/LargeClass/base/players/components/liveVideo/largeClass.vue'), t.next = 3, e.rtcClass.createTeacherRtcChannel();
                                    case 3:
                                        s = t.sent, e.sendLogger('创建主讲rtc频道'), s.on('remoteVideoStateChanged', function (t, s, o) {
                                            console.info('箭头函数 监听 remoteVideoStateChanged(uid, state, reason)', t, s, o, 'filePath:renderer/components/Classroom/LargeClass/base/players/components/liveVideo/largeClass.vue');
                                            t == e.rtcConfig.teacherVideoUid && 1 == s && e.sendLogger('接收到主讲视频首帧, uid: '.concat(e.rtcConfig.teacherVideoUid));
                                            e.rtcConfig.teacherVideoUid;
                                            e.rtcConfig.teacherAudioUid;
                                            t == e.rtcConfig.teacherVideoUid && (5 === o && (e.teacherVideoStatus = false), 6 === o && (e.teacherVideoStatus = true));
                                        }), s.on('remoteAudioStateChanged', function (t, s, o) {
                                            console.info('箭头函数 监听 remoteAudioStateChanged(uid, state, reason)', t, s, o, 'filePath:renderer/components/Classroom/LargeClass/base/players/components/liveVideo/largeClass.vue');
                                            t == e.rtcConfig.teacherAudioUid && (2 === s && (e.audioMuteStatus = false), 0 === s && 5 === o && (e.audioMuteStatus = true, e.sendLogger('主讲端静音, uid: '.concat(e.rtcConfig.teacherAudioUid))), 2 === s && 6 === o && (e.audioMuteStatus = false, e.sendLogger('主讲端解除静音, uid: '.concat(e.rtcConfig.teacherAudioUid))));
                                        }), s.on('remoteJoinChannel', function (t) {
                                            console.info('箭头函数 监听 remoteJoinChannel(uid)', t, 'filePath:renderer/components/Classroom/LargeClass/base/players/components/liveVideo/largeClass.vue');
                                            e.sendLogger('老师频道远端用户加入回调触发, uid: '.concat(t), {
                                                teacherAudioUid: e.rtcConfig.teacherAudioUid,
                                                teacherVideoUid: e.rtcConfig.teacherVideoUid
                                            });
                                            t == e.rtcConfig.teacherAudioUid && (e.$emit('updateLiveState', 1), e.sendLogger('主讲端音频加入频道'));
                                            t == e.rtcConfig.teacherVideoUid && (e.teacherVideoStatus = true, e.rtcClass.createVideo('liveVideoContainer'), e.sendLogger('主讲视频加入频道'));
                                        }), s.on('remoteLeaveChannel', function (t) {
                                            console.info('箭头函数 监听 remoteLeaveChannel(uid)', t, 'filePath:renderer/components/Classroom/LargeClass/base/players/components/liveVideo/largeClass.vue');
                                            t == e.rtcConfig.teacherAudioUid && (e.audioMuteStatus = false, e.$emit('updateLiveState', 0), e.sendLogger('主讲端音频离开频道, uid: '.concat(e.rtcConfig.teacherAudioUid)));
                                            t == e.rtcConfig.teacherVideoUid && (e.teacherVideoStatus = false, e.rtcClass.destroyVideo(), e.sendLogger('主讲视频端离开频道, uid: '.concat(e.rtcConfig.teacherVideoUid)));
                                        }), s.on('rtcStats', function (t) {
                                            e.$bus.$emit('teacherRtcChannelStats', t);
                                        }), s.on('connectionStateChanged', function (t) {
                                            console.info('箭头函数 监听 connectionStateChanged(state)', t, 'filePath:renderer/components/Classroom/LargeClass/base/players/components/liveVideo/largeClass.vue');
                                            5 == t ? e.teacherRtcSensor.rtcSensorPush({
                                                result: 'fail',
                                                errorType: '连接失败'
                                            }) : 4 == t && (e.teacherRtcSensor.isFirstJoinChannel = false, e.teacherRtcSensor.rtcSensorPush({ result: 'start' }));
                                        }), s.on('localJoinChannel', function () {
                                            console.info('箭头函数 监听 localJoinChannel,filePath:renderer/components/Classroom/LargeClass/base/players/components/liveVideo/largeClass.vue');
                                            e.sendLogger('本地加入主讲频道成功');
                                            e.teacherRtcSensor.rtcSensorPush({ result: 'success' });
                                        }), s.on('rejoinChannelSuccess', function () {
                                            console.info('箭头函数 监听 rejoinChannelSuccess,filePath:renderer/components/Classroom/LargeClass/base/players/components/liveVideo/largeClass.vue');
                                            e.sendLogger('本地重连加入主讲频道成功');
                                            e.teacherRtcSensor.rtcSensorPush({ result: 'success' });
                                        }), e.teacherRtcSensor = new x.a(), e.teacherRtcSensor.rtcSensorPush({ result: 'start' }), o = s.joinChannel({
                                            autoSubscribeAudio: true,
                                            autoSubscribeVideo: true,
                                            publishLocalAudio: false,
                                            publishLocalVideo: false
                                        }), 0 == o ? e.sendLogger('调用加入主讲频道成功') : (e.sendLogger('调用加入主讲频道失败,code:'.concat(o), {}, 'error'), e.teacherRtcSensor.rtcSensorPush({
                                            result: 'fail',
                                            errorType: '调用加入房间接口失败'
                                        }));
                                    case 18:
                                    case 'end':
                                        return t.stop();
                                }
                            }
                        }, t);
                    }))();
                },
                handleTeacherOnStage: function (e) {
                    console.info('对象函数 handleTeacherOnStage(status)', e, 'filePath:renderer/components/Classroom/LargeClass/base/players/components/liveVideo/largeClass.vue');
                    this.teacherOnStageStatus = e;
                    e ? (this.rtcClass.destroyVideo(), this.teacherVideoStatus = false) : (this.rtcClass.createVideo('liveVideoContainer'), this.teacherVideoStatus = true);
                },
                sendLogger: function (e) {
                    var t = arguments.length > 1 && void 0 !== arguments[1] ? arguments[1] : {}, s = arguments.length > 2 && void 0 !== arguments[2] ? arguments[2] : 'info';
                    L.a.send({
                        tag: 'liveVideo',
                        level: s,
                        content: {
                            msg: e,
                            parmas: t
                        }
                    });
                }
            }
        }, Ot = xt, jt = (s('6cad'), Object(Ae.a)(Ot, bt, St, false, null, '572b0424', null)), Tt = jt.exports, Mt = function () {
            var e = this, t = e._self._c;
            return t('div', { staticClass: 'live-video-wrapper' }, [
                t('div', {
                    directives: [{
                        name: 'show',
                        rawName: 'v-show',
                        value: e.teacherVideoStatus,
                        expression: 'teacherVideoStatus'
                    }],
                    ref: 'liveVideoContainer',
                    staticClass: 'live-video-container',
                    attrs: { id: 'liveVideoContainer' }
                }),
                t('div', {
                    directives: [{
                        name: 'show',
                        rawName: 'v-show',
                        value: !e.teacherVideoStatus,
                        expression: '!teacherVideoStatus'
                    }],
                    staticClass: 'live-bg'
                }),
                e.audioMuteStatus ? t('div', { staticClass: 'microphone-container' }, [t('MicrophoneStatus')], 1) : e._e()
            ]);
        }, Rt = [], Et = {
            name: 'liveVideo',
            components: { MicrophoneStatus: It },
            props: {
                options: {
                    type: Object,
                    default: function () {
                        return {};
                    }
                },
                rtcConfig: {
                    type: Object,
                    default: function () {
                        return {};
                    }
                }
            },
            data: function () {
                return {
                    audioMuteStatus: false,
                    teacherVideoUid: Number(this.rtcConfig.teacherVideoUid),
                    teacherAudioUid: Number(this.rtcConfig.teacherAudioUid),
                    teacherVideoStatus: false
                };
            },
            mounted: function () {
                this.init();
            },
            methods: {
                init: function () {
                    console.info('对象函数 init,filePath:renderer/components/Classroom/LargeClass/base/players/components/liveVideo/smallClass.vue');
                    this.bindEvent();
                },
                bindEvent: function () {
                    var e = this;
                    console.info('对象函数 bindEvent,filePath:renderer/components/Classroom/LargeClass/base/players/components/liveVideo/smallClass.vue');
                    this.$bus.$on('player.muteTeacherChannelAudio', function (t) {
                        console.info('箭头函数 监听 player.muteTeacherChannelAudio(status)', t, 'filePath:renderer/components/Classroom/LargeClass/base/players/components/liveVideo/smallClass.vue');
                        window.RTC_COMMON.classRtcChannel.muteRemoteAudioStream(e.teacherAudioUid, t);
                    });
                    this.$bus.$on('player.smallClassRtcReady', function (t) {
                        console.info('箭头函数 监听 player.smallClassRtcReady(classRtcChannel)', t, 'filePath:renderer/components/Classroom/LargeClass/base/players/components/liveVideo/smallClass.vue');
                        e.initTeacherRtcChannel(t);
                    });
                },
                initTeacherRtcChannel: function (e) {
                    var t = this;
                    return Object(A.a)(Object(P.a)().mark(function s() {
                        return Object(P.a)().wrap(function (s) {
                            while (1) {
                                switch (s.prev = s.next) {
                                    case 0:
                                        console.info('对象函数 initTeacherRtcChannel(classRtcChannel)', e, 'filePath:renderer/components/Classroom/LargeClass/base/players/components/liveVideo/smallClass.vue'), e.on('remoteVideoStateChanged', function (s, o) {
                                            console.info('箭头函数 监听 remoteVideoStateChanged(uid, state)', s, o, 'filePath:renderer/components/Classroom/LargeClass/base/players/components/liveVideo/smallClass.vue');
                                            s == t.teacherVideoUid && 1 == o && (setTimeout(function () {
                                                e.setupRemoteVideo(t.teacherVideoUid, document.getElementById('liveVideoContainer'));
                                            }, 0), t.sendLogger('接收到主讲视频首帧, uid: '.concat(t.teacherVideoUid)));
                                            t.rtcConfig.teacherVideoUid;
                                            t.rtcConfig.teacherAudioUid;
                                            reason;
                                            s == t.teacherVideoUid && (5 === reason && (t.teacherVideoStatus = false), 6 === reason && (t.teacherVideoStatus = true));
                                        }), e.on('remoteAudioStateChanged', function (e, s, o) {
                                            console.info('箭头函数 监听 remoteAudioStateChanged(uid, state, reason)', e, s, o, 'filePath:renderer/components/Classroom/LargeClass/base/players/components/liveVideo/smallClass.vue');
                                            e == t.teacherAudioUid && (0 === s && 5 === o && (t.audioMuteStatus = true, t.sendLogger('主讲端静音, uid: '.concat(t.teacherAudioUid))), 2 === s && 6 === o && (t.audioMuteStatus = false, t.sendLogger('主讲端解除静音, uid: '.concat(t.teacherAudioUid))));
                                        }), e.on('remoteJoinChannel', function (s) {
                                            console.info('箭头函数 监听 remoteJoinChannel(uid)', s, 'filePath:renderer/components/Classroom/LargeClass/base/players/components/liveVideo/smallClass.vue');
                                            s == t.teacherAudioUid && (e.muteRemoteAudioStream(t.teacherAudioUid, false), t.$emit('updateLiveState', 1), t.sendLogger('主讲端加入频道, uid: '.concat(t.teacherAudioUid)));
                                            s == t.teacherVideoUid && (t.teacherVideoStatus = true, t.sendLogger('主讲视频端加入频道, uid: '.concat(t.teacherVideoUid)));
                                        }), e.on('remoteLeaveChannel', function (s) {
                                            console.info('箭头函数 监听 remoteLeaveChannel(uid)', s, 'filePath:renderer/components/Classroom/LargeClass/base/players/components/liveVideo/smallClass.vue');
                                            s == t.teacherAudioUid && (t.audioMuteStatus = false, t.$emit('updateLiveState', 0), t.sendLogger('主讲端离开频道, uid: '.concat(t.teacherAudioUid)));
                                            s == t.teacherVideoUid && (t.teacherVideoStatus = false, e.destroyRemoteVideo(t.teacherVideoUid, document.getElementById(t.teacherVideoUid)), t.sendLogger('主讲视频端离开频道, uid: '.concat(t.teacherVideoUid)));
                                        }), e.on('rtcStats', function (e) {
                                            t.$bus.$emit('teacherRtcChannelStats', e);
                                        });
                                    case 6:
                                    case 'end':
                                        return s.stop();
                                }
                            }
                        }, s);
                    }))();
                },
                sendLogger: function (e) {
                    L.a.send({
                        tag: 'liveVideo',
                        content: { msg: e }
                    });
                }
            }
        }, Vt = Et, Nt = (s('84c9'), Object(Ae.a)(Vt, Mt, Rt, false, null, 'afc282fa', null)), Dt = Nt.exports, Bt = function () {
            var e = this, t = e._self._c;
            return e.thumbnailBase64 ? t('div', {
                staticClass: 'thumbnail-wrapper',
                on: {
                    click: function (t) {
                        return t.stopPropagation(), e.handleScreenshotPath.apply(null, arguments);
                    }
                }
            }, [
                t('div', { staticClass: 'thumbnail-img' }, [t('img', { attrs: { src: e.thumbnailBase64 } })]),
                t('div', { staticClass: 'thumbnail-text' }, [e._v(' ' + e._s(e.$t('classroom.modules.screenThumbnail.successNotice')) + ' ')])
            ]) : e._e();
        }, Ut = [], Gt = s('4bde'), Ht = {
            data: function () {
                return { thumbnailBase64: null };
            },
            mounted: function () {
                var e = this;
                this.$bus.$on('screenThumbnail', function (t) {
                    console.info('箭头函数 监听 screenThumbnail(thumbnailBase64)', t, 'filePath:renderer/components/Classroom/LargeClass/base/players/components/screenThumbnail/index.vue');
                    e.thumbnailBase64 = t;
                    o && clearTimeout(o);
                    o = setTimeout(function () {
                        e.thumbnailBase64 = null;
                    }, 3000);
                });
            },
            methods: {
                handleScreenshotPath: function () {
                    return Object(A.a)(Object(P.a)().mark(function e() {
                        var t;
                        return Object(P.a)().wrap(function (e) {
                            while (1) {
                                switch (e.prev = e.next) {
                                    case 0:
                                        return console.info('对象函数 handleScreenshotPath,filePath:renderer/components/Classroom/LargeClass/base/players/components/screenThumbnail/index.vue'), e.next = 3, Object(Gt.b)();
                                    case 3:
                                        t = e.sent, te.nativeApi.openDirBySystem(t);
                                    case 5:
                                    case 'end':
                                        return e.stop();
                                }
                            }
                        }, e);
                    }))();
                }
            },
            beforeDestroy: function () {
                console.info('对象函数 beforeDestroy,filePath:renderer/components/Classroom/LargeClass/base/players/components/screenThumbnail/index.vue');
                this.$bus.$off('screenThumbnail');
            }
        }, _t = Ht, Ft = (s('ebb8'), Object(Ae.a)(_t, Bt, Ut, false, null, '2ca16823', null)), Wt = Ft.exports, Kt = s('8958'), qt = {
            components: {
                PptArea: gt,
                MediaSecurityAccess: Ct.a,
                LargeClassLiveVideo: Tt,
                SmallClassLiveVideo: Dt,
                ScreenThumbnail: Wt
            },
            i18n: se.b,
            props: {
                configs: {
                    type: Object,
                    default: function () {
                        return {};
                    }
                },
                extraInfo: {
                    type: Object,
                    default: function () {
                        return {};
                    }
                },
                commonOption: {
                    type: Object,
                    default: function () {
                        return {};
                    }
                }
            },
            mixins: [Kt.a],
            data: function () {
                return {
                    classType: this.commonOption.classType,
                    ircconfig: null,
                    liveState: 0
                };
            },
            computed: {
                isInClass: function () {
                    return console.info('对象函数 isInClass,filePath:renderer/components/Classroom/LargeClass/base/players/rtc-live.vue'), 1 === this.liveState;
                }
            },
            mounted: function () {
                this.ircconfig = this.configs;
                this.addRtcListener();
                Object(se.c)();
            },
            methods: {
                updateLiveState: function (e) {
                    console.info('对象函数 updateLiveState(state)', e, 'filePath:renderer/components/Classroom/LargeClass/base/players/rtc-live.vue');
                    this.liveState = e;
                },
                addRtcListener: function () {
                    var e = this;
                    console.info('对象函数 addRtcListener,filePath:renderer/components/Classroom/LargeClass/base/players/rtc-live.vue');
                    window.RTC_COMMON.rtcEngine.on('localVideoStateChanged', function (t, s) {
                        console.info('箭头函数 监听 localVideoStateChanged(state, err)', t, s, 'filePath:renderer/components/Classroom/LargeClass/base/players/rtc-live.vue');
                        e.showNotification(e.VideoErrorMap, s);
                    });
                    window.RTC_COMMON.rtcEngine.on('localAudioStateChanged', function (t, s) {
                        console.info('箭头函数 监听 localAudioStateChanged(state, err)', t, s, 'filePath:renderer/components/Classroom/LargeClass/base/players/rtc-live.vue');
                        e.showNotification(e.AudioErrorMap, s);
                    });
                }
            }
        }, zt = qt, Jt = (s('f7794'), Object(Ae.a)(zt, ce, le, false, null, '7c9f6d3e', null)), Qt = Jt.exports, Zt = s('b02e'), Yt = (s('068a'), function (e) {
            Object(b.a)(s, e);
            var t = Object(S.a)(s);
            function s() {
                var e, o = arguments.length > 0 && void 0 !== arguments[0] ? arguments[0] : {};
                return console.info('函数申明 RTCWebLive(options)', o, 'filePath:renderer/components/Classroom/LargeClass/base/players/rtc-live.js'), Object(g.a)(this, s), e = t.call(this, o), e.initPlayer(o.dom), e;
            }
            return Object(C.a)(s, [
                {
                    key: 'createVuePlayer',
                    value: function (e) {
                        var t = v.a.extend(e), s = this.createPlayerProps(), o = new t({
                            i18n: se.b,
                            propsData: s
                        });
                        return o.$mount(), o;
                    }
                },
                {
                    key: 'initPlayer',
                    value: function (e) {
                        this.vm = this.createVuePlayer(Qt);
                        this.render(e, this.vm);
                    }
                },
                {
                    key: 'eventHandler',
                    value: function (e) {
                        var t = e.type, s = e.data, o = this.vm.$refs.ppt, a = o.$children[0];
                        'onRecvRoomBinMessageNotice' === t && o.handleRoomCanvasMessage(s);
                        'onGetRoomHistoryBinMessageNotice' === t && o.onGetRoomHistoryBinMessageNotice(s);
                        'canvasSwitchCourseware' === t && a.handleSwitchCourseware(s);
                    }
                },
                {
                    key: 'sendLogger',
                    value: function (e, t) {
                        L.a.send({
                            tag: 'rtc-live',
                            content: {
                                msg: e,
                                params: t
                            }
                        });
                    }
                }
            ]), s;
        }(Zt.a)), Xt = function () {
            var e = this, t = e._self._c;
            return t('div', {
                directives: [{
                    name: 'show',
                    rawName: 'v-show',
                    value: e.isShowChat,
                    expression: 'isShowChat'
                }],
                class: e.diffClassStyle
            }, [t('div', { staticClass: 'chat-container' }, [
                t('span', {
                    directives: [{
                        name: 'show',
                        rawName: 'v-show',
                        value: false,
                        expression: 'false'
                    }]
                }, [e._v(e._s(e.peopleOnline) + e._s(e.selfChatStatus))]),
                t('div', { staticClass: 'content-box' }, [
                    t('div', {
                        ref: 'messagesRef',
                        staticClass: 'messages-wrap',
                        attrs: { id: 'messagesRef' }
                    }, [t('MessageArea', {
                        ref: 'messageContainerRef',
                        attrs: {
                            privateMessageStatus: e.privateMessageStatus,
                            messages: e.messages,
                            privateMessages: e.privateMessages
                        }
                    })], 1),
                    e.showFooter ? t('Footer', {
                        attrs: {
                            privateMessageStatus: e.privateMessageStatus,
                            privateMessages: e.privateMessages,
                            inputStatus: e.ChatClass.inputStatus,
                            hasNewMsg: e.ChatClass.hasNewMsg,
                            hasPrivateNewMsg: e.ChatClass.hasPrivateNewMsg,
                            isPlayBack: e.options.isPlayBack,
                            goodMethod: e.ChatClass.goodMethod,
                            lockTeacherMessage: e.ChatClass.lockTeacherMessage,
                            planId: e.options.planId,
                            options: e.options,
                            packageId: e.options.planInfo.packageId,
                            lottieEmojiLists: e.lottieEmojiLists,
                            handleInputKeyDown: e.handleInputKeyDown
                        },
                        on: {
                            changeInputText: e.handleInputText,
                            handleSetMessage: e.handleSetMessage,
                            handleSetNewMsgStatus: e.handleSetNewMsgStatus,
                            handleSetPrivateMessage: e.handleSetPrivateMessage
                        }
                    }) : e._e()
                ], 1)
            ])]);
        }, $t = [], es = (s('fb6a'), s('13d5'), {
            stu: 1,
            teacher_f: 2,
            system: 3,
            mine: 4
        }), ts = function (e, t) {
            if (console.info('箭头函数 replaceExpress(text, isMegList)', e, t, 'filePath:renderer/components/Classroom/LargeClass/base/chats/chat-conf.js'), t && '[e]em_18[e]' == e) {
                return console.info('if(isMegList && text == \'[e]em_18[e]\')为true触发return,path: /renderer/components/Classroom/LargeClass/base/chats/chat-conf.js'), '<i class="get-good-method"></i>';
            }
            ;
            return /\[e\](\d+)\[e\]/g.test(e) ? (console.info('if(reg.test(text))为true触发return,path: /renderer/components/Classroom/LargeClass/base/chats/chat-conf.js'), e.replace(/\[e\](\d+)\[e\]/g, function (e, t) {
                return console.info('箭头函数 replace(em, it)', e, t, 'filePath:renderer/components/Classroom/LargeClass/base/chats/chat-conf.js'), t;
            })) : e && e.replace(/\[e\](em\_[1-9]{1,1}[0-9]{0,1})\[e\]/g, function (e, t) {
                return console.info('箭头函数 replace(em, item)', e, t, 'filePath:renderer/components/Classroom/LargeClass/base/chats/chat-conf.js'), '<img src="'.concat(s('4b5d')('./icons/' + t + '.png'), '" />');
            });
        }, ss = function (e) {
            console.info('箭头函数 msgFormType(str)', e, 'filePath:renderer/components/Classroom/LargeClass/base/chats/chat-conf.js');
            var t = e.substr(0, 2);
            return 't_' === t ? (console.info('if(prefix === \'t_\')为true触发return,path: /renderer/components/Classroom/LargeClass/base/chats/chat-conf.js'), 1) : 'f_' === t ? (console.info('if(prefix === \'f_\')为true触发return,path: /renderer/components/Classroom/LargeClass/base/chats/chat-conf.js'), 0) : 's_' === t || 'ws_' === e.substr(0, 3) ? (console.info('if(prefix === \'s_\' || str.substr(0, 3) === \'ws_\')为true触发return,path: /renderer/components/Classroom/LargeClass/base/chats/chat-conf.js'), 2) : 3;
        }, ns = function (e) {
            return console.info('箭头函数 isTeacher(str)', e, 'filePath:renderer/components/Classroom/LargeClass/base/chats/chat-conf.js'), 't_' === e.substr(0, 2) || 'f_' === e.substr(0, 2);
        }, rs = function (e) {
            console.info('箭头函数 getCursortPosition(ele)', e, 'filePath:renderer/components/Classroom/LargeClass/base/chats/chat-conf.js');
            var t = 0;
            if (document.selection) {
                e.focus();
                var s = document.selection.createRange();
                s.moveStart('character', -e.value.length);
                t = s.text.length;
            } else {
                (e.selectionStart || '0' == e.selectionStart) && (t = e.selectionStart);
            }
            return t;
        }, is = function (e) {
            return console.info('箭头函数 replaceExpressName(text)', e, 'filePath:renderer/components/Classroom/LargeClass/base/chats/chat-conf.js'), e ? (console.info('if(text)为true触发return,path: /renderer/components/Classroom/LargeClass/base/chats/chat-conf.js'), e.replace(/\[e\]smiling\[e\]/g, '[e]em_1[e]').replace(/\[e\]grinning\[e\]/g, '[e]em_2[e]').replace(/\[e\]flushe\[e\]/g, '[e]em_3[e]').replace(/\[e\]satisfy\[e\]/g, '[e]em_4[e]').replace(/\[e\]grimacing\[e\]/g, '[e]em_5[e]').replace(/\[e\]winking\[e\]/g, '[e]em_6[e]').replace(/\[e\]sweat\[e\]/g, '[e]em_7[e]').replace(/\[e\]downcast\[e\]/g, '[e]em_8[e]').replace(/\[e\]confounded\[e\]/g, '[e]em_9[e]').replace(/\[e\]disappointed\[e\]/g, '[e]em_10[e]').replace(/\[e\]loudlyCrying\[e\]/g, '[e]em_11[e]').replace(/\[e\]tearsOfJoy\[e\]/g, '[e]em_12[e]').replace(/\[e\]dizzy\[e\]/g, '[e]em_13[e]').replace(/\[e\]pouting\[e\]/g, '[e]em_14[e]').replace(/\[e\]thumbsUp\[e\]/g, '[e]em_15[e]').replace(/\[e\]OK\[e\]/g, '[e]em_16[e]').replace(/\[e\]victory\[e\]/g, '[e]em_17[e]')) : (console.info('if(text)为false,触发return,path: /renderer/components/Classroom/LargeClass/base/chats/chat-conf.js'), '');
        }, ls = [
            {
                text: 'smiling',
                name: 'em_1'
            },
            {
                text: 'grinning',
                name: 'em_2'
            },
            {
                text: 'flushe',
                name: 'em_3'
            },
            {
                text: 'satisfy',
                name: 'em_4'
            },
            {
                text: 'grimacing',
                name: 'em_5'
            },
            {
                text: 'winking',
                name: 'em_6'
            },
            {
                text: 'sweat',
                name: 'em_7'
            },
            {
                text: 'downcast',
                name: 'em_8'
            },
            {
                text: 'confounded',
                name: 'em_9'
            },
            {
                text: 'disappointed',
                name: 'em_10'
            },
            {
                text: 'loudlyCrying',
                name: 'em_11'
            },
            {
                text: 'tearsOfJoy',
                name: 'em_12'
            },
            {
                text: 'dizzy',
                name: 'em_13'
            },
            {
                text: 'pouting',
                name: 'em_14'
            },
            {
                text: 'thumbsUp',
                name: 'em_15'
            },
            {
                text: 'OK',
                name: 'em_16'
            },
            {
                text: 'victory',
                name: 'em_17'
            }
        ], ds = (s('2d1a'), s('bf99')), ms = s('975c'), hs = function () {
            var e = this, t = e._self._c;
            return t('div', {
                ref: 'messageContainerRef',
                attrs: { id: 'messageContainerRef' }
            }, [
                e.privateMessageStatus ? t('div', { staticClass: 'message-container' }, e._l(e.privateMessages, function (s, o) {
                    return t('div', {
                        key: o,
                        staticClass: 'item-message'
                    }, [
                        2 == s.type ? t('div', { staticClass: 'message-teacher teacher-f' }, [
                            t('section', [
                                t('div', { staticClass: 'avatar' }, [t('img', { attrs: { src: s.tutor_avatar } })]),
                                t('span', { staticClass: 'name-label name' }, [e._v(' ' + e._s(s.name) + ' ')])
                            ]),
                            t('section', { staticClass: 'message-content' }, [t('span', {
                                staticClass: 'message',
                                domProps: { innerHTML: e._s(e.replaceExpress(s.msg, true)) }
                            })])
                        ]) : e._e(),
                        s.type === e.msgUserType.mine ? t('div', { staticClass: 'message-student' }, [t('div', { staticClass: 'stu-message-content private-stu-message' }, [
                            t('section', [t('span', { staticClass: 'self' }, [
                                t('span', { staticClass: 'name' }, [e._v(' ' + e._s(e.nickName) + ' ')]),
                                t('img', {
                                    staticClass: 'stu-avator',
                                    attrs: { src: e.selfAvatar }
                                })
                            ])]),
                            t('section', { staticClass: 'message-content' }, [t('div', { staticClass: 'content' }, [
                                t('span', {
                                    directives: [{
                                        name: 'show',
                                        rawName: 'v-show',
                                        value: s.messageStatus,
                                        expression: 'item.messageStatus'
                                    }],
                                    staticClass: 'send_error'
                                }),
                                t('span', {
                                    staticClass: 'message',
                                    domProps: { innerHTML: e._s(e.replaceExpress(s.msg, true)) }
                                })
                            ])])
                        ])]) : e._e()
                    ]);
                }), 0) : e._e(),
                e.privateMessageStatus ? e._e() : t('div', { staticClass: 'message-container' }, e._l(e.messages, function (s, o) {
                    return t('div', {
                        key: o,
                        staticClass: 'item-message'
                    }, [
                        s.type === e.msgUserType.teacher_f ? t('div', { staticClass: 'message-teacher teacher-f' }, [
                            t('section', [
                                t('div', { staticClass: 'avatar' }, [t('img', { attrs: { src: s.tutor_avatar } })]),
                                t('span', { staticClass: 'name-label name' }, [e._v(' ' + e._s(s.name) + ' ')])
                            ]),
                            t('section', { staticClass: 'message-content' }, [t('span', {
                                staticClass: 'message',
                                domProps: { innerHTML: e._s(e.replaceExpress(s.msg, true)) }
                            })])
                        ]) : e._e(),
                        s.type === e.msgUserType.stu || s.type === e.msgUserType.mine ? t('div', { staticClass: 'message-student' }, [t('div', {
                            staticClass: 'stu-message-content',
                            class: s.isMe || s.type === e.msgUserType.mine ? 'self-chat-content' : 'others-chat-content'
                        }, [
                            t('section', [s.type === e.msgUserType.mine || s.isMe ? t('span', { staticClass: 'self' }, [
                                t('span', { staticClass: 'name' }, [e._v(' ' + e._s(e.nickName) + ' ')]),
                                t('img', {
                                    staticClass: 'stu-avator',
                                    attrs: { src: e.selfAvatar }
                                })
                            ]) : t('span', { staticClass: 'others' }, [
                                t('img', {
                                    staticClass: 'stu-avator',
                                    attrs: { src: s.avatar }
                                }),
                                t('span', { staticClass: 'name' }, [e._v(' ' + e._s(s.name) + ' ')])
                            ])]),
                            t('section', [t('div', { staticClass: 'content' }, [
                                t('span', {
                                    directives: [{
                                        name: 'show',
                                        rawName: 'v-show',
                                        value: s.messageStatus,
                                        expression: 'item.messageStatus'
                                    }],
                                    staticClass: 'send_error'
                                }),
                                s.isNewEmoji ? t('EmoticonMessage', {
                                    attrs: {
                                        willAutoClear: false,
                                        name: s.msg,
                                        type: s.emojiType,
                                        emojiId: s.emojiId,
                                        width: 70,
                                        height: 70,
                                        lottieUrl: s.lottieUrl,
                                        loopLottie: true
                                    }
                                }) : t('div', {
                                    staticClass: 'message',
                                    domProps: { innerHTML: e._s(e.replaceExpress(s.msg, true)) }
                                })
                            ], 1)])
                        ])]) : e._e(),
                        s.type === e.msgUserType.system ? t('div', { staticClass: 'message-system' }, [t('div', { staticClass: 'message-content' }, [t('span', { staticClass: 'message' }, [e._v(e._s(s.msg))])])]) : e._e()
                    ]);
                }), 0)
            ]);
        }, ps = [], fs = s('722b'), vs = {
            data: function () {
                return {
                    singleEmoji: {},
                    emoticonType: 1,
                    emojiId: 0,
                    lottieUrl: '',
                    selfAvatar: '',
                    nickName: '',
                    msgTip: this.$t('classroom.largeClass.chats.msgTip'),
                    msgUserType: es
                };
            },
            components: { EmoticonMessage: fs.a },
            props: {
                privateMessageStatus: {
                    default: false,
                    type: Boolean
                },
                messages: {
                    default: [],
                    type: Array
                },
                privateMessages: {
                    default: [],
                    type: Array
                }
            },
            methods: {
                replaceExpress: ts,
                getUserAvatar: function () {
                    var e = this;
                    return Object(A.a)(Object(P.a)().mark(function t() {
                        var s, o, a;
                        return Object(P.a)().wrap(function (t) {
                            while (1) {
                                switch (t.prev = t.next) {
                                    case 0:
                                        return console.info('对象函数 getUserAvatar,filePath:renderer/components/Classroom/LargeClass/base/chats/components/messageArea.vue'), t.next = 3, Object(oe.a)();
                                    case 3:
                                        s = t.sent, o = s.nickName, a = s.avatar, e.nickName = o, e.selfAvatar = a;
                                    case 8:
                                    case 'end':
                                        return t.stop();
                                }
                            }
                        }, t);
                    }))();
                }
            },
            mounted: function () {
                this.getUserAvatar();
            }
        }, gs = vs, Cs = (s('b1b7'), Object(Ae.a)(gs, hs, ps, false, null, '6f6907bd', null)), bs = Cs.exports, Ss = function () {
            var e = this, t = e._self._c;
            return t('div', { staticClass: 'chat-footer-wrapper' }, [
                e.showTeacherOnly ? e._e() : t('PrivateMessageNum', {
                    attrs: {
                        privateMessages: e.privateMessages,
                        options: e.options
                    }
                }),
                true === e.privateMessageStatus ? t('div', { staticClass: 'chat-footer-container' }, [
                    t('div', { staticClass: 'footer-live-box' }, [t('div', { staticClass: 'send-message-box' }, [t('div', { staticClass: 'message-box private-message-box' }, [t('div', { staticClass: 'input-wrap' }, [
                        t('input', {
                            directives: [{
                                name: 'model',
                                rawName: 'v-model',
                                value: e.privateInputStatus.text,
                                expression: 'privateInputStatus.text'
                            }],
                            ref: 'inputBox',
                            attrs: {
                                type: 'text',
                                placeholder: e.$t('classroom.largeClass.chats.inputPlaceholder'),
                                autocomplete: 'off',
                                maxlength: '200'
                            },
                            domProps: { value: e.privateInputStatus.text },
                            on: {
                                keydown: [
                                    function (t) {
                                        return !t.type.indexOf('key') && e._k(t.keyCode, 'enter', 13, t.key, 'Enter') ? (console.info('if(!$event.type.indexOf(\'key\') && _vm._k($event.keyCode, \'enter\', 13, $event.key, \'Enter\'))为true触发return,path: /renderer/components/Classroom/LargeClass/base/chats/components/footer.vue'), null) : e.handleSetPrivateMessage.apply(null, arguments);
                                    },
                                    e.handleInputKeyDown
                                ],
                                keyup: e.handleInputKeyDown,
                                input: function (t) {
                                    t.target.composing ? console.info('if($event.target.composing)为true触发return,path: /renderer/components/Classroom/LargeClass/base/chats/components/footer.vue') : e.$set(e.privateInputStatus, 'text', t.target.value);
                                }
                            }
                        }),
                        t('div', {
                            staticClass: 'send-button',
                            class: { red: e.privateInputStatus.text.length > 0 },
                            on: { click: e.handleSetPrivateMessage }
                        }, [t('span')])
                    ])])])]),
                    t('div', {
                        directives: [{
                            name: 'show',
                            rawName: 'v-show',
                            value: e.hasPrivateNewMsg,
                            expression: 'hasPrivateNewMsg'
                        }],
                        staticClass: 'new-meg-tip',
                        on: { click: e.handleNewMsg }
                    }, [t('i', { staticClass: 'icon-more-bottom' })])
                ]) : e._e(),
                false === e.privateMessageStatus ? t('div', { staticClass: 'chat-footer-container' }, [
                    t('div', { staticClass: 'footer-live-box' }, [
                        t('div', {
                            staticClass: 'send-message-box',
                            class: { lock: e.needLoak }
                        }, [
                            t('div', {
                                directives: [{
                                    name: 'show',
                                    rawName: 'v-show',
                                    value: e.needLoak,
                                    expression: 'needLoak'
                                }],
                                staticClass: 'message-box message-box-lock'
                            }, [t('div', { staticClass: 'chatbox-closed' }, [e._v(' ' + e._s(e.inputStatus.text) + ' ')])]),
                            t('div', {
                                directives: [{
                                    name: 'show',
                                    rawName: 'v-show',
                                    value: !e.needLoak,
                                    expression: '!needLoak'
                                }],
                                staticClass: 'message-box'
                            }, [
                                t('div', {
                                    staticClass: 'express',
                                    class: e.showEmojiPane ? 'select-express' : '',
                                    attrs: { id: 'emoji-icon' },
                                    on: { click: e.handleShowExpress }
                                }),
                                t('div', { staticClass: 'input-wrap' }, [
                                    t('span', {
                                        staticClass: 'quick-fadeback',
                                        attrs: { id: 'quick-fadeback' },
                                        on: { click: e.handleOpenHotWord }
                                    }),
                                    t('input', {
                                        directives: [{
                                            name: 'model',
                                            rawName: 'v-model',
                                            value: e.inputStatus.text,
                                            expression: 'inputStatus.text'
                                        }],
                                        ref: 'inputBox',
                                        class: { disabled: e.needLoak },
                                        attrs: {
                                            type: 'text',
                                            placeholder: e.$t('classroom.largeClass.chats.inputPlaceholder'),
                                            autocomplete: 'off',
                                            disabled: e.needLoak,
                                            maxlength: '200'
                                        },
                                        domProps: { value: e.inputStatus.text },
                                        on: {
                                            keydown: [
                                                function (t) {
                                                    return !t.type.indexOf('key') && e._k(t.keyCode, 'enter', 13, t.key, 'Enter') ? (console.info('if(!$event.type.indexOf(\'key\') && _vm._k($event.keyCode, \'enter\', 13, $event.key, \'Enter\'))为true触发return,path: /renderer/components/Classroom/LargeClass/base/chats/components/footer.vue'), null) : e.handleSendMessage.apply(null, arguments);
                                                },
                                                e.handleInputKeyDown
                                            ],
                                            keyup: e.handleInputKeyDown,
                                            input: function (t) {
                                                t.target.composing ? console.info('if($event.target.composing)为true触发return,path: /renderer/components/Classroom/LargeClass/base/chats/components/footer.vue') : e.$set(e.inputStatus, 'text', t.target.value);
                                            }
                                        }
                                    }),
                                    t('div', {
                                        staticClass: 'send-button',
                                        class: { red: e.inputStatus.text.length > 0 && !e.needLoak },
                                        on: { click: e.handleSendMessage }
                                    }, [t('span')])
                                ])
                            ]),
                            e.needLoak ? e._e() : t('div', {
                                staticClass: 'teacher-only',
                                on: {
                                    mouseenter: e.handleTeacherOnlyMouseenter,
                                    mouseleave: e.handleTeacherOnlyMouseleave
                                }
                            }, [
                                t('div', {
                                    staticClass: 'icon-button',
                                    on: { click: e.handleTeacherOnly }
                                }),
                                e.showTeacherOnly ? t('div', { staticClass: 'operation-content' }, [
                                    t('div', { staticClass: 'operation-title' }, [e._v(' ' + e._s(e.$t('classroom.largeClass.chats.teacherOnly')) + ' ')]),
                                    t('div', { staticClass: 'operation-switch' }, [t('a-switch', {
                                        on: { change: e.changeTeacherOnly },
                                        model: {
                                            value: e.lockTeacherMessage,
                                            callback: function (t) {
                                                e.lockTeacherMessage = t;
                                            },
                                            expression: 'lockTeacherMessage'
                                        }
                                    })], 1)
                                ]) : e._e()
                            ])
                        ]),
                        t('div', {
                            staticClass: 'emoji-container',
                            attrs: { id: 'emoji-container-id' }
                        }, [t('LargeEmojiPane', {
                            directives: [{
                                name: 'clickoutside',
                                rawName: 'v-clickoutside',
                                value: e.closeEmojiPane,
                                expression: 'closeEmojiPane'
                            }],
                            ref: 'emojiPaneRef',
                            attrs: {
                                showEmojiPane: e.showEmojiPane,
                                lottieEmojiLists: e.lottieEmojiLists,
                                options: e.options,
                                packageId: e.packageId
                            },
                            on: { closeLargeEmojiPane: e.closeLargeEmojiPane }
                        })], 1),
                        t('div', {
                            directives: [
                                {
                                    name: 'clickoutside',
                                    rawName: 'v-clickoutside',
                                    value: e.closeHotWordPane,
                                    expression: 'closeHotWordPane'
                                },
                                {
                                    name: 'show',
                                    rawName: 'v-show',
                                    value: e.showHotWord,
                                    expression: 'showHotWord'
                                }
                            ],
                            staticClass: 'express-box express-bot-box'
                        }, [t('ul', e._l(e.hotWordList, function (s, o) {
                            return t('li', {
                                key: o,
                                staticClass: 'express-item-bot',
                                domProps: { innerHTML: e._s(s) },
                                on: {
                                    click: function (t) {
                                        return e.handleSelectHotWord(s);
                                    }
                                }
                            });
                        }), 0)])
                    ]),
                    t('div', {
                        directives: [{
                            name: 'show',
                            rawName: 'v-show',
                            value: e.hasNewMsg,
                            expression: 'hasNewMsg'
                        }],
                        staticClass: 'new-meg-tip',
                        on: { click: e.handleNewMsg }
                    }, [t('i', { staticClass: 'icon-more-bottom' })])
                ]) : e._e()
            ], 1);
        }, ws = [], ys = (s('498a2'), s('5e38')), Ps = s.n(ys), As = function () {
            var e = this, t = e._self._c;
            return t('div', [
                e.privateMessageStatus ? t('div', { staticClass: 'private-message-entry' }, [t('div', {
                    staticClass: 'icon-goback',
                    on: {
                        click: function (t) {
                            return e.handleChangeStatus(false);
                        }
                    }
                })]) : e._e(),
                e.showPrivateMessageEntry ? t('div', { staticClass: 'private-message-entry' }, [t('div', {
                    staticClass: 'icon-private-msg-num',
                    on: {
                        click: function (t) {
                            return e.handleChangeStatus(true);
                        }
                    }
                }, [e.showPrivateMessageNum ? t('div', { staticClass: 'msg-num' }, [e._v(e._s(e.messageNumAlias))]) : e._e()])]) : e._e()
            ]);
        }, ks = [], Ls = {
            props: {
                privateMessages: {
                    default: [],
                    type: Array
                },
                options: {
                    type: Object,
                    default: function () {
                        return console.info('对象函数 default,filePath:renderer/components/Classroom/LargeClass/base/chats/components/privateMessageNum.vue'), {};
                    }
                }
            },
            data: function () {
                return {
                    privateMessageStatus: false,
                    messageNum: 0
                };
            },
            computed: {
                showPrivateMessageEntry: function () {
                    return console.info('对象函数 showPrivateMessageEntry,filePath:renderer/components/Classroom/LargeClass/base/chats/components/privateMessageNum.vue'), this.privateMessages.length > 0 && !this.privateMessageStatus;
                },
                showPrivateMessageNum: function () {
                    return console.info('对象函数 showPrivateMessageNum,filePath:renderer/components/Classroom/LargeClass/base/chats/components/privateMessageNum.vue'), this.messageNum > 0;
                },
                messageNumAlias: function () {
                    return console.info('对象函数 messageNumAlias,filePath:renderer/components/Classroom/LargeClass/base/chats/components/privateMessageNum.vue'), this.messageNum > 99 ? (console.info('if(this.messageNum > 99)为true触发return,path: /renderer/components/Classroom/LargeClass/base/chats/components/privateMessageNum.vue'), '99+') : this.messageNum;
                }
            },
            mounted: function () {
                this.initEvent();
            },
            methods: {
                initEvent: function () {
                    var e = this;
                    console.info('对象函数 initEvent,filePath:renderer/components/Classroom/LargeClass/base/chats/components/privateMessageNum.vue');
                    this.$bus.$on('chats.privateMessagePush', function () {
                        console.info('箭头函数 监听 chats.privateMessagePush,filePath:renderer/components/Classroom/LargeClass/base/chats/components/privateMessageNum.vue');
                        e.messageNum = e.messageNum + 1;
                    });
                },
                handleChangeStatus: function (e) {
                    console.info('对象函数 handleChangeStatus(status)', e, 'filePath:renderer/components/Classroom/LargeClass/base/chats/components/privateMessageNum.vue');
                    this.privateMessageStatus = e;
                    this.$bus.$emit('chats.changePrivateMessageStatus', e);
                    this.messageNum = 0;
                    Object(x.e)('hw_classroom_tutor_message', this.options);
                }
            }
        }, Is = Ls, xs = (s('77132'), Object(Ae.a)(Is, As, ks, false, null, 'dd662714', null)), Os = xs.exports, js = function () {
            var e = this, t = e._self._c;
            return e.showEmojiPane ? t('div', {
                directives: [{
                    name: 'clickoutside',
                    rawName: 'v-clickoutside',
                    value: e.closeEmojiPane,
                    expression: 'closeEmojiPane'
                }],
                staticClass: 'emojis-pane-container',
                class: e.allOnStage ? 'allOnStage-pane-container' : ''
            }, [
                t('section', { staticClass: 'emojis-nav' }, [t('ul', e._l(e.lottieEmojiLists, function (o, a) {
                    return t('li', {
                        key: o.emojiPackageId,
                        staticClass: 'emoji-nav-content',
                        class: o.emojiPackageId == e.currentOrderId ? 'active' : '',
                        on: {
                            click: function (t) {
                                return e.selectedEmoji(o.emojiPackageId, a);
                            }
                        }
                    }, [o.isLocal ? t('img', {
                        attrs: {
                            src: s('ff63'),
                            alt: ''
                        }
                    }) : t('img', {
                        attrs: {
                            src: o.picture,
                            alt: ''
                        }
                    })]);
                }), 0)]),
                t('section', { staticClass: 'emojis-list' }, [t('div', {
                    ref: 'scrollWrapper',
                    staticClass: 'emoji-scroll-wrapper'
                }, e._l(e.lottieEmojiLists, function (s) {
                    return t('div', {
                        key: s.emojiPackageId,
                        staticClass: 'emoji-show-list',
                        class: {
                            'native-emoji': 1 == s.isLocal,
                            'overshow-style': 1 == s.isOver && 1 == s.overShow
                        },
                        style: e.synamicWidthStyle(s.isLocal, s.content.length)
                    }, [1 == s.isOver && 1 == s.overShow ? [t('div', { staticClass: 'emojiGroup-overShow' }, [
                        t('span', { staticClass: 'overShow-emoji' }, [
                            t('img', { attrs: { src: s.picture } }),
                            t('span')
                        ]),
                        t('p', { staticClass: 'overShow-tips top' }, [e._v(' ' + e._s(e.$t('classroom.smallClass.dynamicEmoji[0]')) + ' ')]),
                        t('p', { staticClass: 'overShow-tips' }, [e._v(e._s(e.$t('classroom.smallClass.dynamicEmoji[1]')))])
                    ])] : e._l(s.content, function (o, a) {
                        return t('div', {
                            key: a,
                            staticClass: 'emoji-group-item'
                        }, [s.isLocal ? t('Emoticon', {
                            attrs: {
                                name: o.name,
                                type: o.type,
                                enableHover: true,
                                hoverWidth: 45,
                                hoverHeight: 45,
                                width: 40,
                                height: 40
                            },
                            on: {
                                handleClick: function (t) {
                                    return e.handleLocalClick(arguments, s, a);
                                }
                            }
                        }) : t('div', {
                            staticClass: 'dynamic-emoji',
                            on: {
                                click: function (t) {
                                    return e.handleLottieClick(o, s);
                                }
                            }
                        }, [t('img', {
                            attrs: {
                                src: o.emojiPicture,
                                alt: ''
                            }
                        })])], 1);
                    })], 2);
                }), 0)])
            ]) : e._e();
        }, Ts = [], Ms = (s('8a79'), s('90ea')), Rs = s('c02a'), Es = {
            name: 'EmojiPane',
            components: { Emoticon: Ms.a },
            data: function () {
                return {
                    emoticonList: '',
                    showEmojiPane: false,
                    nickName: '',
                    avatar: '',
                    currentOrderId: 0,
                    dynamicEmolist: []
                };
            },
            props: {
                options: {
                    type: Object,
                    default: null
                },
                allOnStage: {
                    type: Boolean,
                    default: false
                },
                showEmojiPane: {
                    type: Boolean,
                    default: false
                },
                packageId: {
                    type: Number,
                    default: 0
                },
                lottieEmojiLists: {
                    default: [],
                    type: Array
                }
            },
            computed: {},
            mounted: function () {
                this.getUserInfo();
            },
            methods: {
                getUserInfo: function () {
                    var e = this;
                    return Object(A.a)(Object(P.a)().mark(function t() {
                        var s, o, a;
                        return Object(P.a)().wrap(function (t) {
                            while (1) {
                                switch (t.prev = t.next) {
                                    case 0:
                                        return console.info('对象函数 getUserInfo,filePath:renderer/components/Classroom/LargeClass/base/chats/components/LargeEmojiPane/index.vue'), t.next = 3, Object(oe.a)();
                                    case 3:
                                        s = t.sent, o = s.nickName, a = s.avatar, e.nickName = o, e.avatar = a;
                                    case 8:
                                    case 'end':
                                        return t.stop();
                                }
                            }
                        }, t);
                    }))();
                },
                handleClick: function (e, t, s) {
                    console.info('对象函数 handleClick(params, emojiGroup, key)', e, t, s, 'filePath:renderer/components/Classroom/LargeClass/base/chats/components/LargeEmojiPane/index.vue');
                    this.$bus.$emit('handleLargeNativeEmoji', e);
                    this.$emit('closeLargeEmojiPane');
                    this.currentOrderId = 0;
                    Object(ms.c)(this.options, e, t, s, this.allOnStage, this.packageId);
                    Rs.c({
                        type: 4,
                        contentType: 'emoji',
                        msg: ''.concat(e.name)
                    });
                },
                handleLocalClick: function (e, t, s) {
                    console.info('对象函数 handleLocalClick(params, emojiGroup, key)', e, t, s, 'filePath:renderer/components/Classroom/LargeClass/base/chats/components/LargeEmojiPane/index.vue');
                    L.a.send({
                        tag: 'action',
                        content: { msg: '学生选择本地表情发送' }
                    });
                    this.handleClick(e[0], t, s);
                },
                handleLottieClick: function (e, t) {
                    console.info('对象函数 handleLottieClick(params, emojiGroup)', e, t, 'filePath:renderer/components/Classroom/LargeClass/base/chats/components/LargeEmojiPane/index.vue');
                    L.a.send({
                        tag: 'action',
                        content: { msg: '学生选择动态表情发送' }
                    });
                    var s = e.lottieUrl.endsWith('.json') ? 2 : 3, o = Object(F.a)(Object(F.a)({}, e), {}, {
                        type: s,
                        name: e.emojiName
                    });
                    this.handleClick(o, t);
                },
                synamicWidthStyle: function (e, t) {
                    console.info('对象函数 synamicWidthStyle(isLocal, len)', e, t, 'filePath:renderer/components/Classroom/LargeClass/base/chats/components/LargeEmojiPane/index.vue');
                    var n = (t - 6) / 2 * 70 + 300;
                    return { width: ''.concat(e ? 488 : n, 'px') };
                },
                selectedEmoji: function (e, t) {
                    console.info('对象函数 selectedEmoji(emojiPackageId, key)', e, t, 'filePath:renderer/components/Classroom/LargeClass/base/chats/components/LargeEmojiPane/index.vue');
                    L.a.send({
                        tag: 'action',
                        content: { msg: '学生选择表情类型' }
                    });
                    this.currentOrderId = e;
                    var s = document.getElementsByClassName('emoji-show-list')[t];
                    s && s.scrollIntoView({ inline: 'center' });
                },
                changeNavPos: function () {
                    console.info('对象函数 changeNavPos,filePath:renderer/components/Classroom/LargeClass/base/chats/components/LargeEmojiPane/index.vue');
                    this.currentOrderId = 0;
                }
            }
        }, Vs = Es, Ns = (s('712f'), Object(Ae.a)(Vs, js, Ts, false, null, '7eaf38f4', null)), Ds = Ns.exports, Bs = s('a5d8'), Us = {
            components: {
                PrivateMessageNum: Os,
                LargeEmojiPane: Ds
            },
            props: {
                privateMessageStatus: {
                    type: Boolean,
                    default: false
                },
                privateMessages: {
                    default: [],
                    type: Array
                },
                inputStatus: {
                    type: Object,
                    default: function () {
                        return console.info('对象函数 default,filePath:renderer/components/Classroom/LargeClass/base/chats/components/footer.vue'), {
                            status: 5,
                            text: this.$t('classroom.largeClass.chats.inputStatusMap')[5]
                        };
                    }
                },
                isPlayBack: { default: false },
                planId: { default: '' },
                allOnStage: false,
                lottieEmojiLists: {
                    default: [],
                    type: Array
                },
                options: {
                    type: Object,
                    default: function () {
                        return console.info('对象函数 default,filePath:renderer/components/Classroom/LargeClass/base/chats/components/footer.vue'), {};
                    }
                },
                packageId: {
                    type: Number,
                    default: 0
                },
                hasNewMsg: Boolean,
                hasPrivateNewMsg: Boolean,
                handleInputKeyDown: Function,
                goodMethod: Boolean,
                lockTeacherMessage: Boolean
            },
            directives: { Clickoutside: Bs.a },
            data: function () {
                return {
                    expressList: ls,
                    showHotWord: false,
                    showTeacherOnly: false,
                    inputBox: null,
                    showEmojiPane: false,
                    rightLabel: '',
                    teacherOnlyTimer: null,
                    privateInputStatus: { text: '' }
                };
            },
            computed: {
                needLoak: function () {
                    return console.info('对象函数 needLoak,filePath:renderer/components/Classroom/LargeClass/base/chats/components/footer.vue'), 3 != this.inputStatus.status && 4 != this.inputStatus.status;
                },
                msgTip: function () {
                    return console.info('对象函数 msgTip,filePath:renderer/components/Classroom/LargeClass/base/chats/components/footer.vue'), this.$t('classroom.largeClass.chats.msgTip');
                },
                hotWordList: function () {
                    return console.info('对象函数 hotWordList,filePath:renderer/components/Classroom/LargeClass/base/chats/components/footer.vue'), this.$t('classroom.largeClass.chats.hotWordList');
                }
            },
            watch: {
                showHotWord: function (e) {
                    console.info('对象函数 showHotWord(val)', e, 'filePath:renderer/components/Classroom/LargeClass/base/chats/components/footer.vue');
                    e && this.reSensorEvent('hw_classroom_chat_shortcut_show');
                },
                needLoak: function (e) {
                    console.info('对象函数 needLoak(isNeedLoak)', e, 'filePath:renderer/components/Classroom/LargeClass/base/chats/components/footer.vue');
                    L.a.send({
                        tag: 'action',
                        content: {
                            msg: '老师禁言',
                            params: {
                                isNeedLoak: e,
                                showEmojiPane: this.showEmojiPane
                            }
                        }
                    });
                    e && this.showEmojiPane && this.closeLargeEmojiPane();
                }
            },
            mounted: function () {
                var e = this;
                this.inputBox = this.$refs.inputBox;
                J.a.emit('interaction', {
                    type: 'onContinueRightLabel',
                    data: function (t) {
                        e.rightLabel = t;
                    }
                });
            },
            methods: {
                reSensorEvent: function (e) {
                    var t = arguments.length > 1 && void 0 !== arguments[1] ? arguments[1] : {};
                    console.info('对象函数 reSensorEvent(eventName, params)', e, t, 'filePath:renderer/components/Classroom/LargeClass/base/chats/components/footer.vue');
                    Object(x.e)(e, this.options, t);
                },
                handleShowExpress: function () {
                    console.info('对象函数 handleShowExpress,filePath:renderer/components/Classroom/LargeClass/base/chats/components/footer.vue');
                    L.a.send({
                        tag: 'action',
                        content: {
                            msg: '点击表情icon切换显示隐藏',
                            privateMessageStatus: this.privateMessageStatus,
                            needLoak: this.needLoak
                        }
                    });
                    this.privateMessageStatus || !this.needLoak ? (this.showEmojiPane = !this.showEmojiPane, this.showEmojiPane ? (this.dynamicDealPaneZindex('add'), Object(ms.b)(this.options, this.allOnStage, this.packageId)) : this.dynamicDealPaneZindex('remove')) : console.info('if(!this.privateMessageStatus && this.needLoak)为true触发return,path: /renderer/components/Classroom/LargeClass/base/chats/components/footer.vue');
                },
                closeEmojiPane: function (e) {
                    console.info('对象函数 closeEmojiPane(e)', e, 'filePath:renderer/components/Classroom/LargeClass/base/chats/components/footer.vue');
                    var t = document.querySelector('#emoji-icon'), s = t == e.target;
                    if (s) {
                        return console.info('if(clickDom)为true触发return,path: /renderer/components/Classroom/LargeClass/base/chats/components/footer.vue'), void (this.showEmojiPane = true);
                    }
                    L.a.send({
                        tag: 'action',
                        content: { msg: '点击外部关闭表情弹窗' }
                    });
                    this.showEmojiPane = false;
                    this.dynamicDealPaneZindex('remove');
                    this.$refs.emojiPaneRef.changeNavPos();
                },
                closeLargeEmojiPane: function () {
                    console.info('对象函数 closeLargeEmojiPane,filePath:renderer/components/Classroom/LargeClass/base/chats/components/footer.vue');
                    L.a.send({
                        tag: 'action',
                        content: { msg: '关闭表情面板' }
                    });
                    this.showEmojiPane = false;
                    this.dynamicDealPaneZindex('remove');
                },
                dynamicDealPaneZindex: function (e) {
                    console.info('对象函数 dynamicDealPaneZindex(type)', e, 'filePath:renderer/components/Classroom/LargeClass/base/chats/components/footer.vue');
                    var t = document.getElementById('emoji-container-id');
                    'add' === e ? Object(X.a)(t, 'emoji-z-index') : 'remove' === e && Object(X.w)(t, 'emoji-z-index');
                },
                handleSelectEmoji: function (e) {
                    console.info('对象函数 handleSelectEmoji(word)', e, 'filePath:renderer/components/Classroom/LargeClass/base/chats/components/footer.vue');
                    var t = this.privateMessageStatus ? this.privateInputStatus : this.inputStatus, s = t.text;
                    if (s.length + e.length > 100) {
                        console.info('if(text.length + word.length > 100)为true触发return,path: /renderer/components/Classroom/LargeClass/base/chats/components/footer.vue');
                    } else {
                        var o = rs(this.inputBox), a = s.substring(0, o) + '[e]' + e + '[e]' + s.substring(o, s.length);
                        this.privateMessageStatus ? this.privateInputStatus.text = a : this.$emit('changeInputText', a);
                        this.inputBox.focus();
                    }
                },
                handleSelectHotWord: function (e) {
                    if (console.info('对象函数 handleSelectHotWord(word)', e, 'filePath:renderer/components/Classroom/LargeClass/base/chats/components/footer.vue'), L.a.send({
                        tag: 'action',
                        content: { msg: '选择热词' }
                    }), this.showHotWord = false, this.handleIn3s()) {
                        console.info('if(this.handleIn3s())为true触发return,path: /renderer/components/Classroom/LargeClass/base/chats/components/footer.vue');
                    } else {
                        var t = {
                            type: es.mine,
                            name: this.msgTip.SPEECH_MINE,
                            msg: e,
                            evenexc: this.rightLabel
                        };
                        this.$emit('handleSetMessage', false, t);
                        this.reSensorEvent('hw_classroom_chat_shortcut', { sentence_content: e });
                        Rs.c(t);
                    }
                },
                handleOpenHotWord: function () {
                    console.info('对象函数 handleOpenHotWord,filePath:renderer/components/Classroom/LargeClass/base/chats/components/footer.vue');
                    L.a.send({
                        tag: 'action',
                        content: { msg: '打开热词面板' }
                    });
                    this.showHotWord = true;
                },
                closeHotWordPane: function (e) {
                    console.info('对象函数 closeHotWordPane(e)', e, 'filePath:renderer/components/Classroom/LargeClass/base/chats/components/footer.vue');
                    L.a.send({
                        tag: 'action',
                        content: { msg: '关闭热词面板' }
                    });
                    var t = document.querySelector('#quick-fadeback'), s = t == e.target;
                    s ? console.info('if(clickDom)为true触发return,path: /renderer/components/Classroom/LargeClass/base/chats/components/footer.vue') : this.showHotWord = s;
                },
                handleSendMessage: function () {
                    console.info('对象函数 handleSendMessage,filePath:renderer/components/Classroom/LargeClass/base/chats/components/footer.vue');
                    L.a.send({
                        tag: 'action',
                        content: {
                            msg: '发送消息',
                            inputStatus: this.inputStatus
                        }
                    });
                    var e = this.inputStatus, t = e.text, s = e.status;
                    t.length ? this.handleIn3s() ? console.info('if(this.handleIn3s())为true触发return,path: /renderer/components/Classroom/LargeClass/base/chats/components/footer.vue') : (t.trim().length > 0 && 3 === s && (this.inputStatus.text = '', this.$emit('handleSetMessage', false, {
                        type: es.mine,
                        name: this.msgTip.SPEECH_MINE,
                        msg: Ps()(t).trim(),
                        evenexc: this.rightLabel
                    }), this.reSensorEvent('hw_classroom_chat_send'), Rs.c({
                        type: es.mine,
                        msg: Ps()(t).trim()
                    })), this.inputBox.focus()) : console.info('if(!text.length)为true触发return,path: /renderer/components/Classroom/LargeClass/base/chats/components/footer.vue');
                },
                handleSetPrivateMessage: function () {
                    console.info('对象函数 handleSetPrivateMessage,filePath:renderer/components/Classroom/LargeClass/base/chats/components/footer.vue');
                    var e = this.privateInputStatus.text;
                    L.a.send({
                        tag: 'action',
                        content: {
                            msg: '发送私聊消息',
                            privateInputStatus: this.privateInputStatus
                        }
                    });
                    e.length ? e.trim().length > 0 && (this.inputBox.blur(), this.privateInputStatus.text = '', this.$emit('handleSetPrivateMessage', {
                        type: es.mine,
                        name: this.msgTip.SPEECH_MINE,
                        msg: Ps()(e).trim()
                    }), this.reSensorEvent('hw_classroom_tutor_message_reply')) : console.info('if(!text.length)为true触发return,path: /renderer/components/Classroom/LargeClass/base/chats/components/footer.vue');
                },
                handleIn3s: function () {
                    return console.info('对象函数 handleIn3s,filePath:renderer/components/Classroom/LargeClass/base/chats/components/footer.vue'), 4 === this.inputStatus.status && (console.info('if(this.inputStatus.status === 4)为true触发return,path: /renderer/components/Classroom/LargeClass/base/chats/components/footer.vue'), this.$emit('handleSetMessage', false, {
                        type: es.system,
                        name: this.msgTip.SPEECH_SYS,
                        msg: this.msgTip.SPEECH_INTERVAL
                    }), true);
                },
                handleNewMsg: function () {
                    console.info('对象函数 handleNewMsg,filePath:renderer/components/Classroom/LargeClass/base/chats/components/footer.vue');
                    L.a.send({
                        tag: 'action',
                        content: { msg: '点击新消息事件' }
                    });
                    this.$emit('handleSetNewMsgStatus', false);
                    J.a.emit('logger', {
                        type: 'interactive',
                        data: {
                            logtype: 'newMessage',
                            isPlayBack: this.isPlayBack,
                            planId: this.planId
                        }
                    });
                },
                handleTeacherOnly: function () {
                    console.info('对象函数 handleTeacherOnly,filePath:renderer/components/Classroom/LargeClass/base/chats/components/footer.vue');
                    this.showTeacherOnly = !this.showTeacherOnly;
                    this.showTeacherOnly && (this.reSensorEvent('hw_classroom_teacher_only_show'), this.showHotWord = false);
                },
                changeTeacherOnly: function () {
                    console.info('对象函数 changeTeacherOnly,filePath:renderer/components/Classroom/LargeClass/base/chats/components/footer.vue');
                    this.$parent.handleSwitchMessage();
                    this.reSensorEvent('hw_classroom_teacher_only_switch', { switch_type: this.lockTeacherMessage ? 1 : 0 });
                },
                handleTeacherOnlyMouseenter: function () {
                    console.info('对象函数 handleTeacherOnlyMouseenter,filePath:renderer/components/Classroom/LargeClass/base/chats/components/footer.vue');
                    this.teacherOnlyTimer && clearTimeout(this.teacherOnlyTimer);
                },
                handleTeacherOnlyMouseleave: function () {
                    var e = this;
                    console.info('对象函数 handleTeacherOnlyMouseleave,filePath:renderer/components/Classroom/LargeClass/base/chats/components/footer.vue');
                    this.teacherOnlyTimer = setTimeout(function () {
                        e.showTeacherOnly = false;
                    }, 500);
                }
            }
        }, Gs = Us, Hs = (s('fb75'), Object(Ae.a)(Gs, Ss, ws, false, null, '51c3aeb6', null)), _s = Hs.exports, Fs = (s('ef91'), {
            components: {
                MessageArea: bs,
                Footer: _s
            },
            props: {
                options: {
                    type: Object,
                    default: function () {
                        return console.info('对象函数 default,filePath:renderer/components/Classroom/LargeClass/base/chats/index.vue'), {
                            counselorInfo: {},
                            isPlayBack: false,
                            planId: ''
                        };
                    }
                }
            },
            data: function () {
                var e = this.$t('classroom.largeClass.chats');
                return {
                    msgTip: e.msgTip,
                    smallClassSwitchType: 'video',
                    privateMessageStatus: false,
                    lottieEmojiLists: [],
                    teamSwitchStatus: null,
                    ChatClass: {
                        inputStatus: {
                            status: 5,
                            text: ''
                        }
                    }
                };
            },
            computed: {
                classType: function () {
                    return console.info('对象函数 classType,filePath:renderer/components/Classroom/LargeClass/base/chats/index.vue'), this.options.classType;
                },
                showFooter: function () {
                    return console.info('对象函数 showFooter,filePath:renderer/components/Classroom/LargeClass/base/chats/index.vue'), !this.options.isAudition;
                },
                isShowChat: function () {
                    return console.info('对象函数 isShowChat,filePath:renderer/components/Classroom/LargeClass/base/chats/index.vue'), !this.classType || 'video' !== this.smallClassSwitchType || (console.info('if(this.classType && this.smallClassSwitchType === \'video\')为true触发return,path: /renderer/components/Classroom/LargeClass/base/chats/index.vue'), false);
                },
                diffClassStyle: function () {
                    return console.info('对象函数 diffClassStyle,filePath:renderer/components/Classroom/LargeClass/base/chats/index.vue'), 1 === this.classType || 2 === this.classType ? (console.info('if(this.classType === 1 || this.classType === 2)为true触发return,path: /renderer/components/Classroom/LargeClass/base/chats/index.vue'), 'small-class-chat-wrapper') : 0 === this.classType && false === this.teamSwitchStatus ? (console.info('if(this.classType === 0 && this.teamSwitchStatus === false)为true触发return,path: /renderer/components/Classroom/LargeClass/base/chats/index.vue'), 'chat-wrapper-no-video') : 0 === this.classType && true === this.teamSwitchStatus ? (console.info('if(this.classType === 0 && this.teamSwitchStatus === true)为true触发return,path: /renderer/components/Classroom/LargeClass/base/chats/index.vue'), 'chat-wrapper-video') : void 0;
                },
                peopleOnline: function () {
                    console.info('对象函数 peopleOnline,filePath:renderer/components/Classroom/LargeClass/base/chats/index.vue');
                    var e = this.ChatClass.userList, t = e ? e.length : 0;
                    return Object(z.c)() && Object(ds.b)({ onlineNum: t }), t;
                },
                messages: function () {
                    console.info('对象函数 messages,filePath:renderer/components/Classroom/LargeClass/base/chats/index.vue');
                    var e = this.ChatClass.messages, t = e || [];
                    return t;
                },
                privateMessages: function () {
                    console.info('对象函数 privateMessages,filePath:renderer/components/Classroom/LargeClass/base/chats/index.vue');
                    var e = this.ChatClass.privateMessages, t = e || [];
                    return t;
                },
                inputText: function () {
                    return console.info('对象函数 inputText,filePath:renderer/components/Classroom/LargeClass/base/chats/index.vue'), this.ChatClass.inputStatus.text;
                },
                selfChatStatus: function () {
                    console.info('对象函数 selfChatStatus,filePath:renderer/components/Classroom/LargeClass/base/chats/index.vue');
                    this.ChatClass;
                    var e = this.ChatClass.inputStatus || {}, t = e.status, s = void 0 === t ? 5 : t;
                    return 2 === s ? sessionStorage.setItem('stopSpeaking', true) : sessionStorage.setItem('stopSpeaking', false), s;
                }
            },
            mounted: function () {
                var e = this;
                this.options;
                this.$bus.$on('handleLargeNativeEmoji', function (t) {
                    console.info('箭头函数 监听 handleLargeNativeEmoji(params)', t, 'filePath:renderer/components/Classroom/LargeClass/base/chats/index.vue');
                    e.handleSetNewSingleEmoji(t);
                });
                this.getTeamSwitchStatus();
                this.bindEvent();
                this.initDynamicEmoji();
                this.$nextTick(function () {
                    window.addEventListener('scroll', e.handleOnScroll, true);
                });
            },
            methods: {
                handleOnScroll: function () {
                    console.info('对象函数 handleOnScroll,filePath:renderer/components/Classroom/LargeClass/base/chats/index.vue');
                    var e = document.getElementById('messagesRef'), s = e.scrollTop + e.clientHeight + 1;
                    e.scrollHeight <= s && (this.ChatClass.hasNewMsg = false, this.ChatClass.hasPrivateNewMsg = false);
                },
                bindEvent: function () {
                    var e = this;
                    console.info('对象函数 bindEvent,filePath:renderer/components/Classroom/LargeClass/base/chats/index.vue');
                    this.$bus.$on('updateTeamSwitchStatus', function (t) {
                        console.info('箭头函数 监听 updateTeamSwitchStatus(status)', t, 'filePath:renderer/components/Classroom/LargeClass/base/chats/index.vue');
                        e.teamSwitchStatus = t;
                    });
                    this.$bus.$on('chats.changePrivateMessageStatus', function (t) {
                        console.info('箭头函数 监听 chats.changePrivateMessageStatus(status)', t, 'filePath:renderer/components/Classroom/LargeClass/base/chats/index.vue');
                        e.privateMessageStatus = t;
                        setTimeout(function () {
                            e.handleSetNewMsgStatus();
                        }, 0);
                    });
                    this.$bus.$on('switchVideoAndChat', function (t) {
                        console.info('箭头函数 监听 switchVideoAndChat(type)', t, 'filePath:renderer/components/Classroom/LargeClass/base/chats/index.vue');
                        L.a.send({
                            tag: 'action',
                            content: { msg: '伪小班模式切换视频和聊天' }
                        });
                        e.smallClassSwitchType = t;
                    });
                },
                getTeamSwitchStatus: function () {
                    var e = this;
                    return Object(A.a)(Object(P.a)().mark(function t() {
                        var s;
                        return Object(P.a)().wrap(function (t) {
                            while (1) {
                                switch (t.prev = t.next) {
                                    case 0:
                                        return console.info('对象函数 getTeamSwitchStatus,filePath:renderer/components/Classroom/LargeClass/base/chats/index.vue'), t.next = 3, window.thinkApi.ipc.invoke('getStoreValue', 'videoGroupSwitchStatus_'.concat(e.options.planId));
                                    case 3:
                                        s = t.sent, e.teamSwitchStatus = void 0 === s || s;
                                    case 6:
                                    case 'end':
                                        return t.stop();
                                }
                            }
                        }, t);
                    }))();
                },
                handleSwitchMessage: function () {
                    console.info('对象函数 handleSwitchMessage,filePath:renderer/components/Classroom/LargeClass/base/chats/index.vue');
                    this.ChatClass.lockTeacherMessage = !this.ChatClass.lockTeacherMessage;
                    this.ChatClass.lockTeacherMessage;
                },
                handleSetMessage: function (e, t) {
                    if (console.info('对象函数 handleSetMessage(flag, data)', e, t, 'filePath:renderer/components/Classroom/LargeClass/base/chats/index.vue'), e) {
                        return console.info('if(flag)为true触发return,path: /renderer/components/Classroom/LargeClass/base/chats/index.vue'), this.ChatClass.messages = [], this.ChatClass.userNotInMegBottom = false, void J.a.emit('logger', {
                            type: 'interactive',
                            data: {
                                logtype: 'clearScreen',
                                isPlayBack: this.options.isPlayBack,
                                planId: this.options.planId
                            }
                        });
                    }
                    var s = t.type, o = t.name, a = t.msg, n = t.evenexc, r = t.lottieUrl, i = t.emojiType, c = t.emojiId, l = t.isNewEmoji, u = t.emojiPicture, d = void 0 === u ? '' : u;
                    try {
                        a = is(a);
                    } catch (m) {
                        console.error('handleSetMessage replaceExpressName', a, m);
                    }
                    this.ChatClass.setMessage({
                        type: s,
                        emojiPicture: d,
                        name: o,
                        msg: a,
                        lottieUrl: r,
                        emojiId: c,
                        emojiType: i,
                        isNewEmoji: l,
                        evenexc: n
                    });
                },
                initDynamicEmoji: function () {
                    var e = this;
                    return Object(A.a)(Object(P.a)().mark(function t() {
                        return Object(P.a)().wrap(function (t) {
                            while (1) {
                                switch (t.prev = t.next) {
                                    case 0:
                                        return console.info('对象函数 initDynamicEmoji,filePath:renderer/components/Classroom/LargeClass/base/chats/index.vue'), t.next = 3, Object(ms.a)().then(function (t) {
                                            e.lottieEmojiLists = t;
                                        });
                                    case 3:
                                    case 'end':
                                        return t.stop();
                                }
                            }
                        }, t);
                    }))();
                },
                handleSetPrivateMessage: function (e) {
                    console.info('对象函数 handleSetPrivateMessage(data)', e, 'filePath:renderer/components/Classroom/LargeClass/base/chats/index.vue');
                    var t = e.type, s = e.name, o = e.msg;
                    try {
                        o = is(o);
                    } catch (a) {
                        console.error('handleSetPrivateMessage', o, a);
                    }
                    this.ChatClass.setPrivateMessage({
                        type: t,
                        name: s,
                        msg: o
                    });
                },
                handleInputKeyDown: function () {
                    console.info('对象函数 handleInputKeyDown,filePath:renderer/components/Classroom/LargeClass/base/chats/index.vue');
                    this.ChatClass.inputStatus.text = this.ChatClass.inputStatus.text.slice(0, 200);
                },
                handleInputText: function (e) {
                    console.info('对象函数 handleInputText(newText)', e, 'filePath:renderer/components/Classroom/LargeClass/base/chats/index.vue');
                    this.ChatClass.inputStatus.text = e;
                },
                handleSetNewMsgStatus: function (e) {
                    console.info('对象函数 handleSetNewMsgStatus(status)', e, 'filePath:renderer/components/Classroom/LargeClass/base/chats/index.vue');
                    this.ChatClass.hasNewMsg = e;
                    this.ChatClass.hasPrivateNewMsg = e;
                    this.ChatClass.messagesRef.scrollTop = this.ChatClass.messagesRef.scrollHeight;
                },
                handleSetNewSingleEmoji: function (e) {
                    console.info('对象函数 handleSetNewSingleEmoji(params)', e, 'filePath:renderer/components/Classroom/LargeClass/base/chats/index.vue');
                    this.handleSetMessage(false, {
                        type: es.mine,
                        name: this.msgTip.SPEECH_MINE,
                        msg: e.name,
                        emojiType: e.type,
                        emojiPicture: e.emojiPicture,
                        emojiId: e.emojiId ? e.emojiId : 0,
                        lottieUrl: e.lottieUrl ? e.lottieUrl : '',
                        isNewEmoji: true
                    });
                }
            },
            beforeDestroy: function () {
                console.info('对象函数 beforeDestroy,filePath:renderer/components/Classroom/LargeClass/base/chats/index.vue');
                this.$bus.$off('handleLargeNativeEmoji');
                window.removeEventListener('scroll', this.handleOnScroll);
            }
        }), Ws = Fs, Ks = (s('6ffc'), Object(Ae.a)(Ws, Xt, $t, false, null, '4c214308', null)), qs = Ks.exports, zs = s('bc80'), Js = (s('14d9'), s('cca6'), s('4de4'), s('d396')), Qs = function () {
            function e() {
                var t = arguments.length > 0 && void 0 !== arguments[0] ? arguments[0] : {};
                console.info('函数申明 ChatMain(options)', t, 'filePath:renderer/components/Classroom/LargeClass/base/chats/chat-main.js');
                Object(g.a)(this, e);
                this.options = t;
                this.msgTip = t.msgTip;
                this.inputStatusMap = t.inputStatusMap;
                this.blurTimer = null;
                this.isWindowBlur = false;
                var s = {
                    stuInRoom: false,
                    teaInRoom: false,
                    lockTeacherMessage: false,
                    hasNewMsg: false,
                    hasPrivateNewMsg: false,
                    userNotInMegBottom: true,
                    myName: '',
                    messages: [],
                    privateMessages: [],
                    encourageData: [],
                    encourageStatus: false,
                    userList: [],
                    inputStatus: {
                        openChat: false,
                        text: this.inputStatusMap[5],
                        status: 5
                    },
                    messagesRef: document.getElementById('messagesRef'),
                    parentData: {},
                    playBackData: {
                        originMessages: [],
                        streamTime: 0,
                        preventRequestCon: 0,
                        lessDataCon: 0,
                        msgEndTime: null
                    },
                    discussInteractionData: {},
                    isBrokenLine: true,
                    sendRoomMessageFail: false,
                    sendPrivateMessageFail: false
                }, o = Object.assign(s, t);
                this.stuInRoom = o.stuInRoom;
                this.teaInRoom = o.teaInRoom;
                this.lockTeacherMessage = o.lockTeacherMessage;
                this.messages = o.messages;
                this.privateMessages = o.privateMessages;
                this.encourageData = o.encourageData;
                this.userList = o.userList;
                this.inputStatus = o.inputStatus;
                this.parentData = o.chatOptions;
                this.playBackData = o.playBackData;
                this.messagesRef = o.messagesRef;
                this.userNotInMegBottom = o.userNotInMegBottom;
                this.hasNewMsg = o.hasNewMsg;
                this.hasPrivateNewMsg = o.hasPrivateNewMsg;
                this.sendMsgFrom = 'flv';
                this.discussInteractionData = o.discussInteractionData;
                this.isBrokenLine = o.isBrokenLine;
                this.encourageStatus = o.encourageStatus;
                this.sendRoomMessageFail = o.sendRoomMessageFail;
                this.sendPrivateMessageFail = o.sendPrivateMessageFail;
                this.mode = this.parentData.streamMode;
                this.goodMethod = false;
                var a = this.parentData.nickName;
                this.myName = a;
            }
            return Object(C.a)(e, [
                {
                    key: 'init',
                    value: function () {
                        var e = this;
                        try {
                            this.initPrivateMessagesHistory();
                            var t = this.parentData, s = t.roomlist, o = t.planId, a = t.stuId;
                            window.onbeforeunload = function () {
                                if (e.stuInRoom) {
                                    var t = {
                                        live_id: o,
                                        uid: a,
                                        roomlist: s,
                                        loginStatus: 'onbeforeunload'
                                    };
                                    J.a.emit('logger', {
                                        type: 'sys',
                                        data: {
                                            logData: t,
                                            logType: 'irc'
                                        }
                                    });
                                } else {
                                    console.info('if(!_this.stuInRoom)为true触发return,path: /renderer/components/Classroom/LargeClass/base/chats/chat-main.js');
                                }
                            };
                        } catch (n) {
                            console.error('%c报错信息', 'color: red;', n.message);
                        }
                    }
                },
                {
                    key: 'onRecvRoomDataUpdateNotice',
                    value: function (e) {
                        var t = this;
                        e.datas ? e.datas.forEach(function (e, s) {
                            var o = JSON.parse(e.value), a = o[s];
                            switch (s) {
                                case 'openchat':
                                    t.handleUpdateNoticeByOpenchat(a);
                                    break;
                                case 'peer_mute_chat':
                                    t.handleUpdateNoticeByPeerMuteChat(a);
                                    break;
                            }
                        }) : console.info('if(!data.datas)为true触发return,path: /renderer/components/Classroom/LargeClass/base/chats/chat-main.js');
                    }
                },
                {
                    key: 'handleUpdateNoticeByOpenchat',
                    value: function (e) {
                        e ? this.setInputStatus(3) : this.setInputStatus(1);
                        L.a.send({
                            tag: 'chatbox',
                            content: { msg: e ? '主讲老师开启聊天区' : '主讲老师关闭聊天区' }
                        });
                    }
                },
                {
                    key: 'handleUpdateNoticeByPeerMuteChat',
                    value: function (e) {
                        var t = e.stuId, s = e.mute;
                        t == this.parentData.stuId && (s ? (this.setInputStatus(2), this.setMessage({
                            type: es.system,
                            name: this.msgTip.SPEECH_SYS,
                            msg: this.msgTip.BAN_SPEECH
                        }), L.a.send({
                            tag: 'chatbox',
                            content: { msg: '已被禁言' }
                        })) : (this.inputStatus.openChat ? this.setInputStatus(3) : this.setInputStatus(1), this.setMessage({
                            type: es.system,
                            name: this.msgTip.SPEECH_SYS,
                            msg: this.msgTip.RELIEVE_SPEECH
                        }), L.a.send({
                            tag: 'chatbox',
                            content: { msg: '解除禁言' }
                        })));
                    }
                },
                {
                    key: 'onGetRoomHistoryMessageResponse',
                    value: function (e) {
                        var t = this;
                        if (0 == e.code) {
                            var s = e.content;
                            if (s && s.length) {
                                var o = [];
                                s.forEach(function (e) {
                                    if (e.priority === 99) {
                                        var s;
                                        try {
                                            s = JSON.parse(e.text);
                                        } catch (d) {
                                            console.error(d);
                                        }
                                        var a, n, r, i, c, l = {}, u = ss(e.sender);
                                        if (u === 0 && (l = {
                                            type: es.teacher_f,
                                            name: s.name,
                                            msg: s.msg,
                                            tutor_avatar: s.tutor_avatar
                                        }), 'send_emoji' == s.ircType || 'animation_emoji' == s.ircType) {
                                            l = {
                                                type: es.stu,
                                                name: e.sender === t.options.configs.stuIrcId ? t.msgTip.SPEECH_MINE : null === (a = s.from) || void 0 === a ? void 0 : a.username,
                                                isMe: e.sender === t.options.configs.stuIrcId,
                                                msg: s.data.name,
                                                emojiType: s.data.type,
                                                lottieUrl: (null === (n = s.data.resource) || void 0 === n ? void 0 : n.lottieUrl) || '',
                                                emojiId: (null === (r = s.data.resource) || void 0 === r ? void 0 : r.emojiId) || 0,
                                                isNewEmoji: true,
                                                avatar: e.sender === t.options.configs.stuIrcId ? '' : null === (i = s.from) || void 0 === i ? void 0 : i.path
                                            };
                                        } else {
                                            if (u === 2 && s.type === 130) {
                                                l = {
                                                    type: es.stu,
                                                    name: e.sender === t.options.configs.stuIrcId ? t.msgTip.SPEECH_MINE : s.name,
                                                    isMe: e.sender === t.options.configs.stuIrcId,
                                                    msg: s.msg,
                                                    isNewEmoji: false,
                                                    avatar: (null === (c = s) || void 0 === c ? void 0 : c.path) || ''
                                                };
                                            }
                                        }
                                        o.push(l);
                                    }
                                });
                                o.reverse();
                                o.length ? (this.messages = o, this.hasNewMsg = false, setTimeout(function () {
                                    t.messagesRef.scrollTop = t.messagesRef.scrollHeight;
                                }, 20)) : console.info('if(!tempMessage.length)为true触发return,path: /renderer/components/Classroom/LargeClass/base/chats/chat-main.js');
                            } else {
                                console.info('if(!messageList || !messageList.length)为true触发return,path: /renderer/components/Classroom/LargeClass/base/chats/chat-main.js');
                            }
                        } else {
                            console.info('if(data.code != 0)为true触发return,path: /renderer/components/Classroom/LargeClass/base/chats/chat-main.js');
                        }
                    }
                },
                {
                    key: 'onLogoutNotice',
                    value: function (e) {
                        if (e.userInfo) {
                            var t, s = e.userInfo.nickname;
                            t = !!ns(s);
                            t ? (this.teaInRoom = false, J.a.emit('interaction', {
                                type: 'onStuAndTeaStatus',
                                data: {
                                    stuInRoom: this.stuInRoom,
                                    teaInRoom: this.teaInRoom
                                }
                            })) : this.userList = this.userList.filter(function (e) {
                                return e !== s;
                            });
                        } else {
                            console.info('if(!res.userInfo)为true触发return,path: /renderer/components/Classroom/LargeClass/base/chats/chat-main.js');
                        }
                    }
                },
                {
                    key: 'recvPeerMessageT',
                    value: function (e) {
                        this.stuInRoom = false;
                        J.a.emit('interaction', {
                            type: 'onStuAndTeaStatus',
                            data: {
                                stuInRoom: this.stuInRoom,
                                teaInRoom: this.teaInRoomx
                            }
                        });
                        this.userList = [];
                        this.setInputStatus(5);
                        this.setMessage({
                            type: es.system,
                            name: this.msgTip.SPEECH_SYS,
                            msg: this.msgTip.REMOTE_LOGIN
                        });
                        v.a.prototype.$bus.$emit('live-kickout', true);
                    }
                },
                {
                    key: 'onKickoutNotice',
                    value: function (e) {
                        301 === e.code && (L.a.send({ tag: 'student.IRCKick' }), L.a.send({
                            tag: 'ircStatus',
                            content: { msg: 'Kickout: '.concat(JSON.stringify(e)) }
                        }), this.recvPeerMessageT(true));
                    }
                },
                {
                    key: 'serverUnkown',
                    value: function () {
                        ;
                        v.a.prototype.$bus.$emit('ircConnectStatus', 0);
                    }
                },
                {
                    key: 'serverUnavailable',
                    value: function () {
                        ;
                        v.a.prototype.$bus.$emit('ircConnectStatus', 1);
                    }
                },
                {
                    key: 'serverFailed',
                    value: function () {
                        ;
                        v.a.prototype.$bus.$emit('ircConnectStatus', 2);
                        L.a.send({
                            tag: 'ircStatus',
                            content: { msg: 'Connection failed' }
                        });
                    }
                },
                {
                    key: 'serverConnection',
                    value: function () {
                        ;
                        v.a.prototype.$bus.$emit('ircConnectStatus', 3);
                        this.setMessage({
                            type: es.system,
                            name: this.msgTip.SPEECH_SYS,
                            msg: this.msgTip.RECONNECT
                        });
                        this.userList = [];
                        this.isBrokenLine = true;
                        L.a.send({
                            tag: 'ircStatus',
                            content: { msg: 'Connecting' }
                        });
                    }
                },
                {
                    key: 'serverConnected',
                    value: function () {
                        v.a.prototype.$Notification.destroy();
                        document.getElementById('interactionFullPage').removeAttribute('style');
                        ;
                        v.a.prototype.$bus.$emit('ircConnectStatus', 4);
                        L.a.send({
                            tag: 'ircStatus',
                            content: { msg: 'Connection successful' }
                        });
                    }
                },
                {
                    key: 'disconnect',
                    value: function () {
                        ;
                        v.a.prototype.$bus.$emit('ircConnectStatus', 5);
                        L.a.send({
                            tag: 'ircStatus',
                            content: { msg: 'Disconnect' }
                        });
                    }
                },
                {
                    key: 'onJoinRoomResponse',
                    value: function (e) {
                        0 == e.code ? (this.isBrokenLine = false, this.setMessage({
                            type: es.system,
                            name: this.msgTip.SPEECH_SYS,
                            msg: this.msgTip.CONNECT
                        }), this.setInputStatus(3), this.stuInRoom = true, J.a.emit('interaction', {
                            type: 'onStuAndTeaStatus',
                            data: {
                                stuInRoom: this.stuInRoom,
                                teaInRoom: this.teaInRoom
                            }
                        })) : console.info('if(res.code != 0)为true触发return,path: /renderer/components/Classroom/LargeClass/base/chats/chat-main.js');
                    }
                },
                {
                    key: 'setInputStatus',
                    value: function (e) {
                        this.inputStatus.status = e;
                        this.inputStatus.text = this.inputStatusMap[e];
                        1 == e && (this.inputStatus.openChat = false);
                        3 == e && (this.inputStatus.openChat = true);
                    }
                },
                {
                    key: 'onSendRoomMessageResponse',
                    value: function (e) {
                        var t;
                        this.sendRoomMessageFail = 0 !== e.code;
                        var s = this.messages.length - 1;
                        (null === (t = this.messages[s]) || void 0 === t ? void 0 : t.type) === es.mine && v.a.prototype.$set(this.messages[s], 'messageStatus', this.sendRoomMessageFail);
                    }
                },
                {
                    key: 'onSendPeerMessageResponse',
                    value: function (e) {
                        var t;
                        this.sendPrivateMessageFail = 0 !== e.code;
                        var s = this.privateMessages.length - 1;
                        (null === (t = this.privateMessages[s]) || void 0 === t ? void 0 : t.type) === es.mine && v.a.prototype.$set(this.privateMessages[s], 'messageStatus', this.sendPrivateMessageFail);
                    }
                },
                {
                    key: 'onJoinRoomNotice',
                    value: function (e) {
                        if (e.userInfo) {
                            var t = e.userInfo.nickname;
                            if (ns(t)) {
                                return console.info('if(isTeacher(nickname))为true触发return,path: /renderer/components/Classroom/LargeClass/base/chats/chat-main.js'), this.teaInRoom = true, void J.a.emit('interaction', {
                                    type: 'onStuAndTeaStatus',
                                    data: {
                                        stuInRoom: this.stuInRoom,
                                        teaInRoom: this.teaInRoom
                                    }
                                });
                            }
                            this.userList.push(e.userInfo.nickname);
                        } else {
                            console.info('if(!res.userInfo)为true触发return,path: /renderer/components/Classroom/LargeClass/base/chats/chat-main.js');
                        }
                    }
                },
                {
                    key: 'onRecvRoomUserList',
                    value: function (e) {
                        var t = this;
                        if (this.teaInRoom = false, J.a.emit('interaction', {
                            type: 'onStuAndTeaStatus',
                            data: {
                                stuInRoom: this.stuInRoom,
                                teaInRoom: this.teaInRoom
                            }
                        }), e.userList.filter(function (e) {
                            var s = e.nickname;
                            t.userList.includes(s) || t.userList.push(s);
                        }), 53 === e.code) {
                            for (var s = 0; s < this.userList.length; s++) {
                                if (ns(this.userList[s])) {
                                    this.teaInRoom = true;
                                    J.a.emit('interaction', {
                                        type: 'onStuAndTeaStatus',
                                        data: {
                                            stuInRoom: this.stuInRoom,
                                            teaInRoom: this.teaInRoom
                                        }
                                    });
                                    break;
                                }
                            }
                        }
                    }
                },
                {
                    key: 'onLeaveRoomNotice',
                    value: function (e) {
                        if (e.userInfo) {
                            var t = e.userInfo.nickname;
                            ns(t) ? (this.teaInRoom = false, J.a.emit('interaction', {
                                type: 'onStuAndTeaStatus',
                                data: {
                                    stuInRoom: this.stuInRoom,
                                    teaInRoom: this.teaInRoom
                                }
                            })) : this.userList = this.userList.filter(function (e) {
                                return e !== t;
                            });
                        }
                    }
                },
                {
                    key: 'onRecvRoomMessage',
                    value: function (e) {
                        var t = e.messagePriority, s = e.content, o = e.fromUserInfo, a = void 0 === o ? {} : o, n = a.nickname, r = void 0 === n ? '' : n, i = ss(r), c = JSON.parse(s);
                        t === 99 && this.recvRoomMessagePri(c, i);
                    }
                },
                {
                    key: 'recvRoomMessagePri',
                    value: function (e, t) {
                        var s = e.type, o = e.name, a = e.msg, n = e.tutor_avatar, r = void 0 === n ? '' : n;
                        if (e.type == 142) {
                            return console.info('if(data.type == ircMsgType.CONTINUS_CORRECT)为true触发return,path: /renderer/components/Classroom/LargeClass/base/chats/chat-main.js'), void v.a.prototype.$bus.$emit('chats.correctMedalData', e);
                        }
                        var i = {};
                        if (1 * s === 130) {
                            (o !== this.myName || this.options.commonOption.isParent) && (t === 0 && (i = {
                                type: es.teacher_f,
                                name: o,
                                msg: a,
                                tutor_avatar: r
                            }), t === 2 && (i = {
                                type: es.stu,
                                name: o,
                                msg: a,
                                avatar: e.path || ''
                            }));
                        } else {
                            var c, l, u, d = {
                                type: es.stu,
                                name: null === (c = e.from) || void 0 === c ? void 0 : c.username,
                                isMe: false,
                                msg: null === (l = e.data) || void 0 === l ? void 0 : l.name,
                                isNewEmoji: true,
                                avatar: (null === (u = e.from) || void 0 === u ? void 0 : u.path) || ''
                            };
                            if ('send_emoji' == e.ircType && 1 == e.data.type) {
                                i = d;
                            } else {
                                if ('animation_emoji' == e.ircType && (2 == e.data.type || 3 == e.data.type)) {
                                    var m, h;
                                    i = Object(F.a)(Object(F.a)({}, d), {}, {
                                        lottieUrl: (null === (m = e.data.resource) || void 0 === m ? void 0 : m.lottieUrl) || '',
                                        emojiId: (null === (h = e.data.resource) || void 0 === h ? void 0 : h.emojiId) || 0,
                                        emojiType: e.data.type
                                    });
                                }
                            }
                        }
                        this.setMessage(i);
                    }
                },
                {
                    key: 'onRecvPeerMessage',
                    value: function (e) {
                        var t = e.msgPriority, s = e.content, o = e.fromUserInfo, a = void 0 === o ? {} : o, n = a.nickname, r = void 0 === n ? '' : n, i = ss(r), c = JSON.parse(s);
                        t === 99 && this.recvPeerMessagePri(c, i);
                    }
                },
                {
                    key: 'recvPeerMessagePri',
                    value: function (e) {
                        var t = e.type, s = e.name, o = e.msg, a = e.tutor_avatar, n = e.suid;
                        if (this.parentData, t == 130 && n == this.parentData.stuId && (this.setPrivateMessage({
                            type: es.teacher_f,
                            name: s,
                            msg: o,
                            isPrivateMsg: true,
                            tutor_avatar: a
                        }), v.a.prototype.$bus.$emit('chats.privateMessagePush')), 140 == t) {
                            var r = e.parameter ? e.parameter : e.msg, i = JSON.parse(r).correct_picrure_t;
                            if (!i) {
                                return void console.info('if(!correctPicrure)为true触发return,path: /renderer/components/Classroom/LargeClass/base/chats/chat-main.js');
                            }
                            v.a.prototype.$bus.$emit('chats.assignmentCheckedPush', i);
                        }
                    }
                },
                {
                    key: 'setPrivateMessage',
                    value: function () {
                        var e = Object(A.a)(Object(P.a)().mark(function e(t) {
                            var s, o, a, n;
                            return Object(P.a)().wrap(function (e) {
                                while (1) {
                                    switch (e.prev = e.next) {
                                        case 0:
                                            if (this.privateMessages.length >= 300 && (this.privateMessages = this.privateMessages.slice(-299)), this.privateMessages.push(t), t.type !== es.mine) {
                                                e.next = 10;
                                                break;
                                            }
                                            return e.next = 5, Object(oe.a)();
                                        case 5:
                                            s = e.sent, o = s.avatar, a = this.options.configs.tutorIrcId, n = {
                                                nickname: a,
                                                content: this.baseCommonUserInfo(t, o),
                                                chatMsgPriority: 99
                                            }, it.a.sendPeerMessage(n);
                                        case 10:
                                            this.handleNewMessageTip(t);
                                        case 11:
                                        case 'end':
                                            return e.stop();
                                    }
                                }
                            }, e, this);
                        }));
                        function t(t) {
                            return console.info('函数申明 setPrivateMessage(_x)', t, 'filePath:renderer/components/Classroom/LargeClass/base/chats/chat-main.js'), e.apply(this, arguments);
                        }
                        return t;
                    }()
                },
                {
                    key: 'setMessagejudge',
                    value: function (e) {
                        this.lockTeacherMessage && e.type === es.stu ? console.info('if(this.lockTeacherMessage && data.type === msgUserType.stu)为true触发return,path: /renderer/components/Classroom/LargeClass/base/chats/chat-main.js') : (this.messages.length >= 300 && (this.messages = this.messages.slice(-299)), this.parentData.isPlayBack ? this.messages.push(e) : this.liveJudge(e), this.handleNewMessageTip(e));
                    }
                },
                {
                    key: 'handleNewMessageTip',
                    value: function (e) {
                        var s = this.messagesRef, o = s.scrollHeight <= s.scrollTop + s.clientHeight + 1;
                        o || e.type === es.mine ? v.a.prototype.$nextTick(function () {
                            s.scrollTop = s.scrollHeight;
                        }) : (e.type !== es.mine && (this.hasNewMsg = true), e.type == es.teacher_f && (this.hasPrivateNewMsg = true));
                    }
                },
                {
                    key: 'liveJudge',
                    value: function () {
                        var e = Object(A.a)(Object(P.a)().mark(function e(t) {
                            var s, o, a, n, r, i, c, l, u, d = this;
                            return Object(P.a)().wrap(function (e) {
                                while (1) {
                                    switch (e.prev = e.next) {
                                        case 0:
                                            if (!this.isBrokenLine) {
                                                e.next = 4;
                                                break;
                                            }
                                            return console.info('if(this.isBrokenLine)为true触发return,path: /renderer/components/Classroom/LargeClass/base/chats/chat-main.js'), this.messages.push({
                                                type: es.system,
                                                name: this.msgTip.SPEECH_SYS,
                                                msg: this.msgTip.CHAT_DISCONNECT,
                                                lottieUrl: t.lottieUrl,
                                                emojiId: t.emojiId,
                                                emojiType: t.emojiType,
                                                isNewEmoji: t.isNewEmoji
                                            }), e.abrupt('return');
                                        case 4:
                                            if (this.messages.push(t), t.type !== es.mine) {
                                                e.next = 17;
                                                break;
                                            }
                                            return o = this.parentData.roomlist, e.next = 9, Object(oe.a)();
                                        case 9:
                                            a = e.sent, n = a.nickName, r = a.avatar, t.isNewEmoji ? (i = {
                                                roomlist: o,
                                                content: {
                                                    ircType: 'send_emoji',
                                                    data: {
                                                        name: t.msg,
                                                        type: t.emojiType
                                                    },
                                                    from: {
                                                        username: n,
                                                        path: r
                                                    }
                                                },
                                                chatMsgPriority: 99
                                            }, 1 == t.emojiType ? s = i : 2 != t.emojiType && 3 != t.emojiType || (s = i, s.content.ircType = 'animation_emoji', s.content.data.resource = {
                                                emojiName: t.msg,
                                                emojiId: t.emojiId,
                                                emojiPicture: t.emojiPicture,
                                                lottieUrl: t.lottieUrl
                                            })) : s = {
                                                roomlist: o,
                                                content: this.baseCommonUserInfo(t, r),
                                                chatMsgPriority: 99
                                            }, it.a.sendRoomMessage(s), c = this.parentData.discussInteractionUrl, c && this.discussInteractionData && this.discussInteractionData.pub && this.sendMegToInterface(this.discussInteractionData.interactId, t.msg, c), 3 === this.inputStatus.status && (this.inputStatus.status = 4, l = null, u = 0, clearInterval(l), l = setInterval(function () {
                                                u++;
                                                u >= 3 && (4 === d.inputStatus.status && (d.inputStatus.status = 3), clearInterval(l), l = null);
                                            }, 1000));
                                        case 17:
                                        case 'end':
                                            return e.stop();
                                    }
                                }
                            }, e, this);
                        }));
                        function t(t) {
                            return console.info('函数申明 liveJudge(_x2)', t, 'filePath:renderer/components/Classroom/LargeClass/base/chats/chat-main.js'), e.apply(this, arguments);
                        }
                        return t;
                    }()
                },
                {
                    key: 'sendMegToInterface',
                    value: function () {
                        var e = Object(A.a)(Object(P.a)().mark(function e(t, s, o) {
                            var a, n, r, i, c, l, u, d, m, h;
                            return Object(P.a)().wrap(function (e) {
                                while (1) {
                                    switch (e.prev = e.next) {
                                        case 0:
                                            return a = this.parentData, n = a.bizId, r = a.planId, i = a.nick, c = a.psId, l = a.imgPath, u = a.stuName, d = a.classId, m = a.teamId, e.next = 3, Js.a.post(o, {
                                                bizId: n,
                                                planId: r,
                                                interactionId: t,
                                                message: s,
                                                stuIrcId: i,
                                                psId: c,
                                                imgPath: l,
                                                name: u,
                                                classId: d,
                                                teamId: m,
                                                businessType: 3
                                            });
                                        case 3:
                                            h = e.sent, h.stat || J.a.emit('exception', {
                                                level: 'toast',
                                                data: {
                                                    message: h.msg,
                                                    duration: '1000'
                                                }
                                            }), J.a.emit('logger', {
                                                type: 'interactive',
                                                data: {
                                                    elem: document.body,
                                                    eventtype: 'live_liveroom',
                                                    stable: 1,
                                                    sno: '100.3',
                                                    logtype: 'submit',
                                                    ex: 1 === h.stat ? 'Y' : 'N',
                                                    interactionId: t
                                                }
                                            });
                                        case 6:
                                        case 'end':
                                            return e.stop();
                                    }
                                }
                            }, e, this);
                        }));
                        function t(t, s, o) {
                            return console.info('函数申明 sendMegToInterface(_x3, _x4, _x5)', t, s, o, 'filePath:renderer/components/Classroom/LargeClass/base/chats/chat-main.js'), e.apply(this, arguments);
                        }
                        return t;
                    }()
                },
                {
                    key: 'setMessage',
                    value: function (e) {
                        this.setMessagejudge(e);
                    }
                },
                {
                    key: 'baseCommonUserInfo',
                    value: function (e, t) {
                        return {
                            from: this.sendMsgFrom,
                            name: this.myName,
                            msg: e.msg,
                            type: 130,
                            evenexc: e.evenexc,
                            path: t
                        };
                    }
                },
                {
                    key: 'getBaseTime',
                    value: function () {
                        var e = this.parentData, t = e.gotoClassTime, s = e.stime;
                        return t || parseInt(s);
                    }
                },
                {
                    key: 'initPrivateMessagesHistory',
                    value: function () {
                        var e = Object(A.a)(Object(P.a)().mark(function e() {
                            var t, s, o, a, n = this;
                            return Object(P.a)().wrap(function (e) {
                                while (1) {
                                    switch (e.prev = e.next) {
                                        case 0:
                                            return e.next = 2, Object(Q.q)({
                                                planId: this.parentData.planId,
                                                tutorId: this.options.counselorInfo.id
                                            });
                                        case 2:
                                            if (t = e.sent, t && 0 == t.code) {
                                                e.next = 7;
                                                break;
                                            }
                                            return console.info('if(!res || res.code != 0)为true触发return,path: /renderer/components/Classroom/LargeClass/base/chats/chat-main.js'), e.abrupt('return');
                                        case 7:
                                            if (s = t.data || {}, o = s.list || [], o.length) {
                                                e.next = 12;
                                                break;
                                            }
                                            return console.info('if(!list.length)为true触发return,path: /renderer/components/Classroom/LargeClass/base/chats/chat-main.js'), e.abrupt('return');
                                        case 12:
                                            a = [], o.forEach(function (e) {
                                                var t = JSON.parse(e.message);
                                                e.sendTo == es.stu && a.push({
                                                    type: es.mine,
                                                    msg: t.msg,
                                                    name: e.studentId == n.options.stuInfo.id ? n.msgTip.SPEECH_MINE : t.name,
                                                    isPrivateMsg: true
                                                });
                                                e.sendTo == es.teacher_f && a.push({
                                                    type: es.teacher_f,
                                                    msg: t.msg,
                                                    name: t.name,
                                                    tutor_avatar: t.tutor_avatar,
                                                    isPrivateMsg: true
                                                });
                                            }), this.privateMessages = a;
                                        case 15:
                                        case 'end':
                                            return e.stop();
                                    }
                                }
                            }, e, this);
                        }));
                        function t() {
                            return console.info('函数申明 initPrivateMessagesHistory, filePath:renderer/components/Classroom/LargeClass/base/chats/chat-main.js'), e.apply(this, arguments);
                        }
                        return t;
                    }()
                }
            ]), e;
        }(), Zs = function (e) {
            Object(b.a)(s, e);
            var t = Object(S.a)(s);
            function s() {
                var e, o = arguments.length > 0 && void 0 !== arguments[0] ? arguments[0] : {};
                return console.info('函数申明 Chat(options)', o, 'filePath:renderer/components/Classroom/LargeClass/base/chats/index.js'), Object(g.a)(this, s), e = t.call(this), e.options = o, e.initChat(o.dom), e;
            }
            return Object(C.a)(s, [
                {
                    key: 'initChat',
                    value: function (e) {
                        this.vm = this.createVueChat(qs);
                        this.render(e, this.vm);
                        var t = this.vm.$t('classroom.largeClass.chats');
                        this.vm.ChatClass = new Qs(Object(F.a)(Object(F.a)({
                            msgTip: t.msgTip,
                            inputStatusMap: t.inputStatusMap
                        }, this.options), {}, { sendMsgFrom: 'flv' }));
                    }
                },
                {
                    key: 'createChatProps',
                    value: function () {
                        var e = {
                            skinType: this.options.configs.skinType,
                            options: this.options.commonOption
                        };
                        return e;
                    }
                },
                {
                    key: 'createVueChat',
                    value: function (e) {
                        var t = v.a.extend(e), s = null, o = this.createChatProps();
                        return s = new t({
                            i18n: se.b,
                            propsData: o
                        }), s.$mount(), this.vm = s, s;
                    }
                },
                {
                    key: 'eventHandler',
                    value: function (e) {
                        this.options;
                        this.vm;
                        var t = e.type, s = e.data;
                        this.vm.ChatClass[t] && this.vm.ChatClass[t](s);
                    }
                }
            ]), s;
        }(zs.a), Ys = s('257e'), Xs = s('ade3'), $s = s('9f67'), eo = function (e) {
            Object(b.a)(s, e);
            var t = Object(S.a)(s);
            function s() {
                for (var e, o = arguments.length, a = new Array(o), n = 0; n < o; n++) {
                    a[n] = arguments[n];
                }
                return console.info('函数申明 LiveExceptionHandler(args)', a, 'filePath:renderer/components/Classroom/LargeClass/base/exception-handler/index.js'), Object(g.a)(this, s), e = t.call.apply(t, [this].concat(a)), Object(Xs.a)(Object(Ys.a)(e), 'isShow', false), e;
            }
            return Object(C.a)(s, [
                {
                    key: 'eventHandler',
                    value: function () {
                        var e = arguments.length > 0 && void 0 !== arguments[0] ? arguments[0] : {}, t = e.level, s = e.data;
                        Object(z.e)(this[t]) && this[t](s);
                    }
                },
                {
                    key: 'networkError',
                    value: function () {
                        var e = arguments.length > 0 && void 0 !== arguments[0] ? arguments[0] : {};
                        4 != e.netStatus ? this.showNotice() : this.closeNotice();
                    }
                },
                {
                    key: 'onSDKProvisionStatusNotice',
                    value: function () {
                        var e = arguments.length > 0 && void 0 !== arguments[0] ? arguments[0] : {};
                        0 != e.status ? this.showNotice() : this.closeNotice();
                    }
                },
                {
                    key: 'showNotice',
                    value: function () {
                        var e = Object(A.a)(Object(P.a)().mark(function e() {
                            var t;
                            return Object(P.a)().wrap(function (e) {
                                while (1) {
                                    switch (e.prev = e.next) {
                                        case 0:
                                            if (this.$createElement, !this.isShow) {
                                                e.next = 4;
                                                break;
                                            }
                                            return console.info('if(this.isShow)为true触发return,path: /renderer/components/Classroom/LargeClass/base/exception-handler/index.js'), e.abrupt('return');
                                        case 4:
                                            return this.isShow = true, e.next = 7, Object(se.a)();
                                        case 7:
                                            t = e.sent, Vue.prototype.$Notification.open({
                                                key: 'networkErrorTip',
                                                description: function (e) {
                                                    var s = t.classroom.modules.networkError;
                                                    return e('div', [
                                                        e('i', { class: 'netError' }),
                                                        e('div', { class: 'description' }, [
                                                            s.notice[0],
                                                            e('br'),
                                                            s.notice[1]
                                                        ])
                                                    ]);
                                                },
                                                class: 'notification-network-error',
                                                placement: 'bottomRight',
                                                bottom: '0px',
                                                onClose: null,
                                                btn: function (e) {
                                                    return e('a-button', {
                                                        class: 'ant-btn-primary',
                                                        attrs: { shape: 'round' }
                                                    }, [t.common.exit]);
                                                },
                                                getContainer: function () {
                                                    return document.getElementById('interactionFullPage');
                                                },
                                                onClick: function () {
                                                    window.location.href = '/';
                                                },
                                                closeIcon: function () {
                                                },
                                                duration: null
                                            }), document.getElementById('interactionFullPage').style.zIndex = '1001';
                                        case 10:
                                        case 'end':
                                            return e.stop();
                                    }
                                }
                            }, e, this);
                        }));
                        function t() {
                            return console.info('函数申明 showNotice, filePath:renderer/components/Classroom/LargeClass/base/exception-handler/index.js'), e.apply(this, arguments);
                        }
                        return t;
                    }()
                },
                {
                    key: 'closeNotice',
                    value: function () {
                        this.isShow = false;
                        Vue.prototype.$Notification.destroy();
                        document.getElementById('interactionFullPage').removeAttribute('style');
                    }
                }
            ]), s;
        }($s.a), to = s('5880'), so = s.n(to), oo = function () {
            var e = this, t = e._self._c;
            return t('div', { staticClass: 'header-wrapper' }, [
                t('Toolbar', { attrs: { 'dark-theme': true } }),
                t('div', {
                    staticClass: 'live-header',
                    class: e.triggerClass,
                    on: {
                        mouseenter: e.handleMouseenter,
                        mouseleave: e.handleMouseleave
                    }
                }, [t('div', { staticClass: 'wrapper' }, [
                    t('div', { staticClass: 'left' }, [t('div', {
                        staticClass: 'icon-goback',
                        on: { click: e.handleBack }
                    })]),
                    t('div', { staticClass: 'center' }, [t('div', { staticClass: 'title' }, [e.planName ? t('span', { staticClass: 'plan-name' }, [e._v(' ' + e._s(e.planName) + ' ')]) : e._e()])]),
                    t('div', { staticClass: 'right' }, [
                        t('div', { staticClass: 'operation-button' }, [
                            e.isPlayBack ? e._e() : t('div', { staticClass: 'item' }, [t('NetworkStatus', { on: { 'update-network-quality': e.updateNetworkQuality } })], 1),
                            t('PrintScreen', { on: { click: e.printScrenClick } }),
                            e.showFeedbackButton ? t('div', { staticClass: 'item' }, [t('div', {
                                staticClass: 'button button-feedback',
                                on: { click: e.handleFeedbackShow }
                            })]) : e._e(),
                            e.showExamReportButton ? t('div', { staticClass: 'item' }, [t('div', {
                                staticClass: 'button button-exam',
                                on: { click: e.handleExamResult }
                            })]) : e._e(),
                            e.showHomeworkButton ? t('div', { staticClass: 'item' }, [t('div', {
                                staticClass: 'button button-homework',
                                on: { click: e.handleOpenAssignmentBox }
                            }, [e.haveNewMessage ? t('span') : e._e()])]) : e._e(),
                            t('div', { staticClass: 'item' }, [t('div', {
                                staticClass: 'button button-refresh',
                                on: { click: e.handleRefresh }
                            })]),
                            this.isPlayBack ? e._e() : t('div', { staticClass: 'item' }, [t('div', {
                                staticClass: 'button button-more',
                                on: { click: e.handleMore }
                            })])
                        ], 1),
                        t('div', {
                            directives: [{
                                name: 'show',
                                rawName: 'v-show',
                                value: e.showMore,
                                expression: 'showMore'
                            }],
                            staticClass: 'operation-more'
                        }, [
                            e.showTeamSwitch ? t('TeamSwitch', {
                                attrs: {
                                    'plan-id': e.planInfo.id,
                                    options: e.options
                                }
                            }) : e._e(),
                            t('DeviceTest')
                        ], 1)
                    ])
                ])]),
                t('div', { staticClass: 'components-box' }, [
                    t('AssignmentBox', {
                        ref: 'assignmentBoxRef',
                        attrs: {
                            'plan-id': e.planInfo.id,
                            options: e.options
                        },
                        on: {
                            hideHeader: e.hideHeader,
                            handleShowMessageTip: e.handleShowMessageTip,
                            handleHideMessageTip: e.handleHideMessageTip
                        }
                    }),
                    t('Feedback', {
                        ref: 'Feedback',
                        attrs: {
                            options: e.options,
                            rtcConfig: e.rtcConfig,
                            downlinkNetworkQuality: e.downlinkNetworkQuality
                        }
                    }),
                    t('ExamReport', { attrs: { commonOptions: e.options } })
                ], 1)
            ], 1);
        }, ao = [], no = s('dfa8'), ro = (s('a4d3'), s('e01a'), function () {
            var e = this, t = e._self._c;
            return e.networkStatus ? t('div', {
                staticClass: 'network-status',
                class: e.networkStatusClass
            }, [
                t('div', {
                    staticClass: 'status-button',
                    on: {
                        mouseenter: e.handleMouseenter,
                        mouseleave: e.handleMouseleave
                    }
                }),
                e.showStatusPanel ? t('div', { staticClass: 'status-panel' }, [t('div', { staticClass: 'panel-wrapper' }, [
                    t('div', { staticClass: 'title-wrapper' }, [
                        t('div', { staticClass: 'icon' }),
                        t('div', { staticClass: 'title' }, [e._v(' ' + e._s(e.statusConfig.title) + ' ')])
                    ]),
                    e.statusConfig.description ? t('div', { staticClass: 'description' }, [e._v(' ' + e._s(e.statusConfig.description) + ' ')]) : e._e()
                ])]) : e._e()
            ]) : e._e();
        }), io = [], co = {
            data: function () {
                return {
                    rtcengine: null,
                    downlinkNetworkQuality: -1,
                    showStatusPanel: false
                };
            },
            computed: {
                networkStatus: function () {
                    console.info('对象函数 networkStatus,filePath:renderer/components/Classroom/LargeClass/base/room/header/NetworkStatus.vue');
                    ;
                    return e[this.downlinkNetworkQuality] || '';
                },
                statusConfig: function () {
                    console.info('对象函数 statusConfig,filePath:renderer/components/Classroom/LargeClass/base/room/header/NetworkStatus.vue');
                    var e = this.$t('classroom.modules.networkStatus.statusMap'), t = {
                        good: { title: e.good.title },
                        normal: { title: e.normal.title },
                        weak: {
                            title: e.weak.title,
                            description: e.weak.description
                        }
                    };
                    return t[this.networkStatus] || {};
                },
                networkStatusClass: function () {
                    return console.info('对象函数 networkStatusClass,filePath:renderer/components/Classroom/LargeClass/base/room/header/NetworkStatus.vue'), this.networkStatus ? 'status-'.concat(this.networkStatus) : '';
                }
            },
            mounted: function () {
                this.networkStatusListener();
            },
            methods: {
                networkStatusListener: function () {
                    var e = this;
                    console.info('对象函数 networkStatusListener,filePath:renderer/components/Classroom/LargeClass/base/room/header/NetworkStatus.vue');
                    var t = window.RTC_COMMON.teacherRtcChannel;
                    t && t.on('localNetworkQuality', function (t, s) {
                        e.downlinkNetworkQuality = s;
                        e.$emit('update-network-quality', s);
                    });
                },
                handleMouseenter: function () {
                    console.info('对象函数 handleMouseenter,filePath:renderer/components/Classroom/LargeClass/base/room/header/NetworkStatus.vue');
                    this.showStatusPanel = true;
                },
                handleMouseleave: function () {
                    console.info('对象函数 handleMouseleave,filePath:renderer/components/Classroom/LargeClass/base/room/header/NetworkStatus.vue');
                    this.showStatusPanel = false;
                }
            }
        }, lo = co, uo = (s('61c1'), Object(Ae.a)(lo, ro, io, false, null, '6ecf2946', null)), mo = uo.exports, ho = function () {
            var e = this, t = e._self._c;
            return e.showStatus ? t('div', { staticClass: 'feedback-wrapper' }, [t('div', { staticClass: 'feedback-popup' }, [
                t('div', {
                    staticClass: 'popup-close',
                    on: { click: e.handleHide }
                }),
                t('div', { staticClass: 'popup-wrapper' }, [
                    t('div', { staticClass: 'popup-header' }, [e._v(' ' + e._s(e.$t('classroom.modules.feedback.headerName')) + ' ')]),
                    t('div', { staticClass: 'popup-contenter' }, [
                        t('FeedbackOptions', { on: { 'update-checked-info': e.updateCheckedInfo } }),
                        t('div', { staticClass: 'feedback-textarea' }, [t('textarea', {
                            directives: [{
                                name: 'model',
                                rawName: 'v-model',
                                value: e.content,
                                expression: 'content'
                            }],
                            attrs: {
                                maxlength: '500',
                                placeholder: e.$t('classroom.modules.feedback.placeholder')
                            },
                            domProps: { value: e.content },
                            on: {
                                input: function (t) {
                                    t.target.composing ? console.info('if($event.target.composing)为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/header/feedback/index.vue') : e.content = t.target.value;
                                }
                            }
                        })]),
                        t('div', {
                            staticClass: 'agree-wrapper',
                            on: { click: e.handleClickAgree }
                        }, [
                            t('div', { staticClass: 'agree-checkbox' }, [e.agreeChecked ? t('div', { staticClass: 'icon-checked' }) : e._e()]),
                            e._v(' ' + e._s(e.$t('classroom.modules.feedback.screenshotTips')) + ' ')
                        ]),
                        t('div', { staticClass: 'button-wrapper' }, [t('a-button', {
                            attrs: {
                                block: '',
                                type: 'primary',
                                shape: 'round',
                                size: 'large'
                            },
                            on: { click: e.handleSend }
                        }, [e._v(' ' + e._s(e.$t('common.send')) + ' ')])], 1)
                    ], 1)
                ])
            ])]) : e._e();
        }, po = [], fo = function () {
            var e = this, t = e._self._c;
            return t('div', { staticClass: 'feedback-options' }, e._l(e.options, function (s, o) {
                return t('div', {
                    key: o,
                    staticClass: 'item',
                    class: { active: e.checkedCode == s.code },
                    on: {
                        click: function (t) {
                            return e.handleClickOption(s);
                        }
                    }
                }, [
                    e.checkedCode == s.code ? t('div', { staticClass: 'icon-checked' }) : e._e(),
                    t('div', { staticClass: 'item-name' }, [e._v(e._s(s.name))])
                ]);
            }), 0);
        }, vo = [], go = {
            data: function () {
                var e = this.$t('classroom.modules.feedback.optionNames');
                return {
                    options: [
                        {
                            code: 'study-question',
                            name: e[0]
                        },
                        {
                            code: 'app-problem',
                            name: e[1]
                        },
                        {
                            code: 'inappropriate-behavior',
                            name: e[2]
                        },
                        {
                            code: 'others',
                            name: e[3]
                        }
                    ],
                    checkedCode: '',
                    checkedName: ''
                };
            },
            methods: {
                handleClickOption: function (e) {
                    if (console.info('对象函数 handleClickOption(item)', e, 'filePath:renderer/components/Classroom/LargeClass/base/room/header/feedback/feedbackOptions.vue'), e.code == this.checkedCode) {
                        return console.info('if(item.code == this.checkedCode)为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/header/feedback/feedbackOptions.vue'), this.checkedCode = '', this.checkedName = '', void this.$emit('update-checked-info', '', '');
                    }
                    this.checkedCode = e.code;
                    this.checkedName = e.name;
                    this.$emit('update-checked-info', e.code, e.name);
                }
            }
        }, Co = go, bo = (s('0e0e'), Object(Ae.a)(Co, fo, vo, false, null, '49d099ad', null)), So = bo.exports, wo = s('bcaf'), yo = s('1a37'), Po = s('3631'), Ao = {
            props: {
                options: {
                    type: Object,
                    default: null
                },
                rtcConfig: {
                    type: Object,
                    default: null
                },
                downlinkNetworkQuality: {
                    type: Number,
                    default: null
                }
            },
            components: { FeedbackOptions: So },
            data: function () {
                return {
                    showStatus: false,
                    agreeChecked: true,
                    content: '',
                    checkedCode: '',
                    checkedName: ''
                };
            },
            mounted: function () {
                this.options;
                this.rtcConfig;
            },
            methods: {
                handleShow: function () {
                    console.info('对象函数 handleShow,filePath:renderer/components/Classroom/LargeClass/base/room/header/feedback/index.vue');
                    this.showStatus = true;
                },
                handleHide: function () {
                    console.info('对象函数 handleHide,filePath:renderer/components/Classroom/LargeClass/base/room/header/feedback/index.vue');
                    this.showStatus = false;
                },
                handleClickAgree: function () {
                    console.info('对象函数 handleClickAgree,filePath:renderer/components/Classroom/LargeClass/base/room/header/feedback/index.vue');
                    this.agreeChecked = !this.agreeChecked;
                },
                handleSend: function () {
                    var e = this;
                    console.info('对象函数 handleSend,filePath:renderer/components/Classroom/LargeClass/base/room/header/feedback/index.vue');
                    this.handleHide();
                    this.$Message.info(this.$t('classroom.modules.feedback.sendSuccessNotice'));
                    this.agreeChecked ? this.uploadScreenshot(function (t) {
                        console.info('箭头函数 uploadScreenshot(screenshotUrl)', t, 'filePath:renderer/components/Classroom/LargeClass/base/room/header/feedback/index.vue');
                        e.sendMessage(t);
                    }) : this.sendMessage();
                    this.sendLogger('点击Send按钮: '.concat(JSON.stringify({
                        checkedName: this.checkedName,
                        content: this.content.replace(/[\r\n]/g, ' '),
                        agreeChecked: this.agreeChecked
                    })));
                    Object(x.e)('hw_classroom_toolbar_problem', this.options, { problem_type: this.checkedName });
                },
                sendMessage: function (e) {
                    var t = this;
                    return Object(A.a)(Object(P.a)().mark(function s() {
                        var o, a, n, r, i, c;
                        return Object(P.a)().wrap(function (s) {
                            while (1) {
                                switch (s.prev = s.next) {
                                    case 0:
                                        return console.info('对象函数 sendMessage(screenshotUrl)', e, 'filePath:renderer/components/Classroom/LargeClass/base/room/header/feedback/index.vue'), s.next = 3, Object(Y.f)();
                                    case 3:
                                        return a = s.sent, s.next = 6, te.nativeApi.getDeviceInfo();
                                    case 6:
                                        if (n = s.sent, r = t.content.replace(/[\r\n]/g, ' '), i = JSON.stringify({
                                            type: 150,
                                            from: 'flv',
                                            name: t.options.nickName,
                                            msg: 'I send a feedback',
                                            parameter: {
                                                schoolCode: a,
                                                planId: t.options.planId,
                                                roomId: t.options.classId,
                                                studentId: t.options.stuIRCId,
                                                uid: t.options.stuId,
                                                teacherId: t.options.teacherInfo.id,
                                                teacherName: t.options.teacherInfo.name,
                                                teacherRoomId: null === (o = t.rtcConfig) || void 0 === o ? void 0 : o.teacherRoomId,
                                                startTime: t.options.stime,
                                                currenTime: new Date().getTime(),
                                                device: n.platform,
                                                deviceVersion: n.osVersion,
                                                AppVersion: n.appVersion,
                                                question: t.checkedName,
                                                question_msg: r,
                                                question_url: e || ''
                                            }
                                        }), c = window.ChatClient.PeerChatManager.sendPeerMessage([{ nickname: t.options.configs.tutorIrcId }], i, wo.a.privMsg), t.resetData(), 0 == c) {
                                            s.next = 16;
                                            break;
                                        }
                                        return console.info('if(res != 0)为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/header/feedback/index.vue'), t.sendLogger('发送反馈消息失败: '.concat(i, ' irc消息发送返回状态: ').concat(c), 'error'), s.abrupt('return');
                                    case 16:
                                        t.sendLogger('发送反馈消息成功: '.concat(i));
                                    case 17:
                                    case 'end':
                                        return s.stop();
                                }
                            }
                        }, s);
                    }))();
                },
                uploadScreenshot: function (e) {
                    var t = this;
                    return Object(A.a)(Object(P.a)().mark(function s() {
                        var o, a, n, r;
                        return Object(P.a)().wrap(function (s) {
                            while (1) {
                                switch (s.prev = s.next) {
                                    case 0:
                                        return console.info('对象函数 uploadScreenshot(callback)', e, 'filePath:renderer/components/Classroom/LargeClass/base/room/header/feedback/index.vue'), s.prev = 1, s.next = 4, Object(Po.default)({
                                            thumbnailWidth: 1024,
                                            thumbnailQuality: 1
                                        });
                                    case 4:
                                        o = s.sent, a = o.thumbnail, n = Object(X.d)(a), r = new yo.b({ scene: 'classFeedback' }), r.putFile({
                                            filePath: 'classFeedback.jpg',
                                            file: n,
                                            progress: function (e) {
                                            },
                                            success: function (s) {
                                                e && e(s.url);
                                                t.sendLogger('截屏上传成功:'.concat(s.url));
                                            },
                                            fail: function () {
                                                e && e();
                                                t.sendLogger('截屏上传失败', 'error');
                                            }
                                        }), s.next = 15;
                                        break;
                                    case 11:
                                        s.prev = 11, s.t0 = s.catch(1), console.error('截屏上传报错', s.t0), e && e();
                                    case 15:
                                    case 'end':
                                        return s.stop();
                                }
                            }
                        }, s, null, [[
                            1,
                            11
                        ]]);
                    }))();
                },
                updateCheckedInfo: function (e, t) {
                    console.info('对象函数 updateCheckedInfo(code, name)', e, t, 'filePath:renderer/components/Classroom/LargeClass/base/room/header/feedback/index.vue');
                    this.checkedCode = e;
                    this.checkedName = t;
                },
                resetData: function () {
                    console.info('对象函数 resetData,filePath:renderer/components/Classroom/LargeClass/base/room/header/feedback/index.vue');
                    this.content = '';
                    this.checkedCode = '';
                    this.checkedName = '';
                },
                sendLogger: function (e) {
                    var t = arguments.length > 1 && void 0 !== arguments[1] ? arguments[1] : 'info';
                    L.a.send({
                        tag: 'liveFeedback',
                        content: {
                            msg: e,
                            level: t
                        }
                    });
                }
            }
        }, ko = Ao, Lo = (s('006b'), Object(Ae.a)(ko, ho, po, false, null, '0d4f9390', null)), Io = Lo.exports, xo = function () {
            var e = this, t = e._self._c;
            return t('div', { staticClass: 'team-switch' }, [t('div', { staticClass: 'switch-wrapper' }, [
                t('div', { staticClass: 'title' }, [e._v(' ' + e._s(e.$t('classroom.largeClass.header.groupVideoButtonName')) + ' ')]),
                t('div', { staticClass: 'switch' }, [t('a-switch', {
                    attrs: { disabled: e.disabledStatus },
                    on: { change: e.handleSwitchButton },
                    model: {
                        value: e.status,
                        callback: function (t) {
                            e.status = t;
                        },
                        expression: 'status'
                    }
                })], 1)
            ])]);
        }, Oo = [], jo = {
            props: {
                planId: {
                    type: Number,
                    default: 0
                },
                options: {
                    type: Object,
                    default: function () {
                        return {};
                    }
                }
            },
            data: function () {
                return {
                    status: false,
                    disabledStatus: false
                };
            },
            mounted: function () {
                var e = this;
                this.getSwitchStatus();
                this.$bus.$on('teamSwitchDisabled', function (t) {
                    console.info('箭头函数 监听 teamSwitchDisabled(disabledStatus)', t, 'filePath:renderer/components/Classroom/LargeClass/base/room/header/TeamSwitch.vue');
                    e.disabledStatus = t;
                });
            },
            methods: {
                handleSwitchButton: function () {
                    console.info('对象函数 handleSwitchButton,filePath:renderer/components/Classroom/LargeClass/base/room/header/TeamSwitch.vue');
                    L.a.send({
                        tag: 'action',
                        content: {
                            msg: '点击切换videoGroup显示状态',
                            disabledStatus: this.disabledStatus,
                            status: this.status
                        }
                    });
                    this.disabledStatus ? console.info('if(this.disabledStatus)为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/header/TeamSwitch.vue') : (Rs.e(this.status), this.status, this.updateSwitchStatus());
                },
                getSwitchStatus: function () {
                    var e = this;
                    return Object(A.a)(Object(P.a)().mark(function t() {
                        var s;
                        return Object(P.a)().wrap(function (t) {
                            while (1) {
                                switch (t.prev = t.next) {
                                    case 0:
                                        return console.info('对象函数 getSwitchStatus,filePath:renderer/components/Classroom/LargeClass/base/room/header/TeamSwitch.vue'), t.next = 3, window.thinkApi.ipc.invoke('getStoreValue', 'videoGroupSwitchStatus_'.concat(e.planId));
                                    case 3:
                                        s = t.sent, e.status = void 0 === s || s;
                                    case 5:
                                    case 'end':
                                        return t.stop();
                                }
                            }
                        }, t);
                    }))();
                },
                updateSwitchStatus: function () {
                    var e = this;
                    return Object(A.a)(Object(P.a)().mark(function t() {
                        return Object(P.a)().wrap(function (t) {
                            while (1) {
                                switch (t.prev = t.next) {
                                    case 0:
                                        return console.info('对象函数 updateSwitchStatus,filePath:renderer/components/Classroom/LargeClass/base/room/header/TeamSwitch.vue'), t.next = 3, window.thinkApi.ipc.invoke('setStoreValue', 'videoGroupSwitchStatus_'.concat(e.planId), e.status);
                                    case 3:
                                        e.$bus.$emit('updateTeamSwitchStatus', e.status), Object(x.e)('hw_classroom_toolbar_video', e.options, { switch_type: e.status ? 1 : 0 });
                                    case 5:
                                    case 'end':
                                        return t.stop();
                                }
                            }
                        }, t);
                    }))();
                }
            }
        }, To = jo, Mo = (s('a027'), Object(Ae.a)(To, xo, Oo, false, null, 'c8fa3f0e', null)), Ro = Mo.exports, Eo = function () {
            var e = this, t = e._self._c;
            return t('div', { staticClass: 'device-test' }, [t('div', {
                staticClass: 'device-test-wrapper',
                on: { click: e.handleClick }
            }, [t('div', { staticClass: 'title' }, [e._v(' ' + e._s(e.$t('classroom.largeClass.header.deviceTestButtonName')) + ' ')])])]);
        }, Vo = [], No = {
            methods: {
                handleClick: function () {
                    console.info('对象函数 handleClick,filePath:renderer/components/Classroom/LargeClass/base/room/header/DeviceTest.vue');
                    this.$bus.$emit('room.deviceTestShow');
                }
            }
        }, Do = No, Bo = (s('dd90'), Object(Ae.a)(Do, Eo, Vo, false, null, '55062aa6', null)), Uo = Bo.exports, Go = s('6cd4'), Ho = s('234d'), _o = function () {
            var e = this, t = e._self._c;
            return t('div', {
                staticClass: 'print-screen-container',
                on: { click: e.handleClick }
            });
        }, Fo = [], Wo = false, Ko = {
            methods: {
                handleClick: function () {
                    var e = this;
                    return Object(A.a)(Object(P.a)().mark(function t() {
                        var s;
                        return Object(P.a)().wrap(function (t) {
                            while (1) {
                                switch (t.prev = t.next) {
                                    case 0:
                                        if (console.info('对象函数 handleClick,filePath:renderer/components/Classroom/LargeClass/base/room/header/print-screen/printScreen.vue'), e.$emit('click'), !Wo) {
                                            t.next = 5;
                                            break;
                                        }
                                        return console.info('if(loading)为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/header/print-screen/printScreen.vue'), t.abrupt('return');
                                    case 5:
                                        return Wo = true, t.next = 8, Object(Po.default)();
                                    case 8:
                                        if (s = t.sent, Wo = false, s.thumbnail) {
                                            t.next = 13;
                                            break;
                                        }
                                        return console.info('if(!res.thumbnail)为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/header/print-screen/printScreen.vue'), t.abrupt('return');
                                    case 13:
                                        e.$bus.$emit('screenThumbnail', s.thumbnail);
                                    case 14:
                                    case 'end':
                                        return t.stop();
                                }
                            }
                        }, t);
                    }))();
                }
            }
        }, qo = Ko, zo = (s('0781'), Object(Ae.a)(qo, _o, Fo, false, null, '4ab02bdd', null)), Jo = zo.exports, Qo = s('36e6'), Zo = s('c6c8'), Yo = s('cf14'), Xo = {
            props: {
                options: {
                    type: Object,
                    default: null
                },
                stuInfo: {
                    type: Object,
                    default: null
                },
                rtcConfig: {
                    type: Object,
                    default: null
                },
                planInfo: {
                    type: Object,
                    default: null
                },
                planName: {
                    type: String,
                    default: ''
                }
            },
            components: {
                Toolbar: no.a,
                Feedback: Io,
                AssignmentBox: Go.a,
                NetworkStatus: mo,
                TeamSwitch: Ro,
                DeviceTest: Uo,
                PrintScreen: Jo,
                ExamReport: Zo.a
            },
            data: function () {
                return {
                    isPlayBack: this.options.isPlayBack,
                    showHeader: true,
                    showMore: false,
                    local: '',
                    haveNewMessage: false,
                    downlinkNetworkQuality: -1,
                    checkRefreshBox: true,
                    backUrl: '',
                    reportBtnVisible: false,
                    checkNetHealthIntervalId: null,
                    lessonType: ''
                };
            },
            computed: {
                triggerClass: function () {
                    return console.info('对象函数 triggerClass,filePath:renderer/components/Classroom/LargeClass/base/room/header/header.vue'), this.showHeader ? 'show' : 'hide';
                },
                showTeamSwitch: function () {
                    return console.info('对象函数 showTeamSwitch,filePath:renderer/components/Classroom/LargeClass/base/room/header/header.vue'), !this.options.isAudition;
                },
                showHomeworkButton: function () {
                    return console.info('对象函数 showHomeworkButton,filePath:renderer/components/Classroom/LargeClass/base/room/header/header.vue'), 'uk' != this.local && !this.options.isAudition;
                },
                showFeedbackButton: function () {
                    return console.info('对象函数 showFeedbackButton,filePath:renderer/components/Classroom/LargeClass/base/room/header/header.vue'), !this.options.isAudition;
                },
                showExamReportButton: function () {
                    return console.info('对象函数 showExamReportButton,filePath:renderer/components/Classroom/LargeClass/base/room/header/header.vue'), !this.options.isAudition && this.reportBtnVisible;
                }
            },
            mounted: function () {
                var e = this;
                return Object(A.a)(Object(P.a)().mark(function t() {
                    var s;
                    return Object(P.a)().wrap(function (t) {
                        while (1) {
                            switch (t.prev = t.next) {
                                case 0:
                                    return t.next = 2, Object(Y.c)();
                                case 2:
                                    return e.local = t.sent, e.handleHideLiveHeader(), e.queryReadMessage(), e.backUrl = window.location.href.split('backUrl=')[1] || '/courses', t.next = 8, e.initShowReportBtn();
                                case 8:
                                    e.checkNetHealthIntervalId = setInterval(function () {
                                        Object(Yo.a)();
                                    }, Yo.b), s = K.a.parse(window.location.search), e.lessonType = tt.g[s.lessonType] || '';
                                case 11:
                                case 'end':
                                    return t.stop();
                            }
                        }
                    }, t);
                }))();
            },
            beforeDestroy: function () {
                console.info('对象函数 beforeDestroy,filePath:renderer/components/Classroom/LargeClass/base/room/header/header.vue');
                this.checkNetHealthIntervalId && clearInterval(this.checkNetHealthIntervalId);
            },
            methods: {
                reSensorEvent: function (e) {
                    console.info('对象函数 reSensorEvent(toolName)', e, 'filePath:renderer/components/Classroom/LargeClass/base/room/header/header.vue');
                    Object(x.e)('hw_classroom_toolbar_click', this.options, { tool_name: e });
                },
                printScrenClick: function () {
                    console.info('对象函数 printScrenClick,filePath:renderer/components/Classroom/LargeClass/base/room/header/header.vue');
                    L.a.send({
                        tag: 'action',
                        content: { msg: '学生点击header截屏' }
                    });
                    this.reSensorEvent('截屏');
                },
                handleHideLiveHeader: function () {
                    var e = this;
                    console.info('对象函数 handleHideLiveHeader,filePath:renderer/components/Classroom/LargeClass/base/room/header/header.vue');
                    setTimeout(function () {
                        e.showHeader = false;
                    }, 5000);
                },
                handleBack: function () {
                    var e = this;
                    return Object(A.a)(Object(P.a)().mark(function t() {
                        return Object(P.a)().wrap(function (t) {
                            while (1) {
                                switch (t.prev = t.next) {
                                    case 0:
                                        if (console.info('对象函数 handleBack,filePath:renderer/components/Classroom/LargeClass/base/room/header/header.vue'), localStorage.setItem('largeClassTestCoverage', JSON.stringify(window.__coverage__)), !e.options.isPlayBack) {
                                            t.next = 5;
                                            break;
                                        }
                                        return console.info('if(_this3.options.isPlayBack)为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/header/header.vue'), t.abrupt('return', window.location.href = '/#' + e.backUrl);
                                    case 5:
                                        e.$Modal.confirm({
                                            class: 'modal-simple apu-header',
                                            content: e.$t('classroom.modules.header.backConfirm.content'),
                                            okText: e.$t('common.yes'),
                                            cancelText: e.$t('common.no'),
                                            zIndex: 3000,
                                            onOk: function () {
                                                if (!e.options.isPlayBack) {
                                                    var t;
                                                    e.$bus.$emit('liveQuit');
                                                    var s = e.planInfo, o = s.startStampTime, a = void 0 === o ? '' : o, n = s.endStampTime, r = void 0 === n ? '' : n, i = s.id, c = void 0 === i ? '' : i;
                                                    Object(X.A)(a, r) && e.$sensors.track('click_exit_btn', {
                                                        isStartClass: true,
                                                        isKickout: false,
                                                        planId: +c,
                                                        course_type: e.lessonType
                                                    });
                                                    Rs.d(null === (t = e.options) || void 0 === t ? void 0 : t.timeOffset, r);
                                                    Object(ne.setPlanId)({});
                                                }
                                                L.a.send({
                                                    tag: 'action',
                                                    content: { msg: '学生退出课堂' }
                                                });
                                                setTimeout(function () {
                                                    window.location.href = '/#' + e.backUrl;
                                                }, 1000);
                                            }
                                        });
                                    case 6:
                                    case 'end':
                                        return t.stop();
                                }
                            }
                        }, t);
                    }))();
                },
                handleFeedbackShow: function () {
                    console.info('对象函数 handleFeedbackShow,filePath:renderer/components/Classroom/LargeClass/base/room/header/header.vue');
                    this.$refs.Feedback.handleShow();
                    this.reSensorEvent('反馈');
                    this.$refs.assignmentBoxRef.hideAssignmentBoxOnly();
                },
                handleRefresh: function () {
                    console.info('对象函数 handleRefresh,filePath:renderer/components/Classroom/LargeClass/base/room/header/header.vue');
                    L.a.send({
                        tag: 'action',
                        content: { msg: '点击header刷新' }
                    });
                    this.reSensorEvent('刷新');
                    this.$bus.$emit('liveRefresh');
                    var e = this.planInfo, t = e.startStampTime, s = void 0 === t ? '' : t, o = e.endStampTime, a = void 0 === o ? '' : o;
                    Object(X.A)(s, a) && this.$sensors.track('refresh_livePage', { course_type: this.lessonType });
                },
                handleExamResult: function () {
                    console.info('对象函数 handleExamResult,filePath:renderer/components/Classroom/LargeClass/base/room/header/header.vue');
                    this.$bus.$emit('handleOpenExamReport', true);
                },
                handleMore: function () {
                    console.info('对象函数 handleMore,filePath:renderer/components/Classroom/LargeClass/base/room/header/header.vue');
                    L.a.send({
                        tag: 'action',
                        content: { msg: '点击更多按钮' }
                    });
                    this.reSensorEvent('小组视频');
                    this.showMore = !this.showMore;
                },
                queryReadMessage: function () {
                    var e = this;
                    return Object(A.a)(Object(P.a)().mark(function t() {
                        var s;
                        return Object(P.a)().wrap(function (t) {
                            while (1) {
                                switch (t.prev = t.next) {
                                    case 0:
                                        return console.info('对象函数 queryReadMessage,filePath:renderer/components/Classroom/LargeClass/base/room/header/header.vue'), t.next = 3, Object(Ho.b)(e, { planId: e.planInfo.id });
                                    case 3:
                                        s = t.sent, 1 == (null === s || void 0 === s ? void 0 : s.stat) && (e.haveNewMessage = s.data.haveNewMessage);
                                    case 5:
                                    case 'end':
                                        return t.stop();
                                }
                            }
                        }, t);
                    }))();
                },
                handleShowMessageTip: function () {
                    console.info('对象函数 handleShowMessageTip,filePath:renderer/components/Classroom/LargeClass/base/room/header/header.vue');
                    L.a.send({
                        tag: 'action',
                        content: { msg: '新的作业盒子消息' }
                    });
                    this.haveNewMessage = true;
                },
                handleHideMessageTip: function () {
                    console.info('对象函数 handleHideMessageTip,filePath:renderer/components/Classroom/LargeClass/base/room/header/header.vue');
                    L.a.send({
                        tag: 'action',
                        content: { msg: '取消作业盒子消息提醒' }
                    });
                    this.haveNewMessage = false;
                },
                handleOpenAssignmentBox: function () {
                    var e = this;
                    console.info('对象函数 handleOpenAssignmentBox,filePath:renderer/components/Classroom/LargeClass/base/room/header/header.vue');
                    L.a.send({
                        tag: 'action',
                        content: { msg: '打开作业盒子' }
                    });
                    this.reSensorEvent('作业盒子');
                    this.$nextTick(function () {
                        e.$refs.assignmentBoxRef.handleOpenAssignmentBox();
                    });
                    this.$refs.Feedback.handleHide();
                },
                handleMouseenter: function () {
                    console.info('对象函数 handleMouseenter,filePath:renderer/components/Classroom/LargeClass/base/room/header/header.vue');
                    L.a.send({
                        tag: 'action',
                        content: { msg: '显示头部导航栏' }
                    });
                    this.showHeader = true;
                    this.showMore = false;
                },
                hideHeader: function () {
                    console.info('对象函数 hideHeader,filePath:renderer/components/Classroom/LargeClass/base/room/header/header.vue');
                    this.showHeader = false;
                },
                handleMouseleave: function () {
                    console.info('对象函数 handleMouseleave,filePath:renderer/components/Classroom/LargeClass/base/room/header/header.vue');
                    L.a.send({
                        tag: 'action',
                        content: { msg: '移出头部导航栏' }
                    });
                    this.$refs.assignmentBoxRef.showAssignmentBox || (this.showHeader = false);
                },
                updateNetworkQuality: function (e) {
                    console.info('对象函数 updateNetworkQuality(downlinkNetworkQuality)', e, 'filePath:renderer/components/Classroom/LargeClass/base/room/header/header.vue');
                    this.downlinkNetworkQuality = e;
                },
                initShowReportBtn: function () {
                    var e = this;
                    return Object(A.a)(Object(P.a)().mark(function t() {
                        var s, o;
                        return Object(P.a)().wrap(function (t) {
                            while (1) {
                                switch (t.prev = t.next) {
                                    case 0:
                                        return console.info('对象函数 initShowReportBtn,filePath:renderer/components/Classroom/LargeClass/base/room/header/header.vue'), t.next = 3, Object(Qo.a)({
                                            planId: e.planInfo.id,
                                            platform: '3'
                                        });
                                    case 3:
                                        if (o = t.sent, o && 0 == o.code) {
                                            t.next = 7;
                                            break;
                                        }
                                        return console.info('if(!res || res.code != 0)为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/header/header.vue'), t.abrupt('return');
                                    case 7:
                                        e.reportBtnVisible = '1' === (null === o || void 0 === o || null === (s = o.data) || void 0 === s ? void 0 : s.showReportEnter);
                                    case 8:
                                    case 'end':
                                        return t.stop();
                                }
                            }
                        }, t);
                    }))();
                }
            }
        }, $o = Xo, ea = (s('9654'), Object(Ae.a)($o, oo, ao, false, null, '6543ab99', null)), ta = ea.exports, sa = function () {
            var e = this, t = e._self._c;
            return t('div', [
                0 === e.classType ? t('LargeClass', {
                    attrs: {
                        options: e.options,
                        stuInfo: e.stuInfo,
                        rtcConfig: e.rtcConfig
                    }
                }) : e._e(),
                1 === e.classType || 2 === e.classType ? t('SmallClass', {
                    attrs: {
                        options: e.options,
                        stuInfo: e.stuInfo,
                        rtcConfig: e.rtcConfig,
                        classType: e.classType
                    }
                }) : e._e()
            ], 1);
        }, oa = [], aa = function () {
            var e = this, t = e._self._c;
            return t('div', [
                t('Achievement', {
                    attrs: {
                        showAchievement: e.showAchievement,
                        options: e.options,
                        type: 'normal'
                    }
                }),
                t('div', {
                    directives: [{
                        name: 'show',
                        rawName: 'v-show',
                        value: true === e.teamSwitchStatus,
                        expression: 'teamSwitchStatus === true'
                    }],
                    staticClass: 'video-group-wrapper class-type-large'
                }, [t('div', { staticClass: 'video-group-contenter' }, [
                    e.options.isParent ? [e.myChildInfo.onlineStatus ? t('RemoteVideo', {
                        key: e.myChildInfo.uid,
                        attrs: {
                            remoteStuInfo: e.myChildInfo,
                            showAudioWaves: e.showAudioWaves,
                            hideRemoteVideo: e.hideRemoteVideo
                        },
                        on: { handleRemoteVideoStatus: e.handleRemoteVideoStatus }
                    }) : t('OffLineVideo', { attrs: { name: e.myChildInfo.stuName } })] : !e.options.isParent && e.options.isAudition ? [t('VideoItemPad', { attrs: { notice: e.$t('classroom.largeClass.videoGroup.localVideoAudition.notice') } })] : [t('LocalVideo', {
                        attrs: {
                            options: e.options,
                            localStuInfo: e.localStuInfo,
                            hideVideoIcon: e.hideLocalVideoIcon
                        },
                        on: { handleLocalVideoStatus: e.handleLocalVideoStatus }
                    })],
                    e._l(e.remoteStuInfo, function (s, o) {
                        return [t('RemoteVideo', {
                            key: o,
                            attrs: {
                                remoteStuInfo: s,
                                showAudioWaves: e.showAudioWaves,
                                hideRemoteVideo: e.hideRemoteVideo,
                                isExaminationStatus: e.isExaminationStatus
                            },
                            on: { handleRemoteVideoStatus: e.handleRemoteVideoStatus }
                        })];
                    }),
                    e.remoteStuPadNum > 0 ? e._l(e.remoteStuPadNum, function (s) {
                        return t('VideoItemPad', {
                            key: s,
                            attrs: { notice: e.canShowOtherChild ? e.$t('classroom.largeClass.videoGroup.textConfig.matching') : '' }
                        });
                    }) : e._e()
                ], 2)])
            ], 1);
        }, na = [], ra = function () {
            var e = this, t = e._self._c;
            return e.showAchievement ? t('div', { class: [e.achievementClassName] }, [
                'normal' === e.type ? t('div', { staticClass: 'achievement-container' }, [
                    t('div', { staticClass: 'coins-wrapper' }, [
                        t('div', {
                            class: [
                                'coins-icon',
                                { 'add-coin': e.addCoin }
                            ]
                        }),
                        t('span', { staticClass: 'coins-title' }, [e._v(' ' + e._s(e.$t('classroom.largeClass.coins.title')) + ' ')])
                    ]),
                    e.addCoin ? t('CountTo', {
                        staticClass: 'coins-num',
                        attrs: {
                            startVal: e.startCoin,
                            endVal: e.endCoin,
                            duration: 400,
                            separator: ''
                        },
                        on: {
                            end: function (t) {
                                e.addCoin = false;
                            }
                        }
                    }) : t('div', { staticClass: 'coins-num' }, [e._v(e._s(e.gold))])
                ], 1) : e._e(),
                'simple' === e.type ? t('div', { staticClass: 'achievement-container' }, [
                    t('div', {
                        class: [
                            'coins-icon-simple',
                            { 'add-coin': e.addCoin }
                        ]
                    }),
                    e.addCoin ? t('CountTo', {
                        staticClass: 'count',
                        attrs: {
                            startVal: e.startCoin,
                            endVal: e.endCoin,
                            duration: 400,
                            separator: ''
                        },
                        on: {
                            end: function (t) {
                                e.addCoin = false;
                            }
                        }
                    }) : t('span', { staticClass: 'count' }, [e._v(e._s(e.gold))])
                ], 1) : e._e()
            ]) : e._e();
        }, ia = [], ca = s('306f'), la = {
            components: { CountTo: ca.a },
            props: {
                options: {
                    type: Object,
                    default: null
                },
                type: {
                    type: String,
                    default: 'simple'
                },
                showAchievement: {
                    type: Boolean,
                    default: true
                }
            },
            data: function () {
                return {
                    gold: this.options.goldNum,
                    addCoin: false,
                    startCoin: 0,
                    endCoin: 0
                };
            },
            computed: {
                achievementClassName: function () {
                    return console.info('对象函数 achievementClassName,filePath:renderer/components/Classroom/LargeClass/base/room/achievement/index.vue'), 'normal' === this.type ? (console.info('if(this.type === \'normal\')为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/achievement/index.vue'), 'achievement-wrapper-normal') : 'simple' === this.type ? (console.info('if(this.type === \'simple\')为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/achievement/index.vue'), 'achievement-wrapper-simple') : void 0;
                }
            },
            mounted: function () {
                var e = this;
                this.$bus.$on('updateAchievement', function (t, s) {
                    console.info('箭头函数 监听 updateAchievement(type, num)', t, s, 'filePath:renderer/components/Classroom/LargeClass/base/room/achievement/index.vue');
                    e[t](s);
                });
                this.$bus.$on('addCoin', function (t, s) {
                    console.info('箭头函数 监听 addCoin(isStart, coin)', t, s, 'filePath:renderer/components/Classroom/LargeClass/base/room/achievement/index.vue');
                    t && (e.addCoin = true, e.startCoin = +e.gold, e.endCoin = e.startCoin + s, e.gold = e.endCoin);
                });
            },
            methods: {
                add: function (e) {
                    console.info('对象函数 add(num)', e, 'filePath:renderer/components/Classroom/LargeClass/base/room/achievement/index.vue');
                    this.gold = this.gold + parseInt(e);
                },
                update: function (e) {
                    var t = this;
                    return Object(A.a)(Object(P.a)().mark(function s() {
                        return Object(P.a)().wrap(function (s) {
                            while (1) {
                                switch (s.prev = s.next) {
                                    case 0:
                                        if (console.info('对象函数 update(num)', e, 'filePath:renderer/components/Classroom/LargeClass/base/room/achievement/index.vue'), e) {
                                            s.next = 5;
                                            break;
                                        }
                                        return s.next = 4, t.initMedalCoins();
                                    case 4:
                                        e = s.sent;
                                    case 5:
                                        t.gold = parseInt(e);
                                    case 6:
                                    case 'end':
                                        return s.stop();
                                }
                            }
                        }, s);
                    }))();
                },
                initMedalCoins: function () {
                    return Object(A.a)(Object(P.a)().mark(function e() {
                        var t, s, o;
                        return Object(P.a)().wrap(function (e) {
                            while (1) {
                                switch (e.prev = e.next) {
                                    case 0:
                                        return console.info('对象函数 initMedalCoins,filePath:renderer/components/Classroom/LargeClass/base/room/achievement/index.vue'), s = K.a.parse(window.location.search), e.next = 4, Object(Q.w)({ planId: s.planId });
                                    case 4:
                                        return o = e.sent, e.abrupt('return', (null === o || void 0 === o || null === (t = o.data) || void 0 === t ? void 0 : t.totalCoin) || '');
                                    case 6:
                                    case 'end':
                                        return e.stop();
                                }
                            }
                        }, e);
                    }))();
                }
            }
        }, ua = la, da = (s('0b48'), Object(Ae.a)(ua, ra, ia, false, null, '89ae54b8', null)), ma = da.exports, ha = function () {
            var e = this, t = e._self._c;
            return t('div', { staticClass: 'video-item video-local' }, [
                0 == this.options.classType ? t('Achievement', {
                    attrs: {
                        options: e.options,
                        type: 'simple'
                    }
                }) : e._e(),
                e.localStuInfo.cameraStatus ? [
                    t('div', { staticClass: 'group-wrapper' }, [
                        t('div', {
                            directives: [{
                                name: 'show',
                                rawName: 'v-show',
                                value: e.localStuInfo.displayVideo,
                                expression: 'localStuInfo.displayVideo'
                            }],
                            staticClass: 'video-wrapper',
                            attrs: { id: 'video-group-local' }
                        }),
                        e.localStuInfo.displayVideo ? e._e() : t('div', { staticClass: 'avatar-wrapper' }, [t('img', { attrs: { src: e.localStuInfo.avatar } })])
                    ]),
                    e.showMicrophoneIcon ? t('div', {
                        staticClass: 'microphone-status',
                        class: [{
                            'icon-microphone': e.localStuInfo.microphoneStatus,
                            'icon-microphone-disabled': !e.localStuInfo.microphoneStatus
                        }],
                        on: { click: e.handleLocalMicrophoneStatus }
                    }) : e._e(),
                    e.hideVideoIcon ? e._e() : t('div', {
                        staticClass: 'camera-status',
                        class: [{
                            'icon-camera': e.localStuInfo.displayVideo,
                            'icon-no-camera': !e.localStuInfo.displayVideo
                        }],
                        on: { click: e.handleLocalVideoStatus }
                    })
                ] : [
                    t('div', { staticClass: 'group-wrapper' }, [t('div', { staticClass: 'avatar-wrapper' }, [t('img', { attrs: { src: e.localStuInfo.avatar } })])]),
                    e.showMicrophoneIcon ? t('div', {
                        staticClass: 'microphone-status',
                        class: [{
                            'icon-microphone': e.localStuInfo.microphoneStatus,
                            'icon-microphone-disabled': !e.localStuInfo.microphoneStatus
                        }],
                        on: { click: e.handleLocalMicrophoneStatus }
                    }) : e._e(),
                    t('div', {
                        staticClass: 'camera-status icon-no-camera',
                        on: { click: e.showNoAccessNotice }
                    })
                ],
                e.localStuInfo.level ? t('div', { staticClass: 'medal-wrapper' }, [
                    t('span', {
                        staticClass: 'icon',
                        class: e.localStuInfo.level ? 'level-'.concat(e.localStuInfo.level) : ''
                    }),
                    t('span', {
                        staticClass: 'text',
                        class: e.smallLevelText
                    }, [e._v('Lv' + e._s(e.localStuInfo.level))])
                ]) : e._e(),
                t('div', { staticClass: 'student-name' }, [e._v(e._s(e.localStuInfo.stuName))]),
                t('MediaSecurityAccess', {
                    ref: 'MediaSecurityAccessCamera',
                    attrs: {
                        visible: false,
                        type: 'camera'
                    }
                }),
                t('MediaSecurityAccess', {
                    ref: 'MediaSecurityAccessMicrophone',
                    attrs: {
                        visible: false,
                        type: 'microphone'
                    }
                })
            ], 2);
        }, pa = [], fa = {
            components: {
                Achievement: ma,
                MediaSecurityAccess: Ct.a
            },
            props: {
                options: {
                    type: Object,
                    default: null
                },
                localStuInfo: {
                    type: Object,
                    default: null
                },
                hideVideoIcon: {
                    type: Boolean,
                    default: false
                },
                classType: {
                    type: Number,
                    default: -1
                }
            },
            computed: {
                showMicrophoneIcon: function () {
                    return console.info('对象函数 showMicrophoneIcon,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/localVideo.vue'), !this.hideVideoIcon && 2 == this.classType;
                },
                smallLevelText: function () {
                    return console.info('对象函数 smallLevelText,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/localVideo.vue'), 'level-'.concat(this.localStuInfo.level);
                }
            },
            data: function () {
                return {};
            },
            methods: {
                handleLocalVideoStatus: ve()(function () {
                    this.$emit('handleLocalVideoStatus');
                    Object(x.e)('hw_classroom_my_camera', this.options, { switch_type: this.localStuInfo.displayVideo ? 1 : 0 });
                }, 300),
                handleLocalMicrophoneStatus: function () {
                    var e = this;
                    return Object(A.a)(Object(P.a)().mark(function t() {
                        var s;
                        return Object(P.a)().wrap(function (t) {
                            while (1) {
                                switch (t.prev = t.next) {
                                    case 0:
                                        return console.info('对象函数 handleLocalMicrophoneStatus,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/localVideo.vue'), t.next = 3, Object($.f)();
                                    case 3:
                                        if (s = t.sent, s) {
                                            t.next = 9;
                                            break;
                                        }
                                        return console.info('if(!microphoneStatus)为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/videoGroup/localVideo.vue'), e.$refs.MediaSecurityAccessMicrophone.checkAccess(), t.abrupt('return');
                                    case 9:
                                        e.$emit('handleLocalMicrophoneStatus');
                                    case 10:
                                    case 'end':
                                        return t.stop();
                                }
                            }
                        }, t);
                    }))();
                },
                showNoAccessNotice: function () {
                    console.info('对象函数 showNoAccessNotice,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/localVideo.vue');
                    this.$refs.MediaSecurityAccessCamera.checkAccess();
                }
            }
        }, va = fa, ga = (s('9234'), Object(Ae.a)(va, ha, pa, false, null, '1659edb8', null)), Ca = ga.exports, ba = function () {
            var e = this, t = e._self._c;
            return t('div', {
                directives: [{
                    name: 'show',
                    rawName: 'v-show',
                    value: e.remoteStuInfo.showStatus,
                    expression: 'remoteStuInfo.showStatus'
                }],
                staticClass: 'video-item video-remote'
            }, [
                t('div', {
                    directives: [{
                        name: 'show',
                        rawName: 'v-show',
                        value: e.remoteStuInfo.cameraStatus,
                        expression: 'remoteStuInfo.cameraStatus'
                    }],
                    staticClass: 'item-wrapper'
                }, [
                    e.showAudioWaves ? t('div', { staticClass: 'audio-waves-wrapper' }, [t('AudioWaves', {
                        attrs: {
                            animation: true,
                            size: 'small',
                            skin: 'white',
                            'animation-type': 'sound'
                        }
                    })], 1) : e._e(),
                    t('div', { staticClass: 'group-wrapper' }, [
                        t('div', {
                            directives: [{
                                name: 'show',
                                rawName: 'v-show',
                                value: e.showRemoteVideo,
                                expression: 'showRemoteVideo'
                            }],
                            staticClass: 'video-wrapper',
                            attrs: { id: 'remote-' + e.remoteStuInfo.stuId }
                        }),
                        e.showRemoteAvatar ? t('div', { staticClass: 'avatar-wrapper' }, [t('img', { attrs: { src: e.remoteStuInfo.avatar } })]) : e._e()
                    ]),
                    e.showCameraStatusIcon ? t('div', {
                        staticClass: 'camera-status',
                        class: [{
                            'icon-visible': e.remoteStuInfo.displayVideo,
                            'icon-invisible': !e.remoteStuInfo.displayVideo
                        }],
                        on: { click: e.handleRemoteVideoStatus }
                    }) : e._e()
                ]),
                e.remoteStuInfo.cameraStatus ? e._e() : [t('div', { staticClass: 'group-wrapper' }, [t('div', { staticClass: 'avatar-wrapper' }, [t('img', { attrs: { src: e.remoteStuInfo.avatar } })])])],
                t('div', { staticClass: 'student-name' }, [e._v(e._s(e.remoteStuInfo.stuName))]),
                !e.showAudioWaves && e.remoteStuInfo.level ? t('div', { staticClass: 'medal-wrapper' }, [
                    t('span', {
                        staticClass: 'icon',
                        class: e.remoteStuInfo.level ? 'level-'.concat(e.remoteStuInfo.level) : ''
                    }),
                    t('span', {
                        staticClass: 'text',
                        class: e.smallLevelText
                    }, [e._v('Lv' + e._s(e.remoteStuInfo.level))])
                ]) : e._e()
            ], 2);
        }, Sa = [], wa = s('217d'), ya = {
            components: { AudioWaves: wa.a },
            props: {
                remoteStuInfo: {
                    type: Object,
                    default: null
                },
                showAudioWaves: {
                    type: Boolean,
                    default: null
                },
                hideRemoteVideo: {
                    type: Boolean,
                    default: null
                },
                hideVideoIcon: {
                    type: Boolean,
                    default: false
                },
                isExaminationStatus: {
                    type: Boolean,
                    default: false
                }
            },
            computed: {
                showRemoteVideo: function () {
                    return console.info('对象函数 showRemoteVideo,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/remoteVideo.vue'), this.remoteStuInfo.onlineStatus && this.remoteStuInfo.displayVideo && !this.remoteStuInfo.mutedVideoStatus && !this.hideRemoteVideo && !this.isExaminationStatus;
                },
                showRemoteAvatar: function () {
                    return console.info('对象函数 showRemoteAvatar,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/remoteVideo.vue'), !this.remoteStuInfo.onlineStatus || !this.remoteStuInfo.displayVideo || this.remoteStuInfo.mutedVideoStatus || this.hideRemoteVideo || this.isExaminationStatus;
                },
                showCameraStatusIcon: function () {
                    return console.info('对象函数 showCameraStatusIcon,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/remoteVideo.vue'), this.remoteStuInfo.onlineStatus && !this.remoteStuInfo.mutedVideoStatus && !this.hideVideoIcon;
                },
                smallLevelText: function () {
                    return console.info('对象函数 smallLevelText,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/remoteVideo.vue'), 'level-'.concat(this.remoteStuInfo.level);
                }
            },
            methods: {
                handleRemoteVideoStatus: function () {
                    console.info('对象函数 handleRemoteVideoStatus,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/remoteVideo.vue');
                    this.$emit('handleRemoteVideoStatus', this.remoteStuInfo.stuId, !this.remoteStuInfo.displayVideo);
                }
            }
        }, Pa = ya, Aa = (s('f502'), Object(Ae.a)(Pa, ba, Sa, false, null, '2831850a', null)), ka = Aa.exports, La = function () {
            var e = this, t = e._self._c;
            return t('div', { staticClass: 'video-item video-remote video-parent-audition' }, [
                t('div', { staticClass: 'notice' }, [e._v(' ' + e._s(e.$t('classroom.smallClass.videoGroup.localVideoAudition.offline')) + ' ')]),
                t('div', { staticClass: 'name' }, [e._v(e._s(e.name))])
            ]);
        }, Ia = [], xa = {
            props: {
                name: {
                    type: String,
                    default: ''
                }
            }
        }, Oa = xa, ja = (s('58cb'), Object(Ae.a)(Oa, La, Ia, false, null, '34d61130', null)), Ta = ja.exports, Ma = function () {
            function e() {
                var t = arguments.length > 0 && void 0 !== arguments[0] ? arguments[0] : {};
                console.info('函数申明 _default(opts)', t, 'filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/rtcClass.js');
                Object(g.a)(this, e);
                this.options = t.options;
                this.stuInfo = t.stuInfo;
                this.rtcConfig = t.rtcConfig;
                this.classType = t.classType;
                this.publishStatus = void 0 === t.publishStatus || t.publishStatus;
                this.rtcEngine = null;
                this.classRtcChannel = null;
            }
            return Object(C.a)(e, [
                {
                    key: 'init',
                    value: function () {
                        var e = Object(A.a)(Object(P.a)().mark(function e() {
                            var t, s;
                            return Object(P.a)().wrap(function (e) {
                                while (1) {
                                    switch (e.prev = e.next) {
                                        case 0:
                                            if (this.publishStatus) {
                                                e.next = 3;
                                                break;
                                            }
                                            return console.info('if(!this.publishStatus)为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/videoGroup/rtcClass.js'), e.abrupt('return', this.createClassRtcChannel());
                                        case 3:
                                            return e.next = 5, Object($.b)();
                                        case 5:
                                            return t = e.sent, e.next = 8, Object($.e)();
                                        case 8:
                                            if (s = e.sent, 'not-determined' !== t) {
                                                e.next = 25;
                                                break;
                                            }
                                            return console.info('if(cameraAccessStatus === \'not-determined\')为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/videoGroup/rtcClass.js'), e.next = 15, Object($.a)();
                                        case 15:
                                            if (e.sent, 'not-determined' !== s) {
                                                e.next = 22;
                                                break;
                                            }
                                            return e.next = 20, Object($.d)();
                                        case 20:
                                            e.sent;
                                        case 22:
                                            return e.abrupt('return', this.createClassRtcChannel());
                                        case 25:
                                            return console.info('if(cameraAccessStatus === \'not-determined\')为false,触发return,path: /renderer/components/Classroom/LargeClass/base/room/videoGroup/rtcClass.js'), e.abrupt('return', this.createClassRtcChannel());
                                        case 27:
                                        case 'end':
                                            return e.stop();
                                    }
                                }
                            }, e, this);
                        }));
                        function t() {
                            return console.info('函数申明 init, filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/rtcClass.js'), e.apply(this, arguments);
                        }
                        return t;
                    }()
                },
                {
                    key: 'createClassRtcChannel',
                    value: function () {
                        var e = Object(A.a)(Object(P.a)().mark(function e() {
                            var t, s, o;
                            return Object(P.a)().wrap(function (e) {
                                while (1) {
                                    switch (e.prev = e.next) {
                                        case 0:
                                            return t = 2 == this.classType ? this.rtcConfig.token : this.rtcConfig.classToken, s = String(t), this.rtcEngine = window.RTC_COMMON.rtcEngine, e.next = 5, Object(wt.b)(this.rtcEngine);
                                        case 5:
                                            return this.classRtcChannel = window.RTC_COMMON.classRtcChannel = this.rtcEngine.createChannel(s), o = this.publishStatus ? 1 : 2, this.classRtcChannel.setClientRole(o), this.classRtcChannel.setDefaultMuteAllRemoteAudioStreams(true), this.publishStatus && (this.classRtcChannel.muteLocalAudioStream(false), this.classRtcChannel.muteLocalVideoStream(false)), e.abrupt('return', this.classRtcChannel);
                                        case 11:
                                        case 'end':
                                            return e.stop();
                                    }
                                }
                            }, e, this);
                        }));
                        function t() {
                            return console.info('函数申明 createClassRtcChannel, filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/rtcClass.js'), e.apply(this, arguments);
                        }
                        return t;
                    }()
                },
                {
                    key: 'setupLocalVideo',
                    value: function (e) {
                        this.rtcEngine.setupLocalVideo(document.getElementById(e));
                    }
                },
                {
                    key: 'setupRemoteVideo',
                    value: function (e, t) {
                        this.classRtcChannel.setupRemoteVideo(e, document.getElementById(t));
                    }
                },
                {
                    key: 'muteLocalVideo',
                    value: function (e) {
                        this.classRtcChannel.muteLocalVideoStream(e);
                    }
                },
                {
                    key: 'muteLocalAudio',
                    value: function (e) {
                        this.classRtcChannel.muteLocalAudioStream(e);
                    }
                },
                {
                    key: 'muteRemoteVideo',
                    value: function (e, t) {
                        this.classRtcChannel.muteRemoteVideoStream(Number(e), t);
                    }
                },
                {
                    key: 'muteRemoteAudio',
                    value: function (e, t) {
                        this.classRtcChannel.muteRemoteAudioStream(Number(e), t);
                    }
                },
                {
                    key: 'publish',
                    value: function (e) {
                        var t = e.publishVideo, s = void 0 === t || t;
                        this.classRtcChannel.setClientRole(1);
                        this.classRtcChannel.muteLocalAudioStream(false);
                        s ? this.classRtcChannel.muteLocalVideoStream(false) : this.classRtcChannel.muteLocalVideoStream(true);
                    }
                },
                {
                    key: 'unpublish',
                    value: function () {
                        this.classRtcChannel.setClientRole(0);
                        this.classRtcChannel.muteLocalAudioStream(true);
                        this.classRtcChannel.muteLocalVideoStream(true);
                    }
                },
                {
                    key: 'leaveChannel',
                    value: function () {
                        this.classRtcChannel.leaveChannel();
                    }
                },
                {
                    key: 'enableLocalVideo',
                    value: function (e) {
                        var t;
                        null === (t = this.rtcEngine) || void 0 === t || t.enableLocalVideo(e);
                        this.classRtcChannel.muteLocalVideoStream(!e);
                    }
                },
                {
                    key: 'setVideoDevice',
                    value: function (e) {
                        this.rtcEngine.setVideoDevice(e);
                    }
                },
                {
                    key: 'setAudioRecordingDevice',
                    value: function (e) {
                        this.rtcEngine.setAudioRecordingDevice(e);
                    }
                },
                {
                    key: 'setAudioPlaybackDevice',
                    value: function (e) {
                        this.rtcEngine.setAudioPlaybackDevice(e);
                    }
                }
            ]), e;
        }(), Ra = function () {
            function e() {
                var t = arguments.length > 0 && void 0 !== arguments[0] ? arguments[0] : {};
                console.info('函数申明 _default(opts)', t, 'filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/videoGroupClass.js');
                Object(g.a)(this, e);
                this.options = t.options;
                this.stuInfo = t.stuInfo;
                this.rtcConfig = t.rtcConfig;
                this.requestTimer = null;
                this.groupStudentList = [];
            }
            return Object(C.a)(e, [
                {
                    key: 'sendRtcStatus',
                    value: function () {
                        var e = Object(A.a)(Object(P.a)().mark(function e() {
                            var t, s, o, a, n, r = arguments;
                            return Object(P.a)().wrap(function (e) {
                                while (1) {
                                    switch (e.prev = e.next) {
                                        case 0:
                                            return t = r.length > 0 && void 0 !== r[0] ? r[0] : {}, s = -1, e.next = 4, Object($.c)();
                                        case 4:
                                            return o = e.sent, e.next = 7, Object($.f)();
                                        case 7:
                                            if (a = e.sent, o && (s = 1), a && (s = 2), o && a && (s = 3), -1 != s) {
                                                e.next = 14;
                                                break;
                                            }
                                            return console.info('if(status == -1)为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/videoGroup/videoGroupClass.js'), e.abrupt('return');
                                        case 14:
                                            return n = {
                                                planId: this.options.planId,
                                                classId: this.options.classId,
                                                status: s,
                                                micPermission: a ? 1 : 2,
                                                cameraPermission: o ? 1 : 2,
                                                micIsOpen: a ? 1 : 2,
                                                cameraIsOpen: o ? 1 : 2
                                            }, void 0 !== t.displayVideo && (n.cameraIsOpen = t.displayVideo ? 1 : 2), e.next = 18, Object(Q.v)(n);
                                        case 18:
                                        case 'end':
                                            return e.stop();
                                    }
                                }
                            }, e, this);
                        }));
                        function t() {
                            return console.info('函数申明 sendRtcStatus, filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/videoGroupClass.js'), e.apply(this, arguments);
                        }
                        return t;
                    }()
                },
                {
                    key: 'queryGroupStudent',
                    value: function () {
                        var e = Object(A.a)(Object(P.a)().mark(function e(t) {
                            var s, o, a, n = this;
                            return Object(P.a)().wrap(function (e) {
                                while (1) {
                                    switch (e.prev = e.next) {
                                        case 0:
                                            if (!(this.groupStudentList.length >= 3)) {
                                                e.next = 3;
                                                break;
                                            }
                                            return console.info('if(this.groupStudentList.length >= 3)为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/videoGroup/videoGroupClass.js'), e.abrupt('return');
                                        case 3:
                                            return e.prev = 3, e.next = 6, Object(Q.o)({
                                                isParentAudition: this.options.isParent ? 1 : 0,
                                                planId: this.options.planId,
                                                classId: this.options.classId,
                                                cameraPerm: t.cameraStatus
                                            });
                                        case 6:
                                            if (s = e.sent, o = s.data || {}, a = o.list || [], a.forEach(function (e) {
                                                n.hasUserIdByStudentList(n.groupStudentList, e.userId) || (n.groupStudentList.push(e), t.addStudentCallback && t.addStudentCallback(e));
                                            }), !o.isFull) {
                                                e.next = 13;
                                                break;
                                            }
                                            return console.info('if(data.isFull)为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/videoGroup/videoGroupClass.js'), e.abrupt('return');
                                        case 13:
                                            this.delayQueryGroupStudent(t), e.next = 20;
                                            break;
                                        case 16:
                                            e.prev = 16, e.t0 = e.catch(3), console.error('videoGroup-queryGroupStudent-error', e.t0), this.delayQueryGroupStudent(t);
                                        case 20:
                                        case 'end':
                                            return e.stop();
                                    }
                                }
                            }, e, this, [[
                                3,
                                16
                            ]]);
                        }));
                        function t(t) {
                            return console.info('函数申明 queryGroupStudent(_x)', t, 'filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/videoGroupClass.js'), e.apply(this, arguments);
                        }
                        return t;
                    }()
                },
                {
                    key: 'queryClassStudentList',
                    value: function () {
                        var e = Object(A.a)(Object(P.a)().mark(function e() {
                            var t, s;
                            return Object(P.a)().wrap(function (e) {
                                while (1) {
                                    switch (e.prev = e.next) {
                                        case 0:
                                            return e.next = 2, Object(Q.n)({
                                                planId: this.options.planId,
                                                classId: this.options.classId
                                            });
                                        case 2:
                                            if (t = e.sent, t && 0 == t.code) {
                                                e.next = 6;
                                                break;
                                            }
                                            return console.info('if(!res || res.code != 0)为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/videoGroup/videoGroupClass.js'), e.abrupt('return', []);
                                        case 6:
                                            return s = t.data || [], e.abrupt('return', s);
                                        case 8:
                                        case 'end':
                                            return e.stop();
                                    }
                                }
                            }, e, this);
                        }));
                        function t() {
                            return console.info('函数申明 queryClassStudentList, filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/videoGroupClass.js'), e.apply(this, arguments);
                        }
                        return t;
                    }()
                },
                {
                    key: 'delayQueryGroupStudent',
                    value: function (e) {
                        var t = this;
                        this.requestTimer && clearTimeout(this.requestTimer);
                        this.requestTimer = setTimeout(function () {
                            t.queryGroupStudent(e);
                        }, 10000);
                    }
                },
                {
                    key: 'querySpeakStudentList',
                    value: function () {
                        var e = Object(A.a)(Object(P.a)().mark(function e() {
                            var t, s;
                            return Object(P.a)().wrap(function (e) {
                                while (1) {
                                    switch (e.prev = e.next) {
                                        case 0:
                                            return e.next = 2, Object(Q.t)({
                                                classId: this.options.classId,
                                                planId: this.options.planId
                                            });
                                        case 2:
                                            if (t = e.sent, t && 0 == t.code) {
                                                e.next = 6;
                                                break;
                                            }
                                            return console.info('if(!res || res.code != 0)为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/videoGroup/videoGroupClass.js'), e.abrupt('return', []);
                                        case 6:
                                            return s = t.data || {}, e.abrupt('return', s.list || []);
                                        case 8:
                                        case 'end':
                                            return e.stop();
                                    }
                                }
                            }, e, this);
                        }));
                        function t() {
                            return console.info('函数申明 querySpeakStudentList, filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/videoGroupClass.js'), e.apply(this, arguments);
                        }
                        return t;
                    }()
                },
                {
                    key: 'hasUserIdByStudentList',
                    value: function (e, t) {
                        var s = false;
                        return e.forEach(function (e) {
                            e.stuId != t && e.userId != t || (s = true);
                        }), s;
                    }
                },
                {
                    key: 'getTeamSwitchStatus',
                    value: function () {
                        var e = Object(A.a)(Object(P.a)().mark(function e() {
                            var t;
                            return Object(P.a)().wrap(function (e) {
                                while (1) {
                                    switch (e.prev = e.next) {
                                        case 0:
                                            return e.next = 2, window.thinkApi.ipc.invoke('getStoreValue', 'videoGroupSwitchStatus_'.concat(this.options.planId));
                                        case 2:
                                            return t = e.sent, e.abrupt('return', void 0 === t || t);
                                        case 4:
                                        case 'end':
                                            return e.stop();
                                    }
                                }
                            }, e, this);
                        }));
                        function t() {
                            return console.info('函数申明 getTeamSwitchStatus, filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/videoGroupClass.js'), e.apply(this, arguments);
                        }
                        return t;
                    }()
                },
                {
                    key: 'sendLogger',
                    value: function (e) {
                        var t = arguments.length > 1 && void 0 !== arguments[1] ? arguments[1] : {}, s = arguments.length > 2 && void 0 !== arguments[2] ? arguments[2] : 'info';
                        L.a.send({
                            tag: 'rtc',
                            level: s,
                            content: {
                                msg: e,
                                params: t
                            }
                        });
                    }
                }
            ]), e;
        }(), Ea = function () {
            var e = this, t = e._self._c;
            return t('div', { staticClass: 'video-item video-remote' }, [t('div', { staticClass: 'notice-text' }, [e._v(e._s(e.notice))])]);
        }, Va = [], Na = {
            props: {
                notice: {
                    type: String,
                    default: ''
                }
            }
        }, Da = Na, Ba = (s('c7c9'), Object(Ae.a)(Da, Ea, Va, false, null, '0de807bb', null)), Ua = Ba.exports, Ga = s('35ac'), Ha = {
            components: {
                Achievement: ma,
                LocalVideo: Ca,
                RemoteVideo: ka,
                VideoItemPad: Ua,
                OffLineVideo: Ta
            },
            props: {
                options: {
                    type: Object,
                    default: null
                },
                stuInfo: {
                    type: Object,
                    default: null
                },
                rtcConfig: {
                    type: Object,
                    default: null
                }
            },
            data: function () {
                return {
                    myChildInfo: {},
                    teamSwitchStatus: null,
                    localStuInfo: {
                        stuId: this.stuInfo.id,
                        stuName: this.stuInfo.nickName,
                        avatar: this.stuInfo.avatar,
                        displayVideo: false,
                        cameraStatus: true,
                        level: this.stuInfo.level
                    },
                    remoteStuInfo: [],
                    speakStudentList: [],
                    groupSpeakStatus: false,
                    videoLinkStatus: false,
                    otherCameraStatus: false,
                    localVideoDisplayCache: null,
                    remoteVideoFrameCache: {},
                    remoteVideoMutedCache: {},
                    isExaminationStatus: false,
                    canShowOtherChild: false,
                    classRtcSensor: null
                };
            },
            computed: {
                showAchievement: function () {
                    return console.info('对象函数 showAchievement,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/largeClass.vue'), !this.options.isAudition && !this.teamSwitchStatus;
                },
                localVideoPublishStatus: function () {
                    return console.info('对象函数 localVideoPublishStatus,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/largeClass.vue'), false !== this.localVideoDisplayCache && this.teamSwitchStatus;
                },
                achievementType: function () {
                    return console.info('对象函数 achievementType,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/largeClass.vue'), this.teamSwitchStatus ? (console.info('if(this.teamSwitchStatus)为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/videoGroup/largeClass.vue'), 'simple') : (console.info('if(this.teamSwitchStatus)为false,触发return,path: /renderer/components/Classroom/LargeClass/base/room/videoGroup/largeClass.vue'), 'normal');
                },
                showAudioWaves: function () {
                    return console.info('对象函数 showAudioWaves,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/largeClass.vue'), this.groupSpeakStatus;
                },
                hideLocalVideoIcon: function () {
                    return console.info('对象函数 hideLocalVideoIcon,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/largeClass.vue'), this.videoLinkStatus || this.otherCameraStatus ? (console.info('if(this.videoLinkStatus || this.otherCameraStatus)为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/videoGroup/largeClass.vue'), true) : (console.info('if(this.videoLinkStatus || this.otherCameraStatus)为false,触发return,path: /renderer/components/Classroom/LargeClass/base/room/videoGroup/largeClass.vue'), false);
                },
                hideRemoteVideo: function () {
                    return console.info('对象函数 hideRemoteVideo,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/largeClass.vue'), this.otherCameraStatus;
                },
                remoteStuPadNum: function () {
                    return console.info('对象函数 remoteStuPadNum,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/largeClass.vue'), 3 === this.remoteStuInfo.length ? (console.info('if(this.remoteStuInfo.length === 3)为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/videoGroup/largeClass.vue'), 0) : 3 - this.remoteStuInfo.length;
                }
            },
            mounted: function () {
                var e = {
                    options: this.options,
                    stuInfo: this.stuInfo,
                    rtcConfig: this.rtcConfig,
                    publishStatus: !this.options.isAudition
                };
                this.rtcClass = new Ma(e);
                this.videoGroup = new Ra(e);
                this.init();
            },
            methods: {
                initVideoShow: function () {
                    var e = this;
                    return Object(A.a)(Object(P.a)().mark(function t() {
                        return Object(P.a)().wrap(function (t) {
                            while (1) {
                                switch (t.prev = t.next) {
                                    case 0:
                                        if (console.info('对象函数 initVideoShow,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/largeClass.vue'), !e.options.isParent) {
                                            t.next = 7;
                                            break;
                                        }
                                        return t.next = 4, Object(Ga.d)('showOtherChild');
                                    case 4:
                                        e.canShowOtherChild = t.sent, t.next = 8;
                                        break;
                                    case 7:
                                        e.canShowOtherChild = true;
                                    case 8:
                                    case 'end':
                                        return t.stop();
                                }
                            }
                        }, t);
                    }))();
                },
                init: function () {
                    var e = this;
                    return Object(A.a)(Object(P.a)().mark(function t() {
                        return Object(P.a)().wrap(function (t) {
                            while (1) {
                                switch (t.prev = t.next) {
                                    case 0:
                                        return console.info('对象函数 init,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/largeClass.vue'), t.next = 3, e.initVideoShow();
                                    case 3:
                                        return t.next = 5, e.videoGroup.getTeamSwitchStatus();
                                    case 5:
                                        return e.teamSwitchStatus = t.sent, t.next = 8, e.initClassRtcChannel();
                                    case 8:
                                        return t.next = 10, Object($.c)();
                                    case 10:
                                        e.localStuInfo.cameraStatus = t.sent, e.listenBusEvent(), e.videoGroup.sendRtcStatus();
                                    case 13:
                                    case 'end':
                                        return t.stop();
                                }
                            }
                        }, t);
                    }))();
                },
                initClassRtcChannel: function () {
                    var e = this;
                    return Object(A.a)(Object(P.a)().mark(function t() {
                        var s, o;
                        return Object(P.a)().wrap(function (t) {
                            while (1) {
                                switch (t.prev = t.next) {
                                    case 0:
                                        return console.info('对象函数 initClassRtcChannel,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/largeClass.vue'), t.next = 3, e.rtcClass.init();
                                    case 3:
                                        s = t.sent, e.teamSwitchStatus || e.rtcClass.enableLocalVideo(false), s.on('connectionStateChanged', function (t) {
                                            console.info('箭头函数 监听 connectionStateChanged(state)', t, 'filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/largeClass.vue');
                                            5 == t ? e.classRtcSensor.rtcSensorPush({
                                                result: 'fail',
                                                errorType: '连接失败'
                                            }) : 4 == t && (e.classRtcSensor.isFirstJoinChannel = false, e.classRtcSensor.rtcSensorPush({ result: 'start' }));
                                        }), s.on('localJoinChannel', function () {
                                            console.info('箭头函数 监听 localJoinChannel,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/largeClass.vue');
                                            e.teamSwitchStatus && e.setupLocalVideo();
                                            e.options.isParent && e.setupMyChildVideo();
                                            e.canShowOtherChild && e.setupRemoteVideo();
                                            e.videoGroup.sendLogger('本地加入班级频道成功');
                                            e.classRtcSensor.rtcSensorPush({ result: 'success' });
                                        }), s.on('rejoinChannelSuccess', function () {
                                            console.info('箭头函数 监听 rejoinChannelSuccess,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/largeClass.vue');
                                            e.videoGroup.sendLogger('本地重连加入班级频道成功');
                                            e.classRtcSensor.rtcSensorPush({ result: 'success' });
                                        }), s.on('remoteLeaveChannel', function (t) {
                                            console.info('箭头函数 监听 remoteLeaveChannel(uid)', t, 'filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/largeClass.vue');
                                            e.videoGroup.sendLogger('远端学生离开频道, uid: '.concat(t));
                                            e.setRemoteStuVal(t, 'onlineStatus', false);
                                        }), s.on('remoteJoinChannel', function (t) {
                                            console.info('箭头函数 监听 remoteJoinChannel(uid)', t, 'filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/largeClass.vue');
                                            e.videoGroup.sendLogger('远端学生加入频道, uid: '.concat(t));
                                            e.setRemoteStuVal(t, 'onlineStatus', true);
                                            e.rtcClass.muteRemoteAudio(t, !e.isMyChild(t));
                                        }), s.on('remoteVideoStateChanged', function (t, s, o) {
                                            console.info('箭头函数 监听 remoteVideoStateChanged(uid, state, reason)', t, s, o, 'filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/largeClass.vue');
                                            2 == s && (e.remoteVideoFrameCache[t] = true, e.setRemoteStuVal(t, 'cameraStatus', true), e.setRemoteStuVal(t, 'onlineStatus', true), e.setRemoteStuVal(t, 'mutedVideoStatus', false), e.rtcClass.setupRemoteVideo(t, 'remote-'.concat(t)));
                                            5 === o && (e.remoteVideoMutedCache[t] = true, e.setRemoteStuVal(t, 'mutedVideoStatus', true));
                                            6 === o && (e.remoteVideoMutedCache[t] = false, e.setRemoteStuVal(t, 'mutedVideoStatus', false), e.rtcClass.setupRemoteVideo(t, 'remote-'.concat(t)));
                                            e.remoteStuInfo;
                                        }), e.classRtcSensor = new x.a(), e.classRtcSensor.rtcSensorPush({ result: 'start' }), o = s.joinChannel(), 0 == o ? e.videoGroup.sendLogger('调用加入班级频道成功') : (e.videoGroup.sendLogger('调用加入班级频道失败,code:'.concat(o), {}, 'error'), e.classRtcSensor.rtcSensorPush({
                                            result: 'fail',
                                            errorType: '调用加入房间接口失败'
                                        }));
                                    case 16:
                                    case 'end':
                                        return t.stop();
                                }
                            }
                        }, t);
                    }))();
                },
                listenBusEvent: function () {
                    var e = this;
                    console.info('对象函数 listenBusEvent,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/largeClass.vue');
                    this.$bus.$on('setDefaultVideoDevice', function (t) {
                        console.info('箭头函数 监听 setDefaultVideoDevice(deviceId)', t, 'filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/largeClass.vue');
                        e.rtcClass.setVideoDevice(t);
                    });
                    this.$bus.$on('setDefaultAudioRecordingDevice', function (t) {
                        console.info('箭头函数 监听 setDefaultAudioRecordingDevice(deviceId)', t, 'filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/largeClass.vue');
                        e.rtcClass.setAudioRecordingDevice(t);
                    });
                    this.$bus.$on('setDefaultAudioPlaybackDevice', function (t) {
                        console.info('箭头函数 监听 setDefaultAudioPlaybackDevice(deviceId)', t, 'filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/largeClass.vue');
                        e.rtcClass.setAudioPlaybackDevice(t);
                    });
                    this.$bus.$on('updateTeamSwitchStatus', function (t) {
                        console.info('箭头函数 监听 updateTeamSwitchStatus(status)', t, 'filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/largeClass.vue');
                        e.videoGroup.sendLogger('收到视频回显状态变化, status: '.concat(t));
                        e.teamSwitchStatus = t;
                        t ? false !== e.localVideoDisplayCache && (e.rtcClass.enableLocalVideo(true), e.setupLocalVideo()) : (e.rtcClass.enableLocalVideo(false), e.hideLocalVideo());
                    });
                    this.$bus.$on('cameraStatus', function (t) {
                        console.info('箭头函数 监听 cameraStatus(status)', t, 'filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/largeClass.vue');
                        e.$bus.$emit('teamSwitchDisabled', t);
                        t ? e.rtcClass.muteLocalVideo(true) : e.localVideoPublishStatus && e.rtcClass.muteLocalVideo(false);
                    });
                    this.$bus.$on('videoLinkStatus', function (t) {
                        console.info('箭头函数 监听 videoLinkStatus(status)', t, 'filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/largeClass.vue');
                        e.$bus.$emit('teamSwitchDisabled', t);
                        e.videoLinkStatus = t;
                    });
                    this.$bus.$on('localVideoLinkStatus', function (t) {
                        console.info('箭头函数 监听 localVideoLinkStatus(status)', t, 'filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/largeClass.vue');
                        e.videoGroup.sendLogger('收到视频连麦互动状态变化, status: '.concat(t));
                        t ? (e.rtcClass.unpublish(), e.hideLocalVideo()) : (e.rtcClass.publish({ publishVideo: e.localVideoPublishStatus }), e.setupLocalVideo());
                        e.otherCameraStatus = t;
                    });
                    this.$bus.$on('groupSpeakStatus', function (t) {
                        console.info('箭头函数 监听 groupSpeakStatus(status)', t, 'filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/largeClass.vue');
                        e.videoGroup.sendLogger('收到集体发言互动状态变化, status: '.concat(t));
                        e.groupSpeakStatus = t;
                        t ? e.collectiveSpeechOpen() : e.collectiveSpeechClose();
                    });
                    this.$bus.$on('liveQuit', function () {
                        console.info('箭头函数 监听 liveQuit,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/largeClass.vue');
                        e.rtcClass.unpublish();
                        e.rtcClass.leaveChannel();
                    });
                    this.$bus.$on('openExitByCoursewareChange', function (t) {
                        console.info('箭头函数 监听 openExitByCoursewareChange(backUrl)', t, 'filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/largeClass.vue');
                        Object(tt.d)(e.$t('classroom.modules.header.backConfirm.exitByCoursewareIdChange'), e.$t('courses.confirmModal.confirm'), t);
                    });
                    this.$bus.$on('getLocalDisplayVideoStatus', function (t) {
                        console.info('箭头函数 监听 getLocalDisplayVideoStatus(callback)', t, 'filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/largeClass.vue');
                        t && t(e.localVideoPublishStatus);
                    });
                    this.$bus.$on('chats.correctSelfMedalData', function (t) {
                        console.info('箭头函数 监听 chats.correctSelfMedalData(data)', t, 'filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/largeClass.vue');
                        e.localStuInfo.level = t.level;
                    });
                    this.$bus.$on('chats.correctMedalData', function (t) {
                        console.info('箭头函数 监听 chats.correctMedalData(data)', t, 'filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/largeClass.vue');
                        e.setRemoteStuVal(t.userId, 'level', t.level);
                    });
                    this.$bus.$on('setExaminationStatus', function (t) {
                        console.info('箭头函数 监听 setExaminationStatus(data)', t, 'filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/largeClass.vue');
                        e.isExaminationStatus = t;
                    });
                },
                setupLocalVideo: function () {
                    console.info('对象函数 setupLocalVideo,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/largeClass.vue');
                    !this.options.isAudition && this.localStuInfo.cameraStatus ? (this.rtcClass.setupLocalVideo('video-group-local'), false !== this.localVideoDisplayCache ? this.localStuInfo.displayVideo = true : console.info('if(this.localVideoDisplayCache === false)为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/videoGroup/largeClass.vue')) : console.info('if(this.options.isAudition || !this.localStuInfo.cameraStatus)为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/videoGroup/largeClass.vue');
                },
                hideLocalVideo: function () {
                    console.info('对象函数 hideLocalVideo,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/largeClass.vue');
                    this.localStuInfo.displayVideo = false;
                },
                buildInfo: function (e) {
                    console.info('对象函数 buildInfo(stuInfo)', e, 'filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/largeClass.vue');
                    var t = this.remoteVideoFrameCache[e.userId], s = this.remoteVideoMutedCache[e.userId] || false;
                    return {
                        showStatus: true,
                        stuId: e.userId,
                        stuName: e.nickName,
                        avatar: e.avatar,
                        level: e.level,
                        cameraStatus: !!t,
                        displayVideo: true,
                        mutedVideoStatus: s,
                        onlineStatus: !!t
                    };
                },
                setupRemoteVideo: function () {
                    var e = this;
                    console.info('对象函数 setupRemoteVideo,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/largeClass.vue');
                    this.videoGroup.queryGroupStudent({
                        cameraStatus: this.localStuInfo.cameraStatus ? 1 : 2,
                        addStudentCallback: function (t) {
                            var s = e.buildInfo(t);
                            e.remoteStuInfo.push(s);
                            e.$nextTick(function () {
                                this.rtcClass.muteRemoteAudio(t.userId, true);
                                this.rtcClass.setupRemoteVideo(t.userId, 'remote-'.concat(t.userId));
                                this.teamSwitchStatus || this.handleRemoteVideoStatus(t.userId, false);
                            });
                        }
                    });
                },
                setupMyChildVideo: function () {
                    console.info('对象函数 setupMyChildVideo,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/largeClass.vue');
                    var e = Object(F.a)(Object(F.a)({}, this.localStuInfo), {}, {
                        userId: this.localStuInfo.stuId,
                        nickName: this.localStuInfo.stuName
                    });
                    this.myChildInfo = this.buildInfo(e);
                    this.$nextTick(function () {
                        this.rtcClass.setupRemoteVideo(e.userId, 'remote-'.concat(e.userId));
                        this.teamSwitchStatus || this.handleRemoteVideoStatus(e.userId, false);
                    });
                },
                handleLocalVideoStatus: function () {
                    console.info('对象函数 handleLocalVideoStatus,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/largeClass.vue');
                    this.localStuInfo.displayVideo ? this.rtcClass.muteLocalVideo(true) : (this.rtcClass.muteLocalVideo(false), this.setupLocalVideo());
                    this.localStuInfo.displayVideo = !this.localStuInfo.displayVideo;
                    this.localVideoDisplayCache = this.localStuInfo.displayVideo;
                    this.videoGroup.sendRtcStatus({ displayVideo: this.localStuInfo.displayVideo });
                    Rs.s(this.localStuInfo.displayVideo);
                    this.$bus.$emit('updateLocalDisplayVideoStatus', this.localStuInfo.displayVideo);
                    this.videoGroup.sendLogger('学生操作本地视频开关状态, status: '.concat(this.localStuInfo.displayVideo));
                },
                handleRemoteVideoStatus: function (e, t) {
                    console.info('对象函数 handleRemoteVideoStatus(stuId, status)', e, t, 'filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/largeClass.vue');
                    this.setRemoteStuVal(e, 'displayVideo', t);
                    this.videoGroup.sendLogger('学生操作远端视频开关状态, uid: '.concat(e, ' status: ').concat(t));
                },
                setRemoteStuVal: function (e, t, s) {
                    var o = this;
                    console.info('对象函数 setRemoteStuVal(uid, key, val)', e, t, s, 'filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/largeClass.vue');
                    e ? this.isMyChild(e) ? this.$set(this.myChildInfo, t, s) : this.remoteStuInfo.forEach(function (a, n) {
                        a.stuId == e && o.$set(o.remoteStuInfo[n], t, s);
                    }) : console.info('if(!uid)为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/videoGroup/largeClass.vue');
                },
                isMyChild: function (e) {
                    return console.info('对象函数 isMyChild(uid)', e, 'filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/largeClass.vue'), this.options.isParent && e == this.options.stuId;
                },
                collectiveSpeechOpen: function () {
                    var e = this;
                    return Object(A.a)(Object(P.a)().mark(function t() {
                        var s;
                        return Object(P.a)().wrap(function (t) {
                            while (1) {
                                switch (t.prev = t.next) {
                                    case 0:
                                        return console.info('对象函数 collectiveSpeechOpen,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/largeClass.vue'), t.next = 3, e.videoGroup.querySpeakStudentList();
                                    case 3:
                                        if (s = t.sent, s.length && e.groupSpeakStatus) {
                                            t.next = 7;
                                            break;
                                        }
                                        return console.info('if(!speakStudentList.length || !_this7.groupSpeakStatus)为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/videoGroup/largeClass.vue'), t.abrupt('return');
                                    case 7:
                                        e.speakStudentList = s, e.speakStudentList.forEach(function (t) {
                                            e.rtcClass.muteRemoteAudio(t, false);
                                        }), e.videoGroup.sendLogger('集体发言拉取远端学生音频流, 远端学生列表: '.concat(JSON.stringify(s)));
                                    case 10:
                                    case 'end':
                                        return t.stop();
                                }
                            }
                        }, t);
                    }))();
                },
                collectiveSpeechClose: function () {
                    var e = this;
                    console.info('对象函数 collectiveSpeechClose,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/largeClass.vue');
                    this.speakStudentList.forEach(function (t) {
                        e.rtcClass.muteRemoteAudio(t, true);
                    });
                    this.speakStudentList = [];
                }
            }
        }, _a = Ha, Fa = (s('d672'), Object(Ae.a)(_a, aa, na, false, null, '636c827e', null)), Wa = Fa.exports, Ka = function () {
            var e = this, t = e._self._c;
            return t('div', { staticClass: 'small-class' }, [
                t('Achievement', {
                    attrs: {
                        options: e.options,
                        type: 'normal'
                    }
                }),
                t('div', { staticClass: 'video-group-wrapper class-type-small' }, [
                    t('VideoChatsSwitch', {
                        attrs: { videoGroupShowStatus: e.videoGroupShowStatus },
                        on: {
                            switchVideoChats: e.handleChangeVideoChat,
                            handlePrevPage: e.handlePrevPage,
                            handleNextPage: e.handleNextPage
                        }
                    }),
                    t('div', {
                        directives: [{
                            name: 'show',
                            rawName: 'v-show',
                            value: e.videoGroupShowStatus && 'video' === e.showVideoChatType,
                            expression: 'videoGroupShowStatus && showVideoChatType === \'video\''
                        }]
                    }, [t('div', { staticClass: 'video-group-contenter' }, [
                        t('LocalVideo', {
                            directives: [{
                                name: 'show',
                                rawName: 'v-show',
                                value: e.localVideoShowStatus,
                                expression: 'localVideoShowStatus'
                            }],
                            attrs: {
                                options: e.options,
                                localStuInfo: e.localStuInfo,
                                hideVideoIcon: e.hideLocalVideoIcon,
                                classType: e.classType
                            },
                            on: {
                                handleLocalVideoStatus: e.handleLocalVideoStatus,
                                handleLocalMicrophoneStatus: e.handleLocalMicrophoneStatus
                            }
                        }),
                        e._l(e.remoteStuInfo, function (s) {
                            return [t('RemoteVideo', {
                                key: s.stuId,
                                attrs: {
                                    remoteStuInfo: s,
                                    showAudioWaves: e.showAudioWaves,
                                    hideRemoteVideo: e.hideRemoteVideo,
                                    isExaminationStatus: e.isExaminationStatus
                                },
                                on: { handleRemoteVideoStatus: e.handleRemoteVideoStatus }
                            })];
                        })
                    ], 2)]),
                    e.videoGroupShowStatus || 'video' !== e.showVideoChatType ? e._e() : t('div', { staticClass: 'close-video-tag' }, [t('span', [e._v(e._s(e.$t('classroom.largeClass.videoGroup.closedNotice')))])])
                ], 1)
            ], 1);
        }, qa = [], za = s('b85c'), Ja = (s('4ec9'), s('3ca3'), s('ddb0'), s('7db0'), s('a434'), function () {
            var e = this, t = e._self._c;
            return t('div', { staticClass: 'switch' }, [
                t('div', {
                    staticClass: 'arrow-left left',
                    on: { click: e.prevGroup }
                }),
                t('div', { staticClass: 'switch-content' }, [
                    t('div', {
                        staticClass: 'switch-btn btn-video',
                        on: {
                            click: function (t) {
                                return e.tabSwitch('video');
                            }
                        }
                    }, [e._v(' ' + e._s(e.$t('classroom.largeClass.videoGroup.tabNames')[0]) + ' ')]),
                    t('div', {
                        staticClass: 'switch-btn btn-chats',
                        on: {
                            click: function (t) {
                                return e.tabSwitch('chat');
                            }
                        }
                    }, [t('span', [
                        e._v(' ' + e._s(e.$t('classroom.largeClass.videoGroup.tabNames')[1]) + ' '),
                        'video' === e.switchKey && e.hasPrivateNewMsg ? t('label') : e._e()
                    ])]),
                    t('div', {
                        staticClass: 'switch-bg',
                        class: 'video' == e.switchKey ? 'left-video' : 'left-chats'
                    })
                ]),
                t('div', {
                    staticClass: 'arrow-right right',
                    on: { click: e.nextGroup }
                })
            ]);
        }), Qa = [], Za = {
            data: function () {
                return {
                    switchKey: 'video',
                    hasPrivateNewMsg: false
                };
            },
            props: {
                videoGroupShowStatus: {
                    type: Boolean,
                    default: true
                }
            },
            mounted: function () {
                var e = this;
                this.$bus.$on('chats.privateMessagePush', function () {
                    console.info('箭头函数 监听 chats.privateMessagePush,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/videoChatsSwitch.vue');
                    'chat' === e.switchKey ? e.hasPrivateNewMsg = false : e.hasPrivateNewMsg = true;
                });
            },
            methods: {
                tabSwitch: function (e) {
                    console.info('对象函数 tabSwitch(key)', e, 'filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/videoChatsSwitch.vue');
                    'chat' === e && (this.hasPrivateNewMsg = false);
                    this.switchKey = e;
                    this.$emit('switchVideoChats', e);
                    this.$bus.$emit('switchVideoAndChat', e);
                },
                prevGroup: function () {
                    console.info('对象函数 prevGroup,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/videoChatsSwitch.vue');
                    this.$emit('handlePrevPage');
                },
                nextGroup: function () {
                    console.info('对象函数 nextGroup,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/videoChatsSwitch.vue');
                    this.$emit('handleNextPage');
                }
            },
            watch: {
                videoGroupShowStatus: {
                    handler: function (e, t) {
                        console.info('对象函数 handler(newValue, oldValue)', e, t, 'filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/videoChatsSwitch.vue');
                        e ? this.tabSwitch('video') : this.tabSwitch('chat');
                    }
                }
            }
        }, Ya = Za, Xa = (s('1643'), Object(Ae.a)(Ya, Ja, Qa, false, null, '2bee514c', null)), $a = Xa.exports, en = {
            components: {
                VideoChatsSwitch: $a,
                LocalVideo: Ca,
                RemoteVideo: ka,
                Achievement: ma
            },
            props: {
                options: {
                    type: Object,
                    default: null
                },
                stuInfo: {
                    type: Object,
                    default: null
                },
                rtcConfig: {
                    type: Object,
                    default: null
                },
                classType: {
                    type: Number,
                    default: -1
                }
            },
            data: function () {
                return {
                    teamSwitchStatus: null,
                    showVideoChatType: 'video',
                    localStuInfo: {
                        stuId: this.stuInfo.id,
                        stuName: this.stuInfo.nickName,
                        avatar: this.stuInfo.avatar,
                        displayVideo: false,
                        cameraStatus: true,
                        microphoneStatus: false,
                        level: this.stuInfo.level
                    },
                    remoteStuInfo: [],
                    speakStudentList: [],
                    groupSpeakStatus: false,
                    videoLinkStatus: false,
                    otherCameraStatus: false,
                    localVideoDisplayCache: null,
                    remoteAudioStatus: false,
                    pageNum: 1,
                    pageSize: 6,
                    classStudentMap: new Map(),
                    remoteLevelCache: {},
                    isExaminationStatus: false,
                    rtcSensor: null
                };
            },
            computed: {
                localVideoPublishStatus: function () {
                    return console.info('对象函数 localVideoPublishStatus,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue'), false !== this.localVideoDisplayCache && this.teamSwitchStatus;
                },
                videoGroupShowStatus: function () {
                    return console.info('对象函数 videoGroupShowStatus,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue'), true === this.teamSwitchStatus;
                },
                localVideoShowStatus: function () {
                    return console.info('对象函数 localVideoShowStatus,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue'), 1 === this.pageNum && (console.info('if(this.pageNum === 1)为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue'), true);
                },
                showAudioWaves: function () {
                    return console.info('对象函数 showAudioWaves,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue'), this.groupSpeakStatus;
                },
                hideLocalVideoIcon: function () {
                    return console.info('对象函数 hideLocalVideoIcon,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue'), this.videoLinkStatus || this.otherCameraStatus ? (console.info('if(this.videoLinkStatus || this.otherCameraStatus)为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue'), true) : (console.info('if(this.videoLinkStatus || this.otherCameraStatus)为false,触发return,path: /renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue'), false);
                },
                hideRemoteVideo: function () {
                    return console.info('对象函数 hideRemoteVideo,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue'), this.otherCameraStatus;
                },
                pageCount: function () {
                    console.info('对象函数 pageCount,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue');
                    var e = this.remoteStuInfo.length, t = this.pageSize - 1;
                    if (e <= t) {
                        return console.info('if(totalCount <= onePageCount)为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue'), 1;
                    }
                    var s = e - t;
                    return Math.floor(s / this.pageSize) + (s % this.pageSize > 0 ? 1 : 0) + 1;
                }
            },
            mounted: function () {
                var e = {
                    options: this.options,
                    stuInfo: this.stuInfo,
                    rtcConfig: this.rtcConfig,
                    classType: this.classType
                };
                this.rtcClass = new Ma(e);
                this.videoGroup = new Ra(e);
                this.init();
            },
            methods: {
                init: function () {
                    var e = this;
                    return Object(A.a)(Object(P.a)().mark(function t() {
                        return Object(P.a)().wrap(function (t) {
                            while (1) {
                                switch (t.prev = t.next) {
                                    case 0:
                                        return console.info('对象函数 init,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue'), t.next = 3, e.videoGroup.getTeamSwitchStatus();
                                    case 3:
                                        return e.teamSwitchStatus = t.sent, t.next = 6, e.initClassStudent();
                                    case 6:
                                        return t.next = 8, e.initClassRtcChannel();
                                    case 8:
                                        return t.next = 10, e.initMediaAccess();
                                    case 10:
                                        e.listenBusEvent(), e.videoGroup.sendRtcStatus();
                                    case 12:
                                    case 'end':
                                        return t.stop();
                                }
                            }
                        }, t);
                    }))();
                },
                initMediaAccess: function () {
                    var e = this;
                    return Object(A.a)(Object(P.a)().mark(function t() {
                        return Object(P.a)().wrap(function (t) {
                            while (1) {
                                switch (t.prev = t.next) {
                                    case 0:
                                        return console.info('对象函数 initMediaAccess,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue'), t.next = 3, Object($.c)();
                                    case 3:
                                        return e.localStuInfo.cameraStatus = t.sent, t.next = 6, Object($.f)();
                                    case 6:
                                        e.localStuInfo.microphoneStatus = t.sent, e.$bus.$emit('updateLocalDisplayVideoStatus', e.localStuInfo.cameraStatus && e.teamSwitchStatus), e.$bus.$emit('updateMicrophoneStatus', e.localStuInfo.microphoneStatus);
                                    case 9:
                                    case 'end':
                                        return t.stop();
                                }
                            }
                        }, t);
                    }))();
                },
                initClassStudent: function () {
                    var e = this;
                    return Object(A.a)(Object(P.a)().mark(function t() {
                        var s;
                        return Object(P.a)().wrap(function (t) {
                            while (1) {
                                switch (t.prev = t.next) {
                                    case 0:
                                        return console.info('对象函数 initClassStudent,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue'), t.next = 3, e.videoGroup.queryClassStudentList();
                                    case 3:
                                        s = t.sent, s.forEach(function (t) {
                                            e.classStudentMap.set(t.userId, t);
                                        }), e.classStudentMap;
                                    case 6:
                                    case 'end':
                                        return t.stop();
                                }
                            }
                        }, t);
                    }))();
                },
                updateClassStudent: function (e) {
                    var t = this;
                    return Object(A.a)(Object(P.a)().mark(function s() {
                        var o, a;
                        return Object(P.a)().wrap(function (s) {
                            while (1) {
                                switch (s.prev = s.next) {
                                    case 0:
                                        return console.info('对象函数 updateClassStudent(uid)', e, 'filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue'), s.next = 3, t.videoGroup.queryClassStudentList();
                                    case 3:
                                        o = s.sent, a = o.find(function (t) {
                                            return e == t.userId;
                                        }), a && t.classStudentMap.set(a.userId, a), t.handleRemoteJoinChannel(e);
                                    case 7:
                                    case 'end':
                                        return s.stop();
                                }
                            }
                        }, s);
                    }))();
                },
                initClassRtcChannel: function () {
                    var e = this;
                    return Object(A.a)(Object(P.a)().mark(function t() {
                        var s, o;
                        return Object(P.a)().wrap(function (t) {
                            while (1) {
                                switch (t.prev = t.next) {
                                    case 0:
                                        return console.info('对象函数 initClassRtcChannel,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue'), t.next = 3, e.rtcClass.init();
                                    case 3:
                                        s = t.sent, 2 === e.classType && e.$bus.$emit('player.smallClassRtcReady', s), e.teamSwitchStatus || e.rtcClass.enableLocalVideo(false), s.on('connectionStateChanged', function (t) {
                                            console.info('箭头函数 监听 connectionStateChanged(state)', t, 'filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue');
                                            5 == t ? e.rtcSensor.rtcSensorPush({
                                                result: 'fail',
                                                errorType: '连接失败'
                                            }) : 4 == t && (e.rtcSensor.isFirstJoinChannel = false, e.rtcSensor.rtcSensorPush({ result: 'start' }));
                                        }), s.on('localJoinChannel', function () {
                                            console.info('箭头函数 监听 localJoinChannel,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue');
                                            e.videoGroup.sendLogger('伪小班本地加入频道成功');
                                            e.teamSwitchStatus && e.setupLocalVideo();
                                            e.rtcSensor.rtcSensorPush({ result: 'success' });
                                        }), s.on('rejoinChannelSuccess', function () {
                                            console.info('箭头函数 监听 rejoinChannelSuccess,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue');
                                            e.videoGroup.sendLogger('伪小班本地重连加入班级频道成功');
                                            e.rtcSensor.rtcSensorPush({ result: 'success' });
                                        }), s.on('remoteLeaveChannel', function (t) {
                                            console.info('箭头函数 监听 remoteLeaveChannel(uid)', t, 'filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue');
                                            e.handleRemoteLeaveChannel(t);
                                            e.videoGroup.sendLogger('远端学生离开频道, uid: '.concat(t));
                                        }), s.on('remoteJoinChannel', function () {
                                            var t = Object(A.a)(Object(P.a)().mark(function t(s) {
                                                var o;
                                                return Object(P.a)().wrap(function (t) {
                                                    while (1) {
                                                        switch (t.prev = t.next) {
                                                            case 0:
                                                                console.info('箭头函数 监听 remoteJoinChannel(uid)', s, 'filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue'), e.videoGroup.sendLogger('远端学生加入频道, uid: '.concat(s)), o = e.classStudentMap.get(String(s)), o ? e.handleRemoteJoinChannel(s) : e.updateClassStudent(s);
                                                            case 5:
                                                            case 'end':
                                                                return t.stop();
                                                        }
                                                    }
                                                }, t);
                                            }));
                                            return function (e) {
                                                return t.apply(this, arguments);
                                            };
                                        }()), s.on('remoteVideoStateChanged', function (t, s, o) {
                                            console.info('箭头函数 监听 remoteVideoStateChanged(uid, state, reason)', t, s, o, 'filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue');
                                            1 == s && (e.setRemoteStuVal(t, 'cameraStatus', true), e.$nextTick(function () {
                                                this.rtcClass.setupRemoteVideo(t, 'remote-'.concat(t));
                                            }));
                                            5 === o && e.setRemoteStuVal(t, 'mutedVideoStatus', true);
                                            6 === o && (e.setRemoteStuVal(t, 'mutedVideoStatus', false), e.$nextTick(function () {
                                                this.rtcClass.setupRemoteVideo(t, 'remote-'.concat(t));
                                            }));
                                            e.remoteStuInfo;
                                        }), e.rtcSensor = new x.a(), e.rtcSensor.rtcSensorPush({ result: 'start' }), o = s.joinChannel(), 0 == o ? e.videoGroup.sendLogger('伪小班调用加入频道成功') : (e.videoGroup.sendLogger('伪小班调用加入频道失败,code:'.concat(o), {}, 'error'), e.rtcSensor.rtcSensorPush({
                                            result: 'fail',
                                            errorType: '调用加入房间接口失败'
                                        }));
                                    case 17:
                                    case 'end':
                                        return t.stop();
                                }
                            }
                        }, t);
                    }))();
                },
                listenBusEvent: function () {
                    var e = this;
                    console.info('对象函数 listenBusEvent,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue');
                    this.$bus.$on('setDefaultVideoDevice', function (t) {
                        console.info('箭头函数 监听 setDefaultVideoDevice(deviceId)', t, 'filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue');
                        e.rtcClass.setVideoDevice(t);
                    });
                    this.$bus.$on('setDefaultAudioRecordingDevice', function (t) {
                        console.info('箭头函数 监听 setDefaultAudioRecordingDevice(deviceId)', t, 'filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue');
                        e.rtcClass.setAudioRecordingDevice(t);
                    });
                    this.$bus.$on('setDefaultAudioPlaybackDevice', function (t) {
                        console.info('箭头函数 监听 setDefaultAudioPlaybackDevice(deviceId)', t, 'filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue');
                        e.rtcClass.setAudioPlaybackDevice(t);
                    });
                    this.$bus.$on('updateTeamSwitchStatus', function (t) {
                        console.info('箭头函数 监听 updateTeamSwitchStatus(status)', t, 'filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue');
                        e.videoGroup.sendLogger('收到视频回显状态变化, status: '.concat(t));
                        e.teamSwitchStatus = t;
                        t ? false !== e.localVideoDisplayCache && (e.rtcClass.enableLocalVideo(true), e.setupLocalVideo()) : (e.rtcClass.enableLocalVideo(false), e.hideLocalVideo());
                        e.$bus.$emit('updateLocalDisplayVideoStatus', e.localVideoPublishStatus);
                    });
                    this.$bus.$on('cameraStatus', function (t) {
                        console.info('箭头函数 监听 cameraStatus(status)', t, 'filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue');
                        e.$bus.$emit('teamSwitchDisabled', t);
                        t ? e.rtcClass.muteLocalVideo(true) : e.localVideoPublishStatus && e.rtcClass.muteLocalVideo(false);
                    });
                    this.$bus.$on('videoLinkStatus', function (t) {
                        console.info('箭头函数 监听 videoLinkStatus(status)', t, 'filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue');
                        e.$bus.$emit('teamSwitchDisabled', t);
                        e.videoLinkStatus = t;
                    });
                    this.$bus.$on('localVideoLinkStatus', function (t) {
                        console.info('箭头函数 监听 localVideoLinkStatus(status)', t, 'filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue');
                        e.videoGroup.sendLogger('收到视频连麦互动状态变化, status: '.concat(t));
                        2 == e.classType ? t ? e.hideLocalVideo() : e.setupLocalVideo() : t ? (e.rtcClass.unpublish(), e.hideLocalVideo()) : (e.rtcClass.publish({ publishVideo: e.localVideoPublishStatus }), e.setupLocalVideo());
                        e.otherCameraStatus = t;
                    });
                    this.$bus.$on('multVideoLinkStatus', function (t) {
                        var s = t.pub, o = t.status, a = t.stuId;
                        if (console.info('箭头函数 监听 multVideoLinkStatus(pub, status, stuId)', s, o, a, 'filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue'), !s) {
                            return console.info('if(!pub)为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue'), e.videoLinkStatus = false, e.$bus.$emit('teamSwitchDisabled', false), void (e.remoteAudioStatus && e.collectiveSpeechOpen());
                        }
                        if (s && 1 == o) {
                            return console.info('if(pub && status == 1)为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue'), e.videoLinkStatus = true, e.$bus.$emit('teamSwitchDisabled', true), void (e.remoteAudioStatus && e.collectiveSpeechClose());
                        }
                        if (a) {
                            var n = a == e.localStuInfo.stuId;
                            2 == o && (n ? e.hideLocalVideo() : e.setRemoteStuVal(a, 'displayVideo', false));
                            3 == o && (n ? e.setupLocalVideo() : (e.setRemoteStuVal(a, 'displayVideo', true), e.$nextTick(function () {
                                this.rtcClass.setupRemoteVideo(Number(a), 'remote-'.concat(a));
                            })));
                        } else {
                            console.info('if(!stuId)为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue');
                        }
                    });
                    this.$bus.$on('groupSpeakStatus', function (t) {
                        console.info('箭头函数 监听 groupSpeakStatus(status)', t, 'filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue');
                        e.videoGroup.sendLogger('收到集体发言互动状态变化, status: '.concat(t));
                        e.groupSpeakStatus = t;
                        t ? e.collectiveSpeechOpen() : e.collectiveSpeechClose();
                    });
                    this.$bus.$on('remoteAudioStatus', function (t) {
                        console.info('箭头函数 监听 remoteAudioStatus(status)', t, 'filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue');
                        e.videoGroup.sendLogger('收到语音管理状态变化, status: '.concat(t));
                        e.remoteAudioStatus = t;
                        t ? e.collectiveSpeechOpen() : e.collectiveSpeechClose();
                    });
                    this.$bus.$on('liveQuit', function () {
                        console.info('箭头函数 监听 liveQuit,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue');
                        e.rtcClass.unpublish();
                        e.rtcClass.leaveChannel();
                    });
                    this.$bus.$on('getLocalDisplayVideoStatus', function (t) {
                        console.info('箭头函数 监听 getLocalDisplayVideoStatus(callback)', t, 'filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue');
                        t && t(e.localVideoPublishStatus);
                    });
                    this.$bus.$on('getLocalMicrophoneStatus', function (t) {
                        console.info('箭头函数 监听 getLocalMicrophoneStatus(callback)', t, 'filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue');
                        t && t(e.localStuInfo.microphoneStatus);
                    });
                    this.$bus.$on('chats.correctSelfMedalData', function (t) {
                        console.info('箭头函数 监听 chats.correctSelfMedalData(data)', t, 'filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue');
                        e.localStuInfo.level = t.level;
                    });
                    this.$bus.$on('chats.correctMedalData', function (t) {
                        console.info('箭头函数 监听 chats.correctMedalData(data)', t, 'filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue');
                        e.setRemoteStuVal(t.userId, 'level', t.level);
                        e.remoteLevelCache[t.userId] = t.level;
                    });
                    this.$bus.$on('setExaminationStatus', function (t) {
                        console.info('箭头函数 监听 setExaminationStatus(data)', t, 'filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue');
                        e.isExaminationStatus = t;
                    });
                },
                setupLocalVideo: function () {
                    console.info('对象函数 setupLocalVideo,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue');
                    this.localStuInfo.cameraStatus ? (this.rtcClass.setupLocalVideo('video-group-local'), false !== this.localVideoDisplayCache ? this.localStuInfo.displayVideo = true : console.info('if(this.localVideoDisplayCache === false)为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue')) : console.info('if(!this.localStuInfo.cameraStatus)为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue');
                },
                handleChangeVideoChat: function (e) {
                    console.info('对象函数 handleChangeVideoChat(type)', e, 'filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue');
                    this.showVideoChatType = e;
                },
                hideLocalVideo: function () {
                    console.info('对象函数 hideLocalVideo,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue');
                    this.localStuInfo.displayVideo = false;
                },
                handleRemoteJoinChannel: function (e) {
                    console.info('对象函数 handleRemoteJoinChannel(uid)', e, 'filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue');
                    var t = this.classStudentMap.get(String(e));
                    if (t) {
                        if (this.videoGroup.hasUserIdByStudentList(this.remoteStuInfo, e)) {
                            console.info('if(this.videoGroup.hasUserIdByStudentList(this.remoteStuInfo, uid))为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue');
                        } else {
                            this.remoteStuInfo.push({
                                showStatus: false,
                                stuId: t.userId,
                                stuName: t.nickName,
                                avatar: t.avatar,
                                level: this.remoteLevelCache[e] || t.level,
                                cameraStatus: false,
                                displayVideo: true,
                                mutedVideoStatus: false,
                                onlineStatus: true
                            });
                            var s = this.hasPageByUid(e);
                            s && this.setRemoteStuVal(e, 'showStatus', true);
                            this.remoteStuInfo;
                        }
                    } else {
                        console.info('if(!stuInfo)为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue');
                    }
                },
                handleRemoteLeaveChannel: function (e) {
                    var t = this;
                    console.info('对象函数 handleRemoteLeaveChannel(uid)', e, 'filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue');
                    var s = -1;
                    if (this.remoteStuInfo.forEach(function (t, o) {
                        t.stuId == e && (s = o);
                    }), -1 !== s) {
                        this.remoteStuInfo.splice(s, 1);
                        var o = this.getIndexRangeByPageNum(this.pageNum), a = 0;
                        this.remoteStuInfo.forEach(function (e, s) {
                            s >= o.start && s <= o.end && !e.showStatus && (t.$set(t.remoteStuInfo[s], 'showStatus', true), a++);
                        });
                        0 === a && (this.pageNum = this.getValidPageNum(this.pageNum), this.pageNum, this.changePageRender());
                        this.remoteStuInfo;
                    } else {
                        console.info('if(stuIndex === -1)为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue');
                    }
                },
                handleLocalVideoStatus: function () {
                    console.info('对象函数 handleLocalVideoStatus,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue');
                    this.localStuInfo.displayVideo ? this.rtcClass.enableLocalVideo(false) : this.rtcClass.enableLocalVideo(true);
                    this.localStuInfo.displayVideo = !this.localStuInfo.displayVideo;
                    this.localVideoDisplayCache = this.localStuInfo.displayVideo;
                    this.videoGroup.sendRtcStatus({ displayVideo: this.localStuInfo.displayVideo });
                    this.$bus.$emit('updateLocalDisplayVideoStatus', this.localStuInfo.displayVideo);
                    this.videoGroup.sendLogger('学生操作本地视频开关状态, status: '.concat(this.localStuInfo.displayVideo));
                },
                handleLocalMicrophoneStatus: function () {
                    console.info('对象函数 handleLocalMicrophoneStatus,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue');
                    this.localStuInfo.microphoneStatus = !this.localStuInfo.microphoneStatus;
                    this.rtcClass.muteLocalAudio(!this.localStuInfo.microphoneStatus);
                    this.$bus.$emit('updateMicrophoneStatus', this.localStuInfo.microphoneStatus);
                },
                handleRemoteVideoStatus: function (e, t) {
                    console.info('对象函数 handleRemoteVideoStatus(stuId, status)', e, t, 'filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue');
                    this.setRemoteStuVal(e, 'displayVideo', t);
                    this.videoGroup.sendLogger('学生操作远端视频开关状态, uid: '.concat(e, ' status: ').concat(t));
                },
                setRemoteStuVal: function (e, t, s) {
                    var o = this;
                    console.info('对象函数 setRemoteStuVal(uid, key, val)', e, t, s, 'filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue');
                    e ? this.remoteStuInfo.forEach(function (a, n) {
                        a.stuId == e && o.$set(o.remoteStuInfo[n], t, s);
                    }) : console.info('if(!uid)为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue');
                },
                handlePrevPage: function () {
                    console.info('对象函数 handlePrevPage,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue');
                    1 !== this.pageNum ? (this.pageNum--, this.changePageRender()) : console.info('if(this.pageNum === 1)为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue');
                },
                handleNextPage: function () {
                    console.info('对象函数 handleNextPage,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue');
                    this.pageNum >= this.pageCount ? console.info('if(this.pageNum >= this.pageCount)为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue') : (this.pageNum++, this.changePageRender());
                },
                changePageRender: function () {
                    var e = this;
                    console.info('对象函数 changePageRender,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue');
                    this.remoteStuInfo.forEach(function (t, s) {
                        e.$set(e.remoteStuInfo[s], 'showStatus', false);
                    });
                    this.remoteStuInfo.forEach(function (t, s) {
                        var o = e.hasPageByUid(t.stuId);
                        o && e.$set(e.remoteStuInfo[s], 'showStatus', true);
                    });
                },
                getIndexRangeByPageNum: function (e) {
                    return console.info('对象函数 getIndexRangeByPageNum(pageNum)', e, 'filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue'), 1 === e ? (console.info('if(pageNum === 1)为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue'), {
                        start: 0,
                        end: this.pageSize - 2
                    }) : {
                        start: (e - 1) * this.pageSize - 1,
                        end: e * this.pageSize - 2
                    };
                },
                hasPageByUid: function (e) {
                    console.info('对象函数 hasPageByUid(uid)', e, 'filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue');
                    var t = this.getIndexRangeByPageNum(this.pageNum), s = -1;
                    return this.remoteStuInfo.forEach(function (t, o) {
                        t.stuId == e && (s = o);
                    }), -1 == s ? (console.info('if(uidIndex == -1)为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue'), false) : s >= t.start && s <= t.end ? (console.info('if(uidIndex >= indexRange.start && uidIndex <= indexRange.end)为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue'), true) : (console.info('if(uidIndex >= indexRange.start && uidIndex <= indexRange.end)为false,触发return,path: /renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue'), false);
                },
                getValidPageNum: function (e) {
                    if (console.info('对象函数 getValidPageNum(pageNum)', e, 'filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue'), e <= 1) {
                        return console.info('if(pageNum <= 1)为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue'), 1;
                    }
                    var t = this.getIndexRangeByPageNum(e), s = 0;
                    return this.remoteStuInfo.forEach(function (e, o) {
                        o >= t.start && o <= t.end && s++;
                    }), s > 0 ? (console.info('if(pageRangeCount > 0)为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue'), e) : this.getValidPageNum(e - 1);
                },
                collectiveSpeechOpen: function () {
                    var e = this;
                    return Object(A.a)(Object(P.a)().mark(function t() {
                        var s;
                        return Object(P.a)().wrap(function (t) {
                            while (1) {
                                switch (t.prev = t.next) {
                                    case 0:
                                        console.info('对象函数 collectiveSpeechOpen,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue'), s = e.getSpeakStudentList(), s.forEach(function (t) {
                                            e.rtcClass.muteRemoteAudio(t, false);
                                        }), e.videoGroup.sendLogger('拉取远端学生音频流, 远端学生列表: '.concat(JSON.stringify(s)));
                                    case 4:
                                    case 'end':
                                        return t.stop();
                                }
                            }
                        }, t);
                    }))();
                },
                collectiveSpeechClose: function () {
                    var e = this;
                    console.info('对象函数 collectiveSpeechClose,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue');
                    var t = this.getSpeakStudentList();
                    t.forEach(function (t) {
                        e.rtcClass.muteRemoteAudio(t, true);
                    });
                },
                getSpeakStudentList: function () {
                    console.info('对象函数 getSpeakStudentList,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/smallClass.vue');
                    var e, t = [], s = Object(za.a)(this.classStudentMap.keys());
                    try {
                        for (s.s(); !(e = s.n()).done;) {
                            var o = e.value;
                            t.push(o);
                        }
                    } catch (a) {
                        s.e(a);
                    } finally {
                        s.f();
                    }
                    return t;
                }
            }
        }, tn = en, sn = (s('f813'), Object(Ae.a)(tn, Ka, qa, false, null, '0bc5e710', null)), on = sn.exports, an = s('34bb'), nn = {
            components: {
                LargeClass: Wa,
                SmallClass: on
            },
            props: {
                options: {
                    type: Object,
                    default: null
                },
                stuInfo: {
                    type: Object,
                    default: null
                },
                rtcConfig: {
                    type: Object,
                    default: null
                }
            },
            data: function () {
                return {
                    blurTimer: null,
                    isWindowBlur: null,
                    startTime: '',
                    endTime: ''
                };
            },
            computed: {
                classType: function () {
                    return console.info('对象函数 classType,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/index.vue'), this.options.classType;
                }
            },
            mounted: function () {
                this.windowBlur();
            },
            methods: {
                windowBlur: function () {
                    console.info('对象函数 windowBlur,filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/index.vue');
                    var e = this.options, t = (e.commonOption, e.configs), s = e.planInfo;
                    this.options.isParent || this.options.isAudition ? console.info('if(this.options.isParent || this.options.isAudition)为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/videoGroup/index.vue') : this.focusHandler({
                        studentId: this.stuInfo.id,
                        tutorIrcId: t.tutorIrcId,
                        planId: s.id
                    });
                },
                focusHandler: function (e) {
                    var t = this, s = e.studentId, o = e.tutorIrcId, a = e.planId;
                    console.info('对象函数 focusHandler(studentId, tutorIrcId, planId)', s, o, a, 'filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/index.vue');
                    an.ipcRenderer.on('window_blur', function (e, n) {
                        if (clearTimeout(t.blurTimer), t.isWindowBlur !== n) {
                            var r = n ? 5000 : 0, i = JSON.stringify({
                                type: '180',
                                isFunction: true,
                                msg: 'isBlur',
                                parameter: { isBlur: n }
                            });
                            t.blurTimer = setTimeout(function () {
                                window.ChatClient.PeerChatManager.sendPeerMessage([{ nickname: o }], i, wo.a.notice);
                                n ? t.startTime = new Date().getTime() : (t.endTime = new Date().getTime(), t.startTime && t.reportData({
                                    studentId: s,
                                    planId: a
                                }));
                                t.isWindowBlur = n;
                                L.a.send({
                                    tag: '开小差',
                                    content: i,
                                    tutorIrcId: o
                                });
                                Rs.a(n);
                            }, r);
                        } else {
                            console.info('if(_this.isWindowBlur === arg)为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/videoGroup/index.vue');
                        }
                    });
                },
                reportData: function (e) {
                    var t = this;
                    return Object(A.a)(Object(P.a)().mark(function s() {
                        var o, a, n, r, i;
                        return Object(P.a)().wrap(function (s) {
                            while (1) {
                                switch (s.prev = s.next) {
                                    case 0:
                                        return o = e.studentId, a = e.planId, console.info('对象函数 reportData(studentId, planId)', o, a, 'filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/index.vue'), n = t.startTime, r = t.endTime, i = parseInt((r - n) / 1000), s.next = 7, Object(Q.k)({
                                            planId: a,
                                            studentId: o,
                                            duration: i,
                                            startTime: n,
                                            endTime: r
                                        }).catch(function (e) {
                                            console.info('箭头函数 notFocusedPush的catch(err)', e, 'filePath:renderer/components/Classroom/LargeClass/base/room/videoGroup/index.vue');
                                            L.a.send({
                                                tag: '开小差',
                                                content: { msg: '状态上报接口报错'.concat(JSON.stringify(e)) },
                                                level: 'error'
                                            });
                                        });
                                    case 7:
                                    case 'end':
                                        return s.stop();
                                }
                            }
                        }, s);
                    }))();
                }
            }
        }, rn = nn, cn = Object(Ae.a)(rn, sa, oa, false, null, null, null), ln = cn.exports, un = function () {
            var e = this, t = e._self._c;
            return t('div', {
                ref: 'controller',
                staticClass: 'controller-container'
            }, [
                t('div', {
                    ref: 'controllerBox',
                    staticClass: 'controller-box'
                }, [
                    t('div', { staticClass: 'time-area' }, [e._v(' ' + e._s(e._f('formatSeconds')(e.curTime)) + '/' + e._s(e._f('formatSeconds')(e.planInfo.etime - e.planInfo.stime)) + ' ')]),
                    t('div', { staticClass: 'infrastructure-box' }, [t('RaiseHand', { attrs: { options: e.options } })], 1)
                ]),
                t('ClassInfoDataReport', {
                    attrs: {
                        moduleInfo: e.moduleInfo,
                        planInfo: e.planInfo,
                        options: e.options
                    }
                })
            ], 1);
        }, dn = [], mn = (s('b7ef'), s('e6cf'), s('466d'), function (e) {
            if (e < 0) {
                return console.info('if(value < 0)为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/utils/index.js'), '00:00:00';
            }
            var t = parseInt(e), s = 0, o = 0;
            return t > 60 && (s = parseInt(t / 60), t = parseInt(t % 60), s > 60 && (o = parseInt(s / 60), s = parseInt(s % 60))), ''.concat(parseInt(o) > 9 ? parseInt(o) : '0' + parseInt(o), ':').concat(parseInt(s) > 9 ? parseInt(s) : '0' + parseInt(s), ':').concat(parseInt(t) > 9 ? parseInt(t) : '0' + parseInt(t));
        }), hn = function () {
            var e = this, t = e._self._c;
            return e.classType ? t('div', { staticClass: 'raiseHand' }, [
                e.showRaiseHand ? t('div', {
                    staticClass: 'raiseHand-btn',
                    class: { disabled: e.disabled },
                    on: { click: e.handleRaiseHand }
                }, [
                    t('i'),
                    t('div', { staticClass: 'raiseHand-name' }, [e._v(' ' + e._s(e.$t('classroom.largeClass.raiseHand.buttonName')) + ' ')])
                ]) : t('div', { staticClass: 'countdown' }, [
                    t('span', { staticClass: 'show-time' }, [e._v(e._s(e.countdownTime) + 's')]),
                    t('a-progress', {
                        attrs: {
                            percent: e.percent,
                            strokeWidth: 20,
                            showInfo: false,
                            strokeLinecap: 'square',
                            strokeColor: {
                                from: 'rgba(255, 213, 24, 1)',
                                to: 'rgba(255, 170, 10, 1)'
                            }
                        }
                    })
                ], 1),
                !e.multVideoLinkStatus || e.disabled || e.fiveEnd ? e._e() : t('div', { staticClass: 'raiseHand-tips' })
            ]) : e._e();
        }, pn = [], fn = {
            props: {
                options: {
                    type: Object,
                    default: function () {
                    }
                }
            },
            data: function () {
                return {
                    showRaiseHand: true,
                    countdownTime: 10,
                    progressTime: 100,
                    percent: 0,
                    disabled: false,
                    teacherType: 'tutor',
                    fiveEnd: false,
                    cameraStatus: null,
                    microphoneStatus: null,
                    multVideoLinkStatus: false
                };
            },
            computed: {
                classType: function () {
                    return console.info('对象函数 classType,filePath:renderer/components/Classroom/LargeClass/base/room/controller/components/raiseHand/index.vue'), this.options.classType;
                }
            },
            watch: {
                multVideoLinkStatus: function (e) {
                    var t = this;
                    e ? setTimeout(function () {
                        t.fiveEnd = true;
                    }, 5000) : this.fiveEnd = false;
                }
            },
            mounted: function () {
                var e = this;
                this.$bus.$on('raiseHandForMultVideoLink', function (t) {
                    console.info('箭头函数 监听 raiseHandForMultVideoLink(status)', t, 'filePath:renderer/components/Classroom/LargeClass/base/room/controller/components/raiseHand/index.vue');
                    e.multVideoLinkStatus = t;
                });
                this.$bus.$on('raiseHandDisabled', function (t) {
                    console.info('箭头函数 监听 raiseHandDisabled(status)', t, 'filePath:renderer/components/Classroom/LargeClass/base/room/controller/components/raiseHand/index.vue');
                    e.disabled = !!t;
                });
                this.$bus.$on('updateLocalDisplayVideoStatus', function (t) {
                    console.info('箭头函数 监听 updateLocalDisplayVideoStatus(status)', t, 'filePath:renderer/components/Classroom/LargeClass/base/room/controller/components/raiseHand/index.vue');
                    e.cameraStatus = t;
                });
                this.$bus.$on('updateMicrophoneStatus', function (t) {
                    console.info('箭头函数 监听 updateMicrophoneStatus(status)', t, 'filePath:renderer/components/Classroom/LargeClass/base/room/controller/components/raiseHand/index.vue');
                    e.microphoneStatus = t;
                });
                this.$bus.$on('raiseHandSendMessageToTeacher', function (t) {
                    var s = t.type;
                    console.info('箭头函数 监听 raiseHandSendMessageToTeacher(type)', s, 'filePath:renderer/components/Classroom/LargeClass/base/room/controller/components/raiseHand/index.vue');
                    e.sendPeerMessageToTeacher({ type: s });
                });
            },
            methods: {
                handleRaiseHand: function () {
                    console.info('对象函数 handleRaiseHand,filePath:renderer/components/Classroom/LargeClass/base/room/controller/components/raiseHand/index.vue');
                    this.showRaiseHand = false;
                    this.setCountdown();
                    this.setProgressPercent();
                    this.sendPeerMessage();
                    this.sendLogger('学员举手');
                },
                sendPeerMessage: function () {
                    console.info('对象函数 sendPeerMessage,filePath:renderer/components/Classroom/LargeClass/base/room/controller/components/raiseHand/index.vue');
                    this.sendPeerMessageToTour();
                    this.multVideoLinkStatus && this.sendPeerMessageToTeacher({ type: 125 });
                },
                sendPeerMessageToTour: function () {
                    var e = this;
                    return Object(A.a)(Object(P.a)().mark(function t() {
                        var s, o, a;
                        return Object(P.a)().wrap(function (t) {
                            while (1) {
                                switch (t.prev = t.next) {
                                    case 0:
                                        return console.info('对象函数 sendPeerMessageToTour,filePath:renderer/components/Classroom/LargeClass/base/room/controller/components/raiseHand/index.vue'), t.next = 3, Object(Y.f)();
                                    case 3:
                                        return s = t.sent, t.next = 6, te.nativeApi.getDeviceInfo();
                                    case 6:
                                        o = t.sent, a = {
                                            type: 160,
                                            msg: 'raiseHand',
                                            parameter: {
                                                schoolCode: s,
                                                planId: e.options.planId,
                                                roomId: e.options.classId,
                                                studentId: e.options.stuIRCId,
                                                uid: e.options.stuId,
                                                teacherId: e.options.teacherInfo.id,
                                                teacherName: e.options.teacherInfo.name,
                                                startTime: e.options.stime,
                                                currenTime: new Date().getTime(),
                                                device: o.platform,
                                                deviceVersion: o.osVersion,
                                                AppVersion: o.appVersion
                                            }
                                        }, window.ChatClient.PeerChatManager.sendPeerMessage([{ nickname: e.options.configs.tutorIrcId }], JSON.stringify(a), wo.a.notice);
                                    case 9:
                                    case 'end':
                                        return t.stop();
                                }
                            }
                        }, t);
                    }))();
                },
                sendPeerMessageToTeacher: function (e) {
                    var t = e.type;
                    console.info('对象函数 sendPeerMessageToTeacher(type)', t, 'filePath:renderer/components/Classroom/LargeClass/base/room/controller/components/raiseHand/index.vue');
                    var s = {
                        type: t || 125,
                        status: 6,
                        stuId: this.options.stuId,
                        cameraIsOpen: this.cameraStatus ? 1 : 2,
                        mikeAvailable: this.microphoneStatus ? 1 : 2
                    };
                    window.ChatClient.PeerChatManager.sendPeerMessage([{ nickname: this.options.configs.teacherIrcId }], JSON.stringify(s), wo.a.notice);
                },
                setProgressPercent: function () {
                    var e = this;
                    if (console.info('对象函数 setProgressPercent,filePath:renderer/components/Classroom/LargeClass/base/room/controller/components/raiseHand/index.vue'), this.progressTime <= 0) {
                        return console.info('if(this.progressTime <= 0)为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/controller/components/raiseHand/index.vue'), this.progressTime = 100;
                    }
                    this.progressTime--;
                    this.percent = this.calcProgressPercent(100, this.progressTime);
                    var t = setTimeout(function () {
                        e.setProgressPercent();
                        clearTimeout(t);
                        t = null;
                    }, 100);
                },
                setCountdown: function () {
                    var e = this;
                    if (console.info('对象函数 setCountdown,filePath:renderer/components/Classroom/LargeClass/base/room/controller/components/raiseHand/index.vue'), this.countdownTime <= 0) {
                        return console.info('if(this.countdownTime <= 0)为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/controller/components/raiseHand/index.vue'), this.countdownTime = 10, void (this.showRaiseHand = true);
                    }
                    this.countdownTime--;
                    var t = setTimeout(function () {
                        e.setCountdown();
                        clearTimeout(t);
                        t = null;
                    }, 1000);
                },
                calcProgressPercent: function (e, t) {
                    if (console.info('对象函数 calcProgressPercent(total, completed)', e, t, 'filePath:renderer/components/Classroom/LargeClass/base/room/controller/components/raiseHand/index.vue'), e = parseInt(e, 10), t = parseInt(t, 10), 0 === e || 0 === t) {
                        return console.info('if(total === 0 || completed === 0)为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/controller/components/raiseHand/index.vue'), 0;
                    }
                    var s = (e - t) / e * 100;
                    return parseFloat(s.toFixed(2));
                },
                sendLogger: function (e) {
                    var t = arguments.length > 1 && void 0 !== arguments[1] ? arguments[1] : '';
                    L.a.send({
                        tag: 'student.Interact',
                        content: {
                            msg: e,
                            interactType: 'stu_handsup',
                            interactId: '',
                            interactStage: t
                        }
                    });
                }
            }
        }, vn = fn, gn = (s('db90'), Object(Ae.a)(vn, hn, pn, false, null, '785ce806', null)), Cn = gn.exports, bn = s('1651'), Sn = (bn.a, function () {
            var e = this, t = e._self._c;
            return t('div');
        }), wn = [], yn = {
            props: {
                options: {
                    type: Object,
                    default: null
                },
                moduleInfo: {
                    type: Object,
                    default: null
                },
                planInfo: {
                    type: Object,
                    default: null
                }
            },
            data: function () {
                return {
                    durationTimestamp: new Date().getTime(),
                    durationModuleInfo: this.moduleInfo['11'] || null,
                    timer: null,
                    kejianStatus: 1,
                    ircCodeCount: {
                        0: 0,
                        1: 0,
                        2: 0,
                        3: 0,
                        4: 0,
                        5: 0
                    },
                    ircCurrentCode: 0,
                    rtcRoundTripDelayed: 0,
                    rtcDownlinkPacketLossRate: 0,
                    cameraStatus: 1
                };
            },
            mounted: function () {
                this.initEventListeners();
                this.delayDurationPush();
            },
            methods: {
                initEventListeners: function () {
                    var e = this;
                    console.info('对象函数 initEventListeners,filePath:renderer/components/Classroom/LargeClass/base/room/controller/components/classInfoDataReport/index.vue');
                    this.$bus.$on('corewareLoadStatus', function (t) {
                        console.info('箭头函数 监听 corewareLoadStatus(data)', t, 'filePath:renderer/components/Classroom/LargeClass/base/room/controller/components/classInfoDataReport/index.vue');
                        e.kejianStatus = t.isLocal ? 1 : 2;
                    });
                    this.$bus.$on('ircConnectStatus', function (t) {
                        console.info('箭头函数 监听 ircConnectStatus(data)', t, 'filePath:renderer/components/Classroom/LargeClass/base/room/controller/components/classInfoDataReport/index.vue');
                        e.ircCodeCount[t] = e.ircCodeCount[t] + 1;
                        e.ircCurrentCode = t;
                    });
                    this.$bus.$on('teacherRtcChannelStats', function (t) {
                        console.info('箭头函数 监听 teacherRtcChannelStats(data)', t, 'filePath:renderer/components/Classroom/LargeClass/base/room/controller/components/classInfoDataReport/index.vue');
                        e.rtcRoundTripDelayed = t.gatewayRtt;
                        e.rtcDownlinkPacketLossRate = t.rxPacketLossRate;
                    });
                    this.$bus.$on('updateLocalDisplayVideoStatus', function (t) {
                        console.info('箭头函数 监听 updateLocalDisplayVideoStatus(status)', t, 'filePath:renderer/components/Classroom/LargeClass/base/room/controller/components/classInfoDataReport/index.vue');
                        e.cameraStatus = t ? 1 : 2;
                    });
                },
                durationPush: function () {
                    var e = this;
                    return Object(A.a)(Object(P.a)().mark(function t() {
                        var s, o, a;
                        return Object(P.a)().wrap(function (t) {
                            while (1) {
                                switch (t.prev = t.next) {
                                    case 0:
                                        return console.info('对象函数 durationPush,filePath:renderer/components/Classroom/LargeClass/base/room/controller/components/classInfoDataReport/index.vue'), s = String(e.planInfo.id), o = 60000, a = 60, e.durationTimestamp = new Date().getTime(), t.next = 7, Object(Q.c)({
                                            planId: s,
                                            duration: a,
                                            isParentAudition: e.options.isParent ? 1 : 0,
                                            kejianStatus: e.kejianStatus,
                                            ircCodeCount: e.ircCodeCount,
                                            ircCurrentCode: e.ircCurrentCode,
                                            rtcRoundTripDelayed: e.rtcRoundTripDelayed,
                                            rtcDownlinkPacketLossRate: e.rtcDownlinkPacketLossRate,
                                            cameraState: e.cameraStatus
                                        });
                                    case 7:
                                        e.delayDurationPush(o);
                                    case 8:
                                    case 'end':
                                        return t.stop();
                                }
                            }
                        }, t);
                    }))();
                },
                delayDurationPush: function (e) {
                    var t = this;
                    console.info('对象函数 delayDurationPush(interval)', e, 'filePath:renderer/components/Classroom/LargeClass/base/room/controller/components/classInfoDataReport/index.vue');
                    this.resetPrevMinuteReportData();
                    this.timer && clearTimeout(this.timer);
                    this.timer = setTimeout(function () {
                        t.durationPush();
                    }, e);
                },
                resetPrevMinuteReportData: function () {
                    console.info('对象函数 resetPrevMinuteReportData,filePath:renderer/components/Classroom/LargeClass/base/room/controller/components/classInfoDataReport/index.vue');
                    this.ircCodeCount = {
                        0: 0,
                        1: 0,
                        2: 0,
                        3: 0,
                        4: 0,
                        5: 0
                    };
                    this.kejianStatus = 1;
                    this.rtcRoundTripDelayed = 0;
                    this.rtcDownlinkPacketLossRate = 0;
                    this.ircCurrentCode = 0;
                }
            }
        }, Pn = yn, An = Object(Ae.a)(Pn, Sn, wn, false, null, null, null), kn = An.exports, Ln = (s('2ef0e'), {
            components: {
                RaiseHand: Cn,
                ClassInfoDataReport: kn
            },
            filters: {
                timer: function (e) {
                    if (console.info('对象函数 timer(value)', e, 'filePath:renderer/components/Classroom/LargeClass/base/room/controller/live/controller.vue'), !e) {
                        return console.info('if(!value)为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/controller/live/controller.vue'), '00:00:00';
                    }
                    e = parseInt(e);
                    var t = Math.floor(e / 3600), s = Math.floor(e % 3600 / 60), o = e % 60;
                    return (t >= 10 ? t : '0' + t) + ':' + (s >= 10 ? s : '0' + s) + ':' + (o >= 10 ? o : '0' + o);
                },
                formatSeconds: mn
            },
            props: {
                options: {
                    type: Object,
                    default: null
                },
                moduleInfo: {
                    type: Object,
                    default: null
                },
                planInfo: {
                    type: Object,
                    default: null
                },
                isPlayBack: {
                    type: Number,
                    default: 0
                }
            },
            data: function () {
                return { curTime: 0 };
            },
            mounted: function () {
                this.options;
                this.moduleInfo;
                this.planInfo;
                this.init();
            },
            methods: {
                init: function () {
                    var e = this;
                    return Object(A.a)(Object(P.a)().mark(function t() {
                        return Object(P.a)().wrap(function (t) {
                            while (1) {
                                switch (t.prev = t.next) {
                                    case 0:
                                        console.info('对象函数 init,filePath:renderer/components/Classroom/LargeClass/base/room/controller/live/controller.vue'), e.startTime();
                                    case 2:
                                    case 'end':
                                        return t.stop();
                                }
                            }
                        }, t);
                    }))();
                },
                startTime: function () {
                    var e = this;
                    console.info('对象函数 startTime,filePath:renderer/components/Classroom/LargeClass/base/room/controller/live/controller.vue');
                    setInterval(function () {
                        e.curTime = new Date().getTime() / 1000 - e.planInfo.stime;
                    }, 1000);
                }
            }
        }), In = Ln, xn = (s('bf00'), Object(Ae.a)(In, un, dn, false, null, '6442ac90', null)), On = xn.exports, jn = function () {
            var e = this, t = e._self._c;
            return t('div', [
                t('CountDown', { attrs: { options: e.options } }),
                t('OrientationCoins', { attrs: { options: e.options } }),
                t('ContinuousCorrect', { attrs: { options: e.options } }),
                t('ClassPraise', { attrs: { options: e.options } }),
                t('LiveKickout', { attrs: { options: e.options } }),
                t('TutorVideoLink', {
                    attrs: {
                        options: e.options,
                        stuInfo: e.stuInfo,
                        rtcConfig: e.rtcConfig
                    }
                }),
                t('SmallClassRank', { attrs: { options: e.options } }),
                t('DeviceTest'),
                t('SmallClassGraffitiCorrect'),
                t('TeacherOnStage', {
                    attrs: {
                        options: e.options,
                        rtcConfig: e.rtcConfig
                    }
                })
            ], 1);
        }, Tn = [], Mn = s('d9de'), Rn = s('cab4'), En = s('ac6d'), Vn = s('6c5d'), Nn = function () {
            var e = this, t = e._self._c;
            return e.isShowLink ? t('div', { staticClass: 'tutor-video-link-wrapper' }, [
                t('div', {
                    staticClass: 'tutor-video',
                    class: {
                        error: e.isError,
                        normal: !e.isError
                    }
                }, [
                    t('div', {
                        directives: [{
                            name: 'show',
                            rawName: 'v-show',
                            value: !e.isError,
                            expression: '!isError'
                        }],
                        staticClass: 'tutor-video-container'
                    }, [t('div', { attrs: { id: e.tutorId } })]),
                    e.isError ? t('div', { staticClass: 'icon-error' }) : e._e()
                ]),
                t('div', { staticClass: 'title-bar' }, [
                    t('div', { staticClass: 'dot' }),
                    t('div', { staticClass: 'title' }, [e._v(' ' + e._s(e.$t('classroom.modules.tutorVideoLink.title')) + ' ')])
                ]),
                t('div', { staticClass: 'video-link-info' }, [e.isError ? t('div', { staticClass: 'tutor-video-error' }, [
                    t('div', { staticClass: 'notice' }, [
                        e._v(' ' + e._s(e.$t('classroom.modules.tutorVideoLink.errorMsg')[0])),
                        t('br'),
                        e._v(' ' + e._s(e.$t('classroom.modules.tutorVideoLink.errorMsg')[1]) + ' ')
                    ]),
                    t('div', {
                        staticClass: 'button',
                        on: { click: e.handleExit }
                    }, [e._v(' ' + e._s(e.$t('common.exit')) + ' ')])
                ]) : t('div', [
                    t('div', { staticClass: 'avatar-info' }, [
                        t('div', {
                            staticClass: 'avatar-tutor',
                            class: { 'default-avatar': !e.tutorAvatarUrl }
                        }, [e.tutorAvatarUrl ? t('img', { attrs: { src: e.tutorAvatarUrl } }) : e._e()]),
                        t('div', { staticClass: 'icon-vocal-print' }),
                        t('div', { staticClass: 'avatar-student' }, [t('img', { attrs: { src: e.studentAvatarUrl } })])
                    ]),
                    t('div', { staticClass: 'link-time' }, [e._v(e._s(e.formatTime))])
                ])])
            ]) : e._e();
        }, Dn = [], Bn = function () {
            function e() {
                var t = arguments.length > 0 && void 0 !== arguments[0] ? arguments[0] : {};
                console.info('函数申明 _default(opts)', t, 'filePath:renderer/components/Classroom/LargeClass/base/room/modules/tutorVideoLink/rtcClass.js');
                Object(g.a)(this, e);
                this.options = t.options;
                this.rtcConfig = t.rtcConfig;
                this.teacherAudioUid = this.rtcConfig.teacherAudioUid;
                this.tutorUid = this.options.counselorInfo.id;
                this.teacherRtcChannel = window.RTC_COMMON.teacherRtcChannel || null;
                this.classRtcChannel = window.RTC_COMMON.classRtcChannel || null;
            }
            return Object(C.a)(e, [
                {
                    key: 'tutorVideoLinkStart',
                    value: function (e) {
                        this.classRtcChannel.muteRemoteAudioStream(this.tutorUid, false);
                        this.classRtcChannel.muteRemoteVideoStream(this.tutorUid, false);
                        this.classRtcChannel.setupRemoteVideo(this.tutorUid, document.getElementById(e));
                    }
                },
                {
                    key: 'tutorVideoLinkEnd',
                    value: function () {
                        this.classRtcChannel.muteRemoteAudioStream(this.tutorUid, true);
                        this.classRtcChannel.muteRemoteVideoStream(this.tutorUid, true);
                        this.classRtcChannel.destroyRemoteVideo(this.tutorUid, document.getElementById(this.tutorUid));
                    }
                }
            ]), e;
        }(), Un = {
            props: {
                options: {
                    type: Object,
                    default: null
                },
                stuInfo: {
                    type: Object,
                    default: null
                },
                rtcConfig: {
                    type: Object,
                    default: null
                }
            },
            computed: {
                tutorId: function () {
                    return console.info('对象函数 tutorId,filePath:renderer/components/Classroom/LargeClass/base/room/modules/tutorVideoLink/index.vue'), 'remote-'.concat(this.options.counselorInfo.id);
                },
                tutorAvatarUrl: function () {
                    return console.info('对象函数 tutorAvatarUrl,filePath:renderer/components/Classroom/LargeClass/base/room/modules/tutorVideoLink/index.vue'), this.options.counselorInfo.avatar || '';
                },
                studentAvatarUrl: function () {
                    return console.info('对象函数 studentAvatarUrl,filePath:renderer/components/Classroom/LargeClass/base/room/modules/tutorVideoLink/index.vue'), this.stuInfo.avatar || '';
                },
                formatTime: function () {
                    console.info('对象函数 formatTime,filePath:renderer/components/Classroom/LargeClass/base/room/modules/tutorVideoLink/index.vue');
                    var e = this.timerCounter, t = Math.floor(e / 60), s = e % 60;
                    return ''.concat(Object(X.u)(t), ':').concat(Object(X.u)(s));
                }
            },
            data: function () {
                return {
                    isShowLink: false,
                    isError: false,
                    isFirstMsg: false,
                    status: 0,
                    callback: null,
                    timerCounter: 0,
                    timer: null,
                    highEncoderConfig: {
                        width: 320,
                        height: 240,
                        bitrate: 120,
                        frameRate: 10
                    },
                    lowEncoderConfig: {
                        bitrate: 80,
                        frameRate: 10,
                        width: 160,
                        height: 120
                    }
                };
            },
            mounted: function () {
                var e = this;
                this.$bus.$on('room.tutorVideoLink', function (t, s) {
                    console.info('箭头函数 监听 room.tutorVideoLink(noticeContent, callback)', t, s, 'filePath:renderer/components/Classroom/LargeClass/base/room/modules/tutorVideoLink/index.vue');
                    e.sendLogger('收到辅导连麦消息: '.concat(JSON.stringify(t)));
                    var o = t.studentId, a = t.status;
                    if (o == e.stuInfo.id) {
                        var n, r, i, c;
                        if (1 == a && (e.isFirstMsg = true), e.status = a, e.callback = s, e.isFirstMsg && 2 == a) {
                            null === (n = window.RTC_COMMON) || void 0 === n || null === (r = n.classRtcChannel) || void 0 === r || r.setVideoEncoderConfiguration(e.highEncoderConfig);
                            e.startLink();
                            Rs.o('', 'guiding_teacher', true);
                        }
                        if (e.isFirstMsg && 3 == a) {
                            null === (i = window.RTC_COMMON) || void 0 === i || null === (c = i.classRtcChannel) || void 0 === c || c.setVideoEncoderConfiguration(e.lowEncoderConfig);
                            e.endLink();
                            Rs.o('', 'guiding_teacher', false);
                        }
                    } else {
                        console.info('if(studentId != _this.stuInfo.id)为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/modules/tutorVideoLink/index.vue');
                    }
                });
            },
            methods: {
                startLink: function () {
                    var e = this;
                    console.info('对象函数 startLink,filePath:renderer/components/Classroom/LargeClass/base/room/modules/tutorVideoLink/index.vue');
                    this.isShowLink = true;
                    this.isError = false;
                    this.timerCounter = 0;
                    this.rtcClass = new Bn({
                        options: this.options,
                        rtcConfig: this.rtcConfig
                    });
                    this.addEventListen();
                    this.$nextTick(function () {
                        e.$bus.$emit('player.muteTeacherChannelAudio', true);
                        e.rtcClass.tutorVideoLinkStart(e.tutorId);
                        e.callback && e.callback({ status: true });
                        e.startTimerCounter();
                        e.sendLogger('开始辅导连麦', 'start');
                    });
                },
                endLink: function () {
                    console.info('对象函数 endLink,filePath:renderer/components/Classroom/LargeClass/base/room/modules/tutorVideoLink/index.vue');
                    this.$bus.$emit('player.muteTeacherChannelAudio', false);
                    this.rtcClass.tutorVideoLinkEnd();
                    this.removeEventListen();
                    this.startTimerCounter();
                    this.isShowLink = false;
                    this.isError = false;
                    this.isFirstMsg = false;
                    this.status = 0;
                    this.callback && this.callback({ status: false });
                    this.callback = null;
                    this.sendLogger('结束辅导连麦', 'end');
                },
                addEventListen: function () {
                    console.info('对象函数 addEventListen,filePath:renderer/components/Classroom/LargeClass/base/room/modules/tutorVideoLink/index.vue');
                    this.rtcClass.classRtcChannel.on('remoteVideoStateChanged', this.listenRemoteVideoStateChanged);
                    this.rtcClass.classRtcChannel.on('connectionStateChanged', this.listenConnectionStateChanged);
                },
                removeEventListen: function () {
                    console.info('对象函数 removeEventListen,filePath:renderer/components/Classroom/LargeClass/base/room/modules/tutorVideoLink/index.vue');
                    this.rtcClass.classRtcChannel.off('remoteVideoStateChanged', this.listenRemoteVideoStateChanged);
                    this.rtcClass.classRtcChannel.off('connectionStateChanged', this.listenConnectionStateChanged);
                },
                listenRemoteVideoStateChanged: function (e, t, s) {
                    console.info('对象函数 listenRemoteVideoStateChanged(uid, state, reason)', e, t, s, 'filePath:renderer/components/Classroom/LargeClass/base/room/modules/tutorVideoLink/index.vue');
                    var o = this.options.counselorInfo.id;
                    e == o && (0 == t && 5 == s && (this.isError = true, this.sendLogger('视频显示失败')), 0 == t && 7 == s && this.endLink(), 2 == t && (this.isError = false, this.sendLogger('视频显示成功')));
                },
                listenConnectionStateChanged: function (e, t) {
                    console.info('对象函数 listenConnectionStateChanged(state, reason)', e, t, 'filePath:renderer/components/Classroom/LargeClass/base/room/modules/tutorVideoLink/index.vue');
                    1 !== e && 4 !== e && 5 !== e || (this.isError = true);
                    3 === e && (this.isError = false);
                },
                handleExit: function () {
                    console.info('对象函数 handleExit,filePath:renderer/components/Classroom/LargeClass/base/room/modules/tutorVideoLink/index.vue');
                    this.endLink();
                    this.sendLogger('学生点击Exit按钮, 主动退出辅导连麦');
                },
                startTimerCounter: function () {
                    var e = this;
                    console.info('对象函数 startTimerCounter,filePath:renderer/components/Classroom/LargeClass/base/room/modules/tutorVideoLink/index.vue');
                    this.timer && clearTimeout(this.timer);
                    this.timer = setTimeout(function () {
                        ++e.timerCounter;
                        e.startTimerCounter();
                    }, 1000);
                },
                endTimerCounter: function () {
                    console.info('对象函数 endTimerCounter,filePath:renderer/components/Classroom/LargeClass/base/room/modules/tutorVideoLink/index.vue');
                    clearTimeout(this.timer);
                    this.timer = null;
                    this.timerCounter = 0;
                },
                sendLogger: function (e) {
                    var t = arguments.length > 1 && void 0 !== arguments[1] ? arguments[1] : '';
                    L.a.send({
                        tag: 'student.Interact',
                        content: {
                            msg: e,
                            interactType: 'TutorLinkMic',
                            interactStage: t
                        }
                    });
                }
            }
        }, Gn = Un, Hn = (s('ffa1'), Object(Ae.a)(Gn, Nn, Dn, false, null, 'af963950', null)), _n = Hn.exports, Fn = s('e99b'), Wn = function () {
            var e = this, t = e._self._c;
            return t('a-modal', {
                attrs: {
                    width: 400,
                    maskClosable: false,
                    closable: false,
                    centered: true,
                    title: e.$t('classroom.modules.deviceTest.dialogTitle'),
                    dialogClass: 'modal-simple',
                    okText: e.$t('common.confirm'),
                    cancelText: e.$t('common.cancel')
                },
                on: { ok: e.handleOk },
                model: {
                    value: e.visible,
                    callback: function (t) {
                        e.visible = t;
                    },
                    expression: 'visible'
                }
            }, [t('div', { staticClass: 'modal-device-test' }, [
                t('div', { staticClass: 'device-item' }, [
                    t('div', { staticClass: 'device-head' }, [
                        t('div', { staticClass: 'title' }, [
                            t('span', { staticClass: 'color-gray' }, [e._v(' ' + e._s(e.$t('classroom.modules.deviceTest.cameraTitle')) + ' ')]),
                            e._v(' ' + e._s(e.cameraStatusInfo.text) + ' ')
                        ]),
                        t('div', {
                            staticClass: 'icon',
                            class: e.cameraStatusInfo.className
                        })
                    ]),
                    t('a-select', {
                        staticStyle: { width: '340px' },
                        attrs: {
                            value: e.defaultVideoDeviceId,
                            'default-value': e.defaultVideoDeviceId,
                            suffixIcon: e.suffixIcon
                        },
                        on: { change: e.handleChangeVideoDevice },
                        scopedSlots: e._u([{
                            key: 'suffixIcon',
                            fn: function () {
                                return [t('a-icon', { attrs: { component: e.arrowBottomSvg } })];
                            },
                            proxy: true
                        }])
                    }, e._l(e.videoDevices, function (s, o) {
                        return t('a-select-option', {
                            key: o,
                            attrs: { value: s.deviceid }
                        }, [e._v(' ' + e._s(s.devicename) + ' ')]);
                    }), 1),
                    e.isMac && false === e.cameraStatus ? t('div', { staticClass: 'authorize-guide' }, [
                        e._v(' ' + e._s(e.$t('classroom.modules.deviceTest.authorizeGuide')[0]) + ' '),
                        t('span', { on: { click: e.handleCameraAccess } }, [e._v(' ' + e._s(e.$t('classroom.modules.deviceTest.authorizeGuide')[1]) + ' ')])
                    ]) : e._e()
                ], 1),
                t('div', { staticClass: 'device-item' }, [
                    t('div', { staticClass: 'device-head' }, [
                        t('div', { staticClass: 'title' }, [
                            t('span', { staticClass: 'color-gray' }, [e._v(' ' + e._s(e.$t('classroom.modules.deviceTest.microphoneTitle')) + ' ')]),
                            e._v(' ' + e._s(e.microphoneStatusInfo.text) + ' ')
                        ]),
                        t('div', {
                            staticClass: 'icon',
                            class: e.microphoneStatusInfo.className
                        })
                    ]),
                    t('a-select', {
                        staticStyle: { width: '340px' },
                        attrs: {
                            value: e.defaultAudioRecordingDeviceId,
                            'default-value': e.defaultAudioRecordingDeviceId,
                            suffixIcon: e.suffixIcon
                        },
                        on: { change: e.handleChangeAudioRecordingDevice },
                        scopedSlots: e._u([{
                            key: 'suffixIcon',
                            fn: function () {
                                return [t('a-icon', { attrs: { component: e.arrowBottomSvg } })];
                            },
                            proxy: true
                        }])
                    }, e._l(e.audioRecordingDevices, function (s, o) {
                        return t('a-select-option', {
                            key: o,
                            attrs: { value: s.deviceid }
                        }, [e._v(' ' + e._s(s.devicename) + ' ')]);
                    }), 1),
                    e.isMac && false === e.microphoneStatus ? t('div', { staticClass: 'authorize-guide' }, [
                        e._v(' ' + e._s(e.$t('classroom.modules.deviceTest.authorizeGuide')[0]) + ' '),
                        t('span', { on: { click: e.handleMicrophoneAccess } }, [e._v(' ' + e._s(e.$t('classroom.modules.deviceTest.authorizeGuide')[1]) + ' ')])
                    ]) : e._e()
                ], 1),
                t('div', { staticClass: 'device-item' }, [
                    t('div', { staticClass: 'device-head' }, [
                        t('div', { staticClass: 'title' }, [
                            t('span', { staticClass: 'color-gray' }, [e._v(' ' + e._s(e.$t('classroom.modules.deviceTest.audioTitle')) + ' ')]),
                            e._v(' ' + e._s(e.audioPlaybackStatusInfo.text) + ' ')
                        ]),
                        t('div', {
                            staticClass: 'icon',
                            class: e.audioPlaybackStatusInfo.className
                        })
                    ]),
                    t('a-select', {
                        staticStyle: { width: '340px' },
                        attrs: {
                            value: e.defaultAudioPlaybackDeviceId,
                            'default-value': e.defaultAudioPlaybackDeviceId,
                            suffixIcon: e.suffixIcon
                        },
                        on: { change: e.handleChangeAudioPlaybackDevice },
                        scopedSlots: e._u([{
                            key: 'suffixIcon',
                            fn: function () {
                                return [t('a-icon', { attrs: { component: e.arrowBottomSvg } })];
                            },
                            proxy: true
                        }])
                    }, e._l(e.audioPlaybackDevices, function (s, o) {
                        return t('a-select-option', {
                            key: o,
                            attrs: { value: s.deviceid }
                        }, [e._v(' ' + e._s(s.devicename) + ' ')]);
                    }), 1)
                ], 1)
            ])]);
        }, Kn = [], qn = s('ff07'), zn = s.n(qn), Jn = {
            data: function () {
                return {
                    isMac: Object(X.s)(),
                    arrowBottomSvg: zn.a,
                    visible: false,
                    rtcEngine: null,
                    videoDevices: [],
                    audioRecordingDevices: [],
                    audioPlaybackDevices: [],
                    defaultVideoDeviceId: '',
                    defaultAudioRecordingDeviceId: '',
                    defaultAudioPlaybackDeviceId: '',
                    cameraStatus: null,
                    microphoneStatus: null
                };
            },
            computed: {
                statusNames: function () {
                    return console.info('对象函数 statusNames,filePath:renderer/components/Classroom/LargeClass/base/room/modules/deviceTest/index.vue'), this.$t('classroom.modules.deviceTest.statusNames');
                },
                cameraStatusInfo: function () {
                    return console.info('对象函数 cameraStatusInfo,filePath:renderer/components/Classroom/LargeClass/base/room/modules/deviceTest/index.vue'), this.videoDevices.length ? true === this.cameraStatus ? (console.info('if(this.cameraStatus === true)为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/modules/deviceTest/index.vue'), {
                        className: 'icon-success',
                        text: this.statusNames.usable
                    }) : false === this.cameraStatus ? (console.info('if(this.cameraStatus === false)为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/modules/deviceTest/index.vue'), {
                        className: 'icon-warn',
                        text: this.statusNames.unauthorized
                    }) : (console.info('if(this.cameraStatus === false)为false,触发return,path: /renderer/components/Classroom/LargeClass/base/room/modules/deviceTest/index.vue'), {}) : (console.info('if(!this.videoDevices.length)为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/modules/deviceTest/index.vue'), {
                        className: 'icon-error',
                        text: this.statusNames.disabled
                    });
                },
                microphoneStatusInfo: function () {
                    return console.info('对象函数 microphoneStatusInfo,filePath:renderer/components/Classroom/LargeClass/base/room/modules/deviceTest/index.vue'), this.audioRecordingDevices.length ? true === this.microphoneStatus ? (console.info('if(this.microphoneStatus === true)为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/modules/deviceTest/index.vue'), {
                        className: 'icon-success',
                        text: this.statusNames.usable
                    }) : false === this.microphoneStatus ? (console.info('if(this.microphoneStatus === false)为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/modules/deviceTest/index.vue'), {
                        className: 'icon-warn',
                        text: this.statusNames.unauthorized
                    }) : (console.info('if(this.microphoneStatus === false)为false,触发return,path: /renderer/components/Classroom/LargeClass/base/room/modules/deviceTest/index.vue'), {}) : (console.info('if(!this.audioRecordingDevices.length)为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/modules/deviceTest/index.vue'), {
                        className: 'icon-error',
                        text: this.statusNames.disabled
                    });
                },
                audioPlaybackStatusInfo: function () {
                    return console.info('对象函数 audioPlaybackStatusInfo,filePath:renderer/components/Classroom/LargeClass/base/room/modules/deviceTest/index.vue'), this.audioPlaybackDevices.length ? (console.info('if(!this.audioPlaybackDevices.length)为false,触发return,path: /renderer/components/Classroom/LargeClass/base/room/modules/deviceTest/index.vue'), {
                        className: 'icon-success',
                        text: this.statusNames.usable
                    }) : (console.info('if(!this.audioPlaybackDevices.length)为true触发return,path: /renderer/components/Classroom/LargeClass/base/room/modules/deviceTest/index.vue'), {
                        className: 'icon-error',
                        text: this.statusNames.disabled
                    });
                }
            },
            mounted: function () {
                var e = this;
                this.$bus.$on('room.deviceTestShow', function () {
                    console.info('箭头函数 监听 room.deviceTestShow,filePath:renderer/components/Classroom/LargeClass/base/room/modules/deviceTest/index.vue');
                    e.sendLogger('点击打开设备检测弹窗');
                    e.showModal();
                });
            },
            methods: {
                showModal: function () {
                    console.info('对象函数 showModal,filePath:renderer/components/Classroom/LargeClass/base/room/modules/deviceTest/index.vue');
                    this.visible = true;
                    this.rtcEngine = window.RTC_COMMON.rtcEngine;
                    this.getDevices();
                    this.getDefaultDevices();
                    this.getMediaAccess();
                },
                hideModal: function () {
                    console.info('对象函数 hideModal,filePath:renderer/components/Classroom/LargeClass/base/room/modules/deviceTest/index.vue');
                    this.visible = false;
                },
                handleOk: function () {
                    var e = this;
                    return Object(A.a)(Object(P.a)().mark(function t() {
                        return Object(P.a)().wrap(function (t) {
                            while (1) {
                                switch (t.prev = t.next) {
                                    case 0:
                                        return console.info('对象函数 handleOk,filePath:renderer/components/Classroom/LargeClass/base/room/modules/deviceTest/index.vue'), t.next = 3, Object(wt.e)(e.defaultVideoDeviceId);
                                    case 3:
                                        return t.next = 5, Object(wt.d)(e.defaultAudioRecordingDeviceId);
                                    case 5:
                                        return t.next = 7, Object(wt.c)(e.defaultAudioPlaybackDeviceId);
                                    case 7:
                                        e.$bus.$emit('setDefaultVideoDevice', e.defaultVideoDeviceId), e.$bus.$emit('setDefaultAudioRecordingDevice', e.defaultAudioRecordingDeviceId), e.$bus.$emit('setDefaultAudioPlaybackDevice', e.defaultAudioPlaybackDeviceId), e.sendLogger('设置默认设备, 摄像头: '.concat(e.defaultVideoDeviceId, ', 麦克风: ').concat(e.defaultAudioRecordingDeviceId, ', 扬声器: ').concat(e.defaultAudioPlaybackDeviceId)), e.hideModal();
                                    case 12:
                                    case 'end':
                                        return t.stop();
                                }
                            }
                        }, t);
                    }))();
                },
                handleChangeVideoDevice: function (e) {
                    console.info('对象函数 handleChangeVideoDevice(val)', e, 'filePath:renderer/components/Classroom/LargeClass/base/room/modules/deviceTest/index.vue');
                    this.defaultVideoDeviceId = e;
                },
                handleChangeAudioRecordingDevice: function (e) {
                    console.info('对象函数 handleChangeAudioRecordingDevice(val)', e, 'filePath:renderer/components/Classroom/LargeClass/base/room/modules/deviceTest/index.vue');
                    this.defaultAudioRecordingDeviceId = e;
                },
                handleChangeAudioPlaybackDevice: function (e) {
                    console.info('对象函数 handleChangeAudioPlaybackDevice(val)', e, 'filePath:renderer/components/Classroom/LargeClass/base/room/modules/deviceTest/index.vue');
                    this.defaultAudioPlaybackDeviceId = e;
                },
                getDevices: function () {
                    console.info('对象函数 getDevices,filePath:renderer/components/Classroom/LargeClass/base/room/modules/deviceTest/index.vue');
                    var e = this.rtcEngine.getVideoDevices(), t = this.rtcEngine.getAudioRecordingDevices(), s = this.rtcEngine.getAudioPlaybackDevices();
                    this.videoDevices = e;
                    this.audioRecordingDevices = t;
                    this.audioPlaybackDevices = s;
                    this.sendLogger('查询设备列表, 摄像头: '.concat(JSON.stringify(e), ', 麦克风: ').concat(JSON.stringify(t), ', 扬声器: ').concat(JSON.stringify(s)));
                },
                getDefaultDevices: function () {
                    console.info('对象函数 getDefaultDevices,filePath:renderer/components/Classroom/LargeClass/base/room/modules/deviceTest/index.vue');
                    var e = this.rtcEngine.getCurrentVideoDevice(), t = this.rtcEngine.getCurrentAudioRecordingDevice(), s = this.rtcEngine.getCurrentAudioPlaybackDevice();
                    this.defaultVideoDeviceId = e;
                    this.defaultAudioRecordingDeviceId = t;
                    this.defaultAudioPlaybackDeviceId = s;
                    this.sendLogger('查询当前默认使用设备, 摄像头: '.concat(e, ', 麦克风: ').concat(t, ', 扬声器: ').concat(s));
                },
                getMediaAccess: function () {
                    var e = this;
                    return Object(A.a)(Object(P.a)().mark(function t() {
                        return Object(P.a)().wrap(function (t) {
                            while (1) {
                                switch (t.prev = t.next) {
                                    case 0:
                                        return console.info('对象函数 getMediaAccess,filePath:renderer/components/Classroom/LargeClass/base/room/modules/deviceTest/index.vue'), t.next = 3, Object($.c)();
                                    case 3:
                                        return e.cameraStatus = t.sent, t.next = 6, Object($.f)();
                                    case 6:
                                        e.microphoneStatus = t.sent, e.sendLogger('查询当前媒体权限\uFF0C摄像头\uFF1A'.concat(e.cameraStatus, ', 麦克风:').concat(e.microphoneStatus));
                                    case 8:
                                    case 'end':
                                        return t.stop();
                                }
                            }
                        }, t);
                    }))();
                },
                handleCameraAccess: function () {
                    console.info('对象函数 handleCameraAccess,filePath:renderer/components/Classroom/LargeClass/base/room/modules/deviceTest/index.vue');
                    this.sendLogger('点击打开摄像头权限设置');
                    te.nativeApi.openPreferences('security', 'camera');
                },
                handleMicrophoneAccess: function () {
                    console.info('对象函数 handleMicrophoneAccess,filePath:renderer/components/Classroom/LargeClass/base/room/modules/deviceTest/index.vue');
                    this.sendLogger('点击打开麦克风权限设置');
                    te.nativeApi.openPreferences('security', 'microphone');
                },
                sendLogger: function (e) {
                    L.a.send({
                        tag: 'deviceTest',
                        content: { msg: e }
                    });
                }
            }
        }, Qn = Jn, Zn = (s('bcf1'), Object(Ae.a)(Qn, Wn, Kn, false, null, '78fd127c', null)), Yn = Zn.exports, Xn = s('9f80'), $n = s('5f8e'), er = s('4a3d'), tr = {
            components: {
                CountDown: Mn.a,
                OrientationCoins: Rn.a,
                ContinuousCorrect: En.a,
                ClassPraise: Vn.a,
                TutorVideoLink: _n,
                DeviceTest: Yn,
                SmallClassRank: Fn.a,
                LiveKickout: Xn.a,
                SmallClassGraffitiCorrect: $n.a,
                TeacherOnStage: er.a
            },
            props: {
                options: {
                    type: Object,
                    default: null
                },
                stuInfo: {
                    type: Object,
                    default: null
                },
                rtcConfig: {
                    type: Object,
                    default: null
                }
            }
        }, sr = tr, or = Object(Ae.a)(sr, jn, Tn, false, null, null, null), ar = or.exports, nr = s('1c07');
        v.a.use(so.a);
        var rr = function (e) {
            Object(b.a)(s, e);
            var t = Object(S.a)(s);
            function s() {
                var e, o = arguments.length > 0 && void 0 !== arguments[0] ? arguments[0] : {};
                return console.info('函数申明 Room(options)', o, 'filePath:renderer/components/Classroom/LargeClass/base/room/live.js'), Object(g.a)(this, s), e = t.call(this), e.options = o, e.initRoom(), e;
            }
            return Object(C.a)(s, [
                {
                    key: 'initRoom',
                    value: function () {
                        this.options;
                        var e = this.options, t = e.videoGroupDom, s = e.controllerDom, o = e.headerDom, a = e.roomModulesDom;
                        this.videoGroup = this.init(t, ln);
                        this.controllerVm = this.init(s, On);
                        this.headerVm = this.init(o, ta);
                        this.roomModulesVm = this.init(a, ar);
                    }
                },
                {
                    key: 'init',
                    value: function (e, t) {
                        var s = this.createVueRoom(t);
                        return this.render(e, s), s;
                    }
                },
                {
                    key: 'createVueRoom',
                    value: function (e) {
                        var t = v.a.extend(e), s = null, o = this.createRoomProps();
                        return s = new t({
                            i18n: se.b,
                            propsData: o
                        }), s.$mount(), s;
                    }
                },
                {
                    key: 'createRoomProps',
                    value: function () {
                        this.options;
                        var e = this.options.roomMessage, t = e.moduleInfo, s = e.roomInfo, o = {
                            options: s.commonOption,
                            stuInfo: s.stuInfo,
                            moduleInfo: t,
                            planId: s.planInfo.id,
                            planName: s.planInfo.name,
                            skinType: s.configs.skinType,
                            isPlayBack: s.isPlayBack,
                            playerOptions: s.playerOptions,
                            planInfo: s.planInfo,
                            rtcConfig: s.configs.rtcConfig
                        };
                        return o;
                    }
                },
                {
                    key: 'eventHandler',
                    value: function (e) {
                    }
                }
            ]), s;
        }(nr.a), ir = s('8138'), cr = s('5e36'), lr = s('6ce8'), ur = function (e) {
            Object(b.a)(s, e);
            var t = Object(S.a)(s);
            function s() {
                var e;
                return console.info('函数申明 InteractionHandler, filePath:renderer/components/Classroom/LargeClass/base/interaction-handler/index.js'), Object(g.a)(this, s), e = t.call(this), e.options = null, e.isAudition = false, e.interactionList = wo.b, e.submit = false, e.tutorVideoLinkStatus = false, e.interactionMap = new Map(), e;
            }
            return Object(C.a)(s, [
                {
                    key: 'eventHandler',
                    value: function (e) {
                        var t = e.type, s = e.data, o = e.roomMessage;
                        this.options = o;
                        this.isAudition = o.roomInfo.commonOption.isAudition;
                        'onRecvRoomDataUpdateNotice' === t && this.handleRoomNotice(s);
                    }
                },
                {
                    key: 'handleRoomNotice',
                    value: function (e) {
                        var t = this;
                        if (e.datas) {
                            var s = !e.msgId;
                            e.datas.forEach(function () {
                                var e = Object(A.a)(Object(P.a)().mark(function e(o, a) {
                                    var n, r, i, c, l, u, d, m, h, p, f, g, C, b, S, w, y, A, k, I, x, O, j, T, M, R;
                                    return Object(P.a)().wrap(function (e) {
                                        while (1) {
                                            switch (e.prev = e.next) {
                                                case 0:
                                                    if (!t.isAudition || !cr.a.includes(a)) {
                                                        e.next = 3;
                                                        break;
                                                    }
                                                    return console.info('if(_this2.isAudition && ignoreRoomDataNotices.includes(key))为true触发return,path: /renderer/components/Classroom/LargeClass/base/interaction-handler/index.js'), e.abrupt('return');
                                                case 3:
                                                    if (r = JSON.parse(o.value), i = r[a] || r.data, c = r.sendTime, 'classmode' === a && Object(tt.b)(a, Object(Xs.a)({}, a, i)), !t.tutorVideoLinkStatus || 'video_mic' !== a && 'speech_interact' !== a && 'random_video_mic' !== a && 'mult_video_mic' !== a) {
                                                        e.next = 10;
                                                        break;
                                                    }
                                                    return console.info('if(_this2.tutorVideoLinkStatus && (key === \'video_mic\' || key === \'speech_interact\' || key === \'random_video_mic\' || key === \'mult_video_mic\'))为true触发return,path: /renderer/components/Classroom/LargeClass/base/interaction-handler/index.js'), e.abrupt('return');
                                                case 10:
                                                    if ('canvas_switch_courseware' !== a) {
                                                        e.next = 14;
                                                        break;
                                                    }
                                                    return console.info('if(key === \'canvas_switch_courseware\')为true触发return,path: /renderer/components/Classroom/LargeClass/base/interaction-handler/index.js'), J.a.emit('player', {
                                                        type: 'canvasSwitchCourseware',
                                                        data: i
                                                    }), e.abrupt('return');
                                                case 14:
                                                    if (t.interactionMap, l = t.interactionMap.get(a), null === l || void 0 === l || null === (n = l.ircMsg) || void 0 === n || n.sendTime, !l || c !== l.ircMsg.sendTime) {
                                                        e.next = 23;
                                                        break;
                                                    }
                                                    return console.info('if(keyContent && sendTime === keyContent.ircMsg.sendTime)为true触发return,path: /renderer/components/Classroom/LargeClass/base/interaction-handler/index.js'), t.interactionMap, L.a.send({
                                                        tag: 'irc',
                                                        level: 'error',
                                                        content: { msg: '收到和已存在互动相同的消息' }
                                                    }), e.abrupt('return');
                                                case 23:
                                                    if (u = '收到KV消息('.concat(s ? '历史' : '实时', ') => ').concat(a), L.a.send({
                                                        tag: 'irc',
                                                        content: {
                                                            msg: u,
                                                            params: i
                                                        }
                                                    }), 'countDown' !== a) {
                                                        e.next = 29;
                                                        break;
                                                    }
                                                    return console.info('if(key === \'countDown\')为true触发return,path: /renderer/components/Classroom/LargeClass/base/interaction-handler/index.js'), v.a.prototype.$bus.$emit('room.countDown', i), e.abrupt('return');
                                                case 29:
                                                    if ('sendGiftBarrage' !== a) {
                                                        e.next = 34;
                                                        break;
                                                    }
                                                    return console.info('if(key === \'sendGiftBarrage\')为true触发return,path: /renderer/components/Classroom/LargeClass/base/interaction-handler/index.js'), m = null === (d = t.interactionMap.get('openGift')) || void 0 === d ? void 0 : d.instance, m && m.vm.receiveGiftBarrage(i), e.abrupt('return');
                                                case 34:
                                                    if ('vote_data' !== a) {
                                                        e.next = 39;
                                                        break;
                                                    }
                                                    return console.info('if(key === \'vote_data\')为true触发return,path: /renderer/components/Classroom/LargeClass/base/interaction-handler/index.js'), p = null === (h = t.interactionMap.get('vote')) || void 0 === h ? void 0 : h.instance, p && p.vm.getVoteStatistics(i), e.abrupt('return');
                                                case 39:
                                                    if ('video_mic' !== a) {
                                                        e.next = 46;
                                                        break;
                                                    }
                                                    if (g = null === (f = t.interactionMap.get('video_mic')) || void 0 === f ? void 0 : f.instance, !g) {
                                                        e.next = 46;
                                                        break;
                                                    }
                                                    return console.info('if(_interaction2)为true触发return,path: /renderer/components/Classroom/LargeClass/base/interaction-handler/index.js'), g.vm.videoLinkMessage(i), i.open || t.destroy(a), e.abrupt('return');
                                                case 46:
                                                    if ('video_mic_f' !== a) {
                                                        e.next = 50;
                                                        break;
                                                    }
                                                    return console.info('if(key === \'video_mic_f\')为true触发return,path: /renderer/components/Classroom/LargeClass/base/interaction-handler/index.js'), v.a.prototype.$bus.$emit('room.tutorVideoLink', i, function (e) {
                                                        var s = e.status;
                                                        console.info('箭头函数 监听 room.tutorVideoLink(status)', s, 'filePath:renderer/components/Classroom/LargeClass/base/interaction-handler/index.js');
                                                        t.tutorVideoLinkStatus = s;
                                                    }), e.abrupt('return');
                                                case 50:
                                                    if ('classroom_praise' !== a) {
                                                        e.next = 55;
                                                        break;
                                                    }
                                                    if (!i.pub) {
                                                        e.next = 55;
                                                        break;
                                                    }
                                                    return console.info('if(noticeContent.pub)为true触发return,path: /renderer/components/Classroom/LargeClass/base/interaction-handler/index.js'), v.a.prototype.$bus.$emit('room.showPraiseTreasure', i), e.abrupt('return');
                                                case 55:
                                                    if ('distribute_coins' !== a) {
                                                        e.next = 60;
                                                        break;
                                                    }
                                                    if (!i.pub) {
                                                        e.next = 60;
                                                        break;
                                                    }
                                                    return console.info('if(noticeContent.pub)为true触发return,path: /renderer/components/Classroom/LargeClass/base/interaction-handler/index.js'), v.a.prototype.$bus.$emit('room.orientationCoins', i), e.abrupt('return');
                                                case 60:
                                                    if ('praise' !== a) {
                                                        e.next = 63;
                                                        break;
                                                    }
                                                    return console.info('if(key === \'praise\')为true触发return,path: /renderer/components/Classroom/LargeClass/base/interaction-handler/index.js'), e.abrupt('return', v.a.prototype.$bus.$emit('endCorrectPhotoWall', i, s));
                                                case 63:
                                                    if ('student_rank' !== a) {
                                                        e.next = 68;
                                                        break;
                                                    }
                                                    if (!i) {
                                                        e.next = 68;
                                                        break;
                                                    }
                                                    return console.info('if(noticeContent)为true触发return,path: /renderer/components/Classroom/LargeClass/base/interaction-handler/index.js'), v.a.prototype.$bus.$emit('room.smallClassRank', i), e.abrupt('return');
                                                case 68:
                                                    if ('video_bet_student' !== a) {
                                                        e.next = 72;
                                                        break;
                                                    }
                                                    return console.info('if(key === \'video_bet_student\')为true触发return,path: /renderer/components/Classroom/LargeClass/base/interaction-handler/index.js'), i.pub ? v.a.prototype.$bus.$emit('remoteAudioStatus', true) : v.a.prototype.$bus.$emit('remoteAudioStatus', false), e.abrupt('return');
                                                case 72:
                                                    if ('mult_video_mic' !== a) {
                                                        e.next = 78;
                                                        break;
                                                    }
                                                    if (b = null === (C = t.interactionMap.get('mult_video_mic')) || void 0 === C ? void 0 : C.instance, !b || !i.pub || 1 == i.status || s) {
                                                        e.next = 78;
                                                        break;
                                                    }
                                                    return console.info('if(_interaction3 && noticeContent.pub && noticeContent.status != 1 && !isHistory)为true触发return,path: /renderer/components/Classroom/LargeClass/base/interaction-handler/index.js'), b.vm.receiveMessage(i), e.abrupt('return');
                                                case 78:
                                                    if ('teacher_video_mic' === a && v.a.prototype.$bus.$emit('teacherOnStage', i), 'graffiti_board_video' === a && ((null === i || void 0 === i ? void 0 : i.userId) != t.options.roomInfo.commonOption.stuId ? v.a.prototype.$bus.$emit('teacherOnPrivateChat', i) : (i.status = 1, v.a.prototype.$bus.$emit('teacherOnStage', i)), v.a.prototype.$bus.$emit('changeAudioStatus', i)), 'class_examination' === a && v.a.prototype.$bus.$emit('classExamination', i), 'red_packet_rain' !== a) {
                                                        e.next = 111;
                                                        break;
                                                    }
                                                    if (S = i.pub, w = i.action, y = i.name, 'redbagrainPackage' === y && (a = 'redPacket'), A = t.interactionMap.get(a), !S) {
                                                        e.next = 111;
                                                        break;
                                                    }
                                                    if (!A || 'start' !== w) {
                                                        e.next = 89;
                                                        break;
                                                    }
                                                    return console.info('if(storeVm && action === \'start\')为true触发return,path: /renderer/components/Classroom/LargeClass/base/interaction-handler/index.js'), e.abrupt('return');
                                                case 89:
                                                    if ('play' !== w) {
                                                        e.next = 111;
                                                        break;
                                                    }
                                                    if (k = localStorage.getItem('redPacketRainKey'), I = localStorage.getItem('redPacketRainStatus'), k !== i.interactId || 'end' !== I) {
                                                        e.next = 96;
                                                        break;
                                                    }
                                                    return console.info('if(interactId === noticeContent.interactId && status === \'end\')为true触发return,path: /renderer/components/Classroom/LargeClass/base/interaction-handler/index.js'), A && t.destroy(a), e.abrupt('return');
                                                case 96:
                                                    if (!A || '' !== I && 'start' !== I) {
                                                        e.next = 100;
                                                        break;
                                                    }
                                                    return console.info('if(storeVm && (status === \'\' || status === \'start\'))为true触发return,path: /renderer/components/Classroom/LargeClass/base/interaction-handler/index.js'), A.instance.vm.play(), e.abrupt('return');
                                                case 100:
                                                    if (x = t.options.roomInfo.commonOption.timeOffset + +new Date(), t.options.roomInfo.commonOption.timeOffset, r.sendTime, !(x > r.sendTime + 10000)) {
                                                        e.next = 105;
                                                        break;
                                                    }
                                                    return console.info('if(nowTime > noticeValue.sendTime + 10000)为true触发return,path: /renderer/components/Classroom/LargeClass/base/interaction-handler/index.js'), e.abrupt('return');
                                                case 105:
                                                    return e.next = 107, Object(lr.b)(t, {
                                                        interactId: i.interactId,
                                                        planId: t.options.roomInfo.commonOption.planId,
                                                        userId: t.options.roomInfo.commonOption.stuId
                                                    });
                                                case 107:
                                                    if (O = e.sent, !O) {
                                                        e.next = 111;
                                                        break;
                                                    }
                                                    return console.info('if(hasReport)为true触发return,path: /renderer/components/Classroom/LargeClass/base/interaction-handler/index.js'), e.abrupt('return');
                                                case 111:
                                                    wo.b[a] && (j = i.pub, T = i.open, M = i.publishTopic, j || T || M ? (R = t.interactionMap.get(a), R && t.destroy(a, false), t.render({
                                                        key: a,
                                                        noticeContent: i,
                                                        isHistory: s,
                                                        sendTime: c
                                                    })) : false !== j && false !== T && 0 !== j && 0 !== T && false !== M || t.destroy(a));
                                                case 112:
                                                case 'end':
                                                    return e.stop();
                                            }
                                        }
                                    }, e);
                                }));
                                return function (t, s) {
                                    return e.apply(this, arguments);
                                };
                            }());
                        } else {
                            console.info('if(!data.datas)为true触发return,path: /renderer/components/Classroom/LargeClass/base/interaction-handler/index.js');
                        }
                    }
                },
                {
                    key: 'addExtraTimeParams',
                    value: function (e) {
                        this.interactionContent.sendTime = e.sendTime < 1000 * window._requestBasicEnterServerTime ? 1000 * window._requestBasicEnterServerTime + (new Date().getTime() - window._requestBasicTime) : e.sendTime;
                        this.interactionContent.getIrcLocalTime = new Date().getTime();
                    }
                },
                {
                    key: 'render',
                    value: function () {
                        var e = Object(A.a)(Object(P.a)().mark(function e(t) {
                            var s, o, a, n, r, i, c, l;
                            return Object(P.a)().wrap(function (e) {
                                while (1) {
                                    switch (e.prev = e.next) {
                                        case 0:
                                            if (s = t.key, o = t.isHistory, a = t.noticeContent, n = t.sendTime, r = this.interactionList[s], !r) {
                                                e.next = 11;
                                                break;
                                            }
                                            return i = {
                                                roomMessage: this.options,
                                                ircMsg: a,
                                                isHistory: o
                                            }, e.next = 6, r();
                                        case 6:
                                            c = e.sent, l = new c.default(i), this.interactionMap.set(s, {
                                                instance: l,
                                                ircMsg: Object(F.a)(Object(F.a)({}, a), {}, { sendTime: n })
                                            }), e.next = 12;
                                            break;
                                        case 11:
                                            console.error('未实现这种互动');
                                        case 12:
                                        case 'end':
                                            return e.stop();
                                    }
                                }
                            }, e, this);
                        }));
                        function t(t) {
                            return console.info('函数申明 render(_x3)', t, 'filePath:renderer/components/Classroom/LargeClass/base/interaction-handler/index.js'), e.apply(this, arguments);
                        }
                        return t;
                    }()
                },
                {
                    key: 'destroy',
                    value: function (e) {
                        var t = !(arguments.length > 1 && void 0 !== arguments[1]) || arguments[1], s = this.interactionMap.get(e);
                        if (s) {
                            var o = s.instance, a = s.ircMsg;
                            if (this.interactionMap.delete(e), o.vm.destroyInteraction) {
                                return console.info('if(interaction.vm.destroyInteraction)为true触发return,path: /renderer/components/Classroom/LargeClass/base/interaction-handler/index.js'), void o.vm.destroyInteraction({
                                    ircMsg: a,
                                    isNeedSubmit: t
                                });
                            }
                            o.destroy({
                                options: this.options,
                                submit: this.submit,
                                ircMsg: a
                            });
                        } else {
                            console.info('if(!interactionObj)为true触发return,path: /renderer/components/Classroom/LargeClass/base/interaction-handler/index.js');
                        }
                    }
                }
            ]), s;
        }(ir.a);
        s('e8a0');
        s('0b2c');
        window.RTC_COMMON = { RtcEngine: p.a };
        v.a.use(h.a);
        v.a.use(m.a);
        v.a.use(d.a);
        v.a.use(u.a);
        v.a.use(l.a);
        v.a.use(c.a);
        v.a.use(i.a);
        v.a.use(r.a);
        v.a.prototype.$Modal = m.a;
        v.a.prototype.$Message = n.a;
        v.a.prototype.$Notification = a.a;
        v.a.prototype.$bus = new v.a();
        new y({
            Logger: {
                module: _,
                options: {}
            },
            Initer: {
                module: ie,
                options: {}
            },
            Player: [{
                module: Yt,
                options: {}
            }],
            SignalService: {
                module: it.a,
                options: {}
            },
            Chat: {
                module: Zs,
                options: {}
            },
            InteractionHandler: {
                module: ur,
                options: {}
            },
            Room: [{
                module: rr,
                options: {}
            }],
            ExceptionHandler: {
                module: eo,
                options: {}
            }
        });
    },
    d46a: function (e, t, s) {
    },
    d672: function (e, t, s) {
        'use strict';
        s('e93c');
    },
    d787: function (e, t) {
        e.exports = require('punycode');
    },
    d871: function (e, t, s) {
        'use strict';
        s('c8e4');
    },
    d9e5: function (e, t) {
        e.exports = 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEgAAABICAMAAABiM0N1AAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAACTUExURUdwTP/AD/+4Df/LE/+2DP/CEP/ADv++Bf/AD//AEP+2DP/LE//ADf+zC//EEP/JEv+/D//LE/++D//FEv/KE//NFP/OFP+3Df+/EP/FEv+5Dv/////HEv+7Dv+1DP/BEP/LFP+9EP+zDP/DEv/NFP/JFP/JEv/DEP+xDP+9Dv/89P/QTv/ikP/de//qq//01f/HLEyeD+gAAAAXdFJOUwCO0LPpN0sIcF+z0Rr3IuL0+abu6/DqT1WinQAABE9JREFUWMOdmOmWojAQhdlsQJtWj91NjCzGwDRjb77/001WspAgTuD3d25VbqoqCYKZtcrDdRQlRZEk0TrMV8H/rOdsnTTN5dKUZF2KoRiGIVlnz49R0nwNSwgpo2zYulwGvtZ5uhyTJRBSDCU19CMgghKwJEuXYlANIUeNmkpOegC1imrJEdE1nHVRoGGI7iU+DWuE6lqRuKTyMkGFs6JeIoKhoBrWpqbGBg3Ri5/zlLQIcUWKJDQpSRKVPHk5O85BXBMySQokSYWHlLeMI4MjipACcVJpkobcyQEAILkoCI1bB33RuUirHTBICCKI4CQ6i1RMbPCyw61OqhmJo0pHoqSkwtq7NMKALyWJB4eUJi7J0hSZoBC37YSkgpvzU2gkiHAmJCRISD92joxraUo3DCRICMgs6Zqg10+ROixZK5ZBQgaphN69y0ZBB4yxTgLIJBl7N40ukZKyI75DmnrcIAlJ6SvmIKxAE5LP47qkHGOsJDldMKJEdLaf+EmJj0essyzS5+/19xNax8Xy05r1neNxjvR9Op2u11tp5MmovhRFu1RWeUjUBTXlkPVtucDeuoxFVtkgRRKc03c55txZC2hshyNfDtLfL8G53oyiovUpAUrIMeuZIidp5HxCzZmuWkAOXF5VNoj5qQVYcaibjGNn9ztigHDfVy5JLf7R9CBkSbL9FAZxVY2a9JSDH00PU+Q4d6OfSLY3vQZSJE1PjTD5ZImyaqaMLgq2feUiSY69rl+GxYWfmiIJXvveEdzXybu+Sl2T9FMS7Pt+qqm9+kFXp58KBdJJH78zoLK2/MRBJLT+j4HC+HicC832E1tJsD33oyaN5E92CWvLT1RTQra/n5AI66a2n2UfYF5YIGRzil3HmyiIz72GGkEfWDckkL+cMPR2zkjrIDRAWsY/FAlwQaJP1Ug/d4wEizDIOyeJbp06tBhxDhjHAnqI9ZqZB6vzWZKs6LS9+zQkqW4+Fs2G9O03Rap8pOuNHjdVyGuzGNDdJ6X2PJIsP5FvLLUUgo0updcnSEtt1nW2Js1PsvhTAyDf1FNCWvyf9+ezh0RFffPQANu51j0XoIJdmmImyZNx/EEb5I1ZErXO+UlERlo2B3kzTqqcNHdrTD0iT+TnLTt97wxNlav4AgwmpDFPcq7JhCRfdKL4YjWtmHuH5KSVvnWz0amOQCSZeYI0wHHQUpLcfholeSbWTBtGO6cmm0RbJ55MYtowGqw6S5PtJ8WaTofGLSLsbE3uLuUgheYVQgU3l/F2Oo9H1pX05a3r5vbOMz+h3eRCutpPNLn9pE+HADlu2/l+UXQm6cl11867bpGftITnnstx59HknJ8A2OW+14PV21I/UdDhaeYBYbPUT20794BAnzSWZRzj8O4jy2aJnzarJc8+7/f8dFj8gvQ+V5+22QNvWnm8d/sJxw88jYnHunjSgw/xo4916vkw3mxf9/vX7Sa+83z4D98F1zcKKGaFAAAAAElFTkSuQmCC';
    },
    da52: function (e, t) {
        e.exports = 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADwAAAA8CAMAAAANIilAAAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAAHXUExURUdwTP/36v/t0P/99f/vsf/++//Nq/7tsP/xtP7tsf/u2//s1f7tr/7trv/xuv/tsP/9+f/15P7tsP3uu//v1fzrs//ssv////7rtf///f3suf3trf/06fzjsv/s2f/t2//v3v/v3P703v/r1v736P//////////5//////s2f/t1//r1/354f3ts//98f///f/t2////+FSGHg8AP/V1f/JYP/+/P///f7vtv7tsf/05v3trf3tr/7wuv/7+P7xvv7ts/7rq//t2//58f/v3f/48P/9+f3tq//+9/70zv/68//v3//37f7wxP/69v7zyP/x5P/10//33P/12P/55f/16f/qtP//+//suv7xwf/u2f/87v/v6//w0P/54f/17P/y4P/98//i4f7yxf/d2v/76v7swf7psP/rysqXfrSPa+PVxf/Z1frh0//NbOqGV/nVxv/uyONfJn5DCJZiMYlQGuFVGv3vs/Xx7f7DXOvj2uVtO7udff/trfmxUNGjjum7r/THuaJxRsmxmOVnK/nNyuuLYe2ZdfXBq+2GNv/o5//ajvGvk/CkgPz18+t9Mf3RhKuFXP/v1durmfu7WP/l2/3R0f3hndG9p/GXQO2HPP3pvdmpmTg54hkAAAAxdFJOUwATaBdo8QT2FI71/sruGFVoJLdQ7iR0js/L79tS+NvJdI3PU/JW2wS3j7fPdNuNdLc+bPFzAAAErklEQVRIx+2X+VcaVxTHXVhUFo1rtLVJYxKTtmlLwHGUYWBYRWUTzTkgoCLO4G5cGLdjNHFJOCmxnpSknfyxve8NKjPgkp/aH3LxcM4c5/O+33vffddnRcW3+O+j+lHbk8dKpUH5+Enbo+qvISsb2g3FQbQ3VN5WtE0pQQ29BDGg/PU28t2/yVCkTLinZh7+0n0Te6e9F2nJpd1T46OJBy3Xs98rCRS9cttu//hMItTcdB3bkPP73W6CkEojeMAxmhjxTlddww4P+mmaBlYKG3rdA+B7xBuIKK70PDbhGvQjYUJqGypGT43PjIS8EcsVzu88nEAwTcht43IPDM4kwt5pa0fZqnU/iPVfwLJqgzaNfIcCEfKuqgx8PxgE25BzqbC40+Ob2DfZWqav6gpwqTCmC759FlKtL4F/HAr2j7kGabxRn/+c25YZd0OToXpbLXxtyVmoGwoGz4XnjEbj2ryEnp/PDeCkWZJX18jgKjsoDzsAhheNKNaLPG+/huccJI18833yzb43NBRErpHwGwwbL9jNOfw8Dx0aDkDSfVpZuezOoX5ca3gZ4LVLmH6zJi42P1WoGEVJfXc5EezwZ5OpVPJVsfLmuvi0NpdKpezQ3gLPU/US+KndDhsVM6HIz+KXC/CuyK7vm/LoowlYyT6ztN6/R53BsSxGTabZYuVdvJDx9UFeXDlt5W1UowT+wQ7wAkZl8PZGwfYs/m1+gSUp83cSuBl2Kmi6VC4qWG6uULB98fcsT1E6CVwHcAxnBSEWbONiq2CXEf9FXFogKY+6BJ5Iicr5I+x097LF/V821owbR3jpBQsvh5ujAMcKOZv212Fn/EWdnc2/mj0Sl2ZJG8XoZAUD2IW0UVFM2c2c9FDFRMumhXTEwpsZacF+QtV2+YlYNpnMxkqGGGGgY8lk6q+oNyDYKA8j3aqnUQzTBvn8Oh8kMEmgO0PeaZQyI22SLtxhcJoN5SYBmvowC0bDYRhDkLJH2p7VGjucSDTADLHj1Z3lk/dvD1ZWFiFWVg7evj9Z3lldjqJjIfCU2cPIDvQ9SHrChWb28fOykckso7mNXWtLhoETn2eaOMSvlsEPQ16fFQsrSsaQHc5kDnwfi2jm4oOf4WcZWAuwHl1NyQBE0qhkixmpcKbwlekMsGDazDAlA7BCjzsUTcATifDqh7/3Pm5t9Xw8RSzHgLC+zNCPOoGGGZjbyZxLZ97t9fRs9aBYgukF58nDeMoM/QrVz1HQHht2DC6uitKZd1sFElietWKW0arK/qFr1kDe/cMux8oqUj7cK4CwwhIHnnkOKq1rKQtXdGnONFHnZP/YzOLO88yHCxJ0bQIp6jJXXg6q0mlNPBqeTCQm//in5zI+CSBLga7Ho7j6alAlpNPpePwsGh45Y06XsOFTQBFLAdqpuO5S0tQhpNn0S2887o17Qy/ZiM8XsQJLcZTZbNY1XX8darkrQLCsj/VBsBHWYiFh1kJjcWZty00XMVVrZ6fwAq0gWAQSQBtHUZAvpWtVqW6+A+prOzmOo2wUZ+NtL3gOCfPqWv0tb581Ci3iIUCXhy+tovJrLr76+trGZzq1uuNZY219zbd/If4H8S+Ps++9s5oqAgAAAABJRU5ErkJggg==';
    },
    db90: function (e, t, s) {
        'use strict';
        s('bc3f');
    },
    db99: function (e, t, s) {
        'use strict';
        s('b8a2');
    },
    dd90: function (e, t, s) {
        'use strict';
        s('d46a');
    },
    dfa8: function (e, t, s) {
        'use strict';
        s('c7cd');
        var o = function () {
            var e = this, t = e._self._c;
            return t('div', {
                staticClass: 'toolbar',
                class: [{
                    transparent: e.transparent,
                    fixed: e.fixed,
                    'white-button': e.whiteButton,
                    'theme-dark': e.darkTheme
                }],
                attrs: { 'data-log': '原生菜单栏' }
            }, [
                t('div', {
                    staticClass: 'drag-bar',
                    attrs: { 'data-log': 'drag-bar' }
                }),
                t('WindowsActionBar')
            ], 1);
        }, a = [], n = function () {
            var e = this, t = e._self._c;
            return 'win' === e.platform ? t('div', {
                staticClass: 'windows-action-bar',
                attrs: { 'data-log': 'window菜单栏' }
            }, [
                t('div', {
                    staticClass: 'item',
                    attrs: { 'data-log': '最小化' },
                    on: { click: e.handleMinimizeWindow }
                }, [t('span', { staticClass: 'icon icon-minimize' })]),
                e.disabledMaximize ? e._e() : t('div', {
                    staticClass: 'item',
                    attrs: { 'data-log': '最大化' },
                    on: { click: e.handleMaximizeWindow }
                }, [e.isMaximized ? t('span', { staticClass: 'icon icon-exit-full-screen' }) : t('span', { staticClass: 'icon icon-full-screen' })]),
                t('div', {
                    staticClass: 'item',
                    attrs: { 'data-log': '关闭' },
                    on: { click: e.handleCloseWindow }
                }, [t('span', { staticClass: 'icon icon-close' })])
            ]) : e._e();
        }, r = [], i = s('0a4b'), c = s('e39c'), l = (s('18b0'), {
            name: 'WindowsActionBar',
            data: function () {
                return {
                    platform: Object(c.k)(),
                    isMaximized: false
                };
            },
            methods: {
                handleMinimizeWindow: function () {
                    console.info('对象函数 handleMinimizeWindow,filePath:renderer/components/Common/windowsActionBar.vue');
                    i.nativeApi.minimizeWindow();
                },
                handleMaximizeWindow: function () {
                    var e = this;
                    console.info('对象函数 handleMaximizeWindow,filePath:renderer/components/Common/windowsActionBar.vue');
                    i.nativeApi.getWindowState(function (t) {
                        console.info('箭头函数 getWindowState(windwoState)', t, 'filePath:renderer/components/Common/windowsActionBar.vue');
                        'isMaximized' === t ? (i.nativeApi.normalWindow(), e.isMaximized = false) : (i.nativeApi.maximizeWindow(), e.isMaximized = true);
                    });
                },
                handleCloseWindow: function () {
                    console.info('对象函数 handleCloseWindow,filePath:renderer/components/Common/windowsActionBar.vue');
                    localStorage.removeItem('largeClassTestCoverage');
                    localStorage.removeItem('smallClassTestCoverage');
                    i.nativeApi.closeWindow(true);
                }
            }
        }), u = l, d = (s('97e5'), s('2877')), m = Object(d.a)(u, n, r, false, null, '6d913dee', null), h = m.exports, p = {
            name: 'Toolbar',
            components: { WindowsActionBar: h },
            props: {
                transparent: {
                    default: false,
                    type: Boolean
                },
                fixed: {
                    default: false,
                    type: Boolean
                },
                whiteButton: {
                    default: false,
                    type: Boolean
                },
                disabledMaximize: {
                    default: false,
                    type: Boolean
                },
                darkTheme: {
                    default: false,
                    type: Boolean
                }
            }
        }, f = p, v = (s('3ed8'), Object(d.a)(f, o, a, false, null, '3bd2c296', null));
        t.a = v.exports;
    },
    e4e0: function (e, t, s) {
        'use strict';
        s('524e');
    },
    e93c: function (e, t, s) {
    },
    e9da: function (e, t, s) {
        e.exports = s.p + 'static/img/em_8.69d857b0.png';
    },
    ebb8: function (e, t, s) {
        'use strict';
        s('b2dd');
    },
    ed04: function (e, t) {
        e.exports = 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADQAAAA0CAMAAADypuvZAAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAACiUExURUdwTP/////QJv/TSf/////////////////////////bb//JJf/FF/++H/////+/Gv/GI//23/+6Gv+4G//JM//AEf/hhf/NOf/AE//JKf/IL//sqv/AFv/UUv+9D//AIv/SF/+zDv/RXv/PHP/FIP/JFf/PGf/FEv/IG/+8Ev/CEP/EEv+/EP+9D//RFf/HEv/NFP/JE//LFP+0DP+4Dv+xDFMwaacAAAAqdFJOUwAWk1EEDgcaGBM3k8qZCrCUHaqfa/AuYuSGdSTHSfqS8+M/v5/k0/e629KcDUUAAAIVSURBVEjHnVbtdqowEJQKJFBLqwUUBKnWVs1HAeW+/6vdBEQSBMSMPzhwnLM7s5vNTib30B3DgiUsw9EnI6AbEEiAxiOeaYEOWOZQlE5KSeuNZoABGN1hNDAIrSOYCcEDwDtlJhgBU4HTYulwHAmKujQwEtpIr3uc18ETqBOU+8CONie3n2R1OhfRgm7sRw7KgWJCKC3eHoRqKdoTsqLUmw+rkq1be4RMPVq4wwbKdQ0xWYE9pVF/uWE7OzhDKAExbawIP0skOzE/RyLtMEbs7ydCk+rD8nK5/OPYNqGdlqQPjGfsETA3KivcS1HRtqIoyfC5l+OQPX1CybL6FCxKfO5E0yXBbp4e1mWFCT1eVUJ474T06TvFhxlDtCJkY8Ne+6S2S/M0TTEHIjQAo0gveX7lEIRYvfogpjf/yfPfaYU9Yp1Rynwrkdg9mpbZ+VzmBAG0D4hwK5YFLQru+kkkNZbDIyP5txNC0Ia9uKzlOa3YipYLxf3KsqPQhJiXah68cywWsVhcoY2+s79pI3CFPbtMFbStd6SGjX3xkMTr/gMFwZOAz82v5hA2+fnByxWv/FfhgyNJAl8eYjfTf/84sjNzPq/7iXUGnzS0iOQZVo8w7asiMU6bRWjhtS6BOlTIWVnFymsWqlheKA/LmyoInxjLSheA2lWjdqkpXZ9qF7XaSqC2fKitOYoLldrqprgkjltH/wPvDWVVn9PpRQAAAABJRU5ErkJggg==';
    },
    ed62: function (e, t) {
        e.exports = require('https');
    },
    f0e0: function (e, t, s) {
        var o = s('278c').default;
        s('13d5');
        s('3c65');
        s('14d9');
        s('ac1f');
        s('5319');
        s('d3b7');
        s('159b');
        s('4fad');
        s('1276');
        s('d81d');
        s('25f0');
        var a = s('822a');
        function m(e) {
            return ' title="' + e + '" ';
        }
        function h(e) {
            return e = String(e), e.replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g, '&gt;').replace(/\u0001/g, '<').replace(/\u0002/g, '>');
        }
        function p(e, t) {
            var s = e.getLineCoverage();
            s && Object.entries(s).forEach(function (e) {
                var s = o(e, 2), a = s[0], n = s[1];
                t[a] && (t[a].covered = n > 0 ? 'yes' : 'no', t[a].hits = n);
            });
        }
        function f(e, t) {
            var s = e.s, a = e.statementMap;
            Object.entries(s).forEach(function (e) {
                var s, i = o(e, 2), c = i[0], l = i[1], u = a[c], d = l > 0 ? 'yes' : 'no', h = u.start.column, p = u.end.column + 1, f = u.start.line, v = u.end.line, g = '\x01span class="' + (u.skip ? 'cstat-skip' : 'cstat-no') + '"' + m('statement not covered') + '\x02', C = '\x01/span\x02';
                'no' === d && t[f] && (v !== f && (p = t[f].text.originalLength()), s = t[f].text, s.wrap(h, g, h < p ? p : s.originalLength(), C));
            });
        }
        function v(e, t) {
            var s = e.f, a = e.fnMap;
            s && Object.entries(s).forEach(function (e) {
                var s, i = o(e, 2), c = i[0], l = i[1], u = a[c], d = l > 0 ? 'yes' : 'no', h = u.decl || u.loc, p = h.start.column, f = h.end.column + 1, v = h.start.line, g = h.end.line, C = '\x01span class="' + (u.skip ? 'fstat-skip' : 'fstat-no') + '"' + m('function not covered') + '\x02', b = '\x01/span\x02';
                'no' === d && t[v] && (g !== v && (f = t[v].text.originalLength()), s = t[v].text, s.wrap(p, C, p < f ? f : s.originalLength(), b));
            });
        }
        function g(e, t) {
            var s = e.b, a = e.branchMap;
            s && Object.entries(s).forEach(function (e) {
                var s, i, c, l, u, d, h, p, f, v, g = o(e, 2), C = g[0], b = g[1], S = b.reduce(function (e, t) {
                    return e + t;
                }, 0), w = a[C].locations;
                if (S > 0 || 0 === S && 1 === b.length) {
                    for ('if' === a[C].type && 2 === b.length && 1 === w.length && 0 === b[1] && (w[1] = {
                        start: {},
                        end: {}
                    }), s = 0; s < b.length && s < w.length; s += 1) {
                        if (i = b[s], c = w[s], l = c.start.column, u = c.end.column + 1, d = c.start.line, h = c.end.line, p = '\x01span class="branch-' + s + ' ' + (c.skip ? 'cbranch-skip' : 'cbranch-no') + '"' + m('branch not covered') + '\x02', f = '\x01/span\x02', 0 === i && void 0 === d && 'if' === a[C].type) {
                            var y = w[s - 1];
                            l = y.start.column;
                            u = y.end.column + 1;
                            d = y.start.line;
                            h = y.end.line;
                        }
                        0 === i && t[d] && (h !== d && (u = t[d].text.originalLength()), v = t[d].text, 'if' === a[C].type ? v.insertAt(l, '\x01span class="' + (c.skip ? 'skip-if-branch' : 'missing-if-branch') + '"' + m((0 === s ? 'if' : 'else') + ' path not taken') + '\x02' + (0 === s ? 'I' : 'E') + '\x01' + '/span' + '\x02', true, false) : v.wrap(l, p, l < u ? u : v.originalLength(), f));
                    }
                }
            });
        }
        function C(e, t) {
            var s, o;
            try {
                var n = t.getSource(e.path), r = n.split(/(?:\r?\n)|\r/), i = 0, c = r.map(function (e) {
                    return i += 1, {
                        line: i,
                        covered: 'neutral',
                        hits: 0,
                        text: new a(e, true)
                    };
                });
                return c.unshift({
                    line: 0,
                    covered: null,
                    text: new a('')
                }), p(e, c), g(e, c), v(e, c), f(e, c), c.shift(), s = c.map(function (e) {
                    return h(e.text.toString()) || '&nbsp;';
                }), o = c.map(function (e) {
                    return {
                        covered: e.covered,
                        hits: e.hits > 0 ? e.hits + 'x' : '&nbsp;'
                    };
                }), {
                    annotatedCode: s,
                    lineCoverage: o,
                    maxLines: c.length
                };
            } catch (l) {
                return s = [l.message], o = [{
                    covered: 'no',
                    hits: 0
                }], String(l.stack || '').split(/\r?\n/).forEach(function (e) {
                    s.push(e);
                    o.push({
                        covered: 'no',
                        hits: 0
                    });
                }), {
                    annotatedCode: s,
                    lineCoverage: o,
                    maxLines: s.length
                };
            }
        }
        e.exports = C;
    },
    f1687: function (e, t, s) {
        e.exports = s.p + 'static/img/em_5.6e17efdb.png';
    },
    f319: function (e, t) {
        e.exports = require('querystring');
    },
    f502: function (e, t, s) {
        'use strict';
        s('c482');
    },
    f7794: function (e, t, s) {
        'use strict';
        s('c826');
    },
    f813: function (e, t, s) {
        'use strict';
        s('fd7ec');
    },
    f980: function (e, t, s) {
    },
    fb75: function (e, t, s) {
        'use strict';
        s('fdfc');
    },
    fd7ec: function (e, t, s) {
    },
    fdfc: function (e, t, s) {
    },
    ff4a: function (e, t) {
        e.exports = require('events');
    },
    ffa1: function (e, t, s) {
        'use strict';
        s('c216');
    }
}));