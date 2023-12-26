package com.bonree.sdk.ai;

import android.text.TextUtils;
import android.util.Log;
import com.bonree.sdk.bs.ad;
import com.bonree.sdk.common.json.HTTP;
import com.luck.picture.lib.tools.PictureFileUtils;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicBoolean;

public class b {
    private static final String a = "CrashPartsParser";
    private static int b = 100;
    private static final String d = "**br****br****br****br****br****br****br****br****br****br****br**";
    private static final String e = "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---";
    private static final String f = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
    private static final String g = "==";
    private AtomicBoolean c;

    public b(boolean z) {
        this.c = new AtomicBoolean(z);
    }

    private void a(boolean z) {
        this.c.getAndSet(z);
    }

    private boolean c(String str) {
        return str != null && this.c.get() && str.startsWith("com.bonree.sdk") && !str.contains("Instrumentation") && !str.contains("uncaughtException") && !str.contains("external") && !str.contains(".invoke(");
    }

    public final boolean a(String str) {
        return str != null && this.c.get() && str.contains("lib317844B0CDB0A833.so");
    }

    private static Throwable b(Throwable th) {
        if (th == null) {
            return null;
        }
        Throwable cause = th.getCause();
        if (cause == null || cause.getStackTrace() == null) {
            return th;
        }
        while (cause.getCause() != null && (r2 = cause.getCause().getStackTrace()) != null && r2.length != 0) {
            cause = cause.getCause();
        }
        return cause;
    }

