package com.kwai.koom.javaoom.monitor;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/io/File;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: OOMFileManager.kt */
final class OOMFileManager$rootDir$2 extends Lambda implements Function0<File> {
    public static final OOMFileManager$rootDir$2 INSTANCE = new OOMFileManager$rootDir$2();

    OOMFileManager$rootDir$2() {
        super(0);
    }

    public final File invoke() {
        Function1 function1 = null;
        if (OOMFileManager.mRootDirInvoker != null) {
            Function1 access$getMRootDirInvoker$p = OOMFileManager.mRootDirInvoker;
            if (access$getMRootDirInvoker$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootDirInvoker");
            } else {
                function1 = access$getMRootDirInvoker$p;
            }
            return (File) function1.invoke("oom");
        }
        Function1 access$getMRootPath$p = OOMFileManager.mRootPath;
        if (access$getMRootPath$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootPath");
        } else {
            function1 = access$getMRootPath$p;
        }
        return new File(function1);
    }
}
