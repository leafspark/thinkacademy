package com.bonree.sdk.f;

import java.io.InputStream;
import java.util.Properties;

public class a {
    private int a;
    private boolean b;

    /* synthetic */ a(byte b2) {
        this();
    }

    private a() {
        this.a = 0;
        this.b = false;
        try {
            InputStream open = com.bonree.sdk.bs.a.a().getAssets().open("bonree_make_data.properties");
            Properties properties = new Properties();
            properties.load(open);
            this.b = Boolean.parseBoolean(properties.getProperty("make_data_open"));
        } catch (Throwable unused) {
        }
    }

    private static a a() {
        return C0020a.a;
    }

    private int b() {
        return this.a;
    }

    private void a(int i) {
        if (i >= 0) {
            this.a = i;
        }
    }

    private void c() {
        this.a = 0;
    }

    private boolean d() {
        int i = this.a;
        if (i <= 0) {
            this.a = 1;
            return true;
        }
        this.a = i + 1;
        return true;
    }

    private boolean e() {
        int i = this.a - 1;
        this.a = i;
        if (i >= 0) {
            return true;
        }
        this.a = 0;
        return false;
    }

    private boolean f() {
        return this.b && this.a != 0;
    }

    /* renamed from: com.bonree.sdk.f.a$a  reason: collision with other inner class name */
    static class C0020a {
        /* access modifiers changed from: private */
        public static final a a = new a((byte) 0);

        private C0020a() {
        }
    }
}
