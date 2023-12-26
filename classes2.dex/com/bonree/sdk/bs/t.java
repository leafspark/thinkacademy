package com.bonree.sdk.bs;

import android.util.Log;

public final class t {
    private static void a(String str, String str2) {
        int length = str2.length();
        int i = 2000;
        int i2 = 0;
        int i3 = 0;
        while (i2 < 100) {
            if (length > i) {
                Log.w(str + i2, str2.substring(i3, i));
                i2++;
                i3 = i;
                i += 2000;
            } else {
                Log.w(str, str2.substring(i3, length));
                return;
            }
        }
    }
}
