package io.ktor.client.content;

import io.ktor.client.call.UnsupportedContentTypeException;
import io.ktor.client.utils.ByteChannelUtilsKt;
import io.ktor.http.ContentType;
import io.ktor.http.Headers;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.AttributeKey;
import io.ktor.utils.io.ByteChannelCtorKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.CoroutinesKt;
import io.ktor.utils.io.WriterScope;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B`\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012F\u0010\u0006\u001aB\b\u0001\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0010J'\u0010%\u001a\u0004\u0018\u0001H&\"\b\b\u0000\u0010&*\u00020\u000f2\f\u0010'\u001a\b\u0012\u0004\u0012\u0002H&0(H\u0016¢\u0006\u0002\u0010)J\b\u0010*\u001a\u00020\u0012H\u0016J/\u0010+\u001a\u00020\u000e\"\b\b\u0000\u0010&*\u00020\u000f2\f\u0010'\u001a\b\u0012\u0004\u0012\u0002H&0(2\b\u0010,\u001a\u0004\u0018\u0001H&H\u0016¢\u0006\u0002\u0010-R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0014R\u0016\u0010\f\u001a\u0004\u0018\u00010\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00188VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001b\u0010\u0014R\u0014\u0010\u001c\u001a\u00020\u001d8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fRS\u0010\u0006\u001aB\b\u0001\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0007X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010 R\u0016\u0010!\u001a\u0004\u0018\u00010\"8VX\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$\u0002\u0004\n\u0002\b\u0019¨\u0006."}, d2 = {"Lio/ktor/client/content/ObservableContent;", "Lio/ktor/http/content/OutgoingContent$ReadChannelContent;", "delegate", "Lio/ktor/http/content/OutgoingContent;", "callContext", "Lkotlin/coroutines/CoroutineContext;", "listener", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "bytesSentTotal", "contentLength", "Lkotlin/coroutines/Continuation;", "", "", "(Lio/ktor/http/content/OutgoingContent;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function3;)V", "content", "Lio/ktor/utils/io/ByteReadChannel;", "getContent$annotations", "()V", "getContentLength", "()Ljava/lang/Long;", "contentType", "Lio/ktor/http/ContentType;", "getContentType", "()Lio/ktor/http/ContentType;", "getDelegate$annotations", "headers", "Lio/ktor/http/Headers;", "getHeaders", "()Lio/ktor/http/Headers;", "Lkotlin/jvm/functions/Function3;", "status", "Lio/ktor/http/HttpStatusCode;", "getStatus", "()Lio/ktor/http/HttpStatusCode;", "getProperty", "T", "key", "Lio/ktor/util/AttributeKey;", "(Lio/ktor/util/AttributeKey;)Ljava/lang/Object;", "readFrom", "setProperty", "value", "(Lio/ktor/util/AttributeKey;Ljava/lang/Object;)V", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ObservableContent.kt */
public final class ObservableContent extends OutgoingContent.ReadChannelContent {
    private final CoroutineContext callContext;
    private final ByteReadChannel content;
    private final OutgoingContent delegate;
    private final Function3<Long, Long, Continuation<? super Unit>, Object> listener;

    private static /* synthetic */ void getContent$annotations() {
    }

    private static /* synthetic */ void getDelegate$annotations() {
    }

    public ObservableContent(OutgoingContent outgoingContent, CoroutineContext coroutineContext, Function3<? super Long, ? super Long, ? super Continuation<? super Unit>, ? extends Object> function3) {
        ByteReadChannel byteReadChannel;
        Intrinsics.checkNotNullParameter(outgoingContent, "delegate");
        Intrinsics.checkNotNullParameter(coroutineContext, "callContext");
        Intrinsics.checkNotNullParameter(function3, "listener");
        this.callContext = coroutineContext;
        this.listener = function3;
        if (outgoingContent instanceof OutgoingContent.ByteArrayContent) {
            byteReadChannel = ByteChannelCtorKt.ByteReadChannel(((OutgoingContent.ByteArrayContent) outgoingContent).bytes());
        } else if (outgoingContent instanceof OutgoingContent.ProtocolUpgrade) {
            throw new UnsupportedContentTypeException(outgoingContent);
        } else if (outgoingContent instanceof OutgoingContent.NoContent) {
            byteReadChannel = ByteReadChannel.Companion.getEmpty();
        } else if (outgoingContent instanceof OutgoingContent.ReadChannelContent) {
            byteReadChannel = ((OutgoingContent.ReadChannelContent) outgoingContent).readFrom();
        } else if (outgoingContent instanceof OutgoingContent.WriteChannelContent) {
            byteReadChannel = CoroutinesKt.writer((CoroutineScope) GlobalScope.INSTANCE, coroutineContext, true, (Function2<? super WriterScope, ? super Continuation<? super Unit>, ? extends Object>) new ObservableContent$content$1(outgoingContent, (Continuation<? super ObservableContent$content$1>) null)).getChannel();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        this.content = byteReadChannel;
        this.delegate = outgoingContent;
    }

    public ContentType getContentType() {
        return this.delegate.getContentType();
    }

    public Long getContentLength() {
        return this.delegate.getContentLength();
    }

    public HttpStatusCode getStatus() {
        return this.delegate.getStatus();
    }

    public Headers getHeaders() {
        return this.delegate.getHeaders();
    }

    public <T> T getProperty(AttributeKey<T> attributeKey) {
        Intrinsics.checkNotNullParameter(attributeKey, "key");
        return this.delegate.getProperty(attributeKey);
    }

    public <T> void setProperty(AttributeKey<T> attributeKey, T t) {
        Intrinsics.checkNotNullParameter(attributeKey, "key");
        this.delegate.setProperty(attributeKey, t);
    }

    public ByteReadChannel readFrom() {
        return ByteChannelUtilsKt.observable(this.content, this.callContext, getContentLength(), this.listener);
    }
}
