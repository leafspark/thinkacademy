package androidx.camera.view.transform;

import android.graphics.Matrix;
import android.util.Size;

public final class OutputTransform {
    final Matrix mMatrix;
    final Size mViewPortSize;

    public OutputTransform(Matrix matrix, Size size) {
        this.mMatrix = matrix;
        this.mViewPortSize = size;
    }

    /* access modifiers changed from: package-private */
    public Matrix getMatrix() {
        return this.mMatrix;
    }

    /* access modifiers changed from: package-private */
    public Size getViewPortSize() {
        return this.mViewPortSize;
    }
}
