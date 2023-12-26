package com.igexin.push.config;

import android.text.TextUtils;
import com.igexin.b.a.c.b;
import com.igexin.push.core.d;
import java.util.ArrayList;
import java.util.List;

public class SDKUrlConfig {
    public static String[] BI_ADDRESS_IPS = {"https://sdk-open-phone.getui.com/api.php"};
    public static String[] CONFIG_ADDRESS_IPS = {"https://c-hzgt2.getui.com/api.php"};
    public static String[] STATE_ADDRESS_IPS = {"https://s-gt.getui.com/api.php"};
    public static String[] XFR_ADDRESS_BAK = {"socket://43.231.145.10:5224"};
    private static final Object a = new Object();
    private static String[] b = null;
    private static String c = "HZ";
    private static String[] d = {"socket://sdk.open.talk.igexin.com:5224", "socket://sdk.open.talk.getui.net:5224", "socket://sdk.open.talk.gepush.com:5224"};
    private static volatile String e;

    public static String getBiUploadServiceUrl() {
        return BI_ADDRESS_IPS[0] + "?format=json&t=1";
    }

    public static String getCmAddress() {
        return e == null ? d[0] : e;
    }

    public static String getConfigServiceUrl() {
        return CONFIG_ADDRESS_IPS[0] + "?format=json&t=1";
    }

    public static List<String> getDefaultXfrList() {
        String[] xfrAddress = getXfrAddress();
        ArrayList arrayList = new ArrayList();
        for (String str : xfrAddress) {
            if (!arrayList.contains(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public static String[] getIdcConfigUrl() {
        return b;
    }

    public static String getLocation() {
        return c;
    }

    public static String getStatServiceUrl() {
        return STATE_ADDRESS_IPS[0] + "?format=json&t=1";
    }

    public static String[] getXfrAddress() {
        String[] strArr;
        synchronized (a) {
            strArr = d;
        }
        return strArr;
    }

    public static boolean hasMultipleXfr() {
        return getDefaultXfrList().size() > 1;
    }

    public static void setCmAddress(String str) {
        b.a("set cm address : " + str, new Object[0]);
        e = str;
    }

    public static void setIdcConfigUrl(String[] strArr) {
        b = strArr;
    }

    public static void setLocation(String str) {
        if (!TextUtils.isEmpty(str)) {
            d.d = str;
            c = str;
        }
    }

    public static void setXfrAddressIps(String[] strArr) {
        synchronized (a) {
            d = strArr;
        }
    }
}
