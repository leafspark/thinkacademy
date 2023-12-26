package com.bonree.sdk.h;

import android.os.IBinder;
import android.text.TextUtils;
import com.bonree.sdk.h.b;
import com.bonree.sdk.i.i;

public final class h implements i.b {
    private static final String a = "WakeLockListener";

    public final void a(IBinder iBinder, String str) {
        if (!TextUtils.isEmpty(str)) {
            b.a.a.a(d.WAKELOCK, 1, System.identityHashCode(iBinder));
        }
    }

    public final void a(IBinder iBinder) {
        b.a.a.a(d.WAKELOCK, 2, System.identityHashCode(iBinder));
    }
}
