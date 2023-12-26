package io.ktor.client.content;

import io.ktor.http.ContentType;
import io.ktor.http.FileContentTypeJvmKt;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.cio.FileChannelsKt;
import io.ktor.utils.io.ByteReadChannel;
import java.io.File;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongRange;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lio/ktor/client/content/LocalFileContent;", "Lio/ktor/http/content/OutgoingContent$ReadChannelContent;", "file", "Ljava/io/File;", "contentType", "Lio/ktor/http/ContentType;", "(Ljava/io/File;Lio/ktor/http/ContentType;)V", "contentLength", "", "getContentLength", "()Ljava/lang/Long;", "getContentType", "()Lio/ktor/http/ContentType;", "getFile", "()Ljava/io/File;", "readFrom", "Lio/ktor/utils/io/ByteReadChannel;", "range", "Lkotlin/ranges/LongRange;", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LocalFileContent.kt */
public final class LocalFileContent extends OutgoingContent.ReadChannelContent {
    private final ContentType contentType;
    private final File file;

    public final File getFile() {
        return this.file;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LocalFileContent(File file2, ContentType contentType2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(file2, (i & 2) != 0 ? FileContentTypeJvmKt.defaultForFile(ContentType.Companion, file2) : contentType2);
    }

    public ContentType getContentType() {
        return this.contentType;
    }

    public LocalFileContent(File file2, ContentType contentType2) {
        Intrinsics.checkNotNullParameter(file2, "file");
        Intrinsics.checkNotNullParameter(contentType2, "contentType");
        this.file = file2;
        this.contentType = contentType2;
    }

    public Long getContentLength() {
        return Long.valueOf(this.file.length());
    }

    public ByteReadChannel readFrom() {
        return FileChannelsKt.readChannel$default(this.file, 0, 0, (CoroutineContext) null, 7, (Object) null);
    }

    public ByteReadChannel readFrom(LongRange longRange) {
        Intrinsics.checkNotNullParameter(longRange, "range");
        return FileChannelsKt.readChannel$default(this.file, longRange.getStart().longValue(), longRange.getEndInclusive().longValue(), (CoroutineContext) null, 4, (Object) null);
    }
}
