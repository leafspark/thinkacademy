package io.agora.rtc.audio;

import android.content.Context;
import io.agora.rtc.internal.Logging;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class OppoHardwareEarback implements IHardwareEarback {
    private static String TAG = "AG-OPPO";
    /* access modifiers changed from: private */
    public Class clsMediaClient;
    private Class clsMediaUnit;
    private Class clsOnConnectionSucceedListener;
    /* access modifiers changed from: private */
    public boolean isConnected = false;
    private boolean mClsInited = false;
    /* access modifiers changed from: private */
    public Context mContext = null;

    public int setHardwareEarbackVolume(int i) {
        return 0;
    }

    public OppoHardwareEarback(Context context) {
        this.mContext = context;
        initialize();
    }

    public static boolean hasMediaUnitClass() {
        return (ReflectUtils.safeFindClass("com.coloros.ocs.mediaunit.MediaUnitClient") == null || ReflectUtils.safeFindClass("com.coloros.ocs.mediaunit.MediaUnit") == null || ReflectUtils.safeFindClass("com.coloros.ocs.base.common.api.OnConnectionSucceedListener") == null) ? false : true;
    }

    public void initialize() {
        Class cls;
        Object safeCallMethod;
        this.clsMediaUnit = ReflectUtils.safeFindClass("com.coloros.ocs.mediaunit.MediaUnit");
        this.clsMediaClient = ReflectUtils.safeFindClass("com.coloros.ocs.mediaunit.MediaUnitClient");
        Class safeFindClass = ReflectUtils.safeFindClass("com.coloros.ocs.base.common.api.OnConnectionSucceedListener");
        this.clsOnConnectionSucceedListener = safeFindClass;
        if (this.clsMediaClient != null && (cls = this.clsMediaUnit) != null && safeFindClass != null) {
            this.mClsInited = true;
            try {
                Context context = this.mContext;
                if (context != null && (safeCallMethod = ReflectUtils.safeCallMethod(cls, (Object) null, "getMediaClient", new Class[]{Context.class}, new Object[]{context})) != null) {
                    Object newProxyInstance = Proxy.newProxyInstance(this.mContext.getClassLoader(), new Class[]{this.clsOnConnectionSucceedListener}, new InvocationHandler() {
                        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                            if (!method.getName().equals("onConnectionSucceed")) {
                                return null;
                            }
                            boolean unused = OppoHardwareEarback.this.isConnected = true;
                            return null;
                        }
                    });
                    ReflectUtils.safeCallMethod(this.clsMediaClient, safeCallMethod, "addOnConnectionSucceedListener", new Class[]{this.clsOnConnectionSucceedListener}, new Object[]{newProxyInstance});
                }
            } catch (Exception e) {
                Logging.e(e.getMessage());
            }
        }
    }

    public boolean isHardwareEarbackSupported() {
        return this.isConnected && this.mClsInited;
    }

    public int enableEarbackFeature(boolean z) {
        if (!this.mClsInited) {
            return -1;
        }
        try {
            Context context = this.mContext;
            if (context != null && this.isConnected) {
                final Object safeCallMethod = ReflectUtils.safeCallMethod(this.clsMediaUnit, (Object) null, "getMediaClient", new Class[]{Context.class}, new Object[]{context});
                if (z) {
                    if (safeCallMethod != null) {
                        Object newProxyInstance = Proxy.newProxyInstance(this.mContext.getClassLoader(), new Class[]{this.clsOnConnectionSucceedListener}, new InvocationHandler() {
                            public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                                if (!method.getName().equals("onConnectionSucceed") || OppoHardwareEarback.this.mContext == null) {
                                    return null;
                                }
                                ReflectUtils.safeCallMethod(OppoHardwareEarback.this.clsMediaClient, safeCallMethod, "requestAudioLoopback", new Class[0], new Object[0]);
                                return null;
                            }
                        });
                        ReflectUtils.safeCallMethod(this.clsMediaClient, safeCallMethod, "addOnConnectionSucceedListener", new Class[]{this.clsOnConnectionSucceedListener}, new Object[]{newProxyInstance});
                    }
                } else if (safeCallMethod != null) {
                    Object newProxyInstance2 = Proxy.newProxyInstance(this.mContext.getClassLoader(), new Class[]{this.clsOnConnectionSucceedListener}, new InvocationHandler() {
                        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                            if (!method.getName().equals("onConnectionSucceed") || OppoHardwareEarback.this.mContext == null) {
                                return null;
                            }
                            ReflectUtils.safeCallMethod(OppoHardwareEarback.this.clsMediaClient, safeCallMethod, "abandonAudioLoopback", new Class[0], new Object[0]);
                            return null;
                        }
                    });
                    ReflectUtils.safeCallMethod(this.clsMediaClient, safeCallMethod, "addOnConnectionSucceedListener", new Class[]{this.clsOnConnectionSucceedListener}, new Object[]{newProxyInstance2});
                }
                return 0;
            }
        } catch (Exception e) {
            Logging.e(e.getMessage());
        }
        return -1;
    }

    public void destroy() {
        Object safeCallMethod;
        if (this.mClsInited) {
            try {
                Context context = this.mContext;
                if (context != null && (safeCallMethod = ReflectUtils.safeCallMethod(this.clsMediaUnit, (Object) null, "getMediaClient", new Class[]{Context.class}, new Object[]{context})) != null) {
                    ReflectUtils.safeCallMethod(this.clsMediaClient, safeCallMethod, "release", new Class[0], new Object[0]);
                }
            } catch (Exception e) {
                Logging.e(e.getMessage());
            }
        }
    }
}
