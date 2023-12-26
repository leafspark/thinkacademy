package io.ktor.client.request;

import io.ktor.util.pipeline.Pipeline;
import io.ktor.util.pipeline.PipelinePhase;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \t2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\tB\u000f\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lio/ktor/client/request/HttpRequestPipeline;", "Lio/ktor/util/pipeline/Pipeline;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "developmentMode", "", "(Z)V", "getDevelopmentMode", "()Z", "Phases", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HttpRequestPipeline.kt */
public final class HttpRequestPipeline extends Pipeline<Object, HttpRequestBuilder> {
    /* access modifiers changed from: private */
    public static final PipelinePhase Before = new PipelinePhase("Before");
    public static final Phases Phases = new Phases((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final PipelinePhase Render = new PipelinePhase("Render");
    /* access modifiers changed from: private */
    public static final PipelinePhase Send = new PipelinePhase("Send");
    /* access modifiers changed from: private */
    public static final PipelinePhase State = new PipelinePhase("State");
    /* access modifiers changed from: private */
    public static final PipelinePhase Transform = new PipelinePhase("Transform");
    private final boolean developmentMode;

    public HttpRequestPipeline() {
        this(false, 1, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HttpRequestPipeline(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }

    public boolean getDevelopmentMode() {
        return this.developmentMode;
    }

    public HttpRequestPipeline(boolean z) {
        super(Before, State, Transform, Render, Send);
        this.developmentMode = z;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, d2 = {"Lio/ktor/client/request/HttpRequestPipeline$Phases;", "", "()V", "Before", "Lio/ktor/util/pipeline/PipelinePhase;", "getBefore", "()Lio/ktor/util/pipeline/PipelinePhase;", "Render", "getRender", "Send", "getSend", "State", "getState", "Transform", "getTransform", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HttpRequestPipeline.kt */
    public static final class Phases {
        public /* synthetic */ Phases(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Phases() {
        }

        public final PipelinePhase getBefore() {
            return HttpRequestPipeline.Before;
        }

        public final PipelinePhase getState() {
            return HttpRequestPipeline.State;
        }

        public final PipelinePhase getTransform() {
            return HttpRequestPipeline.Transform;
        }

        public final PipelinePhase getRender() {
            return HttpRequestPipeline.Render;
        }

        public final PipelinePhase getSend() {
            return HttpRequestPipeline.Send;
        }
    }
}