package com.tal100.chatsdk;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.tal100.chatsdk.PMDefs;
import com.tal100.chatsdk.utils.SharedPreferencesUtils;
import com.tal100.mars.comm.PlatformComm;
import java.io.File;
import java.util.List;
import java.util.UUID;

public class TMSdkManager {
    private static final String TAG = "TMSdkManager";
    public static final String TMSDK_CID_KEY = "tmsdk_client_id";
    private static volatile TMSdkManager mInstance;
    private ITMHttpDnsListener httpDnsListerer = null;
    private Context mContext = null;

    /* access modifiers changed from: package-private */
    public native String nativeGetVersion();

    /* access modifiers changed from: package-private */
    public native int nativeInit(String str, String str2, String str3, String str4, String str5, PMDefs.SdkPropertyEntity sdkPropertyEntity, PMDefs.SdkPropertyEntity sdkPropertyEntity2);

    /* access modifiers changed from: package-private */
    public native int nativeReleaseInstance();

    /* access modifiers changed from: package-private */
    public native int nativeSetForeground(boolean z);

    /* access modifiers changed from: package-private */
    public native int nativeUnInit();

    static {
        System.loadLibrary("chat-native-lib");
    }

    public static TMSdkManager getInstance() {
        if (mInstance == null) {
            synchronized (TMSdkManager.class) {
                if (mInstance == null) {
                    mInstance = new TMSdkManager();
                }
            }
        }
        return mInstance;
    }

    public static void releaseInstance() {
        if (mInstance != null) {
            mInstance.nativeReleaseInstance();
        }
    }

    private TMSdkManager() {
    }

    public ChatClient getChatClient() {
        return ChatClient.getInstance();
    }

    public TMChannelManager getChannelManager() {
        return TMChannelManager.getInstance();
    }

    public TMPushManager getPushManager() {
        return TMPushManager.getInstance();
    }

    public int init(Context context, String str, String str2, String str3, String str4, PMDefs.SdkPropertyEntity sdkPropertyEntity, PMDefs.SdkPropertyEntity sdkPropertyEntity2) {
        Context context2 = context;
        String str5 = TAG;
        Log.i(str5, "TMSdkManager-> init");
        if (context2 == null) {
            Log.e(str5, "context is null!");
            return 1;
        } else if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            Log.e(str5, "appId or appKey or workpath is null!");
            return 1;
        } else {
            String str6 = str3;
            if (!new File(str3).exists()) {
                Log.e(str5, "can not create work path!");
                return 13;
            } else if (sdkPropertyEntity == null || sdkPropertyEntity2 == null) {
                Log.e(str5, "logService or confService is null!");
                return 1;
            } else {
                this.mContext = context2;
                PlatformComm.init(context, (Handler) null);
                DeviceInfo.init(context);
                String str7 = (String) SharedPreferencesUtils.getParam(this.mContext, TMSDK_CID_KEY, "");
                if (TextUtils.isEmpty(str7)) {
                    str7 = UUID.randomUUID().toString().replaceAll("-", "");
                }
                String str8 = str7;
                SharedPreferencesUtils.setParam(context, TMSDK_CID_KEY, str8);
                nativeInit(str, str2, str8, str3, str4, sdkPropertyEntity, sdkPropertyEntity2);
                return 0;
            }
        }
    }

    public int unInit() {
        Log.i(TAG, "TMSdkManager-> uninit");
        return nativeUnInit();
    }

    public void setForeground(boolean z) {
        Log.i(TAG, "TMSdkManager-> setForeground");
        nativeSetForeground(z);
    }

    public void registerHttpDnsListerner(ITMHttpDnsListener iTMHttpDnsListener) {
        this.httpDnsListerer = iTMHttpDnsListener;
    }

    public static String[] onGetIpListByHostname(String str) {
        if (getInstance().httpDnsListerer == null || TextUtils.isEmpty(str)) {
            return new String[0];
        }
        synchronized (getInstance().httpDnsListerer) {
            List<String> lookup = getInstance().httpDnsListerer.lookup(str);
            if (lookup == null || lookup.size() <= 0) {
                String[] strArr = new String[0];
                return strArr;
            }
            String[] strArr2 = new String[lookup.size()];
            lookup.toArray(strArr2);
            return strArr2;
        }
    }

    public String getVersion() {
        return nativeGetVersion();
    }
}