    public final a a(Throwable th) {
        return c(th);
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0159  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.bonree.sdk.ai.a c(java.lang.Throwable r17) {
        /*
            r16 = this;
            java.lang.String r0 = "Caused by: "
            java.lang.String r1 = "\r\n"
            r2 = 0
            r3 = 0
            if (r17 != 0) goto L_0x0014
            com.bonree.sdk.be.f r0 = com.bonree.sdk.be.a.a()
            java.lang.Object[] r1 = new java.lang.Object[r3]
            java.lang.String r3 = "Crash:realParseJavaCrash-root-null"
            r0.c(r3, r1)
            return r2
        L_0x0014:
            java.lang.StringBuffer r4 = new java.lang.StringBuffer
            r4.<init>()
            java.lang.String r5 = ""
            java.lang.String r6 = "at "
            com.bonree.sdk.ai.a r7 = new com.bonree.sdk.ai.a
            r7.<init>()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0124 }
            r9.<init>(r0)     // Catch:{ Exception -> 0x0124 }
            java.lang.String r10 = r17.toString()     // Catch:{ Exception -> 0x0124 }
            r9.append(r10)     // Catch:{ Exception -> 0x0124 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0124 }
            r10 = r17
            r11 = r3
        L_0x0035:
            if (r10 == 0) goto L_0x0121
            java.lang.String r12 = "io.reactivex.exceptions.CompositeException"
            java.lang.Class r13 = r10.getClass()     // Catch:{ Exception -> 0x011d }
            java.lang.String r13 = r13.getName()     // Catch:{ Exception -> 0x011d }
            boolean r12 = r12.equals(r13)     // Catch:{ Exception -> 0x011d }
            if (r12 != 0) goto L_0x0121
            boolean r12 = com.bonree.sdk.bs.ad.a((java.lang.String) r5)     // Catch:{ Exception -> 0x011d }
            if (r12 == 0) goto L_0x008b
            java.lang.Throwable r12 = r10.getCause()     // Catch:{ Exception -> 0x011d }
            if (r12 == 0) goto L_0x007a
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x011d }
            r12.<init>()     // Catch:{ Exception -> 0x011d }
            java.lang.String r13 = r17.toString()     // Catch:{ Exception -> 0x011d }
            r12.append(r13)     // Catch:{ Exception -> 0x011d }
            r12.append(r1)     // Catch:{ Exception -> 0x011d }
            java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x011d }
            r4.append(r12)     // Catch:{ Exception -> 0x011d }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x011d }
            r12.<init>(r0)     // Catch:{ Exception -> 0x011d }
            java.lang.String r13 = r10.toString()     // Catch:{ Exception -> 0x011d }
            r12.append(r13)     // Catch:{ Exception -> 0x011d }
            java.lang.String r5 = r12.toString()     // Catch:{ Exception -> 0x011d }
            goto L_0x00ad
        L_0x007a:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x011d }
            r12.<init>(r0)     // Catch:{ Exception -> 0x011d }
            java.lang.String r13 = r10.toString()     // Catch:{ Exception -> 0x011d }
            r12.append(r13)     // Catch:{ Exception -> 0x011d }
            java.lang.String r5 = r12.toString()     // Catch:{ Exception -> 0x011d }
            goto L_0x00ad
        L_0x008b:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x011d }
            r12.<init>(r0)     // Catch:{ Exception -> 0x011d }
            java.lang.String r13 = r10.toString()     // Catch:{ Exception -> 0x011d }
            r12.append(r13)     // Catch:{ Exception -> 0x011d }
            java.lang.String r5 = r12.toString()     // Catch:{ Exception -> 0x011d }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x011d }
            r12.<init>()     // Catch:{ Exception -> 0x011d }
            r12.append(r5)     // Catch:{ Exception -> 0x011d }
            r12.append(r1)     // Catch:{ Exception -> 0x011d }
            java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x011d }
            r4.append(r12)     // Catch:{ Exception -> 0x011d }
        L_0x00ad:
            java.lang.StackTraceElement[] r12 = r10.getStackTrace()     // Catch:{ Exception -> 0x011d }
            if (r12 == 0) goto L_0x0112
            int r13 = r12.length     // Catch:{ Exception -> 0x011d }
            r14 = r3
        L_0x00b5:
            if (r14 >= r13) goto L_0x0112
            r15 = r12[r14]     // Catch:{ Exception -> 0x011d }
            r2 = 100
            if (r11 >= r2) goto L_0x0112
            java.lang.String r2 = java.lang.String.valueOf(r15)     // Catch:{ Exception -> 0x011d }
            r4.append(r6)     // Catch:{ Exception -> 0x011d }
            r4.append(r2)     // Catch:{ Exception -> 0x011d }
            r4.append(r1)     // Catch:{ Exception -> 0x011d }
            boolean r15 = r7.f     // Catch:{ Exception -> 0x011d }
            if (r15 != 0) goto L_0x010a
            if (r2 == 0) goto L_0x0104
            r15 = r16
            java.util.concurrent.atomic.AtomicBoolean r8 = r15.c     // Catch:{ Exception -> 0x011b }
            boolean r8 = r8.get()     // Catch:{ Exception -> 0x011b }
            if (r8 == 0) goto L_0x0106
            java.lang.String r8 = "com.bonree.sdk"
            boolean r8 = r2.startsWith(r8)     // Catch:{ Exception -> 0x011b }
            if (r8 == 0) goto L_0x0106
            java.lang.String r8 = "Instrumentation"
            boolean r8 = r2.contains(r8)     // Catch:{ Exception -> 0x011b }
            if (r8 != 0) goto L_0x0106
            java.lang.String r8 = "uncaughtException"
            boolean r8 = r2.contains(r8)     // Catch:{ Exception -> 0x011b }
            if (r8 != 0) goto L_0x0106
            java.lang.String r8 = "external"
            boolean r8 = r2.contains(r8)     // Catch:{ Exception -> 0x011b }
            if (r8 != 0) goto L_0x0106
            java.lang.String r8 = ".invoke("
            boolean r2 = r2.contains(r8)     // Catch:{ Exception -> 0x011b }
            if (r2 != 0) goto L_0x0106
            r2 = 1
            goto L_0x0107
        L_0x0104:
            r15 = r16
        L_0x0106:
            r2 = r3
        L_0x0107:
            r7.f = r2     // Catch:{ Exception -> 0x011b }
            goto L_0x010c
        L_0x010a:
            r15 = r16
        L_0x010c:
            int r11 = r11 + 1
            int r14 = r14 + 1
            r2 = 0
            goto L_0x00b5
        L_0x0112:
            r15 = r16
            java.lang.Throwable r10 = r10.getCause()     // Catch:{ Exception -> 0x011b }
            r2 = 0
            goto L_0x0035
        L_0x011b:
            r0 = move-exception
            goto L_0x0128
        L_0x011d:
            r0 = move-exception
            r15 = r16
            goto L_0x0128
        L_0x0121:
            r15 = r16
            goto L_0x013b
        L_0x0124:
            r0 = move-exception
            r15 = r16
            r9 = 0
        L_0x0128:
            com.bonree.sdk.be.f r2 = com.bonree.sdk.be.a.a()
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]
            java.lang.String r8 = "realParseJavaCrash"
            r6[r3] = r8
            r8 = 1
            r6[r8] = r0
            java.lang.String r0 = "CrashPartsParser"
            r2.e(r0, r6)
        L_0x013b:
            boolean r0 = com.bonree.sdk.bs.ad.a((java.lang.String) r5)
            if (r0 == 0) goto L_0x014a
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            if (r0 == 0) goto L_0x0149
            r2 = 0
            return r2
        L_0x0149:
            r5 = r9
        L_0x014a:
            java.lang.String r0 = ":"
            java.lang.String[] r0 = r5.split(r0)
            int r2 = r0.length
            r6 = 1
            if (r2 <= r6) goto L_0x0159
            r0 = r0[r6]
            r7.a = r0
            goto L_0x015b
        L_0x0159:
            r7.a = r5
        L_0x015b:
            r7.c = r5
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r5)
            r0.append(r1)
            java.lang.String r1 = r4.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r7.b = r0
            java.lang.String r0 = r7.b
            boolean r0 = com.bonree.sdk.bs.ad.c((java.lang.String) r0)
            if (r0 == 0) goto L_0x018f
            java.lang.String r0 = r7.b
            int r0 = r0.length()
            r1 = 10000(0x2710, float:1.4013E-41)
            if (r0 <= r1) goto L_0x018f
            java.lang.String r0 = r7.b
            java.lang.String r0 = r0.substring(r3, r1)
            r7.b = r0
        L_0x018f:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.ai.b.c(java.lang.Throwable):com.bonree.sdk.ai.a");
    }

    public final a a(String str, int i) {
        String str2 = null;
        if (ad.a(str) || i <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        a aVar = new a();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str)), PictureFileUtils.KB);
            int i2 = 0;
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                } else if (d.equals(readLine)) {
                    i2++;
                } else {
                    aVar.f = a(readLine);
                    if (i2 == 1) {
                        if (readLine.contains("signal ") && readLine.contains("(")) {
                            str2 = readLine.substring(0, readLine.indexOf("("));
                        }
                        sb.append(readLine);
                        sb.append(HTTP.CRLF);
                    } else if (i2 == 2) {
                        sb2.append(readLine);
                        sb2.append(HTTP.CRLF);
                    } else if (i2 == 4 && !HTTP.CRLF.equals(readLine)) {
                        sb3.append(readLine);
                        sb3.append(HTTP.CRLF);
                    }
                }
            }
        } catch (Exception unused) {
        }
        aVar.b = sb.toString();
        if (!TextUtils.isEmpty(str2)) {
            aVar.a = "signal";
            aVar.c = "Caused by: Application received " + str2;
        } else if (!TextUtils.isEmpty(aVar.b)) {
            aVar.c = "Caused by: Application native crash";
        }
        aVar.d = sb3.toString();
        aVar.e = sb2.toString();
        return aVar;
    }

    private static String d(String str) {
        int lastIndexOf = str.lastIndexOf("logcat:");
        int indexOf = str.indexOf(e, lastIndexOf + 1);
        if (lastIndexOf == -1 || indexOf == -1) {
            return null;
        }
        return str.substring(lastIndexOf + 7, indexOf);
    }

    public static String b(String str) {
        try {
            int indexOf = str.indexOf("pid:");
            if (indexOf == -1) {
                Log.e(a, "parseNativeCrashDump: null");
                return null;
            }
            while (true) {
                if (indexOf == -1) {
                    break;
                }
                int indexOf2 = str.indexOf("tid:", indexOf);
                int indexOf3 = str.indexOf("name:", indexOf);
                int indexOf4 = str.indexOf(">>>", indexOf);
                int indexOf5 = str.indexOf("backtrace:", indexOf);
                int indexOf6 = str.indexOf("backtrace-end:", indexOf);
                int indexOf7 = str.indexOf("pid:", indexOf + 1);
                if (indexOf3 == -1 || indexOf4 == -1 || indexOf5 == -1) {
                    break;
                } else if (indexOf6 == -1) {
                    break;
                } else {
                    if (indexOf2 - indexOf <= 15 && indexOf3 - indexOf2 <= 15 && indexOf4 - indexOf3 <= 25) {
                        if (indexOf7 != -1) {
                            if (indexOf4 <= indexOf7 && indexOf5 <= indexOf7) {
                                if (indexOf6 > indexOf7) {
                                }
                            }
                        }
                        String substring = str.substring(indexOf + 5, indexOf2 - 2);
                        String substring2 = str.substring(indexOf2 + 5, indexOf3 - 2);
                        if (!ad.a(substring) && substring.equals(substring2)) {
                            return b(str.substring(indexOf5 + 10, indexOf6), 100);
                        }
                        indexOf = indexOf7;
                    }
                    Log.e(a, "parseNativeCrashDump: continue");
                    indexOf = indexOf7;
                }
            }
            Log.e(a, "parseNativeCrashDump: break");
            return null;
        } catch (Exception unused) {
        }
    }

    private static String b(String str, int i) {
        if (ad.a(str)) {
            return null;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
        InputStreamReader inputStreamReader = new InputStreamReader(byteArrayInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuilder sb = new StringBuilder();
        int i2 = 1;
        while (i2 <= 100) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
                sb.append(HTTP.CRLF);
                i2++;
            } catch (IOException unused) {
                ad.a(bufferedReader, inputStreamReader, byteArrayInputStream);
                return null;
            } catch (Throwable th) {
                ad.a(bufferedReader, inputStreamReader, byteArrayInputStream);
                throw th;
            }
        }
        if (i2 > 1) {
            sb.delete(sb.length() - 2, sb.length());
        }
        String sb2 = sb.toString();
        ad.a(bufferedReader, inputStreamReader, byteArrayInputStream);
        return sb2;
    }

    private b() {
    }

    public static String a(byte[] bArr) {
        int length = (3 - (bArr.length % 3)) % 3;
        byte[] bArr2 = new byte[(bArr.length + length)];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bArr.length; i += 3) {
            int i2 = ((bArr2[i] & 255) << 16) + ((bArr2[i + 1] & 255) << 8) + (bArr2[i + 2] & 255);
            sb.append(f.charAt((i2 >> 18) & 63));
            sb.append(f.charAt((i2 >> 12) & 63));
            sb.append(f.charAt((i2 >> 6) & 63));
            sb.append(f.charAt(i2 & 63));
        }
        return sb.substring(0, sb.length() - length) + g.substring(0, length);
    }
}
