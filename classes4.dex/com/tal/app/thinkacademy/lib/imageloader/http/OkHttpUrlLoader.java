package com.tal.app.thinkacademy.lib.imageloader.http;

import com.bonree.sdk.agent.engine.external.OkHttp3Instrumentation;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J0\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/tal/app/thinkacademy/lib/imageloader/http/OkHttpUrlLoader;", "Lcom/bumptech/glide/load/model/ModelLoader;", "Lcom/bumptech/glide/load/model/GlideUrl;", "Ljava/io/InputStream;", "client", "Lokhttp3/Call$Factory;", "(Lokhttp3/Call$Factory;)V", "buildLoadData", "Lcom/bumptech/glide/load/model/ModelLoader$LoadData;", "model", "width", "", "height", "options", "Lcom/bumptech/glide/load/Options;", "handles", "", "url", "Factory", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OkHttpUrlLoader.kt */
public final class OkHttpUrlLoader implements ModelLoader<GlideUrl, InputStream> {
    private final Call.Factory client;

    public boolean handles(GlideUrl glideUrl) {
        Intrinsics.checkNotNullParameter(glideUrl, "url");
        return true;
    }

    public OkHttpUrlLoader(Call.Factory factory) {
        Intrinsics.checkNotNullParameter(factory, "client");
        this.client = factory;
    }

    public ModelLoader.LoadData<InputStream> buildLoadData(GlideUrl glideUrl, int i, int i2, Options options) {
        Intrinsics.checkNotNullParameter(glideUrl, "model");
        Intrinsics.checkNotNullParameter(options, "options");
        return new ModelLoader.LoadData<>((Key) glideUrl, new OkHttpStreamFetcher(this.client, glideUrl));
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/tal/app/thinkacademy/lib/imageloader/http/OkHttpUrlLoader$Factory;", "Lcom/bumptech/glide/load/model/ModelLoaderFactory;", "Lcom/bumptech/glide/load/model/GlideUrl;", "Ljava/io/InputStream;", "client", "Lokhttp3/Call$Factory;", "(Lokhttp3/Call$Factory;)V", "build", "Lcom/bumptech/glide/load/model/ModelLoader;", "multiFactory", "Lcom/bumptech/glide/load/model/MultiModelLoaderFactory;", "teardown", "", "Companion", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: OkHttpUrlLoader.kt */
    public static final class Factory implements ModelLoaderFactory<GlideUrl, InputStream> {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        public static volatile Call.Factory internalClient;
        private final Call.Factory client;

        public Factory() {
            this((Call.Factory) null, 1, (DefaultConstructorMarker) null);
        }

        public void teardown() {
        }

        public Factory(Call.Factory factory) {
            Intrinsics.checkNotNullParameter(factory, "client");
            this.client = factory;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ Factory(okhttp3.Call.Factory r1, int r2, kotlin.jvm.internal.DefaultConstructorMarker r3) {
            /*
                r0 = this;
                r2 = r2 & 1
                if (r2 == 0) goto L_0x000d
                com.tal.app.thinkacademy.lib.imageloader.http.OkHttpUrlLoader$Factory$Companion r1 = Companion
                okhttp3.Call$Factory r1 = r1.getInternalClient()
                kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            L_0x000d:
                r0.<init>(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.lib.imageloader.http.OkHttpUrlLoader.Factory.<init>(okhttp3.Call$Factory, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public ModelLoader<GlideUrl, InputStream> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            Intrinsics.checkNotNullParameter(multiModelLoaderFactory, "multiFactory");
            return (ModelLoader) new OkHttpUrlLoader(this.client);
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/tal/app/thinkacademy/lib/imageloader/http/OkHttpUrlLoader$Factory$Companion;", "", "()V", "internalClient", "Lokhttp3/Call$Factory;", "getInternalClient", "()Lokhttp3/Call$Factory;", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: OkHttpUrlLoader.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* access modifiers changed from: private */
            public final Call.Factory getInternalClient() {
                if (Factory.internalClient == null) {
                    synchronized (Factory.class) {
                        if (Factory.internalClient == null) {
                            Factory.internalClient = OkHttp3Instrumentation.init();
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                }
                return Factory.internalClient;
            }
        }
    }
}
