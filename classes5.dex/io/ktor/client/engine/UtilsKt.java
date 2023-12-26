package io.ktor.client.engine;

import io.ktor.client.utils.HeadersKt;
import io.ktor.http.ContentType;
import io.ktor.http.Headers;
import io.ktor.http.HttpHeaders;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.InternalAPI;
import io.ktor.util.PlatformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\u001a\u0019\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tHHø\u0001\u0000¢\u0006\u0002\u0010\n\u001a\u0011\u0010\u000b\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\r\u001aP\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u001226\u0010\u0013\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00070\u0014H\u0007\u001a\b\u0010\u0019\u001a\u00020\u001aH\u0002\"\u001c\u0010\u0000\u001a\u00020\u00018\u0006XD¢\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"KTOR_DEFAULT_USER_AGENT", "", "getKTOR_DEFAULT_USER_AGENT$annotations", "()V", "getKTOR_DEFAULT_USER_AGENT", "()Ljava/lang/String;", "attachToUserJob", "", "callJob", "Lkotlinx/coroutines/Job;", "(Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callContext", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mergeHeaders", "requestHeaders", "Lio/ktor/http/Headers;", "content", "Lio/ktor/http/content/OutgoingContent;", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "key", "value", "needUserAgent", "", "ktor-client-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Utils.kt */
public final class UtilsKt {
    private static final String KTOR_DEFAULT_USER_AGENT = "Ktor client";

    @InternalAPI
    public static /* synthetic */ void getKTOR_DEFAULT_USER_AGENT$annotations() {
    }

    public static final String getKTOR_DEFAULT_USER_AGENT() {
        return KTOR_DEFAULT_USER_AGENT;
    }

    @InternalAPI
    public static final void mergeHeaders(Headers headers, OutgoingContent outgoingContent, Function2<? super String, ? super String, Unit> function2) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(headers, "requestHeaders");
        Intrinsics.checkNotNullParameter(outgoingContent, "content");
        Intrinsics.checkNotNullParameter(function2, "block");
        HeadersKt.buildHeaders(new UtilsKt$mergeHeaders$1(headers, outgoingContent)).forEach(new UtilsKt$mergeHeaders$2(function2));
        if ((headers.get(HttpHeaders.INSTANCE.getUserAgent()) == null && outgoingContent.getHeaders().get(HttpHeaders.INSTANCE.getUserAgent()) == null) && needUserAgent()) {
            function2.invoke(HttpHeaders.INSTANCE.getUserAgent(), KTOR_DEFAULT_USER_AGENT);
        }
        ContentType contentType = outgoingContent.getContentType();
        if (contentType == null || (str = contentType.toString()) == null) {
            str = outgoingContent.getHeaders().get(HttpHeaders.INSTANCE.getContentType());
        }
        Long contentLength = outgoingContent.getContentLength();
        if (contentLength == null || (str2 = contentLength.toString()) == null) {
            str2 = outgoingContent.getHeaders().get(HttpHeaders.INSTANCE.getContentLength());
        }
        if (str != null) {
            function2.invoke(HttpHeaders.INSTANCE.getContentType(), str);
        }
        if (str2 != null) {
            function2.invoke(HttpHeaders.INSTANCE.getContentLength(), str2);
        }
    }

    @InternalAPI
    public static final Object callContext(Continuation<? super CoroutineContext> continuation) {
        KtorCallContextElement ktorCallContextElement = continuation.getContext().get(KtorCallContextElement.Companion);
        Intrinsics.checkNotNull(ktorCallContextElement);
        return ktorCallContextElement.getCallContext();
    }

    public static final Object attachToUserJob(Job job, Continuation<? super Unit> continuation) {
        Job job2 = continuation.getContext().get(Job.Key);
        if (job2 == null) {
            return Unit.INSTANCE;
        }
        DisposableHandle invokeOnCompletion = job.invokeOnCompletion(new UtilsKt$attachToUserJob$2(Job.DefaultImpls.invokeOnCompletion$default(job2, true, false, new UtilsKt$attachToUserJob$cleanupHandler$1(job), 2, (Object) null)));
        if (invokeOnCompletion == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return invokeOnCompletion;
        }
        return Unit.INSTANCE;
    }

    private static final Object attachToUserJob$$forInline(Job job, Continuation<? super Unit> continuation) {
        InlineMarker.mark(3);
        Continuation continuation2 = null;
        Job job2 = continuation2.getContext().get(Job.Key);
        if (job2 == null) {
            return Unit.INSTANCE;
        }
        job.invokeOnCompletion(new UtilsKt$attachToUserJob$2(Job.DefaultImpls.invokeOnCompletion$default(job2, true, false, new UtilsKt$attachToUserJob$cleanupHandler$1(job), 2, (Object) null)));
        return Unit.INSTANCE;
    }

    private static final boolean needUserAgent() {
        return !PlatformUtils.INSTANCE.getIS_BROWSER();
    }
}
