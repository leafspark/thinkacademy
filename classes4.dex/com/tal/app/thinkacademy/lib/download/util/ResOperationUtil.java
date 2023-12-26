package com.tal.app.thinkacademy.lib.download.util;

import android.text.TextUtils;
import com.tal.app.thinkacademy.lib.download.operation.DownloadEngine;
import java.io.File;

public class ResOperationUtil {
    private static String DEFAULT_FILE_DIR = null;
    public static final int FILE_NOT_EXIST = 10004;
    public static final int MERGE_DIFF_FAILED = 10003;
    public static final int RETRY_COUNT = 1;
    public static final int UN_ZIP_FAILED = 10001;
    public static final int VERIFY_MD5_FAILED = 10002;

    public static String getDefaultDirectory() {
        if (TextUtils.isEmpty(DEFAULT_FILE_DIR)) {
            DEFAULT_FILE_DIR = DownloadEngine.getInstance().getApplication().getFilesDir().getAbsolutePath() + File.separator;
        }
        return DEFAULT_FILE_DIR;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0012, code lost:
        r2 = r9.getFileName();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getResNewPath(com.tal.app.thinkacademy.lib.download.model.FilePoint r9) {
        /*
            java.lang.String r0 = "_"
            java.lang.String r1 = ""
            if (r9 == 0) goto L_0x008c
            java.lang.String r2 = r9.getFileName()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x0012
            goto L_0x008c
        L_0x0012:
            java.lang.String r2 = r9.getFileName()
            java.lang.String r3 = "."
            int r3 = r2.lastIndexOf(r3)
            r4 = -1
            if (r3 == r4) goto L_0x008c
            java.lang.String r4 = r9.getVersion()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x008c
            java.lang.StringBuffer r1 = new java.lang.StringBuffer
            r1.<init>()
            java.lang.String r4 = r9.getFilePath()
            r1.append(r4)
            java.lang.String r4 = r9.getVersion()
            r5 = 0
            boolean r6 = r4.contains(r0)     // Catch:{ Exception -> 0x0048 }
            if (r6 == 0) goto L_0x0067
            java.lang.String[] r6 = r4.split(r0)     // Catch:{ Exception -> 0x0048 }
            r9 = r6[r5]     // Catch:{ Exception -> 0x0048 }
            r4 = r9
            goto L_0x0067
        L_0x0048:
            r6 = 1
            java.lang.Object[] r6 = new java.lang.Object[r6]
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "生成合并文件名出问题："
            r7.append(r8)
            java.lang.String r9 = r9.getFileName()
            r7.append(r9)
            java.lang.String r9 = r7.toString()
            r6[r5] = r9
            java.lang.String r9 = "DownloadEngine"
            com.tal.app.thinkacademy.lib.logger.XesLog.et(r9, r6)
        L_0x0067:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r5 = r2.substring(r5, r3)
            r9.append(r5)
            r9.append(r0)
            r9.append(r4)
            java.lang.String r9 = r9.toString()
            r1.append(r9)
            java.lang.String r9 = r2.substring(r3)
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            return r9
        L_0x008c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.lib.download.util.ResOperationUtil.getResNewPath(com.tal.app.thinkacademy.lib.download.model.FilePoint):java.lang.String");
    }
}
