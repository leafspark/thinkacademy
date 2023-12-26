package androidx.camera.core.internal.compat;

import android.media.ImageWriter;
import android.os.Build;
import android.view.Surface;

public final class ImageWriterCompat {
    public static ImageWriter newInstance(Surface surface, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 29) {
            return ImageWriterCompatApi29Impl.newInstance(surface, i, i2);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return ImageWriterCompatApi26Impl.newInstance(surface, i, i2);
        }
        throw new RuntimeException("Unable to call newInstance(Surface, int, int) on API " + Build.VERSION.SDK_INT + ". Version 26 or higher required.");
    }

    private ImageWriterCompat() {
    }
}
