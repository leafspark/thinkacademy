package com.tal.app.thinkacademy.lib.imageloader.progress;

import android.os.Handler;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ForwardingSource;
import okio.Source;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007¨\u0006\u000f"}, d2 = {"com/tal/app/thinkacademy/lib/imageloader/progress/ProgressResponseBody$source$1", "Lokio/ForwardingSource;", "lastTotalBytesRead", "", "getLastTotalBytesRead", "()J", "setLastTotalBytesRead", "(J)V", "totalBytesRead", "getTotalBytesRead", "setTotalBytesRead", "read", "sink", "Lokio/Buffer;", "byteCount", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ProgressResponseBody.kt */
public final class ProgressResponseBody$source$1 extends ForwardingSource {
    final /* synthetic */ Source $source;
    private long lastTotalBytesRead;
    final /* synthetic */ ProgressResponseBody this$0;
    private long totalBytesRead;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProgressResponseBody$source$1(Source source, ProgressResponseBody progressResponseBody) {
        super(source);
        this.$source = source;
        this.this$0 = progressResponseBody;
    }

    public final long getTotalBytesRead() {
        return this.totalBytesRead;
    }

    public final void setTotalBytesRead(long j) {
        this.totalBytesRead = j;
    }

    public final long getLastTotalBytesRead() {
        return this.lastTotalBytesRead;
    }

    public final void setLastTotalBytesRead(long j) {
        this.lastTotalBytesRead = j;
    }

    public long read(Buffer buffer, long j) throws IOException {
        Intrinsics.checkNotNullParameter(buffer, "sink");
        long read = ProgressResponseBody$source$1.super.read(buffer, j);
        this.totalBytesRead += read == -1 ? 0 : read;
        if (this.this$0.internalProgressListener != null) {
            long j2 = this.lastTotalBytesRead;
            long j3 = this.totalBytesRead;
            if (j2 != j3) {
                this.lastTotalBytesRead = j3;
                Handler access$getMainThreadHandler$cp = ProgressResponseBody.mainThreadHandler;
                ProgressResponseBody$source$1$$ExternalSyntheticLambda0 progressResponseBody$source$1$$ExternalSyntheticLambda0 = new ProgressResponseBody$source$1$$ExternalSyntheticLambda0(this.this$0, this);
                if (!(access$getMainThreadHandler$cp instanceof Handler)) {
                    access$getMainThreadHandler$cp.post(progressResponseBody$source$1$$ExternalSyntheticLambda0);
                } else {
                    AsynchronousInstrumentation.handlerPost(access$getMainThreadHandler$cp, progressResponseBody$source$1$$ExternalSyntheticLambda0);
                }
            }
        }
        return read;
    }

    /* access modifiers changed from: private */
    /* renamed from: read$lambda-0  reason: not valid java name */
    public static final void m89read$lambda0(ProgressResponseBody progressResponseBody, ProgressResponseBody$source$1 progressResponseBody$source$1) {
        Intrinsics.checkNotNullParameter(progressResponseBody, "this$0");
        Intrinsics.checkNotNullParameter(progressResponseBody$source$1, "this$1");
        progressResponseBody.internalProgressListener.onProgress(progressResponseBody.url, progressResponseBody$source$1.totalBytesRead, progressResponseBody.contentLength());
    }
}
