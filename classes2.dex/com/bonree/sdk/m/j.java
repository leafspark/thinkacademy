package com.bonree.sdk.m;

import android.text.TextUtils;
import com.bonree.sdk.agent.business.util.c;
import com.bonree.sdk.be.g;
import com.bonree.sdk.n.b;

public class j {
    public static void a(b bVar, String str, int i, int i2) {
        if (str != null && !str.equals("")) {
            bVar.b(str);
        }
        if (i >= 0) {
            bVar.d((long) i);
        }
        bVar.a(i2);
    }

    public static void a(b bVar, String str) {
        if (!TextUtils.isEmpty(str)) {
            bVar.c(str);
        }
    }

    public static void a(b bVar, Exception exc) {
        c.a(bVar, exc);
        g.b("TransactionStateUtil: Attempting to convert network exception " + exc.getClass().getName() + " to error code.");
    }

    public static void a(b bVar, Throwable th) {
        c.a(bVar, th);
        g.b("TransactionStateUtil: Attempting to convert network exception " + th.getClass().getName() + " to error code.");
    }
}
