package io.ktor.http;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 F2\u00020\u0001:\u0001FBi\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\b\u0010A\u001a\u00020BH\u0002J\u0006\u0010C\u001a\u00020DJ\u0006\u0010E\u001a\u00020\u0005R\u001a\u0010\u0012\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0018@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u0016R \u0010!\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0014\"\u0004\b(\u0010\u0016R$\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00058F@FX\u000e¢\u0006\f\u001a\u0004\b)\u0010\u0014\"\u0004\b*\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0014\"\u0004\b,\u0010\u0016R\u001e\u0010\f\u001a\u00020\u00182\u0006\u0010-\u001a\u00020\u0018@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001bR(\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00058F@FX\u000e¢\u0006\f\u001a\u0004\b/\u0010\u0014\"\u0004\b0\u0010\u0016R0\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b8F@FX\u000e¢\u0006\f\u001a\u0004\b1\u0010#\"\u0004\b2\u0010%R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R(\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00058F@FX\u000e¢\u0006\f\u001a\u0004\b?\u0010\u0014\"\u0004\b@\u0010\u0016¨\u0006G"}, d2 = {"Lio/ktor/http/URLBuilder;", "", "protocol", "Lio/ktor/http/URLProtocol;", "host", "", "port", "", "user", "password", "pathSegments", "", "parameters", "Lio/ktor/http/Parameters;", "fragment", "trailingQuery", "", "(Lio/ktor/http/URLProtocol;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Lio/ktor/http/Parameters;Ljava/lang/String;Z)V", "encodedFragment", "getEncodedFragment", "()Ljava/lang/String;", "setEncodedFragment", "(Ljava/lang/String;)V", "value", "Lio/ktor/http/ParametersBuilder;", "encodedParameters", "getEncodedParameters", "()Lio/ktor/http/ParametersBuilder;", "setEncodedParameters", "(Lio/ktor/http/ParametersBuilder;)V", "encodedPassword", "getEncodedPassword", "setEncodedPassword", "encodedPathSegments", "getEncodedPathSegments", "()Ljava/util/List;", "setEncodedPathSegments", "(Ljava/util/List;)V", "encodedUser", "getEncodedUser", "setEncodedUser", "getFragment", "setFragment", "getHost", "setHost", "<set-?>", "getParameters", "getPassword", "setPassword", "getPathSegments", "setPathSegments", "getPort", "()I", "setPort", "(I)V", "getProtocol", "()Lio/ktor/http/URLProtocol;", "setProtocol", "(Lio/ktor/http/URLProtocol;)V", "getTrailingQuery", "()Z", "setTrailingQuery", "(Z)V", "getUser", "setUser", "applyOrigin", "", "build", "Lio/ktor/http/Url;", "buildString", "Companion", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: URLBuilder.kt */
public final class URLBuilder {
    public static final Companion Companion;
    private static final Url originUrl;
    private String encodedFragment;
    private ParametersBuilder encodedParameters;
    private String encodedPassword;
    private List<String> encodedPathSegments;
    private String encodedUser;
    private String host;
    private ParametersBuilder parameters;
    private int port;
    private URLProtocol protocol;
    private boolean trailingQuery;

    public URLBuilder() {
        this((URLProtocol) null, (String) null, 0, (String) null, (String) null, (List) null, (Parameters) null, (String) null, false, 511, (DefaultConstructorMarker) null);
    }

    public URLBuilder(URLProtocol uRLProtocol, String str, int i, String str2, String str3, List<String> list, Parameters parameters2, String str4, boolean z) {
        Intrinsics.checkNotNullParameter(uRLProtocol, "protocol");
        Intrinsics.checkNotNullParameter(str, "host");
        Intrinsics.checkNotNullParameter(list, "pathSegments");
        Intrinsics.checkNotNullParameter(parameters2, "parameters");
        Intrinsics.checkNotNullParameter(str4, "fragment");
        this.protocol = uRLProtocol;
        this.host = str;
        this.port = i;
        this.trailingQuery = z;
        String str5 = null;
        this.encodedUser = str2 != null ? CodecsKt.encodeURLParameter$default(str2, false, 1, (Object) null) : null;
        this.encodedPassword = str3 != null ? CodecsKt.encodeURLParameter$default(str3, false, 1, (Object) null) : str5;
        this.encodedFragment = CodecsKt.encodeURLQueryComponent$default(str4, false, false, (Charset) null, 7, (Object) null);
        Iterable<String> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (String encodeURLPath : iterable) {
            arrayList.add(CodecsKt.encodeURLPath(encodeURLPath));
        }
        this.encodedPathSegments = (List) arrayList;
        ParametersBuilder encodeParameters = UrlDecodedParametersBuilderKt.encodeParameters(parameters2);
        this.encodedParameters = encodeParameters;
        this.parameters = new UrlDecodedParametersBuilder(encodeParameters);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ URLBuilder(io.ktor.http.URLProtocol r12, java.lang.String r13, int r14, java.lang.String r15, java.lang.String r16, java.util.List r17, io.ktor.http.Parameters r18, java.lang.String r19, boolean r20, int r21, kotlin.jvm.internal.DefaultConstructorMarker r22) {
        /*
            r11 = this;
            r0 = r21
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000d
            io.ktor.http.URLProtocol$Companion r1 = io.ktor.http.URLProtocol.Companion
            io.ktor.http.URLProtocol r1 = r1.getHTTP()
            goto L_0x000e
        L_0x000d:
            r1 = r12
        L_0x000e:
            r2 = r0 & 2
            java.lang.String r3 = ""
            if (r2 == 0) goto L_0x0016
            r2 = r3
            goto L_0x0017
        L_0x0016:
            r2 = r13
        L_0x0017:
            r4 = r0 & 4
            r5 = 0
            if (r4 == 0) goto L_0x001e
            r4 = r5
            goto L_0x001f
        L_0x001e:
            r4 = r14
        L_0x001f:
            r6 = r0 & 8
            r7 = 0
            if (r6 == 0) goto L_0x0026
            r6 = r7
            goto L_0x0027
        L_0x0026:
            r6 = r15
        L_0x0027:
            r8 = r0 & 16
            if (r8 == 0) goto L_0x002c
            goto L_0x002e
        L_0x002c:
            r7 = r16
        L_0x002e:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0037
            java.util.List r8 = kotlin.collections.CollectionsKt.emptyList()
            goto L_0x0039
        L_0x0037:
            r8 = r17
        L_0x0039:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x0044
            io.ktor.http.Parameters$Companion r9 = io.ktor.http.Parameters.Companion
            io.ktor.http.Parameters r9 = r9.getEmpty()
            goto L_0x0046
        L_0x0044:
            r9 = r18
        L_0x0046:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x004b
            goto L_0x004d
        L_0x004b:
            r3 = r19
        L_0x004d:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0052
            goto L_0x0054
        L_0x0052:
            r5 = r20
        L_0x0054:
            r12 = r11
            r13 = r1
            r14 = r2
            r15 = r4
            r16 = r6
            r17 = r7
            r18 = r8
            r19 = r9
            r20 = r3
            r21 = r5
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.URLBuilder.<init>(io.ktor.http.URLProtocol, java.lang.String, int, java.lang.String, java.lang.String, java.util.List, io.ktor.http.Parameters, java.lang.String, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final URLProtocol getProtocol() {
        return this.protocol;
    }

    public final void setProtocol(URLProtocol uRLProtocol) {
        Intrinsics.checkNotNullParameter(uRLProtocol, "<set-?>");
        this.protocol = uRLProtocol;
    }

    public final String getHost() {
        return this.host;
    }

    public final void setHost(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.host = str;
    }

    public final int getPort() {
        return this.port;
    }

    public final void setPort(int i) {
        this.port = i;
    }

    public final boolean getTrailingQuery() {
        return this.trailingQuery;
    }

    public final void setTrailingQuery(boolean z) {
        this.trailingQuery = z;
    }

    public final String getEncodedUser() {
        return this.encodedUser;
    }

    public final void setEncodedUser(String str) {
        this.encodedUser = str;
    }

    public final String getUser() {
        String str = this.encodedUser;
        if (str != null) {
            return CodecsKt.decodeURLPart$default(str, 0, 0, (Charset) null, 7, (Object) null);
        }
        return null;
    }

    public final void setUser(String str) {
        String str2 = null;
        if (str != null) {
            str2 = CodecsKt.encodeURLParameter$default(str, false, 1, (Object) null);
        }
        this.encodedUser = str2;
    }

    public final String getEncodedPassword() {
        return this.encodedPassword;
    }

    public final void setEncodedPassword(String str) {
        this.encodedPassword = str;
    }

    public final String getPassword() {
        String str = this.encodedPassword;
        if (str != null) {
            return CodecsKt.decodeURLPart$default(str, 0, 0, (Charset) null, 7, (Object) null);
        }
        return null;
    }

    public final void setPassword(String str) {
        String str2 = null;
        if (str != null) {
            str2 = CodecsKt.encodeURLParameter$default(str, false, 1, (Object) null);
        }
        this.encodedPassword = str2;
    }

    public final String getEncodedFragment() {
        return this.encodedFragment;
    }

    public final void setEncodedFragment(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.encodedFragment = str;
    }

    public final String getFragment() {
        return CodecsKt.decodeURLQueryComponent$default(this.encodedFragment, 0, 0, false, (Charset) null, 15, (Object) null);
    }

    public final void setFragment(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.encodedFragment = CodecsKt.encodeURLQueryComponent$default(str, false, false, (Charset) null, 7, (Object) null);
    }

    public final List<String> getEncodedPathSegments() {
        return this.encodedPathSegments;
    }

    public final void setEncodedPathSegments(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.encodedPathSegments = list;
    }

    public final List<String> getPathSegments() {
        Iterable<String> iterable = this.encodedPathSegments;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (String decodeURLPart$default : iterable) {
            arrayList.add(CodecsKt.decodeURLPart$default(decodeURLPart$default, 0, 0, (Charset) null, 7, (Object) null));
        }
        return (List) arrayList;
    }

    public final void setPathSegments(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "value");
        Iterable<String> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (String encodeURLPath : iterable) {
            arrayList.add(CodecsKt.encodeURLPath(encodeURLPath));
        }
        this.encodedPathSegments = (List) arrayList;
    }

    public final ParametersBuilder getEncodedParameters() {
        return this.encodedParameters;
    }

    public final void setEncodedParameters(ParametersBuilder parametersBuilder) {
        Intrinsics.checkNotNullParameter(parametersBuilder, "value");
        this.encodedParameters = parametersBuilder;
        this.parameters = new UrlDecodedParametersBuilder(parametersBuilder);
    }

    public final ParametersBuilder getParameters() {
        return this.parameters;
    }

    public final String buildString() {
        applyOrigin();
        String sb = ((StringBuilder) URLBuilderKt.appendTo(this, new StringBuilder(256))).toString();
        Intrinsics.checkNotNullExpressionValue(sb, "appendTo(StringBuilder(256)).toString()");
        return sb;
    }

    public final Url build() {
        applyOrigin();
        return new Url(this.protocol, this.host, this.port, getPathSegments(), this.parameters.build(), getFragment(), getUser(), getPassword(), this.trailingQuery, buildString());
    }

    private final void applyOrigin() {
        if (!(this.host.length() > 0) && !Intrinsics.areEqual(this.protocol.getName(), "file")) {
            Url url = originUrl;
            this.host = url.getHost();
            if (Intrinsics.areEqual(this.protocol, URLProtocol.Companion.getHTTP())) {
                this.protocol = url.getProtocol();
            }
            if (this.port == 0) {
                this.port = url.getSpecifiedPort();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lio/ktor/http/URLBuilder$Companion;", "", "()V", "originUrl", "Lio/ktor/http/Url;", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: URLBuilder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion companion = new Companion((DefaultConstructorMarker) null);
        Companion = companion;
        originUrl = URLUtilsKt.Url(URLBuilderJvmKt.getOrigin(companion));
    }
}
