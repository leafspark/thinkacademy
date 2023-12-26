package androidx.camera.core;

import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import android.view.Surface;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.utils.MainThreadAsyncHandler;
import java.util.concurrent.Executor;

final class AndroidImageReaderProxy implements ImageReaderProxy {
    private final ImageReader mImageReader;

    AndroidImageReaderProxy(ImageReader imageReader) {
        this.mImageReader = imageReader;
    }

    public synchronized ImageProxy acquireLatestImage() {
        Image image;
        try {
            image = this.mImageReader.acquireLatestImage();
        } catch (RuntimeException e) {
            if (isImageReaderContextNotInitializedException(e)) {
                image = null;
            } else {
                throw e;
            }
        }
        if (image == null) {
            return null;
        }
        return new AndroidImageProxy(image);
    }

    public synchronized ImageProxy acquireNextImage() {
        Image image;
        try {
            image = this.mImageReader.acquireNextImage();
        } catch (RuntimeException e) {
            if (isImageReaderContextNotInitializedException(e)) {
                image = null;
            } else {
                throw e;
            }
        }
        if (image == null) {
            return null;
        }
        return new AndroidImageProxy(image);
    }

    private boolean isImageReaderContextNotInitializedException(RuntimeException runtimeException) {
        return "ImageReaderContext is not initialized".equals(runtimeException.getMessage());
    }

    public synchronized void close() {
        this.mImageReader.close();
    }

    public synchronized int getHeight() {
        return this.mImageReader.getHeight();
    }

    public synchronized int getWidth() {
        return this.mImageReader.getWidth();
    }

    public synchronized int getImageFormat() {
        return this.mImageReader.getImageFormat();
    }

    public synchronized int getMaxImages() {
        return this.mImageReader.getMaxImages();
    }

    public synchronized Surface getSurface() {
        return this.mImageReader.getSurface();
    }

    public synchronized void setOnImageAvailableListener(ImageReaderProxy.OnImageAvailableListener onImageAvailableListener, Executor executor) {
        this.mImageReader.setOnImageAvailableListener(new AndroidImageReaderProxy$$ExternalSyntheticLambda0(this, executor, onImageAvailableListener), MainThreadAsyncHandler.getInstance());
    }

    public /* synthetic */ void lambda$setOnImageAvailableListener$0$AndroidImageReaderProxy(ImageReaderProxy.OnImageAvailableListener onImageAvailableListener) {
        onImageAvailableListener.onImageAvailable(this);
    }

    public /* synthetic */ void lambda$setOnImageAvailableListener$1$AndroidImageReaderProxy(Executor executor, ImageReaderProxy.OnImageAvailableListener onImageAvailableListener, ImageReader imageReader) {
        executor.execute(new AndroidImageReaderProxy$$ExternalSyntheticLambda1(this, onImageAvailableListener));
    }

    public synchronized void clearOnImageAvailableListener() {
        this.mImageReader.setOnImageAvailableListener((ImageReader.OnImageAvailableListener) null, (Handler) null);
    }
}
