package okio.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ByteString;
import okio.Path;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\u001a\u0015\u0010\r\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\b\u001a\u0017\u0010\u000f\u001a\u00020\u0010*\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0011H\b\u001a\r\u0010\u0012\u001a\u00020\u0007*\u00020\bH\b\u001a\r\u0010\u0013\u001a\u00020\u0010*\u00020\bH\b\u001a\r\u0010\u0014\u001a\u00020\u0010*\u00020\bH\b\u001a\r\u0010\u0015\u001a\u00020\u0010*\u00020\bH\b\u001a\r\u0010\u0016\u001a\u00020\u0017*\u00020\bH\b\u001a\r\u0010\u0018\u001a\u00020\u0001*\u00020\bH\b\u001a\u000f\u0010\u0019\u001a\u0004\u0018\u00010\b*\u00020\bH\b\u001a\u0015\u0010\u001a\u001a\u00020\b*\u00020\b2\u0006\u0010\u001b\u001a\u00020\u0017H\b\u001a\u0015\u0010\u001a\u001a\u00020\b*\u00020\b2\u0006\u0010\u001b\u001a\u00020\bH\b\u001a\f\u0010\u001c\u001a\u00020\b*\u00020\u0017H\u0007\u001a\r\u0010\u001d\u001a\u00020\u0017*\u00020\bH\b\u001a\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u001f*\u00020\bH\b¢\u0006\u0002\u0010 \u001a\f\u0010!\u001a\u00020\u0010*\u00020\bH\u0003\u001a\u0014\u0010\"\u001a\u00020\u0010*\u00020#2\u0006\u0010$\u001a\u00020\u0001H\u0002\u001a\f\u0010%\u001a\u00020\b*\u00020#H\u0001\u001a\f\u0010&\u001a\u00020\u0001*\u00020'H\u0002\u001a\f\u0010&\u001a\u00020\u0001*\u00020\u0017H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u001e\u0010\u0006\u001a\u00020\u0007*\u00020\b8BX\u0004¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006("}, d2 = {"ANY_SLASH", "Lokio/ByteString;", "BACKSLASH", "DOT", "DOT_DOT", "SLASH", "indexOfLastSlash", "", "Lokio/Path;", "getIndexOfLastSlash$annotations", "(Lokio/Path;)V", "getIndexOfLastSlash", "(Lokio/Path;)I", "commonCompareTo", "other", "commonEquals", "", "", "commonHashCode", "commonIsAbsolute", "commonIsRelative", "commonIsRoot", "commonName", "", "commonNameBytes", "commonParent", "commonResolve", "child", "commonToPath", "commonToString", "commonVolumeLetter", "", "(Lokio/Path;)Ljava/lang/Character;", "lastSegmentIsDotDot", "startsWithVolumeLetterAndColon", "Lokio/Buffer;", "slash", "toPath", "toSlash", "", "okio"}, k = 2, mv = {1, 4, 1})
/* compiled from: -Path.kt */
public final class _PathKt {
    private static final ByteString ANY_SLASH = ByteString.Companion.encodeUtf8("/\\");
    /* access modifiers changed from: private */
    public static final ByteString BACKSLASH = ByteString.Companion.encodeUtf8("\\");
    /* access modifiers changed from: private */
    public static final ByteString DOT = ByteString.Companion.encodeUtf8(".");
    private static final ByteString DOT_DOT = ByteString.Companion.encodeUtf8("..");
    /* access modifiers changed from: private */
    public static final ByteString SLASH = ByteString.Companion.encodeUtf8("/");

    private static /* synthetic */ void getIndexOfLastSlash$annotations(Path path) {
    }

    public static final boolean commonIsAbsolute(Path path) {
        Intrinsics.checkNotNullParameter(path, "$this$commonIsAbsolute");
        return path.getBytes$okio().startsWith(SLASH) || path.getBytes$okio().startsWith(BACKSLASH) || (path.volumeLetter() != null && path.getBytes$okio().size() > 2 && path.getBytes$okio().getByte(2) == ((byte) 92));
    }

    public static final boolean commonIsRelative(Path path) {
        Intrinsics.checkNotNullParameter(path, "$this$commonIsRelative");
        return !path.isAbsolute();
    }

    public static final Character commonVolumeLetter(Path path) {
        Intrinsics.checkNotNullParameter(path, "$this$commonVolumeLetter");
        if (ByteString.indexOf$default(path.getBytes$okio(), SLASH, 0, 2, (Object) null) != -1 || path.getBytes$okio().size() < 2 || path.getBytes$okio().getByte(1) != ((byte) 58)) {
            return null;
        }
        char c = (char) path.getBytes$okio().getByte(0);
        if (('a' > c || 'z' < c) && ('A' > c || 'Z' < c)) {
            return null;
        }
        return Character.valueOf(c);
    }

