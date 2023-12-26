package com.didi.hummer.render.utility;

public class YogaColorUtils {
    public static int getOpacityFromColor(int i) {
        int i2 = i >>> 24;
        if (i2 == 255) {
            return -1;
        }
        return i2 == 0 ? -2 : -3;
    }

    public static int multiplyColorAlpha(int i, int i2) {
        if (i2 == 255) {
            return i;
        }
        if (i2 == 0) {
            return i & FlexItem.MAX_SIZE;
        }
        int i3 = i2 + (i2 >> 7);
        return (i & FlexItem.MAX_SIZE) | ((((i >>> 24) * i3) >> 8) << 24);
    }

    public static int rgba2argb(int i) {
        return ((i >> 8) & FlexItem.MAX_SIZE) | (i << 24);
    }
}
