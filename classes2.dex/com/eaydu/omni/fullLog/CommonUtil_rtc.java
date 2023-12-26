package com.eaydu.omni.fullLog;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Process;
import com.eaydu.omni.fullLog.UmsAgent_rtc;
import com.igexin.assist.sdk.AssistPushConsts;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.util.UUID;

public class CommonUtil_rtc {
    static String getSALTStr;

    public static boolean checkPermissions(Context context, String str) {
        try {
            if (context.getPackageManager().checkPermission(str, context.getPackageName()) == 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String getUmsClientPosUrl() {
        return UmsConstants_rtc.UMSAGENT_CLIENT_LOG_POST_URL;
    }

    public static void saveUmsClientPosUrl(String str) {
        UmsConstants_rtc.UMSAGENT_CLIENT_LOG_POST_URL = str;
    }

    public static UmsAgent_rtc.SendPolicy getReportPolicyMode(Context context) {
        return UmsConstants_rtc.mReportPolicy;
    }

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (!checkPermissions(context, "android.permission.INTERNET") || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) {
            return false;
        }
        return true;
    }

    public static String md5Appkey(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                byte b2 = b & 255;
                if (b2 < 16) {
                    stringBuffer.append(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_NONE);
                }
                stringBuffer.append(Integer.toHexString(b2));
            }
            return stringBuffer.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:15|16|17|18|19|20|21) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x007e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.lang.String getSALT(android.content.Context r7) {
        /*
            java.lang.Class<com.eaydu.omni.fullLog.CommonUtil_rtc> r0 = com.eaydu.omni.fullLog.CommonUtil_rtc.class
            monitor-enter(r0)
            java.lang.String r1 = getSALTStr     // Catch:{ all -> 0x009a }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)
            return r1
        L_0x0009:
            java.lang.String r1 = r7.getPackageName()     // Catch:{ all -> 0x009a }
            java.lang.String r2 = "."
            java.lang.String r3 = ""
            java.lang.String r1 = r1.replace(r2, r3)     // Catch:{ all -> 0x009a }
            java.io.File r2 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ all -> 0x009a }
            java.lang.String r2 = r2.getAbsolutePath()     // Catch:{ all -> 0x009a }
            java.lang.String r3 = android.os.Build.VERSION.SDK     // Catch:{ all -> 0x009a }
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ all -> 0x009a }
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x009a }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x009a }
            r5.<init>()     // Catch:{ all -> 0x009a }
            r5.append(r2)     // Catch:{ all -> 0x009a }
            java.lang.String r2 = java.io.File.separator     // Catch:{ all -> 0x009a }
            r5.append(r2)     // Catch:{ all -> 0x009a }
            java.lang.String r2 = r5.toString()     // Catch:{ all -> 0x009a }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x009a }
            r5.<init>()     // Catch:{ all -> 0x009a }
            java.lang.String r6 = "."
            r5.append(r6)     // Catch:{ all -> 0x009a }
            r5.append(r1)     // Catch:{ all -> 0x009a }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x009a }
            r4.<init>(r2, r5)     // Catch:{ all -> 0x009a }
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x009a }
            java.io.File r5 = r7.getFilesDir()     // Catch:{ all -> 0x009a }
            r2.<init>(r5, r1)     // Catch:{ all -> 0x009a }
            r5 = 19
            if (r3 < r5) goto L_0x0065
            r3 = 0
            java.io.File r7 = r7.getExternalFilesDir(r3)     // Catch:{ all -> 0x009a }
            java.lang.String r7 = r7.getAbsolutePath()     // Catch:{ all -> 0x009a }
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x009a }
            r4.<init>(r7, r1)     // Catch:{ all -> 0x009a }
        L_0x0065:
            java.lang.String r7 = android.os.Environment.getExternalStorageState()     // Catch:{ all -> 0x009a }
            java.lang.String r3 = "mounted"
            boolean r7 = r7.equals(r3)     // Catch:{ all -> 0x009a }
            if (r7 == 0) goto L_0x0092
            boolean r7 = r4.exists()     // Catch:{ all -> 0x009a }
            if (r7 != 0) goto L_0x0082
            java.lang.String r7 = getSaltOnDataData(r2, r1)     // Catch:{ all -> 0x009a }
            writeToFile(r4, r7)     // Catch:{ Exception -> 0x007e }
        L_0x007e:
            getSALTStr = r7     // Catch:{ all -> 0x009a }
            monitor-exit(r0)
            return r7
        L_0x0082:
            java.lang.String r7 = getSaltOnSDCard(r4)     // Catch:{ all -> 0x009a }
            writeToFile(r2, r7)     // Catch:{ IOException -> 0x008a }
            goto L_0x008e
        L_0x008a:
            r1 = move-exception
            r1.printStackTrace()     // Catch:{ all -> 0x009a }
        L_0x008e:
            getSALTStr = r7     // Catch:{ all -> 0x009a }
            monitor-exit(r0)
            return r7
        L_0x0092:
            java.lang.String r7 = getSaltOnDataData(r2, r1)     // Catch:{ all -> 0x009a }
            getSALTStr = r7     // Catch:{ all -> 0x009a }
            monitor-exit(r0)
            return r7
        L_0x009a:
            r7 = move-exception
            monitor-exit(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.eaydu.omni.fullLog.CommonUtil_rtc.getSALT(android.content.Context):java.lang.String");
    }

    private static String getSaltOnSDCard(File file) {
        try {
            return readSaltFromFile(file);
        } catch (IOException unused) {
            return null;
        }
    }

    private static String getSaltOnDataData(File file, String str) {
        try {
            if (file.exists()) {
                return readSaltFromFile(file);
            }
            String uuid = getUUID();
            writeToFile(file, uuid);
            return uuid;
        } catch (IOException unused) {
            return "";
        }
    }

    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    private static String readSaltFromFile(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        byte[] bArr = new byte[((int) randomAccessFile.length())];
        randomAccessFile.readFully(bArr);
        randomAccessFile.close();
        return new String(bArr);
    }

    private static void writeToFile(File file, String str) throws IOException {
        file.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(str.getBytes());
        fileOutputStream.close();
    }

    public static String getCurProcessName(Context context) {
        int myPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null || activityManager.getRunningAppProcesses() == null) {
            return "main";
        }
        for (ActivityManager.RunningAppProcessInfo next : activityManager.getRunningAppProcesses()) {
            if (next.pid == myPid) {
                return next.processName;
            }
        }
        return "main";
    }
}
