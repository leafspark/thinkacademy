package com.didi.hummer.module;

import android.text.TextUtils;
import com.bonree.sdk.agent.engine.external.OkHttp3Instrumentation;
import com.coloros.ocs.base.common.constant.CommonStatusCodes;
import com.didi.hummer.annotation.Component;
import com.didi.hummer.annotation.JsMethod;
import com.didi.hummer.annotation.JsProperty;
import com.didi.hummer.core.engine.JSCallback;
import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.lifecycle.ILifeCycle;
import com.didi.hummer.utils.UIThreadUtil;
import com.google.firebase.messaging.Constants;
import com.huawei.multimedia.audiokit.config.ResultCode;
import java.io.EOFException;
import java.util.HashMap;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocketListener;

@Component("WebSocket")
public class WebSocket implements ILifeCycle {
    private static OkHttpClient client;
    private JSValue jsValue;
    /* access modifiers changed from: private */
    @JsProperty("onclose")
    public JSCallback onclose;
    /* access modifiers changed from: private */
    @JsProperty("onerror")
    public JSCallback onerror;
    /* access modifiers changed from: private */
    @JsProperty("onmessage")
    public JSCallback onmessage;
    /* access modifiers changed from: private */
    @JsProperty("onopen")
    public JSCallback onopen;
    @JsProperty("url")
    public String url;
    /* access modifiers changed from: private */
    public okhttp3.WebSocket webSocket;

    public void onCreate() {
    }

    public enum CloseCodes {
        CLOSE_NORMAL(ResultCode.KARAOKE_SUCCESS),
        CLOSE_GOING_AWAY(1001),
        CLOSE_PROTOCOL_ERROR(1002),
        CLOSE_UNSUPPORTED(1003),
        CLOSE_NO_STATUS(CommonStatusCodes.VERSION_INCOMPATIBLE),
        CLOSE_ABNORMAL(CommonStatusCodes.AUTHCODE_RECYCLE),
        UNSUPPORTED_DATA(CommonStatusCodes.AUTHCODE_INVALID),
        POLICY_VIOLATION(CommonStatusCodes.CAPABILITY_EXCEPTION),
        CLOSE_TOO_LARGE(1009),
        MISSING_EXTENSION(1010),
        INTERNAL_ERROR(1011),
        SERVICE_RESTART(1012),
        TRY_AGAIN_LATER(1013),
        TLS_HANDSHAKE(1015);
        
        private int code;

        private CloseCodes(int i) {
            this.code = i;
        }

        public int getCode() {
            return this.code;
        }
    }

    public WebSocket(JSValue jSValue, String str) {
        if (client == null) {
            client = OkHttp3Instrumentation.init();
        }
        this.jsValue = jSValue;
        if (jSValue != null) {
            jSValue.protect();
        }
        connect(str);
    }

    public void onDestroy() {
        okhttp3.WebSocket webSocket2 = this.webSocket;
        if (webSocket2 != null) {
            webSocket2.close(CloseCodes.CLOSE_GOING_AWAY.getCode(), CloseCodes.CLOSE_GOING_AWAY.name());
        }
        JSCallback jSCallback = this.onopen;
        if (jSCallback != null) {
            jSCallback.release();
            this.onopen = null;
        }
        JSCallback jSCallback2 = this.onmessage;
        if (jSCallback2 != null) {
            jSCallback2.release();
            this.onmessage = null;
        }
        JSCallback jSCallback3 = this.onclose;
        if (jSCallback3 != null) {
            jSCallback3.release();
            this.onclose = null;
        }
        JSCallback jSCallback4 = this.onerror;
        if (jSCallback4 != null) {
            jSCallback4.release();
            this.onerror = null;
        }
    }

