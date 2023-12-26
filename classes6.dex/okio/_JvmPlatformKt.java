package okio;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okio.Path;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a-\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\f0\u0010H\bø\u0001\u0000¢\u0006\u0002\u0010\u0011\u001a\f\u0010\u0012\u001a\u00020\u0013*\u00020\u0014H\u0000\u001a\f\u0010\u0015\u001a\u00020\u0014*\u00020\u0013H\u0000\"\u001a\u0010\u0000\u001a\u00020\u00018@X\u0004¢\u0006\f\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u001a\u0010\u0006\u001a\u00020\u00078@X\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0003\u001a\u0004\b\t\u0010\n*\n\u0010\u0016\"\u00020\u00172\u00020\u0017*\n\u0010\u0018\"\u00020\u00192\u00020\u0019*\n\u0010\u001a\"\u00020\u001b2\u00020\u001b*\n\u0010\u001c\"\u00020\u001d2\u00020\u001d*\n\u0010\u001e\"\u00020\u001f2\u00020\u001f\u0002\u0007\n\u0005\b20\u0001¨\u0006 "}, d2 = {"PLATFORM_FILE_SYSTEM", "Lokio/FileSystem;", "getPLATFORM_FILE_SYSTEM$annotations", "()V", "getPLATFORM_FILE_SYSTEM", "()Lokio/FileSystem;", "PLATFORM_TEMPORARY_DIRECTORY", "Lokio/Path;", "getPLATFORM_TEMPORARY_DIRECTORY$annotations", "getPLATFORM_TEMPORARY_DIRECTORY", "()Lokio/Path;", "synchronized", "R", "lock", "", "block", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "asUtf8ToByteArray", "", "", "toUtf8String", "ArrayIndexOutOfBoundsException", "Ljava/lang/ArrayIndexOutOfBoundsException;", "Closeable", "Ljava/io/Closeable;", "EOFException", "Ljava/io/EOFException;", "FileNotFoundException", "Ljava/io/FileNotFoundException;", "IOException", "Ljava/io/IOException;", "okio"}, k = 2, mv = {1, 4, 1})
/* compiled from: -JvmPlatform.kt */
public final class _JvmPlatformKt {
    public static /* synthetic */ void getPLATFORM_FILE_SYSTEM$annotations() {
    }

    public static /* synthetic */ void getPLATFORM_TEMPORARY_DIRECTORY$annotations() {
    }

    public static final FileSystem getPLATFORM_FILE_SYSTEM() {
        try {
            Class.forName("java.nio.file.Files");
            return new NioSystemFileSystem();
        } catch (ClassNotFoundException unused) {
            return new JvmSystemFileSystem();
        }
    }

    public static final Path getPLATFORM_TEMPORARY_DIRECTORY() {
        Path.Companion companion = Path.Companion;
        String property = System.getProperty("java.io.tmpdir");
        Intrinsics.checkNotNullExpressionValue(property, "System.getProperty(\"java.io.tmpdir\")");
        return companion.get(property);
    }

    public static final String toUtf8String(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$toUtf8String");
        return new String(bArr, Charsets.UTF_8);
    }

    public static final byte[] asUtf8ToByteArray(String str) {
        Intrinsics.checkNotNullParameter(str, "$this$asUtf8ToByteArray");
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    /* renamed from: synchronized  reason: not valid java name */
    public static final <R> R m222synchronized(Object obj, Function0<? extends R> function0) {
        R invoke;
        Intrinsics.checkNotNullParameter(obj, "lock");
        Intrinsics.checkNotNullParameter(function0, "block");
        synchronized (obj) {
            try {
                invoke = function0.invoke();
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
        return invoke;
    }
}
