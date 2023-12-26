package com.wushuangtech.api;

import com.wushuangtech.utils.OmniLog;
import java.io.File;

public class ExternalLoadHelper {
    private static final String TAG = "ExternalLoadHelper";
    private static boolean mLoaded;
    private static final String[] mSoArray = {"libyuv_omni.so", "libAudioDecoder.so", "libaudioengine.so", "libclientcore.so", "libcodec_omni.so"};

    public static int load(String str) {
        boolean z;
        if (mLoaded) {
            return 0;
        }
        String[] strArr = mSoArray;
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = true;
                break;
            }
            if (!checkFileExist(str + strArr[i])) {
                z = false;
                break;
            }
            i++;
        }
        if (!z) {
            return -1002;
        }
        try {
            for (String str2 : mSoArray) {
                System.load(str + str2);
            }
            mLoaded = true;
            return 0;
        } catch (Exception e) {
            OmniLog.e(TAG, "Load failed! " + e.getLocalizedMessage());
            return -1001;
        }
    }

    public static boolean isLoaded() {
        return mLoaded;
    }

    private static boolean checkFileExist(String str) {
        return new File(str).exists();
    }
}