    private void connect(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.url = str;
            Request build = new Request.Builder().url(str).build();
            OkHttpClient okHttpClient = client;
            AnonymousClass1 r1 = new WebSocketListener() {
                public void onOpen(okhttp3.WebSocket webSocket, Response response) {
                    okhttp3.WebSocket unused = WebSocket.this.webSocket = webSocket;
                    UIThreadUtil.runOnUiThread(new WebSocket$1$$ExternalSyntheticLambda0(this));
                }

                public /* synthetic */ void lambda$onOpen$0$WebSocket$1() {
                    if (WebSocket.this.onopen != null) {
                        WebSocket.this.onopen.call(new Object[0]);
                    }
                }

                public void onClosed(okhttp3.WebSocket webSocket, int i, String str) {
                    UIThreadUtil.runOnUiThread(new WebSocket$1$$ExternalSyntheticLambda1(this, i, str));
                }

                public /* synthetic */ void lambda$onClosed$1$WebSocket$1(int i, String str) {
                    if (WebSocket.this.onclose != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("code", Integer.valueOf(i));
                        hashMap.put("reason", str);
                        WebSocket.this.onclose.call(hashMap);
                    }
                }

                public void onFailure(okhttp3.WebSocket webSocket, Throwable th, Response response) {
                    th.printStackTrace();
                    UIThreadUtil.runOnUiThread(new WebSocket$1$$ExternalSyntheticLambda3(this, th));
                }

                public /* synthetic */ void lambda$onFailure$2$WebSocket$1(Throwable th) {
                    if (th instanceof EOFException) {
                        if (WebSocket.this.onclose != null) {
                            WebSocket.this.onclose.call(Integer.valueOf(CloseCodes.CLOSE_NORMAL.getCode()), CloseCodes.CLOSE_NORMAL.name());
                        }
                    } else if (WebSocket.this.onerror != null) {
                        WebSocket.this.onerror.call(new Object[0]);
                    }
                }

                public void onMessage(okhttp3.WebSocket webSocket, String str) {
                    UIThreadUtil.runOnUiThread(new WebSocket$1$$ExternalSyntheticLambda2(this, str));
                }

                public /* synthetic */ void lambda$onMessage$3$WebSocket$1(String str) {
                    if (WebSocket.this.onmessage != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, str);
                        WebSocket.this.onmessage.call(hashMap);
                    }
                }
            };
            if (!(okHttpClient instanceof OkHttpClient)) {
                okHttpClient.newWebSocket(build, r1);
            } else {
                OkHttp3Instrumentation.newWebSocket(okHttpClient, build, r1);
            }
        }
    }

    @JsMethod("close")
    public void close() {
        okhttp3.WebSocket webSocket2 = this.webSocket;
        if (webSocket2 != null) {
            webSocket2.close(CloseCodes.CLOSE_NORMAL.getCode(), CloseCodes.CLOSE_NORMAL.name());
        }
        JSValue jSValue = this.jsValue;
        if (jSValue != null) {
            jSValue.unprotect();
        }
    }

    @JsMethod("send")
    public void send(String str) {
        okhttp3.WebSocket webSocket2 = this.webSocket;
        if (webSocket2 == null) {
            return;
        }
        if (!(webSocket2 instanceof okhttp3.WebSocket)) {
            webSocket2.send(str);
        } else {
            OkHttp3Instrumentation.newSend(webSocket2, str);
        }
    }

    @JsMethod("addEventListener")
    public void addEventListener(String str, JSCallback jSCallback) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case 3417674:
                if (str.equals("open")) {
                    c = 0;
                    break;
                }
                break;
            case 94756344:
                if (str.equals("close")) {
                    c = 1;
                    break;
                }
                break;
            case 96784904:
                if (str.equals(Constants.IPC_BUNDLE_KEY_SEND_ERROR)) {
                    c = 2;
                    break;
                }
                break;
            case 954925063:
                if (str.equals("message")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.onopen = jSCallback;
                return;
            case 1:
                this.onclose = jSCallback;
                return;
            case 2:
                this.onerror = jSCallback;
                return;
            case 3:
                this.onmessage = jSCallback;
                return;
            default:
                return;
        }
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setOnopen(JSCallback jSCallback) {
        this.onopen = jSCallback;
    }

    public void setOnmessage(JSCallback jSCallback) {
        this.onmessage = jSCallback;
    }

    public void setOnclose(JSCallback jSCallback) {
        this.onclose = jSCallback;
    }

    public void setOnerror(JSCallback jSCallback) {
        this.onerror = jSCallback;
    }
}
