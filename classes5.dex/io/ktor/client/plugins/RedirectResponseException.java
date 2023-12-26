package io.ktor.client.plugins;

import io.ktor.client.statement.HttpResponse;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lio/ktor/client/plugins/RedirectResponseException;", "Lio/ktor/client/plugins/ResponseException;", "response", "Lio/ktor/client/statement/HttpResponse;", "(Lio/ktor/client/statement/HttpResponse;)V", "cachedResponseText", "", "(Lio/ktor/client/statement/HttpResponse;Ljava/lang/String;)V", "message", "getMessage", "()Ljava/lang/String;", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DefaultResponseValidation.kt */
public final class RedirectResponseException extends ResponseException {
    private final String message;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RedirectResponseException(HttpResponse httpResponse, String str) {
        super(httpResponse, str);
        Intrinsics.checkNotNullParameter(httpResponse, "response");
        Intrinsics.checkNotNullParameter(str, "cachedResponseText");
        this.message = "Unhandled redirect: " + httpResponse.getCall().getRequest().getMethod().getValue() + ' ' + httpResponse.getCall().getRequest().getUrl() + ". Status: " + httpResponse.getStatus() + ". Text: \"" + str + Typography.quote;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated(level = DeprecationLevel.ERROR, message = "Please, provide response text in constructor")
    public RedirectResponseException(HttpResponse httpResponse) {
        this(httpResponse, DefaultResponseValidationKt.NO_RESPONSE_TEXT);
        Intrinsics.checkNotNullParameter(httpResponse, "response");
    }

    public String getMessage() {
        return this.message;
    }
}