    /* access modifiers changed from: private */
    public static final int getIndexOfLastSlash(Path path) {
        int lastIndexOf$default = ByteString.lastIndexOf$default(path.getBytes$okio(), SLASH, 0, 2, (Object) null);
        if (lastIndexOf$default != -1) {
            return lastIndexOf$default;
        }
        return ByteString.lastIndexOf$default(path.getBytes$okio(), BACKSLASH, 0, 2, (Object) null);
    }

    public static final ByteString commonNameBytes(Path path) {
        Intrinsics.checkNotNullParameter(path, "$this$commonNameBytes");
        int access$getIndexOfLastSlash$p = getIndexOfLastSlash(path);
        if (access$getIndexOfLastSlash$p != -1) {
            return ByteString.substring$default(path.getBytes$okio(), access$getIndexOfLastSlash$p + 1, 0, 2, (Object) null);
        }
        if (path.volumeLetter() == null || path.getBytes$okio().size() != 2) {
            return path.getBytes$okio();
        }
        return ByteString.EMPTY;
    }

    public static final String commonName(Path path) {
        Intrinsics.checkNotNullParameter(path, "$this$commonName");
        return path.nameBytes().utf8();
    }

    public static final Path commonParent(Path path) {
        Intrinsics.checkNotNullParameter(path, "$this$commonParent");
        if (Intrinsics.areEqual(path.getBytes$okio(), DOT) || Intrinsics.areEqual(path.getBytes$okio(), SLASH) || Intrinsics.areEqual(path.getBytes$okio(), BACKSLASH) || lastSegmentIsDotDot(path)) {
            return null;
        }
        int access$getIndexOfLastSlash$p = getIndexOfLastSlash(path);
        if (access$getIndexOfLastSlash$p != 2 || path.volumeLetter() == null) {
            if (access$getIndexOfLastSlash$p == 1 && path.getBytes$okio().startsWith(BACKSLASH)) {
                return null;
            }
            if (access$getIndexOfLastSlash$p != -1 || path.volumeLetter() == null) {
                if (access$getIndexOfLastSlash$p == -1) {
                    return new Path(DOT);
                }
                if (access$getIndexOfLastSlash$p == 0) {
                    return new Path(ByteString.substring$default(path.getBytes$okio(), 0, 1, 1, (Object) null));
                }
                return new Path(ByteString.substring$default(path.getBytes$okio(), 0, access$getIndexOfLastSlash$p, 1, (Object) null));
            } else if (path.getBytes$okio().size() == 2) {
                return null;
            } else {
                return new Path(ByteString.substring$default(path.getBytes$okio(), 0, 2, 1, (Object) null));
            }
        } else if (path.getBytes$okio().size() == 3) {
            return null;
        } else {
            return new Path(ByteString.substring$default(path.getBytes$okio(), 0, 3, 1, (Object) null));
        }
    }

    /* access modifiers changed from: private */
    public static final boolean lastSegmentIsDotDot(Path path) {
        if (!path.getBytes$okio().endsWith(DOT_DOT) || (path.getBytes$okio().size() != 2 && !path.getBytes$okio().rangeEquals(path.getBytes$okio().size() - 3, SLASH, 0, 1) && !path.getBytes$okio().rangeEquals(path.getBytes$okio().size() - 3, BACKSLASH, 0, 1))) {
            return false;
        }
        return true;
    }

    public static final boolean commonIsRoot(Path path) {
        Intrinsics.checkNotNullParameter(path, "$this$commonIsRoot");
        return path.parent() == null && path.isAbsolute();
    }

    public static final Path commonResolve(Path path, String str) {
        Intrinsics.checkNotNullParameter(path, "$this$commonResolve");
        Intrinsics.checkNotNullParameter(str, "child");
        return path.resolve(toPath(new Buffer().writeUtf8(str)));
    }

    public static final Path commonResolve(Path path, Path path2) {
        ByteString byteString;
        Intrinsics.checkNotNullParameter(path, "$this$commonResolve");
        Intrinsics.checkNotNullParameter(path2, "child");
        if (path2.isAbsolute() || path2.volumeLetter() != null) {
            return path2;
        }
        if (ByteString.indexOf$default(path.getBytes$okio(), SLASH, 0, 2, (Object) null) != -1) {
            byteString = SLASH;
        } else if (ByteString.indexOf$default(path.getBytes$okio(), BACKSLASH, 0, 2, (Object) null) != -1) {
            byteString = BACKSLASH;
        } else if (ByteString.indexOf$default(path2.getBytes$okio(), SLASH, 0, 2, (Object) null) != -1) {
            byteString = SLASH;
        } else if (ByteString.indexOf$default(path2.getBytes$okio(), BACKSLASH, 0, 2, (Object) null) != -1) {
            byteString = BACKSLASH;
        } else {
            byteString = toSlash(Path.DIRECTORY_SEPARATOR);
        }
        Buffer buffer = new Buffer();
        buffer.write(path.getBytes$okio());
        if (buffer.size() > 0) {
            buffer.write(byteString);
        }
        buffer.write(path2.getBytes$okio());
        return toPath(buffer);
    }

