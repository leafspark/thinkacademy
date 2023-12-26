package androidx.camera.core;

import androidx.camera.core.ImageAnalysis;

public final /* synthetic */ class ImageAnalysis$$ExternalSyntheticLambda0 implements ImageAnalysis.Analyzer {
    public final /* synthetic */ ImageAnalysis f$0;
    public final /* synthetic */ ImageAnalysis.Analyzer f$1;

    public /* synthetic */ ImageAnalysis$$ExternalSyntheticLambda0(ImageAnalysis imageAnalysis, ImageAnalysis.Analyzer analyzer) {
        this.f$0 = imageAnalysis;
        this.f$1 = analyzer;
    }

    public final void analyze(ImageProxy imageProxy) {
        this.f$0.lambda$setAnalyzer$1$ImageAnalysis(this.f$1, imageProxy);
    }
}
