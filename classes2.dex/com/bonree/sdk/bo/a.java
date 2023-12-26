package com.bonree.sdk.bo;

import java.net.IDN;

public final class a implements b {
    public final String a(String str) {
        if (com.bonree.sdk.bk.a.a.d.equals(str)) {
            return com.bonree.sdk.bk.a.a.d;
        }
        return IDN.toASCII(str);
    }

    public final String b(String str) {
        return IDN.toUnicode(str);
    }
}
