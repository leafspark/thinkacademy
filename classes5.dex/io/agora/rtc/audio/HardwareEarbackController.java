package io.agora.rtc.audio;

import android.content.Context;
import android.os.Build;

public class HardwareEarbackController {
    private static HardwareEarbackController mInstance;
    private final String TAG = "HardwareEarbackController Java";
    private IHardwareEarback mHardwareEarback = null;

    public static HardwareEarbackController getInstance(Context context) {
        if (mInstance == null) {
            synchronized (HardwareEarbackController.class) {
                if (mInstance == null) {
                    mInstance = new HardwareEarbackController(context);
                }
            }
        }
        return mInstance;
    }

    private HardwareEarbackController(Context context) {
        String str = Build.MANUFACTURER;
        if (!str.trim().contains("vivo")) {
            if (str.trim().contains("HUAWEI") && HuaweiHardwareEarback.hasHwAudioKitClass()) {
                this.mHardwareEarback = new HuaweiHardwareEarback(context);
            } else if (str.trim().contains("OPPO") && OppoHardwareEarback.hasMediaUnitClass()) {
                this.mHardwareEarback = new OppoHardwareEarback(context);
            }
        }
    }

    public boolean isHardwareEarbackSupported() {
        IHardwareEarback iHardwareEarback = this.mHardwareEarback;
        if (iHardwareEarback != null) {
            return iHardwareEarback.isHardwareEarbackSupported();
        }
        return false;
    }

    public int enableHardwareEarback(boolean z) {
        IHardwareEarback iHardwareEarback = this.mHardwareEarback;
        if (iHardwareEarback != null) {
            return iHardwareEarback.enableEarbackFeature(z);
        }
        return -7;
    }

    public int setHardwareEarbackVolume(int i) {
        IHardwareEarback iHardwareEarback = this.mHardwareEarback;
        if (iHardwareEarback != null) {
            return iHardwareEarback.setHardwareEarbackVolume(i);
        }
        return -7;
    }
}
