package com.kwai.koom.base;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "pathname", "Ljava/io/File;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 4, 1})
/* compiled from: Monitor_System.kt */
final class Monitor_SystemKt$getCpuCoreCount$1$1 implements FileFilter {
    public static final Monitor_SystemKt$getCpuCoreCount$1$1 INSTANCE = new Monitor_SystemKt$getCpuCoreCount$1$1();

    Monitor_SystemKt$getCpuCoreCount$1$1() {
    }

    public final boolean accept(File file) {
        Intrinsics.checkNotNullExpressionValue(file, "pathname");
        return Pattern.matches("cpu[0-9]+", file.getName());
    }
}
