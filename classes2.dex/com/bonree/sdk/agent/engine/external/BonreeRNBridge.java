package com.bonree.sdk.agent.engine.external;

import com.bonree.sdk.ac.c;
import com.bonree.sdk.af.a;
import com.bonree.sdk.ba.p;
import com.bonree.sdk.d.e;

public class BonreeRNBridge {
    public static void reportAction(long j, int i, String str, String str2, String str3, int i2) {
        c.a(j, i, str, str2, str3, i2);
    }

    public static void reportView(long j, String str, int i, int i2, String str2, String str3) {
        p.a(j, str, i, i2, str2, str3, 0);
    }

    public static void reportCrash(long j, String str, String str2, String str3) {
        a f = e.d().f();
        if (f != null) {
            f.a(j, str, str2, str3);
        }
    }
}
