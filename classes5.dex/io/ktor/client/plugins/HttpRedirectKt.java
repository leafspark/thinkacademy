package io.ktor.client.plugins;

import io.ktor.http.HttpMethod;
import io.ktor.http.HttpStatusCode;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0002\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"ALLOWED_FOR_REDIRECT", "", "Lio/ktor/http/HttpMethod;", "isRedirect", "", "Lio/ktor/http/HttpStatusCode;", "ktor-client-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: HttpRedirect.kt */
public final class HttpRedirectKt {
    /* access modifiers changed from: private */
    public static final Set<HttpMethod> ALLOWED_FOR_REDIRECT = SetsKt.setOf(new HttpMethod[]{HttpMethod.Companion.getGet(), HttpMethod.Companion.getHead()});

    /* access modifiers changed from: private */
    public static final boolean isRedirect(HttpStatusCode httpStatusCode) {
        boolean z;
        boolean z2;
        boolean z3;
        int value = httpStatusCode.getValue();
        if (value == HttpStatusCode.Companion.getMovedPermanently().getValue() || value == HttpStatusCode.Companion.getFound().getValue()) {
            z = true;
        } else {
            z = false;
        }
        if (!z && value != HttpStatusCode.Companion.getTemporaryRedirect().getValue()) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z2 && value != HttpStatusCode.Companion.getPermanentRedirect().getValue()) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (!z3 && value != HttpStatusCode.Companion.getSeeOther().getValue()) {
            return false;
        }
        return true;
    }
}
