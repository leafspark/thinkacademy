package com.igexin.sdk.a;

import com.igexin.push.core.stub.PushCore;
import com.igexin.sdk.IPushCore;

public class a {
    private static a b;
    private IPushCore a;

    private a() {
    }

    public static a a() {
        if (b == null) {
            b = new a();
        }
        return b;
    }

    public void b() {
        this.a = new PushCore();
    }

    public IPushCore c() {
        return this.a;
    }
}
