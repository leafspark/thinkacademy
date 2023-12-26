package io.ktor.http;

import io.ktor.http.ContentType;
import io.ktor.util.NioPathKt;
import java.io.File;
import java.nio.file.Path;
import kotlin.Metadata;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"defaultForFile", "Lio/ktor/http/ContentType;", "Lio/ktor/http/ContentType$Companion;", "file", "Ljava/io/File;", "Ljava/nio/file/Path;", "ktor-http"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: FileContentTypeJvm.kt */
public final class FileContentTypeJvmKt {
    public static final ContentType defaultForFile(ContentType.Companion companion, File file) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(file, "file");
        return FileContentTypeKt.selectDefault(FileContentTypeKt.fromFileExtension(ContentType.Companion, FilesKt.getExtension(file)));
    }

    public static final ContentType defaultForFile(ContentType.Companion companion, Path path) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(path, "file");
        return FileContentTypeKt.selectDefault(FileContentTypeKt.fromFileExtension(ContentType.Companion, NioPathKt.getExtension(path)));
    }
}
