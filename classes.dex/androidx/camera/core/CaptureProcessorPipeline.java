package androidx.camera.core;

import android.media.ImageReader;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.impl.CaptureProcessor;
import androidx.camera.core.impl.ImageProxyBundle;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

class CaptureProcessorPipeline implements CaptureProcessor {
    private final Executor mExecutor;
    private ImageReaderProxy mIntermediateImageReader = null;
    private final int mMaxImages;
    private final CaptureProcessor mPostCaptureProcessor;
    private final CaptureProcessor mPreCaptureProcessor;
    private ImageInfo mSourceImageInfo = null;

    CaptureProcessorPipeline(CaptureProcessor captureProcessor, int i, CaptureProcessor captureProcessor2, Executor executor) {
        this.mPreCaptureProcessor = captureProcessor;
        this.mPostCaptureProcessor = captureProcessor2;
        this.mExecutor = executor;
        this.mMaxImages = i;
    }

    public void onOutputSurface(Surface surface, int i) {
        this.mPostCaptureProcessor.onOutputSurface(surface, i);
    }

    public void process(ImageProxyBundle imageProxyBundle) {
        ListenableFuture<ImageProxy> imageProxy = imageProxyBundle.getImageProxy(imageProxyBundle.getCaptureIds().get(0).intValue());
        Preconditions.checkArgument(imageProxy.isDone());
        try {
            this.mSourceImageInfo = ((ImageProxy) imageProxy.get()).getImageInfo();
            this.mPreCaptureProcessor.process(imageProxyBundle);
        } catch (InterruptedException | ExecutionException unused) {
            throw new IllegalArgumentException("Can not successfully extract ImageProxy from the ImageProxyBundle.");
        }
    }

    public void onResolutionUpdate(Size size) {
        AndroidImageReaderProxy androidImageReaderProxy = new AndroidImageReaderProxy(ImageReader.newInstance(size.getWidth(), size.getHeight(), 35, this.mMaxImages));
        this.mIntermediateImageReader = androidImageReaderProxy;
        this.mPreCaptureProcessor.onOutputSurface(androidImageReaderProxy.getSurface(), 35);
        this.mPreCaptureProcessor.onResolutionUpdate(size);
        this.mPostCaptureProcessor.onResolutionUpdate(size);
        this.mIntermediateImageReader.setOnImageAvailableListener(new ImageReaderProxy.OnImageAvailableListener() {
            public void onImageAvailable(ImageReaderProxy imageReaderProxy) {
                CaptureProcessorPipeline.this.postProcess(imageReaderProxy.acquireNextImage());
            }
        }, this.mExecutor);
    }

    /* access modifiers changed from: package-private */
    public void postProcess(ImageProxy imageProxy) {
        Size size = new Size(imageProxy.getWidth(), imageProxy.getHeight());
        Preconditions.checkNotNull(this.mSourceImageInfo);
        String next = this.mSourceImageInfo.getTagBundle().listKeys().iterator().next();
        int intValue = ((Integer) this.mSourceImageInfo.getTagBundle().getTag(next)).intValue();
        SettableImageProxy settableImageProxy = new SettableImageProxy(imageProxy, size, this.mSourceImageInfo);
        this.mSourceImageInfo = null;
        SettableImageProxyBundle settableImageProxyBundle = new SettableImageProxyBundle(Collections.singletonList(Integer.valueOf(intValue)), next);
        settableImageProxyBundle.addImageProxy(settableImageProxy);
        this.mPostCaptureProcessor.process(settableImageProxyBundle);
    }

    /* access modifiers changed from: package-private */
    public void close() {
        ImageReaderProxy imageReaderProxy = this.mIntermediateImageReader;
        if (imageReaderProxy != null) {
            imageReaderProxy.clearOnImageAvailableListener();
            this.mIntermediateImageReader.close();
        }
    }
}
