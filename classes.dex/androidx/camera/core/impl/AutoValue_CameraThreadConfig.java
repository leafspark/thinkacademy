package androidx.camera.core.impl;

import android.os.Handler;
import java.util.Objects;
import java.util.concurrent.Executor;

final class AutoValue_CameraThreadConfig extends CameraThreadConfig {
    private final Executor cameraExecutor;
    private final Handler schedulerHandler;

    AutoValue_CameraThreadConfig(Executor executor, Handler handler) {
        Objects.requireNonNull(executor, "Null cameraExecutor");
        this.cameraExecutor = executor;
        Objects.requireNonNull(handler, "Null schedulerHandler");
        this.schedulerHandler = handler;
    }

    public Executor getCameraExecutor() {
        return this.cameraExecutor;
    }

    public Handler getSchedulerHandler() {
        return this.schedulerHandler;
    }

    public String toString() {
        return "CameraThreadConfig{cameraExecutor=" + this.cameraExecutor + ", schedulerHandler=" + this.schedulerHandler + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CameraThreadConfig)) {
            return false;
        }
        CameraThreadConfig cameraThreadConfig = (CameraThreadConfig) obj;
        if (!this.cameraExecutor.equals(cameraThreadConfig.getCameraExecutor()) || !this.schedulerHandler.equals(cameraThreadConfig.getSchedulerHandler())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.cameraExecutor.hashCode() ^ 1000003) * 1000003) ^ this.schedulerHandler.hashCode();
    }
}
