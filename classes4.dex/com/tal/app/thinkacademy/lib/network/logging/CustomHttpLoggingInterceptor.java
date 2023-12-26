package com.tal.app.thinkacademy.lib.network.logging;

import java.io.EOFException;
import java.nio.charset.Charset;
import java.util.Objects;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.internal.platform.Platform;
import okio.Buffer;

public final class CustomHttpLoggingInterceptor implements Interceptor {
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private volatile Level level;
    private final Logger logger;

    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    public interface Logger {
        public static final Logger DEFAULT = new Logger() {
            public void log(String str) {
                Platform.get().log(str, 4, (Throwable) null);
            }
        };

        void log(String str);
    }

    public CustomHttpLoggingInterceptor() {
        this(Logger.DEFAULT);
    }

    public CustomHttpLoggingInterceptor(Logger logger2) {
        this.level = Level.NONE;
        this.logger = logger2;
    }

    public CustomHttpLoggingInterceptor setLevel(Level level2) {
        Objects.requireNonNull(level2, "level == null. Use Level.NONE instead.");
        this.level = level2;
        return this;
    }

    public Level getLevel() {
        return this.level;
    }

    /* JADX WARNING: Removed duplicated region for block: B:74:0x01d8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain r19) throws java.io.IOException {
        /*
            r18 = this;
            r1 = r18
            r0 = r19
            com.tal.app.thinkacademy.lib.network.logging.CustomHttpLoggingInterceptor$Level r2 = r1.level
            okhttp3.Request r3 = r19.request()
            com.tal.app.thinkacademy.lib.network.logging.CustomHttpLoggingInterceptor$Level r4 = com.tal.app.thinkacademy.lib.network.logging.CustomHttpLoggingInterceptor.Level.NONE
            if (r2 != r4) goto L_0x0013
            okhttp3.Response r0 = r0.proceed(r3)
            return r0
        L_0x0013:
            com.tal.app.thinkacademy.lib.network.logging.CustomHttpLoggingInterceptor$Level r4 = com.tal.app.thinkacademy.lib.network.logging.CustomHttpLoggingInterceptor.Level.BODY
            r5 = 1
            if (r2 != r4) goto L_0x001a
            r4 = r5
            goto L_0x001b
        L_0x001a:
            r4 = 0
        L_0x001b:
            if (r4 != 0) goto L_0x0024
            com.tal.app.thinkacademy.lib.network.logging.CustomHttpLoggingInterceptor$Level r7 = com.tal.app.thinkacademy.lib.network.logging.CustomHttpLoggingInterceptor.Level.HEADERS
            if (r2 != r7) goto L_0x0022
            goto L_0x0024
        L_0x0022:
            r2 = 0
            goto L_0x0025
        L_0x0024:
            r2 = r5
        L_0x0025:
            okhttp3.RequestBody r7 = r3.body()
            if (r7 == 0) goto L_0x002c
            goto L_0x002d
        L_0x002c:
            r5 = 0
        L_0x002d:
            okhttp3.Connection r8 = r19.connection()
            com.tal.app.thinkacademy.lib.network.logging.RequestLoggingBean r9 = new com.tal.app.thinkacademy.lib.network.logging.RequestLoggingBean
            r9.<init>()
            java.lang.String r10 = r3.method()
            r9.method = r10
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            okhttp3.HttpUrl r11 = r3.url()
            r10.append(r11)
            java.lang.String r11 = ""
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            r9.uri = r10
            if (r8 == 0) goto L_0x0069
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            okhttp3.Protocol r8 = r8.protocol()
            r10.append(r8)
            r10.append(r11)
            java.lang.String r8 = r10.toString()
            goto L_0x006a
        L_0x0069:
            r8 = r11
        L_0x006a:
            r9.http_version = r8
            if (r2 == 0) goto L_0x0112
            java.lang.String r8 = "Content-Length"
            java.lang.String r10 = "Content-Type"
            if (r5 == 0) goto L_0x00b4
            okhttp3.MediaType r12 = r7.contentType()
            if (r12 == 0) goto L_0x0092
            java.util.HashMap<java.lang.String, java.lang.String> r12 = r9.requestHeaderMaps
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            okhttp3.MediaType r14 = r7.contentType()
            r13.append(r14)
            r13.append(r11)
            java.lang.String r13 = r13.toString()
            r12.put(r10, r13)
        L_0x0092:
            long r12 = r7.contentLength()
            r14 = -1
            int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r12 == 0) goto L_0x00b4
            java.util.HashMap<java.lang.String, java.lang.String> r12 = r9.requestHeaderMaps
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            long r14 = r7.contentLength()
            r13.append(r14)
            r13.append(r11)
            java.lang.String r13 = r13.toString()
            r12.put(r8, r13)
        L_0x00b4:
            okhttp3.Headers r12 = r3.headers()
            int r13 = r12.size()
            r14 = 0
        L_0x00bd:
            if (r14 >= r13) goto L_0x00e2
            java.lang.String r15 = r12.name(r14)
            boolean r16 = r10.equalsIgnoreCase(r15)
            if (r16 != 0) goto L_0x00db
            boolean r16 = r8.equalsIgnoreCase(r15)
            if (r16 != 0) goto L_0x00db
            java.util.HashMap<java.lang.String, java.lang.String> r6 = r9.requestHeaderMaps
            r17 = r8
            java.lang.String r8 = r12.value(r14)
            r6.put(r15, r8)
            goto L_0x00dd
        L_0x00db:
            r17 = r8
        L_0x00dd:
            int r14 = r14 + 1
            r8 = r17
            goto L_0x00bd
        L_0x00e2:
            if (r4 == 0) goto L_0x0112
            if (r5 != 0) goto L_0x00e7
            goto L_0x0112
        L_0x00e7:
            okhttp3.Headers r5 = r3.headers()
            boolean r5 = r1.bodyHasUnknownEncoding(r5)
            if (r5 == 0) goto L_0x00f2
            goto L_0x0112
        L_0x00f2:
            okio.Buffer r5 = new okio.Buffer
            r5.<init>()
            r7.writeTo(r5)
            java.nio.charset.Charset r6 = UTF8
            okhttp3.MediaType r7 = r7.contentType()
            if (r7 == 0) goto L_0x0106
            java.nio.charset.Charset r6 = r7.charset(r6)
        L_0x0106:
            boolean r7 = isPlaintext(r5)
            if (r7 == 0) goto L_0x0112
            java.lang.String r5 = r5.readString(r6)
            r9.requestBody = r5
        L_0x0112:
            com.tal.app.thinkacademy.lib.network.logging.CustomHttpLoggingInterceptor$Logger r5 = r1.logger
            java.lang.String r6 = r9.toString()
            r5.log(r6)
            com.tal.app.thinkacademy.lib.network.logging.ResponseLoggingBean r5 = new com.tal.app.thinkacademy.lib.network.logging.ResponseLoggingBean
            r5.<init>()
            long r6 = java.lang.System.nanoTime()
            okhttp3.Response r0 = r0.proceed(r3)     // Catch:{ Exception -> 0x0210 }
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r8 = java.lang.System.nanoTime()
            long r8 = r8 - r6
            long r6 = r3.toMillis(r8)
            okhttp3.ResponseBody r3 = r0.body()
            long r8 = r3.contentLength()
            int r10 = r0.code()
            r5.code = r10
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            okhttp3.Request r12 = r0.request()
            okhttp3.HttpUrl r12 = r12.url()
            r10.append(r12)
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            r5.uri = r10
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r6)
            java.lang.String r6 = "毫秒"
            r10.append(r6)
            java.lang.String r6 = r10.toString()
            r5.time = r6
            if (r2 == 0) goto L_0x01ff
            okhttp3.Headers r2 = r0.headers()
            int r6 = r2.size()
            r7 = 0
        L_0x0178:
            if (r7 >= r6) goto L_0x018a
            java.util.HashMap<java.lang.String, java.lang.String> r10 = r5.responseHeaderMaps
            java.lang.String r11 = r2.name(r7)
            java.lang.String r12 = r2.value(r7)
            r10.put(r11, r12)
            int r7 = r7 + 1
            goto L_0x0178
        L_0x018a:
            if (r4 == 0) goto L_0x01ff
            boolean r4 = okhttp3.internal.http.HttpHeaders.hasBody(r0)
            if (r4 != 0) goto L_0x0193
            goto L_0x01ff
        L_0x0193:
            okhttp3.Headers r4 = r0.headers()
            boolean r4 = r1.bodyHasUnknownEncoding(r4)
            if (r4 == 0) goto L_0x019e
            goto L_0x01ff
        L_0x019e:
            okio.BufferedSource r4 = r3.source()
            r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r4.request(r6)
            okio.Buffer r4 = r4.buffer()
            java.lang.String r6 = "Content-Encoding"
            java.lang.String r2 = r2.get(r6)
            java.lang.String r6 = "gzip"
            boolean r2 = r6.equalsIgnoreCase(r2)
            if (r2 == 0) goto L_0x01dc
            r2 = 0
            okio.GzipSource r6 = new okio.GzipSource     // Catch:{ all -> 0x01d5 }
            okio.Buffer r4 = r4.clone()     // Catch:{ all -> 0x01d5 }
            r6.<init>(r4)     // Catch:{ all -> 0x01d5 }
            okio.Buffer r4 = new okio.Buffer     // Catch:{ all -> 0x01d2 }
            r4.<init>()     // Catch:{ all -> 0x01d2 }
            r4.writeAll(r6)     // Catch:{ all -> 0x01d2 }
            r6.close()
            goto L_0x01dc
        L_0x01d2:
            r0 = move-exception
            r2 = r6
            goto L_0x01d6
        L_0x01d5:
            r0 = move-exception
        L_0x01d6:
            if (r2 == 0) goto L_0x01db
            r2.close()
        L_0x01db:
            throw r0
        L_0x01dc:
            java.nio.charset.Charset r2 = UTF8
            okhttp3.MediaType r3 = r3.contentType()
            if (r3 == 0) goto L_0x01e8
            java.nio.charset.Charset r2 = r3.charset(r2)
        L_0x01e8:
            boolean r3 = isPlaintext(r4)
            if (r3 != 0) goto L_0x01ef
            return r0
        L_0x01ef:
            r6 = 0
            int r3 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r3 == 0) goto L_0x01ff
            okio.Buffer r3 = r4.clone()
            java.lang.String r2 = r3.readString(r2)
            r5.responseBody = r2
        L_0x01ff:
            com.tal.app.thinkacademy.lib.network.logging.CustomHttpLoggingInterceptor$Logger r2 = r1.logger
            java.lang.String r3 = r5.toString()
            r2.log(r3)
            com.tal.app.thinkacademy.lib.network.logging.CustomHttpLoggingInterceptor$Logger r2 = r1.logger
            java.lang.String r3 = r5.responseBody
            r2.log(r3)
            return r0
        L_0x0210:
            r0 = move-exception
            r2 = r0
            com.tal.app.thinkacademy.lib.network.logging.CustomHttpLoggingInterceptor$Logger r0 = r1.logger
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "<--接口请求异常"
            r3.append(r4)
            java.lang.String r4 = r2.getMessage()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r0.log(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.lib.network.logging.CustomHttpLoggingInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }

    public static boolean isPlaintext(Buffer buffer) {
        try {
            Buffer buffer2 = new Buffer();
            buffer.copyTo(buffer2, 0, buffer.size() < 64 ? buffer.size() : 64);
            for (int i = 0; i < 16; i++) {
                if (buffer2.exhausted()) {
                    return true;
                }
                int readUtf8CodePoint = buffer2.readUtf8CodePoint();
                if (Character.isISOControl(readUtf8CodePoint) && !Character.isWhitespace(readUtf8CodePoint)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    private boolean bodyHasUnknownEncoding(Headers headers) {
        String str = headers.get("Content-Encoding");
        return str != null && !str.equalsIgnoreCase("identity") && !str.equalsIgnoreCase("gzip");
    }
}
