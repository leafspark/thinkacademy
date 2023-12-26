package okio;

import java.io.File;
import java.nio.file.Paths;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.internal._PathKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001#B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0000H\u0002J\u0016\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\rH\u0002¢\u0006\u0002\b\u001aJ\u0016\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0000H\u0002¢\u0006\u0002\b\u001aJ\u0013\u0010\u001b\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u0016H\u0016J\u0006\u0010\u001e\u001a\u00020\u001fJ\b\u0010 \u001a\u00020!H\u0007J\b\u0010\"\u001a\u00020\rH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u0011\u0010\n\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\n\u0010\tR\u0011\u0010\u000b\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0006R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u00008G¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u00138G¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014¨\u0006$"}, d2 = {"Lokio/Path;", "", "bytes", "Lokio/ByteString;", "(Lokio/ByteString;)V", "getBytes$okio", "()Lokio/ByteString;", "isAbsolute", "", "()Z", "isRelative", "isRoot", "name", "", "()Ljava/lang/String;", "nameBytes", "parent", "()Lokio/Path;", "volumeLetter", "", "()Ljava/lang/Character;", "compareTo", "", "other", "div", "child", "resolve", "equals", "", "hashCode", "toFile", "Ljava/io/File;", "toNioPath", "Ljava/nio/file/Path;", "toString", "Companion", "okio"}, k = 1, mv = {1, 4, 1})
/* compiled from: Path.kt */
public final class Path implements Comparable<Path> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String DIRECTORY_SEPARATOR;
    private final ByteString bytes;

    @JvmStatic
    public static final Path get(File file) {
        return Companion.get(file);
    }

    @JvmStatic
    public static final Path get(String str) {
        return Companion.get(str);
    }

    @JvmStatic
    public static final Path get(java.nio.file.Path path) {
        return Companion.get(path);
    }

    public Path(ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "bytes");
        this.bytes = byteString;
    }

    public final ByteString getBytes$okio() {
        return this.bytes;
    }

    public final File toFile() {
        return new File(toString());
    }

    public final java.nio.file.Path toNioPath() {
        java.nio.file.Path path = Paths.get(toString(), new String[0]);
        Intrinsics.checkNotNullExpressionValue(path, "Paths.get(toString())");
        return path;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0005\u001a\u00020\u0006*\u00020\u0007H\u0007¢\u0006\u0002\b\bJ\u0011\u0010\u0005\u001a\u00020\u0006*\u00020\tH\u0007¢\u0006\u0002\b\bJ\u0011\u0010\n\u001a\u00020\u0006*\u00020\u0004H\u0007¢\u0006\u0002\b\bR\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lokio/Path$Companion;", "", "()V", "DIRECTORY_SEPARATOR", "", "toOkioPath", "Lokio/Path;", "Ljava/io/File;", "get", "Ljava/nio/file/Path;", "toPath", "okio"}, k = 1, mv = {1, 4, 1})
    /* compiled from: Path.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final Path get(String str) {
            Intrinsics.checkNotNullParameter(str, "$this$toPath");
            return _PathKt.commonToPath(str);
        }

        @JvmStatic
        public final Path get(File file) {
            Intrinsics.checkNotNullParameter(file, "$this$toOkioPath");
            String file2 = file.toString();
            Intrinsics.checkNotNullExpressionValue(file2, "toString()");
            return get(file2);
        }

        @JvmStatic
        public final Path get(java.nio.file.Path path) {
            Intrinsics.checkNotNullParameter(path, "$this$toOkioPath");
            return get(path.toString());
        }
    }

    static {
        String str = File.separator;
        Intrinsics.checkNotNullExpressionValue(str, "File.separator");
        DIRECTORY_SEPARATOR = str;
    }

    public final boolean isAbsolute() {
        return getBytes$okio().startsWith(_PathKt.SLASH) || getBytes$okio().startsWith(_PathKt.BACKSLASH) || (volumeLetter() != null && getBytes$okio().size() > 2 && getBytes$okio().getByte(2) == ((byte) 92));
    }

    public final boolean isRelative() {
        return !isAbsolute();
    }

    public final Character volumeLetter() {
        if (ByteString.indexOf$default(getBytes$okio(), _PathKt.SLASH, 0, 2, (Object) null) != -1 || getBytes$okio().size() < 2 || getBytes$okio().getByte(1) != ((byte) 58)) {
            return null;
        }
        char c = (char) getBytes$okio().getByte(0);
        if (('a' > c || 'z' < c) && ('A' > c || 'Z' < c)) {
            return null;
        }
        return Character.valueOf(c);
    }

    public final ByteString nameBytes() {
        int access$getIndexOfLastSlash$p = _PathKt.getIndexOfLastSlash(this);
        if (access$getIndexOfLastSlash$p != -1) {
            return ByteString.substring$default(getBytes$okio(), access$getIndexOfLastSlash$p + 1, 0, 2, (Object) null);
        }
        if (volumeLetter() == null || getBytes$okio().size() != 2) {
            return getBytes$okio();
        }
        return ByteString.EMPTY;
    }

    public final String name() {
        return nameBytes().utf8();
    }

    public final Path parent() {
        Path path;
        if (Intrinsics.areEqual(getBytes$okio(), _PathKt.DOT) || Intrinsics.areEqual(getBytes$okio(), _PathKt.SLASH) || Intrinsics.areEqual(getBytes$okio(), _PathKt.BACKSLASH) || _PathKt.lastSegmentIsDotDot(this)) {
            return null;
        }
        int access$getIndexOfLastSlash$p = _PathKt.getIndexOfLastSlash(this);
        if (access$getIndexOfLastSlash$p != 2 || volumeLetter() == null) {
            if (access$getIndexOfLastSlash$p == 1 && getBytes$okio().startsWith(_PathKt.BACKSLASH)) {
                return null;
            }
            if (access$getIndexOfLastSlash$p != -1 || volumeLetter() == null) {
                if (access$getIndexOfLastSlash$p == -1) {
                    return new Path(_PathKt.DOT);
                }
                if (access$getIndexOfLastSlash$p != 0) {
                    return new Path(ByteString.substring$default(getBytes$okio(), 0, access$getIndexOfLastSlash$p, 1, (Object) null));
                }
                path = new Path(ByteString.substring$default(getBytes$okio(), 0, 1, 1, (Object) null));
            } else if (getBytes$okio().size() == 2) {
                return null;
            } else {
                path = new Path(ByteString.substring$default(getBytes$okio(), 0, 2, 1, (Object) null));
            }
        } else if (getBytes$okio().size() == 3) {
            return null;
        } else {
            path = new Path(ByteString.substring$default(getBytes$okio(), 0, 3, 1, (Object) null));
        }
        return path;
    }

    public final boolean isRoot() {
        return parent() == null && isAbsolute();
    }

    public final Path resolve(String str) {
        Intrinsics.checkNotNullParameter(str, "child");
        return resolve(_PathKt.toPath(new Buffer().writeUtf8(str)));
    }

    public final Path resolve(Path path) {
        ByteString byteString;
        Intrinsics.checkNotNullParameter(path, "child");
        if (path.isAbsolute() || path.volumeLetter() != null) {
            return path;
        }
        if (ByteString.indexOf$default(getBytes$okio(), _PathKt.SLASH, 0, 2, (Object) null) != -1) {
            byteString = _PathKt.SLASH;
        } else if (ByteString.indexOf$default(getBytes$okio(), _PathKt.BACKSLASH, 0, 2, (Object) null) != -1) {
            byteString = _PathKt.BACKSLASH;
        } else if (ByteString.indexOf$default(path.getBytes$okio(), _PathKt.SLASH, 0, 2, (Object) null) != -1) {
            byteString = _PathKt.SLASH;
        } else if (ByteString.indexOf$default(path.getBytes$okio(), _PathKt.BACKSLASH, 0, 2, (Object) null) != -1) {
            byteString = _PathKt.BACKSLASH;
        } else {
            byteString = _PathKt.toSlash(DIRECTORY_SEPARATOR);
        }
        Buffer buffer = new Buffer();
        buffer.write(getBytes$okio());
        if (buffer.size() > 0) {
            buffer.write(byteString);
        }
        buffer.write(path.getBytes$okio());
        return _PathKt.toPath(buffer);
    }

    public int compareTo(Path path) {
        Intrinsics.checkNotNullParameter(path, "other");
        return getBytes$okio().compareTo(path.getBytes$okio());
    }

    public boolean equals(Object obj) {
        return (obj instanceof Path) && Intrinsics.areEqual(((Path) obj).getBytes$okio(), getBytes$okio());
    }

    public int hashCode() {
        return getBytes$okio().hashCode();
    }

    public String toString() {
        return getBytes$okio().utf8();
    }
}
