package com.didi.hummer.module;

import com.didi.hummer.component.input.NJReturnKeyType;
import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.render.component.view.BaseInvoker;

public class WebSocket$$Invoker extends BaseInvoker<WebSocket> {
    public String getName() {
        return "WebSocket";
    }

    /* access modifiers changed from: protected */
    public WebSocket createInstance(JSValue jSValue, Object[] objArr) {
        return new WebSocket(jSValue, (objArr.length <= 0 || objArr[0] == null) ? null : String.valueOf(objArr[0]));
    }

    /* access modifiers changed from: protected */
    public Object invoke(WebSocket webSocket, String str, Object[] objArr) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -2129028346:
                if (str.equals("setOnmessage")) {
                    c = 0;
                    break;
                }
                break;
            case -1249348039:
                if (str.equals("getUrl")) {
                    c = 1;
                    break;
                }
                break;
            case -905798227:
                if (str.equals("setUrl")) {
                    c = 2;
                    break;
                }
                break;
            case -625809843:
                if (str.equals("addEventListener")) {
                    c = 3;
                    break;
                }
                break;
            case 3526536:
                if (str.equals(NJReturnKeyType.SEND)) {
                    c = 4;
                    break;
                }
                break;
            case 94756344:
                if (str.equals("close")) {
                    c = 5;
                    break;
                }
                break;
            case 469271467:
                if (str.equals("setOnopen")) {
                    c = 6;
                    break;
                }
                break;
            case 1651322039:
                if (str.equals("setOnclose")) {
                    c = 7;
                    break;
                }
                break;
            case 1653350599:
                if (str.equals("setOnerror")) {
                    c = 8;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                webSocket.setOnmessage((objArr.length <= 0 || objArr[0] == null) ? null : objArr[0]);
                return null;
            case 1:
                return webSocket.getUrl();
            case 2:
                webSocket.setUrl((objArr.length <= 0 || objArr[0] == null) ? null : String.valueOf(objArr[0]));
                return null;
            case 3:
                webSocket.addEventListener((objArr.length <= 0 || objArr[0] == null) ? null : String.valueOf(objArr[0]), (objArr.length <= 1 || objArr[1] == null) ? null : objArr[1]);
                return null;
            case 4:
                webSocket.send((objArr.length <= 0 || objArr[0] == null) ? null : String.valueOf(objArr[0]));
                return null;
            case 5:
                webSocket.close();
                return null;
            case 6:
                webSocket.setOnopen((objArr.length <= 0 || objArr[0] == null) ? null : objArr[0]);
                return null;
            case 7:
                webSocket.setOnclose((objArr.length <= 0 || objArr[0] == null) ? null : objArr[0]);
                return null;
            case 8:
                webSocket.setOnerror((objArr.length <= 0 || objArr[0] == null) ? null : objArr[0]);
                return null;
            default:
                return null;
        }
    }
}
