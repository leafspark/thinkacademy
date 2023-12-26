package androidx.camera.core;

import android.media.ImageReader;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CaptureBundle;
import androidx.camera.core.impl.CaptureProcessor;
import androidx.camera.core.impl.CaptureStage;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;

class ProcessingImageReader implements ImageReaderProxy {
    private static final String TAG = "ProcessingImageReader";
    private final List<Integer> mCaptureIdList;
    final CaptureProcessor mCaptureProcessor;
    private FutureCallback<List<ImageProxy>> mCaptureStageReadyCallback;
    CallbackToFutureAdapter.Completer<Void> mCloseCompleter;
    private ListenableFuture<Void> mCloseFuture;
    boolean mClosed;
    Executor mExecutor;
    private ImageReaderProxy.OnImageAvailableListener mImageProcessedListener;
    final MetadataImageReader mInputImageReader;
    ImageReaderProxy.OnImageAvailableListener mListener;
    final Object mLock;
    final ImageReaderProxy mOutputImageReader;
    final Executor mPostProcessExecutor;
    boolean mProcessing;
    SettableImageProxyBundle mSettableImageProxyBundle;
    private String mTagBundleKey;
    private ImageReaderProxy.OnImageAvailableListener mTransformedListener;

    ProcessingImageReader(int i, int i2, int i3, int i4, Executor executor, CaptureBundle captureBundle, CaptureProcessor captureProcessor) {
        this(i, i2, i3, i4, executor, captureBundle, captureProcessor, i3);
    }

    ProcessingImageReader(int i, int i2, int i3, int i4, Executor executor, CaptureBundle captureBundle, CaptureProcessor captureProcessor, int i5) {
        this(new MetadataImageReader(i, i2, i3, i4), executor, captureBundle, captureProcessor, i5);
    }

    ProcessingImageReader(MetadataImageReader metadataImageReader, Executor executor, CaptureBundle captureBundle, CaptureProcessor captureProcessor) {
        this(metadataImageReader, executor, captureBundle, captureProcessor, metadataImageReader.getImageFormat());
    }

