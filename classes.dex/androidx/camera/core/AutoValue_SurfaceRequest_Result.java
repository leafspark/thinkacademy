package androidx.camera.core;

import android.view.Surface;
import androidx.camera.core.SurfaceRequest;
import java.util.Objects;

final class AutoValue_SurfaceRequest_Result extends SurfaceRequest.Result {
    private final int resultCode;
    private final Surface surface;

    AutoValue_SurfaceRequest_Result(int i, Surface surface2) {
        this.resultCode = i;
        Objects.requireNonNull(surface2, "Null surface");
        this.surface = surface2;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public Surface getSurface() {
        return this.surface;
    }

    public String toString() {
        return "Result{resultCode=" + this.resultCode + ", surface=" + this.surface + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SurfaceRequest.Result)) {
            return false;
        }
        SurfaceRequest.Result result = (SurfaceRequest.Result) obj;
        if (this.resultCode != result.getResultCode() || !this.surface.equals(result.getSurface())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.resultCode ^ 1000003) * 1000003) ^ this.surface.hashCode();
    }
}
