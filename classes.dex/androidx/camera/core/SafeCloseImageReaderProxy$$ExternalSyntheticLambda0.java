package androidx.camera.core;

import androidx.camera.core.ForwardingImageProxy;

public final /* synthetic */ class SafeCloseImageReaderProxy$$ExternalSyntheticLambda0 implements ForwardingImageProxy.OnImageCloseListener {
    public final /* synthetic */ SafeCloseImageReaderProxy f$0;

    public /* synthetic */ SafeCloseImageReaderProxy$$ExternalSyntheticLambda0(SafeCloseImageReaderProxy safeCloseImageReaderProxy) {
        this.f$0 = safeCloseImageReaderProxy;
    }

    public final void onImageClose(ImageProxy imageProxy) {
        this.f$0.lambda$new$0$SafeCloseImageReaderProxy(imageProxy);
    }
}
