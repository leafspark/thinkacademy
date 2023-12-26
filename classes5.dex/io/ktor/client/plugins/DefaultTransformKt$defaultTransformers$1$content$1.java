package io.ktor.client.plugins;

import io.ktor.http.ContentType;
import io.ktor.http.content.OutgoingContent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"io/ktor/client/plugins/DefaultTransformKt$defaultTransformers$1$content$1", "Lio/ktor/http/content/OutgoingContent$ByteArrayContent;", "contentLength", "", "getContentLength", "()Ljava/lang/Long;", "contentType", "Lio/ktor/http/ContentType;", "getContentType", "()Lio/ktor/http/ContentType;", "bytes", "", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DefaultTransform.kt */
public final class DefaultTransformKt$defaultTransformers$1$content$1 extends OutgoingContent.ByteArrayContent {
    final /* synthetic */ Object $body;
    private final long contentLength;
    private final ContentType contentType;

    DefaultTransformKt$defaultTransformers$1$content$1(ContentType contentType2, Object obj) {
        this.$body = obj;
        this.contentType = contentType2 == null ? ContentType.Application.INSTANCE.getOctetStream() : contentType2;
        this.contentLength = (long) ((byte[]) obj).length;
    }

    public ContentType getContentType() {
        return this.contentType;
    }

    public Long getContentLength() {
        return Long.valueOf(this.contentLength);
    }

    public byte[] bytes() {
        return (byte[]) this.$body;
    }
}
