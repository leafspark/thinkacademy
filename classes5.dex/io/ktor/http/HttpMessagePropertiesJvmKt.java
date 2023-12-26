package io.ktor.http;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001a\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u001a\f\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\t\u001a\f\u0010\n\u001a\u0004\u0018\u00010\u0007*\u00020\t\u001a\f\u0010\n\u001a\u0004\u0018\u00010\u0007*\u00020\u000b\u001a\u0012\u0010\f\u001a\u00020\r*\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007\u001a\f\u0010\u000e\u001a\u0004\u0018\u00010\u0007*\u00020\t\u001a\f\u0010\u000e\u001a\u0004\u0018\u00010\u0007*\u00020\u000b\"\u0014\u0010\u0000\u001a\u00020\u00018BX\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u000f"}, d2 = {"HTTP_DATE_FORMAT", "Ljava/text/SimpleDateFormat;", "getHTTP_DATE_FORMAT", "()Ljava/text/SimpleDateFormat;", "formatHttpDate", "", "date", "Ljava/util/Date;", "parseHttpDate", "Lio/ktor/http/HttpMessage;", "expires", "Lio/ktor/http/HttpMessageBuilder;", "ifModifiedSince", "", "lastModified", "ktor-http"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: HttpMessagePropertiesJvm.kt */
public final class HttpMessagePropertiesJvmKt {
    private static final SimpleDateFormat getHTTP_DATE_FORMAT() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }

    private static final Date parseHttpDate(String str) {
        Date parse = getHTTP_DATE_FORMAT().parse(str);
        Intrinsics.checkNotNullExpressionValue(parse, "HTTP_DATE_FORMAT.parse(date)");
        return parse;
    }

    private static final String formatHttpDate(Date date) {
        String format = getHTTP_DATE_FORMAT().format(date);
        Intrinsics.checkNotNullExpressionValue(format, "HTTP_DATE_FORMAT.format(date)");
        return format;
    }

    public static final void ifModifiedSince(HttpMessageBuilder httpMessageBuilder, Date date) {
        Intrinsics.checkNotNullParameter(httpMessageBuilder, "<this>");
        Intrinsics.checkNotNullParameter(date, "date");
        httpMessageBuilder.getHeaders().set(HttpHeaders.INSTANCE.getIfModifiedSince(), formatHttpDate(date));
    }

    public static final Date lastModified(HttpMessageBuilder httpMessageBuilder) {
        Intrinsics.checkNotNullParameter(httpMessageBuilder, "<this>");
        String str = httpMessageBuilder.getHeaders().get(HttpHeaders.INSTANCE.getLastModified());
        if (str != null) {
            return parseHttpDate(str);
        }
        return null;
    }

    public static final Date expires(HttpMessageBuilder httpMessageBuilder) {
        Intrinsics.checkNotNullParameter(httpMessageBuilder, "<this>");
        String str = httpMessageBuilder.getHeaders().get(HttpHeaders.INSTANCE.getExpires());
        if (str != null) {
            return parseHttpDate(str);
        }
        return null;
    }

    public static final Date lastModified(HttpMessage httpMessage) {
        Intrinsics.checkNotNullParameter(httpMessage, "<this>");
        String str = httpMessage.getHeaders().get(HttpHeaders.INSTANCE.getLastModified());
        if (str != null) {
            return parseHttpDate(str);
        }
        return null;
    }

    public static final Date expires(HttpMessage httpMessage) {
        Intrinsics.checkNotNullParameter(httpMessage, "<this>");
        String str = httpMessage.getHeaders().get(HttpHeaders.INSTANCE.getExpires());
        if (str != null) {
            return parseHttpDate(str);
        }
        return null;
    }

    public static final Date date(HttpMessage httpMessage) {
        Intrinsics.checkNotNullParameter(httpMessage, "<this>");
        String str = httpMessage.getHeaders().get(HttpHeaders.INSTANCE.getDate());
        if (str != null) {
            return parseHttpDate(str);
        }
        return null;
    }
}
