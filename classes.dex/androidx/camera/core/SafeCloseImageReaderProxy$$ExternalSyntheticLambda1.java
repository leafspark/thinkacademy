package androidx.camera.core;

import androidx.camera.core.impl.ImageReaderProxy;

public final /* synthetic */ class SafeCloseImageReaderProxy$$ExternalSyntheticLambda1 implements ImageReaderProxy.OnImageAvailableListener {
    public final /* synthetic */ SafeCloseImageReaderProxy f$0;
    public final /* synthetic */ ImageReaderProxy.OnImageAvailableListener f$1;

    public /* synthetic */ SafeCloseImageReaderProxy$$ExternalSyntheticLambda1(SafeCloseImageReaderProxy safeCloseImageReaderProxy, ImageReaderProxy.OnImageAvailableListener onImageAvailableListener) {
        this.f$0 = safeCloseImageReaderProxy;
        this.f$1 = onImageAvailableListener;
    }

    public final void onImageAvailable(ImageReaderProxy imageReaderProxy) {
        this.f$0.lambda$setOnImageAvailableListener$1$SafeCloseImageReaderProxy(this.f$1, imageReaderProxy);
    }
}
