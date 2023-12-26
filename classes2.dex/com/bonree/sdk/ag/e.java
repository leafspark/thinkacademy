package com.bonree.sdk.ag;

import java.io.Serializable;

public final class e implements Serializable {
    /* access modifiers changed from: private */
    public String a;
    /* access modifiers changed from: private */
    public StackTraceElement[] b;

    e(String str, StackTraceElement[] stackTraceElementArr) {
        this.a = str;
        this.b = stackTraceElementArr;
    }

    class a extends Throwable {
        a(a aVar) {
            super(e.this.a, aVar);
        }

        public final synchronized Throwable fillInStackTrace() {
            setStackTrace(e.this.b);
            return this;
        }
    }
}
