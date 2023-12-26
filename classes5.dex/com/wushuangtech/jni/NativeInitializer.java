package com.wushuangtech.jni;

import android.content.Context;

public class NativeInitializer {
    private static NativeInitializer instance;

    public native String getVersion();

    public native void initialize(Context context, String str, String str2, int i);

    public native long lastGwToUeID();

    public native long lastUeToGwID();

    public native void setLogLevel(int i);

    public native long signalReconnectTimes();

    private NativeInitializer() {
    }

    public static NativeInitializer getIntance() {
        if (instance == null) {
            synchronized (NativeInitializer.class) {
                if (instance == null) {
                    instance = new NativeInitializer();
                }
            }
        }
        return instance;
    }
}
