package io.ktor.client.content;

import io.ktor.http.ContentType;
import io.ktor.http.FileContentTypeKt;
import io.ktor.util.PathKt;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"LocalFileContent", "Lio/ktor/client/content/LocalFileContent;", "baseDir", "Ljava/io/File;", "relativePath", "", "contentType", "Lio/ktor/http/ContentType;", "ktor-client-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: LocalFileContent.kt */
public final class LocalFileContentKt {
    public static /* synthetic */ LocalFileContent LocalFileContent$default(File file, String str, ContentType contentType, int i, Object obj) {
        if ((i & 4) != 0) {
            contentType = FileContentTypeKt.defaultForFilePath(ContentType.Companion, str);
        }
        return LocalFileContent(file, str, contentType);
    }

    public static final LocalFileContent LocalFileContent(File file, String str, ContentType contentType) {
        Intrinsics.checkNotNullParameter(file, "baseDir");
        Intrinsics.checkNotNullParameter(str, "relativePath");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        return new LocalFileContent(PathKt.combineSafe(file, str), contentType);
    }
}
