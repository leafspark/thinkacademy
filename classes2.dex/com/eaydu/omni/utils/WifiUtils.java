package com.eaydu.omni.utils;

import android.content.Context;
import android.net.wifi.WifiManager;
import com.igexin.assist.sdk.AssistPushConsts;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.Security;
import java.util.regex.Pattern;

public class WifiUtils {
    private static String pingCmd = "ping -c 1 -w 5 ";

    public static float getWifiRTT(Context context) {
        try {
            String wifiIP = getWifiIP(context);
            String pingResult = getPingResult(pingCmd + wifiIP);
            if (isDoubleOrFloat(pingResult)) {
                return Float.parseFloat(pingResult);
            }
            return 0.0f;
        } catch (Exception unused) {
            return 0.0f;
        }
    }

    public boolean isIP(String str) {
        String str2;
        if (str.toLowerCase().contains("http://") || str.toLowerCase().contains("https://")) {
            str2 = str.split("/")[2];
        } else if (str.startsWith("/")) {
            str2 = str.split("/")[1];
        } else {
            str2 = str.split("/")[0];
        }
        if (str2.contains(":")) {
            str2 = str2.split(":")[0];
        }
        if (str2.length() < 7 || str2.length() > 15 || "".equals(str2)) {
            return false;
        }
        return Pattern.compile("([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}").matcher(str2).find();
    }

    public String obtainDomain(String str) {
        String str2;
        if (str.toLowerCase().contains("http://") || str.toLowerCase().contains("https://")) {
            str2 = str.split("/")[2];
        } else if (str.startsWith("/")) {
            str2 = str.split("/")[1];
        } else {
            str2 = str.split("/")[0];
        }
        return str2.contains(":") ? str2.split(":")[0] : str2;
    }

