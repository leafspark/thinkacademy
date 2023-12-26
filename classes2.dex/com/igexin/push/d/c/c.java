package com.igexin.push.d.c;

import com.bumptech.glide.load.Key;
import com.igexin.b.a.d.a;

public abstract class c extends a {
    public int i;
    public byte j;
    public byte k = 11;

    /* access modifiers changed from: protected */
    public int a(String str) {
        if (str.equals(Key.STRING_CHARSET_NAME)) {
            return 1;
        }
        if (str.equals("UTF-16")) {
            return 2;
        }
        if (str.equals("UTF-16BE")) {
            return 16;
        }
        if (str.equals("UTF-16LE")) {
            return 17;
        }
        if (str.equals("GBK")) {
            return 25;
        }
        if (str.equals("GB2312")) {
            return 26;
        }
        if (str.equals("GB18030")) {
            return 27;
        }
        return str.equals("ISO-8859-1") ? 33 : 1;
    }

    /* access modifiers changed from: protected */
    public String a(byte b) {
        byte b2 = b & 63;
        if (b2 == 1) {
            return Key.STRING_CHARSET_NAME;
        }
        if (b2 == 2) {
            return "UTF-16";
        }
        if (b2 == 16) {
            return "UTF-16BE";
        }
        if (b2 == 17) {
            return "UTF-16LE";
        }
        if (b2 == 33) {
            return "ISO-8859-1";
        }
        switch (b2) {
            case 25:
                return "GBK";
            case 26:
                return "GB2312";
            case 27:
                return "GB18030";
            default:
                return Key.STRING_CHARSET_NAME;
        }
    }

    public abstract void a(byte[] bArr);

    public int b_() {
        return this.i;
    }

    public abstract byte[] c();
}
