package com.tal.app.thinkacademy.lib.logger;

import android.util.Log;

public class XesConsolePrinter implements XesLogPrinter {
    public void print(XesLogConfig xesLogConfig, int i, String str, String str2) {
        int length = str2.length();
        int i2 = length / XesLogConfig.MAX_LEN;
        if (i2 > 0) {
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                Log.println(i, str, str2.substring(i3, XesLogConfig.MAX_LEN + i3));
                i3 += XesLogConfig.MAX_LEN;
            }
            if (i3 != length) {
                Log.println(i, str, str2.substring(i3, length));
                return;
            }
            return;
        }
        Log.println(i, str, str2);
    }
}
