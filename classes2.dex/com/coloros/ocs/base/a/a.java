package com.coloros.ocs.base.a;

import android.os.Looper;

public final class a {
    public static boolean a() {
        return Looper.getMainLooper() == Looper.myLooper();
    }
}
