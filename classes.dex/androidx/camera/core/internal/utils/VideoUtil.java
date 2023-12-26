package androidx.camera.core.internal.utils;

public final class VideoUtil {
    private static final String TAG = "VideoUtil";

    private VideoUtil() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0055  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getAbsolutePathFromUri(android.content.ContentResolver r8, android.net.Uri r9) {
        /*
            java.lang.String r0 = "_data"
            r1 = 0
            java.lang.String[] r4 = new java.lang.String[]{r0}     // Catch:{ RuntimeException -> 0x002d }
            r5 = 0
            r6 = 0
            r7 = 0
            r2 = r8
            r3 = r9
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7)     // Catch:{ RuntimeException -> 0x002d }
            java.lang.Object r8 = androidx.core.util.Preconditions.checkNotNull(r1)     // Catch:{ RuntimeException -> 0x002d }
            android.database.Cursor r8 = (android.database.Cursor) r8     // Catch:{ RuntimeException -> 0x002d }
            int r0 = r8.getColumnIndexOrThrow(r0)     // Catch:{ RuntimeException -> 0x002a, all -> 0x0027 }
            r8.moveToFirst()     // Catch:{ RuntimeException -> 0x002a, all -> 0x0027 }
            java.lang.String r9 = r8.getString(r0)     // Catch:{ RuntimeException -> 0x002a, all -> 0x0027 }
            if (r8 == 0) goto L_0x0026
            r8.close()
        L_0x0026:
            return r9
        L_0x0027:
            r9 = move-exception
            r1 = r8
            goto L_0x0053
        L_0x002a:
            r0 = move-exception
            r1 = r8
            goto L_0x002e
        L_0x002d:
            r0 = move-exception
        L_0x002e:
            java.lang.String r8 = "VideoUtil"
            java.lang.String r2 = "Failed in getting absolute path for Uri %s with Exception %s"
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x0052 }
            r4 = 0
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0052 }
            r3[r4] = r9     // Catch:{ all -> 0x0052 }
            r9 = 1
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0052 }
            r3[r9] = r0     // Catch:{ all -> 0x0052 }
            java.lang.String r9 = java.lang.String.format(r2, r3)     // Catch:{ all -> 0x0052 }
            androidx.camera.core.Logger.e(r8, r9)     // Catch:{ all -> 0x0052 }
            java.lang.String r8 = ""
            if (r1 == 0) goto L_0x0051
            r1.close()
        L_0x0051:
            return r8
        L_0x0052:
            r9 = move-exception
        L_0x0053:
            if (r1 == 0) goto L_0x0058
            r1.close()
        L_0x0058:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.internal.utils.VideoUtil.getAbsolutePathFromUri(android.content.ContentResolver, android.net.Uri):java.lang.String");
    }
}
