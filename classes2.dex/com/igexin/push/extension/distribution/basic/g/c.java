package com.igexin.push.extension.distribution.basic.g;

import java.util.regex.Pattern;

public class c {
    public static int a(String str, String str2) {
        try {
            Pattern compile = Pattern.compile("([a-zA-Z_-])*");
            String[] split = str.split("\\.");
            String[] split2 = str2.split("\\.");
            if (split.length < 4 || split2.length < 4) {
                return -1;
            }
            split[3] = compile.matcher(split[3]).replaceAll("");
            split2[3] = compile.matcher(split2[3]).replaceAll("");
            long j = 0;
            int i = 0;
            long j2 = 0;
            while (true) {
                long j3 = 1;
                if (i >= 4) {
                    break;
                }
                for (int i2 = 0; i2 < 3 - i; i2++) {
                    j3 *= 100;
                }
                long parseLong = Long.parseLong(split[i]);
                Long.signum(parseLong);
                j2 += parseLong * j3;
                i++;
            }
            for (int i3 = 0; i3 < 4; i3++) {
                long j4 = 1;
                for (int i4 = 0; i4 < 3 - i3; i4++) {
                    j4 *= 100;
                }
                j += Long.parseLong(split2[i3]) * j4;
            }
            int i5 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
            if (i5 > 0) {
                return 1;
            }
            return i5 == 0 ? 0 : -1;
        } catch (Exception unused) {
            return -1;
        }
    }
}
