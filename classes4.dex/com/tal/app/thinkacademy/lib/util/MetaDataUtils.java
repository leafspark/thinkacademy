package com.tal.app.thinkacademy.lib.util;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import com.tal.app.thinkacademy.live.business.livemessage.entity.LiveMessageCode;

public final class MetaDataUtils {
    private MetaDataUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static String getMetaDataInApp(String str) {
        try {
            return String.valueOf(Utils.getApp().getPackageManager().getApplicationInfo(Utils.getApp().getPackageName(), LiveMessageCode.LIVE_BUSINESS_VOTE_ALL_THUMBS_UP).metaData.get(str));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getMetaDataInActivity(Activity activity, String str) {
        return getMetaDataInActivity((Class<? extends Activity>) activity.getClass(), str);
    }

    public static String getMetaDataInActivity(Class<? extends Activity> cls, String str) {
        try {
            return String.valueOf(Utils.getApp().getPackageManager().getActivityInfo(new ComponentName(Utils.getApp(), cls), LiveMessageCode.LIVE_BUSINESS_VOTE_ALL_THUMBS_UP).metaData.get(str));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getMetaDataInService(Service service, String str) {
        return getMetaDataInService((Class<? extends Service>) service.getClass(), str);
    }

    public static String getMetaDataInService(Class<? extends Service> cls, String str) {
        try {
            return String.valueOf(Utils.getApp().getPackageManager().getServiceInfo(new ComponentName(Utils.getApp(), cls), LiveMessageCode.LIVE_BUSINESS_VOTE_ALL_THUMBS_UP).metaData.get(str));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getMetaDataInReceiver(BroadcastReceiver broadcastReceiver, String str) {
        return getMetaDataInReceiver(broadcastReceiver, str);
    }

    public static String getMetaDataInReceiver(Class<? extends BroadcastReceiver> cls, String str) {
        try {
            return String.valueOf(Utils.getApp().getPackageManager().getReceiverInfo(new ComponentName(Utils.getApp(), cls), LiveMessageCode.LIVE_BUSINESS_VOTE_ALL_THUMBS_UP).metaData.get(str));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }
}
