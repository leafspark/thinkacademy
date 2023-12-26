package androidx.camera.core.impl;

import androidx.camera.core.impl.StateObservable;
import java.util.Objects;

final class AutoValue_StateObservable_ErrorWrapper extends StateObservable.ErrorWrapper {
    private final Throwable error;

    AutoValue_StateObservable_ErrorWrapper(Throwable th) {
        Objects.requireNonNull(th, "Null error");
        this.error = th;
    }

    public Throwable getError() {
        return this.error;
    }

    public String toString() {
        return "ErrorWrapper{error=" + this.error + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof StateObservable.ErrorWrapper) {
            return this.error.equals(((StateObservable.ErrorWrapper) obj).getError());
        }
        return false;
    }

    public int hashCode() {
        return this.error.hashCode() ^ 1000003;
    }
}
