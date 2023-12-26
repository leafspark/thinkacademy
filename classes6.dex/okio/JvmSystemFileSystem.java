package okio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okio.Path;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0011\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0006H\u0016J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00112\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\f\u001a\u00020\u0006H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016¨\u0006\u001a"}, d2 = {"Lokio/JvmSystemFileSystem;", "Lokio/FileSystem;", "()V", "appendingSink", "Lokio/Sink;", "file", "Lokio/Path;", "atomicMove", "", "source", "target", "canonicalize", "path", "createDirectory", "dir", "delete", "list", "", "metadataOrNull", "Lokio/FileMetadata;", "open", "Lokio/FileHandle;", "sink", "Lokio/Source;", "toString", "", "okio"}, k = 1, mv = {1, 4, 1})
/* compiled from: JvmSystemFileSystem.kt */
public class JvmSystemFileSystem extends FileSystem {
    public String toString() {
        return "JvmSystemFileSystem";
    }

    public Path canonicalize(Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        File canonicalFile = path.toFile().getCanonicalFile();
        if (canonicalFile.exists()) {
            Path.Companion companion = Path.Companion;
            Intrinsics.checkNotNullExpressionValue(canonicalFile, "canonicalFile");
            return companion.get(canonicalFile);
        }
        throw new FileNotFoundException("no such file");
    }

    public FileMetadata metadataOrNull(Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        File file = path.toFile();
        boolean isFile = file.isFile();
        boolean isDirectory = file.isDirectory();
        long lastModified = file.lastModified();
        long length = file.length();
        if (!isFile && !isDirectory && lastModified == 0 && length == 0 && !file.exists()) {
            return null;
        }
        return new FileMetadata(isFile, isDirectory, Long.valueOf(length), (Long) null, Long.valueOf(lastModified), (Long) null);
    }

    public List<Path> list(Path path) {
        Intrinsics.checkNotNullParameter(path, "dir");
        File file = path.toFile();
        String[] list = file.list();
        if (list != null) {
            Collection arrayList = new ArrayList();
            for (String str : list) {
                Intrinsics.checkNotNullExpressionValue(str, "it");
                arrayList.add(path.resolve(str));
            }
            List<Path> list2 = (List) arrayList;
            CollectionsKt.sort(list2);
            return list2;
        } else if (!file.exists()) {
            throw new FileNotFoundException("no such file: " + path);
        } else {
            throw new IOException("failed to list " + path);
        }
    }

    public FileHandle open(Path path) {
        Intrinsics.checkNotNullParameter(path, "file");
        throw new UnsupportedOperationException("not implemented yet!");
    }

    public Source source(Path path) {
        Intrinsics.checkNotNullParameter(path, "file");
        return Okio.source(path.toFile());
    }

    public Sink sink(Path path) {
        Intrinsics.checkNotNullParameter(path, "file");
        return Okio__JvmOkioKt.sink$default(path.toFile(), false, 1, (Object) null);
    }

    public Sink appendingSink(Path path) {
        Intrinsics.checkNotNullParameter(path, "file");
        return Okio.sink(path.toFile(), true);
    }

    public void createDirectory(Path path) {
        Intrinsics.checkNotNullParameter(path, "dir");
        if (!path.toFile().mkdir()) {
            throw new IOException("failed to create directory: " + path);
        }
    }

    public void atomicMove(Path path, Path path2) {
        Intrinsics.checkNotNullParameter(path, "source");
        Intrinsics.checkNotNullParameter(path2, "target");
        if (!path.toFile().renameTo(path2.toFile())) {
            throw new IOException("failed to move " + path + " to " + path2);
        }
    }

    public void delete(Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        File file = path.toFile();
        if (file.delete()) {
            return;
        }
        if (!file.exists()) {
            throw new FileNotFoundException("no such file: " + path);
        }
        throw new IOException("failed to delete " + path);
    }
}
