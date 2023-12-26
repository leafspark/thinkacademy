package androidx.camera.core;

import androidx.camera.core.ProcessingImageReader;
import androidx.camera.core.impl.ImageReaderProxy;

public final /* synthetic */ class ProcessingImageReader$2$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ ProcessingImageReader.AnonymousClass2 f$0;
    public final /* synthetic */ ImageReaderProxy.OnImageAvailableListener f$1;

    public /* synthetic */ ProcessingImageReader$2$$ExternalSyntheticLambda0(ProcessingImageReader.AnonymousClass2 r1, ImageReaderProxy.OnImageAvailableListener onImageAvailableListener) {
        this.f$0 = r1;
        this.f$1 = onImageAvailableListener;
    }

    public final void run() {
        this.f$0.lambda$onImageAvailable$0$ProcessingImageReader$2(this.f$1);
    }
}
