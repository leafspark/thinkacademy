package io.ktor.client.engine.okhttp;

import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u000f"}, d2 = {"Lio/ktor/client/engine/okhttp/StreamRequestBody;", "Lokhttp3/RequestBody;", "contentLength", "", "block", "Lkotlin/Function0;", "Lio/ktor/utils/io/ByteReadChannel;", "(Ljava/lang/Long;Lkotlin/jvm/functions/Function0;)V", "Ljava/lang/Long;", "contentType", "Lokhttp3/MediaType;", "writeTo", "", "sink", "Lokio/BufferedSink;", "ktor-client-okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StreamRequestBody.kt */
public final class StreamRequestBody extends RequestBody {
    private final Function0<ByteReadChannel> block;
    private final Long contentLength;

    public MediaType contentType() {
        return null;
    }

    public StreamRequestBody(Long l, Function0<? extends ByteReadChannel> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        this.contentLength = l;
        this.block = function0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0029, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0025, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeTo(okio.BufferedSink r4) {
        /*
            r3 = this;
            java.lang.String r0 = "sink"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            kotlin.jvm.functions.Function0<io.ktor.utils.io.ByteReadChannel> r0 = r3.block
            java.lang.Object r0 = r0.invoke()
            io.ktor.utils.io.ByteReadChannel r0 = (io.ktor.utils.io.ByteReadChannel) r0
            r1 = 0
            r2 = 1
            java.io.InputStream r0 = io.ktor.utils.io.jvm.javaio.BlockingKt.toInputStream$default(r0, r1, r2, r1)
            okio.Source r0 = okio.Okio.source(r0)
            java.io.Closeable r0 = (java.io.Closeable) r0
            r2 = r0
            okio.Source r2 = (okio.Source) r2     // Catch:{ all -> 0x0023 }
            r4.writeAll(r2)     // Catch:{ all -> 0x0023 }
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            return
        L_0x0023:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0025 }
        L_0x0025:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r4)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.engine.okhttp.StreamRequestBody.writeTo(okio.BufferedSink):void");
    }

    public long contentLength() {
        Long l = this.contentLength;
        if (l != null) {
            return l.longValue();
        }
        return -1;
    }
}
