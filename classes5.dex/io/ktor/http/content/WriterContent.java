package io.ktor.http.content;

import io.ktor.http.ContentType;
import io.ktor.http.ContentTypesKt;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.ByteWriteChannel;
import java.io.Writer;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001BQ\u0012'\u0010\u0002\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003¢\u0006\u0002\b\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0019\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001aH@ø\u0001\u0000¢\u0006\u0002\u0010\u001bR4\u0010\u0002\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003¢\u0006\u0002\b\bX\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0010R\u0018\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Lio/ktor/http/content/WriterContent;", "Lio/ktor/http/content/OutgoingContent$WriteChannelContent;", "body", "Lkotlin/Function2;", "Ljava/io/Writer;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "contentType", "Lio/ktor/http/ContentType;", "status", "Lio/ktor/http/HttpStatusCode;", "contentLength", "", "(Lkotlin/jvm/functions/Function2;Lio/ktor/http/ContentType;Lio/ktor/http/HttpStatusCode;Ljava/lang/Long;)V", "Lkotlin/jvm/functions/Function2;", "getContentLength", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getContentType", "()Lio/ktor/http/ContentType;", "getStatus", "()Lio/ktor/http/HttpStatusCode;", "writeTo", "channel", "Lio/ktor/utils/io/ByteWriteChannel;", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WriterContent.kt */
public final class WriterContent extends OutgoingContent.WriteChannelContent {
    /* access modifiers changed from: private */
    public final Function2<Writer, Continuation<? super Unit>, Object> body;
    private final Long contentLength;
    private final ContentType contentType;
    private final HttpStatusCode status;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WriterContent(Function2 function2, ContentType contentType2, HttpStatusCode httpStatusCode, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function2, contentType2, (i & 4) != 0 ? null : httpStatusCode, (i & 8) != 0 ? null : l);
    }

    public ContentType getContentType() {
        return this.contentType;
    }

    public HttpStatusCode getStatus() {
        return this.status;
    }

    public Long getContentLength() {
        return this.contentLength;
    }

    public WriterContent(Function2<? super Writer, ? super Continuation<? super Unit>, ? extends Object> function2, ContentType contentType2, HttpStatusCode httpStatusCode, Long l) {
        Intrinsics.checkNotNullParameter(function2, "body");
        Intrinsics.checkNotNullParameter(contentType2, "contentType");
        this.body = function2;
        this.contentType = contentType2;
        this.status = httpStatusCode;
        this.contentLength = l;
    }

    public Object writeTo(ByteWriteChannel byteWriteChannel, Continuation<? super Unit> continuation) {
        Charset charset = ContentTypesKt.charset(getContentType());
        if (charset == null) {
            charset = Charsets.UTF_8;
        }
        Object withBlocking = BlockingBridgeKt.withBlocking(new WriterContent$writeTo$2(byteWriteChannel, charset, this, (Continuation<? super WriterContent$writeTo$2>) null), continuation);
        return withBlocking == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withBlocking : Unit.INSTANCE;
    }
}
