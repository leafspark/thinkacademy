package io.agora.rtc.gdp;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.os.BatteryManager;
import android.os.Build;
import android.util.Log;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class GDPAndroid {
    private static final FileFilter CPU_FILTER = new FileFilter() {
        public boolean accept(File file) {
            String name = file.getName();
            if (!name.startsWith("cpu")) {
                return false;
            }
            for (int i = 3; i < name.length(); i++) {
                if (!Character.isDigit(name.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
    };
    private static final List<String> CPU_TEMP_FILE_PATHS = Arrays.asList(new String[]{"/sys/devices/system/cpu/cpu0/cpufreq/cpu_temp", "/sys/devices/system/cpu/cpu0/cpufreq/FakeShmoo_cpu_temp", "/sys/class/thermal/thermal_zone0/temp", "/sys/class/i2c-adapter/i2c-4/4-004c/temperature", "/sys/devices/platform/tegra-i2c.3/i2c-4/4-004c/temperature", "/sys/devices/platform/omap/omap_temp_sensor.0/temperature", "/sys/devices/platform/tegra_tmon/temp1_input", "/sys/kernel/debug/tegra_thermal/temp_tj", "/sys/devices/platform/s5p-tmu/temperature", "/sys/class/thermal/thermal_zone1/temp", "/sys/class/hwmon/hwmon0/device/temp1_input", "/sys/devices/virtual/thermal/thermal_zone1/temp", "/sys/devices/virtual/thermal/thermal_zone0/temp", "/sys/class/thermal/thermal_zone3/temp", "/sys/class/thermal/thermal_zone4/temp", "/sys/class/hwmon/hwmonX/temp1_input", "/sys/devices/platform/s5p-tmu/curr_temp"});
    private static final int DEVICEINFO_UNKNOWN = -1;
    private static String TAG = "GDPAndroid";
    private Context mAppContext = null;
    private String mGpuRenderer = "unkown";
    private String mGpuVendor = "unkown";

    private boolean isTemperatureValid(double d) {
        return d >= -30.0d && d <= 250.0d;
    }

    public boolean initGDP(Context context) {
        this.mAppContext = context;
        if (!isEGL14SupportedHere()) {
            return true;
        }
        gatherGlInfo();
        return true;
    }

    public int getCpuCores() {
        return getNumberOfCPUCores();
    }

    public int getCpuClock() {
        return getCPUMaxFreqKHz();
    }

    public String getCpuVendor() {
        return Build.HARDWARE;
    }

    public int getRam() {
        return (int) (getTotalMemory(this.mAppContext) / ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS);
    }

    public String getGpuVendor() {
        return this.mGpuVendor;
    }

    public String getGpuRenderer() {
        return this.mGpuRenderer;
    }

    public int getOsVersion() {
        return Build.VERSION.SDK_INT;
    }

    public String getDeviceName() {
        return Build.MODEL;
    }

    public int getBattery() {
        return getBatteryLevel();
    }

    private boolean isEGL14SupportedHere() {
        return Build.VERSION.SDK_INT >= 21;
    }

    private void gatherGlInfo() {
        EglCore eglCore = new EglCore((EGLContext) null, 2);
        OffscreenSurface offscreenSurface = new OffscreenSurface(eglCore, 1, 1);
        offscreenSurface.makeCurrent();
        this.mGpuVendor = GLES20.glGetString(7936);
        this.mGpuRenderer = GLES20.glGetString(7937);
        offscreenSurface.release();
        eglCore.release();
    }

    private int getBatteryLevel() {
        if (Build.VERSION.SDK_INT >= 21) {
            return ((BatteryManager) this.mAppContext.getSystemService("batterymanager")).getIntProperty(4);
        }
        Intent registerReceiver = new ContextWrapper(this.mAppContext).registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        return (registerReceiver.getIntExtra("level", -1) * 100) / registerReceiver.getIntExtra("scale", -1);
    }

    private static int getNumberOfCPUCores() {
        if (Build.VERSION.SDK_INT <= 10) {
            return 1;
        }
        int i = -1;
        try {
            int coresFromFileInfo = getCoresFromFileInfo("/sys/devices/system/cpu/possible");
            if (coresFromFileInfo == -1) {
                coresFromFileInfo = getCoresFromFileInfo("/sys/devices/system/cpu/present");
            }
            i = coresFromFileInfo == -1 ? getCoresFromCPUFileList() : coresFromFileInfo;
        } catch (NullPointerException | SecurityException unused) {
        }
        String str = TAG;
        Log.i(str, "cores:" + i);
        return i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0027 A[SYNTHETIC, Splitter:B:15:0x0027] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x002e A[SYNTHETIC, Splitter:B:22:0x002e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int getCoresFromFileInfo(java.lang.String r2) {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ IOException -> 0x002b, all -> 0x0024 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x002b, all -> 0x0024 }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0022, all -> 0x001f }
            java.io.InputStreamReader r0 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0022, all -> 0x001f }
            r0.<init>(r1)     // Catch:{ IOException -> 0x0022, all -> 0x001f }
            r2.<init>(r0)     // Catch:{ IOException -> 0x0022, all -> 0x001f }
            java.lang.String r0 = r2.readLine()     // Catch:{ IOException -> 0x0022, all -> 0x001f }
            r2.close()     // Catch:{ IOException -> 0x0022, all -> 0x001f }
            int r2 = getCoresFromFileString(r0)     // Catch:{ IOException -> 0x0022, all -> 0x001f }
            r1.close()     // Catch:{ IOException -> 0x001e }
        L_0x001e:
            return r2
        L_0x001f:
            r2 = move-exception
            r0 = r1
            goto L_0x0025
        L_0x0022:
            r0 = r1
            goto L_0x002b
        L_0x0024:
            r2 = move-exception
        L_0x0025:
            if (r0 == 0) goto L_0x002a
            r0.close()     // Catch:{ IOException -> 0x002a }
        L_0x002a:
            throw r2
        L_0x002b:
            r2 = -1
            if (r0 == 0) goto L_0x0031
            r0.close()     // Catch:{ IOException -> 0x0031 }
        L_0x0031:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.agora.rtc.gdp.GDPAndroid.getCoresFromFileInfo(java.lang.String):int");
    }

    private static int getCoresFromFileString(String str) {
        if (str == null || !str.matches("0-[\\d]+$")) {
            return -1;
        }
        return Integer.valueOf(str.substring(2)).intValue() + 1;
    }

    private static int getCoresFromCPUFileList() {
        return new File("/sys/devices/system/cpu/").listFiles(CPU_FILTER).length;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0062 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int getCPUMaxFreqKHz() {
        /*
            r0 = 0
            r1 = -1
            r2 = r0
            r3 = r1
        L_0x0004:
            int r4 = getNumberOfCPUCores()     // Catch:{ IOException -> 0x008c }
            if (r2 >= r4) goto L_0x006e
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x008c }
            r4.<init>()     // Catch:{ IOException -> 0x008c }
            java.lang.String r5 = "/sys/devices/system/cpu/cpu"
            r4.append(r5)     // Catch:{ IOException -> 0x008c }
            r4.append(r2)     // Catch:{ IOException -> 0x008c }
            java.lang.String r5 = "/cpufreq/cpuinfo_max_freq"
            r4.append(r5)     // Catch:{ IOException -> 0x008c }
            java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x008c }
            java.io.File r5 = new java.io.File     // Catch:{ IOException -> 0x008c }
            r5.<init>(r4)     // Catch:{ IOException -> 0x008c }
            boolean r4 = r5.exists()     // Catch:{ IOException -> 0x008c }
            if (r4 == 0) goto L_0x006b
            boolean r4 = r5.canRead()     // Catch:{ IOException -> 0x008c }
            if (r4 == 0) goto L_0x006b
            r4 = 128(0x80, float:1.794E-43)
            byte[] r6 = new byte[r4]     // Catch:{ IOException -> 0x008c }
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ IOException -> 0x008c }
            r7.<init>(r5)     // Catch:{ IOException -> 0x008c }
            r7.read(r6)     // Catch:{ NumberFormatException -> 0x0062, all -> 0x0066 }
            r5 = r0
        L_0x003e:
            byte r8 = r6[r5]     // Catch:{ NumberFormatException -> 0x0062, all -> 0x0066 }
            boolean r8 = java.lang.Character.isDigit(r8)     // Catch:{ NumberFormatException -> 0x0062, all -> 0x0066 }
            if (r8 == 0) goto L_0x004b
            if (r5 >= r4) goto L_0x004b
            int r5 = r5 + 1
            goto L_0x003e
        L_0x004b:
            java.lang.String r4 = new java.lang.String     // Catch:{ NumberFormatException -> 0x0062, all -> 0x0066 }
            r4.<init>(r6, r0, r5)     // Catch:{ NumberFormatException -> 0x0062, all -> 0x0066 }
            int r4 = java.lang.Integer.parseInt(r4)     // Catch:{ NumberFormatException -> 0x0062, all -> 0x0066 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ NumberFormatException -> 0x0062, all -> 0x0066 }
            int r5 = r4.intValue()     // Catch:{ NumberFormatException -> 0x0062, all -> 0x0066 }
            if (r5 <= r3) goto L_0x0062
            int r3 = r4.intValue()     // Catch:{ NumberFormatException -> 0x0062, all -> 0x0066 }
        L_0x0062:
            r7.close()     // Catch:{ IOException -> 0x008c }
            goto L_0x006b
        L_0x0066:
            r0 = move-exception
            r7.close()     // Catch:{ IOException -> 0x008c }
            throw r0     // Catch:{ IOException -> 0x008c }
        L_0x006b:
            int r2 = r2 + 1
            goto L_0x0004
        L_0x006e:
            if (r3 != r1) goto L_0x008b
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ IOException -> 0x008c }
            java.lang.String r2 = "/proc/cpuinfo"
            r0.<init>(r2)     // Catch:{ IOException -> 0x008c }
            java.lang.String r2 = "cpu MHz"
            int r2 = parseFileForValue(r2, r0)     // Catch:{ all -> 0x0086 }
            int r2 = r2 * 1000
            if (r2 <= r3) goto L_0x0082
            r3 = r2
        L_0x0082:
            r0.close()     // Catch:{ IOException -> 0x008c }
            goto L_0x008b
        L_0x0086:
            r2 = move-exception
            r0.close()     // Catch:{ IOException -> 0x008c }
            throw r2     // Catch:{ IOException -> 0x008c }
        L_0x008b:
            r1 = r3
        L_0x008c:
            java.lang.String r0 = TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "max freq:"
            r2.append(r3)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            android.util.Log.i(r0, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.agora.rtc.gdp.GDPAndroid.getCPUMaxFreqKHz():int");
    }

    private static long getTotalMemory(Context context) {
        FileInputStream fileInputStream;
        if (Build.VERSION.SDK_INT >= 16) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
            String str = TAG;
            Log.i(str, "total mem:" + memoryInfo.totalMem);
            return memoryInfo.totalMem;
        }
        long j = -1;
        try {
            fileInputStream = new FileInputStream("/proc/meminfo");
            j = ((long) parseFileForValue("MemTotal", fileInputStream)) * ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS;
            fileInputStream.close();
        } catch (IOException unused) {
        } catch (Throwable th) {
            fileInputStream.close();
            throw th;
        }
        String str2 = TAG;
        Log.i(str2, "total mem:" + j);
        return j;
    }

    private static int parseFileForValue(String str, FileInputStream fileInputStream) {
        byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
        try {
            int read = fileInputStream.read(bArr);
            int i = 0;
            while (i < read) {
                if (bArr[i] == 10 || i == 0) {
                    if (bArr[i] == 10) {
                        i++;
                    }
                    int i2 = i;
                    while (true) {
                        if (i2 >= read) {
                            continue;
                            break;
                        }
                        int i3 = i2 - i;
                        if (bArr[i2] != str.charAt(i3)) {
                            break;
                        } else if (i3 == str.length() - 1) {
                            return extractValue(bArr, i2);
                        } else {
                            i2++;
                        }
                    }
                }
                i++;
            }
            return -1;
        } catch (IOException | NumberFormatException unused) {
            return -1;
        }
    }

    private static int extractValue(byte[] bArr, int i) {
        while (i < bArr.length && bArr[i] != 10) {
            if (Character.isDigit(bArr[i])) {
                int i2 = i + 1;
                while (i2 < bArr.length && Character.isDigit(bArr[i2])) {
                    i2++;
                }
                return Integer.parseInt(new String(bArr, 0, i, i2 - i));
            }
            i++;
        }
        return -1;
    }

    public boolean checkBackground() {
        ComponentName componentName;
        ActivityManager activityManager = (ActivityManager) this.mAppContext.getSystemService("activity");
        if (Build.VERSION.SDK_INT > 21) {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (!runningAppProcesses.isEmpty()) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.importance == 100) {
                        return false;
                    }
                }
            }
        } else {
            String packageName = this.mAppContext.getPackageName();
            List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(1);
            if (!runningTasks.isEmpty() && (componentName = runningTasks.get(0).topActivity) != null) {
                return !packageName.equals(componentName.getPackageName());
            }
        }
        return true;
    }

    public int getCpuTemperature() {
        double d;
        int i = 0;
        while (true) {
            List<String> list = CPU_TEMP_FILE_PATHS;
            if (i >= list.size()) {
                d = 0.0d;
                break;
            }
            String str = list.get(i);
            Double valueOf = Double.valueOf(readOneLine(new File(str)));
            if (isTemperatureValid(valueOf.doubleValue())) {
                d = valueOf.doubleValue();
                String str2 = TAG;
                Log.i(str2, "getCpuTemperature valid path:" + str);
                break;
            } else if (isTemperatureValid(valueOf.doubleValue() / 1000.0d)) {
                d = valueOf.doubleValue() / 1000.0d;
                String str3 = TAG;
                Log.i(str3, "getCpuTemperature valid path:" + str);
                break;
            } else {
                i++;
            }
        }
        return (int) (d * 1000.0d);
    }

    private double readOneLine(File file) {
        String str = "";
        if (!file.exists()) {
            return -100000.0d;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            str = bufferedReader.readLine();
            fileInputStream.close();
            inputStreamReader.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException unused) {
            return -100000.0d;
        }
    }
}
