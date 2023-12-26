package io.ktor.http;

import java.net.URI;
import java.net.URL;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010\u0004\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010\u0004\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u001a\n\u0010\b\u001a\u00020\u0003*\u00020\u0001¨\u0006\t"}, d2 = {"Url", "Lio/ktor/http/Url;", "uri", "Ljava/net/URI;", "takeFrom", "Lio/ktor/http/URLBuilder;", "url", "Ljava/net/URL;", "toURI", "ktor-http"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: URLUtilsJvm.kt */
public final class URLUtilsJvmKt {
    public static final URLBuilder takeFrom(URLBuilder uRLBuilder, URI uri) {
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        Intrinsics.checkNotNullParameter(uri, "uri");
        String scheme = uri.getScheme();
        if (scheme != null) {
            uRLBuilder.setProtocol(URLProtocol.Companion.createOrDefault(scheme));
            uRLBuilder.setPort(uRLBuilder.getProtocol().getDefaultPort());
        }
        if (uri.getPort() > 0) {
            uRLBuilder.setPort(uri.getPort());
        } else {
            String scheme2 = uri.getScheme();
            if (Intrinsics.areEqual(scheme2, "http")) {
                uRLBuilder.setPort(80);
            } else if (Intrinsics.areEqual(scheme2, "https")) {
                uRLBuilder.setPort(443);
            }
        }
        boolean z = false;
        if (uri.getRawUserInfo() != null) {
            String rawUserInfo = uri.getRawUserInfo();
            Intrinsics.checkNotNullExpressionValue(rawUserInfo, "uri.rawUserInfo");
            if (rawUserInfo.length() > 0) {
                String rawUserInfo2 = uri.getRawUserInfo();
                Intrinsics.checkNotNullExpressionValue(rawUserInfo2, "uri.rawUserInfo");
                List split$default = StringsKt.split$default((CharSequence) rawUserInfo2, new String[]{":"}, false, 0, 6, (Object) null);
                uRLBuilder.setEncodedUser((String) CollectionsKt.first(split$default));
                uRLBuilder.setEncodedPassword((String) CollectionsKt.getOrNull(split$default, 1));
            }
        }
        String host = uri.getHost();
        if (host != null) {
            uRLBuilder.setHost(host);
        }
        String rawPath = uri.getRawPath();
        Intrinsics.checkNotNullExpressionValue(rawPath, "uri.rawPath");
        URLBuilderKt.setEncodedPath(uRLBuilder, rawPath);
        String rawQuery = uri.getRawQuery();
        if (rawQuery != null) {
            ParametersBuilder ParametersBuilder$default = ParametersKt.ParametersBuilder$default(0, 1, (Object) null);
            ParametersBuilder$default.appendAll(QueryKt.parseQueryString$default(rawQuery, 0, 0, false, 6, (Object) null));
            uRLBuilder.setEncodedParameters(ParametersBuilder$default);
        }
        String query = uri.getQuery();
        if (query != null) {
            if (query.length() == 0) {
                z = true;
            }
        }
        if (z) {
            uRLBuilder.setTrailingQuery(true);
        }
        String rawFragment = uri.getRawFragment();
        if (rawFragment != null) {
            uRLBuilder.setEncodedFragment(rawFragment);
        }
        return uRLBuilder;
    }

    public static final URLBuilder takeFrom(URLBuilder uRLBuilder, URL url) {
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        URI uri = url.toURI();
        Intrinsics.checkNotNullExpressionValue(uri, "url.toURI()");
        return takeFrom(uRLBuilder, uri);
    }

    public static final URI toURI(Url url) {
        Intrinsics.checkNotNullParameter(url, "<this>");
        return new URI(url.toString());
    }

    public static final Url Url(URI uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return takeFrom(new URLBuilder((URLProtocol) null, (String) null, 0, (String) null, (String) null, (List) null, (Parameters) null, (String) null, false, 511, (DefaultConstructorMarker) null), uri).build();
    }
}
