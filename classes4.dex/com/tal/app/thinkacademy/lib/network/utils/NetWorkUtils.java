package com.tal.app.thinkacademy.lib.network.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Proxy;
import android.net.Uri;
import android.os.Build;
import android.preference.PreferenceManager;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.RelativeSizeSpan;
import android.widget.Toast;
import com.tal.app.thinkacademy.lib.language.LanguageUtil;
import com.tal.app.thinkacademy.lib.network.trace.NetworkTraceBean;
import com.tal.app.thinkacademy.live.business.function.bean.EnterRoomMuteData;
import java.util.LinkedHashMap;
import java.util.Map;

public final class NetWorkUtils {
    public static final long DAY = 86400000;
    public static final long HOUR = 3600000;
    public static final long MINUTE = 60000;
    public static final long SECOND = 1000;

    public static void copyToClipBoard(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
            ClipData newPlainText = ClipData.newPlainText("", str);
            if (clipboardManager != null) {
                clipboardManager.setPrimaryClip(newPlainText);
                Toast.makeText(context, "复制成功", 0).show();
            }
        }
    }

    public static boolean isWifiProxy(Context context) {
        String str;
        int i;
        if (Build.VERSION.SDK_INT >= 14) {
            str = System.getProperty("http.proxyHost");
            String property = System.getProperty("http.proxyPort");
            if (property == null) {
                property = "-1";
            }
            i = Integer.parseInt(property);
        } else {
            String host = Proxy.getHost(context);
            i = Proxy.getPort(context);
            str = host;
        }
        if (TextUtils.isEmpty(str) || i == -1) {
            return false;
        }
        return true;
    }

    public static LinkedHashMap<String, Long> transformToTraceDetail(Map<String, Long> map) {
        LinkedHashMap<String, Long> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(NetworkTraceBean.TRACE_NAME_TOTAL, Long.valueOf(getEventCostTime(map, NetworkTraceBean.CALL_START, NetworkTraceBean.CALL_END)));
        linkedHashMap.put(NetworkTraceBean.TRACE_NAME_DNS, Long.valueOf(getEventCostTime(map, NetworkTraceBean.DNS_START, NetworkTraceBean.DNS_END)));
        linkedHashMap.put(NetworkTraceBean.TRACE_NAME_SECURE_CONNECT, Long.valueOf(getEventCostTime(map, NetworkTraceBean.SECURE_CONNECT_START, NetworkTraceBean.SECURE_CONNECT_END)));
        linkedHashMap.put(NetworkTraceBean.TRACE_NAME_CONNECT, Long.valueOf(getEventCostTime(map, NetworkTraceBean.CONNECT_START, NetworkTraceBean.CONNECT_END)));
        linkedHashMap.put(NetworkTraceBean.TRACE_NAME_REQUEST_HEADERS, Long.valueOf(getEventCostTime(map, NetworkTraceBean.REQUEST_HEADERS_START, NetworkTraceBean.REQUEST_HEADERS_END)));
        linkedHashMap.put(NetworkTraceBean.TRACE_NAME_REQUEST_BODY, Long.valueOf(getEventCostTime(map, NetworkTraceBean.REQUEST_BODY_START, NetworkTraceBean.REQUEST_BODY_END)));
        linkedHashMap.put(NetworkTraceBean.TRACE_NAME_RESPONSE_HEADERS, Long.valueOf(getEventCostTime(map, NetworkTraceBean.RESPONSE_HEADERS_START, NetworkTraceBean.RESPONSE_HEADERS_END)));
        linkedHashMap.put(NetworkTraceBean.TRACE_NAME_RESPONSE_BODY, Long.valueOf(getEventCostTime(map, NetworkTraceBean.RESPONSE_BODY_START, NetworkTraceBean.RESPONSE_BODY_END)));
        return linkedHashMap;
    }

    public static long getEventCostTime(Map<String, Long> map, String str, String str2) {
        if (!map.containsKey(str) || !map.containsKey(str2)) {
            return 0;
        }
        return map.get(str2).longValue() - map.get(str).longValue();
    }

    public static boolean isTimeout(Context context, String str, Long l) {
        int settingTimeout = getSettingTimeout(context, str);
        if (settingTimeout <= 0 || l == null || l.longValue() <= ((long) settingTimeout)) {
            return false;
        }
        return true;
    }

    private static int getSettingTimeout(Context context, String str) {
        try {
            return Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(context).getString(str, EnterRoomMuteData.STATUS_UN_MUTE));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int sp2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static int dp2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static SpannableString getPrintSizeForSpannable(long j) {
        RelativeSizeSpan relativeSizeSpan = new RelativeSizeSpan(0.5f);
        if (j < 1024) {
            SpannableString spannableString = new SpannableString(String.valueOf(j) + "B");
            spannableString.setSpan(relativeSizeSpan, spannableString.length() + -1, spannableString.length(), 17);
            return spannableString;
        }
        long j2 = j / 1024;
        if (j2 < 1024) {
            SpannableString spannableString2 = new SpannableString(String.valueOf(j2) + "KB");
            spannableString2.setSpan(relativeSizeSpan, spannableString2.length() + -2, spannableString2.length(), 17);
            return spannableString2;
        }
        long j3 = j2 / 1024;
        if (j3 < 1024) {
            long j4 = j3 * 100;
            SpannableString spannableString3 = new SpannableString(String.valueOf(j4 / 100) + "." + String.valueOf(j4 % 100) + "MB");
            spannableString3.setSpan(relativeSizeSpan, spannableString3.length() + -2, spannableString3.length(), 17);
            return spannableString3;
        }
        long j5 = (j3 * 100) / 1024;
        SpannableString spannableString4 = new SpannableString(String.valueOf(j5 / 100) + "." + String.valueOf(j5 % 100) + LanguageUtil.COUNTRY_UK);
        spannableString4.setSpan(relativeSizeSpan, spannableString4.length() + -2, spannableString4.length(), 17);
        return spannableString4;
    }

    public static void openLink(Context context, String str) {
        context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }
}
