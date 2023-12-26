package com.igexin.b.a.b;

import com.bonree.sdk.common.json.HTTP;
import java.io.OutputStream;

public class a extends OutputStream {
    private OutputStream a = null;
    private int b = 0;
    private int c = 0;
    private int d = 0;
    private int e = 0;

    public a(OutputStream outputStream, int i) {
        this.a = outputStream;
        this.e = i;
    }

    /* access modifiers changed from: protected */
    public void a() {
        if (this.c > 0) {
            int i = this.e;
            if (i > 0 && this.d == i) {
                this.a.write(HTTP.CRLF.getBytes());
                this.d = 0;
            }
            char charAt = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((this.b << 8) >>> 26);
            char charAt2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((this.b << 14) >>> 26);
            char c2 = '=';
            char charAt3 = this.c < 2 ? '=' : "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((this.b << 20) >>> 26);
            if (this.c >= 3) {
                c2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((this.b << 26) >>> 26);
            }
            this.a.write(charAt);
            this.a.write(charAt2);
            this.a.write(charAt3);
            this.a.write(c2);
            this.d += 4;
            this.c = 0;
            this.b = 0;
        }
    }

    public void close() {
        a();
        this.a.close();
    }

    public void write(int i) {
        int i2 = this.c;
        this.b = ((i & 255) << (16 - (i2 * 8))) | this.b;
        int i3 = i2 + 1;
        this.c = i3;
        if (i3 == 3) {
            a();
        }
    }
}
