package io.ktor.http;

import io.ktor.http.HttpStatusCode;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0000\u001a\n\u0010\t\u001a\u00020\n*\u00020\u0001\"\u001f\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"ExceptionFailed", "Lio/ktor/http/HttpStatusCode;", "Lio/ktor/http/HttpStatusCode$Companion;", "getExceptionFailed$annotations", "(Lio/ktor/http/HttpStatusCode$Companion;)V", "getExceptionFailed", "(Lio/ktor/http/HttpStatusCode$Companion;)Lio/ktor/http/HttpStatusCode;", "allStatusCodes", "", "isSuccess", "", "ktor-http"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: HttpStatusCode.kt */
public final class HttpStatusCodeKt {
    @Deprecated(level = DeprecationLevel.ERROR, message = "Use ExpectationFailed instead", replaceWith = @ReplaceWith(expression = "ExpectationFailed", imports = {"io.ktor.http.HttpStatusCode.Companion.ExpectationFailed"}))
    public static /* synthetic */ void getExceptionFailed$annotations(HttpStatusCode.Companion companion) {
    }

    public static final HttpStatusCode getExceptionFailed(HttpStatusCode.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return companion.getExpectationFailed();
    }

    public static final List<HttpStatusCode> allStatusCodes() {
        return CollectionsKt.listOf(new HttpStatusCode[]{HttpStatusCode.Companion.getContinue(), HttpStatusCode.Companion.getSwitchingProtocols(), HttpStatusCode.Companion.getProcessing(), HttpStatusCode.Companion.getOK(), HttpStatusCode.Companion.getCreated(), HttpStatusCode.Companion.getAccepted(), HttpStatusCode.Companion.getNonAuthoritativeInformation(), HttpStatusCode.Companion.getNoContent(), HttpStatusCode.Companion.getResetContent(), HttpStatusCode.Companion.getPartialContent(), HttpStatusCode.Companion.getMultiStatus(), HttpStatusCode.Companion.getMultipleChoices(), HttpStatusCode.Companion.getMovedPermanently(), HttpStatusCode.Companion.getFound(), HttpStatusCode.Companion.getSeeOther(), HttpStatusCode.Companion.getNotModified(), HttpStatusCode.Companion.getUseProxy(), HttpStatusCode.Companion.getSwitchProxy(), HttpStatusCode.Companion.getTemporaryRedirect(), HttpStatusCode.Companion.getPermanentRedirect(), HttpStatusCode.Companion.getBadRequest(), HttpStatusCode.Companion.getUnauthorized(), HttpStatusCode.Companion.getPaymentRequired(), HttpStatusCode.Companion.getForbidden(), HttpStatusCode.Companion.getNotFound(), HttpStatusCode.Companion.getMethodNotAllowed(), HttpStatusCode.Companion.getNotAcceptable(), HttpStatusCode.Companion.getProxyAuthenticationRequired(), HttpStatusCode.Companion.getRequestTimeout(), HttpStatusCode.Companion.getConflict(), HttpStatusCode.Companion.getGone(), HttpStatusCode.Companion.getLengthRequired(), HttpStatusCode.Companion.getPreconditionFailed(), HttpStatusCode.Companion.getPayloadTooLarge(), HttpStatusCode.Companion.getRequestURITooLong(), HttpStatusCode.Companion.getUnsupportedMediaType(), HttpStatusCode.Companion.getRequestedRangeNotSatisfiable(), HttpStatusCode.Companion.getExpectationFailed(), HttpStatusCode.Companion.getUnprocessableEntity(), HttpStatusCode.Companion.getLocked(), HttpStatusCode.Companion.getFailedDependency(), HttpStatusCode.Companion.getUpgradeRequired(), HttpStatusCode.Companion.getTooManyRequests(), HttpStatusCode.Companion.getRequestHeaderFieldTooLarge(), HttpStatusCode.Companion.getInternalServerError(), HttpStatusCode.Companion.getNotImplemented(), HttpStatusCode.Companion.getBadGateway(), HttpStatusCode.Companion.getServiceUnavailable(), HttpStatusCode.Companion.getGatewayTimeout(), HttpStatusCode.Companion.getVersionNotSupported(), HttpStatusCode.Companion.getVariantAlsoNegotiates(), HttpStatusCode.Companion.getInsufficientStorage()});
    }

    public static final boolean isSuccess(HttpStatusCode httpStatusCode) {
        Intrinsics.checkNotNullParameter(httpStatusCode, "<this>");
        int value = httpStatusCode.getValue();
        return 200 <= value && value < 300;
    }
}
