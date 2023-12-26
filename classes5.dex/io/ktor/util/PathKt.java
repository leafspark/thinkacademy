package io.ktor.util;

import java.io.File;
import kotlin.Metadata;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\f\n\u0002\b\u0004\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0007\u001a\f\u0010\u0004\u001a\u00020\u0001*\u00020\u0001H\u0002\u001a\f\u0010\b\u001a\u00020\t*\u00020\nH\u0002\u001a\f\u0010\u000b\u001a\u00020\t*\u00020\nH\u0002\u001a\n\u0010\f\u001a\u00020\u0001*\u00020\u0001\u001a\f\u0010\r\u001a\u00020\u0001*\u00020\u0001H\u0002¨\u0006\u000e"}, d2 = {"combineSafe", "Ljava/io/File;", "dir", "relativePath", "dropLeadingTopDirs", "", "path", "", "isPathSeparator", "", "", "isPathSeparatorOrDot", "normalizeAndRelativize", "notRooted", "ktor-utils"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Path.kt */
public final class PathKt {
    private static final boolean isPathSeparator(char c) {
        return c == '\\' || c == '/';
    }

    public static final File combineSafe(File file, String str) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(str, "relativePath");
        return combineSafe(file, new File(str));
    }

    public static final File normalizeAndRelativize(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        return dropLeadingTopDirs(notRooted(FilesKt.normalize(file)));
    }

    private static final File combineSafe(File file, File file2) {
        File normalizeAndRelativize = normalizeAndRelativize(file2);
        if (FilesKt.startsWith(normalizeAndRelativize, "..")) {
            throw new IllegalArgumentException("Bad relative path " + file2);
        } else if (!normalizeAndRelativize.isAbsolute()) {
            return new File(file, normalizeAndRelativize.getPath());
        } else {
            throw new IllegalStateException(("Bad relative path " + file2).toString());
        }
    }

    private static final File notRooted(File file) {
        String str;
        if (!FilesKt.isRooted(file)) {
            return file;
        }
        File file2 = file;
        while (true) {
            File parentFile = file2.getParentFile();
            if (parentFile == null) {
                break;
            }
            file2 = parentFile;
        }
        String path = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "path");
        String drop = StringsKt.drop(path, file2.getName().length());
        int length = drop.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                str = "";
                break;
            }
            char charAt = drop.charAt(i);
            if (!(charAt == '\\' || charAt == '/')) {
                str = drop.substring(i);
                Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).substring(startIndex)");
                break;
            }
            i++;
        }
        return new File(str);
    }

    public static final int dropLeadingTopDirs(String str) {
        Intrinsics.checkNotNullParameter(str, "path");
        int length = str.length() - 1;
        int i = 0;
        while (i <= length) {
            char charAt = str.charAt(i);
            if (isPathSeparator(charAt)) {
                i++;
            } else if (charAt != '.') {
                return i;
            } else {
                if (i == length) {
                    return i + 1;
                }
                char charAt2 = str.charAt(i + 1);
                if (isPathSeparator(charAt2)) {
                    i += 2;
                } else if (charAt2 != '.') {
                    return i;
                } else {
                    int i2 = i + 2;
                    if (i2 == str.length()) {
                        i = i2;
                    } else if (!isPathSeparator(str.charAt(i2))) {
                        return i;
                    } else {
                        i += 3;
                    }
                }
            }
        }
        return i;
    }

    private static final boolean isPathSeparatorOrDot(char c) {
        return c == '.' || isPathSeparator(c);
    }

    private static final File dropLeadingTopDirs(File file) {
        String path = file.getPath();
        if (path == null) {
            path = "";
        }
        int dropLeadingTopDirs = dropLeadingTopDirs(path);
        if (dropLeadingTopDirs == 0) {
            return file;
        }
        if (dropLeadingTopDirs >= file.getPath().length()) {
            return new File(".");
        }
        String path2 = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path2, "path");
        String substring = path2.substring(dropLeadingTopDirs);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        return new File(substring);
    }
}
