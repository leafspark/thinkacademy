package com.tal.app.thinkacademy.lib.shareprefrence;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.tal.app.thinkacademy.live.business.livemessage.entity.LiveMessageCode;
import java.io.PrintStream;

public class CacheSDKManager {
    protected static boolean isEnableOpenSafeMode = false;
    private static final String mKey = "elwalYZNt7xCU+lQwQYcIdgVnrh29RKLEL3+/mkA8uA=";
    private static String mRegistrationCode;
    public static Context sAppContext;

    public interface OnGuardInitlistener {
        void over(boolean z);
    }

    public static void init(Context context) {
        init(context, (OnGuardInitlistener) null);
    }

    public static void init(Context context, OnGuardInitlistener onGuardInitlistener) {
        init(context, (String) null, onGuardInitlistener);
    }

    public static void init(Context context, String str, OnGuardInitlistener onGuardInitlistener) {
        if (sAppContext == null) {
            sAppContext = context;
        }
        if (TextUtils.isEmpty(str)) {
            mRegistrationCode = getJDRobileCacheSDK();
        }
        mRegistrationCode = str;
    }

    public static boolean enableOpenSafeMode() {
        return isEnableOpenSafeMode;
    }

    public static String getCacheKey(String str) {
        try {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(mRegistrationCode)) {
                return str;
            }
            return str + mRegistrationCode;
        } catch (Exception unused) {
            return str;
        }
    }

    public static int getAppVersion() {
        try {
            return sAppContext.getPackageManager().getPackageInfo(sAppContext.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 1;
        }
    }

    private static String getJDRobileCacheSDK() {
        try {
            return sAppContext.getPackageManager().getApplicationInfo(sAppContext.getPackageName(), LiveMessageCode.LIVE_BUSINESS_VOTE_ALL_THUMBS_UP).metaData.getString("JDRobileCacheSDK");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void getVersion() {
        try {
            PackageInfo packageInfo = sAppContext.getPackageManager().getPackageInfo(sAppContext.getPackageName(), 0);
            String charSequence = packageInfo.applicationInfo.loadLabel(sAppContext.getPackageManager()).toString();
            String str = packageInfo.versionName;
            PrintStream printStream = System.out;
            printStream.println("appName:" + charSequence);
            PrintStream printStream2 = System.out;
            printStream2.println("versionName:" + str);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
