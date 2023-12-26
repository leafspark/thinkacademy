package com.didi.hummer.devtools.ws;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.bonree.sdk.agent.engine.external.OkHttp3Instrumentation;
import com.huawei.multimedia.audiokit.config.ResultCode;
import java.util.HashMap;
import java.util.Map;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

public class WebSocketManager {
    private static final int RECONNECT_DELAY_MS = 2000;
    private static OkHttpClient client;
    private static volatile WebSocketManager instance;
    /* access modifiers changed from: private */
    public boolean mClosed;
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler(Looper.getMainLooper());
    private boolean mIsReconnectWaiting;
    private String mWsUrl;
    /* access modifiers changed from: private */
    public WebSocket webSocket;
    /* access modifiers changed from: private */
    public Map<String, WSMsgListener> wsMsgListeners = new HashMap();

    public interface WSMsgListener {
        void onMsgReceived(String str);
    }

    public static WebSocketManager getInstance() {
        if (instance == null) {
            synchronized (WebSocketManager.class) {
                if (instance == null) {
                    instance = new WebSocketManager();
                }
            }
        }
        return instance;
    }

    private WebSocketManager() {
        if (client == null) {
            client = OkHttp3Instrumentation.init();
        }
    }

    public void connect(String str, WSMsgListener wSMsgListener) {
        if (!this.wsMsgListeners.containsKey(str)) {
            this.wsMsgListeners.put(str, wSMsgListener);
        }
        if (this.webSocket == null) {
            this.mWsUrl = toWSUrl(str);
            doConnect();
        }
    }

    private void doConnect() {
        if (!TextUtils.isEmpty(this.mWsUrl)) {
            Request build = new Request.Builder().url(this.mWsUrl).build();
            OkHttpClient okHttpClient = client;
            AnonymousClass1 r2 = new WebSocketListener() {
                public void onOpen(WebSocket webSocket, Response response) {
                    WebSocket unused = WebSocketManager.this.webSocket = webSocket;
                }

                public void onClosed(WebSocket webSocket, int i, String str) {
                    if (!WebSocketManager.this.mClosed) {
                        WebSocketManager.this.reconnect();
                    }
                }

                public void onFailure(WebSocket webSocket, Throwable th, Response response) {
                    th.printStackTrace();
                    if (!WebSocketManager.this.mClosed) {
                        WebSocketManager.this.reconnect();
                    }
                }

                public void onMessage(WebSocket webSocket, String str) {
                    Handler access$300 = WebSocketManager.this.mHandler;
                    WebSocketManager$1$$ExternalSyntheticLambda0 webSocketManager$1$$ExternalSyntheticLambda0 = new WebSocketManager$1$$ExternalSyntheticLambda0(this, str);
                    if (!(access$300 instanceof Handler)) {
                        access$300.post(webSocketManager$1$$ExternalSyntheticLambda0);
                    } else {
                        AsynchronousInstrumentation.handlerPost(access$300, webSocketManager$1$$ExternalSyntheticLambda0);
                    }
                }

                public /* synthetic */ void lambda$onMessage$0$WebSocketManager$1(String str) {
                    for (String str2 : WebSocketManager.this.wsMsgListeners.keySet()) {
                        WSMsgListener wSMsgListener = (WSMsgListener) WebSocketManager.this.wsMsgListeners.get(str2);
                        if (wSMsgListener != null) {
                            wSMsgListener.onMsgReceived(str);
                        }
                    }
                }
            };
            if (!(okHttpClient instanceof OkHttpClient)) {
                okHttpClient.newWebSocket(build, r2);
            } else {
                OkHttp3Instrumentation.newWebSocket(okHttpClient, build, r2);
            }
        }
    }

    /* access modifiers changed from: private */
    public void reconnect() {
        if (!this.mClosed && !this.mIsReconnectWaiting) {
            this.mIsReconnectWaiting = true;
            this.mHandler.postDelayed(new WebSocketManager$$ExternalSyntheticLambda0(this), 2000);
        }
    }

    public /* synthetic */ void lambda$reconnect$0$WebSocketManager() {
        if (!this.mClosed) {
            doConnect();
        }
        this.mIsReconnectWaiting = false;
    }

    public void sendMsg(String str) {
        WebSocket webSocket2 = this.webSocket;
        if (webSocket2 == null) {
            return;
        }
        if (!(webSocket2 instanceof WebSocket)) {
            webSocket2.send(str);
        } else {
            OkHttp3Instrumentation.newSend(webSocket2, str);
        }
    }

    public void release(String str) {
        this.wsMsgListeners.remove(str);
    }

    private void close() {
        this.mClosed = true;
        WebSocket webSocket2 = this.webSocket;
        if (webSocket2 != null) {
            try {
                webSocket2.close(ResultCode.KARAOKE_SUCCESS, "End of session");
            } catch (Exception unused) {
            }
            this.webSocket = null;
        }
    }

    private String toWSUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String lowerCase = str.toLowerCase();
        if (lowerCase.startsWith("http://")) {
            Uri parse = Uri.parse(lowerCase);
            return "ws://" + parse.getAuthority() + "/proxy/native";
        } else if (lowerCase.startsWith("ws://")) {
            return lowerCase;
        } else {
            return null;
        }
    }
}
