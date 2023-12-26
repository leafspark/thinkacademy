package androidx.camera.core;

import android.graphics.Rect;
import android.util.Size;
import java.util.Objects;

final class AutoValue_ResolutionInfo extends ResolutionInfo {
    private final Rect cropRect;
    private final Size resolution;
    private final int rotationDegrees;

    AutoValue_ResolutionInfo(Size size, Rect rect, int i) {
        Objects.requireNonNull(size, "Null resolution");
        this.resolution = size;
        Objects.requireNonNull(rect, "Null cropRect");
        this.cropRect = rect;
        this.rotationDegrees = i;
    }

    public Size getResolution() {
        return this.resolution;
    }

    public Rect getCropRect() {
        return this.cropRect;
    }

    public int getRotationDegrees() {
        return this.rotationDegrees;
    }

    public String toString() {
        return "ResolutionInfo{resolution=" + this.resolution + ", cropRect=" + this.cropRect + ", rotationDegrees=" + this.rotationDegrees + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResolutionInfo)) {
            return false;
        }
        ResolutionInfo resolutionInfo = (ResolutionInfo) obj;
        if (!this.resolution.equals(resolutionInfo.getResolution()) || !this.cropRect.equals(resolutionInfo.getCropRect()) || this.rotationDegrees != resolutionInfo.getRotationDegrees()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((this.resolution.hashCode() ^ 1000003) * 1000003) ^ this.cropRect.hashCode()) * 1000003) ^ this.rotationDegrees;
    }
}
