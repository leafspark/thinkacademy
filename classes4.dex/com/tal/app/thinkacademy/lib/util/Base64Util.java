package com.tal.app.thinkacademy.lib.util;

import android.graphics.Bitmap;
import android.util.Base64;
import com.bonree.sdk.agent.engine.external.BitmapFactoryInstrumentation;

public class Base64Util {
    public static String encryptBASE64(String str) {
        return encryptBASE64(str.getBytes());
    }

    public static String encryptBASE64(byte[] bArr) {
        try {
            return Base64.encodeToString(bArr, 0);
        } catch (Exception unused) {
            return "";
        }
    }

    public static byte[] decryptBASE64ToByte(String str) {
        try {
            return Base64.decode(str, 0);
        } catch (Exception unused) {
            return new byte[0];
        }
    }

    public static String decryptBASE64(String str) {
        try {
            return new String(Base64.decode(str, 0));
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x002f A[SYNTHETIC, Splitter:B:18:0x002f] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0037 A[SYNTHETIC, Splitter:B:24:0x0037] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String imageToBase64(java.lang.String r3) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0028, all -> 0x0026 }
            r0.<init>(r3)     // Catch:{ IOException -> 0x0028, all -> 0x0026 }
            int r3 = r0.available()     // Catch:{ IOException -> 0x0024 }
            byte[] r3 = new byte[r3]     // Catch:{ IOException -> 0x0024 }
            r0.read(r3)     // Catch:{ IOException -> 0x0024 }
            r2 = 0
            java.lang.String r1 = android.util.Base64.encodeToString(r3, r2)     // Catch:{ IOException -> 0x0024 }
            r0.close()     // Catch:{ IOException -> 0x001f }
            goto L_0x0032
        L_0x001f:
            r3 = move-exception
            r3.printStackTrace()
            goto L_0x0032
        L_0x0024:
            r3 = move-exception
            goto L_0x002a
        L_0x0026:
            r3 = move-exception
            goto L_0x0035
        L_0x0028:
            r3 = move-exception
            r0 = r1
        L_0x002a:
            r3.printStackTrace()     // Catch:{ all -> 0x0033 }
            if (r0 == 0) goto L_0x0032
            r0.close()     // Catch:{ IOException -> 0x001f }
        L_0x0032:
            return r1
        L_0x0033:
            r3 = move-exception
            r1 = r0
        L_0x0035:
            if (r1 == 0) goto L_0x003f
            r1.close()     // Catch:{ IOException -> 0x003b }
            goto L_0x003f
        L_0x003b:
            r0 = move-exception
            r0.printStackTrace()
        L_0x003f:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.lib.util.Base64Util.imageToBase64(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x003b A[SYNTHETIC, Splitter:B:25:0x003b] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0049 A[SYNTHETIC, Splitter:B:31:0x0049] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean base64ToFile(java.lang.String r3, java.lang.String r4) {
        /*
            r0 = 0
            byte[] r3 = android.util.Base64.decode(r3, r0)
            r1 = r0
        L_0x0006:
            int r2 = r3.length
            if (r1 >= r2) goto L_0x0017
            byte r2 = r3[r1]
            if (r2 >= 0) goto L_0x0014
            byte r2 = r3[r1]
            int r2 = r2 + 256
            byte r2 = (byte) r2
            r3[r1] = r2
        L_0x0014:
            int r1 = r1 + 1
            goto L_0x0006
        L_0x0017:
            r1 = 0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0035 }
            r2.<init>(r4)     // Catch:{ IOException -> 0x0035 }
            r2.write(r3)     // Catch:{ IOException -> 0x0030, all -> 0x002d }
            r2.flush()     // Catch:{ IOException -> 0x0027 }
            r2.close()     // Catch:{ IOException -> 0x0027 }
            goto L_0x002b
        L_0x0027:
            r3 = move-exception
            r3.printStackTrace()
        L_0x002b:
            r3 = 1
            return r3
        L_0x002d:
            r3 = move-exception
            r1 = r2
            goto L_0x0047
        L_0x0030:
            r3 = move-exception
            r1 = r2
            goto L_0x0036
        L_0x0033:
            r3 = move-exception
            goto L_0x0047
        L_0x0035:
            r3 = move-exception
        L_0x0036:
            r3.printStackTrace()     // Catch:{ all -> 0x0033 }
            if (r1 == 0) goto L_0x0046
            r1.flush()     // Catch:{ IOException -> 0x0042 }
            r1.close()     // Catch:{ IOException -> 0x0042 }
            goto L_0x0046
        L_0x0042:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0046:
            return r0
        L_0x0047:
            if (r1 == 0) goto L_0x0054
            r1.flush()     // Catch:{ IOException -> 0x0050 }
            r1.close()     // Catch:{ IOException -> 0x0050 }
            goto L_0x0054
        L_0x0050:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0054:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.lib.util.Base64Util.base64ToFile(java.lang.String, java.lang.String):boolean");
    }

    public static byte[] base64ToBitmapBytes(String str) {
        try {
            return Base64.decode(str.split(",")[1], 0);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Bitmap base64ToBitmap(String str) {
        try {
            byte[] decode = Base64.decode(str.split(",")[1], 0);
            return BitmapFactoryInstrumentation.decodeByteArray(decode, 0, decode.length);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
