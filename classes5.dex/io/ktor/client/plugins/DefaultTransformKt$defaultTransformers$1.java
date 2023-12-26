package io.ktor.client.plugins;

import com.yanzhenjie.andserver.util.MediaType;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.ContentType;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.content.OutgoingContent;
import io.ktor.http.content.TextContent;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H@"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "body"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$1", f = "DefaultTransform.kt", i = {}, l = {50}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DefaultTransform.kt */
final class DefaultTransformKt$defaultTransformers$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    DefaultTransformKt$defaultTransformers$1(Continuation<? super DefaultTransformKt$defaultTransformers$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation<? super Unit> continuation) {
        DefaultTransformKt$defaultTransformers$1 defaultTransformKt$defaultTransformers$1 = new DefaultTransformKt$defaultTransformers$1(continuation);
        defaultTransformKt$defaultTransformers$1.L$0 = pipelineContext;
        defaultTransformKt$defaultTransformers$1.L$1 = obj;
        return defaultTransformKt$defaultTransformers$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        OutgoingContent outgoingContent;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PipelineContext pipelineContext = (PipelineContext) this.L$0;
            Object obj2 = this.L$1;
            if (((HttpRequestBuilder) pipelineContext.getContext()).getHeaders().get(HttpHeaders.INSTANCE.getAccept()) == null) {
                ((HttpRequestBuilder) pipelineContext.getContext()).getHeaders().append(HttpHeaders.INSTANCE.getAccept(), MediaType.ALL_VALUE);
            }
            ContentType contentType = HttpMessagePropertiesKt.contentType((HttpMessageBuilder) pipelineContext.getContext());
            if (obj2 instanceof String) {
                String str = (String) obj2;
                if (contentType == null) {
                    contentType = ContentType.Text.INSTANCE.getPlain();
                }
                outgoingContent = new TextContent(str, contentType, (HttpStatusCode) null, 4, (DefaultConstructorMarker) null);
            } else if (obj2 instanceof byte[]) {
                outgoingContent = new DefaultTransformKt$defaultTransformers$1$content$1(contentType, obj2);
            } else if (obj2 instanceof ByteReadChannel) {
                outgoingContent = new DefaultTransformKt$defaultTransformers$1$content$2(pipelineContext, contentType, obj2);
            } else if (obj2 instanceof OutgoingContent) {
                outgoingContent = (OutgoingContent) obj2;
            } else {
                outgoingContent = DefaultTransformersJvmKt.platformRequestDefaultTransform(contentType, (HttpRequestBuilder) pipelineContext.getContext(), obj2);
            }
            if (outgoingContent != null) {
                ((HttpRequestBuilder) pipelineContext.getContext()).getHeaders().remove(HttpHeaders.INSTANCE.getContentType());
                this.L$0 = null;
                this.label = 1;
                if (pipelineContext.proceedWith(outgoingContent, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
