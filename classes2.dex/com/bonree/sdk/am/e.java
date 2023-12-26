package com.bonree.sdk.am;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class e {
    private static final int a = 100;
    private final List<a> b = Collections.synchronizedList(new ArrayList());

    public final void a(int i, int i2, int i3) {
        this.b.add(new a(i, i2, i3));
    }

    public final void a(int i, int i2) {
        if (this.b.size() > i && i >= 0) {
            this.b.get(i).a(i2);
        }
    }

    public final boolean a() {
        return this.b.size() > 0;
    }

    public final int b() {
        double d = 0.0d;
        double d2 = 0.0d;
        for (a next : this.b) {
            if (next.b > 0 && next.c - next.a > 0) {
                d += (double) next.b;
                d2 += (double) (next.c - next.a);
            }
        }
        double d3 = d > 0.0d ? (d2 / d) * 100.0d : 0.0d;
        if (d3 > 100.0d) {
            return 100;
        }
        if (d3 < 0.0d) {
            return 0;
        }
        return (int) d3;
    }

    static class a {
        /* access modifiers changed from: private */
        public final int a;
        /* access modifiers changed from: private */
        public final int b;
        /* access modifiers changed from: private */
        public int c;

        a(int i, int i2, int i3) {
            this.a = i;
            this.b = i2 - i;
            this.c = i3;
        }

        public final void a(int i) {
            this.c = i;
        }
    }

    public static e c() {
        return b.a;
    }

    static class b {
        /* access modifiers changed from: private */
        public static final e a = new e();

        private b() {
        }
    }
}
