package com.bonree.sdk.agent.engine.network.cronet;

import com.bonree.sdk.n.a;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import org.chromium.net.ExperimentalCronetEngine;
import org.chromium.net.ExperimentalUrlRequest;
import org.chromium.net.RequestFinishedInfo;
import org.chromium.net.UploadDataProvider;
import org.chromium.net.UrlRequest;

public final class BrUrlRequestBuilder extends ExperimentalUrlRequest.Builder {
    private final ExperimentalUrlRequest.Builder a;
    private final RequestFinishedListener b;

    public BrUrlRequestBuilder(String str, UrlRequest.Callback callback, Executor executor, ExperimentalCronetEngine experimentalCronetEngine, a aVar) {
        a aVar2 = new a(str, callback, aVar);
        ExperimentalUrlRequest.Builder newUrlRequestBuilder = experimentalCronetEngine.newUrlRequestBuilder(str, aVar2, executor);
        this.a = newUrlRequestBuilder;
        RequestFinishedListener requestFinishedListener = new RequestFinishedListener(executor, aVar2);
        this.b = requestFinishedListener;
        newUrlRequestBuilder.setRequestFinishedListener(requestFinishedListener);
    }

    public final ExperimentalUrlRequest.Builder setHttpMethod(String str) {
        this.a.setHttpMethod(str);
        return this;
    }

    public final BrUrlRequestBuilder addHeader(String str, String str2) {
        this.a.addHeader(str, str2);
        return this;
    }

    public final BrUrlRequestBuilder disableCache() {
        this.a.disableCache();
        return this;
    }

    public final BrUrlRequestBuilder disableConnectionMigration() {
        this.a.disableConnectionMigration();
        return this;
    }

    public final BrUrlRequestBuilder setPriority(int i) {
        this.a.setPriority(i);
        return this;
    }

    public final BrUrlRequestBuilder setUploadDataProvider(UploadDataProvider uploadDataProvider, Executor executor) {
        this.a.setUploadDataProvider(uploadDataProvider, executor);
        return this;
    }

    public final BrUrlRequestBuilder allowDirectExecutor() {
        this.a.allowDirectExecutor();
        return this;
    }

    public final BrUrlRequestBuilder addRequestAnnotation(Object obj) {
        this.a.addRequestAnnotation(obj);
        return this;
    }

    public final BrUrlRequestBuilder setTrafficStatsTag(int i) {
        this.a.setTrafficStatsTag(i);
        return this;
    }

    public final BrUrlRequestBuilder setTrafficStatsUid(int i) {
        this.a.setTrafficStatsUid(i);
        return this;
    }

    public final BrUrlRequestBuilder setRequestFinishedListener(RequestFinishedInfo.Listener listener) {
        this.b.setRequestFinishedListener(listener);
        return this;
    }

    public final ExperimentalUrlRequest build() {
        return this.a.build();
    }

    private static class RequestFinishedListener extends RequestFinishedInfo.Listener {
        private a a;
        private WeakReference<RequestFinishedInfo.Listener> b;

        public RequestFinishedListener(Executor executor, a aVar) {
            super(executor);
            this.a = aVar;
        }

        public void setRequestFinishedListener(RequestFinishedInfo.Listener listener) {
            this.b = new WeakReference<>(listener);
        }

        public void onRequestFinished(RequestFinishedInfo requestFinishedInfo) {
            this.a.onFinished(requestFinishedInfo);
            WeakReference<RequestFinishedInfo.Listener> weakReference = this.b;
            if (weakReference != null && weakReference.get() != null) {
                ((RequestFinishedInfo.Listener) this.b.get()).onRequestFinished(requestFinishedInfo);
            }
        }

        public Executor getExecutor() {
            WeakReference<RequestFinishedInfo.Listener> weakReference = this.b;
            if (weakReference == null || weakReference.get() == null) {
                return BrUrlRequestBuilder.super.getExecutor();
            }
            return ((RequestFinishedInfo.Listener) this.b.get()).getExecutor();
        }
    }
}
