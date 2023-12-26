package com.tal.app.thinkacademy.common.business.browser.helper;

import android.os.Build;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.google.gson.reflect.TypeToken;
import com.tal.app.thinkacademy.common.user.UserInfo;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.common.utils.TimeZoneUtil;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.AppUtils;
import com.tal.app.thinkacademy.lib.util.GsonUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XesWebViewCookieUtils {
    private static final String TAG = "updateWhiteList";
    private static List<String> whiteList;

    static {
        ArrayList arrayList = new ArrayList();
        whiteList = arrayList;
        arrayList.add("thinkacademy");
        whiteList.add("izhikang.com");
        whiteList.add("paypal.com");
        whiteList.add("globalmathclub");
    }

    public static void updateWhiteList(String str) {
        try {
            List<String> list = (List) GsonUtils.fromJson(str, new TypeToken<List<String>>() {
            }.getType());
            if (list == null || list.size() <= 0) {
                XesLog.dt(TAG, "updateWhiteList list is empty");
                return;
            }
            XesLog.dt(TAG, "updateWhiteList threadName=" + Thread.currentThread().getName());
            whiteList = list;
        } catch (Exception e) {
            XesLog.dt(TAG, "updateWhiteList error =" + e.toString());
        }
    }

    public static void syncCookie(String str, Map<String, String> map, WebView webView) {
        String str2;
        if (map == null) {
            map = new HashMap<>();
        }
        String host = getHost(str);
        CookieManager instance = CookieManager.getInstance();
        instance.setAcceptCookie(true);
        instance.acceptCookie();
        instance.setAcceptThirdPartyCookies(webView, true);
        UserInfo userInfoEntity = UserInfoBll.getInstance().getUserInfoEntity();
        if (userInfoEntity == null) {
            str2 = "";
        } else {
            str2 = userInfoEntity.getUnifiedAccessToken();
        }
        map.put("_app_name", AppUtils.getAppName());
        map.put("_app_version", AppUtils.getAppVersionName());
        map.put("_app_system", Build.VERSION.RELEASE);
        map.put("_app_device", "Android");
        map.put("_app_token", str2);
        map.put("_official_token", str2);
        map.put("_app_timezone", TimeZoneUtil.INSTANCE.getTimeZone());
        if (map.size() > 0) {
            for (Map.Entry next : map.entrySet()) {
                if (next != null) {
                    instance.setCookie(host, ((String) next.getKey()) + "=" + ((String) next.getValue()));
                }
            }
        }
        instance.flush();
        XesLog.dt("Leather***********cookie***********" + instance.getCookie(host), new Object[0]);
    }

    private static String getHost(String str) {
        XesLog.dt("Leather***********url***********" + str, new Object[0]);
        if (TextUtils.isEmpty(str) || !validHost(str)) {
            return "";
        }
        try {
            return new URL(str).getHost();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static boolean validHost(String str) {
        for (String contains : whiteList) {
            if (str.toLowerCase().contains(contains)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isOwnHost(String str) {
        return validHost(str);
    }

    public static Map<String, String> getWebViewCookie(String str) {
        HashMap hashMap = new HashMap();
        String cookie = CookieManager.getInstance().getCookie(str);
        if (TextUtils.isEmpty(cookie)) {
            return hashMap;
        }
        for (String split : cookie.split(";")) {
            String[] split2 = split.split("=");
            if (split2.length == 2) {
                hashMap.put(split2[0], split2[1]);
            }
        }
        return hashMap;
    }

    public static void clearCookies() {
        try {
            CookieManager instance = CookieManager.getInstance();
            instance.setAcceptCookie(true);
            instance.acceptCookie();
            instance.removeSessionCookies((ValueCallback) null);
            instance.removeAllCookies((ValueCallback) null);
            instance.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
