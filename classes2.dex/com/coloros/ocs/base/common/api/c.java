package com.coloros.ocs.base.common.api;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.coloros.ocs.base.a.b;
import com.coloros.ocs.base.common.AuthResult;
import com.coloros.ocs.base.common.ConnectionResult;
import com.coloros.ocs.base.common.a;
import com.coloros.ocs.base.common.api.Api;
import com.coloros.ocs.base.common.api.Api.ApiOptions;
import com.coloros.ocs.base.common.constant.CommonStatusCodes;
import com.coloros.ocs.base.internal.ClientSettings;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class c<O extends Api.ApiOptions> implements Handler.Callback {
    private static volatile c d;
    private static Map<Api.ClientKey, ColorApiClient> e = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    public static Map<Api.ClientKey, ColorApiClient> f = new ConcurrentHashMap();
    a a = new a(this.c, this);
    private Context b;
    private Looper c;

    public static c a(Context context) {
        if (d == null) {
            synchronized (c.class) {
                if (d == null) {
                    HandlerThread handlerThread = new HandlerThread("ColorApiManager", 9);
                    handlerThread.start();
                    d = new c(context, handlerThread.getLooper());
                }
            }
        }
        return d;
    }

    private c(Context context, Looper looper) {
        this.b = context.getApplicationContext();
        this.c = looper;
    }

    /* access modifiers changed from: package-private */
    public final void a(final ColorApi colorApi, ClientSettings clientSettings) {
        com.coloros.ocs.base.a.c.a(colorApi, (Object) "colorApi not be null");
        com.coloros.ocs.base.a.c.a(clientSettings, (Object) "clientsettings not be null");
        if (!e.containsKey(colorApi.getApi().getClientKey())) {
            b.b("ColorApiManager", "addColorClient");
            final d dVar = new d(this.b, colorApi.getApi(), colorApi.a, clientSettings);
            dVar.setOnClearListener(new e() {
                public final void a() {
                    c.a((Api.ClientKey) colorApi.getApi().getClientKey());
                    c.f.put(colorApi.getApi().getClientKey(), dVar);
                }
            });
            b.a("TAG", "getClientKey " + colorApi.getApi().getClientKey());
            e.put(colorApi.getApi().getClientKey(), dVar);
            b.b("ColorApiManager", "handlerConnect");
            Message obtainMessage = this.a.obtainMessage();
            obtainMessage.what = 0;
            obtainMessage.obj = colorApi;
            this.a.sendMessage(obtainMessage);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(ColorApi colorApi, final OnConnectionSucceedListener onConnectionSucceedListener, Handler handler) {
        ColorApiClient colorApiClient;
        com.coloros.ocs.base.a.c.a(colorApi, (Object) "colorApi not be null");
        if (e.containsKey(colorApi.getApi().getClientKey()) && (colorApiClient = e.get(colorApi.getApi().getClientKey())) != null) {
            if (colorApi.isConnected()) {
                AnonymousClass2 r5 = new Handler(handler == null ? Looper.getMainLooper() : handler.getLooper()) {
                    public final void handleMessage(Message message) {
                        AsynchronousInstrumentation.handlerMessageBegin(this, message);
                        super.handleMessage(message);
                        onConnectionSucceedListener.onConnectionSucceed();
                        AsynchronousInstrumentation.handlerMessageEnd();
                    }
                };
                if (!(r5 instanceof Handler)) {
                    r5.sendEmptyMessage(0);
                } else {
                    AsynchronousInstrumentation.sendEmptyMessage(r5, 0);
                }
            } else {
                colorApiClient.setOnConnectionSucceedListener(onConnectionSucceedListener, handler);
            }
        }
    }

    static void a(ColorApi colorApi, OnConnectionFailedListener onConnectionFailedListener, Handler handler) {
        ColorApiClient colorApiClient;
        com.coloros.ocs.base.a.c.a(colorApi, (Object) "colorApi not be null");
        if (e.containsKey(colorApi.getApi().getClientKey())) {
            ColorApiClient colorApiClient2 = e.get(colorApi.getApi().getClientKey());
            if (colorApiClient2 != null) {
                colorApiClient2.setOnConnectionFailedListener(onConnectionFailedListener, handler);
            }
        } else if (f.containsKey(colorApi.getApi().getClientKey()) && (colorApiClient = f.get(colorApi.getApi().getClientKey())) != null && onConnectionFailedListener != null) {
            onConnectionFailedListener.onConnectionFailed(new ConnectionResult(a(colorApiClient)));
        }
    }

    private static int a(ColorApiClient colorApiClient) {
        if (colorApiClient.getAuthResult() != null) {
            return colorApiClient.getAuthResult().getErrrorCode();
        }
        return -1;
    }

    static IBinder a(ColorApi colorApi) {
        ColorApiClient colorApiClient;
        com.coloros.ocs.base.a.c.a(colorApi, (Object) "colorApi not be null");
        if (!e.containsKey(colorApi.getApi().getClientKey()) || (colorApiClient = e.get(colorApi.getApi().getClientKey())) == null) {
            return null;
        }
        return colorApiClient.getRemoteService();
    }

    static int b(ColorApi colorApi) {
        ColorApiClient colorApiClient;
        com.coloros.ocs.base.a.c.a(colorApi, (Object) "colorApi not be null");
        if (!e.containsKey(colorApi.getApi().getClientKey()) || (colorApiClient = e.get(colorApi.getApi().getClientKey())) == null) {
            return 0;
        }
        return colorApiClient.getRemoteVersion();
    }

    static AuthResult c(ColorApi colorApi) {
        ColorApiClient colorApiClient;
        com.coloros.ocs.base.a.c.a(colorApi, (Object) "colorApi not be null");
        if (!e.containsKey(colorApi.getApi().getClientKey()) || (colorApiClient = e.get(colorApi.getApi().getClientKey())) == null) {
            return null;
        }
        return colorApiClient.getAuthResult();
    }

    static boolean d(ColorApi colorApi) {
        ColorApiClient colorApiClient;
        com.coloros.ocs.base.a.c.a(colorApi, (Object) "colorApi not be null");
        if (!e.containsKey(colorApi.getApi().getClientKey()) || (colorApiClient = e.get(colorApi.getApi().getClientKey())) == null) {
            return false;
        }
        return colorApiClient.isConnected();
    }

    static <T> void a(ColorApi colorApi, TaskListenerHolder<T> taskListenerHolder) {
        ColorApiClient colorApiClient;
        b.b("ColorApiManager", "addQueue " + colorApi.getClass().getSimpleName());
        com.coloros.ocs.base.a.c.a(colorApi, (Object) "colorApi not be null");
        if (e.containsKey(colorApi.getApi().getClientKey())) {
            ColorApiClient colorApiClient2 = e.get(colorApi.getApi().getClientKey());
            if (colorApiClient2 != null) {
                colorApiClient2.addQueue(taskListenerHolder);
            }
        } else if (f.containsKey(colorApi.getApi().getClientKey()) && (colorApiClient = f.get(colorApi.getApi().getClientKey())) != null && taskListenerHolder.getFailureNotifier() != null) {
            int a2 = a(colorApiClient);
            taskListenerHolder.getFailureNotifier().onNotifyListenerFailed(taskListenerHolder.getTask(), a2, CommonStatusCodes.getStatusCodeString(a2));
        }
    }

    static void a(Api.ClientKey clientKey) {
        e.remove(clientKey);
    }

    static void b(Api.ClientKey clientKey) {
        f.remove(clientKey);
    }

    public boolean handleMessage(Message message) {
        ColorApiClient colorApiClient;
        ColorApi colorApi;
        ColorApiClient colorApiClient2;
        b.b("ColorApiManager", "handle message " + message.what);
        int i = message.what;
        if (i == 0) {
            b.b("ColorApiManager", "handle connect");
            ColorApi colorApi2 = (ColorApi) message.obj;
            if (colorApi2 == null || colorApi2.getApi().getClientKey() == null || (colorApiClient = e.get(colorApi2.getApi().getClientKey())) == null) {
                return false;
            }
            b.a("ColorApiManager", "colorApiClient is not null,will connect");
            colorApiClient.connect();
            return false;
        } else if (i != 1 || (colorApi = (ColorApi) message.obj) == null || colorApi.getApi().getClientKey() == null || (colorApiClient2 = e.get(colorApi.getApi().getClientKey())) == null) {
            return false;
        } else {
            b.a("ColorApiManager", "colorApiClient is not null,will disconnect");
            colorApiClient2.disconnect();
            a((Api.ClientKey) colorApi.getApi().getClientKey());
            b((Api.ClientKey) colorApi.getApi().getClientKey());
            return false;
        }
    }
}
