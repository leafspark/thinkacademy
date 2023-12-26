package io.ktor.http;

import io.ktor.http.URLBuilder;
import io.ktor.http.Url;
import java.net.URI;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001H\u0002\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\t"}, d2 = {"origin", "", "Lio/ktor/http/URLBuilder$Companion;", "getOrigin", "(Lio/ktor/http/URLBuilder$Companion;)Ljava/lang/String;", "invoke", "Lio/ktor/http/Url;", "Lio/ktor/http/Url$Companion;", "fullUrl", "ktor-http"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: URLBuilderJvm.kt */
public final class URLBuilderJvmKt {
    public static final String getOrigin(URLBuilder.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return "http://localhost";
    }

    public static final Url invoke(Url.Companion companion, String str) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(str, "fullUrl");
        URLBuilder uRLBuilder = new URLBuilder((URLProtocol) null, (String) null, 0, (String) null, (String) null, (List) null, (Parameters) null, (String) null, false, 511, (DefaultConstructorMarker) null);
        URLUtilsJvmKt.takeFrom(uRLBuilder, new URI(str));
        return uRLBuilder.build();
    }
}
