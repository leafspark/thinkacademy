package com.bonree.sdk.common.onlineTools;

import com.bonree.sdk.agent.business.entity.NetworkCustomEventBean;
import com.bonree.sdk.agent.business.util.k;
import com.bonree.sdk.agent.engine.external.HttpFilterInstrumentation;
import com.bonree.sdk.be.a;
import com.bonree.sdk.be.f;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

public class b {
    private static final String a = "b";
    private static String b = "Content-Type";
    private static final int d = 1000;
    private static final int e = 999;
    private f c = a.a();

    /* JADX WARNING: Removed duplicated region for block: B:110:0x023b A[SYNTHETIC, Splitter:B:110:0x023b] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0245 A[Catch:{ all -> 0x023f }] */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x024a A[Catch:{ all -> 0x023f }] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x024f A[Catch:{ all -> 0x023f }] */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x02ca A[SYNTHETIC, Splitter:B:135:0x02ca] */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x02d2 A[Catch:{ all -> 0x02ce }] */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x02d7 A[Catch:{ all -> 0x02ce }] */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x02dc A[Catch:{ all -> 0x02ce }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.bonree.sdk.agent.business.entity.instruction.HTTPInstructionResultBean a(java.lang.String r24, java.lang.String r25, java.lang.String r26, java.util.Map<java.lang.String, java.lang.Object> r27, int r28, int r29) {
        /*
            r23 = this;
            r1 = r23
            r2 = r24
            r0 = r25
            r3 = r26
            r4 = r29
            com.bonree.sdk.agent.business.entity.instruction.HTTPInstructionResultBean r5 = new com.bonree.sdk.agent.business.entity.instruction.HTTPInstructionResultBean
            r5.<init>()
            r5.setRequestUrl(r2)
            r5.setMethod(r0)
            boolean r6 = android.text.TextUtils.isEmpty(r26)
            if (r6 != 0) goto L_0x001e
            r5.setRequestBody(r3)
        L_0x001e:
            if (r27 == 0) goto L_0x002b
            java.util.Map r6 = com.bonree.sdk.bs.u.e((java.util.Map<java.lang.String, java.lang.Object>) r27)
            java.lang.String r6 = com.bonree.sdk.bs.ad.d((java.util.Map<java.lang.String, java.lang.Object>) r6)
            r5.setRequestHeader(r6)
        L_0x002b:
            r7 = 1
            r8 = 0
            java.lang.String r9 = "http://"
            boolean r9 = r2.startsWith(r9)     // Catch:{ all -> 0x0274 }
            r10 = 120(0x78, float:1.68E-43)
            r11 = r28
            if (r11 <= r10) goto L_0x003a
            goto L_0x003b
        L_0x003a:
            r10 = r11
        L_0x003b:
            java.net.URL r11 = new java.net.URL     // Catch:{ all -> 0x0270 }
            r11.<init>(r2)     // Catch:{ all -> 0x0270 }
            java.net.URLConnection r11 = r11.openConnection()     // Catch:{ all -> 0x0270 }
            java.net.URLConnection r11 = com.bonree.sdk.agent.engine.external.HttpFilterInstrumentation.openConnectionFilter(r11)     // Catch:{ all -> 0x0270 }
            com.bonree.sdk.agent.business.entity.NetworkCustomEventBean$HttpMethod r12 = com.bonree.sdk.agent.business.entity.NetworkCustomEventBean.HttpMethod.POST     // Catch:{ all -> 0x0270 }
            java.lang.String r12 = r12.value()     // Catch:{ all -> 0x0270 }
            boolean r12 = r12.equals(r0)     // Catch:{ all -> 0x0270 }
            if (r12 == 0) goto L_0x005a
            r11.setDoInput(r7)     // Catch:{ all -> 0x0270 }
            r11.setDoOutput(r7)     // Catch:{ all -> 0x0270 }
        L_0x005a:
            if (r9 == 0) goto L_0x0063
            r12 = r11
            java.net.HttpURLConnection r12 = (java.net.HttpURLConnection) r12     // Catch:{ all -> 0x0270 }
            r12.setRequestMethod(r0)     // Catch:{ all -> 0x0270 }
            goto L_0x0077
        L_0x0063:
            r12 = r11
            javax.net.ssl.HttpsURLConnection r12 = (javax.net.ssl.HttpsURLConnection) r12     // Catch:{ all -> 0x0270 }
            com.bonree.sdk.agent.business.util.k r13 = com.bonree.sdk.agent.business.util.k.b()     // Catch:{ all -> 0x0270 }
            javax.net.ssl.HostnameVerifier r13 = r13.a()     // Catch:{ all -> 0x0270 }
            r12.setHostnameVerifier(r13)     // Catch:{ all -> 0x0270 }
            r12 = r11
            javax.net.ssl.HttpsURLConnection r12 = (javax.net.ssl.HttpsURLConnection) r12     // Catch:{ all -> 0x0270 }
            r12.setRequestMethod(r0)     // Catch:{ all -> 0x0270 }
        L_0x0077:
            if (r10 <= 0) goto L_0x0081
            int r0 = r10 * 1000
            r11.setConnectTimeout(r0)     // Catch:{ all -> 0x0270 }
            r11.setReadTimeout(r0)     // Catch:{ all -> 0x0270 }
        L_0x0081:
            if (r27 == 0) goto L_0x00b4
            int r0 = r27.size()     // Catch:{ all -> 0x00af }
            if (r0 <= 0) goto L_0x00b4
            java.util.Set r0 = r27.entrySet()     // Catch:{ all -> 0x00af }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x00af }
        L_0x0091:
            boolean r12 = r0.hasNext()     // Catch:{ all -> 0x00af }
            if (r12 == 0) goto L_0x00b4
            java.lang.Object r12 = r0.next()     // Catch:{ all -> 0x00af }
            java.util.Map$Entry r12 = (java.util.Map.Entry) r12     // Catch:{ all -> 0x00af }
            java.lang.Object r13 = r12.getKey()     // Catch:{ all -> 0x00af }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ all -> 0x00af }
            java.lang.Object r12 = r12.getValue()     // Catch:{ all -> 0x00af }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x00af }
            r11.setRequestProperty(r13, r12)     // Catch:{ all -> 0x00af }
            goto L_0x0091
        L_0x00af:
            r0 = move-exception
            r6 = r11
            r3 = 0
            goto L_0x027b
        L_0x00b4:
            java.net.URL r0 = new java.net.URL     // Catch:{ MalformedURLException -> 0x00c2 }
            r0.<init>(r2)     // Catch:{ MalformedURLException -> 0x00c2 }
            java.lang.String r0 = r0.getHost()     // Catch:{ MalformedURLException -> 0x00c2 }
            int r0 = com.bonree.sdk.bs.u.g(r0)     // Catch:{ MalformedURLException -> 0x00c2 }
            goto L_0x00c3
        L_0x00c2:
            r0 = r8
        L_0x00c3:
            int r0 = r0 * 1000
            r12 = 999(0x3e7, float:1.4E-42)
            int r0 = java.lang.Math.max(r0, r12)     // Catch:{ all -> 0x00af }
            long r12 = (long) r0     // Catch:{ all -> 0x00af }
            r5.setDnsTime(r12)     // Catch:{ all -> 0x00af }
            long r12 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x00af }
            r11.connect()     // Catch:{ all -> 0x00af }
            if (r9 == 0) goto L_0x00e0
            r0 = r11
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ all -> 0x00af }
            int r0 = r0.getResponseCode()     // Catch:{ all -> 0x00af }
            goto L_0x00e7
        L_0x00e0:
            r0 = r11
            javax.net.ssl.HttpsURLConnection r0 = (javax.net.ssl.HttpsURLConnection) r0     // Catch:{ all -> 0x00af }
            int r0 = r0.getResponseCode()     // Catch:{ all -> 0x00af }
        L_0x00e7:
            long r14 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x00af }
            long r14 = r14 - r12
            long r12 = r14 << r7
            r16 = 7
            long r12 = r12 / r16
            long r16 = r14 - r12
            r18 = 1000(0x3e8, double:4.94E-321)
            long r12 = r12 * r18
            r6 = 999(0x3e7, double:4.936E-321)
            long r12 = java.lang.Math.max(r12, r6)     // Catch:{ all -> 0x00af }
            r5.setConnectTime(r12)     // Catch:{ all -> 0x00af }
            long r12 = r16 * r18
            long r12 = java.lang.Math.max(r12, r6)     // Catch:{ all -> 0x00af }
            r5.setSslTime(r12)     // Catch:{ all -> 0x00af }
            if (r3 == 0) goto L_0x012c
            long r12 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x00af }
            java.io.OutputStream r14 = r11.getOutputStream()     // Catch:{ all -> 0x00af }
            byte[] r3 = r26.getBytes()     // Catch:{ all -> 0x0127 }
            r14.write(r3)     // Catch:{ all -> 0x0127 }
            r14.flush()     // Catch:{ all -> 0x0127 }
            long r15 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x0127 }
            long r12 = r15 - r12
            r3 = r14
            r14 = r12
            goto L_0x012d
        L_0x0127:
            r0 = move-exception
            r6 = r11
            r3 = r14
            goto L_0x027b
        L_0x012c:
            r3 = 0
        L_0x012d:
            long r14 = r14 * r18
            long r12 = java.lang.Math.max(r14, r6)     // Catch:{ all -> 0x026d }
            r5.setRequestTime(r12)     // Catch:{ all -> 0x026d }
            r12 = 400(0x190, float:5.6E-43)
            if (r12 > r0) goto L_0x015e
            r12 = 600(0x258, float:8.41E-43)
            if (r0 > r12) goto L_0x015e
            java.lang.String r12 = "http"
            r5.setErrorPlatform(r12)     // Catch:{ all -> 0x026d }
            r12 = 4
            r5.setErrorOccurrentProcess(r12)     // Catch:{ all -> 0x026d }
            if (r9 == 0) goto L_0x0154
            r12 = r11
            java.net.HttpURLConnection r12 = (java.net.HttpURLConnection) r12     // Catch:{ all -> 0x026d }
            java.lang.String r12 = r12.getResponseMessage()     // Catch:{ all -> 0x026d }
            r5.setErrorMsg(r12)     // Catch:{ all -> 0x026d }
            goto L_0x015e
        L_0x0154:
            r12 = r11
            javax.net.ssl.HttpsURLConnection r12 = (javax.net.ssl.HttpsURLConnection) r12     // Catch:{ all -> 0x026d }
            java.lang.String r12 = r12.getResponseMessage()     // Catch:{ all -> 0x026d }
            r5.setErrorMsg(r12)     // Catch:{ all -> 0x026d }
        L_0x015e:
            r12 = r11
            java.net.HttpURLConnection r12 = (java.net.HttpURLConnection) r12     // Catch:{ all -> 0x026d }
            java.lang.String r12 = r12.getRequestMethod()     // Catch:{ all -> 0x026d }
            r5.setMethod(r12)     // Catch:{ all -> 0x026d }
            long r12 = (long) r0     // Catch:{ all -> 0x026d }
            r5.setErrorCode(r12)     // Catch:{ all -> 0x026d }
            java.util.Map r0 = r11.getHeaderFields()     // Catch:{ all -> 0x026d }
            com.bonree.sdk.bs.u$a r0 = com.bonree.sdk.bs.u.f((java.util.Map<java.lang.String, java.util.List<java.lang.String>>) r0)     // Catch:{ all -> 0x026d }
            java.lang.String r12 = r0.a     // Catch:{ all -> 0x026d }
            boolean r12 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x026d }
            if (r12 != 0) goto L_0x0181
            java.lang.String r0 = r0.a     // Catch:{ all -> 0x026d }
            r5.setResponseHeader(r0)     // Catch:{ all -> 0x026d }
        L_0x0181:
            java.io.InputStream r0 = r11.getInputStream()     // Catch:{ IOException -> 0x0187 }
            r12 = r0
            goto L_0x0188
        L_0x0187:
            r12 = 0
        L_0x0188:
            if (r12 != 0) goto L_0x019a
            r0 = r11
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ Exception -> 0x019a }
            java.io.InputStream r0 = r0.getErrorStream()     // Catch:{ Exception -> 0x019a }
            r12 = r0
            goto L_0x019a
        L_0x0193:
            r0 = move-exception
        L_0x0194:
            r6 = r11
            r20 = r12
            r13 = 0
            goto L_0x027e
        L_0x019a:
            if (r12 == 0) goto L_0x0238
            int r0 = r11.getContentLength()     // Catch:{ all -> 0x0233 }
            if (r0 > 0) goto L_0x01c0
            java.util.Map r13 = r11.getHeaderFields()     // Catch:{ all -> 0x0193 }
            java.lang.String r14 = "Content-Length"
            java.lang.Object r13 = r13.get(r14)     // Catch:{ all -> 0x0193 }
            java.util.List r13 = (java.util.List) r13     // Catch:{ all -> 0x0193 }
            if (r13 == 0) goto L_0x01c0
            int r14 = r13.size()     // Catch:{ all -> 0x0193 }
            if (r14 <= 0) goto L_0x01c0
            java.lang.Object r0 = r13.get(r8)     // Catch:{ all -> 0x0193 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0193 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ all -> 0x0193 }
        L_0x01c0:
            if (r0 >= r4) goto L_0x022e
            java.io.ByteArrayOutputStream r13 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0233 }
            r13.<init>()     // Catch:{ all -> 0x0233 }
            r0 = 512(0x200, float:7.175E-43)
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x0227 }
            long r14 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x0227 }
        L_0x01cf:
            int r8 = r12.read(r0)     // Catch:{ all -> 0x0227 }
            r6 = -1
            if (r8 == r6) goto L_0x01fb
            long r6 = r5.getResponseTime()     // Catch:{ all -> 0x0227 }
            r21 = 0
            int r6 = (r6 > r21 ? 1 : (r6 == r21 ? 0 : -1))
            if (r6 > 0) goto L_0x01f0
            long r6 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x0227 }
            long r6 = r6 - r14
            long r6 = r6 * r18
            r1 = 999(0x3e7, double:4.936E-321)
            long r6 = java.lang.Math.max(r6, r1)     // Catch:{ all -> 0x0227 }
            r5.setResponseTime(r6)     // Catch:{ all -> 0x0227 }
        L_0x01f0:
            r1 = 0
            r13.write(r0, r1, r8)     // Catch:{ all -> 0x0227 }
            r6 = 999(0x3e7, double:4.936E-321)
            r1 = r23
            r2 = r24
            goto L_0x01cf
        L_0x01fb:
            long r0 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x0227 }
            long r0 = r0 - r14
            long r0 = r0 * r18
            r6 = 999(0x3e7, double:4.936E-321)
            long r0 = java.lang.Math.max(r0, r6)     // Catch:{ all -> 0x0227 }
            r5.setDownloadTime(r0)     // Catch:{ all -> 0x0227 }
            int r0 = r13.size()     // Catch:{ all -> 0x0227 }
            long r0 = (long) r0     // Catch:{ all -> 0x0227 }
            r5.setDownloadSize(r0)     // Catch:{ all -> 0x0227 }
            int r0 = r13.size()     // Catch:{ all -> 0x0227 }
            if (r0 > r4) goto L_0x0225
            byte[] r0 = r13.toByteArray()     // Catch:{ all -> 0x0227 }
            r1 = 0
            java.lang.String r0 = com.bonree.sdk.bs.i.b(r0, r1)     // Catch:{ all -> 0x0227 }
            r5.setResponseBody(r0)     // Catch:{ all -> 0x0227 }
        L_0x0225:
            r6 = r13
            goto L_0x0239
        L_0x0227:
            r0 = move-exception
            r1 = r23
            r6 = r11
            r20 = r12
            goto L_0x027e
        L_0x022e:
            long r0 = (long) r0
            r5.setDownloadSize(r0)     // Catch:{ all -> 0x0233 }
            goto L_0x0238
        L_0x0233:
            r0 = move-exception
            r1 = r23
            goto L_0x0194
        L_0x0238:
            r6 = 0
        L_0x0239:
            if (r6 == 0) goto L_0x0243
            r6.close()     // Catch:{ all -> 0x023f }
            goto L_0x0243
        L_0x023f:
            r0 = move-exception
            r1 = r23
            goto L_0x025f
        L_0x0243:
            if (r12 == 0) goto L_0x0248
            r12.close()     // Catch:{ all -> 0x023f }
        L_0x0248:
            if (r3 == 0) goto L_0x024d
            r3.close()     // Catch:{ all -> 0x023f }
        L_0x024d:
            if (r11 == 0) goto L_0x0256
            if (r9 == 0) goto L_0x0259
            java.net.HttpURLConnection r11 = (java.net.HttpURLConnection) r11     // Catch:{ all -> 0x023f }
            r11.disconnect()     // Catch:{ all -> 0x023f }
        L_0x0256:
            r1 = r23
            goto L_0x026c
        L_0x0259:
            javax.net.ssl.HttpsURLConnection r11 = (javax.net.ssl.HttpsURLConnection) r11     // Catch:{ all -> 0x023f }
            r11.disconnect()     // Catch:{ all -> 0x023f }
            goto L_0x0256
        L_0x025f:
            com.bonree.sdk.be.f r2 = r1.c
            java.lang.String r3 = a
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r6 = 0
            r4[r6] = r0
            r2.c(r3, r4)
        L_0x026c:
            return r5
        L_0x026d:
            r0 = move-exception
            r6 = r11
            goto L_0x027b
        L_0x0270:
            r0 = move-exception
            r3 = 0
            r6 = 0
            goto L_0x027b
        L_0x0274:
            r0 = move-exception
            r11 = r28
            r10 = r11
            r3 = 0
            r6 = 0
            r9 = 0
        L_0x027b:
            r13 = 0
            r20 = 0
        L_0x027e:
            com.bonree.sdk.be.f r2 = com.bonree.sdk.be.a.a()     // Catch:{ all -> 0x02f8 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x02f8 }
            r4.<init>()     // Catch:{ all -> 0x02f8 }
            java.lang.String r7 = a     // Catch:{ all -> 0x02f8 }
            r4.append(r7)     // Catch:{ all -> 0x02f8 }
            java.lang.String r7 = " URL: "
            r4.append(r7)     // Catch:{ all -> 0x02f8 }
            r7 = r24
            r4.append(r7)     // Catch:{ all -> 0x02f8 }
            java.lang.String r7 = "    timeOut:"
            r4.append(r7)     // Catch:{ all -> 0x02f8 }
            r4.append(r10)     // Catch:{ all -> 0x02f8 }
            java.lang.String r7 = "\r\n"
            r4.append(r7)     // Catch:{ all -> 0x02f8 }
            java.lang.String r7 = r0.toString()     // Catch:{ all -> 0x02f8 }
            r4.append(r7)     // Catch:{ all -> 0x02f8 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x02f8 }
            r7 = 0
            java.lang.Object[] r8 = new java.lang.Object[r7]     // Catch:{ all -> 0x02f8 }
            r2.e(r4, r8)     // Catch:{ all -> 0x02f8 }
            java.lang.String r2 = r0.toString()     // Catch:{ all -> 0x02f8 }
            r5.setErrorMsg(r2)     // Catch:{ all -> 0x02f8 }
            com.bonree.sdk.n.c r2 = new com.bonree.sdk.n.c     // Catch:{ all -> 0x02f8 }
            r2.<init>()     // Catch:{ all -> 0x02f8 }
            com.bonree.sdk.agent.business.util.c.a((java.lang.Throwable) r0, (com.bonree.sdk.n.c) r2)     // Catch:{ all -> 0x02f8 }
            int r0 = r2.a     // Catch:{ all -> 0x02f8 }
            r5.setErrorOccurrentProcess(r0)     // Catch:{ all -> 0x02f8 }
            if (r13 == 0) goto L_0x02d0
            r13.close()     // Catch:{ all -> 0x02ce }
            goto L_0x02d0
        L_0x02ce:
            r0 = move-exception
            goto L_0x02ea
        L_0x02d0:
            if (r20 == 0) goto L_0x02d5
            r20.close()     // Catch:{ all -> 0x02ce }
        L_0x02d5:
            if (r3 == 0) goto L_0x02da
            r3.close()     // Catch:{ all -> 0x02ce }
        L_0x02da:
            if (r6 == 0) goto L_0x02f7
            if (r9 == 0) goto L_0x02e4
            java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6     // Catch:{ all -> 0x02ce }
            r6.disconnect()     // Catch:{ all -> 0x02ce }
            goto L_0x02f7
        L_0x02e4:
            javax.net.ssl.HttpsURLConnection r6 = (javax.net.ssl.HttpsURLConnection) r6     // Catch:{ all -> 0x02ce }
            r6.disconnect()     // Catch:{ all -> 0x02ce }
            goto L_0x02f7
        L_0x02ea:
            com.bonree.sdk.be.f r2 = r1.c
            java.lang.String r3 = a
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r6 = 0
            r4[r6] = r0
            r2.c(r3, r4)
        L_0x02f7:
            return r5
        L_0x02f8:
            r0 = move-exception
            r2 = r0
            if (r13 == 0) goto L_0x0302
            r13.close()     // Catch:{ all -> 0x0300 }
            goto L_0x0302
        L_0x0300:
            r0 = move-exception
            goto L_0x031c
        L_0x0302:
            if (r20 == 0) goto L_0x0307
            r20.close()     // Catch:{ all -> 0x0300 }
        L_0x0307:
            if (r3 == 0) goto L_0x030c
            r3.close()     // Catch:{ all -> 0x0300 }
        L_0x030c:
            if (r6 == 0) goto L_0x0329
            if (r9 == 0) goto L_0x0316
            java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6     // Catch:{ all -> 0x0300 }
            r6.disconnect()     // Catch:{ all -> 0x0300 }
            goto L_0x0329
        L_0x0316:
            javax.net.ssl.HttpsURLConnection r6 = (javax.net.ssl.HttpsURLConnection) r6     // Catch:{ all -> 0x0300 }
            r6.disconnect()     // Catch:{ all -> 0x0300 }
            goto L_0x0329
        L_0x031c:
            com.bonree.sdk.be.f r3 = r1.c
            java.lang.String r4 = a
            r5 = 1
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r6 = 0
            r5[r6] = r0
            r3.c(r4, r5)
        L_0x0329:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.common.onlineTools.b.a(java.lang.String, java.lang.String, java.lang.String, java.util.Map, int, int):com.bonree.sdk.agent.business.entity.instruction.HTTPInstructionResultBean");
    }

    private static URLConnection a(String str, boolean z, String str2, int i) throws Exception {
        URLConnection openConnectionFilter = HttpFilterInstrumentation.openConnectionFilter(new URL(str).openConnection());
        if (NetworkCustomEventBean.HttpMethod.POST.value().equals(str2)) {
            openConnectionFilter.setDoInput(true);
            openConnectionFilter.setDoOutput(true);
        }
        if (z) {
            ((HttpURLConnection) openConnectionFilter).setRequestMethod(str2);
        } else {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) openConnectionFilter;
            httpsURLConnection.setHostnameVerifier(k.b().a());
            httpsURLConnection.setRequestMethod(str2);
        }
        if (i > 0) {
            int i2 = i * 1000;
            openConnectionFilter.setConnectTimeout(i2);
            openConnectionFilter.setReadTimeout(i2);
        }
        return openConnectionFilter;
    }
}
