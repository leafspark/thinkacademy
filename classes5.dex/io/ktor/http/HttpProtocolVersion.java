package io.ktor.http;

import io.ktor.http.ContentDisposition;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\b\u0010\u0015\u001a\u00020\u0003H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lio/ktor/http/HttpProtocolVersion;", "", "name", "", "major", "", "minor", "(Ljava/lang/String;II)V", "getMajor", "()I", "getMinor", "getName", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HttpProtocolVersion.kt */
public final class HttpProtocolVersion {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final HttpProtocolVersion HTTP_1_0 = new HttpProtocolVersion("HTTP", 1, 0);
    /* access modifiers changed from: private */
    public static final HttpProtocolVersion HTTP_1_1 = new HttpProtocolVersion("HTTP", 1, 1);
    /* access modifiers changed from: private */
    public static final HttpProtocolVersion HTTP_2_0 = new HttpProtocolVersion("HTTP", 2, 0);
    /* access modifiers changed from: private */
    public static final HttpProtocolVersion QUIC = new HttpProtocolVersion("QUIC", 1, 0);
    /* access modifiers changed from: private */
    public static final HttpProtocolVersion SPDY_3 = new HttpProtocolVersion("SPDY", 3, 0);
    private final int major;
    private final int minor;
    private final String name;

    public static /* synthetic */ HttpProtocolVersion copy$default(HttpProtocolVersion httpProtocolVersion, String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = httpProtocolVersion.name;
        }
        if ((i3 & 2) != 0) {
            i = httpProtocolVersion.major;
        }
        if ((i3 & 4) != 0) {
            i2 = httpProtocolVersion.minor;
        }
        return httpProtocolVersion.copy(str, i, i2);
    }

    public final String component1() {
        return this.name;
    }

    public final int component2() {
        return this.major;
    }

    public final int component3() {
        return this.minor;
    }

    public final HttpProtocolVersion copy(String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
        return new HttpProtocolVersion(str, i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HttpProtocolVersion)) {
            return false;
        }
        HttpProtocolVersion httpProtocolVersion = (HttpProtocolVersion) obj;
        return Intrinsics.areEqual(this.name, httpProtocolVersion.name) && this.major == httpProtocolVersion.major && this.minor == httpProtocolVersion.minor;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.major) * 31) + this.minor;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0017R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u0018"}, d2 = {"Lio/ktor/http/HttpProtocolVersion$Companion;", "", "()V", "HTTP_1_0", "Lio/ktor/http/HttpProtocolVersion;", "getHTTP_1_0", "()Lio/ktor/http/HttpProtocolVersion;", "HTTP_1_1", "getHTTP_1_1", "HTTP_2_0", "getHTTP_2_0", "QUIC", "getQUIC", "SPDY_3", "getSPDY_3", "fromValue", "name", "", "major", "", "minor", "parse", "value", "", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HttpProtocolVersion.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HttpProtocolVersion getHTTP_2_0() {
            return HttpProtocolVersion.HTTP_2_0;
        }

        public final HttpProtocolVersion getHTTP_1_1() {
            return HttpProtocolVersion.HTTP_1_1;
        }

        public final HttpProtocolVersion getHTTP_1_0() {
            return HttpProtocolVersion.HTTP_1_0;
        }

        public final HttpProtocolVersion getSPDY_3() {
            return HttpProtocolVersion.SPDY_3;
        }

        public final HttpProtocolVersion getQUIC() {
            return HttpProtocolVersion.QUIC;
        }

        public final HttpProtocolVersion fromValue(String str, int i, int i2) {
            Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
            if (Intrinsics.areEqual(str, "HTTP") && i == 1 && i2 == 1) {
                return getHTTP_1_1();
            }
            if (Intrinsics.areEqual(str, "HTTP") && i == 2 && i2 == 0) {
                return getHTTP_2_0();
            }
            return new HttpProtocolVersion(str, i, i2);
        }

        public final HttpProtocolVersion parse(CharSequence charSequence) {
            Intrinsics.checkNotNullParameter(charSequence, "value");
            List split$default = StringsKt.split$default(charSequence, new String[]{"/", "."}, false, 0, 6, (Object) null);
            if (split$default.size() == 3) {
                return fromValue((String) split$default.get(0), Integer.parseInt((String) split$default.get(1)), Integer.parseInt((String) split$default.get(2)));
            }
            throw new IllegalStateException(("Failed to parse HttpProtocolVersion. Expected format: protocol/major.minor, but actual: " + charSequence).toString());
        }
    }

    public HttpProtocolVersion(String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
        this.name = str;
        this.major = i;
        this.minor = i2;
    }

    public final int getMajor() {
        return this.major;
    }

    public final int getMinor() {
        return this.minor;
    }

    public final String getName() {
        return this.name;
    }

    public String toString() {
        return this.name + '/' + this.major + '.' + this.minor;
    }
}
