package com.bonree.sdk.bs;

public final class r {
    public static final String a = "Content-Type".toLowerCase();
    private static String[] b = {"get", "post", "head", "put", "delete", "trace", "option", "connect", "patch"};
    private static String c = "\r\n";
    private static String d = "\n";
    private static String e = "\\s+";
    private static String f = ":";
    private static String g = "Content-Length";
    private static String h = "cl:";
    private static String i = "Transfer-Encoding";
    private static String j = "chunked";
    private static String k = "Trailer";
    private static String l = "Connection";
    private static String m = "close";
    private static String n = "Host";
    private static String o = "Upgrade";
    private static String p = "User-Agent";
    private static String q = "Content-Type";
    private static byte[] r = null;
    private static byte[] s = null;
    private static String t = "HTTP/";
    private static String u = "http/";
    private static int v = 200;
    private static int w = 101;

    private static byte a(byte b2) {
        return (b2 < 65 || b2 > 90) ? b2 : (byte) (b2 | 32);
    }

    private static int a(String str) {
        String str2;
        if (str == null || str.trim().length() == 0) {
            return 0;
        }
        while (true) {
            try {
                int indexOf = str.indexOf("HTTP/");
                if (indexOf == -1) {
                    indexOf = str.indexOf("http/");
                }
                if (indexOf < 0) {
                    break;
                }
                str = str.substring(str.indexOf(32)).trim();
            } catch (Throwable unused) {
                return 0;
            }
        }
        String trim = str.trim();
        int indexOf2 = trim.indexOf(10);
        if (indexOf2 != -1) {
            trim = trim.substring(0, indexOf2);
        }
        int indexOf3 = trim.indexOf(32);
        if (indexOf3 != -1) {
            str2 = trim.substring(0, indexOf3);
        } else {
            str2 = trim.trim();
        }
        int parseInt = Integer.parseInt(str2);
        if (parseInt >= 600) {
            return 0;
        }
        return parseInt;
    }

    private static String b(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[10];
        int i2 = 0;
        for (byte b2 : bArr) {
            if (b2 != 32 && b2 != 9) {
                bArr2[i2] = b2;
                i2++;
                if (i2 >= 10) {
                    break;
                }
            } else if (i2 > 0) {
                break;
            }
        }
        if (i2 <= 0) {
            return null;
        }
        byte[] bArr3 = new byte[i2];
        System.arraycopy(bArr, 0, bArr3, 0, i2);
        return new String(bArr3);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0034  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(byte[] r9) {
        /*
            r0 = 9
            r1 = 0
            if (r9 == 0) goto L_0x0031
            r2 = 10
            byte[] r3 = new byte[r2]
            int r4 = r9.length
            r5 = r1
            r6 = r5
        L_0x000c:
            if (r5 >= r4) goto L_0x0024
            byte r7 = r9[r5]
            r8 = 32
            if (r7 == r8) goto L_0x001e
            if (r7 != r0) goto L_0x0017
            goto L_0x001e
        L_0x0017:
            r3[r6] = r7
            int r6 = r6 + 1
            if (r6 >= r2) goto L_0x0024
            goto L_0x0021
        L_0x001e:
            if (r6 <= 0) goto L_0x0021
            goto L_0x0024
        L_0x0021:
            int r5 = r5 + 1
            goto L_0x000c
        L_0x0024:
            if (r6 <= 0) goto L_0x0031
            byte[] r2 = new byte[r6]
            java.lang.System.arraycopy(r9, r1, r2, r1, r6)
            java.lang.String r9 = new java.lang.String
            r9.<init>(r2)
            goto L_0x0032
        L_0x0031:
            r9 = 0
        L_0x0032:
            if (r9 == 0) goto L_0x004a
            java.lang.String r9 = r9.toLowerCase()
            java.lang.String[] r2 = b
            r3 = r1
        L_0x003b:
            if (r3 >= r0) goto L_0x004a
            r4 = r2[r3]
            boolean r4 = r9.equals(r4)
            if (r4 == 0) goto L_0x0047
            r9 = 1
            return r9
        L_0x0047:
            int r3 = r3 + 1
            goto L_0x003b
        L_0x004a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.bs.r.a(byte[]):boolean");
    }
}
