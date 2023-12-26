package io.ktor.client.utils;

import io.ktor.http.content.OutgoingContent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lio/ktor/client/utils/EmptyContent;", "Lio/ktor/http/content/OutgoingContent$NoContent;", "()V", "contentLength", "", "getContentLength", "()Ljava/lang/Long;", "toString", "", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Content.kt */
public final class EmptyContent extends OutgoingContent.NoContent {
    public static final EmptyContent INSTANCE = new EmptyContent();
    private static final long contentLength = 0;

    public String toString() {
        return "EmptyContent";
    }

    private EmptyContent() {
    }

    public Long getContentLength() {
        return Long.valueOf(contentLength);
    }
}
