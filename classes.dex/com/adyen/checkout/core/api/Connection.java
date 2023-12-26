package com.adyen.checkout.core.api;

import androidx.browser.trusted.sharing.ShareTarget;
import com.adyen.checkout.core.log.LogUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.Callable;

public abstract class Connection<T> implements Callable<T> {
    private static final String APP_JSON_CONTENT_TYPE = "application/json";
    private static final int BUFFER_SIZE = 1024;
    private static final Charset CHARSET = StandardCharsets.UTF_8;
    private static final String CONTENT_TYPE_HEADER = "Content-Type";
    public static final Map<String, String> CONTENT_TYPE_JSON_HEADER = Collections.singletonMap("Content-Type", APP_JSON_CONTENT_TYPE);
    private static final String TAG = LogUtil.getTag();
    private HttpURLConnection mURLConnection;
    private final String mUrl;

    protected Connection(String str) {
        this.mUrl = str;
    }

    /* access modifiers changed from: protected */
    public String getUrl() {
        return this.mUrl;
    }

    /* access modifiers changed from: protected */
    public byte[] get() throws IOException {
        return get(Collections.emptyMap());
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    public byte[] get(Map<String, String> map) throws IOException {
        if (this.mURLConnection == null) {
            try {
                HttpURLConnection urlConnection = getUrlConnection(this.mUrl, map, HttpMethod.GET);
                this.mURLConnection = urlConnection;
                urlConnection.connect();
                byte[] handleResponse = handleResponse(this.mURLConnection);
                HttpURLConnection httpURLConnection = this.mURLConnection;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return handleResponse;
            } catch (Throwable th) {
                HttpURLConnection httpURLConnection2 = this.mURLConnection;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                throw th;
            }
        } else {
            throw new RuntimeException("Connection already initiated");
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0032, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0033, code lost:
        if (r3 != null) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003d, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] post(java.util.Map<java.lang.String, java.lang.String> r3, byte[] r4) throws java.io.IOException {
        /*
            r2 = this;
            java.net.HttpURLConnection r0 = r2.mURLConnection
            if (r0 != 0) goto L_0x0047
            java.lang.String r0 = r2.mUrl     // Catch:{ all -> 0x003e }
            com.adyen.checkout.core.api.Connection$HttpMethod r1 = com.adyen.checkout.core.api.Connection.HttpMethod.POST     // Catch:{ all -> 0x003e }
            java.net.HttpURLConnection r3 = r2.getUrlConnection(r0, r3, r1)     // Catch:{ all -> 0x003e }
            r2.mURLConnection = r3     // Catch:{ all -> 0x003e }
            r3.connect()     // Catch:{ all -> 0x003e }
            java.net.HttpURLConnection r3 = r2.mURLConnection     // Catch:{ all -> 0x003e }
            java.io.OutputStream r3 = r3.getOutputStream()     // Catch:{ all -> 0x003e }
            r3.write(r4)     // Catch:{ all -> 0x0030 }
            r3.flush()     // Catch:{ all -> 0x0030 }
            if (r3 == 0) goto L_0x0022
            r3.close()     // Catch:{ all -> 0x003e }
        L_0x0022:
            java.net.HttpURLConnection r3 = r2.mURLConnection     // Catch:{ all -> 0x003e }
            byte[] r3 = r2.handleResponse(r3)     // Catch:{ all -> 0x003e }
            java.net.HttpURLConnection r4 = r2.mURLConnection
            if (r4 == 0) goto L_0x002f
            r4.disconnect()
        L_0x002f:
            return r3
        L_0x0030:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0032 }
        L_0x0032:
            r0 = move-exception
            if (r3 == 0) goto L_0x003d
            r3.close()     // Catch:{ all -> 0x0039 }
            goto L_0x003d
        L_0x0039:
            r3 = move-exception
            r4.addSuppressed(r3)     // Catch:{ all -> 0x003e }
        L_0x003d:
            throw r0     // Catch:{ all -> 0x003e }
        L_0x003e:
            r3 = move-exception
            java.net.HttpURLConnection r4 = r2.mURLConnection
            if (r4 == 0) goto L_0x0046
            r4.disconnect()
        L_0x0046:
            throw r3
        L_0x0047:
            java.lang.RuntimeException r3 = new java.lang.RuntimeException
            java.lang.String r4 = "Connection already initiated"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adyen.checkout.core.api.Connection.post(java.util.Map, byte[]):byte[]");
    }

    private IOException parseException(byte[] bArr) {
        return new IOException(bArr != null ? new String(bArr, CHARSET) : null);
    }

    private HttpURLConnection getUrlConnection(String str, Map<String, String> map, HttpMethod httpMethod) throws IOException {
        HttpURLConnection createHttpUrlConnection = HttpUrlConnectionFactory.getInstance().createHttpUrlConnection(str);
        createHttpUrlConnection.setRequestMethod(httpMethod.getValue());
        createHttpUrlConnection.setUseCaches(false);
        createHttpUrlConnection.setDoInput(true);
        createHttpUrlConnection.setDoOutput(httpMethod.isDoOutput());
        for (Map.Entry next : map.entrySet()) {
            createHttpUrlConnection.addRequestProperty((String) next.getKey(), (String) next.getValue());
        }
        return createHttpUrlConnection;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0023, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0024, code lost:
        if (r4 != null) goto L_0x0026;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x002a, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r1.addSuppressed(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x002e, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x003a, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x003b, code lost:
        if (r0 != null) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0041, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0042, code lost:
        r4.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0045, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] handleResponse(java.net.HttpURLConnection r4) throws java.io.IOException {
        /*
            r3 = this;
            java.io.InputStream r0 = r4.getErrorStream()
            if (r0 != 0) goto L_0x002f
            java.io.InputStream r4 = r4.getInputStream()     // Catch:{ all -> 0x0038 }
            byte[] r1 = r3.getBytes(r4)     // Catch:{ all -> 0x0021 }
            if (r1 == 0) goto L_0x001b
            if (r4 == 0) goto L_0x0015
            r4.close()     // Catch:{ all -> 0x0038 }
        L_0x0015:
            if (r0 == 0) goto L_0x001a
            r0.close()
        L_0x001a:
            return r1
        L_0x001b:
            if (r4 == 0) goto L_0x002f
            r4.close()     // Catch:{ all -> 0x0038 }
            goto L_0x002f
        L_0x0021:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0023 }
        L_0x0023:
            r2 = move-exception
            if (r4 == 0) goto L_0x002e
            r4.close()     // Catch:{ all -> 0x002a }
            goto L_0x002e
        L_0x002a:
            r4 = move-exception
            r1.addSuppressed(r4)     // Catch:{ all -> 0x0038 }
        L_0x002e:
            throw r2     // Catch:{ all -> 0x0038 }
        L_0x002f:
            byte[] r4 = r3.getBytes(r0)     // Catch:{ all -> 0x0038 }
            java.io.IOException r4 = r3.parseException(r4)     // Catch:{ all -> 0x0038 }
            throw r4     // Catch:{ all -> 0x0038 }
        L_0x0038:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x003a }
        L_0x003a:
            r1 = move-exception
            if (r0 == 0) goto L_0x0045
            r0.close()     // Catch:{ all -> 0x0041 }
            goto L_0x0045
        L_0x0041:
            r0 = move-exception
            r4.addSuppressed(r0)
        L_0x0045:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adyen.checkout.core.api.Connection.handleResponse(java.net.HttpURLConnection):byte[]");
    }

    private byte[] getBytes(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        int read = inputStream.read(bArr);
        while (read > 0) {
            byteArrayOutputStream.write(bArr, 0, read);
            read = inputStream.read(bArr);
        }
        return byteArrayOutputStream.toByteArray();
    }

    private enum HttpMethod {
        GET(ShareTarget.METHOD_GET, false),
        POST(ShareTarget.METHOD_POST, true);
        
        private final boolean mDoOutput;
        private final String mValue;

        private HttpMethod(String str, boolean z) {
            this.mValue = str;
            this.mDoOutput = z;
        }

        /* access modifiers changed from: package-private */
        public String getValue() {
            return this.mValue;
        }

        /* access modifiers changed from: package-private */
        public boolean isDoOutput() {
            return this.mDoOutput;
        }
    }
}
