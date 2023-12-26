package com.eaydu.omni.utils;

import android.content.Context;
import com.eaydu.omni.EngineConfig;

public class CommonUtils {
    public static boolean isApkInDebug(Context context) {
        try {
            if ((context.getApplicationInfo().flags & 2) != 0) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isTSMsg(byte[] bArr) {
        if (bArr == null || bArr.length < 16) {
            return false;
        }
        for (int i = 0; i < 16; i++) {
            if (bArr[i] != EngineConfig.SEI_TS_UUID[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isIRCMsg(byte[] bArr) {
        if (bArr == null || bArr.length < 16) {
            return false;
        }
        for (int i = 0; i < 16; i++) {
            if (bArr[i] != EngineConfig.SEI_IRC_UUID[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkRoomID(String str) {
        if (str == null || str.equals("") || str.length() > 64 || str.contains(":")) {
            return false;
        }
        return true;
    }
}
