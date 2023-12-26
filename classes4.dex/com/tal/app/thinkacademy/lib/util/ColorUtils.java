package com.tal.app.thinkacademy.lib.util;

import android.graphics.Color;
import androidx.core.content.ContextCompat;
import com.tal.app.thinkacademy.live.business.function.bean.EnterRoomMuteData;

public final class ColorUtils {
    public static int setAlphaComponent(int i, float f) {
        return (i & 16777215) | (((int) ((f * 255.0f) + 0.5f)) << 24);
    }

    public static int setAlphaComponent(int i, int i2) {
        return (i & 16777215) | (i2 << 24);
    }

    public static int setBlueComponent(int i, float f) {
        return (i & -256) | ((int) ((f * 255.0f) + 0.5f));
    }

    public static int setBlueComponent(int i, int i2) {
        return (i & -256) | i2;
    }

    public static int setGreenComponent(int i, float f) {
        return (i & -65281) | (((int) ((f * 255.0f) + 0.5f)) << 8);
    }

    public static int setGreenComponent(int i, int i2) {
        return (i & -65281) | (i2 << 8);
    }

    public static int setRedComponent(int i, float f) {
        return (i & -16711681) | (((int) ((f * 255.0f) + 0.5f)) << 16);
    }

    public static int setRedComponent(int i, int i2) {
        return (i & -16711681) | (i2 << 16);
    }

    private ColorUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static int getColor(int i) {
        return ContextCompat.getColor(Utils.getApp(), i);
    }

    public static int string2Int(String str) {
        return Color.parseColor(str);
    }

    public static String int2RgbString(int i) {
        String hexString = Integer.toHexString(i & 16777215);
        while (hexString.length() < 6) {
            hexString = EnterRoomMuteData.STATUS_UN_MUTE + hexString;
        }
        return "#" + hexString;
    }

    public static String int2ArgbString(int i) {
        String hexString = Integer.toHexString(i);
        while (hexString.length() < 6) {
            hexString = EnterRoomMuteData.STATUS_UN_MUTE + hexString;
        }
        while (hexString.length() < 8) {
            hexString = "f" + hexString;
        }
        return "#" + hexString;
    }

    public static int getRandomColor() {
        return getRandomColor(true);
    }

    public static int getRandomColor(boolean z) {
        return (z ? ((int) (Math.random() * 256.0d)) << 24 : -16777216) | ((int) (Math.random() * 1.6777216E7d));
    }
}