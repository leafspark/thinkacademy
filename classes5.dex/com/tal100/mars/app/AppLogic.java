package com.tal100.mars.app;

import android.os.Environment;
import com.tal100.mars.comm.PlatformComm;

public class AppLogic {
    public static final String TAG = "mars.AppLogic";
    private static ICallBack callBack;

    public interface ICallBack {
        AccountInfo getAccountInfo();

        String getAppFilePath();

        int getClientVersion();

        DeviceInfo getDeviceType();
    }

    public static class AccountInfo {
        public long uin = 0;
        public String userName = "";

        public AccountInfo() {
        }

        public AccountInfo(long j, String str) {
            this.uin = j;
            this.userName = str;
        }
    }

    public static class DeviceInfo {
        public String devicename = "";
        public String devicetype = "";

        public DeviceInfo(String str, String str2) {
            this.devicename = str;
            this.devicetype = str2;
        }
    }

    public static void setCallBack(ICallBack iCallBack) {
        callBack = iCallBack;
    }

    public static String getAppFilePath() {
        try {
            ICallBack iCallBack = callBack;
            if (iCallBack != null) {
                return iCallBack.getAppFilePath();
            }
            String appFilePath = PlatformComm.getAppFilePath();
            return appFilePath == null ? Environment.getExternalStorageDirectory().getPath() : appFilePath;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static AccountInfo getAccountInfo() {
        try {
            ICallBack iCallBack = callBack;
            if (iCallBack == null) {
                return null;
            }
            return iCallBack.getAccountInfo();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static int getClientVersion() {
        try {
            ICallBack iCallBack = callBack;
            if (iCallBack == null) {
                return 0;
            }
            return iCallBack.getClientVersion();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    private static DeviceInfo getDeviceType() {
        try {
            ICallBack iCallBack = callBack;
            if (iCallBack == null) {
                return null;
            }
            return iCallBack.getDeviceType();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
