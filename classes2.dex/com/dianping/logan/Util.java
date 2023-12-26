package com.dianping.logan;

import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.FilenameFilter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Util {
    private static final String FILE_FORMAT = "%s_%s_%s";
    private static final String FILE_FORMAT_EXTRA = "%s_%s_%s_%s";
    private static final AtomicInteger mCurrentFileIndex = new AtomicInteger(0);
    private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static long getCurrentTime() {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            SimpleDateFormat simpleDateFormat = sDateFormat;
            return simpleDateFormat.parse(simpleDateFormat.format(new Date(currentTimeMillis))).getTime();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String getDateStr(long j) {
        return sDateFormat.format(new Date(j));
    }

    public static long getDateTime(String str) {
        try {
            return sDateFormat.parse(str).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static synchronized void resetIndex(File file, final long j) {
        synchronized (Util.class) {
            File[] listFiles = file.listFiles(new FilenameFilter() {
                public boolean accept(File file, String str) {
                    return str.startsWith(String.valueOf(j));
                }
            });
            mCurrentFileIndex.set(0);
            if (listFiles != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    logI("Util", "filter currentFile: " + file2.getName());
                    String[] split = file2.getName().split("_");
                    if (split.length > 1) {
                        try {
                            int parseInt = Integer.parseInt(split[1]);
                            AtomicInteger atomicInteger = mCurrentFileIndex;
                            if (atomicInteger.intValue() < parseInt) {
                                atomicInteger.set(parseInt);
                            }
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            logI("Util", "resetIndex: " + mCurrentFileIndex.get());
        }
    }

    private static synchronized int increaseIndex() {
        int incrementAndGet;
        synchronized (Util.class) {
            incrementAndGet = mCurrentFileIndex.incrementAndGet();
        }
        return incrementAndGet;
    }

    public static String newFileName(long j) {
        return String.format(FILE_FORMAT, new Object[]{Long.valueOf(j), Integer.valueOf(increaseIndex()), Long.valueOf(System.currentTimeMillis())});
    }

    public static String newFileNameWithExtra(long j, String str) {
        if (TextUtils.isEmpty(str)) {
            return newFileName(j);
        }
        return String.format(FILE_FORMAT_EXTRA, new Object[]{Long.valueOf(j), Integer.valueOf(increaseIndex()), Long.valueOf(System.currentTimeMillis()), str});
    }

    public static Long formatFileTime(String str) {
        try {
            return Long.valueOf(Long.parseLong(str.split("_")[0]));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static void logI(String str, String str2) {
        if (Logan.sDebug) {
            Log.i("LoganDebug", str + ":" + str2);
        }
    }
}
