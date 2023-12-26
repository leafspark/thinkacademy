package io.ktor.http;

import com.tekartik.sqflite.Constant;
import io.ktor.http.ContentDisposition;
import io.ktor.http.HeaderValueWithParameters;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r\u0018\u0000 \u001d2\u00020\u0001:\b\u001b\u001c\u001d\u001e\u001f !\"B'\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bB/\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\nJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u000e\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0000J\u000e\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0003J\u0016\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003J\u0006\u0010\u001a\u001a\u00020\u0000R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006#"}, d2 = {"Lio/ktor/http/ContentType;", "Lio/ktor/http/HeaderValueWithParameters;", "contentType", "", "contentSubtype", "parameters", "", "Lio/ktor/http/HeaderValueParam;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "existingContent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getContentSubtype", "()Ljava/lang/String;", "getContentType", "equals", "", "other", "", "hasParameter", "name", "value", "hashCode", "", "match", "pattern", "withParameter", "withoutParameters", "Application", "Audio", "Companion", "Image", "Message", "MultiPart", "Text", "Video", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ContentTypes.kt */
public final class ContentType extends HeaderValueWithParameters {
    /* access modifiers changed from: private */
    public static final ContentType Any = new ContentType("*", "*", (List) null, 4, (DefaultConstructorMarker) null);
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String contentSubtype;
    private final String contentType;

    public final String getContentType() {
        return this.contentType;
    }

    public final String getContentSubtype() {
        return this.contentSubtype;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    /* synthetic */ ContentType(String str, String str2, String str3, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i & 8) != 0 ? CollectionsKt.emptyList() : list);
    }

    private ContentType(String str, String str2, String str3, List<HeaderValueParam> list) {
        super(str3, list);
        this.contentType = str;
        this.contentSubtype = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ContentType(String str, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? CollectionsKt.emptyList() : list);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ContentType(String str, String str2, List<HeaderValueParam> list) {
        this(str, str2, str + '/' + str2, list);
        Intrinsics.checkNotNullParameter(str, "contentType");
        Intrinsics.checkNotNullParameter(str2, "contentSubtype");
        Intrinsics.checkNotNullParameter(list, "parameters");
    }

    public final ContentType withParameter(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
        Intrinsics.checkNotNullParameter(str2, "value");
        if (hasParameter(str, str2)) {
            return this;
        }
        return new ContentType(this.contentType, this.contentSubtype, getContent(), CollectionsKt.plus(getParameters(), new HeaderValueParam(str, str2)));
    }

    private final boolean hasParameter(String str, String str2) {
        boolean z;
        int size = getParameters().size();
        if (size == 0) {
            return false;
        }
        if (size != 1) {
            Iterable<HeaderValueParam> parameters = getParameters();
            if ((parameters instanceof Collection) && ((Collection) parameters).isEmpty()) {
                return false;
            }
            for (HeaderValueParam headerValueParam : parameters) {
                if (!StringsKt.equals(headerValueParam.getName(), str, true) || !StringsKt.equals(headerValueParam.getValue(), str2, true)) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (z) {
                }
            }
            return false;
        }
        HeaderValueParam headerValueParam2 = getParameters().get(0);
        if (!StringsKt.equals(headerValueParam2.getName(), str, true) || !StringsKt.equals(headerValueParam2.getValue(), str2, true)) {
            return false;
        }
        return true;
    }

    public final ContentType withoutParameters() {
        if (getParameters().isEmpty()) {
            return this;
        }
        return new ContentType(this.contentType, this.contentSubtype, (List) null, 4, (DefaultConstructorMarker) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0092, code lost:
        if (r4 != null) goto L_0x0057;
     */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009d A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean match(io.ktor.http.ContentType r7) {
        /*
            r6 = this;
            java.lang.String r0 = "pattern"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = r7.contentType
            java.lang.String r1 = "*"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L_0x001c
            java.lang.String r0 = r7.contentType
            java.lang.String r4 = r6.contentType
            boolean r0 = kotlin.text.StringsKt.equals(r0, r4, r3)
            if (r0 != 0) goto L_0x001c
            return r2
        L_0x001c:
            java.lang.String r0 = r7.contentSubtype
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 != 0) goto L_0x002f
            java.lang.String r0 = r7.contentSubtype
            java.lang.String r4 = r6.contentSubtype
            boolean r0 = kotlin.text.StringsKt.equals(r0, r4, r3)
            if (r0 != 0) goto L_0x002f
            return r2
        L_0x002f:
            java.util.List r7 = r7.getParameters()
            java.util.Iterator r7 = r7.iterator()
        L_0x0037:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L_0x009e
            java.lang.Object r0 = r7.next()
            io.ktor.http.HeaderValueParam r0 = (io.ktor.http.HeaderValueParam) r0
            java.lang.String r4 = r0.component1()
            java.lang.String r0 = r0.component2()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r1)
            if (r5 == 0) goto L_0x0088
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r4 == 0) goto L_0x0059
        L_0x0057:
            r0 = r3
            goto L_0x009b
        L_0x0059:
            java.util.List r4 = r6.getParameters()
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            boolean r5 = r4 instanceof java.util.Collection
            if (r5 == 0) goto L_0x006d
            r5 = r4
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L_0x006d
            goto L_0x0095
        L_0x006d:
            java.util.Iterator r4 = r4.iterator()
        L_0x0071:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0095
            java.lang.Object r5 = r4.next()
            io.ktor.http.HeaderValueParam r5 = (io.ktor.http.HeaderValueParam) r5
            java.lang.String r5 = r5.getValue()
            boolean r5 = kotlin.text.StringsKt.equals(r5, r0, r3)
            if (r5 == 0) goto L_0x0071
            goto L_0x0057
        L_0x0088:
            java.lang.String r4 = r6.parameter(r4)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r5 == 0) goto L_0x0097
            if (r4 == 0) goto L_0x0095
            goto L_0x0057
        L_0x0095:
            r0 = r2
            goto L_0x009b
        L_0x0097:
            boolean r0 = kotlin.text.StringsKt.equals(r4, r0, r3)
        L_0x009b:
            if (r0 != 0) goto L_0x0037
            return r2
        L_0x009e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.ContentType.match(io.ktor.http.ContentType):boolean");
    }

    public final boolean match(String str) {
        Intrinsics.checkNotNullParameter(str, "pattern");
        return match(Companion.parse(str));
    }

    public boolean equals(Object obj) {
        if (obj instanceof ContentType) {
            ContentType contentType2 = (ContentType) obj;
            if (!StringsKt.equals(this.contentType, contentType2.contentType, true) || !StringsKt.equals(this.contentSubtype, contentType2.contentSubtype, true) || !Intrinsics.areEqual(getParameters(), contentType2.getParameters())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        String lowerCase = this.contentType.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        int hashCode = lowerCase.hashCode();
        String lowerCase2 = this.contentSubtype.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return hashCode + (hashCode * 31) + lowerCase2.hashCode() + (getParameters().hashCode() * 31);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lio/ktor/http/ContentType$Companion;", "", "()V", "Any", "Lio/ktor/http/ContentType;", "getAny", "()Lio/ktor/http/ContentType;", "parse", "value", "", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ContentTypes.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ContentType parse(String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            if (StringsKt.isBlank(str)) {
                return getAny();
            }
            HeaderValueWithParameters.Companion companion = HeaderValueWithParameters.Companion;
            HeaderValue headerValue = (HeaderValue) CollectionsKt.last(HttpHeaderValueParserKt.parseHeaderValue(str));
            String value = headerValue.getValue();
            List<HeaderValueParam> params = headerValue.getParams();
            CharSequence charSequence = value;
            int indexOf$default = StringsKt.indexOf$default(charSequence, '/', 0, false, 6, (Object) null);
            if (indexOf$default != -1) {
                String substring = value.substring(0, indexOf$default);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                String obj = StringsKt.trim((CharSequence) substring).toString();
                CharSequence charSequence2 = obj;
                boolean z = true;
                if (!(charSequence2.length() == 0)) {
                    String substring2 = value.substring(indexOf$default + 1);
                    Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                    String obj2 = StringsKt.trim((CharSequence) substring2).toString();
                    if (!StringsKt.contains$default(charSequence2, ' ', false, 2, (Object) null)) {
                        CharSequence charSequence3 = obj2;
                        if (!StringsKt.contains$default(charSequence3, ' ', false, 2, (Object) null)) {
                            if (charSequence3.length() != 0) {
                                z = false;
                            }
                            if (!z && !StringsKt.contains$default(charSequence3, '/', false, 2, (Object) null)) {
                                return new ContentType(obj, obj2, params);
                            }
                            throw new BadContentTypeFormatException(str);
                        }
                    }
                    throw new BadContentTypeFormatException(str);
                }
                throw new BadContentTypeFormatException(str);
            } else if (Intrinsics.areEqual(StringsKt.trim(charSequence).toString(), "*")) {
                return ContentType.Companion.getAny();
            } else {
                throw new BadContentTypeFormatException(str);
            }
        }

        public final ContentType getAny() {
            return ContentType.Any;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b-\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0011\u0010\u0011\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0011\u0010\u0013\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0011\u0010\u0015\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0011\u0010\u0017\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u0011\u0010\u0019\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006R\u0011\u0010\u001b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006R\u0011\u0010\u001d\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0006R\u0011\u0010\u001f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0006R\u0011\u0010!\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0006R\u0011\u0010#\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0006R\u0011\u0010%\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0006R\u0011\u0010'\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0006R\u0011\u0010)\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0006R\u0011\u0010+\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0006R\u0011\u0010-\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0006R\u0011\u0010/\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0006¨\u00061"}, d2 = {"Lio/ktor/http/ContentType$Application;", "", "()V", "Any", "Lio/ktor/http/ContentType;", "getAny", "()Lio/ktor/http/ContentType;", "Atom", "getAtom", "Cbor", "getCbor", "Docx", "getDocx", "FontWoff", "getFontWoff", "FormUrlEncoded", "getFormUrlEncoded", "GZip", "getGZip", "HalJson", "getHalJson", "JavaScript", "getJavaScript", "Json", "getJson", "OctetStream", "getOctetStream", "Pdf", "getPdf", "Pptx", "getPptx", "ProblemJson", "getProblemJson", "ProblemXml", "getProblemXml", "ProtoBuf", "getProtoBuf", "Rss", "getRss", "Wasm", "getWasm", "Xlsx", "getXlsx", "Xml", "getXml", "Xml_Dtd", "getXml_Dtd", "Zip", "getZip", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ContentTypes.kt */
    public static final class Application {
        private static final ContentType Any = new ContentType("application", "*", (List) null, 4, (DefaultConstructorMarker) null);
        private static final ContentType Atom = new ContentType("application", "atom+xml", (List) null, 4, (DefaultConstructorMarker) null);
        private static final ContentType Cbor = new ContentType("application", "cbor", (List) null, 4, (DefaultConstructorMarker) null);
        private static final ContentType Docx = new ContentType("application", "vnd.openxmlformats-officedocument.wordprocessingml.document", (List) null, 4, (DefaultConstructorMarker) null);
        private static final ContentType FontWoff = new ContentType("application", "font-woff", (List) null, 4, (DefaultConstructorMarker) null);
        private static final ContentType FormUrlEncoded = new ContentType("application", "x-www-form-urlencoded", (List) null, 4, (DefaultConstructorMarker) null);
        private static final ContentType GZip = new ContentType("application", "gzip", (List) null, 4, (DefaultConstructorMarker) null);
        private static final ContentType HalJson = new ContentType("application", "hal+json", (List) null, 4, (DefaultConstructorMarker) null);
        public static final Application INSTANCE = new Application();
        private static final ContentType JavaScript = new ContentType("application", "javascript", (List) null, 4, (DefaultConstructorMarker) null);
        private static final ContentType Json = new ContentType("application", "json", (List) null, 4, (DefaultConstructorMarker) null);
        private static final ContentType OctetStream = new ContentType("application", "octet-stream", (List) null, 4, (DefaultConstructorMarker) null);
        private static final ContentType Pdf = new ContentType("application", "pdf", (List) null, 4, (DefaultConstructorMarker) null);
        private static final ContentType Pptx = new ContentType("application", "vnd.openxmlformats-officedocument.presentationml.presentation", (List) null, 4, (DefaultConstructorMarker) null);
        private static final ContentType ProblemJson = new ContentType("application", "problem+json", (List) null, 4, (DefaultConstructorMarker) null);
        private static final ContentType ProblemXml = new ContentType("application", "problem+xml", (List) null, 4, (DefaultConstructorMarker) null);
        private static final ContentType ProtoBuf = new ContentType("application", "protobuf", (List) null, 4, (DefaultConstructorMarker) null);
        private static final ContentType Rss = new ContentType("application", "rss+xml", (List) null, 4, (DefaultConstructorMarker) null);
        private static final ContentType Wasm = new ContentType("application", "wasm", (List) null, 4, (DefaultConstructorMarker) null);
        private static final ContentType Xlsx = new ContentType("application", "vnd.openxmlformats-officedocument.spreadsheetml.sheet", (List) null, 4, (DefaultConstructorMarker) null);
        private static final ContentType Xml = new ContentType("application", "xml", (List) null, 4, (DefaultConstructorMarker) null);
        private static final ContentType Xml_Dtd = new ContentType("application", "xml-dtd", (List) null, 4, (DefaultConstructorMarker) null);
        private static final ContentType Zip = new ContentType("application", "zip", (List) null, 4, (DefaultConstructorMarker) null);

        private Application() {
        }

        public final ContentType getAny() {
            return Any;
        }

        public final ContentType getAtom() {
            return Atom;
        }

        public final ContentType getCbor() {
            return Cbor;
        }

        public final ContentType getJson() {
            return Json;
        }

        public final ContentType getHalJson() {
            return HalJson;
        }

        public final ContentType getJavaScript() {
            return JavaScript;
        }

        public final ContentType getOctetStream() {
            return OctetStream;
        }

        public final ContentType getFontWoff() {
            return FontWoff;
        }

        public final ContentType getRss() {
            return Rss;
        }

        public final ContentType getXml() {
            return Xml;
        }

        public final ContentType getXml_Dtd() {
            return Xml_Dtd;
        }

        public final ContentType getZip() {
            return Zip;
        }

        public final ContentType getGZip() {
            return GZip;
        }

        public final ContentType getFormUrlEncoded() {
            return FormUrlEncoded;
        }

        public final ContentType getPdf() {
            return Pdf;
        }

        public final ContentType getXlsx() {
            return Xlsx;
        }

        public final ContentType getDocx() {
            return Docx;
        }

        public final ContentType getPptx() {
            return Pptx;
        }

        public final ContentType getProtoBuf() {
            return ProtoBuf;
        }

        public final ContentType getWasm() {
            return Wasm;
        }

        public final ContentType getProblemJson() {
            return ProblemJson;
        }

        public final ContentType getProblemXml() {
            return ProblemXml;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Lio/ktor/http/ContentType$Audio;", "", "()V", "Any", "Lio/ktor/http/ContentType;", "getAny", "()Lio/ktor/http/ContentType;", "MP4", "getMP4", "MPEG", "getMPEG", "OGG", "getOGG", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ContentTypes.kt */
    public static final class Audio {
        private static final ContentType Any = new ContentType("audio", "*", (List) null, 4, (DefaultConstructorMarker) null);
        public static final Audio INSTANCE = new Audio();
        private static final ContentType MP4 = new ContentType("audio", "mp4", (List) null, 4, (DefaultConstructorMarker) null);
        private static final ContentType MPEG = new ContentType("audio", "mpeg", (List) null, 4, (DefaultConstructorMarker) null);
        private static final ContentType OGG = new ContentType("audio", "ogg", (List) null, 4, (DefaultConstructorMarker) null);

        private Audio() {
        }

        public final ContentType getAny() {
            return Any;
        }

        public final ContentType getMP4() {
            return MP4;
        }

        public final ContentType getMPEG() {
            return MPEG;
        }

        public final ContentType getOGG() {
            return OGG;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006¨\u0006\u0011"}, d2 = {"Lio/ktor/http/ContentType$Image;", "", "()V", "Any", "Lio/ktor/http/ContentType;", "getAny", "()Lio/ktor/http/ContentType;", "GIF", "getGIF", "JPEG", "getJPEG", "PNG", "getPNG", "SVG", "getSVG", "XIcon", "getXIcon", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ContentTypes.kt */
    public static final class Image {
        private static final ContentType Any = new ContentType("image", "*", (List) null, 4, (DefaultConstructorMarker) null);
        private static final ContentType GIF = new ContentType("image", "gif", (List) null, 4, (DefaultConstructorMarker) null);
        public static final Image INSTANCE = new Image();
        private static final ContentType JPEG = new ContentType("image", "jpeg", (List) null, 4, (DefaultConstructorMarker) null);
        private static final ContentType PNG = new ContentType("image", "png", (List) null, 4, (DefaultConstructorMarker) null);
        private static final ContentType SVG = new ContentType("image", "svg+xml", (List) null, 4, (DefaultConstructorMarker) null);
        private static final ContentType XIcon = new ContentType("image", "x-icon", (List) null, 4, (DefaultConstructorMarker) null);

        private Image() {
        }

        public final ContentType getAny() {
            return Any;
        }

        public final ContentType getGIF() {
            return GIF;
        }

        public final ContentType getJPEG() {
            return JPEG;
        }

        public final ContentType getPNG() {
            return PNG;
        }

        public final ContentType getSVG() {
            return SVG;
        }

        public final ContentType getXIcon() {
            return XIcon;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lio/ktor/http/ContentType$Message;", "", "()V", "Any", "Lio/ktor/http/ContentType;", "getAny", "()Lio/ktor/http/ContentType;", "Http", "getHttp", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ContentTypes.kt */
    public static final class Message {
        private static final ContentType Any = new ContentType(Constant.PARAM_ERROR_MESSAGE, "*", (List) null, 4, (DefaultConstructorMarker) null);
        private static final ContentType Http = new ContentType(Constant.PARAM_ERROR_MESSAGE, "http", (List) null, 4, (DefaultConstructorMarker) null);
        public static final Message INSTANCE = new Message();

        private Message() {
        }

        public final ContentType getAny() {
            return Any;
        }

        public final ContentType getHttp() {
            return Http;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0011\u0010\u0011\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0011\u0010\u0013\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006¨\u0006\u0015"}, d2 = {"Lio/ktor/http/ContentType$MultiPart;", "", "()V", "Alternative", "Lio/ktor/http/ContentType;", "getAlternative", "()Lio/ktor/http/ContentType;", "Any", "getAny", "ByteRanges", "getByteRanges", "Encrypted", "getEncrypted", "FormData", "getFormData", "Mixed", "getMixed", "Related", "getRelated", "Signed", "getSigned", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ContentTypes.kt */
    public static final class MultiPart {
        private static final ContentType Alternative = new ContentType("multipart", "alternative", (List) null, 4, (DefaultConstructorMarker) null);
        private static final ContentType Any = new ContentType("multipart", "*", (List) null, 4, (DefaultConstructorMarker) null);
        private static final ContentType ByteRanges = new ContentType("multipart", "byteranges", (List) null, 4, (DefaultConstructorMarker) null);
        private static final ContentType Encrypted = new ContentType("multipart", "encrypted", (List) null, 4, (DefaultConstructorMarker) null);
        private static final ContentType FormData = new ContentType("multipart", "form-data", (List) null, 4, (DefaultConstructorMarker) null);
        public static final MultiPart INSTANCE = new MultiPart();
        private static final ContentType Mixed = new ContentType("multipart", "mixed", (List) null, 4, (DefaultConstructorMarker) null);
        private static final ContentType Related = new ContentType("multipart", "related", (List) null, 4, (DefaultConstructorMarker) null);
        private static final ContentType Signed = new ContentType("multipart", "signed", (List) null, 4, (DefaultConstructorMarker) null);

        private MultiPart() {
        }

        public final ContentType getAny() {
            return Any;
        }

        public final ContentType getMixed() {
            return Mixed;
        }

        public final ContentType getAlternative() {
            return Alternative;
        }

        public final ContentType getRelated() {
            return Related;
        }

        public final ContentType getFormData() {
            return FormData;
        }

        public final ContentType getSigned() {
            return Signed;
        }

        public final ContentType getEncrypted() {
            return Encrypted;
        }

        public final ContentType getByteRanges() {
            return ByteRanges;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0011\u0010\u0011\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0011\u0010\u0013\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0011\u0010\u0015\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006¨\u0006\u0017"}, d2 = {"Lio/ktor/http/ContentType$Text;", "", "()V", "Any", "Lio/ktor/http/ContentType;", "getAny", "()Lio/ktor/http/ContentType;", "CSS", "getCSS", "CSV", "getCSV", "EventStream", "getEventStream", "Html", "getHtml", "JavaScript", "getJavaScript", "Plain", "getPlain", "VCard", "getVCard", "Xml", "getXml", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ContentTypes.kt */
    public static final class Text {
        private static final ContentType Any = new ContentType("text", "*", (List) null, 4, (DefaultConstructorMarker) null);
        private static final ContentType CSS = new ContentType("text", "css", (List) null, 4, (DefaultConstructorMarker) null);
        private static final ContentType CSV = new ContentType("text", "csv", (List) null, 4, (DefaultConstructorMarker) null);
        private static final ContentType EventStream = new ContentType("text", "event-stream", (List) null, 4, (DefaultConstructorMarker) null);
        private static final ContentType Html = new ContentType("text", "html", (List) null, 4, (DefaultConstructorMarker) null);
        public static final Text INSTANCE = new Text();
        private static final ContentType JavaScript = new ContentType("text", "javascript", (List) null, 4, (DefaultConstructorMarker) null);
        private static final ContentType Plain = new ContentType("text", "plain", (List) null, 4, (DefaultConstructorMarker) null);
        private static final ContentType VCard = new ContentType("text", "vcard", (List) null, 4, (DefaultConstructorMarker) null);
        private static final ContentType Xml = new ContentType("text", "xml", (List) null, 4, (DefaultConstructorMarker) null);

        private Text() {
        }

        public final ContentType getAny() {
            return Any;
        }

        public final ContentType getPlain() {
            return Plain;
        }

        public final ContentType getCSS() {
            return CSS;
        }

        public final ContentType getCSV() {
            return CSV;
        }

        public final ContentType getHtml() {
            return Html;
        }

        public final ContentType getJavaScript() {
            return JavaScript;
        }

        public final ContentType getVCard() {
            return VCard;
        }

        public final ContentType getXml() {
            return Xml;
        }

        public final ContentType getEventStream() {
            return EventStream;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, d2 = {"Lio/ktor/http/ContentType$Video;", "", "()V", "Any", "Lio/ktor/http/ContentType;", "getAny", "()Lio/ktor/http/ContentType;", "MP4", "getMP4", "MPEG", "getMPEG", "OGG", "getOGG", "QuickTime", "getQuickTime", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ContentTypes.kt */
    public static final class Video {
        private static final ContentType Any = new ContentType("video", "*", (List) null, 4, (DefaultConstructorMarker) null);
        public static final Video INSTANCE = new Video();
        private static final ContentType MP4 = new ContentType("video", "mp4", (List) null, 4, (DefaultConstructorMarker) null);
        private static final ContentType MPEG = new ContentType("video", "mpeg", (List) null, 4, (DefaultConstructorMarker) null);
        private static final ContentType OGG = new ContentType("video", "ogg", (List) null, 4, (DefaultConstructorMarker) null);
        private static final ContentType QuickTime = new ContentType("video", "quicktime", (List) null, 4, (DefaultConstructorMarker) null);

        private Video() {
        }

        public final ContentType getAny() {
            return Any;
        }

        public final ContentType getMPEG() {
            return MPEG;
        }

        public final ContentType getMP4() {
            return MP4;
        }

        public final ContentType getOGG() {
            return OGG;
        }

        public final ContentType getQuickTime() {
            return QuickTime;
        }
    }
}
