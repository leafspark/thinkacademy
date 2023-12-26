package com.kwai.koom.javaoom.monitor;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/io/File;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: OOMFileManager.kt */
final class OOMFileManager$hprofAnalysisDir$2 extends Lambda implements Function0<File> {
    public static final OOMFileManager$hprofAnalysisDir$2 INSTANCE = new OOMFileManager$hprofAnalysisDir$2();

    OOMFileManager$hprofAnalysisDir$2() {
        super(0);
    }

    public final File invoke() {
        File file = new File(OOMFileManager.INSTANCE.getRootDir(), "memory/hprof-aly");
        file.mkdirs();
        return file;
    }
}
