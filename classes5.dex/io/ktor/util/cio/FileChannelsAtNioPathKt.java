package io.ktor.util.cio;

import io.ktor.utils.io.ByteReadChannel;
import java.io.File;
import java.nio.file.Path;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0006"}, d2 = {"readChannel", "Lio/ktor/utils/io/ByteReadChannel;", "Ljava/nio/file/Path;", "start", "", "endInclusive", "ktor-utils"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: FileChannelsAtNioPath.kt */
public final class FileChannelsAtNioPathKt {
    public static final ByteReadChannel readChannel(Path path, long j, long j2) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        File file = path.toFile();
        Intrinsics.checkNotNullExpressionValue(file, "toFile()");
        return FileChannelsKt.readChannel$default(file, j, j2, (CoroutineContext) null, 4, (Object) null);
    }

    public static final ByteReadChannel readChannel(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        File file = path.toFile();
        Intrinsics.checkNotNullExpressionValue(file, "toFile()");
        return FileChannelsKt.readChannel$default(file, 0, 0, (CoroutineContext) null, 7, (Object) null);
    }
}
