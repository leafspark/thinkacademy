package androidx.camera.camera2.internal;

import android.media.CamcorderProfile;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.quirk.CamcorderProfileResolutionQuirk;
import androidx.camera.camera2.internal.compat.quirk.CameraQuirks;
import androidx.camera.camera2.internal.compat.workaround.CamcorderProfileResolutionValidator;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CamcorderProfileProvider;
import androidx.camera.core.impl.CamcorderProfileProxy;

public class Camera2CamcorderProfileProvider implements CamcorderProfileProvider {
    private static final String TAG = "Camera2CamcorderProfileProvider";
    private final CamcorderProfileResolutionValidator mCamcorderProfileResolutionValidator;
    private final int mCameraId;
    private final boolean mHasValidCameraId;

    public Camera2CamcorderProfileProvider(String str, CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        boolean z;
        int i;
        try {
            i = Integer.parseInt(str);
            z = true;
        } catch (NumberFormatException unused) {
            Logger.w(TAG, "Camera id is not an integer: " + str + ", unable to create CamcorderProfileProvider");
            z = false;
            i = -1;
        }
        this.mHasValidCameraId = z;
        this.mCameraId = i;
        this.mCamcorderProfileResolutionValidator = new CamcorderProfileResolutionValidator((CamcorderProfileResolutionQuirk) CameraQuirks.get(str, cameraCharacteristicsCompat).get(CamcorderProfileResolutionQuirk.class));
    }

    public boolean hasProfile(int i) {
        if (!this.mHasValidCameraId || !CamcorderProfile.hasProfile(this.mCameraId, i)) {
            return false;
        }
        if (!this.mCamcorderProfileResolutionValidator.hasQuirk()) {
            return true;
        }
        return this.mCamcorderProfileResolutionValidator.hasValidVideoResolution(getProfileInternal(i));
    }

    public CamcorderProfileProxy get(int i) {
        if (!this.mHasValidCameraId || !CamcorderProfile.hasProfile(this.mCameraId, i)) {
            return null;
        }
        CamcorderProfileProxy profileInternal = getProfileInternal(i);
        if (!this.mCamcorderProfileResolutionValidator.hasValidVideoResolution(profileInternal)) {
            return null;
        }
        return profileInternal;
    }

    private CamcorderProfileProxy getProfileInternal(int i) {
        CamcorderProfile camcorderProfile;
        try {
            camcorderProfile = CamcorderProfile.get(this.mCameraId, i);
        } catch (RuntimeException e) {
            Logger.w(TAG, "Unable to get CamcorderProfile by quality: " + i, e);
            camcorderProfile = null;
        }
        if (camcorderProfile != null) {
            return CamcorderProfileProxy.fromCamcorderProfile(camcorderProfile);
        }
        return null;
    }
}
