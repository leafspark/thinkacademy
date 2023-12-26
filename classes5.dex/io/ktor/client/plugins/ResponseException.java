package io.ktor.client.plugins;

import io.ktor.client.statement.HttpResponse;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0016\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lio/ktor/client/plugins/ResponseException;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "response", "Lio/ktor/client/statement/HttpResponse;", "(Lio/ktor/client/statement/HttpResponse;)V", "cachedResponseText", "", "(Lio/ktor/client/statement/HttpResponse;Ljava/lang/String;)V", "getResponse", "()Lio/ktor/client/statement/HttpResponse;", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DefaultResponseValidation.kt */
public class ResponseException extends IllegalStateException {
    private final transient HttpResponse response;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ResponseException(HttpResponse httpResponse, String str) {
        super("Bad response: " + httpResponse + ". Text: \"" + str + Typography.quote);
        Intrinsics.checkNotNullParameter(httpResponse, "response");
        Intrinsics.checkNotNullParameter(str, "cachedResponseText");
        this.response = httpResponse;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated(level = DeprecationLevel.ERROR, message = "Please, provide response text in constructor")
    public ResponseException(HttpResponse httpResponse) {
        this(httpResponse, DefaultResponseValidationKt.NO_RESPONSE_TEXT);
        Intrinsics.checkNotNullParameter(httpResponse, "response");
    }

    public final HttpResponse getResponse() {
        return this.response;
    }
}
