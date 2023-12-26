package androidx.camera.core;

import androidx.camera.core.ImageAnalysis;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.Executor;

public final /* synthetic */ class ImageAnalysisAbstractAnalyzer$$ExternalSyntheticLambda0 implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ ImageAnalysisAbstractAnalyzer f$0;
    public final /* synthetic */ Executor f$1;
    public final /* synthetic */ ImageProxy f$2;
    public final /* synthetic */ ImageAnalysis.Analyzer f$3;

    public /* synthetic */ ImageAnalysisAbstractAnalyzer$$ExternalSyntheticLambda0(ImageAnalysisAbstractAnalyzer imageAnalysisAbstractAnalyzer, Executor executor, ImageProxy imageProxy, ImageAnalysis.Analyzer analyzer) {
        this.f$0 = imageAnalysisAbstractAnalyzer;
        this.f$1 = executor;
        this.f$2 = imageProxy;
        this.f$3 = analyzer;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return this.f$0.lambda$analyzeImage$1$ImageAnalysisAbstractAnalyzer(this.f$1, this.f$2, this.f$3, completer);
    }
}
