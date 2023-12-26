package io.ktor.client.call;

import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.util.StringValuesKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006\u0012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006¢\u0006\u0002\u0010\bR\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lio/ktor/client/call/NoTransformationFoundException;", "Ljava/lang/UnsupportedOperationException;", "Lkotlin/UnsupportedOperationException;", "response", "Lio/ktor/client/statement/HttpResponse;", "from", "Lkotlin/reflect/KClass;", "to", "(Lio/ktor/client/statement/HttpResponse;Lkotlin/reflect/KClass;Lkotlin/reflect/KClass;)V", "message", "", "getMessage", "()Ljava/lang/String;", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HttpClientCall.kt */
public final class NoTransformationFoundException extends UnsupportedOperationException {
    private final String message;

    public NoTransformationFoundException(HttpResponse httpResponse, KClass<?> kClass, KClass<?> kClass2) {
        Intrinsics.checkNotNullParameter(httpResponse, "response");
        Intrinsics.checkNotNullParameter(kClass, "from");
        Intrinsics.checkNotNullParameter(kClass2, "to");
        this.message = StringsKt.trimMargin$default("No transformation found: " + kClass + " -> " + kClass2 + "\n        |with response from " + HttpResponseKt.getRequest(httpResponse).getUrl() + ":\n        |status: " + httpResponse.getStatus() + "\n        |response headers: \n        |" + CollectionsKt.joinToString$default(StringValuesKt.flattenEntries(httpResponse.getHeaders()), (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, NoTransformationFoundException$message$1.INSTANCE, 31, (Object) null) + "\n    ", (String) null, 1, (Object) null);
    }

    public String getMessage() {
        return this.message;
    }
}
