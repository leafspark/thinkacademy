package io.agora.rtc.internal;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import io.agora.rtc.video.VideoCaptureCamera;
import io.agora.rtc.video.VideoCaptureCamera2;
import io.agora.rtc.video.VideoCaptureFactory;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeviceUtils {
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
    public static final int DEVICE_INFO_UNKNOWN = -1;
    private static final String[] H264_HW_BLACKLIST = {"SAMSUNG-SGH-I337", "Nexus 7", "Nexus 4", "P6-C00", "HM 2A", "XT105", "XT109", "XT1060"};
    private static final String TAG = "DeviceUtils";

    public static String buildDeviceId() {
        String str = Build.MANUFACTURER + "/" + Build.MODEL + "/" + Build.PRODUCT + "/" + Build.DEVICE + "/" + Build.VERSION.SDK_INT + "/" + System.getProperty("os.version");
        if (str != null) {
            str = str.toLowerCase();
        }
        Matcher matcher = Pattern.compile(".*[A-Z][A-M][0-9]$").matcher(Build.ID);
        if (!Build.BRAND.toLowerCase().equals("samsung") || !Build.DEVICE.toLowerCase().startsWith("cs02") || matcher.find() || Build.VERSION.SDK_INT != 19) {
            return str;
        }
        return "yeshen/simulator/" + Build.MODEL + "/" + Build.PRODUCT + "/" + Build.DEVICE + "/" + Build.VERSION.SDK_INT + "/" + System.getProperty("os.version");
    }

    public static String getDeviceInfo() {
        String str = Build.MANUFACTURER + "/" + Build.MODEL + "/" + Build.HARDWARE;
        return str != null ? str.toLowerCase() : str;
    }

    public static String getSystemInfo() {
        return "Android/" + Build.VERSION.RELEASE;
    }

    public static int selectFrontCamera(Context context) {
        if (VideoCaptureFactory.isLReleaseOrLater()) {
            return VideoCaptureCamera2.getFrontCameraIndex(context);
        }
        return VideoCaptureCamera.getFrontCameraIndex();
    }

    public static int getNumberOfCameras(Context context) {
        try {
            return VideoCaptureFactory.getNumberOfCameras(context);
        } catch (Exception e) {
            Log.e(TAG, e.toString());
            return 0;
        }
    }

    public static int getRecommendedEncoderType() {
        if (Arrays.asList(H264_HW_BLACKLIST).contains(Build.MODEL)) {
            Logging.w(TAG, "Model: " + Build.MODEL + " has black listed H.264 encoder.");
            return 1;
        } else if (Build.VERSION.SDK_INT <= 18) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int getNumberOfCPUCores() {
        if (Build.VERSION.SDK_INT <= 10) {
            return 1;
        }
        try {
            int coresFromFileInfo = getCoresFromFileInfo("/sys/devices/system/cpu/possible");
            if (coresFromFileInfo == -1) {
                coresFromFileInfo = getCoresFromFileInfo("/sys/devices/system/cpu/present");
            }
            return coresFromFileInfo == -1 ? getCoresFromCPUFileList() : coresFromFileInfo;
        } catch (NullPointerException | SecurityException unused) {
            return -1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0044 A[SYNTHETIC, Splitter:B:24:0x0044] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0051 A[SYNTHETIC, Splitter:B:32:0x0051] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x005d A[SYNTHETIC, Splitter:B:39:0x005d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getCpuName() {
        /*
            java.lang.String r0 = "failed to close proc file"
            java.lang.String r1 = "DeviceUtils"
            r2 = 0
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ FileNotFoundException -> 0x0048, IOException -> 0x003b, all -> 0x0036 }
            java.lang.String r4 = "/proc/cpuinfo"
            r3.<init>(r4)     // Catch:{ FileNotFoundException -> 0x0048, IOException -> 0x003b, all -> 0x0036 }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ FileNotFoundException -> 0x0034, IOException -> 0x0032 }
            r4.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0034, IOException -> 0x0032 }
            java.lang.String r4 = r4.readLine()     // Catch:{ FileNotFoundException -> 0x0034, IOException -> 0x0032 }
            java.lang.String r5 = ":\\s+"
            r6 = 2
            java.lang.String[] r4 = r4.split(r5, r6)     // Catch:{ FileNotFoundException -> 0x0034, IOException -> 0x0032 }
            r5 = 0
        L_0x001d:
            int r6 = r4.length     // Catch:{ FileNotFoundException -> 0x0034, IOException -> 0x0032 }
            if (r5 >= r6) goto L_0x0023
            int r5 = r5 + 1
            goto L_0x001d
        L_0x0023:
            r3.close()     // Catch:{ FileNotFoundException -> 0x0034, IOException -> 0x0032 }
            r5 = 1
            r2 = r4[r5]     // Catch:{ FileNotFoundException -> 0x0034, IOException -> 0x0032 }
            r3.close()     // Catch:{ IOException -> 0x002d }
            goto L_0x0031
        L_0x002d:
            r3 = move-exception
            io.agora.rtc.internal.Logging.e(r1, r0, r3)
        L_0x0031:
            return r2
        L_0x0032:
            r4 = move-exception
            goto L_0x003d
        L_0x0034:
            r4 = move-exception
            goto L_0x004a
        L_0x0036:
            r3 = move-exception
            r7 = r3
            r3 = r2
            r2 = r7
            goto L_0x005b
        L_0x003b:
            r4 = move-exception
            r3 = r2
        L_0x003d:
            java.lang.String r5 = "getCpuName failed,"
            io.agora.rtc.internal.Logging.e(r1, r5, r4)     // Catch:{ all -> 0x005a }
            if (r3 == 0) goto L_0x0059
            r3.close()     // Catch:{ IOException -> 0x0055 }
            goto L_0x0059
        L_0x0048:
            r4 = move-exception
            r3 = r2
        L_0x004a:
            java.lang.String r5 = "getCpuName failed, no /proc/cpuinfo found in system"
            io.agora.rtc.internal.Logging.e(r1, r5, r4)     // Catch:{ all -> 0x005a }
            if (r3 == 0) goto L_0x0059
            r3.close()     // Catch:{ IOException -> 0x0055 }
            goto L_0x0059
        L_0x0055:
            r3 = move-exception
            io.agora.rtc.internal.Logging.e(r1, r0, r3)
        L_0x0059:
            return r2
        L_0x005a:
            r2 = move-exception
        L_0x005b:
            if (r3 == 0) goto L_0x0065
            r3.close()     // Catch:{ IOException -> 0x0061 }
            goto L_0x0065
        L_0x0061:
            r3 = move-exception
            io.agora.rtc.internal.Logging.e(r1, r0, r3)
        L_0x0065:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.agora.rtc.internal.DeviceUtils.getCpuName():java.lang.String");
    }

    public static String getCpuABI() {
        return Build.CPU_ABI;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0030 A[SYNTHETIC, Splitter:B:16:0x0030] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003c A[SYNTHETIC, Splitter:B:24:0x003c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int getCoresFromFileInfo(java.lang.String r4) {
        /*
            java.lang.String r0 = "close file stream"
            java.lang.String r1 = "DeviceUtils"
            r2 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0039, all -> 0x002d }
            r3.<init>(r4)     // Catch:{ IOException -> 0x0039, all -> 0x002d }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ IOException -> 0x002b, all -> 0x0028 }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x002b, all -> 0x0028 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x002b, all -> 0x0028 }
            r4.<init>(r2)     // Catch:{ IOException -> 0x002b, all -> 0x0028 }
            java.lang.String r4 = r4.readLine()     // Catch:{ IOException -> 0x002b, all -> 0x0028 }
            r3.close()     // Catch:{ IOException -> 0x002b, all -> 0x0028 }
            int r4 = getCoresFromFileString(r4)     // Catch:{ IOException -> 0x002b, all -> 0x0028 }
            r3.close()     // Catch:{ IOException -> 0x0023 }
            goto L_0x0027
        L_0x0023:
            r2 = move-exception
            io.agora.rtc.internal.Logging.e(r1, r0, r2)
        L_0x0027:
            return r4
        L_0x0028:
            r4 = move-exception
            r2 = r3
            goto L_0x002e
        L_0x002b:
            r2 = r3
            goto L_0x0039
        L_0x002d:
            r4 = move-exception
        L_0x002e:
            if (r2 == 0) goto L_0x0038
            r2.close()     // Catch:{ IOException -> 0x0034 }
            goto L_0x0038
        L_0x0034:
            r2 = move-exception
            io.agora.rtc.internal.Logging.e(r1, r0, r2)
        L_0x0038:
            throw r4
        L_0x0039:
            r4 = -1
            if (r2 == 0) goto L_0x0044
            r2.close()     // Catch:{ IOException -> 0x0040 }
            goto L_0x0044
        L_0x0040:
            r2 = move-exception
            io.agora.rtc.internal.Logging.e(r1, r0, r2)
        L_0x0044:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.agora.rtc.internal.DeviceUtils.getCoresFromFileInfo(java.lang.String):int");
    }

    private static int getCoresFromFileString(String str) {
        if (str == null || !str.matches("0-[\\d]+$")) {
            return -1;
        }
        return Integer.valueOf(str.substring(2)).intValue() + 1;
    }

    private static int getCoresFromCPUFileList() {
        return new File("/sys/devices/system/cpu").listFiles(CPU_FILTER).length;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x005c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getCPUMaxFreqKHz() {
        /*
            r0 = 0
            r1 = -1
            r2 = r0
            r3 = r1
        L_0x0004:
            int r4 = getNumberOfCPUCores()     // Catch:{ IOException -> 0x0086 }
            if (r2 >= r4) goto L_0x0068
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0086 }
            r4.<init>()     // Catch:{ IOException -> 0x0086 }
            java.lang.String r5 = "/sys/devices/system/cpu/cpu"
            r4.append(r5)     // Catch:{ IOException -> 0x0086 }
            r4.append(r2)     // Catch:{ IOException -> 0x0086 }
            java.lang.String r5 = "/cpufreq/cpuinfo_max_freq"
            r4.append(r5)     // Catch:{ IOException -> 0x0086 }
            java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x0086 }
            java.io.File r5 = new java.io.File     // Catch:{ IOException -> 0x0086 }
            r5.<init>(r4)     // Catch:{ IOException -> 0x0086 }
            boolean r4 = r5.exists()     // Catch:{ IOException -> 0x0086 }
            if (r4 == 0) goto L_0x0065
            r4 = 128(0x80, float:1.794E-43)
            byte[] r6 = new byte[r4]     // Catch:{ IOException -> 0x0086 }
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0086 }
            r7.<init>(r5)     // Catch:{ IOException -> 0x0086 }
            r7.read(r6)     // Catch:{ NumberFormatException -> 0x005c, all -> 0x0060 }
            r5 = r0
        L_0x0038:
            byte r8 = r6[r5]     // Catch:{ NumberFormatException -> 0x005c, all -> 0x0060 }
            boolean r8 = java.lang.Character.isDigit(r8)     // Catch:{ NumberFormatException -> 0x005c, all -> 0x0060 }
            if (r8 == 0) goto L_0x0045
            if (r5 >= r4) goto L_0x0045
            int r5 = r5 + 1
            goto L_0x0038
        L_0x0045:
            java.lang.String r4 = new java.lang.String     // Catch:{ NumberFormatException -> 0x005c, all -> 0x0060 }
            r4.<init>(r6, r0, r5)     // Catch:{ NumberFormatException -> 0x005c, all -> 0x0060 }
            int r4 = java.lang.Integer.parseInt(r4)     // Catch:{ NumberFormatException -> 0x005c, all -> 0x0060 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ NumberFormatException -> 0x005c, all -> 0x0060 }
            int r5 = r4.intValue()     // Catch:{ NumberFormatException -> 0x005c, all -> 0x0060 }
            if (r5 <= r3) goto L_0x005c
            int r3 = r4.intValue()     // Catch:{ NumberFormatException -> 0x005c, all -> 0x0060 }
        L_0x005c:
            r7.close()     // Catch:{ IOException -> 0x0086 }
            goto L_0x0065
        L_0x0060:
            r0 = move-exception
            r7.close()     // Catch:{ IOException -> 0x0086 }
            throw r0     // Catch:{ IOException -> 0x0086 }
        L_0x0065:
            int r2 = r2 + 1
            goto L_0x0004
        L_0x0068:
            if (r3 != r1) goto L_0x0085
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0086 }
            java.lang.String r2 = "/proc/cpuinfo"
            r0.<init>(r2)     // Catch:{ IOException -> 0x0086 }
            java.lang.String r2 = "cpu MHz"
            int r2 = parseFileForValue(r2, r0)     // Catch:{ all -> 0x0080 }
            int r2 = r2 * 1000
            if (r2 <= r3) goto L_0x007c
            r3 = r2
        L_0x007c:
            r0.close()     // Catch:{ IOException -> 0x0086 }
            goto L_0x0085
        L_0x0080:
            r2 = move-exception
            r0.close()     // Catch:{ IOException -> 0x0086 }
            throw r2     // Catch:{ IOException -> 0x0086 }
        L_0x0085:
            r1 = r3
        L_0x0086:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.agora.rtc.internal.DeviceUtils.getCPUMaxFreqKHz():int");
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
}
