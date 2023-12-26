package com.igexin.push.config;

import com.igexin.push.core.d;

public class j {
    private static j a;

    private j() {
    }

    public static synchronized j a() {
        j jVar;
        synchronized (j.class) {
            if (a == null) {
                a = new j();
            }
            jVar = a;
        }
        return jVar;
    }

    public boolean b() {
        m.a();
        m.a(d.g);
        return true;
    }
}
