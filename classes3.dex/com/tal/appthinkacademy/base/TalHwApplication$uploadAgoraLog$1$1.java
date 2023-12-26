package com.tal.appthinkacademy.base;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Ljava/io/File;", "invoke", "(Ljava/io/File;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TalHwApplication.kt */
final class TalHwApplication$uploadAgoraLog$1$1 extends Lambda implements Function1<File, Boolean> {
    public static final TalHwApplication$uploadAgoraLog$1$1 INSTANCE = new TalHwApplication$uploadAgoraLog$1$1();

    TalHwApplication$uploadAgoraLog$1$1() {
        super(1);
    }

    public final Boolean invoke(File file) {
        Intrinsics.checkNotNullParameter(file, "it");
        return Boolean.valueOf(file.isFile());
    }
}
