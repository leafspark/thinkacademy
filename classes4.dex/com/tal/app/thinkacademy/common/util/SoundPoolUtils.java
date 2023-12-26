package com.tal.app.thinkacademy.common.util;

import android.content.Context;
import android.media.SoundPool;
import com.tal.app.thinkacademy.lib.logger.XesLog;

public class SoundPoolUtils {
    private static int currentCache = 5;
    private static SoundPool moreStreamsSoundPool;
    private static SoundPool soundPool;

    public static int play(Context context, int i, int i2) {
        if (soundPool == null) {
            soundPool = new SoundPool.Builder().setMaxStreams(1).build();
        }
        soundPool.setOnLoadCompleteListener(new SoundPoolUtils$$ExternalSyntheticLambda1(System.currentTimeMillis(), i2));
        int load = soundPool.load(context, i, 1);
        XesLog.it("SoundPoolUtils", "开始加载soundID=" + load + "，resId=" + i + ",repeatTime=" + i2);
        return load;
    }

    static /* synthetic */ void lambda$play$0(long j, int i, SoundPool soundPool2, int i2, int i3) {
        XesLog.it("SoundPoolUtils", "加载完成soundID=" + i2 + "耗时= " + (System.currentTimeMillis() - j));
        soundPool2.play(i2, 1.0f, 1.0f, 1, i, 1.0f);
    }

    public static int preLoad(Context context, int i) {
        if (soundPool == null) {
            soundPool = new SoundPool.Builder().setMaxStreams(1).build();
        }
        return soundPool.load(context, i, 1);
    }

    public static void play(int i, int i2) {
        SoundPool soundPool2 = soundPool;
        if (soundPool2 != null) {
            soundPool2.play(i, 1.0f, 1.0f, 1, i2, 1.0f);
        }
    }

    public static void stop(int i) {
        SoundPool soundPool2 = soundPool;
        if (soundPool2 != null) {
            soundPool2.stop(i);
        }
    }

    public static int playSameTime(Context context, int i, int i2) {
        if (moreStreamsSoundPool == null) {
            moreStreamsSoundPool = new SoundPool.Builder().setMaxStreams(currentCache).build();
        }
        moreStreamsSoundPool.setOnLoadCompleteListener(new SoundPoolUtils$$ExternalSyntheticLambda0(i2));
        int load = moreStreamsSoundPool.load(context, i, 1);
        XesLog.it("SoundPoolUtils", "playSameTime>>>开始加载soundID=" + load + "，resId=" + i + ",repeatTime=" + i2);
        return load;
    }

    static /* synthetic */ void lambda$playSameTime$1(int i, SoundPool soundPool2, int i2, int i3) {
        XesLog.it("SoundPoolUtils", "playSameTime>>>加载完成soundID=" + i2);
        soundPool2.play(i2, 1.0f, 1.0f, 1, i, 1.0f);
    }

    public static void stopSameTime(int i) {
        SoundPool soundPool2 = moreStreamsSoundPool;
        if (soundPool2 != null) {
            soundPool2.stop(i);
        }
    }

    public static void release() {
        SoundPool soundPool2 = soundPool;
        if (soundPool2 != null) {
            soundPool2.release();
            soundPool = null;
        }
        SoundPool soundPool3 = moreStreamsSoundPool;
        if (soundPool3 != null) {
            soundPool3.release();
            moreStreamsSoundPool = null;
        }
    }
}
