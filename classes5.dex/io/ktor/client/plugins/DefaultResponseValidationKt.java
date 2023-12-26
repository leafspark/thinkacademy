package io.ktor.client.plugins;

import io.ktor.client.HttpClientConfig;
import io.ktor.util.AttributeKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0006\u001a\u00020\u0005*\u0006\u0012\u0002\b\u00030\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"DEPRECATED_EXCEPTION_CTOR", "", "NO_RESPONSE_TEXT", "ValidateMark", "Lio/ktor/util/AttributeKey;", "", "addDefaultResponseValidation", "Lio/ktor/client/HttpClientConfig;", "ktor-client-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: DefaultResponseValidation.kt */
public final class DefaultResponseValidationKt {
    public static final String DEPRECATED_EXCEPTION_CTOR = "Please, provide response text in constructor";
    public static final String NO_RESPONSE_TEXT = "<no response text provided>";
    /* access modifiers changed from: private */
    public static final AttributeKey<Unit> ValidateMark = new AttributeKey<>("ValidateMark");

    public static final void addDefaultResponseValidation(HttpClientConfig<?> httpClientConfig) {
        Intrinsics.checkNotNullParameter(httpClientConfig, "<this>");
        HttpCallValidatorKt.HttpResponseValidator(httpClientConfig, new DefaultResponseValidationKt$addDefaultResponseValidation$1(httpClientConfig));
    }
}
