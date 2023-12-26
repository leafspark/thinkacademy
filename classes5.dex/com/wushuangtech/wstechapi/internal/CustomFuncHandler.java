package com.wushuangtech.wstechapi.internal;

import android.text.TextUtils;
import com.wushuangtech.api.EnterConfApi;
import com.wushuangtech.library.GlobalConfig;

public class CustomFuncHandler {
    public boolean processParams(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String[] split = str.split(":");
            if (split == null || split.length != 2) {
                return false;
            }
            return processParams(split[0], split[1]);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004f, code lost:
        if (r5.equals(com.wushuangtech.constants.LocalSDKConstants.PARAMETERS_BRANCH) == false) goto L_0x001b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean processParams(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            r1 = 0
            if (r0 != 0) goto L_0x006e
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 == 0) goto L_0x000f
            goto L_0x006e
        L_0x000f:
            r5.hashCode()
            r0 = -1
            int r2 = r5.hashCode()
            r3 = 1
            switch(r2) {
                case -1618907234: goto L_0x0049;
                case -1379841197: goto L_0x003e;
                case -356951762: goto L_0x0033;
                case 878871241: goto L_0x0028;
                case 1950241694: goto L_0x001d;
                default: goto L_0x001b;
            }
        L_0x001b:
            r1 = r0
            goto L_0x0052
        L_0x001d:
            java.lang.String r1 = "ComLatSdkAppBackgroundState"
            boolean r5 = r5.equals(r1)
            if (r5 != 0) goto L_0x0026
            goto L_0x001b
        L_0x0026:
            r1 = 4
            goto L_0x0052
        L_0x0028:
            java.lang.String r1 = "ComLatSdkSetImgReportApi"
            boolean r5 = r5.equals(r1)
            if (r5 != 0) goto L_0x0031
            goto L_0x001b
        L_0x0031:
            r1 = 3
            goto L_0x0052
        L_0x0033:
            java.lang.String r1 = "ComLatSdkVideoLocalRawDataReplace"
            boolean r5 = r5.equals(r1)
            if (r5 != 0) goto L_0x003c
            goto L_0x001b
        L_0x003c:
            r1 = 2
            goto L_0x0052
        L_0x003e:
            java.lang.String r1 = "ComLatSdkSetSignalTimeout"
            boolean r5 = r5.equals(r1)
            if (r5 != 0) goto L_0x0047
            goto L_0x001b
        L_0x0047:
            r1 = r3
            goto L_0x0052
        L_0x0049:
            java.lang.String r2 = "ComLatSdkBranch"
            boolean r5 = r5.equals(r2)
            if (r5 != 0) goto L_0x0052
            goto L_0x001b
        L_0x0052:
            switch(r1) {
                case 0: goto L_0x0069;
                case 1: goto L_0x0064;
                case 2: goto L_0x005f;
                case 3: goto L_0x005a;
                case 4: goto L_0x0056;
                default: goto L_0x0055;
            }
        L_0x0055:
            goto L_0x0059
        L_0x0056:
            r4.handleAppBackground(r6)
        L_0x0059:
            return r3
        L_0x005a:
            boolean r5 = r4.handleImageReportApi(r6)
            return r5
        L_0x005f:
            boolean r5 = r4.handleLocalRawDataReplace(r6)
            return r5
        L_0x0064:
            boolean r5 = r4.handleSignalTimeout(r6)
            return r5
        L_0x0069:
            boolean r5 = r4.handleSetBranch(r6)
            return r5
        L_0x006e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.wstechapi.internal.CustomFuncHandler.processParams(java.lang.String, java.lang.String):boolean");
    }

    private boolean handleImageReportApi(String str) {
        return EnterConfApi.getInstance().setImageReportUrl(str) == 0;
    }

    private boolean handleSignalTimeout(String str) {
        try {
            EnterConfApi.getInstance().setReconnectTimeoutSeconds(Integer.parseInt(str));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean handleSetBranch(String str) {
        try {
            GlobalConfig.mBranch = Integer.parseInt(str);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean handleLocalRawDataReplace(String str) {
        boolean z = false;
        try {
            if (Integer.parseInt(str) == 1) {
                z = true;
            }
            GlobalConfig.mVideoLocalRawDataReplaced = z;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void handleAppBackground(String str) {
        try {
            int parseInt = Integer.parseInt(str);
            EnterConfApi instance = EnterConfApi.getInstance();
            boolean z = true;
            if (parseInt != 1) {
                z = false;
            }
            instance.handleAppBackgroundStatus(z);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
