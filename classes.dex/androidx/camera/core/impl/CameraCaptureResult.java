package androidx.camera.core.impl;

import androidx.camera.core.impl.CameraCaptureMetaData;
import androidx.camera.core.impl.utils.ExifData;

public interface CameraCaptureResult {
    CameraCaptureMetaData.AeState getAeState();

    CameraCaptureMetaData.AfMode getAfMode();

    CameraCaptureMetaData.AfState getAfState();

    CameraCaptureMetaData.AwbState getAwbState();

    CameraCaptureMetaData.FlashState getFlashState();

    TagBundle getTagBundle();

    long getTimestamp();

    void populateExifData(ExifData.Builder builder);

    /* renamed from: androidx.camera.core.impl.CameraCaptureResult$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$populateExifData(CameraCaptureResult _this, ExifData.Builder builder) {
            builder.setFlashState(_this.getFlashState());
        }
    }

    public static final class EmptyCameraCaptureResult implements CameraCaptureResult {
        public long getTimestamp() {
            return -1;
        }

        public /* synthetic */ void populateExifData(ExifData.Builder builder) {
            CC.$default$populateExifData(this, builder);
        }

        public static CameraCaptureResult create() {
            return new EmptyCameraCaptureResult();
        }

        public CameraCaptureMetaData.AfMode getAfMode() {
            return CameraCaptureMetaData.AfMode.UNKNOWN;
        }

        public CameraCaptureMetaData.AfState getAfState() {
            return CameraCaptureMetaData.AfState.UNKNOWN;
        }

        public CameraCaptureMetaData.AeState getAeState() {
            return CameraCaptureMetaData.AeState.UNKNOWN;
        }

        public CameraCaptureMetaData.AwbState getAwbState() {
            return CameraCaptureMetaData.AwbState.UNKNOWN;
        }

        public CameraCaptureMetaData.FlashState getFlashState() {
            return CameraCaptureMetaData.FlashState.UNKNOWN;
        }

        public TagBundle getTagBundle() {
            return TagBundle.emptyBundle();
        }
    }
}
