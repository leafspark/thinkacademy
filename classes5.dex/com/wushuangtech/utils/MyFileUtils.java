package com.wushuangtech.utils;

import java.util.Locale;

public class MyFileUtils {
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00b2 A[SYNTHETIC, Splitter:B:51:0x00b2] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00bc A[SYNTHETIC, Splitter:B:56:0x00bc] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00c6 A[SYNTHETIC, Splitter:B:61:0x00c6] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00d2 A[SYNTHETIC, Splitter:B:68:0x00d2] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00dc A[SYNTHETIC, Splitter:B:73:0x00dc] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e6 A[SYNTHETIC, Splitter:B:78:0x00e6] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String moveVideoFileToDCIM(android.content.Context r6, java.lang.String r7) {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r7)
            boolean r7 = r0.exists()
            java.lang.String r1 = ""
            if (r7 != 0) goto L_0x000e
            return r1
        L_0x000e:
            r7 = 0
            android.content.ContentResolver r6 = r6.getContentResolver()     // Catch:{ Exception -> 0x00a8, all -> 0x00a2 }
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch:{ Exception -> 0x00a8, all -> 0x00a2 }
            r2.<init>()     // Catch:{ Exception -> 0x00a8, all -> 0x00a2 }
            java.lang.String r3 = "_display_name"
            java.lang.String r4 = r0.getName()     // Catch:{ Exception -> 0x00a8, all -> 0x00a2 }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x00a8, all -> 0x00a2 }
            java.lang.String r3 = "mime_type"
            java.lang.String r4 = "video/*"
            r2.put(r3, r4)     // Catch:{ Exception -> 0x00a8, all -> 0x00a2 }
            android.net.Uri r3 = android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI     // Catch:{ Exception -> 0x00a8, all -> 0x00a2 }
            android.net.Uri r2 = r6.insert(r3, r2)     // Catch:{ Exception -> 0x00a8, all -> 0x00a2 }
            if (r2 != 0) goto L_0x0031
            return r1
        L_0x0031:
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00a8, all -> 0x00a2 }
            r3.<init>(r0)     // Catch:{ Exception -> 0x00a8, all -> 0x00a2 }
            java.lang.String r4 = "w"
            android.os.ParcelFileDescriptor r6 = r6.openFileDescriptor(r2, r4)     // Catch:{ Exception -> 0x009d, all -> 0x0098 }
            android.os.ParcelFileDescriptor$AutoCloseOutputStream r2 = new android.os.ParcelFileDescriptor$AutoCloseOutputStream     // Catch:{ Exception -> 0x0094, all -> 0x0090 }
            r2.<init>(r6)     // Catch:{ Exception -> 0x0094, all -> 0x0090 }
            r7 = 1024(0x400, float:1.435E-42)
            byte[] r7 = new byte[r7]     // Catch:{ Exception -> 0x008e }
        L_0x0045:
            int r4 = r3.read(r7)     // Catch:{ Exception -> 0x008e }
            r5 = -1
            if (r4 == r5) goto L_0x0051
            r5 = 0
            r2.write(r7, r5, r4)     // Catch:{ Exception -> 0x008e }
            goto L_0x0045
        L_0x0051:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x008e }
            r7.<init>()     // Catch:{ Exception -> 0x008e }
            java.lang.String r4 = android.os.Environment.DIRECTORY_MOVIES     // Catch:{ Exception -> 0x008e }
            java.io.File r4 = android.os.Environment.getExternalStoragePublicDirectory(r4)     // Catch:{ Exception -> 0x008e }
            java.lang.String r4 = r4.getAbsolutePath()     // Catch:{ Exception -> 0x008e }
            r7.append(r4)     // Catch:{ Exception -> 0x008e }
            java.lang.String r4 = "/"
            r7.append(r4)     // Catch:{ Exception -> 0x008e }
            java.lang.String r0 = r0.getName()     // Catch:{ Exception -> 0x008e }
            r7.append(r0)     // Catch:{ Exception -> 0x008e }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x008e }
            r3.close()     // Catch:{ IOException -> 0x0077 }
            goto L_0x007b
        L_0x0077:
            r0 = move-exception
            r0.printStackTrace()
        L_0x007b:
            if (r6 == 0) goto L_0x0085
            r6.close()     // Catch:{ IOException -> 0x0081 }
            goto L_0x0085
        L_0x0081:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0085:
            r2.close()     // Catch:{ IOException -> 0x0089 }
            goto L_0x008d
        L_0x0089:
            r6 = move-exception
            r6.printStackTrace()
        L_0x008d:
            return r7
        L_0x008e:
            r7 = move-exception
            goto L_0x00ad
        L_0x0090:
            r0 = move-exception
            r2 = r7
            r7 = r0
            goto L_0x00d0
        L_0x0094:
            r0 = move-exception
            r2 = r7
            r7 = r0
            goto L_0x00ad
        L_0x0098:
            r6 = move-exception
            r2 = r7
            r7 = r6
            r6 = r2
            goto L_0x00d0
        L_0x009d:
            r6 = move-exception
            r2 = r7
            r7 = r6
            r6 = r2
            goto L_0x00ad
        L_0x00a2:
            r6 = move-exception
            r2 = r7
            r3 = r2
            r7 = r6
            r6 = r3
            goto L_0x00d0
        L_0x00a8:
            r6 = move-exception
            r2 = r7
            r3 = r2
            r7 = r6
            r6 = r3
        L_0x00ad:
            r7.printStackTrace()     // Catch:{ all -> 0x00cf }
            if (r3 == 0) goto L_0x00ba
            r3.close()     // Catch:{ IOException -> 0x00b6 }
            goto L_0x00ba
        L_0x00b6:
            r7 = move-exception
            r7.printStackTrace()
        L_0x00ba:
            if (r6 == 0) goto L_0x00c4
            r6.close()     // Catch:{ IOException -> 0x00c0 }
            goto L_0x00c4
        L_0x00c0:
            r6 = move-exception
            r6.printStackTrace()
        L_0x00c4:
            if (r2 == 0) goto L_0x00ce
            r2.close()     // Catch:{ IOException -> 0x00ca }
            goto L_0x00ce
        L_0x00ca:
            r6 = move-exception
            r6.printStackTrace()
        L_0x00ce:
            return r1
        L_0x00cf:
            r7 = move-exception
        L_0x00d0:
            if (r3 == 0) goto L_0x00da
            r3.close()     // Catch:{ IOException -> 0x00d6 }
            goto L_0x00da
        L_0x00d6:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00da:
            if (r6 == 0) goto L_0x00e4
            r6.close()     // Catch:{ IOException -> 0x00e0 }
            goto L_0x00e4
        L_0x00e0:
            r6 = move-exception
            r6.printStackTrace()
        L_0x00e4:
            if (r2 == 0) goto L_0x00ee
            r2.close()     // Catch:{ IOException -> 0x00ea }
            goto L_0x00ee
        L_0x00ea:
            r6 = move-exception
            r6.printStackTrace()
        L_0x00ee:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.utils.MyFileUtils.moveVideoFileToDCIM(android.content.Context, java.lang.String):java.lang.String");
    }

    private static String formatedSize(long j) {
        if (j >= 100000) {
            return String.format(Locale.CHINA, "%.2f MB", new Object[]{Float.valueOf((((float) j) / 1000.0f) / 1000.0f)});
        } else if (j >= 100) {
            return String.format(Locale.CHINA, "%.1f KB", new Object[]{Float.valueOf(((float) j) / 1000.0f)});
        } else {
            return String.format(Locale.CHINA, "%d B", new Object[]{Long.valueOf(j)});
        }
    }
}
