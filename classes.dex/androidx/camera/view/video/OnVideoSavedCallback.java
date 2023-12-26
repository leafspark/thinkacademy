package androidx.camera.view.video;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface OnVideoSavedCallback {
    public static final int ERROR_ENCODER = 1;
    public static final int ERROR_FILE_IO = 4;
    public static final int ERROR_INVALID_CAMERA = 5;
    public static final int ERROR_MUXER = 2;
    public static final int ERROR_RECORDING_IN_PROGRESS = 3;
    public static final int ERROR_UNKNOWN = 0;

    @Retention(RetentionPolicy.SOURCE)
    public @interface VideoCaptureError {
    }

    void onError(int i, String str, Throwable th);

    void onVideoSaved(OutputFileResults outputFileResults);
}
