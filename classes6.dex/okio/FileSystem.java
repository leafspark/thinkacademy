package okio;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.internal._FileSystemKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 )2\u00020\u0001:\u0001)B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H&J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H&J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0006J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0006H&J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0006H&J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0006H\u0016J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u0006J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u00172\u0006\u0010\u000f\u001a\u00020\u0006H&J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\u0006J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\f\u001a\u00020\u0006H&J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u0006H&J8\u0010\u001d\u001a\u0002H\u001e\"\u0004\b\u0000\u0010\u001e2\u0006\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u0002H\u001e0 ¢\u0006\u0002\b\"H\bø\u0001\u0000¢\u0006\u0002\u0010#J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\t\u001a\u00020%2\u0006\u0010\u0005\u001a\u00020\u0006H&J8\u0010&\u001a\u0002H\u001e\"\u0004\b\u0000\u0010\u001e2\u0006\u0010\u0005\u001a\u00020\u00062\u0017\u0010'\u001a\u0013\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u0002H\u001e0 ¢\u0006\u0002\b\"H\bø\u0001\u0000¢\u0006\u0002\u0010#\u0002\u0007\n\u0005\b20\u0001¨\u0006*"}, d2 = {"Lokio/FileSystem;", "", "()V", "appendingSink", "Lokio/Sink;", "file", "Lokio/Path;", "atomicMove", "", "source", "target", "canonicalize", "path", "copy", "createDirectories", "dir", "createDirectory", "delete", "deleteRecursively", "fileOrDirectory", "exists", "", "list", "", "metadata", "Lokio/FileMetadata;", "metadataOrNull", "open", "Lokio/FileHandle;", "read", "T", "readerAction", "Lkotlin/Function1;", "Lokio/BufferedSource;", "Lkotlin/ExtensionFunctionType;", "(Lokio/Path;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "sink", "Lokio/Source;", "write", "writerAction", "Lokio/BufferedSink;", "Companion", "okio"}, k = 1, mv = {1, 4, 1})
/* compiled from: FileSystem.kt */
public abstract class FileSystem {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final FileSystem SYSTEM = _JvmPlatformKt.getPLATFORM_FILE_SYSTEM();
    public static final Path SYSTEM_TEMPORARY_DIRECTORY = _JvmPlatformKt.getPLATFORM_TEMPORARY_DIRECTORY();

    public abstract Sink appendingSink(Path path) throws IOException;

    public abstract void atomicMove(Path path, Path path2) throws IOException;

    public abstract Path canonicalize(Path path) throws IOException;

    public abstract void createDirectory(Path path) throws IOException;

    public abstract void delete(Path path) throws IOException;

    public abstract List<Path> list(Path path) throws IOException;

    public abstract FileMetadata metadataOrNull(Path path) throws IOException;

    public abstract FileHandle open(Path path) throws IOException;

    public abstract Sink sink(Path path) throws IOException;

    public abstract Source source(Path path) throws IOException;

    public final FileMetadata metadata(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "path");
        return _FileSystemKt.commonMetadata(this, path);
    }

    public final boolean exists(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "path");
        return _FileSystemKt.commonExists(this, path);
    }

    public final <T> T read(Path path, Function1<? super BufferedSource, ? extends T> function1) throws IOException {
        Intrinsics.checkNotNullParameter(path, "file");
        Intrinsics.checkNotNullParameter(function1, "readerAction");
        Closeable buffer = Okio.buffer(source(path));
        T t = null;
        Throwable th = null;
        try {
            t = function1.invoke((BufferedSource) buffer);
        } catch (Throwable th2) {
            th = th2;
        }
        if (buffer != null) {
            try {
                buffer.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                } else {
                    ExceptionsKt.addSuppressed(th, th3);
                }
            }
        }
        if (th == null) {
            Intrinsics.checkNotNull(t);
            return t;
        }
        throw th;
    }

    public final <T> T write(Path path, Function1<? super BufferedSink, ? extends T> function1) throws IOException {
        Intrinsics.checkNotNullParameter(path, "file");
        Intrinsics.checkNotNullParameter(function1, "writerAction");
        Closeable buffer = Okio.buffer(sink(path));
        T t = null;
        Throwable th = null;
        try {
            t = function1.invoke((BufferedSink) buffer);
        } catch (Throwable th2) {
            th = th2;
        }
        if (buffer != null) {
            try {
                buffer.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                } else {
                    ExceptionsKt.addSuppressed(th, th3);
                }
            }
        }
        if (th == null) {
            Intrinsics.checkNotNull(t);
            return t;
        }
        throw th;
    }

    public final void createDirectories(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "dir");
        _FileSystemKt.commonCreateDirectories(this, path);
    }

    public void copy(Path path, Path path2) throws IOException {
        Intrinsics.checkNotNullParameter(path, "source");
        Intrinsics.checkNotNullParameter(path2, "target");
        _FileSystemKt.commonCopy(this, path, path2);
    }

    public void deleteRecursively(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "fileOrDirectory");
        _FileSystemKt.commonDeleteRecursively(this, path);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lokio/FileSystem$Companion;", "", "()V", "SYSTEM", "Lokio/FileSystem;", "SYSTEM_TEMPORARY_DIRECTORY", "Lokio/Path;", "okio"}, k = 1, mv = {1, 4, 1})
    /* compiled from: FileSystem.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
