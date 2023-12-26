package com.aliyun.sls.android.producer.utils;

import android.content.Context;
import android.os.SystemClock;
import androidx.browser.trusted.sharing.ShareTarget;
import com.aliyun.sls.android.producer.Log;
import com.aliyun.sls.android.producer.LogProducerHttpTool;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public class TimeUtils {
    private static long elapsedRealTime;
    private static long serverTime;

    private TimeUtils() {
    }

    public static void startUpdateServerTime(Context context, String str, String str2) {
        if (context == null || context.getPackageManager().checkPermission("android.permission.INTERNET", context.getPackageName()) == 0) {
            if (str.contains("http")) {
                str = str.substring(str.indexOf("://") + 3);
            }
            final String str3 = "https://" + str2 + "." + str + "/servertime";
            final String[] strArr = {"x-log-apiversion", "0.6.0"};
            ThreadUtils.exec(new Runnable() {
                public void run() {
                    LogProducerHttpTool.android_http_post(str3, ShareTarget.METHOD_GET, strArr, new byte[0]);
                }
            });
        }
    }

    public static void updateServerTime(long j) {
        serverTime = j;
        elapsedRealTime = SystemClock.elapsedRealtime();
    }

    public static long getTimeInMillis() {
        if (0 == elapsedRealTime) {
            return System.currentTimeMillis() / 1000;
        }
        return serverTime + ((SystemClock.elapsedRealtime() - elapsedRealTime) / 1000);
    }

    public static void fixTime(Log log) {
        Map<String, String> content;
        String str;
        if (log != null && (content = log.getContent()) != null && content.size() != 0 && content.containsKey("local_timestamp")) {
            Date date = new Date();
            String str2 = content.get("local_timestamp");
            if (str2.length() < 10) {
                str = String.valueOf(System.currentTimeMillis());
            } else {
                str = str2.substring(0, 10) + String.valueOf(date.getTime()).substring(10);
            }
            date.setTime(safe2Long(str));
            content.put("local_time_fixed", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.getDefault()).format(date));
            content.put("local_timestamp_fixed", str);
        }
    }

    private static long safe2Long(String str) {
        try {
            return Long.parseLong(str);
        } catch (Throwable unused) {
            return System.currentTimeMillis();
        }
    }
}
