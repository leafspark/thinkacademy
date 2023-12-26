'use strict'
/** 
 * 重写window.parent.postMessage
 */
window.parent = {}
/**
 * 获取课件发送的消息
 * @param {Object} message 课件广播发送的消息message
 * @param {String} origin 其值可以是字符串 “*”，或者是一个URI
 */

window.parent.postMessage = function (message, origin) {
    var data = {
        message: message,
        origin: origin
    }
    console.log(data)
    window.webkit && window.webkit.messageHandlers.xesApp.postMessage(JSON.stringify(data));
    
    /*
     var UserAgent = window.navigator.userAgent.toLowerCase();
     var isIOS = !!UserAgent.match(/\(i[^;]+;( U;)? cpu.+mac os x/);
     var isPC = window.navigator.userAgent.toLocaleLowerCase().indexOf('xescef') != -1;
     if (isPC) {
     onInvokeQtFunction(JSON.stringify(data));
     } else if (isIOS) {
     window.webkit && window.webkit.messageHandlers.xesApp.postMessage(JSON.stringify(data));
     } else {
     window.xesApp && xesApp.postMessage(JSON.stringify(data));
     }
     */
}
/**
 * 监听e.source.postMessage
 */
window.addEventListener('message', function (e) {
    var data = {
        message: e.data,
        origin: e.origin
    }
    console.log(data)
    window.webkit && window.webkit.messageHandlers.xesApp.postMessage(JSON.stringify(data));
    
    /*
     var UserAgent = window.navigator.userAgent.toLowerCase();
     var isIOS = !!UserAgent.match(/\(i[^;]+;( U;)? cpu.+mac os x/);
     var isPC = window.navigator.userAgent.toLocaleLowerCase().indexOf('xescef') != -1;
     if (isPC) {
     onInvokeQtFunction(JSON.stringify(data));
     } else if (isIOS) {
     window.webkit && window.webkit.messageHandlers.xesApp.postMessage(JSON.stringify(data));
     } else {
     window.xesApp && xesApp.postMessage(JSON.stringify(data));
     }
     */
})

/**
 * 给课件发送消息
 * @param {Object} message 表示该message的类型
 * @param {String} origin 其值可以是字符串 “*”，或者是一个URI
 */

function sendToCourseware(message, origin) {
    window.postMessage(message, origin)
}

/**
 * mac PC端通信
 */
registerFunction();

function registerFunction() {
    var isPC = navigator.userAgent.toLocaleLowerCase().indexOf('xescef') != -1
    if (isPC) {
        if (typeof QCefClient == 'undefined') {
            var head = document.getElementsByTagName('head')[0];
            var script = document.createElement('script');
            script.src = 'qrc:///qtwebchannel/qwebchannel.js';
            head.appendChild(script);
            script.onload = function () {
                new QWebChannel(qt.webChannelTransport, function (channel) {
                    window.bridges = channel.objects.bridges;
                });
            };
        } else {
            QCefClient.addEventListener("invokeJsFunction", onInvokeJsFunction);
        }
    }
}

function onInvokeQtFunction(method, args) {
    var isPC = navigator.userAgent.toLocaleLowerCase().indexOf('xescef') != -1
    if (isPC) {
        args = args || '';
        if (typeof QCefClient == 'undefined') {
            if (window.bridges !== undefined) {
                window.bridges.invokeMethod(method, args);
            } else {
                var maxTry = 5;
                var timer = setInterval(function () {
                    if (window.bridges === undefined) {
                        maxTry--;
                    } else if (maxTry === 0) {
                        clearInterval(timer);
                        console.warn('onInvokeQtFunction(' + method + ') timeout, failed!');
                    } else {
                        clearInterval(timer);
                        window.bridges.invokeMethod(method, args);
                    }
                }, 500);
            }
        } else {
            QCefClient.invokeMethod(method, args);
        }
    }
}

function onInvokeJsFunction(event) {
    var isPC = navigator.userAgent.toLocaleLowerCase().indexOf('xescef') != -1
    if (isPC) {
        if (typeof QCefClient == 'undefined') {
            return;
        }
        if (event.type == 'function') {
            eval(event.data);
        }
    }
}


