package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.client.statement.HttpReceivePipeline;
import io.ktor.util.AttributeKey;
import io.ktor.util.pipeline.PipelinePhase;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\b"}, d2 = {"Lio/ktor/client/plugins/BodyProgress;", "", "()V", "handle", "", "scope", "Lio/ktor/client/HttpClient;", "Plugin", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BodyProgress.kt */
public final class BodyProgress {
    public static final Plugin Plugin = new Plugin((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final AttributeKey<BodyProgress> key = new AttributeKey<>("BodyProgress");

    /* access modifiers changed from: private */
    public final void handle(HttpClient httpClient) {
        PipelinePhase pipelinePhase = new PipelinePhase("ObservableContent");
        httpClient.getRequestPipeline().insertPhaseAfter(HttpRequestPipeline.Phases.getRender(), pipelinePhase);
        httpClient.getRequestPipeline().intercept(pipelinePhase, new BodyProgress$handle$1((Continuation<? super BodyProgress$handle$1>) null));
        httpClient.getReceivePipeline().intercept(HttpReceivePipeline.Phases.getAfter(), new BodyProgress$handle$2((Continuation<? super BodyProgress$handle$2>) null));
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0016J!\u0010\r\u001a\u00020\u00032\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000f¢\u0006\u0002\b\u0010H\u0016R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lio/ktor/client/plugins/BodyProgress$Plugin;", "Lio/ktor/client/plugins/HttpClientPlugin;", "", "Lio/ktor/client/plugins/BodyProgress;", "()V", "key", "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "install", "plugin", "scope", "Lio/ktor/client/HttpClient;", "prepare", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BodyProgress.kt */
    public static final class Plugin implements HttpClientPlugin<Unit, BodyProgress> {
        public /* synthetic */ Plugin(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Plugin() {
        }

        public AttributeKey<BodyProgress> getKey() {
            return BodyProgress.key;
        }

        public BodyProgress prepare(Function1<? super Unit, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            return new BodyProgress();
        }

        public void install(BodyProgress bodyProgress, HttpClient httpClient) {
            Intrinsics.checkNotNullParameter(bodyProgress, "plugin");
            Intrinsics.checkNotNullParameter(httpClient, "scope");
            bodyProgress.handle(httpClient);
        }
    }
}
