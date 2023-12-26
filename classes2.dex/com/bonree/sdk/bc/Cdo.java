package com.bonree.sdk.bc;

import java.io.IOException;

/* renamed from: com.bonree.sdk.bc.do  reason: invalid class name */
public class Cdo extends IOException {
    public Cdo() {
    }

    public Cdo(String str) {
        super(str);
    }

    public Cdo(String str, Throwable th) {
        super(str);
        initCause(th);
    }
}
