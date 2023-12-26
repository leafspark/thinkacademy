package androidx.camera.core;

import androidx.camera.core.CameraState;
import java.util.Objects;

final class AutoValue_CameraState extends CameraState {
    private final CameraState.StateError error;
    private final CameraState.Type type;

    AutoValue_CameraState(CameraState.Type type2, CameraState.StateError stateError) {
        Objects.requireNonNull(type2, "Null type");
        this.type = type2;
        this.error = stateError;
    }

    public CameraState.Type getType() {
        return this.type;
    }

    public CameraState.StateError getError() {
        return this.error;
    }

    public String toString() {
        return "CameraState{type=" + this.type + ", error=" + this.error + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CameraState)) {
            return false;
        }
        CameraState cameraState = (CameraState) obj;
        if (this.type.equals(cameraState.getType())) {
            CameraState.StateError stateError = this.error;
            if (stateError == null) {
                if (cameraState.getError() == null) {
                    return true;
                }
            } else if (stateError.equals(cameraState.getError())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (this.type.hashCode() ^ 1000003) * 1000003;
        CameraState.StateError stateError = this.error;
        return hashCode ^ (stateError == null ? 0 : stateError.hashCode());
    }
}