    ProcessingImageReader(MetadataImageReader metadataImageReader, Executor executor, CaptureBundle captureBundle, CaptureProcessor captureProcessor, int i) {
        this.mLock = new Object();
        this.mTransformedListener = new ImageReaderProxy.OnImageAvailableListener() {
            public void onImageAvailable(ImageReaderProxy imageReaderProxy) {
                ProcessingImageReader.this.imageIncoming(imageReaderProxy);
            }
        };
        this.mImageProcessedListener = new ImageReaderProxy.OnImageAvailableListener() {
            public void onImageAvailable(ImageReaderProxy imageReaderProxy) {
                ImageReaderProxy.OnImageAvailableListener onImageAvailableListener;
                Executor executor;
                synchronized (ProcessingImageReader.this.mLock) {
                    onImageAvailableListener = ProcessingImageReader.this.mListener;
                    executor = ProcessingImageReader.this.mExecutor;
                    ProcessingImageReader.this.mSettableImageProxyBundle.reset();
                    ProcessingImageReader.this.setupSettableImageProxyBundleCallbacks();
                }
                if (onImageAvailableListener == null) {
                    return;
                }
                if (executor != null) {
                    executor.execute(new ProcessingImageReader$2$$ExternalSyntheticLambda0(this, onImageAvailableListener));
                } else {
                    onImageAvailableListener.onImageAvailable(ProcessingImageReader.this);
                }
            }

            public /* synthetic */ void lambda$onImageAvailable$0$ProcessingImageReader$2(ImageReaderProxy.OnImageAvailableListener onImageAvailableListener) {
                onImageAvailableListener.onImageAvailable(ProcessingImageReader.this);
            }
        };
        this.mCaptureStageReadyCallback = new FutureCallback<List<ImageProxy>>() {
            public void onFailure(Throwable th) {
            }

            /* JADX WARNING: Code restructure failed: missing block: B:10:0x0022, code lost:
                monitor-enter(r0);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
                r2.this$0.mProcessing = false;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:13:0x002c, code lost:
                if (r2.this$0.mClosed == false) goto L_0x0051;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
                r2.this$0.mInputImageReader.close();
                r2.this$0.mSettableImageProxyBundle.close();
                r2.this$0.mOutputImageReader.close();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:15:0x0047, code lost:
                if (r2.this$0.mCloseCompleter == null) goto L_0x0051;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:16:0x0049, code lost:
                r2.this$0.mCloseCompleter.set(null);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:17:0x0051, code lost:
                monitor-exit(r0);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:18:0x0052, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
                r2.this$0.mCaptureProcessor.process(r0);
                r0 = r2.this$0.mLock;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onSuccess(java.util.List<androidx.camera.core.ImageProxy> r3) {
                /*
                    r2 = this;
                    androidx.camera.core.ProcessingImageReader r3 = androidx.camera.core.ProcessingImageReader.this
                    java.lang.Object r3 = r3.mLock
                    monitor-enter(r3)
                    androidx.camera.core.ProcessingImageReader r0 = androidx.camera.core.ProcessingImageReader.this     // Catch:{ all -> 0x0056 }
                    boolean r0 = r0.mClosed     // Catch:{ all -> 0x0056 }
                    if (r0 == 0) goto L_0x000d
                    monitor-exit(r3)     // Catch:{ all -> 0x0056 }
                    return
                L_0x000d:
                    androidx.camera.core.ProcessingImageReader r0 = androidx.camera.core.ProcessingImageReader.this     // Catch:{ all -> 0x0056 }
                    r1 = 1
                    r0.mProcessing = r1     // Catch:{ all -> 0x0056 }
                    androidx.camera.core.ProcessingImageReader r0 = androidx.camera.core.ProcessingImageReader.this     // Catch:{ all -> 0x0056 }
                    androidx.camera.core.SettableImageProxyBundle r0 = r0.mSettableImageProxyBundle     // Catch:{ all -> 0x0056 }
                    monitor-exit(r3)     // Catch:{ all -> 0x0056 }
                    androidx.camera.core.ProcessingImageReader r3 = androidx.camera.core.ProcessingImageReader.this
                    androidx.camera.core.impl.CaptureProcessor r3 = r3.mCaptureProcessor
                    r3.process(r0)
                    androidx.camera.core.ProcessingImageReader r3 = androidx.camera.core.ProcessingImageReader.this
                    java.lang.Object r0 = r3.mLock
                    monitor-enter(r0)
                    androidx.camera.core.ProcessingImageReader r3 = androidx.camera.core.ProcessingImageReader.this     // Catch:{ all -> 0x0053 }
                    r1 = 0
                    r3.mProcessing = r1     // Catch:{ all -> 0x0053 }
                    androidx.camera.core.ProcessingImageReader r3 = androidx.camera.core.ProcessingImageReader.this     // Catch:{ all -> 0x0053 }
                    boolean r3 = r3.mClosed     // Catch:{ all -> 0x0053 }
                    if (r3 == 0) goto L_0x0051
                    androidx.camera.core.ProcessingImageReader r3 = androidx.camera.core.ProcessingImageReader.this     // Catch:{ all -> 0x0053 }
                    androidx.camera.core.MetadataImageReader r3 = r3.mInputImageReader     // Catch:{ all -> 0x0053 }
                    r3.close()     // Catch:{ all -> 0x0053 }
                    androidx.camera.core.ProcessingImageReader r3 = androidx.camera.core.ProcessingImageReader.this     // Catch:{ all -> 0x0053 }
                    androidx.camera.core.SettableImageProxyBundle r3 = r3.mSettableImageProxyBundle     // Catch:{ all -> 0x0053 }
                    r3.close()     // Catch:{ all -> 0x0053 }
                    androidx.camera.core.ProcessingImageReader r3 = androidx.camera.core.ProcessingImageReader.this     // Catch:{ all -> 0x0053 }
                    androidx.camera.core.impl.ImageReaderProxy r3 = r3.mOutputImageReader     // Catch:{ all -> 0x0053 }
                    r3.close()     // Catch:{ all -> 0x0053 }
                    androidx.camera.core.ProcessingImageReader r3 = androidx.camera.core.ProcessingImageReader.this     // Catch:{ all -> 0x0053 }
                    androidx.concurrent.futures.CallbackToFutureAdapter$Completer<java.lang.Void> r3 = r3.mCloseCompleter     // Catch:{ all -> 0x0053 }
                    if (r3 == 0) goto L_0x0051
                    androidx.camera.core.ProcessingImageReader r3 = androidx.camera.core.ProcessingImageReader.this     // Catch:{ all -> 0x0053 }
                    androidx.concurrent.futures.CallbackToFutureAdapter$Completer<java.lang.Void> r3 = r3.mCloseCompleter     // Catch:{ all -> 0x0053 }
                    r1 = 0
                    r3.set(r1)     // Catch:{ all -> 0x0053 }
                L_0x0051:
                    monitor-exit(r0)     // Catch:{ all -> 0x0053 }
                    return
                L_0x0053:
                    r3 = move-exception
                    monitor-exit(r0)     // Catch:{ all -> 0x0053 }
                    throw r3
                L_0x0056:
                    r0 = move-exception
                    monitor-exit(r3)     // Catch:{ all -> 0x0056 }
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.ProcessingImageReader.AnonymousClass3.onSuccess(java.util.List):void");
            }
        };
        this.mClosed = false;
        this.mProcessing = false;
        this.mTagBundleKey = new String();
        this.mSettableImageProxyBundle = new SettableImageProxyBundle(Collections.emptyList(), this.mTagBundleKey);
        this.mCaptureIdList = new ArrayList();
        if (metadataImageReader.getMaxImages() >= captureBundle.getCaptureStages().size()) {
            this.mInputImageReader = metadataImageReader;
            int width = metadataImageReader.getWidth();
            int height = metadataImageReader.getHeight();
            if (i == 256) {
                width = metadataImageReader.getWidth() * metadataImageReader.getHeight();
                height = 1;
            }
            AndroidImageReaderProxy androidImageReaderProxy = new AndroidImageReaderProxy(ImageReader.newInstance(width, height, i, metadataImageReader.getMaxImages()));
            this.mOutputImageReader = androidImageReaderProxy;
            this.mPostProcessExecutor = executor;
            this.mCaptureProcessor = captureProcessor;
            captureProcessor.onOutputSurface(androidImageReaderProxy.getSurface(), i);
            captureProcessor.onResolutionUpdate(new Size(metadataImageReader.getWidth(), metadataImageReader.getHeight()));
            setCaptureBundle(captureBundle);
            return;
        }
        throw new IllegalArgumentException("MetadataImageReader is smaller than CaptureBundle.");
    }

    public ImageProxy acquireLatestImage() {
        ImageProxy acquireLatestImage;
        synchronized (this.mLock) {
            acquireLatestImage = this.mOutputImageReader.acquireLatestImage();
        }
        return acquireLatestImage;
    }

    public ImageProxy acquireNextImage() {
        ImageProxy acquireNextImage;
        synchronized (this.mLock) {
            acquireNextImage = this.mOutputImageReader.acquireNextImage();
        }
        return acquireNextImage;
    }

    public void close() {
        synchronized (this.mLock) {
            if (!this.mClosed) {
                this.mOutputImageReader.clearOnImageAvailableListener();
                if (!this.mProcessing) {
                    this.mInputImageReader.close();
                    this.mSettableImageProxyBundle.close();
                    this.mOutputImageReader.close();
                    CallbackToFutureAdapter.Completer<Void> completer = this.mCloseCompleter;
                    if (completer != null) {
                        completer.set(null);
                    }
                }
                this.mClosed = true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public ListenableFuture<Void> getCloseFuture() {
        ListenableFuture<Void> listenableFuture;
        synchronized (this.mLock) {
            if (!this.mClosed || this.mProcessing) {
                if (this.mCloseFuture == null) {
                    this.mCloseFuture = CallbackToFutureAdapter.getFuture(new ProcessingImageReader$$ExternalSyntheticLambda0(this));
                }
                listenableFuture = Futures.nonCancellationPropagating(this.mCloseFuture);
            } else {
                listenableFuture = Futures.immediateFuture(null);
            }
        }
        return listenableFuture;
    }

    public /* synthetic */ Object lambda$getCloseFuture$0$ProcessingImageReader(CallbackToFutureAdapter.Completer completer) throws Exception {
        synchronized (this.mLock) {
            this.mCloseCompleter = completer;
        }
        return "ProcessingImageReader-close";
    }

    public int getHeight() {
        int height;
        synchronized (this.mLock) {
            height = this.mInputImageReader.getHeight();
        }
        return height;
    }

    public int getWidth() {
        int width;
        synchronized (this.mLock) {
            width = this.mInputImageReader.getWidth();
        }
        return width;
    }

    public int getImageFormat() {
        int imageFormat;
        synchronized (this.mLock) {
            imageFormat = this.mOutputImageReader.getImageFormat();
        }
        return imageFormat;
    }

    public int getMaxImages() {
        int maxImages;
        synchronized (this.mLock) {
            maxImages = this.mInputImageReader.getMaxImages();
        }
        return maxImages;
    }

    public Surface getSurface() {
        Surface surface;
        synchronized (this.mLock) {
            surface = this.mInputImageReader.getSurface();
        }
        return surface;
    }

    public void setOnImageAvailableListener(ImageReaderProxy.OnImageAvailableListener onImageAvailableListener, Executor executor) {
        synchronized (this.mLock) {
            this.mListener = (ImageReaderProxy.OnImageAvailableListener) Preconditions.checkNotNull(onImageAvailableListener);
            this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
            this.mInputImageReader.setOnImageAvailableListener(this.mTransformedListener, executor);
            this.mOutputImageReader.setOnImageAvailableListener(this.mImageProcessedListener, executor);
        }
    }

    public void clearOnImageAvailableListener() {
        synchronized (this.mLock) {
            this.mListener = null;
            this.mExecutor = null;
            this.mInputImageReader.clearOnImageAvailableListener();
            this.mOutputImageReader.clearOnImageAvailableListener();
            if (!this.mProcessing) {
                this.mSettableImageProxyBundle.close();
            }
        }
    }

    public void setCaptureBundle(CaptureBundle captureBundle) {
        synchronized (this.mLock) {
            if (captureBundle.getCaptureStages() != null) {
                if (this.mInputImageReader.getMaxImages() >= captureBundle.getCaptureStages().size()) {
                    this.mCaptureIdList.clear();
                    for (CaptureStage next : captureBundle.getCaptureStages()) {
                        if (next != null) {
                            this.mCaptureIdList.add(Integer.valueOf(next.getId()));
                        }
                    }
                } else {
                    throw new IllegalArgumentException("CaptureBundle is larger than InputImageReader.");
                }
            }
            String num = Integer.toString(captureBundle.hashCode());
            this.mTagBundleKey = num;
            this.mSettableImageProxyBundle = new SettableImageProxyBundle(this.mCaptureIdList, num);
            setupSettableImageProxyBundleCallbacks();
        }
    }

    public String getTagBundleKey() {
        return this.mTagBundleKey;
    }

    /* access modifiers changed from: package-private */
    public CameraCaptureCallback getCameraCaptureCallback() {
        CameraCaptureCallback cameraCaptureCallback;
        synchronized (this.mLock) {
            cameraCaptureCallback = this.mInputImageReader.getCameraCaptureCallback();
        }
        return cameraCaptureCallback;
    }

    /* access modifiers changed from: package-private */
    public void setupSettableImageProxyBundleCallbacks() {
        ArrayList arrayList = new ArrayList();
        for (Integer intValue : this.mCaptureIdList) {
            arrayList.add(this.mSettableImageProxyBundle.getImageProxy(intValue.intValue()));
        }
        Futures.addCallback(Futures.allAsList(arrayList), this.mCaptureStageReadyCallback, this.mPostProcessExecutor);
    }

    /* access modifiers changed from: package-private */
    public void imageIncoming(ImageReaderProxy imageReaderProxy) {
        synchronized (this.mLock) {
            if (!this.mClosed) {
                try {
                    ImageProxy acquireNextImage = imageReaderProxy.acquireNextImage();
                    if (acquireNextImage != null) {
                        Integer num = (Integer) acquireNextImage.getImageInfo().getTagBundle().getTag(this.mTagBundleKey);
                        if (!this.mCaptureIdList.contains(num)) {
                            Logger.w(TAG, "ImageProxyBundle does not contain this id: " + num);
                            acquireNextImage.close();
                        } else {
                            this.mSettableImageProxyBundle.addImageProxy(acquireNextImage);
                        }
                    }
                } catch (IllegalStateException e) {
                    Logger.e(TAG, "Failed to acquire latest image.", e);
                }
                return;
            }
            return;
        }
    }
}
