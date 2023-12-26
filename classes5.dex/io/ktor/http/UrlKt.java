package io.ktor.http;

import io.agora.rtc.Constants;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\u001aj\u0010\t\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0001*\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004\"\u0015\u0010\u0007\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004¨\u0006\u0017"}, d2 = {"authority", "", "Lio/ktor/http/Url;", "getAuthority", "(Lio/ktor/http/Url;)Ljava/lang/String;", "encodedUserAndPassword", "getEncodedUserAndPassword", "protocolWithAuthority", "getProtocolWithAuthority", "copy", "protocol", "Lio/ktor/http/URLProtocol;", "host", "specifiedPort", "", "encodedPath", "parameters", "Lio/ktor/http/Parameters;", "fragment", "user", "password", "trailingQuery", "", "ktor-http"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Url.kt */
public final class UrlKt {
    public static /* synthetic */ Url copy$default(Url url, URLProtocol uRLProtocol, String str, int i, String str2, Parameters parameters, String str3, String str4, String str5, boolean z, int i2, Object obj) {
        boolean z2;
        int i3 = i2;
        URLProtocol protocol = (i3 & 1) != 0 ? url.getProtocol() : uRLProtocol;
        String host = (i3 & 2) != 0 ? url.getHost() : str;
        int specifiedPort = (i3 & 4) != 0 ? url.getSpecifiedPort() : i;
        String encodedPath = (i3 & 8) != 0 ? url.getEncodedPath() : str2;
        Parameters parameters2 = (i3 & 16) != 0 ? url.getParameters() : parameters;
        String fragment = (i3 & 32) != 0 ? url.getFragment() : str3;
        String user = (i3 & 64) != 0 ? url.getUser() : str4;
        String password = (i3 & Constants.ERR_WATERMARK_ARGB) != 0 ? url.getPassword() : str5;
        if ((i3 & 256) != 0) {
            z2 = url.getTrailingQuery();
        } else {
            z2 = z;
        }
        return copy(url, protocol, host, specifiedPort, encodedPath, parameters2, fragment, user, password, z2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Url is not a data class anymore. Please use URLBuilder(url)", replaceWith = @ReplaceWith(expression = "URLBuilder(this)", imports = {}))
    public static final Url copy(Url url, URLProtocol uRLProtocol, String str, int i, String str2, Parameters parameters, String str3, String str4, String str5, boolean z) {
        Intrinsics.checkNotNullParameter(url, "<this>");
        Intrinsics.checkNotNullParameter(uRLProtocol, "protocol");
        Intrinsics.checkNotNullParameter(str, "host");
        Intrinsics.checkNotNullParameter(str2, "encodedPath");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        Intrinsics.checkNotNullParameter(str3, "fragment");
        throw new IllegalStateException("Please use URLBuilder(url)".toString());
    }

    public static final String getAuthority(Url url) {
        Intrinsics.checkNotNullParameter(url, "<this>");
        StringBuilder sb = new StringBuilder();
        sb.append(getEncodedUserAndPassword(url));
        if (url.getSpecifiedPort() == 0 || url.getSpecifiedPort() == url.getProtocol().getDefaultPort()) {
            sb.append(url.getHost());
        } else {
            sb.append(URLUtilsKt.getHostWithPort(url));
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public static final String getProtocolWithAuthority(Url url) {
        Intrinsics.checkNotNullParameter(url, "<this>");
        StringBuilder sb = new StringBuilder();
        sb.append(url.getProtocol().getName());
        sb.append("://");
        sb.append(getEncodedUserAndPassword(url));
        if (url.getSpecifiedPort() == 0 || url.getSpecifiedPort() == url.getProtocol().getDefaultPort()) {
            sb.append(url.getHost());
        } else {
            sb.append(URLUtilsKt.getHostWithPort(url));
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public static final String getEncodedUserAndPassword(Url url) {
        Intrinsics.checkNotNullParameter(url, "<this>");
        StringBuilder sb = new StringBuilder();
        URLUtilsKt.appendUserAndPassword(sb, url.getEncodedUser(), url.getEncodedPassword());
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
