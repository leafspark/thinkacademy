package androidx.camera.core;

import android.graphics.Rect;
import android.util.Size;

public abstract class ResolutionInfo {
    public abstract Rect getCropRect();

    public abstract Size getResolution();

    public abstract int getRotationDegrees();

    static ResolutionInfo create(Size size, Rect rect, int i) {
        return new AutoValue_ResolutionInfo(size, rect, i);
    }

    ResolutionInfo() {
    }
}
