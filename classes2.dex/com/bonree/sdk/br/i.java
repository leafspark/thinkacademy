package com.bonree.sdk.br;

import com.bonree.sdk.bk.a;

public final class i {
    private static boolean a(String str, String str2) {
        if (str == str2) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2) || a.a(str).compareTo(a.a(str2)) == 0;
    }
}
