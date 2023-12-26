package com.wushuangtech.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.wushuangtech.constants.LocalSDKConstants;
import com.yalantis.ucrop.view.CropImageView;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class DeviceUtils {
    private static final FileFilter CPU_FILTER = new FileFilter() {
        public boolean accept(File file) {
            String name = file.getName();
            if (!name.startsWith("cpu")) {
                return false;
            }
            for (int i = 3; i < name.length(); i++) {
                if (name.charAt(i) < '0' || name.charAt(i) > '9') {
                    return false;
                }
            }
            return true;
        }
    };
    private static final String TAG = "DeviceUtils";
    private RandomAccessFile mAppProcStatFile;
    private Context mContext;
    private int mCpuCoreNum;
    private long mLastAppCpuTime;
    private CpuStatus mLastAppTotalCpuStatus = new CpuStatus();
    private CpuStatus mLastTotalCpuStatus = new CpuStatus();
    private final Object mLock = new Object();
    private RandomAccessFile mProcStatFile;

    public static int[] adjustSizeByRotate(int i, int i2, int i3) {
        if (i3 == 90 || i3 == 270 ? i > i2 : i < i2) {
            int i4 = i ^ i2;
            i2 ^= i4;
            i = i4 ^ i2;
        }
        return new int[]{i, i2};
    }

    public DeviceUtils(Context context) {
        this.mContext = context;
    }

    public void initCpuInfos() {
        synchronized (this.mLock) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile("/proc/stat", "r");
                try {
                    RandomAccessFile randomAccessFile2 = new RandomAccessFile("/proc/" + Process.myPid() + "/stat", "r");
                    this.mProcStatFile = randomAccessFile;
                    this.mAppProcStatFile = randomAccessFile2;
                    CpuStatus cpuStatus = new CpuStatus();
                    if (getTotalCpuTime(cpuStatus)) {
                        this.mLastTotalCpuStatus = cpuStatus;
                        CpuStatus cpuStatus2 = new CpuStatus();
                        if (getTotalCpuTime(cpuStatus2)) {
                            this.mLastAppTotalCpuStatus = cpuStatus2;
                            long appCpuTime = getAppCpuTime();
                            if (appCpuTime > 0) {
                                this.mLastAppCpuTime = appCpuTime;
                            }
                        }
                    }
                } catch (Exception e) {
                    String str = TAG;
                    OmniLog.e(str, "Open app proc stat file is failed... crash info : " + e.getLocalizedMessage());
                } catch (Throwable th) {
                    throw th;
                }
            } catch (Exception e2) {
                String str2 = TAG;
                OmniLog.e(str2, "Open proc stat file is failed... crash info : " + e2.getLocalizedMessage());
            }
        }
    }

    public void initCpuCoreNum() {
        synchronized (this.mLock) {
            try {
                File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(CPU_FILTER);
                int length = listFiles != null ? listFiles.length : 0;
                if (length != 0) {
                    this.mCpuCoreNum = length;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void clearResource() {
        synchronized (this.mLock) {
            RandomAccessFile randomAccessFile = this.mProcStatFile;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e) {
                    String str = TAG;
                    OmniLog.e(str, " closeRandomAccessFile --> get crash : " + e.getLocalizedMessage());
                }
                this.mProcStatFile = null;
            }
            RandomAccessFile randomAccessFile2 = this.mAppProcStatFile;
            if (randomAccessFile2 != null) {
                try {
                    randomAccessFile2.close();
                } catch (IOException e2) {
                    String str2 = TAG;
                    OmniLog.e(str2, " closeRandomAccessFile --> get crash : " + e2.getLocalizedMessage());
                }
                this.mAppProcStatFile = null;
            }
            this.mLastTotalCpuStatus = null;
            this.mLastAppTotalCpuStatus = null;
            this.mContext = null;
        }
    }

    private float getAvailableMemory() {
        ActivityManager activityManager;
        Context context = this.mContext;
        if (context == null || (activityManager = (ActivityManager) context.getSystemService("activity")) == null) {
            return CropImageView.DEFAULT_ASPECT_RATIO;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return (((float) memoryInfo.availMem) / 1024.0f) / 1024.0f;
    }

    public static float getAppUsedJavaMemory() {
        return (((float) Runtime.getRuntime().totalMemory()) / 1024.0f) / 1024.0f;
    }

    public float getAppUsedMemory() {
        Context context = this.mContext;
        if (context == null) {
            return CropImageView.DEFAULT_ASPECT_RATIO;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null) {
                return CropImageView.DEFAULT_ASPECT_RATIO;
            }
            Debug.MemoryInfo[] processMemoryInfo = activityManager.getProcessMemoryInfo(new int[]{Process.myPid()});
            if (processMemoryInfo != null) {
                if (processMemoryInfo.length > 0) {
                    int totalPss = processMemoryInfo[0].getTotalPss();
                    if (totalPss <= 0) {
                        return CropImageView.DEFAULT_ASPECT_RATIO;
                    }
                    return ((float) totalPss) / 1024.0f;
                }
            }
            OmniLog.w(TAG, "getAppProcessCpuRate --> index is -1! ");
            return CropImageView.DEFAULT_ASPECT_RATIO;
        } catch (Exception e) {
            String str = TAG;
            OmniLog.w(str, "getAppUsedMemory exception --> " + e.getLocalizedMessage());
            return CropImageView.DEFAULT_ASPECT_RATIO;
        }
    }

    public float getSysUsedMemory() {
        float totalMemory = getTotalMemory();
        if (totalMemory == CropImageView.DEFAULT_ASPECT_RATIO) {
            return CropImageView.DEFAULT_ASPECT_RATIO;
        }
        float availableMemory = getAvailableMemory();
        if (availableMemory <= CropImageView.DEFAULT_ASPECT_RATIO) {
            return CropImageView.DEFAULT_ASPECT_RATIO;
        }
        return totalMemory - availableMemory;
    }

    public float getUsedPercentValue() {
        float totalMemory = getTotalMemory();
        if (totalMemory == CropImageView.DEFAULT_ASPECT_RATIO) {
            return CropImageView.DEFAULT_ASPECT_RATIO;
        }
        float availableMemory = getAvailableMemory();
        if (availableMemory <= CropImageView.DEFAULT_ASPECT_RATIO) {
            return CropImageView.DEFAULT_ASPECT_RATIO;
        }
        return (totalMemory - availableMemory) / totalMemory;
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x0154 A[SYNTHETIC, Splitter:B:54:0x0154] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0176 A[SYNTHETIC, Splitter:B:62:0x0176] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public float getTotalMemory() {
        /*
            r8 = this;
            java.lang.String r0 = "getAppProcessCpuRate --> BufferedReader close exception! "
            java.lang.String r1 = "/proc/meminfo"
            r2 = 0
            r3 = 0
            java.io.FileReader r4 = new java.io.FileReader     // Catch:{ Exception -> 0x0134, all -> 0x0132 }
            r4.<init>(r1)     // Catch:{ Exception -> 0x0134, all -> 0x0132 }
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0134, all -> 0x0132 }
            r5 = 2048(0x800, float:2.87E-42)
            r1.<init>(r4, r5)     // Catch:{ Exception -> 0x0134, all -> 0x0132 }
            java.lang.String r3 = r1.readLine()     // Catch:{ Exception -> 0x0130 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0130 }
            if (r4 == 0) goto L_0x0050
            java.lang.String r4 = TAG     // Catch:{ Exception -> 0x0130 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0130 }
            r5.<init>()     // Catch:{ Exception -> 0x0130 }
            java.lang.String r6 = "getAppProcessCpuRate --> memoryLine is empty! "
            r5.append(r6)     // Catch:{ Exception -> 0x0130 }
            r5.append(r3)     // Catch:{ Exception -> 0x0130 }
            java.lang.String r3 = r5.toString()     // Catch:{ Exception -> 0x0130 }
            com.wushuangtech.utils.OmniLog.w(r4, r3)     // Catch:{ Exception -> 0x0130 }
            r1.close()     // Catch:{ IOException -> 0x0036 }
            goto L_0x004f
        L_0x0036:
            r1 = move-exception
            java.lang.String r3 = TAG
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            java.lang.String r0 = r1.getLocalizedMessage()
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            com.wushuangtech.utils.OmniLog.w(r3, r0)
        L_0x004f:
            return r2
        L_0x0050:
            java.lang.String r4 = "MemTotal:"
            int r4 = r3.indexOf(r4)     // Catch:{ Exception -> 0x0130 }
            r5 = -1
            if (r4 != r5) goto L_0x008d
            java.lang.String r4 = TAG     // Catch:{ Exception -> 0x0130 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0130 }
            r5.<init>()     // Catch:{ Exception -> 0x0130 }
            java.lang.String r6 = "getAppProcessCpuRate --> index is -1! "
            r5.append(r6)     // Catch:{ Exception -> 0x0130 }
            r5.append(r3)     // Catch:{ Exception -> 0x0130 }
            java.lang.String r3 = r5.toString()     // Catch:{ Exception -> 0x0130 }
            com.wushuangtech.utils.OmniLog.w(r4, r3)     // Catch:{ Exception -> 0x0130 }
            r1.close()     // Catch:{ IOException -> 0x0073 }
            goto L_0x008c
        L_0x0073:
            r1 = move-exception
            java.lang.String r3 = TAG
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            java.lang.String r0 = r1.getLocalizedMessage()
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            com.wushuangtech.utils.OmniLog.w(r3, r0)
        L_0x008c:
            return r2
        L_0x008d:
            java.lang.String r4 = r3.substring(r4)     // Catch:{ Exception -> 0x0130 }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0130 }
            if (r5 == 0) goto L_0x00cb
            java.lang.String r4 = TAG     // Catch:{ Exception -> 0x0130 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0130 }
            r5.<init>()     // Catch:{ Exception -> 0x0130 }
            java.lang.String r6 = "getAppProcessCpuRate --> subMemoryLine is empty! "
            r5.append(r6)     // Catch:{ Exception -> 0x0130 }
            r5.append(r3)     // Catch:{ Exception -> 0x0130 }
            java.lang.String r3 = r5.toString()     // Catch:{ Exception -> 0x0130 }
            com.wushuangtech.utils.OmniLog.w(r4, r3)     // Catch:{ Exception -> 0x0130 }
            r1.close()     // Catch:{ IOException -> 0x00b1 }
            goto L_0x00ca
        L_0x00b1:
            r1 = move-exception
            java.lang.String r3 = TAG
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            java.lang.String r0 = r1.getLocalizedMessage()
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            com.wushuangtech.utils.OmniLog.w(r3, r0)
        L_0x00ca:
            return r2
        L_0x00cb:
            java.lang.String r5 = "\\D+"
            java.lang.String r6 = ""
            java.lang.String r4 = r4.replaceAll(r5, r6)     // Catch:{ Exception -> 0x0130 }
            float r4 = java.lang.Float.parseFloat(r4)     // Catch:{ Exception -> 0x0130 }
            int r5 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r5 > 0) goto L_0x010f
            java.lang.String r4 = TAG     // Catch:{ Exception -> 0x0130 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0130 }
            r5.<init>()     // Catch:{ Exception -> 0x0130 }
            java.lang.String r6 = "Get total memory -> totalMemorySize is less than zero! "
            r5.append(r6)     // Catch:{ Exception -> 0x0130 }
            r5.append(r3)     // Catch:{ Exception -> 0x0130 }
            java.lang.String r3 = r5.toString()     // Catch:{ Exception -> 0x0130 }
            com.wushuangtech.utils.OmniLog.w(r4, r3)     // Catch:{ Exception -> 0x0130 }
            r1.close()     // Catch:{ IOException -> 0x00f5 }
            goto L_0x010e
        L_0x00f5:
            r1 = move-exception
            java.lang.String r3 = TAG
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            java.lang.String r0 = r1.getLocalizedMessage()
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            com.wushuangtech.utils.OmniLog.w(r3, r0)
        L_0x010e:
            return r2
        L_0x010f:
            r2 = 1149239296(0x44800000, float:1024.0)
            float r4 = r4 / r2
            r1.close()     // Catch:{ IOException -> 0x0116 }
            goto L_0x012f
        L_0x0116:
            r1 = move-exception
            java.lang.String r2 = TAG
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            java.lang.String r0 = r1.getLocalizedMessage()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            com.wushuangtech.utils.OmniLog.w(r2, r0)
        L_0x012f:
            return r4
        L_0x0130:
            r3 = move-exception
            goto L_0x0138
        L_0x0132:
            r2 = move-exception
            goto L_0x0174
        L_0x0134:
            r1 = move-exception
            r7 = r3
            r3 = r1
            r1 = r7
        L_0x0138:
            java.lang.String r4 = TAG     // Catch:{ all -> 0x0172 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0172 }
            r5.<init>()     // Catch:{ all -> 0x0172 }
            java.lang.String r6 = "Get total memory -> Exception : "
            r5.append(r6)     // Catch:{ all -> 0x0172 }
            java.lang.String r3 = r3.getLocalizedMessage()     // Catch:{ all -> 0x0172 }
            r5.append(r3)     // Catch:{ all -> 0x0172 }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x0172 }
            com.wushuangtech.utils.OmniLog.w(r4, r3)     // Catch:{ all -> 0x0172 }
            if (r1 == 0) goto L_0x0171
            r1.close()     // Catch:{ IOException -> 0x0158 }
            goto L_0x0171
        L_0x0158:
            r1 = move-exception
            java.lang.String r3 = TAG
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            java.lang.String r0 = r1.getLocalizedMessage()
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            com.wushuangtech.utils.OmniLog.w(r3, r0)
        L_0x0171:
            return r2
        L_0x0172:
            r2 = move-exception
            r3 = r1
        L_0x0174:
            if (r3 == 0) goto L_0x0193
            r3.close()     // Catch:{ IOException -> 0x017a }
            goto L_0x0193
        L_0x017a:
            r1 = move-exception
            java.lang.String r3 = TAG
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            java.lang.String r0 = r1.getLocalizedMessage()
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            com.wushuangtech.utils.OmniLog.w(r3, r0)
        L_0x0193:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.utils.DeviceUtils.getTotalMemory():float");
    }

    public int getNumberOfCPUCores() {
        return this.mCpuCoreNum;
    }

    public double getAppCpuUsedRate() {
        if (Build.VERSION.SDK_INT >= 26) {
            return 0.0d;
        }
        CpuStatus cpuStatus = this.mLastAppTotalCpuStatus;
        if (cpuStatus == null) {
            cpuStatus = new CpuStatus();
            if (!getTotalCpuTime(cpuStatus)) {
                return 0.0d;
            }
            this.mLastAppTotalCpuStatus = cpuStatus;
        }
        long j = this.mLastAppCpuTime;
        if (j <= 0) {
            j = getAppCpuTime();
            if (j <= 0) {
                return 0.0d;
            }
        }
        CpuStatus cpuStatus2 = new CpuStatus();
        long totalCpuDiff = getTotalCpuDiff(cpuStatus, cpuStatus2);
        if (totalCpuDiff <= 0) {
            logE("Get app cpu rate failed... " + "totalCpuDiff  less than zero!" + cpuStatus + " - " + cpuStatus2);
            return 0.0d;
        }
        long appCpuTime = getAppCpuTime();
        if (appCpuTime <= 0) {
            logE("Get app cpu rate failed... " + "appCpuTimeDiff less than zero! " + appCpuTime + " - " + j);
            return 0.0d;
        }
        long j2 = appCpuTime - j;
        if (j2 <= 0) {
            logE("Get app cpu rate failed... " + "appCpuTimeDiff less than zero! " + appCpuTime + " - " + j);
            return 0.0d;
        } else if (j2 > totalCpuDiff) {
            logE("Get app cpu rate failed... " + "appCpuTimeDiff > totalCpuDiff" + j2 + " - " + totalCpuDiff);
            return 0.0d;
        } else {
            double d = ((double) j2) / ((double) totalCpuDiff);
            this.mLastAppCpuTime = appCpuTime;
            cpuStatus.copyValues(cpuStatus2);
            if (d >= 0.0d && d <= 1.0d) {
                return d;
            }
            String str = TAG;
            OmniLog.w(str, "getAppProcessCpuRate --> cpuRate less than zero! " + d);
            return 0.0d;
        }
    }

    public double getSysCpuUsedRate() {
        if (Build.VERSION.SDK_INT >= 26) {
            return 0.0d;
        }
        CpuStatus cpuStatus = this.mLastTotalCpuStatus;
        if (cpuStatus == null) {
            cpuStatus = new CpuStatus();
            if (!getTotalCpuTime(cpuStatus)) {
                return 0.0d;
            }
            this.mLastTotalCpuStatus = cpuStatus;
        }
        CpuStatus cpuStatus2 = new CpuStatus();
        if (!getTotalCpuTime(cpuStatus2)) {
            logE("Get total cpu rate failed... " + "<getTotalCpuTime> execute failed...");
            return 0.0d;
        }
        long totalTime = cpuStatus2.getTotalTime();
        long totalTime2 = cpuStatus.getTotalTime();
        long j = totalTime - totalTime2;
        if (j <= 0) {
            logE("Get total cpu rate failed... " + "<totalCpuTimeDiff> is zero... " + totalTime + " - " + totalTime2);
            return 0.0d;
        }
        long j2 = totalTime - cpuStatus2.idletime;
        long j3 = totalTime2 - cpuStatus.idletime;
        long j4 = j2 - j3;
        if (j4 <= 0) {
            logE("Get total cpu rate failed... " + "<totalCpuTimeDiff> is zero... " + j2 + " - " + j3);
            return 0.0d;
        }
        double d = ((double) j4) / ((double) j);
        cpuStatus.copyValues(cpuStatus2);
        if (d < 0.0d || d > 1.0d) {
            return 0.0d;
        }
        return d;
    }

    public static int getOrientation(Context context) {
        Display defaultDisplay;
        if (context == null) {
            return 1;
        }
        try {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null) {
                return 1;
            }
            return defaultDisplay.getRotation();
        } catch (Exception unused) {
            return 1;
        }
    }

    public static int getRotation(Context context) {
        Display defaultDisplay;
        if (context == null) {
            return -1;
        }
        try {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null) {
                return -1;
            }
            return defaultDisplay.getRotation();
        } catch (Exception unused) {
            return -1;
        }
    }

    public static int getRotate(int i) {
        int i2 = i == 0 ? 0 : i == 1 ? 90 : i == 2 ? LocalSDKConstants.SCREEN_ROTATE_180 : i == 3 ? LocalSDKConstants.SCREEN_ROTATE_270 : -1;
        if (i2 == -1) {
            String str = TAG;
            OmniLog.e(str, "Change rotation to rotate failed! rotation = " + i);
        }
        return i2;
    }

    private boolean getTotalCpuTime(CpuStatus cpuStatus) {
        RandomAccessFile randomAccessFile = this.mProcStatFile;
        if (Build.VERSION.SDK_INT < 26 && randomAccessFile != null) {
            try {
                randomAccessFile.seek(0);
                String readLine = randomAccessFile.readLine();
                if (TextUtils.isEmpty(readLine)) {
                    logE("Get total cpu time failed... " + "content is empty...");
                    return false;
                }
                String[] split = readLine.split(" ");
                if (split.length < 9) {
                    return false;
                }
                try {
                    cpuStatus.usertime = Long.parseLong(split[2]);
                    cpuStatus.nicetime = Long.parseLong(split[3]);
                    cpuStatus.systemtime = Long.parseLong(split[4]);
                    cpuStatus.idletime = Long.parseLong(split[5]);
                    cpuStatus.iowaittime = Long.parseLong(split[6]);
                    cpuStatus.irqtime = Long.parseLong(split[7]);
                    cpuStatus.softirqtime = Long.parseLong(split[8]);
                    return true;
                } catch (NumberFormatException unused) {
                    logE("Get total cpu time failed... " + "NumberFormatException happened...");
                    return false;
                }
            } catch (IOException unused2) {
                logE("Get total cpu time failed... " + "IOException happened...");
            }
        }
        return false;
    }

    private long getAppCpuTime() {
        RandomAccessFile randomAccessFile = this.mAppProcStatFile;
        if (Build.VERSION.SDK_INT < 26 && randomAccessFile != null) {
            try {
                randomAccessFile.seek(0);
                String readLine = randomAccessFile.readLine();
                if (TextUtils.isEmpty(readLine)) {
                    logE("Get app cpu time failed... " + "content is empty...");
                    return -1;
                }
                String[] split = readLine.split(" ");
                if (split.length < 17) {
                    return -1;
                }
                try {
                    return Long.parseLong(split[13]) + Long.parseLong(split[14]) + Long.parseLong(split[15]) + Long.parseLong(split[16]);
                } catch (NumberFormatException unused) {
                    logE("Get app cpu time failed... " + "NumberFormatException happened...");
                    return -1;
                }
            } catch (IOException unused2) {
                logE("Get app cpu time failed... " + "IOException happened...");
            }
        }
        return -1;
    }

    private long getTotalCpuDiff(CpuStatus cpuStatus, CpuStatus cpuStatus2) {
        long totalTime = cpuStatus.getTotalTime();
        if (!getTotalCpuTime(cpuStatus2)) {
            logE("Get total cpu time diff failed... totalCpuTime less than zero!");
            return 0;
        }
        long totalTime2 = cpuStatus2.getTotalTime();
        long j = totalTime2 - totalTime;
        if (j > 0) {
            return j;
        }
        logE("Get total cpu time diff failed... less than zero! " + totalTime2 + " - " + totalTime);
        return 0;
    }

    private void logE(String str) {
        OmniLog.e(TAG, str);
    }

    private static class CpuStatus {
        long idletime;
        long iowaittime;
        long irqtime;
        long nicetime;
        long softirqtime;
        long systemtime;
        long usertime;

        private CpuStatus() {
        }

        /* access modifiers changed from: package-private */
        public void copyValues(CpuStatus cpuStatus) {
            this.usertime = cpuStatus.usertime;
            this.nicetime = cpuStatus.nicetime;
            this.systemtime = cpuStatus.systemtime;
            this.idletime = cpuStatus.idletime;
            this.iowaittime = cpuStatus.iowaittime;
            this.irqtime = cpuStatus.irqtime;
            this.softirqtime = cpuStatus.softirqtime;
        }

        /* access modifiers changed from: package-private */
        public long getTotalTime() {
            return this.usertime + this.nicetime + this.systemtime + this.idletime + this.iowaittime + this.irqtime + this.softirqtime;
        }
    }
}
