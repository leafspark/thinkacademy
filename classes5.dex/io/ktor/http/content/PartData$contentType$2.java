package io.ktor.http.content;

import io.ktor.http.ContentType;
import io.ktor.http.HttpHeaders;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lio/ktor/http/ContentType;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Multipart.kt */
final class PartData$contentType$2 extends Lambda implements Function0<ContentType> {
    final /* synthetic */ PartData this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PartData$contentType$2(PartData partData) {
        super(0);
        this.this$0 = partData;
    }

    public final ContentType invoke() {
        String str = this.this$0.getHeaders().get(HttpHeaders.INSTANCE.getContentType());
        if (str != null) {
            return ContentType.Companion.parse(str);
        }
        return null;
    }
}
