package com.dianping.logan;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class SendLogDefaultRunnable extends SendLogRunnable {
    private static final String TAG = "SendLogDefaultRunnable";
    private final Map<String, String> mRequestHeaders = new HashMap();
    private SendLogCallback mSendLogCallback;
    private String mUploadLogUrl;

    public void sendLog(File file) {
        doSendFileByAction(file, this.mRequestHeaders, this.mUploadLogUrl);
        finish();
        if (file.getName().contains(".copy")) {
            file.delete();
        }
    }

    public void setUrl(String str) {
        this.mUploadLogUrl = str;
    }

    public void setRequestHeader(Map<String, String> map) {
        this.mRequestHeaders.clear();
        if (map != null) {
            this.mRequestHeaders.putAll(map);
        }
    }

    public void setSendLogCallback(SendLogCallback sendLogCallback) {
        this.mSendLogCallback = sendLogCallback;
    }

    private void doSendFileByAction(File file, Map<String, String> map, String str) {
        try {
            doPostRequest(str, new FileInputStream(file), map);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v23, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v25, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v27, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v29, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v36, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v37, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v38, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v39, resolved type: java.io.OutputStream} */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v1, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r3v2 */
    /* JADX WARNING: type inference failed for: r3v4 */
    /* JADX WARNING: type inference failed for: r3v5, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r3v6 */
    /* JADX WARNING: type inference failed for: r3v8 */
    /* JADX WARNING: type inference failed for: r0v43 */
    /* JADX WARNING: type inference failed for: r0v46 */
    /* JADX WARNING: type inference failed for: r0v49 */
    /* JADX WARNING: type inference failed for: r0v52 */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0154, code lost:
        if (r10 == null) goto L_0x01d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x017d, code lost:
        if (r10 == null) goto L_0x01d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x01a5, code lost:
        if (r10 == null) goto L_0x01d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x01cd, code lost:
        if (r10 == null) goto L_0x01d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x01cf, code lost:
        r10.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x01d2, code lost:
        r0 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00f2, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x00f6, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x00f7, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x00f8, code lost:
        r6 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x00fd, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x00fe, code lost:
        r6 = null;
        r8 = r0;
        r0 = r12;
        r12 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0103, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0104, code lost:
        r6 = null;
        r8 = r0;
        r0 = r12;
        r12 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x010a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x010b, code lost:
        r6 = null;
        r8 = r0;
        r0 = r12;
        r12 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0111, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0112, code lost:
        r6 = null;
        r8 = r0;
        r0 = r12;
        r12 = r8;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0138 A[SYNTHETIC, Splitter:B:104:0x0138] */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0142 A[SYNTHETIC, Splitter:B:109:0x0142] */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x014c A[SYNTHETIC, Splitter:B:114:0x014c] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0161 A[SYNTHETIC, Splitter:B:125:0x0161] */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x016b A[SYNTHETIC, Splitter:B:130:0x016b] */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0175 A[SYNTHETIC, Splitter:B:135:0x0175] */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0189 A[SYNTHETIC, Splitter:B:146:0x0189] */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x0193 A[SYNTHETIC, Splitter:B:151:0x0193] */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x019d A[SYNTHETIC, Splitter:B:156:0x019d] */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x01b1 A[SYNTHETIC, Splitter:B:167:0x01b1] */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x01bb A[SYNTHETIC, Splitter:B:172:0x01bb] */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x01c5 A[SYNTHETIC, Splitter:B:177:0x01c5] */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x01f5 A[SYNTHETIC, Splitter:B:190:0x01f5] */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x01ff A[SYNTHETIC, Splitter:B:195:0x01ff] */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x0209 A[SYNTHETIC, Splitter:B:200:0x0209] */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x0213  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00f7 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:12:0x0060] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:101:0x0133=Splitter:B:101:0x0133, B:143:0x0184=Splitter:B:143:0x0184, B:122:0x015c=Splitter:B:122:0x015c, B:164:0x01ac=Splitter:B:164:0x01ac} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void doPostRequest(java.lang.String r10, java.io.InputStream r11, java.util.Map<java.lang.String, java.lang.String> r12) {
        /*
            r9 = this;
            r0 = 2048(0x800, float:2.87E-42)
            byte[] r1 = new byte[r0]
            r2 = -1
            r3 = 0
            java.net.URL r4 = new java.net.URL     // Catch:{ ProtocolException -> 0x01a8, MalformedURLException -> 0x0180, IOException -> 0x0158, Exception -> 0x012f, all -> 0x012a }
            r4.<init>(r10)     // Catch:{ ProtocolException -> 0x01a8, MalformedURLException -> 0x0180, IOException -> 0x0158, Exception -> 0x012f, all -> 0x012a }
            java.net.URLConnection r10 = r4.openConnection()     // Catch:{ ProtocolException -> 0x01a8, MalformedURLException -> 0x0180, IOException -> 0x0158, Exception -> 0x012f, all -> 0x012a }
            java.net.URLConnection r10 = com.bonree.sdk.agent.engine.external.HttpInstrumentation.openConnection(r10)     // Catch:{ ProtocolException -> 0x01a8, MalformedURLException -> 0x0180, IOException -> 0x0158, Exception -> 0x012f, all -> 0x012a }
            java.net.HttpURLConnection r10 = (java.net.HttpURLConnection) r10     // Catch:{ ProtocolException -> 0x01a8, MalformedURLException -> 0x0180, IOException -> 0x0158, Exception -> 0x012f, all -> 0x012a }
            boolean r4 = r10 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ ProtocolException -> 0x0126, MalformedURLException -> 0x0122, IOException -> 0x011f, Exception -> 0x011c, all -> 0x0118 }
            if (r4 == 0) goto L_0x0024
            r4 = r10
            javax.net.ssl.HttpsURLConnection r4 = (javax.net.ssl.HttpsURLConnection) r4     // Catch:{ ProtocolException -> 0x0126, MalformedURLException -> 0x0122, IOException -> 0x011f, Exception -> 0x011c, all -> 0x0118 }
            com.dianping.logan.SendLogDefaultRunnable$1 r5 = new com.dianping.logan.SendLogDefaultRunnable$1     // Catch:{ ProtocolException -> 0x0126, MalformedURLException -> 0x0122, IOException -> 0x011f, Exception -> 0x011c, all -> 0x0118 }
            r5.<init>()     // Catch:{ ProtocolException -> 0x0126, MalformedURLException -> 0x0122, IOException -> 0x011f, Exception -> 0x011c, all -> 0x0118 }
            r4.setHostnameVerifier(r5)     // Catch:{ ProtocolException -> 0x0126, MalformedURLException -> 0x0122, IOException -> 0x011f, Exception -> 0x011c, all -> 0x0118 }
        L_0x0024:
            java.util.Set r12 = r12.entrySet()     // Catch:{ ProtocolException -> 0x0126, MalformedURLException -> 0x0122, IOException -> 0x011f, Exception -> 0x011c, all -> 0x0118 }
            java.util.Iterator r12 = r12.iterator()     // Catch:{ ProtocolException -> 0x0126, MalformedURLException -> 0x0122, IOException -> 0x011f, Exception -> 0x011c, all -> 0x0118 }
        L_0x002c:
            boolean r4 = r12.hasNext()     // Catch:{ ProtocolException -> 0x0126, MalformedURLException -> 0x0122, IOException -> 0x011f, Exception -> 0x011c, all -> 0x0118 }
            if (r4 == 0) goto L_0x0048
            java.lang.Object r4 = r12.next()     // Catch:{ ProtocolException -> 0x0126, MalformedURLException -> 0x0122, IOException -> 0x011f, Exception -> 0x011c, all -> 0x0118 }
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch:{ ProtocolException -> 0x0126, MalformedURLException -> 0x0122, IOException -> 0x011f, Exception -> 0x011c, all -> 0x0118 }
            java.lang.Object r5 = r4.getKey()     // Catch:{ ProtocolException -> 0x0126, MalformedURLException -> 0x0122, IOException -> 0x011f, Exception -> 0x011c, all -> 0x0118 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ ProtocolException -> 0x0126, MalformedURLException -> 0x0122, IOException -> 0x011f, Exception -> 0x011c, all -> 0x0118 }
            java.lang.Object r4 = r4.getValue()     // Catch:{ ProtocolException -> 0x0126, MalformedURLException -> 0x0122, IOException -> 0x011f, Exception -> 0x011c, all -> 0x0118 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ ProtocolException -> 0x0126, MalformedURLException -> 0x0122, IOException -> 0x011f, Exception -> 0x011c, all -> 0x0118 }
            r10.addRequestProperty(r5, r4)     // Catch:{ ProtocolException -> 0x0126, MalformedURLException -> 0x0122, IOException -> 0x011f, Exception -> 0x011c, all -> 0x0118 }
            goto L_0x002c
        L_0x0048:
            r12 = 15000(0x3a98, float:2.102E-41)
            r10.setReadTimeout(r12)     // Catch:{ ProtocolException -> 0x0126, MalformedURLException -> 0x0122, IOException -> 0x011f, Exception -> 0x011c, all -> 0x0118 }
            r10.setConnectTimeout(r12)     // Catch:{ ProtocolException -> 0x0126, MalformedURLException -> 0x0122, IOException -> 0x011f, Exception -> 0x011c, all -> 0x0118 }
            r12 = 1
            r10.setDoInput(r12)     // Catch:{ ProtocolException -> 0x0126, MalformedURLException -> 0x0122, IOException -> 0x011f, Exception -> 0x011c, all -> 0x0118 }
            r10.setDoOutput(r12)     // Catch:{ ProtocolException -> 0x0126, MalformedURLException -> 0x0122, IOException -> 0x011f, Exception -> 0x011c, all -> 0x0118 }
            java.lang.String r12 = "POST"
            r10.setRequestMethod(r12)     // Catch:{ ProtocolException -> 0x0126, MalformedURLException -> 0x0122, IOException -> 0x011f, Exception -> 0x011c, all -> 0x0118 }
            java.io.OutputStream r12 = r10.getOutputStream()     // Catch:{ ProtocolException -> 0x0126, MalformedURLException -> 0x0122, IOException -> 0x011f, Exception -> 0x011c, all -> 0x0118 }
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch:{ ProtocolException -> 0x0111, MalformedURLException -> 0x010a, IOException -> 0x0103, Exception -> 0x00fd, all -> 0x00f7 }
            r4.<init>(r0)     // Catch:{ ProtocolException -> 0x0111, MalformedURLException -> 0x010a, IOException -> 0x0103, Exception -> 0x00fd, all -> 0x00f7 }
        L_0x0065:
            int r0 = r11.read(r1)     // Catch:{ all -> 0x00f2 }
            r5 = 0
            if (r0 == r2) goto L_0x0070
            r4.write(r1, r5, r0)     // Catch:{ all -> 0x00f2 }
            goto L_0x0065
        L_0x0070:
            byte[] r0 = r4.toByteArray()     // Catch:{ all -> 0x00f2 }
            r4.close()     // Catch:{ ProtocolException -> 0x0111, MalformedURLException -> 0x010a, IOException -> 0x0103, Exception -> 0x00fd, all -> 0x00f7 }
            r12.write(r0)     // Catch:{ ProtocolException -> 0x0111, MalformedURLException -> 0x010a, IOException -> 0x0103, Exception -> 0x00fd, all -> 0x00f7 }
            r12.flush()     // Catch:{ ProtocolException -> 0x0111, MalformedURLException -> 0x010a, IOException -> 0x0103, Exception -> 0x00fd, all -> 0x00f7 }
            int r0 = r10.getResponseCode()     // Catch:{ ProtocolException -> 0x0111, MalformedURLException -> 0x010a, IOException -> 0x0103, Exception -> 0x00fd, all -> 0x00f7 }
            int r4 = r0 / 100
            r6 = 2
            if (r4 != r6) goto L_0x00af
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch:{ ProtocolException -> 0x00eb, MalformedURLException -> 0x00e4, IOException -> 0x00dd, Exception -> 0x00d6, all -> 0x00f7 }
            r4.<init>()     // Catch:{ ProtocolException -> 0x00eb, MalformedURLException -> 0x00e4, IOException -> 0x00dd, Exception -> 0x00d6, all -> 0x00f7 }
            java.io.InputStream r6 = r10.getInputStream()     // Catch:{ ProtocolException -> 0x00eb, MalformedURLException -> 0x00e4, IOException -> 0x00dd, Exception -> 0x00d6, all -> 0x00f7 }
        L_0x008f:
            int r7 = r6.read(r1)     // Catch:{ ProtocolException -> 0x00ac, MalformedURLException -> 0x00a9, IOException -> 0x00a6, Exception -> 0x00a3, all -> 0x00a0 }
            if (r7 == r2) goto L_0x0099
            r4.write(r1, r5, r7)     // Catch:{ ProtocolException -> 0x00ac, MalformedURLException -> 0x00a9, IOException -> 0x00a6, Exception -> 0x00a3, all -> 0x00a0 }
            goto L_0x008f
        L_0x0099:
            byte[] r3 = r4.toByteArray()     // Catch:{ ProtocolException -> 0x00ac, MalformedURLException -> 0x00a9, IOException -> 0x00a6, Exception -> 0x00a3, all -> 0x00a0 }
            r1 = r3
            r3 = r6
            goto L_0x00b0
        L_0x00a0:
            r0 = move-exception
            goto L_0x00f9
        L_0x00a3:
            r1 = move-exception
            r2 = r0
            goto L_0x00d9
        L_0x00a6:
            r1 = move-exception
            r2 = r0
            goto L_0x00e0
        L_0x00a9:
            r1 = move-exception
            r2 = r0
            goto L_0x00e7
        L_0x00ac:
            r1 = move-exception
            r2 = r0
            goto L_0x00ee
        L_0x00af:
            r1 = r3
        L_0x00b0:
            if (r12 == 0) goto L_0x00ba
            r12.close()     // Catch:{ IOException -> 0x00b6 }
            goto L_0x00ba
        L_0x00b6:
            r12 = move-exception
            r12.printStackTrace()
        L_0x00ba:
            if (r3 == 0) goto L_0x00c4
            r3.close()     // Catch:{ IOException -> 0x00c0 }
            goto L_0x00c4
        L_0x00c0:
            r12 = move-exception
            r12.printStackTrace()
        L_0x00c4:
            if (r11 == 0) goto L_0x00ce
            r11.close()     // Catch:{ IOException -> 0x00ca }
            goto L_0x00ce
        L_0x00ca:
            r11 = move-exception
            r11.printStackTrace()
        L_0x00ce:
            if (r10 == 0) goto L_0x00d3
            r10.disconnect()
        L_0x00d3:
            r3 = r1
            goto L_0x01d3
        L_0x00d6:
            r1 = move-exception
            r2 = r0
            r6 = r3
        L_0x00d9:
            r0 = r12
            r12 = r1
            goto L_0x0133
        L_0x00dd:
            r1 = move-exception
            r2 = r0
            r6 = r3
        L_0x00e0:
            r0 = r12
            r12 = r1
            goto L_0x015c
        L_0x00e4:
            r1 = move-exception
            r2 = r0
            r6 = r3
        L_0x00e7:
            r0 = r12
            r12 = r1
            goto L_0x0184
        L_0x00eb:
            r1 = move-exception
            r2 = r0
            r6 = r3
        L_0x00ee:
            r0 = r12
            r12 = r1
            goto L_0x01ac
        L_0x00f2:
            r0 = move-exception
            r4.close()     // Catch:{ ProtocolException -> 0x0111, MalformedURLException -> 0x010a, IOException -> 0x0103, Exception -> 0x00fd, all -> 0x00f7 }
            throw r0     // Catch:{ ProtocolException -> 0x0111, MalformedURLException -> 0x010a, IOException -> 0x0103, Exception -> 0x00fd, all -> 0x00f7 }
        L_0x00f7:
            r0 = move-exception
            r6 = r3
        L_0x00f9:
            r3 = r12
            r12 = r0
            goto L_0x01f3
        L_0x00fd:
            r0 = move-exception
            r6 = r3
            r8 = r0
            r0 = r12
            r12 = r8
            goto L_0x0133
        L_0x0103:
            r0 = move-exception
            r6 = r3
            r8 = r0
            r0 = r12
            r12 = r8
            goto L_0x015c
        L_0x010a:
            r0 = move-exception
            r6 = r3
            r8 = r0
            r0 = r12
            r12 = r8
            goto L_0x0184
        L_0x0111:
            r0 = move-exception
            r6 = r3
            r8 = r0
            r0 = r12
            r12 = r8
            goto L_0x01ac
        L_0x0118:
            r12 = move-exception
            r6 = r3
            goto L_0x01f3
        L_0x011c:
            r12 = move-exception
            r0 = r3
            goto L_0x0132
        L_0x011f:
            r12 = move-exception
            r0 = r3
            goto L_0x015b
        L_0x0122:
            r12 = move-exception
            r0 = r3
            goto L_0x0183
        L_0x0126:
            r12 = move-exception
            r0 = r3
            goto L_0x01ab
        L_0x012a:
            r12 = move-exception
            r10 = r3
            r6 = r10
            goto L_0x01f3
        L_0x012f:
            r12 = move-exception
            r10 = r3
            r0 = r10
        L_0x0132:
            r6 = r0
        L_0x0133:
            r12.printStackTrace()     // Catch:{ all -> 0x01f1 }
            if (r0 == 0) goto L_0x0140
            r0.close()     // Catch:{ IOException -> 0x013c }
            goto L_0x0140
        L_0x013c:
            r12 = move-exception
            r12.printStackTrace()
        L_0x0140:
            if (r6 == 0) goto L_0x014a
            r6.close()     // Catch:{ IOException -> 0x0146 }
            goto L_0x014a
        L_0x0146:
            r12 = move-exception
            r12.printStackTrace()
        L_0x014a:
            if (r11 == 0) goto L_0x0154
            r11.close()     // Catch:{ IOException -> 0x0150 }
            goto L_0x0154
        L_0x0150:
            r11 = move-exception
            r11.printStackTrace()
        L_0x0154:
            if (r10 == 0) goto L_0x01d2
            goto L_0x01cf
        L_0x0158:
            r12 = move-exception
            r10 = r3
            r0 = r10
        L_0x015b:
            r6 = r0
        L_0x015c:
            r12.printStackTrace()     // Catch:{ all -> 0x01f1 }
            if (r0 == 0) goto L_0x0169
            r0.close()     // Catch:{ IOException -> 0x0165 }
            goto L_0x0169
        L_0x0165:
            r12 = move-exception
            r12.printStackTrace()
        L_0x0169:
            if (r6 == 0) goto L_0x0173
            r6.close()     // Catch:{ IOException -> 0x016f }
            goto L_0x0173
        L_0x016f:
            r12 = move-exception
            r12.printStackTrace()
        L_0x0173:
            if (r11 == 0) goto L_0x017d
            r11.close()     // Catch:{ IOException -> 0x0179 }
            goto L_0x017d
        L_0x0179:
            r11 = move-exception
            r11.printStackTrace()
        L_0x017d:
            if (r10 == 0) goto L_0x01d2
            goto L_0x01cf
        L_0x0180:
            r12 = move-exception
            r10 = r3
            r0 = r10
        L_0x0183:
            r6 = r0
        L_0x0184:
            r12.printStackTrace()     // Catch:{ all -> 0x01f1 }
            if (r0 == 0) goto L_0x0191
            r0.close()     // Catch:{ IOException -> 0x018d }
            goto L_0x0191
        L_0x018d:
            r12 = move-exception
            r12.printStackTrace()
        L_0x0191:
            if (r6 == 0) goto L_0x019b
            r6.close()     // Catch:{ IOException -> 0x0197 }
            goto L_0x019b
        L_0x0197:
            r12 = move-exception
            r12.printStackTrace()
        L_0x019b:
            if (r11 == 0) goto L_0x01a5
            r11.close()     // Catch:{ IOException -> 0x01a1 }
            goto L_0x01a5
        L_0x01a1:
            r11 = move-exception
            r11.printStackTrace()
        L_0x01a5:
            if (r10 == 0) goto L_0x01d2
            goto L_0x01cf
        L_0x01a8:
            r12 = move-exception
            r10 = r3
            r0 = r10
        L_0x01ab:
            r6 = r0
        L_0x01ac:
            r12.printStackTrace()     // Catch:{ all -> 0x01f1 }
            if (r0 == 0) goto L_0x01b9
            r0.close()     // Catch:{ IOException -> 0x01b5 }
            goto L_0x01b9
        L_0x01b5:
            r12 = move-exception
            r12.printStackTrace()
        L_0x01b9:
            if (r6 == 0) goto L_0x01c3
            r6.close()     // Catch:{ IOException -> 0x01bf }
            goto L_0x01c3
        L_0x01bf:
            r12 = move-exception
            r12.printStackTrace()
        L_0x01c3:
            if (r11 == 0) goto L_0x01cd
            r11.close()     // Catch:{ IOException -> 0x01c9 }
            goto L_0x01cd
        L_0x01c9:
            r11 = move-exception
            r11.printStackTrace()
        L_0x01cd:
            if (r10 == 0) goto L_0x01d2
        L_0x01cf:
            r10.disconnect()
        L_0x01d2:
            r0 = r2
        L_0x01d3:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "log send completed, http statusCode : "
            r10.append(r11)
            r10.append(r0)
            java.lang.String r10 = r10.toString()
            java.lang.String r11 = "SendLogDefaultRunnable"
            android.util.Log.d(r11, r10)
            com.dianping.logan.SendLogCallback r10 = r9.mSendLogCallback
            if (r10 == 0) goto L_0x01f0
            r10.onLogSendCompleted(r0, r3)
        L_0x01f0:
            return
        L_0x01f1:
            r12 = move-exception
            r3 = r0
        L_0x01f3:
            if (r3 == 0) goto L_0x01fd
            r3.close()     // Catch:{ IOException -> 0x01f9 }
            goto L_0x01fd
        L_0x01f9:
            r0 = move-exception
            r0.printStackTrace()
        L_0x01fd:
            if (r6 == 0) goto L_0x0207
            r6.close()     // Catch:{ IOException -> 0x0203 }
            goto L_0x0207
        L_0x0203:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0207:
            if (r11 == 0) goto L_0x0211
            r11.close()     // Catch:{ IOException -> 0x020d }
            goto L_0x0211
        L_0x020d:
            r11 = move-exception
            r11.printStackTrace()
        L_0x0211:
            if (r10 == 0) goto L_0x0216
            r10.disconnect()
        L_0x0216:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dianping.logan.SendLogDefaultRunnable.doPostRequest(java.lang.String, java.io.InputStream, java.util.Map):void");
    }
}
