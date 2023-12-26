package com.igexin.b.a.b;

import com.bumptech.glide.request.target.Target;
import com.luck.picture.lib.tools.PictureFileUtils;
import java.io.InputStream;
import java.io.OutputStream;

public final class e {
    public static int a(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) ((i >> 24) & 255);
        bArr[i2 + 1] = (byte) ((i >> 16) & 255);
        bArr[i2 + 2] = (byte) ((i >> 8) & 255);
        bArr[i2 + 3] = (byte) (i & 255);
        return 4;
    }

    public static int a(long j, byte[] bArr, int i) {
        bArr[i] = (byte) ((int) ((j >> 56) & 255));
        bArr[i + 1] = (byte) ((int) ((j >> 48) & 255));
        bArr[i + 2] = (byte) ((int) ((j >> 40) & 255));
        bArr[i + 3] = (byte) ((int) ((j >> 32) & 255));
        bArr[i + 4] = (byte) ((int) ((j >> 24) & 255));
        bArr[i + 5] = (byte) ((int) ((j >> 16) & 255));
        bArr[i + 6] = (byte) ((int) ((j >> 8) & 255));
        bArr[i + 7] = (byte) ((int) (j & 255));
        return 8;
    }

    public static int a(byte[] bArr, int i) {
        return bArr[i] & 255;
    }

    public static int a(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        System.arraycopy(bArr, i, bArr2, i2, i3);
        return i3;
    }

    public static String a(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        if (!strArr[0].equals("")) {
            sb.append(strArr[0]);
            sb.append("://");
        }
        if (!strArr[1].equals("")) {
            sb.append(strArr[1]);
        }
        if (!strArr[2].equals("")) {
            sb.append(':');
            sb.append(strArr[2]);
        }
        if (!strArr[3].equals("")) {
            sb.append(strArr[3]);
            if (!strArr[3].equals("/")) {
                sb.append('/');
            }
        }
        if (!strArr[4].equals("")) {
            sb.append(strArr[4]);
        }
        if (!strArr[5].equals("")) {
            sb.append('?');
            sb.append(strArr[5]);
        }
        return sb.toString();
    }

    private static void a(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[PictureFileUtils.KB];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public static void a(InputStream inputStream, OutputStream outputStream, int i) {
        a aVar = new a(outputStream, i);
        a(inputStream, (OutputStream) aVar);
        aVar.a();
    }

    public static byte[] a(int i) {
        int i2;
        int i3 = 0;
        int i4 = 0;
        do {
            i2 = 24;
            i3 |= (i & 127) << 24;
            i >>>= 7;
            i4++;
            if (i > 0) {
                i3 = (i3 >>> 8) | Target.SIZE_ORIGINAL;
                continue;
            }
        } while (i > 0);
        byte[] bArr = new byte[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            bArr[i5] = (byte) (i3 >>> i2);
            i2 -= 8;
        }
        return bArr;
    }

    public static byte[] a(byte[] bArr) {
        return c(bArr);
    }

    public static String[] a(String str) {
        StringBuilder sb = new StringBuilder(str.toLowerCase());
        String[] strArr = new String[6];
        for (int i = 0; i < 6; i++) {
            strArr[i] = "";
        }
        int indexOf = str.indexOf(":");
        if (indexOf > 0) {
            strArr[0] = str.substring(0, indexOf);
            sb.delete(0, indexOf + 1);
        } else if (indexOf == 0) {
            throw new IllegalArgumentException("url format error - protocol");
        }
        if (sb.length() >= 2 && sb.charAt(0) == '/' && sb.charAt(1) == '/') {
            sb.delete(0, 2);
            int indexOf2 = sb.toString().indexOf(47);
            if (indexOf2 < 0) {
                indexOf2 = sb.length();
            }
            if (indexOf2 != 0) {
                int lastIndexOf = sb.toString().lastIndexOf(58);
                if (lastIndexOf < 0) {
                    lastIndexOf = indexOf2;
                } else if (lastIndexOf <= indexOf2) {
                    strArr[2] = sb.toString().substring(lastIndexOf + 1, indexOf2);
                } else {
                    throw new IllegalArgumentException("url format error - port");
                }
                strArr[1] = sb.toString().substring(0, lastIndexOf);
                sb.delete(0, indexOf2);
            }
        }
        if (sb.length() > 0) {
            String sb2 = sb.toString();
            int lastIndexOf2 = sb2.lastIndexOf(47);
            if (lastIndexOf2 > 0) {
                strArr[3] = sb2.substring(0, lastIndexOf2);
            } else if (lastIndexOf2 == 0) {
                if (sb2.indexOf(63) <= 0) {
                    strArr[3] = sb2;
                    return strArr;
                }
                throw new IllegalArgumentException("url format error - path");
            }
            if (lastIndexOf2 < sb2.length() - 1) {
                String substring = sb2.substring(lastIndexOf2 + 1, sb2.length());
                int indexOf3 = substring.indexOf(63);
                if (indexOf3 >= 0) {
                    strArr[4] = substring.substring(0, indexOf3);
                    strArr[5] = substring.substring(indexOf3 + 1);
                } else {
                    strArr[4] = substring;
                }
            }
        } else {
            strArr[3] = "/";
        }
        return strArr;
    }

    public static int b(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) ((i >> 8) & 255);
        bArr[i2 + 1] = (byte) (i & 255);
        return 2;
    }

    public static short b(byte[] bArr, int i) {
        return (short) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
    }

    public static byte[] b(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public static byte[] b(byte[] bArr) {
        return d(bArr);
    }

    public static int c(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        return 1;
    }

    public static int c(byte[] bArr, int i) {
        return (bArr[i + 1] & 255) | ((bArr[i] & 255) << 8);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|13|(1:(0))) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
        if (r2 != null) goto L_0x0015;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0018 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] c(byte[] r3) {
        /*
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r1 = 0
            java.util.zip.GZIPOutputStream r2 = new java.util.zip.GZIPOutputStream     // Catch:{ all -> 0x001c }
            r2.<init>(r0)     // Catch:{ all -> 0x001c }
            r2.write(r3)     // Catch:{ all -> 0x001d }
            r2.finish()     // Catch:{ all -> 0x001d }
            byte[] r1 = r0.toByteArray()     // Catch:{ all -> 0x001d }
        L_0x0015:
            r2.close()     // Catch:{ Exception -> 0x0018 }
        L_0x0018:
            r0.close()     // Catch:{ Exception -> 0x0020 }
            goto L_0x0020
        L_0x001c:
            r2 = r1
        L_0x001d:
            if (r2 == 0) goto L_0x0018
            goto L_0x0015
        L_0x0020:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.b.a.b.e.c(byte[]):byte[]");
    }

    public static int d(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(15:0|1|2|3|4|(3:5|6|(1:8)(1:28))|9|10|11|12|13|14|15|26|(1:(0))) */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0032, code lost:
        if (r1 == null) goto L_0x0025;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0022 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0025 */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x002f A[SYNTHETIC, Splitter:B:22:0x002f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] d(byte[] r5) {
        /*
            java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream
            r0.<init>(r5)
            r5 = 0
            java.util.zip.GZIPInputStream r1 = new java.util.zip.GZIPInputStream     // Catch:{ all -> 0x002b }
            r1.<init>(r0)     // Catch:{ all -> 0x002b }
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0029 }
            r2.<init>()     // Catch:{ all -> 0x0029 }
        L_0x0010:
            int r3 = r1.read()     // Catch:{ all -> 0x002d }
            r4 = -1
            if (r3 == r4) goto L_0x001b
            r2.write(r3)     // Catch:{ all -> 0x002d }
            goto L_0x0010
        L_0x001b:
            byte[] r5 = r2.toByteArray()     // Catch:{ all -> 0x002d }
            r2.close()     // Catch:{ Exception -> 0x0022 }
        L_0x0022:
            r1.close()     // Catch:{ Exception -> 0x0025 }
        L_0x0025:
            r0.close()     // Catch:{ Exception -> 0x0035 }
            goto L_0x0035
        L_0x0029:
            r2 = r5
            goto L_0x002d
        L_0x002b:
            r1 = r5
            r2 = r1
        L_0x002d:
            if (r2 == 0) goto L_0x0032
            r2.close()     // Catch:{ Exception -> 0x0032 }
        L_0x0032:
            if (r1 == 0) goto L_0x0025
            goto L_0x0022
        L_0x0035:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.b.a.b.e.d(byte[]):byte[]");
    }

    public static long e(byte[] bArr, int i) {
        return (((long) bArr[i + 7]) & 255) | ((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i + 1]) & 255) << 48) | ((((long) bArr[i + 2]) & 255) << 40) | ((((long) bArr[i + 3]) & 255) << 32) | ((((long) bArr[i + 4]) & 255) << 24) | ((((long) bArr[i + 5]) & 255) << 16) | ((((long) bArr[i + 6]) & 255) << 8);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:14|15|16|17|18|19) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0025 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0010 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] f(byte[] r3, int r4) {
        /*
            java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream
            r0.<init>(r3)
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream
            r3.<init>()
            a((java.io.InputStream) r0, (java.io.OutputStream) r3, (int) r4)     // Catch:{ all -> 0x0018 }
            r0.close()     // Catch:{ all -> 0x0010 }
        L_0x0010:
            r3.close()     // Catch:{ all -> 0x0013 }
        L_0x0013:
            byte[] r3 = r3.toByteArray()
            return r3
        L_0x0018:
            r4 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ all -> 0x0021 }
            java.lang.String r2 = "Unexpected I/O error"
            r1.<init>(r2, r4)     // Catch:{ all -> 0x0021 }
            throw r1     // Catch:{ all -> 0x0021 }
        L_0x0021:
            r4 = move-exception
            r0.close()     // Catch:{ all -> 0x0025 }
        L_0x0025:
            r3.close()     // Catch:{ all -> 0x0028 }
        L_0x0028:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.b.a.b.e.f(byte[], int):byte[]");
    }
}
