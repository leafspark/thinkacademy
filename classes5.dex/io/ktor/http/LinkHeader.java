package io.ktor.http;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\u0011\u0012B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0006\"\u00020\u0003¢\u0006\u0002\u0010\u0007B%\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bB\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\b¢\u0006\u0002\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lio/ktor/http/LinkHeader;", "Lio/ktor/http/HeaderValueWithParameters;", "uri", "", "rel", "(Ljava/lang/String;Ljava/lang/String;)V", "", "(Ljava/lang/String;[Ljava/lang/String;)V", "", "type", "Lio/ktor/http/ContentType;", "(Ljava/lang/String;Ljava/util/List;Lio/ktor/http/ContentType;)V", "params", "Lio/ktor/http/HeaderValueParam;", "(Ljava/lang/String;Ljava/util/List;)V", "getUri", "()Ljava/lang/String;", "Parameters", "Rel", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LinkHeader.kt */
public final class LinkHeader extends HeaderValueWithParameters {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LinkHeader(String str, List<HeaderValueParam> list) {
        super(Typography.less + str + Typography.greater, list);
        Intrinsics.checkNotNullParameter(str, "uri");
        Intrinsics.checkNotNullParameter(list, "params");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LinkHeader(String str, String str2) {
        this(str, (List<HeaderValueParam>) CollectionsKt.listOf(new HeaderValueParam(Parameters.Rel, str2)));
        Intrinsics.checkNotNullParameter(str, "uri");
        Intrinsics.checkNotNullParameter(str2, Parameters.Rel);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LinkHeader(String str, String... strArr) {
        this(str, (List<HeaderValueParam>) CollectionsKt.listOf(new HeaderValueParam(Parameters.Rel, ArraysKt.joinToString$default(strArr, " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null))));
        Intrinsics.checkNotNullParameter(str, "uri");
        Intrinsics.checkNotNullParameter(strArr, Parameters.Rel);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public LinkHeader(java.lang.String r17, java.util.List<java.lang.String> r18, io.ktor.http.ContentType r19) {
        /*
            r16 = this;
            r0 = r17
            r1 = r18
            java.lang.String r2 = "uri"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            java.lang.String r2 = "rel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            java.lang.String r3 = "type"
            r4 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r3)
            r5 = 2
            io.ktor.http.HeaderValueParam[] r5 = new io.ktor.http.HeaderValueParam[r5]
            io.ktor.http.HeaderValueParam r6 = new io.ktor.http.HeaderValueParam
            r7 = r1
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.lang.String r1 = " "
            r8 = r1
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 62
            r15 = 0
            java.lang.String r1 = kotlin.collections.CollectionsKt.joinToString$default(r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r6.<init>(r2, r1)
            r1 = 0
            r5[r1] = r6
            io.ktor.http.HeaderValueParam r1 = new io.ktor.http.HeaderValueParam
            java.lang.String r2 = r19.toString()
            r1.<init>(r3, r2)
            r2 = 1
            r5[r2] = r1
            java.util.List r1 = kotlin.collections.CollectionsKt.listOf(r5)
            r2 = r16
            r2.<init>((java.lang.String) r0, (java.util.List<io.ktor.http.HeaderValueParam>) r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.LinkHeader.<init>(java.lang.String, java.util.List, io.ktor.http.ContentType):void");
    }

    public final String getUri() {
        return StringsKt.removeSuffix(StringsKt.removePrefix(getContent(), (CharSequence) "<"), (CharSequence) ">");
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lio/ktor/http/LinkHeader$Parameters;", "", "()V", "Anchor", "", "HrefLang", "Media", "Rel", "Rev", "Title", "Type", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LinkHeader.kt */
    public static final class Parameters {
        public static final String Anchor = "anchor";
        public static final String HrefLang = "hreflang";
        public static final Parameters INSTANCE = new Parameters();
        public static final String Media = "media";
        public static final String Rel = "rel";
        public static final String Rev = "Rev";
        public static final String Title = "title";
        public static final String Type = "type";

        private Parameters() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lio/ktor/http/LinkHeader$Rel;", "", "()V", "DnsPrefetch", "", "Next", "PreConnect", "PreLoad", "PreRender", "Prefetch", "Stylesheet", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LinkHeader.kt */
    public static final class Rel {
        public static final String DnsPrefetch = "dns-prefetch";
        public static final Rel INSTANCE = new Rel();
        public static final String Next = "next";
        public static final String PreConnect = "preconnect";
        public static final String PreLoad = "preload";
        public static final String PreRender = "prerender";
        public static final String Prefetch = "prefetch";
        public static final String Stylesheet = "stylesheet";

        private Rel() {
        }
    }
}