    private String obtainIP(String str) {
        Security.setProperty("networkaddress.cache.ttl", AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_NONE);
        try {
            return InetAddress.getByName(str).getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String getWifiIP(Context context) {
        return intToIp(((WifiManager) context.getSystemService("wifi")).getDhcpInfo().gateway);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x011c, code lost:
        if (r6 != null) goto L_0x012e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x012c, code lost:
        if (r6 == null) goto L_0x0131;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x002b */
    /* JADX WARNING: Removed duplicated region for block: B:4:0x002b A[LOOP:0: B:4:0x002b->B:67:0x002b, LOOP_START, PHI: r8 r9 
      PHI: (r8v3 java.lang.String) = (r8v2 java.lang.String), (r8v4 java.lang.String) binds: [B:3:0x0028, B:67:0x002b] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r9v2 java.lang.String) = (r9v1 java.lang.String), (r9v3 java.lang.String) binds: [B:3:0x0028, B:67:0x002b] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String getPingResult(java.lang.String r17) {
        /*
            java.lang.String r0 = "time"
            java.lang.String r1 = "packet loss"
            java.lang.String r2 = "time="
            java.lang.String r3 = "received"
            java.lang.String r4 = "packets transmitted"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r6 = 0
            java.lang.Runtime r7 = java.lang.Runtime.getRuntime()     // Catch:{ IOException -> 0x0128, InterruptedException -> 0x0121 }
            r8 = r17
            java.lang.Process r6 = r7.exec(r8)     // Catch:{ IOException -> 0x0128, InterruptedException -> 0x0121 }
            java.io.BufferedReader r7 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0128, InterruptedException -> 0x0121 }
            java.io.InputStreamReader r8 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0128, InterruptedException -> 0x0121 }
            java.io.InputStream r9 = r6.getInputStream()     // Catch:{ IOException -> 0x0128, InterruptedException -> 0x0121 }
            r8.<init>(r9)     // Catch:{ IOException -> 0x0128, InterruptedException -> 0x0121 }
            r7.<init>(r8)     // Catch:{ IOException -> 0x0128, InterruptedException -> 0x0121 }
            java.lang.String r8 = ""
            r9 = r8
        L_0x002b:
            java.lang.String r10 = r7.readLine()     // Catch:{ IOException -> 0x0128, InterruptedException -> 0x0121 }
            if (r10 == 0) goto L_0x0119
            java.lang.String r11 = "bytes from"
            boolean r11 = r10.contains(r11)     // Catch:{ IOException -> 0x0128, InterruptedException -> 0x0121 }
            r12 = 0
            r13 = 1
            if (r11 == 0) goto L_0x0065
            java.lang.String r11 = "ttl="
            boolean r11 = r10.contains(r11)     // Catch:{ IOException -> 0x0128, InterruptedException -> 0x0121 }
            if (r11 == 0) goto L_0x0065
            boolean r11 = r10.contains(r2)     // Catch:{ IOException -> 0x0128, InterruptedException -> 0x0121 }
            if (r11 == 0) goto L_0x0065
            java.lang.String[] r10 = r10.split(r2)     // Catch:{ NumberFormatException -> 0x002b }
            r10 = r10[r13]     // Catch:{ NumberFormatException -> 0x002b }
            java.lang.String r10 = r10.trim()     // Catch:{ NumberFormatException -> 0x002b }
            java.lang.String r11 = " ms"
            java.lang.String[] r10 = r10.split(r11)     // Catch:{ NumberFormatException -> 0x002b }
            r10 = r10[r12]     // Catch:{ NumberFormatException -> 0x002b }
            java.lang.String r0 = r10.trim()     // Catch:{ NumberFormatException -> 0x002b }
            if (r6 == 0) goto L_0x0064
            r6.destroy()
        L_0x0064:
            return r0
        L_0x0065:
            boolean r11 = r10.contains(r4)     // Catch:{ IOException -> 0x0128, InterruptedException -> 0x0121 }
            if (r11 == 0) goto L_0x00f5
            boolean r11 = r10.contains(r3)     // Catch:{ IOException -> 0x0128, InterruptedException -> 0x0121 }
            if (r11 == 0) goto L_0x00f5
            java.lang.String r11 = ":"
            java.lang.String[] r10 = r10.split(r11)     // Catch:{ IOException -> 0x0128, InterruptedException -> 0x0121 }
            int r11 = r10.length     // Catch:{ IOException -> 0x0128, InterruptedException -> 0x0121 }
            int r11 = r11 - r13
            r10 = r10[r11]     // Catch:{ IOException -> 0x0128, InterruptedException -> 0x0121 }
            java.lang.String r11 = ","
            java.lang.String[] r10 = r10.split(r11)     // Catch:{ IOException -> 0x0128, InterruptedException -> 0x0121 }
            int r11 = r10.length     // Catch:{ IOException -> 0x0128, InterruptedException -> 0x0121 }
            r14 = r12
        L_0x0083:
            if (r14 >= r11) goto L_0x00d2
            r15 = r10[r14]     // Catch:{ IOException -> 0x0128, InterruptedException -> 0x0121 }
            boolean r16 = r15.contains(r4)     // Catch:{ IOException -> 0x0128, InterruptedException -> 0x0121 }
            if (r16 == 0) goto L_0x0098
            java.lang.String[] r8 = r15.split(r4)     // Catch:{ IOException -> 0x0128, InterruptedException -> 0x0121 }
            r8 = r8[r12]     // Catch:{ IOException -> 0x0128, InterruptedException -> 0x0121 }
            java.lang.String r8 = r8.trim()     // Catch:{ IOException -> 0x0128, InterruptedException -> 0x0121 }
            goto L_0x00cf
        L_0x0098:
            boolean r16 = r15.contains(r3)     // Catch:{ IOException -> 0x0128, InterruptedException -> 0x0121 }
            if (r16 == 0) goto L_0x00a9
            java.lang.String[] r9 = r15.split(r3)     // Catch:{ IOException -> 0x0128, InterruptedException -> 0x0121 }
            r9 = r9[r12]     // Catch:{ IOException -> 0x0128, InterruptedException -> 0x0121 }
            java.lang.String r9 = r9.trim()     // Catch:{ IOException -> 0x0128, InterruptedException -> 0x0121 }
            goto L_0x00cf
        L_0x00a9:
            boolean r16 = r15.contains(r1)     // Catch:{ IOException -> 0x0128, InterruptedException -> 0x0121 }
            if (r16 == 0) goto L_0x00b9
            java.lang.String[] r15 = r15.split(r1)     // Catch:{ IOException -> 0x0128, InterruptedException -> 0x0121 }
            r15 = r15[r12]     // Catch:{ IOException -> 0x0128, InterruptedException -> 0x0121 }
            r15.trim()     // Catch:{ IOException -> 0x0128, InterruptedException -> 0x0121 }
            goto L_0x00cf
        L_0x00b9:
            boolean r16 = r15.contains(r0)     // Catch:{ IOException -> 0x0128, InterruptedException -> 0x0121 }
            if (r16 == 0) goto L_0x00cf
            java.lang.String[] r0 = r15.split(r0)     // Catch:{ IOException -> 0x0128, InterruptedException -> 0x0121 }
            r0 = r0[r13]     // Catch:{ IOException -> 0x0128, InterruptedException -> 0x0121 }
            java.lang.String r0 = r0.trim()     // Catch:{ IOException -> 0x0128, InterruptedException -> 0x0121 }
            if (r6 == 0) goto L_0x00ce
            r6.destroy()
        L_0x00ce:
            return r0
        L_0x00cf:
            int r14 = r14 + 1
            goto L_0x0083
        L_0x00d2:
            java.text.DecimalFormat r10 = new java.text.DecimalFormat     // Catch:{ IOException -> 0x0128, InterruptedException -> 0x0121 }
            java.lang.String r11 = "0"
            r10.<init>(r11)     // Catch:{ IOException -> 0x0128, InterruptedException -> 0x0121 }
            double r11 = java.lang.Double.parseDouble(r8)     // Catch:{ IOException -> 0x0128, InterruptedException -> 0x0121 }
            r13 = 0
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 != 0) goto L_0x00e4
            goto L_0x00f0
        L_0x00e4:
            double r11 = java.lang.Double.parseDouble(r9)     // Catch:{ IOException -> 0x0128, InterruptedException -> 0x0121 }
            double r13 = java.lang.Double.parseDouble(r8)     // Catch:{ IOException -> 0x0128, InterruptedException -> 0x0121 }
            double r11 = r11 / r13
            r13 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r13 = r13 * r11
        L_0x00f0:
            r10.format(r13)     // Catch:{ IOException -> 0x0128, InterruptedException -> 0x0121 }
            goto L_0x002b
        L_0x00f5:
            java.lang.String r11 = "rtt min/avg/max/mdev ="
            boolean r11 = r10.contains(r11)     // Catch:{ IOException -> 0x0128, InterruptedException -> 0x0121 }
            if (r11 == 0) goto L_0x002b
            java.lang.String r0 = "="
            java.lang.String[] r0 = r10.split(r0)     // Catch:{ IOException -> 0x0128, InterruptedException -> 0x0121 }
            r0 = r0[r13]     // Catch:{ IOException -> 0x0128, InterruptedException -> 0x0121 }
            java.lang.String r1 = "ms"
            java.lang.String[] r0 = r0.split(r1)     // Catch:{ IOException -> 0x0128, InterruptedException -> 0x0121 }
            r0 = r0[r12]     // Catch:{ IOException -> 0x0128, InterruptedException -> 0x0121 }
            java.lang.String r0 = r0.trim()     // Catch:{ IOException -> 0x0128, InterruptedException -> 0x0121 }
            java.lang.String r1 = "\\/"
            java.lang.String[] r0 = r0.split(r1)     // Catch:{ IOException -> 0x0128, InterruptedException -> 0x0121 }
            r0 = r0[r13]     // Catch:{ IOException -> 0x0128, InterruptedException -> 0x0121 }
        L_0x0119:
            r6.waitFor()     // Catch:{ IOException -> 0x0128, InterruptedException -> 0x0121 }
            if (r6 == 0) goto L_0x0131
            goto L_0x012e
        L_0x011f:
            r0 = move-exception
            goto L_0x0136
        L_0x0121:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x011f }
            if (r6 == 0) goto L_0x0131
            goto L_0x012e
        L_0x0128:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x011f }
            if (r6 == 0) goto L_0x0131
        L_0x012e:
            r6.destroy()
        L_0x0131:
            java.lang.String r0 = r5.toString()
            return r0
        L_0x0136:
            if (r6 == 0) goto L_0x013b
            r6.destroy()
        L_0x013b:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.eaydu.omni.utils.WifiUtils.getPingResult(java.lang.String):java.lang.String");
    }

    private static String intToIp(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(i & 255);
        sb.append(".");
        int i2 = i >>> 8;
        sb.append(i2 & 255);
        sb.append(".");
        int i3 = i2 >>> 8;
        sb.append(i3 & 255);
        sb.append(".");
        sb.append((i3 >>> 8) & 255);
        return sb.toString();
    }

    public static boolean isDoubleOrFloat(String str) {
        return Pattern.compile("^[-\\+]?[.\\d]*$").matcher(str).matches();
    }
}
