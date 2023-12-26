package androidx.camera.view;

import android.graphics.Bitmap;
import android.util.Size;
import android.view.View;
import android.widget.FrameLayout;
import androidx.camera.core.SurfaceRequest;
import com.google.common.util.concurrent.ListenableFuture;

abstract class PreviewViewImplementation {
    FrameLayout mParent;
    private final PreviewTransformation mPreviewTransform;
    Size mResolution;

    interface OnSurfaceNotInUseListener {
        void onSurfaceNotInUse();
    }

    /* access modifiers changed from: package-private */
    public abstract View getPreview();

    /* access modifiers changed from: package-private */
    public abstract Bitmap getPreviewBitmap();

    /* access modifiers changed from: package-private */
    public abstract void initializePreview();

    /* access modifiers changed from: package-private */
    public abstract void onAttachedToWindow();

    /* access modifiers changed from: package-private */
    public abstract void onDetachedFromWindow();

    /* access modifiers changed from: package-private */
    public abstract void onSurfaceRequested(SurfaceRequest surfaceRequest, OnSurfaceNotInUseListener onSurfaceNotInUseListener);

    /* access modifiers changed from: package-private */
    public abstract ListenableFuture<Void> waitForNextFrame();

    PreviewViewImplementation(FrameLayout frameLayout, PreviewTransformation previewTransformation) {
        this.mParent = frameLayout;
        this.mPreviewTransform = previewTransformation;
    }

    /* access modifiers changed from: package-private */
    public void redrawPreview() {
        View preview = getPreview();
        if (preview != null) {
            this.mPreviewTransform.transformView(new Size(this.mParent.getWidth(), this.mParent.getHeight()), this.mParent.getLayoutDirection(), preview);
        }
    }

    /* access modifiers changed from: package-private */
    public void onSurfaceProvided() {
        redrawPreview();
    }

    /* access modifiers changed from: package-private */
    public Bitmap getBitmap() {
        Bitmap previewBitmap = getPreviewBitmap();
        if (previewBitmap == null) {
            return null;
        }
        return this.mPreviewTransform.createTransformedBitmap(previewBitmap, new Size(this.mParent.getWidth(), this.mParent.getHeight()), this.mParent.getLayoutDirection());
    }
}
