package androidx.camera.core;

import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.ImageAnalysisNonBlockingAnalyzer;

public final /* synthetic */ class ImageAnalysisNonBlockingAnalyzer$CacheAnalyzingImageProxy$$ExternalSyntheticLambda0 implements ForwardingImageProxy.OnImageCloseListener {
    public final /* synthetic */ ImageAnalysisNonBlockingAnalyzer.CacheAnalyzingImageProxy f$0;

    public /* synthetic */ ImageAnalysisNonBlockingAnalyzer$CacheAnalyzingImageProxy$$ExternalSyntheticLambda0(ImageAnalysisNonBlockingAnalyzer.CacheAnalyzingImageProxy cacheAnalyzingImageProxy) {
        this.f$0 = cacheAnalyzingImageProxy;
    }

    public final void onImageClose(ImageProxy imageProxy) {
        this.f$0.lambda$new$0$ImageAnalysisNonBlockingAnalyzer$CacheAnalyzingImageProxy(imageProxy);
    }
}
