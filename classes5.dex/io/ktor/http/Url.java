package io.ktor.http;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b,\u0018\u0000 ;2\u00020\u0001:\u0001;Ba\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0005¢\u0006\u0002\u0010\u0012J\u0013\u00107\u001a\u00020\u00102\b\u00108\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u00109\u001a\u00020\u0007H\u0016J\b\u0010:\u001a\u00020\u0005H\u0016R\u001b\u0010\u0013\u001a\u00020\u00058FX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00058FX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u0019\u0010\u0015R\u001b\u0010\u001b\u001a\u00020\u00058FX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0017\u001a\u0004\b\u001c\u0010\u0015R\u001b\u0010\u001e\u001a\u00020\u00058FX\u0002¢\u0006\f\n\u0004\b \u0010\u0017\u001a\u0004\b\u001f\u0010\u0015R\u001b\u0010!\u001a\u00020\u00058FX\u0002¢\u0006\f\n\u0004\b#\u0010\u0017\u001a\u0004\b\"\u0010\u0015R\u001d\u0010$\u001a\u0004\u0018\u00010\u00058FX\u0002¢\u0006\f\n\u0004\b&\u0010\u0017\u001a\u0004\b%\u0010\u0015R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0015R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010.\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b/\u00100R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b3\u00100R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u000e\u0010\u0011\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u0015¨\u0006<"}, d2 = {"Lio/ktor/http/Url;", "", "protocol", "Lio/ktor/http/URLProtocol;", "host", "", "specifiedPort", "", "pathSegments", "", "parameters", "Lio/ktor/http/Parameters;", "fragment", "user", "password", "trailingQuery", "", "urlString", "(Lio/ktor/http/URLProtocol;Ljava/lang/String;ILjava/util/List;Lio/ktor/http/Parameters;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "encodedFragment", "getEncodedFragment", "()Ljava/lang/String;", "encodedFragment$delegate", "Lkotlin/Lazy;", "encodedPassword", "getEncodedPassword", "encodedPassword$delegate", "encodedPath", "getEncodedPath", "encodedPath$delegate", "encodedPathAndQuery", "getEncodedPathAndQuery", "encodedPathAndQuery$delegate", "encodedQuery", "getEncodedQuery", "encodedQuery$delegate", "encodedUser", "getEncodedUser", "encodedUser$delegate", "getFragment", "getHost", "getParameters", "()Lio/ktor/http/Parameters;", "getPassword", "getPathSegments", "()Ljava/util/List;", "port", "getPort", "()I", "getProtocol", "()Lio/ktor/http/URLProtocol;", "getSpecifiedPort", "getTrailingQuery", "()Z", "getUser", "equals", "other", "hashCode", "toString", "Companion", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Url.kt */
public final class Url {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Lazy encodedFragment$delegate;
    private final Lazy encodedPassword$delegate;
    private final Lazy encodedPath$delegate;
    private final Lazy encodedPathAndQuery$delegate;
    private final Lazy encodedQuery$delegate;
    private final Lazy encodedUser$delegate;
    private final String fragment;
    private final String host;
    private final Parameters parameters;
    private final String password;
    private final List<String> pathSegments;
    private final URLProtocol protocol;
    private final int specifiedPort;
    private final boolean trailingQuery;
    /* access modifiers changed from: private */
    public final String urlString;
    private final String user;

    public Url(URLProtocol uRLProtocol, String str, int i, List<String> list, Parameters parameters2, String str2, String str3, String str4, boolean z, String str5) {
        Intrinsics.checkNotNullParameter(uRLProtocol, "protocol");
        Intrinsics.checkNotNullParameter(str, "host");
        Intrinsics.checkNotNullParameter(list, "pathSegments");
        Intrinsics.checkNotNullParameter(parameters2, "parameters");
        Intrinsics.checkNotNullParameter(str2, "fragment");
        Intrinsics.checkNotNullParameter(str5, "urlString");
        this.protocol = uRLProtocol;
        this.host = str;
        this.specifiedPort = i;
        this.pathSegments = list;
        this.parameters = parameters2;
        this.fragment = str2;
        this.user = str3;
        this.password = str4;
        this.trailingQuery = z;
        this.urlString = str5;
        boolean z2 = true;
        if (!(i >= 0 && i < 65536) && i != 0) {
            z2 = false;
        }
        if (z2) {
            this.encodedPath$delegate = LazyKt.lazy(new Url$encodedPath$2(this));
            this.encodedQuery$delegate = LazyKt.lazy(new Url$encodedQuery$2(this));
            this.encodedPathAndQuery$delegate = LazyKt.lazy(new Url$encodedPathAndQuery$2(this));
            this.encodedUser$delegate = LazyKt.lazy(new Url$encodedUser$2(this));
            this.encodedPassword$delegate = LazyKt.lazy(new Url$encodedPassword$2(this));
            this.encodedFragment$delegate = LazyKt.lazy(new Url$encodedFragment$2(this));
            return;
        }
        throw new IllegalArgumentException("port must be between 0 and 65535, or 0 if not set".toString());
    }

    public final URLProtocol getProtocol() {
        return this.protocol;
    }

    public final String getHost() {
        return this.host;
    }

    public final int getSpecifiedPort() {
        return this.specifiedPort;
    }

    public final List<String> getPathSegments() {
        return this.pathSegments;
    }

    public final Parameters getParameters() {
        return this.parameters;
    }

    public final String getFragment() {
        return this.fragment;
    }

    public final String getUser() {
        return this.user;
    }

    public final String getPassword() {
        return this.password;
    }

    public final boolean getTrailingQuery() {
        return this.trailingQuery;
    }

    public final int getPort() {
        Integer valueOf = Integer.valueOf(this.specifiedPort);
        if (valueOf.intValue() == 0) {
            valueOf = null;
        }
        return valueOf != null ? valueOf.intValue() : this.protocol.getDefaultPort();
    }

    public final String getEncodedPath() {
        return (String) this.encodedPath$delegate.getValue();
    }

    public final String getEncodedQuery() {
        return (String) this.encodedQuery$delegate.getValue();
    }

    public final String getEncodedPathAndQuery() {
        return (String) this.encodedPathAndQuery$delegate.getValue();
    }

    public final String getEncodedUser() {
        return (String) this.encodedUser$delegate.getValue();
    }

    public final String getEncodedPassword() {
        return (String) this.encodedPassword$delegate.getValue();
    }

    public final String getEncodedFragment() {
        return (String) this.encodedFragment$delegate.getValue();
    }

    public String toString() {
        return this.urlString;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(getClass()), Reflection.getOrCreateKotlinClass(obj.getClass())) && Intrinsics.areEqual(this.urlString, ((Url) obj).urlString);
    }

    public int hashCode() {
        return this.urlString.hashCode();
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lio/ktor/http/Url$Companion;", "", "()V", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Url.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
