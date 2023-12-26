package com.wushuangtech.utils;

import com.wushuangtech.bean.SpeedCalcBean;
import com.yalantis.ucrop.view.CropImageView;
import java.math.BigDecimal;

public class MyMathUtils {
    public static float formatSpeedKBps(long j, long j2) {
        return ((((float) j) * 1000.0f) / ((float) j2)) / 1024.0f;
    }

    public static float formatSpeedKbps(long j, long j2) {
        return (((((float) j) * 1000.0f) / ((float) j2)) / 1024.0f) * 8.0f;
    }

    public static int transAudioLevelRange(int i) {
        return (i * 255) / 9;
    }

    public static int transAudioLevelFullRange(int i) {
        return (i * 255) / 32767;
    }

    public static double formatNumberDecimal(int i, double d) {
        if (d == 0.0d) {
            return 0.0d;
        }
        try {
            return Double.parseDouble(new BigDecimal(String.valueOf(d)).setScale(i, 5).toString());
        } catch (Exception e) {
            OmniLog.d("MyMathUtils -> formatNumberDecimal exception : " + e.getLocalizedMessage());
            return 0.0d;
        }
    }

    public static float formatNumberDecimal(int i, float f) {
        if (f == CropImageView.DEFAULT_ASPECT_RATIO) {
            return CropImageView.DEFAULT_ASPECT_RATIO;
        }
        try {
            return Float.parseFloat(new BigDecimal(String.valueOf(f)).setScale(i, 5).toString());
        } catch (Exception e) {
            OmniLog.d("MyMathUtils -> formatNumberDecimal exception : " + e.getLocalizedMessage());
            return CropImageView.DEFAULT_ASPECT_RATIO;
        }
    }

    public static int alignIntMultipleOf32(int i) {
        int i2 = i % 32;
        return i2 == 0 ? i : (i + 32) - i2;
    }

    public static int calcFps(SpeedCalcBean speedCalcBean) {
        long j = speedCalcBean.mCount;
        long j2 = speedCalcBean.mLastCount;
        long j3 = speedCalcBean.mLastBuildTimestamp;
        if (j <= j2) {
            speedCalcBean.mLastCount = 0;
            return 0;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (j2 == 0) {
            speedCalcBean.mLastCount = j;
            speedCalcBean.mLastBuildTimestamp = currentTimeMillis;
            return 0;
        }
        int i = (int) (((double) (((float) (j - j2)) / (j3 == 0 ? 1.0f : ((float) (currentTimeMillis - j3)) / 1000.0f))) + 0.5d);
        speedCalcBean.mLastCount = j;
        speedCalcBean.mLastBuildTimestamp = currentTimeMillis;
        if (i > 60) {
            return 0;
        }
        return i;
    }
}
