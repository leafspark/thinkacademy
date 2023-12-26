package io.agora.rtc.utils;

import android.content.Context;
import android.view.WindowManager;
import com.wushuangtech.constants.LocalSDKConstants;
import io.agora.rtc.internal.RtcEngineImpl;

public class AgoraUtils {
    private static final String TAG = "AgoraUtils";

    public static boolean ensureNativeLibsInitialized() {
        return RtcEngineImpl.initializeNativeLibs();
    }

    public static int getFrameOrientation(int i, int i2, boolean z, boolean z2) {
        if (!z) {
            return ((i2 - i) + 360) % 360;
        }
        int i3 = (i2 + i) % 360;
        if (z2) {
            return (360 - i3) % 360;
        }
        return i3;
    }

    public static int getDisplayRotation(Context context) {
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        if (rotation == 1) {
            return 90;
        }
        if (rotation == 2) {
            return LocalSDKConstants.SCREEN_ROTATE_180;
        }
        if (rotation != 3) {
            return 0;
        }
        return LocalSDKConstants.SCREEN_ROTATE_270;
    }
}
