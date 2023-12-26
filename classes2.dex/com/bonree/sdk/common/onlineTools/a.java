package com.bonree.sdk.common.onlineTools;

import com.bonree.sdk.agent.business.entity.NetworkCustomEventBean;
import com.bonree.sdk.agent.business.util.k;
import com.bonree.sdk.agent.engine.external.HttpFilterInstrumentation;
import com.bonree.sdk.be.f;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

public class a {
    private static final String a = "a";
    private f b = com.bonree.sdk.be.a.a();

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: java.io.InputStream} */
    /* JADX WARNING: type inference failed for: r4v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0107 A[SYNTHETIC, Splitter:B:75:0x0107] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x010f A[Catch:{ all -> 0x010b }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0114 A[Catch:{ all -> 0x010b }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0119 A[Catch:{ all -> 0x010b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a(java.io.File r13, java.lang.String r14) {
        /*
            r12 = this;
            r0 = 1
            r1 = 0
            r2 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ all -> 0x00cf }
            r3.<init>(r13)     // Catch:{ all -> 0x00cf }
            java.lang.String r13 = "http://"
            boolean r13 = r14.startsWith(r13)     // Catch:{ all -> 0x00cf }
            r4 = 5000(0x1388, float:7.006E-42)
            java.net.URLConnection r4 = a(r14, r13, r4)     // Catch:{ all -> 0x00c9 }
            r4.connect()     // Catch:{ all -> 0x00c3 }
            java.io.OutputStream r5 = r4.getOutputStream()     // Catch:{ all -> 0x00c3 }
            r6 = 10240(0x2800, float:1.4349E-41)
            byte[] r6 = new byte[r6]     // Catch:{ all -> 0x00bf }
        L_0x001f:
            int r7 = r3.read(r6)     // Catch:{ all -> 0x00bf }
            r8 = -1
            if (r7 == r8) goto L_0x002a
            r5.write(r6, r2, r7)     // Catch:{ all -> 0x00bf }
            goto L_0x001f
        L_0x002a:
            r3.close()     // Catch:{ all -> 0x00bf }
            r5.flush()     // Catch:{ all -> 0x00bf }
            if (r13 == 0) goto L_0x0039
            r3 = r4
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch:{ all -> 0x00bf }
            r3.getResponseCode()     // Catch:{ all -> 0x00bf }
            goto L_0x003f
        L_0x0039:
            r3 = r4
            javax.net.ssl.HttpsURLConnection r3 = (javax.net.ssl.HttpsURLConnection) r3     // Catch:{ all -> 0x00bf }
            r3.getResponseCode()     // Catch:{ all -> 0x00bf }
        L_0x003f:
            java.io.InputStream r3 = r4.getInputStream()     // Catch:{ IOException -> 0x0044 }
            goto L_0x0045
        L_0x0044:
            r3 = r1
        L_0x0045:
            if (r3 == 0) goto L_0x0096
            java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x008e }
            r6.<init>()     // Catch:{ all -> 0x008e }
            r7 = 512(0x200, float:7.175E-43)
            byte[] r7 = new byte[r7]     // Catch:{ all -> 0x0088 }
        L_0x0050:
            int r9 = r3.read(r7)     // Catch:{ all -> 0x0088 }
            if (r9 == r8) goto L_0x005a
            r6.write(r7, r2, r9)     // Catch:{ all -> 0x0088 }
            goto L_0x0050
        L_0x005a:
            java.lang.String r14 = r6.toString()     // Catch:{ all -> 0x0088 }
            r6.close()     // Catch:{ all -> 0x007b }
            if (r3 == 0) goto L_0x0066
            r3.close()     // Catch:{ all -> 0x007b }
        L_0x0066:
            if (r5 == 0) goto L_0x006b
            r5.close()     // Catch:{ all -> 0x007b }
        L_0x006b:
            if (r4 == 0) goto L_0x0087
            if (r13 == 0) goto L_0x0075
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch:{ all -> 0x007b }
            r4.disconnect()     // Catch:{ all -> 0x007b }
            goto L_0x0087
        L_0x0075:
            javax.net.ssl.HttpsURLConnection r4 = (javax.net.ssl.HttpsURLConnection) r4     // Catch:{ all -> 0x007b }
            r4.disconnect()     // Catch:{ all -> 0x007b }
            goto L_0x0087
        L_0x007b:
            r13 = move-exception
            com.bonree.sdk.be.f r1 = r12.b
            java.lang.String r3 = a
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r2] = r13
            r1.c(r3, r0)
        L_0x0087:
            return r14
        L_0x0088:
            r7 = move-exception
            r11 = r4
            r4 = r3
            r3 = r7
            r7 = r6
            goto L_0x0093
        L_0x008e:
            r6 = move-exception
            r7 = r1
            r11 = r4
            r4 = r3
            r3 = r6
        L_0x0093:
            r6 = r5
            r5 = r11
            goto L_0x00d5
        L_0x0096:
            if (r3 == 0) goto L_0x009e
            r3.close()     // Catch:{ all -> 0x009c }
            goto L_0x009e
        L_0x009c:
            r13 = move-exception
            goto L_0x00b3
        L_0x009e:
            if (r5 == 0) goto L_0x00a3
            r5.close()     // Catch:{ all -> 0x009c }
        L_0x00a3:
            if (r4 == 0) goto L_0x00be
            if (r13 == 0) goto L_0x00ad
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch:{ all -> 0x009c }
            r4.disconnect()     // Catch:{ all -> 0x009c }
            goto L_0x00be
        L_0x00ad:
            javax.net.ssl.HttpsURLConnection r4 = (javax.net.ssl.HttpsURLConnection) r4     // Catch:{ all -> 0x009c }
            r4.disconnect()     // Catch:{ all -> 0x009c }
            goto L_0x00be
        L_0x00b3:
            com.bonree.sdk.be.f r14 = r12.b
            java.lang.String r3 = a
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r2] = r13
            r14.c(r3, r0)
        L_0x00be:
            return r1
        L_0x00bf:
            r3 = move-exception
            r7 = r1
            r6 = r5
            goto L_0x00c6
        L_0x00c3:
            r3 = move-exception
            r6 = r1
            r7 = r6
        L_0x00c6:
            r5 = r4
            r4 = r7
            goto L_0x00d5
        L_0x00c9:
            r3 = move-exception
            r4 = r1
            r5 = r4
            r6 = r5
            r7 = r6
            goto L_0x00d5
        L_0x00cf:
            r3 = move-exception
            r4 = r1
            r5 = r4
            r6 = r5
            r7 = r6
            r13 = r2
        L_0x00d5:
            com.bonree.sdk.be.f r8 = com.bonree.sdk.be.a.a()     // Catch:{ all -> 0x0133 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0133 }
            r9.<init>()     // Catch:{ all -> 0x0133 }
            java.lang.String r10 = a     // Catch:{ all -> 0x0133 }
            r9.append(r10)     // Catch:{ all -> 0x0133 }
            java.lang.String r10 = " URL: "
            r9.append(r10)     // Catch:{ all -> 0x0133 }
            r9.append(r14)     // Catch:{ all -> 0x0133 }
            java.lang.String r14 = "    timeOut:5000"
            r9.append(r14)     // Catch:{ all -> 0x0133 }
            java.lang.String r14 = "\r\n"
            r9.append(r14)     // Catch:{ all -> 0x0133 }
            java.lang.String r14 = r3.toString()     // Catch:{ all -> 0x0133 }
            r9.append(r14)     // Catch:{ all -> 0x0133 }
            java.lang.String r14 = r9.toString()     // Catch:{ all -> 0x0133 }
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ all -> 0x0133 }
            r8.e(r14, r3)     // Catch:{ all -> 0x0133 }
            if (r7 == 0) goto L_0x010d
            r7.close()     // Catch:{ all -> 0x010b }
            goto L_0x010d
        L_0x010b:
            r13 = move-exception
            goto L_0x0127
        L_0x010d:
            if (r4 == 0) goto L_0x0112
            r4.close()     // Catch:{ all -> 0x010b }
        L_0x0112:
            if (r6 == 0) goto L_0x0117
            r6.close()     // Catch:{ all -> 0x010b }
        L_0x0117:
            if (r5 == 0) goto L_0x0132
            if (r13 == 0) goto L_0x0121
            java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch:{ all -> 0x010b }
            r5.disconnect()     // Catch:{ all -> 0x010b }
            goto L_0x0132
        L_0x0121:
            javax.net.ssl.HttpsURLConnection r5 = (javax.net.ssl.HttpsURLConnection) r5     // Catch:{ all -> 0x010b }
            r5.disconnect()     // Catch:{ all -> 0x010b }
            goto L_0x0132
        L_0x0127:
            com.bonree.sdk.be.f r14 = r12.b
            java.lang.String r3 = a
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r2] = r13
            r14.c(r3, r0)
        L_0x0132:
            return r1
        L_0x0133:
            r14 = move-exception
            if (r7 == 0) goto L_0x013c
            r7.close()     // Catch:{ all -> 0x013a }
            goto L_0x013c
        L_0x013a:
            r13 = move-exception
            goto L_0x0156
        L_0x013c:
            if (r4 == 0) goto L_0x0141
            r4.close()     // Catch:{ all -> 0x013a }
        L_0x0141:
            if (r6 == 0) goto L_0x0146
            r6.close()     // Catch:{ all -> 0x013a }
        L_0x0146:
            if (r5 == 0) goto L_0x0161
            if (r13 == 0) goto L_0x0150
            java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch:{ all -> 0x013a }
            r5.disconnect()     // Catch:{ all -> 0x013a }
            goto L_0x0161
        L_0x0150:
            javax.net.ssl.HttpsURLConnection r5 = (javax.net.ssl.HttpsURLConnection) r5     // Catch:{ all -> 0x013a }
            r5.disconnect()     // Catch:{ all -> 0x013a }
            goto L_0x0161
        L_0x0156:
            com.bonree.sdk.be.f r1 = r12.b
            java.lang.String r3 = a
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r2] = r13
            r1.c(r3, r0)
        L_0x0161:
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.common.onlineTools.a.a(java.io.File, java.lang.String):java.lang.String");
    }

    private static URLConnection a(String str, boolean z, int i) {
        URLConnection uRLConnection = null;
        try {
            uRLConnection = HttpFilterInstrumentation.openConnectionFilter(new URL(str).openConnection());
            uRLConnection.setDoInput(true);
            uRLConnection.setDoOutput(true);
            if (z) {
                ((HttpURLConnection) uRLConnection).setRequestMethod(NetworkCustomEventBean.HttpMethod.POST.value());
            } else {
                ((HttpsURLConnection) uRLConnection).setHostnameVerifier(k.b().a());
                ((HttpsURLConnection) uRLConnection).setRequestMethod(NetworkCustomEventBean.HttpMethod.POST.value());
            }
            uRLConnection.setConnectTimeout(5000);
            uRLConnection.setReadTimeout(5000);
        } catch (Throwable th) {
            com.bonree.sdk.be.a.a().a(a, th);
        }
        return uRLConnection;
    }
}
