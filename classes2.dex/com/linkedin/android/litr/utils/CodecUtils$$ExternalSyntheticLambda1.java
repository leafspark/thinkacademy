package com.linkedin.android.litr.utils;

import java.util.concurrent.Callable;

public final /* synthetic */ class CodecUtils$$ExternalSyntheticLambda1 implements Callable {
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ CodecUtils$$ExternalSyntheticLambda1(boolean z, String str) {
        this.f$0 = z;
        this.f$1 = str;
    }

    public final Object call() {
        return CodecUtils.lambda$findCodecForFormatOrType$1(this.f$0, this.f$1);
    }
}
