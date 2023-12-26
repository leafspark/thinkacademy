package com.xueersi.lib.graffiti.utils;

public class ColorUtil {
    public static int alphaInt(int i) {
        return (i >> 24) & 255;
    }

    public static float alpha(int i) {
        return ((float) alphaInt(i)) / 255.0f;
    }
}
