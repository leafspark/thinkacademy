package androidx.camera.core;

public final /* synthetic */ class ImageAnalysisNonBlockingAnalyzer$CacheAnalyzingImageProxy$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ ImageAnalysisNonBlockingAnalyzer f$0;

    public /* synthetic */ ImageAnalysisNonBlockingAnalyzer$CacheAnalyzingImageProxy$$ExternalSyntheticLambda1(ImageAnalysisNonBlockingAnalyzer imageAnalysisNonBlockingAnalyzer) {
        this.f$0 = imageAnalysisNonBlockingAnalyzer;
    }

    public final void run() {
        this.f$0.analyzeCachedImage();
    }
}
