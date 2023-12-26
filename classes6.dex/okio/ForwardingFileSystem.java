package okio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\bH\u0016J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u00132\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000e\u001a\u00020\bH\u0016J \u0010\u0016\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0018\u0010\u001a\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u001e2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\u001f\u001a\u00020\u0018H\u0016R\u0013\u0010\u0002\u001a\u00020\u00018\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0004¨\u0006 "}, d2 = {"Lokio/ForwardingFileSystem;", "Lokio/FileSystem;", "delegate", "(Lokio/FileSystem;)V", "()Lokio/FileSystem;", "appendingSink", "Lokio/Sink;", "file", "Lokio/Path;", "atomicMove", "", "source", "target", "canonicalize", "path", "createDirectory", "dir", "delete", "list", "", "metadataOrNull", "Lokio/FileMetadata;", "onPathParameter", "functionName", "", "parameterName", "onPathResult", "open", "Lokio/FileHandle;", "sink", "Lokio/Source;", "toString", "okio"}, k = 1, mv = {1, 4, 1})
/* compiled from: ForwardingFileSystem.kt */
public abstract class ForwardingFileSystem extends FileSystem {
    private final FileSystem delegate;

    public Path onPathParameter(Path path, String str, String str2) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(str, "functionName");
        Intrinsics.checkNotNullParameter(str2, "parameterName");
        return path;
    }

    public Path onPathResult(Path path, String str) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(str, "functionName");
        return path;
    }

    public final FileSystem delegate() {
        return this.delegate;
    }

    public ForwardingFileSystem(FileSystem fileSystem) {
        Intrinsics.checkNotNullParameter(fileSystem, "delegate");
        this.delegate = fileSystem;
    }

    public Path canonicalize(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "path");
        return onPathResult(this.delegate.canonicalize(onPathParameter(path, "canonicalize", "path")), "canonicalize");
    }

    public FileMetadata metadataOrNull(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "path");
        return this.delegate.metadataOrNull(onPathParameter(path, "metadataOrNull", "path"));
    }

    public List<Path> list(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "dir");
        Path onPathParameter = onPathParameter(path, "list", "dir");
        Collection arrayList = new ArrayList();
        for (Path onPathResult : this.delegate.list(onPathParameter)) {
            arrayList.add(onPathResult(onPathResult, "list"));
        }
        List<Path> list = (List) arrayList;
        CollectionsKt.sort(list);
        return list;
    }

    public FileHandle open(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "file");
        return this.delegate.open(onPathParameter(path, "open", "file"));
    }

    public Source source(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "file");
        return this.delegate.source(onPathParameter(path, "source", "file"));
    }

    public Sink sink(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "file");
        return this.delegate.sink(onPathParameter(path, "sink", "file"));
    }

    public Sink appendingSink(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "file");
        return this.delegate.appendingSink(onPathParameter(path, "appendingSink", "file"));
    }

    public void createDirectory(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "dir");
        this.delegate.createDirectory(onPathParameter(path, "createDirectory", "dir"));
    }

    public void atomicMove(Path path, Path path2) throws IOException {
        Intrinsics.checkNotNullParameter(path, "source");
        Intrinsics.checkNotNullParameter(path2, "target");
        this.delegate.atomicMove(onPathParameter(path, "atomicMove", "source"), onPathParameter(path2, "atomicMove", "target"));
    }

    public void delete(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "path");
        this.delegate.delete(onPathParameter(path, "delete", "path"));
    }

    public String toString() {
        return Reflection.getOrCreateKotlinClass(getClass()).getSimpleName() + '(' + this.delegate + ')';
    }
}
