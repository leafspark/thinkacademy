package okio.internal;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSink;
import okio.FileMetadata;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
import okio.Source;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0001\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0001\u001a\u0014\u0010\b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0001\u001a\u0014\u0010\n\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\f\u001a\u00020\u0004H\u0001\u001a\u0014\u0010\r\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\f\u001a\u00020\u0004H\u0001¨\u0006\u000f"}, d2 = {"commonCopy", "", "Lokio/FileSystem;", "source", "Lokio/Path;", "target", "commonCreateDirectories", "dir", "commonDeleteRecursively", "fileOrDirectory", "commonExists", "", "path", "commonMetadata", "Lokio/FileMetadata;", "okio"}, k = 2, mv = {1, 4, 1})
/* compiled from: -FileSystem.kt */
public final class _FileSystemKt {
    public static final FileMetadata commonMetadata(FileSystem fileSystem, Path path) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "$this$commonMetadata");
        Intrinsics.checkNotNullParameter(path, "path");
        FileMetadata metadataOrNull = fileSystem.metadataOrNull(path);
        if (metadataOrNull != null) {
            return metadataOrNull;
        }
        throw new FileNotFoundException("no such file: " + path);
    }

    public static final boolean commonExists(FileSystem fileSystem, Path path) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "$this$commonExists");
        Intrinsics.checkNotNullParameter(path, "path");
        return fileSystem.metadataOrNull(path) != null;
    }

    public static final void commonCreateDirectories(FileSystem fileSystem, Path path) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "$this$commonCreateDirectories");
        Intrinsics.checkNotNullParameter(path, "dir");
        ArrayDeque arrayDeque = new ArrayDeque();
        while (path != null && !fileSystem.exists(path)) {
            arrayDeque.addFirst(path);
            path = path.parent();
        }
        Iterator it = arrayDeque.iterator();
        while (it.hasNext()) {
            fileSystem.createDirectory((Path) it.next());
        }
    }

    public static final void commonCopy(FileSystem fileSystem, Path path, Path path2) throws IOException {
        Throwable th;
        Long l;
        Intrinsics.checkNotNullParameter(fileSystem, "$this$commonCopy");
        Intrinsics.checkNotNullParameter(path, "source");
        Intrinsics.checkNotNullParameter(path2, "target");
        Closeable source = fileSystem.source(path);
        Long l2 = null;
        Throwable th2 = null;
        try {
            Source source2 = (Source) source;
            Closeable buffer = Okio.buffer(fileSystem.sink(path2));
            th = null;
            try {
                l = Long.valueOf(((BufferedSink) buffer).writeAll(source2));
            } catch (Throwable th3) {
                th = th3;
                l = null;
            }
            if (buffer != null) {
                buffer.close();
            }
        } catch (Throwable th4) {
            th2 = th4;
        }
        if (th == null) {
            Intrinsics.checkNotNull(l);
            l2 = Long.valueOf(l.longValue());
            if (source != null) {
                try {
                    source.close();
                } catch (Throwable th5) {
                    if (th2 == null) {
                        th2 = th5;
                    } else {
                        ExceptionsKt.addSuppressed(th2, th5);
                    }
                }
            }
            if (th2 == null) {
                Intrinsics.checkNotNull(l2);
                return;
            }
            throw th2;
        }
        throw th;
    }

    public static final void commonDeleteRecursively(FileSystem fileSystem, Path path) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "$this$commonDeleteRecursively");
        Intrinsics.checkNotNullParameter(path, "fileOrDirectory");
        Collection arrayDeque = new ArrayDeque();
        Collection collection = arrayDeque;
        collection.add(path);
        while (!collection.isEmpty()) {
            Path path2 = (Path) arrayDeque.removeLast();
            List<Path> list = fileSystem.metadata(path2).isDirectory() ? fileSystem.list(path2) : CollectionsKt.emptyList();
            if (!list.isEmpty()) {
                collection.add(path2);
                CollectionsKt.addAll(collection, list);
            } else {
                fileSystem.delete(path2);
            }
        }
    }
}
