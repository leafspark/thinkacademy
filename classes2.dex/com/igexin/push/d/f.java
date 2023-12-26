package com.igexin.push.d;

import com.igexin.assist.control.fcm.GTJobService;
import com.igexin.b.a.c.b;
import com.igexin.push.core.d;
import com.igexin.push.util.a;

public class f implements i {
    public long a() {
        long j;
        long j2;
        long j3;
        boolean a = a.a(System.currentTimeMillis());
        boolean b = a.b();
        d.i = a.h();
        b.a("NormalModel|isPushOn = " + d.k + " checkIsSilentTime = " + a + " isBlockEndTime = " + b + " isNetworkAvailable = " + d.i, new Object[0]);
        if (!d.i || !d.k || a || !b) {
            b.a("NormalModel|reconnect stop, interval= 20min ++++", new Object[0]);
            d.G = 1200000;
            return 1200000;
        }
        if (d.F <= 0) {
            j3 = 100;
        } else {
            if (d.F <= 10000) {
                j = d.F;
                j2 = 500;
            } else if (d.F <= GTJobService.WAIT_TIME) {
                j = d.F;
                j2 = 1500;
            } else {
                j = d.F;
                j2 = 120000;
            }
            j3 = j + j2;
        }
        d.F = j3;
        if (d.F > 1200000) {
            d.F = 1200000;
        }
        long j4 = d.F;
        b.a("NormalModel|after add auto reconnect delay time = " + j4, new Object[0]);
        d.G = j4;
        return j4;
    }
}
