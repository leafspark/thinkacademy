package io.ktor.http.content;

import io.ktor.http.ContentType;
import io.ktor.http.Headers;
import io.ktor.http.HttpStatusCode;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import io.ktor.util.AttributesJvmKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.CoroutinesKt;
import io.ktor.utils.io.WriterScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongRange;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u001f !\"#B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J'\u0010\u0015\u001a\u0004\u0018\u0001H\u0016\"\b\b\u0000\u0010\u0016*\u00020\u00012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0018H\u0016¢\u0006\u0002\u0010\u0019J/\u0010\u001a\u001a\u00020\u001b\"\b\b\u0000\u0010\u0016*\u00020\u00012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u00182\b\u0010\u001c\u001a\u0004\u0018\u0001H\u0016H\u0016¢\u0006\u0002\u0010\u001dJ\n\u0010\u001e\u001a\u0004\u0018\u00010\u000eH\u0016R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00128VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u0001\u0005$%&'(¨\u0006)"}, d2 = {"Lio/ktor/http/content/OutgoingContent;", "", "()V", "contentLength", "", "getContentLength", "()Ljava/lang/Long;", "contentType", "Lio/ktor/http/ContentType;", "getContentType", "()Lio/ktor/http/ContentType;", "extensionProperties", "Lio/ktor/util/Attributes;", "headers", "Lio/ktor/http/Headers;", "getHeaders", "()Lio/ktor/http/Headers;", "status", "Lio/ktor/http/HttpStatusCode;", "getStatus", "()Lio/ktor/http/HttpStatusCode;", "getProperty", "T", "key", "Lio/ktor/util/AttributeKey;", "(Lio/ktor/util/AttributeKey;)Ljava/lang/Object;", "setProperty", "", "value", "(Lio/ktor/util/AttributeKey;Ljava/lang/Object;)V", "trailers", "ByteArrayContent", "NoContent", "ProtocolUpgrade", "ReadChannelContent", "WriteChannelContent", "Lio/ktor/http/content/OutgoingContent$NoContent;", "Lio/ktor/http/content/OutgoingContent$ReadChannelContent;", "Lio/ktor/http/content/OutgoingContent$WriteChannelContent;", "Lio/ktor/http/content/OutgoingContent$ByteArrayContent;", "Lio/ktor/http/content/OutgoingContent$ProtocolUpgrade;", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OutgoingContent.kt */
public abstract class OutgoingContent {
    private Attributes extensionProperties;

    public /* synthetic */ OutgoingContent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public Long getContentLength() {
        return null;
    }

    public ContentType getContentType() {
        return null;
    }

    public HttpStatusCode getStatus() {
        return null;
    }

    public Headers trailers() {
        return null;
    }

    private OutgoingContent() {
    }

    public Headers getHeaders() {
        return Headers.Companion.getEmpty();
    }

    public <T> T getProperty(AttributeKey<T> attributeKey) {
        Intrinsics.checkNotNullParameter(attributeKey, "key");
        Attributes attributes = this.extensionProperties;
        if (attributes != null) {
            return attributes.getOrNull(attributeKey);
        }
        return null;
    }

    public <T> void setProperty(AttributeKey<T> attributeKey, T t) {
        Intrinsics.checkNotNullParameter(attributeKey, "key");
        if (t != null || this.extensionProperties != null) {
            if (t == null) {
                Attributes attributes = this.extensionProperties;
                if (attributes != null) {
                    attributes.remove(attributeKey);
                    return;
                }
                return;
            }
            Attributes attributes2 = this.extensionProperties;
            if (attributes2 == null) {
                attributes2 = AttributesJvmKt.Attributes$default(false, 1, (Object) null);
            }
            this.extensionProperties = attributes2;
            attributes2.put(attributeKey, t);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lio/ktor/http/content/OutgoingContent$NoContent;", "Lio/ktor/http/content/OutgoingContent;", "()V", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: OutgoingContent.kt */
    public static abstract class NoContent extends OutgoingContent {
        public NoContent() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lio/ktor/http/content/OutgoingContent$ReadChannelContent;", "Lio/ktor/http/content/OutgoingContent;", "()V", "readFrom", "Lio/ktor/utils/io/ByteReadChannel;", "range", "Lkotlin/ranges/LongRange;", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: OutgoingContent.kt */
    public static abstract class ReadChannelContent extends OutgoingContent {
        public abstract ByteReadChannel readFrom();

        public ReadChannelContent() {
            super((DefaultConstructorMarker) null);
        }

        public ByteReadChannel readFrom(LongRange longRange) {
            Intrinsics.checkNotNullParameter(longRange, "range");
            if (longRange.isEmpty()) {
                return ByteReadChannel.Companion.getEmpty();
            }
            return CoroutinesKt.writer((CoroutineScope) GlobalScope.INSTANCE, Dispatchers.getUnconfined(), true, (Function2<? super WriterScope, ? super Continuation<? super Unit>, ? extends Object>) new OutgoingContent$ReadChannelContent$readFrom$1(this, longRange, (Continuation<? super OutgoingContent$ReadChannelContent$readFrom$1>) null)).getChannel();
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"Lio/ktor/http/content/OutgoingContent$WriteChannelContent;", "Lio/ktor/http/content/OutgoingContent;", "()V", "writeTo", "", "channel", "Lio/ktor/utils/io/ByteWriteChannel;", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: OutgoingContent.kt */
    public static abstract class WriteChannelContent extends OutgoingContent {
        public abstract Object writeTo(ByteWriteChannel byteWriteChannel, Continuation<? super Unit> continuation);

        public WriteChannelContent() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&¨\u0006\u0005"}, d2 = {"Lio/ktor/http/content/OutgoingContent$ByteArrayContent;", "Lio/ktor/http/content/OutgoingContent;", "()V", "bytes", "", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: OutgoingContent.kt */
    public static abstract class ByteArrayContent extends OutgoingContent {
        public abstract byte[] bytes();

        public ByteArrayContent() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J1\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0010R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lio/ktor/http/content/OutgoingContent$ProtocolUpgrade;", "Lio/ktor/http/content/OutgoingContent;", "()V", "status", "Lio/ktor/http/HttpStatusCode;", "getStatus", "()Lio/ktor/http/HttpStatusCode;", "upgrade", "Lkotlinx/coroutines/Job;", "input", "Lio/ktor/utils/io/ByteReadChannel;", "output", "Lio/ktor/utils/io/ByteWriteChannel;", "engineContext", "Lkotlin/coroutines/CoroutineContext;", "userContext", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: OutgoingContent.kt */
    public static abstract class ProtocolUpgrade extends OutgoingContent {
        public abstract Object upgrade(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, Continuation<? super Job> continuation);

        public ProtocolUpgrade() {
            super((DefaultConstructorMarker) null);
        }

        public final HttpStatusCode getStatus() {
            return HttpStatusCode.Companion.getSwitchingProtocols();
        }
    }
}
