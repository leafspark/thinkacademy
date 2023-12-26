package com.eaydu.omni.utils;

import android.util.Log;
import com.eaydu.omni.net.okhttp3.MediaType;
import com.eaydu.omni.net.okhttp3.RequestBody;
import com.eaydu.omni.net.okhttp3.internal.Util;
import com.eaydu.omni.net.okio.BufferedSink;
import com.eaydu.omni.net.okio.Source;
import com.huawei.multimedia.audiokit.config.ResultCode;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

public class RateLimitingRequestBody extends RequestBody {
    private MediaType mContentType;
    private File mFile;
    private int mMaxRate;

    private RateLimitingRequestBody(MediaType mediaType, File file, int i) {
        this.mContentType = mediaType;
        this.mFile = file;
        this.mMaxRate = i;
    }

    public MediaType contentType() {
        return this.mContentType;
    }

    public void writeTo(BufferedSink bufferedSink) throws IOException {
        Source source = null;
        try {
            Source source2 = (Source) Class.forName("okio.Okio").getMethod("source", new Class[]{File.class}).invoke((Object) null, new Object[]{this.mFile});
            try {
                writeAll(bufferedSink, source2);
                Util.closeQuietly((Closeable) source2);
            } catch (InterruptedException e) {
                e = e;
                source = source2;
                Log.e("RateLimitingRequestBody", e.toString());
                Util.closeQuietly((Closeable) source);
            } catch (NoSuchMethodException e2) {
                e = e2;
                source = source2;
                Log.e("RateLimitingRequestBody", e.toString());
                Util.closeQuietly((Closeable) source);
            } catch (IllegalAccessException e3) {
                e = e3;
                source = source2;
                Log.e("RateLimitingRequestBody", e.toString());
                Util.closeQuietly((Closeable) source);
            } catch (InvocationTargetException e4) {
                e = e4;
                source = source2;
                Log.e("RateLimitingRequestBody", e.toString());
                Util.closeQuietly((Closeable) source);
            } catch (ClassNotFoundException e5) {
                e = e5;
                source = source2;
                Log.e("RateLimitingRequestBody", e.toString());
                Util.closeQuietly((Closeable) source);
            } catch (Throwable th) {
                th = th;
                source = source2;
                Util.closeQuietly((Closeable) source);
                throw th;
            }
        } catch (InterruptedException e6) {
            e = e6;
            Log.e("RateLimitingRequestBody", e.toString());
            Util.closeQuietly((Closeable) source);
        } catch (NoSuchMethodException e7) {
            e = e7;
            Log.e("RateLimitingRequestBody", e.toString());
            Util.closeQuietly((Closeable) source);
        } catch (IllegalAccessException e8) {
            e = e8;
            Log.e("RateLimitingRequestBody", e.toString());
            Util.closeQuietly((Closeable) source);
        } catch (InvocationTargetException e9) {
            e = e9;
            Log.e("RateLimitingRequestBody", e.toString());
            Util.closeQuietly((Closeable) source);
        } catch (ClassNotFoundException e10) {
            e = e10;
            Log.e("RateLimitingRequestBody", e.toString());
            Util.closeQuietly((Closeable) source);
        } catch (Throwable th2) {
            th = th2;
            Util.closeQuietly((Closeable) source);
            throw th;
        }
    }

    public long writeAll(BufferedSink bufferedSink, Source source) throws IOException, InterruptedException {
        if (source != null) {
            long j = 0;
            long currentTimeMillis = System.currentTimeMillis();
            while (true) {
                long read = source.read(bufferedSink.buffer(), 8192);
                if (read == -1) {
                    return j;
                }
                j += read;
                bufferedSink.emitCompleteSegments();
                long currentTimeMillis2 = System.currentTimeMillis();
                if (currentTimeMillis2 != currentTimeMillis) {
                    long j2 = 8 * j;
                    long j3 = currentTimeMillis2 - currentTimeMillis;
                    int i = this.mMaxRate;
                    if (j2 / j3 > ((long) (i / ResultCode.KARAOKE_SUCCESS))) {
                        Thread.sleep((long) (((int) (((j2 * 1000) / ((long) i)) - j3)) + 50));
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    public static RequestBody createRequestBody(MediaType mediaType, File file, int i) {
        Objects.requireNonNull(file, "content == null");
        return new RateLimitingRequestBody(mediaType, file, i);
    }
}