    public static final int commonCompareTo(Path path, Path path2) {
        Intrinsics.checkNotNullParameter(path, "$this$commonCompareTo");
        Intrinsics.checkNotNullParameter(path2, "other");
        return path.getBytes$okio().compareTo(path2.getBytes$okio());
    }

    public static final boolean commonEquals(Path path, Object obj) {
        Intrinsics.checkNotNullParameter(path, "$this$commonEquals");
        return (obj instanceof Path) && Intrinsics.areEqual(((Path) obj).getBytes$okio(), path.getBytes$okio());
    }

    public static final int commonHashCode(Path path) {
        Intrinsics.checkNotNullParameter(path, "$this$commonHashCode");
        return path.getBytes$okio().hashCode();
    }

    public static final String commonToString(Path path) {
        Intrinsics.checkNotNullParameter(path, "$this$commonToString");
        return path.getBytes$okio().utf8();
    }

    public static final Path commonToPath(String str) {
        Intrinsics.checkNotNullParameter(str, "$this$commonToPath");
        return toPath(new Buffer().writeUtf8(str));
    }

    public static final Path toPath(Buffer buffer) {
        ByteString byteString;
        ByteString byteString2;
        Intrinsics.checkNotNullParameter(buffer, "$this$toPath");
        ByteString byteString3 = null;
        Buffer buffer2 = new Buffer();
        int i = 0;
        while (true) {
            if (!buffer.rangeEquals(0, SLASH)) {
                byteString = BACKSLASH;
                if (!buffer.rangeEquals(0, byteString)) {
                    break;
                }
            }
            byte readByte = buffer.readByte();
            if (byteString3 == null) {
                byteString3 = toSlash(readByte);
            }
            i++;
        }
        if (i >= 2 && Intrinsics.areEqual(byteString3, byteString)) {
            buffer2.write(byteString3);
            buffer2.write(byteString3);
        } else if (i > 0) {
            Intrinsics.checkNotNull(byteString3);
            buffer2.write(byteString3);
        } else {
            long indexOfElement = buffer.indexOfElement(ANY_SLASH);
            if (byteString3 == null) {
                if (indexOfElement == -1) {
                    byteString3 = toSlash(Path.DIRECTORY_SEPARATOR);
                } else {
                    byteString3 = toSlash(buffer.getByte(indexOfElement));
                }
            }
            if (startsWithVolumeLetterAndColon(buffer, byteString3)) {
                if (indexOfElement == 2) {
                    buffer2.write(buffer, 3);
                } else {
                    buffer2.write(buffer, 2);
                }
            }
        }
        boolean z = buffer2.size() > 0;
        List arrayList = new ArrayList();
        while (!buffer.exhausted()) {
            long indexOfElement2 = buffer.indexOfElement(ANY_SLASH);
            if (indexOfElement2 == -1) {
                byteString2 = buffer.readByteString();
            } else {
                byteString2 = buffer.readByteString(indexOfElement2);
                buffer.readByte();
            }
            ByteString byteString4 = DOT_DOT;
            if (Intrinsics.areEqual(byteString2, byteString4)) {
                if (z || (!arrayList.isEmpty() && !Intrinsics.areEqual((ByteString) CollectionsKt.last(arrayList), byteString4))) {
                    CollectionsKt.removeLastOrNull(arrayList);
                } else {
                    arrayList.add(byteString2);
                }
            } else if ((!Intrinsics.areEqual(byteString2, DOT)) && (!Intrinsics.areEqual(byteString2, ByteString.EMPTY))) {
                arrayList.add(byteString2);
            }
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 > 0) {
                buffer2.write(byteString3);
            }
            buffer2.write((ByteString) arrayList.get(i2));
        }
        if (buffer2.size() == 0) {
            buffer2.write(DOT);
        }
        return new Path(buffer2.readByteString());
    }

    /* access modifiers changed from: private */
    public static final ByteString toSlash(String str) {
        int hashCode = str.hashCode();
        if (hashCode != 47) {
            if (hashCode == 92 && str.equals("\\")) {
                return BACKSLASH;
            }
        } else if (str.equals("/")) {
            return SLASH;
        }
        throw new IllegalArgumentException("not a directory separator: " + str);
    }

    private static final ByteString toSlash(byte b) {
        if (b == 47) {
            return SLASH;
        }
        if (b == 92) {
            return BACKSLASH;
        }
        throw new IllegalArgumentException("not a directory separator: " + b);
    }

    private static final boolean startsWithVolumeLetterAndColon(Buffer buffer, ByteString byteString) {
        if ((!Intrinsics.areEqual(byteString, BACKSLASH)) || buffer.size() < ((long) 2) || buffer.getByte(1) != ((byte) 58)) {
            return false;
        }
        char c = (char) buffer.getByte(0);
        if ('a' <= c && 'z' >= c) {
            return true;
        }
        if ('A' <= c && 'Z' >= c) {
            return true;
        }
        return false;
    }
}
