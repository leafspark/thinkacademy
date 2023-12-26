package com.tal.app.thinkacademy.lib.util;

import android.animation.ValueAnimator;
import java.lang.reflect.Field;

public class ValueAnimatorUtil {
    public static void resetDurationScaleIfDisable() {
        if (getDurationScale() == 0.0f) {
            resetDurationScale();
        }
    }

    public static void resetDurationScale() {
        try {
            getField().setFloat((Object) null, 1.0f);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static float getDurationScale() {
        try {
            return getField().getFloat((Object) null);
        } catch (Exception e) {
            e.printStackTrace();
            return -1.0f;
        }
    }

    private static Field getField() throws NoSuchFieldException {
        Field declaredField = ValueAnimator.class.getDeclaredField("sDurationScale");
        declaredField.setAccessible(true);
        return declaredField;
    }
}
