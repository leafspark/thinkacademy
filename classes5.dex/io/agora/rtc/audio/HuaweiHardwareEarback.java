package io.agora.rtc.audio;

import android.content.Context;
import io.agora.rtc.internal.Logging;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class HuaweiHardwareEarback implements IHardwareEarback {
    private static final String TAG = "HuaweiHardwareEarback";
    Class clsAudioKitCallback = null;
    Class clsHwAudioKaraokeFeatureKit = null;
    Class clsHwAudioKit = null;
    private int latency = 0;
    private boolean mClsInited = false;
    private Context mContext = null;
    private boolean mEarbackEnabled = false;
    private Object mHwAudioKaraokeFeatureKit = null;
    private Object mHwAudioKit = null;
    /* access modifiers changed from: private */
    public boolean mInited = false;
    private int volume = 0;

    public HuaweiHardwareEarback(Context context) {
        Logging.d(TAG, ">>ctor");
        this.mContext = context;
        initialize();
    }

    public static boolean hasHwAudioKitClass() {
        return (ReflectUtils.safeFindClass("com.huawei.multimedia.audiokit.interfaces.IAudioKitCallback") == null || ReflectUtils.safeFindClass("com.huawei.multimedia.audiokit.interfaces.HwAudioKit") == null || ReflectUtils.safeFindClass("com.huawei.multimedia.audiokit.interfaces.HwAudioKaraokeFeatureKit") == null) ? false : true;
    }

    public void initialize() {
        Constructor constructor;
        if (this.mContext == null) {
            Logging.e(TAG, "mContext is null!");
            return;
        }
        Logging.d(TAG, ">>initialize");
        this.clsHwAudioKit = ReflectUtils.safeFindClass("com.huawei.multimedia.audiokit.interfaces.HwAudioKit");
        this.clsAudioKitCallback = ReflectUtils.safeFindClass("com.huawei.multimedia.audiokit.interfaces.IAudioKitCallback");
        Class safeFindClass = ReflectUtils.safeFindClass("com.huawei.multimedia.audiokit.interfaces.HwAudioKaraokeFeatureKit");
        this.clsHwAudioKaraokeFeatureKit = safeFindClass;
        if (this.clsAudioKitCallback != null && this.clsHwAudioKit != null && safeFindClass != null) {
            Object newProxyInstance = Proxy.newProxyInstance(this.mContext.getClassLoader(), new Class[]{this.clsAudioKitCallback}, new InvocationHandler() {
                public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                    if (!method.getName().equals("onResult")) {
                        return null;
                    }
                    int intValue = objArr[0].intValue();
                    if (intValue == 0) {
                        Logging.i(HuaweiHardwareEarback.TAG, "IAudioKitCallback: HwAudioKit init success");
                        return null;
                    } else if (intValue == 2) {
                        Logging.i(HuaweiHardwareEarback.TAG, "IAudioKitCallback: audio kit not installed");
                        return null;
                    } else if (intValue != 1000) {
                        Logging.e(HuaweiHardwareEarback.TAG, "IAudioKitCallback: onResult error number " + intValue);
                        return null;
                    } else {
                        boolean unused = HuaweiHardwareEarback.this.mInited = true;
                        Logging.i(HuaweiHardwareEarback.TAG, "IAudioKitCallback: HwAudioKaraokeFeatureKit init success ");
                        return null;
                    }
                }
            });
            Method method = null;
            try {
                constructor = this.clsHwAudioKit.getConstructor(new Class[]{Context.class, this.clsAudioKitCallback});
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
                constructor = null;
            }
            if (constructor == null) {
                Logging.e(TAG, "find HwAudioKit constructor failed");
                return;
            }
            try {
                this.mHwAudioKit = constructor.newInstance(new Object[]{this.mContext, newProxyInstance});
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (this.mHwAudioKit == null) {
                Logging.e(TAG, "create HwAudioKit failed");
                return;
            }
            try {
                Method method2 = this.clsHwAudioKit.getMethod("initialize", new Class[0]);
                if (method2 != null) {
                    method2.invoke(this.mHwAudioKit, new Object[0]);
                }
                Class safeFindClass2 = ReflectUtils.safeFindClass("com.huawei.multimedia.audiokit.interfaces.HwAudioKit$FeatureType");
                if (safeFindClass2 == null) {
                    Logging.e(TAG, "cannot find class  HwAudioKit$FeatureType initialize failed");
                    return;
                }
                Object obj = safeFindClass2.isEnum() ? safeFindClass2.getEnumConstants()[0] : null;
                if (obj == null) {
                    Logging.e(TAG, "cannot find class  HwAudioKit$FeatureType initialize failed");
                    return;
                }
                try {
                    method = this.clsHwAudioKit.getMethod("createFeature", new Class[]{safeFindClass2});
                } catch (NoSuchMethodException e3) {
                    e3.printStackTrace();
                }
                if (method == null) {
                    Logging.e(TAG, "cannot find method createFeature ");
                    return;
                }
                try {
                    this.mHwAudioKaraokeFeatureKit = method.invoke(this.mHwAudioKit, new Object[]{obj});
                } catch (IllegalAccessException e4) {
                    e4.printStackTrace();
                } catch (InvocationTargetException e5) {
                    e5.printStackTrace();
                }
                if (this.mHwAudioKaraokeFeatureKit == null) {
                    Logging.e(TAG, " createFeature failed");
                } else {
                    this.mClsInited = true;
                }
            } catch (NoSuchMethodException e6) {
                e6.printStackTrace();
                Logging.e(TAG, "create HwAudioKit initialize failed");
            } catch (IllegalAccessException e7) {
                e7.printStackTrace();
                Logging.e(TAG, "create HwAudioKit initialize failed");
            } catch (InvocationTargetException e8) {
                e8.printStackTrace();
                Logging.e(TAG, "create HwAudioKit initialize failed");
            }
        }
    }

    public boolean isHardwareEarbackSupported() {
        boolean z = false;
        if (this.mInited && this.mClsInited) {
            Logging.d(TAG, ">>isHardwareEarbackSupported");
            try {
                z = ((Boolean) ReflectUtils.safeCallMethod(this.clsHwAudioKaraokeFeatureKit, this.mHwAudioKaraokeFeatureKit, "isKaraokeFeatureSupport", new Class[0], new Object[0])).booleanValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Logging.d(TAG, "isSupported " + z);
        }
        return z;
    }

    public synchronized int setHardwareEarbackVolume(int i) {
        int i2;
        if (this.mInited) {
            if (this.mClsInited) {
                Logging.d(TAG, ">>setHardwareEarbackVolume " + i);
                if (i < 0) {
                    i = 0;
                } else if (i > 100) {
                    i = 100;
                }
                Class safeFindClass = ReflectUtils.safeFindClass("com.huawei.multimedia.audiokit.interfaces.HwAudioKaraokeFeatureKit$ParameName");
                if (safeFindClass == null) {
                    Logging.e(TAG, "cannot find method  ParameName.getParameName");
                    return -1;
                }
                Method safeGetMethod = ReflectUtils.safeGetMethod(safeFindClass, "getParameName", new Class[0]);
                if (safeGetMethod == null) {
                    Logging.e(TAG, "cannot find method  ParameName.getParameName");
                    return -1;
                }
                Object obj = null;
                try {
                    for (Object obj2 : safeFindClass.getEnumConstants()) {
                        Object invoke = safeGetMethod.invoke(obj2, new Object[0]);
                        if (invoke != null && ((String) invoke).equals("Karaoke_volume=")) {
                            obj = obj2;
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e2) {
                    e2.printStackTrace();
                }
                if (obj == null) {
                    Logging.e(TAG, "cannot find object  ParameName.CMD_SET_VOCAL_VOLUME_BASE");
                    return -1;
                }
                try {
                    i2 = ((Integer) ReflectUtils.safeCallMethod(this.clsHwAudioKaraokeFeatureKit, this.mHwAudioKaraokeFeatureKit, "setParameter", new Class[]{safeFindClass, Integer.TYPE}, new Object[]{obj, Integer.valueOf(i)})).intValue();
                } catch (Exception e3) {
                    e3.printStackTrace();
                    i2 = -1;
                }
                if (i2 != 0) {
                    Logging.e(TAG, "setParameter error number " + i2);
                    return -1;
                }
                this.volume = i;
                return 0;
            }
        }
        return -7;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00db, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00dd, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00df, code lost:
        return -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int enableEarbackFeature(boolean r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            boolean r0 = r8.mInited     // Catch:{ all -> 0x00e3 }
            if (r0 == 0) goto L_0x00e0
            boolean r0 = r8.mClsInited     // Catch:{ all -> 0x00e3 }
            if (r0 != 0) goto L_0x000b
            goto L_0x00e0
        L_0x000b:
            java.lang.String r0 = "HuaweiHardwareEarback"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e3 }
            r1.<init>()     // Catch:{ all -> 0x00e3 }
            java.lang.String r2 = ">>enableEarbackFeature "
            r1.append(r2)     // Catch:{ all -> 0x00e3 }
            r1.append(r9)     // Catch:{ all -> 0x00e3 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00e3 }
            io.agora.rtc.internal.Logging.d(r0, r1)     // Catch:{ all -> 0x00e3 }
            java.lang.Class r0 = r8.clsHwAudioKaraokeFeatureKit     // Catch:{ all -> 0x00e3 }
            java.lang.Object r1 = r8.mHwAudioKaraokeFeatureKit     // Catch:{ all -> 0x00e3 }
            java.lang.String r2 = "isKaraokeFeatureSupport"
            r3 = 0
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ all -> 0x00e3 }
            java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch:{ all -> 0x00e3 }
            java.lang.Object r0 = io.agora.rtc.audio.ReflectUtils.safeCallMethod(r0, r1, r2, r4, r5)     // Catch:{ all -> 0x00e3 }
            r1 = -1
            if (r0 == 0) goto L_0x00de
            java.lang.Class r2 = r0.getClass()     // Catch:{ all -> 0x00e3 }
            java.lang.Class<java.lang.Boolean> r4 = java.lang.Boolean.class
            boolean r2 = r2.equals(r4)     // Catch:{ all -> 0x00e3 }
            if (r2 != 0) goto L_0x0041
            goto L_0x00de
        L_0x0041:
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x00e3 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00e3 }
            if (r0 != 0) goto L_0x0052
            java.lang.String r9 = "HuaweiHardwareEarback"
            java.lang.String r0 = "karaoke not supported"
            io.agora.rtc.internal.Logging.e(r9, r0)     // Catch:{ all -> 0x00e3 }
            monitor-exit(r8)
            return r1
        L_0x0052:
            java.lang.Class r0 = r8.clsHwAudioKaraokeFeatureKit     // Catch:{ all -> 0x00e3 }
            java.lang.Object r2 = r8.mHwAudioKaraokeFeatureKit     // Catch:{ all -> 0x00e3 }
            java.lang.String r4 = "enableKaraokeFeature"
            r5 = 1
            java.lang.Class[] r6 = new java.lang.Class[r5]     // Catch:{ all -> 0x00e3 }
            java.lang.Class r7 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x00e3 }
            r6[r3] = r7     // Catch:{ all -> 0x00e3 }
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x00e3 }
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r9)     // Catch:{ all -> 0x00e3 }
            r5[r3] = r7     // Catch:{ all -> 0x00e3 }
            java.lang.Object r0 = io.agora.rtc.audio.ReflectUtils.safeCallMethod(r0, r2, r4, r6, r5)     // Catch:{ all -> 0x00e3 }
            if (r0 == 0) goto L_0x00dc
            java.lang.Class r2 = r0.getClass()     // Catch:{ all -> 0x00e3 }
            java.lang.Class<java.lang.Integer> r4 = java.lang.Integer.class
            boolean r2 = r2.equals(r4)     // Catch:{ all -> 0x00e3 }
            if (r2 != 0) goto L_0x007a
            goto L_0x00dc
        L_0x007a:
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ all -> 0x00e3 }
            int r0 = r0.intValue()     // Catch:{ all -> 0x00e3 }
            if (r0 == 0) goto L_0x009a
            java.lang.String r9 = "HuaweiHardwareEarback"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e3 }
            r2.<init>()     // Catch:{ all -> 0x00e3 }
            java.lang.String r3 = "enableKaraokeFeature failed ret "
            r2.append(r3)     // Catch:{ all -> 0x00e3 }
            r2.append(r0)     // Catch:{ all -> 0x00e3 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x00e3 }
            io.agora.rtc.internal.Logging.e(r9, r0)     // Catch:{ all -> 0x00e3 }
            monitor-exit(r8)
            return r1
        L_0x009a:
            r8.mEarbackEnabled = r9     // Catch:{ all -> 0x00e3 }
            if (r9 == 0) goto L_0x00da
            java.lang.Class r9 = r8.clsHwAudioKaraokeFeatureKit     // Catch:{ all -> 0x00e3 }
            java.lang.Object r0 = r8.mHwAudioKaraokeFeatureKit     // Catch:{ all -> 0x00e3 }
            java.lang.String r1 = "getKaraokeLatency"
            java.lang.Class[] r2 = new java.lang.Class[r3]     // Catch:{ all -> 0x00e3 }
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ all -> 0x00e3 }
            java.lang.Object r9 = io.agora.rtc.audio.ReflectUtils.safeCallMethod(r9, r0, r1, r2, r4)     // Catch:{ all -> 0x00e3 }
            if (r9 == 0) goto L_0x00ba
            java.lang.Class r0 = r9.getClass()     // Catch:{ all -> 0x00e3 }
            java.lang.Class<java.lang.Integer> r1 = java.lang.Integer.class
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x00e3 }
            if (r0 != 0) goto L_0x00c2
        L_0x00ba:
            java.lang.Integer r9 = (java.lang.Integer) r9     // Catch:{ all -> 0x00e3 }
            int r9 = r9.intValue()     // Catch:{ all -> 0x00e3 }
            r8.latency = r9     // Catch:{ all -> 0x00e3 }
        L_0x00c2:
            java.lang.String r9 = "HuaweiHardwareEarback"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e3 }
            r0.<init>()     // Catch:{ all -> 0x00e3 }
            java.lang.String r1 = "latency "
            r0.append(r1)     // Catch:{ all -> 0x00e3 }
            int r1 = r8.latency     // Catch:{ all -> 0x00e3 }
            r0.append(r1)     // Catch:{ all -> 0x00e3 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00e3 }
            io.agora.rtc.internal.Logging.i(r9, r0)     // Catch:{ all -> 0x00e3 }
        L_0x00da:
            monitor-exit(r8)
            return r3
        L_0x00dc:
            monitor-exit(r8)
            return r1
        L_0x00de:
            monitor-exit(r8)
            return r1
        L_0x00e0:
            r9 = -7
            monitor-exit(r8)
            return r9
        L_0x00e3:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.agora.rtc.audio.HuaweiHardwareEarback.enableEarbackFeature(boolean):int");
    }

    public void destroy() {
        Logging.d(TAG, ">>destroy");
        Object obj = this.mHwAudioKaraokeFeatureKit;
        if (obj != null) {
            ReflectUtils.safeCallMethod(this.clsHwAudioKaraokeFeatureKit, obj, "destroy", new Class[0], new Object[0]);
        }
        Object obj2 = this.mHwAudioKit;
        if (obj2 != null) {
            ReflectUtils.safeCallMethod(this.clsHwAudioKit, obj2, "destroy", new Class[0], new Object[0]);
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        Logging.d(TAG, ">>finalize");
        destroy();
        super.finalize();
    }
}
