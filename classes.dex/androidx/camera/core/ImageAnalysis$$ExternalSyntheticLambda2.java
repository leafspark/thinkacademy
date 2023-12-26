package androidx.camera.core;

public final /* synthetic */ class ImageAnalysis$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ SafeCloseImageReaderProxy f$0;

    public /* synthetic */ ImageAnalysis$$ExternalSyntheticLambda2(SafeCloseImageReaderProxy safeCloseImageReaderProxy) {
        this.f$0 = safeCloseImageReaderProxy;
    }

    public final void run() {
        this.f$0.safeClose();
    }
}
