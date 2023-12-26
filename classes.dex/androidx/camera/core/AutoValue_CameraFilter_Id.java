package androidx.camera.core;

import androidx.camera.core.CameraFilter;
import java.util.Objects;

final class AutoValue_CameraFilter_Id extends CameraFilter.Id {
    private final Object value;

    AutoValue_CameraFilter_Id(Object obj) {
        Objects.requireNonNull(obj, "Null value");
        this.value = obj;
    }

    public Object getValue() {
        return this.value;
    }

    public String toString() {
        return "Id{value=" + this.value + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CameraFilter.Id) {
            return this.value.equals(((CameraFilter.Id) obj).getValue());
        }
        return false;
    }

    public int hashCode() {
        return this.value.hashCode() ^ 1000003;
    }
}
