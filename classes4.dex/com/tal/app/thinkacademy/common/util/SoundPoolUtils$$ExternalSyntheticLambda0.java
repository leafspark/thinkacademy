package com.tal.app.thinkacademy.common.util;

import android.media.SoundPool;

public final /* synthetic */ class SoundPoolUtils$$ExternalSyntheticLambda0 implements SoundPool.OnLoadCompleteListener {
    public final /* synthetic */ int f$0;

    public /* synthetic */ SoundPoolUtils$$ExternalSyntheticLambda0(int i) {
        this.f$0 = i;
    }

    public final void onLoadComplete(SoundPool soundPool, int i, int i2) {
        SoundPoolUtils.lambda$playSameTime$1(this.f$0, soundPool, i, i2);
    }
}
