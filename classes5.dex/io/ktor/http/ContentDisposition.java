package io.ktor.http;

import io.ktor.http.HeaderValueWithParameters;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u00172\u00020\u0001:\u0002\u0017\u0018B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0016\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003J\u0014\u0010\u0015\u001a\u00020\u00002\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005R\u0011\u0010\u0002\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t¨\u0006\u0019"}, d2 = {"Lio/ktor/http/ContentDisposition;", "Lio/ktor/http/HeaderValueWithParameters;", "disposition", "", "parameters", "", "Lio/ktor/http/HeaderValueParam;", "(Ljava/lang/String;Ljava/util/List;)V", "getDisposition", "()Ljava/lang/String;", "name", "getName", "equals", "", "other", "", "hashCode", "", "withParameter", "key", "value", "withParameters", "newParameters", "Companion", "Parameters", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ContentDisposition.kt */
public final class ContentDisposition extends HeaderValueWithParameters {
    /* access modifiers changed from: private */
    public static final ContentDisposition Attachment = new ContentDisposition("attachment", (List) null, 2, (DefaultConstructorMarker) null);
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final ContentDisposition File = new ContentDisposition("file", (List) null, 2, (DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final ContentDisposition Inline = new ContentDisposition("inline", (List) null, 2, (DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final ContentDisposition Mixed = new ContentDisposition("mixed", (List) null, 2, (DefaultConstructorMarker) null);

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ContentDisposition(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContentDisposition(String str, List<HeaderValueParam> list) {
        super(str, list);
        Intrinsics.checkNotNullParameter(str, "disposition");
        Intrinsics.checkNotNullParameter(list, "parameters");
    }

    public final String getDisposition() {
        return getContent();
    }

    public final String getName() {
        return parameter(Parameters.Name);
    }

    public final ContentDisposition withParameter(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "value");
        return new ContentDisposition(getDisposition(), CollectionsKt.plus(getParameters(), new HeaderValueParam(str, str2)));
    }

    public final ContentDisposition withParameters(List<HeaderValueParam> list) {
        Intrinsics.checkNotNullParameter(list, "newParameters");
        return new ContentDisposition(getDisposition(), CollectionsKt.plus(getParameters(), list));
    }

    public boolean equals(Object obj) {
        if (obj instanceof ContentDisposition) {
            ContentDisposition contentDisposition = (ContentDisposition) obj;
            return Intrinsics.areEqual(getDisposition(), contentDisposition.getDisposition()) && Intrinsics.areEqual(getParameters(), contentDisposition.getParameters());
        }
    }

    public int hashCode() {
        return (getDisposition().hashCode() * 31) + getParameters().hashCode();
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006¨\u0006\u0010"}, d2 = {"Lio/ktor/http/ContentDisposition$Companion;", "", "()V", "Attachment", "Lio/ktor/http/ContentDisposition;", "getAttachment", "()Lio/ktor/http/ContentDisposition;", "File", "getFile", "Inline", "getInline", "Mixed", "getMixed", "parse", "value", "", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ContentDisposition.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ContentDisposition getFile() {
            return ContentDisposition.File;
        }

        public final ContentDisposition getMixed() {
            return ContentDisposition.Mixed;
        }

        public final ContentDisposition getAttachment() {
            return ContentDisposition.Attachment;
        }

        public final ContentDisposition getInline() {
            return ContentDisposition.Inline;
        }

        public final ContentDisposition parse(String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            HeaderValueWithParameters.Companion companion = HeaderValueWithParameters.Companion;
            HeaderValue headerValue = (HeaderValue) CollectionsKt.last(HttpHeaderValueParserKt.parseHeaderValue(str));
            return new ContentDisposition(headerValue.getValue(), headerValue.getParams());
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lio/ktor/http/ContentDisposition$Parameters;", "", "()V", "CreationDate", "", "FileName", "FileNameAsterisk", "Handling", "ModificationDate", "Name", "ReadDate", "Size", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ContentDisposition.kt */
    public static final class Parameters {
        public static final String CreationDate = "creation-date";
        public static final String FileName = "filename";
        public static final String FileNameAsterisk = "filename*";
        public static final String Handling = "handling";
        public static final Parameters INSTANCE = new Parameters();
        public static final String ModificationDate = "modification-date";
        public static final String Name = "name";
        public static final String ReadDate = "read-date";
        public static final String Size = "size";

        private Parameters() {
        }
    }
}
