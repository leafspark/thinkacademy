package com.tal.app.thinkacademy.common.logan;

import java.io.File;
import java.io.FilenameFilter;

public final /* synthetic */ class RealSendLogRunnable$$ExternalSyntheticLambda0 implements FilenameFilter {
    public final /* synthetic */ String f$0;

    public /* synthetic */ RealSendLogRunnable$$ExternalSyntheticLambda0(String str) {
        this.f$0 = str;
    }

    public final boolean accept(File file, String str) {
        return RealSendLogRunnable.m56deleteCurrentRtcLog$lambda9$lambda7(this.f$0, file, str);
    }
}
