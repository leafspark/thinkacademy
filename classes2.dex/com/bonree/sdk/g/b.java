package com.bonree.sdk.g;

import android.content.Intent;
import java.io.Serializable;

public abstract class b implements Serializable {
    private static int A = 15;
    private static int B = 0;
    private static int C = 1;
    private static int D = 0;
    private static int E = 1;
    private static int l = 0;
    private static int m = 1;
    private static int n = 2;
    private static int o = 3;
    private static int p = 4;
    private static int q = 5;
    private static int r = 6;
    private static int s = 7;
    private static int t = 8;
    private static int u = 9;
    private static int v = 10;
    private static int w = 11;
    private static int x = 12;
    private static int y = 13;
    private static int z = 14;
    private int F;
    private String G;
    private int[] H;
    private boolean I;
    protected String a;
    protected String b;
    protected String c;
    protected int d;
    protected int e;
    protected long f;
    protected long g;
    protected String h;
    protected String i;
    protected boolean j;
    protected Intent[] k;

    public enum a {
        SEND_NETWORK(1),
        RECEIVE_NETWORK(2),
        VIEW_CHANGE(3),
        LIFE_CYCLE_ENTER(4),
        LIFE_CYCLE_QUIT(5),
        BITMAP(6),
        DATA_ANALYSIS(7),
        DATA_IO(8),
        START_ASYNC(9),
        TASK_EXEC(10),
        CUSTOM(11),
        TRIGGER_ACTION(12),
        CUSTOM_ACTION_END(15);
        
        private final int a;

        private a(int i) {
            this.a = i;
        }

        public final int a() {
            return this.a;
        }
    }

    public final String a() {
        return this.a;
    }

    public final void a(String str) {
        this.a = str;
    }

    public final String b() {
        return this.b;
    }

    public final void b(String str) {
        this.b = str;
    }

    public final String c() {
        return this.c;
    }

    public final void c(String str) {
        this.c = str;
    }

    public final int d() {
        return this.d;
    }

    public final void a(int i2) {
        this.d = i2;
    }

    public final int e() {
        return this.e;
    }

    public final void b(int i2) {
        this.e = i2;
    }

    public final long f() {
        return this.f;
    }

    public final void a(long j2) {
        this.f = j2;
    }

    public final String g() {
        return this.h;
    }

    public final String h() {
        return this.i;
    }

    public final void d(String str) {
        this.i = str;
    }

    public final boolean i() {
        return this.j;
    }

    public final void a(boolean z2) {
        this.j = z2;
    }

    public final long j() {
        return this.g;
    }

    public final void b(long j2) {
        this.g = j2;
    }

    public final int k() {
        return this.F;
    }

    public final void c(int i2) {
        this.F = i2;
    }

    public final String l() {
        return this.G;
    }

    public final void e(String str) {
        this.G = str;
    }

    public final void f(String str) {
        this.h = str;
    }

    public final Intent[] m() {
        return this.k;
    }

    public final void a(Intent[] intentArr) {
        this.k = intentArr;
    }

    public final int[] n() {
        return this.H;
    }

    public final void a(int[] iArr) {
        this.H = iArr;
    }

    public String o() {
        String str = "";
        try {
            if (this.d == 6) {
                return this.c;
            }
            if (this.c != null) {
                str = str + this.c;
            }
            if (this.h == null) {
                return str;
            }
            return str + this.h;
        } catch (Exception e2) {
            com.bonree.sdk.be.a.a().e("IData getDataKey is error %s.", e2.getMessage());
            return str;
        }
    }

    public final boolean p() {
        return this.I;
    }

    public final void b(boolean z2) {
        this.I = true;
    }
}
