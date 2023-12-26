package com.didi.hummer.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.didi.hummer.HummerSDK;
import com.didi.hummer.render.utility.DPUtil;
import java.util.HashMap;
import java.util.Map;

public class EnvUtil {
    private static final String ENV_KEY_APP_NAME = "appName";
    private static final String ENV_KEY_APP_VERSION = "appVersion";
    private static final String ENV_KEY_AVAILABLE_HEIGHT = "availableHeight";
    private static final String ENV_KEY_AVAILABLE_WIDTH = "availableWidth";
    private static final String ENV_KEY_DEVICE_HEIGHT = "deviceHeight";
    private static final String ENV_KEY_DEVICE_WIDTH = "deviceWidth";
    private static final String ENV_KEY_NAMESPACE = "namespace";
    private static final String ENV_KEY_OS_VERSION = "osVersion";
    private static final String ENV_KEY_PLATFORM = "platform";
    private static final String ENV_KEY_SAFE_AREA_BOTTOM = "safeAreaBottom";
    private static final String ENV_KEY_SCALE = "scale";
    private static final String ENV_KEY_STATUS_BAR_HEIGHT = "statusBarHeight";
    private static Map<String, Object> gEnvs = new HashMap();

    public static void initHummerEnv(Context context) {
        int statusBarHeight = BarUtils.getStatusBarHeight(context);
        int appScreenWidth = ScreenUtils.getAppScreenWidth(context);
        int appScreenHeight = ScreenUtils.getAppScreenHeight(context);
        int i = appScreenHeight - statusBarHeight;
        int px2dp = DPUtil.px2dp(context, (float) statusBarHeight);
        float f = (float) appScreenWidth;
        int px2dp2 = DPUtil.px2dp(context, f);
        int px2dp3 = DPUtil.px2dp(context, (float) appScreenHeight);
        int px2dp4 = DPUtil.px2dp(context, f);
        int px2dp5 = DPUtil.px2dp(context, (float) i);
        gEnvs.clear();
        gEnvs.put(ENV_KEY_PLATFORM, "Android");
        gEnvs.put(ENV_KEY_OS_VERSION, Build.VERSION.RELEASE);
        gEnvs.put(ENV_KEY_APP_NAME, AppUtils.getAppName(context));
        gEnvs.put(ENV_KEY_APP_VERSION, AppUtils.getAppVersionName(context));
        gEnvs.put(ENV_KEY_STATUS_BAR_HEIGHT, Integer.valueOf(px2dp));
        gEnvs.put(ENV_KEY_SAFE_AREA_BOTTOM, 0);
        gEnvs.put(ENV_KEY_DEVICE_WIDTH, Integer.valueOf(px2dp2));
        gEnvs.put(ENV_KEY_DEVICE_HEIGHT, Integer.valueOf(px2dp3));
        gEnvs.put(ENV_KEY_AVAILABLE_WIDTH, Integer.valueOf(px2dp4));
        gEnvs.put(ENV_KEY_AVAILABLE_HEIGHT, Integer.valueOf(px2dp5));
        gEnvs.put(ENV_KEY_SCALE, Float.valueOf(ScreenUtils.getScreenDensity(context)));
    }

    public static Map<String, Object> getHummerEnv(Context context, String str) {
        Map<String, Object> map = gEnvs;
        if (map == null || map.isEmpty()) {
            initHummerEnv(context.getApplicationContext());
        }
        HashMap hashMap = new HashMap(gEnvs);
        if (!TextUtils.isEmpty(str) && !str.equals(HummerSDK.NAMESPACE_DEFAULT)) {
            hashMap.put(ENV_KEY_NAMESPACE, str);
        }
        return hashMap;
    }
}
