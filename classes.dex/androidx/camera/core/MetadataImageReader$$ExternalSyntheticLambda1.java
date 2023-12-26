package androidx.camera.core;

import androidx.camera.core.impl.ImageReaderProxy;

public final /* synthetic */ class MetadataImageReader$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ MetadataImageReader f$0;
    public final /* synthetic */ ImageReaderProxy.OnImageAvailableListener f$1;

    public /* synthetic */ MetadataImageReader$$ExternalSyntheticLambda1(MetadataImageReader metadataImageReader, ImageReaderProxy.OnImageAvailableListener onImageAvailableListener) {
        this.f$0 = metadataImageReader;
        this.f$1 = onImageAvailableListener;
    }

    public final void run() {
        this.f$0.lambda$enqueueImageProxy$1$MetadataImageReader(this.f$1);
    }
}
