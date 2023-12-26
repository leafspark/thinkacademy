package io.ktor.http.auth;

import io.ktor.http.HeaderValueParam;
import io.ktor.http.auth.HttpAuthHeader;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lio/ktor/http/HeaderValueParam;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: HttpAuthHeader.kt */
final class HttpAuthHeader$Parameterized$render$1 extends Lambda implements Function1<HeaderValueParam, CharSequence> {
    final /* synthetic */ HeaderValueEncoding $encoding;
    final /* synthetic */ HttpAuthHeader.Parameterized this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HttpAuthHeader$Parameterized$render$1(HttpAuthHeader.Parameterized parameterized, HeaderValueEncoding headerValueEncoding) {
        super(1);
        this.this$0 = parameterized;
        this.$encoding = headerValueEncoding;
    }

    public final CharSequence invoke(HeaderValueParam headerValueParam) {
        Intrinsics.checkNotNullParameter(headerValueParam, "it");
        return headerValueParam.getName() + '=' + this.this$0.encode(headerValueParam.getValue(), this.$encoding);
    }
}
