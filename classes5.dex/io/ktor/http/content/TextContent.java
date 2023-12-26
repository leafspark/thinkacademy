package io.ktor.http.content;

import io.ktor.http.ContentType;
import io.ktor.http.ContentTypesKt;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.charsets.CharsetJVMKt;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\n\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u0015\u001a\u00020\u0003H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lio/ktor/http/content/TextContent;", "Lio/ktor/http/content/OutgoingContent$ByteArrayContent;", "text", "", "contentType", "Lio/ktor/http/ContentType;", "status", "Lio/ktor/http/HttpStatusCode;", "(Ljava/lang/String;Lio/ktor/http/ContentType;Lio/ktor/http/HttpStatusCode;)V", "bytes", "", "contentLength", "", "getContentLength", "()Ljava/lang/Long;", "getContentType", "()Lio/ktor/http/ContentType;", "getStatus", "()Lio/ktor/http/HttpStatusCode;", "getText", "()Ljava/lang/String;", "toString", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextContent.kt */
public final class TextContent extends OutgoingContent.ByteArrayContent {
    private final byte[] bytes;
    private final ContentType contentType;
    private final HttpStatusCode status;
    private final String text;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TextContent(String str, ContentType contentType2, HttpStatusCode httpStatusCode, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, contentType2, (i & 4) != 0 ? null : httpStatusCode);
    }

    public final String getText() {
        return this.text;
    }

    public ContentType getContentType() {
        return this.contentType;
    }

    public HttpStatusCode getStatus() {
        return this.status;
    }

    public TextContent(String str, ContentType contentType2, HttpStatusCode httpStatusCode) {
        byte[] bArr;
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(contentType2, "contentType");
        this.text = str;
        this.contentType = contentType2;
        this.status = httpStatusCode;
        Charset charset = ContentTypesKt.charset(getContentType());
        charset = charset == null ? Charsets.UTF_8 : charset;
        if (Intrinsics.areEqual(charset, Charsets.UTF_8)) {
            bArr = StringsKt.encodeToByteArray(str);
        } else {
            CharsetEncoder newEncoder = charset.newEncoder();
            Intrinsics.checkNotNullExpressionValue(newEncoder, "charset.newEncoder()");
            bArr = CharsetJVMKt.encodeToByteArray(newEncoder, str, 0, str.length());
        }
        this.bytes = bArr;
    }

    public Long getContentLength() {
        return Long.valueOf((long) this.bytes.length);
    }

    public byte[] bytes() {
        return this.bytes;
    }

    public String toString() {
        return "TextContent[" + getContentType() + "] \"" + StringsKt.take(this.text, 30) + Typography.quote;
    }
}
