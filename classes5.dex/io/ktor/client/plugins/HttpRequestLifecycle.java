package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.util.AttributeKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lio/ktor/client/plugins/HttpRequestLifecycle;", "", "()V", "Plugin", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HttpRequestLifecycle.kt */
public final class HttpRequestLifecycle {
    public static final Plugin Plugin = new Plugin((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final AttributeKey<HttpRequestLifecycle> key = new AttributeKey<>("RequestLifecycle");

    public /* synthetic */ HttpRequestLifecycle(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private HttpRequestLifecycle() {
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0016J!\u0010\r\u001a\u00020\u00032\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000f¢\u0006\u0002\b\u0010H\u0016R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lio/ktor/client/plugins/HttpRequestLifecycle$Plugin;", "Lio/ktor/client/plugins/HttpClientPlugin;", "", "Lio/ktor/client/plugins/HttpRequestLifecycle;", "()V", "key", "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "install", "plugin", "scope", "Lio/ktor/client/HttpClient;", "prepare", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HttpRequestLifecycle.kt */
    public static final class Plugin implements HttpClientPlugin<Unit, HttpRequestLifecycle> {
        public /* synthetic */ Plugin(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Plugin() {
        }

        public AttributeKey<HttpRequestLifecycle> getKey() {
            return HttpRequestLifecycle.key;
        }

        public HttpRequestLifecycle prepare(Function1<? super Unit, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            return new HttpRequestLifecycle((DefaultConstructorMarker) null);
        }

        public void install(HttpRequestLifecycle httpRequestLifecycle, HttpClient httpClient) {
            Intrinsics.checkNotNullParameter(httpRequestLifecycle, "plugin");
            Intrinsics.checkNotNullParameter(httpClient, "scope");
            httpClient.getRequestPipeline().intercept(HttpRequestPipeline.Phases.getBefore(), new HttpRequestLifecycle$Plugin$install$1(httpClient, (Continuation<? super HttpRequestLifecycle$Plugin$install$1>) null));
        }
    }
}
