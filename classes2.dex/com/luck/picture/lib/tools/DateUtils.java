package com.luck.picture.lib.tools;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class DateUtils {
    private static final SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmssSSS");

    public static long getCurrentTimeMillis() {
        String valueOf = ValueOf.toString(Long.valueOf(System.currentTimeMillis()));
        if (valueOf.length() > 10) {
            valueOf = valueOf.substring(0, 10);
        }
        return ValueOf.toLong(valueOf);
    }

    public static int dateDiffer(long j) {
        try {
            return (int) Math.abs(getCurrentTimeMillis() - j);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static String formatDurationTime(long j) {
        return String.format(Locale.getDefault(), "%02d:%02d", new Object[]{Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(j)), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(j)))});
    }

    public static String getCreateFileName(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        return str + sf.format(Long.valueOf(currentTimeMillis));
    }

    public static String getCreateFileName() {
        return sf.format(Long.valueOf(System.currentTimeMillis()));
    }

    public static String cdTime(long j, long j2) {
        long j3 = j2 - j;
        if (j3 > 1000) {
            return (j3 / 1000) + "秒";
        }
        return j3 + "毫秒";
    }
}
