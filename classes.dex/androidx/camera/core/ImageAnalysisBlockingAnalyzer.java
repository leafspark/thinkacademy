package androidx.camera.core;

import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;

final class ImageAnalysisBlockingAnalyzer extends ImageAnalysisAbstractAnalyzer {
    /* access modifiers changed from: package-private */
    public void clearCache() {
    }

    ImageAnalysisBlockingAnalyzer() {
    }

    /* access modifiers changed from: package-private */
    public ImageProxy acquireImage(ImageReaderProxy imageReaderProxy) {
        return imageReaderProxy.acquireNextImage();
    }

    /* access modifiers changed from: package-private */
    public void onValidImageAvailable(final ImageProxy imageProxy) {
        Futures.addCallback(analyzeImage(imageProxy), new FutureCallback<Void>() {
            public void onSuccess(Void voidR) {
            }

            public void onFailure(Throwable th) {
                imageProxy.close();
            }
        }, CameraXExecutors.directExecutor());
    }
}
