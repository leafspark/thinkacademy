package androidx.camera.core;

import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.os.OperationCanceledException;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

abstract class ImageAnalysisAbstractAnalyzer implements ImageReaderProxy.OnImageAvailableListener {
    private static final String TAG = "ImageAnalysisAnalyzer";
    private final Object mAnalyzerLock = new Object();
    protected boolean mIsAttached = true;
    private volatile int mRelativeRotation;
    private ImageAnalysis.Analyzer mSubscribedAnalyzer;
    private Executor mUserExecutor;

    /* access modifiers changed from: package-private */
    public abstract ImageProxy acquireImage(ImageReaderProxy imageReaderProxy);

    /* access modifiers changed from: package-private */
    public abstract void clearCache();

    /* access modifiers changed from: package-private */
    public abstract void onValidImageAvailable(ImageProxy imageProxy);

    ImageAnalysisAbstractAnalyzer() {
    }

    public void onImageAvailable(ImageReaderProxy imageReaderProxy) {
        try {
            ImageProxy acquireImage = acquireImage(imageReaderProxy);
            if (acquireImage != null) {
                onValidImageAvailable(acquireImage);
            }
        } catch (IllegalStateException e) {
            Logger.e(TAG, "Failed to acquire image.", e);
        }
    }

    /* access modifiers changed from: package-private */
    public ListenableFuture<Void> analyzeImage(ImageProxy imageProxy) {
        Executor executor;
        ImageAnalysis.Analyzer analyzer;
        synchronized (this.mAnalyzerLock) {
            executor = this.mUserExecutor;
            analyzer = this.mSubscribedAnalyzer;
        }
        if (analyzer == null || executor == null) {
            return Futures.immediateFailedFuture(new OperationCanceledException("No analyzer or executor currently set."));
        }
        return CallbackToFutureAdapter.getFuture(new ImageAnalysisAbstractAnalyzer$$ExternalSyntheticLambda0(this, executor, imageProxy, analyzer));
    }

    public /* synthetic */ Object lambda$analyzeImage$1$ImageAnalysisAbstractAnalyzer(Executor executor, ImageProxy imageProxy, ImageAnalysis.Analyzer analyzer, CallbackToFutureAdapter.Completer completer) throws Exception {
        executor.execute(new ImageAnalysisAbstractAnalyzer$$ExternalSyntheticLambda1(this, imageProxy, analyzer, completer));
        return "analyzeImage";
    }

    public /* synthetic */ void lambda$analyzeImage$0$ImageAnalysisAbstractAnalyzer(ImageProxy imageProxy, ImageAnalysis.Analyzer analyzer, CallbackToFutureAdapter.Completer completer) {
        if (this.mIsAttached) {
            analyzer.analyze(new SettableImageProxy(imageProxy, ImmutableImageInfo.create(imageProxy.getImageInfo().getTagBundle(), imageProxy.getImageInfo().getTimestamp(), this.mRelativeRotation)));
            completer.set(null);
            return;
        }
        completer.setException(new OperationCanceledException("ImageAnalysis is detached"));
    }

    /* access modifiers changed from: package-private */
    public void setRelativeRotation(int i) {
        this.mRelativeRotation = i;
    }

    /* access modifiers changed from: package-private */
    public void setAnalyzer(Executor executor, ImageAnalysis.Analyzer analyzer) {
        synchronized (this.mAnalyzerLock) {
            if (analyzer == null) {
                clearCache();
            }
            this.mSubscribedAnalyzer = analyzer;
            this.mUserExecutor = executor;
        }
    }

    /* access modifiers changed from: package-private */
    public void attach() {
        this.mIsAttached = true;
    }

    /* access modifiers changed from: package-private */
    public void detach() {
        this.mIsAttached = false;
        clearCache();
    }
}
