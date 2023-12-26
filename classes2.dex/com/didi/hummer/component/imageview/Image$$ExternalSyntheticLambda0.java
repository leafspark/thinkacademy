package com.didi.hummer.component.imageview;

import com.didi.hummer.adapter.imageloader.ImageSizeCallback;

public final /* synthetic */ class Image$$ExternalSyntheticLambda0 implements ImageSizeCallback {
    public final /* synthetic */ Image f$0;

    public /* synthetic */ Image$$ExternalSyntheticLambda0(Image image) {
        this.f$0 = image;
    }

    public final void onSizeReady(int i, int i2) {
        this.f$0.adjustWidthAndHeight(i, i2);
    }
}
