package io.ktor.http;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b\u001a\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002\u001a\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0001\u001a\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b\u001a\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0001\u001a&\u0010\r\u001a\u00020\u000e*\u00060\u000fj\u0002`\u00102\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015\u001a(\u0010\r\u001a\u00020\u000e*\u00060\u000fj\u0002`\u00102\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0015H\u0000\u001a$\u0010\u0017\u001a\u00020\u000e*\u00060\u0018j\u0002`\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0000\u001a\u0012\u0010\u001c\u001a\u00020\b*\u00020\b2\u0006\u0010\n\u001a\u00020\b\u001a\u0012\u0010\u001c\u001a\u00020\b*\u00020\b2\u0006\u0010\n\u001a\u00020\u0002\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004¨\u0006\u001d"}, d2 = {"fullPath", "", "Lio/ktor/http/Url;", "getFullPath", "(Lio/ktor/http/Url;)Ljava/lang/String;", "hostWithPort", "getHostWithPort", "URLBuilder", "Lio/ktor/http/URLBuilder;", "builder", "url", "urlString", "Url", "appendUrlFullPath", "", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "encodedPath", "encodedQueryParameters", "Lio/ktor/http/ParametersBuilder;", "trailingQuery", "", "encodedQuery", "appendUserAndPassword", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "encodedUser", "encodedPassword", "takeFrom", "ktor-http"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: URLUtils.kt */
public final class URLUtilsKt {
    public static final Url Url(String str) {
        Intrinsics.checkNotNullParameter(str, "urlString");
        return URLBuilder(str).build();
    }

    public static final Url Url(URLBuilder uRLBuilder) {
        Intrinsics.checkNotNullParameter(uRLBuilder, "builder");
        return takeFrom(new URLBuilder((URLProtocol) null, (String) null, 0, (String) null, (String) null, (List) null, (Parameters) null, (String) null, false, 511, (DefaultConstructorMarker) null), uRLBuilder).build();
    }

    public static final URLBuilder URLBuilder(String str) {
        Intrinsics.checkNotNullParameter(str, "urlString");
        return URLParserKt.takeFrom(new URLBuilder((URLProtocol) null, (String) null, 0, (String) null, (String) null, (List) null, (Parameters) null, (String) null, false, 511, (DefaultConstructorMarker) null), str);
    }

    public static final URLBuilder URLBuilder(Url url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return takeFrom(new URLBuilder((URLProtocol) null, (String) null, 0, (String) null, (String) null, (List) null, (Parameters) null, (String) null, false, 511, (DefaultConstructorMarker) null), url);
    }

    public static final URLBuilder URLBuilder(URLBuilder uRLBuilder) {
        Intrinsics.checkNotNullParameter(uRLBuilder, "builder");
        return takeFrom(new URLBuilder((URLProtocol) null, (String) null, 0, (String) null, (String) null, (List) null, (Parameters) null, (String) null, false, 511, (DefaultConstructorMarker) null), uRLBuilder);
    }

    public static final URLBuilder takeFrom(URLBuilder uRLBuilder, URLBuilder uRLBuilder2) {
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        Intrinsics.checkNotNullParameter(uRLBuilder2, "url");
        uRLBuilder.setProtocol(uRLBuilder2.getProtocol());
        uRLBuilder.setHost(uRLBuilder2.getHost());
        uRLBuilder.setPort(uRLBuilder2.getPort());
        uRLBuilder.setEncodedPathSegments(uRLBuilder2.getEncodedPathSegments());
        uRLBuilder.setEncodedUser(uRLBuilder2.getEncodedUser());
        uRLBuilder.setEncodedPassword(uRLBuilder2.getEncodedPassword());
        uRLBuilder.setEncodedParameters(uRLBuilder2.getEncodedParameters());
        uRLBuilder.setEncodedFragment(uRLBuilder2.getEncodedFragment());
        uRLBuilder.setTrailingQuery(uRLBuilder2.getTrailingQuery());
        return uRLBuilder;
    }

    public static final URLBuilder takeFrom(URLBuilder uRLBuilder, Url url) {
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        uRLBuilder.setProtocol(url.getProtocol());
        uRLBuilder.setHost(url.getHost());
        uRLBuilder.setPort(url.getPort());
        URLBuilderKt.setEncodedPath(uRLBuilder, url.getEncodedPath());
        uRLBuilder.setEncodedUser(url.getEncodedUser());
        uRLBuilder.setEncodedPassword(url.getEncodedPassword());
        ParametersBuilder ParametersBuilder$default = ParametersKt.ParametersBuilder$default(0, 1, (Object) null);
        ParametersBuilder$default.appendAll(QueryKt.parseQueryString$default(url.getEncodedQuery(), 0, 0, false, 6, (Object) null));
        uRLBuilder.setEncodedParameters(ParametersBuilder$default);
        uRLBuilder.setEncodedFragment(url.getEncodedFragment());
        uRLBuilder.setTrailingQuery(url.getTrailingQuery());
        return uRLBuilder;
    }

    public static final String getFullPath(Url url) {
        Intrinsics.checkNotNullParameter(url, "<this>");
        StringBuilder sb = new StringBuilder();
        appendUrlFullPath((Appendable) sb, url.getEncodedPath(), url.getEncodedQuery(), url.getTrailingQuery());
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public static final String getHostWithPort(Url url) {
        Intrinsics.checkNotNullParameter(url, "<this>");
        return url.getHost() + ':' + url.getPort();
    }

    public static final void appendUrlFullPath(Appendable appendable, String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(appendable, "<this>");
        Intrinsics.checkNotNullParameter(str, "encodedPath");
        Intrinsics.checkNotNullParameter(str2, "encodedQuery");
        CharSequence charSequence = str;
        boolean z2 = true;
        if ((!StringsKt.isBlank(charSequence)) && !StringsKt.startsWith$default(str, "/", false, 2, (Object) null)) {
            appendable.append('/');
        }
        appendable.append(charSequence);
        CharSequence charSequence2 = str2;
        if (charSequence2.length() <= 0) {
            z2 = false;
        }
        if (z2 || z) {
            appendable.append("?");
        }
        appendable.append(charSequence2);
    }

    public static final void appendUrlFullPath(Appendable appendable, String str, ParametersBuilder parametersBuilder, boolean z) {
        List list;
        Intrinsics.checkNotNullParameter(appendable, "<this>");
        Intrinsics.checkNotNullParameter(str, "encodedPath");
        Intrinsics.checkNotNullParameter(parametersBuilder, "encodedQueryParameters");
        CharSequence charSequence = str;
        if ((!StringsKt.isBlank(charSequence)) && !StringsKt.startsWith$default(str, "/", false, 2, (Object) null)) {
            appendable.append('/');
        }
        appendable.append(charSequence);
        if (!parametersBuilder.isEmpty() || z) {
            appendable.append("?");
        }
        Collection arrayList = new ArrayList();
        for (Map.Entry entry : parametersBuilder.entries()) {
            String str2 = (String) entry.getKey();
            List list2 = (List) entry.getValue();
            if (list2.isEmpty()) {
                list = CollectionsKt.listOf(TuplesKt.to(str2, null));
            } else {
                Iterable<String> iterable = list2;
                Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (String str3 : iterable) {
                    arrayList2.add(TuplesKt.to(str2, str3));
                }
                list = (List) arrayList2;
            }
            CollectionsKt.addAll(arrayList, list);
        }
        CollectionsKt.joinTo$default((List) arrayList, appendable, "&", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, URLUtilsKt$appendUrlFullPath$2.INSTANCE, 60, (Object) null);
    }

    public static final void appendUserAndPassword(StringBuilder sb, String str, String str2) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        if (str != null) {
            sb.append(str);
            if (str2 != null) {
                sb.append(':');
                sb.append(str2);
            }
            sb.append("@");
        }
    }
}
