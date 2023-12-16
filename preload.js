!(function (e) {
  var value_0 = {}
  function object_0(t) {
    if (value_0[t]) {
      return value_0[t].exports
    }
    var o = (value_0[t] = {
      i: t,
      l: false,
      exports: {},
    })
    return e[t].call(o.exports, o, o.exports, object_0), (o.l = true), o.exports
  }
  object_0.m = e
  object_0.c = value_0
  object_0.d = function (e, r, t) {
    object_0.o(e, r) ||
      Object.defineProperty(e, r, {
        enumerable: true,
        get: t,
      })
  }
  object_0.r = function (e) {
    'undefined' != typeof Symbol &&
      Symbol.toStringTag &&
      Object.defineProperty(e, Symbol.toStringTag, { value: 'Module' })
    Object.defineProperty(e, '__esModule', { value: true })
  }
  object_0.t = function (e, r) {
    if ((1 & r && (e = object_0(e)), 8 & r)) {
      return e
    }
    if (4 & r && 'object' == typeof e && e && e.__esModule) {
      return e
    }
    var t = Object.create(null)
    if (
      (object_0.r(t),
        Object.defineProperty(t, 'default', {
          enumerable: true,
          value: e,
        }),
        2 & r && 'string' != typeof e)
    ) {
      for (var o in e)
        object_0.d(
          t,
          o,
          function (r) {
            return e[r]
          }.bind(null, o)
        )
    }
    return t
  }
  object_0.n = function (e) {
    var r =
      e && e.__esModule
        ? function () {
          return e.default
        }
        : function () {
          return e
        }
    return object_0.d(r, 'a', r), r
  }
  object_0.o = function (e, r) {
    return Object.prototype.hasOwnProperty.call(e, r)
  }
  object_0.p = ''
  object_0((object_0.s = 1))
})([
  function (e, r) {
    e.exports = require('electron')
  },
  function (e, r, n) {
    e.exports = n(2)
  },
  function (e, r, n) {
    'use strict'
    n.r(r)
    var data_0 = n(0)
    const o = {
      invoke: (e, ...r) => data_0.ipcRenderer.invoke(e, ...r),
      on: (e, r) => (data_0.ipcRenderer.on(e, r), o),
      send: (e, ...r) => data_0.ipcRenderer.send(e, ...r),
      removeAllListeners: (e) => (data_0.ipcRenderer.removeAllListeners(e), o),
      removeListener: (e, r) => (data_0.ipcRenderer.removeListener(e, r), o),
    },
      i = {
        ipc: o,
        logger: (e = 'info', ...r) =>
          data_0.ipcRenderer.send('application:write-logger', e, ...r),
      }
    try {
      data_0.contextBridge.exposeInMainWorld('thinkApi', i)
    } catch {
      window.thinkApi = i
    }
  },
])
