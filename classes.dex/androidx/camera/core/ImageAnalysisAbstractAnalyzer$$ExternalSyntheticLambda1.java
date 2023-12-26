package androidx.camera.core;

import androidx.camera.core.ImageAnalysis;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class ImageAnalysisAbstractAnalyzer$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ ImageAnalysisAbstractAnalyzer f$0;
    public final /* synthetic */ ImageProxy f$1;
    public final /* synthetic */ ImageAnalysis.Analyzer f$2;
    public final /* synthetic */ CallbackToFutureAdapter.Completer f$3;

    public /* synthetic */ ImageAnalysisAbstractAnalyzer$$ExternalSyntheticLambda1(ImageAnalysisAbstractAnalyzer imageAnalysisAbstractAnalyzer, ImageProxy imageProxy, ImageAnalysis.Analyzer analyzer, CallbackToFutureAdapter.Completer completer) {
        this.f$0 = imageAnalysisAbstractAnalyzer;
        this.f$1 = imageProxy;
        this.f$2 = analyzer;
        this.f$3 = completer;
    }

    public final void run() {
        this.f$0.lambda$analyzeImage$0$ImageAnalysisAbstractAnalyzer(this.f$1, this.f$2, this.f$3);
    }
}
