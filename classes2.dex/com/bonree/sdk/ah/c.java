package com.bonree.sdk.ah;

public class c {
    private static final String e = "0123456789ABCDEFGHIJKLMNOPQRSTUV";
    private static final String f = "======";
    public String a;
    public int b;
    public String c;
    private int d;

    public c(String str, int i, int i2, String str2) {
        this.a = str;
        this.d = i;
        this.b = i2;
        this.c = str2;
    }

    public final String toString() {
        return "NativeCrashCallBackData{" + "path='" + this.a + "', pid=" + this.d + ", tid=" + this.b + ", threadName='" + this.c + "'}";
    }

    private c() {
    }

    public static String a(byte[] bArr) {
        int length = ((int) (8.0d - (((double) (bArr.length % 5)) * 1.6d))) % 8;
        byte[] bArr2 = new byte[(bArr.length + length)];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bArr.length; i += 5) {
            long j = (((long) (bArr2[i] & 255)) << 32) + (((long) (bArr2[i + 1] & 255)) << 24) + ((long) ((bArr2[i + 2] & 255) << 16)) + ((long) ((bArr2[i + 3] & 255) << 8)) + ((long) (bArr2[i + 4] & 255));
            sb.append(e.charAt((int) ((j >> 35) & 31)));
            sb.append(e.charAt((int) ((j >> 30) & 31)));
            sb.append(e.charAt((int) ((j >> 25) & 31)));
            sb.append(e.charAt((int) ((j >> 20) & 31)));
            sb.append(e.charAt((int) ((j >> 15) & 31)));
            sb.append(e.charAt((int) ((j >> 10) & 31)));
            sb.append(e.charAt((int) ((j >> 5) & 31)));
            sb.append(e.charAt((int) (j & 31)));
        }
        return sb.substring(0, sb.length() - length) + f.substring(0, length);
    }
}
