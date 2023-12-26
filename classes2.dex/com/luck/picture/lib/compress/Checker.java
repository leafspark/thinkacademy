package com.luck.picture.lib.compress;

import android.text.TextUtils;
import com.luck.picture.lib.config.PictureMimeType;
import java.io.File;
import java.io.InputStream;
import java.util.Arrays;

enum Checker {
    SINGLE;
    
    private static final String JPG = ".jpg";
    public static final String MIME_TYPE_HEIC = "image/heic";
    public static final String MIME_TYPE_JPEG = "image/jpeg";
    public static final String MIME_TYPE_JPG = "image/jpg";
    private static final String TAG = "Luban";
    private final byte[] JPEG_SIGNATURE;

    /* access modifiers changed from: package-private */
    public boolean isJPG(InputStream inputStream) {
        return isJPG(toByteArray(inputStream));
    }

    /* access modifiers changed from: package-private */
    public boolean isJPG(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith(MIME_TYPE_HEIC) || str.startsWith("image/jpeg") || str.startsWith(MIME_TYPE_JPG)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public int getOrientation(InputStream inputStream) {
        return getOrientation(toByteArray(inputStream));
    }

    private boolean isJPG(byte[] bArr) {
        if (bArr == null || bArr.length < 3) {
            return false;
        }
        return Arrays.equals(this.JPEG_SIGNATURE, new byte[]{bArr[0], bArr[1], bArr[2]});
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0066, code lost:
        r3 = 0;
        r1 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x006a, code lost:
        if (r3 <= 8) goto L_0x00d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x006c, code lost:
        r2 = pack(r12, r1, 4, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0073, code lost:
        if (r2 == 1229531648) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0078, code lost:
        if (r2 == 1296891946) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x007a, code lost:
        android.util.Log.e(TAG, "Invalid byte order");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x007f, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0080, code lost:
        if (r2 != 1229531648) goto L_0x0084;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0082, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0084, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0085, code lost:
        r4 = pack(r12, r1 + 4, 4, r2) + 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x008e, code lost:
        if (r4 < 10) goto L_0x00d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0090, code lost:
        if (r4 <= r3) goto L_0x0093;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0093, code lost:
        r1 = r1 + r4;
        r3 = r3 - r4;
        r4 = pack(r12, r1 - 2, 2, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x009b, code lost:
        r9 = r4 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x009d, code lost:
        if (r4 <= 0) goto L_0x00d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00a1, code lost:
        if (r3 < 12) goto L_0x00d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00a9, code lost:
        if (pack(r12, r1, 2, r2) != 274) goto L_0x00ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00ab, code lost:
        r12 = pack(r12, r1 + 8, 2, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00b0, code lost:
        if (r12 == 1) goto L_0x00c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00b3, code lost:
        if (r12 == 3) goto L_0x00c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00b6, code lost:
        if (r12 == 6) goto L_0x00c3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00b8, code lost:
        if (r12 == 8) goto L_0x00c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00ba, code lost:
        android.util.Log.e(TAG, "Unsupported orientation");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00bf, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00c0, code lost:
        return 270;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00c3, code lost:
        return 90;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00c6, code lost:
        return 180;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00c9, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00ca, code lost:
        r1 = r1 + 12;
        r3 = r3 - 12;
        r4 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00d0, code lost:
        android.util.Log.e(TAG, "Invalid offset");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00d5, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00d6, code lost:
        android.util.Log.e(TAG, "Orientation not found");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x00db, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int getOrientation(byte[] r12) {
        /*
            r11 = this;
            r0 = 0
            if (r12 != 0) goto L_0x0004
            return r0
        L_0x0004:
            r1 = r0
        L_0x0005:
            int r2 = r1 + 3
            int r3 = r12.length
            r4 = 4
            java.lang.String r5 = "Luban"
            r6 = 1
            r7 = 8
            r8 = 2
            if (r2 >= r3) goto L_0x0069
            int r2 = r1 + 1
            byte r1 = r12[r1]
            r3 = 255(0xff, float:3.57E-43)
            r1 = r1 & r3
            if (r1 != r3) goto L_0x0066
            byte r1 = r12[r2]
            r1 = r1 & r3
            if (r1 != r3) goto L_0x0020
            goto L_0x0064
        L_0x0020:
            int r2 = r2 + 1
            r3 = 216(0xd8, float:3.03E-43)
            if (r1 == r3) goto L_0x0064
            if (r1 != r6) goto L_0x0029
            goto L_0x0064
        L_0x0029:
            r3 = 217(0xd9, float:3.04E-43)
            if (r1 == r3) goto L_0x0066
            r3 = 218(0xda, float:3.05E-43)
            if (r1 != r3) goto L_0x0032
            goto L_0x0066
        L_0x0032:
            int r3 = r11.pack(r12, r2, r8, r0)
            if (r3 < r8) goto L_0x005e
            int r9 = r2 + r3
            int r10 = r12.length
            if (r9 <= r10) goto L_0x003e
            goto L_0x005e
        L_0x003e:
            r10 = 225(0xe1, float:3.15E-43)
            if (r1 != r10) goto L_0x005c
            if (r3 < r7) goto L_0x005c
            int r1 = r2 + 2
            int r1 = r11.pack(r12, r1, r4, r0)
            r10 = 1165519206(0x45786966, float:3974.5874)
            if (r1 != r10) goto L_0x005c
            int r1 = r2 + 6
            int r1 = r11.pack(r12, r1, r8, r0)
            if (r1 != 0) goto L_0x005c
            int r1 = r2 + 8
            int r3 = r3 + -8
            goto L_0x006a
        L_0x005c:
            r1 = r9
            goto L_0x0005
        L_0x005e:
            java.lang.String r12 = "Invalid length"
            android.util.Log.e(r5, r12)
            return r0
        L_0x0064:
            r1 = r2
            goto L_0x0005
        L_0x0066:
            r3 = r0
            r1 = r2
            goto L_0x006a
        L_0x0069:
            r3 = r0
        L_0x006a:
            if (r3 <= r7) goto L_0x00d6
            int r2 = r11.pack(r12, r1, r4, r0)
            r9 = 1229531648(0x49492a00, float:823968.0)
            if (r2 == r9) goto L_0x0080
            r10 = 1296891946(0x4d4d002a, float:2.14958752E8)
            if (r2 == r10) goto L_0x0080
            java.lang.String r12 = "Invalid byte order"
            android.util.Log.e(r5, r12)
            return r0
        L_0x0080:
            if (r2 != r9) goto L_0x0084
            r2 = r6
            goto L_0x0085
        L_0x0084:
            r2 = r0
        L_0x0085:
            int r9 = r1 + 4
            int r4 = r11.pack(r12, r9, r4, r2)
            int r4 = r4 + r8
            r9 = 10
            if (r4 < r9) goto L_0x00d0
            if (r4 <= r3) goto L_0x0093
            goto L_0x00d0
        L_0x0093:
            int r1 = r1 + r4
            int r3 = r3 - r4
            int r4 = r1 + -2
            int r4 = r11.pack(r12, r4, r8, r2)
        L_0x009b:
            int r9 = r4 + -1
            if (r4 <= 0) goto L_0x00d6
            r4 = 12
            if (r3 < r4) goto L_0x00d6
            int r4 = r11.pack(r12, r1, r8, r2)
            r10 = 274(0x112, float:3.84E-43)
            if (r4 != r10) goto L_0x00ca
            int r1 = r1 + r7
            int r12 = r11.pack(r12, r1, r8, r2)
            if (r12 == r6) goto L_0x00c9
            r1 = 3
            if (r12 == r1) goto L_0x00c6
            r1 = 6
            if (r12 == r1) goto L_0x00c3
            if (r12 == r7) goto L_0x00c0
            java.lang.String r12 = "Unsupported orientation"
            android.util.Log.e(r5, r12)
            return r0
        L_0x00c0:
            r12 = 270(0x10e, float:3.78E-43)
            return r12
        L_0x00c3:
            r12 = 90
            return r12
        L_0x00c6:
            r12 = 180(0xb4, float:2.52E-43)
            return r12
        L_0x00c9:
            return r0
        L_0x00ca:
            int r1 = r1 + 12
            int r3 = r3 + -12
            r4 = r9
            goto L_0x009b
        L_0x00d0:
            java.lang.String r12 = "Invalid offset"
            android.util.Log.e(r5, r12)
            return r0
        L_0x00d6:
            java.lang.String r12 = "Orientation not found"
            android.util.Log.e(r5, r12)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.compress.Checker.getOrientation(byte[]):int");
    }

    /* access modifiers changed from: package-private */
    public String extSuffix(String str) {
        if (TextUtils.isEmpty(str)) {
            return ".jpg";
        }
        try {
            return str.replace(str.startsWith(PictureMimeType.MIME_TYPE_PREFIX_VIDEO) ? "video/" : "image/", ".");
        } catch (Exception unused) {
            return ".jpg";
        }
    }

    /* access modifiers changed from: package-private */
    public boolean needCompress(int i, String str) {
        if (i <= 0) {
            return true;
        }
        File file = new File(str);
        if (!file.exists() || file.length() <= ((long) (i << 10))) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean needCompressToLocalMedia(int i, String str) {
        if (i <= 0 || TextUtils.isEmpty(str)) {
            return true;
        }
        File file = new File(str);
        if (!file.exists() || file.length() <= ((long) (i << 10))) {
            return false;
        }
        return true;
    }

    private int pack(byte[] bArr, int i, int i2, boolean z) {
        int i3;
        if (z) {
            i += i2 - 1;
            i3 = -1;
        } else {
            i3 = 1;
        }
        byte b = 0;
        while (true) {
            int i4 = i2 - 1;
            if (i2 <= 0) {
                return b;
            }
            b = (bArr[i] & 255) | (b << 8);
            i += i3;
            i2 = i4;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:15|16|17|18|19) */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0022, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0029, code lost:
        return new byte[0];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x002d, code lost:
        throw r7;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0024 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] toByteArray(java.io.InputStream r7) {
        /*
            r6 = this;
            r0 = 0
            if (r7 != 0) goto L_0x0006
            byte[] r7 = new byte[r0]
            return r7
        L_0x0006:
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream
            r1.<init>()
            r2 = 4096(0x1000, float:5.74E-42)
            byte[] r3 = new byte[r2]
        L_0x000f:
            int r4 = r7.read(r3, r0, r2)     // Catch:{ Exception -> 0x0024 }
            r5 = -1
            if (r4 == r5) goto L_0x001a
            r1.write(r3, r0, r4)     // Catch:{ Exception -> 0x0024 }
            goto L_0x000f
        L_0x001a:
            r1.close()     // Catch:{ IOException -> 0x001d }
        L_0x001d:
            byte[] r7 = r1.toByteArray()
            return r7
        L_0x0022:
            r7 = move-exception
            goto L_0x002a
        L_0x0024:
            byte[] r7 = new byte[r0]     // Catch:{ all -> 0x0022 }
            r1.close()     // Catch:{ IOException -> 0x0029 }
        L_0x0029:
            return r7
        L_0x002a:
            r1.close()     // Catch:{ IOException -> 0x002d }
        L_0x002d:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.compress.Checker.toByteArray(java.io.InputStream):byte[]");
    }
}
