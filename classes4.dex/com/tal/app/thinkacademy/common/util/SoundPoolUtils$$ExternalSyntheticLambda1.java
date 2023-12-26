package com.tal.app.thinkacademy.common.util;

import android.media.SoundPool;

public final /* synthetic */ class SoundPoolUtils$$ExternalSyntheticLambda1 implements SoundPool.OnLoadCompleteListener {
    public final /* synthetic */ long f$0;
    public final /* synthetic */ int f$1;

    public /* synthetic */ SoundPoolUtils$$ExternalSyntheticLambda1(long j, int i) {
        this.f$0 = j;
        this.f$1 = i;
    }

    public final void onLoadComplete(SoundPool soundPool, int i, int i2) {
        SoundPoolUtils.lambda$play$0(this.f$0, this.f$1, soundPool, i, i2);
    }
}
