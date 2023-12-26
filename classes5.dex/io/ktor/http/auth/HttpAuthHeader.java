package io.ktor.http.auth;

import io.ktor.http.CodecsKt;
import io.ktor.http.ContentDisposition;
import io.ktor.http.HeaderValueParam;
import io.ktor.http.HeaderValueWithParametersKt;
import io.ktor.http.parsing.ParseException;
import io.ktor.util.CryptoKt;
import io.ktor.util.Hash;
import io.ktor.utils.io.charsets.CharsetJVMKt;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u000b2\u00020\u0001:\u0004\u000b\f\r\u000eB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0001\u0002\u000f\u0010¨\u0006\u0011"}, d2 = {"Lio/ktor/http/auth/HttpAuthHeader;", "", "authScheme", "", "(Ljava/lang/String;)V", "getAuthScheme", "()Ljava/lang/String;", "render", "encoding", "Lio/ktor/http/auth/HeaderValueEncoding;", "toString", "Companion", "Parameterized", "Parameters", "Single", "Lio/ktor/http/auth/HttpAuthHeader$Single;", "Lio/ktor/http/auth/HttpAuthHeader$Parameterized;", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HttpAuthHeader.kt */
public abstract class HttpAuthHeader {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String authScheme;

    public /* synthetic */ HttpAuthHeader(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public abstract String render();

    public abstract String render(HeaderValueEncoding headerValueEncoding);

    private HttpAuthHeader(String str) {
        this.authScheme = str;
        if (!HttpAuthHeaderKt.token68Pattern.matches(str)) {
            throw new ParseException("Invalid authScheme value: it should be token, but instead it is " + str, (Throwable) null, 2, (DefaultConstructorMarker) null);
        }
    }

    public final String getAuthScheme() {
        return this.authScheme;
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lio/ktor/http/auth/HttpAuthHeader$Single;", "Lio/ktor/http/auth/HttpAuthHeader;", "authScheme", "", "blob", "(Ljava/lang/String;Ljava/lang/String;)V", "getBlob", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "render", "encoding", "Lio/ktor/http/auth/HeaderValueEncoding;", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HttpAuthHeader.kt */
    public static final class Single extends HttpAuthHeader {
        private final String blob;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Single(String str, String str2) {
            super(str, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "authScheme");
            Intrinsics.checkNotNullParameter(str2, "blob");
            this.blob = str2;
            if (!HttpAuthHeaderKt.token68Pattern.matches(str2)) {
                throw new ParseException("Invalid blob value: it should be token68, but instead it is " + str2, (Throwable) null, 2, (DefaultConstructorMarker) null);
            }
        }

        public final String getBlob() {
            return this.blob;
        }

        public String render() {
            return getAuthScheme() + ' ' + this.blob;
        }

        public String render(HeaderValueEncoding headerValueEncoding) {
            Intrinsics.checkNotNullParameter(headerValueEncoding, "encoding");
            return render();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Single)) {
                return false;
            }
            Single single = (Single) obj;
            if (!StringsKt.equals(single.getAuthScheme(), getAuthScheme(), true) || !StringsKt.equals(single.blob, this.blob, true)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            Hash hash = Hash.INSTANCE;
            String lowerCase = getAuthScheme().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            String lowerCase2 = this.blob.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            return hash.combine(lowerCase, lowerCase2);
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B-\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0017\u001a\u00020\u0003J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0016\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0003J\u0016\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0003J\u0014\u0010\u001c\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0002R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Lio/ktor/http/auth/HttpAuthHeader$Parameterized;", "Lio/ktor/http/auth/HttpAuthHeader;", "authScheme", "", "parameters", "", "encoding", "Lio/ktor/http/auth/HeaderValueEncoding;", "(Ljava/lang/String;Ljava/util/Map;Lio/ktor/http/auth/HeaderValueEncoding;)V", "", "Lio/ktor/http/HeaderValueParam;", "(Ljava/lang/String;Ljava/util/List;Lio/ktor/http/auth/HeaderValueEncoding;)V", "getEncoding", "()Lio/ktor/http/auth/HeaderValueEncoding;", "getParameters", "()Ljava/util/List;", "equals", "", "other", "", "hashCode", "", "parameter", "name", "render", "withParameter", "value", "withReplacedParameter", "encode", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HttpAuthHeader.kt */
    public static final class Parameterized extends HttpAuthHeader {
        private final HeaderValueEncoding encoding;
        private final List<HeaderValueParam> parameters;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: HttpAuthHeader.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[HeaderValueEncoding.values().length];
                iArr[HeaderValueEncoding.QUOTED_WHEN_REQUIRED.ordinal()] = 1;
                iArr[HeaderValueEncoding.QUOTED_ALWAYS.ordinal()] = 2;
                iArr[HeaderValueEncoding.URI_ENCODE.ordinal()] = 3;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public final List<HeaderValueParam> getParameters() {
            return this.parameters;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Parameterized(String str, List list, HeaderValueEncoding headerValueEncoding, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (List<HeaderValueParam>) list, (i & 4) != 0 ? HeaderValueEncoding.QUOTED_WHEN_REQUIRED : headerValueEncoding);
        }

        public final HeaderValueEncoding getEncoding() {
            return this.encoding;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Parameterized(String str, List<HeaderValueParam> list, HeaderValueEncoding headerValueEncoding) {
            super(str, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "authScheme");
            Intrinsics.checkNotNullParameter(list, "parameters");
            Intrinsics.checkNotNullParameter(headerValueEncoding, "encoding");
            this.parameters = list;
            this.encoding = headerValueEncoding;
            for (HeaderValueParam headerValueParam : list) {
                if (!HttpAuthHeaderKt.token68Pattern.matches(headerValueParam.getName())) {
                    throw new ParseException("parameter name should be a token but it is " + headerValueParam.getName(), (Throwable) null, 2, (DefaultConstructorMarker) null);
                }
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Parameterized(String str, Map map, HeaderValueEncoding headerValueEncoding, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (Map<String, String>) map, (i & 4) != 0 ? HeaderValueEncoding.QUOTED_WHEN_REQUIRED : headerValueEncoding);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public Parameterized(java.lang.String r5, java.util.Map<java.lang.String, java.lang.String> r6, io.ktor.http.auth.HeaderValueEncoding r7) {
            /*
                r4 = this;
                java.lang.String r0 = "authScheme"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                java.lang.String r0 = "parameters"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                java.lang.String r0 = "encoding"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                java.util.Set r6 = r6.entrySet()
                java.lang.Iterable r6 = (java.lang.Iterable) r6
                java.util.ArrayList r0 = new java.util.ArrayList
                r1 = 10
                int r1 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r6, r1)
                r0.<init>(r1)
                java.util.Collection r0 = (java.util.Collection) r0
                java.util.Iterator r6 = r6.iterator()
            L_0x0026:
                boolean r1 = r6.hasNext()
                if (r1 == 0) goto L_0x0047
                java.lang.Object r1 = r6.next()
                java.util.Map$Entry r1 = (java.util.Map.Entry) r1
                io.ktor.http.HeaderValueParam r2 = new io.ktor.http.HeaderValueParam
                java.lang.Object r3 = r1.getKey()
                java.lang.String r3 = (java.lang.String) r3
                java.lang.Object r1 = r1.getValue()
                java.lang.String r1 = (java.lang.String) r1
                r2.<init>(r3, r1)
                r0.add(r2)
                goto L_0x0026
            L_0x0047:
                java.util.List r0 = (java.util.List) r0
                r4.<init>((java.lang.String) r5, (java.util.List<io.ktor.http.HeaderValueParam>) r0, (io.ktor.http.auth.HeaderValueEncoding) r7)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.auth.HttpAuthHeader.Parameterized.<init>(java.lang.String, java.util.Map, io.ktor.http.auth.HeaderValueEncoding):void");
        }

        public final Parameterized withParameter(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
            Intrinsics.checkNotNullParameter(str2, "value");
            return new Parameterized(getAuthScheme(), (List<HeaderValueParam>) CollectionsKt.plus(this.parameters, new HeaderValueParam(str, str2)), this.encoding);
        }

        public final Parameterized withReplacedParameter(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
            Intrinsics.checkNotNullParameter(str2, "value");
            Iterator<HeaderValueParam> it = this.parameters.iterator();
            boolean z = false;
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                } else if (Intrinsics.areEqual(it.next().getName(), str)) {
                    break;
                } else {
                    i++;
                }
            }
            if (i == -1) {
                return withParameter(str, str2);
            }
            Collection arrayList = new ArrayList();
            for (HeaderValueParam headerValueParam : this.parameters) {
                if (Intrinsics.areEqual(headerValueParam.getName(), str)) {
                    if (!z) {
                        headerValueParam = new HeaderValueParam(str, str2);
                        z = true;
                    } else {
                        headerValueParam = null;
                    }
                }
                if (headerValueParam != null) {
                    arrayList.add(headerValueParam);
                }
            }
            return new Parameterized(getAuthScheme(), (List<HeaderValueParam>) (List) arrayList, this.encoding);
        }

        public String render(HeaderValueEncoding headerValueEncoding) {
            Intrinsics.checkNotNullParameter(headerValueEncoding, "encoding");
            return CollectionsKt.joinToString$default(this.parameters, ", ", getAuthScheme() + ' ', (CharSequence) null, 0, (CharSequence) null, new HttpAuthHeader$Parameterized$render$1(this, headerValueEncoding), 28, (Object) null);
        }

        public final String parameter(String str) {
            Object obj;
            Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
            Iterator it = this.parameters.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual(((HeaderValueParam) obj).getName(), str)) {
                    break;
                }
            }
            HeaderValueParam headerValueParam = (HeaderValueParam) obj;
            if (headerValueParam != null) {
                return headerValueParam.getValue();
            }
            return null;
        }

        /* access modifiers changed from: private */
        public final String encode(String str, HeaderValueEncoding headerValueEncoding) {
            int i = WhenMappings.$EnumSwitchMapping$0[headerValueEncoding.ordinal()];
            if (i == 1) {
                return HeaderValueWithParametersKt.escapeIfNeeded(str);
            }
            if (i == 2) {
                return HeaderValueWithParametersKt.quote(str);
            }
            if (i == 3) {
                return CodecsKt.encodeURLParameter$default(str, false, 1, (Object) null);
            }
            throw new NoWhenBranchMatchedException();
        }

        public String render() {
            return render(this.encoding);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Parameterized)) {
                return false;
            }
            Parameterized parameterized = (Parameterized) obj;
            if (!StringsKt.equals(parameterized.getAuthScheme(), getAuthScheme(), true) || !Intrinsics.areEqual(parameterized.parameters, this.parameters)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            Hash hash = Hash.INSTANCE;
            String lowerCase = getAuthScheme().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            return hash.combine(lowerCase, this.parameters);
        }
    }

    public String toString() {
        return render();
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\tJO\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0006¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"Lio/ktor/http/auth/HttpAuthHeader$Companion;", "", "()V", "basicAuthChallenge", "Lio/ktor/http/auth/HttpAuthHeader$Parameterized;", "realm", "", "charset", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "digestAuthChallenge", "nonce", "domain", "", "opaque", "stale", "", "algorithm", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Lio/ktor/http/auth/HttpAuthHeader$Parameterized;", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HttpAuthHeader.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Parameterized basicAuthChallenge(String str, Charset charset) {
            Intrinsics.checkNotNullParameter(str, Parameters.Realm);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(Parameters.Realm, str);
            if (charset != null) {
                linkedHashMap.put(Parameters.Charset, CharsetJVMKt.getName(charset));
            }
            return new Parameterized(AuthScheme.Basic, (Map) linkedHashMap, (HeaderValueEncoding) null, 4, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ Parameterized digestAuthChallenge$default(Companion companion, String str, String str2, List list, String str3, Boolean bool, String str4, int i, Object obj) {
            if ((i & 2) != 0) {
                str2 = CryptoKt.generateNonce();
            }
            String str5 = str2;
            if ((i & 4) != 0) {
                list = CollectionsKt.emptyList();
            }
            List list2 = list;
            String str6 = (i & 8) != 0 ? null : str3;
            Boolean bool2 = (i & 16) != 0 ? null : bool;
            if ((i & 32) != 0) {
                str4 = "MD5";
            }
            return companion.digestAuthChallenge(str, str5, list2, str6, bool2, str4);
        }

        public final Parameterized digestAuthChallenge(String str, String str2, List<String> list, String str3, Boolean bool, String str4) {
            String str5 = str;
            String str6 = str2;
            List<String> list2 = list;
            String str7 = str3;
            String str8 = str4;
            Intrinsics.checkNotNullParameter(str5, Parameters.Realm);
            Intrinsics.checkNotNullParameter(str6, "nonce");
            Intrinsics.checkNotNullParameter(list2, "domain");
            Intrinsics.checkNotNullParameter(str8, "algorithm");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(Parameters.Realm, str5);
            linkedHashMap.put("nonce", str6);
            if (!list2.isEmpty()) {
                linkedHashMap.put("domain", CollectionsKt.joinToString$default(list2, " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
            }
            if (str7 != null) {
                linkedHashMap.put("opaque", str7);
            }
            if (bool != null) {
                linkedHashMap.put("stale", bool.toString());
            }
            linkedHashMap.put("algorithm", str8);
            return new Parameterized(AuthScheme.Digest, (Map<String, String>) linkedHashMap, HeaderValueEncoding.QUOTED_ALWAYS);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lio/ktor/http/auth/HttpAuthHeader$Parameters;", "", "()V", "Charset", "", "OAuthCallback", "OAuthCallbackConfirmed", "OAuthConsumerKey", "OAuthNonce", "OAuthSignature", "OAuthSignatureMethod", "OAuthTimestamp", "OAuthToken", "OAuthTokenSecret", "OAuthVerifier", "OAuthVersion", "Realm", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HttpAuthHeader.kt */
    public static final class Parameters {
        public static final String Charset = "charset";
        public static final Parameters INSTANCE = new Parameters();
        public static final String OAuthCallback = "oauth_callback";
        public static final String OAuthCallbackConfirmed = "oauth_callback_confirmed";
        public static final String OAuthConsumerKey = "oauth_consumer_key";
        public static final String OAuthNonce = "oauth_nonce";
        public static final String OAuthSignature = "oauth_signature";
        public static final String OAuthSignatureMethod = "oauth_signature_method";
        public static final String OAuthTimestamp = "oauth_timestamp";
        public static final String OAuthToken = "oauth_token";
        public static final String OAuthTokenSecret = "oauth_token_secret";
        public static final String OAuthVerifier = "oauth_verifier";
        public static final String OAuthVersion = "oauth_version";
        public static final String Realm = "realm";

        private Parameters() {
        }
    }
}
