package com.tal.app.thinkacademy.lib.imageloader.progress;

import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0002\u0010\u0011B!\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0001¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/tal/app/thinkacademy/lib/imageloader/progress/ProgressResponseBody;", "Lokhttp3/ResponseBody;", "url", "", "internalProgressListener", "Lcom/tal/app/thinkacademy/lib/imageloader/progress/ProgressResponseBody$InternalProgressListener;", "responseBody", "(Ljava/lang/String;Lcom/tal/app/thinkacademy/lib/imageloader/progress/ProgressResponseBody$InternalProgressListener;Lokhttp3/ResponseBody;)V", "bufferedSource", "Lokio/BufferedSource;", "contentLength", "", "contentType", "Lokhttp3/MediaType;", "source", "Lokio/Source;", "Companion", "InternalProgressListener", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ProgressResponseBody.kt */
public final class ProgressResponseBody extends ResponseBody {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Handler mainThreadHandler = new Handler(Looper.getMainLooper());
    private BufferedSource bufferedSource;
    /* access modifiers changed from: private */
    public final InternalProgressListener internalProgressListener;
    private final ResponseBody responseBody;
    /* access modifiers changed from: private */
    public final String url;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/tal/app/thinkacademy/lib/imageloader/progress/ProgressResponseBody$InternalProgressListener;", "", "onProgress", "", "url", "", "bytesRead", "", "totalBytes", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ProgressResponseBody.kt */
    public interface InternalProgressListener {
        void onProgress(String str, long j, long j2);
    }

    public ProgressResponseBody(String str, InternalProgressListener internalProgressListener2, ResponseBody responseBody2) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(responseBody2, "responseBody");
        this.url = str;
        this.internalProgressListener = internalProgressListener2;
        this.responseBody = responseBody2;
    }

    public MediaType contentType() {
        return this.responseBody.contentType();
    }

    public long contentLength() {
        return this.responseBody.contentLength();
    }

    public BufferedSource source() {
        if (this.bufferedSource == null) {
            this.bufferedSource = Okio.buffer(source(this.responseBody.source()));
        }
        BufferedSource bufferedSource2 = this.bufferedSource;
        Intrinsics.checkNotNull(bufferedSource2);
        return bufferedSource2;
    }

    private final Source source(Source source) {
        return new ProgressResponseBody$source$1(source, this);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/lib/imageloader/progress/ProgressResponseBody$Companion;", "", "()V", "mainThreadHandler", "Landroid/os/Handler;", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ProgressResponseBody.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
