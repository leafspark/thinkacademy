package com.tal.app.thinkacademy.lib.imageloader;

import android.content.Context;
import io.reactivex.rxjava3.functions.Consumer;

public final /* synthetic */ class XesImageLoader$$ExternalSyntheticLambda0 implements Consumer {
    public final /* synthetic */ Context f$0;

    public /* synthetic */ XesImageLoader$$ExternalSyntheticLambda0(Context context) {
        this.f$0 = context;
    }

    public final void accept(Object obj) {
        XesImageLoader.m86clearDiskCache$lambda1(this.f$0, (Integer) obj);
    }
}
