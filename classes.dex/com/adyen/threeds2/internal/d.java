package com.adyen.threeds2.internal;

import android.text.TextUtils;
import atd.r0.g;
import atd.s0.a;

public enum d {
    V2_1_0(a.a(-105092218677824L), atd.h.a.V1_4),
    V2_2_0(a.a(-105487355669056L), atd.h.a.V1_4);
    
    private final atd.h.a mDataVersion;
    private final String mVersion;

    private d(String str, atd.h.a aVar) {
        this.mVersion = str;
        this.mDataVersion = aVar;
    }

    public static d[] a() {
        return values();
    }

    public static d b(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (d dVar : values()) {
                if (dVar.c().equals(str)) {
                    return dVar;
                }
            }
        }
        throw atd.y.a.MESSAGE_VERSION.a();
    }

    public String c() {
        return a(this.mVersion);
    }

    public String toString() {
        return c();
    }

    private String a(String str) {
        return g.a(str);
    }

    public atd.h.a b() {
        return this.mDataVersion;
    }
}
