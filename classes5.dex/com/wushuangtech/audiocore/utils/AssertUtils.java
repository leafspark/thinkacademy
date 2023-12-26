package com.wushuangtech.audiocore.utils;

import android.text.TextUtils;
import com.wushuangtech.utils.OmniLog;

public class AssertUtils {
    private static final String ASSET_PATH_PREFIX = "/assets/";
    private static final String TAG = "AssertUtils";

    public static String transformToPath(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int length = str.length();
        boolean z = false;
        if (length <= 8 || !str.substring(0, 8).equals(ASSET_PATH_PREFIX)) {
            str2 = null;
        } else {
            str2 = str.substring(8, length);
            z = true;
        }
        OmniLog.d(TAG, "transformToPath path : " + str2 + " | asset : " + z);
        if (!z || TextUtils.isEmpty(str2)) {
            return null;
        }
        return str2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:66:0x016c A[SYNTHETIC, Splitter:B:66:0x016c] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0176 A[SYNTHETIC, Splitter:B:71:0x0176] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0183 A[SYNTHETIC, Splitter:B:79:0x0183] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x018d A[SYNTHETIC, Splitter:B:84:0x018d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String transformToFile(android.content.Context r8, java.lang.String r9) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            java.lang.String r1 = "AssertUtils"
            r2 = 0
            if (r0 == 0) goto L_0x001e
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "Error file path! "
            r8.append(r0)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            com.wushuangtech.utils.OmniLog.e(r1, r8)
            return r2
        L_0x001e:
            java.lang.String r0 = android.os.Environment.getExternalStorageState()
            java.lang.String r3 = "mounted"
            boolean r0 = r3.equals(r0)
            java.lang.String r3 = "/assertMusic"
            if (r0 != 0) goto L_0x0044
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.io.File r4 = r8.getFilesDir()
            java.lang.String r4 = r4.getParent()
            r0.append(r4)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            goto L_0x0075
        L_0x0044:
            java.io.File r0 = r8.getExternalFilesDir(r2)
            if (r0 != 0) goto L_0x0062
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.io.File r4 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r4 = r4.getAbsolutePath()
            r0.append(r4)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            goto L_0x0075
        L_0x0062:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = r0.getAbsolutePath()
            r4.append(r0)
            r4.append(r3)
            java.lang.String r0 = r4.toString()
        L_0x0075:
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 == 0) goto L_0x0090
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "Get sd save path failed! "
            r8.append(r0)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            com.wushuangtech.utils.OmniLog.e(r1, r8)
            return r2
        L_0x0090:
            java.io.File r3 = new java.io.File
            r3.<init>(r0)
            boolean r4 = r3.exists()
            if (r4 != 0) goto L_0x00b6
            boolean r4 = r3.mkdirs()
            if (r4 != 0) goto L_0x00b6
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Make assert music dir failed! "
            r8.append(r9)
            r8.append(r0)
            java.lang.String r8 = r8.toString()
            com.wushuangtech.utils.OmniLog.e(r1, r8)
            return r2
        L_0x00b6:
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x014f, all -> 0x014c }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x014f, all -> 0x014c }
            r4.<init>()     // Catch:{ Exception -> 0x014f, all -> 0x014c }
            java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ Exception -> 0x014f, all -> 0x014c }
            r4.append(r3)     // Catch:{ Exception -> 0x014f, all -> 0x014c }
            java.lang.String r3 = java.io.File.separator     // Catch:{ Exception -> 0x014f, all -> 0x014c }
            r4.append(r3)     // Catch:{ Exception -> 0x014f, all -> 0x014c }
            r4.append(r9)     // Catch:{ Exception -> 0x014f, all -> 0x014c }
            java.lang.String r3 = r4.toString()     // Catch:{ Exception -> 0x014f, all -> 0x014c }
            r0.<init>(r3)     // Catch:{ Exception -> 0x014f, all -> 0x014c }
            boolean r3 = r0.exists()     // Catch:{ Exception -> 0x014f, all -> 0x014c }
            if (r3 == 0) goto L_0x00f8
            boolean r3 = r0.delete()     // Catch:{ Exception -> 0x014f, all -> 0x014c }
            if (r3 != 0) goto L_0x00f8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x014f, all -> 0x014c }
            r8.<init>()     // Catch:{ Exception -> 0x014f, all -> 0x014c }
            java.lang.String r9 = "Delete old file failed! "
            r8.append(r9)     // Catch:{ Exception -> 0x014f, all -> 0x014c }
            java.lang.String r9 = r0.getAbsolutePath()     // Catch:{ Exception -> 0x014f, all -> 0x014c }
            r8.append(r9)     // Catch:{ Exception -> 0x014f, all -> 0x014c }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x014f, all -> 0x014c }
            com.wushuangtech.utils.OmniLog.e(r1, r8)     // Catch:{ Exception -> 0x014f, all -> 0x014c }
            return r2
        L_0x00f8:
            android.content.res.AssetManager r8 = r8.getAssets()     // Catch:{ Exception -> 0x014f, all -> 0x014c }
            java.io.InputStream r8 = r8.open(r9)     // Catch:{ Exception -> 0x014f, all -> 0x014c }
            java.io.FileOutputStream r9 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0146, all -> 0x0141 }
            r9.<init>(r0)     // Catch:{ Exception -> 0x0146, all -> 0x0141 }
            r3 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r3]     // Catch:{ Exception -> 0x013b, all -> 0x0136 }
        L_0x0109:
            int r5 = r8.read(r4)     // Catch:{ Exception -> 0x013b, all -> 0x0136 }
            r6 = -1
            if (r5 == r6) goto L_0x0118
            r5 = 0
            r9.write(r4, r5, r3)     // Catch:{ Exception -> 0x013b, all -> 0x0136 }
            r9.flush()     // Catch:{ Exception -> 0x013b, all -> 0x0136 }
            goto L_0x0109
        L_0x0118:
            if (r8 == 0) goto L_0x0122
            r8.close()     // Catch:{ IOException -> 0x011e }
            goto L_0x0122
        L_0x011e:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0122:
            r9.close()     // Catch:{ IOException -> 0x0126 }
            goto L_0x012a
        L_0x0126:
            r8 = move-exception
            r8.printStackTrace()
        L_0x012a:
            boolean r8 = r0.exists()
            if (r8 == 0) goto L_0x0135
            java.lang.String r8 = r0.getAbsolutePath()
            return r8
        L_0x0135:
            return r2
        L_0x0136:
            r0 = move-exception
            r2 = r8
            r8 = r0
            r0 = r9
            goto L_0x0181
        L_0x013b:
            r0 = move-exception
            r7 = r9
            r9 = r8
            r8 = r0
            r0 = r7
            goto L_0x0152
        L_0x0141:
            r9 = move-exception
            r0 = r2
            r2 = r8
            r8 = r9
            goto L_0x0181
        L_0x0146:
            r9 = move-exception
            r0 = r2
            r7 = r9
            r9 = r8
            r8 = r7
            goto L_0x0152
        L_0x014c:
            r8 = move-exception
            r0 = r2
            goto L_0x0181
        L_0x014f:
            r8 = move-exception
            r9 = r2
            r0 = r9
        L_0x0152:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x017f }
            r3.<init>()     // Catch:{ all -> 0x017f }
            java.lang.String r4 = "Transform failed! exception : "
            r3.append(r4)     // Catch:{ all -> 0x017f }
            java.lang.String r8 = r8.getLocalizedMessage()     // Catch:{ all -> 0x017f }
            r3.append(r8)     // Catch:{ all -> 0x017f }
            java.lang.String r8 = r3.toString()     // Catch:{ all -> 0x017f }
            com.wushuangtech.utils.OmniLog.e(r1, r8)     // Catch:{ all -> 0x017f }
            if (r9 == 0) goto L_0x0174
            r9.close()     // Catch:{ IOException -> 0x0170 }
            goto L_0x0174
        L_0x0170:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0174:
            if (r0 == 0) goto L_0x017e
            r0.close()     // Catch:{ IOException -> 0x017a }
            goto L_0x017e
        L_0x017a:
            r8 = move-exception
            r8.printStackTrace()
        L_0x017e:
            return r2
        L_0x017f:
            r8 = move-exception
            r2 = r9
        L_0x0181:
            if (r2 == 0) goto L_0x018b
            r2.close()     // Catch:{ IOException -> 0x0187 }
            goto L_0x018b
        L_0x0187:
            r9 = move-exception
            r9.printStackTrace()
        L_0x018b:
            if (r0 == 0) goto L_0x0195
            r0.close()     // Catch:{ IOException -> 0x0191 }
            goto L_0x0195
        L_0x0191:
            r9 = move-exception
            r9.printStackTrace()
        L_0x0195:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.audiocore.utils.AssertUtils.transformToFile(android.content.Context, java.lang.String):java.lang.String");
    }
}
