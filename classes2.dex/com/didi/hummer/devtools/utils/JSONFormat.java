package com.didi.hummer.devtools.utils;

public class JSONFormat {
    public static String format(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (str == null || str.isEmpty()) {
            return null;
        }
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < str.length(); i3++) {
            char charAt = str.charAt(i3);
            if (charAt == '{' || charAt == '[') {
                i2 += 4;
                sb.insert(i3 + i + 1, "\n" + generateBlank(i2));
            } else if (charAt == ',') {
                sb.insert(i3 + i + 1, "\n" + generateBlank(i2));
            } else if (charAt == '}' || charAt == ']') {
                i2 -= 4;
                sb.insert(i3 + i, "\n" + generateBlank(i2));
            }
            i += i2 + 1;
        }
        return sb.toString();
    }

    private static String generateBlank(int i) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
