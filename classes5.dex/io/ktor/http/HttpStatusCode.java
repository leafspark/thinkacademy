package io.ktor.http;

import com.tal100.chatsdk.PMDefs;
import com.yanzhenjie.andserver.util.StatusCode;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0005J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lio/ktor/http/HttpStatusCode;", "", "value", "", "description", "", "(ILjava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "getValue", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HttpStatusCode.kt */
public final class HttpStatusCode {
    /* access modifiers changed from: private */
    public static final HttpStatusCode Accepted = new HttpStatusCode(202, "Accepted");
    /* access modifiers changed from: private */
    public static final HttpStatusCode BadGateway = new HttpStatusCode(502, "Bad Gateway");
    /* access modifiers changed from: private */
    public static final HttpStatusCode BadRequest = new HttpStatusCode(400, "Bad Request");
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final HttpStatusCode Conflict = new HttpStatusCode(StatusCode.SC_CONFLICT, "Conflict");
    /* access modifiers changed from: private */
    public static final HttpStatusCode Continue = new HttpStatusCode(100, "Continue");
    /* access modifiers changed from: private */
    public static final HttpStatusCode Created = new HttpStatusCode(201, "Created");
    /* access modifiers changed from: private */
    public static final HttpStatusCode ExpectationFailed = new HttpStatusCode(StatusCode.SC_EXPECTATION_FAILED, "Expectation Failed");
    /* access modifiers changed from: private */
    public static final HttpStatusCode FailedDependency = new HttpStatusCode(424, "Failed Dependency");
    /* access modifiers changed from: private */
    public static final HttpStatusCode Forbidden = new HttpStatusCode(403, "Forbidden");
    /* access modifiers changed from: private */
    public static final HttpStatusCode Found = new HttpStatusCode(302, "Found");
    /* access modifiers changed from: private */
    public static final HttpStatusCode GatewayTimeout = new HttpStatusCode(504, "Gateway Timeout");
    /* access modifiers changed from: private */
    public static final HttpStatusCode Gone = new HttpStatusCode(StatusCode.SC_GONE, "Gone");
    /* access modifiers changed from: private */
    public static final HttpStatusCode InsufficientStorage = new HttpStatusCode(PMDefs.ResultCode.Result_SensitiveWord, "Insufficient Storage");
    /* access modifiers changed from: private */
    public static final HttpStatusCode InternalServerError = new HttpStatusCode(500, "Internal Server Error");
    /* access modifiers changed from: private */
    public static final HttpStatusCode LengthRequired = new HttpStatusCode(StatusCode.SC_LENGTH_REQUIRED, "Length Required");
    /* access modifiers changed from: private */
    public static final HttpStatusCode Locked = new HttpStatusCode(423, "Locked");
    /* access modifiers changed from: private */
    public static final HttpStatusCode MethodNotAllowed = new HttpStatusCode(405, "Method Not Allowed");
    /* access modifiers changed from: private */
    public static final HttpStatusCode MovedPermanently = new HttpStatusCode(301, "Moved Permanently");
    /* access modifiers changed from: private */
    public static final HttpStatusCode MultiStatus = new HttpStatusCode(207, "Multi-Status");
    /* access modifiers changed from: private */
    public static final HttpStatusCode MultipleChoices = new HttpStatusCode(300, "Multiple Choices");
    /* access modifiers changed from: private */
    public static final HttpStatusCode NoContent = new HttpStatusCode(204, "No Content");
    /* access modifiers changed from: private */
    public static final HttpStatusCode NonAuthoritativeInformation = new HttpStatusCode(203, "Non-Authoritative Information");
    /* access modifiers changed from: private */
    public static final HttpStatusCode NotAcceptable = new HttpStatusCode(StatusCode.SC_NOT_ACCEPTABLE, "Not Acceptable");
    /* access modifiers changed from: private */
    public static final HttpStatusCode NotFound = new HttpStatusCode(404, "Not Found");
    /* access modifiers changed from: private */
    public static final HttpStatusCode NotImplemented = new HttpStatusCode(501, "Not Implemented");
    /* access modifiers changed from: private */
    public static final HttpStatusCode NotModified = new HttpStatusCode(304, "Not Modified");
    /* access modifiers changed from: private */
    public static final HttpStatusCode OK = new HttpStatusCode(200, "OK");
    /* access modifiers changed from: private */
    public static final HttpStatusCode PartialContent = new HttpStatusCode(206, "Partial Content");
    /* access modifiers changed from: private */
    public static final HttpStatusCode PayloadTooLarge = new HttpStatusCode(StatusCode.SC_REQUEST_ENTITY_TOO_LARGE, "Payload Too Large");
    /* access modifiers changed from: private */
    public static final HttpStatusCode PaymentRequired = new HttpStatusCode(402, "Payment Required");
    /* access modifiers changed from: private */
    public static final HttpStatusCode PermanentRedirect = new HttpStatusCode(308, "Permanent Redirect");
    /* access modifiers changed from: private */
    public static final HttpStatusCode PreconditionFailed = new HttpStatusCode(StatusCode.SC_PRECONDITION_FAILED, "Precondition Failed");
    /* access modifiers changed from: private */
    public static final HttpStatusCode Processing = new HttpStatusCode(102, "Processing");
    /* access modifiers changed from: private */
    public static final HttpStatusCode ProxyAuthenticationRequired = new HttpStatusCode(StatusCode.SC_PROXY_AUTHENTICATION_REQUIRED, "Proxy Authentication Required");
    /* access modifiers changed from: private */
    public static final HttpStatusCode RequestHeaderFieldTooLarge = new HttpStatusCode(431, "Request Header Fields Too Large");
    /* access modifiers changed from: private */
    public static final HttpStatusCode RequestTimeout = new HttpStatusCode(StatusCode.SC_REQUEST_TIMEOUT, "Request Timeout");
    /* access modifiers changed from: private */
    public static final HttpStatusCode RequestURITooLong = new HttpStatusCode(StatusCode.SC_REQUEST_URI_TOO_LONG, "Request-URI Too Long");
    /* access modifiers changed from: private */
    public static final HttpStatusCode RequestedRangeNotSatisfiable = new HttpStatusCode(StatusCode.SC_REQUESTED_RANGE_NOT_SATISFIABLE, "Requested Range Not Satisfiable");
    /* access modifiers changed from: private */
    public static final HttpStatusCode ResetContent = new HttpStatusCode(205, "Reset Content");
    /* access modifiers changed from: private */
    public static final HttpStatusCode SeeOther = new HttpStatusCode(303, "See Other");
    /* access modifiers changed from: private */
    public static final HttpStatusCode ServiceUnavailable = new HttpStatusCode(503, "Service Unavailable");
    /* access modifiers changed from: private */
    public static final HttpStatusCode SwitchProxy = new HttpStatusCode(306, "Switch Proxy");
    /* access modifiers changed from: private */
    public static final HttpStatusCode SwitchingProtocols = new HttpStatusCode(101, "Switching Protocols");
    /* access modifiers changed from: private */
    public static final HttpStatusCode TemporaryRedirect = new HttpStatusCode(307, "Temporary Redirect");
    /* access modifiers changed from: private */
    public static final HttpStatusCode TooManyRequests = new HttpStatusCode(429, "Too Many Requests");
    /* access modifiers changed from: private */
    public static final HttpStatusCode Unauthorized = new HttpStatusCode(401, "Unauthorized");
    /* access modifiers changed from: private */
    public static final HttpStatusCode UnprocessableEntity = new HttpStatusCode(422, "Unprocessable Entity");
    /* access modifiers changed from: private */
    public static final HttpStatusCode UnsupportedMediaType = new HttpStatusCode(StatusCode.SC_UNSUPPORTED_MEDIA_TYPE, "Unsupported Media Type");
    /* access modifiers changed from: private */
    public static final HttpStatusCode UpgradeRequired = new HttpStatusCode(426, "Upgrade Required");
    /* access modifiers changed from: private */
    public static final HttpStatusCode UseProxy = new HttpStatusCode(305, "Use Proxy");
    /* access modifiers changed from: private */
    public static final HttpStatusCode VariantAlsoNegotiates = new HttpStatusCode(PMDefs.ResultCode.Result_RecvNotInRoom, "Variant Also Negotiates");
    /* access modifiers changed from: private */
    public static final HttpStatusCode VersionNotSupported = new HttpStatusCode(505, "HTTP Version Not Supported");
    /* access modifiers changed from: private */
    public static final List<HttpStatusCode> allStatusCodes;
    /* access modifiers changed from: private */
    public static final Map<Integer, HttpStatusCode> statusCodesMap;
    private final String description;
    private final int value;

    public static /* synthetic */ HttpStatusCode copy$default(HttpStatusCode httpStatusCode, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = httpStatusCode.value;
        }
        if ((i2 & 2) != 0) {
            str = httpStatusCode.description;
        }
        return httpStatusCode.copy(i, str);
    }

    public final int component1() {
        return this.value;
    }

    public final String component2() {
        return this.description;
    }

    public final HttpStatusCode copy(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "description");
        return new HttpStatusCode(i, str);
    }

    public HttpStatusCode(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "description");
        this.value = i;
        this.description = str;
    }

    public final String getDescription() {
        return this.description;
    }

    public final int getValue() {
        return this.value;
    }

    public String toString() {
        return this.value + ' ' + this.description;
    }

    public boolean equals(Object obj) {
        return (obj instanceof HttpStatusCode) && ((HttpStatusCode) obj).value == this.value;
    }

    public int hashCode() {
        return this.value;
    }

    public final HttpStatusCode description(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        return copy$default(this, 0, str, 1, (Object) null);
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\bi\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010t\u001a\u00020\u00042\u0006\u0010u\u001a\u00020sR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0011\u0010\u0011\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0011\u0010\u0013\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0011\u0010\u0015\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0011\u0010\u0017\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u0011\u0010\u0019\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006R\u0011\u0010\u001b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006R\u0011\u0010\u001d\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0006R\u0011\u0010\u001f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0006R\u0011\u0010!\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0006R\u0011\u0010#\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0006R\u0011\u0010%\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0006R\u0011\u0010'\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0006R\u0011\u0010)\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0006R\u0011\u0010+\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0006R\u0011\u0010-\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0006R\u0011\u0010/\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0006R\u0011\u00101\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u0006R\u0011\u00103\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u0006R\u0011\u00105\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u0006R\u0011\u00107\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u0006R\u0011\u00109\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u0006R\u0011\u0010;\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\u0006R\u0011\u0010=\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\u0006R\u0011\u0010?\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\u0006R\u0011\u0010A\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010\u0006R\u0011\u0010C\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010\u0006R\u0011\u0010E\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010\u0006R\u0011\u0010G\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010\u0006R\u0011\u0010I\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010\u0006R\u0011\u0010K\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u0010\u0006R\u0011\u0010M\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bN\u0010\u0006R\u0011\u0010O\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u0010\u0006R\u0011\u0010Q\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bR\u0010\u0006R\u0011\u0010S\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bT\u0010\u0006R\u0011\u0010U\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u0010\u0006R\u0011\u0010W\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bX\u0010\u0006R\u0011\u0010Y\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010\u0006R\u0011\u0010[\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010\u0006R\u0011\u0010]\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b^\u0010\u0006R\u0011\u0010_\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b`\u0010\u0006R\u0011\u0010a\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bb\u0010\u0006R\u0011\u0010c\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bd\u0010\u0006R\u0011\u0010e\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bf\u0010\u0006R\u0011\u0010g\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bh\u0010\u0006R\u0011\u0010i\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bj\u0010\u0006R\u0011\u0010k\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bl\u0010\u0006R\u0017\u0010m\u001a\b\u0012\u0004\u0012\u00020\u00040n¢\u0006\b\n\u0000\u001a\u0004\bo\u0010pR\u001a\u0010q\u001a\u000e\u0012\u0004\u0012\u00020s\u0012\u0004\u0012\u00020\u00040rX\u0004¢\u0006\u0002\n\u0000¨\u0006v"}, d2 = {"Lio/ktor/http/HttpStatusCode$Companion;", "", "()V", "Accepted", "Lio/ktor/http/HttpStatusCode;", "getAccepted", "()Lio/ktor/http/HttpStatusCode;", "BadGateway", "getBadGateway", "BadRequest", "getBadRequest", "Conflict", "getConflict", "Continue", "getContinue", "Created", "getCreated", "ExpectationFailed", "getExpectationFailed", "FailedDependency", "getFailedDependency", "Forbidden", "getForbidden", "Found", "getFound", "GatewayTimeout", "getGatewayTimeout", "Gone", "getGone", "InsufficientStorage", "getInsufficientStorage", "InternalServerError", "getInternalServerError", "LengthRequired", "getLengthRequired", "Locked", "getLocked", "MethodNotAllowed", "getMethodNotAllowed", "MovedPermanently", "getMovedPermanently", "MultiStatus", "getMultiStatus", "MultipleChoices", "getMultipleChoices", "NoContent", "getNoContent", "NonAuthoritativeInformation", "getNonAuthoritativeInformation", "NotAcceptable", "getNotAcceptable", "NotFound", "getNotFound", "NotImplemented", "getNotImplemented", "NotModified", "getNotModified", "OK", "getOK", "PartialContent", "getPartialContent", "PayloadTooLarge", "getPayloadTooLarge", "PaymentRequired", "getPaymentRequired", "PermanentRedirect", "getPermanentRedirect", "PreconditionFailed", "getPreconditionFailed", "Processing", "getProcessing", "ProxyAuthenticationRequired", "getProxyAuthenticationRequired", "RequestHeaderFieldTooLarge", "getRequestHeaderFieldTooLarge", "RequestTimeout", "getRequestTimeout", "RequestURITooLong", "getRequestURITooLong", "RequestedRangeNotSatisfiable", "getRequestedRangeNotSatisfiable", "ResetContent", "getResetContent", "SeeOther", "getSeeOther", "ServiceUnavailable", "getServiceUnavailable", "SwitchProxy", "getSwitchProxy", "SwitchingProtocols", "getSwitchingProtocols", "TemporaryRedirect", "getTemporaryRedirect", "TooManyRequests", "getTooManyRequests", "Unauthorized", "getUnauthorized", "UnprocessableEntity", "getUnprocessableEntity", "UnsupportedMediaType", "getUnsupportedMediaType", "UpgradeRequired", "getUpgradeRequired", "UseProxy", "getUseProxy", "VariantAlsoNegotiates", "getVariantAlsoNegotiates", "VersionNotSupported", "getVersionNotSupported", "allStatusCodes", "", "getAllStatusCodes", "()Ljava/util/List;", "statusCodesMap", "", "", "fromValue", "value", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HttpStatusCode.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HttpStatusCode getContinue() {
            return HttpStatusCode.Continue;
        }

        public final HttpStatusCode getSwitchingProtocols() {
            return HttpStatusCode.SwitchingProtocols;
        }

        public final HttpStatusCode getProcessing() {
            return HttpStatusCode.Processing;
        }

        public final HttpStatusCode getOK() {
            return HttpStatusCode.OK;
        }

        public final HttpStatusCode getCreated() {
            return HttpStatusCode.Created;
        }

        public final HttpStatusCode getAccepted() {
            return HttpStatusCode.Accepted;
        }

        public final HttpStatusCode getNonAuthoritativeInformation() {
            return HttpStatusCode.NonAuthoritativeInformation;
        }

        public final HttpStatusCode getNoContent() {
            return HttpStatusCode.NoContent;
        }

        public final HttpStatusCode getResetContent() {
            return HttpStatusCode.ResetContent;
        }

        public final HttpStatusCode getPartialContent() {
            return HttpStatusCode.PartialContent;
        }

        public final HttpStatusCode getMultiStatus() {
            return HttpStatusCode.MultiStatus;
        }

        public final HttpStatusCode getMultipleChoices() {
            return HttpStatusCode.MultipleChoices;
        }

        public final HttpStatusCode getMovedPermanently() {
            return HttpStatusCode.MovedPermanently;
        }

        public final HttpStatusCode getFound() {
            return HttpStatusCode.Found;
        }

        public final HttpStatusCode getSeeOther() {
            return HttpStatusCode.SeeOther;
        }

        public final HttpStatusCode getNotModified() {
            return HttpStatusCode.NotModified;
        }

        public final HttpStatusCode getUseProxy() {
            return HttpStatusCode.UseProxy;
        }

        public final HttpStatusCode getSwitchProxy() {
            return HttpStatusCode.SwitchProxy;
        }

        public final HttpStatusCode getTemporaryRedirect() {
            return HttpStatusCode.TemporaryRedirect;
        }

        public final HttpStatusCode getPermanentRedirect() {
            return HttpStatusCode.PermanentRedirect;
        }

        public final HttpStatusCode getBadRequest() {
            return HttpStatusCode.BadRequest;
        }

        public final HttpStatusCode getUnauthorized() {
            return HttpStatusCode.Unauthorized;
        }

        public final HttpStatusCode getPaymentRequired() {
            return HttpStatusCode.PaymentRequired;
        }

        public final HttpStatusCode getForbidden() {
            return HttpStatusCode.Forbidden;
        }

        public final HttpStatusCode getNotFound() {
            return HttpStatusCode.NotFound;
        }

        public final HttpStatusCode getMethodNotAllowed() {
            return HttpStatusCode.MethodNotAllowed;
        }

        public final HttpStatusCode getNotAcceptable() {
            return HttpStatusCode.NotAcceptable;
        }

        public final HttpStatusCode getProxyAuthenticationRequired() {
            return HttpStatusCode.ProxyAuthenticationRequired;
        }

        public final HttpStatusCode getRequestTimeout() {
            return HttpStatusCode.RequestTimeout;
        }

        public final HttpStatusCode getConflict() {
            return HttpStatusCode.Conflict;
        }

        public final HttpStatusCode getGone() {
            return HttpStatusCode.Gone;
        }

        public final HttpStatusCode getLengthRequired() {
            return HttpStatusCode.LengthRequired;
        }

        public final HttpStatusCode getPreconditionFailed() {
            return HttpStatusCode.PreconditionFailed;
        }

        public final HttpStatusCode getPayloadTooLarge() {
            return HttpStatusCode.PayloadTooLarge;
        }

        public final HttpStatusCode getRequestURITooLong() {
            return HttpStatusCode.RequestURITooLong;
        }

        public final HttpStatusCode getUnsupportedMediaType() {
            return HttpStatusCode.UnsupportedMediaType;
        }

        public final HttpStatusCode getRequestedRangeNotSatisfiable() {
            return HttpStatusCode.RequestedRangeNotSatisfiable;
        }

        public final HttpStatusCode getExpectationFailed() {
            return HttpStatusCode.ExpectationFailed;
        }

        public final HttpStatusCode getUnprocessableEntity() {
            return HttpStatusCode.UnprocessableEntity;
        }

        public final HttpStatusCode getLocked() {
            return HttpStatusCode.Locked;
        }

        public final HttpStatusCode getFailedDependency() {
            return HttpStatusCode.FailedDependency;
        }

        public final HttpStatusCode getUpgradeRequired() {
            return HttpStatusCode.UpgradeRequired;
        }

        public final HttpStatusCode getTooManyRequests() {
            return HttpStatusCode.TooManyRequests;
        }

        public final HttpStatusCode getRequestHeaderFieldTooLarge() {
            return HttpStatusCode.RequestHeaderFieldTooLarge;
        }

        public final HttpStatusCode getInternalServerError() {
            return HttpStatusCode.InternalServerError;
        }

        public final HttpStatusCode getNotImplemented() {
            return HttpStatusCode.NotImplemented;
        }

        public final HttpStatusCode getBadGateway() {
            return HttpStatusCode.BadGateway;
        }

        public final HttpStatusCode getServiceUnavailable() {
            return HttpStatusCode.ServiceUnavailable;
        }

        public final HttpStatusCode getGatewayTimeout() {
            return HttpStatusCode.GatewayTimeout;
        }

        public final HttpStatusCode getVersionNotSupported() {
            return HttpStatusCode.VersionNotSupported;
        }

        public final HttpStatusCode getVariantAlsoNegotiates() {
            return HttpStatusCode.VariantAlsoNegotiates;
        }

        public final HttpStatusCode getInsufficientStorage() {
            return HttpStatusCode.InsufficientStorage;
        }

        public final List<HttpStatusCode> getAllStatusCodes() {
            return HttpStatusCode.allStatusCodes;
        }

        public final HttpStatusCode fromValue(int i) {
            HttpStatusCode httpStatusCode = (HttpStatusCode) HttpStatusCode.statusCodesMap.get(Integer.valueOf(i));
            return httpStatusCode == null ? new HttpStatusCode(i, "Unknown Status Code") : httpStatusCode;
        }
    }

    static {
        List<HttpStatusCode> allStatusCodes2 = HttpStatusCodeKt.allStatusCodes();
        allStatusCodes = allStatusCodes2;
        Iterable iterable = allStatusCodes2;
        Map<Integer, HttpStatusCode> linkedHashMap = new LinkedHashMap<>(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(iterable, 10)), 16));
        for (Object next : iterable) {
            linkedHashMap.put(Integer.valueOf(((HttpStatusCode) next).value), next);
        }
        statusCodesMap = linkedHashMap;
    }
}
