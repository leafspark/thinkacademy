package com.tal.app.thinkacademy.lib.imageloader.http;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.util.ContentLengthInputStream;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001 B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J \u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00192\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\fH\u0016J\u0018\u0010\u001a\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u000b\u001a\f\u0012\u0006\b\u0000\u0012\u00020\u0002\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/tal/app/thinkacademy/lib/imageloader/http/OkHttpStreamFetcher;", "Lcom/bumptech/glide/load/data/DataFetcher;", "Ljava/io/InputStream;", "Lokhttp3/Callback;", "client", "Lokhttp3/Call$Factory;", "url", "Lcom/bumptech/glide/load/model/GlideUrl;", "(Lokhttp3/Call$Factory;Lcom/bumptech/glide/load/model/GlideUrl;)V", "call", "Lokhttp3/Call;", "callback", "Lcom/bumptech/glide/load/data/DataFetcher$DataCallback;", "responseBody", "Lokhttp3/ResponseBody;", "stream", "cancel", "", "cleanup", "getDataClass", "Ljava/lang/Class;", "getDataSource", "Lcom/bumptech/glide/load/DataSource;", "loadData", "priority", "Lcom/bumptech/glide/Priority;", "onFailure", "e", "Ljava/io/IOException;", "onResponse", "response", "Lokhttp3/Response;", "Companion", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OkHttpStreamFetcher.kt */
public final class OkHttpStreamFetcher implements DataFetcher<InputStream>, Callback {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "OkHttpFetcher";
    private volatile Call call;
    private DataFetcher.DataCallback<? super InputStream> callback;
    private final Call.Factory client;
    private ResponseBody responseBody;
    private InputStream stream;
    private final GlideUrl url;

    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    public OkHttpStreamFetcher(Call.Factory factory, GlideUrl glideUrl) {
        Intrinsics.checkNotNullParameter(factory, "client");
        Intrinsics.checkNotNullParameter(glideUrl, "url");
        this.client = factory;
        this.url = glideUrl;
    }

    public void loadData(Priority priority, DataFetcher.DataCallback<? super InputStream> dataCallback) {
        Intrinsics.checkNotNullParameter(priority, "priority");
        Intrinsics.checkNotNullParameter(dataCallback, "callback");
        Request.Builder builder = new Request.Builder();
        String stringUrl = this.url.toStringUrl();
        Intrinsics.checkNotNullExpressionValue(stringUrl, "url.toStringUrl()");
        Request.Builder url2 = builder.url(stringUrl);
        Map headers = this.url.getHeaders();
        Intrinsics.checkNotNullExpressionValue(headers, "url.headers");
        for (Map.Entry entry : headers.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            Intrinsics.checkNotNullExpressionValue(str, "key");
            Intrinsics.checkNotNullExpressionValue(str2, "value");
            url2.addHeader(str, str2);
        }
        Request build = url2.build();
        this.callback = dataCallback;
        this.call = this.client.newCall(build);
        Call call2 = this.call;
        if (call2 != null) {
            call2.enqueue((Callback) this);
        }
    }

    public void onFailure(Call call2, IOException iOException) {
        Intrinsics.checkNotNullParameter(call2, "call");
        Intrinsics.checkNotNullParameter(iOException, "e");
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "OkHttp failed to obtain result", iOException);
        }
        DataFetcher.DataCallback<? super InputStream> dataCallback = this.callback;
        Intrinsics.checkNotNull(dataCallback);
        dataCallback.onLoadFailed(iOException);
    }

    public void onResponse(Call call2, Response response) {
        Intrinsics.checkNotNullParameter(call2, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        this.responseBody = response.body();
        if (response.isSuccessful()) {
            long contentLength = ((ResponseBody) Preconditions.checkNotNull(this.responseBody)).contentLength();
            ResponseBody responseBody2 = this.responseBody;
            Intrinsics.checkNotNull(responseBody2);
            this.stream = ContentLengthInputStream.obtain(responseBody2.byteStream(), contentLength);
            DataFetcher.DataCallback<? super InputStream> dataCallback = this.callback;
            Intrinsics.checkNotNull(dataCallback);
            dataCallback.onDataReady(this.stream);
            return;
        }
        DataFetcher.DataCallback<? super InputStream> dataCallback2 = this.callback;
        Intrinsics.checkNotNull(dataCallback2);
        dataCallback2.onLoadFailed(new HttpException(response.message(), response.code()));
    }

    public void cleanup() {
        try {
            InputStream inputStream = this.stream;
            if (inputStream != null) {
                Intrinsics.checkNotNull(inputStream);
                inputStream.close();
            }
        } catch (IOException unused) {
        }
        ResponseBody responseBody2 = this.responseBody;
        if (responseBody2 != null) {
            Intrinsics.checkNotNull(responseBody2);
            responseBody2.close();
        }
        this.callback = null;
    }

    public void cancel() {
        Call call2 = this.call;
        if (call2 != null) {
            call2.cancel();
        }
    }

    public DataSource getDataSource() {
        return DataSource.REMOTE;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/lib/imageloader/http/OkHttpStreamFetcher$Companion;", "", "()V", "TAG", "", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: OkHttpStreamFetcher.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
